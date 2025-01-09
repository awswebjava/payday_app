package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class archivo_siradig_impl extends GXDataArea
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
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_6( A3CliCod, A1EmpCod) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "archivo_siradig", ""), (short)(0)) ;
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

   public archivo_siradig_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public archivo_siradig_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( archivo_siradig_impl.class ));
   }

   public archivo_siradig_impl( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbArchSiradigEstado = new HTMLChoice();
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
      if ( cmbArchSiradigEstado.getItemCount() > 0 )
      {
         A565ArchSiradigEstado = (short)(GXutil.lval( cmbArchSiradigEstado.getValidValue(GXutil.trim( GXutil.str( A565ArchSiradigEstado, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A565ArchSiradigEstado", GXutil.ltrimstr( DecimalUtil.doubleToDec(A565ArchSiradigEstado), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbArchSiradigEstado.setValue( GXutil.trim( GXutil.str( A565ArchSiradigEstado, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbArchSiradigEstado.getInternalname(), "Values", cmbArchSiradigEstado.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "archivo_siradig", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_archivo_siradig.htm");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_archivo_siradig.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_archivo_siradig.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_archivo_siradig.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_archivo_siradig.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_archivo_siradig.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_archivo_siradig.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_archivo_siradig.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArchSiradigFec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtArchSiradigFec_Internalname, httpContext.getMessage( "Siradig Fec", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtArchSiradigFec_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtArchSiradigFec_Internalname, localUtil.ttoc( A85ArchSiradigFec, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A85ArchSiradigFec, "99/99/99 99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtArchSiradigFec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtArchSiradigFec_Enabled, 0, "text", "", 14, "chr", 1, "row", 14, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_archivo_siradig.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtArchSiradigFec_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtArchSiradigFec_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_archivo_siradig.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArchSiradigFile_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtArchSiradigFile_Internalname, httpContext.getMessage( "Siradig File", ""), "col-sm-3 ImageLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      ClassString = "Image" ;
      StyleString = "" ;
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      edtArchSiradigFile_Filename = A564ArchSiradigName ;
      edtArchSiradigFile_Filetype = "" ;
      httpContext.ajax_rsp_assign_prop("", false, edtArchSiradigFile_Internalname, "Filetype", edtArchSiradigFile_Filetype, true);
      edtArchSiradigFile_Filetype = A563ArchSiradigType ;
      httpContext.ajax_rsp_assign_prop("", false, edtArchSiradigFile_Internalname, "Filetype", edtArchSiradigFile_Filetype, true);
      if ( ! (GXutil.strcmp("", A562ArchSiradigFile)==0) )
      {
         gxblobfileaux.setSource( A562ArchSiradigFile );
         if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtArchSiradigFile_Filetype, "tmp") != 0 ) )
         {
            gxblobfileaux.setExt(GXutil.trim( edtArchSiradigFile_Filetype));
         }
         if ( gxblobfileaux.getErrCode() == 0 )
         {
            A562ArchSiradigFile = gxblobfileaux.getURI() ;
            httpContext.ajax_rsp_assign_attri("", false, "A562ArchSiradigFile", A562ArchSiradigFile);
            httpContext.ajax_rsp_assign_prop("", false, edtArchSiradigFile_Internalname, "URL", httpContext.getResourceRelative(A562ArchSiradigFile), true);
            edtArchSiradigFile_Filetype = gxblobfileaux.getExtension() ;
            httpContext.ajax_rsp_assign_prop("", false, edtArchSiradigFile_Internalname, "Filetype", edtArchSiradigFile_Filetype, true);
            gxblobfileaux.setBlobToDelete();
         }
         httpContext.ajax_rsp_assign_prop("", false, edtArchSiradigFile_Internalname, "URL", httpContext.getResourceRelative(A562ArchSiradigFile), true);
      }
      web.GxWebStd.gx_blob_field( httpContext, edtArchSiradigFile_Internalname, GXutil.rtrim( A562ArchSiradigFile), httpContext.getResourceRelative(A562ArchSiradigFile), ((GXutil.strcmp("", edtArchSiradigFile_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtArchSiradigFile_Filetype)==0) ? A562ArchSiradigFile : edtArchSiradigFile_Filetype)) : edtArchSiradigFile_Contenttype), true, "", edtArchSiradigFile_Parameters, 0, edtArchSiradigFile_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtArchSiradigFile_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", "", "", "HLP_archivo_siradig.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbArchSiradigEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbArchSiradigEstado.getInternalname(), httpContext.getMessage( "Siradig Estado", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbArchSiradigEstado, cmbArchSiradigEstado.getInternalname(), GXutil.trim( GXutil.str( A565ArchSiradigEstado, 4, 0)), 1, cmbArchSiradigEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbArchSiradigEstado.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", "", true, (byte)(0), "HLP_archivo_siradig.htm");
      cmbArchSiradigEstado.setValue( GXutil.trim( GXutil.str( A565ArchSiradigEstado, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbArchSiradigEstado.getInternalname(), "Values", cmbArchSiradigEstado.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArchSiradigError_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtArchSiradigError_Internalname, httpContext.getMessage( "Siradig Error", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtArchSiradigError_Internalname, A566ArchSiradigError, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", (short)(0), 1, edtArchSiradigError_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "error", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_archivo_siradig.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtArchSirdigNameAndType_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtArchSirdigNameAndType_Internalname, httpContext.getMessage( "And Type", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtArchSirdigNameAndType_Internalname, A567ArchSirdigNameAndType, "", "", (short)(0), 1, edtArchSirdigNameAndType_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "Descrip", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_archivo_siradig.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_archivo_siradig.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_archivo_siradig.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_archivo_siradig.htm");
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
         Z85ArchSiradigFec = localUtil.ctot( httpContext.cgiGet( "Z85ArchSiradigFec"), 0) ;
         Z565ArchSiradigEstado = (short)(localUtil.ctol( httpContext.cgiGet( "Z565ArchSiradigEstado"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z566ArchSiradigError = httpContext.cgiGet( "Z566ArchSiradigError") ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         A564ArchSiradigName = httpContext.cgiGet( "ARCHSIRADIGNAME") ;
         A563ArchSiradigType = httpContext.cgiGet( "ARCHSIRADIGTYPE") ;
         edtArchSiradigFile_Filetype = httpContext.cgiGet( "ARCHSIRADIGFILE_Filetype") ;
         edtArchSiradigFile_Filename = httpContext.cgiGet( "ARCHSIRADIGFILE_Filename") ;
         edtArchSiradigFile_Filename = httpContext.cgiGet( "ARCHSIRADIGFILE_Filename") ;
         edtArchSiradigFile_Filetype = httpContext.cgiGet( "ARCHSIRADIGFILE_Filetype") ;
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
         if ( localUtil.vcdtime( httpContext.cgiGet( edtArchSiradigFec_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "ARCHSIRADIGFEC");
            AnyError = (short)(1) ;
            GX_FocusControl = edtArchSiradigFec_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A85ArchSiradigFec = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "A85ArchSiradigFec", localUtil.ttoc( A85ArchSiradigFec, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            A85ArchSiradigFec = localUtil.ctot( httpContext.cgiGet( edtArchSiradigFec_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A85ArchSiradigFec", localUtil.ttoc( A85ArchSiradigFec, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         A562ArchSiradigFile = httpContext.cgiGet( edtArchSiradigFile_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A562ArchSiradigFile", A562ArchSiradigFile);
         cmbArchSiradigEstado.setValue( httpContext.cgiGet( cmbArchSiradigEstado.getInternalname()) );
         A565ArchSiradigEstado = (short)(GXutil.lval( httpContext.cgiGet( cmbArchSiradigEstado.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A565ArchSiradigEstado", GXutil.ltrimstr( DecimalUtil.doubleToDec(A565ArchSiradigEstado), 4, 0));
         A566ArchSiradigError = httpContext.cgiGet( edtArchSiradigError_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A566ArchSiradigError", A566ArchSiradigError);
         A567ArchSirdigNameAndType = httpContext.cgiGet( edtArchSirdigNameAndType_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A567ArchSirdigNameAndType", A567ArchSirdigNameAndType);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         if ( ! (GXutil.strcmp("", A562ArchSiradigFile)==0) )
         {
            edtArchSiradigFile_Filename = httpContext.cgiGetFileName( edtArchSiradigFile_Internalname) ;
            edtArchSiradigFile_Filetype = httpContext.cgiGetFileType( edtArchSiradigFile_Internalname) ;
         }
         A563ArchSiradigType = edtArchSiradigFile_Filetype ;
         httpContext.ajax_rsp_assign_attri("", false, "A563ArchSiradigType", A563ArchSiradigType);
         A564ArchSiradigName = edtArchSiradigFile_Filename ;
         httpContext.ajax_rsp_assign_attri("", false, "A564ArchSiradigName", A564ArchSiradigName);
         if ( (GXutil.strcmp("", A562ArchSiradigFile)==0) )
         {
            GXCCtlgxBlob = "ARCHSIRADIGFILE" + "_gxBlob" ;
            A562ArchSiradigFile = httpContext.cgiGet( GXCCtlgxBlob) ;
         }
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
            A85ArchSiradigFec = localUtil.parseDTimeParm( httpContext.GetPar( "ArchSiradigFec")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A85ArchSiradigFec", localUtil.ttoc( A85ArchSiradigFec, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            getEqualNoModal( ) ;
            A85ArchSiradigFec = GXutil.serverNow( context, remoteHandle, pr_default) ;
            httpContext.ajax_rsp_assign_attri("", false, "A85ArchSiradigFec", localUtil.ttoc( A85ArchSiradigFec, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
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
            initAll0373( ) ;
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
      disableAttributes0373( ) ;
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

   public void resetCaption030( )
   {
   }

   public void zm0373( int GX_JID )
   {
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z565ArchSiradigEstado = T00033_A565ArchSiradigEstado[0] ;
            Z566ArchSiradigError = T00033_A566ArchSiradigError[0] ;
         }
         else
         {
            Z565ArchSiradigEstado = A565ArchSiradigEstado ;
            Z566ArchSiradigError = A566ArchSiradigError ;
         }
      }
      if ( GX_JID == -5 )
      {
         Z85ArchSiradigFec = A85ArchSiradigFec ;
         Z565ArchSiradigEstado = A565ArchSiradigEstado ;
         Z562ArchSiradigFile = A562ArchSiradigFile ;
         Z566ArchSiradigError = A566ArchSiradigError ;
         Z563ArchSiradigType = A563ArchSiradigType ;
         Z564ArchSiradigName = A564ArchSiradigName ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
      A85ArchSiradigFec = GXutil.serverNow( context, remoteHandle, pr_default) ;
      httpContext.ajax_rsp_assign_attri("", false, "A85ArchSiradigFec", localUtil.ttoc( A85ArchSiradigFec, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A565ArchSiradigEstado = (short)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "A565ArchSiradigEstado", GXutil.ltrimstr( DecimalUtil.doubleToDec(A565ArchSiradigEstado), 4, 0));
      A567ArchSirdigNameAndType = GXutil.trim( A564ArchSiradigName) + " ." + GXutil.trim( A563ArchSiradigType) ;
      httpContext.ajax_rsp_assign_attri("", false, "A567ArchSirdigNameAndType", A567ArchSirdigNameAndType);
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0373( )
   {
      /* Using cursor T00035 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A85ArchSiradigFec});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound73 = (short)(1) ;
         A565ArchSiradigEstado = T00035_A565ArchSiradigEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A565ArchSiradigEstado", GXutil.ltrimstr( DecimalUtil.doubleToDec(A565ArchSiradigEstado), 4, 0));
         A562ArchSiradigFile = T00035_A562ArchSiradigFile[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A562ArchSiradigFile", A562ArchSiradigFile);
         httpContext.ajax_rsp_assign_prop("", false, edtArchSiradigFile_Internalname, "URL", httpContext.getResourceRelative(A562ArchSiradigFile), true);
         A566ArchSiradigError = T00035_A566ArchSiradigError[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A566ArchSiradigError", A566ArchSiradigError);
         A563ArchSiradigType = T00035_A563ArchSiradigType[0] ;
         edtArchSiradigFile_Filetype = A563ArchSiradigType ;
         httpContext.ajax_rsp_assign_prop("", false, edtArchSiradigFile_Internalname, "Filetype", edtArchSiradigFile_Filetype, true);
         A564ArchSiradigName = T00035_A564ArchSiradigName[0] ;
         edtArchSiradigFile_Filename = A564ArchSiradigName ;
         zm0373( -5) ;
      }
      pr_default.close(3);
      onLoadActions0373( ) ;
   }

   public void onLoadActions0373( )
   {
   }

   public void checkExtendedTable0373( )
   {
      nIsDirty_73 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T00034 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( A565ArchSiradigEstado == 1 ) || ( A565ArchSiradigEstado == 2 ) || ( A565ArchSiradigEstado == 3 ) || ( A565ArchSiradigEstado == 4 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Arch Siradig Estado", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "ARCHSIRADIGESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbArchSiradigEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0373( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_6( int A3CliCod ,
                         short A1EmpCod )
   {
      /* Using cursor T00036 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
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

   public void getKey0373( )
   {
      /* Using cursor T00037 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A85ArchSiradigFec});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound73 = (short)(1) ;
      }
      else
      {
         RcdFound73 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00033 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A85ArchSiradigFec});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0373( 5) ;
         RcdFound73 = (short)(1) ;
         A85ArchSiradigFec = T00033_A85ArchSiradigFec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A85ArchSiradigFec", localUtil.ttoc( A85ArchSiradigFec, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A565ArchSiradigEstado = T00033_A565ArchSiradigEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A565ArchSiradigEstado", GXutil.ltrimstr( DecimalUtil.doubleToDec(A565ArchSiradigEstado), 4, 0));
         A562ArchSiradigFile = T00033_A562ArchSiradigFile[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A562ArchSiradigFile", A562ArchSiradigFile);
         httpContext.ajax_rsp_assign_prop("", false, edtArchSiradigFile_Internalname, "URL", httpContext.getResourceRelative(A562ArchSiradigFile), true);
         A566ArchSiradigError = T00033_A566ArchSiradigError[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A566ArchSiradigError", A566ArchSiradigError);
         A563ArchSiradigType = T00033_A563ArchSiradigType[0] ;
         edtArchSiradigFile_Filetype = A563ArchSiradigType ;
         httpContext.ajax_rsp_assign_prop("", false, edtArchSiradigFile_Internalname, "Filetype", edtArchSiradigFile_Filetype, true);
         A564ArchSiradigName = T00033_A564ArchSiradigName[0] ;
         edtArchSiradigFile_Filename = A564ArchSiradigName ;
         A3CliCod = T00033_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T00033_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z85ArchSiradigFec = A85ArchSiradigFec ;
         sMode73 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0373( ) ;
         if ( AnyError == 1 )
         {
            RcdFound73 = (short)(0) ;
            initializeNonKey0373( ) ;
         }
         Gx_mode = sMode73 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound73 = (short)(0) ;
         initializeNonKey0373( ) ;
         sMode73 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode73 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0373( ) ;
      if ( RcdFound73 == 0 )
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
      RcdFound73 = (short)(0) ;
      /* Using cursor T00038 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A85ArchSiradigFec});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00038_A3CliCod[0] < A3CliCod ) || ( T00038_A3CliCod[0] == A3CliCod ) && ( T00038_A1EmpCod[0] < A1EmpCod ) || ( T00038_A1EmpCod[0] == A1EmpCod ) && ( T00038_A3CliCod[0] == A3CliCod ) && T00038_A85ArchSiradigFec[0].before( A85ArchSiradigFec ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00038_A3CliCod[0] > A3CliCod ) || ( T00038_A3CliCod[0] == A3CliCod ) && ( T00038_A1EmpCod[0] > A1EmpCod ) || ( T00038_A1EmpCod[0] == A1EmpCod ) && ( T00038_A3CliCod[0] == A3CliCod ) && T00038_A85ArchSiradigFec[0].after( A85ArchSiradigFec ) ) )
         {
            A3CliCod = T00038_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T00038_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A85ArchSiradigFec = T00038_A85ArchSiradigFec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A85ArchSiradigFec", localUtil.ttoc( A85ArchSiradigFec, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            RcdFound73 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound73 = (short)(0) ;
      /* Using cursor T00039 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A85ArchSiradigFec});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00039_A3CliCod[0] > A3CliCod ) || ( T00039_A3CliCod[0] == A3CliCod ) && ( T00039_A1EmpCod[0] > A1EmpCod ) || ( T00039_A1EmpCod[0] == A1EmpCod ) && ( T00039_A3CliCod[0] == A3CliCod ) && T00039_A85ArchSiradigFec[0].after( A85ArchSiradigFec ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00039_A3CliCod[0] < A3CliCod ) || ( T00039_A3CliCod[0] == A3CliCod ) && ( T00039_A1EmpCod[0] < A1EmpCod ) || ( T00039_A1EmpCod[0] == A1EmpCod ) && ( T00039_A3CliCod[0] == A3CliCod ) && T00039_A85ArchSiradigFec[0].before( A85ArchSiradigFec ) ) )
         {
            A3CliCod = T00039_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T00039_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A85ArchSiradigFec = T00039_A85ArchSiradigFec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A85ArchSiradigFec", localUtil.ttoc( A85ArchSiradigFec, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            RcdFound73 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0373( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0373( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound73 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || !( GXutil.dateCompare(A85ArchSiradigFec, Z85ArchSiradigFec) ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A85ArchSiradigFec = Z85ArchSiradigFec ;
               httpContext.ajax_rsp_assign_attri("", false, "A85ArchSiradigFec", localUtil.ttoc( A85ArchSiradigFec, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
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
               update0373( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || !( GXutil.dateCompare(A85ArchSiradigFec, Z85ArchSiradigFec) ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0373( ) ;
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
                  insert0373( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || !( GXutil.dateCompare(A85ArchSiradigFec, Z85ArchSiradigFec) ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A85ArchSiradigFec = Z85ArchSiradigFec ;
         httpContext.ajax_rsp_assign_attri("", false, "A85ArchSiradigFec", localUtil.ttoc( A85ArchSiradigFec, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
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
      if ( RcdFound73 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtArchSiradigFile_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0373( ) ;
      if ( RcdFound73 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtArchSiradigFile_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0373( ) ;
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
      if ( RcdFound73 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtArchSiradigFile_Internalname ;
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
      if ( RcdFound73 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtArchSiradigFile_Internalname ;
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
      scanStart0373( ) ;
      if ( RcdFound73 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound73 != 0 )
         {
            scanNext0373( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtArchSiradigFile_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0373( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0373( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00032 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A85ArchSiradigFec});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"archivo_siradig"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z565ArchSiradigEstado != T00032_A565ArchSiradigEstado[0] ) || ( GXutil.strcmp(Z566ArchSiradigError, T00032_A566ArchSiradigError[0]) != 0 ) )
         {
            if ( Z565ArchSiradigEstado != T00032_A565ArchSiradigEstado[0] )
            {
               GXutil.writeLogln("archivo_siradig:[seudo value changed for attri]"+"ArchSiradigEstado");
               GXutil.writeLogRaw("Old: ",Z565ArchSiradigEstado);
               GXutil.writeLogRaw("Current: ",T00032_A565ArchSiradigEstado[0]);
            }
            if ( GXutil.strcmp(Z566ArchSiradigError, T00032_A566ArchSiradigError[0]) != 0 )
            {
               GXutil.writeLogln("archivo_siradig:[seudo value changed for attri]"+"ArchSiradigError");
               GXutil.writeLogRaw("Old: ",Z566ArchSiradigError);
               GXutil.writeLogRaw("Current: ",T00032_A566ArchSiradigError[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"archivo_siradig"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0373( )
   {
      beforeValidate0373( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0373( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0373( 0) ;
         checkOptimisticConcurrency0373( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0373( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0373( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000310 */
                  A563ArchSiradigType = edtArchSiradigFile_Filetype ;
                  httpContext.ajax_rsp_assign_attri("", false, "A563ArchSiradigType", A563ArchSiradigType);
                  A564ArchSiradigName = edtArchSiradigFile_Filename ;
                  httpContext.ajax_rsp_assign_attri("", false, "A564ArchSiradigName", A564ArchSiradigName);
                  pr_default.execute(8, new Object[] {A85ArchSiradigFec, Short.valueOf(A565ArchSiradigEstado), A562ArchSiradigFile, A566ArchSiradigError, A563ArchSiradigType, A564ArchSiradigName, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("archivo_siradig");
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
                        resetCaption030( ) ;
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
            load0373( ) ;
         }
         endLevel0373( ) ;
      }
      closeExtendedTableCursors0373( ) ;
   }

   public void update0373( )
   {
      beforeValidate0373( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0373( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0373( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0373( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0373( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000311 */
                  A563ArchSiradigType = edtArchSiradigFile_Filetype ;
                  httpContext.ajax_rsp_assign_attri("", false, "A563ArchSiradigType", A563ArchSiradigType);
                  A564ArchSiradigName = edtArchSiradigFile_Filename ;
                  httpContext.ajax_rsp_assign_attri("", false, "A564ArchSiradigName", A564ArchSiradigName);
                  pr_default.execute(9, new Object[] {Short.valueOf(A565ArchSiradigEstado), A566ArchSiradigError, A563ArchSiradigType, A564ArchSiradigName, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A85ArchSiradigFec});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("archivo_siradig");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"archivo_siradig"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0373( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption030( ) ;
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
         endLevel0373( ) ;
      }
      closeExtendedTableCursors0373( ) ;
   }

   public void deferredUpdate0373( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T000312 */
         pr_default.execute(10, new Object[] {A562ArchSiradigFile, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A85ArchSiradigFec});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("archivo_siradig");
      }
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0373( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0373( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0373( ) ;
         afterConfirm0373( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0373( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000313 */
               pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A85ArchSiradigFec});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("archivo_siradig");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound73 == 0 )
                     {
                        initAll0373( ) ;
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
                     resetCaption030( ) ;
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
      sMode73 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0373( ) ;
      Gx_mode = sMode73 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0373( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0373( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0373( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "archivo_siradig");
         if ( AnyError == 0 )
         {
            confirmValues030( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "archivo_siradig");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0373( )
   {
      /* Using cursor T000314 */
      pr_default.execute(12);
      RcdFound73 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound73 = (short)(1) ;
         A3CliCod = T000314_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T000314_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A85ArchSiradigFec = T000314_A85ArchSiradigFec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A85ArchSiradigFec", localUtil.ttoc( A85ArchSiradigFec, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0373( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound73 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound73 = (short)(1) ;
         A3CliCod = T000314_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T000314_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A85ArchSiradigFec = T000314_A85ArchSiradigFec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A85ArchSiradigFec", localUtil.ttoc( A85ArchSiradigFec, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      }
   }

   public void scanEnd0373( )
   {
      pr_default.close(12);
   }

   public void afterConfirm0373( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0373( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0373( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0373( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0373( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0373( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0373( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtArchSiradigFec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArchSiradigFec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArchSiradigFec_Enabled), 5, 0), true);
      edtArchSiradigFile_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArchSiradigFile_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArchSiradigFile_Enabled), 5, 0), true);
      cmbArchSiradigEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbArchSiradigEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbArchSiradigEstado.getEnabled(), 5, 0), true);
      edtArchSiradigError_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArchSiradigError_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArchSiradigError_Enabled), 5, 0), true);
      edtArchSirdigNameAndType_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArchSirdigNameAndType_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArchSirdigNameAndType_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0373( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues030( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.archivo_siradig", new String[] {}, new String[] {}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "Z85ArchSiradigFec", localUtil.ttoc( Z85ArchSiradigFec, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "Z565ArchSiradigEstado", GXutil.ltrim( localUtil.ntoc( Z565ArchSiradigEstado, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z566ArchSiradigError", Z566ArchSiradigError);
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "ARCHSIRADIGNAME", A564ArchSiradigName);
      web.GxWebStd.gx_hidden_field( httpContext, "ARCHSIRADIGTYPE", GXutil.rtrim( A563ArchSiradigType));
      GXCCtlgxBlob = "ARCHSIRADIGFILE" + "_gxBlob" ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A562ArchSiradigFile);
      web.GxWebStd.gx_hidden_field( httpContext, "ARCHSIRADIGFILE_Filetype", GXutil.rtrim( edtArchSiradigFile_Filetype));
      web.GxWebStd.gx_hidden_field( httpContext, "ARCHSIRADIGFILE_Filename", GXutil.rtrim( edtArchSiradigFile_Filename));
      web.GxWebStd.gx_hidden_field( httpContext, "ARCHSIRADIGFILE_Filename", GXutil.rtrim( edtArchSiradigFile_Filename));
      web.GxWebStd.gx_hidden_field( httpContext, "ARCHSIRADIGFILE_Filetype", GXutil.rtrim( edtArchSiradigFile_Filetype));
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
      return formatLink("web.archivo_siradig", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "archivo_siradig" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "archivo_siradig", "") ;
   }

   public void initializeNonKey0373( )
   {
      A565ArchSiradigEstado = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A565ArchSiradigEstado", GXutil.ltrimstr( DecimalUtil.doubleToDec(A565ArchSiradigEstado), 4, 0));
      A567ArchSirdigNameAndType = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A567ArchSirdigNameAndType", A567ArchSirdigNameAndType);
      A562ArchSiradigFile = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A562ArchSiradigFile", A562ArchSiradigFile);
      httpContext.ajax_rsp_assign_prop("", false, edtArchSiradigFile_Internalname, "URL", httpContext.getResourceRelative(A562ArchSiradigFile), true);
      A566ArchSiradigError = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A566ArchSiradigError", A566ArchSiradigError);
      A563ArchSiradigType = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A563ArchSiradigType", A563ArchSiradigType);
      A564ArchSiradigName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A564ArchSiradigName", A564ArchSiradigName);
      Z565ArchSiradigEstado = (short)(0) ;
      Z566ArchSiradigError = "" ;
   }

   public void initAll0373( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A85ArchSiradigFec = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "A85ArchSiradigFec", localUtil.ttoc( A85ArchSiradigFec, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      initializeNonKey0373( ) ;
   }

   public void standaloneModalInsert( )
   {
      A565ArchSiradigEstado = i565ArchSiradigEstado ;
      httpContext.ajax_rsp_assign_attri("", false, "A565ArchSiradigEstado", GXutil.ltrimstr( DecimalUtil.doubleToDec(A565ArchSiradigEstado), 4, 0));
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025139315072", true, true);
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
      httpContext.AddJavascriptSource("archivo_siradig.js", "?2025139315072", false, true);
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
      edtArchSiradigFec_Internalname = "ARCHSIRADIGFEC" ;
      edtArchSiradigFile_Internalname = "ARCHSIRADIGFILE" ;
      cmbArchSiradigEstado.setInternalname( "ARCHSIRADIGESTADO" );
      edtArchSiradigError_Internalname = "ARCHSIRADIGERROR" ;
      edtArchSirdigNameAndType_Internalname = "ARCHSIRDIGNAMEANDTYPE" ;
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
      Form.setCaption( httpContext.getMessage( "archivo_siradig", "") );
      edtArchSiradigFile_Filename = "" ;
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtArchSirdigNameAndType_Enabled = 0 ;
      edtArchSiradigError_Enabled = 1 ;
      cmbArchSiradigEstado.setJsonclick( "" );
      cmbArchSiradigEstado.setEnabled( 1 );
      edtArchSiradigFile_Jsonclick = "" ;
      edtArchSiradigFile_Parameters = "" ;
      edtArchSiradigFile_Contenttype = "" ;
      edtArchSiradigFile_Filetype = "" ;
      edtArchSiradigFile_Enabled = 1 ;
      edtArchSiradigFec_Jsonclick = "" ;
      edtArchSiradigFec_Enabled = 1 ;
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
      cmbArchSiradigEstado.setName( "ARCHSIRADIGESTADO" );
      cmbArchSiradigEstado.setWebtags( "" );
      cmbArchSiradigEstado.addItem("1", httpContext.getMessage( "Subido", ""), (short)(0));
      cmbArchSiradigEstado.addItem("2", httpContext.getMessage( "Validado", ""), (short)(0));
      cmbArchSiradigEstado.addItem("3", httpContext.getMessage( "Duplicado", ""), (short)(0));
      cmbArchSiradigEstado.addItem("4", httpContext.getMessage( "Error Formato", ""), (short)(0));
      if ( cmbArchSiradigEstado.getItemCount() > 0 )
      {
         A565ArchSiradigEstado = (short)(GXutil.lval( cmbArchSiradigEstado.getValidValue(GXutil.trim( GXutil.str( A565ArchSiradigEstado, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A565ArchSiradigEstado", GXutil.ltrimstr( DecimalUtil.doubleToDec(A565ArchSiradigEstado), 4, 0));
      }
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      /* Using cursor T000315 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(13);
      GX_FocusControl = edtArchSiradigFile_Internalname ;
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

   public void valid_Empcod( )
   {
      /* Using cursor T000315 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Archsiradigfec( )
   {
      A565ArchSiradigEstado = (short)(GXutil.lval( cmbArchSiradigEstado.getValue())) ;
      cmbArchSiradigEstado.setValue( GXutil.ltrimstr( DecimalUtil.doubleToDec(A565ArchSiradigEstado), 4, 0) );
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      if ( cmbArchSiradigEstado.getItemCount() > 0 )
      {
         A565ArchSiradigEstado = (short)(GXutil.lval( cmbArchSiradigEstado.getValidValue(GXutil.trim( GXutil.str( A565ArchSiradigEstado, 4, 0))))) ;
         cmbArchSiradigEstado.setValue( GXutil.ltrimstr( DecimalUtil.doubleToDec(A565ArchSiradigEstado), 4, 0) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbArchSiradigEstado.setValue( GXutil.trim( GXutil.str( A565ArchSiradigEstado, 4, 0)) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A565ArchSiradigEstado", GXutil.ltrim( localUtil.ntoc( A565ArchSiradigEstado, (byte)(4), (byte)(0), ".", "")));
      cmbArchSiradigEstado.setValue( GXutil.trim( GXutil.str( A565ArchSiradigEstado, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbArchSiradigEstado.getInternalname(), "Values", cmbArchSiradigEstado.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A567ArchSirdigNameAndType", A567ArchSirdigNameAndType);
      httpContext.ajax_rsp_assign_attri("", false, "A562ArchSiradigFile", httpContext.getResourceRelative(A562ArchSiradigFile));
      httpContext.ajax_rsp_assign_attri("", false, "A566ArchSiradigError", A566ArchSiradigError);
      httpContext.ajax_rsp_assign_attri("", false, "A563ArchSiradigType", GXutil.rtrim( A563ArchSiradigType));
      httpContext.ajax_rsp_assign_attri("", false, "A564ArchSiradigName", A564ArchSiradigName);
      httpContext.ajax_rsp_assign_prop("", false, edtArchSiradigFile_Internalname, "Filetype", edtArchSiradigFile_Filetype, true);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z85ArchSiradigFec", localUtil.ttoc( Z85ArchSiradigFec, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "Z565ArchSiradigEstado", GXutil.ltrim( localUtil.ntoc( Z565ArchSiradigEstado, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z567ArchSirdigNameAndType", Z567ArchSirdigNameAndType);
      web.GxWebStd.gx_hidden_field( httpContext, "Z562ArchSiradigFile", httpContext.getResourceRelative(Z562ArchSiradigFile));
      web.GxWebStd.gx_hidden_field( httpContext, "Z566ArchSiradigError", Z566ArchSiradigError);
      web.GxWebStd.gx_hidden_field( httpContext, "Z563ArchSiradigType", GXutil.rtrim( Z563ArchSiradigType));
      web.GxWebStd.gx_hidden_field( httpContext, "Z564ArchSiradigName", Z564ArchSiradigName);
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
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_ARCHSIRADIGFEC","{handler:'valid_Archsiradigfec',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A85ArchSiradigFec',fld:'ARCHSIRADIGFEC',pic:'99/99/99 99:99'},{av:'A564ArchSiradigName',fld:'ARCHSIRADIGNAME',pic:''},{av:'A563ArchSiradigType',fld:'ARCHSIRADIGTYPE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'cmbArchSiradigEstado'},{av:'A565ArchSiradigEstado',fld:'ARCHSIRADIGESTADO',pic:'ZZZ9'}]");
      setEventMetadata("VALID_ARCHSIRADIGFEC",",oparms:[{av:'cmbArchSiradigEstado'},{av:'A565ArchSiradigEstado',fld:'ARCHSIRADIGESTADO',pic:'ZZZ9'},{av:'A567ArchSirdigNameAndType',fld:'ARCHSIRDIGNAMEANDTYPE',pic:''},{av:'A562ArchSiradigFile',fld:'ARCHSIRADIGFILE',pic:''},{av:'A566ArchSiradigError',fld:'ARCHSIRADIGERROR',pic:''},{av:'A563ArchSiradigType',fld:'ARCHSIRADIGTYPE',pic:''},{av:'A564ArchSiradigName',fld:'ARCHSIRADIGNAME',pic:''},{av:'edtArchSiradigFile_Filetype',ctrl:'ARCHSIRADIGFILE',prop:'Filetype'},{av:'edtArchSiradigFile_Filename',ctrl:'ARCHSIRADIGFILE',prop:'Filename'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z3CliCod'},{av:'Z1EmpCod'},{av:'Z85ArchSiradigFec'},{av:'Z565ArchSiradigEstado'},{av:'Z567ArchSirdigNameAndType'},{av:'Z562ArchSiradigFile'},{av:'Z566ArchSiradigError'},{av:'Z563ArchSiradigType'},{av:'Z564ArchSiradigName'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_ARCHSIRADIGESTADO","{handler:'valid_Archsiradigestado',iparms:[]");
      setEventMetadata("VALID_ARCHSIRADIGESTADO",",oparms:[]}");
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
      pr_default.close(13);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z85ArchSiradigFec = GXutil.resetTime( GXutil.nullDate() );
      Z566ArchSiradigError = "" ;
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
      A85ArchSiradigFec = GXutil.resetTime( GXutil.nullDate() );
      A564ArchSiradigName = "" ;
      A563ArchSiradigType = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      A562ArchSiradigFile = "" ;
      A566ArchSiradigError = "" ;
      A567ArchSirdigNameAndType = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gx_mode = "" ;
      GXCCtlgxBlob = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z562ArchSiradigFile = "" ;
      Z563ArchSiradigType = "" ;
      Z564ArchSiradigName = "" ;
      T00035_A85ArchSiradigFec = new java.util.Date[] {GXutil.nullDate()} ;
      T00035_A565ArchSiradigEstado = new short[1] ;
      T00035_A562ArchSiradigFile = new String[] {""} ;
      T00035_A566ArchSiradigError = new String[] {""} ;
      T00035_A563ArchSiradigType = new String[] {""} ;
      T00035_A564ArchSiradigName = new String[] {""} ;
      T00035_A3CliCod = new int[1] ;
      T00035_A1EmpCod = new short[1] ;
      T00034_A3CliCod = new int[1] ;
      T00036_A3CliCod = new int[1] ;
      T00037_A3CliCod = new int[1] ;
      T00037_A1EmpCod = new short[1] ;
      T00037_A85ArchSiradigFec = new java.util.Date[] {GXutil.nullDate()} ;
      T00033_A85ArchSiradigFec = new java.util.Date[] {GXutil.nullDate()} ;
      T00033_A565ArchSiradigEstado = new short[1] ;
      T00033_A562ArchSiradigFile = new String[] {""} ;
      T00033_A566ArchSiradigError = new String[] {""} ;
      T00033_A563ArchSiradigType = new String[] {""} ;
      T00033_A564ArchSiradigName = new String[] {""} ;
      T00033_A3CliCod = new int[1] ;
      T00033_A1EmpCod = new short[1] ;
      sMode73 = "" ;
      T00038_A3CliCod = new int[1] ;
      T00038_A1EmpCod = new short[1] ;
      T00038_A85ArchSiradigFec = new java.util.Date[] {GXutil.nullDate()} ;
      T00039_A3CliCod = new int[1] ;
      T00039_A1EmpCod = new short[1] ;
      T00039_A85ArchSiradigFec = new java.util.Date[] {GXutil.nullDate()} ;
      T00032_A85ArchSiradigFec = new java.util.Date[] {GXutil.nullDate()} ;
      T00032_A565ArchSiradigEstado = new short[1] ;
      T00032_A562ArchSiradigFile = new String[] {""} ;
      T00032_A566ArchSiradigError = new String[] {""} ;
      T00032_A563ArchSiradigType = new String[] {""} ;
      T00032_A564ArchSiradigName = new String[] {""} ;
      T00032_A3CliCod = new int[1] ;
      T00032_A1EmpCod = new short[1] ;
      T000314_A3CliCod = new int[1] ;
      T000314_A1EmpCod = new short[1] ;
      T000314_A85ArchSiradigFec = new java.util.Date[] {GXutil.nullDate()} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T000315_A3CliCod = new int[1] ;
      Z567ArchSirdigNameAndType = "" ;
      ZZ85ArchSiradigFec = GXutil.resetTime( GXutil.nullDate() );
      ZZ567ArchSirdigNameAndType = "" ;
      ZZ562ArchSiradigFile = "" ;
      ZZ566ArchSiradigError = "" ;
      ZZ563ArchSiradigType = "" ;
      ZZ564ArchSiradigName = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.archivo_siradig__default(),
         new Object[] {
             new Object[] {
            T00032_A85ArchSiradigFec, T00032_A565ArchSiradigEstado, T00032_A562ArchSiradigFile, T00032_A566ArchSiradigError, T00032_A563ArchSiradigType, T00032_A564ArchSiradigName, T00032_A3CliCod, T00032_A1EmpCod
            }
            , new Object[] {
            T00033_A85ArchSiradigFec, T00033_A565ArchSiradigEstado, T00033_A562ArchSiradigFile, T00033_A566ArchSiradigError, T00033_A563ArchSiradigType, T00033_A564ArchSiradigName, T00033_A3CliCod, T00033_A1EmpCod
            }
            , new Object[] {
            T00034_A3CliCod
            }
            , new Object[] {
            T00035_A85ArchSiradigFec, T00035_A565ArchSiradigEstado, T00035_A562ArchSiradigFile, T00035_A566ArchSiradigError, T00035_A563ArchSiradigType, T00035_A564ArchSiradigName, T00035_A3CliCod, T00035_A1EmpCod
            }
            , new Object[] {
            T00036_A3CliCod
            }
            , new Object[] {
            T00037_A3CliCod, T00037_A1EmpCod, T00037_A85ArchSiradigFec
            }
            , new Object[] {
            T00038_A3CliCod, T00038_A1EmpCod, T00038_A85ArchSiradigFec
            }
            , new Object[] {
            T00039_A3CliCod, T00039_A1EmpCod, T00039_A85ArchSiradigFec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000314_A3CliCod, T000314_A1EmpCod, T000314_A85ArchSiradigFec
            }
            , new Object[] {
            T000315_A3CliCod
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z1EmpCod ;
   private short Z565ArchSiradigEstado ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A565ArchSiradigEstado ;
   private short RcdFound73 ;
   private short nIsDirty_73 ;
   private short i565ArchSiradigEstado ;
   private short ZZ1EmpCod ;
   private short ZZ565ArchSiradigEstado ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Enabled ;
   private int edtArchSiradigFec_Enabled ;
   private int edtArchSiradigFile_Enabled ;
   private int edtArchSiradigError_Enabled ;
   private int edtArchSirdigNameAndType_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ3CliCod ;
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
   private String edtArchSiradigFec_Internalname ;
   private String edtArchSiradigFec_Jsonclick ;
   private String edtArchSiradigFile_Internalname ;
   private String edtArchSiradigFile_Filename ;
   private String edtArchSiradigFile_Filetype ;
   private String A563ArchSiradigType ;
   private String edtArchSiradigFile_Contenttype ;
   private String edtArchSiradigFile_Parameters ;
   private String edtArchSiradigFile_Jsonclick ;
   private String edtArchSiradigError_Internalname ;
   private String edtArchSirdigNameAndType_Internalname ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String Gx_mode ;
   private String GXCCtlgxBlob ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z563ArchSiradigType ;
   private String sMode73 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ563ArchSiradigType ;
   private java.util.Date Z85ArchSiradigFec ;
   private java.util.Date A85ArchSiradigFec ;
   private java.util.Date ZZ85ArchSiradigFec ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private String A562ArchSiradigFile ;
   private String Z562ArchSiradigFile ;
   private String ZZ562ArchSiradigFile ;
   private String Z566ArchSiradigError ;
   private String A564ArchSiradigName ;
   private String A566ArchSiradigError ;
   private String A567ArchSirdigNameAndType ;
   private String Z564ArchSiradigName ;
   private String Z567ArchSirdigNameAndType ;
   private String ZZ567ArchSirdigNameAndType ;
   private String ZZ566ArchSiradigError ;
   private String ZZ564ArchSiradigName ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private HTMLChoice cmbArchSiradigEstado ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] T00035_A85ArchSiradigFec ;
   private short[] T00035_A565ArchSiradigEstado ;
   private String[] T00035_A562ArchSiradigFile ;
   private String[] T00035_A566ArchSiradigError ;
   private String[] T00035_A563ArchSiradigType ;
   private String[] T00035_A564ArchSiradigName ;
   private int[] T00035_A3CliCod ;
   private short[] T00035_A1EmpCod ;
   private int[] T00034_A3CliCod ;
   private int[] T00036_A3CliCod ;
   private int[] T00037_A3CliCod ;
   private short[] T00037_A1EmpCod ;
   private java.util.Date[] T00037_A85ArchSiradigFec ;
   private java.util.Date[] T00033_A85ArchSiradigFec ;
   private short[] T00033_A565ArchSiradigEstado ;
   private String[] T00033_A562ArchSiradigFile ;
   private String[] T00033_A566ArchSiradigError ;
   private String[] T00033_A563ArchSiradigType ;
   private String[] T00033_A564ArchSiradigName ;
   private int[] T00033_A3CliCod ;
   private short[] T00033_A1EmpCod ;
   private int[] T00038_A3CliCod ;
   private short[] T00038_A1EmpCod ;
   private java.util.Date[] T00038_A85ArchSiradigFec ;
   private int[] T00039_A3CliCod ;
   private short[] T00039_A1EmpCod ;
   private java.util.Date[] T00039_A85ArchSiradigFec ;
   private java.util.Date[] T00032_A85ArchSiradigFec ;
   private short[] T00032_A565ArchSiradigEstado ;
   private String[] T00032_A562ArchSiradigFile ;
   private String[] T00032_A566ArchSiradigError ;
   private String[] T00032_A563ArchSiradigType ;
   private String[] T00032_A564ArchSiradigName ;
   private int[] T00032_A3CliCod ;
   private short[] T00032_A1EmpCod ;
   private int[] T000314_A3CliCod ;
   private short[] T000314_A1EmpCod ;
   private java.util.Date[] T000314_A85ArchSiradigFec ;
   private int[] T000315_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class archivo_siradig__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00032", "SELECT ArchSiradigFec, ArchSiradigEstado, ArchSiradigFile, ArchSiradigError, ArchSiradigType, ArchSiradigName, CliCod, EmpCod FROM archivo_siradig WHERE CliCod = ? AND EmpCod = ? AND ArchSiradigFec = ?  FOR UPDATE OF archivo_siradig NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00033", "SELECT ArchSiradigFec, ArchSiradigEstado, ArchSiradigFile, ArchSiradigError, ArchSiradigType, ArchSiradigName, CliCod, EmpCod FROM archivo_siradig WHERE CliCod = ? AND EmpCod = ? AND ArchSiradigFec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00034", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00035", "SELECT TM1.ArchSiradigFec, TM1.ArchSiradigEstado, TM1.ArchSiradigFile, TM1.ArchSiradigError, TM1.ArchSiradigType, TM1.ArchSiradigName, TM1.CliCod, TM1.EmpCod FROM archivo_siradig TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.ArchSiradigFec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.ArchSiradigFec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00036", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00037", "SELECT CliCod, EmpCod, ArchSiradigFec FROM archivo_siradig WHERE CliCod = ? AND EmpCod = ? AND ArchSiradigFec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00038", "SELECT CliCod, EmpCod, ArchSiradigFec FROM archivo_siradig WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and ArchSiradigFec > ?) ORDER BY CliCod, EmpCod, ArchSiradigFec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00039", "SELECT CliCod, EmpCod, ArchSiradigFec FROM archivo_siradig WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and ArchSiradigFec < ?) ORDER BY CliCod DESC, EmpCod DESC, ArchSiradigFec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000310", "SAVEPOINT gxupdate;INSERT INTO archivo_siradig(ArchSiradigFec, ArchSiradigEstado, ArchSiradigFile, ArchSiradigError, ArchSiradigType, ArchSiradigName, CliCod, EmpCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000311", "SAVEPOINT gxupdate;UPDATE archivo_siradig SET ArchSiradigEstado=?, ArchSiradigError=?, ArchSiradigType=?, ArchSiradigName=?  WHERE CliCod = ? AND EmpCod = ? AND ArchSiradigFec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000312", "SAVEPOINT gxupdate;UPDATE archivo_siradig SET ArchSiradigFile=?  WHERE CliCod = ? AND EmpCod = ? AND ArchSiradigFec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000313", "SAVEPOINT gxupdate;DELETE FROM archivo_siradig  WHERE CliCod = ? AND EmpCod = ? AND ArchSiradigFec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000314", "SELECT CliCod, EmpCod, ArchSiradigFec FROM archivo_siradig ORDER BY CliCod, EmpCod, ArchSiradigFec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000315", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(5, 20), rslt.getVarchar(6));
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(5, 20), rslt.getVarchar(6));
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(5, 20), rslt.getVarchar(6));
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               return;
            case 13 :
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
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setDateTime(6, (java.util.Date)parms[5], false);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setDateTime(6, (java.util.Date)parms[5], false);
               return;
            case 8 :
               stmt.setDateTime(1, (java.util.Date)parms[0], false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setBLOBFile(3, (String)parms[2]);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setDateTime(7, (java.util.Date)parms[6], false);
               return;
            case 10 :
               stmt.setBLOBFile(1, (String)parms[0]);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDateTime(4, (java.util.Date)parms[3], false);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

