package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class f1357legdedgen_impl extends GXDataArea
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
         Form.getMeta().addItem("description", httpContext.getMessage( "F1357 Leg Ded Gen", ""), (short)(0)) ;
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

   public f1357legdedgen_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public f1357legdedgen_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357legdedgen_impl.class ));
   }

   public f1357legdedgen_impl( int remoteHandle ,
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "F1357 Leg Ded Gen", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_F1357LegDedGen.htm");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_F1357LegDedGen.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357LegDedGen.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_F1357LegDedGen.htm");
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
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbF1357CTipoPre, cmbF1357CTipoPre.getInternalname(), GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0)), 1, cmbF1357CTipoPre.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbF1357CTipoPre.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", "", true, (byte)(0), "HLP_F1357LegDedGen.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CPer_Internalname, GXutil.rtrim( A777F1357CPer), GXutil.rtrim( localUtil.format( A777F1357CPer, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CPer_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357CPer_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357LegDedGen.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CSec_Internalname, GXutil.ltrim( localUtil.ntoc( A778F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357CSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A778F1357CSec), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A778F1357CSec), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357CSec_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357LegDedGen.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegNumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGTipReg_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGTipReg_Internalname, httpContext.getMessage( "LDGTip Reg", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGTipReg_Internalname, GXutil.rtrim( A863F1357LDGTipReg), GXutil.rtrim( localUtil.format( A863F1357LDGTipReg, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGTipReg_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGTipReg_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGPrepaga_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGPrepaga_Internalname, httpContext.getMessage( "CUOTAS MÉDICO ASISTENCIALES", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGPrepaga_Internalname, GXutil.ltrim( localUtil.ntoc( A802F1357LDGPrepaga, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGPrepaga_Enabled!=0) ? localUtil.format( A802F1357LDGPrepaga, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A802F1357LDGPrepaga, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGPrepaga_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGPrepaga_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGSeguro_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGSeguro_Internalname, httpContext.getMessage( "PRIMAS DE SEGURO PARA EL CASO DE MUERTE", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGSeguro_Internalname, GXutil.ltrim( localUtil.ntoc( A803F1357LDGSeguro, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGSeguro_Enabled!=0) ? localUtil.format( A803F1357LDGSeguro, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A803F1357LDGSeguro, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGSeguro_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGSeguro_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGSeguMixto_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGSeguMixto_Internalname, httpContext.getMessage( "SEGUROS MUERTE/MIXTOS SUJETAS AL CONTROL DE LA SSN", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGSeguMixto_Internalname, GXutil.ltrim( localUtil.ntoc( A804F1357LDGSeguMixto, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGSeguMixto_Enabled!=0) ? localUtil.format( A804F1357LDGSeguMixto, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A804F1357LDGSeguMixto, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGSeguMixto_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGSeguMixto_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGRetPriv_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGRetPriv_Internalname, httpContext.getMessage( "SEGURO DE RETIRO PRIVADOS -SUJETAS AL CONTROL DE LA SSN", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGRetPriv_Internalname, GXutil.ltrim( localUtil.ntoc( A805F1357LDGRetPriv, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGRetPriv_Enabled!=0) ? localUtil.format( A805F1357LDGRetPriv, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A805F1357LDGRetPriv, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,84);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGRetPriv_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGRetPriv_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGCuotapartes_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGCuotapartes_Internalname, httpContext.getMessage( "ADQUISICIÓN DE CUOTAPARTES DE FCI CON FINES DE RETIRO", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGCuotapartes_Internalname, GXutil.ltrim( localUtil.ntoc( A806F1357LDGCuotapartes, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGCuotapartes_Enabled!=0) ? localUtil.format( A806F1357LDGCuotapartes, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A806F1357LDGCuotapartes, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,89);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGCuotapartes_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGCuotapartes_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGSepelio_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGSepelio_Internalname, httpContext.getMessage( "GASTOS DE SEPELIO", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGSepelio_Internalname, GXutil.ltrim( localUtil.ntoc( A807F1357LDGSepelio, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGSepelio_Enabled!=0) ? localUtil.format( A807F1357LDGSepelio, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A807F1357LDGSepelio, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,94);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGSepelio_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGSepelio_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGRodado_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGRodado_Internalname, httpContext.getMessage( "GTOS AMORT E INT RODADO CORREDORES Y VIAJANTES DE COMERCIO", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGRodado_Internalname, GXutil.ltrim( localUtil.ntoc( A808F1357LDGRodado, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGRodado_Enabled!=0) ? localUtil.format( A808F1357LDGRodado, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A808F1357LDGRodado, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,99);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGRodado_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGRodado_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGDonaciones_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGDonaciones_Internalname, httpContext.getMessage( "DONAC. FISCOS NAC./PROV./MUN./INST. ART 26 INC. E) Y F) LIG", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGDonaciones_Internalname, GXutil.ltrim( localUtil.ntoc( A809F1357LDGDonaciones, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGDonaciones_Enabled!=0) ? localUtil.format( A809F1357LDGDonaciones, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A809F1357LDGDonaciones, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,104);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGDonaciones_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGDonaciones_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGOblig_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGOblig_Internalname, httpContext.getMessage( "DTOS OBLIG POR LEY NACIONAL, PROVINCIAL O MUNICIPAL", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGOblig_Internalname, GXutil.ltrim( localUtil.ntoc( A810F1357LDGOblig, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGOblig_Enabled!=0) ? localUtil.format( A810F1357LDGOblig, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A810F1357LDGOblig, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,109);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGOblig_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGOblig_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGMed_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGMed_Internalname, httpContext.getMessage( "HONORARIOS SERV. ASISTENCIA SANITARIA, MÉDICA Y PARAMÉDICA", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 114,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGMed_Internalname, GXutil.ltrim( localUtil.ntoc( A811F1357LDGMed, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGMed_Enabled!=0) ? localUtil.format( A811F1357LDGMed, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A811F1357LDGMed, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,114);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGMed_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGMed_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGHipoteca_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGHipoteca_Internalname, httpContext.getMessage( "INTERESES CRÉDITOS HIPOTECARIOS", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 119,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGHipoteca_Internalname, GXutil.ltrim( localUtil.ntoc( A812F1357LDGHipoteca, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGHipoteca_Enabled!=0) ? localUtil.format( A812F1357LDGHipoteca, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A812F1357LDGHipoteca, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,119);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGHipoteca_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGHipoteca_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGSGR_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGSGR_Internalname, httpContext.getMessage( "AP. CAP. SOC. /FONDO DE RIESGO DE SOCIOS PROTECTORES DE SGR", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 124,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGSGR_Internalname, GXutil.ltrim( localUtil.ntoc( A813F1357LDGSGR, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGSGR_Enabled!=0) ? localUtil.format( A813F1357LDGSGR, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A813F1357LDGSGR, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,124);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGSGR_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGSGR_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGOtrasCaja_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGOtrasCaja_Internalname, httpContext.getMessage( "Otras Deducciones- AP. CAJAS COMPLEM.", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 129,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGOtrasCaja_Internalname, GXutil.ltrim( localUtil.ntoc( A814F1357LDGOtrasCaja, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGOtrasCaja_Enabled!=0) ? localUtil.format( A814F1357LDGOtrasCaja, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A814F1357LDGOtrasCaja, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,129);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGOtrasCaja_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGOtrasCaja_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGAlquiler_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGAlquiler_Internalname, httpContext.getMessage( "ALQUILERES DE INMUEBLES DESTINADOS A SU CASA HABITACIÓN", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 134,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGAlquiler_Internalname, GXutil.ltrim( localUtil.ntoc( A815F1357LDGAlquiler, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGAlquiler_Enabled!=0) ? localUtil.format( A815F1357LDGAlquiler, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A815F1357LDGAlquiler, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,134);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGAlquiler_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGAlquiler_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGDomes_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGDomes_Internalname, httpContext.getMessage( "EMPLEADOS DEL SERVICIO DOMESTICO", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 139,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGDomes_Internalname, GXutil.ltrim( localUtil.ntoc( A816F1357LDGDomes, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGDomes_Enabled!=0) ? localUtil.format( A816F1357LDGDomes, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A816F1357LDGDomes, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,139);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGDomes_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGDomes_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGViaticos_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGViaticos_Internalname, httpContext.getMessage( "GTOS MOV./VIÁTICOS ABONADOS POR EL EMPLEADOR", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 144,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGViaticos_Internalname, GXutil.ltrim( localUtil.ntoc( A817F1357LDGViaticos, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGViaticos_Enabled!=0) ? localUtil.format( A817F1357LDGViaticos, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A817F1357LDGViaticos, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,144);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGViaticos_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGViaticos_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGIndu_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGIndu_Internalname, httpContext.getMessage( "INDUMENTARIA/EQUIPAMIENTO-USO EXLUSIVO-CARÁCTER OBLIGATORIO", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 149,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGIndu_Internalname, GXutil.ltrim( localUtil.ntoc( A818F1357LDGIndu, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGIndu_Enabled!=0) ? localUtil.format( A818F1357LDGIndu, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A818F1357LDGIndu, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,149);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGIndu_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGIndu_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGOtras_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGOtras_Internalname, httpContext.getMessage( "OTRAS DEDUCCIONES", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 154,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGOtras_Internalname, GXutil.ltrim( localUtil.ntoc( A819F1357LDGOtras, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGOtras_Enabled!=0) ? localUtil.format( A819F1357LDGOtras, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A819F1357LDGOtras, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,154);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGOtras_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGOtras_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGTotal_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGTotal_Internalname, httpContext.getMessage( "TOTAL DEDUCCIONES GENERALES (Topeadas)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 159,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A820F1357LDGTotal, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGTotal_Enabled!=0) ? localUtil.format( A820F1357LDGTotal, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A820F1357LDGTotal, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,159);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGTotal_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGTotal_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGOtrasAnses_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGOtrasAnses_Internalname, httpContext.getMessage( "Otras Deducciones - Aportes para Jubilaciones, Retiros y Subsidios ANSeS", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 164,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGOtrasAnses_Internalname, GXutil.ltrim( localUtil.ntoc( A821F1357LDGOtrasAnses, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGOtrasAnses_Enabled!=0) ? localUtil.format( A821F1357LDGOtrasAnses, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A821F1357LDGOtrasAnses, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,164);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGOtrasAnses_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGOtrasAnses_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGOtrasProf_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGOtrasProf_Internalname, httpContext.getMessage( "Otras Deducciones - Cajas Provinciales o Municipales o de Previsión para Profesionales", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 169,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGOtrasProf_Internalname, GXutil.ltrim( localUtil.ntoc( A822F1357LDGOtrasProf, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGOtrasProf_Enabled!=0) ? localUtil.format( A822F1357LDGOtrasProf, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A822F1357LDGOtrasProf, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,169);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGOtrasProf_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGOtrasProf_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGOtrasActores_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGOtrasActores_Internalname, httpContext.getMessage( "Otras Deducciones - Actores - Retribución pagada a los representantes - RG 2442/08", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 174,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGOtrasActores_Internalname, GXutil.ltrim( localUtil.ntoc( A823F1357LDGOtrasActores, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGOtrasActores_Enabled!=0) ? localUtil.format( A823F1357LDGOtrasActores, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A823F1357LDGOtrasActores, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,174);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGOtrasActores_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGOtrasActores_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGOtrasPrev_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGOtrasPrev_Internalname, httpContext.getMessage( "tras Deducciones - Fondos Compensadores de Previsión", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 179,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGOtrasPrev_Internalname, GXutil.ltrim( localUtil.ntoc( A824F1357LDGOtrasPrev, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGOtrasPrev_Enabled!=0) ? localUtil.format( A824F1357LDGOtrasPrev, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A824F1357LDGOtrasPrev, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,179);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGOtrasPrev_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGOtrasPrev_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGEducativos_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGEducativos_Internalname, httpContext.getMessage( "Servicios educativos y las herramientas destinadas a esos efectos", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 184,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGEducativos_Internalname, GXutil.ltrim( localUtil.ntoc( A944F1357LDGEducativos, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGEducativos_Enabled!=0) ? localUtil.format( A944F1357LDGEducativos, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A944F1357LDGEducativos, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,184);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGEducativos_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGEducativos_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGMovEmpl_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGMovEmpl_Internalname, httpContext.getMessage( "GTOS MOV. ABONADOS POR EL  EMPLEADOR ", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 189,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGMovEmpl_Internalname, GXutil.ltrim( localUtil.ntoc( A1213F1357LDGMovEmpl, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGMovEmpl_Enabled!=0) ? localUtil.format( A1213F1357LDGMovEmpl, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1213F1357LDGMovEmpl, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,189);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGMovEmpl_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGMovEmpl_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGViaEmpl_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGViaEmpl_Internalname, httpContext.getMessage( "GTOS. VIÁTICOS ABONADOS POR  EL EMPLEADOR ", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 194,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGViaEmpl_Internalname, GXutil.ltrim( localUtil.ntoc( A1214F1357LDGViaEmpl, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGViaEmpl_Enabled!=0) ? localUtil.format( A1214F1357LDGViaEmpl, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1214F1357LDGViaEmpl, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,194);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGViaEmpl_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGViaEmpl_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGCompAna_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGCompAna_Internalname, httpContext.getMessage( "COMPENSACIÓN ANÁLOGA ", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 199,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGCompAna_Internalname, GXutil.ltrim( localUtil.ntoc( A1215F1357LDGCompAna, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGCompAna_Enabled!=0) ? localUtil.format( A1215F1357LDGCompAna, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1215F1357LDGCompAna, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,199);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGCompAna_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGCompAna_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357LegDedGen.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGCompAnaCnt_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGCompAnaCnt_Internalname, httpContext.getMessage( "Cantidad Compensación análoga", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 204,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDGCompAnaCnt_Internalname, GXutil.ltrim( localUtil.ntoc( A1216F1357LDGCompAnaCnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDGCompAnaCnt_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1216F1357LDGCompAnaCnt), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1216F1357LDGCompAnaCnt), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,204);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDGCompAnaCnt_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDGCompAnaCnt_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGDescuentosLey_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGDescuentosLey_Internalname, httpContext.getMessage( "Descuentos de Ley", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 209,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtF1357LDGDescuentosLey_Internalname, A825F1357LDGDescuentosLey, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,209);\"", (short)(0), 1, edtF1357LDGDescuentosLey_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDGOtrDescuLey_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtF1357LDGOtrDescuLey_Internalname, httpContext.getMessage( "Descuentos de Ley (otros empleos)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 214,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtF1357LDGOtrDescuLey_Internalname, A826F1357LDGOtrDescuLey, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,214);\"", (short)(0), 1, edtF1357LDGOtrDescuLey_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_F1357LegDedGen.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 219,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 221,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LegDedGen.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 223,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_F1357LegDedGen.htm");
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
         Z863F1357LDGTipReg = httpContext.cgiGet( "Z863F1357LDGTipReg") ;
         Z802F1357LDGPrepaga = localUtil.ctond( httpContext.cgiGet( "Z802F1357LDGPrepaga")) ;
         Z803F1357LDGSeguro = localUtil.ctond( httpContext.cgiGet( "Z803F1357LDGSeguro")) ;
         Z804F1357LDGSeguMixto = localUtil.ctond( httpContext.cgiGet( "Z804F1357LDGSeguMixto")) ;
         Z805F1357LDGRetPriv = localUtil.ctond( httpContext.cgiGet( "Z805F1357LDGRetPriv")) ;
         Z806F1357LDGCuotapartes = localUtil.ctond( httpContext.cgiGet( "Z806F1357LDGCuotapartes")) ;
         Z807F1357LDGSepelio = localUtil.ctond( httpContext.cgiGet( "Z807F1357LDGSepelio")) ;
         Z808F1357LDGRodado = localUtil.ctond( httpContext.cgiGet( "Z808F1357LDGRodado")) ;
         Z809F1357LDGDonaciones = localUtil.ctond( httpContext.cgiGet( "Z809F1357LDGDonaciones")) ;
         Z810F1357LDGOblig = localUtil.ctond( httpContext.cgiGet( "Z810F1357LDGOblig")) ;
         Z811F1357LDGMed = localUtil.ctond( httpContext.cgiGet( "Z811F1357LDGMed")) ;
         Z812F1357LDGHipoteca = localUtil.ctond( httpContext.cgiGet( "Z812F1357LDGHipoteca")) ;
         Z813F1357LDGSGR = localUtil.ctond( httpContext.cgiGet( "Z813F1357LDGSGR")) ;
         Z814F1357LDGOtrasCaja = localUtil.ctond( httpContext.cgiGet( "Z814F1357LDGOtrasCaja")) ;
         Z815F1357LDGAlquiler = localUtil.ctond( httpContext.cgiGet( "Z815F1357LDGAlquiler")) ;
         Z816F1357LDGDomes = localUtil.ctond( httpContext.cgiGet( "Z816F1357LDGDomes")) ;
         Z817F1357LDGViaticos = localUtil.ctond( httpContext.cgiGet( "Z817F1357LDGViaticos")) ;
         Z818F1357LDGIndu = localUtil.ctond( httpContext.cgiGet( "Z818F1357LDGIndu")) ;
         Z819F1357LDGOtras = localUtil.ctond( httpContext.cgiGet( "Z819F1357LDGOtras")) ;
         Z820F1357LDGTotal = localUtil.ctond( httpContext.cgiGet( "Z820F1357LDGTotal")) ;
         Z821F1357LDGOtrasAnses = localUtil.ctond( httpContext.cgiGet( "Z821F1357LDGOtrasAnses")) ;
         Z822F1357LDGOtrasProf = localUtil.ctond( httpContext.cgiGet( "Z822F1357LDGOtrasProf")) ;
         Z823F1357LDGOtrasActores = localUtil.ctond( httpContext.cgiGet( "Z823F1357LDGOtrasActores")) ;
         Z824F1357LDGOtrasPrev = localUtil.ctond( httpContext.cgiGet( "Z824F1357LDGOtrasPrev")) ;
         Z944F1357LDGEducativos = localUtil.ctond( httpContext.cgiGet( "Z944F1357LDGEducativos")) ;
         Z1213F1357LDGMovEmpl = localUtil.ctond( httpContext.cgiGet( "Z1213F1357LDGMovEmpl")) ;
         Z1214F1357LDGViaEmpl = localUtil.ctond( httpContext.cgiGet( "Z1214F1357LDGViaEmpl")) ;
         Z1215F1357LDGCompAna = localUtil.ctond( httpContext.cgiGet( "Z1215F1357LDGCompAna")) ;
         Z1216F1357LDGCompAnaCnt = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1216F1357LDGCompAnaCnt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
         A863F1357LDGTipReg = httpContext.cgiGet( edtF1357LDGTipReg_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A863F1357LDGTipReg", A863F1357LDGTipReg);
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGPrepaga_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGPrepaga_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGPREPAGA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGPrepaga_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A802F1357LDGPrepaga = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A802F1357LDGPrepaga", GXutil.ltrimstr( A802F1357LDGPrepaga, 16, 2));
         }
         else
         {
            A802F1357LDGPrepaga = localUtil.ctond( httpContext.cgiGet( edtF1357LDGPrepaga_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A802F1357LDGPrepaga", GXutil.ltrimstr( A802F1357LDGPrepaga, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGSeguro_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGSeguro_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGSEGURO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGSeguro_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A803F1357LDGSeguro = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A803F1357LDGSeguro", GXutil.ltrimstr( A803F1357LDGSeguro, 16, 2));
         }
         else
         {
            A803F1357LDGSeguro = localUtil.ctond( httpContext.cgiGet( edtF1357LDGSeguro_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A803F1357LDGSeguro", GXutil.ltrimstr( A803F1357LDGSeguro, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGSeguMixto_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGSeguMixto_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGSEGUMIXTO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGSeguMixto_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A804F1357LDGSeguMixto = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A804F1357LDGSeguMixto", GXutil.ltrimstr( A804F1357LDGSeguMixto, 16, 2));
         }
         else
         {
            A804F1357LDGSeguMixto = localUtil.ctond( httpContext.cgiGet( edtF1357LDGSeguMixto_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A804F1357LDGSeguMixto", GXutil.ltrimstr( A804F1357LDGSeguMixto, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGRetPriv_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGRetPriv_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGRETPRIV");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGRetPriv_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A805F1357LDGRetPriv = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A805F1357LDGRetPriv", GXutil.ltrimstr( A805F1357LDGRetPriv, 16, 2));
         }
         else
         {
            A805F1357LDGRetPriv = localUtil.ctond( httpContext.cgiGet( edtF1357LDGRetPriv_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A805F1357LDGRetPriv", GXutil.ltrimstr( A805F1357LDGRetPriv, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGCuotapartes_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGCuotapartes_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGCUOTAPARTES");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGCuotapartes_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A806F1357LDGCuotapartes = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A806F1357LDGCuotapartes", GXutil.ltrimstr( A806F1357LDGCuotapartes, 16, 2));
         }
         else
         {
            A806F1357LDGCuotapartes = localUtil.ctond( httpContext.cgiGet( edtF1357LDGCuotapartes_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A806F1357LDGCuotapartes", GXutil.ltrimstr( A806F1357LDGCuotapartes, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGSepelio_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGSepelio_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGSEPELIO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGSepelio_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A807F1357LDGSepelio = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A807F1357LDGSepelio", GXutil.ltrimstr( A807F1357LDGSepelio, 16, 2));
         }
         else
         {
            A807F1357LDGSepelio = localUtil.ctond( httpContext.cgiGet( edtF1357LDGSepelio_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A807F1357LDGSepelio", GXutil.ltrimstr( A807F1357LDGSepelio, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGRodado_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGRodado_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGRODADO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGRodado_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A808F1357LDGRodado = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A808F1357LDGRodado", GXutil.ltrimstr( A808F1357LDGRodado, 16, 2));
         }
         else
         {
            A808F1357LDGRodado = localUtil.ctond( httpContext.cgiGet( edtF1357LDGRodado_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A808F1357LDGRodado", GXutil.ltrimstr( A808F1357LDGRodado, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGDonaciones_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGDonaciones_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGDONACIONES");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGDonaciones_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A809F1357LDGDonaciones = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A809F1357LDGDonaciones", GXutil.ltrimstr( A809F1357LDGDonaciones, 16, 2));
         }
         else
         {
            A809F1357LDGDonaciones = localUtil.ctond( httpContext.cgiGet( edtF1357LDGDonaciones_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A809F1357LDGDonaciones", GXutil.ltrimstr( A809F1357LDGDonaciones, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGOblig_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGOblig_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGOBLIG");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGOblig_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A810F1357LDGOblig = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A810F1357LDGOblig", GXutil.ltrimstr( A810F1357LDGOblig, 16, 2));
         }
         else
         {
            A810F1357LDGOblig = localUtil.ctond( httpContext.cgiGet( edtF1357LDGOblig_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A810F1357LDGOblig", GXutil.ltrimstr( A810F1357LDGOblig, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGMed_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGMed_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGMED");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGMed_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A811F1357LDGMed = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A811F1357LDGMed", GXutil.ltrimstr( A811F1357LDGMed, 16, 2));
         }
         else
         {
            A811F1357LDGMed = localUtil.ctond( httpContext.cgiGet( edtF1357LDGMed_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A811F1357LDGMed", GXutil.ltrimstr( A811F1357LDGMed, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGHipoteca_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGHipoteca_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGHIPOTECA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGHipoteca_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A812F1357LDGHipoteca = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A812F1357LDGHipoteca", GXutil.ltrimstr( A812F1357LDGHipoteca, 16, 2));
         }
         else
         {
            A812F1357LDGHipoteca = localUtil.ctond( httpContext.cgiGet( edtF1357LDGHipoteca_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A812F1357LDGHipoteca", GXutil.ltrimstr( A812F1357LDGHipoteca, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGSGR_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGSGR_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGSGR");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGSGR_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A813F1357LDGSGR = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A813F1357LDGSGR", GXutil.ltrimstr( A813F1357LDGSGR, 16, 2));
         }
         else
         {
            A813F1357LDGSGR = localUtil.ctond( httpContext.cgiGet( edtF1357LDGSGR_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A813F1357LDGSGR", GXutil.ltrimstr( A813F1357LDGSGR, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasCaja_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasCaja_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGOTRASCAJA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGOtrasCaja_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A814F1357LDGOtrasCaja = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A814F1357LDGOtrasCaja", GXutil.ltrimstr( A814F1357LDGOtrasCaja, 16, 2));
         }
         else
         {
            A814F1357LDGOtrasCaja = localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasCaja_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A814F1357LDGOtrasCaja", GXutil.ltrimstr( A814F1357LDGOtrasCaja, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGAlquiler_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGAlquiler_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGALQUILER");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGAlquiler_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A815F1357LDGAlquiler = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A815F1357LDGAlquiler", GXutil.ltrimstr( A815F1357LDGAlquiler, 16, 2));
         }
         else
         {
            A815F1357LDGAlquiler = localUtil.ctond( httpContext.cgiGet( edtF1357LDGAlquiler_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A815F1357LDGAlquiler", GXutil.ltrimstr( A815F1357LDGAlquiler, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGDomes_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGDomes_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGDOMES");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGDomes_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A816F1357LDGDomes = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A816F1357LDGDomes", GXutil.ltrimstr( A816F1357LDGDomes, 16, 2));
         }
         else
         {
            A816F1357LDGDomes = localUtil.ctond( httpContext.cgiGet( edtF1357LDGDomes_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A816F1357LDGDomes", GXutil.ltrimstr( A816F1357LDGDomes, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGViaticos_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGViaticos_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGVIATICOS");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGViaticos_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A817F1357LDGViaticos = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A817F1357LDGViaticos", GXutil.ltrimstr( A817F1357LDGViaticos, 16, 2));
         }
         else
         {
            A817F1357LDGViaticos = localUtil.ctond( httpContext.cgiGet( edtF1357LDGViaticos_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A817F1357LDGViaticos", GXutil.ltrimstr( A817F1357LDGViaticos, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGIndu_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGIndu_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGINDU");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGIndu_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A818F1357LDGIndu = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A818F1357LDGIndu", GXutil.ltrimstr( A818F1357LDGIndu, 16, 2));
         }
         else
         {
            A818F1357LDGIndu = localUtil.ctond( httpContext.cgiGet( edtF1357LDGIndu_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A818F1357LDGIndu", GXutil.ltrimstr( A818F1357LDGIndu, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtras_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtras_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGOTRAS");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGOtras_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A819F1357LDGOtras = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A819F1357LDGOtras", GXutil.ltrimstr( A819F1357LDGOtras, 16, 2));
         }
         else
         {
            A819F1357LDGOtras = localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtras_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A819F1357LDGOtras", GXutil.ltrimstr( A819F1357LDGOtras, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGTotal_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGTotal_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGTOTAL");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGTotal_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A820F1357LDGTotal = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A820F1357LDGTotal", GXutil.ltrimstr( A820F1357LDGTotal, 16, 2));
         }
         else
         {
            A820F1357LDGTotal = localUtil.ctond( httpContext.cgiGet( edtF1357LDGTotal_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A820F1357LDGTotal", GXutil.ltrimstr( A820F1357LDGTotal, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasAnses_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasAnses_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGOTRASANSES");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGOtrasAnses_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A821F1357LDGOtrasAnses = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A821F1357LDGOtrasAnses", GXutil.ltrimstr( A821F1357LDGOtrasAnses, 16, 2));
         }
         else
         {
            A821F1357LDGOtrasAnses = localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasAnses_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A821F1357LDGOtrasAnses", GXutil.ltrimstr( A821F1357LDGOtrasAnses, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasProf_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasProf_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGOTRASPROF");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGOtrasProf_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A822F1357LDGOtrasProf = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A822F1357LDGOtrasProf", GXutil.ltrimstr( A822F1357LDGOtrasProf, 16, 2));
         }
         else
         {
            A822F1357LDGOtrasProf = localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasProf_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A822F1357LDGOtrasProf", GXutil.ltrimstr( A822F1357LDGOtrasProf, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasActores_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasActores_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGOTRASACTORES");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGOtrasActores_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A823F1357LDGOtrasActores = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A823F1357LDGOtrasActores", GXutil.ltrimstr( A823F1357LDGOtrasActores, 16, 2));
         }
         else
         {
            A823F1357LDGOtrasActores = localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasActores_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A823F1357LDGOtrasActores", GXutil.ltrimstr( A823F1357LDGOtrasActores, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasPrev_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasPrev_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGOTRASPREV");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGOtrasPrev_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A824F1357LDGOtrasPrev = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A824F1357LDGOtrasPrev", GXutil.ltrimstr( A824F1357LDGOtrasPrev, 16, 2));
         }
         else
         {
            A824F1357LDGOtrasPrev = localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasPrev_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A824F1357LDGOtrasPrev", GXutil.ltrimstr( A824F1357LDGOtrasPrev, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGEducativos_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGEducativos_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGEDUCATIVOS");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGEducativos_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A944F1357LDGEducativos = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A944F1357LDGEducativos", GXutil.ltrimstr( A944F1357LDGEducativos, 16, 2));
         }
         else
         {
            A944F1357LDGEducativos = localUtil.ctond( httpContext.cgiGet( edtF1357LDGEducativos_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A944F1357LDGEducativos", GXutil.ltrimstr( A944F1357LDGEducativos, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGMovEmpl_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGMovEmpl_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGMOVEMPL");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGMovEmpl_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1213F1357LDGMovEmpl = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A1213F1357LDGMovEmpl", GXutil.ltrimstr( A1213F1357LDGMovEmpl, 16, 2));
         }
         else
         {
            A1213F1357LDGMovEmpl = localUtil.ctond( httpContext.cgiGet( edtF1357LDGMovEmpl_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1213F1357LDGMovEmpl", GXutil.ltrimstr( A1213F1357LDGMovEmpl, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGViaEmpl_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGViaEmpl_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGVIAEMPL");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGViaEmpl_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1214F1357LDGViaEmpl = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A1214F1357LDGViaEmpl", GXutil.ltrimstr( A1214F1357LDGViaEmpl, 16, 2));
         }
         else
         {
            A1214F1357LDGViaEmpl = localUtil.ctond( httpContext.cgiGet( edtF1357LDGViaEmpl_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1214F1357LDGViaEmpl", GXutil.ltrimstr( A1214F1357LDGViaEmpl, 16, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGCompAna_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtF1357LDGCompAna_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGCOMPANA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGCompAna_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1215F1357LDGCompAna = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "A1215F1357LDGCompAna", GXutil.ltrimstr( A1215F1357LDGCompAna, 16, 2));
         }
         else
         {
            A1215F1357LDGCompAna = localUtil.ctond( httpContext.cgiGet( edtF1357LDGCompAna_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1215F1357LDGCompAna", GXutil.ltrimstr( A1215F1357LDGCompAna, 16, 2));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtF1357LDGCompAnaCnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtF1357LDGCompAnaCnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "F1357LDGCOMPANACNT");
            AnyError = (short)(1) ;
            GX_FocusControl = edtF1357LDGCompAnaCnt_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A1216F1357LDGCompAnaCnt = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1216F1357LDGCompAnaCnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1216F1357LDGCompAnaCnt), 2, 0));
         }
         else
         {
            A1216F1357LDGCompAnaCnt = (byte)(localUtil.ctol( httpContext.cgiGet( edtF1357LDGCompAnaCnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1216F1357LDGCompAnaCnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1216F1357LDGCompAnaCnt), 2, 0));
         }
         A825F1357LDGDescuentosLey = httpContext.cgiGet( edtF1357LDGDescuentosLey_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A825F1357LDGDescuentosLey", A825F1357LDGDescuentosLey);
         A826F1357LDGOtrDescuLey = httpContext.cgiGet( edtF1357LDGOtrDescuLey_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A826F1357LDGOtrDescuLey", A826F1357LDGOtrDescuLey);
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
            A863F1357LDGTipReg = httpContext.GetPar( "F1357LDGTipReg") ;
            httpContext.ajax_rsp_assign_attri("", false, "A863F1357LDGTipReg", A863F1357LDGTipReg);
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
            initAll2I96( ) ;
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
      disableAttributes2I96( ) ;
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

   public void resetCaption2I0( )
   {
   }

   public void zm2I96( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z802F1357LDGPrepaga = T002I3_A802F1357LDGPrepaga[0] ;
            Z803F1357LDGSeguro = T002I3_A803F1357LDGSeguro[0] ;
            Z804F1357LDGSeguMixto = T002I3_A804F1357LDGSeguMixto[0] ;
            Z805F1357LDGRetPriv = T002I3_A805F1357LDGRetPriv[0] ;
            Z806F1357LDGCuotapartes = T002I3_A806F1357LDGCuotapartes[0] ;
            Z807F1357LDGSepelio = T002I3_A807F1357LDGSepelio[0] ;
            Z808F1357LDGRodado = T002I3_A808F1357LDGRodado[0] ;
            Z809F1357LDGDonaciones = T002I3_A809F1357LDGDonaciones[0] ;
            Z810F1357LDGOblig = T002I3_A810F1357LDGOblig[0] ;
            Z811F1357LDGMed = T002I3_A811F1357LDGMed[0] ;
            Z812F1357LDGHipoteca = T002I3_A812F1357LDGHipoteca[0] ;
            Z813F1357LDGSGR = T002I3_A813F1357LDGSGR[0] ;
            Z814F1357LDGOtrasCaja = T002I3_A814F1357LDGOtrasCaja[0] ;
            Z815F1357LDGAlquiler = T002I3_A815F1357LDGAlquiler[0] ;
            Z816F1357LDGDomes = T002I3_A816F1357LDGDomes[0] ;
            Z817F1357LDGViaticos = T002I3_A817F1357LDGViaticos[0] ;
            Z818F1357LDGIndu = T002I3_A818F1357LDGIndu[0] ;
            Z819F1357LDGOtras = T002I3_A819F1357LDGOtras[0] ;
            Z820F1357LDGTotal = T002I3_A820F1357LDGTotal[0] ;
            Z821F1357LDGOtrasAnses = T002I3_A821F1357LDGOtrasAnses[0] ;
            Z822F1357LDGOtrasProf = T002I3_A822F1357LDGOtrasProf[0] ;
            Z823F1357LDGOtrasActores = T002I3_A823F1357LDGOtrasActores[0] ;
            Z824F1357LDGOtrasPrev = T002I3_A824F1357LDGOtrasPrev[0] ;
            Z944F1357LDGEducativos = T002I3_A944F1357LDGEducativos[0] ;
            Z1213F1357LDGMovEmpl = T002I3_A1213F1357LDGMovEmpl[0] ;
            Z1214F1357LDGViaEmpl = T002I3_A1214F1357LDGViaEmpl[0] ;
            Z1215F1357LDGCompAna = T002I3_A1215F1357LDGCompAna[0] ;
            Z1216F1357LDGCompAnaCnt = T002I3_A1216F1357LDGCompAnaCnt[0] ;
         }
         else
         {
            Z802F1357LDGPrepaga = A802F1357LDGPrepaga ;
            Z803F1357LDGSeguro = A803F1357LDGSeguro ;
            Z804F1357LDGSeguMixto = A804F1357LDGSeguMixto ;
            Z805F1357LDGRetPriv = A805F1357LDGRetPriv ;
            Z806F1357LDGCuotapartes = A806F1357LDGCuotapartes ;
            Z807F1357LDGSepelio = A807F1357LDGSepelio ;
            Z808F1357LDGRodado = A808F1357LDGRodado ;
            Z809F1357LDGDonaciones = A809F1357LDGDonaciones ;
            Z810F1357LDGOblig = A810F1357LDGOblig ;
            Z811F1357LDGMed = A811F1357LDGMed ;
            Z812F1357LDGHipoteca = A812F1357LDGHipoteca ;
            Z813F1357LDGSGR = A813F1357LDGSGR ;
            Z814F1357LDGOtrasCaja = A814F1357LDGOtrasCaja ;
            Z815F1357LDGAlquiler = A815F1357LDGAlquiler ;
            Z816F1357LDGDomes = A816F1357LDGDomes ;
            Z817F1357LDGViaticos = A817F1357LDGViaticos ;
            Z818F1357LDGIndu = A818F1357LDGIndu ;
            Z819F1357LDGOtras = A819F1357LDGOtras ;
            Z820F1357LDGTotal = A820F1357LDGTotal ;
            Z821F1357LDGOtrasAnses = A821F1357LDGOtrasAnses ;
            Z822F1357LDGOtrasProf = A822F1357LDGOtrasProf ;
            Z823F1357LDGOtrasActores = A823F1357LDGOtrasActores ;
            Z824F1357LDGOtrasPrev = A824F1357LDGOtrasPrev ;
            Z944F1357LDGEducativos = A944F1357LDGEducativos ;
            Z1213F1357LDGMovEmpl = A1213F1357LDGMovEmpl ;
            Z1214F1357LDGViaEmpl = A1214F1357LDGViaEmpl ;
            Z1215F1357LDGCompAna = A1215F1357LDGCompAna ;
            Z1216F1357LDGCompAnaCnt = A1216F1357LDGCompAnaCnt ;
         }
      }
      if ( GX_JID == -2 )
      {
         Z863F1357LDGTipReg = A863F1357LDGTipReg ;
         Z802F1357LDGPrepaga = A802F1357LDGPrepaga ;
         Z803F1357LDGSeguro = A803F1357LDGSeguro ;
         Z804F1357LDGSeguMixto = A804F1357LDGSeguMixto ;
         Z805F1357LDGRetPriv = A805F1357LDGRetPriv ;
         Z806F1357LDGCuotapartes = A806F1357LDGCuotapartes ;
         Z807F1357LDGSepelio = A807F1357LDGSepelio ;
         Z808F1357LDGRodado = A808F1357LDGRodado ;
         Z809F1357LDGDonaciones = A809F1357LDGDonaciones ;
         Z810F1357LDGOblig = A810F1357LDGOblig ;
         Z811F1357LDGMed = A811F1357LDGMed ;
         Z812F1357LDGHipoteca = A812F1357LDGHipoteca ;
         Z813F1357LDGSGR = A813F1357LDGSGR ;
         Z814F1357LDGOtrasCaja = A814F1357LDGOtrasCaja ;
         Z815F1357LDGAlquiler = A815F1357LDGAlquiler ;
         Z816F1357LDGDomes = A816F1357LDGDomes ;
         Z817F1357LDGViaticos = A817F1357LDGViaticos ;
         Z818F1357LDGIndu = A818F1357LDGIndu ;
         Z819F1357LDGOtras = A819F1357LDGOtras ;
         Z820F1357LDGTotal = A820F1357LDGTotal ;
         Z821F1357LDGOtrasAnses = A821F1357LDGOtrasAnses ;
         Z822F1357LDGOtrasProf = A822F1357LDGOtrasProf ;
         Z823F1357LDGOtrasActores = A823F1357LDGOtrasActores ;
         Z824F1357LDGOtrasPrev = A824F1357LDGOtrasPrev ;
         Z944F1357LDGEducativos = A944F1357LDGEducativos ;
         Z1213F1357LDGMovEmpl = A1213F1357LDGMovEmpl ;
         Z1214F1357LDGViaEmpl = A1214F1357LDGViaEmpl ;
         Z1215F1357LDGCompAna = A1215F1357LDGCompAna ;
         Z1216F1357LDGCompAnaCnt = A1216F1357LDGCompAnaCnt ;
         Z825F1357LDGDescuentosLey = A825F1357LDGDescuentosLey ;
         Z826F1357LDGOtrDescuLey = A826F1357LDGOtrDescuLey ;
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

   public void load2I96( )
   {
      /* Using cursor T002I6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A863F1357LDGTipReg});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound96 = (short)(1) ;
         A802F1357LDGPrepaga = T002I6_A802F1357LDGPrepaga[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A802F1357LDGPrepaga", GXutil.ltrimstr( A802F1357LDGPrepaga, 16, 2));
         A803F1357LDGSeguro = T002I6_A803F1357LDGSeguro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A803F1357LDGSeguro", GXutil.ltrimstr( A803F1357LDGSeguro, 16, 2));
         A804F1357LDGSeguMixto = T002I6_A804F1357LDGSeguMixto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A804F1357LDGSeguMixto", GXutil.ltrimstr( A804F1357LDGSeguMixto, 16, 2));
         A805F1357LDGRetPriv = T002I6_A805F1357LDGRetPriv[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A805F1357LDGRetPriv", GXutil.ltrimstr( A805F1357LDGRetPriv, 16, 2));
         A806F1357LDGCuotapartes = T002I6_A806F1357LDGCuotapartes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A806F1357LDGCuotapartes", GXutil.ltrimstr( A806F1357LDGCuotapartes, 16, 2));
         A807F1357LDGSepelio = T002I6_A807F1357LDGSepelio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A807F1357LDGSepelio", GXutil.ltrimstr( A807F1357LDGSepelio, 16, 2));
         A808F1357LDGRodado = T002I6_A808F1357LDGRodado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A808F1357LDGRodado", GXutil.ltrimstr( A808F1357LDGRodado, 16, 2));
         A809F1357LDGDonaciones = T002I6_A809F1357LDGDonaciones[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A809F1357LDGDonaciones", GXutil.ltrimstr( A809F1357LDGDonaciones, 16, 2));
         A810F1357LDGOblig = T002I6_A810F1357LDGOblig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A810F1357LDGOblig", GXutil.ltrimstr( A810F1357LDGOblig, 16, 2));
         A811F1357LDGMed = T002I6_A811F1357LDGMed[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A811F1357LDGMed", GXutil.ltrimstr( A811F1357LDGMed, 16, 2));
         A812F1357LDGHipoteca = T002I6_A812F1357LDGHipoteca[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A812F1357LDGHipoteca", GXutil.ltrimstr( A812F1357LDGHipoteca, 16, 2));
         A813F1357LDGSGR = T002I6_A813F1357LDGSGR[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A813F1357LDGSGR", GXutil.ltrimstr( A813F1357LDGSGR, 16, 2));
         A814F1357LDGOtrasCaja = T002I6_A814F1357LDGOtrasCaja[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A814F1357LDGOtrasCaja", GXutil.ltrimstr( A814F1357LDGOtrasCaja, 16, 2));
         A815F1357LDGAlquiler = T002I6_A815F1357LDGAlquiler[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A815F1357LDGAlquiler", GXutil.ltrimstr( A815F1357LDGAlquiler, 16, 2));
         A816F1357LDGDomes = T002I6_A816F1357LDGDomes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A816F1357LDGDomes", GXutil.ltrimstr( A816F1357LDGDomes, 16, 2));
         A817F1357LDGViaticos = T002I6_A817F1357LDGViaticos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A817F1357LDGViaticos", GXutil.ltrimstr( A817F1357LDGViaticos, 16, 2));
         A818F1357LDGIndu = T002I6_A818F1357LDGIndu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A818F1357LDGIndu", GXutil.ltrimstr( A818F1357LDGIndu, 16, 2));
         A819F1357LDGOtras = T002I6_A819F1357LDGOtras[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A819F1357LDGOtras", GXutil.ltrimstr( A819F1357LDGOtras, 16, 2));
         A820F1357LDGTotal = T002I6_A820F1357LDGTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A820F1357LDGTotal", GXutil.ltrimstr( A820F1357LDGTotal, 16, 2));
         A821F1357LDGOtrasAnses = T002I6_A821F1357LDGOtrasAnses[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A821F1357LDGOtrasAnses", GXutil.ltrimstr( A821F1357LDGOtrasAnses, 16, 2));
         A822F1357LDGOtrasProf = T002I6_A822F1357LDGOtrasProf[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A822F1357LDGOtrasProf", GXutil.ltrimstr( A822F1357LDGOtrasProf, 16, 2));
         A823F1357LDGOtrasActores = T002I6_A823F1357LDGOtrasActores[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A823F1357LDGOtrasActores", GXutil.ltrimstr( A823F1357LDGOtrasActores, 16, 2));
         A824F1357LDGOtrasPrev = T002I6_A824F1357LDGOtrasPrev[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A824F1357LDGOtrasPrev", GXutil.ltrimstr( A824F1357LDGOtrasPrev, 16, 2));
         A944F1357LDGEducativos = T002I6_A944F1357LDGEducativos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A944F1357LDGEducativos", GXutil.ltrimstr( A944F1357LDGEducativos, 16, 2));
         A1213F1357LDGMovEmpl = T002I6_A1213F1357LDGMovEmpl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1213F1357LDGMovEmpl", GXutil.ltrimstr( A1213F1357LDGMovEmpl, 16, 2));
         A1214F1357LDGViaEmpl = T002I6_A1214F1357LDGViaEmpl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1214F1357LDGViaEmpl", GXutil.ltrimstr( A1214F1357LDGViaEmpl, 16, 2));
         A1215F1357LDGCompAna = T002I6_A1215F1357LDGCompAna[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1215F1357LDGCompAna", GXutil.ltrimstr( A1215F1357LDGCompAna, 16, 2));
         A1216F1357LDGCompAnaCnt = T002I6_A1216F1357LDGCompAnaCnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1216F1357LDGCompAnaCnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1216F1357LDGCompAnaCnt), 2, 0));
         A825F1357LDGDescuentosLey = T002I6_A825F1357LDGDescuentosLey[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A825F1357LDGDescuentosLey", A825F1357LDGDescuentosLey);
         A826F1357LDGOtrDescuLey = T002I6_A826F1357LDGOtrDescuLey[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A826F1357LDGOtrDescuLey", A826F1357LDGOtrDescuLey);
         zm2I96( -2) ;
      }
      pr_default.close(4);
      onLoadActions2I96( ) ;
   }

   public void onLoadActions2I96( )
   {
   }

   public void checkExtendedTable2I96( )
   {
      nIsDirty_96 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      if ( ! ( ( A784F1357CTipoPre == 1 ) || ( A784F1357CTipoPre == 2 ) || ( A784F1357CTipoPre == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "F1357 CTipo Pre", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "F1357CTIPOPRE");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbF1357CTipoPre.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T002I5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Formulario F1357", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "F1357CSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
      /* Using cursor T002I4 */
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

   public void closeExtendedTableCursors2I96( )
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
      /* Using cursor T002I7 */
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
      /* Using cursor T002I8 */
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

   public void getKey2I96( )
   {
      /* Using cursor T002I9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A863F1357LDGTipReg});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound96 = (short)(1) ;
      }
      else
      {
         RcdFound96 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T002I3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A863F1357LDGTipReg});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm2I96( 2) ;
         RcdFound96 = (short)(1) ;
         A863F1357LDGTipReg = T002I3_A863F1357LDGTipReg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A863F1357LDGTipReg", A863F1357LDGTipReg);
         A802F1357LDGPrepaga = T002I3_A802F1357LDGPrepaga[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A802F1357LDGPrepaga", GXutil.ltrimstr( A802F1357LDGPrepaga, 16, 2));
         A803F1357LDGSeguro = T002I3_A803F1357LDGSeguro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A803F1357LDGSeguro", GXutil.ltrimstr( A803F1357LDGSeguro, 16, 2));
         A804F1357LDGSeguMixto = T002I3_A804F1357LDGSeguMixto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A804F1357LDGSeguMixto", GXutil.ltrimstr( A804F1357LDGSeguMixto, 16, 2));
         A805F1357LDGRetPriv = T002I3_A805F1357LDGRetPriv[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A805F1357LDGRetPriv", GXutil.ltrimstr( A805F1357LDGRetPriv, 16, 2));
         A806F1357LDGCuotapartes = T002I3_A806F1357LDGCuotapartes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A806F1357LDGCuotapartes", GXutil.ltrimstr( A806F1357LDGCuotapartes, 16, 2));
         A807F1357LDGSepelio = T002I3_A807F1357LDGSepelio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A807F1357LDGSepelio", GXutil.ltrimstr( A807F1357LDGSepelio, 16, 2));
         A808F1357LDGRodado = T002I3_A808F1357LDGRodado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A808F1357LDGRodado", GXutil.ltrimstr( A808F1357LDGRodado, 16, 2));
         A809F1357LDGDonaciones = T002I3_A809F1357LDGDonaciones[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A809F1357LDGDonaciones", GXutil.ltrimstr( A809F1357LDGDonaciones, 16, 2));
         A810F1357LDGOblig = T002I3_A810F1357LDGOblig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A810F1357LDGOblig", GXutil.ltrimstr( A810F1357LDGOblig, 16, 2));
         A811F1357LDGMed = T002I3_A811F1357LDGMed[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A811F1357LDGMed", GXutil.ltrimstr( A811F1357LDGMed, 16, 2));
         A812F1357LDGHipoteca = T002I3_A812F1357LDGHipoteca[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A812F1357LDGHipoteca", GXutil.ltrimstr( A812F1357LDGHipoteca, 16, 2));
         A813F1357LDGSGR = T002I3_A813F1357LDGSGR[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A813F1357LDGSGR", GXutil.ltrimstr( A813F1357LDGSGR, 16, 2));
         A814F1357LDGOtrasCaja = T002I3_A814F1357LDGOtrasCaja[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A814F1357LDGOtrasCaja", GXutil.ltrimstr( A814F1357LDGOtrasCaja, 16, 2));
         A815F1357LDGAlquiler = T002I3_A815F1357LDGAlquiler[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A815F1357LDGAlquiler", GXutil.ltrimstr( A815F1357LDGAlquiler, 16, 2));
         A816F1357LDGDomes = T002I3_A816F1357LDGDomes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A816F1357LDGDomes", GXutil.ltrimstr( A816F1357LDGDomes, 16, 2));
         A817F1357LDGViaticos = T002I3_A817F1357LDGViaticos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A817F1357LDGViaticos", GXutil.ltrimstr( A817F1357LDGViaticos, 16, 2));
         A818F1357LDGIndu = T002I3_A818F1357LDGIndu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A818F1357LDGIndu", GXutil.ltrimstr( A818F1357LDGIndu, 16, 2));
         A819F1357LDGOtras = T002I3_A819F1357LDGOtras[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A819F1357LDGOtras", GXutil.ltrimstr( A819F1357LDGOtras, 16, 2));
         A820F1357LDGTotal = T002I3_A820F1357LDGTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A820F1357LDGTotal", GXutil.ltrimstr( A820F1357LDGTotal, 16, 2));
         A821F1357LDGOtrasAnses = T002I3_A821F1357LDGOtrasAnses[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A821F1357LDGOtrasAnses", GXutil.ltrimstr( A821F1357LDGOtrasAnses, 16, 2));
         A822F1357LDGOtrasProf = T002I3_A822F1357LDGOtrasProf[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A822F1357LDGOtrasProf", GXutil.ltrimstr( A822F1357LDGOtrasProf, 16, 2));
         A823F1357LDGOtrasActores = T002I3_A823F1357LDGOtrasActores[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A823F1357LDGOtrasActores", GXutil.ltrimstr( A823F1357LDGOtrasActores, 16, 2));
         A824F1357LDGOtrasPrev = T002I3_A824F1357LDGOtrasPrev[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A824F1357LDGOtrasPrev", GXutil.ltrimstr( A824F1357LDGOtrasPrev, 16, 2));
         A944F1357LDGEducativos = T002I3_A944F1357LDGEducativos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A944F1357LDGEducativos", GXutil.ltrimstr( A944F1357LDGEducativos, 16, 2));
         A1213F1357LDGMovEmpl = T002I3_A1213F1357LDGMovEmpl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1213F1357LDGMovEmpl", GXutil.ltrimstr( A1213F1357LDGMovEmpl, 16, 2));
         A1214F1357LDGViaEmpl = T002I3_A1214F1357LDGViaEmpl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1214F1357LDGViaEmpl", GXutil.ltrimstr( A1214F1357LDGViaEmpl, 16, 2));
         A1215F1357LDGCompAna = T002I3_A1215F1357LDGCompAna[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1215F1357LDGCompAna", GXutil.ltrimstr( A1215F1357LDGCompAna, 16, 2));
         A1216F1357LDGCompAnaCnt = T002I3_A1216F1357LDGCompAnaCnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1216F1357LDGCompAnaCnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1216F1357LDGCompAnaCnt), 2, 0));
         A825F1357LDGDescuentosLey = T002I3_A825F1357LDGDescuentosLey[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A825F1357LDGDescuentosLey", A825F1357LDGDescuentosLey);
         A826F1357LDGOtrDescuLey = T002I3_A826F1357LDGOtrDescuLey[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A826F1357LDGOtrDescuLey", A826F1357LDGOtrDescuLey);
         A3CliCod = T002I3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002I3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T002I3_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A784F1357CTipoPre = T002I3_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002I3_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002I3_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z784F1357CTipoPre = A784F1357CTipoPre ;
         Z777F1357CPer = A777F1357CPer ;
         Z778F1357CSec = A778F1357CSec ;
         Z6LegNumero = A6LegNumero ;
         Z863F1357LDGTipReg = A863F1357LDGTipReg ;
         sMode96 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load2I96( ) ;
         if ( AnyError == 1 )
         {
            RcdFound96 = (short)(0) ;
            initializeNonKey2I96( ) ;
         }
         Gx_mode = sMode96 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound96 = (short)(0) ;
         initializeNonKey2I96( ) ;
         sMode96 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode96 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey2I96( ) ;
      if ( RcdFound96 == 0 )
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
      RcdFound96 = (short)(0) ;
      /* Using cursor T002I10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A784F1357CTipoPre), Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A777F1357CPer, A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A778F1357CSec), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A863F1357LDGTipReg});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T002I10_A3CliCod[0] < A3CliCod ) || ( T002I10_A3CliCod[0] == A3CliCod ) && ( T002I10_A1EmpCod[0] < A1EmpCod ) || ( T002I10_A1EmpCod[0] == A1EmpCod ) && ( T002I10_A3CliCod[0] == A3CliCod ) && ( T002I10_A784F1357CTipoPre[0] < A784F1357CTipoPre ) || ( T002I10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002I10_A1EmpCod[0] == A1EmpCod ) && ( T002I10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002I10_A777F1357CPer[0], A777F1357CPer) < 0 ) || ( GXutil.strcmp(T002I10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002I10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002I10_A1EmpCod[0] == A1EmpCod ) && ( T002I10_A3CliCod[0] == A3CliCod ) && ( T002I10_A778F1357CSec[0] < A778F1357CSec ) || ( T002I10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002I10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002I10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002I10_A1EmpCod[0] == A1EmpCod ) && ( T002I10_A3CliCod[0] == A3CliCod ) && ( T002I10_A6LegNumero[0] < A6LegNumero ) || ( T002I10_A6LegNumero[0] == A6LegNumero ) && ( T002I10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002I10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002I10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002I10_A1EmpCod[0] == A1EmpCod ) && ( T002I10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002I10_A863F1357LDGTipReg[0], A863F1357LDGTipReg) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T002I10_A3CliCod[0] > A3CliCod ) || ( T002I10_A3CliCod[0] == A3CliCod ) && ( T002I10_A1EmpCod[0] > A1EmpCod ) || ( T002I10_A1EmpCod[0] == A1EmpCod ) && ( T002I10_A3CliCod[0] == A3CliCod ) && ( T002I10_A784F1357CTipoPre[0] > A784F1357CTipoPre ) || ( T002I10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002I10_A1EmpCod[0] == A1EmpCod ) && ( T002I10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002I10_A777F1357CPer[0], A777F1357CPer) > 0 ) || ( GXutil.strcmp(T002I10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002I10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002I10_A1EmpCod[0] == A1EmpCod ) && ( T002I10_A3CliCod[0] == A3CliCod ) && ( T002I10_A778F1357CSec[0] > A778F1357CSec ) || ( T002I10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002I10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002I10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002I10_A1EmpCod[0] == A1EmpCod ) && ( T002I10_A3CliCod[0] == A3CliCod ) && ( T002I10_A6LegNumero[0] > A6LegNumero ) || ( T002I10_A6LegNumero[0] == A6LegNumero ) && ( T002I10_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002I10_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002I10_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002I10_A1EmpCod[0] == A1EmpCod ) && ( T002I10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002I10_A863F1357LDGTipReg[0], A863F1357LDGTipReg) > 0 ) ) )
         {
            A3CliCod = T002I10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002I10_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A784F1357CTipoPre = T002I10_A784F1357CTipoPre[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
            A777F1357CPer = T002I10_A777F1357CPer[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
            A778F1357CSec = T002I10_A778F1357CSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
            A6LegNumero = T002I10_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A863F1357LDGTipReg = T002I10_A863F1357LDGTipReg[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A863F1357LDGTipReg", A863F1357LDGTipReg);
            RcdFound96 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound96 = (short)(0) ;
      /* Using cursor T002I11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A784F1357CTipoPre), Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A777F1357CPer, A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A778F1357CSec), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Byte.valueOf(A778F1357CSec), A777F1357CPer, Byte.valueOf(A784F1357CTipoPre), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A863F1357LDGTipReg});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T002I11_A3CliCod[0] > A3CliCod ) || ( T002I11_A3CliCod[0] == A3CliCod ) && ( T002I11_A1EmpCod[0] > A1EmpCod ) || ( T002I11_A1EmpCod[0] == A1EmpCod ) && ( T002I11_A3CliCod[0] == A3CliCod ) && ( T002I11_A784F1357CTipoPre[0] > A784F1357CTipoPre ) || ( T002I11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002I11_A1EmpCod[0] == A1EmpCod ) && ( T002I11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002I11_A777F1357CPer[0], A777F1357CPer) > 0 ) || ( GXutil.strcmp(T002I11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002I11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002I11_A1EmpCod[0] == A1EmpCod ) && ( T002I11_A3CliCod[0] == A3CliCod ) && ( T002I11_A778F1357CSec[0] > A778F1357CSec ) || ( T002I11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002I11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002I11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002I11_A1EmpCod[0] == A1EmpCod ) && ( T002I11_A3CliCod[0] == A3CliCod ) && ( T002I11_A6LegNumero[0] > A6LegNumero ) || ( T002I11_A6LegNumero[0] == A6LegNumero ) && ( T002I11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002I11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002I11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002I11_A1EmpCod[0] == A1EmpCod ) && ( T002I11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002I11_A863F1357LDGTipReg[0], A863F1357LDGTipReg) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T002I11_A3CliCod[0] < A3CliCod ) || ( T002I11_A3CliCod[0] == A3CliCod ) && ( T002I11_A1EmpCod[0] < A1EmpCod ) || ( T002I11_A1EmpCod[0] == A1EmpCod ) && ( T002I11_A3CliCod[0] == A3CliCod ) && ( T002I11_A784F1357CTipoPre[0] < A784F1357CTipoPre ) || ( T002I11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002I11_A1EmpCod[0] == A1EmpCod ) && ( T002I11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002I11_A777F1357CPer[0], A777F1357CPer) < 0 ) || ( GXutil.strcmp(T002I11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002I11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002I11_A1EmpCod[0] == A1EmpCod ) && ( T002I11_A3CliCod[0] == A3CliCod ) && ( T002I11_A778F1357CSec[0] < A778F1357CSec ) || ( T002I11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002I11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002I11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002I11_A1EmpCod[0] == A1EmpCod ) && ( T002I11_A3CliCod[0] == A3CliCod ) && ( T002I11_A6LegNumero[0] < A6LegNumero ) || ( T002I11_A6LegNumero[0] == A6LegNumero ) && ( T002I11_A778F1357CSec[0] == A778F1357CSec ) && ( GXutil.strcmp(T002I11_A777F1357CPer[0], A777F1357CPer) == 0 ) && ( T002I11_A784F1357CTipoPre[0] == A784F1357CTipoPre ) && ( T002I11_A1EmpCod[0] == A1EmpCod ) && ( T002I11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002I11_A863F1357LDGTipReg[0], A863F1357LDGTipReg) < 0 ) ) )
         {
            A3CliCod = T002I11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T002I11_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A784F1357CTipoPre = T002I11_A784F1357CTipoPre[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
            A777F1357CPer = T002I11_A777F1357CPer[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
            A778F1357CSec = T002I11_A778F1357CSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
            A6LegNumero = T002I11_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A863F1357LDGTipReg = T002I11_A863F1357LDGTipReg[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A863F1357LDGTipReg", A863F1357LDGTipReg);
            RcdFound96 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2I96( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert2I96( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound96 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A863F1357LDGTipReg, Z863F1357LDGTipReg) != 0 ) )
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
               A863F1357LDGTipReg = Z863F1357LDGTipReg ;
               httpContext.ajax_rsp_assign_attri("", false, "A863F1357LDGTipReg", A863F1357LDGTipReg);
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
               update2I96( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A863F1357LDGTipReg, Z863F1357LDGTipReg) != 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert2I96( ) ;
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
                  insert2I96( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A784F1357CTipoPre != Z784F1357CTipoPre ) || ( GXutil.strcmp(A777F1357CPer, Z777F1357CPer) != 0 ) || ( A778F1357CSec != Z778F1357CSec ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A863F1357LDGTipReg, Z863F1357LDGTipReg) != 0 ) )
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
         A863F1357LDGTipReg = Z863F1357LDGTipReg ;
         httpContext.ajax_rsp_assign_attri("", false, "A863F1357LDGTipReg", A863F1357LDGTipReg);
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
      if ( RcdFound96 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtF1357LDGPrepaga_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart2I96( ) ;
      if ( RcdFound96 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtF1357LDGPrepaga_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd2I96( ) ;
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
      if ( RcdFound96 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtF1357LDGPrepaga_Internalname ;
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
      if ( RcdFound96 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtF1357LDGPrepaga_Internalname ;
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
      scanStart2I96( ) ;
      if ( RcdFound96 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound96 != 0 )
         {
            scanNext2I96( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtF1357LDGPrepaga_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd2I96( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency2I96( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002I2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A863F1357LDGTipReg});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"F1357LegDedGen"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z802F1357LDGPrepaga, T002I2_A802F1357LDGPrepaga[0]) != 0 ) || ( DecimalUtil.compareTo(Z803F1357LDGSeguro, T002I2_A803F1357LDGSeguro[0]) != 0 ) || ( DecimalUtil.compareTo(Z804F1357LDGSeguMixto, T002I2_A804F1357LDGSeguMixto[0]) != 0 ) || ( DecimalUtil.compareTo(Z805F1357LDGRetPriv, T002I2_A805F1357LDGRetPriv[0]) != 0 ) || ( DecimalUtil.compareTo(Z806F1357LDGCuotapartes, T002I2_A806F1357LDGCuotapartes[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z807F1357LDGSepelio, T002I2_A807F1357LDGSepelio[0]) != 0 ) || ( DecimalUtil.compareTo(Z808F1357LDGRodado, T002I2_A808F1357LDGRodado[0]) != 0 ) || ( DecimalUtil.compareTo(Z809F1357LDGDonaciones, T002I2_A809F1357LDGDonaciones[0]) != 0 ) || ( DecimalUtil.compareTo(Z810F1357LDGOblig, T002I2_A810F1357LDGOblig[0]) != 0 ) || ( DecimalUtil.compareTo(Z811F1357LDGMed, T002I2_A811F1357LDGMed[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z812F1357LDGHipoteca, T002I2_A812F1357LDGHipoteca[0]) != 0 ) || ( DecimalUtil.compareTo(Z813F1357LDGSGR, T002I2_A813F1357LDGSGR[0]) != 0 ) || ( DecimalUtil.compareTo(Z814F1357LDGOtrasCaja, T002I2_A814F1357LDGOtrasCaja[0]) != 0 ) || ( DecimalUtil.compareTo(Z815F1357LDGAlquiler, T002I2_A815F1357LDGAlquiler[0]) != 0 ) || ( DecimalUtil.compareTo(Z816F1357LDGDomes, T002I2_A816F1357LDGDomes[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z817F1357LDGViaticos, T002I2_A817F1357LDGViaticos[0]) != 0 ) || ( DecimalUtil.compareTo(Z818F1357LDGIndu, T002I2_A818F1357LDGIndu[0]) != 0 ) || ( DecimalUtil.compareTo(Z819F1357LDGOtras, T002I2_A819F1357LDGOtras[0]) != 0 ) || ( DecimalUtil.compareTo(Z820F1357LDGTotal, T002I2_A820F1357LDGTotal[0]) != 0 ) || ( DecimalUtil.compareTo(Z821F1357LDGOtrasAnses, T002I2_A821F1357LDGOtrasAnses[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z822F1357LDGOtrasProf, T002I2_A822F1357LDGOtrasProf[0]) != 0 ) || ( DecimalUtil.compareTo(Z823F1357LDGOtrasActores, T002I2_A823F1357LDGOtrasActores[0]) != 0 ) || ( DecimalUtil.compareTo(Z824F1357LDGOtrasPrev, T002I2_A824F1357LDGOtrasPrev[0]) != 0 ) || ( DecimalUtil.compareTo(Z944F1357LDGEducativos, T002I2_A944F1357LDGEducativos[0]) != 0 ) || ( DecimalUtil.compareTo(Z1213F1357LDGMovEmpl, T002I2_A1213F1357LDGMovEmpl[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1214F1357LDGViaEmpl, T002I2_A1214F1357LDGViaEmpl[0]) != 0 ) || ( DecimalUtil.compareTo(Z1215F1357LDGCompAna, T002I2_A1215F1357LDGCompAna[0]) != 0 ) || ( Z1216F1357LDGCompAnaCnt != T002I2_A1216F1357LDGCompAnaCnt[0] ) )
         {
            if ( DecimalUtil.compareTo(Z802F1357LDGPrepaga, T002I2_A802F1357LDGPrepaga[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGPrepaga");
               GXutil.writeLogRaw("Old: ",Z802F1357LDGPrepaga);
               GXutil.writeLogRaw("Current: ",T002I2_A802F1357LDGPrepaga[0]);
            }
            if ( DecimalUtil.compareTo(Z803F1357LDGSeguro, T002I2_A803F1357LDGSeguro[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGSeguro");
               GXutil.writeLogRaw("Old: ",Z803F1357LDGSeguro);
               GXutil.writeLogRaw("Current: ",T002I2_A803F1357LDGSeguro[0]);
            }
            if ( DecimalUtil.compareTo(Z804F1357LDGSeguMixto, T002I2_A804F1357LDGSeguMixto[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGSeguMixto");
               GXutil.writeLogRaw("Old: ",Z804F1357LDGSeguMixto);
               GXutil.writeLogRaw("Current: ",T002I2_A804F1357LDGSeguMixto[0]);
            }
            if ( DecimalUtil.compareTo(Z805F1357LDGRetPriv, T002I2_A805F1357LDGRetPriv[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGRetPriv");
               GXutil.writeLogRaw("Old: ",Z805F1357LDGRetPriv);
               GXutil.writeLogRaw("Current: ",T002I2_A805F1357LDGRetPriv[0]);
            }
            if ( DecimalUtil.compareTo(Z806F1357LDGCuotapartes, T002I2_A806F1357LDGCuotapartes[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGCuotapartes");
               GXutil.writeLogRaw("Old: ",Z806F1357LDGCuotapartes);
               GXutil.writeLogRaw("Current: ",T002I2_A806F1357LDGCuotapartes[0]);
            }
            if ( DecimalUtil.compareTo(Z807F1357LDGSepelio, T002I2_A807F1357LDGSepelio[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGSepelio");
               GXutil.writeLogRaw("Old: ",Z807F1357LDGSepelio);
               GXutil.writeLogRaw("Current: ",T002I2_A807F1357LDGSepelio[0]);
            }
            if ( DecimalUtil.compareTo(Z808F1357LDGRodado, T002I2_A808F1357LDGRodado[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGRodado");
               GXutil.writeLogRaw("Old: ",Z808F1357LDGRodado);
               GXutil.writeLogRaw("Current: ",T002I2_A808F1357LDGRodado[0]);
            }
            if ( DecimalUtil.compareTo(Z809F1357LDGDonaciones, T002I2_A809F1357LDGDonaciones[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGDonaciones");
               GXutil.writeLogRaw("Old: ",Z809F1357LDGDonaciones);
               GXutil.writeLogRaw("Current: ",T002I2_A809F1357LDGDonaciones[0]);
            }
            if ( DecimalUtil.compareTo(Z810F1357LDGOblig, T002I2_A810F1357LDGOblig[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGOblig");
               GXutil.writeLogRaw("Old: ",Z810F1357LDGOblig);
               GXutil.writeLogRaw("Current: ",T002I2_A810F1357LDGOblig[0]);
            }
            if ( DecimalUtil.compareTo(Z811F1357LDGMed, T002I2_A811F1357LDGMed[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGMed");
               GXutil.writeLogRaw("Old: ",Z811F1357LDGMed);
               GXutil.writeLogRaw("Current: ",T002I2_A811F1357LDGMed[0]);
            }
            if ( DecimalUtil.compareTo(Z812F1357LDGHipoteca, T002I2_A812F1357LDGHipoteca[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGHipoteca");
               GXutil.writeLogRaw("Old: ",Z812F1357LDGHipoteca);
               GXutil.writeLogRaw("Current: ",T002I2_A812F1357LDGHipoteca[0]);
            }
            if ( DecimalUtil.compareTo(Z813F1357LDGSGR, T002I2_A813F1357LDGSGR[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGSGR");
               GXutil.writeLogRaw("Old: ",Z813F1357LDGSGR);
               GXutil.writeLogRaw("Current: ",T002I2_A813F1357LDGSGR[0]);
            }
            if ( DecimalUtil.compareTo(Z814F1357LDGOtrasCaja, T002I2_A814F1357LDGOtrasCaja[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGOtrasCaja");
               GXutil.writeLogRaw("Old: ",Z814F1357LDGOtrasCaja);
               GXutil.writeLogRaw("Current: ",T002I2_A814F1357LDGOtrasCaja[0]);
            }
            if ( DecimalUtil.compareTo(Z815F1357LDGAlquiler, T002I2_A815F1357LDGAlquiler[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGAlquiler");
               GXutil.writeLogRaw("Old: ",Z815F1357LDGAlquiler);
               GXutil.writeLogRaw("Current: ",T002I2_A815F1357LDGAlquiler[0]);
            }
            if ( DecimalUtil.compareTo(Z816F1357LDGDomes, T002I2_A816F1357LDGDomes[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGDomes");
               GXutil.writeLogRaw("Old: ",Z816F1357LDGDomes);
               GXutil.writeLogRaw("Current: ",T002I2_A816F1357LDGDomes[0]);
            }
            if ( DecimalUtil.compareTo(Z817F1357LDGViaticos, T002I2_A817F1357LDGViaticos[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGViaticos");
               GXutil.writeLogRaw("Old: ",Z817F1357LDGViaticos);
               GXutil.writeLogRaw("Current: ",T002I2_A817F1357LDGViaticos[0]);
            }
            if ( DecimalUtil.compareTo(Z818F1357LDGIndu, T002I2_A818F1357LDGIndu[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGIndu");
               GXutil.writeLogRaw("Old: ",Z818F1357LDGIndu);
               GXutil.writeLogRaw("Current: ",T002I2_A818F1357LDGIndu[0]);
            }
            if ( DecimalUtil.compareTo(Z819F1357LDGOtras, T002I2_A819F1357LDGOtras[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGOtras");
               GXutil.writeLogRaw("Old: ",Z819F1357LDGOtras);
               GXutil.writeLogRaw("Current: ",T002I2_A819F1357LDGOtras[0]);
            }
            if ( DecimalUtil.compareTo(Z820F1357LDGTotal, T002I2_A820F1357LDGTotal[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGTotal");
               GXutil.writeLogRaw("Old: ",Z820F1357LDGTotal);
               GXutil.writeLogRaw("Current: ",T002I2_A820F1357LDGTotal[0]);
            }
            if ( DecimalUtil.compareTo(Z821F1357LDGOtrasAnses, T002I2_A821F1357LDGOtrasAnses[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGOtrasAnses");
               GXutil.writeLogRaw("Old: ",Z821F1357LDGOtrasAnses);
               GXutil.writeLogRaw("Current: ",T002I2_A821F1357LDGOtrasAnses[0]);
            }
            if ( DecimalUtil.compareTo(Z822F1357LDGOtrasProf, T002I2_A822F1357LDGOtrasProf[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGOtrasProf");
               GXutil.writeLogRaw("Old: ",Z822F1357LDGOtrasProf);
               GXutil.writeLogRaw("Current: ",T002I2_A822F1357LDGOtrasProf[0]);
            }
            if ( DecimalUtil.compareTo(Z823F1357LDGOtrasActores, T002I2_A823F1357LDGOtrasActores[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGOtrasActores");
               GXutil.writeLogRaw("Old: ",Z823F1357LDGOtrasActores);
               GXutil.writeLogRaw("Current: ",T002I2_A823F1357LDGOtrasActores[0]);
            }
            if ( DecimalUtil.compareTo(Z824F1357LDGOtrasPrev, T002I2_A824F1357LDGOtrasPrev[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGOtrasPrev");
               GXutil.writeLogRaw("Old: ",Z824F1357LDGOtrasPrev);
               GXutil.writeLogRaw("Current: ",T002I2_A824F1357LDGOtrasPrev[0]);
            }
            if ( DecimalUtil.compareTo(Z944F1357LDGEducativos, T002I2_A944F1357LDGEducativos[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGEducativos");
               GXutil.writeLogRaw("Old: ",Z944F1357LDGEducativos);
               GXutil.writeLogRaw("Current: ",T002I2_A944F1357LDGEducativos[0]);
            }
            if ( DecimalUtil.compareTo(Z1213F1357LDGMovEmpl, T002I2_A1213F1357LDGMovEmpl[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGMovEmpl");
               GXutil.writeLogRaw("Old: ",Z1213F1357LDGMovEmpl);
               GXutil.writeLogRaw("Current: ",T002I2_A1213F1357LDGMovEmpl[0]);
            }
            if ( DecimalUtil.compareTo(Z1214F1357LDGViaEmpl, T002I2_A1214F1357LDGViaEmpl[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGViaEmpl");
               GXutil.writeLogRaw("Old: ",Z1214F1357LDGViaEmpl);
               GXutil.writeLogRaw("Current: ",T002I2_A1214F1357LDGViaEmpl[0]);
            }
            if ( DecimalUtil.compareTo(Z1215F1357LDGCompAna, T002I2_A1215F1357LDGCompAna[0]) != 0 )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGCompAna");
               GXutil.writeLogRaw("Old: ",Z1215F1357LDGCompAna);
               GXutil.writeLogRaw("Current: ",T002I2_A1215F1357LDGCompAna[0]);
            }
            if ( Z1216F1357LDGCompAnaCnt != T002I2_A1216F1357LDGCompAnaCnt[0] )
            {
               GXutil.writeLogln("f1357legdedgen:[seudo value changed for attri]"+"F1357LDGCompAnaCnt");
               GXutil.writeLogRaw("Old: ",Z1216F1357LDGCompAnaCnt);
               GXutil.writeLogRaw("Current: ",T002I2_A1216F1357LDGCompAnaCnt[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"F1357LegDedGen"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2I96( )
   {
      beforeValidate2I96( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2I96( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2I96( 0) ;
         checkOptimisticConcurrency2I96( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2I96( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2I96( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002I12 */
                  pr_default.execute(10, new Object[] {A863F1357LDGTipReg, A802F1357LDGPrepaga, A803F1357LDGSeguro, A804F1357LDGSeguMixto, A805F1357LDGRetPriv, A806F1357LDGCuotapartes, A807F1357LDGSepelio, A808F1357LDGRodado, A809F1357LDGDonaciones, A810F1357LDGOblig, A811F1357LDGMed, A812F1357LDGHipoteca, A813F1357LDGSGR, A814F1357LDGOtrasCaja, A815F1357LDGAlquiler, A816F1357LDGDomes, A817F1357LDGViaticos, A818F1357LDGIndu, A819F1357LDGOtras, A820F1357LDGTotal, A821F1357LDGOtrasAnses, A822F1357LDGOtrasProf, A823F1357LDGOtrasActores, A824F1357LDGOtrasPrev, A944F1357LDGEducativos, A1213F1357LDGMovEmpl, A1214F1357LDGViaEmpl, A1215F1357LDGCompAna, Byte.valueOf(A1216F1357LDGCompAnaCnt), A825F1357LDGDescuentosLey, A826F1357LDGOtrDescuLey, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357LegDedGen");
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
                        resetCaption2I0( ) ;
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
            load2I96( ) ;
         }
         endLevel2I96( ) ;
      }
      closeExtendedTableCursors2I96( ) ;
   }

   public void update2I96( )
   {
      beforeValidate2I96( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2I96( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2I96( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2I96( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2I96( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002I13 */
                  pr_default.execute(11, new Object[] {A802F1357LDGPrepaga, A803F1357LDGSeguro, A804F1357LDGSeguMixto, A805F1357LDGRetPriv, A806F1357LDGCuotapartes, A807F1357LDGSepelio, A808F1357LDGRodado, A809F1357LDGDonaciones, A810F1357LDGOblig, A811F1357LDGMed, A812F1357LDGHipoteca, A813F1357LDGSGR, A814F1357LDGOtrasCaja, A815F1357LDGAlquiler, A816F1357LDGDomes, A817F1357LDGViaticos, A818F1357LDGIndu, A819F1357LDGOtras, A820F1357LDGTotal, A821F1357LDGOtrasAnses, A822F1357LDGOtrasProf, A823F1357LDGOtrasActores, A824F1357LDGOtrasPrev, A944F1357LDGEducativos, A1213F1357LDGMovEmpl, A1214F1357LDGViaEmpl, A1215F1357LDGCompAna, Byte.valueOf(A1216F1357LDGCompAnaCnt), A825F1357LDGDescuentosLey, A826F1357LDGOtrDescuLey, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A863F1357LDGTipReg});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357LegDedGen");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"F1357LegDedGen"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2I96( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption2I0( ) ;
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
         endLevel2I96( ) ;
      }
      closeExtendedTableCursors2I96( ) ;
   }

   public void deferredUpdate2I96( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate2I96( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2I96( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2I96( ) ;
         afterConfirm2I96( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2I96( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002I14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A863F1357LDGTipReg});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357LegDedGen");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound96 == 0 )
                     {
                        initAll2I96( ) ;
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
                     resetCaption2I0( ) ;
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
      sMode96 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2I96( ) ;
      Gx_mode = sMode96 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2I96( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel2I96( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2I96( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "f1357legdedgen");
         if ( AnyError == 0 )
         {
            confirmValues2I0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "f1357legdedgen");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2I96( )
   {
      /* Using cursor T002I15 */
      pr_default.execute(13);
      RcdFound96 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound96 = (short)(1) ;
         A3CliCod = T002I15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002I15_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A784F1357CTipoPre = T002I15_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002I15_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002I15_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         A6LegNumero = T002I15_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A863F1357LDGTipReg = T002I15_A863F1357LDGTipReg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A863F1357LDGTipReg", A863F1357LDGTipReg);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2I96( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound96 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound96 = (short)(1) ;
         A3CliCod = T002I15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T002I15_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A784F1357CTipoPre = T002I15_A784F1357CTipoPre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = T002I15_A777F1357CPer[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = T002I15_A778F1357CSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
         A6LegNumero = T002I15_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A863F1357LDGTipReg = T002I15_A863F1357LDGTipReg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A863F1357LDGTipReg", A863F1357LDGTipReg);
      }
   }

   public void scanEnd2I96( )
   {
      pr_default.close(13);
   }

   public void afterConfirm2I96( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2I96( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2I96( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2I96( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2I96( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2I96( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2I96( )
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
      edtF1357LDGTipReg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGTipReg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGTipReg_Enabled), 5, 0), true);
      edtF1357LDGPrepaga_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGPrepaga_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGPrepaga_Enabled), 5, 0), true);
      edtF1357LDGSeguro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGSeguro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGSeguro_Enabled), 5, 0), true);
      edtF1357LDGSeguMixto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGSeguMixto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGSeguMixto_Enabled), 5, 0), true);
      edtF1357LDGRetPriv_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGRetPriv_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGRetPriv_Enabled), 5, 0), true);
      edtF1357LDGCuotapartes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGCuotapartes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGCuotapartes_Enabled), 5, 0), true);
      edtF1357LDGSepelio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGSepelio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGSepelio_Enabled), 5, 0), true);
      edtF1357LDGRodado_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGRodado_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGRodado_Enabled), 5, 0), true);
      edtF1357LDGDonaciones_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGDonaciones_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGDonaciones_Enabled), 5, 0), true);
      edtF1357LDGOblig_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGOblig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGOblig_Enabled), 5, 0), true);
      edtF1357LDGMed_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGMed_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGMed_Enabled), 5, 0), true);
      edtF1357LDGHipoteca_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGHipoteca_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGHipoteca_Enabled), 5, 0), true);
      edtF1357LDGSGR_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGSGR_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGSGR_Enabled), 5, 0), true);
      edtF1357LDGOtrasCaja_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGOtrasCaja_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGOtrasCaja_Enabled), 5, 0), true);
      edtF1357LDGAlquiler_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGAlquiler_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGAlquiler_Enabled), 5, 0), true);
      edtF1357LDGDomes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGDomes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGDomes_Enabled), 5, 0), true);
      edtF1357LDGViaticos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGViaticos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGViaticos_Enabled), 5, 0), true);
      edtF1357LDGIndu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGIndu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGIndu_Enabled), 5, 0), true);
      edtF1357LDGOtras_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGOtras_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGOtras_Enabled), 5, 0), true);
      edtF1357LDGTotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGTotal_Enabled), 5, 0), true);
      edtF1357LDGOtrasAnses_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGOtrasAnses_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGOtrasAnses_Enabled), 5, 0), true);
      edtF1357LDGOtrasProf_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGOtrasProf_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGOtrasProf_Enabled), 5, 0), true);
      edtF1357LDGOtrasActores_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGOtrasActores_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGOtrasActores_Enabled), 5, 0), true);
      edtF1357LDGOtrasPrev_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGOtrasPrev_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGOtrasPrev_Enabled), 5, 0), true);
      edtF1357LDGEducativos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGEducativos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGEducativos_Enabled), 5, 0), true);
      edtF1357LDGMovEmpl_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGMovEmpl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGMovEmpl_Enabled), 5, 0), true);
      edtF1357LDGViaEmpl_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGViaEmpl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGViaEmpl_Enabled), 5, 0), true);
      edtF1357LDGCompAna_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGCompAna_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGCompAna_Enabled), 5, 0), true);
      edtF1357LDGCompAnaCnt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGCompAnaCnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGCompAnaCnt_Enabled), 5, 0), true);
      edtF1357LDGDescuentosLey_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGDescuentosLey_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGDescuentosLey_Enabled), 5, 0), true);
      edtF1357LDGOtrDescuLey_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtF1357LDGOtrDescuLey_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357LDGOtrDescuLey_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes2I96( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues2I0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.f1357legdedgen", new String[] {}, new String[] {}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "Z863F1357LDGTipReg", GXutil.rtrim( Z863F1357LDGTipReg));
      web.GxWebStd.gx_hidden_field( httpContext, "Z802F1357LDGPrepaga", GXutil.ltrim( localUtil.ntoc( Z802F1357LDGPrepaga, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z803F1357LDGSeguro", GXutil.ltrim( localUtil.ntoc( Z803F1357LDGSeguro, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z804F1357LDGSeguMixto", GXutil.ltrim( localUtil.ntoc( Z804F1357LDGSeguMixto, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z805F1357LDGRetPriv", GXutil.ltrim( localUtil.ntoc( Z805F1357LDGRetPriv, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z806F1357LDGCuotapartes", GXutil.ltrim( localUtil.ntoc( Z806F1357LDGCuotapartes, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z807F1357LDGSepelio", GXutil.ltrim( localUtil.ntoc( Z807F1357LDGSepelio, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z808F1357LDGRodado", GXutil.ltrim( localUtil.ntoc( Z808F1357LDGRodado, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z809F1357LDGDonaciones", GXutil.ltrim( localUtil.ntoc( Z809F1357LDGDonaciones, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z810F1357LDGOblig", GXutil.ltrim( localUtil.ntoc( Z810F1357LDGOblig, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z811F1357LDGMed", GXutil.ltrim( localUtil.ntoc( Z811F1357LDGMed, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z812F1357LDGHipoteca", GXutil.ltrim( localUtil.ntoc( Z812F1357LDGHipoteca, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z813F1357LDGSGR", GXutil.ltrim( localUtil.ntoc( Z813F1357LDGSGR, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z814F1357LDGOtrasCaja", GXutil.ltrim( localUtil.ntoc( Z814F1357LDGOtrasCaja, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z815F1357LDGAlquiler", GXutil.ltrim( localUtil.ntoc( Z815F1357LDGAlquiler, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z816F1357LDGDomes", GXutil.ltrim( localUtil.ntoc( Z816F1357LDGDomes, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z817F1357LDGViaticos", GXutil.ltrim( localUtil.ntoc( Z817F1357LDGViaticos, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z818F1357LDGIndu", GXutil.ltrim( localUtil.ntoc( Z818F1357LDGIndu, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z819F1357LDGOtras", GXutil.ltrim( localUtil.ntoc( Z819F1357LDGOtras, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z820F1357LDGTotal", GXutil.ltrim( localUtil.ntoc( Z820F1357LDGTotal, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z821F1357LDGOtrasAnses", GXutil.ltrim( localUtil.ntoc( Z821F1357LDGOtrasAnses, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z822F1357LDGOtrasProf", GXutil.ltrim( localUtil.ntoc( Z822F1357LDGOtrasProf, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z823F1357LDGOtrasActores", GXutil.ltrim( localUtil.ntoc( Z823F1357LDGOtrasActores, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z824F1357LDGOtrasPrev", GXutil.ltrim( localUtil.ntoc( Z824F1357LDGOtrasPrev, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z944F1357LDGEducativos", GXutil.ltrim( localUtil.ntoc( Z944F1357LDGEducativos, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1213F1357LDGMovEmpl", GXutil.ltrim( localUtil.ntoc( Z1213F1357LDGMovEmpl, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1214F1357LDGViaEmpl", GXutil.ltrim( localUtil.ntoc( Z1214F1357LDGViaEmpl, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1215F1357LDGCompAna", GXutil.ltrim( localUtil.ntoc( Z1215F1357LDGCompAna, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1216F1357LDGCompAnaCnt", GXutil.ltrim( localUtil.ntoc( Z1216F1357LDGCompAnaCnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      return formatLink("web.f1357legdedgen", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "F1357LegDedGen" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "F1357 Leg Ded Gen", "") ;
   }

   public void initializeNonKey2I96( )
   {
      A802F1357LDGPrepaga = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A802F1357LDGPrepaga", GXutil.ltrimstr( A802F1357LDGPrepaga, 16, 2));
      A803F1357LDGSeguro = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A803F1357LDGSeguro", GXutil.ltrimstr( A803F1357LDGSeguro, 16, 2));
      A804F1357LDGSeguMixto = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A804F1357LDGSeguMixto", GXutil.ltrimstr( A804F1357LDGSeguMixto, 16, 2));
      A805F1357LDGRetPriv = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A805F1357LDGRetPriv", GXutil.ltrimstr( A805F1357LDGRetPriv, 16, 2));
      A806F1357LDGCuotapartes = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A806F1357LDGCuotapartes", GXutil.ltrimstr( A806F1357LDGCuotapartes, 16, 2));
      A807F1357LDGSepelio = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A807F1357LDGSepelio", GXutil.ltrimstr( A807F1357LDGSepelio, 16, 2));
      A808F1357LDGRodado = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A808F1357LDGRodado", GXutil.ltrimstr( A808F1357LDGRodado, 16, 2));
      A809F1357LDGDonaciones = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A809F1357LDGDonaciones", GXutil.ltrimstr( A809F1357LDGDonaciones, 16, 2));
      A810F1357LDGOblig = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A810F1357LDGOblig", GXutil.ltrimstr( A810F1357LDGOblig, 16, 2));
      A811F1357LDGMed = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A811F1357LDGMed", GXutil.ltrimstr( A811F1357LDGMed, 16, 2));
      A812F1357LDGHipoteca = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A812F1357LDGHipoteca", GXutil.ltrimstr( A812F1357LDGHipoteca, 16, 2));
      A813F1357LDGSGR = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A813F1357LDGSGR", GXutil.ltrimstr( A813F1357LDGSGR, 16, 2));
      A814F1357LDGOtrasCaja = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A814F1357LDGOtrasCaja", GXutil.ltrimstr( A814F1357LDGOtrasCaja, 16, 2));
      A815F1357LDGAlquiler = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A815F1357LDGAlquiler", GXutil.ltrimstr( A815F1357LDGAlquiler, 16, 2));
      A816F1357LDGDomes = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A816F1357LDGDomes", GXutil.ltrimstr( A816F1357LDGDomes, 16, 2));
      A817F1357LDGViaticos = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A817F1357LDGViaticos", GXutil.ltrimstr( A817F1357LDGViaticos, 16, 2));
      A818F1357LDGIndu = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A818F1357LDGIndu", GXutil.ltrimstr( A818F1357LDGIndu, 16, 2));
      A819F1357LDGOtras = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A819F1357LDGOtras", GXutil.ltrimstr( A819F1357LDGOtras, 16, 2));
      A820F1357LDGTotal = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A820F1357LDGTotal", GXutil.ltrimstr( A820F1357LDGTotal, 16, 2));
      A821F1357LDGOtrasAnses = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A821F1357LDGOtrasAnses", GXutil.ltrimstr( A821F1357LDGOtrasAnses, 16, 2));
      A822F1357LDGOtrasProf = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A822F1357LDGOtrasProf", GXutil.ltrimstr( A822F1357LDGOtrasProf, 16, 2));
      A823F1357LDGOtrasActores = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A823F1357LDGOtrasActores", GXutil.ltrimstr( A823F1357LDGOtrasActores, 16, 2));
      A824F1357LDGOtrasPrev = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A824F1357LDGOtrasPrev", GXutil.ltrimstr( A824F1357LDGOtrasPrev, 16, 2));
      A944F1357LDGEducativos = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A944F1357LDGEducativos", GXutil.ltrimstr( A944F1357LDGEducativos, 16, 2));
      A1213F1357LDGMovEmpl = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1213F1357LDGMovEmpl", GXutil.ltrimstr( A1213F1357LDGMovEmpl, 16, 2));
      A1214F1357LDGViaEmpl = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1214F1357LDGViaEmpl", GXutil.ltrimstr( A1214F1357LDGViaEmpl, 16, 2));
      A1215F1357LDGCompAna = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1215F1357LDGCompAna", GXutil.ltrimstr( A1215F1357LDGCompAna, 16, 2));
      A1216F1357LDGCompAnaCnt = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1216F1357LDGCompAnaCnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1216F1357LDGCompAnaCnt), 2, 0));
      A825F1357LDGDescuentosLey = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A825F1357LDGDescuentosLey", A825F1357LDGDescuentosLey);
      A826F1357LDGOtrDescuLey = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A826F1357LDGOtrDescuLey", A826F1357LDGOtrDescuLey);
      Z802F1357LDGPrepaga = DecimalUtil.ZERO ;
      Z803F1357LDGSeguro = DecimalUtil.ZERO ;
      Z804F1357LDGSeguMixto = DecimalUtil.ZERO ;
      Z805F1357LDGRetPriv = DecimalUtil.ZERO ;
      Z806F1357LDGCuotapartes = DecimalUtil.ZERO ;
      Z807F1357LDGSepelio = DecimalUtil.ZERO ;
      Z808F1357LDGRodado = DecimalUtil.ZERO ;
      Z809F1357LDGDonaciones = DecimalUtil.ZERO ;
      Z810F1357LDGOblig = DecimalUtil.ZERO ;
      Z811F1357LDGMed = DecimalUtil.ZERO ;
      Z812F1357LDGHipoteca = DecimalUtil.ZERO ;
      Z813F1357LDGSGR = DecimalUtil.ZERO ;
      Z814F1357LDGOtrasCaja = DecimalUtil.ZERO ;
      Z815F1357LDGAlquiler = DecimalUtil.ZERO ;
      Z816F1357LDGDomes = DecimalUtil.ZERO ;
      Z817F1357LDGViaticos = DecimalUtil.ZERO ;
      Z818F1357LDGIndu = DecimalUtil.ZERO ;
      Z819F1357LDGOtras = DecimalUtil.ZERO ;
      Z820F1357LDGTotal = DecimalUtil.ZERO ;
      Z821F1357LDGOtrasAnses = DecimalUtil.ZERO ;
      Z822F1357LDGOtrasProf = DecimalUtil.ZERO ;
      Z823F1357LDGOtrasActores = DecimalUtil.ZERO ;
      Z824F1357LDGOtrasPrev = DecimalUtil.ZERO ;
      Z944F1357LDGEducativos = DecimalUtil.ZERO ;
      Z1213F1357LDGMovEmpl = DecimalUtil.ZERO ;
      Z1214F1357LDGViaEmpl = DecimalUtil.ZERO ;
      Z1215F1357LDGCompAna = DecimalUtil.ZERO ;
      Z1216F1357LDGCompAnaCnt = (byte)(0) ;
   }

   public void initAll2I96( )
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
      A863F1357LDGTipReg = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A863F1357LDGTipReg", A863F1357LDGTipReg);
      initializeNonKey2I96( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713391016", true, true);
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
      httpContext.AddJavascriptSource("f1357legdedgen.js", "?20251713391016", false, true);
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
      edtF1357LDGTipReg_Internalname = "F1357LDGTIPREG" ;
      edtF1357LDGPrepaga_Internalname = "F1357LDGPREPAGA" ;
      edtF1357LDGSeguro_Internalname = "F1357LDGSEGURO" ;
      edtF1357LDGSeguMixto_Internalname = "F1357LDGSEGUMIXTO" ;
      edtF1357LDGRetPriv_Internalname = "F1357LDGRETPRIV" ;
      edtF1357LDGCuotapartes_Internalname = "F1357LDGCUOTAPARTES" ;
      edtF1357LDGSepelio_Internalname = "F1357LDGSEPELIO" ;
      edtF1357LDGRodado_Internalname = "F1357LDGRODADO" ;
      edtF1357LDGDonaciones_Internalname = "F1357LDGDONACIONES" ;
      edtF1357LDGOblig_Internalname = "F1357LDGOBLIG" ;
      edtF1357LDGMed_Internalname = "F1357LDGMED" ;
      edtF1357LDGHipoteca_Internalname = "F1357LDGHIPOTECA" ;
      edtF1357LDGSGR_Internalname = "F1357LDGSGR" ;
      edtF1357LDGOtrasCaja_Internalname = "F1357LDGOTRASCAJA" ;
      edtF1357LDGAlquiler_Internalname = "F1357LDGALQUILER" ;
      edtF1357LDGDomes_Internalname = "F1357LDGDOMES" ;
      edtF1357LDGViaticos_Internalname = "F1357LDGVIATICOS" ;
      edtF1357LDGIndu_Internalname = "F1357LDGINDU" ;
      edtF1357LDGOtras_Internalname = "F1357LDGOTRAS" ;
      edtF1357LDGTotal_Internalname = "F1357LDGTOTAL" ;
      edtF1357LDGOtrasAnses_Internalname = "F1357LDGOTRASANSES" ;
      edtF1357LDGOtrasProf_Internalname = "F1357LDGOTRASPROF" ;
      edtF1357LDGOtrasActores_Internalname = "F1357LDGOTRASACTORES" ;
      edtF1357LDGOtrasPrev_Internalname = "F1357LDGOTRASPREV" ;
      edtF1357LDGEducativos_Internalname = "F1357LDGEDUCATIVOS" ;
      edtF1357LDGMovEmpl_Internalname = "F1357LDGMOVEMPL" ;
      edtF1357LDGViaEmpl_Internalname = "F1357LDGVIAEMPL" ;
      edtF1357LDGCompAna_Internalname = "F1357LDGCOMPANA" ;
      edtF1357LDGCompAnaCnt_Internalname = "F1357LDGCOMPANACNT" ;
      edtF1357LDGDescuentosLey_Internalname = "F1357LDGDESCUENTOSLEY" ;
      edtF1357LDGOtrDescuLey_Internalname = "F1357LDGOTRDESCULEY" ;
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
      Form.setCaption( httpContext.getMessage( "F1357 Leg Ded Gen", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtF1357LDGOtrDescuLey_Enabled = 1 ;
      edtF1357LDGDescuentosLey_Enabled = 1 ;
      edtF1357LDGCompAnaCnt_Jsonclick = "" ;
      edtF1357LDGCompAnaCnt_Enabled = 1 ;
      edtF1357LDGCompAna_Jsonclick = "" ;
      edtF1357LDGCompAna_Enabled = 1 ;
      edtF1357LDGViaEmpl_Jsonclick = "" ;
      edtF1357LDGViaEmpl_Enabled = 1 ;
      edtF1357LDGMovEmpl_Jsonclick = "" ;
      edtF1357LDGMovEmpl_Enabled = 1 ;
      edtF1357LDGEducativos_Jsonclick = "" ;
      edtF1357LDGEducativos_Enabled = 1 ;
      edtF1357LDGOtrasPrev_Jsonclick = "" ;
      edtF1357LDGOtrasPrev_Enabled = 1 ;
      edtF1357LDGOtrasActores_Jsonclick = "" ;
      edtF1357LDGOtrasActores_Enabled = 1 ;
      edtF1357LDGOtrasProf_Jsonclick = "" ;
      edtF1357LDGOtrasProf_Enabled = 1 ;
      edtF1357LDGOtrasAnses_Jsonclick = "" ;
      edtF1357LDGOtrasAnses_Enabled = 1 ;
      edtF1357LDGTotal_Jsonclick = "" ;
      edtF1357LDGTotal_Enabled = 1 ;
      edtF1357LDGOtras_Jsonclick = "" ;
      edtF1357LDGOtras_Enabled = 1 ;
      edtF1357LDGIndu_Jsonclick = "" ;
      edtF1357LDGIndu_Enabled = 1 ;
      edtF1357LDGViaticos_Jsonclick = "" ;
      edtF1357LDGViaticos_Enabled = 1 ;
      edtF1357LDGDomes_Jsonclick = "" ;
      edtF1357LDGDomes_Enabled = 1 ;
      edtF1357LDGAlquiler_Jsonclick = "" ;
      edtF1357LDGAlquiler_Enabled = 1 ;
      edtF1357LDGOtrasCaja_Jsonclick = "" ;
      edtF1357LDGOtrasCaja_Enabled = 1 ;
      edtF1357LDGSGR_Jsonclick = "" ;
      edtF1357LDGSGR_Enabled = 1 ;
      edtF1357LDGHipoteca_Jsonclick = "" ;
      edtF1357LDGHipoteca_Enabled = 1 ;
      edtF1357LDGMed_Jsonclick = "" ;
      edtF1357LDGMed_Enabled = 1 ;
      edtF1357LDGOblig_Jsonclick = "" ;
      edtF1357LDGOblig_Enabled = 1 ;
      edtF1357LDGDonaciones_Jsonclick = "" ;
      edtF1357LDGDonaciones_Enabled = 1 ;
      edtF1357LDGRodado_Jsonclick = "" ;
      edtF1357LDGRodado_Enabled = 1 ;
      edtF1357LDGSepelio_Jsonclick = "" ;
      edtF1357LDGSepelio_Enabled = 1 ;
      edtF1357LDGCuotapartes_Jsonclick = "" ;
      edtF1357LDGCuotapartes_Enabled = 1 ;
      edtF1357LDGRetPriv_Jsonclick = "" ;
      edtF1357LDGRetPriv_Enabled = 1 ;
      edtF1357LDGSeguMixto_Jsonclick = "" ;
      edtF1357LDGSeguMixto_Enabled = 1 ;
      edtF1357LDGSeguro_Jsonclick = "" ;
      edtF1357LDGSeguro_Enabled = 1 ;
      edtF1357LDGPrepaga_Jsonclick = "" ;
      edtF1357LDGPrepaga_Enabled = 1 ;
      edtF1357LDGTipReg_Jsonclick = "" ;
      edtF1357LDGTipReg_Enabled = 1 ;
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
      /* Using cursor T002I16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Formulario F1357", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "F1357CSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(14);
      /* Using cursor T002I17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(15);
      GX_FocusControl = edtF1357LDGPrepaga_Internalname ;
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
      /* Using cursor T002I16 */
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
      /* Using cursor T002I17 */
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

   public void valid_F1357ldgtipreg( )
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
      httpContext.ajax_rsp_assign_attri("", false, "A802F1357LDGPrepaga", GXutil.ltrim( localUtil.ntoc( A802F1357LDGPrepaga, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A803F1357LDGSeguro", GXutil.ltrim( localUtil.ntoc( A803F1357LDGSeguro, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A804F1357LDGSeguMixto", GXutil.ltrim( localUtil.ntoc( A804F1357LDGSeguMixto, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A805F1357LDGRetPriv", GXutil.ltrim( localUtil.ntoc( A805F1357LDGRetPriv, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A806F1357LDGCuotapartes", GXutil.ltrim( localUtil.ntoc( A806F1357LDGCuotapartes, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A807F1357LDGSepelio", GXutil.ltrim( localUtil.ntoc( A807F1357LDGSepelio, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A808F1357LDGRodado", GXutil.ltrim( localUtil.ntoc( A808F1357LDGRodado, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A809F1357LDGDonaciones", GXutil.ltrim( localUtil.ntoc( A809F1357LDGDonaciones, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A810F1357LDGOblig", GXutil.ltrim( localUtil.ntoc( A810F1357LDGOblig, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A811F1357LDGMed", GXutil.ltrim( localUtil.ntoc( A811F1357LDGMed, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A812F1357LDGHipoteca", GXutil.ltrim( localUtil.ntoc( A812F1357LDGHipoteca, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A813F1357LDGSGR", GXutil.ltrim( localUtil.ntoc( A813F1357LDGSGR, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A814F1357LDGOtrasCaja", GXutil.ltrim( localUtil.ntoc( A814F1357LDGOtrasCaja, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A815F1357LDGAlquiler", GXutil.ltrim( localUtil.ntoc( A815F1357LDGAlquiler, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A816F1357LDGDomes", GXutil.ltrim( localUtil.ntoc( A816F1357LDGDomes, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A817F1357LDGViaticos", GXutil.ltrim( localUtil.ntoc( A817F1357LDGViaticos, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A818F1357LDGIndu", GXutil.ltrim( localUtil.ntoc( A818F1357LDGIndu, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A819F1357LDGOtras", GXutil.ltrim( localUtil.ntoc( A819F1357LDGOtras, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A820F1357LDGTotal", GXutil.ltrim( localUtil.ntoc( A820F1357LDGTotal, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A821F1357LDGOtrasAnses", GXutil.ltrim( localUtil.ntoc( A821F1357LDGOtrasAnses, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A822F1357LDGOtrasProf", GXutil.ltrim( localUtil.ntoc( A822F1357LDGOtrasProf, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A823F1357LDGOtrasActores", GXutil.ltrim( localUtil.ntoc( A823F1357LDGOtrasActores, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A824F1357LDGOtrasPrev", GXutil.ltrim( localUtil.ntoc( A824F1357LDGOtrasPrev, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A944F1357LDGEducativos", GXutil.ltrim( localUtil.ntoc( A944F1357LDGEducativos, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1213F1357LDGMovEmpl", GXutil.ltrim( localUtil.ntoc( A1213F1357LDGMovEmpl, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1214F1357LDGViaEmpl", GXutil.ltrim( localUtil.ntoc( A1214F1357LDGViaEmpl, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1215F1357LDGCompAna", GXutil.ltrim( localUtil.ntoc( A1215F1357LDGCompAna, (byte)(16), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A1216F1357LDGCompAnaCnt", GXutil.ltrim( localUtil.ntoc( A1216F1357LDGCompAnaCnt, (byte)(2), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A825F1357LDGDescuentosLey", A825F1357LDGDescuentosLey);
      httpContext.ajax_rsp_assign_attri("", false, "A826F1357LDGOtrDescuLey", A826F1357LDGOtrDescuLey);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z784F1357CTipoPre", GXutil.ltrim( localUtil.ntoc( Z784F1357CTipoPre, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z777F1357CPer", GXutil.rtrim( Z777F1357CPer));
      web.GxWebStd.gx_hidden_field( httpContext, "Z778F1357CSec", GXutil.ltrim( localUtil.ntoc( Z778F1357CSec, (byte)(2), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z863F1357LDGTipReg", GXutil.rtrim( Z863F1357LDGTipReg));
      web.GxWebStd.gx_hidden_field( httpContext, "Z802F1357LDGPrepaga", GXutil.ltrim( localUtil.ntoc( Z802F1357LDGPrepaga, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z803F1357LDGSeguro", GXutil.ltrim( localUtil.ntoc( Z803F1357LDGSeguro, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z804F1357LDGSeguMixto", GXutil.ltrim( localUtil.ntoc( Z804F1357LDGSeguMixto, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z805F1357LDGRetPriv", GXutil.ltrim( localUtil.ntoc( Z805F1357LDGRetPriv, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z806F1357LDGCuotapartes", GXutil.ltrim( localUtil.ntoc( Z806F1357LDGCuotapartes, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z807F1357LDGSepelio", GXutil.ltrim( localUtil.ntoc( Z807F1357LDGSepelio, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z808F1357LDGRodado", GXutil.ltrim( localUtil.ntoc( Z808F1357LDGRodado, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z809F1357LDGDonaciones", GXutil.ltrim( localUtil.ntoc( Z809F1357LDGDonaciones, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z810F1357LDGOblig", GXutil.ltrim( localUtil.ntoc( Z810F1357LDGOblig, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z811F1357LDGMed", GXutil.ltrim( localUtil.ntoc( Z811F1357LDGMed, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z812F1357LDGHipoteca", GXutil.ltrim( localUtil.ntoc( Z812F1357LDGHipoteca, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z813F1357LDGSGR", GXutil.ltrim( localUtil.ntoc( Z813F1357LDGSGR, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z814F1357LDGOtrasCaja", GXutil.ltrim( localUtil.ntoc( Z814F1357LDGOtrasCaja, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z815F1357LDGAlquiler", GXutil.ltrim( localUtil.ntoc( Z815F1357LDGAlquiler, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z816F1357LDGDomes", GXutil.ltrim( localUtil.ntoc( Z816F1357LDGDomes, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z817F1357LDGViaticos", GXutil.ltrim( localUtil.ntoc( Z817F1357LDGViaticos, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z818F1357LDGIndu", GXutil.ltrim( localUtil.ntoc( Z818F1357LDGIndu, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z819F1357LDGOtras", GXutil.ltrim( localUtil.ntoc( Z819F1357LDGOtras, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z820F1357LDGTotal", GXutil.ltrim( localUtil.ntoc( Z820F1357LDGTotal, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z821F1357LDGOtrasAnses", GXutil.ltrim( localUtil.ntoc( Z821F1357LDGOtrasAnses, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z822F1357LDGOtrasProf", GXutil.ltrim( localUtil.ntoc( Z822F1357LDGOtrasProf, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z823F1357LDGOtrasActores", GXutil.ltrim( localUtil.ntoc( Z823F1357LDGOtrasActores, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z824F1357LDGOtrasPrev", GXutil.ltrim( localUtil.ntoc( Z824F1357LDGOtrasPrev, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z944F1357LDGEducativos", GXutil.ltrim( localUtil.ntoc( Z944F1357LDGEducativos, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1213F1357LDGMovEmpl", GXutil.ltrim( localUtil.ntoc( Z1213F1357LDGMovEmpl, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1214F1357LDGViaEmpl", GXutil.ltrim( localUtil.ntoc( Z1214F1357LDGViaEmpl, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1215F1357LDGCompAna", GXutil.ltrim( localUtil.ntoc( Z1215F1357LDGCompAna, (byte)(16), (byte)(2), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1216F1357LDGCompAnaCnt", GXutil.ltrim( localUtil.ntoc( Z1216F1357LDGCompAnaCnt, (byte)(2), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z825F1357LDGDescuentosLey", Z825F1357LDGDescuentosLey);
      web.GxWebStd.gx_hidden_field( httpContext, "Z826F1357LDGOtrDescuLey", Z826F1357LDGOtrDescuLey);
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
      setEventMetadata("VALID_F1357LDGTIPREG","{handler:'valid_F1357ldgtipreg',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'cmbF1357CTipoPre'},{av:'A784F1357CTipoPre',fld:'F1357CTIPOPRE',pic:'9'},{av:'A777F1357CPer',fld:'F1357CPER',pic:''},{av:'A778F1357CSec',fld:'F1357CSEC',pic:'Z9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A863F1357LDGTipReg',fld:'F1357LDGTIPREG',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_F1357LDGTIPREG",",oparms:[{av:'A802F1357LDGPrepaga',fld:'F1357LDGPREPAGA',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A803F1357LDGSeguro',fld:'F1357LDGSEGURO',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A804F1357LDGSeguMixto',fld:'F1357LDGSEGUMIXTO',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A805F1357LDGRetPriv',fld:'F1357LDGRETPRIV',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A806F1357LDGCuotapartes',fld:'F1357LDGCUOTAPARTES',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A807F1357LDGSepelio',fld:'F1357LDGSEPELIO',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A808F1357LDGRodado',fld:'F1357LDGRODADO',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A809F1357LDGDonaciones',fld:'F1357LDGDONACIONES',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A810F1357LDGOblig',fld:'F1357LDGOBLIG',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A811F1357LDGMed',fld:'F1357LDGMED',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A812F1357LDGHipoteca',fld:'F1357LDGHIPOTECA',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A813F1357LDGSGR',fld:'F1357LDGSGR',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A814F1357LDGOtrasCaja',fld:'F1357LDGOTRASCAJA',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A815F1357LDGAlquiler',fld:'F1357LDGALQUILER',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A816F1357LDGDomes',fld:'F1357LDGDOMES',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A817F1357LDGViaticos',fld:'F1357LDGVIATICOS',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A818F1357LDGIndu',fld:'F1357LDGINDU',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A819F1357LDGOtras',fld:'F1357LDGOTRAS',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A820F1357LDGTotal',fld:'F1357LDGTOTAL',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A821F1357LDGOtrasAnses',fld:'F1357LDGOTRASANSES',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A822F1357LDGOtrasProf',fld:'F1357LDGOTRASPROF',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A823F1357LDGOtrasActores',fld:'F1357LDGOTRASACTORES',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A824F1357LDGOtrasPrev',fld:'F1357LDGOTRASPREV',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A944F1357LDGEducativos',fld:'F1357LDGEDUCATIVOS',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1213F1357LDGMovEmpl',fld:'F1357LDGMOVEMPL',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1214F1357LDGViaEmpl',fld:'F1357LDGVIAEMPL',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1215F1357LDGCompAna',fld:'F1357LDGCOMPANA',pic:'Z,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1216F1357LDGCompAnaCnt',fld:'F1357LDGCOMPANACNT',pic:'Z9'},{av:'A825F1357LDGDescuentosLey',fld:'F1357LDGDESCUENTOSLEY',pic:''},{av:'A826F1357LDGOtrDescuLey',fld:'F1357LDGOTRDESCULEY',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z3CliCod'},{av:'Z1EmpCod'},{av:'Z784F1357CTipoPre'},{av:'Z777F1357CPer'},{av:'Z778F1357CSec'},{av:'Z6LegNumero'},{av:'Z863F1357LDGTipReg'},{av:'Z802F1357LDGPrepaga'},{av:'Z803F1357LDGSeguro'},{av:'Z804F1357LDGSeguMixto'},{av:'Z805F1357LDGRetPriv'},{av:'Z806F1357LDGCuotapartes'},{av:'Z807F1357LDGSepelio'},{av:'Z808F1357LDGRodado'},{av:'Z809F1357LDGDonaciones'},{av:'Z810F1357LDGOblig'},{av:'Z811F1357LDGMed'},{av:'Z812F1357LDGHipoteca'},{av:'Z813F1357LDGSGR'},{av:'Z814F1357LDGOtrasCaja'},{av:'Z815F1357LDGAlquiler'},{av:'Z816F1357LDGDomes'},{av:'Z817F1357LDGViaticos'},{av:'Z818F1357LDGIndu'},{av:'Z819F1357LDGOtras'},{av:'Z820F1357LDGTotal'},{av:'Z821F1357LDGOtrasAnses'},{av:'Z822F1357LDGOtrasProf'},{av:'Z823F1357LDGOtrasActores'},{av:'Z824F1357LDGOtrasPrev'},{av:'Z944F1357LDGEducativos'},{av:'Z1213F1357LDGMovEmpl'},{av:'Z1214F1357LDGViaEmpl'},{av:'Z1215F1357LDGCompAna'},{av:'Z1216F1357LDGCompAnaCnt'},{av:'Z825F1357LDGDescuentosLey'},{av:'Z826F1357LDGOtrDescuLey'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
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
      Z863F1357LDGTipReg = "" ;
      Z802F1357LDGPrepaga = DecimalUtil.ZERO ;
      Z803F1357LDGSeguro = DecimalUtil.ZERO ;
      Z804F1357LDGSeguMixto = DecimalUtil.ZERO ;
      Z805F1357LDGRetPriv = DecimalUtil.ZERO ;
      Z806F1357LDGCuotapartes = DecimalUtil.ZERO ;
      Z807F1357LDGSepelio = DecimalUtil.ZERO ;
      Z808F1357LDGRodado = DecimalUtil.ZERO ;
      Z809F1357LDGDonaciones = DecimalUtil.ZERO ;
      Z810F1357LDGOblig = DecimalUtil.ZERO ;
      Z811F1357LDGMed = DecimalUtil.ZERO ;
      Z812F1357LDGHipoteca = DecimalUtil.ZERO ;
      Z813F1357LDGSGR = DecimalUtil.ZERO ;
      Z814F1357LDGOtrasCaja = DecimalUtil.ZERO ;
      Z815F1357LDGAlquiler = DecimalUtil.ZERO ;
      Z816F1357LDGDomes = DecimalUtil.ZERO ;
      Z817F1357LDGViaticos = DecimalUtil.ZERO ;
      Z818F1357LDGIndu = DecimalUtil.ZERO ;
      Z819F1357LDGOtras = DecimalUtil.ZERO ;
      Z820F1357LDGTotal = DecimalUtil.ZERO ;
      Z821F1357LDGOtrasAnses = DecimalUtil.ZERO ;
      Z822F1357LDGOtrasProf = DecimalUtil.ZERO ;
      Z823F1357LDGOtrasActores = DecimalUtil.ZERO ;
      Z824F1357LDGOtrasPrev = DecimalUtil.ZERO ;
      Z944F1357LDGEducativos = DecimalUtil.ZERO ;
      Z1213F1357LDGMovEmpl = DecimalUtil.ZERO ;
      Z1214F1357LDGViaEmpl = DecimalUtil.ZERO ;
      Z1215F1357LDGCompAna = DecimalUtil.ZERO ;
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
      A863F1357LDGTipReg = "" ;
      A802F1357LDGPrepaga = DecimalUtil.ZERO ;
      A803F1357LDGSeguro = DecimalUtil.ZERO ;
      A804F1357LDGSeguMixto = DecimalUtil.ZERO ;
      A805F1357LDGRetPriv = DecimalUtil.ZERO ;
      A806F1357LDGCuotapartes = DecimalUtil.ZERO ;
      A807F1357LDGSepelio = DecimalUtil.ZERO ;
      A808F1357LDGRodado = DecimalUtil.ZERO ;
      A809F1357LDGDonaciones = DecimalUtil.ZERO ;
      A810F1357LDGOblig = DecimalUtil.ZERO ;
      A811F1357LDGMed = DecimalUtil.ZERO ;
      A812F1357LDGHipoteca = DecimalUtil.ZERO ;
      A813F1357LDGSGR = DecimalUtil.ZERO ;
      A814F1357LDGOtrasCaja = DecimalUtil.ZERO ;
      A815F1357LDGAlquiler = DecimalUtil.ZERO ;
      A816F1357LDGDomes = DecimalUtil.ZERO ;
      A817F1357LDGViaticos = DecimalUtil.ZERO ;
      A818F1357LDGIndu = DecimalUtil.ZERO ;
      A819F1357LDGOtras = DecimalUtil.ZERO ;
      A820F1357LDGTotal = DecimalUtil.ZERO ;
      A821F1357LDGOtrasAnses = DecimalUtil.ZERO ;
      A822F1357LDGOtrasProf = DecimalUtil.ZERO ;
      A823F1357LDGOtrasActores = DecimalUtil.ZERO ;
      A824F1357LDGOtrasPrev = DecimalUtil.ZERO ;
      A944F1357LDGEducativos = DecimalUtil.ZERO ;
      A1213F1357LDGMovEmpl = DecimalUtil.ZERO ;
      A1214F1357LDGViaEmpl = DecimalUtil.ZERO ;
      A1215F1357LDGCompAna = DecimalUtil.ZERO ;
      A825F1357LDGDescuentosLey = "" ;
      A826F1357LDGOtrDescuLey = "" ;
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
      Z825F1357LDGDescuentosLey = "" ;
      Z826F1357LDGOtrDescuLey = "" ;
      T002I6_A863F1357LDGTipReg = new String[] {""} ;
      T002I6_A802F1357LDGPrepaga = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A803F1357LDGSeguro = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A804F1357LDGSeguMixto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A805F1357LDGRetPriv = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A806F1357LDGCuotapartes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A807F1357LDGSepelio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A808F1357LDGRodado = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A809F1357LDGDonaciones = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A810F1357LDGOblig = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A811F1357LDGMed = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A812F1357LDGHipoteca = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A813F1357LDGSGR = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A814F1357LDGOtrasCaja = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A815F1357LDGAlquiler = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A816F1357LDGDomes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A817F1357LDGViaticos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A818F1357LDGIndu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A819F1357LDGOtras = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A820F1357LDGTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A821F1357LDGOtrasAnses = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A822F1357LDGOtrasProf = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A823F1357LDGOtrasActores = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A824F1357LDGOtrasPrev = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A944F1357LDGEducativos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A1213F1357LDGMovEmpl = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A1214F1357LDGViaEmpl = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A1215F1357LDGCompAna = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I6_A1216F1357LDGCompAnaCnt = new byte[1] ;
      T002I6_A825F1357LDGDescuentosLey = new String[] {""} ;
      T002I6_A826F1357LDGOtrDescuLey = new String[] {""} ;
      T002I6_A3CliCod = new int[1] ;
      T002I6_A1EmpCod = new short[1] ;
      T002I6_A6LegNumero = new int[1] ;
      T002I6_A784F1357CTipoPre = new byte[1] ;
      T002I6_A777F1357CPer = new String[] {""} ;
      T002I6_A778F1357CSec = new byte[1] ;
      T002I5_A3CliCod = new int[1] ;
      T002I4_A3CliCod = new int[1] ;
      T002I7_A3CliCod = new int[1] ;
      T002I8_A3CliCod = new int[1] ;
      T002I9_A3CliCod = new int[1] ;
      T002I9_A1EmpCod = new short[1] ;
      T002I9_A784F1357CTipoPre = new byte[1] ;
      T002I9_A777F1357CPer = new String[] {""} ;
      T002I9_A778F1357CSec = new byte[1] ;
      T002I9_A6LegNumero = new int[1] ;
      T002I9_A863F1357LDGTipReg = new String[] {""} ;
      T002I3_A863F1357LDGTipReg = new String[] {""} ;
      T002I3_A802F1357LDGPrepaga = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A803F1357LDGSeguro = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A804F1357LDGSeguMixto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A805F1357LDGRetPriv = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A806F1357LDGCuotapartes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A807F1357LDGSepelio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A808F1357LDGRodado = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A809F1357LDGDonaciones = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A810F1357LDGOblig = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A811F1357LDGMed = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A812F1357LDGHipoteca = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A813F1357LDGSGR = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A814F1357LDGOtrasCaja = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A815F1357LDGAlquiler = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A816F1357LDGDomes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A817F1357LDGViaticos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A818F1357LDGIndu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A819F1357LDGOtras = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A820F1357LDGTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A821F1357LDGOtrasAnses = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A822F1357LDGOtrasProf = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A823F1357LDGOtrasActores = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A824F1357LDGOtrasPrev = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A944F1357LDGEducativos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A1213F1357LDGMovEmpl = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A1214F1357LDGViaEmpl = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A1215F1357LDGCompAna = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I3_A1216F1357LDGCompAnaCnt = new byte[1] ;
      T002I3_A825F1357LDGDescuentosLey = new String[] {""} ;
      T002I3_A826F1357LDGOtrDescuLey = new String[] {""} ;
      T002I3_A3CliCod = new int[1] ;
      T002I3_A1EmpCod = new short[1] ;
      T002I3_A6LegNumero = new int[1] ;
      T002I3_A784F1357CTipoPre = new byte[1] ;
      T002I3_A777F1357CPer = new String[] {""} ;
      T002I3_A778F1357CSec = new byte[1] ;
      sMode96 = "" ;
      T002I10_A3CliCod = new int[1] ;
      T002I10_A1EmpCod = new short[1] ;
      T002I10_A784F1357CTipoPre = new byte[1] ;
      T002I10_A777F1357CPer = new String[] {""} ;
      T002I10_A778F1357CSec = new byte[1] ;
      T002I10_A6LegNumero = new int[1] ;
      T002I10_A863F1357LDGTipReg = new String[] {""} ;
      T002I11_A3CliCod = new int[1] ;
      T002I11_A1EmpCod = new short[1] ;
      T002I11_A784F1357CTipoPre = new byte[1] ;
      T002I11_A777F1357CPer = new String[] {""} ;
      T002I11_A778F1357CSec = new byte[1] ;
      T002I11_A6LegNumero = new int[1] ;
      T002I11_A863F1357LDGTipReg = new String[] {""} ;
      T002I2_A863F1357LDGTipReg = new String[] {""} ;
      T002I2_A802F1357LDGPrepaga = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A803F1357LDGSeguro = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A804F1357LDGSeguMixto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A805F1357LDGRetPriv = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A806F1357LDGCuotapartes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A807F1357LDGSepelio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A808F1357LDGRodado = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A809F1357LDGDonaciones = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A810F1357LDGOblig = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A811F1357LDGMed = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A812F1357LDGHipoteca = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A813F1357LDGSGR = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A814F1357LDGOtrasCaja = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A815F1357LDGAlquiler = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A816F1357LDGDomes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A817F1357LDGViaticos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A818F1357LDGIndu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A819F1357LDGOtras = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A820F1357LDGTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A821F1357LDGOtrasAnses = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A822F1357LDGOtrasProf = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A823F1357LDGOtrasActores = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A824F1357LDGOtrasPrev = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A944F1357LDGEducativos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A1213F1357LDGMovEmpl = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A1214F1357LDGViaEmpl = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A1215F1357LDGCompAna = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002I2_A1216F1357LDGCompAnaCnt = new byte[1] ;
      T002I2_A825F1357LDGDescuentosLey = new String[] {""} ;
      T002I2_A826F1357LDGOtrDescuLey = new String[] {""} ;
      T002I2_A3CliCod = new int[1] ;
      T002I2_A1EmpCod = new short[1] ;
      T002I2_A6LegNumero = new int[1] ;
      T002I2_A784F1357CTipoPre = new byte[1] ;
      T002I2_A777F1357CPer = new String[] {""} ;
      T002I2_A778F1357CSec = new byte[1] ;
      T002I15_A3CliCod = new int[1] ;
      T002I15_A1EmpCod = new short[1] ;
      T002I15_A784F1357CTipoPre = new byte[1] ;
      T002I15_A777F1357CPer = new String[] {""} ;
      T002I15_A778F1357CSec = new byte[1] ;
      T002I15_A6LegNumero = new int[1] ;
      T002I15_A863F1357LDGTipReg = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T002I16_A3CliCod = new int[1] ;
      T002I17_A3CliCod = new int[1] ;
      ZZ777F1357CPer = "" ;
      ZZ863F1357LDGTipReg = "" ;
      ZZ802F1357LDGPrepaga = DecimalUtil.ZERO ;
      ZZ803F1357LDGSeguro = DecimalUtil.ZERO ;
      ZZ804F1357LDGSeguMixto = DecimalUtil.ZERO ;
      ZZ805F1357LDGRetPriv = DecimalUtil.ZERO ;
      ZZ806F1357LDGCuotapartes = DecimalUtil.ZERO ;
      ZZ807F1357LDGSepelio = DecimalUtil.ZERO ;
      ZZ808F1357LDGRodado = DecimalUtil.ZERO ;
      ZZ809F1357LDGDonaciones = DecimalUtil.ZERO ;
      ZZ810F1357LDGOblig = DecimalUtil.ZERO ;
      ZZ811F1357LDGMed = DecimalUtil.ZERO ;
      ZZ812F1357LDGHipoteca = DecimalUtil.ZERO ;
      ZZ813F1357LDGSGR = DecimalUtil.ZERO ;
      ZZ814F1357LDGOtrasCaja = DecimalUtil.ZERO ;
      ZZ815F1357LDGAlquiler = DecimalUtil.ZERO ;
      ZZ816F1357LDGDomes = DecimalUtil.ZERO ;
      ZZ817F1357LDGViaticos = DecimalUtil.ZERO ;
      ZZ818F1357LDGIndu = DecimalUtil.ZERO ;
      ZZ819F1357LDGOtras = DecimalUtil.ZERO ;
      ZZ820F1357LDGTotal = DecimalUtil.ZERO ;
      ZZ821F1357LDGOtrasAnses = DecimalUtil.ZERO ;
      ZZ822F1357LDGOtrasProf = DecimalUtil.ZERO ;
      ZZ823F1357LDGOtrasActores = DecimalUtil.ZERO ;
      ZZ824F1357LDGOtrasPrev = DecimalUtil.ZERO ;
      ZZ944F1357LDGEducativos = DecimalUtil.ZERO ;
      ZZ1213F1357LDGMovEmpl = DecimalUtil.ZERO ;
      ZZ1214F1357LDGViaEmpl = DecimalUtil.ZERO ;
      ZZ1215F1357LDGCompAna = DecimalUtil.ZERO ;
      ZZ825F1357LDGDescuentosLey = "" ;
      ZZ826F1357LDGOtrDescuLey = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357legdedgen__default(),
         new Object[] {
             new Object[] {
            T002I2_A863F1357LDGTipReg, T002I2_A802F1357LDGPrepaga, T002I2_A803F1357LDGSeguro, T002I2_A804F1357LDGSeguMixto, T002I2_A805F1357LDGRetPriv, T002I2_A806F1357LDGCuotapartes, T002I2_A807F1357LDGSepelio, T002I2_A808F1357LDGRodado, T002I2_A809F1357LDGDonaciones, T002I2_A810F1357LDGOblig,
            T002I2_A811F1357LDGMed, T002I2_A812F1357LDGHipoteca, T002I2_A813F1357LDGSGR, T002I2_A814F1357LDGOtrasCaja, T002I2_A815F1357LDGAlquiler, T002I2_A816F1357LDGDomes, T002I2_A817F1357LDGViaticos, T002I2_A818F1357LDGIndu, T002I2_A819F1357LDGOtras, T002I2_A820F1357LDGTotal,
            T002I2_A821F1357LDGOtrasAnses, T002I2_A822F1357LDGOtrasProf, T002I2_A823F1357LDGOtrasActores, T002I2_A824F1357LDGOtrasPrev, T002I2_A944F1357LDGEducativos, T002I2_A1213F1357LDGMovEmpl, T002I2_A1214F1357LDGViaEmpl, T002I2_A1215F1357LDGCompAna, T002I2_A1216F1357LDGCompAnaCnt, T002I2_A825F1357LDGDescuentosLey,
            T002I2_A826F1357LDGOtrDescuLey, T002I2_A3CliCod, T002I2_A1EmpCod, T002I2_A6LegNumero, T002I2_A784F1357CTipoPre, T002I2_A777F1357CPer, T002I2_A778F1357CSec
            }
            , new Object[] {
            T002I3_A863F1357LDGTipReg, T002I3_A802F1357LDGPrepaga, T002I3_A803F1357LDGSeguro, T002I3_A804F1357LDGSeguMixto, T002I3_A805F1357LDGRetPriv, T002I3_A806F1357LDGCuotapartes, T002I3_A807F1357LDGSepelio, T002I3_A808F1357LDGRodado, T002I3_A809F1357LDGDonaciones, T002I3_A810F1357LDGOblig,
            T002I3_A811F1357LDGMed, T002I3_A812F1357LDGHipoteca, T002I3_A813F1357LDGSGR, T002I3_A814F1357LDGOtrasCaja, T002I3_A815F1357LDGAlquiler, T002I3_A816F1357LDGDomes, T002I3_A817F1357LDGViaticos, T002I3_A818F1357LDGIndu, T002I3_A819F1357LDGOtras, T002I3_A820F1357LDGTotal,
            T002I3_A821F1357LDGOtrasAnses, T002I3_A822F1357LDGOtrasProf, T002I3_A823F1357LDGOtrasActores, T002I3_A824F1357LDGOtrasPrev, T002I3_A944F1357LDGEducativos, T002I3_A1213F1357LDGMovEmpl, T002I3_A1214F1357LDGViaEmpl, T002I3_A1215F1357LDGCompAna, T002I3_A1216F1357LDGCompAnaCnt, T002I3_A825F1357LDGDescuentosLey,
            T002I3_A826F1357LDGOtrDescuLey, T002I3_A3CliCod, T002I3_A1EmpCod, T002I3_A6LegNumero, T002I3_A784F1357CTipoPre, T002I3_A777F1357CPer, T002I3_A778F1357CSec
            }
            , new Object[] {
            T002I4_A3CliCod
            }
            , new Object[] {
            T002I5_A3CliCod
            }
            , new Object[] {
            T002I6_A863F1357LDGTipReg, T002I6_A802F1357LDGPrepaga, T002I6_A803F1357LDGSeguro, T002I6_A804F1357LDGSeguMixto, T002I6_A805F1357LDGRetPriv, T002I6_A806F1357LDGCuotapartes, T002I6_A807F1357LDGSepelio, T002I6_A808F1357LDGRodado, T002I6_A809F1357LDGDonaciones, T002I6_A810F1357LDGOblig,
            T002I6_A811F1357LDGMed, T002I6_A812F1357LDGHipoteca, T002I6_A813F1357LDGSGR, T002I6_A814F1357LDGOtrasCaja, T002I6_A815F1357LDGAlquiler, T002I6_A816F1357LDGDomes, T002I6_A817F1357LDGViaticos, T002I6_A818F1357LDGIndu, T002I6_A819F1357LDGOtras, T002I6_A820F1357LDGTotal,
            T002I6_A821F1357LDGOtrasAnses, T002I6_A822F1357LDGOtrasProf, T002I6_A823F1357LDGOtrasActores, T002I6_A824F1357LDGOtrasPrev, T002I6_A944F1357LDGEducativos, T002I6_A1213F1357LDGMovEmpl, T002I6_A1214F1357LDGViaEmpl, T002I6_A1215F1357LDGCompAna, T002I6_A1216F1357LDGCompAnaCnt, T002I6_A825F1357LDGDescuentosLey,
            T002I6_A826F1357LDGOtrDescuLey, T002I6_A3CliCod, T002I6_A1EmpCod, T002I6_A6LegNumero, T002I6_A784F1357CTipoPre, T002I6_A777F1357CPer, T002I6_A778F1357CSec
            }
            , new Object[] {
            T002I7_A3CliCod
            }
            , new Object[] {
            T002I8_A3CliCod
            }
            , new Object[] {
            T002I9_A3CliCod, T002I9_A1EmpCod, T002I9_A784F1357CTipoPre, T002I9_A777F1357CPer, T002I9_A778F1357CSec, T002I9_A6LegNumero, T002I9_A863F1357LDGTipReg
            }
            , new Object[] {
            T002I10_A3CliCod, T002I10_A1EmpCod, T002I10_A784F1357CTipoPre, T002I10_A777F1357CPer, T002I10_A778F1357CSec, T002I10_A6LegNumero, T002I10_A863F1357LDGTipReg
            }
            , new Object[] {
            T002I11_A3CliCod, T002I11_A1EmpCod, T002I11_A784F1357CTipoPre, T002I11_A777F1357CPer, T002I11_A778F1357CSec, T002I11_A6LegNumero, T002I11_A863F1357LDGTipReg
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002I15_A3CliCod, T002I15_A1EmpCod, T002I15_A784F1357CTipoPre, T002I15_A777F1357CPer, T002I15_A778F1357CSec, T002I15_A6LegNumero, T002I15_A863F1357LDGTipReg
            }
            , new Object[] {
            T002I16_A3CliCod
            }
            , new Object[] {
            T002I17_A3CliCod
            }
         }
      );
   }

   private byte Z784F1357CTipoPre ;
   private byte Z778F1357CSec ;
   private byte Z1216F1357LDGCompAnaCnt ;
   private byte GxWebError ;
   private byte A784F1357CTipoPre ;
   private byte A778F1357CSec ;
   private byte nKeyPressed ;
   private byte A1216F1357LDGCompAnaCnt ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private byte ZZ784F1357CTipoPre ;
   private byte ZZ778F1357CSec ;
   private byte ZZ1216F1357LDGCompAnaCnt ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound96 ;
   private short nIsDirty_96 ;
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
   private int edtF1357LDGTipReg_Enabled ;
   private int edtF1357LDGPrepaga_Enabled ;
   private int edtF1357LDGSeguro_Enabled ;
   private int edtF1357LDGSeguMixto_Enabled ;
   private int edtF1357LDGRetPriv_Enabled ;
   private int edtF1357LDGCuotapartes_Enabled ;
   private int edtF1357LDGSepelio_Enabled ;
   private int edtF1357LDGRodado_Enabled ;
   private int edtF1357LDGDonaciones_Enabled ;
   private int edtF1357LDGOblig_Enabled ;
   private int edtF1357LDGMed_Enabled ;
   private int edtF1357LDGHipoteca_Enabled ;
   private int edtF1357LDGSGR_Enabled ;
   private int edtF1357LDGOtrasCaja_Enabled ;
   private int edtF1357LDGAlquiler_Enabled ;
   private int edtF1357LDGDomes_Enabled ;
   private int edtF1357LDGViaticos_Enabled ;
   private int edtF1357LDGIndu_Enabled ;
   private int edtF1357LDGOtras_Enabled ;
   private int edtF1357LDGTotal_Enabled ;
   private int edtF1357LDGOtrasAnses_Enabled ;
   private int edtF1357LDGOtrasProf_Enabled ;
   private int edtF1357LDGOtrasActores_Enabled ;
   private int edtF1357LDGOtrasPrev_Enabled ;
   private int edtF1357LDGEducativos_Enabled ;
   private int edtF1357LDGMovEmpl_Enabled ;
   private int edtF1357LDGViaEmpl_Enabled ;
   private int edtF1357LDGCompAna_Enabled ;
   private int edtF1357LDGCompAnaCnt_Enabled ;
   private int edtF1357LDGDescuentosLey_Enabled ;
   private int edtF1357LDGOtrDescuLey_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ3CliCod ;
   private int ZZ6LegNumero ;
   private java.math.BigDecimal Z802F1357LDGPrepaga ;
   private java.math.BigDecimal Z803F1357LDGSeguro ;
   private java.math.BigDecimal Z804F1357LDGSeguMixto ;
   private java.math.BigDecimal Z805F1357LDGRetPriv ;
   private java.math.BigDecimal Z806F1357LDGCuotapartes ;
   private java.math.BigDecimal Z807F1357LDGSepelio ;
   private java.math.BigDecimal Z808F1357LDGRodado ;
   private java.math.BigDecimal Z809F1357LDGDonaciones ;
   private java.math.BigDecimal Z810F1357LDGOblig ;
   private java.math.BigDecimal Z811F1357LDGMed ;
   private java.math.BigDecimal Z812F1357LDGHipoteca ;
   private java.math.BigDecimal Z813F1357LDGSGR ;
   private java.math.BigDecimal Z814F1357LDGOtrasCaja ;
   private java.math.BigDecimal Z815F1357LDGAlquiler ;
   private java.math.BigDecimal Z816F1357LDGDomes ;
   private java.math.BigDecimal Z817F1357LDGViaticos ;
   private java.math.BigDecimal Z818F1357LDGIndu ;
   private java.math.BigDecimal Z819F1357LDGOtras ;
   private java.math.BigDecimal Z820F1357LDGTotal ;
   private java.math.BigDecimal Z821F1357LDGOtrasAnses ;
   private java.math.BigDecimal Z822F1357LDGOtrasProf ;
   private java.math.BigDecimal Z823F1357LDGOtrasActores ;
   private java.math.BigDecimal Z824F1357LDGOtrasPrev ;
   private java.math.BigDecimal Z944F1357LDGEducativos ;
   private java.math.BigDecimal Z1213F1357LDGMovEmpl ;
   private java.math.BigDecimal Z1214F1357LDGViaEmpl ;
   private java.math.BigDecimal Z1215F1357LDGCompAna ;
   private java.math.BigDecimal A802F1357LDGPrepaga ;
   private java.math.BigDecimal A803F1357LDGSeguro ;
   private java.math.BigDecimal A804F1357LDGSeguMixto ;
   private java.math.BigDecimal A805F1357LDGRetPriv ;
   private java.math.BigDecimal A806F1357LDGCuotapartes ;
   private java.math.BigDecimal A807F1357LDGSepelio ;
   private java.math.BigDecimal A808F1357LDGRodado ;
   private java.math.BigDecimal A809F1357LDGDonaciones ;
   private java.math.BigDecimal A810F1357LDGOblig ;
   private java.math.BigDecimal A811F1357LDGMed ;
   private java.math.BigDecimal A812F1357LDGHipoteca ;
   private java.math.BigDecimal A813F1357LDGSGR ;
   private java.math.BigDecimal A814F1357LDGOtrasCaja ;
   private java.math.BigDecimal A815F1357LDGAlquiler ;
   private java.math.BigDecimal A816F1357LDGDomes ;
   private java.math.BigDecimal A817F1357LDGViaticos ;
   private java.math.BigDecimal A818F1357LDGIndu ;
   private java.math.BigDecimal A819F1357LDGOtras ;
   private java.math.BigDecimal A820F1357LDGTotal ;
   private java.math.BigDecimal A821F1357LDGOtrasAnses ;
   private java.math.BigDecimal A822F1357LDGOtrasProf ;
   private java.math.BigDecimal A823F1357LDGOtrasActores ;
   private java.math.BigDecimal A824F1357LDGOtrasPrev ;
   private java.math.BigDecimal A944F1357LDGEducativos ;
   private java.math.BigDecimal A1213F1357LDGMovEmpl ;
   private java.math.BigDecimal A1214F1357LDGViaEmpl ;
   private java.math.BigDecimal A1215F1357LDGCompAna ;
   private java.math.BigDecimal ZZ802F1357LDGPrepaga ;
   private java.math.BigDecimal ZZ803F1357LDGSeguro ;
   private java.math.BigDecimal ZZ804F1357LDGSeguMixto ;
   private java.math.BigDecimal ZZ805F1357LDGRetPriv ;
   private java.math.BigDecimal ZZ806F1357LDGCuotapartes ;
   private java.math.BigDecimal ZZ807F1357LDGSepelio ;
   private java.math.BigDecimal ZZ808F1357LDGRodado ;
   private java.math.BigDecimal ZZ809F1357LDGDonaciones ;
   private java.math.BigDecimal ZZ810F1357LDGOblig ;
   private java.math.BigDecimal ZZ811F1357LDGMed ;
   private java.math.BigDecimal ZZ812F1357LDGHipoteca ;
   private java.math.BigDecimal ZZ813F1357LDGSGR ;
   private java.math.BigDecimal ZZ814F1357LDGOtrasCaja ;
   private java.math.BigDecimal ZZ815F1357LDGAlquiler ;
   private java.math.BigDecimal ZZ816F1357LDGDomes ;
   private java.math.BigDecimal ZZ817F1357LDGViaticos ;
   private java.math.BigDecimal ZZ818F1357LDGIndu ;
   private java.math.BigDecimal ZZ819F1357LDGOtras ;
   private java.math.BigDecimal ZZ820F1357LDGTotal ;
   private java.math.BigDecimal ZZ821F1357LDGOtrasAnses ;
   private java.math.BigDecimal ZZ822F1357LDGOtrasProf ;
   private java.math.BigDecimal ZZ823F1357LDGOtrasActores ;
   private java.math.BigDecimal ZZ824F1357LDGOtrasPrev ;
   private java.math.BigDecimal ZZ944F1357LDGEducativos ;
   private java.math.BigDecimal ZZ1213F1357LDGMovEmpl ;
   private java.math.BigDecimal ZZ1214F1357LDGViaEmpl ;
   private java.math.BigDecimal ZZ1215F1357LDGCompAna ;
   private String sPrefix ;
   private String Z777F1357CPer ;
   private String Z863F1357LDGTipReg ;
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
   private String edtF1357LDGTipReg_Internalname ;
   private String A863F1357LDGTipReg ;
   private String edtF1357LDGTipReg_Jsonclick ;
   private String edtF1357LDGPrepaga_Internalname ;
   private String edtF1357LDGPrepaga_Jsonclick ;
   private String edtF1357LDGSeguro_Internalname ;
   private String edtF1357LDGSeguro_Jsonclick ;
   private String edtF1357LDGSeguMixto_Internalname ;
   private String edtF1357LDGSeguMixto_Jsonclick ;
   private String edtF1357LDGRetPriv_Internalname ;
   private String edtF1357LDGRetPriv_Jsonclick ;
   private String edtF1357LDGCuotapartes_Internalname ;
   private String edtF1357LDGCuotapartes_Jsonclick ;
   private String edtF1357LDGSepelio_Internalname ;
   private String edtF1357LDGSepelio_Jsonclick ;
   private String edtF1357LDGRodado_Internalname ;
   private String edtF1357LDGRodado_Jsonclick ;
   private String edtF1357LDGDonaciones_Internalname ;
   private String edtF1357LDGDonaciones_Jsonclick ;
   private String edtF1357LDGOblig_Internalname ;
   private String edtF1357LDGOblig_Jsonclick ;
   private String edtF1357LDGMed_Internalname ;
   private String edtF1357LDGMed_Jsonclick ;
   private String edtF1357LDGHipoteca_Internalname ;
   private String edtF1357LDGHipoteca_Jsonclick ;
   private String edtF1357LDGSGR_Internalname ;
   private String edtF1357LDGSGR_Jsonclick ;
   private String edtF1357LDGOtrasCaja_Internalname ;
   private String edtF1357LDGOtrasCaja_Jsonclick ;
   private String edtF1357LDGAlquiler_Internalname ;
   private String edtF1357LDGAlquiler_Jsonclick ;
   private String edtF1357LDGDomes_Internalname ;
   private String edtF1357LDGDomes_Jsonclick ;
   private String edtF1357LDGViaticos_Internalname ;
   private String edtF1357LDGViaticos_Jsonclick ;
   private String edtF1357LDGIndu_Internalname ;
   private String edtF1357LDGIndu_Jsonclick ;
   private String edtF1357LDGOtras_Internalname ;
   private String edtF1357LDGOtras_Jsonclick ;
   private String edtF1357LDGTotal_Internalname ;
   private String edtF1357LDGTotal_Jsonclick ;
   private String edtF1357LDGOtrasAnses_Internalname ;
   private String edtF1357LDGOtrasAnses_Jsonclick ;
   private String edtF1357LDGOtrasProf_Internalname ;
   private String edtF1357LDGOtrasProf_Jsonclick ;
   private String edtF1357LDGOtrasActores_Internalname ;
   private String edtF1357LDGOtrasActores_Jsonclick ;
   private String edtF1357LDGOtrasPrev_Internalname ;
   private String edtF1357LDGOtrasPrev_Jsonclick ;
   private String edtF1357LDGEducativos_Internalname ;
   private String edtF1357LDGEducativos_Jsonclick ;
   private String edtF1357LDGMovEmpl_Internalname ;
   private String edtF1357LDGMovEmpl_Jsonclick ;
   private String edtF1357LDGViaEmpl_Internalname ;
   private String edtF1357LDGViaEmpl_Jsonclick ;
   private String edtF1357LDGCompAna_Internalname ;
   private String edtF1357LDGCompAna_Jsonclick ;
   private String edtF1357LDGCompAnaCnt_Internalname ;
   private String edtF1357LDGCompAnaCnt_Jsonclick ;
   private String edtF1357LDGDescuentosLey_Internalname ;
   private String edtF1357LDGOtrDescuLey_Internalname ;
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
   private String sMode96 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ777F1357CPer ;
   private String ZZ863F1357LDGTipReg ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Gx_longc ;
   private String A825F1357LDGDescuentosLey ;
   private String A826F1357LDGOtrDescuLey ;
   private String Z825F1357LDGDescuentosLey ;
   private String Z826F1357LDGOtrDescuLey ;
   private String ZZ825F1357LDGDescuentosLey ;
   private String ZZ826F1357LDGOtrDescuLey ;
   private HTMLChoice cmbF1357CTipoPre ;
   private IDataStoreProvider pr_default ;
   private String[] T002I6_A863F1357LDGTipReg ;
   private java.math.BigDecimal[] T002I6_A802F1357LDGPrepaga ;
   private java.math.BigDecimal[] T002I6_A803F1357LDGSeguro ;
   private java.math.BigDecimal[] T002I6_A804F1357LDGSeguMixto ;
   private java.math.BigDecimal[] T002I6_A805F1357LDGRetPriv ;
   private java.math.BigDecimal[] T002I6_A806F1357LDGCuotapartes ;
   private java.math.BigDecimal[] T002I6_A807F1357LDGSepelio ;
   private java.math.BigDecimal[] T002I6_A808F1357LDGRodado ;
   private java.math.BigDecimal[] T002I6_A809F1357LDGDonaciones ;
   private java.math.BigDecimal[] T002I6_A810F1357LDGOblig ;
   private java.math.BigDecimal[] T002I6_A811F1357LDGMed ;
   private java.math.BigDecimal[] T002I6_A812F1357LDGHipoteca ;
   private java.math.BigDecimal[] T002I6_A813F1357LDGSGR ;
   private java.math.BigDecimal[] T002I6_A814F1357LDGOtrasCaja ;
   private java.math.BigDecimal[] T002I6_A815F1357LDGAlquiler ;
   private java.math.BigDecimal[] T002I6_A816F1357LDGDomes ;
   private java.math.BigDecimal[] T002I6_A817F1357LDGViaticos ;
   private java.math.BigDecimal[] T002I6_A818F1357LDGIndu ;
   private java.math.BigDecimal[] T002I6_A819F1357LDGOtras ;
   private java.math.BigDecimal[] T002I6_A820F1357LDGTotal ;
   private java.math.BigDecimal[] T002I6_A821F1357LDGOtrasAnses ;
   private java.math.BigDecimal[] T002I6_A822F1357LDGOtrasProf ;
   private java.math.BigDecimal[] T002I6_A823F1357LDGOtrasActores ;
   private java.math.BigDecimal[] T002I6_A824F1357LDGOtrasPrev ;
   private java.math.BigDecimal[] T002I6_A944F1357LDGEducativos ;
   private java.math.BigDecimal[] T002I6_A1213F1357LDGMovEmpl ;
   private java.math.BigDecimal[] T002I6_A1214F1357LDGViaEmpl ;
   private java.math.BigDecimal[] T002I6_A1215F1357LDGCompAna ;
   private byte[] T002I6_A1216F1357LDGCompAnaCnt ;
   private String[] T002I6_A825F1357LDGDescuentosLey ;
   private String[] T002I6_A826F1357LDGOtrDescuLey ;
   private int[] T002I6_A3CliCod ;
   private short[] T002I6_A1EmpCod ;
   private int[] T002I6_A6LegNumero ;
   private byte[] T002I6_A784F1357CTipoPre ;
   private String[] T002I6_A777F1357CPer ;
   private byte[] T002I6_A778F1357CSec ;
   private int[] T002I5_A3CliCod ;
   private int[] T002I4_A3CliCod ;
   private int[] T002I7_A3CliCod ;
   private int[] T002I8_A3CliCod ;
   private int[] T002I9_A3CliCod ;
   private short[] T002I9_A1EmpCod ;
   private byte[] T002I9_A784F1357CTipoPre ;
   private String[] T002I9_A777F1357CPer ;
   private byte[] T002I9_A778F1357CSec ;
   private int[] T002I9_A6LegNumero ;
   private String[] T002I9_A863F1357LDGTipReg ;
   private String[] T002I3_A863F1357LDGTipReg ;
   private java.math.BigDecimal[] T002I3_A802F1357LDGPrepaga ;
   private java.math.BigDecimal[] T002I3_A803F1357LDGSeguro ;
   private java.math.BigDecimal[] T002I3_A804F1357LDGSeguMixto ;
   private java.math.BigDecimal[] T002I3_A805F1357LDGRetPriv ;
   private java.math.BigDecimal[] T002I3_A806F1357LDGCuotapartes ;
   private java.math.BigDecimal[] T002I3_A807F1357LDGSepelio ;
   private java.math.BigDecimal[] T002I3_A808F1357LDGRodado ;
   private java.math.BigDecimal[] T002I3_A809F1357LDGDonaciones ;
   private java.math.BigDecimal[] T002I3_A810F1357LDGOblig ;
   private java.math.BigDecimal[] T002I3_A811F1357LDGMed ;
   private java.math.BigDecimal[] T002I3_A812F1357LDGHipoteca ;
   private java.math.BigDecimal[] T002I3_A813F1357LDGSGR ;
   private java.math.BigDecimal[] T002I3_A814F1357LDGOtrasCaja ;
   private java.math.BigDecimal[] T002I3_A815F1357LDGAlquiler ;
   private java.math.BigDecimal[] T002I3_A816F1357LDGDomes ;
   private java.math.BigDecimal[] T002I3_A817F1357LDGViaticos ;
   private java.math.BigDecimal[] T002I3_A818F1357LDGIndu ;
   private java.math.BigDecimal[] T002I3_A819F1357LDGOtras ;
   private java.math.BigDecimal[] T002I3_A820F1357LDGTotal ;
   private java.math.BigDecimal[] T002I3_A821F1357LDGOtrasAnses ;
   private java.math.BigDecimal[] T002I3_A822F1357LDGOtrasProf ;
   private java.math.BigDecimal[] T002I3_A823F1357LDGOtrasActores ;
   private java.math.BigDecimal[] T002I3_A824F1357LDGOtrasPrev ;
   private java.math.BigDecimal[] T002I3_A944F1357LDGEducativos ;
   private java.math.BigDecimal[] T002I3_A1213F1357LDGMovEmpl ;
   private java.math.BigDecimal[] T002I3_A1214F1357LDGViaEmpl ;
   private java.math.BigDecimal[] T002I3_A1215F1357LDGCompAna ;
   private byte[] T002I3_A1216F1357LDGCompAnaCnt ;
   private String[] T002I3_A825F1357LDGDescuentosLey ;
   private String[] T002I3_A826F1357LDGOtrDescuLey ;
   private int[] T002I3_A3CliCod ;
   private short[] T002I3_A1EmpCod ;
   private int[] T002I3_A6LegNumero ;
   private byte[] T002I3_A784F1357CTipoPre ;
   private String[] T002I3_A777F1357CPer ;
   private byte[] T002I3_A778F1357CSec ;
   private int[] T002I10_A3CliCod ;
   private short[] T002I10_A1EmpCod ;
   private byte[] T002I10_A784F1357CTipoPre ;
   private String[] T002I10_A777F1357CPer ;
   private byte[] T002I10_A778F1357CSec ;
   private int[] T002I10_A6LegNumero ;
   private String[] T002I10_A863F1357LDGTipReg ;
   private int[] T002I11_A3CliCod ;
   private short[] T002I11_A1EmpCod ;
   private byte[] T002I11_A784F1357CTipoPre ;
   private String[] T002I11_A777F1357CPer ;
   private byte[] T002I11_A778F1357CSec ;
   private int[] T002I11_A6LegNumero ;
   private String[] T002I11_A863F1357LDGTipReg ;
   private String[] T002I2_A863F1357LDGTipReg ;
   private java.math.BigDecimal[] T002I2_A802F1357LDGPrepaga ;
   private java.math.BigDecimal[] T002I2_A803F1357LDGSeguro ;
   private java.math.BigDecimal[] T002I2_A804F1357LDGSeguMixto ;
   private java.math.BigDecimal[] T002I2_A805F1357LDGRetPriv ;
   private java.math.BigDecimal[] T002I2_A806F1357LDGCuotapartes ;
   private java.math.BigDecimal[] T002I2_A807F1357LDGSepelio ;
   private java.math.BigDecimal[] T002I2_A808F1357LDGRodado ;
   private java.math.BigDecimal[] T002I2_A809F1357LDGDonaciones ;
   private java.math.BigDecimal[] T002I2_A810F1357LDGOblig ;
   private java.math.BigDecimal[] T002I2_A811F1357LDGMed ;
   private java.math.BigDecimal[] T002I2_A812F1357LDGHipoteca ;
   private java.math.BigDecimal[] T002I2_A813F1357LDGSGR ;
   private java.math.BigDecimal[] T002I2_A814F1357LDGOtrasCaja ;
   private java.math.BigDecimal[] T002I2_A815F1357LDGAlquiler ;
   private java.math.BigDecimal[] T002I2_A816F1357LDGDomes ;
   private java.math.BigDecimal[] T002I2_A817F1357LDGViaticos ;
   private java.math.BigDecimal[] T002I2_A818F1357LDGIndu ;
   private java.math.BigDecimal[] T002I2_A819F1357LDGOtras ;
   private java.math.BigDecimal[] T002I2_A820F1357LDGTotal ;
   private java.math.BigDecimal[] T002I2_A821F1357LDGOtrasAnses ;
   private java.math.BigDecimal[] T002I2_A822F1357LDGOtrasProf ;
   private java.math.BigDecimal[] T002I2_A823F1357LDGOtrasActores ;
   private java.math.BigDecimal[] T002I2_A824F1357LDGOtrasPrev ;
   private java.math.BigDecimal[] T002I2_A944F1357LDGEducativos ;
   private java.math.BigDecimal[] T002I2_A1213F1357LDGMovEmpl ;
   private java.math.BigDecimal[] T002I2_A1214F1357LDGViaEmpl ;
   private java.math.BigDecimal[] T002I2_A1215F1357LDGCompAna ;
   private byte[] T002I2_A1216F1357LDGCompAnaCnt ;
   private String[] T002I2_A825F1357LDGDescuentosLey ;
   private String[] T002I2_A826F1357LDGOtrDescuLey ;
   private int[] T002I2_A3CliCod ;
   private short[] T002I2_A1EmpCod ;
   private int[] T002I2_A6LegNumero ;
   private byte[] T002I2_A784F1357CTipoPre ;
   private String[] T002I2_A777F1357CPer ;
   private byte[] T002I2_A778F1357CSec ;
   private int[] T002I15_A3CliCod ;
   private short[] T002I15_A1EmpCod ;
   private byte[] T002I15_A784F1357CTipoPre ;
   private String[] T002I15_A777F1357CPer ;
   private byte[] T002I15_A778F1357CSec ;
   private int[] T002I15_A6LegNumero ;
   private String[] T002I15_A863F1357LDGTipReg ;
   private int[] T002I16_A3CliCod ;
   private int[] T002I17_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class f1357legdedgen__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T002I2", "SELECT F1357LDGTipReg, F1357LDGPrepaga, F1357LDGSeguro, F1357LDGSeguMixto, F1357LDGRetPriv, F1357LDGCuotapartes, F1357LDGSepelio, F1357LDGRodado, F1357LDGDonaciones, F1357LDGOblig, F1357LDGMed, F1357LDGHipoteca, F1357LDGSGR, F1357LDGOtrasCaja, F1357LDGAlquiler, F1357LDGDomes, F1357LDGViaticos, F1357LDGIndu, F1357LDGOtras, F1357LDGTotal, F1357LDGOtrasAnses, F1357LDGOtrasProf, F1357LDGOtrasActores, F1357LDGOtrasPrev, F1357LDGEducativos, F1357LDGMovEmpl, F1357LDGViaEmpl, F1357LDGCompAna, F1357LDGCompAnaCnt, F1357LDGDescuentosLey, F1357LDGOtrDescuLey, CliCod, EmpCod, LegNumero, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357LegDedGen WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LDGTipReg = ?  FOR UPDATE OF F1357LegDedGen NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002I3", "SELECT F1357LDGTipReg, F1357LDGPrepaga, F1357LDGSeguro, F1357LDGSeguMixto, F1357LDGRetPriv, F1357LDGCuotapartes, F1357LDGSepelio, F1357LDGRodado, F1357LDGDonaciones, F1357LDGOblig, F1357LDGMed, F1357LDGHipoteca, F1357LDGSGR, F1357LDGOtrasCaja, F1357LDGAlquiler, F1357LDGDomes, F1357LDGViaticos, F1357LDGIndu, F1357LDGOtras, F1357LDGTotal, F1357LDGOtrasAnses, F1357LDGOtrasProf, F1357LDGOtrasActores, F1357LDGOtrasPrev, F1357LDGEducativos, F1357LDGMovEmpl, F1357LDGViaEmpl, F1357LDGCompAna, F1357LDGCompAnaCnt, F1357LDGDescuentosLey, F1357LDGOtrDescuLey, CliCod, EmpCod, LegNumero, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357LegDedGen WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LDGTipReg = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002I4", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002I5", "SELECT CliCod FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002I6", "SELECT TM1.F1357LDGTipReg, TM1.F1357LDGPrepaga, TM1.F1357LDGSeguro, TM1.F1357LDGSeguMixto, TM1.F1357LDGRetPriv, TM1.F1357LDGCuotapartes, TM1.F1357LDGSepelio, TM1.F1357LDGRodado, TM1.F1357LDGDonaciones, TM1.F1357LDGOblig, TM1.F1357LDGMed, TM1.F1357LDGHipoteca, TM1.F1357LDGSGR, TM1.F1357LDGOtrasCaja, TM1.F1357LDGAlquiler, TM1.F1357LDGDomes, TM1.F1357LDGViaticos, TM1.F1357LDGIndu, TM1.F1357LDGOtras, TM1.F1357LDGTotal, TM1.F1357LDGOtrasAnses, TM1.F1357LDGOtrasProf, TM1.F1357LDGOtrasActores, TM1.F1357LDGOtrasPrev, TM1.F1357LDGEducativos, TM1.F1357LDGMovEmpl, TM1.F1357LDGViaEmpl, TM1.F1357LDGCompAna, TM1.F1357LDGCompAnaCnt, TM1.F1357LDGDescuentosLey, TM1.F1357LDGOtrDescuLey, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.F1357CTipoPre, TM1.F1357CPer, TM1.F1357CSec FROM F1357LegDedGen TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.F1357CTipoPre = ? and TM1.F1357CPer = ( ?) and TM1.F1357CSec = ? and TM1.LegNumero = ? and TM1.F1357LDGTipReg = ( ?) ORDER BY TM1.CliCod, TM1.EmpCod, TM1.F1357CTipoPre, TM1.F1357CPer, TM1.F1357CSec, TM1.LegNumero, TM1.F1357LDGTipReg ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002I7", "SELECT CliCod FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002I8", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002I9", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDGTipReg FROM F1357LegDedGen WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LDGTipReg = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002I10", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDGTipReg FROM F1357LegDedGen WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and F1357CTipoPre > ? or F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CPer > ( ?) or F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CSec > ? or F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and LegNumero > ? or LegNumero = ? and F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357LDGTipReg > ( ?)) ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDGTipReg  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002I11", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDGTipReg FROM F1357LegDedGen WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and F1357CTipoPre < ? or F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CPer < ( ?) or F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357CSec < ? or F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and LegNumero < ? or LegNumero = ? and F1357CSec = ? and F1357CPer = ( ?) and F1357CTipoPre = ? and EmpCod = ? and CliCod = ? and F1357LDGTipReg < ( ?)) ORDER BY CliCod DESC, EmpCod DESC, F1357CTipoPre DESC, F1357CPer DESC, F1357CSec DESC, LegNumero DESC, F1357LDGTipReg DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T002I12", "SAVEPOINT gxupdate;INSERT INTO F1357LegDedGen(F1357LDGTipReg, F1357LDGPrepaga, F1357LDGSeguro, F1357LDGSeguMixto, F1357LDGRetPriv, F1357LDGCuotapartes, F1357LDGSepelio, F1357LDGRodado, F1357LDGDonaciones, F1357LDGOblig, F1357LDGMed, F1357LDGHipoteca, F1357LDGSGR, F1357LDGOtrasCaja, F1357LDGAlquiler, F1357LDGDomes, F1357LDGViaticos, F1357LDGIndu, F1357LDGOtras, F1357LDGTotal, F1357LDGOtrasAnses, F1357LDGOtrasProf, F1357LDGOtrasActores, F1357LDGOtrasPrev, F1357LDGEducativos, F1357LDGMovEmpl, F1357LDGViaEmpl, F1357LDGCompAna, F1357LDGCompAnaCnt, F1357LDGDescuentosLey, F1357LDGOtrDescuLey, CliCod, EmpCod, LegNumero, F1357CTipoPre, F1357CPer, F1357CSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002I13", "SAVEPOINT gxupdate;UPDATE F1357LegDedGen SET F1357LDGPrepaga=?, F1357LDGSeguro=?, F1357LDGSeguMixto=?, F1357LDGRetPriv=?, F1357LDGCuotapartes=?, F1357LDGSepelio=?, F1357LDGRodado=?, F1357LDGDonaciones=?, F1357LDGOblig=?, F1357LDGMed=?, F1357LDGHipoteca=?, F1357LDGSGR=?, F1357LDGOtrasCaja=?, F1357LDGAlquiler=?, F1357LDGDomes=?, F1357LDGViaticos=?, F1357LDGIndu=?, F1357LDGOtras=?, F1357LDGTotal=?, F1357LDGOtrasAnses=?, F1357LDGOtrasProf=?, F1357LDGOtrasActores=?, F1357LDGOtrasPrev=?, F1357LDGEducativos=?, F1357LDGMovEmpl=?, F1357LDGViaEmpl=?, F1357LDGCompAna=?, F1357LDGCompAnaCnt=?, F1357LDGDescuentosLey=?, F1357LDGOtrDescuLey=?  WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LDGTipReg = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002I14", "SAVEPOINT gxupdate;DELETE FROM F1357LegDedGen  WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? AND LegNumero = ? AND F1357LDGTipReg = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002I15", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDGTipReg FROM F1357LegDedGen ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDGTipReg ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002I16", "SELECT CliCod FROM F1357Cab WHERE CliCod = ? AND EmpCod = ? AND F1357CTipoPre = ? AND F1357CPer = ? AND F1357CSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002I17", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,2);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,2);
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(25,2);
               ((java.math.BigDecimal[]) buf[25])[0] = rslt.getBigDecimal(26,2);
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(27,2);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(28,2);
               ((byte[]) buf[28])[0] = rslt.getByte(29);
               ((String[]) buf[29])[0] = rslt.getLongVarchar(30);
               ((String[]) buf[30])[0] = rslt.getLongVarchar(31);
               ((int[]) buf[31])[0] = rslt.getInt(32);
               ((short[]) buf[32])[0] = rslt.getShort(33);
               ((int[]) buf[33])[0] = rslt.getInt(34);
               ((byte[]) buf[34])[0] = rslt.getByte(35);
               ((String[]) buf[35])[0] = rslt.getString(36, 6);
               ((byte[]) buf[36])[0] = rslt.getByte(37);
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
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,2);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,2);
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(25,2);
               ((java.math.BigDecimal[]) buf[25])[0] = rslt.getBigDecimal(26,2);
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(27,2);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(28,2);
               ((byte[]) buf[28])[0] = rslt.getByte(29);
               ((String[]) buf[29])[0] = rslt.getLongVarchar(30);
               ((String[]) buf[30])[0] = rslt.getLongVarchar(31);
               ((int[]) buf[31])[0] = rslt.getInt(32);
               ((short[]) buf[32])[0] = rslt.getShort(33);
               ((int[]) buf[33])[0] = rslt.getInt(34);
               ((byte[]) buf[34])[0] = rslt.getByte(35);
               ((String[]) buf[35])[0] = rslt.getString(36, 6);
               ((byte[]) buf[36])[0] = rslt.getByte(37);
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
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,2);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,2);
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(25,2);
               ((java.math.BigDecimal[]) buf[25])[0] = rslt.getBigDecimal(26,2);
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(27,2);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(28,2);
               ((byte[]) buf[28])[0] = rslt.getByte(29);
               ((String[]) buf[29])[0] = rslt.getLongVarchar(30);
               ((String[]) buf[30])[0] = rslt.getLongVarchar(31);
               ((int[]) buf[31])[0] = rslt.getInt(32);
               ((short[]) buf[32])[0] = rslt.getShort(33);
               ((int[]) buf[33])[0] = rslt.getInt(34);
               ((byte[]) buf[34])[0] = rslt.getByte(35);
               ((String[]) buf[35])[0] = rslt.getString(36, 6);
               ((byte[]) buf[36])[0] = rslt.getByte(37);
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
               stmt.setBigDecimal(22, (java.math.BigDecimal)parms[21], 2);
               stmt.setBigDecimal(23, (java.math.BigDecimal)parms[22], 2);
               stmt.setBigDecimal(24, (java.math.BigDecimal)parms[23], 2);
               stmt.setBigDecimal(25, (java.math.BigDecimal)parms[24], 2);
               stmt.setBigDecimal(26, (java.math.BigDecimal)parms[25], 2);
               stmt.setBigDecimal(27, (java.math.BigDecimal)parms[26], 2);
               stmt.setBigDecimal(28, (java.math.BigDecimal)parms[27], 2);
               stmt.setByte(29, ((Number) parms[28]).byteValue());
               stmt.setNLongVarchar(30, (String)parms[29], false);
               stmt.setNLongVarchar(31, (String)parms[30], false);
               stmt.setInt(32, ((Number) parms[31]).intValue());
               stmt.setShort(33, ((Number) parms[32]).shortValue());
               stmt.setInt(34, ((Number) parms[33]).intValue());
               stmt.setByte(35, ((Number) parms[34]).byteValue());
               stmt.setString(36, (String)parms[35], 6);
               stmt.setByte(37, ((Number) parms[36]).byteValue());
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
               stmt.setBigDecimal(21, (java.math.BigDecimal)parms[20], 2);
               stmt.setBigDecimal(22, (java.math.BigDecimal)parms[21], 2);
               stmt.setBigDecimal(23, (java.math.BigDecimal)parms[22], 2);
               stmt.setBigDecimal(24, (java.math.BigDecimal)parms[23], 2);
               stmt.setBigDecimal(25, (java.math.BigDecimal)parms[24], 2);
               stmt.setBigDecimal(26, (java.math.BigDecimal)parms[25], 2);
               stmt.setBigDecimal(27, (java.math.BigDecimal)parms[26], 2);
               stmt.setByte(28, ((Number) parms[27]).byteValue());
               stmt.setNLongVarchar(29, (String)parms[28], false);
               stmt.setNLongVarchar(30, (String)parms[29], false);
               stmt.setInt(31, ((Number) parms[30]).intValue());
               stmt.setShort(32, ((Number) parms[31]).shortValue());
               stmt.setByte(33, ((Number) parms[32]).byteValue());
               stmt.setString(34, (String)parms[33], 6);
               stmt.setByte(35, ((Number) parms[34]).byteValue());
               stmt.setInt(36, ((Number) parms[35]).intValue());
               stmt.setString(37, (String)parms[36], 2);
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

