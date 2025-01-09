package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class paisvacaciones_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_8") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_8( A46PaiCod) ;
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
            AV8PaiVacDesAnt = (byte)(GXutil.lval( httpContext.GetPar( "PaiVacDesAnt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8PaiVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8PaiVacDesAnt), 2, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAIVACDESANT", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8PaiVacDesAnt), "Z9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Pais Vacaciones", ""), (short)(0)) ;
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

   public paisvacaciones_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public paisvacaciones_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paisvacaciones_impl.class ));
   }

   public paisvacaciones_impl( int remoteHandle ,
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedpaicod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockpaicod_Internalname, httpContext.getMessage( "Pais", ""), "", "", lblTextblockpaicod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_PaisVacaciones.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiCod_Visible, edtPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_PaisVacaciones.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiVacDesAnt_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiVacDesAnt_Internalname, httpContext.getMessage( "Años de antiguedad desde", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiVacDesAnt_Internalname, GXutil.ltrim( localUtil.ntoc( A1766PaiVacDesAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1766PaiVacDesAnt), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiVacDesAnt_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiVacDesAnt_Enabled, 1, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisVacaciones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiVacHasAnt_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiVacHasAnt_Internalname, httpContext.getMessage( "Años de antiguedad hasta", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiVacHasAnt_Internalname, GXutil.ltrim( localUtil.ntoc( A1767PaiVacHasAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiVacHasAnt_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1767PaiVacHasAnt), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1767PaiVacHasAnt), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiVacHasAnt_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiVacHasAnt_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisVacaciones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiVacDias_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiVacDias_Internalname, httpContext.getMessage( "Días de vacaciiones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiVacDias_Internalname, GXutil.ltrim( localUtil.ntoc( A1768PaiVacDias, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiVacDias_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1768PaiVacDias), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1768PaiVacDias), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiVacDias_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiVacDias_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisVacaciones.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PaisVacaciones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PaisVacaciones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PaisVacaciones.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombopaicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV19ComboPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCombopaicod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV19ComboPaiCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV19ComboPaiCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombopaicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombopaicod_Visible, edtavCombopaicod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PaisVacaciones.htm");
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
      e115D2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV15DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPAICOD_DATA"), AV14PaiCod_Data);
            /* Read saved values. */
            Z46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1766PaiVacDesAnt = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1766PaiVacDesAnt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1767PaiVacHasAnt = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1767PaiVacHasAnt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1768PaiVacDias = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1768PaiVacDias"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8PaiVacDesAnt = (byte)(localUtil.ctol( httpContext.cgiGet( "vPAIVACDESANT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV20Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiVacDesAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiVacDesAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAIVACDESANT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiVacDesAnt_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1766PaiVacDesAnt = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1766PaiVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1766PaiVacDesAnt), 2, 0));
            }
            else
            {
               A1766PaiVacDesAnt = (byte)(localUtil.ctol( httpContext.cgiGet( edtPaiVacDesAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1766PaiVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1766PaiVacDesAnt), 2, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiVacHasAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiVacHasAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAIVACHASANT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiVacHasAnt_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1767PaiVacHasAnt = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1767PaiVacHasAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1767PaiVacHasAnt), 2, 0));
            }
            else
            {
               A1767PaiVacHasAnt = (byte)(localUtil.ctol( httpContext.cgiGet( edtPaiVacHasAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1767PaiVacHasAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1767PaiVacHasAnt), 2, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiVacDias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiVacDias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAIVACDIAS");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiVacDias_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1768PaiVacDias = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1768PaiVacDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1768PaiVacDias), 2, 0));
            }
            else
            {
               A1768PaiVacDias = (byte)(localUtil.ctol( httpContext.cgiGet( edtPaiVacDias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1768PaiVacDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1768PaiVacDias), 2, 0));
            }
            AV19ComboPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombopaicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19ComboPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboPaiCod), 4, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"PaisVacaciones");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A46PaiCod != Z46PaiCod ) || ( A1766PaiVacDesAnt != Z1766PaiVacDesAnt ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("paisvacaciones:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1766PaiVacDesAnt = (byte)(GXutil.lval( httpContext.GetPar( "PaiVacDesAnt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1766PaiVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1766PaiVacDesAnt), 2, 0));
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
                  sMode240 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode240 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound240 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_5D0( ) ;
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
                        e115D2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e125D2 ();
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
         e125D2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll5D240( ) ;
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
         disableAttributes5D240( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopaicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopaicod_Enabled), 5, 0), true);
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

   public void confirm_5D0( )
   {
      beforeValidate5D240( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls5D240( ) ;
         }
         else
         {
            checkExtendedTable5D240( ) ;
            closeExtendedTableCursors5D240( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption5D0( )
   {
   }

   public void e115D2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV15DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV15DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisVacaciones_Insert", GXv_boolean5) ;
         paisvacaciones_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisVacaciones_Update", GXv_boolean5) ;
         paisvacaciones_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisVacaciones_Delete", GXv_boolean5) ;
         paisvacaciones_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV20Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
   }

   public void e125D2( )
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
      /* 'LOADCOMBOPAICOD' Routine */
      returnInSub = false ;
      GXt_char6 = AV18Combo_DataJson ;
      GXv_char7[0] = AV16ComboSelectedValue ;
      GXv_char8[0] = AV17ComboSelectedText ;
      GXv_char9[0] = GXt_char6 ;
      new web.paisvacacionesloaddvcombo(remoteHandle, context).execute( "PaiCod", Gx_mode, false, AV7PaiCod, AV8PaiVacDesAnt, "", GXv_char7, GXv_char8, GXv_char9) ;
      paisvacaciones_impl.this.AV16ComboSelectedValue = GXv_char7[0] ;
      paisvacaciones_impl.this.AV17ComboSelectedText = GXv_char8[0] ;
      paisvacaciones_impl.this.GXt_char6 = GXv_char9[0] ;
      AV18Combo_DataJson = GXt_char6 ;
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

   public void zm5D240( int GX_JID )
   {
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1767PaiVacHasAnt = T005D3_A1767PaiVacHasAnt[0] ;
            Z1768PaiVacDias = T005D3_A1768PaiVacDias[0] ;
         }
         else
         {
            Z1767PaiVacHasAnt = A1767PaiVacHasAnt ;
            Z1768PaiVacDias = A1768PaiVacDias ;
         }
      }
      if ( GX_JID == -7 )
      {
         Z1766PaiVacDesAnt = A1766PaiVacDesAnt ;
         Z1767PaiVacHasAnt = A1767PaiVacHasAnt ;
         Z1768PaiVacDias = A1768PaiVacDias ;
         Z46PaiCod = A46PaiCod ;
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
      if ( ! (0==AV8PaiVacDesAnt) )
      {
         A1766PaiVacDesAnt = AV8PaiVacDesAnt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1766PaiVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1766PaiVacDesAnt), 2, 0));
      }
      if ( ! (0==AV8PaiVacDesAnt) )
      {
         edtPaiVacDesAnt_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiVacDesAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiVacDesAnt_Enabled), 5, 0), true);
      }
      else
      {
         edtPaiVacDesAnt_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiVacDesAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiVacDesAnt_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8PaiVacDesAnt) )
      {
         edtPaiVacDesAnt_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiVacDesAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiVacDesAnt_Enabled), 5, 0), true);
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
         AV20Pgmname = "PaisVacaciones" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      }
   }

   public void load5D240( )
   {
      /* Using cursor T005D5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1766PaiVacDesAnt)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound240 = (short)(1) ;
         A1767PaiVacHasAnt = T005D5_A1767PaiVacHasAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1767PaiVacHasAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1767PaiVacHasAnt), 2, 0));
         A1768PaiVacDias = T005D5_A1768PaiVacDias[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1768PaiVacDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1768PaiVacDias), 2, 0));
         zm5D240( -7) ;
      }
      pr_default.close(3);
      onLoadActions5D240( ) ;
   }

   public void onLoadActions5D240( )
   {
      AV20Pgmname = "PaisVacaciones" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
   }

   public void checkExtendedTable5D240( )
   {
      nIsDirty_240 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV20Pgmname = "PaisVacaciones" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      /* Using cursor T005D4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
   }

   public void closeExtendedTableCursors5D240( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_8( short A46PaiCod )
   {
      /* Using cursor T005D6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
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

   public void getKey5D240( )
   {
      /* Using cursor T005D7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1766PaiVacDesAnt)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound240 = (short)(1) ;
      }
      else
      {
         RcdFound240 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T005D3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1766PaiVacDesAnt)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm5D240( 7) ;
         RcdFound240 = (short)(1) ;
         A1766PaiVacDesAnt = T005D3_A1766PaiVacDesAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1766PaiVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1766PaiVacDesAnt), 2, 0));
         A1767PaiVacHasAnt = T005D3_A1767PaiVacHasAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1767PaiVacHasAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1767PaiVacHasAnt), 2, 0));
         A1768PaiVacDias = T005D3_A1768PaiVacDias[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1768PaiVacDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1768PaiVacDias), 2, 0));
         A46PaiCod = T005D3_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         Z46PaiCod = A46PaiCod ;
         Z1766PaiVacDesAnt = A1766PaiVacDesAnt ;
         sMode240 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load5D240( ) ;
         if ( AnyError == 1 )
         {
            RcdFound240 = (short)(0) ;
            initializeNonKey5D240( ) ;
         }
         Gx_mode = sMode240 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound240 = (short)(0) ;
         initializeNonKey5D240( ) ;
         sMode240 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode240 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey5D240( ) ;
      if ( RcdFound240 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound240 = (short)(0) ;
      /* Using cursor T005D8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), Byte.valueOf(A1766PaiVacDesAnt)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T005D8_A46PaiCod[0] < A46PaiCod ) || ( T005D8_A46PaiCod[0] == A46PaiCod ) && ( T005D8_A1766PaiVacDesAnt[0] < A1766PaiVacDesAnt ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T005D8_A46PaiCod[0] > A46PaiCod ) || ( T005D8_A46PaiCod[0] == A46PaiCod ) && ( T005D8_A1766PaiVacDesAnt[0] > A1766PaiVacDesAnt ) ) )
         {
            A46PaiCod = T005D8_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A1766PaiVacDesAnt = T005D8_A1766PaiVacDesAnt[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1766PaiVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1766PaiVacDesAnt), 2, 0));
            RcdFound240 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound240 = (short)(0) ;
      /* Using cursor T005D9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), Byte.valueOf(A1766PaiVacDesAnt)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T005D9_A46PaiCod[0] > A46PaiCod ) || ( T005D9_A46PaiCod[0] == A46PaiCod ) && ( T005D9_A1766PaiVacDesAnt[0] > A1766PaiVacDesAnt ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T005D9_A46PaiCod[0] < A46PaiCod ) || ( T005D9_A46PaiCod[0] == A46PaiCod ) && ( T005D9_A1766PaiVacDesAnt[0] < A1766PaiVacDesAnt ) ) )
         {
            A46PaiCod = T005D9_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A1766PaiVacDesAnt = T005D9_A1766PaiVacDesAnt[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1766PaiVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1766PaiVacDesAnt), 2, 0));
            RcdFound240 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey5D240( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert5D240( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound240 == 1 )
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( A1766PaiVacDesAnt != Z1766PaiVacDesAnt ) )
            {
               A46PaiCod = Z46PaiCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A1766PaiVacDesAnt = Z1766PaiVacDesAnt ;
               httpContext.ajax_rsp_assign_attri("", false, "A1766PaiVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1766PaiVacDesAnt), 2, 0));
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
               update5D240( ) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( A1766PaiVacDesAnt != Z1766PaiVacDesAnt ) )
            {
               /* Insert record */
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert5D240( ) ;
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
                  insert5D240( ) ;
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
      if ( ( A46PaiCod != Z46PaiCod ) || ( A1766PaiVacDesAnt != Z1766PaiVacDesAnt ) )
      {
         A46PaiCod = Z46PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1766PaiVacDesAnt = Z1766PaiVacDesAnt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1766PaiVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1766PaiVacDesAnt), 2, 0));
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

   public void checkOptimisticConcurrency5D240( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T005D2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1766PaiVacDesAnt)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"PaisVacaciones"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z1767PaiVacHasAnt != T005D2_A1767PaiVacHasAnt[0] ) || ( Z1768PaiVacDias != T005D2_A1768PaiVacDias[0] ) )
         {
            if ( Z1767PaiVacHasAnt != T005D2_A1767PaiVacHasAnt[0] )
            {
               GXutil.writeLogln("paisvacaciones:[seudo value changed for attri]"+"PaiVacHasAnt");
               GXutil.writeLogRaw("Old: ",Z1767PaiVacHasAnt);
               GXutil.writeLogRaw("Current: ",T005D2_A1767PaiVacHasAnt[0]);
            }
            if ( Z1768PaiVacDias != T005D2_A1768PaiVacDias[0] )
            {
               GXutil.writeLogln("paisvacaciones:[seudo value changed for attri]"+"PaiVacDias");
               GXutil.writeLogRaw("Old: ",Z1768PaiVacDias);
               GXutil.writeLogRaw("Current: ",T005D2_A1768PaiVacDias[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"PaisVacaciones"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert5D240( )
   {
      beforeValidate5D240( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5D240( ) ;
      }
      if ( AnyError == 0 )
      {
         zm5D240( 0) ;
         checkOptimisticConcurrency5D240( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5D240( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert5D240( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005D10 */
                  pr_default.execute(8, new Object[] {Byte.valueOf(A1766PaiVacDesAnt), Byte.valueOf(A1767PaiVacHasAnt), Byte.valueOf(A1768PaiVacDias), Short.valueOf(A46PaiCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisVacaciones");
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
                        resetCaption5D0( ) ;
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
            load5D240( ) ;
         }
         endLevel5D240( ) ;
      }
      closeExtendedTableCursors5D240( ) ;
   }

   public void update5D240( )
   {
      beforeValidate5D240( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5D240( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5D240( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5D240( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate5D240( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005D11 */
                  pr_default.execute(9, new Object[] {Byte.valueOf(A1767PaiVacHasAnt), Byte.valueOf(A1768PaiVacDias), Short.valueOf(A46PaiCod), Byte.valueOf(A1766PaiVacDesAnt)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisVacaciones");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"PaisVacaciones"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate5D240( ) ;
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
         endLevel5D240( ) ;
      }
      closeExtendedTableCursors5D240( ) ;
   }

   public void deferredUpdate5D240( )
   {
   }

   public void delete( )
   {
      beforeValidate5D240( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5D240( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls5D240( ) ;
         afterConfirm5D240( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete5D240( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005D12 */
               pr_default.execute(10, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1766PaiVacDesAnt)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisVacaciones");
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
      sMode240 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel5D240( ) ;
      Gx_mode = sMode240 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls5D240( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV20Pgmname = "PaisVacaciones" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      }
   }

   public void endLevel5D240( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete5D240( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "paisvacaciones");
         if ( AnyError == 0 )
         {
            confirmValues5D0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "paisvacaciones");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart5D240( )
   {
      /* Scan By routine */
      /* Using cursor T005D13 */
      pr_default.execute(11);
      RcdFound240 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound240 = (short)(1) ;
         A46PaiCod = T005D13_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1766PaiVacDesAnt = T005D13_A1766PaiVacDesAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1766PaiVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1766PaiVacDesAnt), 2, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext5D240( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound240 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound240 = (short)(1) ;
         A46PaiCod = T005D13_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1766PaiVacDesAnt = T005D13_A1766PaiVacDesAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1766PaiVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1766PaiVacDesAnt), 2, 0));
      }
   }

   public void scanEnd5D240( )
   {
      pr_default.close(11);
   }

   public void afterConfirm5D240( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert5D240( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate5D240( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete5D240( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete5D240( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate5D240( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes5D240( )
   {
      edtPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      edtPaiVacDesAnt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiVacDesAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiVacDesAnt_Enabled), 5, 0), true);
      edtPaiVacHasAnt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiVacHasAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiVacHasAnt_Enabled), 5, 0), true);
      edtPaiVacDias_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiVacDias_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiVacDias_Enabled), 5, 0), true);
      edtavCombopaicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopaicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopaicod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes5D240( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues5D0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.paisvacaciones", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8PaiVacDesAnt,2,0))}, new String[] {"Gx_mode","PaiCod","PaiVacDesAnt"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"PaisVacaciones");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("paisvacaciones:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z46PaiCod", GXutil.ltrim( localUtil.ntoc( Z46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1766PaiVacDesAnt", GXutil.ltrim( localUtil.ntoc( Z1766PaiVacDesAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1767PaiVacHasAnt", GXutil.ltrim( localUtil.ntoc( Z1767PaiVacHasAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1768PaiVacDias", GXutil.ltrim( localUtil.ntoc( Z1768PaiVacDias, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV7PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAIVACDESANT", GXutil.ltrim( localUtil.ntoc( AV8PaiVacDesAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAIVACDESANT", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8PaiVacDesAnt), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV20Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Objectcall", GXutil.rtrim( Combo_paicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Cls", GXutil.rtrim( Combo_paicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Selectedvalue_set", GXutil.rtrim( Combo_paicod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Selectedtext_set", GXutil.rtrim( Combo_paicod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Enabled", GXutil.booltostr( Combo_paicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Datalistproc", GXutil.rtrim( Combo_paicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_paicod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Emptyitem", GXutil.booltostr( Combo_paicod_Emptyitem));
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
      return formatLink("web.paisvacaciones", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8PaiVacDesAnt,2,0))}, new String[] {"Gx_mode","PaiCod","PaiVacDesAnt"})  ;
   }

   public String getPgmname( )
   {
      return "PaisVacaciones" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Pais Vacaciones", "") ;
   }

   public void initializeNonKey5D240( )
   {
      A1767PaiVacHasAnt = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1767PaiVacHasAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1767PaiVacHasAnt), 2, 0));
      A1768PaiVacDias = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1768PaiVacDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1768PaiVacDias), 2, 0));
      Z1767PaiVacHasAnt = (byte)(0) ;
      Z1768PaiVacDias = (byte)(0) ;
   }

   public void initAll5D240( )
   {
      A46PaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A1766PaiVacDesAnt = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1766PaiVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1766PaiVacDesAnt), 2, 0));
      initializeNonKey5D240( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020345494", true, true);
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
      httpContext.AddJavascriptSource("paisvacaciones.js", "?2024122020345494", false, true);
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
      lblTextblockpaicod_Internalname = "TEXTBLOCKPAICOD" ;
      Combo_paicod_Internalname = "COMBO_PAICOD" ;
      edtPaiCod_Internalname = "PAICOD" ;
      divTablesplittedpaicod_Internalname = "TABLESPLITTEDPAICOD" ;
      edtPaiVacDesAnt_Internalname = "PAIVACDESANT" ;
      edtPaiVacHasAnt_Internalname = "PAIVACHASANT" ;
      edtPaiVacDias_Internalname = "PAIVACDIAS" ;
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
      Form.setCaption( httpContext.getMessage( "Pais Vacaciones", "") );
      edtavCombopaicod_Jsonclick = "" ;
      edtavCombopaicod_Enabled = 0 ;
      edtavCombopaicod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtPaiVacDias_Jsonclick = "" ;
      edtPaiVacDias_Enabled = 1 ;
      edtPaiVacHasAnt_Jsonclick = "" ;
      edtPaiVacHasAnt_Enabled = 1 ;
      edtPaiVacDesAnt_Jsonclick = "" ;
      edtPaiVacDesAnt_Enabled = 1 ;
      edtPaiCod_Jsonclick = "" ;
      edtPaiCod_Enabled = 1 ;
      edtPaiCod_Visible = 1 ;
      Combo_paicod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_paicod_Datalistprocparametersprefix = " \"ComboName\": \"PaiCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PaiCod\": 0, \"PaiVacDesAnt\": 0" ;
      Combo_paicod_Datalistproc = "PaisVacacionesLoadDVCombo" ;
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

   public void valid_Paicod( )
   {
      /* Using cursor T005D14 */
      pr_default.execute(12, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
      }
      pr_default.close(12);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV8PaiVacDesAnt',fld:'vPAIVACDESANT',pic:'Z9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV8PaiVacDesAnt',fld:'vPAIVACDESANT',pic:'Z9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e125D2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_PAICOD","{handler:'valid_Paicod',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_PAICOD",",oparms:[]}");
      setEventMetadata("VALID_PAIVACDESANT","{handler:'valid_Paivacdesant',iparms:[]");
      setEventMetadata("VALID_PAIVACDESANT",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOPAICOD","{handler:'validv_Combopaicod',iparms:[]");
      setEventMetadata("VALIDV_COMBOPAICOD",",oparms:[]}");
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
      pr_default.close(12);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Combo_paicod_Selectedvalue_get = "" ;
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
      lblTextblockpaicod_Jsonclick = "" ;
      ucCombo_paicod = new com.genexus.webpanels.GXUserControl();
      AV15DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV14PaiCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV20Pgmname = "" ;
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
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode240 = "" ;
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
      AV18Combo_DataJson = "" ;
      GXt_char6 = "" ;
      AV16ComboSelectedValue = "" ;
      GXv_char7 = new String[1] ;
      AV17ComboSelectedText = "" ;
      GXv_char8 = new String[1] ;
      GXv_char9 = new String[1] ;
      T005D5_A1766PaiVacDesAnt = new byte[1] ;
      T005D5_A1767PaiVacHasAnt = new byte[1] ;
      T005D5_A1768PaiVacDias = new byte[1] ;
      T005D5_A46PaiCod = new short[1] ;
      T005D4_A46PaiCod = new short[1] ;
      T005D6_A46PaiCod = new short[1] ;
      T005D7_A46PaiCod = new short[1] ;
      T005D7_A1766PaiVacDesAnt = new byte[1] ;
      T005D3_A1766PaiVacDesAnt = new byte[1] ;
      T005D3_A1767PaiVacHasAnt = new byte[1] ;
      T005D3_A1768PaiVacDias = new byte[1] ;
      T005D3_A46PaiCod = new short[1] ;
      T005D8_A46PaiCod = new short[1] ;
      T005D8_A1766PaiVacDesAnt = new byte[1] ;
      T005D9_A46PaiCod = new short[1] ;
      T005D9_A1766PaiVacDesAnt = new byte[1] ;
      T005D2_A1766PaiVacDesAnt = new byte[1] ;
      T005D2_A1767PaiVacHasAnt = new byte[1] ;
      T005D2_A1768PaiVacDias = new byte[1] ;
      T005D2_A46PaiCod = new short[1] ;
      T005D13_A46PaiCod = new short[1] ;
      T005D13_A1766PaiVacDesAnt = new byte[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T005D14_A46PaiCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paisvacaciones__default(),
         new Object[] {
             new Object[] {
            T005D2_A1766PaiVacDesAnt, T005D2_A1767PaiVacHasAnt, T005D2_A1768PaiVacDias, T005D2_A46PaiCod
            }
            , new Object[] {
            T005D3_A1766PaiVacDesAnt, T005D3_A1767PaiVacHasAnt, T005D3_A1768PaiVacDias, T005D3_A46PaiCod
            }
            , new Object[] {
            T005D4_A46PaiCod
            }
            , new Object[] {
            T005D5_A1766PaiVacDesAnt, T005D5_A1767PaiVacHasAnt, T005D5_A1768PaiVacDias, T005D5_A46PaiCod
            }
            , new Object[] {
            T005D6_A46PaiCod
            }
            , new Object[] {
            T005D7_A46PaiCod, T005D7_A1766PaiVacDesAnt
            }
            , new Object[] {
            T005D8_A46PaiCod, T005D8_A1766PaiVacDesAnt
            }
            , new Object[] {
            T005D9_A46PaiCod, T005D9_A1766PaiVacDesAnt
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005D13_A46PaiCod, T005D13_A1766PaiVacDesAnt
            }
            , new Object[] {
            T005D14_A46PaiCod
            }
         }
      );
      AV20Pgmname = "PaisVacaciones" ;
   }

   private byte wcpOAV8PaiVacDesAnt ;
   private byte Z1766PaiVacDesAnt ;
   private byte Z1767PaiVacHasAnt ;
   private byte Z1768PaiVacDias ;
   private byte GxWebError ;
   private byte AV8PaiVacDesAnt ;
   private byte nKeyPressed ;
   private byte A1766PaiVacDesAnt ;
   private byte A1767PaiVacHasAnt ;
   private byte A1768PaiVacDias ;
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
   private short RcdFound240 ;
   private short nIsDirty_240 ;
   private int trnEnded ;
   private int edtPaiCod_Visible ;
   private int edtPaiCod_Enabled ;
   private int edtPaiVacDesAnt_Enabled ;
   private int edtPaiVacHasAnt_Enabled ;
   private int edtPaiVacDias_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombopaicod_Enabled ;
   private int edtavCombopaicod_Visible ;
   private int Combo_paicod_Datalistupdateminimumcharacters ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Combo_paicod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
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
   private String edtPaiVacDesAnt_Internalname ;
   private String edtPaiVacDesAnt_Jsonclick ;
   private String edtPaiVacHasAnt_Internalname ;
   private String edtPaiVacHasAnt_Jsonclick ;
   private String edtPaiVacDias_Internalname ;
   private String edtPaiVacDias_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
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
   private String AV20Pgmname ;
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
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode240 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String GXv_char8[] ;
   private String GXv_char9[] ;
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
   private boolean Combo_paicod_Emptyitem ;
   private boolean Combo_paicod_Enabled ;
   private boolean Combo_paicod_Visible ;
   private boolean Combo_paicod_Allowmultipleselection ;
   private boolean Combo_paicod_Isgriditem ;
   private boolean Combo_paicod_Hasdescription ;
   private boolean Combo_paicod_Includeonlyselectedoption ;
   private boolean Combo_paicod_Includeselectalloption ;
   private boolean Combo_paicod_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String AV18Combo_DataJson ;
   private String AV16ComboSelectedValue ;
   private String AV17ComboSelectedText ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_paicod ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private byte[] T005D5_A1766PaiVacDesAnt ;
   private byte[] T005D5_A1767PaiVacHasAnt ;
   private byte[] T005D5_A1768PaiVacDias ;
   private short[] T005D5_A46PaiCod ;
   private short[] T005D4_A46PaiCod ;
   private short[] T005D6_A46PaiCod ;
   private short[] T005D7_A46PaiCod ;
   private byte[] T005D7_A1766PaiVacDesAnt ;
   private byte[] T005D3_A1766PaiVacDesAnt ;
   private byte[] T005D3_A1767PaiVacHasAnt ;
   private byte[] T005D3_A1768PaiVacDias ;
   private short[] T005D3_A46PaiCod ;
   private short[] T005D8_A46PaiCod ;
   private byte[] T005D8_A1766PaiVacDesAnt ;
   private short[] T005D9_A46PaiCod ;
   private byte[] T005D9_A1766PaiVacDesAnt ;
   private byte[] T005D2_A1766PaiVacDesAnt ;
   private byte[] T005D2_A1767PaiVacHasAnt ;
   private byte[] T005D2_A1768PaiVacDias ;
   private short[] T005D2_A46PaiCod ;
   private short[] T005D13_A46PaiCod ;
   private byte[] T005D13_A1766PaiVacDesAnt ;
   private short[] T005D14_A46PaiCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14PaiCod_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV15DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class paisvacaciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T005D2", "SELECT PaiVacDesAnt, PaiVacHasAnt, PaiVacDias, PaiCod FROM PaisVacaciones WHERE PaiCod = ? AND PaiVacDesAnt = ?  FOR UPDATE OF PaisVacaciones NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005D3", "SELECT PaiVacDesAnt, PaiVacHasAnt, PaiVacDias, PaiCod FROM PaisVacaciones WHERE PaiCod = ? AND PaiVacDesAnt = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005D4", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005D5", "SELECT TM1.PaiVacDesAnt, TM1.PaiVacHasAnt, TM1.PaiVacDias, TM1.PaiCod FROM PaisVacaciones TM1 WHERE TM1.PaiCod = ? and TM1.PaiVacDesAnt = ? ORDER BY TM1.PaiCod, TM1.PaiVacDesAnt ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005D6", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005D7", "SELECT PaiCod, PaiVacDesAnt FROM PaisVacaciones WHERE PaiCod = ? AND PaiVacDesAnt = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005D8", "SELECT PaiCod, PaiVacDesAnt FROM PaisVacaciones WHERE ( PaiCod > ? or PaiCod = ? and PaiVacDesAnt > ?) ORDER BY PaiCod, PaiVacDesAnt  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005D9", "SELECT PaiCod, PaiVacDesAnt FROM PaisVacaciones WHERE ( PaiCod < ? or PaiCod = ? and PaiVacDesAnt < ?) ORDER BY PaiCod DESC, PaiVacDesAnt DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005D10", "SAVEPOINT gxupdate;INSERT INTO PaisVacaciones(PaiVacDesAnt, PaiVacHasAnt, PaiVacDias, PaiCod) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005D11", "SAVEPOINT gxupdate;UPDATE PaisVacaciones SET PaiVacHasAnt=?, PaiVacDias=?  WHERE PaiCod = ? AND PaiVacDesAnt = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005D12", "SAVEPOINT gxupdate;DELETE FROM PaisVacaciones  WHERE PaiCod = ? AND PaiVacDesAnt = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005D13", "SELECT PaiCod, PaiVacDesAnt FROM PaisVacaciones ORDER BY PaiCod, PaiVacDesAnt ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005D14", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 1 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               return;
            case 12 :
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
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               return;
            case 8 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 9 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

