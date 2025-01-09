package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class liqimportarauxtrn_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel5"+"_"+"EMPCOD") == 0 )
      {
         AV7EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7EmpCod), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7EmpCod), "ZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx5asaempcod2B13( AV7EmpCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel6"+"_"+"EMPCOD") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx6asaempcod2B13( A3CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_33") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_33( A3CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_30") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         n46PaiCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_30( A46PaiCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_31") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         n46PaiCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A47ProvCod = (short)(GXutil.lval( httpContext.GetPar( "ProvCod"))) ;
         n47ProvCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_31( A46PaiCod, A47ProvCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_32") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         n46PaiCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A47ProvCod = (short)(GXutil.lval( httpContext.GetPar( "ProvCod"))) ;
         n47ProvCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
         A48LocCod = (short)(GXutil.lval( httpContext.GetPar( "LocCod"))) ;
         n48LocCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_32( A46PaiCod, A47ProvCod, A48LocCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_34") == 0 )
      {
         A43ActCodigo = httpContext.GetPar( "ActCodigo") ;
         n43ActCodigo = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A43ActCodigo", A43ActCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_34( A43ActCodigo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_35") == 0 )
      {
         A45TipEmpleCod = httpContext.GetPar( "TipEmpleCod") ;
         n45TipEmpleCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A45TipEmpleCod", A45TipEmpleCod);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_35( A45TipEmpleCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_36") == 0 )
      {
         A44EmpZonCod = httpContext.GetPar( "EmpZonCod") ;
         n44EmpZonCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A44EmpZonCod", A44EmpZonCod);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_36( A44EmpZonCod) ;
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
            AV30CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30CliCod), "ZZZZZ9")));
            AV7EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7EmpCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7EmpCod), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Liq Importar Aux Trn", ""), (short)(0)) ;
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

   public liqimportarauxtrn_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public liqimportarauxtrn_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liqimportarauxtrn_impl.class ));
   }

   public liqimportarauxtrn_impl( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkEmpReducc = UIFactory.getCheckbox(this);
      cmbTipEmpleDefIns = new HTMLChoice();
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
      A532EmpReducc = GXutil.strtobool( GXutil.booltostr( A532EmpReducc)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A532EmpReducc", A532EmpReducc);
      if ( cmbTipEmpleDefIns.getItemCount() > 0 )
      {
         A530TipEmpleDefIns = cmbTipEmpleDefIns.getValidValue(A530TipEmpleDefIns) ;
         httpContext.ajax_rsp_assign_attri("", false, "A530TipEmpleDefIns", A530TipEmpleDefIns);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbTipEmpleDefIns.setValue( GXutil.rtrim( A530TipEmpleDefIns) );
         httpContext.ajax_rsp_assign_prop("", false, cmbTipEmpleDefIns.getInternalname(), "Values", cmbTipEmpleDefIns.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Liq Importar Aux Trn", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_LiqImportarAuxTrn.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliCod_Internalname, httpContext.getMessage( "Cli Cod", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpCod_Internalname, httpContext.getMessage( "Empresa", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,30);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpNom_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpNom_Internalname, httpContext.getMessage( "Nombre", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpNom_Internalname, A2EmpNom, GXutil.rtrim( localUtil.format( A2EmpNom, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,35);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpNom_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpNom_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionLarga", "left", true, "", "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpCUIT_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpCUIT_Internalname, httpContext.getMessage( "CUIT", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCUIT_Internalname, GXutil.ltrim( localUtil.ntoc( A177EmpCUIT, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpCUIT_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A177EmpCUIT), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A177EmpCUIT), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,40);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCUIT_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCUIT_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCatIvaCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCatIvaCod_Internalname, httpContext.getMessage( "Categoria de IVA", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCatIvaCod_Internalname, GXutil.ltrim( localUtil.ntoc( A125CatIvaCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCatIvaCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A125CatIvaCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A125CatIvaCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,45);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCatIvaCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCatIvaCod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCatIvaDesc_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCatIvaDesc_Internalname, httpContext.getMessage( "Descrpcion IVA", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCatIvaDesc_Internalname, A126CatIvaDesc, GXutil.rtrim( localUtil.format( A126CatIvaDesc, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,50);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCatIvaDesc_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCatIvaDesc_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpDir_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpDir_Internalname, httpContext.getMessage( "Direccion", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpDir_Internalname, A178EmpDir, GXutil.rtrim( localUtil.format( A178EmpDir, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,55);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpDir_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpDir_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionLarga", "left", true, "", "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpTel_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpTel_Internalname, httpContext.getMessage( "Telefono", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpTel_Internalname, A180EmpTel, GXutil.rtrim( localUtil.format( A180EmpTel, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,60);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpTel_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpTel_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpCP_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpCP_Internalname, httpContext.getMessage( "Codigo Postal", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCP_Internalname, GXutil.rtrim( A176EmpCP), GXutil.rtrim( localUtil.format( A176EmpCP, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,65);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCP_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCP_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodigoPostal", "left", true, "", "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockpaicod_Internalname, httpContext.getMessage( "Pais", ""), "", "", lblTextblockpaicod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_paicod.setProperty("Caption", Combo_paicod_Caption);
      ucCombo_paicod.setProperty("Cls", Combo_paicod_Cls);
      ucCombo_paicod.setProperty("DataListProc", Combo_paicod_Datalistproc);
      ucCombo_paicod.setProperty("DataListProcParametersPrefix", Combo_paicod_Datalistprocparametersprefix);
      ucCombo_paicod.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_paicod.setProperty("DropDownOptionsData", AV16PaiCod_Data);
      ucCombo_paicod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_paicod_Internalname, "COMBO_PAICODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiCod_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,76);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiCod_Visible, edtPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_LiqImportarAuxTrn.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedprovcod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockprovcod_Internalname, httpContext.getMessage( "Provincia", ""), "", "", lblTextblockprovcod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_provcod.setProperty("Caption", Combo_provcod_Caption);
      ucCombo_provcod.setProperty("Cls", Combo_provcod_Cls);
      ucCombo_provcod.setProperty("DataListProc", Combo_provcod_Datalistproc);
      ucCombo_provcod.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_provcod.setProperty("DropDownOptionsData", AV22ProvCod_Data);
      ucCombo_provcod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_provcod_Internalname, "COMBO_PROVCODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtProvCod_Internalname, httpContext.getMessage( "Código de Provincia", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtProvCod_Internalname, GXutil.ltrim( localUtil.ntoc( A47ProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A47ProvCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,87);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProvCod_Jsonclick, 0, "Attribute", "", "", "", "", edtProvCod_Visible, edtProvCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_LiqImportarAuxTrn.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedloccod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockloccod_Internalname, httpContext.getMessage( "Localidad", ""), "", "", lblTextblockloccod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_loccod.setProperty("Caption", Combo_loccod_Caption);
      ucCombo_loccod.setProperty("Cls", Combo_loccod_Cls);
      ucCombo_loccod.setProperty("DataListProc", Combo_loccod_Datalistproc);
      ucCombo_loccod.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_loccod.setProperty("DropDownOptionsData", AV25LocCod_Data);
      ucCombo_loccod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_loccod_Internalname, "COMBO_LOCCODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLocCod_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLocCod_Internalname, GXutil.ltrim( localUtil.ntoc( A48LocCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A48LocCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,98);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLocCod_Jsonclick, 0, "Attribute", "", "", "", "", edtLocCod_Visible, edtLocCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_LiqImportarAuxTrn.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedactcodigo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockactcodigo_Internalname, httpContext.getMessage( "Actividad", ""), "", "", lblTextblockactcodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_actcodigo.setProperty("Caption", Combo_actcodigo_Caption);
      ucCombo_actcodigo.setProperty("Cls", Combo_actcodigo_Cls);
      ucCombo_actcodigo.setProperty("DataListProc", Combo_actcodigo_Datalistproc);
      ucCombo_actcodigo.setProperty("DataListProcParametersPrefix", Combo_actcodigo_Datalistprocparametersprefix);
      ucCombo_actcodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_actcodigo.setProperty("DropDownOptionsData", AV28ActCodigo_Data);
      ucCombo_actcodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_actcodigo_Internalname, "COMBO_ACTCODIGOContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtActCodigo_Internalname, httpContext.getMessage( "Actividad", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtActCodigo_Internalname, GXutil.rtrim( A43ActCodigo), GXutil.rtrim( localUtil.format( A43ActCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,109);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtActCodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtActCodigo_Visible, edtActCodigo_Enabled, 1, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LiqImportarAuxTrn.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedtipemplecod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktipemplecod_Internalname, httpContext.getMessage( "Tipo Empleador", ""), "", "", lblTextblocktipemplecod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_tipemplecod.setProperty("Caption", Combo_tipemplecod_Caption);
      ucCombo_tipemplecod.setProperty("Cls", Combo_tipemplecod_Cls);
      ucCombo_tipemplecod.setProperty("DataListProc", Combo_tipemplecod_Datalistproc);
      ucCombo_tipemplecod.setProperty("DataListProcParametersPrefix", Combo_tipemplecod_Datalistprocparametersprefix);
      ucCombo_tipemplecod.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_tipemplecod.setProperty("DropDownOptionsData", AV41TipEmpleCod_Data);
      ucCombo_tipemplecod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_tipemplecod_Internalname, "COMBO_TIPEMPLECODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtTipEmpleCod_Internalname, httpContext.getMessage( "Tipo de Empleador según decreto 814/01 art. 2", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 120,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtTipEmpleCod_Internalname, GXutil.rtrim( A45TipEmpleCod), GXutil.rtrim( localUtil.format( A45TipEmpleCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,120);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipEmpleCod_Jsonclick, 0, "Attribute", "", "", "", "", edtTipEmpleCod_Visible, edtTipEmpleCod_Enabled, 1, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LiqImportarAuxTrn.htm");
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
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedempzoncod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockempzoncod_Internalname, httpContext.getMessage( "Zona", ""), "", "", lblTextblockempzoncod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_empzoncod.setProperty("Caption", Combo_empzoncod_Caption);
      ucCombo_empzoncod.setProperty("Cls", Combo_empzoncod_Cls);
      ucCombo_empzoncod.setProperty("DataListProc", Combo_empzoncod_Datalistproc);
      ucCombo_empzoncod.setProperty("DataListProcParametersPrefix", Combo_empzoncod_Datalistprocparametersprefix);
      ucCombo_empzoncod.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_empzoncod.setProperty("DropDownOptionsData", AV37EmpZonCod_Data);
      ucCombo_empzoncod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_empzoncod_Internalname, "COMBO_EMPZONCODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpZonCod_Internalname, httpContext.getMessage( "Zona", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 131,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpZonCod_Internalname, GXutil.rtrim( A44EmpZonCod), GXutil.rtrim( localUtil.format( A44EmpZonCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,131);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpZonCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpZonCod_Visible, edtEmpZonCod_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodigoCaracter", "left", true, "", "HLP_LiqImportarAuxTrn.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpZonDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpZonDescrip_Internalname, httpContext.getMessage( "Zon Descrip", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtEmpZonDescrip_Internalname, A518EmpZonDescrip, "", "", (short)(0), 1, edtEmpZonDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEmpReducc.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkEmpReducc.getInternalname(), httpContext.getMessage( "Reducción", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 141,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEmpReducc.getInternalname(), GXutil.booltostr( A532EmpReducc), "", httpContext.getMessage( "Reducción", ""), 1, chkEmpReducc.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(141, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,141);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbTipEmpleDefIns.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbTipEmpleDefIns.getInternalname(), httpContext.getMessage( "Inciso relacionado al tipo de empleador", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbTipEmpleDefIns, cmbTipEmpleDefIns.getInternalname(), GXutil.rtrim( A530TipEmpleDefIns), 1, cmbTipEmpleDefIns.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbTipEmpleDefIns.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_LiqImportarAuxTrn.htm");
      cmbTipEmpleDefIns.setValue( GXutil.rtrim( A530TipEmpleDefIns) );
      httpContext.ajax_rsp_assign_prop("", false, cmbTipEmpleDefIns.getInternalname(), "Values", cmbTipEmpleDefIns.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 151,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 153,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 155,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiqImportarAuxTrn.htm");
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
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_paicod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombopaicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV21ComboPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCombopaicod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV21ComboPaiCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV21ComboPaiCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombopaicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombopaicod_Visible, edtavCombopaicod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_provcod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboprovcod_Internalname, GXutil.ltrim( localUtil.ntoc( AV23ComboProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavComboprovcod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV23ComboProvCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV23ComboProvCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboprovcod_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboprovcod_Visible, edtavComboprovcod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_loccod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboloccod_Internalname, GXutil.ltrim( localUtil.ntoc( AV26ComboLocCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavComboloccod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV26ComboLocCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV26ComboLocCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboloccod_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboloccod_Visible, edtavComboloccod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_actcodigo_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboactcodigo_Internalname, GXutil.rtrim( AV29ComboActCodigo), GXutil.rtrim( localUtil.format( AV29ComboActCodigo, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboactcodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboactcodigo_Visible, edtavComboactcodigo_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_tipemplecod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavCombotipemplecod_Internalname, GXutil.rtrim( AV42ComboTipEmpleCod), GXutil.rtrim( localUtil.format( AV42ComboTipEmpleCod, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombotipemplecod_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombotipemplecod_Visible, edtavCombotipemplecod_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LiqImportarAuxTrn.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_empzoncod_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboempzoncod_Internalname, GXutil.rtrim( AV38ComboEmpZonCod), GXutil.rtrim( localUtil.format( AV38ComboEmpZonCod, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboempzoncod_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboempzoncod_Visible, edtavComboempzoncod_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LiqImportarAuxTrn.htm");
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
      e112B2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV17DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPAICOD_DATA"), AV16PaiCod_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPROVCOD_DATA"), AV22ProvCod_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLOCCOD_DATA"), AV25LocCod_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vACTCODIGO_DATA"), AV28ActCodigo_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vTIPEMPLECOD_DATA"), AV41TipEmpleCod_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vEMPZONCOD_DATA"), AV37EmpZonCod_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2EmpNom = httpContext.cgiGet( "Z2EmpNom") ;
            Z177EmpCUIT = localUtil.ctol( httpContext.cgiGet( "Z177EmpCUIT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z125CatIvaCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z125CatIvaCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n125CatIvaCod = ((0==A125CatIvaCod) ? true : false) ;
            Z126CatIvaDesc = httpContext.cgiGet( "Z126CatIvaDesc") ;
            n126CatIvaDesc = ((GXutil.strcmp("", A126CatIvaDesc)==0) ? true : false) ;
            Z178EmpDir = httpContext.cgiGet( "Z178EmpDir") ;
            Z180EmpTel = httpContext.cgiGet( "Z180EmpTel") ;
            n180EmpTel = ((GXutil.strcmp("", A180EmpTel)==0) ? true : false) ;
            Z176EmpCP = httpContext.cgiGet( "Z176EmpCP") ;
            n176EmpCP = ((GXutil.strcmp("", A176EmpCP)==0) ? true : false) ;
            Z532EmpReducc = GXutil.strtobool( httpContext.cgiGet( "Z532EmpReducc")) ;
            Z46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n46PaiCod = ((0==A46PaiCod) ? true : false) ;
            Z47ProvCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z47ProvCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n47ProvCod = ((0==A47ProvCod) ? true : false) ;
            Z48LocCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z48LocCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n48LocCod = ((0==A48LocCod) ? true : false) ;
            Z43ActCodigo = httpContext.cgiGet( "Z43ActCodigo") ;
            n43ActCodigo = ((GXutil.strcmp("", A43ActCodigo)==0) ? true : false) ;
            Z45TipEmpleCod = httpContext.cgiGet( "Z45TipEmpleCod") ;
            n45TipEmpleCod = ((GXutil.strcmp("", A45TipEmpleCod)==0) ? true : false) ;
            Z44EmpZonCod = httpContext.cgiGet( "Z44EmpZonCod") ;
            n44EmpZonCod = ((GXutil.strcmp("", A44EmpZonCod)==0) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "N46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n46PaiCod = ((0==A46PaiCod) ? true : false) ;
            N47ProvCod = (short)(localUtil.ctol( httpContext.cgiGet( "N47ProvCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n47ProvCod = ((0==A47ProvCod) ? true : false) ;
            N48LocCod = (short)(localUtil.ctol( httpContext.cgiGet( "N48LocCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n48LocCod = ((0==A48LocCod) ? true : false) ;
            N43ActCodigo = httpContext.cgiGet( "N43ActCodigo") ;
            n43ActCodigo = ((GXutil.strcmp("", A43ActCodigo)==0) ? true : false) ;
            N45TipEmpleCod = httpContext.cgiGet( "N45TipEmpleCod") ;
            n45TipEmpleCod = ((GXutil.strcmp("", A45TipEmpleCod)==0) ? true : false) ;
            N44EmpZonCod = httpContext.cgiGet( "N44EmpZonCod") ;
            n44EmpZonCod = ((GXutil.strcmp("", A44EmpZonCod)==0) ? true : false) ;
            AV24Cond_PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vCOND_PAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV27Cond_ProvCod = (short)(localUtil.ctol( httpContext.cgiGet( "vCOND_PROVCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV30CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV11Insert_PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_PAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV12Insert_ProvCod = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_PROVCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV13Insert_LocCod = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_LOCCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV14Insert_ActCodigo = httpContext.cgiGet( "vINSERT_ACTCODIGO") ;
            AV40Insert_TipEmpleCod = httpContext.cgiGet( "vINSERT_TIPEMPLECOD") ;
            AV36Insert_EmpZonCod = httpContext.cgiGet( "vINSERT_EMPZONCOD") ;
            A312PaiNom = httpContext.cgiGet( "PAINOM") ;
            A322ProvNom = httpContext.cgiGet( "PROVNOM") ;
            A286LocNom = httpContext.cgiGet( "LOCNOM") ;
            A683ActDescripSinAc = httpContext.cgiGet( "ACTDESCRIPSINAC") ;
            A108ActDescrip = httpContext.cgiGet( "ACTDESCRIP") ;
            AV45Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            Combo_provcod_Objectcall = httpContext.cgiGet( "COMBO_PROVCOD_Objectcall") ;
            Combo_provcod_Class = httpContext.cgiGet( "COMBO_PROVCOD_Class") ;
            Combo_provcod_Icontype = httpContext.cgiGet( "COMBO_PROVCOD_Icontype") ;
            Combo_provcod_Icon = httpContext.cgiGet( "COMBO_PROVCOD_Icon") ;
            Combo_provcod_Caption = httpContext.cgiGet( "COMBO_PROVCOD_Caption") ;
            Combo_provcod_Tooltip = httpContext.cgiGet( "COMBO_PROVCOD_Tooltip") ;
            Combo_provcod_Cls = httpContext.cgiGet( "COMBO_PROVCOD_Cls") ;
            Combo_provcod_Selectedvalue_set = httpContext.cgiGet( "COMBO_PROVCOD_Selectedvalue_set") ;
            Combo_provcod_Selectedvalue_get = httpContext.cgiGet( "COMBO_PROVCOD_Selectedvalue_get") ;
            Combo_provcod_Selectedtext_set = httpContext.cgiGet( "COMBO_PROVCOD_Selectedtext_set") ;
            Combo_provcod_Selectedtext_get = httpContext.cgiGet( "COMBO_PROVCOD_Selectedtext_get") ;
            Combo_provcod_Gamoauthtoken = httpContext.cgiGet( "COMBO_PROVCOD_Gamoauthtoken") ;
            Combo_provcod_Ddointernalname = httpContext.cgiGet( "COMBO_PROVCOD_Ddointernalname") ;
            Combo_provcod_Titlecontrolalign = httpContext.cgiGet( "COMBO_PROVCOD_Titlecontrolalign") ;
            Combo_provcod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_PROVCOD_Dropdownoptionstype") ;
            Combo_provcod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Enabled")) ;
            Combo_provcod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Visible")) ;
            Combo_provcod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_PROVCOD_Titlecontrolidtoreplace") ;
            Combo_provcod_Datalisttype = httpContext.cgiGet( "COMBO_PROVCOD_Datalisttype") ;
            Combo_provcod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Allowmultipleselection")) ;
            Combo_provcod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_PROVCOD_Datalistfixedvalues") ;
            Combo_provcod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Isgriditem")) ;
            Combo_provcod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Hasdescription")) ;
            Combo_provcod_Datalistproc = httpContext.cgiGet( "COMBO_PROVCOD_Datalistproc") ;
            Combo_provcod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_PROVCOD_Datalistprocparametersprefix") ;
            Combo_provcod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_PROVCOD_Remoteservicesparameters") ;
            Combo_provcod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_PROVCOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_provcod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Includeonlyselectedoption")) ;
            Combo_provcod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Includeselectalloption")) ;
            Combo_provcod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Emptyitem")) ;
            Combo_provcod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROVCOD_Includeaddnewoption")) ;
            Combo_provcod_Htmltemplate = httpContext.cgiGet( "COMBO_PROVCOD_Htmltemplate") ;
            Combo_provcod_Multiplevaluestype = httpContext.cgiGet( "COMBO_PROVCOD_Multiplevaluestype") ;
            Combo_provcod_Loadingdata = httpContext.cgiGet( "COMBO_PROVCOD_Loadingdata") ;
            Combo_provcod_Noresultsfound = httpContext.cgiGet( "COMBO_PROVCOD_Noresultsfound") ;
            Combo_provcod_Emptyitemtext = httpContext.cgiGet( "COMBO_PROVCOD_Emptyitemtext") ;
            Combo_provcod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_PROVCOD_Onlyselectedvalues") ;
            Combo_provcod_Selectalltext = httpContext.cgiGet( "COMBO_PROVCOD_Selectalltext") ;
            Combo_provcod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_PROVCOD_Multiplevaluesseparator") ;
            Combo_provcod_Addnewoptiontext = httpContext.cgiGet( "COMBO_PROVCOD_Addnewoptiontext") ;
            Combo_provcod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_PROVCOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_loccod_Objectcall = httpContext.cgiGet( "COMBO_LOCCOD_Objectcall") ;
            Combo_loccod_Class = httpContext.cgiGet( "COMBO_LOCCOD_Class") ;
            Combo_loccod_Icontype = httpContext.cgiGet( "COMBO_LOCCOD_Icontype") ;
            Combo_loccod_Icon = httpContext.cgiGet( "COMBO_LOCCOD_Icon") ;
            Combo_loccod_Caption = httpContext.cgiGet( "COMBO_LOCCOD_Caption") ;
            Combo_loccod_Tooltip = httpContext.cgiGet( "COMBO_LOCCOD_Tooltip") ;
            Combo_loccod_Cls = httpContext.cgiGet( "COMBO_LOCCOD_Cls") ;
            Combo_loccod_Selectedvalue_set = httpContext.cgiGet( "COMBO_LOCCOD_Selectedvalue_set") ;
            Combo_loccod_Selectedvalue_get = httpContext.cgiGet( "COMBO_LOCCOD_Selectedvalue_get") ;
            Combo_loccod_Selectedtext_set = httpContext.cgiGet( "COMBO_LOCCOD_Selectedtext_set") ;
            Combo_loccod_Selectedtext_get = httpContext.cgiGet( "COMBO_LOCCOD_Selectedtext_get") ;
            Combo_loccod_Gamoauthtoken = httpContext.cgiGet( "COMBO_LOCCOD_Gamoauthtoken") ;
            Combo_loccod_Ddointernalname = httpContext.cgiGet( "COMBO_LOCCOD_Ddointernalname") ;
            Combo_loccod_Titlecontrolalign = httpContext.cgiGet( "COMBO_LOCCOD_Titlecontrolalign") ;
            Combo_loccod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_LOCCOD_Dropdownoptionstype") ;
            Combo_loccod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_LOCCOD_Enabled")) ;
            Combo_loccod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_LOCCOD_Visible")) ;
            Combo_loccod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_LOCCOD_Titlecontrolidtoreplace") ;
            Combo_loccod_Datalisttype = httpContext.cgiGet( "COMBO_LOCCOD_Datalisttype") ;
            Combo_loccod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LOCCOD_Allowmultipleselection")) ;
            Combo_loccod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_LOCCOD_Datalistfixedvalues") ;
            Combo_loccod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LOCCOD_Isgriditem")) ;
            Combo_loccod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_LOCCOD_Hasdescription")) ;
            Combo_loccod_Datalistproc = httpContext.cgiGet( "COMBO_LOCCOD_Datalistproc") ;
            Combo_loccod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_LOCCOD_Datalistprocparametersprefix") ;
            Combo_loccod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_LOCCOD_Remoteservicesparameters") ;
            Combo_loccod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_LOCCOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_loccod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LOCCOD_Includeonlyselectedoption")) ;
            Combo_loccod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LOCCOD_Includeselectalloption")) ;
            Combo_loccod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LOCCOD_Emptyitem")) ;
            Combo_loccod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LOCCOD_Includeaddnewoption")) ;
            Combo_loccod_Htmltemplate = httpContext.cgiGet( "COMBO_LOCCOD_Htmltemplate") ;
            Combo_loccod_Multiplevaluestype = httpContext.cgiGet( "COMBO_LOCCOD_Multiplevaluestype") ;
            Combo_loccod_Loadingdata = httpContext.cgiGet( "COMBO_LOCCOD_Loadingdata") ;
            Combo_loccod_Noresultsfound = httpContext.cgiGet( "COMBO_LOCCOD_Noresultsfound") ;
            Combo_loccod_Emptyitemtext = httpContext.cgiGet( "COMBO_LOCCOD_Emptyitemtext") ;
            Combo_loccod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_LOCCOD_Onlyselectedvalues") ;
            Combo_loccod_Selectalltext = httpContext.cgiGet( "COMBO_LOCCOD_Selectalltext") ;
            Combo_loccod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_LOCCOD_Multiplevaluesseparator") ;
            Combo_loccod_Addnewoptiontext = httpContext.cgiGet( "COMBO_LOCCOD_Addnewoptiontext") ;
            Combo_loccod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_LOCCOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_actcodigo_Objectcall = httpContext.cgiGet( "COMBO_ACTCODIGO_Objectcall") ;
            Combo_actcodigo_Class = httpContext.cgiGet( "COMBO_ACTCODIGO_Class") ;
            Combo_actcodigo_Icontype = httpContext.cgiGet( "COMBO_ACTCODIGO_Icontype") ;
            Combo_actcodigo_Icon = httpContext.cgiGet( "COMBO_ACTCODIGO_Icon") ;
            Combo_actcodigo_Caption = httpContext.cgiGet( "COMBO_ACTCODIGO_Caption") ;
            Combo_actcodigo_Tooltip = httpContext.cgiGet( "COMBO_ACTCODIGO_Tooltip") ;
            Combo_actcodigo_Cls = httpContext.cgiGet( "COMBO_ACTCODIGO_Cls") ;
            Combo_actcodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_ACTCODIGO_Selectedvalue_set") ;
            Combo_actcodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_ACTCODIGO_Selectedvalue_get") ;
            Combo_actcodigo_Selectedtext_set = httpContext.cgiGet( "COMBO_ACTCODIGO_Selectedtext_set") ;
            Combo_actcodigo_Selectedtext_get = httpContext.cgiGet( "COMBO_ACTCODIGO_Selectedtext_get") ;
            Combo_actcodigo_Gamoauthtoken = httpContext.cgiGet( "COMBO_ACTCODIGO_Gamoauthtoken") ;
            Combo_actcodigo_Ddointernalname = httpContext.cgiGet( "COMBO_ACTCODIGO_Ddointernalname") ;
            Combo_actcodigo_Titlecontrolalign = httpContext.cgiGet( "COMBO_ACTCODIGO_Titlecontrolalign") ;
            Combo_actcodigo_Dropdownoptionstype = httpContext.cgiGet( "COMBO_ACTCODIGO_Dropdownoptionstype") ;
            Combo_actcodigo_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_ACTCODIGO_Enabled")) ;
            Combo_actcodigo_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_ACTCODIGO_Visible")) ;
            Combo_actcodigo_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_ACTCODIGO_Titlecontrolidtoreplace") ;
            Combo_actcodigo_Datalisttype = httpContext.cgiGet( "COMBO_ACTCODIGO_Datalisttype") ;
            Combo_actcodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_ACTCODIGO_Allowmultipleselection")) ;
            Combo_actcodigo_Datalistfixedvalues = httpContext.cgiGet( "COMBO_ACTCODIGO_Datalistfixedvalues") ;
            Combo_actcodigo_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_ACTCODIGO_Isgriditem")) ;
            Combo_actcodigo_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_ACTCODIGO_Hasdescription")) ;
            Combo_actcodigo_Datalistproc = httpContext.cgiGet( "COMBO_ACTCODIGO_Datalistproc") ;
            Combo_actcodigo_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_ACTCODIGO_Datalistprocparametersprefix") ;
            Combo_actcodigo_Remoteservicesparameters = httpContext.cgiGet( "COMBO_ACTCODIGO_Remoteservicesparameters") ;
            Combo_actcodigo_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_ACTCODIGO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_actcodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ACTCODIGO_Includeonlyselectedoption")) ;
            Combo_actcodigo_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ACTCODIGO_Includeselectalloption")) ;
            Combo_actcodigo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_ACTCODIGO_Emptyitem")) ;
            Combo_actcodigo_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ACTCODIGO_Includeaddnewoption")) ;
            Combo_actcodigo_Htmltemplate = httpContext.cgiGet( "COMBO_ACTCODIGO_Htmltemplate") ;
            Combo_actcodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_ACTCODIGO_Multiplevaluestype") ;
            Combo_actcodigo_Loadingdata = httpContext.cgiGet( "COMBO_ACTCODIGO_Loadingdata") ;
            Combo_actcodigo_Noresultsfound = httpContext.cgiGet( "COMBO_ACTCODIGO_Noresultsfound") ;
            Combo_actcodigo_Emptyitemtext = httpContext.cgiGet( "COMBO_ACTCODIGO_Emptyitemtext") ;
            Combo_actcodigo_Onlyselectedvalues = httpContext.cgiGet( "COMBO_ACTCODIGO_Onlyselectedvalues") ;
            Combo_actcodigo_Selectalltext = httpContext.cgiGet( "COMBO_ACTCODIGO_Selectalltext") ;
            Combo_actcodigo_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_ACTCODIGO_Multiplevaluesseparator") ;
            Combo_actcodigo_Addnewoptiontext = httpContext.cgiGet( "COMBO_ACTCODIGO_Addnewoptiontext") ;
            Combo_actcodigo_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_ACTCODIGO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_tipemplecod_Objectcall = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Objectcall") ;
            Combo_tipemplecod_Class = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Class") ;
            Combo_tipemplecod_Icontype = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Icontype") ;
            Combo_tipemplecod_Icon = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Icon") ;
            Combo_tipemplecod_Caption = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Caption") ;
            Combo_tipemplecod_Tooltip = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Tooltip") ;
            Combo_tipemplecod_Cls = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Cls") ;
            Combo_tipemplecod_Selectedvalue_set = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Selectedvalue_set") ;
            Combo_tipemplecod_Selectedvalue_get = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Selectedvalue_get") ;
            Combo_tipemplecod_Selectedtext_set = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Selectedtext_set") ;
            Combo_tipemplecod_Selectedtext_get = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Selectedtext_get") ;
            Combo_tipemplecod_Gamoauthtoken = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Gamoauthtoken") ;
            Combo_tipemplecod_Ddointernalname = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Ddointernalname") ;
            Combo_tipemplecod_Titlecontrolalign = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Titlecontrolalign") ;
            Combo_tipemplecod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Dropdownoptionstype") ;
            Combo_tipemplecod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPEMPLECOD_Enabled")) ;
            Combo_tipemplecod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPEMPLECOD_Visible")) ;
            Combo_tipemplecod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Titlecontrolidtoreplace") ;
            Combo_tipemplecod_Datalisttype = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Datalisttype") ;
            Combo_tipemplecod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPEMPLECOD_Allowmultipleselection")) ;
            Combo_tipemplecod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Datalistfixedvalues") ;
            Combo_tipemplecod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPEMPLECOD_Isgriditem")) ;
            Combo_tipemplecod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPEMPLECOD_Hasdescription")) ;
            Combo_tipemplecod_Datalistproc = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Datalistproc") ;
            Combo_tipemplecod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Datalistprocparametersprefix") ;
            Combo_tipemplecod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Remoteservicesparameters") ;
            Combo_tipemplecod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_TIPEMPLECOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_tipemplecod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPEMPLECOD_Includeonlyselectedoption")) ;
            Combo_tipemplecod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPEMPLECOD_Includeselectalloption")) ;
            Combo_tipemplecod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPEMPLECOD_Emptyitem")) ;
            Combo_tipemplecod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_TIPEMPLECOD_Includeaddnewoption")) ;
            Combo_tipemplecod_Htmltemplate = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Htmltemplate") ;
            Combo_tipemplecod_Multiplevaluestype = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Multiplevaluestype") ;
            Combo_tipemplecod_Loadingdata = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Loadingdata") ;
            Combo_tipemplecod_Noresultsfound = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Noresultsfound") ;
            Combo_tipemplecod_Emptyitemtext = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Emptyitemtext") ;
            Combo_tipemplecod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Onlyselectedvalues") ;
            Combo_tipemplecod_Selectalltext = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Selectalltext") ;
            Combo_tipemplecod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Multiplevaluesseparator") ;
            Combo_tipemplecod_Addnewoptiontext = httpContext.cgiGet( "COMBO_TIPEMPLECOD_Addnewoptiontext") ;
            Combo_tipemplecod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_TIPEMPLECOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_empzoncod_Objectcall = httpContext.cgiGet( "COMBO_EMPZONCOD_Objectcall") ;
            Combo_empzoncod_Class = httpContext.cgiGet( "COMBO_EMPZONCOD_Class") ;
            Combo_empzoncod_Icontype = httpContext.cgiGet( "COMBO_EMPZONCOD_Icontype") ;
            Combo_empzoncod_Icon = httpContext.cgiGet( "COMBO_EMPZONCOD_Icon") ;
            Combo_empzoncod_Caption = httpContext.cgiGet( "COMBO_EMPZONCOD_Caption") ;
            Combo_empzoncod_Tooltip = httpContext.cgiGet( "COMBO_EMPZONCOD_Tooltip") ;
            Combo_empzoncod_Cls = httpContext.cgiGet( "COMBO_EMPZONCOD_Cls") ;
            Combo_empzoncod_Selectedvalue_set = httpContext.cgiGet( "COMBO_EMPZONCOD_Selectedvalue_set") ;
            Combo_empzoncod_Selectedvalue_get = httpContext.cgiGet( "COMBO_EMPZONCOD_Selectedvalue_get") ;
            Combo_empzoncod_Selectedtext_set = httpContext.cgiGet( "COMBO_EMPZONCOD_Selectedtext_set") ;
            Combo_empzoncod_Selectedtext_get = httpContext.cgiGet( "COMBO_EMPZONCOD_Selectedtext_get") ;
            Combo_empzoncod_Gamoauthtoken = httpContext.cgiGet( "COMBO_EMPZONCOD_Gamoauthtoken") ;
            Combo_empzoncod_Ddointernalname = httpContext.cgiGet( "COMBO_EMPZONCOD_Ddointernalname") ;
            Combo_empzoncod_Titlecontrolalign = httpContext.cgiGet( "COMBO_EMPZONCOD_Titlecontrolalign") ;
            Combo_empzoncod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_EMPZONCOD_Dropdownoptionstype") ;
            Combo_empzoncod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPZONCOD_Enabled")) ;
            Combo_empzoncod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPZONCOD_Visible")) ;
            Combo_empzoncod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_EMPZONCOD_Titlecontrolidtoreplace") ;
            Combo_empzoncod_Datalisttype = httpContext.cgiGet( "COMBO_EMPZONCOD_Datalisttype") ;
            Combo_empzoncod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPZONCOD_Allowmultipleselection")) ;
            Combo_empzoncod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_EMPZONCOD_Datalistfixedvalues") ;
            Combo_empzoncod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPZONCOD_Isgriditem")) ;
            Combo_empzoncod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPZONCOD_Hasdescription")) ;
            Combo_empzoncod_Datalistproc = httpContext.cgiGet( "COMBO_EMPZONCOD_Datalistproc") ;
            Combo_empzoncod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_EMPZONCOD_Datalistprocparametersprefix") ;
            Combo_empzoncod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_EMPZONCOD_Remoteservicesparameters") ;
            Combo_empzoncod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_EMPZONCOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_empzoncod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPZONCOD_Includeonlyselectedoption")) ;
            Combo_empzoncod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPZONCOD_Includeselectalloption")) ;
            Combo_empzoncod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPZONCOD_Emptyitem")) ;
            Combo_empzoncod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPZONCOD_Includeaddnewoption")) ;
            Combo_empzoncod_Htmltemplate = httpContext.cgiGet( "COMBO_EMPZONCOD_Htmltemplate") ;
            Combo_empzoncod_Multiplevaluestype = httpContext.cgiGet( "COMBO_EMPZONCOD_Multiplevaluestype") ;
            Combo_empzoncod_Loadingdata = httpContext.cgiGet( "COMBO_EMPZONCOD_Loadingdata") ;
            Combo_empzoncod_Noresultsfound = httpContext.cgiGet( "COMBO_EMPZONCOD_Noresultsfound") ;
            Combo_empzoncod_Emptyitemtext = httpContext.cgiGet( "COMBO_EMPZONCOD_Emptyitemtext") ;
            Combo_empzoncod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_EMPZONCOD_Onlyselectedvalues") ;
            Combo_empzoncod_Selectalltext = httpContext.cgiGet( "COMBO_EMPZONCOD_Selectalltext") ;
            Combo_empzoncod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_EMPZONCOD_Multiplevaluesseparator") ;
            Combo_empzoncod_Addnewoptiontext = httpContext.cgiGet( "COMBO_EMPZONCOD_Addnewoptiontext") ;
            Combo_empzoncod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_EMPZONCOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            A2EmpNom = GXutil.upper( httpContext.cgiGet( edtEmpNom_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2EmpNom", A2EmpNom);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCUIT_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCUIT_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPCUIT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpCUIT_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A177EmpCUIT = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A177EmpCUIT", GXutil.ltrimstr( DecimalUtil.doubleToDec(A177EmpCUIT), 11, 0));
            }
            else
            {
               A177EmpCUIT = localUtil.ctol( httpContext.cgiGet( edtEmpCUIT_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A177EmpCUIT", GXutil.ltrimstr( DecimalUtil.doubleToDec(A177EmpCUIT), 11, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCatIvaCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCatIvaCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CATIVACOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCatIvaCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A125CatIvaCod = (short)(0) ;
               n125CatIvaCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A125CatIvaCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125CatIvaCod), 4, 0));
            }
            else
            {
               A125CatIvaCod = (short)(localUtil.ctol( httpContext.cgiGet( edtCatIvaCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n125CatIvaCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A125CatIvaCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125CatIvaCod), 4, 0));
            }
            n125CatIvaCod = ((0==A125CatIvaCod) ? true : false) ;
            A126CatIvaDesc = GXutil.upper( httpContext.cgiGet( edtCatIvaDesc_Internalname)) ;
            n126CatIvaDesc = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A126CatIvaDesc", A126CatIvaDesc);
            n126CatIvaDesc = ((GXutil.strcmp("", A126CatIvaDesc)==0) ? true : false) ;
            A178EmpDir = GXutil.upper( httpContext.cgiGet( edtEmpDir_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A178EmpDir", A178EmpDir);
            A180EmpTel = GXutil.upper( httpContext.cgiGet( edtEmpTel_Internalname)) ;
            n180EmpTel = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A180EmpTel", A180EmpTel);
            n180EmpTel = ((GXutil.strcmp("", A180EmpTel)==0) ? true : false) ;
            A176EmpCP = GXutil.upper( httpContext.cgiGet( edtEmpCP_Internalname)) ;
            n176EmpCP = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A176EmpCP", A176EmpCP);
            n176EmpCP = ((GXutil.strcmp("", A176EmpCP)==0) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A46PaiCod = (short)(0) ;
               n46PaiCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            }
            else
            {
               A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n46PaiCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            }
            n46PaiCod = ((0==A46PaiCod) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtProvCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtProvCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PROVCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtProvCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A47ProvCod = (short)(0) ;
               n47ProvCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
            }
            else
            {
               A47ProvCod = (short)(localUtil.ctol( httpContext.cgiGet( edtProvCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n47ProvCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
            }
            n47ProvCod = ((0==A47ProvCod) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLocCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLocCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LOCCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLocCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A48LocCod = (short)(0) ;
               n48LocCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
            }
            else
            {
               A48LocCod = (short)(localUtil.ctol( httpContext.cgiGet( edtLocCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n48LocCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
            }
            n48LocCod = ((0==A48LocCod) ? true : false) ;
            A43ActCodigo = httpContext.cgiGet( edtActCodigo_Internalname) ;
            n43ActCodigo = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A43ActCodigo", A43ActCodigo);
            n43ActCodigo = ((GXutil.strcmp("", A43ActCodigo)==0) ? true : false) ;
            A45TipEmpleCod = httpContext.cgiGet( edtTipEmpleCod_Internalname) ;
            n45TipEmpleCod = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A45TipEmpleCod", A45TipEmpleCod);
            n45TipEmpleCod = ((GXutil.strcmp("", A45TipEmpleCod)==0) ? true : false) ;
            A44EmpZonCod = httpContext.cgiGet( edtEmpZonCod_Internalname) ;
            n44EmpZonCod = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A44EmpZonCod", A44EmpZonCod);
            n44EmpZonCod = ((GXutil.strcmp("", A44EmpZonCod)==0) ? true : false) ;
            A518EmpZonDescrip = httpContext.cgiGet( edtEmpZonDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A518EmpZonDescrip", A518EmpZonDescrip);
            A532EmpReducc = GXutil.strtobool( httpContext.cgiGet( chkEmpReducc.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A532EmpReducc", A532EmpReducc);
            cmbTipEmpleDefIns.setValue( httpContext.cgiGet( cmbTipEmpleDefIns.getInternalname()) );
            A530TipEmpleDefIns = httpContext.cgiGet( cmbTipEmpleDefIns.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A530TipEmpleDefIns", A530TipEmpleDefIns);
            AV21ComboPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombopaicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21ComboPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboPaiCod), 4, 0));
            AV23ComboProvCod = (short)(localUtil.ctol( httpContext.cgiGet( edtavComboprovcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23ComboProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboProvCod), 4, 0));
            AV26ComboLocCod = (short)(localUtil.ctol( httpContext.cgiGet( edtavComboloccod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26ComboLocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ComboLocCod), 4, 0));
            AV29ComboActCodigo = httpContext.cgiGet( edtavComboactcodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29ComboActCodigo", AV29ComboActCodigo);
            AV42ComboTipEmpleCod = httpContext.cgiGet( edtavCombotipemplecod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42ComboTipEmpleCod", AV42ComboTipEmpleCod);
            AV38ComboEmpZonCod = httpContext.cgiGet( edtavComboempzoncod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38ComboEmpZonCod", AV38ComboEmpZonCod);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"LiqImportarAuxTrn");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("liqimportarauxtrn:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
                  sMode13 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode13 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound13 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_2B0( ) ;
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
                        e112B2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e122B2 ();
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
         e122B2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll2B13( ) ;
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
         disableAttributes2B13( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopaicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopaicod_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavComboprovcod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboprovcod_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavComboloccod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboloccod_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavComboactcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboactcodigo_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombotipemplecod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombotipemplecod_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavComboempzoncod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboempzoncod_Enabled), 5, 0), true);
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

   public void confirm_2B0( )
   {
      beforeValidate2B13( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2B13( ) ;
         }
         else
         {
            checkExtendedTable2B13( ) ;
            closeExtendedTableCursors2B13( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption2B0( )
   {
   }

   public void e112B2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV17DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV17DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtEmpZonCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpZonCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpZonCod_Visible), 5, 0), true);
      AV38ComboEmpZonCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38ComboEmpZonCod", AV38ComboEmpZonCod);
      edtavComboempzoncod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboempzoncod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboempzoncod_Visible), 5, 0), true);
      edtTipEmpleCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipEmpleCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipEmpleCod_Visible), 5, 0), true);
      AV42ComboTipEmpleCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42ComboTipEmpleCod", AV42ComboTipEmpleCod);
      edtavCombotipemplecod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombotipemplecod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombotipemplecod_Visible), 5, 0), true);
      edtActCodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtActCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtActCodigo_Visible), 5, 0), true);
      AV29ComboActCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29ComboActCodigo", AV29ComboActCodigo);
      edtavComboactcodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboactcodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboactcodigo_Visible), 5, 0), true);
      edtLocCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLocCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocCod_Visible), 5, 0), true);
      AV26ComboLocCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ComboLocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ComboLocCod), 4, 0));
      edtavComboloccod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboloccod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboloccod_Visible), 5, 0), true);
      edtProvCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProvCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProvCod_Visible), 5, 0), true);
      AV23ComboProvCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboProvCod), 4, 0));
      edtavComboprovcod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboprovcod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboprovcod_Visible), 5, 0), true);
      edtPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Visible), 5, 0), true);
      AV21ComboPaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboPaiCod), 4, 0));
      edtavCombopaicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopaicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopaicod_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOPAICOD' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOPROVCOD' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOLOCCOD' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOACTCODIGO' */
      S142 ();
      if ( returnInSub )
      {
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOTIPEMPLECOD' */
      S152 ();
      if ( returnInSub )
      {
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOEMPZONCOD' */
      S162 ();
      if ( returnInSub )
      {
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV31IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31IsAuthorized", AV31IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV31IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiqImportarAuxTrn_Insert", GXv_boolean5) ;
         liqimportarauxtrn_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV31IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31IsAuthorized", AV31IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV31IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiqImportarAuxTrn_Update", GXv_boolean5) ;
         liqimportarauxtrn_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV31IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31IsAuthorized", AV31IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV31IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiqImportarAuxTrn_Delete", GXv_boolean5) ;
         liqimportarauxtrn_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV31IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31IsAuthorized", AV31IsAuthorized);
      }
      if ( ! AV31IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV45Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV9TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV45Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV46GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46GXV1), 8, 0));
         while ( AV46GXV1 <= AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV15TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV46GXV1));
            if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PaiCod") == 0 )
            {
               AV11Insert_PaiCod = (short)(GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11Insert_PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11Insert_PaiCod), 4, 0));
               if ( ! (0==AV11Insert_PaiCod) )
               {
                  AV21ComboPaiCod = AV11Insert_PaiCod ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21ComboPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboPaiCod), 4, 0));
                  Combo_paicod_Selectedvalue_set = GXutil.trim( GXutil.str( AV21ComboPaiCod, 4, 0)) ;
                  ucCombo_paicod.sendProperty(context, "", false, Combo_paicod_Internalname, "SelectedValue_set", Combo_paicod_Selectedvalue_set);
                  GXt_char6 = AV20Combo_DataJson ;
                  GXv_char7[0] = AV18ComboSelectedValue ;
                  GXv_char8[0] = AV19ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new web.liqimportarauxtrnloaddvcombo(remoteHandle, context).execute( "PaiCod", "GET", false, AV30CliCod, AV7EmpCod, A46PaiCod, A47ProvCod, AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  liqimportarauxtrn_impl.this.AV18ComboSelectedValue = GXv_char7[0] ;
                  liqimportarauxtrn_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
                  liqimportarauxtrn_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
                  AV20Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
                  Combo_paicod_Selectedtext_set = AV19ComboSelectedText ;
                  ucCombo_paicod.sendProperty(context, "", false, Combo_paicod_Internalname, "SelectedText_set", Combo_paicod_Selectedtext_set);
                  Combo_paicod_Enabled = false ;
                  ucCombo_paicod.sendProperty(context, "", false, Combo_paicod_Internalname, "Enabled", GXutil.booltostr( Combo_paicod_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ProvCod") == 0 )
            {
               AV12Insert_ProvCod = (short)(GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_ProvCod), 4, 0));
               if ( ! (0==AV12Insert_ProvCod) )
               {
                  AV23ComboProvCod = AV12Insert_ProvCod ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV23ComboProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboProvCod), 4, 0));
                  Combo_provcod_Selectedvalue_set = GXutil.trim( GXutil.str( AV23ComboProvCod, 4, 0)) ;
                  ucCombo_provcod.sendProperty(context, "", false, Combo_provcod_Internalname, "SelectedValue_set", Combo_provcod_Selectedvalue_set);
                  GXt_char6 = AV20Combo_DataJson ;
                  GXv_char9[0] = AV18ComboSelectedValue ;
                  GXv_char8[0] = AV19ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.liqimportarauxtrnloaddvcombo(remoteHandle, context).execute( "ProvCod", "GET", false, AV30CliCod, AV7EmpCod, AV11Insert_PaiCod, A47ProvCod, AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  liqimportarauxtrn_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
                  liqimportarauxtrn_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
                  liqimportarauxtrn_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
                  AV20Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
                  Combo_provcod_Selectedtext_set = AV19ComboSelectedText ;
                  ucCombo_provcod.sendProperty(context, "", false, Combo_provcod_Internalname, "SelectedText_set", Combo_provcod_Selectedtext_set);
                  Combo_provcod_Enabled = false ;
                  ucCombo_provcod.sendProperty(context, "", false, Combo_provcod_Internalname, "Enabled", GXutil.booltostr( Combo_provcod_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LocCod") == 0 )
            {
               AV13Insert_LocCod = (short)(GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_LocCod), 4, 0));
               if ( ! (0==AV13Insert_LocCod) )
               {
                  AV26ComboLocCod = AV13Insert_LocCod ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV26ComboLocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ComboLocCod), 4, 0));
                  Combo_loccod_Selectedvalue_set = GXutil.trim( GXutil.str( AV26ComboLocCod, 4, 0)) ;
                  ucCombo_loccod.sendProperty(context, "", false, Combo_loccod_Internalname, "SelectedValue_set", Combo_loccod_Selectedvalue_set);
                  GXt_char6 = AV20Combo_DataJson ;
                  GXv_char9[0] = AV18ComboSelectedValue ;
                  GXv_char8[0] = AV19ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.liqimportarauxtrnloaddvcombo(remoteHandle, context).execute( "LocCod", "GET", false, AV30CliCod, AV7EmpCod, AV11Insert_PaiCod, AV12Insert_ProvCod, AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  liqimportarauxtrn_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
                  liqimportarauxtrn_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
                  liqimportarauxtrn_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
                  AV20Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
                  Combo_loccod_Selectedtext_set = AV19ComboSelectedText ;
                  ucCombo_loccod.sendProperty(context, "", false, Combo_loccod_Internalname, "SelectedText_set", Combo_loccod_Selectedtext_set);
                  Combo_loccod_Enabled = false ;
                  ucCombo_loccod.sendProperty(context, "", false, Combo_loccod_Internalname, "Enabled", GXutil.booltostr( Combo_loccod_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ActCodigo") == 0 )
            {
               AV14Insert_ActCodigo = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14Insert_ActCodigo", AV14Insert_ActCodigo);
               if ( ! (GXutil.strcmp("", AV14Insert_ActCodigo)==0) )
               {
                  AV29ComboActCodigo = AV14Insert_ActCodigo ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV29ComboActCodigo", AV29ComboActCodigo);
                  Combo_actcodigo_Selectedvalue_set = AV29ComboActCodigo ;
                  ucCombo_actcodigo.sendProperty(context, "", false, Combo_actcodigo_Internalname, "SelectedValue_set", Combo_actcodigo_Selectedvalue_set);
                  GXt_char6 = AV20Combo_DataJson ;
                  GXv_char9[0] = AV18ComboSelectedValue ;
                  GXv_char8[0] = AV19ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.liqimportarauxtrnloaddvcombo(remoteHandle, context).execute( "ActCodigo", "GET", false, AV30CliCod, AV7EmpCod, A46PaiCod, A47ProvCod, AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  liqimportarauxtrn_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
                  liqimportarauxtrn_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
                  liqimportarauxtrn_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
                  AV20Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
                  Combo_actcodigo_Selectedtext_set = AV19ComboSelectedText ;
                  ucCombo_actcodigo.sendProperty(context, "", false, Combo_actcodigo_Internalname, "SelectedText_set", Combo_actcodigo_Selectedtext_set);
                  Combo_actcodigo_Enabled = false ;
                  ucCombo_actcodigo.sendProperty(context, "", false, Combo_actcodigo_Internalname, "Enabled", GXutil.booltostr( Combo_actcodigo_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "TipEmpleCod") == 0 )
            {
               AV40Insert_TipEmpleCod = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV40Insert_TipEmpleCod", AV40Insert_TipEmpleCod);
               if ( ! (GXutil.strcmp("", AV40Insert_TipEmpleCod)==0) )
               {
                  AV42ComboTipEmpleCod = AV40Insert_TipEmpleCod ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV42ComboTipEmpleCod", AV42ComboTipEmpleCod);
                  Combo_tipemplecod_Selectedvalue_set = AV42ComboTipEmpleCod ;
                  ucCombo_tipemplecod.sendProperty(context, "", false, Combo_tipemplecod_Internalname, "SelectedValue_set", Combo_tipemplecod_Selectedvalue_set);
                  GXt_char6 = AV20Combo_DataJson ;
                  GXv_char9[0] = AV18ComboSelectedValue ;
                  GXv_char8[0] = AV19ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.liqimportarauxtrnloaddvcombo(remoteHandle, context).execute( "TipEmpleCod", "GET", false, AV30CliCod, AV7EmpCod, A46PaiCod, A47ProvCod, AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  liqimportarauxtrn_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
                  liqimportarauxtrn_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
                  liqimportarauxtrn_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
                  AV20Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
                  Combo_tipemplecod_Selectedtext_set = AV19ComboSelectedText ;
                  ucCombo_tipemplecod.sendProperty(context, "", false, Combo_tipemplecod_Internalname, "SelectedText_set", Combo_tipemplecod_Selectedtext_set);
                  Combo_tipemplecod_Enabled = false ;
                  ucCombo_tipemplecod.sendProperty(context, "", false, Combo_tipemplecod_Internalname, "Enabled", GXutil.booltostr( Combo_tipemplecod_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EmpZonCod") == 0 )
            {
               AV36Insert_EmpZonCod = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV36Insert_EmpZonCod", AV36Insert_EmpZonCod);
               if ( ! (GXutil.strcmp("", AV36Insert_EmpZonCod)==0) )
               {
                  AV38ComboEmpZonCod = AV36Insert_EmpZonCod ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV38ComboEmpZonCod", AV38ComboEmpZonCod);
                  Combo_empzoncod_Selectedvalue_set = AV38ComboEmpZonCod ;
                  ucCombo_empzoncod.sendProperty(context, "", false, Combo_empzoncod_Internalname, "SelectedValue_set", Combo_empzoncod_Selectedvalue_set);
                  GXt_char6 = AV20Combo_DataJson ;
                  GXv_char9[0] = AV18ComboSelectedValue ;
                  GXv_char8[0] = AV19ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.liqimportarauxtrnloaddvcombo(remoteHandle, context).execute( "EmpZonCod", "GET", false, AV30CliCod, AV7EmpCod, A46PaiCod, A47ProvCod, AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  liqimportarauxtrn_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
                  liqimportarauxtrn_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
                  liqimportarauxtrn_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
                  AV20Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
                  Combo_empzoncod_Selectedtext_set = AV19ComboSelectedText ;
                  ucCombo_empzoncod.sendProperty(context, "", false, Combo_empzoncod_Internalname, "SelectedText_set", Combo_empzoncod_Selectedtext_set);
                  Combo_empzoncod_Enabled = false ;
                  ucCombo_empzoncod.sendProperty(context, "", false, Combo_empzoncod_Internalname, "Enabled", GXutil.booltostr( Combo_empzoncod_Enabled));
               }
            }
            AV46GXV1 = (int)(AV46GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46GXV1), 8, 0));
         }
      }
   }

   public void e122B2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      GXv_int10[0] = 0 ;
      GXv_date11[0] = AV33Date ;
      GXv_boolean5[0] = AV34CliMultiEmp ;
      GXv_char9[0] = "" ;
      new web.getdatoscliente(remoteHandle, context).execute( AV30CliCod, GXv_int10, GXv_date11, GXv_boolean5, GXv_char9) ;
      liqimportarauxtrn_impl.this.AV33Date = GXv_date11[0] ;
      liqimportarauxtrn_impl.this.AV34CliMultiEmp = GXv_boolean5[0] ;
      if ( AV34CliMultiEmp )
      {
         if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV9TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
         {
            callWebObject(formatLink("web.liqimportarauxtrnww", new String[] {}, new String[] {}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      else
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         GXEncryptionTmp = "web.listmoduleitems"+GXutil.URLEncode(GXutil.rtrim(GXutil.trim( AV35Session.getValue(httpContext.getMessage( "ModuleDescription", ""))))) ;
         callWebObject(formatLink("web.listmoduleitems") + "?" + com.genexus.util.Encryption.uriencrypt64( GXEncryptionTmp+com.genexus.util.Encryption.checksum( GXEncryptionTmp, 6), GXKey));
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
   }

   public void S162( )
   {
      /* 'LOADCOMBOEMPZONCOD' Routine */
      returnInSub = false ;
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.liqimportarauxtrnloaddvcombo(remoteHandle, context).execute( "EmpZonCod", Gx_mode, false, AV30CliCod, AV7EmpCod, A46PaiCod, A47ProvCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      liqimportarauxtrn_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      liqimportarauxtrn_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      liqimportarauxtrn_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_empzoncod_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_empzoncod.sendProperty(context, "", false, Combo_empzoncod_Internalname, "SelectedValue_set", Combo_empzoncod_Selectedvalue_set);
      Combo_empzoncod_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_empzoncod.sendProperty(context, "", false, Combo_empzoncod_Internalname, "SelectedText_set", Combo_empzoncod_Selectedtext_set);
      AV38ComboEmpZonCod = AV18ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38ComboEmpZonCod", AV38ComboEmpZonCod);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_empzoncod_Enabled = false ;
         ucCombo_empzoncod.sendProperty(context, "", false, Combo_empzoncod_Internalname, "Enabled", GXutil.booltostr( Combo_empzoncod_Enabled));
      }
   }

   public void S152( )
   {
      /* 'LOADCOMBOTIPEMPLECOD' Routine */
      returnInSub = false ;
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.liqimportarauxtrnloaddvcombo(remoteHandle, context).execute( "TipEmpleCod", Gx_mode, false, AV30CliCod, AV7EmpCod, A46PaiCod, A47ProvCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      liqimportarauxtrn_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      liqimportarauxtrn_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      liqimportarauxtrn_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_tipemplecod_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_tipemplecod.sendProperty(context, "", false, Combo_tipemplecod_Internalname, "SelectedValue_set", Combo_tipemplecod_Selectedvalue_set);
      Combo_tipemplecod_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_tipemplecod.sendProperty(context, "", false, Combo_tipemplecod_Internalname, "SelectedText_set", Combo_tipemplecod_Selectedtext_set);
      AV42ComboTipEmpleCod = AV18ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42ComboTipEmpleCod", AV42ComboTipEmpleCod);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_tipemplecod_Enabled = false ;
         ucCombo_tipemplecod.sendProperty(context, "", false, Combo_tipemplecod_Internalname, "Enabled", GXutil.booltostr( Combo_tipemplecod_Enabled));
      }
   }

   public void S142( )
   {
      /* 'LOADCOMBOACTCODIGO' Routine */
      returnInSub = false ;
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.liqimportarauxtrnloaddvcombo(remoteHandle, context).execute( "ActCodigo", Gx_mode, false, AV30CliCod, AV7EmpCod, A46PaiCod, A47ProvCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      liqimportarauxtrn_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      liqimportarauxtrn_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      liqimportarauxtrn_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_actcodigo_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_actcodigo.sendProperty(context, "", false, Combo_actcodigo_Internalname, "SelectedValue_set", Combo_actcodigo_Selectedvalue_set);
      Combo_actcodigo_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_actcodigo.sendProperty(context, "", false, Combo_actcodigo_Internalname, "SelectedText_set", Combo_actcodigo_Selectedtext_set);
      AV29ComboActCodigo = AV18ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29ComboActCodigo", AV29ComboActCodigo);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_actcodigo_Enabled = false ;
         ucCombo_actcodigo.sendProperty(context, "", false, Combo_actcodigo_Internalname, "Enabled", GXutil.booltostr( Combo_actcodigo_Enabled));
      }
   }

   public void S132( )
   {
      /* 'LOADCOMBOLOCCOD' Routine */
      returnInSub = false ;
      Combo_loccod_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"LocCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"EmpCod\": 0, \"Cond_PaiCod\": \"#%1#\", \"Cond_ProvCod\": \"#%2#\"", edtPaiCod_Internalname, edtProvCod_Internalname, "", "", "", "", "", "", "") ;
      ucCombo_loccod.sendProperty(context, "", false, Combo_loccod_Internalname, "DataListProcParametersPrefix", Combo_loccod_Datalistprocparametersprefix);
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.liqimportarauxtrnloaddvcombo(remoteHandle, context).execute( "LocCod", Gx_mode, false, AV30CliCod, AV7EmpCod, A46PaiCod, A47ProvCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      liqimportarauxtrn_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      liqimportarauxtrn_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      liqimportarauxtrn_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_loccod_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_loccod.sendProperty(context, "", false, Combo_loccod_Internalname, "SelectedValue_set", Combo_loccod_Selectedvalue_set);
      Combo_loccod_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_loccod.sendProperty(context, "", false, Combo_loccod_Internalname, "SelectedText_set", Combo_loccod_Selectedtext_set);
      AV26ComboLocCod = (short)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ComboLocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ComboLocCod), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_loccod_Enabled = false ;
         ucCombo_loccod.sendProperty(context, "", false, Combo_loccod_Internalname, "Enabled", GXutil.booltostr( Combo_loccod_Enabled));
      }
   }

   public void S122( )
   {
      /* 'LOADCOMBOPROVCOD' Routine */
      returnInSub = false ;
      Combo_provcod_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"ProvCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"EmpCod\": 0, \"Cond_PaiCod\": \"#%1#\", \"Cond_ProvCod\": \"#%2#\"", edtPaiCod_Internalname, edtProvCod_Internalname, "", "", "", "", "", "", "") ;
      ucCombo_provcod.sendProperty(context, "", false, Combo_provcod_Internalname, "DataListProcParametersPrefix", Combo_provcod_Datalistprocparametersprefix);
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.liqimportarauxtrnloaddvcombo(remoteHandle, context).execute( "ProvCod", Gx_mode, false, AV30CliCod, AV7EmpCod, A46PaiCod, A47ProvCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      liqimportarauxtrn_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      liqimportarauxtrn_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      liqimportarauxtrn_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_provcod_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_provcod.sendProperty(context, "", false, Combo_provcod_Internalname, "SelectedValue_set", Combo_provcod_Selectedvalue_set);
      Combo_provcod_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_provcod.sendProperty(context, "", false, Combo_provcod_Internalname, "SelectedText_set", Combo_provcod_Selectedtext_set);
      AV23ComboProvCod = (short)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboProvCod), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_provcod_Enabled = false ;
         ucCombo_provcod.sendProperty(context, "", false, Combo_provcod_Internalname, "Enabled", GXutil.booltostr( Combo_provcod_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOPAICOD' Routine */
      returnInSub = false ;
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.liqimportarauxtrnloaddvcombo(remoteHandle, context).execute( "PaiCod", Gx_mode, false, AV30CliCod, AV7EmpCod, A46PaiCod, A47ProvCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      liqimportarauxtrn_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      liqimportarauxtrn_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      liqimportarauxtrn_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_paicod_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_paicod.sendProperty(context, "", false, Combo_paicod_Internalname, "SelectedValue_set", Combo_paicod_Selectedvalue_set);
      Combo_paicod_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_paicod.sendProperty(context, "", false, Combo_paicod_Internalname, "SelectedText_set", Combo_paicod_Selectedtext_set);
      AV21ComboPaiCod = (short)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboPaiCod), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_paicod_Enabled = false ;
         ucCombo_paicod.sendProperty(context, "", false, Combo_paicod_Internalname, "Enabled", GXutil.booltostr( Combo_paicod_Enabled));
      }
   }

   public void zm2B13( int GX_JID )
   {
      if ( ( GX_JID == 29 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2EmpNom = T002B3_A2EmpNom[0] ;
            Z177EmpCUIT = T002B3_A177EmpCUIT[0] ;
            Z125CatIvaCod = T002B3_A125CatIvaCod[0] ;
            Z126CatIvaDesc = T002B3_A126CatIvaDesc[0] ;
            Z178EmpDir = T002B3_A178EmpDir[0] ;
            Z180EmpTel = T002B3_A180EmpTel[0] ;
            Z176EmpCP = T002B3_A176EmpCP[0] ;
            Z532EmpReducc = T002B3_A532EmpReducc[0] ;
            Z46PaiCod = T002B3_A46PaiCod[0] ;
            Z47ProvCod = T002B3_A47ProvCod[0] ;
            Z48LocCod = T002B3_A48LocCod[0] ;
            Z43ActCodigo = T002B3_A43ActCodigo[0] ;
            Z45TipEmpleCod = T002B3_A45TipEmpleCod[0] ;
            Z44EmpZonCod = T002B3_A44EmpZonCod[0] ;
         }
         else
         {
            Z2EmpNom = A2EmpNom ;
            Z177EmpCUIT = A177EmpCUIT ;
            Z125CatIvaCod = A125CatIvaCod ;
            Z126CatIvaDesc = A126CatIvaDesc ;
            Z178EmpDir = A178EmpDir ;
            Z180EmpTel = A180EmpTel ;
            Z176EmpCP = A176EmpCP ;
            Z532EmpReducc = A532EmpReducc ;
            Z46PaiCod = A46PaiCod ;
            Z47ProvCod = A47ProvCod ;
            Z48LocCod = A48LocCod ;
            Z43ActCodigo = A43ActCodigo ;
            Z45TipEmpleCod = A45TipEmpleCod ;
            Z44EmpZonCod = A44EmpZonCod ;
         }
      }
      if ( GX_JID == -29 )
      {
         Z1EmpCod = A1EmpCod ;
         Z2EmpNom = A2EmpNom ;
         Z177EmpCUIT = A177EmpCUIT ;
         Z125CatIvaCod = A125CatIvaCod ;
         Z126CatIvaDesc = A126CatIvaDesc ;
         Z178EmpDir = A178EmpDir ;
         Z180EmpTel = A180EmpTel ;
         Z176EmpCP = A176EmpCP ;
         Z532EmpReducc = A532EmpReducc ;
         Z46PaiCod = A46PaiCod ;
         Z47ProvCod = A47ProvCod ;
         Z48LocCod = A48LocCod ;
         Z3CliCod = A3CliCod ;
         Z43ActCodigo = A43ActCodigo ;
         Z45TipEmpleCod = A45TipEmpleCod ;
         Z44EmpZonCod = A44EmpZonCod ;
         Z312PaiNom = A312PaiNom ;
         Z322ProvNom = A322ProvNom ;
         Z286LocNom = A286LocNom ;
         Z683ActDescripSinAc = A683ActDescripSinAc ;
         Z108ActDescrip = A108ActDescrip ;
         Z530TipEmpleDefIns = A530TipEmpleDefIns ;
         Z518EmpZonDescrip = A518EmpZonDescrip ;
      }
   }

   public void standaloneNotModal( )
   {
      httpContext.GX_msglist.addItem(httpContext.getMessage( "Debe ingresar un valor entre 0 y 1 en Alícuota Contribución ART", ""), 1, "");
      AnyError = (short)(1) ;
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV30CliCod) )
      {
         A3CliCod = AV30CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      if ( ! (0==AV30CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV30CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7EmpCod) )
      {
         A1EmpCod = AV7EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      if ( ! (0==AV7EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      else
      {
         edtEmpCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV11Insert_PaiCod) )
      {
         edtPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      else
      {
         edtPaiCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_ProvCod) )
      {
         edtProvCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProvCod_Enabled), 5, 0), true);
      }
      else
      {
         edtProvCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProvCod_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_LocCod) )
      {
         edtLocCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLocCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocCod_Enabled), 5, 0), true);
      }
      else
      {
         edtLocCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLocCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocCod_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV14Insert_ActCodigo)==0) )
      {
         edtActCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtActCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtActCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtActCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtActCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtActCodigo_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV40Insert_TipEmpleCod)==0) )
      {
         edtTipEmpleCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTipEmpleCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipEmpleCod_Enabled), 5, 0), true);
      }
      else
      {
         edtTipEmpleCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtTipEmpleCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipEmpleCod_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV36Insert_EmpZonCod)==0) )
      {
         edtEmpZonCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpZonCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpZonCod_Enabled), 5, 0), true);
      }
      else
      {
         edtEmpZonCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpZonCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpZonCod_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV11Insert_PaiCod) )
      {
         A46PaiCod = AV11Insert_PaiCod ;
         n46PaiCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      else
      {
         if ( (0==AV21ComboPaiCod) )
         {
            A46PaiCod = (short)(0) ;
            n46PaiCod = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            n46PaiCod = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         }
         else
         {
            if ( ! (0==AV21ComboPaiCod) )
            {
               A46PaiCod = AV21ComboPaiCod ;
               n46PaiCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            }
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_ProvCod) )
      {
         A47ProvCod = AV12Insert_ProvCod ;
         n47ProvCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
      }
      else
      {
         if ( (0==AV23ComboProvCod) )
         {
            A47ProvCod = (short)(0) ;
            n47ProvCod = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
            n47ProvCod = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
         }
         else
         {
            if ( ! (0==AV23ComboProvCod) )
            {
               A47ProvCod = AV23ComboProvCod ;
               n47ProvCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
            }
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_LocCod) )
      {
         A48LocCod = AV13Insert_LocCod ;
         n48LocCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
      }
      else
      {
         if ( (0==AV26ComboLocCod) )
         {
            A48LocCod = (short)(0) ;
            n48LocCod = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
            n48LocCod = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
         }
         else
         {
            if ( ! (0==AV26ComboLocCod) )
            {
               A48LocCod = AV26ComboLocCod ;
               n48LocCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
            }
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV14Insert_ActCodigo)==0) )
      {
         A43ActCodigo = AV14Insert_ActCodigo ;
         n43ActCodigo = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A43ActCodigo", A43ActCodigo);
      }
      else
      {
         if ( (GXutil.strcmp("", AV29ComboActCodigo)==0) )
         {
            A43ActCodigo = "" ;
            n43ActCodigo = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A43ActCodigo", A43ActCodigo);
            n43ActCodigo = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A43ActCodigo", A43ActCodigo);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV29ComboActCodigo)==0) )
            {
               A43ActCodigo = AV29ComboActCodigo ;
               n43ActCodigo = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A43ActCodigo", A43ActCodigo);
            }
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV40Insert_TipEmpleCod)==0) )
      {
         A45TipEmpleCod = AV40Insert_TipEmpleCod ;
         n45TipEmpleCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A45TipEmpleCod", A45TipEmpleCod);
      }
      else
      {
         if ( (GXutil.strcmp("", AV42ComboTipEmpleCod)==0) )
         {
            A45TipEmpleCod = "" ;
            n45TipEmpleCod = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A45TipEmpleCod", A45TipEmpleCod);
            n45TipEmpleCod = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A45TipEmpleCod", A45TipEmpleCod);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV42ComboTipEmpleCod)==0) )
            {
               A45TipEmpleCod = AV42ComboTipEmpleCod ;
               n45TipEmpleCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A45TipEmpleCod", A45TipEmpleCod);
            }
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV36Insert_EmpZonCod)==0) )
      {
         A44EmpZonCod = AV36Insert_EmpZonCod ;
         n44EmpZonCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A44EmpZonCod", A44EmpZonCod);
      }
      else
      {
         if ( (GXutil.strcmp("", AV38ComboEmpZonCod)==0) )
         {
            A44EmpZonCod = "" ;
            n44EmpZonCod = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A44EmpZonCod", A44EmpZonCod);
            n44EmpZonCod = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A44EmpZonCod", A44EmpZonCod);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV38ComboEmpZonCod)==0) )
            {
               A44EmpZonCod = AV38ComboEmpZonCod ;
               n44EmpZonCod = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A44EmpZonCod", A44EmpZonCod);
            }
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
         AV45Pgmname = "LiqImportarAuxTrn" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45Pgmname", AV45Pgmname);
         /* Using cursor T002B4 */
         pr_default.execute(2, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod)});
         A312PaiNom = T002B4_A312PaiNom[0] ;
         pr_default.close(2);
         /* Using cursor T002B5 */
         pr_default.execute(3, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
         A322ProvNom = T002B5_A322ProvNom[0] ;
         pr_default.close(3);
         /* Using cursor T002B6 */
         pr_default.execute(4, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
         A286LocNom = T002B6_A286LocNom[0] ;
         pr_default.close(4);
         /* Using cursor T002B8 */
         pr_default.execute(6, new Object[] {Boolean.valueOf(n43ActCodigo), A43ActCodigo});
         A683ActDescripSinAc = T002B8_A683ActDescripSinAc[0] ;
         A108ActDescrip = T002B8_A108ActDescrip[0] ;
         pr_default.close(6);
         /* Using cursor T002B9 */
         pr_default.execute(7, new Object[] {Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod});
         A530TipEmpleDefIns = T002B9_A530TipEmpleDefIns[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A530TipEmpleDefIns", A530TipEmpleDefIns);
         pr_default.close(7);
         /* Using cursor T002B10 */
         pr_default.execute(8, new Object[] {Boolean.valueOf(n44EmpZonCod), A44EmpZonCod});
         A518EmpZonDescrip = T002B10_A518EmpZonDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A518EmpZonDescrip", A518EmpZonDescrip);
         pr_default.close(8);
      }
   }

   public void load2B13( )
   {
      /* Using cursor T002B11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A683ActDescripSinAc = T002B11_A683ActDescripSinAc[0] ;
         A2EmpNom = T002B11_A2EmpNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2EmpNom", A2EmpNom);
         A177EmpCUIT = T002B11_A177EmpCUIT[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A177EmpCUIT", GXutil.ltrimstr( DecimalUtil.doubleToDec(A177EmpCUIT), 11, 0));
         A125CatIvaCod = T002B11_A125CatIvaCod[0] ;
         n125CatIvaCod = T002B11_n125CatIvaCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A125CatIvaCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125CatIvaCod), 4, 0));
         A126CatIvaDesc = T002B11_A126CatIvaDesc[0] ;
         n126CatIvaDesc = T002B11_n126CatIvaDesc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A126CatIvaDesc", A126CatIvaDesc);
         A178EmpDir = T002B11_A178EmpDir[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A178EmpDir", A178EmpDir);
         A180EmpTel = T002B11_A180EmpTel[0] ;
         n180EmpTel = T002B11_n180EmpTel[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A180EmpTel", A180EmpTel);
         A176EmpCP = T002B11_A176EmpCP[0] ;
         n176EmpCP = T002B11_n176EmpCP[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A176EmpCP", A176EmpCP);
         A312PaiNom = T002B11_A312PaiNom[0] ;
         A322ProvNom = T002B11_A322ProvNom[0] ;
         A286LocNom = T002B11_A286LocNom[0] ;
         A108ActDescrip = T002B11_A108ActDescrip[0] ;
         A518EmpZonDescrip = T002B11_A518EmpZonDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A518EmpZonDescrip", A518EmpZonDescrip);
         A532EmpReducc = T002B11_A532EmpReducc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A532EmpReducc", A532EmpReducc);
         A530TipEmpleDefIns = T002B11_A530TipEmpleDefIns[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A530TipEmpleDefIns", A530TipEmpleDefIns);
         A46PaiCod = T002B11_A46PaiCod[0] ;
         n46PaiCod = T002B11_n46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A47ProvCod = T002B11_A47ProvCod[0] ;
         n47ProvCod = T002B11_n47ProvCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
         A48LocCod = T002B11_A48LocCod[0] ;
         n48LocCod = T002B11_n48LocCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
         A43ActCodigo = T002B11_A43ActCodigo[0] ;
         n43ActCodigo = T002B11_n43ActCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A43ActCodigo", A43ActCodigo);
         A45TipEmpleCod = T002B11_A45TipEmpleCod[0] ;
         n45TipEmpleCod = T002B11_n45TipEmpleCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A45TipEmpleCod", A45TipEmpleCod);
         A44EmpZonCod = T002B11_A44EmpZonCod[0] ;
         n44EmpZonCod = T002B11_n44EmpZonCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A44EmpZonCod", A44EmpZonCod);
         zm2B13( -29) ;
      }
      pr_default.close(9);
      onLoadActions2B13( ) ;
   }

   public void onLoadActions2B13( )
   {
      AV45Pgmname = "LiqImportarAuxTrn" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45Pgmname", AV45Pgmname);
   }

   public void checkExtendedTable2B13( )
   {
      nIsDirty_13 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV45Pgmname = "LiqImportarAuxTrn" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45Pgmname", AV45Pgmname);
      /* Using cursor T002B7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(5);
      /* Using cursor T002B4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A46PaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A312PaiNom = T002B4_A312PaiNom[0] ;
      pr_default.close(2);
      /* Using cursor T002B5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (0==A47ProvCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Provincia", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PROVCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A322ProvNom = T002B5_A322ProvNom[0] ;
      pr_default.close(3);
      /* Using cursor T002B6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (0==A47ProvCod) || (0==A48LocCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Localidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LOCCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A286LocNom = T002B6_A286LocNom[0] ;
      pr_default.close(4);
      /* Using cursor T002B8 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n43ActCodigo), A43ActCodigo});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A43ActCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Actividad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ACTCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtActCodigo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A683ActDescripSinAc = T002B8_A683ActDescripSinAc[0] ;
      A108ActDescrip = T002B8_A108ActDescrip[0] ;
      pr_default.close(6);
      /* Using cursor T002B9 */
      pr_default.execute(7, new Object[] {Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod});
      if ( (pr_default.getStatus(7) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A45TipEmpleCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Empleador", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPEMPLECOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtTipEmpleCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A530TipEmpleDefIns = T002B9_A530TipEmpleDefIns[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A530TipEmpleDefIns", A530TipEmpleDefIns);
      pr_default.close(7);
      /* Using cursor T002B10 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n44EmpZonCod), A44EmpZonCod});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A44EmpZonCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Zona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPZONCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEmpZonCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A518EmpZonDescrip = T002B10_A518EmpZonDescrip[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A518EmpZonDescrip", A518EmpZonDescrip);
      pr_default.close(8);
   }

   public void closeExtendedTableCursors2B13( )
   {
      pr_default.close(5);
      pr_default.close(2);
      pr_default.close(3);
      pr_default.close(4);
      pr_default.close(6);
      pr_default.close(7);
      pr_default.close(8);
   }

   public void enableDisable( )
   {
   }

   public void gxload_33( int A3CliCod )
   {
      /* Using cursor T002B12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(10) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(10);
   }

   public void gxload_30( short A46PaiCod )
   {
      /* Using cursor T002B13 */
      pr_default.execute(11, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         if ( ! ( (0==A46PaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A312PaiNom = T002B13_A312PaiNom[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A312PaiNom)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(11) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(11);
   }

   public void gxload_31( short A46PaiCod ,
                          short A47ProvCod )
   {
      /* Using cursor T002B14 */
      pr_default.execute(12, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (0==A47ProvCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Provincia", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PROVCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A322ProvNom = T002B14_A322ProvNom[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A322ProvNom)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(12) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(12);
   }

   public void gxload_32( short A46PaiCod ,
                          short A47ProvCod ,
                          short A48LocCod )
   {
      /* Using cursor T002B15 */
      pr_default.execute(13, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (0==A47ProvCod) || (0==A48LocCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Localidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LOCCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A286LocNom = T002B15_A286LocNom[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A286LocNom)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(13) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(13);
   }

   public void gxload_34( String A43ActCodigo )
   {
      /* Using cursor T002B16 */
      pr_default.execute(14, new Object[] {Boolean.valueOf(n43ActCodigo), A43ActCodigo});
      if ( (pr_default.getStatus(14) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A43ActCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Actividad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ACTCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtActCodigo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A683ActDescripSinAc = T002B16_A683ActDescripSinAc[0] ;
      A108ActDescrip = T002B16_A108ActDescrip[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A683ActDescripSinAc)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A108ActDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(14) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(14);
   }

   public void gxload_35( String A45TipEmpleCod )
   {
      /* Using cursor T002B17 */
      pr_default.execute(15, new Object[] {Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod});
      if ( (pr_default.getStatus(15) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A45TipEmpleCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Empleador", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPEMPLECOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtTipEmpleCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A530TipEmpleDefIns = T002B17_A530TipEmpleDefIns[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A530TipEmpleDefIns", A530TipEmpleDefIns);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A530TipEmpleDefIns))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(15) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(15);
   }

   public void gxload_36( String A44EmpZonCod )
   {
      /* Using cursor T002B18 */
      pr_default.execute(16, new Object[] {Boolean.valueOf(n44EmpZonCod), A44EmpZonCod});
      if ( (pr_default.getStatus(16) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A44EmpZonCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Zona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPZONCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEmpZonCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A518EmpZonDescrip = T002B18_A518EmpZonDescrip[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A518EmpZonDescrip", A518EmpZonDescrip);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A518EmpZonDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(16) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(16);
   }

   public void getKey2B13( )
   {
      /* Using cursor T002B19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound13 = (short)(1) ;
      }
      else
      {
         RcdFound13 = (short)(0) ;
      }
      pr_default.close(17);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T002B3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm2B13( 29) ;
         RcdFound13 = (short)(1) ;
         A1EmpCod = T002B3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A2EmpNom = T002B3_A2EmpNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2EmpNom", A2EmpNom);
         A177EmpCUIT = T002B3_A177EmpCUIT[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A177EmpCUIT", GXutil.ltrimstr( DecimalUtil.doubleToDec(A177EmpCUIT), 11, 0));
         A125CatIvaCod = T002B3_A125CatIvaCod[0] ;
         n125CatIvaCod = T002B3_n125CatIvaCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A125CatIvaCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125CatIvaCod), 4, 0));
         A126CatIvaDesc = T002B3_A126CatIvaDesc[0] ;
         n126CatIvaDesc = T002B3_n126CatIvaDesc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A126CatIvaDesc", A126CatIvaDesc);
         A178EmpDir = T002B3_A178EmpDir[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A178EmpDir", A178EmpDir);
         A180EmpTel = T002B3_A180EmpTel[0] ;
         n180EmpTel = T002B3_n180EmpTel[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A180EmpTel", A180EmpTel);
         A176EmpCP = T002B3_A176EmpCP[0] ;
         n176EmpCP = T002B3_n176EmpCP[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A176EmpCP", A176EmpCP);
         A532EmpReducc = T002B3_A532EmpReducc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A532EmpReducc", A532EmpReducc);
         A46PaiCod = T002B3_A46PaiCod[0] ;
         n46PaiCod = T002B3_n46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A47ProvCod = T002B3_A47ProvCod[0] ;
         n47ProvCod = T002B3_n47ProvCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
         A48LocCod = T002B3_A48LocCod[0] ;
         n48LocCod = T002B3_n48LocCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
         A3CliCod = T002B3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A43ActCodigo = T002B3_A43ActCodigo[0] ;
         n43ActCodigo = T002B3_n43ActCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A43ActCodigo", A43ActCodigo);
         A45TipEmpleCod = T002B3_A45TipEmpleCod[0] ;
         n45TipEmpleCod = T002B3_n45TipEmpleCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A45TipEmpleCod", A45TipEmpleCod);
         A44EmpZonCod = T002B3_A44EmpZonCod[0] ;
         n44EmpZonCod = T002B3_n44EmpZonCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A44EmpZonCod", A44EmpZonCod);
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         sMode13 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load2B13( ) ;
         if ( AnyError == 1 )
         {
            RcdFound13 = (short)(0) ;
            initializeNonKey2B13( ) ;
         }
         Gx_mode = sMode13 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound13 = (short)(0) ;
         initializeNonKey2B13( ) ;
         sMode13 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode13 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey2B13( ) ;
      if ( RcdFound13 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound13 = (short)(0) ;
      /* Using cursor T002B20 */
      pr_default.execute(18, new Object[] {Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(18) != 101) )
      {
         while ( (pr_default.getStatus(18) != 101) && ( ( T002B20_A1EmpCod[0] < A1EmpCod ) || ( T002B20_A1EmpCod[0] == A1EmpCod ) && ( T002B20_A3CliCod[0] < A3CliCod ) ) )
         {
            pr_default.readNext(18);
         }
         if ( (pr_default.getStatus(18) != 101) && ( ( T002B20_A1EmpCod[0] > A1EmpCod ) || ( T002B20_A1EmpCod[0] == A1EmpCod ) && ( T002B20_A3CliCod[0] > A3CliCod ) ) )
         {
            A1EmpCod = T002B20_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A3CliCod = T002B20_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            RcdFound13 = (short)(1) ;
         }
      }
      pr_default.close(18);
   }

   public void move_previous( )
   {
      RcdFound13 = (short)(0) ;
      /* Using cursor T002B21 */
      pr_default.execute(19, new Object[] {Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(19) != 101) )
      {
         while ( (pr_default.getStatus(19) != 101) && ( ( T002B21_A1EmpCod[0] > A1EmpCod ) || ( T002B21_A1EmpCod[0] == A1EmpCod ) && ( T002B21_A3CliCod[0] > A3CliCod ) ) )
         {
            pr_default.readNext(19);
         }
         if ( (pr_default.getStatus(19) != 101) && ( ( T002B21_A1EmpCod[0] < A1EmpCod ) || ( T002B21_A1EmpCod[0] == A1EmpCod ) && ( T002B21_A3CliCod[0] < A3CliCod ) ) )
         {
            A1EmpCod = T002B21_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A3CliCod = T002B21_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            RcdFound13 = (short)(1) ;
         }
      }
      pr_default.close(19);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2B13( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert2B13( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound13 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
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
               update2B13( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) )
            {
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert2B13( ) ;
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
                  insert2B13( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
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

   public void checkOptimisticConcurrency2B13( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002B2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresa"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z2EmpNom, T002B2_A2EmpNom[0]) != 0 ) || ( Z177EmpCUIT != T002B2_A177EmpCUIT[0] ) || ( Z125CatIvaCod != T002B2_A125CatIvaCod[0] ) || ( GXutil.strcmp(Z126CatIvaDesc, T002B2_A126CatIvaDesc[0]) != 0 ) || ( GXutil.strcmp(Z178EmpDir, T002B2_A178EmpDir[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z180EmpTel, T002B2_A180EmpTel[0]) != 0 ) || ( GXutil.strcmp(Z176EmpCP, T002B2_A176EmpCP[0]) != 0 ) || ( Z532EmpReducc != T002B2_A532EmpReducc[0] ) || ( Z46PaiCod != T002B2_A46PaiCod[0] ) || ( Z47ProvCod != T002B2_A47ProvCod[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z48LocCod != T002B2_A48LocCod[0] ) || ( GXutil.strcmp(Z43ActCodigo, T002B2_A43ActCodigo[0]) != 0 ) || ( GXutil.strcmp(Z45TipEmpleCod, T002B2_A45TipEmpleCod[0]) != 0 ) || ( GXutil.strcmp(Z44EmpZonCod, T002B2_A44EmpZonCod[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z2EmpNom, T002B2_A2EmpNom[0]) != 0 )
            {
               GXutil.writeLogln("liqimportarauxtrn:[seudo value changed for attri]"+"EmpNom");
               GXutil.writeLogRaw("Old: ",Z2EmpNom);
               GXutil.writeLogRaw("Current: ",T002B2_A2EmpNom[0]);
            }
            if ( Z177EmpCUIT != T002B2_A177EmpCUIT[0] )
            {
               GXutil.writeLogln("liqimportarauxtrn:[seudo value changed for attri]"+"EmpCUIT");
               GXutil.writeLogRaw("Old: ",Z177EmpCUIT);
               GXutil.writeLogRaw("Current: ",T002B2_A177EmpCUIT[0]);
            }
            if ( Z125CatIvaCod != T002B2_A125CatIvaCod[0] )
            {
               GXutil.writeLogln("liqimportarauxtrn:[seudo value changed for attri]"+"CatIvaCod");
               GXutil.writeLogRaw("Old: ",Z125CatIvaCod);
               GXutil.writeLogRaw("Current: ",T002B2_A125CatIvaCod[0]);
            }
            if ( GXutil.strcmp(Z126CatIvaDesc, T002B2_A126CatIvaDesc[0]) != 0 )
            {
               GXutil.writeLogln("liqimportarauxtrn:[seudo value changed for attri]"+"CatIvaDesc");
               GXutil.writeLogRaw("Old: ",Z126CatIvaDesc);
               GXutil.writeLogRaw("Current: ",T002B2_A126CatIvaDesc[0]);
            }
            if ( GXutil.strcmp(Z178EmpDir, T002B2_A178EmpDir[0]) != 0 )
            {
               GXutil.writeLogln("liqimportarauxtrn:[seudo value changed for attri]"+"EmpDir");
               GXutil.writeLogRaw("Old: ",Z178EmpDir);
               GXutil.writeLogRaw("Current: ",T002B2_A178EmpDir[0]);
            }
            if ( GXutil.strcmp(Z180EmpTel, T002B2_A180EmpTel[0]) != 0 )
            {
               GXutil.writeLogln("liqimportarauxtrn:[seudo value changed for attri]"+"EmpTel");
               GXutil.writeLogRaw("Old: ",Z180EmpTel);
               GXutil.writeLogRaw("Current: ",T002B2_A180EmpTel[0]);
            }
            if ( GXutil.strcmp(Z176EmpCP, T002B2_A176EmpCP[0]) != 0 )
            {
               GXutil.writeLogln("liqimportarauxtrn:[seudo value changed for attri]"+"EmpCP");
               GXutil.writeLogRaw("Old: ",Z176EmpCP);
               GXutil.writeLogRaw("Current: ",T002B2_A176EmpCP[0]);
            }
            if ( Z532EmpReducc != T002B2_A532EmpReducc[0] )
            {
               GXutil.writeLogln("liqimportarauxtrn:[seudo value changed for attri]"+"EmpReducc");
               GXutil.writeLogRaw("Old: ",Z532EmpReducc);
               GXutil.writeLogRaw("Current: ",T002B2_A532EmpReducc[0]);
            }
            if ( Z46PaiCod != T002B2_A46PaiCod[0] )
            {
               GXutil.writeLogln("liqimportarauxtrn:[seudo value changed for attri]"+"PaiCod");
               GXutil.writeLogRaw("Old: ",Z46PaiCod);
               GXutil.writeLogRaw("Current: ",T002B2_A46PaiCod[0]);
            }
            if ( Z47ProvCod != T002B2_A47ProvCod[0] )
            {
               GXutil.writeLogln("liqimportarauxtrn:[seudo value changed for attri]"+"ProvCod");
               GXutil.writeLogRaw("Old: ",Z47ProvCod);
               GXutil.writeLogRaw("Current: ",T002B2_A47ProvCod[0]);
            }
            if ( Z48LocCod != T002B2_A48LocCod[0] )
            {
               GXutil.writeLogln("liqimportarauxtrn:[seudo value changed for attri]"+"LocCod");
               GXutil.writeLogRaw("Old: ",Z48LocCod);
               GXutil.writeLogRaw("Current: ",T002B2_A48LocCod[0]);
            }
            if ( GXutil.strcmp(Z43ActCodigo, T002B2_A43ActCodigo[0]) != 0 )
            {
               GXutil.writeLogln("liqimportarauxtrn:[seudo value changed for attri]"+"ActCodigo");
               GXutil.writeLogRaw("Old: ",Z43ActCodigo);
               GXutil.writeLogRaw("Current: ",T002B2_A43ActCodigo[0]);
            }
            if ( GXutil.strcmp(Z45TipEmpleCod, T002B2_A45TipEmpleCod[0]) != 0 )
            {
               GXutil.writeLogln("liqimportarauxtrn:[seudo value changed for attri]"+"TipEmpleCod");
               GXutil.writeLogRaw("Old: ",Z45TipEmpleCod);
               GXutil.writeLogRaw("Current: ",T002B2_A45TipEmpleCod[0]);
            }
            if ( GXutil.strcmp(Z44EmpZonCod, T002B2_A44EmpZonCod[0]) != 0 )
            {
               GXutil.writeLogln("liqimportarauxtrn:[seudo value changed for attri]"+"EmpZonCod");
               GXutil.writeLogRaw("Old: ",Z44EmpZonCod);
               GXutil.writeLogRaw("Current: ",T002B2_A44EmpZonCod[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresa"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2B13( )
   {
      beforeValidate2B13( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2B13( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2B13( 0) ;
         checkOptimisticConcurrency2B13( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2B13( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2B13( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002B22 */
                  pr_default.execute(20, new Object[] {Short.valueOf(A1EmpCod), A2EmpNom, Long.valueOf(A177EmpCUIT), Boolean.valueOf(n125CatIvaCod), Short.valueOf(A125CatIvaCod), Boolean.valueOf(n126CatIvaDesc), A126CatIvaDesc, A178EmpDir, Boolean.valueOf(n180EmpTel), A180EmpTel, Boolean.valueOf(n176EmpCP), A176EmpCP, Boolean.valueOf(A532EmpReducc), Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod), Integer.valueOf(A3CliCod), Boolean.valueOf(n43ActCodigo), A43ActCodigo, Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod, Boolean.valueOf(n44EmpZonCod), A44EmpZonCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
                  if ( (pr_default.getStatus(20) == 1) )
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
                        resetCaption2B0( ) ;
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
            load2B13( ) ;
         }
         endLevel2B13( ) ;
      }
      closeExtendedTableCursors2B13( ) ;
   }

   public void update2B13( )
   {
      beforeValidate2B13( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2B13( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2B13( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2B13( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2B13( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002B23 */
                  pr_default.execute(21, new Object[] {A2EmpNom, Long.valueOf(A177EmpCUIT), Boolean.valueOf(n125CatIvaCod), Short.valueOf(A125CatIvaCod), Boolean.valueOf(n126CatIvaDesc), A126CatIvaDesc, A178EmpDir, Boolean.valueOf(n180EmpTel), A180EmpTel, Boolean.valueOf(n176EmpCP), A176EmpCP, Boolean.valueOf(A532EmpReducc), Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod), Boolean.valueOf(n43ActCodigo), A43ActCodigo, Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod, Boolean.valueOf(n44EmpZonCod), A44EmpZonCod, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
                  if ( (pr_default.getStatus(21) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresa"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2B13( ) ;
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
         endLevel2B13( ) ;
      }
      closeExtendedTableCursors2B13( ) ;
   }

   public void deferredUpdate2B13( )
   {
   }

   public void delete( )
   {
      beforeValidate2B13( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2B13( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2B13( ) ;
         afterConfirm2B13( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2B13( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002B24 */
               pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
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
      sMode13 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2B13( ) ;
      Gx_mode = sMode13 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2B13( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV45Pgmname = "LiqImportarAuxTrn" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45Pgmname", AV45Pgmname);
         /* Using cursor T002B25 */
         pr_default.execute(23, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod)});
         A312PaiNom = T002B25_A312PaiNom[0] ;
         pr_default.close(23);
         /* Using cursor T002B26 */
         pr_default.execute(24, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
         A322ProvNom = T002B26_A322ProvNom[0] ;
         pr_default.close(24);
         /* Using cursor T002B27 */
         pr_default.execute(25, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
         A286LocNom = T002B27_A286LocNom[0] ;
         pr_default.close(25);
         /* Using cursor T002B28 */
         pr_default.execute(26, new Object[] {Boolean.valueOf(n43ActCodigo), A43ActCodigo});
         A683ActDescripSinAc = T002B28_A683ActDescripSinAc[0] ;
         A108ActDescrip = T002B28_A108ActDescrip[0] ;
         pr_default.close(26);
         /* Using cursor T002B29 */
         pr_default.execute(27, new Object[] {Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod});
         A530TipEmpleDefIns = T002B29_A530TipEmpleDefIns[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A530TipEmpleDefIns", A530TipEmpleDefIns);
         pr_default.close(27);
         /* Using cursor T002B30 */
         pr_default.execute(28, new Object[] {Boolean.valueOf(n44EmpZonCod), A44EmpZonCod});
         A518EmpZonDescrip = T002B30_A518EmpZonDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A518EmpZonDescrip", A518EmpZonDescrip);
         pr_default.close(28);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T002B31 */
         pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(29) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "banda_salarial", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(29);
         /* Using cursor T002B32 */
         pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(30) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(30);
         /* Using cursor T002B33 */
         pr_default.execute(31, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(31) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionLotes3", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(31);
         /* Using cursor T002B34 */
         pr_default.execute(32, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(32) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(32);
         /* Using cursor T002B35 */
         pr_default.execute(33, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(33) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionLegajoLinkPdf", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(33);
         /* Using cursor T002B36 */
         pr_default.execute(34, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(34) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionSucursal", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(34);
         /* Using cursor T002B37 */
         pr_default.execute(35, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(35) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionArea", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(35);
         /* Using cursor T002B38 */
         pr_default.execute(36, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(36) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionConvenio", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(36);
         /* Using cursor T002B39 */
         pr_default.execute(37, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(37) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "EmpresaBancos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(37);
         /* Using cursor T002B40 */
         pr_default.execute(38, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(38) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Periodo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(38);
         /* Using cursor T002B41 */
         pr_default.execute(39, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(39) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LSD_reg1", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(39);
         /* Using cursor T002B42 */
         pr_default.execute(40, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(40) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(40);
         /* Using cursor T002B43 */
         pr_default.execute(41, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(41) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(41);
         /* Using cursor T002B44 */
         pr_default.execute(42, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(42) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(42);
         /* Using cursor T002B45 */
         pr_default.execute(43, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(43) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(43);
         /* Using cursor T002B46 */
         pr_default.execute(44, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(44) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(44);
         /* Using cursor T002B47 */
         pr_default.execute(45, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(45) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(45);
         /* Using cursor T002B48 */
         pr_default.execute(46, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(46) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(46);
         /* Using cursor T002B49 */
         pr_default.execute(47, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(47) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(47);
         /* Using cursor T002B50 */
         pr_default.execute(48, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(48) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(48);
         /* Using cursor T002B51 */
         pr_default.execute(49, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(49) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(49);
         /* Using cursor T002B52 */
         pr_default.execute(50, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(50) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(50);
         /* Using cursor T002B53 */
         pr_default.execute(51, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(51) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(51);
         /* Using cursor T002B54 */
         pr_default.execute(52, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(52) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(52);
         /* Using cursor T002B55 */
         pr_default.execute(53, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(53) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(53);
         /* Using cursor T002B56 */
         pr_default.execute(54, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(54) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(54);
         /* Using cursor T002B57 */
         pr_default.execute(55, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(55) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(55);
         /* Using cursor T002B58 */
         pr_default.execute(56, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(56) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(56);
         /* Using cursor T002B59 */
         pr_default.execute(57, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(57) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(57);
         /* Using cursor T002B60 */
         pr_default.execute(58, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(58) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(58);
         /* Using cursor T002B61 */
         pr_default.execute(59, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(59) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(59);
         /* Using cursor T002B62 */
         pr_default.execute(60, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(60) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(60);
         /* Using cursor T002B63 */
         pr_default.execute(61, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(61) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(61);
         /* Using cursor T002B64 */
         pr_default.execute(62, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(62) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(62);
         /* Using cursor T002B65 */
         pr_default.execute(63, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(63) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(63);
         /* Using cursor T002B66 */
         pr_default.execute(64, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(64) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(64);
         /* Using cursor T002B67 */
         pr_default.execute(65, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(65) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(65);
         /* Using cursor T002B68 */
         pr_default.execute(66, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(66) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(66);
         /* Using cursor T002B69 */
         pr_default.execute(67, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(67) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(67);
         /* Using cursor T002B70 */
         pr_default.execute(68, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(68) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(68);
         /* Using cursor T002B71 */
         pr_default.execute(69, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(69) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(69);
         /* Using cursor T002B72 */
         pr_default.execute(70, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(70) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(70);
         /* Using cursor T002B73 */
         pr_default.execute(71, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(71) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(71);
         /* Using cursor T002B74 */
         pr_default.execute(72, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(72) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(72);
         /* Using cursor T002B75 */
         pr_default.execute(73, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(73) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(73);
         /* Using cursor T002B76 */
         pr_default.execute(74, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(74) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(74);
         /* Using cursor T002B77 */
         pr_default.execute(75, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(75) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(75);
         /* Using cursor T002B78 */
         pr_default.execute(76, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(76) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(76);
         /* Using cursor T002B79 */
         pr_default.execute(77, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(77) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(77);
         /* Using cursor T002B80 */
         pr_default.execute(78, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(78) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(78);
         /* Using cursor T002B81 */
         pr_default.execute(79, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(79) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(79);
         /* Using cursor T002B82 */
         pr_default.execute(80, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(80) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(80);
         /* Using cursor T002B83 */
         pr_default.execute(81, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(81) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(81);
         /* Using cursor T002B84 */
         pr_default.execute(82, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(82) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(82);
         /* Using cursor T002B85 */
         pr_default.execute(83, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(83) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(83);
         /* Using cursor T002B86 */
         pr_default.execute(84, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(84) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(84);
         /* Using cursor T002B87 */
         pr_default.execute(85, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(85) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(85);
         /* Using cursor T002B88 */
         pr_default.execute(86, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(86) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(86);
         /* Using cursor T002B89 */
         pr_default.execute(87, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(87) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(87);
         /* Using cursor T002B90 */
         pr_default.execute(88, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(88) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(88);
         /* Using cursor T002B91 */
         pr_default.execute(89, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(89) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(89);
         /* Using cursor T002B92 */
         pr_default.execute(90, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(90) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(90);
         /* Using cursor T002B93 */
         pr_default.execute(91, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(91) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(91);
         /* Using cursor T002B94 */
         pr_default.execute(92, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(92) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(92);
         /* Using cursor T002B95 */
         pr_default.execute(93, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(93) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(93);
         /* Using cursor T002B96 */
         pr_default.execute(94, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(94) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(94);
         /* Using cursor T002B97 */
         pr_default.execute(95, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(95) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(95);
         /* Using cursor T002B98 */
         pr_default.execute(96, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(96) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Guarderias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(96);
         /* Using cursor T002B99 */
         pr_default.execute(97, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(97) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "base_calculo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(97);
         /* Using cursor T002B100 */
         pr_default.execute(98, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(98) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Promedio para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(98);
         /* Using cursor T002B101 */
         pr_default.execute(99, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(99) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para jornalizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(99);
         /* Using cursor T002B102 */
         pr_default.execute(100, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(100) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(100);
         /* Using cursor T002B103 */
         pr_default.execute(101, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(101) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "horasextras_por Limite", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(101);
         /* Using cursor T002B104 */
         pr_default.execute(102, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(102) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "horasextras_pordia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(102);
         /* Using cursor T002B105 */
         pr_default.execute(103, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(103) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Sucursal", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(103);
         /* Using cursor T002B106 */
         pr_default.execute(104, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(104) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "nolaborables_religion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(104);
         /* Using cursor T002B107 */
         pr_default.execute(105, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(105) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "nolaborables_origen", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(105);
         /* Using cursor T002B108 */
         pr_default.execute(106, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(106) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "nolaborables_convenio", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(106);
         /* Using cursor T002B109 */
         pr_default.execute(107, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(107) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Formulario F1357", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(107);
         /* Using cursor T002B110 */
         pr_default.execute(108, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(108) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "importacion_liquidaciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(108);
         /* Using cursor T002B111 */
         pr_default.execute(109, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(109) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "importacion_legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(109);
         /* Using cursor T002B112 */
         pr_default.execute(110, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(110) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Template Recibo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(110);
         /* Using cursor T002B113 */
         pr_default.execute(111, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(111) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "archivo_siradig", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(111);
         /* Using cursor T002B114 */
         pr_default.execute(112, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(112) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Asiento Cab", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(112);
         /* Using cursor T002B115 */
         pr_default.execute(113, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(113) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cuenta Contable", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(113);
         /* Using cursor T002B116 */
         pr_default.execute(114, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(114) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Centro De Costo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(114);
         /* Using cursor T002B117 */
         pr_default.execute(115, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(115) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion Lugar Pago", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(115);
         /* Using cursor T002B118 */
         pr_default.execute(116, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(116) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(116);
      }
   }

   public void endLevel2B13( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2B13( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "liqimportarauxtrn");
         if ( AnyError == 0 )
         {
            confirmValues2B0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "liqimportarauxtrn");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2B13( )
   {
      /* Scan By routine */
      /* Using cursor T002B119 */
      pr_default.execute(117);
      RcdFound13 = (short)(0) ;
      if ( (pr_default.getStatus(117) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A3CliCod = T002B119_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002B119_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2B13( )
   {
      /* Scan next routine */
      pr_default.readNext(117);
      RcdFound13 = (short)(0) ;
      if ( (pr_default.getStatus(117) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A3CliCod = T002B119_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002B119_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
   }

   public void scanEnd2B13( )
   {
      pr_default.close(117);
   }

   public void afterConfirm2B13( )
   {
      /* After Confirm Rules */
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int12 = A1EmpCod ;
         GXv_int13[0] = GXt_int12 ;
         new web.getnextemp(remoteHandle, context).execute( A3CliCod, GXv_int13) ;
         liqimportarauxtrn_impl.this.GXt_int12 = GXv_int13[0] ;
         A1EmpCod = GXt_int12 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
   }

   public void beforeInsert2B13( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2B13( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2B13( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2B13( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2B13( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2B13( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtEmpNom_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpNom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpNom_Enabled), 5, 0), true);
      edtEmpCUIT_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCUIT_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCUIT_Enabled), 5, 0), true);
      edtCatIvaCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatIvaCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatIvaCod_Enabled), 5, 0), true);
      edtCatIvaDesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatIvaDesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatIvaDesc_Enabled), 5, 0), true);
      edtEmpDir_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpDir_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpDir_Enabled), 5, 0), true);
      edtEmpTel_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpTel_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpTel_Enabled), 5, 0), true);
      edtEmpCP_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCP_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCP_Enabled), 5, 0), true);
      edtPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      edtProvCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProvCod_Enabled), 5, 0), true);
      edtLocCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLocCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLocCod_Enabled), 5, 0), true);
      edtActCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtActCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtActCodigo_Enabled), 5, 0), true);
      edtTipEmpleCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipEmpleCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipEmpleCod_Enabled), 5, 0), true);
      edtEmpZonCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpZonCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpZonCod_Enabled), 5, 0), true);
      edtEmpZonDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpZonDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpZonDescrip_Enabled), 5, 0), true);
      chkEmpReducc.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpReducc.getInternalname(), "Enabled", GXutil.ltrimstr( chkEmpReducc.getEnabled(), 5, 0), true);
      cmbTipEmpleDefIns.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbTipEmpleDefIns.getInternalname(), "Enabled", GXutil.ltrimstr( cmbTipEmpleDefIns.getEnabled(), 5, 0), true);
      edtavCombopaicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopaicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopaicod_Enabled), 5, 0), true);
      edtavComboprovcod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboprovcod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboprovcod_Enabled), 5, 0), true);
      edtavComboloccod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboloccod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboloccod_Enabled), 5, 0), true);
      edtavComboactcodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboactcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboactcodigo_Enabled), 5, 0), true);
      edtavCombotipemplecod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombotipemplecod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombotipemplecod_Enabled), 5, 0), true);
      edtavComboempzoncod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboempzoncod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboempzoncod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes2B13( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues2B0( )
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.liqimportarauxtrn", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV30CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV7EmpCod,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"LiqImportarAuxTrn");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("liqimportarauxtrn:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2EmpNom", Z2EmpNom);
      web.GxWebStd.gx_hidden_field( httpContext, "Z177EmpCUIT", GXutil.ltrim( localUtil.ntoc( Z177EmpCUIT, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z125CatIvaCod", GXutil.ltrim( localUtil.ntoc( Z125CatIvaCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z126CatIvaDesc", Z126CatIvaDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z178EmpDir", Z178EmpDir);
      web.GxWebStd.gx_hidden_field( httpContext, "Z180EmpTel", Z180EmpTel);
      web.GxWebStd.gx_hidden_field( httpContext, "Z176EmpCP", GXutil.rtrim( Z176EmpCP));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z532EmpReducc", Z532EmpReducc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z46PaiCod", GXutil.ltrim( localUtil.ntoc( Z46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z47ProvCod", GXutil.ltrim( localUtil.ntoc( Z47ProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z48LocCod", GXutil.ltrim( localUtil.ntoc( Z48LocCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z43ActCodigo", GXutil.rtrim( Z43ActCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z45TipEmpleCod", GXutil.rtrim( Z45TipEmpleCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z44EmpZonCod", GXutil.rtrim( Z44EmpZonCod));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N46PaiCod", GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N47ProvCod", GXutil.ltrim( localUtil.ntoc( A47ProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N48LocCod", GXutil.ltrim( localUtil.ntoc( A48LocCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N43ActCodigo", GXutil.rtrim( A43ActCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "N45TipEmpleCod", GXutil.rtrim( A45TipEmpleCod));
      web.GxWebStd.gx_hidden_field( httpContext, "N44EmpZonCod", GXutil.rtrim( A44EmpZonCod));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV17DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV17DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPAICOD_DATA", AV16PaiCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPAICOD_DATA", AV16PaiCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPROVCOD_DATA", AV22ProvCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPROVCOD_DATA", AV22ProvCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLOCCOD_DATA", AV25LocCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLOCCOD_DATA", AV25LocCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vACTCODIGO_DATA", AV28ActCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vACTCODIGO_DATA", AV28ActCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTIPEMPLECOD_DATA", AV41TipEmpleCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTIPEMPLECOD_DATA", AV41TipEmpleCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vEMPZONCOD_DATA", AV37EmpZonCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vEMPZONCOD_DATA", AV37EmpZonCod_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTRNCONTEXT", AV9TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTRNCONTEXT", AV9TrnContext);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNCONTEXT", getSecureSignedToken( "", AV9TrnContext));
      web.GxWebStd.gx_hidden_field( httpContext, "vCOND_PAICOD", GXutil.ltrim( localUtil.ntoc( AV24Cond_PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCOND_PROVCOD", GXutil.ltrim( localUtil.ntoc( AV27Cond_ProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV30CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV7EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_PAICOD", GXutil.ltrim( localUtil.ntoc( AV11Insert_PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_PROVCOD", GXutil.ltrim( localUtil.ntoc( AV12Insert_ProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_LOCCOD", GXutil.ltrim( localUtil.ntoc( AV13Insert_LocCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_ACTCODIGO", GXutil.rtrim( AV14Insert_ActCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_TIPEMPLECOD", GXutil.rtrim( AV40Insert_TipEmpleCod));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_EMPZONCOD", GXutil.rtrim( AV36Insert_EmpZonCod));
      web.GxWebStd.gx_hidden_field( httpContext, "PAINOM", A312PaiNom);
      web.GxWebStd.gx_hidden_field( httpContext, "PROVNOM", A322ProvNom);
      web.GxWebStd.gx_hidden_field( httpContext, "LOCNOM", A286LocNom);
      web.GxWebStd.gx_hidden_field( httpContext, "ACTDESCRIPSINAC", A683ActDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "ACTDESCRIP", A108ActDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV45Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Objectcall", GXutil.rtrim( Combo_paicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Cls", GXutil.rtrim( Combo_paicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Selectedvalue_set", GXutil.rtrim( Combo_paicod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Selectedtext_set", GXutil.rtrim( Combo_paicod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Enabled", GXutil.booltostr( Combo_paicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Datalistproc", GXutil.rtrim( Combo_paicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_paicod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROVCOD_Objectcall", GXutil.rtrim( Combo_provcod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROVCOD_Cls", GXutil.rtrim( Combo_provcod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROVCOD_Selectedvalue_set", GXutil.rtrim( Combo_provcod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROVCOD_Selectedtext_set", GXutil.rtrim( Combo_provcod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROVCOD_Enabled", GXutil.booltostr( Combo_provcod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROVCOD_Datalistproc", GXutil.rtrim( Combo_provcod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROVCOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_provcod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LOCCOD_Objectcall", GXutil.rtrim( Combo_loccod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LOCCOD_Cls", GXutil.rtrim( Combo_loccod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LOCCOD_Selectedvalue_set", GXutil.rtrim( Combo_loccod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LOCCOD_Selectedtext_set", GXutil.rtrim( Combo_loccod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LOCCOD_Enabled", GXutil.booltostr( Combo_loccod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LOCCOD_Datalistproc", GXutil.rtrim( Combo_loccod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LOCCOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_loccod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ACTCODIGO_Objectcall", GXutil.rtrim( Combo_actcodigo_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ACTCODIGO_Cls", GXutil.rtrim( Combo_actcodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ACTCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_actcodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ACTCODIGO_Selectedtext_set", GXutil.rtrim( Combo_actcodigo_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ACTCODIGO_Enabled", GXutil.booltostr( Combo_actcodigo_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ACTCODIGO_Datalistproc", GXutil.rtrim( Combo_actcodigo_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_ACTCODIGO_Datalistprocparametersprefix", GXutil.rtrim( Combo_actcodigo_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPEMPLECOD_Objectcall", GXutil.rtrim( Combo_tipemplecod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPEMPLECOD_Cls", GXutil.rtrim( Combo_tipemplecod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPEMPLECOD_Selectedvalue_set", GXutil.rtrim( Combo_tipemplecod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPEMPLECOD_Selectedtext_set", GXutil.rtrim( Combo_tipemplecod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPEMPLECOD_Enabled", GXutil.booltostr( Combo_tipemplecod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPEMPLECOD_Datalistproc", GXutil.rtrim( Combo_tipemplecod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_TIPEMPLECOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_tipemplecod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPZONCOD_Objectcall", GXutil.rtrim( Combo_empzoncod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPZONCOD_Cls", GXutil.rtrim( Combo_empzoncod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPZONCOD_Selectedvalue_set", GXutil.rtrim( Combo_empzoncod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPZONCOD_Selectedtext_set", GXutil.rtrim( Combo_empzoncod_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPZONCOD_Enabled", GXutil.booltostr( Combo_empzoncod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPZONCOD_Datalistproc", GXutil.rtrim( Combo_empzoncod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPZONCOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_empzoncod_Datalistprocparametersprefix));
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
      return formatLink("web.liqimportarauxtrn", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV30CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV7EmpCod,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod"})  ;
   }

   public String getPgmname( )
   {
      return "LiqImportarAuxTrn" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Liq Importar Aux Trn", "") ;
   }

   public void initializeNonKey2B13( )
   {
      A46PaiCod = (short)(0) ;
      n46PaiCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      n46PaiCod = ((0==A46PaiCod) ? true : false) ;
      A47ProvCod = (short)(0) ;
      n47ProvCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A47ProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47ProvCod), 4, 0));
      n47ProvCod = ((0==A47ProvCod) ? true : false) ;
      A48LocCod = (short)(0) ;
      n48LocCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A48LocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48LocCod), 4, 0));
      n48LocCod = ((0==A48LocCod) ? true : false) ;
      A43ActCodigo = "" ;
      n43ActCodigo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A43ActCodigo", A43ActCodigo);
      n43ActCodigo = ((GXutil.strcmp("", A43ActCodigo)==0) ? true : false) ;
      A45TipEmpleCod = "" ;
      n45TipEmpleCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A45TipEmpleCod", A45TipEmpleCod);
      n45TipEmpleCod = ((GXutil.strcmp("", A45TipEmpleCod)==0) ? true : false) ;
      A44EmpZonCod = "" ;
      n44EmpZonCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A44EmpZonCod", A44EmpZonCod);
      n44EmpZonCod = ((GXutil.strcmp("", A44EmpZonCod)==0) ? true : false) ;
      A683ActDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A683ActDescripSinAc", A683ActDescripSinAc);
      A2EmpNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2EmpNom", A2EmpNom);
      A177EmpCUIT = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A177EmpCUIT", GXutil.ltrimstr( DecimalUtil.doubleToDec(A177EmpCUIT), 11, 0));
      A125CatIvaCod = (short)(0) ;
      n125CatIvaCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A125CatIvaCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125CatIvaCod), 4, 0));
      n125CatIvaCod = ((0==A125CatIvaCod) ? true : false) ;
      A126CatIvaDesc = "" ;
      n126CatIvaDesc = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A126CatIvaDesc", A126CatIvaDesc);
      n126CatIvaDesc = ((GXutil.strcmp("", A126CatIvaDesc)==0) ? true : false) ;
      A178EmpDir = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A178EmpDir", A178EmpDir);
      A180EmpTel = "" ;
      n180EmpTel = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A180EmpTel", A180EmpTel);
      n180EmpTel = ((GXutil.strcmp("", A180EmpTel)==0) ? true : false) ;
      A176EmpCP = "" ;
      n176EmpCP = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A176EmpCP", A176EmpCP);
      n176EmpCP = ((GXutil.strcmp("", A176EmpCP)==0) ? true : false) ;
      A312PaiNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A312PaiNom", A312PaiNom);
      A322ProvNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A322ProvNom", A322ProvNom);
      A286LocNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A286LocNom", A286LocNom);
      A108ActDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A108ActDescrip", A108ActDescrip);
      A518EmpZonDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A518EmpZonDescrip", A518EmpZonDescrip);
      A532EmpReducc = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A532EmpReducc", A532EmpReducc);
      A530TipEmpleDefIns = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A530TipEmpleDefIns", A530TipEmpleDefIns);
      Z2EmpNom = "" ;
      Z177EmpCUIT = 0 ;
      Z125CatIvaCod = (short)(0) ;
      Z126CatIvaDesc = "" ;
      Z178EmpDir = "" ;
      Z180EmpTel = "" ;
      Z176EmpCP = "" ;
      Z532EmpReducc = false ;
      Z46PaiCod = (short)(0) ;
      Z47ProvCod = (short)(0) ;
      Z48LocCod = (short)(0) ;
      Z43ActCodigo = "" ;
      Z45TipEmpleCod = "" ;
      Z44EmpZonCod = "" ;
   }

   public void initAll2B13( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      initializeNonKey2B13( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251817524756", true, true);
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
      httpContext.AddJavascriptSource("liqimportarauxtrn.js", "?20251817524757", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtEmpNom_Internalname = "EMPNOM" ;
      edtEmpCUIT_Internalname = "EMPCUIT" ;
      edtCatIvaCod_Internalname = "CATIVACOD" ;
      edtCatIvaDesc_Internalname = "CATIVADESC" ;
      edtEmpDir_Internalname = "EMPDIR" ;
      edtEmpTel_Internalname = "EMPTEL" ;
      edtEmpCP_Internalname = "EMPCP" ;
      lblTextblockpaicod_Internalname = "TEXTBLOCKPAICOD" ;
      Combo_paicod_Internalname = "COMBO_PAICOD" ;
      edtPaiCod_Internalname = "PAICOD" ;
      divTablesplittedpaicod_Internalname = "TABLESPLITTEDPAICOD" ;
      lblTextblockprovcod_Internalname = "TEXTBLOCKPROVCOD" ;
      Combo_provcod_Internalname = "COMBO_PROVCOD" ;
      edtProvCod_Internalname = "PROVCOD" ;
      divTablesplittedprovcod_Internalname = "TABLESPLITTEDPROVCOD" ;
      lblTextblockloccod_Internalname = "TEXTBLOCKLOCCOD" ;
      Combo_loccod_Internalname = "COMBO_LOCCOD" ;
      edtLocCod_Internalname = "LOCCOD" ;
      divTablesplittedloccod_Internalname = "TABLESPLITTEDLOCCOD" ;
      lblTextblockactcodigo_Internalname = "TEXTBLOCKACTCODIGO" ;
      Combo_actcodigo_Internalname = "COMBO_ACTCODIGO" ;
      edtActCodigo_Internalname = "ACTCODIGO" ;
      divTablesplittedactcodigo_Internalname = "TABLESPLITTEDACTCODIGO" ;
      lblTextblocktipemplecod_Internalname = "TEXTBLOCKTIPEMPLECOD" ;
      Combo_tipemplecod_Internalname = "COMBO_TIPEMPLECOD" ;
      edtTipEmpleCod_Internalname = "TIPEMPLECOD" ;
      divTablesplittedtipemplecod_Internalname = "TABLESPLITTEDTIPEMPLECOD" ;
      lblTextblockempzoncod_Internalname = "TEXTBLOCKEMPZONCOD" ;
      Combo_empzoncod_Internalname = "COMBO_EMPZONCOD" ;
      edtEmpZonCod_Internalname = "EMPZONCOD" ;
      divTablesplittedempzoncod_Internalname = "TABLESPLITTEDEMPZONCOD" ;
      edtEmpZonDescrip_Internalname = "EMPZONDESCRIP" ;
      chkEmpReducc.setInternalname( "EMPREDUCC" );
      cmbTipEmpleDefIns.setInternalname( "TIPEMPLEDEFINS" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombopaicod_Internalname = "vCOMBOPAICOD" ;
      divSectionattribute_paicod_Internalname = "SECTIONATTRIBUTE_PAICOD" ;
      edtavComboprovcod_Internalname = "vCOMBOPROVCOD" ;
      divSectionattribute_provcod_Internalname = "SECTIONATTRIBUTE_PROVCOD" ;
      edtavComboloccod_Internalname = "vCOMBOLOCCOD" ;
      divSectionattribute_loccod_Internalname = "SECTIONATTRIBUTE_LOCCOD" ;
      edtavComboactcodigo_Internalname = "vCOMBOACTCODIGO" ;
      divSectionattribute_actcodigo_Internalname = "SECTIONATTRIBUTE_ACTCODIGO" ;
      edtavCombotipemplecod_Internalname = "vCOMBOTIPEMPLECOD" ;
      divSectionattribute_tipemplecod_Internalname = "SECTIONATTRIBUTE_TIPEMPLECOD" ;
      edtavComboempzoncod_Internalname = "vCOMBOEMPZONCOD" ;
      divSectionattribute_empzoncod_Internalname = "SECTIONATTRIBUTE_EMPZONCOD" ;
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
      Form.setCaption( httpContext.getMessage( "Liq Importar Aux Trn", "") );
      Combo_provcod_Datalistprocparametersprefix = "" ;
      Combo_loccod_Datalistprocparametersprefix = "" ;
      edtavComboempzoncod_Jsonclick = "" ;
      edtavComboempzoncod_Enabled = 0 ;
      edtavComboempzoncod_Visible = 1 ;
      edtavCombotipemplecod_Jsonclick = "" ;
      edtavCombotipemplecod_Enabled = 0 ;
      edtavCombotipemplecod_Visible = 1 ;
      edtavComboactcodigo_Jsonclick = "" ;
      edtavComboactcodigo_Enabled = 0 ;
      edtavComboactcodigo_Visible = 1 ;
      edtavComboloccod_Jsonclick = "" ;
      edtavComboloccod_Enabled = 0 ;
      edtavComboloccod_Visible = 1 ;
      edtavComboprovcod_Jsonclick = "" ;
      edtavComboprovcod_Enabled = 0 ;
      edtavComboprovcod_Visible = 1 ;
      edtavCombopaicod_Jsonclick = "" ;
      edtavCombopaicod_Enabled = 0 ;
      edtavCombopaicod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbTipEmpleDefIns.setJsonclick( "" );
      cmbTipEmpleDefIns.setEnabled( 0 );
      chkEmpReducc.setEnabled( 1 );
      edtEmpZonDescrip_Enabled = 0 ;
      edtEmpZonCod_Jsonclick = "" ;
      edtEmpZonCod_Enabled = 1 ;
      edtEmpZonCod_Visible = 1 ;
      Combo_empzoncod_Datalistprocparametersprefix = " \"ComboName\": \"EmpZonCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"EmpCod\": 0" ;
      Combo_empzoncod_Datalistproc = "LiqImportarAuxTrnLoadDVCombo" ;
      Combo_empzoncod_Cls = "ExtendedCombo Attribute" ;
      Combo_empzoncod_Caption = "" ;
      Combo_empzoncod_Enabled = GXutil.toBoolean( -1) ;
      edtTipEmpleCod_Jsonclick = "" ;
      edtTipEmpleCod_Enabled = 1 ;
      edtTipEmpleCod_Visible = 1 ;
      Combo_tipemplecod_Datalistprocparametersprefix = " \"ComboName\": \"TipEmpleCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"EmpCod\": 0" ;
      Combo_tipemplecod_Datalistproc = "LiqImportarAuxTrnLoadDVCombo" ;
      Combo_tipemplecod_Cls = "ExtendedCombo Attribute" ;
      Combo_tipemplecod_Caption = "" ;
      Combo_tipemplecod_Enabled = GXutil.toBoolean( -1) ;
      edtActCodigo_Jsonclick = "" ;
      edtActCodigo_Enabled = 1 ;
      edtActCodigo_Visible = 1 ;
      Combo_actcodigo_Datalistprocparametersprefix = " \"ComboName\": \"ActCodigo\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"EmpCod\": 0" ;
      Combo_actcodigo_Datalistproc = "LiqImportarAuxTrnLoadDVCombo" ;
      Combo_actcodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_actcodigo_Caption = "" ;
      Combo_actcodigo_Enabled = GXutil.toBoolean( -1) ;
      edtLocCod_Jsonclick = "" ;
      edtLocCod_Enabled = 1 ;
      edtLocCod_Visible = 1 ;
      Combo_loccod_Datalistproc = "LiqImportarAuxTrnLoadDVCombo" ;
      Combo_loccod_Cls = "ExtendedCombo Attribute" ;
      Combo_loccod_Caption = "" ;
      Combo_loccod_Enabled = GXutil.toBoolean( -1) ;
      edtProvCod_Jsonclick = "" ;
      edtProvCod_Enabled = 1 ;
      edtProvCod_Visible = 1 ;
      Combo_provcod_Datalistproc = "LiqImportarAuxTrnLoadDVCombo" ;
      Combo_provcod_Cls = "ExtendedCombo Attribute" ;
      Combo_provcod_Caption = "" ;
      Combo_provcod_Enabled = GXutil.toBoolean( -1) ;
      edtPaiCod_Jsonclick = "" ;
      edtPaiCod_Enabled = 1 ;
      edtPaiCod_Visible = 1 ;
      Combo_paicod_Datalistprocparametersprefix = " \"ComboName\": \"PaiCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"EmpCod\": 0" ;
      Combo_paicod_Datalistproc = "LiqImportarAuxTrnLoadDVCombo" ;
      Combo_paicod_Cls = "ExtendedCombo Attribute" ;
      Combo_paicod_Caption = "" ;
      Combo_paicod_Enabled = GXutil.toBoolean( -1) ;
      edtEmpCP_Jsonclick = "" ;
      edtEmpCP_Enabled = 1 ;
      edtEmpTel_Jsonclick = "" ;
      edtEmpTel_Enabled = 1 ;
      edtEmpDir_Jsonclick = "" ;
      edtEmpDir_Enabled = 1 ;
      edtCatIvaDesc_Jsonclick = "" ;
      edtCatIvaDesc_Enabled = 1 ;
      edtCatIvaCod_Jsonclick = "" ;
      edtCatIvaCod_Enabled = 1 ;
      edtEmpCUIT_Jsonclick = "" ;
      edtEmpCUIT_Enabled = 1 ;
      edtEmpNom_Jsonclick = "" ;
      edtEmpNom_Enabled = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
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

   public void gx5asaempcod2B13( short AV7EmpCod )
   {
      if ( ! (0==AV7EmpCod) )
      {
         A1EmpCod = AV7EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx6asaempcod2B13( int A3CliCod )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int12 = A1EmpCod ;
         GXv_int13[0] = GXt_int12 ;
         new web.getnextemp(remoteHandle, context).execute( A3CliCod, GXv_int13) ;
         liqimportarauxtrn_impl.this.GXt_int12 = GXv_int13[0] ;
         A1EmpCod = GXt_int12 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), ".", "")))+"\"") ;
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
      chkEmpReducc.setName( "EMPREDUCC" );
      chkEmpReducc.setWebtags( "" );
      chkEmpReducc.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpReducc.getInternalname(), "TitleCaption", chkEmpReducc.getCaption(), true);
      chkEmpReducc.setCheckedValue( "false" );
      A532EmpReducc = GXutil.strtobool( GXutil.booltostr( A532EmpReducc)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A532EmpReducc", A532EmpReducc);
      cmbTipEmpleDefIns.setName( "TIPEMPLEDEFINS" );
      cmbTipEmpleDefIns.setWebtags( "" );
      cmbTipEmpleDefIns.addItem("A", httpContext.getMessage( "Inciso A", ""), (short)(0));
      cmbTipEmpleDefIns.addItem("B", httpContext.getMessage( "Inciso B", ""), (short)(0));
      if ( cmbTipEmpleDefIns.getItemCount() > 0 )
      {
         A530TipEmpleDefIns = cmbTipEmpleDefIns.getValidValue(A530TipEmpleDefIns) ;
         httpContext.ajax_rsp_assign_attri("", false, "A530TipEmpleDefIns", A530TipEmpleDefIns);
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

   public void valid_Clicod( )
   {
      /* Using cursor T002B120 */
      pr_default.execute(118, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(118) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(118);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Paicod( )
   {
      n46PaiCod = false ;
      /* Using cursor T002B25 */
      pr_default.execute(23, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(23) == 101) )
      {
         if ( ! ( (0==A46PaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
         }
      }
      A312PaiNom = T002B25_A312PaiNom[0] ;
      pr_default.close(23);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A312PaiNom", A312PaiNom);
   }

   public void valid_Provcod( )
   {
      n46PaiCod = false ;
      n47ProvCod = false ;
      /* Using cursor T002B26 */
      pr_default.execute(24, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
      if ( (pr_default.getStatus(24) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (0==A47ProvCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Provincia", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PROVCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
         }
      }
      A322ProvNom = T002B26_A322ProvNom[0] ;
      pr_default.close(24);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A322ProvNom", A322ProvNom);
   }

   public void valid_Loccod( )
   {
      n46PaiCod = false ;
      n47ProvCod = false ;
      n48LocCod = false ;
      /* Using cursor T002B27 */
      pr_default.execute(25, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
      if ( (pr_default.getStatus(25) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (0==A47ProvCod) || (0==A48LocCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Localidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LOCCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
         }
      }
      A286LocNom = T002B27_A286LocNom[0] ;
      pr_default.close(25);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A286LocNom", A286LocNom);
   }

   public void valid_Actcodigo( )
   {
      n43ActCodigo = false ;
      /* Using cursor T002B28 */
      pr_default.execute(26, new Object[] {Boolean.valueOf(n43ActCodigo), A43ActCodigo});
      if ( (pr_default.getStatus(26) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A43ActCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Actividad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ACTCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtActCodigo_Internalname ;
         }
      }
      A683ActDescripSinAc = T002B28_A683ActDescripSinAc[0] ;
      A108ActDescrip = T002B28_A108ActDescrip[0] ;
      pr_default.close(26);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A683ActDescripSinAc", A683ActDescripSinAc);
      httpContext.ajax_rsp_assign_attri("", false, "A108ActDescrip", A108ActDescrip);
   }

   public void valid_Tipemplecod( )
   {
      n45TipEmpleCod = false ;
      A530TipEmpleDefIns = cmbTipEmpleDefIns.getValue() ;
      cmbTipEmpleDefIns.setValue( A530TipEmpleDefIns );
      /* Using cursor T002B29 */
      pr_default.execute(27, new Object[] {Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod});
      if ( (pr_default.getStatus(27) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A45TipEmpleCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Empleador", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPEMPLECOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtTipEmpleCod_Internalname ;
         }
      }
      A530TipEmpleDefIns = T002B29_A530TipEmpleDefIns[0] ;
      cmbTipEmpleDefIns.setValue( A530TipEmpleDefIns );
      pr_default.close(27);
      dynload_actions( ) ;
      if ( cmbTipEmpleDefIns.getItemCount() > 0 )
      {
         A530TipEmpleDefIns = cmbTipEmpleDefIns.getValidValue(A530TipEmpleDefIns) ;
         cmbTipEmpleDefIns.setValue( A530TipEmpleDefIns );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbTipEmpleDefIns.setValue( GXutil.rtrim( A530TipEmpleDefIns) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A530TipEmpleDefIns", GXutil.rtrim( A530TipEmpleDefIns));
      cmbTipEmpleDefIns.setValue( GXutil.rtrim( A530TipEmpleDefIns) );
      httpContext.ajax_rsp_assign_prop("", false, cmbTipEmpleDefIns.getInternalname(), "Values", cmbTipEmpleDefIns.ToJavascriptSource(), true);
   }

   public void valid_Empzoncod( )
   {
      n44EmpZonCod = false ;
      /* Using cursor T002B30 */
      pr_default.execute(28, new Object[] {Boolean.valueOf(n44EmpZonCod), A44EmpZonCod});
      if ( (pr_default.getStatus(28) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A44EmpZonCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Zona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPZONCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEmpZonCod_Internalname ;
         }
      }
      A518EmpZonDescrip = T002B30_A518EmpZonDescrip[0] ;
      pr_default.close(28);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A518EmpZonDescrip", A518EmpZonDescrip);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV30CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV7EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV30CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV7EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e122B2',iparms:[{av:'AV30CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]}");
      setEventMetadata("VALID_PAICOD","{handler:'valid_Paicod',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A312PaiNom',fld:'PAINOM',pic:'@!'},{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]");
      setEventMetadata("VALID_PAICOD",",oparms:[{av:'A312PaiNom',fld:'PAINOM',pic:'@!'},{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]}");
      setEventMetadata("VALID_PROVCOD","{handler:'valid_Provcod',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A47ProvCod',fld:'PROVCOD',pic:'ZZZ9'},{av:'A322ProvNom',fld:'PROVNOM',pic:''},{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]");
      setEventMetadata("VALID_PROVCOD",",oparms:[{av:'A322ProvNom',fld:'PROVNOM',pic:''},{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]}");
      setEventMetadata("VALID_LOCCOD","{handler:'valid_Loccod',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A47ProvCod',fld:'PROVCOD',pic:'ZZZ9'},{av:'A48LocCod',fld:'LOCCOD',pic:'ZZZ9'},{av:'A286LocNom',fld:'LOCNOM',pic:'@!'},{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]");
      setEventMetadata("VALID_LOCCOD",",oparms:[{av:'A286LocNom',fld:'LOCNOM',pic:'@!'},{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]}");
      setEventMetadata("VALID_ACTCODIGO","{handler:'valid_Actcodigo',iparms:[{av:'A43ActCodigo',fld:'ACTCODIGO',pic:''},{av:'A683ActDescripSinAc',fld:'ACTDESCRIPSINAC',pic:''},{av:'A108ActDescrip',fld:'ACTDESCRIP',pic:''},{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]");
      setEventMetadata("VALID_ACTCODIGO",",oparms:[{av:'A683ActDescripSinAc',fld:'ACTDESCRIPSINAC',pic:''},{av:'A108ActDescrip',fld:'ACTDESCRIP',pic:''},{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]}");
      setEventMetadata("VALID_TIPEMPLECOD","{handler:'valid_Tipemplecod',iparms:[{av:'A45TipEmpleCod',fld:'TIPEMPLECOD',pic:''},{av:'cmbTipEmpleDefIns'},{av:'A530TipEmpleDefIns',fld:'TIPEMPLEDEFINS',pic:''},{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]");
      setEventMetadata("VALID_TIPEMPLECOD",",oparms:[{av:'cmbTipEmpleDefIns'},{av:'A530TipEmpleDefIns',fld:'TIPEMPLEDEFINS',pic:''},{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]}");
      setEventMetadata("VALID_EMPZONCOD","{handler:'valid_Empzoncod',iparms:[{av:'A44EmpZonCod',fld:'EMPZONCOD',pic:''},{av:'A518EmpZonDescrip',fld:'EMPZONDESCRIP',pic:''},{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]");
      setEventMetadata("VALID_EMPZONCOD",",oparms:[{av:'A518EmpZonDescrip',fld:'EMPZONDESCRIP',pic:''},{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]}");
      setEventMetadata("VALIDV_COMBOPAICOD","{handler:'validv_Combopaicod',iparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]");
      setEventMetadata("VALIDV_COMBOPAICOD",",oparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]}");
      setEventMetadata("VALIDV_COMBOPROVCOD","{handler:'validv_Comboprovcod',iparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]");
      setEventMetadata("VALIDV_COMBOPROVCOD",",oparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]}");
      setEventMetadata("VALIDV_COMBOLOCCOD","{handler:'validv_Comboloccod',iparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]");
      setEventMetadata("VALIDV_COMBOLOCCOD",",oparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]}");
      setEventMetadata("VALIDV_COMBOACTCODIGO","{handler:'validv_Comboactcodigo',iparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]");
      setEventMetadata("VALIDV_COMBOACTCODIGO",",oparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]}");
      setEventMetadata("VALIDV_COMBOTIPEMPLECOD","{handler:'validv_Combotipemplecod',iparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]");
      setEventMetadata("VALIDV_COMBOTIPEMPLECOD",",oparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]}");
      setEventMetadata("VALIDV_COMBOEMPZONCOD","{handler:'validv_Comboempzoncod',iparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]");
      setEventMetadata("VALIDV_COMBOEMPZONCOD",",oparms:[{av:'A532EmpReducc',fld:'EMPREDUCC',pic:''}]}");
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
      return "empresa_Execute";
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
      pr_default.close(25);
      pr_default.close(23);
      pr_default.close(24);
      pr_default.close(118);
      pr_default.close(26);
      pr_default.close(27);
      pr_default.close(28);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z2EmpNom = "" ;
      Z126CatIvaDesc = "" ;
      Z178EmpDir = "" ;
      Z180EmpTel = "" ;
      Z176EmpCP = "" ;
      Z43ActCodigo = "" ;
      Z45TipEmpleCod = "" ;
      Z44EmpZonCod = "" ;
      N43ActCodigo = "" ;
      N45TipEmpleCod = "" ;
      N44EmpZonCod = "" ;
      Combo_empzoncod_Selectedvalue_get = "" ;
      Combo_tipemplecod_Selectedvalue_get = "" ;
      Combo_actcodigo_Selectedvalue_get = "" ;
      Combo_loccod_Selectedvalue_get = "" ;
      Combo_provcod_Selectedvalue_get = "" ;
      Combo_paicod_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A43ActCodigo = "" ;
      A45TipEmpleCod = "" ;
      A44EmpZonCod = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A530TipEmpleDefIns = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A2EmpNom = "" ;
      A126CatIvaDesc = "" ;
      A178EmpDir = "" ;
      A180EmpTel = "" ;
      A176EmpCP = "" ;
      lblTextblockpaicod_Jsonclick = "" ;
      ucCombo_paicod = new com.genexus.webpanels.GXUserControl();
      AV17DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV16PaiCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblockprovcod_Jsonclick = "" ;
      ucCombo_provcod = new com.genexus.webpanels.GXUserControl();
      AV22ProvCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblockloccod_Jsonclick = "" ;
      ucCombo_loccod = new com.genexus.webpanels.GXUserControl();
      AV25LocCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblockactcodigo_Jsonclick = "" ;
      ucCombo_actcodigo = new com.genexus.webpanels.GXUserControl();
      AV28ActCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblocktipemplecod_Jsonclick = "" ;
      ucCombo_tipemplecod = new com.genexus.webpanels.GXUserControl();
      AV41TipEmpleCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblockempzoncod_Jsonclick = "" ;
      ucCombo_empzoncod = new com.genexus.webpanels.GXUserControl();
      AV37EmpZonCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A518EmpZonDescrip = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV29ComboActCodigo = "" ;
      AV42ComboTipEmpleCod = "" ;
      AV38ComboEmpZonCod = "" ;
      AV14Insert_ActCodigo = "" ;
      AV40Insert_TipEmpleCod = "" ;
      AV36Insert_EmpZonCod = "" ;
      A312PaiNom = "" ;
      A322ProvNom = "" ;
      A286LocNom = "" ;
      A683ActDescripSinAc = "" ;
      A108ActDescrip = "" ;
      AV45Pgmname = "" ;
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
      Combo_provcod_Objectcall = "" ;
      Combo_provcod_Class = "" ;
      Combo_provcod_Icontype = "" ;
      Combo_provcod_Icon = "" ;
      Combo_provcod_Tooltip = "" ;
      Combo_provcod_Selectedvalue_set = "" ;
      Combo_provcod_Selectedtext_set = "" ;
      Combo_provcod_Selectedtext_get = "" ;
      Combo_provcod_Gamoauthtoken = "" ;
      Combo_provcod_Ddointernalname = "" ;
      Combo_provcod_Titlecontrolalign = "" ;
      Combo_provcod_Dropdownoptionstype = "" ;
      Combo_provcod_Titlecontrolidtoreplace = "" ;
      Combo_provcod_Datalisttype = "" ;
      Combo_provcod_Datalistfixedvalues = "" ;
      Combo_provcod_Remoteservicesparameters = "" ;
      Combo_provcod_Htmltemplate = "" ;
      Combo_provcod_Multiplevaluestype = "" ;
      Combo_provcod_Loadingdata = "" ;
      Combo_provcod_Noresultsfound = "" ;
      Combo_provcod_Emptyitemtext = "" ;
      Combo_provcod_Onlyselectedvalues = "" ;
      Combo_provcod_Selectalltext = "" ;
      Combo_provcod_Multiplevaluesseparator = "" ;
      Combo_provcod_Addnewoptiontext = "" ;
      Combo_loccod_Objectcall = "" ;
      Combo_loccod_Class = "" ;
      Combo_loccod_Icontype = "" ;
      Combo_loccod_Icon = "" ;
      Combo_loccod_Tooltip = "" ;
      Combo_loccod_Selectedvalue_set = "" ;
      Combo_loccod_Selectedtext_set = "" ;
      Combo_loccod_Selectedtext_get = "" ;
      Combo_loccod_Gamoauthtoken = "" ;
      Combo_loccod_Ddointernalname = "" ;
      Combo_loccod_Titlecontrolalign = "" ;
      Combo_loccod_Dropdownoptionstype = "" ;
      Combo_loccod_Titlecontrolidtoreplace = "" ;
      Combo_loccod_Datalisttype = "" ;
      Combo_loccod_Datalistfixedvalues = "" ;
      Combo_loccod_Remoteservicesparameters = "" ;
      Combo_loccod_Htmltemplate = "" ;
      Combo_loccod_Multiplevaluestype = "" ;
      Combo_loccod_Loadingdata = "" ;
      Combo_loccod_Noresultsfound = "" ;
      Combo_loccod_Emptyitemtext = "" ;
      Combo_loccod_Onlyselectedvalues = "" ;
      Combo_loccod_Selectalltext = "" ;
      Combo_loccod_Multiplevaluesseparator = "" ;
      Combo_loccod_Addnewoptiontext = "" ;
      Combo_actcodigo_Objectcall = "" ;
      Combo_actcodigo_Class = "" ;
      Combo_actcodigo_Icontype = "" ;
      Combo_actcodigo_Icon = "" ;
      Combo_actcodigo_Tooltip = "" ;
      Combo_actcodigo_Selectedvalue_set = "" ;
      Combo_actcodigo_Selectedtext_set = "" ;
      Combo_actcodigo_Selectedtext_get = "" ;
      Combo_actcodigo_Gamoauthtoken = "" ;
      Combo_actcodigo_Ddointernalname = "" ;
      Combo_actcodigo_Titlecontrolalign = "" ;
      Combo_actcodigo_Dropdownoptionstype = "" ;
      Combo_actcodigo_Titlecontrolidtoreplace = "" ;
      Combo_actcodigo_Datalisttype = "" ;
      Combo_actcodigo_Datalistfixedvalues = "" ;
      Combo_actcodigo_Remoteservicesparameters = "" ;
      Combo_actcodigo_Htmltemplate = "" ;
      Combo_actcodigo_Multiplevaluestype = "" ;
      Combo_actcodigo_Loadingdata = "" ;
      Combo_actcodigo_Noresultsfound = "" ;
      Combo_actcodigo_Emptyitemtext = "" ;
      Combo_actcodigo_Onlyselectedvalues = "" ;
      Combo_actcodigo_Selectalltext = "" ;
      Combo_actcodigo_Multiplevaluesseparator = "" ;
      Combo_actcodigo_Addnewoptiontext = "" ;
      Combo_tipemplecod_Objectcall = "" ;
      Combo_tipemplecod_Class = "" ;
      Combo_tipemplecod_Icontype = "" ;
      Combo_tipemplecod_Icon = "" ;
      Combo_tipemplecod_Tooltip = "" ;
      Combo_tipemplecod_Selectedvalue_set = "" ;
      Combo_tipemplecod_Selectedtext_set = "" ;
      Combo_tipemplecod_Selectedtext_get = "" ;
      Combo_tipemplecod_Gamoauthtoken = "" ;
      Combo_tipemplecod_Ddointernalname = "" ;
      Combo_tipemplecod_Titlecontrolalign = "" ;
      Combo_tipemplecod_Dropdownoptionstype = "" ;
      Combo_tipemplecod_Titlecontrolidtoreplace = "" ;
      Combo_tipemplecod_Datalisttype = "" ;
      Combo_tipemplecod_Datalistfixedvalues = "" ;
      Combo_tipemplecod_Remoteservicesparameters = "" ;
      Combo_tipemplecod_Htmltemplate = "" ;
      Combo_tipemplecod_Multiplevaluestype = "" ;
      Combo_tipemplecod_Loadingdata = "" ;
      Combo_tipemplecod_Noresultsfound = "" ;
      Combo_tipemplecod_Emptyitemtext = "" ;
      Combo_tipemplecod_Onlyselectedvalues = "" ;
      Combo_tipemplecod_Selectalltext = "" ;
      Combo_tipemplecod_Multiplevaluesseparator = "" ;
      Combo_tipemplecod_Addnewoptiontext = "" ;
      Combo_empzoncod_Objectcall = "" ;
      Combo_empzoncod_Class = "" ;
      Combo_empzoncod_Icontype = "" ;
      Combo_empzoncod_Icon = "" ;
      Combo_empzoncod_Tooltip = "" ;
      Combo_empzoncod_Selectedvalue_set = "" ;
      Combo_empzoncod_Selectedtext_set = "" ;
      Combo_empzoncod_Selectedtext_get = "" ;
      Combo_empzoncod_Gamoauthtoken = "" ;
      Combo_empzoncod_Ddointernalname = "" ;
      Combo_empzoncod_Titlecontrolalign = "" ;
      Combo_empzoncod_Dropdownoptionstype = "" ;
      Combo_empzoncod_Titlecontrolidtoreplace = "" ;
      Combo_empzoncod_Datalisttype = "" ;
      Combo_empzoncod_Datalistfixedvalues = "" ;
      Combo_empzoncod_Remoteservicesparameters = "" ;
      Combo_empzoncod_Htmltemplate = "" ;
      Combo_empzoncod_Multiplevaluestype = "" ;
      Combo_empzoncod_Loadingdata = "" ;
      Combo_empzoncod_Noresultsfound = "" ;
      Combo_empzoncod_Emptyitemtext = "" ;
      Combo_empzoncod_Onlyselectedvalues = "" ;
      Combo_empzoncod_Selectalltext = "" ;
      Combo_empzoncod_Multiplevaluesseparator = "" ;
      Combo_empzoncod_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode13 = "" ;
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
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      AV15TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV20Combo_DataJson = "" ;
      AV18ComboSelectedValue = "" ;
      AV19ComboSelectedText = "" ;
      GXv_int10 = new long[1] ;
      AV33Date = GXutil.nullDate() ;
      GXv_date11 = new java.util.Date[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV35Session = httpContext.getWebSession();
      GXEncryptionTmp = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z312PaiNom = "" ;
      Z322ProvNom = "" ;
      Z286LocNom = "" ;
      Z683ActDescripSinAc = "" ;
      Z108ActDescrip = "" ;
      Z530TipEmpleDefIns = "" ;
      Z518EmpZonDescrip = "" ;
      T002B4_A312PaiNom = new String[] {""} ;
      T002B5_A322ProvNom = new String[] {""} ;
      T002B6_A286LocNom = new String[] {""} ;
      T002B8_A683ActDescripSinAc = new String[] {""} ;
      T002B8_A108ActDescrip = new String[] {""} ;
      T002B9_A530TipEmpleDefIns = new String[] {""} ;
      T002B10_A518EmpZonDescrip = new String[] {""} ;
      T002B11_A683ActDescripSinAc = new String[] {""} ;
      T002B11_A1EmpCod = new short[1] ;
      T002B11_A2EmpNom = new String[] {""} ;
      T002B11_A177EmpCUIT = new long[1] ;
      T002B11_A125CatIvaCod = new short[1] ;
      T002B11_n125CatIvaCod = new boolean[] {false} ;
      T002B11_A126CatIvaDesc = new String[] {""} ;
      T002B11_n126CatIvaDesc = new boolean[] {false} ;
      T002B11_A178EmpDir = new String[] {""} ;
      T002B11_A180EmpTel = new String[] {""} ;
      T002B11_n180EmpTel = new boolean[] {false} ;
      T002B11_A176EmpCP = new String[] {""} ;
      T002B11_n176EmpCP = new boolean[] {false} ;
      T002B11_A312PaiNom = new String[] {""} ;
      T002B11_A322ProvNom = new String[] {""} ;
      T002B11_A286LocNom = new String[] {""} ;
      T002B11_A108ActDescrip = new String[] {""} ;
      T002B11_A518EmpZonDescrip = new String[] {""} ;
      T002B11_A532EmpReducc = new boolean[] {false} ;
      T002B11_A530TipEmpleDefIns = new String[] {""} ;
      T002B11_A46PaiCod = new short[1] ;
      T002B11_n46PaiCod = new boolean[] {false} ;
      T002B11_A47ProvCod = new short[1] ;
      T002B11_n47ProvCod = new boolean[] {false} ;
      T002B11_A48LocCod = new short[1] ;
      T002B11_n48LocCod = new boolean[] {false} ;
      T002B11_A3CliCod = new int[1] ;
      T002B11_A43ActCodigo = new String[] {""} ;
      T002B11_n43ActCodigo = new boolean[] {false} ;
      T002B11_A45TipEmpleCod = new String[] {""} ;
      T002B11_n45TipEmpleCod = new boolean[] {false} ;
      T002B11_A44EmpZonCod = new String[] {""} ;
      T002B11_n44EmpZonCod = new boolean[] {false} ;
      T002B7_A3CliCod = new int[1] ;
      T002B12_A3CliCod = new int[1] ;
      T002B13_A312PaiNom = new String[] {""} ;
      T002B14_A322ProvNom = new String[] {""} ;
      T002B15_A286LocNom = new String[] {""} ;
      T002B16_A683ActDescripSinAc = new String[] {""} ;
      T002B16_A108ActDescrip = new String[] {""} ;
      T002B17_A530TipEmpleDefIns = new String[] {""} ;
      T002B18_A518EmpZonDescrip = new String[] {""} ;
      T002B19_A3CliCod = new int[1] ;
      T002B19_A1EmpCod = new short[1] ;
      T002B3_A1EmpCod = new short[1] ;
      T002B3_A2EmpNom = new String[] {""} ;
      T002B3_A177EmpCUIT = new long[1] ;
      T002B3_A125CatIvaCod = new short[1] ;
      T002B3_n125CatIvaCod = new boolean[] {false} ;
      T002B3_A126CatIvaDesc = new String[] {""} ;
      T002B3_n126CatIvaDesc = new boolean[] {false} ;
      T002B3_A178EmpDir = new String[] {""} ;
      T002B3_A180EmpTel = new String[] {""} ;
      T002B3_n180EmpTel = new boolean[] {false} ;
      T002B3_A176EmpCP = new String[] {""} ;
      T002B3_n176EmpCP = new boolean[] {false} ;
      T002B3_A532EmpReducc = new boolean[] {false} ;
      T002B3_A46PaiCod = new short[1] ;
      T002B3_n46PaiCod = new boolean[] {false} ;
      T002B3_A47ProvCod = new short[1] ;
      T002B3_n47ProvCod = new boolean[] {false} ;
      T002B3_A48LocCod = new short[1] ;
      T002B3_n48LocCod = new boolean[] {false} ;
      T002B3_A3CliCod = new int[1] ;
      T002B3_A43ActCodigo = new String[] {""} ;
      T002B3_n43ActCodigo = new boolean[] {false} ;
      T002B3_A45TipEmpleCod = new String[] {""} ;
      T002B3_n45TipEmpleCod = new boolean[] {false} ;
      T002B3_A44EmpZonCod = new String[] {""} ;
      T002B3_n44EmpZonCod = new boolean[] {false} ;
      T002B20_A1EmpCod = new short[1] ;
      T002B20_A3CliCod = new int[1] ;
      T002B21_A1EmpCod = new short[1] ;
      T002B21_A3CliCod = new int[1] ;
      T002B2_A1EmpCod = new short[1] ;
      T002B2_A2EmpNom = new String[] {""} ;
      T002B2_A177EmpCUIT = new long[1] ;
      T002B2_A125CatIvaCod = new short[1] ;
      T002B2_n125CatIvaCod = new boolean[] {false} ;
      T002B2_A126CatIvaDesc = new String[] {""} ;
      T002B2_n126CatIvaDesc = new boolean[] {false} ;
      T002B2_A178EmpDir = new String[] {""} ;
      T002B2_A180EmpTel = new String[] {""} ;
      T002B2_n180EmpTel = new boolean[] {false} ;
      T002B2_A176EmpCP = new String[] {""} ;
      T002B2_n176EmpCP = new boolean[] {false} ;
      T002B2_A532EmpReducc = new boolean[] {false} ;
      T002B2_A46PaiCod = new short[1] ;
      T002B2_n46PaiCod = new boolean[] {false} ;
      T002B2_A47ProvCod = new short[1] ;
      T002B2_n47ProvCod = new boolean[] {false} ;
      T002B2_A48LocCod = new short[1] ;
      T002B2_n48LocCod = new boolean[] {false} ;
      T002B2_A3CliCod = new int[1] ;
      T002B2_A43ActCodigo = new String[] {""} ;
      T002B2_n43ActCodigo = new boolean[] {false} ;
      T002B2_A45TipEmpleCod = new String[] {""} ;
      T002B2_n45TipEmpleCod = new boolean[] {false} ;
      T002B2_A44EmpZonCod = new String[] {""} ;
      T002B2_n44EmpZonCod = new boolean[] {false} ;
      T002B25_A312PaiNom = new String[] {""} ;
      T002B26_A322ProvNom = new String[] {""} ;
      T002B27_A286LocNom = new String[] {""} ;
      T002B28_A683ActDescripSinAc = new String[] {""} ;
      T002B28_A108ActDescrip = new String[] {""} ;
      T002B29_A530TipEmpleDefIns = new String[] {""} ;
      T002B30_A518EmpZonDescrip = new String[] {""} ;
      T002B31_A3CliCod = new int[1] ;
      T002B31_A1EmpCod = new short[1] ;
      T002B31_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T002B32_A3CliCod = new int[1] ;
      T002B32_A1EmpCod = new short[1] ;
      T002B32_A2380ColaUUID = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T002B33_A3CliCod = new int[1] ;
      T002B33_A1EmpCod = new short[1] ;
      T002B33_A2371LiqBatchLiqNro = new int[1] ;
      T002B33_A2372LiqBatchCod = new String[] {""} ;
      T002B33_A2373LiqBatchSeccion = new String[] {""} ;
      T002B34_A3CliCod = new int[1] ;
      T002B34_A1EmpCod = new short[1] ;
      T002B34_A2370LiqLoteLiqNro = new int[1] ;
      T002B34_A2269LiqLote = new String[] {""} ;
      T002B35_A3CliCod = new int[1] ;
      T002B35_A1EmpCod = new short[1] ;
      T002B35_A31LiqNro = new int[1] ;
      T002B35_A2285LinkLegNumero = new int[1] ;
      T002B35_A2277LegLinkTiporec = new String[] {""} ;
      T002B36_A3CliCod = new int[1] ;
      T002B36_A1EmpCod = new short[1] ;
      T002B36_A31LiqNro = new int[1] ;
      T002B36_A2183LiqSuc = new String[] {""} ;
      T002B37_A3CliCod = new int[1] ;
      T002B37_A1EmpCod = new short[1] ;
      T002B37_A31LiqNro = new int[1] ;
      T002B37_A2145LiqArea = new String[] {""} ;
      T002B38_A3CliCod = new int[1] ;
      T002B38_A1EmpCod = new short[1] ;
      T002B38_A31LiqNro = new int[1] ;
      T002B38_A2142LiqPaiConve = new short[1] ;
      T002B38_A2143LiqConvenio = new String[] {""} ;
      T002B39_A3CliCod = new int[1] ;
      T002B39_A1EmpCod = new short[1] ;
      T002B39_A1966EmpBanCod = new String[] {""} ;
      T002B40_A3CliCod = new int[1] ;
      T002B40_A1EmpCod = new short[1] ;
      T002B40_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      T002B41_A3CliCod = new int[1] ;
      T002B41_A1EmpCod = new short[1] ;
      T002B41_A1649LSDSec = new int[1] ;
      T002B42_A3CliCod = new int[1] ;
      T002B42_A1EmpCod = new short[1] ;
      T002B42_A1562EmpConvePai = new short[1] ;
      T002B42_A1561EmpConveCod = new String[] {""} ;
      T002B43_A3CliCod = new int[1] ;
      T002B43_A1EmpCod = new short[1] ;
      T002B43_A1562EmpConvePai = new short[1] ;
      T002B43_A1561EmpConveCod = new String[] {""} ;
      T002B44_A3CliCod = new int[1] ;
      T002B44_A1EmpCod = new short[1] ;
      T002B44_A1562EmpConvePai = new short[1] ;
      T002B44_A1561EmpConveCod = new String[] {""} ;
      T002B45_A3CliCod = new int[1] ;
      T002B45_A1EmpCod = new short[1] ;
      T002B45_A1562EmpConvePai = new short[1] ;
      T002B45_A1561EmpConveCod = new String[] {""} ;
      T002B46_A3CliCod = new int[1] ;
      T002B46_A1EmpCod = new short[1] ;
      T002B46_A1562EmpConvePai = new short[1] ;
      T002B46_A1561EmpConveCod = new String[] {""} ;
      T002B47_A3CliCod = new int[1] ;
      T002B47_A1EmpCod = new short[1] ;
      T002B47_A1562EmpConvePai = new short[1] ;
      T002B47_A1561EmpConveCod = new String[] {""} ;
      T002B48_A3CliCod = new int[1] ;
      T002B48_A1EmpCod = new short[1] ;
      T002B48_A1562EmpConvePai = new short[1] ;
      T002B48_A1561EmpConveCod = new String[] {""} ;
      T002B49_A3CliCod = new int[1] ;
      T002B49_A1EmpCod = new short[1] ;
      T002B49_A1562EmpConvePai = new short[1] ;
      T002B49_A1561EmpConveCod = new String[] {""} ;
      T002B50_A3CliCod = new int[1] ;
      T002B50_A1EmpCod = new short[1] ;
      T002B50_A1562EmpConvePai = new short[1] ;
      T002B50_A1561EmpConveCod = new String[] {""} ;
      T002B51_A3CliCod = new int[1] ;
      T002B51_A1EmpCod = new short[1] ;
      T002B51_A1562EmpConvePai = new short[1] ;
      T002B51_A1561EmpConveCod = new String[] {""} ;
      T002B52_A3CliCod = new int[1] ;
      T002B52_A1EmpCod = new short[1] ;
      T002B52_A1562EmpConvePai = new short[1] ;
      T002B52_A1561EmpConveCod = new String[] {""} ;
      T002B53_A3CliCod = new int[1] ;
      T002B53_A1EmpCod = new short[1] ;
      T002B53_A1562EmpConvePai = new short[1] ;
      T002B53_A1561EmpConveCod = new String[] {""} ;
      T002B54_A3CliCod = new int[1] ;
      T002B54_A1EmpCod = new short[1] ;
      T002B54_A1562EmpConvePai = new short[1] ;
      T002B54_A1561EmpConveCod = new String[] {""} ;
      T002B55_A3CliCod = new int[1] ;
      T002B55_A1EmpCod = new short[1] ;
      T002B55_A1562EmpConvePai = new short[1] ;
      T002B55_A1561EmpConveCod = new String[] {""} ;
      T002B56_A3CliCod = new int[1] ;
      T002B56_A1EmpCod = new short[1] ;
      T002B56_A1562EmpConvePai = new short[1] ;
      T002B56_A1561EmpConveCod = new String[] {""} ;
      T002B57_A3CliCod = new int[1] ;
      T002B57_A1EmpCod = new short[1] ;
      T002B57_A1562EmpConvePai = new short[1] ;
      T002B57_A1561EmpConveCod = new String[] {""} ;
      T002B58_A3CliCod = new int[1] ;
      T002B58_A1EmpCod = new short[1] ;
      T002B58_A1562EmpConvePai = new short[1] ;
      T002B58_A1561EmpConveCod = new String[] {""} ;
      T002B59_A3CliCod = new int[1] ;
      T002B59_A1EmpCod = new short[1] ;
      T002B59_A1562EmpConvePai = new short[1] ;
      T002B59_A1561EmpConveCod = new String[] {""} ;
      T002B60_A3CliCod = new int[1] ;
      T002B60_A1EmpCod = new short[1] ;
      T002B60_A1562EmpConvePai = new short[1] ;
      T002B60_A1561EmpConveCod = new String[] {""} ;
      T002B61_A3CliCod = new int[1] ;
      T002B61_A1EmpCod = new short[1] ;
      T002B61_A1562EmpConvePai = new short[1] ;
      T002B61_A1561EmpConveCod = new String[] {""} ;
      T002B62_A3CliCod = new int[1] ;
      T002B62_A1EmpCod = new short[1] ;
      T002B62_A1562EmpConvePai = new short[1] ;
      T002B62_A1561EmpConveCod = new String[] {""} ;
      T002B63_A3CliCod = new int[1] ;
      T002B63_A1EmpCod = new short[1] ;
      T002B63_A1562EmpConvePai = new short[1] ;
      T002B63_A1561EmpConveCod = new String[] {""} ;
      T002B64_A3CliCod = new int[1] ;
      T002B64_A1EmpCod = new short[1] ;
      T002B64_A1562EmpConvePai = new short[1] ;
      T002B64_A1561EmpConveCod = new String[] {""} ;
      T002B65_A3CliCod = new int[1] ;
      T002B65_A1EmpCod = new short[1] ;
      T002B65_A1562EmpConvePai = new short[1] ;
      T002B65_A1561EmpConveCod = new String[] {""} ;
      T002B66_A3CliCod = new int[1] ;
      T002B66_A1EmpCod = new short[1] ;
      T002B66_A1562EmpConvePai = new short[1] ;
      T002B66_A1561EmpConveCod = new String[] {""} ;
      T002B67_A3CliCod = new int[1] ;
      T002B67_A1EmpCod = new short[1] ;
      T002B67_A1562EmpConvePai = new short[1] ;
      T002B67_A1561EmpConveCod = new String[] {""} ;
      T002B68_A3CliCod = new int[1] ;
      T002B68_A1EmpCod = new short[1] ;
      T002B68_A1562EmpConvePai = new short[1] ;
      T002B68_A1561EmpConveCod = new String[] {""} ;
      T002B69_A3CliCod = new int[1] ;
      T002B69_A1EmpCod = new short[1] ;
      T002B69_A1562EmpConvePai = new short[1] ;
      T002B69_A1561EmpConveCod = new String[] {""} ;
      T002B70_A3CliCod = new int[1] ;
      T002B70_A1EmpCod = new short[1] ;
      T002B70_A1562EmpConvePai = new short[1] ;
      T002B70_A1561EmpConveCod = new String[] {""} ;
      T002B71_A3CliCod = new int[1] ;
      T002B71_A1EmpCod = new short[1] ;
      T002B71_A1562EmpConvePai = new short[1] ;
      T002B71_A1561EmpConveCod = new String[] {""} ;
      T002B72_A3CliCod = new int[1] ;
      T002B72_A1EmpCod = new short[1] ;
      T002B72_A1562EmpConvePai = new short[1] ;
      T002B72_A1561EmpConveCod = new String[] {""} ;
      T002B73_A3CliCod = new int[1] ;
      T002B73_A1EmpCod = new short[1] ;
      T002B73_A1562EmpConvePai = new short[1] ;
      T002B73_A1561EmpConveCod = new String[] {""} ;
      T002B74_A3CliCod = new int[1] ;
      T002B74_A1EmpCod = new short[1] ;
      T002B74_A1562EmpConvePai = new short[1] ;
      T002B74_A1561EmpConveCod = new String[] {""} ;
      T002B75_A3CliCod = new int[1] ;
      T002B75_A1EmpCod = new short[1] ;
      T002B75_A1562EmpConvePai = new short[1] ;
      T002B75_A1561EmpConveCod = new String[] {""} ;
      T002B76_A3CliCod = new int[1] ;
      T002B76_A1EmpCod = new short[1] ;
      T002B76_A1562EmpConvePai = new short[1] ;
      T002B76_A1561EmpConveCod = new String[] {""} ;
      T002B77_A3CliCod = new int[1] ;
      T002B77_A1EmpCod = new short[1] ;
      T002B77_A1562EmpConvePai = new short[1] ;
      T002B77_A1561EmpConveCod = new String[] {""} ;
      T002B78_A3CliCod = new int[1] ;
      T002B78_A1EmpCod = new short[1] ;
      T002B78_A1562EmpConvePai = new short[1] ;
      T002B78_A1561EmpConveCod = new String[] {""} ;
      T002B79_A3CliCod = new int[1] ;
      T002B79_A1EmpCod = new short[1] ;
      T002B79_A1562EmpConvePai = new short[1] ;
      T002B79_A1561EmpConveCod = new String[] {""} ;
      T002B80_A3CliCod = new int[1] ;
      T002B80_A1EmpCod = new short[1] ;
      T002B80_A1562EmpConvePai = new short[1] ;
      T002B80_A1561EmpConveCod = new String[] {""} ;
      T002B81_A3CliCod = new int[1] ;
      T002B81_A1EmpCod = new short[1] ;
      T002B81_A1562EmpConvePai = new short[1] ;
      T002B81_A1561EmpConveCod = new String[] {""} ;
      T002B82_A3CliCod = new int[1] ;
      T002B82_A1EmpCod = new short[1] ;
      T002B82_A1562EmpConvePai = new short[1] ;
      T002B82_A1561EmpConveCod = new String[] {""} ;
      T002B83_A3CliCod = new int[1] ;
      T002B83_A1EmpCod = new short[1] ;
      T002B83_A1562EmpConvePai = new short[1] ;
      T002B83_A1561EmpConveCod = new String[] {""} ;
      T002B84_A3CliCod = new int[1] ;
      T002B84_A1EmpCod = new short[1] ;
      T002B84_A1562EmpConvePai = new short[1] ;
      T002B84_A1561EmpConveCod = new String[] {""} ;
      T002B85_A3CliCod = new int[1] ;
      T002B85_A1EmpCod = new short[1] ;
      T002B85_A1562EmpConvePai = new short[1] ;
      T002B85_A1561EmpConveCod = new String[] {""} ;
      T002B86_A3CliCod = new int[1] ;
      T002B86_A1EmpCod = new short[1] ;
      T002B86_A1562EmpConvePai = new short[1] ;
      T002B86_A1561EmpConveCod = new String[] {""} ;
      T002B87_A3CliCod = new int[1] ;
      T002B87_A1EmpCod = new short[1] ;
      T002B87_A1562EmpConvePai = new short[1] ;
      T002B87_A1561EmpConveCod = new String[] {""} ;
      T002B88_A3CliCod = new int[1] ;
      T002B88_A1EmpCod = new short[1] ;
      T002B88_A1562EmpConvePai = new short[1] ;
      T002B88_A1561EmpConveCod = new String[] {""} ;
      T002B89_A3CliCod = new int[1] ;
      T002B89_A1EmpCod = new short[1] ;
      T002B89_A1562EmpConvePai = new short[1] ;
      T002B89_A1561EmpConveCod = new String[] {""} ;
      T002B90_A3CliCod = new int[1] ;
      T002B90_A1EmpCod = new short[1] ;
      T002B90_A1562EmpConvePai = new short[1] ;
      T002B90_A1561EmpConveCod = new String[] {""} ;
      T002B91_A3CliCod = new int[1] ;
      T002B91_A1EmpCod = new short[1] ;
      T002B91_A1562EmpConvePai = new short[1] ;
      T002B91_A1561EmpConveCod = new String[] {""} ;
      T002B92_A3CliCod = new int[1] ;
      T002B92_A1EmpCod = new short[1] ;
      T002B92_A1562EmpConvePai = new short[1] ;
      T002B92_A1561EmpConveCod = new String[] {""} ;
      T002B93_A3CliCod = new int[1] ;
      T002B93_A1EmpCod = new short[1] ;
      T002B93_A1562EmpConvePai = new short[1] ;
      T002B93_A1561EmpConveCod = new String[] {""} ;
      T002B94_A3CliCod = new int[1] ;
      T002B94_A1EmpCod = new short[1] ;
      T002B94_A1562EmpConvePai = new short[1] ;
      T002B94_A1561EmpConveCod = new String[] {""} ;
      T002B95_A3CliCod = new int[1] ;
      T002B95_A1EmpCod = new short[1] ;
      T002B95_A1562EmpConvePai = new short[1] ;
      T002B95_A1561EmpConveCod = new String[] {""} ;
      T002B96_A3CliCod = new int[1] ;
      T002B96_A1EmpCod = new short[1] ;
      T002B96_A1562EmpConvePai = new short[1] ;
      T002B96_A1561EmpConveCod = new String[] {""} ;
      T002B97_A3CliCod = new int[1] ;
      T002B97_A1EmpCod = new short[1] ;
      T002B97_A1562EmpConvePai = new short[1] ;
      T002B97_A1561EmpConveCod = new String[] {""} ;
      T002B98_A3CliCod = new int[1] ;
      T002B98_A1EmpCod = new short[1] ;
      T002B98_A1547GuarCod = new short[1] ;
      T002B99_A3CliCod = new int[1] ;
      T002B99_A1EmpCod = new short[1] ;
      T002B99_A1427EmpBaseClaseLeg = new byte[1] ;
      T002B99_A1429EmpBaseTipo = new String[] {""} ;
      T002B99_A1430EmpBaseCod1 = new String[] {""} ;
      T002B99_A1431EmpBaseCod2 = new String[] {""} ;
      T002B100_A3CliCod = new int[1] ;
      T002B100_A1EmpCod = new short[1] ;
      T002B100_A37TipoConCod = new String[] {""} ;
      T002B100_A1371EmpPromFijVar = new String[] {""} ;
      T002B101_A3CliCod = new int[1] ;
      T002B101_A1EmpCod = new short[1] ;
      T002B101_A1366EmpJorConCodigo = new String[] {""} ;
      T002B102_A3CliCod = new int[1] ;
      T002B102_A1EmpCod = new short[1] ;
      T002B102_A1368EmpMenConCodigo = new String[] {""} ;
      T002B103_A3CliCod = new int[1] ;
      T002B103_A1EmpCod = new short[1] ;
      T002B103_A1294PaiTipoTraId = new String[] {""} ;
      T002B104_A3CliCod = new int[1] ;
      T002B104_A1EmpCod = new short[1] ;
      T002B104_A1340EmpHsExSec = new short[1] ;
      T002B105_A3CliCod = new int[1] ;
      T002B105_A1EmpCod = new short[1] ;
      T002B105_A1243SucCodigo = new String[] {""} ;
      T002B106_A3CliCod = new int[1] ;
      T002B106_A1EmpCod = new short[1] ;
      T002B106_A1237EmpReligion = new String[] {""} ;
      T002B107_A3CliCod = new int[1] ;
      T002B107_A1EmpCod = new short[1] ;
      T002B107_A1238EmpOrigen = new String[] {""} ;
      T002B108_A3CliCod = new int[1] ;
      T002B108_A1EmpCod = new short[1] ;
      T002B108_A1239EmpConvenio = new String[] {""} ;
      T002B109_A3CliCod = new int[1] ;
      T002B109_A1EmpCod = new short[1] ;
      T002B109_A784F1357CTipoPre = new byte[1] ;
      T002B109_A777F1357CPer = new String[] {""} ;
      T002B109_A778F1357CSec = new byte[1] ;
      T002B110_A3CliCod = new int[1] ;
      T002B110_A1EmpCod = new short[1] ;
      T002B110_A88ImpLiqSec = new short[1] ;
      T002B111_A3CliCod = new int[1] ;
      T002B111_A1EmpCod = new short[1] ;
      T002B111_A87MigrLegNumero = new int[1] ;
      T002B112_A3CliCod = new int[1] ;
      T002B112_A1EmpCod = new short[1] ;
      T002B112_A86TempRecSec = new short[1] ;
      T002B113_A3CliCod = new int[1] ;
      T002B113_A1EmpCod = new short[1] ;
      T002B113_A85ArchSiradigFec = new java.util.Date[] {GXutil.nullDate()} ;
      T002B114_A3CliCod = new int[1] ;
      T002B114_A1EmpCod = new short[1] ;
      T002B114_A79AsientoCNum = new int[1] ;
      T002B115_A3CliCod = new int[1] ;
      T002B115_A1EmpCod = new short[1] ;
      T002B115_A78CuenCodigo = new String[] {""} ;
      T002B116_A3CliCod = new int[1] ;
      T002B116_A1EmpCod = new short[1] ;
      T002B116_A77CenCodigo = new short[1] ;
      T002B117_A3CliCod = new int[1] ;
      T002B117_A1EmpCod = new short[1] ;
      T002B117_A31LiqNro = new int[1] ;
      T002B117_A10LpgCodigo = new String[] {""} ;
      T002B118_A3CliCod = new int[1] ;
      T002B118_A1EmpCod = new short[1] ;
      T002B118_A6LegNumero = new int[1] ;
      T002B119_A3CliCod = new int[1] ;
      T002B119_A1EmpCod = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXv_int13 = new short[1] ;
      T002B120_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liqimportarauxtrn__default(),
         new Object[] {
             new Object[] {
            T002B2_A1EmpCod, T002B2_A2EmpNom, T002B2_A177EmpCUIT, T002B2_A125CatIvaCod, T002B2_n125CatIvaCod, T002B2_A126CatIvaDesc, T002B2_n126CatIvaDesc, T002B2_A178EmpDir, T002B2_A180EmpTel, T002B2_n180EmpTel,
            T002B2_A176EmpCP, T002B2_n176EmpCP, T002B2_A532EmpReducc, T002B2_A46PaiCod, T002B2_n46PaiCod, T002B2_A47ProvCod, T002B2_n47ProvCod, T002B2_A48LocCod, T002B2_n48LocCod, T002B2_A3CliCod,
            T002B2_A43ActCodigo, T002B2_n43ActCodigo, T002B2_A45TipEmpleCod, T002B2_n45TipEmpleCod, T002B2_A44EmpZonCod, T002B2_n44EmpZonCod
            }
            , new Object[] {
            T002B3_A1EmpCod, T002B3_A2EmpNom, T002B3_A177EmpCUIT, T002B3_A125CatIvaCod, T002B3_n125CatIvaCod, T002B3_A126CatIvaDesc, T002B3_n126CatIvaDesc, T002B3_A178EmpDir, T002B3_A180EmpTel, T002B3_n180EmpTel,
            T002B3_A176EmpCP, T002B3_n176EmpCP, T002B3_A532EmpReducc, T002B3_A46PaiCod, T002B3_n46PaiCod, T002B3_A47ProvCod, T002B3_n47ProvCod, T002B3_A48LocCod, T002B3_n48LocCod, T002B3_A3CliCod,
            T002B3_A43ActCodigo, T002B3_n43ActCodigo, T002B3_A45TipEmpleCod, T002B3_n45TipEmpleCod, T002B3_A44EmpZonCod, T002B3_n44EmpZonCod
            }
            , new Object[] {
            T002B4_A312PaiNom
            }
            , new Object[] {
            T002B5_A322ProvNom
            }
            , new Object[] {
            T002B6_A286LocNom
            }
            , new Object[] {
            T002B7_A3CliCod
            }
            , new Object[] {
            T002B8_A683ActDescripSinAc, T002B8_A108ActDescrip
            }
            , new Object[] {
            T002B9_A530TipEmpleDefIns
            }
            , new Object[] {
            T002B10_A518EmpZonDescrip
            }
            , new Object[] {
            T002B11_A683ActDescripSinAc, T002B11_A1EmpCod, T002B11_A2EmpNom, T002B11_A177EmpCUIT, T002B11_A125CatIvaCod, T002B11_n125CatIvaCod, T002B11_A126CatIvaDesc, T002B11_n126CatIvaDesc, T002B11_A178EmpDir, T002B11_A180EmpTel,
            T002B11_n180EmpTel, T002B11_A176EmpCP, T002B11_n176EmpCP, T002B11_A312PaiNom, T002B11_A322ProvNom, T002B11_A286LocNom, T002B11_A108ActDescrip, T002B11_A518EmpZonDescrip, T002B11_A532EmpReducc, T002B11_A530TipEmpleDefIns,
            T002B11_A46PaiCod, T002B11_n46PaiCod, T002B11_A47ProvCod, T002B11_n47ProvCod, T002B11_A48LocCod, T002B11_n48LocCod, T002B11_A3CliCod, T002B11_A43ActCodigo, T002B11_n43ActCodigo, T002B11_A45TipEmpleCod,
            T002B11_n45TipEmpleCod, T002B11_A44EmpZonCod, T002B11_n44EmpZonCod
            }
            , new Object[] {
            T002B12_A3CliCod
            }
            , new Object[] {
            T002B13_A312PaiNom
            }
            , new Object[] {
            T002B14_A322ProvNom
            }
            , new Object[] {
            T002B15_A286LocNom
            }
            , new Object[] {
            T002B16_A683ActDescripSinAc, T002B16_A108ActDescrip
            }
            , new Object[] {
            T002B17_A530TipEmpleDefIns
            }
            , new Object[] {
            T002B18_A518EmpZonDescrip
            }
            , new Object[] {
            T002B19_A3CliCod, T002B19_A1EmpCod
            }
            , new Object[] {
            T002B20_A1EmpCod, T002B20_A3CliCod
            }
            , new Object[] {
            T002B21_A1EmpCod, T002B21_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002B25_A312PaiNom
            }
            , new Object[] {
            T002B26_A322ProvNom
            }
            , new Object[] {
            T002B27_A286LocNom
            }
            , new Object[] {
            T002B28_A683ActDescripSinAc, T002B28_A108ActDescrip
            }
            , new Object[] {
            T002B29_A530TipEmpleDefIns
            }
            , new Object[] {
            T002B30_A518EmpZonDescrip
            }
            , new Object[] {
            T002B31_A3CliCod, T002B31_A1EmpCod, T002B31_A2418BanSalCod
            }
            , new Object[] {
            T002B32_A3CliCod, T002B32_A1EmpCod, T002B32_A2380ColaUUID
            }
            , new Object[] {
            T002B33_A3CliCod, T002B33_A1EmpCod, T002B33_A2371LiqBatchLiqNro, T002B33_A2372LiqBatchCod, T002B33_A2373LiqBatchSeccion
            }
            , new Object[] {
            T002B34_A3CliCod, T002B34_A1EmpCod, T002B34_A2370LiqLoteLiqNro, T002B34_A2269LiqLote
            }
            , new Object[] {
            T002B35_A3CliCod, T002B35_A1EmpCod, T002B35_A31LiqNro, T002B35_A2285LinkLegNumero, T002B35_A2277LegLinkTiporec
            }
            , new Object[] {
            T002B36_A3CliCod, T002B36_A1EmpCod, T002B36_A31LiqNro, T002B36_A2183LiqSuc
            }
            , new Object[] {
            T002B37_A3CliCod, T002B37_A1EmpCod, T002B37_A31LiqNro, T002B37_A2145LiqArea
            }
            , new Object[] {
            T002B38_A3CliCod, T002B38_A1EmpCod, T002B38_A31LiqNro, T002B38_A2142LiqPaiConve, T002B38_A2143LiqConvenio
            }
            , new Object[] {
            T002B39_A3CliCod, T002B39_A1EmpCod, T002B39_A1966EmpBanCod
            }
            , new Object[] {
            T002B40_A3CliCod, T002B40_A1EmpCod, T002B40_A1729PeriodoLiq
            }
            , new Object[] {
            T002B41_A3CliCod, T002B41_A1EmpCod, T002B41_A1649LSDSec
            }
            , new Object[] {
            T002B42_A3CliCod, T002B42_A1EmpCod, T002B42_A1562EmpConvePai, T002B42_A1561EmpConveCod
            }
            , new Object[] {
            T002B43_A3CliCod, T002B43_A1EmpCod, T002B43_A1562EmpConvePai, T002B43_A1561EmpConveCod
            }
            , new Object[] {
            T002B44_A3CliCod, T002B44_A1EmpCod, T002B44_A1562EmpConvePai, T002B44_A1561EmpConveCod
            }
            , new Object[] {
            T002B45_A3CliCod, T002B45_A1EmpCod, T002B45_A1562EmpConvePai, T002B45_A1561EmpConveCod
            }
            , new Object[] {
            T002B46_A3CliCod, T002B46_A1EmpCod, T002B46_A1562EmpConvePai, T002B46_A1561EmpConveCod
            }
            , new Object[] {
            T002B47_A3CliCod, T002B47_A1EmpCod, T002B47_A1562EmpConvePai, T002B47_A1561EmpConveCod
            }
            , new Object[] {
            T002B48_A3CliCod, T002B48_A1EmpCod, T002B48_A1562EmpConvePai, T002B48_A1561EmpConveCod
            }
            , new Object[] {
            T002B49_A3CliCod, T002B49_A1EmpCod, T002B49_A1562EmpConvePai, T002B49_A1561EmpConveCod
            }
            , new Object[] {
            T002B50_A3CliCod, T002B50_A1EmpCod, T002B50_A1562EmpConvePai, T002B50_A1561EmpConveCod
            }
            , new Object[] {
            T002B51_A3CliCod, T002B51_A1EmpCod, T002B51_A1562EmpConvePai, T002B51_A1561EmpConveCod
            }
            , new Object[] {
            T002B52_A3CliCod, T002B52_A1EmpCod, T002B52_A1562EmpConvePai, T002B52_A1561EmpConveCod
            }
            , new Object[] {
            T002B53_A3CliCod, T002B53_A1EmpCod, T002B53_A1562EmpConvePai, T002B53_A1561EmpConveCod
            }
            , new Object[] {
            T002B54_A3CliCod, T002B54_A1EmpCod, T002B54_A1562EmpConvePai, T002B54_A1561EmpConveCod
            }
            , new Object[] {
            T002B55_A3CliCod, T002B55_A1EmpCod, T002B55_A1562EmpConvePai, T002B55_A1561EmpConveCod
            }
            , new Object[] {
            T002B56_A3CliCod, T002B56_A1EmpCod, T002B56_A1562EmpConvePai, T002B56_A1561EmpConveCod
            }
            , new Object[] {
            T002B57_A3CliCod, T002B57_A1EmpCod, T002B57_A1562EmpConvePai, T002B57_A1561EmpConveCod
            }
            , new Object[] {
            T002B58_A3CliCod, T002B58_A1EmpCod, T002B58_A1562EmpConvePai, T002B58_A1561EmpConveCod
            }
            , new Object[] {
            T002B59_A3CliCod, T002B59_A1EmpCod, T002B59_A1562EmpConvePai, T002B59_A1561EmpConveCod
            }
            , new Object[] {
            T002B60_A3CliCod, T002B60_A1EmpCod, T002B60_A1562EmpConvePai, T002B60_A1561EmpConveCod
            }
            , new Object[] {
            T002B61_A3CliCod, T002B61_A1EmpCod, T002B61_A1562EmpConvePai, T002B61_A1561EmpConveCod
            }
            , new Object[] {
            T002B62_A3CliCod, T002B62_A1EmpCod, T002B62_A1562EmpConvePai, T002B62_A1561EmpConveCod
            }
            , new Object[] {
            T002B63_A3CliCod, T002B63_A1EmpCod, T002B63_A1562EmpConvePai, T002B63_A1561EmpConveCod
            }
            , new Object[] {
            T002B64_A3CliCod, T002B64_A1EmpCod, T002B64_A1562EmpConvePai, T002B64_A1561EmpConveCod
            }
            , new Object[] {
            T002B65_A3CliCod, T002B65_A1EmpCod, T002B65_A1562EmpConvePai, T002B65_A1561EmpConveCod
            }
            , new Object[] {
            T002B66_A3CliCod, T002B66_A1EmpCod, T002B66_A1562EmpConvePai, T002B66_A1561EmpConveCod
            }
            , new Object[] {
            T002B67_A3CliCod, T002B67_A1EmpCod, T002B67_A1562EmpConvePai, T002B67_A1561EmpConveCod
            }
            , new Object[] {
            T002B68_A3CliCod, T002B68_A1EmpCod, T002B68_A1562EmpConvePai, T002B68_A1561EmpConveCod
            }
            , new Object[] {
            T002B69_A3CliCod, T002B69_A1EmpCod, T002B69_A1562EmpConvePai, T002B69_A1561EmpConveCod
            }
            , new Object[] {
            T002B70_A3CliCod, T002B70_A1EmpCod, T002B70_A1562EmpConvePai, T002B70_A1561EmpConveCod
            }
            , new Object[] {
            T002B71_A3CliCod, T002B71_A1EmpCod, T002B71_A1562EmpConvePai, T002B71_A1561EmpConveCod
            }
            , new Object[] {
            T002B72_A3CliCod, T002B72_A1EmpCod, T002B72_A1562EmpConvePai, T002B72_A1561EmpConveCod
            }
            , new Object[] {
            T002B73_A3CliCod, T002B73_A1EmpCod, T002B73_A1562EmpConvePai, T002B73_A1561EmpConveCod
            }
            , new Object[] {
            T002B74_A3CliCod, T002B74_A1EmpCod, T002B74_A1562EmpConvePai, T002B74_A1561EmpConveCod
            }
            , new Object[] {
            T002B75_A3CliCod, T002B75_A1EmpCod, T002B75_A1562EmpConvePai, T002B75_A1561EmpConveCod
            }
            , new Object[] {
            T002B76_A3CliCod, T002B76_A1EmpCod, T002B76_A1562EmpConvePai, T002B76_A1561EmpConveCod
            }
            , new Object[] {
            T002B77_A3CliCod, T002B77_A1EmpCod, T002B77_A1562EmpConvePai, T002B77_A1561EmpConveCod
            }
            , new Object[] {
            T002B78_A3CliCod, T002B78_A1EmpCod, T002B78_A1562EmpConvePai, T002B78_A1561EmpConveCod
            }
            , new Object[] {
            T002B79_A3CliCod, T002B79_A1EmpCod, T002B79_A1562EmpConvePai, T002B79_A1561EmpConveCod
            }
            , new Object[] {
            T002B80_A3CliCod, T002B80_A1EmpCod, T002B80_A1562EmpConvePai, T002B80_A1561EmpConveCod
            }
            , new Object[] {
            T002B81_A3CliCod, T002B81_A1EmpCod, T002B81_A1562EmpConvePai, T002B81_A1561EmpConveCod
            }
            , new Object[] {
            T002B82_A3CliCod, T002B82_A1EmpCod, T002B82_A1562EmpConvePai, T002B82_A1561EmpConveCod
            }
            , new Object[] {
            T002B83_A3CliCod, T002B83_A1EmpCod, T002B83_A1562EmpConvePai, T002B83_A1561EmpConveCod
            }
            , new Object[] {
            T002B84_A3CliCod, T002B84_A1EmpCod, T002B84_A1562EmpConvePai, T002B84_A1561EmpConveCod
            }
            , new Object[] {
            T002B85_A3CliCod, T002B85_A1EmpCod, T002B85_A1562EmpConvePai, T002B85_A1561EmpConveCod
            }
            , new Object[] {
            T002B86_A3CliCod, T002B86_A1EmpCod, T002B86_A1562EmpConvePai, T002B86_A1561EmpConveCod
            }
            , new Object[] {
            T002B87_A3CliCod, T002B87_A1EmpCod, T002B87_A1562EmpConvePai, T002B87_A1561EmpConveCod
            }
            , new Object[] {
            T002B88_A3CliCod, T002B88_A1EmpCod, T002B88_A1562EmpConvePai, T002B88_A1561EmpConveCod
            }
            , new Object[] {
            T002B89_A3CliCod, T002B89_A1EmpCod, T002B89_A1562EmpConvePai, T002B89_A1561EmpConveCod
            }
            , new Object[] {
            T002B90_A3CliCod, T002B90_A1EmpCod, T002B90_A1562EmpConvePai, T002B90_A1561EmpConveCod
            }
            , new Object[] {
            T002B91_A3CliCod, T002B91_A1EmpCod, T002B91_A1562EmpConvePai, T002B91_A1561EmpConveCod
            }
            , new Object[] {
            T002B92_A3CliCod, T002B92_A1EmpCod, T002B92_A1562EmpConvePai, T002B92_A1561EmpConveCod
            }
            , new Object[] {
            T002B93_A3CliCod, T002B93_A1EmpCod, T002B93_A1562EmpConvePai, T002B93_A1561EmpConveCod
            }
            , new Object[] {
            T002B94_A3CliCod, T002B94_A1EmpCod, T002B94_A1562EmpConvePai, T002B94_A1561EmpConveCod
            }
            , new Object[] {
            T002B95_A3CliCod, T002B95_A1EmpCod, T002B95_A1562EmpConvePai, T002B95_A1561EmpConveCod
            }
            , new Object[] {
            T002B96_A3CliCod, T002B96_A1EmpCod, T002B96_A1562EmpConvePai, T002B96_A1561EmpConveCod
            }
            , new Object[] {
            T002B97_A3CliCod, T002B97_A1EmpCod, T002B97_A1562EmpConvePai, T002B97_A1561EmpConveCod
            }
            , new Object[] {
            T002B98_A3CliCod, T002B98_A1EmpCod, T002B98_A1547GuarCod
            }
            , new Object[] {
            T002B99_A3CliCod, T002B99_A1EmpCod, T002B99_A1427EmpBaseClaseLeg, T002B99_A1429EmpBaseTipo, T002B99_A1430EmpBaseCod1, T002B99_A1431EmpBaseCod2
            }
            , new Object[] {
            T002B100_A3CliCod, T002B100_A1EmpCod, T002B100_A37TipoConCod, T002B100_A1371EmpPromFijVar
            }
            , new Object[] {
            T002B101_A3CliCod, T002B101_A1EmpCod, T002B101_A1366EmpJorConCodigo
            }
            , new Object[] {
            T002B102_A3CliCod, T002B102_A1EmpCod, T002B102_A1368EmpMenConCodigo
            }
            , new Object[] {
            T002B103_A3CliCod, T002B103_A1EmpCod, T002B103_A1294PaiTipoTraId
            }
            , new Object[] {
            T002B104_A3CliCod, T002B104_A1EmpCod, T002B104_A1340EmpHsExSec
            }
            , new Object[] {
            T002B105_A3CliCod, T002B105_A1EmpCod, T002B105_A1243SucCodigo
            }
            , new Object[] {
            T002B106_A3CliCod, T002B106_A1EmpCod, T002B106_A1237EmpReligion
            }
            , new Object[] {
            T002B107_A3CliCod, T002B107_A1EmpCod, T002B107_A1238EmpOrigen
            }
            , new Object[] {
            T002B108_A3CliCod, T002B108_A1EmpCod, T002B108_A1239EmpConvenio
            }
            , new Object[] {
            T002B109_A3CliCod, T002B109_A1EmpCod, T002B109_A784F1357CTipoPre, T002B109_A777F1357CPer, T002B109_A778F1357CSec
            }
            , new Object[] {
            T002B110_A3CliCod, T002B110_A1EmpCod, T002B110_A88ImpLiqSec
            }
            , new Object[] {
            T002B111_A3CliCod, T002B111_A1EmpCod, T002B111_A87MigrLegNumero
            }
            , new Object[] {
            T002B112_A3CliCod, T002B112_A1EmpCod, T002B112_A86TempRecSec
            }
            , new Object[] {
            T002B113_A3CliCod, T002B113_A1EmpCod, T002B113_A85ArchSiradigFec
            }
            , new Object[] {
            T002B114_A3CliCod, T002B114_A1EmpCod, T002B114_A79AsientoCNum
            }
            , new Object[] {
            T002B115_A3CliCod, T002B115_A1EmpCod, T002B115_A78CuenCodigo
            }
            , new Object[] {
            T002B116_A3CliCod, T002B116_A1EmpCod, T002B116_A77CenCodigo
            }
            , new Object[] {
            T002B117_A3CliCod, T002B117_A1EmpCod, T002B117_A31LiqNro, T002B117_A10LpgCodigo
            }
            , new Object[] {
            T002B118_A3CliCod, T002B118_A1EmpCod, T002B118_A6LegNumero
            }
            , new Object[] {
            T002B119_A3CliCod, T002B119_A1EmpCod
            }
            , new Object[] {
            T002B120_A3CliCod
            }
         }
      );
      AV45Pgmname = "LiqImportarAuxTrn" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7EmpCod ;
   private short Z1EmpCod ;
   private short Z125CatIvaCod ;
   private short Z46PaiCod ;
   private short Z47ProvCod ;
   private short Z48LocCod ;
   private short N46PaiCod ;
   private short N47ProvCod ;
   private short N48LocCod ;
   private short AV7EmpCod ;
   private short A46PaiCod ;
   private short A47ProvCod ;
   private short A48LocCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1EmpCod ;
   private short A125CatIvaCod ;
   private short AV21ComboPaiCod ;
   private short AV23ComboProvCod ;
   private short AV26ComboLocCod ;
   private short AV24Cond_PaiCod ;
   private short AV27Cond_ProvCod ;
   private short AV11Insert_PaiCod ;
   private short AV12Insert_ProvCod ;
   private short AV13Insert_LocCod ;
   private short RcdFound13 ;
   private short nIsDirty_13 ;
   private short GXt_int12 ;
   private short GXv_int13[] ;
   private int wcpOAV30CliCod ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int AV30CliCod ;
   private int trnEnded ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Enabled ;
   private int edtEmpNom_Enabled ;
   private int edtEmpCUIT_Enabled ;
   private int edtCatIvaCod_Enabled ;
   private int edtCatIvaDesc_Enabled ;
   private int edtEmpDir_Enabled ;
   private int edtEmpTel_Enabled ;
   private int edtEmpCP_Enabled ;
   private int edtPaiCod_Visible ;
   private int edtPaiCod_Enabled ;
   private int edtProvCod_Visible ;
   private int edtProvCod_Enabled ;
   private int edtLocCod_Visible ;
   private int edtLocCod_Enabled ;
   private int edtActCodigo_Visible ;
   private int edtActCodigo_Enabled ;
   private int edtTipEmpleCod_Visible ;
   private int edtTipEmpleCod_Enabled ;
   private int edtEmpZonCod_Visible ;
   private int edtEmpZonCod_Enabled ;
   private int edtEmpZonDescrip_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombopaicod_Enabled ;
   private int edtavCombopaicod_Visible ;
   private int edtavComboprovcod_Enabled ;
   private int edtavComboprovcod_Visible ;
   private int edtavComboloccod_Enabled ;
   private int edtavComboloccod_Visible ;
   private int edtavComboactcodigo_Visible ;
   private int edtavComboactcodigo_Enabled ;
   private int edtavCombotipemplecod_Visible ;
   private int edtavCombotipemplecod_Enabled ;
   private int edtavComboempzoncod_Visible ;
   private int edtavComboempzoncod_Enabled ;
   private int Combo_paicod_Datalistupdateminimumcharacters ;
   private int Combo_paicod_Gxcontroltype ;
   private int Combo_provcod_Datalistupdateminimumcharacters ;
   private int Combo_provcod_Gxcontroltype ;
   private int Combo_loccod_Datalistupdateminimumcharacters ;
   private int Combo_loccod_Gxcontroltype ;
   private int Combo_actcodigo_Datalistupdateminimumcharacters ;
   private int Combo_actcodigo_Gxcontroltype ;
   private int Combo_tipemplecod_Datalistupdateminimumcharacters ;
   private int Combo_tipemplecod_Gxcontroltype ;
   private int Combo_empzoncod_Datalistupdateminimumcharacters ;
   private int Combo_empzoncod_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV46GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private long Z177EmpCUIT ;
   private long A177EmpCUIT ;
   private long GXv_int10[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z176EmpCP ;
   private String Z43ActCodigo ;
   private String Z45TipEmpleCod ;
   private String Z44EmpZonCod ;
   private String N43ActCodigo ;
   private String N45TipEmpleCod ;
   private String N44EmpZonCod ;
   private String Combo_empzoncod_Selectedvalue_get ;
   private String Combo_tipemplecod_Selectedvalue_get ;
   private String Combo_actcodigo_Selectedvalue_get ;
   private String Combo_loccod_Selectedvalue_get ;
   private String Combo_provcod_Selectedvalue_get ;
   private String Combo_paicod_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A43ActCodigo ;
   private String A45TipEmpleCod ;
   private String A44EmpZonCod ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCliCod_Internalname ;
   private String A530TipEmpleDefIns ;
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
   private String TempTags ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtEmpNom_Internalname ;
   private String edtEmpNom_Jsonclick ;
   private String edtEmpCUIT_Internalname ;
   private String edtEmpCUIT_Jsonclick ;
   private String edtCatIvaCod_Internalname ;
   private String edtCatIvaCod_Jsonclick ;
   private String edtCatIvaDesc_Internalname ;
   private String edtCatIvaDesc_Jsonclick ;
   private String edtEmpDir_Internalname ;
   private String edtEmpDir_Jsonclick ;
   private String edtEmpTel_Internalname ;
   private String edtEmpTel_Jsonclick ;
   private String edtEmpCP_Internalname ;
   private String A176EmpCP ;
   private String edtEmpCP_Jsonclick ;
   private String divTablesplittedpaicod_Internalname ;
   private String lblTextblockpaicod_Internalname ;
   private String lblTextblockpaicod_Jsonclick ;
   private String Combo_paicod_Caption ;
   private String Combo_paicod_Cls ;
   private String Combo_paicod_Datalistproc ;
   private String Combo_paicod_Datalistprocparametersprefix ;
   private String Combo_paicod_Internalname ;
   private String edtPaiCod_Internalname ;
   private String edtPaiCod_Jsonclick ;
   private String divTablesplittedprovcod_Internalname ;
   private String lblTextblockprovcod_Internalname ;
   private String lblTextblockprovcod_Jsonclick ;
   private String Combo_provcod_Caption ;
   private String Combo_provcod_Cls ;
   private String Combo_provcod_Datalistproc ;
   private String Combo_provcod_Internalname ;
   private String edtProvCod_Internalname ;
   private String edtProvCod_Jsonclick ;
   private String divTablesplittedloccod_Internalname ;
   private String lblTextblockloccod_Internalname ;
   private String lblTextblockloccod_Jsonclick ;
   private String Combo_loccod_Caption ;
   private String Combo_loccod_Cls ;
   private String Combo_loccod_Datalistproc ;
   private String Combo_loccod_Internalname ;
   private String edtLocCod_Internalname ;
   private String edtLocCod_Jsonclick ;
   private String divTablesplittedactcodigo_Internalname ;
   private String lblTextblockactcodigo_Internalname ;
   private String lblTextblockactcodigo_Jsonclick ;
   private String Combo_actcodigo_Caption ;
   private String Combo_actcodigo_Cls ;
   private String Combo_actcodigo_Datalistproc ;
   private String Combo_actcodigo_Datalistprocparametersprefix ;
   private String Combo_actcodigo_Internalname ;
   private String edtActCodigo_Internalname ;
   private String edtActCodigo_Jsonclick ;
   private String divTablesplittedtipemplecod_Internalname ;
   private String lblTextblocktipemplecod_Internalname ;
   private String lblTextblocktipemplecod_Jsonclick ;
   private String Combo_tipemplecod_Caption ;
   private String Combo_tipemplecod_Cls ;
   private String Combo_tipemplecod_Datalistproc ;
   private String Combo_tipemplecod_Datalistprocparametersprefix ;
   private String Combo_tipemplecod_Internalname ;
   private String edtTipEmpleCod_Internalname ;
   private String edtTipEmpleCod_Jsonclick ;
   private String divTablesplittedempzoncod_Internalname ;
   private String lblTextblockempzoncod_Internalname ;
   private String lblTextblockempzoncod_Jsonclick ;
   private String Combo_empzoncod_Caption ;
   private String Combo_empzoncod_Cls ;
   private String Combo_empzoncod_Datalistproc ;
   private String Combo_empzoncod_Datalistprocparametersprefix ;
   private String Combo_empzoncod_Internalname ;
   private String edtEmpZonCod_Internalname ;
   private String edtEmpZonCod_Jsonclick ;
   private String edtEmpZonDescrip_Internalname ;
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
   private String divSectionattribute_provcod_Internalname ;
   private String edtavComboprovcod_Internalname ;
   private String edtavComboprovcod_Jsonclick ;
   private String divSectionattribute_loccod_Internalname ;
   private String edtavComboloccod_Internalname ;
   private String edtavComboloccod_Jsonclick ;
   private String divSectionattribute_actcodigo_Internalname ;
   private String edtavComboactcodigo_Internalname ;
   private String AV29ComboActCodigo ;
   private String edtavComboactcodigo_Jsonclick ;
   private String divSectionattribute_tipemplecod_Internalname ;
   private String edtavCombotipemplecod_Internalname ;
   private String AV42ComboTipEmpleCod ;
   private String edtavCombotipemplecod_Jsonclick ;
   private String divSectionattribute_empzoncod_Internalname ;
   private String edtavComboempzoncod_Internalname ;
   private String AV38ComboEmpZonCod ;
   private String edtavComboempzoncod_Jsonclick ;
   private String AV14Insert_ActCodigo ;
   private String AV40Insert_TipEmpleCod ;
   private String AV36Insert_EmpZonCod ;
   private String AV45Pgmname ;
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
   private String Combo_provcod_Objectcall ;
   private String Combo_provcod_Class ;
   private String Combo_provcod_Icontype ;
   private String Combo_provcod_Icon ;
   private String Combo_provcod_Tooltip ;
   private String Combo_provcod_Selectedvalue_set ;
   private String Combo_provcod_Selectedtext_set ;
   private String Combo_provcod_Selectedtext_get ;
   private String Combo_provcod_Gamoauthtoken ;
   private String Combo_provcod_Ddointernalname ;
   private String Combo_provcod_Titlecontrolalign ;
   private String Combo_provcod_Dropdownoptionstype ;
   private String Combo_provcod_Titlecontrolidtoreplace ;
   private String Combo_provcod_Datalisttype ;
   private String Combo_provcod_Datalistfixedvalues ;
   private String Combo_provcod_Datalistprocparametersprefix ;
   private String Combo_provcod_Remoteservicesparameters ;
   private String Combo_provcod_Htmltemplate ;
   private String Combo_provcod_Multiplevaluestype ;
   private String Combo_provcod_Loadingdata ;
   private String Combo_provcod_Noresultsfound ;
   private String Combo_provcod_Emptyitemtext ;
   private String Combo_provcod_Onlyselectedvalues ;
   private String Combo_provcod_Selectalltext ;
   private String Combo_provcod_Multiplevaluesseparator ;
   private String Combo_provcod_Addnewoptiontext ;
   private String Combo_loccod_Objectcall ;
   private String Combo_loccod_Class ;
   private String Combo_loccod_Icontype ;
   private String Combo_loccod_Icon ;
   private String Combo_loccod_Tooltip ;
   private String Combo_loccod_Selectedvalue_set ;
   private String Combo_loccod_Selectedtext_set ;
   private String Combo_loccod_Selectedtext_get ;
   private String Combo_loccod_Gamoauthtoken ;
   private String Combo_loccod_Ddointernalname ;
   private String Combo_loccod_Titlecontrolalign ;
   private String Combo_loccod_Dropdownoptionstype ;
   private String Combo_loccod_Titlecontrolidtoreplace ;
   private String Combo_loccod_Datalisttype ;
   private String Combo_loccod_Datalistfixedvalues ;
   private String Combo_loccod_Datalistprocparametersprefix ;
   private String Combo_loccod_Remoteservicesparameters ;
   private String Combo_loccod_Htmltemplate ;
   private String Combo_loccod_Multiplevaluestype ;
   private String Combo_loccod_Loadingdata ;
   private String Combo_loccod_Noresultsfound ;
   private String Combo_loccod_Emptyitemtext ;
   private String Combo_loccod_Onlyselectedvalues ;
   private String Combo_loccod_Selectalltext ;
   private String Combo_loccod_Multiplevaluesseparator ;
   private String Combo_loccod_Addnewoptiontext ;
   private String Combo_actcodigo_Objectcall ;
   private String Combo_actcodigo_Class ;
   private String Combo_actcodigo_Icontype ;
   private String Combo_actcodigo_Icon ;
   private String Combo_actcodigo_Tooltip ;
   private String Combo_actcodigo_Selectedvalue_set ;
   private String Combo_actcodigo_Selectedtext_set ;
   private String Combo_actcodigo_Selectedtext_get ;
   private String Combo_actcodigo_Gamoauthtoken ;
   private String Combo_actcodigo_Ddointernalname ;
   private String Combo_actcodigo_Titlecontrolalign ;
   private String Combo_actcodigo_Dropdownoptionstype ;
   private String Combo_actcodigo_Titlecontrolidtoreplace ;
   private String Combo_actcodigo_Datalisttype ;
   private String Combo_actcodigo_Datalistfixedvalues ;
   private String Combo_actcodigo_Remoteservicesparameters ;
   private String Combo_actcodigo_Htmltemplate ;
   private String Combo_actcodigo_Multiplevaluestype ;
   private String Combo_actcodigo_Loadingdata ;
   private String Combo_actcodigo_Noresultsfound ;
   private String Combo_actcodigo_Emptyitemtext ;
   private String Combo_actcodigo_Onlyselectedvalues ;
   private String Combo_actcodigo_Selectalltext ;
   private String Combo_actcodigo_Multiplevaluesseparator ;
   private String Combo_actcodigo_Addnewoptiontext ;
   private String Combo_tipemplecod_Objectcall ;
   private String Combo_tipemplecod_Class ;
   private String Combo_tipemplecod_Icontype ;
   private String Combo_tipemplecod_Icon ;
   private String Combo_tipemplecod_Tooltip ;
   private String Combo_tipemplecod_Selectedvalue_set ;
   private String Combo_tipemplecod_Selectedtext_set ;
   private String Combo_tipemplecod_Selectedtext_get ;
   private String Combo_tipemplecod_Gamoauthtoken ;
   private String Combo_tipemplecod_Ddointernalname ;
   private String Combo_tipemplecod_Titlecontrolalign ;
   private String Combo_tipemplecod_Dropdownoptionstype ;
   private String Combo_tipemplecod_Titlecontrolidtoreplace ;
   private String Combo_tipemplecod_Datalisttype ;
   private String Combo_tipemplecod_Datalistfixedvalues ;
   private String Combo_tipemplecod_Remoteservicesparameters ;
   private String Combo_tipemplecod_Htmltemplate ;
   private String Combo_tipemplecod_Multiplevaluestype ;
   private String Combo_tipemplecod_Loadingdata ;
   private String Combo_tipemplecod_Noresultsfound ;
   private String Combo_tipemplecod_Emptyitemtext ;
   private String Combo_tipemplecod_Onlyselectedvalues ;
   private String Combo_tipemplecod_Selectalltext ;
   private String Combo_tipemplecod_Multiplevaluesseparator ;
   private String Combo_tipemplecod_Addnewoptiontext ;
   private String Combo_empzoncod_Objectcall ;
   private String Combo_empzoncod_Class ;
   private String Combo_empzoncod_Icontype ;
   private String Combo_empzoncod_Icon ;
   private String Combo_empzoncod_Tooltip ;
   private String Combo_empzoncod_Selectedvalue_set ;
   private String Combo_empzoncod_Selectedtext_set ;
   private String Combo_empzoncod_Selectedtext_get ;
   private String Combo_empzoncod_Gamoauthtoken ;
   private String Combo_empzoncod_Ddointernalname ;
   private String Combo_empzoncod_Titlecontrolalign ;
   private String Combo_empzoncod_Dropdownoptionstype ;
   private String Combo_empzoncod_Titlecontrolidtoreplace ;
   private String Combo_empzoncod_Datalisttype ;
   private String Combo_empzoncod_Datalistfixedvalues ;
   private String Combo_empzoncod_Remoteservicesparameters ;
   private String Combo_empzoncod_Htmltemplate ;
   private String Combo_empzoncod_Multiplevaluestype ;
   private String Combo_empzoncod_Loadingdata ;
   private String Combo_empzoncod_Noresultsfound ;
   private String Combo_empzoncod_Emptyitemtext ;
   private String Combo_empzoncod_Onlyselectedvalues ;
   private String Combo_empzoncod_Selectalltext ;
   private String Combo_empzoncod_Multiplevaluesseparator ;
   private String Combo_empzoncod_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode13 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXEncryptionTmp ;
   private String GXt_char6 ;
   private String GXv_char9[] ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String Z530TipEmpleDefIns ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date AV33Date ;
   private java.util.Date GXv_date11[] ;
   private boolean Z532EmpReducc ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n46PaiCod ;
   private boolean n47ProvCod ;
   private boolean n48LocCod ;
   private boolean n43ActCodigo ;
   private boolean n45TipEmpleCod ;
   private boolean n44EmpZonCod ;
   private boolean wbErr ;
   private boolean A532EmpReducc ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean n125CatIvaCod ;
   private boolean n126CatIvaDesc ;
   private boolean n180EmpTel ;
   private boolean n176EmpCP ;
   private boolean Combo_paicod_Enabled ;
   private boolean Combo_paicod_Visible ;
   private boolean Combo_paicod_Allowmultipleselection ;
   private boolean Combo_paicod_Isgriditem ;
   private boolean Combo_paicod_Hasdescription ;
   private boolean Combo_paicod_Includeonlyselectedoption ;
   private boolean Combo_paicod_Includeselectalloption ;
   private boolean Combo_paicod_Emptyitem ;
   private boolean Combo_paicod_Includeaddnewoption ;
   private boolean Combo_provcod_Enabled ;
   private boolean Combo_provcod_Visible ;
   private boolean Combo_provcod_Allowmultipleselection ;
   private boolean Combo_provcod_Isgriditem ;
   private boolean Combo_provcod_Hasdescription ;
   private boolean Combo_provcod_Includeonlyselectedoption ;
   private boolean Combo_provcod_Includeselectalloption ;
   private boolean Combo_provcod_Emptyitem ;
   private boolean Combo_provcod_Includeaddnewoption ;
   private boolean Combo_loccod_Enabled ;
   private boolean Combo_loccod_Visible ;
   private boolean Combo_loccod_Allowmultipleselection ;
   private boolean Combo_loccod_Isgriditem ;
   private boolean Combo_loccod_Hasdescription ;
   private boolean Combo_loccod_Includeonlyselectedoption ;
   private boolean Combo_loccod_Includeselectalloption ;
   private boolean Combo_loccod_Emptyitem ;
   private boolean Combo_loccod_Includeaddnewoption ;
   private boolean Combo_actcodigo_Enabled ;
   private boolean Combo_actcodigo_Visible ;
   private boolean Combo_actcodigo_Allowmultipleselection ;
   private boolean Combo_actcodigo_Isgriditem ;
   private boolean Combo_actcodigo_Hasdescription ;
   private boolean Combo_actcodigo_Includeonlyselectedoption ;
   private boolean Combo_actcodigo_Includeselectalloption ;
   private boolean Combo_actcodigo_Emptyitem ;
   private boolean Combo_actcodigo_Includeaddnewoption ;
   private boolean Combo_tipemplecod_Enabled ;
   private boolean Combo_tipemplecod_Visible ;
   private boolean Combo_tipemplecod_Allowmultipleselection ;
   private boolean Combo_tipemplecod_Isgriditem ;
   private boolean Combo_tipemplecod_Hasdescription ;
   private boolean Combo_tipemplecod_Includeonlyselectedoption ;
   private boolean Combo_tipemplecod_Includeselectalloption ;
   private boolean Combo_tipemplecod_Emptyitem ;
   private boolean Combo_tipemplecod_Includeaddnewoption ;
   private boolean Combo_empzoncod_Enabled ;
   private boolean Combo_empzoncod_Visible ;
   private boolean Combo_empzoncod_Allowmultipleselection ;
   private boolean Combo_empzoncod_Isgriditem ;
   private boolean Combo_empzoncod_Hasdescription ;
   private boolean Combo_empzoncod_Includeonlyselectedoption ;
   private boolean Combo_empzoncod_Includeselectalloption ;
   private boolean Combo_empzoncod_Emptyitem ;
   private boolean Combo_empzoncod_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV31IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean AV34CliMultiEmp ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String AV20Combo_DataJson ;
   private String Z2EmpNom ;
   private String Z126CatIvaDesc ;
   private String Z178EmpDir ;
   private String Z180EmpTel ;
   private String A2EmpNom ;
   private String A126CatIvaDesc ;
   private String A178EmpDir ;
   private String A180EmpTel ;
   private String A518EmpZonDescrip ;
   private String A312PaiNom ;
   private String A322ProvNom ;
   private String A286LocNom ;
   private String A683ActDescripSinAc ;
   private String A108ActDescrip ;
   private String AV18ComboSelectedValue ;
   private String AV19ComboSelectedText ;
   private String Z312PaiNom ;
   private String Z322ProvNom ;
   private String Z286LocNom ;
   private String Z683ActDescripSinAc ;
   private String Z108ActDescrip ;
   private String Z518EmpZonDescrip ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.webpanels.WebSession AV35Session ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_paicod ;
   private com.genexus.webpanels.GXUserControl ucCombo_provcod ;
   private com.genexus.webpanels.GXUserControl ucCombo_loccod ;
   private com.genexus.webpanels.GXUserControl ucCombo_actcodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_tipemplecod ;
   private com.genexus.webpanels.GXUserControl ucCombo_empzoncod ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkEmpReducc ;
   private HTMLChoice cmbTipEmpleDefIns ;
   private IDataStoreProvider pr_default ;
   private String[] T002B4_A312PaiNom ;
   private String[] T002B5_A322ProvNom ;
   private String[] T002B6_A286LocNom ;
   private String[] T002B8_A683ActDescripSinAc ;
   private String[] T002B8_A108ActDescrip ;
   private String[] T002B9_A530TipEmpleDefIns ;
   private String[] T002B10_A518EmpZonDescrip ;
   private String[] T002B11_A683ActDescripSinAc ;
   private short[] T002B11_A1EmpCod ;
   private String[] T002B11_A2EmpNom ;
   private long[] T002B11_A177EmpCUIT ;
   private short[] T002B11_A125CatIvaCod ;
   private boolean[] T002B11_n125CatIvaCod ;
   private String[] T002B11_A126CatIvaDesc ;
   private boolean[] T002B11_n126CatIvaDesc ;
   private String[] T002B11_A178EmpDir ;
   private String[] T002B11_A180EmpTel ;
   private boolean[] T002B11_n180EmpTel ;
   private String[] T002B11_A176EmpCP ;
   private boolean[] T002B11_n176EmpCP ;
   private String[] T002B11_A312PaiNom ;
   private String[] T002B11_A322ProvNom ;
   private String[] T002B11_A286LocNom ;
   private String[] T002B11_A108ActDescrip ;
   private String[] T002B11_A518EmpZonDescrip ;
   private boolean[] T002B11_A532EmpReducc ;
   private String[] T002B11_A530TipEmpleDefIns ;
   private short[] T002B11_A46PaiCod ;
   private boolean[] T002B11_n46PaiCod ;
   private short[] T002B11_A47ProvCod ;
   private boolean[] T002B11_n47ProvCod ;
   private short[] T002B11_A48LocCod ;
   private boolean[] T002B11_n48LocCod ;
   private int[] T002B11_A3CliCod ;
   private String[] T002B11_A43ActCodigo ;
   private boolean[] T002B11_n43ActCodigo ;
   private String[] T002B11_A45TipEmpleCod ;
   private boolean[] T002B11_n45TipEmpleCod ;
   private String[] T002B11_A44EmpZonCod ;
   private boolean[] T002B11_n44EmpZonCod ;
   private int[] T002B7_A3CliCod ;
   private int[] T002B12_A3CliCod ;
   private String[] T002B13_A312PaiNom ;
   private String[] T002B14_A322ProvNom ;
   private String[] T002B15_A286LocNom ;
   private String[] T002B16_A683ActDescripSinAc ;
   private String[] T002B16_A108ActDescrip ;
   private String[] T002B17_A530TipEmpleDefIns ;
   private String[] T002B18_A518EmpZonDescrip ;
   private int[] T002B19_A3CliCod ;
   private short[] T002B19_A1EmpCod ;
   private short[] T002B3_A1EmpCod ;
   private String[] T002B3_A2EmpNom ;
   private long[] T002B3_A177EmpCUIT ;
   private short[] T002B3_A125CatIvaCod ;
   private boolean[] T002B3_n125CatIvaCod ;
   private String[] T002B3_A126CatIvaDesc ;
   private boolean[] T002B3_n126CatIvaDesc ;
   private String[] T002B3_A178EmpDir ;
   private String[] T002B3_A180EmpTel ;
   private boolean[] T002B3_n180EmpTel ;
   private String[] T002B3_A176EmpCP ;
   private boolean[] T002B3_n176EmpCP ;
   private boolean[] T002B3_A532EmpReducc ;
   private short[] T002B3_A46PaiCod ;
   private boolean[] T002B3_n46PaiCod ;
   private short[] T002B3_A47ProvCod ;
   private boolean[] T002B3_n47ProvCod ;
   private short[] T002B3_A48LocCod ;
   private boolean[] T002B3_n48LocCod ;
   private int[] T002B3_A3CliCod ;
   private String[] T002B3_A43ActCodigo ;
   private boolean[] T002B3_n43ActCodigo ;
   private String[] T002B3_A45TipEmpleCod ;
   private boolean[] T002B3_n45TipEmpleCod ;
   private String[] T002B3_A44EmpZonCod ;
   private boolean[] T002B3_n44EmpZonCod ;
   private short[] T002B20_A1EmpCod ;
   private int[] T002B20_A3CliCod ;
   private short[] T002B21_A1EmpCod ;
   private int[] T002B21_A3CliCod ;
   private short[] T002B2_A1EmpCod ;
   private String[] T002B2_A2EmpNom ;
   private long[] T002B2_A177EmpCUIT ;
   private short[] T002B2_A125CatIvaCod ;
   private boolean[] T002B2_n125CatIvaCod ;
   private String[] T002B2_A126CatIvaDesc ;
   private boolean[] T002B2_n126CatIvaDesc ;
   private String[] T002B2_A178EmpDir ;
   private String[] T002B2_A180EmpTel ;
   private boolean[] T002B2_n180EmpTel ;
   private String[] T002B2_A176EmpCP ;
   private boolean[] T002B2_n176EmpCP ;
   private boolean[] T002B2_A532EmpReducc ;
   private short[] T002B2_A46PaiCod ;
   private boolean[] T002B2_n46PaiCod ;
   private short[] T002B2_A47ProvCod ;
   private boolean[] T002B2_n47ProvCod ;
   private short[] T002B2_A48LocCod ;
   private boolean[] T002B2_n48LocCod ;
   private int[] T002B2_A3CliCod ;
   private String[] T002B2_A43ActCodigo ;
   private boolean[] T002B2_n43ActCodigo ;
   private String[] T002B2_A45TipEmpleCod ;
   private boolean[] T002B2_n45TipEmpleCod ;
   private String[] T002B2_A44EmpZonCod ;
   private boolean[] T002B2_n44EmpZonCod ;
   private String[] T002B25_A312PaiNom ;
   private String[] T002B26_A322ProvNom ;
   private String[] T002B27_A286LocNom ;
   private String[] T002B28_A683ActDescripSinAc ;
   private String[] T002B28_A108ActDescrip ;
   private String[] T002B29_A530TipEmpleDefIns ;
   private String[] T002B30_A518EmpZonDescrip ;
   private int[] T002B31_A3CliCod ;
   private short[] T002B31_A1EmpCod ;
   private java.util.UUID[] T002B31_A2418BanSalCod ;
   private int[] T002B32_A3CliCod ;
   private short[] T002B32_A1EmpCod ;
   private java.util.UUID[] T002B32_A2380ColaUUID ;
   private int[] T002B33_A3CliCod ;
   private short[] T002B33_A1EmpCod ;
   private int[] T002B33_A2371LiqBatchLiqNro ;
   private String[] T002B33_A2372LiqBatchCod ;
   private String[] T002B33_A2373LiqBatchSeccion ;
   private int[] T002B34_A3CliCod ;
   private short[] T002B34_A1EmpCod ;
   private int[] T002B34_A2370LiqLoteLiqNro ;
   private String[] T002B34_A2269LiqLote ;
   private int[] T002B35_A3CliCod ;
   private short[] T002B35_A1EmpCod ;
   private int[] T002B35_A31LiqNro ;
   private int[] T002B35_A2285LinkLegNumero ;
   private String[] T002B35_A2277LegLinkTiporec ;
   private int[] T002B36_A3CliCod ;
   private short[] T002B36_A1EmpCod ;
   private int[] T002B36_A31LiqNro ;
   private String[] T002B36_A2183LiqSuc ;
   private int[] T002B37_A3CliCod ;
   private short[] T002B37_A1EmpCod ;
   private int[] T002B37_A31LiqNro ;
   private String[] T002B37_A2145LiqArea ;
   private int[] T002B38_A3CliCod ;
   private short[] T002B38_A1EmpCod ;
   private int[] T002B38_A31LiqNro ;
   private short[] T002B38_A2142LiqPaiConve ;
   private String[] T002B38_A2143LiqConvenio ;
   private int[] T002B39_A3CliCod ;
   private short[] T002B39_A1EmpCod ;
   private String[] T002B39_A1966EmpBanCod ;
   private int[] T002B40_A3CliCod ;
   private short[] T002B40_A1EmpCod ;
   private java.util.Date[] T002B40_A1729PeriodoLiq ;
   private int[] T002B41_A3CliCod ;
   private short[] T002B41_A1EmpCod ;
   private int[] T002B41_A1649LSDSec ;
   private int[] T002B42_A3CliCod ;
   private short[] T002B42_A1EmpCod ;
   private short[] T002B42_A1562EmpConvePai ;
   private String[] T002B42_A1561EmpConveCod ;
   private int[] T002B43_A3CliCod ;
   private short[] T002B43_A1EmpCod ;
   private short[] T002B43_A1562EmpConvePai ;
   private String[] T002B43_A1561EmpConveCod ;
   private int[] T002B44_A3CliCod ;
   private short[] T002B44_A1EmpCod ;
   private short[] T002B44_A1562EmpConvePai ;
   private String[] T002B44_A1561EmpConveCod ;
   private int[] T002B45_A3CliCod ;
   private short[] T002B45_A1EmpCod ;
   private short[] T002B45_A1562EmpConvePai ;
   private String[] T002B45_A1561EmpConveCod ;
   private int[] T002B46_A3CliCod ;
   private short[] T002B46_A1EmpCod ;
   private short[] T002B46_A1562EmpConvePai ;
   private String[] T002B46_A1561EmpConveCod ;
   private int[] T002B47_A3CliCod ;
   private short[] T002B47_A1EmpCod ;
   private short[] T002B47_A1562EmpConvePai ;
   private String[] T002B47_A1561EmpConveCod ;
   private int[] T002B48_A3CliCod ;
   private short[] T002B48_A1EmpCod ;
   private short[] T002B48_A1562EmpConvePai ;
   private String[] T002B48_A1561EmpConveCod ;
   private int[] T002B49_A3CliCod ;
   private short[] T002B49_A1EmpCod ;
   private short[] T002B49_A1562EmpConvePai ;
   private String[] T002B49_A1561EmpConveCod ;
   private int[] T002B50_A3CliCod ;
   private short[] T002B50_A1EmpCod ;
   private short[] T002B50_A1562EmpConvePai ;
   private String[] T002B50_A1561EmpConveCod ;
   private int[] T002B51_A3CliCod ;
   private short[] T002B51_A1EmpCod ;
   private short[] T002B51_A1562EmpConvePai ;
   private String[] T002B51_A1561EmpConveCod ;
   private int[] T002B52_A3CliCod ;
   private short[] T002B52_A1EmpCod ;
   private short[] T002B52_A1562EmpConvePai ;
   private String[] T002B52_A1561EmpConveCod ;
   private int[] T002B53_A3CliCod ;
   private short[] T002B53_A1EmpCod ;
   private short[] T002B53_A1562EmpConvePai ;
   private String[] T002B53_A1561EmpConveCod ;
   private int[] T002B54_A3CliCod ;
   private short[] T002B54_A1EmpCod ;
   private short[] T002B54_A1562EmpConvePai ;
   private String[] T002B54_A1561EmpConveCod ;
   private int[] T002B55_A3CliCod ;
   private short[] T002B55_A1EmpCod ;
   private short[] T002B55_A1562EmpConvePai ;
   private String[] T002B55_A1561EmpConveCod ;
   private int[] T002B56_A3CliCod ;
   private short[] T002B56_A1EmpCod ;
   private short[] T002B56_A1562EmpConvePai ;
   private String[] T002B56_A1561EmpConveCod ;
   private int[] T002B57_A3CliCod ;
   private short[] T002B57_A1EmpCod ;
   private short[] T002B57_A1562EmpConvePai ;
   private String[] T002B57_A1561EmpConveCod ;
   private int[] T002B58_A3CliCod ;
   private short[] T002B58_A1EmpCod ;
   private short[] T002B58_A1562EmpConvePai ;
   private String[] T002B58_A1561EmpConveCod ;
   private int[] T002B59_A3CliCod ;
   private short[] T002B59_A1EmpCod ;
   private short[] T002B59_A1562EmpConvePai ;
   private String[] T002B59_A1561EmpConveCod ;
   private int[] T002B60_A3CliCod ;
   private short[] T002B60_A1EmpCod ;
   private short[] T002B60_A1562EmpConvePai ;
   private String[] T002B60_A1561EmpConveCod ;
   private int[] T002B61_A3CliCod ;
   private short[] T002B61_A1EmpCod ;
   private short[] T002B61_A1562EmpConvePai ;
   private String[] T002B61_A1561EmpConveCod ;
   private int[] T002B62_A3CliCod ;
   private short[] T002B62_A1EmpCod ;
   private short[] T002B62_A1562EmpConvePai ;
   private String[] T002B62_A1561EmpConveCod ;
   private int[] T002B63_A3CliCod ;
   private short[] T002B63_A1EmpCod ;
   private short[] T002B63_A1562EmpConvePai ;
   private String[] T002B63_A1561EmpConveCod ;
   private int[] T002B64_A3CliCod ;
   private short[] T002B64_A1EmpCod ;
   private short[] T002B64_A1562EmpConvePai ;
   private String[] T002B64_A1561EmpConveCod ;
   private int[] T002B65_A3CliCod ;
   private short[] T002B65_A1EmpCod ;
   private short[] T002B65_A1562EmpConvePai ;
   private String[] T002B65_A1561EmpConveCod ;
   private int[] T002B66_A3CliCod ;
   private short[] T002B66_A1EmpCod ;
   private short[] T002B66_A1562EmpConvePai ;
   private String[] T002B66_A1561EmpConveCod ;
   private int[] T002B67_A3CliCod ;
   private short[] T002B67_A1EmpCod ;
   private short[] T002B67_A1562EmpConvePai ;
   private String[] T002B67_A1561EmpConveCod ;
   private int[] T002B68_A3CliCod ;
   private short[] T002B68_A1EmpCod ;
   private short[] T002B68_A1562EmpConvePai ;
   private String[] T002B68_A1561EmpConveCod ;
   private int[] T002B69_A3CliCod ;
   private short[] T002B69_A1EmpCod ;
   private short[] T002B69_A1562EmpConvePai ;
   private String[] T002B69_A1561EmpConveCod ;
   private int[] T002B70_A3CliCod ;
   private short[] T002B70_A1EmpCod ;
   private short[] T002B70_A1562EmpConvePai ;
   private String[] T002B70_A1561EmpConveCod ;
   private int[] T002B71_A3CliCod ;
   private short[] T002B71_A1EmpCod ;
   private short[] T002B71_A1562EmpConvePai ;
   private String[] T002B71_A1561EmpConveCod ;
   private int[] T002B72_A3CliCod ;
   private short[] T002B72_A1EmpCod ;
   private short[] T002B72_A1562EmpConvePai ;
   private String[] T002B72_A1561EmpConveCod ;
   private int[] T002B73_A3CliCod ;
   private short[] T002B73_A1EmpCod ;
   private short[] T002B73_A1562EmpConvePai ;
   private String[] T002B73_A1561EmpConveCod ;
   private int[] T002B74_A3CliCod ;
   private short[] T002B74_A1EmpCod ;
   private short[] T002B74_A1562EmpConvePai ;
   private String[] T002B74_A1561EmpConveCod ;
   private int[] T002B75_A3CliCod ;
   private short[] T002B75_A1EmpCod ;
   private short[] T002B75_A1562EmpConvePai ;
   private String[] T002B75_A1561EmpConveCod ;
   private int[] T002B76_A3CliCod ;
   private short[] T002B76_A1EmpCod ;
   private short[] T002B76_A1562EmpConvePai ;
   private String[] T002B76_A1561EmpConveCod ;
   private int[] T002B77_A3CliCod ;
   private short[] T002B77_A1EmpCod ;
   private short[] T002B77_A1562EmpConvePai ;
   private String[] T002B77_A1561EmpConveCod ;
   private int[] T002B78_A3CliCod ;
   private short[] T002B78_A1EmpCod ;
   private short[] T002B78_A1562EmpConvePai ;
   private String[] T002B78_A1561EmpConveCod ;
   private int[] T002B79_A3CliCod ;
   private short[] T002B79_A1EmpCod ;
   private short[] T002B79_A1562EmpConvePai ;
   private String[] T002B79_A1561EmpConveCod ;
   private int[] T002B80_A3CliCod ;
   private short[] T002B80_A1EmpCod ;
   private short[] T002B80_A1562EmpConvePai ;
   private String[] T002B80_A1561EmpConveCod ;
   private int[] T002B81_A3CliCod ;
   private short[] T002B81_A1EmpCod ;
   private short[] T002B81_A1562EmpConvePai ;
   private String[] T002B81_A1561EmpConveCod ;
   private int[] T002B82_A3CliCod ;
   private short[] T002B82_A1EmpCod ;
   private short[] T002B82_A1562EmpConvePai ;
   private String[] T002B82_A1561EmpConveCod ;
   private int[] T002B83_A3CliCod ;
   private short[] T002B83_A1EmpCod ;
   private short[] T002B83_A1562EmpConvePai ;
   private String[] T002B83_A1561EmpConveCod ;
   private int[] T002B84_A3CliCod ;
   private short[] T002B84_A1EmpCod ;
   private short[] T002B84_A1562EmpConvePai ;
   private String[] T002B84_A1561EmpConveCod ;
   private int[] T002B85_A3CliCod ;
   private short[] T002B85_A1EmpCod ;
   private short[] T002B85_A1562EmpConvePai ;
   private String[] T002B85_A1561EmpConveCod ;
   private int[] T002B86_A3CliCod ;
   private short[] T002B86_A1EmpCod ;
   private short[] T002B86_A1562EmpConvePai ;
   private String[] T002B86_A1561EmpConveCod ;
   private int[] T002B87_A3CliCod ;
   private short[] T002B87_A1EmpCod ;
   private short[] T002B87_A1562EmpConvePai ;
   private String[] T002B87_A1561EmpConveCod ;
   private int[] T002B88_A3CliCod ;
   private short[] T002B88_A1EmpCod ;
   private short[] T002B88_A1562EmpConvePai ;
   private String[] T002B88_A1561EmpConveCod ;
   private int[] T002B89_A3CliCod ;
   private short[] T002B89_A1EmpCod ;
   private short[] T002B89_A1562EmpConvePai ;
   private String[] T002B89_A1561EmpConveCod ;
   private int[] T002B90_A3CliCod ;
   private short[] T002B90_A1EmpCod ;
   private short[] T002B90_A1562EmpConvePai ;
   private String[] T002B90_A1561EmpConveCod ;
   private int[] T002B91_A3CliCod ;
   private short[] T002B91_A1EmpCod ;
   private short[] T002B91_A1562EmpConvePai ;
   private String[] T002B91_A1561EmpConveCod ;
   private int[] T002B92_A3CliCod ;
   private short[] T002B92_A1EmpCod ;
   private short[] T002B92_A1562EmpConvePai ;
   private String[] T002B92_A1561EmpConveCod ;
   private int[] T002B93_A3CliCod ;
   private short[] T002B93_A1EmpCod ;
   private short[] T002B93_A1562EmpConvePai ;
   private String[] T002B93_A1561EmpConveCod ;
   private int[] T002B94_A3CliCod ;
   private short[] T002B94_A1EmpCod ;
   private short[] T002B94_A1562EmpConvePai ;
   private String[] T002B94_A1561EmpConveCod ;
   private int[] T002B95_A3CliCod ;
   private short[] T002B95_A1EmpCod ;
   private short[] T002B95_A1562EmpConvePai ;
   private String[] T002B95_A1561EmpConveCod ;
   private int[] T002B96_A3CliCod ;
   private short[] T002B96_A1EmpCod ;
   private short[] T002B96_A1562EmpConvePai ;
   private String[] T002B96_A1561EmpConveCod ;
   private int[] T002B97_A3CliCod ;
   private short[] T002B97_A1EmpCod ;
   private short[] T002B97_A1562EmpConvePai ;
   private String[] T002B97_A1561EmpConveCod ;
   private int[] T002B98_A3CliCod ;
   private short[] T002B98_A1EmpCod ;
   private short[] T002B98_A1547GuarCod ;
   private int[] T002B99_A3CliCod ;
   private short[] T002B99_A1EmpCod ;
   private byte[] T002B99_A1427EmpBaseClaseLeg ;
   private String[] T002B99_A1429EmpBaseTipo ;
   private String[] T002B99_A1430EmpBaseCod1 ;
   private String[] T002B99_A1431EmpBaseCod2 ;
   private int[] T002B100_A3CliCod ;
   private short[] T002B100_A1EmpCod ;
   private String[] T002B100_A37TipoConCod ;
   private String[] T002B100_A1371EmpPromFijVar ;
   private int[] T002B101_A3CliCod ;
   private short[] T002B101_A1EmpCod ;
   private String[] T002B101_A1366EmpJorConCodigo ;
   private int[] T002B102_A3CliCod ;
   private short[] T002B102_A1EmpCod ;
   private String[] T002B102_A1368EmpMenConCodigo ;
   private int[] T002B103_A3CliCod ;
   private short[] T002B103_A1EmpCod ;
   private String[] T002B103_A1294PaiTipoTraId ;
   private int[] T002B104_A3CliCod ;
   private short[] T002B104_A1EmpCod ;
   private short[] T002B104_A1340EmpHsExSec ;
   private int[] T002B105_A3CliCod ;
   private short[] T002B105_A1EmpCod ;
   private String[] T002B105_A1243SucCodigo ;
   private int[] T002B106_A3CliCod ;
   private short[] T002B106_A1EmpCod ;
   private String[] T002B106_A1237EmpReligion ;
   private int[] T002B107_A3CliCod ;
   private short[] T002B107_A1EmpCod ;
   private String[] T002B107_A1238EmpOrigen ;
   private int[] T002B108_A3CliCod ;
   private short[] T002B108_A1EmpCod ;
   private String[] T002B108_A1239EmpConvenio ;
   private int[] T002B109_A3CliCod ;
   private short[] T002B109_A1EmpCod ;
   private byte[] T002B109_A784F1357CTipoPre ;
   private String[] T002B109_A777F1357CPer ;
   private byte[] T002B109_A778F1357CSec ;
   private int[] T002B110_A3CliCod ;
   private short[] T002B110_A1EmpCod ;
   private short[] T002B110_A88ImpLiqSec ;
   private int[] T002B111_A3CliCod ;
   private short[] T002B111_A1EmpCod ;
   private int[] T002B111_A87MigrLegNumero ;
   private int[] T002B112_A3CliCod ;
   private short[] T002B112_A1EmpCod ;
   private short[] T002B112_A86TempRecSec ;
   private int[] T002B113_A3CliCod ;
   private short[] T002B113_A1EmpCod ;
   private java.util.Date[] T002B113_A85ArchSiradigFec ;
   private int[] T002B114_A3CliCod ;
   private short[] T002B114_A1EmpCod ;
   private int[] T002B114_A79AsientoCNum ;
   private int[] T002B115_A3CliCod ;
   private short[] T002B115_A1EmpCod ;
   private String[] T002B115_A78CuenCodigo ;
   private int[] T002B116_A3CliCod ;
   private short[] T002B116_A1EmpCod ;
   private short[] T002B116_A77CenCodigo ;
   private int[] T002B117_A3CliCod ;
   private short[] T002B117_A1EmpCod ;
   private int[] T002B117_A31LiqNro ;
   private String[] T002B117_A10LpgCodigo ;
   private int[] T002B118_A3CliCod ;
   private short[] T002B118_A1EmpCod ;
   private int[] T002B118_A6LegNumero ;
   private int[] T002B119_A3CliCod ;
   private short[] T002B119_A1EmpCod ;
   private int[] T002B120_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV16PaiCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV22ProvCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV25LocCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV28ActCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV41TipEmpleCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV37EmpZonCod_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV15TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV17DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class liqimportarauxtrn__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T002B2", "SELECT EmpCod, EmpNom, EmpCUIT, CatIvaCod, CatIvaDesc, EmpDir, EmpTel, EmpCP, EmpReducc, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, EmpZonCod FROM Empresa WHERE CliCod = ? AND EmpCod = ?  FOR UPDATE OF Empresa NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B3", "SELECT EmpCod, EmpNom, EmpCUIT, CatIvaCod, CatIvaDesc, EmpDir, EmpTel, EmpCP, EmpReducc, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, EmpZonCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B4", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B5", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B6", "SELECT LocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B7", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B8", "SELECT ActDescripSinAc, ActDescrip FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B9", "SELECT TipEmpleDefIns FROM TipoEmpleador WHERE TipEmpleCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B10", "SELECT ZonDescrip AS EmpZonDescrip FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B11", "SELECT T5.ActDescripSinAc, TM1.EmpCod, TM1.EmpNom, TM1.EmpCUIT, TM1.CatIvaCod, TM1.CatIvaDesc, TM1.EmpDir, TM1.EmpTel, TM1.EmpCP, T2.PaiNom, T3.ProvNom, T4.LocNom, T5.ActDescrip, T7.ZonDescrip AS EmpZonDescrip, TM1.EmpReducc, T6.TipEmpleDefIns, TM1.PaiCod, TM1.ProvCod, TM1.LocCod, TM1.CliCod, TM1.ActCodigo, TM1.TipEmpleCod, TM1.EmpZonCod AS EmpZonCod FROM ((((((Empresa TM1 LEFT JOIN Pais T2 ON T2.PaiCod = TM1.PaiCod) LEFT JOIN Provincia T3 ON T3.PaiCod = TM1.PaiCod AND T3.ProvCod = TM1.ProvCod) LEFT JOIN Localidad T4 ON T4.PaiCod = TM1.PaiCod AND T4.ProvCod = TM1.ProvCod AND T4.LocCod = TM1.LocCod) LEFT JOIN Actividad T5 ON T5.ActCodigo = TM1.ActCodigo) LEFT JOIN TipoEmpleador T6 ON T6.TipEmpleCod = TM1.TipEmpleCod) LEFT JOIN Zona T7 ON T7.ZonCod = TM1.EmpZonCod) WHERE TM1.EmpCod = ? and TM1.CliCod = ? ORDER BY TM1.CliCod, TM1.EmpCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B12", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B13", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B14", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B15", "SELECT LocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B16", "SELECT ActDescripSinAc, ActDescrip FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B17", "SELECT TipEmpleDefIns FROM TipoEmpleador WHERE TipEmpleCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B18", "SELECT ZonDescrip AS EmpZonDescrip FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B19", "SELECT CliCod, EmpCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B20", "SELECT EmpCod, CliCod FROM Empresa WHERE ( EmpCod > ? or EmpCod = ? and CliCod > ?) ORDER BY CliCod, EmpCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B21", "SELECT EmpCod, CliCod FROM Empresa WHERE ( EmpCod < ? or EmpCod = ? and CliCod < ?) ORDER BY CliCod DESC, EmpCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T002B22", "SAVEPOINT gxupdate;INSERT INTO Empresa(EmpCod, EmpNom, EmpCUIT, CatIvaCod, CatIvaDesc, EmpDir, EmpTel, EmpCP, EmpReducc, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, EmpZonCod, EmpLogo, EmpLogoNom, EmpLogoExt, EmpFirma, EmpFirmaNom, EmpFirmaExt, EmpAntiguedad, EmpPresentismo, ARTSec, EmpMesHsPExt, EmpDiaHsPExt, EmpLiqFer, EmpActComercial, EmpGuarEdadMin, EmpGuarEdadMax, ActComCodigo, EmpLiqFerJor, EmpLiqGan, EmpTipoExp, EmpPromDesde, EmpPerVacDes, EmpPerVacHas, EmpFracVacAnt, EmpOsoCod, EmpUltSexoIng, EmpCondiCod, EmpVacExpLim, EmpVacExpTie, EmpVacDisMax, EmpModTra, EmpModEmpl, EmpModAuto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', '', '', '', '', '', 0, 0, 0, 0, '', FALSE, '', 0, 0, '', FALSE, FALSE, 0, '', 0, 0, 0, '', 0, 0, FALSE, 0, 0, '', FALSE, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002B23", "SAVEPOINT gxupdate;UPDATE Empresa SET EmpNom=?, EmpCUIT=?, CatIvaCod=?, CatIvaDesc=?, EmpDir=?, EmpTel=?, EmpCP=?, EmpReducc=?, PaiCod=?, ProvCod=?, LocCod=?, ActCodigo=?, TipEmpleCod=?, EmpZonCod=?  WHERE CliCod = ? AND EmpCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002B24", "SAVEPOINT gxupdate;DELETE FROM Empresa  WHERE CliCod = ? AND EmpCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002B25", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B26", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B27", "SELECT LocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B28", "SELECT ActDescripSinAc, ActDescrip FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B29", "SELECT TipEmpleDefIns FROM TipoEmpleador WHERE TipEmpleCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B30", "SELECT ZonDescrip AS EmpZonDescrip FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B31", "SELECT CliCod, EmpCod, BanSalCod FROM banda_salarial WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B32", "SELECT CliCod, EmpCod, ColaUUID FROM Cola WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B33", "SELECT CliCod, EmpCod, LiqBatchLiqNro, LiqBatchCod, LiqBatchSeccion FROM LiquidacionLotes3 WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B34", "SELECT CliCod, EmpCod, LiqLoteLiqNro, LiqLote FROM LiquidacionLotes2 WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B35", "SELECT CliCod, EmpCod, LiqNro, LinkLegNumero, LegLinkTiporec FROM LiquidacionLegajoLinkPdf WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B36", "SELECT CliCod, EmpCod, LiqNro, LiqSuc FROM LiquidacionSucursal WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B37", "SELECT CliCod, EmpCod, LiqNro, LiqArea FROM LiquidacionArea WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B38", "SELECT CliCod, EmpCod, LiqNro, LiqPaiConve, LiqConvenio FROM LiquidacionConvenio WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B39", "SELECT CliCod, EmpCod, EmpBanCod FROM EmpresaBancos WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B40", "SELECT CliCod, EmpCod, PeriodoLiq FROM Periodo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B41", "SELECT CliCod, EmpCod, LSDSec FROM LSD_reg1 WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B42", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE EmpConveVer = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B43", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B44", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B45", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B46", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B47", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B48", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B49", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B50", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B51", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B52", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B53", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B54", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B55", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B56", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B57", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B58", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B59", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B60", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B61", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B62", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B63", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B64", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B65", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B66", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B67", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B68", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B69", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B70", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B71", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B72", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B73", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B74", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B75", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B76", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B77", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B78", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B79", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B80", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B81", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B82", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B83", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B84", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B85", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B86", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B87", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B88", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B89", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B90", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B91", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B92", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B93", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B94", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B95", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B96", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B97", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B98", "SELECT CliCod, EmpCod, GuarCod FROM EmpresaGuarderias WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B99", "SELECT CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2 FROM Empresabase_calculo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B100", "SELECT CliCod, EmpCod, TipoConCod, EmpPromFijVar FROM Empresapromedio_horanormal_mensualizados WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B101", "SELECT CliCod, EmpCod, EmpJorConCodigo FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B102", "SELECT CliCod, EmpCod, EmpMenConCodigo FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B103", "SELECT CliCod, EmpCod, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B104", "SELECT CliCod, EmpCod, EmpHsExSec FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B105", "SELECT CliCod, EmpCod, SucCodigo FROM Sucursal WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B106", "SELECT CliCod, EmpCod, EmpReligion FROM Empresanolaborables_religion WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B107", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B108", "SELECT CliCod, EmpCod, EmpConvenio FROM Empresanolaborables_convenio WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B109", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357Cab WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B110", "SELECT CliCod, EmpCod, ImpLiqSec FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B111", "SELECT CliCod, EmpCod, MigrLegNumero FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B112", "SELECT CliCod, EmpCod, TempRecSec FROM TemplateRecibo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B113", "SELECT CliCod, EmpCod, ArchSiradigFec FROM archivo_siradig WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B114", "SELECT CliCod, EmpCod, AsientoCNum FROM AsientoCab WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B115", "SELECT CliCod, EmpCod, CuenCodigo FROM CuentaContable WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B116", "SELECT CliCod, EmpCod, CenCodigo FROM CentroDeCosto WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B117", "SELECT CliCod, EmpCod, LiqNro, LpgCodigo FROM LiquidacionLugarPago WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B118", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002B119", "SELECT CliCod, EmpCod FROM Empresa ORDER BY CliCod, EmpCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002B120", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((boolean[]) buf[12])[0] = rslt.getBoolean(9);
               ((short[]) buf[13])[0] = rslt.getShort(10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((short[]) buf[17])[0] = rslt.getShort(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((int[]) buf[19])[0] = rslt.getInt(13);
               ((String[]) buf[20])[0] = rslt.getString(14, 8);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getString(15, 4);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((boolean[]) buf[12])[0] = rslt.getBoolean(9);
               ((short[]) buf[13])[0] = rslt.getShort(10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((short[]) buf[17])[0] = rslt.getShort(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((int[]) buf[19])[0] = rslt.getInt(13);
               ((String[]) buf[20])[0] = rslt.getString(14, 8);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getString(15, 4);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(10);
               ((String[]) buf[14])[0] = rslt.getVarchar(11);
               ((String[]) buf[15])[0] = rslt.getVarchar(12);
               ((String[]) buf[16])[0] = rslt.getVarchar(13);
               ((String[]) buf[17])[0] = rslt.getVarchar(14);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(15);
               ((String[]) buf[19])[0] = rslt.getString(16, 1);
               ((short[]) buf[20])[0] = rslt.getShort(17);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((short[]) buf[22])[0] = rslt.getShort(18);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((short[]) buf[24])[0] = rslt.getShort(19);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((int[]) buf[26])[0] = rslt.getInt(20);
               ((String[]) buf[27])[0] = rslt.getString(21, 8);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getString(22, 4);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 18 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 23 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 25 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 26 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               return;
            case 28 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.UUID[]) buf[2])[0] = rslt.getGUID(3);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.UUID[]) buf[2])[0] = rslt.getGUID(3);
               return;
            case 31 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 32 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 34 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 35 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 36 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 37 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               return;
            case 38 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               return;
            case 39 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 40 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 41 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 42 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 43 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 44 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 45 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 46 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 47 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 48 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 49 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 50 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 51 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 52 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 53 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 54 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 55 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 56 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 57 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 58 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 59 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
      }
      getresults60( cursor, rslt, buf) ;
   }

   public void getresults60( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 60 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 61 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 62 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 63 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 64 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 65 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 66 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 67 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 68 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 69 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 70 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 71 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 72 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 73 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 74 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 75 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 76 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 77 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 78 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 79 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 80 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 81 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 82 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 83 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 84 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 85 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 86 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 87 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 88 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 89 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
      }
      getresults90( cursor, rslt, buf) ;
   }

   public void getresults90( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 90 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 91 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 92 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 93 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 94 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 95 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 96 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 97 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 98 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 99 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 100 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 101 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 102 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 103 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 104 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 105 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 106 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 107 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 108 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 109 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 110 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 111 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               return;
            case 112 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 113 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 114 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 115 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 116 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 117 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 118 :
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
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
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 8);
               }
               return;
            case 7 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 13 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 14 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 8);
               }
               return;
            case 15 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 16 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setLong(3, ((Number) parms[2]).longValue());
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(4, ((Number) parms[4]).shortValue());
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(5, (String)parms[6], 30);
               }
               stmt.setVarchar(6, (String)parms[7], 40, false);
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(7, (String)parms[9], 30);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[11], 20);
               }
               stmt.setBoolean(9, ((Boolean) parms[12]).booleanValue());
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(10, ((Number) parms[14]).shortValue());
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(11, ((Number) parms[16]).shortValue());
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(12, ((Number) parms[18]).shortValue());
               }
               stmt.setInt(13, ((Number) parms[19]).intValue());
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(14, (String)parms[21], 8);
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(15, (String)parms[23], 4);
               }
               if ( ((Boolean) parms[24]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(16, (String)parms[25], 20);
               }
               return;
            case 21 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(4, (String)parms[5], 30);
               }
               stmt.setVarchar(5, (String)parms[6], 40, false);
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(6, (String)parms[8], 30);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[10], 20);
               }
               stmt.setBoolean(8, ((Boolean) parms[11]).booleanValue());
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(9, ((Number) parms[13]).shortValue());
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(10, ((Number) parms[15]).shortValue());
               }
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(11, ((Number) parms[17]).shortValue());
               }
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(12, (String)parms[19], 8);
               }
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(13, (String)parms[21], 4);
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(14, (String)parms[23], 20);
               }
               stmt.setInt(15, ((Number) parms[24]).intValue());
               stmt.setShort(16, ((Number) parms[25]).shortValue());
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 23 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 24 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 25 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 26 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 8);
               }
               return;
            case 27 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 28 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 32 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 34 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 36 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 37 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 38 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 39 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 40 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 41 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 42 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 43 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 44 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 45 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 46 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 47 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 48 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 49 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 50 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 51 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 52 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 53 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 54 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 55 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 56 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 57 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 58 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 59 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
      setparameters60( cursor, stmt, parms) ;
   }

   public void setparameters60( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 60 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 61 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 62 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 63 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 64 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 65 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 66 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 67 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 68 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 69 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 70 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 71 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 72 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 73 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 74 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 75 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 76 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 77 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 78 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 79 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 80 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 81 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 82 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 83 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 84 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 85 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 86 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 87 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 88 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 89 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
      setparameters90( cursor, stmt, parms) ;
   }

   public void setparameters90( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 90 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 91 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 92 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 93 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 94 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 95 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 96 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 97 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 98 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 99 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 100 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 101 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 102 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 103 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 104 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 105 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 106 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 107 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 108 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 109 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 110 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 111 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 112 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 113 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 114 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 115 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 116 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 118 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

