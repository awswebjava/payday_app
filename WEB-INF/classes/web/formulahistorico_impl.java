package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class formulahistorico_impl extends GXWebComponent
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
      if ( GXutil.len( sPrefix) == 0 )
      {
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
         else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            nDynComponent = (byte)(1) ;
            sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
            sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
            setjustcreated();
            componentprepare(new Object[] {sCompPrefix,sSFPrefix});
            componentstart();
            httpContext.ajax_rspStartCmp(sPrefix);
            componentdraw();
            httpContext.ajax_rspEndCmp();
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_2") == 0 )
         {
            A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A52ImpSec = GXutil.lval( httpContext.GetPar( "ImpSec")) ;
            n52ImpSec = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A52ImpSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ImpSec), 18, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_2( A3CliCod, A52ImpSec) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_3") == 0 )
         {
            A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A26ConCodigo = httpContext.GetPar( "ConCodigo") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxload_3( A3CliCod, A26ConCodigo) ;
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
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
         }
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_web_controls( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
            }
            Form.getMeta().addItem("description", httpContext.getMessage( "Formula Historico", ""), (short)(0)) ;
         }
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtConCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusDS");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public formulahistorico_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public formulahistorico_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( formulahistorico_impl.class ));
   }

   public formulahistorico_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
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
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         userMain( ) ;
         if ( ! isFullAjaxMode( ) && ( nDynComponent == 0 ) )
         {
            draw( ) ;
         }
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
      cleanup();
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
         renderHtmlCloseForm0I16( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         renderHtmlHeaders( ) ;
      }
      renderHtmlOpenForm( ) ;
      if ( GXutil.len( sPrefix) != 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.formulahistorico");
      }
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "Formula Historico", ""), "", "", lblTitle_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_FormulaHistorico.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "BtnFirst" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_FormulaHistorico.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_FormulaHistorico.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_FormulaHistorico.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_FormulaHistorico.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"ESELECT."+"'", TempTags, "", 2, "HLP_FormulaHistorico.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConCodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'" + sPrefix + "',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConCodigo_Internalname, GXutil.rtrim( A26ConCodigo), GXutil.rtrim( localUtil.format( A26ConCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConCodigo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_FormulaHistorico.htm");
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
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'" + sPrefix + "',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,39);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_FormulaHistorico.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtForHisNum_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtForHisNum_Internalname, httpContext.getMessage( "For His Num", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A51ForHisNum", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51ForHisNum), 4, 0));
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'" + sPrefix + "',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtForHisNum_Internalname, GXutil.ltrim( localUtil.ntoc( A51ForHisNum, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtForHisNum_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A51ForHisNum), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A51ForHisNum), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,44);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtForHisNum_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtForHisNum_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_FormulaHistorico.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtForHisFecha_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtForHisFecha_Internalname, httpContext.getMessage( "For His Fecha", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A223ForHisFecha", localUtil.ttoc( A223ForHisFecha, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'" + sPrefix + "',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtForHisFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtForHisFecha_Internalname, localUtil.ttoc( A223ForHisFecha, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A223ForHisFecha, "99/99/99 99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,49);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtForHisFecha_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtForHisFecha_Enabled, 0, "text", "", 14, "chr", 1, "row", 14, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_FormulaHistorico.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtForHisFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtForHisFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_FormulaHistorico.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtForHisAntes_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtForHisAntes_Internalname, httpContext.getMessage( "For His Antes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A221ForHisAntes", A221ForHisAntes);
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtForHisAntes_Internalname, A221ForHisAntes, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", (short)(0), 1, edtForHisAntes_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_FormulaHistorico.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtForHisDespues_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtForHisDespues_Internalname, httpContext.getMessage( "For His Despues", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A222ForHisDespues", A222ForHisDespues);
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtForHisDespues_Internalname, A222ForHisDespues, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", (short)(0), 1, edtForHisDespues_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_FormulaHistorico.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtForHisUsuario_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtForHisUsuario_Internalname, httpContext.getMessage( "For His Usuario", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A224ForHisUsuario", A224ForHisUsuario);
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'" + sPrefix + "',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtForHisUsuario_Internalname, A224ForHisUsuario, GXutil.rtrim( localUtil.format( A224ForHisUsuario, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtForHisUsuario_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtForHisUsuario_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Usuario", "left", true, "", "HLP_FormulaHistorico.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtImpSec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtImpSec_Internalname, httpContext.getMessage( "Imp Sec", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A52ImpSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ImpSec), 18, 0));
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'" + sPrefix + "',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtImpSec_Internalname, GXutil.ltrim( localUtil.ntoc( A52ImpSec, (byte)(18), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtImpSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A52ImpSec), "ZZZZZZZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A52ImpSec), "ZZZZZZZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,69);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtImpSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtImpSec_Enabled, 0, "text", "1", 18, "chr", 1, "row", 18, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_FormulaHistorico.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_FormulaHistorico.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_FormulaHistorico.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'" + sPrefix + "',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_FormulaHistorico.htm");
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
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            standaloneStartupServer( ) ;
         }
      }
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      nDoneStart = (byte)(1) ;
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z26ConCodigo = httpContext.cgiGet( sPrefix+"Z26ConCodigo") ;
         Z51ForHisNum = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"Z51ForHisNum"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z223ForHisFecha = localUtil.ctot( httpContext.cgiGet( sPrefix+"Z223ForHisFecha"), 0) ;
         Z224ForHisUsuario = httpContext.cgiGet( sPrefix+"Z224ForHisUsuario") ;
         Z52ImpSec = localUtil.ctol( httpContext.cgiGet( sPrefix+"Z52ImpSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         n52ImpSec = ((0==A52ImpSec) ? true : false) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_mode = httpContext.cgiGet( sPrefix+"Mode") ;
         A42ConCodYDesc = httpContext.cgiGet( sPrefix+"CONCODYDESC") ;
         n42ConCodYDesc = false ;
         A41ConDescrip = httpContext.cgiGet( sPrefix+"CONDESCRIP") ;
         /* Read variables values. */
         A26ConCodigo = httpContext.cgiGet( edtConCodigo_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A3CliCod = 0 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
         else
         {
            A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtForHisNum_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtForHisNum_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "FORHISNUM");
            AnyError = (short)(1) ;
            GX_FocusControl = edtForHisNum_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A51ForHisNum = (short)(0) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A51ForHisNum", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51ForHisNum), 4, 0));
         }
         else
         {
            A51ForHisNum = (short)(localUtil.ctol( httpContext.cgiGet( edtForHisNum_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A51ForHisNum", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51ForHisNum), 4, 0));
         }
         if ( localUtil.vcdtime( httpContext.cgiGet( edtForHisFecha_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "FORHISFECHA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtForHisFecha_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A223ForHisFecha = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A223ForHisFecha", localUtil.ttoc( A223ForHisFecha, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            A223ForHisFecha = localUtil.ctot( httpContext.cgiGet( edtForHisFecha_Internalname)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A223ForHisFecha", localUtil.ttoc( A223ForHisFecha, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         A221ForHisAntes = httpContext.cgiGet( edtForHisAntes_Internalname) ;
         n221ForHisAntes = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A221ForHisAntes", A221ForHisAntes);
         n221ForHisAntes = ((GXutil.strcmp("", A221ForHisAntes)==0) ? true : false) ;
         A222ForHisDespues = httpContext.cgiGet( edtForHisDespues_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A222ForHisDespues", A222ForHisDespues);
         A224ForHisUsuario = httpContext.cgiGet( edtForHisUsuario_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A224ForHisUsuario", A224ForHisUsuario);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtImpSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtImpSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "IMPSEC");
            AnyError = (short)(1) ;
            GX_FocusControl = edtImpSec_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A52ImpSec = 0 ;
            n52ImpSec = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A52ImpSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ImpSec), 18, 0));
         }
         else
         {
            A52ImpSec = localUtil.ctol( httpContext.cgiGet( edtImpSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            n52ImpSec = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A52ImpSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ImpSec), 18, 0));
         }
         n52ImpSec = ((0==A52ImpSec) ? true : false) ;
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
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
            A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A26ConCodigo = httpContext.GetPar( "ConCodigo") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
            A51ForHisNum = (short)(GXutil.lval( httpContext.GetPar( "ForHisNum"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A51ForHisNum", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51ForHisNum), 4, 0));
            getEqualNoModal( ) ;
            Gx_mode = "DSP" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
            disable_std_buttons_dsp( ) ;
            standaloneModal( ) ;
         }
         else
         {
            Gx_mode = "INS" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
            standaloneModal( ) ;
         }
      }
   }

   public void process( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read Transaction buttons. */
         if ( httpContext.wbHandled == 0 )
         {
            if ( GXutil.len( sPrefix) == 0 )
            {
               sEvt = httpContext.cgiGet( "_EventName") ;
               EvtGridId = httpContext.cgiGet( "_EventGridId") ;
               EvtRowId = httpContext.cgiGet( "_EventRowId") ;
            }
            if ( GXutil.len( sEvt) > 0 )
            {
               sEvtType = GXutil.left( sEvt, 1) ;
               sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                        {
                           standaloneStartupServer( ) ;
                        }
                        if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              btn_enter( ) ;
                           }
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                     else if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                     {
                        if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                        {
                           standaloneStartupServer( ) ;
                        }
                        if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              btn_first( ) ;
                           }
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "PREVIOUS") == 0 )
                     {
                        if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                        {
                           standaloneStartupServer( ) ;
                        }
                        if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              btn_previous( ) ;
                           }
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                     {
                        if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                        {
                           standaloneStartupServer( ) ;
                        }
                        if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              btn_next( ) ;
                           }
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                     {
                        if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                        {
                           standaloneStartupServer( ) ;
                        }
                        if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              btn_last( ) ;
                           }
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "SELECT") == 0 )
                     {
                        if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                        {
                           standaloneStartupServer( ) ;
                        }
                        if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              btn_select( ) ;
                           }
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "DELETE") == 0 )
                     {
                        if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                        {
                           standaloneStartupServer( ) ;
                        }
                        if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              btn_delete( ) ;
                           }
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                     {
                        if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                        {
                           standaloneStartupServer( ) ;
                        }
                        if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              afterkeyloadscreen( ) ;
                           }
                        }
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
            initAll0I16( ) ;
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
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtForHisNum_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtForHisNum_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtForHisFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtForHisFecha_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtForHisAntes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtForHisAntes_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtForHisDespues_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtForHisDespues_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtForHisUsuario_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtForHisUsuario_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtImpSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpSec_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Visible), 5, 0), true);
   }

   public void disable_std_buttons_dsp( )
   {
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      bttBtn_first_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_first_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_first_Visible), 5, 0), true);
      bttBtn_previous_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_previous_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_previous_Visible), 5, 0), true);
      bttBtn_next_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_next_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_next_Visible), 5, 0), true);
      bttBtn_last_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_last_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_last_Visible), 5, 0), true);
      bttBtn_select_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_select_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_select_Visible), 5, 0), true);
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      if ( isDsp( ) )
      {
         bttBtn_enter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Visible), 5, 0), true);
      }
      disableAttributes0I16( ) ;
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

   public void resetCaption0I0( )
   {
   }

   public void zm0I16( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z223ForHisFecha = T000I3_A223ForHisFecha[0] ;
            Z224ForHisUsuario = T000I3_A224ForHisUsuario[0] ;
            Z52ImpSec = T000I3_A52ImpSec[0] ;
         }
         else
         {
            Z223ForHisFecha = A223ForHisFecha ;
            Z224ForHisUsuario = A224ForHisUsuario ;
            Z52ImpSec = A52ImpSec ;
         }
      }
      if ( GX_JID == -1 )
      {
         Z51ForHisNum = A51ForHisNum ;
         Z223ForHisFecha = A223ForHisFecha ;
         Z221ForHisAntes = A221ForHisAntes ;
         Z222ForHisDespues = A222ForHisDespues ;
         Z224ForHisUsuario = A224ForHisUsuario ;
         Z3CliCod = A3CliCod ;
         Z52ImpSec = A52ImpSec ;
         Z26ConCodigo = A26ConCodigo ;
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
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_delete_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
   }

   public void load0I16( )
   {
      /* Using cursor T000I6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A51ForHisNum), Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A42ConCodYDesc = T000I6_A42ConCodYDesc[0] ;
         n42ConCodYDesc = T000I6_n42ConCodYDesc[0] ;
         A223ForHisFecha = T000I6_A223ForHisFecha[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A223ForHisFecha", localUtil.ttoc( A223ForHisFecha, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A221ForHisAntes = T000I6_A221ForHisAntes[0] ;
         n221ForHisAntes = T000I6_n221ForHisAntes[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A221ForHisAntes", A221ForHisAntes);
         A222ForHisDespues = T000I6_A222ForHisDespues[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A222ForHisDespues", A222ForHisDespues);
         A224ForHisUsuario = T000I6_A224ForHisUsuario[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A224ForHisUsuario", A224ForHisUsuario);
         A41ConDescrip = T000I6_A41ConDescrip[0] ;
         A52ImpSec = T000I6_A52ImpSec[0] ;
         n52ImpSec = T000I6_n52ImpSec[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A52ImpSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ImpSec), 18, 0));
         zm0I16( -1) ;
      }
      pr_default.close(4);
      onLoadActions0I16( ) ;
   }

   public void onLoadActions0I16( )
   {
   }

   public void checkExtendedTable0I16( )
   {
      nIsDirty_16 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T000I4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n52ImpSec), Long.valueOf(A52ImpSec)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A52ImpSec) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Importacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPSEC");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(2);
      /* Using cursor T000I5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      }
      A42ConCodYDesc = T000I5_A42ConCodYDesc[0] ;
      n42ConCodYDesc = T000I5_n42ConCodYDesc[0] ;
      A41ConDescrip = T000I5_A41ConDescrip[0] ;
      A41ConDescrip = T000I5_A41ConDescrip[0] ;
      pr_default.close(3);
   }

   public void closeExtendedTableCursors0I16( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_2( int A3CliCod ,
                         long A52ImpSec )
   {
      /* Using cursor T000I7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n52ImpSec), Long.valueOf(A52ImpSec)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A52ImpSec) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Importacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPSEC");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
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
                         String A26ConCodigo )
   {
      /* Using cursor T000I8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      }
      A42ConCodYDesc = T000I8_A42ConCodYDesc[0] ;
      n42ConCodYDesc = T000I8_n42ConCodYDesc[0] ;
      A41ConDescrip = T000I8_A41ConDescrip[0] ;
      A41ConDescrip = T000I8_A41ConDescrip[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A42ConCodYDesc)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A41ConDescrip)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A41ConDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey0I16( )
   {
      /* Using cursor T000I9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, Short.valueOf(A51ForHisNum)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound16 = (short)(1) ;
      }
      else
      {
         RcdFound16 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000I3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, Short.valueOf(A51ForHisNum)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0I16( 1) ;
         RcdFound16 = (short)(1) ;
         A51ForHisNum = T000I3_A51ForHisNum[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A51ForHisNum", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51ForHisNum), 4, 0));
         A223ForHisFecha = T000I3_A223ForHisFecha[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A223ForHisFecha", localUtil.ttoc( A223ForHisFecha, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A221ForHisAntes = T000I3_A221ForHisAntes[0] ;
         n221ForHisAntes = T000I3_n221ForHisAntes[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A221ForHisAntes", A221ForHisAntes);
         A222ForHisDespues = T000I3_A222ForHisDespues[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A222ForHisDespues", A222ForHisDespues);
         A224ForHisUsuario = T000I3_A224ForHisUsuario[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A224ForHisUsuario", A224ForHisUsuario);
         A3CliCod = T000I3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A52ImpSec = T000I3_A52ImpSec[0] ;
         n52ImpSec = T000I3_n52ImpSec[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A52ImpSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ImpSec), 18, 0));
         A26ConCodigo = T000I3_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
         Z3CliCod = A3CliCod ;
         Z26ConCodigo = A26ConCodigo ;
         Z51ForHisNum = A51ForHisNum ;
         sMode16 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0I16( ) ;
         if ( AnyError == 1 )
         {
            RcdFound16 = (short)(0) ;
            initializeNonKey0I16( ) ;
         }
         Gx_mode = sMode16 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound16 = (short)(0) ;
         initializeNonKey0I16( ) ;
         sMode16 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode16 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0I16( ) ;
      if ( RcdFound16 == 0 )
      {
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound16 = (short)(0) ;
      /* Using cursor T000I10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A51ForHisNum), Short.valueOf(A51ForHisNum), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A51ForHisNum), A26ConCodigo});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000I10_A51ForHisNum[0] < A51ForHisNum ) || ( T000I10_A51ForHisNum[0] == A51ForHisNum ) && ( T000I10_A3CliCod[0] < A3CliCod ) || ( T000I10_A3CliCod[0] == A3CliCod ) && ( T000I10_A51ForHisNum[0] == A51ForHisNum ) && ( GXutil.strcmp(T000I10_A26ConCodigo[0], A26ConCodigo) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000I10_A51ForHisNum[0] > A51ForHisNum ) || ( T000I10_A51ForHisNum[0] == A51ForHisNum ) && ( T000I10_A3CliCod[0] > A3CliCod ) || ( T000I10_A3CliCod[0] == A3CliCod ) && ( T000I10_A51ForHisNum[0] == A51ForHisNum ) && ( GXutil.strcmp(T000I10_A26ConCodigo[0], A26ConCodigo) > 0 ) ) )
         {
            A51ForHisNum = T000I10_A51ForHisNum[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A51ForHisNum", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51ForHisNum), 4, 0));
            A3CliCod = T000I10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A26ConCodigo = T000I10_A26ConCodigo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
            RcdFound16 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound16 = (short)(0) ;
      /* Using cursor T000I11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A51ForHisNum), Short.valueOf(A51ForHisNum), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A51ForHisNum), A26ConCodigo});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T000I11_A51ForHisNum[0] > A51ForHisNum ) || ( T000I11_A51ForHisNum[0] == A51ForHisNum ) && ( T000I11_A3CliCod[0] > A3CliCod ) || ( T000I11_A3CliCod[0] == A3CliCod ) && ( T000I11_A51ForHisNum[0] == A51ForHisNum ) && ( GXutil.strcmp(T000I11_A26ConCodigo[0], A26ConCodigo) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T000I11_A51ForHisNum[0] < A51ForHisNum ) || ( T000I11_A51ForHisNum[0] == A51ForHisNum ) && ( T000I11_A3CliCod[0] < A3CliCod ) || ( T000I11_A3CliCod[0] == A3CliCod ) && ( T000I11_A51ForHisNum[0] == A51ForHisNum ) && ( GXutil.strcmp(T000I11_A26ConCodigo[0], A26ConCodigo) < 0 ) ) )
         {
            A51ForHisNum = T000I11_A51ForHisNum[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A51ForHisNum", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51ForHisNum), 4, 0));
            A3CliCod = T000I11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A26ConCodigo = T000I11_A26ConCodigo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
            RcdFound16 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0I16( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtConCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         insert0I16( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound16 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) || ( A51ForHisNum != Z51ForHisNum ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A26ConCodigo = Z26ConCodigo ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
               A51ForHisNum = Z51ForHisNum ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A51ForHisNum", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51ForHisNum), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtConCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
               /* Update record */
               update0I16( ) ;
               GX_FocusControl = edtConCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) || ( A51ForHisNum != Z51ForHisNum ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtConCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
               insert0I16( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CLICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtConCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                  insert0I16( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void btn_delete( )
   {
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A26ConCodigo, Z26ConCodigo) != 0 ) || ( A51ForHisNum != Z51ForHisNum ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = Z26ConCodigo ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
         A51ForHisNum = Z51ForHisNum ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A51ForHisNum", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51ForHisNum), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtConCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
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
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      if ( RcdFound16 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtForHisFecha_Internalname ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0I16( ) ;
      if ( RcdFound16 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtForHisFecha_Internalname ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      scanEnd0I16( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_previous( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_previous( ) ;
      if ( RcdFound16 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtForHisFecha_Internalname ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_next( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_next( ) ;
      if ( RcdFound16 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtForHisFecha_Internalname ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_last( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0I16( ) ;
      if ( RcdFound16 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound16 != 0 )
         {
            scanNext0I16( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtForHisFecha_Internalname ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      scanEnd0I16( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0I16( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000I2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, Short.valueOf(A51ForHisNum)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"FormulaHistorico"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || !( GXutil.dateCompare(Z223ForHisFecha, T000I2_A223ForHisFecha[0]) ) || ( GXutil.strcmp(Z224ForHisUsuario, T000I2_A224ForHisUsuario[0]) != 0 ) || ( Z52ImpSec != T000I2_A52ImpSec[0] ) )
         {
            if ( !( GXutil.dateCompare(Z223ForHisFecha, T000I2_A223ForHisFecha[0]) ) )
            {
               GXutil.writeLogln("formulahistorico:[seudo value changed for attri]"+"ForHisFecha");
               GXutil.writeLogRaw("Old: ",Z223ForHisFecha);
               GXutil.writeLogRaw("Current: ",T000I2_A223ForHisFecha[0]);
            }
            if ( GXutil.strcmp(Z224ForHisUsuario, T000I2_A224ForHisUsuario[0]) != 0 )
            {
               GXutil.writeLogln("formulahistorico:[seudo value changed for attri]"+"ForHisUsuario");
               GXutil.writeLogRaw("Old: ",Z224ForHisUsuario);
               GXutil.writeLogRaw("Current: ",T000I2_A224ForHisUsuario[0]);
            }
            if ( Z52ImpSec != T000I2_A52ImpSec[0] )
            {
               GXutil.writeLogln("formulahistorico:[seudo value changed for attri]"+"ImpSec");
               GXutil.writeLogRaw("Old: ",Z52ImpSec);
               GXutil.writeLogRaw("Current: ",T000I2_A52ImpSec[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"FormulaHistorico"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0I16( )
   {
      beforeValidate0I16( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0I16( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0I16( 0) ;
         checkOptimisticConcurrency0I16( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0I16( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0I16( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000I12 */
                  pr_default.execute(10, new Object[] {Short.valueOf(A51ForHisNum), A223ForHisFecha, Boolean.valueOf(n221ForHisAntes), A221ForHisAntes, A222ForHisDespues, A224ForHisUsuario, Integer.valueOf(A3CliCod), Boolean.valueOf(n52ImpSec), Long.valueOf(A52ImpSec), A26ConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("FormulaHistorico");
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
                        resetCaption0I0( ) ;
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
            load0I16( ) ;
         }
         endLevel0I16( ) ;
      }
      closeExtendedTableCursors0I16( ) ;
   }

   public void update0I16( )
   {
      beforeValidate0I16( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0I16( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0I16( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0I16( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0I16( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000I13 */
                  pr_default.execute(11, new Object[] {A223ForHisFecha, Boolean.valueOf(n221ForHisAntes), A221ForHisAntes, A222ForHisDespues, A224ForHisUsuario, Boolean.valueOf(n52ImpSec), Long.valueOf(A52ImpSec), Integer.valueOf(A3CliCod), A26ConCodigo, Short.valueOf(A51ForHisNum)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("FormulaHistorico");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"FormulaHistorico"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0I16( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption0I0( ) ;
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
         endLevel0I16( ) ;
      }
      closeExtendedTableCursors0I16( ) ;
   }

   public void deferredUpdate0I16( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      beforeValidate0I16( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0I16( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0I16( ) ;
         afterConfirm0I16( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0I16( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000I14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, Short.valueOf(A51ForHisNum)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("FormulaHistorico");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound16 == 0 )
                     {
                        initAll0I16( ) ;
                        Gx_mode = "INS" ;
                        httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
                     }
                     else
                     {
                        getByPrimaryKey( ) ;
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
                     }
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                     resetCaption0I0( ) ;
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
      sMode16 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      endLevel0I16( ) ;
      Gx_mode = sMode16 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0I16( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000I15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         A42ConCodYDesc = T000I15_A42ConCodYDesc[0] ;
         n42ConCodYDesc = T000I15_n42ConCodYDesc[0] ;
         A41ConDescrip = T000I15_A41ConDescrip[0] ;
         A41ConDescrip = T000I15_A41ConDescrip[0] ;
         pr_default.close(13);
      }
   }

   public void endLevel0I16( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0I16( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "formulahistorico");
         if ( AnyError == 0 )
         {
            confirmValues0I0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "formulahistorico");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0I16( )
   {
      /* Using cursor T000I16 */
      pr_default.execute(14);
      RcdFound16 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A3CliCod = T000I16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = T000I16_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
         A51ForHisNum = T000I16_A51ForHisNum[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A51ForHisNum", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51ForHisNum), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0I16( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound16 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A3CliCod = T000I16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = T000I16_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
         A51ForHisNum = T000I16_A51ForHisNum[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A51ForHisNum", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51ForHisNum), 4, 0));
      }
   }

   public void scanEnd0I16( )
   {
      pr_default.close(14);
   }

   public void afterConfirm0I16( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0I16( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0I16( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0I16( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0I16( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0I16( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0I16( )
   {
      edtConCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtForHisNum_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtForHisNum_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtForHisNum_Enabled), 5, 0), true);
      edtForHisFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtForHisFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtForHisFecha_Enabled), 5, 0), true);
      edtForHisAntes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtForHisAntes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtForHisAntes_Enabled), 5, 0), true);
      edtForHisDespues_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtForHisDespues_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtForHisDespues_Enabled), 5, 0), true);
      edtForHisUsuario_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtForHisUsuario_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtForHisUsuario_Enabled), 5, 0), true);
      edtImpSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtImpSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpSec_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0I16( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0I0( )
   {
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( httpContext.getMessage( "Formula Historico", "")) ;
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
      }
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
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.formulahistorico", new String[] {}, new String[] {}) +"\">") ;
         web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z26ConCodigo", GXutil.rtrim( Z26ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z51ForHisNum", GXutil.ltrim( localUtil.ntoc( Z51ForHisNum, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z223ForHisFecha", localUtil.ttoc( Z223ForHisFecha, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z224ForHisUsuario", Z224ForHisUsuario);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z52ImpSec", GXutil.ltrim( localUtil.ntoc( Z52ImpSec, (byte)(18), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CONCODYDESC", A42ConCodYDesc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CONDESCRIP", A41ConDescrip);
   }

   public void renderHtmlCloseForm0I16( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
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
         httpContext.writeTextNL( "</body>") ;
         httpContext.writeTextNL( "</html>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "FormulaHistorico" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Formula Historico", "") ;
   }

   public void initializeNonKey0I16( )
   {
      A42ConCodYDesc = "" ;
      n42ConCodYDesc = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A42ConCodYDesc", A42ConCodYDesc);
      A223ForHisFecha = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A223ForHisFecha", localUtil.ttoc( A223ForHisFecha, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A221ForHisAntes = "" ;
      n221ForHisAntes = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A221ForHisAntes", A221ForHisAntes);
      n221ForHisAntes = ((GXutil.strcmp("", A221ForHisAntes)==0) ? true : false) ;
      A222ForHisDespues = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A222ForHisDespues", A222ForHisDespues);
      A224ForHisUsuario = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A224ForHisUsuario", A224ForHisUsuario);
      A52ImpSec = 0 ;
      n52ImpSec = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A52ImpSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ImpSec), 18, 0));
      n52ImpSec = ((0==A52ImpSec) ? true : false) ;
      A41ConDescrip = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A41ConDescrip", A41ConDescrip);
      Z223ForHisFecha = GXutil.resetTime( GXutil.nullDate() );
      Z224ForHisUsuario = "" ;
      Z52ImpSec = 0 ;
   }

   public void initAll0I16( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A26ConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A26ConCodigo", A26ConCodigo);
      A51ForHisNum = (short)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A51ForHisNum", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51ForHisNum), 4, 0));
      initializeNonKey0I16( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      if ( GXutil.len( sPrefix) != 0 )
      {
         initialize_properties( ) ;
      }
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      if ( nDoneStart == 0 )
      {
      }
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "formulahistorico", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initenv( ) ;
         inittrn( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
      }
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initenv( ) ;
      inittrn( ) ;
      nDraw = (byte)(0) ;
      sEvt = sCompEvt ;
      if ( isFullAjaxMode( ) )
      {
         userMain( ) ;
      }
      else
      {
         wcparametersget( ) ;
      }
      process( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      userMain( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      draw( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
   }

   public void componentthemes( )
   {
      define_styles( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025181745850", true, true);
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
      httpContext.AddJavascriptSource("formulahistorico.js", "?2025181745851", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTitle_Internalname = sPrefix+"TITLE" ;
      divTitlecontainer_Internalname = sPrefix+"TITLECONTAINER" ;
      bttBtn_first_Internalname = sPrefix+"BTN_FIRST" ;
      bttBtn_previous_Internalname = sPrefix+"BTN_PREVIOUS" ;
      bttBtn_next_Internalname = sPrefix+"BTN_NEXT" ;
      bttBtn_last_Internalname = sPrefix+"BTN_LAST" ;
      bttBtn_select_Internalname = sPrefix+"BTN_SELECT" ;
      divToolbarcell_Internalname = sPrefix+"TOOLBARCELL" ;
      edtConCodigo_Internalname = sPrefix+"CONCODIGO" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtForHisNum_Internalname = sPrefix+"FORHISNUM" ;
      edtForHisFecha_Internalname = sPrefix+"FORHISFECHA" ;
      edtForHisAntes_Internalname = sPrefix+"FORHISANTES" ;
      edtForHisDespues_Internalname = sPrefix+"FORHISDESPUES" ;
      edtForHisUsuario_Internalname = sPrefix+"FORHISUSUARIO" ;
      edtImpSec_Internalname = sPrefix+"IMPSEC" ;
      divFormcontainer_Internalname = sPrefix+"FORMCONTAINER" ;
      bttBtn_enter_Internalname = sPrefix+"BTN_ENTER" ;
      bttBtn_cancel_Internalname = sPrefix+"BTN_CANCEL" ;
      bttBtn_delete_Internalname = sPrefix+"BTN_DELETE" ;
      divMaintable_Internalname = sPrefix+"MAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusDS");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtImpSec_Jsonclick = "" ;
      edtImpSec_Enabled = 1 ;
      edtForHisUsuario_Jsonclick = "" ;
      edtForHisUsuario_Enabled = 1 ;
      edtForHisDespues_Enabled = 1 ;
      edtForHisAntes_Enabled = 1 ;
      edtForHisFecha_Jsonclick = "" ;
      edtForHisFecha_Enabled = 1 ;
      edtForHisNum_Jsonclick = "" ;
      edtForHisNum_Enabled = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtConCodigo_Jsonclick = "" ;
      edtConCodigo_Enabled = 1 ;
      bttBtn_select_Visible = 1 ;
      bttBtn_last_Visible = 1 ;
      bttBtn_next_Visible = 1 ;
      bttBtn_previous_Visible = 1 ;
      bttBtn_first_Visible = 1 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
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
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      /* Using cursor T000I15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
      }
      A42ConCodYDesc = T000I15_A42ConCodYDesc[0] ;
      n42ConCodYDesc = T000I15_n42ConCodYDesc[0] ;
      A41ConDescrip = T000I15_A41ConDescrip[0] ;
      A41ConDescrip = T000I15_A41ConDescrip[0] ;
      pr_default.close(13);
      GX_FocusControl = edtForHisFecha_Internalname ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
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
      n42ConCodYDesc = false ;
      /* Using cursor T000I15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A42ConCodYDesc = T000I15_A42ConCodYDesc[0] ;
      n42ConCodYDesc = T000I15_n42ConCodYDesc[0] ;
      A41ConDescrip = T000I15_A41ConDescrip[0] ;
      A41ConDescrip = T000I15_A41ConDescrip[0] ;
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A42ConCodYDesc", A42ConCodYDesc);
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A41ConDescrip", A41ConDescrip);
   }

   public void valid_Forhisnum( )
   {
      if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
      {
         standaloneStartupServer( ) ;
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         httpContext.wbHandled = (byte)(1) ;
         if ( ! wbErr )
         {
            afterkeyloadscreen( ) ;
         }
      }
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A223ForHisFecha", localUtil.ttoc( A223ForHisFecha, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A221ForHisAntes", A221ForHisAntes);
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A222ForHisDespues", A222ForHisDespues);
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A224ForHisUsuario", A224ForHisUsuario);
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A52ImpSec", GXutil.ltrim( localUtil.ntoc( A52ImpSec, (byte)(18), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A42ConCodYDesc", A42ConCodYDesc);
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A41ConDescrip", A41ConDescrip);
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z26ConCodigo", GXutil.rtrim( Z26ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z51ForHisNum", GXutil.ltrim( localUtil.ntoc( Z51ForHisNum, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z223ForHisFecha", localUtil.ttoc( Z223ForHisFecha, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z221ForHisAntes", Z221ForHisAntes);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z222ForHisDespues", Z222ForHisDespues);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z224ForHisUsuario", Z224ForHisUsuario);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z52ImpSec", GXutil.ltrim( localUtil.ntoc( Z52ImpSec, (byte)(18), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z42ConCodYDesc", Z42ConCodYDesc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Z41ConDescrip", Z41ConDescrip);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Impsec( )
   {
      n52ImpSec = false ;
      /* Using cursor T000I17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n52ImpSec), Long.valueOf(A52ImpSec)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A52ImpSec) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Importacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPSEC");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      pr_default.close(15);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'componentprocess',iparms:[{postForm:true},{sPrefix:true},{sSFPrefix:true},{sCompEvt:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("VALID_CONCODIGO","{handler:'valid_Concodigo',iparms:[]");
      setEventMetadata("VALID_CONCODIGO",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''},{av:'A42ConCodYDesc',fld:'CONCODYDESC',pic:''},{av:'A41ConDescrip',fld:'CONDESCRIP',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A42ConCodYDesc',fld:'CONCODYDESC',pic:''},{av:'A41ConDescrip',fld:'CONDESCRIP',pic:''}]}");
      setEventMetadata("VALID_FORHISNUM","{handler:'valid_Forhisnum',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''},{av:'A51ForHisNum',fld:'FORHISNUM',pic:'ZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_FORHISNUM",",oparms:[{av:'A223ForHisFecha',fld:'FORHISFECHA',pic:'99/99/99 99:99'},{av:'A221ForHisAntes',fld:'FORHISANTES',pic:''},{av:'A222ForHisDespues',fld:'FORHISDESPUES',pic:''},{av:'A224ForHisUsuario',fld:'FORHISUSUARIO',pic:''},{av:'A52ImpSec',fld:'IMPSEC',pic:'ZZZZZZZZZZZZZZZZZ9'},{av:'A42ConCodYDesc',fld:'CONCODYDESC',pic:''},{av:'A41ConDescrip',fld:'CONDESCRIP',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z3CliCod'},{av:'Z26ConCodigo'},{av:'Z51ForHisNum'},{av:'Z223ForHisFecha'},{av:'Z221ForHisAntes'},{av:'Z222ForHisDespues'},{av:'Z224ForHisUsuario'},{av:'Z52ImpSec'},{av:'Z42ConCodYDesc'},{av:'Z41ConDescrip'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_IMPSEC","{handler:'valid_Impsec',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A52ImpSec',fld:'IMPSEC',pic:'ZZZZZZZZZZZZZZZZZ9'}]");
      setEventMetadata("VALID_IMPSEC",",oparms:[]}");
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
      pr_default.close(13);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z26ConCodigo = "" ;
      Z223ForHisFecha = GXutil.resetTime( GXutil.nullDate() );
      Z224ForHisUsuario = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A26ConCodigo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sXEvt = "" ;
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
      A223ForHisFecha = GXutil.resetTime( GXutil.nullDate() );
      A221ForHisAntes = "" ;
      A222ForHisDespues = "" ;
      A224ForHisUsuario = "" ;
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
      Z221ForHisAntes = "" ;
      Z222ForHisDespues = "" ;
      Z42ConCodYDesc = "" ;
      Z41ConDescrip = "" ;
      T000I6_A42ConCodYDesc = new String[] {""} ;
      T000I6_n42ConCodYDesc = new boolean[] {false} ;
      T000I6_A51ForHisNum = new short[1] ;
      T000I6_A223ForHisFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000I6_A221ForHisAntes = new String[] {""} ;
      T000I6_n221ForHisAntes = new boolean[] {false} ;
      T000I6_A222ForHisDespues = new String[] {""} ;
      T000I6_A224ForHisUsuario = new String[] {""} ;
      T000I6_A41ConDescrip = new String[] {""} ;
      T000I6_A3CliCod = new int[1] ;
      T000I6_A52ImpSec = new long[1] ;
      T000I6_n52ImpSec = new boolean[] {false} ;
      T000I6_A26ConCodigo = new String[] {""} ;
      T000I4_A3CliCod = new int[1] ;
      T000I5_A42ConCodYDesc = new String[] {""} ;
      T000I5_n42ConCodYDesc = new boolean[] {false} ;
      T000I5_A41ConDescrip = new String[] {""} ;
      T000I7_A3CliCod = new int[1] ;
      T000I8_A42ConCodYDesc = new String[] {""} ;
      T000I8_n42ConCodYDesc = new boolean[] {false} ;
      T000I8_A41ConDescrip = new String[] {""} ;
      T000I9_A3CliCod = new int[1] ;
      T000I9_A26ConCodigo = new String[] {""} ;
      T000I9_A51ForHisNum = new short[1] ;
      T000I3_A51ForHisNum = new short[1] ;
      T000I3_A223ForHisFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000I3_A221ForHisAntes = new String[] {""} ;
      T000I3_n221ForHisAntes = new boolean[] {false} ;
      T000I3_A222ForHisDespues = new String[] {""} ;
      T000I3_A224ForHisUsuario = new String[] {""} ;
      T000I3_A3CliCod = new int[1] ;
      T000I3_A52ImpSec = new long[1] ;
      T000I3_n52ImpSec = new boolean[] {false} ;
      T000I3_A26ConCodigo = new String[] {""} ;
      sMode16 = "" ;
      T000I10_A51ForHisNum = new short[1] ;
      T000I10_A3CliCod = new int[1] ;
      T000I10_A26ConCodigo = new String[] {""} ;
      T000I11_A51ForHisNum = new short[1] ;
      T000I11_A3CliCod = new int[1] ;
      T000I11_A26ConCodigo = new String[] {""} ;
      T000I2_A51ForHisNum = new short[1] ;
      T000I2_A223ForHisFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000I2_A221ForHisAntes = new String[] {""} ;
      T000I2_n221ForHisAntes = new boolean[] {false} ;
      T000I2_A222ForHisDespues = new String[] {""} ;
      T000I2_A224ForHisUsuario = new String[] {""} ;
      T000I2_A3CliCod = new int[1] ;
      T000I2_A52ImpSec = new long[1] ;
      T000I2_n52ImpSec = new boolean[] {false} ;
      T000I2_A26ConCodigo = new String[] {""} ;
      T000I15_A42ConCodYDesc = new String[] {""} ;
      T000I15_n42ConCodYDesc = new boolean[] {false} ;
      T000I15_A41ConDescrip = new String[] {""} ;
      T000I16_A3CliCod = new int[1] ;
      T000I16_A26ConCodigo = new String[] {""} ;
      T000I16_A51ForHisNum = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ZZ26ConCodigo = "" ;
      ZZ223ForHisFecha = GXutil.resetTime( GXutil.nullDate() );
      ZZ221ForHisAntes = "" ;
      ZZ222ForHisDespues = "" ;
      ZZ224ForHisUsuario = "" ;
      ZZ42ConCodYDesc = "" ;
      ZZ41ConDescrip = "" ;
      T000I17_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.formulahistorico__default(),
         new Object[] {
             new Object[] {
            T000I2_A51ForHisNum, T000I2_A223ForHisFecha, T000I2_A221ForHisAntes, T000I2_n221ForHisAntes, T000I2_A222ForHisDespues, T000I2_A224ForHisUsuario, T000I2_A3CliCod, T000I2_A52ImpSec, T000I2_n52ImpSec, T000I2_A26ConCodigo
            }
            , new Object[] {
            T000I3_A51ForHisNum, T000I3_A223ForHisFecha, T000I3_A221ForHisAntes, T000I3_n221ForHisAntes, T000I3_A222ForHisDespues, T000I3_A224ForHisUsuario, T000I3_A3CliCod, T000I3_A52ImpSec, T000I3_n52ImpSec, T000I3_A26ConCodigo
            }
            , new Object[] {
            T000I4_A3CliCod
            }
            , new Object[] {
            T000I5_A42ConCodYDesc, T000I5_n42ConCodYDesc, T000I5_A41ConDescrip
            }
            , new Object[] {
            T000I6_A42ConCodYDesc, T000I6_n42ConCodYDesc, T000I6_A51ForHisNum, T000I6_A223ForHisFecha, T000I6_A221ForHisAntes, T000I6_n221ForHisAntes, T000I6_A222ForHisDespues, T000I6_A224ForHisUsuario, T000I6_A41ConDescrip, T000I6_A3CliCod,
            T000I6_A52ImpSec, T000I6_n52ImpSec, T000I6_A26ConCodigo
            }
            , new Object[] {
            T000I7_A3CliCod
            }
            , new Object[] {
            T000I8_A42ConCodYDesc, T000I8_n42ConCodYDesc, T000I8_A41ConDescrip
            }
            , new Object[] {
            T000I9_A3CliCod, T000I9_A26ConCodigo, T000I9_A51ForHisNum
            }
            , new Object[] {
            T000I10_A51ForHisNum, T000I10_A3CliCod, T000I10_A26ConCodigo
            }
            , new Object[] {
            T000I11_A51ForHisNum, T000I11_A3CliCod, T000I11_A26ConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000I15_A42ConCodYDesc, T000I15_n42ConCodYDesc, T000I15_A41ConDescrip
            }
            , new Object[] {
            T000I16_A3CliCod, T000I16_A26ConCodigo, T000I16_A51ForHisNum
            }
            , new Object[] {
            T000I17_A3CliCod
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nKeyPressed ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte Gx_BScreen ;
   private short Z51ForHisNum ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A51ForHisNum ;
   private short RcdFound16 ;
   private short nIsDirty_16 ;
   private short ZZ51ForHisNum ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtConCodigo_Enabled ;
   private int edtCliCod_Enabled ;
   private int edtForHisNum_Enabled ;
   private int edtForHisFecha_Enabled ;
   private int edtForHisAntes_Enabled ;
   private int edtForHisDespues_Enabled ;
   private int edtForHisUsuario_Enabled ;
   private int edtImpSec_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ3CliCod ;
   private long Z52ImpSec ;
   private long A52ImpSec ;
   private long ZZ52ImpSec ;
   private String sPrefix ;
   private String Z26ConCodigo ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String A26ConCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String sXEvt ;
   private String GX_FocusControl ;
   private String edtConCodigo_Internalname ;
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
   private String edtConCodigo_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtForHisNum_Internalname ;
   private String edtForHisNum_Jsonclick ;
   private String edtForHisFecha_Internalname ;
   private String edtForHisFecha_Jsonclick ;
   private String edtForHisAntes_Internalname ;
   private String edtForHisDespues_Internalname ;
   private String edtForHisUsuario_Internalname ;
   private String edtForHisUsuario_Jsonclick ;
   private String edtImpSec_Internalname ;
   private String edtImpSec_Jsonclick ;
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
   private String sMode16 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ26ConCodigo ;
   private java.util.Date Z223ForHisFecha ;
   private java.util.Date A223ForHisFecha ;
   private java.util.Date ZZ223ForHisFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n52ImpSec ;
   private boolean wbErr ;
   private boolean n42ConCodYDesc ;
   private boolean n221ForHisAntes ;
   private String A221ForHisAntes ;
   private String A222ForHisDespues ;
   private String Z221ForHisAntes ;
   private String Z222ForHisDespues ;
   private String ZZ221ForHisAntes ;
   private String ZZ222ForHisDespues ;
   private String Z224ForHisUsuario ;
   private String A224ForHisUsuario ;
   private String A42ConCodYDesc ;
   private String A41ConDescrip ;
   private String Z42ConCodYDesc ;
   private String Z41ConDescrip ;
   private String ZZ224ForHisUsuario ;
   private String ZZ42ConCodYDesc ;
   private String ZZ41ConDescrip ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private IDataStoreProvider pr_default ;
   private String[] T000I6_A42ConCodYDesc ;
   private boolean[] T000I6_n42ConCodYDesc ;
   private short[] T000I6_A51ForHisNum ;
   private java.util.Date[] T000I6_A223ForHisFecha ;
   private String[] T000I6_A221ForHisAntes ;
   private boolean[] T000I6_n221ForHisAntes ;
   private String[] T000I6_A222ForHisDespues ;
   private String[] T000I6_A224ForHisUsuario ;
   private String[] T000I6_A41ConDescrip ;
   private int[] T000I6_A3CliCod ;
   private long[] T000I6_A52ImpSec ;
   private boolean[] T000I6_n52ImpSec ;
   private String[] T000I6_A26ConCodigo ;
   private int[] T000I4_A3CliCod ;
   private String[] T000I5_A42ConCodYDesc ;
   private boolean[] T000I5_n42ConCodYDesc ;
   private String[] T000I5_A41ConDescrip ;
   private int[] T000I7_A3CliCod ;
   private String[] T000I8_A42ConCodYDesc ;
   private boolean[] T000I8_n42ConCodYDesc ;
   private String[] T000I8_A41ConDescrip ;
   private int[] T000I9_A3CliCod ;
   private String[] T000I9_A26ConCodigo ;
   private short[] T000I9_A51ForHisNum ;
   private short[] T000I3_A51ForHisNum ;
   private java.util.Date[] T000I3_A223ForHisFecha ;
   private String[] T000I3_A221ForHisAntes ;
   private boolean[] T000I3_n221ForHisAntes ;
   private String[] T000I3_A222ForHisDespues ;
   private String[] T000I3_A224ForHisUsuario ;
   private int[] T000I3_A3CliCod ;
   private long[] T000I3_A52ImpSec ;
   private boolean[] T000I3_n52ImpSec ;
   private String[] T000I3_A26ConCodigo ;
   private short[] T000I10_A51ForHisNum ;
   private int[] T000I10_A3CliCod ;
   private String[] T000I10_A26ConCodigo ;
   private short[] T000I11_A51ForHisNum ;
   private int[] T000I11_A3CliCod ;
   private String[] T000I11_A26ConCodigo ;
   private short[] T000I2_A51ForHisNum ;
   private java.util.Date[] T000I2_A223ForHisFecha ;
   private String[] T000I2_A221ForHisAntes ;
   private boolean[] T000I2_n221ForHisAntes ;
   private String[] T000I2_A222ForHisDespues ;
   private String[] T000I2_A224ForHisUsuario ;
   private int[] T000I2_A3CliCod ;
   private long[] T000I2_A52ImpSec ;
   private boolean[] T000I2_n52ImpSec ;
   private String[] T000I2_A26ConCodigo ;
   private String[] T000I15_A42ConCodYDesc ;
   private boolean[] T000I15_n42ConCodYDesc ;
   private String[] T000I15_A41ConDescrip ;
   private int[] T000I16_A3CliCod ;
   private String[] T000I16_A26ConCodigo ;
   private short[] T000I16_A51ForHisNum ;
   private int[] T000I17_A3CliCod ;
}

final  class formulahistorico__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000I2", "SELECT ForHisNum, ForHisFecha, ForHisAntes, ForHisDespues, ForHisUsuario, CliCod, ImpSec, ConCodigo FROM FormulaHistorico WHERE CliCod = ? AND ConCodigo = ? AND ForHisNum = ?  FOR UPDATE OF FormulaHistorico NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000I3", "SELECT ForHisNum, ForHisFecha, ForHisAntes, ForHisDespues, ForHisUsuario, CliCod, ImpSec, ConCodigo FROM FormulaHistorico WHERE CliCod = ? AND ConCodigo = ? AND ForHisNum = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000I4", "SELECT CliCod FROM Importacion WHERE CliCod = ? AND ImpSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000I5", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000I6", "SELECT T2.ConCodYDesc, TM1.ForHisNum, TM1.ForHisFecha, TM1.ForHisAntes, TM1.ForHisDespues, TM1.ForHisUsuario, T2.ConDescrip, TM1.CliCod, TM1.ImpSec, TM1.ConCodigo FROM (FormulaHistorico TM1 INNER JOIN Concepto T2 ON T2.CliCod = TM1.CliCod AND T2.ConCodigo = TM1.ConCodigo) WHERE TM1.ForHisNum = ? and TM1.CliCod = ? and TM1.ConCodigo = ( ?) ORDER BY TM1.CliCod, TM1.ConCodigo, TM1.ForHisNum ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000I7", "SELECT CliCod FROM Importacion WHERE CliCod = ? AND ImpSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000I8", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000I9", "SELECT CliCod, ConCodigo, ForHisNum FROM FormulaHistorico WHERE CliCod = ? AND ConCodigo = ? AND ForHisNum = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000I10", "SELECT ForHisNum, CliCod, ConCodigo FROM FormulaHistorico WHERE ( ForHisNum > ? or ForHisNum = ? and CliCod > ? or CliCod = ? and ForHisNum = ? and ConCodigo > ( ?)) ORDER BY CliCod, ConCodigo, ForHisNum  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000I11", "SELECT ForHisNum, CliCod, ConCodigo FROM FormulaHistorico WHERE ( ForHisNum < ? or ForHisNum = ? and CliCod < ? or CliCod = ? and ForHisNum = ? and ConCodigo < ( ?)) ORDER BY CliCod DESC, ConCodigo DESC, ForHisNum DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000I12", "SAVEPOINT gxupdate;INSERT INTO FormulaHistorico(ForHisNum, ForHisFecha, ForHisAntes, ForHisDespues, ForHisUsuario, CliCod, ImpSec, ConCodigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000I13", "SAVEPOINT gxupdate;UPDATE FormulaHistorico SET ForHisFecha=?, ForHisAntes=?, ForHisDespues=?, ForHisUsuario=?, ImpSec=?  WHERE CliCod = ? AND ConCodigo = ? AND ForHisNum = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000I14", "SAVEPOINT gxupdate;DELETE FROM FormulaHistorico  WHERE CliCod = ? AND ConCodigo = ? AND ForHisNum = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000I15", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000I16", "SELECT CliCod, ConCodigo, ForHisNum FROM FormulaHistorico ORDER BY CliCod, ConCodigo, ForHisNum ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000I17", "SELECT CliCod FROM Importacion WHERE CliCod = ? AND ImpSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((long[]) buf[7])[0] = rslt.getLong(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getString(8, 10);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((long[]) buf[7])[0] = rslt.getLong(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getString(8, 10);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(3);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((int[]) buf[9])[0] = rslt.getInt(8);
               ((long[]) buf[10])[0] = rslt.getLong(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getString(10, 10);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
               stmt.setString(2, (String)parms[1], 10);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(2, ((Number) parms[2]).longValue());
               }
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(2, ((Number) parms[2]).longValue());
               }
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 10);
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 10);
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setDateTime(2, (java.util.Date)parms[1], false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(3, (String)parms[3]);
               }
               stmt.setNLongVarchar(4, (String)parms[4], false);
               stmt.setVarchar(5, (String)parms[5], 100, false);
               stmt.setInt(6, ((Number) parms[6]).intValue());
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(7, ((Number) parms[8]).longValue());
               }
               stmt.setString(8, (String)parms[9], 10);
               return;
            case 11 :
               stmt.setDateTime(1, (java.util.Date)parms[0], false);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(2, (String)parms[2]);
               }
               stmt.setNLongVarchar(3, (String)parms[3], false);
               stmt.setVarchar(4, (String)parms[4], 100, false);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(5, ((Number) parms[6]).longValue());
               }
               stmt.setInt(6, ((Number) parms[7]).intValue());
               stmt.setString(7, (String)parms[8], 10);
               stmt.setShort(8, ((Number) parms[9]).shortValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(2, ((Number) parms[2]).longValue());
               }
               return;
      }
   }

}

