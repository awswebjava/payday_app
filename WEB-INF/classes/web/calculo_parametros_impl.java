package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class calculo_parametros_impl extends GXDataArea
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
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A74idOperando = httpContext.GetPar( "idOperando") ;
         httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_3( A46PaiCod, A74idOperando) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Calculo_parametros", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public calculo_parametros_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public calculo_parametros_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculo_parametros_impl.class ));
   }

   public calculo_parametros_impl( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbidOperando = new HTMLChoice();
      cmbCalParId = new HTMLChoice();
      chkCalParObl = UIFactory.getCheckbox(this);
      chkCalParSugGen = UIFactory.getCheckbox(this);
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
      if ( cmbidOperando.getItemCount() > 0 )
      {
         A74idOperando = cmbidOperando.getValidValue(A74idOperando) ;
         httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbidOperando.setValue( GXutil.rtrim( A74idOperando) );
         httpContext.ajax_rsp_assign_prop("", false, cmbidOperando.getInternalname(), "Values", cmbidOperando.ToJavascriptSource(), true);
      }
      if ( cmbCalParId.getItemCount() > 0 )
      {
         A2098CalParId = cmbCalParId.getValidValue(A2098CalParId) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2098CalParId", A2098CalParId);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCalParId.setValue( GXutil.rtrim( A2098CalParId) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCalParId.getInternalname(), "Values", cmbCalParId.ToJavascriptSource(), true);
      }
      A2106CalParObl = GXutil.strtobool( GXutil.booltostr( A2106CalParObl)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2106CalParObl", A2106CalParObl);
      A2141CalParSugGen = GXutil.strtobool( GXutil.booltostr( A2141CalParSugGen)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2141CalParSugGen", A2141CalParSugGen);
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "Calculo_parametros", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Calculo_parametros.htm");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_Calculo_parametros.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaiCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtPaiCod_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPaiCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaiCod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbidOperando.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbidOperando.getInternalname(), httpContext.getMessage( "id Operando", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbidOperando, cmbidOperando.getInternalname(), GXutil.rtrim( A74idOperando), 1, cmbidOperando.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbidOperando.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "", true, (byte)(0), "HLP_Calculo_parametros.htm");
      cmbidOperando.setValue( GXutil.rtrim( A74idOperando) );
      httpContext.ajax_rsp_assign_prop("", false, cmbidOperando.getInternalname(), "Values", cmbidOperando.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbCalParId.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbCalParId.getInternalname(), httpContext.getMessage( "Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbCalParId, cmbCalParId.getInternalname(), GXutil.rtrim( A2098CalParId), 1, cmbCalParId.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbCalParId.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", "", true, (byte)(0), "HLP_Calculo_parametros.htm");
      cmbCalParId.setValue( GXutil.rtrim( A2098CalParId) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCalParId.getInternalname(), "Values", cmbCalParId.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCalParCampo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCalParCampo_Internalname, httpContext.getMessage( "Tabla y campo o expresión regular", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtCalParCampo_Internalname, A2099CalParCampo, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", (short)(0), 1, edtCalParCampo_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCalParValLista_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCalParValLista_Internalname, httpContext.getMessage( "Lista de valores válidos", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtCalParValLista_Internalname, A2111CalParValLista, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", (short)(0), 1, edtCalParValLista_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "4000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCalParEjemplo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCalParEjemplo_Internalname, httpContext.getMessage( "Ejemplo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtCalParEjemplo_Internalname, A2108CalParEjemplo, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", (short)(1), 1, edtCalParEjemplo_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCalParEjemExpli_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCalParEjemExpli_Internalname, httpContext.getMessage( "Explicación de ejemplo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtCalParEjemExpli_Internalname, A2109CalParEjemExpli, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", (short)(0), 1, edtCalParEjemExpli_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCalParGrp_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCalParGrp_Internalname, httpContext.getMessage( "Grupo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCalParGrp_Internalname, GXutil.ltrim( localUtil.ntoc( A2104CalParGrp, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCalParGrp_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2104CalParGrp), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A2104CalParGrp), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCalParGrp_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCalParGrp_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCalParGrpDep_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCalParGrpDep_Internalname, httpContext.getMessage( "Dependencia grupo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCalParGrpDep_Internalname, GXutil.ltrim( localUtil.ntoc( A2105CalParGrpDep, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCalParGrpDep_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2105CalParGrpDep), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A2105CalParGrpDep), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCalParGrpDep_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCalParGrpDep_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCalParObl.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkCalParObl.getInternalname(), httpContext.getMessage( "Obligatorio", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCalParObl.getInternalname(), GXutil.booltostr( A2106CalParObl), "", httpContext.getMessage( "Obligatorio", ""), 1, chkCalParObl.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(79, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,79);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCalParDef_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCalParDef_Internalname, httpContext.getMessage( "Valor por omisión", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCalParDef_Internalname, GXutil.rtrim( A2107CalParDef), GXutil.rtrim( localUtil.format( A2107CalParDef, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,84);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCalParDef_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCalParDef_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "palabra", "left", true, "", "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCalParNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCalParNombre_Internalname, httpContext.getMessage( "Nombre", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtCalParNombre_Internalname, A2110CalParNombre, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,89);\"", (short)(0), 1, edtCalParNombre_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCalParDesc_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCalParDesc_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtCalParDesc_Internalname, A2100CalParDesc, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,94);\"", (short)(0), 1, edtCalParDesc_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "Descrip", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCalParDetail_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCalParDetail_Internalname, httpContext.getMessage( "Detalle", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtCalParDetail_Internalname, A2137CalParDetail, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,99);\"", (short)(0), 1, edtCalParDetail_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCalParDoc_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCalParDoc_Internalname, httpContext.getMessage( "Documentación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtCalParDoc_Internalname, A2135CalParDoc, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,104);\"", (short)(0), 1, edtCalParDoc_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCalParDummy_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCalParDummy_Internalname, httpContext.getMessage( "Valor dummy para ejemplo de parámetro", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCalParDummy_Internalname, A2136CalParDummy, GXutil.rtrim( localUtil.format( A2136CalParDummy, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,109);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCalParDummy_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCalParDummy_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCalParSugGen.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkCalParSugGen.getInternalname(), httpContext.getMessage( "Sugerir valor genérico en fórmulas", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 114,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCalParSugGen.getInternalname(), GXutil.booltostr( A2141CalParSugGen), "", httpContext.getMessage( "Sugerir valor genérico en fórmulas", ""), 1, chkCalParSugGen.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(114, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,114);\"");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 119,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 121,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Calculo_parametros.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 123,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Calculo_parametros.htm");
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
         Z46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z74idOperando = httpContext.cgiGet( "Z74idOperando") ;
         Z2098CalParId = httpContext.cgiGet( "Z2098CalParId") ;
         Z2099CalParCampo = httpContext.cgiGet( "Z2099CalParCampo") ;
         Z2111CalParValLista = httpContext.cgiGet( "Z2111CalParValLista") ;
         Z2108CalParEjemplo = httpContext.cgiGet( "Z2108CalParEjemplo") ;
         Z2104CalParGrp = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2104CalParGrp"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z2105CalParGrpDep = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2105CalParGrpDep"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z2106CalParObl = GXutil.strtobool( httpContext.cgiGet( "Z2106CalParObl")) ;
         Z2107CalParDef = httpContext.cgiGet( "Z2107CalParDef") ;
         Z2110CalParNombre = httpContext.cgiGet( "Z2110CalParNombre") ;
         Z2100CalParDesc = httpContext.cgiGet( "Z2100CalParDesc") ;
         Z2137CalParDetail = httpContext.cgiGet( "Z2137CalParDetail") ;
         Z2136CalParDummy = httpContext.cgiGet( "Z2136CalParDummy") ;
         Z2141CalParSugGen = GXutil.strtobool( httpContext.cgiGet( "Z2141CalParSugGen")) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAICOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPaiCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A46PaiCod = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         }
         else
         {
            A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         }
         cmbidOperando.setValue( httpContext.cgiGet( cmbidOperando.getInternalname()) );
         A74idOperando = httpContext.cgiGet( cmbidOperando.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
         cmbCalParId.setValue( httpContext.cgiGet( cmbCalParId.getInternalname()) );
         A2098CalParId = httpContext.cgiGet( cmbCalParId.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2098CalParId", A2098CalParId);
         A2099CalParCampo = httpContext.cgiGet( edtCalParCampo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2099CalParCampo", A2099CalParCampo);
         A2111CalParValLista = httpContext.cgiGet( edtCalParValLista_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2111CalParValLista", A2111CalParValLista);
         A2108CalParEjemplo = httpContext.cgiGet( edtCalParEjemplo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2108CalParEjemplo", A2108CalParEjemplo);
         A2109CalParEjemExpli = httpContext.cgiGet( edtCalParEjemExpli_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2109CalParEjemExpli", A2109CalParEjemExpli);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCalParGrp_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCalParGrp_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CALPARGRP");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCalParGrp_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A2104CalParGrp = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2104CalParGrp", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2104CalParGrp), 2, 0));
         }
         else
         {
            A2104CalParGrp = (byte)(localUtil.ctol( httpContext.cgiGet( edtCalParGrp_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2104CalParGrp", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2104CalParGrp), 2, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCalParGrpDep_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCalParGrpDep_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CALPARGRPDEP");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCalParGrpDep_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A2105CalParGrpDep = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2105CalParGrpDep", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2105CalParGrpDep), 2, 0));
         }
         else
         {
            A2105CalParGrpDep = (byte)(localUtil.ctol( httpContext.cgiGet( edtCalParGrpDep_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2105CalParGrpDep", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2105CalParGrpDep), 2, 0));
         }
         A2106CalParObl = GXutil.strtobool( httpContext.cgiGet( chkCalParObl.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2106CalParObl", A2106CalParObl);
         A2107CalParDef = httpContext.cgiGet( edtCalParDef_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2107CalParDef", A2107CalParDef);
         A2110CalParNombre = httpContext.cgiGet( edtCalParNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2110CalParNombre", A2110CalParNombre);
         A2100CalParDesc = httpContext.cgiGet( edtCalParDesc_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2100CalParDesc", A2100CalParDesc);
         A2137CalParDetail = httpContext.cgiGet( edtCalParDetail_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2137CalParDetail", A2137CalParDetail);
         A2135CalParDoc = httpContext.cgiGet( edtCalParDoc_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2135CalParDoc", A2135CalParDoc);
         A2136CalParDummy = httpContext.cgiGet( edtCalParDummy_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2136CalParDummy", A2136CalParDummy);
         A2141CalParSugGen = GXutil.strtobool( httpContext.cgiGet( chkCalParSugGen.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2141CalParSugGen", A2141CalParSugGen);
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
            A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A74idOperando = httpContext.GetPar( "idOperando") ;
            httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
            A2098CalParId = httpContext.GetPar( "CalParId") ;
            httpContext.ajax_rsp_assign_attri("", false, "A2098CalParId", A2098CalParId);
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
            initAll62265( ) ;
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
      disableAttributes62265( ) ;
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

   public void resetCaption620( )
   {
   }

   public void zm62265( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2099CalParCampo = T00623_A2099CalParCampo[0] ;
            Z2111CalParValLista = T00623_A2111CalParValLista[0] ;
            Z2108CalParEjemplo = T00623_A2108CalParEjemplo[0] ;
            Z2104CalParGrp = T00623_A2104CalParGrp[0] ;
            Z2105CalParGrpDep = T00623_A2105CalParGrpDep[0] ;
            Z2106CalParObl = T00623_A2106CalParObl[0] ;
            Z2107CalParDef = T00623_A2107CalParDef[0] ;
            Z2110CalParNombre = T00623_A2110CalParNombre[0] ;
            Z2100CalParDesc = T00623_A2100CalParDesc[0] ;
            Z2137CalParDetail = T00623_A2137CalParDetail[0] ;
            Z2136CalParDummy = T00623_A2136CalParDummy[0] ;
            Z2141CalParSugGen = T00623_A2141CalParSugGen[0] ;
         }
         else
         {
            Z2099CalParCampo = A2099CalParCampo ;
            Z2111CalParValLista = A2111CalParValLista ;
            Z2108CalParEjemplo = A2108CalParEjemplo ;
            Z2104CalParGrp = A2104CalParGrp ;
            Z2105CalParGrpDep = A2105CalParGrpDep ;
            Z2106CalParObl = A2106CalParObl ;
            Z2107CalParDef = A2107CalParDef ;
            Z2110CalParNombre = A2110CalParNombre ;
            Z2100CalParDesc = A2100CalParDesc ;
            Z2137CalParDetail = A2137CalParDetail ;
            Z2136CalParDummy = A2136CalParDummy ;
            Z2141CalParSugGen = A2141CalParSugGen ;
         }
      }
      if ( GX_JID == -2 )
      {
         Z2098CalParId = A2098CalParId ;
         Z2099CalParCampo = A2099CalParCampo ;
         Z2111CalParValLista = A2111CalParValLista ;
         Z2108CalParEjemplo = A2108CalParEjemplo ;
         Z2109CalParEjemExpli = A2109CalParEjemExpli ;
         Z2104CalParGrp = A2104CalParGrp ;
         Z2105CalParGrpDep = A2105CalParGrpDep ;
         Z2106CalParObl = A2106CalParObl ;
         Z2107CalParDef = A2107CalParDef ;
         Z2110CalParNombre = A2110CalParNombre ;
         Z2100CalParDesc = A2100CalParDesc ;
         Z2137CalParDetail = A2137CalParDetail ;
         Z2135CalParDoc = A2135CalParDoc ;
         Z2136CalParDummy = A2136CalParDummy ;
         Z2141CalParSugGen = A2141CalParSugGen ;
         Z46PaiCod = A46PaiCod ;
         Z74idOperando = A74idOperando ;
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

   public void load62265( )
   {
      /* Using cursor T00625 */
      pr_default.execute(3, new Object[] {Short.valueOf(A46PaiCod), A74idOperando, A2098CalParId});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound265 = (short)(1) ;
         A2099CalParCampo = T00625_A2099CalParCampo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2099CalParCampo", A2099CalParCampo);
         A2111CalParValLista = T00625_A2111CalParValLista[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2111CalParValLista", A2111CalParValLista);
         A2108CalParEjemplo = T00625_A2108CalParEjemplo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2108CalParEjemplo", A2108CalParEjemplo);
         A2109CalParEjemExpli = T00625_A2109CalParEjemExpli[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2109CalParEjemExpli", A2109CalParEjemExpli);
         A2104CalParGrp = T00625_A2104CalParGrp[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2104CalParGrp", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2104CalParGrp), 2, 0));
         A2105CalParGrpDep = T00625_A2105CalParGrpDep[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2105CalParGrpDep", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2105CalParGrpDep), 2, 0));
         A2106CalParObl = T00625_A2106CalParObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2106CalParObl", A2106CalParObl);
         A2107CalParDef = T00625_A2107CalParDef[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2107CalParDef", A2107CalParDef);
         A2110CalParNombre = T00625_A2110CalParNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2110CalParNombre", A2110CalParNombre);
         A2100CalParDesc = T00625_A2100CalParDesc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2100CalParDesc", A2100CalParDesc);
         A2137CalParDetail = T00625_A2137CalParDetail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2137CalParDetail", A2137CalParDetail);
         A2135CalParDoc = T00625_A2135CalParDoc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2135CalParDoc", A2135CalParDoc);
         A2136CalParDummy = T00625_A2136CalParDummy[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2136CalParDummy", A2136CalParDummy);
         A2141CalParSugGen = T00625_A2141CalParSugGen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2141CalParSugGen", A2141CalParSugGen);
         zm62265( -2) ;
      }
      pr_default.close(3);
      onLoadActions62265( ) ;
   }

   public void onLoadActions62265( )
   {
   }

   public void checkExtendedTable62265( )
   {
      nIsDirty_265 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T00624 */
      pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod), A74idOperando});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "calculo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IDOPERANDO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( GXutil.strcmp(A2098CalParId, "Devolver") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Calculo") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Periodo") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Concepto") == 0 ) || ( GXutil.strcmp(A2098CalParId, "TipoLiq") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Adicional") == 0 ) || ( GXutil.strcmp(A2098CalParId, "AdicionalOpcion") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Area") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Categoria") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Clase") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Convenio") == 0 ) || ( GXutil.strcmp(A2098CalParId, "MotivoEgreso") == 0 ) || ( GXutil.strcmp(A2098CalParId, "ObraSocial") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Sexo") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Sindicato") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Tipo de trabajo") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Dia") == 0 ) || ( GXutil.strcmp(A2098CalParId, "TipoObligacion") == 0 ) || ( GXutil.strcmp(A2098CalParId, "AplIIGG") == 0 ) || ( GXutil.strcmp(A2098CalParId, "TipoDeConcepto") == 0 ) || ( GXutil.strcmp(A2098CalParId, "SueldoBasico") == 0 ) || ( GXutil.strcmp(A2098CalParId, "PropiedadAdicional") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Id", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CALPARID");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbCalParId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors62265( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_3( short A46PaiCod ,
                         String A74idOperando )
   {
      /* Using cursor T00626 */
      pr_default.execute(4, new Object[] {Short.valueOf(A46PaiCod), A74idOperando});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "calculo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IDOPERANDO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
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

   public void getKey62265( )
   {
      /* Using cursor T00627 */
      pr_default.execute(5, new Object[] {Short.valueOf(A46PaiCod), A74idOperando, A2098CalParId});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound265 = (short)(1) ;
      }
      else
      {
         RcdFound265 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00623 */
      pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), A74idOperando, A2098CalParId});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm62265( 2) ;
         RcdFound265 = (short)(1) ;
         A2098CalParId = T00623_A2098CalParId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2098CalParId", A2098CalParId);
         A2099CalParCampo = T00623_A2099CalParCampo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2099CalParCampo", A2099CalParCampo);
         A2111CalParValLista = T00623_A2111CalParValLista[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2111CalParValLista", A2111CalParValLista);
         A2108CalParEjemplo = T00623_A2108CalParEjemplo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2108CalParEjemplo", A2108CalParEjemplo);
         A2109CalParEjemExpli = T00623_A2109CalParEjemExpli[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2109CalParEjemExpli", A2109CalParEjemExpli);
         A2104CalParGrp = T00623_A2104CalParGrp[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2104CalParGrp", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2104CalParGrp), 2, 0));
         A2105CalParGrpDep = T00623_A2105CalParGrpDep[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2105CalParGrpDep", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2105CalParGrpDep), 2, 0));
         A2106CalParObl = T00623_A2106CalParObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2106CalParObl", A2106CalParObl);
         A2107CalParDef = T00623_A2107CalParDef[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2107CalParDef", A2107CalParDef);
         A2110CalParNombre = T00623_A2110CalParNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2110CalParNombre", A2110CalParNombre);
         A2100CalParDesc = T00623_A2100CalParDesc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2100CalParDesc", A2100CalParDesc);
         A2137CalParDetail = T00623_A2137CalParDetail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2137CalParDetail", A2137CalParDetail);
         A2135CalParDoc = T00623_A2135CalParDoc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2135CalParDoc", A2135CalParDoc);
         A2136CalParDummy = T00623_A2136CalParDummy[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2136CalParDummy", A2136CalParDummy);
         A2141CalParSugGen = T00623_A2141CalParSugGen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2141CalParSugGen", A2141CalParSugGen);
         A46PaiCod = T00623_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A74idOperando = T00623_A74idOperando[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
         Z46PaiCod = A46PaiCod ;
         Z74idOperando = A74idOperando ;
         Z2098CalParId = A2098CalParId ;
         sMode265 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load62265( ) ;
         if ( AnyError == 1 )
         {
            RcdFound265 = (short)(0) ;
            initializeNonKey62265( ) ;
         }
         Gx_mode = sMode265 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound265 = (short)(0) ;
         initializeNonKey62265( ) ;
         sMode265 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode265 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey62265( ) ;
      if ( RcdFound265 == 0 )
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
      RcdFound265 = (short)(0) ;
      /* Using cursor T00628 */
      pr_default.execute(6, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), A74idOperando, A74idOperando, Short.valueOf(A46PaiCod), A2098CalParId});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00628_A46PaiCod[0] < A46PaiCod ) || ( T00628_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T00628_A74idOperando[0], A74idOperando) < 0 ) || ( GXutil.strcmp(T00628_A74idOperando[0], A74idOperando) == 0 ) && ( T00628_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T00628_A2098CalParId[0], A2098CalParId) < 0 ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00628_A46PaiCod[0] > A46PaiCod ) || ( T00628_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T00628_A74idOperando[0], A74idOperando) > 0 ) || ( GXutil.strcmp(T00628_A74idOperando[0], A74idOperando) == 0 ) && ( T00628_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T00628_A2098CalParId[0], A2098CalParId) > 0 ) ) )
         {
            A46PaiCod = T00628_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A74idOperando = T00628_A74idOperando[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
            A2098CalParId = T00628_A2098CalParId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2098CalParId", A2098CalParId);
            RcdFound265 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound265 = (short)(0) ;
      /* Using cursor T00629 */
      pr_default.execute(7, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), A74idOperando, A74idOperando, Short.valueOf(A46PaiCod), A2098CalParId});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00629_A46PaiCod[0] > A46PaiCod ) || ( T00629_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T00629_A74idOperando[0], A74idOperando) > 0 ) || ( GXutil.strcmp(T00629_A74idOperando[0], A74idOperando) == 0 ) && ( T00629_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T00629_A2098CalParId[0], A2098CalParId) > 0 ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00629_A46PaiCod[0] < A46PaiCod ) || ( T00629_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T00629_A74idOperando[0], A74idOperando) < 0 ) || ( GXutil.strcmp(T00629_A74idOperando[0], A74idOperando) == 0 ) && ( T00629_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T00629_A2098CalParId[0], A2098CalParId) < 0 ) ) )
         {
            A46PaiCod = T00629_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A74idOperando = T00629_A74idOperando[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
            A2098CalParId = T00629_A2098CalParId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2098CalParId", A2098CalParId);
            RcdFound265 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey62265( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert62265( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound265 == 1 )
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A74idOperando, Z74idOperando) != 0 ) || ( GXutil.strcmp(A2098CalParId, Z2098CalParId) != 0 ) )
            {
               A46PaiCod = Z46PaiCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A74idOperando = Z74idOperando ;
               httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
               A2098CalParId = Z2098CalParId ;
               httpContext.ajax_rsp_assign_attri("", false, "A2098CalParId", A2098CalParId);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update62265( ) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A74idOperando, Z74idOperando) != 0 ) || ( GXutil.strcmp(A2098CalParId, Z2098CalParId) != 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert62265( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PAICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPaiCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtPaiCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert62265( ) ;
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
      if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A74idOperando, Z74idOperando) != 0 ) || ( GXutil.strcmp(A2098CalParId, Z2098CalParId) != 0 ) )
      {
         A46PaiCod = Z46PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A74idOperando = Z74idOperando ;
         httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
         A2098CalParId = Z2098CalParId ;
         httpContext.ajax_rsp_assign_attri("", false, "A2098CalParId", A2098CalParId);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtPaiCod_Internalname ;
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
      if ( RcdFound265 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtCalParCampo_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart62265( ) ;
      if ( RcdFound265 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtCalParCampo_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd62265( ) ;
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
      if ( RcdFound265 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtCalParCampo_Internalname ;
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
      if ( RcdFound265 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtCalParCampo_Internalname ;
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
      scanStart62265( ) ;
      if ( RcdFound265 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound265 != 0 )
         {
            scanNext62265( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtCalParCampo_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd62265( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency62265( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00622 */
         pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A74idOperando, A2098CalParId});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Calculo_parametros"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z2099CalParCampo, T00622_A2099CalParCampo[0]) != 0 ) || ( GXutil.strcmp(Z2111CalParValLista, T00622_A2111CalParValLista[0]) != 0 ) || ( GXutil.strcmp(Z2108CalParEjemplo, T00622_A2108CalParEjemplo[0]) != 0 ) || ( Z2104CalParGrp != T00622_A2104CalParGrp[0] ) || ( Z2105CalParGrpDep != T00622_A2105CalParGrpDep[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2106CalParObl != T00622_A2106CalParObl[0] ) || ( GXutil.strcmp(Z2107CalParDef, T00622_A2107CalParDef[0]) != 0 ) || ( GXutil.strcmp(Z2110CalParNombre, T00622_A2110CalParNombre[0]) != 0 ) || ( GXutil.strcmp(Z2100CalParDesc, T00622_A2100CalParDesc[0]) != 0 ) || ( GXutil.strcmp(Z2137CalParDetail, T00622_A2137CalParDetail[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2136CalParDummy, T00622_A2136CalParDummy[0]) != 0 ) || ( Z2141CalParSugGen != T00622_A2141CalParSugGen[0] ) )
         {
            if ( GXutil.strcmp(Z2099CalParCampo, T00622_A2099CalParCampo[0]) != 0 )
            {
               GXutil.writeLogln("calculo_parametros:[seudo value changed for attri]"+"CalParCampo");
               GXutil.writeLogRaw("Old: ",Z2099CalParCampo);
               GXutil.writeLogRaw("Current: ",T00622_A2099CalParCampo[0]);
            }
            if ( GXutil.strcmp(Z2111CalParValLista, T00622_A2111CalParValLista[0]) != 0 )
            {
               GXutil.writeLogln("calculo_parametros:[seudo value changed for attri]"+"CalParValLista");
               GXutil.writeLogRaw("Old: ",Z2111CalParValLista);
               GXutil.writeLogRaw("Current: ",T00622_A2111CalParValLista[0]);
            }
            if ( GXutil.strcmp(Z2108CalParEjemplo, T00622_A2108CalParEjemplo[0]) != 0 )
            {
               GXutil.writeLogln("calculo_parametros:[seudo value changed for attri]"+"CalParEjemplo");
               GXutil.writeLogRaw("Old: ",Z2108CalParEjemplo);
               GXutil.writeLogRaw("Current: ",T00622_A2108CalParEjemplo[0]);
            }
            if ( Z2104CalParGrp != T00622_A2104CalParGrp[0] )
            {
               GXutil.writeLogln("calculo_parametros:[seudo value changed for attri]"+"CalParGrp");
               GXutil.writeLogRaw("Old: ",Z2104CalParGrp);
               GXutil.writeLogRaw("Current: ",T00622_A2104CalParGrp[0]);
            }
            if ( Z2105CalParGrpDep != T00622_A2105CalParGrpDep[0] )
            {
               GXutil.writeLogln("calculo_parametros:[seudo value changed for attri]"+"CalParGrpDep");
               GXutil.writeLogRaw("Old: ",Z2105CalParGrpDep);
               GXutil.writeLogRaw("Current: ",T00622_A2105CalParGrpDep[0]);
            }
            if ( Z2106CalParObl != T00622_A2106CalParObl[0] )
            {
               GXutil.writeLogln("calculo_parametros:[seudo value changed for attri]"+"CalParObl");
               GXutil.writeLogRaw("Old: ",Z2106CalParObl);
               GXutil.writeLogRaw("Current: ",T00622_A2106CalParObl[0]);
            }
            if ( GXutil.strcmp(Z2107CalParDef, T00622_A2107CalParDef[0]) != 0 )
            {
               GXutil.writeLogln("calculo_parametros:[seudo value changed for attri]"+"CalParDef");
               GXutil.writeLogRaw("Old: ",Z2107CalParDef);
               GXutil.writeLogRaw("Current: ",T00622_A2107CalParDef[0]);
            }
            if ( GXutil.strcmp(Z2110CalParNombre, T00622_A2110CalParNombre[0]) != 0 )
            {
               GXutil.writeLogln("calculo_parametros:[seudo value changed for attri]"+"CalParNombre");
               GXutil.writeLogRaw("Old: ",Z2110CalParNombre);
               GXutil.writeLogRaw("Current: ",T00622_A2110CalParNombre[0]);
            }
            if ( GXutil.strcmp(Z2100CalParDesc, T00622_A2100CalParDesc[0]) != 0 )
            {
               GXutil.writeLogln("calculo_parametros:[seudo value changed for attri]"+"CalParDesc");
               GXutil.writeLogRaw("Old: ",Z2100CalParDesc);
               GXutil.writeLogRaw("Current: ",T00622_A2100CalParDesc[0]);
            }
            if ( GXutil.strcmp(Z2137CalParDetail, T00622_A2137CalParDetail[0]) != 0 )
            {
               GXutil.writeLogln("calculo_parametros:[seudo value changed for attri]"+"CalParDetail");
               GXutil.writeLogRaw("Old: ",Z2137CalParDetail);
               GXutil.writeLogRaw("Current: ",T00622_A2137CalParDetail[0]);
            }
            if ( GXutil.strcmp(Z2136CalParDummy, T00622_A2136CalParDummy[0]) != 0 )
            {
               GXutil.writeLogln("calculo_parametros:[seudo value changed for attri]"+"CalParDummy");
               GXutil.writeLogRaw("Old: ",Z2136CalParDummy);
               GXutil.writeLogRaw("Current: ",T00622_A2136CalParDummy[0]);
            }
            if ( Z2141CalParSugGen != T00622_A2141CalParSugGen[0] )
            {
               GXutil.writeLogln("calculo_parametros:[seudo value changed for attri]"+"CalParSugGen");
               GXutil.writeLogRaw("Old: ",Z2141CalParSugGen);
               GXutil.writeLogRaw("Current: ",T00622_A2141CalParSugGen[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Calculo_parametros"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert62265( )
   {
      beforeValidate62265( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable62265( ) ;
      }
      if ( AnyError == 0 )
      {
         zm62265( 0) ;
         checkOptimisticConcurrency62265( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm62265( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert62265( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006210 */
                  pr_default.execute(8, new Object[] {A2098CalParId, A2099CalParCampo, A2111CalParValLista, A2108CalParEjemplo, A2109CalParEjemExpli, Byte.valueOf(A2104CalParGrp), Byte.valueOf(A2105CalParGrpDep), Boolean.valueOf(A2106CalParObl), A2107CalParDef, A2110CalParNombre, A2100CalParDesc, A2137CalParDetail, A2135CalParDoc, A2136CalParDummy, Boolean.valueOf(A2141CalParSugGen), Short.valueOf(A46PaiCod), A74idOperando});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Calculo_parametros");
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
                        resetCaption620( ) ;
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
            load62265( ) ;
         }
         endLevel62265( ) ;
      }
      closeExtendedTableCursors62265( ) ;
   }

   public void update62265( )
   {
      beforeValidate62265( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable62265( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency62265( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm62265( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate62265( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006211 */
                  pr_default.execute(9, new Object[] {A2099CalParCampo, A2111CalParValLista, A2108CalParEjemplo, A2109CalParEjemExpli, Byte.valueOf(A2104CalParGrp), Byte.valueOf(A2105CalParGrpDep), Boolean.valueOf(A2106CalParObl), A2107CalParDef, A2110CalParNombre, A2100CalParDesc, A2137CalParDetail, A2135CalParDoc, A2136CalParDummy, Boolean.valueOf(A2141CalParSugGen), Short.valueOf(A46PaiCod), A74idOperando, A2098CalParId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Calculo_parametros");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Calculo_parametros"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate62265( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption620( ) ;
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
         endLevel62265( ) ;
      }
      closeExtendedTableCursors62265( ) ;
   }

   public void deferredUpdate62265( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate62265( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency62265( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls62265( ) ;
         afterConfirm62265( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete62265( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T006212 */
               pr_default.execute(10, new Object[] {Short.valueOf(A46PaiCod), A74idOperando, A2098CalParId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Calculo_parametros");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound265 == 0 )
                     {
                        initAll62265( ) ;
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
                     resetCaption620( ) ;
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
      sMode265 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel62265( ) ;
      Gx_mode = sMode265 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls62265( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel62265( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete62265( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "calculo_parametros");
         if ( AnyError == 0 )
         {
            confirmValues620( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "calculo_parametros");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart62265( )
   {
      /* Using cursor T006213 */
      pr_default.execute(11);
      RcdFound265 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound265 = (short)(1) ;
         A46PaiCod = T006213_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A74idOperando = T006213_A74idOperando[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
         A2098CalParId = T006213_A2098CalParId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2098CalParId", A2098CalParId);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext62265( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound265 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound265 = (short)(1) ;
         A46PaiCod = T006213_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A74idOperando = T006213_A74idOperando[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
         A2098CalParId = T006213_A2098CalParId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2098CalParId", A2098CalParId);
      }
   }

   public void scanEnd62265( )
   {
      pr_default.close(11);
   }

   public void afterConfirm62265( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert62265( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate62265( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete62265( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete62265( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate62265( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes62265( )
   {
      edtPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      cmbidOperando.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbidOperando.getInternalname(), "Enabled", GXutil.ltrimstr( cmbidOperando.getEnabled(), 5, 0), true);
      cmbCalParId.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbCalParId.getInternalname(), "Enabled", GXutil.ltrimstr( cmbCalParId.getEnabled(), 5, 0), true);
      edtCalParCampo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCalParCampo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParCampo_Enabled), 5, 0), true);
      edtCalParValLista_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCalParValLista_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParValLista_Enabled), 5, 0), true);
      edtCalParEjemplo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCalParEjemplo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParEjemplo_Enabled), 5, 0), true);
      edtCalParEjemExpli_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCalParEjemExpli_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParEjemExpli_Enabled), 5, 0), true);
      edtCalParGrp_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCalParGrp_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParGrp_Enabled), 5, 0), true);
      edtCalParGrpDep_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCalParGrpDep_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParGrpDep_Enabled), 5, 0), true);
      chkCalParObl.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkCalParObl.getInternalname(), "Enabled", GXutil.ltrimstr( chkCalParObl.getEnabled(), 5, 0), true);
      edtCalParDef_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCalParDef_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParDef_Enabled), 5, 0), true);
      edtCalParNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCalParNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParNombre_Enabled), 5, 0), true);
      edtCalParDesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCalParDesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParDesc_Enabled), 5, 0), true);
      edtCalParDetail_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCalParDetail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParDetail_Enabled), 5, 0), true);
      edtCalParDoc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCalParDoc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParDoc_Enabled), 5, 0), true);
      edtCalParDummy_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCalParDummy_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParDummy_Enabled), 5, 0), true);
      chkCalParSugGen.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkCalParSugGen.getInternalname(), "Enabled", GXutil.ltrimstr( chkCalParSugGen.getEnabled(), 5, 0), true);
   }

   public void send_integrity_lvl_hashes62265( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues620( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.calculo_parametros", new String[] {}, new String[] {}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "Z46PaiCod", GXutil.ltrim( localUtil.ntoc( Z46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z74idOperando", GXutil.rtrim( Z74idOperando));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2098CalParId", GXutil.rtrim( Z2098CalParId));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2099CalParCampo", Z2099CalParCampo);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2111CalParValLista", Z2111CalParValLista);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2108CalParEjemplo", Z2108CalParEjemplo);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2104CalParGrp", GXutil.ltrim( localUtil.ntoc( Z2104CalParGrp, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2105CalParGrpDep", GXutil.ltrim( localUtil.ntoc( Z2105CalParGrpDep, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2106CalParObl", Z2106CalParObl);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2107CalParDef", GXutil.rtrim( Z2107CalParDef));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2110CalParNombre", Z2110CalParNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2100CalParDesc", Z2100CalParDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2137CalParDetail", Z2137CalParDetail);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2136CalParDummy", Z2136CalParDummy);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2141CalParSugGen", Z2141CalParSugGen);
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
      return formatLink("web.calculo_parametros", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "Calculo_parametros" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Calculo_parametros", "") ;
   }

   public void initializeNonKey62265( )
   {
      A2099CalParCampo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2099CalParCampo", A2099CalParCampo);
      A2111CalParValLista = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2111CalParValLista", A2111CalParValLista);
      A2108CalParEjemplo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2108CalParEjemplo", A2108CalParEjemplo);
      A2109CalParEjemExpli = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2109CalParEjemExpli", A2109CalParEjemExpli);
      A2104CalParGrp = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2104CalParGrp", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2104CalParGrp), 2, 0));
      A2105CalParGrpDep = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2105CalParGrpDep", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2105CalParGrpDep), 2, 0));
      A2106CalParObl = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2106CalParObl", A2106CalParObl);
      A2107CalParDef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2107CalParDef", A2107CalParDef);
      A2110CalParNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2110CalParNombre", A2110CalParNombre);
      A2100CalParDesc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2100CalParDesc", A2100CalParDesc);
      A2137CalParDetail = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2137CalParDetail", A2137CalParDetail);
      A2135CalParDoc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2135CalParDoc", A2135CalParDoc);
      A2136CalParDummy = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2136CalParDummy", A2136CalParDummy);
      A2141CalParSugGen = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2141CalParSugGen", A2141CalParSugGen);
      Z2099CalParCampo = "" ;
      Z2111CalParValLista = "" ;
      Z2108CalParEjemplo = "" ;
      Z2104CalParGrp = (byte)(0) ;
      Z2105CalParGrpDep = (byte)(0) ;
      Z2106CalParObl = false ;
      Z2107CalParDef = "" ;
      Z2110CalParNombre = "" ;
      Z2100CalParDesc = "" ;
      Z2137CalParDetail = "" ;
      Z2136CalParDummy = "" ;
      Z2141CalParSugGen = false ;
   }

   public void initAll62265( )
   {
      A46PaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A74idOperando = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
      A2098CalParId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2098CalParId", A2098CalParId);
      initializeNonKey62265( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122019421398", true, true);
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
      httpContext.AddJavascriptSource("calculo_parametros.js", "?2024122019421398", false, true);
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
      edtPaiCod_Internalname = "PAICOD" ;
      cmbidOperando.setInternalname( "IDOPERANDO" );
      cmbCalParId.setInternalname( "CALPARID" );
      edtCalParCampo_Internalname = "CALPARCAMPO" ;
      edtCalParValLista_Internalname = "CALPARVALLISTA" ;
      edtCalParEjemplo_Internalname = "CALPAREJEMPLO" ;
      edtCalParEjemExpli_Internalname = "CALPAREJEMEXPLI" ;
      edtCalParGrp_Internalname = "CALPARGRP" ;
      edtCalParGrpDep_Internalname = "CALPARGRPDEP" ;
      chkCalParObl.setInternalname( "CALPAROBL" );
      edtCalParDef_Internalname = "CALPARDEF" ;
      edtCalParNombre_Internalname = "CALPARNOMBRE" ;
      edtCalParDesc_Internalname = "CALPARDESC" ;
      edtCalParDetail_Internalname = "CALPARDETAIL" ;
      edtCalParDoc_Internalname = "CALPARDOC" ;
      edtCalParDummy_Internalname = "CALPARDUMMY" ;
      chkCalParSugGen.setInternalname( "CALPARSUGGEN" );
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
      Form.setCaption( httpContext.getMessage( "Calculo_parametros", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      chkCalParSugGen.setEnabled( 1 );
      edtCalParDummy_Jsonclick = "" ;
      edtCalParDummy_Enabled = 1 ;
      edtCalParDoc_Enabled = 1 ;
      edtCalParDetail_Enabled = 1 ;
      edtCalParDesc_Enabled = 1 ;
      edtCalParNombre_Enabled = 1 ;
      edtCalParDef_Jsonclick = "" ;
      edtCalParDef_Enabled = 1 ;
      chkCalParObl.setEnabled( 1 );
      edtCalParGrpDep_Jsonclick = "" ;
      edtCalParGrpDep_Enabled = 1 ;
      edtCalParGrp_Jsonclick = "" ;
      edtCalParGrp_Enabled = 1 ;
      edtCalParEjemExpli_Enabled = 1 ;
      edtCalParEjemplo_Enabled = 1 ;
      edtCalParValLista_Enabled = 1 ;
      edtCalParCampo_Enabled = 1 ;
      cmbCalParId.setJsonclick( "" );
      cmbCalParId.setEnabled( 1 );
      cmbidOperando.setJsonclick( "" );
      cmbidOperando.setEnabled( 1 );
      edtPaiCod_Jsonclick = "" ;
      edtPaiCod_Enabled = 1 ;
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
      cmbidOperando.setName( "IDOPERANDO" );
      cmbidOperando.setWebtags( "" );
      cmbidOperando.addItem("[antiguedad]", httpContext.getMessage( "Antiguedad en años", ""), (short)(0));
      cmbidOperando.addItem("[antiguedad_indemnizacion]", httpContext.getMessage( "Antig. fracción 3 meses = 1 año", ""), (short)(0));
      cmbidOperando.addItem("{concepto}", httpContext.getMessage( "Concepto", ""), (short)(0));
      cmbidOperando.addItem("{conceptos}", httpContext.getMessage( "Conceptos", ""), (short)(0));
      cmbidOperando.addItem("[dias_mes]", httpContext.getMessage( "Cantidad de dias del mes. Si el parámetro \"Todos los meses tienen 30 dias\" está en \"Si\", devuelve el valor 30, si no devuelve la cantidad de días del mes reales.", ""), (short)(0));
      cmbidOperando.addItem("[dias_semestre]", httpContext.getMessage( "Cantidad de dias del semestre. Tiene en cuenta el parámetro \"Todos los meses tienen 30 días\" para calcular la cantidad de días del semestre.", ""), (short)(0));
      cmbidOperando.addItem("[dias_trabajados_mes]", httpContext.getMessage( "Cantidad de dias trabajados de forma normal en el mes. Es la cantidad de días del mes menos los días de licencia y los días feriados trabajados (que se liquidan aparte), contemplando fecha de ingreso y egreso.", ""), (short)(0));
      cmbidOperando.addItem("[dias_remunerados_semestre]", httpContext.getMessage( "Cantidad de dias remunerados en el semestre. Es la cantidad de días del semestre menos las ausencias injustificadas, contemplando fecha de ingreso y egreso.", ""), (short)(0));
      cmbidOperando.addItem("[plan_medico]", httpContext.getMessage( "Plan Médico", ""), (short)(0));
      cmbidOperando.addItem("[remu_var]", httpContext.getMessage( "Remuneraciones Variables", ""), (short)(0));
      cmbidOperando.addItem("[basico_mensual]", httpContext.getMessage( "Sueldo Básico Mensual", ""), (short)(0));
      cmbidOperando.addItem("[contr_OS_ali]", httpContext.getMessage( "Alícuota para contribución patronal destinada a obra social", ""), (short)(0));
      cmbidOperando.addItem("[contr_FSR_ali]", httpContext.getMessage( "Alìcuota para contribuciòn patronal destinada a FSR (ex ANSSAL)", ""), (short)(0));
      cmbidOperando.addItem("[apo_Dif]", httpContext.getMessage( "Total No Remunerativos que tributan a  aporte de Régimenes Diferenciales", ""), (short)(0));
      cmbidOperando.addItem("[tipoLiq]", httpContext.getMessage( "Tipo de Liquidación", ""), (short)(0));
      cmbidOperando.addItem("[mes_Periodo]", httpContext.getMessage( "Mes Periodo", ""), (short)(0));
      cmbidOperando.addItem("[novedad_cantidad]", httpContext.getMessage( "Cantidad de horas (jornalizados) o días (mensualizados) informadas en agenda de novedades", ""), (short)(0));
      cmbidOperando.addItem("[novedad_importe]", httpContext.getMessage( "Importe informado en agenda de novedades", ""), (short)(0));
      cmbidOperando.addItem("[ART_ali]", httpContext.getMessage( "Alícuota de Contribución Patronal ART según Empresa", ""), (short)(0));
      cmbidOperando.addItem("[gan_cuotas]", httpContext.getMessage( "Ganancias - Cantidad de cuotas faltantes", ""), (short)(0));
      cmbidOperando.addItem("[con_discapacidad]", httpContext.getMessage( "Legajo con Discapacidad", ""), (short)(0));
      cmbidOperando.addItem("[sexo]", httpContext.getMessage( "Legajo Sexo", ""), (short)(0));
      cmbidOperando.addItem("[motivo_egreso]", httpContext.getMessage( "Legajo Motivo de Egreso", ""), (short)(0));
      cmbidOperando.addItem("[area]", httpContext.getMessage( "Legajo Area", ""), (short)(0));
      cmbidOperando.addItem("[categoria]", httpContext.getMessage( "Legajo Categoria", ""), (short)(0));
      cmbidOperando.addItem("[convenio]", httpContext.getMessage( "Legajo Convenio", ""), (short)(0));
      cmbidOperando.addItem("[clase]", httpContext.getMessage( "Legajo Clase", ""), (short)(0));
      cmbidOperando.addItem("[sindicato]", httpContext.getMessage( "Legajo Sindicato", ""), (short)(0));
      cmbidOperando.addItem("[obraSocial]", httpContext.getMessage( "Obra Social_", ""), (short)(0));
      cmbidOperando.addItem("[edad]", httpContext.getMessage( "Edad", ""), (short)(0));
      cmbidOperando.addItem("[monto_siradig]", httpContext.getMessage( "Importes de items ingresados en SIRADIG al 100% para el concepto. En el caso de deducciones generales anuales el importe se aplicará en el mes de diciembre o en liquidación final.", ""), (short)(0));
      cmbidOperando.addItem("[hora_basica]", httpContext.getMessage( "Valor hora básico", ""), (short)(0));
      cmbidOperando.addItem("[horas_extras_exentas]", httpContext.getMessage( "Horas extras exentas.", ""), (short)(0));
      cmbidOperando.addItem("[exentas]", httpContext.getMessage( "Ganancias - remuneraciones totalmente exentas.", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_ley_ganancias]", httpContext.getMessage( "Ganancias - Descuentos de ley sobre remuneración bruta", ""), (short)(0));
      cmbidOperando.addItem("[deduce_conyuge]", httpContext.getMessage( "Ganancias - Deduce conyuge", ""), (short)(0));
      cmbidOperando.addItem("[cant_hijos]", httpContext.getMessage( "Cantidad de hijos menores a 18 años, no incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[cant_hijos_incap]", httpContext.getMessage( "Cantidad de hijos incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[prc_ded_hijos]", httpContext.getMessage( "Ganancias - Porcentaje deducción hijos no incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[prc_ded_hijos_incap]", httpContext.getMessage( "Ganancias - Porcentaje deducción hijos incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[ded_esp_inc]", httpContext.getMessage( "Deduccion especial incrementada", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_anticipo_sac]", httpContext.getMessage( "Descuentos de ley sobre anticipo de SAC", ""), (short)(0));
      cmbidOperando.addItem("[pagos_a_cuenta_anteriores]", httpContext.getMessage( "Pagos a cuenta actualizados. Se recorren las liquidaciones de periodos anteriores para tomar los valores actualizados de pagos a cuenta considerando la carga al día de SIRADIG", ""), (short)(0));
      cmbidOperando.addItem("[alicuota_ley]", httpContext.getMessage( "Alicuota total descuentos de ley según legajo", ""), (short)(0));
      cmbidOperando.addItem("[sueldo_bruto_promedio]", httpContext.getMessage( "Sueldo Bruto Promedio Anual. Este valor es recalculado de forma retroactiva para siempre reflejar el promedio más actualizado", ""), (short)(0));
      cmbidOperando.addItem("[nro_cuota]", httpContext.getMessage( "Número de cuota para ganancias. En liquidaciones de egreso en donde el empleado no continua relación con otro empleador el valor equivale a la cantidad de cuotas totales del año.", ""), (short)(0));
      cmbidOperando.addItem("[agente_retencion]", httpContext.getMessage( "Empresa es agente de retención para el empleado", ""), (short)(0));
      cmbidOperando.addItem("[mni_zona]", httpContext.getMessage( "Deducción [Artículo 30, inciso a)] Mínimo no imponible. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_hijo_zona]", httpContext.getMessage( "Deducción [Art. 30] Hijo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_hijo_incap_zona]", httpContext.getMessage( "Deducción [Art. 30] Hijo incapacitado para el trabajo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_cony_zona]", httpContext.getMessage( "Deducción [Art. 30] Cónyuge / unión convivencial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_especial_zona]", httpContext.getMessage( "Deducción [Art. 30, inc c, A. 2] Especial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[cant_cuotas]", httpContext.getMessage( "Cantidad de cuotas a retener ganancias", ""), (short)(0));
      cmbidOperando.addItem("[f1357_saldo]", httpContext.getMessage( "Saldo de F1357 del año anterior. Aplica en el mes de abril.", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_retencion]", httpContext.getMessage( "Descuentos de Ley más descuentos sobre anticipo de SAC", ""), (short)(0));
      cmbidOperando.addItem("[os_cantidad_adherentes]", httpContext.getMessage( "Cantidad de adherentes adicionales a la obra social", ""), (short)(0));
      cmbidOperando.addItem("[horas_mes]", httpContext.getMessage( "Horas del mes según categoría, o en su defecto el valor de la variable de horas mes default", ""), (short)(0));
      cmbidOperando.addItem("[os_apo_adic]", httpContext.getMessage( "Aporte adicional obra social", ""), (short)(0));
      cmbidOperando.addItem("[horas_jornal]", httpContext.getMessage( "Horas por día que trabaja el empleado", ""), (short)(0));
      cmbidOperando.addItem("[dias_vacaciones]", httpContext.getMessage( "Cantidad de días de vacaciones del periodo", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_licencia]", httpContext.getMessage( "Càlculo de remuneraciòn por la licencia paga", ""), (short)(0));
      cmbidOperando.addItem("[viaticos]", httpContext.getMessage( "Total de viáticos. Incluye importes de otros empleos informado en siradig para el periodo", ""), (short)(0));
      cmbidOperando.addItem("[materiales_didacticos]", httpContext.getMessage( "Total de materiales didácticos de personal docente. Incluye importes de otros empleos informados en siradig para el periodo", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_sobre_gravados]", httpContext.getMessage( "Descuentos de ley sobre impuesto gravado", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_vacaciones_no_gozadas]", httpContext.getMessage( "Mismo cálculo que se realiza para vacaciones, pero la cantidad de días es la que corresponde por ley según años de antiguedad, siempre y cuando el empleado no se haya tomado ya las vacaciones.", ""), (short)(0));
      cmbidOperando.addItem("[tope_indemnizatorio]", httpContext.getMessage( "Tope Indemnizatorio del convenio", ""), (short)(0));
      cmbidOperando.addItem("[alicuota_sindical]", httpContext.getMessage( "Alícuota de cuota sindical", ""), (short)(0));
      cmbidOperando.addItem("[adelanto_retencion]", httpContext.getMessage( "Adelanto de retencion de ganancias", ""), (short)(0));
      cmbidOperando.addItem("[adicional_convenio]", httpContext.getMessage( "Adicional por convenio", ""), (short)(0));
      cmbidOperando.addItem("[horas_jornada_completa]", httpContext.getMessage( "Cantidad de horas de la jornada completa", ""), (short)(0));
      cmbidOperando.addItem("[valor_categoria]", httpContext.getMessage( "Sueldo Categoria", ""), (short)(0));
      cmbidOperando.addItem("{feriado_trabajado_horas}", httpContext.getMessage( "Horas feriado trabajado", ""), (short)(0));
      cmbidOperando.addItem("[feriados_no_trabajados]", httpContext.getMessage( "Feriados no trabajados", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_5]", httpContext.getMessage( "Base imponible 5 -Aportes INSSJYP", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_2]", httpContext.getMessage( "Base imponible 2 - CONTRIBUCIONES SIPA E INSSJYP", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_3]", httpContext.getMessage( "base Imponible 3 - ONTRIBUCIONES FNE, AAFF, Y RENATRE", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_4]", httpContext.getMessage( "Base imponible 4 - APORTES OS Y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_dif_apo_OS_FSR]", httpContext.getMessage( "base Diferencial - Aportes OS y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_dif_con_OS_FSR]", httpContext.getMessage( "Base diferencial - Contribuciones OS y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_8]", httpContext.getMessage( "base Imponible 8  -  CONTRIBUCIONES OS Y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_9]", httpContext.getMessage( "base Imponible 9 - CONTRIBUCIONES LRT", ""), (short)(0));
      cmbidOperando.addItem("[importe_a_detraer]", httpContext.getMessage( "Importe a detraer", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_6]", httpContext.getMessage( "Base imponible 6 - APORTES DIFERENCIALES", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_7]", httpContext.getMessage( "base Imponible 7 - APORTES ESPECIALES", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_adelanto_vacaciones]", httpContext.getMessage( "Remuneracion adelanto de vacaciones", ""), (short)(0));
      cmbidOperando.addItem("[sueldo_bruto]", httpContext.getMessage( "Sueldo Bruto", ""), (short)(0));
      cmbidOperando.addItem("[descuento_adelanto]", httpContext.getMessage( "Descuento por adelanto", ""), (short)(0));
      cmbidOperando.addItem("[dias_proporcionar_tope]", httpContext.getMessage( "Días para proporcionar tope para cálculo de máximo imponible de sueldo", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_1_sueldo]", httpContext.getMessage( "Tope para base imponible 1 sueldo", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_sac]", httpContext.getMessage( "Tope para base imponible para SAC", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_adelantoVac]", httpContext.getMessage( "Tope para base imponible para adelanto de vacaciones de mes próximo", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_1]", httpContext.getMessage( "Base imponible 1 - Aportes SIPA", ""), (short)(0));
      cmbidOperando.addItem("[sueldo_basico]", httpContext.getMessage( "Sueldo básico", ""), (short)(0));
      cmbidOperando.addItem("[calculo_sac]", httpContext.getMessage( "Cálculo SAC", ""), (short)(0));
      cmbidOperando.addItem("[haberes_sac]", httpContext.getMessage( "Haberes Sac", ""), (short)(0));
      cmbidOperando.addItem("[anticipo_sac]", httpContext.getMessage( "Anticipo de SAC", ""), (short)(0));
      cmbidOperando.addItem("[sac_estimado]", httpContext.getMessage( "Estimación de próximo SAC", ""), (short)(0));
      cmbidOperando.addItem("[total_exentos_sin_sac]", httpContext.getMessage( "Total Exentos Sin Sac", ""), (short)(0));
      cmbidOperando.addItem("[cuotas_prorrateo]", httpContext.getMessage( "Cuotas prorrateos", ""), (short)(0));
      cmbidOperando.addItem("[prorrateables]", httpContext.getMessage( "Prorrateables", ""), (short)(0));
      cmbidOperando.addItem("[exento_concepto]", httpContext.getMessage( "Cálculo exento", ""), (short)(0));
      cmbidOperando.addItem("[deduccion]", httpContext.getMessage( "Calculo Deduccion", ""), (short)(0));
      cmbidOperando.addItem("[retencion_ganancias]", httpContext.getMessage( "Retención ganancias", ""), (short)(0));
      cmbidOperando.addItem("[empresa_antiguedad]", httpContext.getMessage( "Importe o alícuota para antiguedad por empresa (fuera de convenio)", ""), (short)(0));
      cmbidOperando.addItem("[empresa_presentismo]", httpContext.getMessage( "Importe o alícuota para presentismo por empresa (fuera de convenio)", ""), (short)(0));
      cmbidOperando.addItem("[asistencia_perfecta]", httpContext.getMessage( "Flag de asistencia perfecta. Si se registran faltas injustificadas o llegadas tarde es 0, caso contrario es 1", ""), (short)(0));
      cmbidOperando.addItem("[es_primera_quincena]", httpContext.getMessage( "Es primera quincena", ""), (short)(0));
      cmbidOperando.addItem("[ART_fijo]", httpContext.getMessage( "Importe fijo de ART", ""), (short)(0));
      cmbidOperando.addItem("[contr_jub_ali]", httpContext.getMessage( "Alìcuota de contribuciòn dej ubilaciòn", ""), (short)(0));
      cmbidOperando.addItem("[contr_inssjyp_ali]", httpContext.getMessage( "Alìcuota de contribución PAMI", ""), (short)(0));
      cmbidOperando.addItem("[contr_aaff_ali]", httpContext.getMessage( "Alìcuota de contribuciòn asignaciones familiares", ""), (short)(0));
      cmbidOperando.addItem("[contr_fne_ali]", httpContext.getMessage( "Alìcuota de contribuciòn fondo nacional de empleo", ""), (short)(0));
      cmbidOperando.addItem("[obligacion]", httpContext.getMessage( "Obligación", ""), (short)(0));
      cmbidOperando.addItem("[liquidar_sac]", httpContext.getMessage( "liquidar_sac", ""), (short)(0));
      cmbidOperando.addItem("[plus_vacacional]", httpContext.getMessage( "Plus Vacacional", ""), (short)(0));
      cmbidOperando.addItem("[no_laborables]", httpContext.getMessage( "Días no laborables no trabajados", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_descuento]", httpContext.getMessage( "Ausencias injustificadas", ""), (short)(0));
      cmbidOperando.addItem("[dias_proporcionar_sac]", httpContext.getMessage( "Cantidad de días para proporcionar SAC", ""), (short)(0));
      cmbidOperando.addItem("[hora_normal]", httpContext.getMessage( "Valor de hora normal", ""), (short)(0));
      cmbidOperando.addItem("[extra]", httpContext.getMessage( "Aumento de hora extra sobre hora normal", ""), (short)(0));
      cmbidOperando.addItem("[recargo]", httpContext.getMessage( "Recargo por tipo de trabajo (por ejemplo nocturno)", ""), (short)(0));
      cmbidOperando.addItem("[jubilacion]", httpContext.getMessage( "Jubilación", ""), (short)(0));
      cmbidOperando.addItem("[obra_social]", httpContext.getMessage( "Obra Social", ""), (short)(0));
      cmbidOperando.addItem("[ley_19032]", httpContext.getMessage( "Ley 19032", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_accidente_empresa]", httpContext.getMessage( "Incapacidad laboral temporaria a cargo de la empresa", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_accidente_ART]", httpContext.getMessage( "Incapacidad laboral temporaria a cargo de ART", ""), (short)(0));
      cmbidOperando.addItem("[ultimo_dia_mes]", httpContext.getMessage( "Ultimo día del mes", ""), (short)(0));
      cmbidOperando.addItem("[dia_fecha_egreso]", httpContext.getMessage( "Día de fecha de egreso", ""), (short)(0));
      cmbidOperando.addItem("[indemnizacion_antiguedad]", httpContext.getMessage( "Indemnización por antiguedad", ""), (short)(0));
      cmbidOperando.addItem("[proporcion_antiguedad_motivo]", httpContext.getMessage( "Proporción según antiguedad y motivo de egreso definido en el concepto", ""), (short)(0));
      cmbidOperando.addItem("[reintegro_guarderia]", httpContext.getMessage( "Reintegro por gastos de guardería", ""), (short)(0));
      cmbidOperando.addItem("[beneficio_guarderia]", httpContext.getMessage( "Beneficio Guarderia", ""), (short)(0));
      cmbidOperando.addItem("[ultimo_dia_mes_egreso]", httpContext.getMessage( "Ultimo día del mes de egreso", ""), (short)(0));
      cmbidOperando.addItem("[dias_mes_egreso]", httpContext.getMessage( "Cantidad de días del mes de egreso", ""), (short)(0));
      cmbidOperando.addItem("[cuota_sindical]", httpContext.getMessage( "Cuota sindical", ""), (short)(0));
      cmbidOperando.addItem("[obra_social_adherentes]", httpContext.getMessage( "Obra Social Adherentes", ""), (short)(0));
      cmbidOperando.addItem("[antiguedad_importe]", httpContext.getMessage( "Antiguedad importe", ""), (short)(0));
      cmbidOperando.addItem("[presentismo_importe]", httpContext.getMessage( "Presentismo importe", ""), (short)(0));
      cmbidOperando.addItem("{sueldo}", httpContext.getMessage( "Sueldo", ""), (short)(0));
      cmbidOperando.addItem("{hora_completa}", httpContext.getMessage( "Hora básica más adicional", ""), (short)(0));
      cmbidOperando.addItem("{feriados_trabajados}", httpContext.getMessage( "Feriados trabajados", ""), (short)(0));
      cmbidOperando.addItem("[vacaciones_descuento]", httpContext.getMessage( "Descuento por días no trabajados por vacaciones", ""), (short)(0));
      cmbidOperando.addItem("[licencias_descuento]", httpContext.getMessage( "Descuento por días no trabajados por licencias", ""), (short)(0));
      cmbidOperando.addItem("{feriados_no_trabajados_descuento}", httpContext.getMessage( "Descuento por días no trabajados feriados", ""), (short)(0));
      cmbidOperando.addItem("{no_laborables_descuento}", httpContext.getMessage( "Descuento por días no trabajados no laborables", ""), (short)(0));
      cmbidOperando.addItem("{sac}", httpContext.getMessage( "Sueldo anual complementario", ""), (short)(0));
      cmbidOperando.addItem("{sac_proporcional}", httpContext.getMessage( "SAC Proporcional", ""), (short)(0));
      cmbidOperando.addItem("{sueldo_adicional}", httpContext.getMessage( "Sueldo Adicional", ""), (short)(0));
      cmbidOperando.addItem("{vacaciones_no_gozadas_ant}", httpContext.getMessage( "Vacaciones no gozadas de año anterior", ""), (short)(0));
      cmbidOperando.addItem("{egreso_descuento}", httpContext.getMessage( "Descuento por días no trabajados por egreso", ""), (short)(0));
      cmbidOperando.addItem("{obra_social_diferencial}", httpContext.getMessage( "Obra social diferencial", ""), (short)(0));
      cmbidOperando.addItem("{dias_HastaFinSemestre}", httpContext.getMessage( "Dias faltantes hasta el fin del semestre", ""), (short)(0));
      cmbidOperando.addItem("{tratamiento_exencion}", httpContext.getMessage( "Cálculo exento por tratamiento de exención de IIGG", ""), (short)(0));
      cmbidOperando.addItem("{horas_nocturnas}", httpContext.getMessage( "Adicional por horas nocturna", ""), (short)(0));
      cmbidOperando.addItem("{extras_al_50}", httpContext.getMessage( "Horas extras al 50%", ""), (short)(0));
      cmbidOperando.addItem("{extras_nocturnas_al_50}", httpContext.getMessage( "Horas extras nocturnas al 50%", ""), (short)(0));
      cmbidOperando.addItem("{extras_nocturnas_al_100}", httpContext.getMessage( "Horas extras nocturnas al 100%", ""), (short)(0));
      cmbidOperando.addItem("{extras_al_100}", httpContext.getMessage( "Horas extras al 100%", ""), (short)(0));
      cmbidOperando.addItem("{retroactivo}", httpContext.getMessage( "Recálculo de liquidaciones anteriores para calcular valores retroactivos", ""), (short)(0));
      cmbidOperando.addItem("{fondo_cese}", httpContext.getMessage( "Fondo de cese laboral", ""), (short)(0));
      cmbidOperando.addItem("{plus_licencia}", httpContext.getMessage( "Plus Licencia", ""), (short)(0));
      cmbidOperando.addItem("{redondeo}", httpContext.getMessage( "Redondeo", ""), (short)(0));
      cmbidOperando.addItem("{leg_prop_adi}", httpContext.getMessage( "Propiedad adicional de legajo", ""), (short)(0));
      cmbidOperando.addItem("{ded_art_30}", httpContext.getMessage( "Deducciones artículo 30", ""), (short)(0));
      cmbidOperando.addItem("{devolucion_ganancias}", httpContext.getMessage( "Devolución ganancias", ""), (short)(0));
      cmbidOperando.addItem("{ded_gen_men}", httpContext.getMessage( "Deducciones generales mensuales", ""), (short)(0));
      cmbidOperando.addItem("{ded_gen_anu}", httpContext.getMessage( "Deducciones generales anuales", ""), (short)(0));
      cmbidOperando.addItem("{rem_gravada_gan}", httpContext.getMessage( "Remuneración gravada en ganancias", ""), (short)(0));
      cmbidOperando.addItem("{gan_neta}", httpContext.getMessage( "Ganancia neta para impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{gnsi_sin_dei}", httpContext.getMessage( "Ganancia neta sujeta a impuesto a las ganancias, menos deducción especial incrementada", ""), (short)(0));
      cmbidOperando.addItem("{gnsi}", httpContext.getMessage( "Ganancia neta sujeta a impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{gan_neta_topes}", httpContext.getMessage( "Ganancia neta para calcular topes de deducciones de impuestos a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{calculo_iigg_neto}", httpContext.getMessage( "Cálculo de impuesto a las ganancias menos pagos a cuenta de periodos anteriores e importes pagados en liquidaciones anteriores", ""), (short)(0));
      cmbidOperando.addItem("{importe_iigg}", httpContext.getMessage( "Importe a retener de impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("[calculo_iigg]", httpContext.getMessage( "Cálculo de impuesto a las ganancias usando tabla de escalas de AFIP", ""), (short)(0));
      cmbidOperando.addItem("{sueldo_bruto_ganancias}", httpContext.getMessage( "Sueldo Bruto más sueldo bruto de otros empleos", ""), (short)(0));
      cmbidOperando.addItem("{sueldo_bruto_menos_ley}", httpContext.getMessage( "Sueldo bruto menos descuentos de ley", ""), (short)(0));
      cmbidOperando.addItem("{alcanza_ganancias}", httpContext.getMessage( "Empleado es alcanzado por impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_jubilacion}", httpContext.getMessage( "Contribución jubilación", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_inssjp}", httpContext.getMessage( "Contribución  ley 19032", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_aaff}", httpContext.getMessage( "Contribución asignaciones familiares", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_fne}", httpContext.getMessage( "Contribución FNE", ""), (short)(0));
      cmbidOperando.addItem("{grossing_up}", httpContext.getMessage( "Grossing up", ""), (short)(0));
      if ( cmbidOperando.getItemCount() > 0 )
      {
         A74idOperando = cmbidOperando.getValidValue(A74idOperando) ;
         httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
      }
      cmbCalParId.setName( "CALPARID" );
      cmbCalParId.setWebtags( "" );
      cmbCalParId.addItem("Devolver", httpContext.getMessage( "Cantidad ingresada en novedad \"C\" o Total \"T\" (valor por omisión)", ""), (short)(0));
      cmbCalParId.addItem("Calculo", httpContext.getMessage( "\"mejor\", o \"promedio\", o \"suma\" (valor por omisión)", ""), (short)(0));
      cmbCalParId.addItem("Periodo", httpContext.getMessage( "Periodo. Valores posibles: \"semestre\" para liquidaciones del semestre, \"acumulado\" para liquidaciones acumuladas en el año en curso, \"deMesesAnteriores\" para liquidaciones de periodos anteriores, \"liquidacionesAnteriores\", \"mismoPeriodo\" para liquidaciones del mismo periodo, \"anterioresDelPeriodo\" para liquidaciones anteriores del periodo (sin incluir el periodo liquidado), \"tramoGanancias\" para liquidaciones de periodos del mismo tramo de ganancias", ""), (short)(0));
      cmbCalParId.addItem("Concepto", httpContext.getMessage( "Código de concepto", ""), (short)(0));
      cmbCalParId.addItem("TipoLiq", httpContext.getMessage( "Tipo de Liquidación", ""), (short)(0));
      cmbCalParId.addItem("Adicional", httpContext.getMessage( "Código de adicional de convenio", ""), (short)(0));
      cmbCalParId.addItem("AdicionalOpcion", httpContext.getMessage( "Opción de adicional de convenio", ""), (short)(0));
      cmbCalParId.addItem("Area", httpContext.getMessage( "Area", ""), (short)(0));
      cmbCalParId.addItem("Categoria", httpContext.getMessage( "Categoría", ""), (short)(0));
      cmbCalParId.addItem("Clase", httpContext.getMessage( "Clase", ""), (short)(0));
      cmbCalParId.addItem("Convenio", httpContext.getMessage( "Convenio", ""), (short)(0));
      cmbCalParId.addItem("MotivoEgreso", httpContext.getMessage( "Motivo de egreso", ""), (short)(0));
      cmbCalParId.addItem("ObraSocial", httpContext.getMessage( "Obra Social", ""), (short)(0));
      cmbCalParId.addItem("Sexo", httpContext.getMessage( "Sexo", ""), (short)(0));
      cmbCalParId.addItem("Sindicato", httpContext.getMessage( "Sindicato", ""), (short)(0));
      cmbCalParId.addItem("Tipo de trabajo", httpContext.getMessage( "TipoTrabajo", ""), (short)(0));
      cmbCalParId.addItem("Dia", httpContext.getMessage( "Día", ""), (short)(0));
      cmbCalParId.addItem("TipoObligacion", httpContext.getMessage( "Tipo de obligación", ""), (short)(0));
      cmbCalParId.addItem("AplIIGG", httpContext.getMessage( "Código de tratamiento de exención", ""), (short)(0));
      cmbCalParId.addItem("TipoDeConcepto", httpContext.getMessage( "Solo de tipo de concepto determinado", ""), (short)(0));
      cmbCalParId.addItem("SueldoBasico", httpContext.getMessage( "Sueldo básico fuera de convenio", ""), (short)(0));
      cmbCalParId.addItem("PropiedadAdicional", httpContext.getMessage( "Propiedad Adicional de legajo por convenio", ""), (short)(0));
      if ( cmbCalParId.getItemCount() > 0 )
      {
         A2098CalParId = cmbCalParId.getValidValue(A2098CalParId) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2098CalParId", A2098CalParId);
      }
      chkCalParObl.setName( "CALPAROBL" );
      chkCalParObl.setWebtags( "" );
      chkCalParObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCalParObl.getInternalname(), "TitleCaption", chkCalParObl.getCaption(), true);
      chkCalParObl.setCheckedValue( "false" );
      A2106CalParObl = GXutil.strtobool( GXutil.booltostr( A2106CalParObl)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2106CalParObl", A2106CalParObl);
      chkCalParSugGen.setName( "CALPARSUGGEN" );
      chkCalParSugGen.setWebtags( "" );
      chkCalParSugGen.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCalParSugGen.getInternalname(), "TitleCaption", chkCalParSugGen.getCaption(), true);
      chkCalParSugGen.setCheckedValue( "false" );
      A2141CalParSugGen = GXutil.strtobool( GXutil.booltostr( A2141CalParSugGen)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2141CalParSugGen", A2141CalParSugGen);
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      /* Using cursor T006214 */
      pr_default.execute(12, new Object[] {Short.valueOf(A46PaiCod), A74idOperando});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "calculo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IDOPERANDO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(12);
      GX_FocusControl = edtCalParCampo_Internalname ;
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

   public void valid_Idoperando( )
   {
      A74idOperando = cmbidOperando.getValue() ;
      /* Using cursor T006214 */
      pr_default.execute(12, new Object[] {Short.valueOf(A46PaiCod), A74idOperando});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "calculo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IDOPERANDO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
      }
      pr_default.close(12);
      dynload_actions( ) ;
      if ( cmbidOperando.getItemCount() > 0 )
      {
         A74idOperando = cmbidOperando.getValidValue(A74idOperando) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbidOperando.setValue( GXutil.rtrim( A74idOperando) );
      }
      if ( cmbCalParId.getItemCount() > 0 )
      {
         A2098CalParId = cmbCalParId.getValidValue(A2098CalParId) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCalParId.setValue( GXutil.rtrim( A2098CalParId) );
      }
      /*  Sending validation outputs */
   }

   public void valid_Calparid( )
   {
      A74idOperando = cmbidOperando.getValue() ;
      A2098CalParId = cmbCalParId.getValue() ;
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      if ( ! ( ( GXutil.strcmp(A2098CalParId, "Devolver") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Calculo") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Periodo") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Concepto") == 0 ) || ( GXutil.strcmp(A2098CalParId, "TipoLiq") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Adicional") == 0 ) || ( GXutil.strcmp(A2098CalParId, "AdicionalOpcion") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Area") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Categoria") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Clase") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Convenio") == 0 ) || ( GXutil.strcmp(A2098CalParId, "MotivoEgreso") == 0 ) || ( GXutil.strcmp(A2098CalParId, "ObraSocial") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Sexo") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Sindicato") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Tipo de trabajo") == 0 ) || ( GXutil.strcmp(A2098CalParId, "Dia") == 0 ) || ( GXutil.strcmp(A2098CalParId, "TipoObligacion") == 0 ) || ( GXutil.strcmp(A2098CalParId, "AplIIGG") == 0 ) || ( GXutil.strcmp(A2098CalParId, "TipoDeConcepto") == 0 ) || ( GXutil.strcmp(A2098CalParId, "SueldoBasico") == 0 ) || ( GXutil.strcmp(A2098CalParId, "PropiedadAdicional") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Id", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CALPARID");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbCalParId.getInternalname() ;
      }
      dynload_actions( ) ;
      if ( cmbidOperando.getItemCount() > 0 )
      {
         A74idOperando = cmbidOperando.getValidValue(A74idOperando) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbidOperando.setValue( GXutil.rtrim( A74idOperando) );
      }
      if ( cmbCalParId.getItemCount() > 0 )
      {
         A2098CalParId = cmbCalParId.getValidValue(A2098CalParId) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCalParId.setValue( GXutil.rtrim( A2098CalParId) );
      }
      A2106CalParObl = GXutil.strtobool( GXutil.booltostr( A2106CalParObl)) ;
      A2141CalParSugGen = GXutil.strtobool( GXutil.booltostr( A2141CalParSugGen)) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A2099CalParCampo", A2099CalParCampo);
      httpContext.ajax_rsp_assign_attri("", false, "A2111CalParValLista", A2111CalParValLista);
      httpContext.ajax_rsp_assign_attri("", false, "A2108CalParEjemplo", A2108CalParEjemplo);
      httpContext.ajax_rsp_assign_attri("", false, "A2109CalParEjemExpli", A2109CalParEjemExpli);
      httpContext.ajax_rsp_assign_attri("", false, "A2104CalParGrp", GXutil.ltrim( localUtil.ntoc( A2104CalParGrp, (byte)(2), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A2105CalParGrpDep", GXutil.ltrim( localUtil.ntoc( A2105CalParGrpDep, (byte)(2), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A2106CalParObl", A2106CalParObl);
      httpContext.ajax_rsp_assign_attri("", false, "A2107CalParDef", GXutil.rtrim( A2107CalParDef));
      httpContext.ajax_rsp_assign_attri("", false, "A2110CalParNombre", A2110CalParNombre);
      httpContext.ajax_rsp_assign_attri("", false, "A2100CalParDesc", A2100CalParDesc);
      httpContext.ajax_rsp_assign_attri("", false, "A2137CalParDetail", A2137CalParDetail);
      httpContext.ajax_rsp_assign_attri("", false, "A2135CalParDoc", A2135CalParDoc);
      httpContext.ajax_rsp_assign_attri("", false, "A2136CalParDummy", A2136CalParDummy);
      httpContext.ajax_rsp_assign_attri("", false, "A2141CalParSugGen", A2141CalParSugGen);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "Z46PaiCod", GXutil.ltrim( localUtil.ntoc( Z46PaiCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z74idOperando", GXutil.rtrim( Z74idOperando));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2098CalParId", GXutil.rtrim( Z2098CalParId));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2099CalParCampo", Z2099CalParCampo);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2111CalParValLista", Z2111CalParValLista);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2108CalParEjemplo", Z2108CalParEjemplo);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2109CalParEjemExpli", Z2109CalParEjemExpli);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2104CalParGrp", GXutil.ltrim( localUtil.ntoc( Z2104CalParGrp, (byte)(2), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2105CalParGrpDep", GXutil.ltrim( localUtil.ntoc( Z2105CalParGrpDep, (byte)(2), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2106CalParObl", GXutil.booltostr( Z2106CalParObl));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2107CalParDef", GXutil.rtrim( Z2107CalParDef));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2110CalParNombre", Z2110CalParNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2100CalParDesc", Z2100CalParDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2137CalParDetail", Z2137CalParDetail);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2135CalParDoc", Z2135CalParDoc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2136CalParDummy", Z2136CalParDummy);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2141CalParSugGen", GXutil.booltostr( Z2141CalParSugGen));
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'A2106CalParObl',fld:'CALPAROBL',pic:''},{av:'A2141CalParSugGen',fld:'CALPARSUGGEN',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A2106CalParObl',fld:'CALPAROBL',pic:''},{av:'A2141CalParSugGen',fld:'CALPARSUGGEN',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A2106CalParObl',fld:'CALPAROBL',pic:''},{av:'A2141CalParSugGen',fld:'CALPARSUGGEN',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A2106CalParObl',fld:'CALPAROBL',pic:''},{av:'A2141CalParSugGen',fld:'CALPARSUGGEN',pic:''}]}");
      setEventMetadata("VALID_PAICOD","{handler:'valid_Paicod',iparms:[{av:'A2106CalParObl',fld:'CALPAROBL',pic:''},{av:'A2141CalParSugGen',fld:'CALPARSUGGEN',pic:''}]");
      setEventMetadata("VALID_PAICOD",",oparms:[{av:'A2106CalParObl',fld:'CALPAROBL',pic:''},{av:'A2141CalParSugGen',fld:'CALPARSUGGEN',pic:''}]}");
      setEventMetadata("VALID_IDOPERANDO","{handler:'valid_Idoperando',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'cmbidOperando'},{av:'A74idOperando',fld:'IDOPERANDO',pic:''},{av:'A2106CalParObl',fld:'CALPAROBL',pic:''},{av:'A2141CalParSugGen',fld:'CALPARSUGGEN',pic:''}]");
      setEventMetadata("VALID_IDOPERANDO",",oparms:[{av:'A2106CalParObl',fld:'CALPAROBL',pic:''},{av:'A2141CalParSugGen',fld:'CALPARSUGGEN',pic:''}]}");
      setEventMetadata("VALID_CALPARID","{handler:'valid_Calparid',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'cmbidOperando'},{av:'A74idOperando',fld:'IDOPERANDO',pic:''},{av:'cmbCalParId'},{av:'A2098CalParId',fld:'CALPARID',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'A2106CalParObl',fld:'CALPAROBL',pic:''},{av:'A2141CalParSugGen',fld:'CALPARSUGGEN',pic:''}]");
      setEventMetadata("VALID_CALPARID",",oparms:[{av:'A2099CalParCampo',fld:'CALPARCAMPO',pic:''},{av:'A2111CalParValLista',fld:'CALPARVALLISTA',pic:''},{av:'A2108CalParEjemplo',fld:'CALPAREJEMPLO',pic:''},{av:'A2109CalParEjemExpli',fld:'CALPAREJEMEXPLI',pic:''},{av:'A2104CalParGrp',fld:'CALPARGRP',pic:'Z9'},{av:'A2105CalParGrpDep',fld:'CALPARGRPDEP',pic:'Z9'},{av:'A2107CalParDef',fld:'CALPARDEF',pic:''},{av:'A2110CalParNombre',fld:'CALPARNOMBRE',pic:''},{av:'A2100CalParDesc',fld:'CALPARDESC',pic:''},{av:'A2137CalParDetail',fld:'CALPARDETAIL',pic:''},{av:'A2135CalParDoc',fld:'CALPARDOC',pic:''},{av:'A2136CalParDummy',fld:'CALPARDUMMY',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z46PaiCod'},{av:'Z74idOperando'},{av:'Z2098CalParId'},{av:'Z2099CalParCampo'},{av:'Z2111CalParValLista'},{av:'Z2108CalParEjemplo'},{av:'Z2109CalParEjemExpli'},{av:'Z2104CalParGrp'},{av:'Z2105CalParGrpDep'},{av:'Z2106CalParObl'},{av:'Z2107CalParDef'},{av:'Z2110CalParNombre'},{av:'Z2100CalParDesc'},{av:'Z2137CalParDetail'},{av:'Z2135CalParDoc'},{av:'Z2136CalParDummy'},{av:'Z2141CalParSugGen'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'},{av:'A2106CalParObl',fld:'CALPAROBL',pic:''},{av:'A2141CalParSugGen',fld:'CALPARSUGGEN',pic:''}]}");
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
      Z74idOperando = "" ;
      Z2098CalParId = "" ;
      Z2099CalParCampo = "" ;
      Z2111CalParValLista = "" ;
      Z2108CalParEjemplo = "" ;
      Z2107CalParDef = "" ;
      Z2110CalParNombre = "" ;
      Z2100CalParDesc = "" ;
      Z2137CalParDetail = "" ;
      Z2136CalParDummy = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A74idOperando = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A2098CalParId = "" ;
      lblTitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A2099CalParCampo = "" ;
      A2111CalParValLista = "" ;
      A2108CalParEjemplo = "" ;
      A2109CalParEjemExpli = "" ;
      A2107CalParDef = "" ;
      A2110CalParNombre = "" ;
      A2100CalParDesc = "" ;
      A2137CalParDetail = "" ;
      A2135CalParDoc = "" ;
      A2136CalParDummy = "" ;
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
      Z2109CalParEjemExpli = "" ;
      Z2135CalParDoc = "" ;
      T00625_A2098CalParId = new String[] {""} ;
      T00625_A2099CalParCampo = new String[] {""} ;
      T00625_A2111CalParValLista = new String[] {""} ;
      T00625_A2108CalParEjemplo = new String[] {""} ;
      T00625_A2109CalParEjemExpli = new String[] {""} ;
      T00625_A2104CalParGrp = new byte[1] ;
      T00625_A2105CalParGrpDep = new byte[1] ;
      T00625_A2106CalParObl = new boolean[] {false} ;
      T00625_A2107CalParDef = new String[] {""} ;
      T00625_A2110CalParNombre = new String[] {""} ;
      T00625_A2100CalParDesc = new String[] {""} ;
      T00625_A2137CalParDetail = new String[] {""} ;
      T00625_A2135CalParDoc = new String[] {""} ;
      T00625_A2136CalParDummy = new String[] {""} ;
      T00625_A2141CalParSugGen = new boolean[] {false} ;
      T00625_A46PaiCod = new short[1] ;
      T00625_A74idOperando = new String[] {""} ;
      T00624_A46PaiCod = new short[1] ;
      T00626_A46PaiCod = new short[1] ;
      T00627_A46PaiCod = new short[1] ;
      T00627_A74idOperando = new String[] {""} ;
      T00627_A2098CalParId = new String[] {""} ;
      T00623_A2098CalParId = new String[] {""} ;
      T00623_A2099CalParCampo = new String[] {""} ;
      T00623_A2111CalParValLista = new String[] {""} ;
      T00623_A2108CalParEjemplo = new String[] {""} ;
      T00623_A2109CalParEjemExpli = new String[] {""} ;
      T00623_A2104CalParGrp = new byte[1] ;
      T00623_A2105CalParGrpDep = new byte[1] ;
      T00623_A2106CalParObl = new boolean[] {false} ;
      T00623_A2107CalParDef = new String[] {""} ;
      T00623_A2110CalParNombre = new String[] {""} ;
      T00623_A2100CalParDesc = new String[] {""} ;
      T00623_A2137CalParDetail = new String[] {""} ;
      T00623_A2135CalParDoc = new String[] {""} ;
      T00623_A2136CalParDummy = new String[] {""} ;
      T00623_A2141CalParSugGen = new boolean[] {false} ;
      T00623_A46PaiCod = new short[1] ;
      T00623_A74idOperando = new String[] {""} ;
      sMode265 = "" ;
      T00628_A46PaiCod = new short[1] ;
      T00628_A74idOperando = new String[] {""} ;
      T00628_A2098CalParId = new String[] {""} ;
      T00629_A46PaiCod = new short[1] ;
      T00629_A74idOperando = new String[] {""} ;
      T00629_A2098CalParId = new String[] {""} ;
      T00622_A2098CalParId = new String[] {""} ;
      T00622_A2099CalParCampo = new String[] {""} ;
      T00622_A2111CalParValLista = new String[] {""} ;
      T00622_A2108CalParEjemplo = new String[] {""} ;
      T00622_A2109CalParEjemExpli = new String[] {""} ;
      T00622_A2104CalParGrp = new byte[1] ;
      T00622_A2105CalParGrpDep = new byte[1] ;
      T00622_A2106CalParObl = new boolean[] {false} ;
      T00622_A2107CalParDef = new String[] {""} ;
      T00622_A2110CalParNombre = new String[] {""} ;
      T00622_A2100CalParDesc = new String[] {""} ;
      T00622_A2137CalParDetail = new String[] {""} ;
      T00622_A2135CalParDoc = new String[] {""} ;
      T00622_A2136CalParDummy = new String[] {""} ;
      T00622_A2141CalParSugGen = new boolean[] {false} ;
      T00622_A46PaiCod = new short[1] ;
      T00622_A74idOperando = new String[] {""} ;
      T006213_A46PaiCod = new short[1] ;
      T006213_A74idOperando = new String[] {""} ;
      T006213_A2098CalParId = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T006214_A46PaiCod = new short[1] ;
      ZZ74idOperando = "" ;
      ZZ2098CalParId = "" ;
      ZZ2099CalParCampo = "" ;
      ZZ2111CalParValLista = "" ;
      ZZ2108CalParEjemplo = "" ;
      ZZ2109CalParEjemExpli = "" ;
      ZZ2107CalParDef = "" ;
      ZZ2110CalParNombre = "" ;
      ZZ2100CalParDesc = "" ;
      ZZ2137CalParDetail = "" ;
      ZZ2135CalParDoc = "" ;
      ZZ2136CalParDummy = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calculo_parametros__default(),
         new Object[] {
             new Object[] {
            T00622_A2098CalParId, T00622_A2099CalParCampo, T00622_A2111CalParValLista, T00622_A2108CalParEjemplo, T00622_A2109CalParEjemExpli, T00622_A2104CalParGrp, T00622_A2105CalParGrpDep, T00622_A2106CalParObl, T00622_A2107CalParDef, T00622_A2110CalParNombre,
            T00622_A2100CalParDesc, T00622_A2137CalParDetail, T00622_A2135CalParDoc, T00622_A2136CalParDummy, T00622_A2141CalParSugGen, T00622_A46PaiCod, T00622_A74idOperando
            }
            , new Object[] {
            T00623_A2098CalParId, T00623_A2099CalParCampo, T00623_A2111CalParValLista, T00623_A2108CalParEjemplo, T00623_A2109CalParEjemExpli, T00623_A2104CalParGrp, T00623_A2105CalParGrpDep, T00623_A2106CalParObl, T00623_A2107CalParDef, T00623_A2110CalParNombre,
            T00623_A2100CalParDesc, T00623_A2137CalParDetail, T00623_A2135CalParDoc, T00623_A2136CalParDummy, T00623_A2141CalParSugGen, T00623_A46PaiCod, T00623_A74idOperando
            }
            , new Object[] {
            T00624_A46PaiCod
            }
            , new Object[] {
            T00625_A2098CalParId, T00625_A2099CalParCampo, T00625_A2111CalParValLista, T00625_A2108CalParEjemplo, T00625_A2109CalParEjemExpli, T00625_A2104CalParGrp, T00625_A2105CalParGrpDep, T00625_A2106CalParObl, T00625_A2107CalParDef, T00625_A2110CalParNombre,
            T00625_A2100CalParDesc, T00625_A2137CalParDetail, T00625_A2135CalParDoc, T00625_A2136CalParDummy, T00625_A2141CalParSugGen, T00625_A46PaiCod, T00625_A74idOperando
            }
            , new Object[] {
            T00626_A46PaiCod
            }
            , new Object[] {
            T00627_A46PaiCod, T00627_A74idOperando, T00627_A2098CalParId
            }
            , new Object[] {
            T00628_A46PaiCod, T00628_A74idOperando, T00628_A2098CalParId
            }
            , new Object[] {
            T00629_A46PaiCod, T00629_A74idOperando, T00629_A2098CalParId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T006213_A46PaiCod, T006213_A74idOperando, T006213_A2098CalParId
            }
            , new Object[] {
            T006214_A46PaiCod
            }
         }
      );
   }

   private byte Z2104CalParGrp ;
   private byte Z2105CalParGrpDep ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A2104CalParGrp ;
   private byte A2105CalParGrpDep ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private byte ZZ2104CalParGrp ;
   private byte ZZ2105CalParGrpDep ;
   private short Z46PaiCod ;
   private short A46PaiCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound265 ;
   private short nIsDirty_265 ;
   private short ZZ46PaiCod ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtPaiCod_Enabled ;
   private int edtCalParCampo_Enabled ;
   private int edtCalParValLista_Enabled ;
   private int edtCalParEjemplo_Enabled ;
   private int edtCalParEjemExpli_Enabled ;
   private int edtCalParGrp_Enabled ;
   private int edtCalParGrpDep_Enabled ;
   private int edtCalParDef_Enabled ;
   private int edtCalParNombre_Enabled ;
   private int edtCalParDesc_Enabled ;
   private int edtCalParDetail_Enabled ;
   private int edtCalParDoc_Enabled ;
   private int edtCalParDummy_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String Z74idOperando ;
   private String Z2098CalParId ;
   private String Z2107CalParDef ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A74idOperando ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtPaiCod_Internalname ;
   private String A2098CalParId ;
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
   private String edtPaiCod_Jsonclick ;
   private String edtCalParCampo_Internalname ;
   private String edtCalParValLista_Internalname ;
   private String edtCalParEjemplo_Internalname ;
   private String edtCalParEjemExpli_Internalname ;
   private String edtCalParGrp_Internalname ;
   private String edtCalParGrp_Jsonclick ;
   private String edtCalParGrpDep_Internalname ;
   private String edtCalParGrpDep_Jsonclick ;
   private String edtCalParDef_Internalname ;
   private String A2107CalParDef ;
   private String edtCalParDef_Jsonclick ;
   private String edtCalParNombre_Internalname ;
   private String edtCalParDesc_Internalname ;
   private String edtCalParDetail_Internalname ;
   private String edtCalParDoc_Internalname ;
   private String edtCalParDummy_Internalname ;
   private String edtCalParDummy_Jsonclick ;
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
   private String sMode265 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ74idOperando ;
   private String ZZ2098CalParId ;
   private String ZZ2107CalParDef ;
   private boolean Z2106CalParObl ;
   private boolean Z2141CalParSugGen ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A2106CalParObl ;
   private boolean A2141CalParSugGen ;
   private boolean Gx_longc ;
   private boolean ZZ2106CalParObl ;
   private boolean ZZ2141CalParSugGen ;
   private String A2109CalParEjemExpli ;
   private String A2135CalParDoc ;
   private String Z2109CalParEjemExpli ;
   private String Z2135CalParDoc ;
   private String ZZ2109CalParEjemExpli ;
   private String ZZ2135CalParDoc ;
   private String Z2099CalParCampo ;
   private String Z2111CalParValLista ;
   private String Z2108CalParEjemplo ;
   private String Z2110CalParNombre ;
   private String Z2100CalParDesc ;
   private String Z2137CalParDetail ;
   private String Z2136CalParDummy ;
   private String A2099CalParCampo ;
   private String A2111CalParValLista ;
   private String A2108CalParEjemplo ;
   private String A2110CalParNombre ;
   private String A2100CalParDesc ;
   private String A2137CalParDetail ;
   private String A2136CalParDummy ;
   private String ZZ2099CalParCampo ;
   private String ZZ2111CalParValLista ;
   private String ZZ2108CalParEjemplo ;
   private String ZZ2110CalParNombre ;
   private String ZZ2100CalParDesc ;
   private String ZZ2137CalParDetail ;
   private String ZZ2136CalParDummy ;
   private HTMLChoice cmbidOperando ;
   private HTMLChoice cmbCalParId ;
   private ICheckbox chkCalParObl ;
   private ICheckbox chkCalParSugGen ;
   private IDataStoreProvider pr_default ;
   private String[] T00625_A2098CalParId ;
   private String[] T00625_A2099CalParCampo ;
   private String[] T00625_A2111CalParValLista ;
   private String[] T00625_A2108CalParEjemplo ;
   private String[] T00625_A2109CalParEjemExpli ;
   private byte[] T00625_A2104CalParGrp ;
   private byte[] T00625_A2105CalParGrpDep ;
   private boolean[] T00625_A2106CalParObl ;
   private String[] T00625_A2107CalParDef ;
   private String[] T00625_A2110CalParNombre ;
   private String[] T00625_A2100CalParDesc ;
   private String[] T00625_A2137CalParDetail ;
   private String[] T00625_A2135CalParDoc ;
   private String[] T00625_A2136CalParDummy ;
   private boolean[] T00625_A2141CalParSugGen ;
   private short[] T00625_A46PaiCod ;
   private String[] T00625_A74idOperando ;
   private short[] T00624_A46PaiCod ;
   private short[] T00626_A46PaiCod ;
   private short[] T00627_A46PaiCod ;
   private String[] T00627_A74idOperando ;
   private String[] T00627_A2098CalParId ;
   private String[] T00623_A2098CalParId ;
   private String[] T00623_A2099CalParCampo ;
   private String[] T00623_A2111CalParValLista ;
   private String[] T00623_A2108CalParEjemplo ;
   private String[] T00623_A2109CalParEjemExpli ;
   private byte[] T00623_A2104CalParGrp ;
   private byte[] T00623_A2105CalParGrpDep ;
   private boolean[] T00623_A2106CalParObl ;
   private String[] T00623_A2107CalParDef ;
   private String[] T00623_A2110CalParNombre ;
   private String[] T00623_A2100CalParDesc ;
   private String[] T00623_A2137CalParDetail ;
   private String[] T00623_A2135CalParDoc ;
   private String[] T00623_A2136CalParDummy ;
   private boolean[] T00623_A2141CalParSugGen ;
   private short[] T00623_A46PaiCod ;
   private String[] T00623_A74idOperando ;
   private short[] T00628_A46PaiCod ;
   private String[] T00628_A74idOperando ;
   private String[] T00628_A2098CalParId ;
   private short[] T00629_A46PaiCod ;
   private String[] T00629_A74idOperando ;
   private String[] T00629_A2098CalParId ;
   private String[] T00622_A2098CalParId ;
   private String[] T00622_A2099CalParCampo ;
   private String[] T00622_A2111CalParValLista ;
   private String[] T00622_A2108CalParEjemplo ;
   private String[] T00622_A2109CalParEjemExpli ;
   private byte[] T00622_A2104CalParGrp ;
   private byte[] T00622_A2105CalParGrpDep ;
   private boolean[] T00622_A2106CalParObl ;
   private String[] T00622_A2107CalParDef ;
   private String[] T00622_A2110CalParNombre ;
   private String[] T00622_A2100CalParDesc ;
   private String[] T00622_A2137CalParDetail ;
   private String[] T00622_A2135CalParDoc ;
   private String[] T00622_A2136CalParDummy ;
   private boolean[] T00622_A2141CalParSugGen ;
   private short[] T00622_A46PaiCod ;
   private String[] T00622_A74idOperando ;
   private short[] T006213_A46PaiCod ;
   private String[] T006213_A74idOperando ;
   private String[] T006213_A2098CalParId ;
   private short[] T006214_A46PaiCod ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class calculo_parametros__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00622", "SELECT CalParId, CalParCampo, CalParValLista, CalParEjemplo, CalParEjemExpli, CalParGrp, CalParGrpDep, CalParObl, CalParDef, CalParNombre, CalParDesc, CalParDetail, CalParDoc, CalParDummy, CalParSugGen, PaiCod, idOperando FROM Calculo_parametros WHERE PaiCod = ? AND idOperando = ? AND CalParId = ?  FOR UPDATE OF Calculo_parametros NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00623", "SELECT CalParId, CalParCampo, CalParValLista, CalParEjemplo, CalParEjemExpli, CalParGrp, CalParGrpDep, CalParObl, CalParDef, CalParNombre, CalParDesc, CalParDetail, CalParDoc, CalParDummy, CalParSugGen, PaiCod, idOperando FROM Calculo_parametros WHERE PaiCod = ? AND idOperando = ? AND CalParId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00624", "SELECT PaiCod FROM calculo WHERE PaiCod = ? AND idOperando = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00625", "SELECT TM1.CalParId, TM1.CalParCampo, TM1.CalParValLista, TM1.CalParEjemplo, TM1.CalParEjemExpli, TM1.CalParGrp, TM1.CalParGrpDep, TM1.CalParObl, TM1.CalParDef, TM1.CalParNombre, TM1.CalParDesc, TM1.CalParDetail, TM1.CalParDoc, TM1.CalParDummy, TM1.CalParSugGen, TM1.PaiCod, TM1.idOperando FROM Calculo_parametros TM1 WHERE TM1.PaiCod = ? and TM1.idOperando = ( ?) and TM1.CalParId = ( ?) ORDER BY TM1.PaiCod, TM1.idOperando, TM1.CalParId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00626", "SELECT PaiCod FROM calculo WHERE PaiCod = ? AND idOperando = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00627", "SELECT PaiCod, idOperando, CalParId FROM Calculo_parametros WHERE PaiCod = ? AND idOperando = ? AND CalParId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00628", "SELECT PaiCod, idOperando, CalParId FROM Calculo_parametros WHERE ( PaiCod > ? or PaiCod = ? and idOperando > ( ?) or idOperando = ( ?) and PaiCod = ? and CalParId > ( ?)) ORDER BY PaiCod, idOperando, CalParId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00629", "SELECT PaiCod, idOperando, CalParId FROM Calculo_parametros WHERE ( PaiCod < ? or PaiCod = ? and idOperando < ( ?) or idOperando = ( ?) and PaiCod = ? and CalParId < ( ?)) ORDER BY PaiCod DESC, idOperando DESC, CalParId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T006210", "SAVEPOINT gxupdate;INSERT INTO Calculo_parametros(CalParId, CalParCampo, CalParValLista, CalParEjemplo, CalParEjemExpli, CalParGrp, CalParGrpDep, CalParObl, CalParDef, CalParNombre, CalParDesc, CalParDetail, CalParDoc, CalParDummy, CalParSugGen, PaiCod, idOperando) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006211", "SAVEPOINT gxupdate;UPDATE Calculo_parametros SET CalParCampo=?, CalParValLista=?, CalParEjemplo=?, CalParEjemExpli=?, CalParGrp=?, CalParGrpDep=?, CalParObl=?, CalParDef=?, CalParNombre=?, CalParDesc=?, CalParDetail=?, CalParDoc=?, CalParDummy=?, CalParSugGen=?  WHERE PaiCod = ? AND idOperando = ? AND CalParId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006212", "SAVEPOINT gxupdate;DELETE FROM Calculo_parametros  WHERE PaiCod = ? AND idOperando = ? AND CalParId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T006213", "SELECT PaiCod, idOperando, CalParId FROM Calculo_parametros ORDER BY PaiCod, idOperando, CalParId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006214", "SELECT PaiCod FROM calculo WHERE PaiCod = ? AND idOperando = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((short[]) buf[15])[0] = rslt.getShort(16);
               ((String[]) buf[16])[0] = rslt.getString(17, 40);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((short[]) buf[15])[0] = rslt.getShort(16);
               ((String[]) buf[16])[0] = rslt.getString(17, 40);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((short[]) buf[15])[0] = rslt.getShort(16);
               ((String[]) buf[16])[0] = rslt.getString(17, 40);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setString(3, (String)parms[2], 40);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setString(3, (String)parms[2], 40);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setString(3, (String)parms[2], 40);
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setString(3, (String)parms[2], 40);
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 40);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 40);
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 40);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 40);
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 4000, false);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setNLongVarchar(5, (String)parms[4], false);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setVarchar(10, (String)parms[9], 400, false);
               stmt.setVarchar(11, (String)parms[10], 400, false);
               stmt.setVarchar(12, (String)parms[11], 400, false);
               stmt.setNLongVarchar(13, (String)parms[12], false);
               stmt.setVarchar(14, (String)parms[13], 40, false);
               stmt.setBoolean(15, ((Boolean) parms[14]).booleanValue());
               stmt.setShort(16, ((Number) parms[15]).shortValue());
               stmt.setString(17, (String)parms[16], 40);
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 4000, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setNLongVarchar(4, (String)parms[3], false);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setString(8, (String)parms[7], 20);
               stmt.setVarchar(9, (String)parms[8], 400, false);
               stmt.setVarchar(10, (String)parms[9], 400, false);
               stmt.setVarchar(11, (String)parms[10], 400, false);
               stmt.setNLongVarchar(12, (String)parms[11], false);
               stmt.setVarchar(13, (String)parms[12], 40, false);
               stmt.setBoolean(14, ((Boolean) parms[13]).booleanValue());
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               stmt.setString(16, (String)parms[15], 40);
               stmt.setString(17, (String)parms[16], 40);
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setString(3, (String)parms[2], 40);
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
      }
   }

}

