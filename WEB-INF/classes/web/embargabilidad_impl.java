package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class embargabilidad_impl extends GXDataArea
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
         A1160EmbarPaiCod = (short)(GXutil.lval( httpContext.GetPar( "EmbarPaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1160EmbarPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1160EmbarPaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_9( A1160EmbarPaiCod) ;
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
            AV7EmbargaSec = (short)(GXutil.lval( httpContext.GetPar( "EmbargaSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7EmbargaSec), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMBARGASEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7EmbargaSec), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "embargabilidad", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtEmbarPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public embargabilidad_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public embargabilidad_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( embargabilidad_impl.class ));
   }

   public embargabilidad_impl( int remoteHandle ,
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmbargaSec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmbargaSec_Internalname, httpContext.getMessage( "Embargabilidad predefinida", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmbargaSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1161EmbargaSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmbargaSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1161EmbargaSec), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1161EmbargaSec), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmbargaSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmbargaSec_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_embargabilidad.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedembarpaicod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockembarpaicod_Internalname, httpContext.getMessage( "Pai Cod", ""), "", "", lblTextblockembarpaicod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_embargabilidad.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_embarpaicod.setProperty("Caption", Combo_embarpaicod_Caption);
      ucCombo_embarpaicod.setProperty("Cls", Combo_embarpaicod_Cls);
      ucCombo_embarpaicod.setProperty("DataListProc", Combo_embarpaicod_Datalistproc);
      ucCombo_embarpaicod.setProperty("DataListProcParametersPrefix", Combo_embarpaicod_Datalistprocparametersprefix);
      ucCombo_embarpaicod.setProperty("EmptyItem", Combo_embarpaicod_Emptyitem);
      ucCombo_embarpaicod.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_embarpaicod.setProperty("DropDownOptionsData", AV15EmbarPaiCod_Data);
      ucCombo_embarpaicod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_embarpaicod_Internalname, "COMBO_EMBARPAICODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmbarPaiCod_Internalname, httpContext.getMessage( "Embar Pai Cod", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmbarPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1160EmbarPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1160EmbarPaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmbarPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmbarPaiCod_Visible, edtEmbarPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_embargabilidad.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmbargaDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmbargaDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmbargaDescrip_Internalname, A1162EmbargaDescrip, GXutil.rtrim( localUtil.format( A1162EmbargaDescrip, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmbargaDescrip_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmbargaDescrip_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_embargabilidad.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 46,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_embargabilidad.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_embargabilidad.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_embargabilidad.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_embarpaicod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboembarpaicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV20ComboEmbarPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavComboembarpaicod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV20ComboEmbarPaiCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV20ComboEmbarPaiCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboembarpaicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboembarpaicod_Visible, edtavComboembarpaicod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_embargabilidad.htm");
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
      e113B2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV16DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vEMBARPAICOD_DATA"), AV15EmbarPaiCod_Data);
            /* Read saved values. */
            Z1161EmbargaSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z1161EmbargaSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1162EmbargaDescrip = httpContext.cgiGet( "Z1162EmbargaDescrip") ;
            Z1160EmbarPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1160EmbarPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1160EmbarPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "N1160EmbarPaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7EmbargaSec = (short)(localUtil.ctol( httpContext.cgiGet( "vEMBARGASEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV13Insert_EmbarPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_EMBARPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1203EmbargaExplicacion = httpContext.cgiGet( "EMBARGAEXPLICACION") ;
            AV22Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_embarpaicod_Objectcall = httpContext.cgiGet( "COMBO_EMBARPAICOD_Objectcall") ;
            Combo_embarpaicod_Class = httpContext.cgiGet( "COMBO_EMBARPAICOD_Class") ;
            Combo_embarpaicod_Icontype = httpContext.cgiGet( "COMBO_EMBARPAICOD_Icontype") ;
            Combo_embarpaicod_Icon = httpContext.cgiGet( "COMBO_EMBARPAICOD_Icon") ;
            Combo_embarpaicod_Caption = httpContext.cgiGet( "COMBO_EMBARPAICOD_Caption") ;
            Combo_embarpaicod_Tooltip = httpContext.cgiGet( "COMBO_EMBARPAICOD_Tooltip") ;
            Combo_embarpaicod_Cls = httpContext.cgiGet( "COMBO_EMBARPAICOD_Cls") ;
            Combo_embarpaicod_Selectedvalue_set = httpContext.cgiGet( "COMBO_EMBARPAICOD_Selectedvalue_set") ;
            Combo_embarpaicod_Selectedvalue_get = httpContext.cgiGet( "COMBO_EMBARPAICOD_Selectedvalue_get") ;
            Combo_embarpaicod_Selectedtext_set = httpContext.cgiGet( "COMBO_EMBARPAICOD_Selectedtext_set") ;
            Combo_embarpaicod_Selectedtext_get = httpContext.cgiGet( "COMBO_EMBARPAICOD_Selectedtext_get") ;
            Combo_embarpaicod_Gamoauthtoken = httpContext.cgiGet( "COMBO_EMBARPAICOD_Gamoauthtoken") ;
            Combo_embarpaicod_Ddointernalname = httpContext.cgiGet( "COMBO_EMBARPAICOD_Ddointernalname") ;
            Combo_embarpaicod_Titlecontrolalign = httpContext.cgiGet( "COMBO_EMBARPAICOD_Titlecontrolalign") ;
            Combo_embarpaicod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_EMBARPAICOD_Dropdownoptionstype") ;
            Combo_embarpaicod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARPAICOD_Enabled")) ;
            Combo_embarpaicod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARPAICOD_Visible")) ;
            Combo_embarpaicod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_EMBARPAICOD_Titlecontrolidtoreplace") ;
            Combo_embarpaicod_Datalisttype = httpContext.cgiGet( "COMBO_EMBARPAICOD_Datalisttype") ;
            Combo_embarpaicod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARPAICOD_Allowmultipleselection")) ;
            Combo_embarpaicod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_EMBARPAICOD_Datalistfixedvalues") ;
            Combo_embarpaicod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARPAICOD_Isgriditem")) ;
            Combo_embarpaicod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARPAICOD_Hasdescription")) ;
            Combo_embarpaicod_Datalistproc = httpContext.cgiGet( "COMBO_EMBARPAICOD_Datalistproc") ;
            Combo_embarpaicod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_EMBARPAICOD_Datalistprocparametersprefix") ;
            Combo_embarpaicod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_EMBARPAICOD_Remoteservicesparameters") ;
            Combo_embarpaicod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_EMBARPAICOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_embarpaicod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARPAICOD_Includeonlyselectedoption")) ;
            Combo_embarpaicod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARPAICOD_Includeselectalloption")) ;
            Combo_embarpaicod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARPAICOD_Emptyitem")) ;
            Combo_embarpaicod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMBARPAICOD_Includeaddnewoption")) ;
            Combo_embarpaicod_Htmltemplate = httpContext.cgiGet( "COMBO_EMBARPAICOD_Htmltemplate") ;
            Combo_embarpaicod_Multiplevaluestype = httpContext.cgiGet( "COMBO_EMBARPAICOD_Multiplevaluestype") ;
            Combo_embarpaicod_Loadingdata = httpContext.cgiGet( "COMBO_EMBARPAICOD_Loadingdata") ;
            Combo_embarpaicod_Noresultsfound = httpContext.cgiGet( "COMBO_EMBARPAICOD_Noresultsfound") ;
            Combo_embarpaicod_Emptyitemtext = httpContext.cgiGet( "COMBO_EMBARPAICOD_Emptyitemtext") ;
            Combo_embarpaicod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_EMBARPAICOD_Onlyselectedvalues") ;
            Combo_embarpaicod_Selectalltext = httpContext.cgiGet( "COMBO_EMBARPAICOD_Selectalltext") ;
            Combo_embarpaicod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_EMBARPAICOD_Multiplevaluesseparator") ;
            Combo_embarpaicod_Addnewoptiontext = httpContext.cgiGet( "COMBO_EMBARPAICOD_Addnewoptiontext") ;
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
            A1161EmbargaSec = (short)(localUtil.ctol( httpContext.cgiGet( edtEmbargaSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1161EmbargaSec = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmbarPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmbarPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMBARPAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmbarPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1160EmbarPaiCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1160EmbarPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1160EmbarPaiCod), 4, 0));
            }
            else
            {
               A1160EmbarPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmbarPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1160EmbarPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1160EmbarPaiCod), 4, 0));
            }
            A1162EmbargaDescrip = GXutil.upper( httpContext.cgiGet( edtEmbargaDescrip_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1162EmbargaDescrip", A1162EmbargaDescrip);
            AV20ComboEmbarPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtavComboembarpaicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ComboEmbarPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboEmbarPaiCod), 4, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"embargabilidad");
            A1161EmbargaSec = (short)(localUtil.ctol( httpContext.cgiGet( edtEmbargaSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1161EmbargaSec = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
            forbiddenHiddens.add("EmbargaSec", localUtil.format( DecimalUtil.doubleToDec(A1161EmbargaSec), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A1161EmbargaSec != Z1161EmbargaSec ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("embargabilidad:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1161EmbargaSec = (short)(GXutil.lval( httpContext.GetPar( "EmbargaSec"))) ;
               n1161EmbargaSec = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
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
                  sMode132 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode132 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound132 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_3B0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "EMBARGASEC");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtEmbargaSec_Internalname ;
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
                        e113B2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e123B2 ();
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
         e123B2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll3B132( ) ;
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
         disableAttributes3B132( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboembarpaicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboembarpaicod_Enabled), 5, 0), true);
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

   public void confirm_3B0( )
   {
      beforeValidate3B132( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls3B132( ) ;
         }
         else
         {
            checkExtendedTable3B132( ) ;
            closeExtendedTableCursors3B132( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption3B0( )
   {
   }

   public void e113B2( )
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
      edtEmbarPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmbarPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmbarPaiCod_Visible), 5, 0), true);
      AV20ComboEmbarPaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboEmbarPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboEmbarPaiCod), 4, 0));
      edtavComboembarpaicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboembarpaicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboembarpaicod_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOEMBARPAICOD' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWembargabilidad_Insert", GXv_boolean5) ;
         embargabilidad_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWembargabilidad_Update", GXv_boolean5) ;
         embargabilidad_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWembargabilidad_Delete", GXv_boolean5) ;
         embargabilidad_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
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
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EmbarPaiCod") == 0 )
            {
               AV13Insert_EmbarPaiCod = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_EmbarPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_EmbarPaiCod), 4, 0));
               if ( ! (0==AV13Insert_EmbarPaiCod) )
               {
                  AV20ComboEmbarPaiCod = AV13Insert_EmbarPaiCod ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboEmbarPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboEmbarPaiCod), 4, 0));
                  Combo_embarpaicod_Selectedvalue_set = GXutil.trim( GXutil.str( AV20ComboEmbarPaiCod, 4, 0)) ;
                  ucCombo_embarpaicod.sendProperty(context, "", false, Combo_embarpaicod_Internalname, "SelectedValue_set", Combo_embarpaicod_Selectedvalue_set);
                  GXt_char6 = AV19Combo_DataJson ;
                  GXv_char7[0] = AV17ComboSelectedValue ;
                  GXv_char8[0] = AV18ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new web.embargabilidadloaddvcombo(remoteHandle, context).execute( "EmbarPaiCod", "GET", false, AV7EmbargaSec, AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  embargabilidad_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
                  embargabilidad_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
                  embargabilidad_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedValue", AV17ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedText", AV18ComboSelectedText);
                  AV19Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19Combo_DataJson", AV19Combo_DataJson);
                  Combo_embarpaicod_Selectedtext_set = AV18ComboSelectedText ;
                  ucCombo_embarpaicod.sendProperty(context, "", false, Combo_embarpaicod_Internalname, "SelectedText_set", Combo_embarpaicod_Selectedtext_set);
                  Combo_embarpaicod_Enabled = false ;
                  ucCombo_embarpaicod.sendProperty(context, "", false, Combo_embarpaicod_Internalname, "Enabled", GXutil.booltostr( Combo_embarpaicod_Enabled));
               }
            }
            AV23GXV1 = (int)(AV23GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GXV1), 8, 0));
         }
      }
   }

   public void e123B2( )
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
      /* 'LOADCOMBOEMBARPAICOD' Routine */
      returnInSub = false ;
      GXt_char6 = AV19Combo_DataJson ;
      GXv_char9[0] = AV17ComboSelectedValue ;
      GXv_char8[0] = AV18ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.embargabilidadloaddvcombo(remoteHandle, context).execute( "EmbarPaiCod", Gx_mode, false, AV7EmbargaSec, "", GXv_char9, GXv_char8, GXv_char7) ;
      embargabilidad_impl.this.AV17ComboSelectedValue = GXv_char9[0] ;
      embargabilidad_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
      embargabilidad_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedValue", AV17ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedText", AV18ComboSelectedText);
      AV19Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19Combo_DataJson", AV19Combo_DataJson);
      Combo_embarpaicod_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_embarpaicod.sendProperty(context, "", false, Combo_embarpaicod_Internalname, "SelectedValue_set", Combo_embarpaicod_Selectedvalue_set);
      Combo_embarpaicod_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_embarpaicod.sendProperty(context, "", false, Combo_embarpaicod_Internalname, "SelectedText_set", Combo_embarpaicod_Selectedtext_set);
      AV20ComboEmbarPaiCod = (short)(GXutil.lval( AV17ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboEmbarPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboEmbarPaiCod), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_embarpaicod_Enabled = false ;
         ucCombo_embarpaicod.sendProperty(context, "", false, Combo_embarpaicod_Internalname, "Enabled", GXutil.booltostr( Combo_embarpaicod_Enabled));
      }
   }

   public void zm3B132( int GX_JID )
   {
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1162EmbargaDescrip = T003B3_A1162EmbargaDescrip[0] ;
            Z1160EmbarPaiCod = T003B3_A1160EmbarPaiCod[0] ;
         }
         else
         {
            Z1162EmbargaDescrip = A1162EmbargaDescrip ;
            Z1160EmbarPaiCod = A1160EmbarPaiCod ;
         }
      }
      if ( GX_JID == -8 )
      {
         Z1161EmbargaSec = A1161EmbargaSec ;
         Z1162EmbargaDescrip = A1162EmbargaDescrip ;
         Z1203EmbargaExplicacion = A1203EmbargaExplicacion ;
         Z1160EmbarPaiCod = A1160EmbarPaiCod ;
      }
   }

   public void standaloneNotModal( )
   {
      edtEmbargaSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmbargaSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmbargaSec_Enabled), 5, 0), true);
      edtEmbargaSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmbargaSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmbargaSec_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7EmbargaSec) )
      {
         A1161EmbargaSec = AV7EmbargaSec ;
         n1161EmbargaSec = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_EmbarPaiCod) )
      {
         edtEmbarPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmbarPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmbarPaiCod_Enabled), 5, 0), true);
      }
      else
      {
         edtEmbarPaiCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmbarPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmbarPaiCod_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_EmbarPaiCod) )
      {
         A1160EmbarPaiCod = AV13Insert_EmbarPaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1160EmbarPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1160EmbarPaiCod), 4, 0));
      }
      else
      {
         A1160EmbarPaiCod = AV20ComboEmbarPaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1160EmbarPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1160EmbarPaiCod), 4, 0));
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
         AV22Pgmname = "embargabilidad" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      }
   }

   public void load3B132( )
   {
      /* Using cursor T003B5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound132 = (short)(1) ;
         A1162EmbargaDescrip = T003B5_A1162EmbargaDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1162EmbargaDescrip", A1162EmbargaDescrip);
         A1203EmbargaExplicacion = T003B5_A1203EmbargaExplicacion[0] ;
         A1160EmbarPaiCod = T003B5_A1160EmbarPaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1160EmbarPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1160EmbarPaiCod), 4, 0));
         zm3B132( -8) ;
      }
      pr_default.close(3);
      onLoadActions3B132( ) ;
   }

   public void onLoadActions3B132( )
   {
      AV22Pgmname = "embargabilidad" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
   }

   public void checkExtendedTable3B132( )
   {
      nIsDirty_132 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV22Pgmname = "embargabilidad" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      /* Using cursor T003B4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A1160EmbarPaiCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Embar Subtipo Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMBARPAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmbarPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
   }

   public void closeExtendedTableCursors3B132( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_9( short A1160EmbarPaiCod )
   {
      /* Using cursor T003B6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A1160EmbarPaiCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Embar Subtipo Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMBARPAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmbarPaiCod_Internalname ;
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

   public void getKey3B132( )
   {
      /* Using cursor T003B7 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound132 = (short)(1) ;
      }
      else
      {
         RcdFound132 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T003B3 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm3B132( 8) ;
         RcdFound132 = (short)(1) ;
         A1161EmbargaSec = T003B3_A1161EmbargaSec[0] ;
         n1161EmbargaSec = T003B3_n1161EmbargaSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
         A1162EmbargaDescrip = T003B3_A1162EmbargaDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1162EmbargaDescrip", A1162EmbargaDescrip);
         A1203EmbargaExplicacion = T003B3_A1203EmbargaExplicacion[0] ;
         A1160EmbarPaiCod = T003B3_A1160EmbarPaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1160EmbarPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1160EmbarPaiCod), 4, 0));
         Z1161EmbargaSec = A1161EmbargaSec ;
         sMode132 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load3B132( ) ;
         if ( AnyError == 1 )
         {
            RcdFound132 = (short)(0) ;
            initializeNonKey3B132( ) ;
         }
         Gx_mode = sMode132 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound132 = (short)(0) ;
         initializeNonKey3B132( ) ;
         sMode132 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode132 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey3B132( ) ;
      if ( RcdFound132 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound132 = (short)(0) ;
      /* Using cursor T003B8 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T003B8_A1161EmbargaSec[0] < A1161EmbargaSec ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T003B8_A1161EmbargaSec[0] > A1161EmbargaSec ) ) )
         {
            A1161EmbargaSec = T003B8_A1161EmbargaSec[0] ;
            n1161EmbargaSec = T003B8_n1161EmbargaSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
            RcdFound132 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound132 = (short)(0) ;
      /* Using cursor T003B9 */
      pr_default.execute(7, new Object[] {Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T003B9_A1161EmbargaSec[0] > A1161EmbargaSec ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T003B9_A1161EmbargaSec[0] < A1161EmbargaSec ) ) )
         {
            A1161EmbargaSec = T003B9_A1161EmbargaSec[0] ;
            n1161EmbargaSec = T003B9_n1161EmbargaSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
            RcdFound132 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey3B132( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtEmbarPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert3B132( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound132 == 1 )
         {
            if ( A1161EmbargaSec != Z1161EmbargaSec )
            {
               A1161EmbargaSec = Z1161EmbargaSec ;
               n1161EmbargaSec = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "EMBARGASEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmbargaSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtEmbarPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update3B132( ) ;
               GX_FocusControl = edtEmbarPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A1161EmbargaSec != Z1161EmbargaSec )
            {
               /* Insert record */
               GX_FocusControl = edtEmbarPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert3B132( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "EMBARGASEC");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtEmbargaSec_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtEmbarPaiCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert3B132( ) ;
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
      if ( A1161EmbargaSec != Z1161EmbargaSec )
      {
         A1161EmbargaSec = Z1161EmbargaSec ;
         n1161EmbargaSec = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "EMBARGASEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmbargaSec_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtEmbarPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency3B132( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T003B2 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"embargabilidad"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1162EmbargaDescrip, T003B2_A1162EmbargaDescrip[0]) != 0 ) || ( Z1160EmbarPaiCod != T003B2_A1160EmbarPaiCod[0] ) )
         {
            if ( GXutil.strcmp(Z1162EmbargaDescrip, T003B2_A1162EmbargaDescrip[0]) != 0 )
            {
               GXutil.writeLogln("embargabilidad:[seudo value changed for attri]"+"EmbargaDescrip");
               GXutil.writeLogRaw("Old: ",Z1162EmbargaDescrip);
               GXutil.writeLogRaw("Current: ",T003B2_A1162EmbargaDescrip[0]);
            }
            if ( Z1160EmbarPaiCod != T003B2_A1160EmbarPaiCod[0] )
            {
               GXutil.writeLogln("embargabilidad:[seudo value changed for attri]"+"EmbarPaiCod");
               GXutil.writeLogRaw("Old: ",Z1160EmbarPaiCod);
               GXutil.writeLogRaw("Current: ",T003B2_A1160EmbarPaiCod[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"embargabilidad"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert3B132( )
   {
      beforeValidate3B132( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3B132( ) ;
      }
      if ( AnyError == 0 )
      {
         zm3B132( 0) ;
         checkOptimisticConcurrency3B132( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3B132( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert3B132( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003B10 */
                  pr_default.execute(8, new Object[] {A1162EmbargaDescrip, A1203EmbargaExplicacion, Short.valueOf(A1160EmbarPaiCod)});
                  /* Retrieving last key number assigned */
                  /* Using cursor T003B11 */
                  pr_default.execute(9);
                  A1161EmbargaSec = T003B11_A1161EmbargaSec[0] ;
                  n1161EmbargaSec = T003B11_n1161EmbargaSec[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
                  pr_default.close(9);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("embargabilidad");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption3B0( ) ;
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
            load3B132( ) ;
         }
         endLevel3B132( ) ;
      }
      closeExtendedTableCursors3B132( ) ;
   }

   public void update3B132( )
   {
      beforeValidate3B132( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3B132( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3B132( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3B132( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate3B132( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003B12 */
                  pr_default.execute(10, new Object[] {A1162EmbargaDescrip, A1203EmbargaExplicacion, Short.valueOf(A1160EmbarPaiCod), Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("embargabilidad");
                  if ( (pr_default.getStatus(10) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"embargabilidad"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate3B132( ) ;
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
         endLevel3B132( ) ;
      }
      closeExtendedTableCursors3B132( ) ;
   }

   public void deferredUpdate3B132( )
   {
   }

   public void delete( )
   {
      beforeValidate3B132( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3B132( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls3B132( ) ;
         afterConfirm3B132( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete3B132( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T003B13 */
               pr_default.execute(11, new Object[] {Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("embargabilidad");
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
      sMode132 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel3B132( ) ;
      Gx_mode = sMode132 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls3B132( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV22Pgmname = "embargabilidad" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T003B14 */
         pr_default.execute(12, new Object[] {Boolean.valueOf(n1161EmbargaSec), Short.valueOf(A1161EmbargaSec)});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "tipo_obligacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
      }
   }

   public void endLevel3B132( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete3B132( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "embargabilidad");
         if ( AnyError == 0 )
         {
            confirmValues3B0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "embargabilidad");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart3B132( )
   {
      /* Scan By routine */
      /* Using cursor T003B15 */
      pr_default.execute(13);
      RcdFound132 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound132 = (short)(1) ;
         A1161EmbargaSec = T003B15_A1161EmbargaSec[0] ;
         n1161EmbargaSec = T003B15_n1161EmbargaSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext3B132( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound132 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound132 = (short)(1) ;
         A1161EmbargaSec = T003B15_A1161EmbargaSec[0] ;
         n1161EmbargaSec = T003B15_n1161EmbargaSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
      }
   }

   public void scanEnd3B132( )
   {
      pr_default.close(13);
   }

   public void afterConfirm3B132( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert3B132( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate3B132( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete3B132( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete3B132( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate3B132( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes3B132( )
   {
      edtEmbargaSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmbargaSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmbargaSec_Enabled), 5, 0), true);
      edtEmbarPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmbarPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmbarPaiCod_Enabled), 5, 0), true);
      edtEmbargaDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmbargaDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmbargaDescrip_Enabled), 5, 0), true);
      edtavComboembarpaicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboembarpaicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboembarpaicod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes3B132( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues3B0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.embargabilidad", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7EmbargaSec,4,0))}, new String[] {"Gx_mode","EmbargaSec"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"embargabilidad");
      forbiddenHiddens.add("EmbargaSec", localUtil.format( DecimalUtil.doubleToDec(A1161EmbargaSec), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("embargabilidad:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z1161EmbargaSec", GXutil.ltrim( localUtil.ntoc( Z1161EmbargaSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1162EmbargaDescrip", Z1162EmbargaDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1160EmbarPaiCod", GXutil.ltrim( localUtil.ntoc( Z1160EmbarPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N1160EmbarPaiCod", GXutil.ltrim( localUtil.ntoc( A1160EmbarPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vEMBARPAICOD_DATA", AV15EmbarPaiCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vEMBARPAICOD_DATA", AV15EmbarPaiCod_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMBARGASEC", GXutil.ltrim( localUtil.ntoc( AV7EmbargaSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMBARGASEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7EmbargaSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_EMBARPAICOD", GXutil.ltrim( localUtil.ntoc( AV13Insert_EmbarPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMBARGAEXPLICACION", A1203EmbargaExplicacion);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV22Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMBARPAICOD_Objectcall", GXutil.rtrim( Combo_embarpaicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMBARPAICOD_Cls", GXutil.rtrim( Combo_embarpaicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMBARPAICOD_Selectedvalue_set", GXutil.rtrim( Combo_embarpaicod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMBARPAICOD_Selectedtext_set", GXutil.rtrim( Combo_embarpaicod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMBARPAICOD_Enabled", GXutil.booltostr( Combo_embarpaicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMBARPAICOD_Datalistproc", GXutil.rtrim( Combo_embarpaicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMBARPAICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_embarpaicod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMBARPAICOD_Emptyitem", GXutil.booltostr( Combo_embarpaicod_Emptyitem));
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
      return formatLink("web.embargabilidad", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7EmbargaSec,4,0))}, new String[] {"Gx_mode","EmbargaSec"})  ;
   }

   public String getPgmname( )
   {
      return "embargabilidad" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "embargabilidad", "") ;
   }

   public void initializeNonKey3B132( )
   {
      A1160EmbarPaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1160EmbarPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1160EmbarPaiCod), 4, 0));
      A1162EmbargaDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1162EmbargaDescrip", A1162EmbargaDescrip);
      A1203EmbargaExplicacion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1203EmbargaExplicacion", A1203EmbargaExplicacion);
      Z1162EmbargaDescrip = "" ;
      Z1160EmbarPaiCod = (short)(0) ;
   }

   public void initAll3B132( )
   {
      A1161EmbargaSec = (short)(0) ;
      n1161EmbargaSec = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1161EmbargaSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1161EmbargaSec), 4, 0));
      initializeNonKey3B132( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122019565391", true, true);
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
      httpContext.AddJavascriptSource("embargabilidad.js", "?2024122019565391", false, true);
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
      edtEmbargaSec_Internalname = "EMBARGASEC" ;
      lblTextblockembarpaicod_Internalname = "TEXTBLOCKEMBARPAICOD" ;
      Combo_embarpaicod_Internalname = "COMBO_EMBARPAICOD" ;
      edtEmbarPaiCod_Internalname = "EMBARPAICOD" ;
      divTablesplittedembarpaicod_Internalname = "TABLESPLITTEDEMBARPAICOD" ;
      edtEmbargaDescrip_Internalname = "EMBARGADESCRIP" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboembarpaicod_Internalname = "vCOMBOEMBARPAICOD" ;
      divSectionattribute_embarpaicod_Internalname = "SECTIONATTRIBUTE_EMBARPAICOD" ;
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
      Form.setCaption( httpContext.getMessage( "embargabilidad", "") );
      edtavComboembarpaicod_Jsonclick = "" ;
      edtavComboembarpaicod_Enabled = 0 ;
      edtavComboembarpaicod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtEmbargaDescrip_Jsonclick = "" ;
      edtEmbargaDescrip_Enabled = 1 ;
      edtEmbarPaiCod_Jsonclick = "" ;
      edtEmbarPaiCod_Enabled = 1 ;
      edtEmbarPaiCod_Visible = 1 ;
      Combo_embarpaicod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_embarpaicod_Datalistprocparametersprefix = " \"ComboName\": \"EmbarPaiCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"EmbargaSec\": 0" ;
      Combo_embarpaicod_Datalistproc = "embargabilidadLoadDVCombo" ;
      Combo_embarpaicod_Cls = "ExtendedCombo Attribute" ;
      Combo_embarpaicod_Caption = "" ;
      Combo_embarpaicod_Enabled = GXutil.toBoolean( -1) ;
      edtEmbargaSec_Jsonclick = "" ;
      edtEmbargaSec_Enabled = 0 ;
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

   public void valid_Embarpaicod( )
   {
      /* Using cursor T003B16 */
      pr_default.execute(14, new Object[] {Short.valueOf(A1160EmbarPaiCod)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Embar Subtipo Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMBARPAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmbarPaiCod_Internalname ;
      }
      pr_default.close(14);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7EmbargaSec',fld:'vEMBARGASEC',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7EmbargaSec',fld:'vEMBARGASEC',pic:'ZZZ9',hsh:true},{av:'A1161EmbargaSec',fld:'EMBARGASEC',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e123B2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_EMBARGASEC","{handler:'valid_Embargasec',iparms:[]");
      setEventMetadata("VALID_EMBARGASEC",",oparms:[]}");
      setEventMetadata("VALID_EMBARPAICOD","{handler:'valid_Embarpaicod',iparms:[{av:'A1160EmbarPaiCod',fld:'EMBARPAICOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_EMBARPAICOD",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOEMBARPAICOD","{handler:'validv_Comboembarpaicod',iparms:[]");
      setEventMetadata("VALIDV_COMBOEMBARPAICOD",",oparms:[]}");
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
      Z1162EmbargaDescrip = "" ;
      Combo_embarpaicod_Selectedvalue_get = "" ;
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
      lblTextblockembarpaicod_Jsonclick = "" ;
      ucCombo_embarpaicod = new com.genexus.webpanels.GXUserControl();
      AV16DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV15EmbarPaiCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A1162EmbargaDescrip = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A1203EmbargaExplicacion = "" ;
      AV22Pgmname = "" ;
      Combo_embarpaicod_Objectcall = "" ;
      Combo_embarpaicod_Class = "" ;
      Combo_embarpaicod_Icontype = "" ;
      Combo_embarpaicod_Icon = "" ;
      Combo_embarpaicod_Tooltip = "" ;
      Combo_embarpaicod_Selectedvalue_set = "" ;
      Combo_embarpaicod_Selectedtext_set = "" ;
      Combo_embarpaicod_Selectedtext_get = "" ;
      Combo_embarpaicod_Gamoauthtoken = "" ;
      Combo_embarpaicod_Ddointernalname = "" ;
      Combo_embarpaicod_Titlecontrolalign = "" ;
      Combo_embarpaicod_Dropdownoptionstype = "" ;
      Combo_embarpaicod_Titlecontrolidtoreplace = "" ;
      Combo_embarpaicod_Datalisttype = "" ;
      Combo_embarpaicod_Datalistfixedvalues = "" ;
      Combo_embarpaicod_Remoteservicesparameters = "" ;
      Combo_embarpaicod_Htmltemplate = "" ;
      Combo_embarpaicod_Multiplevaluestype = "" ;
      Combo_embarpaicod_Loadingdata = "" ;
      Combo_embarpaicod_Noresultsfound = "" ;
      Combo_embarpaicod_Emptyitemtext = "" ;
      Combo_embarpaicod_Onlyselectedvalues = "" ;
      Combo_embarpaicod_Selectalltext = "" ;
      Combo_embarpaicod_Multiplevaluesseparator = "" ;
      Combo_embarpaicod_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode132 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
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
      Z1203EmbargaExplicacion = "" ;
      T003B5_A1161EmbargaSec = new short[1] ;
      T003B5_n1161EmbargaSec = new boolean[] {false} ;
      T003B5_A1162EmbargaDescrip = new String[] {""} ;
      T003B5_A1203EmbargaExplicacion = new String[] {""} ;
      T003B5_A1160EmbarPaiCod = new short[1] ;
      T003B4_A1160EmbarPaiCod = new short[1] ;
      T003B6_A1160EmbarPaiCod = new short[1] ;
      T003B7_A1161EmbargaSec = new short[1] ;
      T003B7_n1161EmbargaSec = new boolean[] {false} ;
      T003B3_A1161EmbargaSec = new short[1] ;
      T003B3_n1161EmbargaSec = new boolean[] {false} ;
      T003B3_A1162EmbargaDescrip = new String[] {""} ;
      T003B3_A1203EmbargaExplicacion = new String[] {""} ;
      T003B3_A1160EmbarPaiCod = new short[1] ;
      T003B8_A1161EmbargaSec = new short[1] ;
      T003B8_n1161EmbargaSec = new boolean[] {false} ;
      T003B9_A1161EmbargaSec = new short[1] ;
      T003B9_n1161EmbargaSec = new boolean[] {false} ;
      T003B2_A1161EmbargaSec = new short[1] ;
      T003B2_n1161EmbargaSec = new boolean[] {false} ;
      T003B2_A1162EmbargaDescrip = new String[] {""} ;
      T003B2_A1203EmbargaExplicacion = new String[] {""} ;
      T003B2_A1160EmbarPaiCod = new short[1] ;
      T003B11_A1161EmbargaSec = new short[1] ;
      T003B11_n1161EmbargaSec = new boolean[] {false} ;
      T003B14_A1163TipoOblSec = new short[1] ;
      T003B15_A1161EmbargaSec = new short[1] ;
      T003B15_n1161EmbargaSec = new boolean[] {false} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T003B16_A1160EmbarPaiCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.embargabilidad__default(),
         new Object[] {
             new Object[] {
            T003B2_A1161EmbargaSec, T003B2_A1162EmbargaDescrip, T003B2_A1203EmbargaExplicacion, T003B2_A1160EmbarPaiCod
            }
            , new Object[] {
            T003B3_A1161EmbargaSec, T003B3_A1162EmbargaDescrip, T003B3_A1203EmbargaExplicacion, T003B3_A1160EmbarPaiCod
            }
            , new Object[] {
            T003B4_A1160EmbarPaiCod
            }
            , new Object[] {
            T003B5_A1161EmbargaSec, T003B5_A1162EmbargaDescrip, T003B5_A1203EmbargaExplicacion, T003B5_A1160EmbarPaiCod
            }
            , new Object[] {
            T003B6_A1160EmbarPaiCod
            }
            , new Object[] {
            T003B7_A1161EmbargaSec
            }
            , new Object[] {
            T003B8_A1161EmbargaSec
            }
            , new Object[] {
            T003B9_A1161EmbargaSec
            }
            , new Object[] {
            }
            , new Object[] {
            T003B11_A1161EmbargaSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T003B14_A1163TipoOblSec
            }
            , new Object[] {
            T003B15_A1161EmbargaSec
            }
            , new Object[] {
            T003B16_A1160EmbarPaiCod
            }
         }
      );
      AV22Pgmname = "embargabilidad" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7EmbargaSec ;
   private short Z1161EmbargaSec ;
   private short Z1160EmbarPaiCod ;
   private short N1160EmbarPaiCod ;
   private short A1160EmbarPaiCod ;
   private short AV7EmbargaSec ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1161EmbargaSec ;
   private short AV20ComboEmbarPaiCod ;
   private short AV13Insert_EmbarPaiCod ;
   private short RcdFound132 ;
   private short nIsDirty_132 ;
   private int trnEnded ;
   private int edtEmbargaSec_Enabled ;
   private int edtEmbarPaiCod_Visible ;
   private int edtEmbarPaiCod_Enabled ;
   private int edtEmbargaDescrip_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavComboembarpaicod_Enabled ;
   private int edtavComboembarpaicod_Visible ;
   private int Combo_embarpaicod_Datalistupdateminimumcharacters ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV23GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Combo_embarpaicod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtEmbarPaiCod_Internalname ;
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
   private String edtEmbargaSec_Internalname ;
   private String edtEmbargaSec_Jsonclick ;
   private String divTablesplittedembarpaicod_Internalname ;
   private String lblTextblockembarpaicod_Internalname ;
   private String lblTextblockembarpaicod_Jsonclick ;
   private String Combo_embarpaicod_Caption ;
   private String Combo_embarpaicod_Cls ;
   private String Combo_embarpaicod_Datalistproc ;
   private String Combo_embarpaicod_Datalistprocparametersprefix ;
   private String Combo_embarpaicod_Internalname ;
   private String TempTags ;
   private String edtEmbarPaiCod_Jsonclick ;
   private String edtEmbargaDescrip_Internalname ;
   private String edtEmbargaDescrip_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_embarpaicod_Internalname ;
   private String edtavComboembarpaicod_Internalname ;
   private String edtavComboembarpaicod_Jsonclick ;
   private String AV22Pgmname ;
   private String Combo_embarpaicod_Objectcall ;
   private String Combo_embarpaicod_Class ;
   private String Combo_embarpaicod_Icontype ;
   private String Combo_embarpaicod_Icon ;
   private String Combo_embarpaicod_Tooltip ;
   private String Combo_embarpaicod_Selectedvalue_set ;
   private String Combo_embarpaicod_Selectedtext_set ;
   private String Combo_embarpaicod_Selectedtext_get ;
   private String Combo_embarpaicod_Gamoauthtoken ;
   private String Combo_embarpaicod_Ddointernalname ;
   private String Combo_embarpaicod_Titlecontrolalign ;
   private String Combo_embarpaicod_Dropdownoptionstype ;
   private String Combo_embarpaicod_Titlecontrolidtoreplace ;
   private String Combo_embarpaicod_Datalisttype ;
   private String Combo_embarpaicod_Datalistfixedvalues ;
   private String Combo_embarpaicod_Remoteservicesparameters ;
   private String Combo_embarpaicod_Htmltemplate ;
   private String Combo_embarpaicod_Multiplevaluestype ;
   private String Combo_embarpaicod_Loadingdata ;
   private String Combo_embarpaicod_Noresultsfound ;
   private String Combo_embarpaicod_Emptyitemtext ;
   private String Combo_embarpaicod_Onlyselectedvalues ;
   private String Combo_embarpaicod_Selectalltext ;
   private String Combo_embarpaicod_Multiplevaluesseparator ;
   private String Combo_embarpaicod_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode132 ;
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
   private boolean Combo_embarpaicod_Emptyitem ;
   private boolean Combo_embarpaicod_Enabled ;
   private boolean Combo_embarpaicod_Visible ;
   private boolean Combo_embarpaicod_Allowmultipleselection ;
   private boolean Combo_embarpaicod_Isgriditem ;
   private boolean Combo_embarpaicod_Hasdescription ;
   private boolean Combo_embarpaicod_Includeonlyselectedoption ;
   private boolean Combo_embarpaicod_Includeselectalloption ;
   private boolean Combo_embarpaicod_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n1161EmbargaSec ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String A1203EmbargaExplicacion ;
   private String AV19Combo_DataJson ;
   private String Z1203EmbargaExplicacion ;
   private String Z1162EmbargaDescrip ;
   private String A1162EmbargaDescrip ;
   private String AV17ComboSelectedValue ;
   private String AV18ComboSelectedText ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_embarpaicod ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private short[] T003B5_A1161EmbargaSec ;
   private boolean[] T003B5_n1161EmbargaSec ;
   private String[] T003B5_A1162EmbargaDescrip ;
   private String[] T003B5_A1203EmbargaExplicacion ;
   private short[] T003B5_A1160EmbarPaiCod ;
   private short[] T003B4_A1160EmbarPaiCod ;
   private short[] T003B6_A1160EmbarPaiCod ;
   private short[] T003B7_A1161EmbargaSec ;
   private boolean[] T003B7_n1161EmbargaSec ;
   private short[] T003B3_A1161EmbargaSec ;
   private boolean[] T003B3_n1161EmbargaSec ;
   private String[] T003B3_A1162EmbargaDescrip ;
   private String[] T003B3_A1203EmbargaExplicacion ;
   private short[] T003B3_A1160EmbarPaiCod ;
   private short[] T003B8_A1161EmbargaSec ;
   private boolean[] T003B8_n1161EmbargaSec ;
   private short[] T003B9_A1161EmbargaSec ;
   private boolean[] T003B9_n1161EmbargaSec ;
   private short[] T003B2_A1161EmbargaSec ;
   private boolean[] T003B2_n1161EmbargaSec ;
   private String[] T003B2_A1162EmbargaDescrip ;
   private String[] T003B2_A1203EmbargaExplicacion ;
   private short[] T003B2_A1160EmbarPaiCod ;
   private short[] T003B11_A1161EmbargaSec ;
   private boolean[] T003B11_n1161EmbargaSec ;
   private short[] T003B14_A1163TipoOblSec ;
   private short[] T003B15_A1161EmbargaSec ;
   private boolean[] T003B15_n1161EmbargaSec ;
   private short[] T003B16_A1160EmbarPaiCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV15EmbarPaiCod_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV16DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class embargabilidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T003B2", "SELECT EmbargaSec, EmbargaDescrip, EmbargaExplicacion, EmbarPaiCod FROM embargabilidad WHERE EmbargaSec = ?  FOR UPDATE OF embargabilidad NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003B3", "SELECT EmbargaSec, EmbargaDescrip, EmbargaExplicacion, EmbarPaiCod FROM embargabilidad WHERE EmbargaSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003B4", "SELECT PaiCod AS EmbarPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003B5", "SELECT TM1.EmbargaSec, TM1.EmbargaDescrip, TM1.EmbargaExplicacion, TM1.EmbarPaiCod AS EmbarPaiCod FROM embargabilidad TM1 WHERE TM1.EmbargaSec = ? ORDER BY TM1.EmbargaSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003B6", "SELECT PaiCod AS EmbarPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003B7", "SELECT EmbargaSec FROM embargabilidad WHERE EmbargaSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003B8", "SELECT EmbargaSec FROM embargabilidad WHERE ( EmbargaSec > ?) ORDER BY EmbargaSec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003B9", "SELECT EmbargaSec FROM embargabilidad WHERE ( EmbargaSec < ?) ORDER BY EmbargaSec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T003B10", "SAVEPOINT gxupdate;INSERT INTO embargabilidad(EmbargaDescrip, EmbargaExplicacion, EmbarPaiCod) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003B11", "SELECT currval('EmbargaSec') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T003B12", "SAVEPOINT gxupdate;UPDATE embargabilidad SET EmbargaDescrip=?, EmbargaExplicacion=?, EmbarPaiCod=?  WHERE EmbargaSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003B13", "SAVEPOINT gxupdate;DELETE FROM embargabilidad  WHERE EmbargaSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003B14", "SELECT TipoOblSec FROM tipo_obligacion WHERE EmbargaSec = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003B15", "SELECT EmbargaSec FROM embargabilidad ORDER BY EmbargaSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003B16", "SELECT PaiCod AS EmbarPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 7 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 30, false);
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 30, false);
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(4, ((Number) parms[4]).shortValue());
               }
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

