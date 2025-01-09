package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class f1357leg_impl extends GXDataArea
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
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A784F1357CTipoPre = (byte)(GXutil.lval( httpContext.GetPar( "F1357CTipoPre"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = httpContext.GetPar( "F1357CPer") ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = (byte)(GXutil.lval( httpContext.GetPar( "F1357CSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_5( A3CliCod, A1EmpCod, A784F1357CTipoPre, A777F1357CPer, A778F1357CSec) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "F1357 Leg", ""), (short)(0)) ;
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

   public f1357leg_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public f1357leg_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357leg_impl.class ));
   }

   public f1357leg_impl( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbF1357CTipoPre = new HTMLChoice();
      cmbF1357LBeneficio = new HTMLChoice();
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
      if ( cmbF1357LBeneficio.getItemCount() > 0 )
      {
         A791F1357LBeneficio = (byte)(GXutil.lval( cmbF1357LBeneficio.getValidValue(GXutil.trim( GXutil.str( A791F1357LBeneficio, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A791F1357LBeneficio", GXutil.str( A791F1357LBeneficio, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbF1357LBeneficio.setValue( GXutil.trim( GXutil.str( A791F1357LBeneficio, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbF1357LBeneficio.getInternalname(), "Values", cmbF1357LBeneficio.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "F1357 Leg", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_F1357Leg.htm");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_F1357Leg.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357Leg.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbF1357CTipoPre.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbF1357CTipoPre.getInternalname(), httpContext.getMessage( "F1357 CTipo Pre", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbF1357CTipoPre, cmbF1357CTipoPre.getInternalname(), GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0)), 1, cmbF1357CTipoPre.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbF1357CTipoPre.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", "", true, (byte)(0), "HLP_F1357Leg.htm");
      cmbF1357CTipoPre.setValue( GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbF1357CTipoPre.getInternalname(), "Values", cmbF1357CTipoPre.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357CPer_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357CPer_Internalname, httpContext.getMessage( "Periodo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CPer_Internalname, GXutil.rtrim( A777F1357CPer), GXutil.rtrim( localUtil.format( A777F1357CPer, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CPer_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357CPer_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357CSec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357CSec_Internalname, httpContext.getMessage( "Secuencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CSec_Internalname, GXutil.ltrim( localUtil.ntoc( A778F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357CSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A778F1357CSec), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A778F1357CSec), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357CSec_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357Leg.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegNumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LTipoReg_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LTipoReg_Internalname, httpContext.getMessage( "LTipo Reg", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LTipoReg_Internalname, GXutil.rtrim( A786F1357LTipoReg), GXutil.rtrim( localUtil.format( A786F1357LTipoReg, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LTipoReg_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LTipoReg_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LCuil_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LCuil_Internalname, httpContext.getMessage( "Cuil", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LCuil_Internalname, GXutil.rtrim( A787F1357LCuil), GXutil.rtrim( localUtil.format( A787F1357LCuil, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LCuil_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LCuil_Enabled, 0, "text", "", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LPerDesd_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LPerDesd_Internalname, httpContext.getMessage( "Periodo desde", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LPerDesd_Internalname, GXutil.rtrim( A788F1357LPerDesd), GXutil.rtrim( localUtil.format( A788F1357LPerDesd, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LPerDesd_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LPerDesd_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LPerHas_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LPerHas_Internalname, httpContext.getMessage( "Periodo hasta", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LPerHas_Internalname, GXutil.rtrim( A789F1357LPerHas), GXutil.rtrim( localUtil.format( A789F1357LPerHas, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LPerHas_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LPerHas_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LMeses_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LMeses_Internalname, httpContext.getMessage( "Meses", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LMeses_Internalname, GXutil.rtrim( A790F1357LMeses), GXutil.rtrim( localUtil.format( A790F1357LMeses, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,84);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LMeses_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LMeses_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbF1357LBeneficio.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbF1357LBeneficio.getInternalname(), httpContext.getMessage( "Beneficio", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbF1357LBeneficio, cmbF1357LBeneficio.getInternalname(), GXutil.trim( GXutil.str( A791F1357LBeneficio, 1, 0)), 1, cmbF1357LBeneficio.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbF1357LBeneficio.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,89);\"", "", true, (byte)(0), "HLP_F1357Leg.htm");
      cmbF1357LBeneficio.setValue( GXutil.trim( GXutil.str( A791F1357LBeneficio, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbF1357LBeneficio.getInternalname(), "Values", cmbF1357LBeneficio.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LLargaDist_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LLargaDist_Internalname, httpContext.getMessage( "Larga distancia (No CT 40/1989)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LLargaDist_Internalname, GXutil.rtrim( A792F1357LLargaDist), GXutil.rtrim( localUtil.format( A792F1357LLargaDist, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,94);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LLargaDist_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LLargaDist_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LLey27424_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LLey27424_Internalname, httpContext.getMessage( "¿El trabajador posee el beneficio  promocional de la Ley Nro.  27.424?", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LLey27424_Internalname, GXutil.rtrim( A793F1357LLey27424), GXutil.rtrim( localUtil.format( A793F1357LLey27424, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,99);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LLey27424_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LLey27424_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357L27549_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357L27549_Internalname, httpContext.getMessage( "¿El trabajador posee el beneficio  de la Ley 27.718? ", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357L27549_Internalname, GXutil.rtrim( A794F1357L27549), GXutil.rtrim( localUtil.format( A794F1357L27549, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,104);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357L27549_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357L27549_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LTeletrabajo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LTeletrabajo_Internalname, httpContext.getMessage( "¿El trabajador labora bajo el  régimen de teletrabajo - Ley  27.555?", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LTeletrabajo_Internalname, GXutil.rtrim( A795F1357LTeletrabajo), GXutil.rtrim( localUtil.format( A795F1357LTeletrabajo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,109);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LTeletrabajo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LTeletrabajo_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LMilitar_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LMilitar_Internalname, httpContext.getMessage( "¿El trabajador es personal militar  en actividad - Ley 19.101? ", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 114,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LMilitar_Internalname, GXutil.rtrim( A796F1357LMilitar), GXutil.rtrim( localUtil.format( A796F1357LMilitar, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,114);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LMilitar_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LMilitar_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LLargaDistCT_40_1989_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LLargaDistCT_40_1989_Internalname, httpContext.getMessage( "¿El trabajador desarrolla la  actividad de transporte TERRESTRE de larga distancia  bajo el convenio 40/1989?", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 119,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LLargaDistCT_40_1989_Internalname, GXutil.rtrim( A943F1357LLargaDistCT_40_1989), GXutil.rtrim( localUtil.format( A943F1357LLargaDistCT_40_1989, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,119);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LLargaDistCT_40_1989_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LLargaDistCT_40_1989_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357Leg.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 124,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 126,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357Leg.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 128,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357Leg.htm");
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
         Z784F1357CTipoPre = (byte)(localUtil.ctol( httpContext.cgiGet( "Z784F1357CTipoPre"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z777F1357CPer = httpContext.cgiGet( "Z777F1357CPer") ;
         Z778F1357CSec = (byte)(localUtil.ctol( httpContext.cgiGet( "Z778F1357CSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "Z6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z786F1357LTipoReg = httpContext.cgiGet( "Z786F1357LTipoReg") ;
         Z787F1357LCuil = httpContext.cgiGet( "Z787F1357LCuil") ;
         Z788F1357LPerDesd = httpContext.cgiGet( "Z788F1357LPerDesd") ;
         Z789F1357LPerHas = httpContext.cgiGet( "Z789F1357LPerHas") ;
         Z790F1357LMeses = httpContext.cgiGet( "Z790F1357LMeses") ;
         Z791F1357LBeneficio = (byte)(localUtil.ctol( httpContext.cgiGet( "Z791F1357LBeneficio"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z792F1357LLargaDist = httpContext.cgiGet( "Z792F1357LLargaDist") ;
         Z793F1357LLey27424 = httpContext.cgiGet( "Z793F1357LLey27424") ;
         Z794F1357L27549 = httpContext.cgiGet( "Z794F1357L27549") ;
         Z795F1357LTeletrabajo = httpContext.cgiGet( "Z795F1357LTeletrabajo") ;
         Z796F1357LMilitar = httpContext.cgiGet( "Z796F1357LMilitar") ;
         Z943F1357LLargaDistCT_40_1989 = httpContext.cgiGet( "Z943F1357LLargaDistCT_40_1989") ;
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
         A786F1357LTipoReg = httpContext.cgiGet( edtF1357LTipoReg_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A786F1357LTipoReg", A786F1357LTipoReg);
         A787F1357LCuil = httpContext.cgiGet( edtF1357LCuil_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A787F1357LCuil", A787F1357LCuil);
         A788F1357LPerDesd = httpContext.cgiGet( edtF1357LPerDesd_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A788F1357LPerDesd", A788F1357LPerDesd);
         A789F1357LPerHas = httpContext.cgiGet( edtF1357LPerHas_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A789F1357LPerHas", A789F1357LPerHas);
         A790F1357LMeses = httpContext.cgiGet( edtF1357LMeses_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A790F1357LMeses", A790F1357LMeses);
         cmbF1357LBeneficio.setValue( httpContext.cgiGet( cmbF1357LBeneficio.getInternalname()) );
         A791F1357LBeneficio = (byte)(GXutil.lval( httpContext.cgiGet( cmbF1357LBeneficio.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A791F1357LBeneficio", GXutil.str( A791F1357LBeneficio, 1, 0));
         A792F1357LLargaDist = httpContext.cgiGet( edtF1357LLargaDist_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A792F1357LLargaDist", A792F1357LLargaDist);
         A793F1357LLey27424 = httpContext.cgiGet( edtF1357LLey27424_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A793F1357LLey27424", A793F1357LLey27424);
         A794F1357L27549 = httpContext.cgiGet( edtF1357L27549_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A794F1357L27549", A794F1357L27549);
         A795F1357LTeletrabajo = httpContext.cgiGet( edtF1357LTeletrabajo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A795F1357LTeletrabajo", A795F1357LTeletrabajo);
         A796F1357LMilitar = httpContext.cgiGet( edtF1357LMilitar_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A796F1357LMilitar", A796F1357LMilitar);
         A943F1357LLargaDistCT_40_1989 = httpContext.cgiGet( edtF1357LLargaDistCT_40_1989_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A943F1357LLargaDistCT_40_1989", A943F1357LLargaDistCT_40_1989);
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
            A784F1357CTipoPre = (byte)(GXutil.lval( httpContext.GetPar( "F1357CTipoPre"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
            A777F1357CPer = httpContext.GetPar( "F1357CPer") ;
            httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
            A778F1357CSec = (byte)(GXutil.lval( httpContext.GetPar( "F1357CSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
            A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A786F1357LTipoReg = httpContext.GetPar( "F1357LTipoReg") ;
            httpContext.ajax_rsp_assign_attri("", false, "A786F1357LTipoReg", A786F1357LTipoReg);
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
            initAll2G95( ) ;
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
      disableAttributes2G95( ) ;
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

   public void resetCaption2G0( )
   {
   }

   public void zm2G95( int GX_JID )
   {
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z787F1357LCuil = T002G3_A787F1357LCuil[0] ;
            Z788F1357LPerDesd = T002G3_A788F1357LPerDesd[0] ;
            Z789F1357LPerHas = T002G3_A789F1357LPerHas[0] ;
            Z790F1357LMeses = T002G3_A790F1357LMeses[0] ;
            Z791F1357LBeneficio = T002G3_A791F1357LBeneficio[0] ;
            Z792F1357LLargaDist = T002G3_A792F1357LLargaDist[0] ;
            Z793F1357LLey27424 = T002G3_A793F1357LLey27424[0] ;
            Z794F1357L27549 = T002G3_A794F1357L27549[0] ;
            Z795F1357LTeletrabajo = T002G3_A795F1357LTeletrabajo[0] ;
            Z796F1357LMilitar = T002G3_A796F1357LMilitar[0] ;
            Z943F1357LLargaDistCT_40_1989 = T002G3_A943F1357LLargaDistCT_40_1989[0] ;
         }
         else
         {
            Z787F1357LCuil = A787F1357LCuil ;
            Z788F1357LPerDesd = A788F1357LPerDesd ;
            Z789F1357LPerHas = A789F1357LPerHas ;
            Z790F1357LMeses = A790F1357LMeses ;
            Z791F1357LBeneficio = A791F1357LBeneficio ;
            Z792F1357LLargaDist = A792F1357LLargaDist ;
            Z793F1357LLey27424 = A793F1357LLey27424 ;
            Z794F1357L27549 = A794F1357L27549 ;
            Z795F1357LTeletrabajo = A795F1357LTeletrabajo ;
            Z796F1357LMilitar = A796F1357LMilitar ;
            Z943F1357LLargaDistCT_40_1989 = A943F1357LLargaDistCT_40_1989 ;
         }
      }
      if ( GX_JID == -3 )
      {
         Z786F1357LTipoReg = A786F1357LTipoReg ;
         Z787F1357LCuil = A787F1357LCuil ;
         Z788F1357LPerDesd = A788F1357LPerDesd ;
         Z789F1357LPerHas = A789F1357LPerHas ;
         Z790F1357LMeses = A790F1357LMeses ;
         Z791F1357LBeneficio = A791F1357LBeneficio ;
         Z792F1357LLargaDist = A792F1357LLargaDist ;
         Z793F1357LLey27424 = A793F1357LLey27424 ;
         Z794F1357L27549 = A794F1357L27549 ;
         Z795F1357LTeletrabajo = A795F1357LTeletrabajo ;
         Z796F1357LMilitar = A796F1357LMilitar ;
         Z943F1357LLargaDistCT_40_1989 = A943F1357LLargaDistCT_40_1989 ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z784F1357CTipoPre = A784F1357CTipoPre ;
         Z777F1357CPer = A777F1357CPer ;
         Z778F1357CSec = A778F1357CSec ;
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

   public void load2G95( )
   {
      /* Using cursor T002G6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A786F1357LTipoReg});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound95 = (short)(1) ;
         A787F1357LCuil = T002G6_A787F1357LCuil[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A787F1357LCuil", A787F1357LCuil);
         A788F1357LPerDesd = T002G6_A788F1357LPerDesd[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A788F1357LPerDesd", A788F1357LPerDesd);
         A789F1357LPerHas = T002G6_A789F1357LPerHas[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A789F1357LPerHas", A789F1357LPerHas);
         A790F1357LMeses = T002G6_A790F1357LMeses[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A790F1357LMeses", A790F1357LMeses);
         A791F1357LBeneficio = T002G6_A791F1357LBeneficio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A791F1357LBeneficio", GXutil.str( A791F1357LBeneficio, 1, 0));
         A792F1357LLargaDist = T002G6_A792F1357LLargaDist[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A792F1357LLargaDist", A792F1357LLargaDist);
         A793F1357LLey27424 = T002G6_A793F1357LLey27424[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A793F1357LLey27424", A793F1357LLey27424);
         A794F1357L27549 = T002G6_A794F1357L27549[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A794F1357L27549", A794F1357L27549);
         A795F1357LTeletrabajo = T002G6_A795F1357LTeletrabajo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A795F1357LTeletrabajo", A795F1357LTeletrabajo);
         A796F1357LMilitar = T002G6_A796F1357LMilitar[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A796F1357LMilitar", A796F1357LMilitar);
         A943F1357LLargaDistCT_40_1989 = T002G6_A943F1357LLargaDistCT_40_1989[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A943F1357LLargaDistCT_40_1989", A943F1357LLargaDistCT_40_1989);
         zm2G95( -3) ;
      }
      pr_default.close(4);
      onLoadActions2G95( ) ;
   }

   public void onLoadActions2G95( )
   {
   }

   public void checkExtendedTable2G95( )
   {
      nIsDirty_95 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      if ( ! ( ( A784F1357CTipoPre == 1 ) || ( A784F1357CTipoPre == 2 ) || ( A784F1357CTipoPre == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "F1357 CTipo Pre", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "F1357CTIPOPRE");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbF1357CTipoPre.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T002G5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Formulario F1357", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "F1357CSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
      /* Using cursor T002G4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( A791F1357LBeneficio == 1 ) || ( A791F1357LBeneficio == 2 ) || ( A791F1357LBeneficio == 3 ) || ( A791F1357LBeneficio == 4 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "32, 32] BENEFICIO ", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "F1357LBENEFICIO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbF1357LBeneficio.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors2G95( )
   {
      pr_default.close(3);
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_5( int A3CliCod ,
                         short A1EmpCod ,
                         byte A784F1357CTipoPre ,
                         String A777F1357CPer ,
                         byte A778F1357CSec )
   {
      /* Using cursor T002G7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Formulario F1357", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "F1357CSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_4( int A3CliCod ,
                         short A1EmpCod ,
                         int A6LegNumero )
   {
      /* Using cursor T002G8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
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

   public void getKey2G95( )
   {
      /* Using cursor T002G9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A786F1357LTipoReg});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound95 = (short)(1) ;
      }
      else
      {
         RcdFound95 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T002G3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A786F1357LTipoReg});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm2G95( 3) ;
         RcdFound95 = (short)(1) ;
         A786F1357LTipoReg = T002G3_A786F1357LTipoReg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A786F1357LTipoReg", A786F1357LTipoReg);
         A787F1357LCuil = T002G3_A787F1357LCuil[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A787F1357LCuil", A787F1357LCuil);
         A788F1357LPerDesd = T002G3_A788F1357LPerDesd[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A788F1357LPerDesd", A788F1357LPerDesd);
         A789F1357LPerHas = T002G3_A789F1357LPerHas[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A789F1357LPerHas", A789F1357LPerHas);
         A790F1357LMeses = T002G3_A790F1357LMeses[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A790F1357LMeses", A790F1357LMeses);
         A791F1357LBeneficio = T002G3_A791F1357LBeneficio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A791F1357LBeneficio", GXutil.str( A791F1357LBeneficio, 1, 0));
         A792F1357LLargaDist = T002G3_A792F1357LLargaDist[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A792F1357LLargaDist", A792F1357LLargaDist);
         A793F1357LLey27424 = T002G3_A793F1357LLey27424[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A793F1357LLey27424", A793F1357LLey27424);
         A794F1357L27549 = T002G3_A794F1357L27549[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A794F1357L27549", A794F1357L27549);
         A795F1357LTeletrabajo = T002G3_A795F1357LTeletrabajo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A795F1357LTeletrabajo", A795F1357LTeletrabajo);
         A796F1357LMilitar = T002G3_A796F1357LMilitar[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A796F1357LMilitar", A796F1357LMilitar);
         A943F1357LLargaDistCT_40_1989 = T002G3_A943F1357LLargaDistCT_40_1989[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A943F1357LLargaDistCT_40_1989", A943F1357LLargaDistCT_40_1989);
         A3CliCod = T002G3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002G3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T002G3_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A784F1357CTipoPre = T002G3_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002G3_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002G3_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z784F1357CTipoPre = A784F1357CTipoPre ;
         Z777F1357CPer = A777F1357CPer ;
         Z778F1357CSec = A778F1357CSec ;
         Z6LegNumero = A6LegNumero ;
         Z786F1357LTipoReg = A786F1357LTipoReg ;
         sMode95 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load2G95( ) ;
         if ( AnyError == 1 )
         {
            RcdFound95 = (short)(0) ;
            initializeNonKey2G95( ) ;
         }
         Gx_mode = sMode95 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound95 = (short)(0) ;
         initializeNonKey2G95( ) ;
         sMode95 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode95 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey2G95( ) ;
      if ( RcdFound95 == 0 )
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
      RcdFound95 = (short)(0) ;
      /* Using cursor T002G10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A784F1357CTipoPre), Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A777F1357CPer, A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A778F1357CSec), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A786F1357LTipoReg});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T002G10_A3CliCod[0] < A3CliCod ) || ( T002G10_A3CliCod[0] == A3CliCod ) && ( T002G10_A1EmpCod[0] < A1EmpCod ) || ( T002G10_A1EmpCod[0] == A1EmpCod ) && ( T002G10_A3CliCod[0] == A3CliCod ) && ( T002G10_A784F1357CTipoPre[0] < A784F1357CTipoPre ) || ( T002G10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002G10_A1EmpCod[0] == A1EmpCod ) && ( T002G10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002G10_A777F1357CPer[0], A777F1357CPer) < 0 ) || ( GXutil.strcmp(T002G10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002G10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002G10_A1EmpCod[0] == A1EmpCod ) && ( T002G10_A3CliCod[0] == A3CliCod ) && ( T002G10_A778F1357CSec[0] < A778F1357CSec ) || ( T002G10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002G10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002G10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002G10_A1EmpCod[0] == A1EmpCod ) && ( T002G10_A3CliCod[0] == A3CliCod ) && ( T002G10_A6LegNumero[0] < A6LegNumero ) || ( T002G10_A6LegNumero[0] == A6LegNumero ) && ( T002G10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002G10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002G10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002G10_A1EmpCod[0] == A1EmpCod ) && ( T002G10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002G10_A786F1357LTipoReg[0], A786F1357LTipoReg) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T002G10_A3CliCod[0] > A3CliCod ) || ( T002G10_A3CliCod[0] == A3CliCod ) && ( T002G10_A1EmpCod[0] > A1EmpCod ) || ( T002G10_A1EmpCod[0] == A1EmpCod ) && ( T002G10_A3CliCod[0] == A3CliCod ) && ( T002G10_A784F1357CTipoPre[0] > A784F1357CTipoPre ) || ( T002G10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002G10_A1EmpCod[0] == A1EmpCod ) && ( T002G10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002G10_A777F1357CPer[0], A777F1357CPer) > 0 ) || ( GXutil.strcmp(T002G10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002G10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002G10_A1EmpCod[0] == A1EmpCod ) && ( T002G10_A3CliCod[0] == A3CliCod ) && ( T002G10_A778F1357CSec[0] > A778F1357CSec ) || ( T002G10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002G10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002G10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002G10_A1EmpCod[0] == A1EmpCod ) && ( T002G10_A3CliCod[0] == A3CliCod ) && ( T002G10_A6LegNumero[0] > A6LegNumero ) || ( T002G10_A6LegNumero[0] == A6LegNumero ) && ( T002G10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002G10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002G10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002G10_A1EmpCod[0] == A1EmpCod ) && ( T002G10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002G10_A786F1357LTipoReg[0], A786F1357LTipoReg) > 0 ) ) )
         {
            A3CliCod = T002G10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002G10_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A784F1357CTipoPre = T002G10_A784F1357CTipoPre[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
            A777F1357CPer = T002G10_A777F1357CPer[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
            A778F1357CSec = T002G10_A778F1357CSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
            A6LegNumero = T002G10_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A786F1357LTipoReg = T002G10_A786F1357LTipoReg[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A786F1357LTipoReg", A786F1357LTipoReg);
            RcdFound95 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound95 = (short)(0) ;
      /* Using cursor T002G11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A784F1357CTipoPre), Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A777F1357CPer, A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A778F1357CSec), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A786F1357LTipoReg});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T002G11_A3CliCod[0] > A3CliCod ) || ( T002G11_A3CliCod[0] == A3CliCod ) && ( T002G11_A1EmpCod[0] > A1EmpCod ) || ( T002G11_A1EmpCod[0] == A1EmpCod ) && ( T002G11_A3CliCod[0] == A3CliCod ) && ( T002G11_A784F1357CTipoPre[0] > A784F1357CTipoPre ) || ( T002G11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002G11_A1EmpCod[0] == A1EmpCod ) && ( T002G11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002G11_A777F1357CPer[0], A777F1357CPer) > 0 ) || ( GXutil.strcmp(T002G11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002G11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002G11_A1EmpCod[0] == A1EmpCod ) && ( T002G11_A3CliCod[0] == A3CliCod ) && ( T002G11_A778F1357CSec[0] > A778F1357CSec ) || ( T002G11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002G11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002G11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002G11_A1EmpCod[0] == A1EmpCod ) && ( T002G11_A3CliCod[0] == A3CliCod ) && ( T002G11_A6LegNumero[0] > A6LegNumero ) || ( T002G11_A6LegNumero[0] == A6LegNumero ) && ( T002G11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002G11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002G11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002G11_A1EmpCod[0] == A1EmpCod ) && ( T002G11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002G11_A786F1357LTipoReg[0], A786F1357LTipoReg) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T002G11_A3CliCod[0] < A3CliCod ) || ( T002G11_A3CliCod[0] == A3CliCod ) && ( T002G11_A1EmpCod[0] < A1EmpCod ) || ( T002G11_A1EmpCod[0] == A1EmpCod ) && ( T002G11_A3CliCod[0] == A3CliCod ) && ( T002G11_A784F1357CTipoPre[0] < A784F1357CTipoPre ) || ( T002G11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002G11_A1EmpCod[0] == A1EmpCod ) && ( T002G11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002G11_A777F1357CPer[0], A777F1357CPer) < 0 ) || ( GXutil.strcmp(T002G11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002G11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002G11_A1EmpCod[0] == A1EmpCod ) && ( T002G11_A3CliCod[0] == A3CliCod ) && ( T002G11_A778F1357CSec[0] < A778F1357CSec ) || ( T002G11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002G11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002G11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002G11_A1EmpCod[0] == A1EmpCod ) && ( T002G11_A3CliCod[0] == A3CliCod ) && ( T002G11_A6LegNumero[0] < A6LegNumero ) || ( T002G11_A6LegNumero[0] == A6LegNumero ) && ( T002G11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002G11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002G11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002G11_A1EmpCod[0] == A1EmpCod ) && ( T002G11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002G11_A786F1357LTipoReg[0], A786F1357LTipoReg) < 0 ) ) )
         {
            A3CliCod = T002G11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002G11_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A784F1357CTipoPre = T002G11_A784F1357CTipoPre[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
            A777F1357CPer = T002G11_A777F1357CPer[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
            A778F1357CSec = T002G11_A778F1357CSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
            A6LegNumero = T002G11_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A786F1357LTipoReg = T002G11_A786F1357LTipoReg[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A786F1357LTipoReg", A786F1357LTipoReg);
            RcdFound95 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2G95( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert2G95( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound95 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A786F1357LTipoReg, Z786F1357LTipoReg) != 0 ) )
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
               A6LegNumero = Z6LegNumero ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A786F1357LTipoReg = Z786F1357LTipoReg ;
               httpContext.ajax_rsp_assign_attri("", false, "A786F1357LTipoReg", A786F1357LTipoReg);
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
               update2G95( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A786F1357LTipoReg, Z786F1357LTipoReg) != 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert2G95( ) ;
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
                  insert2G95( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A786F1357LTipoReg, Z786F1357LTipoReg) != 0 ) )
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
         A6LegNumero = Z6LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A786F1357LTipoReg = Z786F1357LTipoReg ;
         httpContext.ajax_rsp_assign_attri("", false, "A786F1357LTipoReg", A786F1357LTipoReg);
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
      if ( RcdFound95 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtF1357LCuil_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart2G95( ) ;
      if ( RcdFound95 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtF1357LCuil_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd2G95( ) ;
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
      if ( RcdFound95 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtF1357LCuil_Internalname ;
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
      if ( RcdFound95 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtF1357LCuil_Internalname ;
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
      scanStart2G95( ) ;
      if ( RcdFound95 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound95 != 0 )
         {
            scanNext2G95( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtF1357LCuil_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd2G95( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency2G95( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002G2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A786F1357LTipoReg});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"F1357Leg"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z787F1357LCuil, T002G2_A787F1357LCuil[0]) != 0 ) || ( GXutil.strcmp(Z788F1357LPerDesd, T002G2_A788F1357LPerDesd[0]) != 0 ) || ( GXutil.strcmp(Z789F1357LPerHas, T002G2_A789F1357LPerHas[0]) != 0 ) || ( GXutil.strcmp(Z790F1357LMeses, T002G2_A790F1357LMeses[0]) != 0 ) || ( Z791F1357LBeneficio != T002G2_A791F1357LBeneficio[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z792F1357LLargaDist, T002G2_A792F1357LLargaDist[0]) != 0 ) || ( GXutil.strcmp(Z793F1357LLey27424, T002G2_A793F1357LLey27424[0]) != 0 ) || ( GXutil.strcmp(Z794F1357L27549, T002G2_A794F1357L27549[0]) != 0 ) || ( GXutil.strcmp(Z795F1357LTeletrabajo, T002G2_A795F1357LTeletrabajo[0]) != 0 ) || ( GXutil.strcmp(Z796F1357LMilitar, T002G2_A796F1357LMilitar[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z943F1357LLargaDistCT_40_1989, T002G2_A943F1357LLargaDistCT_40_1989[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z787F1357LCuil, T002G2_A787F1357LCuil[0]) != 0 )
            {
               GXutil.writeLogln("f1357leg:[seudo value changed for attri]"+"F1357LCuil");
               GXutil.writeLogRaw("Old: ",Z787F1357LCuil);
               GXutil.writeLogRaw("Current: ",T002G2_A787F1357LCuil[0]);
            }
            if ( GXutil.strcmp(Z788F1357LPerDesd, T002G2_A788F1357LPerDesd[0]) != 0 )
            {
               GXutil.writeLogln("f1357leg:[seudo value changed for attri]"+"F1357LPerDesd");
               GXutil.writeLogRaw("Old: ",Z788F1357LPerDesd);
               GXutil.writeLogRaw("Current: ",T002G2_A788F1357LPerDesd[0]);
            }
            if ( GXutil.strcmp(Z789F1357LPerHas, T002G2_A789F1357LPerHas[0]) != 0 )
            {
               GXutil.writeLogln("f1357leg:[seudo value changed for attri]"+"F1357LPerHas");
               GXutil.writeLogRaw("Old: ",Z789F1357LPerHas);
               GXutil.writeLogRaw("Current: ",T002G2_A789F1357LPerHas[0]);
            }
            if ( GXutil.strcmp(Z790F1357LMeses, T002G2_A790F1357LMeses[0]) != 0 )
            {
               GXutil.writeLogln("f1357leg:[seudo value changed for attri]"+"F1357LMeses");
               GXutil.writeLogRaw("Old: ",Z790F1357LMeses);
               GXutil.writeLogRaw("Current: ",T002G2_A790F1357LMeses[0]);
            }
            if ( Z791F1357LBeneficio != T002G2_A791F1357LBeneficio[0] )
            {
               GXutil.writeLogln("f1357leg:[seudo value changed for attri]"+"F1357LBeneficio");
               GXutil.writeLogRaw("Old: ",Z791F1357LBeneficio);
               GXutil.writeLogRaw("Current: ",T002G2_A791F1357LBeneficio[0]);
            }
            if ( GXutil.strcmp(Z792F1357LLargaDist, T002G2_A792F1357LLargaDist[0]) != 0 )
            {
               GXutil.writeLogln("f1357leg:[seudo value changed for attri]"+"F1357LLargaDist");
               GXutil.writeLogRaw("Old: ",Z792F1357LLargaDist);
               GXutil.writeLogRaw("Current: ",T002G2_A792F1357LLargaDist[0]);
            }
            if ( GXutil.strcmp(Z793F1357LLey27424, T002G2_A793F1357LLey27424[0]) != 0 )
            {
               GXutil.writeLogln("f1357leg:[seudo value changed for attri]"+"F1357LLey27424");
               GXutil.writeLogRaw("Old: ",Z793F1357LLey27424);
               GXutil.writeLogRaw("Current: ",T002G2_A793F1357LLey27424[0]);
            }
            if ( GXutil.strcmp(Z794F1357L27549, T002G2_A794F1357L27549[0]) != 0 )
            {
               GXutil.writeLogln("f1357leg:[seudo value changed for attri]"+"F1357L27549");
               GXutil.writeLogRaw("Old: ",Z794F1357L27549);
               GXutil.writeLogRaw("Current: ",T002G2_A794F1357L27549[0]);
            }
            if ( GXutil.strcmp(Z795F1357LTeletrabajo, T002G2_A795F1357LTeletrabajo[0]) != 0 )
            {
               GXutil.writeLogln("f1357leg:[seudo value changed for attri]"+"F1357LTeletrabajo");
               GXutil.writeLogRaw("Old: ",Z795F1357LTeletrabajo);
               GXutil.writeLogRaw("Current: ",T002G2_A795F1357LTeletrabajo[0]);
            }
            if ( GXutil.strcmp(Z796F1357LMilitar, T002G2_A796F1357LMilitar[0]) != 0 )
            {
               GXutil.writeLogln("f1357leg:[seudo value changed for attri]"+"F1357LMilitar");
               GXutil.writeLogRaw("Old: ",Z796F1357LMilitar);
               GXutil.writeLogRaw("Current: ",T002G2_A796F1357LMilitar[0]);
            }
            if ( GXutil.strcmp(Z943F1357LLargaDistCT_40_1989, T002G2_A943F1357LLargaDistCT_40_1989[0]) != 0 )
            {
               GXutil.writeLogln("f1357leg:[seudo value changed for attri]"+"F1357LLargaDistCT_40_1989");
               GXutil.writeLogRaw("Old: ",Z943F1357LLargaDistCT_40_1989);
               GXutil.writeLogRaw("Current: ",T002G2_A943F1357LLargaDistCT_40_1989[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"F1357Leg"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2G95( )
   {
      beforeValidate2G95( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2G95( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2G95( 0) ;
         checkOptimisticConcurrency2G95( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2G95( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2G95( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002G12 */
                  pr_default.execute(10, new Object[] {A786F1357LTipoReg, A787F1357LCuil, A788F1357LPerDesd, A789F1357LPerHas, A790F1357LMeses, Byte.valueOf(A791F1357LBeneficio), A792F1357LLargaDist, A793F1357LLey27424, A794F1357L27549, A795F1357LTeletrabajo, A796F1357LMilitar, A943F1357LLargaDistCT_40_1989, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357Leg");
                  if ( (pr_default.getStatus(10) == 1) )
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
                        resetCaption2G0( ) ;
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
            load2G95( ) ;
         }
         endLevel2G95( ) ;
      }
      closeExtendedTableCursors2G95( ) ;
   }

   public void update2G95( )
   {
      beforeValidate2G95( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2G95( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2G95( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2G95( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2G95( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002G13 */
                  pr_default.execute(11, new Object[] {A787F1357LCuil, A788F1357LPerDesd, A789F1357LPerHas, A790F1357LMeses, Byte.valueOf(A791F1357LBeneficio), A792F1357LLargaDist, A793F1357LLey27424, A794F1357L27549, A795F1357LTeletrabajo, A796F1357LMilitar, A943F1357LLargaDistCT_40_1989, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A786F1357LTipoReg});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357Leg");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"F1357Leg"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2G95( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption2G0( ) ;
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
         endLevel2G95( ) ;
      }
      closeExtendedTableCursors2G95( ) ;
   }

   public void deferredUpdate2G95( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate2G95( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2G95( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2G95( ) ;
         afterConfirm2G95( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2G95( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002G14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A786F1357LTipoReg});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357Leg");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound95 == 0 )
                     {
                        initAll2G95( ) ;
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
                     resetCaption2G0( ) ;
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
      sMode95 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2G95( ) ;
      Gx_mode = sMode95 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2G95( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel2G95( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2G95( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "f1357leg");
         if ( AnyError == 0 )
         {
            confirmValues2G0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "f1357leg");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2G95( )
   {
      /* Using cursor T002G15 */
      pr_default.execute(13);
      RcdFound95 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound95 = (short)(1) ;
         A3CliCod = T002G15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002G15_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A784F1357CTipoPre = T002G15_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002G15_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002G15_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         A6LegNumero = T002G15_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A786F1357LTipoReg = T002G15_A786F1357LTipoReg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A786F1357LTipoReg", A786F1357LTipoReg);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2G95( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound95 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound95 = (short)(1) ;
         A3CliCod = T002G15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002G15_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A784F1357CTipoPre = T002G15_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002G15_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002G15_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         A6LegNumero = T002G15_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A786F1357LTipoReg = T002G15_A786F1357LTipoReg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A786F1357LTipoReg", A786F1357LTipoReg);
      }
   }

   public void scanEnd2G95( )
   {
      pr_default.close(13);
   }

   public void afterConfirm2G95( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2G95( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2G95( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2G95( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2G95( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2G95( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2G95( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      cmbF1357CTipoPre.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbF1357CTipoPre.getInternalname(), "Enabled", GXutil.ltrimstr( cmbF1357CTipoPre.getEnabled(), 5, 0), true);
      edtF1357CPer_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357CPer_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CPer_Enabled), 5, 0), true);
      edtF1357CSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357CSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CSec_Enabled), 5, 0), true);
      edtLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      edtF1357LTipoReg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LTipoReg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LTipoReg_Enabled), 5, 0), true);
      edtF1357LCuil_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LCuil_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LCuil_Enabled), 5, 0), true);
      edtF1357LPerDesd_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LPerDesd_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LPerDesd_Enabled), 5, 0), true);
      edtF1357LPerHas_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LPerHas_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LPerHas_Enabled), 5, 0), true);
      edtF1357LMeses_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LMeses_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LMeses_Enabled), 5, 0), true);
      cmbF1357LBeneficio.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbF1357LBeneficio.getInternalname(), "Enabled", GXutil.ltrimstr( cmbF1357LBeneficio.getEnabled(), 5, 0), true);
      edtF1357LLargaDist_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LLargaDist_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LLargaDist_Enabled), 5, 0), true);
      edtF1357LLey27424_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LLey27424_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LLey27424_Enabled), 5, 0), true);
      edtF1357L27549_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357L27549_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357L27549_Enabled), 5, 0), true);
      edtF1357LTeletrabajo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LTeletrabajo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LTeletrabajo_Enabled), 5, 0), true);
      edtF1357LMilitar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LMilitar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LMilitar_Enabled), 5, 0), true);
      edtF1357LLargaDistCT_40_1989_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LLargaDistCT_40_1989_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LLargaDistCT_40_1989_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes2G95( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues2G0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.f1357leg", new String[] {}, new String[] {}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "Z784F1357CTipoPre", GXutil.ltrim( localUtil.ntoc( Z784F1357CTipoPre, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z777F1357CPer", GXutil.rtrim( Z777F1357CPer));
      web.GxWebStd.gx_hidden_field( httpContext, "Z778F1357CSec", GXutil.ltrim( localUtil.ntoc( Z778F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z786F1357LTipoReg", GXutil.rtrim( Z786F1357LTipoReg));
      web.GxWebStd.gx_hidden_field( httpContext, "Z787F1357LCuil", GXutil.rtrim( Z787F1357LCuil));
      web.GxWebStd.gx_hidden_field( httpContext, "Z788F1357LPerDesd", GXutil.rtrim( Z788F1357LPerDesd));
      web.GxWebStd.gx_hidden_field( httpContext, "Z789F1357LPerHas", GXutil.rtrim( Z789F1357LPerHas));
      web.GxWebStd.gx_hidden_field( httpContext, "Z790F1357LMeses", GXutil.rtrim( Z790F1357LMeses));
      web.GxWebStd.gx_hidden_field( httpContext, "Z791F1357LBeneficio", GXutil.ltrim( localUtil.ntoc( Z791F1357LBeneficio, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z792F1357LLargaDist", GXutil.rtrim( Z792F1357LLargaDist));
      web.GxWebStd.gx_hidden_field( httpContext, "Z793F1357LLey27424", GXutil.rtrim( Z793F1357LLey27424));
      web.GxWebStd.gx_hidden_field( httpContext, "Z794F1357L27549", GXutil.rtrim( Z794F1357L27549));
      web.GxWebStd.gx_hidden_field( httpContext, "Z795F1357LTeletrabajo", GXutil.rtrim( Z795F1357LTeletrabajo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z796F1357LMilitar", GXutil.rtrim( Z796F1357LMilitar));
      web.GxWebStd.gx_hidden_field( httpContext, "Z943F1357LLargaDistCT_40_1989", GXutil.rtrim( Z943F1357LLargaDistCT_40_1989));
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
      return formatLink("web.f1357leg", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "F1357Leg" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "F1357 Leg", "") ;
   }

   public void initializeNonKey2G95( )
   {
      A787F1357LCuil = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A787F1357LCuil", A787F1357LCuil);
      A788F1357LPerDesd = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A788F1357LPerDesd", A788F1357LPerDesd);
      A789F1357LPerHas = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A789F1357LPerHas", A789F1357LPerHas);
      A790F1357LMeses = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A790F1357LMeses", A790F1357LMeses);
      A791F1357LBeneficio = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A791F1357LBeneficio", GXutil.str( A791F1357LBeneficio, 1, 0));
      A792F1357LLargaDist = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A792F1357LLargaDist", A792F1357LLargaDist);
      A793F1357LLey27424 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A793F1357LLey27424", A793F1357LLey27424);
      A794F1357L27549 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A794F1357L27549", A794F1357L27549);
      A795F1357LTeletrabajo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A795F1357LTeletrabajo", A795F1357LTeletrabajo);
      A796F1357LMilitar = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A796F1357LMilitar", A796F1357LMilitar);
      A943F1357LLargaDistCT_40_1989 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A943F1357LLargaDistCT_40_1989", A943F1357LLargaDistCT_40_1989);
      Z787F1357LCuil = "" ;
      Z788F1357LPerDesd = "" ;
      Z789F1357LPerHas = "" ;
      Z790F1357LMeses = "" ;
      Z791F1357LBeneficio = (byte)(0) ;
      Z792F1357LLargaDist = "" ;
      Z793F1357LLey27424 = "" ;
      Z794F1357L27549 = "" ;
      Z795F1357LTeletrabajo = "" ;
      Z796F1357LMilitar = "" ;
      Z943F1357LLargaDistCT_40_1989 = "" ;
   }

   public void initAll2G95( )
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
      A6LegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      A786F1357LTipoReg = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A786F1357LTipoReg", A786F1357LTipoReg);
      initializeNonKey2G95( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171339632", true, true);
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
      httpContext.AddJavascriptSource("f1357leg.js", "?2025171339632", false, true);
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
      cmbF1357CTipoPre.setInternalname( "F1357CTIPOPRE" );
      edtF1357CPer_Internalname = "F1357CPER" ;
      edtF1357CSec_Internalname = "F1357CSEC" ;
      edtLegNumero_Internalname = "LEGNUMERO" ;
      edtF1357LTipoReg_Internalname = "F1357LTIPOREG" ;
      edtF1357LCuil_Internalname = "F1357LCUIL" ;
      edtF1357LPerDesd_Internalname = "F1357LPERDESD" ;
      edtF1357LPerHas_Internalname = "F1357LPERHAS" ;
      edtF1357LMeses_Internalname = "F1357LMESES" ;
      cmbF1357LBeneficio.setInternalname( "F1357LBENEFICIO" );
      edtF1357LLargaDist_Internalname = "F1357LLARGADIST" ;
      edtF1357LLey27424_Internalname = "F1357LLEY27424" ;
      edtF1357L27549_Internalname = "F1357L27549" ;
      edtF1357LTeletrabajo_Internalname = "F1357LTELETRABAJO" ;
      edtF1357LMilitar_Internalname = "F1357LMILITAR" ;
      edtF1357LLargaDistCT_40_1989_Internalname = "F1357LLARGADISTCT_40_1989" ;
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
      Form.setCaption( httpContext.getMessage( "F1357 Leg", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtF1357LLargaDistCT_40_1989_Jsonclick = "" ;
      edtF1357LLargaDistCT_40_1989_Enabled = 1 ;
      edtF1357LMilitar_Jsonclick = "" ;
      edtF1357LMilitar_Enabled = 1 ;
      edtF1357LTeletrabajo_Jsonclick = "" ;
      edtF1357LTeletrabajo_Enabled = 1 ;
      edtF1357L27549_Jsonclick = "" ;
      edtF1357L27549_Enabled = 1 ;
      edtF1357LLey27424_Jsonclick = "" ;
      edtF1357LLey27424_Enabled = 1 ;
      edtF1357LLargaDist_Jsonclick = "" ;
      edtF1357LLargaDist_Enabled = 1 ;
      cmbF1357LBeneficio.setJsonclick( "" );
      cmbF1357LBeneficio.setEnabled( 1 );
      edtF1357LMeses_Jsonclick = "" ;
      edtF1357LMeses_Enabled = 1 ;
      edtF1357LPerHas_Jsonclick = "" ;
      edtF1357LPerHas_Enabled = 1 ;
      edtF1357LPerDesd_Jsonclick = "" ;
      edtF1357LPerDesd_Enabled = 1 ;
      edtF1357LCuil_Jsonclick = "" ;
      edtF1357LCuil_Enabled = 1 ;
      edtF1357LTipoReg_Jsonclick = "" ;
      edtF1357LTipoReg_Enabled = 1 ;
      edtLegNumero_Jsonclick = "" ;
      edtLegNumero_Enabled = 1 ;
      edtF1357CSec_Jsonclick = "" ;
      edtF1357CSec_Enabled = 1 ;
      edtF1357CPer_Jsonclick = "" ;
      edtF1357CPer_Enabled = 1 ;
      cmbF1357CTipoPre.setJsonclick( "" );
      cmbF1357CTipoPre.setEnabled( 1 );
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
      cmbF1357LBeneficio.setName( "F1357LBENEFICIO" );
      cmbF1357LBeneficio.setWebtags( "" );
      cmbF1357LBeneficio.addItem("1", httpContext.getMessage( "Sin Beneficio", ""), (short)(0));
      cmbF1357LBeneficio.addItem("2", httpContext.getMessage( "ZONA PATAGÓNICA – INCREMENTO DEL 22%", ""), (short)(0));
      cmbF1357LBeneficio.addItem("3", httpContext.getMessage( "asdf", ""), (short)(0));
      cmbF1357LBeneficio.addItem("4", httpContext.getMessage( "JUBILADO ZONA PATAGÓNICA", ""), (short)(0));
      if ( cmbF1357LBeneficio.getItemCount() > 0 )
      {
         A791F1357LBeneficio = (byte)(GXutil.lval( cmbF1357LBeneficio.getValidValue(GXutil.trim( GXutil.str( A791F1357LBeneficio, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A791F1357LBeneficio", GXutil.str( A791F1357LBeneficio, 1, 0));
      }
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      /* Using cursor T002G16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Formulario F1357", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "F1357CSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(14);
      /* Using cursor T002G17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(15);
      GX_FocusControl = edtF1357LCuil_Internalname ;
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

   public void valid_F1357csec( )
   {
      A784F1357CTipoPre = (byte)(GXutil.lval( cmbF1357CTipoPre.getValue())) ;
      /* Using cursor T002G16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Formulario F1357", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "F1357CSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(14);
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

   public void valid_Legnumero( )
   {
      /* Using cursor T002G17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(15);
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

   public void valid_F1357ltiporeg( )
   {
      A791F1357LBeneficio = (byte)(GXutil.lval( cmbF1357LBeneficio.getValue())) ;
      cmbF1357LBeneficio.setValue( GXutil.str( A791F1357LBeneficio, 1, 0) );
      A784F1357CTipoPre = (byte)(GXutil.lval( cmbF1357CTipoPre.getValue())) ;
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      if ( cmbF1357CTipoPre.getItemCount() > 0 )
      {
         A784F1357CTipoPre = (byte)(GXutil.lval( cmbF1357CTipoPre.getValidValue(GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbF1357CTipoPre.setValue( GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0)) );
      }
      if ( cmbF1357LBeneficio.getItemCount() > 0 )
      {
         A791F1357LBeneficio = (byte)(GXutil.lval( cmbF1357LBeneficio.getValidValue(GXutil.trim( GXutil.str( A791F1357LBeneficio, 1, 0))))) ;
         cmbF1357LBeneficio.setValue( GXutil.str( A791F1357LBeneficio, 1, 0) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbF1357LBeneficio.setValue( GXutil.trim( GXutil.str( A791F1357LBeneficio, 1, 0)) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A787F1357LCuil", GXutil.rtrim( A787F1357LCuil));
      httpContext.ajax_rsp_assign_attri("", false, "A788F1357LPerDesd", GXutil.rtrim( A788F1357LPerDesd));
      httpContext.ajax_rsp_assign_attri("", false, "A789F1357LPerHas", GXutil.rtrim( A789F1357LPerHas));
      httpContext.ajax_rsp_assign_attri("", false, "A790F1357LMeses", GXutil.rtrim( A790F1357LMeses));
      httpContext.ajax_rsp_assign_attri("", false, "A791F1357LBeneficio", GXutil.ltrim( localUtil.ntoc( A791F1357LBeneficio, (byte)(1), (byte)(0), ".", "")));
      cmbF1357LBeneficio.setValue( GXutil.trim( GXutil.str( A791F1357LBeneficio, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbF1357LBeneficio.getInternalname(), "Values", cmbF1357LBeneficio.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A792F1357LLargaDist", GXutil.rtrim( A792F1357LLargaDist));
      httpContext.ajax_rsp_assign_attri("", false, "A793F1357LLey27424", GXutil.rtrim( A793F1357LLey27424));
      httpContext.ajax_rsp_assign_attri("", false, "A794F1357L27549", GXutil.rtrim( A794F1357L27549));
      httpContext.ajax_rsp_assign_attri("", false, "A795F1357LTeletrabajo", GXutil.rtrim( A795F1357LTeletrabajo));
      httpContext.ajax_rsp_assign_attri("", false, "A796F1357LMilitar", GXutil.rtrim( A796F1357LMilitar));
      httpContext.ajax_rsp_assign_attri("", false, "A943F1357LLargaDistCT_40_1989", GXutil.rtrim( A943F1357LLargaDistCT_40_1989));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z784F1357CTipoPre", GXutil.ltrim( localUtil.ntoc( Z784F1357CTipoPre, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z777F1357CPer", GXutil.rtrim( Z777F1357CPer));
      web.GxWebStd.gx_hidden_field( httpContext, "Z778F1357CSec", GXutil.ltrim( localUtil.ntoc( Z778F1357CSec, (byte)(2), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z786F1357LTipoReg", GXutil.rtrim( Z786F1357LTipoReg));
      web.GxWebStd.gx_hidden_field( httpContext, "Z787F1357LCuil", GXutil.rtrim( Z787F1357LCuil));
      web.GxWebStd.gx_hidden_field( httpContext, "Z788F1357LPerDesd", GXutil.rtrim( Z788F1357LPerDesd));
      web.GxWebStd.gx_hidden_field( httpContext, "Z789F1357LPerHas", GXutil.rtrim( Z789F1357LPerHas));
      web.GxWebStd.gx_hidden_field( httpContext, "Z790F1357LMeses", GXutil.rtrim( Z790F1357LMeses));
      web.GxWebStd.gx_hidden_field( httpContext, "Z791F1357LBeneficio", GXutil.ltrim( localUtil.ntoc( Z791F1357LBeneficio, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z792F1357LLargaDist", GXutil.rtrim( Z792F1357LLargaDist));
      web.GxWebStd.gx_hidden_field( httpContext, "Z793F1357LLey27424", GXutil.rtrim( Z793F1357LLey27424));
      web.GxWebStd.gx_hidden_field( httpContext, "Z794F1357L27549", GXutil.rtrim( Z794F1357L27549));
      web.GxWebStd.gx_hidden_field( httpContext, "Z795F1357LTeletrabajo", GXutil.rtrim( Z795F1357LTeletrabajo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z796F1357LMilitar", GXutil.rtrim( Z796F1357LMilitar));
      web.GxWebStd.gx_hidden_field( httpContext, "Z943F1357LLargaDistCT_40_1989", GXutil.rtrim( Z943F1357LLargaDistCT_40_1989));
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_F1357CTIPOPRE","{handler:'valid_F1357ctipopre',iparms:[]");
      setEventMetadata("VALID_F1357CTIPOPRE",",oparms:[]}");
      setEventMetadata("VALID_F1357CPER","{handler:'valid_F1357cper',iparms:[]");
      setEventMetadata("VALID_F1357CPER",",oparms:[]}");
      setEventMetadata("VALID_F1357CSEC","{handler:'valid_F1357csec',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'cmbF1357CTipoPre'},{av:'A784F1357CTipoPre',fld:'F1357CTIPOPRE',pic:'9'},{av:'A777F1357CPer',fld:'F1357CPER',pic:''},{av:'A778F1357CSec',fld:'F1357CSEC',pic:'Z9'}]");
      setEventMetadata("VALID_F1357CSEC",",oparms:[]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[]}");
      setEventMetadata("VALID_F1357LTIPOREG","{handler:'valid_F1357ltiporeg',iparms:[{av:'cmbF1357LBeneficio'},{av:'A791F1357LBeneficio',fld:'F1357LBENEFICIO',pic:'9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'cmbF1357CTipoPre'},{av:'A784F1357CTipoPre',fld:'F1357CTIPOPRE',pic:'9'},{av:'A777F1357CPer',fld:'F1357CPER',pic:''},{av:'A778F1357CSec',fld:'F1357CSEC',pic:'Z9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A786F1357LTipoReg',fld:'F1357LTIPOREG',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_F1357LTIPOREG",",oparms:[{av:'A787F1357LCuil',fld:'F1357LCUIL',pic:''},{av:'A788F1357LPerDesd',fld:'F1357LPERDESD',pic:''},{av:'A789F1357LPerHas',fld:'F1357LPERHAS',pic:''},{av:'A790F1357LMeses',fld:'F1357LMESES',pic:''},{av:'cmbF1357LBeneficio'},{av:'A791F1357LBeneficio',fld:'F1357LBENEFICIO',pic:'9'},{av:'A792F1357LLargaDist',fld:'F1357LLARGADIST',pic:''},{av:'A793F1357LLey27424',fld:'F1357LLEY27424',pic:''},{av:'A794F1357L27549',fld:'F1357L27549',pic:''},{av:'A795F1357LTeletrabajo',fld:'F1357LTELETRABAJO',pic:''},{av:'A796F1357LMilitar',fld:'F1357LMILITAR',pic:''},{av:'A943F1357LLargaDistCT_40_1989',fld:'F1357LLARGADISTCT_40_1989',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z3CliCod'},{av:'Z1EmpCod'},{av:'Z784F1357CTipoPre'},{av:'Z777F1357CPer'},{av:'Z778F1357CSec'},{av:'Z6LegNumero'},{av:'Z786F1357LTipoReg'},{av:'Z787F1357LCuil'},{av:'Z788F1357LPerDesd'},{av:'Z789F1357LPerHas'},{av:'Z790F1357LMeses'},{av:'Z791F1357LBeneficio'},{av:'Z792F1357LLargaDist'},{av:'Z793F1357LLey27424'},{av:'Z794F1357L27549'},{av:'Z795F1357LTeletrabajo'},{av:'Z796F1357LMilitar'},{av:'Z943F1357LLargaDistCT_40_1989'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_F1357LBENEFICIO","{handler:'valid_F1357lbeneficio',iparms:[]");
      setEventMetadata("VALID_F1357LBENEFICIO",",oparms:[]}");
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
      pr_default.close(15);
      pr_default.close(14);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z777F1357CPer = "" ;
      Z786F1357LTipoReg = "" ;
      Z787F1357LCuil = "" ;
      Z788F1357LPerDesd = "" ;
      Z789F1357LPerHas = "" ;
      Z790F1357LMeses = "" ;
      Z792F1357LLargaDist = "" ;
      Z793F1357LLey27424 = "" ;
      Z794F1357L27549 = "" ;
      Z795F1357LTeletrabajo = "" ;
      Z796F1357LMilitar = "" ;
      Z943F1357LLargaDistCT_40_1989 = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A777F1357CPer = "" ;
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
      A786F1357LTipoReg = "" ;
      A787F1357LCuil = "" ;
      A788F1357LPerDesd = "" ;
      A789F1357LPerHas = "" ;
      A790F1357LMeses = "" ;
      A792F1357LLargaDist = "" ;
      A793F1357LLey27424 = "" ;
      A794F1357L27549 = "" ;
      A795F1357LTeletrabajo = "" ;
      A796F1357LMilitar = "" ;
      A943F1357LLargaDistCT_40_1989 = "" ;
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
      T002G6_A786F1357LTipoReg = new String[] {""} ;
      T002G6_A787F1357LCuil = new String[] {""} ;
      T002G6_A788F1357LPerDesd = new String[] {""} ;
      T002G6_A789F1357LPerHas = new String[] {""} ;
      T002G6_A790F1357LMeses = new String[] {""} ;
      T002G6_A791F1357LBeneficio = new byte[1] ;
      T002G6_A792F1357LLargaDist = new String[] {""} ;
      T002G6_A793F1357LLey27424 = new String[] {""} ;
      T002G6_A794F1357L27549 = new String[] {""} ;
      T002G6_A795F1357LTeletrabajo = new String[] {""} ;
      T002G6_A796F1357LMilitar = new String[] {""} ;
      T002G6_A943F1357LLargaDistCT_40_1989 = new String[] {""} ;
      T002G6_A3CliCod = new int[1] ;
      T002G6_A1EmpCod = new short[1] ;
      T002G6_A6LegNumero = new int[1] ;
      T002G6_A784F1357CTipoPre = new byte[1] ;
      T002G6_A777F1357CPer = new String[] {""} ;
      T002G6_A778F1357CSec = new byte[1] ;
      T002G5_A3CliCod = new int[1] ;
      T002G4_A3CliCod = new int[1] ;
      T002G7_A3CliCod = new int[1] ;
      T002G8_A3CliCod = new int[1] ;
      T002G9_A3CliCod = new int[1] ;
      T002G9_A1EmpCod = new short[1] ;
      T002G9_A784F1357CTipoPre = new byte[1] ;
      T002G9_A777F1357CPer = new String[] {""} ;
      T002G9_A778F1357CSec = new byte[1] ;
      T002G9_A6LegNumero = new int[1] ;
      T002G9_A786F1357LTipoReg = new String[] {""} ;
      T002G3_A786F1357LTipoReg = new String[] {""} ;
      T002G3_A787F1357LCuil = new String[] {""} ;
      T002G3_A788F1357LPerDesd = new String[] {""} ;
      T002G3_A789F1357LPerHas = new String[] {""} ;
      T002G3_A790F1357LMeses = new String[] {""} ;
      T002G3_A791F1357LBeneficio = new byte[1] ;
      T002G3_A792F1357LLargaDist = new String[] {""} ;
      T002G3_A793F1357LLey27424 = new String[] {""} ;
      T002G3_A794F1357L27549 = new String[] {""} ;
      T002G3_A795F1357LTeletrabajo = new String[] {""} ;
      T002G3_A796F1357LMilitar = new String[] {""} ;
      T002G3_A943F1357LLargaDistCT_40_1989 = new String[] {""} ;
      T002G3_A3CliCod = new int[1] ;
      T002G3_A1EmpCod = new short[1] ;
      T002G3_A6LegNumero = new int[1] ;
      T002G3_A784F1357CTipoPre = new byte[1] ;
      T002G3_A777F1357CPer = new String[] {""} ;
      T002G3_A778F1357CSec = new byte[1] ;
      sMode95 = "" ;
      T002G10_A3CliCod = new int[1] ;
      T002G10_A1EmpCod = new short[1] ;
      T002G10_A784F1357CTipoPre = new byte[1] ;
      T002G10_A777F1357CPer = new String[] {""} ;
      T002G10_A778F1357CSec = new byte[1] ;
      T002G10_A6LegNumero = new int[1] ;
      T002G10_A786F1357LTipoReg = new String[] {""} ;
      T002G11_A3CliCod = new int[1] ;
      T002G11_A1EmpCod = new short[1] ;
      T002G11_A784F1357CTipoPre = new byte[1] ;
      T002G11_A777F1357CPer = new String[] {""} ;
      T002G11_A778F1357CSec = new byte[1] ;
      T002G11_A6LegNumero = new int[1] ;
      T002G11_A786F1357LTipoReg = new String[] {""} ;
      T002G2_A786F1357LTipoReg = new String[] {""} ;
      T002G2_A787F1357LCuil = new String[] {""} ;
      T002G2_A788F1357LPerDesd = new String[] {""} ;
      T002G2_A789F1357LPerHas = new String[] {""} ;
      T002G2_A790F1357LMeses = new String[] {""} ;
      T002G2_A791F1357LBeneficio = new byte[1] ;
      T002G2_A792F1357LLargaDist = new String[] {""} ;
      T002G2_A793F1357LLey27424 = new String[] {""} ;
      T002G2_A794F1357L27549 = new String[] {""} ;
      T002G2_A795F1357LTeletrabajo = new String[] {""} ;
      T002G2_A796F1357LMilitar = new String[] {""} ;
      T002G2_A943F1357LLargaDistCT_40_1989 = new String[] {""} ;
      T002G2_A3CliCod = new int[1] ;
      T002G2_A1EmpCod = new short[1] ;
      T002G2_A6LegNumero = new int[1] ;
      T002G2_A784F1357CTipoPre = new byte[1] ;
      T002G2_A777F1357CPer = new String[] {""} ;
      T002G2_A778F1357CSec = new byte[1] ;
      T002G15_A3CliCod = new int[1] ;
      T002G15_A1EmpCod = new short[1] ;
      T002G15_A784F1357CTipoPre = new byte[1] ;
      T002G15_A777F1357CPer = new String[] {""} ;
      T002G15_A778F1357CSec = new byte[1] ;
      T002G15_A6LegNumero = new int[1] ;
      T002G15_A786F1357LTipoReg = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T002G16_A3CliCod = new int[1] ;
      T002G17_A3CliCod = new int[1] ;
      ZZ777F1357CPer = "" ;
      ZZ786F1357LTipoReg = "" ;
      ZZ787F1357LCuil = "" ;
      ZZ788F1357LPerDesd = "" ;
      ZZ789F1357LPerHas = "" ;
      ZZ790F1357LMeses = "" ;
      ZZ792F1357LLargaDist = "" ;
      ZZ793F1357LLey27424 = "" ;
      ZZ794F1357L27549 = "" ;
      ZZ795F1357LTeletrabajo = "" ;
      ZZ796F1357LMilitar = "" ;
      ZZ943F1357LLargaDistCT_40_1989 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357leg__default(),
         new Object[] {
             new Object[] {
            T002G2_A786F1357LTipoReg, T002G2_A787F1357LCuil, T002G2_A788F1357LPerDesd, T002G2_A789F1357LPerHas, T002G2_A790F1357LMeses, T002G2_A791F1357LBeneficio, T002G2_A792F1357LLargaDist, T002G2_A793F1357LLey27424, T002G2_A794F1357L27549, T002G2_A795F1357LTeletrabajo,
            T002G2_A796F1357LMilitar, T002G2_A943F1357LLargaDistCT_40_1989, T002G2_A3CliCod, T002G2_A1EmpCod, T002G2_A6LegNumero, T002G2_A784F1357CTipoPre, T002G2_A777F1357CPer, T002G2_A778F1357CSec
            }
            , new Object[] {
            T002G3_A786F1357LTipoReg, T002G3_A787F1357LCuil, T002G3_A788F1357LPerDesd, T002G3_A789F1357LPerHas, T002G3_A790F1357LMeses, T002G3_A791F1357LBeneficio, T002G3_A792F1357LLargaDist, T002G3_A793F1357LLey27424, T002G3_A794F1357L27549, T002G3_A795F1357LTeletrabajo,
            T002G3_A796F1357LMilitar, T002G3_A943F1357LLargaDistCT_40_1989, T002G3_A3CliCod, T002G3_A1EmpCod, T002G3_A6LegNumero, T002G3_A784F1357CTipoPre, T002G3_A777F1357CPer, T002G3_A778F1357CSec
            }
            , new Object[] {
            T002G4_A3CliCod
            }
            , new Object[] {
            T002G5_A3CliCod
            }
            , new Object[] {
            T002G6_A786F1357LTipoReg, T002G6_A787F1357LCuil, T002G6_A788F1357LPerDesd, T002G6_A789F1357LPerHas, T002G6_A790F1357LMeses, T002G6_A791F1357LBeneficio, T002G6_A792F1357LLargaDist, T002G6_A793F1357LLey27424, T002G6_A794F1357L27549, T002G6_A795F1357LTeletrabajo,
            T002G6_A796F1357LMilitar, T002G6_A943F1357LLargaDistCT_40_1989, T002G6_A3CliCod, T002G6_A1EmpCod, T002G6_A6LegNumero, T002G6_A784F1357CTipoPre, T002G6_A777F1357CPer, T002G6_A778F1357CSec
            }
            , new Object[] {
            T002G7_A3CliCod
            }
            , new Object[] {
            T002G8_A3CliCod
            }
            , new Object[] {
            T002G9_A3CliCod, T002G9_A1EmpCod, T002G9_A784F1357CTipoPre, T002G9_A777F1357CPer, T002G9_A778F1357CSec, T002G9_A6LegNumero, T002G9_A786F1357LTipoReg
            }
            , new Object[] {
            T002G10_A3CliCod, T002G10_A1EmpCod, T002G10_A784F1357CTipoPre, T002G10_A777F1357CPer, T002G10_A778F1357CSec, T002G10_A6LegNumero, T002G10_A786F1357LTipoReg
            }
            , new Object[] {
            T002G11_A3CliCod, T002G11_A1EmpCod, T002G11_A784F1357CTipoPre, T002G11_A777F1357CPer, T002G11_A778F1357CSec, T002G11_A6LegNumero, T002G11_A786F1357LTipoReg
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002G15_A3CliCod, T002G15_A1EmpCod, T002G15_A784F1357CTipoPre, T002G15_A777F1357CPer, T002G15_A778F1357CSec, T002G15_A6LegNumero, T002G15_A786F1357LTipoReg
            }
            , new Object[] {
            T002G16_A3CliCod
            }
            , new Object[] {
            T002G17_A3CliCod
            }
         }
      );
   }

   private byte Z784F1357CTipoPre ;
   private byte Z778F1357CSec ;
   private byte Z791F1357LBeneficio ;
   private byte GxWebError ;
   private byte A784F1357CTipoPre ;
   private byte A778F1357CSec ;
   private byte nKeyPressed ;
   private byte A791F1357LBeneficio ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private byte ZZ784F1357CTipoPre ;
   private byte ZZ778F1357CSec ;
   private byte ZZ791F1357LBeneficio ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound95 ;
   private short nIsDirty_95 ;
   private short ZZ1EmpCod ;
   private int Z3CliCod ;
   private int Z6LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Enabled ;
   private int edtF1357CPer_Enabled ;
   private int edtF1357CSec_Enabled ;
   private int edtLegNumero_Enabled ;
   private int edtF1357LTipoReg_Enabled ;
   private int edtF1357LCuil_Enabled ;
   private int edtF1357LPerDesd_Enabled ;
   private int edtF1357LPerHas_Enabled ;
   private int edtF1357LMeses_Enabled ;
   private int edtF1357LLargaDist_Enabled ;
   private int edtF1357LLey27424_Enabled ;
   private int edtF1357L27549_Enabled ;
   private int edtF1357LTeletrabajo_Enabled ;
   private int edtF1357LMilitar_Enabled ;
   private int edtF1357LLargaDistCT_40_1989_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ3CliCod ;
   private int ZZ6LegNumero ;
   private String sPrefix ;
   private String Z777F1357CPer ;
   private String Z786F1357LTipoReg ;
   private String Z787F1357LCuil ;
   private String Z788F1357LPerDesd ;
   private String Z789F1357LPerHas ;
   private String Z790F1357LMeses ;
   private String Z792F1357LLargaDist ;
   private String Z793F1357LLey27424 ;
   private String Z794F1357L27549 ;
   private String Z795F1357LTeletrabajo ;
   private String Z796F1357LMilitar ;
   private String Z943F1357LLargaDistCT_40_1989 ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A777F1357CPer ;
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
   private String edtF1357CPer_Internalname ;
   private String edtF1357CPer_Jsonclick ;
   private String edtF1357CSec_Internalname ;
   private String edtF1357CSec_Jsonclick ;
   private String edtLegNumero_Internalname ;
   private String edtLegNumero_Jsonclick ;
   private String edtF1357LTipoReg_Internalname ;
   private String A786F1357LTipoReg ;
   private String edtF1357LTipoReg_Jsonclick ;
   private String edtF1357LCuil_Internalname ;
   private String A787F1357LCuil ;
   private String edtF1357LCuil_Jsonclick ;
   private String edtF1357LPerDesd_Internalname ;
   private String A788F1357LPerDesd ;
   private String edtF1357LPerDesd_Jsonclick ;
   private String edtF1357LPerHas_Internalname ;
   private String A789F1357LPerHas ;
   private String edtF1357LPerHas_Jsonclick ;
   private String edtF1357LMeses_Internalname ;
   private String A790F1357LMeses ;
   private String edtF1357LMeses_Jsonclick ;
   private String edtF1357LLargaDist_Internalname ;
   private String A792F1357LLargaDist ;
   private String edtF1357LLargaDist_Jsonclick ;
   private String edtF1357LLey27424_Internalname ;
   private String A793F1357LLey27424 ;
   private String edtF1357LLey27424_Jsonclick ;
   private String edtF1357L27549_Internalname ;
   private String A794F1357L27549 ;
   private String edtF1357L27549_Jsonclick ;
   private String edtF1357LTeletrabajo_Internalname ;
   private String A795F1357LTeletrabajo ;
   private String edtF1357LTeletrabajo_Jsonclick ;
   private String edtF1357LMilitar_Internalname ;
   private String A796F1357LMilitar ;
   private String edtF1357LMilitar_Jsonclick ;
   private String edtF1357LLargaDistCT_40_1989_Internalname ;
   private String A943F1357LLargaDistCT_40_1989 ;
   private String edtF1357LLargaDistCT_40_1989_Jsonclick ;
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
   private String sMode95 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ777F1357CPer ;
   private String ZZ786F1357LTipoReg ;
   private String ZZ787F1357LCuil ;
   private String ZZ788F1357LPerDesd ;
   private String ZZ789F1357LPerHas ;
   private String ZZ790F1357LMeses ;
   private String ZZ792F1357LLargaDist ;
   private String ZZ793F1357LLey27424 ;
   private String ZZ794F1357L27549 ;
   private String ZZ795F1357LTeletrabajo ;
   private String ZZ796F1357LMilitar ;
   private String ZZ943F1357LLargaDistCT_40_1989 ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Gx_longc ;
   private HTMLChoice cmbF1357CTipoPre ;
   private HTMLChoice cmbF1357LBeneficio ;
   private IDataStoreProvider pr_default ;
   private String[] T002G6_A786F1357LTipoReg ;
   private String[] T002G6_A787F1357LCuil ;
   private String[] T002G6_A788F1357LPerDesd ;
   private String[] T002G6_A789F1357LPerHas ;
   private String[] T002G6_A790F1357LMeses ;
   private byte[] T002G6_A791F1357LBeneficio ;
   private String[] T002G6_A792F1357LLargaDist ;
   private String[] T002G6_A793F1357LLey27424 ;
   private String[] T002G6_A794F1357L27549 ;
   private String[] T002G6_A795F1357LTeletrabajo ;
   private String[] T002G6_A796F1357LMilitar ;
   private String[] T002G6_A943F1357LLargaDistCT_40_1989 ;
   private int[] T002G6_A3CliCod ;
   private short[] T002G6_A1EmpCod ;
   private int[] T002G6_A6LegNumero ;
   private byte[] T002G6_A784F1357CTipoPre ;
   private String[] T002G6_A777F1357CPer ;
   private byte[] T002G6_A778F1357CSec ;
   private int[] T002G5_A3CliCod ;
   private int[] T002G4_A3CliCod ;
   private int[] T002G7_A3CliCod ;
   private int[] T002G8_A3CliCod ;
   private int[] T002G9_A3CliCod ;
   private short[] T002G9_A1EmpCod ;
   private byte[] T002G9_A784F1357CTipoPre ;
   private String[] T002G9_A777F1357CPer ;
   private byte[] T002G9_A778F1357CSec ;
   private int[] T002G9_A6LegNumero ;
   private String[] T002G9_A786F1357LTipoReg ;
   private String[] T002G3_A786F1357LTipoReg ;
   private String[] T002G3_A787F1357LCuil ;
   private String[] T002G3_A788F1357LPerDesd ;
   private String[] T002G3_A789F1357LPerHas ;
   private String[] T002G3_A790F1357LMeses ;
   private byte[] T002G3_A791F1357LBeneficio ;
   private String[] T002G3_A792F1357LLargaDist ;
   private String[] T002G3_A793F1357LLey27424 ;
   private String[] T002G3_A794F1357L27549 ;
   private String[] T002G3_A795F1357LTeletrabajo ;
   private String[] T002G3_A796F1357LMilitar ;
   private String[] T002G3_A943F1357LLargaDistCT_40_1989 ;
   private int[] T002G3_A3CliCod ;
   private short[] T002G3_A1EmpCod ;
   private int[] T002G3_A6LegNumero ;
   private byte[] T002G3_A784F1357CTipoPre ;
   private String[] T002G3_A777F1357CPer ;
   private byte[] T002G3_A778F1357CSec ;
   private int[] T002G10_A3CliCod ;
   private short[] T002G10_A1EmpCod ;
   private byte[] T002G10_A784F1357CTipoPre ;
   private String[] T002G10_A777F1357CPer ;
   private byte[] T002G10_A778F1357CSec ;
   private int[] T002G10_A6LegNumero ;
   private String[] T002G10_A786F1357LTipoReg ;
   private int[] T002G11_A3CliCod ;
   private short[] T002G11_A1EmpCod ;
   private byte[] T002G11_A784F1357CTipoPre ;
   private String[] T002G11_A777F1357CPer ;
   private byte[] T002G11_A778F1357CSec ;
   private int[] T002G11_A6LegNumero ;
   private String[] T002G11_A786F1357LTipoReg ;
   private String[] T002G2_A786F1357LTipoReg ;
   private String[] T002G2_A787F1357LCuil ;
   private String[] T002G2_A788F1357LPerDesd ;
   private String[] T002G2_A789F1357LPerHas ;
   private String[] T002G2_A790F1357LMeses ;
   private byte[] T002G2_A791F1357LBeneficio ;
   private String[] T002G2_A792F1357LLargaDist ;
   private String[] T002G2_A793F1357LLey27424 ;
   private String[] T002G2_A794F1357L27549 ;
   private String[] T002G2_A795F1357LTeletrabajo ;
   private String[] T002G2_A796F1357LMilitar ;
   private String[] T002G2_A943F1357LLargaDistCT_40_1989 ;
   private int[] T002G2_A3CliCod ;
   private short[] T002G2_A1EmpCod ;
   private int[] T002G2_A6LegNumero ;
   private byte[] T002G2_A784F1357CTipoPre ;
   private String[] T002G2_A777F1357CPer ;
   private byte[] T002G2_A778F1357CSec ;
   private int[] T002G15_A3CliCod ;
   private short[] T002G15_A1EmpCod ;
   private byte[] T002G15_A784F1357CTipoPre ;
   private String[] T002G15_A777F1357CPer ;
   private byte[] T002G15_A778F1357CSec ;
   private int[] T002G15_A6LegNumero ;
   private String[] T002G15_A786F1357LTipoReg ;
   private int[] T002G16_A3CliCod ;
   private int[] T002G17_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class f1357leg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T002G2", "SELECT F1357LTipoReg, F1357LCuil, F1357LPerDesd, F1357LPerHas, F1357LMeses, F1357LBeneficio, F1357LLargaDist, F1357LLey27424, F1357L27549, F1357LTeletrabajo, F1357LMilitar, F1357LLargaDistCT_40_1989, CliCod, EmpCod, LegNumero, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357Leg WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LTipoReg = ?  FOR UPDATE OF F1357Leg NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002G3", "SELECT F1357LTipoReg, F1357LCuil, F1357LPerDesd, F1357LPerHas, F1357LMeses, F1357LBeneficio, F1357LLargaDist, F1357LLey27424, F1357L27549, F1357LTeletrabajo, F1357LMilitar, F1357LLargaDistCT_40_1989, CliCod, EmpCod, LegNumero, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357Leg WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LTipoReg = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002G4", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002G5", "SELECT CliCod FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002G6", "SELECT TM1.F1357LTipoReg, TM1.F1357LCuil, TM1.F1357LPerDesd, TM1.F1357LPerHas, TM1.F1357LMeses, TM1.F1357LBeneficio, TM1.F1357LLargaDist, TM1.F1357LLey27424, TM1.F1357L27549, TM1.F1357LTeletrabajo, TM1.F1357LMilitar, TM1.F1357LLargaDistCT_40_1989, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.F1357CTipoPre, TM1.F1357CPer, TM1.F1357CSec FROM F1357Leg TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.F1357CTipoPre = ? and TM1.F1357CPer = ( ?) and TM1.F1357CSec = ? and TM1.LegNumero = ? and TM1.F1357LTipoReg = ( ?) ORDER BY TM1.CliCod, TM1.EmpCod, TM1.F1357CTipoPre, TM1.F1357CPer, TM1.F1357CSec, TM1.LegNumero, TM1.F1357LTipoReg ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002G7", "SELECT CliCod FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002G8", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002G9", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LTipoReg FROM F1357Leg WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LTipoReg = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002G10", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LTipoReg FROM F1357Leg WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and F1357CTipoPre > ? or F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CPer > ( ?) or F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CSec > ? or F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and LegNumero > ? or LegNumero = ? and F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357LTipoReg > ( ?)) ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LTipoReg  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002G11", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LTipoReg FROM F1357Leg WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and F1357CTipoPre < ? or F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CPer < ( ?) or F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CSec < ? or F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and LegNumero < ? or LegNumero = ? and F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357LTipoReg < ( ?)) ORDER BY CliCod DESC, EmpCod DESC, F1357CTipoPre DESC, F1357CPer DESC, F1357CSec DESC, LegNumero DESC, F1357LTipoReg DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T002G12", "SAVEPOINT gxupdate;INSERT INTO F1357Leg(F1357LTipoReg, F1357LCuil, F1357LPerDesd, F1357LPerHas, F1357LMeses, F1357LBeneficio, F1357LLargaDist, F1357LLey27424, F1357L27549, F1357LTeletrabajo, F1357LMilitar, F1357LLargaDistCT_40_1989, CliCod, EmpCod, LegNumero, F1357CTipoPre, F1357CPer, F1357CSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002G13", "SAVEPOINT gxupdate;UPDATE F1357Leg SET F1357LCuil=?, F1357LPerDesd=?, F1357LPerHas=?, F1357LMeses=?, F1357LBeneficio=?, F1357LLargaDist=?, F1357LLey27424=?, F1357L27549=?, F1357LTeletrabajo=?, F1357LMilitar=?, F1357LLargaDistCT_40_1989=?  WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LTipoReg = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002G14", "SAVEPOINT gxupdate;DELETE FROM F1357Leg  WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LTipoReg = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002G15", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LTipoReg FROM F1357Leg ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LTipoReg ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002G16", "SELECT CliCod FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002G17", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 2);
               ((String[]) buf[1])[0] = rslt.getString(2, 11);
               ((String[]) buf[2])[0] = rslt.getString(3, 8);
               ((String[]) buf[3])[0] = rslt.getString(4, 8);
               ((String[]) buf[4])[0] = rslt.getString(5, 2);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 1);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               ((byte[]) buf[15])[0] = rslt.getByte(16);
               ((String[]) buf[16])[0] = rslt.getString(17, 6);
               ((byte[]) buf[17])[0] = rslt.getByte(18);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 2);
               ((String[]) buf[1])[0] = rslt.getString(2, 11);
               ((String[]) buf[2])[0] = rslt.getString(3, 8);
               ((String[]) buf[3])[0] = rslt.getString(4, 8);
               ((String[]) buf[4])[0] = rslt.getString(5, 2);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 1);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               ((byte[]) buf[15])[0] = rslt.getByte(16);
               ((String[]) buf[16])[0] = rslt.getString(17, 6);
               ((byte[]) buf[17])[0] = rslt.getByte(18);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 2);
               ((String[]) buf[1])[0] = rslt.getString(2, 11);
               ((String[]) buf[2])[0] = rslt.getString(3, 8);
               ((String[]) buf[3])[0] = rslt.getString(4, 8);
               ((String[]) buf[4])[0] = rslt.getString(5, 2);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 1);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               ((byte[]) buf[15])[0] = rslt.getByte(16);
               ((String[]) buf[16])[0] = rslt.getString(17, 6);
               ((byte[]) buf[17])[0] = rslt.getByte(18);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               return;
            case 9 :
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
               return;
            case 15 :
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
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 2);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 2);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
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
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 2);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 2);
               return;
            case 8 :
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
               stmt.setByte(16, ((Number) parms[15]).byteValue());
               stmt.setString(17, (String)parms[16], 6);
               stmt.setByte(18, ((Number) parms[17]).byteValue());
               stmt.setShort(19, ((Number) parms[18]).shortValue());
               stmt.setInt(20, ((Number) parms[19]).intValue());
               stmt.setInt(21, ((Number) parms[20]).intValue());
               stmt.setInt(22, ((Number) parms[21]).intValue());
               stmt.setByte(23, ((Number) parms[22]).byteValue());
               stmt.setString(24, (String)parms[23], 6);
               stmt.setByte(25, ((Number) parms[24]).byteValue());
               stmt.setShort(26, ((Number) parms[25]).shortValue());
               stmt.setInt(27, ((Number) parms[26]).intValue());
               stmt.setString(28, (String)parms[27], 2);
               return;
            case 9 :
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
               stmt.setByte(16, ((Number) parms[15]).byteValue());
               stmt.setString(17, (String)parms[16], 6);
               stmt.setByte(18, ((Number) parms[17]).byteValue());
               stmt.setShort(19, ((Number) parms[18]).shortValue());
               stmt.setInt(20, ((Number) parms[19]).intValue());
               stmt.setInt(21, ((Number) parms[20]).intValue());
               stmt.setInt(22, ((Number) parms[21]).intValue());
               stmt.setByte(23, ((Number) parms[22]).byteValue());
               stmt.setString(24, (String)parms[23], 6);
               stmt.setByte(25, ((Number) parms[24]).byteValue());
               stmt.setShort(26, ((Number) parms[25]).shortValue());
               stmt.setInt(27, ((Number) parms[26]).intValue());
               stmt.setString(28, (String)parms[27], 2);
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 2);
               stmt.setString(2, (String)parms[1], 11);
               stmt.setString(3, (String)parms[2], 8);
               stmt.setString(4, (String)parms[3], 8);
               stmt.setString(5, (String)parms[4], 2);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 1);
               stmt.setString(8, (String)parms[7], 1);
               stmt.setString(9, (String)parms[8], 1);
               stmt.setString(10, (String)parms[9], 1);
               stmt.setString(11, (String)parms[10], 1);
               stmt.setString(12, (String)parms[11], 1);
               stmt.setInt(13, ((Number) parms[12]).intValue());
               stmt.setShort(14, ((Number) parms[13]).shortValue());
               stmt.setInt(15, ((Number) parms[14]).intValue());
               stmt.setByte(16, ((Number) parms[15]).byteValue());
               stmt.setString(17, (String)parms[16], 6);
               stmt.setByte(18, ((Number) parms[17]).byteValue());
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 11);
               stmt.setString(2, (String)parms[1], 8);
               stmt.setString(3, (String)parms[2], 8);
               stmt.setString(4, (String)parms[3], 2);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setString(6, (String)parms[5], 1);
               stmt.setString(7, (String)parms[6], 1);
               stmt.setString(8, (String)parms[7], 1);
               stmt.setString(9, (String)parms[8], 1);
               stmt.setString(10, (String)parms[9], 1);
               stmt.setString(11, (String)parms[10], 1);
               stmt.setInt(12, ((Number) parms[11]).intValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setByte(14, ((Number) parms[13]).byteValue());
               stmt.setString(15, (String)parms[14], 6);
               stmt.setByte(16, ((Number) parms[15]).byteValue());
               stmt.setInt(17, ((Number) parms[16]).intValue());
               stmt.setString(18, (String)parms[17], 2);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 2);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

