package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class art_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_9") == 0 )
      {
         A1149ARTPaiCod = (short)(GXutil.lval( httpContext.GetPar( "ARTPaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1149ARTPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1149ARTPaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_9( A1149ARTPaiCod) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_importesfijos") == 0 )
      {
         gxnrgridlevel_importesfijos_newrow_invoke( ) ;
         return  ;
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
            AV7ARTSec = (short)(GXutil.lval( httpContext.GetPar( "ARTSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7ARTSec), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vARTSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ARTSec), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "ART", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtARTPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel_importesfijos_newrow_invoke( )
   {
      nRC_GXsfl_52 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_52"))) ;
      nGXsfl_52_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_52_idx"))) ;
      sGXsfl_52_idx = httpContext.GetPar( "sGXsfl_52_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_importesfijos_newrow( ) ;
      /* End function gxnrGridlevel_importesfijos_newrow_invoke */
   }

   public art_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public art_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( art_impl.class ));
   }

   public art_impl( int remoteHandle ,
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtARTSec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtARTSec_Internalname, httpContext.getMessage( "ART", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtARTSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1151ARTSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtARTSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1151ARTSec), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1151ARTSec), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtARTSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtARTSec_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ART.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedartpaicod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockartpaicod_Internalname, httpContext.getMessage( "Pais", ""), "", "", lblTextblockartpaicod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ART.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_artpaicod.setProperty("Caption", Combo_artpaicod_Caption);
      ucCombo_artpaicod.setProperty("Cls", Combo_artpaicod_Cls);
      ucCombo_artpaicod.setProperty("DataListProc", Combo_artpaicod_Datalistproc);
      ucCombo_artpaicod.setProperty("DataListProcParametersPrefix", Combo_artpaicod_Datalistprocparametersprefix);
      ucCombo_artpaicod.setProperty("EmptyItem", Combo_artpaicod_Emptyitem);
      ucCombo_artpaicod.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_artpaicod.setProperty("DropDownOptionsData", AV15ARTPaiCod_Data);
      ucCombo_artpaicod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_artpaicod_Internalname, "COMBO_ARTPAICODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtARTPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1149ARTPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1149ARTPaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtARTPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtARTPaiCod_Visible, edtARTPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_ART.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtARTNom_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtARTNom_Internalname, httpContext.getMessage( "Nombre", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtARTNom_Internalname, A1152ARTNom, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", (short)(0), 1, edtARTNom_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_ART.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtARTAli_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtARTAli_Internalname, httpContext.getMessage( "Alìcuota", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtARTAli_Internalname, GXutil.ltrim( localUtil.ntoc( A1153ARTAli, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtARTAli_Enabled!=0) ? localUtil.format( A1153ARTAli, "9.9999") : localUtil.format( A1153ARTAli, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtARTAli_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtARTAli_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_ART.htm");
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
      httpContext.writeText( "<td class='CellMarginTop'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_importesfijos_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol52( ) ;
      nGXsfl_52_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount131 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_131 = (short)(1) ;
            scanStart3A131( ) ;
            while ( RcdFound131 != 0 )
            {
               init_level_properties131( ) ;
               getByPrimaryKey3A131( ) ;
               addRow3A131( ) ;
               scanNext3A131( ) ;
            }
            scanEnd3A131( ) ;
            nBlankRcdCount131 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal3A131( ) ;
         standaloneModal3A131( ) ;
         sMode131 = Gx_mode ;
         while ( nGXsfl_52_idx < nRC_GXsfl_52 )
         {
            bGXsfl_52_Refreshing = true ;
            readRow3A131( ) ;
            edtARTImpFijSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTIMPFIJSEC_"+sGXsfl_52_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtARTImpFijSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTImpFijSec_Enabled), 5, 0), !bGXsfl_52_Refreshing);
            edtARTImpFijFecha_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTIMPFIJFECHA_"+sGXsfl_52_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtARTImpFijFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTImpFijFecha_Enabled), 5, 0), !bGXsfl_52_Refreshing);
            edtARTFijo_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTFIJO_"+sGXsfl_52_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtARTFijo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTFijo_Enabled), 5, 0), !bGXsfl_52_Refreshing);
            if ( ( nRcdExists_131 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal3A131( ) ;
            }
            sendRow3A131( ) ;
            bGXsfl_52_Refreshing = false ;
         }
         Gx_mode = sMode131 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount131 = (short)(5) ;
         nRcdExists_131 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart3A131( ) ;
            while ( RcdFound131 != 0 )
            {
               sGXsfl_52_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_52_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_52131( ) ;
               init_level_properties131( ) ;
               standaloneNotModal3A131( ) ;
               getByPrimaryKey3A131( ) ;
               standaloneModal3A131( ) ;
               addRow3A131( ) ;
               scanNext3A131( ) ;
            }
            scanEnd3A131( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode131 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_52_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_52_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_52131( ) ;
         initAll3A131( ) ;
         init_level_properties131( ) ;
         nRcdExists_131 = (short)(0) ;
         nIsMod_131 = (short)(0) ;
         nRcdDeleted_131 = (short)(0) ;
         nBlankRcdCount131 = (short)(nBlankRcdUsr131+nBlankRcdCount131) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount131 > 0 )
         {
            standaloneNotModal3A131( ) ;
            standaloneModal3A131( ) ;
            addRow3A131( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtARTImpFijSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount131 = (short)(nBlankRcdCount131-1) ;
         }
         Gx_mode = sMode131 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_importesfijosContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_importesfijos", Gridlevel_importesfijosContainer, subGridlevel_importesfijos_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_importesfijosContainerData", Gridlevel_importesfijosContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_importesfijosContainerData"+"V", Gridlevel_importesfijosContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_importesfijosContainerData"+"V"+"\" value='"+Gridlevel_importesfijosContainer.GridValuesHidden()+"'/>") ;
      }
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ART.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ART.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ART.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_artpaicod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboartpaicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV20ComboARTPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavComboartpaicod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV20ComboARTPaiCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV20ComboARTPaiCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboartpaicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboartpaicod_Visible, edtavComboartpaicod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ART.htm");
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
      e113A2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV16DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vARTPAICOD_DATA"), AV15ARTPaiCod_Data);
            /* Read saved values. */
            Z1151ARTSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z1151ARTSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1152ARTNom = httpContext.cgiGet( "Z1152ARTNom") ;
            Z1153ARTAli = localUtil.ctond( httpContext.cgiGet( "Z1153ARTAli")) ;
            Z1149ARTPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1149ARTPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_52 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_52"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            N1149ARTPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "N1149ARTPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7ARTSec = (short)(localUtil.ctol( httpContext.cgiGet( "vARTSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV13Insert_ARTPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_ARTPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1150ARTPaiNom = httpContext.cgiGet( "ARTPAINOM") ;
            AV22Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_artpaicod_Objectcall = httpContext.cgiGet( "COMBO_ARTPAICOD_Objectcall") ;
            Combo_artpaicod_Class = httpContext.cgiGet( "COMBO_ARTPAICOD_Class") ;
            Combo_artpaicod_Icontype = httpContext.cgiGet( "COMBO_ARTPAICOD_Icontype") ;
            Combo_artpaicod_Icon = httpContext.cgiGet( "COMBO_ARTPAICOD_Icon") ;
            Combo_artpaicod_Caption = httpContext.cgiGet( "COMBO_ARTPAICOD_Caption") ;
            Combo_artpaicod_Tooltip = httpContext.cgiGet( "COMBO_ARTPAICOD_Tooltip") ;
            Combo_artpaicod_Cls = httpContext.cgiGet( "COMBO_ARTPAICOD_Cls") ;
            Combo_artpaicod_Selectedvalue_set = httpContext.cgiGet( "COMBO_ARTPAICOD_Selectedvalue_set") ;
            Combo_artpaicod_Selectedvalue_get = httpContext.cgiGet( "COMBO_ARTPAICOD_Selectedvalue_get") ;
            Combo_artpaicod_Selectedtext_set = httpContext.cgiGet( "COMBO_ARTPAICOD_Selectedtext_set") ;
            Combo_artpaicod_Selectedtext_get = httpContext.cgiGet( "COMBO_ARTPAICOD_Selectedtext_get") ;
            Combo_artpaicod_Gamoauthtoken = httpContext.cgiGet( "COMBO_ARTPAICOD_Gamoauthtoken") ;
            Combo_artpaicod_Ddointernalname = httpContext.cgiGet( "COMBO_ARTPAICOD_Ddointernalname") ;
            Combo_artpaicod_Titlecontrolalign = httpContext.cgiGet( "COMBO_ARTPAICOD_Titlecontrolalign") ;
            Combo_artpaicod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_ARTPAICOD_Dropdownoptionstype") ;
            Combo_artpaicod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_ARTPAICOD_Enabled")) ;
            Combo_artpaicod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_ARTPAICOD_Visible")) ;
            Combo_artpaicod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_ARTPAICOD_Titlecontrolidtoreplace") ;
            Combo_artpaicod_Datalisttype = httpContext.cgiGet( "COMBO_ARTPAICOD_Datalisttype") ;
            Combo_artpaicod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_ARTPAICOD_Allowmultipleselection")) ;
            Combo_artpaicod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_ARTPAICOD_Datalistfixedvalues") ;
            Combo_artpaicod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_ARTPAICOD_Isgriditem")) ;
            Combo_artpaicod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_ARTPAICOD_Hasdescription")) ;
            Combo_artpaicod_Datalistproc = httpContext.cgiGet( "COMBO_ARTPAICOD_Datalistproc") ;
            Combo_artpaicod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_ARTPAICOD_Datalistprocparametersprefix") ;
            Combo_artpaicod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_ARTPAICOD_Remoteservicesparameters") ;
            Combo_artpaicod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_ARTPAICOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_artpaicod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ARTPAICOD_Includeonlyselectedoption")) ;
            Combo_artpaicod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ARTPAICOD_Includeselectalloption")) ;
            Combo_artpaicod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_ARTPAICOD_Emptyitem")) ;
            Combo_artpaicod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ARTPAICOD_Includeaddnewoption")) ;
            Combo_artpaicod_Htmltemplate = httpContext.cgiGet( "COMBO_ARTPAICOD_Htmltemplate") ;
            Combo_artpaicod_Multiplevaluestype = httpContext.cgiGet( "COMBO_ARTPAICOD_Multiplevaluestype") ;
            Combo_artpaicod_Loadingdata = httpContext.cgiGet( "COMBO_ARTPAICOD_Loadingdata") ;
            Combo_artpaicod_Noresultsfound = httpContext.cgiGet( "COMBO_ARTPAICOD_Noresultsfound") ;
            Combo_artpaicod_Emptyitemtext = httpContext.cgiGet( "COMBO_ARTPAICOD_Emptyitemtext") ;
            Combo_artpaicod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_ARTPAICOD_Onlyselectedvalues") ;
            Combo_artpaicod_Selectalltext = httpContext.cgiGet( "COMBO_ARTPAICOD_Selectalltext") ;
            Combo_artpaicod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_ARTPAICOD_Multiplevaluesseparator") ;
            Combo_artpaicod_Addnewoptiontext = httpContext.cgiGet( "COMBO_ARTPAICOD_Addnewoptiontext") ;
            Combo_artpaicod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_ARTPAICOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            A1151ARTSec = (short)(localUtil.ctol( httpContext.cgiGet( edtARTSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtARTPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtARTPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "ARTPAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtARTPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1149ARTPaiCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1149ARTPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1149ARTPaiCod), 4, 0));
            }
            else
            {
               A1149ARTPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtARTPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1149ARTPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1149ARTPaiCod), 4, 0));
            }
            A1152ARTNom = httpContext.cgiGet( edtARTNom_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1152ARTNom", A1152ARTNom);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtARTAli_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtARTAli_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "ARTALI");
               AnyError = (short)(1) ;
               GX_FocusControl = edtARTAli_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1153ARTAli = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1153ARTAli", GXutil.ltrimstr( A1153ARTAli, 6, 4));
            }
            else
            {
               A1153ARTAli = localUtil.ctond( httpContext.cgiGet( edtARTAli_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1153ARTAli", GXutil.ltrimstr( A1153ARTAli, 6, 4));
            }
            AV20ComboARTPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtavComboartpaicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ComboARTPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboARTPaiCod), 4, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"ART");
            A1151ARTSec = (short)(localUtil.ctol( httpContext.cgiGet( edtARTSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
            forbiddenHiddens.add("ARTSec", localUtil.format( DecimalUtil.doubleToDec(A1151ARTSec), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A1151ARTSec != Z1151ARTSec ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("art:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A1151ARTSec = (short)(GXutil.lval( httpContext.GetPar( "ARTSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
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
                  sMode130 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode130 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound130 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_3A0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "ARTSEC");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtARTSec_Internalname ;
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
                        e113A2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e123A2 ();
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
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
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
         e123A2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll3A130( ) ;
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
         disableAttributes3A130( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboartpaicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboartpaicod_Enabled), 5, 0), true);
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

   public void confirm_3A0( )
   {
      beforeValidate3A130( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls3A130( ) ;
         }
         else
         {
            checkExtendedTable3A130( ) ;
            closeExtendedTableCursors3A130( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode130 = Gx_mode ;
         confirm_3A131( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode130 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode130 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_3A131( )
   {
      nGXsfl_52_idx = 0 ;
      while ( nGXsfl_52_idx < nRC_GXsfl_52 )
      {
         readRow3A131( ) ;
         if ( ( nRcdExists_131 != 0 ) || ( nIsMod_131 != 0 ) )
         {
            getKey3A131( ) ;
            if ( ( nRcdExists_131 == 0 ) && ( nRcdDeleted_131 == 0 ) )
            {
               if ( RcdFound131 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate3A131( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable3A131( ) ;
                     closeExtendedTableCursors3A131( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "ARTIMPFIJSEC_" + sGXsfl_52_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtARTImpFijSec_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound131 != 0 )
               {
                  if ( nRcdDeleted_131 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey3A131( ) ;
                     load3A131( ) ;
                     beforeValidate3A131( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls3A131( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_131 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate3A131( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable3A131( ) ;
                           closeExtendedTableCursors3A131( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_131 == 0 )
                  {
                     GXCCtl = "ARTIMPFIJSEC_" + sGXsfl_52_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtARTImpFijSec_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtARTImpFijSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1155ARTImpFijSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtARTImpFijFecha_Internalname, localUtil.format(A1156ARTImpFijFecha, "99/99/9999")) ;
         httpContext.changePostValue( edtARTFijo_Internalname, GXutil.ltrim( localUtil.ntoc( A1154ARTFijo, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1155ARTImpFijSec_"+sGXsfl_52_idx, GXutil.ltrim( localUtil.ntoc( Z1155ARTImpFijSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1156ARTImpFijFecha_"+sGXsfl_52_idx, localUtil.dtoc( Z1156ARTImpFijFecha, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z1154ARTFijo_"+sGXsfl_52_idx, GXutil.ltrim( localUtil.ntoc( Z1154ARTFijo, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_131_"+sGXsfl_52_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_131, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_131_"+sGXsfl_52_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_131, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_131_"+sGXsfl_52_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_131, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_131 != 0 )
         {
            httpContext.changePostValue( "ARTIMPFIJSEC_"+sGXsfl_52_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtARTImpFijSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTIMPFIJFECHA_"+sGXsfl_52_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtARTImpFijFecha_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTFIJO_"+sGXsfl_52_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtARTFijo_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption3A0( )
   {
   }

   public void e113A2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV16DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV16DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtARTPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtARTPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTPaiCod_Visible), 5, 0), true);
      AV20ComboARTPaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboARTPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboARTPaiCod), 4, 0));
      edtavComboartpaicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboartpaicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboartpaicod_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOARTPAICOD' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV9IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWART_Insert", GXv_boolean5) ;
         art_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWART_Update", GXv_boolean5) ;
         art_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWART_Delete", GXv_boolean5) ;
         art_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV22Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV22Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV23GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GXV1), 8, 0));
         while ( AV23GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV23GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ARTPaiCod") == 0 )
            {
               AV13Insert_ARTPaiCod = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_ARTPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_ARTPaiCod), 4, 0));
               if ( ! (0==AV13Insert_ARTPaiCod) )
               {
                  AV20ComboARTPaiCod = AV13Insert_ARTPaiCod ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboARTPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboARTPaiCod), 4, 0));
                  Combo_artpaicod_Selectedvalue_set = GXutil.trim( GXutil.str( AV20ComboARTPaiCod, 4, 0)) ;
                  ucCombo_artpaicod.sendProperty(context, "", false, Combo_artpaicod_Internalname, "SelectedValue_set", Combo_artpaicod_Selectedvalue_set);
                  GXt_char6 = AV19Combo_DataJson ;
                  GXv_char7[0] = AV17ComboSelectedValue ;
                  GXv_char8[0] = AV18ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new web.artloaddvcombo(remoteHandle, context).execute( "ARTPaiCod", "GET", false, AV7ARTSec, AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  art_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
                  art_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
                  art_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedValue", AV17ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedText", AV18ComboSelectedText);
                  AV19Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19Combo_DataJson", AV19Combo_DataJson);
                  Combo_artpaicod_Selectedtext_set = AV18ComboSelectedText ;
                  ucCombo_artpaicod.sendProperty(context, "", false, Combo_artpaicod_Internalname, "SelectedText_set", Combo_artpaicod_Selectedtext_set);
                  Combo_artpaicod_Enabled = false ;
                  ucCombo_artpaicod.sendProperty(context, "", false, Combo_artpaicod_Internalname, "Enabled", GXutil.booltostr( Combo_artpaicod_Enabled));
               }
            }
            AV23GXV1 = (int)(AV23GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GXV1), 8, 0));
         }
      }
   }

   public void e123A2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'LOADCOMBOARTPAICOD' Routine */
      returnInSub = false ;
      GXt_char6 = AV19Combo_DataJson ;
      GXv_char9[0] = AV17ComboSelectedValue ;
      GXv_char8[0] = AV18ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.artloaddvcombo(remoteHandle, context).execute( "ARTPaiCod", Gx_mode, false, AV7ARTSec, "", GXv_char9, GXv_char8, GXv_char7) ;
      art_impl.this.AV17ComboSelectedValue = GXv_char9[0] ;
      art_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
      art_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedValue", AV17ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedText", AV18ComboSelectedText);
      AV19Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19Combo_DataJson", AV19Combo_DataJson);
      Combo_artpaicod_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_artpaicod.sendProperty(context, "", false, Combo_artpaicod_Internalname, "SelectedValue_set", Combo_artpaicod_Selectedvalue_set);
      Combo_artpaicod_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_artpaicod.sendProperty(context, "", false, Combo_artpaicod_Internalname, "SelectedText_set", Combo_artpaicod_Selectedtext_set);
      AV20ComboARTPaiCod = (short)(GXutil.lval( AV17ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboARTPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboARTPaiCod), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_artpaicod_Enabled = false ;
         ucCombo_artpaicod.sendProperty(context, "", false, Combo_artpaicod_Internalname, "Enabled", GXutil.booltostr( Combo_artpaicod_Enabled));
      }
   }

   public void zm3A130( int GX_JID )
   {
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1152ARTNom = T003A5_A1152ARTNom[0] ;
            Z1153ARTAli = T003A5_A1153ARTAli[0] ;
            Z1149ARTPaiCod = T003A5_A1149ARTPaiCod[0] ;
         }
         else
         {
            Z1152ARTNom = A1152ARTNom ;
            Z1153ARTAli = A1153ARTAli ;
            Z1149ARTPaiCod = A1149ARTPaiCod ;
         }
      }
      if ( GX_JID == -8 )
      {
         Z1151ARTSec = A1151ARTSec ;
         Z1152ARTNom = A1152ARTNom ;
         Z1153ARTAli = A1153ARTAli ;
         Z1149ARTPaiCod = A1149ARTPaiCod ;
         Z1150ARTPaiNom = A1150ARTPaiNom ;
      }
   }

   public void standaloneNotModal( )
   {
      edtARTSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtARTSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTSec_Enabled), 5, 0), true);
      edtARTSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtARTSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTSec_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7ARTSec) )
      {
         A1151ARTSec = AV7ARTSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_ARTPaiCod) )
      {
         edtARTPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtARTPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTPaiCod_Enabled), 5, 0), true);
      }
      else
      {
         edtARTPaiCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtARTPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTPaiCod_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_ARTPaiCod) )
      {
         A1149ARTPaiCod = AV13Insert_ARTPaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1149ARTPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1149ARTPaiCod), 4, 0));
      }
      else
      {
         A1149ARTPaiCod = AV20ComboARTPaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1149ARTPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1149ARTPaiCod), 4, 0));
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
         AV22Pgmname = "ART" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
         /* Using cursor T003A6 */
         pr_default.execute(4, new Object[] {Short.valueOf(A1149ARTPaiCod)});
         A1150ARTPaiNom = T003A6_A1150ARTPaiNom[0] ;
         pr_default.close(4);
      }
   }

   public void load3A130( )
   {
      /* Using cursor T003A7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A1151ARTSec)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound130 = (short)(1) ;
         A1150ARTPaiNom = T003A7_A1150ARTPaiNom[0] ;
         A1152ARTNom = T003A7_A1152ARTNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1152ARTNom", A1152ARTNom);
         A1153ARTAli = T003A7_A1153ARTAli[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1153ARTAli", GXutil.ltrimstr( A1153ARTAli, 6, 4));
         A1149ARTPaiCod = T003A7_A1149ARTPaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1149ARTPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1149ARTPaiCod), 4, 0));
         zm3A130( -8) ;
      }
      pr_default.close(5);
      onLoadActions3A130( ) ;
   }

   public void onLoadActions3A130( )
   {
      AV22Pgmname = "ART" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
   }

   public void checkExtendedTable3A130( )
   {
      nIsDirty_130 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV22Pgmname = "ART" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      /* Using cursor T003A6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A1149ARTPaiCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "ARTPais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ARTPAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtARTPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1150ARTPaiNom = T003A6_A1150ARTPaiNom[0] ;
      pr_default.close(4);
   }

   public void closeExtendedTableCursors3A130( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void gxload_9( short A1149ARTPaiCod )
   {
      /* Using cursor T003A8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A1149ARTPaiCod)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "ARTPais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ARTPAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtARTPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1150ARTPaiNom = T003A8_A1150ARTPaiNom[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1150ARTPaiNom)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey3A130( )
   {
      /* Using cursor T003A9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A1151ARTSec)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound130 = (short)(1) ;
      }
      else
      {
         RcdFound130 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T003A5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A1151ARTSec)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm3A130( 8) ;
         RcdFound130 = (short)(1) ;
         A1151ARTSec = T003A5_A1151ARTSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
         A1152ARTNom = T003A5_A1152ARTNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1152ARTNom", A1152ARTNom);
         A1153ARTAli = T003A5_A1153ARTAli[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1153ARTAli", GXutil.ltrimstr( A1153ARTAli, 6, 4));
         A1149ARTPaiCod = T003A5_A1149ARTPaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1149ARTPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1149ARTPaiCod), 4, 0));
         Z1151ARTSec = A1151ARTSec ;
         sMode130 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load3A130( ) ;
         if ( AnyError == 1 )
         {
            RcdFound130 = (short)(0) ;
            initializeNonKey3A130( ) ;
         }
         Gx_mode = sMode130 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound130 = (short)(0) ;
         initializeNonKey3A130( ) ;
         sMode130 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode130 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(3);
   }

   public void getEqualNoModal( )
   {
      getKey3A130( ) ;
      if ( RcdFound130 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound130 = (short)(0) ;
      /* Using cursor T003A10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A1151ARTSec)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T003A10_A1151ARTSec[0] < A1151ARTSec ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T003A10_A1151ARTSec[0] > A1151ARTSec ) ) )
         {
            A1151ARTSec = T003A10_A1151ARTSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
            RcdFound130 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound130 = (short)(0) ;
      /* Using cursor T003A11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A1151ARTSec)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T003A11_A1151ARTSec[0] > A1151ARTSec ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T003A11_A1151ARTSec[0] < A1151ARTSec ) ) )
         {
            A1151ARTSec = T003A11_A1151ARTSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
            RcdFound130 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey3A130( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtARTPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert3A130( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound130 == 1 )
         {
            if ( A1151ARTSec != Z1151ARTSec )
            {
               A1151ARTSec = Z1151ARTSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "ARTSEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtARTSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtARTPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update3A130( ) ;
               GX_FocusControl = edtARTPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A1151ARTSec != Z1151ARTSec )
            {
               /* Insert record */
               GX_FocusControl = edtARTPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert3A130( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "ARTSEC");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtARTSec_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtARTPaiCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert3A130( ) ;
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
      if ( A1151ARTSec != Z1151ARTSec )
      {
         A1151ARTSec = Z1151ARTSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "ARTSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtARTSec_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtARTPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency3A130( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T003A4 */
         pr_default.execute(2, new Object[] {Short.valueOf(A1151ARTSec)});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ART"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(2) == 101) || ( GXutil.strcmp(Z1152ARTNom, T003A4_A1152ARTNom[0]) != 0 ) || ( DecimalUtil.compareTo(Z1153ARTAli, T003A4_A1153ARTAli[0]) != 0 ) || ( Z1149ARTPaiCod != T003A4_A1149ARTPaiCod[0] ) )
         {
            if ( GXutil.strcmp(Z1152ARTNom, T003A4_A1152ARTNom[0]) != 0 )
            {
               GXutil.writeLogln("art:[seudo value changed for attri]"+"ARTNom");
               GXutil.writeLogRaw("Old: ",Z1152ARTNom);
               GXutil.writeLogRaw("Current: ",T003A4_A1152ARTNom[0]);
            }
            if ( DecimalUtil.compareTo(Z1153ARTAli, T003A4_A1153ARTAli[0]) != 0 )
            {
               GXutil.writeLogln("art:[seudo value changed for attri]"+"ARTAli");
               GXutil.writeLogRaw("Old: ",Z1153ARTAli);
               GXutil.writeLogRaw("Current: ",T003A4_A1153ARTAli[0]);
            }
            if ( Z1149ARTPaiCod != T003A4_A1149ARTPaiCod[0] )
            {
               GXutil.writeLogln("art:[seudo value changed for attri]"+"ARTPaiCod");
               GXutil.writeLogRaw("Old: ",Z1149ARTPaiCod);
               GXutil.writeLogRaw("Current: ",T003A4_A1149ARTPaiCod[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ART"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert3A130( )
   {
      beforeValidate3A130( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3A130( ) ;
      }
      if ( AnyError == 0 )
      {
         zm3A130( 0) ;
         checkOptimisticConcurrency3A130( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3A130( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert3A130( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003A12 */
                  pr_default.execute(10, new Object[] {A1152ARTNom, A1153ARTAli, Short.valueOf(A1149ARTPaiCod)});
                  /* Retrieving last key number assigned */
                  /* Using cursor T003A13 */
                  pr_default.execute(11);
                  A1151ARTSec = T003A13_A1151ARTSec[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
                  pr_default.close(11);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ART");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel3A130( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption3A0( ) ;
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
         else
         {
            load3A130( ) ;
         }
         endLevel3A130( ) ;
      }
      closeExtendedTableCursors3A130( ) ;
   }

   public void update3A130( )
   {
      beforeValidate3A130( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3A130( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3A130( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3A130( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate3A130( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003A14 */
                  pr_default.execute(12, new Object[] {A1152ARTNom, A1153ARTAli, Short.valueOf(A1149ARTPaiCod), Short.valueOf(A1151ARTSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ART");
                  if ( (pr_default.getStatus(12) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ART"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate3A130( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel3A130( ) ;
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
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel3A130( ) ;
      }
      closeExtendedTableCursors3A130( ) ;
   }

   public void deferredUpdate3A130( )
   {
   }

   public void delete( )
   {
      beforeValidate3A130( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3A130( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls3A130( ) ;
         afterConfirm3A130( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete3A130( ) ;
            if ( AnyError == 0 )
            {
               scanStart3A131( ) ;
               while ( RcdFound131 != 0 )
               {
                  getByPrimaryKey3A131( ) ;
                  delete3A131( ) ;
                  scanNext3A131( ) ;
               }
               scanEnd3A131( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003A15 */
                  pr_default.execute(13, new Object[] {Short.valueOf(A1151ARTSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ART");
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
      }
      sMode130 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel3A130( ) ;
      Gx_mode = sMode130 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls3A130( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV22Pgmname = "ART" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
         /* Using cursor T003A16 */
         pr_default.execute(14, new Object[] {Short.valueOf(A1149ARTPaiCod)});
         A1150ARTPaiNom = T003A16_A1150ARTPaiNom[0] ;
         pr_default.close(14);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T003A17 */
         pr_default.execute(15, new Object[] {Short.valueOf(A1151ARTSec)});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
      }
   }

   public void processNestedLevel3A131( )
   {
      nGXsfl_52_idx = 0 ;
      while ( nGXsfl_52_idx < nRC_GXsfl_52 )
      {
         readRow3A131( ) ;
         if ( ( nRcdExists_131 != 0 ) || ( nIsMod_131 != 0 ) )
         {
            standaloneNotModal3A131( ) ;
            getKey3A131( ) ;
            if ( ( nRcdExists_131 == 0 ) && ( nRcdDeleted_131 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert3A131( ) ;
            }
            else
            {
               if ( RcdFound131 != 0 )
               {
                  if ( ( nRcdDeleted_131 != 0 ) && ( nRcdExists_131 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete3A131( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_131 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update3A131( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_131 == 0 )
                  {
                     GXCCtl = "ARTIMPFIJSEC_" + sGXsfl_52_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtARTImpFijSec_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtARTImpFijSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1155ARTImpFijSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtARTImpFijFecha_Internalname, localUtil.format(A1156ARTImpFijFecha, "99/99/9999")) ;
         httpContext.changePostValue( edtARTFijo_Internalname, GXutil.ltrim( localUtil.ntoc( A1154ARTFijo, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1155ARTImpFijSec_"+sGXsfl_52_idx, GXutil.ltrim( localUtil.ntoc( Z1155ARTImpFijSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1156ARTImpFijFecha_"+sGXsfl_52_idx, localUtil.dtoc( Z1156ARTImpFijFecha, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z1154ARTFijo_"+sGXsfl_52_idx, GXutil.ltrim( localUtil.ntoc( Z1154ARTFijo, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_131_"+sGXsfl_52_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_131, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_131_"+sGXsfl_52_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_131, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_131_"+sGXsfl_52_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_131, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_131 != 0 )
         {
            httpContext.changePostValue( "ARTIMPFIJSEC_"+sGXsfl_52_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtARTImpFijSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTIMPFIJFECHA_"+sGXsfl_52_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtARTImpFijFecha_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTFIJO_"+sGXsfl_52_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtARTFijo_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll3A131( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_131 = (short)(0) ;
      nIsMod_131 = (short)(0) ;
      nRcdDeleted_131 = (short)(0) ;
   }

   public void processLevel3A130( )
   {
      /* Save parent mode. */
      sMode130 = Gx_mode ;
      processNestedLevel3A131( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode130 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel3A130( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError == 0 )
      {
         beforeComplete3A130( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "art");
         if ( AnyError == 0 )
         {
            confirmValues3A0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "art");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart3A130( )
   {
      /* Scan By routine */
      /* Using cursor T003A18 */
      pr_default.execute(16);
      RcdFound130 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound130 = (short)(1) ;
         A1151ARTSec = T003A18_A1151ARTSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext3A130( )
   {
      /* Scan next routine */
      pr_default.readNext(16);
      RcdFound130 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound130 = (short)(1) ;
         A1151ARTSec = T003A18_A1151ARTSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
      }
   }

   public void scanEnd3A130( )
   {
      pr_default.close(16);
   }

   public void afterConfirm3A130( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert3A130( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate3A130( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete3A130( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete3A130( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate3A130( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes3A130( )
   {
      edtARTSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtARTSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTSec_Enabled), 5, 0), true);
      edtARTPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtARTPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTPaiCod_Enabled), 5, 0), true);
      edtARTNom_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtARTNom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTNom_Enabled), 5, 0), true);
      edtARTAli_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtARTAli_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTAli_Enabled), 5, 0), true);
      edtavComboartpaicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboartpaicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboartpaicod_Enabled), 5, 0), true);
   }

   public void zm3A131( int GX_JID )
   {
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1156ARTImpFijFecha = T003A3_A1156ARTImpFijFecha[0] ;
            Z1154ARTFijo = T003A3_A1154ARTFijo[0] ;
         }
         else
         {
            Z1156ARTImpFijFecha = A1156ARTImpFijFecha ;
            Z1154ARTFijo = A1154ARTFijo ;
         }
      }
      if ( GX_JID == -10 )
      {
         Z1151ARTSec = A1151ARTSec ;
         Z1155ARTImpFijSec = A1155ARTImpFijSec ;
         Z1156ARTImpFijFecha = A1156ARTImpFijFecha ;
         Z1154ARTFijo = A1154ARTFijo ;
      }
   }

   public void standaloneNotModal3A131( )
   {
   }

   public void standaloneModal3A131( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtARTImpFijSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtARTImpFijSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTImpFijSec_Enabled), 5, 0), !bGXsfl_52_Refreshing);
      }
      else
      {
         edtARTImpFijSec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtARTImpFijSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTImpFijSec_Enabled), 5, 0), !bGXsfl_52_Refreshing);
      }
   }

   public void load3A131( )
   {
      /* Using cursor T003A19 */
      pr_default.execute(17, new Object[] {Short.valueOf(A1151ARTSec), Short.valueOf(A1155ARTImpFijSec)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound131 = (short)(1) ;
         A1156ARTImpFijFecha = T003A19_A1156ARTImpFijFecha[0] ;
         A1154ARTFijo = T003A19_A1154ARTFijo[0] ;
         zm3A131( -10) ;
      }
      pr_default.close(17);
      onLoadActions3A131( ) ;
   }

   public void onLoadActions3A131( )
   {
   }

   public void checkExtendedTable3A131( )
   {
      nIsDirty_131 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal3A131( ) ;
   }

   public void closeExtendedTableCursors3A131( )
   {
   }

   public void enableDisable3A131( )
   {
   }

   public void getKey3A131( )
   {
      /* Using cursor T003A20 */
      pr_default.execute(18, new Object[] {Short.valueOf(A1151ARTSec), Short.valueOf(A1155ARTImpFijSec)});
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound131 = (short)(1) ;
      }
      else
      {
         RcdFound131 = (short)(0) ;
      }
      pr_default.close(18);
   }

   public void getByPrimaryKey3A131( )
   {
      /* Using cursor T003A3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A1151ARTSec), Short.valueOf(A1155ARTImpFijSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm3A131( 10) ;
         RcdFound131 = (short)(1) ;
         initializeNonKey3A131( ) ;
         A1155ARTImpFijSec = T003A3_A1155ARTImpFijSec[0] ;
         A1156ARTImpFijFecha = T003A3_A1156ARTImpFijFecha[0] ;
         A1154ARTFijo = T003A3_A1154ARTFijo[0] ;
         Z1151ARTSec = A1151ARTSec ;
         Z1155ARTImpFijSec = A1155ARTImpFijSec ;
         sMode131 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load3A131( ) ;
         Gx_mode = sMode131 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound131 = (short)(0) ;
         initializeNonKey3A131( ) ;
         sMode131 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal3A131( ) ;
         Gx_mode = sMode131 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes3A131( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency3A131( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T003A2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A1151ARTSec), Short.valueOf(A1155ARTImpFijSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ARTImportesFijos"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || !( GXutil.dateCompare(GXutil.resetTime(Z1156ARTImpFijFecha), GXutil.resetTime(T003A2_A1156ARTImpFijFecha[0])) ) || ( DecimalUtil.compareTo(Z1154ARTFijo, T003A2_A1154ARTFijo[0]) != 0 ) )
         {
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z1156ARTImpFijFecha), GXutil.resetTime(T003A2_A1156ARTImpFijFecha[0])) ) )
            {
               GXutil.writeLogln("art:[seudo value changed for attri]"+"ARTImpFijFecha");
               GXutil.writeLogRaw("Old: ",Z1156ARTImpFijFecha);
               GXutil.writeLogRaw("Current: ",T003A2_A1156ARTImpFijFecha[0]);
            }
            if ( DecimalUtil.compareTo(Z1154ARTFijo, T003A2_A1154ARTFijo[0]) != 0 )
            {
               GXutil.writeLogln("art:[seudo value changed for attri]"+"ARTFijo");
               GXutil.writeLogRaw("Old: ",Z1154ARTFijo);
               GXutil.writeLogRaw("Current: ",T003A2_A1154ARTFijo[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ARTImportesFijos"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert3A131( )
   {
      beforeValidate3A131( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3A131( ) ;
      }
      if ( AnyError == 0 )
      {
         zm3A131( 0) ;
         checkOptimisticConcurrency3A131( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3A131( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert3A131( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003A21 */
                  pr_default.execute(19, new Object[] {Short.valueOf(A1151ARTSec), Short.valueOf(A1155ARTImpFijSec), A1156ARTImpFijFecha, A1154ARTFijo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ARTImportesFijos");
                  if ( (pr_default.getStatus(19) == 1) )
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
            load3A131( ) ;
         }
         endLevel3A131( ) ;
      }
      closeExtendedTableCursors3A131( ) ;
   }

   public void update3A131( )
   {
      beforeValidate3A131( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3A131( ) ;
      }
      if ( ( nIsMod_131 != 0 ) || ( nIsDirty_131 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency3A131( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm3A131( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate3A131( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T003A22 */
                     pr_default.execute(20, new Object[] {A1156ARTImpFijFecha, A1154ARTFijo, Short.valueOf(A1151ARTSec), Short.valueOf(A1155ARTImpFijSec)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("ARTImportesFijos");
                     if ( (pr_default.getStatus(20) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ARTImportesFijos"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate3A131( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey3A131( ) ;
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
            endLevel3A131( ) ;
         }
      }
      closeExtendedTableCursors3A131( ) ;
   }

   public void deferredUpdate3A131( )
   {
   }

   public void delete3A131( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate3A131( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3A131( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls3A131( ) ;
         afterConfirm3A131( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete3A131( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T003A23 */
               pr_default.execute(21, new Object[] {Short.valueOf(A1151ARTSec), Short.valueOf(A1155ARTImpFijSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ARTImportesFijos");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode131 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel3A131( ) ;
      Gx_mode = sMode131 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls3A131( )
   {
      standaloneModal3A131( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel3A131( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart3A131( )
   {
      /* Scan By routine */
      /* Using cursor T003A24 */
      pr_default.execute(22, new Object[] {Short.valueOf(A1151ARTSec)});
      RcdFound131 = (short)(0) ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound131 = (short)(1) ;
         A1155ARTImpFijSec = T003A24_A1155ARTImpFijSec[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext3A131( )
   {
      /* Scan next routine */
      pr_default.readNext(22);
      RcdFound131 = (short)(0) ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound131 = (short)(1) ;
         A1155ARTImpFijSec = T003A24_A1155ARTImpFijSec[0] ;
      }
   }

   public void scanEnd3A131( )
   {
      pr_default.close(22);
   }

   public void afterConfirm3A131( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert3A131( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate3A131( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete3A131( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete3A131( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate3A131( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes3A131( )
   {
      edtARTImpFijSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtARTImpFijSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTImpFijSec_Enabled), 5, 0), !bGXsfl_52_Refreshing);
      edtARTImpFijFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtARTImpFijFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTImpFijFecha_Enabled), 5, 0), !bGXsfl_52_Refreshing);
      edtARTFijo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtARTFijo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTFijo_Enabled), 5, 0), !bGXsfl_52_Refreshing);
   }

   public void send_integrity_lvl_hashes3A131( )
   {
   }

   public void send_integrity_lvl_hashes3A130( )
   {
   }

   public void subsflControlProps_52131( )
   {
      edtARTImpFijSec_Internalname = "ARTIMPFIJSEC_"+sGXsfl_52_idx ;
      edtARTImpFijFecha_Internalname = "ARTIMPFIJFECHA_"+sGXsfl_52_idx ;
      edtARTFijo_Internalname = "ARTFIJO_"+sGXsfl_52_idx ;
   }

   public void subsflControlProps_fel_52131( )
   {
      edtARTImpFijSec_Internalname = "ARTIMPFIJSEC_"+sGXsfl_52_fel_idx ;
      edtARTImpFijFecha_Internalname = "ARTIMPFIJFECHA_"+sGXsfl_52_fel_idx ;
      edtARTFijo_Internalname = "ARTFIJO_"+sGXsfl_52_fel_idx ;
   }

   public void addRow3A131( )
   {
      nGXsfl_52_idx = (int)(nGXsfl_52_idx+1) ;
      sGXsfl_52_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_52_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_52131( ) ;
      sendRow3A131( ) ;
   }

   public void sendRow3A131( )
   {
      Gridlevel_importesfijosRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_importesfijos_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_importesfijos_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_importesfijos_Class, "") != 0 )
         {
            subGridlevel_importesfijos_Linesclass = subGridlevel_importesfijos_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_importesfijos_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_importesfijos_Backstyle = (byte)(0) ;
         subGridlevel_importesfijos_Backcolor = subGridlevel_importesfijos_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_importesfijos_Class, "") != 0 )
         {
            subGridlevel_importesfijos_Linesclass = subGridlevel_importesfijos_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_importesfijos_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_importesfijos_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_importesfijos_Class, "") != 0 )
         {
            subGridlevel_importesfijos_Linesclass = subGridlevel_importesfijos_Class+"Odd" ;
         }
         subGridlevel_importesfijos_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_importesfijos_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_importesfijos_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_52_idx) % (2))) == 0 )
         {
            subGridlevel_importesfijos_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_importesfijos_Class, "") != 0 )
            {
               subGridlevel_importesfijos_Linesclass = subGridlevel_importesfijos_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_importesfijos_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_importesfijos_Class, "") != 0 )
            {
               subGridlevel_importesfijos_Linesclass = subGridlevel_importesfijos_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_131_" + sGXsfl_52_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 53,'',false,'" + sGXsfl_52_idx + "',52)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_importesfijosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtARTImpFijSec_Internalname,GXutil.ltrim( localUtil.ntoc( A1155ARTImpFijSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1155ARTImpFijSec), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,53);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtARTImpFijSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtARTImpFijSec_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(52),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_131_" + sGXsfl_52_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 54,'',false,'" + sGXsfl_52_idx + "',52)\"" ;
      ROClassString = "AttributeDate" ;
      Gridlevel_importesfijosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtARTImpFijFecha_Internalname,localUtil.format(A1156ARTImpFijFecha, "99/99/9999"),localUtil.format( A1156ARTImpFijFecha, "99/99/9999"),TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,54);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtARTImpFijFecha_Jsonclick,Integer.valueOf(0),"AttributeDate","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtARTImpFijFecha_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(52),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_131_" + sGXsfl_52_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 55,'',false,'" + sGXsfl_52_idx + "',52)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_importesfijosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtARTFijo_Internalname,GXutil.ltrim( localUtil.ntoc( A1154ARTFijo, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtARTFijo_Enabled!=0) ? localUtil.format( A1154ARTFijo, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1154ARTFijo, "ZZ,ZZZ,ZZZ,ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,55);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtARTFijo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtARTFijo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(52),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel_importesfijosRow);
      send_integrity_lvl_hashes3A131( ) ;
      GXCCtl = "Z1155ARTImpFijSec_" + sGXsfl_52_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1155ARTImpFijSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1156ARTImpFijFecha_" + sGXsfl_52_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, localUtil.dtoc( Z1156ARTImpFijFecha, 0, "/"));
      GXCCtl = "Z1154ARTFijo_" + sGXsfl_52_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1154ARTFijo, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_131_" + sGXsfl_52_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_131, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_131_" + sGXsfl_52_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_131, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_131_" + sGXsfl_52_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_131, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_52_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vARTSEC_" + sGXsfl_52_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7ARTSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "ARTIMPFIJSEC_"+sGXsfl_52_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtARTImpFijSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "ARTIMPFIJFECHA_"+sGXsfl_52_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtARTImpFijFecha_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "ARTFIJO_"+sGXsfl_52_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtARTFijo_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_importesfijosContainer.AddRow(Gridlevel_importesfijosRow);
   }

   public void readRow3A131( )
   {
      nGXsfl_52_idx = (int)(nGXsfl_52_idx+1) ;
      sGXsfl_52_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_52_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_52131( ) ;
      edtARTImpFijSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTIMPFIJSEC_"+sGXsfl_52_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtARTImpFijFecha_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTIMPFIJFECHA_"+sGXsfl_52_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtARTFijo_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTFIJO_"+sGXsfl_52_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtARTImpFijSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtARTImpFijSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
      {
         GXCCtl = "ARTIMPFIJSEC_" + sGXsfl_52_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtARTImpFijSec_Internalname ;
         wbErr = true ;
         A1155ARTImpFijSec = (short)(0) ;
      }
      else
      {
         A1155ARTImpFijSec = (short)(localUtil.ctol( httpContext.cgiGet( edtARTImpFijSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      if ( localUtil.vcdate( httpContext.cgiGet( edtARTImpFijFecha_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
      {
         GXCCtl = "ARTIMPFIJFECHA_" + sGXsfl_52_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtARTImpFijFecha_Internalname ;
         wbErr = true ;
         A1156ARTImpFijFecha = GXutil.nullDate() ;
      }
      else
      {
         A1156ARTImpFijFecha = localUtil.ctod( httpContext.cgiGet( edtARTImpFijFecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
      }
      if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtARTFijo_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtARTFijo_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
      {
         GXCCtl = "ARTFIJO_" + sGXsfl_52_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtARTFijo_Internalname ;
         wbErr = true ;
         A1154ARTFijo = DecimalUtil.ZERO ;
      }
      else
      {
         A1154ARTFijo = localUtil.ctond( httpContext.cgiGet( edtARTFijo_Internalname)) ;
      }
      GXCCtl = "Z1155ARTImpFijSec_" + sGXsfl_52_idx ;
      Z1155ARTImpFijSec = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1156ARTImpFijFecha_" + sGXsfl_52_idx ;
      Z1156ARTImpFijFecha = localUtil.ctod( httpContext.cgiGet( GXCCtl), 0) ;
      GXCCtl = "Z1154ARTFijo_" + sGXsfl_52_idx ;
      Z1154ARTFijo = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "nRcdDeleted_131_" + sGXsfl_52_idx ;
      nRcdDeleted_131 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_131_" + sGXsfl_52_idx ;
      nRcdExists_131 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_131_" + sGXsfl_52_idx ;
      nIsMod_131 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtARTImpFijSec_Enabled = edtARTImpFijSec_Enabled ;
   }

   public void confirmValues3A0( )
   {
      nGXsfl_52_idx = 0 ;
      sGXsfl_52_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_52_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_52131( ) ;
      while ( nGXsfl_52_idx < nRC_GXsfl_52 )
      {
         nGXsfl_52_idx = (int)(nGXsfl_52_idx+1) ;
         sGXsfl_52_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_52_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_52131( ) ;
         httpContext.changePostValue( "Z1155ARTImpFijSec_"+sGXsfl_52_idx, httpContext.cgiGet( "ZT_"+"Z1155ARTImpFijSec_"+sGXsfl_52_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1155ARTImpFijSec_"+sGXsfl_52_idx) ;
         httpContext.changePostValue( "Z1156ARTImpFijFecha_"+sGXsfl_52_idx, httpContext.cgiGet( "ZT_"+"Z1156ARTImpFijFecha_"+sGXsfl_52_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1156ARTImpFijFecha_"+sGXsfl_52_idx) ;
         httpContext.changePostValue( "Z1154ARTFijo_"+sGXsfl_52_idx, httpContext.cgiGet( "ZT_"+"Z1154ARTFijo_"+sGXsfl_52_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1154ARTFijo_"+sGXsfl_52_idx) ;
      }
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.art", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7ARTSec,4,0))}, new String[] {"Gx_mode","ARTSec"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"ART");
      forbiddenHiddens.add("ARTSec", localUtil.format( DecimalUtil.doubleToDec(A1151ARTSec), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("art:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z1151ARTSec", GXutil.ltrim( localUtil.ntoc( Z1151ARTSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1152ARTNom", Z1152ARTNom);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1153ARTAli", GXutil.ltrim( localUtil.ntoc( Z1153ARTAli, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1149ARTPaiCod", GXutil.ltrim( localUtil.ntoc( Z1149ARTPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_52", GXutil.ltrim( localUtil.ntoc( nGXsfl_52_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N1149ARTPaiCod", GXutil.ltrim( localUtil.ntoc( A1149ARTPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV16DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV16DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vARTPAICOD_DATA", AV15ARTPaiCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vARTPAICOD_DATA", AV15ARTPaiCod_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vARTSEC", GXutil.ltrim( localUtil.ntoc( AV7ARTSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vARTSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ARTSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_ARTPAICOD", GXutil.ltrim( localUtil.ntoc( AV13Insert_ARTPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "ARTPAINOM", A1150ARTPaiNom);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV22Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ARTPAICOD_Objectcall", GXutil.rtrim( Combo_artpaicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ARTPAICOD_Cls", GXutil.rtrim( Combo_artpaicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ARTPAICOD_Selectedvalue_set", GXutil.rtrim( Combo_artpaicod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ARTPAICOD_Selectedtext_set", GXutil.rtrim( Combo_artpaicod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ARTPAICOD_Enabled", GXutil.booltostr( Combo_artpaicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ARTPAICOD_Datalistproc", GXutil.rtrim( Combo_artpaicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ARTPAICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_artpaicod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ARTPAICOD_Emptyitem", GXutil.booltostr( Combo_artpaicod_Emptyitem));
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
      return formatLink("web.art", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7ARTSec,4,0))}, new String[] {"Gx_mode","ARTSec"})  ;
   }

   public String getPgmname( )
   {
      return "ART" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "ART", "") ;
   }

   public void initializeNonKey3A130( )
   {
      A1149ARTPaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1149ARTPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1149ARTPaiCod), 4, 0));
      A1150ARTPaiNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1150ARTPaiNom", A1150ARTPaiNom);
      A1152ARTNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1152ARTNom", A1152ARTNom);
      A1153ARTAli = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1153ARTAli", GXutil.ltrimstr( A1153ARTAli, 6, 4));
      Z1152ARTNom = "" ;
      Z1153ARTAli = DecimalUtil.ZERO ;
      Z1149ARTPaiCod = (short)(0) ;
   }

   public void initAll3A130( )
   {
      A1151ARTSec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1151ARTSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1151ARTSec), 4, 0));
      initializeNonKey3A130( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey3A131( )
   {
      A1156ARTImpFijFecha = GXutil.nullDate() ;
      A1154ARTFijo = DecimalUtil.ZERO ;
      Z1156ARTImpFijFecha = GXutil.nullDate() ;
      Z1154ARTFijo = DecimalUtil.ZERO ;
   }

   public void initAll3A131( )
   {
      A1155ARTImpFijSec = (short)(0) ;
      initializeNonKey3A131( ) ;
   }

   public void standaloneModalInsert3A131( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025139315448", true, true);
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
      httpContext.AddJavascriptSource("art.js", "?2025139315449", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties131( )
   {
      edtARTImpFijSec_Enabled = defedtARTImpFijSec_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtARTImpFijSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtARTImpFijSec_Enabled), 5, 0), !bGXsfl_52_Refreshing);
   }

   public void startgridcontrol52( )
   {
      Gridlevel_importesfijosContainer.AddObjectProperty("GridName", "Gridlevel_importesfijos");
      Gridlevel_importesfijosContainer.AddObjectProperty("Header", subGridlevel_importesfijos_Header);
      Gridlevel_importesfijosContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_importesfijosContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_importesfijosContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_importesfijosContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_importesfijos_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_importesfijosContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_importesfijosContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_importesfijosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_importesfijosColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1155ARTImpFijSec, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_importesfijosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtARTImpFijSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_importesfijosContainer.AddColumnProperties(Gridlevel_importesfijosColumn);
      Gridlevel_importesfijosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_importesfijosColumn.AddObjectProperty("Value", localUtil.format(A1156ARTImpFijFecha, "99/99/9999"));
      Gridlevel_importesfijosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtARTImpFijFecha_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_importesfijosContainer.AddColumnProperties(Gridlevel_importesfijosColumn);
      Gridlevel_importesfijosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_importesfijosColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1154ARTFijo, (byte)(17), (byte)(2), ".", "")));
      Gridlevel_importesfijosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtARTFijo_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_importesfijosContainer.AddColumnProperties(Gridlevel_importesfijosColumn);
      Gridlevel_importesfijosContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_importesfijos_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_importesfijosContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_importesfijos_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_importesfijosContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_importesfijos_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_importesfijosContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_importesfijos_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_importesfijosContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_importesfijos_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_importesfijosContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_importesfijos_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_importesfijosContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_importesfijos_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      edtARTSec_Internalname = "ARTSEC" ;
      lblTextblockartpaicod_Internalname = "TEXTBLOCKARTPAICOD" ;
      Combo_artpaicod_Internalname = "COMBO_ARTPAICOD" ;
      edtARTPaiCod_Internalname = "ARTPAICOD" ;
      divTablesplittedartpaicod_Internalname = "TABLESPLITTEDARTPAICOD" ;
      edtARTNom_Internalname = "ARTNOM" ;
      edtARTAli_Internalname = "ARTALI" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtARTImpFijSec_Internalname = "ARTIMPFIJSEC" ;
      edtARTImpFijFecha_Internalname = "ARTIMPFIJFECHA" ;
      edtARTFijo_Internalname = "ARTFIJO" ;
      divTableleaflevel_importesfijos_Internalname = "TABLELEAFLEVEL_IMPORTESFIJOS" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboartpaicod_Internalname = "vCOMBOARTPAICOD" ;
      divSectionattribute_artpaicod_Internalname = "SECTIONATTRIBUTE_ARTPAICOD" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel_importesfijos_Internalname = "GRIDLEVEL_IMPORTESFIJOS" ;
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
      subGridlevel_importesfijos_Allowcollapsing = (byte)(0) ;
      subGridlevel_importesfijos_Allowselection = (byte)(0) ;
      subGridlevel_importesfijos_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "ART", "") );
      edtARTFijo_Jsonclick = "" ;
      edtARTImpFijFecha_Jsonclick = "" ;
      edtARTImpFijSec_Jsonclick = "" ;
      subGridlevel_importesfijos_Class = "WorkWith" ;
      subGridlevel_importesfijos_Backcolorstyle = (byte)(0) ;
      edtavComboartpaicod_Jsonclick = "" ;
      edtavComboartpaicod_Enabled = 0 ;
      edtavComboartpaicod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtARTFijo_Enabled = 1 ;
      edtARTImpFijFecha_Enabled = 1 ;
      edtARTImpFijSec_Enabled = 1 ;
      edtARTAli_Jsonclick = "" ;
      edtARTAli_Enabled = 1 ;
      edtARTNom_Enabled = 1 ;
      edtARTPaiCod_Jsonclick = "" ;
      edtARTPaiCod_Enabled = 1 ;
      edtARTPaiCod_Visible = 1 ;
      Combo_artpaicod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_artpaicod_Datalistprocparametersprefix = " \"ComboName\": \"ARTPaiCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"ARTSec\": 0" ;
      Combo_artpaicod_Datalistproc = "ARTLoadDVCombo" ;
      Combo_artpaicod_Cls = "ExtendedCombo Attribute" ;
      Combo_artpaicod_Caption = "" ;
      Combo_artpaicod_Enabled = GXutil.toBoolean( -1) ;
      edtARTSec_Jsonclick = "" ;
      edtARTSec_Enabled = 0 ;
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

   public void gxnrgridlevel_importesfijos_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_52131( ) ;
      while ( nGXsfl_52_idx <= nRC_GXsfl_52 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal3A131( ) ;
         standaloneModal3A131( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow3A131( ) ;
         nGXsfl_52_idx = (int)(nGXsfl_52_idx+1) ;
         sGXsfl_52_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_52_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_52131( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_importesfijosContainer)) ;
      /* End function gxnrGridlevel_importesfijos_newrow */
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

   public void valid_Artpaicod( )
   {
      /* Using cursor T003A16 */
      pr_default.execute(14, new Object[] {Short.valueOf(A1149ARTPaiCod)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "ARTPais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ARTPAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtARTPaiCod_Internalname ;
      }
      A1150ARTPaiNom = T003A16_A1150ARTPaiNom[0] ;
      pr_default.close(14);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1150ARTPaiNom", A1150ARTPaiNom);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7ARTSec',fld:'vARTSEC',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7ARTSec',fld:'vARTSEC',pic:'ZZZ9',hsh:true},{av:'A1151ARTSec',fld:'ARTSEC',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e123A2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_ARTSEC","{handler:'valid_Artsec',iparms:[]");
      setEventMetadata("VALID_ARTSEC",",oparms:[]}");
      setEventMetadata("VALID_ARTPAICOD","{handler:'valid_Artpaicod',iparms:[{av:'A1149ARTPaiCod',fld:'ARTPAICOD',pic:'ZZZ9'},{av:'A1150ARTPaiNom',fld:'ARTPAINOM',pic:'@!'}]");
      setEventMetadata("VALID_ARTPAICOD",",oparms:[{av:'A1150ARTPaiNom',fld:'ARTPAINOM',pic:'@!'}]}");
      setEventMetadata("VALIDV_COMBOARTPAICOD","{handler:'validv_Comboartpaicod',iparms:[]");
      setEventMetadata("VALIDV_COMBOARTPAICOD",",oparms:[]}");
      setEventMetadata("VALID_ARTIMPFIJSEC","{handler:'valid_Artimpfijsec',iparms:[]");
      setEventMetadata("VALID_ARTIMPFIJSEC",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Artfijo',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
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
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z1152ARTNom = "" ;
      Z1153ARTAli = DecimalUtil.ZERO ;
      Combo_artpaicod_Selectedvalue_get = "" ;
      Z1156ARTImpFijFecha = GXutil.nullDate() ;
      Z1154ARTFijo = DecimalUtil.ZERO ;
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
      lblTextblockartpaicod_Jsonclick = "" ;
      ucCombo_artpaicod = new com.genexus.webpanels.GXUserControl();
      AV16DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV15ARTPaiCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A1152ARTNom = "" ;
      A1153ARTAli = DecimalUtil.ZERO ;
      Gridlevel_importesfijosContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode131 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A1150ARTPaiNom = "" ;
      AV22Pgmname = "" ;
      Combo_artpaicod_Objectcall = "" ;
      Combo_artpaicod_Class = "" ;
      Combo_artpaicod_Icontype = "" ;
      Combo_artpaicod_Icon = "" ;
      Combo_artpaicod_Tooltip = "" ;
      Combo_artpaicod_Selectedvalue_set = "" ;
      Combo_artpaicod_Selectedtext_set = "" ;
      Combo_artpaicod_Selectedtext_get = "" ;
      Combo_artpaicod_Gamoauthtoken = "" ;
      Combo_artpaicod_Ddointernalname = "" ;
      Combo_artpaicod_Titlecontrolalign = "" ;
      Combo_artpaicod_Dropdownoptionstype = "" ;
      Combo_artpaicod_Titlecontrolidtoreplace = "" ;
      Combo_artpaicod_Datalisttype = "" ;
      Combo_artpaicod_Datalistfixedvalues = "" ;
      Combo_artpaicod_Remoteservicesparameters = "" ;
      Combo_artpaicod_Htmltemplate = "" ;
      Combo_artpaicod_Multiplevaluestype = "" ;
      Combo_artpaicod_Loadingdata = "" ;
      Combo_artpaicod_Noresultsfound = "" ;
      Combo_artpaicod_Emptyitemtext = "" ;
      Combo_artpaicod_Onlyselectedvalues = "" ;
      Combo_artpaicod_Selectalltext = "" ;
      Combo_artpaicod_Multiplevaluesseparator = "" ;
      Combo_artpaicod_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode130 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A1156ARTImpFijFecha = GXutil.nullDate() ;
      A1154ARTFijo = DecimalUtil.ZERO ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV19Combo_DataJson = "" ;
      AV17ComboSelectedValue = "" ;
      AV18ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z1150ARTPaiNom = "" ;
      T003A6_A1150ARTPaiNom = new String[] {""} ;
      T003A7_A1151ARTSec = new short[1] ;
      T003A7_A1150ARTPaiNom = new String[] {""} ;
      T003A7_A1152ARTNom = new String[] {""} ;
      T003A7_A1153ARTAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003A7_A1149ARTPaiCod = new short[1] ;
      T003A8_A1150ARTPaiNom = new String[] {""} ;
      T003A9_A1151ARTSec = new short[1] ;
      T003A5_A1151ARTSec = new short[1] ;
      T003A5_A1152ARTNom = new String[] {""} ;
      T003A5_A1153ARTAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003A5_A1149ARTPaiCod = new short[1] ;
      T003A10_A1151ARTSec = new short[1] ;
      T003A11_A1151ARTSec = new short[1] ;
      T003A4_A1151ARTSec = new short[1] ;
      T003A4_A1152ARTNom = new String[] {""} ;
      T003A4_A1153ARTAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003A4_A1149ARTPaiCod = new short[1] ;
      T003A13_A1151ARTSec = new short[1] ;
      T003A16_A1150ARTPaiNom = new String[] {""} ;
      T003A17_A3CliCod = new int[1] ;
      T003A17_A1EmpCod = new short[1] ;
      T003A18_A1151ARTSec = new short[1] ;
      T003A19_A1151ARTSec = new short[1] ;
      T003A19_A1155ARTImpFijSec = new short[1] ;
      T003A19_A1156ARTImpFijFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T003A19_A1154ARTFijo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003A20_A1151ARTSec = new short[1] ;
      T003A20_A1155ARTImpFijSec = new short[1] ;
      T003A3_A1151ARTSec = new short[1] ;
      T003A3_A1155ARTImpFijSec = new short[1] ;
      T003A3_A1156ARTImpFijFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T003A3_A1154ARTFijo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003A2_A1151ARTSec = new short[1] ;
      T003A2_A1155ARTImpFijSec = new short[1] ;
      T003A2_A1156ARTImpFijFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T003A2_A1154ARTFijo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003A24_A1151ARTSec = new short[1] ;
      T003A24_A1155ARTImpFijSec = new short[1] ;
      Gridlevel_importesfijosRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_importesfijos_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel_importesfijosColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.art__default(),
         new Object[] {
             new Object[] {
            T003A2_A1151ARTSec, T003A2_A1155ARTImpFijSec, T003A2_A1156ARTImpFijFecha, T003A2_A1154ARTFijo
            }
            , new Object[] {
            T003A3_A1151ARTSec, T003A3_A1155ARTImpFijSec, T003A3_A1156ARTImpFijFecha, T003A3_A1154ARTFijo
            }
            , new Object[] {
            T003A4_A1151ARTSec, T003A4_A1152ARTNom, T003A4_A1153ARTAli, T003A4_A1149ARTPaiCod
            }
            , new Object[] {
            T003A5_A1151ARTSec, T003A5_A1152ARTNom, T003A5_A1153ARTAli, T003A5_A1149ARTPaiCod
            }
            , new Object[] {
            T003A6_A1150ARTPaiNom
            }
            , new Object[] {
            T003A7_A1151ARTSec, T003A7_A1150ARTPaiNom, T003A7_A1152ARTNom, T003A7_A1153ARTAli, T003A7_A1149ARTPaiCod
            }
            , new Object[] {
            T003A8_A1150ARTPaiNom
            }
            , new Object[] {
            T003A9_A1151ARTSec
            }
            , new Object[] {
            T003A10_A1151ARTSec
            }
            , new Object[] {
            T003A11_A1151ARTSec
            }
            , new Object[] {
            }
            , new Object[] {
            T003A13_A1151ARTSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T003A16_A1150ARTPaiNom
            }
            , new Object[] {
            T003A17_A3CliCod, T003A17_A1EmpCod
            }
            , new Object[] {
            T003A18_A1151ARTSec
            }
            , new Object[] {
            T003A19_A1151ARTSec, T003A19_A1155ARTImpFijSec, T003A19_A1156ARTImpFijFecha, T003A19_A1154ARTFijo
            }
            , new Object[] {
            T003A20_A1151ARTSec, T003A20_A1155ARTImpFijSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T003A24_A1151ARTSec, T003A24_A1155ARTImpFijSec
            }
         }
      );
      AV22Pgmname = "ART" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte subGridlevel_importesfijos_Backcolorstyle ;
   private byte subGridlevel_importesfijos_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel_importesfijos_Allowselection ;
   private byte subGridlevel_importesfijos_Allowhovering ;
   private byte subGridlevel_importesfijos_Allowcollapsing ;
   private byte subGridlevel_importesfijos_Collapsed ;
   private short wcpOAV7ARTSec ;
   private short Z1151ARTSec ;
   private short Z1149ARTPaiCod ;
   private short N1149ARTPaiCod ;
   private short Z1155ARTImpFijSec ;
   private short nRcdDeleted_131 ;
   private short nRcdExists_131 ;
   private short nIsMod_131 ;
   private short A1149ARTPaiCod ;
   private short AV7ARTSec ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1151ARTSec ;
   private short nBlankRcdCount131 ;
   private short RcdFound131 ;
   private short nBlankRcdUsr131 ;
   private short AV20ComboARTPaiCod ;
   private short AV13Insert_ARTPaiCod ;
   private short RcdFound130 ;
   private short A1155ARTImpFijSec ;
   private short nIsDirty_130 ;
   private short nIsDirty_131 ;
   private int nRC_GXsfl_52 ;
   private int nGXsfl_52_idx=1 ;
   private int trnEnded ;
   private int edtARTSec_Enabled ;
   private int edtARTPaiCod_Visible ;
   private int edtARTPaiCod_Enabled ;
   private int edtARTNom_Enabled ;
   private int edtARTAli_Enabled ;
   private int edtARTImpFijSec_Enabled ;
   private int edtARTImpFijFecha_Enabled ;
   private int edtARTFijo_Enabled ;
   private int fRowAdded ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavComboartpaicod_Enabled ;
   private int edtavComboartpaicod_Visible ;
   private int Combo_artpaicod_Datalistupdateminimumcharacters ;
   private int Combo_artpaicod_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV23GXV1 ;
   private int GX_JID ;
   private int subGridlevel_importesfijos_Backcolor ;
   private int subGridlevel_importesfijos_Allbackcolor ;
   private int defedtARTImpFijSec_Enabled ;
   private int idxLst ;
   private int subGridlevel_importesfijos_Selectedindex ;
   private int subGridlevel_importesfijos_Selectioncolor ;
   private int subGridlevel_importesfijos_Hoveringcolor ;
   private long GRIDLEVEL_IMPORTESFIJOS_nFirstRecordOnPage ;
   private java.math.BigDecimal Z1153ARTAli ;
   private java.math.BigDecimal Z1154ARTFijo ;
   private java.math.BigDecimal A1153ARTAli ;
   private java.math.BigDecimal A1154ARTFijo ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Combo_artpaicod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtARTPaiCod_Internalname ;
   private String sGXsfl_52_idx="0001" ;
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
   private String edtARTSec_Internalname ;
   private String edtARTSec_Jsonclick ;
   private String divTablesplittedartpaicod_Internalname ;
   private String lblTextblockartpaicod_Internalname ;
   private String lblTextblockartpaicod_Jsonclick ;
   private String Combo_artpaicod_Caption ;
   private String Combo_artpaicod_Cls ;
   private String Combo_artpaicod_Datalistproc ;
   private String Combo_artpaicod_Datalistprocparametersprefix ;
   private String Combo_artpaicod_Internalname ;
   private String TempTags ;
   private String edtARTPaiCod_Jsonclick ;
   private String edtARTNom_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtARTAli_Internalname ;
   private String edtARTAli_Jsonclick ;
   private String divTableleaflevel_importesfijos_Internalname ;
   private String sMode131 ;
   private String edtARTImpFijSec_Internalname ;
   private String edtARTImpFijFecha_Internalname ;
   private String edtARTFijo_Internalname ;
   private String subGridlevel_importesfijos_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_artpaicod_Internalname ;
   private String edtavComboartpaicod_Internalname ;
   private String edtavComboartpaicod_Jsonclick ;
   private String AV22Pgmname ;
   private String Combo_artpaicod_Objectcall ;
   private String Combo_artpaicod_Class ;
   private String Combo_artpaicod_Icontype ;
   private String Combo_artpaicod_Icon ;
   private String Combo_artpaicod_Tooltip ;
   private String Combo_artpaicod_Selectedvalue_set ;
   private String Combo_artpaicod_Selectedtext_set ;
   private String Combo_artpaicod_Selectedtext_get ;
   private String Combo_artpaicod_Gamoauthtoken ;
   private String Combo_artpaicod_Ddointernalname ;
   private String Combo_artpaicod_Titlecontrolalign ;
   private String Combo_artpaicod_Dropdownoptionstype ;
   private String Combo_artpaicod_Titlecontrolidtoreplace ;
   private String Combo_artpaicod_Datalisttype ;
   private String Combo_artpaicod_Datalistfixedvalues ;
   private String Combo_artpaicod_Remoteservicesparameters ;
   private String Combo_artpaicod_Htmltemplate ;
   private String Combo_artpaicod_Multiplevaluestype ;
   private String Combo_artpaicod_Loadingdata ;
   private String Combo_artpaicod_Noresultsfound ;
   private String Combo_artpaicod_Emptyitemtext ;
   private String Combo_artpaicod_Onlyselectedvalues ;
   private String Combo_artpaicod_Selectalltext ;
   private String Combo_artpaicod_Multiplevaluesseparator ;
   private String Combo_artpaicod_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode130 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String GXt_char6 ;
   private String GXv_char9[] ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String sGXsfl_52_fel_idx="0001" ;
   private String subGridlevel_importesfijos_Class ;
   private String subGridlevel_importesfijos_Linesclass ;
   private String ROClassString ;
   private String edtARTImpFijSec_Jsonclick ;
   private String edtARTImpFijFecha_Jsonclick ;
   private String edtARTFijo_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel_importesfijos_Header ;
   private java.util.Date Z1156ARTImpFijFecha ;
   private java.util.Date A1156ARTImpFijFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_artpaicod_Emptyitem ;
   private boolean bGXsfl_52_Refreshing=false ;
   private boolean Combo_artpaicod_Enabled ;
   private boolean Combo_artpaicod_Visible ;
   private boolean Combo_artpaicod_Allowmultipleselection ;
   private boolean Combo_artpaicod_Isgriditem ;
   private boolean Combo_artpaicod_Hasdescription ;
   private boolean Combo_artpaicod_Includeonlyselectedoption ;
   private boolean Combo_artpaicod_Includeselectalloption ;
   private boolean Combo_artpaicod_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String AV19Combo_DataJson ;
   private String Z1152ARTNom ;
   private String A1152ARTNom ;
   private String A1150ARTPaiNom ;
   private String AV17ComboSelectedValue ;
   private String AV18ComboSelectedText ;
   private String Z1150ARTPaiNom ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_importesfijosContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_importesfijosRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_importesfijosColumn ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_artpaicod ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T003A6_A1150ARTPaiNom ;
   private short[] T003A7_A1151ARTSec ;
   private String[] T003A7_A1150ARTPaiNom ;
   private String[] T003A7_A1152ARTNom ;
   private java.math.BigDecimal[] T003A7_A1153ARTAli ;
   private short[] T003A7_A1149ARTPaiCod ;
   private String[] T003A8_A1150ARTPaiNom ;
   private short[] T003A9_A1151ARTSec ;
   private short[] T003A5_A1151ARTSec ;
   private String[] T003A5_A1152ARTNom ;
   private java.math.BigDecimal[] T003A5_A1153ARTAli ;
   private short[] T003A5_A1149ARTPaiCod ;
   private short[] T003A10_A1151ARTSec ;
   private short[] T003A11_A1151ARTSec ;
   private short[] T003A4_A1151ARTSec ;
   private String[] T003A4_A1152ARTNom ;
   private java.math.BigDecimal[] T003A4_A1153ARTAli ;
   private short[] T003A4_A1149ARTPaiCod ;
   private short[] T003A13_A1151ARTSec ;
   private String[] T003A16_A1150ARTPaiNom ;
   private int[] T003A17_A3CliCod ;
   private short[] T003A17_A1EmpCod ;
   private short[] T003A18_A1151ARTSec ;
   private short[] T003A19_A1151ARTSec ;
   private short[] T003A19_A1155ARTImpFijSec ;
   private java.util.Date[] T003A19_A1156ARTImpFijFecha ;
   private java.math.BigDecimal[] T003A19_A1154ARTFijo ;
   private short[] T003A20_A1151ARTSec ;
   private short[] T003A20_A1155ARTImpFijSec ;
   private short[] T003A3_A1151ARTSec ;
   private short[] T003A3_A1155ARTImpFijSec ;
   private java.util.Date[] T003A3_A1156ARTImpFijFecha ;
   private java.math.BigDecimal[] T003A3_A1154ARTFijo ;
   private short[] T003A2_A1151ARTSec ;
   private short[] T003A2_A1155ARTImpFijSec ;
   private java.util.Date[] T003A2_A1156ARTImpFijFecha ;
   private java.math.BigDecimal[] T003A2_A1154ARTFijo ;
   private short[] T003A24_A1151ARTSec ;
   private short[] T003A24_A1155ARTImpFijSec ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV15ARTPaiCod_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV16DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class art__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T003A2", "SELECT ARTSec, ARTImpFijSec, ARTImpFijFecha, ARTFijo FROM ARTImportesFijos WHERE ARTSec = ? AND ARTImpFijSec = ?  FOR UPDATE OF ARTImportesFijos NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003A3", "SELECT ARTSec, ARTImpFijSec, ARTImpFijFecha, ARTFijo FROM ARTImportesFijos WHERE ARTSec = ? AND ARTImpFijSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003A4", "SELECT ARTSec, ARTNom, ARTAli, ARTPaiCod FROM ART WHERE ARTSec = ?  FOR UPDATE OF ART NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003A5", "SELECT ARTSec, ARTNom, ARTAli, ARTPaiCod FROM ART WHERE ARTSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003A6", "SELECT PaiNom AS ARTPaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003A7", "SELECT TM1.ARTSec, T2.PaiNom AS ARTPaiNom, TM1.ARTNom, TM1.ARTAli, TM1.ARTPaiCod AS ARTPaiCod FROM (ART TM1 INNER JOIN Pais T2 ON T2.PaiCod = TM1.ARTPaiCod) WHERE TM1.ARTSec = ? ORDER BY TM1.ARTSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003A8", "SELECT PaiNom AS ARTPaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003A9", "SELECT ARTSec FROM ART WHERE ARTSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003A10", "SELECT ARTSec FROM ART WHERE ( ARTSec > ?) ORDER BY ARTSec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003A11", "SELECT ARTSec FROM ART WHERE ( ARTSec < ?) ORDER BY ARTSec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T003A12", "SAVEPOINT gxupdate;INSERT INTO ART(ARTNom, ARTAli, ARTPaiCod) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003A13", "SELECT currval('ARTSec') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T003A14", "SAVEPOINT gxupdate;UPDATE ART SET ARTNom=?, ARTAli=?, ARTPaiCod=?  WHERE ARTSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003A15", "SAVEPOINT gxupdate;DELETE FROM ART  WHERE ARTSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003A16", "SELECT PaiNom AS ARTPaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003A17", "SELECT CliCod, EmpCod FROM Empresa WHERE ARTSec = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003A18", "SELECT ARTSec FROM ART ORDER BY ARTSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003A19", "SELECT ARTSec, ARTImpFijSec, ARTImpFijFecha, ARTFijo FROM ARTImportesFijos WHERE ARTSec = ? and ARTImpFijSec = ? ORDER BY ARTSec, ARTImpFijSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003A20", "SELECT ARTSec, ARTImpFijSec FROM ARTImportesFijos WHERE ARTSec = ? AND ARTImpFijSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T003A21", "SAVEPOINT gxupdate;INSERT INTO ARTImportesFijos(ARTSec, ARTImpFijSec, ARTImpFijFecha, ARTFijo) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003A22", "SAVEPOINT gxupdate;UPDATE ARTImportesFijos SET ARTImpFijFecha=?, ARTFijo=?  WHERE ARTSec = ? AND ARTImpFijSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003A23", "SAVEPOINT gxupdate;DELETE FROM ARTImportesFijos  WHERE ARTSec = ? AND ARTImpFijSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003A24", "SELECT ARTSec, ARTImpFijSec FROM ARTImportesFijos WHERE ARTSec = ? ORDER BY ARTSec, ARTImpFijSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               return;
            case 18 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 22 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 4);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 12 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 4);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               return;
            case 20 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 21 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 22 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

