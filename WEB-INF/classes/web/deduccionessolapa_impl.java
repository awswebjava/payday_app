package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class deduccionessolapa_impl extends GXDataArea
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
         gx4asaclicod2572( AV7CliCod) ;
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
         gx10asalegdedsec2572( AV10LegDedSec) ;
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
         gx11asalegdedsec2572( AV7CliCod, AV8EmpCod, A6LegNumero) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_26") == 0 )
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
         gxload_26( A3CliCod, A84LegDedConCodigo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_25") == 0 )
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
         gxload_25( A3CliCod, A1EmpCod, A6LegNumero) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "deducciones Solapa", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtLegDedConCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public deduccionessolapa_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public deduccionessolapa_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( deduccionessolapa_impl.class ));
   }

   public deduccionessolapa_impl( int remoteHandle ,
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
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.masterpageframe");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedlegdedconcodigo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocklegdedconcodigo_Internalname, httpContext.getMessage( "Deducción", ""), "", "", lblTextblocklegdedconcodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_deduccionesSolapa.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_legdedconcodigo.setProperty("Caption", Combo_legdedconcodigo_Caption);
      ucCombo_legdedconcodigo.setProperty("Cls", Combo_legdedconcodigo_Cls);
      ucCombo_legdedconcodigo.setProperty("EmptyItem", Combo_legdedconcodigo_Emptyitem);
      ucCombo_legdedconcodigo.setProperty("DropDownOptionsData", AV24LegDedConCodigo_Data);
      ucCombo_legdedconcodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legdedconcodigo_Internalname, "COMBO_LEGDEDCONCODIGOContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegDedConCodigo_Internalname, httpContext.getMessage( "Deducción Concepto", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegDedConCodigo_Internalname, GXutil.rtrim( A84LegDedConCodigo), GXutil.rtrim( localUtil.format( A84LegDedConCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegDedConCodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtLegDedConCodigo_Visible, edtLegDedConCodigo_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_deduccionesSolapa.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegDedFchDes_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegDedFchDes_Internalname, httpContext.getMessage( "Desde", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtLegDedFchDes_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegDedFchDes_Internalname, localUtil.format(A556LegDedFchDes, "99/99/99"), localUtil.format( A556LegDedFchDes, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegDedFchDes_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtLegDedFchDes_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_deduccionesSolapa.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtLegDedFchDes_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLegDedFchDes_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_deduccionesSolapa.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtLegDedFchHas_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegDedFchHas_Internalname, localUtil.format(A557LegDedFchHas, "99/99/99"), localUtil.format( A557LegDedFchHas, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegDedFchHas_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtLegDedFchHas_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_deduccionesSolapa.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtLegDedFchHas_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLegDedFchHas_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_deduccionesSolapa.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtLegDedDescrip_Internalname, A568LegDedDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", (short)(0), 1, edtLegDedDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_deduccionesSolapa.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegDedImporte_Internalname, GXutil.ltrim( localUtil.ntoc( A560LegDedImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegDedImporte_Enabled!=0) ? localUtil.format( A560LegDedImporte, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A560LegDedImporte, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegDedImporte_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegDedImporte_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_deduccionesSolapa.htm");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_deduccionesSolapa.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_deduccionesSolapa.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_deduccionesSolapa.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_legdedconcodigo_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombolegdedconcodigo_Internalname, GXutil.rtrim( AV25ComboLegDedConCodigo), GXutil.rtrim( localUtil.format( AV25ComboLegDedConCodigo, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombolegdedconcodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombolegdedconcodigo_Visible, edtavCombolegdedconcodigo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_deduccionesSolapa.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,66);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_deduccionesSolapa.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_deduccionesSolapa.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", edtLegNumero_Visible, edtLegNumero_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_deduccionesSolapa.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegDedSec_Internalname, GXutil.ltrim( localUtil.ntoc( A83LegDedSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A83LegDedSec), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegDedSec_Jsonclick, 0, "Attribute", "", "", "", "", edtLegDedSec_Visible, edtLegDedSec_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_deduccionesSolapa.htm");
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
      e11252 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGDEDCONCODIGO_DATA"), AV24LegDedConCodigo_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "Z6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z83LegDedSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z83LegDedSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z556LegDedFchDes = localUtil.ctod( httpContext.cgiGet( "Z556LegDedFchDes"), 0) ;
            Z557LegDedFchHas = localUtil.ctod( httpContext.cgiGet( "Z557LegDedFchHas"), 0) ;
            Z560LegDedImporte = localUtil.ctond( httpContext.cgiGet( "Z560LegDedImporte")) ;
            Z568LegDedDescrip = httpContext.cgiGet( "Z568LegDedDescrip") ;
            Z84LegDedConCodigo = httpContext.cgiGet( "Z84LegDedConCodigo") ;
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
            A250LegIdNomApe = httpContext.cgiGet( "LEGIDNOMAPE") ;
            A251LegNombre = httpContext.cgiGet( "LEGNOMBRE") ;
            A230LegApellido = httpContext.cgiGet( "LEGAPELLIDO") ;
            A93LegId = httpContext.cgiGet( "LEGID") ;
            n93LegId = false ;
            AV28Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_legdedconcodigo_Objectcall = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Objectcall") ;
            Combo_legdedconcodigo_Class = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Class") ;
            Combo_legdedconcodigo_Icontype = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Icontype") ;
            Combo_legdedconcodigo_Icon = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Icon") ;
            Combo_legdedconcodigo_Caption = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Caption") ;
            Combo_legdedconcodigo_Tooltip = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Tooltip") ;
            Combo_legdedconcodigo_Cls = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Cls") ;
            Combo_legdedconcodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Selectedvalue_set") ;
            Combo_legdedconcodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Selectedvalue_get") ;
            Combo_legdedconcodigo_Selectedtext_set = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Selectedtext_set") ;
            Combo_legdedconcodigo_Selectedtext_get = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Selectedtext_get") ;
            Combo_legdedconcodigo_Gamoauthtoken = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Gamoauthtoken") ;
            Combo_legdedconcodigo_Ddointernalname = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Ddointernalname") ;
            Combo_legdedconcodigo_Titlecontrolalign = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Titlecontrolalign") ;
            Combo_legdedconcodigo_Dropdownoptionstype = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Dropdownoptionstype") ;
            Combo_legdedconcodigo_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Enabled")) ;
            Combo_legdedconcodigo_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Visible")) ;
            Combo_legdedconcodigo_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Titlecontrolidtoreplace") ;
            Combo_legdedconcodigo_Datalisttype = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Datalisttype") ;
            Combo_legdedconcodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Allowmultipleselection")) ;
            Combo_legdedconcodigo_Datalistfixedvalues = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Datalistfixedvalues") ;
            Combo_legdedconcodigo_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Isgriditem")) ;
            Combo_legdedconcodigo_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Hasdescription")) ;
            Combo_legdedconcodigo_Datalistproc = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Datalistproc") ;
            Combo_legdedconcodigo_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Datalistprocparametersprefix") ;
            Combo_legdedconcodigo_Remoteservicesparameters = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Remoteservicesparameters") ;
            Combo_legdedconcodigo_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_legdedconcodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Includeonlyselectedoption")) ;
            Combo_legdedconcodigo_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Includeselectalloption")) ;
            Combo_legdedconcodigo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Emptyitem")) ;
            Combo_legdedconcodigo_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Includeaddnewoption")) ;
            Combo_legdedconcodigo_Htmltemplate = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Htmltemplate") ;
            Combo_legdedconcodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Multiplevaluestype") ;
            Combo_legdedconcodigo_Loadingdata = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Loadingdata") ;
            Combo_legdedconcodigo_Noresultsfound = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Noresultsfound") ;
            Combo_legdedconcodigo_Emptyitemtext = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Emptyitemtext") ;
            Combo_legdedconcodigo_Onlyselectedvalues = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Onlyselectedvalues") ;
            Combo_legdedconcodigo_Selectalltext = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Selectalltext") ;
            Combo_legdedconcodigo_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Multiplevaluesseparator") ;
            Combo_legdedconcodigo_Addnewoptiontext = httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Addnewoptiontext") ;
            Combo_legdedconcodigo_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_LEGDEDCONCODIGO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            A84LegDedConCodigo = httpContext.cgiGet( edtLegDedConCodigo_Internalname) ;
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
            AV25ComboLegDedConCodigo = httpContext.cgiGet( edtavCombolegdedconcodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25ComboLegDedConCodigo", AV25ComboLegDedConCodigo);
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
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"deduccionesSolapa");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A83LegDedSec != Z83LegDedSec ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("deduccionessolapa:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
                        confirm_250( ) ;
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
                        e11252 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12252 ();
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
         e12252 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll2572( ) ;
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
         disableAttributes2572( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombolegdedconcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombolegdedconcodigo_Enabled), 5, 0), true);
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

   public void confirm_250( )
   {
      beforeValidate2572( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2572( ) ;
         }
         else
         {
            checkExtendedTable2572( ) ;
            closeExtendedTableCursors2572( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption250( )
   {
   }

   public void e11252( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV11WWPContext = GXv_SdtWWPContext1[0] ;
      edtLegDedConCodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedConCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedConCodigo_Visible), 5, 0), true);
      AV25ComboLegDedConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ComboLegDedConCodigo", AV25ComboLegDedConCodigo);
      edtavCombolegdedconcodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombolegdedconcodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombolegdedconcodigo_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOLEGDEDCONCODIGO' */
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
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWdeduccionesSolapa_Insert", GXv_boolean3) ;
         deduccionessolapa_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWdeduccionesSolapa_Update", GXv_boolean3) ;
         deduccionessolapa_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWdeduccionesSolapa_Delete", GXv_boolean3) ;
         deduccionessolapa_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV28Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV14TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV28Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV29GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29GXV1), 8, 0));
         while ( AV29GXV1 <= AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV17TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV29GXV1));
            if ( GXutil.strcmp(AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegDedConCodigo") == 0 )
            {
               AV16Insert_LegDedConCodigo = AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16Insert_LegDedConCodigo", AV16Insert_LegDedConCodigo);
               if ( ! (GXutil.strcmp("", AV16Insert_LegDedConCodigo)==0) )
               {
                  AV25ComboLegDedConCodigo = AV16Insert_LegDedConCodigo ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV25ComboLegDedConCodigo", AV25ComboLegDedConCodigo);
                  Combo_legdedconcodigo_Selectedvalue_set = AV25ComboLegDedConCodigo ;
                  ucCombo_legdedconcodigo.sendProperty(context, "", false, Combo_legdedconcodigo_Internalname, "SelectedValue_set", Combo_legdedconcodigo_Selectedvalue_set);
                  Combo_legdedconcodigo_Enabled = false ;
                  ucCombo_legdedconcodigo.sendProperty(context, "", false, Combo_legdedconcodigo_Internalname, "Enabled", GXutil.booltostr( Combo_legdedconcodigo_Enabled));
               }
            }
            AV29GXV1 = (int)(AV29GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29GXV1), 8, 0));
         }
      }
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtLegNumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Visible), 5, 0), true);
      edtLegDedSec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedSec_Visible), 5, 0), true);
      GXt_char4 = AV27SubTipoConCod1 ;
      GXv_char5[0] = GXt_char4 ;
      new web.subtipocalculogananciasded1(remoteHandle, context).execute( GXv_char5) ;
      deduccionessolapa_impl.this.GXt_char4 = GXv_char5[0] ;
      AV27SubTipoConCod1 = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27SubTipoConCod1", AV27SubTipoConCod1);
   }

   public void e12252( )
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
      /* 'LOADCOMBOLEGDEDCONCODIGO' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item6 = AV24LegDedConCodigo_Data ;
      GXv_char5[0] = AV20ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item7[0] = GXt_objcol_SdtDVB_SDTComboData_Item6 ;
      new web.deduccionessolapaloaddvcombo(remoteHandle, context).execute( "LegDedConCodigo", Gx_mode, AV7CliCod, AV8EmpCod, AV9LegNumero, AV10LegDedSec, GXv_char5, GXv_objcol_SdtDVB_SDTComboData_Item7) ;
      deduccionessolapa_impl.this.AV20ComboSelectedValue = GXv_char5[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item6 = GXv_objcol_SdtDVB_SDTComboData_Item7[0] ;
      AV24LegDedConCodigo_Data = GXt_objcol_SdtDVB_SDTComboData_Item6 ;
      Combo_legdedconcodigo_Selectedvalue_set = AV20ComboSelectedValue ;
      ucCombo_legdedconcodigo.sendProperty(context, "", false, Combo_legdedconcodigo_Internalname, "SelectedValue_set", Combo_legdedconcodigo_Selectedvalue_set);
      AV25ComboLegDedConCodigo = AV20ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ComboLegDedConCodigo", AV25ComboLegDedConCodigo);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_legdedconcodigo_Enabled = false ;
         ucCombo_legdedconcodigo.sendProperty(context, "", false, Combo_legdedconcodigo_Internalname, "Enabled", GXutil.booltostr( Combo_legdedconcodigo_Enabled));
      }
   }

   public void zm2572( int GX_JID )
   {
      if ( ( GX_JID == 24 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z556LegDedFchDes = T00253_A556LegDedFchDes[0] ;
            Z557LegDedFchHas = T00253_A557LegDedFchHas[0] ;
            Z560LegDedImporte = T00253_A560LegDedImporte[0] ;
            Z568LegDedDescrip = T00253_A568LegDedDescrip[0] ;
            Z84LegDedConCodigo = T00253_A84LegDedConCodigo[0] ;
         }
         else
         {
            Z556LegDedFchDes = A556LegDedFchDes ;
            Z557LegDedFchHas = A557LegDedFchHas ;
            Z560LegDedImporte = A560LegDedImporte ;
            Z568LegDedDescrip = A568LegDedDescrip ;
            Z84LegDedConCodigo = A84LegDedConCodigo ;
         }
      }
      if ( GX_JID == -24 )
      {
         Z83LegDedSec = A83LegDedSec ;
         Z556LegDedFchDes = A556LegDedFchDes ;
         Z557LegDedFchHas = A557LegDedFchHas ;
         Z560LegDedImporte = A560LegDedImporte ;
         Z568LegDedDescrip = A568LegDedDescrip ;
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
            GXt_int8 = A3CliCod ;
            GXv_int9[0] = GXt_int8 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int9) ;
            deduccionessolapa_impl.this.GXt_int8 = GXv_int9[0] ;
            A3CliCod = GXt_int8 ;
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
         A6LegNumero = AV9LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV16Insert_LegDedConCodigo)==0) )
      {
         edtLegDedConCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegDedConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedConCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtLegDedConCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegDedConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedConCodigo_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV16Insert_LegDedConCodigo)==0) )
      {
         A84LegDedConCodigo = AV16Insert_LegDedConCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A84LegDedConCodigo", A84LegDedConCodigo);
      }
      else
      {
         A84LegDedConCodigo = AV25ComboLegDedConCodigo ;
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV28Pgmname = "deduccionesSolapa" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28Pgmname", AV28Pgmname);
         /* Using cursor T00254 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         A250LegIdNomApe = T00254_A250LegIdNomApe[0] ;
         A251LegNombre = T00254_A251LegNombre[0] ;
         A251LegNombre = T00254_A251LegNombre[0] ;
         A230LegApellido = T00254_A230LegApellido[0] ;
         A230LegApellido = T00254_A230LegApellido[0] ;
         A93LegId = T00254_A93LegId[0] ;
         n93LegId = T00254_n93LegId[0] ;
         A93LegId = T00254_A93LegId[0] ;
         n93LegId = T00254_n93LegId[0] ;
         pr_default.close(2);
         /* Using cursor T00255 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A84LegDedConCodigo});
         A559LegDedConDescrip = T00255_A559LegDedConDescrip[0] ;
         pr_default.close(3);
         A570LegDedConCodYDesc = GXutil.trim( A84LegDedConCodigo) + " - " + GXutil.trim( A559LegDedConDescrip) ;
         httpContext.ajax_rsp_assign_attri("", false, "A570LegDedConCodYDesc", A570LegDedConCodYDesc);
      }
   }

   public void load2572( )
   {
      /* Using cursor T00256 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A83LegDedSec), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound72 = (short)(1) ;
         A250LegIdNomApe = T00256_A250LegIdNomApe[0] ;
         A556LegDedFchDes = T00256_A556LegDedFchDes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A556LegDedFchDes", localUtil.format(A556LegDedFchDes, "99/99/99"));
         A557LegDedFchHas = T00256_A557LegDedFchHas[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A557LegDedFchHas", localUtil.format(A557LegDedFchHas, "99/99/99"));
         A559LegDedConDescrip = T00256_A559LegDedConDescrip[0] ;
         A560LegDedImporte = T00256_A560LegDedImporte[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A560LegDedImporte", GXutil.ltrimstr( A560LegDedImporte, 14, 2));
         A568LegDedDescrip = T00256_A568LegDedDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A568LegDedDescrip", A568LegDedDescrip);
         A251LegNombre = T00256_A251LegNombre[0] ;
         A230LegApellido = T00256_A230LegApellido[0] ;
         A93LegId = T00256_A93LegId[0] ;
         n93LegId = T00256_n93LegId[0] ;
         A84LegDedConCodigo = T00256_A84LegDedConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A84LegDedConCodigo", A84LegDedConCodigo);
         zm2572( -24) ;
      }
      pr_default.close(4);
      onLoadActions2572( ) ;
   }

   public void onLoadActions2572( )
   {
      AV28Pgmname = "deduccionesSolapa" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28Pgmname", AV28Pgmname);
      A570LegDedConCodYDesc = GXutil.trim( A84LegDedConCodigo) + " - " + GXutil.trim( A559LegDedConDescrip) ;
      httpContext.ajax_rsp_assign_attri("", false, "A570LegDedConCodYDesc", A570LegDedConCodYDesc);
   }

   public void checkExtendedTable2572( )
   {
      nIsDirty_72 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV28Pgmname = "deduccionesSolapa" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28Pgmname", AV28Pgmname);
      /* Using cursor T00255 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A84LegDedConCodigo});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Deduccion Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGDEDCONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A559LegDedConDescrip = T00255_A559LegDedConDescrip[0] ;
      pr_default.close(3);
      nIsDirty_72 = (short)(1) ;
      A570LegDedConCodYDesc = GXutil.trim( A84LegDedConCodigo) + " - " + GXutil.trim( A559LegDedConDescrip) ;
      httpContext.ajax_rsp_assign_attri("", false, "A570LegDedConCodYDesc", A570LegDedConCodYDesc);
      /* Using cursor T00254 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A250LegIdNomApe = T00254_A250LegIdNomApe[0] ;
      A251LegNombre = T00254_A251LegNombre[0] ;
      A251LegNombre = T00254_A251LegNombre[0] ;
      A230LegApellido = T00254_A230LegApellido[0] ;
      A230LegApellido = T00254_A230LegApellido[0] ;
      A93LegId = T00254_A93LegId[0] ;
      n93LegId = T00254_n93LegId[0] ;
      A93LegId = T00254_A93LegId[0] ;
      n93LegId = T00254_n93LegId[0] ;
      pr_default.close(2);
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
         GX_FocusControl = edtLegDedConCodigo_Internalname ;
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

   public void closeExtendedTableCursors2572( )
   {
      pr_default.close(3);
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_26( int A3CliCod ,
                          String A84LegDedConCodigo )
   {
      /* Using cursor T00257 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A84LegDedConCodigo});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Deduccion Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGDEDCONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A559LegDedConDescrip = T00257_A559LegDedConDescrip[0] ;
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

   public void gxload_25( int A3CliCod ,
                          short A1EmpCod ,
                          int A6LegNumero )
   {
      /* Using cursor T00258 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A250LegIdNomApe = T00258_A250LegIdNomApe[0] ;
      A251LegNombre = T00258_A251LegNombre[0] ;
      A251LegNombre = T00258_A251LegNombre[0] ;
      A230LegApellido = T00258_A230LegApellido[0] ;
      A230LegApellido = T00258_A230LegApellido[0] ;
      A93LegId = T00258_A93LegId[0] ;
      n93LegId = T00258_n93LegId[0] ;
      A93LegId = T00258_A93LegId[0] ;
      n93LegId = T00258_n93LegId[0] ;
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

   public void getKey2572( )
   {
      /* Using cursor T00259 */
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
      /* Using cursor T00253 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A83LegDedSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm2572( 24) ;
         RcdFound72 = (short)(1) ;
         A83LegDedSec = T00253_A83LegDedSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
         A556LegDedFchDes = T00253_A556LegDedFchDes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A556LegDedFchDes", localUtil.format(A556LegDedFchDes, "99/99/99"));
         A557LegDedFchHas = T00253_A557LegDedFchHas[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A557LegDedFchHas", localUtil.format(A557LegDedFchHas, "99/99/99"));
         A560LegDedImporte = T00253_A560LegDedImporte[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A560LegDedImporte", GXutil.ltrimstr( A560LegDedImporte, 14, 2));
         A568LegDedDescrip = T00253_A568LegDedDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A568LegDedDescrip", A568LegDedDescrip);
         A3CliCod = T00253_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T00253_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T00253_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A84LegDedConCodigo = T00253_A84LegDedConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A84LegDedConCodigo", A84LegDedConCodigo);
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z83LegDedSec = A83LegDedSec ;
         sMode72 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load2572( ) ;
         if ( AnyError == 1 )
         {
            RcdFound72 = (short)(0) ;
            initializeNonKey2572( ) ;
         }
         Gx_mode = sMode72 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound72 = (short)(0) ;
         initializeNonKey2572( ) ;
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
      getKey2572( ) ;
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
      /* Using cursor T002510 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A83LegDedSec), Integer.valueOf(A83LegDedSec), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Integer.valueOf(A83LegDedSec), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A83LegDedSec), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T002510_A83LegDedSec[0] < A83LegDedSec ) || ( T002510_A83LegDedSec[0] == A83LegDedSec ) && ( T002510_A3CliCod[0] < A3CliCod ) || ( T002510_A3CliCod[0] == A3CliCod ) && ( T002510_A83LegDedSec[0] == A83LegDedSec ) && ( T002510_A1EmpCod[0] < A1EmpCod ) || ( T002510_A1EmpCod[0] == A1EmpCod ) && ( T002510_A3CliCod[0] == A3CliCod ) && ( T002510_A83LegDedSec[0] == A83LegDedSec ) && ( T002510_A6LegNumero[0] < A6LegNumero ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T002510_A83LegDedSec[0] > A83LegDedSec ) || ( T002510_A83LegDedSec[0] == A83LegDedSec ) && ( T002510_A3CliCod[0] > A3CliCod ) || ( T002510_A3CliCod[0] == A3CliCod ) && ( T002510_A83LegDedSec[0] == A83LegDedSec ) && ( T002510_A1EmpCod[0] > A1EmpCod ) || ( T002510_A1EmpCod[0] == A1EmpCod ) && ( T002510_A3CliCod[0] == A3CliCod ) && ( T002510_A83LegDedSec[0] == A83LegDedSec ) && ( T002510_A6LegNumero[0] > A6LegNumero ) ) )
         {
            A83LegDedSec = T002510_A83LegDedSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
            A3CliCod = T002510_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002510_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T002510_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            RcdFound72 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound72 = (short)(0) ;
      /* Using cursor T002511 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A83LegDedSec), Integer.valueOf(A83LegDedSec), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Integer.valueOf(A83LegDedSec), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A83LegDedSec), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T002511_A83LegDedSec[0] > A83LegDedSec ) || ( T002511_A83LegDedSec[0] == A83LegDedSec ) && ( T002511_A3CliCod[0] > A3CliCod ) || ( T002511_A3CliCod[0] == A3CliCod ) && ( T002511_A83LegDedSec[0] == A83LegDedSec ) && ( T002511_A1EmpCod[0] > A1EmpCod ) || ( T002511_A1EmpCod[0] == A1EmpCod ) && ( T002511_A3CliCod[0] == A3CliCod ) && ( T002511_A83LegDedSec[0] == A83LegDedSec ) && ( T002511_A6LegNumero[0] > A6LegNumero ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T002511_A83LegDedSec[0] < A83LegDedSec ) || ( T002511_A83LegDedSec[0] == A83LegDedSec ) && ( T002511_A3CliCod[0] < A3CliCod ) || ( T002511_A3CliCod[0] == A3CliCod ) && ( T002511_A83LegDedSec[0] == A83LegDedSec ) && ( T002511_A1EmpCod[0] < A1EmpCod ) || ( T002511_A1EmpCod[0] == A1EmpCod ) && ( T002511_A3CliCod[0] == A3CliCod ) && ( T002511_A83LegDedSec[0] == A83LegDedSec ) && ( T002511_A6LegNumero[0] < A6LegNumero ) ) )
         {
            A83LegDedSec = T002511_A83LegDedSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
            A3CliCod = T002511_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002511_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T002511_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            RcdFound72 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2572( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtLegDedConCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert2572( ) ;
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
               GX_FocusControl = edtLegDedConCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update2572( ) ;
               GX_FocusControl = edtLegDedConCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A83LegDedSec != Z83LegDedSec ) )
            {
               /* Insert record */
               GX_FocusControl = edtLegDedConCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert2572( ) ;
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
                  GX_FocusControl = edtLegDedConCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert2572( ) ;
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
         GX_FocusControl = edtLegDedConCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency2572( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00252 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A83LegDedSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"legajo_deducciones"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || !( GXutil.dateCompare(GXutil.resetTime(Z556LegDedFchDes), GXutil.resetTime(T00252_A556LegDedFchDes[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z557LegDedFchHas), GXutil.resetTime(T00252_A557LegDedFchHas[0])) ) || ( DecimalUtil.compareTo(Z560LegDedImporte, T00252_A560LegDedImporte[0]) != 0 ) || ( GXutil.strcmp(Z568LegDedDescrip, T00252_A568LegDedDescrip[0]) != 0 ) || ( GXutil.strcmp(Z84LegDedConCodigo, T00252_A84LegDedConCodigo[0]) != 0 ) )
         {
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z556LegDedFchDes), GXutil.resetTime(T00252_A556LegDedFchDes[0])) ) )
            {
               GXutil.writeLogln("deduccionessolapa:[seudo value changed for attri]"+"LegDedFchDes");
               GXutil.writeLogRaw("Old: ",Z556LegDedFchDes);
               GXutil.writeLogRaw("Current: ",T00252_A556LegDedFchDes[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z557LegDedFchHas), GXutil.resetTime(T00252_A557LegDedFchHas[0])) ) )
            {
               GXutil.writeLogln("deduccionessolapa:[seudo value changed for attri]"+"LegDedFchHas");
               GXutil.writeLogRaw("Old: ",Z557LegDedFchHas);
               GXutil.writeLogRaw("Current: ",T00252_A557LegDedFchHas[0]);
            }
            if ( DecimalUtil.compareTo(Z560LegDedImporte, T00252_A560LegDedImporte[0]) != 0 )
            {
               GXutil.writeLogln("deduccionessolapa:[seudo value changed for attri]"+"LegDedImporte");
               GXutil.writeLogRaw("Old: ",Z560LegDedImporte);
               GXutil.writeLogRaw("Current: ",T00252_A560LegDedImporte[0]);
            }
            if ( GXutil.strcmp(Z568LegDedDescrip, T00252_A568LegDedDescrip[0]) != 0 )
            {
               GXutil.writeLogln("deduccionessolapa:[seudo value changed for attri]"+"LegDedDescrip");
               GXutil.writeLogRaw("Old: ",Z568LegDedDescrip);
               GXutil.writeLogRaw("Current: ",T00252_A568LegDedDescrip[0]);
            }
            if ( GXutil.strcmp(Z84LegDedConCodigo, T00252_A84LegDedConCodigo[0]) != 0 )
            {
               GXutil.writeLogln("deduccionessolapa:[seudo value changed for attri]"+"LegDedConCodigo");
               GXutil.writeLogRaw("Old: ",Z84LegDedConCodigo);
               GXutil.writeLogRaw("Current: ",T00252_A84LegDedConCodigo[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"legajo_deducciones"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2572( )
   {
      beforeValidate2572( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2572( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2572( 0) ;
         checkOptimisticConcurrency2572( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2572( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2572( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002512 */
                  pr_default.execute(10, new Object[] {Integer.valueOf(A83LegDedSec), A556LegDedFchDes, A557LegDedFchHas, A560LegDedImporte, A568LegDedDescrip, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A84LegDedConCodigo});
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
                        resetCaption250( ) ;
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
            load2572( ) ;
         }
         endLevel2572( ) ;
      }
      closeExtendedTableCursors2572( ) ;
   }

   public void update2572( )
   {
      beforeValidate2572( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2572( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2572( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2572( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2572( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002513 */
                  pr_default.execute(11, new Object[] {A556LegDedFchDes, A557LegDedFchHas, A560LegDedImporte, A568LegDedDescrip, A84LegDedConCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A83LegDedSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_deducciones");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"legajo_deducciones"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2572( ) ;
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
         endLevel2572( ) ;
      }
      closeExtendedTableCursors2572( ) ;
   }

   public void deferredUpdate2572( )
   {
   }

   public void delete( )
   {
      beforeValidate2572( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2572( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2572( ) ;
         afterConfirm2572( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2572( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002514 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A83LegDedSec)});
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
      endLevel2572( ) ;
      Gx_mode = sMode72 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2572( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV28Pgmname = "deduccionesSolapa" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28Pgmname", AV28Pgmname);
         /* Using cursor T002515 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         A250LegIdNomApe = T002515_A250LegIdNomApe[0] ;
         A251LegNombre = T002515_A251LegNombre[0] ;
         A251LegNombre = T002515_A251LegNombre[0] ;
         A230LegApellido = T002515_A230LegApellido[0] ;
         A230LegApellido = T002515_A230LegApellido[0] ;
         A93LegId = T002515_A93LegId[0] ;
         n93LegId = T002515_n93LegId[0] ;
         A93LegId = T002515_A93LegId[0] ;
         n93LegId = T002515_n93LegId[0] ;
         pr_default.close(13);
         /* Using cursor T002516 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), A84LegDedConCodigo});
         A559LegDedConDescrip = T002516_A559LegDedConDescrip[0] ;
         pr_default.close(14);
         A570LegDedConCodYDesc = GXutil.trim( A84LegDedConCodigo) + " - " + GXutil.trim( A559LegDedConDescrip) ;
         httpContext.ajax_rsp_assign_attri("", false, "A570LegDedConCodYDesc", A570LegDedConCodYDesc);
      }
   }

   public void endLevel2572( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2572( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "deduccionessolapa");
         if ( AnyError == 0 )
         {
            confirmValues250( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "deduccionessolapa");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2572( )
   {
      /* Scan By routine */
      /* Using cursor T002517 */
      pr_default.execute(15);
      RcdFound72 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound72 = (short)(1) ;
         A3CliCod = T002517_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002517_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T002517_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A83LegDedSec = T002517_A83LegDedSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2572( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound72 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound72 = (short)(1) ;
         A3CliCod = T002517_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002517_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T002517_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A83LegDedSec = T002517_A83LegDedSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
      }
   }

   public void scanEnd2572( )
   {
      pr_default.close(15);
   }

   public void afterConfirm2572( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2572( )
   {
      /* Before Insert Rules */
      GXt_int8 = A83LegDedSec ;
      GXv_int9[0] = GXt_int8 ;
      new web.getnextdedsec(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, A6LegNumero, GXv_int9) ;
      deduccionessolapa_impl.this.GXt_int8 = GXv_int9[0] ;
      A83LegDedSec = GXt_int8 ;
      httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
   }

   public void beforeUpdate2572( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2572( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2572( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2572( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2572( )
   {
      edtLegDedConCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedConCodigo_Enabled), 5, 0), true);
      edtLegDedFchDes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedFchDes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedFchDes_Enabled), 5, 0), true);
      edtLegDedFchHas_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedFchHas_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedFchHas_Enabled), 5, 0), true);
      edtLegDedDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedDescrip_Enabled), 5, 0), true);
      edtLegDedImporte_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedImporte_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedImporte_Enabled), 5, 0), true);
      edtavCombolegdedconcodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombolegdedconcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombolegdedconcodigo_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      edtLegDedSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedSec_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes2572( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues250( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.deduccionessolapa", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LegDedSec,8,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LegNumero","LegDedSec"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"deduccionesSolapa");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("deduccionessolapa:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
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
      web.GxWebStd.gx_hidden_field( httpContext, "Z556LegDedFchDes", localUtil.dtoc( Z556LegDedFchDes, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z557LegDedFchHas", localUtil.dtoc( Z557LegDedFchHas, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z560LegDedImporte", GXutil.ltrim( localUtil.ntoc( Z560LegDedImporte, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z568LegDedDescrip", Z568LegDedDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z84LegDedConCodigo", GXutil.rtrim( Z84LegDedConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N84LegDedConCodigo", GXutil.rtrim( A84LegDedConCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGDEDCONCODIGO_DATA", AV24LegDedConCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGDEDCONCODIGO_DATA", AV24LegDedConCodigo_Data);
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
      web.GxWebStd.gx_hidden_field( httpContext, "LEGIDNOMAPE", A250LegIdNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNOMBRE", A251LegNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGAPELLIDO", A230LegApellido);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGID", GXutil.rtrim( A93LegId));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV28Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGDEDCONCODIGO_Objectcall", GXutil.rtrim( Combo_legdedconcodigo_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGDEDCONCODIGO_Cls", GXutil.rtrim( Combo_legdedconcodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGDEDCONCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_legdedconcodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGDEDCONCODIGO_Enabled", GXutil.booltostr( Combo_legdedconcodigo_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGDEDCONCODIGO_Emptyitem", GXutil.booltostr( Combo_legdedconcodigo_Emptyitem));
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
      return formatLink("web.deduccionessolapa", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LegDedSec,8,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LegNumero","LegDedSec"})  ;
   }

   public String getPgmname( )
   {
      return "deduccionesSolapa" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "deducciones Solapa", "") ;
   }

   public void initializeNonKey2572( )
   {
      A84LegDedConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A84LegDedConCodigo", A84LegDedConCodigo);
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
      A251LegNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A251LegNombre", A251LegNombre);
      A230LegApellido = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A230LegApellido", A230LegApellido);
      A93LegId = "" ;
      n93LegId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A93LegId", A93LegId);
      Z556LegDedFchDes = GXutil.nullDate() ;
      Z557LegDedFchHas = GXutil.nullDate() ;
      Z560LegDedImporte = DecimalUtil.ZERO ;
      Z568LegDedDescrip = "" ;
      Z84LegDedConCodigo = "" ;
   }

   public void initAll2572( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A6LegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      A83LegDedSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A83LegDedSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A83LegDedSec), 8, 0));
      initializeNonKey2572( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713344413", true, true);
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
      httpContext.AddJavascriptSource("deduccionessolapa.js", "?20251713344413", false, true);
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
      lblTextblocklegdedconcodigo_Internalname = "TEXTBLOCKLEGDEDCONCODIGO" ;
      Combo_legdedconcodigo_Internalname = "COMBO_LEGDEDCONCODIGO" ;
      edtLegDedConCodigo_Internalname = "LEGDEDCONCODIGO" ;
      divTablesplittedlegdedconcodigo_Internalname = "TABLESPLITTEDLEGDEDCONCODIGO" ;
      edtLegDedFchDes_Internalname = "LEGDEDFCHDES" ;
      edtLegDedFchHas_Internalname = "LEGDEDFCHHAS" ;
      edtLegDedDescrip_Internalname = "LEGDEDDESCRIP" ;
      edtLegDedImporte_Internalname = "LEGDEDIMPORTE" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombolegdedconcodigo_Internalname = "vCOMBOLEGDEDCONCODIGO" ;
      divSectionattribute_legdedconcodigo_Internalname = "SECTIONATTRIBUTE_LEGDEDCONCODIGO" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtLegNumero_Internalname = "LEGNUMERO" ;
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "deducciones Solapa", "") );
      edtLegDedSec_Jsonclick = "" ;
      edtLegDedSec_Enabled = 1 ;
      edtLegDedSec_Visible = 1 ;
      edtLegNumero_Jsonclick = "" ;
      edtLegNumero_Enabled = 1 ;
      edtLegNumero_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavCombolegdedconcodigo_Jsonclick = "" ;
      edtavCombolegdedconcodigo_Enabled = 0 ;
      edtavCombolegdedconcodigo_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtLegDedImporte_Jsonclick = "" ;
      edtLegDedImporte_Enabled = 1 ;
      edtLegDedDescrip_Enabled = 1 ;
      edtLegDedFchHas_Jsonclick = "" ;
      edtLegDedFchHas_Enabled = 1 ;
      edtLegDedFchDes_Jsonclick = "" ;
      edtLegDedFchDes_Enabled = 1 ;
      edtLegDedConCodigo_Jsonclick = "" ;
      edtLegDedConCodigo_Enabled = 1 ;
      edtLegDedConCodigo_Visible = 1 ;
      Combo_legdedconcodigo_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_legdedconcodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_legdedconcodigo_Enabled = GXutil.toBoolean( -1) ;
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

   public void gx4asaclicod2572( int AV7CliCod )
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
            GXt_int8 = A3CliCod ;
            GXv_int9[0] = GXt_int8 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int9) ;
            deduccionessolapa_impl.this.GXt_int8 = GXv_int9[0] ;
            A3CliCod = GXt_int8 ;
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

   public void gx10asalegdedsec2572( int AV10LegDedSec )
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

   public void gx11asalegdedsec2572( int AV7CliCod ,
                                     short AV8EmpCod ,
                                     int A6LegNumero )
   {
      GXt_int8 = A83LegDedSec ;
      GXv_int9[0] = GXt_int8 ;
      new web.getnextdedsec(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, A6LegNumero, GXv_int9) ;
      deduccionessolapa_impl.this.GXt_int8 = GXv_int9[0] ;
      A83LegDedSec = GXt_int8 ;
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

   public void valid_Legnumero( )
   {
      n93LegId = false ;
      /* Using cursor T002515 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A250LegIdNomApe = T002515_A250LegIdNomApe[0] ;
      A251LegNombre = T002515_A251LegNombre[0] ;
      A251LegNombre = T002515_A251LegNombre[0] ;
      A230LegApellido = T002515_A230LegApellido[0] ;
      A230LegApellido = T002515_A230LegApellido[0] ;
      A93LegId = T002515_A93LegId[0] ;
      n93LegId = T002515_n93LegId[0] ;
      A93LegId = T002515_A93LegId[0] ;
      n93LegId = T002515_n93LegId[0] ;
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A250LegIdNomApe", A250LegIdNomApe);
      httpContext.ajax_rsp_assign_attri("", false, "A251LegNombre", A251LegNombre);
      httpContext.ajax_rsp_assign_attri("", false, "A230LegApellido", A230LegApellido);
      httpContext.ajax_rsp_assign_attri("", false, "A93LegId", GXutil.rtrim( A93LegId));
   }

   public void valid_Legdedconcodigo( )
   {
      /* Using cursor T002516 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), A84LegDedConCodigo});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Deduccion Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGDEDCONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A559LegDedConDescrip = T002516_A559LegDedConDescrip[0] ;
      pr_default.close(14);
      A570LegDedConCodYDesc = GXutil.trim( A84LegDedConCodigo) + " - " + GXutil.trim( A559LegDedConDescrip) ;
      if ( (GXutil.strcmp("", A84LegDedConCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), 1, "LEGDEDCONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegDedConCodigo_Internalname ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV10LegDedSec',fld:'vLEGDEDSEC',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12252',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_LEGDEDCONCODIGO","{handler:'valid_Legdedconcodigo',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A84LegDedConCodigo',fld:'LEGDEDCONCODIGO',pic:''},{av:'A559LegDedConDescrip',fld:'LEGDEDCONDESCRIP',pic:''},{av:'A570LegDedConCodYDesc',fld:'LEGDEDCONCODYDESC',pic:''}]");
      setEventMetadata("VALID_LEGDEDCONCODIGO",",oparms:[{av:'A559LegDedConDescrip',fld:'LEGDEDCONDESCRIP',pic:''},{av:'A570LegDedConCodYDesc',fld:'LEGDEDCONCODYDESC',pic:''}]}");
      setEventMetadata("VALID_LEGDEDFCHDES","{handler:'valid_Legdedfchdes',iparms:[]");
      setEventMetadata("VALID_LEGDEDFCHDES",",oparms:[]}");
      setEventMetadata("VALID_LEGDEDFCHHAS","{handler:'valid_Legdedfchhas',iparms:[]");
      setEventMetadata("VALID_LEGDEDFCHHAS",",oparms:[]}");
      setEventMetadata("VALID_LEGDEDIMPORTE","{handler:'valid_Legdedimporte',iparms:[]");
      setEventMetadata("VALID_LEGDEDIMPORTE",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOLEGDEDCONCODIGO","{handler:'validv_Combolegdedconcodigo',iparms:[]");
      setEventMetadata("VALIDV_COMBOLEGDEDCONCODIGO",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A251LegNombre',fld:'LEGNOMBRE',pic:''},{av:'A230LegApellido',fld:'LEGAPELLIDO',pic:''},{av:'A93LegId',fld:'LEGID',pic:''}]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A251LegNombre',fld:'LEGNOMBRE',pic:''},{av:'A230LegApellido',fld:'LEGAPELLIDO',pic:''},{av:'A93LegId',fld:'LEGID',pic:''}]}");
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
      pr_default.close(13);
      pr_default.close(14);
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
      Z84LegDedConCodigo = "" ;
      N84LegDedConCodigo = "" ;
      Combo_legdedconcodigo_Selectedvalue_get = "" ;
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
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblocklegdedconcodigo_Jsonclick = "" ;
      ucCombo_legdedconcodigo = new com.genexus.webpanels.GXUserControl();
      Combo_legdedconcodigo_Caption = "" ;
      AV24LegDedConCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A556LegDedFchDes = GXutil.nullDate() ;
      A557LegDedFchHas = GXutil.nullDate() ;
      ClassString = "" ;
      StyleString = "" ;
      A568LegDedDescrip = "" ;
      A560LegDedImporte = DecimalUtil.ZERO ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV25ComboLegDedConCodigo = "" ;
      A559LegDedConDescrip = "" ;
      A570LegDedConCodYDesc = "" ;
      AV16Insert_LegDedConCodigo = "" ;
      A250LegIdNomApe = "" ;
      A251LegNombre = "" ;
      A230LegApellido = "" ;
      A93LegId = "" ;
      AV28Pgmname = "" ;
      Combo_legdedconcodigo_Objectcall = "" ;
      Combo_legdedconcodigo_Class = "" ;
      Combo_legdedconcodigo_Icontype = "" ;
      Combo_legdedconcodigo_Icon = "" ;
      Combo_legdedconcodigo_Tooltip = "" ;
      Combo_legdedconcodigo_Selectedvalue_set = "" ;
      Combo_legdedconcodigo_Selectedtext_set = "" ;
      Combo_legdedconcodigo_Selectedtext_get = "" ;
      Combo_legdedconcodigo_Gamoauthtoken = "" ;
      Combo_legdedconcodigo_Ddointernalname = "" ;
      Combo_legdedconcodigo_Titlecontrolalign = "" ;
      Combo_legdedconcodigo_Dropdownoptionstype = "" ;
      Combo_legdedconcodigo_Titlecontrolidtoreplace = "" ;
      Combo_legdedconcodigo_Datalisttype = "" ;
      Combo_legdedconcodigo_Datalistfixedvalues = "" ;
      Combo_legdedconcodigo_Datalistproc = "" ;
      Combo_legdedconcodigo_Datalistprocparametersprefix = "" ;
      Combo_legdedconcodigo_Remoteservicesparameters = "" ;
      Combo_legdedconcodigo_Htmltemplate = "" ;
      Combo_legdedconcodigo_Multiplevaluestype = "" ;
      Combo_legdedconcodigo_Loadingdata = "" ;
      Combo_legdedconcodigo_Noresultsfound = "" ;
      Combo_legdedconcodigo_Emptyitemtext = "" ;
      Combo_legdedconcodigo_Onlyselectedvalues = "" ;
      Combo_legdedconcodigo_Selectalltext = "" ;
      Combo_legdedconcodigo_Multiplevaluesseparator = "" ;
      Combo_legdedconcodigo_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
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
      GXv_boolean3 = new boolean[1] ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      AV17TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV27SubTipoConCod1 = "" ;
      GXt_char4 = "" ;
      GXt_objcol_SdtDVB_SDTComboData_Item6 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV20ComboSelectedValue = "" ;
      GXv_char5 = new String[1] ;
      GXv_objcol_SdtDVB_SDTComboData_Item7 = new GXBaseCollection[1] ;
      Z250LegIdNomApe = "" ;
      Z251LegNombre = "" ;
      Z230LegApellido = "" ;
      Z93LegId = "" ;
      Z559LegDedConDescrip = "" ;
      T00254_A250LegIdNomApe = new String[] {""} ;
      T00254_A251LegNombre = new String[] {""} ;
      T00254_A230LegApellido = new String[] {""} ;
      T00254_A93LegId = new String[] {""} ;
      T00254_n93LegId = new boolean[] {false} ;
      T00255_A559LegDedConDescrip = new String[] {""} ;
      T00256_A250LegIdNomApe = new String[] {""} ;
      T00256_A83LegDedSec = new int[1] ;
      T00256_A556LegDedFchDes = new java.util.Date[] {GXutil.nullDate()} ;
      T00256_A557LegDedFchHas = new java.util.Date[] {GXutil.nullDate()} ;
      T00256_A559LegDedConDescrip = new String[] {""} ;
      T00256_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00256_A568LegDedDescrip = new String[] {""} ;
      T00256_A251LegNombre = new String[] {""} ;
      T00256_A230LegApellido = new String[] {""} ;
      T00256_A93LegId = new String[] {""} ;
      T00256_n93LegId = new boolean[] {false} ;
      T00256_A3CliCod = new int[1] ;
      T00256_A1EmpCod = new short[1] ;
      T00256_A6LegNumero = new int[1] ;
      T00256_A84LegDedConCodigo = new String[] {""} ;
      T00257_A559LegDedConDescrip = new String[] {""} ;
      T00258_A250LegIdNomApe = new String[] {""} ;
      T00258_A251LegNombre = new String[] {""} ;
      T00258_A230LegApellido = new String[] {""} ;
      T00258_A93LegId = new String[] {""} ;
      T00258_n93LegId = new boolean[] {false} ;
      T00259_A3CliCod = new int[1] ;
      T00259_A1EmpCod = new short[1] ;
      T00259_A6LegNumero = new int[1] ;
      T00259_A83LegDedSec = new int[1] ;
      T00253_A83LegDedSec = new int[1] ;
      T00253_A556LegDedFchDes = new java.util.Date[] {GXutil.nullDate()} ;
      T00253_A557LegDedFchHas = new java.util.Date[] {GXutil.nullDate()} ;
      T00253_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00253_A568LegDedDescrip = new String[] {""} ;
      T00253_A3CliCod = new int[1] ;
      T00253_A1EmpCod = new short[1] ;
      T00253_A6LegNumero = new int[1] ;
      T00253_A84LegDedConCodigo = new String[] {""} ;
      T002510_A83LegDedSec = new int[1] ;
      T002510_A3CliCod = new int[1] ;
      T002510_A1EmpCod = new short[1] ;
      T002510_A6LegNumero = new int[1] ;
      T002511_A83LegDedSec = new int[1] ;
      T002511_A3CliCod = new int[1] ;
      T002511_A1EmpCod = new short[1] ;
      T002511_A6LegNumero = new int[1] ;
      T00252_A83LegDedSec = new int[1] ;
      T00252_A556LegDedFchDes = new java.util.Date[] {GXutil.nullDate()} ;
      T00252_A557LegDedFchHas = new java.util.Date[] {GXutil.nullDate()} ;
      T00252_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00252_A568LegDedDescrip = new String[] {""} ;
      T00252_A3CliCod = new int[1] ;
      T00252_A1EmpCod = new short[1] ;
      T00252_A6LegNumero = new int[1] ;
      T00252_A84LegDedConCodigo = new String[] {""} ;
      T002515_A250LegIdNomApe = new String[] {""} ;
      T002515_A251LegNombre = new String[] {""} ;
      T002515_A230LegApellido = new String[] {""} ;
      T002515_A93LegId = new String[] {""} ;
      T002515_n93LegId = new boolean[] {false} ;
      T002516_A559LegDedConDescrip = new String[] {""} ;
      T002517_A3CliCod = new int[1] ;
      T002517_A1EmpCod = new short[1] ;
      T002517_A6LegNumero = new int[1] ;
      T002517_A83LegDedSec = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXv_int9 = new int[1] ;
      Z570LegDedConCodYDesc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.deduccionessolapa__default(),
         new Object[] {
             new Object[] {
            T00252_A83LegDedSec, T00252_A556LegDedFchDes, T00252_A557LegDedFchHas, T00252_A560LegDedImporte, T00252_A568LegDedDescrip, T00252_A3CliCod, T00252_A1EmpCod, T00252_A6LegNumero, T00252_A84LegDedConCodigo
            }
            , new Object[] {
            T00253_A83LegDedSec, T00253_A556LegDedFchDes, T00253_A557LegDedFchHas, T00253_A560LegDedImporte, T00253_A568LegDedDescrip, T00253_A3CliCod, T00253_A1EmpCod, T00253_A6LegNumero, T00253_A84LegDedConCodigo
            }
            , new Object[] {
            T00254_A250LegIdNomApe, T00254_A251LegNombre, T00254_A230LegApellido, T00254_A93LegId, T00254_n93LegId
            }
            , new Object[] {
            T00255_A559LegDedConDescrip
            }
            , new Object[] {
            T00256_A250LegIdNomApe, T00256_A83LegDedSec, T00256_A556LegDedFchDes, T00256_A557LegDedFchHas, T00256_A559LegDedConDescrip, T00256_A560LegDedImporte, T00256_A568LegDedDescrip, T00256_A251LegNombre, T00256_A230LegApellido, T00256_A93LegId,
            T00256_n93LegId, T00256_A3CliCod, T00256_A1EmpCod, T00256_A6LegNumero, T00256_A84LegDedConCodigo
            }
            , new Object[] {
            T00257_A559LegDedConDescrip
            }
            , new Object[] {
            T00258_A250LegIdNomApe, T00258_A251LegNombre, T00258_A230LegApellido, T00258_A93LegId, T00258_n93LegId
            }
            , new Object[] {
            T00259_A3CliCod, T00259_A1EmpCod, T00259_A6LegNumero, T00259_A83LegDedSec
            }
            , new Object[] {
            T002510_A83LegDedSec, T002510_A3CliCod, T002510_A1EmpCod, T002510_A6LegNumero
            }
            , new Object[] {
            T002511_A83LegDedSec, T002511_A3CliCod, T002511_A1EmpCod, T002511_A6LegNumero
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002515_A250LegIdNomApe, T002515_A251LegNombre, T002515_A230LegApellido, T002515_A93LegId, T002515_n93LegId
            }
            , new Object[] {
            T002516_A559LegDedConDescrip
            }
            , new Object[] {
            T002517_A3CliCod, T002517_A1EmpCod, T002517_A6LegNumero, T002517_A83LegDedSec
            }
         }
      );
      AV28Pgmname = "deduccionesSolapa" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8EmpCod ;
   private short Z1EmpCod ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound72 ;
   private short nIsDirty_72 ;
   private int wcpOAV7CliCod ;
   private int wcpOAV9LegNumero ;
   private int wcpOAV10LegDedSec ;
   private int Z3CliCod ;
   private int Z6LegNumero ;
   private int Z83LegDedSec ;
   private int AV7CliCod ;
   private int AV10LegDedSec ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int AV9LegNumero ;
   private int trnEnded ;
   private int edtLegDedConCodigo_Visible ;
   private int edtLegDedConCodigo_Enabled ;
   private int edtLegDedFchDes_Enabled ;
   private int edtLegDedFchHas_Enabled ;
   private int edtLegDedDescrip_Enabled ;
   private int edtLegDedImporte_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombolegdedconcodigo_Visible ;
   private int edtavCombolegdedconcodigo_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int edtLegNumero_Visible ;
   private int edtLegNumero_Enabled ;
   private int A83LegDedSec ;
   private int edtLegDedSec_Visible ;
   private int edtLegDedSec_Enabled ;
   private int Combo_legdedconcodigo_Datalistupdateminimumcharacters ;
   private int Combo_legdedconcodigo_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV29GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private int GXt_int8 ;
   private int GXv_int9[] ;
   private java.math.BigDecimal Z560LegDedImporte ;
   private java.math.BigDecimal A560LegDedImporte ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z84LegDedConCodigo ;
   private String N84LegDedConCodigo ;
   private String Combo_legdedconcodigo_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A84LegDedConCodigo ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtLegDedConCodigo_Internalname ;
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
   private String divTablesplittedlegdedconcodigo_Internalname ;
   private String lblTextblocklegdedconcodigo_Internalname ;
   private String lblTextblocklegdedconcodigo_Jsonclick ;
   private String Combo_legdedconcodigo_Caption ;
   private String Combo_legdedconcodigo_Cls ;
   private String Combo_legdedconcodigo_Internalname ;
   private String TempTags ;
   private String edtLegDedConCodigo_Jsonclick ;
   private String edtLegDedFchDes_Internalname ;
   private String edtLegDedFchDes_Jsonclick ;
   private String edtLegDedFchHas_Internalname ;
   private String edtLegDedFchHas_Jsonclick ;
   private String edtLegDedDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtLegDedImporte_Internalname ;
   private String edtLegDedImporte_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_legdedconcodigo_Internalname ;
   private String edtavCombolegdedconcodigo_Internalname ;
   private String AV25ComboLegDedConCodigo ;
   private String edtavCombolegdedconcodigo_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtLegNumero_Internalname ;
   private String edtLegNumero_Jsonclick ;
   private String edtLegDedSec_Internalname ;
   private String edtLegDedSec_Jsonclick ;
   private String AV16Insert_LegDedConCodigo ;
   private String A93LegId ;
   private String AV28Pgmname ;
   private String Combo_legdedconcodigo_Objectcall ;
   private String Combo_legdedconcodigo_Class ;
   private String Combo_legdedconcodigo_Icontype ;
   private String Combo_legdedconcodigo_Icon ;
   private String Combo_legdedconcodigo_Tooltip ;
   private String Combo_legdedconcodigo_Selectedvalue_set ;
   private String Combo_legdedconcodigo_Selectedtext_set ;
   private String Combo_legdedconcodigo_Selectedtext_get ;
   private String Combo_legdedconcodigo_Gamoauthtoken ;
   private String Combo_legdedconcodigo_Ddointernalname ;
   private String Combo_legdedconcodigo_Titlecontrolalign ;
   private String Combo_legdedconcodigo_Dropdownoptionstype ;
   private String Combo_legdedconcodigo_Titlecontrolidtoreplace ;
   private String Combo_legdedconcodigo_Datalisttype ;
   private String Combo_legdedconcodigo_Datalistfixedvalues ;
   private String Combo_legdedconcodigo_Datalistproc ;
   private String Combo_legdedconcodigo_Datalistprocparametersprefix ;
   private String Combo_legdedconcodigo_Remoteservicesparameters ;
   private String Combo_legdedconcodigo_Htmltemplate ;
   private String Combo_legdedconcodigo_Multiplevaluestype ;
   private String Combo_legdedconcodigo_Loadingdata ;
   private String Combo_legdedconcodigo_Noresultsfound ;
   private String Combo_legdedconcodigo_Emptyitemtext ;
   private String Combo_legdedconcodigo_Onlyselectedvalues ;
   private String Combo_legdedconcodigo_Selectalltext ;
   private String Combo_legdedconcodigo_Multiplevaluesseparator ;
   private String Combo_legdedconcodigo_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode72 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV27SubTipoConCod1 ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private String Z93LegId ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
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
   private boolean Combo_legdedconcodigo_Emptyitem ;
   private boolean n93LegId ;
   private boolean Combo_legdedconcodigo_Enabled ;
   private boolean Combo_legdedconcodigo_Visible ;
   private boolean Combo_legdedconcodigo_Allowmultipleselection ;
   private boolean Combo_legdedconcodigo_Isgriditem ;
   private boolean Combo_legdedconcodigo_Hasdescription ;
   private boolean Combo_legdedconcodigo_Includeonlyselectedoption ;
   private boolean Combo_legdedconcodigo_Includeselectalloption ;
   private boolean Combo_legdedconcodigo_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String Z568LegDedDescrip ;
   private String A568LegDedDescrip ;
   private String A559LegDedConDescrip ;
   private String A570LegDedConCodYDesc ;
   private String A250LegIdNomApe ;
   private String A251LegNombre ;
   private String A230LegApellido ;
   private String AV20ComboSelectedValue ;
   private String Z250LegIdNomApe ;
   private String Z251LegNombre ;
   private String Z230LegApellido ;
   private String Z559LegDedConDescrip ;
   private String Z570LegDedConCodYDesc ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_legdedconcodigo ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T00254_A250LegIdNomApe ;
   private String[] T00254_A251LegNombre ;
   private String[] T00254_A230LegApellido ;
   private String[] T00254_A93LegId ;
   private boolean[] T00254_n93LegId ;
   private String[] T00255_A559LegDedConDescrip ;
   private String[] T00256_A250LegIdNomApe ;
   private int[] T00256_A83LegDedSec ;
   private java.util.Date[] T00256_A556LegDedFchDes ;
   private java.util.Date[] T00256_A557LegDedFchHas ;
   private String[] T00256_A559LegDedConDescrip ;
   private java.math.BigDecimal[] T00256_A560LegDedImporte ;
   private String[] T00256_A568LegDedDescrip ;
   private String[] T00256_A251LegNombre ;
   private String[] T00256_A230LegApellido ;
   private String[] T00256_A93LegId ;
   private boolean[] T00256_n93LegId ;
   private int[] T00256_A3CliCod ;
   private short[] T00256_A1EmpCod ;
   private int[] T00256_A6LegNumero ;
   private String[] T00256_A84LegDedConCodigo ;
   private String[] T00257_A559LegDedConDescrip ;
   private String[] T00258_A250LegIdNomApe ;
   private String[] T00258_A251LegNombre ;
   private String[] T00258_A230LegApellido ;
   private String[] T00258_A93LegId ;
   private boolean[] T00258_n93LegId ;
   private int[] T00259_A3CliCod ;
   private short[] T00259_A1EmpCod ;
   private int[] T00259_A6LegNumero ;
   private int[] T00259_A83LegDedSec ;
   private int[] T00253_A83LegDedSec ;
   private java.util.Date[] T00253_A556LegDedFchDes ;
   private java.util.Date[] T00253_A557LegDedFchHas ;
   private java.math.BigDecimal[] T00253_A560LegDedImporte ;
   private String[] T00253_A568LegDedDescrip ;
   private int[] T00253_A3CliCod ;
   private short[] T00253_A1EmpCod ;
   private int[] T00253_A6LegNumero ;
   private String[] T00253_A84LegDedConCodigo ;
   private int[] T002510_A83LegDedSec ;
   private int[] T002510_A3CliCod ;
   private short[] T002510_A1EmpCod ;
   private int[] T002510_A6LegNumero ;
   private int[] T002511_A83LegDedSec ;
   private int[] T002511_A3CliCod ;
   private short[] T002511_A1EmpCod ;
   private int[] T002511_A6LegNumero ;
   private int[] T00252_A83LegDedSec ;
   private java.util.Date[] T00252_A556LegDedFchDes ;
   private java.util.Date[] T00252_A557LegDedFchHas ;
   private java.math.BigDecimal[] T00252_A560LegDedImporte ;
   private String[] T00252_A568LegDedDescrip ;
   private int[] T00252_A3CliCod ;
   private short[] T00252_A1EmpCod ;
   private int[] T00252_A6LegNumero ;
   private String[] T00252_A84LegDedConCodigo ;
   private String[] T002515_A250LegIdNomApe ;
   private String[] T002515_A251LegNombre ;
   private String[] T002515_A230LegApellido ;
   private String[] T002515_A93LegId ;
   private boolean[] T002515_n93LegId ;
   private String[] T002516_A559LegDedConDescrip ;
   private int[] T002517_A3CliCod ;
   private short[] T002517_A1EmpCod ;
   private int[] T002517_A6LegNumero ;
   private int[] T002517_A83LegDedSec ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV24LegDedConCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXt_objcol_SdtDVB_SDTComboData_Item6 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXv_objcol_SdtDVB_SDTComboData_Item7[] ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV17TrnContextAtt ;
}

final  class deduccionessolapa__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00252", "SELECT LegDedSec, LegDedFchDes, LegDedFchHas, LegDedImporte, LegDedDescrip, CliCod, EmpCod, LegNumero, LegDedConCodigo FROM legajo_deducciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ?  FOR UPDATE OF legajo_deducciones NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00253", "SELECT LegDedSec, LegDedFchDes, LegDedFchHas, LegDedImporte, LegDedDescrip, CliCod, EmpCod, LegNumero, LegDedConCodigo FROM legajo_deducciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00254", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00255", "SELECT ConDescrip AS LegDedConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00256", "SELECT T2.LegIdNomApe, TM1.LegDedSec, TM1.LegDedFchDes, TM1.LegDedFchHas, T3.ConDescrip AS LegDedConDescrip, TM1.LegDedImporte, TM1.LegDedDescrip, T2.LegNombre, T2.LegApellido, T2.LegId, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegDedConCodigo AS LegDedConCodigo FROM ((legajo_deducciones TM1 INNER JOIN Legajo T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod AND T2.LegNumero = TM1.LegNumero) INNER JOIN Concepto T3 ON T3.CliCod = TM1.CliCod AND T3.ConCodigo = TM1.LegDedConCodigo) WHERE TM1.LegDedSec = ? and TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegDedSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00257", "SELECT ConDescrip AS LegDedConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00258", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00259", "SELECT CliCod, EmpCod, LegNumero, LegDedSec FROM legajo_deducciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002510", "SELECT LegDedSec, CliCod, EmpCod, LegNumero FROM legajo_deducciones WHERE ( LegDedSec > ? or LegDedSec = ? and CliCod > ? or CliCod = ? and LegDedSec = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and LegDedSec = ? and LegNumero > ?) ORDER BY CliCod, EmpCod, LegNumero, LegDedSec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002511", "SELECT LegDedSec, CliCod, EmpCod, LegNumero FROM legajo_deducciones WHERE ( LegDedSec < ? or LegDedSec = ? and CliCod < ? or CliCod = ? and LegDedSec = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and LegDedSec = ? and LegNumero < ?) ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LegDedSec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T002512", "SAVEPOINT gxupdate;INSERT INTO legajo_deducciones(LegDedSec, LegDedFchDes, LegDedFchHas, LegDedImporte, LegDedDescrip, CliCod, EmpCod, LegNumero, LegDedConCodigo, LegDedMes, LegDedAnio, LegDedCodSiradig, LegDedCodMot, LegDedUsado, LegDedNroLiq, LegDedTipo, LegDedFile, LegDedFileNom, LegDedFileExt) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0, 0, '', 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002513", "SAVEPOINT gxupdate;UPDATE legajo_deducciones SET LegDedFchDes=?, LegDedFchHas=?, LegDedImporte=?, LegDedDescrip=?, LegDedConCodigo=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002514", "SAVEPOINT gxupdate;DELETE FROM legajo_deducciones  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002515", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002516", "SELECT ConDescrip AS LegDedConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002517", "SELECT CliCod, EmpCod, LegNumero, LegDedSec FROM legajo_deducciones ORDER BY CliCod, EmpCod, LegNumero, LegDedSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 10);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 10);
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
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((int[]) buf[11])[0] = rslt.getInt(11);
               ((short[]) buf[12])[0] = rslt.getShort(12);
               ((int[]) buf[13])[0] = rslt.getInt(13);
               ((String[]) buf[14])[0] = rslt.getString(14, 10);
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
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 15 :
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
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 10);
               return;
            case 11 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setString(5, (String)parms[4], 10);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

