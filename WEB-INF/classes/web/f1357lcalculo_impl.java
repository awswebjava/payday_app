package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class f1357lcalculo_impl extends GXDataArea
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
         gxload_6( A3CliCod, A1EmpCod, A784F1357CTipoPre, A777F1357CPer, A778F1357CSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_5") == 0 )
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
         gxload_5( A3CliCod, A1EmpCod, A6LegNumero) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "F1357 LCalculo", ""), (short)(0)) ;
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

   public f1357lcalculo_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public f1357lcalculo_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357lcalculo_impl.class ));
   }

   public f1357lcalculo_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbF1357CTipoPre = new HTMLChoice();
      cmbF1357LCAlicuota = new HTMLChoice();
      cmbF1357LCAliApli = new HTMLChoice();
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
      if ( cmbF1357LCAlicuota.getItemCount() > 0 )
      {
         A844F1357LCAlicuota = (byte)(GXutil.lval( cmbF1357LCAlicuota.getValidValue(GXutil.trim( GXutil.str( A844F1357LCAlicuota, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A844F1357LCAlicuota", GXutil.ltrimstr( DecimalUtil.doubleToDec(A844F1357LCAlicuota), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbF1357LCAlicuota.setValue( GXutil.trim( GXutil.str( A844F1357LCAlicuota, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbF1357LCAlicuota.getInternalname(), "Values", cmbF1357LCAlicuota.ToJavascriptSource(), true);
      }
      if ( cmbF1357LCAliApli.getItemCount() > 0 )
      {
         A845F1357LCAliApli = (byte)(GXutil.lval( cmbF1357LCAliApli.getValidValue(GXutil.trim( GXutil.str( A845F1357LCAliApli, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A845F1357LCAliApli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A845F1357LCAliApli), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbF1357LCAliApli.setValue( GXutil.trim( GXutil.str( A845F1357LCAliApli, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbF1357LCAliApli.getInternalname(), "Values", cmbF1357LCAliApli.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "F1357 LCalculo", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_F1357LCalculo.htm");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_F1357LCalculo.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357LCalculo.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_F1357LCalculo.htm");
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
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbF1357CTipoPre, cmbF1357CTipoPre.getInternalname(), GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0)), 1, cmbF1357CTipoPre.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbF1357CTipoPre.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", "", true, (byte)(0), "HLP_F1357LCalculo.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CPer_Internalname, GXutil.rtrim( A777F1357CPer), GXutil.rtrim( localUtil.format( A777F1357CPer, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CPer_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357CPer_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357LCalculo.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CSec_Internalname, GXutil.ltrim( localUtil.ntoc( A778F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357CSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A778F1357CSec), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A778F1357CSec), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357CSec_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357LCalculo.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegNumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LCTipReg_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LCTipReg_Internalname, httpContext.getMessage( "LCTip Reg", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LCTipReg_Internalname, GXutil.rtrim( A861F1357LCTipReg), GXutil.rtrim( localUtil.format( A861F1357LCTipReg, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LCTipReg_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LCTipReg_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbF1357LCAlicuota.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbF1357LCAlicuota.getInternalname(), httpContext.getMessage( "ALÍCUOTA – ART. 94 LEY GANANCIAS", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbF1357LCAlicuota, cmbF1357LCAlicuota.getInternalname(), GXutil.trim( GXutil.str( A844F1357LCAlicuota, 2, 0)), 1, cmbF1357LCAlicuota.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbF1357LCAlicuota.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", "", true, (byte)(0), "HLP_F1357LCalculo.htm");
      cmbF1357LCAlicuota.setValue( GXutil.trim( GXutil.str( A844F1357LCAlicuota, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbF1357LCAlicuota.getInternalname(), "Values", cmbF1357LCAlicuota.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbF1357LCAliApli.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbF1357LCAliApli.getInternalname(), httpContext.getMessage( "ALÍCUOTA APLICABLE (SIN INCLUIR HORAS EXTRAS)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbF1357LCAliApli, cmbF1357LCAliApli.getInternalname(), GXutil.trim( GXutil.str( A845F1357LCAliApli, 2, 0)), 1, cmbF1357LCAliApli.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbF1357LCAliApli.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", "", true, (byte)(0), "HLP_F1357LCalculo.htm");
      cmbF1357LCAliApli.setValue( GXutil.trim( GXutil.str( A845F1357LCAliApli, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbF1357LCAliApli.getInternalname(), "Values", cmbF1357LCAliApli.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LCDeterminado_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LCDeterminado_Internalname, httpContext.getMessage( "IMPUESTO DETERMINADO", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LCDeterminado_Internalname, GXutil.ltrim( localUtil.ntoc( A846F1357LCDeterminado, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LCDeterminado_Enabled!=0) ? localUtil.format( A846F1357LCDeterminado, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A846F1357LCDeterminado, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LCDeterminado_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LCDeterminado_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LCRetenido_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LCRetenido_Internalname, httpContext.getMessage( "IMPUESTO RETENIDO", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LCRetenido_Internalname, GXutil.ltrim( localUtil.ntoc( A847F1357LCRetenido, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LCRetenido_Enabled!=0) ? localUtil.format( A847F1357LCRetenido, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A847F1357LCRetenido, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,84);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LCRetenido_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LCRetenido_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LCPagosTotal_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LCPagosTotal_Internalname, httpContext.getMessage( "PAGOS A CUENTA (Total)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LCPagosTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A848F1357LCPagosTotal, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LCPagosTotal_Enabled!=0) ? localUtil.format( A848F1357LCPagosTotal, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A848F1357LCPagosTotal, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,89);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LCPagosTotal_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LCPagosTotal_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LCSaldo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LCSaldo_Internalname, httpContext.getMessage( "SALDO ", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LCSaldo_Internalname, GXutil.ltrim( localUtil.ntoc( A849F1357LCSaldo, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LCSaldo_Enabled!=0) ? localUtil.format( A849F1357LCSaldo, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A849F1357LCSaldo, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,94);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LCSaldo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LCSaldo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357CPagosCredDeb_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357CPagosCredDeb_Internalname, httpContext.getMessage( "PAGOS A CUENTA - Impuesto sobre créditos y débitos", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CPagosCredDeb_Internalname, GXutil.ltrim( localUtil.ntoc( A850F1357CPagosCredDeb, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357CPagosCredDeb_Enabled!=0) ? localUtil.format( A850F1357CPagosCredDeb, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A850F1357CPagosCredDeb, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,99);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CPagosCredDeb_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357CPagosCredDeb_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LCPagosAduanta_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LCPagosAduanta_Internalname, httpContext.getMessage( "PAGOS A CUENTA - Percepciones / Retenciones aduaneras", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LCPagosAduanta_Internalname, GXutil.ltrim( localUtil.ntoc( A851F1357LCPagosAduanta, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LCPagosAduanta_Enabled!=0) ? localUtil.format( A851F1357LCPagosAduanta, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A851F1357LCPagosAduanta, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,104);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LCPagosAduanta_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LCPagosAduanta_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LCPagosTurismo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LCPagosTurismo_Internalname, httpContext.getMessage( "PAGOS A CUENTA - - Resolución General (AFIP) 3819/2015 - Cancelaciones en Efectivo - Servicios en el exterior por medio de agencias de viajes y turismo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LCPagosTurismo_Internalname, GXutil.ltrim( localUtil.ntoc( A852F1357LCPagosTurismo, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LCPagosTurismo_Enabled!=0) ? localUtil.format( A852F1357LCPagosTurismo, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A852F1357LCPagosTurismo, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,109);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LCPagosTurismo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LCPagosTurismo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LCPagosBono_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LCPagosBono_Internalname, httpContext.getMessage( "PAGOS A CUENTA - BONO - LEY 27.424", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 114,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LCPagosBono_Internalname, GXutil.ltrim( localUtil.ntoc( A853F1357LCPagosBono, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LCPagosBono_Enabled!=0) ? localUtil.format( A853F1357LCPagosBono, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A853F1357LCPagosBono, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,114);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LCPagosBono_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LCPagosBono_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LCPagosIncA_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LCPagosIncA_Internalname, httpContext.getMessage( "PAGO A CUENTA - LEY 27.541 Art. 35 inciso a)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 119,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LCPagosIncA_Internalname, GXutil.ltrim( localUtil.ntoc( A854F1357LCPagosIncA, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LCPagosIncA_Enabled!=0) ? localUtil.format( A854F1357LCPagosIncA, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A854F1357LCPagosIncA, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,119);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LCPagosIncA_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LCPagosIncA_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LCPagosIncB_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LCPagosIncB_Internalname, httpContext.getMessage( "PAGO A CUENTA - LEY 27.541 Art. 35 inciso b)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 124,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LCPagosIncB_Internalname, GXutil.ltrim( localUtil.ntoc( A855F1357LCPagosIncB, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LCPagosIncB_Enabled!=0) ? localUtil.format( A855F1357LCPagosIncB, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A855F1357LCPagosIncB, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,124);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LCPagosIncB_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LCPagosIncB_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LCPagosIncC_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LCPagosIncC_Internalname, httpContext.getMessage( "PAGO A CUENTA - LEY 27.541 Art. 35 inciso c)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 129,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LCPagosIncC_Internalname, GXutil.ltrim( localUtil.ntoc( A856F1357LCPagosIncC, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LCPagosIncC_Enabled!=0) ? localUtil.format( A856F1357LCPagosIncC, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A856F1357LCPagosIncC, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,129);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LCPagosIncC_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LCPagosIncC_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LCPagosIncD_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LCPagosIncD_Internalname, httpContext.getMessage( "PAGO A CUENTA - LEY 27.541 Art. 35 inciso d)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 134,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LCPagosIncD_Internalname, GXutil.ltrim( localUtil.ntoc( A857F1357LCPagosIncD, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LCPagosIncD_Enabled!=0) ? localUtil.format( A857F1357LCPagosIncD, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A857F1357LCPagosIncD, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,134);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LCPagosIncD_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LCPagosIncD_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LCPagosIncE_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LCPagosIncE_Internalname, httpContext.getMessage( "PAGO A CUENTA - LEY 27.541 Art. 35 inciso e)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 139,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LCPagosIncE_Internalname, GXutil.ltrim( localUtil.ntoc( A858F1357LCPagosIncE, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LCPagosIncE_Enabled!=0) ? localUtil.format( A858F1357LCPagosIncE, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A858F1357LCPagosIncE, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,139);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LCPagosIncE_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LCPagosIncE_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LCCredDebMOv_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LCCredDebMOv_Internalname, httpContext.getMessage( "PAGOS A CUENTA - Impuesto sobre créditos y débitos - sobre movimientos de fondos propios o de terceros", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 144,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LCCredDebMOv_Internalname, GXutil.ltrim( localUtil.ntoc( A859F1357LCCredDebMOv, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LCCredDebMOv_Enabled!=0) ? localUtil.format( A859F1357LCCredDebMOv, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A859F1357LCCredDebMOv, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,144);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LCCredDebMOv_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LCCredDebMOv_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LCViajeExterior_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LCViajeExterior_Internalname, httpContext.getMessage( "PAGOS A CUENTA - Resolución General (AFIP) 3819/2015 - Cancelaciones en Efectivo - Servicios de transporte terrestre, aéreo y por vía acuática de pasajeros con destino fuera del país", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 149,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LCViajeExterior_Internalname, GXutil.ltrim( localUtil.ntoc( A860F1357LCViajeExterior, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LCViajeExterior_Enabled!=0) ? localUtil.format( A860F1357LCViajeExterior, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A860F1357LCViajeExterior, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,149);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LCViajeExterior_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LCViajeExterior_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LC_GNSI_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LC_GNSI_Internalname, httpContext.getMessage( "GNSI", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 154,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LC_GNSI_Internalname, GXutil.ltrim( localUtil.ntoc( A866F1357LC_GNSI, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LC_GNSI_Enabled!=0) ? localUtil.format( A866F1357LC_GNSI, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A866F1357LC_GNSI, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,154);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LC_GNSI_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LC_GNSI_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LC_GanNeta_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LC_GanNeta_Internalname, httpContext.getMessage( "GANANCIA NETA PARA TOPES", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 159,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LC_GanNeta_Internalname, GXutil.ltrim( localUtil.ntoc( A867F1357LC_GanNeta, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LC_GanNeta_Enabled!=0) ? localUtil.format( A867F1357LC_GanNeta, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A867F1357LC_GanNeta, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,159);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LC_GanNeta_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LC_GanNeta_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LC_Cuota_fija_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LC_Cuota_fija_Internalname, httpContext.getMessage( "CUOTA FIJA", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 164,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LC_Cuota_fija_Internalname, GXutil.ltrim( localUtil.ntoc( A871F1357LC_Cuota_fija, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LC_Cuota_fija_Enabled!=0) ? localUtil.format( A871F1357LC_Cuota_fija, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A871F1357LC_Cuota_fija, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,164);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LC_Cuota_fija_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LC_Cuota_fija_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LC_MesesTributados_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LC_MesesTributados_Internalname, httpContext.getMessage( "CANTIDAD DE MESES TRIBUTADOS", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 169,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LC_MesesTributados_Internalname, GXutil.ltrim( localUtil.ntoc( A872F1357LC_MesesTributados, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LC_MesesTributados_Enabled!=0) ? localUtil.format( A872F1357LC_MesesTributados, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A872F1357LC_MesesTributados, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,169);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LC_MesesTributados_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LC_MesesTributados_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LC_Tope_anterior_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LC_Tope_anterior_Internalname, httpContext.getMessage( "ESCALA TOPE ANTERIOR", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 174,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LC_Tope_anterior_Internalname, GXutil.ltrim( localUtil.ntoc( A873F1357LC_Tope_anterior, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LC_Tope_anterior_Enabled!=0) ? localUtil.format( A873F1357LC_Tope_anterior, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A873F1357LC_Tope_anterior, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,174);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LC_Tope_anterior_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LC_Tope_anterior_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LC_DescuSobreGrav_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LC_DescuSobreGrav_Internalname, httpContext.getMessage( "sobre gravados", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 179,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LC_DescuSobreGrav_Internalname, GXutil.ltrim( localUtil.ntoc( A927F1357LC_DescuSobreGrav, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LC_DescuSobreGrav_Enabled!=0) ? localUtil.format( A927F1357LC_DescuSobreGrav, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A927F1357LC_DescuSobreGrav, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,179);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LC_DescuSobreGrav_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LC_DescuSobreGrav_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LC_AnticiposDeSac_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LC_AnticiposDeSac_Internalname, httpContext.getMessage( "Anticipos de SAC", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 184,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LC_AnticiposDeSac_Internalname, GXutil.ltrim( localUtil.ntoc( A1082F1357LC_AnticiposDeSac, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LC_AnticiposDeSac_Enabled!=0) ? localUtil.format( A1082F1357LC_AnticiposDeSac, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1082F1357LC_AnticiposDeSac, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,184);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LC_AnticiposDeSac_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LC_AnticiposDeSac_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LCalculo.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 189,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 191,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LCalculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 193,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LCalculo.htm");
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
         Z861F1357LCTipReg = httpContext.cgiGet( "Z861F1357LCTipReg") ;
         Z844F1357LCAlicuota = (byte)(localUtil.ctol( httpContext.cgiGet( "Z844F1357LCAlicuota"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z845F1357LCAliApli = (byte)(localUtil.ctol( httpContext.cgiGet( "Z845F1357LCAliApli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z846F1357LCDeterminado = localUtil.ctond( httpContext.cgiGet( "Z846F1357LCDeterminado")) ;
         Z847F1357LCRetenido = localUtil.ctond( httpContext.cgiGet( "Z847F1357LCRetenido")) ;
         Z848F1357LCPagosTotal = localUtil.ctond( httpContext.cgiGet( "Z848F1357LCPagosTotal")) ;
         Z849F1357LCSaldo = localUtil.ctond( httpContext.cgiGet( "Z849F1357LCSaldo")) ;
         Z850F1357CPagosCredDeb = localUtil.ctond( httpContext.cgiGet( "Z850F1357CPagosCredDeb")) ;
         Z851F1357LCPagosAduanta = localUtil.ctond( httpContext.cgiGet( "Z851F1357LCPagosAduanta")) ;
         Z852F1357LCPagosTurismo = localUtil.ctond( httpContext.cgiGet( "Z852F1357LCPagosTurismo")) ;
         Z853F1357LCPagosBono = localUtil.ctond( httpContext.cgiGet( "Z853F1357LCPagosBono")) ;
         Z854F1357LCPagosIncA = localUtil.ctond( httpContext.cgiGet( "Z854F1357LCPagosIncA")) ;
         Z855F1357LCPagosIncB = localUtil.ctond( httpContext.cgiGet( "Z855F1357LCPagosIncB")) ;
         Z856F1357LCPagosIncC = localUtil.ctond( httpContext.cgiGet( "Z856F1357LCPagosIncC")) ;
         Z857F1357LCPagosIncD = localUtil.ctond( httpContext.cgiGet( "Z857F1357LCPagosIncD")) ;
         Z858F1357LCPagosIncE = localUtil.ctond( httpContext.cgiGet( "Z858F1357LCPagosIncE")) ;
         Z859F1357LCCredDebMOv = localUtil.ctond( httpContext.cgiGet( "Z859F1357LCCredDebMOv")) ;
         Z860F1357LCViajeExterior = localUtil.ctond( httpContext.cgiGet( "Z860F1357LCViajeExterior")) ;
         Z866F1357LC_GNSI = localUtil.ctond( httpContext.cgiGet( "Z866F1357LC_GNSI")) ;
         Z867F1357LC_GanNeta = localUtil.ctond( httpContext.cgiGet( "Z867F1357LC_GanNeta")) ;
         Z871F1357LC_Cuota_fija = localUtil.ctond( httpContext.cgiGet( "Z871F1357LC_Cuota_fija")) ;
         Z872F1357LC_MesesTributados = localUtil.ctond( httpContext.cgiGet( "Z872F1357LC_MesesTributados")) ;
         Z873F1357LC_Tope_anterior = localUtil.ctond( httpContext.cgiGet( "Z873F1357LC_Tope_anterior")) ;
         Z927F1357LC_DescuSobreGrav = localUtil.ctond( httpContext.cgiGet( "Z927F1357LC_DescuSobreGrav")) ;
         Z1082F1357LC_AnticiposDeSac = localUtil.ctond( httpContext.cgiGet( "Z1082F1357LC_AnticiposDeSac")) ;
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
         A861F1357LCTipReg = httpContext.cgiGet( edtF1357LCTipReg_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A861F1357LCTipReg", A861F1357LCTipReg);
         cmbF1357LCAlicuota.setValue( httpContext.cgiGet( cmbF1357LCAlicuota.getInternalname()) );
         A844F1357LCAlicuota = (byte)(GXutil.lval( httpContext.cgiGet( cmbF1357LCAlicuota.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A844F1357LCAlicuota", GXutil.ltrimstr( DecimalUtil.doubleToDec(A844F1357LCAlicuota), 2, 0));
         cmbF1357LCAliApli.setValue( httpContext.cgiGet( cmbF1357LCAliApli.getInternalname()) );
         A845F1357LCAliApli = (byte)(GXutil.lval( httpContext.cgiGet( cmbF1357LCAliApli.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A845F1357LCAliApli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A845F1357LCAliApli), 2, 0));
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCDeterminado_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCDeterminado_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LCDETERMINADO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LCDeterminado_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A846F1357LCDeterminado = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A846F1357LCDeterminado", GXutil.ltrimstr( A846F1357LCDeterminado, 16, 2));
         }
         else
         {
            A846F1357LCDeterminado = localUtil.ctond( httpContext.cgiGet( edtF1357LCDeterminado_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A846F1357LCDeterminado", GXutil.ltrimstr( A846F1357LCDeterminado, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCRetenido_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCRetenido_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LCRETENIDO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LCRetenido_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A847F1357LCRetenido = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A847F1357LCRetenido", GXutil.ltrimstr( A847F1357LCRetenido, 16, 2));
         }
         else
         {
            A847F1357LCRetenido = localUtil.ctond( httpContext.cgiGet( edtF1357LCRetenido_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A847F1357LCRetenido", GXutil.ltrimstr( A847F1357LCRetenido, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosTotal_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosTotal_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LCPAGOSTOTAL");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LCPagosTotal_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A848F1357LCPagosTotal = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A848F1357LCPagosTotal", GXutil.ltrimstr( A848F1357LCPagosTotal, 16, 2));
         }
         else
         {
            A848F1357LCPagosTotal = localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosTotal_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A848F1357LCPagosTotal", GXutil.ltrimstr( A848F1357LCPagosTotal, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCSaldo_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCSaldo_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LCSALDO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LCSaldo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A849F1357LCSaldo = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A849F1357LCSaldo", GXutil.ltrimstr( A849F1357LCSaldo, 16, 2));
         }
         else
         {
            A849F1357LCSaldo = localUtil.ctond( httpContext.cgiGet( edtF1357LCSaldo_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A849F1357LCSaldo", GXutil.ltrimstr( A849F1357LCSaldo, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357CPagosCredDeb_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357CPagosCredDeb_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357CPAGOSCREDDEB");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357CPagosCredDeb_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A850F1357CPagosCredDeb = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A850F1357CPagosCredDeb", GXutil.ltrimstr( A850F1357CPagosCredDeb, 16, 2));
         }
         else
         {
            A850F1357CPagosCredDeb = localUtil.ctond( httpContext.cgiGet( edtF1357CPagosCredDeb_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A850F1357CPagosCredDeb", GXutil.ltrimstr( A850F1357CPagosCredDeb, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosAduanta_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosAduanta_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LCPAGOSADUANTA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LCPagosAduanta_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A851F1357LCPagosAduanta = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A851F1357LCPagosAduanta", GXutil.ltrimstr( A851F1357LCPagosAduanta, 16, 2));
         }
         else
         {
            A851F1357LCPagosAduanta = localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosAduanta_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A851F1357LCPagosAduanta", GXutil.ltrimstr( A851F1357LCPagosAduanta, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosTurismo_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosTurismo_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LCPAGOSTURISMO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LCPagosTurismo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A852F1357LCPagosTurismo = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A852F1357LCPagosTurismo", GXutil.ltrimstr( A852F1357LCPagosTurismo, 16, 2));
         }
         else
         {
            A852F1357LCPagosTurismo = localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosTurismo_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A852F1357LCPagosTurismo", GXutil.ltrimstr( A852F1357LCPagosTurismo, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosBono_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosBono_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LCPAGOSBONO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LCPagosBono_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A853F1357LCPagosBono = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A853F1357LCPagosBono", GXutil.ltrimstr( A853F1357LCPagosBono, 16, 2));
         }
         else
         {
            A853F1357LCPagosBono = localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosBono_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A853F1357LCPagosBono", GXutil.ltrimstr( A853F1357LCPagosBono, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosIncA_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosIncA_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LCPAGOSINCA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LCPagosIncA_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A854F1357LCPagosIncA = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A854F1357LCPagosIncA", GXutil.ltrimstr( A854F1357LCPagosIncA, 16, 2));
         }
         else
         {
            A854F1357LCPagosIncA = localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosIncA_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A854F1357LCPagosIncA", GXutil.ltrimstr( A854F1357LCPagosIncA, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosIncB_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosIncB_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LCPAGOSINCB");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LCPagosIncB_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A855F1357LCPagosIncB = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A855F1357LCPagosIncB", GXutil.ltrimstr( A855F1357LCPagosIncB, 16, 2));
         }
         else
         {
            A855F1357LCPagosIncB = localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosIncB_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A855F1357LCPagosIncB", GXutil.ltrimstr( A855F1357LCPagosIncB, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosIncC_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosIncC_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LCPAGOSINCC");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LCPagosIncC_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A856F1357LCPagosIncC = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A856F1357LCPagosIncC", GXutil.ltrimstr( A856F1357LCPagosIncC, 16, 2));
         }
         else
         {
            A856F1357LCPagosIncC = localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosIncC_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A856F1357LCPagosIncC", GXutil.ltrimstr( A856F1357LCPagosIncC, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosIncD_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosIncD_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LCPAGOSINCD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LCPagosIncD_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A857F1357LCPagosIncD = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A857F1357LCPagosIncD", GXutil.ltrimstr( A857F1357LCPagosIncD, 16, 2));
         }
         else
         {
            A857F1357LCPagosIncD = localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosIncD_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A857F1357LCPagosIncD", GXutil.ltrimstr( A857F1357LCPagosIncD, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosIncE_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosIncE_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LCPAGOSINCE");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LCPagosIncE_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A858F1357LCPagosIncE = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A858F1357LCPagosIncE", GXutil.ltrimstr( A858F1357LCPagosIncE, 16, 2));
         }
         else
         {
            A858F1357LCPagosIncE = localUtil.ctond( httpContext.cgiGet( edtF1357LCPagosIncE_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A858F1357LCPagosIncE", GXutil.ltrimstr( A858F1357LCPagosIncE, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCCredDebMOv_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCCredDebMOv_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LCCREDDEBMOV");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LCCredDebMOv_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A859F1357LCCredDebMOv = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A859F1357LCCredDebMOv", GXutil.ltrimstr( A859F1357LCCredDebMOv, 16, 2));
         }
         else
         {
            A859F1357LCCredDebMOv = localUtil.ctond( httpContext.cgiGet( edtF1357LCCredDebMOv_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A859F1357LCCredDebMOv", GXutil.ltrimstr( A859F1357LCCredDebMOv, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCViajeExterior_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LCViajeExterior_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LCVIAJEEXTERIOR");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LCViajeExterior_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A860F1357LCViajeExterior = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A860F1357LCViajeExterior", GXutil.ltrimstr( A860F1357LCViajeExterior, 16, 2));
         }
         else
         {
            A860F1357LCViajeExterior = localUtil.ctond( httpContext.cgiGet( edtF1357LCViajeExterior_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A860F1357LCViajeExterior", GXutil.ltrimstr( A860F1357LCViajeExterior, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LC_GNSI_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LC_GNSI_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LC_GNSI");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LC_GNSI_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A866F1357LC_GNSI = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A866F1357LC_GNSI", GXutil.ltrimstr( A866F1357LC_GNSI, 16, 2));
         }
         else
         {
            A866F1357LC_GNSI = localUtil.ctond( httpContext.cgiGet( edtF1357LC_GNSI_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A866F1357LC_GNSI", GXutil.ltrimstr( A866F1357LC_GNSI, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LC_GanNeta_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LC_GanNeta_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LC_GANNETA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LC_GanNeta_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A867F1357LC_GanNeta = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A867F1357LC_GanNeta", GXutil.ltrimstr( A867F1357LC_GanNeta, 16, 2));
         }
         else
         {
            A867F1357LC_GanNeta = localUtil.ctond( httpContext.cgiGet( edtF1357LC_GanNeta_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A867F1357LC_GanNeta", GXutil.ltrimstr( A867F1357LC_GanNeta, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LC_Cuota_fija_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LC_Cuota_fija_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LC_CUOTA_FIJA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LC_Cuota_fija_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A871F1357LC_Cuota_fija = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A871F1357LC_Cuota_fija", GXutil.ltrimstr( A871F1357LC_Cuota_fija, 16, 2));
         }
         else
         {
            A871F1357LC_Cuota_fija = localUtil.ctond( httpContext.cgiGet( edtF1357LC_Cuota_fija_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A871F1357LC_Cuota_fija", GXutil.ltrimstr( A871F1357LC_Cuota_fija, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LC_MesesTributados_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LC_MesesTributados_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LC_MESESTRIBUTADOS");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LC_MesesTributados_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A872F1357LC_MesesTributados = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A872F1357LC_MesesTributados", GXutil.ltrimstr( A872F1357LC_MesesTributados, 16, 2));
         }
         else
         {
            A872F1357LC_MesesTributados = localUtil.ctond( httpContext.cgiGet( edtF1357LC_MesesTributados_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A872F1357LC_MesesTributados", GXutil.ltrimstr( A872F1357LC_MesesTributados, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LC_Tope_anterior_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LC_Tope_anterior_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LC_TOPE_ANTERIOR");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LC_Tope_anterior_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A873F1357LC_Tope_anterior = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A873F1357LC_Tope_anterior", GXutil.ltrimstr( A873F1357LC_Tope_anterior, 16, 2));
         }
         else
         {
            A873F1357LC_Tope_anterior = localUtil.ctond( httpContext.cgiGet( edtF1357LC_Tope_anterior_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A873F1357LC_Tope_anterior", GXutil.ltrimstr( A873F1357LC_Tope_anterior, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LC_DescuSobreGrav_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LC_DescuSobreGrav_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LC_DESCUSOBREGRAV");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LC_DescuSobreGrav_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A927F1357LC_DescuSobreGrav = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A927F1357LC_DescuSobreGrav", GXutil.ltrimstr( A927F1357LC_DescuSobreGrav, 16, 2));
         }
         else
         {
            A927F1357LC_DescuSobreGrav = localUtil.ctond( httpContext.cgiGet( edtF1357LC_DescuSobreGrav_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A927F1357LC_DescuSobreGrav", GXutil.ltrimstr( A927F1357LC_DescuSobreGrav, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LC_AnticiposDeSac_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LC_AnticiposDeSac_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LC_ANTICIPOSDESAC");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LC_AnticiposDeSac_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1082F1357LC_AnticiposDeSac = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A1082F1357LC_AnticiposDeSac", GXutil.ltrimstr( A1082F1357LC_AnticiposDeSac, 16, 2));
         }
         else
         {
            A1082F1357LC_AnticiposDeSac = localUtil.ctond( httpContext.cgiGet( edtF1357LC_AnticiposDeSac_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1082F1357LC_AnticiposDeSac", GXutil.ltrimstr( A1082F1357LC_AnticiposDeSac, 16, 2));
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
            A784F1357CTipoPre = (byte)(GXutil.lval( httpContext.GetPar( "F1357CTipoPre"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
            A777F1357CPer = httpContext.GetPar( "F1357CPer") ;
            httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
            A778F1357CSec = (byte)(GXutil.lval( httpContext.GetPar( "F1357CSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
            A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A861F1357LCTipReg = httpContext.GetPar( "F1357LCTipReg") ;
            httpContext.ajax_rsp_assign_attri("", false, "A861F1357LCTipReg", A861F1357LCTipReg);
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
            initAll2K93( ) ;
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
      disableAttributes2K93( ) ;
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

   public void resetCaption2K0( )
   {
   }

   public void zm2K93( int GX_JID )
   {
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z844F1357LCAlicuota = T002K3_A844F1357LCAlicuota[0] ;
            Z845F1357LCAliApli = T002K3_A845F1357LCAliApli[0] ;
            Z846F1357LCDeterminado = T002K3_A846F1357LCDeterminado[0] ;
            Z847F1357LCRetenido = T002K3_A847F1357LCRetenido[0] ;
            Z848F1357LCPagosTotal = T002K3_A848F1357LCPagosTotal[0] ;
            Z849F1357LCSaldo = T002K3_A849F1357LCSaldo[0] ;
            Z850F1357CPagosCredDeb = T002K3_A850F1357CPagosCredDeb[0] ;
            Z851F1357LCPagosAduanta = T002K3_A851F1357LCPagosAduanta[0] ;
            Z852F1357LCPagosTurismo = T002K3_A852F1357LCPagosTurismo[0] ;
            Z853F1357LCPagosBono = T002K3_A853F1357LCPagosBono[0] ;
            Z854F1357LCPagosIncA = T002K3_A854F1357LCPagosIncA[0] ;
            Z855F1357LCPagosIncB = T002K3_A855F1357LCPagosIncB[0] ;
            Z856F1357LCPagosIncC = T002K3_A856F1357LCPagosIncC[0] ;
            Z857F1357LCPagosIncD = T002K3_A857F1357LCPagosIncD[0] ;
            Z858F1357LCPagosIncE = T002K3_A858F1357LCPagosIncE[0] ;
            Z859F1357LCCredDebMOv = T002K3_A859F1357LCCredDebMOv[0] ;
            Z860F1357LCViajeExterior = T002K3_A860F1357LCViajeExterior[0] ;
            Z866F1357LC_GNSI = T002K3_A866F1357LC_GNSI[0] ;
            Z867F1357LC_GanNeta = T002K3_A867F1357LC_GanNeta[0] ;
            Z871F1357LC_Cuota_fija = T002K3_A871F1357LC_Cuota_fija[0] ;
            Z872F1357LC_MesesTributados = T002K3_A872F1357LC_MesesTributados[0] ;
            Z873F1357LC_Tope_anterior = T002K3_A873F1357LC_Tope_anterior[0] ;
            Z927F1357LC_DescuSobreGrav = T002K3_A927F1357LC_DescuSobreGrav[0] ;
            Z1082F1357LC_AnticiposDeSac = T002K3_A1082F1357LC_AnticiposDeSac[0] ;
         }
         else
         {
            Z844F1357LCAlicuota = A844F1357LCAlicuota ;
            Z845F1357LCAliApli = A845F1357LCAliApli ;
            Z846F1357LCDeterminado = A846F1357LCDeterminado ;
            Z847F1357LCRetenido = A847F1357LCRetenido ;
            Z848F1357LCPagosTotal = A848F1357LCPagosTotal ;
            Z849F1357LCSaldo = A849F1357LCSaldo ;
            Z850F1357CPagosCredDeb = A850F1357CPagosCredDeb ;
            Z851F1357LCPagosAduanta = A851F1357LCPagosAduanta ;
            Z852F1357LCPagosTurismo = A852F1357LCPagosTurismo ;
            Z853F1357LCPagosBono = A853F1357LCPagosBono ;
            Z854F1357LCPagosIncA = A854F1357LCPagosIncA ;
            Z855F1357LCPagosIncB = A855F1357LCPagosIncB ;
            Z856F1357LCPagosIncC = A856F1357LCPagosIncC ;
            Z857F1357LCPagosIncD = A857F1357LCPagosIncD ;
            Z858F1357LCPagosIncE = A858F1357LCPagosIncE ;
            Z859F1357LCCredDebMOv = A859F1357LCCredDebMOv ;
            Z860F1357LCViajeExterior = A860F1357LCViajeExterior ;
            Z866F1357LC_GNSI = A866F1357LC_GNSI ;
            Z867F1357LC_GanNeta = A867F1357LC_GanNeta ;
            Z871F1357LC_Cuota_fija = A871F1357LC_Cuota_fija ;
            Z872F1357LC_MesesTributados = A872F1357LC_MesesTributados ;
            Z873F1357LC_Tope_anterior = A873F1357LC_Tope_anterior ;
            Z927F1357LC_DescuSobreGrav = A927F1357LC_DescuSobreGrav ;
            Z1082F1357LC_AnticiposDeSac = A1082F1357LC_AnticiposDeSac ;
         }
      }
      if ( GX_JID == -4 )
      {
         Z861F1357LCTipReg = A861F1357LCTipReg ;
         Z844F1357LCAlicuota = A844F1357LCAlicuota ;
         Z845F1357LCAliApli = A845F1357LCAliApli ;
         Z846F1357LCDeterminado = A846F1357LCDeterminado ;
         Z847F1357LCRetenido = A847F1357LCRetenido ;
         Z848F1357LCPagosTotal = A848F1357LCPagosTotal ;
         Z849F1357LCSaldo = A849F1357LCSaldo ;
         Z850F1357CPagosCredDeb = A850F1357CPagosCredDeb ;
         Z851F1357LCPagosAduanta = A851F1357LCPagosAduanta ;
         Z852F1357LCPagosTurismo = A852F1357LCPagosTurismo ;
         Z853F1357LCPagosBono = A853F1357LCPagosBono ;
         Z854F1357LCPagosIncA = A854F1357LCPagosIncA ;
         Z855F1357LCPagosIncB = A855F1357LCPagosIncB ;
         Z856F1357LCPagosIncC = A856F1357LCPagosIncC ;
         Z857F1357LCPagosIncD = A857F1357LCPagosIncD ;
         Z858F1357LCPagosIncE = A858F1357LCPagosIncE ;
         Z859F1357LCCredDebMOv = A859F1357LCCredDebMOv ;
         Z860F1357LCViajeExterior = A860F1357LCViajeExterior ;
         Z866F1357LC_GNSI = A866F1357LC_GNSI ;
         Z867F1357LC_GanNeta = A867F1357LC_GanNeta ;
         Z871F1357LC_Cuota_fija = A871F1357LC_Cuota_fija ;
         Z872F1357LC_MesesTributados = A872F1357LC_MesesTributados ;
         Z873F1357LC_Tope_anterior = A873F1357LC_Tope_anterior ;
         Z927F1357LC_DescuSobreGrav = A927F1357LC_DescuSobreGrav ;
         Z1082F1357LC_AnticiposDeSac = A1082F1357LC_AnticiposDeSac ;
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

   public void load2K93( )
   {
      /* Using cursor T002K6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A861F1357LCTipReg});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound93 = (short)(1) ;
         A844F1357LCAlicuota = T002K6_A844F1357LCAlicuota[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A844F1357LCAlicuota", GXutil.ltrimstr( DecimalUtil.doubleToDec(A844F1357LCAlicuota), 2, 0));
         A845F1357LCAliApli = T002K6_A845F1357LCAliApli[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A845F1357LCAliApli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A845F1357LCAliApli), 2, 0));
         A846F1357LCDeterminado = T002K6_A846F1357LCDeterminado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A846F1357LCDeterminado", GXutil.ltrimstr( A846F1357LCDeterminado, 16, 2));
         A847F1357LCRetenido = T002K6_A847F1357LCRetenido[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A847F1357LCRetenido", GXutil.ltrimstr( A847F1357LCRetenido, 16, 2));
         A848F1357LCPagosTotal = T002K6_A848F1357LCPagosTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A848F1357LCPagosTotal", GXutil.ltrimstr( A848F1357LCPagosTotal, 16, 2));
         A849F1357LCSaldo = T002K6_A849F1357LCSaldo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A849F1357LCSaldo", GXutil.ltrimstr( A849F1357LCSaldo, 16, 2));
         A850F1357CPagosCredDeb = T002K6_A850F1357CPagosCredDeb[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A850F1357CPagosCredDeb", GXutil.ltrimstr( A850F1357CPagosCredDeb, 16, 2));
         A851F1357LCPagosAduanta = T002K6_A851F1357LCPagosAduanta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A851F1357LCPagosAduanta", GXutil.ltrimstr( A851F1357LCPagosAduanta, 16, 2));
         A852F1357LCPagosTurismo = T002K6_A852F1357LCPagosTurismo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A852F1357LCPagosTurismo", GXutil.ltrimstr( A852F1357LCPagosTurismo, 16, 2));
         A853F1357LCPagosBono = T002K6_A853F1357LCPagosBono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A853F1357LCPagosBono", GXutil.ltrimstr( A853F1357LCPagosBono, 16, 2));
         A854F1357LCPagosIncA = T002K6_A854F1357LCPagosIncA[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A854F1357LCPagosIncA", GXutil.ltrimstr( A854F1357LCPagosIncA, 16, 2));
         A855F1357LCPagosIncB = T002K6_A855F1357LCPagosIncB[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A855F1357LCPagosIncB", GXutil.ltrimstr( A855F1357LCPagosIncB, 16, 2));
         A856F1357LCPagosIncC = T002K6_A856F1357LCPagosIncC[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A856F1357LCPagosIncC", GXutil.ltrimstr( A856F1357LCPagosIncC, 16, 2));
         A857F1357LCPagosIncD = T002K6_A857F1357LCPagosIncD[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A857F1357LCPagosIncD", GXutil.ltrimstr( A857F1357LCPagosIncD, 16, 2));
         A858F1357LCPagosIncE = T002K6_A858F1357LCPagosIncE[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A858F1357LCPagosIncE", GXutil.ltrimstr( A858F1357LCPagosIncE, 16, 2));
         A859F1357LCCredDebMOv = T002K6_A859F1357LCCredDebMOv[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A859F1357LCCredDebMOv", GXutil.ltrimstr( A859F1357LCCredDebMOv, 16, 2));
         A860F1357LCViajeExterior = T002K6_A860F1357LCViajeExterior[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A860F1357LCViajeExterior", GXutil.ltrimstr( A860F1357LCViajeExterior, 16, 2));
         A866F1357LC_GNSI = T002K6_A866F1357LC_GNSI[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A866F1357LC_GNSI", GXutil.ltrimstr( A866F1357LC_GNSI, 16, 2));
         A867F1357LC_GanNeta = T002K6_A867F1357LC_GanNeta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A867F1357LC_GanNeta", GXutil.ltrimstr( A867F1357LC_GanNeta, 16, 2));
         A871F1357LC_Cuota_fija = T002K6_A871F1357LC_Cuota_fija[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A871F1357LC_Cuota_fija", GXutil.ltrimstr( A871F1357LC_Cuota_fija, 16, 2));
         A872F1357LC_MesesTributados = T002K6_A872F1357LC_MesesTributados[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A872F1357LC_MesesTributados", GXutil.ltrimstr( A872F1357LC_MesesTributados, 16, 2));
         A873F1357LC_Tope_anterior = T002K6_A873F1357LC_Tope_anterior[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A873F1357LC_Tope_anterior", GXutil.ltrimstr( A873F1357LC_Tope_anterior, 16, 2));
         A927F1357LC_DescuSobreGrav = T002K6_A927F1357LC_DescuSobreGrav[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A927F1357LC_DescuSobreGrav", GXutil.ltrimstr( A927F1357LC_DescuSobreGrav, 16, 2));
         A1082F1357LC_AnticiposDeSac = T002K6_A1082F1357LC_AnticiposDeSac[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1082F1357LC_AnticiposDeSac", GXutil.ltrimstr( A1082F1357LC_AnticiposDeSac, 16, 2));
         zm2K93( -4) ;
      }
      pr_default.close(4);
      onLoadActions2K93( ) ;
   }

   public void onLoadActions2K93( )
   {
   }

   public void checkExtendedTable2K93( )
   {
      nIsDirty_93 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      if ( ! ( ( A784F1357CTipoPre == 1 ) || ( A784F1357CTipoPre == 2 ) || ( A784F1357CTipoPre == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "F1357 CTipo Pre", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "F1357CTIPOPRE");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbF1357CTipoPre.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T002K5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Formulario F1357", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "F1357CSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
      /* Using cursor T002K4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( A844F1357LCAlicuota == 0 ) || ( A844F1357LCAlicuota == 1 ) || ( A844F1357LCAlicuota == 2 ) || ( A844F1357LCAlicuota == 3 ) || ( A844F1357LCAlicuota == 4 ) || ( A844F1357LCAlicuota == 5 ) || ( A844F1357LCAlicuota == 6 ) || ( A844F1357LCAlicuota == 7 ) || ( A844F1357LCAlicuota == 8 ) || ( A844F1357LCAlicuota == 9 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "[14, 14] ALÍCUOTA – ART. 94 LEY GANANCIAS", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "F1357LCALICUOTA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbF1357LCAlicuota.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A845F1357LCAliApli == 0 ) || ( A845F1357LCAliApli == 1 ) || ( A845F1357LCAliApli == 2 ) || ( A845F1357LCAliApli == 3 ) || ( A845F1357LCAliApli == 4 ) || ( A845F1357LCAliApli == 5 ) || ( A845F1357LCAliApli == 6 ) || ( A845F1357LCAliApli == 7 ) || ( A845F1357LCAliApli == 8 ) || ( A845F1357LCAliApli == 9 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "[15, 15] ALÍCUOTA APLICABLE (SIN INCLUIR HORAS EXTRAS)", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "F1357LCALIAPLI");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbF1357LCAliApli.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors2K93( )
   {
      pr_default.close(3);
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_6( int A3CliCod ,
                         short A1EmpCod ,
                         byte A784F1357CTipoPre ,
                         String A777F1357CPer ,
                         byte A778F1357CSec )
   {
      /* Using cursor T002K7 */
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

   public void gxload_5( int A3CliCod ,
                         short A1EmpCod ,
                         int A6LegNumero )
   {
      /* Using cursor T002K8 */
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

   public void getKey2K93( )
   {
      /* Using cursor T002K9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A861F1357LCTipReg});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound93 = (short)(1) ;
      }
      else
      {
         RcdFound93 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T002K3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A861F1357LCTipReg});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm2K93( 4) ;
         RcdFound93 = (short)(1) ;
         A861F1357LCTipReg = T002K3_A861F1357LCTipReg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A861F1357LCTipReg", A861F1357LCTipReg);
         A844F1357LCAlicuota = T002K3_A844F1357LCAlicuota[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A844F1357LCAlicuota", GXutil.ltrimstr( DecimalUtil.doubleToDec(A844F1357LCAlicuota), 2, 0));
         A845F1357LCAliApli = T002K3_A845F1357LCAliApli[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A845F1357LCAliApli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A845F1357LCAliApli), 2, 0));
         A846F1357LCDeterminado = T002K3_A846F1357LCDeterminado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A846F1357LCDeterminado", GXutil.ltrimstr( A846F1357LCDeterminado, 16, 2));
         A847F1357LCRetenido = T002K3_A847F1357LCRetenido[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A847F1357LCRetenido", GXutil.ltrimstr( A847F1357LCRetenido, 16, 2));
         A848F1357LCPagosTotal = T002K3_A848F1357LCPagosTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A848F1357LCPagosTotal", GXutil.ltrimstr( A848F1357LCPagosTotal, 16, 2));
         A849F1357LCSaldo = T002K3_A849F1357LCSaldo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A849F1357LCSaldo", GXutil.ltrimstr( A849F1357LCSaldo, 16, 2));
         A850F1357CPagosCredDeb = T002K3_A850F1357CPagosCredDeb[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A850F1357CPagosCredDeb", GXutil.ltrimstr( A850F1357CPagosCredDeb, 16, 2));
         A851F1357LCPagosAduanta = T002K3_A851F1357LCPagosAduanta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A851F1357LCPagosAduanta", GXutil.ltrimstr( A851F1357LCPagosAduanta, 16, 2));
         A852F1357LCPagosTurismo = T002K3_A852F1357LCPagosTurismo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A852F1357LCPagosTurismo", GXutil.ltrimstr( A852F1357LCPagosTurismo, 16, 2));
         A853F1357LCPagosBono = T002K3_A853F1357LCPagosBono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A853F1357LCPagosBono", GXutil.ltrimstr( A853F1357LCPagosBono, 16, 2));
         A854F1357LCPagosIncA = T002K3_A854F1357LCPagosIncA[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A854F1357LCPagosIncA", GXutil.ltrimstr( A854F1357LCPagosIncA, 16, 2));
         A855F1357LCPagosIncB = T002K3_A855F1357LCPagosIncB[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A855F1357LCPagosIncB", GXutil.ltrimstr( A855F1357LCPagosIncB, 16, 2));
         A856F1357LCPagosIncC = T002K3_A856F1357LCPagosIncC[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A856F1357LCPagosIncC", GXutil.ltrimstr( A856F1357LCPagosIncC, 16, 2));
         A857F1357LCPagosIncD = T002K3_A857F1357LCPagosIncD[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A857F1357LCPagosIncD", GXutil.ltrimstr( A857F1357LCPagosIncD, 16, 2));
         A858F1357LCPagosIncE = T002K3_A858F1357LCPagosIncE[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A858F1357LCPagosIncE", GXutil.ltrimstr( A858F1357LCPagosIncE, 16, 2));
         A859F1357LCCredDebMOv = T002K3_A859F1357LCCredDebMOv[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A859F1357LCCredDebMOv", GXutil.ltrimstr( A859F1357LCCredDebMOv, 16, 2));
         A860F1357LCViajeExterior = T002K3_A860F1357LCViajeExterior[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A860F1357LCViajeExterior", GXutil.ltrimstr( A860F1357LCViajeExterior, 16, 2));
         A866F1357LC_GNSI = T002K3_A866F1357LC_GNSI[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A866F1357LC_GNSI", GXutil.ltrimstr( A866F1357LC_GNSI, 16, 2));
         A867F1357LC_GanNeta = T002K3_A867F1357LC_GanNeta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A867F1357LC_GanNeta", GXutil.ltrimstr( A867F1357LC_GanNeta, 16, 2));
         A871F1357LC_Cuota_fija = T002K3_A871F1357LC_Cuota_fija[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A871F1357LC_Cuota_fija", GXutil.ltrimstr( A871F1357LC_Cuota_fija, 16, 2));
         A872F1357LC_MesesTributados = T002K3_A872F1357LC_MesesTributados[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A872F1357LC_MesesTributados", GXutil.ltrimstr( A872F1357LC_MesesTributados, 16, 2));
         A873F1357LC_Tope_anterior = T002K3_A873F1357LC_Tope_anterior[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A873F1357LC_Tope_anterior", GXutil.ltrimstr( A873F1357LC_Tope_anterior, 16, 2));
         A927F1357LC_DescuSobreGrav = T002K3_A927F1357LC_DescuSobreGrav[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A927F1357LC_DescuSobreGrav", GXutil.ltrimstr( A927F1357LC_DescuSobreGrav, 16, 2));
         A1082F1357LC_AnticiposDeSac = T002K3_A1082F1357LC_AnticiposDeSac[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1082F1357LC_AnticiposDeSac", GXutil.ltrimstr( A1082F1357LC_AnticiposDeSac, 16, 2));
         A3CliCod = T002K3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002K3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T002K3_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A784F1357CTipoPre = T002K3_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002K3_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002K3_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z784F1357CTipoPre = A784F1357CTipoPre ;
         Z777F1357CPer = A777F1357CPer ;
         Z778F1357CSec = A778F1357CSec ;
         Z6LegNumero = A6LegNumero ;
         Z861F1357LCTipReg = A861F1357LCTipReg ;
         sMode93 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load2K93( ) ;
         if ( AnyError == 1 )
         {
            RcdFound93 = (short)(0) ;
            initializeNonKey2K93( ) ;
         }
         Gx_mode = sMode93 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound93 = (short)(0) ;
         initializeNonKey2K93( ) ;
         sMode93 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode93 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey2K93( ) ;
      if ( RcdFound93 == 0 )
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
      RcdFound93 = (short)(0) ;
      /* Using cursor T002K10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A784F1357CTipoPre), Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A777F1357CPer, A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A778F1357CSec), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A861F1357LCTipReg});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T002K10_A3CliCod[0] < A3CliCod ) || ( T002K10_A3CliCod[0] == A3CliCod ) && ( T002K10_A1EmpCod[0] < A1EmpCod ) || ( T002K10_A1EmpCod[0] == A1EmpCod ) && ( T002K10_A3CliCod[0] == A3CliCod ) && ( T002K10_A784F1357CTipoPre[0] < A784F1357CTipoPre ) || ( T002K10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002K10_A1EmpCod[0] == A1EmpCod ) && ( T002K10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002K10_A777F1357CPer[0], A777F1357CPer) < 0 ) || ( GXutil.strcmp(T002K10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002K10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002K10_A1EmpCod[0] == A1EmpCod ) && ( T002K10_A3CliCod[0] == A3CliCod ) && ( T002K10_A778F1357CSec[0] < A778F1357CSec ) || ( T002K10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002K10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002K10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002K10_A1EmpCod[0] == A1EmpCod ) && ( T002K10_A3CliCod[0] == A3CliCod ) && ( T002K10_A6LegNumero[0] < A6LegNumero ) || ( T002K10_A6LegNumero[0] == A6LegNumero ) && ( T002K10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002K10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002K10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002K10_A1EmpCod[0] == A1EmpCod ) && ( T002K10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002K10_A861F1357LCTipReg[0], A861F1357LCTipReg) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T002K10_A3CliCod[0] > A3CliCod ) || ( T002K10_A3CliCod[0] == A3CliCod ) && ( T002K10_A1EmpCod[0] > A1EmpCod ) || ( T002K10_A1EmpCod[0] == A1EmpCod ) && ( T002K10_A3CliCod[0] == A3CliCod ) && ( T002K10_A784F1357CTipoPre[0] > A784F1357CTipoPre ) || ( T002K10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002K10_A1EmpCod[0] == A1EmpCod ) && ( T002K10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002K10_A777F1357CPer[0], A777F1357CPer) > 0 ) || ( GXutil.strcmp(T002K10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002K10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002K10_A1EmpCod[0] == A1EmpCod ) && ( T002K10_A3CliCod[0] == A3CliCod ) && ( T002K10_A778F1357CSec[0] > A778F1357CSec ) || ( T002K10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002K10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002K10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002K10_A1EmpCod[0] == A1EmpCod ) && ( T002K10_A3CliCod[0] == A3CliCod ) && ( T002K10_A6LegNumero[0] > A6LegNumero ) || ( T002K10_A6LegNumero[0] == A6LegNumero ) && ( T002K10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002K10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002K10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002K10_A1EmpCod[0] == A1EmpCod ) && ( T002K10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002K10_A861F1357LCTipReg[0], A861F1357LCTipReg) > 0 ) ) )
         {
            A3CliCod = T002K10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002K10_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A784F1357CTipoPre = T002K10_A784F1357CTipoPre[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
            A777F1357CPer = T002K10_A777F1357CPer[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
            A778F1357CSec = T002K10_A778F1357CSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
            A6LegNumero = T002K10_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A861F1357LCTipReg = T002K10_A861F1357LCTipReg[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A861F1357LCTipReg", A861F1357LCTipReg);
            RcdFound93 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound93 = (short)(0) ;
      /* Using cursor T002K11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A784F1357CTipoPre), Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A777F1357CPer, A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A778F1357CSec), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A861F1357LCTipReg});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T002K11_A3CliCod[0] > A3CliCod ) || ( T002K11_A3CliCod[0] == A3CliCod ) && ( T002K11_A1EmpCod[0] > A1EmpCod ) || ( T002K11_A1EmpCod[0] == A1EmpCod ) && ( T002K11_A3CliCod[0] == A3CliCod ) && ( T002K11_A784F1357CTipoPre[0] > A784F1357CTipoPre ) || ( T002K11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002K11_A1EmpCod[0] == A1EmpCod ) && ( T002K11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002K11_A777F1357CPer[0], A777F1357CPer) > 0 ) || ( GXutil.strcmp(T002K11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002K11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002K11_A1EmpCod[0] == A1EmpCod ) && ( T002K11_A3CliCod[0] == A3CliCod ) && ( T002K11_A778F1357CSec[0] > A778F1357CSec ) || ( T002K11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002K11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002K11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002K11_A1EmpCod[0] == A1EmpCod ) && ( T002K11_A3CliCod[0] == A3CliCod ) && ( T002K11_A6LegNumero[0] > A6LegNumero ) || ( T002K11_A6LegNumero[0] == A6LegNumero ) && ( T002K11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002K11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002K11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002K11_A1EmpCod[0] == A1EmpCod ) && ( T002K11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002K11_A861F1357LCTipReg[0], A861F1357LCTipReg) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T002K11_A3CliCod[0] < A3CliCod ) || ( T002K11_A3CliCod[0] == A3CliCod ) && ( T002K11_A1EmpCod[0] < A1EmpCod ) || ( T002K11_A1EmpCod[0] == A1EmpCod ) && ( T002K11_A3CliCod[0] == A3CliCod ) && ( T002K11_A784F1357CTipoPre[0] < A784F1357CTipoPre ) || ( T002K11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002K11_A1EmpCod[0] == A1EmpCod ) && ( T002K11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002K11_A777F1357CPer[0], A777F1357CPer) < 0 ) || ( GXutil.strcmp(T002K11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002K11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002K11_A1EmpCod[0] == A1EmpCod ) && ( T002K11_A3CliCod[0] == A3CliCod ) && ( T002K11_A778F1357CSec[0] < A778F1357CSec ) || ( T002K11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002K11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002K11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002K11_A1EmpCod[0] == A1EmpCod ) && ( T002K11_A3CliCod[0] == A3CliCod ) && ( T002K11_A6LegNumero[0] < A6LegNumero ) || ( T002K11_A6LegNumero[0] == A6LegNumero ) && ( T002K11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002K11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002K11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002K11_A1EmpCod[0] == A1EmpCod ) && ( T002K11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002K11_A861F1357LCTipReg[0], A861F1357LCTipReg) < 0 ) ) )
         {
            A3CliCod = T002K11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002K11_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A784F1357CTipoPre = T002K11_A784F1357CTipoPre[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
            A777F1357CPer = T002K11_A777F1357CPer[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
            A778F1357CSec = T002K11_A778F1357CSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
            A6LegNumero = T002K11_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A861F1357LCTipReg = T002K11_A861F1357LCTipReg[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A861F1357LCTipReg", A861F1357LCTipReg);
            RcdFound93 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2K93( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert2K93( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound93 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A861F1357LCTipReg, Z861F1357LCTipReg) != 0 ) )
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
               A861F1357LCTipReg = Z861F1357LCTipReg ;
               httpContext.ajax_rsp_assign_attri("", false, "A861F1357LCTipReg", A861F1357LCTipReg);
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
               update2K93( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A861F1357LCTipReg, Z861F1357LCTipReg) != 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert2K93( ) ;
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
                  insert2K93( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A861F1357LCTipReg, Z861F1357LCTipReg) != 0 ) )
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
         A861F1357LCTipReg = Z861F1357LCTipReg ;
         httpContext.ajax_rsp_assign_attri("", false, "A861F1357LCTipReg", A861F1357LCTipReg);
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
      if ( RcdFound93 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = cmbF1357LCAlicuota.getInternalname() ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart2K93( ) ;
      if ( RcdFound93 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = cmbF1357LCAlicuota.getInternalname() ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd2K93( ) ;
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
      if ( RcdFound93 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = cmbF1357LCAlicuota.getInternalname() ;
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
      if ( RcdFound93 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = cmbF1357LCAlicuota.getInternalname() ;
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
      scanStart2K93( ) ;
      if ( RcdFound93 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound93 != 0 )
         {
            scanNext2K93( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = cmbF1357LCAlicuota.getInternalname() ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd2K93( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency2K93( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002K2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A861F1357LCTipReg});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"F1357LCalculo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z844F1357LCAlicuota != T002K2_A844F1357LCAlicuota[0] ) || ( Z845F1357LCAliApli != T002K2_A845F1357LCAliApli[0] ) || ( DecimalUtil.compareTo(Z846F1357LCDeterminado, T002K2_A846F1357LCDeterminado[0]) != 0 ) || ( DecimalUtil.compareTo(Z847F1357LCRetenido, T002K2_A847F1357LCRetenido[0]) != 0 ) || ( DecimalUtil.compareTo(Z848F1357LCPagosTotal, T002K2_A848F1357LCPagosTotal[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z849F1357LCSaldo, T002K2_A849F1357LCSaldo[0]) != 0 ) || ( DecimalUtil.compareTo(Z850F1357CPagosCredDeb, T002K2_A850F1357CPagosCredDeb[0]) != 0 ) || ( DecimalUtil.compareTo(Z851F1357LCPagosAduanta, T002K2_A851F1357LCPagosAduanta[0]) != 0 ) || ( DecimalUtil.compareTo(Z852F1357LCPagosTurismo, T002K2_A852F1357LCPagosTurismo[0]) != 0 ) || ( DecimalUtil.compareTo(Z853F1357LCPagosBono, T002K2_A853F1357LCPagosBono[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z854F1357LCPagosIncA, T002K2_A854F1357LCPagosIncA[0]) != 0 ) || ( DecimalUtil.compareTo(Z855F1357LCPagosIncB, T002K2_A855F1357LCPagosIncB[0]) != 0 ) || ( DecimalUtil.compareTo(Z856F1357LCPagosIncC, T002K2_A856F1357LCPagosIncC[0]) != 0 ) || ( DecimalUtil.compareTo(Z857F1357LCPagosIncD, T002K2_A857F1357LCPagosIncD[0]) != 0 ) || ( DecimalUtil.compareTo(Z858F1357LCPagosIncE, T002K2_A858F1357LCPagosIncE[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z859F1357LCCredDebMOv, T002K2_A859F1357LCCredDebMOv[0]) != 0 ) || ( DecimalUtil.compareTo(Z860F1357LCViajeExterior, T002K2_A860F1357LCViajeExterior[0]) != 0 ) || ( DecimalUtil.compareTo(Z866F1357LC_GNSI, T002K2_A866F1357LC_GNSI[0]) != 0 ) || ( DecimalUtil.compareTo(Z867F1357LC_GanNeta, T002K2_A867F1357LC_GanNeta[0]) != 0 ) || ( DecimalUtil.compareTo(Z871F1357LC_Cuota_fija, T002K2_A871F1357LC_Cuota_fija[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z872F1357LC_MesesTributados, T002K2_A872F1357LC_MesesTributados[0]) != 0 ) || ( DecimalUtil.compareTo(Z873F1357LC_Tope_anterior, T002K2_A873F1357LC_Tope_anterior[0]) != 0 ) || ( DecimalUtil.compareTo(Z927F1357LC_DescuSobreGrav, T002K2_A927F1357LC_DescuSobreGrav[0]) != 0 ) || ( DecimalUtil.compareTo(Z1082F1357LC_AnticiposDeSac, T002K2_A1082F1357LC_AnticiposDeSac[0]) != 0 ) )
         {
            if ( Z844F1357LCAlicuota != T002K2_A844F1357LCAlicuota[0] )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LCAlicuota");
               GXutil.writeLogRaw("Old: ",Z844F1357LCAlicuota);
               GXutil.writeLogRaw("Current: ",T002K2_A844F1357LCAlicuota[0]);
            }
            if ( Z845F1357LCAliApli != T002K2_A845F1357LCAliApli[0] )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LCAliApli");
               GXutil.writeLogRaw("Old: ",Z845F1357LCAliApli);
               GXutil.writeLogRaw("Current: ",T002K2_A845F1357LCAliApli[0]);
            }
            if ( DecimalUtil.compareTo(Z846F1357LCDeterminado, T002K2_A846F1357LCDeterminado[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LCDeterminado");
               GXutil.writeLogRaw("Old: ",Z846F1357LCDeterminado);
               GXutil.writeLogRaw("Current: ",T002K2_A846F1357LCDeterminado[0]);
            }
            if ( DecimalUtil.compareTo(Z847F1357LCRetenido, T002K2_A847F1357LCRetenido[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LCRetenido");
               GXutil.writeLogRaw("Old: ",Z847F1357LCRetenido);
               GXutil.writeLogRaw("Current: ",T002K2_A847F1357LCRetenido[0]);
            }
            if ( DecimalUtil.compareTo(Z848F1357LCPagosTotal, T002K2_A848F1357LCPagosTotal[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LCPagosTotal");
               GXutil.writeLogRaw("Old: ",Z848F1357LCPagosTotal);
               GXutil.writeLogRaw("Current: ",T002K2_A848F1357LCPagosTotal[0]);
            }
            if ( DecimalUtil.compareTo(Z849F1357LCSaldo, T002K2_A849F1357LCSaldo[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LCSaldo");
               GXutil.writeLogRaw("Old: ",Z849F1357LCSaldo);
               GXutil.writeLogRaw("Current: ",T002K2_A849F1357LCSaldo[0]);
            }
            if ( DecimalUtil.compareTo(Z850F1357CPagosCredDeb, T002K2_A850F1357CPagosCredDeb[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357CPagosCredDeb");
               GXutil.writeLogRaw("Old: ",Z850F1357CPagosCredDeb);
               GXutil.writeLogRaw("Current: ",T002K2_A850F1357CPagosCredDeb[0]);
            }
            if ( DecimalUtil.compareTo(Z851F1357LCPagosAduanta, T002K2_A851F1357LCPagosAduanta[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LCPagosAduanta");
               GXutil.writeLogRaw("Old: ",Z851F1357LCPagosAduanta);
               GXutil.writeLogRaw("Current: ",T002K2_A851F1357LCPagosAduanta[0]);
            }
            if ( DecimalUtil.compareTo(Z852F1357LCPagosTurismo, T002K2_A852F1357LCPagosTurismo[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LCPagosTurismo");
               GXutil.writeLogRaw("Old: ",Z852F1357LCPagosTurismo);
               GXutil.writeLogRaw("Current: ",T002K2_A852F1357LCPagosTurismo[0]);
            }
            if ( DecimalUtil.compareTo(Z853F1357LCPagosBono, T002K2_A853F1357LCPagosBono[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LCPagosBono");
               GXutil.writeLogRaw("Old: ",Z853F1357LCPagosBono);
               GXutil.writeLogRaw("Current: ",T002K2_A853F1357LCPagosBono[0]);
            }
            if ( DecimalUtil.compareTo(Z854F1357LCPagosIncA, T002K2_A854F1357LCPagosIncA[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LCPagosIncA");
               GXutil.writeLogRaw("Old: ",Z854F1357LCPagosIncA);
               GXutil.writeLogRaw("Current: ",T002K2_A854F1357LCPagosIncA[0]);
            }
            if ( DecimalUtil.compareTo(Z855F1357LCPagosIncB, T002K2_A855F1357LCPagosIncB[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LCPagosIncB");
               GXutil.writeLogRaw("Old: ",Z855F1357LCPagosIncB);
               GXutil.writeLogRaw("Current: ",T002K2_A855F1357LCPagosIncB[0]);
            }
            if ( DecimalUtil.compareTo(Z856F1357LCPagosIncC, T002K2_A856F1357LCPagosIncC[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LCPagosIncC");
               GXutil.writeLogRaw("Old: ",Z856F1357LCPagosIncC);
               GXutil.writeLogRaw("Current: ",T002K2_A856F1357LCPagosIncC[0]);
            }
            if ( DecimalUtil.compareTo(Z857F1357LCPagosIncD, T002K2_A857F1357LCPagosIncD[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LCPagosIncD");
               GXutil.writeLogRaw("Old: ",Z857F1357LCPagosIncD);
               GXutil.writeLogRaw("Current: ",T002K2_A857F1357LCPagosIncD[0]);
            }
            if ( DecimalUtil.compareTo(Z858F1357LCPagosIncE, T002K2_A858F1357LCPagosIncE[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LCPagosIncE");
               GXutil.writeLogRaw("Old: ",Z858F1357LCPagosIncE);
               GXutil.writeLogRaw("Current: ",T002K2_A858F1357LCPagosIncE[0]);
            }
            if ( DecimalUtil.compareTo(Z859F1357LCCredDebMOv, T002K2_A859F1357LCCredDebMOv[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LCCredDebMOv");
               GXutil.writeLogRaw("Old: ",Z859F1357LCCredDebMOv);
               GXutil.writeLogRaw("Current: ",T002K2_A859F1357LCCredDebMOv[0]);
            }
            if ( DecimalUtil.compareTo(Z860F1357LCViajeExterior, T002K2_A860F1357LCViajeExterior[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LCViajeExterior");
               GXutil.writeLogRaw("Old: ",Z860F1357LCViajeExterior);
               GXutil.writeLogRaw("Current: ",T002K2_A860F1357LCViajeExterior[0]);
            }
            if ( DecimalUtil.compareTo(Z866F1357LC_GNSI, T002K2_A866F1357LC_GNSI[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LC_GNSI");
               GXutil.writeLogRaw("Old: ",Z866F1357LC_GNSI);
               GXutil.writeLogRaw("Current: ",T002K2_A866F1357LC_GNSI[0]);
            }
            if ( DecimalUtil.compareTo(Z867F1357LC_GanNeta, T002K2_A867F1357LC_GanNeta[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LC_GanNeta");
               GXutil.writeLogRaw("Old: ",Z867F1357LC_GanNeta);
               GXutil.writeLogRaw("Current: ",T002K2_A867F1357LC_GanNeta[0]);
            }
            if ( DecimalUtil.compareTo(Z871F1357LC_Cuota_fija, T002K2_A871F1357LC_Cuota_fija[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LC_Cuota_fija");
               GXutil.writeLogRaw("Old: ",Z871F1357LC_Cuota_fija);
               GXutil.writeLogRaw("Current: ",T002K2_A871F1357LC_Cuota_fija[0]);
            }
            if ( DecimalUtil.compareTo(Z872F1357LC_MesesTributados, T002K2_A872F1357LC_MesesTributados[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LC_MesesTributados");
               GXutil.writeLogRaw("Old: ",Z872F1357LC_MesesTributados);
               GXutil.writeLogRaw("Current: ",T002K2_A872F1357LC_MesesTributados[0]);
            }
            if ( DecimalUtil.compareTo(Z873F1357LC_Tope_anterior, T002K2_A873F1357LC_Tope_anterior[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LC_Tope_anterior");
               GXutil.writeLogRaw("Old: ",Z873F1357LC_Tope_anterior);
               GXutil.writeLogRaw("Current: ",T002K2_A873F1357LC_Tope_anterior[0]);
            }
            if ( DecimalUtil.compareTo(Z927F1357LC_DescuSobreGrav, T002K2_A927F1357LC_DescuSobreGrav[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LC_DescuSobreGrav");
               GXutil.writeLogRaw("Old: ",Z927F1357LC_DescuSobreGrav);
               GXutil.writeLogRaw("Current: ",T002K2_A927F1357LC_DescuSobreGrav[0]);
            }
            if ( DecimalUtil.compareTo(Z1082F1357LC_AnticiposDeSac, T002K2_A1082F1357LC_AnticiposDeSac[0]) != 0 )
            {
               GXutil.writeLogln("f1357lcalculo:[seudo value changed for attri]"+"F1357LC_AnticiposDeSac");
               GXutil.writeLogRaw("Old: ",Z1082F1357LC_AnticiposDeSac);
               GXutil.writeLogRaw("Current: ",T002K2_A1082F1357LC_AnticiposDeSac[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"F1357LCalculo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2K93( )
   {
      beforeValidate2K93( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2K93( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2K93( 0) ;
         checkOptimisticConcurrency2K93( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2K93( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2K93( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002K12 */
                  pr_default.execute(10, new Object[] {A861F1357LCTipReg, Byte.valueOf(A844F1357LCAlicuota), Byte.valueOf(A845F1357LCAliApli), A846F1357LCDeterminado, A847F1357LCRetenido, A848F1357LCPagosTotal, A849F1357LCSaldo, A850F1357CPagosCredDeb, A851F1357LCPagosAduanta, A852F1357LCPagosTurismo, A853F1357LCPagosBono, A854F1357LCPagosIncA, A855F1357LCPagosIncB, A856F1357LCPagosIncC, A857F1357LCPagosIncD, A858F1357LCPagosIncE, A859F1357LCCredDebMOv, A860F1357LCViajeExterior, A866F1357LC_GNSI, A867F1357LC_GanNeta, A871F1357LC_Cuota_fija, A872F1357LC_MesesTributados, A873F1357LC_Tope_anterior, A927F1357LC_DescuSobreGrav, A1082F1357LC_AnticiposDeSac, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357LCalculo");
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
                        resetCaption2K0( ) ;
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
            load2K93( ) ;
         }
         endLevel2K93( ) ;
      }
      closeExtendedTableCursors2K93( ) ;
   }

   public void update2K93( )
   {
      beforeValidate2K93( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2K93( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2K93( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2K93( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2K93( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002K13 */
                  pr_default.execute(11, new Object[] {Byte.valueOf(A844F1357LCAlicuota), Byte.valueOf(A845F1357LCAliApli), A846F1357LCDeterminado, A847F1357LCRetenido, A848F1357LCPagosTotal, A849F1357LCSaldo, A850F1357CPagosCredDeb, A851F1357LCPagosAduanta, A852F1357LCPagosTurismo, A853F1357LCPagosBono, A854F1357LCPagosIncA, A855F1357LCPagosIncB, A856F1357LCPagosIncC, A857F1357LCPagosIncD, A858F1357LCPagosIncE, A859F1357LCCredDebMOv, A860F1357LCViajeExterior, A866F1357LC_GNSI, A867F1357LC_GanNeta, A871F1357LC_Cuota_fija, A872F1357LC_MesesTributados, A873F1357LC_Tope_anterior, A927F1357LC_DescuSobreGrav, A1082F1357LC_AnticiposDeSac, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A861F1357LCTipReg});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357LCalculo");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"F1357LCalculo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2K93( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption2K0( ) ;
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
         endLevel2K93( ) ;
      }
      closeExtendedTableCursors2K93( ) ;
   }

   public void deferredUpdate2K93( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate2K93( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2K93( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2K93( ) ;
         afterConfirm2K93( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2K93( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002K14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A861F1357LCTipReg});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357LCalculo");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound93 == 0 )
                     {
                        initAll2K93( ) ;
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
                     resetCaption2K0( ) ;
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
      sMode93 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2K93( ) ;
      Gx_mode = sMode93 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2K93( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel2K93( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2K93( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "f1357lcalculo");
         if ( AnyError == 0 )
         {
            confirmValues2K0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "f1357lcalculo");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2K93( )
   {
      /* Using cursor T002K15 */
      pr_default.execute(13);
      RcdFound93 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound93 = (short)(1) ;
         A3CliCod = T002K15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002K15_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A784F1357CTipoPre = T002K15_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002K15_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002K15_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         A6LegNumero = T002K15_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A861F1357LCTipReg = T002K15_A861F1357LCTipReg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A861F1357LCTipReg", A861F1357LCTipReg);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2K93( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound93 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound93 = (short)(1) ;
         A3CliCod = T002K15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002K15_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A784F1357CTipoPre = T002K15_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002K15_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002K15_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         A6LegNumero = T002K15_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A861F1357LCTipReg = T002K15_A861F1357LCTipReg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A861F1357LCTipReg", A861F1357LCTipReg);
      }
   }

   public void scanEnd2K93( )
   {
      pr_default.close(13);
   }

   public void afterConfirm2K93( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2K93( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2K93( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2K93( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2K93( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2K93( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2K93( )
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
      edtF1357LCTipReg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LCTipReg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LCTipReg_Enabled), 5, 0), true);
      cmbF1357LCAlicuota.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbF1357LCAlicuota.getInternalname(), "Enabled", GXutil.ltrimstr( cmbF1357LCAlicuota.getEnabled(), 5, 0), true);
      cmbF1357LCAliApli.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbF1357LCAliApli.getInternalname(), "Enabled", GXutil.ltrimstr( cmbF1357LCAliApli.getEnabled(), 5, 0), true);
      edtF1357LCDeterminado_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LCDeterminado_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LCDeterminado_Enabled), 5, 0), true);
      edtF1357LCRetenido_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LCRetenido_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LCRetenido_Enabled), 5, 0), true);
      edtF1357LCPagosTotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LCPagosTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LCPagosTotal_Enabled), 5, 0), true);
      edtF1357LCSaldo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LCSaldo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LCSaldo_Enabled), 5, 0), true);
      edtF1357CPagosCredDeb_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357CPagosCredDeb_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CPagosCredDeb_Enabled), 5, 0), true);
      edtF1357LCPagosAduanta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LCPagosAduanta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LCPagosAduanta_Enabled), 5, 0), true);
      edtF1357LCPagosTurismo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LCPagosTurismo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LCPagosTurismo_Enabled), 5, 0), true);
      edtF1357LCPagosBono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LCPagosBono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LCPagosBono_Enabled), 5, 0), true);
      edtF1357LCPagosIncA_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LCPagosIncA_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LCPagosIncA_Enabled), 5, 0), true);
      edtF1357LCPagosIncB_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LCPagosIncB_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LCPagosIncB_Enabled), 5, 0), true);
      edtF1357LCPagosIncC_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LCPagosIncC_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LCPagosIncC_Enabled), 5, 0), true);
      edtF1357LCPagosIncD_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LCPagosIncD_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LCPagosIncD_Enabled), 5, 0), true);
      edtF1357LCPagosIncE_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LCPagosIncE_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LCPagosIncE_Enabled), 5, 0), true);
      edtF1357LCCredDebMOv_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LCCredDebMOv_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LCCredDebMOv_Enabled), 5, 0), true);
      edtF1357LCViajeExterior_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LCViajeExterior_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LCViajeExterior_Enabled), 5, 0), true);
      edtF1357LC_GNSI_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LC_GNSI_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LC_GNSI_Enabled), 5, 0), true);
      edtF1357LC_GanNeta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LC_GanNeta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LC_GanNeta_Enabled), 5, 0), true);
      edtF1357LC_Cuota_fija_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LC_Cuota_fija_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LC_Cuota_fija_Enabled), 5, 0), true);
      edtF1357LC_MesesTributados_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LC_MesesTributados_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LC_MesesTributados_Enabled), 5, 0), true);
      edtF1357LC_Tope_anterior_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LC_Tope_anterior_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LC_Tope_anterior_Enabled), 5, 0), true);
      edtF1357LC_DescuSobreGrav_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LC_DescuSobreGrav_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LC_DescuSobreGrav_Enabled), 5, 0), true);
      edtF1357LC_AnticiposDeSac_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LC_AnticiposDeSac_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LC_AnticiposDeSac_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes2K93( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues2K0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.f1357lcalculo", new String[] {}, new String[] {}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "Z861F1357LCTipReg", GXutil.rtrim( Z861F1357LCTipReg));
      web.GxWebStd.gx_hidden_field( httpContext, "Z844F1357LCAlicuota", GXutil.ltrim( localUtil.ntoc( Z844F1357LCAlicuota, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z845F1357LCAliApli", GXutil.ltrim( localUtil.ntoc( Z845F1357LCAliApli, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z846F1357LCDeterminado", GXutil.ltrim( localUtil.ntoc( Z846F1357LCDeterminado, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z847F1357LCRetenido", GXutil.ltrim( localUtil.ntoc( Z847F1357LCRetenido, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z848F1357LCPagosTotal", GXutil.ltrim( localUtil.ntoc( Z848F1357LCPagosTotal, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z849F1357LCSaldo", GXutil.ltrim( localUtil.ntoc( Z849F1357LCSaldo, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z850F1357CPagosCredDeb", GXutil.ltrim( localUtil.ntoc( Z850F1357CPagosCredDeb, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z851F1357LCPagosAduanta", GXutil.ltrim( localUtil.ntoc( Z851F1357LCPagosAduanta, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z852F1357LCPagosTurismo", GXutil.ltrim( localUtil.ntoc( Z852F1357LCPagosTurismo, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z853F1357LCPagosBono", GXutil.ltrim( localUtil.ntoc( Z853F1357LCPagosBono, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z854F1357LCPagosIncA", GXutil.ltrim( localUtil.ntoc( Z854F1357LCPagosIncA, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z855F1357LCPagosIncB", GXutil.ltrim( localUtil.ntoc( Z855F1357LCPagosIncB, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z856F1357LCPagosIncC", GXutil.ltrim( localUtil.ntoc( Z856F1357LCPagosIncC, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z857F1357LCPagosIncD", GXutil.ltrim( localUtil.ntoc( Z857F1357LCPagosIncD, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z858F1357LCPagosIncE", GXutil.ltrim( localUtil.ntoc( Z858F1357LCPagosIncE, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z859F1357LCCredDebMOv", GXutil.ltrim( localUtil.ntoc( Z859F1357LCCredDebMOv, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z860F1357LCViajeExterior", GXutil.ltrim( localUtil.ntoc( Z860F1357LCViajeExterior, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z866F1357LC_GNSI", GXutil.ltrim( localUtil.ntoc( Z866F1357LC_GNSI, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z867F1357LC_GanNeta", GXutil.ltrim( localUtil.ntoc( Z867F1357LC_GanNeta, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z871F1357LC_Cuota_fija", GXutil.ltrim( localUtil.ntoc( Z871F1357LC_Cuota_fija, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z872F1357LC_MesesTributados", GXutil.ltrim( localUtil.ntoc( Z872F1357LC_MesesTributados, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z873F1357LC_Tope_anterior", GXutil.ltrim( localUtil.ntoc( Z873F1357LC_Tope_anterior, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z927F1357LC_DescuSobreGrav", GXutil.ltrim( localUtil.ntoc( Z927F1357LC_DescuSobreGrav, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1082F1357LC_AnticiposDeSac", GXutil.ltrim( localUtil.ntoc( Z1082F1357LC_AnticiposDeSac, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      return formatLink("web.f1357lcalculo", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "F1357LCalculo" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "F1357 LCalculo", "") ;
   }

   public void initializeNonKey2K93( )
   {
      A844F1357LCAlicuota = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A844F1357LCAlicuota", GXutil.ltrimstr( DecimalUtil.doubleToDec(A844F1357LCAlicuota), 2, 0));
      A845F1357LCAliApli = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A845F1357LCAliApli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A845F1357LCAliApli), 2, 0));
      A846F1357LCDeterminado = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A846F1357LCDeterminado", GXutil.ltrimstr( A846F1357LCDeterminado, 16, 2));
      A847F1357LCRetenido = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A847F1357LCRetenido", GXutil.ltrimstr( A847F1357LCRetenido, 16, 2));
      A848F1357LCPagosTotal = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A848F1357LCPagosTotal", GXutil.ltrimstr( A848F1357LCPagosTotal, 16, 2));
      A849F1357LCSaldo = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A849F1357LCSaldo", GXutil.ltrimstr( A849F1357LCSaldo, 16, 2));
      A850F1357CPagosCredDeb = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A850F1357CPagosCredDeb", GXutil.ltrimstr( A850F1357CPagosCredDeb, 16, 2));
      A851F1357LCPagosAduanta = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A851F1357LCPagosAduanta", GXutil.ltrimstr( A851F1357LCPagosAduanta, 16, 2));
      A852F1357LCPagosTurismo = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A852F1357LCPagosTurismo", GXutil.ltrimstr( A852F1357LCPagosTurismo, 16, 2));
      A853F1357LCPagosBono = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A853F1357LCPagosBono", GXutil.ltrimstr( A853F1357LCPagosBono, 16, 2));
      A854F1357LCPagosIncA = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A854F1357LCPagosIncA", GXutil.ltrimstr( A854F1357LCPagosIncA, 16, 2));
      A855F1357LCPagosIncB = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A855F1357LCPagosIncB", GXutil.ltrimstr( A855F1357LCPagosIncB, 16, 2));
      A856F1357LCPagosIncC = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A856F1357LCPagosIncC", GXutil.ltrimstr( A856F1357LCPagosIncC, 16, 2));
      A857F1357LCPagosIncD = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A857F1357LCPagosIncD", GXutil.ltrimstr( A857F1357LCPagosIncD, 16, 2));
      A858F1357LCPagosIncE = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A858F1357LCPagosIncE", GXutil.ltrimstr( A858F1357LCPagosIncE, 16, 2));
      A859F1357LCCredDebMOv = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A859F1357LCCredDebMOv", GXutil.ltrimstr( A859F1357LCCredDebMOv, 16, 2));
      A860F1357LCViajeExterior = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A860F1357LCViajeExterior", GXutil.ltrimstr( A860F1357LCViajeExterior, 16, 2));
      A866F1357LC_GNSI = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A866F1357LC_GNSI", GXutil.ltrimstr( A866F1357LC_GNSI, 16, 2));
      A867F1357LC_GanNeta = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A867F1357LC_GanNeta", GXutil.ltrimstr( A867F1357LC_GanNeta, 16, 2));
      A871F1357LC_Cuota_fija = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A871F1357LC_Cuota_fija", GXutil.ltrimstr( A871F1357LC_Cuota_fija, 16, 2));
      A872F1357LC_MesesTributados = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A872F1357LC_MesesTributados", GXutil.ltrimstr( A872F1357LC_MesesTributados, 16, 2));
      A873F1357LC_Tope_anterior = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A873F1357LC_Tope_anterior", GXutil.ltrimstr( A873F1357LC_Tope_anterior, 16, 2));
      A927F1357LC_DescuSobreGrav = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A927F1357LC_DescuSobreGrav", GXutil.ltrimstr( A927F1357LC_DescuSobreGrav, 16, 2));
      A1082F1357LC_AnticiposDeSac = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1082F1357LC_AnticiposDeSac", GXutil.ltrimstr( A1082F1357LC_AnticiposDeSac, 16, 2));
      Z844F1357LCAlicuota = (byte)(0) ;
      Z845F1357LCAliApli = (byte)(0) ;
      Z846F1357LCDeterminado = DecimalUtil.ZERO ;
      Z847F1357LCRetenido = DecimalUtil.ZERO ;
      Z848F1357LCPagosTotal = DecimalUtil.ZERO ;
      Z849F1357LCSaldo = DecimalUtil.ZERO ;
      Z850F1357CPagosCredDeb = DecimalUtil.ZERO ;
      Z851F1357LCPagosAduanta = DecimalUtil.ZERO ;
      Z852F1357LCPagosTurismo = DecimalUtil.ZERO ;
      Z853F1357LCPagosBono = DecimalUtil.ZERO ;
      Z854F1357LCPagosIncA = DecimalUtil.ZERO ;
      Z855F1357LCPagosIncB = DecimalUtil.ZERO ;
      Z856F1357LCPagosIncC = DecimalUtil.ZERO ;
      Z857F1357LCPagosIncD = DecimalUtil.ZERO ;
      Z858F1357LCPagosIncE = DecimalUtil.ZERO ;
      Z859F1357LCCredDebMOv = DecimalUtil.ZERO ;
      Z860F1357LCViajeExterior = DecimalUtil.ZERO ;
      Z866F1357LC_GNSI = DecimalUtil.ZERO ;
      Z867F1357LC_GanNeta = DecimalUtil.ZERO ;
      Z871F1357LC_Cuota_fija = DecimalUtil.ZERO ;
      Z872F1357LC_MesesTributados = DecimalUtil.ZERO ;
      Z873F1357LC_Tope_anterior = DecimalUtil.ZERO ;
      Z927F1357LC_DescuSobreGrav = DecimalUtil.ZERO ;
      Z1082F1357LC_AnticiposDeSac = DecimalUtil.ZERO ;
   }

   public void initAll2K93( )
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
      A861F1357LCTipReg = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A861F1357LCTipReg", A861F1357LCTipReg);
      initializeNonKey2K93( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171339029", true, true);
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
      httpContext.AddJavascriptSource("gxdec.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("f1357lcalculo.js", "?2025171339030", false, true);
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
      edtF1357LCTipReg_Internalname = "F1357LCTIPREG" ;
      cmbF1357LCAlicuota.setInternalname( "F1357LCALICUOTA" );
      cmbF1357LCAliApli.setInternalname( "F1357LCALIAPLI" );
      edtF1357LCDeterminado_Internalname = "F1357LCDETERMINADO" ;
      edtF1357LCRetenido_Internalname = "F1357LCRETENIDO" ;
      edtF1357LCPagosTotal_Internalname = "F1357LCPAGOSTOTAL" ;
      edtF1357LCSaldo_Internalname = "F1357LCSALDO" ;
      edtF1357CPagosCredDeb_Internalname = "F1357CPAGOSCREDDEB" ;
      edtF1357LCPagosAduanta_Internalname = "F1357LCPAGOSADUANTA" ;
      edtF1357LCPagosTurismo_Internalname = "F1357LCPAGOSTURISMO" ;
      edtF1357LCPagosBono_Internalname = "F1357LCPAGOSBONO" ;
      edtF1357LCPagosIncA_Internalname = "F1357LCPAGOSINCA" ;
      edtF1357LCPagosIncB_Internalname = "F1357LCPAGOSINCB" ;
      edtF1357LCPagosIncC_Internalname = "F1357LCPAGOSINCC" ;
      edtF1357LCPagosIncD_Internalname = "F1357LCPAGOSINCD" ;
      edtF1357LCPagosIncE_Internalname = "F1357LCPAGOSINCE" ;
      edtF1357LCCredDebMOv_Internalname = "F1357LCCREDDEBMOV" ;
      edtF1357LCViajeExterior_Internalname = "F1357LCVIAJEEXTERIOR" ;
      edtF1357LC_GNSI_Internalname = "F1357LC_GNSI" ;
      edtF1357LC_GanNeta_Internalname = "F1357LC_GANNETA" ;
      edtF1357LC_Cuota_fija_Internalname = "F1357LC_CUOTA_FIJA" ;
      edtF1357LC_MesesTributados_Internalname = "F1357LC_MESESTRIBUTADOS" ;
      edtF1357LC_Tope_anterior_Internalname = "F1357LC_TOPE_ANTERIOR" ;
      edtF1357LC_DescuSobreGrav_Internalname = "F1357LC_DESCUSOBREGRAV" ;
      edtF1357LC_AnticiposDeSac_Internalname = "F1357LC_ANTICIPOSDESAC" ;
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
      Form.setCaption( httpContext.getMessage( "F1357 LCalculo", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtF1357LC_AnticiposDeSac_Jsonclick = "" ;
      edtF1357LC_AnticiposDeSac_Enabled = 1 ;
      edtF1357LC_DescuSobreGrav_Jsonclick = "" ;
      edtF1357LC_DescuSobreGrav_Enabled = 1 ;
      edtF1357LC_Tope_anterior_Jsonclick = "" ;
      edtF1357LC_Tope_anterior_Enabled = 1 ;
      edtF1357LC_MesesTributados_Jsonclick = "" ;
      edtF1357LC_MesesTributados_Enabled = 1 ;
      edtF1357LC_Cuota_fija_Jsonclick = "" ;
      edtF1357LC_Cuota_fija_Enabled = 1 ;
      edtF1357LC_GanNeta_Jsonclick = "" ;
      edtF1357LC_GanNeta_Enabled = 1 ;
      edtF1357LC_GNSI_Jsonclick = "" ;
      edtF1357LC_GNSI_Enabled = 1 ;
      edtF1357LCViajeExterior_Jsonclick = "" ;
      edtF1357LCViajeExterior_Enabled = 1 ;
      edtF1357LCCredDebMOv_Jsonclick = "" ;
      edtF1357LCCredDebMOv_Enabled = 1 ;
      edtF1357LCPagosIncE_Jsonclick = "" ;
      edtF1357LCPagosIncE_Enabled = 1 ;
      edtF1357LCPagosIncD_Jsonclick = "" ;
      edtF1357LCPagosIncD_Enabled = 1 ;
      edtF1357LCPagosIncC_Jsonclick = "" ;
      edtF1357LCPagosIncC_Enabled = 1 ;
      edtF1357LCPagosIncB_Jsonclick = "" ;
      edtF1357LCPagosIncB_Enabled = 1 ;
      edtF1357LCPagosIncA_Jsonclick = "" ;
      edtF1357LCPagosIncA_Enabled = 1 ;
      edtF1357LCPagosBono_Jsonclick = "" ;
      edtF1357LCPagosBono_Enabled = 1 ;
      edtF1357LCPagosTurismo_Jsonclick = "" ;
      edtF1357LCPagosTurismo_Enabled = 1 ;
      edtF1357LCPagosAduanta_Jsonclick = "" ;
      edtF1357LCPagosAduanta_Enabled = 1 ;
      edtF1357CPagosCredDeb_Jsonclick = "" ;
      edtF1357CPagosCredDeb_Enabled = 1 ;
      edtF1357LCSaldo_Jsonclick = "" ;
      edtF1357LCSaldo_Enabled = 1 ;
      edtF1357LCPagosTotal_Jsonclick = "" ;
      edtF1357LCPagosTotal_Enabled = 1 ;
      edtF1357LCRetenido_Jsonclick = "" ;
      edtF1357LCRetenido_Enabled = 1 ;
      edtF1357LCDeterminado_Jsonclick = "" ;
      edtF1357LCDeterminado_Enabled = 1 ;
      cmbF1357LCAliApli.setJsonclick( "" );
      cmbF1357LCAliApli.setEnabled( 1 );
      cmbF1357LCAlicuota.setJsonclick( "" );
      cmbF1357LCAlicuota.setEnabled( 1 );
      edtF1357LCTipReg_Jsonclick = "" ;
      edtF1357LCTipReg_Enabled = 1 ;
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
      cmbF1357LCAlicuota.setName( "F1357LCALICUOTA" );
      cmbF1357LCAlicuota.setWebtags( "" );
      cmbF1357LCAlicuota.addItem("0", "0%", (short)(0));
      cmbF1357LCAlicuota.addItem("1", "5%", (short)(0));
      cmbF1357LCAlicuota.addItem("2", "9%", (short)(0));
      cmbF1357LCAlicuota.addItem("3", "12%", (short)(0));
      cmbF1357LCAlicuota.addItem("4", "15%", (short)(0));
      cmbF1357LCAlicuota.addItem("5", "19%", (short)(0));
      cmbF1357LCAlicuota.addItem("6", "23%", (short)(0));
      cmbF1357LCAlicuota.addItem("7", "27%", (short)(0));
      cmbF1357LCAlicuota.addItem("8", "31%", (short)(0));
      cmbF1357LCAlicuota.addItem("9", "35%", (short)(0));
      if ( cmbF1357LCAlicuota.getItemCount() > 0 )
      {
         A844F1357LCAlicuota = (byte)(GXutil.lval( cmbF1357LCAlicuota.getValidValue(GXutil.trim( GXutil.str( A844F1357LCAlicuota, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A844F1357LCAlicuota", GXutil.ltrimstr( DecimalUtil.doubleToDec(A844F1357LCAlicuota), 2, 0));
      }
      cmbF1357LCAliApli.setName( "F1357LCALIAPLI" );
      cmbF1357LCAliApli.setWebtags( "" );
      cmbF1357LCAliApli.addItem("0", "0%", (short)(0));
      cmbF1357LCAliApli.addItem("1", "5%", (short)(0));
      cmbF1357LCAliApli.addItem("2", "9%", (short)(0));
      cmbF1357LCAliApli.addItem("3", "12%", (short)(0));
      cmbF1357LCAliApli.addItem("4", "15%", (short)(0));
      cmbF1357LCAliApli.addItem("5", "19%", (short)(0));
      cmbF1357LCAliApli.addItem("6", "23%", (short)(0));
      cmbF1357LCAliApli.addItem("7", "27%", (short)(0));
      cmbF1357LCAliApli.addItem("8", "31%", (short)(0));
      cmbF1357LCAliApli.addItem("9", "35%", (short)(0));
      if ( cmbF1357LCAliApli.getItemCount() > 0 )
      {
         A845F1357LCAliApli = (byte)(GXutil.lval( cmbF1357LCAliApli.getValidValue(GXutil.trim( GXutil.str( A845F1357LCAliApli, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A845F1357LCAliApli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A845F1357LCAliApli), 2, 0));
      }
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      /* Using cursor T002K16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Formulario F1357", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "F1357CSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(14);
      /* Using cursor T002K17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(15);
      GX_FocusControl = cmbF1357LCAlicuota.getInternalname() ;
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
      /* Using cursor T002K16 */
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
      /* Using cursor T002K17 */
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

   public void valid_F1357lctipreg( )
   {
      A845F1357LCAliApli = (byte)(GXutil.lval( cmbF1357LCAliApli.getValue())) ;
      cmbF1357LCAliApli.setValue( GXutil.ltrimstr( DecimalUtil.doubleToDec(A845F1357LCAliApli), 2, 0) );
      A844F1357LCAlicuota = (byte)(GXutil.lval( cmbF1357LCAlicuota.getValue())) ;
      cmbF1357LCAlicuota.setValue( GXutil.ltrimstr( DecimalUtil.doubleToDec(A844F1357LCAlicuota), 2, 0) );
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
      if ( cmbF1357LCAlicuota.getItemCount() > 0 )
      {
         A844F1357LCAlicuota = (byte)(GXutil.lval( cmbF1357LCAlicuota.getValidValue(GXutil.trim( GXutil.str( A844F1357LCAlicuota, 2, 0))))) ;
         cmbF1357LCAlicuota.setValue( GXutil.ltrimstr( DecimalUtil.doubleToDec(A844F1357LCAlicuota), 2, 0) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbF1357LCAlicuota.setValue( GXutil.trim( GXutil.str( A844F1357LCAlicuota, 2, 0)) );
      }
      if ( cmbF1357LCAliApli.getItemCount() > 0 )
      {
         A845F1357LCAliApli = (byte)(GXutil.lval( cmbF1357LCAliApli.getValidValue(GXutil.trim( GXutil.str( A845F1357LCAliApli, 2, 0))))) ;
         cmbF1357LCAliApli.setValue( GXutil.ltrimstr( DecimalUtil.doubleToDec(A845F1357LCAliApli), 2, 0) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbF1357LCAliApli.setValue( GXutil.trim( GXutil.str( A845F1357LCAliApli, 2, 0)) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A844F1357LCAlicuota", GXutil.ltrim( localUtil.ntoc( A844F1357LCAlicuota, (byte)(2), (byte)(0), ".", "")));
      cmbF1357LCAlicuota.setValue( GXutil.trim( GXutil.str( A844F1357LCAlicuota, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbF1357LCAlicuota.getInternalname(), "Values", cmbF1357LCAlicuota.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A845F1357LCAliApli", GXutil.ltrim( localUtil.ntoc( A845F1357LCAliApli, (byte)(2), (byte)(0), ".", "")));
      cmbF1357LCAliApli.setValue( GXutil.trim( GXutil.str( A845F1357LCAliApli, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbF1357LCAliApli.getInternalname(), "Values", cmbF1357LCAliApli.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A846F1357LCDeterminado", GXutil.ltrim( localUtil.ntoc( A846F1357LCDeterminado, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A847F1357LCRetenido", GXutil.ltrim( localUtil.ntoc( A847F1357LCRetenido, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A848F1357LCPagosTotal", GXutil.ltrim( localUtil.ntoc( A848F1357LCPagosTotal, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A849F1357LCSaldo", GXutil.ltrim( localUtil.ntoc( A849F1357LCSaldo, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A850F1357CPagosCredDeb", GXutil.ltrim( localUtil.ntoc( A850F1357CPagosCredDeb, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A851F1357LCPagosAduanta", GXutil.ltrim( localUtil.ntoc( A851F1357LCPagosAduanta, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A852F1357LCPagosTurismo", GXutil.ltrim( localUtil.ntoc( A852F1357LCPagosTurismo, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A853F1357LCPagosBono", GXutil.ltrim( localUtil.ntoc( A853F1357LCPagosBono, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A854F1357LCPagosIncA", GXutil.ltrim( localUtil.ntoc( A854F1357LCPagosIncA, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A855F1357LCPagosIncB", GXutil.ltrim( localUtil.ntoc( A855F1357LCPagosIncB, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A856F1357LCPagosIncC", GXutil.ltrim( localUtil.ntoc( A856F1357LCPagosIncC, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A857F1357LCPagosIncD", GXutil.ltrim( localUtil.ntoc( A857F1357LCPagosIncD, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A858F1357LCPagosIncE", GXutil.ltrim( localUtil.ntoc( A858F1357LCPagosIncE, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A859F1357LCCredDebMOv", GXutil.ltrim( localUtil.ntoc( A859F1357LCCredDebMOv, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A860F1357LCViajeExterior", GXutil.ltrim( localUtil.ntoc( A860F1357LCViajeExterior, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A866F1357LC_GNSI", GXutil.ltrim( localUtil.ntoc( A866F1357LC_GNSI, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A867F1357LC_GanNeta", GXutil.ltrim( localUtil.ntoc( A867F1357LC_GanNeta, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A871F1357LC_Cuota_fija", GXutil.ltrim( localUtil.ntoc( A871F1357LC_Cuota_fija, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A872F1357LC_MesesTributados", GXutil.ltrim( localUtil.ntoc( A872F1357LC_MesesTributados, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A873F1357LC_Tope_anterior", GXutil.ltrim( localUtil.ntoc( A873F1357LC_Tope_anterior, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A927F1357LC_DescuSobreGrav", GXutil.ltrim( localUtil.ntoc( A927F1357LC_DescuSobreGrav, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1082F1357LC_AnticiposDeSac", GXutil.ltrim( localUtil.ntoc( A1082F1357LC_AnticiposDeSac, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z784F1357CTipoPre", GXutil.ltrim( localUtil.ntoc( Z784F1357CTipoPre, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z777F1357CPer", GXutil.rtrim( Z777F1357CPer));
      web.GxWebStd.gx_hidden_field( httpContext, "Z778F1357CSec", GXutil.ltrim( localUtil.ntoc( Z778F1357CSec, (byte)(2), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z861F1357LCTipReg", GXutil.rtrim( Z861F1357LCTipReg));
      web.GxWebStd.gx_hidden_field( httpContext, "Z844F1357LCAlicuota", GXutil.ltrim( localUtil.ntoc( Z844F1357LCAlicuota, (byte)(2), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z845F1357LCAliApli", GXutil.ltrim( localUtil.ntoc( Z845F1357LCAliApli, (byte)(2), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z846F1357LCDeterminado", GXutil.ltrim( localUtil.ntoc( Z846F1357LCDeterminado, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z847F1357LCRetenido", GXutil.ltrim( localUtil.ntoc( Z847F1357LCRetenido, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z848F1357LCPagosTotal", GXutil.ltrim( localUtil.ntoc( Z848F1357LCPagosTotal, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z849F1357LCSaldo", GXutil.ltrim( localUtil.ntoc( Z849F1357LCSaldo, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z850F1357CPagosCredDeb", GXutil.ltrim( localUtil.ntoc( Z850F1357CPagosCredDeb, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z851F1357LCPagosAduanta", GXutil.ltrim( localUtil.ntoc( Z851F1357LCPagosAduanta, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z852F1357LCPagosTurismo", GXutil.ltrim( localUtil.ntoc( Z852F1357LCPagosTurismo, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z853F1357LCPagosBono", GXutil.ltrim( localUtil.ntoc( Z853F1357LCPagosBono, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z854F1357LCPagosIncA", GXutil.ltrim( localUtil.ntoc( Z854F1357LCPagosIncA, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z855F1357LCPagosIncB", GXutil.ltrim( localUtil.ntoc( Z855F1357LCPagosIncB, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z856F1357LCPagosIncC", GXutil.ltrim( localUtil.ntoc( Z856F1357LCPagosIncC, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z857F1357LCPagosIncD", GXutil.ltrim( localUtil.ntoc( Z857F1357LCPagosIncD, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z858F1357LCPagosIncE", GXutil.ltrim( localUtil.ntoc( Z858F1357LCPagosIncE, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z859F1357LCCredDebMOv", GXutil.ltrim( localUtil.ntoc( Z859F1357LCCredDebMOv, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z860F1357LCViajeExterior", GXutil.ltrim( localUtil.ntoc( Z860F1357LCViajeExterior, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z866F1357LC_GNSI", GXutil.ltrim( localUtil.ntoc( Z866F1357LC_GNSI, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z867F1357LC_GanNeta", GXutil.ltrim( localUtil.ntoc( Z867F1357LC_GanNeta, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z871F1357LC_Cuota_fija", GXutil.ltrim( localUtil.ntoc( Z871F1357LC_Cuota_fija, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z872F1357LC_MesesTributados", GXutil.ltrim( localUtil.ntoc( Z872F1357LC_MesesTributados, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z873F1357LC_Tope_anterior", GXutil.ltrim( localUtil.ntoc( Z873F1357LC_Tope_anterior, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z927F1357LC_DescuSobreGrav", GXutil.ltrim( localUtil.ntoc( Z927F1357LC_DescuSobreGrav, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1082F1357LC_AnticiposDeSac", GXutil.ltrim( localUtil.ntoc( Z1082F1357LC_AnticiposDeSac, (byte)(16), (byte)(2), ".", "")));
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
      setEventMetadata("VALID_F1357LCTIPREG","{handler:'valid_F1357lctipreg',iparms:[{av:'cmbF1357LCAliApli'},{av:'A845F1357LCAliApli',fld:'F1357LCALIAPLI',pic:'Z9'},{av:'cmbF1357LCAlicuota'},{av:'A844F1357LCAlicuota',fld:'F1357LCALICUOTA',pic:'Z9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'cmbF1357CTipoPre'},{av:'A784F1357CTipoPre',fld:'F1357CTIPOPRE',pic:'9'},{av:'A777F1357CPer',fld:'F1357CPER',pic:''},{av:'A778F1357CSec',fld:'F1357CSEC',pic:'Z9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A861F1357LCTipReg',fld:'F1357LCTIPREG',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_F1357LCTIPREG",",oparms:[{av:'cmbF1357LCAlicuota'},{av:'A844F1357LCAlicuota',fld:'F1357LCALICUOTA',pic:'Z9'},{av:'cmbF1357LCAliApli'},{av:'A845F1357LCAliApli',fld:'F1357LCALIAPLI',pic:'Z9'},{av:'A846F1357LCDeterminado',fld:'F1357LCDETERMINADO',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A847F1357LCRetenido',fld:'F1357LCRETENIDO',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A848F1357LCPagosTotal',fld:'F1357LCPAGOSTOTAL',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A849F1357LCSaldo',fld:'F1357LCSALDO',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A850F1357CPagosCredDeb',fld:'F1357CPAGOSCREDDEB',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A851F1357LCPagosAduanta',fld:'F1357LCPAGOSADUANTA',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A852F1357LCPagosTurismo',fld:'F1357LCPAGOSTURISMO',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A853F1357LCPagosBono',fld:'F1357LCPAGOSBONO',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A854F1357LCPagosIncA',fld:'F1357LCPAGOSINCA',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A855F1357LCPagosIncB',fld:'F1357LCPAGOSINCB',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A856F1357LCPagosIncC',fld:'F1357LCPAGOSINCC',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A857F1357LCPagosIncD',fld:'F1357LCPAGOSINCD',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A858F1357LCPagosIncE',fld:'F1357LCPAGOSINCE',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A859F1357LCCredDebMOv',fld:'F1357LCCREDDEBMOV',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A860F1357LCViajeExterior',fld:'F1357LCVIAJEEXTERIOR',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A866F1357LC_GNSI',fld:'F1357LC_GNSI',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A867F1357LC_GanNeta',fld:'F1357LC_GANNETA',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A871F1357LC_Cuota_fija',fld:'F1357LC_CUOTA_FIJA',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A872F1357LC_MesesTributados',fld:'F1357LC_MESESTRIBUTADOS',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A873F1357LC_Tope_anterior',fld:'F1357LC_TOPE_ANTERIOR',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A927F1357LC_DescuSobreGrav',fld:'F1357LC_DESCUSOBREGRAV',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1082F1357LC_AnticiposDeSac',fld:'F1357LC_ANTICIPOSDESAC',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z3CliCod'},{av:'Z1EmpCod'},{av:'Z784F1357CTipoPre'},{av:'Z777F1357CPer'},{av:'Z778F1357CSec'},{av:'Z6LegNumero'},{av:'Z861F1357LCTipReg'},{av:'Z844F1357LCAlicuota'},{av:'Z845F1357LCAliApli'},{av:'Z846F1357LCDeterminado'},{av:'Z847F1357LCRetenido'},{av:'Z848F1357LCPagosTotal'},{av:'Z849F1357LCSaldo'},{av:'Z850F1357CPagosCredDeb'},{av:'Z851F1357LCPagosAduanta'},{av:'Z852F1357LCPagosTurismo'},{av:'Z853F1357LCPagosBono'},{av:'Z854F1357LCPagosIncA'},{av:'Z855F1357LCPagosIncB'},{av:'Z856F1357LCPagosIncC'},{av:'Z857F1357LCPagosIncD'},{av:'Z858F1357LCPagosIncE'},{av:'Z859F1357LCCredDebMOv'},{av:'Z860F1357LCViajeExterior'},{av:'Z866F1357LC_GNSI'},{av:'Z867F1357LC_GanNeta'},{av:'Z871F1357LC_Cuota_fija'},{av:'Z872F1357LC_MesesTributados'},{av:'Z873F1357LC_Tope_anterior'},{av:'Z927F1357LC_DescuSobreGrav'},{av:'Z1082F1357LC_AnticiposDeSac'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_F1357LCALICUOTA","{handler:'valid_F1357lcalicuota',iparms:[]");
      setEventMetadata("VALID_F1357LCALICUOTA",",oparms:[]}");
      setEventMetadata("VALID_F1357LCALIAPLI","{handler:'valid_F1357lcaliapli',iparms:[]");
      setEventMetadata("VALID_F1357LCALIAPLI",",oparms:[]}");
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
      Z861F1357LCTipReg = "" ;
      Z846F1357LCDeterminado = DecimalUtil.ZERO ;
      Z847F1357LCRetenido = DecimalUtil.ZERO ;
      Z848F1357LCPagosTotal = DecimalUtil.ZERO ;
      Z849F1357LCSaldo = DecimalUtil.ZERO ;
      Z850F1357CPagosCredDeb = DecimalUtil.ZERO ;
      Z851F1357LCPagosAduanta = DecimalUtil.ZERO ;
      Z852F1357LCPagosTurismo = DecimalUtil.ZERO ;
      Z853F1357LCPagosBono = DecimalUtil.ZERO ;
      Z854F1357LCPagosIncA = DecimalUtil.ZERO ;
      Z855F1357LCPagosIncB = DecimalUtil.ZERO ;
      Z856F1357LCPagosIncC = DecimalUtil.ZERO ;
      Z857F1357LCPagosIncD = DecimalUtil.ZERO ;
      Z858F1357LCPagosIncE = DecimalUtil.ZERO ;
      Z859F1357LCCredDebMOv = DecimalUtil.ZERO ;
      Z860F1357LCViajeExterior = DecimalUtil.ZERO ;
      Z866F1357LC_GNSI = DecimalUtil.ZERO ;
      Z867F1357LC_GanNeta = DecimalUtil.ZERO ;
      Z871F1357LC_Cuota_fija = DecimalUtil.ZERO ;
      Z872F1357LC_MesesTributados = DecimalUtil.ZERO ;
      Z873F1357LC_Tope_anterior = DecimalUtil.ZERO ;
      Z927F1357LC_DescuSobreGrav = DecimalUtil.ZERO ;
      Z1082F1357LC_AnticiposDeSac = DecimalUtil.ZERO ;
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
      A861F1357LCTipReg = "" ;
      A846F1357LCDeterminado = DecimalUtil.ZERO ;
      A847F1357LCRetenido = DecimalUtil.ZERO ;
      A848F1357LCPagosTotal = DecimalUtil.ZERO ;
      A849F1357LCSaldo = DecimalUtil.ZERO ;
      A850F1357CPagosCredDeb = DecimalUtil.ZERO ;
      A851F1357LCPagosAduanta = DecimalUtil.ZERO ;
      A852F1357LCPagosTurismo = DecimalUtil.ZERO ;
      A853F1357LCPagosBono = DecimalUtil.ZERO ;
      A854F1357LCPagosIncA = DecimalUtil.ZERO ;
      A855F1357LCPagosIncB = DecimalUtil.ZERO ;
      A856F1357LCPagosIncC = DecimalUtil.ZERO ;
      A857F1357LCPagosIncD = DecimalUtil.ZERO ;
      A858F1357LCPagosIncE = DecimalUtil.ZERO ;
      A859F1357LCCredDebMOv = DecimalUtil.ZERO ;
      A860F1357LCViajeExterior = DecimalUtil.ZERO ;
      A866F1357LC_GNSI = DecimalUtil.ZERO ;
      A867F1357LC_GanNeta = DecimalUtil.ZERO ;
      A871F1357LC_Cuota_fija = DecimalUtil.ZERO ;
      A872F1357LC_MesesTributados = DecimalUtil.ZERO ;
      A873F1357LC_Tope_anterior = DecimalUtil.ZERO ;
      A927F1357LC_DescuSobreGrav = DecimalUtil.ZERO ;
      A1082F1357LC_AnticiposDeSac = DecimalUtil.ZERO ;
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
      T002K6_A861F1357LCTipReg = new String[] {""} ;
      T002K6_A844F1357LCAlicuota = new byte[1] ;
      T002K6_A845F1357LCAliApli = new byte[1] ;
      T002K6_A846F1357LCDeterminado = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A847F1357LCRetenido = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A848F1357LCPagosTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A849F1357LCSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A850F1357CPagosCredDeb = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A851F1357LCPagosAduanta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A852F1357LCPagosTurismo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A853F1357LCPagosBono = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A854F1357LCPagosIncA = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A855F1357LCPagosIncB = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A856F1357LCPagosIncC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A857F1357LCPagosIncD = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A858F1357LCPagosIncE = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A859F1357LCCredDebMOv = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A860F1357LCViajeExterior = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A866F1357LC_GNSI = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A867F1357LC_GanNeta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A871F1357LC_Cuota_fija = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A872F1357LC_MesesTributados = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A873F1357LC_Tope_anterior = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A927F1357LC_DescuSobreGrav = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A1082F1357LC_AnticiposDeSac = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K6_A3CliCod = new int[1] ;
      T002K6_A1EmpCod = new short[1] ;
      T002K6_A6LegNumero = new int[1] ;
      T002K6_A784F1357CTipoPre = new byte[1] ;
      T002K6_A777F1357CPer = new String[] {""} ;
      T002K6_A778F1357CSec = new byte[1] ;
      T002K5_A3CliCod = new int[1] ;
      T002K4_A3CliCod = new int[1] ;
      T002K7_A3CliCod = new int[1] ;
      T002K8_A3CliCod = new int[1] ;
      T002K9_A3CliCod = new int[1] ;
      T002K9_A1EmpCod = new short[1] ;
      T002K9_A784F1357CTipoPre = new byte[1] ;
      T002K9_A777F1357CPer = new String[] {""} ;
      T002K9_A778F1357CSec = new byte[1] ;
      T002K9_A6LegNumero = new int[1] ;
      T002K9_A861F1357LCTipReg = new String[] {""} ;
      T002K3_A861F1357LCTipReg = new String[] {""} ;
      T002K3_A844F1357LCAlicuota = new byte[1] ;
      T002K3_A845F1357LCAliApli = new byte[1] ;
      T002K3_A846F1357LCDeterminado = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A847F1357LCRetenido = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A848F1357LCPagosTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A849F1357LCSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A850F1357CPagosCredDeb = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A851F1357LCPagosAduanta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A852F1357LCPagosTurismo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A853F1357LCPagosBono = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A854F1357LCPagosIncA = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A855F1357LCPagosIncB = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A856F1357LCPagosIncC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A857F1357LCPagosIncD = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A858F1357LCPagosIncE = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A859F1357LCCredDebMOv = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A860F1357LCViajeExterior = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A866F1357LC_GNSI = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A867F1357LC_GanNeta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A871F1357LC_Cuota_fija = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A872F1357LC_MesesTributados = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A873F1357LC_Tope_anterior = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A927F1357LC_DescuSobreGrav = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A1082F1357LC_AnticiposDeSac = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K3_A3CliCod = new int[1] ;
      T002K3_A1EmpCod = new short[1] ;
      T002K3_A6LegNumero = new int[1] ;
      T002K3_A784F1357CTipoPre = new byte[1] ;
      T002K3_A777F1357CPer = new String[] {""} ;
      T002K3_A778F1357CSec = new byte[1] ;
      sMode93 = "" ;
      T002K10_A3CliCod = new int[1] ;
      T002K10_A1EmpCod = new short[1] ;
      T002K10_A784F1357CTipoPre = new byte[1] ;
      T002K10_A777F1357CPer = new String[] {""} ;
      T002K10_A778F1357CSec = new byte[1] ;
      T002K10_A6LegNumero = new int[1] ;
      T002K10_A861F1357LCTipReg = new String[] {""} ;
      T002K11_A3CliCod = new int[1] ;
      T002K11_A1EmpCod = new short[1] ;
      T002K11_A784F1357CTipoPre = new byte[1] ;
      T002K11_A777F1357CPer = new String[] {""} ;
      T002K11_A778F1357CSec = new byte[1] ;
      T002K11_A6LegNumero = new int[1] ;
      T002K11_A861F1357LCTipReg = new String[] {""} ;
      T002K2_A861F1357LCTipReg = new String[] {""} ;
      T002K2_A844F1357LCAlicuota = new byte[1] ;
      T002K2_A845F1357LCAliApli = new byte[1] ;
      T002K2_A846F1357LCDeterminado = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A847F1357LCRetenido = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A848F1357LCPagosTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A849F1357LCSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A850F1357CPagosCredDeb = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A851F1357LCPagosAduanta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A852F1357LCPagosTurismo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A853F1357LCPagosBono = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A854F1357LCPagosIncA = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A855F1357LCPagosIncB = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A856F1357LCPagosIncC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A857F1357LCPagosIncD = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A858F1357LCPagosIncE = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A859F1357LCCredDebMOv = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A860F1357LCViajeExterior = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A866F1357LC_GNSI = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A867F1357LC_GanNeta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A871F1357LC_Cuota_fija = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A872F1357LC_MesesTributados = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A873F1357LC_Tope_anterior = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A927F1357LC_DescuSobreGrav = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A1082F1357LC_AnticiposDeSac = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002K2_A3CliCod = new int[1] ;
      T002K2_A1EmpCod = new short[1] ;
      T002K2_A6LegNumero = new int[1] ;
      T002K2_A784F1357CTipoPre = new byte[1] ;
      T002K2_A777F1357CPer = new String[] {""} ;
      T002K2_A778F1357CSec = new byte[1] ;
      T002K15_A3CliCod = new int[1] ;
      T002K15_A1EmpCod = new short[1] ;
      T002K15_A784F1357CTipoPre = new byte[1] ;
      T002K15_A777F1357CPer = new String[] {""} ;
      T002K15_A778F1357CSec = new byte[1] ;
      T002K15_A6LegNumero = new int[1] ;
      T002K15_A861F1357LCTipReg = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T002K16_A3CliCod = new int[1] ;
      T002K17_A3CliCod = new int[1] ;
      ZZ777F1357CPer = "" ;
      ZZ861F1357LCTipReg = "" ;
      ZZ846F1357LCDeterminado = DecimalUtil.ZERO ;
      ZZ847F1357LCRetenido = DecimalUtil.ZERO ;
      ZZ848F1357LCPagosTotal = DecimalUtil.ZERO ;
      ZZ849F1357LCSaldo = DecimalUtil.ZERO ;
      ZZ850F1357CPagosCredDeb = DecimalUtil.ZERO ;
      ZZ851F1357LCPagosAduanta = DecimalUtil.ZERO ;
      ZZ852F1357LCPagosTurismo = DecimalUtil.ZERO ;
      ZZ853F1357LCPagosBono = DecimalUtil.ZERO ;
      ZZ854F1357LCPagosIncA = DecimalUtil.ZERO ;
      ZZ855F1357LCPagosIncB = DecimalUtil.ZERO ;
      ZZ856F1357LCPagosIncC = DecimalUtil.ZERO ;
      ZZ857F1357LCPagosIncD = DecimalUtil.ZERO ;
      ZZ858F1357LCPagosIncE = DecimalUtil.ZERO ;
      ZZ859F1357LCCredDebMOv = DecimalUtil.ZERO ;
      ZZ860F1357LCViajeExterior = DecimalUtil.ZERO ;
      ZZ866F1357LC_GNSI = DecimalUtil.ZERO ;
      ZZ867F1357LC_GanNeta = DecimalUtil.ZERO ;
      ZZ871F1357LC_Cuota_fija = DecimalUtil.ZERO ;
      ZZ872F1357LC_MesesTributados = DecimalUtil.ZERO ;
      ZZ873F1357LC_Tope_anterior = DecimalUtil.ZERO ;
      ZZ927F1357LC_DescuSobreGrav = DecimalUtil.ZERO ;
      ZZ1082F1357LC_AnticiposDeSac = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357lcalculo__default(),
         new Object[] {
             new Object[] {
            T002K2_A861F1357LCTipReg, T002K2_A844F1357LCAlicuota, T002K2_A845F1357LCAliApli, T002K2_A846F1357LCDeterminado, T002K2_A847F1357LCRetenido, T002K2_A848F1357LCPagosTotal, T002K2_A849F1357LCSaldo, T002K2_A850F1357CPagosCredDeb, T002K2_A851F1357LCPagosAduanta, T002K2_A852F1357LCPagosTurismo,
            T002K2_A853F1357LCPagosBono, T002K2_A854F1357LCPagosIncA, T002K2_A855F1357LCPagosIncB, T002K2_A856F1357LCPagosIncC, T002K2_A857F1357LCPagosIncD, T002K2_A858F1357LCPagosIncE, T002K2_A859F1357LCCredDebMOv, T002K2_A860F1357LCViajeExterior, T002K2_A866F1357LC_GNSI, T002K2_A867F1357LC_GanNeta,
            T002K2_A871F1357LC_Cuota_fija, T002K2_A872F1357LC_MesesTributados, T002K2_A873F1357LC_Tope_anterior, T002K2_A927F1357LC_DescuSobreGrav, T002K2_A1082F1357LC_AnticiposDeSac, T002K2_A3CliCod, T002K2_A1EmpCod, T002K2_A6LegNumero, T002K2_A784F1357CTipoPre, T002K2_A777F1357CPer,
            T002K2_A778F1357CSec
            }
            , new Object[] {
            T002K3_A861F1357LCTipReg, T002K3_A844F1357LCAlicuota, T002K3_A845F1357LCAliApli, T002K3_A846F1357LCDeterminado, T002K3_A847F1357LCRetenido, T002K3_A848F1357LCPagosTotal, T002K3_A849F1357LCSaldo, T002K3_A850F1357CPagosCredDeb, T002K3_A851F1357LCPagosAduanta, T002K3_A852F1357LCPagosTurismo,
            T002K3_A853F1357LCPagosBono, T002K3_A854F1357LCPagosIncA, T002K3_A855F1357LCPagosIncB, T002K3_A856F1357LCPagosIncC, T002K3_A857F1357LCPagosIncD, T002K3_A858F1357LCPagosIncE, T002K3_A859F1357LCCredDebMOv, T002K3_A860F1357LCViajeExterior, T002K3_A866F1357LC_GNSI, T002K3_A867F1357LC_GanNeta,
            T002K3_A871F1357LC_Cuota_fija, T002K3_A872F1357LC_MesesTributados, T002K3_A873F1357LC_Tope_anterior, T002K3_A927F1357LC_DescuSobreGrav, T002K3_A1082F1357LC_AnticiposDeSac, T002K3_A3CliCod, T002K3_A1EmpCod, T002K3_A6LegNumero, T002K3_A784F1357CTipoPre, T002K3_A777F1357CPer,
            T002K3_A778F1357CSec
            }
            , new Object[] {
            T002K4_A3CliCod
            }
            , new Object[] {
            T002K5_A3CliCod
            }
            , new Object[] {
            T002K6_A861F1357LCTipReg, T002K6_A844F1357LCAlicuota, T002K6_A845F1357LCAliApli, T002K6_A846F1357LCDeterminado, T002K6_A847F1357LCRetenido, T002K6_A848F1357LCPagosTotal, T002K6_A849F1357LCSaldo, T002K6_A850F1357CPagosCredDeb, T002K6_A851F1357LCPagosAduanta, T002K6_A852F1357LCPagosTurismo,
            T002K6_A853F1357LCPagosBono, T002K6_A854F1357LCPagosIncA, T002K6_A855F1357LCPagosIncB, T002K6_A856F1357LCPagosIncC, T002K6_A857F1357LCPagosIncD, T002K6_A858F1357LCPagosIncE, T002K6_A859F1357LCCredDebMOv, T002K6_A860F1357LCViajeExterior, T002K6_A866F1357LC_GNSI, T002K6_A867F1357LC_GanNeta,
            T002K6_A871F1357LC_Cuota_fija, T002K6_A872F1357LC_MesesTributados, T002K6_A873F1357LC_Tope_anterior, T002K6_A927F1357LC_DescuSobreGrav, T002K6_A1082F1357LC_AnticiposDeSac, T002K6_A3CliCod, T002K6_A1EmpCod, T002K6_A6LegNumero, T002K6_A784F1357CTipoPre, T002K6_A777F1357CPer,
            T002K6_A778F1357CSec
            }
            , new Object[] {
            T002K7_A3CliCod
            }
            , new Object[] {
            T002K8_A3CliCod
            }
            , new Object[] {
            T002K9_A3CliCod, T002K9_A1EmpCod, T002K9_A784F1357CTipoPre, T002K9_A777F1357CPer, T002K9_A778F1357CSec, T002K9_A6LegNumero, T002K9_A861F1357LCTipReg
            }
            , new Object[] {
            T002K10_A3CliCod, T002K10_A1EmpCod, T002K10_A784F1357CTipoPre, T002K10_A777F1357CPer, T002K10_A778F1357CSec, T002K10_A6LegNumero, T002K10_A861F1357LCTipReg
            }
            , new Object[] {
            T002K11_A3CliCod, T002K11_A1EmpCod, T002K11_A784F1357CTipoPre, T002K11_A777F1357CPer, T002K11_A778F1357CSec, T002K11_A6LegNumero, T002K11_A861F1357LCTipReg
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002K15_A3CliCod, T002K15_A1EmpCod, T002K15_A784F1357CTipoPre, T002K15_A777F1357CPer, T002K15_A778F1357CSec, T002K15_A6LegNumero, T002K15_A861F1357LCTipReg
            }
            , new Object[] {
            T002K16_A3CliCod
            }
            , new Object[] {
            T002K17_A3CliCod
            }
         }
      );
   }

   private byte Z784F1357CTipoPre ;
   private byte Z778F1357CSec ;
   private byte Z844F1357LCAlicuota ;
   private byte Z845F1357LCAliApli ;
   private byte GxWebError ;
   private byte A784F1357CTipoPre ;
   private byte A778F1357CSec ;
   private byte nKeyPressed ;
   private byte A844F1357LCAlicuota ;
   private byte A845F1357LCAliApli ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private byte ZZ784F1357CTipoPre ;
   private byte ZZ778F1357CSec ;
   private byte ZZ844F1357LCAlicuota ;
   private byte ZZ845F1357LCAliApli ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound93 ;
   private short nIsDirty_93 ;
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
   private int edtF1357LCTipReg_Enabled ;
   private int edtF1357LCDeterminado_Enabled ;
   private int edtF1357LCRetenido_Enabled ;
   private int edtF1357LCPagosTotal_Enabled ;
   private int edtF1357LCSaldo_Enabled ;
   private int edtF1357CPagosCredDeb_Enabled ;
   private int edtF1357LCPagosAduanta_Enabled ;
   private int edtF1357LCPagosTurismo_Enabled ;
   private int edtF1357LCPagosBono_Enabled ;
   private int edtF1357LCPagosIncA_Enabled ;
   private int edtF1357LCPagosIncB_Enabled ;
   private int edtF1357LCPagosIncC_Enabled ;
   private int edtF1357LCPagosIncD_Enabled ;
   private int edtF1357LCPagosIncE_Enabled ;
   private int edtF1357LCCredDebMOv_Enabled ;
   private int edtF1357LCViajeExterior_Enabled ;
   private int edtF1357LC_GNSI_Enabled ;
   private int edtF1357LC_GanNeta_Enabled ;
   private int edtF1357LC_Cuota_fija_Enabled ;
   private int edtF1357LC_MesesTributados_Enabled ;
   private int edtF1357LC_Tope_anterior_Enabled ;
   private int edtF1357LC_DescuSobreGrav_Enabled ;
   private int edtF1357LC_AnticiposDeSac_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ3CliCod ;
   private int ZZ6LegNumero ;
   private java.math.BigDecimal Z846F1357LCDeterminado ;
   private java.math.BigDecimal Z847F1357LCRetenido ;
   private java.math.BigDecimal Z848F1357LCPagosTotal ;
   private java.math.BigDecimal Z849F1357LCSaldo ;
   private java.math.BigDecimal Z850F1357CPagosCredDeb ;
   private java.math.BigDecimal Z851F1357LCPagosAduanta ;
   private java.math.BigDecimal Z852F1357LCPagosTurismo ;
   private java.math.BigDecimal Z853F1357LCPagosBono ;
   private java.math.BigDecimal Z854F1357LCPagosIncA ;
   private java.math.BigDecimal Z855F1357LCPagosIncB ;
   private java.math.BigDecimal Z856F1357LCPagosIncC ;
   private java.math.BigDecimal Z857F1357LCPagosIncD ;
   private java.math.BigDecimal Z858F1357LCPagosIncE ;
   private java.math.BigDecimal Z859F1357LCCredDebMOv ;
   private java.math.BigDecimal Z860F1357LCViajeExterior ;
   private java.math.BigDecimal Z866F1357LC_GNSI ;
   private java.math.BigDecimal Z867F1357LC_GanNeta ;
   private java.math.BigDecimal Z871F1357LC_Cuota_fija ;
   private java.math.BigDecimal Z872F1357LC_MesesTributados ;
   private java.math.BigDecimal Z873F1357LC_Tope_anterior ;
   private java.math.BigDecimal Z927F1357LC_DescuSobreGrav ;
   private java.math.BigDecimal Z1082F1357LC_AnticiposDeSac ;
   private java.math.BigDecimal A846F1357LCDeterminado ;
   private java.math.BigDecimal A847F1357LCRetenido ;
   private java.math.BigDecimal A848F1357LCPagosTotal ;
   private java.math.BigDecimal A849F1357LCSaldo ;
   private java.math.BigDecimal A850F1357CPagosCredDeb ;
   private java.math.BigDecimal A851F1357LCPagosAduanta ;
   private java.math.BigDecimal A852F1357LCPagosTurismo ;
   private java.math.BigDecimal A853F1357LCPagosBono ;
   private java.math.BigDecimal A854F1357LCPagosIncA ;
   private java.math.BigDecimal A855F1357LCPagosIncB ;
   private java.math.BigDecimal A856F1357LCPagosIncC ;
   private java.math.BigDecimal A857F1357LCPagosIncD ;
   private java.math.BigDecimal A858F1357LCPagosIncE ;
   private java.math.BigDecimal A859F1357LCCredDebMOv ;
   private java.math.BigDecimal A860F1357LCViajeExterior ;
   private java.math.BigDecimal A866F1357LC_GNSI ;
   private java.math.BigDecimal A867F1357LC_GanNeta ;
   private java.math.BigDecimal A871F1357LC_Cuota_fija ;
   private java.math.BigDecimal A872F1357LC_MesesTributados ;
   private java.math.BigDecimal A873F1357LC_Tope_anterior ;
   private java.math.BigDecimal A927F1357LC_DescuSobreGrav ;
   private java.math.BigDecimal A1082F1357LC_AnticiposDeSac ;
   private java.math.BigDecimal ZZ846F1357LCDeterminado ;
   private java.math.BigDecimal ZZ847F1357LCRetenido ;
   private java.math.BigDecimal ZZ848F1357LCPagosTotal ;
   private java.math.BigDecimal ZZ849F1357LCSaldo ;
   private java.math.BigDecimal ZZ850F1357CPagosCredDeb ;
   private java.math.BigDecimal ZZ851F1357LCPagosAduanta ;
   private java.math.BigDecimal ZZ852F1357LCPagosTurismo ;
   private java.math.BigDecimal ZZ853F1357LCPagosBono ;
   private java.math.BigDecimal ZZ854F1357LCPagosIncA ;
   private java.math.BigDecimal ZZ855F1357LCPagosIncB ;
   private java.math.BigDecimal ZZ856F1357LCPagosIncC ;
   private java.math.BigDecimal ZZ857F1357LCPagosIncD ;
   private java.math.BigDecimal ZZ858F1357LCPagosIncE ;
   private java.math.BigDecimal ZZ859F1357LCCredDebMOv ;
   private java.math.BigDecimal ZZ860F1357LCViajeExterior ;
   private java.math.BigDecimal ZZ866F1357LC_GNSI ;
   private java.math.BigDecimal ZZ867F1357LC_GanNeta ;
   private java.math.BigDecimal ZZ871F1357LC_Cuota_fija ;
   private java.math.BigDecimal ZZ872F1357LC_MesesTributados ;
   private java.math.BigDecimal ZZ873F1357LC_Tope_anterior ;
   private java.math.BigDecimal ZZ927F1357LC_DescuSobreGrav ;
   private java.math.BigDecimal ZZ1082F1357LC_AnticiposDeSac ;
   private String sPrefix ;
   private String Z777F1357CPer ;
   private String Z861F1357LCTipReg ;
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
   private String edtF1357LCTipReg_Internalname ;
   private String A861F1357LCTipReg ;
   private String edtF1357LCTipReg_Jsonclick ;
   private String edtF1357LCDeterminado_Internalname ;
   private String edtF1357LCDeterminado_Jsonclick ;
   private String edtF1357LCRetenido_Internalname ;
   private String edtF1357LCRetenido_Jsonclick ;
   private String edtF1357LCPagosTotal_Internalname ;
   private String edtF1357LCPagosTotal_Jsonclick ;
   private String edtF1357LCSaldo_Internalname ;
   private String edtF1357LCSaldo_Jsonclick ;
   private String edtF1357CPagosCredDeb_Internalname ;
   private String edtF1357CPagosCredDeb_Jsonclick ;
   private String edtF1357LCPagosAduanta_Internalname ;
   private String edtF1357LCPagosAduanta_Jsonclick ;
   private String edtF1357LCPagosTurismo_Internalname ;
   private String edtF1357LCPagosTurismo_Jsonclick ;
   private String edtF1357LCPagosBono_Internalname ;
   private String edtF1357LCPagosBono_Jsonclick ;
   private String edtF1357LCPagosIncA_Internalname ;
   private String edtF1357LCPagosIncA_Jsonclick ;
   private String edtF1357LCPagosIncB_Internalname ;
   private String edtF1357LCPagosIncB_Jsonclick ;
   private String edtF1357LCPagosIncC_Internalname ;
   private String edtF1357LCPagosIncC_Jsonclick ;
   private String edtF1357LCPagosIncD_Internalname ;
   private String edtF1357LCPagosIncD_Jsonclick ;
   private String edtF1357LCPagosIncE_Internalname ;
   private String edtF1357LCPagosIncE_Jsonclick ;
   private String edtF1357LCCredDebMOv_Internalname ;
   private String edtF1357LCCredDebMOv_Jsonclick ;
   private String edtF1357LCViajeExterior_Internalname ;
   private String edtF1357LCViajeExterior_Jsonclick ;
   private String edtF1357LC_GNSI_Internalname ;
   private String edtF1357LC_GNSI_Jsonclick ;
   private String edtF1357LC_GanNeta_Internalname ;
   private String edtF1357LC_GanNeta_Jsonclick ;
   private String edtF1357LC_Cuota_fija_Internalname ;
   private String edtF1357LC_Cuota_fija_Jsonclick ;
   private String edtF1357LC_MesesTributados_Internalname ;
   private String edtF1357LC_MesesTributados_Jsonclick ;
   private String edtF1357LC_Tope_anterior_Internalname ;
   private String edtF1357LC_Tope_anterior_Jsonclick ;
   private String edtF1357LC_DescuSobreGrav_Internalname ;
   private String edtF1357LC_DescuSobreGrav_Jsonclick ;
   private String edtF1357LC_AnticiposDeSac_Internalname ;
   private String edtF1357LC_AnticiposDeSac_Jsonclick ;
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
   private String sMode93 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ777F1357CPer ;
   private String ZZ861F1357LCTipReg ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Gx_longc ;
   private HTMLChoice cmbF1357CTipoPre ;
   private HTMLChoice cmbF1357LCAlicuota ;
   private HTMLChoice cmbF1357LCAliApli ;
   private IDataStoreProvider pr_default ;
   private String[] T002K6_A861F1357LCTipReg ;
   private byte[] T002K6_A844F1357LCAlicuota ;
   private byte[] T002K6_A845F1357LCAliApli ;
   private java.math.BigDecimal[] T002K6_A846F1357LCDeterminado ;
   private java.math.BigDecimal[] T002K6_A847F1357LCRetenido ;
   private java.math.BigDecimal[] T002K6_A848F1357LCPagosTotal ;
   private java.math.BigDecimal[] T002K6_A849F1357LCSaldo ;
   private java.math.BigDecimal[] T002K6_A850F1357CPagosCredDeb ;
   private java.math.BigDecimal[] T002K6_A851F1357LCPagosAduanta ;
   private java.math.BigDecimal[] T002K6_A852F1357LCPagosTurismo ;
   private java.math.BigDecimal[] T002K6_A853F1357LCPagosBono ;
   private java.math.BigDecimal[] T002K6_A854F1357LCPagosIncA ;
   private java.math.BigDecimal[] T002K6_A855F1357LCPagosIncB ;
   private java.math.BigDecimal[] T002K6_A856F1357LCPagosIncC ;
   private java.math.BigDecimal[] T002K6_A857F1357LCPagosIncD ;
   private java.math.BigDecimal[] T002K6_A858F1357LCPagosIncE ;
   private java.math.BigDecimal[] T002K6_A859F1357LCCredDebMOv ;
   private java.math.BigDecimal[] T002K6_A860F1357LCViajeExterior ;
   private java.math.BigDecimal[] T002K6_A866F1357LC_GNSI ;
   private java.math.BigDecimal[] T002K6_A867F1357LC_GanNeta ;
   private java.math.BigDecimal[] T002K6_A871F1357LC_Cuota_fija ;
   private java.math.BigDecimal[] T002K6_A872F1357LC_MesesTributados ;
   private java.math.BigDecimal[] T002K6_A873F1357LC_Tope_anterior ;
   private java.math.BigDecimal[] T002K6_A927F1357LC_DescuSobreGrav ;
   private java.math.BigDecimal[] T002K6_A1082F1357LC_AnticiposDeSac ;
   private int[] T002K6_A3CliCod ;
   private short[] T002K6_A1EmpCod ;
   private int[] T002K6_A6LegNumero ;
   private byte[] T002K6_A784F1357CTipoPre ;
   private String[] T002K6_A777F1357CPer ;
   private byte[] T002K6_A778F1357CSec ;
   private int[] T002K5_A3CliCod ;
   private int[] T002K4_A3CliCod ;
   private int[] T002K7_A3CliCod ;
   private int[] T002K8_A3CliCod ;
   private int[] T002K9_A3CliCod ;
   private short[] T002K9_A1EmpCod ;
   private byte[] T002K9_A784F1357CTipoPre ;
   private String[] T002K9_A777F1357CPer ;
   private byte[] T002K9_A778F1357CSec ;
   private int[] T002K9_A6LegNumero ;
   private String[] T002K9_A861F1357LCTipReg ;
   private String[] T002K3_A861F1357LCTipReg ;
   private byte[] T002K3_A844F1357LCAlicuota ;
   private byte[] T002K3_A845F1357LCAliApli ;
   private java.math.BigDecimal[] T002K3_A846F1357LCDeterminado ;
   private java.math.BigDecimal[] T002K3_A847F1357LCRetenido ;
   private java.math.BigDecimal[] T002K3_A848F1357LCPagosTotal ;
   private java.math.BigDecimal[] T002K3_A849F1357LCSaldo ;
   private java.math.BigDecimal[] T002K3_A850F1357CPagosCredDeb ;
   private java.math.BigDecimal[] T002K3_A851F1357LCPagosAduanta ;
   private java.math.BigDecimal[] T002K3_A852F1357LCPagosTurismo ;
   private java.math.BigDecimal[] T002K3_A853F1357LCPagosBono ;
   private java.math.BigDecimal[] T002K3_A854F1357LCPagosIncA ;
   private java.math.BigDecimal[] T002K3_A855F1357LCPagosIncB ;
   private java.math.BigDecimal[] T002K3_A856F1357LCPagosIncC ;
   private java.math.BigDecimal[] T002K3_A857F1357LCPagosIncD ;
   private java.math.BigDecimal[] T002K3_A858F1357LCPagosIncE ;
   private java.math.BigDecimal[] T002K3_A859F1357LCCredDebMOv ;
   private java.math.BigDecimal[] T002K3_A860F1357LCViajeExterior ;
   private java.math.BigDecimal[] T002K3_A866F1357LC_GNSI ;
   private java.math.BigDecimal[] T002K3_A867F1357LC_GanNeta ;
   private java.math.BigDecimal[] T002K3_A871F1357LC_Cuota_fija ;
   private java.math.BigDecimal[] T002K3_A872F1357LC_MesesTributados ;
   private java.math.BigDecimal[] T002K3_A873F1357LC_Tope_anterior ;
   private java.math.BigDecimal[] T002K3_A927F1357LC_DescuSobreGrav ;
   private java.math.BigDecimal[] T002K3_A1082F1357LC_AnticiposDeSac ;
   private int[] T002K3_A3CliCod ;
   private short[] T002K3_A1EmpCod ;
   private int[] T002K3_A6LegNumero ;
   private byte[] T002K3_A784F1357CTipoPre ;
   private String[] T002K3_A777F1357CPer ;
   private byte[] T002K3_A778F1357CSec ;
   private int[] T002K10_A3CliCod ;
   private short[] T002K10_A1EmpCod ;
   private byte[] T002K10_A784F1357CTipoPre ;
   private String[] T002K10_A777F1357CPer ;
   private byte[] T002K10_A778F1357CSec ;
   private int[] T002K10_A6LegNumero ;
   private String[] T002K10_A861F1357LCTipReg ;
   private int[] T002K11_A3CliCod ;
   private short[] T002K11_A1EmpCod ;
   private byte[] T002K11_A784F1357CTipoPre ;
   private String[] T002K11_A777F1357CPer ;
   private byte[] T002K11_A778F1357CSec ;
   private int[] T002K11_A6LegNumero ;
   private String[] T002K11_A861F1357LCTipReg ;
   private String[] T002K2_A861F1357LCTipReg ;
   private byte[] T002K2_A844F1357LCAlicuota ;
   private byte[] T002K2_A845F1357LCAliApli ;
   private java.math.BigDecimal[] T002K2_A846F1357LCDeterminado ;
   private java.math.BigDecimal[] T002K2_A847F1357LCRetenido ;
   private java.math.BigDecimal[] T002K2_A848F1357LCPagosTotal ;
   private java.math.BigDecimal[] T002K2_A849F1357LCSaldo ;
   private java.math.BigDecimal[] T002K2_A850F1357CPagosCredDeb ;
   private java.math.BigDecimal[] T002K2_A851F1357LCPagosAduanta ;
   private java.math.BigDecimal[] T002K2_A852F1357LCPagosTurismo ;
   private java.math.BigDecimal[] T002K2_A853F1357LCPagosBono ;
   private java.math.BigDecimal[] T002K2_A854F1357LCPagosIncA ;
   private java.math.BigDecimal[] T002K2_A855F1357LCPagosIncB ;
   private java.math.BigDecimal[] T002K2_A856F1357LCPagosIncC ;
   private java.math.BigDecimal[] T002K2_A857F1357LCPagosIncD ;
   private java.math.BigDecimal[] T002K2_A858F1357LCPagosIncE ;
   private java.math.BigDecimal[] T002K2_A859F1357LCCredDebMOv ;
   private java.math.BigDecimal[] T002K2_A860F1357LCViajeExterior ;
   private java.math.BigDecimal[] T002K2_A866F1357LC_GNSI ;
   private java.math.BigDecimal[] T002K2_A867F1357LC_GanNeta ;
   private java.math.BigDecimal[] T002K2_A871F1357LC_Cuota_fija ;
   private java.math.BigDecimal[] T002K2_A872F1357LC_MesesTributados ;
   private java.math.BigDecimal[] T002K2_A873F1357LC_Tope_anterior ;
   private java.math.BigDecimal[] T002K2_A927F1357LC_DescuSobreGrav ;
   private java.math.BigDecimal[] T002K2_A1082F1357LC_AnticiposDeSac ;
   private int[] T002K2_A3CliCod ;
   private short[] T002K2_A1EmpCod ;
   private int[] T002K2_A6LegNumero ;
   private byte[] T002K2_A784F1357CTipoPre ;
   private String[] T002K2_A777F1357CPer ;
   private byte[] T002K2_A778F1357CSec ;
   private int[] T002K15_A3CliCod ;
   private short[] T002K15_A1EmpCod ;
   private byte[] T002K15_A784F1357CTipoPre ;
   private String[] T002K15_A777F1357CPer ;
   private byte[] T002K15_A778F1357CSec ;
   private int[] T002K15_A6LegNumero ;
   private String[] T002K15_A861F1357LCTipReg ;
   private int[] T002K16_A3CliCod ;
   private int[] T002K17_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class f1357lcalculo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T002K2", "SELECT F1357LCTipReg, F1357LCAlicuota, F1357LCAliApli, F1357LCDeterminado, F1357LCRetenido, F1357LCPagosTotal, F1357LCSaldo, F1357CPagosCredDeb, F1357LCPagosAduanta, F1357LCPagosTurismo, F1357LCPagosBono, F1357LCPagosIncA, F1357LCPagosIncB, F1357LCPagosIncC, F1357LCPagosIncD, F1357LCPagosIncE, F1357LCCredDebMOv, F1357LCViajeExterior, F1357LC_GNSI, F1357LC_GanNeta, F1357LC_Cuota_fija, F1357LC_MesesTributados, F1357LC_Tope_anterior, F1357LC_DescuSobreGrav, F1357LC_AnticiposDeSac, CliCod, EmpCod, LegNumero, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357LCalculo WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LCTipReg = ?  FOR UPDATE OF F1357LCalculo NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002K3", "SELECT F1357LCTipReg, F1357LCAlicuota, F1357LCAliApli, F1357LCDeterminado, F1357LCRetenido, F1357LCPagosTotal, F1357LCSaldo, F1357CPagosCredDeb, F1357LCPagosAduanta, F1357LCPagosTurismo, F1357LCPagosBono, F1357LCPagosIncA, F1357LCPagosIncB, F1357LCPagosIncC, F1357LCPagosIncD, F1357LCPagosIncE, F1357LCCredDebMOv, F1357LCViajeExterior, F1357LC_GNSI, F1357LC_GanNeta, F1357LC_Cuota_fija, F1357LC_MesesTributados, F1357LC_Tope_anterior, F1357LC_DescuSobreGrav, F1357LC_AnticiposDeSac, CliCod, EmpCod, LegNumero, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357LCalculo WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LCTipReg = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002K4", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002K5", "SELECT CliCod FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002K6", "SELECT TM1.F1357LCTipReg, TM1.F1357LCAlicuota, TM1.F1357LCAliApli, TM1.F1357LCDeterminado, TM1.F1357LCRetenido, TM1.F1357LCPagosTotal, TM1.F1357LCSaldo, TM1.F1357CPagosCredDeb, TM1.F1357LCPagosAduanta, TM1.F1357LCPagosTurismo, TM1.F1357LCPagosBono, TM1.F1357LCPagosIncA, TM1.F1357LCPagosIncB, TM1.F1357LCPagosIncC, TM1.F1357LCPagosIncD, TM1.F1357LCPagosIncE, TM1.F1357LCCredDebMOv, TM1.F1357LCViajeExterior, TM1.F1357LC_GNSI, TM1.F1357LC_GanNeta, TM1.F1357LC_Cuota_fija, TM1.F1357LC_MesesTributados, TM1.F1357LC_Tope_anterior, TM1.F1357LC_DescuSobreGrav, TM1.F1357LC_AnticiposDeSac, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.F1357CTipoPre, TM1.F1357CPer, TM1.F1357CSec FROM F1357LCalculo TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.F1357CTipoPre = ? and TM1.F1357CPer = ( ?) and TM1.F1357CSec = ? and TM1.LegNumero = ? and TM1.F1357LCTipReg = ( ?) ORDER BY TM1.CliCod, TM1.EmpCod, TM1.F1357CTipoPre, TM1.F1357CPer, TM1.F1357CSec, TM1.LegNumero, TM1.F1357LCTipReg ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002K7", "SELECT CliCod FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002K8", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002K9", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LCTipReg FROM F1357LCalculo WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LCTipReg = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002K10", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LCTipReg FROM F1357LCalculo WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and F1357CTipoPre > ? or F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CPer > ( ?) or F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CSec > ? or F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and LegNumero > ? or LegNumero = ? and F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357LCTipReg > ( ?)) ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LCTipReg  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002K11", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LCTipReg FROM F1357LCalculo WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and F1357CTipoPre < ? or F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CPer < ( ?) or F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CSec < ? or F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and LegNumero < ? or LegNumero = ? and F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357LCTipReg < ( ?)) ORDER BY CliCod DESC, EmpCod DESC, F1357CTipoPre DESC, F1357CPer DESC, F1357CSec DESC, LegNumero DESC, F1357LCTipReg DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T002K12", "SAVEPOINT gxupdate;INSERT INTO F1357LCalculo(F1357LCTipReg, F1357LCAlicuota, F1357LCAliApli, F1357LCDeterminado, F1357LCRetenido, F1357LCPagosTotal, F1357LCSaldo, F1357CPagosCredDeb, F1357LCPagosAduanta, F1357LCPagosTurismo, F1357LCPagosBono, F1357LCPagosIncA, F1357LCPagosIncB, F1357LCPagosIncC, F1357LCPagosIncD, F1357LCPagosIncE, F1357LCCredDebMOv, F1357LCViajeExterior, F1357LC_GNSI, F1357LC_GanNeta, F1357LC_Cuota_fija, F1357LC_MesesTributados, F1357LC_Tope_anterior, F1357LC_DescuSobreGrav, F1357LC_AnticiposDeSac, CliCod, EmpCod, LegNumero, F1357CTipoPre, F1357CPer, F1357CSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002K13", "SAVEPOINT gxupdate;UPDATE F1357LCalculo SET F1357LCAlicuota=?, F1357LCAliApli=?, F1357LCDeterminado=?, F1357LCRetenido=?, F1357LCPagosTotal=?, F1357LCSaldo=?, F1357CPagosCredDeb=?, F1357LCPagosAduanta=?, F1357LCPagosTurismo=?, F1357LCPagosBono=?, F1357LCPagosIncA=?, F1357LCPagosIncB=?, F1357LCPagosIncC=?, F1357LCPagosIncD=?, F1357LCPagosIncE=?, F1357LCCredDebMOv=?, F1357LCViajeExterior=?, F1357LC_GNSI=?, F1357LC_GanNeta=?, F1357LC_Cuota_fija=?, F1357LC_MesesTributados=?, F1357LC_Tope_anterior=?, F1357LC_DescuSobreGrav=?, F1357LC_AnticiposDeSac=?  WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LCTipReg = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002K14", "SAVEPOINT gxupdate;DELETE FROM F1357LCalculo  WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LCTipReg = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002K15", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LCTipReg FROM F1357LCalculo ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LCTipReg ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002K16", "SELECT CliCod FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002K17", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
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
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(19,2);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,2);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,2);
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(25,2);
               ((int[]) buf[25])[0] = rslt.getInt(26);
               ((short[]) buf[26])[0] = rslt.getShort(27);
               ((int[]) buf[27])[0] = rslt.getInt(28);
               ((byte[]) buf[28])[0] = rslt.getByte(29);
               ((String[]) buf[29])[0] = rslt.getString(30, 6);
               ((byte[]) buf[30])[0] = rslt.getByte(31);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 2);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
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
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(19,2);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,2);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,2);
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(25,2);
               ((int[]) buf[25])[0] = rslt.getInt(26);
               ((short[]) buf[26])[0] = rslt.getShort(27);
               ((int[]) buf[27])[0] = rslt.getInt(28);
               ((byte[]) buf[28])[0] = rslt.getByte(29);
               ((String[]) buf[29])[0] = rslt.getString(30, 6);
               ((byte[]) buf[30])[0] = rslt.getByte(31);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 2);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
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
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(19,2);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,2);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,2);
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(25,2);
               ((int[]) buf[25])[0] = rslt.getInt(26);
               ((short[]) buf[26])[0] = rslt.getShort(27);
               ((int[]) buf[27])[0] = rslt.getInt(28);
               ((byte[]) buf[28])[0] = rslt.getByte(29);
               ((String[]) buf[29])[0] = rslt.getString(30, 6);
               ((byte[]) buf[30])[0] = rslt.getByte(31);
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
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 2);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 2);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 2);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 2);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[10], 2);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[11], 2);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[12], 2);
               stmt.setBigDecimal(14, (java.math.BigDecimal)parms[13], 2);
               stmt.setBigDecimal(15, (java.math.BigDecimal)parms[14], 2);
               stmt.setBigDecimal(16, (java.math.BigDecimal)parms[15], 2);
               stmt.setBigDecimal(17, (java.math.BigDecimal)parms[16], 2);
               stmt.setBigDecimal(18, (java.math.BigDecimal)parms[17], 2);
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[18], 2);
               stmt.setBigDecimal(20, (java.math.BigDecimal)parms[19], 2);
               stmt.setBigDecimal(21, (java.math.BigDecimal)parms[20], 2);
               stmt.setBigDecimal(22, (java.math.BigDecimal)parms[21], 2);
               stmt.setBigDecimal(23, (java.math.BigDecimal)parms[22], 2);
               stmt.setBigDecimal(24, (java.math.BigDecimal)parms[23], 2);
               stmt.setBigDecimal(25, (java.math.BigDecimal)parms[24], 2);
               stmt.setInt(26, ((Number) parms[25]).intValue());
               stmt.setShort(27, ((Number) parms[26]).shortValue());
               stmt.setInt(28, ((Number) parms[27]).intValue());
               stmt.setByte(29, ((Number) parms[28]).byteValue());
               stmt.setString(30, (String)parms[29], 6);
               stmt.setByte(31, ((Number) parms[30]).byteValue());
               return;
            case 11 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 2);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 2);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 2);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 2);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[10], 2);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[11], 2);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[12], 2);
               stmt.setBigDecimal(14, (java.math.BigDecimal)parms[13], 2);
               stmt.setBigDecimal(15, (java.math.BigDecimal)parms[14], 2);
               stmt.setBigDecimal(16, (java.math.BigDecimal)parms[15], 2);
               stmt.setBigDecimal(17, (java.math.BigDecimal)parms[16], 2);
               stmt.setBigDecimal(18, (java.math.BigDecimal)parms[17], 2);
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[18], 2);
               stmt.setBigDecimal(20, (java.math.BigDecimal)parms[19], 2);
               stmt.setBigDecimal(21, (java.math.BigDecimal)parms[20], 2);
               stmt.setBigDecimal(22, (java.math.BigDecimal)parms[21], 2);
               stmt.setBigDecimal(23, (java.math.BigDecimal)parms[22], 2);
               stmt.setBigDecimal(24, (java.math.BigDecimal)parms[23], 2);
               stmt.setInt(25, ((Number) parms[24]).intValue());
               stmt.setShort(26, ((Number) parms[25]).shortValue());
               stmt.setByte(27, ((Number) parms[26]).byteValue());
               stmt.setString(28, (String)parms[27], 6);
               stmt.setByte(29, ((Number) parms[28]).byteValue());
               stmt.setInt(30, ((Number) parms[29]).intValue());
               stmt.setString(31, (String)parms[30], 2);
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

