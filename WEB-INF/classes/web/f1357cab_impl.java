package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class f1357cab_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel2"+"_"+"CLICOD") == 0 )
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
         gx2asaclicod2F92( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_18") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_18( A3CliCod, A1EmpCod) ;
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
            AV16F1357CTipoPre = (byte)(GXutil.lval( httpContext.GetPar( "F1357CTipoPre"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16F1357CTipoPre", GXutil.str( AV16F1357CTipoPre, 1, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CTIPOPRE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16F1357CTipoPre), "9")));
            AV9F1357CPer = httpContext.GetPar( "F1357CPer") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9F1357CPer", AV9F1357CPer);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CPER", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9F1357CPer, ""))));
            AV10F1357CSec = (byte)(GXutil.lval( httpContext.GetPar( "F1357CSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10F1357CSec), 2, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10F1357CSec), "Z9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Formulario F1357", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = cmbF1357CTipoPre.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public f1357cab_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public f1357cab_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357cab_impl.class ));
   }

   public f1357cab_impl( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbF1357CTipoPre = new HTMLChoice();
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
      if ( cmbF1357CTipoPre.getItemCount() > 0 )
      {
         A784F1357CTipoPre = (byte)(GXutil.lval( cmbF1357CTipoPre.getValidValue(GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbF1357CTipoPre.setValue( GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbF1357CTipoPre.getInternalname(), "Values", cmbF1357CTipoPre.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbF1357CTipoPre.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbF1357CTipoPre.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbF1357CTipoPre, cmbF1357CTipoPre.getInternalname(), GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0)), 1, cmbF1357CTipoPre.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbF1357CTipoPre.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_F1357Cab.htm");
      cmbF1357CTipoPre.setValue( GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbF1357CTipoPre.getInternalname(), "Values", cmbF1357CTipoPre.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357CPer_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357CPer_Internalname, httpContext.getMessage( "Periodo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CPer_Internalname, GXutil.rtrim( A777F1357CPer), GXutil.rtrim( localUtil.format( A777F1357CPer, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CPer_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357CPer_Enabled, 1, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Cab.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357CSec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357CSec_Internalname, httpContext.getMessage( "Secuencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CSec_Internalname, GXutil.ltrim( localUtil.ntoc( A778F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A778F1357CSec), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357CSec_Enabled, 1, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357Cab.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357Cab.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357Cab.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357Cab.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357Cab.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_F1357Cab.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CCuitAgente_Internalname, GXutil.rtrim( A780F1357CCuitAgente), GXutil.rtrim( localUtil.format( A780F1357CCuitAgente, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,50);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CCuitAgente_Jsonclick, 0, "Attribute", "", "", "", "", edtF1357CCuitAgente_Visible, edtF1357CCuitAgente_Enabled, 0, "text", "", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Cab.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CCodImp_Internalname, GXutil.rtrim( A781F1357CCodImp), GXutil.rtrim( localUtil.format( A781F1357CCodImp, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,51);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CCodImp_Jsonclick, 0, "Attribute", "", "", "", "", edtF1357CCodImp_Visible, edtF1357CCodImp_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Cab.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CCodCon_Internalname, GXutil.rtrim( A782F1357CCodCon), GXutil.rtrim( localUtil.format( A782F1357CCodCon, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CCodCon_Jsonclick, 0, "Attribute", "", "", "", "", edtF1357CCodCon_Visible, edtF1357CCodCon_Enabled, 0, "text", "", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Cab.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CNumForm_Internalname, GXutil.rtrim( A783F1357CNumForm), GXutil.rtrim( localUtil.format( A783F1357CNumForm, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CNumForm_Jsonclick, 0, "Attribute", "", "", "", "", edtF1357CNumForm_Visible, edtF1357CNumForm_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Cab.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CVerSis_Internalname, GXutil.rtrim( A785F1357CVerSis), GXutil.rtrim( localUtil.format( A785F1357CVerSis, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CVerSis_Jsonclick, 0, "Attribute", "", "", "", "", edtF1357CVerSis_Visible, edtF1357CVerSis_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Cab.htm");
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
      e112F2 ();
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
            Z784F1357CTipoPre = (byte)(localUtil.ctol( httpContext.cgiGet( "Z784F1357CTipoPre"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z777F1357CPer = httpContext.cgiGet( "Z777F1357CPer") ;
            Z778F1357CSec = (byte)(localUtil.ctol( httpContext.cgiGet( "Z778F1357CSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z780F1357CCuitAgente = httpContext.cgiGet( "Z780F1357CCuitAgente") ;
            Z781F1357CCodImp = httpContext.cgiGet( "Z781F1357CCodImp") ;
            Z782F1357CCodCon = httpContext.cgiGet( "Z782F1357CCodCon") ;
            Z783F1357CNumForm = httpContext.cgiGet( "Z783F1357CNumForm") ;
            Z785F1357CVerSis = httpContext.cgiGet( "Z785F1357CVerSis") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV16F1357CTipoPre = (byte)(localUtil.ctol( httpContext.cgiGet( "vF1357CTIPOPRE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9F1357CPer = httpContext.cgiGet( "vF1357CPER") ;
            AV10F1357CSec = (byte)(localUtil.ctol( httpContext.cgiGet( "vF1357CSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV17Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            cmbF1357CTipoPre.setValue( httpContext.cgiGet( cmbF1357CTipoPre.getInternalname()) );
            A784F1357CTipoPre = (byte)(GXutil.lval( httpContext.cgiGet( cmbF1357CTipoPre.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
            A777F1357CPer = httpContext.cgiGet( edtF1357CPer_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtF1357CSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtF1357CSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357CSEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtF1357CSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A778F1357CSec = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
            }
            else
            {
               A778F1357CSec = (byte)(localUtil.ctol( httpContext.cgiGet( edtF1357CSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
            }
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
            A780F1357CCuitAgente = httpContext.cgiGet( edtF1357CCuitAgente_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A780F1357CCuitAgente", A780F1357CCuitAgente);
            A781F1357CCodImp = httpContext.cgiGet( edtF1357CCodImp_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A781F1357CCodImp", A781F1357CCodImp);
            A782F1357CCodCon = httpContext.cgiGet( edtF1357CCodCon_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A782F1357CCodCon", A782F1357CCodCon);
            A783F1357CNumForm = httpContext.cgiGet( edtF1357CNumForm_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A783F1357CNumForm", A783F1357CNumForm);
            A785F1357CVerSis = httpContext.cgiGet( edtF1357CVerSis_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A785F1357CVerSis", A785F1357CVerSis);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"F1357Cab");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("f1357cab:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A784F1357CTipoPre = (byte)(GXutil.lval( httpContext.GetPar( "F1357CTipoPre"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
               A777F1357CPer = httpContext.GetPar( "F1357CPer") ;
               httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
               A778F1357CSec = (byte)(GXutil.lval( httpContext.GetPar( "F1357CSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
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
                  sMode92 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode92 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound92 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_2F0( ) ;
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
                        e112F2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e122F2 ();
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
         e122F2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll2F92( ) ;
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
         disableAttributes2F92( ) ;
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

   public void confirm_2F0( )
   {
      beforeValidate2F92( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2F92( ) ;
         }
         else
         {
            checkExtendedTable2F92( ) ;
            closeExtendedTableCursors2F92( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption2F0( )
   {
   }

   public void e112F2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV11WWPContext = GXv_SdtWWPContext1[0] ;
      AV12IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWF1357Cab_Insert", GXv_boolean3) ;
         f1357cab_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWF1357Cab_Update", GXv_boolean3) ;
         f1357cab_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWF1357Cab_Delete", GXv_boolean3) ;
         f1357cab_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV17Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtF1357CCuitAgente_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357CCuitAgente_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CCuitAgente_Visible), 5, 0), true);
      edtF1357CCodImp_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357CCodImp_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CCodImp_Visible), 5, 0), true);
      edtF1357CCodCon_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357CCodCon_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CCodCon_Visible), 5, 0), true);
      edtF1357CNumForm_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357CNumForm_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CNumForm_Visible), 5, 0), true);
      edtF1357CVerSis_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357CVerSis_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CVerSis_Visible), 5, 0), true);
   }

   public void e122F2( )
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

   public void zm2F92( int GX_JID )
   {
      if ( ( GX_JID == 17 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z780F1357CCuitAgente = T002F3_A780F1357CCuitAgente[0] ;
            Z781F1357CCodImp = T002F3_A781F1357CCodImp[0] ;
            Z782F1357CCodCon = T002F3_A782F1357CCodCon[0] ;
            Z783F1357CNumForm = T002F3_A783F1357CNumForm[0] ;
            Z785F1357CVerSis = T002F3_A785F1357CVerSis[0] ;
         }
         else
         {
            Z780F1357CCuitAgente = A780F1357CCuitAgente ;
            Z781F1357CCodImp = A781F1357CCodImp ;
            Z782F1357CCodCon = A782F1357CCodCon ;
            Z783F1357CNumForm = A783F1357CNumForm ;
            Z785F1357CVerSis = A785F1357CVerSis ;
         }
      }
      if ( GX_JID == -17 )
      {
         Z784F1357CTipoPre = A784F1357CTipoPre ;
         Z777F1357CPer = A777F1357CPer ;
         Z778F1357CSec = A778F1357CSec ;
         Z780F1357CCuitAgente = A780F1357CCuitAgente ;
         Z781F1357CCodImp = A781F1357CCodImp ;
         Z782F1357CCodCon = A782F1357CCodCon ;
         Z783F1357CNumForm = A783F1357CNumForm ;
         Z785F1357CVerSis = A785F1357CVerSis ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
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
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            f1357cab_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
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
      if ( ! (0==AV16F1357CTipoPre) )
      {
         A784F1357CTipoPre = AV16F1357CTipoPre ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
      }
      if ( ! (0==AV16F1357CTipoPre) )
      {
         cmbF1357CTipoPre.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbF1357CTipoPre.getInternalname(), "Enabled", GXutil.ltrimstr( cmbF1357CTipoPre.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbF1357CTipoPre.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbF1357CTipoPre.getInternalname(), "Enabled", GXutil.ltrimstr( cmbF1357CTipoPre.getEnabled(), 5, 0), true);
      }
      if ( ! (0==AV16F1357CTipoPre) )
      {
         cmbF1357CTipoPre.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbF1357CTipoPre.getInternalname(), "Enabled", GXutil.ltrimstr( cmbF1357CTipoPre.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9F1357CPer)==0) )
      {
         A777F1357CPer = AV9F1357CPer ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
      }
      if ( ! (GXutil.strcmp("", AV9F1357CPer)==0) )
      {
         edtF1357CPer_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtF1357CPer_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CPer_Enabled), 5, 0), true);
      }
      else
      {
         edtF1357CPer_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtF1357CPer_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CPer_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9F1357CPer)==0) )
      {
         edtF1357CPer_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtF1357CPer_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CPer_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10F1357CSec) )
      {
         A778F1357CSec = AV10F1357CSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
      }
      if ( ! (0==AV10F1357CSec) )
      {
         edtF1357CSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtF1357CSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CSec_Enabled), 5, 0), true);
      }
      else
      {
         edtF1357CSec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtF1357CSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CSec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10F1357CSec) )
      {
         edtF1357CSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtF1357CSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CSec_Enabled), 5, 0), true);
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
         AV17Pgmname = "F1357Cab" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
      }
   }

   public void load2F92( )
   {
      /* Using cursor T002F5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound92 = (short)(1) ;
         A780F1357CCuitAgente = T002F5_A780F1357CCuitAgente[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A780F1357CCuitAgente", A780F1357CCuitAgente);
         A781F1357CCodImp = T002F5_A781F1357CCodImp[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A781F1357CCodImp", A781F1357CCodImp);
         A782F1357CCodCon = T002F5_A782F1357CCodCon[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A782F1357CCodCon", A782F1357CCodCon);
         A783F1357CNumForm = T002F5_A783F1357CNumForm[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A783F1357CNumForm", A783F1357CNumForm);
         A785F1357CVerSis = T002F5_A785F1357CVerSis[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A785F1357CVerSis", A785F1357CVerSis);
         zm2F92( -17) ;
      }
      pr_default.close(3);
      onLoadActions2F92( ) ;
   }

   public void onLoadActions2F92( )
   {
      AV17Pgmname = "F1357Cab" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
   }

   public void checkExtendedTable2F92( )
   {
      nIsDirty_92 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV17Pgmname = "F1357Cab" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
      /* Using cursor T002F4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( A784F1357CTipoPre == 1 ) || ( A784F1357CTipoPre == 2 ) || ( A784F1357CTipoPre == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "F1357 CTipo Pre", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "F1357CTIPOPRE");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbF1357CTipoPre.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors2F92( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_18( int A3CliCod ,
                          short A1EmpCod )
   {
      /* Using cursor T002F6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
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

   public void getKey2F92( )
   {
      /* Using cursor T002F7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound92 = (short)(1) ;
      }
      else
      {
         RcdFound92 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T002F3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm2F92( 17) ;
         RcdFound92 = (short)(1) ;
         A784F1357CTipoPre = T002F3_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002F3_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002F3_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         A780F1357CCuitAgente = T002F3_A780F1357CCuitAgente[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A780F1357CCuitAgente", A780F1357CCuitAgente);
         A781F1357CCodImp = T002F3_A781F1357CCodImp[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A781F1357CCodImp", A781F1357CCodImp);
         A782F1357CCodCon = T002F3_A782F1357CCodCon[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A782F1357CCodCon", A782F1357CCodCon);
         A783F1357CNumForm = T002F3_A783F1357CNumForm[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A783F1357CNumForm", A783F1357CNumForm);
         A785F1357CVerSis = T002F3_A785F1357CVerSis[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A785F1357CVerSis", A785F1357CVerSis);
         A3CliCod = T002F3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002F3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z784F1357CTipoPre = A784F1357CTipoPre ;
         Z777F1357CPer = A777F1357CPer ;
         Z778F1357CSec = A778F1357CSec ;
         sMode92 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load2F92( ) ;
         if ( AnyError == 1 )
         {
            RcdFound92 = (short)(0) ;
            initializeNonKey2F92( ) ;
         }
         Gx_mode = sMode92 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound92 = (short)(0) ;
         initializeNonKey2F92( ) ;
         sMode92 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode92 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey2F92( ) ;
      if ( RcdFound92 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound92 = (short)(0) ;
      /* Using cursor T002F8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A784F1357CTipoPre), Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A777F1357CPer, A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A778F1357CSec)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T002F8_A3CliCod[0] < A3CliCod ) || ( T002F8_A3CliCod[0] == A3CliCod ) && ( T002F8_A1EmpCod[0] < A1EmpCod ) || ( T002F8_A1EmpCod[0] == A1EmpCod ) && ( T002F8_A3CliCod[0] == A3CliCod ) && ( T002F8_A784F1357CTipoPre[0] < A784F1357CTipoPre ) || ( T002F8_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002F8_A1EmpCod[0] == A1EmpCod ) && ( T002F8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002F8_A777F1357CPer[0], A777F1357CPer) < 0 ) || ( GXutil.strcmp(T002F8_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002F8_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002F8_A1EmpCod[0] == A1EmpCod ) && ( T002F8_A3CliCod[0] == A3CliCod ) && ( T002F8_A778F1357CSec[0] < A778F1357CSec ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T002F8_A3CliCod[0] > A3CliCod ) || ( T002F8_A3CliCod[0] == A3CliCod ) && ( T002F8_A1EmpCod[0] > A1EmpCod ) || ( T002F8_A1EmpCod[0] == A1EmpCod ) && ( T002F8_A3CliCod[0] == A3CliCod ) && ( T002F8_A784F1357CTipoPre[0] > A784F1357CTipoPre ) || ( T002F8_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002F8_A1EmpCod[0] == A1EmpCod ) && ( T002F8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002F8_A777F1357CPer[0], A777F1357CPer) > 0 ) || ( GXutil.strcmp(T002F8_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002F8_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002F8_A1EmpCod[0] == A1EmpCod ) && ( T002F8_A3CliCod[0] == A3CliCod ) && ( T002F8_A778F1357CSec[0] > A778F1357CSec ) ) )
         {
            A3CliCod = T002F8_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002F8_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A784F1357CTipoPre = T002F8_A784F1357CTipoPre[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
            A777F1357CPer = T002F8_A777F1357CPer[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
            A778F1357CSec = T002F8_A778F1357CSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
            RcdFound92 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound92 = (short)(0) ;
      /* Using cursor T002F9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A784F1357CTipoPre), Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A777F1357CPer, A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A778F1357CSec)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T002F9_A3CliCod[0] > A3CliCod ) || ( T002F9_A3CliCod[0] == A3CliCod ) && ( T002F9_A1EmpCod[0] > A1EmpCod ) || ( T002F9_A1EmpCod[0] == A1EmpCod ) && ( T002F9_A3CliCod[0] == A3CliCod ) && ( T002F9_A784F1357CTipoPre[0] > A784F1357CTipoPre ) || ( T002F9_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002F9_A1EmpCod[0] == A1EmpCod ) && ( T002F9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002F9_A777F1357CPer[0], A777F1357CPer) > 0 ) || ( GXutil.strcmp(T002F9_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002F9_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002F9_A1EmpCod[0] == A1EmpCod ) && ( T002F9_A3CliCod[0] == A3CliCod ) && ( T002F9_A778F1357CSec[0] > A778F1357CSec ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T002F9_A3CliCod[0] < A3CliCod ) || ( T002F9_A3CliCod[0] == A3CliCod ) && ( T002F9_A1EmpCod[0] < A1EmpCod ) || ( T002F9_A1EmpCod[0] == A1EmpCod ) && ( T002F9_A3CliCod[0] == A3CliCod ) && ( T002F9_A784F1357CTipoPre[0] < A784F1357CTipoPre ) || ( T002F9_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002F9_A1EmpCod[0] == A1EmpCod ) && ( T002F9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002F9_A777F1357CPer[0], A777F1357CPer) < 0 ) || ( GXutil.strcmp(T002F9_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002F9_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002F9_A1EmpCod[0] == A1EmpCod ) && ( T002F9_A3CliCod[0] == A3CliCod ) && ( T002F9_A778F1357CSec[0] < A778F1357CSec ) ) )
         {
            A3CliCod = T002F9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002F9_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A784F1357CTipoPre = T002F9_A784F1357CTipoPre[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
            A777F1357CPer = T002F9_A777F1357CPer[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
            A778F1357CSec = T002F9_A778F1357CSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
            RcdFound92 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2F92( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = cmbF1357CTipoPre.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert2F92( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound92 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A784F1357CTipoPre = Z784F1357CTipoPre ;
               httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
               A777F1357CPer = Z777F1357CPer ;
               httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
               A778F1357CSec = Z778F1357CSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = cmbF1357CTipoPre.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update2F92( ) ;
               GX_FocusControl = cmbF1357CTipoPre.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) )
            {
               /* Insert record */
               GX_FocusControl = cmbF1357CTipoPre.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert2F92( ) ;
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
                  GX_FocusControl = cmbF1357CTipoPre.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert2F92( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A784F1357CTipoPre = Z784F1357CTipoPre ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = Z777F1357CPer ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = Z778F1357CSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = cmbF1357CTipoPre.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency2F92( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002F2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"F1357Cab"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z780F1357CCuitAgente, T002F2_A780F1357CCuitAgente[0]) != 0 ) || ( GXutil.strcmp(Z781F1357CCodImp, T002F2_A781F1357CCodImp[0]) != 0 ) || ( GXutil.strcmp(Z782F1357CCodCon, T002F2_A782F1357CCodCon[0]) != 0 ) || ( GXutil.strcmp(Z783F1357CNumForm, T002F2_A783F1357CNumForm[0]) != 0 ) || ( GXutil.strcmp(Z785F1357CVerSis, T002F2_A785F1357CVerSis[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z780F1357CCuitAgente, T002F2_A780F1357CCuitAgente[0]) != 0 )
            {
               GXutil.writeLogln("f1357cab:[seudo value changed for attri]"+"F1357CCuitAgente");
               GXutil.writeLogRaw("Old: ",Z780F1357CCuitAgente);
               GXutil.writeLogRaw("Current: ",T002F2_A780F1357CCuitAgente[0]);
            }
            if ( GXutil.strcmp(Z781F1357CCodImp, T002F2_A781F1357CCodImp[0]) != 0 )
            {
               GXutil.writeLogln("f1357cab:[seudo value changed for attri]"+"F1357CCodImp");
               GXutil.writeLogRaw("Old: ",Z781F1357CCodImp);
               GXutil.writeLogRaw("Current: ",T002F2_A781F1357CCodImp[0]);
            }
            if ( GXutil.strcmp(Z782F1357CCodCon, T002F2_A782F1357CCodCon[0]) != 0 )
            {
               GXutil.writeLogln("f1357cab:[seudo value changed for attri]"+"F1357CCodCon");
               GXutil.writeLogRaw("Old: ",Z782F1357CCodCon);
               GXutil.writeLogRaw("Current: ",T002F2_A782F1357CCodCon[0]);
            }
            if ( GXutil.strcmp(Z783F1357CNumForm, T002F2_A783F1357CNumForm[0]) != 0 )
            {
               GXutil.writeLogln("f1357cab:[seudo value changed for attri]"+"F1357CNumForm");
               GXutil.writeLogRaw("Old: ",Z783F1357CNumForm);
               GXutil.writeLogRaw("Current: ",T002F2_A783F1357CNumForm[0]);
            }
            if ( GXutil.strcmp(Z785F1357CVerSis, T002F2_A785F1357CVerSis[0]) != 0 )
            {
               GXutil.writeLogln("f1357cab:[seudo value changed for attri]"+"F1357CVerSis");
               GXutil.writeLogRaw("Old: ",Z785F1357CVerSis);
               GXutil.writeLogRaw("Current: ",T002F2_A785F1357CVerSis[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"F1357Cab"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2F92( )
   {
      beforeValidate2F92( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2F92( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2F92( 0) ;
         checkOptimisticConcurrency2F92( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2F92( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2F92( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002F10 */
                  pr_default.execute(8, new Object[] {Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), A780F1357CCuitAgente, A781F1357CCodImp, A782F1357CCodCon, A783F1357CNumForm, A785F1357CVerSis, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357Cab");
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
                        resetCaption2F0( ) ;
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
            load2F92( ) ;
         }
         endLevel2F92( ) ;
      }
      closeExtendedTableCursors2F92( ) ;
   }

   public void update2F92( )
   {
      beforeValidate2F92( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2F92( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2F92( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2F92( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2F92( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002F11 */
                  pr_default.execute(9, new Object[] {A780F1357CCuitAgente, A781F1357CCodImp, A782F1357CCodCon, A783F1357CNumForm, A785F1357CVerSis, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357Cab");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"F1357Cab"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2F92( ) ;
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
         endLevel2F92( ) ;
      }
      closeExtendedTableCursors2F92( ) ;
   }

   public void deferredUpdate2F92( )
   {
   }

   public void delete( )
   {
      beforeValidate2F92( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2F92( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2F92( ) ;
         afterConfirm2F92( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2F92( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002F12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357Cab");
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
      sMode92 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2F92( ) ;
      Gx_mode = sMode92 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2F92( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV17Pgmname = "F1357Cab" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T002F13 */
         pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "F1357 Leg Remu", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
         /* Using cursor T002F14 */
         pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "F1357 Leg Ded Gen", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
         /* Using cursor T002F15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "F1357 Leg", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
         /* Using cursor T002F16 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "F1357 LDed Per", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
         /* Using cursor T002F17 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "F1357 LCalculo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
      }
   }

   public void endLevel2F92( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2F92( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "f1357cab");
         if ( AnyError == 0 )
         {
            confirmValues2F0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "f1357cab");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2F92( )
   {
      /* Scan By routine */
      /* Using cursor T002F18 */
      pr_default.execute(16);
      RcdFound92 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound92 = (short)(1) ;
         A3CliCod = T002F18_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002F18_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A784F1357CTipoPre = T002F18_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002F18_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002F18_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2F92( )
   {
      /* Scan next routine */
      pr_default.readNext(16);
      RcdFound92 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound92 = (short)(1) ;
         A3CliCod = T002F18_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002F18_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A784F1357CTipoPre = T002F18_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002F18_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002F18_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
      }
   }

   public void scanEnd2F92( )
   {
      pr_default.close(16);
   }

   public void afterConfirm2F92( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2F92( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2F92( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2F92( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2F92( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2F92( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2F92( )
   {
      cmbF1357CTipoPre.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbF1357CTipoPre.getInternalname(), "Enabled", GXutil.ltrimstr( cmbF1357CTipoPre.getEnabled(), 5, 0), true);
      edtF1357CPer_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357CPer_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CPer_Enabled), 5, 0), true);
      edtF1357CSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357CSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CSec_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtF1357CCuitAgente_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357CCuitAgente_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CCuitAgente_Enabled), 5, 0), true);
      edtF1357CCodImp_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357CCodImp_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CCodImp_Enabled), 5, 0), true);
      edtF1357CCodCon_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357CCodCon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CCodCon_Enabled), 5, 0), true);
      edtF1357CNumForm_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357CNumForm_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CNumForm_Enabled), 5, 0), true);
      edtF1357CVerSis_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357CVerSis_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CVerSis_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes2F92( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues2F0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.f1357cab", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV16F1357CTipoPre,1,0)),GXutil.URLEncode(GXutil.rtrim(AV9F1357CPer)),GXutil.URLEncode(GXutil.ltrimstr(AV10F1357CSec,2,0))}, new String[] {"Gx_mode","CliCod","EmpCod","F1357CTipoPre","F1357CPer","F1357CSec"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"F1357Cab");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("f1357cab:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z784F1357CTipoPre", GXutil.ltrim( localUtil.ntoc( Z784F1357CTipoPre, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z777F1357CPer", GXutil.rtrim( Z777F1357CPer));
      web.GxWebStd.gx_hidden_field( httpContext, "Z778F1357CSec", GXutil.ltrim( localUtil.ntoc( Z778F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z780F1357CCuitAgente", GXutil.rtrim( Z780F1357CCuitAgente));
      web.GxWebStd.gx_hidden_field( httpContext, "Z781F1357CCodImp", GXutil.rtrim( Z781F1357CCodImp));
      web.GxWebStd.gx_hidden_field( httpContext, "Z782F1357CCodCon", GXutil.rtrim( Z782F1357CCodCon));
      web.GxWebStd.gx_hidden_field( httpContext, "Z783F1357CNumForm", GXutil.rtrim( Z783F1357CNumForm));
      web.GxWebStd.gx_hidden_field( httpContext, "Z785F1357CVerSis", GXutil.rtrim( Z785F1357CVerSis));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vF1357CTIPOPRE", GXutil.ltrim( localUtil.ntoc( AV16F1357CTipoPre, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CTIPOPRE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16F1357CTipoPre), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vF1357CPER", GXutil.rtrim( AV9F1357CPer));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CPER", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9F1357CPer, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vF1357CSEC", GXutil.ltrim( localUtil.ntoc( AV10F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vF1357CSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10F1357CSec), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV17Pgmname));
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
      return formatLink("web.f1357cab", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV16F1357CTipoPre,1,0)),GXutil.URLEncode(GXutil.rtrim(AV9F1357CPer)),GXutil.URLEncode(GXutil.ltrimstr(AV10F1357CSec,2,0))}, new String[] {"Gx_mode","CliCod","EmpCod","F1357CTipoPre","F1357CPer","F1357CSec"})  ;
   }

   public String getPgmname( )
   {
      return "F1357Cab" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Formulario F1357", "") ;
   }

   public void initializeNonKey2F92( )
   {
      A780F1357CCuitAgente = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A780F1357CCuitAgente", A780F1357CCuitAgente);
      A781F1357CCodImp = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A781F1357CCodImp", A781F1357CCodImp);
      A782F1357CCodCon = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A782F1357CCodCon", A782F1357CCodCon);
      A783F1357CNumForm = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A783F1357CNumForm", A783F1357CNumForm);
      A785F1357CVerSis = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A785F1357CVerSis", A785F1357CVerSis);
      Z780F1357CCuitAgente = "" ;
      Z781F1357CCodImp = "" ;
      Z782F1357CCodCon = "" ;
      Z783F1357CNumForm = "" ;
      Z785F1357CVerSis = "" ;
   }

   public void initAll2F92( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A784F1357CTipoPre = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
      A777F1357CPer = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
      A778F1357CSec = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
      initializeNonKey2F92( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025139373227", true, true);
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
      httpContext.AddJavascriptSource("f1357cab.js", "?2025139373227", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      cmbF1357CTipoPre.setInternalname( "F1357CTIPOPRE" );
      edtF1357CPer_Internalname = "F1357CPER" ;
      edtF1357CSec_Internalname = "F1357CSEC" ;
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
      edtF1357CCuitAgente_Internalname = "F1357CCUITAGENTE" ;
      edtF1357CCodImp_Internalname = "F1357CCODIMP" ;
      edtF1357CCodCon_Internalname = "F1357CCODCON" ;
      edtF1357CNumForm_Internalname = "F1357CNUMFORM" ;
      edtF1357CVerSis_Internalname = "F1357CVERSIS" ;
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
      Form.setCaption( httpContext.getMessage( "Formulario F1357", "") );
      edtF1357CVerSis_Jsonclick = "" ;
      edtF1357CVerSis_Enabled = 1 ;
      edtF1357CVerSis_Visible = 1 ;
      edtF1357CNumForm_Jsonclick = "" ;
      edtF1357CNumForm_Enabled = 1 ;
      edtF1357CNumForm_Visible = 1 ;
      edtF1357CCodCon_Jsonclick = "" ;
      edtF1357CCodCon_Enabled = 1 ;
      edtF1357CCodCon_Visible = 1 ;
      edtF1357CCodImp_Jsonclick = "" ;
      edtF1357CCodImp_Enabled = 1 ;
      edtF1357CCodImp_Visible = 1 ;
      edtF1357CCuitAgente_Jsonclick = "" ;
      edtF1357CCuitAgente_Enabled = 1 ;
      edtF1357CCuitAgente_Visible = 1 ;
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
      edtF1357CSec_Jsonclick = "" ;
      edtF1357CSec_Enabled = 1 ;
      edtF1357CPer_Jsonclick = "" ;
      edtF1357CPer_Enabled = 1 ;
      cmbF1357CTipoPre.setJsonclick( "" );
      cmbF1357CTipoPre.setEnabled( 1 );
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

   public void gx2asaclicod2F92( int AV7CliCod )
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
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            f1357cab_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
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

   public void init_web_controls( )
   {
      cmbF1357CTipoPre.setName( "F1357CTIPOPRE" );
      cmbF1357CTipoPre.setWebtags( "" );
      cmbF1357CTipoPre.addItem("1", httpContext.getMessage( "Anual", ""), (short)(0));
      cmbF1357CTipoPre.addItem("2", httpContext.getMessage( "Final", ""), (short)(0));
      cmbF1357CTipoPre.addItem("3", httpContext.getMessage( "Informativa", ""), (short)(0));
      if ( cmbF1357CTipoPre.getItemCount() > 0 )
      {
         A784F1357CTipoPre = (byte)(GXutil.lval( cmbF1357CTipoPre.getValidValue(GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
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
      /* Using cursor T002F19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(17);
      dynload_actions( ) ;
      if ( cmbF1357CTipoPre.getItemCount() > 0 )
      {
         A784F1357CTipoPre = (byte)(GXutil.lval( cmbF1357CTipoPre.getValidValue(GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbF1357CTipoPre.setValue( GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0)) );
      }
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV16F1357CTipoPre',fld:'vF1357CTIPOPRE',pic:'9',hsh:true},{av:'AV9F1357CPer',fld:'vF1357CPER',pic:'',hsh:true},{av:'AV10F1357CSec',fld:'vF1357CSEC',pic:'Z9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV16F1357CTipoPre',fld:'vF1357CTIPOPRE',pic:'9',hsh:true},{av:'AV9F1357CPer',fld:'vF1357CPER',pic:'',hsh:true},{av:'AV10F1357CSec',fld:'vF1357CSEC',pic:'Z9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e122F2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_F1357CTIPOPRE","{handler:'valid_F1357ctipopre',iparms:[]");
      setEventMetadata("VALID_F1357CTIPOPRE",",oparms:[]}");
      setEventMetadata("VALID_F1357CPER","{handler:'valid_F1357cper',iparms:[]");
      setEventMetadata("VALID_F1357CPER",",oparms:[]}");
      setEventMetadata("VALID_F1357CSEC","{handler:'valid_F1357csec',iparms:[]");
      setEventMetadata("VALID_F1357CSEC",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
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
      pr_default.close(17);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV9F1357CPer = "" ;
      Z777F1357CPer = "" ;
      Z780F1357CCuitAgente = "" ;
      Z781F1357CCodImp = "" ;
      Z782F1357CCodCon = "" ;
      Z783F1357CNumForm = "" ;
      Z785F1357CVerSis = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV9F1357CPer = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A777F1357CPer = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A780F1357CCuitAgente = "" ;
      A781F1357CCodImp = "" ;
      A782F1357CCodCon = "" ;
      A783F1357CNumForm = "" ;
      A785F1357CVerSis = "" ;
      AV17Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode92 = "" ;
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
      T002F5_A784F1357CTipoPre = new byte[1] ;
      T002F5_A777F1357CPer = new String[] {""} ;
      T002F5_A778F1357CSec = new byte[1] ;
      T002F5_A780F1357CCuitAgente = new String[] {""} ;
      T002F5_A781F1357CCodImp = new String[] {""} ;
      T002F5_A782F1357CCodCon = new String[] {""} ;
      T002F5_A783F1357CNumForm = new String[] {""} ;
      T002F5_A785F1357CVerSis = new String[] {""} ;
      T002F5_A3CliCod = new int[1] ;
      T002F5_A1EmpCod = new short[1] ;
      T002F4_A3CliCod = new int[1] ;
      T002F6_A3CliCod = new int[1] ;
      T002F7_A3CliCod = new int[1] ;
      T002F7_A1EmpCod = new short[1] ;
      T002F7_A784F1357CTipoPre = new byte[1] ;
      T002F7_A777F1357CPer = new String[] {""} ;
      T002F7_A778F1357CSec = new byte[1] ;
      T002F3_A784F1357CTipoPre = new byte[1] ;
      T002F3_A777F1357CPer = new String[] {""} ;
      T002F3_A778F1357CSec = new byte[1] ;
      T002F3_A780F1357CCuitAgente = new String[] {""} ;
      T002F3_A781F1357CCodImp = new String[] {""} ;
      T002F3_A782F1357CCodCon = new String[] {""} ;
      T002F3_A783F1357CNumForm = new String[] {""} ;
      T002F3_A785F1357CVerSis = new String[] {""} ;
      T002F3_A3CliCod = new int[1] ;
      T002F3_A1EmpCod = new short[1] ;
      T002F8_A3CliCod = new int[1] ;
      T002F8_A1EmpCod = new short[1] ;
      T002F8_A784F1357CTipoPre = new byte[1] ;
      T002F8_A777F1357CPer = new String[] {""} ;
      T002F8_A778F1357CSec = new byte[1] ;
      T002F9_A3CliCod = new int[1] ;
      T002F9_A1EmpCod = new short[1] ;
      T002F9_A784F1357CTipoPre = new byte[1] ;
      T002F9_A777F1357CPer = new String[] {""} ;
      T002F9_A778F1357CSec = new byte[1] ;
      T002F2_A784F1357CTipoPre = new byte[1] ;
      T002F2_A777F1357CPer = new String[] {""} ;
      T002F2_A778F1357CSec = new byte[1] ;
      T002F2_A780F1357CCuitAgente = new String[] {""} ;
      T002F2_A781F1357CCodImp = new String[] {""} ;
      T002F2_A782F1357CCodCon = new String[] {""} ;
      T002F2_A783F1357CNumForm = new String[] {""} ;
      T002F2_A785F1357CVerSis = new String[] {""} ;
      T002F2_A3CliCod = new int[1] ;
      T002F2_A1EmpCod = new short[1] ;
      T002F13_A3CliCod = new int[1] ;
      T002F13_A1EmpCod = new short[1] ;
      T002F13_A784F1357CTipoPre = new byte[1] ;
      T002F13_A777F1357CPer = new String[] {""} ;
      T002F13_A778F1357CSec = new byte[1] ;
      T002F13_A6LegNumero = new int[1] ;
      T002F13_A797F1357LRTipReg = new String[] {""} ;
      T002F14_A3CliCod = new int[1] ;
      T002F14_A1EmpCod = new short[1] ;
      T002F14_A784F1357CTipoPre = new byte[1] ;
      T002F14_A777F1357CPer = new String[] {""} ;
      T002F14_A778F1357CSec = new byte[1] ;
      T002F14_A6LegNumero = new int[1] ;
      T002F14_A863F1357LDGTipReg = new String[] {""} ;
      T002F15_A3CliCod = new int[1] ;
      T002F15_A1EmpCod = new short[1] ;
      T002F15_A784F1357CTipoPre = new byte[1] ;
      T002F15_A777F1357CPer = new String[] {""} ;
      T002F15_A778F1357CSec = new byte[1] ;
      T002F15_A6LegNumero = new int[1] ;
      T002F15_A786F1357LTipoReg = new String[] {""} ;
      T002F16_A3CliCod = new int[1] ;
      T002F16_A1EmpCod = new short[1] ;
      T002F16_A784F1357CTipoPre = new byte[1] ;
      T002F16_A777F1357CPer = new String[] {""} ;
      T002F16_A778F1357CSec = new byte[1] ;
      T002F16_A6LegNumero = new int[1] ;
      T002F16_A862F1357LDPTipReg = new String[] {""} ;
      T002F17_A3CliCod = new int[1] ;
      T002F17_A1EmpCod = new short[1] ;
      T002F17_A784F1357CTipoPre = new byte[1] ;
      T002F17_A777F1357CPer = new String[] {""} ;
      T002F17_A778F1357CSec = new byte[1] ;
      T002F17_A6LegNumero = new int[1] ;
      T002F17_A861F1357LCTipReg = new String[] {""} ;
      T002F18_A3CliCod = new int[1] ;
      T002F18_A1EmpCod = new short[1] ;
      T002F18_A784F1357CTipoPre = new byte[1] ;
      T002F18_A777F1357CPer = new String[] {""} ;
      T002F18_A778F1357CSec = new byte[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXv_int5 = new int[1] ;
      T002F19_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357cab__default(),
         new Object[] {
             new Object[] {
            T002F2_A784F1357CTipoPre, T002F2_A777F1357CPer, T002F2_A778F1357CSec, T002F2_A780F1357CCuitAgente, T002F2_A781F1357CCodImp, T002F2_A782F1357CCodCon, T002F2_A783F1357CNumForm, T002F2_A785F1357CVerSis, T002F2_A3CliCod, T002F2_A1EmpCod
            }
            , new Object[] {
            T002F3_A784F1357CTipoPre, T002F3_A777F1357CPer, T002F3_A778F1357CSec, T002F3_A780F1357CCuitAgente, T002F3_A781F1357CCodImp, T002F3_A782F1357CCodCon, T002F3_A783F1357CNumForm, T002F3_A785F1357CVerSis, T002F3_A3CliCod, T002F3_A1EmpCod
            }
            , new Object[] {
            T002F4_A3CliCod
            }
            , new Object[] {
            T002F5_A784F1357CTipoPre, T002F5_A777F1357CPer, T002F5_A778F1357CSec, T002F5_A780F1357CCuitAgente, T002F5_A781F1357CCodImp, T002F5_A782F1357CCodCon, T002F5_A783F1357CNumForm, T002F5_A785F1357CVerSis, T002F5_A3CliCod, T002F5_A1EmpCod
            }
            , new Object[] {
            T002F6_A3CliCod
            }
            , new Object[] {
            T002F7_A3CliCod, T002F7_A1EmpCod, T002F7_A784F1357CTipoPre, T002F7_A777F1357CPer, T002F7_A778F1357CSec
            }
            , new Object[] {
            T002F8_A3CliCod, T002F8_A1EmpCod, T002F8_A784F1357CTipoPre, T002F8_A777F1357CPer, T002F8_A778F1357CSec
            }
            , new Object[] {
            T002F9_A3CliCod, T002F9_A1EmpCod, T002F9_A784F1357CTipoPre, T002F9_A777F1357CPer, T002F9_A778F1357CSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002F13_A3CliCod, T002F13_A1EmpCod, T002F13_A784F1357CTipoPre, T002F13_A777F1357CPer, T002F13_A778F1357CSec, T002F13_A6LegNumero, T002F13_A797F1357LRTipReg
            }
            , new Object[] {
            T002F14_A3CliCod, T002F14_A1EmpCod, T002F14_A784F1357CTipoPre, T002F14_A777F1357CPer, T002F14_A778F1357CSec, T002F14_A6LegNumero, T002F14_A863F1357LDGTipReg
            }
            , new Object[] {
            T002F15_A3CliCod, T002F15_A1EmpCod, T002F15_A784F1357CTipoPre, T002F15_A777F1357CPer, T002F15_A778F1357CSec, T002F15_A6LegNumero, T002F15_A786F1357LTipoReg
            }
            , new Object[] {
            T002F16_A3CliCod, T002F16_A1EmpCod, T002F16_A784F1357CTipoPre, T002F16_A777F1357CPer, T002F16_A778F1357CSec, T002F16_A6LegNumero, T002F16_A862F1357LDPTipReg
            }
            , new Object[] {
            T002F17_A3CliCod, T002F17_A1EmpCod, T002F17_A784F1357CTipoPre, T002F17_A777F1357CPer, T002F17_A778F1357CSec, T002F17_A6LegNumero, T002F17_A861F1357LCTipReg
            }
            , new Object[] {
            T002F18_A3CliCod, T002F18_A1EmpCod, T002F18_A784F1357CTipoPre, T002F18_A777F1357CPer, T002F18_A778F1357CSec
            }
            , new Object[] {
            T002F19_A3CliCod
            }
         }
      );
      AV17Pgmname = "F1357Cab" ;
   }

   private byte wcpOAV16F1357CTipoPre ;
   private byte wcpOAV10F1357CSec ;
   private byte Z784F1357CTipoPre ;
   private byte Z778F1357CSec ;
   private byte GxWebError ;
   private byte AV16F1357CTipoPre ;
   private byte AV10F1357CSec ;
   private byte nKeyPressed ;
   private byte A784F1357CTipoPre ;
   private byte A778F1357CSec ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8EmpCod ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short AV8EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound92 ;
   private short nIsDirty_92 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtF1357CPer_Enabled ;
   private int edtF1357CSec_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int edtF1357CCuitAgente_Visible ;
   private int edtF1357CCuitAgente_Enabled ;
   private int edtF1357CCodImp_Visible ;
   private int edtF1357CCodImp_Enabled ;
   private int edtF1357CCodCon_Visible ;
   private int edtF1357CCodCon_Enabled ;
   private int edtF1357CNumForm_Visible ;
   private int edtF1357CNumForm_Enabled ;
   private int edtF1357CVerSis_Visible ;
   private int edtF1357CVerSis_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV9F1357CPer ;
   private String Z777F1357CPer ;
   private String Z780F1357CCuitAgente ;
   private String Z781F1357CCodImp ;
   private String Z782F1357CCodCon ;
   private String Z783F1357CNumForm ;
   private String Z785F1357CVerSis ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV9F1357CPer ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
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
   private String edtF1357CPer_Internalname ;
   private String A777F1357CPer ;
   private String edtF1357CPer_Jsonclick ;
   private String edtF1357CSec_Internalname ;
   private String edtF1357CSec_Jsonclick ;
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
   private String edtF1357CCuitAgente_Internalname ;
   private String A780F1357CCuitAgente ;
   private String edtF1357CCuitAgente_Jsonclick ;
   private String edtF1357CCodImp_Internalname ;
   private String A781F1357CCodImp ;
   private String edtF1357CCodImp_Jsonclick ;
   private String edtF1357CCodCon_Internalname ;
   private String A782F1357CCodCon ;
   private String edtF1357CCodCon_Jsonclick ;
   private String edtF1357CNumForm_Internalname ;
   private String A783F1357CNumForm ;
   private String edtF1357CNumForm_Jsonclick ;
   private String edtF1357CVerSis_Internalname ;
   private String A785F1357CVerSis ;
   private String edtF1357CVerSis_Jsonclick ;
   private String AV17Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode92 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
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
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbF1357CTipoPre ;
   private IDataStoreProvider pr_default ;
   private byte[] T002F5_A784F1357CTipoPre ;
   private String[] T002F5_A777F1357CPer ;
   private byte[] T002F5_A778F1357CSec ;
   private String[] T002F5_A780F1357CCuitAgente ;
   private String[] T002F5_A781F1357CCodImp ;
   private String[] T002F5_A782F1357CCodCon ;
   private String[] T002F5_A783F1357CNumForm ;
   private String[] T002F5_A785F1357CVerSis ;
   private int[] T002F5_A3CliCod ;
   private short[] T002F5_A1EmpCod ;
   private int[] T002F4_A3CliCod ;
   private int[] T002F6_A3CliCod ;
   private int[] T002F7_A3CliCod ;
   private short[] T002F7_A1EmpCod ;
   private byte[] T002F7_A784F1357CTipoPre ;
   private String[] T002F7_A777F1357CPer ;
   private byte[] T002F7_A778F1357CSec ;
   private byte[] T002F3_A784F1357CTipoPre ;
   private String[] T002F3_A777F1357CPer ;
   private byte[] T002F3_A778F1357CSec ;
   private String[] T002F3_A780F1357CCuitAgente ;
   private String[] T002F3_A781F1357CCodImp ;
   private String[] T002F3_A782F1357CCodCon ;
   private String[] T002F3_A783F1357CNumForm ;
   private String[] T002F3_A785F1357CVerSis ;
   private int[] T002F3_A3CliCod ;
   private short[] T002F3_A1EmpCod ;
   private int[] T002F8_A3CliCod ;
   private short[] T002F8_A1EmpCod ;
   private byte[] T002F8_A784F1357CTipoPre ;
   private String[] T002F8_A777F1357CPer ;
   private byte[] T002F8_A778F1357CSec ;
   private int[] T002F9_A3CliCod ;
   private short[] T002F9_A1EmpCod ;
   private byte[] T002F9_A784F1357CTipoPre ;
   private String[] T002F9_A777F1357CPer ;
   private byte[] T002F9_A778F1357CSec ;
   private byte[] T002F2_A784F1357CTipoPre ;
   private String[] T002F2_A777F1357CPer ;
   private byte[] T002F2_A778F1357CSec ;
   private String[] T002F2_A780F1357CCuitAgente ;
   private String[] T002F2_A781F1357CCodImp ;
   private String[] T002F2_A782F1357CCodCon ;
   private String[] T002F2_A783F1357CNumForm ;
   private String[] T002F2_A785F1357CVerSis ;
   private int[] T002F2_A3CliCod ;
   private short[] T002F2_A1EmpCod ;
   private int[] T002F13_A3CliCod ;
   private short[] T002F13_A1EmpCod ;
   private byte[] T002F13_A784F1357CTipoPre ;
   private String[] T002F13_A777F1357CPer ;
   private byte[] T002F13_A778F1357CSec ;
   private int[] T002F13_A6LegNumero ;
   private String[] T002F13_A797F1357LRTipReg ;
   private int[] T002F14_A3CliCod ;
   private short[] T002F14_A1EmpCod ;
   private byte[] T002F14_A784F1357CTipoPre ;
   private String[] T002F14_A777F1357CPer ;
   private byte[] T002F14_A778F1357CSec ;
   private int[] T002F14_A6LegNumero ;
   private String[] T002F14_A863F1357LDGTipReg ;
   private int[] T002F15_A3CliCod ;
   private short[] T002F15_A1EmpCod ;
   private byte[] T002F15_A784F1357CTipoPre ;
   private String[] T002F15_A777F1357CPer ;
   private byte[] T002F15_A778F1357CSec ;
   private int[] T002F15_A6LegNumero ;
   private String[] T002F15_A786F1357LTipoReg ;
   private int[] T002F16_A3CliCod ;
   private short[] T002F16_A1EmpCod ;
   private byte[] T002F16_A784F1357CTipoPre ;
   private String[] T002F16_A777F1357CPer ;
   private byte[] T002F16_A778F1357CSec ;
   private int[] T002F16_A6LegNumero ;
   private String[] T002F16_A862F1357LDPTipReg ;
   private int[] T002F17_A3CliCod ;
   private short[] T002F17_A1EmpCod ;
   private byte[] T002F17_A784F1357CTipoPre ;
   private String[] T002F17_A777F1357CPer ;
   private byte[] T002F17_A778F1357CSec ;
   private int[] T002F17_A6LegNumero ;
   private String[] T002F17_A861F1357LCTipReg ;
   private int[] T002F18_A3CliCod ;
   private short[] T002F18_A1EmpCod ;
   private byte[] T002F18_A784F1357CTipoPre ;
   private String[] T002F18_A777F1357CPer ;
   private byte[] T002F18_A778F1357CSec ;
   private int[] T002F19_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
}

final  class f1357cab__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T002F2", "SELECT F1357CTipoPre, F1357CPer, F1357CSec, F1357CCuitAgente, F1357CCodImp, F1357CCodCon, F1357CNumForm, F1357CVerSis, CliCod, EmpCod FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ?  FOR UPDATE OF F1357Cab NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002F3", "SELECT F1357CTipoPre, F1357CPer, F1357CSec, F1357CCuitAgente, F1357CCodImp, F1357CCodCon, F1357CNumForm, F1357CVerSis, CliCod, EmpCod FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002F4", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002F5", "SELECT TM1.F1357CTipoPre, TM1.F1357CPer, TM1.F1357CSec, TM1.F1357CCuitAgente, TM1.F1357CCodImp, TM1.F1357CCodCon, TM1.F1357CNumForm, TM1.F1357CVerSis, TM1.CliCod, TM1.EmpCod FROM F1357Cab TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.F1357CTipoPre = ? and TM1.F1357CPer = ( ?) and TM1.F1357CSec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.F1357CTipoPre, TM1.F1357CPer, TM1.F1357CSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002F6", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002F7", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002F8", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357Cab WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and F1357CTipoPre > ? or F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CPer > ( ?) or F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CSec > ?) ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002F9", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357Cab WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and F1357CTipoPre < ? or F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CPer < ( ?) or F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CSec < ?) ORDER BY CliCod DESC, EmpCod DESC, F1357CTipoPre DESC, F1357CPer DESC, F1357CSec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T002F10", "SAVEPOINT gxupdate;INSERT INTO F1357Cab(F1357CTipoPre, F1357CPer, F1357CSec, F1357CCuitAgente, F1357CCodImp, F1357CCodCon, F1357CNumForm, F1357CVerSis, CliCod, EmpCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002F11", "SAVEPOINT gxupdate;UPDATE F1357Cab SET F1357CCuitAgente=?, F1357CCodImp=?, F1357CCodCon=?, F1357CNumForm=?, F1357CVerSis=?  WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002F12", "SAVEPOINT gxupdate;DELETE FROM F1357Cab  WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002F13", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LRTipReg FROM F1357LegRemun WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002F14", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDGTipReg FROM F1357LegDedGen WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002F15", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LTipoReg FROM F1357Leg WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002F16", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDPTipReg FROM F1357LDedPer WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002F17", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LCTipReg FROM F1357LCalculo WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002F18", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357Cab ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002F19", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 11);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               ((String[]) buf[5])[0] = rslt.getString(6, 3);
               ((String[]) buf[6])[0] = rslt.getString(7, 4);
               ((String[]) buf[7])[0] = rslt.getString(8, 5);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 1 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 11);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               ((String[]) buf[5])[0] = rslt.getString(6, 3);
               ((String[]) buf[6])[0] = rslt.getString(7, 4);
               ((String[]) buf[7])[0] = rslt.getString(8, 5);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 11);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               ((String[]) buf[5])[0] = rslt.getString(6, 3);
               ((String[]) buf[6])[0] = rslt.getString(7, 4);
               ((String[]) buf[7])[0] = rslt.getString(8, 5);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 6);
               stmt.setString(11, (String)parms[10], 6);
               stmt.setByte(12, ((Number) parms[11]).byteValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setByte(15, ((Number) parms[14]).byteValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 6);
               stmt.setString(11, (String)parms[10], 6);
               stmt.setByte(12, ((Number) parms[11]).byteValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setByte(15, ((Number) parms[14]).byteValue());
               return;
            case 8 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setString(2, (String)parms[1], 6);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 11);
               stmt.setString(5, (String)parms[4], 4);
               stmt.setString(6, (String)parms[5], 3);
               stmt.setString(7, (String)parms[6], 4);
               stmt.setString(8, (String)parms[7], 5);
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
            case 9 :
               stmt.setString(1, (String)parms[0], 11);
               stmt.setString(2, (String)parms[1], 4);
               stmt.setString(3, (String)parms[2], 3);
               stmt.setString(4, (String)parms[3], 4);
               stmt.setString(5, (String)parms[4], 5);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setString(9, (String)parms[8], 6);
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

