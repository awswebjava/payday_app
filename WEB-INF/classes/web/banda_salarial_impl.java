package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class banda_salarial_impl extends GXDataArea
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
      gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"EMPCOD") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlaempcod6O301( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel5"+"_"+"CLICOD") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx5asaclicod6O301( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_14") == 0 )
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
         gxload_14( A3CliCod, A1EmpCod) ;
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
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_valores") == 0 )
      {
         gxnrgridlevel_valores_newrow_invoke( ) ;
         return  ;
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
      if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
      {
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
            AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
            AV9BanSalCod = GXutil.strToGuid(httpContext.GetPar( "BanSalCod")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9BanSalCod", AV9BanSalCod.toString());
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vBANSALCOD", getSecureSignedToken( "", AV9BanSalCod));
         }
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
         Form.getMeta().addItem("description", httpContext.getMessage( "banda_salarial", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtBanSalCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel_valores_newrow_invoke( )
   {
      nRC_GXsfl_56 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_56"))) ;
      nGXsfl_56_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_56_idx"))) ;
      sGXsfl_56_idx = httpContext.GetPar( "sGXsfl_56_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_valores_newrow( ) ;
      /* End function gxnrGridlevel_valores_newrow_invoke */
   }

   public banda_salarial_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public banda_salarial_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( banda_salarial_impl.class ));
   }

   public banda_salarial_impl( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynEmpCod = new HTMLChoice();
      cmbBanSalFrecPag = new HTMLChoice();
      cmbBanSalTipoTarifa = new HTMLChoice();
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.newmasterpage");
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
      if ( dynEmpCod.getItemCount() > 0 )
      {
         A1EmpCod = (short)(GXutil.lval( dynEmpCod.getValidValue(GXutil.trim( GXutil.str( A1EmpCod, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynEmpCod.setValue( GXutil.trim( GXutil.str( A1EmpCod, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynEmpCod.getInternalname(), "Values", dynEmpCod.ToJavascriptSource(), true);
      }
      if ( cmbBanSalFrecPag.getItemCount() > 0 )
      {
         A2421BanSalFrecPag = (byte)(GXutil.lval( cmbBanSalFrecPag.getValidValue(GXutil.trim( GXutil.str( A2421BanSalFrecPag, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2421BanSalFrecPag", GXutil.str( A2421BanSalFrecPag, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbBanSalFrecPag.setValue( GXutil.trim( GXutil.str( A2421BanSalFrecPag, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbBanSalFrecPag.getInternalname(), "Values", cmbBanSalFrecPag.ToJavascriptSource(), true);
      }
      if ( cmbBanSalTipoTarifa.getItemCount() > 0 )
      {
         A2422BanSalTipoTarifa = cmbBanSalTipoTarifa.getValidValue(A2422BanSalTipoTarifa) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2422BanSalTipoTarifa", A2422BanSalTipoTarifa);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbBanSalTipoTarifa.setValue( GXutil.rtrim( A2422BanSalTipoTarifa) );
         httpContext.ajax_rsp_assign_prop("", false, cmbBanSalTipoTarifa.getInternalname(), "Values", cmbBanSalTipoTarifa.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtBanSalCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtBanSalCod_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtBanSalCod_Internalname, A2418BanSalCod.toString(), A2418BanSalCod.toString(), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtBanSalCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtBanSalCod_Enabled, 1, "text", "", 36, "chr", 1, "row", 36, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "", "", false, "", "HLP_banda_salarial.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynEmpCod.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynEmpCod.getInternalname(), httpContext.getMessage( "Empresa", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynEmpCod, dynEmpCod.getInternalname(), GXutil.trim( GXutil.str( A1EmpCod, 4, 0)), 1, dynEmpCod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynEmpCod.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_banda_salarial.htm");
      dynEmpCod.setValue( GXutil.trim( GXutil.str( A1EmpCod, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynEmpCod.getInternalname(), "Values", dynEmpCod.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtBanSaNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtBanSaNombre_Internalname, httpContext.getMessage( "Nombre", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtBanSaNombre_Internalname, A2419BanSaNombre, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", (short)(0), 1, edtBanSaNombre_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "Descrip", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_banda_salarial.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtBanSalDescripcion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtBanSalDescripcion_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtBanSalDescripcion_Internalname, A2420BanSalDescripcion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", (short)(0), 1, edtBanSalDescripcion_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_banda_salarial.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbBanSalFrecPag.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbBanSalFrecPag.getInternalname(), httpContext.getMessage( "Frecuencia de pago", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbBanSalFrecPag, cmbBanSalFrecPag.getInternalname(), GXutil.trim( GXutil.str( A2421BanSalFrecPag, 1, 0)), 1, cmbBanSalFrecPag.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbBanSalFrecPag.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "", true, (byte)(0), "HLP_banda_salarial.htm");
      cmbBanSalFrecPag.setValue( GXutil.trim( GXutil.str( A2421BanSalFrecPag, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbBanSalFrecPag.getInternalname(), "Values", cmbBanSalFrecPag.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbBanSalTipoTarifa.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbBanSalTipoTarifa.getInternalname(), httpContext.getMessage( "Tipo de tarifa", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbBanSalTipoTarifa, cmbBanSalTipoTarifa.getInternalname(), GXutil.rtrim( A2422BanSalTipoTarifa), 1, cmbBanSalTipoTarifa.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbBanSalTipoTarifa.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "", true, (byte)(0), "HLP_banda_salarial.htm");
      cmbBanSalTipoTarifa.setValue( GXutil.rtrim( A2422BanSalTipoTarifa) );
      httpContext.ajax_rsp_assign_prop("", false, cmbBanSalTipoTarifa.getInternalname(), "Values", cmbBanSalTipoTarifa.ToJavascriptSource(), true);
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
      httpContext.writeText( "<td class='CellMarginTop'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_valores_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol56( ) ;
      nGXsfl_56_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount302 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_302 = (short)(1) ;
            scanStart6O302( ) ;
            while ( RcdFound302 != 0 )
            {
               init_level_properties302( ) ;
               getByPrimaryKey6O302( ) ;
               addRow6O302( ) ;
               scanNext6O302( ) ;
            }
            scanEnd6O302( ) ;
            nBlankRcdCount302 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal6O302( ) ;
         standaloneModal6O302( ) ;
         sMode302 = Gx_mode ;
         while ( nGXsfl_56_idx < nRC_GXsfl_56 )
         {
            bGXsfl_56_Refreshing = true ;
            readRow6O302( ) ;
            edtBanSalVigencia_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "BANSALVIGENCIA_"+sGXsfl_56_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtBanSalVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanSalVigencia_Enabled), 5, 0), !bGXsfl_56_Refreshing);
            edtBanSalValor_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "BANSALVALOR_"+sGXsfl_56_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtBanSalValor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanSalValor_Enabled), 5, 0), !bGXsfl_56_Refreshing);
            if ( ( nRcdExists_302 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal6O302( ) ;
            }
            sendRow6O302( ) ;
            bGXsfl_56_Refreshing = false ;
         }
         Gx_mode = sMode302 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount302 = (short)(5) ;
         nRcdExists_302 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart6O302( ) ;
            while ( RcdFound302 != 0 )
            {
               sGXsfl_56_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_56302( ) ;
               init_level_properties302( ) ;
               standaloneNotModal6O302( ) ;
               getByPrimaryKey6O302( ) ;
               standaloneModal6O302( ) ;
               addRow6O302( ) ;
               scanNext6O302( ) ;
            }
            scanEnd6O302( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode302 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_56_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_56302( ) ;
         initAll6O302( ) ;
         init_level_properties302( ) ;
         nRcdExists_302 = (short)(0) ;
         nIsMod_302 = (short)(0) ;
         nRcdDeleted_302 = (short)(0) ;
         nBlankRcdCount302 = (short)(nBlankRcdUsr302+nBlankRcdCount302) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount302 > 0 )
         {
            standaloneNotModal6O302( ) ;
            standaloneModal6O302( ) ;
            addRow6O302( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtBanSalVigencia_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount302 = (short)(nBlankRcdCount302-1) ;
         }
         Gx_mode = sMode302 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_valoresContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_valores", Gridlevel_valoresContainer, subGridlevel_valores_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_valoresContainerData", Gridlevel_valoresContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_valoresContainerData"+"V", Gridlevel_valoresContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_valoresContainerData"+"V"+"\" value='"+Gridlevel_valoresContainer.GridValuesHidden()+"'/>") ;
      }
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_banda_salarial.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_banda_salarial.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_banda_salarial.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,71);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_banda_salarial.htm");
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
      e116O2 ();
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
            Z2418BanSalCod = GXutil.strToGuid(httpContext.cgiGet( "Z2418BanSalCod")) ;
            Z2419BanSaNombre = httpContext.cgiGet( "Z2419BanSaNombre") ;
            Z2421BanSalFrecPag = (byte)(localUtil.ctol( httpContext.cgiGet( "Z2421BanSalFrecPag"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2422BanSalTipoTarifa = httpContext.cgiGet( "Z2422BanSalTipoTarifa") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_56 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_56"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9BanSalCod = GXutil.strToGuid(httpContext.cgiGet( "vBANSALCOD")) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV15Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            /* Read variables values. */
            if ( GXutil.strcmp(httpContext.cgiGet( edtBanSalCod_Internalname), "") == 0 )
            {
               A2418BanSalCod = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
               httpContext.ajax_rsp_assign_attri("", false, "A2418BanSalCod", A2418BanSalCod.toString());
            }
            else
            {
               try
               {
                  A2418BanSalCod = GXutil.strToGuid(httpContext.cgiGet( edtBanSalCod_Internalname)) ;
                  httpContext.ajax_rsp_assign_attri("", false, "A2418BanSalCod", A2418BanSalCod.toString());
               }
               catch ( IllegalArgumentException  e)
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_invalidguid"), 1, "BANSALCOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtBanSalCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  wbErr = true ;
               }
            }
            dynEmpCod.setName( dynEmpCod.getInternalname() );
            dynEmpCod.setValue( httpContext.cgiGet( dynEmpCod.getInternalname()) );
            A1EmpCod = (short)(GXutil.lval( httpContext.cgiGet( dynEmpCod.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A2419BanSaNombre = httpContext.cgiGet( edtBanSaNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2419BanSaNombre", A2419BanSaNombre);
            A2420BanSalDescripcion = httpContext.cgiGet( edtBanSalDescripcion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2420BanSalDescripcion", A2420BanSalDescripcion);
            cmbBanSalFrecPag.setName( cmbBanSalFrecPag.getInternalname() );
            cmbBanSalFrecPag.setValue( httpContext.cgiGet( cmbBanSalFrecPag.getInternalname()) );
            A2421BanSalFrecPag = (byte)(GXutil.lval( httpContext.cgiGet( cmbBanSalFrecPag.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2421BanSalFrecPag", GXutil.str( A2421BanSalFrecPag, 1, 0));
            cmbBanSalTipoTarifa.setName( cmbBanSalTipoTarifa.getInternalname() );
            cmbBanSalTipoTarifa.setValue( httpContext.cgiGet( cmbBanSalTipoTarifa.getInternalname()) );
            A2422BanSalTipoTarifa = httpContext.cgiGet( cmbBanSalTipoTarifa.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2422BanSalTipoTarifa", A2422BanSalTipoTarifa);
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
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"banda_salarial");
            A1EmpCod = (short)(GXutil.lval( httpContext.cgiGet( dynEmpCod.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            forbiddenHiddens.add("EmpCod", localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || !( A2418BanSalCod.equals( Z2418BanSalCod ) ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("banda_salarial:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
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
               A2418BanSalCod = GXutil.strToGuid(httpContext.GetPar( "BanSalCod")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2418BanSalCod", A2418BanSalCod.toString());
               getEqualNoModal( ) ;
               gxaempcod_html6O301( AV7CliCod) ;
               if ( ! java.util.UUID.fromString("00000000-0000-0000-0000-000000000000").equals(AV9BanSalCod) )
               {
                  A2418BanSalCod = AV9BanSalCod ;
                  httpContext.ajax_rsp_assign_attri("", false, "A2418BanSalCod", A2418BanSalCod.toString());
               }
               else
               {
                  if ( isIns( )  && java.util.UUID.fromString("00000000-0000-0000-0000-000000000000").equals(A2418BanSalCod) && ( Gx_BScreen == 0 ) )
                  {
                     A2418BanSalCod = java.util.UUID.randomUUID( ) ;
                     httpContext.ajax_rsp_assign_attri("", false, "A2418BanSalCod", A2418BanSalCod.toString());
                  }
               }
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode301 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  gxaempcod_html6O301( AV7CliCod) ;
                  if ( ! java.util.UUID.fromString("00000000-0000-0000-0000-000000000000").equals(AV9BanSalCod) )
                  {
                     A2418BanSalCod = AV9BanSalCod ;
                     httpContext.ajax_rsp_assign_attri("", false, "A2418BanSalCod", A2418BanSalCod.toString());
                  }
                  else
                  {
                     if ( isIns( )  && java.util.UUID.fromString("00000000-0000-0000-0000-000000000000").equals(A2418BanSalCod) && ( Gx_BScreen == 0 ) )
                     {
                        A2418BanSalCod = java.util.UUID.randomUUID( ) ;
                        httpContext.ajax_rsp_assign_attri("", false, "A2418BanSalCod", A2418BanSalCod.toString());
                     }
                  }
                  Gx_mode = sMode301 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound301 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_6O0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CLICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCliCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
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
                        e116O2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e126O2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                  }
                  else
                  {
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
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
         e126O2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll6O301( ) ;
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
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes6O301( ) ;
      }
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

   public void confirm_6O0( )
   {
      beforeValidate6O301( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls6O301( ) ;
         }
         else
         {
            checkExtendedTable6O301( ) ;
            closeExtendedTableCursors6O301( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode301 = Gx_mode ;
         confirm_6O302( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode301 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode301 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_6O302( )
   {
      nGXsfl_56_idx = 0 ;
      while ( nGXsfl_56_idx < nRC_GXsfl_56 )
      {
         readRow6O302( ) ;
         if ( ( nRcdExists_302 != 0 ) || ( nIsMod_302 != 0 ) )
         {
            getKey6O302( ) ;
            if ( ( nRcdExists_302 == 0 ) && ( nRcdDeleted_302 == 0 ) )
            {
               if ( RcdFound302 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate6O302( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable6O302( ) ;
                     closeExtendedTableCursors6O302( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "BANSALVIGENCIA_" + sGXsfl_56_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtBanSalVigencia_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound302 != 0 )
               {
                  if ( nRcdDeleted_302 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey6O302( ) ;
                     load6O302( ) ;
                     beforeValidate6O302( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls6O302( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_302 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate6O302( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable6O302( ) ;
                           closeExtendedTableCursors6O302( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_302 == 0 )
                  {
                     GXCCtl = "BANSALVIGENCIA_" + sGXsfl_56_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtBanSalVigencia_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtBanSalVigencia_Internalname, GXutil.ltrim( localUtil.ntoc( A2423BanSalVigencia, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtBanSalValor_Internalname, GXutil.ltrim( localUtil.ntoc( A2424BanSalValor, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2423BanSalVigencia_"+sGXsfl_56_idx, GXutil.ltrim( localUtil.ntoc( Z2423BanSalVigencia, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2424BanSalValor_"+sGXsfl_56_idx, GXutil.ltrim( localUtil.ntoc( Z2424BanSalValor, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_302_"+sGXsfl_56_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_302, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_302_"+sGXsfl_56_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_302, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_302_"+sGXsfl_56_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_302, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_302 != 0 )
         {
            httpContext.changePostValue( "BANSALVIGENCIA_"+sGXsfl_56_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtBanSalVigencia_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "BANSALVALOR_"+sGXsfl_56_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtBanSalValor_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption6O0( )
   {
   }

   public void e116O2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV10WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV10WWPContext = GXv_SdtWWPContext1[0] ;
      AV11IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWbanda_salarial_Insert", GXv_boolean3) ;
         banda_salarial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWbanda_salarial_Update", GXv_boolean3) ;
         banda_salarial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWbanda_salarial_Delete", GXv_boolean3) ;
         banda_salarial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV15Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
   }

   public void e126O2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm6O301( int GX_JID )
   {
      if ( ( GX_JID == 13 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2419BanSaNombre = T006O5_A2419BanSaNombre[0] ;
            Z2421BanSalFrecPag = T006O5_A2421BanSalFrecPag[0] ;
            Z2422BanSalTipoTarifa = T006O5_A2422BanSalTipoTarifa[0] ;
         }
         else
         {
            Z2419BanSaNombre = A2419BanSaNombre ;
            Z2421BanSalFrecPag = A2421BanSalFrecPag ;
            Z2422BanSalTipoTarifa = A2422BanSalTipoTarifa ;
         }
      }
      if ( GX_JID == -13 )
      {
         Z2418BanSalCod = A2418BanSalCod ;
         Z2419BanSaNombre = A2419BanSaNombre ;
         Z2420BanSalDescripcion = A2420BanSalDescripcion ;
         Z2421BanSalFrecPag = A2421BanSalFrecPag ;
         Z2422BanSalTipoTarifa = A2422BanSalTipoTarifa ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
      }
   }

   public void standaloneNotModal( )
   {
      dynEmpCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynEmpCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynEmpCod.getEnabled(), 5, 0), true);
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      dynEmpCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynEmpCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynEmpCod.getEnabled(), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxaempcod_html6O301( AV7CliCod) ;
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            banda_salarial_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8EmpCod) )
      {
         A1EmpCod = AV8EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      if ( ! java.util.UUID.fromString("00000000-0000-0000-0000-000000000000").equals(AV9BanSalCod) )
      {
         edtBanSalCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtBanSalCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanSalCod_Enabled), 5, 0), true);
      }
      else
      {
         edtBanSalCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtBanSalCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanSalCod_Enabled), 5, 0), true);
      }
      if ( ! java.util.UUID.fromString("00000000-0000-0000-0000-000000000000").equals(AV9BanSalCod) )
      {
         edtBanSalCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtBanSalCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanSalCod_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
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
      if ( ! java.util.UUID.fromString("00000000-0000-0000-0000-000000000000").equals(AV9BanSalCod) )
      {
         A2418BanSalCod = AV9BanSalCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A2418BanSalCod", A2418BanSalCod.toString());
      }
      else
      {
         if ( isIns( )  && java.util.UUID.fromString("00000000-0000-0000-0000-000000000000").equals(A2418BanSalCod) && ( Gx_BScreen == 0 ) )
         {
            A2418BanSalCod = java.util.UUID.randomUUID( ) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2418BanSalCod", A2418BanSalCod.toString());
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV15Pgmname = "banda_salarial" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
      }
   }

   public void load6O301( )
   {
      /* Using cursor T006O7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A2418BanSalCod});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound301 = (short)(1) ;
         A2419BanSaNombre = T006O7_A2419BanSaNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2419BanSaNombre", A2419BanSaNombre);
         A2420BanSalDescripcion = T006O7_A2420BanSalDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2420BanSalDescripcion", A2420BanSalDescripcion);
         A2421BanSalFrecPag = T006O7_A2421BanSalFrecPag[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2421BanSalFrecPag", GXutil.str( A2421BanSalFrecPag, 1, 0));
         A2422BanSalTipoTarifa = T006O7_A2422BanSalTipoTarifa[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2422BanSalTipoTarifa", A2422BanSalTipoTarifa);
         zm6O301( -13) ;
      }
      pr_default.close(5);
      onLoadActions6O301( ) ;
   }

   public void onLoadActions6O301( )
   {
      AV15Pgmname = "banda_salarial" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
   }

   public void checkExtendedTable6O301( )
   {
      nIsDirty_301 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV15Pgmname = "banda_salarial" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
      /* Using cursor T006O6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      if ( ! ( ( A2421BanSalFrecPag == 1 ) || ( A2421BanSalFrecPag == 2 ) || ( A2421BanSalFrecPag == 3 ) || ( A2421BanSalFrecPag == 4 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Frecuencia de pago", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "BANSALFRECPAG");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbBanSalFrecPag.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A2422BanSalTipoTarifa, "H") == 0 ) || ( GXutil.strcmp(A2422BanSalTipoTarifa, "P") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de tarifa", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "BANSALTIPOTARIFA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbBanSalTipoTarifa.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors6O301( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void gxload_14( int A3CliCod ,
                          short A1EmpCod )
   {
      /* Using cursor T006O8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
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

   public void getKey6O301( )
   {
      /* Using cursor T006O9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A2418BanSalCod});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound301 = (short)(1) ;
      }
      else
      {
         RcdFound301 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T006O5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A2418BanSalCod});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm6O301( 13) ;
         RcdFound301 = (short)(1) ;
         A2418BanSalCod = T006O5_A2418BanSalCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2418BanSalCod", A2418BanSalCod.toString());
         A2419BanSaNombre = T006O5_A2419BanSaNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2419BanSaNombre", A2419BanSaNombre);
         A2420BanSalDescripcion = T006O5_A2420BanSalDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2420BanSalDescripcion", A2420BanSalDescripcion);
         A2421BanSalFrecPag = T006O5_A2421BanSalFrecPag[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2421BanSalFrecPag", GXutil.str( A2421BanSalFrecPag, 1, 0));
         A2422BanSalTipoTarifa = T006O5_A2422BanSalTipoTarifa[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2422BanSalTipoTarifa", A2422BanSalTipoTarifa);
         A3CliCod = T006O5_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T006O5_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z2418BanSalCod = A2418BanSalCod ;
         sMode301 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load6O301( ) ;
         if ( AnyError == 1 )
         {
            RcdFound301 = (short)(0) ;
            initializeNonKey6O301( ) ;
         }
         Gx_mode = sMode301 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound301 = (short)(0) ;
         initializeNonKey6O301( ) ;
         sMode301 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode301 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(3);
   }

   public void getEqualNoModal( )
   {
      getKey6O301( ) ;
      if ( RcdFound301 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound301 = (short)(0) ;
      /* Using cursor T006O10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A2418BanSalCod});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T006O10_A3CliCod[0] < A3CliCod ) || ( T006O10_A3CliCod[0] == A3CliCod ) && ( T006O10_A1EmpCod[0] < A1EmpCod ) || ( T006O10_A1EmpCod[0] == A1EmpCod ) && ( T006O10_A3CliCod[0] == A3CliCod ) && ( GXutil.guidCompare(T006O10_A2418BanSalCod[0], A2418BanSalCod, 0) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T006O10_A3CliCod[0] > A3CliCod ) || ( T006O10_A3CliCod[0] == A3CliCod ) && ( T006O10_A1EmpCod[0] > A1EmpCod ) || ( T006O10_A1EmpCod[0] == A1EmpCod ) && ( T006O10_A3CliCod[0] == A3CliCod ) && ( GXutil.guidCompare(T006O10_A2418BanSalCod[0], A2418BanSalCod, 0) > 0 ) ) )
         {
            A3CliCod = T006O10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T006O10_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A2418BanSalCod = T006O10_A2418BanSalCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2418BanSalCod", A2418BanSalCod.toString());
            RcdFound301 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound301 = (short)(0) ;
      /* Using cursor T006O11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A2418BanSalCod});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T006O11_A3CliCod[0] > A3CliCod ) || ( T006O11_A3CliCod[0] == A3CliCod ) && ( T006O11_A1EmpCod[0] > A1EmpCod ) || ( T006O11_A1EmpCod[0] == A1EmpCod ) && ( T006O11_A3CliCod[0] == A3CliCod ) && ( GXutil.guidCompare(T006O11_A2418BanSalCod[0], A2418BanSalCod, 0) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T006O11_A3CliCod[0] < A3CliCod ) || ( T006O11_A3CliCod[0] == A3CliCod ) && ( T006O11_A1EmpCod[0] < A1EmpCod ) || ( T006O11_A1EmpCod[0] == A1EmpCod ) && ( T006O11_A3CliCod[0] == A3CliCod ) && ( GXutil.guidCompare(T006O11_A2418BanSalCod[0], A2418BanSalCod, 0) < 0 ) ) )
         {
            A3CliCod = T006O11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T006O11_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A2418BanSalCod = T006O11_A2418BanSalCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2418BanSalCod", A2418BanSalCod.toString());
            RcdFound301 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey6O301( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtBanSalCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert6O301( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound301 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || !( A2418BanSalCod.equals( Z2418BanSalCod ) ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A2418BanSalCod = Z2418BanSalCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A2418BanSalCod", A2418BanSalCod.toString());
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtBanSalCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update6O301( ) ;
               GX_FocusControl = edtBanSalCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || !( A2418BanSalCod.equals( Z2418BanSalCod ) ) )
            {
               /* Insert record */
               GX_FocusControl = edtBanSalCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert6O301( ) ;
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
                  /* Insert record */
                  GX_FocusControl = edtBanSalCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert6O301( ) ;
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
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || !( A2418BanSalCod.equals( Z2418BanSalCod ) ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A2418BanSalCod = Z2418BanSalCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A2418BanSalCod", A2418BanSalCod.toString());
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtBanSalCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency6O301( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T006O4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A2418BanSalCod});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"banda_salarial"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(2) == 101) || ( GXutil.strcmp(Z2419BanSaNombre, T006O4_A2419BanSaNombre[0]) != 0 ) || ( Z2421BanSalFrecPag != T006O4_A2421BanSalFrecPag[0] ) || ( GXutil.strcmp(Z2422BanSalTipoTarifa, T006O4_A2422BanSalTipoTarifa[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z2419BanSaNombre, T006O4_A2419BanSaNombre[0]) != 0 )
            {
               GXutil.writeLogln("banda_salarial:[seudo value changed for attri]"+"BanSaNombre");
               GXutil.writeLogRaw("Old: ",Z2419BanSaNombre);
               GXutil.writeLogRaw("Current: ",T006O4_A2419BanSaNombre[0]);
            }
            if ( Z2421BanSalFrecPag != T006O4_A2421BanSalFrecPag[0] )
            {
               GXutil.writeLogln("banda_salarial:[seudo value changed for attri]"+"BanSalFrecPag");
               GXutil.writeLogRaw("Old: ",Z2421BanSalFrecPag);
               GXutil.writeLogRaw("Current: ",T006O4_A2421BanSalFrecPag[0]);
            }
            if ( GXutil.strcmp(Z2422BanSalTipoTarifa, T006O4_A2422BanSalTipoTarifa[0]) != 0 )
            {
               GXutil.writeLogln("banda_salarial:[seudo value changed for attri]"+"BanSalTipoTarifa");
               GXutil.writeLogRaw("Old: ",Z2422BanSalTipoTarifa);
               GXutil.writeLogRaw("Current: ",T006O4_A2422BanSalTipoTarifa[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"banda_salarial"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert6O301( )
   {
      beforeValidate6O301( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6O301( ) ;
      }
      if ( AnyError == 0 )
      {
         zm6O301( 0) ;
         checkOptimisticConcurrency6O301( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm6O301( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert6O301( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006O12 */
                  pr_default.execute(10, new Object[] {A2418BanSalCod, A2419BanSaNombre, A2420BanSalDescripcion, Byte.valueOf(A2421BanSalFrecPag), A2422BanSalTipoTarifa, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("banda_salarial");
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
                        processLevel6O301( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption6O0( ) ;
                        }
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
            load6O301( ) ;
         }
         endLevel6O301( ) ;
      }
      closeExtendedTableCursors6O301( ) ;
   }

   public void update6O301( )
   {
      beforeValidate6O301( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6O301( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency6O301( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm6O301( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate6O301( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006O13 */
                  pr_default.execute(11, new Object[] {A2419BanSaNombre, A2420BanSalDescripcion, Byte.valueOf(A2421BanSalFrecPag), A2422BanSalTipoTarifa, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A2418BanSalCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("banda_salarial");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"banda_salarial"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate6O301( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel6O301( ) ;
                        if ( AnyError == 0 )
                        {
                           if ( isUpd( ) || isDlt( ) )
                           {
                              if ( AnyError == 0 )
                              {
                                 httpContext.nUserReturn = (byte)(1) ;
                              }
                           }
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
         }
         endLevel6O301( ) ;
      }
      closeExtendedTableCursors6O301( ) ;
   }

   public void deferredUpdate6O301( )
   {
   }

   public void delete( )
   {
      beforeValidate6O301( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency6O301( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls6O301( ) ;
         afterConfirm6O301( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete6O301( ) ;
            if ( AnyError == 0 )
            {
               scanStart6O302( ) ;
               while ( RcdFound302 != 0 )
               {
                  getByPrimaryKey6O302( ) ;
                  delete6O302( ) ;
                  scanNext6O302( ) ;
               }
               scanEnd6O302( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006O14 */
                  pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A2418BanSalCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("banda_salarial");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
                           }
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
         }
      }
      sMode301 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel6O301( ) ;
      Gx_mode = sMode301 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls6O301( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV15Pgmname = "banda_salarial" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15Pgmname", AV15Pgmname);
      }
   }

   public void processNestedLevel6O302( )
   {
      nGXsfl_56_idx = 0 ;
      while ( nGXsfl_56_idx < nRC_GXsfl_56 )
      {
         readRow6O302( ) ;
         if ( ( nRcdExists_302 != 0 ) || ( nIsMod_302 != 0 ) )
         {
            standaloneNotModal6O302( ) ;
            getKey6O302( ) ;
            if ( ( nRcdExists_302 == 0 ) && ( nRcdDeleted_302 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert6O302( ) ;
            }
            else
            {
               if ( RcdFound302 != 0 )
               {
                  if ( ( nRcdDeleted_302 != 0 ) && ( nRcdExists_302 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete6O302( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_302 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update6O302( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_302 == 0 )
                  {
                     GXCCtl = "BANSALVIGENCIA_" + sGXsfl_56_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtBanSalVigencia_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtBanSalVigencia_Internalname, GXutil.ltrim( localUtil.ntoc( A2423BanSalVigencia, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtBanSalValor_Internalname, GXutil.ltrim( localUtil.ntoc( A2424BanSalValor, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2423BanSalVigencia_"+sGXsfl_56_idx, GXutil.ltrim( localUtil.ntoc( Z2423BanSalVigencia, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2424BanSalValor_"+sGXsfl_56_idx, GXutil.ltrim( localUtil.ntoc( Z2424BanSalValor, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_302_"+sGXsfl_56_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_302, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_302_"+sGXsfl_56_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_302, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_302_"+sGXsfl_56_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_302, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_302 != 0 )
         {
            httpContext.changePostValue( "BANSALVIGENCIA_"+sGXsfl_56_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtBanSalVigencia_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "BANSALVALOR_"+sGXsfl_56_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtBanSalValor_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll6O302( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_302 = (short)(0) ;
      nIsMod_302 = (short)(0) ;
      nRcdDeleted_302 = (short)(0) ;
   }

   public void processLevel6O301( )
   {
      /* Save parent mode. */
      sMode301 = Gx_mode ;
      processNestedLevel6O302( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode301 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel6O301( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError == 0 )
      {
         beforeComplete6O301( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "banda_salarial");
         if ( AnyError == 0 )
         {
            confirmValues6O0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "banda_salarial");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart6O301( )
   {
      /* Scan By routine */
      /* Using cursor T006O15 */
      pr_default.execute(13);
      RcdFound301 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound301 = (short)(1) ;
         A3CliCod = T006O15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T006O15_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A2418BanSalCod = T006O15_A2418BanSalCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2418BanSalCod", A2418BanSalCod.toString());
      }
      /* Load Subordinate Levels */
   }

   public void scanNext6O301( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound301 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound301 = (short)(1) ;
         A3CliCod = T006O15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T006O15_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A2418BanSalCod = T006O15_A2418BanSalCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2418BanSalCod", A2418BanSalCod.toString());
      }
   }

   public void scanEnd6O301( )
   {
      pr_default.close(13);
   }

   public void afterConfirm6O301( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert6O301( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate6O301( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete6O301( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete6O301( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate6O301( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes6O301( )
   {
      edtBanSalCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtBanSalCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanSalCod_Enabled), 5, 0), true);
      dynEmpCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynEmpCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynEmpCod.getEnabled(), 5, 0), true);
      edtBanSaNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtBanSaNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanSaNombre_Enabled), 5, 0), true);
      edtBanSalDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtBanSalDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanSalDescripcion_Enabled), 5, 0), true);
      cmbBanSalFrecPag.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbBanSalFrecPag.getInternalname(), "Enabled", GXutil.ltrimstr( cmbBanSalFrecPag.getEnabled(), 5, 0), true);
      cmbBanSalTipoTarifa.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbBanSalTipoTarifa.getInternalname(), "Enabled", GXutil.ltrimstr( cmbBanSalTipoTarifa.getEnabled(), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
   }

   public void zm6O302( int GX_JID )
   {
      if ( ( GX_JID == 15 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2424BanSalValor = T006O3_A2424BanSalValor[0] ;
         }
         else
         {
            Z2424BanSalValor = A2424BanSalValor ;
         }
      }
      if ( GX_JID == -15 )
      {
         Z1EmpCod = A1EmpCod ;
         Z2418BanSalCod = A2418BanSalCod ;
         Z2423BanSalVigencia = A2423BanSalVigencia ;
         Z2424BanSalValor = A2424BanSalValor ;
         Z3CliCod = A3CliCod ;
      }
   }

   public void standaloneNotModal6O302( )
   {
   }

   public void standaloneModal6O302( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtBanSalVigencia_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtBanSalVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanSalVigencia_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      }
      else
      {
         edtBanSalVigencia_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtBanSalVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanSalVigencia_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      }
   }

   public void load6O302( )
   {
      /* Using cursor T006O16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A2418BanSalCod, Short.valueOf(A2423BanSalVigencia)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound302 = (short)(1) ;
         A2424BanSalValor = T006O16_A2424BanSalValor[0] ;
         zm6O302( -15) ;
      }
      pr_default.close(14);
      onLoadActions6O302( ) ;
   }

   public void onLoadActions6O302( )
   {
   }

   public void checkExtendedTable6O302( )
   {
      nIsDirty_302 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal6O302( ) ;
   }

   public void closeExtendedTableCursors6O302( )
   {
   }

   public void enableDisable6O302( )
   {
   }

   public void getKey6O302( )
   {
      /* Using cursor T006O17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A2418BanSalCod, Short.valueOf(A2423BanSalVigencia)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound302 = (short)(1) ;
      }
      else
      {
         RcdFound302 = (short)(0) ;
      }
      pr_default.close(15);
   }

   public void getByPrimaryKey6O302( )
   {
      /* Using cursor T006O3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A2418BanSalCod, Short.valueOf(A2423BanSalVigencia)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm6O302( 15) ;
         RcdFound302 = (short)(1) ;
         initializeNonKey6O302( ) ;
         A2423BanSalVigencia = T006O3_A2423BanSalVigencia[0] ;
         A2424BanSalValor = T006O3_A2424BanSalValor[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z2418BanSalCod = A2418BanSalCod ;
         Z2423BanSalVigencia = A2423BanSalVigencia ;
         sMode302 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load6O302( ) ;
         Gx_mode = sMode302 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound302 = (short)(0) ;
         initializeNonKey6O302( ) ;
         sMode302 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal6O302( ) ;
         Gx_mode = sMode302 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes6O302( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency6O302( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T006O2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A2418BanSalCod, Short.valueOf(A2423BanSalVigencia)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"banda_salarialvalores"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z2424BanSalValor, T006O2_A2424BanSalValor[0]) != 0 ) )
         {
            if ( DecimalUtil.compareTo(Z2424BanSalValor, T006O2_A2424BanSalValor[0]) != 0 )
            {
               GXutil.writeLogln("banda_salarial:[seudo value changed for attri]"+"BanSalValor");
               GXutil.writeLogRaw("Old: ",Z2424BanSalValor);
               GXutil.writeLogRaw("Current: ",T006O2_A2424BanSalValor[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"banda_salarialvalores"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert6O302( )
   {
      beforeValidate6O302( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6O302( ) ;
      }
      if ( AnyError == 0 )
      {
         zm6O302( 0) ;
         checkOptimisticConcurrency6O302( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm6O302( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert6O302( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006O18 */
                  pr_default.execute(16, new Object[] {Short.valueOf(A1EmpCod), A2418BanSalCod, Short.valueOf(A2423BanSalVigencia), A2424BanSalValor, Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("banda_salarialvalores");
                  if ( (pr_default.getStatus(16) == 1) )
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
            load6O302( ) ;
         }
         endLevel6O302( ) ;
      }
      closeExtendedTableCursors6O302( ) ;
   }

   public void update6O302( )
   {
      beforeValidate6O302( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6O302( ) ;
      }
      if ( ( nIsMod_302 != 0 ) || ( nIsDirty_302 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency6O302( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm6O302( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate6O302( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T006O19 */
                     pr_default.execute(17, new Object[] {A2424BanSalValor, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A2418BanSalCod, Short.valueOf(A2423BanSalVigencia)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("banda_salarialvalores");
                     if ( (pr_default.getStatus(17) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"banda_salarialvalores"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate6O302( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey6O302( ) ;
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
            endLevel6O302( ) ;
         }
      }
      closeExtendedTableCursors6O302( ) ;
   }

   public void deferredUpdate6O302( )
   {
   }

   public void delete6O302( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate6O302( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency6O302( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls6O302( ) ;
         afterConfirm6O302( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete6O302( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T006O20 */
               pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A2418BanSalCod, Short.valueOf(A2423BanSalVigencia)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("banda_salarialvalores");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode302 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel6O302( ) ;
      Gx_mode = sMode302 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls6O302( )
   {
      standaloneModal6O302( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel6O302( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart6O302( )
   {
      /* Scan By routine */
      /* Using cursor T006O21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A2418BanSalCod});
      RcdFound302 = (short)(0) ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound302 = (short)(1) ;
         A2423BanSalVigencia = T006O21_A2423BanSalVigencia[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext6O302( )
   {
      /* Scan next routine */
      pr_default.readNext(19);
      RcdFound302 = (short)(0) ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound302 = (short)(1) ;
         A2423BanSalVigencia = T006O21_A2423BanSalVigencia[0] ;
      }
   }

   public void scanEnd6O302( )
   {
      pr_default.close(19);
   }

   public void afterConfirm6O302( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert6O302( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate6O302( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete6O302( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete6O302( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate6O302( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes6O302( )
   {
      edtBanSalVigencia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtBanSalVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanSalVigencia_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtBanSalValor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtBanSalValor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanSalValor_Enabled), 5, 0), !bGXsfl_56_Refreshing);
   }

   public void send_integrity_lvl_hashes6O302( )
   {
   }

   public void send_integrity_lvl_hashes6O301( )
   {
   }

   public void subsflControlProps_56302( )
   {
      edtBanSalVigencia_Internalname = "BANSALVIGENCIA_"+sGXsfl_56_idx ;
      edtBanSalValor_Internalname = "BANSALVALOR_"+sGXsfl_56_idx ;
   }

   public void subsflControlProps_fel_56302( )
   {
      edtBanSalVigencia_Internalname = "BANSALVIGENCIA_"+sGXsfl_56_fel_idx ;
      edtBanSalValor_Internalname = "BANSALVALOR_"+sGXsfl_56_fel_idx ;
   }

   public void addRow6O302( )
   {
      nGXsfl_56_idx = (int)(nGXsfl_56_idx+1) ;
      sGXsfl_56_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_56302( ) ;
      sendRow6O302( ) ;
   }

   public void sendRow6O302( )
   {
      Gridlevel_valoresRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_valores_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_valores_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
         {
            subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_valores_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_valores_Backstyle = (byte)(0) ;
         subGridlevel_valores_Backcolor = subGridlevel_valores_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
         {
            subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_valores_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_valores_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
         {
            subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Odd" ;
         }
         subGridlevel_valores_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_valores_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_valores_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_56_idx) % (2))) == 0 )
         {
            subGridlevel_valores_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
            {
               subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_valores_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
            {
               subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_302_" + sGXsfl_56_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 57,'',false,'" + sGXsfl_56_idx + "',56)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_valoresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtBanSalVigencia_Internalname,GXutil.ltrim( localUtil.ntoc( A2423BanSalVigencia, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2423BanSalVigencia), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,57);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtBanSalVigencia_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtBanSalVigencia_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_302_" + sGXsfl_56_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 58,'',false,'" + sGXsfl_56_idx + "',56)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_valoresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtBanSalValor_Internalname,GXutil.ltrim( localUtil.ntoc( A2424BanSalValor, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtBanSalValor_Enabled!=0) ? localUtil.format( A2424BanSalValor, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A2424BanSalValor, "ZZ,ZZZ,ZZZ,ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,58);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtBanSalValor_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtBanSalValor_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel_valoresRow);
      send_integrity_lvl_hashes6O302( ) ;
      GXCCtl = "Z2423BanSalVigencia_" + sGXsfl_56_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2423BanSalVigencia, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2424BanSalValor_" + sGXsfl_56_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2424BanSalValor, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_302_" + sGXsfl_56_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_302, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_302_" + sGXsfl_56_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_302, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_302_" + sGXsfl_56_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_302, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_56_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_56_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vEMPCOD_" + sGXsfl_56_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vBANSALCOD_" + sGXsfl_56_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, AV9BanSalCod.toString());
      web.GxWebStd.gx_hidden_field( httpContext, "BANSALVIGENCIA_"+sGXsfl_56_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtBanSalVigencia_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "BANSALVALOR_"+sGXsfl_56_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtBanSalValor_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_valoresContainer.AddRow(Gridlevel_valoresRow);
   }

   public void readRow6O302( )
   {
      nGXsfl_56_idx = (int)(nGXsfl_56_idx+1) ;
      sGXsfl_56_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_56302( ) ;
      edtBanSalVigencia_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "BANSALVIGENCIA_"+sGXsfl_56_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtBanSalValor_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "BANSALVALOR_"+sGXsfl_56_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtBanSalVigencia_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtBanSalVigencia_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
      {
         GXCCtl = "BANSALVIGENCIA_" + sGXsfl_56_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtBanSalVigencia_Internalname ;
         wbErr = true ;
         A2423BanSalVigencia = (short)(0) ;
      }
      else
      {
         A2423BanSalVigencia = (short)(localUtil.ctol( httpContext.cgiGet( edtBanSalVigencia_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtBanSalValor_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtBanSalValor_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
      {
         GXCCtl = "BANSALVALOR_" + sGXsfl_56_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtBanSalValor_Internalname ;
         wbErr = true ;
         A2424BanSalValor = DecimalUtil.ZERO ;
      }
      else
      {
         A2424BanSalValor = localUtil.ctond( httpContext.cgiGet( edtBanSalValor_Internalname)) ;
      }
      GXCCtl = "Z2423BanSalVigencia_" + sGXsfl_56_idx ;
      Z2423BanSalVigencia = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2424BanSalValor_" + sGXsfl_56_idx ;
      Z2424BanSalValor = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "nRcdDeleted_302_" + sGXsfl_56_idx ;
      nRcdDeleted_302 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_302_" + sGXsfl_56_idx ;
      nRcdExists_302 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_302_" + sGXsfl_56_idx ;
      nIsMod_302 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtBanSalVigencia_Enabled = edtBanSalVigencia_Enabled ;
   }

   public void confirmValues6O0( )
   {
      nGXsfl_56_idx = 0 ;
      sGXsfl_56_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_56302( ) ;
      while ( nGXsfl_56_idx < nRC_GXsfl_56 )
      {
         nGXsfl_56_idx = (int)(nGXsfl_56_idx+1) ;
         sGXsfl_56_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_56302( ) ;
         httpContext.changePostValue( "Z2423BanSalVigencia_"+sGXsfl_56_idx, httpContext.cgiGet( "ZT_"+"Z2423BanSalVigencia_"+sGXsfl_56_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2423BanSalVigencia_"+sGXsfl_56_idx) ;
         httpContext.changePostValue( "Z2424BanSalValor_"+sGXsfl_56_idx, httpContext.cgiGet( "ZT_"+"Z2424BanSalValor_"+sGXsfl_56_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2424BanSalValor_"+sGXsfl_56_idx) ;
      }
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.banda_salarial", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(AV9BanSalCod.toString())}, new String[] {"Gx_mode","CliCod","EmpCod","BanSalCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"banda_salarial");
      forbiddenHiddens.add("EmpCod", localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("banda_salarial:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2418BanSalCod", Z2418BanSalCod.toString());
      web.GxWebStd.gx_hidden_field( httpContext, "Z2419BanSaNombre", Z2419BanSaNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2421BanSalFrecPag", GXutil.ltrim( localUtil.ntoc( Z2421BanSalFrecPag, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2422BanSalTipoTarifa", GXutil.rtrim( Z2422BanSalTipoTarifa));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_56", GXutil.ltrim( localUtil.ntoc( nGXsfl_56_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vBANSALCOD", AV9BanSalCod.toString());
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vBANSALCOD", getSecureSignedToken( "", AV9BanSalCod));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV15Pgmname));
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
      return formatLink("web.banda_salarial", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(AV9BanSalCod.toString())}, new String[] {"Gx_mode","CliCod","EmpCod","BanSalCod"})  ;
   }

   public String getPgmname( )
   {
      return "banda_salarial" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "banda_salarial", "") ;
   }

   public void initializeNonKey6O301( )
   {
      A2419BanSaNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2419BanSaNombre", A2419BanSaNombre);
      A2420BanSalDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2420BanSalDescripcion", A2420BanSalDescripcion);
      A2421BanSalFrecPag = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2421BanSalFrecPag", GXutil.str( A2421BanSalFrecPag, 1, 0));
      A2422BanSalTipoTarifa = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2422BanSalTipoTarifa", A2422BanSalTipoTarifa);
      Z2419BanSaNombre = "" ;
      Z2421BanSalFrecPag = (byte)(0) ;
      Z2422BanSalTipoTarifa = "" ;
   }

   public void initAll6O301( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A2418BanSalCod = java.util.UUID.randomUUID( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2418BanSalCod", A2418BanSalCod.toString());
      initializeNonKey6O301( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey6O302( )
   {
      A2424BanSalValor = DecimalUtil.ZERO ;
      Z2424BanSalValor = DecimalUtil.ZERO ;
   }

   public void initAll6O302( )
   {
      A2423BanSalVigencia = (short)(0) ;
      initializeNonKey6O302( ) ;
   }

   public void standaloneModalInsert6O302( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713253337", true, true);
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
      httpContext.AddJavascriptSource("banda_salarial.js", "?20251713253337", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties302( )
   {
      edtBanSalVigencia_Enabled = defedtBanSalVigencia_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtBanSalVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanSalVigencia_Enabled), 5, 0), !bGXsfl_56_Refreshing);
   }

   public void startgridcontrol56( )
   {
      Gridlevel_valoresContainer.AddObjectProperty("GridName", "Gridlevel_valores");
      Gridlevel_valoresContainer.AddObjectProperty("Header", subGridlevel_valores_Header);
      Gridlevel_valoresContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_valoresContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_valoresContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_valoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_valoresColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2423BanSalVigencia, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_valoresColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtBanSalVigencia_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddColumnProperties(Gridlevel_valoresColumn);
      Gridlevel_valoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_valoresColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2424BanSalValor, (byte)(17), (byte)(2), ".", "")));
      Gridlevel_valoresColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtBanSalValor_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddColumnProperties(Gridlevel_valoresColumn);
      Gridlevel_valoresContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      edtBanSalCod_Internalname = "BANSALCOD" ;
      dynEmpCod.setInternalname( "EMPCOD" );
      edtBanSaNombre_Internalname = "BANSANOMBRE" ;
      edtBanSalDescripcion_Internalname = "BANSALDESCRIPCION" ;
      cmbBanSalFrecPag.setInternalname( "BANSALFRECPAG" );
      cmbBanSalTipoTarifa.setInternalname( "BANSALTIPOTARIFA" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtBanSalVigencia_Internalname = "BANSALVIGENCIA" ;
      edtBanSalValor_Internalname = "BANSALVALOR" ;
      divTableleaflevel_valores_Internalname = "TABLELEAFLEVEL_VALORES" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel_valores_Internalname = "GRIDLEVEL_VALORES" ;
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
      subGridlevel_valores_Allowcollapsing = (byte)(0) ;
      subGridlevel_valores_Allowselection = (byte)(0) ;
      subGridlevel_valores_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "banda_salarial", "") );
      edtBanSalValor_Jsonclick = "" ;
      edtBanSalVigencia_Jsonclick = "" ;
      subGridlevel_valores_Class = "WorkWith" ;
      subGridlevel_valores_Backcolorstyle = (byte)(0) ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtBanSalValor_Enabled = 1 ;
      edtBanSalVigencia_Enabled = 1 ;
      cmbBanSalTipoTarifa.setJsonclick( "" );
      cmbBanSalTipoTarifa.setEnabled( 1 );
      cmbBanSalFrecPag.setJsonclick( "" );
      cmbBanSalFrecPag.setEnabled( 1 );
      edtBanSalDescripcion_Enabled = 1 ;
      edtBanSaNombre_Enabled = 1 ;
      dynEmpCod.setJsonclick( "" );
      dynEmpCod.setEnabled( 0 );
      edtBanSalCod_Jsonclick = "" ;
      edtBanSalCod_Enabled = 1 ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      divLayoutmaintable_Class = "Table" ;
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

   public void gxdlaempcod6O301( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaempcod_data6O301( AV7CliCod) ;
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

   public void gxaempcod_html6O301( int AV7CliCod )
   {
      short gxdynajaxvalue;
      gxdlaempcod_data6O301( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynEmpCod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynEmpCod.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaempcod_data6O301( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T006O22 */
      pr_default.execute(20, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(20) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T006O22_A1EmpCod[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T006O22_A2EmpNom[0]);
         pr_default.readNext(20);
      }
      pr_default.close(20);
   }

   public void gx5asaclicod6O301( int AV7CliCod )
   {
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            banda_salarial_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxnrgridlevel_valores_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_56302( ) ;
      while ( nGXsfl_56_idx <= nRC_GXsfl_56 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal6O302( ) ;
         standaloneModal6O302( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow6O302( ) ;
         nGXsfl_56_idx = (int)(nGXsfl_56_idx+1) ;
         sGXsfl_56_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_56302( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_valoresContainer)) ;
      /* End function gxnrGridlevel_valores_newrow */
   }

   public void init_web_controls( )
   {
      dynEmpCod.setName( "EMPCOD" );
      dynEmpCod.setWebtags( "" );
      cmbBanSalFrecPag.setName( "BANSALFRECPAG" );
      cmbBanSalFrecPag.setWebtags( "" );
      cmbBanSalFrecPag.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbBanSalFrecPag.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbBanSalFrecPag.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbBanSalFrecPag.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbBanSalFrecPag.getItemCount() > 0 )
      {
         A2421BanSalFrecPag = (byte)(GXutil.lval( cmbBanSalFrecPag.getValidValue(GXutil.trim( GXutil.str( A2421BanSalFrecPag, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2421BanSalFrecPag", GXutil.str( A2421BanSalFrecPag, 1, 0));
      }
      cmbBanSalTipoTarifa.setName( "BANSALTIPOTARIFA" );
      cmbBanSalTipoTarifa.setWebtags( "" );
      cmbBanSalTipoTarifa.addItem("H", httpContext.getMessage( "Por hora trabajada", ""), (short)(0));
      cmbBanSalTipoTarifa.addItem("P", httpContext.getMessage( "Por periodo trabajado", ""), (short)(0));
      if ( cmbBanSalTipoTarifa.getItemCount() > 0 )
      {
         A2422BanSalTipoTarifa = cmbBanSalTipoTarifa.getValidValue(A2422BanSalTipoTarifa) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2422BanSalTipoTarifa", A2422BanSalTipoTarifa);
      }
      /* End function init_web_controls */
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
      A1EmpCod = (short)(GXutil.lval( dynEmpCod.getValue())) ;
      /* Using cursor T006O23 */
      pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(21) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(21);
      dynload_actions( ) ;
      if ( dynEmpCod.getItemCount() > 0 )
      {
         A1EmpCod = (short)(GXutil.lval( dynEmpCod.getValidValue(GXutil.trim( GXutil.str( A1EmpCod, 4, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynEmpCod.setValue( GXutil.trim( GXutil.str( A1EmpCod, 4, 0)) );
      }
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9BanSalCod',fld:'vBANSALCOD',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9BanSalCod',fld:'vBANSALCOD',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
      setEventMetadata("AFTER TRN","{handler:'e126O2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_BANSALCOD","{handler:'valid_Bansalcod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_BANSALCOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_BANSALFRECPAG","{handler:'valid_Bansalfrecpag',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_BANSALFRECPAG",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_BANSALTIPOTARIFA","{handler:'valid_Bansaltipotarifa',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_BANSALTIPOTARIFA",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_BANSALVIGENCIA","{handler:'valid_Bansalvigencia',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_BANSALVIGENCIA",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
      setEventMetadata("NULL","{handler:'valid_Bansalvalor',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("NULL",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]}");
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
      pr_default.close(21);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV9BanSalCod = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      Z2418BanSalCod = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      Z2419BanSaNombre = "" ;
      Z2422BanSalTipoTarifa = "" ;
      Z2424BanSalValor = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV9BanSalCod = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A2422BanSalTipoTarifa = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A2418BanSalCod = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      ClassString = "" ;
      StyleString = "" ;
      A2419BanSaNombre = "" ;
      A2420BanSalDescripcion = "" ;
      Gridlevel_valoresContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode302 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV15Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode301 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A2424BanSalValor = DecimalUtil.ZERO ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      Z2420BanSalDescripcion = "" ;
      T006O7_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T006O7_A2419BanSaNombre = new String[] {""} ;
      T006O7_A2420BanSalDescripcion = new String[] {""} ;
      T006O7_A2421BanSalFrecPag = new byte[1] ;
      T006O7_A2422BanSalTipoTarifa = new String[] {""} ;
      T006O7_A3CliCod = new int[1] ;
      T006O7_A1EmpCod = new short[1] ;
      T006O6_A3CliCod = new int[1] ;
      T006O8_A3CliCod = new int[1] ;
      T006O9_A3CliCod = new int[1] ;
      T006O9_A1EmpCod = new short[1] ;
      T006O9_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T006O5_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T006O5_A2419BanSaNombre = new String[] {""} ;
      T006O5_A2420BanSalDescripcion = new String[] {""} ;
      T006O5_A2421BanSalFrecPag = new byte[1] ;
      T006O5_A2422BanSalTipoTarifa = new String[] {""} ;
      T006O5_A3CliCod = new int[1] ;
      T006O5_A1EmpCod = new short[1] ;
      T006O10_A3CliCod = new int[1] ;
      T006O10_A1EmpCod = new short[1] ;
      T006O10_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T006O11_A3CliCod = new int[1] ;
      T006O11_A1EmpCod = new short[1] ;
      T006O11_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T006O4_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T006O4_A2419BanSaNombre = new String[] {""} ;
      T006O4_A2420BanSalDescripcion = new String[] {""} ;
      T006O4_A2421BanSalFrecPag = new byte[1] ;
      T006O4_A2422BanSalTipoTarifa = new String[] {""} ;
      T006O4_A3CliCod = new int[1] ;
      T006O4_A1EmpCod = new short[1] ;
      T006O15_A3CliCod = new int[1] ;
      T006O15_A1EmpCod = new short[1] ;
      T006O15_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T006O16_A1EmpCod = new short[1] ;
      T006O16_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T006O16_A2423BanSalVigencia = new short[1] ;
      T006O16_A2424BanSalValor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006O16_A3CliCod = new int[1] ;
      T006O17_A3CliCod = new int[1] ;
      T006O17_A1EmpCod = new short[1] ;
      T006O17_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T006O17_A2423BanSalVigencia = new short[1] ;
      T006O3_A1EmpCod = new short[1] ;
      T006O3_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T006O3_A2423BanSalVigencia = new short[1] ;
      T006O3_A2424BanSalValor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006O3_A3CliCod = new int[1] ;
      T006O2_A1EmpCod = new short[1] ;
      T006O2_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T006O2_A2423BanSalVigencia = new short[1] ;
      T006O2_A2424BanSalValor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006O2_A3CliCod = new int[1] ;
      T006O21_A3CliCod = new int[1] ;
      T006O21_A1EmpCod = new short[1] ;
      T006O21_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T006O21_A2423BanSalVigencia = new short[1] ;
      Gridlevel_valoresRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_valores_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel_valoresColumn = new com.genexus.webpanels.GXWebColumn();
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T006O22_A3CliCod = new int[1] ;
      T006O22_A1EmpCod = new short[1] ;
      T006O22_A2EmpNom = new String[] {""} ;
      GXv_int5 = new int[1] ;
      T006O23_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.banda_salarial__default(),
         new Object[] {
             new Object[] {
            T006O2_A1EmpCod, T006O2_A2418BanSalCod, T006O2_A2423BanSalVigencia, T006O2_A2424BanSalValor, T006O2_A3CliCod
            }
            , new Object[] {
            T006O3_A1EmpCod, T006O3_A2418BanSalCod, T006O3_A2423BanSalVigencia, T006O3_A2424BanSalValor, T006O3_A3CliCod
            }
            , new Object[] {
            T006O4_A2418BanSalCod, T006O4_A2419BanSaNombre, T006O4_A2420BanSalDescripcion, T006O4_A2421BanSalFrecPag, T006O4_A2422BanSalTipoTarifa, T006O4_A3CliCod, T006O4_A1EmpCod
            }
            , new Object[] {
            T006O5_A2418BanSalCod, T006O5_A2419BanSaNombre, T006O5_A2420BanSalDescripcion, T006O5_A2421BanSalFrecPag, T006O5_A2422BanSalTipoTarifa, T006O5_A3CliCod, T006O5_A1EmpCod
            }
            , new Object[] {
            T006O6_A3CliCod
            }
            , new Object[] {
            T006O7_A2418BanSalCod, T006O7_A2419BanSaNombre, T006O7_A2420BanSalDescripcion, T006O7_A2421BanSalFrecPag, T006O7_A2422BanSalTipoTarifa, T006O7_A3CliCod, T006O7_A1EmpCod
            }
            , new Object[] {
            T006O8_A3CliCod
            }
            , new Object[] {
            T006O9_A3CliCod, T006O9_A1EmpCod, T006O9_A2418BanSalCod
            }
            , new Object[] {
            T006O10_A3CliCod, T006O10_A1EmpCod, T006O10_A2418BanSalCod
            }
            , new Object[] {
            T006O11_A3CliCod, T006O11_A1EmpCod, T006O11_A2418BanSalCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T006O15_A3CliCod, T006O15_A1EmpCod, T006O15_A2418BanSalCod
            }
            , new Object[] {
            T006O16_A1EmpCod, T006O16_A2418BanSalCod, T006O16_A2423BanSalVigencia, T006O16_A2424BanSalValor, T006O16_A3CliCod
            }
            , new Object[] {
            T006O17_A3CliCod, T006O17_A1EmpCod, T006O17_A2418BanSalCod, T006O17_A2423BanSalVigencia
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T006O21_A3CliCod, T006O21_A1EmpCod, T006O21_A2418BanSalCod, T006O21_A2423BanSalVigencia
            }
            , new Object[] {
            T006O22_A3CliCod, T006O22_A1EmpCod, T006O22_A2EmpNom
            }
            , new Object[] {
            T006O23_A3CliCod
            }
         }
      );
      Z2418BanSalCod = java.util.UUID.randomUUID( ) ;
      A2418BanSalCod = java.util.UUID.randomUUID( ) ;
      AV15Pgmname = "banda_salarial" ;
   }

   private byte Z2421BanSalFrecPag ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A2421BanSalFrecPag ;
   private byte Gx_BScreen ;
   private byte subGridlevel_valores_Backcolorstyle ;
   private byte subGridlevel_valores_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel_valores_Allowselection ;
   private byte subGridlevel_valores_Allowhovering ;
   private byte subGridlevel_valores_Allowcollapsing ;
   private byte subGridlevel_valores_Collapsed ;
   private short wcpOAV8EmpCod ;
   private short Z1EmpCod ;
   private short Z2423BanSalVigencia ;
   private short nRcdDeleted_302 ;
   private short nRcdExists_302 ;
   private short nIsMod_302 ;
   private short A1EmpCod ;
   private short AV8EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount302 ;
   private short RcdFound302 ;
   private short nBlankRcdUsr302 ;
   private short RcdFound301 ;
   private short A2423BanSalVigencia ;
   private short nIsDirty_301 ;
   private short nIsDirty_302 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int nRC_GXsfl_56 ;
   private int nGXsfl_56_idx=1 ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtBanSalCod_Enabled ;
   private int edtBanSaNombre_Enabled ;
   private int edtBanSalDescripcion_Enabled ;
   private int edtBanSalVigencia_Enabled ;
   private int edtBanSalValor_Enabled ;
   private int fRowAdded ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int subGridlevel_valores_Backcolor ;
   private int subGridlevel_valores_Allbackcolor ;
   private int defedtBanSalVigencia_Enabled ;
   private int idxLst ;
   private int subGridlevel_valores_Selectedindex ;
   private int subGridlevel_valores_Selectioncolor ;
   private int subGridlevel_valores_Hoveringcolor ;
   private int gxdynajaxindex ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private long GRIDLEVEL_VALORES_nFirstRecordOnPage ;
   private java.math.BigDecimal Z2424BanSalValor ;
   private java.math.BigDecimal A2424BanSalValor ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z2422BanSalTipoTarifa ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtBanSalCod_Internalname ;
   private String sGXsfl_56_idx="0001" ;
   private String A2422BanSalTipoTarifa ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
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
   private String edtBanSalCod_Jsonclick ;
   private String edtBanSaNombre_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtBanSalDescripcion_Internalname ;
   private String divTableleaflevel_valores_Internalname ;
   private String sMode302 ;
   private String edtBanSalVigencia_Internalname ;
   private String edtBanSalValor_Internalname ;
   private String subGridlevel_valores_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String AV15Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode301 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String sGXsfl_56_fel_idx="0001" ;
   private String subGridlevel_valores_Class ;
   private String subGridlevel_valores_Linesclass ;
   private String ROClassString ;
   private String edtBanSalVigencia_Jsonclick ;
   private String edtBanSalValor_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel_valores_Header ;
   private String gxwrpcisep ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean bGXsfl_56_Refreshing=false ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean gxdyncontrolsrefreshing ;
   private String A2420BanSalDescripcion ;
   private String Z2420BanSalDescripcion ;
   private String Z2419BanSaNombre ;
   private String A2419BanSaNombre ;
   private java.util.UUID wcpOAV9BanSalCod ;
   private java.util.UUID Z2418BanSalCod ;
   private java.util.UUID AV9BanSalCod ;
   private java.util.UUID A2418BanSalCod ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_valoresContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_valoresRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_valoresColumn ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynEmpCod ;
   private HTMLChoice cmbBanSalFrecPag ;
   private HTMLChoice cmbBanSalTipoTarifa ;
   private IDataStoreProvider pr_default ;
   private java.util.UUID[] T006O7_A2418BanSalCod ;
   private String[] T006O7_A2419BanSaNombre ;
   private String[] T006O7_A2420BanSalDescripcion ;
   private byte[] T006O7_A2421BanSalFrecPag ;
   private String[] T006O7_A2422BanSalTipoTarifa ;
   private int[] T006O7_A3CliCod ;
   private short[] T006O7_A1EmpCod ;
   private int[] T006O6_A3CliCod ;
   private int[] T006O8_A3CliCod ;
   private int[] T006O9_A3CliCod ;
   private short[] T006O9_A1EmpCod ;
   private java.util.UUID[] T006O9_A2418BanSalCod ;
   private java.util.UUID[] T006O5_A2418BanSalCod ;
   private String[] T006O5_A2419BanSaNombre ;
   private String[] T006O5_A2420BanSalDescripcion ;
   private byte[] T006O5_A2421BanSalFrecPag ;
   private String[] T006O5_A2422BanSalTipoTarifa ;
   private int[] T006O5_A3CliCod ;
   private short[] T006O5_A1EmpCod ;
   private int[] T006O10_A3CliCod ;
   private short[] T006O10_A1EmpCod ;
   private java.util.UUID[] T006O10_A2418BanSalCod ;
   private int[] T006O11_A3CliCod ;
   private short[] T006O11_A1EmpCod ;
   private java.util.UUID[] T006O11_A2418BanSalCod ;
   private java.util.UUID[] T006O4_A2418BanSalCod ;
   private String[] T006O4_A2419BanSaNombre ;
   private String[] T006O4_A2420BanSalDescripcion ;
   private byte[] T006O4_A2421BanSalFrecPag ;
   private String[] T006O4_A2422BanSalTipoTarifa ;
   private int[] T006O4_A3CliCod ;
   private short[] T006O4_A1EmpCod ;
   private int[] T006O15_A3CliCod ;
   private short[] T006O15_A1EmpCod ;
   private java.util.UUID[] T006O15_A2418BanSalCod ;
   private short[] T006O16_A1EmpCod ;
   private java.util.UUID[] T006O16_A2418BanSalCod ;
   private short[] T006O16_A2423BanSalVigencia ;
   private java.math.BigDecimal[] T006O16_A2424BanSalValor ;
   private int[] T006O16_A3CliCod ;
   private int[] T006O17_A3CliCod ;
   private short[] T006O17_A1EmpCod ;
   private java.util.UUID[] T006O17_A2418BanSalCod ;
   private short[] T006O17_A2423BanSalVigencia ;
   private short[] T006O3_A1EmpCod ;
   private java.util.UUID[] T006O3_A2418BanSalCod ;
   private short[] T006O3_A2423BanSalVigencia ;
   private java.math.BigDecimal[] T006O3_A2424BanSalValor ;
   private int[] T006O3_A3CliCod ;
   private short[] T006O2_A1EmpCod ;
   private java.util.UUID[] T006O2_A2418BanSalCod ;
   private short[] T006O2_A2423BanSalVigencia ;
   private java.math.BigDecimal[] T006O2_A2424BanSalValor ;
   private int[] T006O2_A3CliCod ;
   private int[] T006O21_A3CliCod ;
   private short[] T006O21_A1EmpCod ;
   private java.util.UUID[] T006O21_A2418BanSalCod ;
   private short[] T006O21_A2423BanSalVigencia ;
   private int[] T006O22_A3CliCod ;
   private short[] T006O22_A1EmpCod ;
   private String[] T006O22_A2EmpNom ;
   private int[] T006O23_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
}

final  class banda_salarial__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T006O2", "SELECT EmpCod, BanSalCod, BanSalVigencia, BanSalValor, CliCod FROM banda_salarialvalores WHERE CliCod = ? AND EmpCod = ? AND BanSalCod = ? AND BanSalVigencia = ?  FOR UPDATE OF banda_salarialvalores NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006O3", "SELECT EmpCod, BanSalCod, BanSalVigencia, BanSalValor, CliCod FROM banda_salarialvalores WHERE CliCod = ? AND EmpCod = ? AND BanSalCod = ? AND BanSalVigencia = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006O4", "SELECT BanSalCod, BanSaNombre, BanSalDescripcion, BanSalFrecPag, BanSalTipoTarifa, CliCod, EmpCod FROM banda_salarial WHERE CliCod = ? AND EmpCod = ? AND BanSalCod = ?  FOR UPDATE OF banda_salarial NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006O5", "SELECT BanSalCod, BanSaNombre, BanSalDescripcion, BanSalFrecPag, BanSalTipoTarifa, CliCod, EmpCod FROM banda_salarial WHERE CliCod = ? AND EmpCod = ? AND BanSalCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006O6", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006O7", "SELECT TM1.BanSalCod, TM1.BanSaNombre, TM1.BanSalDescripcion, TM1.BanSalFrecPag, TM1.BanSalTipoTarifa, TM1.CliCod, TM1.EmpCod FROM banda_salarial TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.BanSalCod = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.BanSalCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006O8", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006O9", "SELECT CliCod, EmpCod, BanSalCod FROM banda_salarial WHERE CliCod = ? AND EmpCod = ? AND BanSalCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006O10", "SELECT CliCod, EmpCod, BanSalCod FROM banda_salarial WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and BanSalCod > ?) ORDER BY CliCod, EmpCod, BanSalCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T006O11", "SELECT CliCod, EmpCod, BanSalCod FROM banda_salarial WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and BanSalCod < ?) ORDER BY CliCod DESC, EmpCod DESC, BanSalCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T006O12", "SAVEPOINT gxupdate;INSERT INTO banda_salarial(BanSalCod, BanSaNombre, BanSalDescripcion, BanSalFrecPag, BanSalTipoTarifa, CliCod, EmpCod) VALUES(?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006O13", "SAVEPOINT gxupdate;UPDATE banda_salarial SET BanSaNombre=?, BanSalDescripcion=?, BanSalFrecPag=?, BanSalTipoTarifa=?  WHERE CliCod = ? AND EmpCod = ? AND BanSalCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006O14", "SAVEPOINT gxupdate;DELETE FROM banda_salarial  WHERE CliCod = ? AND EmpCod = ? AND BanSalCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T006O15", "SELECT CliCod, EmpCod, BanSalCod FROM banda_salarial ORDER BY CliCod, EmpCod, BanSalCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006O16", "SELECT EmpCod, BanSalCod, BanSalVigencia, BanSalValor, CliCod FROM banda_salarialvalores WHERE CliCod = ? and EmpCod = ? and BanSalCod = ? and BanSalVigencia = ? ORDER BY CliCod, EmpCod, BanSalCod, BanSalVigencia ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006O17", "SELECT CliCod, EmpCod, BanSalCod, BanSalVigencia FROM banda_salarialvalores WHERE CliCod = ? AND EmpCod = ? AND BanSalCod = ? AND BanSalVigencia = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T006O18", "SAVEPOINT gxupdate;INSERT INTO banda_salarialvalores(EmpCod, BanSalCod, BanSalVigencia, BanSalValor, CliCod) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006O19", "SAVEPOINT gxupdate;UPDATE banda_salarialvalores SET BanSalValor=?  WHERE CliCod = ? AND EmpCod = ? AND BanSalCod = ? AND BanSalVigencia = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006O20", "SAVEPOINT gxupdate;DELETE FROM banda_salarialvalores  WHERE CliCod = ? AND EmpCod = ? AND BanSalCod = ? AND BanSalVigencia = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T006O21", "SELECT CliCod, EmpCod, BanSalCod, BanSalVigencia FROM banda_salarialvalores WHERE CliCod = ? and EmpCod = ? and BanSalCod = ? ORDER BY CliCod, EmpCod, BanSalCod, BanSalVigencia ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006O22", "SELECT CliCod, EmpCod, EmpNom FROM Empresa WHERE CliCod = ? ORDER BY EmpNom ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006O23", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 2 :
               ((java.util.UUID[]) buf[0])[0] = rslt.getGUID(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 3 :
               ((java.util.UUID[]) buf[0])[0] = rslt.getGUID(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((java.util.UUID[]) buf[0])[0] = rslt.getGUID(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.UUID[]) buf[2])[0] = rslt.getGUID(3);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.UUID[]) buf[2])[0] = rslt.getGUID(3);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.UUID[]) buf[2])[0] = rslt.getGUID(3);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.UUID[]) buf[2])[0] = rslt.getGUID(3);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.UUID[]) buf[2])[0] = rslt.getGUID(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.UUID[]) buf[2])[0] = rslt.getGUID(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 21 :
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
               stmt.setGUID(3, (java.util.UUID)parms[2]);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setGUID(3, (java.util.UUID)parms[2]);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setGUID(3, (java.util.UUID)parms[2]);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setGUID(3, (java.util.UUID)parms[2]);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setGUID(3, (java.util.UUID)parms[2]);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setGUID(3, (java.util.UUID)parms[2]);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setGUID(6, (java.util.UUID)parms[5]);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setGUID(6, (java.util.UUID)parms[5]);
               return;
            case 10 :
               stmt.setGUID(1, (java.util.UUID)parms[0]);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 1);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 1);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setGUID(7, (java.util.UUID)parms[6]);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setGUID(3, (java.util.UUID)parms[2]);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setGUID(3, (java.util.UUID)parms[2]);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setGUID(3, (java.util.UUID)parms[2]);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 17 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setGUID(4, (java.util.UUID)parms[3]);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setGUID(3, (java.util.UUID)parms[2]);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setGUID(3, (java.util.UUID)parms[2]);
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

