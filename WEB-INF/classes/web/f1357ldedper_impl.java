package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class f1357ldedper_impl extends GXDataArea
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
         gxload_4( A3CliCod, A1EmpCod, A784F1357CTipoPre, A777F1357CPer, A778F1357CSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_3") == 0 )
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
         gxload_3( A3CliCod, A1EmpCod, A6LegNumero) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "F1357 LDed Per", ""), (short)(0)) ;
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

   public f1357ldedper_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public f1357ldedper_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357ldedper_impl.class ));
   }

   public f1357ldedper_impl( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbF1357CTipoPre = new HTMLChoice();
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "F1357 LDed Per", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_F1357LDedPer.htm");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_F1357LDedPer.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357LDedPer.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_F1357LDedPer.htm");
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
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbF1357CTipoPre, cmbF1357CTipoPre.getInternalname(), GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0)), 1, cmbF1357CTipoPre.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbF1357CTipoPre.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", "", true, (byte)(0), "HLP_F1357LDedPer.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CPer_Internalname, GXutil.rtrim( A777F1357CPer), GXutil.rtrim( localUtil.format( A777F1357CPer, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CPer_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357CPer_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357LDedPer.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CSec_Internalname, GXutil.ltrim( localUtil.ntoc( A778F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357CSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A778F1357CSec), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A778F1357CSec), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357CSec_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357LDedPer.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegNumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPTipReg_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPTipReg_Internalname, httpContext.getMessage( "LDPTip Reg", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPTipReg_Internalname, GXutil.rtrim( A862F1357LDPTipReg), GXutil.rtrim( localUtil.format( A862F1357LDPTipReg, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPTipReg_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPTipReg_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPGNI_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPGNI_Internalname, httpContext.getMessage( "GANANCIA NO IMPONIBLE", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPGNI_Internalname, GXutil.ltrim( localUtil.ntoc( A827F1357LDPGNI, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPGNI_Enabled!=0) ? localUtil.format( A827F1357LDPGNI, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A827F1357LDPGNI, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPGNI_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPGNI_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPEspecial_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPEspecial_Internalname, httpContext.getMessage( "DEDUCCION ESPECIAL", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPEspecial_Internalname, GXutil.ltrim( localUtil.ntoc( A828F1357LDPEspecial, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPEspecial_Enabled!=0) ? localUtil.format( A828F1357LDPEspecial, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A828F1357LDPEspecial, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPEspecial_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPEspecial_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPEspecifica_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPEspecifica_Internalname, httpContext.getMessage( "DEDUCCIÓN ESPECÍFICA", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPEspecifica_Internalname, GXutil.ltrim( localUtil.ntoc( A829F1357LDPEspecifica, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPEspecifica_Enabled!=0) ? localUtil.format( A829F1357LDPEspecifica, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A829F1357LDPEspecifica, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPEspecifica_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPEspecifica_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPConyuge_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPConyuge_Internalname, httpContext.getMessage( "CÓNYUGE / UNION CONVIVENCIAL", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPConyuge_Internalname, GXutil.ltrim( localUtil.ntoc( A830F1357LDPConyuge, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPConyuge_Enabled!=0) ? localUtil.format( A830F1357LDPConyuge, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A830F1357LDPConyuge, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,84);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPConyuge_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPConyuge_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPCantHijos_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPCantHijos_Internalname, httpContext.getMessage( "CANTIDAD DE HIJOS / HIJASTROS AL 50 %", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPCantHijos_Internalname, GXutil.ltrim( localUtil.ntoc( A831F1357LDPCantHijos, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPCantHijos_Enabled!=0) ? localUtil.format( A831F1357LDPCantHijos, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A831F1357LDPCantHijos, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,89);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPCantHijos_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPCantHijos_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPHijosImporte_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPHijosImporte_Internalname, httpContext.getMessage( "HIJOS / HIJASTROS ($)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPHijosImporte_Internalname, GXutil.ltrim( localUtil.ntoc( A832F1357LDPHijosImporte, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPHijosImporte_Enabled!=0) ? localUtil.format( A832F1357LDPHijosImporte, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A832F1357LDPHijosImporte, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,94);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPHijosImporte_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPHijosImporte_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPTotalFami_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPTotalFami_Internalname, httpContext.getMessage( "TOTAL DE CARGAS DE FAMILIA", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPTotalFami_Internalname, GXutil.ltrim( localUtil.ntoc( A833F1357LDPTotalFami, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPTotalFami_Enabled!=0) ? localUtil.format( A833F1357LDPTotalFami, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A833F1357LDPTotalFami, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,99);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPTotalFami_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPTotalFami_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPTotalArt30_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPTotalArt30_Internalname, httpContext.getMessage( "TOTAL DEDUCCIONES ART. 30", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPTotalArt30_Internalname, GXutil.ltrim( localUtil.ntoc( A834F1357LDPTotalArt30, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPTotalArt30_Enabled!=0) ? localUtil.format( A834F1357LDPTotalArt30, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A834F1357LDPTotalArt30, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,104);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPTotalArt30_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPTotalArt30_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPSujAntes_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPSujAntes_Internalname, httpContext.getMessage( "REMUNERACIÓN SUJETA A IMPUESTO ANTES DEDUCCIÓN ART 46 LEY 27541", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPSujAntes_Internalname, GXutil.ltrim( localUtil.ntoc( A835F1357LDPSujAntes, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPSujAntes_Enabled!=0) ? localUtil.format( A835F1357LDPSujAntes, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A835F1357LDPSujAntes, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,109);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPSujAntes_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPSujAntes_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPIncA_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPIncA_Internalname, httpContext.getMessage( "DEDUCCIÓN INC. A) ART 46 LEY 27541 (GNI)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 114,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPIncA_Internalname, GXutil.ltrim( localUtil.ntoc( A836F1357LDPIncA, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPIncA_Enabled!=0) ? localUtil.format( A836F1357LDPIncA, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A836F1357LDPIncA, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,114);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPIncA_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPIncA_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPIncB_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPIncB_Internalname, httpContext.getMessage( "DEDUCCIÓN INC. C) ART 46 LEY 27541 (DE)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 119,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPIncB_Internalname, GXutil.ltrim( localUtil.ntoc( A837F1357LDPIncB, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPIncB_Enabled!=0) ? localUtil.format( A837F1357LDPIncB, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A837F1357LDPIncB, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,119);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPIncB_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPIncB_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPRemuSuj_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPRemuSuj_Internalname, httpContext.getMessage( "REMUNERACIÓN SUJETA A IMPUESTO", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 124,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPRemuSuj_Internalname, GXutil.ltrim( localUtil.ntoc( A838F1357LDPRemuSuj, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPRemuSuj_Enabled!=0) ? localUtil.format( A838F1357LDPRemuSuj, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A838F1357LDPRemuSuj, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,124);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPRemuSuj_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPRemuSuj_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPCantHijIncap_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPCantHijIncap_Internalname, httpContext.getMessage( "CANTIDAD DE HIJOS / HIJASTROS INCAPACITADOS PARA EL TRABAJO AL 50%", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 129,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPCantHijIncap_Internalname, GXutil.ltrim( localUtil.ntoc( A839F1357LDPCantHijIncap, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPCantHijIncap_Enabled!=0) ? localUtil.format( A839F1357LDPCantHijIncap, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A839F1357LDPCantHijIncap, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,129);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPCantHijIncap_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPCantHijIncap_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPHijosIncapImp_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPHijosIncapImp_Internalname, httpContext.getMessage( "HIJOS / HIJASTROS INCAPACITADOS PARA EL TRABAJO ($)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 134,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPHijosIncapImp_Internalname, GXutil.ltrim( localUtil.ntoc( A840F1357LDPHijosIncapImp, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPHijosIncapImp_Enabled!=0) ? localUtil.format( A840F1357LDPHijosIncapImp, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A840F1357LDPHijosIncapImp, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,134);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPHijosIncapImp_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPHijosIncapImp_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPEspIncremen1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPEspIncremen1_Internalname, httpContext.getMessage( "Deducción Especial Incrementada Primera parte del penúltimo párrafo del inciso c) del artículo 30 de la ley del gravamen", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 139,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPEspIncremen1_Internalname, GXutil.ltrim( localUtil.ntoc( A841F1357LDPEspIncremen1, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPEspIncremen1_Enabled!=0) ? localUtil.format( A841F1357LDPEspIncremen1, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A841F1357LDPEspIncremen1, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,139);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPEspIncremen1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPEspIncremen1_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPEspIncremen2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPEspIncremen2_Internalname, httpContext.getMessage( "Deducción Especial Incrementada Segunda parte del penúltimo párrafo del inciso c) del artículo 30 de la ley del gravamen", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 144,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPEspIncremen2_Internalname, GXutil.ltrim( localUtil.ntoc( A842F1357LDPEspIncremen2, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPEspIncremen2_Enabled!=0) ? localUtil.format( A842F1357LDPEspIncremen2, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A842F1357LDPEspIncremen2, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,144);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPEspIncremen2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPEspIncremen2_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPCantHij100PC_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPCantHij100PC_Internalname, httpContext.getMessage( "CANTIDAD DE HIJOS / HIJASTROS al 100% ", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 149,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPCantHij100PC_Internalname, GXutil.ltrim( localUtil.ntoc( A945F1357LDPCantHij100PC, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPCantHij100PC_Enabled!=0) ? localUtil.format( A945F1357LDPCantHij100PC, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A945F1357LDPCantHij100PC, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,149);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPCantHij100PC_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPCantHij100PC_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357ldpcAntHijIncap100pc_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357ldpcAntHijIncap100pc_Internalname, httpContext.getMessage( "CANTIDAD DE HIJOS / HIJASTROS INCAPACITADOS AL 100%", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 154,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357ldpcAntHijIncap100pc_Internalname, GXutil.ltrim( localUtil.ntoc( A946F1357ldpcAntHijIncap100pc, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357ldpcAntHijIncap100pc_Enabled!=0) ? localUtil.format( A946F1357ldpcAntHijIncap100pc, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A946F1357ldpcAntHijIncap100pc, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,154);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357ldpcAntHijIncap100pc_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357ldpcAntHijIncap100pc_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPcantHijMay18_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPcantHijMay18_Internalname, httpContext.getMessage( "CANTIDAD DE HIJOS ENTRE 18 y 24 AÑOS - EDUCACIÓN al 50% ", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 159,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPcantHijMay18_Internalname, GXutil.ltrim( localUtil.ntoc( A947F1357LDPcantHijMay18, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPcantHijMay18_Enabled!=0) ? localUtil.format( A947F1357LDPcantHijMay18, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A947F1357LDPcantHijMay18, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,159);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPcantHijMay18_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPcantHijMay18_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPcantHijMay18_100pc_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDPcantHijMay18_100pc_Internalname, httpContext.getMessage( "CANTIDAD DE HIJOS ENTRE 18 y 24 AÑOS - EDUCACIÓN al 100% ", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 164,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPcantHijMay18_100pc_Internalname, GXutil.ltrim( localUtil.ntoc( A948F1357LDPcantHijMay18_100pc, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPcantHijMay18_100pc_Enabled!=0) ? localUtil.format( A948F1357LDPcantHijMay18_100pc, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A948F1357LDPcantHijMay18_100pc, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,164);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPcantHijMay18_100pc_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPcantHijMay18_100pc_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LDedPer.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 169,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 171,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LDedPer.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 173,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LDedPer.htm");
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
         Z862F1357LDPTipReg = httpContext.cgiGet( "Z862F1357LDPTipReg") ;
         Z827F1357LDPGNI = localUtil.ctond( httpContext.cgiGet( "Z827F1357LDPGNI")) ;
         Z828F1357LDPEspecial = localUtil.ctond( httpContext.cgiGet( "Z828F1357LDPEspecial")) ;
         Z829F1357LDPEspecifica = localUtil.ctond( httpContext.cgiGet( "Z829F1357LDPEspecifica")) ;
         Z830F1357LDPConyuge = localUtil.ctond( httpContext.cgiGet( "Z830F1357LDPConyuge")) ;
         Z831F1357LDPCantHijos = localUtil.ctond( httpContext.cgiGet( "Z831F1357LDPCantHijos")) ;
         Z832F1357LDPHijosImporte = localUtil.ctond( httpContext.cgiGet( "Z832F1357LDPHijosImporte")) ;
         Z833F1357LDPTotalFami = localUtil.ctond( httpContext.cgiGet( "Z833F1357LDPTotalFami")) ;
         Z834F1357LDPTotalArt30 = localUtil.ctond( httpContext.cgiGet( "Z834F1357LDPTotalArt30")) ;
         Z835F1357LDPSujAntes = localUtil.ctond( httpContext.cgiGet( "Z835F1357LDPSujAntes")) ;
         Z836F1357LDPIncA = localUtil.ctond( httpContext.cgiGet( "Z836F1357LDPIncA")) ;
         Z837F1357LDPIncB = localUtil.ctond( httpContext.cgiGet( "Z837F1357LDPIncB")) ;
         Z838F1357LDPRemuSuj = localUtil.ctond( httpContext.cgiGet( "Z838F1357LDPRemuSuj")) ;
         Z839F1357LDPCantHijIncap = localUtil.ctond( httpContext.cgiGet( "Z839F1357LDPCantHijIncap")) ;
         Z840F1357LDPHijosIncapImp = localUtil.ctond( httpContext.cgiGet( "Z840F1357LDPHijosIncapImp")) ;
         Z841F1357LDPEspIncremen1 = localUtil.ctond( httpContext.cgiGet( "Z841F1357LDPEspIncremen1")) ;
         Z842F1357LDPEspIncremen2 = localUtil.ctond( httpContext.cgiGet( "Z842F1357LDPEspIncremen2")) ;
         Z945F1357LDPCantHij100PC = localUtil.ctond( httpContext.cgiGet( "Z945F1357LDPCantHij100PC")) ;
         Z946F1357ldpcAntHijIncap100pc = localUtil.ctond( httpContext.cgiGet( "Z946F1357ldpcAntHijIncap100pc")) ;
         Z947F1357LDPcantHijMay18 = localUtil.ctond( httpContext.cgiGet( "Z947F1357LDPcantHijMay18")) ;
         Z948F1357LDPcantHijMay18_100pc = localUtil.ctond( httpContext.cgiGet( "Z948F1357LDPcantHijMay18_100pc")) ;
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
         A862F1357LDPTipReg = httpContext.cgiGet( edtF1357LDPTipReg_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A862F1357LDPTipReg", A862F1357LDPTipReg);
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPGNI_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPGNI_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPGNI");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPGNI_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A827F1357LDPGNI = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A827F1357LDPGNI", GXutil.ltrimstr( A827F1357LDPGNI, 16, 2));
         }
         else
         {
            A827F1357LDPGNI = localUtil.ctond( httpContext.cgiGet( edtF1357LDPGNI_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A827F1357LDPGNI", GXutil.ltrimstr( A827F1357LDPGNI, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPEspecial_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPEspecial_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPESPECIAL");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPEspecial_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A828F1357LDPEspecial = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A828F1357LDPEspecial", GXutil.ltrimstr( A828F1357LDPEspecial, 16, 2));
         }
         else
         {
            A828F1357LDPEspecial = localUtil.ctond( httpContext.cgiGet( edtF1357LDPEspecial_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A828F1357LDPEspecial", GXutil.ltrimstr( A828F1357LDPEspecial, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPEspecifica_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPEspecifica_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPESPECIFICA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPEspecifica_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A829F1357LDPEspecifica = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A829F1357LDPEspecifica", GXutil.ltrimstr( A829F1357LDPEspecifica, 16, 2));
         }
         else
         {
            A829F1357LDPEspecifica = localUtil.ctond( httpContext.cgiGet( edtF1357LDPEspecifica_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A829F1357LDPEspecifica", GXutil.ltrimstr( A829F1357LDPEspecifica, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPConyuge_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPConyuge_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPCONYUGE");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPConyuge_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A830F1357LDPConyuge = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A830F1357LDPConyuge", GXutil.ltrimstr( A830F1357LDPConyuge, 16, 2));
         }
         else
         {
            A830F1357LDPConyuge = localUtil.ctond( httpContext.cgiGet( edtF1357LDPConyuge_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A830F1357LDPConyuge", GXutil.ltrimstr( A830F1357LDPConyuge, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPCantHijos_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPCantHijos_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPCANTHIJOS");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPCantHijos_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A831F1357LDPCantHijos = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A831F1357LDPCantHijos", GXutil.ltrimstr( A831F1357LDPCantHijos, 16, 2));
         }
         else
         {
            A831F1357LDPCantHijos = localUtil.ctond( httpContext.cgiGet( edtF1357LDPCantHijos_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A831F1357LDPCantHijos", GXutil.ltrimstr( A831F1357LDPCantHijos, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPHijosImporte_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPHijosImporte_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPHIJOSIMPORTE");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPHijosImporte_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A832F1357LDPHijosImporte = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A832F1357LDPHijosImporte", GXutil.ltrimstr( A832F1357LDPHijosImporte, 16, 2));
         }
         else
         {
            A832F1357LDPHijosImporte = localUtil.ctond( httpContext.cgiGet( edtF1357LDPHijosImporte_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A832F1357LDPHijosImporte", GXutil.ltrimstr( A832F1357LDPHijosImporte, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPTotalFami_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPTotalFami_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPTOTALFAMI");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPTotalFami_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A833F1357LDPTotalFami = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A833F1357LDPTotalFami", GXutil.ltrimstr( A833F1357LDPTotalFami, 16, 2));
         }
         else
         {
            A833F1357LDPTotalFami = localUtil.ctond( httpContext.cgiGet( edtF1357LDPTotalFami_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A833F1357LDPTotalFami", GXutil.ltrimstr( A833F1357LDPTotalFami, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPTotalArt30_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPTotalArt30_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPTOTALART30");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPTotalArt30_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A834F1357LDPTotalArt30 = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A834F1357LDPTotalArt30", GXutil.ltrimstr( A834F1357LDPTotalArt30, 16, 2));
         }
         else
         {
            A834F1357LDPTotalArt30 = localUtil.ctond( httpContext.cgiGet( edtF1357LDPTotalArt30_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A834F1357LDPTotalArt30", GXutil.ltrimstr( A834F1357LDPTotalArt30, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPSujAntes_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPSujAntes_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPSUJANTES");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPSujAntes_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A835F1357LDPSujAntes = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A835F1357LDPSujAntes", GXutil.ltrimstr( A835F1357LDPSujAntes, 16, 2));
         }
         else
         {
            A835F1357LDPSujAntes = localUtil.ctond( httpContext.cgiGet( edtF1357LDPSujAntes_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A835F1357LDPSujAntes", GXutil.ltrimstr( A835F1357LDPSujAntes, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPIncA_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPIncA_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPINCA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPIncA_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A836F1357LDPIncA = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A836F1357LDPIncA", GXutil.ltrimstr( A836F1357LDPIncA, 16, 2));
         }
         else
         {
            A836F1357LDPIncA = localUtil.ctond( httpContext.cgiGet( edtF1357LDPIncA_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A836F1357LDPIncA", GXutil.ltrimstr( A836F1357LDPIncA, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPIncB_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPIncB_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPINCB");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPIncB_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A837F1357LDPIncB = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A837F1357LDPIncB", GXutil.ltrimstr( A837F1357LDPIncB, 16, 2));
         }
         else
         {
            A837F1357LDPIncB = localUtil.ctond( httpContext.cgiGet( edtF1357LDPIncB_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A837F1357LDPIncB", GXutil.ltrimstr( A837F1357LDPIncB, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPRemuSuj_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPRemuSuj_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPREMUSUJ");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPRemuSuj_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A838F1357LDPRemuSuj = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A838F1357LDPRemuSuj", GXutil.ltrimstr( A838F1357LDPRemuSuj, 16, 2));
         }
         else
         {
            A838F1357LDPRemuSuj = localUtil.ctond( httpContext.cgiGet( edtF1357LDPRemuSuj_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A838F1357LDPRemuSuj", GXutil.ltrimstr( A838F1357LDPRemuSuj, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPCantHijIncap_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPCantHijIncap_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPCANTHIJINCAP");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPCantHijIncap_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A839F1357LDPCantHijIncap = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A839F1357LDPCantHijIncap", GXutil.ltrimstr( A839F1357LDPCantHijIncap, 16, 2));
         }
         else
         {
            A839F1357LDPCantHijIncap = localUtil.ctond( httpContext.cgiGet( edtF1357LDPCantHijIncap_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A839F1357LDPCantHijIncap", GXutil.ltrimstr( A839F1357LDPCantHijIncap, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPHijosIncapImp_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPHijosIncapImp_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPHIJOSINCAPIMP");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPHijosIncapImp_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A840F1357LDPHijosIncapImp = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A840F1357LDPHijosIncapImp", GXutil.ltrimstr( A840F1357LDPHijosIncapImp, 16, 2));
         }
         else
         {
            A840F1357LDPHijosIncapImp = localUtil.ctond( httpContext.cgiGet( edtF1357LDPHijosIncapImp_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A840F1357LDPHijosIncapImp", GXutil.ltrimstr( A840F1357LDPHijosIncapImp, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPEspIncremen1_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPEspIncremen1_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPESPINCREMEN1");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPEspIncremen1_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A841F1357LDPEspIncremen1 = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A841F1357LDPEspIncremen1", GXutil.ltrimstr( A841F1357LDPEspIncremen1, 16, 2));
         }
         else
         {
            A841F1357LDPEspIncremen1 = localUtil.ctond( httpContext.cgiGet( edtF1357LDPEspIncremen1_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A841F1357LDPEspIncremen1", GXutil.ltrimstr( A841F1357LDPEspIncremen1, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPEspIncremen2_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPEspIncremen2_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPESPINCREMEN2");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPEspIncremen2_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A842F1357LDPEspIncremen2 = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A842F1357LDPEspIncremen2", GXutil.ltrimstr( A842F1357LDPEspIncremen2, 16, 2));
         }
         else
         {
            A842F1357LDPEspIncremen2 = localUtil.ctond( httpContext.cgiGet( edtF1357LDPEspIncremen2_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A842F1357LDPEspIncremen2", GXutil.ltrimstr( A842F1357LDPEspIncremen2, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPCantHij100PC_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPCantHij100PC_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPCANTHIJ100PC");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPCantHij100PC_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A945F1357LDPCantHij100PC = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A945F1357LDPCantHij100PC", GXutil.ltrimstr( A945F1357LDPCantHij100PC, 16, 2));
         }
         else
         {
            A945F1357LDPCantHij100PC = localUtil.ctond( httpContext.cgiGet( edtF1357LDPCantHij100PC_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A945F1357LDPCantHij100PC", GXutil.ltrimstr( A945F1357LDPCantHij100PC, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357ldpcAntHijIncap100pc_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357ldpcAntHijIncap100pc_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPCANTHIJINCAP100PC");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357ldpcAntHijIncap100pc_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A946F1357ldpcAntHijIncap100pc = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A946F1357ldpcAntHijIncap100pc", GXutil.ltrimstr( A946F1357ldpcAntHijIncap100pc, 16, 2));
         }
         else
         {
            A946F1357ldpcAntHijIncap100pc = localUtil.ctond( httpContext.cgiGet( edtF1357ldpcAntHijIncap100pc_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A946F1357ldpcAntHijIncap100pc", GXutil.ltrimstr( A946F1357ldpcAntHijIncap100pc, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPcantHijMay18_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPcantHijMay18_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPCANTHIJMAY18");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPcantHijMay18_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A947F1357LDPcantHijMay18 = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A947F1357LDPcantHijMay18", GXutil.ltrimstr( A947F1357LDPcantHijMay18, 16, 2));
         }
         else
         {
            A947F1357LDPcantHijMay18 = localUtil.ctond( httpContext.cgiGet( edtF1357LDPcantHijMay18_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A947F1357LDPcantHijMay18", GXutil.ltrimstr( A947F1357LDPcantHijMay18, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPcantHijMay18_100pc_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDPcantHijMay18_100pc_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDPCANTHIJMAY18_100PC");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDPcantHijMay18_100pc_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A948F1357LDPcantHijMay18_100pc = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A948F1357LDPcantHijMay18_100pc", GXutil.ltrimstr( A948F1357LDPcantHijMay18_100pc, 16, 2));
         }
         else
         {
            A948F1357LDPcantHijMay18_100pc = localUtil.ctond( httpContext.cgiGet( edtF1357LDPcantHijMay18_100pc_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A948F1357LDPcantHijMay18_100pc", GXutil.ltrimstr( A948F1357LDPcantHijMay18_100pc, 16, 2));
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
            A862F1357LDPTipReg = httpContext.GetPar( "F1357LDPTipReg") ;
            httpContext.ajax_rsp_assign_attri("", false, "A862F1357LDPTipReg", A862F1357LDPTipReg);
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
            initAll2J94( ) ;
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
      disableAttributes2J94( ) ;
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

   public void resetCaption2J0( )
   {
   }

   public void zm2J94( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z827F1357LDPGNI = T002J3_A827F1357LDPGNI[0] ;
            Z828F1357LDPEspecial = T002J3_A828F1357LDPEspecial[0] ;
            Z829F1357LDPEspecifica = T002J3_A829F1357LDPEspecifica[0] ;
            Z830F1357LDPConyuge = T002J3_A830F1357LDPConyuge[0] ;
            Z831F1357LDPCantHijos = T002J3_A831F1357LDPCantHijos[0] ;
            Z832F1357LDPHijosImporte = T002J3_A832F1357LDPHijosImporte[0] ;
            Z833F1357LDPTotalFami = T002J3_A833F1357LDPTotalFami[0] ;
            Z834F1357LDPTotalArt30 = T002J3_A834F1357LDPTotalArt30[0] ;
            Z835F1357LDPSujAntes = T002J3_A835F1357LDPSujAntes[0] ;
            Z836F1357LDPIncA = T002J3_A836F1357LDPIncA[0] ;
            Z837F1357LDPIncB = T002J3_A837F1357LDPIncB[0] ;
            Z838F1357LDPRemuSuj = T002J3_A838F1357LDPRemuSuj[0] ;
            Z839F1357LDPCantHijIncap = T002J3_A839F1357LDPCantHijIncap[0] ;
            Z840F1357LDPHijosIncapImp = T002J3_A840F1357LDPHijosIncapImp[0] ;
            Z841F1357LDPEspIncremen1 = T002J3_A841F1357LDPEspIncremen1[0] ;
            Z842F1357LDPEspIncremen2 = T002J3_A842F1357LDPEspIncremen2[0] ;
            Z945F1357LDPCantHij100PC = T002J3_A945F1357LDPCantHij100PC[0] ;
            Z946F1357ldpcAntHijIncap100pc = T002J3_A946F1357ldpcAntHijIncap100pc[0] ;
            Z947F1357LDPcantHijMay18 = T002J3_A947F1357LDPcantHijMay18[0] ;
            Z948F1357LDPcantHijMay18_100pc = T002J3_A948F1357LDPcantHijMay18_100pc[0] ;
         }
         else
         {
            Z827F1357LDPGNI = A827F1357LDPGNI ;
            Z828F1357LDPEspecial = A828F1357LDPEspecial ;
            Z829F1357LDPEspecifica = A829F1357LDPEspecifica ;
            Z830F1357LDPConyuge = A830F1357LDPConyuge ;
            Z831F1357LDPCantHijos = A831F1357LDPCantHijos ;
            Z832F1357LDPHijosImporte = A832F1357LDPHijosImporte ;
            Z833F1357LDPTotalFami = A833F1357LDPTotalFami ;
            Z834F1357LDPTotalArt30 = A834F1357LDPTotalArt30 ;
            Z835F1357LDPSujAntes = A835F1357LDPSujAntes ;
            Z836F1357LDPIncA = A836F1357LDPIncA ;
            Z837F1357LDPIncB = A837F1357LDPIncB ;
            Z838F1357LDPRemuSuj = A838F1357LDPRemuSuj ;
            Z839F1357LDPCantHijIncap = A839F1357LDPCantHijIncap ;
            Z840F1357LDPHijosIncapImp = A840F1357LDPHijosIncapImp ;
            Z841F1357LDPEspIncremen1 = A841F1357LDPEspIncremen1 ;
            Z842F1357LDPEspIncremen2 = A842F1357LDPEspIncremen2 ;
            Z945F1357LDPCantHij100PC = A945F1357LDPCantHij100PC ;
            Z946F1357ldpcAntHijIncap100pc = A946F1357ldpcAntHijIncap100pc ;
            Z947F1357LDPcantHijMay18 = A947F1357LDPcantHijMay18 ;
            Z948F1357LDPcantHijMay18_100pc = A948F1357LDPcantHijMay18_100pc ;
         }
      }
      if ( GX_JID == -2 )
      {
         Z862F1357LDPTipReg = A862F1357LDPTipReg ;
         Z827F1357LDPGNI = A827F1357LDPGNI ;
         Z828F1357LDPEspecial = A828F1357LDPEspecial ;
         Z829F1357LDPEspecifica = A829F1357LDPEspecifica ;
         Z830F1357LDPConyuge = A830F1357LDPConyuge ;
         Z831F1357LDPCantHijos = A831F1357LDPCantHijos ;
         Z832F1357LDPHijosImporte = A832F1357LDPHijosImporte ;
         Z833F1357LDPTotalFami = A833F1357LDPTotalFami ;
         Z834F1357LDPTotalArt30 = A834F1357LDPTotalArt30 ;
         Z835F1357LDPSujAntes = A835F1357LDPSujAntes ;
         Z836F1357LDPIncA = A836F1357LDPIncA ;
         Z837F1357LDPIncB = A837F1357LDPIncB ;
         Z838F1357LDPRemuSuj = A838F1357LDPRemuSuj ;
         Z839F1357LDPCantHijIncap = A839F1357LDPCantHijIncap ;
         Z840F1357LDPHijosIncapImp = A840F1357LDPHijosIncapImp ;
         Z841F1357LDPEspIncremen1 = A841F1357LDPEspIncremen1 ;
         Z842F1357LDPEspIncremen2 = A842F1357LDPEspIncremen2 ;
         Z945F1357LDPCantHij100PC = A945F1357LDPCantHij100PC ;
         Z946F1357ldpcAntHijIncap100pc = A946F1357ldpcAntHijIncap100pc ;
         Z947F1357LDPcantHijMay18 = A947F1357LDPcantHijMay18 ;
         Z948F1357LDPcantHijMay18_100pc = A948F1357LDPcantHijMay18_100pc ;
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

   public void load2J94( )
   {
      /* Using cursor T002J6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A862F1357LDPTipReg});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound94 = (short)(1) ;
         A827F1357LDPGNI = T002J6_A827F1357LDPGNI[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A827F1357LDPGNI", GXutil.ltrimstr( A827F1357LDPGNI, 16, 2));
         A828F1357LDPEspecial = T002J6_A828F1357LDPEspecial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A828F1357LDPEspecial", GXutil.ltrimstr( A828F1357LDPEspecial, 16, 2));
         A829F1357LDPEspecifica = T002J6_A829F1357LDPEspecifica[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A829F1357LDPEspecifica", GXutil.ltrimstr( A829F1357LDPEspecifica, 16, 2));
         A830F1357LDPConyuge = T002J6_A830F1357LDPConyuge[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A830F1357LDPConyuge", GXutil.ltrimstr( A830F1357LDPConyuge, 16, 2));
         A831F1357LDPCantHijos = T002J6_A831F1357LDPCantHijos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A831F1357LDPCantHijos", GXutil.ltrimstr( A831F1357LDPCantHijos, 16, 2));
         A832F1357LDPHijosImporte = T002J6_A832F1357LDPHijosImporte[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A832F1357LDPHijosImporte", GXutil.ltrimstr( A832F1357LDPHijosImporte, 16, 2));
         A833F1357LDPTotalFami = T002J6_A833F1357LDPTotalFami[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A833F1357LDPTotalFami", GXutil.ltrimstr( A833F1357LDPTotalFami, 16, 2));
         A834F1357LDPTotalArt30 = T002J6_A834F1357LDPTotalArt30[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A834F1357LDPTotalArt30", GXutil.ltrimstr( A834F1357LDPTotalArt30, 16, 2));
         A835F1357LDPSujAntes = T002J6_A835F1357LDPSujAntes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A835F1357LDPSujAntes", GXutil.ltrimstr( A835F1357LDPSujAntes, 16, 2));
         A836F1357LDPIncA = T002J6_A836F1357LDPIncA[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A836F1357LDPIncA", GXutil.ltrimstr( A836F1357LDPIncA, 16, 2));
         A837F1357LDPIncB = T002J6_A837F1357LDPIncB[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A837F1357LDPIncB", GXutil.ltrimstr( A837F1357LDPIncB, 16, 2));
         A838F1357LDPRemuSuj = T002J6_A838F1357LDPRemuSuj[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A838F1357LDPRemuSuj", GXutil.ltrimstr( A838F1357LDPRemuSuj, 16, 2));
         A839F1357LDPCantHijIncap = T002J6_A839F1357LDPCantHijIncap[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A839F1357LDPCantHijIncap", GXutil.ltrimstr( A839F1357LDPCantHijIncap, 16, 2));
         A840F1357LDPHijosIncapImp = T002J6_A840F1357LDPHijosIncapImp[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A840F1357LDPHijosIncapImp", GXutil.ltrimstr( A840F1357LDPHijosIncapImp, 16, 2));
         A841F1357LDPEspIncremen1 = T002J6_A841F1357LDPEspIncremen1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A841F1357LDPEspIncremen1", GXutil.ltrimstr( A841F1357LDPEspIncremen1, 16, 2));
         A842F1357LDPEspIncremen2 = T002J6_A842F1357LDPEspIncremen2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A842F1357LDPEspIncremen2", GXutil.ltrimstr( A842F1357LDPEspIncremen2, 16, 2));
         A945F1357LDPCantHij100PC = T002J6_A945F1357LDPCantHij100PC[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A945F1357LDPCantHij100PC", GXutil.ltrimstr( A945F1357LDPCantHij100PC, 16, 2));
         A946F1357ldpcAntHijIncap100pc = T002J6_A946F1357ldpcAntHijIncap100pc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A946F1357ldpcAntHijIncap100pc", GXutil.ltrimstr( A946F1357ldpcAntHijIncap100pc, 16, 2));
         A947F1357LDPcantHijMay18 = T002J6_A947F1357LDPcantHijMay18[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A947F1357LDPcantHijMay18", GXutil.ltrimstr( A947F1357LDPcantHijMay18, 16, 2));
         A948F1357LDPcantHijMay18_100pc = T002J6_A948F1357LDPcantHijMay18_100pc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A948F1357LDPcantHijMay18_100pc", GXutil.ltrimstr( A948F1357LDPcantHijMay18_100pc, 16, 2));
         zm2J94( -2) ;
      }
      pr_default.close(4);
      onLoadActions2J94( ) ;
   }

   public void onLoadActions2J94( )
   {
   }

   public void checkExtendedTable2J94( )
   {
      nIsDirty_94 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      if ( ! ( ( A784F1357CTipoPre == 1 ) || ( A784F1357CTipoPre == 2 ) || ( A784F1357CTipoPre == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "F1357 CTipo Pre", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "F1357CTIPOPRE");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbF1357CTipoPre.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T002J5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Formulario F1357", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "F1357CSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
      /* Using cursor T002J4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
   }

   public void closeExtendedTableCursors2J94( )
   {
      pr_default.close(3);
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_4( int A3CliCod ,
                         short A1EmpCod ,
                         byte A784F1357CTipoPre ,
                         String A777F1357CPer ,
                         byte A778F1357CSec )
   {
      /* Using cursor T002J7 */
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

   public void gxload_3( int A3CliCod ,
                         short A1EmpCod ,
                         int A6LegNumero )
   {
      /* Using cursor T002J8 */
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

   public void getKey2J94( )
   {
      /* Using cursor T002J9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A862F1357LDPTipReg});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound94 = (short)(1) ;
      }
      else
      {
         RcdFound94 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T002J3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A862F1357LDPTipReg});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm2J94( 2) ;
         RcdFound94 = (short)(1) ;
         A862F1357LDPTipReg = T002J3_A862F1357LDPTipReg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A862F1357LDPTipReg", A862F1357LDPTipReg);
         A827F1357LDPGNI = T002J3_A827F1357LDPGNI[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A827F1357LDPGNI", GXutil.ltrimstr( A827F1357LDPGNI, 16, 2));
         A828F1357LDPEspecial = T002J3_A828F1357LDPEspecial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A828F1357LDPEspecial", GXutil.ltrimstr( A828F1357LDPEspecial, 16, 2));
         A829F1357LDPEspecifica = T002J3_A829F1357LDPEspecifica[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A829F1357LDPEspecifica", GXutil.ltrimstr( A829F1357LDPEspecifica, 16, 2));
         A830F1357LDPConyuge = T002J3_A830F1357LDPConyuge[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A830F1357LDPConyuge", GXutil.ltrimstr( A830F1357LDPConyuge, 16, 2));
         A831F1357LDPCantHijos = T002J3_A831F1357LDPCantHijos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A831F1357LDPCantHijos", GXutil.ltrimstr( A831F1357LDPCantHijos, 16, 2));
         A832F1357LDPHijosImporte = T002J3_A832F1357LDPHijosImporte[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A832F1357LDPHijosImporte", GXutil.ltrimstr( A832F1357LDPHijosImporte, 16, 2));
         A833F1357LDPTotalFami = T002J3_A833F1357LDPTotalFami[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A833F1357LDPTotalFami", GXutil.ltrimstr( A833F1357LDPTotalFami, 16, 2));
         A834F1357LDPTotalArt30 = T002J3_A834F1357LDPTotalArt30[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A834F1357LDPTotalArt30", GXutil.ltrimstr( A834F1357LDPTotalArt30, 16, 2));
         A835F1357LDPSujAntes = T002J3_A835F1357LDPSujAntes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A835F1357LDPSujAntes", GXutil.ltrimstr( A835F1357LDPSujAntes, 16, 2));
         A836F1357LDPIncA = T002J3_A836F1357LDPIncA[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A836F1357LDPIncA", GXutil.ltrimstr( A836F1357LDPIncA, 16, 2));
         A837F1357LDPIncB = T002J3_A837F1357LDPIncB[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A837F1357LDPIncB", GXutil.ltrimstr( A837F1357LDPIncB, 16, 2));
         A838F1357LDPRemuSuj = T002J3_A838F1357LDPRemuSuj[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A838F1357LDPRemuSuj", GXutil.ltrimstr( A838F1357LDPRemuSuj, 16, 2));
         A839F1357LDPCantHijIncap = T002J3_A839F1357LDPCantHijIncap[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A839F1357LDPCantHijIncap", GXutil.ltrimstr( A839F1357LDPCantHijIncap, 16, 2));
         A840F1357LDPHijosIncapImp = T002J3_A840F1357LDPHijosIncapImp[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A840F1357LDPHijosIncapImp", GXutil.ltrimstr( A840F1357LDPHijosIncapImp, 16, 2));
         A841F1357LDPEspIncremen1 = T002J3_A841F1357LDPEspIncremen1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A841F1357LDPEspIncremen1", GXutil.ltrimstr( A841F1357LDPEspIncremen1, 16, 2));
         A842F1357LDPEspIncremen2 = T002J3_A842F1357LDPEspIncremen2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A842F1357LDPEspIncremen2", GXutil.ltrimstr( A842F1357LDPEspIncremen2, 16, 2));
         A945F1357LDPCantHij100PC = T002J3_A945F1357LDPCantHij100PC[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A945F1357LDPCantHij100PC", GXutil.ltrimstr( A945F1357LDPCantHij100PC, 16, 2));
         A946F1357ldpcAntHijIncap100pc = T002J3_A946F1357ldpcAntHijIncap100pc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A946F1357ldpcAntHijIncap100pc", GXutil.ltrimstr( A946F1357ldpcAntHijIncap100pc, 16, 2));
         A947F1357LDPcantHijMay18 = T002J3_A947F1357LDPcantHijMay18[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A947F1357LDPcantHijMay18", GXutil.ltrimstr( A947F1357LDPcantHijMay18, 16, 2));
         A948F1357LDPcantHijMay18_100pc = T002J3_A948F1357LDPcantHijMay18_100pc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A948F1357LDPcantHijMay18_100pc", GXutil.ltrimstr( A948F1357LDPcantHijMay18_100pc, 16, 2));
         A3CliCod = T002J3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002J3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T002J3_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A784F1357CTipoPre = T002J3_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002J3_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002J3_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z784F1357CTipoPre = A784F1357CTipoPre ;
         Z777F1357CPer = A777F1357CPer ;
         Z778F1357CSec = A778F1357CSec ;
         Z6LegNumero = A6LegNumero ;
         Z862F1357LDPTipReg = A862F1357LDPTipReg ;
         sMode94 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load2J94( ) ;
         if ( AnyError == 1 )
         {
            RcdFound94 = (short)(0) ;
            initializeNonKey2J94( ) ;
         }
         Gx_mode = sMode94 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound94 = (short)(0) ;
         initializeNonKey2J94( ) ;
         sMode94 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode94 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey2J94( ) ;
      if ( RcdFound94 == 0 )
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
      RcdFound94 = (short)(0) ;
      /* Using cursor T002J10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A784F1357CTipoPre), Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A777F1357CPer, A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A778F1357CSec), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A862F1357LDPTipReg});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T002J10_A3CliCod[0] < A3CliCod ) || ( T002J10_A3CliCod[0] == A3CliCod ) && ( T002J10_A1EmpCod[0] < A1EmpCod ) || ( T002J10_A1EmpCod[0] == A1EmpCod ) && ( T002J10_A3CliCod[0] == A3CliCod ) && ( T002J10_A784F1357CTipoPre[0] < A784F1357CTipoPre ) || ( T002J10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002J10_A1EmpCod[0] == A1EmpCod ) && ( T002J10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002J10_A777F1357CPer[0], A777F1357CPer) < 0 ) || ( GXutil.strcmp(T002J10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002J10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002J10_A1EmpCod[0] == A1EmpCod ) && ( T002J10_A3CliCod[0] == A3CliCod ) && ( T002J10_A778F1357CSec[0] < A778F1357CSec ) || ( T002J10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002J10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002J10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002J10_A1EmpCod[0] == A1EmpCod ) && ( T002J10_A3CliCod[0] == A3CliCod ) && ( T002J10_A6LegNumero[0] < A6LegNumero ) || ( T002J10_A6LegNumero[0] == A6LegNumero ) && ( T002J10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002J10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002J10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002J10_A1EmpCod[0] == A1EmpCod ) && ( T002J10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002J10_A862F1357LDPTipReg[0], A862F1357LDPTipReg) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T002J10_A3CliCod[0] > A3CliCod ) || ( T002J10_A3CliCod[0] == A3CliCod ) && ( T002J10_A1EmpCod[0] > A1EmpCod ) || ( T002J10_A1EmpCod[0] == A1EmpCod ) && ( T002J10_A3CliCod[0] == A3CliCod ) && ( T002J10_A784F1357CTipoPre[0] > A784F1357CTipoPre ) || ( T002J10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002J10_A1EmpCod[0] == A1EmpCod ) && ( T002J10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002J10_A777F1357CPer[0], A777F1357CPer) > 0 ) || ( GXutil.strcmp(T002J10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002J10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002J10_A1EmpCod[0] == A1EmpCod ) && ( T002J10_A3CliCod[0] == A3CliCod ) && ( T002J10_A778F1357CSec[0] > A778F1357CSec ) || ( T002J10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002J10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002J10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002J10_A1EmpCod[0] == A1EmpCod ) && ( T002J10_A3CliCod[0] == A3CliCod ) && ( T002J10_A6LegNumero[0] > A6LegNumero ) || ( T002J10_A6LegNumero[0] == A6LegNumero ) && ( T002J10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002J10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002J10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002J10_A1EmpCod[0] == A1EmpCod ) && ( T002J10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002J10_A862F1357LDPTipReg[0], A862F1357LDPTipReg) > 0 ) ) )
         {
            A3CliCod = T002J10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002J10_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A784F1357CTipoPre = T002J10_A784F1357CTipoPre[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
            A777F1357CPer = T002J10_A777F1357CPer[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
            A778F1357CSec = T002J10_A778F1357CSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
            A6LegNumero = T002J10_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A862F1357LDPTipReg = T002J10_A862F1357LDPTipReg[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A862F1357LDPTipReg", A862F1357LDPTipReg);
            RcdFound94 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound94 = (short)(0) ;
      /* Using cursor T002J11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A784F1357CTipoPre), Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A777F1357CPer, A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A778F1357CSec), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A862F1357LDPTipReg});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T002J11_A3CliCod[0] > A3CliCod ) || ( T002J11_A3CliCod[0] == A3CliCod ) && ( T002J11_A1EmpCod[0] > A1EmpCod ) || ( T002J11_A1EmpCod[0] == A1EmpCod ) && ( T002J11_A3CliCod[0] == A3CliCod ) && ( T002J11_A784F1357CTipoPre[0] > A784F1357CTipoPre ) || ( T002J11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002J11_A1EmpCod[0] == A1EmpCod ) && ( T002J11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002J11_A777F1357CPer[0], A777F1357CPer) > 0 ) || ( GXutil.strcmp(T002J11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002J11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002J11_A1EmpCod[0] == A1EmpCod ) && ( T002J11_A3CliCod[0] == A3CliCod ) && ( T002J11_A778F1357CSec[0] > A778F1357CSec ) || ( T002J11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002J11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002J11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002J11_A1EmpCod[0] == A1EmpCod ) && ( T002J11_A3CliCod[0] == A3CliCod ) && ( T002J11_A6LegNumero[0] > A6LegNumero ) || ( T002J11_A6LegNumero[0] == A6LegNumero ) && ( T002J11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002J11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002J11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002J11_A1EmpCod[0] == A1EmpCod ) && ( T002J11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002J11_A862F1357LDPTipReg[0], A862F1357LDPTipReg) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T002J11_A3CliCod[0] < A3CliCod ) || ( T002J11_A3CliCod[0] == A3CliCod ) && ( T002J11_A1EmpCod[0] < A1EmpCod ) || ( T002J11_A1EmpCod[0] == A1EmpCod ) && ( T002J11_A3CliCod[0] == A3CliCod ) && ( T002J11_A784F1357CTipoPre[0] < A784F1357CTipoPre ) || ( T002J11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002J11_A1EmpCod[0] == A1EmpCod ) && ( T002J11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002J11_A777F1357CPer[0], A777F1357CPer) < 0 ) || ( GXutil.strcmp(T002J11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002J11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002J11_A1EmpCod[0] == A1EmpCod ) && ( T002J11_A3CliCod[0] == A3CliCod ) && ( T002J11_A778F1357CSec[0] < A778F1357CSec ) || ( T002J11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002J11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002J11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002J11_A1EmpCod[0] == A1EmpCod ) && ( T002J11_A3CliCod[0] == A3CliCod ) && ( T002J11_A6LegNumero[0] < A6LegNumero ) || ( T002J11_A6LegNumero[0] == A6LegNumero ) && ( T002J11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002J11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002J11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002J11_A1EmpCod[0] == A1EmpCod ) && ( T002J11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002J11_A862F1357LDPTipReg[0], A862F1357LDPTipReg) < 0 ) ) )
         {
            A3CliCod = T002J11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002J11_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A784F1357CTipoPre = T002J11_A784F1357CTipoPre[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
            A777F1357CPer = T002J11_A777F1357CPer[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
            A778F1357CSec = T002J11_A778F1357CSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
            A6LegNumero = T002J11_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A862F1357LDPTipReg = T002J11_A862F1357LDPTipReg[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A862F1357LDPTipReg", A862F1357LDPTipReg);
            RcdFound94 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2J94( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert2J94( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound94 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A862F1357LDPTipReg, Z862F1357LDPTipReg) != 0 ) )
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
               A862F1357LDPTipReg = Z862F1357LDPTipReg ;
               httpContext.ajax_rsp_assign_attri("", false, "A862F1357LDPTipReg", A862F1357LDPTipReg);
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
               update2J94( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A862F1357LDPTipReg, Z862F1357LDPTipReg) != 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert2J94( ) ;
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
                  insert2J94( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A862F1357LDPTipReg, Z862F1357LDPTipReg) != 0 ) )
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
         A862F1357LDPTipReg = Z862F1357LDPTipReg ;
         httpContext.ajax_rsp_assign_attri("", false, "A862F1357LDPTipReg", A862F1357LDPTipReg);
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
      if ( RcdFound94 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtF1357LDPGNI_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart2J94( ) ;
      if ( RcdFound94 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtF1357LDPGNI_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd2J94( ) ;
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
      if ( RcdFound94 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtF1357LDPGNI_Internalname ;
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
      if ( RcdFound94 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtF1357LDPGNI_Internalname ;
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
      scanStart2J94( ) ;
      if ( RcdFound94 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound94 != 0 )
         {
            scanNext2J94( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtF1357LDPGNI_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd2J94( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency2J94( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002J2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A862F1357LDPTipReg});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"F1357LDedPer"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z827F1357LDPGNI, T002J2_A827F1357LDPGNI[0]) != 0 ) || ( DecimalUtil.compareTo(Z828F1357LDPEspecial, T002J2_A828F1357LDPEspecial[0]) != 0 ) || ( DecimalUtil.compareTo(Z829F1357LDPEspecifica, T002J2_A829F1357LDPEspecifica[0]) != 0 ) || ( DecimalUtil.compareTo(Z830F1357LDPConyuge, T002J2_A830F1357LDPConyuge[0]) != 0 ) || ( DecimalUtil.compareTo(Z831F1357LDPCantHijos, T002J2_A831F1357LDPCantHijos[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z832F1357LDPHijosImporte, T002J2_A832F1357LDPHijosImporte[0]) != 0 ) || ( DecimalUtil.compareTo(Z833F1357LDPTotalFami, T002J2_A833F1357LDPTotalFami[0]) != 0 ) || ( DecimalUtil.compareTo(Z834F1357LDPTotalArt30, T002J2_A834F1357LDPTotalArt30[0]) != 0 ) || ( DecimalUtil.compareTo(Z835F1357LDPSujAntes, T002J2_A835F1357LDPSujAntes[0]) != 0 ) || ( DecimalUtil.compareTo(Z836F1357LDPIncA, T002J2_A836F1357LDPIncA[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z837F1357LDPIncB, T002J2_A837F1357LDPIncB[0]) != 0 ) || ( DecimalUtil.compareTo(Z838F1357LDPRemuSuj, T002J2_A838F1357LDPRemuSuj[0]) != 0 ) || ( DecimalUtil.compareTo(Z839F1357LDPCantHijIncap, T002J2_A839F1357LDPCantHijIncap[0]) != 0 ) || ( DecimalUtil.compareTo(Z840F1357LDPHijosIncapImp, T002J2_A840F1357LDPHijosIncapImp[0]) != 0 ) || ( DecimalUtil.compareTo(Z841F1357LDPEspIncremen1, T002J2_A841F1357LDPEspIncremen1[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z842F1357LDPEspIncremen2, T002J2_A842F1357LDPEspIncremen2[0]) != 0 ) || ( DecimalUtil.compareTo(Z945F1357LDPCantHij100PC, T002J2_A945F1357LDPCantHij100PC[0]) != 0 ) || ( DecimalUtil.compareTo(Z946F1357ldpcAntHijIncap100pc, T002J2_A946F1357ldpcAntHijIncap100pc[0]) != 0 ) || ( DecimalUtil.compareTo(Z947F1357LDPcantHijMay18, T002J2_A947F1357LDPcantHijMay18[0]) != 0 ) || ( DecimalUtil.compareTo(Z948F1357LDPcantHijMay18_100pc, T002J2_A948F1357LDPcantHijMay18_100pc[0]) != 0 ) )
         {
            if ( DecimalUtil.compareTo(Z827F1357LDPGNI, T002J2_A827F1357LDPGNI[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPGNI");
               GXutil.writeLogRaw("Old: ",Z827F1357LDPGNI);
               GXutil.writeLogRaw("Current: ",T002J2_A827F1357LDPGNI[0]);
            }
            if ( DecimalUtil.compareTo(Z828F1357LDPEspecial, T002J2_A828F1357LDPEspecial[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPEspecial");
               GXutil.writeLogRaw("Old: ",Z828F1357LDPEspecial);
               GXutil.writeLogRaw("Current: ",T002J2_A828F1357LDPEspecial[0]);
            }
            if ( DecimalUtil.compareTo(Z829F1357LDPEspecifica, T002J2_A829F1357LDPEspecifica[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPEspecifica");
               GXutil.writeLogRaw("Old: ",Z829F1357LDPEspecifica);
               GXutil.writeLogRaw("Current: ",T002J2_A829F1357LDPEspecifica[0]);
            }
            if ( DecimalUtil.compareTo(Z830F1357LDPConyuge, T002J2_A830F1357LDPConyuge[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPConyuge");
               GXutil.writeLogRaw("Old: ",Z830F1357LDPConyuge);
               GXutil.writeLogRaw("Current: ",T002J2_A830F1357LDPConyuge[0]);
            }
            if ( DecimalUtil.compareTo(Z831F1357LDPCantHijos, T002J2_A831F1357LDPCantHijos[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPCantHijos");
               GXutil.writeLogRaw("Old: ",Z831F1357LDPCantHijos);
               GXutil.writeLogRaw("Current: ",T002J2_A831F1357LDPCantHijos[0]);
            }
            if ( DecimalUtil.compareTo(Z832F1357LDPHijosImporte, T002J2_A832F1357LDPHijosImporte[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPHijosImporte");
               GXutil.writeLogRaw("Old: ",Z832F1357LDPHijosImporte);
               GXutil.writeLogRaw("Current: ",T002J2_A832F1357LDPHijosImporte[0]);
            }
            if ( DecimalUtil.compareTo(Z833F1357LDPTotalFami, T002J2_A833F1357LDPTotalFami[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPTotalFami");
               GXutil.writeLogRaw("Old: ",Z833F1357LDPTotalFami);
               GXutil.writeLogRaw("Current: ",T002J2_A833F1357LDPTotalFami[0]);
            }
            if ( DecimalUtil.compareTo(Z834F1357LDPTotalArt30, T002J2_A834F1357LDPTotalArt30[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPTotalArt30");
               GXutil.writeLogRaw("Old: ",Z834F1357LDPTotalArt30);
               GXutil.writeLogRaw("Current: ",T002J2_A834F1357LDPTotalArt30[0]);
            }
            if ( DecimalUtil.compareTo(Z835F1357LDPSujAntes, T002J2_A835F1357LDPSujAntes[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPSujAntes");
               GXutil.writeLogRaw("Old: ",Z835F1357LDPSujAntes);
               GXutil.writeLogRaw("Current: ",T002J2_A835F1357LDPSujAntes[0]);
            }
            if ( DecimalUtil.compareTo(Z836F1357LDPIncA, T002J2_A836F1357LDPIncA[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPIncA");
               GXutil.writeLogRaw("Old: ",Z836F1357LDPIncA);
               GXutil.writeLogRaw("Current: ",T002J2_A836F1357LDPIncA[0]);
            }
            if ( DecimalUtil.compareTo(Z837F1357LDPIncB, T002J2_A837F1357LDPIncB[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPIncB");
               GXutil.writeLogRaw("Old: ",Z837F1357LDPIncB);
               GXutil.writeLogRaw("Current: ",T002J2_A837F1357LDPIncB[0]);
            }
            if ( DecimalUtil.compareTo(Z838F1357LDPRemuSuj, T002J2_A838F1357LDPRemuSuj[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPRemuSuj");
               GXutil.writeLogRaw("Old: ",Z838F1357LDPRemuSuj);
               GXutil.writeLogRaw("Current: ",T002J2_A838F1357LDPRemuSuj[0]);
            }
            if ( DecimalUtil.compareTo(Z839F1357LDPCantHijIncap, T002J2_A839F1357LDPCantHijIncap[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPCantHijIncap");
               GXutil.writeLogRaw("Old: ",Z839F1357LDPCantHijIncap);
               GXutil.writeLogRaw("Current: ",T002J2_A839F1357LDPCantHijIncap[0]);
            }
            if ( DecimalUtil.compareTo(Z840F1357LDPHijosIncapImp, T002J2_A840F1357LDPHijosIncapImp[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPHijosIncapImp");
               GXutil.writeLogRaw("Old: ",Z840F1357LDPHijosIncapImp);
               GXutil.writeLogRaw("Current: ",T002J2_A840F1357LDPHijosIncapImp[0]);
            }
            if ( DecimalUtil.compareTo(Z841F1357LDPEspIncremen1, T002J2_A841F1357LDPEspIncremen1[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPEspIncremen1");
               GXutil.writeLogRaw("Old: ",Z841F1357LDPEspIncremen1);
               GXutil.writeLogRaw("Current: ",T002J2_A841F1357LDPEspIncremen1[0]);
            }
            if ( DecimalUtil.compareTo(Z842F1357LDPEspIncremen2, T002J2_A842F1357LDPEspIncremen2[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPEspIncremen2");
               GXutil.writeLogRaw("Old: ",Z842F1357LDPEspIncremen2);
               GXutil.writeLogRaw("Current: ",T002J2_A842F1357LDPEspIncremen2[0]);
            }
            if ( DecimalUtil.compareTo(Z945F1357LDPCantHij100PC, T002J2_A945F1357LDPCantHij100PC[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPCantHij100PC");
               GXutil.writeLogRaw("Old: ",Z945F1357LDPCantHij100PC);
               GXutil.writeLogRaw("Current: ",T002J2_A945F1357LDPCantHij100PC[0]);
            }
            if ( DecimalUtil.compareTo(Z946F1357ldpcAntHijIncap100pc, T002J2_A946F1357ldpcAntHijIncap100pc[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357ldpcAntHijIncap100pc");
               GXutil.writeLogRaw("Old: ",Z946F1357ldpcAntHijIncap100pc);
               GXutil.writeLogRaw("Current: ",T002J2_A946F1357ldpcAntHijIncap100pc[0]);
            }
            if ( DecimalUtil.compareTo(Z947F1357LDPcantHijMay18, T002J2_A947F1357LDPcantHijMay18[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPcantHijMay18");
               GXutil.writeLogRaw("Old: ",Z947F1357LDPcantHijMay18);
               GXutil.writeLogRaw("Current: ",T002J2_A947F1357LDPcantHijMay18[0]);
            }
            if ( DecimalUtil.compareTo(Z948F1357LDPcantHijMay18_100pc, T002J2_A948F1357LDPcantHijMay18_100pc[0]) != 0 )
            {
               GXutil.writeLogln("f1357ldedper:[seudo value changed for attri]"+"F1357LDPcantHijMay18_100pc");
               GXutil.writeLogRaw("Old: ",Z948F1357LDPcantHijMay18_100pc);
               GXutil.writeLogRaw("Current: ",T002J2_A948F1357LDPcantHijMay18_100pc[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"F1357LDedPer"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2J94( )
   {
      beforeValidate2J94( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2J94( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2J94( 0) ;
         checkOptimisticConcurrency2J94( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2J94( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2J94( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002J12 */
                  pr_default.execute(10, new Object[] {A862F1357LDPTipReg, A827F1357LDPGNI, A828F1357LDPEspecial, A829F1357LDPEspecifica, A830F1357LDPConyuge, A831F1357LDPCantHijos, A832F1357LDPHijosImporte, A833F1357LDPTotalFami, A834F1357LDPTotalArt30, A835F1357LDPSujAntes, A836F1357LDPIncA, A837F1357LDPIncB, A838F1357LDPRemuSuj, A839F1357LDPCantHijIncap, A840F1357LDPHijosIncapImp, A841F1357LDPEspIncremen1, A842F1357LDPEspIncremen2, A945F1357LDPCantHij100PC, A946F1357ldpcAntHijIncap100pc, A947F1357LDPcantHijMay18, A948F1357LDPcantHijMay18_100pc, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357LDedPer");
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
                        resetCaption2J0( ) ;
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
            load2J94( ) ;
         }
         endLevel2J94( ) ;
      }
      closeExtendedTableCursors2J94( ) ;
   }

   public void update2J94( )
   {
      beforeValidate2J94( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2J94( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2J94( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2J94( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2J94( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002J13 */
                  pr_default.execute(11, new Object[] {A827F1357LDPGNI, A828F1357LDPEspecial, A829F1357LDPEspecifica, A830F1357LDPConyuge, A831F1357LDPCantHijos, A832F1357LDPHijosImporte, A833F1357LDPTotalFami, A834F1357LDPTotalArt30, A835F1357LDPSujAntes, A836F1357LDPIncA, A837F1357LDPIncB, A838F1357LDPRemuSuj, A839F1357LDPCantHijIncap, A840F1357LDPHijosIncapImp, A841F1357LDPEspIncremen1, A842F1357LDPEspIncremen2, A945F1357LDPCantHij100PC, A946F1357ldpcAntHijIncap100pc, A947F1357LDPcantHijMay18, A948F1357LDPcantHijMay18_100pc, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A862F1357LDPTipReg});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357LDedPer");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"F1357LDedPer"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2J94( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption2J0( ) ;
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
         endLevel2J94( ) ;
      }
      closeExtendedTableCursors2J94( ) ;
   }

   public void deferredUpdate2J94( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate2J94( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2J94( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2J94( ) ;
         afterConfirm2J94( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2J94( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002J14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A862F1357LDPTipReg});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357LDedPer");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound94 == 0 )
                     {
                        initAll2J94( ) ;
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
                     resetCaption2J0( ) ;
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
      sMode94 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2J94( ) ;
      Gx_mode = sMode94 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2J94( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel2J94( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2J94( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "f1357ldedper");
         if ( AnyError == 0 )
         {
            confirmValues2J0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "f1357ldedper");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2J94( )
   {
      /* Using cursor T002J15 */
      pr_default.execute(13);
      RcdFound94 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound94 = (short)(1) ;
         A3CliCod = T002J15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002J15_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A784F1357CTipoPre = T002J15_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002J15_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002J15_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         A6LegNumero = T002J15_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A862F1357LDPTipReg = T002J15_A862F1357LDPTipReg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A862F1357LDPTipReg", A862F1357LDPTipReg);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2J94( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound94 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound94 = (short)(1) ;
         A3CliCod = T002J15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002J15_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A784F1357CTipoPre = T002J15_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002J15_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002J15_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         A6LegNumero = T002J15_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A862F1357LDPTipReg = T002J15_A862F1357LDPTipReg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A862F1357LDPTipReg", A862F1357LDPTipReg);
      }
   }

   public void scanEnd2J94( )
   {
      pr_default.close(13);
   }

   public void afterConfirm2J94( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2J94( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2J94( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2J94( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2J94( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2J94( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2J94( )
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
      edtF1357LDPTipReg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPTipReg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPTipReg_Enabled), 5, 0), true);
      edtF1357LDPGNI_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPGNI_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPGNI_Enabled), 5, 0), true);
      edtF1357LDPEspecial_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPEspecial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPEspecial_Enabled), 5, 0), true);
      edtF1357LDPEspecifica_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPEspecifica_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPEspecifica_Enabled), 5, 0), true);
      edtF1357LDPConyuge_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPConyuge_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPConyuge_Enabled), 5, 0), true);
      edtF1357LDPCantHijos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPCantHijos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPCantHijos_Enabled), 5, 0), true);
      edtF1357LDPHijosImporte_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPHijosImporte_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPHijosImporte_Enabled), 5, 0), true);
      edtF1357LDPTotalFami_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPTotalFami_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPTotalFami_Enabled), 5, 0), true);
      edtF1357LDPTotalArt30_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPTotalArt30_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPTotalArt30_Enabled), 5, 0), true);
      edtF1357LDPSujAntes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPSujAntes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPSujAntes_Enabled), 5, 0), true);
      edtF1357LDPIncA_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPIncA_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPIncA_Enabled), 5, 0), true);
      edtF1357LDPIncB_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPIncB_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPIncB_Enabled), 5, 0), true);
      edtF1357LDPRemuSuj_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPRemuSuj_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPRemuSuj_Enabled), 5, 0), true);
      edtF1357LDPCantHijIncap_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPCantHijIncap_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPCantHijIncap_Enabled), 5, 0), true);
      edtF1357LDPHijosIncapImp_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPHijosIncapImp_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPHijosIncapImp_Enabled), 5, 0), true);
      edtF1357LDPEspIncremen1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPEspIncremen1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPEspIncremen1_Enabled), 5, 0), true);
      edtF1357LDPEspIncremen2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPEspIncremen2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPEspIncremen2_Enabled), 5, 0), true);
      edtF1357LDPCantHij100PC_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPCantHij100PC_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPCantHij100PC_Enabled), 5, 0), true);
      edtF1357ldpcAntHijIncap100pc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357ldpcAntHijIncap100pc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357ldpcAntHijIncap100pc_Enabled), 5, 0), true);
      edtF1357LDPcantHijMay18_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPcantHijMay18_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPcantHijMay18_Enabled), 5, 0), true);
      edtF1357LDPcantHijMay18_100pc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDPcantHijMay18_100pc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDPcantHijMay18_100pc_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes2J94( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues2J0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.f1357ldedper", new String[] {}, new String[] {}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "Z862F1357LDPTipReg", GXutil.rtrim( Z862F1357LDPTipReg));
      web.GxWebStd.gx_hidden_field( httpContext, "Z827F1357LDPGNI", GXutil.ltrim( localUtil.ntoc( Z827F1357LDPGNI, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z828F1357LDPEspecial", GXutil.ltrim( localUtil.ntoc( Z828F1357LDPEspecial, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z829F1357LDPEspecifica", GXutil.ltrim( localUtil.ntoc( Z829F1357LDPEspecifica, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z830F1357LDPConyuge", GXutil.ltrim( localUtil.ntoc( Z830F1357LDPConyuge, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z831F1357LDPCantHijos", GXutil.ltrim( localUtil.ntoc( Z831F1357LDPCantHijos, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z832F1357LDPHijosImporte", GXutil.ltrim( localUtil.ntoc( Z832F1357LDPHijosImporte, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z833F1357LDPTotalFami", GXutil.ltrim( localUtil.ntoc( Z833F1357LDPTotalFami, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z834F1357LDPTotalArt30", GXutil.ltrim( localUtil.ntoc( Z834F1357LDPTotalArt30, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z835F1357LDPSujAntes", GXutil.ltrim( localUtil.ntoc( Z835F1357LDPSujAntes, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z836F1357LDPIncA", GXutil.ltrim( localUtil.ntoc( Z836F1357LDPIncA, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z837F1357LDPIncB", GXutil.ltrim( localUtil.ntoc( Z837F1357LDPIncB, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z838F1357LDPRemuSuj", GXutil.ltrim( localUtil.ntoc( Z838F1357LDPRemuSuj, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z839F1357LDPCantHijIncap", GXutil.ltrim( localUtil.ntoc( Z839F1357LDPCantHijIncap, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z840F1357LDPHijosIncapImp", GXutil.ltrim( localUtil.ntoc( Z840F1357LDPHijosIncapImp, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z841F1357LDPEspIncremen1", GXutil.ltrim( localUtil.ntoc( Z841F1357LDPEspIncremen1, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z842F1357LDPEspIncremen2", GXutil.ltrim( localUtil.ntoc( Z842F1357LDPEspIncremen2, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z945F1357LDPCantHij100PC", GXutil.ltrim( localUtil.ntoc( Z945F1357LDPCantHij100PC, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z946F1357ldpcAntHijIncap100pc", GXutil.ltrim( localUtil.ntoc( Z946F1357ldpcAntHijIncap100pc, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z947F1357LDPcantHijMay18", GXutil.ltrim( localUtil.ntoc( Z947F1357LDPcantHijMay18, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z948F1357LDPcantHijMay18_100pc", GXutil.ltrim( localUtil.ntoc( Z948F1357LDPcantHijMay18_100pc, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      return formatLink("web.f1357ldedper", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "F1357LDedPer" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "F1357 LDed Per", "") ;
   }

   public void initializeNonKey2J94( )
   {
      A827F1357LDPGNI = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A827F1357LDPGNI", GXutil.ltrimstr( A827F1357LDPGNI, 16, 2));
      A828F1357LDPEspecial = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A828F1357LDPEspecial", GXutil.ltrimstr( A828F1357LDPEspecial, 16, 2));
      A829F1357LDPEspecifica = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A829F1357LDPEspecifica", GXutil.ltrimstr( A829F1357LDPEspecifica, 16, 2));
      A830F1357LDPConyuge = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A830F1357LDPConyuge", GXutil.ltrimstr( A830F1357LDPConyuge, 16, 2));
      A831F1357LDPCantHijos = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A831F1357LDPCantHijos", GXutil.ltrimstr( A831F1357LDPCantHijos, 16, 2));
      A832F1357LDPHijosImporte = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A832F1357LDPHijosImporte", GXutil.ltrimstr( A832F1357LDPHijosImporte, 16, 2));
      A833F1357LDPTotalFami = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A833F1357LDPTotalFami", GXutil.ltrimstr( A833F1357LDPTotalFami, 16, 2));
      A834F1357LDPTotalArt30 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A834F1357LDPTotalArt30", GXutil.ltrimstr( A834F1357LDPTotalArt30, 16, 2));
      A835F1357LDPSujAntes = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A835F1357LDPSujAntes", GXutil.ltrimstr( A835F1357LDPSujAntes, 16, 2));
      A836F1357LDPIncA = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A836F1357LDPIncA", GXutil.ltrimstr( A836F1357LDPIncA, 16, 2));
      A837F1357LDPIncB = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A837F1357LDPIncB", GXutil.ltrimstr( A837F1357LDPIncB, 16, 2));
      A838F1357LDPRemuSuj = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A838F1357LDPRemuSuj", GXutil.ltrimstr( A838F1357LDPRemuSuj, 16, 2));
      A839F1357LDPCantHijIncap = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A839F1357LDPCantHijIncap", GXutil.ltrimstr( A839F1357LDPCantHijIncap, 16, 2));
      A840F1357LDPHijosIncapImp = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A840F1357LDPHijosIncapImp", GXutil.ltrimstr( A840F1357LDPHijosIncapImp, 16, 2));
      A841F1357LDPEspIncremen1 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A841F1357LDPEspIncremen1", GXutil.ltrimstr( A841F1357LDPEspIncremen1, 16, 2));
      A842F1357LDPEspIncremen2 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A842F1357LDPEspIncremen2", GXutil.ltrimstr( A842F1357LDPEspIncremen2, 16, 2));
      A945F1357LDPCantHij100PC = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A945F1357LDPCantHij100PC", GXutil.ltrimstr( A945F1357LDPCantHij100PC, 16, 2));
      A946F1357ldpcAntHijIncap100pc = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A946F1357ldpcAntHijIncap100pc", GXutil.ltrimstr( A946F1357ldpcAntHijIncap100pc, 16, 2));
      A947F1357LDPcantHijMay18 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A947F1357LDPcantHijMay18", GXutil.ltrimstr( A947F1357LDPcantHijMay18, 16, 2));
      A948F1357LDPcantHijMay18_100pc = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A948F1357LDPcantHijMay18_100pc", GXutil.ltrimstr( A948F1357LDPcantHijMay18_100pc, 16, 2));
      Z827F1357LDPGNI = DecimalUtil.ZERO ;
      Z828F1357LDPEspecial = DecimalUtil.ZERO ;
      Z829F1357LDPEspecifica = DecimalUtil.ZERO ;
      Z830F1357LDPConyuge = DecimalUtil.ZERO ;
      Z831F1357LDPCantHijos = DecimalUtil.ZERO ;
      Z832F1357LDPHijosImporte = DecimalUtil.ZERO ;
      Z833F1357LDPTotalFami = DecimalUtil.ZERO ;
      Z834F1357LDPTotalArt30 = DecimalUtil.ZERO ;
      Z835F1357LDPSujAntes = DecimalUtil.ZERO ;
      Z836F1357LDPIncA = DecimalUtil.ZERO ;
      Z837F1357LDPIncB = DecimalUtil.ZERO ;
      Z838F1357LDPRemuSuj = DecimalUtil.ZERO ;
      Z839F1357LDPCantHijIncap = DecimalUtil.ZERO ;
      Z840F1357LDPHijosIncapImp = DecimalUtil.ZERO ;
      Z841F1357LDPEspIncremen1 = DecimalUtil.ZERO ;
      Z842F1357LDPEspIncremen2 = DecimalUtil.ZERO ;
      Z945F1357LDPCantHij100PC = DecimalUtil.ZERO ;
      Z946F1357ldpcAntHijIncap100pc = DecimalUtil.ZERO ;
      Z947F1357LDPcantHijMay18 = DecimalUtil.ZERO ;
      Z948F1357LDPcantHijMay18_100pc = DecimalUtil.ZERO ;
   }

   public void initAll2J94( )
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
      A862F1357LDPTipReg = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A862F1357LDPTipReg", A862F1357LDPTipReg);
      initializeNonKey2J94( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171339379", true, true);
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
      httpContext.AddJavascriptSource("f1357ldedper.js", "?2025171339380", false, true);
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
      edtF1357LDPTipReg_Internalname = "F1357LDPTIPREG" ;
      edtF1357LDPGNI_Internalname = "F1357LDPGNI" ;
      edtF1357LDPEspecial_Internalname = "F1357LDPESPECIAL" ;
      edtF1357LDPEspecifica_Internalname = "F1357LDPESPECIFICA" ;
      edtF1357LDPConyuge_Internalname = "F1357LDPCONYUGE" ;
      edtF1357LDPCantHijos_Internalname = "F1357LDPCANTHIJOS" ;
      edtF1357LDPHijosImporte_Internalname = "F1357LDPHIJOSIMPORTE" ;
      edtF1357LDPTotalFami_Internalname = "F1357LDPTOTALFAMI" ;
      edtF1357LDPTotalArt30_Internalname = "F1357LDPTOTALART30" ;
      edtF1357LDPSujAntes_Internalname = "F1357LDPSUJANTES" ;
      edtF1357LDPIncA_Internalname = "F1357LDPINCA" ;
      edtF1357LDPIncB_Internalname = "F1357LDPINCB" ;
      edtF1357LDPRemuSuj_Internalname = "F1357LDPREMUSUJ" ;
      edtF1357LDPCantHijIncap_Internalname = "F1357LDPCANTHIJINCAP" ;
      edtF1357LDPHijosIncapImp_Internalname = "F1357LDPHIJOSINCAPIMP" ;
      edtF1357LDPEspIncremen1_Internalname = "F1357LDPESPINCREMEN1" ;
      edtF1357LDPEspIncremen2_Internalname = "F1357LDPESPINCREMEN2" ;
      edtF1357LDPCantHij100PC_Internalname = "F1357LDPCANTHIJ100PC" ;
      edtF1357ldpcAntHijIncap100pc_Internalname = "F1357LDPCANTHIJINCAP100PC" ;
      edtF1357LDPcantHijMay18_Internalname = "F1357LDPCANTHIJMAY18" ;
      edtF1357LDPcantHijMay18_100pc_Internalname = "F1357LDPCANTHIJMAY18_100PC" ;
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
      Form.setCaption( httpContext.getMessage( "F1357 LDed Per", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtF1357LDPcantHijMay18_100pc_Jsonclick = "" ;
      edtF1357LDPcantHijMay18_100pc_Enabled = 1 ;
      edtF1357LDPcantHijMay18_Jsonclick = "" ;
      edtF1357LDPcantHijMay18_Enabled = 1 ;
      edtF1357ldpcAntHijIncap100pc_Jsonclick = "" ;
      edtF1357ldpcAntHijIncap100pc_Enabled = 1 ;
      edtF1357LDPCantHij100PC_Jsonclick = "" ;
      edtF1357LDPCantHij100PC_Enabled = 1 ;
      edtF1357LDPEspIncremen2_Jsonclick = "" ;
      edtF1357LDPEspIncremen2_Enabled = 1 ;
      edtF1357LDPEspIncremen1_Jsonclick = "" ;
      edtF1357LDPEspIncremen1_Enabled = 1 ;
      edtF1357LDPHijosIncapImp_Jsonclick = "" ;
      edtF1357LDPHijosIncapImp_Enabled = 1 ;
      edtF1357LDPCantHijIncap_Jsonclick = "" ;
      edtF1357LDPCantHijIncap_Enabled = 1 ;
      edtF1357LDPRemuSuj_Jsonclick = "" ;
      edtF1357LDPRemuSuj_Enabled = 1 ;
      edtF1357LDPIncB_Jsonclick = "" ;
      edtF1357LDPIncB_Enabled = 1 ;
      edtF1357LDPIncA_Jsonclick = "" ;
      edtF1357LDPIncA_Enabled = 1 ;
      edtF1357LDPSujAntes_Jsonclick = "" ;
      edtF1357LDPSujAntes_Enabled = 1 ;
      edtF1357LDPTotalArt30_Jsonclick = "" ;
      edtF1357LDPTotalArt30_Enabled = 1 ;
      edtF1357LDPTotalFami_Jsonclick = "" ;
      edtF1357LDPTotalFami_Enabled = 1 ;
      edtF1357LDPHijosImporte_Jsonclick = "" ;
      edtF1357LDPHijosImporte_Enabled = 1 ;
      edtF1357LDPCantHijos_Jsonclick = "" ;
      edtF1357LDPCantHijos_Enabled = 1 ;
      edtF1357LDPConyuge_Jsonclick = "" ;
      edtF1357LDPConyuge_Enabled = 1 ;
      edtF1357LDPEspecifica_Jsonclick = "" ;
      edtF1357LDPEspecifica_Enabled = 1 ;
      edtF1357LDPEspecial_Jsonclick = "" ;
      edtF1357LDPEspecial_Enabled = 1 ;
      edtF1357LDPGNI_Jsonclick = "" ;
      edtF1357LDPGNI_Enabled = 1 ;
      edtF1357LDPTipReg_Jsonclick = "" ;
      edtF1357LDPTipReg_Enabled = 1 ;
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
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      /* Using cursor T002J16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Formulario F1357", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "F1357CSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(14);
      /* Using cursor T002J17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(15);
      GX_FocusControl = edtF1357LDPGNI_Internalname ;
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
      /* Using cursor T002J16 */
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
      /* Using cursor T002J17 */
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

   public void valid_F1357ldptipreg( )
   {
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
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A827F1357LDPGNI", GXutil.ltrim( localUtil.ntoc( A827F1357LDPGNI, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A828F1357LDPEspecial", GXutil.ltrim( localUtil.ntoc( A828F1357LDPEspecial, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A829F1357LDPEspecifica", GXutil.ltrim( localUtil.ntoc( A829F1357LDPEspecifica, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A830F1357LDPConyuge", GXutil.ltrim( localUtil.ntoc( A830F1357LDPConyuge, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A831F1357LDPCantHijos", GXutil.ltrim( localUtil.ntoc( A831F1357LDPCantHijos, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A832F1357LDPHijosImporte", GXutil.ltrim( localUtil.ntoc( A832F1357LDPHijosImporte, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A833F1357LDPTotalFami", GXutil.ltrim( localUtil.ntoc( A833F1357LDPTotalFami, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A834F1357LDPTotalArt30", GXutil.ltrim( localUtil.ntoc( A834F1357LDPTotalArt30, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A835F1357LDPSujAntes", GXutil.ltrim( localUtil.ntoc( A835F1357LDPSujAntes, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A836F1357LDPIncA", GXutil.ltrim( localUtil.ntoc( A836F1357LDPIncA, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A837F1357LDPIncB", GXutil.ltrim( localUtil.ntoc( A837F1357LDPIncB, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A838F1357LDPRemuSuj", GXutil.ltrim( localUtil.ntoc( A838F1357LDPRemuSuj, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A839F1357LDPCantHijIncap", GXutil.ltrim( localUtil.ntoc( A839F1357LDPCantHijIncap, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A840F1357LDPHijosIncapImp", GXutil.ltrim( localUtil.ntoc( A840F1357LDPHijosIncapImp, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A841F1357LDPEspIncremen1", GXutil.ltrim( localUtil.ntoc( A841F1357LDPEspIncremen1, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A842F1357LDPEspIncremen2", GXutil.ltrim( localUtil.ntoc( A842F1357LDPEspIncremen2, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A945F1357LDPCantHij100PC", GXutil.ltrim( localUtil.ntoc( A945F1357LDPCantHij100PC, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A946F1357ldpcAntHijIncap100pc", GXutil.ltrim( localUtil.ntoc( A946F1357ldpcAntHijIncap100pc, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A947F1357LDPcantHijMay18", GXutil.ltrim( localUtil.ntoc( A947F1357LDPcantHijMay18, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A948F1357LDPcantHijMay18_100pc", GXutil.ltrim( localUtil.ntoc( A948F1357LDPcantHijMay18_100pc, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z784F1357CTipoPre", GXutil.ltrim( localUtil.ntoc( Z784F1357CTipoPre, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z777F1357CPer", GXutil.rtrim( Z777F1357CPer));
      web.GxWebStd.gx_hidden_field( httpContext, "Z778F1357CSec", GXutil.ltrim( localUtil.ntoc( Z778F1357CSec, (byte)(2), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z862F1357LDPTipReg", GXutil.rtrim( Z862F1357LDPTipReg));
      web.GxWebStd.gx_hidden_field( httpContext, "Z827F1357LDPGNI", GXutil.ltrim( localUtil.ntoc( Z827F1357LDPGNI, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z828F1357LDPEspecial", GXutil.ltrim( localUtil.ntoc( Z828F1357LDPEspecial, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z829F1357LDPEspecifica", GXutil.ltrim( localUtil.ntoc( Z829F1357LDPEspecifica, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z830F1357LDPConyuge", GXutil.ltrim( localUtil.ntoc( Z830F1357LDPConyuge, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z831F1357LDPCantHijos", GXutil.ltrim( localUtil.ntoc( Z831F1357LDPCantHijos, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z832F1357LDPHijosImporte", GXutil.ltrim( localUtil.ntoc( Z832F1357LDPHijosImporte, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z833F1357LDPTotalFami", GXutil.ltrim( localUtil.ntoc( Z833F1357LDPTotalFami, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z834F1357LDPTotalArt30", GXutil.ltrim( localUtil.ntoc( Z834F1357LDPTotalArt30, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z835F1357LDPSujAntes", GXutil.ltrim( localUtil.ntoc( Z835F1357LDPSujAntes, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z836F1357LDPIncA", GXutil.ltrim( localUtil.ntoc( Z836F1357LDPIncA, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z837F1357LDPIncB", GXutil.ltrim( localUtil.ntoc( Z837F1357LDPIncB, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z838F1357LDPRemuSuj", GXutil.ltrim( localUtil.ntoc( Z838F1357LDPRemuSuj, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z839F1357LDPCantHijIncap", GXutil.ltrim( localUtil.ntoc( Z839F1357LDPCantHijIncap, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z840F1357LDPHijosIncapImp", GXutil.ltrim( localUtil.ntoc( Z840F1357LDPHijosIncapImp, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z841F1357LDPEspIncremen1", GXutil.ltrim( localUtil.ntoc( Z841F1357LDPEspIncremen1, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z842F1357LDPEspIncremen2", GXutil.ltrim( localUtil.ntoc( Z842F1357LDPEspIncremen2, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z945F1357LDPCantHij100PC", GXutil.ltrim( localUtil.ntoc( Z945F1357LDPCantHij100PC, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z946F1357ldpcAntHijIncap100pc", GXutil.ltrim( localUtil.ntoc( Z946F1357ldpcAntHijIncap100pc, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z947F1357LDPcantHijMay18", GXutil.ltrim( localUtil.ntoc( Z947F1357LDPcantHijMay18, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z948F1357LDPcantHijMay18_100pc", GXutil.ltrim( localUtil.ntoc( Z948F1357LDPcantHijMay18_100pc, (byte)(16), (byte)(2), ".", "")));
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
      setEventMetadata("VALID_F1357LDPTIPREG","{handler:'valid_F1357ldptipreg',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'cmbF1357CTipoPre'},{av:'A784F1357CTipoPre',fld:'F1357CTIPOPRE',pic:'9'},{av:'A777F1357CPer',fld:'F1357CPER',pic:''},{av:'A778F1357CSec',fld:'F1357CSEC',pic:'Z9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A862F1357LDPTipReg',fld:'F1357LDPTIPREG',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_F1357LDPTIPREG",",oparms:[{av:'A827F1357LDPGNI',fld:'F1357LDPGNI',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A828F1357LDPEspecial',fld:'F1357LDPESPECIAL',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A829F1357LDPEspecifica',fld:'F1357LDPESPECIFICA',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A830F1357LDPConyuge',fld:'F1357LDPCONYUGE',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A831F1357LDPCantHijos',fld:'F1357LDPCANTHIJOS',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A832F1357LDPHijosImporte',fld:'F1357LDPHIJOSIMPORTE',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A833F1357LDPTotalFami',fld:'F1357LDPTOTALFAMI',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A834F1357LDPTotalArt30',fld:'F1357LDPTOTALART30',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A835F1357LDPSujAntes',fld:'F1357LDPSUJANTES',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A836F1357LDPIncA',fld:'F1357LDPINCA',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A837F1357LDPIncB',fld:'F1357LDPINCB',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A838F1357LDPRemuSuj',fld:'F1357LDPREMUSUJ',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A839F1357LDPCantHijIncap',fld:'F1357LDPCANTHIJINCAP',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A840F1357LDPHijosIncapImp',fld:'F1357LDPHIJOSINCAPIMP',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A841F1357LDPEspIncremen1',fld:'F1357LDPESPINCREMEN1',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A842F1357LDPEspIncremen2',fld:'F1357LDPESPINCREMEN2',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A945F1357LDPCantHij100PC',fld:'F1357LDPCANTHIJ100PC',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A946F1357ldpcAntHijIncap100pc',fld:'F1357LDPCANTHIJINCAP100PC',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A947F1357LDPcantHijMay18',fld:'F1357LDPCANTHIJMAY18',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A948F1357LDPcantHijMay18_100pc',fld:'F1357LDPCANTHIJMAY18_100PC',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z3CliCod'},{av:'Z1EmpCod'},{av:'Z784F1357CTipoPre'},{av:'Z777F1357CPer'},{av:'Z778F1357CSec'},{av:'Z6LegNumero'},{av:'Z862F1357LDPTipReg'},{av:'Z827F1357LDPGNI'},{av:'Z828F1357LDPEspecial'},{av:'Z829F1357LDPEspecifica'},{av:'Z830F1357LDPConyuge'},{av:'Z831F1357LDPCantHijos'},{av:'Z832F1357LDPHijosImporte'},{av:'Z833F1357LDPTotalFami'},{av:'Z834F1357LDPTotalArt30'},{av:'Z835F1357LDPSujAntes'},{av:'Z836F1357LDPIncA'},{av:'Z837F1357LDPIncB'},{av:'Z838F1357LDPRemuSuj'},{av:'Z839F1357LDPCantHijIncap'},{av:'Z840F1357LDPHijosIncapImp'},{av:'Z841F1357LDPEspIncremen1'},{av:'Z842F1357LDPEspIncremen2'},{av:'Z945F1357LDPCantHij100PC'},{av:'Z946F1357ldpcAntHijIncap100pc'},{av:'Z947F1357LDPcantHijMay18'},{av:'Z948F1357LDPcantHijMay18_100pc'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
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
      Z862F1357LDPTipReg = "" ;
      Z827F1357LDPGNI = DecimalUtil.ZERO ;
      Z828F1357LDPEspecial = DecimalUtil.ZERO ;
      Z829F1357LDPEspecifica = DecimalUtil.ZERO ;
      Z830F1357LDPConyuge = DecimalUtil.ZERO ;
      Z831F1357LDPCantHijos = DecimalUtil.ZERO ;
      Z832F1357LDPHijosImporte = DecimalUtil.ZERO ;
      Z833F1357LDPTotalFami = DecimalUtil.ZERO ;
      Z834F1357LDPTotalArt30 = DecimalUtil.ZERO ;
      Z835F1357LDPSujAntes = DecimalUtil.ZERO ;
      Z836F1357LDPIncA = DecimalUtil.ZERO ;
      Z837F1357LDPIncB = DecimalUtil.ZERO ;
      Z838F1357LDPRemuSuj = DecimalUtil.ZERO ;
      Z839F1357LDPCantHijIncap = DecimalUtil.ZERO ;
      Z840F1357LDPHijosIncapImp = DecimalUtil.ZERO ;
      Z841F1357LDPEspIncremen1 = DecimalUtil.ZERO ;
      Z842F1357LDPEspIncremen2 = DecimalUtil.ZERO ;
      Z945F1357LDPCantHij100PC = DecimalUtil.ZERO ;
      Z946F1357ldpcAntHijIncap100pc = DecimalUtil.ZERO ;
      Z947F1357LDPcantHijMay18 = DecimalUtil.ZERO ;
      Z948F1357LDPcantHijMay18_100pc = DecimalUtil.ZERO ;
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
      A862F1357LDPTipReg = "" ;
      A827F1357LDPGNI = DecimalUtil.ZERO ;
      A828F1357LDPEspecial = DecimalUtil.ZERO ;
      A829F1357LDPEspecifica = DecimalUtil.ZERO ;
      A830F1357LDPConyuge = DecimalUtil.ZERO ;
      A831F1357LDPCantHijos = DecimalUtil.ZERO ;
      A832F1357LDPHijosImporte = DecimalUtil.ZERO ;
      A833F1357LDPTotalFami = DecimalUtil.ZERO ;
      A834F1357LDPTotalArt30 = DecimalUtil.ZERO ;
      A835F1357LDPSujAntes = DecimalUtil.ZERO ;
      A836F1357LDPIncA = DecimalUtil.ZERO ;
      A837F1357LDPIncB = DecimalUtil.ZERO ;
      A838F1357LDPRemuSuj = DecimalUtil.ZERO ;
      A839F1357LDPCantHijIncap = DecimalUtil.ZERO ;
      A840F1357LDPHijosIncapImp = DecimalUtil.ZERO ;
      A841F1357LDPEspIncremen1 = DecimalUtil.ZERO ;
      A842F1357LDPEspIncremen2 = DecimalUtil.ZERO ;
      A945F1357LDPCantHij100PC = DecimalUtil.ZERO ;
      A946F1357ldpcAntHijIncap100pc = DecimalUtil.ZERO ;
      A947F1357LDPcantHijMay18 = DecimalUtil.ZERO ;
      A948F1357LDPcantHijMay18_100pc = DecimalUtil.ZERO ;
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
      T002J6_A862F1357LDPTipReg = new String[] {""} ;
      T002J6_A827F1357LDPGNI = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A828F1357LDPEspecial = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A829F1357LDPEspecifica = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A830F1357LDPConyuge = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A831F1357LDPCantHijos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A832F1357LDPHijosImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A833F1357LDPTotalFami = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A834F1357LDPTotalArt30 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A835F1357LDPSujAntes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A836F1357LDPIncA = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A837F1357LDPIncB = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A838F1357LDPRemuSuj = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A839F1357LDPCantHijIncap = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A840F1357LDPHijosIncapImp = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A841F1357LDPEspIncremen1 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A842F1357LDPEspIncremen2 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A945F1357LDPCantHij100PC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A946F1357ldpcAntHijIncap100pc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A947F1357LDPcantHijMay18 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A948F1357LDPcantHijMay18_100pc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J6_A3CliCod = new int[1] ;
      T002J6_A1EmpCod = new short[1] ;
      T002J6_A6LegNumero = new int[1] ;
      T002J6_A784F1357CTipoPre = new byte[1] ;
      T002J6_A777F1357CPer = new String[] {""} ;
      T002J6_A778F1357CSec = new byte[1] ;
      T002J5_A3CliCod = new int[1] ;
      T002J4_A3CliCod = new int[1] ;
      T002J7_A3CliCod = new int[1] ;
      T002J8_A3CliCod = new int[1] ;
      T002J9_A3CliCod = new int[1] ;
      T002J9_A1EmpCod = new short[1] ;
      T002J9_A784F1357CTipoPre = new byte[1] ;
      T002J9_A777F1357CPer = new String[] {""} ;
      T002J9_A778F1357CSec = new byte[1] ;
      T002J9_A6LegNumero = new int[1] ;
      T002J9_A862F1357LDPTipReg = new String[] {""} ;
      T002J3_A862F1357LDPTipReg = new String[] {""} ;
      T002J3_A827F1357LDPGNI = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A828F1357LDPEspecial = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A829F1357LDPEspecifica = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A830F1357LDPConyuge = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A831F1357LDPCantHijos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A832F1357LDPHijosImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A833F1357LDPTotalFami = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A834F1357LDPTotalArt30 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A835F1357LDPSujAntes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A836F1357LDPIncA = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A837F1357LDPIncB = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A838F1357LDPRemuSuj = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A839F1357LDPCantHijIncap = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A840F1357LDPHijosIncapImp = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A841F1357LDPEspIncremen1 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A842F1357LDPEspIncremen2 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A945F1357LDPCantHij100PC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A946F1357ldpcAntHijIncap100pc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A947F1357LDPcantHijMay18 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A948F1357LDPcantHijMay18_100pc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J3_A3CliCod = new int[1] ;
      T002J3_A1EmpCod = new short[1] ;
      T002J3_A6LegNumero = new int[1] ;
      T002J3_A784F1357CTipoPre = new byte[1] ;
      T002J3_A777F1357CPer = new String[] {""} ;
      T002J3_A778F1357CSec = new byte[1] ;
      sMode94 = "" ;
      T002J10_A3CliCod = new int[1] ;
      T002J10_A1EmpCod = new short[1] ;
      T002J10_A784F1357CTipoPre = new byte[1] ;
      T002J10_A777F1357CPer = new String[] {""} ;
      T002J10_A778F1357CSec = new byte[1] ;
      T002J10_A6LegNumero = new int[1] ;
      T002J10_A862F1357LDPTipReg = new String[] {""} ;
      T002J11_A3CliCod = new int[1] ;
      T002J11_A1EmpCod = new short[1] ;
      T002J11_A784F1357CTipoPre = new byte[1] ;
      T002J11_A777F1357CPer = new String[] {""} ;
      T002J11_A778F1357CSec = new byte[1] ;
      T002J11_A6LegNumero = new int[1] ;
      T002J11_A862F1357LDPTipReg = new String[] {""} ;
      T002J2_A862F1357LDPTipReg = new String[] {""} ;
      T002J2_A827F1357LDPGNI = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A828F1357LDPEspecial = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A829F1357LDPEspecifica = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A830F1357LDPConyuge = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A831F1357LDPCantHijos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A832F1357LDPHijosImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A833F1357LDPTotalFami = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A834F1357LDPTotalArt30 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A835F1357LDPSujAntes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A836F1357LDPIncA = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A837F1357LDPIncB = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A838F1357LDPRemuSuj = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A839F1357LDPCantHijIncap = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A840F1357LDPHijosIncapImp = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A841F1357LDPEspIncremen1 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A842F1357LDPEspIncremen2 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A945F1357LDPCantHij100PC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A946F1357ldpcAntHijIncap100pc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A947F1357LDPcantHijMay18 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A948F1357LDPcantHijMay18_100pc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002J2_A3CliCod = new int[1] ;
      T002J2_A1EmpCod = new short[1] ;
      T002J2_A6LegNumero = new int[1] ;
      T002J2_A784F1357CTipoPre = new byte[1] ;
      T002J2_A777F1357CPer = new String[] {""} ;
      T002J2_A778F1357CSec = new byte[1] ;
      T002J15_A3CliCod = new int[1] ;
      T002J15_A1EmpCod = new short[1] ;
      T002J15_A784F1357CTipoPre = new byte[1] ;
      T002J15_A777F1357CPer = new String[] {""} ;
      T002J15_A778F1357CSec = new byte[1] ;
      T002J15_A6LegNumero = new int[1] ;
      T002J15_A862F1357LDPTipReg = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T002J16_A3CliCod = new int[1] ;
      T002J17_A3CliCod = new int[1] ;
      ZZ777F1357CPer = "" ;
      ZZ862F1357LDPTipReg = "" ;
      ZZ827F1357LDPGNI = DecimalUtil.ZERO ;
      ZZ828F1357LDPEspecial = DecimalUtil.ZERO ;
      ZZ829F1357LDPEspecifica = DecimalUtil.ZERO ;
      ZZ830F1357LDPConyuge = DecimalUtil.ZERO ;
      ZZ831F1357LDPCantHijos = DecimalUtil.ZERO ;
      ZZ832F1357LDPHijosImporte = DecimalUtil.ZERO ;
      ZZ833F1357LDPTotalFami = DecimalUtil.ZERO ;
      ZZ834F1357LDPTotalArt30 = DecimalUtil.ZERO ;
      ZZ835F1357LDPSujAntes = DecimalUtil.ZERO ;
      ZZ836F1357LDPIncA = DecimalUtil.ZERO ;
      ZZ837F1357LDPIncB = DecimalUtil.ZERO ;
      ZZ838F1357LDPRemuSuj = DecimalUtil.ZERO ;
      ZZ839F1357LDPCantHijIncap = DecimalUtil.ZERO ;
      ZZ840F1357LDPHijosIncapImp = DecimalUtil.ZERO ;
      ZZ841F1357LDPEspIncremen1 = DecimalUtil.ZERO ;
      ZZ842F1357LDPEspIncremen2 = DecimalUtil.ZERO ;
      ZZ945F1357LDPCantHij100PC = DecimalUtil.ZERO ;
      ZZ946F1357ldpcAntHijIncap100pc = DecimalUtil.ZERO ;
      ZZ947F1357LDPcantHijMay18 = DecimalUtil.ZERO ;
      ZZ948F1357LDPcantHijMay18_100pc = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357ldedper__default(),
         new Object[] {
             new Object[] {
            T002J2_A862F1357LDPTipReg, T002J2_A827F1357LDPGNI, T002J2_A828F1357LDPEspecial, T002J2_A829F1357LDPEspecifica, T002J2_A830F1357LDPConyuge, T002J2_A831F1357LDPCantHijos, T002J2_A832F1357LDPHijosImporte, T002J2_A833F1357LDPTotalFami, T002J2_A834F1357LDPTotalArt30, T002J2_A835F1357LDPSujAntes,
            T002J2_A836F1357LDPIncA, T002J2_A837F1357LDPIncB, T002J2_A838F1357LDPRemuSuj, T002J2_A839F1357LDPCantHijIncap, T002J2_A840F1357LDPHijosIncapImp, T002J2_A841F1357LDPEspIncremen1, T002J2_A842F1357LDPEspIncremen2, T002J2_A945F1357LDPCantHij100PC, T002J2_A946F1357ldpcAntHijIncap100pc, T002J2_A947F1357LDPcantHijMay18,
            T002J2_A948F1357LDPcantHijMay18_100pc, T002J2_A3CliCod, T002J2_A1EmpCod, T002J2_A6LegNumero, T002J2_A784F1357CTipoPre, T002J2_A777F1357CPer, T002J2_A778F1357CSec
            }
            , new Object[] {
            T002J3_A862F1357LDPTipReg, T002J3_A827F1357LDPGNI, T002J3_A828F1357LDPEspecial, T002J3_A829F1357LDPEspecifica, T002J3_A830F1357LDPConyuge, T002J3_A831F1357LDPCantHijos, T002J3_A832F1357LDPHijosImporte, T002J3_A833F1357LDPTotalFami, T002J3_A834F1357LDPTotalArt30, T002J3_A835F1357LDPSujAntes,
            T002J3_A836F1357LDPIncA, T002J3_A837F1357LDPIncB, T002J3_A838F1357LDPRemuSuj, T002J3_A839F1357LDPCantHijIncap, T002J3_A840F1357LDPHijosIncapImp, T002J3_A841F1357LDPEspIncremen1, T002J3_A842F1357LDPEspIncremen2, T002J3_A945F1357LDPCantHij100PC, T002J3_A946F1357ldpcAntHijIncap100pc, T002J3_A947F1357LDPcantHijMay18,
            T002J3_A948F1357LDPcantHijMay18_100pc, T002J3_A3CliCod, T002J3_A1EmpCod, T002J3_A6LegNumero, T002J3_A784F1357CTipoPre, T002J3_A777F1357CPer, T002J3_A778F1357CSec
            }
            , new Object[] {
            T002J4_A3CliCod
            }
            , new Object[] {
            T002J5_A3CliCod
            }
            , new Object[] {
            T002J6_A862F1357LDPTipReg, T002J6_A827F1357LDPGNI, T002J6_A828F1357LDPEspecial, T002J6_A829F1357LDPEspecifica, T002J6_A830F1357LDPConyuge, T002J6_A831F1357LDPCantHijos, T002J6_A832F1357LDPHijosImporte, T002J6_A833F1357LDPTotalFami, T002J6_A834F1357LDPTotalArt30, T002J6_A835F1357LDPSujAntes,
            T002J6_A836F1357LDPIncA, T002J6_A837F1357LDPIncB, T002J6_A838F1357LDPRemuSuj, T002J6_A839F1357LDPCantHijIncap, T002J6_A840F1357LDPHijosIncapImp, T002J6_A841F1357LDPEspIncremen1, T002J6_A842F1357LDPEspIncremen2, T002J6_A945F1357LDPCantHij100PC, T002J6_A946F1357ldpcAntHijIncap100pc, T002J6_A947F1357LDPcantHijMay18,
            T002J6_A948F1357LDPcantHijMay18_100pc, T002J6_A3CliCod, T002J6_A1EmpCod, T002J6_A6LegNumero, T002J6_A784F1357CTipoPre, T002J6_A777F1357CPer, T002J6_A778F1357CSec
            }
            , new Object[] {
            T002J7_A3CliCod
            }
            , new Object[] {
            T002J8_A3CliCod
            }
            , new Object[] {
            T002J9_A3CliCod, T002J9_A1EmpCod, T002J9_A784F1357CTipoPre, T002J9_A777F1357CPer, T002J9_A778F1357CSec, T002J9_A6LegNumero, T002J9_A862F1357LDPTipReg
            }
            , new Object[] {
            T002J10_A3CliCod, T002J10_A1EmpCod, T002J10_A784F1357CTipoPre, T002J10_A777F1357CPer, T002J10_A778F1357CSec, T002J10_A6LegNumero, T002J10_A862F1357LDPTipReg
            }
            , new Object[] {
            T002J11_A3CliCod, T002J11_A1EmpCod, T002J11_A784F1357CTipoPre, T002J11_A777F1357CPer, T002J11_A778F1357CSec, T002J11_A6LegNumero, T002J11_A862F1357LDPTipReg
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002J15_A3CliCod, T002J15_A1EmpCod, T002J15_A784F1357CTipoPre, T002J15_A777F1357CPer, T002J15_A778F1357CSec, T002J15_A6LegNumero, T002J15_A862F1357LDPTipReg
            }
            , new Object[] {
            T002J16_A3CliCod
            }
            , new Object[] {
            T002J17_A3CliCod
            }
         }
      );
   }

   private byte Z784F1357CTipoPre ;
   private byte Z778F1357CSec ;
   private byte GxWebError ;
   private byte A784F1357CTipoPre ;
   private byte A778F1357CSec ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private byte ZZ784F1357CTipoPre ;
   private byte ZZ778F1357CSec ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound94 ;
   private short nIsDirty_94 ;
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
   private int edtF1357LDPTipReg_Enabled ;
   private int edtF1357LDPGNI_Enabled ;
   private int edtF1357LDPEspecial_Enabled ;
   private int edtF1357LDPEspecifica_Enabled ;
   private int edtF1357LDPConyuge_Enabled ;
   private int edtF1357LDPCantHijos_Enabled ;
   private int edtF1357LDPHijosImporte_Enabled ;
   private int edtF1357LDPTotalFami_Enabled ;
   private int edtF1357LDPTotalArt30_Enabled ;
   private int edtF1357LDPSujAntes_Enabled ;
   private int edtF1357LDPIncA_Enabled ;
   private int edtF1357LDPIncB_Enabled ;
   private int edtF1357LDPRemuSuj_Enabled ;
   private int edtF1357LDPCantHijIncap_Enabled ;
   private int edtF1357LDPHijosIncapImp_Enabled ;
   private int edtF1357LDPEspIncremen1_Enabled ;
   private int edtF1357LDPEspIncremen2_Enabled ;
   private int edtF1357LDPCantHij100PC_Enabled ;
   private int edtF1357ldpcAntHijIncap100pc_Enabled ;
   private int edtF1357LDPcantHijMay18_Enabled ;
   private int edtF1357LDPcantHijMay18_100pc_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ3CliCod ;
   private int ZZ6LegNumero ;
   private java.math.BigDecimal Z827F1357LDPGNI ;
   private java.math.BigDecimal Z828F1357LDPEspecial ;
   private java.math.BigDecimal Z829F1357LDPEspecifica ;
   private java.math.BigDecimal Z830F1357LDPConyuge ;
   private java.math.BigDecimal Z831F1357LDPCantHijos ;
   private java.math.BigDecimal Z832F1357LDPHijosImporte ;
   private java.math.BigDecimal Z833F1357LDPTotalFami ;
   private java.math.BigDecimal Z834F1357LDPTotalArt30 ;
   private java.math.BigDecimal Z835F1357LDPSujAntes ;
   private java.math.BigDecimal Z836F1357LDPIncA ;
   private java.math.BigDecimal Z837F1357LDPIncB ;
   private java.math.BigDecimal Z838F1357LDPRemuSuj ;
   private java.math.BigDecimal Z839F1357LDPCantHijIncap ;
   private java.math.BigDecimal Z840F1357LDPHijosIncapImp ;
   private java.math.BigDecimal Z841F1357LDPEspIncremen1 ;
   private java.math.BigDecimal Z842F1357LDPEspIncremen2 ;
   private java.math.BigDecimal Z945F1357LDPCantHij100PC ;
   private java.math.BigDecimal Z946F1357ldpcAntHijIncap100pc ;
   private java.math.BigDecimal Z947F1357LDPcantHijMay18 ;
   private java.math.BigDecimal Z948F1357LDPcantHijMay18_100pc ;
   private java.math.BigDecimal A827F1357LDPGNI ;
   private java.math.BigDecimal A828F1357LDPEspecial ;
   private java.math.BigDecimal A829F1357LDPEspecifica ;
   private java.math.BigDecimal A830F1357LDPConyuge ;
   private java.math.BigDecimal A831F1357LDPCantHijos ;
   private java.math.BigDecimal A832F1357LDPHijosImporte ;
   private java.math.BigDecimal A833F1357LDPTotalFami ;
   private java.math.BigDecimal A834F1357LDPTotalArt30 ;
   private java.math.BigDecimal A835F1357LDPSujAntes ;
   private java.math.BigDecimal A836F1357LDPIncA ;
   private java.math.BigDecimal A837F1357LDPIncB ;
   private java.math.BigDecimal A838F1357LDPRemuSuj ;
   private java.math.BigDecimal A839F1357LDPCantHijIncap ;
   private java.math.BigDecimal A840F1357LDPHijosIncapImp ;
   private java.math.BigDecimal A841F1357LDPEspIncremen1 ;
   private java.math.BigDecimal A842F1357LDPEspIncremen2 ;
   private java.math.BigDecimal A945F1357LDPCantHij100PC ;
   private java.math.BigDecimal A946F1357ldpcAntHijIncap100pc ;
   private java.math.BigDecimal A947F1357LDPcantHijMay18 ;
   private java.math.BigDecimal A948F1357LDPcantHijMay18_100pc ;
   private java.math.BigDecimal ZZ827F1357LDPGNI ;
   private java.math.BigDecimal ZZ828F1357LDPEspecial ;
   private java.math.BigDecimal ZZ829F1357LDPEspecifica ;
   private java.math.BigDecimal ZZ830F1357LDPConyuge ;
   private java.math.BigDecimal ZZ831F1357LDPCantHijos ;
   private java.math.BigDecimal ZZ832F1357LDPHijosImporte ;
   private java.math.BigDecimal ZZ833F1357LDPTotalFami ;
   private java.math.BigDecimal ZZ834F1357LDPTotalArt30 ;
   private java.math.BigDecimal ZZ835F1357LDPSujAntes ;
   private java.math.BigDecimal ZZ836F1357LDPIncA ;
   private java.math.BigDecimal ZZ837F1357LDPIncB ;
   private java.math.BigDecimal ZZ838F1357LDPRemuSuj ;
   private java.math.BigDecimal ZZ839F1357LDPCantHijIncap ;
   private java.math.BigDecimal ZZ840F1357LDPHijosIncapImp ;
   private java.math.BigDecimal ZZ841F1357LDPEspIncremen1 ;
   private java.math.BigDecimal ZZ842F1357LDPEspIncremen2 ;
   private java.math.BigDecimal ZZ945F1357LDPCantHij100PC ;
   private java.math.BigDecimal ZZ946F1357ldpcAntHijIncap100pc ;
   private java.math.BigDecimal ZZ947F1357LDPcantHijMay18 ;
   private java.math.BigDecimal ZZ948F1357LDPcantHijMay18_100pc ;
   private String sPrefix ;
   private String Z777F1357CPer ;
   private String Z862F1357LDPTipReg ;
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
   private String edtF1357LDPTipReg_Internalname ;
   private String A862F1357LDPTipReg ;
   private String edtF1357LDPTipReg_Jsonclick ;
   private String edtF1357LDPGNI_Internalname ;
   private String edtF1357LDPGNI_Jsonclick ;
   private String edtF1357LDPEspecial_Internalname ;
   private String edtF1357LDPEspecial_Jsonclick ;
   private String edtF1357LDPEspecifica_Internalname ;
   private String edtF1357LDPEspecifica_Jsonclick ;
   private String edtF1357LDPConyuge_Internalname ;
   private String edtF1357LDPConyuge_Jsonclick ;
   private String edtF1357LDPCantHijos_Internalname ;
   private String edtF1357LDPCantHijos_Jsonclick ;
   private String edtF1357LDPHijosImporte_Internalname ;
   private String edtF1357LDPHijosImporte_Jsonclick ;
   private String edtF1357LDPTotalFami_Internalname ;
   private String edtF1357LDPTotalFami_Jsonclick ;
   private String edtF1357LDPTotalArt30_Internalname ;
   private String edtF1357LDPTotalArt30_Jsonclick ;
   private String edtF1357LDPSujAntes_Internalname ;
   private String edtF1357LDPSujAntes_Jsonclick ;
   private String edtF1357LDPIncA_Internalname ;
   private String edtF1357LDPIncA_Jsonclick ;
   private String edtF1357LDPIncB_Internalname ;
   private String edtF1357LDPIncB_Jsonclick ;
   private String edtF1357LDPRemuSuj_Internalname ;
   private String edtF1357LDPRemuSuj_Jsonclick ;
   private String edtF1357LDPCantHijIncap_Internalname ;
   private String edtF1357LDPCantHijIncap_Jsonclick ;
   private String edtF1357LDPHijosIncapImp_Internalname ;
   private String edtF1357LDPHijosIncapImp_Jsonclick ;
   private String edtF1357LDPEspIncremen1_Internalname ;
   private String edtF1357LDPEspIncremen1_Jsonclick ;
   private String edtF1357LDPEspIncremen2_Internalname ;
   private String edtF1357LDPEspIncremen2_Jsonclick ;
   private String edtF1357LDPCantHij100PC_Internalname ;
   private String edtF1357LDPCantHij100PC_Jsonclick ;
   private String edtF1357ldpcAntHijIncap100pc_Internalname ;
   private String edtF1357ldpcAntHijIncap100pc_Jsonclick ;
   private String edtF1357LDPcantHijMay18_Internalname ;
   private String edtF1357LDPcantHijMay18_Jsonclick ;
   private String edtF1357LDPcantHijMay18_100pc_Internalname ;
   private String edtF1357LDPcantHijMay18_100pc_Jsonclick ;
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
   private String sMode94 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ777F1357CPer ;
   private String ZZ862F1357LDPTipReg ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Gx_longc ;
   private HTMLChoice cmbF1357CTipoPre ;
   private IDataStoreProvider pr_default ;
   private String[] T002J6_A862F1357LDPTipReg ;
   private java.math.BigDecimal[] T002J6_A827F1357LDPGNI ;
   private java.math.BigDecimal[] T002J6_A828F1357LDPEspecial ;
   private java.math.BigDecimal[] T002J6_A829F1357LDPEspecifica ;
   private java.math.BigDecimal[] T002J6_A830F1357LDPConyuge ;
   private java.math.BigDecimal[] T002J6_A831F1357LDPCantHijos ;
   private java.math.BigDecimal[] T002J6_A832F1357LDPHijosImporte ;
   private java.math.BigDecimal[] T002J6_A833F1357LDPTotalFami ;
   private java.math.BigDecimal[] T002J6_A834F1357LDPTotalArt30 ;
   private java.math.BigDecimal[] T002J6_A835F1357LDPSujAntes ;
   private java.math.BigDecimal[] T002J6_A836F1357LDPIncA ;
   private java.math.BigDecimal[] T002J6_A837F1357LDPIncB ;
   private java.math.BigDecimal[] T002J6_A838F1357LDPRemuSuj ;
   private java.math.BigDecimal[] T002J6_A839F1357LDPCantHijIncap ;
   private java.math.BigDecimal[] T002J6_A840F1357LDPHijosIncapImp ;
   private java.math.BigDecimal[] T002J6_A841F1357LDPEspIncremen1 ;
   private java.math.BigDecimal[] T002J6_A842F1357LDPEspIncremen2 ;
   private java.math.BigDecimal[] T002J6_A945F1357LDPCantHij100PC ;
   private java.math.BigDecimal[] T002J6_A946F1357ldpcAntHijIncap100pc ;
   private java.math.BigDecimal[] T002J6_A947F1357LDPcantHijMay18 ;
   private java.math.BigDecimal[] T002J6_A948F1357LDPcantHijMay18_100pc ;
   private int[] T002J6_A3CliCod ;
   private short[] T002J6_A1EmpCod ;
   private int[] T002J6_A6LegNumero ;
   private byte[] T002J6_A784F1357CTipoPre ;
   private String[] T002J6_A777F1357CPer ;
   private byte[] T002J6_A778F1357CSec ;
   private int[] T002J5_A3CliCod ;
   private int[] T002J4_A3CliCod ;
   private int[] T002J7_A3CliCod ;
   private int[] T002J8_A3CliCod ;
   private int[] T002J9_A3CliCod ;
   private short[] T002J9_A1EmpCod ;
   private byte[] T002J9_A784F1357CTipoPre ;
   private String[] T002J9_A777F1357CPer ;
   private byte[] T002J9_A778F1357CSec ;
   private int[] T002J9_A6LegNumero ;
   private String[] T002J9_A862F1357LDPTipReg ;
   private String[] T002J3_A862F1357LDPTipReg ;
   private java.math.BigDecimal[] T002J3_A827F1357LDPGNI ;
   private java.math.BigDecimal[] T002J3_A828F1357LDPEspecial ;
   private java.math.BigDecimal[] T002J3_A829F1357LDPEspecifica ;
   private java.math.BigDecimal[] T002J3_A830F1357LDPConyuge ;
   private java.math.BigDecimal[] T002J3_A831F1357LDPCantHijos ;
   private java.math.BigDecimal[] T002J3_A832F1357LDPHijosImporte ;
   private java.math.BigDecimal[] T002J3_A833F1357LDPTotalFami ;
   private java.math.BigDecimal[] T002J3_A834F1357LDPTotalArt30 ;
   private java.math.BigDecimal[] T002J3_A835F1357LDPSujAntes ;
   private java.math.BigDecimal[] T002J3_A836F1357LDPIncA ;
   private java.math.BigDecimal[] T002J3_A837F1357LDPIncB ;
   private java.math.BigDecimal[] T002J3_A838F1357LDPRemuSuj ;
   private java.math.BigDecimal[] T002J3_A839F1357LDPCantHijIncap ;
   private java.math.BigDecimal[] T002J3_A840F1357LDPHijosIncapImp ;
   private java.math.BigDecimal[] T002J3_A841F1357LDPEspIncremen1 ;
   private java.math.BigDecimal[] T002J3_A842F1357LDPEspIncremen2 ;
   private java.math.BigDecimal[] T002J3_A945F1357LDPCantHij100PC ;
   private java.math.BigDecimal[] T002J3_A946F1357ldpcAntHijIncap100pc ;
   private java.math.BigDecimal[] T002J3_A947F1357LDPcantHijMay18 ;
   private java.math.BigDecimal[] T002J3_A948F1357LDPcantHijMay18_100pc ;
   private int[] T002J3_A3CliCod ;
   private short[] T002J3_A1EmpCod ;
   private int[] T002J3_A6LegNumero ;
   private byte[] T002J3_A784F1357CTipoPre ;
   private String[] T002J3_A777F1357CPer ;
   private byte[] T002J3_A778F1357CSec ;
   private int[] T002J10_A3CliCod ;
   private short[] T002J10_A1EmpCod ;
   private byte[] T002J10_A784F1357CTipoPre ;
   private String[] T002J10_A777F1357CPer ;
   private byte[] T002J10_A778F1357CSec ;
   private int[] T002J10_A6LegNumero ;
   private String[] T002J10_A862F1357LDPTipReg ;
   private int[] T002J11_A3CliCod ;
   private short[] T002J11_A1EmpCod ;
   private byte[] T002J11_A784F1357CTipoPre ;
   private String[] T002J11_A777F1357CPer ;
   private byte[] T002J11_A778F1357CSec ;
   private int[] T002J11_A6LegNumero ;
   private String[] T002J11_A862F1357LDPTipReg ;
   private String[] T002J2_A862F1357LDPTipReg ;
   private java.math.BigDecimal[] T002J2_A827F1357LDPGNI ;
   private java.math.BigDecimal[] T002J2_A828F1357LDPEspecial ;
   private java.math.BigDecimal[] T002J2_A829F1357LDPEspecifica ;
   private java.math.BigDecimal[] T002J2_A830F1357LDPConyuge ;
   private java.math.BigDecimal[] T002J2_A831F1357LDPCantHijos ;
   private java.math.BigDecimal[] T002J2_A832F1357LDPHijosImporte ;
   private java.math.BigDecimal[] T002J2_A833F1357LDPTotalFami ;
   private java.math.BigDecimal[] T002J2_A834F1357LDPTotalArt30 ;
   private java.math.BigDecimal[] T002J2_A835F1357LDPSujAntes ;
   private java.math.BigDecimal[] T002J2_A836F1357LDPIncA ;
   private java.math.BigDecimal[] T002J2_A837F1357LDPIncB ;
   private java.math.BigDecimal[] T002J2_A838F1357LDPRemuSuj ;
   private java.math.BigDecimal[] T002J2_A839F1357LDPCantHijIncap ;
   private java.math.BigDecimal[] T002J2_A840F1357LDPHijosIncapImp ;
   private java.math.BigDecimal[] T002J2_A841F1357LDPEspIncremen1 ;
   private java.math.BigDecimal[] T002J2_A842F1357LDPEspIncremen2 ;
   private java.math.BigDecimal[] T002J2_A945F1357LDPCantHij100PC ;
   private java.math.BigDecimal[] T002J2_A946F1357ldpcAntHijIncap100pc ;
   private java.math.BigDecimal[] T002J2_A947F1357LDPcantHijMay18 ;
   private java.math.BigDecimal[] T002J2_A948F1357LDPcantHijMay18_100pc ;
   private int[] T002J2_A3CliCod ;
   private short[] T002J2_A1EmpCod ;
   private int[] T002J2_A6LegNumero ;
   private byte[] T002J2_A784F1357CTipoPre ;
   private String[] T002J2_A777F1357CPer ;
   private byte[] T002J2_A778F1357CSec ;
   private int[] T002J15_A3CliCod ;
   private short[] T002J15_A1EmpCod ;
   private byte[] T002J15_A784F1357CTipoPre ;
   private String[] T002J15_A777F1357CPer ;
   private byte[] T002J15_A778F1357CSec ;
   private int[] T002J15_A6LegNumero ;
   private String[] T002J15_A862F1357LDPTipReg ;
   private int[] T002J16_A3CliCod ;
   private int[] T002J17_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class f1357ldedper__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T002J2", "SELECT F1357LDPTipReg, F1357LDPGNI, F1357LDPEspecial, F1357LDPEspecifica, F1357LDPConyuge, F1357LDPCantHijos, F1357LDPHijosImporte, F1357LDPTotalFami, F1357LDPTotalArt30, F1357LDPSujAntes, F1357LDPIncA, F1357LDPIncB, F1357LDPRemuSuj, F1357LDPCantHijIncap, F1357LDPHijosIncapImp, F1357LDPEspIncremen1, F1357LDPEspIncremen2, F1357LDPCantHij100PC, F1357ldpcAntHijIncap100pc, F1357LDPcantHijMay18, F1357LDPcantHijMay18_100pc, CliCod, EmpCod, LegNumero, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357LDedPer WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LDPTipReg = ?  FOR UPDATE OF F1357LDedPer NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002J3", "SELECT F1357LDPTipReg, F1357LDPGNI, F1357LDPEspecial, F1357LDPEspecifica, F1357LDPConyuge, F1357LDPCantHijos, F1357LDPHijosImporte, F1357LDPTotalFami, F1357LDPTotalArt30, F1357LDPSujAntes, F1357LDPIncA, F1357LDPIncB, F1357LDPRemuSuj, F1357LDPCantHijIncap, F1357LDPHijosIncapImp, F1357LDPEspIncremen1, F1357LDPEspIncremen2, F1357LDPCantHij100PC, F1357ldpcAntHijIncap100pc, F1357LDPcantHijMay18, F1357LDPcantHijMay18_100pc, CliCod, EmpCod, LegNumero, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357LDedPer WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LDPTipReg = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002J4", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002J5", "SELECT CliCod FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002J6", "SELECT TM1.F1357LDPTipReg, TM1.F1357LDPGNI, TM1.F1357LDPEspecial, TM1.F1357LDPEspecifica, TM1.F1357LDPConyuge, TM1.F1357LDPCantHijos, TM1.F1357LDPHijosImporte, TM1.F1357LDPTotalFami, TM1.F1357LDPTotalArt30, TM1.F1357LDPSujAntes, TM1.F1357LDPIncA, TM1.F1357LDPIncB, TM1.F1357LDPRemuSuj, TM1.F1357LDPCantHijIncap, TM1.F1357LDPHijosIncapImp, TM1.F1357LDPEspIncremen1, TM1.F1357LDPEspIncremen2, TM1.F1357LDPCantHij100PC, TM1.F1357ldpcAntHijIncap100pc, TM1.F1357LDPcantHijMay18, TM1.F1357LDPcantHijMay18_100pc, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.F1357CTipoPre, TM1.F1357CPer, TM1.F1357CSec FROM F1357LDedPer TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.F1357CTipoPre = ? and TM1.F1357CPer = ( ?) and TM1.F1357CSec = ? and TM1.LegNumero = ? and TM1.F1357LDPTipReg = ( ?) ORDER BY TM1.CliCod, TM1.EmpCod, TM1.F1357CTipoPre, TM1.F1357CPer, TM1.F1357CSec, TM1.LegNumero, TM1.F1357LDPTipReg ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002J7", "SELECT CliCod FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002J8", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002J9", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDPTipReg FROM F1357LDedPer WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LDPTipReg = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002J10", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDPTipReg FROM F1357LDedPer WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and F1357CTipoPre > ? or F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CPer > ( ?) or F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CSec > ? or F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and LegNumero > ? or LegNumero = ? and F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357LDPTipReg > ( ?)) ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDPTipReg  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002J11", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDPTipReg FROM F1357LDedPer WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and F1357CTipoPre < ? or F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CPer < ( ?) or F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CSec < ? or F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and LegNumero < ? or LegNumero = ? and F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357LDPTipReg < ( ?)) ORDER BY CliCod DESC, EmpCod DESC, F1357CTipoPre DESC, F1357CPer DESC, F1357CSec DESC, LegNumero DESC, F1357LDPTipReg DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T002J12", "SAVEPOINT gxupdate;INSERT INTO F1357LDedPer(F1357LDPTipReg, F1357LDPGNI, F1357LDPEspecial, F1357LDPEspecifica, F1357LDPConyuge, F1357LDPCantHijos, F1357LDPHijosImporte, F1357LDPTotalFami, F1357LDPTotalArt30, F1357LDPSujAntes, F1357LDPIncA, F1357LDPIncB, F1357LDPRemuSuj, F1357LDPCantHijIncap, F1357LDPHijosIncapImp, F1357LDPEspIncremen1, F1357LDPEspIncremen2, F1357LDPCantHij100PC, F1357ldpcAntHijIncap100pc, F1357LDPcantHijMay18, F1357LDPcantHijMay18_100pc, CliCod, EmpCod, LegNumero, F1357CTipoPre, F1357CPer, F1357CSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002J13", "SAVEPOINT gxupdate;UPDATE F1357LDedPer SET F1357LDPGNI=?, F1357LDPEspecial=?, F1357LDPEspecifica=?, F1357LDPConyuge=?, F1357LDPCantHijos=?, F1357LDPHijosImporte=?, F1357LDPTotalFami=?, F1357LDPTotalArt30=?, F1357LDPSujAntes=?, F1357LDPIncA=?, F1357LDPIncB=?, F1357LDPRemuSuj=?, F1357LDPCantHijIncap=?, F1357LDPHijosIncapImp=?, F1357LDPEspIncremen1=?, F1357LDPEspIncremen2=?, F1357LDPCantHij100PC=?, F1357ldpcAntHijIncap100pc=?, F1357LDPcantHijMay18=?, F1357LDPcantHijMay18_100pc=?  WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LDPTipReg = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002J14", "SAVEPOINT gxupdate;DELETE FROM F1357LDedPer  WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LDPTipReg = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002J15", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDPTipReg FROM F1357LDedPer ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDPTipReg ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002J16", "SELECT CliCod FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002J17", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
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
               ((int[]) buf[21])[0] = rslt.getInt(22);
               ((short[]) buf[22])[0] = rslt.getShort(23);
               ((int[]) buf[23])[0] = rslt.getInt(24);
               ((byte[]) buf[24])[0] = rslt.getByte(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 6);
               ((byte[]) buf[26])[0] = rslt.getByte(27);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 2);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
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
               ((int[]) buf[21])[0] = rslt.getInt(22);
               ((short[]) buf[22])[0] = rslt.getShort(23);
               ((int[]) buf[23])[0] = rslt.getInt(24);
               ((byte[]) buf[24])[0] = rslt.getByte(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 6);
               ((byte[]) buf[26])[0] = rslt.getByte(27);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 2);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
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
               ((int[]) buf[21])[0] = rslt.getInt(22);
               ((short[]) buf[22])[0] = rslt.getShort(23);
               ((int[]) buf[23])[0] = rslt.getInt(24);
               ((byte[]) buf[24])[0] = rslt.getByte(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 6);
               ((byte[]) buf[26])[0] = rslt.getByte(27);
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
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
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
               stmt.setInt(22, ((Number) parms[21]).intValue());
               stmt.setShort(23, ((Number) parms[22]).shortValue());
               stmt.setInt(24, ((Number) parms[23]).intValue());
               stmt.setByte(25, ((Number) parms[24]).byteValue());
               stmt.setString(26, (String)parms[25], 6);
               stmt.setByte(27, ((Number) parms[26]).byteValue());
               return;
            case 11 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
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
               stmt.setInt(21, ((Number) parms[20]).intValue());
               stmt.setShort(22, ((Number) parms[21]).shortValue());
               stmt.setByte(23, ((Number) parms[22]).byteValue());
               stmt.setString(24, (String)parms[23], 6);
               stmt.setByte(25, ((Number) parms[24]).byteValue());
               stmt.setInt(26, ((Number) parms[25]).intValue());
               stmt.setString(27, (String)parms[26], 2);
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

