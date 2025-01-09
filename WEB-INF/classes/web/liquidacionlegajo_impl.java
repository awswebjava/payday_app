package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class liquidacionlegajo_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_6") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A34LiqSecCodigo = httpContext.GetPar( "LiqSecCodigo") ;
         n34LiqSecCodigo = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A34LiqSecCodigo", A34LiqSecCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_6( A3CliCod, A34LiqSecCodigo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_3") == 0 )
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
         gxload_3( A3CliCod, A1EmpCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_5") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A31LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_5( A3CliCod, A1EmpCod, A31LiqNro) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_4") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_4( A3CliCod, A1EmpCod, A6LegNumero) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Liquidacion Legajo", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtEmpCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public liquidacionlegajo_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public liquidacionlegajo_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionlegajo_impl.class ));
   }

   public liquidacionlegajo_impl( int remoteHandle ,
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "Liquidacion Legajo", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionLegajo.htm");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionLegajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionLegajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionLegajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionLegajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_LiquidacionLegajo.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpCod_Internalname, httpContext.getMessage( "Empresa", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_LiquidacionLegajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliCod_Internalname, httpContext.getMessage( "Cli Cod", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiquidacionLegajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpNom_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpNom_Internalname, httpContext.getMessage( "Nombre", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpNom_Internalname, A2EmpNom, GXutil.rtrim( localUtil.format( A2EmpNom, "@!")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpNom_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpNom_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionLarga", "left", true, "", "HLP_LiquidacionLegajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqNro_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqNro_Internalname, httpContext.getMessage( "Liquidacion", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqNro_Internalname, GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqNro_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqNro_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqNro_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_LiquidacionLegajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegNumero_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegNumero_Internalname, httpContext.getMessage( "Legajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegNumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_LiquidacionLegajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqLegImpTotal_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqLegImpTotal_Internalname, httpContext.getMessage( "Importe", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqLegImpTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A281LiqLegImpTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqLegImpTotal_Enabled!=0) ? localUtil.format( A281LiqLegImpTotal, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A281LiqLegImpTotal, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqLegImpTotal_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqLegImpTotal_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_LiquidacionLegajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqSecCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqSecCodigo_Internalname, httpContext.getMessage( "Seccion (borrar)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqSecCodigo_Internalname, GXutil.rtrim( A34LiqSecCodigo), GXutil.rtrim( localUtil.format( A34LiqSecCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqSecCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqSecCodigo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodigoCaracter", "left", true, "", "HLP_LiquidacionLegajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqSecDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqSecDescrip_Internalname, httpContext.getMessage( "Descripcion", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtLiqSecDescrip_Internalname, A284LiqSecDescrip, "", "", (short)(0), 1, edtLiqSecDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_LiquidacionLegajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqLegReciboNro_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqLegReciboNro_Internalname, httpContext.getMessage( "Numero de Recibo (borrar)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqLegReciboNro_Internalname, GXutil.ltrim( localUtil.ntoc( A282LiqLegReciboNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqLegReciboNro_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A282LiqLegReciboNro), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A282LiqLegReciboNro), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqLegReciboNro_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqLegReciboNro_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_LiquidacionLegajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegId_Internalname, httpContext.getMessage( "ID", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegId_Internalname, GXutil.rtrim( A93LegId), GXutil.rtrim( localUtil.format( A93LegId, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegId_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LiquidacionLegajo.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionLegajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 86,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionLegajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 88,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionLegajo.htm");
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
         Z31LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "Z31LiqNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "Z6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z281LiqLegImpTotal = localUtil.ctond( httpContext.cgiGet( "Z281LiqLegImpTotal")) ;
         Z282LiqLegReciboNro = (int)(localUtil.ctol( httpContext.cgiGet( "Z282LiqLegReciboNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z482LegLiqDatosHis = httpContext.cgiGet( "Z482LegLiqDatosHis") ;
         Z498LiqLegImpTotBruto = localUtil.ctond( httpContext.cgiGet( "Z498LiqLegImpTotBruto")) ;
         Z759LiqLegImpTotBruSinSAC = localUtil.ctond( httpContext.cgiGet( "Z759LiqLegImpTotBruSinSAC")) ;
         Z499LiqLegCntConc = (short)(localUtil.ctol( httpContext.cgiGet( "Z499LiqLegCntConc"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z577LiqLegImpTotRemu = localUtil.ctond( httpContext.cgiGet( "Z577LiqLegImpTotRemu")) ;
         Z578LiqLegImpTotNoRemu = localUtil.ctond( httpContext.cgiGet( "Z578LiqLegImpTotNoRemu")) ;
         Z579LiqLegImpTotDescu = localUtil.ctond( httpContext.cgiGet( "Z579LiqLegImpTotDescu")) ;
         Z1157LiqLegImpContr = localUtil.ctond( httpContext.cgiGet( "Z1157LiqLegImpContr")) ;
         Z1158LiqLegImpCosto = localUtil.ctond( httpContext.cgiGet( "Z1158LiqLegImpCosto")) ;
         Z1131LiqLegImpOtrDescu = localUtil.ctond( httpContext.cgiGet( "Z1131LiqLegImpOtrDescu")) ;
         Z1143LiqLegImpDescuNeg = localUtil.ctond( httpContext.cgiGet( "Z1143LiqLegImpDescuNeg")) ;
         Z757LiqLegImpTotRetGan = localUtil.ctond( httpContext.cgiGet( "Z757LiqLegImpTotRetGan")) ;
         Z775LiqLegImpPagosACuen = localUtil.ctond( httpContext.cgiGet( "Z775LiqLegImpPagosACuen")) ;
         Z758LiqLegImpTotBruProm = localUtil.ctond( httpContext.cgiGet( "Z758LiqLegImpTotBruProm")) ;
         Z760LiqLegImpBasico = localUtil.ctond( httpContext.cgiGet( "Z760LiqLegImpBasico")) ;
         Z761LiqLegGNSI = localUtil.ctond( httpContext.cgiGet( "Z761LiqLegGNSI")) ;
         Z590LiqRutaPDF = httpContext.cgiGet( "Z590LiqRutaPDF") ;
         Z774LiqRutaPDFVertical = httpContext.cgiGet( "Z774LiqRutaPDFVertical") ;
         Z883LIqLegIteraciones = (short)(localUtil.ctol( httpContext.cgiGet( "Z883LIqLegIteraciones"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z884LiqLegSegundos = localUtil.ctond( httpContext.cgiGet( "Z884LiqLegSegundos")) ;
         Z1495LiqLegSegIns = localUtil.ctond( httpContext.cgiGet( "Z1495LiqLegSegIns")) ;
         Z1496LieqLegSegUpd = localUtil.ctond( httpContext.cgiGet( "Z1496LieqLegSegUpd")) ;
         Z891LiqLegError = httpContext.cgiGet( "Z891LiqLegError") ;
         Z961LiqNombrePDF = httpContext.cgiGet( "Z961LiqNombrePDF") ;
         Z962LiqNombrePDFVertical = httpContext.cgiGet( "Z962LiqNombrePDFVertical") ;
         Z1546LiqLegHorasSem = localUtil.ctond( httpContext.cgiGet( "Z1546LiqLegHorasSem")) ;
         Z1780LiqLegAuxEstado = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1780LiqLegAuxEstado"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1781LiqLegErrorAux = httpContext.cgiGet( "Z1781LiqLegErrorAux") ;
         Z1815LiqLegFecEgr = localUtil.ctod( httpContext.cgiGet( "Z1815LiqLegFecEgr"), 0) ;
         Z1816LiqLegFecIng = localUtil.ctod( httpContext.cgiGet( "Z1816LiqLegFecIng"), 0) ;
         Z2113LiqLegCatCodigo = httpContext.cgiGet( "Z2113LiqLegCatCodigo") ;
         Z2115LiqLegConvenio = httpContext.cgiGet( "Z2115LiqLegConvenio") ;
         Z2114LiqLegSueldo = localUtil.ctond( httpContext.cgiGet( "Z2114LiqLegSueldo")) ;
         Z2179LiqLegPDFEstado = httpContext.cgiGet( "Z2179LiqLegPDFEstado") ;
         n2179LiqLegPDFEstado = ((GXutil.strcmp("", A2179LiqLegPDFEstado)==0) ? true : false) ;
         Z2268LiqLegProcesado = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2268LiqLegProcesado"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z2360LiqLegNivLiq = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2360LiqLegNivLiq"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z2400LiqLegLSD = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2400LiqLegLSD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z2401LiqLegDaemonUUID = httpContext.cgiGet( "Z2401LiqLegDaemonUUID") ;
         n2401LiqLegDaemonUUID = ((GXutil.strcmp("", A2401LiqLegDaemonUUID)==0) ? true : false) ;
         Z2402LiqLegFecHor = localUtil.ctot( httpContext.cgiGet( "Z2402LiqLegFecHor"), 0) ;
         Z34LiqSecCodigo = httpContext.cgiGet( "Z34LiqSecCodigo") ;
         n34LiqSecCodigo = ((GXutil.strcmp("", A34LiqSecCodigo)==0) ? true : false) ;
         A482LegLiqDatosHis = httpContext.cgiGet( "Z482LegLiqDatosHis") ;
         A498LiqLegImpTotBruto = localUtil.ctond( httpContext.cgiGet( "Z498LiqLegImpTotBruto")) ;
         A759LiqLegImpTotBruSinSAC = localUtil.ctond( httpContext.cgiGet( "Z759LiqLegImpTotBruSinSAC")) ;
         A499LiqLegCntConc = (short)(localUtil.ctol( httpContext.cgiGet( "Z499LiqLegCntConc"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A577LiqLegImpTotRemu = localUtil.ctond( httpContext.cgiGet( "Z577LiqLegImpTotRemu")) ;
         A578LiqLegImpTotNoRemu = localUtil.ctond( httpContext.cgiGet( "Z578LiqLegImpTotNoRemu")) ;
         A579LiqLegImpTotDescu = localUtil.ctond( httpContext.cgiGet( "Z579LiqLegImpTotDescu")) ;
         A1157LiqLegImpContr = localUtil.ctond( httpContext.cgiGet( "Z1157LiqLegImpContr")) ;
         A1158LiqLegImpCosto = localUtil.ctond( httpContext.cgiGet( "Z1158LiqLegImpCosto")) ;
         A1131LiqLegImpOtrDescu = localUtil.ctond( httpContext.cgiGet( "Z1131LiqLegImpOtrDescu")) ;
         A1143LiqLegImpDescuNeg = localUtil.ctond( httpContext.cgiGet( "Z1143LiqLegImpDescuNeg")) ;
         A757LiqLegImpTotRetGan = localUtil.ctond( httpContext.cgiGet( "Z757LiqLegImpTotRetGan")) ;
         A775LiqLegImpPagosACuen = localUtil.ctond( httpContext.cgiGet( "Z775LiqLegImpPagosACuen")) ;
         A758LiqLegImpTotBruProm = localUtil.ctond( httpContext.cgiGet( "Z758LiqLegImpTotBruProm")) ;
         A760LiqLegImpBasico = localUtil.ctond( httpContext.cgiGet( "Z760LiqLegImpBasico")) ;
         A761LiqLegGNSI = localUtil.ctond( httpContext.cgiGet( "Z761LiqLegGNSI")) ;
         A590LiqRutaPDF = httpContext.cgiGet( "Z590LiqRutaPDF") ;
         A774LiqRutaPDFVertical = httpContext.cgiGet( "Z774LiqRutaPDFVertical") ;
         A883LIqLegIteraciones = (short)(localUtil.ctol( httpContext.cgiGet( "Z883LIqLegIteraciones"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A884LiqLegSegundos = localUtil.ctond( httpContext.cgiGet( "Z884LiqLegSegundos")) ;
         A1495LiqLegSegIns = localUtil.ctond( httpContext.cgiGet( "Z1495LiqLegSegIns")) ;
         A1496LieqLegSegUpd = localUtil.ctond( httpContext.cgiGet( "Z1496LieqLegSegUpd")) ;
         A891LiqLegError = httpContext.cgiGet( "Z891LiqLegError") ;
         A961LiqNombrePDF = httpContext.cgiGet( "Z961LiqNombrePDF") ;
         A962LiqNombrePDFVertical = httpContext.cgiGet( "Z962LiqNombrePDFVertical") ;
         A1546LiqLegHorasSem = localUtil.ctond( httpContext.cgiGet( "Z1546LiqLegHorasSem")) ;
         A1780LiqLegAuxEstado = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1780LiqLegAuxEstado"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A1781LiqLegErrorAux = httpContext.cgiGet( "Z1781LiqLegErrorAux") ;
         A1815LiqLegFecEgr = localUtil.ctod( httpContext.cgiGet( "Z1815LiqLegFecEgr"), 0) ;
         A1816LiqLegFecIng = localUtil.ctod( httpContext.cgiGet( "Z1816LiqLegFecIng"), 0) ;
         A2113LiqLegCatCodigo = httpContext.cgiGet( "Z2113LiqLegCatCodigo") ;
         A2115LiqLegConvenio = httpContext.cgiGet( "Z2115LiqLegConvenio") ;
         A2114LiqLegSueldo = localUtil.ctond( httpContext.cgiGet( "Z2114LiqLegSueldo")) ;
         A2179LiqLegPDFEstado = httpContext.cgiGet( "Z2179LiqLegPDFEstado") ;
         n2179LiqLegPDFEstado = false ;
         n2179LiqLegPDFEstado = ((GXutil.strcmp("", A2179LiqLegPDFEstado)==0) ? true : false) ;
         A2268LiqLegProcesado = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2268LiqLegProcesado"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A2360LiqLegNivLiq = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2360LiqLegNivLiq"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A2400LiqLegLSD = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2400LiqLegLSD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A2401LiqLegDaemonUUID = httpContext.cgiGet( "Z2401LiqLegDaemonUUID") ;
         n2401LiqLegDaemonUUID = false ;
         n2401LiqLegDaemonUUID = ((GXutil.strcmp("", A2401LiqLegDaemonUUID)==0) ? true : false) ;
         A2402LiqLegFecHor = localUtil.ctot( httpContext.cgiGet( "Z2402LiqLegFecHor"), 0) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         A482LegLiqDatosHis = httpContext.cgiGet( "LEGLIQDATOSHIS") ;
         A498LiqLegImpTotBruto = localUtil.ctond( httpContext.cgiGet( "LIQLEGIMPTOTBRUTO")) ;
         A759LiqLegImpTotBruSinSAC = localUtil.ctond( httpContext.cgiGet( "LIQLEGIMPTOTBRUSINSAC")) ;
         A499LiqLegCntConc = (short)(localUtil.ctol( httpContext.cgiGet( "LIQLEGCNTCONC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A577LiqLegImpTotRemu = localUtil.ctond( httpContext.cgiGet( "LIQLEGIMPTOTREMU")) ;
         A578LiqLegImpTotNoRemu = localUtil.ctond( httpContext.cgiGet( "LIQLEGIMPTOTNOREMU")) ;
         A579LiqLegImpTotDescu = localUtil.ctond( httpContext.cgiGet( "LIQLEGIMPTOTDESCU")) ;
         A1157LiqLegImpContr = localUtil.ctond( httpContext.cgiGet( "LIQLEGIMPCONTR")) ;
         A1158LiqLegImpCosto = localUtil.ctond( httpContext.cgiGet( "LIQLEGIMPCOSTO")) ;
         A1131LiqLegImpOtrDescu = localUtil.ctond( httpContext.cgiGet( "LIQLEGIMPOTRDESCU")) ;
         A1143LiqLegImpDescuNeg = localUtil.ctond( httpContext.cgiGet( "LIQLEGIMPDESCUNEG")) ;
         A757LiqLegImpTotRetGan = localUtil.ctond( httpContext.cgiGet( "LIQLEGIMPTOTRETGAN")) ;
         A775LiqLegImpPagosACuen = localUtil.ctond( httpContext.cgiGet( "LIQLEGIMPPAGOSACUEN")) ;
         A758LiqLegImpTotBruProm = localUtil.ctond( httpContext.cgiGet( "LIQLEGIMPTOTBRUPROM")) ;
         A760LiqLegImpBasico = localUtil.ctond( httpContext.cgiGet( "LIQLEGIMPBASICO")) ;
         A761LiqLegGNSI = localUtil.ctond( httpContext.cgiGet( "LIQLEGGNSI")) ;
         A590LiqRutaPDF = httpContext.cgiGet( "LIQRUTAPDF") ;
         A774LiqRutaPDFVertical = httpContext.cgiGet( "LIQRUTAPDFVERTICAL") ;
         A883LIqLegIteraciones = (short)(localUtil.ctol( httpContext.cgiGet( "LIQLEGITERACIONES"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A884LiqLegSegundos = localUtil.ctond( httpContext.cgiGet( "LIQLEGSEGUNDOS")) ;
         A1495LiqLegSegIns = localUtil.ctond( httpContext.cgiGet( "LIQLEGSEGINS")) ;
         A1496LieqLegSegUpd = localUtil.ctond( httpContext.cgiGet( "LIEQLEGSEGUPD")) ;
         A891LiqLegError = httpContext.cgiGet( "LIQLEGERROR") ;
         A961LiqNombrePDF = httpContext.cgiGet( "LIQNOMBREPDF") ;
         A962LiqNombrePDFVertical = httpContext.cgiGet( "LIQNOMBREPDFVERTICAL") ;
         A1546LiqLegHorasSem = localUtil.ctond( httpContext.cgiGet( "LIQLEGHORASSEM")) ;
         A1780LiqLegAuxEstado = (byte)(localUtil.ctol( httpContext.cgiGet( "LIQLEGAUXESTADO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A1781LiqLegErrorAux = httpContext.cgiGet( "LIQLEGERRORAUX") ;
         A1815LiqLegFecEgr = localUtil.ctod( httpContext.cgiGet( "LIQLEGFECEGR"), 0) ;
         A1816LiqLegFecIng = localUtil.ctod( httpContext.cgiGet( "LIQLEGFECING"), 0) ;
         A2113LiqLegCatCodigo = httpContext.cgiGet( "LIQLEGCATCODIGO") ;
         A2115LiqLegConvenio = httpContext.cgiGet( "LIQLEGCONVENIO") ;
         A2114LiqLegSueldo = localUtil.ctond( httpContext.cgiGet( "LIQLEGSUELDO")) ;
         A2179LiqLegPDFEstado = httpContext.cgiGet( "LIQLEGPDFESTADO") ;
         n2179LiqLegPDFEstado = ((GXutil.strcmp("", A2179LiqLegPDFEstado)==0) ? true : false) ;
         A2268LiqLegProcesado = (byte)(localUtil.ctol( httpContext.cgiGet( "LIQLEGPROCESADO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A2360LiqLegNivLiq = (byte)(localUtil.ctol( httpContext.cgiGet( "LIQLEGNIVLIQ"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A2393LiqLegHtml = httpContext.cgiGet( "LIQLEGHTML") ;
         A2400LiqLegLSD = (byte)(localUtil.ctol( httpContext.cgiGet( "LIQLEGLSD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A2401LiqLegDaemonUUID = httpContext.cgiGet( "LIQLEGDAEMONUUID") ;
         n2401LiqLegDaemonUUID = ((GXutil.strcmp("", A2401LiqLegDaemonUUID)==0) ? true : false) ;
         A2402LiqLegFecHor = localUtil.ctot( httpContext.cgiGet( "LIQLEGFECHOR"), 0) ;
         A250LegIdNomApe = httpContext.cgiGet( "LEGIDNOMAPE") ;
         A251LegNombre = httpContext.cgiGet( "LEGNOMBRE") ;
         A230LegApellido = httpContext.cgiGet( "LEGAPELLIDO") ;
         A283LiqPeriodo = localUtil.ctod( httpContext.cgiGet( "LIQPERIODO"), 0) ;
         A32TLiqCod = httpContext.cgiGet( "TLIQCOD") ;
         n32TLiqCod = false ;
         /* Read variables values. */
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
         A2EmpNom = GXutil.upper( httpContext.cgiGet( edtEmpNom_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2EmpNom", A2EmpNom);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQNRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqNro_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A31LiqNro = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         }
         else
         {
            A31LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGNUMERO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLegNumero_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A6LegNumero = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         }
         else
         {
            A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqLegImpTotal_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqLegImpTotal_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQLEGIMPTOTAL");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqLegImpTotal_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A281LiqLegImpTotal = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A281LiqLegImpTotal", GXutil.ltrimstr( A281LiqLegImpTotal, 14, 2));
         }
         else
         {
            A281LiqLegImpTotal = localUtil.ctond( httpContext.cgiGet( edtLiqLegImpTotal_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A281LiqLegImpTotal", GXutil.ltrimstr( A281LiqLegImpTotal, 14, 2));
         }
         A34LiqSecCodigo = httpContext.cgiGet( edtLiqSecCodigo_Internalname) ;
         n34LiqSecCodigo = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A34LiqSecCodigo", A34LiqSecCodigo);
         n34LiqSecCodigo = ((GXutil.strcmp("", A34LiqSecCodigo)==0) ? true : false) ;
         A284LiqSecDescrip = httpContext.cgiGet( edtLiqSecDescrip_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A284LiqSecDescrip", A284LiqSecDescrip);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqLegReciboNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqLegReciboNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQLEGRECIBONRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqLegReciboNro_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A282LiqLegReciboNro = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A282LiqLegReciboNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A282LiqLegReciboNro), 8, 0));
         }
         else
         {
            A282LiqLegReciboNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqLegReciboNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A282LiqLegReciboNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A282LiqLegReciboNro), 8, 0));
         }
         A93LegId = httpContext.cgiGet( edtLegId_Internalname) ;
         n93LegId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A93LegId", A93LegId);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", "hsh"+"LiquidacionLegajo");
         forbiddenHiddens.add("LegLiqDatosHis", GXutil.rtrim( localUtil.format( A482LegLiqDatosHis, "")));
         forbiddenHiddens.add("LiqLegImpTotBruto", localUtil.format( A498LiqLegImpTotBruto, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         forbiddenHiddens.add("LiqLegImpTotBruSinSAC", localUtil.format( A759LiqLegImpTotBruSinSAC, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         forbiddenHiddens.add("LiqLegCntConc", localUtil.format( DecimalUtil.doubleToDec(A499LiqLegCntConc), "ZZZ9"));
         forbiddenHiddens.add("LiqLegImpTotRemu", localUtil.format( A577LiqLegImpTotRemu, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         forbiddenHiddens.add("LiqLegImpTotNoRemu", localUtil.format( A578LiqLegImpTotNoRemu, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         forbiddenHiddens.add("LiqLegImpTotDescu", localUtil.format( A579LiqLegImpTotDescu, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         forbiddenHiddens.add("LiqLegImpContr", localUtil.format( A1157LiqLegImpContr, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         forbiddenHiddens.add("LiqLegImpCosto", localUtil.format( A1158LiqLegImpCosto, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         forbiddenHiddens.add("LiqLegImpOtrDescu", localUtil.format( A1131LiqLegImpOtrDescu, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         forbiddenHiddens.add("LiqLegImpDescuNeg", localUtil.format( A1143LiqLegImpDescuNeg, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         forbiddenHiddens.add("LiqLegImpTotRetGan", localUtil.format( A757LiqLegImpTotRetGan, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         forbiddenHiddens.add("LiqLegImpPagosACuen", localUtil.format( A775LiqLegImpPagosACuen, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         forbiddenHiddens.add("LiqLegImpTotBruProm", localUtil.format( A758LiqLegImpTotBruProm, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         forbiddenHiddens.add("LiqLegImpBasico", localUtil.format( A760LiqLegImpBasico, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         forbiddenHiddens.add("LiqLegGNSI", localUtil.format( A761LiqLegGNSI, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         forbiddenHiddens.add("LiqRutaPDF", GXutil.rtrim( localUtil.format( A590LiqRutaPDF, "")));
         forbiddenHiddens.add("LiqRutaPDFVertical", GXutil.rtrim( localUtil.format( A774LiqRutaPDFVertical, "")));
         forbiddenHiddens.add("LIqLegIteraciones", localUtil.format( DecimalUtil.doubleToDec(A883LIqLegIteraciones), "ZZZ9"));
         forbiddenHiddens.add("LiqLegSegundos", localUtil.format( A884LiqLegSegundos, "ZZ9.999999"));
         forbiddenHiddens.add("LiqLegSegIns", localUtil.format( A1495LiqLegSegIns, "ZZ9.999999"));
         forbiddenHiddens.add("LieqLegSegUpd", localUtil.format( A1496LieqLegSegUpd, "ZZ9.999999"));
         forbiddenHiddens.add("LiqLegError", GXutil.rtrim( localUtil.format( A891LiqLegError, "")));
         forbiddenHiddens.add("LiqNombrePDF", GXutil.rtrim( localUtil.format( A961LiqNombrePDF, "")));
         forbiddenHiddens.add("LiqNombrePDFVertical", GXutil.rtrim( localUtil.format( A962LiqNombrePDFVertical, "")));
         forbiddenHiddens.add("LiqLegHorasSem", localUtil.format( A1546LiqLegHorasSem, "Z9.9"));
         forbiddenHiddens.add("LiqLegAuxEstado", localUtil.format( DecimalUtil.doubleToDec(A1780LiqLegAuxEstado), "9"));
         forbiddenHiddens.add("LiqLegErrorAux", GXutil.rtrim( localUtil.format( A1781LiqLegErrorAux, "")));
         forbiddenHiddens.add("LiqLegFecEgr", localUtil.format(A1815LiqLegFecEgr, "99/99/9999"));
         forbiddenHiddens.add("LiqLegFecIng", localUtil.format(A1816LiqLegFecIng, "99/99/9999"));
         forbiddenHiddens.add("LiqLegCatCodigo", GXutil.rtrim( localUtil.format( A2113LiqLegCatCodigo, "")));
         forbiddenHiddens.add("LiqLegConvenio", GXutil.rtrim( localUtil.format( A2115LiqLegConvenio, "")));
         forbiddenHiddens.add("LiqLegSueldo", localUtil.format( A2114LiqLegSueldo, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         forbiddenHiddens.add("LiqLegPDFEstado", GXutil.rtrim( localUtil.format( A2179LiqLegPDFEstado, "")));
         forbiddenHiddens.add("LiqLegProcesado", localUtil.format( DecimalUtil.doubleToDec(A2268LiqLegProcesado), "9"));
         forbiddenHiddens.add("LiqLegNivLiq", localUtil.format( DecimalUtil.doubleToDec(A2360LiqLegNivLiq), "9"));
         forbiddenHiddens.add("LiqLegLSD", localUtil.format( DecimalUtil.doubleToDec(A2400LiqLegLSD), "9"));
         forbiddenHiddens.add("LiqLegDaemonUUID", GXutil.rtrim( localUtil.format( A2401LiqLegDaemonUUID, "")));
         forbiddenHiddens.add("LiqLegFecHor", localUtil.format( A2402LiqLegFecHor, "99/99/99 99:99"));
         hsh = httpContext.cgiGet( "hsh") ;
         if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) || ( A6LegNumero != Z6LegNumero ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("liquidacionlegajo:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
            A31LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
            A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
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
            initAll0V28( ) ;
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
      disableAttributes0V28( ) ;
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

   public void resetCaption0V0( )
   {
   }

   public void zm0V28( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z281LiqLegImpTotal = T000V3_A281LiqLegImpTotal[0] ;
            Z282LiqLegReciboNro = T000V3_A282LiqLegReciboNro[0] ;
            Z482LegLiqDatosHis = T000V3_A482LegLiqDatosHis[0] ;
            Z498LiqLegImpTotBruto = T000V3_A498LiqLegImpTotBruto[0] ;
            Z759LiqLegImpTotBruSinSAC = T000V3_A759LiqLegImpTotBruSinSAC[0] ;
            Z499LiqLegCntConc = T000V3_A499LiqLegCntConc[0] ;
            Z577LiqLegImpTotRemu = T000V3_A577LiqLegImpTotRemu[0] ;
            Z578LiqLegImpTotNoRemu = T000V3_A578LiqLegImpTotNoRemu[0] ;
            Z579LiqLegImpTotDescu = T000V3_A579LiqLegImpTotDescu[0] ;
            Z1157LiqLegImpContr = T000V3_A1157LiqLegImpContr[0] ;
            Z1158LiqLegImpCosto = T000V3_A1158LiqLegImpCosto[0] ;
            Z1131LiqLegImpOtrDescu = T000V3_A1131LiqLegImpOtrDescu[0] ;
            Z1143LiqLegImpDescuNeg = T000V3_A1143LiqLegImpDescuNeg[0] ;
            Z757LiqLegImpTotRetGan = T000V3_A757LiqLegImpTotRetGan[0] ;
            Z775LiqLegImpPagosACuen = T000V3_A775LiqLegImpPagosACuen[0] ;
            Z758LiqLegImpTotBruProm = T000V3_A758LiqLegImpTotBruProm[0] ;
            Z760LiqLegImpBasico = T000V3_A760LiqLegImpBasico[0] ;
            Z761LiqLegGNSI = T000V3_A761LiqLegGNSI[0] ;
            Z590LiqRutaPDF = T000V3_A590LiqRutaPDF[0] ;
            Z774LiqRutaPDFVertical = T000V3_A774LiqRutaPDFVertical[0] ;
            Z883LIqLegIteraciones = T000V3_A883LIqLegIteraciones[0] ;
            Z884LiqLegSegundos = T000V3_A884LiqLegSegundos[0] ;
            Z1495LiqLegSegIns = T000V3_A1495LiqLegSegIns[0] ;
            Z1496LieqLegSegUpd = T000V3_A1496LieqLegSegUpd[0] ;
            Z891LiqLegError = T000V3_A891LiqLegError[0] ;
            Z961LiqNombrePDF = T000V3_A961LiqNombrePDF[0] ;
            Z962LiqNombrePDFVertical = T000V3_A962LiqNombrePDFVertical[0] ;
            Z1546LiqLegHorasSem = T000V3_A1546LiqLegHorasSem[0] ;
            Z1780LiqLegAuxEstado = T000V3_A1780LiqLegAuxEstado[0] ;
            Z1781LiqLegErrorAux = T000V3_A1781LiqLegErrorAux[0] ;
            Z1815LiqLegFecEgr = T000V3_A1815LiqLegFecEgr[0] ;
            Z1816LiqLegFecIng = T000V3_A1816LiqLegFecIng[0] ;
            Z2113LiqLegCatCodigo = T000V3_A2113LiqLegCatCodigo[0] ;
            Z2115LiqLegConvenio = T000V3_A2115LiqLegConvenio[0] ;
            Z2114LiqLegSueldo = T000V3_A2114LiqLegSueldo[0] ;
            Z2179LiqLegPDFEstado = T000V3_A2179LiqLegPDFEstado[0] ;
            Z2268LiqLegProcesado = T000V3_A2268LiqLegProcesado[0] ;
            Z2360LiqLegNivLiq = T000V3_A2360LiqLegNivLiq[0] ;
            Z2400LiqLegLSD = T000V3_A2400LiqLegLSD[0] ;
            Z2401LiqLegDaemonUUID = T000V3_A2401LiqLegDaemonUUID[0] ;
            Z2402LiqLegFecHor = T000V3_A2402LiqLegFecHor[0] ;
            Z34LiqSecCodigo = T000V3_A34LiqSecCodigo[0] ;
         }
         else
         {
            Z281LiqLegImpTotal = A281LiqLegImpTotal ;
            Z282LiqLegReciboNro = A282LiqLegReciboNro ;
            Z482LegLiqDatosHis = A482LegLiqDatosHis ;
            Z498LiqLegImpTotBruto = A498LiqLegImpTotBruto ;
            Z759LiqLegImpTotBruSinSAC = A759LiqLegImpTotBruSinSAC ;
            Z499LiqLegCntConc = A499LiqLegCntConc ;
            Z577LiqLegImpTotRemu = A577LiqLegImpTotRemu ;
            Z578LiqLegImpTotNoRemu = A578LiqLegImpTotNoRemu ;
            Z579LiqLegImpTotDescu = A579LiqLegImpTotDescu ;
            Z1157LiqLegImpContr = A1157LiqLegImpContr ;
            Z1158LiqLegImpCosto = A1158LiqLegImpCosto ;
            Z1131LiqLegImpOtrDescu = A1131LiqLegImpOtrDescu ;
            Z1143LiqLegImpDescuNeg = A1143LiqLegImpDescuNeg ;
            Z757LiqLegImpTotRetGan = A757LiqLegImpTotRetGan ;
            Z775LiqLegImpPagosACuen = A775LiqLegImpPagosACuen ;
            Z758LiqLegImpTotBruProm = A758LiqLegImpTotBruProm ;
            Z760LiqLegImpBasico = A760LiqLegImpBasico ;
            Z761LiqLegGNSI = A761LiqLegGNSI ;
            Z590LiqRutaPDF = A590LiqRutaPDF ;
            Z774LiqRutaPDFVertical = A774LiqRutaPDFVertical ;
            Z883LIqLegIteraciones = A883LIqLegIteraciones ;
            Z884LiqLegSegundos = A884LiqLegSegundos ;
            Z1495LiqLegSegIns = A1495LiqLegSegIns ;
            Z1496LieqLegSegUpd = A1496LieqLegSegUpd ;
            Z891LiqLegError = A891LiqLegError ;
            Z961LiqNombrePDF = A961LiqNombrePDF ;
            Z962LiqNombrePDFVertical = A962LiqNombrePDFVertical ;
            Z1546LiqLegHorasSem = A1546LiqLegHorasSem ;
            Z1780LiqLegAuxEstado = A1780LiqLegAuxEstado ;
            Z1781LiqLegErrorAux = A1781LiqLegErrorAux ;
            Z1815LiqLegFecEgr = A1815LiqLegFecEgr ;
            Z1816LiqLegFecIng = A1816LiqLegFecIng ;
            Z2113LiqLegCatCodigo = A2113LiqLegCatCodigo ;
            Z2115LiqLegConvenio = A2115LiqLegConvenio ;
            Z2114LiqLegSueldo = A2114LiqLegSueldo ;
            Z2179LiqLegPDFEstado = A2179LiqLegPDFEstado ;
            Z2268LiqLegProcesado = A2268LiqLegProcesado ;
            Z2360LiqLegNivLiq = A2360LiqLegNivLiq ;
            Z2400LiqLegLSD = A2400LiqLegLSD ;
            Z2401LiqLegDaemonUUID = A2401LiqLegDaemonUUID ;
            Z2402LiqLegFecHor = A2402LiqLegFecHor ;
            Z34LiqSecCodigo = A34LiqSecCodigo ;
         }
      }
      if ( GX_JID == -2 )
      {
         Z281LiqLegImpTotal = A281LiqLegImpTotal ;
         Z282LiqLegReciboNro = A282LiqLegReciboNro ;
         Z482LegLiqDatosHis = A482LegLiqDatosHis ;
         Z498LiqLegImpTotBruto = A498LiqLegImpTotBruto ;
         Z759LiqLegImpTotBruSinSAC = A759LiqLegImpTotBruSinSAC ;
         Z499LiqLegCntConc = A499LiqLegCntConc ;
         Z577LiqLegImpTotRemu = A577LiqLegImpTotRemu ;
         Z578LiqLegImpTotNoRemu = A578LiqLegImpTotNoRemu ;
         Z579LiqLegImpTotDescu = A579LiqLegImpTotDescu ;
         Z1157LiqLegImpContr = A1157LiqLegImpContr ;
         Z1158LiqLegImpCosto = A1158LiqLegImpCosto ;
         Z1131LiqLegImpOtrDescu = A1131LiqLegImpOtrDescu ;
         Z1143LiqLegImpDescuNeg = A1143LiqLegImpDescuNeg ;
         Z757LiqLegImpTotRetGan = A757LiqLegImpTotRetGan ;
         Z775LiqLegImpPagosACuen = A775LiqLegImpPagosACuen ;
         Z758LiqLegImpTotBruProm = A758LiqLegImpTotBruProm ;
         Z760LiqLegImpBasico = A760LiqLegImpBasico ;
         Z761LiqLegGNSI = A761LiqLegGNSI ;
         Z590LiqRutaPDF = A590LiqRutaPDF ;
         Z774LiqRutaPDFVertical = A774LiqRutaPDFVertical ;
         Z883LIqLegIteraciones = A883LIqLegIteraciones ;
         Z884LiqLegSegundos = A884LiqLegSegundos ;
         Z1495LiqLegSegIns = A1495LiqLegSegIns ;
         Z1496LieqLegSegUpd = A1496LieqLegSegUpd ;
         Z891LiqLegError = A891LiqLegError ;
         Z283LiqPeriodo = A283LiqPeriodo ;
         Z961LiqNombrePDF = A961LiqNombrePDF ;
         Z962LiqNombrePDFVertical = A962LiqNombrePDFVertical ;
         Z32TLiqCod = A32TLiqCod ;
         Z1546LiqLegHorasSem = A1546LiqLegHorasSem ;
         Z1780LiqLegAuxEstado = A1780LiqLegAuxEstado ;
         Z1781LiqLegErrorAux = A1781LiqLegErrorAux ;
         Z1815LiqLegFecEgr = A1815LiqLegFecEgr ;
         Z1816LiqLegFecIng = A1816LiqLegFecIng ;
         Z2113LiqLegCatCodigo = A2113LiqLegCatCodigo ;
         Z2115LiqLegConvenio = A2115LiqLegConvenio ;
         Z2114LiqLegSueldo = A2114LiqLegSueldo ;
         Z2179LiqLegPDFEstado = A2179LiqLegPDFEstado ;
         Z2268LiqLegProcesado = A2268LiqLegProcesado ;
         Z2360LiqLegNivLiq = A2360LiqLegNivLiq ;
         Z2393LiqLegHtml = A2393LiqLegHtml ;
         Z2400LiqLegLSD = A2400LiqLegLSD ;
         Z2401LiqLegDaemonUUID = A2401LiqLegDaemonUUID ;
         Z2402LiqLegFecHor = A2402LiqLegFecHor ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z31LiqNro = A31LiqNro ;
         Z34LiqSecCodigo = A34LiqSecCodigo ;
         Z2EmpNom = A2EmpNom ;
         Z250LegIdNomApe = A250LegIdNomApe ;
         Z93LegId = A93LegId ;
         Z251LegNombre = A251LegNombre ;
         Z230LegApellido = A230LegApellido ;
         Z284LiqSecDescrip = A284LiqSecDescrip ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( false )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "asdf", ""), 0, "");
      }
   }

   public void standaloneModal( )
   {
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

   public void load0V28( )
   {
      /* Using cursor T000V8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A31LiqNro)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound28 = (short)(1) ;
         A250LegIdNomApe = T000V8_A250LegIdNomApe[0] ;
         A2EmpNom = T000V8_A2EmpNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2EmpNom", A2EmpNom);
         A281LiqLegImpTotal = T000V8_A281LiqLegImpTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A281LiqLegImpTotal", GXutil.ltrimstr( A281LiqLegImpTotal, 14, 2));
         A284LiqSecDescrip = T000V8_A284LiqSecDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A284LiqSecDescrip", A284LiqSecDescrip);
         A282LiqLegReciboNro = T000V8_A282LiqLegReciboNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A282LiqLegReciboNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A282LiqLegReciboNro), 8, 0));
         A93LegId = T000V8_A93LegId[0] ;
         n93LegId = T000V8_n93LegId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A93LegId", A93LegId);
         A482LegLiqDatosHis = T000V8_A482LegLiqDatosHis[0] ;
         A498LiqLegImpTotBruto = T000V8_A498LiqLegImpTotBruto[0] ;
         A759LiqLegImpTotBruSinSAC = T000V8_A759LiqLegImpTotBruSinSAC[0] ;
         A499LiqLegCntConc = T000V8_A499LiqLegCntConc[0] ;
         A577LiqLegImpTotRemu = T000V8_A577LiqLegImpTotRemu[0] ;
         A578LiqLegImpTotNoRemu = T000V8_A578LiqLegImpTotNoRemu[0] ;
         A579LiqLegImpTotDescu = T000V8_A579LiqLegImpTotDescu[0] ;
         A1157LiqLegImpContr = T000V8_A1157LiqLegImpContr[0] ;
         A1158LiqLegImpCosto = T000V8_A1158LiqLegImpCosto[0] ;
         A1131LiqLegImpOtrDescu = T000V8_A1131LiqLegImpOtrDescu[0] ;
         A1143LiqLegImpDescuNeg = T000V8_A1143LiqLegImpDescuNeg[0] ;
         A757LiqLegImpTotRetGan = T000V8_A757LiqLegImpTotRetGan[0] ;
         A775LiqLegImpPagosACuen = T000V8_A775LiqLegImpPagosACuen[0] ;
         A758LiqLegImpTotBruProm = T000V8_A758LiqLegImpTotBruProm[0] ;
         A760LiqLegImpBasico = T000V8_A760LiqLegImpBasico[0] ;
         A761LiqLegGNSI = T000V8_A761LiqLegGNSI[0] ;
         A590LiqRutaPDF = T000V8_A590LiqRutaPDF[0] ;
         A774LiqRutaPDFVertical = T000V8_A774LiqRutaPDFVertical[0] ;
         A883LIqLegIteraciones = T000V8_A883LIqLegIteraciones[0] ;
         A884LiqLegSegundos = T000V8_A884LiqLegSegundos[0] ;
         A1495LiqLegSegIns = T000V8_A1495LiqLegSegIns[0] ;
         A1496LieqLegSegUpd = T000V8_A1496LieqLegSegUpd[0] ;
         A891LiqLegError = T000V8_A891LiqLegError[0] ;
         A283LiqPeriodo = T000V8_A283LiqPeriodo[0] ;
         A961LiqNombrePDF = T000V8_A961LiqNombrePDF[0] ;
         A962LiqNombrePDFVertical = T000V8_A962LiqNombrePDFVertical[0] ;
         A32TLiqCod = T000V8_A32TLiqCod[0] ;
         n32TLiqCod = T000V8_n32TLiqCod[0] ;
         A1546LiqLegHorasSem = T000V8_A1546LiqLegHorasSem[0] ;
         A1780LiqLegAuxEstado = T000V8_A1780LiqLegAuxEstado[0] ;
         A1781LiqLegErrorAux = T000V8_A1781LiqLegErrorAux[0] ;
         A1815LiqLegFecEgr = T000V8_A1815LiqLegFecEgr[0] ;
         A1816LiqLegFecIng = T000V8_A1816LiqLegFecIng[0] ;
         A2113LiqLegCatCodigo = T000V8_A2113LiqLegCatCodigo[0] ;
         A2115LiqLegConvenio = T000V8_A2115LiqLegConvenio[0] ;
         A2114LiqLegSueldo = T000V8_A2114LiqLegSueldo[0] ;
         A2179LiqLegPDFEstado = T000V8_A2179LiqLegPDFEstado[0] ;
         n2179LiqLegPDFEstado = T000V8_n2179LiqLegPDFEstado[0] ;
         A2268LiqLegProcesado = T000V8_A2268LiqLegProcesado[0] ;
         A2360LiqLegNivLiq = T000V8_A2360LiqLegNivLiq[0] ;
         A2393LiqLegHtml = T000V8_A2393LiqLegHtml[0] ;
         A2400LiqLegLSD = T000V8_A2400LiqLegLSD[0] ;
         A2401LiqLegDaemonUUID = T000V8_A2401LiqLegDaemonUUID[0] ;
         n2401LiqLegDaemonUUID = T000V8_n2401LiqLegDaemonUUID[0] ;
         A2402LiqLegFecHor = T000V8_A2402LiqLegFecHor[0] ;
         A251LegNombre = T000V8_A251LegNombre[0] ;
         A230LegApellido = T000V8_A230LegApellido[0] ;
         A34LiqSecCodigo = T000V8_A34LiqSecCodigo[0] ;
         n34LiqSecCodigo = T000V8_n34LiqSecCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A34LiqSecCodigo", A34LiqSecCodigo);
         zm0V28( -2) ;
      }
      pr_default.close(6);
      onLoadActions0V28( ) ;
   }

   public void onLoadActions0V28( )
   {
      /* Using cursor T000V6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
      A283LiqPeriodo = T000V6_A283LiqPeriodo[0] ;
      A32TLiqCod = T000V6_A32TLiqCod[0] ;
      n32TLiqCod = T000V6_n32TLiqCod[0] ;
      pr_default.close(4);
   }

   public void checkExtendedTable0V28( )
   {
      nIsDirty_28 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T000V7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n34LiqSecCodigo), A34LiqSecCodigo});
      if ( (pr_default.getStatus(5) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A34LiqSecCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo Seccion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQSECCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A284LiqSecDescrip = T000V7_A284LiqSecDescrip[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A284LiqSecDescrip", A284LiqSecDescrip);
      pr_default.close(5);
      /* Using cursor T000V4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A2EmpNom = T000V4_A2EmpNom[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A2EmpNom", A2EmpNom);
      pr_default.close(2);
      /* Using cursor T000V6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQNRO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A283LiqPeriodo = T000V6_A283LiqPeriodo[0] ;
      A32TLiqCod = T000V6_A32TLiqCod[0] ;
      n32TLiqCod = T000V6_n32TLiqCod[0] ;
      pr_default.close(4);
      /* Using cursor T000V5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A250LegIdNomApe = T000V5_A250LegIdNomApe[0] ;
      A93LegId = T000V5_A93LegId[0] ;
      n93LegId = T000V5_n93LegId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A93LegId", A93LegId);
      A251LegNombre = T000V5_A251LegNombre[0] ;
      A251LegNombre = T000V5_A251LegNombre[0] ;
      A230LegApellido = T000V5_A230LegApellido[0] ;
      A230LegApellido = T000V5_A230LegApellido[0] ;
      pr_default.close(3);
   }

   public void closeExtendedTableCursors0V28( )
   {
      pr_default.close(5);
      pr_default.close(2);
      pr_default.close(4);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_6( int A3CliCod ,
                         String A34LiqSecCodigo )
   {
      /* Using cursor T000V9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n34LiqSecCodigo), A34LiqSecCodigo});
      if ( (pr_default.getStatus(7) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A34LiqSecCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo Seccion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQSECCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A284LiqSecDescrip = T000V9_A284LiqSecDescrip[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A284LiqSecDescrip", A284LiqSecDescrip);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A284LiqSecDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void gxload_3( int A3CliCod ,
                         short A1EmpCod )
   {
      /* Using cursor T000V10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A2EmpNom = T000V10_A2EmpNom[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A2EmpNom", A2EmpNom);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A2EmpNom)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(8) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(8);
   }

   public void gxload_5( int A3CliCod ,
                         short A1EmpCod ,
                         int A31LiqNro )
   {
      /* Using cursor T000V11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
      if ( (pr_default.getStatus(9) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQNRO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A283LiqPeriodo = T000V11_A283LiqPeriodo[0] ;
      A32TLiqCod = T000V11_A32TLiqCod[0] ;
      n32TLiqCod = T000V11_n32TLiqCod[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( localUtil.format(A283LiqPeriodo, "99/99/9999"))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A32TLiqCod))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(9) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(9);
   }

   public void gxload_4( int A3CliCod ,
                         short A1EmpCod ,
                         int A6LegNumero )
   {
      /* Using cursor T000V12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A250LegIdNomApe = T000V12_A250LegIdNomApe[0] ;
      A93LegId = T000V12_A93LegId[0] ;
      n93LegId = T000V12_n93LegId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A93LegId", A93LegId);
      A251LegNombre = T000V12_A251LegNombre[0] ;
      A251LegNombre = T000V12_A251LegNombre[0] ;
      A230LegApellido = T000V12_A230LegApellido[0] ;
      A230LegApellido = T000V12_A230LegApellido[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A250LegIdNomApe)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A93LegId))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A251LegNombre)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A230LegApellido)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A230LegApellido)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A251LegNombre)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(10) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(10);
   }

   public void getKey0V28( )
   {
      /* Using cursor T000V13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound28 = (short)(1) ;
      }
      else
      {
         RcdFound28 = (short)(0) ;
      }
      pr_default.close(11);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000V3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0V28( 2) ;
         RcdFound28 = (short)(1) ;
         A281LiqLegImpTotal = T000V3_A281LiqLegImpTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A281LiqLegImpTotal", GXutil.ltrimstr( A281LiqLegImpTotal, 14, 2));
         A282LiqLegReciboNro = T000V3_A282LiqLegReciboNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A282LiqLegReciboNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A282LiqLegReciboNro), 8, 0));
         A482LegLiqDatosHis = T000V3_A482LegLiqDatosHis[0] ;
         A498LiqLegImpTotBruto = T000V3_A498LiqLegImpTotBruto[0] ;
         A759LiqLegImpTotBruSinSAC = T000V3_A759LiqLegImpTotBruSinSAC[0] ;
         A499LiqLegCntConc = T000V3_A499LiqLegCntConc[0] ;
         A577LiqLegImpTotRemu = T000V3_A577LiqLegImpTotRemu[0] ;
         A578LiqLegImpTotNoRemu = T000V3_A578LiqLegImpTotNoRemu[0] ;
         A579LiqLegImpTotDescu = T000V3_A579LiqLegImpTotDescu[0] ;
         A1157LiqLegImpContr = T000V3_A1157LiqLegImpContr[0] ;
         A1158LiqLegImpCosto = T000V3_A1158LiqLegImpCosto[0] ;
         A1131LiqLegImpOtrDescu = T000V3_A1131LiqLegImpOtrDescu[0] ;
         A1143LiqLegImpDescuNeg = T000V3_A1143LiqLegImpDescuNeg[0] ;
         A757LiqLegImpTotRetGan = T000V3_A757LiqLegImpTotRetGan[0] ;
         A775LiqLegImpPagosACuen = T000V3_A775LiqLegImpPagosACuen[0] ;
         A758LiqLegImpTotBruProm = T000V3_A758LiqLegImpTotBruProm[0] ;
         A760LiqLegImpBasico = T000V3_A760LiqLegImpBasico[0] ;
         A761LiqLegGNSI = T000V3_A761LiqLegGNSI[0] ;
         A590LiqRutaPDF = T000V3_A590LiqRutaPDF[0] ;
         A774LiqRutaPDFVertical = T000V3_A774LiqRutaPDFVertical[0] ;
         A883LIqLegIteraciones = T000V3_A883LIqLegIteraciones[0] ;
         A884LiqLegSegundos = T000V3_A884LiqLegSegundos[0] ;
         A1495LiqLegSegIns = T000V3_A1495LiqLegSegIns[0] ;
         A1496LieqLegSegUpd = T000V3_A1496LieqLegSegUpd[0] ;
         A891LiqLegError = T000V3_A891LiqLegError[0] ;
         A961LiqNombrePDF = T000V3_A961LiqNombrePDF[0] ;
         A962LiqNombrePDFVertical = T000V3_A962LiqNombrePDFVertical[0] ;
         A1546LiqLegHorasSem = T000V3_A1546LiqLegHorasSem[0] ;
         A1780LiqLegAuxEstado = T000V3_A1780LiqLegAuxEstado[0] ;
         A1781LiqLegErrorAux = T000V3_A1781LiqLegErrorAux[0] ;
         A1815LiqLegFecEgr = T000V3_A1815LiqLegFecEgr[0] ;
         A1816LiqLegFecIng = T000V3_A1816LiqLegFecIng[0] ;
         A2113LiqLegCatCodigo = T000V3_A2113LiqLegCatCodigo[0] ;
         A2115LiqLegConvenio = T000V3_A2115LiqLegConvenio[0] ;
         A2114LiqLegSueldo = T000V3_A2114LiqLegSueldo[0] ;
         A2179LiqLegPDFEstado = T000V3_A2179LiqLegPDFEstado[0] ;
         n2179LiqLegPDFEstado = T000V3_n2179LiqLegPDFEstado[0] ;
         A2268LiqLegProcesado = T000V3_A2268LiqLegProcesado[0] ;
         A2360LiqLegNivLiq = T000V3_A2360LiqLegNivLiq[0] ;
         A2393LiqLegHtml = T000V3_A2393LiqLegHtml[0] ;
         A2400LiqLegLSD = T000V3_A2400LiqLegLSD[0] ;
         A2401LiqLegDaemonUUID = T000V3_A2401LiqLegDaemonUUID[0] ;
         n2401LiqLegDaemonUUID = T000V3_n2401LiqLegDaemonUUID[0] ;
         A2402LiqLegFecHor = T000V3_A2402LiqLegFecHor[0] ;
         A3CliCod = T000V3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T000V3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T000V3_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A31LiqNro = T000V3_A31LiqNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         A34LiqSecCodigo = T000V3_A34LiqSecCodigo[0] ;
         n34LiqSecCodigo = T000V3_n34LiqSecCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A34LiqSecCodigo", A34LiqSecCodigo);
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z31LiqNro = A31LiqNro ;
         Z6LegNumero = A6LegNumero ;
         sMode28 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0V28( ) ;
         if ( AnyError == 1 )
         {
            RcdFound28 = (short)(0) ;
            initializeNonKey0V28( ) ;
         }
         Gx_mode = sMode28 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound28 = (short)(0) ;
         initializeNonKey0V28( ) ;
         sMode28 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode28 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0V28( ) ;
      if ( RcdFound28 == 0 )
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
      RcdFound28 = (short)(0) ;
      /* Using cursor T000V14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A31LiqNro)});
      if ( (pr_default.getStatus(12) != 101) )
      {
         while ( (pr_default.getStatus(12) != 101) && ( ( T000V14_A3CliCod[0] < A3CliCod ) || ( T000V14_A3CliCod[0] == A3CliCod ) && ( T000V14_A1EmpCod[0] < A1EmpCod ) || ( T000V14_A1EmpCod[0] == A1EmpCod ) && ( T000V14_A3CliCod[0] == A3CliCod ) && ( T000V14_A6LegNumero[0] < A6LegNumero ) || ( T000V14_A6LegNumero[0] == A6LegNumero ) && ( T000V14_A1EmpCod[0] == A1EmpCod ) && ( T000V14_A3CliCod[0] == A3CliCod ) && ( T000V14_A31LiqNro[0] < A31LiqNro ) ) )
         {
            pr_default.readNext(12);
         }
         if ( (pr_default.getStatus(12) != 101) && ( ( T000V14_A3CliCod[0] > A3CliCod ) || ( T000V14_A3CliCod[0] == A3CliCod ) && ( T000V14_A1EmpCod[0] > A1EmpCod ) || ( T000V14_A1EmpCod[0] == A1EmpCod ) && ( T000V14_A3CliCod[0] == A3CliCod ) && ( T000V14_A6LegNumero[0] > A6LegNumero ) || ( T000V14_A6LegNumero[0] == A6LegNumero ) && ( T000V14_A1EmpCod[0] == A1EmpCod ) && ( T000V14_A3CliCod[0] == A3CliCod ) && ( T000V14_A31LiqNro[0] > A31LiqNro ) ) )
         {
            A3CliCod = T000V14_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T000V14_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T000V14_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A31LiqNro = T000V14_A31LiqNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
            RcdFound28 = (short)(1) ;
         }
      }
      pr_default.close(12);
   }

   public void move_previous( )
   {
      RcdFound28 = (short)(0) ;
      /* Using cursor T000V15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A31LiqNro)});
      if ( (pr_default.getStatus(13) != 101) )
      {
         while ( (pr_default.getStatus(13) != 101) && ( ( T000V15_A3CliCod[0] > A3CliCod ) || ( T000V15_A3CliCod[0] == A3CliCod ) && ( T000V15_A1EmpCod[0] > A1EmpCod ) || ( T000V15_A1EmpCod[0] == A1EmpCod ) && ( T000V15_A3CliCod[0] == A3CliCod ) && ( T000V15_A6LegNumero[0] > A6LegNumero ) || ( T000V15_A6LegNumero[0] == A6LegNumero ) && ( T000V15_A1EmpCod[0] == A1EmpCod ) && ( T000V15_A3CliCod[0] == A3CliCod ) && ( T000V15_A31LiqNro[0] > A31LiqNro ) ) )
         {
            pr_default.readNext(13);
         }
         if ( (pr_default.getStatus(13) != 101) && ( ( T000V15_A3CliCod[0] < A3CliCod ) || ( T000V15_A3CliCod[0] == A3CliCod ) && ( T000V15_A1EmpCod[0] < A1EmpCod ) || ( T000V15_A1EmpCod[0] == A1EmpCod ) && ( T000V15_A3CliCod[0] == A3CliCod ) && ( T000V15_A6LegNumero[0] < A6LegNumero ) || ( T000V15_A6LegNumero[0] == A6LegNumero ) && ( T000V15_A1EmpCod[0] == A1EmpCod ) && ( T000V15_A3CliCod[0] == A3CliCod ) && ( T000V15_A31LiqNro[0] < A31LiqNro ) ) )
         {
            A3CliCod = T000V15_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T000V15_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T000V15_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A31LiqNro = T000V15_A31LiqNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
            RcdFound28 = (short)(1) ;
         }
      }
      pr_default.close(13);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0V28( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtEmpCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0V28( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound28 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) || ( A6LegNumero != Z6LegNumero ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A31LiqNro = Z31LiqNro ;
               httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
               A6LegNumero = Z6LegNumero ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtEmpCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update0V28( ) ;
               GX_FocusControl = edtEmpCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) || ( A6LegNumero != Z6LegNumero ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtEmpCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0V28( ) ;
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
                  GX_FocusControl = edtEmpCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0V28( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) || ( A6LegNumero != Z6LegNumero ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A31LiqNro = Z31LiqNro ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         A6LegNumero = Z6LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtEmpCod_Internalname ;
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
      if ( RcdFound28 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtLiqLegImpTotal_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0V28( ) ;
      if ( RcdFound28 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtLiqLegImpTotal_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0V28( ) ;
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
      if ( RcdFound28 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtLiqLegImpTotal_Internalname ;
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
      if ( RcdFound28 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtLiqLegImpTotal_Internalname ;
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
      scanStart0V28( ) ;
      if ( RcdFound28 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound28 != 0 )
         {
            scanNext0V28( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtLiqLegImpTotal_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0V28( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0V28( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000V2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LiquidacionLegajo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z281LiqLegImpTotal, T000V2_A281LiqLegImpTotal[0]) != 0 ) || ( Z282LiqLegReciboNro != T000V2_A282LiqLegReciboNro[0] ) || ( GXutil.strcmp(Z482LegLiqDatosHis, T000V2_A482LegLiqDatosHis[0]) != 0 ) || ( DecimalUtil.compareTo(Z498LiqLegImpTotBruto, T000V2_A498LiqLegImpTotBruto[0]) != 0 ) || ( DecimalUtil.compareTo(Z759LiqLegImpTotBruSinSAC, T000V2_A759LiqLegImpTotBruSinSAC[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z499LiqLegCntConc != T000V2_A499LiqLegCntConc[0] ) || ( DecimalUtil.compareTo(Z577LiqLegImpTotRemu, T000V2_A577LiqLegImpTotRemu[0]) != 0 ) || ( DecimalUtil.compareTo(Z578LiqLegImpTotNoRemu, T000V2_A578LiqLegImpTotNoRemu[0]) != 0 ) || ( DecimalUtil.compareTo(Z579LiqLegImpTotDescu, T000V2_A579LiqLegImpTotDescu[0]) != 0 ) || ( DecimalUtil.compareTo(Z1157LiqLegImpContr, T000V2_A1157LiqLegImpContr[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1158LiqLegImpCosto, T000V2_A1158LiqLegImpCosto[0]) != 0 ) || ( DecimalUtil.compareTo(Z1131LiqLegImpOtrDescu, T000V2_A1131LiqLegImpOtrDescu[0]) != 0 ) || ( DecimalUtil.compareTo(Z1143LiqLegImpDescuNeg, T000V2_A1143LiqLegImpDescuNeg[0]) != 0 ) || ( DecimalUtil.compareTo(Z757LiqLegImpTotRetGan, T000V2_A757LiqLegImpTotRetGan[0]) != 0 ) || ( DecimalUtil.compareTo(Z775LiqLegImpPagosACuen, T000V2_A775LiqLegImpPagosACuen[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z758LiqLegImpTotBruProm, T000V2_A758LiqLegImpTotBruProm[0]) != 0 ) || ( DecimalUtil.compareTo(Z760LiqLegImpBasico, T000V2_A760LiqLegImpBasico[0]) != 0 ) || ( DecimalUtil.compareTo(Z761LiqLegGNSI, T000V2_A761LiqLegGNSI[0]) != 0 ) || ( GXutil.strcmp(Z590LiqRutaPDF, T000V2_A590LiqRutaPDF[0]) != 0 ) || ( GXutil.strcmp(Z774LiqRutaPDFVertical, T000V2_A774LiqRutaPDFVertical[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z883LIqLegIteraciones != T000V2_A883LIqLegIteraciones[0] ) || ( DecimalUtil.compareTo(Z884LiqLegSegundos, T000V2_A884LiqLegSegundos[0]) != 0 ) || ( DecimalUtil.compareTo(Z1495LiqLegSegIns, T000V2_A1495LiqLegSegIns[0]) != 0 ) || ( DecimalUtil.compareTo(Z1496LieqLegSegUpd, T000V2_A1496LieqLegSegUpd[0]) != 0 ) || ( GXutil.strcmp(Z891LiqLegError, T000V2_A891LiqLegError[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z961LiqNombrePDF, T000V2_A961LiqNombrePDF[0]) != 0 ) || ( GXutil.strcmp(Z962LiqNombrePDFVertical, T000V2_A962LiqNombrePDFVertical[0]) != 0 ) || ( DecimalUtil.compareTo(Z1546LiqLegHorasSem, T000V2_A1546LiqLegHorasSem[0]) != 0 ) || ( Z1780LiqLegAuxEstado != T000V2_A1780LiqLegAuxEstado[0] ) || ( GXutil.strcmp(Z1781LiqLegErrorAux, T000V2_A1781LiqLegErrorAux[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z1815LiqLegFecEgr), GXutil.resetTime(T000V2_A1815LiqLegFecEgr[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z1816LiqLegFecIng), GXutil.resetTime(T000V2_A1816LiqLegFecIng[0])) ) || ( GXutil.strcmp(Z2113LiqLegCatCodigo, T000V2_A2113LiqLegCatCodigo[0]) != 0 ) || ( GXutil.strcmp(Z2115LiqLegConvenio, T000V2_A2115LiqLegConvenio[0]) != 0 ) || ( DecimalUtil.compareTo(Z2114LiqLegSueldo, T000V2_A2114LiqLegSueldo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2179LiqLegPDFEstado, T000V2_A2179LiqLegPDFEstado[0]) != 0 ) || ( Z2268LiqLegProcesado != T000V2_A2268LiqLegProcesado[0] ) || ( Z2360LiqLegNivLiq != T000V2_A2360LiqLegNivLiq[0] ) || ( Z2400LiqLegLSD != T000V2_A2400LiqLegLSD[0] ) || ( GXutil.strcmp(Z2401LiqLegDaemonUUID, T000V2_A2401LiqLegDaemonUUID[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(Z2402LiqLegFecHor, T000V2_A2402LiqLegFecHor[0]) ) || ( GXutil.strcmp(Z34LiqSecCodigo, T000V2_A34LiqSecCodigo[0]) != 0 ) )
         {
            if ( DecimalUtil.compareTo(Z281LiqLegImpTotal, T000V2_A281LiqLegImpTotal[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegImpTotal");
               GXutil.writeLogRaw("Old: ",Z281LiqLegImpTotal);
               GXutil.writeLogRaw("Current: ",T000V2_A281LiqLegImpTotal[0]);
            }
            if ( Z282LiqLegReciboNro != T000V2_A282LiqLegReciboNro[0] )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegReciboNro");
               GXutil.writeLogRaw("Old: ",Z282LiqLegReciboNro);
               GXutil.writeLogRaw("Current: ",T000V2_A282LiqLegReciboNro[0]);
            }
            if ( GXutil.strcmp(Z482LegLiqDatosHis, T000V2_A482LegLiqDatosHis[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LegLiqDatosHis");
               GXutil.writeLogRaw("Old: ",Z482LegLiqDatosHis);
               GXutil.writeLogRaw("Current: ",T000V2_A482LegLiqDatosHis[0]);
            }
            if ( DecimalUtil.compareTo(Z498LiqLegImpTotBruto, T000V2_A498LiqLegImpTotBruto[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegImpTotBruto");
               GXutil.writeLogRaw("Old: ",Z498LiqLegImpTotBruto);
               GXutil.writeLogRaw("Current: ",T000V2_A498LiqLegImpTotBruto[0]);
            }
            if ( DecimalUtil.compareTo(Z759LiqLegImpTotBruSinSAC, T000V2_A759LiqLegImpTotBruSinSAC[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegImpTotBruSinSAC");
               GXutil.writeLogRaw("Old: ",Z759LiqLegImpTotBruSinSAC);
               GXutil.writeLogRaw("Current: ",T000V2_A759LiqLegImpTotBruSinSAC[0]);
            }
            if ( Z499LiqLegCntConc != T000V2_A499LiqLegCntConc[0] )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegCntConc");
               GXutil.writeLogRaw("Old: ",Z499LiqLegCntConc);
               GXutil.writeLogRaw("Current: ",T000V2_A499LiqLegCntConc[0]);
            }
            if ( DecimalUtil.compareTo(Z577LiqLegImpTotRemu, T000V2_A577LiqLegImpTotRemu[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegImpTotRemu");
               GXutil.writeLogRaw("Old: ",Z577LiqLegImpTotRemu);
               GXutil.writeLogRaw("Current: ",T000V2_A577LiqLegImpTotRemu[0]);
            }
            if ( DecimalUtil.compareTo(Z578LiqLegImpTotNoRemu, T000V2_A578LiqLegImpTotNoRemu[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegImpTotNoRemu");
               GXutil.writeLogRaw("Old: ",Z578LiqLegImpTotNoRemu);
               GXutil.writeLogRaw("Current: ",T000V2_A578LiqLegImpTotNoRemu[0]);
            }
            if ( DecimalUtil.compareTo(Z579LiqLegImpTotDescu, T000V2_A579LiqLegImpTotDescu[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegImpTotDescu");
               GXutil.writeLogRaw("Old: ",Z579LiqLegImpTotDescu);
               GXutil.writeLogRaw("Current: ",T000V2_A579LiqLegImpTotDescu[0]);
            }
            if ( DecimalUtil.compareTo(Z1157LiqLegImpContr, T000V2_A1157LiqLegImpContr[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegImpContr");
               GXutil.writeLogRaw("Old: ",Z1157LiqLegImpContr);
               GXutil.writeLogRaw("Current: ",T000V2_A1157LiqLegImpContr[0]);
            }
            if ( DecimalUtil.compareTo(Z1158LiqLegImpCosto, T000V2_A1158LiqLegImpCosto[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegImpCosto");
               GXutil.writeLogRaw("Old: ",Z1158LiqLegImpCosto);
               GXutil.writeLogRaw("Current: ",T000V2_A1158LiqLegImpCosto[0]);
            }
            if ( DecimalUtil.compareTo(Z1131LiqLegImpOtrDescu, T000V2_A1131LiqLegImpOtrDescu[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegImpOtrDescu");
               GXutil.writeLogRaw("Old: ",Z1131LiqLegImpOtrDescu);
               GXutil.writeLogRaw("Current: ",T000V2_A1131LiqLegImpOtrDescu[0]);
            }
            if ( DecimalUtil.compareTo(Z1143LiqLegImpDescuNeg, T000V2_A1143LiqLegImpDescuNeg[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegImpDescuNeg");
               GXutil.writeLogRaw("Old: ",Z1143LiqLegImpDescuNeg);
               GXutil.writeLogRaw("Current: ",T000V2_A1143LiqLegImpDescuNeg[0]);
            }
            if ( DecimalUtil.compareTo(Z757LiqLegImpTotRetGan, T000V2_A757LiqLegImpTotRetGan[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegImpTotRetGan");
               GXutil.writeLogRaw("Old: ",Z757LiqLegImpTotRetGan);
               GXutil.writeLogRaw("Current: ",T000V2_A757LiqLegImpTotRetGan[0]);
            }
            if ( DecimalUtil.compareTo(Z775LiqLegImpPagosACuen, T000V2_A775LiqLegImpPagosACuen[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegImpPagosACuen");
               GXutil.writeLogRaw("Old: ",Z775LiqLegImpPagosACuen);
               GXutil.writeLogRaw("Current: ",T000V2_A775LiqLegImpPagosACuen[0]);
            }
            if ( DecimalUtil.compareTo(Z758LiqLegImpTotBruProm, T000V2_A758LiqLegImpTotBruProm[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegImpTotBruProm");
               GXutil.writeLogRaw("Old: ",Z758LiqLegImpTotBruProm);
               GXutil.writeLogRaw("Current: ",T000V2_A758LiqLegImpTotBruProm[0]);
            }
            if ( DecimalUtil.compareTo(Z760LiqLegImpBasico, T000V2_A760LiqLegImpBasico[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegImpBasico");
               GXutil.writeLogRaw("Old: ",Z760LiqLegImpBasico);
               GXutil.writeLogRaw("Current: ",T000V2_A760LiqLegImpBasico[0]);
            }
            if ( DecimalUtil.compareTo(Z761LiqLegGNSI, T000V2_A761LiqLegGNSI[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegGNSI");
               GXutil.writeLogRaw("Old: ",Z761LiqLegGNSI);
               GXutil.writeLogRaw("Current: ",T000V2_A761LiqLegGNSI[0]);
            }
            if ( GXutil.strcmp(Z590LiqRutaPDF, T000V2_A590LiqRutaPDF[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqRutaPDF");
               GXutil.writeLogRaw("Old: ",Z590LiqRutaPDF);
               GXutil.writeLogRaw("Current: ",T000V2_A590LiqRutaPDF[0]);
            }
            if ( GXutil.strcmp(Z774LiqRutaPDFVertical, T000V2_A774LiqRutaPDFVertical[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqRutaPDFVertical");
               GXutil.writeLogRaw("Old: ",Z774LiqRutaPDFVertical);
               GXutil.writeLogRaw("Current: ",T000V2_A774LiqRutaPDFVertical[0]);
            }
            if ( Z883LIqLegIteraciones != T000V2_A883LIqLegIteraciones[0] )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LIqLegIteraciones");
               GXutil.writeLogRaw("Old: ",Z883LIqLegIteraciones);
               GXutil.writeLogRaw("Current: ",T000V2_A883LIqLegIteraciones[0]);
            }
            if ( DecimalUtil.compareTo(Z884LiqLegSegundos, T000V2_A884LiqLegSegundos[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegSegundos");
               GXutil.writeLogRaw("Old: ",Z884LiqLegSegundos);
               GXutil.writeLogRaw("Current: ",T000V2_A884LiqLegSegundos[0]);
            }
            if ( DecimalUtil.compareTo(Z1495LiqLegSegIns, T000V2_A1495LiqLegSegIns[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegSegIns");
               GXutil.writeLogRaw("Old: ",Z1495LiqLegSegIns);
               GXutil.writeLogRaw("Current: ",T000V2_A1495LiqLegSegIns[0]);
            }
            if ( DecimalUtil.compareTo(Z1496LieqLegSegUpd, T000V2_A1496LieqLegSegUpd[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LieqLegSegUpd");
               GXutil.writeLogRaw("Old: ",Z1496LieqLegSegUpd);
               GXutil.writeLogRaw("Current: ",T000V2_A1496LieqLegSegUpd[0]);
            }
            if ( GXutil.strcmp(Z891LiqLegError, T000V2_A891LiqLegError[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegError");
               GXutil.writeLogRaw("Old: ",Z891LiqLegError);
               GXutil.writeLogRaw("Current: ",T000V2_A891LiqLegError[0]);
            }
            if ( GXutil.strcmp(Z961LiqNombrePDF, T000V2_A961LiqNombrePDF[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqNombrePDF");
               GXutil.writeLogRaw("Old: ",Z961LiqNombrePDF);
               GXutil.writeLogRaw("Current: ",T000V2_A961LiqNombrePDF[0]);
            }
            if ( GXutil.strcmp(Z962LiqNombrePDFVertical, T000V2_A962LiqNombrePDFVertical[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqNombrePDFVertical");
               GXutil.writeLogRaw("Old: ",Z962LiqNombrePDFVertical);
               GXutil.writeLogRaw("Current: ",T000V2_A962LiqNombrePDFVertical[0]);
            }
            if ( DecimalUtil.compareTo(Z1546LiqLegHorasSem, T000V2_A1546LiqLegHorasSem[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegHorasSem");
               GXutil.writeLogRaw("Old: ",Z1546LiqLegHorasSem);
               GXutil.writeLogRaw("Current: ",T000V2_A1546LiqLegHorasSem[0]);
            }
            if ( Z1780LiqLegAuxEstado != T000V2_A1780LiqLegAuxEstado[0] )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegAuxEstado");
               GXutil.writeLogRaw("Old: ",Z1780LiqLegAuxEstado);
               GXutil.writeLogRaw("Current: ",T000V2_A1780LiqLegAuxEstado[0]);
            }
            if ( GXutil.strcmp(Z1781LiqLegErrorAux, T000V2_A1781LiqLegErrorAux[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegErrorAux");
               GXutil.writeLogRaw("Old: ",Z1781LiqLegErrorAux);
               GXutil.writeLogRaw("Current: ",T000V2_A1781LiqLegErrorAux[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z1815LiqLegFecEgr), GXutil.resetTime(T000V2_A1815LiqLegFecEgr[0])) ) )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegFecEgr");
               GXutil.writeLogRaw("Old: ",Z1815LiqLegFecEgr);
               GXutil.writeLogRaw("Current: ",T000V2_A1815LiqLegFecEgr[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z1816LiqLegFecIng), GXutil.resetTime(T000V2_A1816LiqLegFecIng[0])) ) )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegFecIng");
               GXutil.writeLogRaw("Old: ",Z1816LiqLegFecIng);
               GXutil.writeLogRaw("Current: ",T000V2_A1816LiqLegFecIng[0]);
            }
            if ( GXutil.strcmp(Z2113LiqLegCatCodigo, T000V2_A2113LiqLegCatCodigo[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegCatCodigo");
               GXutil.writeLogRaw("Old: ",Z2113LiqLegCatCodigo);
               GXutil.writeLogRaw("Current: ",T000V2_A2113LiqLegCatCodigo[0]);
            }
            if ( GXutil.strcmp(Z2115LiqLegConvenio, T000V2_A2115LiqLegConvenio[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegConvenio");
               GXutil.writeLogRaw("Old: ",Z2115LiqLegConvenio);
               GXutil.writeLogRaw("Current: ",T000V2_A2115LiqLegConvenio[0]);
            }
            if ( DecimalUtil.compareTo(Z2114LiqLegSueldo, T000V2_A2114LiqLegSueldo[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegSueldo");
               GXutil.writeLogRaw("Old: ",Z2114LiqLegSueldo);
               GXutil.writeLogRaw("Current: ",T000V2_A2114LiqLegSueldo[0]);
            }
            if ( GXutil.strcmp(Z2179LiqLegPDFEstado, T000V2_A2179LiqLegPDFEstado[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegPDFEstado");
               GXutil.writeLogRaw("Old: ",Z2179LiqLegPDFEstado);
               GXutil.writeLogRaw("Current: ",T000V2_A2179LiqLegPDFEstado[0]);
            }
            if ( Z2268LiqLegProcesado != T000V2_A2268LiqLegProcesado[0] )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegProcesado");
               GXutil.writeLogRaw("Old: ",Z2268LiqLegProcesado);
               GXutil.writeLogRaw("Current: ",T000V2_A2268LiqLegProcesado[0]);
            }
            if ( Z2360LiqLegNivLiq != T000V2_A2360LiqLegNivLiq[0] )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegNivLiq");
               GXutil.writeLogRaw("Old: ",Z2360LiqLegNivLiq);
               GXutil.writeLogRaw("Current: ",T000V2_A2360LiqLegNivLiq[0]);
            }
            if ( Z2400LiqLegLSD != T000V2_A2400LiqLegLSD[0] )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegLSD");
               GXutil.writeLogRaw("Old: ",Z2400LiqLegLSD);
               GXutil.writeLogRaw("Current: ",T000V2_A2400LiqLegLSD[0]);
            }
            if ( GXutil.strcmp(Z2401LiqLegDaemonUUID, T000V2_A2401LiqLegDaemonUUID[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegDaemonUUID");
               GXutil.writeLogRaw("Old: ",Z2401LiqLegDaemonUUID);
               GXutil.writeLogRaw("Current: ",T000V2_A2401LiqLegDaemonUUID[0]);
            }
            if ( !( GXutil.dateCompare(Z2402LiqLegFecHor, T000V2_A2402LiqLegFecHor[0]) ) )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqLegFecHor");
               GXutil.writeLogRaw("Old: ",Z2402LiqLegFecHor);
               GXutil.writeLogRaw("Current: ",T000V2_A2402LiqLegFecHor[0]);
            }
            if ( GXutil.strcmp(Z34LiqSecCodigo, T000V2_A34LiqSecCodigo[0]) != 0 )
            {
               GXutil.writeLogln("liquidacionlegajo:[seudo value changed for attri]"+"LiqSecCodigo");
               GXutil.writeLogRaw("Old: ",Z34LiqSecCodigo);
               GXutil.writeLogRaw("Current: ",T000V2_A34LiqSecCodigo[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LiquidacionLegajo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0V28( )
   {
      beforeValidate0V28( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0V28( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0V28( 0) ;
         checkOptimisticConcurrency0V28( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0V28( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0V28( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000V16 */
                  pr_default.execute(14, new Object[] {A283LiqPeriodo, Boolean.valueOf(n32TLiqCod), A32TLiqCod, A281LiqLegImpTotal, Integer.valueOf(A282LiqLegReciboNro), A482LegLiqDatosHis, A498LiqLegImpTotBruto, A759LiqLegImpTotBruSinSAC, Short.valueOf(A499LiqLegCntConc), A577LiqLegImpTotRemu, A578LiqLegImpTotNoRemu, A579LiqLegImpTotDescu, A1157LiqLegImpContr, A1158LiqLegImpCosto, A1131LiqLegImpOtrDescu, A1143LiqLegImpDescuNeg, A757LiqLegImpTotRetGan, A775LiqLegImpPagosACuen, A758LiqLegImpTotBruProm, A760LiqLegImpBasico, A761LiqLegGNSI, A590LiqRutaPDF, A774LiqRutaPDFVertical, Short.valueOf(A883LIqLegIteraciones), A884LiqLegSegundos, A1495LiqLegSegIns, A1496LieqLegSegUpd, A891LiqLegError, A961LiqNombrePDF, A962LiqNombrePDFVertical, A1546LiqLegHorasSem, Byte.valueOf(A1780LiqLegAuxEstado), A1781LiqLegErrorAux, A1815LiqLegFecEgr, A1816LiqLegFecIng, A2113LiqLegCatCodigo, A2115LiqLegConvenio, A2114LiqLegSueldo, Boolean.valueOf(n2179LiqLegPDFEstado), A2179LiqLegPDFEstado, Byte.valueOf(A2268LiqLegProcesado), Byte.valueOf(A2360LiqLegNivLiq), A2393LiqLegHtml, Byte.valueOf(A2400LiqLegLSD), Boolean.valueOf(n2401LiqLegDaemonUUID), A2401LiqLegDaemonUUID, A2402LiqLegFecHor, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A31LiqNro), Boolean.valueOf(n34LiqSecCodigo), A34LiqSecCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
                  if ( (pr_default.getStatus(14) == 1) )
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
                        resetCaption0V0( ) ;
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
            load0V28( ) ;
         }
         endLevel0V28( ) ;
      }
      closeExtendedTableCursors0V28( ) ;
   }

   public void update0V28( )
   {
      beforeValidate0V28( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0V28( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0V28( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0V28( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0V28( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000V17 */
                  pr_default.execute(15, new Object[] {A283LiqPeriodo, Boolean.valueOf(n32TLiqCod), A32TLiqCod, A281LiqLegImpTotal, Integer.valueOf(A282LiqLegReciboNro), A482LegLiqDatosHis, A498LiqLegImpTotBruto, A759LiqLegImpTotBruSinSAC, Short.valueOf(A499LiqLegCntConc), A577LiqLegImpTotRemu, A578LiqLegImpTotNoRemu, A579LiqLegImpTotDescu, A1157LiqLegImpContr, A1158LiqLegImpCosto, A1131LiqLegImpOtrDescu, A1143LiqLegImpDescuNeg, A757LiqLegImpTotRetGan, A775LiqLegImpPagosACuen, A758LiqLegImpTotBruProm, A760LiqLegImpBasico, A761LiqLegGNSI, A590LiqRutaPDF, A774LiqRutaPDFVertical, Short.valueOf(A883LIqLegIteraciones), A884LiqLegSegundos, A1495LiqLegSegIns, A1496LieqLegSegUpd, A891LiqLegError, A961LiqNombrePDF, A962LiqNombrePDFVertical, A1546LiqLegHorasSem, Byte.valueOf(A1780LiqLegAuxEstado), A1781LiqLegErrorAux, A1815LiqLegFecEgr, A1816LiqLegFecIng, A2113LiqLegCatCodigo, A2115LiqLegConvenio, A2114LiqLegSueldo, Boolean.valueOf(n2179LiqLegPDFEstado), A2179LiqLegPDFEstado, Byte.valueOf(A2268LiqLegProcesado), Byte.valueOf(A2360LiqLegNivLiq), A2393LiqLegHtml, Byte.valueOf(A2400LiqLegLSD), Boolean.valueOf(n2401LiqLegDaemonUUID), A2401LiqLegDaemonUUID, A2402LiqLegFecHor, Boolean.valueOf(n34LiqSecCodigo), A34LiqSecCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
                  if ( (pr_default.getStatus(15) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LiquidacionLegajo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0V28( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption0V0( ) ;
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
         endLevel0V28( ) ;
      }
      closeExtendedTableCursors0V28( ) ;
   }

   public void deferredUpdate0V28( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0V28( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0V28( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0V28( ) ;
         afterConfirm0V28( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0V28( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000V18 */
               pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound28 == 0 )
                     {
                        initAll0V28( ) ;
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
                     resetCaption0V0( ) ;
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
      sMode28 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0V28( ) ;
      Gx_mode = sMode28 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0V28( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000V19 */
         pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         A2EmpNom = T000V19_A2EmpNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2EmpNom", A2EmpNom);
         pr_default.close(17);
         /* Using cursor T000V20 */
         pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         A283LiqPeriodo = T000V20_A283LiqPeriodo[0] ;
         A32TLiqCod = T000V20_A32TLiqCod[0] ;
         n32TLiqCod = T000V20_n32TLiqCod[0] ;
         pr_default.close(18);
         /* Using cursor T000V21 */
         pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         A250LegIdNomApe = T000V21_A250LegIdNomApe[0] ;
         A93LegId = T000V21_A93LegId[0] ;
         n93LegId = T000V21_n93LegId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A93LegId", A93LegId);
         A251LegNombre = T000V21_A251LegNombre[0] ;
         A251LegNombre = T000V21_A251LegNombre[0] ;
         A230LegApellido = T000V21_A230LegApellido[0] ;
         A230LegApellido = T000V21_A230LegApellido[0] ;
         pr_default.close(19);
         /* Using cursor T000V22 */
         pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n34LiqSecCodigo), A34LiqSecCodigo});
         A284LiqSecDescrip = T000V22_A284LiqSecDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A284LiqSecDescrip", A284LiqSecDescrip);
         pr_default.close(20);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000V23 */
         pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(21) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_cuenta_licenciasconsumos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(21);
         /* Using cursor T000V24 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(22) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_cuenta_licenciasaprobaciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(22);
         /* Using cursor T000V25 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(23) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_permanencia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(23);
         /* Using cursor T000V26 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(24) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(24);
         /* Using cursor T000V27 */
         pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(25) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "liquidacionLegajoCalculos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(25);
         /* Using cursor T000V28 */
         pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(26) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion Ajuste", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(26);
         /* Using cursor T000V29 */
         pr_default.execute(27, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(27) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Obligacion Cuenta", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(27);
         /* Using cursor T000V30 */
         pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(28) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Obligacion Cuenta", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(28);
         /* Using cursor T000V31 */
         pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(29) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Obligacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(29);
         /* Using cursor T000V32 */
         pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(30) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "liquidacion_exencion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(30);
         /* Using cursor T000V33 */
         pr_default.execute(31, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(31) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Concepto Cuenta", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(31);
         /* Using cursor T000V34 */
         pr_default.execute(32, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(32) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Concepto Cuenta", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(32);
         /* Using cursor T000V35 */
         pr_default.execute(33, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(33) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Test Table", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(33);
         /* Using cursor T000V36 */
         pr_default.execute(34, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(34) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion Detalle", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(34);
         /* Using cursor T000V37 */
         pr_default.execute(35, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(35) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Agenda de Novedades", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(35);
      }
   }

   public void endLevel0V28( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0V28( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "liquidacionlegajo");
         if ( AnyError == 0 )
         {
            confirmValues0V0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "liquidacionlegajo");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0V28( )
   {
      /* Using cursor T000V38 */
      pr_default.execute(36);
      RcdFound28 = (short)(0) ;
      if ( (pr_default.getStatus(36) != 101) )
      {
         RcdFound28 = (short)(1) ;
         A3CliCod = T000V38_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T000V38_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A31LiqNro = T000V38_A31LiqNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         A6LegNumero = T000V38_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0V28( )
   {
      /* Scan next routine */
      pr_default.readNext(36);
      RcdFound28 = (short)(0) ;
      if ( (pr_default.getStatus(36) != 101) )
      {
         RcdFound28 = (short)(1) ;
         A3CliCod = T000V38_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T000V38_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A31LiqNro = T000V38_A31LiqNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         A6LegNumero = T000V38_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
   }

   public void scanEnd0V28( )
   {
      pr_default.close(36);
   }

   public void afterConfirm0V28( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0V28( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0V28( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0V28( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0V28( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0V28( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0V28( )
   {
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpNom_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpNom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpNom_Enabled), 5, 0), true);
      edtLiqNro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqNro_Enabled), 5, 0), true);
      edtLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      edtLiqLegImpTotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqLegImpTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegImpTotal_Enabled), 5, 0), true);
      edtLiqSecCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqSecCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqSecCodigo_Enabled), 5, 0), true);
      edtLiqSecDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqSecDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqSecDescrip_Enabled), 5, 0), true);
      edtLiqLegReciboNro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqLegReciboNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegReciboNro_Enabled), 5, 0), true);
      edtLegId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegId_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0V28( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0V0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.liquidacionlegajo", new String[] {}, new String[] {}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"LiquidacionLegajo");
      forbiddenHiddens.add("LegLiqDatosHis", GXutil.rtrim( localUtil.format( A482LegLiqDatosHis, "")));
      forbiddenHiddens.add("LiqLegImpTotBruto", localUtil.format( A498LiqLegImpTotBruto, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqLegImpTotBruSinSAC", localUtil.format( A759LiqLegImpTotBruSinSAC, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqLegCntConc", localUtil.format( DecimalUtil.doubleToDec(A499LiqLegCntConc), "ZZZ9"));
      forbiddenHiddens.add("LiqLegImpTotRemu", localUtil.format( A577LiqLegImpTotRemu, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqLegImpTotNoRemu", localUtil.format( A578LiqLegImpTotNoRemu, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqLegImpTotDescu", localUtil.format( A579LiqLegImpTotDescu, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqLegImpContr", localUtil.format( A1157LiqLegImpContr, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqLegImpCosto", localUtil.format( A1158LiqLegImpCosto, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqLegImpOtrDescu", localUtil.format( A1131LiqLegImpOtrDescu, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqLegImpDescuNeg", localUtil.format( A1143LiqLegImpDescuNeg, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqLegImpTotRetGan", localUtil.format( A757LiqLegImpTotRetGan, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqLegImpPagosACuen", localUtil.format( A775LiqLegImpPagosACuen, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqLegImpTotBruProm", localUtil.format( A758LiqLegImpTotBruProm, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqLegImpBasico", localUtil.format( A760LiqLegImpBasico, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqLegGNSI", localUtil.format( A761LiqLegGNSI, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqRutaPDF", GXutil.rtrim( localUtil.format( A590LiqRutaPDF, "")));
      forbiddenHiddens.add("LiqRutaPDFVertical", GXutil.rtrim( localUtil.format( A774LiqRutaPDFVertical, "")));
      forbiddenHiddens.add("LIqLegIteraciones", localUtil.format( DecimalUtil.doubleToDec(A883LIqLegIteraciones), "ZZZ9"));
      forbiddenHiddens.add("LiqLegSegundos", localUtil.format( A884LiqLegSegundos, "ZZ9.999999"));
      forbiddenHiddens.add("LiqLegSegIns", localUtil.format( A1495LiqLegSegIns, "ZZ9.999999"));
      forbiddenHiddens.add("LieqLegSegUpd", localUtil.format( A1496LieqLegSegUpd, "ZZ9.999999"));
      forbiddenHiddens.add("LiqLegError", GXutil.rtrim( localUtil.format( A891LiqLegError, "")));
      forbiddenHiddens.add("LiqNombrePDF", GXutil.rtrim( localUtil.format( A961LiqNombrePDF, "")));
      forbiddenHiddens.add("LiqNombrePDFVertical", GXutil.rtrim( localUtil.format( A962LiqNombrePDFVertical, "")));
      forbiddenHiddens.add("LiqLegHorasSem", localUtil.format( A1546LiqLegHorasSem, "Z9.9"));
      forbiddenHiddens.add("LiqLegAuxEstado", localUtil.format( DecimalUtil.doubleToDec(A1780LiqLegAuxEstado), "9"));
      forbiddenHiddens.add("LiqLegErrorAux", GXutil.rtrim( localUtil.format( A1781LiqLegErrorAux, "")));
      forbiddenHiddens.add("LiqLegFecEgr", localUtil.format(A1815LiqLegFecEgr, "99/99/9999"));
      forbiddenHiddens.add("LiqLegFecIng", localUtil.format(A1816LiqLegFecIng, "99/99/9999"));
      forbiddenHiddens.add("LiqLegCatCodigo", GXutil.rtrim( localUtil.format( A2113LiqLegCatCodigo, "")));
      forbiddenHiddens.add("LiqLegConvenio", GXutil.rtrim( localUtil.format( A2115LiqLegConvenio, "")));
      forbiddenHiddens.add("LiqLegSueldo", localUtil.format( A2114LiqLegSueldo, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("LiqLegPDFEstado", GXutil.rtrim( localUtil.format( A2179LiqLegPDFEstado, "")));
      forbiddenHiddens.add("LiqLegProcesado", localUtil.format( DecimalUtil.doubleToDec(A2268LiqLegProcesado), "9"));
      forbiddenHiddens.add("LiqLegNivLiq", localUtil.format( DecimalUtil.doubleToDec(A2360LiqLegNivLiq), "9"));
      forbiddenHiddens.add("LiqLegLSD", localUtil.format( DecimalUtil.doubleToDec(A2400LiqLegLSD), "9"));
      forbiddenHiddens.add("LiqLegDaemonUUID", GXutil.rtrim( localUtil.format( A2401LiqLegDaemonUUID, "")));
      forbiddenHiddens.add("LiqLegFecHor", localUtil.format( A2402LiqLegFecHor, "99/99/99 99:99"));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("liquidacionlegajo:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z31LiqNro", GXutil.ltrim( localUtil.ntoc( Z31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z281LiqLegImpTotal", GXutil.ltrim( localUtil.ntoc( Z281LiqLegImpTotal, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z282LiqLegReciboNro", GXutil.ltrim( localUtil.ntoc( Z282LiqLegReciboNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z482LegLiqDatosHis", Z482LegLiqDatosHis);
      web.GxWebStd.gx_hidden_field( httpContext, "Z498LiqLegImpTotBruto", GXutil.ltrim( localUtil.ntoc( Z498LiqLegImpTotBruto, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z759LiqLegImpTotBruSinSAC", GXutil.ltrim( localUtil.ntoc( Z759LiqLegImpTotBruSinSAC, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z499LiqLegCntConc", GXutil.ltrim( localUtil.ntoc( Z499LiqLegCntConc, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z577LiqLegImpTotRemu", GXutil.ltrim( localUtil.ntoc( Z577LiqLegImpTotRemu, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z578LiqLegImpTotNoRemu", GXutil.ltrim( localUtil.ntoc( Z578LiqLegImpTotNoRemu, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z579LiqLegImpTotDescu", GXutil.ltrim( localUtil.ntoc( Z579LiqLegImpTotDescu, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1157LiqLegImpContr", GXutil.ltrim( localUtil.ntoc( Z1157LiqLegImpContr, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1158LiqLegImpCosto", GXutil.ltrim( localUtil.ntoc( Z1158LiqLegImpCosto, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1131LiqLegImpOtrDescu", GXutil.ltrim( localUtil.ntoc( Z1131LiqLegImpOtrDescu, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1143LiqLegImpDescuNeg", GXutil.ltrim( localUtil.ntoc( Z1143LiqLegImpDescuNeg, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z757LiqLegImpTotRetGan", GXutil.ltrim( localUtil.ntoc( Z757LiqLegImpTotRetGan, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z775LiqLegImpPagosACuen", GXutil.ltrim( localUtil.ntoc( Z775LiqLegImpPagosACuen, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z758LiqLegImpTotBruProm", GXutil.ltrim( localUtil.ntoc( Z758LiqLegImpTotBruProm, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z760LiqLegImpBasico", GXutil.ltrim( localUtil.ntoc( Z760LiqLegImpBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z761LiqLegGNSI", GXutil.ltrim( localUtil.ntoc( Z761LiqLegGNSI, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z590LiqRutaPDF", Z590LiqRutaPDF);
      web.GxWebStd.gx_hidden_field( httpContext, "Z774LiqRutaPDFVertical", Z774LiqRutaPDFVertical);
      web.GxWebStd.gx_hidden_field( httpContext, "Z883LIqLegIteraciones", GXutil.ltrim( localUtil.ntoc( Z883LIqLegIteraciones, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z884LiqLegSegundos", GXutil.ltrim( localUtil.ntoc( Z884LiqLegSegundos, (byte)(10), (byte)(6), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1495LiqLegSegIns", GXutil.ltrim( localUtil.ntoc( Z1495LiqLegSegIns, (byte)(10), (byte)(6), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1496LieqLegSegUpd", GXutil.ltrim( localUtil.ntoc( Z1496LieqLegSegUpd, (byte)(10), (byte)(6), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z891LiqLegError", Z891LiqLegError);
      web.GxWebStd.gx_hidden_field( httpContext, "Z961LiqNombrePDF", GXutil.rtrim( Z961LiqNombrePDF));
      web.GxWebStd.gx_hidden_field( httpContext, "Z962LiqNombrePDFVertical", GXutil.rtrim( Z962LiqNombrePDFVertical));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1546LiqLegHorasSem", GXutil.ltrim( localUtil.ntoc( Z1546LiqLegHorasSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1780LiqLegAuxEstado", GXutil.ltrim( localUtil.ntoc( Z1780LiqLegAuxEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1781LiqLegErrorAux", Z1781LiqLegErrorAux);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1815LiqLegFecEgr", localUtil.dtoc( Z1815LiqLegFecEgr, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1816LiqLegFecIng", localUtil.dtoc( Z1816LiqLegFecIng, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2113LiqLegCatCodigo", GXutil.rtrim( Z2113LiqLegCatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2115LiqLegConvenio", GXutil.rtrim( Z2115LiqLegConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2114LiqLegSueldo", GXutil.ltrim( localUtil.ntoc( Z2114LiqLegSueldo, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2179LiqLegPDFEstado", GXutil.rtrim( Z2179LiqLegPDFEstado));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2268LiqLegProcesado", GXutil.ltrim( localUtil.ntoc( Z2268LiqLegProcesado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2360LiqLegNivLiq", GXutil.ltrim( localUtil.ntoc( Z2360LiqLegNivLiq, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2400LiqLegLSD", GXutil.ltrim( localUtil.ntoc( Z2400LiqLegLSD, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2401LiqLegDaemonUUID", GXutil.rtrim( Z2401LiqLegDaemonUUID));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2402LiqLegFecHor", localUtil.ttoc( Z2402LiqLegFecHor, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "Z34LiqSecCodigo", GXutil.rtrim( Z34LiqSecCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGLIQDATOSHIS", A482LegLiqDatosHis);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGIMPTOTBRUTO", GXutil.ltrim( localUtil.ntoc( A498LiqLegImpTotBruto, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGIMPTOTBRUSINSAC", GXutil.ltrim( localUtil.ntoc( A759LiqLegImpTotBruSinSAC, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGCNTCONC", GXutil.ltrim( localUtil.ntoc( A499LiqLegCntConc, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGIMPTOTREMU", GXutil.ltrim( localUtil.ntoc( A577LiqLegImpTotRemu, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGIMPTOTNOREMU", GXutil.ltrim( localUtil.ntoc( A578LiqLegImpTotNoRemu, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGIMPTOTDESCU", GXutil.ltrim( localUtil.ntoc( A579LiqLegImpTotDescu, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGIMPCONTR", GXutil.ltrim( localUtil.ntoc( A1157LiqLegImpContr, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGIMPCOSTO", GXutil.ltrim( localUtil.ntoc( A1158LiqLegImpCosto, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGIMPOTRDESCU", GXutil.ltrim( localUtil.ntoc( A1131LiqLegImpOtrDescu, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGIMPDESCUNEG", GXutil.ltrim( localUtil.ntoc( A1143LiqLegImpDescuNeg, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGIMPTOTRETGAN", GXutil.ltrim( localUtil.ntoc( A757LiqLegImpTotRetGan, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGIMPPAGOSACUEN", GXutil.ltrim( localUtil.ntoc( A775LiqLegImpPagosACuen, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGIMPTOTBRUPROM", GXutil.ltrim( localUtil.ntoc( A758LiqLegImpTotBruProm, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGIMPBASICO", GXutil.ltrim( localUtil.ntoc( A760LiqLegImpBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGGNSI", GXutil.ltrim( localUtil.ntoc( A761LiqLegGNSI, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQRUTAPDF", A590LiqRutaPDF);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQRUTAPDFVERTICAL", A774LiqRutaPDFVertical);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGITERACIONES", GXutil.ltrim( localUtil.ntoc( A883LIqLegIteraciones, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGSEGUNDOS", GXutil.ltrim( localUtil.ntoc( A884LiqLegSegundos, (byte)(10), (byte)(6), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGSEGINS", GXutil.ltrim( localUtil.ntoc( A1495LiqLegSegIns, (byte)(10), (byte)(6), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIEQLEGSEGUPD", GXutil.ltrim( localUtil.ntoc( A1496LieqLegSegUpd, (byte)(10), (byte)(6), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGERROR", A891LiqLegError);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQNOMBREPDF", GXutil.rtrim( A961LiqNombrePDF));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQNOMBREPDFVERTICAL", GXutil.rtrim( A962LiqNombrePDFVertical));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGHORASSEM", GXutil.ltrim( localUtil.ntoc( A1546LiqLegHorasSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGAUXESTADO", GXutil.ltrim( localUtil.ntoc( A1780LiqLegAuxEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGERRORAUX", A1781LiqLegErrorAux);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGFECEGR", localUtil.dtoc( A1815LiqLegFecEgr, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGFECING", localUtil.dtoc( A1816LiqLegFecIng, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGCATCODIGO", GXutil.rtrim( A2113LiqLegCatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGCONVENIO", GXutil.rtrim( A2115LiqLegConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGSUELDO", GXutil.ltrim( localUtil.ntoc( A2114LiqLegSueldo, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGPDFESTADO", GXutil.rtrim( A2179LiqLegPDFEstado));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGPROCESADO", GXutil.ltrim( localUtil.ntoc( A2268LiqLegProcesado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGNIVLIQ", GXutil.ltrim( localUtil.ntoc( A2360LiqLegNivLiq, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGHTML", A2393LiqLegHtml);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGLSD", GXutil.ltrim( localUtil.ntoc( A2400LiqLegLSD, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGDAEMONUUID", GXutil.rtrim( A2401LiqLegDaemonUUID));
      web.GxWebStd.gx_hidden_field( httpContext, "LIQLEGFECHOR", localUtil.ttoc( A2402LiqLegFecHor, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGIDNOMAPE", A250LegIdNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNOMBRE", A251LegNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGAPELLIDO", A230LegApellido);
      web.GxWebStd.gx_hidden_field( httpContext, "LIQPERIODO", localUtil.dtoc( A283LiqPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "TLIQCOD", GXutil.rtrim( A32TLiqCod));
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
      return formatLink("web.liquidacionlegajo", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "LiquidacionLegajo" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Liquidacion Legajo", "") ;
   }

   public void initializeNonKey0V28( )
   {
      A250LegIdNomApe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A250LegIdNomApe", A250LegIdNomApe);
      A2EmpNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2EmpNom", A2EmpNom);
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A281LiqLegImpTotal", GXutil.ltrimstr( A281LiqLegImpTotal, 14, 2));
      A34LiqSecCodigo = "" ;
      n34LiqSecCodigo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A34LiqSecCodigo", A34LiqSecCodigo);
      n34LiqSecCodigo = ((GXutil.strcmp("", A34LiqSecCodigo)==0) ? true : false) ;
      A284LiqSecDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A284LiqSecDescrip", A284LiqSecDescrip);
      A282LiqLegReciboNro = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A282LiqLegReciboNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A282LiqLegReciboNro), 8, 0));
      A93LegId = "" ;
      n93LegId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A93LegId", A93LegId);
      A482LegLiqDatosHis = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A482LegLiqDatosHis", A482LegLiqDatosHis);
      A498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A498LiqLegImpTotBruto", GXutil.ltrimstr( A498LiqLegImpTotBruto, 14, 2));
      A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A759LiqLegImpTotBruSinSAC", GXutil.ltrimstr( A759LiqLegImpTotBruSinSAC, 14, 2));
      A499LiqLegCntConc = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A499LiqLegCntConc", GXutil.ltrimstr( DecimalUtil.doubleToDec(A499LiqLegCntConc), 4, 0));
      A577LiqLegImpTotRemu = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A577LiqLegImpTotRemu", GXutil.ltrimstr( A577LiqLegImpTotRemu, 14, 2));
      A578LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A578LiqLegImpTotNoRemu", GXutil.ltrimstr( A578LiqLegImpTotNoRemu, 14, 2));
      A579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A579LiqLegImpTotDescu", GXutil.ltrimstr( A579LiqLegImpTotDescu, 14, 2));
      A1157LiqLegImpContr = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1157LiqLegImpContr", GXutil.ltrimstr( A1157LiqLegImpContr, 14, 2));
      A1158LiqLegImpCosto = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1158LiqLegImpCosto", GXutil.ltrimstr( A1158LiqLegImpCosto, 14, 2));
      A1131LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1131LiqLegImpOtrDescu", GXutil.ltrimstr( A1131LiqLegImpOtrDescu, 14, 2));
      A1143LiqLegImpDescuNeg = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1143LiqLegImpDescuNeg", GXutil.ltrimstr( A1143LiqLegImpDescuNeg, 14, 2));
      A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A757LiqLegImpTotRetGan", GXutil.ltrimstr( A757LiqLegImpTotRetGan, 14, 2));
      A775LiqLegImpPagosACuen = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A775LiqLegImpPagosACuen", GXutil.ltrimstr( A775LiqLegImpPagosACuen, 14, 2));
      A758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A758LiqLegImpTotBruProm", GXutil.ltrimstr( A758LiqLegImpTotBruProm, 14, 2));
      A760LiqLegImpBasico = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A760LiqLegImpBasico", GXutil.ltrimstr( A760LiqLegImpBasico, 14, 2));
      A761LiqLegGNSI = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A761LiqLegGNSI", GXutil.ltrimstr( A761LiqLegGNSI, 14, 2));
      A590LiqRutaPDF = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A590LiqRutaPDF", A590LiqRutaPDF);
      A774LiqRutaPDFVertical = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A774LiqRutaPDFVertical", A774LiqRutaPDFVertical);
      A883LIqLegIteraciones = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A883LIqLegIteraciones", GXutil.ltrimstr( DecimalUtil.doubleToDec(A883LIqLegIteraciones), 4, 0));
      A884LiqLegSegundos = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A884LiqLegSegundos", GXutil.ltrimstr( A884LiqLegSegundos, 10, 6));
      A1495LiqLegSegIns = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1495LiqLegSegIns", GXutil.ltrimstr( A1495LiqLegSegIns, 10, 6));
      A1496LieqLegSegUpd = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1496LieqLegSegUpd", GXutil.ltrimstr( A1496LieqLegSegUpd, 10, 6));
      A891LiqLegError = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A891LiqLegError", A891LiqLegError);
      A283LiqPeriodo = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A283LiqPeriodo", localUtil.format(A283LiqPeriodo, "99/99/9999"));
      A961LiqNombrePDF = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A961LiqNombrePDF", A961LiqNombrePDF);
      A962LiqNombrePDFVertical = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A962LiqNombrePDFVertical", A962LiqNombrePDFVertical);
      A32TLiqCod = "" ;
      n32TLiqCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", A32TLiqCod);
      A1546LiqLegHorasSem = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1546LiqLegHorasSem", GXutil.ltrimstr( A1546LiqLegHorasSem, 4, 1));
      A1780LiqLegAuxEstado = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1780LiqLegAuxEstado", GXutil.str( A1780LiqLegAuxEstado, 1, 0));
      A1781LiqLegErrorAux = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1781LiqLegErrorAux", A1781LiqLegErrorAux);
      A1815LiqLegFecEgr = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A1815LiqLegFecEgr", localUtil.format(A1815LiqLegFecEgr, "99/99/9999"));
      A1816LiqLegFecIng = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A1816LiqLegFecIng", localUtil.format(A1816LiqLegFecIng, "99/99/9999"));
      A2113LiqLegCatCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2113LiqLegCatCodigo", A2113LiqLegCatCodigo);
      A2115LiqLegConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2115LiqLegConvenio", A2115LiqLegConvenio);
      A2114LiqLegSueldo = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A2114LiqLegSueldo", GXutil.ltrimstr( A2114LiqLegSueldo, 14, 2));
      A2179LiqLegPDFEstado = "" ;
      n2179LiqLegPDFEstado = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2179LiqLegPDFEstado", A2179LiqLegPDFEstado);
      A2268LiqLegProcesado = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2268LiqLegProcesado", GXutil.str( A2268LiqLegProcesado, 1, 0));
      A2360LiqLegNivLiq = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2360LiqLegNivLiq", GXutil.str( A2360LiqLegNivLiq, 1, 0));
      A2393LiqLegHtml = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2393LiqLegHtml", A2393LiqLegHtml);
      A2400LiqLegLSD = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2400LiqLegLSD", GXutil.str( A2400LiqLegLSD, 1, 0));
      A2401LiqLegDaemonUUID = "" ;
      n2401LiqLegDaemonUUID = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2401LiqLegDaemonUUID", A2401LiqLegDaemonUUID);
      A2402LiqLegFecHor = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "A2402LiqLegFecHor", localUtil.ttoc( A2402LiqLegFecHor, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A251LegNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A251LegNombre", A251LegNombre);
      A230LegApellido = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A230LegApellido", A230LegApellido);
      Z281LiqLegImpTotal = DecimalUtil.ZERO ;
      Z282LiqLegReciboNro = 0 ;
      Z482LegLiqDatosHis = "" ;
      Z498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      Z759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      Z499LiqLegCntConc = (short)(0) ;
      Z577LiqLegImpTotRemu = DecimalUtil.ZERO ;
      Z578LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      Z579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      Z1157LiqLegImpContr = DecimalUtil.ZERO ;
      Z1158LiqLegImpCosto = DecimalUtil.ZERO ;
      Z1131LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      Z1143LiqLegImpDescuNeg = DecimalUtil.ZERO ;
      Z757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      Z775LiqLegImpPagosACuen = DecimalUtil.ZERO ;
      Z758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      Z760LiqLegImpBasico = DecimalUtil.ZERO ;
      Z761LiqLegGNSI = DecimalUtil.ZERO ;
      Z590LiqRutaPDF = "" ;
      Z774LiqRutaPDFVertical = "" ;
      Z883LIqLegIteraciones = (short)(0) ;
      Z884LiqLegSegundos = DecimalUtil.ZERO ;
      Z1495LiqLegSegIns = DecimalUtil.ZERO ;
      Z1496LieqLegSegUpd = DecimalUtil.ZERO ;
      Z891LiqLegError = "" ;
      Z961LiqNombrePDF = "" ;
      Z962LiqNombrePDFVertical = "" ;
      Z1546LiqLegHorasSem = DecimalUtil.ZERO ;
      Z1780LiqLegAuxEstado = (byte)(0) ;
      Z1781LiqLegErrorAux = "" ;
      Z1815LiqLegFecEgr = GXutil.nullDate() ;
      Z1816LiqLegFecIng = GXutil.nullDate() ;
      Z2113LiqLegCatCodigo = "" ;
      Z2115LiqLegConvenio = "" ;
      Z2114LiqLegSueldo = DecimalUtil.ZERO ;
      Z2179LiqLegPDFEstado = "" ;
      Z2268LiqLegProcesado = (byte)(0) ;
      Z2360LiqLegNivLiq = (byte)(0) ;
      Z2400LiqLegLSD = (byte)(0) ;
      Z2401LiqLegDaemonUUID = "" ;
      Z2402LiqLegFecHor = GXutil.resetTime( GXutil.nullDate() );
      Z34LiqSecCodigo = "" ;
   }

   public void initAll0V28( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A31LiqNro = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
      A6LegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      initializeNonKey0V28( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713514310", true, true);
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
      httpContext.AddJavascriptSource("liquidacionlegajo.js", "?20251713514310", false, true);
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
      edtEmpCod_Internalname = "EMPCOD" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpNom_Internalname = "EMPNOM" ;
      edtLiqNro_Internalname = "LIQNRO" ;
      edtLegNumero_Internalname = "LEGNUMERO" ;
      edtLiqLegImpTotal_Internalname = "LIQLEGIMPTOTAL" ;
      edtLiqSecCodigo_Internalname = "LIQSECCODIGO" ;
      edtLiqSecDescrip_Internalname = "LIQSECDESCRIP" ;
      edtLiqLegReciboNro_Internalname = "LIQLEGRECIBONRO" ;
      edtLegId_Internalname = "LEGID" ;
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
      Form.setCaption( httpContext.getMessage( "Liquidacion Legajo", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtLegId_Jsonclick = "" ;
      edtLegId_Enabled = 0 ;
      edtLiqLegReciboNro_Jsonclick = "" ;
      edtLiqLegReciboNro_Enabled = 1 ;
      edtLiqSecDescrip_Enabled = 0 ;
      edtLiqSecCodigo_Jsonclick = "" ;
      edtLiqSecCodigo_Enabled = 1 ;
      edtLiqLegImpTotal_Jsonclick = "" ;
      edtLiqLegImpTotal_Enabled = 1 ;
      edtLegNumero_Jsonclick = "" ;
      edtLegNumero_Enabled = 1 ;
      edtLiqNro_Jsonclick = "" ;
      edtLiqNro_Enabled = 1 ;
      edtEmpNom_Jsonclick = "" ;
      edtEmpNom_Enabled = 0 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
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
      /* Using cursor T000V19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A2EmpNom = T000V19_A2EmpNom[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A2EmpNom", A2EmpNom);
      pr_default.close(17);
      /* Using cursor T000V20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQNRO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A283LiqPeriodo = T000V20_A283LiqPeriodo[0] ;
      A32TLiqCod = T000V20_A32TLiqCod[0] ;
      n32TLiqCod = T000V20_n32TLiqCod[0] ;
      pr_default.close(18);
      /* Using cursor T000V21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A250LegIdNomApe = T000V21_A250LegIdNomApe[0] ;
      A93LegId = T000V21_A93LegId[0] ;
      n93LegId = T000V21_n93LegId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A93LegId", A93LegId);
      A251LegNombre = T000V21_A251LegNombre[0] ;
      A251LegNombre = T000V21_A251LegNombre[0] ;
      A230LegApellido = T000V21_A230LegApellido[0] ;
      A230LegApellido = T000V21_A230LegApellido[0] ;
      pr_default.close(19);
      GX_FocusControl = edtLiqLegImpTotal_Internalname ;
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

   public void valid_Clicod( )
   {
      /* Using cursor T000V19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A2EmpNom = T000V19_A2EmpNom[0] ;
      pr_default.close(17);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A2EmpNom", A2EmpNom);
   }

   public void valid_Liqnro( )
   {
      n32TLiqCod = false ;
      /* Using cursor T000V20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQNRO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A283LiqPeriodo = T000V20_A283LiqPeriodo[0] ;
      A32TLiqCod = T000V20_A32TLiqCod[0] ;
      n32TLiqCod = T000V20_n32TLiqCod[0] ;
      pr_default.close(18);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A283LiqPeriodo", localUtil.format(A283LiqPeriodo, "99/99/9999"));
      httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", GXutil.rtrim( A32TLiqCod));
   }

   public void valid_Legnumero( )
   {
      n2401LiqLegDaemonUUID = false ;
      n2179LiqLegPDFEstado = false ;
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      /* Using cursor T000V21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A250LegIdNomApe = T000V21_A250LegIdNomApe[0] ;
      A93LegId = T000V21_A93LegId[0] ;
      n93LegId = T000V21_n93LegId[0] ;
      A251LegNombre = T000V21_A251LegNombre[0] ;
      A251LegNombre = T000V21_A251LegNombre[0] ;
      A230LegApellido = T000V21_A230LegApellido[0] ;
      A230LegApellido = T000V21_A230LegApellido[0] ;
      pr_default.close(19);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A281LiqLegImpTotal", GXutil.ltrim( localUtil.ntoc( A281LiqLegImpTotal, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A34LiqSecCodigo", GXutil.rtrim( A34LiqSecCodigo));
      httpContext.ajax_rsp_assign_attri("", false, "A282LiqLegReciboNro", GXutil.ltrim( localUtil.ntoc( A282LiqLegReciboNro, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A482LegLiqDatosHis", A482LegLiqDatosHis);
      httpContext.ajax_rsp_assign_attri("", false, "A498LiqLegImpTotBruto", GXutil.ltrim( localUtil.ntoc( A498LiqLegImpTotBruto, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A759LiqLegImpTotBruSinSAC", GXutil.ltrim( localUtil.ntoc( A759LiqLegImpTotBruSinSAC, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A499LiqLegCntConc", GXutil.ltrim( localUtil.ntoc( A499LiqLegCntConc, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A577LiqLegImpTotRemu", GXutil.ltrim( localUtil.ntoc( A577LiqLegImpTotRemu, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A578LiqLegImpTotNoRemu", GXutil.ltrim( localUtil.ntoc( A578LiqLegImpTotNoRemu, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A579LiqLegImpTotDescu", GXutil.ltrim( localUtil.ntoc( A579LiqLegImpTotDescu, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1157LiqLegImpContr", GXutil.ltrim( localUtil.ntoc( A1157LiqLegImpContr, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1158LiqLegImpCosto", GXutil.ltrim( localUtil.ntoc( A1158LiqLegImpCosto, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1131LiqLegImpOtrDescu", GXutil.ltrim( localUtil.ntoc( A1131LiqLegImpOtrDescu, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1143LiqLegImpDescuNeg", GXutil.ltrim( localUtil.ntoc( A1143LiqLegImpDescuNeg, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A757LiqLegImpTotRetGan", GXutil.ltrim( localUtil.ntoc( A757LiqLegImpTotRetGan, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A775LiqLegImpPagosACuen", GXutil.ltrim( localUtil.ntoc( A775LiqLegImpPagosACuen, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A758LiqLegImpTotBruProm", GXutil.ltrim( localUtil.ntoc( A758LiqLegImpTotBruProm, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A760LiqLegImpBasico", GXutil.ltrim( localUtil.ntoc( A760LiqLegImpBasico, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A761LiqLegGNSI", GXutil.ltrim( localUtil.ntoc( A761LiqLegGNSI, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A590LiqRutaPDF", A590LiqRutaPDF);
      httpContext.ajax_rsp_assign_attri("", false, "A774LiqRutaPDFVertical", A774LiqRutaPDFVertical);
      httpContext.ajax_rsp_assign_attri("", false, "A883LIqLegIteraciones", GXutil.ltrim( localUtil.ntoc( A883LIqLegIteraciones, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A884LiqLegSegundos", GXutil.ltrim( localUtil.ntoc( A884LiqLegSegundos, (byte)(10), (byte)(6), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1495LiqLegSegIns", GXutil.ltrim( localUtil.ntoc( A1495LiqLegSegIns, (byte)(10), (byte)(6), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1496LieqLegSegUpd", GXutil.ltrim( localUtil.ntoc( A1496LieqLegSegUpd, (byte)(10), (byte)(6), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A891LiqLegError", A891LiqLegError);
      httpContext.ajax_rsp_assign_attri("", false, "A961LiqNombrePDF", GXutil.rtrim( A961LiqNombrePDF));
      httpContext.ajax_rsp_assign_attri("", false, "A962LiqNombrePDFVertical", GXutil.rtrim( A962LiqNombrePDFVertical));
      httpContext.ajax_rsp_assign_attri("", false, "A1546LiqLegHorasSem", GXutil.ltrim( localUtil.ntoc( A1546LiqLegHorasSem, (byte)(4), (byte)(1), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1780LiqLegAuxEstado", GXutil.ltrim( localUtil.ntoc( A1780LiqLegAuxEstado, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1781LiqLegErrorAux", A1781LiqLegErrorAux);
      httpContext.ajax_rsp_assign_attri("", false, "A1815LiqLegFecEgr", localUtil.format(A1815LiqLegFecEgr, "99/99/9999"));
      httpContext.ajax_rsp_assign_attri("", false, "A1816LiqLegFecIng", localUtil.format(A1816LiqLegFecIng, "99/99/9999"));
      httpContext.ajax_rsp_assign_attri("", false, "A2113LiqLegCatCodigo", GXutil.rtrim( A2113LiqLegCatCodigo));
      httpContext.ajax_rsp_assign_attri("", false, "A2115LiqLegConvenio", GXutil.rtrim( A2115LiqLegConvenio));
      httpContext.ajax_rsp_assign_attri("", false, "A2114LiqLegSueldo", GXutil.ltrim( localUtil.ntoc( A2114LiqLegSueldo, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A2179LiqLegPDFEstado", GXutil.rtrim( A2179LiqLegPDFEstado));
      httpContext.ajax_rsp_assign_attri("", false, "A2268LiqLegProcesado", GXutil.ltrim( localUtil.ntoc( A2268LiqLegProcesado, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A2360LiqLegNivLiq", GXutil.ltrim( localUtil.ntoc( A2360LiqLegNivLiq, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A2393LiqLegHtml", A2393LiqLegHtml);
      httpContext.ajax_rsp_assign_attri("", false, "A2400LiqLegLSD", GXutil.ltrim( localUtil.ntoc( A2400LiqLegLSD, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A2401LiqLegDaemonUUID", GXutil.rtrim( A2401LiqLegDaemonUUID));
      httpContext.ajax_rsp_assign_attri("", false, "A2402LiqLegFecHor", localUtil.ttoc( A2402LiqLegFecHor, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A284LiqSecDescrip", A284LiqSecDescrip);
      httpContext.ajax_rsp_assign_attri("", false, "A2EmpNom", A2EmpNom);
      httpContext.ajax_rsp_assign_attri("", false, "A283LiqPeriodo", localUtil.format(A283LiqPeriodo, "99/99/9999"));
      httpContext.ajax_rsp_assign_attri("", false, "A32TLiqCod", GXutil.rtrim( A32TLiqCod));
      httpContext.ajax_rsp_assign_attri("", false, "A250LegIdNomApe", A250LegIdNomApe);
      httpContext.ajax_rsp_assign_attri("", false, "A93LegId", GXutil.rtrim( A93LegId));
      httpContext.ajax_rsp_assign_attri("", false, "A251LegNombre", A251LegNombre);
      httpContext.ajax_rsp_assign_attri("", false, "A230LegApellido", A230LegApellido);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z31LiqNro", GXutil.ltrim( localUtil.ntoc( Z31LiqNro, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z281LiqLegImpTotal", GXutil.ltrim( localUtil.ntoc( Z281LiqLegImpTotal, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z34LiqSecCodigo", GXutil.rtrim( Z34LiqSecCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z282LiqLegReciboNro", GXutil.ltrim( localUtil.ntoc( Z282LiqLegReciboNro, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z482LegLiqDatosHis", Z482LegLiqDatosHis);
      web.GxWebStd.gx_hidden_field( httpContext, "Z498LiqLegImpTotBruto", GXutil.ltrim( localUtil.ntoc( Z498LiqLegImpTotBruto, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z759LiqLegImpTotBruSinSAC", GXutil.ltrim( localUtil.ntoc( Z759LiqLegImpTotBruSinSAC, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z499LiqLegCntConc", GXutil.ltrim( localUtil.ntoc( Z499LiqLegCntConc, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z577LiqLegImpTotRemu", GXutil.ltrim( localUtil.ntoc( Z577LiqLegImpTotRemu, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z578LiqLegImpTotNoRemu", GXutil.ltrim( localUtil.ntoc( Z578LiqLegImpTotNoRemu, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z579LiqLegImpTotDescu", GXutil.ltrim( localUtil.ntoc( Z579LiqLegImpTotDescu, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1157LiqLegImpContr", GXutil.ltrim( localUtil.ntoc( Z1157LiqLegImpContr, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1158LiqLegImpCosto", GXutil.ltrim( localUtil.ntoc( Z1158LiqLegImpCosto, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1131LiqLegImpOtrDescu", GXutil.ltrim( localUtil.ntoc( Z1131LiqLegImpOtrDescu, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1143LiqLegImpDescuNeg", GXutil.ltrim( localUtil.ntoc( Z1143LiqLegImpDescuNeg, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z757LiqLegImpTotRetGan", GXutil.ltrim( localUtil.ntoc( Z757LiqLegImpTotRetGan, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z775LiqLegImpPagosACuen", GXutil.ltrim( localUtil.ntoc( Z775LiqLegImpPagosACuen, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z758LiqLegImpTotBruProm", GXutil.ltrim( localUtil.ntoc( Z758LiqLegImpTotBruProm, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z760LiqLegImpBasico", GXutil.ltrim( localUtil.ntoc( Z760LiqLegImpBasico, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z761LiqLegGNSI", GXutil.ltrim( localUtil.ntoc( Z761LiqLegGNSI, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z590LiqRutaPDF", Z590LiqRutaPDF);
      web.GxWebStd.gx_hidden_field( httpContext, "Z774LiqRutaPDFVertical", Z774LiqRutaPDFVertical);
      web.GxWebStd.gx_hidden_field( httpContext, "Z883LIqLegIteraciones", GXutil.ltrim( localUtil.ntoc( Z883LIqLegIteraciones, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z884LiqLegSegundos", GXutil.ltrim( localUtil.ntoc( Z884LiqLegSegundos, (byte)(10), (byte)(6), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1495LiqLegSegIns", GXutil.ltrim( localUtil.ntoc( Z1495LiqLegSegIns, (byte)(10), (byte)(6), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1496LieqLegSegUpd", GXutil.ltrim( localUtil.ntoc( Z1496LieqLegSegUpd, (byte)(10), (byte)(6), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z891LiqLegError", Z891LiqLegError);
      web.GxWebStd.gx_hidden_field( httpContext, "Z961LiqNombrePDF", GXutil.rtrim( Z961LiqNombrePDF));
      web.GxWebStd.gx_hidden_field( httpContext, "Z962LiqNombrePDFVertical", GXutil.rtrim( Z962LiqNombrePDFVertical));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1546LiqLegHorasSem", GXutil.ltrim( localUtil.ntoc( Z1546LiqLegHorasSem, (byte)(4), (byte)(1), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1780LiqLegAuxEstado", GXutil.ltrim( localUtil.ntoc( Z1780LiqLegAuxEstado, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1781LiqLegErrorAux", Z1781LiqLegErrorAux);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1815LiqLegFecEgr", localUtil.format(Z1815LiqLegFecEgr, "99/99/9999"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1816LiqLegFecIng", localUtil.format(Z1816LiqLegFecIng, "99/99/9999"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2113LiqLegCatCodigo", GXutil.rtrim( Z2113LiqLegCatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2115LiqLegConvenio", GXutil.rtrim( Z2115LiqLegConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2114LiqLegSueldo", GXutil.ltrim( localUtil.ntoc( Z2114LiqLegSueldo, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2179LiqLegPDFEstado", GXutil.rtrim( Z2179LiqLegPDFEstado));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2268LiqLegProcesado", GXutil.ltrim( localUtil.ntoc( Z2268LiqLegProcesado, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2360LiqLegNivLiq", GXutil.ltrim( localUtil.ntoc( Z2360LiqLegNivLiq, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2393LiqLegHtml", Z2393LiqLegHtml);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2400LiqLegLSD", GXutil.ltrim( localUtil.ntoc( Z2400LiqLegLSD, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2401LiqLegDaemonUUID", GXutil.rtrim( Z2401LiqLegDaemonUUID));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2402LiqLegFecHor", localUtil.ttoc( Z2402LiqLegFecHor, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "Z284LiqSecDescrip", Z284LiqSecDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2EmpNom", Z2EmpNom);
      web.GxWebStd.gx_hidden_field( httpContext, "Z283LiqPeriodo", localUtil.format(Z283LiqPeriodo, "99/99/9999"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z32TLiqCod", GXutil.rtrim( Z32TLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z250LegIdNomApe", Z250LegIdNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, "Z93LegId", GXutil.rtrim( Z93LegId));
      web.GxWebStd.gx_hidden_field( httpContext, "Z251LegNombre", Z251LegNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "Z230LegApellido", Z230LegApellido);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Liqseccodigo( )
   {
      n34LiqSecCodigo = false ;
      /* Using cursor T000V22 */
      pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n34LiqSecCodigo), A34LiqSecCodigo});
      if ( (pr_default.getStatus(20) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A34LiqSecCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo Seccion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQSECCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      A284LiqSecDescrip = T000V22_A284LiqSecDescrip[0] ;
      pr_default.close(20);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A284LiqSecDescrip", A284LiqSecDescrip);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A482LegLiqDatosHis',fld:'LEGLIQDATOSHIS',pic:''},{av:'A498LiqLegImpTotBruto',fld:'LIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A759LiqLegImpTotBruSinSAC',fld:'LIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A499LiqLegCntConc',fld:'LIQLEGCNTCONC',pic:'ZZZ9'},{av:'A577LiqLegImpTotRemu',fld:'LIQLEGIMPTOTREMU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A578LiqLegImpTotNoRemu',fld:'LIQLEGIMPTOTNOREMU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A579LiqLegImpTotDescu',fld:'LIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1157LiqLegImpContr',fld:'LIQLEGIMPCONTR',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1158LiqLegImpCosto',fld:'LIQLEGIMPCOSTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1131LiqLegImpOtrDescu',fld:'LIQLEGIMPOTRDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1143LiqLegImpDescuNeg',fld:'LIQLEGIMPDESCUNEG',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A757LiqLegImpTotRetGan',fld:'LIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A775LiqLegImpPagosACuen',fld:'LIQLEGIMPPAGOSACUEN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A758LiqLegImpTotBruProm',fld:'LIQLEGIMPTOTBRUPROM',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A760LiqLegImpBasico',fld:'LIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A761LiqLegGNSI',fld:'LIQLEGGNSI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A590LiqRutaPDF',fld:'LIQRUTAPDF',pic:''},{av:'A774LiqRutaPDFVertical',fld:'LIQRUTAPDFVERTICAL',pic:''},{av:'A883LIqLegIteraciones',fld:'LIQLEGITERACIONES',pic:'ZZZ9'},{av:'A884LiqLegSegundos',fld:'LIQLEGSEGUNDOS',pic:'ZZ9.999999'},{av:'A1495LiqLegSegIns',fld:'LIQLEGSEGINS',pic:'ZZ9.999999'},{av:'A1496LieqLegSegUpd',fld:'LIEQLEGSEGUPD',pic:'ZZ9.999999'},{av:'A891LiqLegError',fld:'LIQLEGERROR',pic:''},{av:'A961LiqNombrePDF',fld:'LIQNOMBREPDF',pic:''},{av:'A962LiqNombrePDFVertical',fld:'LIQNOMBREPDFVERTICAL',pic:''},{av:'A1546LiqLegHorasSem',fld:'LIQLEGHORASSEM',pic:'Z9.9'},{av:'A1780LiqLegAuxEstado',fld:'LIQLEGAUXESTADO',pic:'9'},{av:'A1781LiqLegErrorAux',fld:'LIQLEGERRORAUX',pic:''},{av:'A1815LiqLegFecEgr',fld:'LIQLEGFECEGR',pic:''},{av:'A1816LiqLegFecIng',fld:'LIQLEGFECING',pic:''},{av:'A2113LiqLegCatCodigo',fld:'LIQLEGCATCODIGO',pic:''},{av:'A2115LiqLegConvenio',fld:'LIQLEGCONVENIO',pic:''},{av:'A2114LiqLegSueldo',fld:'LIQLEGSUELDO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A2179LiqLegPDFEstado',fld:'LIQLEGPDFESTADO',pic:''},{av:'A2268LiqLegProcesado',fld:'LIQLEGPROCESADO',pic:'9'},{av:'A2360LiqLegNivLiq',fld:'LIQLEGNIVLIQ',pic:'9'},{av:'A2400LiqLegLSD',fld:'LIQLEGLSD',pic:'9'},{av:'A2401LiqLegDaemonUUID',fld:'LIQLEGDAEMONUUID',pic:''},{av:'A2402LiqLegFecHor',fld:'LIQLEGFECHOR',pic:'99/99/99 99:99'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A2EmpNom',fld:'EMPNOM',pic:'@!'}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A2EmpNom',fld:'EMPNOM',pic:'@!'}]}");
      setEventMetadata("VALID_LIQNRO","{handler:'valid_Liqnro',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:''},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''}]");
      setEventMetadata("VALID_LIQNRO",",oparms:[{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:''},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''}]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[{av:'A2402LiqLegFecHor',fld:'LIQLEGFECHOR',pic:'99/99/99 99:99'},{av:'A2401LiqLegDaemonUUID',fld:'LIQLEGDAEMONUUID',pic:''},{av:'A2400LiqLegLSD',fld:'LIQLEGLSD',pic:'9'},{av:'A2360LiqLegNivLiq',fld:'LIQLEGNIVLIQ',pic:'9'},{av:'A2268LiqLegProcesado',fld:'LIQLEGPROCESADO',pic:'9'},{av:'A2179LiqLegPDFEstado',fld:'LIQLEGPDFESTADO',pic:''},{av:'A2114LiqLegSueldo',fld:'LIQLEGSUELDO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A2115LiqLegConvenio',fld:'LIQLEGCONVENIO',pic:''},{av:'A2113LiqLegCatCodigo',fld:'LIQLEGCATCODIGO',pic:''},{av:'A1816LiqLegFecIng',fld:'LIQLEGFECING',pic:''},{av:'A1815LiqLegFecEgr',fld:'LIQLEGFECEGR',pic:''},{av:'A1781LiqLegErrorAux',fld:'LIQLEGERRORAUX',pic:''},{av:'A1780LiqLegAuxEstado',fld:'LIQLEGAUXESTADO',pic:'9'},{av:'A1546LiqLegHorasSem',fld:'LIQLEGHORASSEM',pic:'Z9.9'},{av:'A962LiqNombrePDFVertical',fld:'LIQNOMBREPDFVERTICAL',pic:''},{av:'A961LiqNombrePDF',fld:'LIQNOMBREPDF',pic:''},{av:'A891LiqLegError',fld:'LIQLEGERROR',pic:''},{av:'A1496LieqLegSegUpd',fld:'LIEQLEGSEGUPD',pic:'ZZ9.999999'},{av:'A1495LiqLegSegIns',fld:'LIQLEGSEGINS',pic:'ZZ9.999999'},{av:'A884LiqLegSegundos',fld:'LIQLEGSEGUNDOS',pic:'ZZ9.999999'},{av:'A883LIqLegIteraciones',fld:'LIQLEGITERACIONES',pic:'ZZZ9'},{av:'A774LiqRutaPDFVertical',fld:'LIQRUTAPDFVERTICAL',pic:''},{av:'A590LiqRutaPDF',fld:'LIQRUTAPDF',pic:''},{av:'A761LiqLegGNSI',fld:'LIQLEGGNSI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A760LiqLegImpBasico',fld:'LIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A758LiqLegImpTotBruProm',fld:'LIQLEGIMPTOTBRUPROM',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A775LiqLegImpPagosACuen',fld:'LIQLEGIMPPAGOSACUEN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A757LiqLegImpTotRetGan',fld:'LIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1143LiqLegImpDescuNeg',fld:'LIQLEGIMPDESCUNEG',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1131LiqLegImpOtrDescu',fld:'LIQLEGIMPOTRDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1158LiqLegImpCosto',fld:'LIQLEGIMPCOSTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1157LiqLegImpContr',fld:'LIQLEGIMPCONTR',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A579LiqLegImpTotDescu',fld:'LIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A578LiqLegImpTotNoRemu',fld:'LIQLEGIMPTOTNOREMU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A577LiqLegImpTotRemu',fld:'LIQLEGIMPTOTREMU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A499LiqLegCntConc',fld:'LIQLEGCNTCONC',pic:'ZZZ9'},{av:'A759LiqLegImpTotBruSinSAC',fld:'LIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A498LiqLegImpTotBruto',fld:'LIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A482LegLiqDatosHis',fld:'LEGLIQDATOSHIS',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[{av:'A281LiqLegImpTotal',fld:'LIQLEGIMPTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A34LiqSecCodigo',fld:'LIQSECCODIGO',pic:''},{av:'A282LiqLegReciboNro',fld:'LIQLEGRECIBONRO',pic:'ZZZZZZZ9'},{av:'A482LegLiqDatosHis',fld:'LEGLIQDATOSHIS',pic:''},{av:'A498LiqLegImpTotBruto',fld:'LIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A759LiqLegImpTotBruSinSAC',fld:'LIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A499LiqLegCntConc',fld:'LIQLEGCNTCONC',pic:'ZZZ9'},{av:'A577LiqLegImpTotRemu',fld:'LIQLEGIMPTOTREMU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A578LiqLegImpTotNoRemu',fld:'LIQLEGIMPTOTNOREMU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A579LiqLegImpTotDescu',fld:'LIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1157LiqLegImpContr',fld:'LIQLEGIMPCONTR',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1158LiqLegImpCosto',fld:'LIQLEGIMPCOSTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1131LiqLegImpOtrDescu',fld:'LIQLEGIMPOTRDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1143LiqLegImpDescuNeg',fld:'LIQLEGIMPDESCUNEG',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A757LiqLegImpTotRetGan',fld:'LIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A775LiqLegImpPagosACuen',fld:'LIQLEGIMPPAGOSACUEN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A758LiqLegImpTotBruProm',fld:'LIQLEGIMPTOTBRUPROM',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A760LiqLegImpBasico',fld:'LIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A761LiqLegGNSI',fld:'LIQLEGGNSI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A590LiqRutaPDF',fld:'LIQRUTAPDF',pic:''},{av:'A774LiqRutaPDFVertical',fld:'LIQRUTAPDFVERTICAL',pic:''},{av:'A883LIqLegIteraciones',fld:'LIQLEGITERACIONES',pic:'ZZZ9'},{av:'A884LiqLegSegundos',fld:'LIQLEGSEGUNDOS',pic:'ZZ9.999999'},{av:'A1495LiqLegSegIns',fld:'LIQLEGSEGINS',pic:'ZZ9.999999'},{av:'A1496LieqLegSegUpd',fld:'LIEQLEGSEGUPD',pic:'ZZ9.999999'},{av:'A891LiqLegError',fld:'LIQLEGERROR',pic:''},{av:'A961LiqNombrePDF',fld:'LIQNOMBREPDF',pic:''},{av:'A962LiqNombrePDFVertical',fld:'LIQNOMBREPDFVERTICAL',pic:''},{av:'A1546LiqLegHorasSem',fld:'LIQLEGHORASSEM',pic:'Z9.9'},{av:'A1780LiqLegAuxEstado',fld:'LIQLEGAUXESTADO',pic:'9'},{av:'A1781LiqLegErrorAux',fld:'LIQLEGERRORAUX',pic:''},{av:'A1815LiqLegFecEgr',fld:'LIQLEGFECEGR',pic:''},{av:'A1816LiqLegFecIng',fld:'LIQLEGFECING',pic:''},{av:'A2113LiqLegCatCodigo',fld:'LIQLEGCATCODIGO',pic:''},{av:'A2115LiqLegConvenio',fld:'LIQLEGCONVENIO',pic:''},{av:'A2114LiqLegSueldo',fld:'LIQLEGSUELDO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A2179LiqLegPDFEstado',fld:'LIQLEGPDFESTADO',pic:''},{av:'A2268LiqLegProcesado',fld:'LIQLEGPROCESADO',pic:'9'},{av:'A2360LiqLegNivLiq',fld:'LIQLEGNIVLIQ',pic:'9'},{av:'A2393LiqLegHtml',fld:'LIQLEGHTML',pic:''},{av:'A2400LiqLegLSD',fld:'LIQLEGLSD',pic:'9'},{av:'A2401LiqLegDaemonUUID',fld:'LIQLEGDAEMONUUID',pic:''},{av:'A2402LiqLegFecHor',fld:'LIQLEGFECHOR',pic:'99/99/99 99:99'},{av:'A284LiqSecDescrip',fld:'LIQSECDESCRIP',pic:''},{av:'A2EmpNom',fld:'EMPNOM',pic:'@!'},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:''},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A93LegId',fld:'LEGID',pic:''},{av:'A251LegNombre',fld:'LEGNOMBRE',pic:''},{av:'A230LegApellido',fld:'LEGAPELLIDO',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z3CliCod'},{av:'Z1EmpCod'},{av:'Z31LiqNro'},{av:'Z6LegNumero'},{av:'Z281LiqLegImpTotal'},{av:'Z34LiqSecCodigo'},{av:'Z282LiqLegReciboNro'},{av:'Z482LegLiqDatosHis'},{av:'Z498LiqLegImpTotBruto'},{av:'Z759LiqLegImpTotBruSinSAC'},{av:'Z499LiqLegCntConc'},{av:'Z577LiqLegImpTotRemu'},{av:'Z578LiqLegImpTotNoRemu'},{av:'Z579LiqLegImpTotDescu'},{av:'Z1157LiqLegImpContr'},{av:'Z1158LiqLegImpCosto'},{av:'Z1131LiqLegImpOtrDescu'},{av:'Z1143LiqLegImpDescuNeg'},{av:'Z757LiqLegImpTotRetGan'},{av:'Z775LiqLegImpPagosACuen'},{av:'Z758LiqLegImpTotBruProm'},{av:'Z760LiqLegImpBasico'},{av:'Z761LiqLegGNSI'},{av:'Z590LiqRutaPDF'},{av:'Z774LiqRutaPDFVertical'},{av:'Z883LIqLegIteraciones'},{av:'Z884LiqLegSegundos'},{av:'Z1495LiqLegSegIns'},{av:'Z1496LieqLegSegUpd'},{av:'Z891LiqLegError'},{av:'Z961LiqNombrePDF'},{av:'Z962LiqNombrePDFVertical'},{av:'Z1546LiqLegHorasSem'},{av:'Z1780LiqLegAuxEstado'},{av:'Z1781LiqLegErrorAux'},{av:'Z1815LiqLegFecEgr'},{av:'Z1816LiqLegFecIng'},{av:'Z2113LiqLegCatCodigo'},{av:'Z2115LiqLegConvenio'},{av:'Z2114LiqLegSueldo'},{av:'Z2179LiqLegPDFEstado'},{av:'Z2268LiqLegProcesado'},{av:'Z2360LiqLegNivLiq'},{av:'Z2393LiqLegHtml'},{av:'Z2400LiqLegLSD'},{av:'Z2401LiqLegDaemonUUID'},{av:'Z2402LiqLegFecHor'},{av:'Z284LiqSecDescrip'},{av:'Z2EmpNom'},{av:'Z283LiqPeriodo'},{av:'Z32TLiqCod'},{av:'Z250LegIdNomApe'},{av:'Z93LegId'},{av:'Z251LegNombre'},{av:'Z230LegApellido'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_LIQSECCODIGO","{handler:'valid_Liqseccodigo',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A34LiqSecCodigo',fld:'LIQSECCODIGO',pic:''},{av:'A284LiqSecDescrip',fld:'LIQSECDESCRIP',pic:''}]");
      setEventMetadata("VALID_LIQSECCODIGO",",oparms:[{av:'A284LiqSecDescrip',fld:'LIQSECDESCRIP',pic:''}]}");
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
      pr_default.close(19);
      pr_default.close(18);
      pr_default.close(20);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z281LiqLegImpTotal = DecimalUtil.ZERO ;
      Z482LegLiqDatosHis = "" ;
      Z498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      Z759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      Z577LiqLegImpTotRemu = DecimalUtil.ZERO ;
      Z578LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      Z579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      Z1157LiqLegImpContr = DecimalUtil.ZERO ;
      Z1158LiqLegImpCosto = DecimalUtil.ZERO ;
      Z1131LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      Z1143LiqLegImpDescuNeg = DecimalUtil.ZERO ;
      Z757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      Z775LiqLegImpPagosACuen = DecimalUtil.ZERO ;
      Z758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      Z760LiqLegImpBasico = DecimalUtil.ZERO ;
      Z761LiqLegGNSI = DecimalUtil.ZERO ;
      Z590LiqRutaPDF = "" ;
      Z774LiqRutaPDFVertical = "" ;
      Z884LiqLegSegundos = DecimalUtil.ZERO ;
      Z1495LiqLegSegIns = DecimalUtil.ZERO ;
      Z1496LieqLegSegUpd = DecimalUtil.ZERO ;
      Z891LiqLegError = "" ;
      Z961LiqNombrePDF = "" ;
      Z962LiqNombrePDFVertical = "" ;
      Z1546LiqLegHorasSem = DecimalUtil.ZERO ;
      Z1781LiqLegErrorAux = "" ;
      Z1815LiqLegFecEgr = GXutil.nullDate() ;
      Z1816LiqLegFecIng = GXutil.nullDate() ;
      Z2113LiqLegCatCodigo = "" ;
      Z2115LiqLegConvenio = "" ;
      Z2114LiqLegSueldo = DecimalUtil.ZERO ;
      Z2179LiqLegPDFEstado = "" ;
      Z2401LiqLegDaemonUUID = "" ;
      Z2402LiqLegFecHor = GXutil.resetTime( GXutil.nullDate() );
      Z34LiqSecCodigo = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A34LiqSecCodigo = "" ;
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
      A2EmpNom = "" ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      A284LiqSecDescrip = "" ;
      A93LegId = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      A2179LiqLegPDFEstado = "" ;
      A2401LiqLegDaemonUUID = "" ;
      A482LegLiqDatosHis = "" ;
      A498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      A577LiqLegImpTotRemu = DecimalUtil.ZERO ;
      A578LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      A579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      A1157LiqLegImpContr = DecimalUtil.ZERO ;
      A1158LiqLegImpCosto = DecimalUtil.ZERO ;
      A1131LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      A1143LiqLegImpDescuNeg = DecimalUtil.ZERO ;
      A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      A775LiqLegImpPagosACuen = DecimalUtil.ZERO ;
      A758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      A760LiqLegImpBasico = DecimalUtil.ZERO ;
      A761LiqLegGNSI = DecimalUtil.ZERO ;
      A590LiqRutaPDF = "" ;
      A774LiqRutaPDFVertical = "" ;
      A884LiqLegSegundos = DecimalUtil.ZERO ;
      A1495LiqLegSegIns = DecimalUtil.ZERO ;
      A1496LieqLegSegUpd = DecimalUtil.ZERO ;
      A891LiqLegError = "" ;
      A961LiqNombrePDF = "" ;
      A962LiqNombrePDFVertical = "" ;
      A1546LiqLegHorasSem = DecimalUtil.ZERO ;
      A1781LiqLegErrorAux = "" ;
      A1815LiqLegFecEgr = GXutil.nullDate() ;
      A1816LiqLegFecIng = GXutil.nullDate() ;
      A2113LiqLegCatCodigo = "" ;
      A2115LiqLegConvenio = "" ;
      A2114LiqLegSueldo = DecimalUtil.ZERO ;
      A2402LiqLegFecHor = GXutil.resetTime( GXutil.nullDate() );
      Gx_mode = "" ;
      A2393LiqLegHtml = "" ;
      A250LegIdNomApe = "" ;
      A251LegNombre = "" ;
      A230LegApellido = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A32TLiqCod = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z283LiqPeriodo = GXutil.nullDate() ;
      Z32TLiqCod = "" ;
      Z2393LiqLegHtml = "" ;
      Z2EmpNom = "" ;
      Z250LegIdNomApe = "" ;
      Z93LegId = "" ;
      Z251LegNombre = "" ;
      Z230LegApellido = "" ;
      Z284LiqSecDescrip = "" ;
      T000V8_A250LegIdNomApe = new String[] {""} ;
      T000V8_A2EmpNom = new String[] {""} ;
      T000V8_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A284LiqSecDescrip = new String[] {""} ;
      T000V8_A282LiqLegReciboNro = new int[1] ;
      T000V8_A93LegId = new String[] {""} ;
      T000V8_n93LegId = new boolean[] {false} ;
      T000V8_A482LegLiqDatosHis = new String[] {""} ;
      T000V8_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A499LiqLegCntConc = new short[1] ;
      T000V8_A577LiqLegImpTotRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A578LiqLegImpTotNoRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A1157LiqLegImpContr = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A1158LiqLegImpCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A1131LiqLegImpOtrDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A1143LiqLegImpDescuNeg = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A775LiqLegImpPagosACuen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A761LiqLegGNSI = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A590LiqRutaPDF = new String[] {""} ;
      T000V8_A774LiqRutaPDFVertical = new String[] {""} ;
      T000V8_A883LIqLegIteraciones = new short[1] ;
      T000V8_A884LiqLegSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A1495LiqLegSegIns = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A1496LieqLegSegUpd = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A891LiqLegError = new String[] {""} ;
      T000V8_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T000V8_A961LiqNombrePDF = new String[] {""} ;
      T000V8_A962LiqNombrePDFVertical = new String[] {""} ;
      T000V8_A32TLiqCod = new String[] {""} ;
      T000V8_n32TLiqCod = new boolean[] {false} ;
      T000V8_A1546LiqLegHorasSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A1780LiqLegAuxEstado = new byte[1] ;
      T000V8_A1781LiqLegErrorAux = new String[] {""} ;
      T000V8_A1815LiqLegFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      T000V8_A1816LiqLegFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      T000V8_A2113LiqLegCatCodigo = new String[] {""} ;
      T000V8_A2115LiqLegConvenio = new String[] {""} ;
      T000V8_A2114LiqLegSueldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V8_A2179LiqLegPDFEstado = new String[] {""} ;
      T000V8_n2179LiqLegPDFEstado = new boolean[] {false} ;
      T000V8_A2268LiqLegProcesado = new byte[1] ;
      T000V8_A2360LiqLegNivLiq = new byte[1] ;
      T000V8_A2393LiqLegHtml = new String[] {""} ;
      T000V8_A2400LiqLegLSD = new byte[1] ;
      T000V8_A2401LiqLegDaemonUUID = new String[] {""} ;
      T000V8_n2401LiqLegDaemonUUID = new boolean[] {false} ;
      T000V8_A2402LiqLegFecHor = new java.util.Date[] {GXutil.nullDate()} ;
      T000V8_A251LegNombre = new String[] {""} ;
      T000V8_A230LegApellido = new String[] {""} ;
      T000V8_A3CliCod = new int[1] ;
      T000V8_A1EmpCod = new short[1] ;
      T000V8_A6LegNumero = new int[1] ;
      T000V8_A31LiqNro = new int[1] ;
      T000V8_A34LiqSecCodigo = new String[] {""} ;
      T000V8_n34LiqSecCodigo = new boolean[] {false} ;
      T000V6_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T000V6_A32TLiqCod = new String[] {""} ;
      T000V6_n32TLiqCod = new boolean[] {false} ;
      T000V7_A284LiqSecDescrip = new String[] {""} ;
      T000V4_A2EmpNom = new String[] {""} ;
      T000V5_A250LegIdNomApe = new String[] {""} ;
      T000V5_A93LegId = new String[] {""} ;
      T000V5_n93LegId = new boolean[] {false} ;
      T000V5_A251LegNombre = new String[] {""} ;
      T000V5_A230LegApellido = new String[] {""} ;
      T000V9_A284LiqSecDescrip = new String[] {""} ;
      T000V10_A2EmpNom = new String[] {""} ;
      T000V11_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T000V11_A32TLiqCod = new String[] {""} ;
      T000V11_n32TLiqCod = new boolean[] {false} ;
      T000V12_A250LegIdNomApe = new String[] {""} ;
      T000V12_A93LegId = new String[] {""} ;
      T000V12_n93LegId = new boolean[] {false} ;
      T000V12_A251LegNombre = new String[] {""} ;
      T000V12_A230LegApellido = new String[] {""} ;
      T000V13_A3CliCod = new int[1] ;
      T000V13_A1EmpCod = new short[1] ;
      T000V13_A31LiqNro = new int[1] ;
      T000V13_A6LegNumero = new int[1] ;
      T000V3_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A282LiqLegReciboNro = new int[1] ;
      T000V3_A482LegLiqDatosHis = new String[] {""} ;
      T000V3_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A499LiqLegCntConc = new short[1] ;
      T000V3_A577LiqLegImpTotRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A578LiqLegImpTotNoRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A1157LiqLegImpContr = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A1158LiqLegImpCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A1131LiqLegImpOtrDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A1143LiqLegImpDescuNeg = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A775LiqLegImpPagosACuen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A761LiqLegGNSI = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A590LiqRutaPDF = new String[] {""} ;
      T000V3_A774LiqRutaPDFVertical = new String[] {""} ;
      T000V3_A883LIqLegIteraciones = new short[1] ;
      T000V3_A884LiqLegSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A1495LiqLegSegIns = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A1496LieqLegSegUpd = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A891LiqLegError = new String[] {""} ;
      T000V3_A961LiqNombrePDF = new String[] {""} ;
      T000V3_A962LiqNombrePDFVertical = new String[] {""} ;
      T000V3_A1546LiqLegHorasSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A1780LiqLegAuxEstado = new byte[1] ;
      T000V3_A1781LiqLegErrorAux = new String[] {""} ;
      T000V3_A1815LiqLegFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      T000V3_A1816LiqLegFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      T000V3_A2113LiqLegCatCodigo = new String[] {""} ;
      T000V3_A2115LiqLegConvenio = new String[] {""} ;
      T000V3_A2114LiqLegSueldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A2179LiqLegPDFEstado = new String[] {""} ;
      T000V3_n2179LiqLegPDFEstado = new boolean[] {false} ;
      T000V3_A2268LiqLegProcesado = new byte[1] ;
      T000V3_A2360LiqLegNivLiq = new byte[1] ;
      T000V3_A2393LiqLegHtml = new String[] {""} ;
      T000V3_A2400LiqLegLSD = new byte[1] ;
      T000V3_A2401LiqLegDaemonUUID = new String[] {""} ;
      T000V3_n2401LiqLegDaemonUUID = new boolean[] {false} ;
      T000V3_A2402LiqLegFecHor = new java.util.Date[] {GXutil.nullDate()} ;
      T000V3_A3CliCod = new int[1] ;
      T000V3_A1EmpCod = new short[1] ;
      T000V3_A6LegNumero = new int[1] ;
      T000V3_A31LiqNro = new int[1] ;
      T000V3_A34LiqSecCodigo = new String[] {""} ;
      T000V3_n34LiqSecCodigo = new boolean[] {false} ;
      T000V3_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T000V3_A32TLiqCod = new String[] {""} ;
      T000V3_n32TLiqCod = new boolean[] {false} ;
      sMode28 = "" ;
      T000V14_A3CliCod = new int[1] ;
      T000V14_A1EmpCod = new short[1] ;
      T000V14_A6LegNumero = new int[1] ;
      T000V14_A31LiqNro = new int[1] ;
      T000V15_A3CliCod = new int[1] ;
      T000V15_A1EmpCod = new short[1] ;
      T000V15_A6LegNumero = new int[1] ;
      T000V15_A31LiqNro = new int[1] ;
      T000V2_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A282LiqLegReciboNro = new int[1] ;
      T000V2_A482LegLiqDatosHis = new String[] {""} ;
      T000V2_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A499LiqLegCntConc = new short[1] ;
      T000V2_A577LiqLegImpTotRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A578LiqLegImpTotNoRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A1157LiqLegImpContr = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A1158LiqLegImpCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A1131LiqLegImpOtrDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A1143LiqLegImpDescuNeg = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A775LiqLegImpPagosACuen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A761LiqLegGNSI = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A590LiqRutaPDF = new String[] {""} ;
      T000V2_A774LiqRutaPDFVertical = new String[] {""} ;
      T000V2_A883LIqLegIteraciones = new short[1] ;
      T000V2_A884LiqLegSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A1495LiqLegSegIns = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A1496LieqLegSegUpd = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A891LiqLegError = new String[] {""} ;
      T000V2_A961LiqNombrePDF = new String[] {""} ;
      T000V2_A962LiqNombrePDFVertical = new String[] {""} ;
      T000V2_A1546LiqLegHorasSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A1780LiqLegAuxEstado = new byte[1] ;
      T000V2_A1781LiqLegErrorAux = new String[] {""} ;
      T000V2_A1815LiqLegFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      T000V2_A1816LiqLegFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      T000V2_A2113LiqLegCatCodigo = new String[] {""} ;
      T000V2_A2115LiqLegConvenio = new String[] {""} ;
      T000V2_A2114LiqLegSueldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A2179LiqLegPDFEstado = new String[] {""} ;
      T000V2_n2179LiqLegPDFEstado = new boolean[] {false} ;
      T000V2_A2268LiqLegProcesado = new byte[1] ;
      T000V2_A2360LiqLegNivLiq = new byte[1] ;
      T000V2_A2393LiqLegHtml = new String[] {""} ;
      T000V2_A2400LiqLegLSD = new byte[1] ;
      T000V2_A2401LiqLegDaemonUUID = new String[] {""} ;
      T000V2_n2401LiqLegDaemonUUID = new boolean[] {false} ;
      T000V2_A2402LiqLegFecHor = new java.util.Date[] {GXutil.nullDate()} ;
      T000V2_A3CliCod = new int[1] ;
      T000V2_A1EmpCod = new short[1] ;
      T000V2_A6LegNumero = new int[1] ;
      T000V2_A31LiqNro = new int[1] ;
      T000V2_A34LiqSecCodigo = new String[] {""} ;
      T000V2_n34LiqSecCodigo = new boolean[] {false} ;
      T000V2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T000V2_A32TLiqCod = new String[] {""} ;
      T000V2_n32TLiqCod = new boolean[] {false} ;
      T000V19_A2EmpNom = new String[] {""} ;
      T000V20_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T000V20_A32TLiqCod = new String[] {""} ;
      T000V20_n32TLiqCod = new boolean[] {false} ;
      T000V21_A250LegIdNomApe = new String[] {""} ;
      T000V21_A93LegId = new String[] {""} ;
      T000V21_n93LegId = new boolean[] {false} ;
      T000V21_A251LegNombre = new String[] {""} ;
      T000V21_A230LegApellido = new String[] {""} ;
      T000V22_A284LiqSecDescrip = new String[] {""} ;
      T000V23_A3CliCod = new int[1] ;
      T000V23_A1EmpCod = new short[1] ;
      T000V23_A6LegNumero = new int[1] ;
      T000V23_A2243LegCuenLicTpo = new String[] {""} ;
      T000V23_A2266LegCuenAnio = new short[1] ;
      T000V23_A2310LegCuLConsAnio = new short[1] ;
      T000V23_A2311LegCuLConsSec = new short[1] ;
      T000V24_A3CliCod = new int[1] ;
      T000V24_A1EmpCod = new short[1] ;
      T000V24_A6LegNumero = new int[1] ;
      T000V24_A2243LegCuenLicTpo = new String[] {""} ;
      T000V24_A2266LegCuenAnio = new short[1] ;
      T000V24_A2324LegCuLAprLicFch = new java.util.Date[] {GXutil.nullDate()} ;
      T000V25_A3CliCod = new int[1] ;
      T000V25_A1EmpCod = new short[1] ;
      T000V25_A6LegNumero = new int[1] ;
      T000V25_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      T000V26_A3CliCod = new int[1] ;
      T000V26_A1EmpCod = new short[1] ;
      T000V26_A31LiqNro = new int[1] ;
      T000V26_A6LegNumero = new int[1] ;
      T000V26_A2094LiqDetForCon = new String[] {""} ;
      T000V26_A2095LiqDetForOpe = new String[] {""} ;
      T000V26_A2096LiqDetForOpeCod = new String[] {""} ;
      T000V27_A3CliCod = new int[1] ;
      T000V27_A1EmpCod = new short[1] ;
      T000V27_A31LiqNro = new int[1] ;
      T000V27_A6LegNumero = new int[1] ;
      T000V27_A1035LiqDOpeOrig = new String[] {""} ;
      T000V28_A3CliCod = new int[1] ;
      T000V28_A1EmpCod = new short[1] ;
      T000V28_A31LiqNro = new int[1] ;
      T000V28_A6LegNumero = new int[1] ;
      T000V28_A1541LiqAjuNro = new short[1] ;
      T000V29_A3CliCod = new int[1] ;
      T000V29_A1EmpCod = new short[1] ;
      T000V29_A6LegNumero = new int[1] ;
      T000V29_A1172OblSecuencial = new short[1] ;
      T000V29_A1184LiqOblAltaNro = new int[1] ;
      T000V29_A1185LiqOblNuevaNro = new int[1] ;
      T000V30_A3CliCod = new int[1] ;
      T000V30_A1EmpCod = new short[1] ;
      T000V30_A6LegNumero = new int[1] ;
      T000V30_A1172OblSecuencial = new short[1] ;
      T000V30_A1184LiqOblAltaNro = new int[1] ;
      T000V30_A1185LiqOblNuevaNro = new int[1] ;
      T000V31_A3CliCod = new int[1] ;
      T000V31_A1EmpCod = new short[1] ;
      T000V31_A6LegNumero = new int[1] ;
      T000V31_A1172OblSecuencial = new short[1] ;
      T000V32_A3CliCod = new int[1] ;
      T000V32_A1EmpCod = new short[1] ;
      T000V32_A1129LiqExAnio = new short[1] ;
      T000V32_A31LiqNro = new int[1] ;
      T000V32_A6LegNumero = new int[1] ;
      T000V32_A1127LiqExenConCodigo = new String[] {""} ;
      T000V32_A1128LiqExAplIIGG = new short[1] ;
      T000V33_A3CliCod = new int[1] ;
      T000V33_A1EmpCod = new short[1] ;
      T000V33_A869LiqLegConAnio = new short[1] ;
      T000V33_A6LegNumero = new int[1] ;
      T000V33_A26ConCodigo = new String[] {""} ;
      T000V33_A1097LiqAltaNro = new int[1] ;
      T000V33_A1098LiqNuevaNro = new int[1] ;
      T000V34_A3CliCod = new int[1] ;
      T000V34_A1EmpCod = new short[1] ;
      T000V34_A869LiqLegConAnio = new short[1] ;
      T000V34_A6LegNumero = new int[1] ;
      T000V34_A26ConCodigo = new String[] {""} ;
      T000V34_A1097LiqAltaNro = new int[1] ;
      T000V34_A1098LiqNuevaNro = new int[1] ;
      T000V35_A3CliCod = new int[1] ;
      T000V35_A1EmpCod = new short[1] ;
      T000V35_A31LiqNro = new int[1] ;
      T000V35_A6LegNumero = new int[1] ;
      T000V35_A721TestLiqDSecuencial = new short[1] ;
      T000V36_A3CliCod = new int[1] ;
      T000V36_A1EmpCod = new short[1] ;
      T000V36_A31LiqNro = new int[1] ;
      T000V36_A6LegNumero = new int[1] ;
      T000V36_A81LiqDSecuencial = new int[1] ;
      T000V37_A3CliCod = new int[1] ;
      T000V37_A1EmpCod = new short[1] ;
      T000V37_A6LegNumero = new int[1] ;
      T000V37_A25AgeOrden = new short[1] ;
      T000V38_A3CliCod = new int[1] ;
      T000V38_A1EmpCod = new short[1] ;
      T000V38_A31LiqNro = new int[1] ;
      T000V38_A6LegNumero = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      ZZ281LiqLegImpTotal = DecimalUtil.ZERO ;
      ZZ34LiqSecCodigo = "" ;
      ZZ482LegLiqDatosHis = "" ;
      ZZ498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      ZZ759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      ZZ577LiqLegImpTotRemu = DecimalUtil.ZERO ;
      ZZ578LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      ZZ579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      ZZ1157LiqLegImpContr = DecimalUtil.ZERO ;
      ZZ1158LiqLegImpCosto = DecimalUtil.ZERO ;
      ZZ1131LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      ZZ1143LiqLegImpDescuNeg = DecimalUtil.ZERO ;
      ZZ757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      ZZ775LiqLegImpPagosACuen = DecimalUtil.ZERO ;
      ZZ758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      ZZ760LiqLegImpBasico = DecimalUtil.ZERO ;
      ZZ761LiqLegGNSI = DecimalUtil.ZERO ;
      ZZ590LiqRutaPDF = "" ;
      ZZ774LiqRutaPDFVertical = "" ;
      ZZ884LiqLegSegundos = DecimalUtil.ZERO ;
      ZZ1495LiqLegSegIns = DecimalUtil.ZERO ;
      ZZ1496LieqLegSegUpd = DecimalUtil.ZERO ;
      ZZ891LiqLegError = "" ;
      ZZ961LiqNombrePDF = "" ;
      ZZ962LiqNombrePDFVertical = "" ;
      ZZ1546LiqLegHorasSem = DecimalUtil.ZERO ;
      ZZ1781LiqLegErrorAux = "" ;
      ZZ1815LiqLegFecEgr = GXutil.nullDate() ;
      ZZ1816LiqLegFecIng = GXutil.nullDate() ;
      ZZ2113LiqLegCatCodigo = "" ;
      ZZ2115LiqLegConvenio = "" ;
      ZZ2114LiqLegSueldo = DecimalUtil.ZERO ;
      ZZ2179LiqLegPDFEstado = "" ;
      ZZ2393LiqLegHtml = "" ;
      ZZ2401LiqLegDaemonUUID = "" ;
      ZZ2402LiqLegFecHor = GXutil.resetTime( GXutil.nullDate() );
      ZZ284LiqSecDescrip = "" ;
      ZZ2EmpNom = "" ;
      ZZ283LiqPeriodo = GXutil.nullDate() ;
      ZZ32TLiqCod = "" ;
      ZZ250LegIdNomApe = "" ;
      ZZ93LegId = "" ;
      ZZ251LegNombre = "" ;
      ZZ230LegApellido = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionlegajo__default(),
         new Object[] {
             new Object[] {
            T000V2_A281LiqLegImpTotal, T000V2_A282LiqLegReciboNro, T000V2_A482LegLiqDatosHis, T000V2_A498LiqLegImpTotBruto, T000V2_A759LiqLegImpTotBruSinSAC, T000V2_A499LiqLegCntConc, T000V2_A577LiqLegImpTotRemu, T000V2_A578LiqLegImpTotNoRemu, T000V2_A579LiqLegImpTotDescu, T000V2_A1157LiqLegImpContr,
            T000V2_A1158LiqLegImpCosto, T000V2_A1131LiqLegImpOtrDescu, T000V2_A1143LiqLegImpDescuNeg, T000V2_A757LiqLegImpTotRetGan, T000V2_A775LiqLegImpPagosACuen, T000V2_A758LiqLegImpTotBruProm, T000V2_A760LiqLegImpBasico, T000V2_A761LiqLegGNSI, T000V2_A590LiqRutaPDF, T000V2_A774LiqRutaPDFVertical,
            T000V2_A883LIqLegIteraciones, T000V2_A884LiqLegSegundos, T000V2_A1495LiqLegSegIns, T000V2_A1496LieqLegSegUpd, T000V2_A891LiqLegError, T000V2_A961LiqNombrePDF, T000V2_A962LiqNombrePDFVertical, T000V2_A1546LiqLegHorasSem, T000V2_A1780LiqLegAuxEstado, T000V2_A1781LiqLegErrorAux,
            T000V2_A1815LiqLegFecEgr, T000V2_A1816LiqLegFecIng, T000V2_A2113LiqLegCatCodigo, T000V2_A2115LiqLegConvenio, T000V2_A2114LiqLegSueldo, T000V2_A2179LiqLegPDFEstado, T000V2_n2179LiqLegPDFEstado, T000V2_A2268LiqLegProcesado, T000V2_A2360LiqLegNivLiq, T000V2_A2393LiqLegHtml,
            T000V2_A2400LiqLegLSD, T000V2_A2401LiqLegDaemonUUID, T000V2_n2401LiqLegDaemonUUID, T000V2_A2402LiqLegFecHor, T000V2_A3CliCod, T000V2_A1EmpCod, T000V2_A6LegNumero, T000V2_A31LiqNro, T000V2_A34LiqSecCodigo, T000V2_n34LiqSecCodigo,
            T000V2_A283LiqPeriodo, T000V2_A32TLiqCod, T000V2_n32TLiqCod
            }
            , new Object[] {
            T000V3_A281LiqLegImpTotal, T000V3_A282LiqLegReciboNro, T000V3_A482LegLiqDatosHis, T000V3_A498LiqLegImpTotBruto, T000V3_A759LiqLegImpTotBruSinSAC, T000V3_A499LiqLegCntConc, T000V3_A577LiqLegImpTotRemu, T000V3_A578LiqLegImpTotNoRemu, T000V3_A579LiqLegImpTotDescu, T000V3_A1157LiqLegImpContr,
            T000V3_A1158LiqLegImpCosto, T000V3_A1131LiqLegImpOtrDescu, T000V3_A1143LiqLegImpDescuNeg, T000V3_A757LiqLegImpTotRetGan, T000V3_A775LiqLegImpPagosACuen, T000V3_A758LiqLegImpTotBruProm, T000V3_A760LiqLegImpBasico, T000V3_A761LiqLegGNSI, T000V3_A590LiqRutaPDF, T000V3_A774LiqRutaPDFVertical,
            T000V3_A883LIqLegIteraciones, T000V3_A884LiqLegSegundos, T000V3_A1495LiqLegSegIns, T000V3_A1496LieqLegSegUpd, T000V3_A891LiqLegError, T000V3_A961LiqNombrePDF, T000V3_A962LiqNombrePDFVertical, T000V3_A1546LiqLegHorasSem, T000V3_A1780LiqLegAuxEstado, T000V3_A1781LiqLegErrorAux,
            T000V3_A1815LiqLegFecEgr, T000V3_A1816LiqLegFecIng, T000V3_A2113LiqLegCatCodigo, T000V3_A2115LiqLegConvenio, T000V3_A2114LiqLegSueldo, T000V3_A2179LiqLegPDFEstado, T000V3_n2179LiqLegPDFEstado, T000V3_A2268LiqLegProcesado, T000V3_A2360LiqLegNivLiq, T000V3_A2393LiqLegHtml,
            T000V3_A2400LiqLegLSD, T000V3_A2401LiqLegDaemonUUID, T000V3_n2401LiqLegDaemonUUID, T000V3_A2402LiqLegFecHor, T000V3_A3CliCod, T000V3_A1EmpCod, T000V3_A6LegNumero, T000V3_A31LiqNro, T000V3_A34LiqSecCodigo, T000V3_n34LiqSecCodigo,
            T000V3_A283LiqPeriodo, T000V3_A32TLiqCod, T000V3_n32TLiqCod
            }
            , new Object[] {
            T000V4_A2EmpNom
            }
            , new Object[] {
            T000V5_A250LegIdNomApe, T000V5_A93LegId, T000V5_n93LegId, T000V5_A251LegNombre, T000V5_A230LegApellido
            }
            , new Object[] {
            T000V6_A283LiqPeriodo, T000V6_A32TLiqCod, T000V6_n32TLiqCod
            }
            , new Object[] {
            T000V7_A284LiqSecDescrip
            }
            , new Object[] {
            T000V8_A250LegIdNomApe, T000V8_A2EmpNom, T000V8_A281LiqLegImpTotal, T000V8_A284LiqSecDescrip, T000V8_A282LiqLegReciboNro, T000V8_A93LegId, T000V8_n93LegId, T000V8_A482LegLiqDatosHis, T000V8_A498LiqLegImpTotBruto, T000V8_A759LiqLegImpTotBruSinSAC,
            T000V8_A499LiqLegCntConc, T000V8_A577LiqLegImpTotRemu, T000V8_A578LiqLegImpTotNoRemu, T000V8_A579LiqLegImpTotDescu, T000V8_A1157LiqLegImpContr, T000V8_A1158LiqLegImpCosto, T000V8_A1131LiqLegImpOtrDescu, T000V8_A1143LiqLegImpDescuNeg, T000V8_A757LiqLegImpTotRetGan, T000V8_A775LiqLegImpPagosACuen,
            T000V8_A758LiqLegImpTotBruProm, T000V8_A760LiqLegImpBasico, T000V8_A761LiqLegGNSI, T000V8_A590LiqRutaPDF, T000V8_A774LiqRutaPDFVertical, T000V8_A883LIqLegIteraciones, T000V8_A884LiqLegSegundos, T000V8_A1495LiqLegSegIns, T000V8_A1496LieqLegSegUpd, T000V8_A891LiqLegError,
            T000V8_A283LiqPeriodo, T000V8_A961LiqNombrePDF, T000V8_A962LiqNombrePDFVertical, T000V8_A32TLiqCod, T000V8_n32TLiqCod, T000V8_A1546LiqLegHorasSem, T000V8_A1780LiqLegAuxEstado, T000V8_A1781LiqLegErrorAux, T000V8_A1815LiqLegFecEgr, T000V8_A1816LiqLegFecIng,
            T000V8_A2113LiqLegCatCodigo, T000V8_A2115LiqLegConvenio, T000V8_A2114LiqLegSueldo, T000V8_A2179LiqLegPDFEstado, T000V8_n2179LiqLegPDFEstado, T000V8_A2268LiqLegProcesado, T000V8_A2360LiqLegNivLiq, T000V8_A2393LiqLegHtml, T000V8_A2400LiqLegLSD, T000V8_A2401LiqLegDaemonUUID,
            T000V8_n2401LiqLegDaemonUUID, T000V8_A2402LiqLegFecHor, T000V8_A251LegNombre, T000V8_A230LegApellido, T000V8_A3CliCod, T000V8_A1EmpCod, T000V8_A6LegNumero, T000V8_A31LiqNro, T000V8_A34LiqSecCodigo, T000V8_n34LiqSecCodigo
            }
            , new Object[] {
            T000V9_A284LiqSecDescrip
            }
            , new Object[] {
            T000V10_A2EmpNom
            }
            , new Object[] {
            T000V11_A283LiqPeriodo, T000V11_A32TLiqCod, T000V11_n32TLiqCod
            }
            , new Object[] {
            T000V12_A250LegIdNomApe, T000V12_A93LegId, T000V12_n93LegId, T000V12_A251LegNombre, T000V12_A230LegApellido
            }
            , new Object[] {
            T000V13_A3CliCod, T000V13_A1EmpCod, T000V13_A31LiqNro, T000V13_A6LegNumero
            }
            , new Object[] {
            T000V14_A3CliCod, T000V14_A1EmpCod, T000V14_A6LegNumero, T000V14_A31LiqNro
            }
            , new Object[] {
            T000V15_A3CliCod, T000V15_A1EmpCod, T000V15_A6LegNumero, T000V15_A31LiqNro
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000V19_A2EmpNom
            }
            , new Object[] {
            T000V20_A283LiqPeriodo, T000V20_A32TLiqCod, T000V20_n32TLiqCod
            }
            , new Object[] {
            T000V21_A250LegIdNomApe, T000V21_A93LegId, T000V21_n93LegId, T000V21_A251LegNombre, T000V21_A230LegApellido
            }
            , new Object[] {
            T000V22_A284LiqSecDescrip
            }
            , new Object[] {
            T000V23_A3CliCod, T000V23_A1EmpCod, T000V23_A6LegNumero, T000V23_A2243LegCuenLicTpo, T000V23_A2266LegCuenAnio, T000V23_A2310LegCuLConsAnio, T000V23_A2311LegCuLConsSec
            }
            , new Object[] {
            T000V24_A3CliCod, T000V24_A1EmpCod, T000V24_A6LegNumero, T000V24_A2243LegCuenLicTpo, T000V24_A2266LegCuenAnio, T000V24_A2324LegCuLAprLicFch
            }
            , new Object[] {
            T000V25_A3CliCod, T000V25_A1EmpCod, T000V25_A6LegNumero, T000V25_A2253LegHisFecIng
            }
            , new Object[] {
            T000V26_A3CliCod, T000V26_A1EmpCod, T000V26_A31LiqNro, T000V26_A6LegNumero, T000V26_A2094LiqDetForCon, T000V26_A2095LiqDetForOpe, T000V26_A2096LiqDetForOpeCod
            }
            , new Object[] {
            T000V27_A3CliCod, T000V27_A1EmpCod, T000V27_A31LiqNro, T000V27_A6LegNumero, T000V27_A1035LiqDOpeOrig
            }
            , new Object[] {
            T000V28_A3CliCod, T000V28_A1EmpCod, T000V28_A31LiqNro, T000V28_A6LegNumero, T000V28_A1541LiqAjuNro
            }
            , new Object[] {
            T000V29_A3CliCod, T000V29_A1EmpCod, T000V29_A6LegNumero, T000V29_A1172OblSecuencial, T000V29_A1184LiqOblAltaNro, T000V29_A1185LiqOblNuevaNro
            }
            , new Object[] {
            T000V30_A3CliCod, T000V30_A1EmpCod, T000V30_A6LegNumero, T000V30_A1172OblSecuencial, T000V30_A1184LiqOblAltaNro, T000V30_A1185LiqOblNuevaNro
            }
            , new Object[] {
            T000V31_A3CliCod, T000V31_A1EmpCod, T000V31_A6LegNumero, T000V31_A1172OblSecuencial
            }
            , new Object[] {
            T000V32_A3CliCod, T000V32_A1EmpCod, T000V32_A1129LiqExAnio, T000V32_A31LiqNro, T000V32_A6LegNumero, T000V32_A1127LiqExenConCodigo, T000V32_A1128LiqExAplIIGG
            }
            , new Object[] {
            T000V33_A3CliCod, T000V33_A1EmpCod, T000V33_A869LiqLegConAnio, T000V33_A6LegNumero, T000V33_A26ConCodigo, T000V33_A1097LiqAltaNro, T000V33_A1098LiqNuevaNro
            }
            , new Object[] {
            T000V34_A3CliCod, T000V34_A1EmpCod, T000V34_A869LiqLegConAnio, T000V34_A6LegNumero, T000V34_A26ConCodigo, T000V34_A1097LiqAltaNro, T000V34_A1098LiqNuevaNro
            }
            , new Object[] {
            T000V35_A3CliCod, T000V35_A1EmpCod, T000V35_A31LiqNro, T000V35_A6LegNumero, T000V35_A721TestLiqDSecuencial
            }
            , new Object[] {
            T000V36_A3CliCod, T000V36_A1EmpCod, T000V36_A31LiqNro, T000V36_A6LegNumero, T000V36_A81LiqDSecuencial
            }
            , new Object[] {
            T000V37_A3CliCod, T000V37_A1EmpCod, T000V37_A6LegNumero, T000V37_A25AgeOrden
            }
            , new Object[] {
            T000V38_A3CliCod, T000V38_A1EmpCod, T000V38_A31LiqNro, T000V38_A6LegNumero
            }
         }
      );
   }

   private byte Z1780LiqLegAuxEstado ;
   private byte Z2268LiqLegProcesado ;
   private byte Z2360LiqLegNivLiq ;
   private byte Z2400LiqLegLSD ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1780LiqLegAuxEstado ;
   private byte A2268LiqLegProcesado ;
   private byte A2360LiqLegNivLiq ;
   private byte A2400LiqLegLSD ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private byte ZZ1780LiqLegAuxEstado ;
   private byte ZZ2268LiqLegProcesado ;
   private byte ZZ2360LiqLegNivLiq ;
   private byte ZZ2400LiqLegLSD ;
   private short Z1EmpCod ;
   private short Z499LiqLegCntConc ;
   private short Z883LIqLegIteraciones ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A499LiqLegCntConc ;
   private short A883LIqLegIteraciones ;
   private short RcdFound28 ;
   private short nIsDirty_28 ;
   private short ZZ1EmpCod ;
   private short ZZ499LiqLegCntConc ;
   private short ZZ883LIqLegIteraciones ;
   private int Z3CliCod ;
   private int Z31LiqNro ;
   private int Z6LegNumero ;
   private int Z282LiqLegReciboNro ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtEmpCod_Enabled ;
   private int edtCliCod_Enabled ;
   private int edtEmpNom_Enabled ;
   private int edtLiqNro_Enabled ;
   private int edtLegNumero_Enabled ;
   private int edtLiqLegImpTotal_Enabled ;
   private int edtLiqSecCodigo_Enabled ;
   private int edtLiqSecDescrip_Enabled ;
   private int A282LiqLegReciboNro ;
   private int edtLiqLegReciboNro_Enabled ;
   private int edtLegId_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ3CliCod ;
   private int ZZ31LiqNro ;
   private int ZZ6LegNumero ;
   private int ZZ282LiqLegReciboNro ;
   private java.math.BigDecimal Z281LiqLegImpTotal ;
   private java.math.BigDecimal Z498LiqLegImpTotBruto ;
   private java.math.BigDecimal Z759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal Z577LiqLegImpTotRemu ;
   private java.math.BigDecimal Z578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal Z579LiqLegImpTotDescu ;
   private java.math.BigDecimal Z1157LiqLegImpContr ;
   private java.math.BigDecimal Z1158LiqLegImpCosto ;
   private java.math.BigDecimal Z1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal Z1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal Z757LiqLegImpTotRetGan ;
   private java.math.BigDecimal Z775LiqLegImpPagosACuen ;
   private java.math.BigDecimal Z758LiqLegImpTotBruProm ;
   private java.math.BigDecimal Z760LiqLegImpBasico ;
   private java.math.BigDecimal Z761LiqLegGNSI ;
   private java.math.BigDecimal Z884LiqLegSegundos ;
   private java.math.BigDecimal Z1495LiqLegSegIns ;
   private java.math.BigDecimal Z1496LieqLegSegUpd ;
   private java.math.BigDecimal Z1546LiqLegHorasSem ;
   private java.math.BigDecimal Z2114LiqLegSueldo ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private java.math.BigDecimal A498LiqLegImpTotBruto ;
   private java.math.BigDecimal A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal A577LiqLegImpTotRemu ;
   private java.math.BigDecimal A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal A579LiqLegImpTotDescu ;
   private java.math.BigDecimal A1157LiqLegImpContr ;
   private java.math.BigDecimal A1158LiqLegImpCosto ;
   private java.math.BigDecimal A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal A1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal A775LiqLegImpPagosACuen ;
   private java.math.BigDecimal A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal A760LiqLegImpBasico ;
   private java.math.BigDecimal A761LiqLegGNSI ;
   private java.math.BigDecimal A884LiqLegSegundos ;
   private java.math.BigDecimal A1495LiqLegSegIns ;
   private java.math.BigDecimal A1496LieqLegSegUpd ;
   private java.math.BigDecimal A1546LiqLegHorasSem ;
   private java.math.BigDecimal A2114LiqLegSueldo ;
   private java.math.BigDecimal ZZ281LiqLegImpTotal ;
   private java.math.BigDecimal ZZ498LiqLegImpTotBruto ;
   private java.math.BigDecimal ZZ759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal ZZ577LiqLegImpTotRemu ;
   private java.math.BigDecimal ZZ578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal ZZ579LiqLegImpTotDescu ;
   private java.math.BigDecimal ZZ1157LiqLegImpContr ;
   private java.math.BigDecimal ZZ1158LiqLegImpCosto ;
   private java.math.BigDecimal ZZ1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal ZZ1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal ZZ757LiqLegImpTotRetGan ;
   private java.math.BigDecimal ZZ775LiqLegImpPagosACuen ;
   private java.math.BigDecimal ZZ758LiqLegImpTotBruProm ;
   private java.math.BigDecimal ZZ760LiqLegImpBasico ;
   private java.math.BigDecimal ZZ761LiqLegGNSI ;
   private java.math.BigDecimal ZZ884LiqLegSegundos ;
   private java.math.BigDecimal ZZ1495LiqLegSegIns ;
   private java.math.BigDecimal ZZ1496LieqLegSegUpd ;
   private java.math.BigDecimal ZZ1546LiqLegHorasSem ;
   private java.math.BigDecimal ZZ2114LiqLegSueldo ;
   private String sPrefix ;
   private String Z961LiqNombrePDF ;
   private String Z962LiqNombrePDFVertical ;
   private String Z2113LiqLegCatCodigo ;
   private String Z2115LiqLegConvenio ;
   private String Z2179LiqLegPDFEstado ;
   private String Z2401LiqLegDaemonUUID ;
   private String Z34LiqSecCodigo ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A34LiqSecCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtEmpCod_Internalname ;
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
   private String edtEmpCod_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpNom_Internalname ;
   private String edtEmpNom_Jsonclick ;
   private String edtLiqNro_Internalname ;
   private String edtLiqNro_Jsonclick ;
   private String edtLegNumero_Internalname ;
   private String edtLegNumero_Jsonclick ;
   private String edtLiqLegImpTotal_Internalname ;
   private String edtLiqLegImpTotal_Jsonclick ;
   private String edtLiqSecCodigo_Internalname ;
   private String edtLiqSecCodigo_Jsonclick ;
   private String edtLiqSecDescrip_Internalname ;
   private String edtLiqLegReciboNro_Internalname ;
   private String edtLiqLegReciboNro_Jsonclick ;
   private String edtLegId_Internalname ;
   private String A93LegId ;
   private String edtLegId_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String A2179LiqLegPDFEstado ;
   private String A2401LiqLegDaemonUUID ;
   private String A961LiqNombrePDF ;
   private String A962LiqNombrePDFVertical ;
   private String A2113LiqLegCatCodigo ;
   private String A2115LiqLegConvenio ;
   private String Gx_mode ;
   private String A32TLiqCod ;
   private String hsh ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z32TLiqCod ;
   private String Z93LegId ;
   private String sMode28 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ34LiqSecCodigo ;
   private String ZZ961LiqNombrePDF ;
   private String ZZ962LiqNombrePDFVertical ;
   private String ZZ2113LiqLegCatCodigo ;
   private String ZZ2115LiqLegConvenio ;
   private String ZZ2179LiqLegPDFEstado ;
   private String ZZ2401LiqLegDaemonUUID ;
   private String ZZ32TLiqCod ;
   private String ZZ93LegId ;
   private java.util.Date Z2402LiqLegFecHor ;
   private java.util.Date A2402LiqLegFecHor ;
   private java.util.Date ZZ2402LiqLegFecHor ;
   private java.util.Date Z1815LiqLegFecEgr ;
   private java.util.Date Z1816LiqLegFecIng ;
   private java.util.Date A1815LiqLegFecEgr ;
   private java.util.Date A1816LiqLegFecIng ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date Z283LiqPeriodo ;
   private java.util.Date ZZ1815LiqLegFecEgr ;
   private java.util.Date ZZ1816LiqLegFecIng ;
   private java.util.Date ZZ283LiqPeriodo ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n34LiqSecCodigo ;
   private boolean wbErr ;
   private boolean n2179LiqLegPDFEstado ;
   private boolean n2401LiqLegDaemonUUID ;
   private boolean n32TLiqCod ;
   private boolean n93LegId ;
   private boolean Gx_longc ;
   private String A2393LiqLegHtml ;
   private String Z2393LiqLegHtml ;
   private String ZZ2393LiqLegHtml ;
   private String Z482LegLiqDatosHis ;
   private String Z590LiqRutaPDF ;
   private String Z774LiqRutaPDFVertical ;
   private String Z891LiqLegError ;
   private String Z1781LiqLegErrorAux ;
   private String A2EmpNom ;
   private String A284LiqSecDescrip ;
   private String A482LegLiqDatosHis ;
   private String A590LiqRutaPDF ;
   private String A774LiqRutaPDFVertical ;
   private String A891LiqLegError ;
   private String A1781LiqLegErrorAux ;
   private String A250LegIdNomApe ;
   private String A251LegNombre ;
   private String A230LegApellido ;
   private String Z2EmpNom ;
   private String Z250LegIdNomApe ;
   private String Z251LegNombre ;
   private String Z230LegApellido ;
   private String Z284LiqSecDescrip ;
   private String ZZ482LegLiqDatosHis ;
   private String ZZ590LiqRutaPDF ;
   private String ZZ774LiqRutaPDFVertical ;
   private String ZZ891LiqLegError ;
   private String ZZ1781LiqLegErrorAux ;
   private String ZZ284LiqSecDescrip ;
   private String ZZ2EmpNom ;
   private String ZZ250LegIdNomApe ;
   private String ZZ251LegNombre ;
   private String ZZ230LegApellido ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T000V8_A250LegIdNomApe ;
   private String[] T000V8_A2EmpNom ;
   private java.math.BigDecimal[] T000V8_A281LiqLegImpTotal ;
   private String[] T000V8_A284LiqSecDescrip ;
   private int[] T000V8_A282LiqLegReciboNro ;
   private String[] T000V8_A93LegId ;
   private boolean[] T000V8_n93LegId ;
   private String[] T000V8_A482LegLiqDatosHis ;
   private java.math.BigDecimal[] T000V8_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] T000V8_A759LiqLegImpTotBruSinSAC ;
   private short[] T000V8_A499LiqLegCntConc ;
   private java.math.BigDecimal[] T000V8_A577LiqLegImpTotRemu ;
   private java.math.BigDecimal[] T000V8_A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal[] T000V8_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] T000V8_A1157LiqLegImpContr ;
   private java.math.BigDecimal[] T000V8_A1158LiqLegImpCosto ;
   private java.math.BigDecimal[] T000V8_A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal[] T000V8_A1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal[] T000V8_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] T000V8_A775LiqLegImpPagosACuen ;
   private java.math.BigDecimal[] T000V8_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] T000V8_A760LiqLegImpBasico ;
   private java.math.BigDecimal[] T000V8_A761LiqLegGNSI ;
   private String[] T000V8_A590LiqRutaPDF ;
   private String[] T000V8_A774LiqRutaPDFVertical ;
   private short[] T000V8_A883LIqLegIteraciones ;
   private java.math.BigDecimal[] T000V8_A884LiqLegSegundos ;
   private java.math.BigDecimal[] T000V8_A1495LiqLegSegIns ;
   private java.math.BigDecimal[] T000V8_A1496LieqLegSegUpd ;
   private String[] T000V8_A891LiqLegError ;
   private java.util.Date[] T000V8_A283LiqPeriodo ;
   private String[] T000V8_A961LiqNombrePDF ;
   private String[] T000V8_A962LiqNombrePDFVertical ;
   private String[] T000V8_A32TLiqCod ;
   private boolean[] T000V8_n32TLiqCod ;
   private java.math.BigDecimal[] T000V8_A1546LiqLegHorasSem ;
   private byte[] T000V8_A1780LiqLegAuxEstado ;
   private String[] T000V8_A1781LiqLegErrorAux ;
   private java.util.Date[] T000V8_A1815LiqLegFecEgr ;
   private java.util.Date[] T000V8_A1816LiqLegFecIng ;
   private String[] T000V8_A2113LiqLegCatCodigo ;
   private String[] T000V8_A2115LiqLegConvenio ;
   private java.math.BigDecimal[] T000V8_A2114LiqLegSueldo ;
   private String[] T000V8_A2179LiqLegPDFEstado ;
   private boolean[] T000V8_n2179LiqLegPDFEstado ;
   private byte[] T000V8_A2268LiqLegProcesado ;
   private byte[] T000V8_A2360LiqLegNivLiq ;
   private String[] T000V8_A2393LiqLegHtml ;
   private byte[] T000V8_A2400LiqLegLSD ;
   private String[] T000V8_A2401LiqLegDaemonUUID ;
   private boolean[] T000V8_n2401LiqLegDaemonUUID ;
   private java.util.Date[] T000V8_A2402LiqLegFecHor ;
   private String[] T000V8_A251LegNombre ;
   private String[] T000V8_A230LegApellido ;
   private int[] T000V8_A3CliCod ;
   private short[] T000V8_A1EmpCod ;
   private int[] T000V8_A6LegNumero ;
   private int[] T000V8_A31LiqNro ;
   private String[] T000V8_A34LiqSecCodigo ;
   private boolean[] T000V8_n34LiqSecCodigo ;
   private java.util.Date[] T000V6_A283LiqPeriodo ;
   private String[] T000V6_A32TLiqCod ;
   private boolean[] T000V6_n32TLiqCod ;
   private String[] T000V7_A284LiqSecDescrip ;
   private String[] T000V4_A2EmpNom ;
   private String[] T000V5_A250LegIdNomApe ;
   private String[] T000V5_A93LegId ;
   private boolean[] T000V5_n93LegId ;
   private String[] T000V5_A251LegNombre ;
   private String[] T000V5_A230LegApellido ;
   private String[] T000V9_A284LiqSecDescrip ;
   private String[] T000V10_A2EmpNom ;
   private java.util.Date[] T000V11_A283LiqPeriodo ;
   private String[] T000V11_A32TLiqCod ;
   private boolean[] T000V11_n32TLiqCod ;
   private String[] T000V12_A250LegIdNomApe ;
   private String[] T000V12_A93LegId ;
   private boolean[] T000V12_n93LegId ;
   private String[] T000V12_A251LegNombre ;
   private String[] T000V12_A230LegApellido ;
   private int[] T000V13_A3CliCod ;
   private short[] T000V13_A1EmpCod ;
   private int[] T000V13_A31LiqNro ;
   private int[] T000V13_A6LegNumero ;
   private java.math.BigDecimal[] T000V3_A281LiqLegImpTotal ;
   private int[] T000V3_A282LiqLegReciboNro ;
   private String[] T000V3_A482LegLiqDatosHis ;
   private java.math.BigDecimal[] T000V3_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] T000V3_A759LiqLegImpTotBruSinSAC ;
   private short[] T000V3_A499LiqLegCntConc ;
   private java.math.BigDecimal[] T000V3_A577LiqLegImpTotRemu ;
   private java.math.BigDecimal[] T000V3_A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal[] T000V3_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] T000V3_A1157LiqLegImpContr ;
   private java.math.BigDecimal[] T000V3_A1158LiqLegImpCosto ;
   private java.math.BigDecimal[] T000V3_A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal[] T000V3_A1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal[] T000V3_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] T000V3_A775LiqLegImpPagosACuen ;
   private java.math.BigDecimal[] T000V3_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] T000V3_A760LiqLegImpBasico ;
   private java.math.BigDecimal[] T000V3_A761LiqLegGNSI ;
   private String[] T000V3_A590LiqRutaPDF ;
   private String[] T000V3_A774LiqRutaPDFVertical ;
   private short[] T000V3_A883LIqLegIteraciones ;
   private java.math.BigDecimal[] T000V3_A884LiqLegSegundos ;
   private java.math.BigDecimal[] T000V3_A1495LiqLegSegIns ;
   private java.math.BigDecimal[] T000V3_A1496LieqLegSegUpd ;
   private String[] T000V3_A891LiqLegError ;
   private String[] T000V3_A961LiqNombrePDF ;
   private String[] T000V3_A962LiqNombrePDFVertical ;
   private java.math.BigDecimal[] T000V3_A1546LiqLegHorasSem ;
   private byte[] T000V3_A1780LiqLegAuxEstado ;
   private String[] T000V3_A1781LiqLegErrorAux ;
   private java.util.Date[] T000V3_A1815LiqLegFecEgr ;
   private java.util.Date[] T000V3_A1816LiqLegFecIng ;
   private String[] T000V3_A2113LiqLegCatCodigo ;
   private String[] T000V3_A2115LiqLegConvenio ;
   private java.math.BigDecimal[] T000V3_A2114LiqLegSueldo ;
   private String[] T000V3_A2179LiqLegPDFEstado ;
   private boolean[] T000V3_n2179LiqLegPDFEstado ;
   private byte[] T000V3_A2268LiqLegProcesado ;
   private byte[] T000V3_A2360LiqLegNivLiq ;
   private String[] T000V3_A2393LiqLegHtml ;
   private byte[] T000V3_A2400LiqLegLSD ;
   private String[] T000V3_A2401LiqLegDaemonUUID ;
   private boolean[] T000V3_n2401LiqLegDaemonUUID ;
   private java.util.Date[] T000V3_A2402LiqLegFecHor ;
   private int[] T000V3_A3CliCod ;
   private short[] T000V3_A1EmpCod ;
   private int[] T000V3_A6LegNumero ;
   private int[] T000V3_A31LiqNro ;
   private String[] T000V3_A34LiqSecCodigo ;
   private boolean[] T000V3_n34LiqSecCodigo ;
   private java.util.Date[] T000V3_A283LiqPeriodo ;
   private String[] T000V3_A32TLiqCod ;
   private boolean[] T000V3_n32TLiqCod ;
   private int[] T000V14_A3CliCod ;
   private short[] T000V14_A1EmpCod ;
   private int[] T000V14_A6LegNumero ;
   private int[] T000V14_A31LiqNro ;
   private int[] T000V15_A3CliCod ;
   private short[] T000V15_A1EmpCod ;
   private int[] T000V15_A6LegNumero ;
   private int[] T000V15_A31LiqNro ;
   private java.math.BigDecimal[] T000V2_A281LiqLegImpTotal ;
   private int[] T000V2_A282LiqLegReciboNro ;
   private String[] T000V2_A482LegLiqDatosHis ;
   private java.math.BigDecimal[] T000V2_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] T000V2_A759LiqLegImpTotBruSinSAC ;
   private short[] T000V2_A499LiqLegCntConc ;
   private java.math.BigDecimal[] T000V2_A577LiqLegImpTotRemu ;
   private java.math.BigDecimal[] T000V2_A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal[] T000V2_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] T000V2_A1157LiqLegImpContr ;
   private java.math.BigDecimal[] T000V2_A1158LiqLegImpCosto ;
   private java.math.BigDecimal[] T000V2_A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal[] T000V2_A1143LiqLegImpDescuNeg ;
   private java.math.BigDecimal[] T000V2_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] T000V2_A775LiqLegImpPagosACuen ;
   private java.math.BigDecimal[] T000V2_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] T000V2_A760LiqLegImpBasico ;
   private java.math.BigDecimal[] T000V2_A761LiqLegGNSI ;
   private String[] T000V2_A590LiqRutaPDF ;
   private String[] T000V2_A774LiqRutaPDFVertical ;
   private short[] T000V2_A883LIqLegIteraciones ;
   private java.math.BigDecimal[] T000V2_A884LiqLegSegundos ;
   private java.math.BigDecimal[] T000V2_A1495LiqLegSegIns ;
   private java.math.BigDecimal[] T000V2_A1496LieqLegSegUpd ;
   private String[] T000V2_A891LiqLegError ;
   private String[] T000V2_A961LiqNombrePDF ;
   private String[] T000V2_A962LiqNombrePDFVertical ;
   private java.math.BigDecimal[] T000V2_A1546LiqLegHorasSem ;
   private byte[] T000V2_A1780LiqLegAuxEstado ;
   private String[] T000V2_A1781LiqLegErrorAux ;
   private java.util.Date[] T000V2_A1815LiqLegFecEgr ;
   private java.util.Date[] T000V2_A1816LiqLegFecIng ;
   private String[] T000V2_A2113LiqLegCatCodigo ;
   private String[] T000V2_A2115LiqLegConvenio ;
   private java.math.BigDecimal[] T000V2_A2114LiqLegSueldo ;
   private String[] T000V2_A2179LiqLegPDFEstado ;
   private boolean[] T000V2_n2179LiqLegPDFEstado ;
   private byte[] T000V2_A2268LiqLegProcesado ;
   private byte[] T000V2_A2360LiqLegNivLiq ;
   private String[] T000V2_A2393LiqLegHtml ;
   private byte[] T000V2_A2400LiqLegLSD ;
   private String[] T000V2_A2401LiqLegDaemonUUID ;
   private boolean[] T000V2_n2401LiqLegDaemonUUID ;
   private java.util.Date[] T000V2_A2402LiqLegFecHor ;
   private int[] T000V2_A3CliCod ;
   private short[] T000V2_A1EmpCod ;
   private int[] T000V2_A6LegNumero ;
   private int[] T000V2_A31LiqNro ;
   private String[] T000V2_A34LiqSecCodigo ;
   private boolean[] T000V2_n34LiqSecCodigo ;
   private java.util.Date[] T000V2_A283LiqPeriodo ;
   private String[] T000V2_A32TLiqCod ;
   private boolean[] T000V2_n32TLiqCod ;
   private String[] T000V19_A2EmpNom ;
   private java.util.Date[] T000V20_A283LiqPeriodo ;
   private String[] T000V20_A32TLiqCod ;
   private boolean[] T000V20_n32TLiqCod ;
   private String[] T000V21_A250LegIdNomApe ;
   private String[] T000V21_A93LegId ;
   private boolean[] T000V21_n93LegId ;
   private String[] T000V21_A251LegNombre ;
   private String[] T000V21_A230LegApellido ;
   private String[] T000V22_A284LiqSecDescrip ;
   private int[] T000V23_A3CliCod ;
   private short[] T000V23_A1EmpCod ;
   private int[] T000V23_A6LegNumero ;
   private String[] T000V23_A2243LegCuenLicTpo ;
   private short[] T000V23_A2266LegCuenAnio ;
   private short[] T000V23_A2310LegCuLConsAnio ;
   private short[] T000V23_A2311LegCuLConsSec ;
   private int[] T000V24_A3CliCod ;
   private short[] T000V24_A1EmpCod ;
   private int[] T000V24_A6LegNumero ;
   private String[] T000V24_A2243LegCuenLicTpo ;
   private short[] T000V24_A2266LegCuenAnio ;
   private java.util.Date[] T000V24_A2324LegCuLAprLicFch ;
   private int[] T000V25_A3CliCod ;
   private short[] T000V25_A1EmpCod ;
   private int[] T000V25_A6LegNumero ;
   private java.util.Date[] T000V25_A2253LegHisFecIng ;
   private int[] T000V26_A3CliCod ;
   private short[] T000V26_A1EmpCod ;
   private int[] T000V26_A31LiqNro ;
   private int[] T000V26_A6LegNumero ;
   private String[] T000V26_A2094LiqDetForCon ;
   private String[] T000V26_A2095LiqDetForOpe ;
   private String[] T000V26_A2096LiqDetForOpeCod ;
   private int[] T000V27_A3CliCod ;
   private short[] T000V27_A1EmpCod ;
   private int[] T000V27_A31LiqNro ;
   private int[] T000V27_A6LegNumero ;
   private String[] T000V27_A1035LiqDOpeOrig ;
   private int[] T000V28_A3CliCod ;
   private short[] T000V28_A1EmpCod ;
   private int[] T000V28_A31LiqNro ;
   private int[] T000V28_A6LegNumero ;
   private short[] T000V28_A1541LiqAjuNro ;
   private int[] T000V29_A3CliCod ;
   private short[] T000V29_A1EmpCod ;
   private int[] T000V29_A6LegNumero ;
   private short[] T000V29_A1172OblSecuencial ;
   private int[] T000V29_A1184LiqOblAltaNro ;
   private int[] T000V29_A1185LiqOblNuevaNro ;
   private int[] T000V30_A3CliCod ;
   private short[] T000V30_A1EmpCod ;
   private int[] T000V30_A6LegNumero ;
   private short[] T000V30_A1172OblSecuencial ;
   private int[] T000V30_A1184LiqOblAltaNro ;
   private int[] T000V30_A1185LiqOblNuevaNro ;
   private int[] T000V31_A3CliCod ;
   private short[] T000V31_A1EmpCod ;
   private int[] T000V31_A6LegNumero ;
   private short[] T000V31_A1172OblSecuencial ;
   private int[] T000V32_A3CliCod ;
   private short[] T000V32_A1EmpCod ;
   private short[] T000V32_A1129LiqExAnio ;
   private int[] T000V32_A31LiqNro ;
   private int[] T000V32_A6LegNumero ;
   private String[] T000V32_A1127LiqExenConCodigo ;
   private short[] T000V32_A1128LiqExAplIIGG ;
   private int[] T000V33_A3CliCod ;
   private short[] T000V33_A1EmpCod ;
   private short[] T000V33_A869LiqLegConAnio ;
   private int[] T000V33_A6LegNumero ;
   private String[] T000V33_A26ConCodigo ;
   private int[] T000V33_A1097LiqAltaNro ;
   private int[] T000V33_A1098LiqNuevaNro ;
   private int[] T000V34_A3CliCod ;
   private short[] T000V34_A1EmpCod ;
   private short[] T000V34_A869LiqLegConAnio ;
   private int[] T000V34_A6LegNumero ;
   private String[] T000V34_A26ConCodigo ;
   private int[] T000V34_A1097LiqAltaNro ;
   private int[] T000V34_A1098LiqNuevaNro ;
   private int[] T000V35_A3CliCod ;
   private short[] T000V35_A1EmpCod ;
   private int[] T000V35_A31LiqNro ;
   private int[] T000V35_A6LegNumero ;
   private short[] T000V35_A721TestLiqDSecuencial ;
   private int[] T000V36_A3CliCod ;
   private short[] T000V36_A1EmpCod ;
   private int[] T000V36_A31LiqNro ;
   private int[] T000V36_A6LegNumero ;
   private int[] T000V36_A81LiqDSecuencial ;
   private int[] T000V37_A3CliCod ;
   private short[] T000V37_A1EmpCod ;
   private int[] T000V37_A6LegNumero ;
   private short[] T000V37_A25AgeOrden ;
   private int[] T000V38_A3CliCod ;
   private short[] T000V38_A1EmpCod ;
   private int[] T000V38_A31LiqNro ;
   private int[] T000V38_A6LegNumero ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class liquidacionlegajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000V2", "SELECT LiqLegImpTotal, LiqLegReciboNro, LegLiqDatosHis, LiqLegImpTotBruto, LiqLegImpTotBruSinSAC, LiqLegCntConc, LiqLegImpTotRemu, LiqLegImpTotNoRemu, LiqLegImpTotDescu, LiqLegImpContr, LiqLegImpCosto, LiqLegImpOtrDescu, LiqLegImpDescuNeg, LiqLegImpTotRetGan, LiqLegImpPagosACuen, LiqLegImpTotBruProm, LiqLegImpBasico, LiqLegGNSI, LiqRutaPDF, LiqRutaPDFVertical, LIqLegIteraciones, LiqLegSegundos, LiqLegSegIns, LieqLegSegUpd, LiqLegError, LiqNombrePDF, LiqNombrePDFVertical, LiqLegHorasSem, LiqLegAuxEstado, LiqLegErrorAux, LiqLegFecEgr, LiqLegFecIng, LiqLegCatCodigo, LiqLegConvenio, LiqLegSueldo, LiqLegPDFEstado, LiqLegProcesado, LiqLegNivLiq, LiqLegHtml, LiqLegLSD, LiqLegDaemonUUID, LiqLegFecHor, CliCod, EmpCod, LegNumero, LiqNro, LiqSecCodigo, LiqPeriodo, TLiqCod FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?  FOR UPDATE OF LiquidacionLegajo NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V3", "SELECT LiqLegImpTotal, LiqLegReciboNro, LegLiqDatosHis, LiqLegImpTotBruto, LiqLegImpTotBruSinSAC, LiqLegCntConc, LiqLegImpTotRemu, LiqLegImpTotNoRemu, LiqLegImpTotDescu, LiqLegImpContr, LiqLegImpCosto, LiqLegImpOtrDescu, LiqLegImpDescuNeg, LiqLegImpTotRetGan, LiqLegImpPagosACuen, LiqLegImpTotBruProm, LiqLegImpBasico, LiqLegGNSI, LiqRutaPDF, LiqRutaPDFVertical, LIqLegIteraciones, LiqLegSegundos, LiqLegSegIns, LieqLegSegUpd, LiqLegError, LiqNombrePDF, LiqNombrePDFVertical, LiqLegHorasSem, LiqLegAuxEstado, LiqLegErrorAux, LiqLegFecEgr, LiqLegFecIng, LiqLegCatCodigo, LiqLegConvenio, LiqLegSueldo, LiqLegPDFEstado, LiqLegProcesado, LiqLegNivLiq, LiqLegHtml, LiqLegLSD, LiqLegDaemonUUID, LiqLegFecHor, CliCod, EmpCod, LegNumero, LiqNro, LiqSecCodigo, LiqPeriodo, TLiqCod FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V4", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V5", "SELECT LegIdNomApe, LegId, LegNombre, LegApellido FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V6", "SELECT LiqPeriodo, TLiqCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V7", "SELECT SecDescrip AS LiqSecDescrip FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V8", "SELECT T3.LegIdNomApe, T2.EmpNom, TM1.LiqLegImpTotal, T4.SecDescrip AS LiqSecDescrip, TM1.LiqLegReciboNro, T3.LegId, TM1.LegLiqDatosHis, TM1.LiqLegImpTotBruto, TM1.LiqLegImpTotBruSinSAC, TM1.LiqLegCntConc, TM1.LiqLegImpTotRemu, TM1.LiqLegImpTotNoRemu, TM1.LiqLegImpTotDescu, TM1.LiqLegImpContr, TM1.LiqLegImpCosto, TM1.LiqLegImpOtrDescu, TM1.LiqLegImpDescuNeg, TM1.LiqLegImpTotRetGan, TM1.LiqLegImpPagosACuen, TM1.LiqLegImpTotBruProm, TM1.LiqLegImpBasico, TM1.LiqLegGNSI, TM1.LiqRutaPDF, TM1.LiqRutaPDFVertical, TM1.LIqLegIteraciones, TM1.LiqLegSegundos, TM1.LiqLegSegIns, TM1.LieqLegSegUpd, TM1.LiqLegError, TM1.LiqPeriodo, TM1.LiqNombrePDF, TM1.LiqNombrePDFVertical, TM1.TLiqCod, TM1.LiqLegHorasSem, TM1.LiqLegAuxEstado, TM1.LiqLegErrorAux, TM1.LiqLegFecEgr, TM1.LiqLegFecIng, TM1.LiqLegCatCodigo, TM1.LiqLegConvenio, TM1.LiqLegSueldo, TM1.LiqLegPDFEstado, TM1.LiqLegProcesado, TM1.LiqLegNivLiq, TM1.LiqLegHtml, TM1.LiqLegLSD, TM1.LiqLegDaemonUUID, TM1.LiqLegFecHor, T3.LegNombre, T3.LegApellido, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LiqNro, TM1.LiqSecCodigo AS LiqSecCodigo FROM (((LiquidacionLegajo TM1 INNER JOIN Empresa T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod) INNER JOIN Legajo T3 ON T3.CliCod = TM1.CliCod AND T3.EmpCod = TM1.EmpCod AND T3.LegNumero = TM1.LegNumero) LEFT JOIN Seccion T4 ON T4.CliCod = TM1.CliCod AND T4.SecCodigo = TM1.LiqSecCodigo) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.LiqNro = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LiqNro, TM1.LegNumero ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V9", "SELECT SecDescrip AS LiqSecDescrip FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V10", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V11", "SELECT LiqPeriodo, TLiqCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V12", "SELECT LegIdNomApe, LegId, LegNombre, LegApellido FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V13", "SELECT CliCod, EmpCod, LiqNro, LegNumero FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V14", "SELECT CliCod, EmpCod, LegNumero, LiqNro FROM LiquidacionLegajo WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and LegNumero > ? or LegNumero = ? and EmpCod = ? and CliCod = ? and LiqNro > ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V15", "SELECT CliCod, EmpCod, LegNumero, LiqNro FROM LiquidacionLegajo WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and LegNumero < ? or LegNumero = ? and EmpCod = ? and CliCod = ? and LiqNro < ?) ORDER BY CliCod DESC, EmpCod DESC, LiqNro DESC, LegNumero DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000V16", "SAVEPOINT gxupdate;INSERT INTO LiquidacionLegajo(LiqPeriodo, TLiqCod, LiqLegImpTotal, LiqLegReciboNro, LegLiqDatosHis, LiqLegImpTotBruto, LiqLegImpTotBruSinSAC, LiqLegCntConc, LiqLegImpTotRemu, LiqLegImpTotNoRemu, LiqLegImpTotDescu, LiqLegImpContr, LiqLegImpCosto, LiqLegImpOtrDescu, LiqLegImpDescuNeg, LiqLegImpTotRetGan, LiqLegImpPagosACuen, LiqLegImpTotBruProm, LiqLegImpBasico, LiqLegGNSI, LiqRutaPDF, LiqRutaPDFVertical, LIqLegIteraciones, LiqLegSegundos, LiqLegSegIns, LieqLegSegUpd, LiqLegError, LiqNombrePDF, LiqNombrePDFVertical, LiqLegHorasSem, LiqLegAuxEstado, LiqLegErrorAux, LiqLegFecEgr, LiqLegFecIng, LiqLegCatCodigo, LiqLegConvenio, LiqLegSueldo, LiqLegPDFEstado, LiqLegProcesado, LiqLegNivLiq, LiqLegHtml, LiqLegLSD, LiqLegDaemonUUID, LiqLegFecHor, CliCod, EmpCod, LegNumero, LiqNro, LiqSecCodigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000V17", "SAVEPOINT gxupdate;UPDATE LiquidacionLegajo SET LiqPeriodo=?, TLiqCod=?, LiqLegImpTotal=?, LiqLegReciboNro=?, LegLiqDatosHis=?, LiqLegImpTotBruto=?, LiqLegImpTotBruSinSAC=?, LiqLegCntConc=?, LiqLegImpTotRemu=?, LiqLegImpTotNoRemu=?, LiqLegImpTotDescu=?, LiqLegImpContr=?, LiqLegImpCosto=?, LiqLegImpOtrDescu=?, LiqLegImpDescuNeg=?, LiqLegImpTotRetGan=?, LiqLegImpPagosACuen=?, LiqLegImpTotBruProm=?, LiqLegImpBasico=?, LiqLegGNSI=?, LiqRutaPDF=?, LiqRutaPDFVertical=?, LIqLegIteraciones=?, LiqLegSegundos=?, LiqLegSegIns=?, LieqLegSegUpd=?, LiqLegError=?, LiqNombrePDF=?, LiqNombrePDFVertical=?, LiqLegHorasSem=?, LiqLegAuxEstado=?, LiqLegErrorAux=?, LiqLegFecEgr=?, LiqLegFecIng=?, LiqLegCatCodigo=?, LiqLegConvenio=?, LiqLegSueldo=?, LiqLegPDFEstado=?, LiqLegProcesado=?, LiqLegNivLiq=?, LiqLegHtml=?, LiqLegLSD=?, LiqLegDaemonUUID=?, LiqLegFecHor=?, LiqSecCodigo=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000V18", "SAVEPOINT gxupdate;DELETE FROM LiquidacionLegajo  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000V19", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V20", "SELECT LiqPeriodo, TLiqCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V21", "SELECT LegIdNomApe, LegId, LegNombre, LegApellido FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V22", "SELECT SecDescrip AS LiqSecDescrip FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V23", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLConsAnio, LegCuLConsSec FROM legajo_cuenta_licenciasconsumos WHERE CliCod = ? AND EmpCod = ? AND LegCulConsLiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V24", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLAprLicFch FROM legajo_cuenta_licenciasaprobaciones WHERE CliCod = ? AND EmpCod = ? AND LegCuLAprLiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V25", "SELECT CliCod, EmpCod, LegNumero, LegHisFecIng FROM legajo_permanencia WHERE CliCod = ? AND EmpCod = ? AND LegHisLiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V26", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDetForCon, LiqDetForOpe, LiqDetForOpeCod FROM LiqDetForOperandos WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V27", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDOpeOrig FROM liquidacionLegajoCalculos WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V28", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqAjuNro FROM LiquidacionAjuste WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V29", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro FROM LiqLegObligacionCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqOblNuevaNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V30", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro FROM LiqLegObligacionCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqOblAltaNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V31", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial FROM Obligacion WHERE CliCod = ? AND EmpCod = ? AND OblLiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V32", "SELECT CliCod, EmpCod, LiqExAnio, LiqNro, LegNumero, LiqExenConCodigo, LiqExAplIIGG FROM liquidacion_exencion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V33", "SELECT CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro FROM LiqLegConceptoCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqNuevaNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V34", "SELECT CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro FROM LiqLegConceptoCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqAltaNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V35", "SELECT CliCod, EmpCod, LiqNro, LegNumero, TestLiqDSecuencial FROM TestTable WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V36", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V37", "SELECT CliCod, EmpCod, LegNumero, AgeOrden FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND AgeLiqNro = ? AND LegNumero = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V38", "SELECT CliCod, EmpCod, LiqNro, LegNumero FROM LiquidacionLegajo ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(15,2);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(16,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(17,2);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(18,2);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,6);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,6);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,6);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 200);
               ((String[]) buf[26])[0] = rslt.getString(27, 200);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(28,1);
               ((byte[]) buf[28])[0] = rslt.getByte(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((java.util.Date[]) buf[30])[0] = rslt.getGXDate(31);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(32);
               ((String[]) buf[32])[0] = rslt.getString(33, 40);
               ((String[]) buf[33])[0] = rslt.getString(34, 20);
               ((java.math.BigDecimal[]) buf[34])[0] = rslt.getBigDecimal(35,2);
               ((String[]) buf[35])[0] = rslt.getString(36, 20);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((byte[]) buf[37])[0] = rslt.getByte(37);
               ((byte[]) buf[38])[0] = rslt.getByte(38);
               ((String[]) buf[39])[0] = rslt.getLongVarchar(39);
               ((byte[]) buf[40])[0] = rslt.getByte(40);
               ((String[]) buf[41])[0] = rslt.getString(41, 36);
               ((boolean[]) buf[42])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[43])[0] = rslt.getGXDateTime(42);
               ((int[]) buf[44])[0] = rslt.getInt(43);
               ((short[]) buf[45])[0] = rslt.getShort(44);
               ((int[]) buf[46])[0] = rslt.getInt(45);
               ((int[]) buf[47])[0] = rslt.getInt(46);
               ((String[]) buf[48])[0] = rslt.getString(47, 20);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[50])[0] = rslt.getGXDate(48);
               ((String[]) buf[51])[0] = rslt.getString(49, 20);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               return;
            case 1 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(15,2);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(16,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(17,2);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(18,2);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,6);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,6);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,6);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 200);
               ((String[]) buf[26])[0] = rslt.getString(27, 200);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(28,1);
               ((byte[]) buf[28])[0] = rslt.getByte(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((java.util.Date[]) buf[30])[0] = rslt.getGXDate(31);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(32);
               ((String[]) buf[32])[0] = rslt.getString(33, 40);
               ((String[]) buf[33])[0] = rslt.getString(34, 20);
               ((java.math.BigDecimal[]) buf[34])[0] = rslt.getBigDecimal(35,2);
               ((String[]) buf[35])[0] = rslt.getString(36, 20);
               ((boolean[]) buf[36])[0] = rslt.wasNull();
               ((byte[]) buf[37])[0] = rslt.getByte(37);
               ((byte[]) buf[38])[0] = rslt.getByte(38);
               ((String[]) buf[39])[0] = rslt.getLongVarchar(39);
               ((byte[]) buf[40])[0] = rslt.getByte(40);
               ((String[]) buf[41])[0] = rslt.getString(41, 36);
               ((boolean[]) buf[42])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[43])[0] = rslt.getGXDateTime(42);
               ((int[]) buf[44])[0] = rslt.getInt(43);
               ((short[]) buf[45])[0] = rslt.getShort(44);
               ((int[]) buf[46])[0] = rslt.getInt(45);
               ((int[]) buf[47])[0] = rslt.getInt(46);
               ((String[]) buf[48])[0] = rslt.getString(47, 20);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[50])[0] = rslt.getGXDate(48);
               ((String[]) buf[51])[0] = rslt.getString(49, 20);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 4 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,2);
               ((short[]) buf[10])[0] = rslt.getShort(10);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(15,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(16,2);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(17,2);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(18,2);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(19,2);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(22,2);
               ((String[]) buf[23])[0] = rslt.getVarchar(23);
               ((String[]) buf[24])[0] = rslt.getVarchar(24);
               ((short[]) buf[25])[0] = rslt.getShort(25);
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(26,6);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(27,6);
               ((java.math.BigDecimal[]) buf[28])[0] = rslt.getBigDecimal(28,6);
               ((String[]) buf[29])[0] = rslt.getVarchar(29);
               ((java.util.Date[]) buf[30])[0] = rslt.getGXDate(30);
               ((String[]) buf[31])[0] = rslt.getString(31, 200);
               ((String[]) buf[32])[0] = rslt.getString(32, 200);
               ((String[]) buf[33])[0] = rslt.getString(33, 20);
               ((boolean[]) buf[34])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[35])[0] = rslt.getBigDecimal(34,1);
               ((byte[]) buf[36])[0] = rslt.getByte(35);
               ((String[]) buf[37])[0] = rslt.getVarchar(36);
               ((java.util.Date[]) buf[38])[0] = rslt.getGXDate(37);
               ((java.util.Date[]) buf[39])[0] = rslt.getGXDate(38);
               ((String[]) buf[40])[0] = rslt.getString(39, 40);
               ((String[]) buf[41])[0] = rslt.getString(40, 20);
               ((java.math.BigDecimal[]) buf[42])[0] = rslt.getBigDecimal(41,2);
               ((String[]) buf[43])[0] = rslt.getString(42, 20);
               ((boolean[]) buf[44])[0] = rslt.wasNull();
               ((byte[]) buf[45])[0] = rslt.getByte(43);
               ((byte[]) buf[46])[0] = rslt.getByte(44);
               ((String[]) buf[47])[0] = rslt.getLongVarchar(45);
               ((byte[]) buf[48])[0] = rslt.getByte(46);
               ((String[]) buf[49])[0] = rslt.getString(47, 36);
               ((boolean[]) buf[50])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[51])[0] = rslt.getGXDateTime(48);
               ((String[]) buf[52])[0] = rslt.getVarchar(49);
               ((String[]) buf[53])[0] = rslt.getVarchar(50);
               ((int[]) buf[54])[0] = rslt.getInt(51);
               ((short[]) buf[55])[0] = rslt.getShort(52);
               ((int[]) buf[56])[0] = rslt.getInt(53);
               ((int[]) buf[57])[0] = rslt.getInt(54);
               ((String[]) buf[58])[0] = rslt.getString(55, 20);
               ((boolean[]) buf[59])[0] = rslt.wasNull();
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 18 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 24 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 100);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 27 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 28 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 31 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 32 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 34 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 35 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 36 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               return;
            case 14 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[3], 2);
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setVarchar(5, (String)parms[5], 4000, false);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 2);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 2);
               stmt.setShort(8, ((Number) parms[8]).shortValue());
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[9], 2);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[10], 2);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[11], 2);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[12], 2);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[13], 2);
               stmt.setBigDecimal(14, (java.math.BigDecimal)parms[14], 2);
               stmt.setBigDecimal(15, (java.math.BigDecimal)parms[15], 2);
               stmt.setBigDecimal(16, (java.math.BigDecimal)parms[16], 2);
               stmt.setBigDecimal(17, (java.math.BigDecimal)parms[17], 2);
               stmt.setBigDecimal(18, (java.math.BigDecimal)parms[18], 2);
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[19], 2);
               stmt.setBigDecimal(20, (java.math.BigDecimal)parms[20], 2);
               stmt.setVarchar(21, (String)parms[21], 400, false);
               stmt.setVarchar(22, (String)parms[22], 400, false);
               stmt.setShort(23, ((Number) parms[23]).shortValue());
               stmt.setBigDecimal(24, (java.math.BigDecimal)parms[24], 6);
               stmt.setBigDecimal(25, (java.math.BigDecimal)parms[25], 6);
               stmt.setBigDecimal(26, (java.math.BigDecimal)parms[26], 6);
               stmt.setVarchar(27, (String)parms[27], 400, false);
               stmt.setString(28, (String)parms[28], 200);
               stmt.setString(29, (String)parms[29], 200);
               stmt.setBigDecimal(30, (java.math.BigDecimal)parms[30], 1);
               stmt.setByte(31, ((Number) parms[31]).byteValue());
               stmt.setVarchar(32, (String)parms[32], 400, false);
               stmt.setDate(33, (java.util.Date)parms[33]);
               stmt.setDate(34, (java.util.Date)parms[34]);
               stmt.setString(35, (String)parms[35], 40);
               stmt.setString(36, (String)parms[36], 20);
               stmt.setBigDecimal(37, (java.math.BigDecimal)parms[37], 2);
               if ( ((Boolean) parms[38]).booleanValue() )
               {
                  stmt.setNull( 38 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(38, (String)parms[39], 20);
               }
               stmt.setByte(39, ((Number) parms[40]).byteValue());
               stmt.setByte(40, ((Number) parms[41]).byteValue());
               stmt.setNLongVarchar(41, (String)parms[42], false);
               stmt.setByte(42, ((Number) parms[43]).byteValue());
               if ( ((Boolean) parms[44]).booleanValue() )
               {
                  stmt.setNull( 43 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(43, (String)parms[45], 36);
               }
               stmt.setDateTime(44, (java.util.Date)parms[46], false);
               stmt.setInt(45, ((Number) parms[47]).intValue());
               stmt.setShort(46, ((Number) parms[48]).shortValue());
               stmt.setInt(47, ((Number) parms[49]).intValue());
               stmt.setInt(48, ((Number) parms[50]).intValue());
               if ( ((Boolean) parms[51]).booleanValue() )
               {
                  stmt.setNull( 49 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(49, (String)parms[52], 20);
               }
               return;
            case 15 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[3], 2);
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setVarchar(5, (String)parms[5], 4000, false);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 2);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 2);
               stmt.setShort(8, ((Number) parms[8]).shortValue());
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[9], 2);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[10], 2);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[11], 2);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[12], 2);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[13], 2);
               stmt.setBigDecimal(14, (java.math.BigDecimal)parms[14], 2);
               stmt.setBigDecimal(15, (java.math.BigDecimal)parms[15], 2);
               stmt.setBigDecimal(16, (java.math.BigDecimal)parms[16], 2);
               stmt.setBigDecimal(17, (java.math.BigDecimal)parms[17], 2);
               stmt.setBigDecimal(18, (java.math.BigDecimal)parms[18], 2);
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[19], 2);
               stmt.setBigDecimal(20, (java.math.BigDecimal)parms[20], 2);
               stmt.setVarchar(21, (String)parms[21], 400, false);
               stmt.setVarchar(22, (String)parms[22], 400, false);
               stmt.setShort(23, ((Number) parms[23]).shortValue());
               stmt.setBigDecimal(24, (java.math.BigDecimal)parms[24], 6);
               stmt.setBigDecimal(25, (java.math.BigDecimal)parms[25], 6);
               stmt.setBigDecimal(26, (java.math.BigDecimal)parms[26], 6);
               stmt.setVarchar(27, (String)parms[27], 400, false);
               stmt.setString(28, (String)parms[28], 200);
               stmt.setString(29, (String)parms[29], 200);
               stmt.setBigDecimal(30, (java.math.BigDecimal)parms[30], 1);
               stmt.setByte(31, ((Number) parms[31]).byteValue());
               stmt.setVarchar(32, (String)parms[32], 400, false);
               stmt.setDate(33, (java.util.Date)parms[33]);
               stmt.setDate(34, (java.util.Date)parms[34]);
               stmt.setString(35, (String)parms[35], 40);
               stmt.setString(36, (String)parms[36], 20);
               stmt.setBigDecimal(37, (java.math.BigDecimal)parms[37], 2);
               if ( ((Boolean) parms[38]).booleanValue() )
               {
                  stmt.setNull( 38 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(38, (String)parms[39], 20);
               }
               stmt.setByte(39, ((Number) parms[40]).byteValue());
               stmt.setByte(40, ((Number) parms[41]).byteValue());
               stmt.setNLongVarchar(41, (String)parms[42], false);
               stmt.setByte(42, ((Number) parms[43]).byteValue());
               if ( ((Boolean) parms[44]).booleanValue() )
               {
                  stmt.setNull( 43 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(43, (String)parms[45], 36);
               }
               stmt.setDateTime(44, (java.util.Date)parms[46], false);
               if ( ((Boolean) parms[47]).booleanValue() )
               {
                  stmt.setNull( 45 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(45, (String)parms[48], 20);
               }
               stmt.setInt(46, ((Number) parms[49]).intValue());
               stmt.setShort(47, ((Number) parms[50]).shortValue());
               stmt.setInt(48, ((Number) parms[51]).intValue());
               stmt.setInt(49, ((Number) parms[52]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 32 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 34 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

