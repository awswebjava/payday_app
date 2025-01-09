package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class liqlegconceptocuenta_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_5") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A888LiqLegCodigo = (short)(GXutil.lval( httpContext.GetPar( "LiqLegCodigo"))) ;
         n888LiqLegCodigo = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A888LiqLegCodigo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A888LiqLegCodigo), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_5( A3CliCod, A888LiqLegCodigo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_4") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = httpContext.GetPar( "ConCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_4( A3CliCod, A26ConCodigo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_2") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1097LiqAltaNro = (int)(GXutil.lval( httpContext.GetPar( "LiqAltaNro"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1097LiqAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1097LiqAltaNro), 8, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_2( A3CliCod, A1EmpCod, A1097LiqAltaNro, A6LegNumero) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_3") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1098LiqNuevaNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNuevaNro"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1098LiqNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1098LiqNuevaNro), 8, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_3( A3CliCod, A1EmpCod, A1098LiqNuevaNro, A6LegNumero) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Liq Leg Concepto Cuenta", ""), (short)(0)) ;
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

   public liqlegconceptocuenta_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public liqlegconceptocuenta_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liqlegconceptocuenta_impl.class ));
   }

   public liqlegconceptocuenta_impl( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkLiqLegPrimera = UIFactory.getCheckbox(this);
      chkLiqLegEsPrrGan = UIFactory.getCheckbox(this);
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
      A889LiqLegPrimera = GXutil.strtobool( GXutil.booltostr( A889LiqLegPrimera)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A889LiqLegPrimera", A889LiqLegPrimera);
      A1778LiqLegEsPrrGan = GXutil.strtobool( GXutil.booltostr( A1778LiqLegEsPrrGan)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1778LiqLegEsPrrGan", A1778LiqLegEsPrrGan);
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "Liq Leg Concepto Cuenta", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_LiqLegConceptoCuenta.htm");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_LiqLegConceptoCuenta.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiqLegConceptoCuenta.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqLegConAnio_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqLegConAnio_Internalname, httpContext.getMessage( "Año", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqLegConAnio_Internalname, GXutil.ltrim( localUtil.ntoc( A869LiqLegConAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqLegConAnio_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A869LiqLegConAnio), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A869LiqLegConAnio), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqLegConAnio_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqLegConAnio_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Anio", "right", false, "", "HLP_LiqLegConceptoCuenta.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegNumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConCodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConCodigo_Internalname, GXutil.rtrim( A26ConCodigo), GXutil.rtrim( localUtil.format( A26ConCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConCodigo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqAltaNro_Internalname+"\"", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqAltaNro_Internalname, GXutil.ltrim( localUtil.ntoc( A1097LiqAltaNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqAltaNro_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1097LiqAltaNro), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1097LiqAltaNro), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqAltaNro_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqAltaNro_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqNuevaNro_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqNuevaNro_Internalname, httpContext.getMessage( "Nueva Nro", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqNuevaNro_Internalname, GXutil.ltrim( localUtil.ntoc( A1098LiqNuevaNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqNuevaNro_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1098LiqNuevaNro), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1098LiqNuevaNro), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqNuevaNro_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqNuevaNro_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqLegConSaldo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqLegConSaldo_Internalname, httpContext.getMessage( "Saldo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqLegConSaldo_Internalname, GXutil.ltrim( localUtil.ntoc( A868LiqLegConSaldo, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqLegConSaldo_Enabled!=0) ? localUtil.format( A868LiqLegConSaldo, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A868LiqLegConSaldo, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqLegConSaldo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqLegConSaldo_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqLegConPer_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqLegConPer_Internalname, httpContext.getMessage( "Periodo en el que fué añadido el concepto a prorratear", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtLiqLegConPer_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqLegConPer_Internalname, localUtil.format(A886LiqLegConPer, "99/99/9999"), localUtil.format( A886LiqLegConPer, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqLegConPer_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqLegConPer_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtLiqLegConPer_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLiqLegConPer_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LiqLegConceptoCuenta.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqLegCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqLegCodigo_Internalname, httpContext.getMessage( "Leg Codigo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqLegCodigo_Internalname, GXutil.ltrim( localUtil.ntoc( A888LiqLegCodigo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqLegCodigo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A888LiqLegCodigo), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A888LiqLegCodigo), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqLegCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqLegCodigo_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkLiqLegPrimera.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkLiqLegPrimera.getInternalname(), httpContext.getMessage( "Leg Primera", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkLiqLegPrimera.getInternalname(), GXutil.booltostr( A889LiqLegPrimera), "", httpContext.getMessage( "Leg Primera", ""), 1, chkLiqLegPrimera.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(84, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,84);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqLegLog_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqLegLog_Internalname, httpContext.getMessage( "Leg Log", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtLiqLegLog_Internalname, A1094LiqLegLog, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,89);\"", (short)(0), 1, edtLiqLegLog_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "1000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqLegCuota_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqLegCuota_Internalname, httpContext.getMessage( "Leg Cuota", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqLegCuota_Internalname, GXutil.ltrim( localUtil.ntoc( A1099LiqLegCuota, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqLegCuota_Enabled!=0) ? localUtil.format( A1099LiqLegCuota, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1099LiqLegCuota, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,94);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqLegCuota_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqLegCuota_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqLegTotal_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqLegTotal_Internalname, httpContext.getMessage( "Leg Total", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqLegTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A1147LiqLegTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqLegTotal_Enabled!=0) ? localUtil.format( A1147LiqLegTotal, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1147LiqLegTotal, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,99);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqLegTotal_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqLegTotal_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqLegTotRecal_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqLegTotRecal_Internalname, httpContext.getMessage( "Tot Recal", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqLegTotRecal_Internalname, GXutil.ltrim( localUtil.ntoc( A1148LiqLegTotRecal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqLegTotRecal_Enabled!=0) ? localUtil.format( A1148LiqLegTotRecal, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1148LiqLegTotRecal, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,104);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqLegTotRecal_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqLegTotRecal_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkLiqLegEsPrrGan.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkLiqLegEsPrrGan.getInternalname(), httpContext.getMessage( "Es prorrateo para ganancias", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkLiqLegEsPrrGan.getInternalname(), GXutil.booltostr( A1778LiqLegEsPrrGan), "", httpContext.getMessage( "Es prorrateo para ganancias", ""), 1, chkLiqLegEsPrrGan.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(109, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,109);\"");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 114,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 116,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiqLegConceptoCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 118,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiqLegConceptoCuenta.htm");
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
         Z869LiqLegConAnio = (short)(localUtil.ctol( httpContext.cgiGet( "Z869LiqLegConAnio"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "Z6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z26ConCodigo = httpContext.cgiGet( "Z26ConCodigo") ;
         Z1097LiqAltaNro = (int)(localUtil.ctol( httpContext.cgiGet( "Z1097LiqAltaNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1098LiqNuevaNro = (int)(localUtil.ctol( httpContext.cgiGet( "Z1098LiqNuevaNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z868LiqLegConSaldo = localUtil.ctond( httpContext.cgiGet( "Z868LiqLegConSaldo")) ;
         Z886LiqLegConPer = localUtil.ctod( httpContext.cgiGet( "Z886LiqLegConPer"), 0) ;
         n886LiqLegConPer = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A886LiqLegConPer)) ? true : false) ;
         Z889LiqLegPrimera = GXutil.strtobool( httpContext.cgiGet( "Z889LiqLegPrimera")) ;
         Z1094LiqLegLog = httpContext.cgiGet( "Z1094LiqLegLog") ;
         Z1099LiqLegCuota = localUtil.ctond( httpContext.cgiGet( "Z1099LiqLegCuota")) ;
         Z1147LiqLegTotal = localUtil.ctond( httpContext.cgiGet( "Z1147LiqLegTotal")) ;
         Z1148LiqLegTotRecal = localUtil.ctond( httpContext.cgiGet( "Z1148LiqLegTotRecal")) ;
         Z1778LiqLegEsPrrGan = GXutil.strtobool( httpContext.cgiGet( "Z1778LiqLegEsPrrGan")) ;
         Z888LiqLegCodigo = (short)(localUtil.ctol( httpContext.cgiGet( "Z888LiqLegCodigo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         n888LiqLegCodigo = ((0==A888LiqLegCodigo) ? true : false) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         A42ConCodYDesc = httpContext.cgiGet( "CONCODYDESC") ;
         n42ConCodYDesc = false ;
         A41ConDescrip = httpContext.cgiGet( "CONDESCRIP") ;
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
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqLegConAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqLegConAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQLEGCONANIO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqLegConAnio_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A869LiqLegConAnio = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A869LiqLegConAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A869LiqLegConAnio), 4, 0));
         }
         else
         {
            A869LiqLegConAnio = (short)(localUtil.ctol( httpContext.cgiGet( edtLiqLegConAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A869LiqLegConAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A869LiqLegConAnio), 4, 0));
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
         A26ConCodigo = httpContext.cgiGet( edtConCodigo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqAltaNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqAltaNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQALTANRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqAltaNro_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1097LiqAltaNro = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A1097LiqAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1097LiqAltaNro), 8, 0));
         }
         else
         {
            A1097LiqAltaNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqAltaNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1097LiqAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1097LiqAltaNro), 8, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqNuevaNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqNuevaNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQNUEVANRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqNuevaNro_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1098LiqNuevaNro = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A1098LiqNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1098LiqNuevaNro), 8, 0));
         }
         else
         {
            A1098LiqNuevaNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqNuevaNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1098LiqNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1098LiqNuevaNro), 8, 0));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqLegConSaldo_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqLegConSaldo_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQLEGCONSALDO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqLegConSaldo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A868LiqLegConSaldo = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A868LiqLegConSaldo", GXutil.ltrimstr( A868LiqLegConSaldo, 14, 2));
         }
         else
         {
            A868LiqLegConSaldo = localUtil.ctond( httpContext.cgiGet( edtLiqLegConSaldo_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A868LiqLegConSaldo", GXutil.ltrimstr( A868LiqLegConSaldo, 14, 2));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtLiqLegConPer_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "LIQLEGCONPER");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqLegConPer_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A886LiqLegConPer = GXutil.nullDate() ;
            n886LiqLegConPer = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A886LiqLegConPer", localUtil.format(A886LiqLegConPer, "99/99/9999"));
         }
         else
         {
            A886LiqLegConPer = localUtil.ctod( httpContext.cgiGet( edtLiqLegConPer_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            n886LiqLegConPer = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A886LiqLegConPer", localUtil.format(A886LiqLegConPer, "99/99/9999"));
         }
         n886LiqLegConPer = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A886LiqLegConPer)) ? true : false) ;
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqLegCodigo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqLegCodigo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQLEGCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqLegCodigo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A888LiqLegCodigo = (short)(0) ;
            n888LiqLegCodigo = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A888LiqLegCodigo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A888LiqLegCodigo), 4, 0));
         }
         else
         {
            A888LiqLegCodigo = (short)(localUtil.ctol( httpContext.cgiGet( edtLiqLegCodigo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n888LiqLegCodigo = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A888LiqLegCodigo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A888LiqLegCodigo), 4, 0));
         }
         n888LiqLegCodigo = ((0==A888LiqLegCodigo) ? true : false) ;
         A889LiqLegPrimera = GXutil.strtobool( httpContext.cgiGet( chkLiqLegPrimera.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "A889LiqLegPrimera", A889LiqLegPrimera);
         A1094LiqLegLog = httpContext.cgiGet( edtLiqLegLog_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1094LiqLegLog", A1094LiqLegLog);
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqLegCuota_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqLegCuota_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQLEGCUOTA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqLegCuota_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1099LiqLegCuota = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A1099LiqLegCuota", GXutil.ltrimstr( A1099LiqLegCuota, 14, 2));
         }
         else
         {
            A1099LiqLegCuota = localUtil.ctond( httpContext.cgiGet( edtLiqLegCuota_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1099LiqLegCuota", GXutil.ltrimstr( A1099LiqLegCuota, 14, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqLegTotal_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqLegTotal_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQLEGTOTAL");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqLegTotal_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1147LiqLegTotal = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A1147LiqLegTotal", GXutil.ltrimstr( A1147LiqLegTotal, 14, 2));
         }
         else
         {
            A1147LiqLegTotal = localUtil.ctond( httpContext.cgiGet( edtLiqLegTotal_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1147LiqLegTotal", GXutil.ltrimstr( A1147LiqLegTotal, 14, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqLegTotRecal_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqLegTotRecal_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQLEGTOTRECAL");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqLegTotRecal_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1148LiqLegTotRecal = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A1148LiqLegTotRecal", GXutil.ltrimstr( A1148LiqLegTotRecal, 14, 2));
         }
         else
         {
            A1148LiqLegTotRecal = localUtil.ctond( httpContext.cgiGet( edtLiqLegTotRecal_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1148LiqLegTotRecal", GXutil.ltrimstr( A1148LiqLegTotRecal, 14, 2));
         }
         A1778LiqLegEsPrrGan = GXutil.strtobool( httpContext.cgiGet( chkLiqLegEsPrrGan.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1778LiqLegEsPrrGan", A1778LiqLegEsPrrGan);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
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
            A869LiqLegConAnio = (short)(GXutil.lval( httpContext.GetPar( "LiqLegConAnio"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A869LiqLegConAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A869LiqLegConAnio), 4, 0));
            A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A26ConCodigo = httpContext.GetPar( "ConCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
            A1097LiqAltaNro = (int)(GXutil.lval( httpContext.GetPar( "LiqAltaNro"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1097LiqAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1097LiqAltaNro), 8, 0));
            A1098LiqNuevaNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNuevaNro"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1098LiqNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1098LiqNuevaNro), 8, 0));
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
            initAll2M122( ) ;
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
      disableAttributes2M122( ) ;
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

   public void resetCaption2M0( )
   {
   }

   public void zm2M122( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z868LiqLegConSaldo = T002M3_A868LiqLegConSaldo[0] ;
            Z886LiqLegConPer = T002M3_A886LiqLegConPer[0] ;
            Z889LiqLegPrimera = T002M3_A889LiqLegPrimera[0] ;
            Z1094LiqLegLog = T002M3_A1094LiqLegLog[0] ;
            Z1099LiqLegCuota = T002M3_A1099LiqLegCuota[0] ;
            Z1147LiqLegTotal = T002M3_A1147LiqLegTotal[0] ;
            Z1148LiqLegTotRecal = T002M3_A1148LiqLegTotRecal[0] ;
            Z1778LiqLegEsPrrGan = T002M3_A1778LiqLegEsPrrGan[0] ;
            Z888LiqLegCodigo = T002M3_A888LiqLegCodigo[0] ;
         }
         else
         {
            Z868LiqLegConSaldo = A868LiqLegConSaldo ;
            Z886LiqLegConPer = A886LiqLegConPer ;
            Z889LiqLegPrimera = A889LiqLegPrimera ;
            Z1094LiqLegLog = A1094LiqLegLog ;
            Z1099LiqLegCuota = A1099LiqLegCuota ;
            Z1147LiqLegTotal = A1147LiqLegTotal ;
            Z1148LiqLegTotRecal = A1148LiqLegTotRecal ;
            Z1778LiqLegEsPrrGan = A1778LiqLegEsPrrGan ;
            Z888LiqLegCodigo = A888LiqLegCodigo ;
         }
      }
      if ( GX_JID == -1 )
      {
         Z869LiqLegConAnio = A869LiqLegConAnio ;
         Z868LiqLegConSaldo = A868LiqLegConSaldo ;
         Z886LiqLegConPer = A886LiqLegConPer ;
         Z889LiqLegPrimera = A889LiqLegPrimera ;
         Z1094LiqLegLog = A1094LiqLegLog ;
         Z1099LiqLegCuota = A1099LiqLegCuota ;
         Z1147LiqLegTotal = A1147LiqLegTotal ;
         Z1148LiqLegTotRecal = A1148LiqLegTotRecal ;
         Z1778LiqLegEsPrrGan = A1778LiqLegEsPrrGan ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1097LiqAltaNro = A1097LiqAltaNro ;
         Z1098LiqNuevaNro = A1098LiqNuevaNro ;
         Z26ConCodigo = A26ConCodigo ;
         Z888LiqLegCodigo = A888LiqLegCodigo ;
         Z42ConCodYDesc = A42ConCodYDesc ;
         Z41ConDescrip = A41ConDescrip ;
      }
   }

   public void standaloneNotModal( )
   {
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

   public void load2M122( )
   {
      /* Using cursor T002M8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A1098LiqNuevaNro), A26ConCodigo});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound122 = (short)(1) ;
         A42ConCodYDesc = T002M8_A42ConCodYDesc[0] ;
         n42ConCodYDesc = T002M8_n42ConCodYDesc[0] ;
         A868LiqLegConSaldo = T002M8_A868LiqLegConSaldo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A868LiqLegConSaldo", GXutil.ltrimstr( A868LiqLegConSaldo, 14, 2));
         A886LiqLegConPer = T002M8_A886LiqLegConPer[0] ;
         n886LiqLegConPer = T002M8_n886LiqLegConPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A886LiqLegConPer", localUtil.format(A886LiqLegConPer, "99/99/9999"));
         A889LiqLegPrimera = T002M8_A889LiqLegPrimera[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A889LiqLegPrimera", A889LiqLegPrimera);
         A1094LiqLegLog = T002M8_A1094LiqLegLog[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1094LiqLegLog", A1094LiqLegLog);
         A1099LiqLegCuota = T002M8_A1099LiqLegCuota[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1099LiqLegCuota", GXutil.ltrimstr( A1099LiqLegCuota, 14, 2));
         A1147LiqLegTotal = T002M8_A1147LiqLegTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1147LiqLegTotal", GXutil.ltrimstr( A1147LiqLegTotal, 14, 2));
         A1148LiqLegTotRecal = T002M8_A1148LiqLegTotRecal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1148LiqLegTotRecal", GXutil.ltrimstr( A1148LiqLegTotRecal, 14, 2));
         A1778LiqLegEsPrrGan = T002M8_A1778LiqLegEsPrrGan[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1778LiqLegEsPrrGan", A1778LiqLegEsPrrGan);
         A41ConDescrip = T002M8_A41ConDescrip[0] ;
         A888LiqLegCodigo = T002M8_A888LiqLegCodigo[0] ;
         n888LiqLegCodigo = T002M8_n888LiqLegCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A888LiqLegCodigo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A888LiqLegCodigo), 4, 0));
         zm2M122( -1) ;
      }
      pr_default.close(6);
      onLoadActions2M122( ) ;
   }

   public void onLoadActions2M122( )
   {
   }

   public void checkExtendedTable2M122( )
   {
      nIsDirty_122 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T002M7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n888LiqLegCodigo), Short.valueOf(A888LiqLegCodigo)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A888LiqLegCodigo) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cuenta Prorra Apl IIGGGroup", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQLEGCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(5);
      /* Using cursor T002M6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A42ConCodYDesc = T002M6_A42ConCodYDesc[0] ;
      n42ConCodYDesc = T002M6_n42ConCodYDesc[0] ;
      A41ConDescrip = T002M6_A41ConDescrip[0] ;
      A41ConDescrip = T002M6_A41ConDescrip[0] ;
      pr_default.close(4);
      /* Using cursor T002M4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T002M5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1098LiqNuevaNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
   }

   public void closeExtendedTableCursors2M122( )
   {
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_5( int A3CliCod ,
                         short A888LiqLegCodigo )
   {
      /* Using cursor T002M9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n888LiqLegCodigo), Short.valueOf(A888LiqLegCodigo)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A888LiqLegCodigo) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cuenta Prorra Apl IIGGGroup", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQLEGCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void gxload_4( int A3CliCod ,
                         String A26ConCodigo )
   {
      /* Using cursor T002M10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A42ConCodYDesc = T002M10_A42ConCodYDesc[0] ;
      n42ConCodYDesc = T002M10_n42ConCodYDesc[0] ;
      A41ConDescrip = T002M10_A41ConDescrip[0] ;
      A41ConDescrip = T002M10_A41ConDescrip[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A42ConCodYDesc)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A41ConDescrip)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A41ConDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(8) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(8);
   }

   public void gxload_2( int A3CliCod ,
                         short A1EmpCod ,
                         int A1097LiqAltaNro ,
                         int A6LegNumero )
   {
      /* Using cursor T002M11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(9) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(9) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(9);
   }

   public void gxload_3( int A3CliCod ,
                         short A1EmpCod ,
                         int A1098LiqNuevaNro ,
                         int A6LegNumero )
   {
      /* Using cursor T002M12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1098LiqNuevaNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
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

   public void getKey2M122( )
   {
      /* Using cursor T002M13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A6LegNumero), A26ConCodigo, Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A1098LiqNuevaNro)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound122 = (short)(1) ;
      }
      else
      {
         RcdFound122 = (short)(0) ;
      }
      pr_default.close(11);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T002M3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A6LegNumero), A26ConCodigo, Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A1098LiqNuevaNro)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm2M122( 1) ;
         RcdFound122 = (short)(1) ;
         A869LiqLegConAnio = T002M3_A869LiqLegConAnio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A869LiqLegConAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A869LiqLegConAnio), 4, 0));
         A868LiqLegConSaldo = T002M3_A868LiqLegConSaldo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A868LiqLegConSaldo", GXutil.ltrimstr( A868LiqLegConSaldo, 14, 2));
         A886LiqLegConPer = T002M3_A886LiqLegConPer[0] ;
         n886LiqLegConPer = T002M3_n886LiqLegConPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A886LiqLegConPer", localUtil.format(A886LiqLegConPer, "99/99/9999"));
         A889LiqLegPrimera = T002M3_A889LiqLegPrimera[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A889LiqLegPrimera", A889LiqLegPrimera);
         A1094LiqLegLog = T002M3_A1094LiqLegLog[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1094LiqLegLog", A1094LiqLegLog);
         A1099LiqLegCuota = T002M3_A1099LiqLegCuota[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1099LiqLegCuota", GXutil.ltrimstr( A1099LiqLegCuota, 14, 2));
         A1147LiqLegTotal = T002M3_A1147LiqLegTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1147LiqLegTotal", GXutil.ltrimstr( A1147LiqLegTotal, 14, 2));
         A1148LiqLegTotRecal = T002M3_A1148LiqLegTotRecal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1148LiqLegTotRecal", GXutil.ltrimstr( A1148LiqLegTotRecal, 14, 2));
         A1778LiqLegEsPrrGan = T002M3_A1778LiqLegEsPrrGan[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1778LiqLegEsPrrGan", A1778LiqLegEsPrrGan);
         A3CliCod = T002M3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002M3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T002M3_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A1097LiqAltaNro = T002M3_A1097LiqAltaNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1097LiqAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1097LiqAltaNro), 8, 0));
         A1098LiqNuevaNro = T002M3_A1098LiqNuevaNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1098LiqNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1098LiqNuevaNro), 8, 0));
         A26ConCodigo = T002M3_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         A888LiqLegCodigo = T002M3_A888LiqLegCodigo[0] ;
         n888LiqLegCodigo = T002M3_n888LiqLegCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A888LiqLegCodigo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A888LiqLegCodigo), 4, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z869LiqLegConAnio = A869LiqLegConAnio ;
         Z6LegNumero = A6LegNumero ;
         Z26ConCodigo = A26ConCodigo ;
         Z1097LiqAltaNro = A1097LiqAltaNro ;
         Z1098LiqNuevaNro = A1098LiqNuevaNro ;
         sMode122 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load2M122( ) ;
         if ( AnyError == 1 )
         {
            RcdFound122 = (short)(0) ;
            initializeNonKey2M122( ) ;
         }
         Gx_mode = sMode122 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound122 = (short)(0) ;
         initializeNonKey2M122( ) ;
         sMode122 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode122 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey2M122( ) ;
      if ( RcdFound122 == 0 )
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
      RcdFound122 = (short)(0) ;
      /* Using cursor T002M14 */
      pr_default.execute(12, new Object[] {Short.valueOf(A869LiqLegConAnio), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A869LiqLegConAnio), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A1098LiqNuevaNro), Integer.valueOf(A1098LiqNuevaNro), Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A869LiqLegConAnio), A26ConCodigo});
      if ( (pr_default.getStatus(12) != 101) )
      {
         while ( (pr_default.getStatus(12) != 101) && ( ( T002M14_A869LiqLegConAnio[0] < A869LiqLegConAnio ) || ( T002M14_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M14_A3CliCod[0] < A3CliCod ) || ( T002M14_A3CliCod[0] == A3CliCod ) && ( T002M14_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M14_A1EmpCod[0] < A1EmpCod ) || ( T002M14_A1EmpCod[0] == A1EmpCod ) && ( T002M14_A3CliCod[0] == A3CliCod ) && ( T002M14_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M14_A6LegNumero[0] < A6LegNumero ) || ( T002M14_A6LegNumero[0] == A6LegNumero ) && ( T002M14_A1EmpCod[0] == A1EmpCod ) && ( T002M14_A3CliCod[0] == A3CliCod ) && ( T002M14_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M14_A1097LiqAltaNro[0] < A1097LiqAltaNro ) || ( T002M14_A1097LiqAltaNro[0] == A1097LiqAltaNro ) && ( T002M14_A6LegNumero[0] == A6LegNumero ) && ( T002M14_A1EmpCod[0] == A1EmpCod ) && ( T002M14_A3CliCod[0] == A3CliCod ) && ( T002M14_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M14_A1098LiqNuevaNro[0] < A1098LiqNuevaNro ) || ( T002M14_A1098LiqNuevaNro[0] == A1098LiqNuevaNro ) && ( T002M14_A1097LiqAltaNro[0] == A1097LiqAltaNro ) && ( T002M14_A6LegNumero[0] == A6LegNumero ) && ( T002M14_A1EmpCod[0] == A1EmpCod ) && ( T002M14_A3CliCod[0] == A3CliCod ) && ( T002M14_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( GXutil.strcmp(T002M14_A26ConCodigo[0], A26ConCodigo) < 0 ) ) )
         {
            pr_default.readNext(12);
         }
         if ( (pr_default.getStatus(12) != 101) && ( ( T002M14_A869LiqLegConAnio[0] > A869LiqLegConAnio ) || ( T002M14_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M14_A3CliCod[0] > A3CliCod ) || ( T002M14_A3CliCod[0] == A3CliCod ) && ( T002M14_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M14_A1EmpCod[0] > A1EmpCod ) || ( T002M14_A1EmpCod[0] == A1EmpCod ) && ( T002M14_A3CliCod[0] == A3CliCod ) && ( T002M14_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M14_A6LegNumero[0] > A6LegNumero ) || ( T002M14_A6LegNumero[0] == A6LegNumero ) && ( T002M14_A1EmpCod[0] == A1EmpCod ) && ( T002M14_A3CliCod[0] == A3CliCod ) && ( T002M14_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M14_A1097LiqAltaNro[0] > A1097LiqAltaNro ) || ( T002M14_A1097LiqAltaNro[0] == A1097LiqAltaNro ) && ( T002M14_A6LegNumero[0] == A6LegNumero ) && ( T002M14_A1EmpCod[0] == A1EmpCod ) && ( T002M14_A3CliCod[0] == A3CliCod ) && ( T002M14_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M14_A1098LiqNuevaNro[0] > A1098LiqNuevaNro ) || ( T002M14_A1098LiqNuevaNro[0] == A1098LiqNuevaNro ) && ( T002M14_A1097LiqAltaNro[0] == A1097LiqAltaNro ) && ( T002M14_A6LegNumero[0] == A6LegNumero ) && ( T002M14_A1EmpCod[0] == A1EmpCod ) && ( T002M14_A3CliCod[0] == A3CliCod ) && ( T002M14_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( GXutil.strcmp(T002M14_A26ConCodigo[0], A26ConCodigo) > 0 ) ) )
         {
            A869LiqLegConAnio = T002M14_A869LiqLegConAnio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A869LiqLegConAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A869LiqLegConAnio), 4, 0));
            A3CliCod = T002M14_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002M14_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T002M14_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A1097LiqAltaNro = T002M14_A1097LiqAltaNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1097LiqAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1097LiqAltaNro), 8, 0));
            A1098LiqNuevaNro = T002M14_A1098LiqNuevaNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1098LiqNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1098LiqNuevaNro), 8, 0));
            A26ConCodigo = T002M14_A26ConCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
            RcdFound122 = (short)(1) ;
         }
      }
      pr_default.close(12);
   }

   public void move_previous( )
   {
      RcdFound122 = (short)(0) ;
      /* Using cursor T002M15 */
      pr_default.execute(13, new Object[] {Short.valueOf(A869LiqLegConAnio), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A869LiqLegConAnio), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A1098LiqNuevaNro), Integer.valueOf(A1098LiqNuevaNro), Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A869LiqLegConAnio), A26ConCodigo});
      if ( (pr_default.getStatus(13) != 101) )
      {
         while ( (pr_default.getStatus(13) != 101) && ( ( T002M15_A869LiqLegConAnio[0] > A869LiqLegConAnio ) || ( T002M15_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M15_A3CliCod[0] > A3CliCod ) || ( T002M15_A3CliCod[0] == A3CliCod ) && ( T002M15_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M15_A1EmpCod[0] > A1EmpCod ) || ( T002M15_A1EmpCod[0] == A1EmpCod ) && ( T002M15_A3CliCod[0] == A3CliCod ) && ( T002M15_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M15_A6LegNumero[0] > A6LegNumero ) || ( T002M15_A6LegNumero[0] == A6LegNumero ) && ( T002M15_A1EmpCod[0] == A1EmpCod ) && ( T002M15_A3CliCod[0] == A3CliCod ) && ( T002M15_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M15_A1097LiqAltaNro[0] > A1097LiqAltaNro ) || ( T002M15_A1097LiqAltaNro[0] == A1097LiqAltaNro ) && ( T002M15_A6LegNumero[0] == A6LegNumero ) && ( T002M15_A1EmpCod[0] == A1EmpCod ) && ( T002M15_A3CliCod[0] == A3CliCod ) && ( T002M15_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M15_A1098LiqNuevaNro[0] > A1098LiqNuevaNro ) || ( T002M15_A1098LiqNuevaNro[0] == A1098LiqNuevaNro ) && ( T002M15_A1097LiqAltaNro[0] == A1097LiqAltaNro ) && ( T002M15_A6LegNumero[0] == A6LegNumero ) && ( T002M15_A1EmpCod[0] == A1EmpCod ) && ( T002M15_A3CliCod[0] == A3CliCod ) && ( T002M15_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( GXutil.strcmp(T002M15_A26ConCodigo[0], A26ConCodigo) > 0 ) ) )
         {
            pr_default.readNext(13);
         }
         if ( (pr_default.getStatus(13) != 101) && ( ( T002M15_A869LiqLegConAnio[0] < A869LiqLegConAnio ) || ( T002M15_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M15_A3CliCod[0] < A3CliCod ) || ( T002M15_A3CliCod[0] == A3CliCod ) && ( T002M15_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M15_A1EmpCod[0] < A1EmpCod ) || ( T002M15_A1EmpCod[0] == A1EmpCod ) && ( T002M15_A3CliCod[0] == A3CliCod ) && ( T002M15_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M15_A6LegNumero[0] < A6LegNumero ) || ( T002M15_A6LegNumero[0] == A6LegNumero ) && ( T002M15_A1EmpCod[0] == A1EmpCod ) && ( T002M15_A3CliCod[0] == A3CliCod ) && ( T002M15_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M15_A1097LiqAltaNro[0] < A1097LiqAltaNro ) || ( T002M15_A1097LiqAltaNro[0] == A1097LiqAltaNro ) && ( T002M15_A6LegNumero[0] == A6LegNumero ) && ( T002M15_A1EmpCod[0] == A1EmpCod ) && ( T002M15_A3CliCod[0] == A3CliCod ) && ( T002M15_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( T002M15_A1098LiqNuevaNro[0] < A1098LiqNuevaNro ) || ( T002M15_A1098LiqNuevaNro[0] == A1098LiqNuevaNro ) && ( T002M15_A1097LiqAltaNro[0] == A1097LiqAltaNro ) && ( T002M15_A6LegNumero[0] == A6LegNumero ) && ( T002M15_A1EmpCod[0] == A1EmpCod ) && ( T002M15_A3CliCod[0] == A3CliCod ) && ( T002M15_A869LiqLegConAnio[0] == A869LiqLegConAnio ) && ( GXutil.strcmp(T002M15_A26ConCodigo[0], A26ConCodigo) < 0 ) ) )
         {
            A869LiqLegConAnio = T002M15_A869LiqLegConAnio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A869LiqLegConAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A869LiqLegConAnio), 4, 0));
            A3CliCod = T002M15_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002M15_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T002M15_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A1097LiqAltaNro = T002M15_A1097LiqAltaNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1097LiqAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1097LiqAltaNro), 8, 0));
            A1098LiqNuevaNro = T002M15_A1098LiqNuevaNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1098LiqNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1098LiqNuevaNro), 8, 0));
            A26ConCodigo = T002M15_A26ConCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
            RcdFound122 = (short)(1) ;
         }
      }
      pr_default.close(13);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2M122( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert2M122( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound122 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A869LiqLegConAnio != Z869LiqLegConAnio ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) || ( A1097LiqAltaNro != Z1097LiqAltaNro ) || ( A1098LiqNuevaNro != Z1098LiqNuevaNro ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A869LiqLegConAnio = Z869LiqLegConAnio ;
               httpContext.ajax_rsp_assign_attri("", false, "A869LiqLegConAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A869LiqLegConAnio), 4, 0));
               A6LegNumero = Z6LegNumero ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A26ConCodigo = Z26ConCodigo ;
               httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
               A1097LiqAltaNro = Z1097LiqAltaNro ;
               httpContext.ajax_rsp_assign_attri("", false, "A1097LiqAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1097LiqAltaNro), 8, 0));
               A1098LiqNuevaNro = Z1098LiqNuevaNro ;
               httpContext.ajax_rsp_assign_attri("", false, "A1098LiqNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1098LiqNuevaNro), 8, 0));
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
               update2M122( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A869LiqLegConAnio != Z869LiqLegConAnio ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) || ( A1097LiqAltaNro != Z1097LiqAltaNro ) || ( A1098LiqNuevaNro != Z1098LiqNuevaNro ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert2M122( ) ;
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
                  insert2M122( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A869LiqLegConAnio != Z869LiqLegConAnio ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) || ( A1097LiqAltaNro != Z1097LiqAltaNro ) || ( A1098LiqNuevaNro != Z1098LiqNuevaNro ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A869LiqLegConAnio = Z869LiqLegConAnio ;
         httpContext.ajax_rsp_assign_attri("", false, "A869LiqLegConAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A869LiqLegConAnio), 4, 0));
         A6LegNumero = Z6LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A26ConCodigo = Z26ConCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         A1097LiqAltaNro = Z1097LiqAltaNro ;
         httpContext.ajax_rsp_assign_attri("", false, "A1097LiqAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1097LiqAltaNro), 8, 0));
         A1098LiqNuevaNro = Z1098LiqNuevaNro ;
         httpContext.ajax_rsp_assign_attri("", false, "A1098LiqNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1098LiqNuevaNro), 8, 0));
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
      if ( RcdFound122 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtLiqLegConSaldo_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart2M122( ) ;
      if ( RcdFound122 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtLiqLegConSaldo_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd2M122( ) ;
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
      if ( RcdFound122 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtLiqLegConSaldo_Internalname ;
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
      if ( RcdFound122 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtLiqLegConSaldo_Internalname ;
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
      scanStart2M122( ) ;
      if ( RcdFound122 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound122 != 0 )
         {
            scanNext2M122( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtLiqLegConSaldo_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd2M122( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency2M122( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002M2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A6LegNumero), A26ConCodigo, Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A1098LiqNuevaNro)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LiqLegConceptoCuenta"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z868LiqLegConSaldo, T002M2_A868LiqLegConSaldo[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z886LiqLegConPer), GXutil.resetTime(T002M2_A886LiqLegConPer[0])) ) || ( Z889LiqLegPrimera != T002M2_A889LiqLegPrimera[0] ) || ( GXutil.strcmp(Z1094LiqLegLog, T002M2_A1094LiqLegLog[0]) != 0 ) || ( DecimalUtil.compareTo(Z1099LiqLegCuota, T002M2_A1099LiqLegCuota[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1147LiqLegTotal, T002M2_A1147LiqLegTotal[0]) != 0 ) || ( DecimalUtil.compareTo(Z1148LiqLegTotRecal, T002M2_A1148LiqLegTotRecal[0]) != 0 ) || ( Z1778LiqLegEsPrrGan != T002M2_A1778LiqLegEsPrrGan[0] ) || ( Z888LiqLegCodigo != T002M2_A888LiqLegCodigo[0] ) )
         {
            if ( DecimalUtil.compareTo(Z868LiqLegConSaldo, T002M2_A868LiqLegConSaldo[0]) != 0 )
            {
               GXutil.writeLogln("liqlegconceptocuenta:[seudo value changed for attri]"+"LiqLegConSaldo");
               GXutil.writeLogRaw("Old: ",Z868LiqLegConSaldo);
               GXutil.writeLogRaw("Current: ",T002M2_A868LiqLegConSaldo[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z886LiqLegConPer), GXutil.resetTime(T002M2_A886LiqLegConPer[0])) ) )
            {
               GXutil.writeLogln("liqlegconceptocuenta:[seudo value changed for attri]"+"LiqLegConPer");
               GXutil.writeLogRaw("Old: ",Z886LiqLegConPer);
               GXutil.writeLogRaw("Current: ",T002M2_A886LiqLegConPer[0]);
            }
            if ( Z889LiqLegPrimera != T002M2_A889LiqLegPrimera[0] )
            {
               GXutil.writeLogln("liqlegconceptocuenta:[seudo value changed for attri]"+"LiqLegPrimera");
               GXutil.writeLogRaw("Old: ",Z889LiqLegPrimera);
               GXutil.writeLogRaw("Current: ",T002M2_A889LiqLegPrimera[0]);
            }
            if ( GXutil.strcmp(Z1094LiqLegLog, T002M2_A1094LiqLegLog[0]) != 0 )
            {
               GXutil.writeLogln("liqlegconceptocuenta:[seudo value changed for attri]"+"LiqLegLog");
               GXutil.writeLogRaw("Old: ",Z1094LiqLegLog);
               GXutil.writeLogRaw("Current: ",T002M2_A1094LiqLegLog[0]);
            }
            if ( DecimalUtil.compareTo(Z1099LiqLegCuota, T002M2_A1099LiqLegCuota[0]) != 0 )
            {
               GXutil.writeLogln("liqlegconceptocuenta:[seudo value changed for attri]"+"LiqLegCuota");
               GXutil.writeLogRaw("Old: ",Z1099LiqLegCuota);
               GXutil.writeLogRaw("Current: ",T002M2_A1099LiqLegCuota[0]);
            }
            if ( DecimalUtil.compareTo(Z1147LiqLegTotal, T002M2_A1147LiqLegTotal[0]) != 0 )
            {
               GXutil.writeLogln("liqlegconceptocuenta:[seudo value changed for attri]"+"LiqLegTotal");
               GXutil.writeLogRaw("Old: ",Z1147LiqLegTotal);
               GXutil.writeLogRaw("Current: ",T002M2_A1147LiqLegTotal[0]);
            }
            if ( DecimalUtil.compareTo(Z1148LiqLegTotRecal, T002M2_A1148LiqLegTotRecal[0]) != 0 )
            {
               GXutil.writeLogln("liqlegconceptocuenta:[seudo value changed for attri]"+"LiqLegTotRecal");
               GXutil.writeLogRaw("Old: ",Z1148LiqLegTotRecal);
               GXutil.writeLogRaw("Current: ",T002M2_A1148LiqLegTotRecal[0]);
            }
            if ( Z1778LiqLegEsPrrGan != T002M2_A1778LiqLegEsPrrGan[0] )
            {
               GXutil.writeLogln("liqlegconceptocuenta:[seudo value changed for attri]"+"LiqLegEsPrrGan");
               GXutil.writeLogRaw("Old: ",Z1778LiqLegEsPrrGan);
               GXutil.writeLogRaw("Current: ",T002M2_A1778LiqLegEsPrrGan[0]);
            }
            if ( Z888LiqLegCodigo != T002M2_A888LiqLegCodigo[0] )
            {
               GXutil.writeLogln("liqlegconceptocuenta:[seudo value changed for attri]"+"LiqLegCodigo");
               GXutil.writeLogRaw("Old: ",Z888LiqLegCodigo);
               GXutil.writeLogRaw("Current: ",T002M2_A888LiqLegCodigo[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LiqLegConceptoCuenta"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2M122( )
   {
      beforeValidate2M122( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2M122( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2M122( 0) ;
         checkOptimisticConcurrency2M122( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2M122( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2M122( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002M16 */
                  pr_default.execute(14, new Object[] {Short.valueOf(A869LiqLegConAnio), A868LiqLegConSaldo, Boolean.valueOf(n886LiqLegConPer), A886LiqLegConPer, Boolean.valueOf(A889LiqLegPrimera), A1094LiqLegLog, A1099LiqLegCuota, A1147LiqLegTotal, A1148LiqLegTotRecal, Boolean.valueOf(A1778LiqLegEsPrrGan), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A1098LiqNuevaNro), A26ConCodigo, Boolean.valueOf(n888LiqLegCodigo), Short.valueOf(A888LiqLegCodigo)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegConceptoCuenta");
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
                        resetCaption2M0( ) ;
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
            load2M122( ) ;
         }
         endLevel2M122( ) ;
      }
      closeExtendedTableCursors2M122( ) ;
   }

   public void update2M122( )
   {
      beforeValidate2M122( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2M122( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2M122( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2M122( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2M122( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002M17 */
                  pr_default.execute(15, new Object[] {A868LiqLegConSaldo, Boolean.valueOf(n886LiqLegConPer), A886LiqLegConPer, Boolean.valueOf(A889LiqLegPrimera), A1094LiqLegLog, A1099LiqLegCuota, A1147LiqLegTotal, A1148LiqLegTotRecal, Boolean.valueOf(A1778LiqLegEsPrrGan), Boolean.valueOf(n888LiqLegCodigo), Short.valueOf(A888LiqLegCodigo), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A6LegNumero), A26ConCodigo, Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A1098LiqNuevaNro)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegConceptoCuenta");
                  if ( (pr_default.getStatus(15) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LiqLegConceptoCuenta"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2M122( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption2M0( ) ;
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
         endLevel2M122( ) ;
      }
      closeExtendedTableCursors2M122( ) ;
   }

   public void deferredUpdate2M122( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate2M122( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2M122( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2M122( ) ;
         afterConfirm2M122( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2M122( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002M18 */
               pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A6LegNumero), A26ConCodigo, Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A1098LiqNuevaNro)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegConceptoCuenta");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound122 == 0 )
                     {
                        initAll2M122( ) ;
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
                     resetCaption2M0( ) ;
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
      sMode122 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2M122( ) ;
      Gx_mode = sMode122 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2M122( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T002M19 */
         pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         A42ConCodYDesc = T002M19_A42ConCodYDesc[0] ;
         n42ConCodYDesc = T002M19_n42ConCodYDesc[0] ;
         A41ConDescrip = T002M19_A41ConDescrip[0] ;
         A41ConDescrip = T002M19_A41ConDescrip[0] ;
         pr_default.close(17);
      }
   }

   public void endLevel2M122( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2M122( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "liqlegconceptocuenta");
         if ( AnyError == 0 )
         {
            confirmValues2M0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "liqlegconceptocuenta");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2M122( )
   {
      /* Using cursor T002M20 */
      pr_default.execute(18);
      RcdFound122 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound122 = (short)(1) ;
         A3CliCod = T002M20_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002M20_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A869LiqLegConAnio = T002M20_A869LiqLegConAnio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A869LiqLegConAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A869LiqLegConAnio), 4, 0));
         A6LegNumero = T002M20_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A26ConCodigo = T002M20_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         A1097LiqAltaNro = T002M20_A1097LiqAltaNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1097LiqAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1097LiqAltaNro), 8, 0));
         A1098LiqNuevaNro = T002M20_A1098LiqNuevaNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1098LiqNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1098LiqNuevaNro), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2M122( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound122 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound122 = (short)(1) ;
         A3CliCod = T002M20_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002M20_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A869LiqLegConAnio = T002M20_A869LiqLegConAnio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A869LiqLegConAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A869LiqLegConAnio), 4, 0));
         A6LegNumero = T002M20_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A26ConCodigo = T002M20_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         A1097LiqAltaNro = T002M20_A1097LiqAltaNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1097LiqAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1097LiqAltaNro), 8, 0));
         A1098LiqNuevaNro = T002M20_A1098LiqNuevaNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1098LiqNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1098LiqNuevaNro), 8, 0));
      }
   }

   public void scanEnd2M122( )
   {
      pr_default.close(18);
   }

   public void afterConfirm2M122( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2M122( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2M122( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2M122( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2M122( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2M122( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2M122( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtLiqLegConAnio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqLegConAnio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegConAnio_Enabled), 5, 0), true);
      edtLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      edtConCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      edtLiqAltaNro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqAltaNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqAltaNro_Enabled), 5, 0), true);
      edtLiqNuevaNro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqNuevaNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqNuevaNro_Enabled), 5, 0), true);
      edtLiqLegConSaldo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqLegConSaldo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegConSaldo_Enabled), 5, 0), true);
      edtLiqLegConPer_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqLegConPer_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegConPer_Enabled), 5, 0), true);
      edtLiqLegCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqLegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegCodigo_Enabled), 5, 0), true);
      chkLiqLegPrimera.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkLiqLegPrimera.getInternalname(), "Enabled", GXutil.ltrimstr( chkLiqLegPrimera.getEnabled(), 5, 0), true);
      edtLiqLegLog_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqLegLog_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegLog_Enabled), 5, 0), true);
      edtLiqLegCuota_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqLegCuota_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegCuota_Enabled), 5, 0), true);
      edtLiqLegTotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqLegTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegTotal_Enabled), 5, 0), true);
      edtLiqLegTotRecal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqLegTotRecal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegTotRecal_Enabled), 5, 0), true);
      chkLiqLegEsPrrGan.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkLiqLegEsPrrGan.getInternalname(), "Enabled", GXutil.ltrimstr( chkLiqLegEsPrrGan.getEnabled(), 5, 0), true);
   }

   public void send_integrity_lvl_hashes2M122( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues2M0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.liqlegconceptocuenta", new String[] {}, new String[] {}) +"\">") ;
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
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z869LiqLegConAnio", GXutil.ltrim( localUtil.ntoc( Z869LiqLegConAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z26ConCodigo", GXutil.rtrim( Z26ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1097LiqAltaNro", GXutil.ltrim( localUtil.ntoc( Z1097LiqAltaNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1098LiqNuevaNro", GXutil.ltrim( localUtil.ntoc( Z1098LiqNuevaNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z868LiqLegConSaldo", GXutil.ltrim( localUtil.ntoc( Z868LiqLegConSaldo, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z886LiqLegConPer", localUtil.dtoc( Z886LiqLegConPer, 0, "/"));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z889LiqLegPrimera", Z889LiqLegPrimera);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1094LiqLegLog", Z1094LiqLegLog);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1099LiqLegCuota", GXutil.ltrim( localUtil.ntoc( Z1099LiqLegCuota, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1147LiqLegTotal", GXutil.ltrim( localUtil.ntoc( Z1147LiqLegTotal, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1148LiqLegTotRecal", GXutil.ltrim( localUtil.ntoc( Z1148LiqLegTotRecal, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1778LiqLegEsPrrGan", Z1778LiqLegEsPrrGan);
      web.GxWebStd.gx_hidden_field( httpContext, "Z888LiqLegCodigo", GXutil.ltrim( localUtil.ntoc( Z888LiqLegCodigo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "CONCODYDESC", A42ConCodYDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "CONDESCRIP", A41ConDescrip);
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
      return formatLink("web.liqlegconceptocuenta", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "LiqLegConceptoCuenta" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Liq Leg Concepto Cuenta", "") ;
   }

   public void initializeNonKey2M122( )
   {
      A31LiqNro = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
      A42ConCodYDesc = "" ;
      n42ConCodYDesc = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A42ConCodYDesc", A42ConCodYDesc);
      A868LiqLegConSaldo = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A868LiqLegConSaldo", GXutil.ltrimstr( A868LiqLegConSaldo, 14, 2));
      A886LiqLegConPer = GXutil.nullDate() ;
      n886LiqLegConPer = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A886LiqLegConPer", localUtil.format(A886LiqLegConPer, "99/99/9999"));
      n886LiqLegConPer = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A886LiqLegConPer)) ? true : false) ;
      A888LiqLegCodigo = (short)(0) ;
      n888LiqLegCodigo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A888LiqLegCodigo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A888LiqLegCodigo), 4, 0));
      n888LiqLegCodigo = ((0==A888LiqLegCodigo) ? true : false) ;
      A889LiqLegPrimera = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A889LiqLegPrimera", A889LiqLegPrimera);
      A1094LiqLegLog = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1094LiqLegLog", A1094LiqLegLog);
      A1099LiqLegCuota = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1099LiqLegCuota", GXutil.ltrimstr( A1099LiqLegCuota, 14, 2));
      A1147LiqLegTotal = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1147LiqLegTotal", GXutil.ltrimstr( A1147LiqLegTotal, 14, 2));
      A1148LiqLegTotRecal = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1148LiqLegTotRecal", GXutil.ltrimstr( A1148LiqLegTotRecal, 14, 2));
      A1778LiqLegEsPrrGan = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1778LiqLegEsPrrGan", A1778LiqLegEsPrrGan);
      A41ConDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
      Z868LiqLegConSaldo = DecimalUtil.ZERO ;
      Z886LiqLegConPer = GXutil.nullDate() ;
      Z889LiqLegPrimera = false ;
      Z1094LiqLegLog = "" ;
      Z1099LiqLegCuota = DecimalUtil.ZERO ;
      Z1147LiqLegTotal = DecimalUtil.ZERO ;
      Z1148LiqLegTotRecal = DecimalUtil.ZERO ;
      Z1778LiqLegEsPrrGan = false ;
      Z888LiqLegCodigo = (short)(0) ;
   }

   public void initAll2M122( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A869LiqLegConAnio = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A869LiqLegConAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A869LiqLegConAnio), 4, 0));
      A6LegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      A26ConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      A1097LiqAltaNro = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1097LiqAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1097LiqAltaNro), 8, 0));
      A1098LiqNuevaNro = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1098LiqNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1098LiqNuevaNro), 8, 0));
      initializeNonKey2M122( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025181753788", true, true);
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
      httpContext.AddJavascriptSource("liqlegconceptocuenta.js", "?2025181753788", false, true);
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
      edtLiqLegConAnio_Internalname = "LIQLEGCONANIO" ;
      edtLegNumero_Internalname = "LEGNUMERO" ;
      edtConCodigo_Internalname = "CONCODIGO" ;
      edtLiqAltaNro_Internalname = "LIQALTANRO" ;
      edtLiqNuevaNro_Internalname = "LIQNUEVANRO" ;
      edtLiqLegConSaldo_Internalname = "LIQLEGCONSALDO" ;
      edtLiqLegConPer_Internalname = "LIQLEGCONPER" ;
      edtLiqLegCodigo_Internalname = "LIQLEGCODIGO" ;
      chkLiqLegPrimera.setInternalname( "LIQLEGPRIMERA" );
      edtLiqLegLog_Internalname = "LIQLEGLOG" ;
      edtLiqLegCuota_Internalname = "LIQLEGCUOTA" ;
      edtLiqLegTotal_Internalname = "LIQLEGTOTAL" ;
      edtLiqLegTotRecal_Internalname = "LIQLEGTOTRECAL" ;
      chkLiqLegEsPrrGan.setInternalname( "LIQLEGESPRRGAN" );
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
      Form.setCaption( httpContext.getMessage( "Liq Leg Concepto Cuenta", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      chkLiqLegEsPrrGan.setEnabled( 1 );
      edtLiqLegTotRecal_Jsonclick = "" ;
      edtLiqLegTotRecal_Enabled = 1 ;
      edtLiqLegTotal_Jsonclick = "" ;
      edtLiqLegTotal_Enabled = 1 ;
      edtLiqLegCuota_Jsonclick = "" ;
      edtLiqLegCuota_Enabled = 1 ;
      edtLiqLegLog_Enabled = 1 ;
      chkLiqLegPrimera.setEnabled( 1 );
      edtLiqLegCodigo_Jsonclick = "" ;
      edtLiqLegCodigo_Enabled = 1 ;
      edtLiqLegConPer_Jsonclick = "" ;
      edtLiqLegConPer_Enabled = 1 ;
      edtLiqLegConSaldo_Jsonclick = "" ;
      edtLiqLegConSaldo_Enabled = 1 ;
      edtLiqNuevaNro_Jsonclick = "" ;
      edtLiqNuevaNro_Enabled = 1 ;
      edtLiqAltaNro_Jsonclick = "" ;
      edtLiqAltaNro_Enabled = 1 ;
      edtConCodigo_Jsonclick = "" ;
      edtConCodigo_Enabled = 1 ;
      edtLegNumero_Jsonclick = "" ;
      edtLegNumero_Enabled = 1 ;
      edtLiqLegConAnio_Jsonclick = "" ;
      edtLiqLegConAnio_Enabled = 1 ;
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
      chkLiqLegPrimera.setName( "LIQLEGPRIMERA" );
      chkLiqLegPrimera.setWebtags( "" );
      chkLiqLegPrimera.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkLiqLegPrimera.getInternalname(), "TitleCaption", chkLiqLegPrimera.getCaption(), true);
      chkLiqLegPrimera.setCheckedValue( "false" );
      A889LiqLegPrimera = GXutil.strtobool( GXutil.booltostr( A889LiqLegPrimera)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A889LiqLegPrimera", A889LiqLegPrimera);
      chkLiqLegEsPrrGan.setName( "LIQLEGESPRRGAN" );
      chkLiqLegEsPrrGan.setWebtags( "" );
      chkLiqLegEsPrrGan.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkLiqLegEsPrrGan.getInternalname(), "TitleCaption", chkLiqLegEsPrrGan.getCaption(), true);
      chkLiqLegEsPrrGan.setCheckedValue( "false" );
      A1778LiqLegEsPrrGan = GXutil.strtobool( GXutil.booltostr( A1778LiqLegEsPrrGan)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1778LiqLegEsPrrGan", A1778LiqLegEsPrrGan);
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      /* Using cursor T002M19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A42ConCodYDesc = T002M19_A42ConCodYDesc[0] ;
      n42ConCodYDesc = T002M19_n42ConCodYDesc[0] ;
      A41ConDescrip = T002M19_A41ConDescrip[0] ;
      A41ConDescrip = T002M19_A41ConDescrip[0] ;
      pr_default.close(17);
      /* Using cursor T002M21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(19);
      /* Using cursor T002M22 */
      pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1098LiqNuevaNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(20) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(20);
      GX_FocusControl = edtLiqLegConSaldo_Internalname ;
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

   public void valid_Concodigo( )
   {
      n42ConCodYDesc = false ;
      /* Using cursor T002M19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A42ConCodYDesc = T002M19_A42ConCodYDesc[0] ;
      n42ConCodYDesc = T002M19_n42ConCodYDesc[0] ;
      A41ConDescrip = T002M19_A41ConDescrip[0] ;
      A41ConDescrip = T002M19_A41ConDescrip[0] ;
      pr_default.close(17);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A42ConCodYDesc", A42ConCodYDesc);
      httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
   }

   public void valid_Liqaltanro( )
   {
      /* Using cursor T002M21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(19);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Liqnuevanro( )
   {
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      /* Using cursor T002M22 */
      pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1098LiqNuevaNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(20) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(20);
      dynload_actions( ) ;
      A889LiqLegPrimera = GXutil.strtobool( GXutil.booltostr( A889LiqLegPrimera)) ;
      A1778LiqLegEsPrrGan = GXutil.strtobool( GXutil.booltostr( A1778LiqLegEsPrrGan)) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A868LiqLegConSaldo", GXutil.ltrim( localUtil.ntoc( A868LiqLegConSaldo, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A886LiqLegConPer", localUtil.format(A886LiqLegConPer, "99/99/9999"));
      httpContext.ajax_rsp_assign_attri("", false, "A888LiqLegCodigo", GXutil.ltrim( localUtil.ntoc( A888LiqLegCodigo, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A889LiqLegPrimera", A889LiqLegPrimera);
      httpContext.ajax_rsp_assign_attri("", false, "A1094LiqLegLog", A1094LiqLegLog);
      httpContext.ajax_rsp_assign_attri("", false, "A1099LiqLegCuota", GXutil.ltrim( localUtil.ntoc( A1099LiqLegCuota, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1147LiqLegTotal", GXutil.ltrim( localUtil.ntoc( A1147LiqLegTotal, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1148LiqLegTotRecal", GXutil.ltrim( localUtil.ntoc( A1148LiqLegTotRecal, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1778LiqLegEsPrrGan", A1778LiqLegEsPrrGan);
      httpContext.ajax_rsp_assign_attri("", false, "A42ConCodYDesc", A42ConCodYDesc);
      httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z869LiqLegConAnio", GXutil.ltrim( localUtil.ntoc( Z869LiqLegConAnio, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z26ConCodigo", GXutil.rtrim( Z26ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1097LiqAltaNro", GXutil.ltrim( localUtil.ntoc( Z1097LiqAltaNro, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1098LiqNuevaNro", GXutil.ltrim( localUtil.ntoc( Z1098LiqNuevaNro, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z31LiqNro", GXutil.ltrim( localUtil.ntoc( Z31LiqNro, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z868LiqLegConSaldo", GXutil.ltrim( localUtil.ntoc( Z868LiqLegConSaldo, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z886LiqLegConPer", localUtil.format(Z886LiqLegConPer, "99/99/9999"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z888LiqLegCodigo", GXutil.ltrim( localUtil.ntoc( Z888LiqLegCodigo, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z889LiqLegPrimera", GXutil.booltostr( Z889LiqLegPrimera));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1094LiqLegLog", Z1094LiqLegLog);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1099LiqLegCuota", GXutil.ltrim( localUtil.ntoc( Z1099LiqLegCuota, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1147LiqLegTotal", GXutil.ltrim( localUtil.ntoc( Z1147LiqLegTotal, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1148LiqLegTotRecal", GXutil.ltrim( localUtil.ntoc( Z1148LiqLegTotRecal, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1778LiqLegEsPrrGan", GXutil.booltostr( Z1778LiqLegEsPrrGan));
      web.GxWebStd.gx_hidden_field( httpContext, "Z42ConCodYDesc", Z42ConCodYDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z41ConDescrip", Z41ConDescrip);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Liqlegcodigo( )
   {
      n888LiqLegCodigo = false ;
      /* Using cursor T002M23 */
      pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n888LiqLegCodigo), Short.valueOf(A888LiqLegCodigo)});
      if ( (pr_default.getStatus(21) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A888LiqLegCodigo) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cuenta Prorra Apl IIGGGroup", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQLEGCODIGO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      pr_default.close(21);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]}");
      setEventMetadata("VALID_LIQLEGCONANIO","{handler:'valid_Liqlegconanio',iparms:[{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]");
      setEventMetadata("VALID_LIQLEGCONANIO",",oparms:[{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]}");
      setEventMetadata("VALID_CONCODIGO","{handler:'valid_Concodigo',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''},{av:'A42ConCodYDesc',fld:'CONCODYDESC',pic:''},{av:'A41ConDescrip',fld:'CONDESCRIP',pic:''},{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]");
      setEventMetadata("VALID_CONCODIGO",",oparms:[{av:'A42ConCodYDesc',fld:'CONCODYDESC',pic:''},{av:'A41ConDescrip',fld:'CONDESCRIP',pic:''},{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]}");
      setEventMetadata("VALID_LIQALTANRO","{handler:'valid_Liqaltanro',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1097LiqAltaNro',fld:'LIQALTANRO',pic:'ZZZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]");
      setEventMetadata("VALID_LIQALTANRO",",oparms:[{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]}");
      setEventMetadata("VALID_LIQNUEVANRO","{handler:'valid_Liqnuevanro',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A869LiqLegConAnio',fld:'LIQLEGCONANIO',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''},{av:'A1097LiqAltaNro',fld:'LIQALTANRO',pic:'ZZZZZZZ9'},{av:'A1098LiqNuevaNro',fld:'LIQNUEVANRO',pic:'ZZZZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]");
      setEventMetadata("VALID_LIQNUEVANRO",",oparms:[{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'A868LiqLegConSaldo',fld:'LIQLEGCONSALDO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A886LiqLegConPer',fld:'LIQLEGCONPER',pic:''},{av:'A888LiqLegCodigo',fld:'LIQLEGCODIGO',pic:'ZZZ9'},{av:'A1094LiqLegLog',fld:'LIQLEGLOG',pic:''},{av:'A1099LiqLegCuota',fld:'LIQLEGCUOTA',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1147LiqLegTotal',fld:'LIQLEGTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1148LiqLegTotRecal',fld:'LIQLEGTOTRECAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A42ConCodYDesc',fld:'CONCODYDESC',pic:''},{av:'A41ConDescrip',fld:'CONDESCRIP',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z3CliCod'},{av:'Z1EmpCod'},{av:'Z869LiqLegConAnio'},{av:'Z6LegNumero'},{av:'Z26ConCodigo'},{av:'Z1097LiqAltaNro'},{av:'Z1098LiqNuevaNro'},{av:'Z31LiqNro'},{av:'Z868LiqLegConSaldo'},{av:'Z886LiqLegConPer'},{av:'Z888LiqLegCodigo'},{av:'Z889LiqLegPrimera'},{av:'Z1094LiqLegLog'},{av:'Z1099LiqLegCuota'},{av:'Z1147LiqLegTotal'},{av:'Z1148LiqLegTotRecal'},{av:'Z1778LiqLegEsPrrGan'},{av:'Z42ConCodYDesc'},{av:'Z41ConDescrip'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'},{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]}");
      setEventMetadata("VALID_LIQLEGCODIGO","{handler:'valid_Liqlegcodigo',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A888LiqLegCodigo',fld:'LIQLEGCODIGO',pic:'ZZZ9'},{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]");
      setEventMetadata("VALID_LIQLEGCODIGO",",oparms:[{av:'A889LiqLegPrimera',fld:'LIQLEGPRIMERA',pic:''},{av:'A1778LiqLegEsPrrGan',fld:'LIQLEGESPRRGAN',pic:''}]}");
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
      pr_default.close(20);
      pr_default.close(19);
      pr_default.close(17);
      pr_default.close(21);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z26ConCodigo = "" ;
      Z868LiqLegConSaldo = DecimalUtil.ZERO ;
      Z886LiqLegConPer = GXutil.nullDate() ;
      Z1094LiqLegLog = "" ;
      Z1099LiqLegCuota = DecimalUtil.ZERO ;
      Z1147LiqLegTotal = DecimalUtil.ZERO ;
      Z1148LiqLegTotRecal = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A26ConCodigo = "" ;
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
      A868LiqLegConSaldo = DecimalUtil.ZERO ;
      A886LiqLegConPer = GXutil.nullDate() ;
      A1094LiqLegLog = "" ;
      A1099LiqLegCuota = DecimalUtil.ZERO ;
      A1147LiqLegTotal = DecimalUtil.ZERO ;
      A1148LiqLegTotRecal = DecimalUtil.ZERO ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gx_mode = "" ;
      A42ConCodYDesc = "" ;
      A41ConDescrip = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z42ConCodYDesc = "" ;
      Z41ConDescrip = "" ;
      T002M8_A42ConCodYDesc = new String[] {""} ;
      T002M8_n42ConCodYDesc = new boolean[] {false} ;
      T002M8_A869LiqLegConAnio = new short[1] ;
      T002M8_A868LiqLegConSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002M8_A886LiqLegConPer = new java.util.Date[] {GXutil.nullDate()} ;
      T002M8_n886LiqLegConPer = new boolean[] {false} ;
      T002M8_A889LiqLegPrimera = new boolean[] {false} ;
      T002M8_A1094LiqLegLog = new String[] {""} ;
      T002M8_A1099LiqLegCuota = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002M8_A1147LiqLegTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002M8_A1148LiqLegTotRecal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002M8_A1778LiqLegEsPrrGan = new boolean[] {false} ;
      T002M8_A41ConDescrip = new String[] {""} ;
      T002M8_A3CliCod = new int[1] ;
      T002M8_A1EmpCod = new short[1] ;
      T002M8_A6LegNumero = new int[1] ;
      T002M8_A1097LiqAltaNro = new int[1] ;
      T002M8_A1098LiqNuevaNro = new int[1] ;
      T002M8_A26ConCodigo = new String[] {""} ;
      T002M8_A888LiqLegCodigo = new short[1] ;
      T002M8_n888LiqLegCodigo = new boolean[] {false} ;
      T002M7_A3CliCod = new int[1] ;
      T002M6_A42ConCodYDesc = new String[] {""} ;
      T002M6_n42ConCodYDesc = new boolean[] {false} ;
      T002M6_A41ConDescrip = new String[] {""} ;
      T002M4_A31LiqNro = new int[1] ;
      T002M5_A31LiqNro = new int[1] ;
      T002M9_A3CliCod = new int[1] ;
      T002M10_A42ConCodYDesc = new String[] {""} ;
      T002M10_n42ConCodYDesc = new boolean[] {false} ;
      T002M10_A41ConDescrip = new String[] {""} ;
      T002M11_A31LiqNro = new int[1] ;
      T002M12_A31LiqNro = new int[1] ;
      T002M13_A3CliCod = new int[1] ;
      T002M13_A1EmpCod = new short[1] ;
      T002M13_A869LiqLegConAnio = new short[1] ;
      T002M13_A6LegNumero = new int[1] ;
      T002M13_A26ConCodigo = new String[] {""} ;
      T002M13_A1097LiqAltaNro = new int[1] ;
      T002M13_A1098LiqNuevaNro = new int[1] ;
      T002M3_A869LiqLegConAnio = new short[1] ;
      T002M3_A868LiqLegConSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002M3_A886LiqLegConPer = new java.util.Date[] {GXutil.nullDate()} ;
      T002M3_n886LiqLegConPer = new boolean[] {false} ;
      T002M3_A889LiqLegPrimera = new boolean[] {false} ;
      T002M3_A1094LiqLegLog = new String[] {""} ;
      T002M3_A1099LiqLegCuota = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002M3_A1147LiqLegTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002M3_A1148LiqLegTotRecal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002M3_A1778LiqLegEsPrrGan = new boolean[] {false} ;
      T002M3_A3CliCod = new int[1] ;
      T002M3_A1EmpCod = new short[1] ;
      T002M3_A6LegNumero = new int[1] ;
      T002M3_A1097LiqAltaNro = new int[1] ;
      T002M3_A1098LiqNuevaNro = new int[1] ;
      T002M3_A26ConCodigo = new String[] {""} ;
      T002M3_A888LiqLegCodigo = new short[1] ;
      T002M3_n888LiqLegCodigo = new boolean[] {false} ;
      sMode122 = "" ;
      T002M14_A869LiqLegConAnio = new short[1] ;
      T002M14_A3CliCod = new int[1] ;
      T002M14_A1EmpCod = new short[1] ;
      T002M14_A6LegNumero = new int[1] ;
      T002M14_A1097LiqAltaNro = new int[1] ;
      T002M14_A1098LiqNuevaNro = new int[1] ;
      T002M14_A26ConCodigo = new String[] {""} ;
      T002M15_A869LiqLegConAnio = new short[1] ;
      T002M15_A3CliCod = new int[1] ;
      T002M15_A1EmpCod = new short[1] ;
      T002M15_A6LegNumero = new int[1] ;
      T002M15_A1097LiqAltaNro = new int[1] ;
      T002M15_A1098LiqNuevaNro = new int[1] ;
      T002M15_A26ConCodigo = new String[] {""} ;
      T002M2_A869LiqLegConAnio = new short[1] ;
      T002M2_A868LiqLegConSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002M2_A886LiqLegConPer = new java.util.Date[] {GXutil.nullDate()} ;
      T002M2_n886LiqLegConPer = new boolean[] {false} ;
      T002M2_A889LiqLegPrimera = new boolean[] {false} ;
      T002M2_A1094LiqLegLog = new String[] {""} ;
      T002M2_A1099LiqLegCuota = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002M2_A1147LiqLegTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002M2_A1148LiqLegTotRecal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002M2_A1778LiqLegEsPrrGan = new boolean[] {false} ;
      T002M2_A3CliCod = new int[1] ;
      T002M2_A1EmpCod = new short[1] ;
      T002M2_A6LegNumero = new int[1] ;
      T002M2_A1097LiqAltaNro = new int[1] ;
      T002M2_A1098LiqNuevaNro = new int[1] ;
      T002M2_A26ConCodigo = new String[] {""} ;
      T002M2_A888LiqLegCodigo = new short[1] ;
      T002M2_n888LiqLegCodigo = new boolean[] {false} ;
      T002M19_A42ConCodYDesc = new String[] {""} ;
      T002M19_n42ConCodYDesc = new boolean[] {false} ;
      T002M19_A41ConDescrip = new String[] {""} ;
      T002M20_A3CliCod = new int[1] ;
      T002M20_A1EmpCod = new short[1] ;
      T002M20_A869LiqLegConAnio = new short[1] ;
      T002M20_A6LegNumero = new int[1] ;
      T002M20_A26ConCodigo = new String[] {""} ;
      T002M20_A1097LiqAltaNro = new int[1] ;
      T002M20_A1098LiqNuevaNro = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T002M21_A31LiqNro = new int[1] ;
      T002M22_A31LiqNro = new int[1] ;
      ZZ26ConCodigo = "" ;
      ZZ868LiqLegConSaldo = DecimalUtil.ZERO ;
      ZZ886LiqLegConPer = GXutil.nullDate() ;
      ZZ1094LiqLegLog = "" ;
      ZZ1099LiqLegCuota = DecimalUtil.ZERO ;
      ZZ1147LiqLegTotal = DecimalUtil.ZERO ;
      ZZ1148LiqLegTotRecal = DecimalUtil.ZERO ;
      ZZ42ConCodYDesc = "" ;
      ZZ41ConDescrip = "" ;
      T002M23_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liqlegconceptocuenta__default(),
         new Object[] {
             new Object[] {
            T002M2_A869LiqLegConAnio, T002M2_A868LiqLegConSaldo, T002M2_A886LiqLegConPer, T002M2_n886LiqLegConPer, T002M2_A889LiqLegPrimera, T002M2_A1094LiqLegLog, T002M2_A1099LiqLegCuota, T002M2_A1147LiqLegTotal, T002M2_A1148LiqLegTotRecal, T002M2_A1778LiqLegEsPrrGan,
            T002M2_A3CliCod, T002M2_A1EmpCod, T002M2_A6LegNumero, T002M2_A1097LiqAltaNro, T002M2_A1098LiqNuevaNro, T002M2_A26ConCodigo, T002M2_A888LiqLegCodigo, T002M2_n888LiqLegCodigo
            }
            , new Object[] {
            T002M3_A869LiqLegConAnio, T002M3_A868LiqLegConSaldo, T002M3_A886LiqLegConPer, T002M3_n886LiqLegConPer, T002M3_A889LiqLegPrimera, T002M3_A1094LiqLegLog, T002M3_A1099LiqLegCuota, T002M3_A1147LiqLegTotal, T002M3_A1148LiqLegTotRecal, T002M3_A1778LiqLegEsPrrGan,
            T002M3_A3CliCod, T002M3_A1EmpCod, T002M3_A6LegNumero, T002M3_A1097LiqAltaNro, T002M3_A1098LiqNuevaNro, T002M3_A26ConCodigo, T002M3_A888LiqLegCodigo, T002M3_n888LiqLegCodigo
            }
            , new Object[] {
            T002M4_A31LiqNro
            }
            , new Object[] {
            T002M5_A31LiqNro
            }
            , new Object[] {
            T002M6_A42ConCodYDesc, T002M6_n42ConCodYDesc, T002M6_A41ConDescrip
            }
            , new Object[] {
            T002M7_A3CliCod
            }
            , new Object[] {
            T002M8_A42ConCodYDesc, T002M8_n42ConCodYDesc, T002M8_A869LiqLegConAnio, T002M8_A868LiqLegConSaldo, T002M8_A886LiqLegConPer, T002M8_n886LiqLegConPer, T002M8_A889LiqLegPrimera, T002M8_A1094LiqLegLog, T002M8_A1099LiqLegCuota, T002M8_A1147LiqLegTotal,
            T002M8_A1148LiqLegTotRecal, T002M8_A1778LiqLegEsPrrGan, T002M8_A41ConDescrip, T002M8_A3CliCod, T002M8_A1EmpCod, T002M8_A6LegNumero, T002M8_A1097LiqAltaNro, T002M8_A1098LiqNuevaNro, T002M8_A26ConCodigo, T002M8_A888LiqLegCodigo,
            T002M8_n888LiqLegCodigo
            }
            , new Object[] {
            T002M9_A3CliCod
            }
            , new Object[] {
            T002M10_A42ConCodYDesc, T002M10_n42ConCodYDesc, T002M10_A41ConDescrip
            }
            , new Object[] {
            T002M11_A31LiqNro
            }
            , new Object[] {
            T002M12_A31LiqNro
            }
            , new Object[] {
            T002M13_A3CliCod, T002M13_A1EmpCod, T002M13_A869LiqLegConAnio, T002M13_A6LegNumero, T002M13_A26ConCodigo, T002M13_A1097LiqAltaNro, T002M13_A1098LiqNuevaNro
            }
            , new Object[] {
            T002M14_A869LiqLegConAnio, T002M14_A3CliCod, T002M14_A1EmpCod, T002M14_A6LegNumero, T002M14_A1097LiqAltaNro, T002M14_A1098LiqNuevaNro, T002M14_A26ConCodigo
            }
            , new Object[] {
            T002M15_A869LiqLegConAnio, T002M15_A3CliCod, T002M15_A1EmpCod, T002M15_A6LegNumero, T002M15_A1097LiqAltaNro, T002M15_A1098LiqNuevaNro, T002M15_A26ConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002M19_A42ConCodYDesc, T002M19_n42ConCodYDesc, T002M19_A41ConDescrip
            }
            , new Object[] {
            T002M20_A3CliCod, T002M20_A1EmpCod, T002M20_A869LiqLegConAnio, T002M20_A6LegNumero, T002M20_A26ConCodigo, T002M20_A1097LiqAltaNro, T002M20_A1098LiqNuevaNro
            }
            , new Object[] {
            T002M21_A31LiqNro
            }
            , new Object[] {
            T002M22_A31LiqNro
            }
            , new Object[] {
            T002M23_A3CliCod
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z1EmpCod ;
   private short Z869LiqLegConAnio ;
   private short Z888LiqLegCodigo ;
   private short A888LiqLegCodigo ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A869LiqLegConAnio ;
   private short RcdFound122 ;
   private short nIsDirty_122 ;
   private short ZZ1EmpCod ;
   private short ZZ869LiqLegConAnio ;
   private short ZZ888LiqLegCodigo ;
   private int Z3CliCod ;
   private int Z6LegNumero ;
   private int Z1097LiqAltaNro ;
   private int Z1098LiqNuevaNro ;
   private int A3CliCod ;
   private int A1097LiqAltaNro ;
   private int A6LegNumero ;
   private int A1098LiqNuevaNro ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Enabled ;
   private int edtLiqLegConAnio_Enabled ;
   private int edtLegNumero_Enabled ;
   private int edtConCodigo_Enabled ;
   private int edtLiqAltaNro_Enabled ;
   private int edtLiqNuevaNro_Enabled ;
   private int edtLiqLegConSaldo_Enabled ;
   private int edtLiqLegConPer_Enabled ;
   private int edtLiqLegCodigo_Enabled ;
   private int edtLiqLegLog_Enabled ;
   private int edtLiqLegCuota_Enabled ;
   private int edtLiqLegTotal_Enabled ;
   private int edtLiqLegTotRecal_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int A31LiqNro ;
   private int idxLst ;
   private int Z31LiqNro ;
   private int ZZ3CliCod ;
   private int ZZ6LegNumero ;
   private int ZZ1097LiqAltaNro ;
   private int ZZ1098LiqNuevaNro ;
   private int ZZ31LiqNro ;
   private java.math.BigDecimal Z868LiqLegConSaldo ;
   private java.math.BigDecimal Z1099LiqLegCuota ;
   private java.math.BigDecimal Z1147LiqLegTotal ;
   private java.math.BigDecimal Z1148LiqLegTotRecal ;
   private java.math.BigDecimal A868LiqLegConSaldo ;
   private java.math.BigDecimal A1099LiqLegCuota ;
   private java.math.BigDecimal A1147LiqLegTotal ;
   private java.math.BigDecimal A1148LiqLegTotRecal ;
   private java.math.BigDecimal ZZ868LiqLegConSaldo ;
   private java.math.BigDecimal ZZ1099LiqLegCuota ;
   private java.math.BigDecimal ZZ1147LiqLegTotal ;
   private java.math.BigDecimal ZZ1148LiqLegTotRecal ;
   private String sPrefix ;
   private String Z26ConCodigo ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A26ConCodigo ;
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
   private String edtLiqLegConAnio_Internalname ;
   private String edtLiqLegConAnio_Jsonclick ;
   private String edtLegNumero_Internalname ;
   private String edtLegNumero_Jsonclick ;
   private String edtConCodigo_Internalname ;
   private String edtConCodigo_Jsonclick ;
   private String edtLiqAltaNro_Internalname ;
   private String edtLiqAltaNro_Jsonclick ;
   private String edtLiqNuevaNro_Internalname ;
   private String edtLiqNuevaNro_Jsonclick ;
   private String edtLiqLegConSaldo_Internalname ;
   private String edtLiqLegConSaldo_Jsonclick ;
   private String edtLiqLegConPer_Internalname ;
   private String edtLiqLegConPer_Jsonclick ;
   private String edtLiqLegCodigo_Internalname ;
   private String edtLiqLegCodigo_Jsonclick ;
   private String edtLiqLegLog_Internalname ;
   private String edtLiqLegCuota_Internalname ;
   private String edtLiqLegCuota_Jsonclick ;
   private String edtLiqLegTotal_Internalname ;
   private String edtLiqLegTotal_Jsonclick ;
   private String edtLiqLegTotRecal_Internalname ;
   private String edtLiqLegTotRecal_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String Gx_mode ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode122 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ26ConCodigo ;
   private java.util.Date Z886LiqLegConPer ;
   private java.util.Date A886LiqLegConPer ;
   private java.util.Date ZZ886LiqLegConPer ;
   private boolean Z889LiqLegPrimera ;
   private boolean Z1778LiqLegEsPrrGan ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n888LiqLegCodigo ;
   private boolean wbErr ;
   private boolean A889LiqLegPrimera ;
   private boolean A1778LiqLegEsPrrGan ;
   private boolean n886LiqLegConPer ;
   private boolean n42ConCodYDesc ;
   private boolean Gx_longc ;
   private boolean ZZ889LiqLegPrimera ;
   private boolean ZZ1778LiqLegEsPrrGan ;
   private String Z1094LiqLegLog ;
   private String A1094LiqLegLog ;
   private String A42ConCodYDesc ;
   private String A41ConDescrip ;
   private String Z42ConCodYDesc ;
   private String Z41ConDescrip ;
   private String ZZ1094LiqLegLog ;
   private String ZZ42ConCodYDesc ;
   private String ZZ41ConDescrip ;
   private ICheckbox chkLiqLegPrimera ;
   private ICheckbox chkLiqLegEsPrrGan ;
   private IDataStoreProvider pr_default ;
   private String[] T002M8_A42ConCodYDesc ;
   private boolean[] T002M8_n42ConCodYDesc ;
   private short[] T002M8_A869LiqLegConAnio ;
   private java.math.BigDecimal[] T002M8_A868LiqLegConSaldo ;
   private java.util.Date[] T002M8_A886LiqLegConPer ;
   private boolean[] T002M8_n886LiqLegConPer ;
   private boolean[] T002M8_A889LiqLegPrimera ;
   private String[] T002M8_A1094LiqLegLog ;
   private java.math.BigDecimal[] T002M8_A1099LiqLegCuota ;
   private java.math.BigDecimal[] T002M8_A1147LiqLegTotal ;
   private java.math.BigDecimal[] T002M8_A1148LiqLegTotRecal ;
   private boolean[] T002M8_A1778LiqLegEsPrrGan ;
   private String[] T002M8_A41ConDescrip ;
   private int[] T002M8_A3CliCod ;
   private short[] T002M8_A1EmpCod ;
   private int[] T002M8_A6LegNumero ;
   private int[] T002M8_A1097LiqAltaNro ;
   private int[] T002M8_A1098LiqNuevaNro ;
   private String[] T002M8_A26ConCodigo ;
   private short[] T002M8_A888LiqLegCodigo ;
   private boolean[] T002M8_n888LiqLegCodigo ;
   private int[] T002M7_A3CliCod ;
   private String[] T002M6_A42ConCodYDesc ;
   private boolean[] T002M6_n42ConCodYDesc ;
   private String[] T002M6_A41ConDescrip ;
   private int[] T002M4_A31LiqNro ;
   private int[] T002M5_A31LiqNro ;
   private int[] T002M9_A3CliCod ;
   private String[] T002M10_A42ConCodYDesc ;
   private boolean[] T002M10_n42ConCodYDesc ;
   private String[] T002M10_A41ConDescrip ;
   private int[] T002M11_A31LiqNro ;
   private int[] T002M12_A31LiqNro ;
   private int[] T002M13_A3CliCod ;
   private short[] T002M13_A1EmpCod ;
   private short[] T002M13_A869LiqLegConAnio ;
   private int[] T002M13_A6LegNumero ;
   private String[] T002M13_A26ConCodigo ;
   private int[] T002M13_A1097LiqAltaNro ;
   private int[] T002M13_A1098LiqNuevaNro ;
   private short[] T002M3_A869LiqLegConAnio ;
   private java.math.BigDecimal[] T002M3_A868LiqLegConSaldo ;
   private java.util.Date[] T002M3_A886LiqLegConPer ;
   private boolean[] T002M3_n886LiqLegConPer ;
   private boolean[] T002M3_A889LiqLegPrimera ;
   private String[] T002M3_A1094LiqLegLog ;
   private java.math.BigDecimal[] T002M3_A1099LiqLegCuota ;
   private java.math.BigDecimal[] T002M3_A1147LiqLegTotal ;
   private java.math.BigDecimal[] T002M3_A1148LiqLegTotRecal ;
   private boolean[] T002M3_A1778LiqLegEsPrrGan ;
   private int[] T002M3_A3CliCod ;
   private short[] T002M3_A1EmpCod ;
   private int[] T002M3_A6LegNumero ;
   private int[] T002M3_A1097LiqAltaNro ;
   private int[] T002M3_A1098LiqNuevaNro ;
   private String[] T002M3_A26ConCodigo ;
   private short[] T002M3_A888LiqLegCodigo ;
   private boolean[] T002M3_n888LiqLegCodigo ;
   private short[] T002M14_A869LiqLegConAnio ;
   private int[] T002M14_A3CliCod ;
   private short[] T002M14_A1EmpCod ;
   private int[] T002M14_A6LegNumero ;
   private int[] T002M14_A1097LiqAltaNro ;
   private int[] T002M14_A1098LiqNuevaNro ;
   private String[] T002M14_A26ConCodigo ;
   private short[] T002M15_A869LiqLegConAnio ;
   private int[] T002M15_A3CliCod ;
   private short[] T002M15_A1EmpCod ;
   private int[] T002M15_A6LegNumero ;
   private int[] T002M15_A1097LiqAltaNro ;
   private int[] T002M15_A1098LiqNuevaNro ;
   private String[] T002M15_A26ConCodigo ;
   private short[] T002M2_A869LiqLegConAnio ;
   private java.math.BigDecimal[] T002M2_A868LiqLegConSaldo ;
   private java.util.Date[] T002M2_A886LiqLegConPer ;
   private boolean[] T002M2_n886LiqLegConPer ;
   private boolean[] T002M2_A889LiqLegPrimera ;
   private String[] T002M2_A1094LiqLegLog ;
   private java.math.BigDecimal[] T002M2_A1099LiqLegCuota ;
   private java.math.BigDecimal[] T002M2_A1147LiqLegTotal ;
   private java.math.BigDecimal[] T002M2_A1148LiqLegTotRecal ;
   private boolean[] T002M2_A1778LiqLegEsPrrGan ;
   private int[] T002M2_A3CliCod ;
   private short[] T002M2_A1EmpCod ;
   private int[] T002M2_A6LegNumero ;
   private int[] T002M2_A1097LiqAltaNro ;
   private int[] T002M2_A1098LiqNuevaNro ;
   private String[] T002M2_A26ConCodigo ;
   private short[] T002M2_A888LiqLegCodigo ;
   private boolean[] T002M2_n888LiqLegCodigo ;
   private String[] T002M19_A42ConCodYDesc ;
   private boolean[] T002M19_n42ConCodYDesc ;
   private String[] T002M19_A41ConDescrip ;
   private int[] T002M20_A3CliCod ;
   private short[] T002M20_A1EmpCod ;
   private short[] T002M20_A869LiqLegConAnio ;
   private int[] T002M20_A6LegNumero ;
   private String[] T002M20_A26ConCodigo ;
   private int[] T002M20_A1097LiqAltaNro ;
   private int[] T002M20_A1098LiqNuevaNro ;
   private int[] T002M21_A31LiqNro ;
   private int[] T002M22_A31LiqNro ;
   private int[] T002M23_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class liqlegconceptocuenta__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T002M2", "SELECT LiqLegConAnio, LiqLegConSaldo, LiqLegConPer, LiqLegPrimera, LiqLegLog, LiqLegCuota, LiqLegTotal, LiqLegTotRecal, LiqLegEsPrrGan, CliCod, EmpCod, LegNumero, LiqAltaNro, LiqNuevaNro, ConCodigo, LiqLegCodigo FROM LiqLegConceptoCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqLegConAnio = ? AND LegNumero = ? AND ConCodigo = ? AND LiqAltaNro = ? AND LiqNuevaNro = ?  FOR UPDATE OF LiqLegConceptoCuenta NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002M3", "SELECT LiqLegConAnio, LiqLegConSaldo, LiqLegConPer, LiqLegPrimera, LiqLegLog, LiqLegCuota, LiqLegTotal, LiqLegTotRecal, LiqLegEsPrrGan, CliCod, EmpCod, LegNumero, LiqAltaNro, LiqNuevaNro, ConCodigo, LiqLegCodigo FROM LiqLegConceptoCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqLegConAnio = ? AND LegNumero = ? AND ConCodigo = ? AND LiqAltaNro = ? AND LiqNuevaNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002M4", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002M5", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002M6", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002M7", "SELECT CliCod FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002M8", "SELECT T2.ConCodYDesc, TM1.LiqLegConAnio, TM1.LiqLegConSaldo, TM1.LiqLegConPer, TM1.LiqLegPrimera, TM1.LiqLegLog, TM1.LiqLegCuota, TM1.LiqLegTotal, TM1.LiqLegTotRecal, TM1.LiqLegEsPrrGan, T2.ConDescrip, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LiqAltaNro, TM1.LiqNuevaNro, TM1.ConCodigo, TM1.LiqLegCodigo AS LiqLegCodigo FROM (LiqLegConceptoCuenta TM1 INNER JOIN Concepto T2 ON T2.CliCod = TM1.CliCod AND T2.ConCodigo = TM1.ConCodigo) WHERE TM1.LiqLegConAnio = ? and TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.LiqAltaNro = ? and TM1.LiqNuevaNro = ? and TM1.ConCodigo = ( ?) ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LiqLegConAnio, TM1.LegNumero, TM1.ConCodigo, TM1.LiqAltaNro, TM1.LiqNuevaNro ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002M9", "SELECT CliCod FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002M10", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002M11", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002M12", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002M13", "SELECT CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro FROM LiqLegConceptoCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqLegConAnio = ? AND LegNumero = ? AND ConCodigo = ? AND LiqAltaNro = ? AND LiqNuevaNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002M14", "SELECT LiqLegConAnio, CliCod, EmpCod, LegNumero, LiqAltaNro, LiqNuevaNro, ConCodigo FROM LiqLegConceptoCuenta WHERE ( LiqLegConAnio > ? or LiqLegConAnio = ? and CliCod > ? or CliCod = ? and LiqLegConAnio = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and LiqLegConAnio = ? and LegNumero > ? or LegNumero = ? and EmpCod = ? and CliCod = ? and LiqLegConAnio = ? and LiqAltaNro > ? or LiqAltaNro = ? and LegNumero = ? and EmpCod = ? and CliCod = ? and LiqLegConAnio = ? and LiqNuevaNro > ? or LiqNuevaNro = ? and LiqAltaNro = ? and LegNumero = ? and EmpCod = ? and CliCod = ? and LiqLegConAnio = ? and ConCodigo > ( ?)) ORDER BY CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002M15", "SELECT LiqLegConAnio, CliCod, EmpCod, LegNumero, LiqAltaNro, LiqNuevaNro, ConCodigo FROM LiqLegConceptoCuenta WHERE ( LiqLegConAnio < ? or LiqLegConAnio = ? and CliCod < ? or CliCod = ? and LiqLegConAnio = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and LiqLegConAnio = ? and LegNumero < ? or LegNumero = ? and EmpCod = ? and CliCod = ? and LiqLegConAnio = ? and LiqAltaNro < ? or LiqAltaNro = ? and LegNumero = ? and EmpCod = ? and CliCod = ? and LiqLegConAnio = ? and LiqNuevaNro < ? or LiqNuevaNro = ? and LiqAltaNro = ? and LegNumero = ? and EmpCod = ? and CliCod = ? and LiqLegConAnio = ? and ConCodigo < ( ?)) ORDER BY CliCod DESC, EmpCod DESC, LiqLegConAnio DESC, LegNumero DESC, ConCodigo DESC, LiqAltaNro DESC, LiqNuevaNro DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T002M16", "SAVEPOINT gxupdate;INSERT INTO LiqLegConceptoCuenta(LiqLegConAnio, LiqLegConSaldo, LiqLegConPer, LiqLegPrimera, LiqLegLog, LiqLegCuota, LiqLegTotal, LiqLegTotRecal, LiqLegEsPrrGan, CliCod, EmpCod, LegNumero, LiqAltaNro, LiqNuevaNro, ConCodigo, LiqLegCodigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002M17", "SAVEPOINT gxupdate;UPDATE LiqLegConceptoCuenta SET LiqLegConSaldo=?, LiqLegConPer=?, LiqLegPrimera=?, LiqLegLog=?, LiqLegCuota=?, LiqLegTotal=?, LiqLegTotRecal=?, LiqLegEsPrrGan=?, LiqLegCodigo=?  WHERE CliCod = ? AND EmpCod = ? AND LiqLegConAnio = ? AND LegNumero = ? AND ConCodigo = ? AND LiqAltaNro = ? AND LiqNuevaNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002M18", "SAVEPOINT gxupdate;DELETE FROM LiqLegConceptoCuenta  WHERE CliCod = ? AND EmpCod = ? AND LiqLegConAnio = ? AND LegNumero = ? AND ConCodigo = ? AND LiqAltaNro = ? AND LiqNuevaNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002M19", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002M20", "SELECT CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro FROM LiqLegConceptoCuenta ORDER BY CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002M21", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002M22", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002M23", "SELECT CliCod FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((boolean[]) buf[4])[0] = rslt.getBoolean(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               ((short[]) buf[11])[0] = rslt.getShort(11);
               ((int[]) buf[12])[0] = rslt.getInt(12);
               ((int[]) buf[13])[0] = rslt.getInt(13);
               ((int[]) buf[14])[0] = rslt.getInt(14);
               ((String[]) buf[15])[0] = rslt.getString(15, 10);
               ((short[]) buf[16])[0] = rslt.getShort(16);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((boolean[]) buf[4])[0] = rslt.getBoolean(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               ((short[]) buf[11])[0] = rslt.getShort(11);
               ((int[]) buf[12])[0] = rslt.getInt(12);
               ((int[]) buf[13])[0] = rslt.getInt(13);
               ((int[]) buf[14])[0] = rslt.getInt(14);
               ((String[]) buf[15])[0] = rslt.getString(15, 10);
               ((short[]) buf[16])[0] = rslt.getShort(16);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(5);
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(9,2);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(10);
               ((String[]) buf[12])[0] = rslt.getVarchar(11);
               ((int[]) buf[13])[0] = rslt.getInt(12);
               ((short[]) buf[14])[0] = rslt.getShort(13);
               ((int[]) buf[15])[0] = rslt.getInt(14);
               ((int[]) buf[16])[0] = rslt.getInt(15);
               ((int[]) buf[17])[0] = rslt.getInt(16);
               ((String[]) buf[18])[0] = rslt.getString(17, 10);
               ((short[]) buf[19])[0] = rslt.getShort(18);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 21 :
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 10);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               stmt.setInt(13, ((Number) parms[12]).intValue());
               stmt.setShort(14, ((Number) parms[13]).shortValue());
               stmt.setInt(15, ((Number) parms[14]).intValue());
               stmt.setInt(16, ((Number) parms[15]).intValue());
               stmt.setInt(17, ((Number) parms[16]).intValue());
               stmt.setShort(18, ((Number) parms[17]).shortValue());
               stmt.setInt(19, ((Number) parms[18]).intValue());
               stmt.setShort(20, ((Number) parms[19]).shortValue());
               stmt.setInt(21, ((Number) parms[20]).intValue());
               stmt.setInt(22, ((Number) parms[21]).intValue());
               stmt.setInt(23, ((Number) parms[22]).intValue());
               stmt.setInt(24, ((Number) parms[23]).intValue());
               stmt.setShort(25, ((Number) parms[24]).shortValue());
               stmt.setInt(26, ((Number) parms[25]).intValue());
               stmt.setShort(27, ((Number) parms[26]).shortValue());
               stmt.setString(28, (String)parms[27], 10);
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               stmt.setInt(13, ((Number) parms[12]).intValue());
               stmt.setShort(14, ((Number) parms[13]).shortValue());
               stmt.setInt(15, ((Number) parms[14]).intValue());
               stmt.setInt(16, ((Number) parms[15]).intValue());
               stmt.setInt(17, ((Number) parms[16]).intValue());
               stmt.setShort(18, ((Number) parms[17]).shortValue());
               stmt.setInt(19, ((Number) parms[18]).intValue());
               stmt.setShort(20, ((Number) parms[19]).shortValue());
               stmt.setInt(21, ((Number) parms[20]).intValue());
               stmt.setInt(22, ((Number) parms[21]).intValue());
               stmt.setInt(23, ((Number) parms[22]).intValue());
               stmt.setInt(24, ((Number) parms[23]).intValue());
               stmt.setShort(25, ((Number) parms[24]).shortValue());
               stmt.setInt(26, ((Number) parms[25]).intValue());
               stmt.setShort(27, ((Number) parms[26]).shortValue());
               stmt.setString(28, (String)parms[27], 10);
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.DATE );
               }
               else
               {
                  stmt.setDate(3, (java.util.Date)parms[3]);
               }
               stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               stmt.setVarchar(5, (String)parms[5], 1000, false);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 2);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 2);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[8], 2);
               stmt.setBoolean(9, ((Boolean) parms[9]).booleanValue());
               stmt.setInt(10, ((Number) parms[10]).intValue());
               stmt.setShort(11, ((Number) parms[11]).shortValue());
               stmt.setInt(12, ((Number) parms[12]).intValue());
               stmt.setInt(13, ((Number) parms[13]).intValue());
               stmt.setInt(14, ((Number) parms[14]).intValue());
               stmt.setString(15, (String)parms[15], 10);
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(16, ((Number) parms[17]).shortValue());
               }
               return;
            case 15 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.DATE );
               }
               else
               {
                  stmt.setDate(2, (java.util.Date)parms[2]);
               }
               stmt.setBoolean(3, ((Boolean) parms[3]).booleanValue());
               stmt.setVarchar(4, (String)parms[4], 1000, false);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 2);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 2);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[7], 2);
               stmt.setBoolean(8, ((Boolean) parms[8]).booleanValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(9, ((Number) parms[10]).shortValue());
               }
               stmt.setInt(10, ((Number) parms[11]).intValue());
               stmt.setShort(11, ((Number) parms[12]).shortValue());
               stmt.setShort(12, ((Number) parms[13]).shortValue());
               stmt.setInt(13, ((Number) parms[14]).intValue());
               stmt.setString(14, (String)parms[15], 10);
               stmt.setInt(15, ((Number) parms[16]).intValue());
               stmt.setInt(16, ((Number) parms[17]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
      }
   }

}

