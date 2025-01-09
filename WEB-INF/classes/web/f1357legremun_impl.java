package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class f1357legremun_impl extends GXDataArea
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
         Form.getMeta().addItem("description", httpContext.getMessage( "F1357 Leg Remu", ""), (short)(0)) ;
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

   public f1357legremun_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public f1357legremun_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357legremun_impl.class ));
   }

   public f1357legremun_impl( int remoteHandle ,
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "F1357 Leg Remu", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_F1357LegRemun.htm");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LegRemun.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LegRemun.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LegRemun.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LegRemun.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_F1357LegRemun.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357LegRemun.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_F1357LegRemun.htm");
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
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbF1357CTipoPre, cmbF1357CTipoPre.getInternalname(), GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0)), 1, cmbF1357CTipoPre.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbF1357CTipoPre.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", "", true, (byte)(0), "HLP_F1357LegRemun.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CPer_Internalname, GXutil.rtrim( A777F1357CPer), GXutil.rtrim( localUtil.format( A777F1357CPer, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CPer_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357CPer_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357LegRemun.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CSec_Internalname, GXutil.ltrim( localUtil.ntoc( A778F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357CSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A778F1357CSec), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A778F1357CSec), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357CSec_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357LegRemun.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegNumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_F1357LegRemun.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LRTipReg_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LRTipReg_Internalname, httpContext.getMessage( "LRTip Reg", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LRTipReg_Internalname, GXutil.rtrim( A797F1357LRTipReg), GXutil.rtrim( localUtil.format( A797F1357LRTipReg, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LRTipReg_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LRTipReg_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357LegRemun.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LRRemuneraciones_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LRRemuneraciones_Internalname, httpContext.getMessage( "LRRemuneraciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtF1357LRRemuneraciones_Internalname, A798F1357LRRemuneraciones, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", (short)(0), 1, edtF1357LRRemuneraciones_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_F1357LegRemun.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LRRemuOtr_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LRRemuOtr_Internalname, httpContext.getMessage( "Remuneraciones Otros empleos", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtF1357LRRemuOtr_Internalname, A799F1357LRRemuOtr, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", (short)(0), 1, edtF1357LRRemuOtr_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_F1357LegRemun.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LRGravada_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LRGravada_Internalname, httpContext.getMessage( "REMUNERACIÓN GRAVADA", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LRGravada_Internalname, GXutil.ltrim( localUtil.ntoc( A800F1357LRGravada, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LRGravada_Enabled!=0) ? localUtil.format( A800F1357LRGravada, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A800F1357LRGravada, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LRGravada_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LRGravada_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegRemun.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LRExenta_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LRExenta_Internalname, httpContext.getMessage( "REMUNERACIÓN NO GRAVADA / NO ALCANZADA / EXENTA", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LRExenta_Internalname, GXutil.ltrim( localUtil.ntoc( A801F1357LRExenta, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LRExenta_Enabled!=0) ? localUtil.format( A801F1357LRExenta, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A801F1357LRExenta, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,84);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LRExenta_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LRExenta_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegRemun.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LegRemun.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 91,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LegRemun.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LegRemun.htm");
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
         Z797F1357LRTipReg = httpContext.cgiGet( "Z797F1357LRTipReg") ;
         Z800F1357LRGravada = localUtil.ctond( httpContext.cgiGet( "Z800F1357LRGravada")) ;
         Z801F1357LRExenta = localUtil.ctond( httpContext.cgiGet( "Z801F1357LRExenta")) ;
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
         A797F1357LRTipReg = httpContext.cgiGet( edtF1357LRTipReg_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A797F1357LRTipReg", A797F1357LRTipReg);
         A798F1357LRRemuneraciones = httpContext.cgiGet( edtF1357LRRemuneraciones_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A798F1357LRRemuneraciones", A798F1357LRRemuneraciones);
         A799F1357LRRemuOtr = httpContext.cgiGet( edtF1357LRRemuOtr_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A799F1357LRRemuOtr", A799F1357LRRemuOtr);
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LRGravada_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LRGravada_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LRGRAVADA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LRGravada_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A800F1357LRGravada = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A800F1357LRGravada", GXutil.ltrimstr( A800F1357LRGravada, 16, 2));
         }
         else
         {
            A800F1357LRGravada = localUtil.ctond( httpContext.cgiGet( edtF1357LRGravada_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A800F1357LRGravada", GXutil.ltrimstr( A800F1357LRGravada, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LRExenta_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LRExenta_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LREXENTA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LRExenta_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A801F1357LRExenta = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A801F1357LRExenta", GXutil.ltrimstr( A801F1357LRExenta, 16, 2));
         }
         else
         {
            A801F1357LRExenta = localUtil.ctond( httpContext.cgiGet( edtF1357LRExenta_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A801F1357LRExenta", GXutil.ltrimstr( A801F1357LRExenta, 16, 2));
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
            A797F1357LRTipReg = httpContext.GetPar( "F1357LRTipReg") ;
            httpContext.ajax_rsp_assign_attri("", false, "A797F1357LRTipReg", A797F1357LRTipReg);
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
            initAll2H97( ) ;
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
      disableAttributes2H97( ) ;
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

   public void resetCaption2H0( )
   {
   }

   public void zm2H97( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z800F1357LRGravada = T002H3_A800F1357LRGravada[0] ;
            Z801F1357LRExenta = T002H3_A801F1357LRExenta[0] ;
         }
         else
         {
            Z800F1357LRGravada = A800F1357LRGravada ;
            Z801F1357LRExenta = A801F1357LRExenta ;
         }
      }
      if ( GX_JID == -2 )
      {
         Z797F1357LRTipReg = A797F1357LRTipReg ;
         Z798F1357LRRemuneraciones = A798F1357LRRemuneraciones ;
         Z799F1357LRRemuOtr = A799F1357LRRemuOtr ;
         Z800F1357LRGravada = A800F1357LRGravada ;
         Z801F1357LRExenta = A801F1357LRExenta ;
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

   public void load2H97( )
   {
      /* Using cursor T002H6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A797F1357LRTipReg});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound97 = (short)(1) ;
         A798F1357LRRemuneraciones = T002H6_A798F1357LRRemuneraciones[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A798F1357LRRemuneraciones", A798F1357LRRemuneraciones);
         A799F1357LRRemuOtr = T002H6_A799F1357LRRemuOtr[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A799F1357LRRemuOtr", A799F1357LRRemuOtr);
         A800F1357LRGravada = T002H6_A800F1357LRGravada[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A800F1357LRGravada", GXutil.ltrimstr( A800F1357LRGravada, 16, 2));
         A801F1357LRExenta = T002H6_A801F1357LRExenta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A801F1357LRExenta", GXutil.ltrimstr( A801F1357LRExenta, 16, 2));
         zm2H97( -2) ;
      }
      pr_default.close(4);
      onLoadActions2H97( ) ;
   }

   public void onLoadActions2H97( )
   {
   }

   public void checkExtendedTable2H97( )
   {
      nIsDirty_97 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      if ( ! ( ( A784F1357CTipoPre == 1 ) || ( A784F1357CTipoPre == 2 ) || ( A784F1357CTipoPre == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "F1357 CTipo Pre", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "F1357CTIPOPRE");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbF1357CTipoPre.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T002H5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Formulario F1357", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "F1357CSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
      /* Using cursor T002H4 */
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

   public void closeExtendedTableCursors2H97( )
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
      /* Using cursor T002H7 */
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
      /* Using cursor T002H8 */
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

   public void getKey2H97( )
   {
      /* Using cursor T002H9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A797F1357LRTipReg});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound97 = (short)(1) ;
      }
      else
      {
         RcdFound97 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T002H3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A797F1357LRTipReg});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm2H97( 2) ;
         RcdFound97 = (short)(1) ;
         A797F1357LRTipReg = T002H3_A797F1357LRTipReg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A797F1357LRTipReg", A797F1357LRTipReg);
         A798F1357LRRemuneraciones = T002H3_A798F1357LRRemuneraciones[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A798F1357LRRemuneraciones", A798F1357LRRemuneraciones);
         A799F1357LRRemuOtr = T002H3_A799F1357LRRemuOtr[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A799F1357LRRemuOtr", A799F1357LRRemuOtr);
         A800F1357LRGravada = T002H3_A800F1357LRGravada[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A800F1357LRGravada", GXutil.ltrimstr( A800F1357LRGravada, 16, 2));
         A801F1357LRExenta = T002H3_A801F1357LRExenta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A801F1357LRExenta", GXutil.ltrimstr( A801F1357LRExenta, 16, 2));
         A3CliCod = T002H3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002H3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T002H3_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A784F1357CTipoPre = T002H3_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002H3_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002H3_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z784F1357CTipoPre = A784F1357CTipoPre ;
         Z777F1357CPer = A777F1357CPer ;
         Z778F1357CSec = A778F1357CSec ;
         Z6LegNumero = A6LegNumero ;
         Z797F1357LRTipReg = A797F1357LRTipReg ;
         sMode97 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load2H97( ) ;
         if ( AnyError == 1 )
         {
            RcdFound97 = (short)(0) ;
            initializeNonKey2H97( ) ;
         }
         Gx_mode = sMode97 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound97 = (short)(0) ;
         initializeNonKey2H97( ) ;
         sMode97 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode97 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey2H97( ) ;
      if ( RcdFound97 == 0 )
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
      RcdFound97 = (short)(0) ;
      /* Using cursor T002H10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A784F1357CTipoPre), Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A777F1357CPer, A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A778F1357CSec), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A797F1357LRTipReg});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T002H10_A3CliCod[0] < A3CliCod ) || ( T002H10_A3CliCod[0] == A3CliCod ) && ( T002H10_A1EmpCod[0] < A1EmpCod ) || ( T002H10_A1EmpCod[0] == A1EmpCod ) && ( T002H10_A3CliCod[0] == A3CliCod ) && ( T002H10_A784F1357CTipoPre[0] < A784F1357CTipoPre ) || ( T002H10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002H10_A1EmpCod[0] == A1EmpCod ) && ( T002H10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002H10_A777F1357CPer[0], A777F1357CPer) < 0 ) || ( GXutil.strcmp(T002H10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002H10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002H10_A1EmpCod[0] == A1EmpCod ) && ( T002H10_A3CliCod[0] == A3CliCod ) && ( T002H10_A778F1357CSec[0] < A778F1357CSec ) || ( T002H10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002H10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002H10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002H10_A1EmpCod[0] == A1EmpCod ) && ( T002H10_A3CliCod[0] == A3CliCod ) && ( T002H10_A6LegNumero[0] < A6LegNumero ) || ( T002H10_A6LegNumero[0] == A6LegNumero ) && ( T002H10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002H10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002H10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002H10_A1EmpCod[0] == A1EmpCod ) && ( T002H10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002H10_A797F1357LRTipReg[0], A797F1357LRTipReg) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T002H10_A3CliCod[0] > A3CliCod ) || ( T002H10_A3CliCod[0] == A3CliCod ) && ( T002H10_A1EmpCod[0] > A1EmpCod ) || ( T002H10_A1EmpCod[0] == A1EmpCod ) && ( T002H10_A3CliCod[0] == A3CliCod ) && ( T002H10_A784F1357CTipoPre[0] > A784F1357CTipoPre ) || ( T002H10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002H10_A1EmpCod[0] == A1EmpCod ) && ( T002H10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002H10_A777F1357CPer[0], A777F1357CPer) > 0 ) || ( GXutil.strcmp(T002H10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002H10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002H10_A1EmpCod[0] == A1EmpCod ) && ( T002H10_A3CliCod[0] == A3CliCod ) && ( T002H10_A778F1357CSec[0] > A778F1357CSec ) || ( T002H10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002H10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002H10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002H10_A1EmpCod[0] == A1EmpCod ) && ( T002H10_A3CliCod[0] == A3CliCod ) && ( T002H10_A6LegNumero[0] > A6LegNumero ) || ( T002H10_A6LegNumero[0] == A6LegNumero ) && ( T002H10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002H10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002H10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002H10_A1EmpCod[0] == A1EmpCod ) && ( T002H10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002H10_A797F1357LRTipReg[0], A797F1357LRTipReg) > 0 ) ) )
         {
            A3CliCod = T002H10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002H10_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A784F1357CTipoPre = T002H10_A784F1357CTipoPre[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
            A777F1357CPer = T002H10_A777F1357CPer[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
            A778F1357CSec = T002H10_A778F1357CSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
            A6LegNumero = T002H10_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A797F1357LRTipReg = T002H10_A797F1357LRTipReg[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A797F1357LRTipReg", A797F1357LRTipReg);
            RcdFound97 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound97 = (short)(0) ;
      /* Using cursor T002H11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A784F1357CTipoPre), Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A777F1357CPer, A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A778F1357CSec), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A797F1357LRTipReg});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T002H11_A3CliCod[0] > A3CliCod ) || ( T002H11_A3CliCod[0] == A3CliCod ) && ( T002H11_A1EmpCod[0] > A1EmpCod ) || ( T002H11_A1EmpCod[0] == A1EmpCod ) && ( T002H11_A3CliCod[0] == A3CliCod ) && ( T002H11_A784F1357CTipoPre[0] > A784F1357CTipoPre ) || ( T002H11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002H11_A1EmpCod[0] == A1EmpCod ) && ( T002H11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002H11_A777F1357CPer[0], A777F1357CPer) > 0 ) || ( GXutil.strcmp(T002H11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002H11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002H11_A1EmpCod[0] == A1EmpCod ) && ( T002H11_A3CliCod[0] == A3CliCod ) && ( T002H11_A778F1357CSec[0] > A778F1357CSec ) || ( T002H11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002H11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002H11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002H11_A1EmpCod[0] == A1EmpCod ) && ( T002H11_A3CliCod[0] == A3CliCod ) && ( T002H11_A6LegNumero[0] > A6LegNumero ) || ( T002H11_A6LegNumero[0] == A6LegNumero ) && ( T002H11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002H11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002H11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002H11_A1EmpCod[0] == A1EmpCod ) && ( T002H11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002H11_A797F1357LRTipReg[0], A797F1357LRTipReg) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T002H11_A3CliCod[0] < A3CliCod ) || ( T002H11_A3CliCod[0] == A3CliCod ) && ( T002H11_A1EmpCod[0] < A1EmpCod ) || ( T002H11_A1EmpCod[0] == A1EmpCod ) && ( T002H11_A3CliCod[0] == A3CliCod ) && ( T002H11_A784F1357CTipoPre[0] < A784F1357CTipoPre ) || ( T002H11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002H11_A1EmpCod[0] == A1EmpCod ) && ( T002H11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002H11_A777F1357CPer[0], A777F1357CPer) < 0 ) || ( GXutil.strcmp(T002H11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002H11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002H11_A1EmpCod[0] == A1EmpCod ) && ( T002H11_A3CliCod[0] == A3CliCod ) && ( T002H11_A778F1357CSec[0] < A778F1357CSec ) || ( T002H11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002H11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002H11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002H11_A1EmpCod[0] == A1EmpCod ) && ( T002H11_A3CliCod[0] == A3CliCod ) && ( T002H11_A6LegNumero[0] < A6LegNumero ) || ( T002H11_A6LegNumero[0] == A6LegNumero ) && ( T002H11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002H11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002H11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002H11_A1EmpCod[0] == A1EmpCod ) && ( T002H11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002H11_A797F1357LRTipReg[0], A797F1357LRTipReg) < 0 ) ) )
         {
            A3CliCod = T002H11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002H11_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A784F1357CTipoPre = T002H11_A784F1357CTipoPre[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
            A777F1357CPer = T002H11_A777F1357CPer[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
            A778F1357CSec = T002H11_A778F1357CSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
            A6LegNumero = T002H11_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A797F1357LRTipReg = T002H11_A797F1357LRTipReg[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A797F1357LRTipReg", A797F1357LRTipReg);
            RcdFound97 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2H97( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert2H97( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound97 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A797F1357LRTipReg, Z797F1357LRTipReg) != 0 ) )
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
               A797F1357LRTipReg = Z797F1357LRTipReg ;
               httpContext.ajax_rsp_assign_attri("", false, "A797F1357LRTipReg", A797F1357LRTipReg);
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
               update2H97( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A797F1357LRTipReg, Z797F1357LRTipReg) != 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert2H97( ) ;
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
                  insert2H97( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A797F1357LRTipReg, Z797F1357LRTipReg) != 0 ) )
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
         A797F1357LRTipReg = Z797F1357LRTipReg ;
         httpContext.ajax_rsp_assign_attri("", false, "A797F1357LRTipReg", A797F1357LRTipReg);
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
      if ( RcdFound97 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtF1357LRRemuneraciones_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart2H97( ) ;
      if ( RcdFound97 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtF1357LRRemuneraciones_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd2H97( ) ;
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
      if ( RcdFound97 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtF1357LRRemuneraciones_Internalname ;
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
      if ( RcdFound97 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtF1357LRRemuneraciones_Internalname ;
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
      scanStart2H97( ) ;
      if ( RcdFound97 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound97 != 0 )
         {
            scanNext2H97( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtF1357LRRemuneraciones_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd2H97( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency2H97( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002H2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A797F1357LRTipReg});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"F1357LegRemun"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z800F1357LRGravada, T002H2_A800F1357LRGravada[0]) != 0 ) || ( DecimalUtil.compareTo(Z801F1357LRExenta, T002H2_A801F1357LRExenta[0]) != 0 ) )
         {
            if ( DecimalUtil.compareTo(Z800F1357LRGravada, T002H2_A800F1357LRGravada[0]) != 0 )
            {
               GXutil.writeLogln("f1357legremun:[seudo value changed for attri]"+"F1357LRGravada");
               GXutil.writeLogRaw("Old: ",Z800F1357LRGravada);
               GXutil.writeLogRaw("Current: ",T002H2_A800F1357LRGravada[0]);
            }
            if ( DecimalUtil.compareTo(Z801F1357LRExenta, T002H2_A801F1357LRExenta[0]) != 0 )
            {
               GXutil.writeLogln("f1357legremun:[seudo value changed for attri]"+"F1357LRExenta");
               GXutil.writeLogRaw("Old: ",Z801F1357LRExenta);
               GXutil.writeLogRaw("Current: ",T002H2_A801F1357LRExenta[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"F1357LegRemun"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2H97( )
   {
      beforeValidate2H97( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2H97( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2H97( 0) ;
         checkOptimisticConcurrency2H97( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2H97( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2H97( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002H12 */
                  pr_default.execute(10, new Object[] {A797F1357LRTipReg, A798F1357LRRemuneraciones, A799F1357LRRemuOtr, A800F1357LRGravada, A801F1357LRExenta, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357LegRemun");
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
                        resetCaption2H0( ) ;
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
            load2H97( ) ;
         }
         endLevel2H97( ) ;
      }
      closeExtendedTableCursors2H97( ) ;
   }

   public void update2H97( )
   {
      beforeValidate2H97( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2H97( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2H97( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2H97( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2H97( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002H13 */
                  pr_default.execute(11, new Object[] {A798F1357LRRemuneraciones, A799F1357LRRemuOtr, A800F1357LRGravada, A801F1357LRExenta, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A797F1357LRTipReg});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357LegRemun");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"F1357LegRemun"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2H97( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption2H0( ) ;
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
         endLevel2H97( ) ;
      }
      closeExtendedTableCursors2H97( ) ;
   }

   public void deferredUpdate2H97( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate2H97( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2H97( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2H97( ) ;
         afterConfirm2H97( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2H97( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002H14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A797F1357LRTipReg});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357LegRemun");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound97 == 0 )
                     {
                        initAll2H97( ) ;
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
                     resetCaption2H0( ) ;
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
      sMode97 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2H97( ) ;
      Gx_mode = sMode97 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2H97( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel2H97( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2H97( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "f1357legremun");
         if ( AnyError == 0 )
         {
            confirmValues2H0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "f1357legremun");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2H97( )
   {
      /* Using cursor T002H15 */
      pr_default.execute(13);
      RcdFound97 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound97 = (short)(1) ;
         A3CliCod = T002H15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002H15_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A784F1357CTipoPre = T002H15_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002H15_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002H15_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         A6LegNumero = T002H15_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A797F1357LRTipReg = T002H15_A797F1357LRTipReg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A797F1357LRTipReg", A797F1357LRTipReg);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2H97( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound97 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound97 = (short)(1) ;
         A3CliCod = T002H15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002H15_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A784F1357CTipoPre = T002H15_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002H15_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002H15_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         A6LegNumero = T002H15_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A797F1357LRTipReg = T002H15_A797F1357LRTipReg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A797F1357LRTipReg", A797F1357LRTipReg);
      }
   }

   public void scanEnd2H97( )
   {
      pr_default.close(13);
   }

   public void afterConfirm2H97( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2H97( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2H97( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2H97( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2H97( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2H97( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2H97( )
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
      edtF1357LRTipReg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LRTipReg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LRTipReg_Enabled), 5, 0), true);
      edtF1357LRRemuneraciones_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LRRemuneraciones_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LRRemuneraciones_Enabled), 5, 0), true);
      edtF1357LRRemuOtr_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LRRemuOtr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LRRemuOtr_Enabled), 5, 0), true);
      edtF1357LRGravada_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LRGravada_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LRGravada_Enabled), 5, 0), true);
      edtF1357LRExenta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LRExenta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LRExenta_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes2H97( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues2H0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.f1357legremun", new String[] {}, new String[] {}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "Z797F1357LRTipReg", GXutil.rtrim( Z797F1357LRTipReg));
      web.GxWebStd.gx_hidden_field( httpContext, "Z800F1357LRGravada", GXutil.ltrim( localUtil.ntoc( Z800F1357LRGravada, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z801F1357LRExenta", GXutil.ltrim( localUtil.ntoc( Z801F1357LRExenta, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      return formatLink("web.f1357legremun", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "F1357LegRemun" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "F1357 Leg Remu", "") ;
   }

   public void initializeNonKey2H97( )
   {
      A798F1357LRRemuneraciones = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A798F1357LRRemuneraciones", A798F1357LRRemuneraciones);
      A799F1357LRRemuOtr = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A799F1357LRRemuOtr", A799F1357LRRemuOtr);
      A800F1357LRGravada = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A800F1357LRGravada", GXutil.ltrimstr( A800F1357LRGravada, 16, 2));
      A801F1357LRExenta = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A801F1357LRExenta", GXutil.ltrimstr( A801F1357LRExenta, 16, 2));
      Z800F1357LRGravada = DecimalUtil.ZERO ;
      Z801F1357LRExenta = DecimalUtil.ZERO ;
   }

   public void initAll2H97( )
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
      A797F1357LRTipReg = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A797F1357LRTipReg", A797F1357LRTipReg);
      initializeNonKey2H97( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713391264", true, true);
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
      httpContext.AddJavascriptSource("f1357legremun.js", "?20251713391265", false, true);
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
      edtF1357LRTipReg_Internalname = "F1357LRTIPREG" ;
      edtF1357LRRemuneraciones_Internalname = "F1357LRREMUNERACIONES" ;
      edtF1357LRRemuOtr_Internalname = "F1357LRREMUOTR" ;
      edtF1357LRGravada_Internalname = "F1357LRGRAVADA" ;
      edtF1357LRExenta_Internalname = "F1357LREXENTA" ;
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
      Form.setCaption( httpContext.getMessage( "F1357 Leg Remu", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtF1357LRExenta_Jsonclick = "" ;
      edtF1357LRExenta_Enabled = 1 ;
      edtF1357LRGravada_Jsonclick = "" ;
      edtF1357LRGravada_Enabled = 1 ;
      edtF1357LRRemuOtr_Enabled = 1 ;
      edtF1357LRRemuneraciones_Enabled = 1 ;
      edtF1357LRTipReg_Jsonclick = "" ;
      edtF1357LRTipReg_Enabled = 1 ;
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
      /* Using cursor T002H16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Formulario F1357", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "F1357CSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(14);
      /* Using cursor T002H17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(15);
      GX_FocusControl = edtF1357LRRemuneraciones_Internalname ;
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
      /* Using cursor T002H16 */
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
      /* Using cursor T002H17 */
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

   public void valid_F1357lrtipreg( )
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
      httpContext.ajax_rsp_assign_attri("", false, "A798F1357LRRemuneraciones", A798F1357LRRemuneraciones);
      httpContext.ajax_rsp_assign_attri("", false, "A799F1357LRRemuOtr", A799F1357LRRemuOtr);
      httpContext.ajax_rsp_assign_attri("", false, "A800F1357LRGravada", GXutil.ltrim( localUtil.ntoc( A800F1357LRGravada, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A801F1357LRExenta", GXutil.ltrim( localUtil.ntoc( A801F1357LRExenta, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z784F1357CTipoPre", GXutil.ltrim( localUtil.ntoc( Z784F1357CTipoPre, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z777F1357CPer", GXutil.rtrim( Z777F1357CPer));
      web.GxWebStd.gx_hidden_field( httpContext, "Z778F1357CSec", GXutil.ltrim( localUtil.ntoc( Z778F1357CSec, (byte)(2), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z797F1357LRTipReg", GXutil.rtrim( Z797F1357LRTipReg));
      web.GxWebStd.gx_hidden_field( httpContext, "Z798F1357LRRemuneraciones", Z798F1357LRRemuneraciones);
      web.GxWebStd.gx_hidden_field( httpContext, "Z799F1357LRRemuOtr", Z799F1357LRRemuOtr);
      web.GxWebStd.gx_hidden_field( httpContext, "Z800F1357LRGravada", GXutil.ltrim( localUtil.ntoc( Z800F1357LRGravada, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z801F1357LRExenta", GXutil.ltrim( localUtil.ntoc( Z801F1357LRExenta, (byte)(16), (byte)(2), ".", "")));
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
      setEventMetadata("VALID_F1357LRTIPREG","{handler:'valid_F1357lrtipreg',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'cmbF1357CTipoPre'},{av:'A784F1357CTipoPre',fld:'F1357CTIPOPRE',pic:'9'},{av:'A777F1357CPer',fld:'F1357CPER',pic:''},{av:'A778F1357CSec',fld:'F1357CSEC',pic:'Z9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A797F1357LRTipReg',fld:'F1357LRTIPREG',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_F1357LRTIPREG",",oparms:[{av:'A798F1357LRRemuneraciones',fld:'F1357LRREMUNERACIONES',pic:''},{av:'A799F1357LRRemuOtr',fld:'F1357LRREMUOTR',pic:''},{av:'A800F1357LRGravada',fld:'F1357LRGRAVADA',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A801F1357LRExenta',fld:'F1357LREXENTA',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z3CliCod'},{av:'Z1EmpCod'},{av:'Z784F1357CTipoPre'},{av:'Z777F1357CPer'},{av:'Z778F1357CSec'},{av:'Z6LegNumero'},{av:'Z797F1357LRTipReg'},{av:'Z798F1357LRRemuneraciones'},{av:'Z799F1357LRRemuOtr'},{av:'Z800F1357LRGravada'},{av:'Z801F1357LRExenta'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
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
      Z797F1357LRTipReg = "" ;
      Z800F1357LRGravada = DecimalUtil.ZERO ;
      Z801F1357LRExenta = DecimalUtil.ZERO ;
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
      A797F1357LRTipReg = "" ;
      A798F1357LRRemuneraciones = "" ;
      A799F1357LRRemuOtr = "" ;
      A800F1357LRGravada = DecimalUtil.ZERO ;
      A801F1357LRExenta = DecimalUtil.ZERO ;
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
      Z798F1357LRRemuneraciones = "" ;
      Z799F1357LRRemuOtr = "" ;
      T002H6_A797F1357LRTipReg = new String[] {""} ;
      T002H6_A798F1357LRRemuneraciones = new String[] {""} ;
      T002H6_A799F1357LRRemuOtr = new String[] {""} ;
      T002H6_A800F1357LRGravada = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002H6_A801F1357LRExenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002H6_A3CliCod = new int[1] ;
      T002H6_A1EmpCod = new short[1] ;
      T002H6_A6LegNumero = new int[1] ;
      T002H6_A784F1357CTipoPre = new byte[1] ;
      T002H6_A777F1357CPer = new String[] {""} ;
      T002H6_A778F1357CSec = new byte[1] ;
      T002H5_A3CliCod = new int[1] ;
      T002H4_A3CliCod = new int[1] ;
      T002H7_A3CliCod = new int[1] ;
      T002H8_A3CliCod = new int[1] ;
      T002H9_A3CliCod = new int[1] ;
      T002H9_A1EmpCod = new short[1] ;
      T002H9_A784F1357CTipoPre = new byte[1] ;
      T002H9_A777F1357CPer = new String[] {""} ;
      T002H9_A778F1357CSec = new byte[1] ;
      T002H9_A6LegNumero = new int[1] ;
      T002H9_A797F1357LRTipReg = new String[] {""} ;
      T002H3_A797F1357LRTipReg = new String[] {""} ;
      T002H3_A798F1357LRRemuneraciones = new String[] {""} ;
      T002H3_A799F1357LRRemuOtr = new String[] {""} ;
      T002H3_A800F1357LRGravada = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002H3_A801F1357LRExenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002H3_A3CliCod = new int[1] ;
      T002H3_A1EmpCod = new short[1] ;
      T002H3_A6LegNumero = new int[1] ;
      T002H3_A784F1357CTipoPre = new byte[1] ;
      T002H3_A777F1357CPer = new String[] {""} ;
      T002H3_A778F1357CSec = new byte[1] ;
      sMode97 = "" ;
      T002H10_A3CliCod = new int[1] ;
      T002H10_A1EmpCod = new short[1] ;
      T002H10_A784F1357CTipoPre = new byte[1] ;
      T002H10_A777F1357CPer = new String[] {""} ;
      T002H10_A778F1357CSec = new byte[1] ;
      T002H10_A6LegNumero = new int[1] ;
      T002H10_A797F1357LRTipReg = new String[] {""} ;
      T002H11_A3CliCod = new int[1] ;
      T002H11_A1EmpCod = new short[1] ;
      T002H11_A784F1357CTipoPre = new byte[1] ;
      T002H11_A777F1357CPer = new String[] {""} ;
      T002H11_A778F1357CSec = new byte[1] ;
      T002H11_A6LegNumero = new int[1] ;
      T002H11_A797F1357LRTipReg = new String[] {""} ;
      T002H2_A797F1357LRTipReg = new String[] {""} ;
      T002H2_A798F1357LRRemuneraciones = new String[] {""} ;
      T002H2_A799F1357LRRemuOtr = new String[] {""} ;
      T002H2_A800F1357LRGravada = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002H2_A801F1357LRExenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002H2_A3CliCod = new int[1] ;
      T002H2_A1EmpCod = new short[1] ;
      T002H2_A6LegNumero = new int[1] ;
      T002H2_A784F1357CTipoPre = new byte[1] ;
      T002H2_A777F1357CPer = new String[] {""} ;
      T002H2_A778F1357CSec = new byte[1] ;
      T002H15_A3CliCod = new int[1] ;
      T002H15_A1EmpCod = new short[1] ;
      T002H15_A784F1357CTipoPre = new byte[1] ;
      T002H15_A777F1357CPer = new String[] {""} ;
      T002H15_A778F1357CSec = new byte[1] ;
      T002H15_A6LegNumero = new int[1] ;
      T002H15_A797F1357LRTipReg = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T002H16_A3CliCod = new int[1] ;
      T002H17_A3CliCod = new int[1] ;
      ZZ777F1357CPer = "" ;
      ZZ797F1357LRTipReg = "" ;
      ZZ798F1357LRRemuneraciones = "" ;
      ZZ799F1357LRRemuOtr = "" ;
      ZZ800F1357LRGravada = DecimalUtil.ZERO ;
      ZZ801F1357LRExenta = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357legremun__default(),
         new Object[] {
             new Object[] {
            T002H2_A797F1357LRTipReg, T002H2_A798F1357LRRemuneraciones, T002H2_A799F1357LRRemuOtr, T002H2_A800F1357LRGravada, T002H2_A801F1357LRExenta, T002H2_A3CliCod, T002H2_A1EmpCod, T002H2_A6LegNumero, T002H2_A784F1357CTipoPre, T002H2_A777F1357CPer,
            T002H2_A778F1357CSec
            }
            , new Object[] {
            T002H3_A797F1357LRTipReg, T002H3_A798F1357LRRemuneraciones, T002H3_A799F1357LRRemuOtr, T002H3_A800F1357LRGravada, T002H3_A801F1357LRExenta, T002H3_A3CliCod, T002H3_A1EmpCod, T002H3_A6LegNumero, T002H3_A784F1357CTipoPre, T002H3_A777F1357CPer,
            T002H3_A778F1357CSec
            }
            , new Object[] {
            T002H4_A3CliCod
            }
            , new Object[] {
            T002H5_A3CliCod
            }
            , new Object[] {
            T002H6_A797F1357LRTipReg, T002H6_A798F1357LRRemuneraciones, T002H6_A799F1357LRRemuOtr, T002H6_A800F1357LRGravada, T002H6_A801F1357LRExenta, T002H6_A3CliCod, T002H6_A1EmpCod, T002H6_A6LegNumero, T002H6_A784F1357CTipoPre, T002H6_A777F1357CPer,
            T002H6_A778F1357CSec
            }
            , new Object[] {
            T002H7_A3CliCod
            }
            , new Object[] {
            T002H8_A3CliCod
            }
            , new Object[] {
            T002H9_A3CliCod, T002H9_A1EmpCod, T002H9_A784F1357CTipoPre, T002H9_A777F1357CPer, T002H9_A778F1357CSec, T002H9_A6LegNumero, T002H9_A797F1357LRTipReg
            }
            , new Object[] {
            T002H10_A3CliCod, T002H10_A1EmpCod, T002H10_A784F1357CTipoPre, T002H10_A777F1357CPer, T002H10_A778F1357CSec, T002H10_A6LegNumero, T002H10_A797F1357LRTipReg
            }
            , new Object[] {
            T002H11_A3CliCod, T002H11_A1EmpCod, T002H11_A784F1357CTipoPre, T002H11_A777F1357CPer, T002H11_A778F1357CSec, T002H11_A6LegNumero, T002H11_A797F1357LRTipReg
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002H15_A3CliCod, T002H15_A1EmpCod, T002H15_A784F1357CTipoPre, T002H15_A777F1357CPer, T002H15_A778F1357CSec, T002H15_A6LegNumero, T002H15_A797F1357LRTipReg
            }
            , new Object[] {
            T002H16_A3CliCod
            }
            , new Object[] {
            T002H17_A3CliCod
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
   private short RcdFound97 ;
   private short nIsDirty_97 ;
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
   private int edtF1357LRTipReg_Enabled ;
   private int edtF1357LRRemuneraciones_Enabled ;
   private int edtF1357LRRemuOtr_Enabled ;
   private int edtF1357LRGravada_Enabled ;
   private int edtF1357LRExenta_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ3CliCod ;
   private int ZZ6LegNumero ;
   private java.math.BigDecimal Z800F1357LRGravada ;
   private java.math.BigDecimal Z801F1357LRExenta ;
   private java.math.BigDecimal A800F1357LRGravada ;
   private java.math.BigDecimal A801F1357LRExenta ;
   private java.math.BigDecimal ZZ800F1357LRGravada ;
   private java.math.BigDecimal ZZ801F1357LRExenta ;
   private String sPrefix ;
   private String Z777F1357CPer ;
   private String Z797F1357LRTipReg ;
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
   private String edtF1357LRTipReg_Internalname ;
   private String A797F1357LRTipReg ;
   private String edtF1357LRTipReg_Jsonclick ;
   private String edtF1357LRRemuneraciones_Internalname ;
   private String edtF1357LRRemuOtr_Internalname ;
   private String edtF1357LRGravada_Internalname ;
   private String edtF1357LRGravada_Jsonclick ;
   private String edtF1357LRExenta_Internalname ;
   private String edtF1357LRExenta_Jsonclick ;
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
   private String sMode97 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ777F1357CPer ;
   private String ZZ797F1357LRTipReg ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private String A798F1357LRRemuneraciones ;
   private String A799F1357LRRemuOtr ;
   private String Z798F1357LRRemuneraciones ;
   private String Z799F1357LRRemuOtr ;
   private String ZZ798F1357LRRemuneraciones ;
   private String ZZ799F1357LRRemuOtr ;
   private HTMLChoice cmbF1357CTipoPre ;
   private IDataStoreProvider pr_default ;
   private String[] T002H6_A797F1357LRTipReg ;
   private String[] T002H6_A798F1357LRRemuneraciones ;
   private String[] T002H6_A799F1357LRRemuOtr ;
   private java.math.BigDecimal[] T002H6_A800F1357LRGravada ;
   private java.math.BigDecimal[] T002H6_A801F1357LRExenta ;
   private int[] T002H6_A3CliCod ;
   private short[] T002H6_A1EmpCod ;
   private int[] T002H6_A6LegNumero ;
   private byte[] T002H6_A784F1357CTipoPre ;
   private String[] T002H6_A777F1357CPer ;
   private byte[] T002H6_A778F1357CSec ;
   private int[] T002H5_A3CliCod ;
   private int[] T002H4_A3CliCod ;
   private int[] T002H7_A3CliCod ;
   private int[] T002H8_A3CliCod ;
   private int[] T002H9_A3CliCod ;
   private short[] T002H9_A1EmpCod ;
   private byte[] T002H9_A784F1357CTipoPre ;
   private String[] T002H9_A777F1357CPer ;
   private byte[] T002H9_A778F1357CSec ;
   private int[] T002H9_A6LegNumero ;
   private String[] T002H9_A797F1357LRTipReg ;
   private String[] T002H3_A797F1357LRTipReg ;
   private String[] T002H3_A798F1357LRRemuneraciones ;
   private String[] T002H3_A799F1357LRRemuOtr ;
   private java.math.BigDecimal[] T002H3_A800F1357LRGravada ;
   private java.math.BigDecimal[] T002H3_A801F1357LRExenta ;
   private int[] T002H3_A3CliCod ;
   private short[] T002H3_A1EmpCod ;
   private int[] T002H3_A6LegNumero ;
   private byte[] T002H3_A784F1357CTipoPre ;
   private String[] T002H3_A777F1357CPer ;
   private byte[] T002H3_A778F1357CSec ;
   private int[] T002H10_A3CliCod ;
   private short[] T002H10_A1EmpCod ;
   private byte[] T002H10_A784F1357CTipoPre ;
   private String[] T002H10_A777F1357CPer ;
   private byte[] T002H10_A778F1357CSec ;
   private int[] T002H10_A6LegNumero ;
   private String[] T002H10_A797F1357LRTipReg ;
   private int[] T002H11_A3CliCod ;
   private short[] T002H11_A1EmpCod ;
   private byte[] T002H11_A784F1357CTipoPre ;
   private String[] T002H11_A777F1357CPer ;
   private byte[] T002H11_A778F1357CSec ;
   private int[] T002H11_A6LegNumero ;
   private String[] T002H11_A797F1357LRTipReg ;
   private String[] T002H2_A797F1357LRTipReg ;
   private String[] T002H2_A798F1357LRRemuneraciones ;
   private String[] T002H2_A799F1357LRRemuOtr ;
   private java.math.BigDecimal[] T002H2_A800F1357LRGravada ;
   private java.math.BigDecimal[] T002H2_A801F1357LRExenta ;
   private int[] T002H2_A3CliCod ;
   private short[] T002H2_A1EmpCod ;
   private int[] T002H2_A6LegNumero ;
   private byte[] T002H2_A784F1357CTipoPre ;
   private String[] T002H2_A777F1357CPer ;
   private byte[] T002H2_A778F1357CSec ;
   private int[] T002H15_A3CliCod ;
   private short[] T002H15_A1EmpCod ;
   private byte[] T002H15_A784F1357CTipoPre ;
   private String[] T002H15_A777F1357CPer ;
   private byte[] T002H15_A778F1357CSec ;
   private int[] T002H15_A6LegNumero ;
   private String[] T002H15_A797F1357LRTipReg ;
   private int[] T002H16_A3CliCod ;
   private int[] T002H17_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class f1357legremun__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T002H2", "SELECT F1357LRTipReg, F1357LRRemuneraciones, F1357LRRemuOtr, F1357LRGravada, F1357LRExenta, CliCod, EmpCod, LegNumero, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357LegRemun WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LRTipReg = ?  FOR UPDATE OF F1357LegRemun NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002H3", "SELECT F1357LRTipReg, F1357LRRemuneraciones, F1357LRRemuOtr, F1357LRGravada, F1357LRExenta, CliCod, EmpCod, LegNumero, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357LegRemun WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LRTipReg = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002H4", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002H5", "SELECT CliCod FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002H6", "SELECT TM1.F1357LRTipReg, TM1.F1357LRRemuneraciones, TM1.F1357LRRemuOtr, TM1.F1357LRGravada, TM1.F1357LRExenta, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.F1357CTipoPre, TM1.F1357CPer, TM1.F1357CSec FROM F1357LegRemun TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.F1357CTipoPre = ? and TM1.F1357CPer = ( ?) and TM1.F1357CSec = ? and TM1.LegNumero = ? and TM1.F1357LRTipReg = ( ?) ORDER BY TM1.CliCod, TM1.EmpCod, TM1.F1357CTipoPre, TM1.F1357CPer, TM1.F1357CSec, TM1.LegNumero, TM1.F1357LRTipReg ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002H7", "SELECT CliCod FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002H8", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002H9", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LRTipReg FROM F1357LegRemun WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LRTipReg = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002H10", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LRTipReg FROM F1357LegRemun WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and F1357CTipoPre > ? or F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CPer > ( ?) or F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CSec > ? or F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and LegNumero > ? or LegNumero = ? and F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357LRTipReg > ( ?)) ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LRTipReg  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002H11", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LRTipReg FROM F1357LegRemun WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and F1357CTipoPre < ? or F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CPer < ( ?) or F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CSec < ? or F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and LegNumero < ? or LegNumero = ? and F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357LRTipReg < ( ?)) ORDER BY CliCod DESC, EmpCod DESC, F1357CTipoPre DESC, F1357CPer DESC, F1357CSec DESC, LegNumero DESC, F1357LRTipReg DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T002H12", "SAVEPOINT gxupdate;INSERT INTO F1357LegRemun(F1357LRTipReg, F1357LRRemuneraciones, F1357LRRemuOtr, F1357LRGravada, F1357LRExenta, CliCod, EmpCod, LegNumero, F1357CTipoPre, F1357CPer, F1357CSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002H13", "SAVEPOINT gxupdate;UPDATE F1357LegRemun SET F1357LRRemuneraciones=?, F1357LRRemuOtr=?, F1357LRGravada=?, F1357LRExenta=?  WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LRTipReg = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002H14", "SAVEPOINT gxupdate;DELETE FROM F1357LegRemun  WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LRTipReg = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002H15", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LRTipReg FROM F1357LegRemun ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LRTipReg ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002H16", "SELECT CliCod FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002H17", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 6);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 2);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 6);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 2);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 6);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
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
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setString(10, (String)parms[9], 6);
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               return;
            case 11 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setString(8, (String)parms[7], 6);
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setString(11, (String)parms[10], 2);
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

