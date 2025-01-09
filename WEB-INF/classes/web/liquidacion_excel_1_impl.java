package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class liquidacion_excel_1_impl extends GXDataArea
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
         A31LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_4( A3CliCod, A1EmpCod, A31LiqNro, A6LegNumero) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Liquidacion_Excel_1", ""), (short)(0)) ;
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

   public liquidacion_excel_1_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public liquidacion_excel_1_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacion_excel_1_impl.class ));
   }

   public liquidacion_excel_1_impl( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbDTipoConCod = new HTMLChoice();
      chkDConVariable = UIFactory.getCheckbox(this);
      cmbDConPrereq = new HTMLChoice();
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
      if ( cmbDTipoConCod.getItemCount() > 0 )
      {
         A464DTipoConCod = cmbDTipoConCod.getValidValue(A464DTipoConCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "A464DTipoConCod", A464DTipoConCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbDTipoConCod.setValue( GXutil.rtrim( A464DTipoConCod) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDTipoConCod.getInternalname(), "Values", cmbDTipoConCod.ToJavascriptSource(), true);
      }
      A466DConVariable = GXutil.strtobool( GXutil.booltostr( A466DConVariable)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A466DConVariable", A466DConVariable);
      if ( cmbDConPrereq.getItemCount() > 0 )
      {
         A1067DConPrereq = cmbDConPrereq.getValidValue(A1067DConPrereq) ;
         n1067DConPrereq = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1067DConPrereq", A1067DConPrereq);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbDConPrereq.setValue( GXutil.rtrim( A1067DConPrereq) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDConPrereq.getInternalname(), "Values", cmbDConPrereq.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "Liquidacion_Excel_1", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Liquidacion_Excel_1.htm");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_Liquidacion_Excel_1.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqNro_Internalname, GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqNro_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqNro_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqNro_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegNumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDSecuencial_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDSecuencial_Internalname, httpContext.getMessage( "DSecuencial", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDSecuencial_Internalname, GXutil.ltrim( localUtil.ntoc( A81LiqDSecuencial, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDSecuencial_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A81LiqDSecuencial), "ZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A81LiqDSecuencial), "ZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDSecuencial_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDSecuencial_Enabled, 0, "text", "1", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDConCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtDConCodigo_Internalname, httpContext.getMessage( "Codigo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtDConCodigo_Internalname, GXutil.rtrim( A394DConCodigo), GXutil.rtrim( localUtil.format( A394DConCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDConCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtDConCodigo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDConDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtDConDescrip_Internalname, httpContext.getMessage( "Descrip", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtDConDescrip_Internalname, A393DConDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", (short)(0), 1, edtDConDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDLiqPeriodo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtDLiqPeriodo_Internalname, httpContext.getMessage( "Periodo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtDLiqPeriodo_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtDLiqPeriodo_Internalname, localUtil.format(A397DLiqPeriodo, "99/99/9999"), localUtil.format( A397DLiqPeriodo, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDLiqPeriodo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtDLiqPeriodo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtDLiqPeriodo_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtDLiqPeriodo_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Liquidacion_Excel_1.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDTLiqCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtDTLiqCod_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtDTLiqCod_Internalname, GXutil.rtrim( A400DTLiqCod), GXutil.rtrim( localUtil.format( A400DTLiqCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDTLiqCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtDTLiqCod_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodigoCaracter", "left", true, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbDTipoConCod.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbDTipoConCod.getInternalname(), httpContext.getMessage( "Con Cod", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbDTipoConCod, cmbDTipoConCod.getInternalname(), GXutil.rtrim( A464DTipoConCod), 1, cmbDTipoConCod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbDTipoConCod.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,79);\"", "", true, (byte)(0), "HLP_Liquidacion_Excel_1.htm");
      cmbDTipoConCod.setValue( GXutil.rtrim( A464DTipoConCod) );
      httpContext.ajax_rsp_assign_prop("", false, cmbDTipoConCod.getInternalname(), "Values", cmbDTipoConCod.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDSubTipoConCod1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtDSubTipoConCod1_Internalname, httpContext.getMessage( "Con Cod1", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtDSubTipoConCod1_Internalname, GXutil.rtrim( A468DSubTipoConCod1), GXutil.rtrim( localUtil.format( A468DSubTipoConCod1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,84);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDSubTipoConCod1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtDSubTipoConCod1_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDSubTipoConCod2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtDSubTipoConCod2_Internalname, httpContext.getMessage( "Con Cod2", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtDSubTipoConCod2_Internalname, GXutil.rtrim( A732DSubTipoConCod2), GXutil.rtrim( localUtil.format( A732DSubTipoConCod2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,89);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDSubTipoConCod2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtDSubTipoConCod2_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDClasifAux_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDClasifAux_Internalname, httpContext.getMessage( "Clasificación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDClasifAux_Internalname, A2149LiqDClasifAux, GXutil.rtrim( localUtil.format( A2149LiqDClasifAux, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,94);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDClasifAux_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDClasifAux_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDCanti_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDCanti_Internalname, httpContext.getMessage( "Cantidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDCanti_Internalname, GXutil.ltrim( localUtil.ntoc( A269LiqDCanti, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDCanti_Enabled!=0) ? localUtil.format( A269LiqDCanti, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A269LiqDCanti, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,99);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDCanti_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDCanti_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDValUni_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDValUni_Internalname, httpContext.getMessage( "Unitario", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDValUni_Internalname, GXutil.ltrim( localUtil.ntoc( A277LiqDValUni, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDValUni_Enabled!=0) ? localUtil.format( A277LiqDValUni, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A277LiqDValUni, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,104);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDValUni_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDValUni_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDImporte_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDImporte_Internalname, httpContext.getMessage( "Importe", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDImporte_Internalname, GXutil.ltrim( localUtil.ntoc( A276LiqDImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDImporte_Enabled!=0) ? localUtil.format( A276LiqDImporte, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A276LiqDImporte, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,109);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDImporte_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDImporte_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDImpCalcu_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDImpCalcu_Internalname, httpContext.getMessage( "Calculado", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 114,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDImpCalcu_Internalname, GXutil.ltrim( localUtil.ntoc( A275LiqDImpCalcu, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDImpCalcu_Enabled!=0) ? localUtil.format( A275LiqDImpCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A275LiqDImpCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,114);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDImpCalcu_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDImpCalcu_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "ImportesSigned", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDFormula_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDFormula_Internalname, httpContext.getMessage( "Formula", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 119,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtLiqDFormula_Internalname, A274LiqDFormula, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,119);\"", (short)(0), 1, edtLiqDFormula_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDErrorDesc_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDErrorDesc_Internalname, httpContext.getMessage( "Error", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 124,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtLiqDErrorDesc_Internalname, A270LiqDErrorDesc, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,124);\"", (short)(0), 1, edtLiqDErrorDesc_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkDConVariable.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkDConVariable.getInternalname(), httpContext.getMessage( "Variable", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 129,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkDConVariable.getInternalname(), GXutil.booltostr( A466DConVariable), "", httpContext.getMessage( "Variable", ""), 1, chkDConVariable.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(129, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,129);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDConOrden_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtDConOrden_Internalname, httpContext.getMessage( "Orden", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 134,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtDConOrden_Internalname, GXutil.ltrim( localUtil.ntoc( A471DConOrden, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtDConOrden_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A471DConOrden), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A471DConOrden), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,134);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDConOrden_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtDConOrden_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDLiqPerAno_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtDLiqPerAno_Internalname, httpContext.getMessage( "Per Ano", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 139,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtDLiqPerAno_Internalname, GXutil.ltrim( localUtil.ntoc( A742DLiqPerAno, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtDLiqPerAno_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A742DLiqPerAno), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A742DLiqPerAno), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,139);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDLiqPerAno_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtDLiqPerAno_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Anio", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDSIPAApo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDSIPAApo_Internalname, httpContext.getMessage( "DSIPAApo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 144,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDSIPAApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1051LiqDSIPAApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDSIPAApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1051LiqDSIPAApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1051LiqDSIPAApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,144);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDSIPAApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDSIPAApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDSIPACont_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDSIPACont_Internalname, httpContext.getMessage( "DSIPACont", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 149,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDSIPACont_Internalname, GXutil.ltrim( localUtil.ntoc( A1052LiqDSIPACont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDSIPACont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1052LiqDSIPACont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1052LiqDSIPACont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,149);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDSIPACont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDSIPACont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDINSSJyPApo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDINSSJyPApo_Internalname, httpContext.getMessage( "DINSSJy PApo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 154,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDINSSJyPApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1053LiqDINSSJyPApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDINSSJyPApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1053LiqDINSSJyPApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1053LiqDINSSJyPApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,154);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDINSSJyPApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDINSSJyPApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDINSSJyPCont_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDINSSJyPCont_Internalname, httpContext.getMessage( "DINSSJy PCont", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 159,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDINSSJyPCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1054LiqDINSSJyPCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDINSSJyPCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1054LiqDINSSJyPCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1054LiqDINSSJyPCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,159);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDINSSJyPCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDINSSJyPCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDObraSocApo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDObraSocApo_Internalname, httpContext.getMessage( "Soc Apo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 164,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDObraSocApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1055LiqDObraSocApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDObraSocApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1055LiqDObraSocApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1055LiqDObraSocApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,164);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDObraSocApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDObraSocApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDObraSocCont_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDObraSocCont_Internalname, httpContext.getMessage( "Soc Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 169,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDObraSocCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1056LiqDObraSocCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDObraSocCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1056LiqDObraSocCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1056LiqDObraSocCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,169);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDObraSocCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDObraSocCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDFonSolRedApo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDFonSolRedApo_Internalname, httpContext.getMessage( "Red Apo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 174,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDFonSolRedApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1057LiqDFonSolRedApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDFonSolRedApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1057LiqDFonSolRedApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1057LiqDFonSolRedApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,174);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDFonSolRedApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDFonSolRedApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDFonSolRedCont_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDFonSolRedCont_Internalname, httpContext.getMessage( "Red Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 179,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDFonSolRedCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1058LiqDFonSolRedCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDFonSolRedCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1058LiqDFonSolRedCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1058LiqDFonSolRedCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,179);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDFonSolRedCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDFonSolRedCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDRenateaApo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDRenateaApo_Internalname, httpContext.getMessage( "DRenatea Apo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 184,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDRenateaApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1059LiqDRenateaApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDRenateaApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1059LiqDRenateaApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1059LiqDRenateaApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,184);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDRenateaApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDRenateaApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDRenateaCont_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDRenateaCont_Internalname, httpContext.getMessage( "DRenatea Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 189,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDRenateaCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1060LiqDRenateaCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDRenateaCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1060LiqDRenateaCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1060LiqDRenateaCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,189);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDRenateaCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDRenateaCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDAsigFamCont_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDAsigFamCont_Internalname, httpContext.getMessage( "Fam Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 194,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDAsigFamCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1061LiqDAsigFamCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDAsigFamCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1061LiqDAsigFamCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1061LiqDAsigFamCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,194);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDAsigFamCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDAsigFamCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDFonNacEmpCont_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDFonNacEmpCont_Internalname, httpContext.getMessage( "Emp Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 199,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDFonNacEmpCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1062LiqDFonNacEmpCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDFonNacEmpCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1062LiqDFonNacEmpCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1062LiqDFonNacEmpCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,199);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDFonNacEmpCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDFonNacEmpCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      drawcontrols1( ) ;
   }

   public void drawcontrols1( )
   {
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDLeyRieTrabCont_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDLeyRieTrabCont_Internalname, httpContext.getMessage( "Trab Cont", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 204,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDLeyRieTrabCont_Internalname, GXutil.ltrim( localUtil.ntoc( A1063LiqDLeyRieTrabCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDLeyRieTrabCont_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1063LiqDLeyRieTrabCont), "9") : localUtil.format( DecimalUtil.doubleToDec(A1063LiqDLeyRieTrabCont), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,204);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDLeyRieTrabCont_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDLeyRieTrabCont_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDRegDifApo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDRegDifApo_Internalname, httpContext.getMessage( "Dif Apo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 209,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDRegDifApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1064LiqDRegDifApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDRegDifApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1064LiqDRegDifApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1064LiqDRegDifApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,209);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDRegDifApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDRegDifApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDRegEspApo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDRegEspApo_Internalname, httpContext.getMessage( "Esp Apo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 214,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDRegEspApo_Internalname, GXutil.ltrim( localUtil.ntoc( A1065LiqDRegEspApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDRegEspApo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1065LiqDRegEspApo), "9") : localUtil.format( DecimalUtil.doubleToDec(A1065LiqDRegEspApo), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,214);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDRegEspApo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDRegEspApo_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbDConPrereq.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbDConPrereq.getInternalname(), httpContext.getMessage( "Prereq (borrar)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 219,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbDConPrereq, cmbDConPrereq.getInternalname(), GXutil.rtrim( A1067DConPrereq), 1, cmbDConPrereq.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbDConPrereq.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,219);\"", "", true, (byte)(0), "HLP_Liquidacion_Excel_1.htm");
      cmbDConPrereq.setValue( GXutil.rtrim( A1067DConPrereq) );
      httpContext.ajax_rsp_assign_prop("", false, cmbDConPrereq.getInternalname(), "Values", cmbDConPrereq.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLiqDOrdVis_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLiqDOrdVis_Internalname, httpContext.getMessage( "DOrd Vis", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 224,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLiqDOrdVis_Internalname, GXutil.ltrim( localUtil.ntoc( A1134LiqDOrdVis, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLiqDOrdVis_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1134LiqDOrdVis), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1134LiqDOrdVis), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,224);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLiqDOrdVis_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLiqDOrdVis_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDConLiqBasica_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtDConLiqBasica_Internalname, httpContext.getMessage( "Basica (borrar)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 229,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtDConLiqBasica_Internalname, GXutil.ltrim( localUtil.ntoc( A1642DConLiqBasica, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtDConLiqBasica_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1642DConLiqBasica), "9") : localUtil.format( DecimalUtil.doubleToDec(A1642DConLiqBasica), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,229);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDConLiqBasica_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtDConLiqBasica_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDConConveCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtDConConveCodigo_Internalname, httpContext.getMessage( "Conve Codigo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 234,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtDConConveCodigo_Internalname, GXutil.rtrim( A1753DConConveCodigo), GXutil.rtrim( localUtil.format( A1753DConConveCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,234);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDConConveCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtDConConveCodigo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Liquidacion_Excel_1.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 239,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 241,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Liquidacion_Excel_1.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 243,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Liquidacion_Excel_1.htm");
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
         Z81LiqDSecuencial = (int)(localUtil.ctol( httpContext.cgiGet( "Z81LiqDSecuencial"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z394DConCodigo = httpContext.cgiGet( "Z394DConCodigo") ;
         Z393DConDescrip = httpContext.cgiGet( "Z393DConDescrip") ;
         Z397DLiqPeriodo = localUtil.ctod( httpContext.cgiGet( "Z397DLiqPeriodo"), 0) ;
         Z400DTLiqCod = httpContext.cgiGet( "Z400DTLiqCod") ;
         Z464DTipoConCod = httpContext.cgiGet( "Z464DTipoConCod") ;
         Z468DSubTipoConCod1 = httpContext.cgiGet( "Z468DSubTipoConCod1") ;
         n468DSubTipoConCod1 = ((GXutil.strcmp("", A468DSubTipoConCod1)==0) ? true : false) ;
         Z732DSubTipoConCod2 = httpContext.cgiGet( "Z732DSubTipoConCod2") ;
         n732DSubTipoConCod2 = ((GXutil.strcmp("", A732DSubTipoConCod2)==0) ? true : false) ;
         Z2149LiqDClasifAux = httpContext.cgiGet( "Z2149LiqDClasifAux") ;
         Z269LiqDCanti = localUtil.ctond( httpContext.cgiGet( "Z269LiqDCanti")) ;
         n269LiqDCanti = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A269LiqDCanti)==0) ? true : false) ;
         Z277LiqDValUni = localUtil.ctond( httpContext.cgiGet( "Z277LiqDValUni")) ;
         n277LiqDValUni = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A277LiqDValUni)==0) ? true : false) ;
         Z276LiqDImporte = localUtil.ctond( httpContext.cgiGet( "Z276LiqDImporte")) ;
         n276LiqDImporte = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A276LiqDImporte)==0) ? true : false) ;
         Z275LiqDImpCalcu = localUtil.ctond( httpContext.cgiGet( "Z275LiqDImpCalcu")) ;
         n275LiqDImpCalcu = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A275LiqDImpCalcu)==0) ? true : false) ;
         Z270LiqDErrorDesc = httpContext.cgiGet( "Z270LiqDErrorDesc") ;
         n270LiqDErrorDesc = ((GXutil.strcmp("", A270LiqDErrorDesc)==0) ? true : false) ;
         Z466DConVariable = GXutil.strtobool( httpContext.cgiGet( "Z466DConVariable")) ;
         Z471DConOrden = (int)(localUtil.ctol( httpContext.cgiGet( "Z471DConOrden"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z742DLiqPerAno = (short)(localUtil.ctol( httpContext.cgiGet( "Z742DLiqPerAno"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1051LiqDSIPAApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1051LiqDSIPAApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1052LiqDSIPACont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1052LiqDSIPACont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1053LiqDINSSJyPApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1053LiqDINSSJyPApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1054LiqDINSSJyPCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1054LiqDINSSJyPCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1055LiqDObraSocApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1055LiqDObraSocApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1056LiqDObraSocCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1056LiqDObraSocCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1057LiqDFonSolRedApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1057LiqDFonSolRedApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1058LiqDFonSolRedCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1058LiqDFonSolRedCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1059LiqDRenateaApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1059LiqDRenateaApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1060LiqDRenateaCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1060LiqDRenateaCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1061LiqDAsigFamCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1061LiqDAsigFamCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1062LiqDFonNacEmpCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1062LiqDFonNacEmpCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1063LiqDLeyRieTrabCont = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1063LiqDLeyRieTrabCont"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1064LiqDRegDifApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1064LiqDRegDifApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1065LiqDRegEspApo = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1065LiqDRegEspApo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1067DConPrereq = httpContext.cgiGet( "Z1067DConPrereq") ;
         n1067DConPrereq = ((GXutil.strcmp("", A1067DConPrereq)==0) ? true : false) ;
         Z1134LiqDOrdVis = (short)(localUtil.ctol( httpContext.cgiGet( "Z1134LiqDOrdVis"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z1642DConLiqBasica = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1642DConLiqBasica"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         n1642DConLiqBasica = ((0==A1642DConLiqBasica) ? true : false) ;
         Z1753DConConveCodigo = httpContext.cgiGet( "Z1753DConConveCodigo") ;
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
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDSecuencial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDSecuencial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDSECUENCIAL");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDSecuencial_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A81LiqDSecuencial = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A81LiqDSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81LiqDSecuencial), 5, 0));
         }
         else
         {
            A81LiqDSecuencial = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqDSecuencial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A81LiqDSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81LiqDSecuencial), 5, 0));
         }
         A394DConCodigo = httpContext.cgiGet( edtDConCodigo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A394DConCodigo", A394DConCodigo);
         A393DConDescrip = httpContext.cgiGet( edtDConDescrip_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A393DConDescrip", A393DConDescrip);
         if ( localUtil.vcdate( httpContext.cgiGet( edtDLiqPeriodo_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "DLIQPERIODO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtDLiqPeriodo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A397DLiqPeriodo = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "A397DLiqPeriodo", localUtil.format(A397DLiqPeriodo, "99/99/9999"));
         }
         else
         {
            A397DLiqPeriodo = localUtil.ctod( httpContext.cgiGet( edtDLiqPeriodo_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A397DLiqPeriodo", localUtil.format(A397DLiqPeriodo, "99/99/9999"));
         }
         A400DTLiqCod = httpContext.cgiGet( edtDTLiqCod_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A400DTLiqCod", A400DTLiqCod);
         cmbDTipoConCod.setValue( httpContext.cgiGet( cmbDTipoConCod.getInternalname()) );
         A464DTipoConCod = httpContext.cgiGet( cmbDTipoConCod.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "A464DTipoConCod", A464DTipoConCod);
         A468DSubTipoConCod1 = httpContext.cgiGet( edtDSubTipoConCod1_Internalname) ;
         n468DSubTipoConCod1 = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A468DSubTipoConCod1", A468DSubTipoConCod1);
         n468DSubTipoConCod1 = ((GXutil.strcmp("", A468DSubTipoConCod1)==0) ? true : false) ;
         A732DSubTipoConCod2 = httpContext.cgiGet( edtDSubTipoConCod2_Internalname) ;
         n732DSubTipoConCod2 = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A732DSubTipoConCod2", A732DSubTipoConCod2);
         n732DSubTipoConCod2 = ((GXutil.strcmp("", A732DSubTipoConCod2)==0) ? true : false) ;
         A2149LiqDClasifAux = httpContext.cgiGet( edtLiqDClasifAux_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2149LiqDClasifAux", A2149LiqDClasifAux);
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqDCanti_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqDCanti_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDCANTI");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDCanti_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A269LiqDCanti = DecimalUtil.ZERO ;
            n269LiqDCanti = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A269LiqDCanti", GXutil.ltrimstr( A269LiqDCanti, 14, 2));
         }
         else
         {
            A269LiqDCanti = localUtil.ctond( httpContext.cgiGet( edtLiqDCanti_Internalname)) ;
            n269LiqDCanti = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A269LiqDCanti", GXutil.ltrimstr( A269LiqDCanti, 14, 2));
         }
         n269LiqDCanti = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A269LiqDCanti)==0) ? true : false) ;
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqDValUni_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqDValUni_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDVALUNI");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDValUni_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A277LiqDValUni = DecimalUtil.ZERO ;
            n277LiqDValUni = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A277LiqDValUni", GXutil.ltrimstr( A277LiqDValUni, 14, 2));
         }
         else
         {
            A277LiqDValUni = localUtil.ctond( httpContext.cgiGet( edtLiqDValUni_Internalname)) ;
            n277LiqDValUni = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A277LiqDValUni", GXutil.ltrimstr( A277LiqDValUni, 14, 2));
         }
         n277LiqDValUni = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A277LiqDValUni)==0) ? true : false) ;
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqDImporte_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqDImporte_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDIMPORTE");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDImporte_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A276LiqDImporte = DecimalUtil.ZERO ;
            n276LiqDImporte = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A276LiqDImporte", GXutil.ltrimstr( A276LiqDImporte, 14, 2));
         }
         else
         {
            A276LiqDImporte = localUtil.ctond( httpContext.cgiGet( edtLiqDImporte_Internalname)) ;
            n276LiqDImporte = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A276LiqDImporte", GXutil.ltrimstr( A276LiqDImporte, 14, 2));
         }
         n276LiqDImporte = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A276LiqDImporte)==0) ? true : false) ;
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqDImpCalcu_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLiqDImpCalcu_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDIMPCALCU");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDImpCalcu_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A275LiqDImpCalcu = DecimalUtil.ZERO ;
            n275LiqDImpCalcu = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A275LiqDImpCalcu", GXutil.ltrimstr( A275LiqDImpCalcu, 14, 2));
         }
         else
         {
            A275LiqDImpCalcu = localUtil.ctond( httpContext.cgiGet( edtLiqDImpCalcu_Internalname)) ;
            n275LiqDImpCalcu = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A275LiqDImpCalcu", GXutil.ltrimstr( A275LiqDImpCalcu, 14, 2));
         }
         n275LiqDImpCalcu = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A275LiqDImpCalcu)==0) ? true : false) ;
         A274LiqDFormula = httpContext.cgiGet( edtLiqDFormula_Internalname) ;
         n274LiqDFormula = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A274LiqDFormula", A274LiqDFormula);
         n274LiqDFormula = ((GXutil.strcmp("", A274LiqDFormula)==0) ? true : false) ;
         A270LiqDErrorDesc = httpContext.cgiGet( edtLiqDErrorDesc_Internalname) ;
         n270LiqDErrorDesc = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A270LiqDErrorDesc", A270LiqDErrorDesc);
         n270LiqDErrorDesc = ((GXutil.strcmp("", A270LiqDErrorDesc)==0) ? true : false) ;
         A466DConVariable = GXutil.strtobool( httpContext.cgiGet( chkDConVariable.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "A466DConVariable", A466DConVariable);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtDConOrden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtDConOrden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "DCONORDEN");
            AnyError = (short)(1) ;
            GX_FocusControl = edtDConOrden_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A471DConOrden = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A471DConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A471DConOrden), 8, 0));
         }
         else
         {
            A471DConOrden = (int)(localUtil.ctol( httpContext.cgiGet( edtDConOrden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A471DConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A471DConOrden), 8, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtDLiqPerAno_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtDLiqPerAno_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "DLIQPERANO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtDLiqPerAno_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A742DLiqPerAno = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A742DLiqPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(A742DLiqPerAno), 4, 0));
         }
         else
         {
            A742DLiqPerAno = (short)(localUtil.ctol( httpContext.cgiGet( edtDLiqPerAno_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A742DLiqPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(A742DLiqPerAno), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDSIPAApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDSIPAApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDSIPAAPO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDSIPAApo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1051LiqDSIPAApo = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1051LiqDSIPAApo", GXutil.str( A1051LiqDSIPAApo, 1, 0));
         }
         else
         {
            A1051LiqDSIPAApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtLiqDSIPAApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1051LiqDSIPAApo", GXutil.str( A1051LiqDSIPAApo, 1, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDSIPACont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDSIPACont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDSIPACONT");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDSIPACont_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1052LiqDSIPACont = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1052LiqDSIPACont", GXutil.str( A1052LiqDSIPACont, 1, 0));
         }
         else
         {
            A1052LiqDSIPACont = (byte)(localUtil.ctol( httpContext.cgiGet( edtLiqDSIPACont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1052LiqDSIPACont", GXutil.str( A1052LiqDSIPACont, 1, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDINSSJyPApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDINSSJyPApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDINSSJYPAPO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDINSSJyPApo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1053LiqDINSSJyPApo = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1053LiqDINSSJyPApo", GXutil.str( A1053LiqDINSSJyPApo, 1, 0));
         }
         else
         {
            A1053LiqDINSSJyPApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtLiqDINSSJyPApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1053LiqDINSSJyPApo", GXutil.str( A1053LiqDINSSJyPApo, 1, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDINSSJyPCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDINSSJyPCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDINSSJYPCONT");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDINSSJyPCont_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1054LiqDINSSJyPCont = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1054LiqDINSSJyPCont", GXutil.str( A1054LiqDINSSJyPCont, 1, 0));
         }
         else
         {
            A1054LiqDINSSJyPCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtLiqDINSSJyPCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1054LiqDINSSJyPCont", GXutil.str( A1054LiqDINSSJyPCont, 1, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDObraSocApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDObraSocApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDOBRASOCAPO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDObraSocApo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1055LiqDObraSocApo = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1055LiqDObraSocApo", GXutil.str( A1055LiqDObraSocApo, 1, 0));
         }
         else
         {
            A1055LiqDObraSocApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtLiqDObraSocApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1055LiqDObraSocApo", GXutil.str( A1055LiqDObraSocApo, 1, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDObraSocCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDObraSocCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDOBRASOCCONT");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDObraSocCont_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1056LiqDObraSocCont = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1056LiqDObraSocCont", GXutil.str( A1056LiqDObraSocCont, 1, 0));
         }
         else
         {
            A1056LiqDObraSocCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtLiqDObraSocCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1056LiqDObraSocCont", GXutil.str( A1056LiqDObraSocCont, 1, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDFonSolRedApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDFonSolRedApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDFONSOLREDAPO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDFonSolRedApo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1057LiqDFonSolRedApo = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1057LiqDFonSolRedApo", GXutil.str( A1057LiqDFonSolRedApo, 1, 0));
         }
         else
         {
            A1057LiqDFonSolRedApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtLiqDFonSolRedApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1057LiqDFonSolRedApo", GXutil.str( A1057LiqDFonSolRedApo, 1, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDFonSolRedCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDFonSolRedCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDFONSOLREDCONT");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDFonSolRedCont_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1058LiqDFonSolRedCont = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1058LiqDFonSolRedCont", GXutil.str( A1058LiqDFonSolRedCont, 1, 0));
         }
         else
         {
            A1058LiqDFonSolRedCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtLiqDFonSolRedCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1058LiqDFonSolRedCont", GXutil.str( A1058LiqDFonSolRedCont, 1, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDRenateaApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDRenateaApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDRENATEAAPO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDRenateaApo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1059LiqDRenateaApo = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1059LiqDRenateaApo", GXutil.str( A1059LiqDRenateaApo, 1, 0));
         }
         else
         {
            A1059LiqDRenateaApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtLiqDRenateaApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1059LiqDRenateaApo", GXutil.str( A1059LiqDRenateaApo, 1, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDRenateaCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDRenateaCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDRENATEACONT");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDRenateaCont_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1060LiqDRenateaCont = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1060LiqDRenateaCont", GXutil.str( A1060LiqDRenateaCont, 1, 0));
         }
         else
         {
            A1060LiqDRenateaCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtLiqDRenateaCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1060LiqDRenateaCont", GXutil.str( A1060LiqDRenateaCont, 1, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDAsigFamCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDAsigFamCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDASIGFAMCONT");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDAsigFamCont_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1061LiqDAsigFamCont = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1061LiqDAsigFamCont", GXutil.str( A1061LiqDAsigFamCont, 1, 0));
         }
         else
         {
            A1061LiqDAsigFamCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtLiqDAsigFamCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1061LiqDAsigFamCont", GXutil.str( A1061LiqDAsigFamCont, 1, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDFonNacEmpCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDFonNacEmpCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDFONNACEMPCONT");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDFonNacEmpCont_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1062LiqDFonNacEmpCont = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1062LiqDFonNacEmpCont", GXutil.str( A1062LiqDFonNacEmpCont, 1, 0));
         }
         else
         {
            A1062LiqDFonNacEmpCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtLiqDFonNacEmpCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1062LiqDFonNacEmpCont", GXutil.str( A1062LiqDFonNacEmpCont, 1, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDLeyRieTrabCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDLeyRieTrabCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDLEYRIETRABCONT");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDLeyRieTrabCont_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1063LiqDLeyRieTrabCont = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1063LiqDLeyRieTrabCont", GXutil.str( A1063LiqDLeyRieTrabCont, 1, 0));
         }
         else
         {
            A1063LiqDLeyRieTrabCont = (byte)(localUtil.ctol( httpContext.cgiGet( edtLiqDLeyRieTrabCont_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1063LiqDLeyRieTrabCont", GXutil.str( A1063LiqDLeyRieTrabCont, 1, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDRegDifApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDRegDifApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDREGDIFAPO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDRegDifApo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1064LiqDRegDifApo = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1064LiqDRegDifApo", GXutil.str( A1064LiqDRegDifApo, 1, 0));
         }
         else
         {
            A1064LiqDRegDifApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtLiqDRegDifApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1064LiqDRegDifApo", GXutil.str( A1064LiqDRegDifApo, 1, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDRegEspApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDRegEspApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDREGESPAPO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDRegEspApo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1065LiqDRegEspApo = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1065LiqDRegEspApo", GXutil.str( A1065LiqDRegEspApo, 1, 0));
         }
         else
         {
            A1065LiqDRegEspApo = (byte)(localUtil.ctol( httpContext.cgiGet( edtLiqDRegEspApo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1065LiqDRegEspApo", GXutil.str( A1065LiqDRegEspApo, 1, 0));
         }
         cmbDConPrereq.setValue( httpContext.cgiGet( cmbDConPrereq.getInternalname()) );
         A1067DConPrereq = httpContext.cgiGet( cmbDConPrereq.getInternalname()) ;
         n1067DConPrereq = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1067DConPrereq", A1067DConPrereq);
         n1067DConPrereq = ((GXutil.strcmp("", A1067DConPrereq)==0) ? true : false) ;
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDOrdVis_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLiqDOrdVis_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LIQDORDVIS");
            AnyError = (short)(1) ;
            GX_FocusControl = edtLiqDOrdVis_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1134LiqDOrdVis = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1134LiqDOrdVis", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1134LiqDOrdVis), 4, 0));
         }
         else
         {
            A1134LiqDOrdVis = (short)(localUtil.ctol( httpContext.cgiGet( edtLiqDOrdVis_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1134LiqDOrdVis", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1134LiqDOrdVis), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtDConLiqBasica_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtDConLiqBasica_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "DCONLIQBASICA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtDConLiqBasica_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1642DConLiqBasica = (byte)(0) ;
            n1642DConLiqBasica = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1642DConLiqBasica", GXutil.str( A1642DConLiqBasica, 1, 0));
         }
         else
         {
            A1642DConLiqBasica = (byte)(localUtil.ctol( httpContext.cgiGet( edtDConLiqBasica_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1642DConLiqBasica = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1642DConLiqBasica", GXutil.str( A1642DConLiqBasica, 1, 0));
         }
         n1642DConLiqBasica = ((0==A1642DConLiqBasica) ? true : false) ;
         A1753DConConveCodigo = httpContext.cgiGet( edtDConConveCodigo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1753DConConveCodigo", A1753DConConveCodigo);
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
            A31LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
            A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A81LiqDSecuencial = (int)(GXutil.lval( httpContext.GetPar( "LiqDSecuencial"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A81LiqDSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81LiqDSecuencial), 5, 0));
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
            initAll0S26( ) ;
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
      disableAttributes0S26( ) ;
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

   public void resetCaption0S0( )
   {
   }

   public void zm0S26( int GX_JID )
   {
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z394DConCodigo = T000S3_A394DConCodigo[0] ;
            Z393DConDescrip = T000S3_A393DConDescrip[0] ;
            Z397DLiqPeriodo = T000S3_A397DLiqPeriodo[0] ;
            Z400DTLiqCod = T000S3_A400DTLiqCod[0] ;
            Z464DTipoConCod = T000S3_A464DTipoConCod[0] ;
            Z468DSubTipoConCod1 = T000S3_A468DSubTipoConCod1[0] ;
            Z732DSubTipoConCod2 = T000S3_A732DSubTipoConCod2[0] ;
            Z2149LiqDClasifAux = T000S3_A2149LiqDClasifAux[0] ;
            Z269LiqDCanti = T000S3_A269LiqDCanti[0] ;
            Z277LiqDValUni = T000S3_A277LiqDValUni[0] ;
            Z276LiqDImporte = T000S3_A276LiqDImporte[0] ;
            Z275LiqDImpCalcu = T000S3_A275LiqDImpCalcu[0] ;
            Z270LiqDErrorDesc = T000S3_A270LiqDErrorDesc[0] ;
            Z466DConVariable = T000S3_A466DConVariable[0] ;
            Z471DConOrden = T000S3_A471DConOrden[0] ;
            Z742DLiqPerAno = T000S3_A742DLiqPerAno[0] ;
            Z1051LiqDSIPAApo = T000S3_A1051LiqDSIPAApo[0] ;
            Z1052LiqDSIPACont = T000S3_A1052LiqDSIPACont[0] ;
            Z1053LiqDINSSJyPApo = T000S3_A1053LiqDINSSJyPApo[0] ;
            Z1054LiqDINSSJyPCont = T000S3_A1054LiqDINSSJyPCont[0] ;
            Z1055LiqDObraSocApo = T000S3_A1055LiqDObraSocApo[0] ;
            Z1056LiqDObraSocCont = T000S3_A1056LiqDObraSocCont[0] ;
            Z1057LiqDFonSolRedApo = T000S3_A1057LiqDFonSolRedApo[0] ;
            Z1058LiqDFonSolRedCont = T000S3_A1058LiqDFonSolRedCont[0] ;
            Z1059LiqDRenateaApo = T000S3_A1059LiqDRenateaApo[0] ;
            Z1060LiqDRenateaCont = T000S3_A1060LiqDRenateaCont[0] ;
            Z1061LiqDAsigFamCont = T000S3_A1061LiqDAsigFamCont[0] ;
            Z1062LiqDFonNacEmpCont = T000S3_A1062LiqDFonNacEmpCont[0] ;
            Z1063LiqDLeyRieTrabCont = T000S3_A1063LiqDLeyRieTrabCont[0] ;
            Z1064LiqDRegDifApo = T000S3_A1064LiqDRegDifApo[0] ;
            Z1065LiqDRegEspApo = T000S3_A1065LiqDRegEspApo[0] ;
            Z1067DConPrereq = T000S3_A1067DConPrereq[0] ;
            Z1134LiqDOrdVis = T000S3_A1134LiqDOrdVis[0] ;
            Z1642DConLiqBasica = T000S3_A1642DConLiqBasica[0] ;
            Z1753DConConveCodigo = T000S3_A1753DConConveCodigo[0] ;
         }
         else
         {
            Z394DConCodigo = A394DConCodigo ;
            Z393DConDescrip = A393DConDescrip ;
            Z397DLiqPeriodo = A397DLiqPeriodo ;
            Z400DTLiqCod = A400DTLiqCod ;
            Z464DTipoConCod = A464DTipoConCod ;
            Z468DSubTipoConCod1 = A468DSubTipoConCod1 ;
            Z732DSubTipoConCod2 = A732DSubTipoConCod2 ;
            Z2149LiqDClasifAux = A2149LiqDClasifAux ;
            Z269LiqDCanti = A269LiqDCanti ;
            Z277LiqDValUni = A277LiqDValUni ;
            Z276LiqDImporte = A276LiqDImporte ;
            Z275LiqDImpCalcu = A275LiqDImpCalcu ;
            Z270LiqDErrorDesc = A270LiqDErrorDesc ;
            Z466DConVariable = A466DConVariable ;
            Z471DConOrden = A471DConOrden ;
            Z742DLiqPerAno = A742DLiqPerAno ;
            Z1051LiqDSIPAApo = A1051LiqDSIPAApo ;
            Z1052LiqDSIPACont = A1052LiqDSIPACont ;
            Z1053LiqDINSSJyPApo = A1053LiqDINSSJyPApo ;
            Z1054LiqDINSSJyPCont = A1054LiqDINSSJyPCont ;
            Z1055LiqDObraSocApo = A1055LiqDObraSocApo ;
            Z1056LiqDObraSocCont = A1056LiqDObraSocCont ;
            Z1057LiqDFonSolRedApo = A1057LiqDFonSolRedApo ;
            Z1058LiqDFonSolRedCont = A1058LiqDFonSolRedCont ;
            Z1059LiqDRenateaApo = A1059LiqDRenateaApo ;
            Z1060LiqDRenateaCont = A1060LiqDRenateaCont ;
            Z1061LiqDAsigFamCont = A1061LiqDAsigFamCont ;
            Z1062LiqDFonNacEmpCont = A1062LiqDFonNacEmpCont ;
            Z1063LiqDLeyRieTrabCont = A1063LiqDLeyRieTrabCont ;
            Z1064LiqDRegDifApo = A1064LiqDRegDifApo ;
            Z1065LiqDRegEspApo = A1065LiqDRegEspApo ;
            Z1067DConPrereq = A1067DConPrereq ;
            Z1134LiqDOrdVis = A1134LiqDOrdVis ;
            Z1642DConLiqBasica = A1642DConLiqBasica ;
            Z1753DConConveCodigo = A1753DConConveCodigo ;
         }
      }
      if ( GX_JID == -3 )
      {
         Z81LiqDSecuencial = A81LiqDSecuencial ;
         Z394DConCodigo = A394DConCodigo ;
         Z393DConDescrip = A393DConDescrip ;
         Z397DLiqPeriodo = A397DLiqPeriodo ;
         Z400DTLiqCod = A400DTLiqCod ;
         Z464DTipoConCod = A464DTipoConCod ;
         Z468DSubTipoConCod1 = A468DSubTipoConCod1 ;
         Z732DSubTipoConCod2 = A732DSubTipoConCod2 ;
         Z2149LiqDClasifAux = A2149LiqDClasifAux ;
         Z269LiqDCanti = A269LiqDCanti ;
         Z277LiqDValUni = A277LiqDValUni ;
         Z276LiqDImporte = A276LiqDImporte ;
         Z275LiqDImpCalcu = A275LiqDImpCalcu ;
         Z274LiqDFormula = A274LiqDFormula ;
         Z270LiqDErrorDesc = A270LiqDErrorDesc ;
         Z466DConVariable = A466DConVariable ;
         Z471DConOrden = A471DConOrden ;
         Z742DLiqPerAno = A742DLiqPerAno ;
         Z1051LiqDSIPAApo = A1051LiqDSIPAApo ;
         Z1052LiqDSIPACont = A1052LiqDSIPACont ;
         Z1053LiqDINSSJyPApo = A1053LiqDINSSJyPApo ;
         Z1054LiqDINSSJyPCont = A1054LiqDINSSJyPCont ;
         Z1055LiqDObraSocApo = A1055LiqDObraSocApo ;
         Z1056LiqDObraSocCont = A1056LiqDObraSocCont ;
         Z1057LiqDFonSolRedApo = A1057LiqDFonSolRedApo ;
         Z1058LiqDFonSolRedCont = A1058LiqDFonSolRedCont ;
         Z1059LiqDRenateaApo = A1059LiqDRenateaApo ;
         Z1060LiqDRenateaCont = A1060LiqDRenateaCont ;
         Z1061LiqDAsigFamCont = A1061LiqDAsigFamCont ;
         Z1062LiqDFonNacEmpCont = A1062LiqDFonNacEmpCont ;
         Z1063LiqDLeyRieTrabCont = A1063LiqDLeyRieTrabCont ;
         Z1064LiqDRegDifApo = A1064LiqDRegDifApo ;
         Z1065LiqDRegEspApo = A1065LiqDRegEspApo ;
         Z1067DConPrereq = A1067DConPrereq ;
         Z1134LiqDOrdVis = A1134LiqDOrdVis ;
         Z1642DConLiqBasica = A1642DConLiqBasica ;
         Z1753DConConveCodigo = A1753DConConveCodigo ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z31LiqNro = A31LiqNro ;
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

   public void load0S26( )
   {
      /* Using cursor T000S5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound26 = (short)(1) ;
         A394DConCodigo = T000S5_A394DConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A394DConCodigo", A394DConCodigo);
         A393DConDescrip = T000S5_A393DConDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A393DConDescrip", A393DConDescrip);
         A397DLiqPeriodo = T000S5_A397DLiqPeriodo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A397DLiqPeriodo", localUtil.format(A397DLiqPeriodo, "99/99/9999"));
         A400DTLiqCod = T000S5_A400DTLiqCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A400DTLiqCod", A400DTLiqCod);
         A464DTipoConCod = T000S5_A464DTipoConCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A464DTipoConCod", A464DTipoConCod);
         A468DSubTipoConCod1 = T000S5_A468DSubTipoConCod1[0] ;
         n468DSubTipoConCod1 = T000S5_n468DSubTipoConCod1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A468DSubTipoConCod1", A468DSubTipoConCod1);
         A732DSubTipoConCod2 = T000S5_A732DSubTipoConCod2[0] ;
         n732DSubTipoConCod2 = T000S5_n732DSubTipoConCod2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A732DSubTipoConCod2", A732DSubTipoConCod2);
         A2149LiqDClasifAux = T000S5_A2149LiqDClasifAux[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2149LiqDClasifAux", A2149LiqDClasifAux);
         A269LiqDCanti = T000S5_A269LiqDCanti[0] ;
         n269LiqDCanti = T000S5_n269LiqDCanti[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A269LiqDCanti", GXutil.ltrimstr( A269LiqDCanti, 14, 2));
         A277LiqDValUni = T000S5_A277LiqDValUni[0] ;
         n277LiqDValUni = T000S5_n277LiqDValUni[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A277LiqDValUni", GXutil.ltrimstr( A277LiqDValUni, 14, 2));
         A276LiqDImporte = T000S5_A276LiqDImporte[0] ;
         n276LiqDImporte = T000S5_n276LiqDImporte[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A276LiqDImporte", GXutil.ltrimstr( A276LiqDImporte, 14, 2));
         A275LiqDImpCalcu = T000S5_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = T000S5_n275LiqDImpCalcu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A275LiqDImpCalcu", GXutil.ltrimstr( A275LiqDImpCalcu, 14, 2));
         A274LiqDFormula = T000S5_A274LiqDFormula[0] ;
         n274LiqDFormula = T000S5_n274LiqDFormula[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A274LiqDFormula", A274LiqDFormula);
         A270LiqDErrorDesc = T000S5_A270LiqDErrorDesc[0] ;
         n270LiqDErrorDesc = T000S5_n270LiqDErrorDesc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A270LiqDErrorDesc", A270LiqDErrorDesc);
         A466DConVariable = T000S5_A466DConVariable[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A466DConVariable", A466DConVariable);
         A471DConOrden = T000S5_A471DConOrden[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A471DConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A471DConOrden), 8, 0));
         A742DLiqPerAno = T000S5_A742DLiqPerAno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A742DLiqPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(A742DLiqPerAno), 4, 0));
         A1051LiqDSIPAApo = T000S5_A1051LiqDSIPAApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1051LiqDSIPAApo", GXutil.str( A1051LiqDSIPAApo, 1, 0));
         A1052LiqDSIPACont = T000S5_A1052LiqDSIPACont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1052LiqDSIPACont", GXutil.str( A1052LiqDSIPACont, 1, 0));
         A1053LiqDINSSJyPApo = T000S5_A1053LiqDINSSJyPApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1053LiqDINSSJyPApo", GXutil.str( A1053LiqDINSSJyPApo, 1, 0));
         A1054LiqDINSSJyPCont = T000S5_A1054LiqDINSSJyPCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1054LiqDINSSJyPCont", GXutil.str( A1054LiqDINSSJyPCont, 1, 0));
         A1055LiqDObraSocApo = T000S5_A1055LiqDObraSocApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1055LiqDObraSocApo", GXutil.str( A1055LiqDObraSocApo, 1, 0));
         A1056LiqDObraSocCont = T000S5_A1056LiqDObraSocCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1056LiqDObraSocCont", GXutil.str( A1056LiqDObraSocCont, 1, 0));
         A1057LiqDFonSolRedApo = T000S5_A1057LiqDFonSolRedApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1057LiqDFonSolRedApo", GXutil.str( A1057LiqDFonSolRedApo, 1, 0));
         A1058LiqDFonSolRedCont = T000S5_A1058LiqDFonSolRedCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1058LiqDFonSolRedCont", GXutil.str( A1058LiqDFonSolRedCont, 1, 0));
         A1059LiqDRenateaApo = T000S5_A1059LiqDRenateaApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1059LiqDRenateaApo", GXutil.str( A1059LiqDRenateaApo, 1, 0));
         A1060LiqDRenateaCont = T000S5_A1060LiqDRenateaCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1060LiqDRenateaCont", GXutil.str( A1060LiqDRenateaCont, 1, 0));
         A1061LiqDAsigFamCont = T000S5_A1061LiqDAsigFamCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1061LiqDAsigFamCont", GXutil.str( A1061LiqDAsigFamCont, 1, 0));
         A1062LiqDFonNacEmpCont = T000S5_A1062LiqDFonNacEmpCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1062LiqDFonNacEmpCont", GXutil.str( A1062LiqDFonNacEmpCont, 1, 0));
         A1063LiqDLeyRieTrabCont = T000S5_A1063LiqDLeyRieTrabCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1063LiqDLeyRieTrabCont", GXutil.str( A1063LiqDLeyRieTrabCont, 1, 0));
         A1064LiqDRegDifApo = T000S5_A1064LiqDRegDifApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1064LiqDRegDifApo", GXutil.str( A1064LiqDRegDifApo, 1, 0));
         A1065LiqDRegEspApo = T000S5_A1065LiqDRegEspApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1065LiqDRegEspApo", GXutil.str( A1065LiqDRegEspApo, 1, 0));
         A1067DConPrereq = T000S5_A1067DConPrereq[0] ;
         n1067DConPrereq = T000S5_n1067DConPrereq[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1067DConPrereq", A1067DConPrereq);
         A1134LiqDOrdVis = T000S5_A1134LiqDOrdVis[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1134LiqDOrdVis", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1134LiqDOrdVis), 4, 0));
         A1642DConLiqBasica = T000S5_A1642DConLiqBasica[0] ;
         n1642DConLiqBasica = T000S5_n1642DConLiqBasica[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1642DConLiqBasica", GXutil.str( A1642DConLiqBasica, 1, 0));
         A1753DConConveCodigo = T000S5_A1753DConConveCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1753DConConveCodigo", A1753DConConveCodigo);
         zm0S26( -3) ;
      }
      pr_default.close(3);
      onLoadActions0S26( ) ;
   }

   public void onLoadActions0S26( )
   {
   }

   public void checkExtendedTable0S26( )
   {
      nIsDirty_26 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T000S4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( GXutil.strcmp(A464DTipoConCod, "REM_ARG") == 0 ) || ( GXutil.strcmp(A464DTipoConCod, "NRE_ARG") == 0 ) || ( GXutil.strcmp(A464DTipoConCod, "DES_ARG") == 0 ) || ( GXutil.strcmp(A464DTipoConCod, "CAL_ARG") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "DTipo Con Cod", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "DTIPOCONCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbDTipoConCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A1067DConPrereq, "APO_SIPA") == 0 ) || ( GXutil.strcmp(A1067DConPrereq, "APO_SIPA_NoSacNiVac") == 0 ) || ( GXutil.strcmp(A1067DConPrereq, "APO_INSSJyP") == 0 ) || ( GXutil.strcmp(A1067DConPrereq, "APO_OS") == 0 ) || ( GXutil.strcmp(A1067DConPrereq, "APO_DIF") == 0 ) || ( GXutil.strcmp(A1067DConPrereq, "APO_ESP") == 0 ) || ( GXutil.strcmp(A1067DConPrereq, "CON_SIPA") == 0 ) || ( GXutil.strcmp(A1067DConPrereq, "CON_OS") == 0 ) || ( GXutil.strcmp(A1067DConPrereq, "CON_FNE") == 0 ) || ( GXutil.strcmp(A1067DConPrereq, "CON_LRT") == 0 ) || ( GXutil.strcmp(A1067DConPrereq, "BRUTA") == 0 ) || ( GXutil.strcmp(A1067DConPrereq, "REM") == 0 ) || ( GXutil.strcmp(A1067DConPrereq, "NRE") == 0 ) || ( GXutil.strcmp(A1067DConPrereq, "REMNOSAC") == 0 ) || ( GXutil.strcmp(A1067DConPrereq, "EXENTOS") == 0 ) || ( GXutil.strcmp(A1067DConPrereq, "LICENCIAS") == 0 ) || ( GXutil.strcmp(A1067DConPrereq, "FIJAS") == 0 ) || (GXutil.strcmp("", A1067DConPrereq)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "DCon Prereq (borrar)", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "DCONPREREQ");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbDConPrereq.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0S26( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_4( int A3CliCod ,
                         short A1EmpCod ,
                         int A31LiqNro ,
                         int A6LegNumero )
   {
      /* Using cursor T000S6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
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

   public void getKey0S26( )
   {
      /* Using cursor T000S7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound26 = (short)(1) ;
      }
      else
      {
         RcdFound26 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000S3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0S26( 3) ;
         RcdFound26 = (short)(1) ;
         A81LiqDSecuencial = T000S3_A81LiqDSecuencial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A81LiqDSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81LiqDSecuencial), 5, 0));
         A394DConCodigo = T000S3_A394DConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A394DConCodigo", A394DConCodigo);
         A393DConDescrip = T000S3_A393DConDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A393DConDescrip", A393DConDescrip);
         A397DLiqPeriodo = T000S3_A397DLiqPeriodo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A397DLiqPeriodo", localUtil.format(A397DLiqPeriodo, "99/99/9999"));
         A400DTLiqCod = T000S3_A400DTLiqCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A400DTLiqCod", A400DTLiqCod);
         A464DTipoConCod = T000S3_A464DTipoConCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A464DTipoConCod", A464DTipoConCod);
         A468DSubTipoConCod1 = T000S3_A468DSubTipoConCod1[0] ;
         n468DSubTipoConCod1 = T000S3_n468DSubTipoConCod1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A468DSubTipoConCod1", A468DSubTipoConCod1);
         A732DSubTipoConCod2 = T000S3_A732DSubTipoConCod2[0] ;
         n732DSubTipoConCod2 = T000S3_n732DSubTipoConCod2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A732DSubTipoConCod2", A732DSubTipoConCod2);
         A2149LiqDClasifAux = T000S3_A2149LiqDClasifAux[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2149LiqDClasifAux", A2149LiqDClasifAux);
         A269LiqDCanti = T000S3_A269LiqDCanti[0] ;
         n269LiqDCanti = T000S3_n269LiqDCanti[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A269LiqDCanti", GXutil.ltrimstr( A269LiqDCanti, 14, 2));
         A277LiqDValUni = T000S3_A277LiqDValUni[0] ;
         n277LiqDValUni = T000S3_n277LiqDValUni[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A277LiqDValUni", GXutil.ltrimstr( A277LiqDValUni, 14, 2));
         A276LiqDImporte = T000S3_A276LiqDImporte[0] ;
         n276LiqDImporte = T000S3_n276LiqDImporte[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A276LiqDImporte", GXutil.ltrimstr( A276LiqDImporte, 14, 2));
         A275LiqDImpCalcu = T000S3_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = T000S3_n275LiqDImpCalcu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A275LiqDImpCalcu", GXutil.ltrimstr( A275LiqDImpCalcu, 14, 2));
         A274LiqDFormula = T000S3_A274LiqDFormula[0] ;
         n274LiqDFormula = T000S3_n274LiqDFormula[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A274LiqDFormula", A274LiqDFormula);
         A270LiqDErrorDesc = T000S3_A270LiqDErrorDesc[0] ;
         n270LiqDErrorDesc = T000S3_n270LiqDErrorDesc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A270LiqDErrorDesc", A270LiqDErrorDesc);
         A466DConVariable = T000S3_A466DConVariable[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A466DConVariable", A466DConVariable);
         A471DConOrden = T000S3_A471DConOrden[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A471DConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A471DConOrden), 8, 0));
         A742DLiqPerAno = T000S3_A742DLiqPerAno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A742DLiqPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(A742DLiqPerAno), 4, 0));
         A1051LiqDSIPAApo = T000S3_A1051LiqDSIPAApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1051LiqDSIPAApo", GXutil.str( A1051LiqDSIPAApo, 1, 0));
         A1052LiqDSIPACont = T000S3_A1052LiqDSIPACont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1052LiqDSIPACont", GXutil.str( A1052LiqDSIPACont, 1, 0));
         A1053LiqDINSSJyPApo = T000S3_A1053LiqDINSSJyPApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1053LiqDINSSJyPApo", GXutil.str( A1053LiqDINSSJyPApo, 1, 0));
         A1054LiqDINSSJyPCont = T000S3_A1054LiqDINSSJyPCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1054LiqDINSSJyPCont", GXutil.str( A1054LiqDINSSJyPCont, 1, 0));
         A1055LiqDObraSocApo = T000S3_A1055LiqDObraSocApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1055LiqDObraSocApo", GXutil.str( A1055LiqDObraSocApo, 1, 0));
         A1056LiqDObraSocCont = T000S3_A1056LiqDObraSocCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1056LiqDObraSocCont", GXutil.str( A1056LiqDObraSocCont, 1, 0));
         A1057LiqDFonSolRedApo = T000S3_A1057LiqDFonSolRedApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1057LiqDFonSolRedApo", GXutil.str( A1057LiqDFonSolRedApo, 1, 0));
         A1058LiqDFonSolRedCont = T000S3_A1058LiqDFonSolRedCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1058LiqDFonSolRedCont", GXutil.str( A1058LiqDFonSolRedCont, 1, 0));
         A1059LiqDRenateaApo = T000S3_A1059LiqDRenateaApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1059LiqDRenateaApo", GXutil.str( A1059LiqDRenateaApo, 1, 0));
         A1060LiqDRenateaCont = T000S3_A1060LiqDRenateaCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1060LiqDRenateaCont", GXutil.str( A1060LiqDRenateaCont, 1, 0));
         A1061LiqDAsigFamCont = T000S3_A1061LiqDAsigFamCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1061LiqDAsigFamCont", GXutil.str( A1061LiqDAsigFamCont, 1, 0));
         A1062LiqDFonNacEmpCont = T000S3_A1062LiqDFonNacEmpCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1062LiqDFonNacEmpCont", GXutil.str( A1062LiqDFonNacEmpCont, 1, 0));
         A1063LiqDLeyRieTrabCont = T000S3_A1063LiqDLeyRieTrabCont[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1063LiqDLeyRieTrabCont", GXutil.str( A1063LiqDLeyRieTrabCont, 1, 0));
         A1064LiqDRegDifApo = T000S3_A1064LiqDRegDifApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1064LiqDRegDifApo", GXutil.str( A1064LiqDRegDifApo, 1, 0));
         A1065LiqDRegEspApo = T000S3_A1065LiqDRegEspApo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1065LiqDRegEspApo", GXutil.str( A1065LiqDRegEspApo, 1, 0));
         A1067DConPrereq = T000S3_A1067DConPrereq[0] ;
         n1067DConPrereq = T000S3_n1067DConPrereq[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1067DConPrereq", A1067DConPrereq);
         A1134LiqDOrdVis = T000S3_A1134LiqDOrdVis[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1134LiqDOrdVis", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1134LiqDOrdVis), 4, 0));
         A1642DConLiqBasica = T000S3_A1642DConLiqBasica[0] ;
         n1642DConLiqBasica = T000S3_n1642DConLiqBasica[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1642DConLiqBasica", GXutil.str( A1642DConLiqBasica, 1, 0));
         A1753DConConveCodigo = T000S3_A1753DConConveCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1753DConConveCodigo", A1753DConConveCodigo);
         A3CliCod = T000S3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T000S3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T000S3_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A31LiqNro = T000S3_A31LiqNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z31LiqNro = A31LiqNro ;
         Z6LegNumero = A6LegNumero ;
         Z81LiqDSecuencial = A81LiqDSecuencial ;
         sMode26 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0S26( ) ;
         if ( AnyError == 1 )
         {
            RcdFound26 = (short)(0) ;
            initializeNonKey0S26( ) ;
         }
         Gx_mode = sMode26 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound26 = (short)(0) ;
         initializeNonKey0S26( ) ;
         sMode26 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode26 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0S26( ) ;
      if ( RcdFound26 == 0 )
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
      RcdFound26 = (short)(0) ;
      /* Using cursor T000S8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A31LiqNro), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Integer.valueOf(A31LiqNro), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A81LiqDSecuencial)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T000S8_A3CliCod[0] < A3CliCod ) || ( T000S8_A3CliCod[0] == A3CliCod ) && ( T000S8_A1EmpCod[0] < A1EmpCod ) || ( T000S8_A1EmpCod[0] == A1EmpCod ) && ( T000S8_A3CliCod[0] == A3CliCod ) && ( T000S8_A31LiqNro[0] < A31LiqNro ) || ( T000S8_A31LiqNro[0] == A31LiqNro ) && ( T000S8_A1EmpCod[0] == A1EmpCod ) && ( T000S8_A3CliCod[0] == A3CliCod ) && ( T000S8_A6LegNumero[0] < A6LegNumero ) || ( T000S8_A6LegNumero[0] == A6LegNumero ) && ( T000S8_A31LiqNro[0] == A31LiqNro ) && ( T000S8_A1EmpCod[0] == A1EmpCod ) && ( T000S8_A3CliCod[0] == A3CliCod ) && ( T000S8_A81LiqDSecuencial[0] < A81LiqDSecuencial ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T000S8_A3CliCod[0] > A3CliCod ) || ( T000S8_A3CliCod[0] == A3CliCod ) && ( T000S8_A1EmpCod[0] > A1EmpCod ) || ( T000S8_A1EmpCod[0] == A1EmpCod ) && ( T000S8_A3CliCod[0] == A3CliCod ) && ( T000S8_A31LiqNro[0] > A31LiqNro ) || ( T000S8_A31LiqNro[0] == A31LiqNro ) && ( T000S8_A1EmpCod[0] == A1EmpCod ) && ( T000S8_A3CliCod[0] == A3CliCod ) && ( T000S8_A6LegNumero[0] > A6LegNumero ) || ( T000S8_A6LegNumero[0] == A6LegNumero ) && ( T000S8_A31LiqNro[0] == A31LiqNro ) && ( T000S8_A1EmpCod[0] == A1EmpCod ) && ( T000S8_A3CliCod[0] == A3CliCod ) && ( T000S8_A81LiqDSecuencial[0] > A81LiqDSecuencial ) ) )
         {
            A3CliCod = T000S8_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T000S8_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A31LiqNro = T000S8_A31LiqNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
            A6LegNumero = T000S8_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A81LiqDSecuencial = T000S8_A81LiqDSecuencial[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A81LiqDSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81LiqDSecuencial), 5, 0));
            RcdFound26 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound26 = (short)(0) ;
      /* Using cursor T000S9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A31LiqNro), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Integer.valueOf(A31LiqNro), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A81LiqDSecuencial)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T000S9_A3CliCod[0] > A3CliCod ) || ( T000S9_A3CliCod[0] == A3CliCod ) && ( T000S9_A1EmpCod[0] > A1EmpCod ) || ( T000S9_A1EmpCod[0] == A1EmpCod ) && ( T000S9_A3CliCod[0] == A3CliCod ) && ( T000S9_A31LiqNro[0] > A31LiqNro ) || ( T000S9_A31LiqNro[0] == A31LiqNro ) && ( T000S9_A1EmpCod[0] == A1EmpCod ) && ( T000S9_A3CliCod[0] == A3CliCod ) && ( T000S9_A6LegNumero[0] > A6LegNumero ) || ( T000S9_A6LegNumero[0] == A6LegNumero ) && ( T000S9_A31LiqNro[0] == A31LiqNro ) && ( T000S9_A1EmpCod[0] == A1EmpCod ) && ( T000S9_A3CliCod[0] == A3CliCod ) && ( T000S9_A81LiqDSecuencial[0] > A81LiqDSecuencial ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T000S9_A3CliCod[0] < A3CliCod ) || ( T000S9_A3CliCod[0] == A3CliCod ) && ( T000S9_A1EmpCod[0] < A1EmpCod ) || ( T000S9_A1EmpCod[0] == A1EmpCod ) && ( T000S9_A3CliCod[0] == A3CliCod ) && ( T000S9_A31LiqNro[0] < A31LiqNro ) || ( T000S9_A31LiqNro[0] == A31LiqNro ) && ( T000S9_A1EmpCod[0] == A1EmpCod ) && ( T000S9_A3CliCod[0] == A3CliCod ) && ( T000S9_A6LegNumero[0] < A6LegNumero ) || ( T000S9_A6LegNumero[0] == A6LegNumero ) && ( T000S9_A31LiqNro[0] == A31LiqNro ) && ( T000S9_A1EmpCod[0] == A1EmpCod ) && ( T000S9_A3CliCod[0] == A3CliCod ) && ( T000S9_A81LiqDSecuencial[0] < A81LiqDSecuencial ) ) )
         {
            A3CliCod = T000S9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T000S9_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A31LiqNro = T000S9_A31LiqNro[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
            A6LegNumero = T000S9_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A81LiqDSecuencial = T000S9_A81LiqDSecuencial[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A81LiqDSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81LiqDSecuencial), 5, 0));
            RcdFound26 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0S26( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0S26( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound26 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) || ( A6LegNumero != Z6LegNumero ) || ( A81LiqDSecuencial != Z81LiqDSecuencial ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A31LiqNro = Z31LiqNro ;
               httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
               A6LegNumero = Z6LegNumero ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A81LiqDSecuencial = Z81LiqDSecuencial ;
               httpContext.ajax_rsp_assign_attri("", false, "A81LiqDSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81LiqDSecuencial), 5, 0));
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
               update0S26( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) || ( A6LegNumero != Z6LegNumero ) || ( A81LiqDSecuencial != Z81LiqDSecuencial ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0S26( ) ;
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
                  insert0S26( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) || ( A6LegNumero != Z6LegNumero ) || ( A81LiqDSecuencial != Z81LiqDSecuencial ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A31LiqNro = Z31LiqNro ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         A6LegNumero = Z6LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A81LiqDSecuencial = Z81LiqDSecuencial ;
         httpContext.ajax_rsp_assign_attri("", false, "A81LiqDSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81LiqDSecuencial), 5, 0));
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
      if ( RcdFound26 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtDConCodigo_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0S26( ) ;
      if ( RcdFound26 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtDConCodigo_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0S26( ) ;
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
      if ( RcdFound26 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtDConCodigo_Internalname ;
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
      if ( RcdFound26 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtDConCodigo_Internalname ;
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
      scanStart0S26( ) ;
      if ( RcdFound26 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound26 != 0 )
         {
            scanNext0S26( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtDConCodigo_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0S26( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0S26( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000S2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LiquidacionDetalle"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z394DConCodigo, T000S2_A394DConCodigo[0]) != 0 ) || ( GXutil.strcmp(Z393DConDescrip, T000S2_A393DConDescrip[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z397DLiqPeriodo), GXutil.resetTime(T000S2_A397DLiqPeriodo[0])) ) || ( GXutil.strcmp(Z400DTLiqCod, T000S2_A400DTLiqCod[0]) != 0 ) || ( GXutil.strcmp(Z464DTipoConCod, T000S2_A464DTipoConCod[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z468DSubTipoConCod1, T000S2_A468DSubTipoConCod1[0]) != 0 ) || ( GXutil.strcmp(Z732DSubTipoConCod2, T000S2_A732DSubTipoConCod2[0]) != 0 ) || ( GXutil.strcmp(Z2149LiqDClasifAux, T000S2_A2149LiqDClasifAux[0]) != 0 ) || ( DecimalUtil.compareTo(Z269LiqDCanti, T000S2_A269LiqDCanti[0]) != 0 ) || ( DecimalUtil.compareTo(Z277LiqDValUni, T000S2_A277LiqDValUni[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z276LiqDImporte, T000S2_A276LiqDImporte[0]) != 0 ) || ( DecimalUtil.compareTo(Z275LiqDImpCalcu, T000S2_A275LiqDImpCalcu[0]) != 0 ) || ( GXutil.strcmp(Z270LiqDErrorDesc, T000S2_A270LiqDErrorDesc[0]) != 0 ) || ( Z466DConVariable != T000S2_A466DConVariable[0] ) || ( Z471DConOrden != T000S2_A471DConOrden[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z742DLiqPerAno != T000S2_A742DLiqPerAno[0] ) || ( Z1051LiqDSIPAApo != T000S2_A1051LiqDSIPAApo[0] ) || ( Z1052LiqDSIPACont != T000S2_A1052LiqDSIPACont[0] ) || ( Z1053LiqDINSSJyPApo != T000S2_A1053LiqDINSSJyPApo[0] ) || ( Z1054LiqDINSSJyPCont != T000S2_A1054LiqDINSSJyPCont[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1055LiqDObraSocApo != T000S2_A1055LiqDObraSocApo[0] ) || ( Z1056LiqDObraSocCont != T000S2_A1056LiqDObraSocCont[0] ) || ( Z1057LiqDFonSolRedApo != T000S2_A1057LiqDFonSolRedApo[0] ) || ( Z1058LiqDFonSolRedCont != T000S2_A1058LiqDFonSolRedCont[0] ) || ( Z1059LiqDRenateaApo != T000S2_A1059LiqDRenateaApo[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1060LiqDRenateaCont != T000S2_A1060LiqDRenateaCont[0] ) || ( Z1061LiqDAsigFamCont != T000S2_A1061LiqDAsigFamCont[0] ) || ( Z1062LiqDFonNacEmpCont != T000S2_A1062LiqDFonNacEmpCont[0] ) || ( Z1063LiqDLeyRieTrabCont != T000S2_A1063LiqDLeyRieTrabCont[0] ) || ( Z1064LiqDRegDifApo != T000S2_A1064LiqDRegDifApo[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1065LiqDRegEspApo != T000S2_A1065LiqDRegEspApo[0] ) || ( GXutil.strcmp(Z1067DConPrereq, T000S2_A1067DConPrereq[0]) != 0 ) || ( Z1134LiqDOrdVis != T000S2_A1134LiqDOrdVis[0] ) || ( Z1642DConLiqBasica != T000S2_A1642DConLiqBasica[0] ) || ( GXutil.strcmp(Z1753DConConveCodigo, T000S2_A1753DConConveCodigo[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z394DConCodigo, T000S2_A394DConCodigo[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"DConCodigo");
               GXutil.writeLogRaw("Old: ",Z394DConCodigo);
               GXutil.writeLogRaw("Current: ",T000S2_A394DConCodigo[0]);
            }
            if ( GXutil.strcmp(Z393DConDescrip, T000S2_A393DConDescrip[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"DConDescrip");
               GXutil.writeLogRaw("Old: ",Z393DConDescrip);
               GXutil.writeLogRaw("Current: ",T000S2_A393DConDescrip[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z397DLiqPeriodo), GXutil.resetTime(T000S2_A397DLiqPeriodo[0])) ) )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"DLiqPeriodo");
               GXutil.writeLogRaw("Old: ",Z397DLiqPeriodo);
               GXutil.writeLogRaw("Current: ",T000S2_A397DLiqPeriodo[0]);
            }
            if ( GXutil.strcmp(Z400DTLiqCod, T000S2_A400DTLiqCod[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"DTLiqCod");
               GXutil.writeLogRaw("Old: ",Z400DTLiqCod);
               GXutil.writeLogRaw("Current: ",T000S2_A400DTLiqCod[0]);
            }
            if ( GXutil.strcmp(Z464DTipoConCod, T000S2_A464DTipoConCod[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"DTipoConCod");
               GXutil.writeLogRaw("Old: ",Z464DTipoConCod);
               GXutil.writeLogRaw("Current: ",T000S2_A464DTipoConCod[0]);
            }
            if ( GXutil.strcmp(Z468DSubTipoConCod1, T000S2_A468DSubTipoConCod1[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"DSubTipoConCod1");
               GXutil.writeLogRaw("Old: ",Z468DSubTipoConCod1);
               GXutil.writeLogRaw("Current: ",T000S2_A468DSubTipoConCod1[0]);
            }
            if ( GXutil.strcmp(Z732DSubTipoConCod2, T000S2_A732DSubTipoConCod2[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"DSubTipoConCod2");
               GXutil.writeLogRaw("Old: ",Z732DSubTipoConCod2);
               GXutil.writeLogRaw("Current: ",T000S2_A732DSubTipoConCod2[0]);
            }
            if ( GXutil.strcmp(Z2149LiqDClasifAux, T000S2_A2149LiqDClasifAux[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDClasifAux");
               GXutil.writeLogRaw("Old: ",Z2149LiqDClasifAux);
               GXutil.writeLogRaw("Current: ",T000S2_A2149LiqDClasifAux[0]);
            }
            if ( DecimalUtil.compareTo(Z269LiqDCanti, T000S2_A269LiqDCanti[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDCanti");
               GXutil.writeLogRaw("Old: ",Z269LiqDCanti);
               GXutil.writeLogRaw("Current: ",T000S2_A269LiqDCanti[0]);
            }
            if ( DecimalUtil.compareTo(Z277LiqDValUni, T000S2_A277LiqDValUni[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDValUni");
               GXutil.writeLogRaw("Old: ",Z277LiqDValUni);
               GXutil.writeLogRaw("Current: ",T000S2_A277LiqDValUni[0]);
            }
            if ( DecimalUtil.compareTo(Z276LiqDImporte, T000S2_A276LiqDImporte[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDImporte");
               GXutil.writeLogRaw("Old: ",Z276LiqDImporte);
               GXutil.writeLogRaw("Current: ",T000S2_A276LiqDImporte[0]);
            }
            if ( DecimalUtil.compareTo(Z275LiqDImpCalcu, T000S2_A275LiqDImpCalcu[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDImpCalcu");
               GXutil.writeLogRaw("Old: ",Z275LiqDImpCalcu);
               GXutil.writeLogRaw("Current: ",T000S2_A275LiqDImpCalcu[0]);
            }
            if ( GXutil.strcmp(Z270LiqDErrorDesc, T000S2_A270LiqDErrorDesc[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDErrorDesc");
               GXutil.writeLogRaw("Old: ",Z270LiqDErrorDesc);
               GXutil.writeLogRaw("Current: ",T000S2_A270LiqDErrorDesc[0]);
            }
            if ( Z466DConVariable != T000S2_A466DConVariable[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"DConVariable");
               GXutil.writeLogRaw("Old: ",Z466DConVariable);
               GXutil.writeLogRaw("Current: ",T000S2_A466DConVariable[0]);
            }
            if ( Z471DConOrden != T000S2_A471DConOrden[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"DConOrden");
               GXutil.writeLogRaw("Old: ",Z471DConOrden);
               GXutil.writeLogRaw("Current: ",T000S2_A471DConOrden[0]);
            }
            if ( Z742DLiqPerAno != T000S2_A742DLiqPerAno[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"DLiqPerAno");
               GXutil.writeLogRaw("Old: ",Z742DLiqPerAno);
               GXutil.writeLogRaw("Current: ",T000S2_A742DLiqPerAno[0]);
            }
            if ( Z1051LiqDSIPAApo != T000S2_A1051LiqDSIPAApo[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDSIPAApo");
               GXutil.writeLogRaw("Old: ",Z1051LiqDSIPAApo);
               GXutil.writeLogRaw("Current: ",T000S2_A1051LiqDSIPAApo[0]);
            }
            if ( Z1052LiqDSIPACont != T000S2_A1052LiqDSIPACont[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDSIPACont");
               GXutil.writeLogRaw("Old: ",Z1052LiqDSIPACont);
               GXutil.writeLogRaw("Current: ",T000S2_A1052LiqDSIPACont[0]);
            }
            if ( Z1053LiqDINSSJyPApo != T000S2_A1053LiqDINSSJyPApo[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDINSSJyPApo");
               GXutil.writeLogRaw("Old: ",Z1053LiqDINSSJyPApo);
               GXutil.writeLogRaw("Current: ",T000S2_A1053LiqDINSSJyPApo[0]);
            }
            if ( Z1054LiqDINSSJyPCont != T000S2_A1054LiqDINSSJyPCont[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDINSSJyPCont");
               GXutil.writeLogRaw("Old: ",Z1054LiqDINSSJyPCont);
               GXutil.writeLogRaw("Current: ",T000S2_A1054LiqDINSSJyPCont[0]);
            }
            if ( Z1055LiqDObraSocApo != T000S2_A1055LiqDObraSocApo[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDObraSocApo");
               GXutil.writeLogRaw("Old: ",Z1055LiqDObraSocApo);
               GXutil.writeLogRaw("Current: ",T000S2_A1055LiqDObraSocApo[0]);
            }
            if ( Z1056LiqDObraSocCont != T000S2_A1056LiqDObraSocCont[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDObraSocCont");
               GXutil.writeLogRaw("Old: ",Z1056LiqDObraSocCont);
               GXutil.writeLogRaw("Current: ",T000S2_A1056LiqDObraSocCont[0]);
            }
            if ( Z1057LiqDFonSolRedApo != T000S2_A1057LiqDFonSolRedApo[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDFonSolRedApo");
               GXutil.writeLogRaw("Old: ",Z1057LiqDFonSolRedApo);
               GXutil.writeLogRaw("Current: ",T000S2_A1057LiqDFonSolRedApo[0]);
            }
            if ( Z1058LiqDFonSolRedCont != T000S2_A1058LiqDFonSolRedCont[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDFonSolRedCont");
               GXutil.writeLogRaw("Old: ",Z1058LiqDFonSolRedCont);
               GXutil.writeLogRaw("Current: ",T000S2_A1058LiqDFonSolRedCont[0]);
            }
            if ( Z1059LiqDRenateaApo != T000S2_A1059LiqDRenateaApo[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDRenateaApo");
               GXutil.writeLogRaw("Old: ",Z1059LiqDRenateaApo);
               GXutil.writeLogRaw("Current: ",T000S2_A1059LiqDRenateaApo[0]);
            }
            if ( Z1060LiqDRenateaCont != T000S2_A1060LiqDRenateaCont[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDRenateaCont");
               GXutil.writeLogRaw("Old: ",Z1060LiqDRenateaCont);
               GXutil.writeLogRaw("Current: ",T000S2_A1060LiqDRenateaCont[0]);
            }
            if ( Z1061LiqDAsigFamCont != T000S2_A1061LiqDAsigFamCont[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDAsigFamCont");
               GXutil.writeLogRaw("Old: ",Z1061LiqDAsigFamCont);
               GXutil.writeLogRaw("Current: ",T000S2_A1061LiqDAsigFamCont[0]);
            }
            if ( Z1062LiqDFonNacEmpCont != T000S2_A1062LiqDFonNacEmpCont[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDFonNacEmpCont");
               GXutil.writeLogRaw("Old: ",Z1062LiqDFonNacEmpCont);
               GXutil.writeLogRaw("Current: ",T000S2_A1062LiqDFonNacEmpCont[0]);
            }
            if ( Z1063LiqDLeyRieTrabCont != T000S2_A1063LiqDLeyRieTrabCont[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDLeyRieTrabCont");
               GXutil.writeLogRaw("Old: ",Z1063LiqDLeyRieTrabCont);
               GXutil.writeLogRaw("Current: ",T000S2_A1063LiqDLeyRieTrabCont[0]);
            }
            if ( Z1064LiqDRegDifApo != T000S2_A1064LiqDRegDifApo[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDRegDifApo");
               GXutil.writeLogRaw("Old: ",Z1064LiqDRegDifApo);
               GXutil.writeLogRaw("Current: ",T000S2_A1064LiqDRegDifApo[0]);
            }
            if ( Z1065LiqDRegEspApo != T000S2_A1065LiqDRegEspApo[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDRegEspApo");
               GXutil.writeLogRaw("Old: ",Z1065LiqDRegEspApo);
               GXutil.writeLogRaw("Current: ",T000S2_A1065LiqDRegEspApo[0]);
            }
            if ( GXutil.strcmp(Z1067DConPrereq, T000S2_A1067DConPrereq[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"DConPrereq");
               GXutil.writeLogRaw("Old: ",Z1067DConPrereq);
               GXutil.writeLogRaw("Current: ",T000S2_A1067DConPrereq[0]);
            }
            if ( Z1134LiqDOrdVis != T000S2_A1134LiqDOrdVis[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"LiqDOrdVis");
               GXutil.writeLogRaw("Old: ",Z1134LiqDOrdVis);
               GXutil.writeLogRaw("Current: ",T000S2_A1134LiqDOrdVis[0]);
            }
            if ( Z1642DConLiqBasica != T000S2_A1642DConLiqBasica[0] )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"DConLiqBasica");
               GXutil.writeLogRaw("Old: ",Z1642DConLiqBasica);
               GXutil.writeLogRaw("Current: ",T000S2_A1642DConLiqBasica[0]);
            }
            if ( GXutil.strcmp(Z1753DConConveCodigo, T000S2_A1753DConConveCodigo[0]) != 0 )
            {
               GXutil.writeLogln("liquidacion_excel_1:[seudo value changed for attri]"+"DConConveCodigo");
               GXutil.writeLogRaw("Old: ",Z1753DConConveCodigo);
               GXutil.writeLogRaw("Current: ",T000S2_A1753DConConveCodigo[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LiquidacionDetalle"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0S26( )
   {
      beforeValidate0S26( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0S26( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0S26( 0) ;
         checkOptimisticConcurrency0S26( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0S26( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0S26( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000S10 */
                  pr_default.execute(8, new Object[] {Integer.valueOf(A81LiqDSecuencial), A394DConCodigo, A393DConDescrip, A397DLiqPeriodo, A400DTLiqCod, A464DTipoConCod, Boolean.valueOf(n468DSubTipoConCod1), A468DSubTipoConCod1, Boolean.valueOf(n732DSubTipoConCod2), A732DSubTipoConCod2, A2149LiqDClasifAux, Boolean.valueOf(n269LiqDCanti), A269LiqDCanti, Boolean.valueOf(n277LiqDValUni), A277LiqDValUni, Boolean.valueOf(n276LiqDImporte), A276LiqDImporte, Boolean.valueOf(n275LiqDImpCalcu), A275LiqDImpCalcu, Boolean.valueOf(n274LiqDFormula), A274LiqDFormula, Boolean.valueOf(n270LiqDErrorDesc), A270LiqDErrorDesc, Boolean.valueOf(A466DConVariable), Integer.valueOf(A471DConOrden), Short.valueOf(A742DLiqPerAno), Byte.valueOf(A1051LiqDSIPAApo), Byte.valueOf(A1052LiqDSIPACont), Byte.valueOf(A1053LiqDINSSJyPApo), Byte.valueOf(A1054LiqDINSSJyPCont), Byte.valueOf(A1055LiqDObraSocApo), Byte.valueOf(A1056LiqDObraSocCont), Byte.valueOf(A1057LiqDFonSolRedApo), Byte.valueOf(A1058LiqDFonSolRedCont), Byte.valueOf(A1059LiqDRenateaApo), Byte.valueOf(A1060LiqDRenateaCont), Byte.valueOf(A1061LiqDAsigFamCont), Byte.valueOf(A1062LiqDFonNacEmpCont), Byte.valueOf(A1063LiqDLeyRieTrabCont), Byte.valueOf(A1064LiqDRegDifApo), Byte.valueOf(A1065LiqDRegEspApo), Boolean.valueOf(n1067DConPrereq), A1067DConPrereq, Short.valueOf(A1134LiqDOrdVis), Boolean.valueOf(n1642DConLiqBasica), Byte.valueOf(A1642DConLiqBasica), A1753DConConveCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A31LiqNro)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
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
                        resetCaption0S0( ) ;
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
            load0S26( ) ;
         }
         endLevel0S26( ) ;
      }
      closeExtendedTableCursors0S26( ) ;
   }

   public void update0S26( )
   {
      beforeValidate0S26( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0S26( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0S26( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0S26( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0S26( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000S11 */
                  pr_default.execute(9, new Object[] {A394DConCodigo, A393DConDescrip, A397DLiqPeriodo, A400DTLiqCod, A464DTipoConCod, Boolean.valueOf(n468DSubTipoConCod1), A468DSubTipoConCod1, Boolean.valueOf(n732DSubTipoConCod2), A732DSubTipoConCod2, A2149LiqDClasifAux, Boolean.valueOf(n269LiqDCanti), A269LiqDCanti, Boolean.valueOf(n277LiqDValUni), A277LiqDValUni, Boolean.valueOf(n276LiqDImporte), A276LiqDImporte, Boolean.valueOf(n275LiqDImpCalcu), A275LiqDImpCalcu, Boolean.valueOf(n274LiqDFormula), A274LiqDFormula, Boolean.valueOf(n270LiqDErrorDesc), A270LiqDErrorDesc, Boolean.valueOf(A466DConVariable), Integer.valueOf(A471DConOrden), Short.valueOf(A742DLiqPerAno), Byte.valueOf(A1051LiqDSIPAApo), Byte.valueOf(A1052LiqDSIPACont), Byte.valueOf(A1053LiqDINSSJyPApo), Byte.valueOf(A1054LiqDINSSJyPCont), Byte.valueOf(A1055LiqDObraSocApo), Byte.valueOf(A1056LiqDObraSocCont), Byte.valueOf(A1057LiqDFonSolRedApo), Byte.valueOf(A1058LiqDFonSolRedCont), Byte.valueOf(A1059LiqDRenateaApo), Byte.valueOf(A1060LiqDRenateaCont), Byte.valueOf(A1061LiqDAsigFamCont), Byte.valueOf(A1062LiqDFonNacEmpCont), Byte.valueOf(A1063LiqDLeyRieTrabCont), Byte.valueOf(A1064LiqDRegDifApo), Byte.valueOf(A1065LiqDRegEspApo), Boolean.valueOf(n1067DConPrereq), A1067DConPrereq, Short.valueOf(A1134LiqDOrdVis), Boolean.valueOf(n1642DConLiqBasica), Byte.valueOf(A1642DConLiqBasica), A1753DConConveCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LiquidacionDetalle"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0S26( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption0S0( ) ;
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
         endLevel0S26( ) ;
      }
      closeExtendedTableCursors0S26( ) ;
   }

   public void deferredUpdate0S26( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0S26( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0S26( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0S26( ) ;
         afterConfirm0S26( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0S26( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000S12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound26 == 0 )
                     {
                        initAll0S26( ) ;
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
                     resetCaption0S0( ) ;
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
      sMode26 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0S26( ) ;
      Gx_mode = sMode26 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0S26( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0S26( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0S26( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "liquidacion_excel_1");
         if ( AnyError == 0 )
         {
            confirmValues0S0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "liquidacion_excel_1");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0S26( )
   {
      /* Using cursor T000S13 */
      pr_default.execute(11);
      RcdFound26 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound26 = (short)(1) ;
         A3CliCod = T000S13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T000S13_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A31LiqNro = T000S13_A31LiqNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         A6LegNumero = T000S13_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A81LiqDSecuencial = T000S13_A81LiqDSecuencial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A81LiqDSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81LiqDSecuencial), 5, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0S26( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound26 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound26 = (short)(1) ;
         A3CliCod = T000S13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T000S13_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A31LiqNro = T000S13_A31LiqNro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
         A6LegNumero = T000S13_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A81LiqDSecuencial = T000S13_A81LiqDSecuencial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A81LiqDSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81LiqDSecuencial), 5, 0));
      }
   }

   public void scanEnd0S26( )
   {
      pr_default.close(11);
   }

   public void afterConfirm0S26( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0S26( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0S26( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0S26( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0S26( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0S26( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0S26( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtLiqNro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqNro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqNro_Enabled), 5, 0), true);
      edtLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      edtLiqDSecuencial_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDSecuencial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDSecuencial_Enabled), 5, 0), true);
      edtDConCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDConCodigo_Enabled), 5, 0), true);
      edtDConDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDConDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDConDescrip_Enabled), 5, 0), true);
      edtDLiqPeriodo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDLiqPeriodo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDLiqPeriodo_Enabled), 5, 0), true);
      edtDTLiqCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDTLiqCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDTLiqCod_Enabled), 5, 0), true);
      cmbDTipoConCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbDTipoConCod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbDTipoConCod.getEnabled(), 5, 0), true);
      edtDSubTipoConCod1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDSubTipoConCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDSubTipoConCod1_Enabled), 5, 0), true);
      edtDSubTipoConCod2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDSubTipoConCod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDSubTipoConCod2_Enabled), 5, 0), true);
      edtLiqDClasifAux_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDClasifAux_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDClasifAux_Enabled), 5, 0), true);
      edtLiqDCanti_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDCanti_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDCanti_Enabled), 5, 0), true);
      edtLiqDValUni_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDValUni_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDValUni_Enabled), 5, 0), true);
      edtLiqDImporte_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDImporte_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDImporte_Enabled), 5, 0), true);
      edtLiqDImpCalcu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDImpCalcu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDImpCalcu_Enabled), 5, 0), true);
      edtLiqDFormula_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDFormula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDFormula_Enabled), 5, 0), true);
      edtLiqDErrorDesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDErrorDesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDErrorDesc_Enabled), 5, 0), true);
      chkDConVariable.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkDConVariable.getInternalname(), "Enabled", GXutil.ltrimstr( chkDConVariable.getEnabled(), 5, 0), true);
      edtDConOrden_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDConOrden_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDConOrden_Enabled), 5, 0), true);
      edtDLiqPerAno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDLiqPerAno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDLiqPerAno_Enabled), 5, 0), true);
      edtLiqDSIPAApo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDSIPAApo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDSIPAApo_Enabled), 5, 0), true);
      edtLiqDSIPACont_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDSIPACont_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDSIPACont_Enabled), 5, 0), true);
      edtLiqDINSSJyPApo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDINSSJyPApo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDINSSJyPApo_Enabled), 5, 0), true);
      edtLiqDINSSJyPCont_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDINSSJyPCont_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDINSSJyPCont_Enabled), 5, 0), true);
      edtLiqDObraSocApo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDObraSocApo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDObraSocApo_Enabled), 5, 0), true);
      edtLiqDObraSocCont_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDObraSocCont_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDObraSocCont_Enabled), 5, 0), true);
      edtLiqDFonSolRedApo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDFonSolRedApo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDFonSolRedApo_Enabled), 5, 0), true);
      edtLiqDFonSolRedCont_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDFonSolRedCont_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDFonSolRedCont_Enabled), 5, 0), true);
      edtLiqDRenateaApo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDRenateaApo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDRenateaApo_Enabled), 5, 0), true);
      edtLiqDRenateaCont_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDRenateaCont_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDRenateaCont_Enabled), 5, 0), true);
      edtLiqDAsigFamCont_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDAsigFamCont_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDAsigFamCont_Enabled), 5, 0), true);
      edtLiqDFonNacEmpCont_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDFonNacEmpCont_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDFonNacEmpCont_Enabled), 5, 0), true);
      edtLiqDLeyRieTrabCont_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDLeyRieTrabCont_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDLeyRieTrabCont_Enabled), 5, 0), true);
      edtLiqDRegDifApo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDRegDifApo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDRegDifApo_Enabled), 5, 0), true);
      edtLiqDRegEspApo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDRegEspApo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDRegEspApo_Enabled), 5, 0), true);
      cmbDConPrereq.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbDConPrereq.getInternalname(), "Enabled", GXutil.ltrimstr( cmbDConPrereq.getEnabled(), 5, 0), true);
      edtLiqDOrdVis_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDOrdVis_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDOrdVis_Enabled), 5, 0), true);
      edtDConLiqBasica_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDConLiqBasica_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDConLiqBasica_Enabled), 5, 0), true);
      edtDConConveCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDConConveCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDConConveCodigo_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0S26( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0S0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.liquidacion_excel_1", new String[] {}, new String[] {}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "Z31LiqNro", GXutil.ltrim( localUtil.ntoc( Z31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z81LiqDSecuencial", GXutil.ltrim( localUtil.ntoc( Z81LiqDSecuencial, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z394DConCodigo", GXutil.rtrim( Z394DConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z393DConDescrip", Z393DConDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z397DLiqPeriodo", localUtil.dtoc( Z397DLiqPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z400DTLiqCod", GXutil.rtrim( Z400DTLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z464DTipoConCod", GXutil.rtrim( Z464DTipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z468DSubTipoConCod1", GXutil.rtrim( Z468DSubTipoConCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "Z732DSubTipoConCod2", GXutil.rtrim( Z732DSubTipoConCod2));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2149LiqDClasifAux", Z2149LiqDClasifAux);
      web.GxWebStd.gx_hidden_field( httpContext, "Z269LiqDCanti", GXutil.ltrim( localUtil.ntoc( Z269LiqDCanti, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z277LiqDValUni", GXutil.ltrim( localUtil.ntoc( Z277LiqDValUni, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z276LiqDImporte", GXutil.ltrim( localUtil.ntoc( Z276LiqDImporte, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z275LiqDImpCalcu", GXutil.ltrim( localUtil.ntoc( Z275LiqDImpCalcu, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z270LiqDErrorDesc", Z270LiqDErrorDesc);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z466DConVariable", Z466DConVariable);
      web.GxWebStd.gx_hidden_field( httpContext, "Z471DConOrden", GXutil.ltrim( localUtil.ntoc( Z471DConOrden, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z742DLiqPerAno", GXutil.ltrim( localUtil.ntoc( Z742DLiqPerAno, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1051LiqDSIPAApo", GXutil.ltrim( localUtil.ntoc( Z1051LiqDSIPAApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1052LiqDSIPACont", GXutil.ltrim( localUtil.ntoc( Z1052LiqDSIPACont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1053LiqDINSSJyPApo", GXutil.ltrim( localUtil.ntoc( Z1053LiqDINSSJyPApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1054LiqDINSSJyPCont", GXutil.ltrim( localUtil.ntoc( Z1054LiqDINSSJyPCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1055LiqDObraSocApo", GXutil.ltrim( localUtil.ntoc( Z1055LiqDObraSocApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1056LiqDObraSocCont", GXutil.ltrim( localUtil.ntoc( Z1056LiqDObraSocCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1057LiqDFonSolRedApo", GXutil.ltrim( localUtil.ntoc( Z1057LiqDFonSolRedApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1058LiqDFonSolRedCont", GXutil.ltrim( localUtil.ntoc( Z1058LiqDFonSolRedCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1059LiqDRenateaApo", GXutil.ltrim( localUtil.ntoc( Z1059LiqDRenateaApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1060LiqDRenateaCont", GXutil.ltrim( localUtil.ntoc( Z1060LiqDRenateaCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1061LiqDAsigFamCont", GXutil.ltrim( localUtil.ntoc( Z1061LiqDAsigFamCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1062LiqDFonNacEmpCont", GXutil.ltrim( localUtil.ntoc( Z1062LiqDFonNacEmpCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1063LiqDLeyRieTrabCont", GXutil.ltrim( localUtil.ntoc( Z1063LiqDLeyRieTrabCont, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1064LiqDRegDifApo", GXutil.ltrim( localUtil.ntoc( Z1064LiqDRegDifApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1065LiqDRegEspApo", GXutil.ltrim( localUtil.ntoc( Z1065LiqDRegEspApo, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1067DConPrereq", GXutil.rtrim( Z1067DConPrereq));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1134LiqDOrdVis", GXutil.ltrim( localUtil.ntoc( Z1134LiqDOrdVis, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1642DConLiqBasica", GXutil.ltrim( localUtil.ntoc( Z1642DConLiqBasica, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1753DConConveCodigo", GXutil.rtrim( Z1753DConConveCodigo));
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
      return formatLink("web.liquidacion_excel_1", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "Liquidacion_Excel_1" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Liquidacion_Excel_1", "") ;
   }

   public void initializeNonKey0S26( )
   {
      A394DConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A394DConCodigo", A394DConCodigo);
      A393DConDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A393DConDescrip", A393DConDescrip);
      A397DLiqPeriodo = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A397DLiqPeriodo", localUtil.format(A397DLiqPeriodo, "99/99/9999"));
      A400DTLiqCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A400DTLiqCod", A400DTLiqCod);
      A464DTipoConCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A464DTipoConCod", A464DTipoConCod);
      A468DSubTipoConCod1 = "" ;
      n468DSubTipoConCod1 = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A468DSubTipoConCod1", A468DSubTipoConCod1);
      n468DSubTipoConCod1 = ((GXutil.strcmp("", A468DSubTipoConCod1)==0) ? true : false) ;
      A732DSubTipoConCod2 = "" ;
      n732DSubTipoConCod2 = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A732DSubTipoConCod2", A732DSubTipoConCod2);
      n732DSubTipoConCod2 = ((GXutil.strcmp("", A732DSubTipoConCod2)==0) ? true : false) ;
      A2149LiqDClasifAux = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2149LiqDClasifAux", A2149LiqDClasifAux);
      A269LiqDCanti = DecimalUtil.ZERO ;
      n269LiqDCanti = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A269LiqDCanti", GXutil.ltrimstr( A269LiqDCanti, 14, 2));
      n269LiqDCanti = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A269LiqDCanti)==0) ? true : false) ;
      A277LiqDValUni = DecimalUtil.ZERO ;
      n277LiqDValUni = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A277LiqDValUni", GXutil.ltrimstr( A277LiqDValUni, 14, 2));
      n277LiqDValUni = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A277LiqDValUni)==0) ? true : false) ;
      A276LiqDImporte = DecimalUtil.ZERO ;
      n276LiqDImporte = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A276LiqDImporte", GXutil.ltrimstr( A276LiqDImporte, 14, 2));
      n276LiqDImporte = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A276LiqDImporte)==0) ? true : false) ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      n275LiqDImpCalcu = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A275LiqDImpCalcu", GXutil.ltrimstr( A275LiqDImpCalcu, 14, 2));
      n275LiqDImpCalcu = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A275LiqDImpCalcu)==0) ? true : false) ;
      A274LiqDFormula = "" ;
      n274LiqDFormula = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A274LiqDFormula", A274LiqDFormula);
      n274LiqDFormula = ((GXutil.strcmp("", A274LiqDFormula)==0) ? true : false) ;
      A270LiqDErrorDesc = "" ;
      n270LiqDErrorDesc = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A270LiqDErrorDesc", A270LiqDErrorDesc);
      n270LiqDErrorDesc = ((GXutil.strcmp("", A270LiqDErrorDesc)==0) ? true : false) ;
      A466DConVariable = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A466DConVariable", A466DConVariable);
      A471DConOrden = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A471DConOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A471DConOrden), 8, 0));
      A742DLiqPerAno = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A742DLiqPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(A742DLiqPerAno), 4, 0));
      A1051LiqDSIPAApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1051LiqDSIPAApo", GXutil.str( A1051LiqDSIPAApo, 1, 0));
      A1052LiqDSIPACont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1052LiqDSIPACont", GXutil.str( A1052LiqDSIPACont, 1, 0));
      A1053LiqDINSSJyPApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1053LiqDINSSJyPApo", GXutil.str( A1053LiqDINSSJyPApo, 1, 0));
      A1054LiqDINSSJyPCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1054LiqDINSSJyPCont", GXutil.str( A1054LiqDINSSJyPCont, 1, 0));
      A1055LiqDObraSocApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1055LiqDObraSocApo", GXutil.str( A1055LiqDObraSocApo, 1, 0));
      A1056LiqDObraSocCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1056LiqDObraSocCont", GXutil.str( A1056LiqDObraSocCont, 1, 0));
      A1057LiqDFonSolRedApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1057LiqDFonSolRedApo", GXutil.str( A1057LiqDFonSolRedApo, 1, 0));
      A1058LiqDFonSolRedCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1058LiqDFonSolRedCont", GXutil.str( A1058LiqDFonSolRedCont, 1, 0));
      A1059LiqDRenateaApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1059LiqDRenateaApo", GXutil.str( A1059LiqDRenateaApo, 1, 0));
      A1060LiqDRenateaCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1060LiqDRenateaCont", GXutil.str( A1060LiqDRenateaCont, 1, 0));
      A1061LiqDAsigFamCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1061LiqDAsigFamCont", GXutil.str( A1061LiqDAsigFamCont, 1, 0));
      A1062LiqDFonNacEmpCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1062LiqDFonNacEmpCont", GXutil.str( A1062LiqDFonNacEmpCont, 1, 0));
      A1063LiqDLeyRieTrabCont = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1063LiqDLeyRieTrabCont", GXutil.str( A1063LiqDLeyRieTrabCont, 1, 0));
      A1064LiqDRegDifApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1064LiqDRegDifApo", GXutil.str( A1064LiqDRegDifApo, 1, 0));
      A1065LiqDRegEspApo = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1065LiqDRegEspApo", GXutil.str( A1065LiqDRegEspApo, 1, 0));
      A1067DConPrereq = "" ;
      n1067DConPrereq = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1067DConPrereq", A1067DConPrereq);
      n1067DConPrereq = ((GXutil.strcmp("", A1067DConPrereq)==0) ? true : false) ;
      A1134LiqDOrdVis = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1134LiqDOrdVis", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1134LiqDOrdVis), 4, 0));
      A1642DConLiqBasica = (byte)(0) ;
      n1642DConLiqBasica = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1642DConLiqBasica", GXutil.str( A1642DConLiqBasica, 1, 0));
      n1642DConLiqBasica = ((0==A1642DConLiqBasica) ? true : false) ;
      A1753DConConveCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1753DConConveCodigo", A1753DConConveCodigo);
      Z394DConCodigo = "" ;
      Z393DConDescrip = "" ;
      Z397DLiqPeriodo = GXutil.nullDate() ;
      Z400DTLiqCod = "" ;
      Z464DTipoConCod = "" ;
      Z468DSubTipoConCod1 = "" ;
      Z732DSubTipoConCod2 = "" ;
      Z2149LiqDClasifAux = "" ;
      Z269LiqDCanti = DecimalUtil.ZERO ;
      Z277LiqDValUni = DecimalUtil.ZERO ;
      Z276LiqDImporte = DecimalUtil.ZERO ;
      Z275LiqDImpCalcu = DecimalUtil.ZERO ;
      Z270LiqDErrorDesc = "" ;
      Z466DConVariable = false ;
      Z471DConOrden = 0 ;
      Z742DLiqPerAno = (short)(0) ;
      Z1051LiqDSIPAApo = (byte)(0) ;
      Z1052LiqDSIPACont = (byte)(0) ;
      Z1053LiqDINSSJyPApo = (byte)(0) ;
      Z1054LiqDINSSJyPCont = (byte)(0) ;
      Z1055LiqDObraSocApo = (byte)(0) ;
      Z1056LiqDObraSocCont = (byte)(0) ;
      Z1057LiqDFonSolRedApo = (byte)(0) ;
      Z1058LiqDFonSolRedCont = (byte)(0) ;
      Z1059LiqDRenateaApo = (byte)(0) ;
      Z1060LiqDRenateaCont = (byte)(0) ;
      Z1061LiqDAsigFamCont = (byte)(0) ;
      Z1062LiqDFonNacEmpCont = (byte)(0) ;
      Z1063LiqDLeyRieTrabCont = (byte)(0) ;
      Z1064LiqDRegDifApo = (byte)(0) ;
      Z1065LiqDRegEspApo = (byte)(0) ;
      Z1067DConPrereq = "" ;
      Z1134LiqDOrdVis = (short)(0) ;
      Z1642DConLiqBasica = (byte)(0) ;
      Z1753DConConveCodigo = "" ;
   }

   public void initAll0S26( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A31LiqNro = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A31LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31LiqNro), 8, 0));
      A6LegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      A81LiqDSecuencial = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A81LiqDSecuencial", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81LiqDSecuencial), 5, 0));
      initializeNonKey0S26( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025181755173", true, true);
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
      httpContext.AddJavascriptSource("liquidacion_excel_1.js", "?2025181755173", false, true);
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
      edtLiqNro_Internalname = "LIQNRO" ;
      edtLegNumero_Internalname = "LEGNUMERO" ;
      edtLiqDSecuencial_Internalname = "LIQDSECUENCIAL" ;
      edtDConCodigo_Internalname = "DCONCODIGO" ;
      edtDConDescrip_Internalname = "DCONDESCRIP" ;
      edtDLiqPeriodo_Internalname = "DLIQPERIODO" ;
      edtDTLiqCod_Internalname = "DTLIQCOD" ;
      cmbDTipoConCod.setInternalname( "DTIPOCONCOD" );
      edtDSubTipoConCod1_Internalname = "DSUBTIPOCONCOD1" ;
      edtDSubTipoConCod2_Internalname = "DSUBTIPOCONCOD2" ;
      edtLiqDClasifAux_Internalname = "LIQDCLASIFAUX" ;
      edtLiqDCanti_Internalname = "LIQDCANTI" ;
      edtLiqDValUni_Internalname = "LIQDVALUNI" ;
      edtLiqDImporte_Internalname = "LIQDIMPORTE" ;
      edtLiqDImpCalcu_Internalname = "LIQDIMPCALCU" ;
      edtLiqDFormula_Internalname = "LIQDFORMULA" ;
      edtLiqDErrorDesc_Internalname = "LIQDERRORDESC" ;
      chkDConVariable.setInternalname( "DCONVARIABLE" );
      edtDConOrden_Internalname = "DCONORDEN" ;
      edtDLiqPerAno_Internalname = "DLIQPERANO" ;
      edtLiqDSIPAApo_Internalname = "LIQDSIPAAPO" ;
      edtLiqDSIPACont_Internalname = "LIQDSIPACONT" ;
      edtLiqDINSSJyPApo_Internalname = "LIQDINSSJYPAPO" ;
      edtLiqDINSSJyPCont_Internalname = "LIQDINSSJYPCONT" ;
      edtLiqDObraSocApo_Internalname = "LIQDOBRASOCAPO" ;
      edtLiqDObraSocCont_Internalname = "LIQDOBRASOCCONT" ;
      edtLiqDFonSolRedApo_Internalname = "LIQDFONSOLREDAPO" ;
      edtLiqDFonSolRedCont_Internalname = "LIQDFONSOLREDCONT" ;
      edtLiqDRenateaApo_Internalname = "LIQDRENATEAAPO" ;
      edtLiqDRenateaCont_Internalname = "LIQDRENATEACONT" ;
      edtLiqDAsigFamCont_Internalname = "LIQDASIGFAMCONT" ;
      edtLiqDFonNacEmpCont_Internalname = "LIQDFONNACEMPCONT" ;
      edtLiqDLeyRieTrabCont_Internalname = "LIQDLEYRIETRABCONT" ;
      edtLiqDRegDifApo_Internalname = "LIQDREGDIFAPO" ;
      edtLiqDRegEspApo_Internalname = "LIQDREGESPAPO" ;
      cmbDConPrereq.setInternalname( "DCONPREREQ" );
      edtLiqDOrdVis_Internalname = "LIQDORDVIS" ;
      edtDConLiqBasica_Internalname = "DCONLIQBASICA" ;
      edtDConConveCodigo_Internalname = "DCONCONVECODIGO" ;
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
      Form.setCaption( httpContext.getMessage( "Liquidacion_Excel_1", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtDConConveCodigo_Jsonclick = "" ;
      edtDConConveCodigo_Enabled = 1 ;
      edtDConLiqBasica_Jsonclick = "" ;
      edtDConLiqBasica_Enabled = 1 ;
      edtLiqDOrdVis_Jsonclick = "" ;
      edtLiqDOrdVis_Enabled = 1 ;
      cmbDConPrereq.setJsonclick( "" );
      cmbDConPrereq.setEnabled( 1 );
      edtLiqDRegEspApo_Jsonclick = "" ;
      edtLiqDRegEspApo_Enabled = 1 ;
      edtLiqDRegDifApo_Jsonclick = "" ;
      edtLiqDRegDifApo_Enabled = 1 ;
      edtLiqDLeyRieTrabCont_Jsonclick = "" ;
      edtLiqDLeyRieTrabCont_Enabled = 1 ;
      edtLiqDFonNacEmpCont_Jsonclick = "" ;
      edtLiqDFonNacEmpCont_Enabled = 1 ;
      edtLiqDAsigFamCont_Jsonclick = "" ;
      edtLiqDAsigFamCont_Enabled = 1 ;
      edtLiqDRenateaCont_Jsonclick = "" ;
      edtLiqDRenateaCont_Enabled = 1 ;
      edtLiqDRenateaApo_Jsonclick = "" ;
      edtLiqDRenateaApo_Enabled = 1 ;
      edtLiqDFonSolRedCont_Jsonclick = "" ;
      edtLiqDFonSolRedCont_Enabled = 1 ;
      edtLiqDFonSolRedApo_Jsonclick = "" ;
      edtLiqDFonSolRedApo_Enabled = 1 ;
      edtLiqDObraSocCont_Jsonclick = "" ;
      edtLiqDObraSocCont_Enabled = 1 ;
      edtLiqDObraSocApo_Jsonclick = "" ;
      edtLiqDObraSocApo_Enabled = 1 ;
      edtLiqDINSSJyPCont_Jsonclick = "" ;
      edtLiqDINSSJyPCont_Enabled = 1 ;
      edtLiqDINSSJyPApo_Jsonclick = "" ;
      edtLiqDINSSJyPApo_Enabled = 1 ;
      edtLiqDSIPACont_Jsonclick = "" ;
      edtLiqDSIPACont_Enabled = 1 ;
      edtLiqDSIPAApo_Jsonclick = "" ;
      edtLiqDSIPAApo_Enabled = 1 ;
      edtDLiqPerAno_Jsonclick = "" ;
      edtDLiqPerAno_Enabled = 1 ;
      edtDConOrden_Jsonclick = "" ;
      edtDConOrden_Enabled = 1 ;
      chkDConVariable.setEnabled( 1 );
      edtLiqDErrorDesc_Enabled = 1 ;
      edtLiqDFormula_Enabled = 1 ;
      edtLiqDImpCalcu_Jsonclick = "" ;
      edtLiqDImpCalcu_Enabled = 1 ;
      edtLiqDImporte_Jsonclick = "" ;
      edtLiqDImporte_Enabled = 1 ;
      edtLiqDValUni_Jsonclick = "" ;
      edtLiqDValUni_Enabled = 1 ;
      edtLiqDCanti_Jsonclick = "" ;
      edtLiqDCanti_Enabled = 1 ;
      edtLiqDClasifAux_Jsonclick = "" ;
      edtLiqDClasifAux_Enabled = 1 ;
      edtDSubTipoConCod2_Jsonclick = "" ;
      edtDSubTipoConCod2_Enabled = 1 ;
      edtDSubTipoConCod1_Jsonclick = "" ;
      edtDSubTipoConCod1_Enabled = 1 ;
      cmbDTipoConCod.setJsonclick( "" );
      cmbDTipoConCod.setEnabled( 1 );
      edtDTLiqCod_Jsonclick = "" ;
      edtDTLiqCod_Enabled = 1 ;
      edtDLiqPeriodo_Jsonclick = "" ;
      edtDLiqPeriodo_Enabled = 1 ;
      edtDConDescrip_Enabled = 1 ;
      edtDConCodigo_Jsonclick = "" ;
      edtDConCodigo_Enabled = 1 ;
      edtLiqDSecuencial_Jsonclick = "" ;
      edtLiqDSecuencial_Enabled = 1 ;
      edtLegNumero_Jsonclick = "" ;
      edtLegNumero_Enabled = 1 ;
      edtLiqNro_Jsonclick = "" ;
      edtLiqNro_Enabled = 1 ;
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
      cmbDTipoConCod.setName( "DTIPOCONCOD" );
      cmbDTipoConCod.setWebtags( "" );
      cmbDTipoConCod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
      cmbDTipoConCod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
      cmbDTipoConCod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
      cmbDTipoConCod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
      if ( cmbDTipoConCod.getItemCount() > 0 )
      {
         A464DTipoConCod = cmbDTipoConCod.getValidValue(A464DTipoConCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "A464DTipoConCod", A464DTipoConCod);
      }
      chkDConVariable.setName( "DCONVARIABLE" );
      chkDConVariable.setWebtags( "" );
      chkDConVariable.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkDConVariable.getInternalname(), "TitleCaption", chkDConVariable.getCaption(), true);
      chkDConVariable.setCheckedValue( "false" );
      A466DConVariable = GXutil.strtobool( GXutil.booltostr( A466DConVariable)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A466DConVariable", A466DConVariable);
      cmbDConPrereq.setName( "DCONPREREQ" );
      cmbDConPrereq.setWebtags( "" );
      cmbDConPrereq.addItem("APO_SIPA", httpContext.getMessage( "Conceptos que aporten a SIPA o Renatre", ""), (short)(0));
      cmbDConPrereq.addItem("APO_SIPA_NoSacNiVac", httpContext.getMessage( "Conceptos que aporten a SIPA o Renatre distintos a SAC y vacaciones", ""), (short)(0));
      cmbDConPrereq.addItem("APO_INSSJyP", httpContext.getMessage( "Conceptos que aporten a INSSJyP", ""), (short)(0));
      cmbDConPrereq.addItem("APO_OS", httpContext.getMessage( "Conceptos que aporten a Obra Social o FSR", ""), (short)(0));
      cmbDConPrereq.addItem("APO_DIF", httpContext.getMessage( "Conceptos que aporten a Diferenciales", ""), (short)(0));
      cmbDConPrereq.addItem("APO_ESP", httpContext.getMessage( "Conceptos que aporten a Especiales", ""), (short)(0));
      cmbDConPrereq.addItem("CON_SIPA", httpContext.getMessage( "Conceptos que contribuyan a SIPA o INSSJyP", ""), (short)(0));
      cmbDConPrereq.addItem("CON_OS", httpContext.getMessage( "Conceptos que contribuyan a Obra social o FSR", ""), (short)(0));
      cmbDConPrereq.addItem("CON_FNE", httpContext.getMessage( "Conceptos que contribuyan a AAFF, Renatre,o FNE", ""), (short)(0));
      cmbDConPrereq.addItem("CON_LRT", httpContext.getMessage( "Conceptos que contribuyan a LRT", ""), (short)(0));
      cmbDConPrereq.addItem("BRUTA", httpContext.getMessage( "Conceptos remunerativos y no remunerativos", ""), (short)(0));
      cmbDConPrereq.addItem("REM", httpContext.getMessage( "Conceptos remunerativos", ""), (short)(0));
      cmbDConPrereq.addItem("NRE", httpContext.getMessage( "Conceptos no remunerativos", ""), (short)(0));
      cmbDConPrereq.addItem("REMNOSAC", httpContext.getMessage( "Conceptos remunerativos exceptuando SAC", ""), (short)(0));
      cmbDConPrereq.addItem("EXENTOS", httpContext.getMessage( "Conceptos totalmente exentos de IIGG (excepto sac) y conceptos prorrateables", ""), (short)(0));
      cmbDConPrereq.addItem("LICENCIAS", httpContext.getMessage( "Conceptos relacionados a licencias o feriados", ""), (short)(0));
      cmbDConPrereq.addItem("FIJAS", httpContext.getMessage( "Conceptos de remuneración fija de tipo remunerativos y no remunerativos con clasificacion distinta a vacaciones", ""), (short)(0));
      if ( cmbDConPrereq.getItemCount() > 0 )
      {
         A1067DConPrereq = cmbDConPrereq.getValidValue(A1067DConPrereq) ;
         n1067DConPrereq = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1067DConPrereq", A1067DConPrereq);
      }
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      /* Using cursor T000S14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(12);
      GX_FocusControl = edtDConCodigo_Internalname ;
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

   public void valid_Legnumero( )
   {
      /* Using cursor T000S14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(12);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Liqdsecuencial( )
   {
      n1067DConPrereq = false ;
      A1067DConPrereq = cmbDConPrereq.getValue() ;
      n1067DConPrereq = false ;
      cmbDConPrereq.setValue( A1067DConPrereq );
      A464DTipoConCod = cmbDTipoConCod.getValue() ;
      cmbDTipoConCod.setValue( A464DTipoConCod );
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      if ( cmbDTipoConCod.getItemCount() > 0 )
      {
         A464DTipoConCod = cmbDTipoConCod.getValidValue(A464DTipoConCod) ;
         cmbDTipoConCod.setValue( A464DTipoConCod );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbDTipoConCod.setValue( GXutil.rtrim( A464DTipoConCod) );
      }
      A466DConVariable = GXutil.strtobool( GXutil.booltostr( A466DConVariable)) ;
      if ( cmbDConPrereq.getItemCount() > 0 )
      {
         A1067DConPrereq = cmbDConPrereq.getValidValue(A1067DConPrereq) ;
         n1067DConPrereq = false ;
         cmbDConPrereq.setValue( A1067DConPrereq );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbDConPrereq.setValue( GXutil.rtrim( A1067DConPrereq) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A394DConCodigo", GXutil.rtrim( A394DConCodigo));
      httpContext.ajax_rsp_assign_attri("", false, "A393DConDescrip", A393DConDescrip);
      httpContext.ajax_rsp_assign_attri("", false, "A397DLiqPeriodo", localUtil.format(A397DLiqPeriodo, "99/99/9999"));
      httpContext.ajax_rsp_assign_attri("", false, "A400DTLiqCod", GXutil.rtrim( A400DTLiqCod));
      httpContext.ajax_rsp_assign_attri("", false, "A464DTipoConCod", GXutil.rtrim( A464DTipoConCod));
      cmbDTipoConCod.setValue( GXutil.rtrim( A464DTipoConCod) );
      httpContext.ajax_rsp_assign_prop("", false, cmbDTipoConCod.getInternalname(), "Values", cmbDTipoConCod.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A468DSubTipoConCod1", GXutil.rtrim( A468DSubTipoConCod1));
      httpContext.ajax_rsp_assign_attri("", false, "A732DSubTipoConCod2", GXutil.rtrim( A732DSubTipoConCod2));
      httpContext.ajax_rsp_assign_attri("", false, "A2149LiqDClasifAux", A2149LiqDClasifAux);
      httpContext.ajax_rsp_assign_attri("", false, "A269LiqDCanti", GXutil.ltrim( localUtil.ntoc( A269LiqDCanti, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A277LiqDValUni", GXutil.ltrim( localUtil.ntoc( A277LiqDValUni, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A276LiqDImporte", GXutil.ltrim( localUtil.ntoc( A276LiqDImporte, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A275LiqDImpCalcu", GXutil.ltrim( localUtil.ntoc( A275LiqDImpCalcu, (byte)(14), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A274LiqDFormula", A274LiqDFormula);
      httpContext.ajax_rsp_assign_attri("", false, "A270LiqDErrorDesc", A270LiqDErrorDesc);
      httpContext.ajax_rsp_assign_attri("", false, "A466DConVariable", A466DConVariable);
      httpContext.ajax_rsp_assign_attri("", false, "A471DConOrden", GXutil.ltrim( localUtil.ntoc( A471DConOrden, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A742DLiqPerAno", GXutil.ltrim( localUtil.ntoc( A742DLiqPerAno, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1051LiqDSIPAApo", GXutil.ltrim( localUtil.ntoc( A1051LiqDSIPAApo, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1052LiqDSIPACont", GXutil.ltrim( localUtil.ntoc( A1052LiqDSIPACont, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1053LiqDINSSJyPApo", GXutil.ltrim( localUtil.ntoc( A1053LiqDINSSJyPApo, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1054LiqDINSSJyPCont", GXutil.ltrim( localUtil.ntoc( A1054LiqDINSSJyPCont, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1055LiqDObraSocApo", GXutil.ltrim( localUtil.ntoc( A1055LiqDObraSocApo, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1056LiqDObraSocCont", GXutil.ltrim( localUtil.ntoc( A1056LiqDObraSocCont, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1057LiqDFonSolRedApo", GXutil.ltrim( localUtil.ntoc( A1057LiqDFonSolRedApo, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1058LiqDFonSolRedCont", GXutil.ltrim( localUtil.ntoc( A1058LiqDFonSolRedCont, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1059LiqDRenateaApo", GXutil.ltrim( localUtil.ntoc( A1059LiqDRenateaApo, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1060LiqDRenateaCont", GXutil.ltrim( localUtil.ntoc( A1060LiqDRenateaCont, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1061LiqDAsigFamCont", GXutil.ltrim( localUtil.ntoc( A1061LiqDAsigFamCont, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1062LiqDFonNacEmpCont", GXutil.ltrim( localUtil.ntoc( A1062LiqDFonNacEmpCont, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1063LiqDLeyRieTrabCont", GXutil.ltrim( localUtil.ntoc( A1063LiqDLeyRieTrabCont, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1064LiqDRegDifApo", GXutil.ltrim( localUtil.ntoc( A1064LiqDRegDifApo, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1065LiqDRegEspApo", GXutil.ltrim( localUtil.ntoc( A1065LiqDRegEspApo, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1067DConPrereq", GXutil.rtrim( A1067DConPrereq));
      cmbDConPrereq.setValue( GXutil.rtrim( A1067DConPrereq) );
      httpContext.ajax_rsp_assign_prop("", false, cmbDConPrereq.getInternalname(), "Values", cmbDConPrereq.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A1134LiqDOrdVis", GXutil.ltrim( localUtil.ntoc( A1134LiqDOrdVis, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1642DConLiqBasica", GXutil.ltrim( localUtil.ntoc( A1642DConLiqBasica, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1753DConConveCodigo", GXutil.rtrim( A1753DConConveCodigo));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z31LiqNro", GXutil.ltrim( localUtil.ntoc( Z31LiqNro, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z81LiqDSecuencial", GXutil.ltrim( localUtil.ntoc( Z81LiqDSecuencial, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z394DConCodigo", GXutil.rtrim( Z394DConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z393DConDescrip", Z393DConDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z397DLiqPeriodo", localUtil.format(Z397DLiqPeriodo, "99/99/9999"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z400DTLiqCod", GXutil.rtrim( Z400DTLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z464DTipoConCod", GXutil.rtrim( Z464DTipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z468DSubTipoConCod1", GXutil.rtrim( Z468DSubTipoConCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "Z732DSubTipoConCod2", GXutil.rtrim( Z732DSubTipoConCod2));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2149LiqDClasifAux", Z2149LiqDClasifAux);
      web.GxWebStd.gx_hidden_field( httpContext, "Z269LiqDCanti", GXutil.ltrim( localUtil.ntoc( Z269LiqDCanti, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z277LiqDValUni", GXutil.ltrim( localUtil.ntoc( Z277LiqDValUni, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z276LiqDImporte", GXutil.ltrim( localUtil.ntoc( Z276LiqDImporte, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z275LiqDImpCalcu", GXutil.ltrim( localUtil.ntoc( Z275LiqDImpCalcu, (byte)(14), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z274LiqDFormula", Z274LiqDFormula);
      web.GxWebStd.gx_hidden_field( httpContext, "Z270LiqDErrorDesc", Z270LiqDErrorDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z466DConVariable", GXutil.booltostr( Z466DConVariable));
      web.GxWebStd.gx_hidden_field( httpContext, "Z471DConOrden", GXutil.ltrim( localUtil.ntoc( Z471DConOrden, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z742DLiqPerAno", GXutil.ltrim( localUtil.ntoc( Z742DLiqPerAno, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1051LiqDSIPAApo", GXutil.ltrim( localUtil.ntoc( Z1051LiqDSIPAApo, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1052LiqDSIPACont", GXutil.ltrim( localUtil.ntoc( Z1052LiqDSIPACont, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1053LiqDINSSJyPApo", GXutil.ltrim( localUtil.ntoc( Z1053LiqDINSSJyPApo, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1054LiqDINSSJyPCont", GXutil.ltrim( localUtil.ntoc( Z1054LiqDINSSJyPCont, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1055LiqDObraSocApo", GXutil.ltrim( localUtil.ntoc( Z1055LiqDObraSocApo, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1056LiqDObraSocCont", GXutil.ltrim( localUtil.ntoc( Z1056LiqDObraSocCont, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1057LiqDFonSolRedApo", GXutil.ltrim( localUtil.ntoc( Z1057LiqDFonSolRedApo, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1058LiqDFonSolRedCont", GXutil.ltrim( localUtil.ntoc( Z1058LiqDFonSolRedCont, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1059LiqDRenateaApo", GXutil.ltrim( localUtil.ntoc( Z1059LiqDRenateaApo, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1060LiqDRenateaCont", GXutil.ltrim( localUtil.ntoc( Z1060LiqDRenateaCont, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1061LiqDAsigFamCont", GXutil.ltrim( localUtil.ntoc( Z1061LiqDAsigFamCont, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1062LiqDFonNacEmpCont", GXutil.ltrim( localUtil.ntoc( Z1062LiqDFonNacEmpCont, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1063LiqDLeyRieTrabCont", GXutil.ltrim( localUtil.ntoc( Z1063LiqDLeyRieTrabCont, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1064LiqDRegDifApo", GXutil.ltrim( localUtil.ntoc( Z1064LiqDRegDifApo, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1065LiqDRegEspApo", GXutil.ltrim( localUtil.ntoc( Z1065LiqDRegEspApo, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1067DConPrereq", GXutil.rtrim( Z1067DConPrereq));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1134LiqDOrdVis", GXutil.ltrim( localUtil.ntoc( Z1134LiqDOrdVis, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1642DConLiqBasica", GXutil.ltrim( localUtil.ntoc( Z1642DConLiqBasica, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1753DConConveCodigo", GXutil.rtrim( Z1753DConConveCodigo));
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]}");
      setEventMetadata("VALID_LIQNRO","{handler:'valid_Liqnro',iparms:[{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]");
      setEventMetadata("VALID_LIQNRO",",oparms:[{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]}");
      setEventMetadata("VALID_LIQDSECUENCIAL","{handler:'valid_Liqdsecuencial',iparms:[{av:'cmbDConPrereq'},{av:'A1067DConPrereq',fld:'DCONPREREQ',pic:''},{av:'cmbDTipoConCod'},{av:'A464DTipoConCod',fld:'DTIPOCONCOD',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A81LiqDSecuencial',fld:'LIQDSECUENCIAL',pic:'ZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]");
      setEventMetadata("VALID_LIQDSECUENCIAL",",oparms:[{av:'A394DConCodigo',fld:'DCONCODIGO',pic:''},{av:'A393DConDescrip',fld:'DCONDESCRIP',pic:''},{av:'A397DLiqPeriodo',fld:'DLIQPERIODO',pic:''},{av:'A400DTLiqCod',fld:'DTLIQCOD',pic:''},{av:'cmbDTipoConCod'},{av:'A464DTipoConCod',fld:'DTIPOCONCOD',pic:''},{av:'A468DSubTipoConCod1',fld:'DSUBTIPOCONCOD1',pic:''},{av:'A732DSubTipoConCod2',fld:'DSUBTIPOCONCOD2',pic:''},{av:'A2149LiqDClasifAux',fld:'LIQDCLASIFAUX',pic:''},{av:'A269LiqDCanti',fld:'LIQDCANTI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A277LiqDValUni',fld:'LIQDVALUNI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A276LiqDImporte',fld:'LIQDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A275LiqDImpCalcu',fld:'LIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A274LiqDFormula',fld:'LIQDFORMULA',pic:''},{av:'A270LiqDErrorDesc',fld:'LIQDERRORDESC',pic:''},{av:'A471DConOrden',fld:'DCONORDEN',pic:'ZZZZZZZ9'},{av:'A742DLiqPerAno',fld:'DLIQPERANO',pic:'ZZZ9'},{av:'A1051LiqDSIPAApo',fld:'LIQDSIPAAPO',pic:'9'},{av:'A1052LiqDSIPACont',fld:'LIQDSIPACONT',pic:'9'},{av:'A1053LiqDINSSJyPApo',fld:'LIQDINSSJYPAPO',pic:'9'},{av:'A1054LiqDINSSJyPCont',fld:'LIQDINSSJYPCONT',pic:'9'},{av:'A1055LiqDObraSocApo',fld:'LIQDOBRASOCAPO',pic:'9'},{av:'A1056LiqDObraSocCont',fld:'LIQDOBRASOCCONT',pic:'9'},{av:'A1057LiqDFonSolRedApo',fld:'LIQDFONSOLREDAPO',pic:'9'},{av:'A1058LiqDFonSolRedCont',fld:'LIQDFONSOLREDCONT',pic:'9'},{av:'A1059LiqDRenateaApo',fld:'LIQDRENATEAAPO',pic:'9'},{av:'A1060LiqDRenateaCont',fld:'LIQDRENATEACONT',pic:'9'},{av:'A1061LiqDAsigFamCont',fld:'LIQDASIGFAMCONT',pic:'9'},{av:'A1062LiqDFonNacEmpCont',fld:'LIQDFONNACEMPCONT',pic:'9'},{av:'A1063LiqDLeyRieTrabCont',fld:'LIQDLEYRIETRABCONT',pic:'9'},{av:'A1064LiqDRegDifApo',fld:'LIQDREGDIFAPO',pic:'9'},{av:'A1065LiqDRegEspApo',fld:'LIQDREGESPAPO',pic:'9'},{av:'cmbDConPrereq'},{av:'A1067DConPrereq',fld:'DCONPREREQ',pic:''},{av:'A1134LiqDOrdVis',fld:'LIQDORDVIS',pic:'ZZZ9'},{av:'A1642DConLiqBasica',fld:'DCONLIQBASICA',pic:'9'},{av:'A1753DConConveCodigo',fld:'DCONCONVECODIGO',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z3CliCod'},{av:'Z1EmpCod'},{av:'Z31LiqNro'},{av:'Z6LegNumero'},{av:'Z81LiqDSecuencial'},{av:'Z394DConCodigo'},{av:'Z393DConDescrip'},{av:'Z397DLiqPeriodo'},{av:'Z400DTLiqCod'},{av:'Z464DTipoConCod'},{av:'Z468DSubTipoConCod1'},{av:'Z732DSubTipoConCod2'},{av:'Z2149LiqDClasifAux'},{av:'Z269LiqDCanti'},{av:'Z277LiqDValUni'},{av:'Z276LiqDImporte'},{av:'Z275LiqDImpCalcu'},{av:'Z274LiqDFormula'},{av:'Z270LiqDErrorDesc'},{av:'Z466DConVariable'},{av:'Z471DConOrden'},{av:'Z742DLiqPerAno'},{av:'Z1051LiqDSIPAApo'},{av:'Z1052LiqDSIPACont'},{av:'Z1053LiqDINSSJyPApo'},{av:'Z1054LiqDINSSJyPCont'},{av:'Z1055LiqDObraSocApo'},{av:'Z1056LiqDObraSocCont'},{av:'Z1057LiqDFonSolRedApo'},{av:'Z1058LiqDFonSolRedCont'},{av:'Z1059LiqDRenateaApo'},{av:'Z1060LiqDRenateaCont'},{av:'Z1061LiqDAsigFamCont'},{av:'Z1062LiqDFonNacEmpCont'},{av:'Z1063LiqDLeyRieTrabCont'},{av:'Z1064LiqDRegDifApo'},{av:'Z1065LiqDRegEspApo'},{av:'Z1067DConPrereq'},{av:'Z1134LiqDOrdVis'},{av:'Z1642DConLiqBasica'},{av:'Z1753DConConveCodigo'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'},{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]}");
      setEventMetadata("VALID_DTIPOCONCOD","{handler:'valid_Dtipoconcod',iparms:[{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]");
      setEventMetadata("VALID_DTIPOCONCOD",",oparms:[{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]}");
      setEventMetadata("VALID_DCONPREREQ","{handler:'valid_Dconprereq',iparms:[{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]");
      setEventMetadata("VALID_DCONPREREQ",",oparms:[{av:'A466DConVariable',fld:'DCONVARIABLE',pic:''}]}");
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
      Z394DConCodigo = "" ;
      Z393DConDescrip = "" ;
      Z397DLiqPeriodo = GXutil.nullDate() ;
      Z400DTLiqCod = "" ;
      Z464DTipoConCod = "" ;
      Z468DSubTipoConCod1 = "" ;
      Z732DSubTipoConCod2 = "" ;
      Z2149LiqDClasifAux = "" ;
      Z269LiqDCanti = DecimalUtil.ZERO ;
      Z277LiqDValUni = DecimalUtil.ZERO ;
      Z276LiqDImporte = DecimalUtil.ZERO ;
      Z275LiqDImpCalcu = DecimalUtil.ZERO ;
      Z270LiqDErrorDesc = "" ;
      Z1067DConPrereq = "" ;
      Z1753DConConveCodigo = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A464DTipoConCod = "" ;
      A1067DConPrereq = "" ;
      lblTitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A394DConCodigo = "" ;
      A393DConDescrip = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A400DTLiqCod = "" ;
      A468DSubTipoConCod1 = "" ;
      A732DSubTipoConCod2 = "" ;
      A2149LiqDClasifAux = "" ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A277LiqDValUni = DecimalUtil.ZERO ;
      A276LiqDImporte = DecimalUtil.ZERO ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      A274LiqDFormula = "" ;
      A270LiqDErrorDesc = "" ;
      A1753DConConveCodigo = "" ;
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
      Z274LiqDFormula = "" ;
      T000S5_A81LiqDSecuencial = new int[1] ;
      T000S5_A394DConCodigo = new String[] {""} ;
      T000S5_A393DConDescrip = new String[] {""} ;
      T000S5_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T000S5_A400DTLiqCod = new String[] {""} ;
      T000S5_A464DTipoConCod = new String[] {""} ;
      T000S5_A468DSubTipoConCod1 = new String[] {""} ;
      T000S5_n468DSubTipoConCod1 = new boolean[] {false} ;
      T000S5_A732DSubTipoConCod2 = new String[] {""} ;
      T000S5_n732DSubTipoConCod2 = new boolean[] {false} ;
      T000S5_A2149LiqDClasifAux = new String[] {""} ;
      T000S5_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000S5_n269LiqDCanti = new boolean[] {false} ;
      T000S5_A277LiqDValUni = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000S5_n277LiqDValUni = new boolean[] {false} ;
      T000S5_A276LiqDImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000S5_n276LiqDImporte = new boolean[] {false} ;
      T000S5_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000S5_n275LiqDImpCalcu = new boolean[] {false} ;
      T000S5_A274LiqDFormula = new String[] {""} ;
      T000S5_n274LiqDFormula = new boolean[] {false} ;
      T000S5_A270LiqDErrorDesc = new String[] {""} ;
      T000S5_n270LiqDErrorDesc = new boolean[] {false} ;
      T000S5_A466DConVariable = new boolean[] {false} ;
      T000S5_A471DConOrden = new int[1] ;
      T000S5_A742DLiqPerAno = new short[1] ;
      T000S5_A1051LiqDSIPAApo = new byte[1] ;
      T000S5_A1052LiqDSIPACont = new byte[1] ;
      T000S5_A1053LiqDINSSJyPApo = new byte[1] ;
      T000S5_A1054LiqDINSSJyPCont = new byte[1] ;
      T000S5_A1055LiqDObraSocApo = new byte[1] ;
      T000S5_A1056LiqDObraSocCont = new byte[1] ;
      T000S5_A1057LiqDFonSolRedApo = new byte[1] ;
      T000S5_A1058LiqDFonSolRedCont = new byte[1] ;
      T000S5_A1059LiqDRenateaApo = new byte[1] ;
      T000S5_A1060LiqDRenateaCont = new byte[1] ;
      T000S5_A1061LiqDAsigFamCont = new byte[1] ;
      T000S5_A1062LiqDFonNacEmpCont = new byte[1] ;
      T000S5_A1063LiqDLeyRieTrabCont = new byte[1] ;
      T000S5_A1064LiqDRegDifApo = new byte[1] ;
      T000S5_A1065LiqDRegEspApo = new byte[1] ;
      T000S5_A1067DConPrereq = new String[] {""} ;
      T000S5_n1067DConPrereq = new boolean[] {false} ;
      T000S5_A1134LiqDOrdVis = new short[1] ;
      T000S5_A1642DConLiqBasica = new byte[1] ;
      T000S5_n1642DConLiqBasica = new boolean[] {false} ;
      T000S5_A1753DConConveCodigo = new String[] {""} ;
      T000S5_A3CliCod = new int[1] ;
      T000S5_A1EmpCod = new short[1] ;
      T000S5_A6LegNumero = new int[1] ;
      T000S5_A31LiqNro = new int[1] ;
      T000S4_A3CliCod = new int[1] ;
      T000S6_A3CliCod = new int[1] ;
      T000S7_A3CliCod = new int[1] ;
      T000S7_A1EmpCod = new short[1] ;
      T000S7_A31LiqNro = new int[1] ;
      T000S7_A6LegNumero = new int[1] ;
      T000S7_A81LiqDSecuencial = new int[1] ;
      T000S3_A81LiqDSecuencial = new int[1] ;
      T000S3_A394DConCodigo = new String[] {""} ;
      T000S3_A393DConDescrip = new String[] {""} ;
      T000S3_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T000S3_A400DTLiqCod = new String[] {""} ;
      T000S3_A464DTipoConCod = new String[] {""} ;
      T000S3_A468DSubTipoConCod1 = new String[] {""} ;
      T000S3_n468DSubTipoConCod1 = new boolean[] {false} ;
      T000S3_A732DSubTipoConCod2 = new String[] {""} ;
      T000S3_n732DSubTipoConCod2 = new boolean[] {false} ;
      T000S3_A2149LiqDClasifAux = new String[] {""} ;
      T000S3_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000S3_n269LiqDCanti = new boolean[] {false} ;
      T000S3_A277LiqDValUni = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000S3_n277LiqDValUni = new boolean[] {false} ;
      T000S3_A276LiqDImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000S3_n276LiqDImporte = new boolean[] {false} ;
      T000S3_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000S3_n275LiqDImpCalcu = new boolean[] {false} ;
      T000S3_A274LiqDFormula = new String[] {""} ;
      T000S3_n274LiqDFormula = new boolean[] {false} ;
      T000S3_A270LiqDErrorDesc = new String[] {""} ;
      T000S3_n270LiqDErrorDesc = new boolean[] {false} ;
      T000S3_A466DConVariable = new boolean[] {false} ;
      T000S3_A471DConOrden = new int[1] ;
      T000S3_A742DLiqPerAno = new short[1] ;
      T000S3_A1051LiqDSIPAApo = new byte[1] ;
      T000S3_A1052LiqDSIPACont = new byte[1] ;
      T000S3_A1053LiqDINSSJyPApo = new byte[1] ;
      T000S3_A1054LiqDINSSJyPCont = new byte[1] ;
      T000S3_A1055LiqDObraSocApo = new byte[1] ;
      T000S3_A1056LiqDObraSocCont = new byte[1] ;
      T000S3_A1057LiqDFonSolRedApo = new byte[1] ;
      T000S3_A1058LiqDFonSolRedCont = new byte[1] ;
      T000S3_A1059LiqDRenateaApo = new byte[1] ;
      T000S3_A1060LiqDRenateaCont = new byte[1] ;
      T000S3_A1061LiqDAsigFamCont = new byte[1] ;
      T000S3_A1062LiqDFonNacEmpCont = new byte[1] ;
      T000S3_A1063LiqDLeyRieTrabCont = new byte[1] ;
      T000S3_A1064LiqDRegDifApo = new byte[1] ;
      T000S3_A1065LiqDRegEspApo = new byte[1] ;
      T000S3_A1067DConPrereq = new String[] {""} ;
      T000S3_n1067DConPrereq = new boolean[] {false} ;
      T000S3_A1134LiqDOrdVis = new short[1] ;
      T000S3_A1642DConLiqBasica = new byte[1] ;
      T000S3_n1642DConLiqBasica = new boolean[] {false} ;
      T000S3_A1753DConConveCodigo = new String[] {""} ;
      T000S3_A3CliCod = new int[1] ;
      T000S3_A1EmpCod = new short[1] ;
      T000S3_A6LegNumero = new int[1] ;
      T000S3_A31LiqNro = new int[1] ;
      sMode26 = "" ;
      T000S8_A3CliCod = new int[1] ;
      T000S8_A1EmpCod = new short[1] ;
      T000S8_A31LiqNro = new int[1] ;
      T000S8_A6LegNumero = new int[1] ;
      T000S8_A81LiqDSecuencial = new int[1] ;
      T000S9_A3CliCod = new int[1] ;
      T000S9_A1EmpCod = new short[1] ;
      T000S9_A31LiqNro = new int[1] ;
      T000S9_A6LegNumero = new int[1] ;
      T000S9_A81LiqDSecuencial = new int[1] ;
      T000S2_A81LiqDSecuencial = new int[1] ;
      T000S2_A394DConCodigo = new String[] {""} ;
      T000S2_A393DConDescrip = new String[] {""} ;
      T000S2_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T000S2_A400DTLiqCod = new String[] {""} ;
      T000S2_A464DTipoConCod = new String[] {""} ;
      T000S2_A468DSubTipoConCod1 = new String[] {""} ;
      T000S2_n468DSubTipoConCod1 = new boolean[] {false} ;
      T000S2_A732DSubTipoConCod2 = new String[] {""} ;
      T000S2_n732DSubTipoConCod2 = new boolean[] {false} ;
      T000S2_A2149LiqDClasifAux = new String[] {""} ;
      T000S2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000S2_n269LiqDCanti = new boolean[] {false} ;
      T000S2_A277LiqDValUni = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000S2_n277LiqDValUni = new boolean[] {false} ;
      T000S2_A276LiqDImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000S2_n276LiqDImporte = new boolean[] {false} ;
      T000S2_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000S2_n275LiqDImpCalcu = new boolean[] {false} ;
      T000S2_A274LiqDFormula = new String[] {""} ;
      T000S2_n274LiqDFormula = new boolean[] {false} ;
      T000S2_A270LiqDErrorDesc = new String[] {""} ;
      T000S2_n270LiqDErrorDesc = new boolean[] {false} ;
      T000S2_A466DConVariable = new boolean[] {false} ;
      T000S2_A471DConOrden = new int[1] ;
      T000S2_A742DLiqPerAno = new short[1] ;
      T000S2_A1051LiqDSIPAApo = new byte[1] ;
      T000S2_A1052LiqDSIPACont = new byte[1] ;
      T000S2_A1053LiqDINSSJyPApo = new byte[1] ;
      T000S2_A1054LiqDINSSJyPCont = new byte[1] ;
      T000S2_A1055LiqDObraSocApo = new byte[1] ;
      T000S2_A1056LiqDObraSocCont = new byte[1] ;
      T000S2_A1057LiqDFonSolRedApo = new byte[1] ;
      T000S2_A1058LiqDFonSolRedCont = new byte[1] ;
      T000S2_A1059LiqDRenateaApo = new byte[1] ;
      T000S2_A1060LiqDRenateaCont = new byte[1] ;
      T000S2_A1061LiqDAsigFamCont = new byte[1] ;
      T000S2_A1062LiqDFonNacEmpCont = new byte[1] ;
      T000S2_A1063LiqDLeyRieTrabCont = new byte[1] ;
      T000S2_A1064LiqDRegDifApo = new byte[1] ;
      T000S2_A1065LiqDRegEspApo = new byte[1] ;
      T000S2_A1067DConPrereq = new String[] {""} ;
      T000S2_n1067DConPrereq = new boolean[] {false} ;
      T000S2_A1134LiqDOrdVis = new short[1] ;
      T000S2_A1642DConLiqBasica = new byte[1] ;
      T000S2_n1642DConLiqBasica = new boolean[] {false} ;
      T000S2_A1753DConConveCodigo = new String[] {""} ;
      T000S2_A3CliCod = new int[1] ;
      T000S2_A1EmpCod = new short[1] ;
      T000S2_A6LegNumero = new int[1] ;
      T000S2_A31LiqNro = new int[1] ;
      T000S13_A3CliCod = new int[1] ;
      T000S13_A1EmpCod = new short[1] ;
      T000S13_A31LiqNro = new int[1] ;
      T000S13_A6LegNumero = new int[1] ;
      T000S13_A81LiqDSecuencial = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T000S14_A3CliCod = new int[1] ;
      ZZ394DConCodigo = "" ;
      ZZ393DConDescrip = "" ;
      ZZ397DLiqPeriodo = GXutil.nullDate() ;
      ZZ400DTLiqCod = "" ;
      ZZ464DTipoConCod = "" ;
      ZZ468DSubTipoConCod1 = "" ;
      ZZ732DSubTipoConCod2 = "" ;
      ZZ2149LiqDClasifAux = "" ;
      ZZ269LiqDCanti = DecimalUtil.ZERO ;
      ZZ277LiqDValUni = DecimalUtil.ZERO ;
      ZZ276LiqDImporte = DecimalUtil.ZERO ;
      ZZ275LiqDImpCalcu = DecimalUtil.ZERO ;
      ZZ274LiqDFormula = "" ;
      ZZ270LiqDErrorDesc = "" ;
      ZZ1067DConPrereq = "" ;
      ZZ1753DConConveCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacion_excel_1__default(),
         new Object[] {
             new Object[] {
            T000S2_A81LiqDSecuencial, T000S2_A394DConCodigo, T000S2_A393DConDescrip, T000S2_A397DLiqPeriodo, T000S2_A400DTLiqCod, T000S2_A464DTipoConCod, T000S2_A468DSubTipoConCod1, T000S2_n468DSubTipoConCod1, T000S2_A732DSubTipoConCod2, T000S2_n732DSubTipoConCod2,
            T000S2_A2149LiqDClasifAux, T000S2_A269LiqDCanti, T000S2_n269LiqDCanti, T000S2_A277LiqDValUni, T000S2_n277LiqDValUni, T000S2_A276LiqDImporte, T000S2_n276LiqDImporte, T000S2_A275LiqDImpCalcu, T000S2_n275LiqDImpCalcu, T000S2_A274LiqDFormula,
            T000S2_n274LiqDFormula, T000S2_A270LiqDErrorDesc, T000S2_n270LiqDErrorDesc, T000S2_A466DConVariable, T000S2_A471DConOrden, T000S2_A742DLiqPerAno, T000S2_A1051LiqDSIPAApo, T000S2_A1052LiqDSIPACont, T000S2_A1053LiqDINSSJyPApo, T000S2_A1054LiqDINSSJyPCont,
            T000S2_A1055LiqDObraSocApo, T000S2_A1056LiqDObraSocCont, T000S2_A1057LiqDFonSolRedApo, T000S2_A1058LiqDFonSolRedCont, T000S2_A1059LiqDRenateaApo, T000S2_A1060LiqDRenateaCont, T000S2_A1061LiqDAsigFamCont, T000S2_A1062LiqDFonNacEmpCont, T000S2_A1063LiqDLeyRieTrabCont, T000S2_A1064LiqDRegDifApo,
            T000S2_A1065LiqDRegEspApo, T000S2_A1067DConPrereq, T000S2_n1067DConPrereq, T000S2_A1134LiqDOrdVis, T000S2_A1642DConLiqBasica, T000S2_n1642DConLiqBasica, T000S2_A1753DConConveCodigo, T000S2_A3CliCod, T000S2_A1EmpCod, T000S2_A6LegNumero,
            T000S2_A31LiqNro
            }
            , new Object[] {
            T000S3_A81LiqDSecuencial, T000S3_A394DConCodigo, T000S3_A393DConDescrip, T000S3_A397DLiqPeriodo, T000S3_A400DTLiqCod, T000S3_A464DTipoConCod, T000S3_A468DSubTipoConCod1, T000S3_n468DSubTipoConCod1, T000S3_A732DSubTipoConCod2, T000S3_n732DSubTipoConCod2,
            T000S3_A2149LiqDClasifAux, T000S3_A269LiqDCanti, T000S3_n269LiqDCanti, T000S3_A277LiqDValUni, T000S3_n277LiqDValUni, T000S3_A276LiqDImporte, T000S3_n276LiqDImporte, T000S3_A275LiqDImpCalcu, T000S3_n275LiqDImpCalcu, T000S3_A274LiqDFormula,
            T000S3_n274LiqDFormula, T000S3_A270LiqDErrorDesc, T000S3_n270LiqDErrorDesc, T000S3_A466DConVariable, T000S3_A471DConOrden, T000S3_A742DLiqPerAno, T000S3_A1051LiqDSIPAApo, T000S3_A1052LiqDSIPACont, T000S3_A1053LiqDINSSJyPApo, T000S3_A1054LiqDINSSJyPCont,
            T000S3_A1055LiqDObraSocApo, T000S3_A1056LiqDObraSocCont, T000S3_A1057LiqDFonSolRedApo, T000S3_A1058LiqDFonSolRedCont, T000S3_A1059LiqDRenateaApo, T000S3_A1060LiqDRenateaCont, T000S3_A1061LiqDAsigFamCont, T000S3_A1062LiqDFonNacEmpCont, T000S3_A1063LiqDLeyRieTrabCont, T000S3_A1064LiqDRegDifApo,
            T000S3_A1065LiqDRegEspApo, T000S3_A1067DConPrereq, T000S3_n1067DConPrereq, T000S3_A1134LiqDOrdVis, T000S3_A1642DConLiqBasica, T000S3_n1642DConLiqBasica, T000S3_A1753DConConveCodigo, T000S3_A3CliCod, T000S3_A1EmpCod, T000S3_A6LegNumero,
            T000S3_A31LiqNro
            }
            , new Object[] {
            T000S4_A3CliCod
            }
            , new Object[] {
            T000S5_A81LiqDSecuencial, T000S5_A394DConCodigo, T000S5_A393DConDescrip, T000S5_A397DLiqPeriodo, T000S5_A400DTLiqCod, T000S5_A464DTipoConCod, T000S5_A468DSubTipoConCod1, T000S5_n468DSubTipoConCod1, T000S5_A732DSubTipoConCod2, T000S5_n732DSubTipoConCod2,
            T000S5_A2149LiqDClasifAux, T000S5_A269LiqDCanti, T000S5_n269LiqDCanti, T000S5_A277LiqDValUni, T000S5_n277LiqDValUni, T000S5_A276LiqDImporte, T000S5_n276LiqDImporte, T000S5_A275LiqDImpCalcu, T000S5_n275LiqDImpCalcu, T000S5_A274LiqDFormula,
            T000S5_n274LiqDFormula, T000S5_A270LiqDErrorDesc, T000S5_n270LiqDErrorDesc, T000S5_A466DConVariable, T000S5_A471DConOrden, T000S5_A742DLiqPerAno, T000S5_A1051LiqDSIPAApo, T000S5_A1052LiqDSIPACont, T000S5_A1053LiqDINSSJyPApo, T000S5_A1054LiqDINSSJyPCont,
            T000S5_A1055LiqDObraSocApo, T000S5_A1056LiqDObraSocCont, T000S5_A1057LiqDFonSolRedApo, T000S5_A1058LiqDFonSolRedCont, T000S5_A1059LiqDRenateaApo, T000S5_A1060LiqDRenateaCont, T000S5_A1061LiqDAsigFamCont, T000S5_A1062LiqDFonNacEmpCont, T000S5_A1063LiqDLeyRieTrabCont, T000S5_A1064LiqDRegDifApo,
            T000S5_A1065LiqDRegEspApo, T000S5_A1067DConPrereq, T000S5_n1067DConPrereq, T000S5_A1134LiqDOrdVis, T000S5_A1642DConLiqBasica, T000S5_n1642DConLiqBasica, T000S5_A1753DConConveCodigo, T000S5_A3CliCod, T000S5_A1EmpCod, T000S5_A6LegNumero,
            T000S5_A31LiqNro
            }
            , new Object[] {
            T000S6_A3CliCod
            }
            , new Object[] {
            T000S7_A3CliCod, T000S7_A1EmpCod, T000S7_A31LiqNro, T000S7_A6LegNumero, T000S7_A81LiqDSecuencial
            }
            , new Object[] {
            T000S8_A3CliCod, T000S8_A1EmpCod, T000S8_A31LiqNro, T000S8_A6LegNumero, T000S8_A81LiqDSecuencial
            }
            , new Object[] {
            T000S9_A3CliCod, T000S9_A1EmpCod, T000S9_A31LiqNro, T000S9_A6LegNumero, T000S9_A81LiqDSecuencial
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000S13_A3CliCod, T000S13_A1EmpCod, T000S13_A31LiqNro, T000S13_A6LegNumero, T000S13_A81LiqDSecuencial
            }
            , new Object[] {
            T000S14_A3CliCod
            }
         }
      );
   }

   private byte Z1051LiqDSIPAApo ;
   private byte Z1052LiqDSIPACont ;
   private byte Z1053LiqDINSSJyPApo ;
   private byte Z1054LiqDINSSJyPCont ;
   private byte Z1055LiqDObraSocApo ;
   private byte Z1056LiqDObraSocCont ;
   private byte Z1057LiqDFonSolRedApo ;
   private byte Z1058LiqDFonSolRedCont ;
   private byte Z1059LiqDRenateaApo ;
   private byte Z1060LiqDRenateaCont ;
   private byte Z1061LiqDAsigFamCont ;
   private byte Z1062LiqDFonNacEmpCont ;
   private byte Z1063LiqDLeyRieTrabCont ;
   private byte Z1064LiqDRegDifApo ;
   private byte Z1065LiqDRegEspApo ;
   private byte Z1642DConLiqBasica ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1051LiqDSIPAApo ;
   private byte A1052LiqDSIPACont ;
   private byte A1053LiqDINSSJyPApo ;
   private byte A1054LiqDINSSJyPCont ;
   private byte A1055LiqDObraSocApo ;
   private byte A1056LiqDObraSocCont ;
   private byte A1057LiqDFonSolRedApo ;
   private byte A1058LiqDFonSolRedCont ;
   private byte A1059LiqDRenateaApo ;
   private byte A1060LiqDRenateaCont ;
   private byte A1061LiqDAsigFamCont ;
   private byte A1062LiqDFonNacEmpCont ;
   private byte A1063LiqDLeyRieTrabCont ;
   private byte A1064LiqDRegDifApo ;
   private byte A1065LiqDRegEspApo ;
   private byte A1642DConLiqBasica ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private byte ZZ1051LiqDSIPAApo ;
   private byte ZZ1052LiqDSIPACont ;
   private byte ZZ1053LiqDINSSJyPApo ;
   private byte ZZ1054LiqDINSSJyPCont ;
   private byte ZZ1055LiqDObraSocApo ;
   private byte ZZ1056LiqDObraSocCont ;
   private byte ZZ1057LiqDFonSolRedApo ;
   private byte ZZ1058LiqDFonSolRedCont ;
   private byte ZZ1059LiqDRenateaApo ;
   private byte ZZ1060LiqDRenateaCont ;
   private byte ZZ1061LiqDAsigFamCont ;
   private byte ZZ1062LiqDFonNacEmpCont ;
   private byte ZZ1063LiqDLeyRieTrabCont ;
   private byte ZZ1064LiqDRegDifApo ;
   private byte ZZ1065LiqDRegEspApo ;
   private byte ZZ1642DConLiqBasica ;
   private short Z1EmpCod ;
   private short Z742DLiqPerAno ;
   private short Z1134LiqDOrdVis ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A742DLiqPerAno ;
   private short A1134LiqDOrdVis ;
   private short RcdFound26 ;
   private short nIsDirty_26 ;
   private short ZZ1EmpCod ;
   private short ZZ742DLiqPerAno ;
   private short ZZ1134LiqDOrdVis ;
   private int Z3CliCod ;
   private int Z31LiqNro ;
   private int Z6LegNumero ;
   private int Z81LiqDSecuencial ;
   private int Z471DConOrden ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Enabled ;
   private int edtLiqNro_Enabled ;
   private int edtLegNumero_Enabled ;
   private int A81LiqDSecuencial ;
   private int edtLiqDSecuencial_Enabled ;
   private int edtDConCodigo_Enabled ;
   private int edtDConDescrip_Enabled ;
   private int edtDLiqPeriodo_Enabled ;
   private int edtDTLiqCod_Enabled ;
   private int edtDSubTipoConCod1_Enabled ;
   private int edtDSubTipoConCod2_Enabled ;
   private int edtLiqDClasifAux_Enabled ;
   private int edtLiqDCanti_Enabled ;
   private int edtLiqDValUni_Enabled ;
   private int edtLiqDImporte_Enabled ;
   private int edtLiqDImpCalcu_Enabled ;
   private int edtLiqDFormula_Enabled ;
   private int edtLiqDErrorDesc_Enabled ;
   private int A471DConOrden ;
   private int edtDConOrden_Enabled ;
   private int edtDLiqPerAno_Enabled ;
   private int edtLiqDSIPAApo_Enabled ;
   private int edtLiqDSIPACont_Enabled ;
   private int edtLiqDINSSJyPApo_Enabled ;
   private int edtLiqDINSSJyPCont_Enabled ;
   private int edtLiqDObraSocApo_Enabled ;
   private int edtLiqDObraSocCont_Enabled ;
   private int edtLiqDFonSolRedApo_Enabled ;
   private int edtLiqDFonSolRedCont_Enabled ;
   private int edtLiqDRenateaApo_Enabled ;
   private int edtLiqDRenateaCont_Enabled ;
   private int edtLiqDAsigFamCont_Enabled ;
   private int edtLiqDFonNacEmpCont_Enabled ;
   private int edtLiqDLeyRieTrabCont_Enabled ;
   private int edtLiqDRegDifApo_Enabled ;
   private int edtLiqDRegEspApo_Enabled ;
   private int edtLiqDOrdVis_Enabled ;
   private int edtDConLiqBasica_Enabled ;
   private int edtDConConveCodigo_Enabled ;
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
   private int ZZ81LiqDSecuencial ;
   private int ZZ471DConOrden ;
   private java.math.BigDecimal Z269LiqDCanti ;
   private java.math.BigDecimal Z277LiqDValUni ;
   private java.math.BigDecimal Z276LiqDImporte ;
   private java.math.BigDecimal Z275LiqDImpCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A277LiqDValUni ;
   private java.math.BigDecimal A276LiqDImporte ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private java.math.BigDecimal ZZ269LiqDCanti ;
   private java.math.BigDecimal ZZ277LiqDValUni ;
   private java.math.BigDecimal ZZ276LiqDImporte ;
   private java.math.BigDecimal ZZ275LiqDImpCalcu ;
   private String sPrefix ;
   private String Z394DConCodigo ;
   private String Z400DTLiqCod ;
   private String Z464DTipoConCod ;
   private String Z468DSubTipoConCod1 ;
   private String Z732DSubTipoConCod2 ;
   private String Z1067DConPrereq ;
   private String Z1753DConConveCodigo ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCliCod_Internalname ;
   private String A464DTipoConCod ;
   private String A1067DConPrereq ;
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
   private String edtLiqNro_Internalname ;
   private String edtLiqNro_Jsonclick ;
   private String edtLegNumero_Internalname ;
   private String edtLegNumero_Jsonclick ;
   private String edtLiqDSecuencial_Internalname ;
   private String edtLiqDSecuencial_Jsonclick ;
   private String edtDConCodigo_Internalname ;
   private String A394DConCodigo ;
   private String edtDConCodigo_Jsonclick ;
   private String edtDConDescrip_Internalname ;
   private String edtDLiqPeriodo_Internalname ;
   private String edtDLiqPeriodo_Jsonclick ;
   private String edtDTLiqCod_Internalname ;
   private String A400DTLiqCod ;
   private String edtDTLiqCod_Jsonclick ;
   private String edtDSubTipoConCod1_Internalname ;
   private String A468DSubTipoConCod1 ;
   private String edtDSubTipoConCod1_Jsonclick ;
   private String edtDSubTipoConCod2_Internalname ;
   private String A732DSubTipoConCod2 ;
   private String edtDSubTipoConCod2_Jsonclick ;
   private String edtLiqDClasifAux_Internalname ;
   private String edtLiqDClasifAux_Jsonclick ;
   private String edtLiqDCanti_Internalname ;
   private String edtLiqDCanti_Jsonclick ;
   private String edtLiqDValUni_Internalname ;
   private String edtLiqDValUni_Jsonclick ;
   private String edtLiqDImporte_Internalname ;
   private String edtLiqDImporte_Jsonclick ;
   private String edtLiqDImpCalcu_Internalname ;
   private String edtLiqDImpCalcu_Jsonclick ;
   private String edtLiqDFormula_Internalname ;
   private String edtLiqDErrorDesc_Internalname ;
   private String edtDConOrden_Internalname ;
   private String edtDConOrden_Jsonclick ;
   private String edtDLiqPerAno_Internalname ;
   private String edtDLiqPerAno_Jsonclick ;
   private String edtLiqDSIPAApo_Internalname ;
   private String edtLiqDSIPAApo_Jsonclick ;
   private String edtLiqDSIPACont_Internalname ;
   private String edtLiqDSIPACont_Jsonclick ;
   private String edtLiqDINSSJyPApo_Internalname ;
   private String edtLiqDINSSJyPApo_Jsonclick ;
   private String edtLiqDINSSJyPCont_Internalname ;
   private String edtLiqDINSSJyPCont_Jsonclick ;
   private String edtLiqDObraSocApo_Internalname ;
   private String edtLiqDObraSocApo_Jsonclick ;
   private String edtLiqDObraSocCont_Internalname ;
   private String edtLiqDObraSocCont_Jsonclick ;
   private String edtLiqDFonSolRedApo_Internalname ;
   private String edtLiqDFonSolRedApo_Jsonclick ;
   private String edtLiqDFonSolRedCont_Internalname ;
   private String edtLiqDFonSolRedCont_Jsonclick ;
   private String edtLiqDRenateaApo_Internalname ;
   private String edtLiqDRenateaApo_Jsonclick ;
   private String edtLiqDRenateaCont_Internalname ;
   private String edtLiqDRenateaCont_Jsonclick ;
   private String edtLiqDAsigFamCont_Internalname ;
   private String edtLiqDAsigFamCont_Jsonclick ;
   private String edtLiqDFonNacEmpCont_Internalname ;
   private String edtLiqDFonNacEmpCont_Jsonclick ;
   private String edtLiqDLeyRieTrabCont_Internalname ;
   private String edtLiqDLeyRieTrabCont_Jsonclick ;
   private String edtLiqDRegDifApo_Internalname ;
   private String edtLiqDRegDifApo_Jsonclick ;
   private String edtLiqDRegEspApo_Internalname ;
   private String edtLiqDRegEspApo_Jsonclick ;
   private String edtLiqDOrdVis_Internalname ;
   private String edtLiqDOrdVis_Jsonclick ;
   private String edtDConLiqBasica_Internalname ;
   private String edtDConLiqBasica_Jsonclick ;
   private String edtDConConveCodigo_Internalname ;
   private String A1753DConConveCodigo ;
   private String edtDConConveCodigo_Jsonclick ;
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
   private String sMode26 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ394DConCodigo ;
   private String ZZ400DTLiqCod ;
   private String ZZ464DTipoConCod ;
   private String ZZ468DSubTipoConCod1 ;
   private String ZZ732DSubTipoConCod2 ;
   private String ZZ1067DConPrereq ;
   private String ZZ1753DConConveCodigo ;
   private java.util.Date Z397DLiqPeriodo ;
   private java.util.Date A397DLiqPeriodo ;
   private java.util.Date ZZ397DLiqPeriodo ;
   private boolean Z466DConVariable ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A466DConVariable ;
   private boolean n1067DConPrereq ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n732DSubTipoConCod2 ;
   private boolean n269LiqDCanti ;
   private boolean n277LiqDValUni ;
   private boolean n276LiqDImporte ;
   private boolean n275LiqDImpCalcu ;
   private boolean n270LiqDErrorDesc ;
   private boolean n1642DConLiqBasica ;
   private boolean n274LiqDFormula ;
   private boolean Gx_longc ;
   private boolean ZZ466DConVariable ;
   private String A274LiqDFormula ;
   private String Z274LiqDFormula ;
   private String ZZ274LiqDFormula ;
   private String Z393DConDescrip ;
   private String Z2149LiqDClasifAux ;
   private String Z270LiqDErrorDesc ;
   private String A393DConDescrip ;
   private String A2149LiqDClasifAux ;
   private String A270LiqDErrorDesc ;
   private String ZZ393DConDescrip ;
   private String ZZ2149LiqDClasifAux ;
   private String ZZ270LiqDErrorDesc ;
   private HTMLChoice cmbDTipoConCod ;
   private ICheckbox chkDConVariable ;
   private HTMLChoice cmbDConPrereq ;
   private IDataStoreProvider pr_default ;
   private int[] T000S5_A81LiqDSecuencial ;
   private String[] T000S5_A394DConCodigo ;
   private String[] T000S5_A393DConDescrip ;
   private java.util.Date[] T000S5_A397DLiqPeriodo ;
   private String[] T000S5_A400DTLiqCod ;
   private String[] T000S5_A464DTipoConCod ;
   private String[] T000S5_A468DSubTipoConCod1 ;
   private boolean[] T000S5_n468DSubTipoConCod1 ;
   private String[] T000S5_A732DSubTipoConCod2 ;
   private boolean[] T000S5_n732DSubTipoConCod2 ;
   private String[] T000S5_A2149LiqDClasifAux ;
   private java.math.BigDecimal[] T000S5_A269LiqDCanti ;
   private boolean[] T000S5_n269LiqDCanti ;
   private java.math.BigDecimal[] T000S5_A277LiqDValUni ;
   private boolean[] T000S5_n277LiqDValUni ;
   private java.math.BigDecimal[] T000S5_A276LiqDImporte ;
   private boolean[] T000S5_n276LiqDImporte ;
   private java.math.BigDecimal[] T000S5_A275LiqDImpCalcu ;
   private boolean[] T000S5_n275LiqDImpCalcu ;
   private String[] T000S5_A274LiqDFormula ;
   private boolean[] T000S5_n274LiqDFormula ;
   private String[] T000S5_A270LiqDErrorDesc ;
   private boolean[] T000S5_n270LiqDErrorDesc ;
   private boolean[] T000S5_A466DConVariable ;
   private int[] T000S5_A471DConOrden ;
   private short[] T000S5_A742DLiqPerAno ;
   private byte[] T000S5_A1051LiqDSIPAApo ;
   private byte[] T000S5_A1052LiqDSIPACont ;
   private byte[] T000S5_A1053LiqDINSSJyPApo ;
   private byte[] T000S5_A1054LiqDINSSJyPCont ;
   private byte[] T000S5_A1055LiqDObraSocApo ;
   private byte[] T000S5_A1056LiqDObraSocCont ;
   private byte[] T000S5_A1057LiqDFonSolRedApo ;
   private byte[] T000S5_A1058LiqDFonSolRedCont ;
   private byte[] T000S5_A1059LiqDRenateaApo ;
   private byte[] T000S5_A1060LiqDRenateaCont ;
   private byte[] T000S5_A1061LiqDAsigFamCont ;
   private byte[] T000S5_A1062LiqDFonNacEmpCont ;
   private byte[] T000S5_A1063LiqDLeyRieTrabCont ;
   private byte[] T000S5_A1064LiqDRegDifApo ;
   private byte[] T000S5_A1065LiqDRegEspApo ;
   private String[] T000S5_A1067DConPrereq ;
   private boolean[] T000S5_n1067DConPrereq ;
   private short[] T000S5_A1134LiqDOrdVis ;
   private byte[] T000S5_A1642DConLiqBasica ;
   private boolean[] T000S5_n1642DConLiqBasica ;
   private String[] T000S5_A1753DConConveCodigo ;
   private int[] T000S5_A3CliCod ;
   private short[] T000S5_A1EmpCod ;
   private int[] T000S5_A6LegNumero ;
   private int[] T000S5_A31LiqNro ;
   private int[] T000S4_A3CliCod ;
   private int[] T000S6_A3CliCod ;
   private int[] T000S7_A3CliCod ;
   private short[] T000S7_A1EmpCod ;
   private int[] T000S7_A31LiqNro ;
   private int[] T000S7_A6LegNumero ;
   private int[] T000S7_A81LiqDSecuencial ;
   private int[] T000S3_A81LiqDSecuencial ;
   private String[] T000S3_A394DConCodigo ;
   private String[] T000S3_A393DConDescrip ;
   private java.util.Date[] T000S3_A397DLiqPeriodo ;
   private String[] T000S3_A400DTLiqCod ;
   private String[] T000S3_A464DTipoConCod ;
   private String[] T000S3_A468DSubTipoConCod1 ;
   private boolean[] T000S3_n468DSubTipoConCod1 ;
   private String[] T000S3_A732DSubTipoConCod2 ;
   private boolean[] T000S3_n732DSubTipoConCod2 ;
   private String[] T000S3_A2149LiqDClasifAux ;
   private java.math.BigDecimal[] T000S3_A269LiqDCanti ;
   private boolean[] T000S3_n269LiqDCanti ;
   private java.math.BigDecimal[] T000S3_A277LiqDValUni ;
   private boolean[] T000S3_n277LiqDValUni ;
   private java.math.BigDecimal[] T000S3_A276LiqDImporte ;
   private boolean[] T000S3_n276LiqDImporte ;
   private java.math.BigDecimal[] T000S3_A275LiqDImpCalcu ;
   private boolean[] T000S3_n275LiqDImpCalcu ;
   private String[] T000S3_A274LiqDFormula ;
   private boolean[] T000S3_n274LiqDFormula ;
   private String[] T000S3_A270LiqDErrorDesc ;
   private boolean[] T000S3_n270LiqDErrorDesc ;
   private boolean[] T000S3_A466DConVariable ;
   private int[] T000S3_A471DConOrden ;
   private short[] T000S3_A742DLiqPerAno ;
   private byte[] T000S3_A1051LiqDSIPAApo ;
   private byte[] T000S3_A1052LiqDSIPACont ;
   private byte[] T000S3_A1053LiqDINSSJyPApo ;
   private byte[] T000S3_A1054LiqDINSSJyPCont ;
   private byte[] T000S3_A1055LiqDObraSocApo ;
   private byte[] T000S3_A1056LiqDObraSocCont ;
   private byte[] T000S3_A1057LiqDFonSolRedApo ;
   private byte[] T000S3_A1058LiqDFonSolRedCont ;
   private byte[] T000S3_A1059LiqDRenateaApo ;
   private byte[] T000S3_A1060LiqDRenateaCont ;
   private byte[] T000S3_A1061LiqDAsigFamCont ;
   private byte[] T000S3_A1062LiqDFonNacEmpCont ;
   private byte[] T000S3_A1063LiqDLeyRieTrabCont ;
   private byte[] T000S3_A1064LiqDRegDifApo ;
   private byte[] T000S3_A1065LiqDRegEspApo ;
   private String[] T000S3_A1067DConPrereq ;
   private boolean[] T000S3_n1067DConPrereq ;
   private short[] T000S3_A1134LiqDOrdVis ;
   private byte[] T000S3_A1642DConLiqBasica ;
   private boolean[] T000S3_n1642DConLiqBasica ;
   private String[] T000S3_A1753DConConveCodigo ;
   private int[] T000S3_A3CliCod ;
   private short[] T000S3_A1EmpCod ;
   private int[] T000S3_A6LegNumero ;
   private int[] T000S3_A31LiqNro ;
   private int[] T000S8_A3CliCod ;
   private short[] T000S8_A1EmpCod ;
   private int[] T000S8_A31LiqNro ;
   private int[] T000S8_A6LegNumero ;
   private int[] T000S8_A81LiqDSecuencial ;
   private int[] T000S9_A3CliCod ;
   private short[] T000S9_A1EmpCod ;
   private int[] T000S9_A31LiqNro ;
   private int[] T000S9_A6LegNumero ;
   private int[] T000S9_A81LiqDSecuencial ;
   private int[] T000S2_A81LiqDSecuencial ;
   private String[] T000S2_A394DConCodigo ;
   private String[] T000S2_A393DConDescrip ;
   private java.util.Date[] T000S2_A397DLiqPeriodo ;
   private String[] T000S2_A400DTLiqCod ;
   private String[] T000S2_A464DTipoConCod ;
   private String[] T000S2_A468DSubTipoConCod1 ;
   private boolean[] T000S2_n468DSubTipoConCod1 ;
   private String[] T000S2_A732DSubTipoConCod2 ;
   private boolean[] T000S2_n732DSubTipoConCod2 ;
   private String[] T000S2_A2149LiqDClasifAux ;
   private java.math.BigDecimal[] T000S2_A269LiqDCanti ;
   private boolean[] T000S2_n269LiqDCanti ;
   private java.math.BigDecimal[] T000S2_A277LiqDValUni ;
   private boolean[] T000S2_n277LiqDValUni ;
   private java.math.BigDecimal[] T000S2_A276LiqDImporte ;
   private boolean[] T000S2_n276LiqDImporte ;
   private java.math.BigDecimal[] T000S2_A275LiqDImpCalcu ;
   private boolean[] T000S2_n275LiqDImpCalcu ;
   private String[] T000S2_A274LiqDFormula ;
   private boolean[] T000S2_n274LiqDFormula ;
   private String[] T000S2_A270LiqDErrorDesc ;
   private boolean[] T000S2_n270LiqDErrorDesc ;
   private boolean[] T000S2_A466DConVariable ;
   private int[] T000S2_A471DConOrden ;
   private short[] T000S2_A742DLiqPerAno ;
   private byte[] T000S2_A1051LiqDSIPAApo ;
   private byte[] T000S2_A1052LiqDSIPACont ;
   private byte[] T000S2_A1053LiqDINSSJyPApo ;
   private byte[] T000S2_A1054LiqDINSSJyPCont ;
   private byte[] T000S2_A1055LiqDObraSocApo ;
   private byte[] T000S2_A1056LiqDObraSocCont ;
   private byte[] T000S2_A1057LiqDFonSolRedApo ;
   private byte[] T000S2_A1058LiqDFonSolRedCont ;
   private byte[] T000S2_A1059LiqDRenateaApo ;
   private byte[] T000S2_A1060LiqDRenateaCont ;
   private byte[] T000S2_A1061LiqDAsigFamCont ;
   private byte[] T000S2_A1062LiqDFonNacEmpCont ;
   private byte[] T000S2_A1063LiqDLeyRieTrabCont ;
   private byte[] T000S2_A1064LiqDRegDifApo ;
   private byte[] T000S2_A1065LiqDRegEspApo ;
   private String[] T000S2_A1067DConPrereq ;
   private boolean[] T000S2_n1067DConPrereq ;
   private short[] T000S2_A1134LiqDOrdVis ;
   private byte[] T000S2_A1642DConLiqBasica ;
   private boolean[] T000S2_n1642DConLiqBasica ;
   private String[] T000S2_A1753DConConveCodigo ;
   private int[] T000S2_A3CliCod ;
   private short[] T000S2_A1EmpCod ;
   private int[] T000S2_A6LegNumero ;
   private int[] T000S2_A31LiqNro ;
   private int[] T000S13_A3CliCod ;
   private short[] T000S13_A1EmpCod ;
   private int[] T000S13_A31LiqNro ;
   private int[] T000S13_A6LegNumero ;
   private int[] T000S13_A81LiqDSecuencial ;
   private int[] T000S14_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class liquidacion_excel_1__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000S2", "SELECT LiqDSecuencial, DConCodigo, DConDescrip, DLiqPeriodo, DTLiqCod, DTipoConCod, DSubTipoConCod1, DSubTipoConCod2, LiqDClasifAux, LiqDCanti, LiqDValUni, LiqDImporte, LiqDImpCalcu, LiqDFormula, LiqDErrorDesc, DConVariable, DConOrden, DLiqPerAno, LiqDSIPAApo, LiqDSIPACont, LiqDINSSJyPApo, LiqDINSSJyPCont, LiqDObraSocApo, LiqDObraSocCont, LiqDFonSolRedApo, LiqDFonSolRedCont, LiqDRenateaApo, LiqDRenateaCont, LiqDAsigFamCont, LiqDFonNacEmpCont, LiqDLeyRieTrabCont, LiqDRegDifApo, LiqDRegEspApo, DConPrereq, LiqDOrdVis, DConLiqBasica, DConConveCodigo, CliCod, EmpCod, LegNumero, LiqNro FROM LiquidacionDetalle WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?  FOR UPDATE OF LiquidacionDetalle NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S3", "SELECT LiqDSecuencial, DConCodigo, DConDescrip, DLiqPeriodo, DTLiqCod, DTipoConCod, DSubTipoConCod1, DSubTipoConCod2, LiqDClasifAux, LiqDCanti, LiqDValUni, LiqDImporte, LiqDImpCalcu, LiqDFormula, LiqDErrorDesc, DConVariable, DConOrden, DLiqPerAno, LiqDSIPAApo, LiqDSIPACont, LiqDINSSJyPApo, LiqDINSSJyPCont, LiqDObraSocApo, LiqDObraSocCont, LiqDFonSolRedApo, LiqDFonSolRedCont, LiqDRenateaApo, LiqDRenateaCont, LiqDAsigFamCont, LiqDFonNacEmpCont, LiqDLeyRieTrabCont, LiqDRegDifApo, LiqDRegEspApo, DConPrereq, LiqDOrdVis, DConLiqBasica, DConConveCodigo, CliCod, EmpCod, LegNumero, LiqNro FROM LiquidacionDetalle WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S4", "SELECT CliCod FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S5", "SELECT TM1.LiqDSecuencial, TM1.DConCodigo, TM1.DConDescrip, TM1.DLiqPeriodo, TM1.DTLiqCod, TM1.DTipoConCod, TM1.DSubTipoConCod1, TM1.DSubTipoConCod2, TM1.LiqDClasifAux, TM1.LiqDCanti, TM1.LiqDValUni, TM1.LiqDImporte, TM1.LiqDImpCalcu, TM1.LiqDFormula, TM1.LiqDErrorDesc, TM1.DConVariable, TM1.DConOrden, TM1.DLiqPerAno, TM1.LiqDSIPAApo, TM1.LiqDSIPACont, TM1.LiqDINSSJyPApo, TM1.LiqDINSSJyPCont, TM1.LiqDObraSocApo, TM1.LiqDObraSocCont, TM1.LiqDFonSolRedApo, TM1.LiqDFonSolRedCont, TM1.LiqDRenateaApo, TM1.LiqDRenateaCont, TM1.LiqDAsigFamCont, TM1.LiqDFonNacEmpCont, TM1.LiqDLeyRieTrabCont, TM1.LiqDRegDifApo, TM1.LiqDRegEspApo, TM1.DConPrereq, TM1.LiqDOrdVis, TM1.DConLiqBasica, TM1.DConConveCodigo, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LiqNro FROM LiquidacionDetalle TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LiqNro = ? and TM1.LegNumero = ? and TM1.LiqDSecuencial = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LiqNro, TM1.LegNumero, TM1.LiqDSecuencial ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S6", "SELECT CliCod FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S7", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S8", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial FROM LiquidacionDetalle WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and LiqNro > ? or LiqNro = ? and EmpCod = ? and CliCod = ? and LegNumero > ? or LegNumero = ? and LiqNro = ? and EmpCod = ? and CliCod = ? and LiqDSecuencial > ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000S9", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial FROM LiquidacionDetalle WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and LiqNro < ? or LiqNro = ? and EmpCod = ? and CliCod = ? and LegNumero < ? or LegNumero = ? and LiqNro = ? and EmpCod = ? and CliCod = ? and LiqDSecuencial < ?) ORDER BY CliCod DESC, EmpCod DESC, LiqNro DESC, LegNumero DESC, LiqDSecuencial DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000S10", "SAVEPOINT gxupdate;INSERT INTO LiquidacionDetalle(LiqDSecuencial, DConCodigo, DConDescrip, DLiqPeriodo, DTLiqCod, DTipoConCod, DSubTipoConCod1, DSubTipoConCod2, LiqDClasifAux, LiqDCanti, LiqDValUni, LiqDImporte, LiqDImpCalcu, LiqDFormula, LiqDErrorDesc, DConVariable, DConOrden, DLiqPerAno, LiqDSIPAApo, LiqDSIPACont, LiqDINSSJyPApo, LiqDINSSJyPCont, LiqDObraSocApo, LiqDObraSocCont, LiqDFonSolRedApo, LiqDFonSolRedCont, LiqDRenateaApo, LiqDRenateaCont, LiqDAsigFamCont, LiqDFonNacEmpCont, LiqDLeyRieTrabCont, LiqDRegDifApo, LiqDRegEspApo, DConPrereq, LiqDOrdVis, DConLiqBasica, DConConveCodigo, CliCod, EmpCod, LegNumero, LiqNro, LiqDMostrar, LiqDForOrig, LiqDCalculado, LiqDFormulaHTML, LiqDOrdEjec, LiqDFormuAux, LiqDRecalculado, LiqDImpReCalcu, LiqdFormuRecalc, LiqDReFormulaHTML, LiqDVueltaRes, LiqDUniMed, LiqDLog, LiqDLogRecal, LiqDNovedad, LiqDAdelDescu, DAplIIGG, LiqDProrr, LiqDLote, LiqDPlus, LiqDSeg, DConCondicion, DAgeFecDes, DAgeFecHas) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, '', 0, '', 0, '', 0, 0, '', '', 0, '', '', '', FALSE, 0, 0, '', 0, 0, 0, '', DATE '00010101', DATE '00010101');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000S11", "SAVEPOINT gxupdate;UPDATE LiquidacionDetalle SET DConCodigo=?, DConDescrip=?, DLiqPeriodo=?, DTLiqCod=?, DTipoConCod=?, DSubTipoConCod1=?, DSubTipoConCod2=?, LiqDClasifAux=?, LiqDCanti=?, LiqDValUni=?, LiqDImporte=?, LiqDImpCalcu=?, LiqDFormula=?, LiqDErrorDesc=?, DConVariable=?, DConOrden=?, DLiqPerAno=?, LiqDSIPAApo=?, LiqDSIPACont=?, LiqDINSSJyPApo=?, LiqDINSSJyPCont=?, LiqDObraSocApo=?, LiqDObraSocCont=?, LiqDFonSolRedApo=?, LiqDFonSolRedCont=?, LiqDRenateaApo=?, LiqDRenateaCont=?, LiqDAsigFamCont=?, LiqDFonNacEmpCont=?, LiqDLeyRieTrabCont=?, LiqDRegDifApo=?, LiqDRegEspApo=?, DConPrereq=?, LiqDOrdVis=?, DConLiqBasica=?, DConConveCodigo=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000S12", "SAVEPOINT gxupdate;DELETE FROM LiquidacionDetalle  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000S13", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial FROM LiquidacionDetalle ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S14", "SELECT CliCod FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(12,2);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(13,2);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getLongVarchar(14);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(16);
               ((int[]) buf[24])[0] = rslt.getInt(17);
               ((short[]) buf[25])[0] = rslt.getShort(18);
               ((byte[]) buf[26])[0] = rslt.getByte(19);
               ((byte[]) buf[27])[0] = rslt.getByte(20);
               ((byte[]) buf[28])[0] = rslt.getByte(21);
               ((byte[]) buf[29])[0] = rslt.getByte(22);
               ((byte[]) buf[30])[0] = rslt.getByte(23);
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((byte[]) buf[32])[0] = rslt.getByte(25);
               ((byte[]) buf[33])[0] = rslt.getByte(26);
               ((byte[]) buf[34])[0] = rslt.getByte(27);
               ((byte[]) buf[35])[0] = rslt.getByte(28);
               ((byte[]) buf[36])[0] = rslt.getByte(29);
               ((byte[]) buf[37])[0] = rslt.getByte(30);
               ((byte[]) buf[38])[0] = rslt.getByte(31);
               ((byte[]) buf[39])[0] = rslt.getByte(32);
               ((byte[]) buf[40])[0] = rslt.getByte(33);
               ((String[]) buf[41])[0] = rslt.getString(34, 20);
               ((boolean[]) buf[42])[0] = rslt.wasNull();
               ((short[]) buf[43])[0] = rslt.getShort(35);
               ((byte[]) buf[44])[0] = rslt.getByte(36);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((String[]) buf[46])[0] = rslt.getString(37, 20);
               ((int[]) buf[47])[0] = rslt.getInt(38);
               ((short[]) buf[48])[0] = rslt.getShort(39);
               ((int[]) buf[49])[0] = rslt.getInt(40);
               ((int[]) buf[50])[0] = rslt.getInt(41);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(12,2);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(13,2);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getLongVarchar(14);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(16);
               ((int[]) buf[24])[0] = rslt.getInt(17);
               ((short[]) buf[25])[0] = rslt.getShort(18);
               ((byte[]) buf[26])[0] = rslt.getByte(19);
               ((byte[]) buf[27])[0] = rslt.getByte(20);
               ((byte[]) buf[28])[0] = rslt.getByte(21);
               ((byte[]) buf[29])[0] = rslt.getByte(22);
               ((byte[]) buf[30])[0] = rslt.getByte(23);
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((byte[]) buf[32])[0] = rslt.getByte(25);
               ((byte[]) buf[33])[0] = rslt.getByte(26);
               ((byte[]) buf[34])[0] = rslt.getByte(27);
               ((byte[]) buf[35])[0] = rslt.getByte(28);
               ((byte[]) buf[36])[0] = rslt.getByte(29);
               ((byte[]) buf[37])[0] = rslt.getByte(30);
               ((byte[]) buf[38])[0] = rslt.getByte(31);
               ((byte[]) buf[39])[0] = rslt.getByte(32);
               ((byte[]) buf[40])[0] = rslt.getByte(33);
               ((String[]) buf[41])[0] = rslt.getString(34, 20);
               ((boolean[]) buf[42])[0] = rslt.wasNull();
               ((short[]) buf[43])[0] = rslt.getShort(35);
               ((byte[]) buf[44])[0] = rslt.getByte(36);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((String[]) buf[46])[0] = rslt.getString(37, 20);
               ((int[]) buf[47])[0] = rslt.getInt(38);
               ((short[]) buf[48])[0] = rslt.getShort(39);
               ((int[]) buf[49])[0] = rslt.getInt(40);
               ((int[]) buf[50])[0] = rslt.getInt(41);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(12,2);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(13,2);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getLongVarchar(14);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(16);
               ((int[]) buf[24])[0] = rslt.getInt(17);
               ((short[]) buf[25])[0] = rslt.getShort(18);
               ((byte[]) buf[26])[0] = rslt.getByte(19);
               ((byte[]) buf[27])[0] = rslt.getByte(20);
               ((byte[]) buf[28])[0] = rslt.getByte(21);
               ((byte[]) buf[29])[0] = rslt.getByte(22);
               ((byte[]) buf[30])[0] = rslt.getByte(23);
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((byte[]) buf[32])[0] = rslt.getByte(25);
               ((byte[]) buf[33])[0] = rslt.getByte(26);
               ((byte[]) buf[34])[0] = rslt.getByte(27);
               ((byte[]) buf[35])[0] = rslt.getByte(28);
               ((byte[]) buf[36])[0] = rslt.getByte(29);
               ((byte[]) buf[37])[0] = rslt.getByte(30);
               ((byte[]) buf[38])[0] = rslt.getByte(31);
               ((byte[]) buf[39])[0] = rslt.getByte(32);
               ((byte[]) buf[40])[0] = rslt.getByte(33);
               ((String[]) buf[41])[0] = rslt.getString(34, 20);
               ((boolean[]) buf[42])[0] = rslt.wasNull();
               ((short[]) buf[43])[0] = rslt.getShort(35);
               ((byte[]) buf[44])[0] = rslt.getByte(36);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((String[]) buf[46])[0] = rslt.getString(37, 20);
               ((int[]) buf[47])[0] = rslt.getInt(38);
               ((short[]) buf[48])[0] = rslt.getShort(39);
               ((int[]) buf[49])[0] = rslt.getInt(40);
               ((int[]) buf[50])[0] = rslt.getInt(41);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
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
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 6 :
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
               return;
            case 7 :
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
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[7], 20);
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[9], 20);
               }
               stmt.setVarchar(9, (String)parms[10], 80, false);
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(10, (java.math.BigDecimal)parms[12], 2);
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(11, (java.math.BigDecimal)parms[14], 2);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(12, (java.math.BigDecimal)parms[16], 2);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(13, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(14, (String)parms[20]);
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(15, (String)parms[22], 400);
               }
               stmt.setBoolean(16, ((Boolean) parms[23]).booleanValue());
               stmt.setInt(17, ((Number) parms[24]).intValue());
               stmt.setShort(18, ((Number) parms[25]).shortValue());
               stmt.setByte(19, ((Number) parms[26]).byteValue());
               stmt.setByte(20, ((Number) parms[27]).byteValue());
               stmt.setByte(21, ((Number) parms[28]).byteValue());
               stmt.setByte(22, ((Number) parms[29]).byteValue());
               stmt.setByte(23, ((Number) parms[30]).byteValue());
               stmt.setByte(24, ((Number) parms[31]).byteValue());
               stmt.setByte(25, ((Number) parms[32]).byteValue());
               stmt.setByte(26, ((Number) parms[33]).byteValue());
               stmt.setByte(27, ((Number) parms[34]).byteValue());
               stmt.setByte(28, ((Number) parms[35]).byteValue());
               stmt.setByte(29, ((Number) parms[36]).byteValue());
               stmt.setByte(30, ((Number) parms[37]).byteValue());
               stmt.setByte(31, ((Number) parms[38]).byteValue());
               stmt.setByte(32, ((Number) parms[39]).byteValue());
               stmt.setByte(33, ((Number) parms[40]).byteValue());
               if ( ((Boolean) parms[41]).booleanValue() )
               {
                  stmt.setNull( 34 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(34, (String)parms[42], 20);
               }
               stmt.setShort(35, ((Number) parms[43]).shortValue());
               if ( ((Boolean) parms[44]).booleanValue() )
               {
                  stmt.setNull( 36 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(36, ((Number) parms[45]).byteValue());
               }
               stmt.setString(37, (String)parms[46], 20);
               stmt.setInt(38, ((Number) parms[47]).intValue());
               stmt.setShort(39, ((Number) parms[48]).shortValue());
               stmt.setInt(40, ((Number) parms[49]).intValue());
               stmt.setInt(41, ((Number) parms[50]).intValue());
               return;
            case 9 :
               stmt.setString(1, (String)parms[0], 10);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[6], 20);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[8], 20);
               }
               stmt.setVarchar(8, (String)parms[9], 80, false);
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(9, (java.math.BigDecimal)parms[11], 2);
               }
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(10, (java.math.BigDecimal)parms[13], 2);
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(11, (java.math.BigDecimal)parms[15], 2);
               }
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(12, (java.math.BigDecimal)parms[17], 2);
               }
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(13, (String)parms[19]);
               }
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(14, (String)parms[21], 400);
               }
               stmt.setBoolean(15, ((Boolean) parms[22]).booleanValue());
               stmt.setInt(16, ((Number) parms[23]).intValue());
               stmt.setShort(17, ((Number) parms[24]).shortValue());
               stmt.setByte(18, ((Number) parms[25]).byteValue());
               stmt.setByte(19, ((Number) parms[26]).byteValue());
               stmt.setByte(20, ((Number) parms[27]).byteValue());
               stmt.setByte(21, ((Number) parms[28]).byteValue());
               stmt.setByte(22, ((Number) parms[29]).byteValue());
               stmt.setByte(23, ((Number) parms[30]).byteValue());
               stmt.setByte(24, ((Number) parms[31]).byteValue());
               stmt.setByte(25, ((Number) parms[32]).byteValue());
               stmt.setByte(26, ((Number) parms[33]).byteValue());
               stmt.setByte(27, ((Number) parms[34]).byteValue());
               stmt.setByte(28, ((Number) parms[35]).byteValue());
               stmt.setByte(29, ((Number) parms[36]).byteValue());
               stmt.setByte(30, ((Number) parms[37]).byteValue());
               stmt.setByte(31, ((Number) parms[38]).byteValue());
               stmt.setByte(32, ((Number) parms[39]).byteValue());
               if ( ((Boolean) parms[40]).booleanValue() )
               {
                  stmt.setNull( 33 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(33, (String)parms[41], 20);
               }
               stmt.setShort(34, ((Number) parms[42]).shortValue());
               if ( ((Boolean) parms[43]).booleanValue() )
               {
                  stmt.setNull( 35 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(35, ((Number) parms[44]).byteValue());
               }
               stmt.setString(36, (String)parms[45], 20);
               stmt.setInt(37, ((Number) parms[46]).intValue());
               stmt.setShort(38, ((Number) parms[47]).shortValue());
               stmt.setInt(39, ((Number) parms[48]).intValue());
               stmt.setInt(40, ((Number) parms[49]).intValue());
               stmt.setInt(41, ((Number) parms[50]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

