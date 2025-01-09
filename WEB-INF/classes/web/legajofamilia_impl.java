package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajofamilia_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"PARCOD") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlaparcod0Q24( A3CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_8") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A30ParCod = httpContext.GetPar( "ParCod") ;
         httpContext.ajax_rsp_assign_attri("", false, "A30ParCod", A30ParCod);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_8( A3CliCod, A30ParCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_9") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1547GuarCod = (short)(GXutil.lval( httpContext.GetPar( "GuarCod"))) ;
         n1547GuarCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1547GuarCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1547GuarCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_9( A3CliCod, A1EmpCod, A1547GuarCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_7") == 0 )
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
         gxload_7( A3CliCod, A1EmpCod, A6LegNumero) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Legajo Familia", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = dynParCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public legajofamilia_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajofamilia_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajofamilia_impl.class ));
   }

   public legajofamilia_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynParCod = new HTMLChoice();
      chkFamDiscap = UIFactory.getCheckbox(this);
      chkFamAdherente = UIFactory.getCheckbox(this);
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
      if ( dynParCod.getItemCount() > 0 )
      {
         A30ParCod = dynParCod.getValidValue(A30ParCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "A30ParCod", A30ParCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynParCod.setValue( GXutil.rtrim( A30ParCod) );
         httpContext.ajax_rsp_assign_prop("", false, dynParCod.getInternalname(), "Values", dynParCod.ToJavascriptSource(), true);
      }
      A205FamDiscap = GXutil.strtobool( GXutil.booltostr( A205FamDiscap)) ;
      n205FamDiscap = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A205FamDiscap", A205FamDiscap);
      A890FamAdherente = GXutil.strtobool( GXutil.booltostr( A890FamAdherente)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A890FamAdherente", A890FamAdherente);
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
      web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContentPadding", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
      ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
      ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
      ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
      ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
      ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
      ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
      ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
      ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
      ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
      ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynParCod.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynParCod.getInternalname(), httpContext.getMessage( "Parentesco", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynParCod, dynParCod.getInternalname(), GXutil.rtrim( A30ParCod), 1, dynParCod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynParCod.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_LegajoFamilia.htm");
      dynParCod.setValue( GXutil.rtrim( A30ParCod) );
      httpContext.ajax_rsp_assign_prop("", false, dynParCod.getInternalname(), "Values", dynParCod.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divFamfecnac_cell_Internalname, 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtFamFecNac_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtFamFecNac_Internalname, httpContext.getMessage( "Fecha de nacimiento", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtFamFecNac_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtFamFecNac_Internalname, localUtil.format(A209FamFecNac, "99/99/9999"), localUtil.format( A209FamFecNac, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFamFecNac_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtFamFecNac_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_LegajoFamilia.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtFamFecNac_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtFamFecNac_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LegajoFamilia.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_panelliq.setProperty("Width", Dvpanel_panelliq_Width);
      ucDvpanel_panelliq.setProperty("AutoWidth", Dvpanel_panelliq_Autowidth);
      ucDvpanel_panelliq.setProperty("AutoHeight", Dvpanel_panelliq_Autoheight);
      ucDvpanel_panelliq.setProperty("Cls", Dvpanel_panelliq_Cls);
      ucDvpanel_panelliq.setProperty("Title", Dvpanel_panelliq_Title);
      ucDvpanel_panelliq.setProperty("Collapsible", Dvpanel_panelliq_Collapsible);
      ucDvpanel_panelliq.setProperty("Collapsed", Dvpanel_panelliq_Collapsed);
      ucDvpanel_panelliq.setProperty("ShowCollapseIcon", Dvpanel_panelliq_Showcollapseicon);
      ucDvpanel_panelliq.setProperty("IconPosition", Dvpanel_panelliq_Iconposition);
      ucDvpanel_panelliq.setProperty("AutoScroll", Dvpanel_panelliq_Autoscroll);
      ucDvpanel_panelliq.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelliq_Internalname, "DVPANEL_PANELLIQContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELLIQContainer"+"PanelLiq"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divPanelliq_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divFamdiscap_cell_Internalname, 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkFamDiscap.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkFamDiscap.getInternalname(), httpContext.getMessage( "Posee alguna discapacidad", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkFamDiscap.getInternalname(), GXutil.booltostr( A205FamDiscap), "", httpContext.getMessage( "Posee alguna discapacidad", ""), 1, chkFamDiscap.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(37, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,37);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtFamTomaDeducImpGan_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtFamTomaDeducImpGan_Internalname, httpContext.getMessage( "Deduce para Imp.Ganancias", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtFamTomaDeducImpGan_Internalname, GXutil.ltrim( localUtil.ntoc( A220FamTomaDeducImpGan, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtFamTomaDeducImpGan_Enabled!=0) ? localUtil.format( A220FamTomaDeducImpGan, "9.9999") : localUtil.format( A220FamTomaDeducImpGan, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFamTomaDeducImpGan_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtFamTomaDeducImpGan_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porcentajeDeduccion", "right", false, "", "HLP_LegajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkFamAdherente.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkFamAdherente.getInternalname(), httpContext.getMessage( "Es adherente adicional a la obra social", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkFamAdherente.getInternalname(), GXutil.booltostr( A890FamAdherente), "", httpContext.getMessage( "Es adherente adicional a la obra social", ""), 1, chkFamAdherente.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(47, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,47);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LegajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LegajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LegajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtFamAsigFam_Internalname, GXutil.booltostr( A199FamAsigFam), GXutil.booltostr( A199FamAsigFam), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFamAsigFam_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtFamAsigFam_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "SINO", "right", false, "", "HLP_LegajoFamilia.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LegajoFamilia.htm");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpCod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_LegajoFamilia.htm");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegNumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_LegajoFamilia.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegOrden_Internalname, GXutil.ltrim( localUtil.ntoc( A29LegOrden, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegOrden_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A29LegOrden), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A29LegOrden), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegOrden_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegOrden_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_LegajoFamilia.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtFamApellido_Internalname, A198FamApellido, GXutil.rtrim( localUtil.format( A198FamApellido, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFamApellido_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtFamApellido_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_LegajoFamilia.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtFamNombres_Internalname, A212FamNombres, GXutil.rtrim( localUtil.format( A212FamNombres, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFamNombres_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtFamNombres_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionMedia", "left", true, "", "HLP_LegajoFamilia.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e110Q2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "Z6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z29LegOrden = (short)(localUtil.ctol( httpContext.cgiGet( "Z29LegOrden"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z198FamApellido = httpContext.cgiGet( "Z198FamApellido") ;
            Z212FamNombres = httpContext.cgiGet( "Z212FamNombres") ;
            Z2090FamNomApe = httpContext.cgiGet( "Z2090FamNomApe") ;
            Z209FamFecNac = localUtil.ctod( httpContext.cgiGet( "Z209FamFecNac"), 0) ;
            n209FamFecNac = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A209FamFecNac)) ? true : false) ;
            Z205FamDiscap = GXutil.strtobool( httpContext.cgiGet( "Z205FamDiscap")) ;
            n205FamDiscap = ((false==A205FamDiscap) ? true : false) ;
            Z199FamAsigFam = GXutil.strtobool( httpContext.cgiGet( "Z199FamAsigFam")) ;
            Z220FamTomaDeducImpGan = localUtil.ctond( httpContext.cgiGet( "Z220FamTomaDeducImpGan")) ;
            Z750FamNroDoc = httpContext.cgiGet( "Z750FamNroDoc") ;
            Z751FamMesDesde = (short)(localUtil.ctol( httpContext.cgiGet( "Z751FamMesDesde"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z752FamMesHasta = (short)(localUtil.ctol( httpContext.cgiGet( "Z752FamMesHasta"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z890FamAdherente = GXutil.strtobool( httpContext.cgiGet( "Z890FamAdherente")) ;
            Z30ParCod = httpContext.cgiGet( "Z30ParCod") ;
            Z1547GuarCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1547GuarCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1547GuarCod = ((0==A1547GuarCod) ? true : false) ;
            A2090FamNomApe = httpContext.cgiGet( "Z2090FamNomApe") ;
            A750FamNroDoc = httpContext.cgiGet( "Z750FamNroDoc") ;
            A751FamMesDesde = (short)(localUtil.ctol( httpContext.cgiGet( "Z751FamMesDesde"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A752FamMesHasta = (short)(localUtil.ctol( httpContext.cgiGet( "Z752FamMesHasta"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1547GuarCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1547GuarCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1547GuarCod = false ;
            n1547GuarCod = ((0==A1547GuarCod) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2090FamNomApe = httpContext.cgiGet( "FAMNOMAPE") ;
            A750FamNroDoc = httpContext.cgiGet( "FAMNRODOC") ;
            A751FamMesDesde = (short)(localUtil.ctol( httpContext.cgiGet( "FAMMESDESDE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A752FamMesHasta = (short)(localUtil.ctol( httpContext.cgiGet( "FAMMESHASTA"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1547GuarCod = (short)(localUtil.ctol( httpContext.cgiGet( "GUARCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1547GuarCod = ((0==A1547GuarCod) ? true : false) ;
            A313ParDescrip = httpContext.cgiGet( "PARDESCRIP") ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Dvpanel_panelliq_Objectcall = httpContext.cgiGet( "DVPANEL_PANELLIQ_Objectcall") ;
            Dvpanel_panelliq_Class = httpContext.cgiGet( "DVPANEL_PANELLIQ_Class") ;
            Dvpanel_panelliq_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLIQ_Enabled")) ;
            Dvpanel_panelliq_Width = httpContext.cgiGet( "DVPANEL_PANELLIQ_Width") ;
            Dvpanel_panelliq_Height = httpContext.cgiGet( "DVPANEL_PANELLIQ_Height") ;
            Dvpanel_panelliq_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLIQ_Autowidth")) ;
            Dvpanel_panelliq_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLIQ_Autoheight")) ;
            Dvpanel_panelliq_Cls = httpContext.cgiGet( "DVPANEL_PANELLIQ_Cls") ;
            Dvpanel_panelliq_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLIQ_Showheader")) ;
            Dvpanel_panelliq_Title = httpContext.cgiGet( "DVPANEL_PANELLIQ_Title") ;
            Dvpanel_panelliq_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLIQ_Collapsible")) ;
            Dvpanel_panelliq_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLIQ_Collapsed")) ;
            Dvpanel_panelliq_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLIQ_Showcollapseicon")) ;
            Dvpanel_panelliq_Iconposition = httpContext.cgiGet( "DVPANEL_PANELLIQ_Iconposition") ;
            Dvpanel_panelliq_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLIQ_Autoscroll")) ;
            Dvpanel_panelliq_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLIQ_Visible")) ;
            Dvpanel_panelliq_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_PANELLIQ_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            dynParCod.setValue( httpContext.cgiGet( dynParCod.getInternalname()) );
            A30ParCod = httpContext.cgiGet( dynParCod.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A30ParCod", A30ParCod);
            if ( localUtil.vcdate( httpContext.cgiGet( edtFamFecNac_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "FAMFECNAC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtFamFecNac_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A209FamFecNac = GXutil.nullDate() ;
               n209FamFecNac = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A209FamFecNac", localUtil.format(A209FamFecNac, "99/99/9999"));
            }
            else
            {
               A209FamFecNac = localUtil.ctod( httpContext.cgiGet( edtFamFecNac_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               n209FamFecNac = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A209FamFecNac", localUtil.format(A209FamFecNac, "99/99/9999"));
            }
            n209FamFecNac = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A209FamFecNac)) ? true : false) ;
            A205FamDiscap = GXutil.strtobool( httpContext.cgiGet( chkFamDiscap.getInternalname())) ;
            n205FamDiscap = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A205FamDiscap", A205FamDiscap);
            n205FamDiscap = ((false==A205FamDiscap) ? true : false) ;
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtFamTomaDeducImpGan_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtFamTomaDeducImpGan_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "FAMTOMADEDUCIMPGAN");
               AnyError = (short)(1) ;
               GX_FocusControl = edtFamTomaDeducImpGan_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A220FamTomaDeducImpGan = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A220FamTomaDeducImpGan", GXutil.ltrimstr( A220FamTomaDeducImpGan, 6, 4));
            }
            else
            {
               A220FamTomaDeducImpGan = localUtil.ctond( httpContext.cgiGet( edtFamTomaDeducImpGan_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A220FamTomaDeducImpGan", GXutil.ltrimstr( A220FamTomaDeducImpGan, 6, 4));
            }
            A890FamAdherente = GXutil.strtobool( httpContext.cgiGet( chkFamAdherente.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A890FamAdherente", A890FamAdherente);
            A199FamAsigFam = GXutil.strtobool( httpContext.cgiGet( edtFamAsigFam_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A199FamAsigFam", A199FamAsigFam);
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
            A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegOrden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegOrden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGORDEN");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegOrden_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A29LegOrden = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A29LegOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29LegOrden), 4, 0));
            }
            else
            {
               A29LegOrden = (short)(localUtil.ctol( httpContext.cgiGet( edtLegOrden_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A29LegOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29LegOrden), 4, 0));
            }
            A198FamApellido = GXutil.upper( httpContext.cgiGet( edtFamApellido_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A198FamApellido", A198FamApellido);
            A212FamNombres = GXutil.upper( httpContext.cgiGet( edtFamNombres_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A212FamNombres", A212FamNombres);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"LegajoFamilia");
            A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            forbiddenHiddens.add("EmpCod", localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"));
            forbiddenHiddens.add("FamNomApe", GXutil.rtrim( localUtil.format( A2090FamNomApe, "")));
            forbiddenHiddens.add("FamNroDoc", GXutil.rtrim( localUtil.format( A750FamNroDoc, "")));
            forbiddenHiddens.add("FamMesDesde", localUtil.format( DecimalUtil.doubleToDec(A751FamMesDesde), "ZZZ9"));
            forbiddenHiddens.add("FamMesHasta", localUtil.format( DecimalUtil.doubleToDec(A752FamMesHasta), "ZZZ9"));
            forbiddenHiddens.add("GuarCod", localUtil.format( DecimalUtil.doubleToDec(A1547GuarCod), "ZZZ9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A29LegOrden != Z29LegOrden ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("legajofamilia:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
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
               A29LegOrden = (short)(GXutil.lval( httpContext.GetPar( "LegOrden"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A29LegOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29LegOrden), 4, 0));
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
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e110Q2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120Q2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_enter( ) ;
                        /* No code required for Cancel button. It is implemented as the Reset button. */
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
         /* Execute user event: After Trn */
         e120Q2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0Q24( ) ;
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
         bttBtntrn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      }
   }

   public void disable_std_buttons_dsp( )
   {
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) )
      {
         bttBtntrn_enter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
      }
      disableAttributes0Q24( ) ;
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

   public void resetCaption0Q0( )
   {
   }

   public void e110Q2( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void e120Q2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
   }

   public void zm0Q24( int GX_JID )
   {
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z198FamApellido = T000Q3_A198FamApellido[0] ;
            Z212FamNombres = T000Q3_A212FamNombres[0] ;
            Z2090FamNomApe = T000Q3_A2090FamNomApe[0] ;
            Z209FamFecNac = T000Q3_A209FamFecNac[0] ;
            Z205FamDiscap = T000Q3_A205FamDiscap[0] ;
            Z199FamAsigFam = T000Q3_A199FamAsigFam[0] ;
            Z220FamTomaDeducImpGan = T000Q3_A220FamTomaDeducImpGan[0] ;
            Z750FamNroDoc = T000Q3_A750FamNroDoc[0] ;
            Z751FamMesDesde = T000Q3_A751FamMesDesde[0] ;
            Z752FamMesHasta = T000Q3_A752FamMesHasta[0] ;
            Z890FamAdherente = T000Q3_A890FamAdherente[0] ;
            Z30ParCod = T000Q3_A30ParCod[0] ;
            Z1547GuarCod = T000Q3_A1547GuarCod[0] ;
         }
         else
         {
            Z198FamApellido = A198FamApellido ;
            Z212FamNombres = A212FamNombres ;
            Z2090FamNomApe = A2090FamNomApe ;
            Z209FamFecNac = A209FamFecNac ;
            Z205FamDiscap = A205FamDiscap ;
            Z199FamAsigFam = A199FamAsigFam ;
            Z220FamTomaDeducImpGan = A220FamTomaDeducImpGan ;
            Z750FamNroDoc = A750FamNroDoc ;
            Z751FamMesDesde = A751FamMesDesde ;
            Z752FamMesHasta = A752FamMesHasta ;
            Z890FamAdherente = A890FamAdherente ;
            Z30ParCod = A30ParCod ;
            Z1547GuarCod = A1547GuarCod ;
         }
      }
      if ( GX_JID == -6 )
      {
         Z29LegOrden = A29LegOrden ;
         Z198FamApellido = A198FamApellido ;
         Z212FamNombres = A212FamNombres ;
         Z2090FamNomApe = A2090FamNomApe ;
         Z209FamFecNac = A209FamFecNac ;
         Z205FamDiscap = A205FamDiscap ;
         Z199FamAsigFam = A199FamAsigFam ;
         Z220FamTomaDeducImpGan = A220FamTomaDeducImpGan ;
         Z750FamNroDoc = A750FamNroDoc ;
         Z751FamMesDesde = A751FamMesDesde ;
         Z752FamMesHasta = A752FamMesHasta ;
         Z890FamAdherente = A890FamAdherente ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z30ParCod = A30ParCod ;
         Z1547GuarCod = A1547GuarCod ;
         Z313ParDescrip = A313ParDescrip ;
      }
   }

   public void standaloneNotModal( )
   {
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A220FamTomaDeducImpGan)==0) && ( Gx_BScreen == 0 ) )
      {
         A220FamTomaDeducImpGan = DecimalUtil.doubleToDec(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "A220FamTomaDeducImpGan", GXutil.ltrimstr( A220FamTomaDeducImpGan, 6, 4));
      }
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         bttBtntrn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_delete_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0Q24( )
   {
      /* Using cursor T000Q7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound24 = (short)(1) ;
         A198FamApellido = T000Q7_A198FamApellido[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A198FamApellido", A198FamApellido);
         A212FamNombres = T000Q7_A212FamNombres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A212FamNombres", A212FamNombres);
         A2090FamNomApe = T000Q7_A2090FamNomApe[0] ;
         A313ParDescrip = T000Q7_A313ParDescrip[0] ;
         A209FamFecNac = T000Q7_A209FamFecNac[0] ;
         n209FamFecNac = T000Q7_n209FamFecNac[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A209FamFecNac", localUtil.format(A209FamFecNac, "99/99/9999"));
         A205FamDiscap = T000Q7_A205FamDiscap[0] ;
         n205FamDiscap = T000Q7_n205FamDiscap[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A205FamDiscap", A205FamDiscap);
         A199FamAsigFam = T000Q7_A199FamAsigFam[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A199FamAsigFam", A199FamAsigFam);
         A220FamTomaDeducImpGan = T000Q7_A220FamTomaDeducImpGan[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A220FamTomaDeducImpGan", GXutil.ltrimstr( A220FamTomaDeducImpGan, 6, 4));
         A750FamNroDoc = T000Q7_A750FamNroDoc[0] ;
         A751FamMesDesde = T000Q7_A751FamMesDesde[0] ;
         A752FamMesHasta = T000Q7_A752FamMesHasta[0] ;
         A890FamAdherente = T000Q7_A890FamAdherente[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A890FamAdherente", A890FamAdherente);
         A30ParCod = T000Q7_A30ParCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A30ParCod", A30ParCod);
         A1547GuarCod = T000Q7_A1547GuarCod[0] ;
         n1547GuarCod = T000Q7_n1547GuarCod[0] ;
         zm0Q24( -6) ;
      }
      pr_default.close(5);
      onLoadActions0Q24( ) ;
   }

   public void onLoadActions0Q24( )
   {
      gxaparcod_html0Q24( A3CliCod) ;
   }

   public void checkExtendedTable0Q24( )
   {
      nIsDirty_24 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      /* Using cursor T000Q5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A30ParCod});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Parentesco", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PARCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A313ParDescrip = T000Q5_A313ParDescrip[0] ;
      pr_default.close(3);
      gxaparcod_html0Q24( A3CliCod) ;
      /* Using cursor T000Q6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n1547GuarCod), Short.valueOf(A1547GuarCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A1547GuarCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Guarderias", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "GUARCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(4);
      /* Using cursor T000Q4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( A220FamTomaDeducImpGan.doubleValue() == 1 ) || ( DecimalUtil.compareTo(A220FamTomaDeducImpGan, DecimalUtil.stringToDec("0.5")) == 0 ) || ( A220FamTomaDeducImpGan.doubleValue() == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Deduce ganancias", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "FAMTOMADEDUCIMPGAN");
         AnyError = (short)(1) ;
         GX_FocusControl = edtFamTomaDeducImpGan_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0Q24( )
   {
      pr_default.close(3);
      pr_default.close(4);
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_8( int A3CliCod ,
                         String A30ParCod )
   {
      /* Using cursor T000Q8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A30ParCod});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Parentesco", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PARCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A313ParDescrip = T000Q8_A313ParDescrip[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A313ParDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void gxload_9( int A3CliCod ,
                         short A1EmpCod ,
                         short A1547GuarCod )
   {
      /* Using cursor T000Q9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n1547GuarCod), Short.valueOf(A1547GuarCod)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A1547GuarCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Guarderias", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "GUARCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
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

   public void gxload_7( int A3CliCod ,
                         short A1EmpCod ,
                         int A6LegNumero )
   {
      /* Using cursor T000Q10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
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

   public void getKey0Q24( )
   {
      /* Using cursor T000Q11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound24 = (short)(1) ;
      }
      else
      {
         RcdFound24 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000Q3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0Q24( 6) ;
         RcdFound24 = (short)(1) ;
         A29LegOrden = T000Q3_A29LegOrden[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A29LegOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29LegOrden), 4, 0));
         A198FamApellido = T000Q3_A198FamApellido[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A198FamApellido", A198FamApellido);
         A212FamNombres = T000Q3_A212FamNombres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A212FamNombres", A212FamNombres);
         A2090FamNomApe = T000Q3_A2090FamNomApe[0] ;
         A209FamFecNac = T000Q3_A209FamFecNac[0] ;
         n209FamFecNac = T000Q3_n209FamFecNac[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A209FamFecNac", localUtil.format(A209FamFecNac, "99/99/9999"));
         A205FamDiscap = T000Q3_A205FamDiscap[0] ;
         n205FamDiscap = T000Q3_n205FamDiscap[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A205FamDiscap", A205FamDiscap);
         A199FamAsigFam = T000Q3_A199FamAsigFam[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A199FamAsigFam", A199FamAsigFam);
         A220FamTomaDeducImpGan = T000Q3_A220FamTomaDeducImpGan[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A220FamTomaDeducImpGan", GXutil.ltrimstr( A220FamTomaDeducImpGan, 6, 4));
         A750FamNroDoc = T000Q3_A750FamNroDoc[0] ;
         A751FamMesDesde = T000Q3_A751FamMesDesde[0] ;
         A752FamMesHasta = T000Q3_A752FamMesHasta[0] ;
         A890FamAdherente = T000Q3_A890FamAdherente[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A890FamAdherente", A890FamAdherente);
         A3CliCod = T000Q3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T000Q3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T000Q3_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A30ParCod = T000Q3_A30ParCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A30ParCod", A30ParCod);
         A1547GuarCod = T000Q3_A1547GuarCod[0] ;
         n1547GuarCod = T000Q3_n1547GuarCod[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z29LegOrden = A29LegOrden ;
         sMode24 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0Q24( ) ;
         if ( AnyError == 1 )
         {
            RcdFound24 = (short)(0) ;
            initializeNonKey0Q24( ) ;
         }
         Gx_mode = sMode24 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound24 = (short)(0) ;
         initializeNonKey0Q24( ) ;
         sMode24 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode24 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0Q24( ) ;
      if ( RcdFound24 == 0 )
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
      RcdFound24 = (short)(0) ;
      /* Using cursor T000Q12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A29LegOrden)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T000Q12_A3CliCod[0] < A3CliCod ) || ( T000Q12_A3CliCod[0] == A3CliCod ) && ( T000Q12_A1EmpCod[0] < A1EmpCod ) || ( T000Q12_A1EmpCod[0] == A1EmpCod ) && ( T000Q12_A3CliCod[0] == A3CliCod ) && ( T000Q12_A6LegNumero[0] < A6LegNumero ) || ( T000Q12_A6LegNumero[0] == A6LegNumero ) && ( T000Q12_A1EmpCod[0] == A1EmpCod ) && ( T000Q12_A3CliCod[0] == A3CliCod ) && ( T000Q12_A29LegOrden[0] < A29LegOrden ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T000Q12_A3CliCod[0] > A3CliCod ) || ( T000Q12_A3CliCod[0] == A3CliCod ) && ( T000Q12_A1EmpCod[0] > A1EmpCod ) || ( T000Q12_A1EmpCod[0] == A1EmpCod ) && ( T000Q12_A3CliCod[0] == A3CliCod ) && ( T000Q12_A6LegNumero[0] > A6LegNumero ) || ( T000Q12_A6LegNumero[0] == A6LegNumero ) && ( T000Q12_A1EmpCod[0] == A1EmpCod ) && ( T000Q12_A3CliCod[0] == A3CliCod ) && ( T000Q12_A29LegOrden[0] > A29LegOrden ) ) )
         {
            A3CliCod = T000Q12_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T000Q12_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T000Q12_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A29LegOrden = T000Q12_A29LegOrden[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A29LegOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29LegOrden), 4, 0));
            RcdFound24 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound24 = (short)(0) ;
      /* Using cursor T000Q13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A6LegNumero), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A29LegOrden)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( ( T000Q13_A3CliCod[0] > A3CliCod ) || ( T000Q13_A3CliCod[0] == A3CliCod ) && ( T000Q13_A1EmpCod[0] > A1EmpCod ) || ( T000Q13_A1EmpCod[0] == A1EmpCod ) && ( T000Q13_A3CliCod[0] == A3CliCod ) && ( T000Q13_A6LegNumero[0] > A6LegNumero ) || ( T000Q13_A6LegNumero[0] == A6LegNumero ) && ( T000Q13_A1EmpCod[0] == A1EmpCod ) && ( T000Q13_A3CliCod[0] == A3CliCod ) && ( T000Q13_A29LegOrden[0] > A29LegOrden ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( ( T000Q13_A3CliCod[0] < A3CliCod ) || ( T000Q13_A3CliCod[0] == A3CliCod ) && ( T000Q13_A1EmpCod[0] < A1EmpCod ) || ( T000Q13_A1EmpCod[0] == A1EmpCod ) && ( T000Q13_A3CliCod[0] == A3CliCod ) && ( T000Q13_A6LegNumero[0] < A6LegNumero ) || ( T000Q13_A6LegNumero[0] == A6LegNumero ) && ( T000Q13_A1EmpCod[0] == A1EmpCod ) && ( T000Q13_A3CliCod[0] == A3CliCod ) && ( T000Q13_A29LegOrden[0] < A29LegOrden ) ) )
         {
            A3CliCod = T000Q13_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T000Q13_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T000Q13_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A29LegOrden = T000Q13_A29LegOrden[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A29LegOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29LegOrden), 4, 0));
            RcdFound24 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0Q24( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = dynParCod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0Q24( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound24 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A29LegOrden != Z29LegOrden ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A6LegNumero = Z6LegNumero ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A29LegOrden = Z29LegOrden ;
               httpContext.ajax_rsp_assign_attri("", false, "A29LegOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29LegOrden), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = dynParCod.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update0Q24( ) ;
               GX_FocusControl = dynParCod.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A29LegOrden != Z29LegOrden ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = dynParCod.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0Q24( ) ;
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
                  GX_FocusControl = dynParCod.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0Q24( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A29LegOrden != Z29LegOrden ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = Z6LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A29LegOrden = Z29LegOrden ;
         httpContext.ajax_rsp_assign_attri("", false, "A29LegOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29LegOrden), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = dynParCod.getInternalname() ;
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
      if ( RcdFound24 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = dynParCod.getInternalname() ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0Q24( ) ;
      if ( RcdFound24 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = dynParCod.getInternalname() ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0Q24( ) ;
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
      if ( RcdFound24 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = dynParCod.getInternalname() ;
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
      if ( RcdFound24 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = dynParCod.getInternalname() ;
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
      scanStart0Q24( ) ;
      if ( RcdFound24 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound24 != 0 )
         {
            scanNext0Q24( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = dynParCod.getInternalname() ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0Q24( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0Q24( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000Q2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoFamilia"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z198FamApellido, T000Q2_A198FamApellido[0]) != 0 ) || ( GXutil.strcmp(Z212FamNombres, T000Q2_A212FamNombres[0]) != 0 ) || ( GXutil.strcmp(Z2090FamNomApe, T000Q2_A2090FamNomApe[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z209FamFecNac), GXutil.resetTime(T000Q2_A209FamFecNac[0])) ) || ( Z205FamDiscap != T000Q2_A205FamDiscap[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z199FamAsigFam != T000Q2_A199FamAsigFam[0] ) || ( DecimalUtil.compareTo(Z220FamTomaDeducImpGan, T000Q2_A220FamTomaDeducImpGan[0]) != 0 ) || ( GXutil.strcmp(Z750FamNroDoc, T000Q2_A750FamNroDoc[0]) != 0 ) || ( Z751FamMesDesde != T000Q2_A751FamMesDesde[0] ) || ( Z752FamMesHasta != T000Q2_A752FamMesHasta[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z890FamAdherente != T000Q2_A890FamAdherente[0] ) || ( GXutil.strcmp(Z30ParCod, T000Q2_A30ParCod[0]) != 0 ) || ( Z1547GuarCod != T000Q2_A1547GuarCod[0] ) )
         {
            if ( GXutil.strcmp(Z198FamApellido, T000Q2_A198FamApellido[0]) != 0 )
            {
               GXutil.writeLogln("legajofamilia:[seudo value changed for attri]"+"FamApellido");
               GXutil.writeLogRaw("Old: ",Z198FamApellido);
               GXutil.writeLogRaw("Current: ",T000Q2_A198FamApellido[0]);
            }
            if ( GXutil.strcmp(Z212FamNombres, T000Q2_A212FamNombres[0]) != 0 )
            {
               GXutil.writeLogln("legajofamilia:[seudo value changed for attri]"+"FamNombres");
               GXutil.writeLogRaw("Old: ",Z212FamNombres);
               GXutil.writeLogRaw("Current: ",T000Q2_A212FamNombres[0]);
            }
            if ( GXutil.strcmp(Z2090FamNomApe, T000Q2_A2090FamNomApe[0]) != 0 )
            {
               GXutil.writeLogln("legajofamilia:[seudo value changed for attri]"+"FamNomApe");
               GXutil.writeLogRaw("Old: ",Z2090FamNomApe);
               GXutil.writeLogRaw("Current: ",T000Q2_A2090FamNomApe[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z209FamFecNac), GXutil.resetTime(T000Q2_A209FamFecNac[0])) ) )
            {
               GXutil.writeLogln("legajofamilia:[seudo value changed for attri]"+"FamFecNac");
               GXutil.writeLogRaw("Old: ",Z209FamFecNac);
               GXutil.writeLogRaw("Current: ",T000Q2_A209FamFecNac[0]);
            }
            if ( Z205FamDiscap != T000Q2_A205FamDiscap[0] )
            {
               GXutil.writeLogln("legajofamilia:[seudo value changed for attri]"+"FamDiscap");
               GXutil.writeLogRaw("Old: ",Z205FamDiscap);
               GXutil.writeLogRaw("Current: ",T000Q2_A205FamDiscap[0]);
            }
            if ( Z199FamAsigFam != T000Q2_A199FamAsigFam[0] )
            {
               GXutil.writeLogln("legajofamilia:[seudo value changed for attri]"+"FamAsigFam");
               GXutil.writeLogRaw("Old: ",Z199FamAsigFam);
               GXutil.writeLogRaw("Current: ",T000Q2_A199FamAsigFam[0]);
            }
            if ( DecimalUtil.compareTo(Z220FamTomaDeducImpGan, T000Q2_A220FamTomaDeducImpGan[0]) != 0 )
            {
               GXutil.writeLogln("legajofamilia:[seudo value changed for attri]"+"FamTomaDeducImpGan");
               GXutil.writeLogRaw("Old: ",Z220FamTomaDeducImpGan);
               GXutil.writeLogRaw("Current: ",T000Q2_A220FamTomaDeducImpGan[0]);
            }
            if ( GXutil.strcmp(Z750FamNroDoc, T000Q2_A750FamNroDoc[0]) != 0 )
            {
               GXutil.writeLogln("legajofamilia:[seudo value changed for attri]"+"FamNroDoc");
               GXutil.writeLogRaw("Old: ",Z750FamNroDoc);
               GXutil.writeLogRaw("Current: ",T000Q2_A750FamNroDoc[0]);
            }
            if ( Z751FamMesDesde != T000Q2_A751FamMesDesde[0] )
            {
               GXutil.writeLogln("legajofamilia:[seudo value changed for attri]"+"FamMesDesde");
               GXutil.writeLogRaw("Old: ",Z751FamMesDesde);
               GXutil.writeLogRaw("Current: ",T000Q2_A751FamMesDesde[0]);
            }
            if ( Z752FamMesHasta != T000Q2_A752FamMesHasta[0] )
            {
               GXutil.writeLogln("legajofamilia:[seudo value changed for attri]"+"FamMesHasta");
               GXutil.writeLogRaw("Old: ",Z752FamMesHasta);
               GXutil.writeLogRaw("Current: ",T000Q2_A752FamMesHasta[0]);
            }
            if ( Z890FamAdherente != T000Q2_A890FamAdherente[0] )
            {
               GXutil.writeLogln("legajofamilia:[seudo value changed for attri]"+"FamAdherente");
               GXutil.writeLogRaw("Old: ",Z890FamAdherente);
               GXutil.writeLogRaw("Current: ",T000Q2_A890FamAdherente[0]);
            }
            if ( GXutil.strcmp(Z30ParCod, T000Q2_A30ParCod[0]) != 0 )
            {
               GXutil.writeLogln("legajofamilia:[seudo value changed for attri]"+"ParCod");
               GXutil.writeLogRaw("Old: ",Z30ParCod);
               GXutil.writeLogRaw("Current: ",T000Q2_A30ParCod[0]);
            }
            if ( Z1547GuarCod != T000Q2_A1547GuarCod[0] )
            {
               GXutil.writeLogln("legajofamilia:[seudo value changed for attri]"+"GuarCod");
               GXutil.writeLogRaw("Old: ",Z1547GuarCod);
               GXutil.writeLogRaw("Current: ",T000Q2_A1547GuarCod[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LegajoFamilia"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0Q24( )
   {
      beforeValidate0Q24( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Q24( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0Q24( 0) ;
         checkOptimisticConcurrency0Q24( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Q24( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0Q24( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000Q14 */
                  pr_default.execute(12, new Object[] {Short.valueOf(A29LegOrden), A198FamApellido, A212FamNombres, A2090FamNomApe, Boolean.valueOf(n209FamFecNac), A209FamFecNac, Boolean.valueOf(n205FamDiscap), Boolean.valueOf(A205FamDiscap), Boolean.valueOf(A199FamAsigFam), A220FamTomaDeducImpGan, A750FamNroDoc, Short.valueOf(A751FamMesDesde), Short.valueOf(A752FamMesHasta), Boolean.valueOf(A890FamAdherente), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A30ParCod, Boolean.valueOf(n1547GuarCod), Short.valueOf(A1547GuarCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoFamilia");
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
                        resetCaption0Q0( ) ;
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
            load0Q24( ) ;
         }
         endLevel0Q24( ) ;
      }
      closeExtendedTableCursors0Q24( ) ;
   }

   public void update0Q24( )
   {
      beforeValidate0Q24( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Q24( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Q24( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Q24( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0Q24( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000Q15 */
                  pr_default.execute(13, new Object[] {A198FamApellido, A212FamNombres, A2090FamNomApe, Boolean.valueOf(n209FamFecNac), A209FamFecNac, Boolean.valueOf(n205FamDiscap), Boolean.valueOf(A205FamDiscap), Boolean.valueOf(A199FamAsigFam), A220FamTomaDeducImpGan, A750FamNroDoc, Short.valueOf(A751FamMesDesde), Short.valueOf(A752FamMesHasta), Boolean.valueOf(A890FamAdherente), A30ParCod, Boolean.valueOf(n1547GuarCod), Short.valueOf(A1547GuarCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoFamilia");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoFamilia"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0Q24( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption0Q0( ) ;
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
         endLevel0Q24( ) ;
      }
      closeExtendedTableCursors0Q24( ) ;
   }

   public void deferredUpdate0Q24( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0Q24( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Q24( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0Q24( ) ;
         afterConfirm0Q24( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0Q24( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000Q16 */
               pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A29LegOrden)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoFamilia");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound24 == 0 )
                     {
                        initAll0Q24( ) ;
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
                     resetCaption0Q0( ) ;
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
      sMode24 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0Q24( ) ;
      Gx_mode = sMode24 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0Q24( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         gxaparcod_html0Q24( A3CliCod) ;
         /* Using cursor T000Q17 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), A30ParCod});
         A313ParDescrip = T000Q17_A313ParDescrip[0] ;
         pr_default.close(15);
      }
   }

   public void endLevel0Q24( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0Q24( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "legajofamilia");
         if ( AnyError == 0 )
         {
            confirmValues0Q0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "legajofamilia");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0Q24( )
   {
      /* Scan By routine */
      /* Using cursor T000Q18 */
      pr_default.execute(16);
      RcdFound24 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound24 = (short)(1) ;
         A3CliCod = T000Q18_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T000Q18_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T000Q18_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A29LegOrden = T000Q18_A29LegOrden[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A29LegOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29LegOrden), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0Q24( )
   {
      /* Scan next routine */
      pr_default.readNext(16);
      RcdFound24 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound24 = (short)(1) ;
         A3CliCod = T000Q18_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T000Q18_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T000Q18_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A29LegOrden = T000Q18_A29LegOrden[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A29LegOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29LegOrden), 4, 0));
      }
   }

   public void scanEnd0Q24( )
   {
      pr_default.close(16);
   }

   public void afterConfirm0Q24( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0Q24( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0Q24( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0Q24( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0Q24( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0Q24( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0Q24( )
   {
      dynParCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynParCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynParCod.getEnabled(), 5, 0), true);
      edtFamFecNac_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFamFecNac_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFamFecNac_Enabled), 5, 0), true);
      chkFamDiscap.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkFamDiscap.getInternalname(), "Enabled", GXutil.ltrimstr( chkFamDiscap.getEnabled(), 5, 0), true);
      edtFamTomaDeducImpGan_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFamTomaDeducImpGan_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFamTomaDeducImpGan_Enabled), 5, 0), true);
      chkFamAdherente.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkFamAdherente.getInternalname(), "Enabled", GXutil.ltrimstr( chkFamAdherente.getEnabled(), 5, 0), true);
      edtFamAsigFam_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFamAsigFam_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFamAsigFam_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      edtLegOrden_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegOrden_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegOrden_Enabled), 5, 0), true);
      edtFamApellido_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFamApellido_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFamApellido_Enabled), 5, 0), true);
      edtFamNombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFamNombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFamNombres_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0Q24( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0Q0( )
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.legajofamilia", new String[] {}, new String[] {}) +"\">") ;
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
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"LegajoFamilia");
      forbiddenHiddens.add("EmpCod", localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"));
      forbiddenHiddens.add("FamNomApe", GXutil.rtrim( localUtil.format( A2090FamNomApe, "")));
      forbiddenHiddens.add("FamNroDoc", GXutil.rtrim( localUtil.format( A750FamNroDoc, "")));
      forbiddenHiddens.add("FamMesDesde", localUtil.format( DecimalUtil.doubleToDec(A751FamMesDesde), "ZZZ9"));
      forbiddenHiddens.add("FamMesHasta", localUtil.format( DecimalUtil.doubleToDec(A752FamMesHasta), "ZZZ9"));
      forbiddenHiddens.add("GuarCod", localUtil.format( DecimalUtil.doubleToDec(A1547GuarCod), "ZZZ9"));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("legajofamilia:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z29LegOrden", GXutil.ltrim( localUtil.ntoc( Z29LegOrden, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z198FamApellido", Z198FamApellido);
      web.GxWebStd.gx_hidden_field( httpContext, "Z212FamNombres", Z212FamNombres);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2090FamNomApe", Z2090FamNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, "Z209FamFecNac", localUtil.dtoc( Z209FamFecNac, 0, "/"));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z205FamDiscap", Z205FamDiscap);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z199FamAsigFam", Z199FamAsigFam);
      web.GxWebStd.gx_hidden_field( httpContext, "Z220FamTomaDeducImpGan", GXutil.ltrim( localUtil.ntoc( Z220FamTomaDeducImpGan, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z750FamNroDoc", GXutil.rtrim( Z750FamNroDoc));
      web.GxWebStd.gx_hidden_field( httpContext, "Z751FamMesDesde", GXutil.ltrim( localUtil.ntoc( Z751FamMesDesde, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z752FamMesHasta", GXutil.ltrim( localUtil.ntoc( Z752FamMesHasta, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z890FamAdherente", Z890FamAdherente);
      web.GxWebStd.gx_hidden_field( httpContext, "Z30ParCod", GXutil.rtrim( Z30ParCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1547GuarCod", GXutil.ltrim( localUtil.ntoc( Z1547GuarCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "FAMNOMAPE", A2090FamNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, "FAMNRODOC", GXutil.rtrim( A750FamNroDoc));
      web.GxWebStd.gx_hidden_field( httpContext, "FAMMESDESDE", GXutil.ltrim( localUtil.ntoc( A751FamMesDesde, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "FAMMESHASTA", GXutil.ltrim( localUtil.ntoc( A752FamMesHasta, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GUARCOD", GXutil.ltrim( localUtil.ntoc( A1547GuarCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PARDESCRIP", A313ParDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIQ_Objectcall", GXutil.rtrim( Dvpanel_panelliq_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIQ_Enabled", GXutil.booltostr( Dvpanel_panelliq_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIQ_Width", GXutil.rtrim( Dvpanel_panelliq_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIQ_Autowidth", GXutil.booltostr( Dvpanel_panelliq_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIQ_Autoheight", GXutil.booltostr( Dvpanel_panelliq_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIQ_Cls", GXutil.rtrim( Dvpanel_panelliq_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIQ_Title", GXutil.rtrim( Dvpanel_panelliq_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIQ_Collapsible", GXutil.booltostr( Dvpanel_panelliq_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIQ_Collapsed", GXutil.booltostr( Dvpanel_panelliq_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIQ_Showcollapseicon", GXutil.booltostr( Dvpanel_panelliq_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIQ_Iconposition", GXutil.rtrim( Dvpanel_panelliq_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLIQ_Autoscroll", GXutil.booltostr( Dvpanel_panelliq_Autoscroll));
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
      return formatLink("web.legajofamilia", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "LegajoFamilia" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Legajo Familia", "") ;
   }

   public void initializeNonKey0Q24( )
   {
      A198FamApellido = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A198FamApellido", A198FamApellido);
      A212FamNombres = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A212FamNombres", A212FamNombres);
      A2090FamNomApe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2090FamNomApe", A2090FamNomApe);
      A30ParCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A30ParCod", A30ParCod);
      A313ParDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A313ParDescrip", A313ParDescrip);
      A209FamFecNac = GXutil.nullDate() ;
      n209FamFecNac = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A209FamFecNac", localUtil.format(A209FamFecNac, "99/99/9999"));
      n209FamFecNac = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A209FamFecNac)) ? true : false) ;
      A205FamDiscap = false ;
      n205FamDiscap = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A205FamDiscap", A205FamDiscap);
      n205FamDiscap = ((false==A205FamDiscap) ? true : false) ;
      A199FamAsigFam = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A199FamAsigFam", A199FamAsigFam);
      A750FamNroDoc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A750FamNroDoc", A750FamNroDoc);
      A751FamMesDesde = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A751FamMesDesde", GXutil.ltrimstr( DecimalUtil.doubleToDec(A751FamMesDesde), 4, 0));
      A752FamMesHasta = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A752FamMesHasta", GXutil.ltrimstr( DecimalUtil.doubleToDec(A752FamMesHasta), 4, 0));
      A890FamAdherente = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A890FamAdherente", A890FamAdherente);
      A1547GuarCod = (short)(0) ;
      n1547GuarCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1547GuarCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1547GuarCod), 4, 0));
      A220FamTomaDeducImpGan = DecimalUtil.doubleToDec(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "A220FamTomaDeducImpGan", GXutil.ltrimstr( A220FamTomaDeducImpGan, 6, 4));
      Z198FamApellido = "" ;
      Z212FamNombres = "" ;
      Z2090FamNomApe = "" ;
      Z209FamFecNac = GXutil.nullDate() ;
      Z205FamDiscap = false ;
      Z199FamAsigFam = false ;
      Z220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      Z750FamNroDoc = "" ;
      Z751FamMesDesde = (short)(0) ;
      Z752FamMesHasta = (short)(0) ;
      Z890FamAdherente = false ;
      Z30ParCod = "" ;
      Z1547GuarCod = (short)(0) ;
   }

   public void initAll0Q24( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A6LegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      A29LegOrden = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A29LegOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29LegOrden), 4, 0));
      initializeNonKey0Q24( ) ;
   }

   public void standaloneModalInsert( )
   {
      A220FamTomaDeducImpGan = i220FamTomaDeducImpGan ;
      httpContext.ajax_rsp_assign_attri("", false, "A220FamTomaDeducImpGan", GXutil.ltrimstr( A220FamTomaDeducImpGan, 6, 4));
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713471114", true, true);
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
      httpContext.AddJavascriptSource("legajofamilia.js", "?20251713471115", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      dynParCod.setInternalname( "PARCOD" );
      edtFamFecNac_Internalname = "FAMFECNAC" ;
      divFamfecnac_cell_Internalname = "FAMFECNAC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      chkFamDiscap.setInternalname( "FAMDISCAP" );
      divFamdiscap_cell_Internalname = "FAMDISCAP_CELL" ;
      edtFamTomaDeducImpGan_Internalname = "FAMTOMADEDUCIMPGAN" ;
      chkFamAdherente.setInternalname( "FAMADHERENTE" );
      divPanelliq_Internalname = "PANELLIQ" ;
      Dvpanel_panelliq_Internalname = "DVPANEL_PANELLIQ" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtFamAsigFam_Internalname = "FAMASIGFAM" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtLegNumero_Internalname = "LEGNUMERO" ;
      edtLegOrden_Internalname = "LEGORDEN" ;
      edtFamApellido_Internalname = "FAMAPELLIDO" ;
      edtFamNombres_Internalname = "FAMNOMBRES" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
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
      Form.setCaption( httpContext.getMessage( "Legajo Familia", "") );
      edtFamNombres_Jsonclick = "" ;
      edtFamNombres_Enabled = 1 ;
      edtFamApellido_Jsonclick = "" ;
      edtFamApellido_Enabled = 1 ;
      edtLegOrden_Jsonclick = "" ;
      edtLegOrden_Enabled = 1 ;
      edtLegNumero_Jsonclick = "" ;
      edtLegNumero_Enabled = 0 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 0 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtFamAsigFam_Jsonclick = "" ;
      edtFamAsigFam_Enabled = 1 ;
      bttBtntrn_delete_Enabled = 1 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      chkFamAdherente.setEnabled( 1 );
      edtFamTomaDeducImpGan_Jsonclick = "" ;
      edtFamTomaDeducImpGan_Enabled = 1 ;
      chkFamDiscap.setEnabled( 1 );
      Dvpanel_panelliq_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelliq_Iconposition = "Right" ;
      Dvpanel_panelliq_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelliq_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelliq_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelliq_Title = httpContext.getMessage( "Datos de Liquidación", "") ;
      Dvpanel_panelliq_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelliq_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelliq_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelliq_Width = "100%" ;
      edtFamFecNac_Jsonclick = "" ;
      edtFamFecNac_Enabled = 1 ;
      dynParCod.setJsonclick( "" );
      dynParCod.setEnabled( 1 );
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "Datos Personales", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      gxaparcod_html0Q24( A3CliCod) ;
      /* End function dynload_actions */
   }

   public void gxdlaparcod0Q24( int A3CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaparcod_data0Q24( A3CliCod) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxaparcod_html0Q24( int A3CliCod )
   {
      String gxdynajaxvalue;
      gxdlaparcod_data0Q24( A3CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynParCod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynParCod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaparcod_data0Q24( int A3CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T000Q19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod)});
      while ( (pr_default.getStatus(17) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T000Q19_A30ParCod[0]));
         gxdynajaxctrldescr.add(T000Q19_A313ParDescrip[0]);
         pr_default.readNext(17);
      }
      pr_default.close(17);
   }

   public void init_web_controls( )
   {
      dynParCod.setName( "PARCOD" );
      dynParCod.setWebtags( "" );
      chkFamDiscap.setName( "FAMDISCAP" );
      chkFamDiscap.setWebtags( "" );
      chkFamDiscap.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkFamDiscap.getInternalname(), "TitleCaption", chkFamDiscap.getCaption(), true);
      chkFamDiscap.setCheckedValue( "false" );
      A205FamDiscap = GXutil.strtobool( GXutil.booltostr( A205FamDiscap)) ;
      n205FamDiscap = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A205FamDiscap", A205FamDiscap);
      chkFamAdherente.setName( "FAMADHERENTE" );
      chkFamAdherente.setWebtags( "" );
      chkFamAdherente.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkFamAdherente.getInternalname(), "TitleCaption", chkFamAdherente.getCaption(), true);
      chkFamAdherente.setCheckedValue( "false" );
      A890FamAdherente = GXutil.strtobool( GXutil.booltostr( A890FamAdherente)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A890FamAdherente", A890FamAdherente);
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      /* Using cursor T000Q20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(18);
      GX_FocusControl = dynParCod.getInternalname() ;
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

   public void valid_Clicod( )
   {
      A30ParCod = dynParCod.getValue() ;
      gxaparcod_html0Q24( A3CliCod) ;
      dynload_actions( ) ;
      if ( dynParCod.getItemCount() > 0 )
      {
         A30ParCod = dynParCod.getValidValue(A30ParCod) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynParCod.setValue( GXutil.rtrim( A30ParCod) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A30ParCod", GXutil.rtrim( A30ParCod));
      dynParCod.setValue( GXutil.rtrim( A30ParCod) );
      httpContext.ajax_rsp_assign_prop("", false, dynParCod.getInternalname(), "Values", dynParCod.ToJavascriptSource(), true);
   }

   public void valid_Empcod( )
   {
      n1547GuarCod = false ;
      A30ParCod = dynParCod.getValue() ;
      /* Using cursor T000Q21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n1547GuarCod), Short.valueOf(A1547GuarCod)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A1547GuarCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Guarderias", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "GUARCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      pr_default.close(19);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Legnumero( )
   {
      A30ParCod = dynParCod.getValue() ;
      /* Using cursor T000Q22 */
      pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(20) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(20);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Legorden( )
   {
      n1547GuarCod = false ;
      A30ParCod = dynParCod.getValue() ;
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      A205FamDiscap = GXutil.strtobool( GXutil.booltostr( A205FamDiscap)) ;
      n205FamDiscap = false ;
      A890FamAdherente = GXutil.strtobool( GXutil.booltostr( A890FamAdherente)) ;
      if ( dynParCod.getItemCount() > 0 )
      {
         A30ParCod = dynParCod.getValidValue(A30ParCod) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynParCod.setValue( GXutil.rtrim( A30ParCod) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A198FamApellido", A198FamApellido);
      httpContext.ajax_rsp_assign_attri("", false, "A212FamNombres", A212FamNombres);
      httpContext.ajax_rsp_assign_attri("", false, "A2090FamNomApe", A2090FamNomApe);
      httpContext.ajax_rsp_assign_attri("", false, "A209FamFecNac", localUtil.format(A209FamFecNac, "99/99/9999"));
      httpContext.ajax_rsp_assign_attri("", false, "A205FamDiscap", A205FamDiscap);
      httpContext.ajax_rsp_assign_attri("", false, "A199FamAsigFam", A199FamAsigFam);
      httpContext.ajax_rsp_assign_attri("", false, "A220FamTomaDeducImpGan", GXutil.ltrim( localUtil.ntoc( A220FamTomaDeducImpGan, (byte)(6), (byte)(4), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A750FamNroDoc", GXutil.rtrim( A750FamNroDoc));
      httpContext.ajax_rsp_assign_attri("", false, "A751FamMesDesde", GXutil.ltrim( localUtil.ntoc( A751FamMesDesde, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A752FamMesHasta", GXutil.ltrim( localUtil.ntoc( A752FamMesHasta, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A890FamAdherente", A890FamAdherente);
      httpContext.ajax_rsp_assign_attri("", false, "A1547GuarCod", GXutil.ltrim( localUtil.ntoc( A1547GuarCod, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A313ParDescrip", A313ParDescrip);
      httpContext.ajax_rsp_assign_attri("", false, "A30ParCod", GXutil.rtrim( A30ParCod));
      dynParCod.setValue( GXutil.rtrim( A30ParCod) );
      httpContext.ajax_rsp_assign_prop("", false, dynParCod.getInternalname(), "Values", dynParCod.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z29LegOrden", GXutil.ltrim( localUtil.ntoc( Z29LegOrden, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z198FamApellido", Z198FamApellido);
      web.GxWebStd.gx_hidden_field( httpContext, "Z212FamNombres", Z212FamNombres);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2090FamNomApe", Z2090FamNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, "Z209FamFecNac", localUtil.format(Z209FamFecNac, "99/99/9999"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z205FamDiscap", GXutil.booltostr( Z205FamDiscap));
      web.GxWebStd.gx_hidden_field( httpContext, "Z199FamAsigFam", GXutil.booltostr( Z199FamAsigFam));
      web.GxWebStd.gx_hidden_field( httpContext, "Z220FamTomaDeducImpGan", GXutil.ltrim( localUtil.ntoc( Z220FamTomaDeducImpGan, (byte)(6), (byte)(4), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z750FamNroDoc", GXutil.rtrim( Z750FamNroDoc));
      web.GxWebStd.gx_hidden_field( httpContext, "Z751FamMesDesde", GXutil.ltrim( localUtil.ntoc( Z751FamMesDesde, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z752FamMesHasta", GXutil.ltrim( localUtil.ntoc( Z752FamMesHasta, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z890FamAdherente", GXutil.booltostr( Z890FamAdherente));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1547GuarCod", GXutil.ltrim( localUtil.ntoc( Z1547GuarCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z313ParDescrip", Z313ParDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z30ParCod", GXutil.rtrim( Z30ParCod));
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Parcod( )
   {
      A30ParCod = dynParCod.getValue() ;
      /* Using cursor T000Q23 */
      pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), A30ParCod});
      if ( (pr_default.getStatus(21) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Parentesco", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PARCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A313ParDescrip = T000Q23_A313ParDescrip[0] ;
      pr_default.close(21);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A313ParDescrip", A313ParDescrip);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A2090FamNomApe',fld:'FAMNOMAPE',pic:''},{av:'A750FamNroDoc',fld:'FAMNRODOC',pic:''},{av:'A751FamMesDesde',fld:'FAMMESDESDE',pic:'ZZZ9'},{av:'A752FamMesHasta',fld:'FAMMESHASTA',pic:'ZZZ9'},{av:'A1547GuarCod',fld:'GUARCOD',pic:'ZZZ9'},{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e120Q2',iparms:[{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]}");
      setEventMetadata("VALID_PARCOD","{handler:'valid_Parcod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynParCod'},{av:'A30ParCod',fld:'PARCOD',pic:''},{av:'A313ParDescrip',fld:'PARDESCRIP',pic:'@!'},{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]");
      setEventMetadata("VALID_PARCOD",",oparms:[{av:'A313ParDescrip',fld:'PARDESCRIP',pic:'@!'},{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]}");
      setEventMetadata("VALID_FAMTOMADEDUCIMPGAN","{handler:'valid_Famtomadeducimpgan',iparms:[{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]");
      setEventMetadata("VALID_FAMTOMADEDUCIMPGAN",",oparms:[{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynParCod'},{av:'A30ParCod',fld:'PARCOD',pic:''},{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'dynParCod'},{av:'A30ParCod',fld:'PARCOD',pic:''},{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1547GuarCod',fld:'GUARCOD',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynParCod'},{av:'A30ParCod',fld:'PARCOD',pic:''},{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynParCod'},{av:'A30ParCod',fld:'PARCOD',pic:''},{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]}");
      setEventMetadata("VALID_LEGORDEN","{handler:'valid_Legorden',iparms:[{av:'A1547GuarCod',fld:'GUARCOD',pic:'ZZZ9'},{av:'A752FamMesHasta',fld:'FAMMESHASTA',pic:'ZZZ9'},{av:'A751FamMesDesde',fld:'FAMMESDESDE',pic:'ZZZ9'},{av:'A750FamNroDoc',fld:'FAMNRODOC',pic:''},{av:'A2090FamNomApe',fld:'FAMNOMAPE',pic:''},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A29LegOrden',fld:'LEGORDEN',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynParCod'},{av:'A30ParCod',fld:'PARCOD',pic:''},{av:'Gx_BScreen',fld:'vGXBSCREEN',pic:'9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'A220FamTomaDeducImpGan',fld:'FAMTOMADEDUCIMPGAN',pic:'9.9999'},{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]");
      setEventMetadata("VALID_LEGORDEN",",oparms:[{av:'A198FamApellido',fld:'FAMAPELLIDO',pic:'@!'},{av:'A212FamNombres',fld:'FAMNOMBRES',pic:'@!'},{av:'A2090FamNomApe',fld:'FAMNOMAPE',pic:''},{av:'A209FamFecNac',fld:'FAMFECNAC',pic:''},{av:'A199FamAsigFam',fld:'FAMASIGFAM',pic:''},{av:'A220FamTomaDeducImpGan',fld:'FAMTOMADEDUCIMPGAN',pic:'9.9999'},{av:'A750FamNroDoc',fld:'FAMNRODOC',pic:''},{av:'A751FamMesDesde',fld:'FAMMESDESDE',pic:'ZZZ9'},{av:'A752FamMesHasta',fld:'FAMMESHASTA',pic:'ZZZ9'},{av:'A1547GuarCod',fld:'GUARCOD',pic:'ZZZ9'},{av:'A313ParDescrip',fld:'PARDESCRIP',pic:'@!'},{av:'dynParCod'},{av:'A30ParCod',fld:'PARCOD',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z3CliCod'},{av:'Z1EmpCod'},{av:'Z6LegNumero'},{av:'Z29LegOrden'},{av:'Z198FamApellido'},{av:'Z212FamNombres'},{av:'Z2090FamNomApe'},{av:'Z209FamFecNac'},{av:'Z205FamDiscap'},{av:'Z199FamAsigFam'},{av:'Z220FamTomaDeducImpGan'},{av:'Z750FamNroDoc'},{av:'Z751FamMesDesde'},{av:'Z752FamMesHasta'},{av:'Z890FamAdherente'},{av:'Z1547GuarCod'},{av:'Z313ParDescrip'},{av:'Z30ParCod'},{ctrl:'BTNTRN_DELETE',prop:'Enabled'},{ctrl:'BTNTRN_ENTER',prop:'Enabled'},{av:'A205FamDiscap',fld:'FAMDISCAP',pic:''},{av:'A890FamAdherente',fld:'FAMADHERENTE',pic:''}]}");
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
      return "legajofamilia_Execute";
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
      pr_default.close(20);
      pr_default.close(18);
      pr_default.close(21);
      pr_default.close(15);
      pr_default.close(19);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z198FamApellido = "" ;
      Z212FamNombres = "" ;
      Z2090FamNomApe = "" ;
      Z209FamFecNac = GXutil.nullDate() ;
      Z220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      Z750FamNroDoc = "" ;
      Z30ParCod = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A30ParCod = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A209FamFecNac = GXutil.nullDate() ;
      ucDvpanel_panelliq = new com.genexus.webpanels.GXUserControl();
      ClassString = "" ;
      StyleString = "" ;
      A220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A198FamApellido = "" ;
      A212FamNombres = "" ;
      A2090FamNomApe = "" ;
      A750FamNroDoc = "" ;
      Gx_mode = "" ;
      A313ParDescrip = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      Dvpanel_panelliq_Objectcall = "" ;
      Dvpanel_panelliq_Class = "" ;
      Dvpanel_panelliq_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z313ParDescrip = "" ;
      T000Q7_A29LegOrden = new short[1] ;
      T000Q7_A198FamApellido = new String[] {""} ;
      T000Q7_A212FamNombres = new String[] {""} ;
      T000Q7_A2090FamNomApe = new String[] {""} ;
      T000Q7_A313ParDescrip = new String[] {""} ;
      T000Q7_A209FamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T000Q7_n209FamFecNac = new boolean[] {false} ;
      T000Q7_A205FamDiscap = new boolean[] {false} ;
      T000Q7_n205FamDiscap = new boolean[] {false} ;
      T000Q7_A199FamAsigFam = new boolean[] {false} ;
      T000Q7_A220FamTomaDeducImpGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000Q7_A750FamNroDoc = new String[] {""} ;
      T000Q7_A751FamMesDesde = new short[1] ;
      T000Q7_A752FamMesHasta = new short[1] ;
      T000Q7_A890FamAdherente = new boolean[] {false} ;
      T000Q7_A3CliCod = new int[1] ;
      T000Q7_A1EmpCod = new short[1] ;
      T000Q7_A6LegNumero = new int[1] ;
      T000Q7_A30ParCod = new String[] {""} ;
      T000Q7_A1547GuarCod = new short[1] ;
      T000Q7_n1547GuarCod = new boolean[] {false} ;
      T000Q5_A313ParDescrip = new String[] {""} ;
      T000Q6_A3CliCod = new int[1] ;
      T000Q4_A3CliCod = new int[1] ;
      T000Q8_A313ParDescrip = new String[] {""} ;
      T000Q9_A3CliCod = new int[1] ;
      T000Q10_A3CliCod = new int[1] ;
      T000Q11_A3CliCod = new int[1] ;
      T000Q11_A1EmpCod = new short[1] ;
      T000Q11_A6LegNumero = new int[1] ;
      T000Q11_A29LegOrden = new short[1] ;
      T000Q3_A29LegOrden = new short[1] ;
      T000Q3_A198FamApellido = new String[] {""} ;
      T000Q3_A212FamNombres = new String[] {""} ;
      T000Q3_A2090FamNomApe = new String[] {""} ;
      T000Q3_A209FamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T000Q3_n209FamFecNac = new boolean[] {false} ;
      T000Q3_A205FamDiscap = new boolean[] {false} ;
      T000Q3_n205FamDiscap = new boolean[] {false} ;
      T000Q3_A199FamAsigFam = new boolean[] {false} ;
      T000Q3_A220FamTomaDeducImpGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000Q3_A750FamNroDoc = new String[] {""} ;
      T000Q3_A751FamMesDesde = new short[1] ;
      T000Q3_A752FamMesHasta = new short[1] ;
      T000Q3_A890FamAdherente = new boolean[] {false} ;
      T000Q3_A3CliCod = new int[1] ;
      T000Q3_A1EmpCod = new short[1] ;
      T000Q3_A6LegNumero = new int[1] ;
      T000Q3_A30ParCod = new String[] {""} ;
      T000Q3_A1547GuarCod = new short[1] ;
      T000Q3_n1547GuarCod = new boolean[] {false} ;
      sMode24 = "" ;
      T000Q12_A3CliCod = new int[1] ;
      T000Q12_A1EmpCod = new short[1] ;
      T000Q12_A6LegNumero = new int[1] ;
      T000Q12_A29LegOrden = new short[1] ;
      T000Q13_A3CliCod = new int[1] ;
      T000Q13_A1EmpCod = new short[1] ;
      T000Q13_A6LegNumero = new int[1] ;
      T000Q13_A29LegOrden = new short[1] ;
      T000Q2_A29LegOrden = new short[1] ;
      T000Q2_A198FamApellido = new String[] {""} ;
      T000Q2_A212FamNombres = new String[] {""} ;
      T000Q2_A2090FamNomApe = new String[] {""} ;
      T000Q2_A209FamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T000Q2_n209FamFecNac = new boolean[] {false} ;
      T000Q2_A205FamDiscap = new boolean[] {false} ;
      T000Q2_n205FamDiscap = new boolean[] {false} ;
      T000Q2_A199FamAsigFam = new boolean[] {false} ;
      T000Q2_A220FamTomaDeducImpGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000Q2_A750FamNroDoc = new String[] {""} ;
      T000Q2_A751FamMesDesde = new short[1] ;
      T000Q2_A752FamMesHasta = new short[1] ;
      T000Q2_A890FamAdherente = new boolean[] {false} ;
      T000Q2_A3CliCod = new int[1] ;
      T000Q2_A1EmpCod = new short[1] ;
      T000Q2_A6LegNumero = new int[1] ;
      T000Q2_A30ParCod = new String[] {""} ;
      T000Q2_A1547GuarCod = new short[1] ;
      T000Q2_n1547GuarCod = new boolean[] {false} ;
      T000Q17_A313ParDescrip = new String[] {""} ;
      T000Q18_A3CliCod = new int[1] ;
      T000Q18_A1EmpCod = new short[1] ;
      T000Q18_A6LegNumero = new int[1] ;
      T000Q18_A29LegOrden = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T000Q19_A3CliCod = new int[1] ;
      T000Q19_A30ParCod = new String[] {""} ;
      T000Q19_A313ParDescrip = new String[] {""} ;
      T000Q19_A314ParHabilitado = new boolean[] {false} ;
      T000Q20_A3CliCod = new int[1] ;
      T000Q21_A3CliCod = new int[1] ;
      T000Q22_A3CliCod = new int[1] ;
      ZZ198FamApellido = "" ;
      ZZ212FamNombres = "" ;
      ZZ2090FamNomApe = "" ;
      ZZ209FamFecNac = GXutil.nullDate() ;
      ZZ220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      ZZ750FamNroDoc = "" ;
      ZZ313ParDescrip = "" ;
      ZZ30ParCod = "" ;
      T000Q23_A313ParDescrip = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajofamilia__default(),
         new Object[] {
             new Object[] {
            T000Q2_A29LegOrden, T000Q2_A198FamApellido, T000Q2_A212FamNombres, T000Q2_A2090FamNomApe, T000Q2_A209FamFecNac, T000Q2_n209FamFecNac, T000Q2_A205FamDiscap, T000Q2_n205FamDiscap, T000Q2_A199FamAsigFam, T000Q2_A220FamTomaDeducImpGan,
            T000Q2_A750FamNroDoc, T000Q2_A751FamMesDesde, T000Q2_A752FamMesHasta, T000Q2_A890FamAdherente, T000Q2_A3CliCod, T000Q2_A1EmpCod, T000Q2_A6LegNumero, T000Q2_A30ParCod, T000Q2_A1547GuarCod, T000Q2_n1547GuarCod
            }
            , new Object[] {
            T000Q3_A29LegOrden, T000Q3_A198FamApellido, T000Q3_A212FamNombres, T000Q3_A2090FamNomApe, T000Q3_A209FamFecNac, T000Q3_n209FamFecNac, T000Q3_A205FamDiscap, T000Q3_n205FamDiscap, T000Q3_A199FamAsigFam, T000Q3_A220FamTomaDeducImpGan,
            T000Q3_A750FamNroDoc, T000Q3_A751FamMesDesde, T000Q3_A752FamMesHasta, T000Q3_A890FamAdherente, T000Q3_A3CliCod, T000Q3_A1EmpCod, T000Q3_A6LegNumero, T000Q3_A30ParCod, T000Q3_A1547GuarCod, T000Q3_n1547GuarCod
            }
            , new Object[] {
            T000Q4_A3CliCod
            }
            , new Object[] {
            T000Q5_A313ParDescrip
            }
            , new Object[] {
            T000Q6_A3CliCod
            }
            , new Object[] {
            T000Q7_A29LegOrden, T000Q7_A198FamApellido, T000Q7_A212FamNombres, T000Q7_A2090FamNomApe, T000Q7_A313ParDescrip, T000Q7_A209FamFecNac, T000Q7_n209FamFecNac, T000Q7_A205FamDiscap, T000Q7_n205FamDiscap, T000Q7_A199FamAsigFam,
            T000Q7_A220FamTomaDeducImpGan, T000Q7_A750FamNroDoc, T000Q7_A751FamMesDesde, T000Q7_A752FamMesHasta, T000Q7_A890FamAdherente, T000Q7_A3CliCod, T000Q7_A1EmpCod, T000Q7_A6LegNumero, T000Q7_A30ParCod, T000Q7_A1547GuarCod,
            T000Q7_n1547GuarCod
            }
            , new Object[] {
            T000Q8_A313ParDescrip
            }
            , new Object[] {
            T000Q9_A3CliCod
            }
            , new Object[] {
            T000Q10_A3CliCod
            }
            , new Object[] {
            T000Q11_A3CliCod, T000Q11_A1EmpCod, T000Q11_A6LegNumero, T000Q11_A29LegOrden
            }
            , new Object[] {
            T000Q12_A3CliCod, T000Q12_A1EmpCod, T000Q12_A6LegNumero, T000Q12_A29LegOrden
            }
            , new Object[] {
            T000Q13_A3CliCod, T000Q13_A1EmpCod, T000Q13_A6LegNumero, T000Q13_A29LegOrden
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000Q17_A313ParDescrip
            }
            , new Object[] {
            T000Q18_A3CliCod, T000Q18_A1EmpCod, T000Q18_A6LegNumero, T000Q18_A29LegOrden
            }
            , new Object[] {
            T000Q19_A3CliCod, T000Q19_A30ParCod, T000Q19_A313ParDescrip, T000Q19_A314ParHabilitado
            }
            , new Object[] {
            T000Q20_A3CliCod
            }
            , new Object[] {
            T000Q21_A3CliCod
            }
            , new Object[] {
            T000Q22_A3CliCod
            }
            , new Object[] {
            T000Q23_A313ParDescrip
            }
         }
      );
      Z220FamTomaDeducImpGan = DecimalUtil.doubleToDec(1) ;
      A220FamTomaDeducImpGan = DecimalUtil.doubleToDec(1) ;
      i220FamTomaDeducImpGan = DecimalUtil.doubleToDec(1) ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z1EmpCod ;
   private short Z29LegOrden ;
   private short Z751FamMesDesde ;
   private short Z752FamMesHasta ;
   private short Z1547GuarCod ;
   private short A1EmpCod ;
   private short A1547GuarCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A29LegOrden ;
   private short A751FamMesDesde ;
   private short A752FamMesHasta ;
   private short RcdFound24 ;
   private short nIsDirty_24 ;
   private short ZZ1EmpCod ;
   private short ZZ29LegOrden ;
   private short ZZ751FamMesDesde ;
   private short ZZ752FamMesHasta ;
   private short ZZ1547GuarCod ;
   private int Z3CliCod ;
   private int Z6LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int trnEnded ;
   private int edtFamFecNac_Enabled ;
   private int edtFamTomaDeducImpGan_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtFamAsigFam_Enabled ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Enabled ;
   private int edtLegNumero_Enabled ;
   private int edtLegOrden_Enabled ;
   private int edtFamApellido_Enabled ;
   private int edtFamNombres_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int Dvpanel_panelliq_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int ZZ3CliCod ;
   private int ZZ6LegNumero ;
   private java.math.BigDecimal Z220FamTomaDeducImpGan ;
   private java.math.BigDecimal A220FamTomaDeducImpGan ;
   private java.math.BigDecimal i220FamTomaDeducImpGan ;
   private java.math.BigDecimal ZZ220FamTomaDeducImpGan ;
   private String sPrefix ;
   private String Z750FamNroDoc ;
   private String Z30ParCod ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A30ParCod ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String divFamfecnac_cell_Internalname ;
   private String edtFamFecNac_Internalname ;
   private String edtFamFecNac_Jsonclick ;
   private String Dvpanel_panelliq_Width ;
   private String Dvpanel_panelliq_Cls ;
   private String Dvpanel_panelliq_Title ;
   private String Dvpanel_panelliq_Iconposition ;
   private String Dvpanel_panelliq_Internalname ;
   private String divPanelliq_Internalname ;
   private String divFamdiscap_cell_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtFamTomaDeducImpGan_Internalname ;
   private String edtFamTomaDeducImpGan_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtFamAsigFam_Internalname ;
   private String edtFamAsigFam_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtLegNumero_Internalname ;
   private String edtLegNumero_Jsonclick ;
   private String edtLegOrden_Internalname ;
   private String edtLegOrden_Jsonclick ;
   private String edtFamApellido_Internalname ;
   private String edtFamApellido_Jsonclick ;
   private String edtFamNombres_Internalname ;
   private String edtFamNombres_Jsonclick ;
   private String A750FamNroDoc ;
   private String Gx_mode ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String Dvpanel_panelliq_Objectcall ;
   private String Dvpanel_panelliq_Class ;
   private String Dvpanel_panelliq_Height ;
   private String hsh ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode24 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private String ZZ750FamNroDoc ;
   private String ZZ30ParCod ;
   private java.util.Date Z209FamFecNac ;
   private java.util.Date A209FamFecNac ;
   private java.util.Date ZZ209FamFecNac ;
   private boolean Z205FamDiscap ;
   private boolean Z199FamAsigFam ;
   private boolean Z890FamAdherente ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1547GuarCod ;
   private boolean wbErr ;
   private boolean A205FamDiscap ;
   private boolean n205FamDiscap ;
   private boolean A890FamAdherente ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_panelliq_Autowidth ;
   private boolean Dvpanel_panelliq_Autoheight ;
   private boolean Dvpanel_panelliq_Collapsible ;
   private boolean Dvpanel_panelliq_Collapsed ;
   private boolean Dvpanel_panelliq_Showcollapseicon ;
   private boolean Dvpanel_panelliq_Autoscroll ;
   private boolean A199FamAsigFam ;
   private boolean n209FamFecNac ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean Dvpanel_panelliq_Enabled ;
   private boolean Dvpanel_panelliq_Showheader ;
   private boolean Dvpanel_panelliq_Visible ;
   private boolean returnInSub ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean ZZ205FamDiscap ;
   private boolean ZZ199FamAsigFam ;
   private boolean ZZ890FamAdherente ;
   private String Z198FamApellido ;
   private String Z212FamNombres ;
   private String Z2090FamNomApe ;
   private String A198FamApellido ;
   private String A212FamNombres ;
   private String A2090FamNomApe ;
   private String A313ParDescrip ;
   private String Z313ParDescrip ;
   private String ZZ198FamApellido ;
   private String ZZ212FamNombres ;
   private String ZZ2090FamNomApe ;
   private String ZZ313ParDescrip ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelliq ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynParCod ;
   private ICheckbox chkFamDiscap ;
   private ICheckbox chkFamAdherente ;
   private IDataStoreProvider pr_default ;
   private short[] T000Q7_A29LegOrden ;
   private String[] T000Q7_A198FamApellido ;
   private String[] T000Q7_A212FamNombres ;
   private String[] T000Q7_A2090FamNomApe ;
   private String[] T000Q7_A313ParDescrip ;
   private java.util.Date[] T000Q7_A209FamFecNac ;
   private boolean[] T000Q7_n209FamFecNac ;
   private boolean[] T000Q7_A205FamDiscap ;
   private boolean[] T000Q7_n205FamDiscap ;
   private boolean[] T000Q7_A199FamAsigFam ;
   private java.math.BigDecimal[] T000Q7_A220FamTomaDeducImpGan ;
   private String[] T000Q7_A750FamNroDoc ;
   private short[] T000Q7_A751FamMesDesde ;
   private short[] T000Q7_A752FamMesHasta ;
   private boolean[] T000Q7_A890FamAdherente ;
   private int[] T000Q7_A3CliCod ;
   private short[] T000Q7_A1EmpCod ;
   private int[] T000Q7_A6LegNumero ;
   private String[] T000Q7_A30ParCod ;
   private short[] T000Q7_A1547GuarCod ;
   private boolean[] T000Q7_n1547GuarCod ;
   private String[] T000Q5_A313ParDescrip ;
   private int[] T000Q6_A3CliCod ;
   private int[] T000Q4_A3CliCod ;
   private String[] T000Q8_A313ParDescrip ;
   private int[] T000Q9_A3CliCod ;
   private int[] T000Q10_A3CliCod ;
   private int[] T000Q11_A3CliCod ;
   private short[] T000Q11_A1EmpCod ;
   private int[] T000Q11_A6LegNumero ;
   private short[] T000Q11_A29LegOrden ;
   private short[] T000Q3_A29LegOrden ;
   private String[] T000Q3_A198FamApellido ;
   private String[] T000Q3_A212FamNombres ;
   private String[] T000Q3_A2090FamNomApe ;
   private java.util.Date[] T000Q3_A209FamFecNac ;
   private boolean[] T000Q3_n209FamFecNac ;
   private boolean[] T000Q3_A205FamDiscap ;
   private boolean[] T000Q3_n205FamDiscap ;
   private boolean[] T000Q3_A199FamAsigFam ;
   private java.math.BigDecimal[] T000Q3_A220FamTomaDeducImpGan ;
   private String[] T000Q3_A750FamNroDoc ;
   private short[] T000Q3_A751FamMesDesde ;
   private short[] T000Q3_A752FamMesHasta ;
   private boolean[] T000Q3_A890FamAdherente ;
   private int[] T000Q3_A3CliCod ;
   private short[] T000Q3_A1EmpCod ;
   private int[] T000Q3_A6LegNumero ;
   private String[] T000Q3_A30ParCod ;
   private short[] T000Q3_A1547GuarCod ;
   private boolean[] T000Q3_n1547GuarCod ;
   private int[] T000Q12_A3CliCod ;
   private short[] T000Q12_A1EmpCod ;
   private int[] T000Q12_A6LegNumero ;
   private short[] T000Q12_A29LegOrden ;
   private int[] T000Q13_A3CliCod ;
   private short[] T000Q13_A1EmpCod ;
   private int[] T000Q13_A6LegNumero ;
   private short[] T000Q13_A29LegOrden ;
   private short[] T000Q2_A29LegOrden ;
   private String[] T000Q2_A198FamApellido ;
   private String[] T000Q2_A212FamNombres ;
   private String[] T000Q2_A2090FamNomApe ;
   private java.util.Date[] T000Q2_A209FamFecNac ;
   private boolean[] T000Q2_n209FamFecNac ;
   private boolean[] T000Q2_A205FamDiscap ;
   private boolean[] T000Q2_n205FamDiscap ;
   private boolean[] T000Q2_A199FamAsigFam ;
   private java.math.BigDecimal[] T000Q2_A220FamTomaDeducImpGan ;
   private String[] T000Q2_A750FamNroDoc ;
   private short[] T000Q2_A751FamMesDesde ;
   private short[] T000Q2_A752FamMesHasta ;
   private boolean[] T000Q2_A890FamAdherente ;
   private int[] T000Q2_A3CliCod ;
   private short[] T000Q2_A1EmpCod ;
   private int[] T000Q2_A6LegNumero ;
   private String[] T000Q2_A30ParCod ;
   private short[] T000Q2_A1547GuarCod ;
   private boolean[] T000Q2_n1547GuarCod ;
   private String[] T000Q17_A313ParDescrip ;
   private int[] T000Q18_A3CliCod ;
   private short[] T000Q18_A1EmpCod ;
   private int[] T000Q18_A6LegNumero ;
   private short[] T000Q18_A29LegOrden ;
   private int[] T000Q19_A3CliCod ;
   private String[] T000Q19_A30ParCod ;
   private String[] T000Q19_A313ParDescrip ;
   private boolean[] T000Q19_A314ParHabilitado ;
   private int[] T000Q20_A3CliCod ;
   private int[] T000Q21_A3CliCod ;
   private int[] T000Q22_A3CliCod ;
   private String[] T000Q23_A313ParDescrip ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class legajofamilia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000Q2", "SELECT LegOrden, FamApellido, FamNombres, FamNomApe, FamFecNac, FamDiscap, FamAsigFam, FamTomaDeducImpGan, FamNroDoc, FamMesDesde, FamMesHasta, FamAdherente, CliCod, EmpCod, LegNumero, ParCod, GuarCod FROM LegajoFamilia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ?  FOR UPDATE OF LegajoFamilia NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q3", "SELECT LegOrden, FamApellido, FamNombres, FamNomApe, FamFecNac, FamDiscap, FamAsigFam, FamTomaDeducImpGan, FamNroDoc, FamMesDesde, FamMesHasta, FamAdherente, CliCod, EmpCod, LegNumero, ParCod, GuarCod FROM LegajoFamilia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q4", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q5", "SELECT ParDescrip FROM Parentesco WHERE CliCod = ? AND ParCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q6", "SELECT CliCod FROM EmpresaGuarderias WHERE CliCod = ? AND EmpCod = ? AND GuarCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q7", "SELECT TM1.LegOrden, TM1.FamApellido, TM1.FamNombres, TM1.FamNomApe, T2.ParDescrip, TM1.FamFecNac, TM1.FamDiscap, TM1.FamAsigFam, TM1.FamTomaDeducImpGan, TM1.FamNroDoc, TM1.FamMesDesde, TM1.FamMesHasta, TM1.FamAdherente, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.ParCod, TM1.GuarCod FROM (LegajoFamilia TM1 INNER JOIN Parentesco T2 ON T2.CliCod = TM1.CliCod AND T2.ParCod = TM1.ParCod) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.LegOrden = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegOrden ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q8", "SELECT ParDescrip FROM Parentesco WHERE CliCod = ? AND ParCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q9", "SELECT CliCod FROM EmpresaGuarderias WHERE CliCod = ? AND EmpCod = ? AND GuarCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q10", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q11", "SELECT CliCod, EmpCod, LegNumero, LegOrden FROM LegajoFamilia WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q12", "SELECT CliCod, EmpCod, LegNumero, LegOrden FROM LegajoFamilia WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and LegNumero > ? or LegNumero = ? and EmpCod = ? and CliCod = ? and LegOrden > ?) ORDER BY CliCod, EmpCod, LegNumero, LegOrden  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Q13", "SELECT CliCod, EmpCod, LegNumero, LegOrden FROM LegajoFamilia WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and LegNumero < ? or LegNumero = ? and EmpCod = ? and CliCod = ? and LegOrden < ?) ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LegOrden DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000Q14", "SAVEPOINT gxupdate;INSERT INTO LegajoFamilia(LegOrden, FamApellido, FamNombres, FamNomApe, FamFecNac, FamDiscap, FamAsigFam, FamTomaDeducImpGan, FamNroDoc, FamMesDesde, FamMesHasta, FamAdherente, CliCod, EmpCod, LegNumero, ParCod, GuarCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000Q15", "SAVEPOINT gxupdate;UPDATE LegajoFamilia SET FamApellido=?, FamNombres=?, FamNomApe=?, FamFecNac=?, FamDiscap=?, FamAsigFam=?, FamTomaDeducImpGan=?, FamNroDoc=?, FamMesDesde=?, FamMesHasta=?, FamAdherente=?, ParCod=?, GuarCod=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000Q16", "SAVEPOINT gxupdate;DELETE FROM LegajoFamilia  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegOrden = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000Q17", "SELECT ParDescrip FROM Parentesco WHERE CliCod = ? AND ParCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q18", "SELECT CliCod, EmpCod, LegNumero, LegOrden FROM LegajoFamilia ORDER BY CliCod, EmpCod, LegNumero, LegOrden ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q19", "SELECT CliCod, ParCod, ParDescrip, ParHabilitado FROM Parentesco WHERE (CliCod = ?) AND (ParHabilitado = TRUE) ORDER BY ParDescrip ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q20", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q21", "SELECT CliCod FROM EmpresaGuarderias WHERE CliCod = ? AND EmpCod = ? AND GuarCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q22", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q23", "SELECT ParDescrip FROM Parentesco WHERE CliCod = ? AND ParCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(7);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(8,4);
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
               ((short[]) buf[11])[0] = rslt.getShort(10);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(12);
               ((int[]) buf[14])[0] = rslt.getInt(13);
               ((short[]) buf[15])[0] = rslt.getShort(14);
               ((int[]) buf[16])[0] = rslt.getInt(15);
               ((String[]) buf[17])[0] = rslt.getString(16, 20);
               ((short[]) buf[18])[0] = rslt.getShort(17);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(7);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(8,4);
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
               ((short[]) buf[11])[0] = rslt.getShort(10);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(12);
               ((int[]) buf[14])[0] = rslt.getInt(13);
               ((short[]) buf[15])[0] = rslt.getShort(14);
               ((int[]) buf[16])[0] = rslt.getInt(15);
               ((String[]) buf[17])[0] = rslt.getString(16, 20);
               ((short[]) buf[18])[0] = rslt.getShort(17);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((boolean[]) buf[9])[0] = rslt.getBoolean(8);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(9,4);
               ((String[]) buf[11])[0] = rslt.getString(10, 20);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(13);
               ((int[]) buf[15])[0] = rslt.getInt(14);
               ((short[]) buf[16])[0] = rslt.getShort(15);
               ((int[]) buf[17])[0] = rslt.getInt(16);
               ((String[]) buf[18])[0] = rslt.getString(17, 20);
               ((short[]) buf[19])[0] = rslt.getShort(18);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[3]).shortValue());
               }
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[3]).shortValue());
               }
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
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
               stmt.setShort(10, ((Number) parms[9]).shortValue());
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
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 30, false);
               stmt.setVarchar(3, (String)parms[2], 30, false);
               stmt.setVarchar(4, (String)parms[3], 40, false);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.DATE );
               }
               else
               {
                  stmt.setDate(5, (java.util.Date)parms[5]);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(6, ((Boolean) parms[7]).booleanValue());
               }
               stmt.setBoolean(7, ((Boolean) parms[8]).booleanValue());
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[9], 4);
               stmt.setString(9, (String)parms[10], 20);
               stmt.setShort(10, ((Number) parms[11]).shortValue());
               stmt.setShort(11, ((Number) parms[12]).shortValue());
               stmt.setBoolean(12, ((Boolean) parms[13]).booleanValue());
               stmt.setInt(13, ((Number) parms[14]).intValue());
               stmt.setShort(14, ((Number) parms[15]).shortValue());
               stmt.setInt(15, ((Number) parms[16]).intValue());
               stmt.setString(16, (String)parms[17], 20);
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(17, ((Number) parms[19]).shortValue());
               }
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 30, false);
               stmt.setVarchar(2, (String)parms[1], 30, false);
               stmt.setVarchar(3, (String)parms[2], 40, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.DATE );
               }
               else
               {
                  stmt.setDate(4, (java.util.Date)parms[4]);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(5, ((Boolean) parms[6]).booleanValue());
               }
               stmt.setBoolean(6, ((Boolean) parms[7]).booleanValue());
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[8], 4);
               stmt.setString(8, (String)parms[9], 20);
               stmt.setShort(9, ((Number) parms[10]).shortValue());
               stmt.setShort(10, ((Number) parms[11]).shortValue());
               stmt.setBoolean(11, ((Boolean) parms[12]).booleanValue());
               stmt.setString(12, (String)parms[13], 20);
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(13, ((Number) parms[15]).shortValue());
               }
               stmt.setInt(14, ((Number) parms[16]).intValue());
               stmt.setShort(15, ((Number) parms[17]).shortValue());
               stmt.setInt(16, ((Number) parms[18]).intValue());
               stmt.setShort(17, ((Number) parms[19]).shortValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[3]).shortValue());
               }
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

