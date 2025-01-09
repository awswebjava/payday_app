package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class liqlegobligacioncuenta_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_4") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A1172OblSecuencial = (short)(GXutil.lval( httpContext.GetPar( "OblSecuencial"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_4( A3CliCod, A1EmpCod, A6LegNumero, A1172OblSecuencial) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_2") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1184LiqOblAltaNro = (int)(GXutil.lval( httpContext.GetPar( "LiqOblAltaNro"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1184LiqOblAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1184LiqOblAltaNro), 8, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_2( A3CliCod, A1EmpCod, A1184LiqOblAltaNro, A6LegNumero) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_3") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1185LiqOblNuevaNro = (int)(GXutil.lval( httpContext.GetPar( "LiqOblNuevaNro"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1185LiqOblNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1185LiqOblNuevaNro), 8, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_3( A3CliCod, A1EmpCod, A1185LiqOblNuevaNro, A6LegNumero) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Liq Leg Obligacion Cuenta", ""), (short)(0)) ;
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

   public liqlegobligacioncuenta_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public liqlegobligacioncuenta_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liqlegobligacioncuenta_impl.class ));
   }

   public liqlegobligacioncuenta_impl( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkLiqOblPrimera = UIFactory.getCheckbox(this);
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
      A1186LiqOblPrimera = GXutil.strtobool( GXutil.booltostr( A1186LiqOblPrimera)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1186LiqOblPrimera", A1186LiqOblPrimera);
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "Liq Leg Obligacion Cuenta", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_LiqLegObligacionCuenta.htm");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiqLegObligacionCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiqLegObligacionCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiqLegObligacionCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiqLegObligacionCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_LiqLegObligacionCuenta.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiqLegObligacionCuenta.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_LiqLegObligacionCuenta.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegNumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_LiqLegObligacionCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOblSecuencial_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOblSecuencial_Internalname, httpContext.getMessage( "Obl Secuencial", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOblSecuencial_Internalname, GXutil.ltrim( localUtil.ntoc( A1172OblSecuencial, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtOblSecuencial_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1172OblSecuencial), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1172OblSecuencial), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOblSecuencial_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtOblSecuencial_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiqLegObligacionCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqOblAltaNro_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqOblAltaNro_Internalname, httpContext.getMessage( "Alta Nro", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqOblAltaNro_Internalname, GXutil.ltrim( localUtil.ntoc( A1184LiqOblAltaNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqOblAltaNro_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1184LiqOblAltaNro), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1184LiqOblAltaNro), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqOblAltaNro_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqOblAltaNro_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_LiqLegObligacionCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqOblNuevaNro_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqOblNuevaNro_Internalname, httpContext.getMessage( "Nueva Nro", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqOblNuevaNro_Internalname, GXutil.ltrim( localUtil.ntoc( A1185LiqOblNuevaNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqOblNuevaNro_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1185LiqOblNuevaNro), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1185LiqOblNuevaNro), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqOblNuevaNro_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqOblNuevaNro_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_LiqLegObligacionCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkLiqOblPrimera.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkLiqOblPrimera.getInternalname(), httpContext.getMessage( "Obl Primera", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkLiqOblPrimera.getInternalname(), GXutil.booltostr( A1186LiqOblPrimera), "", httpContext.getMessage( "Obl Primera", ""), 1, chkLiqOblPrimera.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(64, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,64);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqOblLog_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqOblLog_Internalname, httpContext.getMessage( "Obl Log", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtLiqOblLog_Internalname, A1187LiqOblLog, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", (short)(0), 1, edtLiqOblLog_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "1000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_LiqLegObligacionCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqOblCuota_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqOblCuota_Internalname, httpContext.getMessage( "Obl Cuota", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqOblCuota_Internalname, GXutil.ltrim( localUtil.ntoc( A1188LiqOblCuota, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqOblCuota_Enabled!=0) ? localUtil.format( A1188LiqOblCuota, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1188LiqOblCuota, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqOblCuota_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqOblCuota_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_LiqLegObligacionCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqOblTotal_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqOblTotal_Internalname, httpContext.getMessage( "Obl Total", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqOblTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A1189LiqOblTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqOblTotal_Enabled!=0) ? localUtil.format( A1189LiqOblTotal, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1189LiqOblTotal, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqOblTotal_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqOblTotal_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_LiqLegObligacionCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqOblTotRecal_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqOblTotRecal_Internalname, httpContext.getMessage( "Tot Recal", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqOblTotRecal_Internalname, GXutil.ltrim( localUtil.ntoc( A1190LiqOblTotRecal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqOblTotRecal_Enabled!=0) ? localUtil.format( A1190LiqOblTotRecal, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1190LiqOblTotRecal, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,84);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqOblTotRecal_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqOblTotRecal_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_LiqLegObligacionCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqOblSaldo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqOblSaldo_Internalname, httpContext.getMessage( "Obl Saldo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqOblSaldo_Internalname, GXutil.ltrim( localUtil.ntoc( A1197LiqOblSaldo, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqOblSaldo_Enabled!=0) ? localUtil.format( A1197LiqOblSaldo, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1197LiqOblSaldo, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,89);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqOblSaldo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqOblSaldo_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_LiqLegObligacionCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqOblPeriodo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqOblPeriodo_Internalname, httpContext.getMessage( "Obl Periodo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtLiqOblPeriodo_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqOblPeriodo_Internalname, localUtil.format(A1199LiqOblPeriodo, "99/99/9999"), localUtil.format( A1199LiqOblPeriodo, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,94);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqOblPeriodo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqOblPeriodo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_LiqLegObligacionCuenta.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtLiqOblPeriodo_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLiqOblPeriodo_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LiqLegObligacionCuenta.htm");
      httpContext.writeTextNL( "</div>") ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiqLegObligacionCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 101,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiqLegObligacionCuenta.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 103,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiqLegObligacionCuenta.htm");
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
         Z6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "Z6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1172OblSecuencial = (short)(localUtil.ctol( httpContext.cgiGet( "Z1172OblSecuencial"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1184LiqOblAltaNro = (int)(localUtil.ctol( httpContext.cgiGet( "Z1184LiqOblAltaNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1185LiqOblNuevaNro = (int)(localUtil.ctol( httpContext.cgiGet( "Z1185LiqOblNuevaNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1186LiqOblPrimera = GXutil.strtobool( httpContext.cgiGet( "Z1186LiqOblPrimera")) ;
         Z1187LiqOblLog = httpContext.cgiGet( "Z1187LiqOblLog") ;
         Z1188LiqOblCuota = localUtil.ctond( httpContext.cgiGet( "Z1188LiqOblCuota")) ;
         Z1189LiqOblTotal = localUtil.ctond( httpContext.cgiGet( "Z1189LiqOblTotal")) ;
         Z1190LiqOblTotRecal = localUtil.ctond( httpContext.cgiGet( "Z1190LiqOblTotRecal")) ;
         Z1197LiqOblSaldo = localUtil.ctond( httpContext.cgiGet( "Z1197LiqOblSaldo")) ;
         Z1199LiqOblPeriodo = localUtil.ctod( httpContext.cgiGet( "Z1199LiqOblPeriodo"), 0) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
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
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtOblSecuencial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtOblSecuencial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "OBLSECUENCIAL");
            AnyError = (short)(1) ;
            GX_FocusControl = edtOblSecuencial_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1172OblSecuencial = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
         }
         else
         {
            A1172OblSecuencial = (short)(localUtil.ctol( httpContext.cgiGet( edtOblSecuencial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqOblAltaNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqOblAltaNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQOBLALTANRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqOblAltaNro_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1184LiqOblAltaNro = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A1184LiqOblAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1184LiqOblAltaNro), 8, 0));
         }
         else
         {
            A1184LiqOblAltaNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqOblAltaNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1184LiqOblAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1184LiqOblAltaNro), 8, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqOblNuevaNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqOblNuevaNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQOBLNUEVANRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqOblNuevaNro_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1185LiqOblNuevaNro = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A1185LiqOblNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1185LiqOblNuevaNro), 8, 0));
         }
         else
         {
            A1185LiqOblNuevaNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqOblNuevaNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1185LiqOblNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1185LiqOblNuevaNro), 8, 0));
         }
         A1186LiqOblPrimera = GXutil.strtobool( httpContext.cgiGet( chkLiqOblPrimera.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1186LiqOblPrimera", A1186LiqOblPrimera);
         A1187LiqOblLog = httpContext.cgiGet( edtLiqOblLog_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1187LiqOblLog", A1187LiqOblLog);
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqOblCuota_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqOblCuota_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQOBLCUOTA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqOblCuota_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1188LiqOblCuota = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A1188LiqOblCuota", GXutil.ltrimstr( A1188LiqOblCuota, 14, 2));
         }
         else
         {
            A1188LiqOblCuota = localUtil.ctond( httpContext.cgiGet( edtLiqOblCuota_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1188LiqOblCuota", GXutil.ltrimstr( A1188LiqOblCuota, 14, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqOblTotal_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqOblTotal_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQOBLTOTAL");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqOblTotal_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1189LiqOblTotal = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A1189LiqOblTotal", GXutil.ltrimstr( A1189LiqOblTotal, 14, 2));
         }
         else
         {
            A1189LiqOblTotal = localUtil.ctond( httpContext.cgiGet( edtLiqOblTotal_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1189LiqOblTotal", GXutil.ltrimstr( A1189LiqOblTotal, 14, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqOblTotRecal_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqOblTotRecal_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQOBLTOTRECAL");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqOblTotRecal_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1190LiqOblTotRecal = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A1190LiqOblTotRecal", GXutil.ltrimstr( A1190LiqOblTotRecal, 14, 2));
         }
         else
         {
            A1190LiqOblTotRecal = localUtil.ctond( httpContext.cgiGet( edtLiqOblTotRecal_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1190LiqOblTotRecal", GXutil.ltrimstr( A1190LiqOblTotRecal, 14, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqOblSaldo_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqOblSaldo_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQOBLSALDO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqOblSaldo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1197LiqOblSaldo = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A1197LiqOblSaldo", GXutil.ltrimstr( A1197LiqOblSaldo, 14, 2));
         }
         else
         {
            A1197LiqOblSaldo = localUtil.ctond( httpContext.cgiGet( edtLiqOblSaldo_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1197LiqOblSaldo", GXutil.ltrimstr( A1197LiqOblSaldo, 14, 2));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtLiqOblPeriodo_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "LIQOBLPERIODO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqOblPeriodo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1199LiqOblPeriodo = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "A1199LiqOblPeriodo", localUtil.format(A1199LiqOblPeriodo, "99/99/9999"));
         }
         else
         {
            A1199LiqOblPeriodo = localUtil.ctod( httpContext.cgiGet( edtLiqOblPeriodo_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1199LiqOblPeriodo", localUtil.format(A1199LiqOblPeriodo, "99/99/9999"));
         }
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
            A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A1172OblSecuencial = (short)(GXutil.lval( httpContext.GetPar( "OblSecuencial"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
            A1184LiqOblAltaNro = (int)(GXutil.lval( httpContext.GetPar( "LiqOblAltaNro"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1184LiqOblAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1184LiqOblAltaNro), 8, 0));
            A1185LiqOblNuevaNro = (int)(GXutil.lval( httpContext.GetPar( "LiqOblNuevaNro"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1185LiqOblNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1185LiqOblNuevaNro), 8, 0));
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
            initAll3E136( ) ;
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
      disableAttributes3E136( ) ;
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

   public void resetCaption3E0( )
   {
   }

   public void zm3E136( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1186LiqOblPrimera = T003E3_A1186LiqOblPrimera[0] ;
            Z1187LiqOblLog = T003E3_A1187LiqOblLog[0] ;
            Z1188LiqOblCuota = T003E3_A1188LiqOblCuota[0] ;
            Z1189LiqOblTotal = T003E3_A1189LiqOblTotal[0] ;
            Z1190LiqOblTotRecal = T003E3_A1190LiqOblTotRecal[0] ;
            Z1197LiqOblSaldo = T003E3_A1197LiqOblSaldo[0] ;
            Z1199LiqOblPeriodo = T003E3_A1199LiqOblPeriodo[0] ;
         }
         else
         {
            Z1186LiqOblPrimera = A1186LiqOblPrimera ;
            Z1187LiqOblLog = A1187LiqOblLog ;
            Z1188LiqOblCuota = A1188LiqOblCuota ;
            Z1189LiqOblTotal = A1189LiqOblTotal ;
            Z1190LiqOblTotRecal = A1190LiqOblTotRecal ;
            Z1197LiqOblSaldo = A1197LiqOblSaldo ;
            Z1199LiqOblPeriodo = A1199LiqOblPeriodo ;
         }
      }
      if ( GX_JID == -1 )
      {
         Z1186LiqOblPrimera = A1186LiqOblPrimera ;
         Z1187LiqOblLog = A1187LiqOblLog ;
         Z1188LiqOblCuota = A1188LiqOblCuota ;
         Z1189LiqOblTotal = A1189LiqOblTotal ;
         Z1190LiqOblTotRecal = A1190LiqOblTotRecal ;
         Z1197LiqOblSaldo = A1197LiqOblSaldo ;
         Z1199LiqOblPeriodo = A1199LiqOblPeriodo ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1184LiqOblAltaNro = A1184LiqOblAltaNro ;
         Z1185LiqOblNuevaNro = A1185LiqOblNuevaNro ;
         Z1172OblSecuencial = A1172OblSecuencial ;
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

   public void load3E136( )
   {
      /* Using cursor T003E7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A1185LiqOblNuevaNro), Short.valueOf(A1172OblSecuencial)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound136 = (short)(1) ;
         A1186LiqOblPrimera = T003E7_A1186LiqOblPrimera[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1186LiqOblPrimera", A1186LiqOblPrimera);
         A1187LiqOblLog = T003E7_A1187LiqOblLog[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1187LiqOblLog", A1187LiqOblLog);
         A1188LiqOblCuota = T003E7_A1188LiqOblCuota[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1188LiqOblCuota", GXutil.ltrimstr( A1188LiqOblCuota, 14, 2));
         A1189LiqOblTotal = T003E7_A1189LiqOblTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1189LiqOblTotal", GXutil.ltrimstr( A1189LiqOblTotal, 14, 2));
         A1190LiqOblTotRecal = T003E7_A1190LiqOblTotRecal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1190LiqOblTotRecal", GXutil.ltrimstr( A1190LiqOblTotRecal, 14, 2));
         A1197LiqOblSaldo = T003E7_A1197LiqOblSaldo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1197LiqOblSaldo", GXutil.ltrimstr( A1197LiqOblSaldo, 14, 2));
         A1199LiqOblPeriodo = T003E7_A1199LiqOblPeriodo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1199LiqOblPeriodo", localUtil.format(A1199LiqOblPeriodo, "99/99/9999"));
         zm3E136( -1) ;
      }
      pr_default.close(5);
      onLoadActions3E136( ) ;
   }

   public void onLoadActions3E136( )
   {
   }

   public void checkExtendedTable3E136( )
   {
      nIsDirty_136 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T003E6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Obligacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLSECUENCIAL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      /* Using cursor T003E4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T003E5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1185LiqOblNuevaNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
   }

   public void closeExtendedTableCursors3E136( )
   {
      pr_default.close(4);
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_4( int A3CliCod ,
                         short A1EmpCod ,
                         int A6LegNumero ,
                         short A1172OblSecuencial )
   {
      /* Using cursor T003E8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Obligacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLSECUENCIAL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void gxload_2( int A3CliCod ,
                         short A1EmpCod ,
                         int A1184LiqOblAltaNro ,
                         int A6LegNumero )
   {
      /* Using cursor T003E9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
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

   public void gxload_3( int A3CliCod ,
                         short A1EmpCod ,
                         int A1185LiqOblNuevaNro ,
                         int A6LegNumero )
   {
      /* Using cursor T003E10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1185LiqOblNuevaNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(8) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(8);
   }

   public void getKey3E136( )
   {
      /* Using cursor T003E11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A1185LiqOblNuevaNro)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound136 = (short)(1) ;
      }
      else
      {
         RcdFound136 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T003E3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A1185LiqOblNuevaNro)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm3E136( 1) ;
         RcdFound136 = (short)(1) ;
         A1186LiqOblPrimera = T003E3_A1186LiqOblPrimera[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1186LiqOblPrimera", A1186LiqOblPrimera);
         A1187LiqOblLog = T003E3_A1187LiqOblLog[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1187LiqOblLog", A1187LiqOblLog);
         A1188LiqOblCuota = T003E3_A1188LiqOblCuota[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1188LiqOblCuota", GXutil.ltrimstr( A1188LiqOblCuota, 14, 2));
         A1189LiqOblTotal = T003E3_A1189LiqOblTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1189LiqOblTotal", GXutil.ltrimstr( A1189LiqOblTotal, 14, 2));
         A1190LiqOblTotRecal = T003E3_A1190LiqOblTotRecal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1190LiqOblTotRecal", GXutil.ltrimstr( A1190LiqOblTotRecal, 14, 2));
         A1197LiqOblSaldo = T003E3_A1197LiqOblSaldo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1197LiqOblSaldo", GXutil.ltrimstr( A1197LiqOblSaldo, 14, 2));
         A1199LiqOblPeriodo = T003E3_A1199LiqOblPeriodo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1199LiqOblPeriodo", localUtil.format(A1199LiqOblPeriodo, "99/99/9999"));
         A3CliCod = T003E3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T003E3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T003E3_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A1184LiqOblAltaNro = T003E3_A1184LiqOblAltaNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1184LiqOblAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1184LiqOblAltaNro), 8, 0));
         A1185LiqOblNuevaNro = T003E3_A1185LiqOblNuevaNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1185LiqOblNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1185LiqOblNuevaNro), 8, 0));
         A1172OblSecuencial = T003E3_A1172OblSecuencial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1172OblSecuencial = A1172OblSecuencial ;
         Z1184LiqOblAltaNro = A1184LiqOblAltaNro ;
         Z1185LiqOblNuevaNro = A1185LiqOblNuevaNro ;
         sMode136 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load3E136( ) ;
         if ( AnyError == 1 )
         {
            RcdFound136 = (short)(0) ;
            initializeNonKey3E136( ) ;
         }
         Gx_mode = sMode136 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound136 = (short)(0) ;
         initializeNonKey3E136( ) ;
         sMode136 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode136 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey3E136( ) ;
      if ( RcdFound136 == 0 )
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
      RcdFound136 = (short)(0) ;
      /* Using cursor T003E12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1185LiqOblNuevaNro), Integer.valueOf(A1185LiqOblNuevaNro), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A1172OblSecuencial)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T003E12_A3CliCod[0] < A3CliCod ) || ( T003E12_A3CliCod[0] == A3CliCod ) && ( T003E12_A1EmpCod[0] < A1EmpCod ) || ( T003E12_A1EmpCod[0] == A1EmpCod ) && ( T003E12_A3CliCod[0] == A3CliCod ) && ( T003E12_A6LegNumero[0] < A6LegNumero ) || ( T003E12_A6LegNumero[0] == A6LegNumero ) && ( T003E12_A1EmpCod[0] == A1EmpCod ) && ( T003E12_A3CliCod[0] == A3CliCod ) && ( T003E12_A1184LiqOblAltaNro[0] < A1184LiqOblAltaNro ) || ( T003E12_A1184LiqOblAltaNro[0] == A1184LiqOblAltaNro ) && ( T003E12_A6LegNumero[0] == A6LegNumero ) && ( T003E12_A1EmpCod[0] == A1EmpCod ) && ( T003E12_A3CliCod[0] == A3CliCod ) && ( T003E12_A1185LiqOblNuevaNro[0] < A1185LiqOblNuevaNro ) || ( T003E12_A1185LiqOblNuevaNro[0] == A1185LiqOblNuevaNro ) && ( T003E12_A1184LiqOblAltaNro[0] == A1184LiqOblAltaNro ) && ( T003E12_A6LegNumero[0] == A6LegNumero ) && ( T003E12_A1EmpCod[0] == A1EmpCod ) && ( T003E12_A3CliCod[0] == A3CliCod ) && ( T003E12_A1172OblSecuencial[0] < A1172OblSecuencial ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T003E12_A3CliCod[0] > A3CliCod ) || ( T003E12_A3CliCod[0] == A3CliCod ) && ( T003E12_A1EmpCod[0] > A1EmpCod ) || ( T003E12_A1EmpCod[0] == A1EmpCod ) && ( T003E12_A3CliCod[0] == A3CliCod ) && ( T003E12_A6LegNumero[0] > A6LegNumero ) || ( T003E12_A6LegNumero[0] == A6LegNumero ) && ( T003E12_A1EmpCod[0] == A1EmpCod ) && ( T003E12_A3CliCod[0] == A3CliCod ) && ( T003E12_A1184LiqOblAltaNro[0] > A1184LiqOblAltaNro ) || ( T003E12_A1184LiqOblAltaNro[0] == A1184LiqOblAltaNro ) && ( T003E12_A6LegNumero[0] == A6LegNumero ) && ( T003E12_A1EmpCod[0] == A1EmpCod ) && ( T003E12_A3CliCod[0] == A3CliCod ) && ( T003E12_A1185LiqOblNuevaNro[0] > A1185LiqOblNuevaNro ) || ( T003E12_A1185LiqOblNuevaNro[0] == A1185LiqOblNuevaNro ) && ( T003E12_A1184LiqOblAltaNro[0] == A1184LiqOblAltaNro ) && ( T003E12_A6LegNumero[0] == A6LegNumero ) && ( T003E12_A1EmpCod[0] == A1EmpCod ) && ( T003E12_A3CliCod[0] == A3CliCod ) && ( T003E12_A1172OblSecuencial[0] > A1172OblSecuencial ) ) )
         {
            A3CliCod = T003E12_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T003E12_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T003E12_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A1184LiqOblAltaNro = T003E12_A1184LiqOblAltaNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1184LiqOblAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1184LiqOblAltaNro), 8, 0));
            A1185LiqOblNuevaNro = T003E12_A1185LiqOblNuevaNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1185LiqOblNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1185LiqOblNuevaNro), 8, 0));
            A1172OblSecuencial = T003E12_A1172OblSecuencial[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
            RcdFound136 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound136 = (short)(0) ;
      /* Using cursor T003E13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1185LiqOblNuevaNro), Integer.valueOf(A1185LiqOblNuevaNro), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A1172OblSecuencial)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( ( T003E13_A3CliCod[0] > A3CliCod ) || ( T003E13_A3CliCod[0] == A3CliCod ) && ( T003E13_A1EmpCod[0] > A1EmpCod ) || ( T003E13_A1EmpCod[0] == A1EmpCod ) && ( T003E13_A3CliCod[0] == A3CliCod ) && ( T003E13_A6LegNumero[0] > A6LegNumero ) || ( T003E13_A6LegNumero[0] == A6LegNumero ) && ( T003E13_A1EmpCod[0] == A1EmpCod ) && ( T003E13_A3CliCod[0] == A3CliCod ) && ( T003E13_A1184LiqOblAltaNro[0] > A1184LiqOblAltaNro ) || ( T003E13_A1184LiqOblAltaNro[0] == A1184LiqOblAltaNro ) && ( T003E13_A6LegNumero[0] == A6LegNumero ) && ( T003E13_A1EmpCod[0] == A1EmpCod ) && ( T003E13_A3CliCod[0] == A3CliCod ) && ( T003E13_A1185LiqOblNuevaNro[0] > A1185LiqOblNuevaNro ) || ( T003E13_A1185LiqOblNuevaNro[0] == A1185LiqOblNuevaNro ) && ( T003E13_A1184LiqOblAltaNro[0] == A1184LiqOblAltaNro ) && ( T003E13_A6LegNumero[0] == A6LegNumero ) && ( T003E13_A1EmpCod[0] == A1EmpCod ) && ( T003E13_A3CliCod[0] == A3CliCod ) && ( T003E13_A1172OblSecuencial[0] > A1172OblSecuencial ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( ( T003E13_A3CliCod[0] < A3CliCod ) || ( T003E13_A3CliCod[0] == A3CliCod ) && ( T003E13_A1EmpCod[0] < A1EmpCod ) || ( T003E13_A1EmpCod[0] == A1EmpCod ) && ( T003E13_A3CliCod[0] == A3CliCod ) && ( T003E13_A6LegNumero[0] < A6LegNumero ) || ( T003E13_A6LegNumero[0] == A6LegNumero ) && ( T003E13_A1EmpCod[0] == A1EmpCod ) && ( T003E13_A3CliCod[0] == A3CliCod ) && ( T003E13_A1184LiqOblAltaNro[0] < A1184LiqOblAltaNro ) || ( T003E13_A1184LiqOblAltaNro[0] == A1184LiqOblAltaNro ) && ( T003E13_A6LegNumero[0] == A6LegNumero ) && ( T003E13_A1EmpCod[0] == A1EmpCod ) && ( T003E13_A3CliCod[0] == A3CliCod ) && ( T003E13_A1185LiqOblNuevaNro[0] < A1185LiqOblNuevaNro ) || ( T003E13_A1185LiqOblNuevaNro[0] == A1185LiqOblNuevaNro ) && ( T003E13_A1184LiqOblAltaNro[0] == A1184LiqOblAltaNro ) && ( T003E13_A6LegNumero[0] == A6LegNumero ) && ( T003E13_A1EmpCod[0] == A1EmpCod ) && ( T003E13_A3CliCod[0] == A3CliCod ) && ( T003E13_A1172OblSecuencial[0] < A1172OblSecuencial ) ) )
         {
            A3CliCod = T003E13_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T003E13_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T003E13_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A1184LiqOblAltaNro = T003E13_A1184LiqOblAltaNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1184LiqOblAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1184LiqOblAltaNro), 8, 0));
            A1185LiqOblNuevaNro = T003E13_A1185LiqOblNuevaNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1185LiqOblNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1185LiqOblNuevaNro), 8, 0));
            A1172OblSecuencial = T003E13_A1172OblSecuencial[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
            RcdFound136 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey3E136( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert3E136( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound136 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A1172OblSecuencial != Z1172OblSecuencial ) || ( A1184LiqOblAltaNro != Z1184LiqOblAltaNro ) || ( A1185LiqOblNuevaNro != Z1185LiqOblNuevaNro ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A6LegNumero = Z6LegNumero ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A1172OblSecuencial = Z1172OblSecuencial ;
               httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
               A1184LiqOblAltaNro = Z1184LiqOblAltaNro ;
               httpContext.ajax_rsp_assign_attri("", false, "A1184LiqOblAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1184LiqOblAltaNro), 8, 0));
               A1185LiqOblNuevaNro = Z1185LiqOblNuevaNro ;
               httpContext.ajax_rsp_assign_attri("", false, "A1185LiqOblNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1185LiqOblNuevaNro), 8, 0));
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
               update3E136( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A1172OblSecuencial != Z1172OblSecuencial ) || ( A1184LiqOblAltaNro != Z1184LiqOblAltaNro ) || ( A1185LiqOblNuevaNro != Z1185LiqOblNuevaNro ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert3E136( ) ;
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
                  insert3E136( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A1172OblSecuencial != Z1172OblSecuencial ) || ( A1184LiqOblAltaNro != Z1184LiqOblAltaNro ) || ( A1185LiqOblNuevaNro != Z1185LiqOblNuevaNro ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = Z6LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A1172OblSecuencial = Z1172OblSecuencial ;
         httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
         A1184LiqOblAltaNro = Z1184LiqOblAltaNro ;
         httpContext.ajax_rsp_assign_attri("", false, "A1184LiqOblAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1184LiqOblAltaNro), 8, 0));
         A1185LiqOblNuevaNro = Z1185LiqOblNuevaNro ;
         httpContext.ajax_rsp_assign_attri("", false, "A1185LiqOblNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1185LiqOblNuevaNro), 8, 0));
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
      if ( RcdFound136 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = chkLiqOblPrimera.getInternalname() ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart3E136( ) ;
      if ( RcdFound136 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = chkLiqOblPrimera.getInternalname() ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd3E136( ) ;
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
      if ( RcdFound136 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = chkLiqOblPrimera.getInternalname() ;
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
      if ( RcdFound136 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = chkLiqOblPrimera.getInternalname() ;
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
      scanStart3E136( ) ;
      if ( RcdFound136 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound136 != 0 )
         {
            scanNext3E136( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = chkLiqOblPrimera.getInternalname() ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd3E136( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency3E136( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T003E2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A1185LiqOblNuevaNro)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LiqLegObligacionCuenta"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z1186LiqOblPrimera != T003E2_A1186LiqOblPrimera[0] ) || ( GXutil.strcmp(Z1187LiqOblLog, T003E2_A1187LiqOblLog[0]) != 0 ) || ( DecimalUtil.compareTo(Z1188LiqOblCuota, T003E2_A1188LiqOblCuota[0]) != 0 ) || ( DecimalUtil.compareTo(Z1189LiqOblTotal, T003E2_A1189LiqOblTotal[0]) != 0 ) || ( DecimalUtil.compareTo(Z1190LiqOblTotRecal, T003E2_A1190LiqOblTotRecal[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1197LiqOblSaldo, T003E2_A1197LiqOblSaldo[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z1199LiqOblPeriodo), GXutil.resetTime(T003E2_A1199LiqOblPeriodo[0])) ) )
         {
            if ( Z1186LiqOblPrimera != T003E2_A1186LiqOblPrimera[0] )
            {
               GXutil.writeLogln("liqlegobligacioncuenta:[seudo value changed for attri]"+"LiqOblPrimera");
               GXutil.writeLogRaw("Old: ",Z1186LiqOblPrimera);
               GXutil.writeLogRaw("Current: ",T003E2_A1186LiqOblPrimera[0]);
            }
            if ( GXutil.strcmp(Z1187LiqOblLog, T003E2_A1187LiqOblLog[0]) != 0 )
            {
               GXutil.writeLogln("liqlegobligacioncuenta:[seudo value changed for attri]"+"LiqOblLog");
               GXutil.writeLogRaw("Old: ",Z1187LiqOblLog);
               GXutil.writeLogRaw("Current: ",T003E2_A1187LiqOblLog[0]);
            }
            if ( DecimalUtil.compareTo(Z1188LiqOblCuota, T003E2_A1188LiqOblCuota[0]) != 0 )
            {
               GXutil.writeLogln("liqlegobligacioncuenta:[seudo value changed for attri]"+"LiqOblCuota");
               GXutil.writeLogRaw("Old: ",Z1188LiqOblCuota);
               GXutil.writeLogRaw("Current: ",T003E2_A1188LiqOblCuota[0]);
            }
            if ( DecimalUtil.compareTo(Z1189LiqOblTotal, T003E2_A1189LiqOblTotal[0]) != 0 )
            {
               GXutil.writeLogln("liqlegobligacioncuenta:[seudo value changed for attri]"+"LiqOblTotal");
               GXutil.writeLogRaw("Old: ",Z1189LiqOblTotal);
               GXutil.writeLogRaw("Current: ",T003E2_A1189LiqOblTotal[0]);
            }
            if ( DecimalUtil.compareTo(Z1190LiqOblTotRecal, T003E2_A1190LiqOblTotRecal[0]) != 0 )
            {
               GXutil.writeLogln("liqlegobligacioncuenta:[seudo value changed for attri]"+"LiqOblTotRecal");
               GXutil.writeLogRaw("Old: ",Z1190LiqOblTotRecal);
               GXutil.writeLogRaw("Current: ",T003E2_A1190LiqOblTotRecal[0]);
            }
            if ( DecimalUtil.compareTo(Z1197LiqOblSaldo, T003E2_A1197LiqOblSaldo[0]) != 0 )
            {
               GXutil.writeLogln("liqlegobligacioncuenta:[seudo value changed for attri]"+"LiqOblSaldo");
               GXutil.writeLogRaw("Old: ",Z1197LiqOblSaldo);
               GXutil.writeLogRaw("Current: ",T003E2_A1197LiqOblSaldo[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z1199LiqOblPeriodo), GXutil.resetTime(T003E2_A1199LiqOblPeriodo[0])) ) )
            {
               GXutil.writeLogln("liqlegobligacioncuenta:[seudo value changed for attri]"+"LiqOblPeriodo");
               GXutil.writeLogRaw("Old: ",Z1199LiqOblPeriodo);
               GXutil.writeLogRaw("Current: ",T003E2_A1199LiqOblPeriodo[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LiqLegObligacionCuenta"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert3E136( )
   {
      beforeValidate3E136( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3E136( ) ;
      }
      if ( AnyError == 0 )
      {
         zm3E136( 0) ;
         checkOptimisticConcurrency3E136( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3E136( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert3E136( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003E14 */
                  pr_default.execute(12, new Object[] {Boolean.valueOf(A1186LiqOblPrimera), A1187LiqOblLog, A1188LiqOblCuota, A1189LiqOblTotal, A1190LiqOblTotRecal, A1197LiqOblSaldo, A1199LiqOblPeriodo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A1185LiqOblNuevaNro), Short.valueOf(A1172OblSecuencial)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegObligacionCuenta");
                  if ( (pr_default.getStatus(12) == 1) )
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
                        resetCaption3E0( ) ;
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
            load3E136( ) ;
         }
         endLevel3E136( ) ;
      }
      closeExtendedTableCursors3E136( ) ;
   }

   public void update3E136( )
   {
      beforeValidate3E136( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3E136( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3E136( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3E136( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate3E136( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003E15 */
                  pr_default.execute(13, new Object[] {Boolean.valueOf(A1186LiqOblPrimera), A1187LiqOblLog, A1188LiqOblCuota, A1189LiqOblTotal, A1190LiqOblTotRecal, A1197LiqOblSaldo, A1199LiqOblPeriodo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A1185LiqOblNuevaNro)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegObligacionCuenta");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LiqLegObligacionCuenta"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate3E136( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption3E0( ) ;
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
         endLevel3E136( ) ;
      }
      closeExtendedTableCursors3E136( ) ;
   }

   public void deferredUpdate3E136( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate3E136( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3E136( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls3E136( ) ;
         afterConfirm3E136( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete3E136( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T003E16 */
               pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A1185LiqOblNuevaNro)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegObligacionCuenta");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound136 == 0 )
                     {
                        initAll3E136( ) ;
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
                     resetCaption3E0( ) ;
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
      sMode136 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel3E136( ) ;
      Gx_mode = sMode136 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls3E136( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel3E136( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete3E136( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "liqlegobligacioncuenta");
         if ( AnyError == 0 )
         {
            confirmValues3E0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "liqlegobligacioncuenta");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart3E136( )
   {
      /* Using cursor T003E17 */
      pr_default.execute(15);
      RcdFound136 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound136 = (short)(1) ;
         A3CliCod = T003E17_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T003E17_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T003E17_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A1172OblSecuencial = T003E17_A1172OblSecuencial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
         A1184LiqOblAltaNro = T003E17_A1184LiqOblAltaNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1184LiqOblAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1184LiqOblAltaNro), 8, 0));
         A1185LiqOblNuevaNro = T003E17_A1185LiqOblNuevaNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1185LiqOblNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1185LiqOblNuevaNro), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext3E136( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound136 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound136 = (short)(1) ;
         A3CliCod = T003E17_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T003E17_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T003E17_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A1172OblSecuencial = T003E17_A1172OblSecuencial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
         A1184LiqOblAltaNro = T003E17_A1184LiqOblAltaNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1184LiqOblAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1184LiqOblAltaNro), 8, 0));
         A1185LiqOblNuevaNro = T003E17_A1185LiqOblNuevaNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1185LiqOblNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1185LiqOblNuevaNro), 8, 0));
      }
   }

   public void scanEnd3E136( )
   {
      pr_default.close(15);
   }

   public void afterConfirm3E136( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert3E136( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate3E136( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete3E136( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete3E136( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate3E136( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes3E136( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      edtOblSecuencial_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOblSecuencial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOblSecuencial_Enabled), 5, 0), true);
      edtLiqOblAltaNro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqOblAltaNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqOblAltaNro_Enabled), 5, 0), true);
      edtLiqOblNuevaNro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqOblNuevaNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqOblNuevaNro_Enabled), 5, 0), true);
      chkLiqOblPrimera.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkLiqOblPrimera.getInternalname(), "Enabled", GXutil.ltrimstr( chkLiqOblPrimera.getEnabled(), 5, 0), true);
      edtLiqOblLog_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqOblLog_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqOblLog_Enabled), 5, 0), true);
      edtLiqOblCuota_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqOblCuota_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqOblCuota_Enabled), 5, 0), true);
      edtLiqOblTotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqOblTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqOblTotal_Enabled), 5, 0), true);
      edtLiqOblTotRecal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqOblTotRecal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqOblTotRecal_Enabled), 5, 0), true);
      edtLiqOblSaldo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqOblSaldo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqOblSaldo_Enabled), 5, 0), true);
      edtLiqOblPeriodo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqOblPeriodo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqOblPeriodo_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes3E136( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues3E0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.liqlegobligacioncuenta", new String[] {}, new String[] {}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1172OblSecuencial", GXutil.ltrim( localUtil.ntoc( Z1172OblSecuencial, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1184LiqOblAltaNro", GXutil.ltrim( localUtil.ntoc( Z1184LiqOblAltaNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1185LiqOblNuevaNro", GXutil.ltrim( localUtil.ntoc( Z1185LiqOblNuevaNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1186LiqOblPrimera", Z1186LiqOblPrimera);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1187LiqOblLog", Z1187LiqOblLog);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1188LiqOblCuota", GXutil.ltrim( localUtil.ntoc( Z1188LiqOblCuota, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1189LiqOblTotal", GXutil.ltrim( localUtil.ntoc( Z1189LiqOblTotal, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1190LiqOblTotRecal", GXutil.ltrim( localUtil.ntoc( Z1190LiqOblTotRecal, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1197LiqOblSaldo", GXutil.ltrim( localUtil.ntoc( Z1197LiqOblSaldo, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1199LiqOblPeriodo", localUtil.dtoc( Z1199LiqOblPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
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
      return formatLink("web.liqlegobligacioncuenta", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "LiqLegObligacionCuenta" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Liq Leg Obligacion Cuenta", "") ;
   }

   public void initializeNonKey3E136( )
   {
      A31LiqNro = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
      A1186LiqOblPrimera = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1186LiqOblPrimera", A1186LiqOblPrimera);
      A1187LiqOblLog = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1187LiqOblLog", A1187LiqOblLog);
      A1188LiqOblCuota = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1188LiqOblCuota", GXutil.ltrimstr( A1188LiqOblCuota, 14, 2));
      A1189LiqOblTotal = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1189LiqOblTotal", GXutil.ltrimstr( A1189LiqOblTotal, 14, 2));
      A1190LiqOblTotRecal = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1190LiqOblTotRecal", GXutil.ltrimstr( A1190LiqOblTotRecal, 14, 2));
      A1197LiqOblSaldo = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1197LiqOblSaldo", GXutil.ltrimstr( A1197LiqOblSaldo, 14, 2));
      A1199LiqOblPeriodo = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A1199LiqOblPeriodo", localUtil.format(A1199LiqOblPeriodo, "99/99/9999"));
      Z1186LiqOblPrimera = false ;
      Z1187LiqOblLog = "" ;
      Z1188LiqOblCuota = DecimalUtil.ZERO ;
      Z1189LiqOblTotal = DecimalUtil.ZERO ;
      Z1190LiqOblTotRecal = DecimalUtil.ZERO ;
      Z1197LiqOblSaldo = DecimalUtil.ZERO ;
      Z1199LiqOblPeriodo = GXutil.nullDate() ;
   }

   public void initAll3E136( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A6LegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      A1172OblSecuencial = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1172OblSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1172OblSecuencial), 4, 0));
      A1184LiqOblAltaNro = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1184LiqOblAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1184LiqOblAltaNro), 8, 0));
      A1185LiqOblNuevaNro = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1185LiqOblNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1185LiqOblNuevaNro), 8, 0));
      initializeNonKey3E136( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025181753992", true, true);
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
      httpContext.AddJavascriptSource("liqlegobligacioncuenta.js", "?2025181753992", false, true);
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
      edtLegNumero_Internalname = "LEGNUMERO" ;
      edtOblSecuencial_Internalname = "OBLSECUENCIAL" ;
      edtLiqOblAltaNro_Internalname = "LIQOBLALTANRO" ;
      edtLiqOblNuevaNro_Internalname = "LIQOBLNUEVANRO" ;
      chkLiqOblPrimera.setInternalname( "LIQOBLPRIMERA" );
      edtLiqOblLog_Internalname = "LIQOBLLOG" ;
      edtLiqOblCuota_Internalname = "LIQOBLCUOTA" ;
      edtLiqOblTotal_Internalname = "LIQOBLTOTAL" ;
      edtLiqOblTotRecal_Internalname = "LIQOBLTOTRECAL" ;
      edtLiqOblSaldo_Internalname = "LIQOBLSALDO" ;
      edtLiqOblPeriodo_Internalname = "LIQOBLPERIODO" ;
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
      Form.setCaption( httpContext.getMessage( "Liq Leg Obligacion Cuenta", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtLiqOblPeriodo_Jsonclick = "" ;
      edtLiqOblPeriodo_Enabled = 1 ;
      edtLiqOblSaldo_Jsonclick = "" ;
      edtLiqOblSaldo_Enabled = 1 ;
      edtLiqOblTotRecal_Jsonclick = "" ;
      edtLiqOblTotRecal_Enabled = 1 ;
      edtLiqOblTotal_Jsonclick = "" ;
      edtLiqOblTotal_Enabled = 1 ;
      edtLiqOblCuota_Jsonclick = "" ;
      edtLiqOblCuota_Enabled = 1 ;
      edtLiqOblLog_Enabled = 1 ;
      chkLiqOblPrimera.setEnabled( 1 );
      edtLiqOblNuevaNro_Jsonclick = "" ;
      edtLiqOblNuevaNro_Enabled = 1 ;
      edtLiqOblAltaNro_Jsonclick = "" ;
      edtLiqOblAltaNro_Enabled = 1 ;
      edtOblSecuencial_Jsonclick = "" ;
      edtOblSecuencial_Enabled = 1 ;
      edtLegNumero_Jsonclick = "" ;
      edtLegNumero_Enabled = 1 ;
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
      chkLiqOblPrimera.setName( "LIQOBLPRIMERA" );
      chkLiqOblPrimera.setWebtags( "" );
      chkLiqOblPrimera.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkLiqOblPrimera.getInternalname(), "TitleCaption", chkLiqOblPrimera.getCaption(), true);
      chkLiqOblPrimera.setCheckedValue( "false" );
      A1186LiqOblPrimera = GXutil.strtobool( GXutil.booltostr( A1186LiqOblPrimera)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1186LiqOblPrimera", A1186LiqOblPrimera);
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      /* Using cursor T003E18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Obligacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLSECUENCIAL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(16);
      /* Using cursor T003E19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(17);
      /* Using cursor T003E20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1185LiqOblNuevaNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(18);
      GX_FocusControl = chkLiqOblPrimera.getInternalname() ;
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

   public void valid_Oblsecuencial( )
   {
      /* Using cursor T003E18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Obligacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLSECUENCIAL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(16);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Liqoblaltanro( )
   {
      /* Using cursor T003E19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(17);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Liqoblnuevanro( )
   {
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      /* Using cursor T003E20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1185LiqOblNuevaNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(18);
      dynload_actions( ) ;
      A1186LiqOblPrimera = GXutil.strtobool( GXutil.booltostr( A1186LiqOblPrimera)) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1186LiqOblPrimera", A1186LiqOblPrimera);
      httpContext.ajax_rsp_assign_attri("", false, "A1187LiqOblLog", A1187LiqOblLog);
      httpContext.ajax_rsp_assign_attri("", false, "A1188LiqOblCuota", GXutil.ltrim( localUtil.ntoc( A1188LiqOblCuota, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1189LiqOblTotal", GXutil.ltrim( localUtil.ntoc( A1189LiqOblTotal, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1190LiqOblTotRecal", GXutil.ltrim( localUtil.ntoc( A1190LiqOblTotRecal, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1197LiqOblSaldo", GXutil.ltrim( localUtil.ntoc( A1197LiqOblSaldo, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1199LiqOblPeriodo", localUtil.format(A1199LiqOblPeriodo, "99/99/9999"));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1172OblSecuencial", GXutil.ltrim( localUtil.ntoc( Z1172OblSecuencial, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1184LiqOblAltaNro", GXutil.ltrim( localUtil.ntoc( Z1184LiqOblAltaNro, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1185LiqOblNuevaNro", GXutil.ltrim( localUtil.ntoc( Z1185LiqOblNuevaNro, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z31LiqNro", GXutil.ltrim( localUtil.ntoc( Z31LiqNro, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1186LiqOblPrimera", GXutil.booltostr( Z1186LiqOblPrimera));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1187LiqOblLog", Z1187LiqOblLog);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1188LiqOblCuota", GXutil.ltrim( localUtil.ntoc( Z1188LiqOblCuota, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1189LiqOblTotal", GXutil.ltrim( localUtil.ntoc( Z1189LiqOblTotal, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1190LiqOblTotRecal", GXutil.ltrim( localUtil.ntoc( Z1190LiqOblTotRecal, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1197LiqOblSaldo", GXutil.ltrim( localUtil.ntoc( Z1197LiqOblSaldo, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1199LiqOblPeriodo", localUtil.format(Z1199LiqOblPeriodo, "99/99/9999"));
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'A1186LiqOblPrimera',fld:'LIQOBLPRIMERA',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A1186LiqOblPrimera',fld:'LIQOBLPRIMERA',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A1186LiqOblPrimera',fld:'LIQOBLPRIMERA',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A1186LiqOblPrimera',fld:'LIQOBLPRIMERA',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A1186LiqOblPrimera',fld:'LIQOBLPRIMERA',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A1186LiqOblPrimera',fld:'LIQOBLPRIMERA',pic:''}]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A1186LiqOblPrimera',fld:'LIQOBLPRIMERA',pic:''}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[{av:'A1186LiqOblPrimera',fld:'LIQOBLPRIMERA',pic:''}]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[{av:'A1186LiqOblPrimera',fld:'LIQOBLPRIMERA',pic:''}]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[{av:'A1186LiqOblPrimera',fld:'LIQOBLPRIMERA',pic:''}]}");
      setEventMetadata("VALID_OBLSECUENCIAL","{handler:'valid_Oblsecuencial',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A1172OblSecuencial',fld:'OBLSECUENCIAL',pic:'ZZZ9'},{av:'A1186LiqOblPrimera',fld:'LIQOBLPRIMERA',pic:''}]");
      setEventMetadata("VALID_OBLSECUENCIAL",",oparms:[{av:'A1186LiqOblPrimera',fld:'LIQOBLPRIMERA',pic:''}]}");
      setEventMetadata("VALID_LIQOBLALTANRO","{handler:'valid_Liqoblaltanro',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1184LiqOblAltaNro',fld:'LIQOBLALTANRO',pic:'ZZZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A1186LiqOblPrimera',fld:'LIQOBLPRIMERA',pic:''}]");
      setEventMetadata("VALID_LIQOBLALTANRO",",oparms:[{av:'A1186LiqOblPrimera',fld:'LIQOBLPRIMERA',pic:''}]}");
      setEventMetadata("VALID_LIQOBLNUEVANRO","{handler:'valid_Liqoblnuevanro',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A1172OblSecuencial',fld:'OBLSECUENCIAL',pic:'ZZZ9'},{av:'A1184LiqOblAltaNro',fld:'LIQOBLALTANRO',pic:'ZZZZZZZ9'},{av:'A1185LiqOblNuevaNro',fld:'LIQOBLNUEVANRO',pic:'ZZZZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'A1186LiqOblPrimera',fld:'LIQOBLPRIMERA',pic:''}]");
      setEventMetadata("VALID_LIQOBLNUEVANRO",",oparms:[{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'A1187LiqOblLog',fld:'LIQOBLLOG',pic:''},{av:'A1188LiqOblCuota',fld:'LIQOBLCUOTA',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1189LiqOblTotal',fld:'LIQOBLTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1190LiqOblTotRecal',fld:'LIQOBLTOTRECAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1197LiqOblSaldo',fld:'LIQOBLSALDO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1199LiqOblPeriodo',fld:'LIQOBLPERIODO',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z3CliCod'},{av:'Z1EmpCod'},{av:'Z6LegNumero'},{av:'Z1172OblSecuencial'},{av:'Z1184LiqOblAltaNro'},{av:'Z1185LiqOblNuevaNro'},{av:'Z31LiqNro'},{av:'Z1186LiqOblPrimera'},{av:'Z1187LiqOblLog'},{av:'Z1188LiqOblCuota'},{av:'Z1189LiqOblTotal'},{av:'Z1190LiqOblTotRecal'},{av:'Z1197LiqOblSaldo'},{av:'Z1199LiqOblPeriodo'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'},{av:'A1186LiqOblPrimera',fld:'LIQOBLPRIMERA',pic:''}]}");
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
      pr_default.close(18);
      pr_default.close(17);
      pr_default.close(16);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z1187LiqOblLog = "" ;
      Z1188LiqOblCuota = DecimalUtil.ZERO ;
      Z1189LiqOblTotal = DecimalUtil.ZERO ;
      Z1190LiqOblTotRecal = DecimalUtil.ZERO ;
      Z1197LiqOblSaldo = DecimalUtil.ZERO ;
      Z1199LiqOblPeriodo = GXutil.nullDate() ;
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
      A1187LiqOblLog = "" ;
      A1188LiqOblCuota = DecimalUtil.ZERO ;
      A1189LiqOblTotal = DecimalUtil.ZERO ;
      A1190LiqOblTotRecal = DecimalUtil.ZERO ;
      A1197LiqOblSaldo = DecimalUtil.ZERO ;
      A1199LiqOblPeriodo = GXutil.nullDate() ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gx_mode = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      T003E7_A1186LiqOblPrimera = new boolean[] {false} ;
      T003E7_A1187LiqOblLog = new String[] {""} ;
      T003E7_A1188LiqOblCuota = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003E7_A1189LiqOblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003E7_A1190LiqOblTotRecal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003E7_A1197LiqOblSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003E7_A1199LiqOblPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T003E7_A3CliCod = new int[1] ;
      T003E7_A1EmpCod = new short[1] ;
      T003E7_A6LegNumero = new int[1] ;
      T003E7_A1184LiqOblAltaNro = new int[1] ;
      T003E7_A1185LiqOblNuevaNro = new int[1] ;
      T003E7_A1172OblSecuencial = new short[1] ;
      T003E6_A3CliCod = new int[1] ;
      T003E4_A31LiqNro = new int[1] ;
      T003E5_A31LiqNro = new int[1] ;
      T003E8_A3CliCod = new int[1] ;
      T003E9_A31LiqNro = new int[1] ;
      T003E10_A31LiqNro = new int[1] ;
      T003E11_A3CliCod = new int[1] ;
      T003E11_A1EmpCod = new short[1] ;
      T003E11_A6LegNumero = new int[1] ;
      T003E11_A1172OblSecuencial = new short[1] ;
      T003E11_A1184LiqOblAltaNro = new int[1] ;
      T003E11_A1185LiqOblNuevaNro = new int[1] ;
      T003E3_A1186LiqOblPrimera = new boolean[] {false} ;
      T003E3_A1187LiqOblLog = new String[] {""} ;
      T003E3_A1188LiqOblCuota = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003E3_A1189LiqOblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003E3_A1190LiqOblTotRecal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003E3_A1197LiqOblSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003E3_A1199LiqOblPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T003E3_A3CliCod = new int[1] ;
      T003E3_A1EmpCod = new short[1] ;
      T003E3_A6LegNumero = new int[1] ;
      T003E3_A1184LiqOblAltaNro = new int[1] ;
      T003E3_A1185LiqOblNuevaNro = new int[1] ;
      T003E3_A1172OblSecuencial = new short[1] ;
      sMode136 = "" ;
      T003E12_A3CliCod = new int[1] ;
      T003E12_A1EmpCod = new short[1] ;
      T003E12_A6LegNumero = new int[1] ;
      T003E12_A1184LiqOblAltaNro = new int[1] ;
      T003E12_A1185LiqOblNuevaNro = new int[1] ;
      T003E12_A1172OblSecuencial = new short[1] ;
      T003E13_A3CliCod = new int[1] ;
      T003E13_A1EmpCod = new short[1] ;
      T003E13_A6LegNumero = new int[1] ;
      T003E13_A1184LiqOblAltaNro = new int[1] ;
      T003E13_A1185LiqOblNuevaNro = new int[1] ;
      T003E13_A1172OblSecuencial = new short[1] ;
      T003E2_A1186LiqOblPrimera = new boolean[] {false} ;
      T003E2_A1187LiqOblLog = new String[] {""} ;
      T003E2_A1188LiqOblCuota = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003E2_A1189LiqOblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003E2_A1190LiqOblTotRecal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003E2_A1197LiqOblSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003E2_A1199LiqOblPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T003E2_A3CliCod = new int[1] ;
      T003E2_A1EmpCod = new short[1] ;
      T003E2_A6LegNumero = new int[1] ;
      T003E2_A1184LiqOblAltaNro = new int[1] ;
      T003E2_A1185LiqOblNuevaNro = new int[1] ;
      T003E2_A1172OblSecuencial = new short[1] ;
      T003E17_A3CliCod = new int[1] ;
      T003E17_A1EmpCod = new short[1] ;
      T003E17_A6LegNumero = new int[1] ;
      T003E17_A1172OblSecuencial = new short[1] ;
      T003E17_A1184LiqOblAltaNro = new int[1] ;
      T003E17_A1185LiqOblNuevaNro = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T003E18_A3CliCod = new int[1] ;
      T003E19_A31LiqNro = new int[1] ;
      T003E20_A31LiqNro = new int[1] ;
      ZZ1187LiqOblLog = "" ;
      ZZ1188LiqOblCuota = DecimalUtil.ZERO ;
      ZZ1189LiqOblTotal = DecimalUtil.ZERO ;
      ZZ1190LiqOblTotRecal = DecimalUtil.ZERO ;
      ZZ1197LiqOblSaldo = DecimalUtil.ZERO ;
      ZZ1199LiqOblPeriodo = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liqlegobligacioncuenta__default(),
         new Object[] {
             new Object[] {
            T003E2_A1186LiqOblPrimera, T003E2_A1187LiqOblLog, T003E2_A1188LiqOblCuota, T003E2_A1189LiqOblTotal, T003E2_A1190LiqOblTotRecal, T003E2_A1197LiqOblSaldo, T003E2_A1199LiqOblPeriodo, T003E2_A3CliCod, T003E2_A1EmpCod, T003E2_A6LegNumero,
            T003E2_A1184LiqOblAltaNro, T003E2_A1185LiqOblNuevaNro, T003E2_A1172OblSecuencial
            }
            , new Object[] {
            T003E3_A1186LiqOblPrimera, T003E3_A1187LiqOblLog, T003E3_A1188LiqOblCuota, T003E3_A1189LiqOblTotal, T003E3_A1190LiqOblTotRecal, T003E3_A1197LiqOblSaldo, T003E3_A1199LiqOblPeriodo, T003E3_A3CliCod, T003E3_A1EmpCod, T003E3_A6LegNumero,
            T003E3_A1184LiqOblAltaNro, T003E3_A1185LiqOblNuevaNro, T003E3_A1172OblSecuencial
            }
            , new Object[] {
            T003E4_A31LiqNro
            }
            , new Object[] {
            T003E5_A31LiqNro
            }
            , new Object[] {
            T003E6_A3CliCod
            }
            , new Object[] {
            T003E7_A1186LiqOblPrimera, T003E7_A1187LiqOblLog, T003E7_A1188LiqOblCuota, T003E7_A1189LiqOblTotal, T003E7_A1190LiqOblTotRecal, T003E7_A1197LiqOblSaldo, T003E7_A1199LiqOblPeriodo, T003E7_A3CliCod, T003E7_A1EmpCod, T003E7_A6LegNumero,
            T003E7_A1184LiqOblAltaNro, T003E7_A1185LiqOblNuevaNro, T003E7_A1172OblSecuencial
            }
            , new Object[] {
            T003E8_A3CliCod
            }
            , new Object[] {
            T003E9_A31LiqNro
            }
            , new Object[] {
            T003E10_A31LiqNro
            }
            , new Object[] {
            T003E11_A3CliCod, T003E11_A1EmpCod, T003E11_A6LegNumero, T003E11_A1172OblSecuencial, T003E11_A1184LiqOblAltaNro, T003E11_A1185LiqOblNuevaNro
            }
            , new Object[] {
            T003E12_A3CliCod, T003E12_A1EmpCod, T003E12_A6LegNumero, T003E12_A1184LiqOblAltaNro, T003E12_A1185LiqOblNuevaNro, T003E12_A1172OblSecuencial
            }
            , new Object[] {
            T003E13_A3CliCod, T003E13_A1EmpCod, T003E13_A6LegNumero, T003E13_A1184LiqOblAltaNro, T003E13_A1185LiqOblNuevaNro, T003E13_A1172OblSecuencial
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T003E17_A3CliCod, T003E17_A1EmpCod, T003E17_A6LegNumero, T003E17_A1172OblSecuencial, T003E17_A1184LiqOblAltaNro, T003E17_A1185LiqOblNuevaNro
            }
            , new Object[] {
            T003E18_A3CliCod
            }
            , new Object[] {
            T003E19_A31LiqNro
            }
            , new Object[] {
            T003E20_A31LiqNro
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z1EmpCod ;
   private short Z1172OblSecuencial ;
   private short A1EmpCod ;
   private short A1172OblSecuencial ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound136 ;
   private short nIsDirty_136 ;
   private short ZZ1EmpCod ;
   private short ZZ1172OblSecuencial ;
   private int Z3CliCod ;
   private int Z6LegNumero ;
   private int Z1184LiqOblAltaNro ;
   private int Z1185LiqOblNuevaNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A1184LiqOblAltaNro ;
   private int A1185LiqOblNuevaNro ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Enabled ;
   private int edtLegNumero_Enabled ;
   private int edtOblSecuencial_Enabled ;
   private int edtLiqOblAltaNro_Enabled ;
   private int edtLiqOblNuevaNro_Enabled ;
   private int edtLiqOblLog_Enabled ;
   private int edtLiqOblCuota_Enabled ;
   private int edtLiqOblTotal_Enabled ;
   private int edtLiqOblTotRecal_Enabled ;
   private int edtLiqOblSaldo_Enabled ;
   private int edtLiqOblPeriodo_Enabled ;
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
   private int ZZ1184LiqOblAltaNro ;
   private int ZZ1185LiqOblNuevaNro ;
   private int ZZ31LiqNro ;
   private java.math.BigDecimal Z1188LiqOblCuota ;
   private java.math.BigDecimal Z1189LiqOblTotal ;
   private java.math.BigDecimal Z1190LiqOblTotRecal ;
   private java.math.BigDecimal Z1197LiqOblSaldo ;
   private java.math.BigDecimal A1188LiqOblCuota ;
   private java.math.BigDecimal A1189LiqOblTotal ;
   private java.math.BigDecimal A1190LiqOblTotRecal ;
   private java.math.BigDecimal A1197LiqOblSaldo ;
   private java.math.BigDecimal ZZ1188LiqOblCuota ;
   private java.math.BigDecimal ZZ1189LiqOblTotal ;
   private java.math.BigDecimal ZZ1190LiqOblTotRecal ;
   private java.math.BigDecimal ZZ1197LiqOblSaldo ;
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
   private String edtLegNumero_Internalname ;
   private String edtLegNumero_Jsonclick ;
   private String edtOblSecuencial_Internalname ;
   private String edtOblSecuencial_Jsonclick ;
   private String edtLiqOblAltaNro_Internalname ;
   private String edtLiqOblAltaNro_Jsonclick ;
   private String edtLiqOblNuevaNro_Internalname ;
   private String edtLiqOblNuevaNro_Jsonclick ;
   private String edtLiqOblLog_Internalname ;
   private String edtLiqOblCuota_Internalname ;
   private String edtLiqOblCuota_Jsonclick ;
   private String edtLiqOblTotal_Internalname ;
   private String edtLiqOblTotal_Jsonclick ;
   private String edtLiqOblTotRecal_Internalname ;
   private String edtLiqOblTotRecal_Jsonclick ;
   private String edtLiqOblSaldo_Internalname ;
   private String edtLiqOblSaldo_Jsonclick ;
   private String edtLiqOblPeriodo_Internalname ;
   private String edtLiqOblPeriodo_Jsonclick ;
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
   private String sMode136 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date Z1199LiqOblPeriodo ;
   private java.util.Date A1199LiqOblPeriodo ;
   private java.util.Date ZZ1199LiqOblPeriodo ;
   private boolean Z1186LiqOblPrimera ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A1186LiqOblPrimera ;
   private boolean Gx_longc ;
   private boolean ZZ1186LiqOblPrimera ;
   private String Z1187LiqOblLog ;
   private String A1187LiqOblLog ;
   private String ZZ1187LiqOblLog ;
   private ICheckbox chkLiqOblPrimera ;
   private IDataStoreProvider pr_default ;
   private boolean[] T003E7_A1186LiqOblPrimera ;
   private String[] T003E7_A1187LiqOblLog ;
   private java.math.BigDecimal[] T003E7_A1188LiqOblCuota ;
   private java.math.BigDecimal[] T003E7_A1189LiqOblTotal ;
   private java.math.BigDecimal[] T003E7_A1190LiqOblTotRecal ;
   private java.math.BigDecimal[] T003E7_A1197LiqOblSaldo ;
   private java.util.Date[] T003E7_A1199LiqOblPeriodo ;
   private int[] T003E7_A3CliCod ;
   private short[] T003E7_A1EmpCod ;
   private int[] T003E7_A6LegNumero ;
   private int[] T003E7_A1184LiqOblAltaNro ;
   private int[] T003E7_A1185LiqOblNuevaNro ;
   private short[] T003E7_A1172OblSecuencial ;
   private int[] T003E6_A3CliCod ;
   private int[] T003E4_A31LiqNro ;
   private int[] T003E5_A31LiqNro ;
   private int[] T003E8_A3CliCod ;
   private int[] T003E9_A31LiqNro ;
   private int[] T003E10_A31LiqNro ;
   private int[] T003E11_A3CliCod ;
   private short[] T003E11_A1EmpCod ;
   private int[] T003E11_A6LegNumero ;
   private short[] T003E11_A1172OblSecuencial ;
   private int[] T003E11_A1184LiqOblAltaNro ;
   private int[] T003E11_A1185LiqOblNuevaNro ;
   private boolean[] T003E3_A1186LiqOblPrimera ;
   private String[] T003E3_A1187LiqOblLog ;
   private java.math.BigDecimal[] T003E3_A1188LiqOblCuota ;
   private java.math.BigDecimal[] T003E3_A1189LiqOblTotal ;
   private java.math.BigDecimal[] T003E3_A1190LiqOblTotRecal ;
   private java.math.BigDecimal[] T003E3_A1197LiqOblSaldo ;
   private java.util.Date[] T003E3_A1199LiqOblPeriodo ;
   private int[] T003E3_A3CliCod ;
   private short[] T003E3_A1EmpCod ;
   private int[] T003E3_A6LegNumero ;
   private int[] T003E3_A1184LiqOblAltaNro ;
   private int[] T003E3_A1185LiqOblNuevaNro ;
   private short[] T003E3_A1172OblSecuencial ;
   private int[] T003E12_A3CliCod ;
   private short[] T003E12_A1EmpCod ;
   private int[] T003E12_A6LegNumero ;
   private int[] T003E12_A1184LiqOblAltaNro ;
   private int[] T003E12_A1185LiqOblNuevaNro ;
   private short[] T003E12_A1172OblSecuencial ;
   private int[] T003E13_A3CliCod ;
   private short[] T003E13_A1EmpCod ;
   private int[] T003E13_A6LegNumero ;
   private int[] T003E13_A1184LiqOblAltaNro ;
   private int[] T003E13_A1185LiqOblNuevaNro ;
   private short[] T003E13_A1172OblSecuencial ;
   private boolean[] T003E2_A1186LiqOblPrimera ;
   private String[] T003E2_A1187LiqOblLog ;
   private java.math.BigDecimal[] T003E2_A1188LiqOblCuota ;
   private java.math.BigDecimal[] T003E2_A1189LiqOblTotal ;
   private java.math.BigDecimal[] T003E2_A1190LiqOblTotRecal ;
   private java.math.BigDecimal[] T003E2_A1197LiqOblSaldo ;
   private java.util.Date[] T003E2_A1199LiqOblPeriodo ;
   private int[] T003E2_A3CliCod ;
   private short[] T003E2_A1EmpCod ;
   private int[] T003E2_A6LegNumero ;
   private int[] T003E2_A1184LiqOblAltaNro ;
   private int[] T003E2_A1185LiqOblNuevaNro ;
   private short[] T003E2_A1172OblSecuencial ;
   private int[] T003E17_A3CliCod ;
   private short[] T003E17_A1EmpCod ;
   private int[] T003E17_A6LegNumero ;
   private short[] T003E17_A1172OblSecuencial ;
   private int[] T003E17_A1184LiqOblAltaNro ;
   private int[] T003E17_A1185LiqOblNuevaNro ;
   private int[] T003E18_A3CliCod ;
   private int[] T003E19_A31LiqNro ;
   private int[] T003E20_A31LiqNro ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class liqlegobligacioncuenta__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T003E2", "SELECT LiqOblPrimera, LiqOblLog, LiqOblCuota, LiqOblTotal, LiqOblTotRecal, LiqOblSaldo, LiqOblPeriodo, CliCod, EmpCod, LegNumero, LiqOblAltaNro, LiqOblNuevaNro, OblSecuencial FROM LiqLegObligacionCuenta WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND LiqOblAltaNro = ? AND LiqOblNuevaNro = ?  FOR UPDATE OF LiqLegObligacionCuenta NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003E3", "SELECT LiqOblPrimera, LiqOblLog, LiqOblCuota, LiqOblTotal, LiqOblTotRecal, LiqOblSaldo, LiqOblPeriodo, CliCod, EmpCod, LegNumero, LiqOblAltaNro, LiqOblNuevaNro, OblSecuencial FROM LiqLegObligacionCuenta WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND LiqOblAltaNro = ? AND LiqOblNuevaNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003E4", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003E5", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003E6", "SELECT CliCod FROM Obligacion WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003E7", "SELECT TM1.LiqOblPrimera, TM1.LiqOblLog, TM1.LiqOblCuota, TM1.LiqOblTotal, TM1.LiqOblTotRecal, TM1.LiqOblSaldo, TM1.LiqOblPeriodo, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LiqOblAltaNro, TM1.LiqOblNuevaNro, TM1.OblSecuencial FROM LiqLegObligacionCuenta TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.LiqOblAltaNro = ? and TM1.LiqOblNuevaNro = ? and TM1.OblSecuencial = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.OblSecuencial, TM1.LiqOblAltaNro, TM1.LiqOblNuevaNro ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003E8", "SELECT CliCod FROM Obligacion WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003E9", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003E10", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003E11", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro FROM LiqLegObligacionCuenta WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND LiqOblAltaNro = ? AND LiqOblNuevaNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003E12", "SELECT CliCod, EmpCod, LegNumero, LiqOblAltaNro, LiqOblNuevaNro, OblSecuencial FROM LiqLegObligacionCuenta WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and LegNumero > ? or LegNumero = ? and EmpCod = ? and CliCod = ? and LiqOblAltaNro > ? or LiqOblAltaNro = ? and LegNumero = ? and EmpCod = ? and CliCod = ? and LiqOblNuevaNro > ? or LiqOblNuevaNro = ? and LiqOblAltaNro = ? and LegNumero = ? and EmpCod = ? and CliCod = ? and OblSecuencial > ?) ORDER BY CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003E13", "SELECT CliCod, EmpCod, LegNumero, LiqOblAltaNro, LiqOblNuevaNro, OblSecuencial FROM LiqLegObligacionCuenta WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and LegNumero < ? or LegNumero = ? and EmpCod = ? and CliCod = ? and LiqOblAltaNro < ? or LiqOblAltaNro = ? and LegNumero = ? and EmpCod = ? and CliCod = ? and LiqOblNuevaNro < ? or LiqOblNuevaNro = ? and LiqOblAltaNro = ? and LegNumero = ? and EmpCod = ? and CliCod = ? and OblSecuencial < ?) ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, OblSecuencial DESC, LiqOblAltaNro DESC, LiqOblNuevaNro DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T003E14", "SAVEPOINT gxupdate;INSERT INTO LiqLegObligacionCuenta(LiqOblPrimera, LiqOblLog, LiqOblCuota, LiqOblTotal, LiqOblTotRecal, LiqOblSaldo, LiqOblPeriodo, CliCod, EmpCod, LegNumero, LiqOblAltaNro, LiqOblNuevaNro, OblSecuencial) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003E15", "SAVEPOINT gxupdate;UPDATE LiqLegObligacionCuenta SET LiqOblPrimera=?, LiqOblLog=?, LiqOblCuota=?, LiqOblTotal=?, LiqOblTotRecal=?, LiqOblSaldo=?, LiqOblPeriodo=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND LiqOblAltaNro = ? AND LiqOblNuevaNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003E16", "SAVEPOINT gxupdate;DELETE FROM LiqLegObligacionCuenta  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND LiqOblAltaNro = ? AND LiqOblNuevaNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003E17", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro FROM LiqLegObligacionCuenta ORDER BY CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003E18", "SELECT CliCod FROM Obligacion WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003E19", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003E20", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               return;
            case 1 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 18 :
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 10 :
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
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setInt(12, ((Number) parms[11]).intValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setInt(15, ((Number) parms[14]).intValue());
               stmt.setInt(16, ((Number) parms[15]).intValue());
               stmt.setInt(17, ((Number) parms[16]).intValue());
               stmt.setInt(18, ((Number) parms[17]).intValue());
               stmt.setShort(19, ((Number) parms[18]).shortValue());
               stmt.setInt(20, ((Number) parms[19]).intValue());
               stmt.setShort(21, ((Number) parms[20]).shortValue());
               return;
            case 11 :
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
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setInt(12, ((Number) parms[11]).intValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setInt(15, ((Number) parms[14]).intValue());
               stmt.setInt(16, ((Number) parms[15]).intValue());
               stmt.setInt(17, ((Number) parms[16]).intValue());
               stmt.setInt(18, ((Number) parms[17]).intValue());
               stmt.setShort(19, ((Number) parms[18]).shortValue());
               stmt.setInt(20, ((Number) parms[19]).intValue());
               stmt.setShort(21, ((Number) parms[20]).shortValue());
               return;
            case 12 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setVarchar(2, (String)parms[1], 1000, false);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setDate(7, (java.util.Date)parms[6]);
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setInt(12, ((Number) parms[11]).intValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               return;
            case 13 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setVarchar(2, (String)parms[1], 1000, false);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setDate(7, (java.util.Date)parms[6]);
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setInt(12, ((Number) parms[11]).intValue());
               stmt.setInt(13, ((Number) parms[12]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

