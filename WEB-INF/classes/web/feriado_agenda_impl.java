package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class feriado_agenda_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"FERID") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlaferid3I243( A46PaiCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"PAICOD") == 0 )
      {
         AV7PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7PaiCod), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PaiCod), "ZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx1asapaicod3I243( AV7PaiCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_17") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1223FerId = httpContext.GetPar( "FerId") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_17( A46PaiCod, A1223FerId) ;
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
            AV8FerId = httpContext.GetPar( "FerId") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8FerId", AV8FerId);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFERID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8FerId, ""))));
            AV9FerAnio = (short)(GXutil.lval( httpContext.GetPar( "FerAnio"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9FerAnio), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFERANIO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9FerAnio), "ZZZ9")));
            AV15FerFecha = localUtil.parseDateParm( httpContext.GetPar( "FerFecha")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15FerFecha", localUtil.format(AV15FerFecha, "99/99/9999"));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFERFECHA", getSecureSignedToken( "", AV15FerFecha));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Feriado agenda", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = dynFerId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public feriado_agenda_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public feriado_agenda_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( feriado_agenda_impl.class ));
   }

   public feriado_agenda_impl( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynFerId = new HTMLChoice();
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
      if ( dynFerId.getItemCount() > 0 )
      {
         A1223FerId = dynFerId.getValidValue(A1223FerId) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynFerId.setValue( GXutil.rtrim( A1223FerId) );
         httpContext.ajax_rsp_assign_prop("", false, dynFerId.getInternalname(), "Values", dynFerId.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynFerId.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynFerId.getInternalname(), httpContext.getMessage( "Feriado", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynFerId, dynFerId.getInternalname(), GXutil.rtrim( A1223FerId), 1, dynFerId.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynFerId.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_feriado_agenda.htm");
      dynFerId.setValue( GXutil.rtrim( A1223FerId) );
      httpContext.ajax_rsp_assign_prop("", false, dynFerId.getInternalname(), "Values", dynFerId.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divFeranio_cell_Internalname, 1, 0, "px", 0, "px", divFeranio_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtFerAnio_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtFerAnio_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtFerAnio_Internalname, httpContext.getMessage( "Año", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtFerAnio_Internalname, GXutil.ltrim( localUtil.ntoc( A1226FerAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1226FerAnio), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFerAnio_Jsonclick, 0, "Attribute", "", "", "", "", edtFerAnio_Visible, edtFerAnio_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Anio", "right", false, "", "HLP_feriado_agenda.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtFerFecha_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtFerFecha_Internalname, httpContext.getMessage( "Fecha", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtFerFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtFerFecha_Internalname, localUtil.format(A1227FerFecha, "99/99/9999"), localUtil.format( A1227FerFecha, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFerFecha_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtFerFecha_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_feriado_agenda.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtFerFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtFerFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_feriado_agenda.htm");
      httpContext.writeTextNL( "</div>") ;
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_feriado_agenda.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_feriado_agenda.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_feriado_agenda.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiCod_Visible, edtPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_feriado_agenda.htm");
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
      e113I2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1223FerId = httpContext.cgiGet( "Z1223FerId") ;
            Z1226FerAnio = (short)(localUtil.ctol( httpContext.cgiGet( "Z1226FerAnio"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1227FerFecha = localUtil.ctod( httpContext.cgiGet( "Z1227FerFecha"), 0) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8FerId = httpContext.cgiGet( "vFERID") ;
            AV9FerAnio = (short)(localUtil.ctol( httpContext.cgiGet( "vFERANIO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV15FerFecha = localUtil.ctod( httpContext.cgiGet( "vFERFECHA"), 0) ;
            A1228FerDescrip = httpContext.cgiGet( "FERDESCRIP") ;
            A1230FerReligId = httpContext.cgiGet( "FERRELIGID") ;
            n1230FerReligId = false ;
            A1232FerOrigId = httpContext.cgiGet( "FERORIGID") ;
            n1232FerOrigId = false ;
            A1233FeriadoTipo = httpContext.cgiGet( "FERIADOTIPO") ;
            A1234FeriadoConvenio = httpContext.cgiGet( "FERIADOCONVENIO") ;
            n1234FeriadoConvenio = false ;
            AV16Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            dynFerId.setValue( httpContext.cgiGet( dynFerId.getInternalname()) );
            A1223FerId = httpContext.cgiGet( dynFerId.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtFerAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtFerAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "FERANIO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtFerAnio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1226FerAnio = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
            }
            else
            {
               A1226FerAnio = (short)(localUtil.ctol( httpContext.cgiGet( edtFerAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtFerFecha_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "FERFECHA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtFerFecha_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1227FerFecha = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A1227FerFecha", localUtil.format(A1227FerFecha, "99/99/9999"));
            }
            else
            {
               A1227FerFecha = localUtil.ctod( httpContext.cgiGet( edtFerFecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1227FerFecha", localUtil.format(A1227FerFecha, "99/99/9999"));
            }
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
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"feriado_agenda");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A1223FerId, Z1223FerId) != 0 ) || ( A1226FerAnio != Z1226FerAnio ) || !( GXutil.dateCompare(GXutil.resetTime(A1227FerFecha), GXutil.resetTime(Z1227FerFecha)) ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("feriado_agenda:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1223FerId = httpContext.GetPar( "FerId") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
               A1226FerAnio = (short)(GXutil.lval( httpContext.GetPar( "FerAnio"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
               A1227FerFecha = localUtil.parseDateParm( httpContext.GetPar( "FerFecha")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1227FerFecha", localUtil.format(A1227FerFecha, "99/99/9999"));
               getEqualNoModal( ) ;
               if ( ! (0==AV7PaiCod) )
               {
                  A46PaiCod = AV7PaiCod ;
                  httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               }
               else
               {
                  if ( isIns( )  )
                  {
                     GXt_int1 = A46PaiCod ;
                     GXt_int2 = A46PaiCod ;
                     GXv_int3[0] = GXt_int2 ;
                     new web.getclicod(remoteHandle, context).execute( GXv_int3) ;
                     feriado_agenda_impl.this.GXt_int2 = GXv_int3[0] ;
                     GXv_int4[0] = GXt_int1 ;
                     new web.clientegetpais(remoteHandle, context).execute( GXt_int2, GXv_int4) ;
                     feriado_agenda_impl.this.GXt_int1 = GXv_int4[0] ;
                     A46PaiCod = GXt_int1 ;
                     httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
                  }
               }
               if ( ! (0==AV9FerAnio) )
               {
                  A1226FerAnio = AV9FerAnio ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
               }
               else
               {
                  if ( isIns( )  )
                  {
                     A1226FerAnio = (short)(GXutil.year( A1227FerFecha)) ;
                     httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
                  }
               }
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode243 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  if ( ! (0==AV7PaiCod) )
                  {
                     A46PaiCod = AV7PaiCod ;
                     httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
                  }
                  else
                  {
                     if ( isIns( )  )
                     {
                        GXt_int1 = A46PaiCod ;
                        GXt_int2 = A46PaiCod ;
                        GXv_int3[0] = GXt_int2 ;
                        new web.getclicod(remoteHandle, context).execute( GXv_int3) ;
                        feriado_agenda_impl.this.GXt_int2 = GXv_int3[0] ;
                        GXv_int4[0] = GXt_int1 ;
                        new web.clientegetpais(remoteHandle, context).execute( GXt_int2, GXv_int4) ;
                        feriado_agenda_impl.this.GXt_int1 = GXv_int4[0] ;
                        A46PaiCod = GXt_int1 ;
                        httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
                     }
                  }
                  if ( ! (0==AV9FerAnio) )
                  {
                     A1226FerAnio = AV9FerAnio ;
                     httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
                  }
                  else
                  {
                     if ( isIns( )  )
                     {
                        A1226FerAnio = (short)(GXutil.year( A1227FerFecha)) ;
                        httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
                     }
                  }
                  Gx_mode = sMode243 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound243 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_3I0( ) ;
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
                        e113I2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e123I2 ();
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
         e123I2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll3I243( ) ;
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
         disableAttributes3I243( ) ;
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

   public void confirm_3I0( )
   {
      beforeValidate3I243( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls3I243( ) ;
         }
         else
         {
            checkExtendedTable3I243( ) ;
            closeExtendedTableCursors3I243( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption3I0( )
   {
   }

   public void e113I2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext5[0] = AV10WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV10WWPContext = GXv_SdtWWPContext5[0] ;
      AV11IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean6 = AV11IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWferiado_agenda_Insert", GXv_boolean7) ;
         feriado_agenda_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV11IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean6 = AV11IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWferiado_agenda_Update", GXv_boolean7) ;
         feriado_agenda_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV11IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean6 = AV11IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWferiado_agenda_Delete", GXv_boolean7) ;
         feriado_agenda_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV11IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV16Pgmname))}, new String[] {"GxObject"}) );
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
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
      edtPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Visible), 5, 0), true);
   }

   public void e123I2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.recalcularlegsuelbasicaporlegupd(remoteHandle, context).execute( A46PaiCod, 0, (short)(0), 0, httpContext.getMessage( "FERIADOS", "")) ;
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
      edtFerAnio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFerAnio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerAnio_Visible), 5, 0), true);
      divFeranio_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divFeranio_cell_Internalname, "Class", divFeranio_cell_Class, true);
   }

   public void zm3I243( int GX_JID )
   {
      if ( ( GX_JID == 16 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
         }
         else
         {
         }
      }
      if ( GX_JID == -16 )
      {
         Z1226FerAnio = A1226FerAnio ;
         Z1227FerFecha = A1227FerFecha ;
         Z46PaiCod = A46PaiCod ;
         Z1223FerId = A1223FerId ;
         Z1228FerDescrip = A1228FerDescrip ;
         Z1230FerReligId = A1230FerReligId ;
         Z1232FerOrigId = A1232FerOrigId ;
         Z1233FeriadoTipo = A1233FeriadoTipo ;
         Z1234FeriadoConvenio = A1234FeriadoConvenio ;
      }
   }

   public void standaloneNotModal( )
   {
      edtFerAnio_Visible = ((GXutil.strcmp(Gx_mode, "INS")!=0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtFerAnio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerAnio_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) ) )
      {
         divFeranio_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divFeranio_cell_Internalname, "Class", divFeranio_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
         {
            divFeranio_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divFeranio_cell_Internalname, "Class", divFeranio_cell_Class, true);
         }
      }
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
      if ( ! (GXutil.strcmp("", AV8FerId)==0) )
      {
         A1223FerId = AV8FerId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
      }
      if ( ! (GXutil.strcmp("", AV8FerId)==0) )
      {
         dynFerId.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynFerId.getInternalname(), "Enabled", GXutil.ltrimstr( dynFerId.getEnabled(), 5, 0), true);
      }
      else
      {
         dynFerId.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynFerId.getInternalname(), "Enabled", GXutil.ltrimstr( dynFerId.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8FerId)==0) )
      {
         dynFerId.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynFerId.getInternalname(), "Enabled", GXutil.ltrimstr( dynFerId.getEnabled(), 5, 0), true);
      }
      if ( ! (0==AV9FerAnio) )
      {
         edtFerAnio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFerAnio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerAnio_Enabled), 5, 0), true);
      }
      else
      {
         edtFerAnio_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFerAnio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerAnio_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9FerAnio) )
      {
         edtFerAnio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFerAnio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerAnio_Enabled), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV15FerFecha)) )
      {
         A1227FerFecha = AV15FerFecha ;
         httpContext.ajax_rsp_assign_attri("", false, "A1227FerFecha", localUtil.format(A1227FerFecha, "99/99/9999"));
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV15FerFecha)) )
      {
         edtFerFecha_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFerFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerFecha_Enabled), 5, 0), true);
      }
      else
      {
         edtFerFecha_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFerFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerFecha_Enabled), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV15FerFecha)) )
      {
         edtFerFecha_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFerFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerFecha_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ! (0==AV7PaiCod) )
      {
         A46PaiCod = AV7PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      else
      {
         if ( isIns( )  )
         {
            GXt_int1 = A46PaiCod ;
            GXt_int2 = A46PaiCod ;
            GXv_int3[0] = GXt_int2 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int3) ;
            feriado_agenda_impl.this.GXt_int2 = GXv_int3[0] ;
            GXv_int4[0] = GXt_int1 ;
            new web.clientegetpais(remoteHandle, context).execute( GXt_int2, GXv_int4) ;
            feriado_agenda_impl.this.GXt_int1 = GXv_int4[0] ;
            A46PaiCod = GXt_int1 ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         }
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
         AV16Pgmname = "feriado_agenda" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
         /* Using cursor T003I4 */
         pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod), A1223FerId});
         A1228FerDescrip = T003I4_A1228FerDescrip[0] ;
         A1230FerReligId = T003I4_A1230FerReligId[0] ;
         n1230FerReligId = T003I4_n1230FerReligId[0] ;
         A1232FerOrigId = T003I4_A1232FerOrigId[0] ;
         n1232FerOrigId = T003I4_n1232FerOrigId[0] ;
         A1233FeriadoTipo = T003I4_A1233FeriadoTipo[0] ;
         A1234FeriadoConvenio = T003I4_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = T003I4_n1234FeriadoConvenio[0] ;
         pr_default.close(2);
         gxaferid_html3I243( A46PaiCod) ;
      }
   }

   public void load3I243( )
   {
      /* Using cursor T003I5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A46PaiCod), A1223FerId, Short.valueOf(A1226FerAnio), A1227FerFecha});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound243 = (short)(1) ;
         A1228FerDescrip = T003I5_A1228FerDescrip[0] ;
         A1230FerReligId = T003I5_A1230FerReligId[0] ;
         n1230FerReligId = T003I5_n1230FerReligId[0] ;
         A1232FerOrigId = T003I5_A1232FerOrigId[0] ;
         n1232FerOrigId = T003I5_n1232FerOrigId[0] ;
         A1233FeriadoTipo = T003I5_A1233FeriadoTipo[0] ;
         A1234FeriadoConvenio = T003I5_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = T003I5_n1234FeriadoConvenio[0] ;
         zm3I243( -16) ;
      }
      pr_default.close(3);
      onLoadActions3I243( ) ;
   }

   public void onLoadActions3I243( )
   {
      AV16Pgmname = "feriado_agenda" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      gxaferid_html3I243( A46PaiCod) ;
      if ( ! (0==AV9FerAnio) )
      {
         A1226FerAnio = AV9FerAnio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
      }
      else
      {
         if ( isIns( )  )
         {
            A1226FerAnio = (short)(GXutil.year( A1227FerFecha)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
         }
      }
   }

   public void checkExtendedTable3I243( )
   {
      nIsDirty_243 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV16Pgmname = "feriado_agenda" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      gxaferid_html3I243( A46PaiCod) ;
      /* Using cursor T003I4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod), A1223FerId});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "feriado", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "FERID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1228FerDescrip = T003I4_A1228FerDescrip[0] ;
      A1230FerReligId = T003I4_A1230FerReligId[0] ;
      n1230FerReligId = T003I4_n1230FerReligId[0] ;
      A1232FerOrigId = T003I4_A1232FerOrigId[0] ;
      n1232FerOrigId = T003I4_n1232FerOrigId[0] ;
      A1233FeriadoTipo = T003I4_A1233FeriadoTipo[0] ;
      A1234FeriadoConvenio = T003I4_A1234FeriadoConvenio[0] ;
      n1234FeriadoConvenio = T003I4_n1234FeriadoConvenio[0] ;
      pr_default.close(2);
      if ( ! (0==AV9FerAnio) )
      {
         nIsDirty_243 = (short)(1) ;
         A1226FerAnio = AV9FerAnio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
      }
      else
      {
         if ( isIns( )  )
         {
            nIsDirty_243 = (short)(1) ;
            A1226FerAnio = (short)(GXutil.year( A1227FerFecha)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
         }
      }
   }

   public void closeExtendedTableCursors3I243( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_17( short A46PaiCod ,
                          String A1223FerId )
   {
      /* Using cursor T003I6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A46PaiCod), A1223FerId});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "feriado", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "FERID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1228FerDescrip = T003I6_A1228FerDescrip[0] ;
      A1230FerReligId = T003I6_A1230FerReligId[0] ;
      n1230FerReligId = T003I6_n1230FerReligId[0] ;
      A1232FerOrigId = T003I6_A1232FerOrigId[0] ;
      n1232FerOrigId = T003I6_n1232FerOrigId[0] ;
      A1233FeriadoTipo = T003I6_A1233FeriadoTipo[0] ;
      A1234FeriadoConvenio = T003I6_A1234FeriadoConvenio[0] ;
      n1234FeriadoConvenio = T003I6_n1234FeriadoConvenio[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1228FerDescrip)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A1230FerReligId))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A1232FerOrigId))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A1233FeriadoTipo))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A1234FeriadoConvenio))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey3I243( )
   {
      /* Using cursor T003I7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A46PaiCod), A1223FerId, Short.valueOf(A1226FerAnio), A1227FerFecha});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound243 = (short)(1) ;
      }
      else
      {
         RcdFound243 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T003I3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), A1223FerId, Short.valueOf(A1226FerAnio), A1227FerFecha});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm3I243( 16) ;
         RcdFound243 = (short)(1) ;
         A1226FerAnio = T003I3_A1226FerAnio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
         A1227FerFecha = T003I3_A1227FerFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1227FerFecha", localUtil.format(A1227FerFecha, "99/99/9999"));
         A46PaiCod = T003I3_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1223FerId = T003I3_A1223FerId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
         Z46PaiCod = A46PaiCod ;
         Z1223FerId = A1223FerId ;
         Z1226FerAnio = A1226FerAnio ;
         Z1227FerFecha = A1227FerFecha ;
         sMode243 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load3I243( ) ;
         if ( AnyError == 1 )
         {
            RcdFound243 = (short)(0) ;
            initializeNonKey3I243( ) ;
         }
         Gx_mode = sMode243 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound243 = (short)(0) ;
         initializeNonKey3I243( ) ;
         sMode243 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode243 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey3I243( ) ;
      if ( RcdFound243 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound243 = (short)(0) ;
      /* Using cursor T003I8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), A1223FerId, A1223FerId, Short.valueOf(A46PaiCod), Short.valueOf(A1226FerAnio), Short.valueOf(A1226FerAnio), A1223FerId, Short.valueOf(A46PaiCod), A1227FerFecha});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T003I8_A46PaiCod[0] < A46PaiCod ) || ( T003I8_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T003I8_A1223FerId[0], A1223FerId) < 0 ) || ( GXutil.strcmp(T003I8_A1223FerId[0], A1223FerId) == 0 ) && ( T003I8_A46PaiCod[0] == A46PaiCod ) && ( T003I8_A1226FerAnio[0] < A1226FerAnio ) || ( T003I8_A1226FerAnio[0] == A1226FerAnio ) && ( GXutil.strcmp(T003I8_A1223FerId[0], A1223FerId) == 0 ) && ( T003I8_A46PaiCod[0] == A46PaiCod ) && GXutil.resetTime(T003I8_A1227FerFecha[0]).before( GXutil.resetTime( A1227FerFecha )) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T003I8_A46PaiCod[0] > A46PaiCod ) || ( T003I8_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T003I8_A1223FerId[0], A1223FerId) > 0 ) || ( GXutil.strcmp(T003I8_A1223FerId[0], A1223FerId) == 0 ) && ( T003I8_A46PaiCod[0] == A46PaiCod ) && ( T003I8_A1226FerAnio[0] > A1226FerAnio ) || ( T003I8_A1226FerAnio[0] == A1226FerAnio ) && ( GXutil.strcmp(T003I8_A1223FerId[0], A1223FerId) == 0 ) && ( T003I8_A46PaiCod[0] == A46PaiCod ) && GXutil.resetTime(T003I8_A1227FerFecha[0]).after( GXutil.resetTime( A1227FerFecha )) ) )
         {
            A46PaiCod = T003I8_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A1223FerId = T003I8_A1223FerId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
            A1226FerAnio = T003I8_A1226FerAnio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
            A1227FerFecha = T003I8_A1227FerFecha[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1227FerFecha", localUtil.format(A1227FerFecha, "99/99/9999"));
            RcdFound243 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound243 = (short)(0) ;
      /* Using cursor T003I9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), A1223FerId, A1223FerId, Short.valueOf(A46PaiCod), Short.valueOf(A1226FerAnio), Short.valueOf(A1226FerAnio), A1223FerId, Short.valueOf(A46PaiCod), A1227FerFecha});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T003I9_A46PaiCod[0] > A46PaiCod ) || ( T003I9_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T003I9_A1223FerId[0], A1223FerId) > 0 ) || ( GXutil.strcmp(T003I9_A1223FerId[0], A1223FerId) == 0 ) && ( T003I9_A46PaiCod[0] == A46PaiCod ) && ( T003I9_A1226FerAnio[0] > A1226FerAnio ) || ( T003I9_A1226FerAnio[0] == A1226FerAnio ) && ( GXutil.strcmp(T003I9_A1223FerId[0], A1223FerId) == 0 ) && ( T003I9_A46PaiCod[0] == A46PaiCod ) && GXutil.resetTime(T003I9_A1227FerFecha[0]).after( GXutil.resetTime( A1227FerFecha )) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T003I9_A46PaiCod[0] < A46PaiCod ) || ( T003I9_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T003I9_A1223FerId[0], A1223FerId) < 0 ) || ( GXutil.strcmp(T003I9_A1223FerId[0], A1223FerId) == 0 ) && ( T003I9_A46PaiCod[0] == A46PaiCod ) && ( T003I9_A1226FerAnio[0] < A1226FerAnio ) || ( T003I9_A1226FerAnio[0] == A1226FerAnio ) && ( GXutil.strcmp(T003I9_A1223FerId[0], A1223FerId) == 0 ) && ( T003I9_A46PaiCod[0] == A46PaiCod ) && GXutil.resetTime(T003I9_A1227FerFecha[0]).before( GXutil.resetTime( A1227FerFecha )) ) )
         {
            A46PaiCod = T003I9_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A1223FerId = T003I9_A1223FerId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
            A1226FerAnio = T003I9_A1226FerAnio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
            A1227FerFecha = T003I9_A1227FerFecha[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1227FerFecha", localUtil.format(A1227FerFecha, "99/99/9999"));
            RcdFound243 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey3I243( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = dynFerId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert3I243( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound243 == 1 )
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A1223FerId, Z1223FerId) != 0 ) || ( A1226FerAnio != Z1226FerAnio ) || !( GXutil.dateCompare(GXutil.resetTime(A1227FerFecha), GXutil.resetTime(Z1227FerFecha)) ) )
            {
               A46PaiCod = Z46PaiCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A1223FerId = Z1223FerId ;
               httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
               A1226FerAnio = Z1226FerAnio ;
               httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
               A1227FerFecha = Z1227FerFecha ;
               httpContext.ajax_rsp_assign_attri("", false, "A1227FerFecha", localUtil.format(A1227FerFecha, "99/99/9999"));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = dynFerId.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update3I243( ) ;
               GX_FocusControl = dynFerId.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A1223FerId, Z1223FerId) != 0 ) || ( A1226FerAnio != Z1226FerAnio ) || !( GXutil.dateCompare(GXutil.resetTime(A1227FerFecha), GXutil.resetTime(Z1227FerFecha)) ) )
            {
               /* Insert record */
               GX_FocusControl = dynFerId.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert3I243( ) ;
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
                  GX_FocusControl = dynFerId.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert3I243( ) ;
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
      if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A1223FerId, Z1223FerId) != 0 ) || ( A1226FerAnio != Z1226FerAnio ) || !( GXutil.dateCompare(GXutil.resetTime(A1227FerFecha), GXutil.resetTime(Z1227FerFecha)) ) )
      {
         A46PaiCod = Z46PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1223FerId = Z1223FerId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
         A1226FerAnio = Z1226FerAnio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
         A1227FerFecha = Z1227FerFecha ;
         httpContext.ajax_rsp_assign_attri("", false, "A1227FerFecha", localUtil.format(A1227FerFecha, "99/99/9999"));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = dynFerId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency3I243( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T003I2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A1223FerId, Short.valueOf(A1226FerAnio), A1227FerFecha});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"feriado_agenda"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"feriado_agenda"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert3I243( )
   {
      beforeValidate3I243( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3I243( ) ;
      }
      if ( AnyError == 0 )
      {
         zm3I243( 0) ;
         checkOptimisticConcurrency3I243( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3I243( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert3I243( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003I10 */
                  pr_default.execute(8, new Object[] {Short.valueOf(A1226FerAnio), A1227FerFecha, Short.valueOf(A46PaiCod), A1223FerId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("feriado_agenda");
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
                        resetCaption3I0( ) ;
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
            load3I243( ) ;
         }
         endLevel3I243( ) ;
      }
      closeExtendedTableCursors3I243( ) ;
   }

   public void update3I243( )
   {
      beforeValidate3I243( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3I243( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3I243( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3I243( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate3I243( ) ;
               if ( AnyError == 0 )
               {
                  /* No attributes to update on table feriado_agenda */
                  deferredUpdate3I243( ) ;
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
         endLevel3I243( ) ;
      }
      closeExtendedTableCursors3I243( ) ;
   }

   public void deferredUpdate3I243( )
   {
   }

   public void delete( )
   {
      beforeValidate3I243( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3I243( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls3I243( ) ;
         afterConfirm3I243( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete3I243( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T003I11 */
               pr_default.execute(9, new Object[] {Short.valueOf(A46PaiCod), A1223FerId, Short.valueOf(A1226FerAnio), A1227FerFecha});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("feriado_agenda");
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
      sMode243 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel3I243( ) ;
      Gx_mode = sMode243 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls3I243( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV16Pgmname = "feriado_agenda" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
         gxaferid_html3I243( A46PaiCod) ;
         /* Using cursor T003I12 */
         pr_default.execute(10, new Object[] {Short.valueOf(A46PaiCod), A1223FerId});
         A1228FerDescrip = T003I12_A1228FerDescrip[0] ;
         A1230FerReligId = T003I12_A1230FerReligId[0] ;
         n1230FerReligId = T003I12_n1230FerReligId[0] ;
         A1232FerOrigId = T003I12_A1232FerOrigId[0] ;
         n1232FerOrigId = T003I12_n1232FerOrigId[0] ;
         A1233FeriadoTipo = T003I12_A1233FeriadoTipo[0] ;
         A1234FeriadoConvenio = T003I12_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = T003I12_n1234FeriadoConvenio[0] ;
         pr_default.close(10);
      }
   }

   public void endLevel3I243( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete3I243( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "feriado_agenda");
         if ( AnyError == 0 )
         {
            confirmValues3I0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "feriado_agenda");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart3I243( )
   {
      /* Scan By routine */
      /* Using cursor T003I13 */
      pr_default.execute(11);
      RcdFound243 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound243 = (short)(1) ;
         A46PaiCod = T003I13_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1223FerId = T003I13_A1223FerId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
         A1226FerAnio = T003I13_A1226FerAnio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
         A1227FerFecha = T003I13_A1227FerFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1227FerFecha", localUtil.format(A1227FerFecha, "99/99/9999"));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext3I243( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound243 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound243 = (short)(1) ;
         A46PaiCod = T003I13_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A1223FerId = T003I13_A1223FerId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
         A1226FerAnio = T003I13_A1226FerAnio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
         A1227FerFecha = T003I13_A1227FerFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1227FerFecha", localUtil.format(A1227FerFecha, "99/99/9999"));
      }
   }

   public void scanEnd3I243( )
   {
      pr_default.close(11);
   }

   public void afterConfirm3I243( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert3I243( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate3I243( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete3I243( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete3I243( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate3I243( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes3I243( )
   {
      dynFerId.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynFerId.getInternalname(), "Enabled", GXutil.ltrimstr( dynFerId.getEnabled(), 5, 0), true);
      edtFerAnio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFerAnio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerAnio_Enabled), 5, 0), true);
      edtFerFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFerFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFerFecha_Enabled), 5, 0), true);
      edtPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes3I243( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues3I0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.feriado_agenda", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV8FerId)),GXutil.URLEncode(GXutil.ltrimstr(AV9FerAnio,4,0)),GXutil.URLEncode(GXutil.formatDateParm(AV15FerFecha))}, new String[] {"Gx_mode","PaiCod","FerId","FerAnio","FerFecha"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"feriado_agenda");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("feriado_agenda:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z46PaiCod", GXutil.ltrim( localUtil.ntoc( Z46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1223FerId", GXutil.rtrim( Z1223FerId));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1226FerAnio", GXutil.ltrim( localUtil.ntoc( Z1226FerAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1227FerFecha", localUtil.dtoc( Z1227FerFecha, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV7PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vFERID", GXutil.rtrim( AV8FerId));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFERID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8FerId, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vFERANIO", GXutil.ltrim( localUtil.ntoc( AV9FerAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFERANIO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9FerAnio), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vFERFECHA", localUtil.dtoc( AV15FerFecha, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFERFECHA", getSecureSignedToken( "", AV15FerFecha));
      web.GxWebStd.gx_hidden_field( httpContext, "FERDESCRIP", A1228FerDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "FERRELIGID", GXutil.rtrim( A1230FerReligId));
      web.GxWebStd.gx_hidden_field( httpContext, "FERORIGID", GXutil.rtrim( A1232FerOrigId));
      web.GxWebStd.gx_hidden_field( httpContext, "FERIADOTIPO", GXutil.rtrim( A1233FeriadoTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "FERIADOCONVENIO", GXutil.rtrim( A1234FeriadoConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV16Pgmname));
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
      return formatLink("web.feriado_agenda", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV8FerId)),GXutil.URLEncode(GXutil.ltrimstr(AV9FerAnio,4,0)),GXutil.URLEncode(GXutil.formatDateParm(AV15FerFecha))}, new String[] {"Gx_mode","PaiCod","FerId","FerAnio","FerFecha"})  ;
   }

   public String getPgmname( )
   {
      return "feriado_agenda" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Feriado agenda", "") ;
   }

   public void initializeNonKey3I243( )
   {
      A1228FerDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1228FerDescrip", A1228FerDescrip);
      A1230FerReligId = "" ;
      n1230FerReligId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1230FerReligId", A1230FerReligId);
      A1232FerOrigId = "" ;
      n1232FerOrigId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1232FerOrigId", A1232FerOrigId);
      A1234FeriadoConvenio = "" ;
      n1234FeriadoConvenio = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1234FeriadoConvenio", A1234FeriadoConvenio);
      A1233FeriadoTipo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1233FeriadoTipo", A1233FeriadoTipo);
   }

   public void initAll3I243( )
   {
      A46PaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A1223FerId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", A1223FerId);
      A1226FerAnio = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1226FerAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1226FerAnio), 4, 0));
      A1227FerFecha = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A1227FerFecha", localUtil.format(A1227FerFecha, "99/99/9999"));
      initializeNonKey3I243( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713394878", true, true);
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
      httpContext.AddJavascriptSource("feriado_agenda.js", "?20251713394878", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      dynFerId.setInternalname( "FERID" );
      edtFerAnio_Internalname = "FERANIO" ;
      divFeranio_cell_Internalname = "FERANIO_CELL" ;
      edtFerFecha_Internalname = "FERFECHA" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtPaiCod_Internalname = "PAICOD" ;
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
      Form.setCaption( httpContext.getMessage( "Feriado agenda", "") );
      edtPaiCod_Jsonclick = "" ;
      edtPaiCod_Enabled = 1 ;
      edtPaiCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtFerFecha_Jsonclick = "" ;
      edtFerFecha_Enabled = 1 ;
      edtFerAnio_Jsonclick = "" ;
      edtFerAnio_Enabled = 1 ;
      edtFerAnio_Visible = 1 ;
      divFeranio_cell_Class = "col-xs-12" ;
      dynFerId.setJsonclick( "" );
      dynFerId.setEnabled( 1 );
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
      gxaferid_html3I243( A46PaiCod) ;
      /* End function dynload_actions */
   }

   public void gxdlaferid3I243( short A46PaiCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaferid_data3I243( A46PaiCod) ;
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

   public void gxaferid_html3I243( short A46PaiCod )
   {
      String gxdynajaxvalue;
      gxdlaferid_data3I243( A46PaiCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynFerId.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynFerId.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaferid_data3I243( short A46PaiCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T003I14 */
      pr_default.execute(12, new Object[] {Short.valueOf(A46PaiCod)});
      while ( (pr_default.getStatus(12) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T003I14_A1223FerId[0]));
         gxdynajaxctrldescr.add(T003I14_A1228FerDescrip[0]);
         pr_default.readNext(12);
      }
      pr_default.close(12);
   }

   public void gx1asapaicod3I243( short AV7PaiCod )
   {
      if ( ! (0==AV7PaiCod) )
      {
         A46PaiCod = AV7PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      else
      {
         if ( isIns( )  )
         {
            GXt_int1 = A46PaiCod ;
            GXt_int2 = A46PaiCod ;
            GXv_int3[0] = GXt_int2 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int3) ;
            feriado_agenda_impl.this.GXt_int2 = GXv_int3[0] ;
            GXv_int4[0] = GXt_int1 ;
            new web.clientegetpais(remoteHandle, context).execute( GXt_int2, GXv_int4) ;
            feriado_agenda_impl.this.GXt_int1 = GXv_int4[0] ;
            A46PaiCod = GXt_int1 ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), ".", "")))+"\"") ;
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
      dynFerId.setName( "FERID" );
      dynFerId.setWebtags( "" );
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
      A1223FerId = dynFerId.getValue() ;
      n1230FerReligId = false ;
      n1232FerOrigId = false ;
      n1234FeriadoConvenio = false ;
      /* Using cursor T003I15 */
      pr_default.execute(13, new Object[] {Short.valueOf(A46PaiCod), A1223FerId});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "feriado", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "FERID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
      }
      A1228FerDescrip = T003I15_A1228FerDescrip[0] ;
      A1230FerReligId = T003I15_A1230FerReligId[0] ;
      n1230FerReligId = T003I15_n1230FerReligId[0] ;
      A1232FerOrigId = T003I15_A1232FerOrigId[0] ;
      n1232FerOrigId = T003I15_n1232FerOrigId[0] ;
      A1233FeriadoTipo = T003I15_A1233FeriadoTipo[0] ;
      A1234FeriadoConvenio = T003I15_A1234FeriadoConvenio[0] ;
      n1234FeriadoConvenio = T003I15_n1234FeriadoConvenio[0] ;
      pr_default.close(13);
      gxaferid_html3I243( A46PaiCod) ;
      dynload_actions( ) ;
      if ( dynFerId.getItemCount() > 0 )
      {
         A1223FerId = dynFerId.getValidValue(A1223FerId) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynFerId.setValue( GXutil.rtrim( A1223FerId) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1228FerDescrip", A1228FerDescrip);
      httpContext.ajax_rsp_assign_attri("", false, "A1230FerReligId", GXutil.rtrim( A1230FerReligId));
      httpContext.ajax_rsp_assign_attri("", false, "A1232FerOrigId", GXutil.rtrim( A1232FerOrigId));
      httpContext.ajax_rsp_assign_attri("", false, "A1233FeriadoTipo", GXutil.rtrim( A1233FeriadoTipo));
      httpContext.ajax_rsp_assign_attri("", false, "A1234FeriadoConvenio", GXutil.rtrim( A1234FeriadoConvenio));
      httpContext.ajax_rsp_assign_attri("", false, "A1223FerId", GXutil.rtrim( A1223FerId));
      dynFerId.setValue( GXutil.rtrim( A1223FerId) );
      httpContext.ajax_rsp_assign_prop("", false, dynFerId.getInternalname(), "Values", dynFerId.ToJavascriptSource(), true);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV8FerId',fld:'vFERID',pic:'',hsh:true},{av:'AV9FerAnio',fld:'vFERANIO',pic:'ZZZ9',hsh:true},{av:'AV15FerFecha',fld:'vFERFECHA',pic:'',hsh:true},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFerId'},{av:'A1223FerId',fld:'FERID',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFerId'},{av:'A1223FerId',fld:'FERID',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV8FerId',fld:'vFERID',pic:'',hsh:true},{av:'AV9FerAnio',fld:'vFERANIO',pic:'ZZZ9',hsh:true},{av:'AV15FerFecha',fld:'vFERFECHA',pic:'',hsh:true},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFerId'},{av:'A1223FerId',fld:'FERID',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFerId'},{av:'A1223FerId',fld:'FERID',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e123I2',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFerId'},{av:'A1223FerId',fld:'FERID',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFerId'},{av:'A1223FerId',fld:'FERID',pic:''}]}");
      setEventMetadata("VALID_FERID","{handler:'valid_Ferid',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFerId'},{av:'A1223FerId',fld:'FERID',pic:''}]");
      setEventMetadata("VALID_FERID",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFerId'},{av:'A1223FerId',fld:'FERID',pic:''}]}");
      setEventMetadata("VALID_FERANIO","{handler:'valid_Feranio',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFerId'},{av:'A1223FerId',fld:'FERID',pic:''}]");
      setEventMetadata("VALID_FERANIO",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFerId'},{av:'A1223FerId',fld:'FERID',pic:''}]}");
      setEventMetadata("VALID_FERFECHA","{handler:'valid_Ferfecha',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFerId'},{av:'A1223FerId',fld:'FERID',pic:''}]");
      setEventMetadata("VALID_FERFECHA",",oparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFerId'},{av:'A1223FerId',fld:'FERID',pic:''}]}");
      setEventMetadata("VALID_PAICOD","{handler:'valid_Paicod',iparms:[{av:'A1228FerDescrip',fld:'FERDESCRIP',pic:''},{av:'A1230FerReligId',fld:'FERRELIGID',pic:''},{av:'A1232FerOrigId',fld:'FERORIGID',pic:''},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''},{av:'A1234FeriadoConvenio',fld:'FERIADOCONVENIO',pic:''},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFerId'},{av:'A1223FerId',fld:'FERID',pic:''}]");
      setEventMetadata("VALID_PAICOD",",oparms:[{av:'A1228FerDescrip',fld:'FERDESCRIP',pic:''},{av:'A1230FerReligId',fld:'FERRELIGID',pic:''},{av:'A1232FerOrigId',fld:'FERORIGID',pic:''},{av:'A1233FeriadoTipo',fld:'FERIADOTIPO',pic:''},{av:'A1234FeriadoConvenio',fld:'FERIADOCONVENIO',pic:''},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'dynFerId'},{av:'A1223FerId',fld:'FERID',pic:''}]}");
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
      pr_default.close(10);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV8FerId = "" ;
      wcpOAV15FerFecha = GXutil.nullDate() ;
      Z1223FerId = "" ;
      Z1227FerFecha = GXutil.nullDate() ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A1223FerId = "" ;
      Gx_mode = "" ;
      AV8FerId = "" ;
      AV15FerFecha = GXutil.nullDate() ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A1227FerFecha = GXutil.nullDate() ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A1228FerDescrip = "" ;
      A1230FerReligId = "" ;
      A1232FerOrigId = "" ;
      A1233FeriadoTipo = "" ;
      A1234FeriadoConvenio = "" ;
      AV16Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode243 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean7 = new boolean[1] ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      Z1228FerDescrip = "" ;
      Z1230FerReligId = "" ;
      Z1232FerOrigId = "" ;
      Z1233FeriadoTipo = "" ;
      Z1234FeriadoConvenio = "" ;
      T003I4_A1228FerDescrip = new String[] {""} ;
      T003I4_A1230FerReligId = new String[] {""} ;
      T003I4_n1230FerReligId = new boolean[] {false} ;
      T003I4_A1232FerOrigId = new String[] {""} ;
      T003I4_n1232FerOrigId = new boolean[] {false} ;
      T003I4_A1233FeriadoTipo = new String[] {""} ;
      T003I4_A1234FeriadoConvenio = new String[] {""} ;
      T003I4_n1234FeriadoConvenio = new boolean[] {false} ;
      T003I5_A1226FerAnio = new short[1] ;
      T003I5_A1227FerFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T003I5_A1228FerDescrip = new String[] {""} ;
      T003I5_A46PaiCod = new short[1] ;
      T003I5_A1223FerId = new String[] {""} ;
      T003I5_A1230FerReligId = new String[] {""} ;
      T003I5_n1230FerReligId = new boolean[] {false} ;
      T003I5_A1232FerOrigId = new String[] {""} ;
      T003I5_n1232FerOrigId = new boolean[] {false} ;
      T003I5_A1233FeriadoTipo = new String[] {""} ;
      T003I5_A1234FeriadoConvenio = new String[] {""} ;
      T003I5_n1234FeriadoConvenio = new boolean[] {false} ;
      T003I6_A1228FerDescrip = new String[] {""} ;
      T003I6_A1230FerReligId = new String[] {""} ;
      T003I6_n1230FerReligId = new boolean[] {false} ;
      T003I6_A1232FerOrigId = new String[] {""} ;
      T003I6_n1232FerOrigId = new boolean[] {false} ;
      T003I6_A1233FeriadoTipo = new String[] {""} ;
      T003I6_A1234FeriadoConvenio = new String[] {""} ;
      T003I6_n1234FeriadoConvenio = new boolean[] {false} ;
      T003I7_A46PaiCod = new short[1] ;
      T003I7_A1223FerId = new String[] {""} ;
      T003I7_A1226FerAnio = new short[1] ;
      T003I7_A1227FerFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T003I3_A1226FerAnio = new short[1] ;
      T003I3_A1227FerFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T003I3_A46PaiCod = new short[1] ;
      T003I3_A1223FerId = new String[] {""} ;
      T003I8_A46PaiCod = new short[1] ;
      T003I8_A1223FerId = new String[] {""} ;
      T003I8_A1226FerAnio = new short[1] ;
      T003I8_A1227FerFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T003I9_A46PaiCod = new short[1] ;
      T003I9_A1223FerId = new String[] {""} ;
      T003I9_A1226FerAnio = new short[1] ;
      T003I9_A1227FerFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T003I2_A1226FerAnio = new short[1] ;
      T003I2_A1227FerFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T003I2_A46PaiCod = new short[1] ;
      T003I2_A1223FerId = new String[] {""} ;
      T003I12_A1228FerDescrip = new String[] {""} ;
      T003I12_A1230FerReligId = new String[] {""} ;
      T003I12_n1230FerReligId = new boolean[] {false} ;
      T003I12_A1232FerOrigId = new String[] {""} ;
      T003I12_n1232FerOrigId = new boolean[] {false} ;
      T003I12_A1233FeriadoTipo = new String[] {""} ;
      T003I12_A1234FeriadoConvenio = new String[] {""} ;
      T003I12_n1234FeriadoConvenio = new boolean[] {false} ;
      T003I13_A46PaiCod = new short[1] ;
      T003I13_A1223FerId = new String[] {""} ;
      T003I13_A1226FerAnio = new short[1] ;
      T003I13_A1227FerFecha = new java.util.Date[] {GXutil.nullDate()} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T003I14_A46PaiCod = new short[1] ;
      T003I14_A1223FerId = new String[] {""} ;
      T003I14_A1228FerDescrip = new String[] {""} ;
      GXv_int3 = new int[1] ;
      GXv_int4 = new short[1] ;
      T003I15_A1228FerDescrip = new String[] {""} ;
      T003I15_A1230FerReligId = new String[] {""} ;
      T003I15_n1230FerReligId = new boolean[] {false} ;
      T003I15_A1232FerOrigId = new String[] {""} ;
      T003I15_n1232FerOrigId = new boolean[] {false} ;
      T003I15_A1233FeriadoTipo = new String[] {""} ;
      T003I15_A1234FeriadoConvenio = new String[] {""} ;
      T003I15_n1234FeriadoConvenio = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.feriado_agenda__default(),
         new Object[] {
             new Object[] {
            T003I2_A1226FerAnio, T003I2_A1227FerFecha, T003I2_A46PaiCod, T003I2_A1223FerId
            }
            , new Object[] {
            T003I3_A1226FerAnio, T003I3_A1227FerFecha, T003I3_A46PaiCod, T003I3_A1223FerId
            }
            , new Object[] {
            T003I4_A1228FerDescrip, T003I4_A1230FerReligId, T003I4_n1230FerReligId, T003I4_A1232FerOrigId, T003I4_n1232FerOrigId, T003I4_A1233FeriadoTipo, T003I4_A1234FeriadoConvenio, T003I4_n1234FeriadoConvenio
            }
            , new Object[] {
            T003I5_A1226FerAnio, T003I5_A1227FerFecha, T003I5_A1228FerDescrip, T003I5_A46PaiCod, T003I5_A1223FerId, T003I5_A1230FerReligId, T003I5_n1230FerReligId, T003I5_A1232FerOrigId, T003I5_n1232FerOrigId, T003I5_A1233FeriadoTipo,
            T003I5_A1234FeriadoConvenio, T003I5_n1234FeriadoConvenio
            }
            , new Object[] {
            T003I6_A1228FerDescrip, T003I6_A1230FerReligId, T003I6_n1230FerReligId, T003I6_A1232FerOrigId, T003I6_n1232FerOrigId, T003I6_A1233FeriadoTipo, T003I6_A1234FeriadoConvenio, T003I6_n1234FeriadoConvenio
            }
            , new Object[] {
            T003I7_A46PaiCod, T003I7_A1223FerId, T003I7_A1226FerAnio, T003I7_A1227FerFecha
            }
            , new Object[] {
            T003I8_A46PaiCod, T003I8_A1223FerId, T003I8_A1226FerAnio, T003I8_A1227FerFecha
            }
            , new Object[] {
            T003I9_A46PaiCod, T003I9_A1223FerId, T003I9_A1226FerAnio, T003I9_A1227FerFecha
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T003I12_A1228FerDescrip, T003I12_A1230FerReligId, T003I12_n1230FerReligId, T003I12_A1232FerOrigId, T003I12_n1232FerOrigId, T003I12_A1233FeriadoTipo, T003I12_A1234FeriadoConvenio, T003I12_n1234FeriadoConvenio
            }
            , new Object[] {
            T003I13_A46PaiCod, T003I13_A1223FerId, T003I13_A1226FerAnio, T003I13_A1227FerFecha
            }
            , new Object[] {
            T003I14_A46PaiCod, T003I14_A1223FerId, T003I14_A1228FerDescrip
            }
            , new Object[] {
            T003I15_A1228FerDescrip, T003I15_A1230FerReligId, T003I15_n1230FerReligId, T003I15_A1232FerOrigId, T003I15_n1232FerOrigId, T003I15_A1233FeriadoTipo, T003I15_A1234FeriadoConvenio, T003I15_n1234FeriadoConvenio
            }
         }
      );
      AV16Pgmname = "feriado_agenda" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7PaiCod ;
   private short wcpOAV9FerAnio ;
   private short Z46PaiCod ;
   private short Z1226FerAnio ;
   private short A46PaiCod ;
   private short AV7PaiCod ;
   private short AV9FerAnio ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1226FerAnio ;
   private short RcdFound243 ;
   private short nIsDirty_243 ;
   private short GXt_int1 ;
   private short GXv_int4[] ;
   private int trnEnded ;
   private int edtFerAnio_Visible ;
   private int edtFerAnio_Enabled ;
   private int edtFerFecha_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtPaiCod_Visible ;
   private int edtPaiCod_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int2 ;
   private int GXv_int3[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8FerId ;
   private String Z1223FerId ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A1223FerId ;
   private String Gx_mode ;
   private String AV8FerId ;
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
   private String divFeranio_cell_Internalname ;
   private String divFeranio_cell_Class ;
   private String edtFerAnio_Internalname ;
   private String edtFerAnio_Jsonclick ;
   private String edtFerFecha_Internalname ;
   private String edtFerFecha_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtPaiCod_Internalname ;
   private String edtPaiCod_Jsonclick ;
   private String A1230FerReligId ;
   private String A1232FerOrigId ;
   private String A1233FeriadoTipo ;
   private String A1234FeriadoConvenio ;
   private String AV16Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode243 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z1230FerReligId ;
   private String Z1232FerOrigId ;
   private String Z1233FeriadoTipo ;
   private String Z1234FeriadoConvenio ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private java.util.Date wcpOAV15FerFecha ;
   private java.util.Date Z1227FerFecha ;
   private java.util.Date AV15FerFecha ;
   private java.util.Date A1227FerFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean n1230FerReligId ;
   private boolean n1232FerOrigId ;
   private boolean n1234FeriadoConvenio ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean GXt_boolean6 ;
   private boolean GXv_boolean7[] ;
   private boolean gxdyncontrolsrefreshing ;
   private String A1228FerDescrip ;
   private String Z1228FerDescrip ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynFerId ;
   private IDataStoreProvider pr_default ;
   private String[] T003I4_A1228FerDescrip ;
   private String[] T003I4_A1230FerReligId ;
   private boolean[] T003I4_n1230FerReligId ;
   private String[] T003I4_A1232FerOrigId ;
   private boolean[] T003I4_n1232FerOrigId ;
   private String[] T003I4_A1233FeriadoTipo ;
   private String[] T003I4_A1234FeriadoConvenio ;
   private boolean[] T003I4_n1234FeriadoConvenio ;
   private short[] T003I5_A1226FerAnio ;
   private java.util.Date[] T003I5_A1227FerFecha ;
   private String[] T003I5_A1228FerDescrip ;
   private short[] T003I5_A46PaiCod ;
   private String[] T003I5_A1223FerId ;
   private String[] T003I5_A1230FerReligId ;
   private boolean[] T003I5_n1230FerReligId ;
   private String[] T003I5_A1232FerOrigId ;
   private boolean[] T003I5_n1232FerOrigId ;
   private String[] T003I5_A1233FeriadoTipo ;
   private String[] T003I5_A1234FeriadoConvenio ;
   private boolean[] T003I5_n1234FeriadoConvenio ;
   private String[] T003I6_A1228FerDescrip ;
   private String[] T003I6_A1230FerReligId ;
   private boolean[] T003I6_n1230FerReligId ;
   private String[] T003I6_A1232FerOrigId ;
   private boolean[] T003I6_n1232FerOrigId ;
   private String[] T003I6_A1233FeriadoTipo ;
   private String[] T003I6_A1234FeriadoConvenio ;
   private boolean[] T003I6_n1234FeriadoConvenio ;
   private short[] T003I7_A46PaiCod ;
   private String[] T003I7_A1223FerId ;
   private short[] T003I7_A1226FerAnio ;
   private java.util.Date[] T003I7_A1227FerFecha ;
   private short[] T003I3_A1226FerAnio ;
   private java.util.Date[] T003I3_A1227FerFecha ;
   private short[] T003I3_A46PaiCod ;
   private String[] T003I3_A1223FerId ;
   private short[] T003I8_A46PaiCod ;
   private String[] T003I8_A1223FerId ;
   private short[] T003I8_A1226FerAnio ;
   private java.util.Date[] T003I8_A1227FerFecha ;
   private short[] T003I9_A46PaiCod ;
   private String[] T003I9_A1223FerId ;
   private short[] T003I9_A1226FerAnio ;
   private java.util.Date[] T003I9_A1227FerFecha ;
   private short[] T003I2_A1226FerAnio ;
   private java.util.Date[] T003I2_A1227FerFecha ;
   private short[] T003I2_A46PaiCod ;
   private String[] T003I2_A1223FerId ;
   private String[] T003I12_A1228FerDescrip ;
   private String[] T003I12_A1230FerReligId ;
   private boolean[] T003I12_n1230FerReligId ;
   private String[] T003I12_A1232FerOrigId ;
   private boolean[] T003I12_n1232FerOrigId ;
   private String[] T003I12_A1233FeriadoTipo ;
   private String[] T003I12_A1234FeriadoConvenio ;
   private boolean[] T003I12_n1234FeriadoConvenio ;
   private short[] T003I13_A46PaiCod ;
   private String[] T003I13_A1223FerId ;
   private short[] T003I13_A1226FerAnio ;
   private java.util.Date[] T003I13_A1227FerFecha ;
   private short[] T003I14_A46PaiCod ;
   private String[] T003I14_A1223FerId ;
   private String[] T003I14_A1228FerDescrip ;
   private String[] T003I15_A1228FerDescrip ;
   private String[] T003I15_A1230FerReligId ;
   private boolean[] T003I15_n1230FerReligId ;
   private String[] T003I15_A1232FerOrigId ;
   private boolean[] T003I15_n1232FerOrigId ;
   private String[] T003I15_A1233FeriadoTipo ;
   private String[] T003I15_A1234FeriadoConvenio ;
   private boolean[] T003I15_n1234FeriadoConvenio ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
}

final  class feriado_agenda__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T003I2", "SELECT FerAnio, FerFecha, PaiCod, FerId FROM feriado_agenda WHERE PaiCod = ? AND FerId = ? AND FerAnio = ? AND FerFecha = ?  FOR UPDATE OF feriado_agenda NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003I3", "SELECT FerAnio, FerFecha, PaiCod, FerId FROM feriado_agenda WHERE PaiCod = ? AND FerId = ? AND FerAnio = ? AND FerFecha = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003I4", "SELECT FerDescrip, FerReligId, FerOrigId, FeriadoTipo, FeriadoConvenio FROM feriado WHERE PaiCod = ? AND FerId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003I5", "SELECT TM1.FerAnio, TM1.FerFecha, T2.FerDescrip, TM1.PaiCod, TM1.FerId, T2.FerReligId, T2.FerOrigId, T2.FeriadoTipo, T2.FeriadoConvenio FROM (feriado_agenda TM1 INNER JOIN feriado T2 ON T2.PaiCod = TM1.PaiCod AND T2.FerId = TM1.FerId) WHERE TM1.PaiCod = ? and TM1.FerId = ( ?) and TM1.FerAnio = ? and TM1.FerFecha = ? ORDER BY TM1.PaiCod, TM1.FerId, TM1.FerAnio, TM1.FerFecha ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003I6", "SELECT FerDescrip, FerReligId, FerOrigId, FeriadoTipo, FeriadoConvenio FROM feriado WHERE PaiCod = ? AND FerId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003I7", "SELECT PaiCod, FerId, FerAnio, FerFecha FROM feriado_agenda WHERE PaiCod = ? AND FerId = ? AND FerAnio = ? AND FerFecha = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003I8", "SELECT PaiCod, FerId, FerAnio, FerFecha FROM feriado_agenda WHERE ( PaiCod > ? or PaiCod = ? and FerId > ( ?) or FerId = ( ?) and PaiCod = ? and FerAnio > ? or FerAnio = ? and FerId = ( ?) and PaiCod = ? and FerFecha > ?) ORDER BY PaiCod, FerId, FerAnio, FerFecha  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003I9", "SELECT PaiCod, FerId, FerAnio, FerFecha FROM feriado_agenda WHERE ( PaiCod < ? or PaiCod = ? and FerId < ( ?) or FerId = ( ?) and PaiCod = ? and FerAnio < ? or FerAnio = ? and FerId = ( ?) and PaiCod = ? and FerFecha < ?) ORDER BY PaiCod DESC, FerId DESC, FerAnio DESC, FerFecha DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T003I10", "SAVEPOINT gxupdate;INSERT INTO feriado_agenda(FerAnio, FerFecha, PaiCod, FerId) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003I11", "SAVEPOINT gxupdate;DELETE FROM feriado_agenda  WHERE PaiCod = ? AND FerId = ? AND FerAnio = ? AND FerFecha = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003I12", "SELECT FerDescrip, FerReligId, FerOrigId, FeriadoTipo, FeriadoConvenio FROM feriado WHERE PaiCod = ? AND FerId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003I13", "SELECT PaiCod, FerId, FerAnio, FerFecha FROM feriado_agenda ORDER BY PaiCod, FerId, FerAnio, FerFecha ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003I14", "SELECT PaiCod, FerId, FerDescrip FROM feriado WHERE PaiCod = ? ORDER BY FerDescrip ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003I15", "SELECT FerDescrip, FerReligId, FerOrigId, FeriadoTipo, FeriadoConvenio FROM feriado WHERE PaiCod = ? AND FerId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 40);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getString(8, 20);
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 20);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
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
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 40);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 40);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setDate(10, (java.util.Date)parms[9]);
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 40);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 40);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setDate(10, (java.util.Date)parms[9]);
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
      }
   }

}

