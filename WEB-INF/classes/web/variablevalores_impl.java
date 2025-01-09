package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class variablevalores_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_11") == 0 )
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
         gxload_11( A3CliCod, A82OpeCliId) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Variable Valores", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public variablevalores_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public variablevalores_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( variablevalores_impl.class ));
   }

   public variablevalores_impl( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkOpeCliVPropagar = UIFactory.getCheckbox(this);
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
      A924OpeCliVPropagar = GXutil.strtobool( GXutil.booltostr( A924OpeCliVPropagar)) ;
      n924OpeCliVPropagar = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A924OpeCliVPropagar", A924OpeCliVPropagar);
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedclicod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockclicod_Internalname, httpContext.getMessage( "Cliente", ""), "", "", lblTextblockclicod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_VariableValores.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_clicod.setProperty("Caption", Combo_clicod_Caption);
      ucCombo_clicod.setProperty("Cls", Combo_clicod_Cls);
      ucCombo_clicod.setProperty("DataListProc", Combo_clicod_Datalistproc);
      ucCombo_clicod.setProperty("DataListProcParametersPrefix", Combo_clicod_Datalistprocparametersprefix);
      ucCombo_clicod.setProperty("EmptyItem", Combo_clicod_Emptyitem);
      ucCombo_clicod.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_clicod.setProperty("DropDownOptionsData", AV15CliCod_Data);
      ucCombo_clicod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_clicod_Internalname, "COMBO_CLICODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliCod_Internalname, httpContext.getMessage( "Cli Cod", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_VariableValores.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedopecliid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockopecliid_Internalname, httpContext.getMessage( "Variable", ""), "", "", lblTextblockopecliid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_VariableValores.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_opecliid.setProperty("Caption", Combo_opecliid_Caption);
      ucCombo_opecliid.setProperty("Cls", Combo_opecliid_Cls);
      ucCombo_opecliid.setProperty("DataListProc", Combo_opecliid_Datalistproc);
      ucCombo_opecliid.setProperty("EmptyItem", Combo_opecliid_Emptyitem);
      ucCombo_opecliid.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_opecliid.setProperty("DropDownOptionsData", AV21OpeCliId_Data);
      ucCombo_opecliid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_opecliid_Internalname, "COMBO_OPECLIIDContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOpeCliId_Internalname, httpContext.getMessage( "Id. de variable", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOpeCliId_Internalname, GXutil.rtrim( A82OpeCliId), GXutil.rtrim( localUtil.format( A82OpeCliId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOpeCliId_Jsonclick, 0, "Attribute", "", "", "", "", edtOpeCliId_Visible, edtOpeCliId_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_VariableValores.htm");
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
      web.GxWebStd.gx_label_element( httpContext, edtOpeCliVig_Internalname, httpContext.getMessage( "Vigencia desde", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtOpeCliVig_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOpeCliVig_Internalname, localUtil.format(A754OpeCliVig, "99/99/99"), localUtil.format( A754OpeCliVig, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOpeCliVig_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtOpeCliVig_Enabled, 1, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_VariableValores.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtOpeCliVig_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtOpeCliVig_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_VariableValores.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtOpeCliValor_Internalname, A535OpeCliValor, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", (short)(0), 1, edtOpeCliValor_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "500000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_VariableValores.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkOpeCliVPropagar.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkOpeCliVPropagar.getInternalname(), httpContext.getMessage( "(borrar)", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkOpeCliVPropagar.getInternalname(), GXutil.booltostr( A924OpeCliVPropagar), "", httpContext.getMessage( "(borrar)", ""), 1, chkOpeCliVPropagar.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(54, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,54);\"");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtOpeCliVRetro_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOpeCliVRetro_Internalname, localUtil.format(A1146OpeCliVRetro, "99/99/99"), localUtil.format( A1146OpeCliVRetro, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOpeCliVRetro_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtOpeCliVRetro_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_VariableValores.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtOpeCliVRetro_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtOpeCliVRetro_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_VariableValores.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_VariableValores.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_VariableValores.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_VariableValores.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_clicod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboclicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV20ComboCliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavComboclicod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV20ComboCliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV20ComboCliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboclicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboclicod_Visible, edtavComboclicod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_VariableValores.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_opecliid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboopecliid_Internalname, GXutil.rtrim( AV22ComboOpeCliId), GXutil.rtrim( localUtil.format( AV22ComboOpeCliId, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboopecliid_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboopecliid_Visible, edtavComboopecliid_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_VariableValores.htm");
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
      e11552 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV16DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCLICOD_DATA"), AV15CliCod_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vOPECLIID_DATA"), AV21OpeCliId_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z82OpeCliId = httpContext.cgiGet( "Z82OpeCliId") ;
            Z754OpeCliVig = localUtil.ctod( httpContext.cgiGet( "Z754OpeCliVig"), 0) ;
            Z924OpeCliVPropagar = GXutil.strtobool( httpContext.cgiGet( "Z924OpeCliVPropagar")) ;
            n924OpeCliVPropagar = ((false==A924OpeCliVPropagar) ? true : false) ;
            Z1146OpeCliVRetro = localUtil.ctod( httpContext.cgiGet( "Z1146OpeCliVRetro"), 0) ;
            n1146OpeCliVRetro = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A1146OpeCliVRetro)) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV23Cond_CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCOND_CLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8OpeCliId = httpContext.cgiGet( "vOPECLIID") ;
            AV9OpeCliVig = localUtil.ctod( httpContext.cgiGet( "vOPECLIVIG"), 0) ;
            AV24Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_clicod_Objectcall = httpContext.cgiGet( "COMBO_CLICOD_Objectcall") ;
            Combo_clicod_Class = httpContext.cgiGet( "COMBO_CLICOD_Class") ;
            Combo_clicod_Icontype = httpContext.cgiGet( "COMBO_CLICOD_Icontype") ;
            Combo_clicod_Icon = httpContext.cgiGet( "COMBO_CLICOD_Icon") ;
            Combo_clicod_Caption = httpContext.cgiGet( "COMBO_CLICOD_Caption") ;
            Combo_clicod_Tooltip = httpContext.cgiGet( "COMBO_CLICOD_Tooltip") ;
            Combo_clicod_Cls = httpContext.cgiGet( "COMBO_CLICOD_Cls") ;
            Combo_clicod_Selectedvalue_set = httpContext.cgiGet( "COMBO_CLICOD_Selectedvalue_set") ;
            Combo_clicod_Selectedvalue_get = httpContext.cgiGet( "COMBO_CLICOD_Selectedvalue_get") ;
            Combo_clicod_Selectedtext_set = httpContext.cgiGet( "COMBO_CLICOD_Selectedtext_set") ;
            Combo_clicod_Selectedtext_get = httpContext.cgiGet( "COMBO_CLICOD_Selectedtext_get") ;
            Combo_clicod_Gamoauthtoken = httpContext.cgiGet( "COMBO_CLICOD_Gamoauthtoken") ;
            Combo_clicod_Ddointernalname = httpContext.cgiGet( "COMBO_CLICOD_Ddointernalname") ;
            Combo_clicod_Titlecontrolalign = httpContext.cgiGet( "COMBO_CLICOD_Titlecontrolalign") ;
            Combo_clicod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CLICOD_Dropdownoptionstype") ;
            Combo_clicod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Enabled")) ;
            Combo_clicod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Visible")) ;
            Combo_clicod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CLICOD_Titlecontrolidtoreplace") ;
            Combo_clicod_Datalisttype = httpContext.cgiGet( "COMBO_CLICOD_Datalisttype") ;
            Combo_clicod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Allowmultipleselection")) ;
            Combo_clicod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CLICOD_Datalistfixedvalues") ;
            Combo_clicod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Isgriditem")) ;
            Combo_clicod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Hasdescription")) ;
            Combo_clicod_Datalistproc = httpContext.cgiGet( "COMBO_CLICOD_Datalistproc") ;
            Combo_clicod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CLICOD_Datalistprocparametersprefix") ;
            Combo_clicod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CLICOD_Remoteservicesparameters") ;
            Combo_clicod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CLICOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_clicod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Includeonlyselectedoption")) ;
            Combo_clicod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Includeselectalloption")) ;
            Combo_clicod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Emptyitem")) ;
            Combo_clicod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLICOD_Includeaddnewoption")) ;
            Combo_clicod_Htmltemplate = httpContext.cgiGet( "COMBO_CLICOD_Htmltemplate") ;
            Combo_clicod_Multiplevaluestype = httpContext.cgiGet( "COMBO_CLICOD_Multiplevaluestype") ;
            Combo_clicod_Loadingdata = httpContext.cgiGet( "COMBO_CLICOD_Loadingdata") ;
            Combo_clicod_Noresultsfound = httpContext.cgiGet( "COMBO_CLICOD_Noresultsfound") ;
            Combo_clicod_Emptyitemtext = httpContext.cgiGet( "COMBO_CLICOD_Emptyitemtext") ;
            Combo_clicod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CLICOD_Onlyselectedvalues") ;
            Combo_clicod_Selectalltext = httpContext.cgiGet( "COMBO_CLICOD_Selectalltext") ;
            Combo_clicod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CLICOD_Multiplevaluesseparator") ;
            Combo_clicod_Addnewoptiontext = httpContext.cgiGet( "COMBO_CLICOD_Addnewoptiontext") ;
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
            A924OpeCliVPropagar = GXutil.strtobool( httpContext.cgiGet( chkOpeCliVPropagar.getInternalname())) ;
            n924OpeCliVPropagar = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A924OpeCliVPropagar", A924OpeCliVPropagar);
            n924OpeCliVPropagar = ((false==A924OpeCliVPropagar) ? true : false) ;
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
            AV20ComboCliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtavComboclicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboCliCod), 6, 0));
            AV22ComboOpeCliId = httpContext.cgiGet( edtavComboopecliid_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22ComboOpeCliId", AV22ComboOpeCliId);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"VariableValores");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A82OpeCliId, Z82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(Z754OpeCliVig)) ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("variablevalores:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
                        confirm_550( ) ;
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
                        e11552 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12552 ();
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
         e12552 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll5581( ) ;
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
         disableAttributes5581( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclicod_Enabled), 5, 0), true);
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

   public void confirm_550( )
   {
      beforeValidate5581( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls5581( ) ;
         }
         else
         {
            checkExtendedTable5581( ) ;
            closeExtendedTableCursors5581( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption550( )
   {
   }

   public void e11552( )
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
      AV22ComboOpeCliId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboOpeCliId", AV22ComboOpeCliId);
      edtavComboopecliid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboopecliid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboopecliid_Visible), 5, 0), true);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      AV20ComboCliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboCliCod), 6, 0));
      edtavComboclicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclicod_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCLICOD' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOOPECLIID' */
      S122 ();
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWVariableValores_Insert", GXv_boolean5) ;
         variablevalores_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWVariableValores_Update", GXv_boolean5) ;
         variablevalores_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWVariableValores_Delete", GXv_boolean5) ;
         variablevalores_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV24Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
   }

   public void e12552( )
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

   public void S122( )
   {
      /* 'LOADCOMBOOPECLIID' Routine */
      returnInSub = false ;
      Combo_opecliid_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"OpeCliId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"OpeCliId\": \"\", \"OpeCliVig\": \"\", \"Cond_CliCod\": \"#%1#\"", edtCliCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_opecliid.sendProperty(context, "", false, Combo_opecliid_Internalname, "DataListProcParametersPrefix", Combo_opecliid_Datalistprocparametersprefix);
      GXt_char6 = AV19Combo_DataJson ;
      GXv_char7[0] = AV17ComboSelectedValue ;
      GXv_char8[0] = AV18ComboSelectedText ;
      GXv_char9[0] = GXt_char6 ;
      new web.variablevaloresloaddvcombo(remoteHandle, context).execute( "OpeCliId", Gx_mode, false, AV7CliCod, AV8OpeCliId, AV9OpeCliVig, A3CliCod, "", GXv_char7, GXv_char8, GXv_char9) ;
      variablevalores_impl.this.AV17ComboSelectedValue = GXv_char7[0] ;
      variablevalores_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
      variablevalores_impl.this.GXt_char6 = GXv_char9[0] ;
      AV19Combo_DataJson = GXt_char6 ;
      Combo_opecliid_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_opecliid.sendProperty(context, "", false, Combo_opecliid_Internalname, "SelectedValue_set", Combo_opecliid_Selectedvalue_set);
      Combo_opecliid_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_opecliid.sendProperty(context, "", false, Combo_opecliid_Internalname, "SelectedText_set", Combo_opecliid_Selectedtext_set);
      AV22ComboOpeCliId = AV17ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboOpeCliId", AV22ComboOpeCliId);
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (GXutil.strcmp("", AV8OpeCliId)==0) )
      {
         Combo_opecliid_Enabled = false ;
         ucCombo_opecliid.sendProperty(context, "", false, Combo_opecliid_Internalname, "Enabled", GXutil.booltostr( Combo_opecliid_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOCLICOD' Routine */
      returnInSub = false ;
      GXt_char6 = AV19Combo_DataJson ;
      GXv_char9[0] = AV17ComboSelectedValue ;
      GXv_char8[0] = AV18ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.variablevaloresloaddvcombo(remoteHandle, context).execute( "CliCod", Gx_mode, false, AV7CliCod, AV8OpeCliId, AV9OpeCliVig, A3CliCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      variablevalores_impl.this.AV17ComboSelectedValue = GXv_char9[0] ;
      variablevalores_impl.this.AV18ComboSelectedText = GXv_char8[0] ;
      variablevalores_impl.this.GXt_char6 = GXv_char7[0] ;
      AV19Combo_DataJson = GXt_char6 ;
      Combo_clicod_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "SelectedValue_set", Combo_clicod_Selectedvalue_set);
      Combo_clicod_Selectedtext_set = AV18ComboSelectedText ;
      ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "SelectedText_set", Combo_clicod_Selectedtext_set);
      AV20ComboCliCod = (int)(GXutil.lval( AV17ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboCliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ComboCliCod), 6, 0));
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (0==AV7CliCod) )
      {
         Combo_clicod_Enabled = false ;
         ucCombo_clicod.sendProperty(context, "", false, Combo_clicod_Internalname, "Enabled", GXutil.booltostr( Combo_clicod_Enabled));
      }
   }

   public void zm5581( int GX_JID )
   {
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z924OpeCliVPropagar = T00553_A924OpeCliVPropagar[0] ;
            Z1146OpeCliVRetro = T00553_A1146OpeCliVRetro[0] ;
         }
         else
         {
            Z924OpeCliVPropagar = A924OpeCliVPropagar ;
            Z1146OpeCliVRetro = A1146OpeCliVRetro ;
         }
      }
      if ( GX_JID == -10 )
      {
         Z754OpeCliVig = A754OpeCliVig ;
         Z535OpeCliValor = A535OpeCliValor ;
         Z924OpeCliVPropagar = A924OpeCliVPropagar ;
         Z1146OpeCliVRetro = A1146OpeCliVRetro ;
         Z3CliCod = A3CliCod ;
         Z82OpeCliId = A82OpeCliId ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
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
         A754OpeCliVig = AV9OpeCliVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
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
         A82OpeCliId = AV22ComboOpeCliId ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
      }
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         A3CliCod = AV20ComboCliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
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
         AV24Pgmname = "VariableValores" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      }
   }

   public void load5581( )
   {
      /* Using cursor T00555 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound81 = (short)(1) ;
         A535OpeCliValor = T00555_A535OpeCliValor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A535OpeCliValor", A535OpeCliValor);
         A924OpeCliVPropagar = T00555_A924OpeCliVPropagar[0] ;
         n924OpeCliVPropagar = T00555_n924OpeCliVPropagar[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A924OpeCliVPropagar", A924OpeCliVPropagar);
         A1146OpeCliVRetro = T00555_A1146OpeCliVRetro[0] ;
         n1146OpeCliVRetro = T00555_n1146OpeCliVRetro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1146OpeCliVRetro", localUtil.format(A1146OpeCliVRetro, "99/99/99"));
         zm5581( -10) ;
      }
      pr_default.close(3);
      onLoadActions5581( ) ;
   }

   public void onLoadActions5581( )
   {
      AV24Pgmname = "VariableValores" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
   }

   public void checkExtendedTable5581( )
   {
      nIsDirty_81 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV24Pgmname = "VariableValores" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      /* Using cursor T00554 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Variable", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OPECLIID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
   }

   public void closeExtendedTableCursors5581( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_11( int A3CliCod ,
                          String A82OpeCliId )
   {
      /* Using cursor T00556 */
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

   public void getKey5581( )
   {
      /* Using cursor T00557 */
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
      /* Using cursor T00553 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm5581( 10) ;
         RcdFound81 = (short)(1) ;
         A754OpeCliVig = T00553_A754OpeCliVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
         A535OpeCliValor = T00553_A535OpeCliValor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A535OpeCliValor", A535OpeCliValor);
         A924OpeCliVPropagar = T00553_A924OpeCliVPropagar[0] ;
         n924OpeCliVPropagar = T00553_n924OpeCliVPropagar[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A924OpeCliVPropagar", A924OpeCliVPropagar);
         A1146OpeCliVRetro = T00553_A1146OpeCliVRetro[0] ;
         n1146OpeCliVRetro = T00553_n1146OpeCliVRetro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1146OpeCliVRetro", localUtil.format(A1146OpeCliVRetro, "99/99/99"));
         A3CliCod = T00553_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A82OpeCliId = T00553_A82OpeCliId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
         Z3CliCod = A3CliCod ;
         Z82OpeCliId = A82OpeCliId ;
         Z754OpeCliVig = A754OpeCliVig ;
         sMode81 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load5581( ) ;
         if ( AnyError == 1 )
         {
            RcdFound81 = (short)(0) ;
            initializeNonKey5581( ) ;
         }
         Gx_mode = sMode81 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound81 = (short)(0) ;
         initializeNonKey5581( ) ;
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
      getKey5581( ) ;
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
      /* Using cursor T00558 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A82OpeCliId, A82OpeCliId, Integer.valueOf(A3CliCod), A754OpeCliVig});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00558_A3CliCod[0] < A3CliCod ) || ( T00558_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00558_A82OpeCliId[0], A82OpeCliId) < 0 ) || ( GXutil.strcmp(T00558_A82OpeCliId[0], A82OpeCliId) == 0 ) && ( T00558_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T00558_A754OpeCliVig[0]).before( GXutil.resetTime( A754OpeCliVig )) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00558_A3CliCod[0] > A3CliCod ) || ( T00558_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00558_A82OpeCliId[0], A82OpeCliId) > 0 ) || ( GXutil.strcmp(T00558_A82OpeCliId[0], A82OpeCliId) == 0 ) && ( T00558_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T00558_A754OpeCliVig[0]).after( GXutil.resetTime( A754OpeCliVig )) ) )
         {
            A3CliCod = T00558_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A82OpeCliId = T00558_A82OpeCliId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
            A754OpeCliVig = T00558_A754OpeCliVig[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
            RcdFound81 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound81 = (short)(0) ;
      /* Using cursor T00559 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A82OpeCliId, A82OpeCliId, Integer.valueOf(A3CliCod), A754OpeCliVig});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00559_A3CliCod[0] > A3CliCod ) || ( T00559_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00559_A82OpeCliId[0], A82OpeCliId) > 0 ) || ( GXutil.strcmp(T00559_A82OpeCliId[0], A82OpeCliId) == 0 ) && ( T00559_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T00559_A754OpeCliVig[0]).after( GXutil.resetTime( A754OpeCliVig )) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00559_A3CliCod[0] < A3CliCod ) || ( T00559_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00559_A82OpeCliId[0], A82OpeCliId) < 0 ) || ( GXutil.strcmp(T00559_A82OpeCliId[0], A82OpeCliId) == 0 ) && ( T00559_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T00559_A754OpeCliVig[0]).before( GXutil.resetTime( A754OpeCliVig )) ) )
         {
            A3CliCod = T00559_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A82OpeCliId = T00559_A82OpeCliId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
            A754OpeCliVig = T00559_A754OpeCliVig[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
            RcdFound81 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey5581( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert5581( ) ;
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
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update5581( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A82OpeCliId, Z82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(Z754OpeCliVig)) ) )
            {
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert5581( ) ;
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
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert5581( ) ;
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
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency5581( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00552 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"variable_valores"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z924OpeCliVPropagar != T00552_A924OpeCliVPropagar[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z1146OpeCliVRetro), GXutil.resetTime(T00552_A1146OpeCliVRetro[0])) ) )
         {
            if ( Z924OpeCliVPropagar != T00552_A924OpeCliVPropagar[0] )
            {
               GXutil.writeLogln("variablevalores:[seudo value changed for attri]"+"OpeCliVPropagar");
               GXutil.writeLogRaw("Old: ",Z924OpeCliVPropagar);
               GXutil.writeLogRaw("Current: ",T00552_A924OpeCliVPropagar[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z1146OpeCliVRetro), GXutil.resetTime(T00552_A1146OpeCliVRetro[0])) ) )
            {
               GXutil.writeLogln("variablevalores:[seudo value changed for attri]"+"OpeCliVRetro");
               GXutil.writeLogRaw("Old: ",Z1146OpeCliVRetro);
               GXutil.writeLogRaw("Current: ",T00552_A1146OpeCliVRetro[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"variable_valores"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert5581( )
   {
      beforeValidate5581( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5581( ) ;
      }
      if ( AnyError == 0 )
      {
         zm5581( 0) ;
         checkOptimisticConcurrency5581( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5581( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert5581( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005510 */
                  pr_default.execute(8, new Object[] {A754OpeCliVig, A535OpeCliValor, Boolean.valueOf(n924OpeCliVPropagar), Boolean.valueOf(A924OpeCliVPropagar), Boolean.valueOf(n1146OpeCliVRetro), A1146OpeCliVRetro, Integer.valueOf(A3CliCod), A82OpeCliId});
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
                        resetCaption550( ) ;
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
            load5581( ) ;
         }
         endLevel5581( ) ;
      }
      closeExtendedTableCursors5581( ) ;
   }

   public void update5581( )
   {
      beforeValidate5581( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5581( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5581( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5581( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate5581( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005511 */
                  pr_default.execute(9, new Object[] {A535OpeCliValor, Boolean.valueOf(n924OpeCliVPropagar), Boolean.valueOf(A924OpeCliVPropagar), Boolean.valueOf(n1146OpeCliVRetro), A1146OpeCliVRetro, Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("variable_valores");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"variable_valores"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate5581( ) ;
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
         endLevel5581( ) ;
      }
      closeExtendedTableCursors5581( ) ;
   }

   public void deferredUpdate5581( )
   {
   }

   public void delete( )
   {
      beforeValidate5581( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5581( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls5581( ) ;
         afterConfirm5581( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete5581( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005512 */
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
      endLevel5581( ) ;
      Gx_mode = sMode81 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls5581( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV24Pgmname = "VariableValores" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      }
   }

   public void endLevel5581( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete5581( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "variablevalores");
         if ( AnyError == 0 )
         {
            confirmValues550( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "variablevalores");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart5581( )
   {
      /* Scan By routine */
      /* Using cursor T005513 */
      pr_default.execute(11);
      RcdFound81 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound81 = (short)(1) ;
         A3CliCod = T005513_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A82OpeCliId = T005513_A82OpeCliId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
         A754OpeCliVig = T005513_A754OpeCliVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext5581( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound81 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound81 = (short)(1) ;
         A3CliCod = T005513_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A82OpeCliId = T005513_A82OpeCliId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
         A754OpeCliVig = T005513_A754OpeCliVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
      }
   }

   public void scanEnd5581( )
   {
      pr_default.close(11);
   }

   public void afterConfirm5581( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert5581( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate5581( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete5581( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete5581( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate5581( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes5581( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtOpeCliId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliId_Enabled), 5, 0), true);
      edtOpeCliVig_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliVig_Enabled), 5, 0), true);
      edtOpeCliValor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliValor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliValor_Enabled), 5, 0), true);
      chkOpeCliVPropagar.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeCliVPropagar.getInternalname(), "Enabled", GXutil.ltrimstr( chkOpeCliVPropagar.getEnabled(), 5, 0), true);
      edtOpeCliVRetro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCliVRetro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCliVRetro_Enabled), 5, 0), true);
      edtavComboclicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclicod_Enabled), 5, 0), true);
      edtavComboopecliid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboopecliid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboopecliid_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes5581( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues550( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.variablevalores", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8OpeCliId)),GXutil.URLEncode(GXutil.formatDateParm(AV9OpeCliVig))}, new String[] {"Gx_mode","CliCod","OpeCliId","OpeCliVig"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"VariableValores");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("variablevalores:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z82OpeCliId", GXutil.rtrim( Z82OpeCliId));
      web.GxWebStd.gx_hidden_field( httpContext, "Z754OpeCliVig", localUtil.dtoc( Z754OpeCliVig, 0, "/"));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z924OpeCliVPropagar", Z924OpeCliVPropagar);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1146OpeCliVRetro", localUtil.dtoc( Z1146OpeCliVRetro, 0, "/"));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCLICOD_DATA", AV15CliCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCLICOD_DATA", AV15CliCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vOPECLIID_DATA", AV21OpeCliId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vOPECLIID_DATA", AV21OpeCliId_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCOND_CLICOD", GXutil.ltrim( localUtil.ntoc( AV23Cond_CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vOPECLIID", GXutil.rtrim( AV8OpeCliId));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECLIID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8OpeCliId, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vOPECLIVIG", localUtil.dtoc( AV9OpeCliVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECLIVIG", getSecureSignedToken( "", AV9OpeCliVig));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV24Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Objectcall", GXutil.rtrim( Combo_clicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Cls", GXutil.rtrim( Combo_clicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Selectedvalue_set", GXutil.rtrim( Combo_clicod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Selectedtext_set", GXutil.rtrim( Combo_clicod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Enabled", GXutil.booltostr( Combo_clicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Datalistproc", GXutil.rtrim( Combo_clicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_clicod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLICOD_Emptyitem", GXutil.booltostr( Combo_clicod_Emptyitem));
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
      return formatLink("web.variablevalores", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8OpeCliId)),GXutil.URLEncode(GXutil.formatDateParm(AV9OpeCliVig))}, new String[] {"Gx_mode","CliCod","OpeCliId","OpeCliVig"})  ;
   }

   public String getPgmname( )
   {
      return "VariableValores" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Variable Valores", "") ;
   }

   public void initializeNonKey5581( )
   {
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
      Z924OpeCliVPropagar = false ;
      Z1146OpeCliVRetro = GXutil.nullDate() ;
   }

   public void initAll5581( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A82OpeCliId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A82OpeCliId", A82OpeCliId);
      A754OpeCliVig = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A754OpeCliVig", localUtil.format(A754OpeCliVig, "99/99/99"));
      initializeNonKey5581( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020435873", true, true);
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
      httpContext.AddJavascriptSource("variablevalores.js", "?2024122020435873", false, true);
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
      lblTextblockclicod_Internalname = "TEXTBLOCKCLICOD" ;
      Combo_clicod_Internalname = "COMBO_CLICOD" ;
      edtCliCod_Internalname = "CLICOD" ;
      divTablesplittedclicod_Internalname = "TABLESPLITTEDCLICOD" ;
      lblTextblockopecliid_Internalname = "TEXTBLOCKOPECLIID" ;
      Combo_opecliid_Internalname = "COMBO_OPECLIID" ;
      edtOpeCliId_Internalname = "OPECLIID" ;
      divTablesplittedopecliid_Internalname = "TABLESPLITTEDOPECLIID" ;
      edtOpeCliVig_Internalname = "OPECLIVIG" ;
      edtOpeCliValor_Internalname = "OPECLIVALOR" ;
      chkOpeCliVPropagar.setInternalname( "OPECLIVPROPAGAR" );
      edtOpeCliVRetro_Internalname = "OPECLIVRETRO" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboclicod_Internalname = "vCOMBOCLICOD" ;
      divSectionattribute_clicod_Internalname = "SECTIONATTRIBUTE_CLICOD" ;
      edtavComboopecliid_Internalname = "vCOMBOOPECLIID" ;
      divSectionattribute_opecliid_Internalname = "SECTIONATTRIBUTE_OPECLIID" ;
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
      Form.setCaption( httpContext.getMessage( "Variable Valores", "") );
      Combo_opecliid_Datalistprocparametersprefix = "" ;
      edtavComboopecliid_Jsonclick = "" ;
      edtavComboopecliid_Enabled = 0 ;
      edtavComboopecliid_Visible = 1 ;
      edtavComboclicod_Jsonclick = "" ;
      edtavComboclicod_Enabled = 0 ;
      edtavComboclicod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtOpeCliVRetro_Jsonclick = "" ;
      edtOpeCliVRetro_Enabled = 1 ;
      chkOpeCliVPropagar.setEnabled( 1 );
      edtOpeCliValor_Enabled = 1 ;
      edtOpeCliVig_Jsonclick = "" ;
      edtOpeCliVig_Enabled = 1 ;
      edtOpeCliId_Jsonclick = "" ;
      edtOpeCliId_Enabled = 1 ;
      edtOpeCliId_Visible = 1 ;
      Combo_opecliid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_opecliid_Datalistproc = "VariableValoresLoadDVCombo" ;
      Combo_opecliid_Cls = "ExtendedCombo Attribute" ;
      Combo_opecliid_Caption = "" ;
      Combo_opecliid_Enabled = GXutil.toBoolean( -1) ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      Combo_clicod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_clicod_Datalistprocparametersprefix = " \"ComboName\": \"CliCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"OpeCliId\": \"\", \"OpeCliVig\": \"\"" ;
      Combo_clicod_Datalistproc = "VariableValoresLoadDVCombo" ;
      Combo_clicod_Cls = "ExtendedCombo Attribute" ;
      Combo_clicod_Caption = "" ;
      Combo_clicod_Enabled = GXutil.toBoolean( -1) ;
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
      chkOpeCliVPropagar.setName( "OPECLIVPROPAGAR" );
      chkOpeCliVPropagar.setWebtags( "" );
      chkOpeCliVPropagar.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeCliVPropagar.getInternalname(), "TitleCaption", chkOpeCliVPropagar.getCaption(), true);
      chkOpeCliVPropagar.setCheckedValue( "false" );
      A924OpeCliVPropagar = GXutil.strtobool( GXutil.booltostr( A924OpeCliVPropagar)) ;
      n924OpeCliVPropagar = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A924OpeCliVPropagar", A924OpeCliVPropagar);
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

   public void valid_Opecliid( )
   {
      /* Using cursor T005514 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Variable", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OPECLIID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8OpeCliId',fld:'vOPECLIID',pic:'',hsh:true},{av:'AV9OpeCliVig',fld:'vOPECLIVIG',pic:'',hsh:true},{av:'A924OpeCliVPropagar',fld:'OPECLIVPROPAGAR',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A924OpeCliVPropagar',fld:'OPECLIVPROPAGAR',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8OpeCliId',fld:'vOPECLIID',pic:'',hsh:true},{av:'AV9OpeCliVig',fld:'vOPECLIVIG',pic:'',hsh:true},{av:'A924OpeCliVPropagar',fld:'OPECLIVPROPAGAR',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A924OpeCliVPropagar',fld:'OPECLIVPROPAGAR',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e12552',iparms:[{av:'A924OpeCliVPropagar',fld:'OPECLIVPROPAGAR',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A924OpeCliVPropagar',fld:'OPECLIVPROPAGAR',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A924OpeCliVPropagar',fld:'OPECLIVPROPAGAR',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A924OpeCliVPropagar',fld:'OPECLIVPROPAGAR',pic:''}]}");
      setEventMetadata("VALID_OPECLIID","{handler:'valid_Opecliid',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A82OpeCliId',fld:'OPECLIID',pic:''},{av:'A924OpeCliVPropagar',fld:'OPECLIVPROPAGAR',pic:''}]");
      setEventMetadata("VALID_OPECLIID",",oparms:[{av:'A924OpeCliVPropagar',fld:'OPECLIVPROPAGAR',pic:''}]}");
      setEventMetadata("VALID_OPECLIVIG","{handler:'valid_Opeclivig',iparms:[{av:'A924OpeCliVPropagar',fld:'OPECLIVPROPAGAR',pic:''}]");
      setEventMetadata("VALID_OPECLIVIG",",oparms:[{av:'A924OpeCliVPropagar',fld:'OPECLIVPROPAGAR',pic:''}]}");
      setEventMetadata("VALIDV_COMBOCLICOD","{handler:'validv_Comboclicod',iparms:[{av:'A924OpeCliVPropagar',fld:'OPECLIVPROPAGAR',pic:''}]");
      setEventMetadata("VALIDV_COMBOCLICOD",",oparms:[{av:'A924OpeCliVPropagar',fld:'OPECLIVPROPAGAR',pic:''}]}");
      setEventMetadata("VALIDV_COMBOOPECLIID","{handler:'validv_Comboopecliid',iparms:[{av:'A924OpeCliVPropagar',fld:'OPECLIVPROPAGAR',pic:''}]");
      setEventMetadata("VALIDV_COMBOOPECLIID",",oparms:[{av:'A924OpeCliVPropagar',fld:'OPECLIVPROPAGAR',pic:''}]}");
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
      wcpOAV8OpeCliId = "" ;
      wcpOAV9OpeCliVig = GXutil.nullDate() ;
      Z82OpeCliId = "" ;
      Z754OpeCliVig = GXutil.nullDate() ;
      Z1146OpeCliVRetro = GXutil.nullDate() ;
      Combo_opecliid_Selectedvalue_get = "" ;
      Combo_clicod_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A82OpeCliId = "" ;
      Gx_mode = "" ;
      AV8OpeCliId = "" ;
      AV9OpeCliVig = GXutil.nullDate() ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockclicod_Jsonclick = "" ;
      ucCombo_clicod = new com.genexus.webpanels.GXUserControl();
      AV16DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV15CliCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      lblTextblockopecliid_Jsonclick = "" ;
      ucCombo_opecliid = new com.genexus.webpanels.GXUserControl();
      AV21OpeCliId_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A754OpeCliVig = GXutil.nullDate() ;
      ClassString = "" ;
      StyleString = "" ;
      A535OpeCliValor = "" ;
      A1146OpeCliVRetro = GXutil.nullDate() ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV22ComboOpeCliId = "" ;
      AV24Pgmname = "" ;
      Combo_clicod_Objectcall = "" ;
      Combo_clicod_Class = "" ;
      Combo_clicod_Icontype = "" ;
      Combo_clicod_Icon = "" ;
      Combo_clicod_Tooltip = "" ;
      Combo_clicod_Selectedvalue_set = "" ;
      Combo_clicod_Selectedtext_set = "" ;
      Combo_clicod_Selectedtext_get = "" ;
      Combo_clicod_Gamoauthtoken = "" ;
      Combo_clicod_Ddointernalname = "" ;
      Combo_clicod_Titlecontrolalign = "" ;
      Combo_clicod_Dropdownoptionstype = "" ;
      Combo_clicod_Titlecontrolidtoreplace = "" ;
      Combo_clicod_Datalisttype = "" ;
      Combo_clicod_Datalistfixedvalues = "" ;
      Combo_clicod_Remoteservicesparameters = "" ;
      Combo_clicod_Htmltemplate = "" ;
      Combo_clicod_Multiplevaluestype = "" ;
      Combo_clicod_Loadingdata = "" ;
      Combo_clicod_Noresultsfound = "" ;
      Combo_clicod_Emptyitemtext = "" ;
      Combo_clicod_Onlyselectedvalues = "" ;
      Combo_clicod_Selectalltext = "" ;
      Combo_clicod_Multiplevaluesseparator = "" ;
      Combo_clicod_Addnewoptiontext = "" ;
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
      GXv_boolean5 = new boolean[1] ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      AV19Combo_DataJson = "" ;
      AV17ComboSelectedValue = "" ;
      AV18ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z535OpeCliValor = "" ;
      T00555_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      T00555_A535OpeCliValor = new String[] {""} ;
      T00555_A924OpeCliVPropagar = new boolean[] {false} ;
      T00555_n924OpeCliVPropagar = new boolean[] {false} ;
      T00555_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      T00555_n1146OpeCliVRetro = new boolean[] {false} ;
      T00555_A3CliCod = new int[1] ;
      T00555_A82OpeCliId = new String[] {""} ;
      T00554_A3CliCod = new int[1] ;
      T00556_A3CliCod = new int[1] ;
      T00557_A3CliCod = new int[1] ;
      T00557_A82OpeCliId = new String[] {""} ;
      T00557_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      T00553_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      T00553_A535OpeCliValor = new String[] {""} ;
      T00553_A924OpeCliVPropagar = new boolean[] {false} ;
      T00553_n924OpeCliVPropagar = new boolean[] {false} ;
      T00553_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      T00553_n1146OpeCliVRetro = new boolean[] {false} ;
      T00553_A3CliCod = new int[1] ;
      T00553_A82OpeCliId = new String[] {""} ;
      T00558_A3CliCod = new int[1] ;
      T00558_A82OpeCliId = new String[] {""} ;
      T00558_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      T00559_A3CliCod = new int[1] ;
      T00559_A82OpeCliId = new String[] {""} ;
      T00559_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      T00552_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      T00552_A535OpeCliValor = new String[] {""} ;
      T00552_A924OpeCliVPropagar = new boolean[] {false} ;
      T00552_n924OpeCliVPropagar = new boolean[] {false} ;
      T00552_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      T00552_n1146OpeCliVRetro = new boolean[] {false} ;
      T00552_A3CliCod = new int[1] ;
      T00552_A82OpeCliId = new String[] {""} ;
      T005513_A3CliCod = new int[1] ;
      T005513_A82OpeCliId = new String[] {""} ;
      T005513_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T005514_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.variablevalores__default(),
         new Object[] {
             new Object[] {
            T00552_A754OpeCliVig, T00552_A535OpeCliValor, T00552_A924OpeCliVPropagar, T00552_n924OpeCliVPropagar, T00552_A1146OpeCliVRetro, T00552_n1146OpeCliVRetro, T00552_A3CliCod, T00552_A82OpeCliId
            }
            , new Object[] {
            T00553_A754OpeCliVig, T00553_A535OpeCliValor, T00553_A924OpeCliVPropagar, T00553_n924OpeCliVPropagar, T00553_A1146OpeCliVRetro, T00553_n1146OpeCliVRetro, T00553_A3CliCod, T00553_A82OpeCliId
            }
            , new Object[] {
            T00554_A3CliCod
            }
            , new Object[] {
            T00555_A754OpeCliVig, T00555_A535OpeCliValor, T00555_A924OpeCliVPropagar, T00555_n924OpeCliVPropagar, T00555_A1146OpeCliVRetro, T00555_n1146OpeCliVRetro, T00555_A3CliCod, T00555_A82OpeCliId
            }
            , new Object[] {
            T00556_A3CliCod
            }
            , new Object[] {
            T00557_A3CliCod, T00557_A82OpeCliId, T00557_A754OpeCliVig
            }
            , new Object[] {
            T00558_A3CliCod, T00558_A82OpeCliId, T00558_A754OpeCliVig
            }
            , new Object[] {
            T00559_A3CliCod, T00559_A82OpeCliId, T00559_A754OpeCliVig
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005513_A3CliCod, T005513_A82OpeCliId, T005513_A754OpeCliVig
            }
            , new Object[] {
            T005514_A3CliCod
            }
         }
      );
      AV24Pgmname = "VariableValores" ;
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
   private short nIsDirty_81 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int AV7CliCod ;
   private int trnEnded ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
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
   private int AV20ComboCliCod ;
   private int edtavComboclicod_Enabled ;
   private int edtavComboclicod_Visible ;
   private int edtavComboopecliid_Visible ;
   private int edtavComboopecliid_Enabled ;
   private int AV23Cond_CliCod ;
   private int Combo_clicod_Datalistupdateminimumcharacters ;
   private int Combo_opecliid_Datalistupdateminimumcharacters ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8OpeCliId ;
   private String Z82OpeCliId ;
   private String Combo_opecliid_Selectedvalue_get ;
   private String Combo_clicod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A82OpeCliId ;
   private String Gx_mode ;
   private String AV8OpeCliId ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCliCod_Internalname ;
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
   private String divTablesplittedclicod_Internalname ;
   private String lblTextblockclicod_Internalname ;
   private String lblTextblockclicod_Jsonclick ;
   private String Combo_clicod_Caption ;
   private String Combo_clicod_Cls ;
   private String Combo_clicod_Datalistproc ;
   private String Combo_clicod_Datalistprocparametersprefix ;
   private String Combo_clicod_Internalname ;
   private String TempTags ;
   private String edtCliCod_Jsonclick ;
   private String divTablesplittedopecliid_Internalname ;
   private String lblTextblockopecliid_Internalname ;
   private String lblTextblockopecliid_Jsonclick ;
   private String Combo_opecliid_Caption ;
   private String Combo_opecliid_Cls ;
   private String Combo_opecliid_Datalistproc ;
   private String Combo_opecliid_Internalname ;
   private String edtOpeCliId_Internalname ;
   private String edtOpeCliId_Jsonclick ;
   private String edtOpeCliVig_Internalname ;
   private String edtOpeCliVig_Jsonclick ;
   private String edtOpeCliValor_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtOpeCliVRetro_Internalname ;
   private String edtOpeCliVRetro_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_clicod_Internalname ;
   private String edtavComboclicod_Internalname ;
   private String edtavComboclicod_Jsonclick ;
   private String divSectionattribute_opecliid_Internalname ;
   private String edtavComboopecliid_Internalname ;
   private String AV22ComboOpeCliId ;
   private String edtavComboopecliid_Jsonclick ;
   private String AV24Pgmname ;
   private String Combo_clicod_Objectcall ;
   private String Combo_clicod_Class ;
   private String Combo_clicod_Icontype ;
   private String Combo_clicod_Icon ;
   private String Combo_clicod_Tooltip ;
   private String Combo_clicod_Selectedvalue_set ;
   private String Combo_clicod_Selectedtext_set ;
   private String Combo_clicod_Selectedtext_get ;
   private String Combo_clicod_Gamoauthtoken ;
   private String Combo_clicod_Ddointernalname ;
   private String Combo_clicod_Titlecontrolalign ;
   private String Combo_clicod_Dropdownoptionstype ;
   private String Combo_clicod_Titlecontrolidtoreplace ;
   private String Combo_clicod_Datalisttype ;
   private String Combo_clicod_Datalistfixedvalues ;
   private String Combo_clicod_Remoteservicesparameters ;
   private String Combo_clicod_Htmltemplate ;
   private String Combo_clicod_Multiplevaluestype ;
   private String Combo_clicod_Loadingdata ;
   private String Combo_clicod_Noresultsfound ;
   private String Combo_clicod_Emptyitemtext ;
   private String Combo_clicod_Onlyselectedvalues ;
   private String Combo_clicod_Selectalltext ;
   private String Combo_clicod_Multiplevaluesseparator ;
   private String Combo_clicod_Addnewoptiontext ;
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
   private String GXt_char6 ;
   private String GXv_char9[] ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date wcpOAV9OpeCliVig ;
   private java.util.Date Z754OpeCliVig ;
   private java.util.Date Z1146OpeCliVRetro ;
   private java.util.Date AV9OpeCliVig ;
   private java.util.Date A754OpeCliVig ;
   private java.util.Date A1146OpeCliVRetro ;
   private boolean Z924OpeCliVPropagar ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A924OpeCliVPropagar ;
   private boolean n924OpeCliVPropagar ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_clicod_Emptyitem ;
   private boolean Combo_opecliid_Emptyitem ;
   private boolean n1146OpeCliVRetro ;
   private boolean Combo_clicod_Enabled ;
   private boolean Combo_clicod_Visible ;
   private boolean Combo_clicod_Allowmultipleselection ;
   private boolean Combo_clicod_Isgriditem ;
   private boolean Combo_clicod_Hasdescription ;
   private boolean Combo_clicod_Includeonlyselectedoption ;
   private boolean Combo_clicod_Includeselectalloption ;
   private boolean Combo_clicod_Includeaddnewoption ;
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
   private boolean GXv_boolean5[] ;
   private String A535OpeCliValor ;
   private String AV19Combo_DataJson ;
   private String Z535OpeCliValor ;
   private String AV17ComboSelectedValue ;
   private String AV18ComboSelectedText ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_clicod ;
   private com.genexus.webpanels.GXUserControl ucCombo_opecliid ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkOpeCliVPropagar ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] T00555_A754OpeCliVig ;
   private String[] T00555_A535OpeCliValor ;
   private boolean[] T00555_A924OpeCliVPropagar ;
   private boolean[] T00555_n924OpeCliVPropagar ;
   private java.util.Date[] T00555_A1146OpeCliVRetro ;
   private boolean[] T00555_n1146OpeCliVRetro ;
   private int[] T00555_A3CliCod ;
   private String[] T00555_A82OpeCliId ;
   private int[] T00554_A3CliCod ;
   private int[] T00556_A3CliCod ;
   private int[] T00557_A3CliCod ;
   private String[] T00557_A82OpeCliId ;
   private java.util.Date[] T00557_A754OpeCliVig ;
   private java.util.Date[] T00553_A754OpeCliVig ;
   private String[] T00553_A535OpeCliValor ;
   private boolean[] T00553_A924OpeCliVPropagar ;
   private boolean[] T00553_n924OpeCliVPropagar ;
   private java.util.Date[] T00553_A1146OpeCliVRetro ;
   private boolean[] T00553_n1146OpeCliVRetro ;
   private int[] T00553_A3CliCod ;
   private String[] T00553_A82OpeCliId ;
   private int[] T00558_A3CliCod ;
   private String[] T00558_A82OpeCliId ;
   private java.util.Date[] T00558_A754OpeCliVig ;
   private int[] T00559_A3CliCod ;
   private String[] T00559_A82OpeCliId ;
   private java.util.Date[] T00559_A754OpeCliVig ;
   private java.util.Date[] T00552_A754OpeCliVig ;
   private String[] T00552_A535OpeCliValor ;
   private boolean[] T00552_A924OpeCliVPropagar ;
   private boolean[] T00552_n924OpeCliVPropagar ;
   private java.util.Date[] T00552_A1146OpeCliVRetro ;
   private boolean[] T00552_n1146OpeCliVRetro ;
   private int[] T00552_A3CliCod ;
   private String[] T00552_A82OpeCliId ;
   private int[] T005513_A3CliCod ;
   private String[] T005513_A82OpeCliId ;
   private java.util.Date[] T005513_A754OpeCliVig ;
   private int[] T005514_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV15CliCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV21OpeCliId_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV16DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class variablevalores__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00552", "SELECT OpeCliVig, OpeCliValor, OpeCliVPropagar, OpeCliVRetro, CliCod, OpeCliId FROM variable_valores WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ?  FOR UPDATE OF variable_valores NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00553", "SELECT OpeCliVig, OpeCliValor, OpeCliVPropagar, OpeCliVRetro, CliCod, OpeCliId FROM variable_valores WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00554", "SELECT CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00555", "SELECT TM1.OpeCliVig, TM1.OpeCliValor, TM1.OpeCliVPropagar, TM1.OpeCliVRetro, TM1.CliCod, TM1.OpeCliId FROM variable_valores TM1 WHERE TM1.CliCod = ? and TM1.OpeCliId = ( ?) and TM1.OpeCliVig = ? ORDER BY TM1.CliCod, TM1.OpeCliId, TM1.OpeCliVig ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00556", "SELECT CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00557", "SELECT CliCod, OpeCliId, OpeCliVig FROM variable_valores WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00558", "SELECT CliCod, OpeCliId, OpeCliVig FROM variable_valores WHERE ( CliCod > ? or CliCod = ? and OpeCliId > ( ?) or OpeCliId = ( ?) and CliCod = ? and OpeCliVig > ?) ORDER BY CliCod, OpeCliId, OpeCliVig  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00559", "SELECT CliCod, OpeCliId, OpeCliVig FROM variable_valores WHERE ( CliCod < ? or CliCod = ? and OpeCliId < ( ?) or OpeCliId = ( ?) and CliCod = ? and OpeCliVig < ?) ORDER BY CliCod DESC, OpeCliId DESC, OpeCliVig DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005510", "SAVEPOINT gxupdate;INSERT INTO variable_valores(OpeCliVig, OpeCliValor, OpeCliVPropagar, OpeCliVRetro, CliCod, OpeCliId, OpeCliRelSec, OpeCliRelSecCli, OpeCliVRelRef, OpeCliVOld) VALUES(?, ?, ?, ?, ?, ?, 0, 0, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005511", "SAVEPOINT gxupdate;UPDATE variable_valores SET OpeCliValor=?, OpeCliVPropagar=?, OpeCliVRetro=?  WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005512", "SAVEPOINT gxupdate;DELETE FROM variable_valores  WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005513", "SELECT CliCod, OpeCliId, OpeCliVig FROM variable_valores ORDER BY CliCod, OpeCliId, OpeCliVig ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005514", "SELECT CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(5);
               ((String[]) buf[7])[0] = rslt.getString(6, 40);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(5);
               ((String[]) buf[7])[0] = rslt.getString(6, 40);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(5);
               ((String[]) buf[7])[0] = rslt.getString(6, 40);
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
               stmt.setString(6, (String)parms[7], 40);
               return;
            case 9 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(2, ((Boolean) parms[2]).booleanValue());
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.DATE );
               }
               else
               {
                  stmt.setDate(3, (java.util.Date)parms[4]);
               }
               stmt.setInt(4, ((Number) parms[5]).intValue());
               stmt.setString(5, (String)parms[6], 40);
               stmt.setDate(6, (java.util.Date)parms[7]);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
      }
   }

}

