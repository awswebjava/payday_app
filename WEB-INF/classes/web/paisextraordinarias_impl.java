package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class paisextraordinarias_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action19") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV27CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27CliCod), 6, 0));
         A2057PaiExtraordRelSec = (int)(GXutil.lval( httpContext.GetPar( "PaiExtraordRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2057PaiExtraordRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2057PaiExtraordRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_19_5F164( Gx_mode, AV27CliCod, A2057PaiExtraordRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"PAIEXTRAORDRELSEC") == 0 )
      {
         AV27CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlapaiextraordrelsec5F164( AV27CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel13"+"_"+"PAIEXTRAORDOLDDEFAULT") == 0 )
      {
         A1333PaiHsPDiaDia = (byte)(GXutil.lval( httpContext.GetPar( "PaiHsPDiaDia"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1333PaiHsPDiaDia", GXutil.str( A1333PaiHsPDiaDia, 1, 0));
         A1334PaiHsPDiaDesde = httpContext.GetPar( "PaiHsPDiaDesde") ;
         n1334PaiHsPDiaDesde = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1334PaiHsPDiaDesde", A1334PaiHsPDiaDesde);
         A1335PaiTarifaPDia = CommonUtil.decimalVal( httpContext.GetPar( "PaiTarifaPDia"), ".") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1335PaiTarifaPDia", GXutil.ltrimstr( A1335PaiTarifaPDia, 6, 4));
         A1348PaiTarifaPDRec = CommonUtil.decimalVal( httpContext.GetPar( "PaiTarifaPDRec"), ".") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1348PaiTarifaPDRec", GXutil.ltrimstr( A1348PaiTarifaPDRec, 6, 4));
         A2434PaiTarifaPDCri = httpContext.GetPar( "PaiTarifaPDCri") ;
         httpContext.ajax_rsp_assign_attri("", false, "A2434PaiTarifaPDCri", A2434PaiTarifaPDCri);
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A1331PaiHsPDiaTipTra = httpContext.GetPar( "PaiHsPDiaTipTra") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1331PaiHsPDiaTipTra", A1331PaiHsPDiaTipTra);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx13asapaiextraordolddefault5F164( A1333PaiHsPDiaDia, A1334PaiHsPDiaDesde, A1335PaiTarifaPDia, A1348PaiTarifaPDRec, A2434PaiTarifaPDCri, Gx_mode, A1331PaiHsPDiaTipTra) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_22") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1331PaiHsPDiaTipTra = httpContext.GetPar( "PaiHsPDiaTipTra") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1331PaiHsPDiaTipTra", A1331PaiHsPDiaTipTra);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_22( A46PaiCod, A1331PaiHsPDiaTipTra) ;
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
            AV7PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7PaiCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PaiCod), "ZZZ9")));
            AV8PaiHsExSec = (short)(GXutil.lval( httpContext.GetPar( "PaiHsExSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8PaiHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8PaiHsExSec), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAIHSEXSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8PaiHsExSec), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Pais Extraordinarias", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public paisextraordinarias_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public paisextraordinarias_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paisextraordinarias_impl.class ));
   }

   public paisextraordinarias_impl( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynPaiHsPDiaTipTra = new HTMLChoice();
      cmbPaiHsPDiaDia = new HTMLChoice();
      cmbPaiTarifaPDCri = new HTMLChoice();
      dynPaiExtraordRelSec = new HTMLChoice();
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
      if ( dynPaiHsPDiaTipTra.getItemCount() > 0 )
      {
         A1331PaiHsPDiaTipTra = dynPaiHsPDiaTipTra.getValidValue(A1331PaiHsPDiaTipTra) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1331PaiHsPDiaTipTra", A1331PaiHsPDiaTipTra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPaiHsPDiaTipTra.setValue( GXutil.rtrim( A1331PaiHsPDiaTipTra) );
         httpContext.ajax_rsp_assign_prop("", false, dynPaiHsPDiaTipTra.getInternalname(), "Values", dynPaiHsPDiaTipTra.ToJavascriptSource(), true);
      }
      if ( cmbPaiHsPDiaDia.getItemCount() > 0 )
      {
         A1333PaiHsPDiaDia = (byte)(GXutil.lval( cmbPaiHsPDiaDia.getValidValue(GXutil.trim( GXutil.str( A1333PaiHsPDiaDia, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1333PaiHsPDiaDia", GXutil.str( A1333PaiHsPDiaDia, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiHsPDiaDia.setValue( GXutil.trim( GXutil.str( A1333PaiHsPDiaDia, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiHsPDiaDia.getInternalname(), "Values", cmbPaiHsPDiaDia.ToJavascriptSource(), true);
      }
      if ( cmbPaiTarifaPDCri.getItemCount() > 0 )
      {
         A2434PaiTarifaPDCri = cmbPaiTarifaPDCri.getValidValue(A2434PaiTarifaPDCri) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2434PaiTarifaPDCri", A2434PaiTarifaPDCri);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiTarifaPDCri.setValue( GXutil.rtrim( A2434PaiTarifaPDCri) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiTarifaPDCri.getInternalname(), "Values", cmbPaiTarifaPDCri.ToJavascriptSource(), true);
      }
      if ( dynPaiExtraordRelSec.getItemCount() > 0 )
      {
         A2057PaiExtraordRelSec = (int)(GXutil.lval( dynPaiExtraordRelSec.getValidValue(GXutil.trim( GXutil.str( A2057PaiExtraordRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2057PaiExtraordRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2057PaiExtraordRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPaiExtraordRelSec.setValue( GXutil.trim( GXutil.str( A2057PaiExtraordRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynPaiExtraordRelSec.getInternalname(), "Values", dynPaiExtraordRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiCod_Internalname, httpContext.getMessage( "Pais", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_PaisExtraordinarias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiHsExSec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiHsExSec_Internalname, httpContext.getMessage( "Secuencial", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiHsExSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1332PaiHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1332PaiHsExSec), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiHsExSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiHsExSec_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisExtraordinarias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynPaiHsPDiaTipTra.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynPaiHsPDiaTipTra.getInternalname(), httpContext.getMessage( "Tipo de trabajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynPaiHsPDiaTipTra, dynPaiHsPDiaTipTra.getInternalname(), GXutil.rtrim( A1331PaiHsPDiaTipTra), 1, dynPaiHsPDiaTipTra.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynPaiHsPDiaTipTra.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_PaisExtraordinarias.htm");
      dynPaiHsPDiaTipTra.setValue( GXutil.rtrim( A1331PaiHsPDiaTipTra) );
      httpContext.ajax_rsp_assign_prop("", false, dynPaiHsPDiaTipTra.getInternalname(), "Values", dynPaiHsPDiaTipTra.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPaiHsPDiaDia.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbPaiHsPDiaDia.getInternalname(), httpContext.getMessage( "Día", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiHsPDiaDia, cmbPaiHsPDiaDia.getInternalname(), GXutil.trim( GXutil.str( A1333PaiHsPDiaDia, 1, 0)), 1, cmbPaiHsPDiaDia.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbPaiHsPDiaDia.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "", true, (byte)(0), "HLP_PaisExtraordinarias.htm");
      cmbPaiHsPDiaDia.setValue( GXutil.trim( GXutil.str( A1333PaiHsPDiaDia, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiHsPDiaDia.getInternalname(), "Values", cmbPaiHsPDiaDia.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiHsPDiaDesde_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiHsPDiaDesde_Internalname, httpContext.getMessage( "Hora desde", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiHsPDiaDesde_Internalname, GXutil.rtrim( A1334PaiHsPDiaDesde), GXutil.rtrim( localUtil.format( A1334PaiHsPDiaDesde, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiHsPDiaDesde_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiHsPDiaDesde_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PaisExtraordinarias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiTarifaPDia_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiTarifaPDia_Internalname, httpContext.getMessage( "Aumento de horas extras sobre hora normal", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiTarifaPDia_Internalname, GXutil.ltrim( localUtil.ntoc( A1335PaiTarifaPDia, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiTarifaPDia_Enabled!=0) ? localUtil.format( A1335PaiTarifaPDia, "9.9999") : localUtil.format( A1335PaiTarifaPDia, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiTarifaPDia_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiTarifaPDia_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_PaisExtraordinarias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiTarifaPDRec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiTarifaPDRec_Internalname, httpContext.getMessage( "Recargo a hora normal diurna", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiTarifaPDRec_Internalname, GXutil.ltrim( localUtil.ntoc( A1348PaiTarifaPDRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiTarifaPDRec_Enabled!=0) ? localUtil.format( A1348PaiTarifaPDRec, "9.9999") : localUtil.format( A1348PaiTarifaPDRec, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiTarifaPDRec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiTarifaPDRec_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_PaisExtraordinarias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPaiTarifaPDCri.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbPaiTarifaPDCri.getInternalname(), httpContext.getMessage( "Criterio", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiTarifaPDCri, cmbPaiTarifaPDCri.getInternalname(), GXutil.rtrim( A2434PaiTarifaPDCri), 1, cmbPaiTarifaPDCri.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPaiTarifaPDCri.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,57);\"", "", true, (byte)(0), "HLP_PaisExtraordinarias.htm");
      cmbPaiTarifaPDCri.setValue( GXutil.rtrim( A2434PaiTarifaPDCri) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiTarifaPDCri.getInternalname(), "Values", cmbPaiTarifaPDCri.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divPaiextraordrelsec_cell_Internalname, 1, 0, "px", 0, "px", divPaiextraordrelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynPaiExtraordRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynPaiExtraordRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynPaiExtraordRelSec, dynPaiExtraordRelSec.getInternalname(), GXutil.trim( GXutil.str( A2057PaiExtraordRelSec, 6, 0)), 1, dynPaiExtraordRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynPaiExtraordRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,62);\"", "", true, (byte)(0), "HLP_PaisExtraordinarias.htm");
      dynPaiExtraordRelSec.setValue( GXutil.trim( GXutil.str( A2057PaiExtraordRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynPaiExtraordRelSec.getInternalname(), "Values", dynPaiExtraordRelSec.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PaisExtraordinarias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PaisExtraordinarias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PaisExtraordinarias.htm");
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
      e115F2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1332PaiHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z1332PaiHsExSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1333PaiHsPDiaDia = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1333PaiHsPDiaDia"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1334PaiHsPDiaDesde = httpContext.cgiGet( "Z1334PaiHsPDiaDesde") ;
            n1334PaiHsPDiaDesde = ((GXutil.strcmp("", A1334PaiHsPDiaDesde)==0) ? true : false) ;
            Z1335PaiTarifaPDia = localUtil.ctond( httpContext.cgiGet( "Z1335PaiTarifaPDia")) ;
            Z1348PaiTarifaPDRec = localUtil.ctond( httpContext.cgiGet( "Z1348PaiTarifaPDRec")) ;
            Z2434PaiTarifaPDCri = httpContext.cgiGet( "Z2434PaiTarifaPDCri") ;
            Z2057PaiExtraordRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z2057PaiExtraordRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2058PaiExtraordRelRef = httpContext.cgiGet( "Z2058PaiExtraordRelRef") ;
            Z1331PaiHsPDiaTipTra = httpContext.cgiGet( "Z1331PaiHsPDiaTipTra") ;
            A2058PaiExtraordRelRef = httpContext.cgiGet( "Z2058PaiExtraordRelRef") ;
            O2434PaiTarifaPDCri = httpContext.cgiGet( "O2434PaiTarifaPDCri") ;
            O1348PaiTarifaPDRec = localUtil.ctond( httpContext.cgiGet( "O1348PaiTarifaPDRec")) ;
            O1335PaiTarifaPDia = localUtil.ctond( httpContext.cgiGet( "O1335PaiTarifaPDia")) ;
            O1334PaiHsPDiaDesde = httpContext.cgiGet( "O1334PaiHsPDiaDesde") ;
            n1334PaiHsPDiaDesde = ((GXutil.strcmp("", A1334PaiHsPDiaDesde)==0) ? true : false) ;
            O1333PaiHsPDiaDia = (byte)(localUtil.ctol( httpContext.cgiGet( "O1333PaiHsPDiaDia"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1331PaiHsPDiaTipTra = httpContext.cgiGet( "O1331PaiHsPDiaTipTra") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1331PaiHsPDiaTipTra = httpContext.cgiGet( "N1331PaiHsPDiaTipTra") ;
            AV7PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8PaiHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( "vPAIHSEXSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV14Insert_PaiHsPDiaTipTra = httpContext.cgiGet( "vINSERT_PAIHSPDIATIPTRA") ;
            A1977PaiExtraordOldDefault = httpContext.cgiGet( "PAIEXTRAORDOLDDEFAULT") ;
            AV27CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV26aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A2058PaiExtraordRelRef = httpContext.cgiGet( "PAIEXTRAORDRELREF") ;
            A2071PaiExtraordOld = httpContext.cgiGet( "PAIEXTRAORDOLD") ;
            AV29Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A46PaiCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            }
            else
            {
               A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiHsExSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiHsExSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAIHSEXSEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiHsExSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1332PaiHsExSec = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1332PaiHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1332PaiHsExSec), 4, 0));
            }
            else
            {
               A1332PaiHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiHsExSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1332PaiHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1332PaiHsExSec), 4, 0));
            }
            dynPaiHsPDiaTipTra.setValue( httpContext.cgiGet( dynPaiHsPDiaTipTra.getInternalname()) );
            A1331PaiHsPDiaTipTra = httpContext.cgiGet( dynPaiHsPDiaTipTra.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1331PaiHsPDiaTipTra", A1331PaiHsPDiaTipTra);
            cmbPaiHsPDiaDia.setValue( httpContext.cgiGet( cmbPaiHsPDiaDia.getInternalname()) );
            A1333PaiHsPDiaDia = (byte)(GXutil.lval( httpContext.cgiGet( cmbPaiHsPDiaDia.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1333PaiHsPDiaDia", GXutil.str( A1333PaiHsPDiaDia, 1, 0));
            A1334PaiHsPDiaDesde = httpContext.cgiGet( edtPaiHsPDiaDesde_Internalname) ;
            n1334PaiHsPDiaDesde = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1334PaiHsPDiaDesde", A1334PaiHsPDiaDesde);
            n1334PaiHsPDiaDesde = ((GXutil.strcmp("", A1334PaiHsPDiaDesde)==0) ? true : false) ;
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtPaiTarifaPDia_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtPaiTarifaPDia_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAITARIFAPDIA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiTarifaPDia_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1335PaiTarifaPDia = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1335PaiTarifaPDia", GXutil.ltrimstr( A1335PaiTarifaPDia, 6, 4));
            }
            else
            {
               A1335PaiTarifaPDia = localUtil.ctond( httpContext.cgiGet( edtPaiTarifaPDia_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1335PaiTarifaPDia", GXutil.ltrimstr( A1335PaiTarifaPDia, 6, 4));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtPaiTarifaPDRec_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtPaiTarifaPDRec_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAITARIFAPDREC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiTarifaPDRec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1348PaiTarifaPDRec = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1348PaiTarifaPDRec", GXutil.ltrimstr( A1348PaiTarifaPDRec, 6, 4));
            }
            else
            {
               A1348PaiTarifaPDRec = localUtil.ctond( httpContext.cgiGet( edtPaiTarifaPDRec_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1348PaiTarifaPDRec", GXutil.ltrimstr( A1348PaiTarifaPDRec, 6, 4));
            }
            cmbPaiTarifaPDCri.setValue( httpContext.cgiGet( cmbPaiTarifaPDCri.getInternalname()) );
            A2434PaiTarifaPDCri = httpContext.cgiGet( cmbPaiTarifaPDCri.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2434PaiTarifaPDCri", A2434PaiTarifaPDCri);
            dynPaiExtraordRelSec.setValue( httpContext.cgiGet( dynPaiExtraordRelSec.getInternalname()) );
            A2057PaiExtraordRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynPaiExtraordRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2057PaiExtraordRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2057PaiExtraordRelSec), 6, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"PaisExtraordinarias");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("PaiExtraordRelRef", GXutil.rtrim( localUtil.format( A2058PaiExtraordRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A46PaiCod != Z46PaiCod ) || ( A1332PaiHsExSec != Z1332PaiHsExSec ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("paisextraordinarias:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A1332PaiHsExSec = (short)(GXutil.lval( httpContext.GetPar( "PaiHsExSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1332PaiHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1332PaiHsExSec), 4, 0));
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
                  sMode164 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode164 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound164 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_5F0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "PAICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPaiCod_Internalname ;
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
                        e115F2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e125F2 ();
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
         e125F2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll5F164( ) ;
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
         disableAttributes5F164( ) ;
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

   public void confirm_5F0( )
   {
      beforeValidate5F164( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls5F164( ) ;
         }
         else
         {
            checkExtendedTable5F164( ) ;
            closeExtendedTableCursors5F164( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption5F0( )
   {
   }

   public void e115F2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV27CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      paisextraordinarias_impl.this.GXt_int1 = GXv_int2[0] ;
      AV27CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27CliCod), 6, 0));
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext3[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV9WWPContext = GXv_SdtWWPContext3[0] ;
      AV10IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisExtraordinarias_Insert", GXv_boolean5) ;
         paisextraordinarias_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisExtraordinarias_Update", GXv_boolean5) ;
         paisextraordinarias_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisExtraordinarias_Delete", GXv_boolean5) ;
         paisextraordinarias_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV29Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV12TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV29Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV30GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30GXV1), 8, 0));
         while ( AV30GXV1 <= AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV15TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV30GXV1));
            if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PaiHsPDiaTipTra") == 0 )
            {
               AV14Insert_PaiHsPDiaTipTra = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14Insert_PaiHsPDiaTipTra", AV14Insert_PaiHsPDiaTipTra);
            }
            AV30GXV1 = (int)(AV30GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30GXV1), 8, 0));
         }
      }
   }

   public void e125F2( )
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

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      divPaiextraordrelsec_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divPaiextraordrelsec_cell_Internalname, "Class", divPaiextraordrelsec_cell_Class, true);
   }

   public void zm5F164( int GX_JID )
   {
      if ( ( GX_JID == 21 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1333PaiHsPDiaDia = T005F3_A1333PaiHsPDiaDia[0] ;
            Z1334PaiHsPDiaDesde = T005F3_A1334PaiHsPDiaDesde[0] ;
            Z1335PaiTarifaPDia = T005F3_A1335PaiTarifaPDia[0] ;
            Z1348PaiTarifaPDRec = T005F3_A1348PaiTarifaPDRec[0] ;
            Z2434PaiTarifaPDCri = T005F3_A2434PaiTarifaPDCri[0] ;
            Z2057PaiExtraordRelSec = T005F3_A2057PaiExtraordRelSec[0] ;
            Z2058PaiExtraordRelRef = T005F3_A2058PaiExtraordRelRef[0] ;
            Z1331PaiHsPDiaTipTra = T005F3_A1331PaiHsPDiaTipTra[0] ;
         }
         else
         {
            Z1333PaiHsPDiaDia = A1333PaiHsPDiaDia ;
            Z1334PaiHsPDiaDesde = A1334PaiHsPDiaDesde ;
            Z1335PaiTarifaPDia = A1335PaiTarifaPDia ;
            Z1348PaiTarifaPDRec = A1348PaiTarifaPDRec ;
            Z2434PaiTarifaPDCri = A2434PaiTarifaPDCri ;
            Z2057PaiExtraordRelSec = A2057PaiExtraordRelSec ;
            Z2058PaiExtraordRelRef = A2058PaiExtraordRelRef ;
            Z1331PaiHsPDiaTipTra = A1331PaiHsPDiaTipTra ;
         }
      }
      if ( GX_JID == -21 )
      {
         Z1332PaiHsExSec = A1332PaiHsExSec ;
         Z1977PaiExtraordOldDefault = A1977PaiExtraordOldDefault ;
         Z1333PaiHsPDiaDia = A1333PaiHsPDiaDia ;
         Z1334PaiHsPDiaDesde = A1334PaiHsPDiaDesde ;
         Z1335PaiTarifaPDia = A1335PaiTarifaPDia ;
         Z1348PaiTarifaPDRec = A1348PaiTarifaPDRec ;
         Z2434PaiTarifaPDCri = A2434PaiTarifaPDCri ;
         Z2057PaiExtraordRelSec = A2057PaiExtraordRelSec ;
         Z2058PaiExtraordRelRef = A2058PaiExtraordRelRef ;
         Z2071PaiExtraordOld = A2071PaiExtraordOld ;
         Z46PaiCod = A46PaiCod ;
         Z1331PaiHsPDiaTipTra = A1331PaiHsPDiaTipTra ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7PaiCod) )
      {
         A46PaiCod = AV7PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      if ( ! (0==AV7PaiCod) )
      {
         edtPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      else
      {
         edtPaiCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7PaiCod) )
      {
         edtPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8PaiHsExSec) )
      {
         A1332PaiHsExSec = AV8PaiHsExSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1332PaiHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1332PaiHsExSec), 4, 0));
      }
      if ( ! (0==AV8PaiHsExSec) )
      {
         edtPaiHsExSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiHsExSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiHsExSec_Enabled), 5, 0), true);
      }
      else
      {
         edtPaiHsExSec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiHsExSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiHsExSec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8PaiHsExSec) )
      {
         edtPaiHsExSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiHsExSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiHsExSec_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV14Insert_PaiHsPDiaTipTra)==0) )
      {
         dynPaiHsPDiaTipTra.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynPaiHsPDiaTipTra.getInternalname(), "Enabled", GXutil.ltrimstr( dynPaiHsPDiaTipTra.getEnabled(), 5, 0), true);
      }
      else
      {
         dynPaiHsPDiaTipTra.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynPaiHsPDiaTipTra.getInternalname(), "Enabled", GXutil.ltrimstr( dynPaiHsPDiaTipTra.getEnabled(), 5, 0), true);
      }
      gxapaiextraordrelsec_html5F164( AV27CliCod) ;
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV14Insert_PaiHsPDiaTipTra)==0) )
      {
         A1331PaiHsPDiaTipTra = AV14Insert_PaiHsPDiaTipTra ;
         httpContext.ajax_rsp_assign_attri("", false, "A1331PaiHsPDiaTipTra", A1331PaiHsPDiaTipTra);
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
         AV29Pgmname = "PaisExtraordinarias" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29Pgmname", AV29Pgmname);
      }
   }

   public void load5F164( )
   {
      /* Using cursor T005F5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound164 = (short)(1) ;
         A1977PaiExtraordOldDefault = T005F5_A1977PaiExtraordOldDefault[0] ;
         A1333PaiHsPDiaDia = T005F5_A1333PaiHsPDiaDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1333PaiHsPDiaDia", GXutil.str( A1333PaiHsPDiaDia, 1, 0));
         A1334PaiHsPDiaDesde = T005F5_A1334PaiHsPDiaDesde[0] ;
         n1334PaiHsPDiaDesde = T005F5_n1334PaiHsPDiaDesde[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1334PaiHsPDiaDesde", A1334PaiHsPDiaDesde);
         A1335PaiTarifaPDia = T005F5_A1335PaiTarifaPDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1335PaiTarifaPDia", GXutil.ltrimstr( A1335PaiTarifaPDia, 6, 4));
         A1348PaiTarifaPDRec = T005F5_A1348PaiTarifaPDRec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1348PaiTarifaPDRec", GXutil.ltrimstr( A1348PaiTarifaPDRec, 6, 4));
         A2434PaiTarifaPDCri = T005F5_A2434PaiTarifaPDCri[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2434PaiTarifaPDCri", A2434PaiTarifaPDCri);
         A2057PaiExtraordRelSec = T005F5_A2057PaiExtraordRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2057PaiExtraordRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2057PaiExtraordRelSec), 6, 0));
         A2058PaiExtraordRelRef = T005F5_A2058PaiExtraordRelRef[0] ;
         A2071PaiExtraordOld = T005F5_A2071PaiExtraordOld[0] ;
         A1331PaiHsPDiaTipTra = T005F5_A1331PaiHsPDiaTipTra[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1331PaiHsPDiaTipTra", A1331PaiHsPDiaTipTra);
         zm5F164( -21) ;
      }
      pr_default.close(3);
      onLoadActions5F164( ) ;
   }

   public void onLoadActions5F164( )
   {
      AV29Pgmname = "PaisExtraordinarias" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29Pgmname", AV29Pgmname);
      if ( ! ( ( GXutil.strcmp(A1331PaiHsPDiaTipTra, O1331PaiHsPDiaTipTra) != 0 ) || ( A1333PaiHsPDiaDia != O1333PaiHsPDiaDia ) || ( GXutil.strcmp(A1334PaiHsPDiaDesde, O1334PaiHsPDiaDesde) != 0 ) || ( DecimalUtil.compareTo(A1335PaiTarifaPDia, O1335PaiTarifaPDia) != 0 ) || ( DecimalUtil.compareTo(A1348PaiTarifaPDRec, O1348PaiTarifaPDRec) != 0 ) ) )
      {
         divPaiextraordrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPaiextraordrelsec_cell_Internalname, "Class", divPaiextraordrelsec_cell_Class, true);
      }
      else
      {
         if ( ( GXutil.strcmp(A1331PaiHsPDiaTipTra, O1331PaiHsPDiaTipTra) != 0 ) || ( A1333PaiHsPDiaDia != O1333PaiHsPDiaDia ) || ( GXutil.strcmp(A1334PaiHsPDiaDesde, O1334PaiHsPDiaDesde) != 0 ) || ( DecimalUtil.compareTo(A1335PaiTarifaPDia, O1335PaiTarifaPDia) != 0 ) || ( DecimalUtil.compareTo(A1348PaiTarifaPDRec, O1348PaiTarifaPDRec) != 0 ) )
         {
            divPaiextraordrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPaiextraordrelsec_cell_Internalname, "Class", divPaiextraordrelsec_cell_Class, true);
         }
      }
      if ( isUpd( )  )
      {
         GXt_char6 = A1977PaiExtraordOldDefault ;
         GXv_char7[0] = GXt_char6 ;
         new web.paisextraordinariassetolddef(remoteHandle, context).execute( O1331PaiHsPDiaTipTra, O1333PaiHsPDiaDia, O1334PaiHsPDiaDesde, O1335PaiTarifaPDia, O1348PaiTarifaPDRec, O2434PaiTarifaPDCri, GXv_char7) ;
         paisextraordinarias_impl.this.GXt_char6 = GXv_char7[0] ;
         A1977PaiExtraordOldDefault = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1977PaiExtraordOldDefault", A1977PaiExtraordOldDefault);
      }
   }

   public void checkExtendedTable5F164( )
   {
      nIsDirty_164 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV29Pgmname = "PaisExtraordinarias" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29Pgmname", AV29Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV26aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV27CliCod, A2057PaiExtraordRelSec, GXv_boolean5) ;
         paisextraordinarias_impl.this.AV26aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26aplicadoHay", AV26aplicadoHay);
      }
      /* Using cursor T005F4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod), A1331PaiHsPDiaTipTra});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Horas Extras Pais Tipo Tra", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAIHSPDIATIPTRA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( GXutil.strcmp(A1331PaiHsPDiaTipTra, "diurno") == 0 ) || ( GXutil.strcmp(A1331PaiHsPDiaTipTra, "nocturno") == 0 ) || ( GXutil.strcmp(A1331PaiHsPDiaTipTra, "insalubre") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de trabajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PAIHSPDIATIPTRA");
         AnyError = (short)(1) ;
         GX_FocusControl = dynPaiHsPDiaTipTra.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A1331PaiHsPDiaTipTra, O1331PaiHsPDiaTipTra) != 0 ) || ( A1333PaiHsPDiaDia != O1333PaiHsPDiaDia ) || ( GXutil.strcmp(A1334PaiHsPDiaDesde, O1334PaiHsPDiaDesde) != 0 ) || ( DecimalUtil.compareTo(A1335PaiTarifaPDia, O1335PaiTarifaPDia) != 0 ) || ( DecimalUtil.compareTo(A1348PaiTarifaPDRec, O1348PaiTarifaPDRec) != 0 ) ) )
      {
         divPaiextraordrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPaiextraordrelsec_cell_Internalname, "Class", divPaiextraordrelsec_cell_Class, true);
      }
      else
      {
         if ( ( GXutil.strcmp(A1331PaiHsPDiaTipTra, O1331PaiHsPDiaTipTra) != 0 ) || ( A1333PaiHsPDiaDia != O1333PaiHsPDiaDia ) || ( GXutil.strcmp(A1334PaiHsPDiaDesde, O1334PaiHsPDiaDesde) != 0 ) || ( DecimalUtil.compareTo(A1335PaiTarifaPDia, O1335PaiTarifaPDia) != 0 ) || ( DecimalUtil.compareTo(A1348PaiTarifaPDRec, O1348PaiTarifaPDRec) != 0 ) )
         {
            divPaiextraordrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPaiextraordrelsec_cell_Internalname, "Class", divPaiextraordrelsec_cell_Class, true);
         }
      }
      if ( isUpd( )  )
      {
         nIsDirty_164 = (short)(1) ;
         GXt_char6 = A1977PaiExtraordOldDefault ;
         GXv_char7[0] = GXt_char6 ;
         new web.paisextraordinariassetolddef(remoteHandle, context).execute( O1331PaiHsPDiaTipTra, O1333PaiHsPDiaDia, O1334PaiHsPDiaDesde, O1335PaiTarifaPDia, O1348PaiTarifaPDRec, O2434PaiTarifaPDCri, GXv_char7) ;
         paisextraordinarias_impl.this.GXt_char6 = GXv_char7[0] ;
         A1977PaiExtraordOldDefault = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1977PaiExtraordOldDefault", A1977PaiExtraordOldDefault);
      }
      if ( ( ( GXutil.strcmp(A1331PaiHsPDiaTipTra, O1331PaiHsPDiaTipTra) != 0 ) || ( A1333PaiHsPDiaDia != O1333PaiHsPDiaDia ) || ( GXutil.strcmp(A1334PaiHsPDiaDesde, O1334PaiHsPDiaDesde) != 0 ) || ( DecimalUtil.compareTo(A1335PaiTarifaPDia, O1335PaiTarifaPDia) != 0 ) || ( DecimalUtil.compareTo(A1348PaiTarifaPDRec, O1348PaiTarifaPDRec) != 0 ) ) && (0==A2057PaiExtraordRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "PAIHSPDIATIPTRA");
         AnyError = (short)(1) ;
         GX_FocusControl = dynPaiHsPDiaTipTra.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A1333PaiHsPDiaDia == 1 ) || ( A1333PaiHsPDiaDia == 2 ) || ( A1333PaiHsPDiaDia == 3 ) || ( A1333PaiHsPDiaDia == 4 ) || ( A1333PaiHsPDiaDia == 5 ) || ( A1333PaiHsPDiaDia == 6 ) || ( A1333PaiHsPDiaDia == 7 ) || ( A1333PaiHsPDiaDia == 8 ) || ( A1333PaiHsPDiaDia == 9 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Día", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PAIHSPDIADIA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPaiHsPDiaDia.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A2434PaiTarifaPDCri, "exceso") == 0 ) || ( GXutil.strcmp(A2434PaiTarifaPDCri, "horario") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Criterio de aplicación", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PAITARIFAPDCRI");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPaiTarifaPDCri.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors5F164( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_22( short A46PaiCod ,
                          String A1331PaiHsPDiaTipTra )
   {
      /* Using cursor T005F6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A46PaiCod), A1331PaiHsPDiaTipTra});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Horas Extras Pais Tipo Tra", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAIHSPDIATIPTRA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
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

   public void getKey5F164( )
   {
      /* Using cursor T005F7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound164 = (short)(1) ;
      }
      else
      {
         RcdFound164 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T005F3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm5F164( 21) ;
         RcdFound164 = (short)(1) ;
         A1332PaiHsExSec = T005F3_A1332PaiHsExSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1332PaiHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1332PaiHsExSec), 4, 0));
         A1977PaiExtraordOldDefault = T005F3_A1977PaiExtraordOldDefault[0] ;
         A1333PaiHsPDiaDia = T005F3_A1333PaiHsPDiaDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1333PaiHsPDiaDia", GXutil.str( A1333PaiHsPDiaDia, 1, 0));
         A1334PaiHsPDiaDesde = T005F3_A1334PaiHsPDiaDesde[0] ;
         n1334PaiHsPDiaDesde = T005F3_n1334PaiHsPDiaDesde[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1334PaiHsPDiaDesde", A1334PaiHsPDiaDesde);
         A1335PaiTarifaPDia = T005F3_A1335PaiTarifaPDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1335PaiTarifaPDia", GXutil.ltrimstr( A1335PaiTarifaPDia, 6, 4));
         A1348PaiTarifaPDRec = T005F3_A1348PaiTarifaPDRec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1348PaiTarifaPDRec", GXutil.ltrimstr( A1348PaiTarifaPDRec, 6, 4));
         A2434PaiTarifaPDCri = T005F3_A2434PaiTarifaPDCri[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2434PaiTarifaPDCri", A2434PaiTarifaPDCri);
         A2057PaiExtraordRelSec = T005F3_A2057PaiExtraordRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2057PaiExtraordRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2057PaiExtraordRelSec), 6, 0));
         A2058PaiExtraordRelRef = T005F3_A2058PaiExtraordRelRef[0] ;
         A2071PaiExtraordOld = T005F3_A2071PaiExtraordOld[0] ;
         A46PaiCod = T005F3_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1331PaiHsPDiaTipTra = T005F3_A1331PaiHsPDiaTipTra[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1331PaiHsPDiaTipTra", A1331PaiHsPDiaTipTra);
         O2434PaiTarifaPDCri = A2434PaiTarifaPDCri ;
         httpContext.ajax_rsp_assign_attri("", false, "A2434PaiTarifaPDCri", A2434PaiTarifaPDCri);
         O1348PaiTarifaPDRec = A1348PaiTarifaPDRec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1348PaiTarifaPDRec", GXutil.ltrimstr( A1348PaiTarifaPDRec, 6, 4));
         O1335PaiTarifaPDia = A1335PaiTarifaPDia ;
         httpContext.ajax_rsp_assign_attri("", false, "A1335PaiTarifaPDia", GXutil.ltrimstr( A1335PaiTarifaPDia, 6, 4));
         O1334PaiHsPDiaDesde = A1334PaiHsPDiaDesde ;
         n1334PaiHsPDiaDesde = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1334PaiHsPDiaDesde", A1334PaiHsPDiaDesde);
         O1333PaiHsPDiaDia = A1333PaiHsPDiaDia ;
         httpContext.ajax_rsp_assign_attri("", false, "A1333PaiHsPDiaDia", GXutil.str( A1333PaiHsPDiaDia, 1, 0));
         O1331PaiHsPDiaTipTra = A1331PaiHsPDiaTipTra ;
         httpContext.ajax_rsp_assign_attri("", false, "A1331PaiHsPDiaTipTra", A1331PaiHsPDiaTipTra);
         Z46PaiCod = A46PaiCod ;
         Z1332PaiHsExSec = A1332PaiHsExSec ;
         sMode164 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load5F164( ) ;
         if ( AnyError == 1 )
         {
            RcdFound164 = (short)(0) ;
            initializeNonKey5F164( ) ;
         }
         Gx_mode = sMode164 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound164 = (short)(0) ;
         initializeNonKey5F164( ) ;
         sMode164 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode164 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey5F164( ) ;
      if ( RcdFound164 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound164 = (short)(0) ;
      /* Using cursor T005F8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T005F8_A46PaiCod[0] < A46PaiCod ) || ( T005F8_A46PaiCod[0] == A46PaiCod ) && ( T005F8_A1332PaiHsExSec[0] < A1332PaiHsExSec ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T005F8_A46PaiCod[0] > A46PaiCod ) || ( T005F8_A46PaiCod[0] == A46PaiCod ) && ( T005F8_A1332PaiHsExSec[0] > A1332PaiHsExSec ) ) )
         {
            A46PaiCod = T005F8_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A1332PaiHsExSec = T005F8_A1332PaiHsExSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1332PaiHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1332PaiHsExSec), 4, 0));
            RcdFound164 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound164 = (short)(0) ;
      /* Using cursor T005F9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T005F9_A46PaiCod[0] > A46PaiCod ) || ( T005F9_A46PaiCod[0] == A46PaiCod ) && ( T005F9_A1332PaiHsExSec[0] > A1332PaiHsExSec ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T005F9_A46PaiCod[0] < A46PaiCod ) || ( T005F9_A46PaiCod[0] == A46PaiCod ) && ( T005F9_A1332PaiHsExSec[0] < A1332PaiHsExSec ) ) )
         {
            A46PaiCod = T005F9_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A1332PaiHsExSec = T005F9_A1332PaiHsExSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1332PaiHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1332PaiHsExSec), 4, 0));
            RcdFound164 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey5F164( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert5F164( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound164 == 1 )
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( A1332PaiHsExSec != Z1332PaiHsExSec ) )
            {
               A46PaiCod = Z46PaiCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A1332PaiHsExSec = Z1332PaiHsExSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A1332PaiHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1332PaiHsExSec), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update5F164( ) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( A1332PaiHsExSec != Z1332PaiHsExSec ) )
            {
               /* Insert record */
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert5F164( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PAICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPaiCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtPaiCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert5F164( ) ;
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
      if ( ( A46PaiCod != Z46PaiCod ) || ( A1332PaiHsExSec != Z1332PaiHsExSec ) )
      {
         A46PaiCod = Z46PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1332PaiHsExSec = Z1332PaiHsExSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1332PaiHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1332PaiHsExSec), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency5F164( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T005F2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paishorasextras_pordia"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z1333PaiHsPDiaDia != T005F2_A1333PaiHsPDiaDia[0] ) || ( GXutil.strcmp(Z1334PaiHsPDiaDesde, T005F2_A1334PaiHsPDiaDesde[0]) != 0 ) || ( DecimalUtil.compareTo(Z1335PaiTarifaPDia, T005F2_A1335PaiTarifaPDia[0]) != 0 ) || ( DecimalUtil.compareTo(Z1348PaiTarifaPDRec, T005F2_A1348PaiTarifaPDRec[0]) != 0 ) || ( GXutil.strcmp(Z2434PaiTarifaPDCri, T005F2_A2434PaiTarifaPDCri[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2057PaiExtraordRelSec != T005F2_A2057PaiExtraordRelSec[0] ) || ( GXutil.strcmp(Z2058PaiExtraordRelRef, T005F2_A2058PaiExtraordRelRef[0]) != 0 ) || ( GXutil.strcmp(Z1331PaiHsPDiaTipTra, T005F2_A1331PaiHsPDiaTipTra[0]) != 0 ) )
         {
            if ( Z1333PaiHsPDiaDia != T005F2_A1333PaiHsPDiaDia[0] )
            {
               GXutil.writeLogln("paisextraordinarias:[seudo value changed for attri]"+"PaiHsPDiaDia");
               GXutil.writeLogRaw("Old: ",Z1333PaiHsPDiaDia);
               GXutil.writeLogRaw("Current: ",T005F2_A1333PaiHsPDiaDia[0]);
            }
            if ( GXutil.strcmp(Z1334PaiHsPDiaDesde, T005F2_A1334PaiHsPDiaDesde[0]) != 0 )
            {
               GXutil.writeLogln("paisextraordinarias:[seudo value changed for attri]"+"PaiHsPDiaDesde");
               GXutil.writeLogRaw("Old: ",Z1334PaiHsPDiaDesde);
               GXutil.writeLogRaw("Current: ",T005F2_A1334PaiHsPDiaDesde[0]);
            }
            if ( DecimalUtil.compareTo(Z1335PaiTarifaPDia, T005F2_A1335PaiTarifaPDia[0]) != 0 )
            {
               GXutil.writeLogln("paisextraordinarias:[seudo value changed for attri]"+"PaiTarifaPDia");
               GXutil.writeLogRaw("Old: ",Z1335PaiTarifaPDia);
               GXutil.writeLogRaw("Current: ",T005F2_A1335PaiTarifaPDia[0]);
            }
            if ( DecimalUtil.compareTo(Z1348PaiTarifaPDRec, T005F2_A1348PaiTarifaPDRec[0]) != 0 )
            {
               GXutil.writeLogln("paisextraordinarias:[seudo value changed for attri]"+"PaiTarifaPDRec");
               GXutil.writeLogRaw("Old: ",Z1348PaiTarifaPDRec);
               GXutil.writeLogRaw("Current: ",T005F2_A1348PaiTarifaPDRec[0]);
            }
            if ( GXutil.strcmp(Z2434PaiTarifaPDCri, T005F2_A2434PaiTarifaPDCri[0]) != 0 )
            {
               GXutil.writeLogln("paisextraordinarias:[seudo value changed for attri]"+"PaiTarifaPDCri");
               GXutil.writeLogRaw("Old: ",Z2434PaiTarifaPDCri);
               GXutil.writeLogRaw("Current: ",T005F2_A2434PaiTarifaPDCri[0]);
            }
            if ( Z2057PaiExtraordRelSec != T005F2_A2057PaiExtraordRelSec[0] )
            {
               GXutil.writeLogln("paisextraordinarias:[seudo value changed for attri]"+"PaiExtraordRelSec");
               GXutil.writeLogRaw("Old: ",Z2057PaiExtraordRelSec);
               GXutil.writeLogRaw("Current: ",T005F2_A2057PaiExtraordRelSec[0]);
            }
            if ( GXutil.strcmp(Z2058PaiExtraordRelRef, T005F2_A2058PaiExtraordRelRef[0]) != 0 )
            {
               GXutil.writeLogln("paisextraordinarias:[seudo value changed for attri]"+"PaiExtraordRelRef");
               GXutil.writeLogRaw("Old: ",Z2058PaiExtraordRelRef);
               GXutil.writeLogRaw("Current: ",T005F2_A2058PaiExtraordRelRef[0]);
            }
            if ( GXutil.strcmp(Z1331PaiHsPDiaTipTra, T005F2_A1331PaiHsPDiaTipTra[0]) != 0 )
            {
               GXutil.writeLogln("paisextraordinarias:[seudo value changed for attri]"+"PaiHsPDiaTipTra");
               GXutil.writeLogRaw("Old: ",Z1331PaiHsPDiaTipTra);
               GXutil.writeLogRaw("Current: ",T005F2_A1331PaiHsPDiaTipTra[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Paishorasextras_pordia"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert5F164( )
   {
      beforeValidate5F164( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5F164( ) ;
      }
      if ( AnyError == 0 )
      {
         zm5F164( 0) ;
         checkOptimisticConcurrency5F164( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5F164( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert5F164( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005F10 */
                  pr_default.execute(8, new Object[] {Short.valueOf(A1332PaiHsExSec), A1977PaiExtraordOldDefault, Byte.valueOf(A1333PaiHsPDiaDia), Boolean.valueOf(n1334PaiHsPDiaDesde), A1334PaiHsPDiaDesde, A1335PaiTarifaPDia, A1348PaiTarifaPDRec, A2434PaiTarifaPDCri, Integer.valueOf(A2057PaiExtraordRelSec), A2058PaiExtraordRelRef, A2071PaiExtraordOld, Short.valueOf(A46PaiCod), A1331PaiHsPDiaTipTra});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paishorasextras_pordia");
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
                        resetCaption5F0( ) ;
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
            load5F164( ) ;
         }
         endLevel5F164( ) ;
      }
      closeExtendedTableCursors5F164( ) ;
   }

   public void update5F164( )
   {
      beforeValidate5F164( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5F164( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5F164( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5F164( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate5F164( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005F11 */
                  pr_default.execute(9, new Object[] {A1977PaiExtraordOldDefault, Byte.valueOf(A1333PaiHsPDiaDia), Boolean.valueOf(n1334PaiHsPDiaDesde), A1334PaiHsPDiaDesde, A1335PaiTarifaPDia, A1348PaiTarifaPDRec, A2434PaiTarifaPDCri, Integer.valueOf(A2057PaiExtraordRelSec), A2058PaiExtraordRelRef, A2071PaiExtraordOld, A1331PaiHsPDiaTipTra, Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paishorasextras_pordia");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paishorasextras_pordia"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate5F164( ) ;
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
         endLevel5F164( ) ;
      }
      closeExtendedTableCursors5F164( ) ;
   }

   public void deferredUpdate5F164( )
   {
   }

   public void delete( )
   {
      beforeValidate5F164( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5F164( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls5F164( ) ;
         afterConfirm5F164( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete5F164( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005F12 */
               pr_default.execute(10, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A1332PaiHsExSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Paishorasextras_pordia");
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
      sMode164 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel5F164( ) ;
      Gx_mode = sMode164 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls5F164( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean5[0] = AV26aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV27CliCod, A2057PaiExtraordRelSec, GXv_boolean5) ;
            paisextraordinarias_impl.this.AV26aplicadoHay = GXv_boolean5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26aplicadoHay", AV26aplicadoHay);
         }
         AV29Pgmname = "PaisExtraordinarias" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29Pgmname", AV29Pgmname);
         if ( ! ( ( GXutil.strcmp(A1331PaiHsPDiaTipTra, O1331PaiHsPDiaTipTra) != 0 ) || ( A1333PaiHsPDiaDia != O1333PaiHsPDiaDia ) || ( GXutil.strcmp(A1334PaiHsPDiaDesde, O1334PaiHsPDiaDesde) != 0 ) || ( DecimalUtil.compareTo(A1335PaiTarifaPDia, O1335PaiTarifaPDia) != 0 ) || ( DecimalUtil.compareTo(A1348PaiTarifaPDRec, O1348PaiTarifaPDRec) != 0 ) ) )
         {
            divPaiextraordrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPaiextraordrelsec_cell_Internalname, "Class", divPaiextraordrelsec_cell_Class, true);
         }
         else
         {
            if ( ( GXutil.strcmp(A1331PaiHsPDiaTipTra, O1331PaiHsPDiaTipTra) != 0 ) || ( A1333PaiHsPDiaDia != O1333PaiHsPDiaDia ) || ( GXutil.strcmp(A1334PaiHsPDiaDesde, O1334PaiHsPDiaDesde) != 0 ) || ( DecimalUtil.compareTo(A1335PaiTarifaPDia, O1335PaiTarifaPDia) != 0 ) || ( DecimalUtil.compareTo(A1348PaiTarifaPDRec, O1348PaiTarifaPDRec) != 0 ) )
            {
               divPaiextraordrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divPaiextraordrelsec_cell_Internalname, "Class", divPaiextraordrelsec_cell_Class, true);
            }
         }
      }
   }

   public void endLevel5F164( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete5F164( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "paisextraordinarias");
         if ( AnyError == 0 )
         {
            confirmValues5F0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "paisextraordinarias");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart5F164( )
   {
      /* Scan By routine */
      /* Using cursor T005F13 */
      pr_default.execute(11);
      RcdFound164 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound164 = (short)(1) ;
         A46PaiCod = T005F13_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1332PaiHsExSec = T005F13_A1332PaiHsExSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1332PaiHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1332PaiHsExSec), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext5F164( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound164 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound164 = (short)(1) ;
         A46PaiCod = T005F13_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1332PaiHsExSec = T005F13_A1332PaiHsExSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1332PaiHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1332PaiHsExSec), 4, 0));
      }
   }

   public void scanEnd5F164( )
   {
      pr_default.close(11);
   }

   public void afterConfirm5F164( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV26aplicadoHay ) && ! (0==A2057PaiExtraordRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV27CliCod), "PaiExtraordRelSec", 1, "PAIEXTRAORDRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynPaiExtraordRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert5F164( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate5F164( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete5F164( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete5F164( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate5F164( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes5F164( )
   {
      edtPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      edtPaiHsExSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiHsExSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiHsExSec_Enabled), 5, 0), true);
      dynPaiHsPDiaTipTra.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynPaiHsPDiaTipTra.getInternalname(), "Enabled", GXutil.ltrimstr( dynPaiHsPDiaTipTra.getEnabled(), 5, 0), true);
      cmbPaiHsPDiaDia.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiHsPDiaDia.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiHsPDiaDia.getEnabled(), 5, 0), true);
      edtPaiHsPDiaDesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiHsPDiaDesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiHsPDiaDesde_Enabled), 5, 0), true);
      edtPaiTarifaPDia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiTarifaPDia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiTarifaPDia_Enabled), 5, 0), true);
      edtPaiTarifaPDRec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiTarifaPDRec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiTarifaPDRec_Enabled), 5, 0), true);
      cmbPaiTarifaPDCri.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiTarifaPDCri.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiTarifaPDCri.getEnabled(), 5, 0), true);
      dynPaiExtraordRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynPaiExtraordRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynPaiExtraordRelSec.getEnabled(), 5, 0), true);
   }

   public void send_integrity_lvl_hashes5F164( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues5F0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.paisextraordinarias", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8PaiHsExSec,4,0))}, new String[] {"Gx_mode","PaiCod","PaiHsExSec"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"PaisExtraordinarias");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("PaiExtraordRelRef", GXutil.rtrim( localUtil.format( A2058PaiExtraordRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("paisextraordinarias:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z46PaiCod", GXutil.ltrim( localUtil.ntoc( Z46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1332PaiHsExSec", GXutil.ltrim( localUtil.ntoc( Z1332PaiHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1333PaiHsPDiaDia", GXutil.ltrim( localUtil.ntoc( Z1333PaiHsPDiaDia, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1334PaiHsPDiaDesde", GXutil.rtrim( Z1334PaiHsPDiaDesde));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1335PaiTarifaPDia", GXutil.ltrim( localUtil.ntoc( Z1335PaiTarifaPDia, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1348PaiTarifaPDRec", GXutil.ltrim( localUtil.ntoc( Z1348PaiTarifaPDRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2434PaiTarifaPDCri", GXutil.rtrim( Z2434PaiTarifaPDCri));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2057PaiExtraordRelSec", GXutil.ltrim( localUtil.ntoc( Z2057PaiExtraordRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2058PaiExtraordRelRef", Z2058PaiExtraordRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1331PaiHsPDiaTipTra", GXutil.rtrim( Z1331PaiHsPDiaTipTra));
      web.GxWebStd.gx_hidden_field( httpContext, "O2434PaiTarifaPDCri", GXutil.rtrim( O2434PaiTarifaPDCri));
      web.GxWebStd.gx_hidden_field( httpContext, "O1348PaiTarifaPDRec", GXutil.ltrim( localUtil.ntoc( O1348PaiTarifaPDRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1335PaiTarifaPDia", GXutil.ltrim( localUtil.ntoc( O1335PaiTarifaPDia, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1334PaiHsPDiaDesde", GXutil.rtrim( O1334PaiHsPDiaDesde));
      web.GxWebStd.gx_hidden_field( httpContext, "O1333PaiHsPDiaDia", GXutil.ltrim( localUtil.ntoc( O1333PaiHsPDiaDia, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1331PaiHsPDiaTipTra", GXutil.rtrim( O1331PaiHsPDiaTipTra));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N1331PaiHsPDiaTipTra", GXutil.rtrim( A1331PaiHsPDiaTipTra));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV7PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAIHSEXSEC", GXutil.ltrim( localUtil.ntoc( AV8PaiHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAIHSEXSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8PaiHsExSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_PAIHSPDIATIPTRA", GXutil.rtrim( AV14Insert_PaiHsPDiaTipTra));
      web.GxWebStd.gx_hidden_field( httpContext, "PAIEXTRAORDOLDDEFAULT", A1977PaiExtraordOldDefault);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV27CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV26aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "PAIEXTRAORDRELREF", A2058PaiExtraordRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "PAIEXTRAORDOLD", A2071PaiExtraordOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV29Pgmname));
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
      return formatLink("web.paisextraordinarias", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8PaiHsExSec,4,0))}, new String[] {"Gx_mode","PaiCod","PaiHsExSec"})  ;
   }

   public String getPgmname( )
   {
      return "PaisExtraordinarias" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Pais Extraordinarias", "") ;
   }

   public void initializeNonKey5F164( )
   {
      A1331PaiHsPDiaTipTra = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1331PaiHsPDiaTipTra", A1331PaiHsPDiaTipTra);
      A1977PaiExtraordOldDefault = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1977PaiExtraordOldDefault", A1977PaiExtraordOldDefault);
      AV26aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26aplicadoHay", AV26aplicadoHay);
      A1333PaiHsPDiaDia = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1333PaiHsPDiaDia", GXutil.str( A1333PaiHsPDiaDia, 1, 0));
      A1334PaiHsPDiaDesde = "" ;
      n1334PaiHsPDiaDesde = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1334PaiHsPDiaDesde", A1334PaiHsPDiaDesde);
      n1334PaiHsPDiaDesde = ((GXutil.strcmp("", A1334PaiHsPDiaDesde)==0) ? true : false) ;
      A1335PaiTarifaPDia = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1335PaiTarifaPDia", GXutil.ltrimstr( A1335PaiTarifaPDia, 6, 4));
      A1348PaiTarifaPDRec = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1348PaiTarifaPDRec", GXutil.ltrimstr( A1348PaiTarifaPDRec, 6, 4));
      A2434PaiTarifaPDCri = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2434PaiTarifaPDCri", A2434PaiTarifaPDCri);
      A2057PaiExtraordRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2057PaiExtraordRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2057PaiExtraordRelSec), 6, 0));
      A2058PaiExtraordRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2058PaiExtraordRelRef", A2058PaiExtraordRelRef);
      A2071PaiExtraordOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2071PaiExtraordOld", A2071PaiExtraordOld);
      O2434PaiTarifaPDCri = A2434PaiTarifaPDCri ;
      httpContext.ajax_rsp_assign_attri("", false, "A2434PaiTarifaPDCri", A2434PaiTarifaPDCri);
      O1348PaiTarifaPDRec = A1348PaiTarifaPDRec ;
      httpContext.ajax_rsp_assign_attri("", false, "A1348PaiTarifaPDRec", GXutil.ltrimstr( A1348PaiTarifaPDRec, 6, 4));
      O1335PaiTarifaPDia = A1335PaiTarifaPDia ;
      httpContext.ajax_rsp_assign_attri("", false, "A1335PaiTarifaPDia", GXutil.ltrimstr( A1335PaiTarifaPDia, 6, 4));
      O1334PaiHsPDiaDesde = A1334PaiHsPDiaDesde ;
      n1334PaiHsPDiaDesde = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1334PaiHsPDiaDesde", A1334PaiHsPDiaDesde);
      O1333PaiHsPDiaDia = A1333PaiHsPDiaDia ;
      httpContext.ajax_rsp_assign_attri("", false, "A1333PaiHsPDiaDia", GXutil.str( A1333PaiHsPDiaDia, 1, 0));
      O1331PaiHsPDiaTipTra = A1331PaiHsPDiaTipTra ;
      httpContext.ajax_rsp_assign_attri("", false, "A1331PaiHsPDiaTipTra", A1331PaiHsPDiaTipTra);
      Z1333PaiHsPDiaDia = (byte)(0) ;
      Z1334PaiHsPDiaDesde = "" ;
      Z1335PaiTarifaPDia = DecimalUtil.ZERO ;
      Z1348PaiTarifaPDRec = DecimalUtil.ZERO ;
      Z2434PaiTarifaPDCri = "" ;
      Z2057PaiExtraordRelSec = 0 ;
      Z2058PaiExtraordRelRef = "" ;
      Z1331PaiHsPDiaTipTra = "" ;
   }

   public void initAll5F164( )
   {
      A46PaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A1332PaiHsExSec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1332PaiHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1332PaiHsExSec), 4, 0));
      initializeNonKey5F164( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025198514034", true, true);
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
      httpContext.AddJavascriptSource("paisextraordinarias.js", "?2025198514034", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtPaiCod_Internalname = "PAICOD" ;
      edtPaiHsExSec_Internalname = "PAIHSEXSEC" ;
      dynPaiHsPDiaTipTra.setInternalname( "PAIHSPDIATIPTRA" );
      cmbPaiHsPDiaDia.setInternalname( "PAIHSPDIADIA" );
      edtPaiHsPDiaDesde_Internalname = "PAIHSPDIADESDE" ;
      edtPaiTarifaPDia_Internalname = "PAITARIFAPDIA" ;
      edtPaiTarifaPDRec_Internalname = "PAITARIFAPDREC" ;
      cmbPaiTarifaPDCri.setInternalname( "PAITARIFAPDCRI" );
      dynPaiExtraordRelSec.setInternalname( "PAIEXTRAORDRELSEC" );
      divPaiextraordrelsec_cell_Internalname = "PAIEXTRAORDRELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
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
      Form.setCaption( httpContext.getMessage( "Pais Extraordinarias", "") );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynPaiExtraordRelSec.setJsonclick( "" );
      dynPaiExtraordRelSec.setEnabled( 1 );
      divPaiextraordrelsec_cell_Class = "col-xs-12" ;
      cmbPaiTarifaPDCri.setJsonclick( "" );
      cmbPaiTarifaPDCri.setEnabled( 1 );
      edtPaiTarifaPDRec_Jsonclick = "" ;
      edtPaiTarifaPDRec_Enabled = 1 ;
      edtPaiTarifaPDia_Jsonclick = "" ;
      edtPaiTarifaPDia_Enabled = 1 ;
      edtPaiHsPDiaDesde_Jsonclick = "" ;
      edtPaiHsPDiaDesde_Enabled = 1 ;
      cmbPaiHsPDiaDia.setJsonclick( "" );
      cmbPaiHsPDiaDia.setEnabled( 1 );
      dynPaiHsPDiaTipTra.setJsonclick( "" );
      dynPaiHsPDiaTipTra.setEnabled( 1 );
      edtPaiHsExSec_Jsonclick = "" ;
      edtPaiHsExSec_Enabled = 1 ;
      edtPaiCod_Jsonclick = "" ;
      edtPaiCod_Enabled = 1 ;
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

   public void gxdlapaihspdiatiptra5F1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlapaihspdiatiptra_data5F1( ) ;
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

   public void gxapaihspdiatiptra_html5F1( )
   {
      String gxdynajaxvalue;
      gxdlapaihspdiatiptra_data5F1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynPaiHsPDiaTipTra.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynPaiHsPDiaTipTra.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlapaihspdiatiptra_data5F1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T005F14 */
      pr_default.execute(12);
      while ( (pr_default.getStatus(12) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T005F14_A1292TipoTraId[0]));
         gxdynajaxctrldescr.add(T005F14_A1293TipoTraNom[0]);
         pr_default.readNext(12);
      }
      pr_default.close(12);
   }

   public void gxdlapaiextraordrelsec5F164( int AV27CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlapaiextraordrelsec_data5F164( AV27CliCod) ;
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

   public void gxapaiextraordrelsec_html5F164( int AV27CliCod )
   {
      int gxdynajaxvalue;
      gxdlapaiextraordrelsec_data5F164( AV27CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynPaiExtraordRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynPaiExtraordRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlapaiextraordrelsec_data5F164( int AV27CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T005F15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(AV27CliCod)});
      while ( (pr_default.getStatus(13) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T005F15_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T005F15_A1880CliReDTChar[0]);
         pr_default.readNext(13);
      }
      pr_default.close(13);
   }

   public void gx13asapaiextraordolddefault5F164( byte A1333PaiHsPDiaDia ,
                                                  String A1334PaiHsPDiaDesde ,
                                                  java.math.BigDecimal A1335PaiTarifaPDia ,
                                                  java.math.BigDecimal A1348PaiTarifaPDRec ,
                                                  String A2434PaiTarifaPDCri ,
                                                  String Gx_mode ,
                                                  String A1331PaiHsPDiaTipTra )
   {
      if ( isUpd( )  )
      {
         GXt_char6 = A1977PaiExtraordOldDefault ;
         GXv_char7[0] = GXt_char6 ;
         new web.paisextraordinariassetolddef(remoteHandle, context).execute( O1331PaiHsPDiaTipTra, O1333PaiHsPDiaDia, O1334PaiHsPDiaDesde, O1335PaiTarifaPDia, O1348PaiTarifaPDRec, O2434PaiTarifaPDCri, GXv_char7) ;
         paisextraordinarias_impl.this.GXt_char6 = GXv_char7[0] ;
         A1977PaiExtraordOldDefault = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1977PaiExtraordOldDefault", A1977PaiExtraordOldDefault);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1977PaiExtraordOldDefault)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_19_5F164( String Gx_mode ,
                            int AV27CliCod ,
                            int A2057PaiExtraordRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV26aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV27CliCod, A2057PaiExtraordRelSec, GXv_boolean5) ;
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
      dynPaiHsPDiaTipTra.setName( "PAIHSPDIATIPTRA" );
      dynPaiHsPDiaTipTra.setWebtags( "" );
      dynPaiHsPDiaTipTra.removeAllItems();
      /* Using cursor T005F16 */
      pr_default.execute(14);
      while ( (pr_default.getStatus(14) != 101) )
      {
         dynPaiHsPDiaTipTra.addItem(T005F16_A1292TipoTraId[0], T005F16_A1293TipoTraNom[0], (short)(0));
         pr_default.readNext(14);
      }
      pr_default.close(14);
      if ( dynPaiHsPDiaTipTra.getItemCount() > 0 )
      {
         A1331PaiHsPDiaTipTra = dynPaiHsPDiaTipTra.getValidValue(A1331PaiHsPDiaTipTra) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1331PaiHsPDiaTipTra", A1331PaiHsPDiaTipTra);
      }
      cmbPaiHsPDiaDia.setName( "PAIHSPDIADIA" );
      cmbPaiHsPDiaDia.setWebtags( "" );
      cmbPaiHsPDiaDia.addItem("1", httpContext.getMessage( "Domingo", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("2", httpContext.getMessage( "Lunes", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("3", httpContext.getMessage( "Martes", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("4", httpContext.getMessage( "Miércoles", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("5", httpContext.getMessage( "Jueves", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("6", httpContext.getMessage( "Viernes", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("7", httpContext.getMessage( "Sábado", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("8", httpContext.getMessage( "Feriado", ""), (short)(0));
      cmbPaiHsPDiaDia.addItem("9", httpContext.getMessage( "Día hábil no especificado", ""), (short)(0));
      if ( cmbPaiHsPDiaDia.getItemCount() > 0 )
      {
         A1333PaiHsPDiaDia = (byte)(GXutil.lval( cmbPaiHsPDiaDia.getValidValue(GXutil.trim( GXutil.str( A1333PaiHsPDiaDia, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1333PaiHsPDiaDia", GXutil.str( A1333PaiHsPDiaDia, 1, 0));
      }
      cmbPaiTarifaPDCri.setName( "PAITARIFAPDCRI" );
      cmbPaiTarifaPDCri.setWebtags( "" );
      cmbPaiTarifaPDCri.addItem("exceso", httpContext.getMessage( "Por exceder las horas normales", ""), (short)(0));
      cmbPaiTarifaPDCri.addItem("horario", httpContext.getMessage( "Por fecha y horario determinado", ""), (short)(0));
      if ( cmbPaiTarifaPDCri.getItemCount() > 0 )
      {
         A2434PaiTarifaPDCri = cmbPaiTarifaPDCri.getValidValue(A2434PaiTarifaPDCri) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2434PaiTarifaPDCri", A2434PaiTarifaPDCri);
      }
      dynPaiExtraordRelSec.setName( "PAIEXTRAORDRELSEC" );
      dynPaiExtraordRelSec.setWebtags( "" );
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

   public void valid_Paihspdiatiptra( )
   {
      A2057PaiExtraordRelSec = (int)(GXutil.lval( dynPaiExtraordRelSec.getValue())) ;
      A1331PaiHsPDiaTipTra = dynPaiHsPDiaTipTra.getValue() ;
      /* Using cursor T005F17 */
      pr_default.execute(15, new Object[] {Short.valueOf(A46PaiCod), A1331PaiHsPDiaTipTra});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Horas Extras Pais Tipo Tra", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAIHSPDIATIPTRA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
      }
      pr_default.close(15);
      if ( ! ( ( GXutil.strcmp(A1331PaiHsPDiaTipTra, "diurno") == 0 ) || ( GXutil.strcmp(A1331PaiHsPDiaTipTra, "nocturno") == 0 ) || ( GXutil.strcmp(A1331PaiHsPDiaTipTra, "insalubre") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de trabajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PAIHSPDIATIPTRA");
         AnyError = (short)(1) ;
         GX_FocusControl = dynPaiHsPDiaTipTra.getInternalname() ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Paitarifapdcri( )
   {
      A2434PaiTarifaPDCri = cmbPaiTarifaPDCri.getValue() ;
      A1333PaiHsPDiaDia = (byte)(GXutil.lval( cmbPaiHsPDiaDia.getValue())) ;
      n1334PaiHsPDiaDesde = false ;
      A2057PaiExtraordRelSec = (int)(GXutil.lval( dynPaiExtraordRelSec.getValue())) ;
      A1331PaiHsPDiaTipTra = dynPaiHsPDiaTipTra.getValue() ;
      if ( ! ( ( GXutil.strcmp(A2434PaiTarifaPDCri, "exceso") == 0 ) || ( GXutil.strcmp(A2434PaiTarifaPDCri, "horario") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Criterio de aplicación", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PAITARIFAPDCRI");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPaiTarifaPDCri.getInternalname() ;
      }
      if ( isUpd( )  )
      {
         GXt_char6 = A1977PaiExtraordOldDefault ;
         GXv_char7[0] = GXt_char6 ;
         new web.paisextraordinariassetolddef(remoteHandle, context).execute( O1331PaiHsPDiaTipTra, O1333PaiHsPDiaDia, O1334PaiHsPDiaDesde, O1335PaiTarifaPDia, O1348PaiTarifaPDRec, O2434PaiTarifaPDCri, GXv_char7) ;
         paisextraordinarias_impl.this.GXt_char6 = GXv_char7[0] ;
         A1977PaiExtraordOldDefault = GXt_char6 ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1977PaiExtraordOldDefault", A1977PaiExtraordOldDefault);
   }

   public void valid_Paiextraordrelsec( )
   {
      A2434PaiTarifaPDCri = cmbPaiTarifaPDCri.getValue() ;
      A1333PaiHsPDiaDia = (byte)(GXutil.lval( cmbPaiHsPDiaDia.getValue())) ;
      n1334PaiHsPDiaDesde = false ;
      A2057PaiExtraordRelSec = (int)(GXutil.lval( dynPaiExtraordRelSec.getValue())) ;
      A1331PaiHsPDiaTipTra = dynPaiHsPDiaTipTra.getValue() ;
      if ( ( ( GXutil.strcmp(A1331PaiHsPDiaTipTra, O1331PaiHsPDiaTipTra) != 0 ) || ( A1333PaiHsPDiaDia != O1333PaiHsPDiaDia ) || ( GXutil.strcmp(A1334PaiHsPDiaDesde, O1334PaiHsPDiaDesde) != 0 ) || ( DecimalUtil.compareTo(A1335PaiTarifaPDia, O1335PaiTarifaPDia) != 0 ) || ( DecimalUtil.compareTo(A1348PaiTarifaPDRec, O1348PaiTarifaPDRec) != 0 ) ) && (0==A2057PaiExtraordRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "PAIEXTRAORDRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynPaiExtraordRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV26aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV27CliCod, A2057PaiExtraordRelSec, GXv_boolean5) ;
         paisextraordinarias_impl.this.AV26aplicadoHay = GXv_boolean5[0] ;
         AV26aplicadoHay = this.AV26aplicadoHay ;
      }
      O2434PaiTarifaPDCri = A2434PaiTarifaPDCri ;
      O1348PaiTarifaPDRec = A1348PaiTarifaPDRec ;
      O1335PaiTarifaPDia = A1335PaiTarifaPDia ;
      O1334PaiHsPDiaDesde = A1334PaiHsPDiaDesde ;
      n1334PaiHsPDiaDesde = false ;
      O1333PaiHsPDiaDia = A1333PaiHsPDiaDia ;
      O1331PaiHsPDiaTipTra = A1331PaiHsPDiaTipTra ;
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV8PaiHsExSec',fld:'vPAIHSEXSEC',pic:'ZZZ9',hsh:true},{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV8PaiHsExSec',fld:'vPAIHSEXSEC',pic:'ZZZ9',hsh:true},{av:'A2058PaiExtraordRelRef',fld:'PAIEXTRAORDRELREF',pic:''},{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e125F2',iparms:[{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]}");
      setEventMetadata("VALID_PAICOD","{handler:'valid_Paicod',iparms:[{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]");
      setEventMetadata("VALID_PAICOD",",oparms:[{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]}");
      setEventMetadata("VALID_PAIHSEXSEC","{handler:'valid_Paihsexsec',iparms:[{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]");
      setEventMetadata("VALID_PAIHSEXSEC",",oparms:[{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]}");
      setEventMetadata("VALID_PAIHSPDIATIPTRA","{handler:'valid_Paihspdiatiptra',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'AV27CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynPaiExtraordRelSec'},{av:'A2057PaiExtraordRelSec',fld:'PAIEXTRAORDRELSEC',pic:'ZZZZZ9'},{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]");
      setEventMetadata("VALID_PAIHSPDIATIPTRA",",oparms:[{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]}");
      setEventMetadata("VALID_PAIHSPDIADIA","{handler:'valid_Paihspdiadia',iparms:[{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]");
      setEventMetadata("VALID_PAIHSPDIADIA",",oparms:[{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]}");
      setEventMetadata("VALID_PAIHSPDIADESDE","{handler:'valid_Paihspdiadesde',iparms:[{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]");
      setEventMetadata("VALID_PAIHSPDIADESDE",",oparms:[{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]}");
      setEventMetadata("VALID_PAITARIFAPDIA","{handler:'valid_Paitarifapdia',iparms:[{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]");
      setEventMetadata("VALID_PAITARIFAPDIA",",oparms:[{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]}");
      setEventMetadata("VALID_PAITARIFAPDREC","{handler:'valid_Paitarifapdrec',iparms:[{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]");
      setEventMetadata("VALID_PAITARIFAPDREC",",oparms:[{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]}");
      setEventMetadata("VALID_PAITARIFAPDCRI","{handler:'valid_Paitarifapdcri',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O2434PaiTarifaPDCri'},{av:'O1348PaiTarifaPDRec'},{av:'O1335PaiTarifaPDia'},{av:'O1334PaiHsPDiaDesde'},{av:'O1333PaiHsPDiaDia'},{av:'O1331PaiHsPDiaTipTra'},{av:'cmbPaiTarifaPDCri'},{av:'A2434PaiTarifaPDCri',fld:'PAITARIFAPDCRI',pic:''},{av:'cmbPaiHsPDiaDia'},{av:'A1333PaiHsPDiaDia',fld:'PAIHSPDIADIA',pic:'9'},{av:'A1334PaiHsPDiaDesde',fld:'PAIHSPDIADESDE',pic:''},{av:'A1335PaiTarifaPDia',fld:'PAITARIFAPDIA',pic:'9.9999'},{av:'A1348PaiTarifaPDRec',fld:'PAITARIFAPDREC',pic:'9.9999'},{av:'AV27CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynPaiExtraordRelSec'},{av:'A2057PaiExtraordRelSec',fld:'PAIEXTRAORDRELSEC',pic:'ZZZZZ9'},{av:'A1977PaiExtraordOldDefault',fld:'PAIEXTRAORDOLDDEFAULT',pic:''},{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]");
      setEventMetadata("VALID_PAITARIFAPDCRI",",oparms:[{av:'A1977PaiExtraordOldDefault',fld:'PAIEXTRAORDOLDDEFAULT',pic:''},{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]}");
      setEventMetadata("VALID_PAIEXTRAORDRELSEC","{handler:'valid_Paiextraordrelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'cmbPaiTarifaPDCri'},{av:'A2434PaiTarifaPDCri',fld:'PAITARIFAPDCRI',pic:''},{av:'O1348PaiTarifaPDRec'},{av:'O1335PaiTarifaPDia'},{av:'O1334PaiHsPDiaDesde'},{av:'O1333PaiHsPDiaDia'},{av:'O1331PaiHsPDiaTipTra'},{av:'cmbPaiHsPDiaDia'},{av:'A1333PaiHsPDiaDia',fld:'PAIHSPDIADIA',pic:'9'},{av:'A1334PaiHsPDiaDesde',fld:'PAIHSPDIADESDE',pic:''},{av:'A1335PaiTarifaPDia',fld:'PAITARIFAPDIA',pic:'9.9999'},{av:'A1348PaiTarifaPDRec',fld:'PAITARIFAPDREC',pic:'9.9999'},{av:'AV27CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynPaiExtraordRelSec'},{av:'A2057PaiExtraordRelSec',fld:'PAIEXTRAORDRELSEC',pic:'ZZZZZ9'},{av:'AV26aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]");
      setEventMetadata("VALID_PAIEXTRAORDRELSEC",",oparms:[{av:'AV26aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'dynPaiHsPDiaTipTra'},{av:'A1331PaiHsPDiaTipTra',fld:'PAIHSPDIATIPTRA',pic:''}]}");
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
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z1334PaiHsPDiaDesde = "" ;
      Z1335PaiTarifaPDia = DecimalUtil.ZERO ;
      Z1348PaiTarifaPDRec = DecimalUtil.ZERO ;
      Z2434PaiTarifaPDCri = "" ;
      Z2058PaiExtraordRelRef = "" ;
      Z1331PaiHsPDiaTipTra = "" ;
      O2434PaiTarifaPDCri = "" ;
      O1348PaiTarifaPDRec = DecimalUtil.ZERO ;
      O1335PaiTarifaPDia = DecimalUtil.ZERO ;
      O1334PaiHsPDiaDesde = "" ;
      O1331PaiHsPDiaTipTra = "" ;
      N1331PaiHsPDiaTipTra = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A1334PaiHsPDiaDesde = "" ;
      A1335PaiTarifaPDia = DecimalUtil.ZERO ;
      A1348PaiTarifaPDRec = DecimalUtil.ZERO ;
      A2434PaiTarifaPDCri = "" ;
      A1331PaiHsPDiaTipTra = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A2058PaiExtraordRelRef = "" ;
      AV14Insert_PaiHsPDiaTipTra = "" ;
      A1977PaiExtraordOldDefault = "" ;
      A2071PaiExtraordOld = "" ;
      AV29Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode164 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXv_int2 = new int[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      AV15TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z1977PaiExtraordOldDefault = "" ;
      Z2071PaiExtraordOld = "" ;
      T005F5_A1332PaiHsExSec = new short[1] ;
      T005F5_A1977PaiExtraordOldDefault = new String[] {""} ;
      T005F5_A1333PaiHsPDiaDia = new byte[1] ;
      T005F5_A1334PaiHsPDiaDesde = new String[] {""} ;
      T005F5_n1334PaiHsPDiaDesde = new boolean[] {false} ;
      T005F5_A1335PaiTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005F5_A1348PaiTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005F5_A2434PaiTarifaPDCri = new String[] {""} ;
      T005F5_A2057PaiExtraordRelSec = new int[1] ;
      T005F5_A2058PaiExtraordRelRef = new String[] {""} ;
      T005F5_A2071PaiExtraordOld = new String[] {""} ;
      T005F5_A46PaiCod = new short[1] ;
      T005F5_A1331PaiHsPDiaTipTra = new String[] {""} ;
      T005F4_A46PaiCod = new short[1] ;
      T005F6_A46PaiCod = new short[1] ;
      T005F7_A46PaiCod = new short[1] ;
      T005F7_A1332PaiHsExSec = new short[1] ;
      T005F3_A1332PaiHsExSec = new short[1] ;
      T005F3_A1977PaiExtraordOldDefault = new String[] {""} ;
      T005F3_A1333PaiHsPDiaDia = new byte[1] ;
      T005F3_A1334PaiHsPDiaDesde = new String[] {""} ;
      T005F3_n1334PaiHsPDiaDesde = new boolean[] {false} ;
      T005F3_A1335PaiTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005F3_A1348PaiTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005F3_A2434PaiTarifaPDCri = new String[] {""} ;
      T005F3_A2057PaiExtraordRelSec = new int[1] ;
      T005F3_A2058PaiExtraordRelRef = new String[] {""} ;
      T005F3_A2071PaiExtraordOld = new String[] {""} ;
      T005F3_A46PaiCod = new short[1] ;
      T005F3_A1331PaiHsPDiaTipTra = new String[] {""} ;
      T005F8_A46PaiCod = new short[1] ;
      T005F8_A1332PaiHsExSec = new short[1] ;
      T005F9_A46PaiCod = new short[1] ;
      T005F9_A1332PaiHsExSec = new short[1] ;
      T005F2_A1332PaiHsExSec = new short[1] ;
      T005F2_A1977PaiExtraordOldDefault = new String[] {""} ;
      T005F2_A1333PaiHsPDiaDia = new byte[1] ;
      T005F2_A1334PaiHsPDiaDesde = new String[] {""} ;
      T005F2_n1334PaiHsPDiaDesde = new boolean[] {false} ;
      T005F2_A1335PaiTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005F2_A1348PaiTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T005F2_A2434PaiTarifaPDCri = new String[] {""} ;
      T005F2_A2057PaiExtraordRelSec = new int[1] ;
      T005F2_A2058PaiExtraordRelRef = new String[] {""} ;
      T005F2_A2071PaiExtraordOld = new String[] {""} ;
      T005F2_A46PaiCod = new short[1] ;
      T005F2_A1331PaiHsPDiaTipTra = new String[] {""} ;
      T005F13_A46PaiCod = new short[1] ;
      T005F13_A1332PaiHsExSec = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T005F14_A1292TipoTraId = new String[] {""} ;
      T005F14_A1293TipoTraNom = new String[] {""} ;
      T005F15_A1885CliRelSec = new int[1] ;
      T005F15_A1880CliReDTChar = new String[] {""} ;
      T005F15_A3CliCod = new int[1] ;
      T005F16_A1292TipoTraId = new String[] {""} ;
      T005F16_A1293TipoTraNom = new String[] {""} ;
      T005F17_A46PaiCod = new short[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paisextraordinarias__default(),
         new Object[] {
             new Object[] {
            T005F2_A1332PaiHsExSec, T005F2_A1977PaiExtraordOldDefault, T005F2_A1333PaiHsPDiaDia, T005F2_A1334PaiHsPDiaDesde, T005F2_n1334PaiHsPDiaDesde, T005F2_A1335PaiTarifaPDia, T005F2_A1348PaiTarifaPDRec, T005F2_A2434PaiTarifaPDCri, T005F2_A2057PaiExtraordRelSec, T005F2_A2058PaiExtraordRelRef,
            T005F2_A2071PaiExtraordOld, T005F2_A46PaiCod, T005F2_A1331PaiHsPDiaTipTra
            }
            , new Object[] {
            T005F3_A1332PaiHsExSec, T005F3_A1977PaiExtraordOldDefault, T005F3_A1333PaiHsPDiaDia, T005F3_A1334PaiHsPDiaDesde, T005F3_n1334PaiHsPDiaDesde, T005F3_A1335PaiTarifaPDia, T005F3_A1348PaiTarifaPDRec, T005F3_A2434PaiTarifaPDCri, T005F3_A2057PaiExtraordRelSec, T005F3_A2058PaiExtraordRelRef,
            T005F3_A2071PaiExtraordOld, T005F3_A46PaiCod, T005F3_A1331PaiHsPDiaTipTra
            }
            , new Object[] {
            T005F4_A46PaiCod
            }
            , new Object[] {
            T005F5_A1332PaiHsExSec, T005F5_A1977PaiExtraordOldDefault, T005F5_A1333PaiHsPDiaDia, T005F5_A1334PaiHsPDiaDesde, T005F5_n1334PaiHsPDiaDesde, T005F5_A1335PaiTarifaPDia, T005F5_A1348PaiTarifaPDRec, T005F5_A2434PaiTarifaPDCri, T005F5_A2057PaiExtraordRelSec, T005F5_A2058PaiExtraordRelRef,
            T005F5_A2071PaiExtraordOld, T005F5_A46PaiCod, T005F5_A1331PaiHsPDiaTipTra
            }
            , new Object[] {
            T005F6_A46PaiCod
            }
            , new Object[] {
            T005F7_A46PaiCod, T005F7_A1332PaiHsExSec
            }
            , new Object[] {
            T005F8_A46PaiCod, T005F8_A1332PaiHsExSec
            }
            , new Object[] {
            T005F9_A46PaiCod, T005F9_A1332PaiHsExSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005F13_A46PaiCod, T005F13_A1332PaiHsExSec
            }
            , new Object[] {
            T005F14_A1292TipoTraId, T005F14_A1293TipoTraNom
            }
            , new Object[] {
            T005F15_A1885CliRelSec, T005F15_A1880CliReDTChar, T005F15_A3CliCod
            }
            , new Object[] {
            T005F16_A1292TipoTraId, T005F16_A1293TipoTraNom
            }
            , new Object[] {
            T005F17_A46PaiCod
            }
         }
      );
      AV29Pgmname = "PaisExtraordinarias" ;
   }

   private byte Z1333PaiHsPDiaDia ;
   private byte O1333PaiHsPDiaDia ;
   private byte GxWebError ;
   private byte A1333PaiHsPDiaDia ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7PaiCod ;
   private short wcpOAV8PaiHsExSec ;
   private short Z46PaiCod ;
   private short Z1332PaiHsExSec ;
   private short A46PaiCod ;
   private short AV7PaiCod ;
   private short AV8PaiHsExSec ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1332PaiHsExSec ;
   private short RcdFound164 ;
   private short nIsDirty_164 ;
   private int Z2057PaiExtraordRelSec ;
   private int AV27CliCod ;
   private int A2057PaiExtraordRelSec ;
   private int trnEnded ;
   private int edtPaiCod_Enabled ;
   private int edtPaiHsExSec_Enabled ;
   private int edtPaiHsPDiaDesde_Enabled ;
   private int edtPaiTarifaPDia_Enabled ;
   private int edtPaiTarifaPDRec_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV30GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private java.math.BigDecimal Z1335PaiTarifaPDia ;
   private java.math.BigDecimal Z1348PaiTarifaPDRec ;
   private java.math.BigDecimal O1348PaiTarifaPDRec ;
   private java.math.BigDecimal O1335PaiTarifaPDia ;
   private java.math.BigDecimal A1335PaiTarifaPDia ;
   private java.math.BigDecimal A1348PaiTarifaPDRec ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z1334PaiHsPDiaDesde ;
   private String Z2434PaiTarifaPDCri ;
   private String Z1331PaiHsPDiaTipTra ;
   private String O2434PaiTarifaPDCri ;
   private String O1334PaiHsPDiaDesde ;
   private String O1331PaiHsPDiaTipTra ;
   private String N1331PaiHsPDiaTipTra ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String A1334PaiHsPDiaDesde ;
   private String A2434PaiTarifaPDCri ;
   private String A1331PaiHsPDiaTipTra ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtPaiCod_Internalname ;
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
   private String edtPaiCod_Jsonclick ;
   private String edtPaiHsExSec_Internalname ;
   private String edtPaiHsExSec_Jsonclick ;
   private String edtPaiHsPDiaDesde_Internalname ;
   private String edtPaiHsPDiaDesde_Jsonclick ;
   private String edtPaiTarifaPDia_Internalname ;
   private String edtPaiTarifaPDia_Jsonclick ;
   private String edtPaiTarifaPDRec_Internalname ;
   private String edtPaiTarifaPDRec_Jsonclick ;
   private String divPaiextraordrelsec_cell_Internalname ;
   private String divPaiextraordrelsec_cell_Class ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String AV14Insert_PaiHsPDiaTipTra ;
   private String AV29Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode164 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1334PaiHsPDiaDesde ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean AV26aplicadoHay ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXv_boolean5[] ;
   private boolean ZV26aplicadoHay ;
   private String A1977PaiExtraordOldDefault ;
   private String A2071PaiExtraordOld ;
   private String Z1977PaiExtraordOldDefault ;
   private String Z2071PaiExtraordOld ;
   private String Z2058PaiExtraordRelRef ;
   private String A2058PaiExtraordRelRef ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynPaiHsPDiaTipTra ;
   private HTMLChoice cmbPaiHsPDiaDia ;
   private HTMLChoice cmbPaiTarifaPDCri ;
   private HTMLChoice dynPaiExtraordRelSec ;
   private IDataStoreProvider pr_default ;
   private short[] T005F5_A1332PaiHsExSec ;
   private String[] T005F5_A1977PaiExtraordOldDefault ;
   private byte[] T005F5_A1333PaiHsPDiaDia ;
   private String[] T005F5_A1334PaiHsPDiaDesde ;
   private boolean[] T005F5_n1334PaiHsPDiaDesde ;
   private java.math.BigDecimal[] T005F5_A1335PaiTarifaPDia ;
   private java.math.BigDecimal[] T005F5_A1348PaiTarifaPDRec ;
   private String[] T005F5_A2434PaiTarifaPDCri ;
   private int[] T005F5_A2057PaiExtraordRelSec ;
   private String[] T005F5_A2058PaiExtraordRelRef ;
   private String[] T005F5_A2071PaiExtraordOld ;
   private short[] T005F5_A46PaiCod ;
   private String[] T005F5_A1331PaiHsPDiaTipTra ;
   private short[] T005F4_A46PaiCod ;
   private short[] T005F6_A46PaiCod ;
   private short[] T005F7_A46PaiCod ;
   private short[] T005F7_A1332PaiHsExSec ;
   private short[] T005F3_A1332PaiHsExSec ;
   private String[] T005F3_A1977PaiExtraordOldDefault ;
   private byte[] T005F3_A1333PaiHsPDiaDia ;
   private String[] T005F3_A1334PaiHsPDiaDesde ;
   private boolean[] T005F3_n1334PaiHsPDiaDesde ;
   private java.math.BigDecimal[] T005F3_A1335PaiTarifaPDia ;
   private java.math.BigDecimal[] T005F3_A1348PaiTarifaPDRec ;
   private String[] T005F3_A2434PaiTarifaPDCri ;
   private int[] T005F3_A2057PaiExtraordRelSec ;
   private String[] T005F3_A2058PaiExtraordRelRef ;
   private String[] T005F3_A2071PaiExtraordOld ;
   private short[] T005F3_A46PaiCod ;
   private String[] T005F3_A1331PaiHsPDiaTipTra ;
   private short[] T005F8_A46PaiCod ;
   private short[] T005F8_A1332PaiHsExSec ;
   private short[] T005F9_A46PaiCod ;
   private short[] T005F9_A1332PaiHsExSec ;
   private short[] T005F2_A1332PaiHsExSec ;
   private String[] T005F2_A1977PaiExtraordOldDefault ;
   private byte[] T005F2_A1333PaiHsPDiaDia ;
   private String[] T005F2_A1334PaiHsPDiaDesde ;
   private boolean[] T005F2_n1334PaiHsPDiaDesde ;
   private java.math.BigDecimal[] T005F2_A1335PaiTarifaPDia ;
   private java.math.BigDecimal[] T005F2_A1348PaiTarifaPDRec ;
   private String[] T005F2_A2434PaiTarifaPDCri ;
   private int[] T005F2_A2057PaiExtraordRelSec ;
   private String[] T005F2_A2058PaiExtraordRelRef ;
   private String[] T005F2_A2071PaiExtraordOld ;
   private short[] T005F2_A46PaiCod ;
   private String[] T005F2_A1331PaiHsPDiaTipTra ;
   private short[] T005F13_A46PaiCod ;
   private short[] T005F13_A1332PaiHsExSec ;
   private String[] T005F14_A1292TipoTraId ;
   private String[] T005F14_A1293TipoTraNom ;
   private int[] T005F15_A1885CliRelSec ;
   private String[] T005F15_A1880CliReDTChar ;
   private int[] T005F15_A3CliCod ;
   private String[] T005F16_A1292TipoTraId ;
   private String[] T005F16_A1293TipoTraNom ;
   private short[] T005F17_A46PaiCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV15TrnContextAtt ;
}

final  class paisextraordinarias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T005F2", "SELECT PaiHsExSec, PaiExtraordOldDefault, PaiHsPDiaDia, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiTarifaPDCri, PaiExtraordRelSec, PaiExtraordRelRef, PaiExtraordOld, PaiCod, PaiHsPDiaTipTra FROM Paishorasextras_pordia WHERE PaiCod = ? AND PaiHsExSec = ?  FOR UPDATE OF Paishorasextras_pordia NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005F3", "SELECT PaiHsExSec, PaiExtraordOldDefault, PaiHsPDiaDia, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiTarifaPDCri, PaiExtraordRelSec, PaiExtraordRelRef, PaiExtraordOld, PaiCod, PaiHsPDiaTipTra FROM Paishorasextras_pordia WHERE PaiCod = ? AND PaiHsExSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005F4", "SELECT PaiCod FROM PaisTipoTrabajo WHERE PaiCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005F5", "SELECT TM1.PaiHsExSec, TM1.PaiExtraordOldDefault, TM1.PaiHsPDiaDia, TM1.PaiHsPDiaDesde, TM1.PaiTarifaPDia, TM1.PaiTarifaPDRec, TM1.PaiTarifaPDCri, TM1.PaiExtraordRelSec, TM1.PaiExtraordRelRef, TM1.PaiExtraordOld, TM1.PaiCod, TM1.PaiHsPDiaTipTra AS PaiHsPDiaTipTra FROM Paishorasextras_pordia TM1 WHERE TM1.PaiCod = ? and TM1.PaiHsExSec = ? ORDER BY TM1.PaiCod, TM1.PaiHsExSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005F6", "SELECT PaiCod FROM PaisTipoTrabajo WHERE PaiCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005F7", "SELECT PaiCod, PaiHsExSec FROM Paishorasextras_pordia WHERE PaiCod = ? AND PaiHsExSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005F8", "SELECT PaiCod, PaiHsExSec FROM Paishorasextras_pordia WHERE ( PaiCod > ? or PaiCod = ? and PaiHsExSec > ?) ORDER BY PaiCod, PaiHsExSec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005F9", "SELECT PaiCod, PaiHsExSec FROM Paishorasextras_pordia WHERE ( PaiCod < ? or PaiCod = ? and PaiHsExSec < ?) ORDER BY PaiCod DESC, PaiHsExSec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005F10", "SAVEPOINT gxupdate;INSERT INTO Paishorasextras_pordia(PaiHsExSec, PaiExtraordOldDefault, PaiHsPDiaDia, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiTarifaPDCri, PaiExtraordRelSec, PaiExtraordRelRef, PaiExtraordOld, PaiCod, PaiHsPDiaTipTra) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005F11", "SAVEPOINT gxupdate;UPDATE Paishorasextras_pordia SET PaiExtraordOldDefault=?, PaiHsPDiaDia=?, PaiHsPDiaDesde=?, PaiTarifaPDia=?, PaiTarifaPDRec=?, PaiTarifaPDCri=?, PaiExtraordRelSec=?, PaiExtraordRelRef=?, PaiExtraordOld=?, PaiHsPDiaTipTra=?  WHERE PaiCod = ? AND PaiHsExSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005F12", "SAVEPOINT gxupdate;DELETE FROM Paishorasextras_pordia  WHERE PaiCod = ? AND PaiHsExSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005F13", "SELECT PaiCod, PaiHsExSec FROM Paishorasextras_pordia ORDER BY PaiCod, PaiHsExSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005F14", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo ORDER BY TipoTraNom ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005F15", "SELECT CliRelSec, CliReDTChar, CliCod FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005F16", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo ORDER BY TipoTraNom ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005F17", "SELECT PaiCod FROM PaisTipoTrabajo WHERE PaiCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 5);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(10);
               ((short[]) buf[11])[0] = rslt.getShort(11);
               ((String[]) buf[12])[0] = rslt.getString(12, 20);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 5);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(10);
               ((short[]) buf[11])[0] = rslt.getShort(11);
               ((String[]) buf[12])[0] = rslt.getString(12, 20);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 5);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(10);
               ((short[]) buf[11])[0] = rslt.getShort(11);
               ((String[]) buf[12])[0] = rslt.getString(12, 20);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 15 :
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setNLongVarchar(2, (String)parms[1], false);
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
               stmt.setShort(11, ((Number) parms[11]).shortValue());
               stmt.setString(12, (String)parms[12], 20);
               return;
            case 9 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
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
               stmt.setString(10, (String)parms[10], 20);
               stmt.setShort(11, ((Number) parms[11]).shortValue());
               stmt.setShort(12, ((Number) parms[12]).shortValue());
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

