package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class paistipotrabajo_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action12") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV24CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24CliCod), 6, 0));
         A2055PaiTipoTraRelSec = (int)(GXutil.lval( httpContext.GetPar( "PaiTipoTraRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2055PaiTipoTraRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2055PaiTipoTraRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_12_3R155( Gx_mode, AV24CliCod, A2055PaiTipoTraRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"PAITIPOTRARELSEC") == 0 )
      {
         AV24CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlapaitipotrarelsec3R155( AV24CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel7"+"_"+"PAITIPOTRAOLDDEFAULT") == 0 )
      {
         A1337PaiTipoHsSem = CommonUtil.decimalVal( httpContext.GetPar( "PaiTipoHsSem"), ".") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1337PaiTipoHsSem", GXutil.ltrimstr( A1337PaiTipoHsSem, 4, 1));
         A1338PaiTipoTarifaXLim = CommonUtil.decimalVal( httpContext.GetPar( "PaiTipoTarifaXLim"), ".") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1338PaiTipoTarifaXLim", GXutil.ltrimstr( A1338PaiTipoTarifaXLim, 6, 4));
         A1347PaiTipoTarifaRec = CommonUtil.decimalVal( httpContext.GetPar( "PaiTipoTarifaRec"), ".") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1347PaiTipoTarifaRec", GXutil.ltrimstr( A1347PaiTipoTarifaRec, 6, 4));
         A1383PaiTipoHsMaxDia = CommonUtil.decimalVal( httpContext.GetPar( "PaiTipoHsMaxDia"), ".") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1383PaiTipoHsMaxDia", GXutil.ltrimstr( A1383PaiTipoHsMaxDia, 3, 1));
         A1384PaiTipoHsMaxSem = CommonUtil.decimalVal( httpContext.GetPar( "PaiTipoHsMaxSem"), ".") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1384PaiTipoHsMaxSem", GXutil.ltrimstr( A1384PaiTipoHsMaxSem, 4, 1));
         A1385PaiTipoHsMaxMes = CommonUtil.decimalVal( httpContext.GetPar( "PaiTipoHsMaxMes"), ".") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1385PaiTipoHsMaxMes", GXutil.ltrimstr( A1385PaiTipoHsMaxMes, 5, 1));
         A1390PaiTipoHsMaxAnu = CommonUtil.decimalVal( httpContext.GetPar( "PaiTipoHsMaxAnu"), ".") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1390PaiTipoHsMaxAnu", GXutil.ltrimstr( A1390PaiTipoHsMaxAnu, 5, 1));
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A1336PaiTipoHsDia = CommonUtil.decimalVal( httpContext.GetPar( "PaiTipoHsDia"), ".") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1336PaiTipoHsDia", GXutil.ltrimstr( A1336PaiTipoHsDia, 3, 1));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx7asapaitipotraolddefault3R155( A1337PaiTipoHsSem, A1338PaiTipoTarifaXLim, A1347PaiTipoTarifaRec, A1383PaiTipoHsMaxDia, A1384PaiTipoHsMaxSem, A1385PaiTipoHsMaxMes, A1390PaiTipoHsMaxAnu, Gx_mode, A1336PaiTipoHsDia) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_15") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_15( A46PaiCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_16") == 0 )
      {
         A1294PaiTipoTraId = httpContext.GetPar( "PaiTipoTraId") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_16( A1294PaiTipoTraId) ;
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
            AV8PaiTipoTraId = httpContext.GetPar( "PaiTipoTraId") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8PaiTipoTraId", AV8PaiTipoTraId);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAITIPOTRAID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8PaiTipoTraId, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Pais Tipo Trabajo", ""), (short)(0)) ;
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

   public paistipotrabajo_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public paistipotrabajo_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paistipotrabajo_impl.class ));
   }

   public paistipotrabajo_impl( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbPaiTipoTraId = new HTMLChoice();
      chkPaiTipoTraIns = UIFactory.getCheckbox(this);
      cmbPaiTipoHsMaxMes = new HTMLChoice();
      dynPaiTipoTraRelSec = new HTMLChoice();
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
      A1297PaiTipoTraIns = GXutil.strtobool( GXutil.booltostr( A1297PaiTipoTraIns)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1297PaiTipoTraIns", A1297PaiTipoTraIns);
      if ( cmbPaiTipoHsMaxMes.getItemCount() > 0 )
      {
         A1385PaiTipoHsMaxMes = DecimalUtil.stringToDec( cmbPaiTipoHsMaxMes.getValidValue(GXutil.strNoRound( A1385PaiTipoHsMaxMes, 5, 1))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1385PaiTipoHsMaxMes", GXutil.ltrimstr( A1385PaiTipoHsMaxMes, 5, 1));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPaiTipoHsMaxMes.setValue( GXutil.strNoRound( A1385PaiTipoHsMaxMes, 5, 1) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiTipoHsMaxMes.getInternalname(), "Values", cmbPaiTipoHsMaxMes.ToJavascriptSource(), true);
      }
      if ( dynPaiTipoTraRelSec.getItemCount() > 0 )
      {
         A2055PaiTipoTraRelSec = (int)(GXutil.lval( dynPaiTipoTraRelSec.getValidValue(GXutil.trim( GXutil.str( A2055PaiTipoTraRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2055PaiTipoTraRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2055PaiTipoTraRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynPaiTipoTraRelSec.setValue( GXutil.trim( GXutil.str( A2055PaiTipoTraRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynPaiTipoTraRelSec.getInternalname(), "Values", dynPaiTipoTraRelSec.ToJavascriptSource(), true);
      }
      if ( cmbavCombopaitipotraid.getItemCount() > 0 )
      {
         AV21ComboPaiTipoTraId = cmbavCombopaitipotraid.getValidValue(AV21ComboPaiTipoTraId) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21ComboPaiTipoTraId", AV21ComboPaiTipoTraId);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavCombopaitipotraid.setValue( GXutil.rtrim( AV21ComboPaiTipoTraId) );
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedpaicod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockpaicod_Internalname, httpContext.getMessage( "Pais", ""), "", "", lblTextblockpaicod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_PaisTipoTrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_paicod.setProperty("Caption", Combo_paicod_Caption);
      ucCombo_paicod.setProperty("Cls", Combo_paicod_Cls);
      ucCombo_paicod.setProperty("DataListProc", Combo_paicod_Datalistproc);
      ucCombo_paicod.setProperty("DataListProcParametersPrefix", Combo_paicod_Datalistprocparametersprefix);
      ucCombo_paicod.setProperty("EmptyItem", Combo_paicod_Emptyitem);
      ucCombo_paicod.setProperty("DropDownOptionsTitleSettingsIcons", AV15DDO_TitleSettingsIcons);
      ucCombo_paicod.setProperty("DropDownOptionsData", AV14PaiCod_Data);
      ucCombo_paicod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_paicod_Internalname, "COMBO_PAICODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiCod_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiCod_Visible, edtPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_PaisTipoTrabajo.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedpaitipotraid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockpaitipotraid_Internalname, httpContext.getMessage( "Tipo Trabajo", ""), "", "", lblTextblockpaitipotraid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_PaisTipoTrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_paitipotraid.setProperty("Caption", Combo_paitipotraid_Caption);
      ucCombo_paitipotraid.setProperty("Cls", Combo_paitipotraid_Cls);
      ucCombo_paitipotraid.setProperty("DataListProc", Combo_paitipotraid_Datalistproc);
      ucCombo_paitipotraid.setProperty("DataListProcParametersPrefix", Combo_paitipotraid_Datalistprocparametersprefix);
      ucCombo_paitipotraid.setProperty("EmptyItem", Combo_paitipotraid_Emptyitem);
      ucCombo_paitipotraid.setProperty("DropDownOptionsTitleSettingsIcons", AV15DDO_TitleSettingsIcons);
      ucCombo_paitipotraid.setProperty("DropDownOptionsData", AV20PaiTipoTraId_Data);
      ucCombo_paitipotraid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_paitipotraid_Internalname, "COMBO_PAITIPOTRAIDContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbPaiTipoTraId.getInternalname(), httpContext.getMessage( "Tipo de Trabajo", ""), "col-sm-3 AttributeLabel", 0, true, "");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiTipoTraId, cmbPaiTipoTraId.getInternalname(), GXutil.rtrim( A1294PaiTipoTraId), 1, cmbPaiTipoTraId.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbPaiTipoTraId.getVisible(), cmbPaiTipoTraId.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "", true, (byte)(0), "HLP_PaisTipoTrabajo.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkPaiTipoTraIns.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkPaiTipoTraIns.getInternalname(), httpContext.getMessage( "Trabajo insalubre", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkPaiTipoTraIns.getInternalname(), GXutil.booltostr( A1297PaiTipoTraIns), "", httpContext.getMessage( "Trabajo insalubre", ""), 1, chkPaiTipoTraIns.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(44, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,44);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiTipoHsDia_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiTipoHsDia_Internalname, httpContext.getMessage( "Límite de horas normales por día", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiTipoHsDia_Internalname, GXutil.ltrim( localUtil.ntoc( A1336PaiTipoHsDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiTipoHsDia_Enabled!=0) ? localUtil.format( A1336PaiTipoHsDia, "9.9") : localUtil.format( A1336PaiTipoHsDia, "9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiTipoHsDia_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiTipoHsDia_Enabled, 0, "text", "", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisTipoTrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiTipoHsSem_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiTipoHsSem_Internalname, httpContext.getMessage( "Límite de horas normales por semana", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiTipoHsSem_Internalname, GXutil.ltrim( localUtil.ntoc( A1337PaiTipoHsSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiTipoHsSem_Enabled!=0) ? localUtil.format( A1337PaiTipoHsSem, "Z9.9") : localUtil.format( A1337PaiTipoHsSem, "Z9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiTipoHsSem_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiTipoHsSem_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisTipoTrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiTipoHsMaxDia_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiTipoHsMaxDia_Internalname, httpContext.getMessage( "Máximo de horas extras por día", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiTipoHsMaxDia_Internalname, GXutil.ltrim( localUtil.ntoc( A1383PaiTipoHsMaxDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiTipoHsMaxDia_Enabled!=0) ? localUtil.format( A1383PaiTipoHsMaxDia, "9.9") : localUtil.format( A1383PaiTipoHsMaxDia, "9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiTipoHsMaxDia_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiTipoHsMaxDia_Enabled, 0, "text", "", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisTipoTrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiTipoHsMaxSem_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiTipoHsMaxSem_Internalname, httpContext.getMessage( "Máximo de horas extras por semana", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiTipoHsMaxSem_Internalname, GXutil.ltrim( localUtil.ntoc( A1384PaiTipoHsMaxSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiTipoHsMaxSem_Enabled!=0) ? localUtil.format( A1384PaiTipoHsMaxSem, "Z9.9") : localUtil.format( A1384PaiTipoHsMaxSem, "Z9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiTipoHsMaxSem_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiTipoHsMaxSem_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisTipoTrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPaiTipoHsMaxMes.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbPaiTipoHsMaxMes.getInternalname(), httpContext.getMessage( "Máximo de horas extras por mes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPaiTipoHsMaxMes, cmbPaiTipoHsMaxMes.getInternalname(), GXutil.strNoRound( A1385PaiTipoHsMaxMes, 5, 1), 1, cmbPaiTipoHsMaxMes.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "decimal", "", 1, cmbPaiTipoHsMaxMes.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", "", true, (byte)(0), "HLP_PaisTipoTrabajo.htm");
      cmbPaiTipoHsMaxMes.setValue( GXutil.strNoRound( A1385PaiTipoHsMaxMes, 5, 1) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiTipoHsMaxMes.getInternalname(), "Values", cmbPaiTipoHsMaxMes.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiTipoHsMaxAnu_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiTipoHsMaxAnu_Internalname, httpContext.getMessage( "Máximoi de horas extras por año", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiTipoHsMaxAnu_Internalname, GXutil.ltrim( localUtil.ntoc( A1390PaiTipoHsMaxAnu, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiTipoHsMaxAnu_Enabled!=0) ? localUtil.format( A1390PaiTipoHsMaxAnu, "ZZ9.9") : localUtil.format( A1390PaiTipoHsMaxAnu, "ZZ9.9"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiTipoHsMaxAnu_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiTipoHsMaxAnu_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisTipoTrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divPaitipotrarelsec_cell_Internalname, 1, 0, "px", 0, "px", divPaitipotrarelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynPaiTipoTraRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynPaiTipoTraRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynPaiTipoTraRelSec, dynPaiTipoTraRelSec.getInternalname(), GXutil.trim( GXutil.str( A2055PaiTipoTraRelSec, 6, 0)), 1, dynPaiTipoTraRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynPaiTipoTraRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,79);\"", "", true, (byte)(0), "HLP_PaisTipoTrabajo.htm");
      dynPaiTipoTraRelSec.setValue( GXutil.trim( GXutil.str( A2055PaiTipoTraRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynPaiTipoTraRelSec.getInternalname(), "Values", dynPaiTipoTraRelSec.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PaisTipoTrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PaisTipoTrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 91,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PaisTipoTrabajo.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_paicod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombopaicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV19ComboPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCombopaicod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV19ComboPaiCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV19ComboPaiCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombopaicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombopaicod_Visible, edtavCombopaicod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisTipoTrabajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_paitipotraid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavCombopaitipotraid, cmbavCombopaitipotraid.getInternalname(), GXutil.rtrim( AV21ComboPaiTipoTraId), 1, cmbavCombopaitipotraid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbavCombopaitipotraid.getVisible(), cmbavCombopaitipotraid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_PaisTipoTrabajo.htm");
      cmbavCombopaitipotraid.setValue( GXutil.rtrim( AV21ComboPaiTipoTraId) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCombopaitipotraid.getInternalname(), "Values", cmbavCombopaitipotraid.ToJavascriptSource(), true);
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
      e113R2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV15DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPAICOD_DATA"), AV14PaiCod_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPAITIPOTRAID_DATA"), AV20PaiTipoTraId_Data);
            /* Read saved values. */
            Z46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1294PaiTipoTraId = httpContext.cgiGet( "Z1294PaiTipoTraId") ;
            Z1297PaiTipoTraIns = GXutil.strtobool( httpContext.cgiGet( "Z1297PaiTipoTraIns")) ;
            Z1336PaiTipoHsDia = localUtil.ctond( httpContext.cgiGet( "Z1336PaiTipoHsDia")) ;
            Z1337PaiTipoHsSem = localUtil.ctond( httpContext.cgiGet( "Z1337PaiTipoHsSem")) ;
            Z1338PaiTipoTarifaXLim = localUtil.ctond( httpContext.cgiGet( "Z1338PaiTipoTarifaXLim")) ;
            Z1347PaiTipoTarifaRec = localUtil.ctond( httpContext.cgiGet( "Z1347PaiTipoTarifaRec")) ;
            Z1383PaiTipoHsMaxDia = localUtil.ctond( httpContext.cgiGet( "Z1383PaiTipoHsMaxDia")) ;
            Z1384PaiTipoHsMaxSem = localUtil.ctond( httpContext.cgiGet( "Z1384PaiTipoHsMaxSem")) ;
            Z1385PaiTipoHsMaxMes = localUtil.ctond( httpContext.cgiGet( "Z1385PaiTipoHsMaxMes")) ;
            Z1390PaiTipoHsMaxAnu = localUtil.ctond( httpContext.cgiGet( "Z1390PaiTipoHsMaxAnu")) ;
            Z2055PaiTipoTraRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z2055PaiTipoTraRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2056PaiTipoTraRelRef = httpContext.cgiGet( "Z2056PaiTipoTraRelRef") ;
            Z2435PaiTipoTraHorDes = httpContext.cgiGet( "Z2435PaiTipoTraHorDes") ;
            A1338PaiTipoTarifaXLim = localUtil.ctond( httpContext.cgiGet( "Z1338PaiTipoTarifaXLim")) ;
            A1347PaiTipoTarifaRec = localUtil.ctond( httpContext.cgiGet( "Z1347PaiTipoTarifaRec")) ;
            A2056PaiTipoTraRelRef = httpContext.cgiGet( "Z2056PaiTipoTraRelRef") ;
            A2435PaiTipoTraHorDes = httpContext.cgiGet( "Z2435PaiTipoTraHorDes") ;
            O1390PaiTipoHsMaxAnu = localUtil.ctond( httpContext.cgiGet( "O1390PaiTipoHsMaxAnu")) ;
            O1385PaiTipoHsMaxMes = localUtil.ctond( httpContext.cgiGet( "O1385PaiTipoHsMaxMes")) ;
            O1384PaiTipoHsMaxSem = localUtil.ctond( httpContext.cgiGet( "O1384PaiTipoHsMaxSem")) ;
            O1383PaiTipoHsMaxDia = localUtil.ctond( httpContext.cgiGet( "O1383PaiTipoHsMaxDia")) ;
            O1347PaiTipoTarifaRec = localUtil.ctond( httpContext.cgiGet( "O1347PaiTipoTarifaRec")) ;
            O1338PaiTipoTarifaXLim = localUtil.ctond( httpContext.cgiGet( "O1338PaiTipoTarifaXLim")) ;
            O1337PaiTipoHsSem = localUtil.ctond( httpContext.cgiGet( "O1337PaiTipoHsSem")) ;
            O1336PaiTipoHsDia = localUtil.ctond( httpContext.cgiGet( "O1336PaiTipoHsDia")) ;
            O1297PaiTipoTraIns = GXutil.strtobool( httpContext.cgiGet( "O1297PaiTipoTraIns")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8PaiTipoTraId = httpContext.cgiGet( "vPAITIPOTRAID") ;
            A1338PaiTipoTarifaXLim = localUtil.ctond( httpContext.cgiGet( "PAITIPOTARIFAXLIM")) ;
            A1347PaiTipoTarifaRec = localUtil.ctond( httpContext.cgiGet( "PAITIPOTARIFAREC")) ;
            A1976PaiTipoTraOldDefault = httpContext.cgiGet( "PAITIPOTRAOLDDEFAULT") ;
            AV24CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV23aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A2056PaiTipoTraRelRef = httpContext.cgiGet( "PAITIPOTRARELREF") ;
            A2070PaiTipoTraOld = httpContext.cgiGet( "PAITIPOTRAOLD") ;
            A2435PaiTipoTraHorDes = httpContext.cgiGet( "PAITIPOTRAHORDES") ;
            A1295PaiTipoTraNom = httpContext.cgiGet( "PAITIPOTRANOM") ;
            AV25Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_paicod_Objectcall = httpContext.cgiGet( "COMBO_PAICOD_Objectcall") ;
            Combo_paicod_Class = httpContext.cgiGet( "COMBO_PAICOD_Class") ;
            Combo_paicod_Icontype = httpContext.cgiGet( "COMBO_PAICOD_Icontype") ;
            Combo_paicod_Icon = httpContext.cgiGet( "COMBO_PAICOD_Icon") ;
            Combo_paicod_Caption = httpContext.cgiGet( "COMBO_PAICOD_Caption") ;
            Combo_paicod_Tooltip = httpContext.cgiGet( "COMBO_PAICOD_Tooltip") ;
            Combo_paicod_Cls = httpContext.cgiGet( "COMBO_PAICOD_Cls") ;
            Combo_paicod_Selectedvalue_set = httpContext.cgiGet( "COMBO_PAICOD_Selectedvalue_set") ;
            Combo_paicod_Selectedvalue_get = httpContext.cgiGet( "COMBO_PAICOD_Selectedvalue_get") ;
            Combo_paicod_Selectedtext_set = httpContext.cgiGet( "COMBO_PAICOD_Selectedtext_set") ;
            Combo_paicod_Selectedtext_get = httpContext.cgiGet( "COMBO_PAICOD_Selectedtext_get") ;
            Combo_paicod_Gamoauthtoken = httpContext.cgiGet( "COMBO_PAICOD_Gamoauthtoken") ;
            Combo_paicod_Ddointernalname = httpContext.cgiGet( "COMBO_PAICOD_Ddointernalname") ;
            Combo_paicod_Titlecontrolalign = httpContext.cgiGet( "COMBO_PAICOD_Titlecontrolalign") ;
            Combo_paicod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_PAICOD_Dropdownoptionstype") ;
            Combo_paicod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAICOD_Enabled")) ;
            Combo_paicod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAICOD_Visible")) ;
            Combo_paicod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_PAICOD_Titlecontrolidtoreplace") ;
            Combo_paicod_Datalisttype = httpContext.cgiGet( "COMBO_PAICOD_Datalisttype") ;
            Combo_paicod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAICOD_Allowmultipleselection")) ;
            Combo_paicod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_PAICOD_Datalistfixedvalues") ;
            Combo_paicod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAICOD_Isgriditem")) ;
            Combo_paicod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAICOD_Hasdescription")) ;
            Combo_paicod_Datalistproc = httpContext.cgiGet( "COMBO_PAICOD_Datalistproc") ;
            Combo_paicod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_PAICOD_Datalistprocparametersprefix") ;
            Combo_paicod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_PAICOD_Remoteservicesparameters") ;
            Combo_paicod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_PAICOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_paicod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAICOD_Includeonlyselectedoption")) ;
            Combo_paicod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAICOD_Includeselectalloption")) ;
            Combo_paicod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAICOD_Emptyitem")) ;
            Combo_paicod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAICOD_Includeaddnewoption")) ;
            Combo_paicod_Htmltemplate = httpContext.cgiGet( "COMBO_PAICOD_Htmltemplate") ;
            Combo_paicod_Multiplevaluestype = httpContext.cgiGet( "COMBO_PAICOD_Multiplevaluestype") ;
            Combo_paicod_Loadingdata = httpContext.cgiGet( "COMBO_PAICOD_Loadingdata") ;
            Combo_paicod_Noresultsfound = httpContext.cgiGet( "COMBO_PAICOD_Noresultsfound") ;
            Combo_paicod_Emptyitemtext = httpContext.cgiGet( "COMBO_PAICOD_Emptyitemtext") ;
            Combo_paicod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_PAICOD_Onlyselectedvalues") ;
            Combo_paicod_Selectalltext = httpContext.cgiGet( "COMBO_PAICOD_Selectalltext") ;
            Combo_paicod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_PAICOD_Multiplevaluesseparator") ;
            Combo_paicod_Addnewoptiontext = httpContext.cgiGet( "COMBO_PAICOD_Addnewoptiontext") ;
            Combo_paicod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_PAICOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            cmbPaiTipoTraId.setValue( httpContext.cgiGet( cmbPaiTipoTraId.getInternalname()) );
            A1294PaiTipoTraId = httpContext.cgiGet( cmbPaiTipoTraId.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
            A1297PaiTipoTraIns = GXutil.strtobool( httpContext.cgiGet( chkPaiTipoTraIns.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1297PaiTipoTraIns", A1297PaiTipoTraIns);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsDia_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsDia_Internalname)), DecimalUtil.stringToDec("9.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAITIPOHSDIA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiTipoHsDia_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1336PaiTipoHsDia = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1336PaiTipoHsDia", GXutil.ltrimstr( A1336PaiTipoHsDia, 3, 1));
            }
            else
            {
               A1336PaiTipoHsDia = localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsDia_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1336PaiTipoHsDia", GXutil.ltrimstr( A1336PaiTipoHsDia, 3, 1));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsSem_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsSem_Internalname)), DecimalUtil.stringToDec("99.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAITIPOHSSEM");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiTipoHsSem_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1337PaiTipoHsSem = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1337PaiTipoHsSem", GXutil.ltrimstr( A1337PaiTipoHsSem, 4, 1));
            }
            else
            {
               A1337PaiTipoHsSem = localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsSem_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1337PaiTipoHsSem", GXutil.ltrimstr( A1337PaiTipoHsSem, 4, 1));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsMaxDia_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsMaxDia_Internalname)), DecimalUtil.stringToDec("9.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAITIPOHSMAXDIA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiTipoHsMaxDia_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1383PaiTipoHsMaxDia = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1383PaiTipoHsMaxDia", GXutil.ltrimstr( A1383PaiTipoHsMaxDia, 3, 1));
            }
            else
            {
               A1383PaiTipoHsMaxDia = localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsMaxDia_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1383PaiTipoHsMaxDia", GXutil.ltrimstr( A1383PaiTipoHsMaxDia, 3, 1));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsMaxSem_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsMaxSem_Internalname)), DecimalUtil.stringToDec("99.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAITIPOHSMAXSEM");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiTipoHsMaxSem_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1384PaiTipoHsMaxSem = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1384PaiTipoHsMaxSem", GXutil.ltrimstr( A1384PaiTipoHsMaxSem, 4, 1));
            }
            else
            {
               A1384PaiTipoHsMaxSem = localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsMaxSem_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1384PaiTipoHsMaxSem", GXutil.ltrimstr( A1384PaiTipoHsMaxSem, 4, 1));
            }
            cmbPaiTipoHsMaxMes.setValue( httpContext.cgiGet( cmbPaiTipoHsMaxMes.getInternalname()) );
            A1385PaiTipoHsMaxMes = DecimalUtil.stringToDec( httpContext.cgiGet( cmbPaiTipoHsMaxMes.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1385PaiTipoHsMaxMes", GXutil.ltrimstr( A1385PaiTipoHsMaxMes, 5, 1));
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsMaxAnu_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsMaxAnu_Internalname)), DecimalUtil.stringToDec("999.9")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAITIPOHSMAXANU");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiTipoHsMaxAnu_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1390PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1390PaiTipoHsMaxAnu", GXutil.ltrimstr( A1390PaiTipoHsMaxAnu, 5, 1));
            }
            else
            {
               A1390PaiTipoHsMaxAnu = localUtil.ctond( httpContext.cgiGet( edtPaiTipoHsMaxAnu_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1390PaiTipoHsMaxAnu", GXutil.ltrimstr( A1390PaiTipoHsMaxAnu, 5, 1));
            }
            dynPaiTipoTraRelSec.setValue( httpContext.cgiGet( dynPaiTipoTraRelSec.getInternalname()) );
            A2055PaiTipoTraRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynPaiTipoTraRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2055PaiTipoTraRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2055PaiTipoTraRelSec), 6, 0));
            AV19ComboPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombopaicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19ComboPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboPaiCod), 4, 0));
            cmbavCombopaitipotraid.setValue( httpContext.cgiGet( cmbavCombopaitipotraid.getInternalname()) );
            AV21ComboPaiTipoTraId = httpContext.cgiGet( cmbavCombopaitipotraid.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21ComboPaiTipoTraId", AV21ComboPaiTipoTraId);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"PaisTipoTrabajo");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("PaiTipoTarifaXLim", localUtil.format( A1338PaiTipoTarifaXLim, "9.9999"));
            forbiddenHiddens.add("PaiTipoTarifaRec", localUtil.format( A1347PaiTipoTarifaRec, "9.9999"));
            forbiddenHiddens.add("PaiTipoTraRelRef", GXutil.rtrim( localUtil.format( A2056PaiTipoTraRelRef, "")));
            forbiddenHiddens.add("PaiTipoTraHorDes", GXutil.rtrim( localUtil.format( A2435PaiTipoTraHorDes, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A1294PaiTipoTraId, Z1294PaiTipoTraId) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("paistipotrabajo:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
                  sMode155 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode155 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound155 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_3R0( ) ;
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
                        e113R2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e123R2 ();
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
         e123R2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll3R155( ) ;
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
         disableAttributes3R155( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopaicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopaicod_Enabled), 5, 0), true);
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

   public void confirm_3R0( )
   {
      beforeValidate3R155( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls3R155( ) ;
         }
         else
         {
            checkExtendedTable3R155( ) ;
            closeExtendedTableCursors3R155( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption3R0( )
   {
   }

   public void e113R2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV24CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      paistipotrabajo_impl.this.GXt_int1 = GXv_int2[0] ;
      AV24CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24CliCod), 6, 0));
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext3[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV9WWPContext = GXv_SdtWWPContext3[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = AV15DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[0] ;
      AV15DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4;
      cmbPaiTipoTraId.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiTipoTraId.getInternalname(), "Visible", GXutil.ltrimstr( cmbPaiTipoTraId.getVisible(), 5, 0), true);
      AV21ComboPaiTipoTraId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboPaiTipoTraId", AV21ComboPaiTipoTraId);
      cmbavCombopaitipotraid.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCombopaitipotraid.getInternalname(), "Visible", GXutil.ltrimstr( cmbavCombopaitipotraid.getVisible(), 5, 0), true);
      edtPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Visible), 5, 0), true);
      AV19ComboPaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboPaiCod), 4, 0));
      edtavCombopaicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopaicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopaicod_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOPAICOD' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOPAITIPOTRAID' */
      S122 ();
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
         GXt_boolean6 = AV10IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisTipoTrabajo_Insert", GXv_boolean7) ;
         paistipotrabajo_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV10IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean6 = AV10IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisTipoTrabajo_Update", GXv_boolean7) ;
         paistipotrabajo_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV10IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean6 = AV10IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisTipoTrabajo_Delete", GXv_boolean7) ;
         paistipotrabajo_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV10IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV25Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
   }

   public void e123R2( )
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
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      divPaitipotrarelsec_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divPaitipotrarelsec_cell_Internalname, "Class", divPaitipotrarelsec_cell_Class, true);
   }

   public void S122( )
   {
      /* 'LOADCOMBOPAITIPOTRAID' Routine */
      returnInSub = false ;
      GXt_char8 = AV18Combo_DataJson ;
      GXv_char9[0] = AV16ComboSelectedValue ;
      GXv_char10[0] = AV17ComboSelectedText ;
      GXv_char11[0] = GXt_char8 ;
      new web.paistipotrabajoloaddvcombo(remoteHandle, context).execute( "PaiTipoTraId", Gx_mode, false, AV7PaiCod, AV8PaiTipoTraId, "", GXv_char9, GXv_char10, GXv_char11) ;
      paistipotrabajo_impl.this.AV16ComboSelectedValue = GXv_char9[0] ;
      paistipotrabajo_impl.this.AV17ComboSelectedText = GXv_char10[0] ;
      paistipotrabajo_impl.this.GXt_char8 = GXv_char11[0] ;
      AV18Combo_DataJson = GXt_char8 ;
      Combo_paitipotraid_Selectedvalue_set = AV16ComboSelectedValue ;
      ucCombo_paitipotraid.sendProperty(context, "", false, Combo_paitipotraid_Internalname, "SelectedValue_set", Combo_paitipotraid_Selectedvalue_set);
      Combo_paitipotraid_Selectedtext_set = AV17ComboSelectedText ;
      ucCombo_paitipotraid.sendProperty(context, "", false, Combo_paitipotraid_Internalname, "SelectedText_set", Combo_paitipotraid_Selectedtext_set);
      AV21ComboPaiTipoTraId = AV16ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboPaiTipoTraId", AV21ComboPaiTipoTraId);
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (GXutil.strcmp("", AV8PaiTipoTraId)==0) )
      {
         Combo_paitipotraid_Enabled = false ;
         ucCombo_paitipotraid.sendProperty(context, "", false, Combo_paitipotraid_Internalname, "Enabled", GXutil.booltostr( Combo_paitipotraid_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOPAICOD' Routine */
      returnInSub = false ;
      GXt_char8 = AV18Combo_DataJson ;
      GXv_char11[0] = AV16ComboSelectedValue ;
      GXv_char10[0] = AV17ComboSelectedText ;
      GXv_char9[0] = GXt_char8 ;
      new web.paistipotrabajoloaddvcombo(remoteHandle, context).execute( "PaiCod", Gx_mode, false, AV7PaiCod, AV8PaiTipoTraId, "", GXv_char11, GXv_char10, GXv_char9) ;
      paistipotrabajo_impl.this.AV16ComboSelectedValue = GXv_char11[0] ;
      paistipotrabajo_impl.this.AV17ComboSelectedText = GXv_char10[0] ;
      paistipotrabajo_impl.this.GXt_char8 = GXv_char9[0] ;
      AV18Combo_DataJson = GXt_char8 ;
      Combo_paicod_Selectedvalue_set = AV16ComboSelectedValue ;
      ucCombo_paicod.sendProperty(context, "", false, Combo_paicod_Internalname, "SelectedValue_set", Combo_paicod_Selectedvalue_set);
      Combo_paicod_Selectedtext_set = AV17ComboSelectedText ;
      ucCombo_paicod.sendProperty(context, "", false, Combo_paicod_Internalname, "SelectedText_set", Combo_paicod_Selectedtext_set);
      AV19ComboPaiCod = (short)(GXutil.lval( AV16ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboPaiCod), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (0==AV7PaiCod) )
      {
         Combo_paicod_Enabled = false ;
         ucCombo_paicod.sendProperty(context, "", false, Combo_paicod_Internalname, "Enabled", GXutil.booltostr( Combo_paicod_Enabled));
      }
   }

   public void zm3R155( int GX_JID )
   {
      if ( ( GX_JID == 14 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1297PaiTipoTraIns = T003R3_A1297PaiTipoTraIns[0] ;
            Z1336PaiTipoHsDia = T003R3_A1336PaiTipoHsDia[0] ;
            Z1337PaiTipoHsSem = T003R3_A1337PaiTipoHsSem[0] ;
            Z1338PaiTipoTarifaXLim = T003R3_A1338PaiTipoTarifaXLim[0] ;
            Z1347PaiTipoTarifaRec = T003R3_A1347PaiTipoTarifaRec[0] ;
            Z1383PaiTipoHsMaxDia = T003R3_A1383PaiTipoHsMaxDia[0] ;
            Z1384PaiTipoHsMaxSem = T003R3_A1384PaiTipoHsMaxSem[0] ;
            Z1385PaiTipoHsMaxMes = T003R3_A1385PaiTipoHsMaxMes[0] ;
            Z1390PaiTipoHsMaxAnu = T003R3_A1390PaiTipoHsMaxAnu[0] ;
            Z2055PaiTipoTraRelSec = T003R3_A2055PaiTipoTraRelSec[0] ;
            Z2056PaiTipoTraRelRef = T003R3_A2056PaiTipoTraRelRef[0] ;
            Z2435PaiTipoTraHorDes = T003R3_A2435PaiTipoTraHorDes[0] ;
         }
         else
         {
            Z1297PaiTipoTraIns = A1297PaiTipoTraIns ;
            Z1336PaiTipoHsDia = A1336PaiTipoHsDia ;
            Z1337PaiTipoHsSem = A1337PaiTipoHsSem ;
            Z1338PaiTipoTarifaXLim = A1338PaiTipoTarifaXLim ;
            Z1347PaiTipoTarifaRec = A1347PaiTipoTarifaRec ;
            Z1383PaiTipoHsMaxDia = A1383PaiTipoHsMaxDia ;
            Z1384PaiTipoHsMaxSem = A1384PaiTipoHsMaxSem ;
            Z1385PaiTipoHsMaxMes = A1385PaiTipoHsMaxMes ;
            Z1390PaiTipoHsMaxAnu = A1390PaiTipoHsMaxAnu ;
            Z2055PaiTipoTraRelSec = A2055PaiTipoTraRelSec ;
            Z2056PaiTipoTraRelRef = A2056PaiTipoTraRelRef ;
            Z2435PaiTipoTraHorDes = A2435PaiTipoTraHorDes ;
         }
      }
      if ( GX_JID == -14 )
      {
         Z1976PaiTipoTraOldDefault = A1976PaiTipoTraOldDefault ;
         Z1297PaiTipoTraIns = A1297PaiTipoTraIns ;
         Z1336PaiTipoHsDia = A1336PaiTipoHsDia ;
         Z1337PaiTipoHsSem = A1337PaiTipoHsSem ;
         Z1338PaiTipoTarifaXLim = A1338PaiTipoTarifaXLim ;
         Z1347PaiTipoTarifaRec = A1347PaiTipoTarifaRec ;
         Z1383PaiTipoHsMaxDia = A1383PaiTipoHsMaxDia ;
         Z1384PaiTipoHsMaxSem = A1384PaiTipoHsMaxSem ;
         Z1385PaiTipoHsMaxMes = A1385PaiTipoHsMaxMes ;
         Z1390PaiTipoHsMaxAnu = A1390PaiTipoHsMaxAnu ;
         Z2055PaiTipoTraRelSec = A2055PaiTipoTraRelSec ;
         Z2056PaiTipoTraRelRef = A2056PaiTipoTraRelRef ;
         Z2070PaiTipoTraOld = A2070PaiTipoTraOld ;
         Z2435PaiTipoTraHorDes = A2435PaiTipoTraHorDes ;
         Z46PaiCod = A46PaiCod ;
         Z1294PaiTipoTraId = A1294PaiTipoTraId ;
         Z1292TipoTraId = A1292TipoTraId ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
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
      if ( ! (GXutil.strcmp("", AV8PaiTipoTraId)==0) )
      {
         cmbPaiTipoTraId.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiTipoTraId.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiTipoTraId.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbPaiTipoTraId.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiTipoTraId.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiTipoTraId.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8PaiTipoTraId)==0) )
      {
         cmbPaiTipoTraId.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbPaiTipoTraId.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiTipoTraId.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8PaiTipoTraId)==0) )
      {
         A1294PaiTipoTraId = AV8PaiTipoTraId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      }
      else
      {
         A1294PaiTipoTraId = AV21ComboPaiTipoTraId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      }
      if ( ! (0==AV7PaiCod) )
      {
         A46PaiCod = AV7PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      else
      {
         A46PaiCod = AV19ComboPaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      gxapaitipotrarelsec_html3R155( AV24CliCod) ;
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
         AV25Pgmname = "PaisTipoTrabajo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
         /* Using cursor T003R5 */
         pr_default.execute(3, new Object[] {A1294PaiTipoTraId});
         pr_default.close(3);
      }
   }

   public void load3R155( )
   {
      /* Using cursor T003R6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound155 = (short)(1) ;
         A1292TipoTraId = T003R6_A1292TipoTraId[0] ;
         A1976PaiTipoTraOldDefault = T003R6_A1976PaiTipoTraOldDefault[0] ;
         A1297PaiTipoTraIns = T003R6_A1297PaiTipoTraIns[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1297PaiTipoTraIns", A1297PaiTipoTraIns);
         A1336PaiTipoHsDia = T003R6_A1336PaiTipoHsDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1336PaiTipoHsDia", GXutil.ltrimstr( A1336PaiTipoHsDia, 3, 1));
         A1337PaiTipoHsSem = T003R6_A1337PaiTipoHsSem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1337PaiTipoHsSem", GXutil.ltrimstr( A1337PaiTipoHsSem, 4, 1));
         A1338PaiTipoTarifaXLim = T003R6_A1338PaiTipoTarifaXLim[0] ;
         A1347PaiTipoTarifaRec = T003R6_A1347PaiTipoTarifaRec[0] ;
         A1383PaiTipoHsMaxDia = T003R6_A1383PaiTipoHsMaxDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1383PaiTipoHsMaxDia", GXutil.ltrimstr( A1383PaiTipoHsMaxDia, 3, 1));
         A1384PaiTipoHsMaxSem = T003R6_A1384PaiTipoHsMaxSem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1384PaiTipoHsMaxSem", GXutil.ltrimstr( A1384PaiTipoHsMaxSem, 4, 1));
         A1385PaiTipoHsMaxMes = T003R6_A1385PaiTipoHsMaxMes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1385PaiTipoHsMaxMes", GXutil.ltrimstr( A1385PaiTipoHsMaxMes, 5, 1));
         A1390PaiTipoHsMaxAnu = T003R6_A1390PaiTipoHsMaxAnu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1390PaiTipoHsMaxAnu", GXutil.ltrimstr( A1390PaiTipoHsMaxAnu, 5, 1));
         A2055PaiTipoTraRelSec = T003R6_A2055PaiTipoTraRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2055PaiTipoTraRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2055PaiTipoTraRelSec), 6, 0));
         A2056PaiTipoTraRelRef = T003R6_A2056PaiTipoTraRelRef[0] ;
         A2070PaiTipoTraOld = T003R6_A2070PaiTipoTraOld[0] ;
         A2435PaiTipoTraHorDes = T003R6_A2435PaiTipoTraHorDes[0] ;
         zm3R155( -14) ;
      }
      pr_default.close(4);
      onLoadActions3R155( ) ;
   }

   public void onLoadActions3R155( )
   {
      AV25Pgmname = "PaisTipoTrabajo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
      if ( ! ( ( A1297PaiTipoTraIns != O1297PaiTipoTraIns ) || ( DecimalUtil.compareTo(A1336PaiTipoHsDia, O1336PaiTipoHsDia) != 0 ) || ( DecimalUtil.compareTo(A1337PaiTipoHsSem, O1337PaiTipoHsSem) != 0 ) || ( DecimalUtil.compareTo(A1338PaiTipoTarifaXLim, O1338PaiTipoTarifaXLim) != 0 ) || ( DecimalUtil.compareTo(A1347PaiTipoTarifaRec, O1347PaiTipoTarifaRec) != 0 ) || ( DecimalUtil.compareTo(A1383PaiTipoHsMaxDia, O1383PaiTipoHsMaxDia) != 0 ) || ( DecimalUtil.compareTo(A1384PaiTipoHsMaxSem, O1384PaiTipoHsMaxSem) != 0 ) || ( DecimalUtil.compareTo(A1385PaiTipoHsMaxMes, O1385PaiTipoHsMaxMes) != 0 ) || ( DecimalUtil.compareTo(A1390PaiTipoHsMaxAnu, O1390PaiTipoHsMaxAnu) != 0 ) ) )
      {
         divPaitipotrarelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPaitipotrarelsec_cell_Internalname, "Class", divPaitipotrarelsec_cell_Class, true);
      }
      else
      {
         if ( ( A1297PaiTipoTraIns != O1297PaiTipoTraIns ) || ( DecimalUtil.compareTo(A1336PaiTipoHsDia, O1336PaiTipoHsDia) != 0 ) || ( DecimalUtil.compareTo(A1337PaiTipoHsSem, O1337PaiTipoHsSem) != 0 ) || ( DecimalUtil.compareTo(A1338PaiTipoTarifaXLim, O1338PaiTipoTarifaXLim) != 0 ) || ( DecimalUtil.compareTo(A1347PaiTipoTarifaRec, O1347PaiTipoTarifaRec) != 0 ) || ( DecimalUtil.compareTo(A1383PaiTipoHsMaxDia, O1383PaiTipoHsMaxDia) != 0 ) || ( DecimalUtil.compareTo(A1384PaiTipoHsMaxSem, O1384PaiTipoHsMaxSem) != 0 ) || ( DecimalUtil.compareTo(A1385PaiTipoHsMaxMes, O1385PaiTipoHsMaxMes) != 0 ) || ( DecimalUtil.compareTo(A1390PaiTipoHsMaxAnu, O1390PaiTipoHsMaxAnu) != 0 ) )
         {
            divPaitipotrarelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPaitipotrarelsec_cell_Internalname, "Class", divPaitipotrarelsec_cell_Class, true);
         }
      }
      if ( isUpd( )  )
      {
         GXt_char8 = A1976PaiTipoTraOldDefault ;
         GXv_char11[0] = GXt_char8 ;
         new web.paistipotrabajosetolddef(remoteHandle, context).execute( O1336PaiTipoHsDia, O1337PaiTipoHsSem, O1338PaiTipoTarifaXLim, O1347PaiTipoTarifaRec, O1383PaiTipoHsMaxDia, O1384PaiTipoHsMaxSem, O1385PaiTipoHsMaxMes, O1390PaiTipoHsMaxAnu, GXv_char11) ;
         paistipotrabajo_impl.this.GXt_char8 = GXv_char11[0] ;
         A1976PaiTipoTraOldDefault = GXt_char8 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1976PaiTipoTraOldDefault", A1976PaiTipoTraOldDefault);
      }
   }

   public void checkExtendedTable3R155( )
   {
      nIsDirty_155 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV25Pgmname = "PaisTipoTrabajo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean7[0] = AV23aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV24CliCod, A2055PaiTipoTraRelSec, GXv_boolean7) ;
         paistipotrabajo_impl.this.AV23aplicadoHay = GXv_boolean7[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
      }
      /* Using cursor T003R4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T003R5 */
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
      if ( ! ( ( A1297PaiTipoTraIns != O1297PaiTipoTraIns ) || ( DecimalUtil.compareTo(A1336PaiTipoHsDia, O1336PaiTipoHsDia) != 0 ) || ( DecimalUtil.compareTo(A1337PaiTipoHsSem, O1337PaiTipoHsSem) != 0 ) || ( DecimalUtil.compareTo(A1338PaiTipoTarifaXLim, O1338PaiTipoTarifaXLim) != 0 ) || ( DecimalUtil.compareTo(A1347PaiTipoTarifaRec, O1347PaiTipoTarifaRec) != 0 ) || ( DecimalUtil.compareTo(A1383PaiTipoHsMaxDia, O1383PaiTipoHsMaxDia) != 0 ) || ( DecimalUtil.compareTo(A1384PaiTipoHsMaxSem, O1384PaiTipoHsMaxSem) != 0 ) || ( DecimalUtil.compareTo(A1385PaiTipoHsMaxMes, O1385PaiTipoHsMaxMes) != 0 ) || ( DecimalUtil.compareTo(A1390PaiTipoHsMaxAnu, O1390PaiTipoHsMaxAnu) != 0 ) ) )
      {
         divPaitipotrarelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divPaitipotrarelsec_cell_Internalname, "Class", divPaitipotrarelsec_cell_Class, true);
      }
      else
      {
         if ( ( A1297PaiTipoTraIns != O1297PaiTipoTraIns ) || ( DecimalUtil.compareTo(A1336PaiTipoHsDia, O1336PaiTipoHsDia) != 0 ) || ( DecimalUtil.compareTo(A1337PaiTipoHsSem, O1337PaiTipoHsSem) != 0 ) || ( DecimalUtil.compareTo(A1338PaiTipoTarifaXLim, O1338PaiTipoTarifaXLim) != 0 ) || ( DecimalUtil.compareTo(A1347PaiTipoTarifaRec, O1347PaiTipoTarifaRec) != 0 ) || ( DecimalUtil.compareTo(A1383PaiTipoHsMaxDia, O1383PaiTipoHsMaxDia) != 0 ) || ( DecimalUtil.compareTo(A1384PaiTipoHsMaxSem, O1384PaiTipoHsMaxSem) != 0 ) || ( DecimalUtil.compareTo(A1385PaiTipoHsMaxMes, O1385PaiTipoHsMaxMes) != 0 ) || ( DecimalUtil.compareTo(A1390PaiTipoHsMaxAnu, O1390PaiTipoHsMaxAnu) != 0 ) )
         {
            divPaitipotrarelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPaitipotrarelsec_cell_Internalname, "Class", divPaitipotrarelsec_cell_Class, true);
         }
      }
      if ( ( ( A1297PaiTipoTraIns != O1297PaiTipoTraIns ) || ( DecimalUtil.compareTo(A1336PaiTipoHsDia, O1336PaiTipoHsDia) != 0 ) || ( DecimalUtil.compareTo(A1337PaiTipoHsSem, O1337PaiTipoHsSem) != 0 ) || ( DecimalUtil.compareTo(A1338PaiTipoTarifaXLim, O1338PaiTipoTarifaXLim) != 0 ) || ( DecimalUtil.compareTo(A1347PaiTipoTarifaRec, O1347PaiTipoTarifaRec) != 0 ) || ( DecimalUtil.compareTo(A1383PaiTipoHsMaxDia, O1383PaiTipoHsMaxDia) != 0 ) || ( DecimalUtil.compareTo(A1384PaiTipoHsMaxSem, O1384PaiTipoHsMaxSem) != 0 ) || ( DecimalUtil.compareTo(A1385PaiTipoHsMaxMes, O1385PaiTipoHsMaxMes) != 0 ) || ( DecimalUtil.compareTo(A1390PaiTipoHsMaxAnu, O1390PaiTipoHsMaxAnu) != 0 ) ) && (0==A2055PaiTipoTraRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "PAITIPOTRAINS");
         AnyError = (short)(1) ;
         GX_FocusControl = chkPaiTipoTraIns.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( isUpd( )  )
      {
         nIsDirty_155 = (short)(1) ;
         GXt_char8 = A1976PaiTipoTraOldDefault ;
         GXv_char11[0] = GXt_char8 ;
         new web.paistipotrabajosetolddef(remoteHandle, context).execute( O1336PaiTipoHsDia, O1337PaiTipoHsSem, O1338PaiTipoTarifaXLim, O1347PaiTipoTarifaRec, O1383PaiTipoHsMaxDia, O1384PaiTipoHsMaxSem, O1385PaiTipoHsMaxMes, O1390PaiTipoHsMaxAnu, GXv_char11) ;
         paistipotrabajo_impl.this.GXt_char8 = GXv_char11[0] ;
         A1976PaiTipoTraOldDefault = GXt_char8 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1976PaiTipoTraOldDefault", A1976PaiTipoTraOldDefault);
      }
   }

   public void closeExtendedTableCursors3R155( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_15( short A46PaiCod )
   {
      /* Using cursor T003R7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
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

   public void gxload_16( String A1294PaiTipoTraId )
   {
      /* Using cursor T003R8 */
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
      addString( "\""+PrivateUtilities.encodeJSConstant( A1295PaiTipoTraNom)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey3R155( )
   {
      /* Using cursor T003R9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound155 = (short)(1) ;
      }
      else
      {
         RcdFound155 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T003R3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm3R155( 14) ;
         RcdFound155 = (short)(1) ;
         A1976PaiTipoTraOldDefault = T003R3_A1976PaiTipoTraOldDefault[0] ;
         A1297PaiTipoTraIns = T003R3_A1297PaiTipoTraIns[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1297PaiTipoTraIns", A1297PaiTipoTraIns);
         A1336PaiTipoHsDia = T003R3_A1336PaiTipoHsDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1336PaiTipoHsDia", GXutil.ltrimstr( A1336PaiTipoHsDia, 3, 1));
         A1337PaiTipoHsSem = T003R3_A1337PaiTipoHsSem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1337PaiTipoHsSem", GXutil.ltrimstr( A1337PaiTipoHsSem, 4, 1));
         A1338PaiTipoTarifaXLim = T003R3_A1338PaiTipoTarifaXLim[0] ;
         A1347PaiTipoTarifaRec = T003R3_A1347PaiTipoTarifaRec[0] ;
         A1383PaiTipoHsMaxDia = T003R3_A1383PaiTipoHsMaxDia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1383PaiTipoHsMaxDia", GXutil.ltrimstr( A1383PaiTipoHsMaxDia, 3, 1));
         A1384PaiTipoHsMaxSem = T003R3_A1384PaiTipoHsMaxSem[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1384PaiTipoHsMaxSem", GXutil.ltrimstr( A1384PaiTipoHsMaxSem, 4, 1));
         A1385PaiTipoHsMaxMes = T003R3_A1385PaiTipoHsMaxMes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1385PaiTipoHsMaxMes", GXutil.ltrimstr( A1385PaiTipoHsMaxMes, 5, 1));
         A1390PaiTipoHsMaxAnu = T003R3_A1390PaiTipoHsMaxAnu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1390PaiTipoHsMaxAnu", GXutil.ltrimstr( A1390PaiTipoHsMaxAnu, 5, 1));
         A2055PaiTipoTraRelSec = T003R3_A2055PaiTipoTraRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2055PaiTipoTraRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2055PaiTipoTraRelSec), 6, 0));
         A2056PaiTipoTraRelRef = T003R3_A2056PaiTipoTraRelRef[0] ;
         A2070PaiTipoTraOld = T003R3_A2070PaiTipoTraOld[0] ;
         A2435PaiTipoTraHorDes = T003R3_A2435PaiTipoTraHorDes[0] ;
         A46PaiCod = T003R3_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1294PaiTipoTraId = T003R3_A1294PaiTipoTraId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
         O1390PaiTipoHsMaxAnu = A1390PaiTipoHsMaxAnu ;
         httpContext.ajax_rsp_assign_attri("", false, "A1390PaiTipoHsMaxAnu", GXutil.ltrimstr( A1390PaiTipoHsMaxAnu, 5, 1));
         O1385PaiTipoHsMaxMes = A1385PaiTipoHsMaxMes ;
         httpContext.ajax_rsp_assign_attri("", false, "A1385PaiTipoHsMaxMes", GXutil.ltrimstr( A1385PaiTipoHsMaxMes, 5, 1));
         O1384PaiTipoHsMaxSem = A1384PaiTipoHsMaxSem ;
         httpContext.ajax_rsp_assign_attri("", false, "A1384PaiTipoHsMaxSem", GXutil.ltrimstr( A1384PaiTipoHsMaxSem, 4, 1));
         O1383PaiTipoHsMaxDia = A1383PaiTipoHsMaxDia ;
         httpContext.ajax_rsp_assign_attri("", false, "A1383PaiTipoHsMaxDia", GXutil.ltrimstr( A1383PaiTipoHsMaxDia, 3, 1));
         O1347PaiTipoTarifaRec = A1347PaiTipoTarifaRec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1347PaiTipoTarifaRec", GXutil.ltrimstr( A1347PaiTipoTarifaRec, 6, 4));
         O1338PaiTipoTarifaXLim = A1338PaiTipoTarifaXLim ;
         httpContext.ajax_rsp_assign_attri("", false, "A1338PaiTipoTarifaXLim", GXutil.ltrimstr( A1338PaiTipoTarifaXLim, 6, 4));
         O1337PaiTipoHsSem = A1337PaiTipoHsSem ;
         httpContext.ajax_rsp_assign_attri("", false, "A1337PaiTipoHsSem", GXutil.ltrimstr( A1337PaiTipoHsSem, 4, 1));
         O1336PaiTipoHsDia = A1336PaiTipoHsDia ;
         httpContext.ajax_rsp_assign_attri("", false, "A1336PaiTipoHsDia", GXutil.ltrimstr( A1336PaiTipoHsDia, 3, 1));
         O1297PaiTipoTraIns = A1297PaiTipoTraIns ;
         httpContext.ajax_rsp_assign_attri("", false, "A1297PaiTipoTraIns", A1297PaiTipoTraIns);
         Z46PaiCod = A46PaiCod ;
         Z1294PaiTipoTraId = A1294PaiTipoTraId ;
         sMode155 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load3R155( ) ;
         if ( AnyError == 1 )
         {
            RcdFound155 = (short)(0) ;
            initializeNonKey3R155( ) ;
         }
         Gx_mode = sMode155 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound155 = (short)(0) ;
         initializeNonKey3R155( ) ;
         sMode155 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode155 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey3R155( ) ;
      if ( RcdFound155 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound155 = (short)(0) ;
      /* Using cursor T003R10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T003R10_A46PaiCod[0] < A46PaiCod ) || ( T003R10_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T003R10_A1294PaiTipoTraId[0], A1294PaiTipoTraId) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T003R10_A46PaiCod[0] > A46PaiCod ) || ( T003R10_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T003R10_A1294PaiTipoTraId[0], A1294PaiTipoTraId) > 0 ) ) )
         {
            A46PaiCod = T003R10_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A1294PaiTipoTraId = T003R10_A1294PaiTipoTraId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
            RcdFound155 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound155 = (short)(0) ;
      /* Using cursor T003R11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T003R11_A46PaiCod[0] > A46PaiCod ) || ( T003R11_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T003R11_A1294PaiTipoTraId[0], A1294PaiTipoTraId) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T003R11_A46PaiCod[0] < A46PaiCod ) || ( T003R11_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T003R11_A1294PaiTipoTraId[0], A1294PaiTipoTraId) < 0 ) ) )
         {
            A46PaiCod = T003R11_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A1294PaiTipoTraId = T003R11_A1294PaiTipoTraId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
            RcdFound155 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey3R155( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert3R155( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound155 == 1 )
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A1294PaiTipoTraId, Z1294PaiTipoTraId) != 0 ) )
            {
               A46PaiCod = Z46PaiCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A1294PaiTipoTraId = Z1294PaiTipoTraId ;
               httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
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
               update3R155( ) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A1294PaiTipoTraId, Z1294PaiTipoTraId) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert3R155( ) ;
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
                  insert3R155( ) ;
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
      if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A1294PaiTipoTraId, Z1294PaiTipoTraId) != 0 ) )
      {
         A46PaiCod = Z46PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1294PaiTipoTraId = Z1294PaiTipoTraId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
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

   public void checkOptimisticConcurrency3R155( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T003R2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"PaisTipoTrabajo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z1297PaiTipoTraIns != T003R2_A1297PaiTipoTraIns[0] ) || ( DecimalUtil.compareTo(Z1336PaiTipoHsDia, T003R2_A1336PaiTipoHsDia[0]) != 0 ) || ( DecimalUtil.compareTo(Z1337PaiTipoHsSem, T003R2_A1337PaiTipoHsSem[0]) != 0 ) || ( DecimalUtil.compareTo(Z1338PaiTipoTarifaXLim, T003R2_A1338PaiTipoTarifaXLim[0]) != 0 ) || ( DecimalUtil.compareTo(Z1347PaiTipoTarifaRec, T003R2_A1347PaiTipoTarifaRec[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1383PaiTipoHsMaxDia, T003R2_A1383PaiTipoHsMaxDia[0]) != 0 ) || ( DecimalUtil.compareTo(Z1384PaiTipoHsMaxSem, T003R2_A1384PaiTipoHsMaxSem[0]) != 0 ) || ( DecimalUtil.compareTo(Z1385PaiTipoHsMaxMes, T003R2_A1385PaiTipoHsMaxMes[0]) != 0 ) || ( DecimalUtil.compareTo(Z1390PaiTipoHsMaxAnu, T003R2_A1390PaiTipoHsMaxAnu[0]) != 0 ) || ( Z2055PaiTipoTraRelSec != T003R2_A2055PaiTipoTraRelSec[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2056PaiTipoTraRelRef, T003R2_A2056PaiTipoTraRelRef[0]) != 0 ) || ( GXutil.strcmp(Z2435PaiTipoTraHorDes, T003R2_A2435PaiTipoTraHorDes[0]) != 0 ) )
         {
            if ( Z1297PaiTipoTraIns != T003R2_A1297PaiTipoTraIns[0] )
            {
               GXutil.writeLogln("paistipotrabajo:[seudo value changed for attri]"+"PaiTipoTraIns");
               GXutil.writeLogRaw("Old: ",Z1297PaiTipoTraIns);
               GXutil.writeLogRaw("Current: ",T003R2_A1297PaiTipoTraIns[0]);
            }
            if ( DecimalUtil.compareTo(Z1336PaiTipoHsDia, T003R2_A1336PaiTipoHsDia[0]) != 0 )
            {
               GXutil.writeLogln("paistipotrabajo:[seudo value changed for attri]"+"PaiTipoHsDia");
               GXutil.writeLogRaw("Old: ",Z1336PaiTipoHsDia);
               GXutil.writeLogRaw("Current: ",T003R2_A1336PaiTipoHsDia[0]);
            }
            if ( DecimalUtil.compareTo(Z1337PaiTipoHsSem, T003R2_A1337PaiTipoHsSem[0]) != 0 )
            {
               GXutil.writeLogln("paistipotrabajo:[seudo value changed for attri]"+"PaiTipoHsSem");
               GXutil.writeLogRaw("Old: ",Z1337PaiTipoHsSem);
               GXutil.writeLogRaw("Current: ",T003R2_A1337PaiTipoHsSem[0]);
            }
            if ( DecimalUtil.compareTo(Z1338PaiTipoTarifaXLim, T003R2_A1338PaiTipoTarifaXLim[0]) != 0 )
            {
               GXutil.writeLogln("paistipotrabajo:[seudo value changed for attri]"+"PaiTipoTarifaXLim");
               GXutil.writeLogRaw("Old: ",Z1338PaiTipoTarifaXLim);
               GXutil.writeLogRaw("Current: ",T003R2_A1338PaiTipoTarifaXLim[0]);
            }
            if ( DecimalUtil.compareTo(Z1347PaiTipoTarifaRec, T003R2_A1347PaiTipoTarifaRec[0]) != 0 )
            {
               GXutil.writeLogln("paistipotrabajo:[seudo value changed for attri]"+"PaiTipoTarifaRec");
               GXutil.writeLogRaw("Old: ",Z1347PaiTipoTarifaRec);
               GXutil.writeLogRaw("Current: ",T003R2_A1347PaiTipoTarifaRec[0]);
            }
            if ( DecimalUtil.compareTo(Z1383PaiTipoHsMaxDia, T003R2_A1383PaiTipoHsMaxDia[0]) != 0 )
            {
               GXutil.writeLogln("paistipotrabajo:[seudo value changed for attri]"+"PaiTipoHsMaxDia");
               GXutil.writeLogRaw("Old: ",Z1383PaiTipoHsMaxDia);
               GXutil.writeLogRaw("Current: ",T003R2_A1383PaiTipoHsMaxDia[0]);
            }
            if ( DecimalUtil.compareTo(Z1384PaiTipoHsMaxSem, T003R2_A1384PaiTipoHsMaxSem[0]) != 0 )
            {
               GXutil.writeLogln("paistipotrabajo:[seudo value changed for attri]"+"PaiTipoHsMaxSem");
               GXutil.writeLogRaw("Old: ",Z1384PaiTipoHsMaxSem);
               GXutil.writeLogRaw("Current: ",T003R2_A1384PaiTipoHsMaxSem[0]);
            }
            if ( DecimalUtil.compareTo(Z1385PaiTipoHsMaxMes, T003R2_A1385PaiTipoHsMaxMes[0]) != 0 )
            {
               GXutil.writeLogln("paistipotrabajo:[seudo value changed for attri]"+"PaiTipoHsMaxMes");
               GXutil.writeLogRaw("Old: ",Z1385PaiTipoHsMaxMes);
               GXutil.writeLogRaw("Current: ",T003R2_A1385PaiTipoHsMaxMes[0]);
            }
            if ( DecimalUtil.compareTo(Z1390PaiTipoHsMaxAnu, T003R2_A1390PaiTipoHsMaxAnu[0]) != 0 )
            {
               GXutil.writeLogln("paistipotrabajo:[seudo value changed for attri]"+"PaiTipoHsMaxAnu");
               GXutil.writeLogRaw("Old: ",Z1390PaiTipoHsMaxAnu);
               GXutil.writeLogRaw("Current: ",T003R2_A1390PaiTipoHsMaxAnu[0]);
            }
            if ( Z2055PaiTipoTraRelSec != T003R2_A2055PaiTipoTraRelSec[0] )
            {
               GXutil.writeLogln("paistipotrabajo:[seudo value changed for attri]"+"PaiTipoTraRelSec");
               GXutil.writeLogRaw("Old: ",Z2055PaiTipoTraRelSec);
               GXutil.writeLogRaw("Current: ",T003R2_A2055PaiTipoTraRelSec[0]);
            }
            if ( GXutil.strcmp(Z2056PaiTipoTraRelRef, T003R2_A2056PaiTipoTraRelRef[0]) != 0 )
            {
               GXutil.writeLogln("paistipotrabajo:[seudo value changed for attri]"+"PaiTipoTraRelRef");
               GXutil.writeLogRaw("Old: ",Z2056PaiTipoTraRelRef);
               GXutil.writeLogRaw("Current: ",T003R2_A2056PaiTipoTraRelRef[0]);
            }
            if ( GXutil.strcmp(Z2435PaiTipoTraHorDes, T003R2_A2435PaiTipoTraHorDes[0]) != 0 )
            {
               GXutil.writeLogln("paistipotrabajo:[seudo value changed for attri]"+"PaiTipoTraHorDes");
               GXutil.writeLogRaw("Old: ",Z2435PaiTipoTraHorDes);
               GXutil.writeLogRaw("Current: ",T003R2_A2435PaiTipoTraHorDes[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"PaisTipoTrabajo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert3R155( )
   {
      beforeValidate3R155( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3R155( ) ;
      }
      if ( AnyError == 0 )
      {
         zm3R155( 0) ;
         checkOptimisticConcurrency3R155( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3R155( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert3R155( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003R12 */
                  pr_default.execute(10, new Object[] {A1976PaiTipoTraOldDefault, Boolean.valueOf(A1297PaiTipoTraIns), A1336PaiTipoHsDia, A1337PaiTipoHsSem, A1338PaiTipoTarifaXLim, A1347PaiTipoTarifaRec, A1383PaiTipoHsMaxDia, A1384PaiTipoHsMaxSem, A1385PaiTipoHsMaxMes, A1390PaiTipoHsMaxAnu, Integer.valueOf(A2055PaiTipoTraRelSec), A2056PaiTipoTraRelRef, A2070PaiTipoTraOld, A2435PaiTipoTraHorDes, Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisTipoTrabajo");
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
                        resetCaption3R0( ) ;
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
            load3R155( ) ;
         }
         endLevel3R155( ) ;
      }
      closeExtendedTableCursors3R155( ) ;
   }

   public void update3R155( )
   {
      beforeValidate3R155( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3R155( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3R155( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3R155( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate3R155( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003R13 */
                  pr_default.execute(11, new Object[] {A1976PaiTipoTraOldDefault, Boolean.valueOf(A1297PaiTipoTraIns), A1336PaiTipoHsDia, A1337PaiTipoHsSem, A1338PaiTipoTarifaXLim, A1347PaiTipoTarifaRec, A1383PaiTipoHsMaxDia, A1384PaiTipoHsMaxSem, A1385PaiTipoHsMaxMes, A1390PaiTipoHsMaxAnu, Integer.valueOf(A2055PaiTipoTraRelSec), A2056PaiTipoTraRelRef, A2070PaiTipoTraOld, A2435PaiTipoTraHorDes, Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisTipoTrabajo");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"PaisTipoTrabajo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate3R155( ) ;
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
         endLevel3R155( ) ;
      }
      closeExtendedTableCursors3R155( ) ;
   }

   public void deferredUpdate3R155( )
   {
   }

   public void delete( )
   {
      beforeValidate3R155( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3R155( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls3R155( ) ;
         afterConfirm3R155( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete3R155( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T003R14 */
               pr_default.execute(12, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisTipoTrabajo");
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
      sMode155 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel3R155( ) ;
      Gx_mode = sMode155 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls3R155( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean7[0] = AV23aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV24CliCod, A2055PaiTipoTraRelSec, GXv_boolean7) ;
            paistipotrabajo_impl.this.AV23aplicadoHay = GXv_boolean7[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
         }
         AV25Pgmname = "PaisTipoTrabajo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
         /* Using cursor T003R15 */
         pr_default.execute(13, new Object[] {A1294PaiTipoTraId});
         pr_default.close(13);
         if ( ! ( ( A1297PaiTipoTraIns != O1297PaiTipoTraIns ) || ( DecimalUtil.compareTo(A1336PaiTipoHsDia, O1336PaiTipoHsDia) != 0 ) || ( DecimalUtil.compareTo(A1337PaiTipoHsSem, O1337PaiTipoHsSem) != 0 ) || ( DecimalUtil.compareTo(A1338PaiTipoTarifaXLim, O1338PaiTipoTarifaXLim) != 0 ) || ( DecimalUtil.compareTo(A1347PaiTipoTarifaRec, O1347PaiTipoTarifaRec) != 0 ) || ( DecimalUtil.compareTo(A1383PaiTipoHsMaxDia, O1383PaiTipoHsMaxDia) != 0 ) || ( DecimalUtil.compareTo(A1384PaiTipoHsMaxSem, O1384PaiTipoHsMaxSem) != 0 ) || ( DecimalUtil.compareTo(A1385PaiTipoHsMaxMes, O1385PaiTipoHsMaxMes) != 0 ) || ( DecimalUtil.compareTo(A1390PaiTipoHsMaxAnu, O1390PaiTipoHsMaxAnu) != 0 ) ) )
         {
            divPaitipotrarelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divPaitipotrarelsec_cell_Internalname, "Class", divPaitipotrarelsec_cell_Class, true);
         }
         else
         {
            if ( ( A1297PaiTipoTraIns != O1297PaiTipoTraIns ) || ( DecimalUtil.compareTo(A1336PaiTipoHsDia, O1336PaiTipoHsDia) != 0 ) || ( DecimalUtil.compareTo(A1337PaiTipoHsSem, O1337PaiTipoHsSem) != 0 ) || ( DecimalUtil.compareTo(A1338PaiTipoTarifaXLim, O1338PaiTipoTarifaXLim) != 0 ) || ( DecimalUtil.compareTo(A1347PaiTipoTarifaRec, O1347PaiTipoTarifaRec) != 0 ) || ( DecimalUtil.compareTo(A1383PaiTipoHsMaxDia, O1383PaiTipoHsMaxDia) != 0 ) || ( DecimalUtil.compareTo(A1384PaiTipoHsMaxSem, O1384PaiTipoHsMaxSem) != 0 ) || ( DecimalUtil.compareTo(A1385PaiTipoHsMaxMes, O1385PaiTipoHsMaxMes) != 0 ) || ( DecimalUtil.compareTo(A1390PaiTipoHsMaxAnu, O1390PaiTipoHsMaxAnu) != 0 ) )
            {
               divPaitipotrarelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divPaitipotrarelsec_cell_Internalname, "Class", divPaitipotrarelsec_cell_Class, true);
            }
         }
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T003R16 */
         pr_default.execute(14, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "convenio_tiposdetrabajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
         /* Using cursor T003R17 */
         pr_default.execute(15, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "convenio_tiposdetrabajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor T003R18 */
         pr_default.execute(16, new Object[] {Short.valueOf(A46PaiCod), A1294PaiTipoTraId});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "horasextras_pordia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
      }
   }

   public void endLevel3R155( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete3R155( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "paistipotrabajo");
         if ( AnyError == 0 )
         {
            confirmValues3R0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "paistipotrabajo");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart3R155( )
   {
      /* Scan By routine */
      /* Using cursor T003R19 */
      pr_default.execute(17);
      RcdFound155 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound155 = (short)(1) ;
         A46PaiCod = T003R19_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1294PaiTipoTraId = T003R19_A1294PaiTipoTraId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext3R155( )
   {
      /* Scan next routine */
      pr_default.readNext(17);
      RcdFound155 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound155 = (short)(1) ;
         A46PaiCod = T003R19_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1294PaiTipoTraId = T003R19_A1294PaiTipoTraId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      }
   }

   public void scanEnd3R155( )
   {
      pr_default.close(17);
   }

   public void afterConfirm3R155( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV23aplicadoHay ) && ! (0==A2055PaiTipoTraRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV24CliCod), "PaiTipoTraRelSec", 1, "PAITIPOTRARELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynPaiTipoTraRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert3R155( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate3R155( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete3R155( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete3R155( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate3R155( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes3R155( )
   {
      edtPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      cmbPaiTipoTraId.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiTipoTraId.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiTipoTraId.getEnabled(), 5, 0), true);
      chkPaiTipoTraIns.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiTipoTraIns.getInternalname(), "Enabled", GXutil.ltrimstr( chkPaiTipoTraIns.getEnabled(), 5, 0), true);
      edtPaiTipoHsDia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiTipoHsDia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiTipoHsDia_Enabled), 5, 0), true);
      edtPaiTipoHsSem_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiTipoHsSem_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiTipoHsSem_Enabled), 5, 0), true);
      edtPaiTipoHsMaxDia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiTipoHsMaxDia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiTipoHsMaxDia_Enabled), 5, 0), true);
      edtPaiTipoHsMaxSem_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiTipoHsMaxSem_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiTipoHsMaxSem_Enabled), 5, 0), true);
      cmbPaiTipoHsMaxMes.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPaiTipoHsMaxMes.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPaiTipoHsMaxMes.getEnabled(), 5, 0), true);
      edtPaiTipoHsMaxAnu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiTipoHsMaxAnu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiTipoHsMaxAnu_Enabled), 5, 0), true);
      dynPaiTipoTraRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynPaiTipoTraRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynPaiTipoTraRelSec.getEnabled(), 5, 0), true);
      edtavCombopaicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopaicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopaicod_Enabled), 5, 0), true);
      cmbavCombopaitipotraid.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCombopaitipotraid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavCombopaitipotraid.getEnabled(), 5, 0), true);
   }

   public void send_integrity_lvl_hashes3R155( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues3R0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.paistipotrabajo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV8PaiTipoTraId))}, new String[] {"Gx_mode","PaiCod","PaiTipoTraId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"PaisTipoTrabajo");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("PaiTipoTarifaXLim", localUtil.format( A1338PaiTipoTarifaXLim, "9.9999"));
      forbiddenHiddens.add("PaiTipoTarifaRec", localUtil.format( A1347PaiTipoTarifaRec, "9.9999"));
      forbiddenHiddens.add("PaiTipoTraRelRef", GXutil.rtrim( localUtil.format( A2056PaiTipoTraRelRef, "")));
      forbiddenHiddens.add("PaiTipoTraHorDes", GXutil.rtrim( localUtil.format( A2435PaiTipoTraHorDes, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("paistipotrabajo:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z46PaiCod", GXutil.ltrim( localUtil.ntoc( Z46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1294PaiTipoTraId", GXutil.rtrim( Z1294PaiTipoTraId));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1297PaiTipoTraIns", Z1297PaiTipoTraIns);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1336PaiTipoHsDia", GXutil.ltrim( localUtil.ntoc( Z1336PaiTipoHsDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1337PaiTipoHsSem", GXutil.ltrim( localUtil.ntoc( Z1337PaiTipoHsSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1338PaiTipoTarifaXLim", GXutil.ltrim( localUtil.ntoc( Z1338PaiTipoTarifaXLim, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1347PaiTipoTarifaRec", GXutil.ltrim( localUtil.ntoc( Z1347PaiTipoTarifaRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1383PaiTipoHsMaxDia", GXutil.ltrim( localUtil.ntoc( Z1383PaiTipoHsMaxDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1384PaiTipoHsMaxSem", GXutil.ltrim( localUtil.ntoc( Z1384PaiTipoHsMaxSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1385PaiTipoHsMaxMes", GXutil.ltrim( localUtil.ntoc( Z1385PaiTipoHsMaxMes, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1390PaiTipoHsMaxAnu", GXutil.ltrim( localUtil.ntoc( Z1390PaiTipoHsMaxAnu, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2055PaiTipoTraRelSec", GXutil.ltrim( localUtil.ntoc( Z2055PaiTipoTraRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2056PaiTipoTraRelRef", Z2056PaiTipoTraRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2435PaiTipoTraHorDes", GXutil.rtrim( Z2435PaiTipoTraHorDes));
      web.GxWebStd.gx_hidden_field( httpContext, "O1390PaiTipoHsMaxAnu", GXutil.ltrim( localUtil.ntoc( O1390PaiTipoHsMaxAnu, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1385PaiTipoHsMaxMes", GXutil.ltrim( localUtil.ntoc( O1385PaiTipoHsMaxMes, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1384PaiTipoHsMaxSem", GXutil.ltrim( localUtil.ntoc( O1384PaiTipoHsMaxSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1383PaiTipoHsMaxDia", GXutil.ltrim( localUtil.ntoc( O1383PaiTipoHsMaxDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1347PaiTipoTarifaRec", GXutil.ltrim( localUtil.ntoc( O1347PaiTipoTarifaRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1338PaiTipoTarifaXLim", GXutil.ltrim( localUtil.ntoc( O1338PaiTipoTarifaXLim, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1337PaiTipoHsSem", GXutil.ltrim( localUtil.ntoc( O1337PaiTipoHsSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1336PaiTipoHsDia", GXutil.ltrim( localUtil.ntoc( O1336PaiTipoHsDia, (byte)(3), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O1297PaiTipoTraIns", O1297PaiTipoTraIns);
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV15DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV15DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPAICOD_DATA", AV14PaiCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPAICOD_DATA", AV14PaiCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPAITIPOTRAID_DATA", AV20PaiTipoTraId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPAITIPOTRAID_DATA", AV20PaiTipoTraId_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV7PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAITIPOTRAID", GXutil.rtrim( AV8PaiTipoTraId));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAITIPOTRAID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8PaiTipoTraId, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "PAITIPOTARIFAXLIM", GXutil.ltrim( localUtil.ntoc( A1338PaiTipoTarifaXLim, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PAITIPOTARIFAREC", GXutil.ltrim( localUtil.ntoc( A1347PaiTipoTarifaRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PAITIPOTRAOLDDEFAULT", A1976PaiTipoTraOldDefault);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV24CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV23aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "PAITIPOTRARELREF", A2056PaiTipoTraRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "PAITIPOTRAOLD", A2070PaiTipoTraOld);
      web.GxWebStd.gx_hidden_field( httpContext, "PAITIPOTRAHORDES", GXutil.rtrim( A2435PaiTipoTraHorDes));
      web.GxWebStd.gx_hidden_field( httpContext, "PAITIPOTRANOM", A1295PaiTipoTraNom);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV25Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Objectcall", GXutil.rtrim( Combo_paicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Cls", GXutil.rtrim( Combo_paicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Selectedvalue_set", GXutil.rtrim( Combo_paicod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Selectedtext_set", GXutil.rtrim( Combo_paicod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Enabled", GXutil.booltostr( Combo_paicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Datalistproc", GXutil.rtrim( Combo_paicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_paicod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Emptyitem", GXutil.booltostr( Combo_paicod_Emptyitem));
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
      return formatLink("web.paistipotrabajo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV8PaiTipoTraId))}, new String[] {"Gx_mode","PaiCod","PaiTipoTraId"})  ;
   }

   public String getPgmname( )
   {
      return "PaisTipoTrabajo" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Pais Tipo Trabajo", "") ;
   }

   public void initializeNonKey3R155( )
   {
      A1292TipoTraId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1292TipoTraId", A1292TipoTraId);
      A1976PaiTipoTraOldDefault = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1976PaiTipoTraOldDefault", A1976PaiTipoTraOldDefault);
      AV23aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
      A1295PaiTipoTraNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1295PaiTipoTraNom", A1295PaiTipoTraNom);
      A1297PaiTipoTraIns = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1297PaiTipoTraIns", A1297PaiTipoTraIns);
      A1336PaiTipoHsDia = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1336PaiTipoHsDia", GXutil.ltrimstr( A1336PaiTipoHsDia, 3, 1));
      A1337PaiTipoHsSem = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1337PaiTipoHsSem", GXutil.ltrimstr( A1337PaiTipoHsSem, 4, 1));
      A1338PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1338PaiTipoTarifaXLim", GXutil.ltrimstr( A1338PaiTipoTarifaXLim, 6, 4));
      A1347PaiTipoTarifaRec = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1347PaiTipoTarifaRec", GXutil.ltrimstr( A1347PaiTipoTarifaRec, 6, 4));
      A1383PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1383PaiTipoHsMaxDia", GXutil.ltrimstr( A1383PaiTipoHsMaxDia, 3, 1));
      A1384PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1384PaiTipoHsMaxSem", GXutil.ltrimstr( A1384PaiTipoHsMaxSem, 4, 1));
      A1385PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1385PaiTipoHsMaxMes", GXutil.ltrimstr( A1385PaiTipoHsMaxMes, 5, 1));
      A1390PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1390PaiTipoHsMaxAnu", GXutil.ltrimstr( A1390PaiTipoHsMaxAnu, 5, 1));
      A2055PaiTipoTraRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2055PaiTipoTraRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2055PaiTipoTraRelSec), 6, 0));
      A2056PaiTipoTraRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2056PaiTipoTraRelRef", A2056PaiTipoTraRelRef);
      A2070PaiTipoTraOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2070PaiTipoTraOld", A2070PaiTipoTraOld);
      A2435PaiTipoTraHorDes = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2435PaiTipoTraHorDes", A2435PaiTipoTraHorDes);
      O1390PaiTipoHsMaxAnu = A1390PaiTipoHsMaxAnu ;
      httpContext.ajax_rsp_assign_attri("", false, "A1390PaiTipoHsMaxAnu", GXutil.ltrimstr( A1390PaiTipoHsMaxAnu, 5, 1));
      O1385PaiTipoHsMaxMes = A1385PaiTipoHsMaxMes ;
      httpContext.ajax_rsp_assign_attri("", false, "A1385PaiTipoHsMaxMes", GXutil.ltrimstr( A1385PaiTipoHsMaxMes, 5, 1));
      O1384PaiTipoHsMaxSem = A1384PaiTipoHsMaxSem ;
      httpContext.ajax_rsp_assign_attri("", false, "A1384PaiTipoHsMaxSem", GXutil.ltrimstr( A1384PaiTipoHsMaxSem, 4, 1));
      O1383PaiTipoHsMaxDia = A1383PaiTipoHsMaxDia ;
      httpContext.ajax_rsp_assign_attri("", false, "A1383PaiTipoHsMaxDia", GXutil.ltrimstr( A1383PaiTipoHsMaxDia, 3, 1));
      O1347PaiTipoTarifaRec = A1347PaiTipoTarifaRec ;
      httpContext.ajax_rsp_assign_attri("", false, "A1347PaiTipoTarifaRec", GXutil.ltrimstr( A1347PaiTipoTarifaRec, 6, 4));
      O1338PaiTipoTarifaXLim = A1338PaiTipoTarifaXLim ;
      httpContext.ajax_rsp_assign_attri("", false, "A1338PaiTipoTarifaXLim", GXutil.ltrimstr( A1338PaiTipoTarifaXLim, 6, 4));
      O1337PaiTipoHsSem = A1337PaiTipoHsSem ;
      httpContext.ajax_rsp_assign_attri("", false, "A1337PaiTipoHsSem", GXutil.ltrimstr( A1337PaiTipoHsSem, 4, 1));
      O1336PaiTipoHsDia = A1336PaiTipoHsDia ;
      httpContext.ajax_rsp_assign_attri("", false, "A1336PaiTipoHsDia", GXutil.ltrimstr( A1336PaiTipoHsDia, 3, 1));
      O1297PaiTipoTraIns = A1297PaiTipoTraIns ;
      httpContext.ajax_rsp_assign_attri("", false, "A1297PaiTipoTraIns", A1297PaiTipoTraIns);
      Z1297PaiTipoTraIns = false ;
      Z1336PaiTipoHsDia = DecimalUtil.ZERO ;
      Z1337PaiTipoHsSem = DecimalUtil.ZERO ;
      Z1338PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      Z1347PaiTipoTarifaRec = DecimalUtil.ZERO ;
      Z1383PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      Z1384PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      Z1385PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      Z1390PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      Z2055PaiTipoTraRelSec = 0 ;
      Z2056PaiTipoTraRelRef = "" ;
      Z2435PaiTipoTraHorDes = "" ;
   }

   public void initAll3R155( )
   {
      A46PaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A1294PaiTipoTraId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1294PaiTipoTraId", A1294PaiTipoTraId);
      initializeNonKey3R155( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025198514353", true, true);
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
      httpContext.AddJavascriptSource("paistipotrabajo.js", "?2025198514353", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      lblTextblockpaicod_Internalname = "TEXTBLOCKPAICOD" ;
      Combo_paicod_Internalname = "COMBO_PAICOD" ;
      edtPaiCod_Internalname = "PAICOD" ;
      divTablesplittedpaicod_Internalname = "TABLESPLITTEDPAICOD" ;
      lblTextblockpaitipotraid_Internalname = "TEXTBLOCKPAITIPOTRAID" ;
      Combo_paitipotraid_Internalname = "COMBO_PAITIPOTRAID" ;
      cmbPaiTipoTraId.setInternalname( "PAITIPOTRAID" );
      divTablesplittedpaitipotraid_Internalname = "TABLESPLITTEDPAITIPOTRAID" ;
      chkPaiTipoTraIns.setInternalname( "PAITIPOTRAINS" );
      edtPaiTipoHsDia_Internalname = "PAITIPOHSDIA" ;
      edtPaiTipoHsSem_Internalname = "PAITIPOHSSEM" ;
      edtPaiTipoHsMaxDia_Internalname = "PAITIPOHSMAXDIA" ;
      edtPaiTipoHsMaxSem_Internalname = "PAITIPOHSMAXSEM" ;
      cmbPaiTipoHsMaxMes.setInternalname( "PAITIPOHSMAXMES" );
      edtPaiTipoHsMaxAnu_Internalname = "PAITIPOHSMAXANU" ;
      dynPaiTipoTraRelSec.setInternalname( "PAITIPOTRARELSEC" );
      divPaitipotrarelsec_cell_Internalname = "PAITIPOTRARELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombopaicod_Internalname = "vCOMBOPAICOD" ;
      divSectionattribute_paicod_Internalname = "SECTIONATTRIBUTE_PAICOD" ;
      cmbavCombopaitipotraid.setInternalname( "vCOMBOPAITIPOTRAID" );
      divSectionattribute_paitipotraid_Internalname = "SECTIONATTRIBUTE_PAITIPOTRAID" ;
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
      Form.setCaption( httpContext.getMessage( "Pais Tipo Trabajo", "") );
      cmbavCombopaitipotraid.setJsonclick( "" );
      cmbavCombopaitipotraid.setVisible( 1 );
      cmbavCombopaitipotraid.setEnabled( 0 );
      edtavCombopaicod_Jsonclick = "" ;
      edtavCombopaicod_Enabled = 0 ;
      edtavCombopaicod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynPaiTipoTraRelSec.setJsonclick( "" );
      dynPaiTipoTraRelSec.setEnabled( 1 );
      divPaitipotrarelsec_cell_Class = "col-xs-12" ;
      edtPaiTipoHsMaxAnu_Jsonclick = "" ;
      edtPaiTipoHsMaxAnu_Enabled = 1 ;
      cmbPaiTipoHsMaxMes.setJsonclick( "" );
      cmbPaiTipoHsMaxMes.setEnabled( 1 );
      edtPaiTipoHsMaxSem_Jsonclick = "" ;
      edtPaiTipoHsMaxSem_Enabled = 1 ;
      edtPaiTipoHsMaxDia_Jsonclick = "" ;
      edtPaiTipoHsMaxDia_Enabled = 1 ;
      edtPaiTipoHsSem_Jsonclick = "" ;
      edtPaiTipoHsSem_Enabled = 1 ;
      edtPaiTipoHsDia_Jsonclick = "" ;
      edtPaiTipoHsDia_Enabled = 1 ;
      chkPaiTipoTraIns.setEnabled( 1 );
      cmbPaiTipoTraId.setJsonclick( "" );
      cmbPaiTipoTraId.setVisible( 1 );
      cmbPaiTipoTraId.setEnabled( 1 );
      Combo_paitipotraid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_paitipotraid_Datalistprocparametersprefix = " \"ComboName\": \"PaiTipoTraId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PaiCod\": 0, \"PaiTipoTraId\": \"\"" ;
      Combo_paitipotraid_Datalistproc = "PaisTipoTrabajoLoadDVCombo" ;
      Combo_paitipotraid_Cls = "ExtendedCombo Attribute" ;
      Combo_paitipotraid_Caption = "" ;
      Combo_paitipotraid_Enabled = GXutil.toBoolean( -1) ;
      edtPaiCod_Jsonclick = "" ;
      edtPaiCod_Enabled = 1 ;
      edtPaiCod_Visible = 1 ;
      Combo_paicod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_paicod_Datalistprocparametersprefix = " \"ComboName\": \"PaiCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PaiCod\": 0, \"PaiTipoTraId\": \"\"" ;
      Combo_paicod_Datalistproc = "PaisTipoTrabajoLoadDVCombo" ;
      Combo_paicod_Cls = "ExtendedCombo Attribute" ;
      Combo_paicod_Caption = "" ;
      Combo_paicod_Enabled = GXutil.toBoolean( -1) ;
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

   public void gxdlapaitipotrarelsec3R155( int AV24CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlapaitipotrarelsec_data3R155( AV24CliCod) ;
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

   public void gxapaitipotrarelsec_html3R155( int AV24CliCod )
   {
      int gxdynajaxvalue;
      gxdlapaitipotrarelsec_data3R155( AV24CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynPaiTipoTraRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynPaiTipoTraRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlapaitipotrarelsec_data3R155( int AV24CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T003R20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(AV24CliCod)});
      while ( (pr_default.getStatus(18) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T003R20_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T003R20_A1880CliReDTChar[0]);
         pr_default.readNext(18);
      }
      pr_default.close(18);
   }

   public void gx7asapaitipotraolddefault3R155( java.math.BigDecimal A1337PaiTipoHsSem ,
                                                java.math.BigDecimal A1338PaiTipoTarifaXLim ,
                                                java.math.BigDecimal A1347PaiTipoTarifaRec ,
                                                java.math.BigDecimal A1383PaiTipoHsMaxDia ,
                                                java.math.BigDecimal A1384PaiTipoHsMaxSem ,
                                                java.math.BigDecimal A1385PaiTipoHsMaxMes ,
                                                java.math.BigDecimal A1390PaiTipoHsMaxAnu ,
                                                String Gx_mode ,
                                                java.math.BigDecimal A1336PaiTipoHsDia )
   {
      if ( isUpd( )  )
      {
         GXt_char8 = A1976PaiTipoTraOldDefault ;
         GXv_char11[0] = GXt_char8 ;
         new web.paistipotrabajosetolddef(remoteHandle, context).execute( O1336PaiTipoHsDia, O1337PaiTipoHsSem, O1338PaiTipoTarifaXLim, O1347PaiTipoTarifaRec, O1383PaiTipoHsMaxDia, O1384PaiTipoHsMaxSem, O1385PaiTipoHsMaxMes, O1390PaiTipoHsMaxAnu, GXv_char11) ;
         paistipotrabajo_impl.this.GXt_char8 = GXv_char11[0] ;
         A1976PaiTipoTraOldDefault = GXt_char8 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1976PaiTipoTraOldDefault", A1976PaiTipoTraOldDefault);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1976PaiTipoTraOldDefault)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_12_3R155( String Gx_mode ,
                            int AV24CliCod ,
                            int A2055PaiTipoTraRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean7[0] = AV23aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV24CliCod, A2055PaiTipoTraRelSec, GXv_boolean7) ;
         AV23aplicadoHay = GXv_boolean7[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV23aplicadoHay))+"\"") ;
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
      chkPaiTipoTraIns.setName( "PAITIPOTRAINS" );
      chkPaiTipoTraIns.setWebtags( "" );
      chkPaiTipoTraIns.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkPaiTipoTraIns.getInternalname(), "TitleCaption", chkPaiTipoTraIns.getCaption(), true);
      chkPaiTipoTraIns.setCheckedValue( "false" );
      A1297PaiTipoTraIns = GXutil.strtobool( GXutil.booltostr( A1297PaiTipoTraIns)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1297PaiTipoTraIns", A1297PaiTipoTraIns);
      cmbPaiTipoHsMaxMes.setName( "PAITIPOHSMAXMES" );
      cmbPaiTipoHsMaxMes.setWebtags( "" );
      if ( cmbPaiTipoHsMaxMes.getItemCount() > 0 )
      {
         A1385PaiTipoHsMaxMes = DecimalUtil.stringToDec( cmbPaiTipoHsMaxMes.getValidValue(GXutil.strNoRound( A1385PaiTipoHsMaxMes, 5, 1))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1385PaiTipoHsMaxMes", GXutil.ltrimstr( A1385PaiTipoHsMaxMes, 5, 1));
      }
      dynPaiTipoTraRelSec.setName( "PAITIPOTRARELSEC" );
      dynPaiTipoTraRelSec.setWebtags( "" );
      cmbavCombopaitipotraid.setName( "vCOMBOPAITIPOTRAID" );
      cmbavCombopaitipotraid.setWebtags( "" );
      cmbavCombopaitipotraid.addItem("diurno", httpContext.getMessage( "Diurno", ""), (short)(0));
      cmbavCombopaitipotraid.addItem("nocturno", httpContext.getMessage( "Nocturno", ""), (short)(0));
      cmbavCombopaitipotraid.addItem("insalubre", httpContext.getMessage( "Insalubre", ""), (short)(0));
      if ( cmbavCombopaitipotraid.getItemCount() > 0 )
      {
         AV21ComboPaiTipoTraId = cmbavCombopaitipotraid.getValidValue(AV21ComboPaiTipoTraId) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21ComboPaiTipoTraId", AV21ComboPaiTipoTraId);
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

   public void valid_Paicod( )
   {
      A2055PaiTipoTraRelSec = (int)(GXutil.lval( dynPaiTipoTraRelSec.getValue())) ;
      /* Using cursor T003R21 */
      pr_default.execute(19, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
      }
      pr_default.close(19);
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

   public void valid_Paitipotraid( )
   {
      A1294PaiTipoTraId = cmbPaiTipoTraId.getValue() ;
      A2055PaiTipoTraRelSec = (int)(GXutil.lval( dynPaiTipoTraRelSec.getValue())) ;
      /* Using cursor T003R22 */
      pr_default.execute(20, new Object[] {A1294PaiTipoTraId});
      if ( (pr_default.getStatus(20) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Trabajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAITIPOTRAID");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPaiTipoTraId.getInternalname() ;
      }
      pr_default.close(20);
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
      httpContext.ajax_rsp_assign_attri("", false, "A1295PaiTipoTraNom", A1295PaiTipoTraNom);
   }

   public void valid_Paitipohsmaxanu( )
   {
      A1385PaiTipoHsMaxMes = DecimalUtil.stringToDec( cmbPaiTipoHsMaxMes.getValue()) ;
      A2055PaiTipoTraRelSec = (int)(GXutil.lval( dynPaiTipoTraRelSec.getValue())) ;
      if ( ! ( ( A1297PaiTipoTraIns != O1297PaiTipoTraIns ) || ( DecimalUtil.compareTo(A1336PaiTipoHsDia, O1336PaiTipoHsDia) != 0 ) || ( DecimalUtil.compareTo(A1337PaiTipoHsSem, O1337PaiTipoHsSem) != 0 ) || ( DecimalUtil.compareTo(A1338PaiTipoTarifaXLim, O1338PaiTipoTarifaXLim) != 0 ) || ( DecimalUtil.compareTo(A1347PaiTipoTarifaRec, O1347PaiTipoTarifaRec) != 0 ) || ( DecimalUtil.compareTo(A1383PaiTipoHsMaxDia, O1383PaiTipoHsMaxDia) != 0 ) || ( DecimalUtil.compareTo(A1384PaiTipoHsMaxSem, O1384PaiTipoHsMaxSem) != 0 ) || ( DecimalUtil.compareTo(A1385PaiTipoHsMaxMes, O1385PaiTipoHsMaxMes) != 0 ) || ( DecimalUtil.compareTo(A1390PaiTipoHsMaxAnu, O1390PaiTipoHsMaxAnu) != 0 ) ) )
      {
         divPaitipotrarelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
      }
      else
      {
         if ( ( A1297PaiTipoTraIns != O1297PaiTipoTraIns ) || ( DecimalUtil.compareTo(A1336PaiTipoHsDia, O1336PaiTipoHsDia) != 0 ) || ( DecimalUtil.compareTo(A1337PaiTipoHsSem, O1337PaiTipoHsSem) != 0 ) || ( DecimalUtil.compareTo(A1338PaiTipoTarifaXLim, O1338PaiTipoTarifaXLim) != 0 ) || ( DecimalUtil.compareTo(A1347PaiTipoTarifaRec, O1347PaiTipoTarifaRec) != 0 ) || ( DecimalUtil.compareTo(A1383PaiTipoHsMaxDia, O1383PaiTipoHsMaxDia) != 0 ) || ( DecimalUtil.compareTo(A1384PaiTipoHsMaxSem, O1384PaiTipoHsMaxSem) != 0 ) || ( DecimalUtil.compareTo(A1385PaiTipoHsMaxMes, O1385PaiTipoHsMaxMes) != 0 ) || ( DecimalUtil.compareTo(A1390PaiTipoHsMaxAnu, O1390PaiTipoHsMaxAnu) != 0 ) )
         {
            divPaitipotrarelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
         }
      }
      if ( isUpd( )  )
      {
         GXt_char8 = A1976PaiTipoTraOldDefault ;
         GXv_char11[0] = GXt_char8 ;
         new web.paistipotrabajosetolddef(remoteHandle, context).execute( O1336PaiTipoHsDia, O1337PaiTipoHsSem, O1338PaiTipoTarifaXLim, O1347PaiTipoTarifaRec, O1383PaiTipoHsMaxDia, O1384PaiTipoHsMaxSem, O1385PaiTipoHsMaxMes, O1390PaiTipoHsMaxAnu, GXv_char11) ;
         paistipotrabajo_impl.this.GXt_char8 = GXv_char11[0] ;
         A1976PaiTipoTraOldDefault = GXt_char8 ;
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
      httpContext.ajax_rsp_assign_prop("", false, divPaitipotrarelsec_cell_Internalname, "Class", divPaitipotrarelsec_cell_Class, true);
      httpContext.ajax_rsp_assign_attri("", false, "A1976PaiTipoTraOldDefault", A1976PaiTipoTraOldDefault);
   }

   public void valid_Paitipotrarelsec( )
   {
      A1385PaiTipoHsMaxMes = DecimalUtil.stringToDec( cmbPaiTipoHsMaxMes.getValue()) ;
      A2055PaiTipoTraRelSec = (int)(GXutil.lval( dynPaiTipoTraRelSec.getValue())) ;
      if ( ( ( A1297PaiTipoTraIns != O1297PaiTipoTraIns ) || ( DecimalUtil.compareTo(A1336PaiTipoHsDia, O1336PaiTipoHsDia) != 0 ) || ( DecimalUtil.compareTo(A1337PaiTipoHsSem, O1337PaiTipoHsSem) != 0 ) || ( DecimalUtil.compareTo(A1338PaiTipoTarifaXLim, O1338PaiTipoTarifaXLim) != 0 ) || ( DecimalUtil.compareTo(A1347PaiTipoTarifaRec, O1347PaiTipoTarifaRec) != 0 ) || ( DecimalUtil.compareTo(A1383PaiTipoHsMaxDia, O1383PaiTipoHsMaxDia) != 0 ) || ( DecimalUtil.compareTo(A1384PaiTipoHsMaxSem, O1384PaiTipoHsMaxSem) != 0 ) || ( DecimalUtil.compareTo(A1385PaiTipoHsMaxMes, O1385PaiTipoHsMaxMes) != 0 ) || ( DecimalUtil.compareTo(A1390PaiTipoHsMaxAnu, O1390PaiTipoHsMaxAnu) != 0 ) ) && (0==A2055PaiTipoTraRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "PAITIPOTRARELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynPaiTipoTraRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean7[0] = AV23aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV24CliCod, A2055PaiTipoTraRelSec, GXv_boolean7) ;
         paistipotrabajo_impl.this.AV23aplicadoHay = GXv_boolean7[0] ;
         AV23aplicadoHay = this.AV23aplicadoHay ;
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
      httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV8PaiTipoTraId',fld:'vPAITIPOTRAID',pic:'',hsh:true},{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV8PaiTipoTraId',fld:'vPAITIPOTRAID',pic:'',hsh:true},{av:'A1338PaiTipoTarifaXLim',fld:'PAITIPOTARIFAXLIM',pic:'9.9999'},{av:'A1347PaiTipoTarifaRec',fld:'PAITIPOTARIFAREC',pic:'9.9999'},{av:'A2056PaiTipoTraRelRef',fld:'PAITIPOTRARELREF',pic:''},{av:'A2435PaiTipoTraHorDes',fld:'PAITIPOTRAHORDES',pic:''},{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e123R2',iparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]}");
      setEventMetadata("VALID_PAICOD","{handler:'valid_Paicod',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'AV24CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynPaiTipoTraRelSec'},{av:'A2055PaiTipoTraRelSec',fld:'PAITIPOTRARELSEC',pic:'ZZZZZ9'},{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]");
      setEventMetadata("VALID_PAICOD",",oparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]}");
      setEventMetadata("VALID_PAITIPOTRAID","{handler:'valid_Paitipotraid',iparms:[{av:'cmbPaiTipoTraId'},{av:'A1294PaiTipoTraId',fld:'PAITIPOTRAID',pic:''},{av:'AV24CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynPaiTipoTraRelSec'},{av:'A2055PaiTipoTraRelSec',fld:'PAITIPOTRARELSEC',pic:'ZZZZZ9'},{av:'A1295PaiTipoTraNom',fld:'PAITIPOTRANOM',pic:'@!'},{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]");
      setEventMetadata("VALID_PAITIPOTRAID",",oparms:[{av:'A1295PaiTipoTraNom',fld:'PAITIPOTRANOM',pic:'@!'},{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]}");
      setEventMetadata("VALID_PAITIPOTRAINS","{handler:'valid_Paitipotrains',iparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]");
      setEventMetadata("VALID_PAITIPOTRAINS",",oparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]}");
      setEventMetadata("VALID_PAITIPOHSDIA","{handler:'valid_Paitipohsdia',iparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]");
      setEventMetadata("VALID_PAITIPOHSDIA",",oparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]}");
      setEventMetadata("VALID_PAITIPOHSSEM","{handler:'valid_Paitipohssem',iparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]");
      setEventMetadata("VALID_PAITIPOHSSEM",",oparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]}");
      setEventMetadata("VALID_PAITIPOHSMAXDIA","{handler:'valid_Paitipohsmaxdia',iparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]");
      setEventMetadata("VALID_PAITIPOHSMAXDIA",",oparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]}");
      setEventMetadata("VALID_PAITIPOHSMAXSEM","{handler:'valid_Paitipohsmaxsem',iparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]");
      setEventMetadata("VALID_PAITIPOHSMAXSEM",",oparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]}");
      setEventMetadata("VALID_PAITIPOHSMAXMES","{handler:'valid_Paitipohsmaxmes',iparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]");
      setEventMetadata("VALID_PAITIPOHSMAXMES",",oparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]}");
      setEventMetadata("VALID_PAITIPOHSMAXANU","{handler:'valid_Paitipohsmaxanu',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O1390PaiTipoHsMaxAnu'},{av:'O1385PaiTipoHsMaxMes'},{av:'O1384PaiTipoHsMaxSem'},{av:'O1383PaiTipoHsMaxDia'},{av:'O1347PaiTipoTarifaRec'},{av:'O1338PaiTipoTarifaXLim'},{av:'O1337PaiTipoHsSem'},{av:'O1336PaiTipoHsDia'},{av:'O1297PaiTipoTraIns'},{av:'A1336PaiTipoHsDia',fld:'PAITIPOHSDIA',pic:'9.9'},{av:'A1337PaiTipoHsSem',fld:'PAITIPOHSSEM',pic:'Z9.9'},{av:'A1338PaiTipoTarifaXLim',fld:'PAITIPOTARIFAXLIM',pic:'9.9999'},{av:'A1347PaiTipoTarifaRec',fld:'PAITIPOTARIFAREC',pic:'9.9999'},{av:'A1383PaiTipoHsMaxDia',fld:'PAITIPOHSMAXDIA',pic:'9.9'},{av:'A1384PaiTipoHsMaxSem',fld:'PAITIPOHSMAXSEM',pic:'Z9.9'},{av:'cmbPaiTipoHsMaxMes'},{av:'A1385PaiTipoHsMaxMes',fld:'PAITIPOHSMAXMES',pic:'ZZ9.9'},{av:'A1390PaiTipoHsMaxAnu',fld:'PAITIPOHSMAXANU',pic:'ZZ9.9'},{av:'AV24CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynPaiTipoTraRelSec'},{av:'A2055PaiTipoTraRelSec',fld:'PAITIPOTRARELSEC',pic:'ZZZZZ9'},{av:'A1976PaiTipoTraOldDefault',fld:'PAITIPOTRAOLDDEFAULT',pic:''},{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]");
      setEventMetadata("VALID_PAITIPOHSMAXANU",",oparms:[{av:'divPaitipotrarelsec_cell_Class',ctrl:'PAITIPOTRARELSEC_CELL',prop:'Class'},{av:'A1976PaiTipoTraOldDefault',fld:'PAITIPOTRAOLDDEFAULT',pic:''},{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]}");
      setEventMetadata("VALID_PAITIPOTRARELSEC","{handler:'valid_Paitipotrarelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O1390PaiTipoHsMaxAnu'},{av:'O1385PaiTipoHsMaxMes'},{av:'O1384PaiTipoHsMaxSem'},{av:'O1383PaiTipoHsMaxDia'},{av:'O1347PaiTipoTarifaRec'},{av:'O1338PaiTipoTarifaXLim'},{av:'O1337PaiTipoHsSem'},{av:'O1336PaiTipoHsDia'},{av:'O1297PaiTipoTraIns'},{av:'A1336PaiTipoHsDia',fld:'PAITIPOHSDIA',pic:'9.9'},{av:'A1337PaiTipoHsSem',fld:'PAITIPOHSSEM',pic:'Z9.9'},{av:'A1338PaiTipoTarifaXLim',fld:'PAITIPOTARIFAXLIM',pic:'9.9999'},{av:'A1347PaiTipoTarifaRec',fld:'PAITIPOTARIFAREC',pic:'9.9999'},{av:'A1383PaiTipoHsMaxDia',fld:'PAITIPOHSMAXDIA',pic:'9.9'},{av:'A1384PaiTipoHsMaxSem',fld:'PAITIPOHSMAXSEM',pic:'Z9.9'},{av:'cmbPaiTipoHsMaxMes'},{av:'A1385PaiTipoHsMaxMes',fld:'PAITIPOHSMAXMES',pic:'ZZ9.9'},{av:'A1390PaiTipoHsMaxAnu',fld:'PAITIPOHSMAXANU',pic:'ZZ9.9'},{av:'AV24CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynPaiTipoTraRelSec'},{av:'A2055PaiTipoTraRelSec',fld:'PAITIPOTRARELSEC',pic:'ZZZZZ9'},{av:'AV23aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]");
      setEventMetadata("VALID_PAITIPOTRARELSEC",",oparms:[{av:'AV23aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]}");
      setEventMetadata("VALIDV_COMBOPAICOD","{handler:'validv_Combopaicod',iparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]");
      setEventMetadata("VALIDV_COMBOPAICOD",",oparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]}");
      setEventMetadata("VALIDV_COMBOPAITIPOTRAID","{handler:'validv_Combopaitipotraid',iparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]");
      setEventMetadata("VALIDV_COMBOPAITIPOTRAID",",oparms:[{av:'A1297PaiTipoTraIns',fld:'PAITIPOTRAINS',pic:''}]}");
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
      pr_default.close(19);
      pr_default.close(20);
      pr_default.close(13);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV8PaiTipoTraId = "" ;
      Z1294PaiTipoTraId = "" ;
      Z1336PaiTipoHsDia = DecimalUtil.ZERO ;
      Z1337PaiTipoHsSem = DecimalUtil.ZERO ;
      Z1338PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      Z1347PaiTipoTarifaRec = DecimalUtil.ZERO ;
      Z1383PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      Z1384PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      Z1385PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      Z1390PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      Z2056PaiTipoTraRelRef = "" ;
      Z2435PaiTipoTraHorDes = "" ;
      O1390PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      O1385PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      O1384PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      O1383PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      O1347PaiTipoTarifaRec = DecimalUtil.ZERO ;
      O1338PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      O1337PaiTipoHsSem = DecimalUtil.ZERO ;
      O1336PaiTipoHsDia = DecimalUtil.ZERO ;
      Combo_paitipotraid_Selectedvalue_get = "" ;
      Combo_paicod_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A1337PaiTipoHsSem = DecimalUtil.ZERO ;
      A1338PaiTipoTarifaXLim = DecimalUtil.ZERO ;
      A1347PaiTipoTarifaRec = DecimalUtil.ZERO ;
      A1383PaiTipoHsMaxDia = DecimalUtil.ZERO ;
      A1384PaiTipoHsMaxSem = DecimalUtil.ZERO ;
      A1385PaiTipoHsMaxMes = DecimalUtil.ZERO ;
      A1390PaiTipoHsMaxAnu = DecimalUtil.ZERO ;
      A1336PaiTipoHsDia = DecimalUtil.ZERO ;
      A1294PaiTipoTraId = "" ;
      AV8PaiTipoTraId = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      AV21ComboPaiTipoTraId = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockpaicod_Jsonclick = "" ;
      ucCombo_paicod = new com.genexus.webpanels.GXUserControl();
      AV15DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV14PaiCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      lblTextblockpaitipotraid_Jsonclick = "" ;
      ucCombo_paitipotraid = new com.genexus.webpanels.GXUserControl();
      AV20PaiTipoTraId_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A2056PaiTipoTraRelRef = "" ;
      A2435PaiTipoTraHorDes = "" ;
      A1976PaiTipoTraOldDefault = "" ;
      A2070PaiTipoTraOld = "" ;
      A1295PaiTipoTraNom = "" ;
      AV25Pgmname = "" ;
      Combo_paicod_Objectcall = "" ;
      Combo_paicod_Class = "" ;
      Combo_paicod_Icontype = "" ;
      Combo_paicod_Icon = "" ;
      Combo_paicod_Tooltip = "" ;
      Combo_paicod_Selectedvalue_set = "" ;
      Combo_paicod_Selectedtext_set = "" ;
      Combo_paicod_Selectedtext_get = "" ;
      Combo_paicod_Gamoauthtoken = "" ;
      Combo_paicod_Ddointernalname = "" ;
      Combo_paicod_Titlecontrolalign = "" ;
      Combo_paicod_Dropdownoptionstype = "" ;
      Combo_paicod_Titlecontrolidtoreplace = "" ;
      Combo_paicod_Datalisttype = "" ;
      Combo_paicod_Datalistfixedvalues = "" ;
      Combo_paicod_Remoteservicesparameters = "" ;
      Combo_paicod_Htmltemplate = "" ;
      Combo_paicod_Multiplevaluestype = "" ;
      Combo_paicod_Loadingdata = "" ;
      Combo_paicod_Noresultsfound = "" ;
      Combo_paicod_Emptyitemtext = "" ;
      Combo_paicod_Onlyselectedvalues = "" ;
      Combo_paicod_Selectalltext = "" ;
      Combo_paicod_Multiplevaluesseparator = "" ;
      Combo_paicod_Addnewoptiontext = "" ;
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
      sMode155 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXv_int2 = new int[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      AV18Combo_DataJson = "" ;
      AV16ComboSelectedValue = "" ;
      AV17ComboSelectedText = "" ;
      GXv_char10 = new String[1] ;
      GXv_char9 = new String[1] ;
      Z1976PaiTipoTraOldDefault = "" ;
      Z2070PaiTipoTraOld = "" ;
      Z1292TipoTraId = "" ;
      A1292TipoTraId = "" ;
      T003R5_A1292TipoTraId = new String[] {""} ;
      T003R6_A1292TipoTraId = new String[] {""} ;
      T003R6_A1976PaiTipoTraOldDefault = new String[] {""} ;
      T003R6_A1297PaiTipoTraIns = new boolean[] {false} ;
      T003R6_A1336PaiTipoHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R6_A1337PaiTipoHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R6_A1338PaiTipoTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R6_A1347PaiTipoTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R6_A1383PaiTipoHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R6_A1384PaiTipoHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R6_A1385PaiTipoHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R6_A1390PaiTipoHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R6_A2055PaiTipoTraRelSec = new int[1] ;
      T003R6_A2056PaiTipoTraRelRef = new String[] {""} ;
      T003R6_A2070PaiTipoTraOld = new String[] {""} ;
      T003R6_A2435PaiTipoTraHorDes = new String[] {""} ;
      T003R6_A46PaiCod = new short[1] ;
      T003R6_A1294PaiTipoTraId = new String[] {""} ;
      T003R4_A46PaiCod = new short[1] ;
      T003R7_A46PaiCod = new short[1] ;
      T003R8_A1292TipoTraId = new String[] {""} ;
      T003R9_A46PaiCod = new short[1] ;
      T003R9_A1294PaiTipoTraId = new String[] {""} ;
      T003R3_A1976PaiTipoTraOldDefault = new String[] {""} ;
      T003R3_A1297PaiTipoTraIns = new boolean[] {false} ;
      T003R3_A1336PaiTipoHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R3_A1337PaiTipoHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R3_A1338PaiTipoTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R3_A1347PaiTipoTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R3_A1383PaiTipoHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R3_A1384PaiTipoHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R3_A1385PaiTipoHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R3_A1390PaiTipoHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R3_A2055PaiTipoTraRelSec = new int[1] ;
      T003R3_A2056PaiTipoTraRelRef = new String[] {""} ;
      T003R3_A2070PaiTipoTraOld = new String[] {""} ;
      T003R3_A2435PaiTipoTraHorDes = new String[] {""} ;
      T003R3_A46PaiCod = new short[1] ;
      T003R3_A1294PaiTipoTraId = new String[] {""} ;
      T003R10_A46PaiCod = new short[1] ;
      T003R10_A1294PaiTipoTraId = new String[] {""} ;
      T003R11_A46PaiCod = new short[1] ;
      T003R11_A1294PaiTipoTraId = new String[] {""} ;
      T003R2_A1976PaiTipoTraOldDefault = new String[] {""} ;
      T003R2_A1297PaiTipoTraIns = new boolean[] {false} ;
      T003R2_A1336PaiTipoHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R2_A1337PaiTipoHsSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R2_A1338PaiTipoTarifaXLim = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R2_A1347PaiTipoTarifaRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R2_A1383PaiTipoHsMaxDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R2_A1384PaiTipoHsMaxSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R2_A1385PaiTipoHsMaxMes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R2_A1390PaiTipoHsMaxAnu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003R2_A2055PaiTipoTraRelSec = new int[1] ;
      T003R2_A2056PaiTipoTraRelRef = new String[] {""} ;
      T003R2_A2070PaiTipoTraOld = new String[] {""} ;
      T003R2_A2435PaiTipoTraHorDes = new String[] {""} ;
      T003R2_A46PaiCod = new short[1] ;
      T003R2_A1294PaiTipoTraId = new String[] {""} ;
      T003R15_A1292TipoTraId = new String[] {""} ;
      T003R16_A3CliCod = new int[1] ;
      T003R16_A1564CliPaiConve = new short[1] ;
      T003R16_A1565CliConvenio = new String[] {""} ;
      T003R16_A1294PaiTipoTraId = new String[] {""} ;
      T003R17_A3CliCod = new int[1] ;
      T003R17_A1564CliPaiConve = new short[1] ;
      T003R17_A1565CliConvenio = new String[] {""} ;
      T003R17_A1294PaiTipoTraId = new String[] {""} ;
      T003R18_A46PaiCod = new short[1] ;
      T003R18_A1332PaiHsExSec = new short[1] ;
      T003R19_A46PaiCod = new short[1] ;
      T003R19_A1294PaiTipoTraId = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T003R20_A1885CliRelSec = new int[1] ;
      T003R20_A1880CliReDTChar = new String[] {""} ;
      T003R20_A3CliCod = new int[1] ;
      T003R21_A46PaiCod = new short[1] ;
      T003R22_A1292TipoTraId = new String[] {""} ;
      Z1295PaiTipoTraNom = "" ;
      GXt_char8 = "" ;
      GXv_char11 = new String[1] ;
      GXv_boolean7 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paistipotrabajo__default(),
         new Object[] {
             new Object[] {
            T003R2_A1976PaiTipoTraOldDefault, T003R2_A1297PaiTipoTraIns, T003R2_A1336PaiTipoHsDia, T003R2_A1337PaiTipoHsSem, T003R2_A1338PaiTipoTarifaXLim, T003R2_A1347PaiTipoTarifaRec, T003R2_A1383PaiTipoHsMaxDia, T003R2_A1384PaiTipoHsMaxSem, T003R2_A1385PaiTipoHsMaxMes, T003R2_A1390PaiTipoHsMaxAnu,
            T003R2_A2055PaiTipoTraRelSec, T003R2_A2056PaiTipoTraRelRef, T003R2_A2070PaiTipoTraOld, T003R2_A2435PaiTipoTraHorDes, T003R2_A46PaiCod, T003R2_A1294PaiTipoTraId
            }
            , new Object[] {
            T003R3_A1976PaiTipoTraOldDefault, T003R3_A1297PaiTipoTraIns, T003R3_A1336PaiTipoHsDia, T003R3_A1337PaiTipoHsSem, T003R3_A1338PaiTipoTarifaXLim, T003R3_A1347PaiTipoTarifaRec, T003R3_A1383PaiTipoHsMaxDia, T003R3_A1384PaiTipoHsMaxSem, T003R3_A1385PaiTipoHsMaxMes, T003R3_A1390PaiTipoHsMaxAnu,
            T003R3_A2055PaiTipoTraRelSec, T003R3_A2056PaiTipoTraRelRef, T003R3_A2070PaiTipoTraOld, T003R3_A2435PaiTipoTraHorDes, T003R3_A46PaiCod, T003R3_A1294PaiTipoTraId
            }
            , new Object[] {
            T003R4_A46PaiCod
            }
            , new Object[] {
            T003R5_A1292TipoTraId
            }
            , new Object[] {
            T003R6_A1292TipoTraId, T003R6_A1976PaiTipoTraOldDefault, T003R6_A1297PaiTipoTraIns, T003R6_A1336PaiTipoHsDia, T003R6_A1337PaiTipoHsSem, T003R6_A1338PaiTipoTarifaXLim, T003R6_A1347PaiTipoTarifaRec, T003R6_A1383PaiTipoHsMaxDia, T003R6_A1384PaiTipoHsMaxSem, T003R6_A1385PaiTipoHsMaxMes,
            T003R6_A1390PaiTipoHsMaxAnu, T003R6_A2055PaiTipoTraRelSec, T003R6_A2056PaiTipoTraRelRef, T003R6_A2070PaiTipoTraOld, T003R6_A2435PaiTipoTraHorDes, T003R6_A46PaiCod, T003R6_A1294PaiTipoTraId
            }
            , new Object[] {
            T003R7_A46PaiCod
            }
            , new Object[] {
            T003R8_A1292TipoTraId
            }
            , new Object[] {
            T003R9_A46PaiCod, T003R9_A1294PaiTipoTraId
            }
            , new Object[] {
            T003R10_A46PaiCod, T003R10_A1294PaiTipoTraId
            }
            , new Object[] {
            T003R11_A46PaiCod, T003R11_A1294PaiTipoTraId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T003R15_A1292TipoTraId
            }
            , new Object[] {
            T003R16_A3CliCod, T003R16_A1564CliPaiConve, T003R16_A1565CliConvenio, T003R16_A1294PaiTipoTraId
            }
            , new Object[] {
            T003R17_A3CliCod, T003R17_A1564CliPaiConve, T003R17_A1565CliConvenio, T003R17_A1294PaiTipoTraId
            }
            , new Object[] {
            T003R18_A46PaiCod, T003R18_A1332PaiHsExSec
            }
            , new Object[] {
            T003R19_A46PaiCod, T003R19_A1294PaiTipoTraId
            }
            , new Object[] {
            T003R20_A1885CliRelSec, T003R20_A1880CliReDTChar, T003R20_A3CliCod
            }
            , new Object[] {
            T003R21_A46PaiCod
            }
            , new Object[] {
            T003R22_A1292TipoTraId
            }
         }
      );
      AV25Pgmname = "PaisTipoTrabajo" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7PaiCod ;
   private short Z46PaiCod ;
   private short A46PaiCod ;
   private short AV7PaiCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short AV19ComboPaiCod ;
   private short RcdFound155 ;
   private short nIsDirty_155 ;
   private int Z2055PaiTipoTraRelSec ;
   private int AV24CliCod ;
   private int A2055PaiTipoTraRelSec ;
   private int trnEnded ;
   private int edtPaiCod_Visible ;
   private int edtPaiCod_Enabled ;
   private int edtPaiTipoHsDia_Enabled ;
   private int edtPaiTipoHsSem_Enabled ;
   private int edtPaiTipoHsMaxDia_Enabled ;
   private int edtPaiTipoHsMaxSem_Enabled ;
   private int edtPaiTipoHsMaxAnu_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombopaicod_Enabled ;
   private int edtavCombopaicod_Visible ;
   private int Combo_paicod_Datalistupdateminimumcharacters ;
   private int Combo_paicod_Gxcontroltype ;
   private int Combo_paitipotraid_Datalistupdateminimumcharacters ;
   private int Combo_paitipotraid_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private java.math.BigDecimal Z1336PaiTipoHsDia ;
   private java.math.BigDecimal Z1337PaiTipoHsSem ;
   private java.math.BigDecimal Z1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal Z1347PaiTipoTarifaRec ;
   private java.math.BigDecimal Z1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal Z1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal Z1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal Z1390PaiTipoHsMaxAnu ;
   private java.math.BigDecimal O1390PaiTipoHsMaxAnu ;
   private java.math.BigDecimal O1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal O1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal O1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal O1347PaiTipoTarifaRec ;
   private java.math.BigDecimal O1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal O1337PaiTipoHsSem ;
   private java.math.BigDecimal O1336PaiTipoHsDia ;
   private java.math.BigDecimal A1337PaiTipoHsSem ;
   private java.math.BigDecimal A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal A1390PaiTipoHsMaxAnu ;
   private java.math.BigDecimal A1336PaiTipoHsDia ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8PaiTipoTraId ;
   private String Z1294PaiTipoTraId ;
   private String Z2435PaiTipoTraHorDes ;
   private String Combo_paitipotraid_Selectedvalue_get ;
   private String Combo_paicod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String A1294PaiTipoTraId ;
   private String AV8PaiTipoTraId ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtPaiCod_Internalname ;
   private String AV21ComboPaiTipoTraId ;
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
   private String divTablesplittedpaicod_Internalname ;
   private String lblTextblockpaicod_Internalname ;
   private String lblTextblockpaicod_Jsonclick ;
   private String Combo_paicod_Caption ;
   private String Combo_paicod_Cls ;
   private String Combo_paicod_Datalistproc ;
   private String Combo_paicod_Datalistprocparametersprefix ;
   private String Combo_paicod_Internalname ;
   private String TempTags ;
   private String edtPaiCod_Jsonclick ;
   private String divTablesplittedpaitipotraid_Internalname ;
   private String lblTextblockpaitipotraid_Internalname ;
   private String lblTextblockpaitipotraid_Jsonclick ;
   private String Combo_paitipotraid_Caption ;
   private String Combo_paitipotraid_Cls ;
   private String Combo_paitipotraid_Datalistproc ;
   private String Combo_paitipotraid_Datalistprocparametersprefix ;
   private String Combo_paitipotraid_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtPaiTipoHsDia_Internalname ;
   private String edtPaiTipoHsDia_Jsonclick ;
   private String edtPaiTipoHsSem_Internalname ;
   private String edtPaiTipoHsSem_Jsonclick ;
   private String edtPaiTipoHsMaxDia_Internalname ;
   private String edtPaiTipoHsMaxDia_Jsonclick ;
   private String edtPaiTipoHsMaxSem_Internalname ;
   private String edtPaiTipoHsMaxSem_Jsonclick ;
   private String edtPaiTipoHsMaxAnu_Internalname ;
   private String edtPaiTipoHsMaxAnu_Jsonclick ;
   private String divPaitipotrarelsec_cell_Internalname ;
   private String divPaitipotrarelsec_cell_Class ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_paicod_Internalname ;
   private String edtavCombopaicod_Internalname ;
   private String edtavCombopaicod_Jsonclick ;
   private String divSectionattribute_paitipotraid_Internalname ;
   private String A2435PaiTipoTraHorDes ;
   private String AV25Pgmname ;
   private String Combo_paicod_Objectcall ;
   private String Combo_paicod_Class ;
   private String Combo_paicod_Icontype ;
   private String Combo_paicod_Icon ;
   private String Combo_paicod_Tooltip ;
   private String Combo_paicod_Selectedvalue_set ;
   private String Combo_paicod_Selectedtext_set ;
   private String Combo_paicod_Selectedtext_get ;
   private String Combo_paicod_Gamoauthtoken ;
   private String Combo_paicod_Ddointernalname ;
   private String Combo_paicod_Titlecontrolalign ;
   private String Combo_paicod_Dropdownoptionstype ;
   private String Combo_paicod_Titlecontrolidtoreplace ;
   private String Combo_paicod_Datalisttype ;
   private String Combo_paicod_Datalistfixedvalues ;
   private String Combo_paicod_Remoteservicesparameters ;
   private String Combo_paicod_Htmltemplate ;
   private String Combo_paicod_Multiplevaluestype ;
   private String Combo_paicod_Loadingdata ;
   private String Combo_paicod_Noresultsfound ;
   private String Combo_paicod_Emptyitemtext ;
   private String Combo_paicod_Onlyselectedvalues ;
   private String Combo_paicod_Selectalltext ;
   private String Combo_paicod_Multiplevaluesseparator ;
   private String Combo_paicod_Addnewoptiontext ;
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
   private String sMode155 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXv_char10[] ;
   private String GXv_char9[] ;
   private String Z1292TipoTraId ;
   private String A1292TipoTraId ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private String GXt_char8 ;
   private String GXv_char11[] ;
   private boolean Z1297PaiTipoTraIns ;
   private boolean O1297PaiTipoTraIns ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A1297PaiTipoTraIns ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_paicod_Emptyitem ;
   private boolean Combo_paitipotraid_Emptyitem ;
   private boolean AV23aplicadoHay ;
   private boolean Combo_paicod_Enabled ;
   private boolean Combo_paicod_Visible ;
   private boolean Combo_paicod_Allowmultipleselection ;
   private boolean Combo_paicod_Isgriditem ;
   private boolean Combo_paicod_Hasdescription ;
   private boolean Combo_paicod_Includeonlyselectedoption ;
   private boolean Combo_paicod_Includeselectalloption ;
   private boolean Combo_paicod_Includeaddnewoption ;
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
   private boolean AV10IsAuthorized ;
   private boolean GXt_boolean6 ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXv_boolean7[] ;
   private boolean ZV23aplicadoHay ;
   private String A1976PaiTipoTraOldDefault ;
   private String A2070PaiTipoTraOld ;
   private String AV18Combo_DataJson ;
   private String Z1976PaiTipoTraOldDefault ;
   private String Z2070PaiTipoTraOld ;
   private String Z2056PaiTipoTraRelRef ;
   private String A2056PaiTipoTraRelRef ;
   private String A1295PaiTipoTraNom ;
   private String AV16ComboSelectedValue ;
   private String AV17ComboSelectedText ;
   private String Z1295PaiTipoTraNom ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_paicod ;
   private com.genexus.webpanels.GXUserControl ucCombo_paitipotraid ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbPaiTipoTraId ;
   private ICheckbox chkPaiTipoTraIns ;
   private HTMLChoice cmbPaiTipoHsMaxMes ;
   private HTMLChoice dynPaiTipoTraRelSec ;
   private HTMLChoice cmbavCombopaitipotraid ;
   private IDataStoreProvider pr_default ;
   private String[] T003R5_A1292TipoTraId ;
   private String[] T003R6_A1292TipoTraId ;
   private String[] T003R6_A1976PaiTipoTraOldDefault ;
   private boolean[] T003R6_A1297PaiTipoTraIns ;
   private java.math.BigDecimal[] T003R6_A1336PaiTipoHsDia ;
   private java.math.BigDecimal[] T003R6_A1337PaiTipoHsSem ;
   private java.math.BigDecimal[] T003R6_A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal[] T003R6_A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal[] T003R6_A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal[] T003R6_A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal[] T003R6_A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal[] T003R6_A1390PaiTipoHsMaxAnu ;
   private int[] T003R6_A2055PaiTipoTraRelSec ;
   private String[] T003R6_A2056PaiTipoTraRelRef ;
   private String[] T003R6_A2070PaiTipoTraOld ;
   private String[] T003R6_A2435PaiTipoTraHorDes ;
   private short[] T003R6_A46PaiCod ;
   private String[] T003R6_A1294PaiTipoTraId ;
   private short[] T003R4_A46PaiCod ;
   private short[] T003R7_A46PaiCod ;
   private String[] T003R8_A1292TipoTraId ;
   private short[] T003R9_A46PaiCod ;
   private String[] T003R9_A1294PaiTipoTraId ;
   private String[] T003R3_A1976PaiTipoTraOldDefault ;
   private boolean[] T003R3_A1297PaiTipoTraIns ;
   private java.math.BigDecimal[] T003R3_A1336PaiTipoHsDia ;
   private java.math.BigDecimal[] T003R3_A1337PaiTipoHsSem ;
   private java.math.BigDecimal[] T003R3_A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal[] T003R3_A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal[] T003R3_A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal[] T003R3_A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal[] T003R3_A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal[] T003R3_A1390PaiTipoHsMaxAnu ;
   private int[] T003R3_A2055PaiTipoTraRelSec ;
   private String[] T003R3_A2056PaiTipoTraRelRef ;
   private String[] T003R3_A2070PaiTipoTraOld ;
   private String[] T003R3_A2435PaiTipoTraHorDes ;
   private short[] T003R3_A46PaiCod ;
   private String[] T003R3_A1294PaiTipoTraId ;
   private short[] T003R10_A46PaiCod ;
   private String[] T003R10_A1294PaiTipoTraId ;
   private short[] T003R11_A46PaiCod ;
   private String[] T003R11_A1294PaiTipoTraId ;
   private String[] T003R2_A1976PaiTipoTraOldDefault ;
   private boolean[] T003R2_A1297PaiTipoTraIns ;
   private java.math.BigDecimal[] T003R2_A1336PaiTipoHsDia ;
   private java.math.BigDecimal[] T003R2_A1337PaiTipoHsSem ;
   private java.math.BigDecimal[] T003R2_A1338PaiTipoTarifaXLim ;
   private java.math.BigDecimal[] T003R2_A1347PaiTipoTarifaRec ;
   private java.math.BigDecimal[] T003R2_A1383PaiTipoHsMaxDia ;
   private java.math.BigDecimal[] T003R2_A1384PaiTipoHsMaxSem ;
   private java.math.BigDecimal[] T003R2_A1385PaiTipoHsMaxMes ;
   private java.math.BigDecimal[] T003R2_A1390PaiTipoHsMaxAnu ;
   private int[] T003R2_A2055PaiTipoTraRelSec ;
   private String[] T003R2_A2056PaiTipoTraRelRef ;
   private String[] T003R2_A2070PaiTipoTraOld ;
   private String[] T003R2_A2435PaiTipoTraHorDes ;
   private short[] T003R2_A46PaiCod ;
   private String[] T003R2_A1294PaiTipoTraId ;
   private String[] T003R15_A1292TipoTraId ;
   private int[] T003R16_A3CliCod ;
   private short[] T003R16_A1564CliPaiConve ;
   private String[] T003R16_A1565CliConvenio ;
   private String[] T003R16_A1294PaiTipoTraId ;
   private int[] T003R17_A3CliCod ;
   private short[] T003R17_A1564CliPaiConve ;
   private String[] T003R17_A1565CliConvenio ;
   private String[] T003R17_A1294PaiTipoTraId ;
   private short[] T003R18_A46PaiCod ;
   private short[] T003R18_A1332PaiHsExSec ;
   private short[] T003R19_A46PaiCod ;
   private String[] T003R19_A1294PaiTipoTraId ;
   private int[] T003R20_A1885CliRelSec ;
   private String[] T003R20_A1880CliReDTChar ;
   private int[] T003R20_A3CliCod ;
   private short[] T003R21_A46PaiCod ;
   private String[] T003R22_A1292TipoTraId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14PaiCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV20PaiTipoTraId_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV15DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[] ;
}

final  class paistipotrabajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T003R2", "SELECT PaiTipoTraOldDefault, PaiTipoTraIns, PaiTipoHsDia, PaiTipoHsSem, PaiTipoTarifaXLim, PaiTipoTarifaRec, PaiTipoHsMaxDia, PaiTipoHsMaxSem, PaiTipoHsMaxMes, PaiTipoHsMaxAnu, PaiTipoTraRelSec, PaiTipoTraRelRef, PaiTipoTraOld, PaiTipoTraHorDes, PaiCod, PaiTipoTraId FROM PaisTipoTrabajo WHERE PaiCod = ? AND PaiTipoTraId = ?  FOR UPDATE OF PaisTipoTrabajo NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003R3", "SELECT PaiTipoTraOldDefault, PaiTipoTraIns, PaiTipoHsDia, PaiTipoHsSem, PaiTipoTarifaXLim, PaiTipoTarifaRec, PaiTipoHsMaxDia, PaiTipoHsMaxSem, PaiTipoHsMaxMes, PaiTipoHsMaxAnu, PaiTipoTraRelSec, PaiTipoTraRelRef, PaiTipoTraOld, PaiTipoTraHorDes, PaiCod, PaiTipoTraId FROM PaisTipoTrabajo WHERE PaiCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003R4", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003R5", "SELECT TipoTraId FROM TipoTrabajo WHERE TipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003R6", "SELECT T2.TipoTraId, TM1.PaiTipoTraOldDefault, TM1.PaiTipoTraIns, TM1.PaiTipoHsDia, TM1.PaiTipoHsSem, TM1.PaiTipoTarifaXLim, TM1.PaiTipoTarifaRec, TM1.PaiTipoHsMaxDia, TM1.PaiTipoHsMaxSem, TM1.PaiTipoHsMaxMes, TM1.PaiTipoHsMaxAnu, TM1.PaiTipoTraRelSec, TM1.PaiTipoTraRelRef, TM1.PaiTipoTraOld, TM1.PaiTipoTraHorDes, TM1.PaiCod, TM1.PaiTipoTraId FROM (PaisTipoTrabajo TM1 INNER JOIN TipoTrabajo T2 ON T2.TipoTraId = TM1.PaiTipoTraId) WHERE TM1.PaiCod = ? and TM1.PaiTipoTraId = ( ?) ORDER BY TM1.PaiCod, TM1.PaiTipoTraId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003R7", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003R8", "SELECT TipoTraId FROM TipoTrabajo WHERE TipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003R9", "SELECT PaiCod, PaiTipoTraId FROM PaisTipoTrabajo WHERE PaiCod = ? AND PaiTipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003R10", "SELECT PaiCod, PaiTipoTraId FROM PaisTipoTrabajo WHERE ( PaiCod > ? or PaiCod = ? and PaiTipoTraId > ( ?)) ORDER BY PaiCod, PaiTipoTraId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003R11", "SELECT PaiCod, PaiTipoTraId FROM PaisTipoTrabajo WHERE ( PaiCod < ? or PaiCod = ? and PaiTipoTraId < ( ?)) ORDER BY PaiCod DESC, PaiTipoTraId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T003R12", "SAVEPOINT gxupdate;INSERT INTO PaisTipoTrabajo(PaiTipoTraOldDefault, PaiTipoTraIns, PaiTipoHsDia, PaiTipoHsSem, PaiTipoTarifaXLim, PaiTipoTarifaRec, PaiTipoHsMaxDia, PaiTipoHsMaxSem, PaiTipoHsMaxMes, PaiTipoHsMaxAnu, PaiTipoTraRelSec, PaiTipoTraRelRef, PaiTipoTraOld, PaiTipoTraHorDes, PaiCod, PaiTipoTraId, PaiTipoTraHor) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003R13", "SAVEPOINT gxupdate;UPDATE PaisTipoTrabajo SET PaiTipoTraOldDefault=?, PaiTipoTraIns=?, PaiTipoHsDia=?, PaiTipoHsSem=?, PaiTipoTarifaXLim=?, PaiTipoTarifaRec=?, PaiTipoHsMaxDia=?, PaiTipoHsMaxSem=?, PaiTipoHsMaxMes=?, PaiTipoHsMaxAnu=?, PaiTipoTraRelSec=?, PaiTipoTraRelRef=?, PaiTipoTraOld=?, PaiTipoTraHorDes=?  WHERE PaiCod = ? AND PaiTipoTraId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003R14", "SAVEPOINT gxupdate;DELETE FROM PaisTipoTrabajo  WHERE PaiCod = ? AND PaiTipoTraId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003R15", "SELECT TipoTraId FROM TipoTrabajo WHERE TipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003R16", "SELECT CliCod, CliPaiConve, CliConvenio, PaiTipoTraId FROM convenio_tiposdetrabajo WHERE CliPaiConve = ? AND PaiTipoTraId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003R17", "SELECT CliCod, CliPaiConve, CliConvenio, PaiTipoTraId FROM convenio_tiposdetrabajo WHERE CliPaiConve = ? AND PaiTipoTraId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003R18", "SELECT PaiCod, PaiHsExSec FROM Paishorasextras_pordia WHERE PaiCod = ? AND PaiHsPDiaTipTra = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003R19", "SELECT PaiCod, PaiTipoTraId FROM PaisTipoTrabajo ORDER BY PaiCod, PaiTipoTraId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003R20", "SELECT CliRelSec, CliReDTChar, CliCod FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003R21", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003R22", "SELECT TipoTraId FROM TipoTrabajo WHERE TipoTraId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 5);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               ((String[]) buf[15])[0] = rslt.getString(16, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,1);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 5);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               ((String[]) buf[15])[0] = rslt.getString(16, 20);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,1);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,1);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 5);
               ((short[]) buf[15])[0] = rslt.getShort(16);
               ((String[]) buf[16])[0] = rslt.getString(17, 20);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 20 :
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 10 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 1);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 1);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 4);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 1);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 1);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 1);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 1);
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setVarchar(12, (String)parms[11], 40, false);
               stmt.setNLongVarchar(13, (String)parms[12], false);
               stmt.setString(14, (String)parms[13], 5);
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               stmt.setString(16, (String)parms[15], 20);
               return;
            case 11 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 1);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 1);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 4);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 1);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 1);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 1);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 1);
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setVarchar(12, (String)parms[11], 40, false);
               stmt.setNLongVarchar(13, (String)parms[12], false);
               stmt.setString(14, (String)parms[13], 5);
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               stmt.setString(16, (String)parms[15], 20);
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 13 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 20 :
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

