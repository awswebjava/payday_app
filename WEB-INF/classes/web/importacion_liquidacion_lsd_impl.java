package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importacion_liquidacion_lsd_impl extends GXDataArea
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
      gxfirstwebparm = httpContext.GetNextPar( ) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_3") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A88ImpLiqSec = (short)(GXutil.lval( httpContext.GetPar( "ImpLiqSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_3( A3CliCod, A1EmpCod, A88ImpLiqSec) ;
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
         gxfirstwebparm = httpContext.GetNextPar( ) ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetNextPar( ) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "importacion_liquidacion_lsd", ""), (short)(0)) ;
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

   public importacion_liquidacion_lsd_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importacion_liquidacion_lsd_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importacion_liquidacion_lsd_impl.class ));
   }

   public importacion_liquidacion_lsd_impl( int remoteHandle ,
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
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.workwithplusmasterpage");
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
      web.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "WWAdvancedContainer", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8 col-sm-offset-2", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTitlecontainer_Internalname, 1, 0, "px", 0, "px", "TableTop", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "importacion_liquidacion_lsd", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_liquidacion_lsd.htm");
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
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8 col-sm-offset-2", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divFormcontainer_Internalname, 1, 0, "px", 0, "px", "FormContainer", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divToolbarcell_Internalname, 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3 ToolbarCellClass", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "btn-group", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
      ClassString = "BtnFirst" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_liquidacion_lsd.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_liquidacion_lsd.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_liquidacion_lsd.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_liquidacion_lsd.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_importacion_liquidacion_lsd.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCellAdvanced", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliCod_Internalname, httpContext.getMessage( "Cli Cod", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_importacion_liquidacion_lsd.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpCod_Internalname, httpContext.getMessage( "Empresa", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_importacion_liquidacion_lsd.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtImpLiqSec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtImpLiqSec_Internalname, httpContext.getMessage( "Imp Liq Sec", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtImpLiqSec_Internalname, GXutil.ltrim( localUtil.ntoc( A88ImpLiqSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtImpLiqSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A88ImpLiqSec), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A88ImpLiqSec), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtImpLiqSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtImpLiqSec_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_importacion_liquidacion_lsd.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtImpLiqLSDSec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtImpLiqLSDSec_Internalname, httpContext.getMessage( "Liq LSDSec", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtImpLiqLSDSec_Internalname, GXutil.ltrim( localUtil.ntoc( A704ImpLiqLSDSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtImpLiqLSDSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A704ImpLiqLSDSec), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A704ImpLiqLSDSec), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtImpLiqLSDSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtImpLiqLSDSec_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_importacion_liquidacion_lsd.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtImpLiqLSDFile_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtImpLiqLSDFile_Internalname, httpContext.getMessage( "Liq LSDFile", ""), "col-sm-3 ImageLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      ClassString = "Image" ;
      StyleString = "" ;
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      edtImpLiqLSDFile_Filename = A706ImpLiqLSDFileName ;
      edtImpLiqLSDFile_Filetype = "" ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqLSDFile_Internalname, "Filetype", edtImpLiqLSDFile_Filetype, true);
      edtImpLiqLSDFile_Filetype = A707ImpLiqLSDFileType ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqLSDFile_Internalname, "Filetype", edtImpLiqLSDFile_Filetype, true);
      if ( ! (GXutil.strcmp("", A705ImpLiqLSDFile)==0) )
      {
         gxblobfileaux.setSource( A705ImpLiqLSDFile );
         if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtImpLiqLSDFile_Filetype, "tmp") != 0 ) )
         {
            gxblobfileaux.setExt(GXutil.trim( edtImpLiqLSDFile_Filetype));
         }
         if ( gxblobfileaux.getErrCode() == 0 )
         {
            A705ImpLiqLSDFile = gxblobfileaux.getURI() ;
            httpContext.ajax_rsp_assign_attri("", false, "A705ImpLiqLSDFile", A705ImpLiqLSDFile);
            httpContext.ajax_rsp_assign_prop("", false, edtImpLiqLSDFile_Internalname, "URL", httpContext.getResourceRelative(A705ImpLiqLSDFile), true);
            edtImpLiqLSDFile_Filetype = gxblobfileaux.getExtension() ;
            httpContext.ajax_rsp_assign_prop("", false, edtImpLiqLSDFile_Internalname, "Filetype", edtImpLiqLSDFile_Filetype, true);
            gxblobfileaux.setBlobToDelete();
         }
         httpContext.ajax_rsp_assign_prop("", false, edtImpLiqLSDFile_Internalname, "URL", httpContext.getResourceRelative(A705ImpLiqLSDFile), true);
      }
      web.GxWebStd.gx_blob_field( httpContext, edtImpLiqLSDFile_Internalname, GXutil.rtrim( A705ImpLiqLSDFile), httpContext.getResourceRelative(A705ImpLiqLSDFile), ((GXutil.strcmp("", edtImpLiqLSDFile_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtImpLiqLSDFile_Filetype)==0) ? A705ImpLiqLSDFile : edtImpLiqLSDFile_Filetype)) : edtImpLiqLSDFile_Contenttype), true, "", edtImpLiqLSDFile_Parameters, 0, edtImpLiqLSDFile_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtImpLiqLSDFile_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", "", "", "HLP_importacion_liquidacion_lsd.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtImpLiqLSDFileNameAndType_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtImpLiqLSDFileNameAndType_Internalname, httpContext.getMessage( "And Type", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtImpLiqLSDFileNameAndType_Internalname, A708ImpLiqLSDFileNameAndType, GXutil.rtrim( localUtil.format( A708ImpLiqLSDFileNameAndType, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtImpLiqLSDFileNameAndType_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtImpLiqLSDFileNameAndType_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_liquidacion_lsd.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group Confirm", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_liquidacion_lsd.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_liquidacion_lsd.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_liquidacion_lsd.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
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
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z88ImpLiqSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z88ImpLiqSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z704ImpLiqLSDSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z704ImpLiqLSDSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z708ImpLiqLSDFileNameAndType = httpContext.cgiGet( "Z708ImpLiqLSDFileNameAndType") ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         A706ImpLiqLSDFileName = httpContext.cgiGet( "IMPLIQLSDFILENAME") ;
         A707ImpLiqLSDFileType = httpContext.cgiGet( "IMPLIQLSDFILETYPE") ;
         edtImpLiqLSDFile_Filetype = httpContext.cgiGet( "IMPLIQLSDFILE_Filetype") ;
         edtImpLiqLSDFile_Filename = httpContext.cgiGet( "IMPLIQLSDFILE_Filename") ;
         edtImpLiqLSDFile_Filename = httpContext.cgiGet( "IMPLIQLSDFILE_Filename") ;
         edtImpLiqLSDFile_Filetype = httpContext.cgiGet( "IMPLIQLSDFILE_Filetype") ;
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
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtImpLiqSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtImpLiqSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "IMPLIQSEC");
            AnyError = (short)(1) ;
            GX_FocusControl = edtImpLiqSec_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A88ImpLiqSec = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
         }
         else
         {
            A88ImpLiqSec = (short)(localUtil.ctol( httpContext.cgiGet( edtImpLiqSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtImpLiqLSDSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtImpLiqLSDSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "IMPLIQLSDSEC");
            AnyError = (short)(1) ;
            GX_FocusControl = edtImpLiqLSDSec_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A704ImpLiqLSDSec = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A704ImpLiqLSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A704ImpLiqLSDSec), 4, 0));
         }
         else
         {
            A704ImpLiqLSDSec = (short)(localUtil.ctol( httpContext.cgiGet( edtImpLiqLSDSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A704ImpLiqLSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A704ImpLiqLSDSec), 4, 0));
         }
         A705ImpLiqLSDFile = httpContext.cgiGet( edtImpLiqLSDFile_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A705ImpLiqLSDFile", A705ImpLiqLSDFile);
         A708ImpLiqLSDFileNameAndType = httpContext.cgiGet( edtImpLiqLSDFileNameAndType_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A708ImpLiqLSDFileNameAndType", A708ImpLiqLSDFileNameAndType);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         if ( ! (GXutil.strcmp("", A705ImpLiqLSDFile)==0) )
         {
            edtImpLiqLSDFile_Filename = httpContext.cgiGetFileName( edtImpLiqLSDFile_Internalname) ;
            edtImpLiqLSDFile_Filetype = httpContext.cgiGetFileType( edtImpLiqLSDFile_Internalname) ;
         }
         A707ImpLiqLSDFileType = edtImpLiqLSDFile_Filetype ;
         httpContext.ajax_rsp_assign_attri("", false, "A707ImpLiqLSDFileType", A707ImpLiqLSDFileType);
         A706ImpLiqLSDFileName = edtImpLiqLSDFile_Filename ;
         httpContext.ajax_rsp_assign_attri("", false, "A706ImpLiqLSDFileName", A706ImpLiqLSDFileName);
         if ( (GXutil.strcmp("", A705ImpLiqLSDFile)==0) )
         {
            GXCCtlgxBlob = "IMPLIQLSDFILE" + "_gxBlob" ;
            A705ImpLiqLSDFile = httpContext.cgiGet( GXCCtlgxBlob) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", "hsh"+"importacion_liquidacion_lsd");
         A708ImpLiqLSDFileNameAndType = httpContext.cgiGet( edtImpLiqLSDFileNameAndType_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A708ImpLiqLSDFileNameAndType", A708ImpLiqLSDFileNameAndType);
         forbiddenHiddens.add("ImpLiqLSDFileNameAndType", GXutil.rtrim( localUtil.format( A708ImpLiqLSDFileNameAndType, "")));
         hsh = httpContext.cgiGet( "hsh") ;
         if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( A704ImpLiqLSDSec != Z704ImpLiqLSDSec ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("importacion_liquidacion_lsd:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
            A88ImpLiqSec = (short)(GXutil.lval( httpContext.GetPar( "ImpLiqSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
            A704ImpLiqLSDSec = (short)(GXutil.lval( httpContext.GetPar( "ImpLiqLSDSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A704ImpLiqLSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A704ImpLiqLSDSec), 4, 0));
            getEqualNoModal( ) ;
            Gx_mode = "DSP" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            disable_std_buttons_dsp( ) ;
            standaloneModal( ) ;
         }
         else
         {
            Gx_mode = "INS" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            standaloneModal( ) ;
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
                     if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_enter( ) ;
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                     else if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_first( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "PREVIOUS") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_previous( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_next( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_last( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "SELECT") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_select( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "DELETE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_delete( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        afterkeyloadscreen( ) ;
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
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll2C79( ) ;
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
      if ( isIns( ) )
      {
         bttBtn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
   }

   public void disable_std_buttons_dsp( )
   {
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      bttBtn_first_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_first_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_first_Visible), 5, 0), true);
      bttBtn_previous_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_previous_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_previous_Visible), 5, 0), true);
      bttBtn_next_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_next_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_next_Visible), 5, 0), true);
      bttBtn_last_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_last_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_last_Visible), 5, 0), true);
      bttBtn_select_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_select_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_select_Visible), 5, 0), true);
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      if ( isDsp( ) )
      {
         bttBtn_enter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Visible), 5, 0), true);
      }
      disableAttributes2C79( ) ;
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

   public void resetCaption2C0( )
   {
   }

   public void zm2C79( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z708ImpLiqLSDFileNameAndType = T002C3_A708ImpLiqLSDFileNameAndType[0] ;
         }
         else
         {
            Z708ImpLiqLSDFileNameAndType = A708ImpLiqLSDFileNameAndType ;
         }
      }
      if ( GX_JID == -2 )
      {
         Z708ImpLiqLSDFileNameAndType = A708ImpLiqLSDFileNameAndType ;
         Z704ImpLiqLSDSec = A704ImpLiqLSDSec ;
         Z705ImpLiqLSDFile = A705ImpLiqLSDFile ;
         Z707ImpLiqLSDFileType = A707ImpLiqLSDFileType ;
         Z706ImpLiqLSDFileName = A706ImpLiqLSDFileName ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
      A708ImpLiqLSDFileNameAndType = GXutil.trim( A706ImpLiqLSDFileName) + "." + GXutil.trim( A707ImpLiqLSDFileType) ;
      httpContext.ajax_rsp_assign_attri("", false, "A708ImpLiqLSDFileNameAndType", A708ImpLiqLSDFileNameAndType);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         bttBtn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_delete_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
   }

   public void load2C79( )
   {
      /* Using cursor T002C5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A704ImpLiqLSDSec)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound79 = (short)(1) ;
         A708ImpLiqLSDFileNameAndType = T002C5_A708ImpLiqLSDFileNameAndType[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A708ImpLiqLSDFileNameAndType", A708ImpLiqLSDFileNameAndType);
         A705ImpLiqLSDFile = T002C5_A705ImpLiqLSDFile[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A705ImpLiqLSDFile", A705ImpLiqLSDFile);
         httpContext.ajax_rsp_assign_prop("", false, edtImpLiqLSDFile_Internalname, "URL", httpContext.getResourceRelative(A705ImpLiqLSDFile), true);
         A707ImpLiqLSDFileType = T002C5_A707ImpLiqLSDFileType[0] ;
         edtImpLiqLSDFile_Filetype = A707ImpLiqLSDFileType ;
         httpContext.ajax_rsp_assign_prop("", false, edtImpLiqLSDFile_Internalname, "Filetype", edtImpLiqLSDFile_Filetype, true);
         A706ImpLiqLSDFileName = T002C5_A706ImpLiqLSDFileName[0] ;
         edtImpLiqLSDFile_Filename = A706ImpLiqLSDFileName ;
         zm2C79( -2) ;
      }
      pr_default.close(3);
      onLoadActions2C79( ) ;
   }

   public void onLoadActions2C79( )
   {
   }

   public void checkExtendedTable2C79( )
   {
      nIsDirty_79 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T002C4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_liquidaciones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPLIQSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
   }

   public void closeExtendedTableCursors2C79( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_3( int A3CliCod ,
                         short A1EmpCod ,
                         short A88ImpLiqSec )
   {
      /* Using cursor T002C6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_liquidaciones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPLIQSEC");
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

   public void getKey2C79( )
   {
      /* Using cursor T002C7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A704ImpLiqLSDSec)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound79 = (short)(1) ;
      }
      else
      {
         RcdFound79 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T002C3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A704ImpLiqLSDSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm2C79( 2) ;
         RcdFound79 = (short)(1) ;
         A708ImpLiqLSDFileNameAndType = T002C3_A708ImpLiqLSDFileNameAndType[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A708ImpLiqLSDFileNameAndType", A708ImpLiqLSDFileNameAndType);
         A704ImpLiqLSDSec = T002C3_A704ImpLiqLSDSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A704ImpLiqLSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A704ImpLiqLSDSec), 4, 0));
         A705ImpLiqLSDFile = T002C3_A705ImpLiqLSDFile[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A705ImpLiqLSDFile", A705ImpLiqLSDFile);
         httpContext.ajax_rsp_assign_prop("", false, edtImpLiqLSDFile_Internalname, "URL", httpContext.getResourceRelative(A705ImpLiqLSDFile), true);
         A707ImpLiqLSDFileType = T002C3_A707ImpLiqLSDFileType[0] ;
         edtImpLiqLSDFile_Filetype = A707ImpLiqLSDFileType ;
         httpContext.ajax_rsp_assign_prop("", false, edtImpLiqLSDFile_Internalname, "Filetype", edtImpLiqLSDFile_Filetype, true);
         A706ImpLiqLSDFileName = T002C3_A706ImpLiqLSDFileName[0] ;
         edtImpLiqLSDFile_Filename = A706ImpLiqLSDFileName ;
         A3CliCod = T002C3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002C3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A88ImpLiqSec = T002C3_A88ImpLiqSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
         Z704ImpLiqLSDSec = A704ImpLiqLSDSec ;
         sMode79 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load2C79( ) ;
         if ( AnyError == 1 )
         {
            RcdFound79 = (short)(0) ;
            initializeNonKey2C79( ) ;
         }
         Gx_mode = sMode79 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound79 = (short)(0) ;
         initializeNonKey2C79( ) ;
         sMode79 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode79 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey2C79( ) ;
      if ( RcdFound79 == 0 )
      {
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound79 = (short)(0) ;
      /* Using cursor T002C8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A88ImpLiqSec), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A704ImpLiqLSDSec)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T002C8_A3CliCod[0] < A3CliCod ) || ( T002C8_A3CliCod[0] == A3CliCod ) && ( T002C8_A1EmpCod[0] < A1EmpCod ) || ( T002C8_A1EmpCod[0] == A1EmpCod ) && ( T002C8_A3CliCod[0] == A3CliCod ) && ( T002C8_A88ImpLiqSec[0] < A88ImpLiqSec ) || ( T002C8_A88ImpLiqSec[0] == A88ImpLiqSec ) && ( T002C8_A1EmpCod[0] == A1EmpCod ) && ( T002C8_A3CliCod[0] == A3CliCod ) && ( T002C8_A704ImpLiqLSDSec[0] < A704ImpLiqLSDSec ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T002C8_A3CliCod[0] > A3CliCod ) || ( T002C8_A3CliCod[0] == A3CliCod ) && ( T002C8_A1EmpCod[0] > A1EmpCod ) || ( T002C8_A1EmpCod[0] == A1EmpCod ) && ( T002C8_A3CliCod[0] == A3CliCod ) && ( T002C8_A88ImpLiqSec[0] > A88ImpLiqSec ) || ( T002C8_A88ImpLiqSec[0] == A88ImpLiqSec ) && ( T002C8_A1EmpCod[0] == A1EmpCod ) && ( T002C8_A3CliCod[0] == A3CliCod ) && ( T002C8_A704ImpLiqLSDSec[0] > A704ImpLiqLSDSec ) ) )
         {
            A3CliCod = T002C8_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002C8_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A88ImpLiqSec = T002C8_A88ImpLiqSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
            A704ImpLiqLSDSec = T002C8_A704ImpLiqLSDSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A704ImpLiqLSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A704ImpLiqLSDSec), 4, 0));
            RcdFound79 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound79 = (short)(0) ;
      /* Using cursor T002C9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A88ImpLiqSec), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A704ImpLiqLSDSec)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T002C9_A3CliCod[0] > A3CliCod ) || ( T002C9_A3CliCod[0] == A3CliCod ) && ( T002C9_A1EmpCod[0] > A1EmpCod ) || ( T002C9_A1EmpCod[0] == A1EmpCod ) && ( T002C9_A3CliCod[0] == A3CliCod ) && ( T002C9_A88ImpLiqSec[0] > A88ImpLiqSec ) || ( T002C9_A88ImpLiqSec[0] == A88ImpLiqSec ) && ( T002C9_A1EmpCod[0] == A1EmpCod ) && ( T002C9_A3CliCod[0] == A3CliCod ) && ( T002C9_A704ImpLiqLSDSec[0] > A704ImpLiqLSDSec ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T002C9_A3CliCod[0] < A3CliCod ) || ( T002C9_A3CliCod[0] == A3CliCod ) && ( T002C9_A1EmpCod[0] < A1EmpCod ) || ( T002C9_A1EmpCod[0] == A1EmpCod ) && ( T002C9_A3CliCod[0] == A3CliCod ) && ( T002C9_A88ImpLiqSec[0] < A88ImpLiqSec ) || ( T002C9_A88ImpLiqSec[0] == A88ImpLiqSec ) && ( T002C9_A1EmpCod[0] == A1EmpCod ) && ( T002C9_A3CliCod[0] == A3CliCod ) && ( T002C9_A704ImpLiqLSDSec[0] < A704ImpLiqLSDSec ) ) )
         {
            A3CliCod = T002C9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002C9_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A88ImpLiqSec = T002C9_A88ImpLiqSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
            A704ImpLiqLSDSec = T002C9_A704ImpLiqLSDSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A704ImpLiqLSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A704ImpLiqLSDSec), 4, 0));
            RcdFound79 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2C79( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert2C79( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound79 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( A704ImpLiqLSDSec != Z704ImpLiqLSDSec ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A88ImpLiqSec = Z88ImpLiqSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
               A704ImpLiqLSDSec = Z704ImpLiqLSDSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A704ImpLiqLSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A704ImpLiqLSDSec), 4, 0));
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
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update2C79( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( A704ImpLiqLSDSec != Z704ImpLiqLSDSec ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert2C79( ) ;
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
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert2C79( ) ;
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
   }

   public void btn_delete( )
   {
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( A704ImpLiqLSDSec != Z704ImpLiqLSDSec ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A88ImpLiqSec = Z88ImpLiqSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
         A704ImpLiqLSDSec = Z704ImpLiqLSDSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A704ImpLiqLSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A704ImpLiqLSDSec), 4, 0));
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
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         getByPrimaryKey( ) ;
      }
      CloseOpenCursors();
   }

   public void btn_get( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      if ( RcdFound79 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtImpLiqLSDFile_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart2C79( ) ;
      if ( RcdFound79 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtImpLiqLSDFile_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd2C79( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_previous( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_previous( ) ;
      if ( RcdFound79 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtImpLiqLSDFile_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_next( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_next( ) ;
      if ( RcdFound79 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtImpLiqLSDFile_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_last( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart2C79( ) ;
      if ( RcdFound79 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound79 != 0 )
         {
            scanNext2C79( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtImpLiqLSDFile_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd2C79( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency2C79( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002C2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A704ImpLiqLSDSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_liquidacion_lsd"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z708ImpLiqLSDFileNameAndType, T002C2_A708ImpLiqLSDFileNameAndType[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z708ImpLiqLSDFileNameAndType, T002C2_A708ImpLiqLSDFileNameAndType[0]) != 0 )
            {
               GXutil.writeLogln("importacion_liquidacion_lsd:[seudo value changed for attri]"+"ImpLiqLSDFileNameAndType");
               GXutil.writeLogRaw("Old: ",Z708ImpLiqLSDFileNameAndType);
               GXutil.writeLogRaw("Current: ",T002C2_A708ImpLiqLSDFileNameAndType[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"importacion_liquidacion_lsd"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2C79( )
   {
      beforeValidate2C79( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2C79( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2C79( 0) ;
         checkOptimisticConcurrency2C79( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2C79( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2C79( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002C10 */
                  A707ImpLiqLSDFileType = edtImpLiqLSDFile_Filetype ;
                  httpContext.ajax_rsp_assign_attri("", false, "A707ImpLiqLSDFileType", A707ImpLiqLSDFileType);
                  A706ImpLiqLSDFileName = edtImpLiqLSDFile_Filename ;
                  httpContext.ajax_rsp_assign_attri("", false, "A706ImpLiqLSDFileName", A706ImpLiqLSDFileName);
                  pr_default.execute(8, new Object[] {A708ImpLiqLSDFileNameAndType, Short.valueOf(A704ImpLiqLSDSec), A705ImpLiqLSDFile, A707ImpLiqLSDFileType, A706ImpLiqLSDFileName, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_lsd");
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
                        resetCaption2C0( ) ;
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
            load2C79( ) ;
         }
         endLevel2C79( ) ;
      }
      closeExtendedTableCursors2C79( ) ;
   }

   public void update2C79( )
   {
      beforeValidate2C79( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2C79( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2C79( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2C79( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2C79( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002C11 */
                  A707ImpLiqLSDFileType = edtImpLiqLSDFile_Filetype ;
                  httpContext.ajax_rsp_assign_attri("", false, "A707ImpLiqLSDFileType", A707ImpLiqLSDFileType);
                  A706ImpLiqLSDFileName = edtImpLiqLSDFile_Filename ;
                  httpContext.ajax_rsp_assign_attri("", false, "A706ImpLiqLSDFileName", A706ImpLiqLSDFileName);
                  pr_default.execute(9, new Object[] {A708ImpLiqLSDFileNameAndType, A707ImpLiqLSDFileType, A706ImpLiqLSDFileName, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A704ImpLiqLSDSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_lsd");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_liquidacion_lsd"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2C79( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption2C0( ) ;
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
         endLevel2C79( ) ;
      }
      closeExtendedTableCursors2C79( ) ;
   }

   public void deferredUpdate2C79( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T002C12 */
         pr_default.execute(10, new Object[] {A705ImpLiqLSDFile, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A704ImpLiqLSDSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_lsd");
      }
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate2C79( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2C79( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2C79( ) ;
         afterConfirm2C79( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2C79( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002C13 */
               pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A704ImpLiqLSDSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_lsd");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound79 == 0 )
                     {
                        initAll2C79( ) ;
                        Gx_mode = "INS" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     }
                     else
                     {
                        getByPrimaryKey( ) ;
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     }
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                     resetCaption2C0( ) ;
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
      sMode79 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2C79( ) ;
      Gx_mode = sMode79 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2C79( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel2C79( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2C79( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "importacion_liquidacion_lsd");
         if ( AnyError == 0 )
         {
            confirmValues2C0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "importacion_liquidacion_lsd");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2C79( )
   {
      /* Using cursor T002C14 */
      pr_default.execute(12);
      RcdFound79 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound79 = (short)(1) ;
         A3CliCod = T002C14_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002C14_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A88ImpLiqSec = T002C14_A88ImpLiqSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
         A704ImpLiqLSDSec = T002C14_A704ImpLiqLSDSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A704ImpLiqLSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A704ImpLiqLSDSec), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2C79( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound79 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound79 = (short)(1) ;
         A3CliCod = T002C14_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002C14_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A88ImpLiqSec = T002C14_A88ImpLiqSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
         A704ImpLiqLSDSec = T002C14_A704ImpLiqLSDSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A704ImpLiqLSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A704ImpLiqLSDSec), 4, 0));
      }
   }

   public void scanEnd2C79( )
   {
      pr_default.close(12);
   }

   public void afterConfirm2C79( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2C79( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2C79( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2C79( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2C79( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2C79( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2C79( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtImpLiqSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqSec_Enabled), 5, 0), true);
      edtImpLiqLSDSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqLSDSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqLSDSec_Enabled), 5, 0), true);
      edtImpLiqLSDFile_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqLSDFile_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqLSDFile_Enabled), 5, 0), true);
      edtImpLiqLSDFileNameAndType_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqLSDFileNameAndType_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqLSDFileNameAndType_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes2C79( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues2C0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.importacion_liquidacion_lsd", new String[] {}, new String[] {}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"importacion_liquidacion_lsd");
      forbiddenHiddens.add("ImpLiqLSDFileNameAndType", GXutil.rtrim( localUtil.format( A708ImpLiqLSDFileNameAndType, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("importacion_liquidacion_lsd:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z88ImpLiqSec", GXutil.ltrim( localUtil.ntoc( Z88ImpLiqSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z704ImpLiqLSDSec", GXutil.ltrim( localUtil.ntoc( Z704ImpLiqLSDSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z708ImpLiqLSDFileNameAndType", Z708ImpLiqLSDFileNameAndType);
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "IMPLIQLSDFILENAME", A706ImpLiqLSDFileName);
      web.GxWebStd.gx_hidden_field( httpContext, "IMPLIQLSDFILETYPE", GXutil.rtrim( A707ImpLiqLSDFileType));
      GXCCtlgxBlob = "IMPLIQLSDFILE" + "_gxBlob" ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A705ImpLiqLSDFile);
      web.GxWebStd.gx_hidden_field( httpContext, "IMPLIQLSDFILE_Filetype", GXutil.rtrim( edtImpLiqLSDFile_Filetype));
      web.GxWebStd.gx_hidden_field( httpContext, "IMPLIQLSDFILE_Filename", GXutil.rtrim( edtImpLiqLSDFile_Filename));
      web.GxWebStd.gx_hidden_field( httpContext, "IMPLIQLSDFILE_Filename", GXutil.rtrim( edtImpLiqLSDFile_Filename));
      web.GxWebStd.gx_hidden_field( httpContext, "IMPLIQLSDFILE_Filetype", GXutil.rtrim( edtImpLiqLSDFile_Filetype));
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
      return formatLink("web.importacion_liquidacion_lsd", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "importacion_liquidacion_lsd" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "importacion_liquidacion_lsd", "") ;
   }

   public void initializeNonKey2C79( )
   {
      A708ImpLiqLSDFileNameAndType = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A708ImpLiqLSDFileNameAndType", A708ImpLiqLSDFileNameAndType);
      A705ImpLiqLSDFile = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A705ImpLiqLSDFile", A705ImpLiqLSDFile);
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqLSDFile_Internalname, "URL", httpContext.getResourceRelative(A705ImpLiqLSDFile), true);
      A707ImpLiqLSDFileType = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A707ImpLiqLSDFileType", A707ImpLiqLSDFileType);
      A706ImpLiqLSDFileName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A706ImpLiqLSDFileName", A706ImpLiqLSDFileName);
      Z708ImpLiqLSDFileNameAndType = "" ;
   }

   public void initAll2C79( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A88ImpLiqSec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A88ImpLiqSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A88ImpLiqSec), 4, 0));
      A704ImpLiqLSDSec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A704ImpLiqLSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A704ImpLiqLSDSec), 4, 0));
      initializeNonKey2C79( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020114431", true, true);
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
      httpContext.AddJavascriptSource("importacion_liquidacion_lsd.js", "?2024122020114431", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTitle_Internalname = "TITLE" ;
      divTitlecontainer_Internalname = "TITLECONTAINER" ;
      bttBtn_first_Internalname = "BTN_FIRST" ;
      bttBtn_previous_Internalname = "BTN_PREVIOUS" ;
      bttBtn_next_Internalname = "BTN_NEXT" ;
      bttBtn_last_Internalname = "BTN_LAST" ;
      bttBtn_select_Internalname = "BTN_SELECT" ;
      divToolbarcell_Internalname = "TOOLBARCELL" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtImpLiqSec_Internalname = "IMPLIQSEC" ;
      edtImpLiqLSDSec_Internalname = "IMPLIQLSDSEC" ;
      edtImpLiqLSDFile_Internalname = "IMPLIQLSDFILE" ;
      edtImpLiqLSDFileNameAndType_Internalname = "IMPLIQLSDFILENAMEANDTYPE" ;
      divFormcontainer_Internalname = "FORMCONTAINER" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divMaintable_Internalname = "MAINTABLE" ;
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
      Form.setCaption( httpContext.getMessage( "importacion_liquidacion_lsd", "") );
      edtImpLiqLSDFile_Filename = "" ;
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtImpLiqLSDFileNameAndType_Jsonclick = "" ;
      edtImpLiqLSDFileNameAndType_Enabled = 0 ;
      edtImpLiqLSDFile_Jsonclick = "" ;
      edtImpLiqLSDFile_Parameters = "" ;
      edtImpLiqLSDFile_Contenttype = "" ;
      edtImpLiqLSDFile_Filetype = "" ;
      edtImpLiqLSDFile_Enabled = 1 ;
      edtImpLiqLSDSec_Jsonclick = "" ;
      edtImpLiqLSDSec_Enabled = 1 ;
      edtImpLiqSec_Jsonclick = "" ;
      edtImpLiqSec_Enabled = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      bttBtn_select_Visible = 1 ;
      bttBtn_last_Visible = 1 ;
      bttBtn_next_Visible = 1 ;
      bttBtn_previous_Visible = 1 ;
      bttBtn_first_Visible = 1 ;
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

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      /* Using cursor T002C15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_liquidaciones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPLIQSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(13);
      GX_FocusControl = edtImpLiqLSDFile_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
      /* End function AfterKeyLoadScreen */
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

   public void valid_Impliqsec( )
   {
      /* Using cursor T002C15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_liquidaciones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPLIQSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Impliqlsdsec( )
   {
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A708ImpLiqLSDFileNameAndType", A708ImpLiqLSDFileNameAndType);
      httpContext.ajax_rsp_assign_attri("", false, "A705ImpLiqLSDFile", httpContext.getResourceRelative(A705ImpLiqLSDFile));
      httpContext.ajax_rsp_assign_attri("", false, "A707ImpLiqLSDFileType", GXutil.rtrim( A707ImpLiqLSDFileType));
      httpContext.ajax_rsp_assign_attri("", false, "A706ImpLiqLSDFileName", A706ImpLiqLSDFileName);
      httpContext.ajax_rsp_assign_prop("", false, edtImpLiqLSDFile_Internalname, "Filetype", edtImpLiqLSDFile_Filetype, true);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z88ImpLiqSec", GXutil.ltrim( localUtil.ntoc( Z88ImpLiqSec, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z704ImpLiqLSDSec", GXutil.ltrim( localUtil.ntoc( Z704ImpLiqLSDSec, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z708ImpLiqLSDFileNameAndType", Z708ImpLiqLSDFileNameAndType);
      web.GxWebStd.gx_hidden_field( httpContext, "Z705ImpLiqLSDFile", httpContext.getResourceRelative(Z705ImpLiqLSDFile));
      web.GxWebStd.gx_hidden_field( httpContext, "Z707ImpLiqLSDFileType", GXutil.rtrim( Z707ImpLiqLSDFileType));
      web.GxWebStd.gx_hidden_field( httpContext, "Z706ImpLiqLSDFileName", Z706ImpLiqLSDFileName);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A708ImpLiqLSDFileNameAndType',fld:'IMPLIQLSDFILENAMEANDTYPE',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQSEC","{handler:'valid_Impliqsec',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A88ImpLiqSec',fld:'IMPLIQSEC',pic:'ZZZ9'}]");
      setEventMetadata("VALID_IMPLIQSEC",",oparms:[]}");
      setEventMetadata("VALID_IMPLIQLSDSEC","{handler:'valid_Impliqlsdsec',iparms:[{av:'A708ImpLiqLSDFileNameAndType',fld:'IMPLIQLSDFILENAMEANDTYPE',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A88ImpLiqSec',fld:'IMPLIQSEC',pic:'ZZZ9'},{av:'A704ImpLiqLSDSec',fld:'IMPLIQLSDSEC',pic:'ZZZ9'},{av:'A706ImpLiqLSDFileName',fld:'IMPLIQLSDFILENAME',pic:''},{av:'A707ImpLiqLSDFileType',fld:'IMPLIQLSDFILETYPE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_IMPLIQLSDSEC",",oparms:[{av:'A708ImpLiqLSDFileNameAndType',fld:'IMPLIQLSDFILENAMEANDTYPE',pic:''},{av:'A705ImpLiqLSDFile',fld:'IMPLIQLSDFILE',pic:''},{av:'A707ImpLiqLSDFileType',fld:'IMPLIQLSDFILETYPE',pic:''},{av:'A706ImpLiqLSDFileName',fld:'IMPLIQLSDFILENAME',pic:''},{av:'edtImpLiqLSDFile_Filetype',ctrl:'IMPLIQLSDFILE',prop:'Filetype'},{av:'edtImpLiqLSDFile_Filename',ctrl:'IMPLIQLSDFILE',prop:'Filename'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z3CliCod'},{av:'Z1EmpCod'},{av:'Z88ImpLiqSec'},{av:'Z704ImpLiqLSDSec'},{av:'Z708ImpLiqLSDFileNameAndType'},{av:'Z705ImpLiqLSDFile'},{av:'Z707ImpLiqLSDFileType'},{av:'Z706ImpLiqLSDFileName'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
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
      Z708ImpLiqLSDFileNameAndType = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      lblTitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A706ImpLiqLSDFileName = "" ;
      A707ImpLiqLSDFileType = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      A705ImpLiqLSDFile = "" ;
      A708ImpLiqLSDFileNameAndType = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gx_mode = "" ;
      GXCCtlgxBlob = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z705ImpLiqLSDFile = "" ;
      Z707ImpLiqLSDFileType = "" ;
      Z706ImpLiqLSDFileName = "" ;
      T002C5_A708ImpLiqLSDFileNameAndType = new String[] {""} ;
      T002C5_A704ImpLiqLSDSec = new short[1] ;
      T002C5_A705ImpLiqLSDFile = new String[] {""} ;
      T002C5_A707ImpLiqLSDFileType = new String[] {""} ;
      T002C5_A706ImpLiqLSDFileName = new String[] {""} ;
      T002C5_A3CliCod = new int[1] ;
      T002C5_A1EmpCod = new short[1] ;
      T002C5_A88ImpLiqSec = new short[1] ;
      T002C4_A3CliCod = new int[1] ;
      T002C6_A3CliCod = new int[1] ;
      T002C7_A3CliCod = new int[1] ;
      T002C7_A1EmpCod = new short[1] ;
      T002C7_A88ImpLiqSec = new short[1] ;
      T002C7_A704ImpLiqLSDSec = new short[1] ;
      T002C3_A708ImpLiqLSDFileNameAndType = new String[] {""} ;
      T002C3_A704ImpLiqLSDSec = new short[1] ;
      T002C3_A705ImpLiqLSDFile = new String[] {""} ;
      T002C3_A707ImpLiqLSDFileType = new String[] {""} ;
      T002C3_A706ImpLiqLSDFileName = new String[] {""} ;
      T002C3_A3CliCod = new int[1] ;
      T002C3_A1EmpCod = new short[1] ;
      T002C3_A88ImpLiqSec = new short[1] ;
      sMode79 = "" ;
      T002C8_A3CliCod = new int[1] ;
      T002C8_A1EmpCod = new short[1] ;
      T002C8_A88ImpLiqSec = new short[1] ;
      T002C8_A704ImpLiqLSDSec = new short[1] ;
      T002C9_A3CliCod = new int[1] ;
      T002C9_A1EmpCod = new short[1] ;
      T002C9_A88ImpLiqSec = new short[1] ;
      T002C9_A704ImpLiqLSDSec = new short[1] ;
      T002C2_A708ImpLiqLSDFileNameAndType = new String[] {""} ;
      T002C2_A704ImpLiqLSDSec = new short[1] ;
      T002C2_A705ImpLiqLSDFile = new String[] {""} ;
      T002C2_A707ImpLiqLSDFileType = new String[] {""} ;
      T002C2_A706ImpLiqLSDFileName = new String[] {""} ;
      T002C2_A3CliCod = new int[1] ;
      T002C2_A1EmpCod = new short[1] ;
      T002C2_A88ImpLiqSec = new short[1] ;
      T002C14_A3CliCod = new int[1] ;
      T002C14_A1EmpCod = new short[1] ;
      T002C14_A88ImpLiqSec = new short[1] ;
      T002C14_A704ImpLiqLSDSec = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T002C15_A3CliCod = new int[1] ;
      ZZ708ImpLiqLSDFileNameAndType = "" ;
      ZZ705ImpLiqLSDFile = "" ;
      ZZ707ImpLiqLSDFileType = "" ;
      ZZ706ImpLiqLSDFileName = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importacion_liquidacion_lsd__default(),
         new Object[] {
             new Object[] {
            T002C2_A708ImpLiqLSDFileNameAndType, T002C2_A704ImpLiqLSDSec, T002C2_A705ImpLiqLSDFile, T002C2_A707ImpLiqLSDFileType, T002C2_A706ImpLiqLSDFileName, T002C2_A3CliCod, T002C2_A1EmpCod, T002C2_A88ImpLiqSec
            }
            , new Object[] {
            T002C3_A708ImpLiqLSDFileNameAndType, T002C3_A704ImpLiqLSDSec, T002C3_A705ImpLiqLSDFile, T002C3_A707ImpLiqLSDFileType, T002C3_A706ImpLiqLSDFileName, T002C3_A3CliCod, T002C3_A1EmpCod, T002C3_A88ImpLiqSec
            }
            , new Object[] {
            T002C4_A3CliCod
            }
            , new Object[] {
            T002C5_A708ImpLiqLSDFileNameAndType, T002C5_A704ImpLiqLSDSec, T002C5_A705ImpLiqLSDFile, T002C5_A707ImpLiqLSDFileType, T002C5_A706ImpLiqLSDFileName, T002C5_A3CliCod, T002C5_A1EmpCod, T002C5_A88ImpLiqSec
            }
            , new Object[] {
            T002C6_A3CliCod
            }
            , new Object[] {
            T002C7_A3CliCod, T002C7_A1EmpCod, T002C7_A88ImpLiqSec, T002C7_A704ImpLiqLSDSec
            }
            , new Object[] {
            T002C8_A3CliCod, T002C8_A1EmpCod, T002C8_A88ImpLiqSec, T002C8_A704ImpLiqLSDSec
            }
            , new Object[] {
            T002C9_A3CliCod, T002C9_A1EmpCod, T002C9_A88ImpLiqSec, T002C9_A704ImpLiqLSDSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002C14_A3CliCod, T002C14_A1EmpCod, T002C14_A88ImpLiqSec, T002C14_A704ImpLiqLSDSec
            }
            , new Object[] {
            T002C15_A3CliCod
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z1EmpCod ;
   private short Z88ImpLiqSec ;
   private short Z704ImpLiqLSDSec ;
   private short A1EmpCod ;
   private short A88ImpLiqSec ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A704ImpLiqLSDSec ;
   private short RcdFound79 ;
   private short nIsDirty_79 ;
   private short ZZ1EmpCod ;
   private short ZZ88ImpLiqSec ;
   private short ZZ704ImpLiqLSDSec ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Enabled ;
   private int edtImpLiqSec_Enabled ;
   private int edtImpLiqLSDSec_Enabled ;
   private int edtImpLiqLSDFile_Enabled ;
   private int edtImpLiqLSDFileNameAndType_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ3CliCod ;
   private String sPrefix ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCliCod_Internalname ;
   private String divMaintable_Internalname ;
   private String divTitlecontainer_Internalname ;
   private String lblTitle_Internalname ;
   private String lblTitle_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divFormcontainer_Internalname ;
   private String divToolbarcell_Internalname ;
   private String TempTags ;
   private String bttBtn_first_Internalname ;
   private String bttBtn_first_Jsonclick ;
   private String bttBtn_previous_Internalname ;
   private String bttBtn_previous_Jsonclick ;
   private String bttBtn_next_Internalname ;
   private String bttBtn_next_Jsonclick ;
   private String bttBtn_last_Internalname ;
   private String bttBtn_last_Jsonclick ;
   private String bttBtn_select_Internalname ;
   private String bttBtn_select_Jsonclick ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtImpLiqSec_Internalname ;
   private String edtImpLiqSec_Jsonclick ;
   private String edtImpLiqLSDSec_Internalname ;
   private String edtImpLiqLSDSec_Jsonclick ;
   private String edtImpLiqLSDFile_Internalname ;
   private String edtImpLiqLSDFile_Filename ;
   private String edtImpLiqLSDFile_Filetype ;
   private String A707ImpLiqLSDFileType ;
   private String edtImpLiqLSDFile_Contenttype ;
   private String edtImpLiqLSDFile_Parameters ;
   private String edtImpLiqLSDFile_Jsonclick ;
   private String edtImpLiqLSDFileNameAndType_Internalname ;
   private String edtImpLiqLSDFileNameAndType_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String Gx_mode ;
   private String GXCCtlgxBlob ;
   private String hsh ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z707ImpLiqLSDFileType ;
   private String sMode79 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ707ImpLiqLSDFileType ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private String A705ImpLiqLSDFile ;
   private String Z705ImpLiqLSDFile ;
   private String ZZ705ImpLiqLSDFile ;
   private String Z708ImpLiqLSDFileNameAndType ;
   private String A706ImpLiqLSDFileName ;
   private String A708ImpLiqLSDFileNameAndType ;
   private String Z706ImpLiqLSDFileName ;
   private String ZZ708ImpLiqLSDFileNameAndType ;
   private String ZZ706ImpLiqLSDFileName ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T002C5_A708ImpLiqLSDFileNameAndType ;
   private short[] T002C5_A704ImpLiqLSDSec ;
   private String[] T002C5_A705ImpLiqLSDFile ;
   private String[] T002C5_A707ImpLiqLSDFileType ;
   private String[] T002C5_A706ImpLiqLSDFileName ;
   private int[] T002C5_A3CliCod ;
   private short[] T002C5_A1EmpCod ;
   private short[] T002C5_A88ImpLiqSec ;
   private int[] T002C4_A3CliCod ;
   private int[] T002C6_A3CliCod ;
   private int[] T002C7_A3CliCod ;
   private short[] T002C7_A1EmpCod ;
   private short[] T002C7_A88ImpLiqSec ;
   private short[] T002C7_A704ImpLiqLSDSec ;
   private String[] T002C3_A708ImpLiqLSDFileNameAndType ;
   private short[] T002C3_A704ImpLiqLSDSec ;
   private String[] T002C3_A705ImpLiqLSDFile ;
   private String[] T002C3_A707ImpLiqLSDFileType ;
   private String[] T002C3_A706ImpLiqLSDFileName ;
   private int[] T002C3_A3CliCod ;
   private short[] T002C3_A1EmpCod ;
   private short[] T002C3_A88ImpLiqSec ;
   private int[] T002C8_A3CliCod ;
   private short[] T002C8_A1EmpCod ;
   private short[] T002C8_A88ImpLiqSec ;
   private short[] T002C8_A704ImpLiqLSDSec ;
   private int[] T002C9_A3CliCod ;
   private short[] T002C9_A1EmpCod ;
   private short[] T002C9_A88ImpLiqSec ;
   private short[] T002C9_A704ImpLiqLSDSec ;
   private String[] T002C2_A708ImpLiqLSDFileNameAndType ;
   private short[] T002C2_A704ImpLiqLSDSec ;
   private String[] T002C2_A705ImpLiqLSDFile ;
   private String[] T002C2_A707ImpLiqLSDFileType ;
   private String[] T002C2_A706ImpLiqLSDFileName ;
   private int[] T002C2_A3CliCod ;
   private short[] T002C2_A1EmpCod ;
   private short[] T002C2_A88ImpLiqSec ;
   private int[] T002C14_A3CliCod ;
   private short[] T002C14_A1EmpCod ;
   private short[] T002C14_A88ImpLiqSec ;
   private short[] T002C14_A704ImpLiqLSDSec ;
   private int[] T002C15_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class importacion_liquidacion_lsd__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T002C2", "SELECT ImpLiqLSDFileNameAndType, ImpLiqLSDSec, ImpLiqLSDFile, ImpLiqLSDFileType, ImpLiqLSDFileName, CliCod, EmpCod, ImpLiqSec FROM importacion_liquidacion_lsd WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqLSDSec = ?  FOR UPDATE OF importacion_liquidacion_lsd NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002C3", "SELECT ImpLiqLSDFileNameAndType, ImpLiqLSDSec, ImpLiqLSDFile, ImpLiqLSDFileType, ImpLiqLSDFileName, CliCod, EmpCod, ImpLiqSec FROM importacion_liquidacion_lsd WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqLSDSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002C4", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002C5", "SELECT TM1.ImpLiqLSDFileNameAndType, TM1.ImpLiqLSDSec, TM1.ImpLiqLSDFile, TM1.ImpLiqLSDFileType, TM1.ImpLiqLSDFileName, TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec FROM importacion_liquidacion_lsd TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.ImpLiqSec = ? and TM1.ImpLiqLSDSec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec, TM1.ImpLiqLSDSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002C6", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002C7", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqLSDSec FROM importacion_liquidacion_lsd WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqLSDSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002C8", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqLSDSec FROM importacion_liquidacion_lsd WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and ImpLiqSec > ? or ImpLiqSec = ? and EmpCod = ? and CliCod = ? and ImpLiqLSDSec > ?) ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqLSDSec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002C9", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqLSDSec FROM importacion_liquidacion_lsd WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and ImpLiqSec < ? or ImpLiqSec = ? and EmpCod = ? and CliCod = ? and ImpLiqLSDSec < ?) ORDER BY CliCod DESC, EmpCod DESC, ImpLiqSec DESC, ImpLiqLSDSec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T002C10", "SAVEPOINT gxupdate;INSERT INTO importacion_liquidacion_lsd(ImpLiqLSDFileNameAndType, ImpLiqLSDSec, ImpLiqLSDFile, ImpLiqLSDFileType, ImpLiqLSDFileName, CliCod, EmpCod, ImpLiqSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002C11", "SAVEPOINT gxupdate;UPDATE importacion_liquidacion_lsd SET ImpLiqLSDFileNameAndType=?, ImpLiqLSDFileType=?, ImpLiqLSDFileName=?  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqLSDSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002C12", "SAVEPOINT gxupdate;UPDATE importacion_liquidacion_lsd SET ImpLiqLSDFile=?  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqLSDSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002C13", "SAVEPOINT gxupdate;DELETE FROM importacion_liquidacion_lsd  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqLSDSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002C14", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqLSDSec FROM importacion_liquidacion_lsd ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqLSDSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002C15", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(4, 20), rslt.getVarchar(5));
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(4, 20), rslt.getVarchar(5));
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(4, 20), rslt.getVarchar(5));
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setBLOBFile(3, (String)parms[2]);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 10 :
               stmt.setBLOBFile(1, (String)parms[0]);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

