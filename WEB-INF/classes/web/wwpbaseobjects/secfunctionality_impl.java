package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secfunctionality_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_12") == 0 )
      {
         A63SecParentFunctionalityId = GXutil.lval( httpContext.GetPar( "SecParentFunctionalityId")) ;
         n63SecParentFunctionalityId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A63SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63SecParentFunctionalityId), 10, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_12( A63SecParentFunctionalityId) ;
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
            AV7SecFunctionalityId = GXutil.lval( httpContext.GetPar( "SecFunctionalityId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7SecFunctionalityId), 10, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECFUNCTIONALITYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7SecFunctionalityId), "ZZZZZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Functionality", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtSecParentFunctionalityId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public secfunctionality_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secfunctionality_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secfunctionality_impl.class ));
   }

   public secfunctionality_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbSecFunctionalityType = new HTMLChoice();
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
      if ( cmbSecFunctionalityType.getItemCount() > 0 )
      {
         A351SecFunctionalityType = (byte)(GXutil.lval( cmbSecFunctionalityType.getValidValue(GXutil.trim( GXutil.str( A351SecFunctionalityType, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A351SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(A351SecFunctionalityType), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbSecFunctionalityType.setValue( GXutil.trim( GXutil.str( A351SecFunctionalityType, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbSecFunctionalityType.getInternalname(), "Values", cmbSecFunctionalityType.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainTransaction", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Functionality", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecFunctionality.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "CellMarginTop10", "left", "top", "", "", "div");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecFunctionalityId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSecFunctionalityId_Internalname, httpContext.getMessage( "Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtSecFunctionalityId_Internalname, GXutil.ltrim( localUtil.ntoc( A62SecFunctionalityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtSecFunctionalityId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A62SecFunctionalityId), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A62SecFunctionalityId), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecFunctionalityId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecFunctionalityId_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\SecFunctionality.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecFunctionalityKey_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSecFunctionalityKey_Internalname, httpContext.getMessage( "Key", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtSecFunctionalityKey_Internalname, A64SecFunctionalityKey, GXutil.rtrim( localUtil.format( A64SecFunctionalityKey, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecFunctionalityKey_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecFunctionalityKey_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecFunctionality.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbSecFunctionalityType.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbSecFunctionalityType.getInternalname(), httpContext.getMessage( "Type", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbSecFunctionalityType, cmbSecFunctionalityType.getInternalname(), GXutil.trim( GXutil.str( A351SecFunctionalityType, 2, 0)), 1, cmbSecFunctionalityType.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbSecFunctionalityType.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_WWPBaseObjects\\SecFunctionality.htm");
      cmbSecFunctionalityType.setValue( GXutil.trim( GXutil.str( A351SecFunctionalityType, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbSecFunctionalityType.getInternalname(), "Values", cmbSecFunctionalityType.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecFunctionality.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecFunctionality.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecFunctionality.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSecParentFunctionalityId_Internalname, GXutil.ltrim( localUtil.ntoc( A63SecParentFunctionalityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A63SecParentFunctionalityId), "ZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecParentFunctionalityId_Jsonclick, 0, "Attribute", "", "", "", "", edtSecParentFunctionalityId_Visible, edtSecParentFunctionalityId_Enabled, 1, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\SecFunctionality.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSecFunctionalityActive_Internalname, GXutil.booltostr( A349SecFunctionalityActive), GXutil.booltostr( A349SecFunctionalityActive), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecFunctionalityActive_Jsonclick, 0, "Attribute", "", "", "", "", edtSecFunctionalityActive_Visible, edtSecFunctionalityActive_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\SecFunctionality.htm");
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
      e111I2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z62SecFunctionalityId = localUtil.ctol( httpContext.cgiGet( "Z62SecFunctionalityId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z64SecFunctionalityKey = httpContext.cgiGet( "Z64SecFunctionalityKey") ;
            Z350SecFunctionalityDescription = httpContext.cgiGet( "Z350SecFunctionalityDescription") ;
            Z351SecFunctionalityType = (byte)(localUtil.ctol( httpContext.cgiGet( "Z351SecFunctionalityType"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z349SecFunctionalityActive = GXutil.strtobool( httpContext.cgiGet( "Z349SecFunctionalityActive")) ;
            Z63SecParentFunctionalityId = localUtil.ctol( httpContext.cgiGet( "Z63SecParentFunctionalityId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            n63SecParentFunctionalityId = ((0==A63SecParentFunctionalityId) ? true : false) ;
            A350SecFunctionalityDescription = httpContext.cgiGet( "Z350SecFunctionalityDescription") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N63SecParentFunctionalityId = localUtil.ctol( httpContext.cgiGet( "N63SecParentFunctionalityId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            n63SecParentFunctionalityId = ((0==A63SecParentFunctionalityId) ? true : false) ;
            AV7SecFunctionalityId = localUtil.ctol( httpContext.cgiGet( "vSECFUNCTIONALITYID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV12Insert_SecParentFunctionalityId = localUtil.ctol( httpContext.cgiGet( "vINSERT_SECPARENTFUNCTIONALITYID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A350SecFunctionalityDescription = httpContext.cgiGet( "SECFUNCTIONALITYDESCRIPTION") ;
            A353SecParentFunctionalityDescript = httpContext.cgiGet( "SECPARENTFUNCTIONALITYDESCRIPT") ;
            AV19Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            A62SecFunctionalityId = localUtil.ctol( httpContext.cgiGet( edtSecFunctionalityId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A62SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SecFunctionalityId), 10, 0));
            A64SecFunctionalityKey = httpContext.cgiGet( edtSecFunctionalityKey_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A64SecFunctionalityKey", A64SecFunctionalityKey);
            cmbSecFunctionalityType.setValue( httpContext.cgiGet( cmbSecFunctionalityType.getInternalname()) );
            A351SecFunctionalityType = (byte)(GXutil.lval( httpContext.cgiGet( cmbSecFunctionalityType.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A351SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(A351SecFunctionalityType), 2, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSecParentFunctionalityId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSecParentFunctionalityId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SECPARENTFUNCTIONALITYID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSecParentFunctionalityId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A63SecParentFunctionalityId = 0 ;
               n63SecParentFunctionalityId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A63SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63SecParentFunctionalityId), 10, 0));
            }
            else
            {
               A63SecParentFunctionalityId = localUtil.ctol( httpContext.cgiGet( edtSecParentFunctionalityId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               n63SecParentFunctionalityId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A63SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63SecParentFunctionalityId), 10, 0));
            }
            n63SecParentFunctionalityId = ((0==A63SecParentFunctionalityId) ? true : false) ;
            A349SecFunctionalityActive = GXutil.strtobool( httpContext.cgiGet( edtSecFunctionalityActive_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A349SecFunctionalityActive", A349SecFunctionalityActive);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"SecFunctionality");
            A62SecFunctionalityId = localUtil.ctol( httpContext.cgiGet( edtSecFunctionalityId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A62SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SecFunctionalityId), 10, 0));
            forbiddenHiddens.add("SecFunctionalityId", localUtil.format( DecimalUtil.doubleToDec(A62SecFunctionalityId), "ZZZZZZZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            A64SecFunctionalityKey = httpContext.cgiGet( edtSecFunctionalityKey_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A64SecFunctionalityKey", A64SecFunctionalityKey);
            forbiddenHiddens.add("SecFunctionalityKey", GXutil.rtrim( localUtil.format( A64SecFunctionalityKey, "")));
            forbiddenHiddens.add("SecFunctionalityDescription", GXutil.rtrim( localUtil.format( A350SecFunctionalityDescription, "")));
            A351SecFunctionalityType = (byte)(GXutil.lval( httpContext.cgiGet( cmbSecFunctionalityType.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A351SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(A351SecFunctionalityType), 2, 0));
            forbiddenHiddens.add("SecFunctionalityType", localUtil.format( DecimalUtil.doubleToDec(A351SecFunctionalityType), "Z9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A62SecFunctionalityId != Z62SecFunctionalityId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("wwpbaseobjects\\secfunctionality:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A62SecFunctionalityId = GXutil.lval( httpContext.GetPar( "SecFunctionalityId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A62SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SecFunctionalityId), 10, 0));
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
                  sMode50 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode50 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound50 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_1I0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "SECFUNCTIONALITYID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSecFunctionalityId_Internalname ;
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
                        e111I2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e121I2 ();
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
         e121I2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1I50( ) ;
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
         disableAttributes1I50( ) ;
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

   public void confirm_1I0( )
   {
      beforeValidate1I50( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1I50( ) ;
         }
         else
         {
            checkExtendedTable1I50( ) ;
            closeExtendedTableCursors1I50( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption1I0( )
   {
   }

   public void e111I2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV18WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV18WWPContext = GXv_SdtWWPContext1[0] ;
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV19Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV20GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20GXV1), 8, 0));
         while ( AV20GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV13TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV20GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SecParentFunctionalityId") == 0 )
            {
               AV12Insert_SecParentFunctionalityId = GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_SecParentFunctionalityId), 10, 0));
            }
            AV20GXV1 = (int)(AV20GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20GXV1), 8, 0));
         }
      }
      edtSecParentFunctionalityId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecParentFunctionalityId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecParentFunctionalityId_Visible), 5, 0), true);
      edtSecFunctionalityActive_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityActive_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityActive_Visible), 5, 0), true);
   }

   public void e121I2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("web.wwpbaseobjects.secfunctionalityww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm1I50( int GX_JID )
   {
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z64SecFunctionalityKey = T001I3_A64SecFunctionalityKey[0] ;
            Z350SecFunctionalityDescription = T001I3_A350SecFunctionalityDescription[0] ;
            Z351SecFunctionalityType = T001I3_A351SecFunctionalityType[0] ;
            Z349SecFunctionalityActive = T001I3_A349SecFunctionalityActive[0] ;
            Z63SecParentFunctionalityId = T001I3_A63SecParentFunctionalityId[0] ;
         }
         else
         {
            Z64SecFunctionalityKey = A64SecFunctionalityKey ;
            Z350SecFunctionalityDescription = A350SecFunctionalityDescription ;
            Z351SecFunctionalityType = A351SecFunctionalityType ;
            Z349SecFunctionalityActive = A349SecFunctionalityActive ;
            Z63SecParentFunctionalityId = A63SecParentFunctionalityId ;
         }
      }
      if ( GX_JID == -10 )
      {
         Z62SecFunctionalityId = A62SecFunctionalityId ;
         Z64SecFunctionalityKey = A64SecFunctionalityKey ;
         Z350SecFunctionalityDescription = A350SecFunctionalityDescription ;
         Z351SecFunctionalityType = A351SecFunctionalityType ;
         Z349SecFunctionalityActive = A349SecFunctionalityActive ;
         Z63SecParentFunctionalityId = A63SecParentFunctionalityId ;
         Z353SecParentFunctionalityDescript = A353SecParentFunctionalityDescript ;
      }
   }

   public void standaloneNotModal( )
   {
      edtSecFunctionalityId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityId_Enabled), 5, 0), true);
      edtSecFunctionalityKey_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityKey_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityKey_Enabled), 5, 0), true);
      cmbSecFunctionalityType.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbSecFunctionalityType.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSecFunctionalityType.getEnabled(), 5, 0), true);
      AV19Pgmname = "WWPBaseObjects.SecFunctionality" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19Pgmname", AV19Pgmname);
      edtSecFunctionalityId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityId_Enabled), 5, 0), true);
      edtSecFunctionalityKey_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityKey_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityKey_Enabled), 5, 0), true);
      cmbSecFunctionalityType.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbSecFunctionalityType.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSecFunctionalityType.getEnabled(), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7SecFunctionalityId) )
      {
         A62SecFunctionalityId = AV7SecFunctionalityId ;
         httpContext.ajax_rsp_assign_attri("", false, "A62SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SecFunctionalityId), 10, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_SecParentFunctionalityId) )
      {
         edtSecParentFunctionalityId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecParentFunctionalityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecParentFunctionalityId_Enabled), 5, 0), true);
      }
      else
      {
         edtSecParentFunctionalityId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecParentFunctionalityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecParentFunctionalityId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_SecParentFunctionalityId) )
      {
         A63SecParentFunctionalityId = AV12Insert_SecParentFunctionalityId ;
         n63SecParentFunctionalityId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A63SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63SecParentFunctionalityId), 10, 0));
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
         /* Using cursor T001I4 */
         pr_default.execute(2, new Object[] {Boolean.valueOf(n63SecParentFunctionalityId), Long.valueOf(A63SecParentFunctionalityId)});
         A353SecParentFunctionalityDescript = T001I4_A353SecParentFunctionalityDescript[0] ;
         pr_default.close(2);
      }
   }

   public void load1I50( )
   {
      /* Using cursor T001I5 */
      pr_default.execute(3, new Object[] {Long.valueOf(A62SecFunctionalityId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound50 = (short)(1) ;
         A64SecFunctionalityKey = T001I5_A64SecFunctionalityKey[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A64SecFunctionalityKey", A64SecFunctionalityKey);
         A350SecFunctionalityDescription = T001I5_A350SecFunctionalityDescription[0] ;
         A351SecFunctionalityType = T001I5_A351SecFunctionalityType[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A351SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(A351SecFunctionalityType), 2, 0));
         A353SecParentFunctionalityDescript = T001I5_A353SecParentFunctionalityDescript[0] ;
         A349SecFunctionalityActive = T001I5_A349SecFunctionalityActive[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A349SecFunctionalityActive", A349SecFunctionalityActive);
         A63SecParentFunctionalityId = T001I5_A63SecParentFunctionalityId[0] ;
         n63SecParentFunctionalityId = T001I5_n63SecParentFunctionalityId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A63SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63SecParentFunctionalityId), 10, 0));
         zm1I50( -10) ;
      }
      pr_default.close(3);
      onLoadActions1I50( ) ;
   }

   public void onLoadActions1I50( )
   {
   }

   public void checkExtendedTable1I50( )
   {
      nIsDirty_50 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T001I6 */
      pr_default.execute(4, new Object[] {A64SecFunctionalityKey, Long.valueOf(A62SecFunctionalityId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Functionality Key", "")}), 1, "SECFUNCTIONALITYKEY");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecFunctionalityKey_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      /* Using cursor T001I4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n63SecParentFunctionalityId), Long.valueOf(A63SecParentFunctionalityId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A63SecParentFunctionalityId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Sec Functionality Functionality", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SECPARENTFUNCTIONALITYID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtSecParentFunctionalityId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A353SecParentFunctionalityDescript = T001I4_A353SecParentFunctionalityDescript[0] ;
      pr_default.close(2);
   }

   public void closeExtendedTableCursors1I50( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_12( long A63SecParentFunctionalityId )
   {
      /* Using cursor T001I7 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n63SecParentFunctionalityId), Long.valueOf(A63SecParentFunctionalityId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         if ( ! ( (0==A63SecParentFunctionalityId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Sec Functionality Functionality", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SECPARENTFUNCTIONALITYID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtSecParentFunctionalityId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A353SecParentFunctionalityDescript = T001I7_A353SecParentFunctionalityDescript[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A353SecParentFunctionalityDescript)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void getKey1I50( )
   {
      /* Using cursor T001I8 */
      pr_default.execute(6, new Object[] {Long.valueOf(A62SecFunctionalityId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound50 = (short)(1) ;
      }
      else
      {
         RcdFound50 = (short)(0) ;
      }
      pr_default.close(6);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T001I3 */
      pr_default.execute(1, new Object[] {Long.valueOf(A62SecFunctionalityId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1I50( 10) ;
         RcdFound50 = (short)(1) ;
         A62SecFunctionalityId = T001I3_A62SecFunctionalityId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A62SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SecFunctionalityId), 10, 0));
         A64SecFunctionalityKey = T001I3_A64SecFunctionalityKey[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A64SecFunctionalityKey", A64SecFunctionalityKey);
         A350SecFunctionalityDescription = T001I3_A350SecFunctionalityDescription[0] ;
         A351SecFunctionalityType = T001I3_A351SecFunctionalityType[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A351SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(A351SecFunctionalityType), 2, 0));
         A349SecFunctionalityActive = T001I3_A349SecFunctionalityActive[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A349SecFunctionalityActive", A349SecFunctionalityActive);
         A63SecParentFunctionalityId = T001I3_A63SecParentFunctionalityId[0] ;
         n63SecParentFunctionalityId = T001I3_n63SecParentFunctionalityId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A63SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63SecParentFunctionalityId), 10, 0));
         Z62SecFunctionalityId = A62SecFunctionalityId ;
         sMode50 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1I50( ) ;
         if ( AnyError == 1 )
         {
            RcdFound50 = (short)(0) ;
            initializeNonKey1I50( ) ;
         }
         Gx_mode = sMode50 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound50 = (short)(0) ;
         initializeNonKey1I50( ) ;
         sMode50 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode50 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1I50( ) ;
      if ( RcdFound50 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound50 = (short)(0) ;
      /* Using cursor T001I9 */
      pr_default.execute(7, new Object[] {Long.valueOf(A62SecFunctionalityId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T001I9_A62SecFunctionalityId[0] < A62SecFunctionalityId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T001I9_A62SecFunctionalityId[0] > A62SecFunctionalityId ) ) )
         {
            A62SecFunctionalityId = T001I9_A62SecFunctionalityId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A62SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SecFunctionalityId), 10, 0));
            RcdFound50 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void move_previous( )
   {
      RcdFound50 = (short)(0) ;
      /* Using cursor T001I10 */
      pr_default.execute(8, new Object[] {Long.valueOf(A62SecFunctionalityId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T001I10_A62SecFunctionalityId[0] > A62SecFunctionalityId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T001I10_A62SecFunctionalityId[0] < A62SecFunctionalityId ) ) )
         {
            A62SecFunctionalityId = T001I10_A62SecFunctionalityId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A62SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SecFunctionalityId), 10, 0));
            RcdFound50 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1I50( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtSecParentFunctionalityId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1I50( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound50 == 1 )
         {
            if ( A62SecFunctionalityId != Z62SecFunctionalityId )
            {
               A62SecFunctionalityId = Z62SecFunctionalityId ;
               httpContext.ajax_rsp_assign_attri("", false, "A62SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SecFunctionalityId), 10, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "SECFUNCTIONALITYID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSecFunctionalityId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtSecParentFunctionalityId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1I50( ) ;
               GX_FocusControl = edtSecParentFunctionalityId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A62SecFunctionalityId != Z62SecFunctionalityId )
            {
               /* Insert record */
               GX_FocusControl = edtSecParentFunctionalityId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1I50( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "SECFUNCTIONALITYID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtSecFunctionalityId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtSecParentFunctionalityId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1I50( ) ;
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
      if ( A62SecFunctionalityId != Z62SecFunctionalityId )
      {
         A62SecFunctionalityId = Z62SecFunctionalityId ;
         httpContext.ajax_rsp_assign_attri("", false, "A62SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SecFunctionalityId), 10, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "SECFUNCTIONALITYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecFunctionalityId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtSecParentFunctionalityId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1I50( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T001I2 */
         pr_default.execute(0, new Object[] {Long.valueOf(A62SecFunctionalityId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SecFunctionality"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z64SecFunctionalityKey, T001I2_A64SecFunctionalityKey[0]) != 0 ) || ( GXutil.strcmp(Z350SecFunctionalityDescription, T001I2_A350SecFunctionalityDescription[0]) != 0 ) || ( Z351SecFunctionalityType != T001I2_A351SecFunctionalityType[0] ) || ( Z349SecFunctionalityActive != T001I2_A349SecFunctionalityActive[0] ) || ( Z63SecParentFunctionalityId != T001I2_A63SecParentFunctionalityId[0] ) )
         {
            if ( GXutil.strcmp(Z64SecFunctionalityKey, T001I2_A64SecFunctionalityKey[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.secfunctionality:[seudo value changed for attri]"+"SecFunctionalityKey");
               GXutil.writeLogRaw("Old: ",Z64SecFunctionalityKey);
               GXutil.writeLogRaw("Current: ",T001I2_A64SecFunctionalityKey[0]);
            }
            if ( GXutil.strcmp(Z350SecFunctionalityDescription, T001I2_A350SecFunctionalityDescription[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.secfunctionality:[seudo value changed for attri]"+"SecFunctionalityDescription");
               GXutil.writeLogRaw("Old: ",Z350SecFunctionalityDescription);
               GXutil.writeLogRaw("Current: ",T001I2_A350SecFunctionalityDescription[0]);
            }
            if ( Z351SecFunctionalityType != T001I2_A351SecFunctionalityType[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.secfunctionality:[seudo value changed for attri]"+"SecFunctionalityType");
               GXutil.writeLogRaw("Old: ",Z351SecFunctionalityType);
               GXutil.writeLogRaw("Current: ",T001I2_A351SecFunctionalityType[0]);
            }
            if ( Z349SecFunctionalityActive != T001I2_A349SecFunctionalityActive[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.secfunctionality:[seudo value changed for attri]"+"SecFunctionalityActive");
               GXutil.writeLogRaw("Old: ",Z349SecFunctionalityActive);
               GXutil.writeLogRaw("Current: ",T001I2_A349SecFunctionalityActive[0]);
            }
            if ( Z63SecParentFunctionalityId != T001I2_A63SecParentFunctionalityId[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.secfunctionality:[seudo value changed for attri]"+"SecParentFunctionalityId");
               GXutil.writeLogRaw("Old: ",Z63SecParentFunctionalityId);
               GXutil.writeLogRaw("Current: ",T001I2_A63SecParentFunctionalityId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"SecFunctionality"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1I50( )
   {
      beforeValidate1I50( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1I50( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1I50( 0) ;
         checkOptimisticConcurrency1I50( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1I50( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1I50( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001I11 */
                  pr_default.execute(9, new Object[] {A64SecFunctionalityKey, A350SecFunctionalityDescription, Byte.valueOf(A351SecFunctionalityType), Boolean.valueOf(A349SecFunctionalityActive), Boolean.valueOf(n63SecParentFunctionalityId), Long.valueOf(A63SecParentFunctionalityId)});
                  /* Retrieving last key number assigned */
                  /* Using cursor T001I12 */
                  pr_default.execute(10);
                  A62SecFunctionalityId = T001I12_A62SecFunctionalityId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A62SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SecFunctionalityId), 10, 0));
                  pr_default.close(10);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionality");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption1I0( ) ;
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
            load1I50( ) ;
         }
         endLevel1I50( ) ;
      }
      closeExtendedTableCursors1I50( ) ;
   }

   public void update1I50( )
   {
      beforeValidate1I50( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1I50( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1I50( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1I50( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1I50( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001I13 */
                  pr_default.execute(11, new Object[] {A64SecFunctionalityKey, A350SecFunctionalityDescription, Byte.valueOf(A351SecFunctionalityType), Boolean.valueOf(A349SecFunctionalityActive), Boolean.valueOf(n63SecParentFunctionalityId), Long.valueOf(A63SecParentFunctionalityId), Long.valueOf(A62SecFunctionalityId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionality");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SecFunctionality"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1I50( ) ;
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
         endLevel1I50( ) ;
      }
      closeExtendedTableCursors1I50( ) ;
   }

   public void deferredUpdate1I50( )
   {
   }

   public void delete( )
   {
      beforeValidate1I50( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1I50( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1I50( ) ;
         afterConfirm1I50( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1I50( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001I14 */
               pr_default.execute(12, new Object[] {Long.valueOf(A62SecFunctionalityId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionality");
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
      sMode50 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1I50( ) ;
      Gx_mode = sMode50 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1I50( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T001I15 */
         pr_default.execute(13, new Object[] {Boolean.valueOf(n63SecParentFunctionalityId), Long.valueOf(A63SecParentFunctionalityId)});
         A353SecParentFunctionalityDescript = T001I15_A353SecParentFunctionalityDescript[0] ;
         pr_default.close(13);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001I16 */
         pr_default.execute(14, new Object[] {Long.valueOf(A62SecFunctionalityId)});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Functionality", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
         /* Using cursor T001I17 */
         pr_default.execute(15, new Object[] {Long.valueOf(A62SecFunctionalityId)});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Functionalities", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor T001I18 */
         pr_default.execute(16, new Object[] {Long.valueOf(A62SecFunctionalityId)});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Functionality Role", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
      }
   }

   public void endLevel1I50( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1I50( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secfunctionality");
         if ( AnyError == 0 )
         {
            confirmValues1I0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secfunctionality");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1I50( )
   {
      /* Scan By routine */
      /* Using cursor T001I19 */
      pr_default.execute(17);
      RcdFound50 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound50 = (short)(1) ;
         A62SecFunctionalityId = T001I19_A62SecFunctionalityId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A62SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SecFunctionalityId), 10, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1I50( )
   {
      /* Scan next routine */
      pr_default.readNext(17);
      RcdFound50 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound50 = (short)(1) ;
         A62SecFunctionalityId = T001I19_A62SecFunctionalityId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A62SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SecFunctionalityId), 10, 0));
      }
   }

   public void scanEnd1I50( )
   {
      pr_default.close(17);
   }

   public void afterConfirm1I50( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1I50( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1I50( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1I50( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1I50( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1I50( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1I50( )
   {
      edtSecFunctionalityId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityId_Enabled), 5, 0), true);
      edtSecFunctionalityKey_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityKey_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityKey_Enabled), 5, 0), true);
      cmbSecFunctionalityType.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbSecFunctionalityType.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSecFunctionalityType.getEnabled(), 5, 0), true);
      edtSecParentFunctionalityId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecParentFunctionalityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecParentFunctionalityId_Enabled), 5, 0), true);
      edtSecFunctionalityActive_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityActive_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityActive_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1I50( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues1I0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.wwpbaseobjects.secfunctionality", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7SecFunctionalityId,10,0))}, new String[] {"Gx_mode","SecFunctionalityId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"SecFunctionality");
      forbiddenHiddens.add("SecFunctionalityId", localUtil.format( DecimalUtil.doubleToDec(A62SecFunctionalityId), "ZZZZZZZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("SecFunctionalityKey", GXutil.rtrim( localUtil.format( A64SecFunctionalityKey, "")));
      forbiddenHiddens.add("SecFunctionalityDescription", GXutil.rtrim( localUtil.format( A350SecFunctionalityDescription, "")));
      forbiddenHiddens.add("SecFunctionalityType", localUtil.format( DecimalUtil.doubleToDec(A351SecFunctionalityType), "Z9"));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("wwpbaseobjects\\secfunctionality:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z62SecFunctionalityId", GXutil.ltrim( localUtil.ntoc( Z62SecFunctionalityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z64SecFunctionalityKey", Z64SecFunctionalityKey);
      web.GxWebStd.gx_hidden_field( httpContext, "Z350SecFunctionalityDescription", Z350SecFunctionalityDescription);
      web.GxWebStd.gx_hidden_field( httpContext, "Z351SecFunctionalityType", GXutil.ltrim( localUtil.ntoc( Z351SecFunctionalityType, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z349SecFunctionalityActive", Z349SecFunctionalityActive);
      web.GxWebStd.gx_hidden_field( httpContext, "Z63SecParentFunctionalityId", GXutil.ltrim( localUtil.ntoc( Z63SecParentFunctionalityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N63SecParentFunctionalityId", GXutil.ltrim( localUtil.ntoc( A63SecParentFunctionalityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTRNCONTEXT", AV10TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTRNCONTEXT", AV10TrnContext);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNCONTEXT", getSecureSignedToken( "", AV10TrnContext));
      web.GxWebStd.gx_hidden_field( httpContext, "vSECFUNCTIONALITYID", GXutil.ltrim( localUtil.ntoc( AV7SecFunctionalityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECFUNCTIONALITYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7SecFunctionalityId), "ZZZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_SECPARENTFUNCTIONALITYID", GXutil.ltrim( localUtil.ntoc( AV12Insert_SecParentFunctionalityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SECFUNCTIONALITYDESCRIPTION", A350SecFunctionalityDescription);
      web.GxWebStd.gx_hidden_field( httpContext, "SECPARENTFUNCTIONALITYDESCRIPT", A353SecParentFunctionalityDescript);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV19Pgmname));
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
      return formatLink("web.wwpbaseobjects.secfunctionality", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7SecFunctionalityId,10,0))}, new String[] {"Gx_mode","SecFunctionalityId"})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.SecFunctionality" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Functionality", "") ;
   }

   public void initializeNonKey1I50( )
   {
      A63SecParentFunctionalityId = 0 ;
      n63SecParentFunctionalityId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A63SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63SecParentFunctionalityId), 10, 0));
      n63SecParentFunctionalityId = ((0==A63SecParentFunctionalityId) ? true : false) ;
      A64SecFunctionalityKey = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A64SecFunctionalityKey", A64SecFunctionalityKey);
      A350SecFunctionalityDescription = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A350SecFunctionalityDescription", A350SecFunctionalityDescription);
      A351SecFunctionalityType = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A351SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(A351SecFunctionalityType), 2, 0));
      A353SecParentFunctionalityDescript = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A353SecParentFunctionalityDescript", A353SecParentFunctionalityDescript);
      A349SecFunctionalityActive = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A349SecFunctionalityActive", A349SecFunctionalityActive);
      Z64SecFunctionalityKey = "" ;
      Z350SecFunctionalityDescription = "" ;
      Z351SecFunctionalityType = (byte)(0) ;
      Z349SecFunctionalityActive = false ;
      Z63SecParentFunctionalityId = 0 ;
   }

   public void initAll1I50( )
   {
      A62SecFunctionalityId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A62SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SecFunctionalityId), 10, 0));
      initializeNonKey1I50( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020405060", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/secfunctionality.js", "?2024122020405060", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      edtSecFunctionalityId_Internalname = "SECFUNCTIONALITYID" ;
      edtSecFunctionalityKey_Internalname = "SECFUNCTIONALITYKEY" ;
      cmbSecFunctionalityType.setInternalname( "SECFUNCTIONALITYTYPE" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtSecParentFunctionalityId_Internalname = "SECPARENTFUNCTIONALITYID" ;
      edtSecFunctionalityActive_Internalname = "SECFUNCTIONALITYACTIVE" ;
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
      Form.setCaption( httpContext.getMessage( "Functionality", "") );
      edtSecFunctionalityActive_Jsonclick = "" ;
      edtSecFunctionalityActive_Enabled = 1 ;
      edtSecFunctionalityActive_Visible = 1 ;
      edtSecParentFunctionalityId_Jsonclick = "" ;
      edtSecParentFunctionalityId_Enabled = 1 ;
      edtSecParentFunctionalityId_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbSecFunctionalityType.setJsonclick( "" );
      cmbSecFunctionalityType.setEnabled( 0 );
      edtSecFunctionalityKey_Jsonclick = "" ;
      edtSecFunctionalityKey_Enabled = 0 ;
      edtSecFunctionalityId_Jsonclick = "" ;
      edtSecFunctionalityId_Enabled = 0 ;
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
      cmbSecFunctionalityType.setName( "SECFUNCTIONALITYTYPE" );
      cmbSecFunctionalityType.setWebtags( "" );
      cmbSecFunctionalityType.addItem("1", httpContext.getMessage( "Mode", ""), (short)(0));
      cmbSecFunctionalityType.addItem("2", httpContext.getMessage( "Action", ""), (short)(0));
      cmbSecFunctionalityType.addItem("3", httpContext.getMessage( "Tab", ""), (short)(0));
      cmbSecFunctionalityType.addItem("4", httpContext.getMessage( "Object", ""), (short)(0));
      cmbSecFunctionalityType.addItem("5", httpContext.getMessage( "Attribute", ""), (short)(0));
      if ( cmbSecFunctionalityType.getItemCount() > 0 )
      {
         A351SecFunctionalityType = (byte)(GXutil.lval( cmbSecFunctionalityType.getValidValue(GXutil.trim( GXutil.str( A351SecFunctionalityType, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A351SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(A351SecFunctionalityType), 2, 0));
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

   public void valid_Secfunctionalitykey( )
   {
      /* Using cursor T001I20 */
      pr_default.execute(18, new Object[] {A64SecFunctionalityKey, Long.valueOf(A62SecFunctionalityId)});
      if ( (pr_default.getStatus(18) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Functionality Key", "")}), 1, "SECFUNCTIONALITYKEY");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecFunctionalityKey_Internalname ;
      }
      pr_default.close(18);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Secparentfunctionalityid( )
   {
      n63SecParentFunctionalityId = false ;
      /* Using cursor T001I15 */
      pr_default.execute(13, new Object[] {Boolean.valueOf(n63SecParentFunctionalityId), Long.valueOf(A63SecParentFunctionalityId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         if ( ! ( (0==A63SecParentFunctionalityId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Sec Functionality Functionality", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SECPARENTFUNCTIONALITYID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtSecParentFunctionalityId_Internalname ;
         }
      }
      A353SecParentFunctionalityDescript = T001I15_A353SecParentFunctionalityDescript[0] ;
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A353SecParentFunctionalityDescript", A353SecParentFunctionalityDescript);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7SecFunctionalityId',fld:'vSECFUNCTIONALITYID',pic:'ZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7SecFunctionalityId',fld:'vSECFUNCTIONALITYID',pic:'ZZZZZZZZZ9',hsh:true},{av:'A62SecFunctionalityId',fld:'SECFUNCTIONALITYID',pic:'ZZZZZZZZZ9'},{av:'A64SecFunctionalityKey',fld:'SECFUNCTIONALITYKEY',pic:''},{av:'A350SecFunctionalityDescription',fld:'SECFUNCTIONALITYDESCRIPTION',pic:''},{av:'cmbSecFunctionalityType'},{av:'A351SecFunctionalityType',fld:'SECFUNCTIONALITYTYPE',pic:'Z9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e121I2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_SECFUNCTIONALITYID","{handler:'valid_Secfunctionalityid',iparms:[]");
      setEventMetadata("VALID_SECFUNCTIONALITYID",",oparms:[]}");
      setEventMetadata("VALID_SECFUNCTIONALITYKEY","{handler:'valid_Secfunctionalitykey',iparms:[{av:'A64SecFunctionalityKey',fld:'SECFUNCTIONALITYKEY',pic:''},{av:'A62SecFunctionalityId',fld:'SECFUNCTIONALITYID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("VALID_SECFUNCTIONALITYKEY",",oparms:[]}");
      setEventMetadata("VALID_SECPARENTFUNCTIONALITYID","{handler:'valid_Secparentfunctionalityid',iparms:[{av:'A63SecParentFunctionalityId',fld:'SECPARENTFUNCTIONALITYID',pic:'ZZZZZZZZZ9'},{av:'A353SecParentFunctionalityDescript',fld:'SECPARENTFUNCTIONALITYDESCRIPT',pic:''}]");
      setEventMetadata("VALID_SECPARENTFUNCTIONALITYID",",oparms:[{av:'A353SecParentFunctionalityDescript',fld:'SECPARENTFUNCTIONALITYDESCRIPT',pic:''}]}");
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
      Z64SecFunctionalityKey = "" ;
      Z350SecFunctionalityDescription = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      A64SecFunctionalityKey = "" ;
      TempTags = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A350SecFunctionalityDescription = "" ;
      A353SecParentFunctionalityDescript = "" ;
      AV19Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode50 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV18WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      AV13TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z353SecParentFunctionalityDescript = "" ;
      T001I4_A353SecParentFunctionalityDescript = new String[] {""} ;
      T001I5_A62SecFunctionalityId = new long[1] ;
      T001I5_A64SecFunctionalityKey = new String[] {""} ;
      T001I5_A350SecFunctionalityDescription = new String[] {""} ;
      T001I5_A351SecFunctionalityType = new byte[1] ;
      T001I5_A353SecParentFunctionalityDescript = new String[] {""} ;
      T001I5_A349SecFunctionalityActive = new boolean[] {false} ;
      T001I5_A63SecParentFunctionalityId = new long[1] ;
      T001I5_n63SecParentFunctionalityId = new boolean[] {false} ;
      T001I6_A64SecFunctionalityKey = new String[] {""} ;
      T001I7_A353SecParentFunctionalityDescript = new String[] {""} ;
      T001I8_A62SecFunctionalityId = new long[1] ;
      T001I3_A62SecFunctionalityId = new long[1] ;
      T001I3_A64SecFunctionalityKey = new String[] {""} ;
      T001I3_A350SecFunctionalityDescription = new String[] {""} ;
      T001I3_A351SecFunctionalityType = new byte[1] ;
      T001I3_A349SecFunctionalityActive = new boolean[] {false} ;
      T001I3_A63SecParentFunctionalityId = new long[1] ;
      T001I3_n63SecParentFunctionalityId = new boolean[] {false} ;
      T001I9_A62SecFunctionalityId = new long[1] ;
      T001I10_A62SecFunctionalityId = new long[1] ;
      T001I2_A62SecFunctionalityId = new long[1] ;
      T001I2_A64SecFunctionalityKey = new String[] {""} ;
      T001I2_A350SecFunctionalityDescription = new String[] {""} ;
      T001I2_A351SecFunctionalityType = new byte[1] ;
      T001I2_A349SecFunctionalityActive = new boolean[] {false} ;
      T001I2_A63SecParentFunctionalityId = new long[1] ;
      T001I2_n63SecParentFunctionalityId = new boolean[] {false} ;
      T001I12_A62SecFunctionalityId = new long[1] ;
      T001I15_A353SecParentFunctionalityDescript = new String[] {""} ;
      T001I16_A63SecParentFunctionalityId = new long[1] ;
      T001I16_n63SecParentFunctionalityId = new boolean[] {false} ;
      T001I17_A66SecObjectName = new String[] {""} ;
      T001I17_A62SecFunctionalityId = new long[1] ;
      T001I18_A62SecFunctionalityId = new long[1] ;
      T001I18_A65SecRoleId = new short[1] ;
      T001I19_A62SecFunctionalityId = new long[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T001I20_A64SecFunctionalityKey = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secfunctionality__default(),
         new Object[] {
             new Object[] {
            T001I2_A62SecFunctionalityId, T001I2_A64SecFunctionalityKey, T001I2_A350SecFunctionalityDescription, T001I2_A351SecFunctionalityType, T001I2_A349SecFunctionalityActive, T001I2_A63SecParentFunctionalityId, T001I2_n63SecParentFunctionalityId
            }
            , new Object[] {
            T001I3_A62SecFunctionalityId, T001I3_A64SecFunctionalityKey, T001I3_A350SecFunctionalityDescription, T001I3_A351SecFunctionalityType, T001I3_A349SecFunctionalityActive, T001I3_A63SecParentFunctionalityId, T001I3_n63SecParentFunctionalityId
            }
            , new Object[] {
            T001I4_A353SecParentFunctionalityDescript
            }
            , new Object[] {
            T001I5_A62SecFunctionalityId, T001I5_A64SecFunctionalityKey, T001I5_A350SecFunctionalityDescription, T001I5_A351SecFunctionalityType, T001I5_A353SecParentFunctionalityDescript, T001I5_A349SecFunctionalityActive, T001I5_A63SecParentFunctionalityId, T001I5_n63SecParentFunctionalityId
            }
            , new Object[] {
            T001I6_A64SecFunctionalityKey
            }
            , new Object[] {
            T001I7_A353SecParentFunctionalityDescript
            }
            , new Object[] {
            T001I8_A62SecFunctionalityId
            }
            , new Object[] {
            T001I9_A62SecFunctionalityId
            }
            , new Object[] {
            T001I10_A62SecFunctionalityId
            }
            , new Object[] {
            }
            , new Object[] {
            T001I12_A62SecFunctionalityId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001I15_A353SecParentFunctionalityDescript
            }
            , new Object[] {
            T001I16_A63SecParentFunctionalityId
            }
            , new Object[] {
            T001I17_A66SecObjectName, T001I17_A62SecFunctionalityId
            }
            , new Object[] {
            T001I18_A62SecFunctionalityId, T001I18_A65SecRoleId
            }
            , new Object[] {
            T001I19_A62SecFunctionalityId
            }
            , new Object[] {
            T001I20_A64SecFunctionalityKey
            }
         }
      );
      AV19Pgmname = "WWPBaseObjects.SecFunctionality" ;
   }

   private byte Z351SecFunctionalityType ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A351SecFunctionalityType ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound50 ;
   private short nIsDirty_50 ;
   private int trnEnded ;
   private int edtSecFunctionalityId_Enabled ;
   private int edtSecFunctionalityKey_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtSecParentFunctionalityId_Visible ;
   private int edtSecParentFunctionalityId_Enabled ;
   private int edtSecFunctionalityActive_Visible ;
   private int edtSecFunctionalityActive_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV20GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private long wcpOAV7SecFunctionalityId ;
   private long Z62SecFunctionalityId ;
   private long Z63SecParentFunctionalityId ;
   private long N63SecParentFunctionalityId ;
   private long A63SecParentFunctionalityId ;
   private long AV7SecFunctionalityId ;
   private long A62SecFunctionalityId ;
   private long AV12Insert_SecParentFunctionalityId ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtSecParentFunctionalityId_Internalname ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String edtSecFunctionalityId_Internalname ;
   private String edtSecFunctionalityId_Jsonclick ;
   private String edtSecFunctionalityKey_Internalname ;
   private String edtSecFunctionalityKey_Jsonclick ;
   private String TempTags ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtSecParentFunctionalityId_Jsonclick ;
   private String edtSecFunctionalityActive_Internalname ;
   private String edtSecFunctionalityActive_Jsonclick ;
   private String AV19Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode50 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private boolean Z349SecFunctionalityActive ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n63SecParentFunctionalityId ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean A349SecFunctionalityActive ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private String Z64SecFunctionalityKey ;
   private String Z350SecFunctionalityDescription ;
   private String A64SecFunctionalityKey ;
   private String A350SecFunctionalityDescription ;
   private String A353SecParentFunctionalityDescript ;
   private String Z353SecParentFunctionalityDescript ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbSecFunctionalityType ;
   private IDataStoreProvider pr_default ;
   private String[] T001I4_A353SecParentFunctionalityDescript ;
   private long[] T001I5_A62SecFunctionalityId ;
   private String[] T001I5_A64SecFunctionalityKey ;
   private String[] T001I5_A350SecFunctionalityDescription ;
   private byte[] T001I5_A351SecFunctionalityType ;
   private String[] T001I5_A353SecParentFunctionalityDescript ;
   private boolean[] T001I5_A349SecFunctionalityActive ;
   private long[] T001I5_A63SecParentFunctionalityId ;
   private boolean[] T001I5_n63SecParentFunctionalityId ;
   private String[] T001I6_A64SecFunctionalityKey ;
   private String[] T001I7_A353SecParentFunctionalityDescript ;
   private long[] T001I8_A62SecFunctionalityId ;
   private long[] T001I3_A62SecFunctionalityId ;
   private String[] T001I3_A64SecFunctionalityKey ;
   private String[] T001I3_A350SecFunctionalityDescription ;
   private byte[] T001I3_A351SecFunctionalityType ;
   private boolean[] T001I3_A349SecFunctionalityActive ;
   private long[] T001I3_A63SecParentFunctionalityId ;
   private boolean[] T001I3_n63SecParentFunctionalityId ;
   private long[] T001I9_A62SecFunctionalityId ;
   private long[] T001I10_A62SecFunctionalityId ;
   private long[] T001I2_A62SecFunctionalityId ;
   private String[] T001I2_A64SecFunctionalityKey ;
   private String[] T001I2_A350SecFunctionalityDescription ;
   private byte[] T001I2_A351SecFunctionalityType ;
   private boolean[] T001I2_A349SecFunctionalityActive ;
   private long[] T001I2_A63SecParentFunctionalityId ;
   private boolean[] T001I2_n63SecParentFunctionalityId ;
   private long[] T001I12_A62SecFunctionalityId ;
   private String[] T001I15_A353SecParentFunctionalityDescript ;
   private long[] T001I16_A63SecParentFunctionalityId ;
   private boolean[] T001I16_n63SecParentFunctionalityId ;
   private String[] T001I17_A66SecObjectName ;
   private long[] T001I17_A62SecFunctionalityId ;
   private long[] T001I18_A62SecFunctionalityId ;
   private short[] T001I18_A65SecRoleId ;
   private long[] T001I19_A62SecFunctionalityId ;
   private String[] T001I20_A64SecFunctionalityKey ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV18WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
}

final  class secfunctionality__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T001I2", "SELECT SecFunctionalityId, SecFunctionalityKey, SecFunctionalityDescription, SecFunctionalityType, SecFunctionalityActive, SecParentFunctionalityId FROM SecFunctionality WHERE SecFunctionalityId = ?  FOR UPDATE OF SecFunctionality NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001I3", "SELECT SecFunctionalityId, SecFunctionalityKey, SecFunctionalityDescription, SecFunctionalityType, SecFunctionalityActive, SecParentFunctionalityId FROM SecFunctionality WHERE SecFunctionalityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001I4", "SELECT SecFunctionalityDescription AS SecParentFunctionalityDescript FROM SecFunctionality WHERE SecFunctionalityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001I5", "SELECT TM1.SecFunctionalityId, TM1.SecFunctionalityKey, TM1.SecFunctionalityDescription, TM1.SecFunctionalityType, T2.SecFunctionalityDescription AS SecParentFunctionalityDescript, TM1.SecFunctionalityActive, TM1.SecParentFunctionalityId AS SecParentFunctionalityId FROM (SecFunctionality TM1 LEFT JOIN SecFunctionality T2 ON T2.SecFunctionalityId = TM1.SecParentFunctionalityId) WHERE TM1.SecFunctionalityId = ? ORDER BY TM1.SecFunctionalityId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001I6", "SELECT SecFunctionalityKey FROM SecFunctionality WHERE (SecFunctionalityKey = ?) AND (Not ( SecFunctionalityId = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001I7", "SELECT SecFunctionalityDescription AS SecParentFunctionalityDescript FROM SecFunctionality WHERE SecFunctionalityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001I8", "SELECT SecFunctionalityId FROM SecFunctionality WHERE SecFunctionalityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001I9", "SELECT SecFunctionalityId FROM SecFunctionality WHERE ( SecFunctionalityId > ?) ORDER BY SecFunctionalityId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001I10", "SELECT SecFunctionalityId FROM SecFunctionality WHERE ( SecFunctionalityId < ?) ORDER BY SecFunctionalityId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001I11", "SAVEPOINT gxupdate;INSERT INTO SecFunctionality(SecFunctionalityKey, SecFunctionalityDescription, SecFunctionalityType, SecFunctionalityActive, SecParentFunctionalityId) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001I12", "SELECT currval('SecFunctionalityId') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T001I13", "SAVEPOINT gxupdate;UPDATE SecFunctionality SET SecFunctionalityKey=?, SecFunctionalityDescription=?, SecFunctionalityType=?, SecFunctionalityActive=?, SecParentFunctionalityId=?  WHERE SecFunctionalityId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001I14", "SAVEPOINT gxupdate;DELETE FROM SecFunctionality  WHERE SecFunctionalityId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001I15", "SELECT SecFunctionalityDescription AS SecParentFunctionalityDescript FROM SecFunctionality WHERE SecFunctionalityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001I16", "SELECT SecFunctionalityId AS SecParentFunctionalityId FROM SecFunctionality WHERE SecParentFunctionalityId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001I17", "SELECT SecObjectName, SecFunctionalityId FROM SecObjectFunctionalities WHERE SecFunctionalityId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001I18", "SELECT SecFunctionalityId, SecRoleId FROM SecFunctionalityRole WHERE SecFunctionalityId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001I19", "SELECT SecFunctionalityId FROM SecFunctionality ORDER BY SecFunctionalityId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001I20", "SELECT SecFunctionalityKey FROM SecFunctionality WHERE (SecFunctionalityKey = ?) AND (Not ( SecFunctionalityId = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 8 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 14 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 16 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 17 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 3 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 4 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 6 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 8 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(5, ((Number) parms[5]).longValue());
               }
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(5, ((Number) parms[5]).longValue());
               }
               stmt.setLong(6, ((Number) parms[6]).longValue());
               return;
            case 12 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 13 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 14 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 15 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 16 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 18 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
      }
   }

}

