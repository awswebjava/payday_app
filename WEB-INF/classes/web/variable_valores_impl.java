package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class variable_valores_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action15") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A1890OpeCliRelSec = (int)(GXutil.lval( httpContext.GetPar( "OpeCliRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1890OpeCliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1890OpeCliRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_15_2L81( Gx_mode, AV7CliCod, A1890OpeCliRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action17") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_17_2L81( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"OPECLIRELSEC") == 0 )
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
         gxdlaopeclirelsec2L81( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"CLICOD") == 0 )
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
         gx1asaclicod2L81( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_19") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A82OpeCliId = httpContext.GetPar( "OpeCliId") ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_19( A3CliCod, A82OpeCliId) ;
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
            AV8OpeCliId = httpContext.GetPar( "OpeCliId") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8OpeCliId", AV8OpeCliId);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECLIID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8OpeCliId, ""))));
            AV9OpeCliVig = localUtil.parseDateParm( httpContext.GetPar( "OpeCliVig")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9OpeCliVig", localUtil.format(AV9OpeCliVig, "99/99/99"));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECLIVIG", getSecureSignedToken( "", AV9OpeCliVig));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "variable_valores", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtOpeCliId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public variable_valores_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public variable_valores_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( variable_valores_impl.class ));
   }

   public variable_valores_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynOpeCliRelSec = new HTMLChoice();
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
      if ( dynOpeCliRelSec.getItemCount() > 0 )
      {
         A1890OpeCliRelSec = (int)(GXutil.lval( dynOpeCliRelSec.getValidValue(GXutil.trim( GXutil.str( A1890OpeCliRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1890OpeCliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1890OpeCliRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynOpeCliRelSec.setValue( GXutil.trim( GXutil.str( A1890OpeCliRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynOpeCliRelSec.getInternalname(), "Values", dynOpeCliRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedopecliid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockopecliid_Internalname, httpContext.getMessage( "Variable", ""), "", "", lblTextblockopecliid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_variable_valores.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_opecliid.setProperty("Caption", Combo_opecliid_Caption);
      ucCombo_opecliid.setProperty("Cls", Combo_opecliid_Cls);
      ucCombo_opecliid.setProperty("DataListProc", Combo_opecliid_Datalistproc);
      ucCombo_opecliid.setProperty("EmptyItem", Combo_opecliid_Emptyitem);
      ucCombo_opecliid.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_opecliid.setProperty("DropDownOptionsData", AV15OpeCliId_Data);
      ucCombo_opecliid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_opecliid_Internalname, "COMBO_OPECLIIDContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOpeCliId_Internalname, httpContext.getMessage( "Id. de variable", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOpeCliId_Internalname, GXutil.rtrim( A82OpeCliId), GXutil.rtrim( localUtil.format( A82OpeCliId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOpeCliId_Jsonclick, 0, "Attribute", "", "", "", "", edtOpeCliId_Visible, edtOpeCliId_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_variable_valores.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOpeCliVig_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOpeCliVig_Internalname, httpContext.getMessage( "Vigencia", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtOpeCliVig_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOpeCliVig_Internalname, localUtil.format(A754OpeCliVig, "99/99/99"), localUtil.format( A754OpeCliVig, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOpeCliVig_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtOpeCliVig_Enabled, 1, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_variable_valores.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtOpeCliVig_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtOpeCliVig_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_variable_valores.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOpeCliValor_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOpeCliValor_Internalname, httpContext.getMessage( "Valor", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtOpeCliValor_Internalname, A535OpeCliValor, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", (short)(0), 1, edtOpeCliValor_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "500000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_variable_valores.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOpeCliVRetro_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOpeCliVRetro_Internalname, httpContext.getMessage( "Retroactivo a", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtOpeCliVRetro_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOpeCliVRetro_Internalname, localUtil.format(A1146OpeCliVRetro, "99/99/99"), localUtil.format( A1146OpeCliVRetro, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOpeCliVRetro_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtOpeCliVRetro_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_variable_valores.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtOpeCliVRetro_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtOpeCliVRetro_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_variable_valores.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divOpeclirelsec_cell_Internalname, 1, 0, "px", 0, "px", divOpeclirelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", dynOpeCliRelSec.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynOpeCliRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynOpeCliRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynOpeCliRelSec, dynOpeCliRelSec.getInternalname(), GXutil.trim( GXutil.str( A1890OpeCliRelSec, 6, 0)), 1, dynOpeCliRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", dynOpeCliRelSec.getVisible(), dynOpeCliRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", "", true, (byte)(0), "HLP_variable_valores.htm");
      dynOpeCliRelSec.setValue( GXutil.trim( GXutil.str( A1890OpeCliRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynOpeCliRelSec.getInternalname(), "Values", dynOpeCliRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_variable_valores.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_variable_valores.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_variable_valores.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_opecliid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboopecliid_Internalname, GXutil.rtrim( AV20ComboOpeCliId), GXutil.rtrim( localUtil.format( AV20ComboOpeCliId, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboopecliid_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboopecliid_Visible, edtavComboopecliid_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_variable_valores.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,66);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_variable_valores.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOpeCliVPropagar_Internalname, GXutil.booltostr( A924OpeCliVPropagar), GXutil.booltostr( A924OpeCliVPropagar), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOpeCliVPropagar_Jsonclick, 0, "Attribute", "", "", "", "", edtOpeCliVPropagar_Visible, edtOpeCliVPropagar_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "", "right", false, "", "HLP_variable_valores.htm");
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
      e112L2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV16DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vOPECLIID_DATA"), AV15OpeCliId_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z82OpeCliId = httpContext.cgiGet( "Z82OpeCliId") ;
            Z754OpeCliVig = localUtil.ctod( httpContext.cgiGet( "Z754OpeCliVig"), 0) ;
            Z1904OpeCliRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1904OpeCliRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z924OpeCliVPropagar = GXutil.strtobool( httpContext.cgiGet( "Z924OpeCliVPropagar")) ;
            n924OpeCliVPropagar = ((false==A924OpeCliVPropagar) ? true : false) ;
            Z1146OpeCliVRetro = localUtil.ctod( httpContext.cgiGet( "Z1146OpeCliVRetro"), 0) ;
            n1146OpeCliVRetro = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A1146OpeCliVRetro)) ? true : false) ;
            Z1890OpeCliRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1890OpeCliRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2010OpeCliVRelRef = httpContext.cgiGet( "Z2010OpeCliVRelRef") ;
            A1904OpeCliRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1904OpeCliRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2010OpeCliVRelRef = httpContext.cgiGet( "Z2010OpeCliVRelRef") ;
            O1146OpeCliVRetro = localUtil.ctod( httpContext.cgiGet( "O1146OpeCliVRetro"), 0) ;
            n1146OpeCliVRetro = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A1146OpeCliVRetro)) ? true : false) ;
            O535OpeCliValor = httpContext.cgiGet( "O535OpeCliValor") ;
            O754OpeCliVig = localUtil.ctod( httpContext.cgiGet( "O754OpeCliVig"), 0) ;
            O82OpeCliId = httpContext.cgiGet( "O82OpeCliId") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV25next_OpeCliVig = localUtil.ctod( httpContext.cgiGet( "NEXT_OPECLIVIG"), 0) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8OpeCliId = httpContext.cgiGet( "vOPECLIID") ;
            AV9OpeCliVig = localUtil.ctod( httpContext.cgiGet( "vOPECLIVIG"), 0) ;
            AV25next_OpeCliVig = localUtil.ctod( httpContext.cgiGet( "vNEXT_OPECLIVIG"), 0) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV22esSistemaConceptosDefault = GXutil.strtobool( httpContext.cgiGet( "vESSISTEMACONCEPTOSDEFAULT")) ;
            AV24ClienteConveniador = GXutil.strtobool( httpContext.cgiGet( "vCLIENTECONVENIADOR")) ;
            A1904OpeCliRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "OPECLIRELSECCLI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV23aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A2010OpeCliVRelRef = httpContext.cgiGet( "OPECLIVRELREF") ;
            A2032OpeCliVOld = httpContext.cgiGet( "OPECLIVOLD") ;
            AV27Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_opecliid_Objectcall = httpContext.cgiGet( "COMBO_OPECLIID_Objectcall") ;
            Combo_opecliid_Class = httpContext.cgiGet( "COMBO_OPECLIID_Class") ;
            Combo_opecliid_Icontype = httpContext.cgiGet( "COMBO_OPECLIID_Icontype") ;
            Combo_opecliid_Icon = httpContext.cgiGet( "COMBO_OPECLIID_Icon") ;
            Combo_opecliid_Caption = httpContext.cgiGet( "COMBO_OPECLIID_Caption") ;
            Combo_opecliid_Tooltip = httpContext.cgiGet( "COMBO_OPECLIID_Tooltip") ;
            Combo_opecliid_Cls = httpContext.cgiGet( "COMBO_OPECLIID_Cls") ;
            Combo_opecliid_Selectedvalue_set = httpContext.cgiGet( "COMBO_OPECLIID_Selectedvalue_set") ;
            Combo_opecliid_Selectedvalue_get = httpContext.cgiGet( "COMBO_OPECLIID_Selectedvalue_get") ;
            Combo_opecliid_Selectedtext_set = httpContext.cgiGet( "COMBO_OPECLIID_Selectedtext_set") ;
            Combo_opecliid_Selectedtext_get = httpContext.cgiGet( "COMBO_OPECLIID_Selectedtext_get") ;
            Combo_opecliid_Gamoauthtoken = httpContext.cgiGet( "COMBO_OPECLIID_Gamoauthtoken") ;
            Combo_opecliid_Ddointernalname = httpContext.cgiGet( "COMBO_OPECLIID_Ddointernalname") ;
            Combo_opecliid_Titlecontrolalign = httpContext.cgiGet( "COMBO_OPECLIID_Titlecontrolalign") ;
            Combo_opecliid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_OPECLIID_Dropdownoptionstype") ;
            Combo_opecliid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_OPECLIID_Enabled")) ;
            Combo_opecliid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_OPECLIID_Visible")) ;
            Combo_opecliid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_OPECLIID_Titlecontrolidtoreplace") ;
            Combo_opecliid_Datalisttype = httpContext.cgiGet( "COMBO_OPECLIID_Datalisttype") ;
            Combo_opecliid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_OPECLIID_Allowmultipleselection")) ;
            Combo_opecliid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_OPECLIID_Datalistfixedvalues") ;
            Combo_opecliid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_OPECLIID_Isgriditem")) ;
            Combo_opecliid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_OPECLIID_Hasdescription")) ;
            Combo_opecliid_Datalistproc = httpContext.cgiGet( "COMBO_OPECLIID_Datalistproc") ;
            Combo_opecliid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_OPECLIID_Datalistprocparametersprefix") ;
            Combo_opecliid_Remoteservicesparameters = httpContext.cgiGet( "COMBO_OPECLIID_Remoteservicesparameters") ;
            Combo_opecliid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_OPECLIID_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_opecliid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_OPECLIID_Includeonlyselectedoption")) ;
            Combo_opecliid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_OPECLIID_Includeselectalloption")) ;
            Combo_opecliid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_OPECLIID_Emptyitem")) ;
            Combo_opecliid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_OPECLIID_Includeaddnewoption")) ;
            Combo_opecliid_Htmltemplate = httpContext.cgiGet( "COMBO_OPECLIID_Htmltemplate") ;
            Combo_opecliid_Multiplevaluestype = httpContext.cgiGet( "COMBO_OPECLIID_Multiplevaluestype") ;
            Combo_opecliid_Loadingdata = httpContext.cgiGet( "COMBO_OPECLIID_Loadingdata") ;
            Combo_opecliid_Noresultsfound = httpContext.cgiGet( "COMBO_OPECLIID_Noresultsfound") ;
            Combo_opecliid_Emptyitemtext = httpContext.cgiGet( "COMBO_OPECLIID_Emptyitemtext") ;
            Combo_opecliid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_OPECLIID_Onlyselectedvalues") ;
            Combo_opecliid_Selectalltext = httpContext.cgiGet( "COMBO_OPECLIID_Selectalltext") ;
            Combo_opecliid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_OPECLIID_Multiplevaluesseparator") ;
            Combo_opecliid_Addnewoptiontext = httpContext.cgiGet( "COMBO_OPECLIID_Addnewoptiontext") ;
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
            A82OpeCliId = httpContext.cgiGet( edtOpeCliId_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
            if ( localUtil.vcdate( httpContext.cgiGet( edtOpeCliVig_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "OPECLIVIG");
               AnyError = (short)(1) ;
               GX_FocusControl = edtOpeCliVig_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A754OpeCliVig = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
            }
            else
            {
               A754OpeCliVig = localUtil.ctod( httpContext.cgiGet( edtOpeCliVig_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
            }
            A535OpeCliValor = httpContext.cgiGet( edtOpeCliValor_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A535OpeCliValor", A535OpeCliValor);
            if ( localUtil.vcdate( httpContext.cgiGet( edtOpeCliVRetro_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "OPECLIVRETRO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtOpeCliVRetro_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1146OpeCliVRetro = GXutil.nullDate() ;
               n1146OpeCliVRetro = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1146OpeCliVRetro", localUtil.format(A1146OpeCliVRetro, "99/99/99"));
            }
            else
            {
               A1146OpeCliVRetro = localUtil.ctod( httpContext.cgiGet( edtOpeCliVRetro_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               n1146OpeCliVRetro = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1146OpeCliVRetro", localUtil.format(A1146OpeCliVRetro, "99/99/99"));
            }
            n1146OpeCliVRetro = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A1146OpeCliVRetro)) ? true : false) ;
            dynOpeCliRelSec.setValue( httpContext.cgiGet( dynOpeCliRelSec.getInternalname()) );
            A1890OpeCliRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynOpeCliRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1890OpeCliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1890OpeCliRelSec), 6, 0));
            AV20ComboOpeCliId = httpContext.cgiGet( edtavComboopecliid_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ComboOpeCliId", AV20ComboOpeCliId);
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
            A924OpeCliVPropagar = GXutil.strtobool( httpContext.cgiGet( edtOpeCliVPropagar_Internalname)) ;
            n924OpeCliVPropagar = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A924OpeCliVPropagar", A924OpeCliVPropagar);
            n924OpeCliVPropagar = ((false==A924OpeCliVPropagar) ? true : false) ;
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"variable_valores");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("OpeCliRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1904OpeCliRelSecCli), "ZZZZZ9"));
            forbiddenHiddens.add("next_OpeCliVig", localUtil.format(AV25next_OpeCliVig, "99/99/99"));
            forbiddenHiddens.add("OpeCliVRelRef", GXutil.rtrim( localUtil.format( A2010OpeCliVRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A82OpeCliId, Z82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(Z754OpeCliVig)) ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("variable_valores:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A82OpeCliId = httpContext.GetPar( "OpeCliId") ;
               httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
               A754OpeCliVig = localUtil.parseDateParm( httpContext.GetPar( "OpeCliVig")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
               getEqualNoModal( ) ;
               if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV9OpeCliVig)) )
               {
                  A754OpeCliVig = AV9OpeCliVig ;
                  httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
               }
               else
               {
                  if ( isIns( )  && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A754OpeCliVig)) && ( Gx_BScreen == 0 ) )
                  {
                     A754OpeCliVig = AV25next_OpeCliVig ;
                     httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
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
                  sMode81 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV9OpeCliVig)) )
                  {
                     A754OpeCliVig = AV9OpeCliVig ;
                     httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
                  }
                  else
                  {
                     if ( isIns( )  && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A754OpeCliVig)) && ( Gx_BScreen == 0 ) )
                     {
                        A754OpeCliVig = AV25next_OpeCliVig ;
                        httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
                     }
                  }
                  Gx_mode = sMode81 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound81 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_2L0( ) ;
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
                        e112L2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e122L2 ();
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
         e122L2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll2L81( ) ;
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
         disableAttributes2L81( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboopecliid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboopecliid_Enabled), 5, 0), true);
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

   public void confirm_2L0( )
   {
      beforeValidate2L81( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2L81( ) ;
         }
         else
         {
            checkExtendedTable2L81( ) ;
            closeExtendedTableCursors2L81( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption2L0( )
   {
   }

   public void e112L2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV10WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV10WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV16DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV16DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtOpeCliId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliId_Visible), 5, 0), true);
      AV20ComboOpeCliId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboOpeCliId", AV20ComboOpeCliId);
      edtavComboopecliid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboopecliid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboopecliid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOOPECLIID' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV11IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWvariable_valores_Insert", GXv_boolean5) ;
         variable_valores_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWvariable_valores_Update", GXv_boolean5) ;
         variable_valores_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWvariable_valores_Delete", GXv_boolean5) ;
         variable_valores_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV27Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtOpeCliVPropagar_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliVPropagar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliVPropagar_Visible), 5, 0), true);
      GXt_boolean4 = AV22esSistemaConceptosDefault ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean5) ;
      variable_valores_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV22esSistemaConceptosDefault = GXt_boolean4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22esSistemaConceptosDefault", AV22esSistemaConceptosDefault);
      GXv_boolean5[0] = AV24ClienteConveniador ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      variable_valores_impl.this.AV24ClienteConveniador = GXv_boolean5[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24ClienteConveniador", AV24ClienteConveniador);
   }

   public void e122L2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      GXt_int6 = AV21EmpCod ;
      GXv_int7[0] = GXt_int6 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int7) ;
      variable_valores_impl.this.GXt_int6 = GXv_int7[0] ;
      AV21EmpCod = GXt_int6 ;
      new web.setlegrecalcularliq(remoteHandle, context).execute( AV7CliCod, AV21EmpCod, 0, true) ;
      new web.variablevalorgrabarrelref(remoteHandle, context).execute( A3CliCod, A82OpeCliId, A754OpeCliVig) ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S122( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      dynOpeCliRelSec.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynOpeCliRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynOpeCliRelSec.getVisible(), 5, 0), true);
      divOpeclirelsec_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divOpeclirelsec_cell_Internalname, "Class", divOpeclirelsec_cell_Class, true);
   }

   public void S112( )
   {
      /* 'LOADCOMBOOPECLIID' Routine */
      returnInSub = false ;
      Combo_opecliid_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"OpeCliId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"OpeCliId\": \"\", \"OpeCliVig\": \"\", \"Cond_CliCod\": \"#%1#\"", edtCliCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_opecliid.sendProperty(context, "", false, Combo_opecliid_Internalname, "DataListProcParametersPrefix", Combo_opecliid_Datalistprocparametersprefix);
      GXt_char8 = AV19Combo_DataJson ;
      GXv_char9[0] = AV17ComboSelectedValue ;
      GXv_char10[0] = AV18ComboSelectedText ;
      GXv_char11[0] = GXt_char8 ;
      new web.variable_valoresloaddvcombo(remoteHandle, context).execute( "OpeCliId", Gx_mode, false, AV7CliCod, AV8OpeCliId, AV9OpeCliVig, A3CliCod, "", GXv_char9, GXv_char10, GXv_char11) ;
      variable_valores_impl.this.AV17ComboSelectedValue = GXv_char9[0] ;
      variable_valores_impl.this.AV18ComboSelectedText = GXv_char10[0] ;
      variable_valores_impl.this.GXt_char8 = GXv_char11[0] ;
      AV19Combo_DataJson = GXt_char8 ;
      Combo_opecliid_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_opecliid.sendProperty(context, "", false, Combo_opecliid_Internalname, "SelectedValue_set", Combo_opecliid_Selectedvalue_set);
      Combo_opecliid_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_opecliid.sendProperty(context, "", false, Combo_opecliid_Internalname, "SelectedText_set", Combo_opecliid_Selectedtext_set);
      AV20ComboOpeCliId = AV17ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboOpeCliId", AV20ComboOpeCliId);
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (GXutil.strcmp("", AV8OpeCliId)==0) )
      {
         Combo_opecliid_Enabled = false ;
         ucCombo_opecliid.sendProperty(context, "", false, Combo_opecliid_Internalname, "Enabled", GXutil.booltostr( Combo_opecliid_Enabled));
      }
   }

   public void zm2L81( int GX_JID )
   {
      if ( ( GX_JID == 18 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1904OpeCliRelSecCli = T002L3_A1904OpeCliRelSecCli[0] ;
            Z924OpeCliVPropagar = T002L3_A924OpeCliVPropagar[0] ;
            Z1146OpeCliVRetro = T002L3_A1146OpeCliVRetro[0] ;
            Z1890OpeCliRelSec = T002L3_A1890OpeCliRelSec[0] ;
            Z2010OpeCliVRelRef = T002L3_A2010OpeCliVRelRef[0] ;
         }
         else
         {
            Z1904OpeCliRelSecCli = A1904OpeCliRelSecCli ;
            Z924OpeCliVPropagar = A924OpeCliVPropagar ;
            Z1146OpeCliVRetro = A1146OpeCliVRetro ;
            Z1890OpeCliRelSec = A1890OpeCliRelSec ;
            Z2010OpeCliVRelRef = A2010OpeCliVRelRef ;
         }
      }
      if ( GX_JID == -18 )
      {
         Z754OpeCliVig = A754OpeCliVig ;
         Z1904OpeCliRelSecCli = A1904OpeCliRelSecCli ;
         Z535OpeCliValor = A535OpeCliValor ;
         Z924OpeCliVPropagar = A924OpeCliVPropagar ;
         Z1146OpeCliVRetro = A1146OpeCliVRetro ;
         Z1890OpeCliRelSec = A1890OpeCliRelSec ;
         Z2010OpeCliVRelRef = A2010OpeCliVRelRef ;
         Z2032OpeCliVOld = A2032OpeCliVOld ;
         Z3CliCod = A3CliCod ;
         Z82OpeCliId = A82OpeCliId ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxaopeclirelsec_html2L81( AV7CliCod) ;
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int12 = A3CliCod ;
            GXv_int13[0] = GXt_int12 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int13) ;
            variable_valores_impl.this.GXt_int12 = GXv_int13[0] ;
            A3CliCod = GXt_int12 ;
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
      if ( ! (GXutil.strcmp("", AV8OpeCliId)==0) )
      {
         edtOpeCliId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOpeCliId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliId_Enabled), 5, 0), true);
      }
      else
      {
         edtOpeCliId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOpeCliId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliId_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8OpeCliId)==0) )
      {
         edtOpeCliId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOpeCliId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliId_Enabled), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV9OpeCliVig)) )
      {
         edtOpeCliVig_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOpeCliVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliVig_Enabled), 5, 0), true);
      }
      else
      {
         edtOpeCliVig_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOpeCliVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliVig_Enabled), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV9OpeCliVig)) )
      {
         edtOpeCliVig_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtOpeCliVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliVig_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8OpeCliId)==0) )
      {
         A82OpeCliId = AV8OpeCliId ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
      }
      else
      {
         A82OpeCliId = AV20ComboOpeCliId ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
      }
      dynOpeCliRelSec.setVisible( ((AV22esSistemaConceptosDefault)||(AV24ClienteConveniador) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynOpeCliRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynOpeCliRelSec.getVisible(), 5, 0), true);
   }

   public void standaloneModal( )
   {
      if ( isIns( )  || isUpd( )  )
      {
         A1904OpeCliRelSecCli = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1904OpeCliRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1904OpeCliRelSecCli), 6, 0));
      }
      if ( isIns( )  )
      {
         GXv_date14[0] = AV25next_OpeCliVig ;
         new web.getopeclinextfecha(remoteHandle, context).execute( AV7CliCod, AV8OpeCliId, GXutil.serverDate( context, remoteHandle, pr_default), GXv_date14) ;
         variable_valores_impl.this.AV25next_OpeCliVig = GXv_date14[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25next_OpeCliVig", localUtil.format(AV25next_OpeCliVig, "99/99/99"));
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
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV9OpeCliVig)) )
      {
         A754OpeCliVig = AV9OpeCliVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
      }
      else
      {
         if ( isIns( )  && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A754OpeCliVig)) && ( Gx_BScreen == 0 ) )
         {
            A754OpeCliVig = AV25next_OpeCliVig ;
            httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV27Pgmname = "variable_valores" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
      }
   }

   public void load2L81( )
   {
      /* Using cursor T002L5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound81 = (short)(1) ;
         A1904OpeCliRelSecCli = T002L5_A1904OpeCliRelSecCli[0] ;
         A535OpeCliValor = T002L5_A535OpeCliValor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A535OpeCliValor", A535OpeCliValor);
         A924OpeCliVPropagar = T002L5_A924OpeCliVPropagar[0] ;
         n924OpeCliVPropagar = T002L5_n924OpeCliVPropagar[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A924OpeCliVPropagar", A924OpeCliVPropagar);
         A1146OpeCliVRetro = T002L5_A1146OpeCliVRetro[0] ;
         n1146OpeCliVRetro = T002L5_n1146OpeCliVRetro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1146OpeCliVRetro", localUtil.format(A1146OpeCliVRetro, "99/99/99"));
         A1890OpeCliRelSec = T002L5_A1890OpeCliRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1890OpeCliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1890OpeCliRelSec), 6, 0));
         A2010OpeCliVRelRef = T002L5_A2010OpeCliVRelRef[0] ;
         A2032OpeCliVOld = T002L5_A2032OpeCliVOld[0] ;
         zm2L81( -18) ;
      }
      pr_default.close(3);
      onLoadActions2L81( ) ;
   }

   public void onLoadActions2L81( )
   {
      AV27Pgmname = "variable_valores" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
      if ( ! ( ( AV22esSistemaConceptosDefault ) || ( AV24ClienteConveniador ) ) )
      {
         divOpeclirelsec_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divOpeclirelsec_cell_Internalname, "Class", divOpeclirelsec_cell_Class, true);
      }
      else
      {
         if ( ( AV22esSistemaConceptosDefault ) || ( AV24ClienteConveniador ) && ! ( ( ( AV22esSistemaConceptosDefault ) || ( AV24ClienteConveniador ) ) && ( ( GXutil.strcmp(A82OpeCliId, O82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(O754OpeCliVig)) ) || ( GXutil.strcmp(A535OpeCliValor, O535OpeCliValor) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1146OpeCliVRetro), GXutil.resetTime(O1146OpeCliVRetro)) ) ) ) )
         {
            divOpeclirelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOpeclirelsec_cell_Internalname, "Class", divOpeclirelsec_cell_Class, true);
         }
         else
         {
            if ( ( AV22esSistemaConceptosDefault ) || ( AV24ClienteConveniador ) && ( ( ( AV22esSistemaConceptosDefault ) || ( AV24ClienteConveniador ) ) && ( ( GXutil.strcmp(A82OpeCliId, O82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(O754OpeCliVig)) ) || ( GXutil.strcmp(A535OpeCliValor, O535OpeCliValor) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1146OpeCliVRetro), GXutil.resetTime(O1146OpeCliVRetro)) ) ) ) )
            {
               divOpeclirelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divOpeclirelsec_cell_Internalname, "Class", divOpeclirelsec_cell_Class, true);
            }
         }
      }
   }

   public void checkExtendedTable2L81( )
   {
      nIsDirty_81 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV27Pgmname = "variable_valores" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV23aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1890OpeCliRelSec, GXv_boolean5) ;
         variable_valores_impl.this.AV23aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
      }
      /* Using cursor T002L4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Variable", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OPECLIID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( AV22esSistemaConceptosDefault ) || ( AV24ClienteConveniador ) ) )
      {
         divOpeclirelsec_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divOpeclirelsec_cell_Internalname, "Class", divOpeclirelsec_cell_Class, true);
      }
      else
      {
         if ( ( AV22esSistemaConceptosDefault ) || ( AV24ClienteConveniador ) && ! ( ( ( AV22esSistemaConceptosDefault ) || ( AV24ClienteConveniador ) ) && ( ( GXutil.strcmp(A82OpeCliId, O82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(O754OpeCliVig)) ) || ( GXutil.strcmp(A535OpeCliValor, O535OpeCliValor) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1146OpeCliVRetro), GXutil.resetTime(O1146OpeCliVRetro)) ) ) ) )
         {
            divOpeclirelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOpeclirelsec_cell_Internalname, "Class", divOpeclirelsec_cell_Class, true);
         }
         else
         {
            if ( ( AV22esSistemaConceptosDefault ) || ( AV24ClienteConveniador ) && ( ( ( AV22esSistemaConceptosDefault ) || ( AV24ClienteConveniador ) ) && ( ( GXutil.strcmp(A82OpeCliId, O82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(O754OpeCliVig)) ) || ( GXutil.strcmp(A535OpeCliValor, O535OpeCliValor) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1146OpeCliVRetro), GXutil.resetTime(O1146OpeCliVRetro)) ) ) ) )
            {
               divOpeclirelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divOpeclirelsec_cell_Internalname, "Class", divOpeclirelsec_cell_Class, true);
            }
         }
      }
      if ( ( ( ( AV22esSistemaConceptosDefault ) || ( AV24ClienteConveniador ) ) && ( ( GXutil.strcmp(A82OpeCliId, O82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(O754OpeCliVig)) ) || ( GXutil.strcmp(A535OpeCliValor, O535OpeCliValor) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1146OpeCliVRetro), GXutil.resetTime(O1146OpeCliVRetro)) ) ) ) && (0==A1890OpeCliRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "OPECLIID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtOpeCliId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors2L81( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_19( int A3CliCod ,
                          String A82OpeCliId )
   {
      /* Using cursor T002L6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Variable", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OPECLIID");
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

   public void getKey2L81( )
   {
      /* Using cursor T002L7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound81 = (short)(1) ;
      }
      else
      {
         RcdFound81 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T002L3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm2L81( 18) ;
         RcdFound81 = (short)(1) ;
         A754OpeCliVig = T002L3_A754OpeCliVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
         A1904OpeCliRelSecCli = T002L3_A1904OpeCliRelSecCli[0] ;
         A535OpeCliValor = T002L3_A535OpeCliValor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A535OpeCliValor", A535OpeCliValor);
         A924OpeCliVPropagar = T002L3_A924OpeCliVPropagar[0] ;
         n924OpeCliVPropagar = T002L3_n924OpeCliVPropagar[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A924OpeCliVPropagar", A924OpeCliVPropagar);
         A1146OpeCliVRetro = T002L3_A1146OpeCliVRetro[0] ;
         n1146OpeCliVRetro = T002L3_n1146OpeCliVRetro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1146OpeCliVRetro", localUtil.format(A1146OpeCliVRetro, "99/99/99"));
         A1890OpeCliRelSec = T002L3_A1890OpeCliRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1890OpeCliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1890OpeCliRelSec), 6, 0));
         A2010OpeCliVRelRef = T002L3_A2010OpeCliVRelRef[0] ;
         A2032OpeCliVOld = T002L3_A2032OpeCliVOld[0] ;
         A3CliCod = T002L3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A82OpeCliId = T002L3_A82OpeCliId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
         O1146OpeCliVRetro = A1146OpeCliVRetro ;
         n1146OpeCliVRetro = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1146OpeCliVRetro", localUtil.format(A1146OpeCliVRetro, "99/99/99"));
         O535OpeCliValor = A535OpeCliValor ;
         httpContext.ajax_rsp_assign_attri("", false, "A535OpeCliValor", A535OpeCliValor);
         O754OpeCliVig = A754OpeCliVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
         O82OpeCliId = A82OpeCliId ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
         Z3CliCod = A3CliCod ;
         Z82OpeCliId = A82OpeCliId ;
         Z754OpeCliVig = A754OpeCliVig ;
         sMode81 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load2L81( ) ;
         if ( AnyError == 1 )
         {
            RcdFound81 = (short)(0) ;
            initializeNonKey2L81( ) ;
         }
         Gx_mode = sMode81 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound81 = (short)(0) ;
         initializeNonKey2L81( ) ;
         sMode81 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode81 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey2L81( ) ;
      if ( RcdFound81 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound81 = (short)(0) ;
      /* Using cursor T002L8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A82OpeCliId, A82OpeCliId, Integer.valueOf(A3CliCod), A754OpeCliVig});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T002L8_A3CliCod[0] < A3CliCod ) || ( T002L8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002L8_A82OpeCliId[0], A82OpeCliId) < 0 ) || ( GXutil.strcmp(T002L8_A82OpeCliId[0], A82OpeCliId) == 0 ) && ( T002L8_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T002L8_A754OpeCliVig[0]).before( GXutil.resetTime( A754OpeCliVig )) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T002L8_A3CliCod[0] > A3CliCod ) || ( T002L8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002L8_A82OpeCliId[0], A82OpeCliId) > 0 ) || ( GXutil.strcmp(T002L8_A82OpeCliId[0], A82OpeCliId) == 0 ) && ( T002L8_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T002L8_A754OpeCliVig[0]).after( GXutil.resetTime( A754OpeCliVig )) ) )
         {
            A3CliCod = T002L8_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A82OpeCliId = T002L8_A82OpeCliId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
            A754OpeCliVig = T002L8_A754OpeCliVig[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
            RcdFound81 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound81 = (short)(0) ;
      /* Using cursor T002L9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A82OpeCliId, A82OpeCliId, Integer.valueOf(A3CliCod), A754OpeCliVig});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T002L9_A3CliCod[0] > A3CliCod ) || ( T002L9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002L9_A82OpeCliId[0], A82OpeCliId) > 0 ) || ( GXutil.strcmp(T002L9_A82OpeCliId[0], A82OpeCliId) == 0 ) && ( T002L9_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T002L9_A754OpeCliVig[0]).after( GXutil.resetTime( A754OpeCliVig )) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T002L9_A3CliCod[0] < A3CliCod ) || ( T002L9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002L9_A82OpeCliId[0], A82OpeCliId) < 0 ) || ( GXutil.strcmp(T002L9_A82OpeCliId[0], A82OpeCliId) == 0 ) && ( T002L9_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T002L9_A754OpeCliVig[0]).before( GXutil.resetTime( A754OpeCliVig )) ) )
         {
            A3CliCod = T002L9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A82OpeCliId = T002L9_A82OpeCliId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
            A754OpeCliVig = T002L9_A754OpeCliVig[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
            RcdFound81 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2L81( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtOpeCliId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert2L81( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound81 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A82OpeCliId, Z82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(Z754OpeCliVig)) ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A82OpeCliId = Z82OpeCliId ;
               httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
               A754OpeCliVig = Z754OpeCliVig ;
               httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtOpeCliId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update2L81( ) ;
               GX_FocusControl = edtOpeCliId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A82OpeCliId, Z82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(Z754OpeCliVig)) ) )
            {
               /* Insert record */
               GX_FocusControl = edtOpeCliId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert2L81( ) ;
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
                  GX_FocusControl = edtOpeCliId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert2L81( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A82OpeCliId, Z82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(Z754OpeCliVig)) ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A82OpeCliId = Z82OpeCliId ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
         A754OpeCliVig = Z754OpeCliVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtOpeCliId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency2L81( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002L2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"variable_valores"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z1904OpeCliRelSecCli != T002L2_A1904OpeCliRelSecCli[0] ) || ( Z924OpeCliVPropagar != T002L2_A924OpeCliVPropagar[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z1146OpeCliVRetro), GXutil.resetTime(T002L2_A1146OpeCliVRetro[0])) ) || ( Z1890OpeCliRelSec != T002L2_A1890OpeCliRelSec[0] ) || ( GXutil.strcmp(Z2010OpeCliVRelRef, T002L2_A2010OpeCliVRelRef[0]) != 0 ) )
         {
            if ( Z1904OpeCliRelSecCli != T002L2_A1904OpeCliRelSecCli[0] )
            {
               GXutil.writeLogln("variable_valores:[seudo value changed for attri]"+"OpeCliRelSecCli");
               GXutil.writeLogRaw("Old: ",Z1904OpeCliRelSecCli);
               GXutil.writeLogRaw("Current: ",T002L2_A1904OpeCliRelSecCli[0]);
            }
            if ( Z924OpeCliVPropagar != T002L2_A924OpeCliVPropagar[0] )
            {
               GXutil.writeLogln("variable_valores:[seudo value changed for attri]"+"OpeCliVPropagar");
               GXutil.writeLogRaw("Old: ",Z924OpeCliVPropagar);
               GXutil.writeLogRaw("Current: ",T002L2_A924OpeCliVPropagar[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z1146OpeCliVRetro), GXutil.resetTime(T002L2_A1146OpeCliVRetro[0])) ) )
            {
               GXutil.writeLogln("variable_valores:[seudo value changed for attri]"+"OpeCliVRetro");
               GXutil.writeLogRaw("Old: ",Z1146OpeCliVRetro);
               GXutil.writeLogRaw("Current: ",T002L2_A1146OpeCliVRetro[0]);
            }
            if ( Z1890OpeCliRelSec != T002L2_A1890OpeCliRelSec[0] )
            {
               GXutil.writeLogln("variable_valores:[seudo value changed for attri]"+"OpeCliRelSec");
               GXutil.writeLogRaw("Old: ",Z1890OpeCliRelSec);
               GXutil.writeLogRaw("Current: ",T002L2_A1890OpeCliRelSec[0]);
            }
            if ( GXutil.strcmp(Z2010OpeCliVRelRef, T002L2_A2010OpeCliVRelRef[0]) != 0 )
            {
               GXutil.writeLogln("variable_valores:[seudo value changed for attri]"+"OpeCliVRelRef");
               GXutil.writeLogRaw("Old: ",Z2010OpeCliVRelRef);
               GXutil.writeLogRaw("Current: ",T002L2_A2010OpeCliVRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"variable_valores"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2L81( )
   {
      beforeValidate2L81( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2L81( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2L81( 0) ;
         checkOptimisticConcurrency2L81( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2L81( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2L81( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002L10 */
                  pr_default.execute(8, new Object[] {A754OpeCliVig, Integer.valueOf(A1904OpeCliRelSecCli), A535OpeCliValor, Boolean.valueOf(n924OpeCliVPropagar), Boolean.valueOf(A924OpeCliVPropagar), Boolean.valueOf(n1146OpeCliVRetro), A1146OpeCliVRetro, Integer.valueOf(A1890OpeCliRelSec), A2010OpeCliVRelRef, A2032OpeCliVOld, Integer.valueOf(A3CliCod), A82OpeCliId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("variable_valores");
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
                        resetCaption2L0( ) ;
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
            load2L81( ) ;
         }
         endLevel2L81( ) ;
      }
      closeExtendedTableCursors2L81( ) ;
   }

   public void update2L81( )
   {
      beforeValidate2L81( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2L81( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2L81( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2L81( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2L81( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002L11 */
                  pr_default.execute(9, new Object[] {Integer.valueOf(A1904OpeCliRelSecCli), A535OpeCliValor, Boolean.valueOf(n924OpeCliVPropagar), Boolean.valueOf(A924OpeCliVPropagar), Boolean.valueOf(n1146OpeCliVRetro), A1146OpeCliVRetro, Integer.valueOf(A1890OpeCliRelSec), A2010OpeCliVRelRef, A2032OpeCliVOld, Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("variable_valores");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"variable_valores"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2L81( ) ;
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
         endLevel2L81( ) ;
      }
      closeExtendedTableCursors2L81( ) ;
   }

   public void deferredUpdate2L81( )
   {
   }

   public void delete( )
   {
      beforeValidate2L81( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2L81( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2L81( ) ;
         afterConfirm2L81( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2L81( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002L12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("variable_valores");
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
      sMode81 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2L81( ) ;
      Gx_mode = sMode81 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2L81( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean5[0] = AV23aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1890OpeCliRelSec, GXv_boolean5) ;
            variable_valores_impl.this.AV23aplicadoHay = GXv_boolean5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
         }
         AV27Pgmname = "variable_valores" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
         if ( ! ( ( AV22esSistemaConceptosDefault ) || ( AV24ClienteConveniador ) ) )
         {
            divOpeclirelsec_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divOpeclirelsec_cell_Internalname, "Class", divOpeclirelsec_cell_Class, true);
         }
         else
         {
            if ( ( AV22esSistemaConceptosDefault ) || ( AV24ClienteConveniador ) && ! ( ( ( AV22esSistemaConceptosDefault ) || ( AV24ClienteConveniador ) ) && ( ( GXutil.strcmp(A82OpeCliId, O82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(O754OpeCliVig)) ) || ( GXutil.strcmp(A535OpeCliValor, O535OpeCliValor) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1146OpeCliVRetro), GXutil.resetTime(O1146OpeCliVRetro)) ) ) ) )
            {
               divOpeclirelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divOpeclirelsec_cell_Internalname, "Class", divOpeclirelsec_cell_Class, true);
            }
            else
            {
               if ( ( AV22esSistemaConceptosDefault ) || ( AV24ClienteConveniador ) && ( ( ( AV22esSistemaConceptosDefault ) || ( AV24ClienteConveniador ) ) && ( ( GXutil.strcmp(A82OpeCliId, O82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(O754OpeCliVig)) ) || ( GXutil.strcmp(A535OpeCliValor, O535OpeCliValor) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1146OpeCliVRetro), GXutil.resetTime(O1146OpeCliVRetro)) ) ) ) )
               {
                  divOpeclirelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
                  httpContext.ajax_rsp_assign_prop("", false, divOpeclirelsec_cell_Internalname, "Class", divOpeclirelsec_cell_Class, true);
               }
            }
         }
      }
   }

   public void endLevel2L81( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2L81( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "variable_valores");
         if ( AnyError == 0 )
         {
            confirmValues2L0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "variable_valores");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2L81( )
   {
      /* Scan By routine */
      /* Using cursor T002L13 */
      pr_default.execute(11);
      RcdFound81 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound81 = (short)(1) ;
         A3CliCod = T002L13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A82OpeCliId = T002L13_A82OpeCliId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
         A754OpeCliVig = T002L13_A754OpeCliVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2L81( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound81 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound81 = (short)(1) ;
         A3CliCod = T002L13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A82OpeCliId = T002L13_A82OpeCliId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
         A754OpeCliVig = T002L13_A754OpeCliVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
      }
   }

   public void scanEnd2L81( )
   {
      pr_default.close(11);
   }

   public void afterConfirm2L81( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV23aplicadoHay ) && ! (0==A1890OpeCliRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "OpeCliRelSec", 1, "OPECLIRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynOpeCliRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert2L81( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2L81( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2L81( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2L81( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2L81( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2L81( )
   {
      edtOpeCliId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliId_Enabled), 5, 0), true);
      edtOpeCliVig_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliVig_Enabled), 5, 0), true);
      edtOpeCliValor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliValor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliValor_Enabled), 5, 0), true);
      edtOpeCliVRetro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliVRetro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliVRetro_Enabled), 5, 0), true);
      dynOpeCliRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynOpeCliRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynOpeCliRelSec.getEnabled(), 5, 0), true);
      edtavComboopecliid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboopecliid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboopecliid_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtOpeCliVPropagar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliVPropagar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliVPropagar_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes2L81( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues2L0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.variable_valores", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8OpeCliId)),GXutil.URLEncode(GXutil.formatDateParm(AV9OpeCliVig))}, new String[] {"Gx_mode","CliCod","OpeCliId","OpeCliVig"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"variable_valores");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("OpeCliRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1904OpeCliRelSecCli), "ZZZZZ9"));
      forbiddenHiddens.add("next_OpeCliVig", localUtil.format(AV25next_OpeCliVig, "99/99/99"));
      forbiddenHiddens.add("OpeCliVRelRef", GXutil.rtrim( localUtil.format( A2010OpeCliVRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("variable_valores:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z82OpeCliId", GXutil.rtrim( Z82OpeCliId));
      web.GxWebStd.gx_hidden_field( httpContext, "Z754OpeCliVig", localUtil.dtoc( Z754OpeCliVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1904OpeCliRelSecCli", GXutil.ltrim( localUtil.ntoc( Z1904OpeCliRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z924OpeCliVPropagar", Z924OpeCliVPropagar);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1146OpeCliVRetro", localUtil.dtoc( Z1146OpeCliVRetro, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1890OpeCliRelSec", GXutil.ltrim( localUtil.ntoc( Z1890OpeCliRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2010OpeCliVRelRef", Z2010OpeCliVRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "O1146OpeCliVRetro", localUtil.dtoc( O1146OpeCliVRetro, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "O535OpeCliValor", O535OpeCliValor);
      web.GxWebStd.gx_hidden_field( httpContext, "O754OpeCliVig", localUtil.dtoc( O754OpeCliVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "O82OpeCliId", GXutil.rtrim( O82OpeCliId));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vOPECLIID_DATA", AV15OpeCliId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vOPECLIID_DATA", AV15OpeCliId_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "NEXT_OPECLIVIG", localUtil.dtoc( AV25next_OpeCliVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vOPECLIID", GXutil.rtrim( AV8OpeCliId));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECLIID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8OpeCliId, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vOPECLIVIG", localUtil.dtoc( AV9OpeCliVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECLIVIG", getSecureSignedToken( "", AV9OpeCliVig));
      web.GxWebStd.gx_hidden_field( httpContext, "vNEXT_OPECLIVIG", localUtil.dtoc( AV25next_OpeCliVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vESSISTEMACONCEPTOSDEFAULT", AV22esSistemaConceptosDefault);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCLIENTECONVENIADOR", AV24ClienteConveniador);
      web.GxWebStd.gx_hidden_field( httpContext, "OPECLIRELSECCLI", GXutil.ltrim( localUtil.ntoc( A1904OpeCliRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV23aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "OPECLIVRELREF", A2010OpeCliVRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "OPECLIVOLD", A2032OpeCliVOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV27Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_OPECLIID_Objectcall", GXutil.rtrim( Combo_opecliid_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_OPECLIID_Cls", GXutil.rtrim( Combo_opecliid_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_OPECLIID_Selectedvalue_set", GXutil.rtrim( Combo_opecliid_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_OPECLIID_Selectedtext_set", GXutil.rtrim( Combo_opecliid_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_OPECLIID_Enabled", GXutil.booltostr( Combo_opecliid_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_OPECLIID_Datalistproc", GXutil.rtrim( Combo_opecliid_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_OPECLIID_Datalistprocparametersprefix", GXutil.rtrim( Combo_opecliid_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_OPECLIID_Emptyitem", GXutil.booltostr( Combo_opecliid_Emptyitem));
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
      return formatLink("web.variable_valores", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8OpeCliId)),GXutil.URLEncode(GXutil.formatDateParm(AV9OpeCliVig))}, new String[] {"Gx_mode","CliCod","OpeCliId","OpeCliVig"})  ;
   }

   public String getPgmname( )
   {
      return "variable_valores" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "variable_valores", "") ;
   }

   public void initializeNonKey2L81( )
   {
      AV23aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
      A1904OpeCliRelSecCli = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1904OpeCliRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1904OpeCliRelSecCli), 6, 0));
      AV25next_OpeCliVig = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25next_OpeCliVig", localUtil.format(AV25next_OpeCliVig, "99/99/99"));
      A535OpeCliValor = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A535OpeCliValor", A535OpeCliValor);
      A924OpeCliVPropagar = false ;
      n924OpeCliVPropagar = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A924OpeCliVPropagar", A924OpeCliVPropagar);
      n924OpeCliVPropagar = ((false==A924OpeCliVPropagar) ? true : false) ;
      A1146OpeCliVRetro = GXutil.nullDate() ;
      n1146OpeCliVRetro = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1146OpeCliVRetro", localUtil.format(A1146OpeCliVRetro, "99/99/99"));
      n1146OpeCliVRetro = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A1146OpeCliVRetro)) ? true : false) ;
      A1890OpeCliRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1890OpeCliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1890OpeCliRelSec), 6, 0));
      A2010OpeCliVRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2010OpeCliVRelRef", A2010OpeCliVRelRef);
      A2032OpeCliVOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2032OpeCliVOld", A2032OpeCliVOld);
      O1146OpeCliVRetro = A1146OpeCliVRetro ;
      n1146OpeCliVRetro = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1146OpeCliVRetro", localUtil.format(A1146OpeCliVRetro, "99/99/99"));
      O535OpeCliValor = A535OpeCliValor ;
      httpContext.ajax_rsp_assign_attri("", false, "A535OpeCliValor", A535OpeCliValor);
      Z1904OpeCliRelSecCli = 0 ;
      Z924OpeCliVPropagar = false ;
      Z1146OpeCliVRetro = GXutil.nullDate() ;
      Z1890OpeCliRelSec = 0 ;
      Z2010OpeCliVRelRef = "" ;
   }

   public void initAll2L81( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A82OpeCliId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
      A754OpeCliVig = AV25next_OpeCliVig ;
      httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
      initializeNonKey2L81( ) ;
   }

   public void standaloneModalInsert( )
   {
      A1904OpeCliRelSecCli = i1904OpeCliRelSecCli ;
      httpContext.ajax_rsp_assign_attri("", false, "A1904OpeCliRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1904OpeCliRelSecCli), 6, 0));
      AV25next_OpeCliVig = iV25next_OpeCliVig ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25next_OpeCliVig", localUtil.format(AV25next_OpeCliVig, "99/99/99"));
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020443191", true, true);
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
      httpContext.AddJavascriptSource("variable_valores.js", "?2024122020443191", false, true);
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
      lblTextblockopecliid_Internalname = "TEXTBLOCKOPECLIID" ;
      Combo_opecliid_Internalname = "COMBO_OPECLIID" ;
      edtOpeCliId_Internalname = "OPECLIID" ;
      divTablesplittedopecliid_Internalname = "TABLESPLITTEDOPECLIID" ;
      edtOpeCliVig_Internalname = "OPECLIVIG" ;
      edtOpeCliValor_Internalname = "OPECLIVALOR" ;
      edtOpeCliVRetro_Internalname = "OPECLIVRETRO" ;
      dynOpeCliRelSec.setInternalname( "OPECLIRELSEC" );
      divOpeclirelsec_cell_Internalname = "OPECLIRELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboopecliid_Internalname = "vCOMBOOPECLIID" ;
      divSectionattribute_opecliid_Internalname = "SECTIONATTRIBUTE_OPECLIID" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtOpeCliVPropagar_Internalname = "OPECLIVPROPAGAR" ;
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
      Form.setCaption( httpContext.getMessage( "variable_valores", "") );
      Combo_opecliid_Datalistprocparametersprefix = "" ;
      edtOpeCliVPropagar_Jsonclick = "" ;
      edtOpeCliVPropagar_Enabled = 1 ;
      edtOpeCliVPropagar_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavComboopecliid_Jsonclick = "" ;
      edtavComboopecliid_Enabled = 0 ;
      edtavComboopecliid_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynOpeCliRelSec.setJsonclick( "" );
      dynOpeCliRelSec.setEnabled( 1 );
      dynOpeCliRelSec.setVisible( 1 );
      divOpeclirelsec_cell_Class = "col-xs-12" ;
      edtOpeCliVRetro_Jsonclick = "" ;
      edtOpeCliVRetro_Enabled = 1 ;
      edtOpeCliValor_Enabled = 1 ;
      edtOpeCliVig_Jsonclick = "" ;
      edtOpeCliVig_Enabled = 1 ;
      edtOpeCliId_Jsonclick = "" ;
      edtOpeCliId_Enabled = 1 ;
      edtOpeCliId_Visible = 1 ;
      Combo_opecliid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_opecliid_Datalistproc = "variable_valoresLoadDVCombo" ;
      Combo_opecliid_Cls = "ExtendedCombo Attribute" ;
      Combo_opecliid_Caption = "" ;
      Combo_opecliid_Enabled = GXutil.toBoolean( -1) ;
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

   public void gxdlaopeclirelsec2L81( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaopeclirelsec_data2L81( AV7CliCod) ;
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

   public void gxaopeclirelsec_html2L81( int AV7CliCod )
   {
      int gxdynajaxvalue;
      gxdlaopeclirelsec_data2L81( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynOpeCliRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynOpeCliRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaopeclirelsec_data2L81( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T002L14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(12) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T002L14_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T002L14_A1880CliReDTChar[0]);
         pr_default.readNext(12);
      }
      pr_default.close(12);
   }

   public void gx1asaclicod2L81( int AV7CliCod )
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
            GXt_int12 = A3CliCod ;
            GXv_int13[0] = GXt_int12 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int13) ;
            variable_valores_impl.this.GXt_int12 = GXv_int13[0] ;
            A3CliCod = GXt_int12 ;
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

   public void xc_15_2L81( String Gx_mode ,
                           int AV7CliCod ,
                           int A1890OpeCliRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV23aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1890OpeCliRelSec, GXv_boolean5) ;
         AV23aplicadoHay = GXv_boolean5[0] ;
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

   public void xc_17_2L81( )
   {
      if ( isIns( )  )
      {
         GXv_date14[0] = AV25next_OpeCliVig ;
         new web.getopeclinextfecha(remoteHandle, context).execute( AV7CliCod, AV8OpeCliId, GXutil.serverDate( context, remoteHandle, pr_default), GXv_date14) ;
         AV25next_OpeCliVig = GXv_date14[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25next_OpeCliVig", localUtil.format(AV25next_OpeCliVig, "99/99/99"));
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
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
      dynOpeCliRelSec.setName( "OPECLIRELSEC" );
      dynOpeCliRelSec.setWebtags( "" );
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

   public void valid_Clicod( )
   {
      A1890OpeCliRelSec = (int)(GXutil.lval( dynOpeCliRelSec.getValue())) ;
      /* Using cursor T002L15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Variable", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OPECLIID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Opeclirelsec( )
   {
      n1146OpeCliVRetro = false ;
      A1890OpeCliRelSec = (int)(GXutil.lval( dynOpeCliRelSec.getValue())) ;
      if ( ( ( ( AV22esSistemaConceptosDefault ) || ( AV24ClienteConveniador ) ) && ( ( GXutil.strcmp(A82OpeCliId, O82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(O754OpeCliVig)) ) || ( GXutil.strcmp(A535OpeCliValor, O535OpeCliValor) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1146OpeCliVRetro), GXutil.resetTime(O1146OpeCliVRetro)) ) ) ) && (0==A1890OpeCliRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "OPECLIRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynOpeCliRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV23aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1890OpeCliRelSec, GXv_boolean5) ;
         variable_valores_impl.this.AV23aplicadoHay = GXv_boolean5[0] ;
         AV23aplicadoHay = this.AV23aplicadoHay ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8OpeCliId',fld:'vOPECLIID',pic:'',hsh:true},{av:'AV9OpeCliVig',fld:'vOPECLIVIG',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8OpeCliId',fld:'vOPECLIID',pic:'',hsh:true},{av:'AV9OpeCliVig',fld:'vOPECLIVIG',pic:'',hsh:true},{av:'A1904OpeCliRelSecCli',fld:'OPECLIRELSECCLI',pic:'ZZZZZ9'},{av:'AV25next_OpeCliVig',fld:'vNEXT_OPECLIVIG',pic:''},{av:'A2010OpeCliVRelRef',fld:'OPECLIVRELREF',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("AFTER TRN","{handler:'e122L2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A82OpeCliId',fld:'OPECLIID',pic:''},{av:'A754OpeCliVig',fld:'OPECLIVIG',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_OPECLIID","{handler:'valid_Opecliid',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_OPECLIID",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_OPECLIVIG","{handler:'valid_Opeclivig',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_OPECLIVIG",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_OPECLIVALOR","{handler:'valid_Opeclivalor',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_OPECLIVALOR",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_OPECLIVRETRO","{handler:'valid_Opeclivretro',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_OPECLIVRETRO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_OPECLIRELSEC","{handler:'valid_Opeclirelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O1146OpeCliVRetro'},{av:'O535OpeCliValor'},{av:'O754OpeCliVig'},{av:'O82OpeCliId'},{av:'AV22esSistemaConceptosDefault',fld:'vESSISTEMACONCEPTOSDEFAULT',pic:''},{av:'AV24ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:''},{av:'A82OpeCliId',fld:'OPECLIID',pic:''},{av:'A754OpeCliVig',fld:'OPECLIVIG',pic:''},{av:'A535OpeCliValor',fld:'OPECLIVALOR',pic:''},{av:'A1146OpeCliVRetro',fld:'OPECLIVRETRO',pic:''},{av:'AV23aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_OPECLIRELSEC",",oparms:[{av:'AV23aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALIDV_COMBOOPECLIID","{handler:'validv_Comboopecliid',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALIDV_COMBOOPECLIID",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A82OpeCliId',fld:'OPECLIID',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynOpeCliRelSec'},{av:'A1890OpeCliRelSec',fld:'OPECLIRELSEC',pic:'ZZZZZ9'}]}");
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
      wcpOAV8OpeCliId = "" ;
      wcpOAV9OpeCliVig = GXutil.nullDate() ;
      Z82OpeCliId = "" ;
      Z754OpeCliVig = GXutil.nullDate() ;
      Z1146OpeCliVRetro = GXutil.nullDate() ;
      Z2010OpeCliVRelRef = "" ;
      O1146OpeCliVRetro = GXutil.nullDate() ;
      O535OpeCliValor = "" ;
      O754OpeCliVig = GXutil.nullDate() ;
      O82OpeCliId = "" ;
      Combo_opecliid_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A82OpeCliId = "" ;
      AV8OpeCliId = "" ;
      AV9OpeCliVig = GXutil.nullDate() ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockopecliid_Jsonclick = "" ;
      ucCombo_opecliid = new com.genexus.webpanels.GXUserControl();
      AV16DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV15OpeCliId_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A754OpeCliVig = GXutil.nullDate() ;
      ClassString = "" ;
      StyleString = "" ;
      A535OpeCliValor = "" ;
      A1146OpeCliVRetro = GXutil.nullDate() ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV20ComboOpeCliId = "" ;
      A2010OpeCliVRelRef = "" ;
      AV25next_OpeCliVig = GXutil.nullDate() ;
      A2032OpeCliVOld = "" ;
      AV27Pgmname = "" ;
      Combo_opecliid_Objectcall = "" ;
      Combo_opecliid_Class = "" ;
      Combo_opecliid_Icontype = "" ;
      Combo_opecliid_Icon = "" ;
      Combo_opecliid_Tooltip = "" ;
      Combo_opecliid_Selectedvalue_set = "" ;
      Combo_opecliid_Selectedtext_set = "" ;
      Combo_opecliid_Selectedtext_get = "" ;
      Combo_opecliid_Gamoauthtoken = "" ;
      Combo_opecliid_Ddointernalname = "" ;
      Combo_opecliid_Titlecontrolalign = "" ;
      Combo_opecliid_Dropdownoptionstype = "" ;
      Combo_opecliid_Titlecontrolidtoreplace = "" ;
      Combo_opecliid_Datalisttype = "" ;
      Combo_opecliid_Datalistfixedvalues = "" ;
      Combo_opecliid_Remoteservicesparameters = "" ;
      Combo_opecliid_Htmltemplate = "" ;
      Combo_opecliid_Multiplevaluestype = "" ;
      Combo_opecliid_Loadingdata = "" ;
      Combo_opecliid_Noresultsfound = "" ;
      Combo_opecliid_Emptyitemtext = "" ;
      Combo_opecliid_Onlyselectedvalues = "" ;
      Combo_opecliid_Selectalltext = "" ;
      Combo_opecliid_Multiplevaluesseparator = "" ;
      Combo_opecliid_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode81 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      GXv_int7 = new short[1] ;
      AV19Combo_DataJson = "" ;
      GXt_char8 = "" ;
      AV17ComboSelectedValue = "" ;
      GXv_char9 = new String[1] ;
      AV18ComboSelectedText = "" ;
      GXv_char10 = new String[1] ;
      GXv_char11 = new String[1] ;
      Z535OpeCliValor = "" ;
      Z2032OpeCliVOld = "" ;
      T002L5_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      T002L5_A1904OpeCliRelSecCli = new int[1] ;
      T002L5_A535OpeCliValor = new String[] {""} ;
      T002L5_A924OpeCliVPropagar = new boolean[] {false} ;
      T002L5_n924OpeCliVPropagar = new boolean[] {false} ;
      T002L5_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      T002L5_n1146OpeCliVRetro = new boolean[] {false} ;
      T002L5_A1890OpeCliRelSec = new int[1] ;
      T002L5_A2010OpeCliVRelRef = new String[] {""} ;
      T002L5_A2032OpeCliVOld = new String[] {""} ;
      T002L5_A3CliCod = new int[1] ;
      T002L5_A82OpeCliId = new String[] {""} ;
      T002L4_A3CliCod = new int[1] ;
      T002L6_A3CliCod = new int[1] ;
      T002L7_A3CliCod = new int[1] ;
      T002L7_A82OpeCliId = new String[] {""} ;
      T002L7_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      T002L3_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      T002L3_A1904OpeCliRelSecCli = new int[1] ;
      T002L3_A535OpeCliValor = new String[] {""} ;
      T002L3_A924OpeCliVPropagar = new boolean[] {false} ;
      T002L3_n924OpeCliVPropagar = new boolean[] {false} ;
      T002L3_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      T002L3_n1146OpeCliVRetro = new boolean[] {false} ;
      T002L3_A1890OpeCliRelSec = new int[1] ;
      T002L3_A2010OpeCliVRelRef = new String[] {""} ;
      T002L3_A2032OpeCliVOld = new String[] {""} ;
      T002L3_A3CliCod = new int[1] ;
      T002L3_A82OpeCliId = new String[] {""} ;
      T002L8_A3CliCod = new int[1] ;
      T002L8_A82OpeCliId = new String[] {""} ;
      T002L8_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      T002L9_A3CliCod = new int[1] ;
      T002L9_A82OpeCliId = new String[] {""} ;
      T002L9_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      T002L2_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      T002L2_A1904OpeCliRelSecCli = new int[1] ;
      T002L2_A535OpeCliValor = new String[] {""} ;
      T002L2_A924OpeCliVPropagar = new boolean[] {false} ;
      T002L2_n924OpeCliVPropagar = new boolean[] {false} ;
      T002L2_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      T002L2_n1146OpeCliVRetro = new boolean[] {false} ;
      T002L2_A1890OpeCliRelSec = new int[1] ;
      T002L2_A2010OpeCliVRelRef = new String[] {""} ;
      T002L2_A2032OpeCliVOld = new String[] {""} ;
      T002L2_A3CliCod = new int[1] ;
      T002L2_A82OpeCliId = new String[] {""} ;
      T002L13_A3CliCod = new int[1] ;
      T002L13_A82OpeCliId = new String[] {""} ;
      T002L13_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      iV25next_OpeCliVig = GXutil.nullDate() ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T002L14_A3CliCod = new int[1] ;
      T002L14_A1885CliRelSec = new int[1] ;
      T002L14_A1880CliReDTChar = new String[] {""} ;
      GXv_int13 = new int[1] ;
      GXv_date14 = new java.util.Date[1] ;
      T002L15_A3CliCod = new int[1] ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.variable_valores__default(),
         new Object[] {
             new Object[] {
            T002L2_A754OpeCliVig, T002L2_A1904OpeCliRelSecCli, T002L2_A535OpeCliValor, T002L2_A924OpeCliVPropagar, T002L2_n924OpeCliVPropagar, T002L2_A1146OpeCliVRetro, T002L2_n1146OpeCliVRetro, T002L2_A1890OpeCliRelSec, T002L2_A2010OpeCliVRelRef, T002L2_A2032OpeCliVOld,
            T002L2_A3CliCod, T002L2_A82OpeCliId
            }
            , new Object[] {
            T002L3_A754OpeCliVig, T002L3_A1904OpeCliRelSecCli, T002L3_A535OpeCliValor, T002L3_A924OpeCliVPropagar, T002L3_n924OpeCliVPropagar, T002L3_A1146OpeCliVRetro, T002L3_n1146OpeCliVRetro, T002L3_A1890OpeCliRelSec, T002L3_A2010OpeCliVRelRef, T002L3_A2032OpeCliVOld,
            T002L3_A3CliCod, T002L3_A82OpeCliId
            }
            , new Object[] {
            T002L4_A3CliCod
            }
            , new Object[] {
            T002L5_A754OpeCliVig, T002L5_A1904OpeCliRelSecCli, T002L5_A535OpeCliValor, T002L5_A924OpeCliVPropagar, T002L5_n924OpeCliVPropagar, T002L5_A1146OpeCliVRetro, T002L5_n1146OpeCliVRetro, T002L5_A1890OpeCliRelSec, T002L5_A2010OpeCliVRelRef, T002L5_A2032OpeCliVOld,
            T002L5_A3CliCod, T002L5_A82OpeCliId
            }
            , new Object[] {
            T002L6_A3CliCod
            }
            , new Object[] {
            T002L7_A3CliCod, T002L7_A82OpeCliId, T002L7_A754OpeCliVig
            }
            , new Object[] {
            T002L8_A3CliCod, T002L8_A82OpeCliId, T002L8_A754OpeCliVig
            }
            , new Object[] {
            T002L9_A3CliCod, T002L9_A82OpeCliId, T002L9_A754OpeCliVig
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002L13_A3CliCod, T002L13_A82OpeCliId, T002L13_A754OpeCliVig
            }
            , new Object[] {
            T002L14_A3CliCod, T002L14_A1885CliRelSec, T002L14_A1880CliReDTChar
            }
            , new Object[] {
            T002L15_A3CliCod
            }
         }
      );
      AV27Pgmname = "variable_valores" ;
      Z754OpeCliVig = GXutil.nullDate() ;
      O754OpeCliVig = GXutil.nullDate() ;
      A754OpeCliVig = GXutil.nullDate() ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound81 ;
   private short AV21EmpCod ;
   private short GXt_int6 ;
   private short GXv_int7[] ;
   private short nIsDirty_81 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z1904OpeCliRelSecCli ;
   private int Z1890OpeCliRelSec ;
   private int AV7CliCod ;
   private int A1890OpeCliRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtOpeCliId_Visible ;
   private int edtOpeCliId_Enabled ;
   private int edtOpeCliVig_Enabled ;
   private int edtOpeCliValor_Enabled ;
   private int edtOpeCliVRetro_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavComboopecliid_Visible ;
   private int edtavComboopecliid_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtOpeCliVPropagar_Visible ;
   private int edtOpeCliVPropagar_Enabled ;
   private int A1904OpeCliRelSecCli ;
   private int Combo_opecliid_Datalistupdateminimumcharacters ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int i1904OpeCliRelSecCli ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int12 ;
   private int GXv_int13[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8OpeCliId ;
   private String Z82OpeCliId ;
   private String O82OpeCliId ;
   private String Combo_opecliid_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String A82OpeCliId ;
   private String AV8OpeCliId ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtOpeCliId_Internalname ;
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
   private String divTablesplittedopecliid_Internalname ;
   private String lblTextblockopecliid_Internalname ;
   private String lblTextblockopecliid_Jsonclick ;
   private String Combo_opecliid_Caption ;
   private String Combo_opecliid_Cls ;
   private String Combo_opecliid_Datalistproc ;
   private String Combo_opecliid_Internalname ;
   private String TempTags ;
   private String edtOpeCliId_Jsonclick ;
   private String edtOpeCliVig_Internalname ;
   private String edtOpeCliVig_Jsonclick ;
   private String edtOpeCliValor_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtOpeCliVRetro_Internalname ;
   private String edtOpeCliVRetro_Jsonclick ;
   private String divOpeclirelsec_cell_Internalname ;
   private String divOpeclirelsec_cell_Class ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_opecliid_Internalname ;
   private String edtavComboopecliid_Internalname ;
   private String AV20ComboOpeCliId ;
   private String edtavComboopecliid_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtOpeCliVPropagar_Internalname ;
   private String edtOpeCliVPropagar_Jsonclick ;
   private String AV27Pgmname ;
   private String Combo_opecliid_Objectcall ;
   private String Combo_opecliid_Class ;
   private String Combo_opecliid_Icontype ;
   private String Combo_opecliid_Icon ;
   private String Combo_opecliid_Tooltip ;
   private String Combo_opecliid_Selectedvalue_set ;
   private String Combo_opecliid_Selectedtext_set ;
   private String Combo_opecliid_Selectedtext_get ;
   private String Combo_opecliid_Gamoauthtoken ;
   private String Combo_opecliid_Ddointernalname ;
   private String Combo_opecliid_Titlecontrolalign ;
   private String Combo_opecliid_Dropdownoptionstype ;
   private String Combo_opecliid_Titlecontrolidtoreplace ;
   private String Combo_opecliid_Datalisttype ;
   private String Combo_opecliid_Datalistfixedvalues ;
   private String Combo_opecliid_Datalistprocparametersprefix ;
   private String Combo_opecliid_Remoteservicesparameters ;
   private String Combo_opecliid_Htmltemplate ;
   private String Combo_opecliid_Multiplevaluestype ;
   private String Combo_opecliid_Loadingdata ;
   private String Combo_opecliid_Noresultsfound ;
   private String Combo_opecliid_Emptyitemtext ;
   private String Combo_opecliid_Onlyselectedvalues ;
   private String Combo_opecliid_Selectalltext ;
   private String Combo_opecliid_Multiplevaluesseparator ;
   private String Combo_opecliid_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode81 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private String GXv_char10[] ;
   private String GXv_char11[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private java.util.Date wcpOAV9OpeCliVig ;
   private java.util.Date Z754OpeCliVig ;
   private java.util.Date Z1146OpeCliVRetro ;
   private java.util.Date O1146OpeCliVRetro ;
   private java.util.Date O754OpeCliVig ;
   private java.util.Date AV9OpeCliVig ;
   private java.util.Date A754OpeCliVig ;
   private java.util.Date A1146OpeCliVRetro ;
   private java.util.Date AV25next_OpeCliVig ;
   private java.util.Date iV25next_OpeCliVig ;
   private java.util.Date GXv_date14[] ;
   private boolean Z924OpeCliVPropagar ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_opecliid_Emptyitem ;
   private boolean A924OpeCliVPropagar ;
   private boolean n924OpeCliVPropagar ;
   private boolean n1146OpeCliVRetro ;
   private boolean AV22esSistemaConceptosDefault ;
   private boolean AV24ClienteConveniador ;
   private boolean AV23aplicadoHay ;
   private boolean Combo_opecliid_Enabled ;
   private boolean Combo_opecliid_Visible ;
   private boolean Combo_opecliid_Allowmultipleselection ;
   private boolean Combo_opecliid_Isgriditem ;
   private boolean Combo_opecliid_Hasdescription ;
   private boolean Combo_opecliid_Includeonlyselectedoption ;
   private boolean Combo_opecliid_Includeselectalloption ;
   private boolean Combo_opecliid_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXv_boolean5[] ;
   private boolean ZV23aplicadoHay ;
   private String O535OpeCliValor ;
   private String A535OpeCliValor ;
   private String A2032OpeCliVOld ;
   private String AV19Combo_DataJson ;
   private String Z535OpeCliValor ;
   private String Z2032OpeCliVOld ;
   private String Z2010OpeCliVRelRef ;
   private String A2010OpeCliVRelRef ;
   private String AV17ComboSelectedValue ;
   private String AV18ComboSelectedText ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_opecliid ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynOpeCliRelSec ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] T002L5_A754OpeCliVig ;
   private int[] T002L5_A1904OpeCliRelSecCli ;
   private String[] T002L5_A535OpeCliValor ;
   private boolean[] T002L5_A924OpeCliVPropagar ;
   private boolean[] T002L5_n924OpeCliVPropagar ;
   private java.util.Date[] T002L5_A1146OpeCliVRetro ;
   private boolean[] T002L5_n1146OpeCliVRetro ;
   private int[] T002L5_A1890OpeCliRelSec ;
   private String[] T002L5_A2010OpeCliVRelRef ;
   private String[] T002L5_A2032OpeCliVOld ;
   private int[] T002L5_A3CliCod ;
   private String[] T002L5_A82OpeCliId ;
   private int[] T002L4_A3CliCod ;
   private int[] T002L6_A3CliCod ;
   private int[] T002L7_A3CliCod ;
   private String[] T002L7_A82OpeCliId ;
   private java.util.Date[] T002L7_A754OpeCliVig ;
   private java.util.Date[] T002L3_A754OpeCliVig ;
   private int[] T002L3_A1904OpeCliRelSecCli ;
   private String[] T002L3_A535OpeCliValor ;
   private boolean[] T002L3_A924OpeCliVPropagar ;
   private boolean[] T002L3_n924OpeCliVPropagar ;
   private java.util.Date[] T002L3_A1146OpeCliVRetro ;
   private boolean[] T002L3_n1146OpeCliVRetro ;
   private int[] T002L3_A1890OpeCliRelSec ;
   private String[] T002L3_A2010OpeCliVRelRef ;
   private String[] T002L3_A2032OpeCliVOld ;
   private int[] T002L3_A3CliCod ;
   private String[] T002L3_A82OpeCliId ;
   private int[] T002L8_A3CliCod ;
   private String[] T002L8_A82OpeCliId ;
   private java.util.Date[] T002L8_A754OpeCliVig ;
   private int[] T002L9_A3CliCod ;
   private String[] T002L9_A82OpeCliId ;
   private java.util.Date[] T002L9_A754OpeCliVig ;
   private java.util.Date[] T002L2_A754OpeCliVig ;
   private int[] T002L2_A1904OpeCliRelSecCli ;
   private String[] T002L2_A535OpeCliValor ;
   private boolean[] T002L2_A924OpeCliVPropagar ;
   private boolean[] T002L2_n924OpeCliVPropagar ;
   private java.util.Date[] T002L2_A1146OpeCliVRetro ;
   private boolean[] T002L2_n1146OpeCliVRetro ;
   private int[] T002L2_A1890OpeCliRelSec ;
   private String[] T002L2_A2010OpeCliVRelRef ;
   private String[] T002L2_A2032OpeCliVOld ;
   private int[] T002L2_A3CliCod ;
   private String[] T002L2_A82OpeCliId ;
   private int[] T002L13_A3CliCod ;
   private String[] T002L13_A82OpeCliId ;
   private java.util.Date[] T002L13_A754OpeCliVig ;
   private int[] T002L14_A3CliCod ;
   private int[] T002L14_A1885CliRelSec ;
   private String[] T002L14_A1880CliReDTChar ;
   private int[] T002L15_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV15OpeCliId_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV16DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class variable_valores__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T002L2", "SELECT OpeCliVig, OpeCliRelSecCli, OpeCliValor, OpeCliVPropagar, OpeCliVRetro, OpeCliRelSec, OpeCliVRelRef, OpeCliVOld, CliCod, OpeCliId FROM variable_valores WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ?  FOR UPDATE OF variable_valores NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002L3", "SELECT OpeCliVig, OpeCliRelSecCli, OpeCliValor, OpeCliVPropagar, OpeCliVRetro, OpeCliRelSec, OpeCliVRelRef, OpeCliVOld, CliCod, OpeCliId FROM variable_valores WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002L4", "SELECT CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002L5", "SELECT TM1.OpeCliVig, TM1.OpeCliRelSecCli, TM1.OpeCliValor, TM1.OpeCliVPropagar, TM1.OpeCliVRetro, TM1.OpeCliRelSec, TM1.OpeCliVRelRef, TM1.OpeCliVOld, TM1.CliCod, TM1.OpeCliId FROM variable_valores TM1 WHERE TM1.CliCod = ? and TM1.OpeCliId = ( ?) and TM1.OpeCliVig = ? ORDER BY TM1.CliCod, TM1.OpeCliId, TM1.OpeCliVig ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002L6", "SELECT CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002L7", "SELECT CliCod, OpeCliId, OpeCliVig FROM variable_valores WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002L8", "SELECT CliCod, OpeCliId, OpeCliVig FROM variable_valores WHERE ( CliCod > ? or CliCod = ? and OpeCliId > ( ?) or OpeCliId = ( ?) and CliCod = ? and OpeCliVig > ?) ORDER BY CliCod, OpeCliId, OpeCliVig  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002L9", "SELECT CliCod, OpeCliId, OpeCliVig FROM variable_valores WHERE ( CliCod < ? or CliCod = ? and OpeCliId < ( ?) or OpeCliId = ( ?) and CliCod = ? and OpeCliVig < ?) ORDER BY CliCod DESC, OpeCliId DESC, OpeCliVig DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T002L10", "SAVEPOINT gxupdate;INSERT INTO variable_valores(OpeCliVig, OpeCliRelSecCli, OpeCliValor, OpeCliVPropagar, OpeCliVRetro, OpeCliRelSec, OpeCliVRelRef, OpeCliVOld, CliCod, OpeCliId) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002L11", "SAVEPOINT gxupdate;UPDATE variable_valores SET OpeCliRelSecCli=?, OpeCliValor=?, OpeCliVPropagar=?, OpeCliVRetro=?, OpeCliRelSec=?, OpeCliVRelRef=?, OpeCliVOld=?  WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002L12", "SAVEPOINT gxupdate;DELETE FROM variable_valores  WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002L13", "SELECT CliCod, OpeCliId, OpeCliVig FROM variable_valores ORDER BY CliCod, OpeCliId, OpeCliVig ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002L14", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002L15", "SELECT CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((int[]) buf[7])[0] = rslt.getInt(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 40);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((int[]) buf[7])[0] = rslt.getInt(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 40);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((int[]) buf[7])[0] = rslt.getInt(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 40);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 40);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 40);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
            case 8 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setNLongVarchar(3, (String)parms[2], false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.DATE );
               }
               else
               {
                  stmt.setDate(5, (java.util.Date)parms[6]);
               }
               stmt.setInt(6, ((Number) parms[7]).intValue());
               stmt.setVarchar(7, (String)parms[8], 40, false);
               stmt.setNLongVarchar(8, (String)parms[9], false);
               stmt.setInt(9, ((Number) parms[10]).intValue());
               stmt.setString(10, (String)parms[11], 40);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setNLongVarchar(2, (String)parms[1], false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(3, ((Boolean) parms[3]).booleanValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.DATE );
               }
               else
               {
                  stmt.setDate(4, (java.util.Date)parms[5]);
               }
               stmt.setInt(5, ((Number) parms[6]).intValue());
               stmt.setVarchar(6, (String)parms[7], 40, false);
               stmt.setNLongVarchar(7, (String)parms[8], false);
               stmt.setInt(8, ((Number) parms[9]).intValue());
               stmt.setString(9, (String)parms[10], 40);
               stmt.setDate(10, (java.util.Date)parms[11]);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
      }
   }

}

