package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class periodo_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel2"+"_"+"PERIODOESTADO") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1729PeriodoLiq = localUtil.parseDateParm( httpContext.GetPar( "PeriodoLiq")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx2asaperiodoestado50233( A3CliCod, A1EmpCod, A1729PeriodoLiq) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel3"+"_"+"PERIODOCNTLIQ") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1729PeriodoLiq = localUtil.parseDateParm( httpContext.GetPar( "PeriodoLiq")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx3asaperiodocntliq50233( A3CliCod, A1EmpCod, A1729PeriodoLiq) ;
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
         gx4asaclicod50233( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_14") == 0 )
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
         gxload_14( A3CliCod, A1EmpCod) ;
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
            AV9PeriodoLiq = localUtil.parseDateParm( httpContext.GetPar( "PeriodoLiq")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9PeriodoLiq", localUtil.format(AV9PeriodoLiq, "99/99/99"));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERIODOLIQ", getSecureSignedToken( "", AV9PeriodoLiq));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Periodo", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtPeriodoAnio_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public periodo_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public periodo_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( periodo_impl.class ));
   }

   public periodo_impl( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbPeriodoMes = new HTMLChoice();
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
      if ( cmbPeriodoMes.getItemCount() > 0 )
      {
         A1731PeriodoMes = (byte)(GXutil.lval( cmbPeriodoMes.getValidValue(GXutil.trim( GXutil.str( A1731PeriodoMes, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1731PeriodoMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1731PeriodoMes), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPeriodoMes.setValue( GXutil.trim( GXutil.str( A1731PeriodoMes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPeriodoMes.getInternalname(), "Values", cmbPeriodoMes.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPeriodoAnio_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPeriodoAnio_Internalname, httpContext.getMessage( "Año", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPeriodoAnio_Internalname, GXutil.ltrim( localUtil.ntoc( A1730PeriodoAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPeriodoAnio_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1730PeriodoAnio), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1730PeriodoAnio), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPeriodoAnio_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPeriodoAnio_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Anio", "right", false, "", "HLP_Periodo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPeriodoMes.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbPeriodoMes.getInternalname(), httpContext.getMessage( "Mes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPeriodoMes, cmbPeriodoMes.getInternalname(), GXutil.trim( GXutil.str( A1731PeriodoMes, 2, 0)), 1, cmbPeriodoMes.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbPeriodoMes.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "", true, (byte)(0), "HLP_Periodo.htm");
      cmbPeriodoMes.setValue( GXutil.trim( GXutil.str( A1731PeriodoMes, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPeriodoMes.getInternalname(), "Values", cmbPeriodoMes.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Periodo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Periodo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Periodo.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Periodo.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Periodo.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtPeriodoLiq_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPeriodoLiq_Internalname, localUtil.format(A1729PeriodoLiq, "99/99/99"), localUtil.format( A1729PeriodoLiq, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,45);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPeriodoLiq_Jsonclick, 0, "Attribute", "", "", "", "", edtPeriodoLiq_Visible, edtPeriodoLiq_Enabled, 1, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Periodo", "right", false, "", "HLP_Periodo.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtPeriodoLiq_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtPeriodoLiq_Visible==0)||(edtPeriodoLiq_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Periodo.htm");
      httpContext.writeTextNL( "</div>") ;
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 46,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtPeriodoDescrip_Internalname, A1732PeriodoDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,46);\"", (short)(0), edtPeriodoDescrip_Visible, edtPeriodoDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "Descrip", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Periodo.htm");
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
      e11502 ();
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
            Z1729PeriodoLiq = localUtil.ctod( httpContext.cgiGet( "Z1729PeriodoLiq"), 0) ;
            Z1730PeriodoAnio = (short)(localUtil.ctol( httpContext.cgiGet( "Z1730PeriodoAnio"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1731PeriodoMes = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1731PeriodoMes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1732PeriodoDescrip = httpContext.cgiGet( "Z1732PeriodoDescrip") ;
            Z2103PeriodoAnioMes = (int)(localUtil.ctol( httpContext.cgiGet( "Z2103PeriodoAnioMes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2103PeriodoAnioMes = (int)(localUtil.ctol( httpContext.cgiGet( "Z2103PeriodoAnioMes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            A1819PeriodoEstado = (byte)(localUtil.ctol( httpContext.cgiGet( "PERIODOESTADO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1735PeriodoCntLiq = (short)(localUtil.ctol( httpContext.cgiGet( "PERIODOCNTLIQ"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9PeriodoLiq = localUtil.ctod( httpContext.cgiGet( "vPERIODOLIQ"), 0) ;
            A2103PeriodoAnioMes = (int)(localUtil.ctol( httpContext.cgiGet( "PERIODOANIOMES"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV24Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPeriodoAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPeriodoAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PERIODOANIO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPeriodoAnio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1730PeriodoAnio = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1730PeriodoAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1730PeriodoAnio), 4, 0));
            }
            else
            {
               A1730PeriodoAnio = (short)(localUtil.ctol( httpContext.cgiGet( edtPeriodoAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1730PeriodoAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1730PeriodoAnio), 4, 0));
            }
            cmbPeriodoMes.setValue( httpContext.cgiGet( cmbPeriodoMes.getInternalname()) );
            A1731PeriodoMes = (byte)(GXutil.lval( httpContext.cgiGet( cmbPeriodoMes.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1731PeriodoMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1731PeriodoMes), 2, 0));
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
            if ( localUtil.vcdate( httpContext.cgiGet( edtPeriodoLiq_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "PERIODOLIQ");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPeriodoLiq_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1729PeriodoLiq = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
            }
            else
            {
               A1729PeriodoLiq = localUtil.ctod( httpContext.cgiGet( edtPeriodoLiq_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
            }
            A1732PeriodoDescrip = httpContext.cgiGet( edtPeriodoDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1732PeriodoDescrip", A1732PeriodoDescrip);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Periodo");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("PeriodoAnioMes", localUtil.format( DecimalUtil.doubleToDec(A2103PeriodoAnioMes), "ZZZZZ9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || !( GXutil.dateCompare(GXutil.resetTime(A1729PeriodoLiq), GXutil.resetTime(Z1729PeriodoLiq)) ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("periodo:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1729PeriodoLiq = localUtil.parseDateParm( httpContext.GetPar( "PeriodoLiq")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
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
                  sMode233 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode233 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound233 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_500( ) ;
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
                        e11502 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12502 ();
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
         e12502 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll50233( ) ;
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
         disableAttributes50233( ) ;
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

   public void confirm_500( )
   {
      beforeValidate50233( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls50233( ) ;
         }
         else
         {
            checkExtendedTable50233( ) ;
            closeExtendedTableCursors50233( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption500( )
   {
   }

   public void e11502( )
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPeriodo_Insert", GXv_boolean3) ;
         periodo_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPeriodo_Update", GXv_boolean3) ;
         periodo_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPeriodo_Delete", GXv_boolean3) ;
         periodo_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV24Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtPeriodoLiq_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPeriodoLiq_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPeriodoLiq_Visible), 5, 0), true);
      edtPeriodoDescrip_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPeriodoDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPeriodoDescrip_Visible), 5, 0), true);
   }

   public void e12502( )
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

   public void zm50233( int GX_JID )
   {
      if ( ( GX_JID == 13 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1730PeriodoAnio = T00503_A1730PeriodoAnio[0] ;
            Z1731PeriodoMes = T00503_A1731PeriodoMes[0] ;
            Z1732PeriodoDescrip = T00503_A1732PeriodoDescrip[0] ;
            Z2103PeriodoAnioMes = T00503_A2103PeriodoAnioMes[0] ;
         }
         else
         {
            Z1730PeriodoAnio = A1730PeriodoAnio ;
            Z1731PeriodoMes = A1731PeriodoMes ;
            Z1732PeriodoDescrip = A1732PeriodoDescrip ;
            Z2103PeriodoAnioMes = A2103PeriodoAnioMes ;
         }
      }
      if ( GX_JID == -13 )
      {
         Z1729PeriodoLiq = A1729PeriodoLiq ;
         Z1730PeriodoAnio = A1730PeriodoAnio ;
         Z1731PeriodoMes = A1731PeriodoMes ;
         Z1732PeriodoDescrip = A1732PeriodoDescrip ;
         Z2103PeriodoAnioMes = A2103PeriodoAnioMes ;
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
            periodo_impl.this.GXt_int4 = GXv_int5[0] ;
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
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV9PeriodoLiq)) )
      {
         A1729PeriodoLiq = AV9PeriodoLiq ;
         httpContext.ajax_rsp_assign_attri("", false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV9PeriodoLiq)) )
      {
         edtPeriodoLiq_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPeriodoLiq_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPeriodoLiq_Enabled), 5, 0), true);
      }
      else
      {
         edtPeriodoLiq_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPeriodoLiq_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPeriodoLiq_Enabled), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV9PeriodoLiq)) )
      {
         edtPeriodoLiq_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPeriodoLiq_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPeriodoLiq_Enabled), 5, 0), true);
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
         AV24Pgmname = "Periodo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
         GXt_int6 = A1819PeriodoEstado ;
         GXv_int7[0] = GXt_int6 ;
         new web.getperiodoestado(remoteHandle, context).execute( A3CliCod, A1EmpCod, A1729PeriodoLiq, GXv_int7) ;
         periodo_impl.this.GXt_int6 = GXv_int7[0] ;
         A1819PeriodoEstado = GXt_int6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1819PeriodoEstado", GXutil.str( A1819PeriodoEstado, 1, 0));
         GXt_int8 = A1735PeriodoCntLiq ;
         GXv_int9[0] = GXt_int8 ;
         new web.periodocantliq(remoteHandle, context).execute( A3CliCod, A1EmpCod, A1729PeriodoLiq, GXv_int9) ;
         periodo_impl.this.GXt_int8 = GXv_int9[0] ;
         A1735PeriodoCntLiq = GXt_int8 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1735PeriodoCntLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1735PeriodoCntLiq), 4, 0));
      }
   }

   public void load50233( )
   {
      /* Using cursor T00505 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1729PeriodoLiq});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound233 = (short)(1) ;
         A1730PeriodoAnio = T00505_A1730PeriodoAnio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1730PeriodoAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1730PeriodoAnio), 4, 0));
         A1731PeriodoMes = T00505_A1731PeriodoMes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1731PeriodoMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1731PeriodoMes), 2, 0));
         A1732PeriodoDescrip = T00505_A1732PeriodoDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1732PeriodoDescrip", A1732PeriodoDescrip);
         A2103PeriodoAnioMes = T00505_A2103PeriodoAnioMes[0] ;
         zm50233( -13) ;
      }
      pr_default.close(3);
      onLoadActions50233( ) ;
   }

   public void onLoadActions50233( )
   {
      AV24Pgmname = "Periodo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      GXt_int6 = A1819PeriodoEstado ;
      GXv_int7[0] = GXt_int6 ;
      new web.getperiodoestado(remoteHandle, context).execute( A3CliCod, A1EmpCod, A1729PeriodoLiq, GXv_int7) ;
      periodo_impl.this.GXt_int6 = GXv_int7[0] ;
      A1819PeriodoEstado = GXt_int6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1819PeriodoEstado", GXutil.str( A1819PeriodoEstado, 1, 0));
      GXt_int8 = A1735PeriodoCntLiq ;
      GXv_int9[0] = GXt_int8 ;
      new web.periodocantliq(remoteHandle, context).execute( A3CliCod, A1EmpCod, A1729PeriodoLiq, GXv_int9) ;
      periodo_impl.this.GXt_int8 = GXv_int9[0] ;
      A1735PeriodoCntLiq = GXt_int8 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1735PeriodoCntLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1735PeriodoCntLiq), 4, 0));
   }

   public void checkExtendedTable50233( )
   {
      nIsDirty_233 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV24Pgmname = "Periodo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      /* Using cursor T00504 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      nIsDirty_233 = (short)(1) ;
      GXt_int6 = A1819PeriodoEstado ;
      GXv_int7[0] = GXt_int6 ;
      new web.getperiodoestado(remoteHandle, context).execute( A3CliCod, A1EmpCod, A1729PeriodoLiq, GXv_int7) ;
      periodo_impl.this.GXt_int6 = GXv_int7[0] ;
      A1819PeriodoEstado = GXt_int6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1819PeriodoEstado", GXutil.str( A1819PeriodoEstado, 1, 0));
      nIsDirty_233 = (short)(1) ;
      GXt_int8 = A1735PeriodoCntLiq ;
      GXv_int9[0] = GXt_int8 ;
      new web.periodocantliq(remoteHandle, context).execute( A3CliCod, A1EmpCod, A1729PeriodoLiq, GXv_int9) ;
      periodo_impl.this.GXt_int8 = GXv_int9[0] ;
      A1735PeriodoCntLiq = GXt_int8 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1735PeriodoCntLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1735PeriodoCntLiq), 4, 0));
      if ( ! ( ( A1731PeriodoMes == 1 ) || ( A1731PeriodoMes == 2 ) || ( A1731PeriodoMes == 3 ) || ( A1731PeriodoMes == 4 ) || ( A1731PeriodoMes == 5 ) || ( A1731PeriodoMes == 6 ) || ( A1731PeriodoMes == 7 ) || ( A1731PeriodoMes == 8 ) || ( A1731PeriodoMes == 9 ) || ( A1731PeriodoMes == 10 ) || ( A1731PeriodoMes == 11 ) || ( A1731PeriodoMes == 12 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Mes", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PERIODOMES");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPeriodoMes.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors50233( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_14( int A3CliCod ,
                          short A1EmpCod )
   {
      /* Using cursor T00506 */
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

   public void getKey50233( )
   {
      /* Using cursor T00507 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1729PeriodoLiq});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound233 = (short)(1) ;
      }
      else
      {
         RcdFound233 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00503 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1729PeriodoLiq});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm50233( 13) ;
         RcdFound233 = (short)(1) ;
         A1729PeriodoLiq = T00503_A1729PeriodoLiq[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
         A1730PeriodoAnio = T00503_A1730PeriodoAnio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1730PeriodoAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1730PeriodoAnio), 4, 0));
         A1731PeriodoMes = T00503_A1731PeriodoMes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1731PeriodoMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1731PeriodoMes), 2, 0));
         A1732PeriodoDescrip = T00503_A1732PeriodoDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1732PeriodoDescrip", A1732PeriodoDescrip);
         A2103PeriodoAnioMes = T00503_A2103PeriodoAnioMes[0] ;
         A3CliCod = T00503_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T00503_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1729PeriodoLiq = A1729PeriodoLiq ;
         sMode233 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load50233( ) ;
         if ( AnyError == 1 )
         {
            RcdFound233 = (short)(0) ;
            initializeNonKey50233( ) ;
         }
         Gx_mode = sMode233 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound233 = (short)(0) ;
         initializeNonKey50233( ) ;
         sMode233 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode233 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey50233( ) ;
      if ( RcdFound233 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound233 = (short)(0) ;
      /* Using cursor T00508 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A1729PeriodoLiq});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00508_A3CliCod[0] < A3CliCod ) || ( T00508_A3CliCod[0] == A3CliCod ) && ( T00508_A1EmpCod[0] < A1EmpCod ) || ( T00508_A1EmpCod[0] == A1EmpCod ) && ( T00508_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T00508_A1729PeriodoLiq[0]).before( GXutil.resetTime( A1729PeriodoLiq )) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00508_A3CliCod[0] > A3CliCod ) || ( T00508_A3CliCod[0] == A3CliCod ) && ( T00508_A1EmpCod[0] > A1EmpCod ) || ( T00508_A1EmpCod[0] == A1EmpCod ) && ( T00508_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T00508_A1729PeriodoLiq[0]).after( GXutil.resetTime( A1729PeriodoLiq )) ) )
         {
            A3CliCod = T00508_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T00508_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A1729PeriodoLiq = T00508_A1729PeriodoLiq[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
            RcdFound233 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound233 = (short)(0) ;
      /* Using cursor T00509 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A1729PeriodoLiq});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00509_A3CliCod[0] > A3CliCod ) || ( T00509_A3CliCod[0] == A3CliCod ) && ( T00509_A1EmpCod[0] > A1EmpCod ) || ( T00509_A1EmpCod[0] == A1EmpCod ) && ( T00509_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T00509_A1729PeriodoLiq[0]).after( GXutil.resetTime( A1729PeriodoLiq )) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00509_A3CliCod[0] < A3CliCod ) || ( T00509_A3CliCod[0] == A3CliCod ) && ( T00509_A1EmpCod[0] < A1EmpCod ) || ( T00509_A1EmpCod[0] == A1EmpCod ) && ( T00509_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T00509_A1729PeriodoLiq[0]).before( GXutil.resetTime( A1729PeriodoLiq )) ) )
         {
            A3CliCod = T00509_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T00509_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A1729PeriodoLiq = T00509_A1729PeriodoLiq[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
            RcdFound233 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey50233( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtPeriodoAnio_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert50233( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound233 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || !( GXutil.dateCompare(GXutil.resetTime(A1729PeriodoLiq), GXutil.resetTime(Z1729PeriodoLiq)) ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A1729PeriodoLiq = Z1729PeriodoLiq ;
               httpContext.ajax_rsp_assign_attri("", false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtPeriodoAnio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update50233( ) ;
               GX_FocusControl = edtPeriodoAnio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || !( GXutil.dateCompare(GXutil.resetTime(A1729PeriodoLiq), GXutil.resetTime(Z1729PeriodoLiq)) ) )
            {
               /* Insert record */
               GX_FocusControl = edtPeriodoAnio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert50233( ) ;
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
                  GX_FocusControl = edtPeriodoAnio_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert50233( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || !( GXutil.dateCompare(GXutil.resetTime(A1729PeriodoLiq), GXutil.resetTime(Z1729PeriodoLiq)) ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1729PeriodoLiq = Z1729PeriodoLiq ;
         httpContext.ajax_rsp_assign_attri("", false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtPeriodoAnio_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency50233( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00502 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1729PeriodoLiq});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Periodo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z1730PeriodoAnio != T00502_A1730PeriodoAnio[0] ) || ( Z1731PeriodoMes != T00502_A1731PeriodoMes[0] ) || ( GXutil.strcmp(Z1732PeriodoDescrip, T00502_A1732PeriodoDescrip[0]) != 0 ) || ( Z2103PeriodoAnioMes != T00502_A2103PeriodoAnioMes[0] ) )
         {
            if ( Z1730PeriodoAnio != T00502_A1730PeriodoAnio[0] )
            {
               GXutil.writeLogln("periodo:[seudo value changed for attri]"+"PeriodoAnio");
               GXutil.writeLogRaw("Old: ",Z1730PeriodoAnio);
               GXutil.writeLogRaw("Current: ",T00502_A1730PeriodoAnio[0]);
            }
            if ( Z1731PeriodoMes != T00502_A1731PeriodoMes[0] )
            {
               GXutil.writeLogln("periodo:[seudo value changed for attri]"+"PeriodoMes");
               GXutil.writeLogRaw("Old: ",Z1731PeriodoMes);
               GXutil.writeLogRaw("Current: ",T00502_A1731PeriodoMes[0]);
            }
            if ( GXutil.strcmp(Z1732PeriodoDescrip, T00502_A1732PeriodoDescrip[0]) != 0 )
            {
               GXutil.writeLogln("periodo:[seudo value changed for attri]"+"PeriodoDescrip");
               GXutil.writeLogRaw("Old: ",Z1732PeriodoDescrip);
               GXutil.writeLogRaw("Current: ",T00502_A1732PeriodoDescrip[0]);
            }
            if ( Z2103PeriodoAnioMes != T00502_A2103PeriodoAnioMes[0] )
            {
               GXutil.writeLogln("periodo:[seudo value changed for attri]"+"PeriodoAnioMes");
               GXutil.writeLogRaw("Old: ",Z2103PeriodoAnioMes);
               GXutil.writeLogRaw("Current: ",T00502_A2103PeriodoAnioMes[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Periodo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert50233( )
   {
      beforeValidate50233( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable50233( ) ;
      }
      if ( AnyError == 0 )
      {
         zm50233( 0) ;
         checkOptimisticConcurrency50233( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm50233( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert50233( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005010 */
                  pr_default.execute(8, new Object[] {A1729PeriodoLiq, Short.valueOf(A1730PeriodoAnio), Byte.valueOf(A1731PeriodoMes), A1732PeriodoDescrip, Integer.valueOf(A2103PeriodoAnioMes), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Periodo");
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
                        resetCaption500( ) ;
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
            load50233( ) ;
         }
         endLevel50233( ) ;
      }
      closeExtendedTableCursors50233( ) ;
   }

   public void update50233( )
   {
      beforeValidate50233( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable50233( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency50233( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm50233( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate50233( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005011 */
                  pr_default.execute(9, new Object[] {Short.valueOf(A1730PeriodoAnio), Byte.valueOf(A1731PeriodoMes), A1732PeriodoDescrip, Integer.valueOf(A2103PeriodoAnioMes), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1729PeriodoLiq});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Periodo");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Periodo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate50233( ) ;
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
         endLevel50233( ) ;
      }
      closeExtendedTableCursors50233( ) ;
   }

   public void deferredUpdate50233( )
   {
   }

   public void delete( )
   {
      beforeValidate50233( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency50233( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls50233( ) ;
         afterConfirm50233( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete50233( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005012 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1729PeriodoLiq});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Periodo");
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
      sMode233 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel50233( ) ;
      Gx_mode = sMode233 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls50233( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV24Pgmname = "Periodo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
         GXt_int6 = A1819PeriodoEstado ;
         GXv_int7[0] = GXt_int6 ;
         new web.getperiodoestado(remoteHandle, context).execute( A3CliCod, A1EmpCod, A1729PeriodoLiq, GXv_int7) ;
         periodo_impl.this.GXt_int6 = GXv_int7[0] ;
         A1819PeriodoEstado = GXt_int6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1819PeriodoEstado", GXutil.str( A1819PeriodoEstado, 1, 0));
         GXt_int8 = A1735PeriodoCntLiq ;
         GXv_int9[0] = GXt_int8 ;
         new web.periodocantliq(remoteHandle, context).execute( A3CliCod, A1EmpCod, A1729PeriodoLiq, GXv_int9) ;
         periodo_impl.this.GXt_int8 = GXv_int9[0] ;
         A1735PeriodoCntLiq = GXt_int8 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1735PeriodoCntLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1735PeriodoCntLiq), 4, 0));
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T005013 */
         pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1729PeriodoLiq});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
      }
   }

   public void endLevel50233( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete50233( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "periodo");
         if ( AnyError == 0 )
         {
            confirmValues500( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "periodo");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart50233( )
   {
      /* Scan By routine */
      /* Using cursor T005014 */
      pr_default.execute(12);
      RcdFound233 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound233 = (short)(1) ;
         A3CliCod = T005014_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T005014_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1729PeriodoLiq = T005014_A1729PeriodoLiq[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext50233( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound233 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound233 = (short)(1) ;
         A3CliCod = T005014_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T005014_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1729PeriodoLiq = T005014_A1729PeriodoLiq[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
      }
   }

   public void scanEnd50233( )
   {
      pr_default.close(12);
   }

   public void afterConfirm50233( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert50233( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate50233( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete50233( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete50233( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate50233( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes50233( )
   {
      edtPeriodoAnio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPeriodoAnio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPeriodoAnio_Enabled), 5, 0), true);
      cmbPeriodoMes.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPeriodoMes.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPeriodoMes.getEnabled(), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtPeriodoLiq_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPeriodoLiq_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPeriodoLiq_Enabled), 5, 0), true);
      edtPeriodoDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPeriodoDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPeriodoDescrip_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes50233( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues500( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.periodo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.formatDateParm(AV9PeriodoLiq))}, new String[] {"Gx_mode","CliCod","EmpCod","PeriodoLiq"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Periodo");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("PeriodoAnioMes", localUtil.format( DecimalUtil.doubleToDec(A2103PeriodoAnioMes), "ZZZZZ9"));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("periodo:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1729PeriodoLiq", localUtil.dtoc( Z1729PeriodoLiq, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1730PeriodoAnio", GXutil.ltrim( localUtil.ntoc( Z1730PeriodoAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1731PeriodoMes", GXutil.ltrim( localUtil.ntoc( Z1731PeriodoMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1732PeriodoDescrip", Z1732PeriodoDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2103PeriodoAnioMes", GXutil.ltrim( localUtil.ntoc( Z2103PeriodoAnioMes, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "PERIODOESTADO", GXutil.ltrim( localUtil.ntoc( A1819PeriodoEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PERIODOCNTLIQ", GXutil.ltrim( localUtil.ntoc( A1735PeriodoCntLiq, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPERIODOLIQ", localUtil.dtoc( AV9PeriodoLiq, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPERIODOLIQ", getSecureSignedToken( "", AV9PeriodoLiq));
      web.GxWebStd.gx_hidden_field( httpContext, "PERIODOANIOMES", GXutil.ltrim( localUtil.ntoc( A2103PeriodoAnioMes, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV24Pgmname));
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
      return formatLink("web.periodo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.formatDateParm(AV9PeriodoLiq))}, new String[] {"Gx_mode","CliCod","EmpCod","PeriodoLiq"})  ;
   }

   public String getPgmname( )
   {
      return "Periodo" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Periodo", "") ;
   }

   public void initializeNonKey50233( )
   {
      A1735PeriodoCntLiq = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1735PeriodoCntLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1735PeriodoCntLiq), 4, 0));
      A1819PeriodoEstado = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1819PeriodoEstado", GXutil.str( A1819PeriodoEstado, 1, 0));
      A1730PeriodoAnio = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1730PeriodoAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1730PeriodoAnio), 4, 0));
      A1731PeriodoMes = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1731PeriodoMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1731PeriodoMes), 2, 0));
      A1732PeriodoDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1732PeriodoDescrip", A1732PeriodoDescrip);
      A2103PeriodoAnioMes = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2103PeriodoAnioMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2103PeriodoAnioMes), 6, 0));
      Z1730PeriodoAnio = (short)(0) ;
      Z1731PeriodoMes = (byte)(0) ;
      Z1732PeriodoDescrip = "" ;
      Z2103PeriodoAnioMes = 0 ;
   }

   public void initAll50233( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A1729PeriodoLiq = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
      initializeNonKey50233( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713575072", true, true);
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
      httpContext.AddJavascriptSource("periodo.js", "?20251713575072", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtPeriodoAnio_Internalname = "PERIODOANIO" ;
      cmbPeriodoMes.setInternalname( "PERIODOMES" );
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
      edtPeriodoLiq_Internalname = "PERIODOLIQ" ;
      edtPeriodoDescrip_Internalname = "PERIODODESCRIP" ;
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
      Form.setCaption( httpContext.getMessage( "Periodo", "") );
      edtPeriodoDescrip_Enabled = 1 ;
      edtPeriodoDescrip_Visible = 1 ;
      edtPeriodoLiq_Jsonclick = "" ;
      edtPeriodoLiq_Enabled = 1 ;
      edtPeriodoLiq_Visible = 1 ;
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
      cmbPeriodoMes.setJsonclick( "" );
      cmbPeriodoMes.setEnabled( 1 );
      edtPeriodoAnio_Jsonclick = "" ;
      edtPeriodoAnio_Enabled = 1 ;
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

   public void gx2asaperiodoestado50233( int A3CliCod ,
                                         short A1EmpCod ,
                                         java.util.Date A1729PeriodoLiq )
   {
      GXt_int6 = A1819PeriodoEstado ;
      GXv_int7[0] = GXt_int6 ;
      new web.getperiodoestado(remoteHandle, context).execute( A3CliCod, A1EmpCod, A1729PeriodoLiq, GXv_int7) ;
      periodo_impl.this.GXt_int6 = GXv_int7[0] ;
      A1819PeriodoEstado = GXt_int6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1819PeriodoEstado", GXutil.str( A1819PeriodoEstado, 1, 0));
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1819PeriodoEstado, (byte)(1), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx3asaperiodocntliq50233( int A3CliCod ,
                                         short A1EmpCod ,
                                         java.util.Date A1729PeriodoLiq )
   {
      GXt_int8 = A1735PeriodoCntLiq ;
      GXv_int9[0] = GXt_int8 ;
      new web.periodocantliq(remoteHandle, context).execute( A3CliCod, A1EmpCod, A1729PeriodoLiq, GXv_int9) ;
      periodo_impl.this.GXt_int8 = GXv_int9[0] ;
      A1735PeriodoCntLiq = GXt_int8 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1735PeriodoCntLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1735PeriodoCntLiq), 4, 0));
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1735PeriodoCntLiq, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx4asaclicod50233( int AV7CliCod )
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
            periodo_impl.this.GXt_int4 = GXv_int5[0] ;
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
      cmbPeriodoMes.setName( "PERIODOMES" );
      cmbPeriodoMes.setWebtags( "" );
      cmbPeriodoMes.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbPeriodoMes.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbPeriodoMes.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbPeriodoMes.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbPeriodoMes.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbPeriodoMes.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbPeriodoMes.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbPeriodoMes.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbPeriodoMes.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbPeriodoMes.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbPeriodoMes.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbPeriodoMes.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbPeriodoMes.getItemCount() > 0 )
      {
         A1731PeriodoMes = (byte)(GXutil.lval( cmbPeriodoMes.getValidValue(GXutil.trim( GXutil.str( A1731PeriodoMes, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1731PeriodoMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1731PeriodoMes), 2, 0));
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
      /* Using cursor T005015 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Periodoliq( )
   {
      GXt_int6 = A1819PeriodoEstado ;
      GXv_int7[0] = GXt_int6 ;
      new web.getperiodoestado(remoteHandle, context).execute( A3CliCod, A1EmpCod, A1729PeriodoLiq, GXv_int7) ;
      periodo_impl.this.GXt_int6 = GXv_int7[0] ;
      A1819PeriodoEstado = GXt_int6 ;
      GXt_int8 = A1735PeriodoCntLiq ;
      GXv_int9[0] = GXt_int8 ;
      new web.periodocantliq(remoteHandle, context).execute( A3CliCod, A1EmpCod, A1729PeriodoLiq, GXv_int9) ;
      periodo_impl.this.GXt_int8 = GXv_int9[0] ;
      A1735PeriodoCntLiq = GXt_int8 ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1819PeriodoEstado", GXutil.ltrim( localUtil.ntoc( A1819PeriodoEstado, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1735PeriodoCntLiq", GXutil.ltrim( localUtil.ntoc( A1735PeriodoCntLiq, (byte)(4), (byte)(0), ".", "")));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9PeriodoLiq',fld:'vPERIODOLIQ',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9PeriodoLiq',fld:'vPERIODOLIQ',pic:'',hsh:true},{av:'A2103PeriodoAnioMes',fld:'PERIODOANIOMES',pic:'ZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12502',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_PERIODOMES","{handler:'valid_Periodomes',iparms:[]");
      setEventMetadata("VALID_PERIODOMES",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_PERIODOLIQ","{handler:'valid_Periodoliq',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1729PeriodoLiq',fld:'PERIODOLIQ',pic:''},{av:'A1819PeriodoEstado',fld:'PERIODOESTADO',pic:'9'},{av:'A1735PeriodoCntLiq',fld:'PERIODOCNTLIQ',pic:'ZZZ9'}]");
      setEventMetadata("VALID_PERIODOLIQ",",oparms:[{av:'A1819PeriodoEstado',fld:'PERIODOESTADO',pic:'9'},{av:'A1735PeriodoCntLiq',fld:'PERIODOCNTLIQ',pic:'ZZZ9'}]}");
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
      wcpOAV9PeriodoLiq = GXutil.nullDate() ;
      Z1729PeriodoLiq = GXutil.nullDate() ;
      Z1732PeriodoDescrip = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A1729PeriodoLiq = GXutil.nullDate() ;
      Gx_mode = "" ;
      AV9PeriodoLiq = GXutil.nullDate() ;
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
      A1732PeriodoDescrip = "" ;
      AV24Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode233 = "" ;
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
      T00505_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      T00505_A1730PeriodoAnio = new short[1] ;
      T00505_A1731PeriodoMes = new byte[1] ;
      T00505_A1732PeriodoDescrip = new String[] {""} ;
      T00505_A2103PeriodoAnioMes = new int[1] ;
      T00505_A3CliCod = new int[1] ;
      T00505_A1EmpCod = new short[1] ;
      T00504_A3CliCod = new int[1] ;
      T00506_A3CliCod = new int[1] ;
      T00507_A3CliCod = new int[1] ;
      T00507_A1EmpCod = new short[1] ;
      T00507_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      T00503_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      T00503_A1730PeriodoAnio = new short[1] ;
      T00503_A1731PeriodoMes = new byte[1] ;
      T00503_A1732PeriodoDescrip = new String[] {""} ;
      T00503_A2103PeriodoAnioMes = new int[1] ;
      T00503_A3CliCod = new int[1] ;
      T00503_A1EmpCod = new short[1] ;
      T00508_A3CliCod = new int[1] ;
      T00508_A1EmpCod = new short[1] ;
      T00508_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      T00509_A3CliCod = new int[1] ;
      T00509_A1EmpCod = new short[1] ;
      T00509_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      T00502_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      T00502_A1730PeriodoAnio = new short[1] ;
      T00502_A1731PeriodoMes = new byte[1] ;
      T00502_A1732PeriodoDescrip = new String[] {""} ;
      T00502_A2103PeriodoAnioMes = new int[1] ;
      T00502_A3CliCod = new int[1] ;
      T00502_A1EmpCod = new short[1] ;
      T005013_A3CliCod = new int[1] ;
      T005013_A1EmpCod = new short[1] ;
      T005013_A31LiqNro = new int[1] ;
      T005014_A3CliCod = new int[1] ;
      T005014_A1EmpCod = new short[1] ;
      T005014_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXv_int5 = new int[1] ;
      T005015_A3CliCod = new int[1] ;
      GXv_int7 = new byte[1] ;
      GXv_int9 = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.periodo__default(),
         new Object[] {
             new Object[] {
            T00502_A1729PeriodoLiq, T00502_A1730PeriodoAnio, T00502_A1731PeriodoMes, T00502_A1732PeriodoDescrip, T00502_A2103PeriodoAnioMes, T00502_A3CliCod, T00502_A1EmpCod
            }
            , new Object[] {
            T00503_A1729PeriodoLiq, T00503_A1730PeriodoAnio, T00503_A1731PeriodoMes, T00503_A1732PeriodoDescrip, T00503_A2103PeriodoAnioMes, T00503_A3CliCod, T00503_A1EmpCod
            }
            , new Object[] {
            T00504_A3CliCod
            }
            , new Object[] {
            T00505_A1729PeriodoLiq, T00505_A1730PeriodoAnio, T00505_A1731PeriodoMes, T00505_A1732PeriodoDescrip, T00505_A2103PeriodoAnioMes, T00505_A3CliCod, T00505_A1EmpCod
            }
            , new Object[] {
            T00506_A3CliCod
            }
            , new Object[] {
            T00507_A3CliCod, T00507_A1EmpCod, T00507_A1729PeriodoLiq
            }
            , new Object[] {
            T00508_A3CliCod, T00508_A1EmpCod, T00508_A1729PeriodoLiq
            }
            , new Object[] {
            T00509_A3CliCod, T00509_A1EmpCod, T00509_A1729PeriodoLiq
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005013_A3CliCod, T005013_A1EmpCod, T005013_A31LiqNro
            }
            , new Object[] {
            T005014_A3CliCod, T005014_A1EmpCod, T005014_A1729PeriodoLiq
            }
            , new Object[] {
            T005015_A3CliCod
            }
         }
      );
      AV24Pgmname = "Periodo" ;
   }

   private byte Z1731PeriodoMes ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1731PeriodoMes ;
   private byte A1819PeriodoEstado ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private byte GXt_int6 ;
   private byte GXv_int7[] ;
   private byte Z1819PeriodoEstado ;
   private short wcpOAV8EmpCod ;
   private short Z1EmpCod ;
   private short Z1730PeriodoAnio ;
   private short A1EmpCod ;
   private short AV8EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1730PeriodoAnio ;
   private short A1735PeriodoCntLiq ;
   private short RcdFound233 ;
   private short nIsDirty_233 ;
   private short GXt_int8 ;
   private short GXv_int9[] ;
   private short Z1735PeriodoCntLiq ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z2103PeriodoAnioMes ;
   private int A3CliCod ;
   private int AV7CliCod ;
   private int trnEnded ;
   private int edtPeriodoAnio_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int edtPeriodoLiq_Visible ;
   private int edtPeriodoLiq_Enabled ;
   private int edtPeriodoDescrip_Visible ;
   private int edtPeriodoDescrip_Enabled ;
   private int A2103PeriodoAnioMes ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
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
   private String edtPeriodoAnio_Internalname ;
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
   private String edtPeriodoAnio_Jsonclick ;
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
   private String edtPeriodoLiq_Internalname ;
   private String edtPeriodoLiq_Jsonclick ;
   private String edtPeriodoDescrip_Internalname ;
   private String AV24Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode233 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date wcpOAV9PeriodoLiq ;
   private java.util.Date Z1729PeriodoLiq ;
   private java.util.Date A1729PeriodoLiq ;
   private java.util.Date AV9PeriodoLiq ;
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
   private boolean AV11IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String Z1732PeriodoDescrip ;
   private String A1732PeriodoDescrip ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbPeriodoMes ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] T00505_A1729PeriodoLiq ;
   private short[] T00505_A1730PeriodoAnio ;
   private byte[] T00505_A1731PeriodoMes ;
   private String[] T00505_A1732PeriodoDescrip ;
   private int[] T00505_A2103PeriodoAnioMes ;
   private int[] T00505_A3CliCod ;
   private short[] T00505_A1EmpCod ;
   private int[] T00504_A3CliCod ;
   private int[] T00506_A3CliCod ;
   private int[] T00507_A3CliCod ;
   private short[] T00507_A1EmpCod ;
   private java.util.Date[] T00507_A1729PeriodoLiq ;
   private java.util.Date[] T00503_A1729PeriodoLiq ;
   private short[] T00503_A1730PeriodoAnio ;
   private byte[] T00503_A1731PeriodoMes ;
   private String[] T00503_A1732PeriodoDescrip ;
   private int[] T00503_A2103PeriodoAnioMes ;
   private int[] T00503_A3CliCod ;
   private short[] T00503_A1EmpCod ;
   private int[] T00508_A3CliCod ;
   private short[] T00508_A1EmpCod ;
   private java.util.Date[] T00508_A1729PeriodoLiq ;
   private int[] T00509_A3CliCod ;
   private short[] T00509_A1EmpCod ;
   private java.util.Date[] T00509_A1729PeriodoLiq ;
   private java.util.Date[] T00502_A1729PeriodoLiq ;
   private short[] T00502_A1730PeriodoAnio ;
   private byte[] T00502_A1731PeriodoMes ;
   private String[] T00502_A1732PeriodoDescrip ;
   private int[] T00502_A2103PeriodoAnioMes ;
   private int[] T00502_A3CliCod ;
   private short[] T00502_A1EmpCod ;
   private int[] T005013_A3CliCod ;
   private short[] T005013_A1EmpCod ;
   private int[] T005013_A31LiqNro ;
   private int[] T005014_A3CliCod ;
   private short[] T005014_A1EmpCod ;
   private java.util.Date[] T005014_A1729PeriodoLiq ;
   private int[] T005015_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
}

final  class periodo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00502", "SELECT PeriodoLiq, PeriodoAnio, PeriodoMes, PeriodoDescrip, PeriodoAnioMes, CliCod, EmpCod FROM Periodo WHERE CliCod = ? AND EmpCod = ? AND PeriodoLiq = ?  FOR UPDATE OF Periodo NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00503", "SELECT PeriodoLiq, PeriodoAnio, PeriodoMes, PeriodoDescrip, PeriodoAnioMes, CliCod, EmpCod FROM Periodo WHERE CliCod = ? AND EmpCod = ? AND PeriodoLiq = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00504", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00505", "SELECT TM1.PeriodoLiq, TM1.PeriodoAnio, TM1.PeriodoMes, TM1.PeriodoDescrip, TM1.PeriodoAnioMes, TM1.CliCod, TM1.EmpCod FROM Periodo TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.PeriodoLiq = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.PeriodoLiq ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00506", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00507", "SELECT CliCod, EmpCod, PeriodoLiq FROM Periodo WHERE CliCod = ? AND EmpCod = ? AND PeriodoLiq = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00508", "SELECT CliCod, EmpCod, PeriodoLiq FROM Periodo WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and PeriodoLiq > ?) ORDER BY CliCod, EmpCod, PeriodoLiq  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00509", "SELECT CliCod, EmpCod, PeriodoLiq FROM Periodo WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and PeriodoLiq < ?) ORDER BY CliCod DESC, EmpCod DESC, PeriodoLiq DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005010", "SAVEPOINT gxupdate;INSERT INTO Periodo(PeriodoLiq, PeriodoAnio, PeriodoMes, PeriodoDescrip, PeriodoAnioMes, CliCod, EmpCod) VALUES(?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005011", "SAVEPOINT gxupdate;UPDATE Periodo SET PeriodoAnio=?, PeriodoMes=?, PeriodoDescrip=?, PeriodoAnioMes=?  WHERE CliCod = ? AND EmpCod = ? AND PeriodoLiq = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005012", "SAVEPOINT gxupdate;DELETE FROM Periodo  WHERE CliCod = ? AND EmpCod = ? AND PeriodoLiq = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005013", "SELECT CliCod, EmpCod, LiqNro FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND PeriodoLiq = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005014", "SELECT CliCod, EmpCod, PeriodoLiq FROM Periodo ORDER BY CliCod, EmpCod, PeriodoLiq ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005015", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               return;
            case 13 :
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
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
            case 8 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setDate(7, (java.util.Date)parms[6]);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

