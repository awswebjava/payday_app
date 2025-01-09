package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajo_cuenta_licencias_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel12"+"_"+"CLICOD") == 0 )
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
         gx12asaclicod6F285( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_36") == 0 )
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
         gxload_36( A3CliCod, A1EmpCod, A6LegNumero) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_38") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A2341LegCuLAprLiqNro = (int)(GXutil.lval( httpContext.GetPar( "LegCuLAprLiqNro"))) ;
         n2341LegCuLAprLiqNro = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2341LegCuLAprLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2341LegCuLAprLiqNro), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_38( A3CliCod, A1EmpCod, A2341LegCuLAprLiqNro) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_39") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A2341LegCuLAprLiqNro = (int)(GXutil.lval( httpContext.GetPar( "LegCuLAprLiqNro"))) ;
         n2341LegCuLAprLiqNro = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2341LegCuLAprLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2341LegCuLAprLiqNro), 8, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_39( A3CliCod, A1EmpCod, A2341LegCuLAprLiqNro, A6LegNumero) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_41") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A2342LegCulConsLiqNro = (int)(GXutil.lval( httpContext.GetPar( "LegCulConsLiqNro"))) ;
         n2342LegCulConsLiqNro = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2342LegCulConsLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2342LegCulConsLiqNro), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_41( A3CliCod, A1EmpCod, A2342LegCulConsLiqNro) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_42") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A2342LegCulConsLiqNro = (int)(GXutil.lval( httpContext.GetPar( "LegCulConsLiqNro"))) ;
         n2342LegCulConsLiqNro = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2342LegCulConsLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2342LegCulConsLiqNro), 8, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_42( A3CliCod, A1EmpCod, A2342LegCulConsLiqNro, A6LegNumero) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_aprobaciones") == 0 )
      {
         gxnrgridlevel_aprobaciones_newrow_invoke( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_consumos") == 0 )
      {
         gxnrgridlevel_consumos_newrow_invoke( ) ;
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
            AV9LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9LegNumero), 8, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LegNumero), "ZZZZZZZ9")));
            AV10LegCuenLicTpo = httpContext.GetPar( "LegCuenLicTpo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10LegCuenLicTpo", AV10LegCuenLicTpo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGCUENLICTPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10LegCuenLicTpo, ""))));
            AV11LegCuenAnio = (short)(GXutil.lval( httpContext.GetPar( "LegCuenAnio"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11LegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11LegCuenAnio), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGCUENANIO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11LegCuenAnio), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "legajo_cuenta_licencias", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtLegCuenAnio_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel_aprobaciones_newrow_invoke( )
   {
      nRC_GXsfl_93 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_93"))) ;
      nGXsfl_93_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_93_idx"))) ;
      sGXsfl_93_idx = httpContext.GetPar( "sGXsfl_93_idx") ;
      Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_aprobaciones_newrow( ) ;
      /* End function gxnrGridlevel_aprobaciones_newrow_invoke */
   }

   public void gxnrgridlevel_consumos_newrow_invoke( )
   {
      nRC_GXsfl_107 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_107"))) ;
      nGXsfl_107_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_107_idx"))) ;
      sGXsfl_107_idx = httpContext.GetPar( "sGXsfl_107_idx") ;
      Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_consumos_newrow( ) ;
      /* End function gxnrGridlevel_consumos_newrow_invoke */
   }

   public legajo_cuenta_licencias_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajo_cuenta_licencias_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajo_cuenta_licencias_impl.class ));
   }

   public legajo_cuenta_licencias_impl( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkLegCuLIncluir = UIFactory.getCheckbox(this);
      cmbLegCuLAprLicOri = new HTMLChoice();
      cmbLegCuLConsOri = new HTMLChoice();
      cmbLegCuenLicTpo = new HTMLChoice();
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
      A2321LegCuLIncluir = GXutil.strtobool( GXutil.booltostr( A2321LegCuLIncluir)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2321LegCuLIncluir", A2321LegCuLIncluir);
      if ( cmbLegCuenLicTpo.getItemCount() > 0 )
      {
         A2243LegCuenLicTpo = cmbLegCuenLicTpo.getValidValue(A2243LegCuenLicTpo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbLegCuenLicTpo.setValue( GXutil.rtrim( A2243LegCuenLicTpo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLegCuenLicTpo.getInternalname(), "Values", cmbLegCuenLicTpo.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegIdNomApe_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegIdNomApe_Internalname, httpContext.getMessage( "Legajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegIdNomApe_Internalname, A250LegIdNomApe, GXutil.rtrim( localUtil.format( A250LegIdNomApe, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegIdNomApe_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegIdNomApe_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_legajo_cuenta_licencias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuenAnio_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegCuenAnio_Internalname, httpContext.getMessage( "Año", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuenAnio_Internalname, GXutil.ltrim( localUtil.ntoc( A2266LegCuenAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2266LegCuenAnio), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuenAnio_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuenAnio_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Anio", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuenLicPerIni_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegCuenLicPerIni_Internalname, httpContext.getMessage( "Inicio de periodo de correspondencia", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.writeText( "<div id=\""+edtLegCuenLicPerIni_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuenLicPerIni_Internalname, localUtil.format(A2244LegCuenLicPerIni, "99/99/9999"), localUtil.format( A2244LegCuenLicPerIni, "99/99/9999"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuenLicPerIni_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtLegCuenLicPerIni_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtLegCuenLicPerIni_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLegCuenLicPerIni_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_legajo_cuenta_licencias.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuenLicPerFin_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegCuenLicPerFin_Internalname, httpContext.getMessage( "Fin de periodo de correspondencia", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.writeText( "<div id=\""+edtLegCuenLicPerFin_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuenLicPerFin_Internalname, localUtil.format(A2245LegCuenLicPerFin, "99/99/9999"), localUtil.format( A2245LegCuenLicPerFin, "99/99/9999"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuenLicPerFin_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtLegCuenLicPerFin_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtLegCuenLicPerFin_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLegCuenLicPerFin_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_legajo_cuenta_licencias.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkLegCuLIncluir.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkLegCuLIncluir.getInternalname(), httpContext.getMessage( "Recorrer", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkLegCuLIncluir.getInternalname(), GXutil.booltostr( A2321LegCuLIncluir), "", httpContext.getMessage( "Recorrer", ""), 1, chkLegCuLIncluir.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(42, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,42);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuenDiasCorres_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegCuenDiasCorres_Internalname, httpContext.getMessage( "Cantidad de días que corresponden por antiguedad", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuenDiasCorres_Internalname, GXutil.ltrim( localUtil.ntoc( A2247LegCuenDiasCorres, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuenDiasCorres_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2247LegCuenDiasCorres), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2247LegCuenDiasCorres), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuenDiasCorres_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuenDiasCorres_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuLiPAnt_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegCuLiPAnt_Internalname, httpContext.getMessage( "Pendientes de años anteriores", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuLiPAnt_Internalname, GXutil.ltrim( localUtil.ntoc( A2303LegCuLiPAnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuLiPAnt_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2303LegCuLiPAnt), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2303LegCuLiPAnt), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuLiPAnt_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuLiPAnt_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuLiPVen_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegCuLiPVen_Internalname, httpContext.getMessage( "Pendientes de años anteriores vencidas", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuLiPVen_Internalname, GXutil.ltrim( localUtil.ntoc( A2304LegCuLiPVen, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuLiPVen_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2304LegCuLiPVen), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2304LegCuLiPVen), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuLiPVen_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuLiPVen_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuLiPCur_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegCuLiPCur_Internalname, httpContext.getMessage( "Pendientes actuales", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuLiPCur_Internalname, GXutil.ltrim( localUtil.ntoc( A2302LegCuLiPCur, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuLiPCur_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2302LegCuLiPCur), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2302LegCuLiPCur), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuLiPCur_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuLiPCur_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuLActVen_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegCuLActVen_Internalname, httpContext.getMessage( "Actuales (del periodo) a vencer", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuLActVen_Internalname, GXutil.ltrim( localUtil.ntoc( A2315LegCuLActVen, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuLActVen_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2315LegCuLActVen), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2315LegCuLActVen), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuLActVen_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuLActVen_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuLiPApr_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegCuLiPApr_Internalname, httpContext.getMessage( "Solicitadas y pendientes de aprobación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuLiPApr_Internalname, GXutil.ltrim( localUtil.ntoc( A2306LegCuLiPApr, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuLiPApr_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2306LegCuLiPApr), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2306LegCuLiPApr), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuLiPApr_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuLiPApr_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuenDiasGoz_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegCuenDiasGoz_Internalname, httpContext.getMessage( "Cantidad de días aprobados", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuenDiasGoz_Internalname, GXutil.ltrim( localUtil.ntoc( A2248LegCuenDiasGoz, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuenDiasGoz_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2248LegCuenDiasGoz), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2248LegCuenDiasGoz), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuenDiasGoz_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuenDiasGoz_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegCuLiPSaldo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegCuLiPSaldo_Internalname, httpContext.getMessage( "Total disponible", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuLiPSaldo_Internalname, GXutil.ltrim( localUtil.ntoc( A2305LegCuLiPSaldo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuLiPSaldo_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2305LegCuLiPSaldo), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2305LegCuLiPSaldo), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuLiPSaldo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegCuLiPSaldo_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
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
      ucDvpanel_unnamedtable1.setProperty("Width", Dvpanel_unnamedtable1_Width);
      ucDvpanel_unnamedtable1.setProperty("AutoWidth", Dvpanel_unnamedtable1_Autowidth);
      ucDvpanel_unnamedtable1.setProperty("AutoHeight", Dvpanel_unnamedtable1_Autoheight);
      ucDvpanel_unnamedtable1.setProperty("Cls", Dvpanel_unnamedtable1_Cls);
      ucDvpanel_unnamedtable1.setProperty("Title", Dvpanel_unnamedtable1_Title);
      ucDvpanel_unnamedtable1.setProperty("Collapsible", Dvpanel_unnamedtable1_Collapsible);
      ucDvpanel_unnamedtable1.setProperty("Collapsed", Dvpanel_unnamedtable1_Collapsed);
      ucDvpanel_unnamedtable1.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable1_Showcollapseicon);
      ucDvpanel_unnamedtable1.setProperty("IconPosition", Dvpanel_unnamedtable1_Iconposition);
      ucDvpanel_unnamedtable1.setProperty("AutoScroll", Dvpanel_unnamedtable1_Autoscroll);
      ucDvpanel_unnamedtable1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable1_Internalname, "DVPANEL_UNNAMEDTABLE1Container");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE1Container"+"UnnamedTable1"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 CellMarginTop", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_aprobaciones_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol93( ) ;
      nGXsfl_93_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount288 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_288 = (short)(1) ;
            scanStart6F288( ) ;
            while ( RcdFound288 != 0 )
            {
               init_level_properties288( ) ;
               getByPrimaryKey6F288( ) ;
               addRow6F288( ) ;
               scanNext6F288( ) ;
            }
            scanEnd6F288( ) ;
            nBlankRcdCount288 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal6F288( ) ;
         standaloneModal6F288( ) ;
         sMode288 = Gx_mode ;
         while ( nGXsfl_93_idx < nRC_GXsfl_93 )
         {
            bGXsfl_93_Refreshing = true ;
            readRow6F288( ) ;
            edtLegCuLAprLicFch_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULAPRLICFCH_"+sGXsfl_93_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtLegCuLAprLicFch_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLAprLicFch_Enabled), 5, 0), !bGXsfl_93_Refreshing);
            edtLegCuLAprLicCnt_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULAPRLICCNT_"+sGXsfl_93_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtLegCuLAprLicCnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLAprLicCnt_Enabled), 5, 0), !bGXsfl_93_Refreshing);
            cmbLegCuLAprLicOri.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULAPRLICORI_"+sGXsfl_93_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, cmbLegCuLAprLicOri.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegCuLAprLicOri.getEnabled(), 5, 0), !bGXsfl_93_Refreshing);
            if ( ( nRcdExists_288 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal6F288( ) ;
            }
            sendRow6F288( ) ;
            bGXsfl_93_Refreshing = false ;
         }
         Gx_mode = sMode288 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount288 = (short)(5) ;
         nRcdExists_288 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart6F288( ) ;
            while ( RcdFound288 != 0 )
            {
               sGXsfl_93_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_93_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_93288( ) ;
               init_level_properties288( ) ;
               standaloneNotModal6F288( ) ;
               getByPrimaryKey6F288( ) ;
               standaloneModal6F288( ) ;
               addRow6F288( ) ;
               scanNext6F288( ) ;
            }
            scanEnd6F288( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode288 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_93_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_93_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_93288( ) ;
         initAll6F288( ) ;
         init_level_properties288( ) ;
         nRcdExists_288 = (short)(0) ;
         nIsMod_288 = (short)(0) ;
         nRcdDeleted_288 = (short)(0) ;
         nBlankRcdCount288 = (short)(nBlankRcdUsr288+nBlankRcdCount288) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount288 > 0 )
         {
            standaloneNotModal6F288( ) ;
            standaloneModal6F288( ) ;
            addRow6F288( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtLegCuLAprLicFch_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount288 = (short)(nBlankRcdCount288-1) ;
         }
         Gx_mode = sMode288 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_aprobacionesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_aprobaciones", Gridlevel_aprobacionesContainer, subGridlevel_aprobaciones_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_aprobacionesContainerData", Gridlevel_aprobacionesContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_aprobacionesContainerData"+"V", Gridlevel_aprobacionesContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_aprobacionesContainerData"+"V"+"\" value='"+Gridlevel_aprobacionesContainer.GridValuesHidden()+"'/>") ;
      }
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      ucDvpanel_unnamedtable2.setProperty("Width", Dvpanel_unnamedtable2_Width);
      ucDvpanel_unnamedtable2.setProperty("AutoWidth", Dvpanel_unnamedtable2_Autowidth);
      ucDvpanel_unnamedtable2.setProperty("AutoHeight", Dvpanel_unnamedtable2_Autoheight);
      ucDvpanel_unnamedtable2.setProperty("Cls", Dvpanel_unnamedtable2_Cls);
      ucDvpanel_unnamedtable2.setProperty("Title", Dvpanel_unnamedtable2_Title);
      ucDvpanel_unnamedtable2.setProperty("Collapsible", Dvpanel_unnamedtable2_Collapsible);
      ucDvpanel_unnamedtable2.setProperty("Collapsed", Dvpanel_unnamedtable2_Collapsed);
      ucDvpanel_unnamedtable2.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable2_Showcollapseicon);
      ucDvpanel_unnamedtable2.setProperty("IconPosition", Dvpanel_unnamedtable2_Iconposition);
      ucDvpanel_unnamedtable2.setProperty("AutoScroll", Dvpanel_unnamedtable2_Autoscroll);
      ucDvpanel_unnamedtable2.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable2_Internalname, "DVPANEL_UNNAMEDTABLE2Container");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE2Container"+"UnnamedTable2"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divUnnamedtable2_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 CellMarginTop", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_consumos_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol107( ) ;
      nGXsfl_107_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount289 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_289 = (short)(1) ;
            scanStart6F289( ) ;
            while ( RcdFound289 != 0 )
            {
               init_level_properties289( ) ;
               getByPrimaryKey6F289( ) ;
               addRow6F289( ) ;
               scanNext6F289( ) ;
            }
            scanEnd6F289( ) ;
            nBlankRcdCount289 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal6F289( ) ;
         standaloneModal6F289( ) ;
         sMode289 = Gx_mode ;
         while ( nGXsfl_107_idx < nRC_GXsfl_107 )
         {
            bGXsfl_107_Refreshing = true ;
            readRow6F289( ) ;
            edtLegCuLConsAnio_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULCONSANIO_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtLegCuLConsAnio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLConsAnio_Enabled), 5, 0), !bGXsfl_107_Refreshing);
            edtLegCuLConsSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULCONSSEC_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtLegCuLConsSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLConsSec_Enabled), 5, 0), !bGXsfl_107_Refreshing);
            edtLegCuLConsCnt_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULCONSCNT_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtLegCuLConsCnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLConsCnt_Enabled), 5, 0), !bGXsfl_107_Refreshing);
            cmbLegCuLConsOri.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULCONSORI_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, cmbLegCuLConsOri.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegCuLConsOri.getEnabled(), 5, 0), !bGXsfl_107_Refreshing);
            if ( ( nRcdExists_289 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal6F289( ) ;
            }
            sendRow6F289( ) ;
            bGXsfl_107_Refreshing = false ;
         }
         Gx_mode = sMode289 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount289 = (short)(5) ;
         nRcdExists_289 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart6F289( ) ;
            while ( RcdFound289 != 0 )
            {
               sGXsfl_107_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_107_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_107289( ) ;
               init_level_properties289( ) ;
               standaloneNotModal6F289( ) ;
               getByPrimaryKey6F289( ) ;
               standaloneModal6F289( ) ;
               addRow6F289( ) ;
               scanNext6F289( ) ;
            }
            scanEnd6F289( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode289 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_107_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_107_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_107289( ) ;
         initAll6F289( ) ;
         init_level_properties289( ) ;
         nRcdExists_289 = (short)(0) ;
         nIsMod_289 = (short)(0) ;
         nRcdDeleted_289 = (short)(0) ;
         nBlankRcdCount289 = (short)(nBlankRcdUsr289+nBlankRcdCount289) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount289 > 0 )
         {
            standaloneNotModal6F289( ) ;
            standaloneModal6F289( ) ;
            addRow6F289( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtLegCuLConsAnio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount289 = (short)(nBlankRcdCount289-1) ;
         }
         Gx_mode = sMode289 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_consumosContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_consumos", Gridlevel_consumosContainer, subGridlevel_consumos_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_consumosContainerData", Gridlevel_consumosContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_consumosContainerData"+"V", Gridlevel_consumosContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_consumosContainerData"+"V"+"\" value='"+Gridlevel_consumosContainer.GridValuesHidden()+"'/>") ;
      }
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 119,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_legajo_cuenta_licencias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 121,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_legajo_cuenta_licencias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 123,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_legajo_cuenta_licencias.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 127,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,127);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 128,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,128);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 129,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,129);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", edtLegNumero_Visible, edtLegNumero_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 130,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbLegCuenLicTpo, cmbLegCuenLicTpo.getInternalname(), GXutil.rtrim( A2243LegCuenLicTpo), 1, cmbLegCuenLicTpo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbLegCuenLicTpo.getVisible(), cmbLegCuenLicTpo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,130);\"", "", true, (byte)(0), "HLP_legajo_cuenta_licencias.htm");
      cmbLegCuenLicTpo.setValue( GXutil.rtrim( A2243LegCuenLicTpo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegCuenLicTpo.getInternalname(), "Values", cmbLegCuenLicTpo.ToJavascriptSource(), true);
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 131,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuLRecalc_Internalname, GXutil.booltostr( A2322LegCuLRecalc), GXutil.booltostr( A2322LegCuLRecalc), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,131);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuLRecalc_Jsonclick, 0, "Attribute", "", "", "", "", edtLegCuLRecalc_Visible, edtLegCuLRecalc_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 132,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuenAntDias_Internalname, GXutil.ltrim( localUtil.ntoc( A2246LegCuenAntDias, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuenAntDias_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2246LegCuenAntDias), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2246LegCuenAntDias), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,132);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuenAntDias_Jsonclick, 0, "Attribute", "", "", "", "", edtLegCuenAntDias_Visible, edtLegCuenAntDias_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 133,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuenAntAnios_Internalname, GXutil.ltrim( localUtil.ntoc( A2299LegCuenAntAnios, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuenAntAnios_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2299LegCuenAntAnios), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2299LegCuenAntAnios), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,133);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuenAntAnios_Jsonclick, 0, "Attribute", "", "", "", "", edtLegCuenAntAnios_Visible, edtLegCuenAntAnios_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 134,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegCuenAntMeses_Internalname, GXutil.ltrim( localUtil.ntoc( A2300LegCuenAntMeses, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLegCuenAntMeses_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2300LegCuenAntMeses), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2300LegCuenAntMeses), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,134);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegCuenAntMeses_Jsonclick, 0, "Attribute", "", "", "", "", edtLegCuenAntMeses_Visible, edtLegCuenAntMeses_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_legajo_cuenta_licencias.htm");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 135,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtLegCueAntTexto_Internalname, A2301LegCueAntTexto, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,135);\"", (short)(0), edtLegCueAntTexto_Visible, edtLegCueAntTexto_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_legajo_cuenta_licencias.htm");
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
      e116F2 ();
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
            Z2243LegCuenLicTpo = httpContext.cgiGet( "Z2243LegCuenLicTpo") ;
            Z2266LegCuenAnio = (short)(localUtil.ctol( httpContext.cgiGet( "Z2266LegCuenAnio"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2315LegCuLActVen = (short)(localUtil.ctol( httpContext.cgiGet( "Z2315LegCuLActVen"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2313LegCuLTotCons = (int)(localUtil.ctol( httpContext.cgiGet( "Z2313LegCuLTotCons"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2314LegCuLTotCorr = (int)(localUtil.ctol( httpContext.cgiGet( "Z2314LegCuLTotCorr"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2244LegCuenLicPerIni = localUtil.ctod( httpContext.cgiGet( "Z2244LegCuenLicPerIni"), 0) ;
            Z2245LegCuenLicPerFin = localUtil.ctod( httpContext.cgiGet( "Z2245LegCuenLicPerFin"), 0) ;
            Z2246LegCuenAntDias = (int)(localUtil.ctol( httpContext.cgiGet( "Z2246LegCuenAntDias"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2299LegCuenAntAnios = (short)(localUtil.ctol( httpContext.cgiGet( "Z2299LegCuenAntAnios"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2300LegCuenAntMeses = (short)(localUtil.ctol( httpContext.cgiGet( "Z2300LegCuenAntMeses"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2247LegCuenDiasCorres = (short)(localUtil.ctol( httpContext.cgiGet( "Z2247LegCuenDiasCorres"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2248LegCuenDiasGoz = (short)(localUtil.ctol( httpContext.cgiGet( "Z2248LegCuenDiasGoz"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2249LegCuenDiasVig = (short)(localUtil.ctol( httpContext.cgiGet( "Z2249LegCuenDiasVig"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2328LegCueAntAbr = httpContext.cgiGet( "Z2328LegCueAntAbr") ;
            Z2302LegCuLiPCur = (short)(localUtil.ctol( httpContext.cgiGet( "Z2302LegCuLiPCur"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2303LegCuLiPAnt = (short)(localUtil.ctol( httpContext.cgiGet( "Z2303LegCuLiPAnt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2304LegCuLiPVen = (short)(localUtil.ctol( httpContext.cgiGet( "Z2304LegCuLiPVen"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2305LegCuLiPSaldo = (short)(localUtil.ctol( httpContext.cgiGet( "Z2305LegCuLiPSaldo"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2306LegCuLiPApr = (short)(localUtil.ctol( httpContext.cgiGet( "Z2306LegCuLiPApr"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2307LegCuLiAprPGoce = (short)(localUtil.ctol( httpContext.cgiGet( "Z2307LegCuLiAprPGoce"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2321LegCuLIncluir = GXutil.strtobool( httpContext.cgiGet( "Z2321LegCuLIncluir")) ;
            Z2322LegCuLRecalc = GXutil.strtobool( httpContext.cgiGet( "Z2322LegCuLRecalc")) ;
            A2313LegCuLTotCons = (int)(localUtil.ctol( httpContext.cgiGet( "Z2313LegCuLTotCons"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2314LegCuLTotCorr = (int)(localUtil.ctol( httpContext.cgiGet( "Z2314LegCuLTotCorr"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2249LegCuenDiasVig = (short)(localUtil.ctol( httpContext.cgiGet( "Z2249LegCuenDiasVig"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2328LegCueAntAbr = httpContext.cgiGet( "Z2328LegCueAntAbr") ;
            A2307LegCuLiAprPGoce = (short)(localUtil.ctol( httpContext.cgiGet( "Z2307LegCuLiAprPGoce"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_93 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_93"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            nRC_GXsfl_107 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_107"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "vLEGNUMERO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV10LegCuenLicTpo = httpContext.cgiGet( "vLEGCUENLICTPO") ;
            AV11LegCuenAnio = (short)(localUtil.ctol( httpContext.cgiGet( "vLEGCUENANIO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2313LegCuLTotCons = (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULTOTCONS"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2314LegCuLTotCorr = (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULTOTCORR"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2249LegCuenDiasVig = (short)(localUtil.ctol( httpContext.cgiGet( "LEGCUENDIASVIG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2328LegCueAntAbr = httpContext.cgiGet( "LEGCUEANTABR") ;
            A2307LegCuLiAprPGoce = (short)(localUtil.ctol( httpContext.cgiGet( "LEGCULIAPRPGOCE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2329LegCuLLogDis = httpContext.cgiGet( "LEGCULLOGDIS") ;
            A251LegNombre = httpContext.cgiGet( "LEGNOMBRE") ;
            A230LegApellido = httpContext.cgiGet( "LEGAPELLIDO") ;
            A93LegId = httpContext.cgiGet( "LEGID") ;
            n93LegId = false ;
            AV20Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2341LegCuLAprLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULAPRLIQNRO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n2341LegCuLAprLiqNro = ((0==A2341LegCuLAprLiqNro) ? true : false) ;
            A2342LegCulConsLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULCONSLIQNRO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n2342LegCulConsLiqNro = ((0==A2342LegCulConsLiqNro) ? true : false) ;
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
            Dvpanel_unnamedtable1_Objectcall = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Objectcall") ;
            Dvpanel_unnamedtable1_Class = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Class") ;
            Dvpanel_unnamedtable1_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Enabled")) ;
            Dvpanel_unnamedtable1_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Width") ;
            Dvpanel_unnamedtable1_Height = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Height") ;
            Dvpanel_unnamedtable1_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autowidth")) ;
            Dvpanel_unnamedtable1_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoheight")) ;
            Dvpanel_unnamedtable1_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Cls") ;
            Dvpanel_unnamedtable1_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Showheader")) ;
            Dvpanel_unnamedtable1_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Title") ;
            Dvpanel_unnamedtable1_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsible")) ;
            Dvpanel_unnamedtable1_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsed")) ;
            Dvpanel_unnamedtable1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Showcollapseicon")) ;
            Dvpanel_unnamedtable1_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Iconposition") ;
            Dvpanel_unnamedtable1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoscroll")) ;
            Dvpanel_unnamedtable1_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Visible")) ;
            Dvpanel_unnamedtable1_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Dvpanel_unnamedtable2_Objectcall = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Objectcall") ;
            Dvpanel_unnamedtable2_Class = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Class") ;
            Dvpanel_unnamedtable2_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Enabled")) ;
            Dvpanel_unnamedtable2_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Width") ;
            Dvpanel_unnamedtable2_Height = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Height") ;
            Dvpanel_unnamedtable2_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Autowidth")) ;
            Dvpanel_unnamedtable2_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Autoheight")) ;
            Dvpanel_unnamedtable2_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Cls") ;
            Dvpanel_unnamedtable2_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Showheader")) ;
            Dvpanel_unnamedtable2_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Title") ;
            Dvpanel_unnamedtable2_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Collapsible")) ;
            Dvpanel_unnamedtable2_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Collapsed")) ;
            Dvpanel_unnamedtable2_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Showcollapseicon")) ;
            Dvpanel_unnamedtable2_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Iconposition") ;
            Dvpanel_unnamedtable2_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Autoscroll")) ;
            Dvpanel_unnamedtable2_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Visible")) ;
            Dvpanel_unnamedtable2_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            A250LegIdNomApe = httpContext.cgiGet( edtLegIdNomApe_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A250LegIdNomApe", A250LegIdNomApe);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegCuenAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegCuenAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGCUENANIO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegCuenAnio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2266LegCuenAnio = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2266LegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2266LegCuenAnio), 4, 0));
            }
            else
            {
               A2266LegCuenAnio = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuenAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2266LegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2266LegCuenAnio), 4, 0));
            }
            A2244LegCuenLicPerIni = localUtil.ctod( httpContext.cgiGet( edtLegCuenLicPerIni_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2244LegCuenLicPerIni", localUtil.format(A2244LegCuenLicPerIni, "99/99/9999"));
            A2245LegCuenLicPerFin = localUtil.ctod( httpContext.cgiGet( edtLegCuenLicPerFin_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2245LegCuenLicPerFin", localUtil.format(A2245LegCuenLicPerFin, "99/99/9999"));
            A2321LegCuLIncluir = GXutil.strtobool( httpContext.cgiGet( chkLegCuLIncluir.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2321LegCuLIncluir", A2321LegCuLIncluir);
            A2247LegCuenDiasCorres = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuenDiasCorres_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2247LegCuenDiasCorres", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2247LegCuenDiasCorres), 4, 0));
            A2303LegCuLiPAnt = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2303LegCuLiPAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2303LegCuLiPAnt), 4, 0));
            A2304LegCuLiPVen = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPVen_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2304LegCuLiPVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2304LegCuLiPVen), 4, 0));
            A2302LegCuLiPCur = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPCur_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2302LegCuLiPCur", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2302LegCuLiPCur), 4, 0));
            A2315LegCuLActVen = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLActVen_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2315LegCuLActVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2315LegCuLActVen), 4, 0));
            A2306LegCuLiPApr = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPApr_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2306LegCuLiPApr", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2306LegCuLiPApr), 4, 0));
            A2248LegCuenDiasGoz = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuenDiasGoz_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2248LegCuenDiasGoz", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2248LegCuenDiasGoz), 4, 0));
            A2305LegCuLiPSaldo = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPSaldo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2305LegCuLiPSaldo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2305LegCuLiPSaldo), 4, 0));
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
            cmbLegCuenLicTpo.setName( cmbLegCuenLicTpo.getInternalname() );
            cmbLegCuenLicTpo.setValue( httpContext.cgiGet( cmbLegCuenLicTpo.getInternalname()) );
            A2243LegCuenLicTpo = httpContext.cgiGet( cmbLegCuenLicTpo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
            A2322LegCuLRecalc = GXutil.strtobool( httpContext.cgiGet( edtLegCuLRecalc_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2322LegCuLRecalc", A2322LegCuLRecalc);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegCuenAntDias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegCuenAntDias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGCUENANTDIAS");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegCuenAntDias_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2246LegCuenAntDias = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A2246LegCuenAntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2246LegCuenAntDias), 8, 0));
            }
            else
            {
               A2246LegCuenAntDias = (int)(localUtil.ctol( httpContext.cgiGet( edtLegCuenAntDias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2246LegCuenAntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2246LegCuenAntDias), 8, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegCuenAntAnios_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegCuenAntAnios_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGCUENANTANIOS");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegCuenAntAnios_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2299LegCuenAntAnios = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2299LegCuenAntAnios", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2299LegCuenAntAnios), 4, 0));
            }
            else
            {
               A2299LegCuenAntAnios = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuenAntAnios_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2299LegCuenAntAnios", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2299LegCuenAntAnios), 4, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegCuenAntMeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegCuenAntMeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGCUENANTMESES");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegCuenAntMeses_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2300LegCuenAntMeses = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2300LegCuenAntMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2300LegCuenAntMeses), 4, 0));
            }
            else
            {
               A2300LegCuenAntMeses = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuenAntMeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2300LegCuenAntMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2300LegCuenAntMeses), 4, 0));
            }
            A2301LegCueAntTexto = httpContext.cgiGet( edtLegCueAntTexto_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2301LegCueAntTexto", A2301LegCueAntTexto);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"legajo_cuenta_licencias");
            A2244LegCuenLicPerIni = localUtil.ctod( httpContext.cgiGet( edtLegCuenLicPerIni_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2244LegCuenLicPerIni", localUtil.format(A2244LegCuenLicPerIni, "99/99/9999"));
            forbiddenHiddens.add("LegCuenLicPerIni", localUtil.format(A2244LegCuenLicPerIni, "99/99/9999"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            A2315LegCuLActVen = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLActVen_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2315LegCuLActVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2315LegCuLActVen), 4, 0));
            forbiddenHiddens.add("LegCuLActVen", localUtil.format( DecimalUtil.doubleToDec(A2315LegCuLActVen), "ZZZ9"));
            forbiddenHiddens.add("LegCuLTotCons", localUtil.format( DecimalUtil.doubleToDec(A2313LegCuLTotCons), "ZZZZZZZ9"));
            forbiddenHiddens.add("LegCuLTotCorr", localUtil.format( DecimalUtil.doubleToDec(A2314LegCuLTotCorr), "ZZZZZZZ9"));
            A2245LegCuenLicPerFin = localUtil.ctod( httpContext.cgiGet( edtLegCuenLicPerFin_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2245LegCuenLicPerFin", localUtil.format(A2245LegCuenLicPerFin, "99/99/9999"));
            forbiddenHiddens.add("LegCuenLicPerFin", localUtil.format(A2245LegCuenLicPerFin, "99/99/9999"));
            A2247LegCuenDiasCorres = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuenDiasCorres_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2247LegCuenDiasCorres", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2247LegCuenDiasCorres), 4, 0));
            forbiddenHiddens.add("LegCuenDiasCorres", localUtil.format( DecimalUtil.doubleToDec(A2247LegCuenDiasCorres), "ZZZ9"));
            A2248LegCuenDiasGoz = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuenDiasGoz_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2248LegCuenDiasGoz", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2248LegCuenDiasGoz), 4, 0));
            forbiddenHiddens.add("LegCuenDiasGoz", localUtil.format( DecimalUtil.doubleToDec(A2248LegCuenDiasGoz), "ZZZ9"));
            forbiddenHiddens.add("LegCuenDiasVig", localUtil.format( DecimalUtil.doubleToDec(A2249LegCuenDiasVig), "ZZZ9"));
            forbiddenHiddens.add("LegCueAntAbr", GXutil.rtrim( localUtil.format( A2328LegCueAntAbr, "")));
            A2302LegCuLiPCur = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPCur_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2302LegCuLiPCur", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2302LegCuLiPCur), 4, 0));
            forbiddenHiddens.add("LegCuLiPCur", localUtil.format( DecimalUtil.doubleToDec(A2302LegCuLiPCur), "ZZZ9"));
            A2303LegCuLiPAnt = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2303LegCuLiPAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2303LegCuLiPAnt), 4, 0));
            forbiddenHiddens.add("LegCuLiPAnt", localUtil.format( DecimalUtil.doubleToDec(A2303LegCuLiPAnt), "ZZZ9"));
            A2304LegCuLiPVen = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPVen_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2304LegCuLiPVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2304LegCuLiPVen), 4, 0));
            forbiddenHiddens.add("LegCuLiPVen", localUtil.format( DecimalUtil.doubleToDec(A2304LegCuLiPVen), "ZZZ9"));
            A2305LegCuLiPSaldo = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPSaldo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2305LegCuLiPSaldo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2305LegCuLiPSaldo), 4, 0));
            forbiddenHiddens.add("LegCuLiPSaldo", localUtil.format( DecimalUtil.doubleToDec(A2305LegCuLiPSaldo), "ZZZ9"));
            A2306LegCuLiPApr = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPApr_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2306LegCuLiPApr", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2306LegCuLiPApr), 4, 0));
            forbiddenHiddens.add("LegCuLiPApr", localUtil.format( DecimalUtil.doubleToDec(A2306LegCuLiPApr), "ZZZ9"));
            forbiddenHiddens.add("LegCuLiAprPGoce", localUtil.format( DecimalUtil.doubleToDec(A2307LegCuLiAprPGoce), "ZZZ9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A2243LegCuenLicTpo, Z2243LegCuenLicTpo) != 0 ) || ( A2266LegCuenAnio != Z2266LegCuenAnio ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("legajo_cuenta_licencias:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
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
               A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A2243LegCuenLicTpo = httpContext.GetPar( "LegCuenLicTpo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
               A2266LegCuenAnio = (short)(GXutil.lval( httpContext.GetPar( "LegCuenAnio"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2266LegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2266LegCuenAnio), 4, 0));
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode285 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode285 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound285 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_6F0( ) ;
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
                        e116F2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e126F2 ();
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
         e126F2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll6F285( ) ;
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
         disableAttributes6F285( ) ;
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

   public void confirm_6F0( )
   {
      beforeValidate6F285( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls6F285( ) ;
         }
         else
         {
            checkExtendedTable6F285( ) ;
            closeExtendedTableCursors6F285( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode285 = Gx_mode ;
         confirm_6F288( ) ;
         if ( AnyError == 0 )
         {
            confirm_6F289( ) ;
            if ( AnyError == 0 )
            {
               /* Restore parent mode. */
               Gx_mode = sMode285 ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               IsConfirmed = (short)(1) ;
               httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
            }
         }
         /* Restore parent mode. */
         Gx_mode = sMode285 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_6F289( )
   {
      nGXsfl_107_idx = 0 ;
      while ( nGXsfl_107_idx < nRC_GXsfl_107 )
      {
         readRow6F289( ) ;
         if ( ( nRcdExists_289 != 0 ) || ( nIsMod_289 != 0 ) )
         {
            getKey6F289( ) ;
            if ( ( nRcdExists_289 == 0 ) && ( nRcdDeleted_289 == 0 ) )
            {
               if ( RcdFound289 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate6F289( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable6F289( ) ;
                     closeExtendedTableCursors6F289( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "LEGCULCONSANIO_" + sGXsfl_107_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtLegCuLConsAnio_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound289 != 0 )
               {
                  if ( nRcdDeleted_289 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey6F289( ) ;
                     load6F289( ) ;
                     beforeValidate6F289( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls6F289( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_289 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate6F289( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable6F289( ) ;
                           closeExtendedTableCursors6F289( ) ;
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
                  if ( nRcdDeleted_289 == 0 )
                  {
                     GXCCtl = "LEGCULCONSANIO_" + sGXsfl_107_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtLegCuLConsAnio_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtLegCuLConsAnio_Internalname, GXutil.ltrim( localUtil.ntoc( A2310LegCuLConsAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtLegCuLConsSec_Internalname, GXutil.ltrim( localUtil.ntoc( A2311LegCuLConsSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtLegCuLConsCnt_Internalname, GXutil.ltrim( localUtil.ntoc( A2312LegCuLConsCnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( cmbLegCuLConsOri.getInternalname(), GXutil.rtrim( A2327LegCuLConsOri)) ;
         httpContext.changePostValue( "ZT_"+"Z2310LegCuLConsAnio_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( Z2310LegCuLConsAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2311LegCuLConsSec_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( Z2311LegCuLConsSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2327LegCuLConsOri_"+sGXsfl_107_idx, GXutil.rtrim( Z2327LegCuLConsOri)) ;
         httpContext.changePostValue( "ZT_"+"Z2312LegCuLConsCnt_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( Z2312LegCuLConsCnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2342LegCulConsLiqNro_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( Z2342LegCulConsLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_289_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_289, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_289_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_289, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_289_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_289, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_289 != 0 )
         {
            httpContext.changePostValue( "LEGCULCONSANIO_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLConsAnio_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "LEGCULCONSSEC_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLConsSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "LEGCULCONSCNT_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLConsCnt_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "LEGCULCONSORI_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbLegCuLConsOri.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_6F288( )
   {
      nGXsfl_93_idx = 0 ;
      while ( nGXsfl_93_idx < nRC_GXsfl_93 )
      {
         readRow6F288( ) ;
         if ( ( nRcdExists_288 != 0 ) || ( nIsMod_288 != 0 ) )
         {
            getKey6F288( ) ;
            if ( ( nRcdExists_288 == 0 ) && ( nRcdDeleted_288 == 0 ) )
            {
               if ( RcdFound288 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate6F288( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable6F288( ) ;
                     closeExtendedTableCursors6F288( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "LEGCULAPRLICFCH_" + sGXsfl_93_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtLegCuLAprLicFch_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound288 != 0 )
               {
                  if ( nRcdDeleted_288 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey6F288( ) ;
                     load6F288( ) ;
                     beforeValidate6F288( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls6F288( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_288 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate6F288( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable6F288( ) ;
                           closeExtendedTableCursors6F288( ) ;
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
                  if ( nRcdDeleted_288 == 0 )
                  {
                     GXCCtl = "LEGCULAPRLICFCH_" + sGXsfl_93_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtLegCuLAprLicFch_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtLegCuLAprLicFch_Internalname, localUtil.format(A2324LegCuLAprLicFch, "99/99/99")) ;
         httpContext.changePostValue( edtLegCuLAprLicCnt_Internalname, GXutil.ltrim( localUtil.ntoc( A2325LegCuLAprLicCnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( cmbLegCuLAprLicOri.getInternalname(), GXutil.rtrim( A2326LegCuLAprLicOri)) ;
         httpContext.changePostValue( "ZT_"+"Z2324LegCuLAprLicFch_"+sGXsfl_93_idx, localUtil.dtoc( Z2324LegCuLAprLicFch, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z2326LegCuLAprLicOri_"+sGXsfl_93_idx, GXutil.rtrim( Z2326LegCuLAprLicOri)) ;
         httpContext.changePostValue( "ZT_"+"Z2325LegCuLAprLicCnt_"+sGXsfl_93_idx, GXutil.ltrim( localUtil.ntoc( Z2325LegCuLAprLicCnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2341LegCuLAprLiqNro_"+sGXsfl_93_idx, GXutil.ltrim( localUtil.ntoc( Z2341LegCuLAprLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_288_"+sGXsfl_93_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_288, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_288_"+sGXsfl_93_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_288, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_288_"+sGXsfl_93_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_288, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_288 != 0 )
         {
            httpContext.changePostValue( "LEGCULAPRLICFCH_"+sGXsfl_93_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLAprLicFch_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "LEGCULAPRLICCNT_"+sGXsfl_93_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLAprLicCnt_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "LEGCULAPRLICORI_"+sGXsfl_93_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbLegCuLAprLicOri.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption6F0( )
   {
   }

   public void e116F2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV12WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV12WWPContext = GXv_SdtWWPContext1[0] ;
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_cuenta_licencias_Insert", GXv_boolean3) ;
         legajo_cuenta_licencias_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_cuenta_licencias_Update", GXv_boolean3) ;
         legajo_cuenta_licencias_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_cuenta_licencias_Delete", GXv_boolean3) ;
         legajo_cuenta_licencias_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV20Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV15TrnContext.fromxml(AV16WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtLegNumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Visible), 5, 0), true);
      cmbLegCuenLicTpo.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegCuenLicTpo.getInternalname(), "Visible", GXutil.ltrimstr( cmbLegCuenLicTpo.getVisible(), 5, 0), true);
      edtLegCuLRecalc_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLRecalc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLRecalc_Visible), 5, 0), true);
      edtLegCuenAntDias_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenAntDias_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenAntDias_Visible), 5, 0), true);
      edtLegCuenAntAnios_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenAntAnios_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenAntAnios_Visible), 5, 0), true);
      edtLegCuenAntMeses_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenAntMeses_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenAntMeses_Visible), 5, 0), true);
      edtLegCueAntTexto_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCueAntTexto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCueAntTexto_Visible), 5, 0), true);
      AV18hoy = GXutil.serverDate( context, remoteHandle, pr_default) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18hoy", localUtil.format(AV18hoy, "99/99/99"));
      AV17actualAnio = (short)(GXutil.year( AV18hoy)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17actualAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17actualAnio), 4, 0));
   }

   public void e126F2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.leglicccsetearrecorrer(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A2243LegCuenLicTpo, A2266LegCuenAnio, A2321LegCuLIncluir) ;
      new web.inicializarperiodoscclic(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, (short)(0)) ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(10);
      pr_default.close(9);
      pr_default.close(7);
      pr_default.close(6);
      pr_default.close(5);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm6F285( int GX_JID )
   {
      if ( ( GX_JID == 35 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2315LegCuLActVen = T006F11_A2315LegCuLActVen[0] ;
            Z2313LegCuLTotCons = T006F11_A2313LegCuLTotCons[0] ;
            Z2314LegCuLTotCorr = T006F11_A2314LegCuLTotCorr[0] ;
            Z2244LegCuenLicPerIni = T006F11_A2244LegCuenLicPerIni[0] ;
            Z2245LegCuenLicPerFin = T006F11_A2245LegCuenLicPerFin[0] ;
            Z2246LegCuenAntDias = T006F11_A2246LegCuenAntDias[0] ;
            Z2299LegCuenAntAnios = T006F11_A2299LegCuenAntAnios[0] ;
            Z2300LegCuenAntMeses = T006F11_A2300LegCuenAntMeses[0] ;
            Z2247LegCuenDiasCorres = T006F11_A2247LegCuenDiasCorres[0] ;
            Z2248LegCuenDiasGoz = T006F11_A2248LegCuenDiasGoz[0] ;
            Z2249LegCuenDiasVig = T006F11_A2249LegCuenDiasVig[0] ;
            Z2328LegCueAntAbr = T006F11_A2328LegCueAntAbr[0] ;
            Z2302LegCuLiPCur = T006F11_A2302LegCuLiPCur[0] ;
            Z2303LegCuLiPAnt = T006F11_A2303LegCuLiPAnt[0] ;
            Z2304LegCuLiPVen = T006F11_A2304LegCuLiPVen[0] ;
            Z2305LegCuLiPSaldo = T006F11_A2305LegCuLiPSaldo[0] ;
            Z2306LegCuLiPApr = T006F11_A2306LegCuLiPApr[0] ;
            Z2307LegCuLiAprPGoce = T006F11_A2307LegCuLiAprPGoce[0] ;
            Z2321LegCuLIncluir = T006F11_A2321LegCuLIncluir[0] ;
            Z2322LegCuLRecalc = T006F11_A2322LegCuLRecalc[0] ;
         }
         else
         {
            Z2315LegCuLActVen = A2315LegCuLActVen ;
            Z2313LegCuLTotCons = A2313LegCuLTotCons ;
            Z2314LegCuLTotCorr = A2314LegCuLTotCorr ;
            Z2244LegCuenLicPerIni = A2244LegCuenLicPerIni ;
            Z2245LegCuenLicPerFin = A2245LegCuenLicPerFin ;
            Z2246LegCuenAntDias = A2246LegCuenAntDias ;
            Z2299LegCuenAntAnios = A2299LegCuenAntAnios ;
            Z2300LegCuenAntMeses = A2300LegCuenAntMeses ;
            Z2247LegCuenDiasCorres = A2247LegCuenDiasCorres ;
            Z2248LegCuenDiasGoz = A2248LegCuenDiasGoz ;
            Z2249LegCuenDiasVig = A2249LegCuenDiasVig ;
            Z2328LegCueAntAbr = A2328LegCueAntAbr ;
            Z2302LegCuLiPCur = A2302LegCuLiPCur ;
            Z2303LegCuLiPAnt = A2303LegCuLiPAnt ;
            Z2304LegCuLiPVen = A2304LegCuLiPVen ;
            Z2305LegCuLiPSaldo = A2305LegCuLiPSaldo ;
            Z2306LegCuLiPApr = A2306LegCuLiPApr ;
            Z2307LegCuLiAprPGoce = A2307LegCuLiAprPGoce ;
            Z2321LegCuLIncluir = A2321LegCuLIncluir ;
            Z2322LegCuLRecalc = A2322LegCuLRecalc ;
         }
      }
      if ( GX_JID == -35 )
      {
         Z2243LegCuenLicTpo = A2243LegCuenLicTpo ;
         Z2266LegCuenAnio = A2266LegCuenAnio ;
         Z2315LegCuLActVen = A2315LegCuLActVen ;
         Z2313LegCuLTotCons = A2313LegCuLTotCons ;
         Z2314LegCuLTotCorr = A2314LegCuLTotCorr ;
         Z2244LegCuenLicPerIni = A2244LegCuenLicPerIni ;
         Z2245LegCuenLicPerFin = A2245LegCuenLicPerFin ;
         Z2246LegCuenAntDias = A2246LegCuenAntDias ;
         Z2299LegCuenAntAnios = A2299LegCuenAntAnios ;
         Z2300LegCuenAntMeses = A2300LegCuenAntMeses ;
         Z2247LegCuenDiasCorres = A2247LegCuenDiasCorres ;
         Z2248LegCuenDiasGoz = A2248LegCuenDiasGoz ;
         Z2249LegCuenDiasVig = A2249LegCuenDiasVig ;
         Z2301LegCueAntTexto = A2301LegCueAntTexto ;
         Z2328LegCueAntAbr = A2328LegCueAntAbr ;
         Z2302LegCuLiPCur = A2302LegCuLiPCur ;
         Z2303LegCuLiPAnt = A2303LegCuLiPAnt ;
         Z2304LegCuLiPVen = A2304LegCuLiPVen ;
         Z2305LegCuLiPSaldo = A2305LegCuLiPSaldo ;
         Z2306LegCuLiPApr = A2306LegCuLiPApr ;
         Z2307LegCuLiAprPGoce = A2307LegCuLiAprPGoce ;
         Z2321LegCuLIncluir = A2321LegCuLIncluir ;
         Z2322LegCuLRecalc = A2322LegCuLRecalc ;
         Z2329LegCuLLogDis = A2329LegCuLLogDis ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z250LegIdNomApe = A250LegIdNomApe ;
         Z251LegNombre = A251LegNombre ;
         Z230LegApellido = A230LegApellido ;
         Z93LegId = A93LegId ;
      }
   }

   public void standaloneNotModal( )
   {
      edtLegCuenLicPerIni_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenLicPerIni_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenLicPerIni_Enabled), 5, 0), true);
      edtLegCuenLicPerFin_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenLicPerFin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenLicPerFin_Enabled), 5, 0), true);
      edtLegCuenDiasCorres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenDiasCorres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenDiasCorres_Enabled), 5, 0), true);
      edtLegCuLiPAnt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPAnt_Enabled), 5, 0), true);
      edtLegCuLiPVen_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPVen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPVen_Enabled), 5, 0), true);
      edtLegCuLiPCur_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPCur_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPCur_Enabled), 5, 0), true);
      edtLegCuLActVen_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLActVen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLActVen_Enabled), 5, 0), true);
      edtLegCuLiPApr_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPApr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPApr_Enabled), 5, 0), true);
      edtLegCuenDiasGoz_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenDiasGoz_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenDiasGoz_Enabled), 5, 0), true);
      edtLegCuLiPSaldo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPSaldo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPSaldo_Enabled), 5, 0), true);
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      edtLegCuenLicPerIni_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenLicPerIni_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenLicPerIni_Enabled), 5, 0), true);
      edtLegCuenLicPerFin_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenLicPerFin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenLicPerFin_Enabled), 5, 0), true);
      edtLegCuenDiasCorres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenDiasCorres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenDiasCorres_Enabled), 5, 0), true);
      edtLegCuLiPAnt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPAnt_Enabled), 5, 0), true);
      edtLegCuLiPVen_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPVen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPVen_Enabled), 5, 0), true);
      edtLegCuLiPCur_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPCur_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPCur_Enabled), 5, 0), true);
      edtLegCuLActVen_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLActVen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLActVen_Enabled), 5, 0), true);
      edtLegCuLiPApr_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPApr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPApr_Enabled), 5, 0), true);
      edtLegCuenDiasGoz_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenDiasGoz_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenDiasGoz_Enabled), 5, 0), true);
      edtLegCuLiPSaldo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPSaldo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPSaldo_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
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
            legajo_cuenta_licencias_impl.this.GXt_int4 = GXv_int5[0] ;
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
      if ( ! (0==AV8EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      else
      {
         edtEmpCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9LegNumero) )
      {
         A6LegNumero = AV9LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
      if ( ! (0==AV9LegNumero) )
      {
         edtLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
      else
      {
         edtLegNumero_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9LegNumero) )
      {
         edtLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV10LegCuenLicTpo)==0) )
      {
         A2243LegCuenLicTpo = AV10LegCuenLicTpo ;
         httpContext.ajax_rsp_assign_attri("", false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
      }
      if ( ! (GXutil.strcmp("", AV10LegCuenLicTpo)==0) )
      {
         cmbLegCuenLicTpo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbLegCuenLicTpo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegCuenLicTpo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbLegCuenLicTpo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbLegCuenLicTpo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegCuenLicTpo.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV10LegCuenLicTpo)==0) )
      {
         cmbLegCuenLicTpo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbLegCuenLicTpo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegCuenLicTpo.getEnabled(), 5, 0), true);
      }
      if ( ! (0==AV11LegCuenAnio) )
      {
         A2266LegCuenAnio = AV11LegCuenAnio ;
         httpContext.ajax_rsp_assign_attri("", false, "A2266LegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2266LegCuenAnio), 4, 0));
      }
      if ( ! (0==AV11LegCuenAnio) )
      {
         edtLegCuenAnio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegCuenAnio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenAnio_Enabled), 5, 0), true);
      }
      else
      {
         edtLegCuenAnio_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegCuenAnio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenAnio_Enabled), 5, 0), true);
      }
      if ( ! (0==AV11LegCuenAnio) )
      {
         edtLegCuenAnio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegCuenAnio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenAnio_Enabled), 5, 0), true);
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV20Pgmname = "legajo_cuenta_licencias" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
         /* Using cursor T006F12 */
         pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         A250LegIdNomApe = T006F12_A250LegIdNomApe[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A250LegIdNomApe", A250LegIdNomApe);
         A251LegNombre = T006F12_A251LegNombre[0] ;
         A251LegNombre = T006F12_A251LegNombre[0] ;
         A230LegApellido = T006F12_A230LegApellido[0] ;
         A230LegApellido = T006F12_A230LegApellido[0] ;
         A93LegId = T006F12_A93LegId[0] ;
         n93LegId = T006F12_n93LegId[0] ;
         A93LegId = T006F12_A93LegId[0] ;
         n93LegId = T006F12_n93LegId[0] ;
         pr_default.close(10);
      }
   }

   public void load6F285( )
   {
      /* Using cursor T006F13 */
      pr_default.execute(11, new Object[] {A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound285 = (short)(1) ;
         A250LegIdNomApe = T006F13_A250LegIdNomApe[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A250LegIdNomApe", A250LegIdNomApe);
         A2315LegCuLActVen = T006F13_A2315LegCuLActVen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2315LegCuLActVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2315LegCuLActVen), 4, 0));
         A2313LegCuLTotCons = T006F13_A2313LegCuLTotCons[0] ;
         A2314LegCuLTotCorr = T006F13_A2314LegCuLTotCorr[0] ;
         A2244LegCuenLicPerIni = T006F13_A2244LegCuenLicPerIni[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2244LegCuenLicPerIni", localUtil.format(A2244LegCuenLicPerIni, "99/99/9999"));
         A2245LegCuenLicPerFin = T006F13_A2245LegCuenLicPerFin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2245LegCuenLicPerFin", localUtil.format(A2245LegCuenLicPerFin, "99/99/9999"));
         A2246LegCuenAntDias = T006F13_A2246LegCuenAntDias[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2246LegCuenAntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2246LegCuenAntDias), 8, 0));
         A2299LegCuenAntAnios = T006F13_A2299LegCuenAntAnios[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2299LegCuenAntAnios", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2299LegCuenAntAnios), 4, 0));
         A2300LegCuenAntMeses = T006F13_A2300LegCuenAntMeses[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2300LegCuenAntMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2300LegCuenAntMeses), 4, 0));
         A2247LegCuenDiasCorres = T006F13_A2247LegCuenDiasCorres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2247LegCuenDiasCorres", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2247LegCuenDiasCorres), 4, 0));
         A2248LegCuenDiasGoz = T006F13_A2248LegCuenDiasGoz[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2248LegCuenDiasGoz", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2248LegCuenDiasGoz), 4, 0));
         A2249LegCuenDiasVig = T006F13_A2249LegCuenDiasVig[0] ;
         A2301LegCueAntTexto = T006F13_A2301LegCueAntTexto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2301LegCueAntTexto", A2301LegCueAntTexto);
         A2328LegCueAntAbr = T006F13_A2328LegCueAntAbr[0] ;
         A2302LegCuLiPCur = T006F13_A2302LegCuLiPCur[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2302LegCuLiPCur", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2302LegCuLiPCur), 4, 0));
         A2303LegCuLiPAnt = T006F13_A2303LegCuLiPAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2303LegCuLiPAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2303LegCuLiPAnt), 4, 0));
         A2304LegCuLiPVen = T006F13_A2304LegCuLiPVen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2304LegCuLiPVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2304LegCuLiPVen), 4, 0));
         A2305LegCuLiPSaldo = T006F13_A2305LegCuLiPSaldo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2305LegCuLiPSaldo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2305LegCuLiPSaldo), 4, 0));
         A2306LegCuLiPApr = T006F13_A2306LegCuLiPApr[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2306LegCuLiPApr", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2306LegCuLiPApr), 4, 0));
         A2307LegCuLiAprPGoce = T006F13_A2307LegCuLiAprPGoce[0] ;
         A2321LegCuLIncluir = T006F13_A2321LegCuLIncluir[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2321LegCuLIncluir", A2321LegCuLIncluir);
         A2322LegCuLRecalc = T006F13_A2322LegCuLRecalc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2322LegCuLRecalc", A2322LegCuLRecalc);
         A2329LegCuLLogDis = T006F13_A2329LegCuLLogDis[0] ;
         A251LegNombre = T006F13_A251LegNombre[0] ;
         A230LegApellido = T006F13_A230LegApellido[0] ;
         A93LegId = T006F13_A93LegId[0] ;
         n93LegId = T006F13_n93LegId[0] ;
         zm6F285( -35) ;
      }
      pr_default.close(11);
      onLoadActions6F285( ) ;
   }

   public void onLoadActions6F285( )
   {
      AV20Pgmname = "legajo_cuenta_licencias" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
   }

   public void checkExtendedTable6F285( )
   {
      nIsDirty_285 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV20Pgmname = "legajo_cuenta_licencias" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      /* Using cursor T006F12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A250LegIdNomApe = T006F12_A250LegIdNomApe[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A250LegIdNomApe", A250LegIdNomApe);
      A251LegNombre = T006F12_A251LegNombre[0] ;
      A251LegNombre = T006F12_A251LegNombre[0] ;
      A230LegApellido = T006F12_A230LegApellido[0] ;
      A230LegApellido = T006F12_A230LegApellido[0] ;
      A93LegId = T006F12_A93LegId[0] ;
      n93LegId = T006F12_n93LegId[0] ;
      A93LegId = T006F12_A93LegId[0] ;
      n93LegId = T006F12_n93LegId[0] ;
      pr_default.close(10);
      if ( ! ( ( GXutil.strcmp(A2243LegCuenLicTpo, "Vacaciones") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de licencia", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "LEGCUENLICTPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbLegCuenLicTpo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! A2321LegCuLIncluir && ( A2322LegCuLRecalc ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "Si establece que el periodo debe recalcular, también debe establecer que el periodo debe ser recorrido", ""), 1, "LEGCULINCLUIR");
         AnyError = (short)(1) ;
         GX_FocusControl = chkLegCuLIncluir.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors6F285( )
   {
      pr_default.close(10);
   }

   public void enableDisable( )
   {
   }

   public void gxload_36( int A3CliCod ,
                          short A1EmpCod ,
                          int A6LegNumero )
   {
      /* Using cursor T006F14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A250LegIdNomApe = T006F14_A250LegIdNomApe[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A250LegIdNomApe", A250LegIdNomApe);
      A251LegNombre = T006F14_A251LegNombre[0] ;
      A251LegNombre = T006F14_A251LegNombre[0] ;
      A230LegApellido = T006F14_A230LegApellido[0] ;
      A230LegApellido = T006F14_A230LegApellido[0] ;
      A93LegId = T006F14_A93LegId[0] ;
      n93LegId = T006F14_n93LegId[0] ;
      A93LegId = T006F14_A93LegId[0] ;
      n93LegId = T006F14_n93LegId[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A250LegIdNomApe)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A251LegNombre)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A230LegApellido)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A93LegId))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A93LegId))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A230LegApellido)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A251LegNombre)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(12) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(12);
   }

   public void getKey6F285( )
   {
      /* Using cursor T006F15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound285 = (short)(1) ;
      }
      else
      {
         RcdFound285 = (short)(0) ;
      }
      pr_default.close(13);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T006F11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         zm6F285( 35) ;
         RcdFound285 = (short)(1) ;
         A2243LegCuenLicTpo = T006F11_A2243LegCuenLicTpo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
         A2266LegCuenAnio = T006F11_A2266LegCuenAnio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2266LegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2266LegCuenAnio), 4, 0));
         A2315LegCuLActVen = T006F11_A2315LegCuLActVen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2315LegCuLActVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2315LegCuLActVen), 4, 0));
         A2313LegCuLTotCons = T006F11_A2313LegCuLTotCons[0] ;
         A2314LegCuLTotCorr = T006F11_A2314LegCuLTotCorr[0] ;
         A2244LegCuenLicPerIni = T006F11_A2244LegCuenLicPerIni[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2244LegCuenLicPerIni", localUtil.format(A2244LegCuenLicPerIni, "99/99/9999"));
         A2245LegCuenLicPerFin = T006F11_A2245LegCuenLicPerFin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2245LegCuenLicPerFin", localUtil.format(A2245LegCuenLicPerFin, "99/99/9999"));
         A2246LegCuenAntDias = T006F11_A2246LegCuenAntDias[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2246LegCuenAntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2246LegCuenAntDias), 8, 0));
         A2299LegCuenAntAnios = T006F11_A2299LegCuenAntAnios[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2299LegCuenAntAnios", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2299LegCuenAntAnios), 4, 0));
         A2300LegCuenAntMeses = T006F11_A2300LegCuenAntMeses[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2300LegCuenAntMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2300LegCuenAntMeses), 4, 0));
         A2247LegCuenDiasCorres = T006F11_A2247LegCuenDiasCorres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2247LegCuenDiasCorres", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2247LegCuenDiasCorres), 4, 0));
         A2248LegCuenDiasGoz = T006F11_A2248LegCuenDiasGoz[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2248LegCuenDiasGoz", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2248LegCuenDiasGoz), 4, 0));
         A2249LegCuenDiasVig = T006F11_A2249LegCuenDiasVig[0] ;
         A2301LegCueAntTexto = T006F11_A2301LegCueAntTexto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2301LegCueAntTexto", A2301LegCueAntTexto);
         A2328LegCueAntAbr = T006F11_A2328LegCueAntAbr[0] ;
         A2302LegCuLiPCur = T006F11_A2302LegCuLiPCur[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2302LegCuLiPCur", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2302LegCuLiPCur), 4, 0));
         A2303LegCuLiPAnt = T006F11_A2303LegCuLiPAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2303LegCuLiPAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2303LegCuLiPAnt), 4, 0));
         A2304LegCuLiPVen = T006F11_A2304LegCuLiPVen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2304LegCuLiPVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2304LegCuLiPVen), 4, 0));
         A2305LegCuLiPSaldo = T006F11_A2305LegCuLiPSaldo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2305LegCuLiPSaldo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2305LegCuLiPSaldo), 4, 0));
         A2306LegCuLiPApr = T006F11_A2306LegCuLiPApr[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2306LegCuLiPApr", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2306LegCuLiPApr), 4, 0));
         A2307LegCuLiAprPGoce = T006F11_A2307LegCuLiAprPGoce[0] ;
         A2321LegCuLIncluir = T006F11_A2321LegCuLIncluir[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2321LegCuLIncluir", A2321LegCuLIncluir);
         A2322LegCuLRecalc = T006F11_A2322LegCuLRecalc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2322LegCuLRecalc", A2322LegCuLRecalc);
         A2329LegCuLLogDis = T006F11_A2329LegCuLLogDis[0] ;
         A3CliCod = T006F11_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T006F11_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T006F11_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z2243LegCuenLicTpo = A2243LegCuenLicTpo ;
         Z2266LegCuenAnio = A2266LegCuenAnio ;
         sMode285 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load6F285( ) ;
         if ( AnyError == 1 )
         {
            RcdFound285 = (short)(0) ;
            initializeNonKey6F285( ) ;
         }
         Gx_mode = sMode285 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound285 = (short)(0) ;
         initializeNonKey6F285( ) ;
         sMode285 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode285 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(9);
   }

   public void getEqualNoModal( )
   {
      getKey6F285( ) ;
      if ( RcdFound285 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound285 = (short)(0) ;
      /* Using cursor T006F16 */
      pr_default.execute(14, new Object[] {A2243LegCuenLicTpo, A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), Short.valueOf(A2266LegCuenAnio), A2243LegCuenLicTpo, Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A2266LegCuenAnio), A2243LegCuenLicTpo, Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A2266LegCuenAnio), A2243LegCuenLicTpo, Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         while ( (pr_default.getStatus(14) != 101) && ( ( GXutil.strcmp(T006F16_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) < 0 ) || ( GXutil.strcmp(T006F16_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) == 0 ) && ( T006F16_A2266LegCuenAnio[0] < A2266LegCuenAnio ) || ( T006F16_A2266LegCuenAnio[0] == A2266LegCuenAnio ) && ( GXutil.strcmp(T006F16_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) == 0 ) && ( T006F16_A3CliCod[0] < A3CliCod ) || ( T006F16_A3CliCod[0] == A3CliCod ) && ( T006F16_A2266LegCuenAnio[0] == A2266LegCuenAnio ) && ( GXutil.strcmp(T006F16_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) == 0 ) && ( T006F16_A1EmpCod[0] < A1EmpCod ) || ( T006F16_A1EmpCod[0] == A1EmpCod ) && ( T006F16_A3CliCod[0] == A3CliCod ) && ( T006F16_A2266LegCuenAnio[0] == A2266LegCuenAnio ) && ( GXutil.strcmp(T006F16_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) == 0 ) && ( T006F16_A6LegNumero[0] < A6LegNumero ) ) )
         {
            pr_default.readNext(14);
         }
         if ( (pr_default.getStatus(14) != 101) && ( ( GXutil.strcmp(T006F16_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) > 0 ) || ( GXutil.strcmp(T006F16_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) == 0 ) && ( T006F16_A2266LegCuenAnio[0] > A2266LegCuenAnio ) || ( T006F16_A2266LegCuenAnio[0] == A2266LegCuenAnio ) && ( GXutil.strcmp(T006F16_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) == 0 ) && ( T006F16_A3CliCod[0] > A3CliCod ) || ( T006F16_A3CliCod[0] == A3CliCod ) && ( T006F16_A2266LegCuenAnio[0] == A2266LegCuenAnio ) && ( GXutil.strcmp(T006F16_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) == 0 ) && ( T006F16_A1EmpCod[0] > A1EmpCod ) || ( T006F16_A1EmpCod[0] == A1EmpCod ) && ( T006F16_A3CliCod[0] == A3CliCod ) && ( T006F16_A2266LegCuenAnio[0] == A2266LegCuenAnio ) && ( GXutil.strcmp(T006F16_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) == 0 ) && ( T006F16_A6LegNumero[0] > A6LegNumero ) ) )
         {
            A2243LegCuenLicTpo = T006F16_A2243LegCuenLicTpo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
            A2266LegCuenAnio = T006F16_A2266LegCuenAnio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2266LegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2266LegCuenAnio), 4, 0));
            A3CliCod = T006F16_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T006F16_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T006F16_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            RcdFound285 = (short)(1) ;
         }
      }
      pr_default.close(14);
   }

   public void move_previous( )
   {
      RcdFound285 = (short)(0) ;
      /* Using cursor T006F17 */
      pr_default.execute(15, new Object[] {A2243LegCuenLicTpo, A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), Short.valueOf(A2266LegCuenAnio), A2243LegCuenLicTpo, Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A2266LegCuenAnio), A2243LegCuenLicTpo, Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A2266LegCuenAnio), A2243LegCuenLicTpo, Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         while ( (pr_default.getStatus(15) != 101) && ( ( GXutil.strcmp(T006F17_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) > 0 ) || ( GXutil.strcmp(T006F17_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) == 0 ) && ( T006F17_A2266LegCuenAnio[0] > A2266LegCuenAnio ) || ( T006F17_A2266LegCuenAnio[0] == A2266LegCuenAnio ) && ( GXutil.strcmp(T006F17_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) == 0 ) && ( T006F17_A3CliCod[0] > A3CliCod ) || ( T006F17_A3CliCod[0] == A3CliCod ) && ( T006F17_A2266LegCuenAnio[0] == A2266LegCuenAnio ) && ( GXutil.strcmp(T006F17_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) == 0 ) && ( T006F17_A1EmpCod[0] > A1EmpCod ) || ( T006F17_A1EmpCod[0] == A1EmpCod ) && ( T006F17_A3CliCod[0] == A3CliCod ) && ( T006F17_A2266LegCuenAnio[0] == A2266LegCuenAnio ) && ( GXutil.strcmp(T006F17_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) == 0 ) && ( T006F17_A6LegNumero[0] > A6LegNumero ) ) )
         {
            pr_default.readNext(15);
         }
         if ( (pr_default.getStatus(15) != 101) && ( ( GXutil.strcmp(T006F17_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) < 0 ) || ( GXutil.strcmp(T006F17_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) == 0 ) && ( T006F17_A2266LegCuenAnio[0] < A2266LegCuenAnio ) || ( T006F17_A2266LegCuenAnio[0] == A2266LegCuenAnio ) && ( GXutil.strcmp(T006F17_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) == 0 ) && ( T006F17_A3CliCod[0] < A3CliCod ) || ( T006F17_A3CliCod[0] == A3CliCod ) && ( T006F17_A2266LegCuenAnio[0] == A2266LegCuenAnio ) && ( GXutil.strcmp(T006F17_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) == 0 ) && ( T006F17_A1EmpCod[0] < A1EmpCod ) || ( T006F17_A1EmpCod[0] == A1EmpCod ) && ( T006F17_A3CliCod[0] == A3CliCod ) && ( T006F17_A2266LegCuenAnio[0] == A2266LegCuenAnio ) && ( GXutil.strcmp(T006F17_A2243LegCuenLicTpo[0], A2243LegCuenLicTpo) == 0 ) && ( T006F17_A6LegNumero[0] < A6LegNumero ) ) )
         {
            A2243LegCuenLicTpo = T006F17_A2243LegCuenLicTpo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
            A2266LegCuenAnio = T006F17_A2266LegCuenAnio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A2266LegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2266LegCuenAnio), 4, 0));
            A3CliCod = T006F17_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T006F17_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T006F17_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            RcdFound285 = (short)(1) ;
         }
      }
      pr_default.close(15);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey6F285( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtLegCuenAnio_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert6F285( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound285 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A2243LegCuenLicTpo, Z2243LegCuenLicTpo) != 0 ) || ( A2266LegCuenAnio != Z2266LegCuenAnio ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A6LegNumero = Z6LegNumero ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A2243LegCuenLicTpo = Z2243LegCuenLicTpo ;
               httpContext.ajax_rsp_assign_attri("", false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
               A2266LegCuenAnio = Z2266LegCuenAnio ;
               httpContext.ajax_rsp_assign_attri("", false, "A2266LegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2266LegCuenAnio), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtLegCuenAnio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update6F285( ) ;
               GX_FocusControl = edtLegCuenAnio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A2243LegCuenLicTpo, Z2243LegCuenLicTpo) != 0 ) || ( A2266LegCuenAnio != Z2266LegCuenAnio ) )
            {
               /* Insert record */
               GX_FocusControl = edtLegCuenAnio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert6F285( ) ;
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
                  GX_FocusControl = edtLegCuenAnio_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert6F285( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( GXutil.strcmp(A2243LegCuenLicTpo, Z2243LegCuenLicTpo) != 0 ) || ( A2266LegCuenAnio != Z2266LegCuenAnio ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = Z6LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A2243LegCuenLicTpo = Z2243LegCuenLicTpo ;
         httpContext.ajax_rsp_assign_attri("", false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
         A2266LegCuenAnio = Z2266LegCuenAnio ;
         httpContext.ajax_rsp_assign_attri("", false, "A2266LegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2266LegCuenAnio), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtLegCuenAnio_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency6F285( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T006F10 */
         pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
         if ( (pr_default.getStatus(8) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"legajo_cuenta_licencias"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(8) == 101) || ( Z2315LegCuLActVen != T006F10_A2315LegCuLActVen[0] ) || ( Z2313LegCuLTotCons != T006F10_A2313LegCuLTotCons[0] ) || ( Z2314LegCuLTotCorr != T006F10_A2314LegCuLTotCorr[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z2244LegCuenLicPerIni), GXutil.resetTime(T006F10_A2244LegCuenLicPerIni[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z2245LegCuenLicPerFin), GXutil.resetTime(T006F10_A2245LegCuenLicPerFin[0])) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2246LegCuenAntDias != T006F10_A2246LegCuenAntDias[0] ) || ( Z2299LegCuenAntAnios != T006F10_A2299LegCuenAntAnios[0] ) || ( Z2300LegCuenAntMeses != T006F10_A2300LegCuenAntMeses[0] ) || ( Z2247LegCuenDiasCorres != T006F10_A2247LegCuenDiasCorres[0] ) || ( Z2248LegCuenDiasGoz != T006F10_A2248LegCuenDiasGoz[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2249LegCuenDiasVig != T006F10_A2249LegCuenDiasVig[0] ) || ( GXutil.strcmp(Z2328LegCueAntAbr, T006F10_A2328LegCueAntAbr[0]) != 0 ) || ( Z2302LegCuLiPCur != T006F10_A2302LegCuLiPCur[0] ) || ( Z2303LegCuLiPAnt != T006F10_A2303LegCuLiPAnt[0] ) || ( Z2304LegCuLiPVen != T006F10_A2304LegCuLiPVen[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2305LegCuLiPSaldo != T006F10_A2305LegCuLiPSaldo[0] ) || ( Z2306LegCuLiPApr != T006F10_A2306LegCuLiPApr[0] ) || ( Z2307LegCuLiAprPGoce != T006F10_A2307LegCuLiAprPGoce[0] ) || ( Z2321LegCuLIncluir != T006F10_A2321LegCuLIncluir[0] ) || ( Z2322LegCuLRecalc != T006F10_A2322LegCuLRecalc[0] ) )
         {
            if ( Z2315LegCuLActVen != T006F10_A2315LegCuLActVen[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuLActVen");
               GXutil.writeLogRaw("Old: ",Z2315LegCuLActVen);
               GXutil.writeLogRaw("Current: ",T006F10_A2315LegCuLActVen[0]);
            }
            if ( Z2313LegCuLTotCons != T006F10_A2313LegCuLTotCons[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuLTotCons");
               GXutil.writeLogRaw("Old: ",Z2313LegCuLTotCons);
               GXutil.writeLogRaw("Current: ",T006F10_A2313LegCuLTotCons[0]);
            }
            if ( Z2314LegCuLTotCorr != T006F10_A2314LegCuLTotCorr[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuLTotCorr");
               GXutil.writeLogRaw("Old: ",Z2314LegCuLTotCorr);
               GXutil.writeLogRaw("Current: ",T006F10_A2314LegCuLTotCorr[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z2244LegCuenLicPerIni), GXutil.resetTime(T006F10_A2244LegCuenLicPerIni[0])) ) )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuenLicPerIni");
               GXutil.writeLogRaw("Old: ",Z2244LegCuenLicPerIni);
               GXutil.writeLogRaw("Current: ",T006F10_A2244LegCuenLicPerIni[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z2245LegCuenLicPerFin), GXutil.resetTime(T006F10_A2245LegCuenLicPerFin[0])) ) )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuenLicPerFin");
               GXutil.writeLogRaw("Old: ",Z2245LegCuenLicPerFin);
               GXutil.writeLogRaw("Current: ",T006F10_A2245LegCuenLicPerFin[0]);
            }
            if ( Z2246LegCuenAntDias != T006F10_A2246LegCuenAntDias[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuenAntDias");
               GXutil.writeLogRaw("Old: ",Z2246LegCuenAntDias);
               GXutil.writeLogRaw("Current: ",T006F10_A2246LegCuenAntDias[0]);
            }
            if ( Z2299LegCuenAntAnios != T006F10_A2299LegCuenAntAnios[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuenAntAnios");
               GXutil.writeLogRaw("Old: ",Z2299LegCuenAntAnios);
               GXutil.writeLogRaw("Current: ",T006F10_A2299LegCuenAntAnios[0]);
            }
            if ( Z2300LegCuenAntMeses != T006F10_A2300LegCuenAntMeses[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuenAntMeses");
               GXutil.writeLogRaw("Old: ",Z2300LegCuenAntMeses);
               GXutil.writeLogRaw("Current: ",T006F10_A2300LegCuenAntMeses[0]);
            }
            if ( Z2247LegCuenDiasCorres != T006F10_A2247LegCuenDiasCorres[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuenDiasCorres");
               GXutil.writeLogRaw("Old: ",Z2247LegCuenDiasCorres);
               GXutil.writeLogRaw("Current: ",T006F10_A2247LegCuenDiasCorres[0]);
            }
            if ( Z2248LegCuenDiasGoz != T006F10_A2248LegCuenDiasGoz[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuenDiasGoz");
               GXutil.writeLogRaw("Old: ",Z2248LegCuenDiasGoz);
               GXutil.writeLogRaw("Current: ",T006F10_A2248LegCuenDiasGoz[0]);
            }
            if ( Z2249LegCuenDiasVig != T006F10_A2249LegCuenDiasVig[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuenDiasVig");
               GXutil.writeLogRaw("Old: ",Z2249LegCuenDiasVig);
               GXutil.writeLogRaw("Current: ",T006F10_A2249LegCuenDiasVig[0]);
            }
            if ( GXutil.strcmp(Z2328LegCueAntAbr, T006F10_A2328LegCueAntAbr[0]) != 0 )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCueAntAbr");
               GXutil.writeLogRaw("Old: ",Z2328LegCueAntAbr);
               GXutil.writeLogRaw("Current: ",T006F10_A2328LegCueAntAbr[0]);
            }
            if ( Z2302LegCuLiPCur != T006F10_A2302LegCuLiPCur[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuLiPCur");
               GXutil.writeLogRaw("Old: ",Z2302LegCuLiPCur);
               GXutil.writeLogRaw("Current: ",T006F10_A2302LegCuLiPCur[0]);
            }
            if ( Z2303LegCuLiPAnt != T006F10_A2303LegCuLiPAnt[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuLiPAnt");
               GXutil.writeLogRaw("Old: ",Z2303LegCuLiPAnt);
               GXutil.writeLogRaw("Current: ",T006F10_A2303LegCuLiPAnt[0]);
            }
            if ( Z2304LegCuLiPVen != T006F10_A2304LegCuLiPVen[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuLiPVen");
               GXutil.writeLogRaw("Old: ",Z2304LegCuLiPVen);
               GXutil.writeLogRaw("Current: ",T006F10_A2304LegCuLiPVen[0]);
            }
            if ( Z2305LegCuLiPSaldo != T006F10_A2305LegCuLiPSaldo[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuLiPSaldo");
               GXutil.writeLogRaw("Old: ",Z2305LegCuLiPSaldo);
               GXutil.writeLogRaw("Current: ",T006F10_A2305LegCuLiPSaldo[0]);
            }
            if ( Z2306LegCuLiPApr != T006F10_A2306LegCuLiPApr[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuLiPApr");
               GXutil.writeLogRaw("Old: ",Z2306LegCuLiPApr);
               GXutil.writeLogRaw("Current: ",T006F10_A2306LegCuLiPApr[0]);
            }
            if ( Z2307LegCuLiAprPGoce != T006F10_A2307LegCuLiAprPGoce[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuLiAprPGoce");
               GXutil.writeLogRaw("Old: ",Z2307LegCuLiAprPGoce);
               GXutil.writeLogRaw("Current: ",T006F10_A2307LegCuLiAprPGoce[0]);
            }
            if ( Z2321LegCuLIncluir != T006F10_A2321LegCuLIncluir[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuLIncluir");
               GXutil.writeLogRaw("Old: ",Z2321LegCuLIncluir);
               GXutil.writeLogRaw("Current: ",T006F10_A2321LegCuLIncluir[0]);
            }
            if ( Z2322LegCuLRecalc != T006F10_A2322LegCuLRecalc[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuLRecalc");
               GXutil.writeLogRaw("Old: ",Z2322LegCuLRecalc);
               GXutil.writeLogRaw("Current: ",T006F10_A2322LegCuLRecalc[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"legajo_cuenta_licencias"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert6F285( )
   {
      beforeValidate6F285( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6F285( ) ;
      }
      if ( AnyError == 0 )
      {
         zm6F285( 0) ;
         checkOptimisticConcurrency6F285( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm6F285( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert6F285( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006F18 */
                  pr_default.execute(16, new Object[] {A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), Short.valueOf(A2315LegCuLActVen), Integer.valueOf(A2313LegCuLTotCons), Integer.valueOf(A2314LegCuLTotCorr), A2244LegCuenLicPerIni, A2245LegCuenLicPerFin, Integer.valueOf(A2246LegCuenAntDias), Short.valueOf(A2299LegCuenAntAnios), Short.valueOf(A2300LegCuenAntMeses), Short.valueOf(A2247LegCuenDiasCorres), Short.valueOf(A2248LegCuenDiasGoz), Short.valueOf(A2249LegCuenDiasVig), A2301LegCueAntTexto, A2328LegCueAntAbr, Short.valueOf(A2302LegCuLiPCur), Short.valueOf(A2303LegCuLiPAnt), Short.valueOf(A2304LegCuLiPVen), Short.valueOf(A2305LegCuLiPSaldo), Short.valueOf(A2306LegCuLiPApr), Short.valueOf(A2307LegCuLiAprPGoce), Boolean.valueOf(A2321LegCuLIncluir), Boolean.valueOf(A2322LegCuLRecalc), A2329LegCuLLogDis, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licencias");
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
                        processLevel6F285( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption6F0( ) ;
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
            load6F285( ) ;
         }
         endLevel6F285( ) ;
      }
      closeExtendedTableCursors6F285( ) ;
   }

   public void update6F285( )
   {
      beforeValidate6F285( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6F285( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency6F285( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm6F285( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate6F285( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006F19 */
                  pr_default.execute(17, new Object[] {Short.valueOf(A2315LegCuLActVen), Integer.valueOf(A2313LegCuLTotCons), Integer.valueOf(A2314LegCuLTotCorr), A2244LegCuenLicPerIni, A2245LegCuenLicPerFin, Integer.valueOf(A2246LegCuenAntDias), Short.valueOf(A2299LegCuenAntAnios), Short.valueOf(A2300LegCuenAntMeses), Short.valueOf(A2247LegCuenDiasCorres), Short.valueOf(A2248LegCuenDiasGoz), Short.valueOf(A2249LegCuenDiasVig), A2301LegCueAntTexto, A2328LegCueAntAbr, Short.valueOf(A2302LegCuLiPCur), Short.valueOf(A2303LegCuLiPAnt), Short.valueOf(A2304LegCuLiPVen), Short.valueOf(A2305LegCuLiPSaldo), Short.valueOf(A2306LegCuLiPApr), Short.valueOf(A2307LegCuLiAprPGoce), Boolean.valueOf(A2321LegCuLIncluir), Boolean.valueOf(A2322LegCuLRecalc), A2329LegCuLLogDis, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licencias");
                  if ( (pr_default.getStatus(17) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"legajo_cuenta_licencias"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate6F285( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel6F285( ) ;
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
         endLevel6F285( ) ;
      }
      closeExtendedTableCursors6F285( ) ;
   }

   public void deferredUpdate6F285( )
   {
   }

   public void delete( )
   {
      beforeValidate6F285( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency6F285( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls6F285( ) ;
         afterConfirm6F285( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete6F285( ) ;
            if ( AnyError == 0 )
            {
               scanStart6F289( ) ;
               while ( RcdFound289 != 0 )
               {
                  getByPrimaryKey6F289( ) ;
                  delete6F289( ) ;
                  scanNext6F289( ) ;
               }
               scanEnd6F289( ) ;
               scanStart6F288( ) ;
               while ( RcdFound288 != 0 )
               {
                  getByPrimaryKey6F288( ) ;
                  delete6F288( ) ;
                  scanNext6F288( ) ;
               }
               scanEnd6F288( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006F20 */
                  pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licencias");
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
      sMode285 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel6F285( ) ;
      Gx_mode = sMode285 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls6F285( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV20Pgmname = "legajo_cuenta_licencias" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
         /* Using cursor T006F21 */
         pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         A250LegIdNomApe = T006F21_A250LegIdNomApe[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A250LegIdNomApe", A250LegIdNomApe);
         A251LegNombre = T006F21_A251LegNombre[0] ;
         A251LegNombre = T006F21_A251LegNombre[0] ;
         A230LegApellido = T006F21_A230LegApellido[0] ;
         A230LegApellido = T006F21_A230LegApellido[0] ;
         A93LegId = T006F21_A93LegId[0] ;
         n93LegId = T006F21_n93LegId[0] ;
         A93LegId = T006F21_A93LegId[0] ;
         n93LegId = T006F21_n93LegId[0] ;
         pr_default.close(19);
      }
   }

   public void processNestedLevel6F288( )
   {
      nGXsfl_93_idx = 0 ;
      while ( nGXsfl_93_idx < nRC_GXsfl_93 )
      {
         readRow6F288( ) ;
         if ( ( nRcdExists_288 != 0 ) || ( nIsMod_288 != 0 ) )
         {
            standaloneNotModal6F288( ) ;
            getKey6F288( ) ;
            if ( ( nRcdExists_288 == 0 ) && ( nRcdDeleted_288 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert6F288( ) ;
            }
            else
            {
               if ( RcdFound288 != 0 )
               {
                  if ( ( nRcdDeleted_288 != 0 ) && ( nRcdExists_288 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete6F288( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_288 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update6F288( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_288 == 0 )
                  {
                     GXCCtl = "LEGCULAPRLICFCH_" + sGXsfl_93_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtLegCuLAprLicFch_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtLegCuLAprLicFch_Internalname, localUtil.format(A2324LegCuLAprLicFch, "99/99/99")) ;
         httpContext.changePostValue( edtLegCuLAprLicCnt_Internalname, GXutil.ltrim( localUtil.ntoc( A2325LegCuLAprLicCnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( cmbLegCuLAprLicOri.getInternalname(), GXutil.rtrim( A2326LegCuLAprLicOri)) ;
         httpContext.changePostValue( "ZT_"+"Z2324LegCuLAprLicFch_"+sGXsfl_93_idx, localUtil.dtoc( Z2324LegCuLAprLicFch, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z2326LegCuLAprLicOri_"+sGXsfl_93_idx, GXutil.rtrim( Z2326LegCuLAprLicOri)) ;
         httpContext.changePostValue( "ZT_"+"Z2325LegCuLAprLicCnt_"+sGXsfl_93_idx, GXutil.ltrim( localUtil.ntoc( Z2325LegCuLAprLicCnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2341LegCuLAprLiqNro_"+sGXsfl_93_idx, GXutil.ltrim( localUtil.ntoc( Z2341LegCuLAprLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_288_"+sGXsfl_93_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_288, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_288_"+sGXsfl_93_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_288, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_288_"+sGXsfl_93_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_288, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_288 != 0 )
         {
            httpContext.changePostValue( "LEGCULAPRLICFCH_"+sGXsfl_93_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLAprLicFch_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "LEGCULAPRLICCNT_"+sGXsfl_93_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLAprLicCnt_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "LEGCULAPRLICORI_"+sGXsfl_93_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbLegCuLAprLicOri.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll6F288( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_288 = (short)(0) ;
      nIsMod_288 = (short)(0) ;
      nRcdDeleted_288 = (short)(0) ;
   }

   public void processNestedLevel6F289( )
   {
      nGXsfl_107_idx = 0 ;
      while ( nGXsfl_107_idx < nRC_GXsfl_107 )
      {
         readRow6F289( ) ;
         if ( ( nRcdExists_289 != 0 ) || ( nIsMod_289 != 0 ) )
         {
            standaloneNotModal6F289( ) ;
            getKey6F289( ) ;
            if ( ( nRcdExists_289 == 0 ) && ( nRcdDeleted_289 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert6F289( ) ;
            }
            else
            {
               if ( RcdFound289 != 0 )
               {
                  if ( ( nRcdDeleted_289 != 0 ) && ( nRcdExists_289 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete6F289( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_289 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update6F289( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_289 == 0 )
                  {
                     GXCCtl = "LEGCULCONSANIO_" + sGXsfl_107_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtLegCuLConsAnio_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtLegCuLConsAnio_Internalname, GXutil.ltrim( localUtil.ntoc( A2310LegCuLConsAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtLegCuLConsSec_Internalname, GXutil.ltrim( localUtil.ntoc( A2311LegCuLConsSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtLegCuLConsCnt_Internalname, GXutil.ltrim( localUtil.ntoc( A2312LegCuLConsCnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( cmbLegCuLConsOri.getInternalname(), GXutil.rtrim( A2327LegCuLConsOri)) ;
         httpContext.changePostValue( "ZT_"+"Z2310LegCuLConsAnio_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( Z2310LegCuLConsAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2311LegCuLConsSec_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( Z2311LegCuLConsSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2327LegCuLConsOri_"+sGXsfl_107_idx, GXutil.rtrim( Z2327LegCuLConsOri)) ;
         httpContext.changePostValue( "ZT_"+"Z2312LegCuLConsCnt_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( Z2312LegCuLConsCnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2342LegCulConsLiqNro_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( Z2342LegCulConsLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_289_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_289, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_289_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_289, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_289_"+sGXsfl_107_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_289, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_289 != 0 )
         {
            httpContext.changePostValue( "LEGCULCONSANIO_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLConsAnio_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "LEGCULCONSSEC_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLConsSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "LEGCULCONSCNT_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLConsCnt_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "LEGCULCONSORI_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbLegCuLConsOri.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll6F289( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_289 = (short)(0) ;
      nIsMod_289 = (short)(0) ;
      nRcdDeleted_289 = (short)(0) ;
   }

   public void processLevel6F285( )
   {
      /* Save parent mode. */
      sMode285 = Gx_mode ;
      processNestedLevel6F288( ) ;
      processNestedLevel6F289( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode285 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel6F285( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(8);
      }
      if ( AnyError == 0 )
      {
         beforeComplete6F285( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "legajo_cuenta_licencias");
         if ( AnyError == 0 )
         {
            confirmValues6F0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "legajo_cuenta_licencias");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart6F285( )
   {
      /* Scan By routine */
      /* Using cursor T006F22 */
      pr_default.execute(20);
      RcdFound285 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound285 = (short)(1) ;
         A3CliCod = T006F22_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T006F22_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T006F22_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A2243LegCuenLicTpo = T006F22_A2243LegCuenLicTpo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
         A2266LegCuenAnio = T006F22_A2266LegCuenAnio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2266LegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2266LegCuenAnio), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext6F285( )
   {
      /* Scan next routine */
      pr_default.readNext(20);
      RcdFound285 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound285 = (short)(1) ;
         A3CliCod = T006F22_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T006F22_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T006F22_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A2243LegCuenLicTpo = T006F22_A2243LegCuenLicTpo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
         A2266LegCuenAnio = T006F22_A2266LegCuenAnio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2266LegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2266LegCuenAnio), 4, 0));
      }
   }

   public void scanEnd6F285( )
   {
      pr_default.close(20);
   }

   public void afterConfirm6F285( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert6F285( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate6F285( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete6F285( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete6F285( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate6F285( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes6F285( )
   {
      edtLegIdNomApe_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegIdNomApe_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegIdNomApe_Enabled), 5, 0), true);
      edtLegCuenAnio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenAnio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenAnio_Enabled), 5, 0), true);
      edtLegCuenLicPerIni_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenLicPerIni_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenLicPerIni_Enabled), 5, 0), true);
      edtLegCuenLicPerFin_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenLicPerFin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenLicPerFin_Enabled), 5, 0), true);
      chkLegCuLIncluir.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkLegCuLIncluir.getInternalname(), "Enabled", GXutil.ltrimstr( chkLegCuLIncluir.getEnabled(), 5, 0), true);
      edtLegCuenDiasCorres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenDiasCorres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenDiasCorres_Enabled), 5, 0), true);
      edtLegCuLiPAnt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPAnt_Enabled), 5, 0), true);
      edtLegCuLiPVen_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPVen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPVen_Enabled), 5, 0), true);
      edtLegCuLiPCur_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPCur_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPCur_Enabled), 5, 0), true);
      edtLegCuLActVen_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLActVen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLActVen_Enabled), 5, 0), true);
      edtLegCuLiPApr_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPApr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPApr_Enabled), 5, 0), true);
      edtLegCuenDiasGoz_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenDiasGoz_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenDiasGoz_Enabled), 5, 0), true);
      edtLegCuLiPSaldo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPSaldo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPSaldo_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      cmbLegCuenLicTpo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegCuenLicTpo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegCuenLicTpo.getEnabled(), 5, 0), true);
      edtLegCuLRecalc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLRecalc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLRecalc_Enabled), 5, 0), true);
      edtLegCuenAntDias_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenAntDias_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenAntDias_Enabled), 5, 0), true);
      edtLegCuenAntAnios_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenAntAnios_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenAntAnios_Enabled), 5, 0), true);
      edtLegCuenAntMeses_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenAntMeses_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenAntMeses_Enabled), 5, 0), true);
      edtLegCueAntTexto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCueAntTexto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCueAntTexto_Enabled), 5, 0), true);
   }

   public void zm6F288( int GX_JID )
   {
      if ( ( GX_JID == 37 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2326LegCuLAprLicOri = T006F7_A2326LegCuLAprLicOri[0] ;
            Z2325LegCuLAprLicCnt = T006F7_A2325LegCuLAprLicCnt[0] ;
            Z2341LegCuLAprLiqNro = T006F7_A2341LegCuLAprLiqNro[0] ;
         }
         else
         {
            Z2326LegCuLAprLicOri = A2326LegCuLAprLicOri ;
            Z2325LegCuLAprLicCnt = A2325LegCuLAprLicCnt ;
            Z2341LegCuLAprLiqNro = A2341LegCuLAprLiqNro ;
         }
      }
      if ( GX_JID == -37 )
      {
         Z2243LegCuenLicTpo = A2243LegCuenLicTpo ;
         Z2266LegCuenAnio = A2266LegCuenAnio ;
         Z2324LegCuLAprLicFch = A2324LegCuLAprLicFch ;
         Z2326LegCuLAprLicOri = A2326LegCuLAprLicOri ;
         Z2325LegCuLAprLicCnt = A2325LegCuLAprLicCnt ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z2341LegCuLAprLiqNro = A2341LegCuLAprLiqNro ;
         Z6LegNumero = A6LegNumero ;
      }
   }

   public void standaloneNotModal6F288( )
   {
      cmbLegCuLAprLicOri.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegCuLAprLicOri.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegCuLAprLicOri.getEnabled(), 5, 0), !bGXsfl_93_Refreshing);
   }

   public void standaloneModal6F288( )
   {
      if ( isIns( )  && (GXutil.strcmp("", A2326LegCuLAprLicOri)==0) && ( Gx_BScreen == 0 ) )
      {
         A2326LegCuLAprLicOri = "manual" ;
      }
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtLegCuLAprLicFch_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegCuLAprLicFch_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLAprLicFch_Enabled), 5, 0), !bGXsfl_93_Refreshing);
      }
      else
      {
         edtLegCuLAprLicFch_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegCuLAprLicFch_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLAprLicFch_Enabled), 5, 0), !bGXsfl_93_Refreshing);
      }
   }

   public void load6F288( )
   {
      /* Using cursor T006F23 */
      pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), A2324LegCuLAprLicFch});
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound288 = (short)(1) ;
         A2326LegCuLAprLicOri = T006F23_A2326LegCuLAprLicOri[0] ;
         A2325LegCuLAprLicCnt = T006F23_A2325LegCuLAprLicCnt[0] ;
         A2341LegCuLAprLiqNro = T006F23_A2341LegCuLAprLiqNro[0] ;
         n2341LegCuLAprLiqNro = T006F23_n2341LegCuLAprLiqNro[0] ;
         zm6F288( -37) ;
      }
      pr_default.close(21);
      onLoadActions6F288( ) ;
   }

   public void onLoadActions6F288( )
   {
   }

   public void checkExtendedTable6F288( )
   {
      nIsDirty_288 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal6F288( ) ;
      /* Using cursor T006F8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n2341LegCuLAprLiqNro), Integer.valueOf(A2341LegCuLAprLiqNro)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A2341LegCuLAprLiqNro) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "CCLicencia Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGCULAPRLIQNRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(6);
      /* Using cursor T006F9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n2341LegCuLAprLiqNro), Integer.valueOf(A2341LegCuLAprLiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A2341LegCuLAprLiqNro) || (0==A6LegNumero) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "CCLicencia Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(7);
   }

   public void closeExtendedTableCursors6F288( )
   {
      pr_default.close(6);
      pr_default.close(7);
   }

   public void enableDisable6F288( )
   {
   }

   public void gxload_38( int A3CliCod ,
                          short A1EmpCod ,
                          int A2341LegCuLAprLiqNro )
   {
      /* Using cursor T006F24 */
      pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n2341LegCuLAprLiqNro), Integer.valueOf(A2341LegCuLAprLiqNro)});
      if ( (pr_default.getStatus(22) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A2341LegCuLAprLiqNro) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "CCLicencia Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGCULAPRLIQNRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(22) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(22);
   }

   public void gxload_39( int A3CliCod ,
                          short A1EmpCod ,
                          int A2341LegCuLAprLiqNro ,
                          int A6LegNumero )
   {
      /* Using cursor T006F25 */
      pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n2341LegCuLAprLiqNro), Integer.valueOf(A2341LegCuLAprLiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(23) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A2341LegCuLAprLiqNro) || (0==A6LegNumero) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "CCLicencia Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(23) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(23);
   }

   public void getKey6F288( )
   {
      /* Using cursor T006F26 */
      pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), A2324LegCuLAprLicFch});
      if ( (pr_default.getStatus(24) != 101) )
      {
         RcdFound288 = (short)(1) ;
      }
      else
      {
         RcdFound288 = (short)(0) ;
      }
      pr_default.close(24);
   }

   public void getByPrimaryKey6F288( )
   {
      /* Using cursor T006F7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), A2324LegCuLAprLicFch});
      if ( (pr_default.getStatus(5) != 101) )
      {
         zm6F288( 37) ;
         RcdFound288 = (short)(1) ;
         initializeNonKey6F288( ) ;
         A2324LegCuLAprLicFch = T006F7_A2324LegCuLAprLicFch[0] ;
         A2326LegCuLAprLicOri = T006F7_A2326LegCuLAprLicOri[0] ;
         A2325LegCuLAprLicCnt = T006F7_A2325LegCuLAprLicCnt[0] ;
         A2341LegCuLAprLiqNro = T006F7_A2341LegCuLAprLiqNro[0] ;
         n2341LegCuLAprLiqNro = T006F7_n2341LegCuLAprLiqNro[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z2243LegCuenLicTpo = A2243LegCuenLicTpo ;
         Z2266LegCuenAnio = A2266LegCuenAnio ;
         Z2324LegCuLAprLicFch = A2324LegCuLAprLicFch ;
         sMode288 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load6F288( ) ;
         Gx_mode = sMode288 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound288 = (short)(0) ;
         initializeNonKey6F288( ) ;
         sMode288 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal6F288( ) ;
         Gx_mode = sMode288 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes6F288( ) ;
      }
      pr_default.close(5);
   }

   public void checkOptimisticConcurrency6F288( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T006F6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), A2324LegCuLAprLicFch});
         if ( (pr_default.getStatus(4) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"legajo_cuenta_licenciasaprobaciones"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(4) == 101) || ( GXutil.strcmp(Z2326LegCuLAprLicOri, T006F6_A2326LegCuLAprLicOri[0]) != 0 ) || ( Z2325LegCuLAprLicCnt != T006F6_A2325LegCuLAprLicCnt[0] ) || ( Z2341LegCuLAprLiqNro != T006F6_A2341LegCuLAprLiqNro[0] ) )
         {
            if ( GXutil.strcmp(Z2326LegCuLAprLicOri, T006F6_A2326LegCuLAprLicOri[0]) != 0 )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuLAprLicOri");
               GXutil.writeLogRaw("Old: ",Z2326LegCuLAprLicOri);
               GXutil.writeLogRaw("Current: ",T006F6_A2326LegCuLAprLicOri[0]);
            }
            if ( Z2325LegCuLAprLicCnt != T006F6_A2325LegCuLAprLicCnt[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuLAprLicCnt");
               GXutil.writeLogRaw("Old: ",Z2325LegCuLAprLicCnt);
               GXutil.writeLogRaw("Current: ",T006F6_A2325LegCuLAprLicCnt[0]);
            }
            if ( Z2341LegCuLAprLiqNro != T006F6_A2341LegCuLAprLiqNro[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuLAprLiqNro");
               GXutil.writeLogRaw("Old: ",Z2341LegCuLAprLiqNro);
               GXutil.writeLogRaw("Current: ",T006F6_A2341LegCuLAprLiqNro[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"legajo_cuenta_licenciasaprobaciones"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert6F288( )
   {
      beforeValidate6F288( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6F288( ) ;
      }
      if ( AnyError == 0 )
      {
         zm6F288( 0) ;
         checkOptimisticConcurrency6F288( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm6F288( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert6F288( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006F27 */
                  pr_default.execute(25, new Object[] {A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), A2324LegCuLAprLicFch, A2326LegCuLAprLicOri, Short.valueOf(A2325LegCuLAprLicCnt), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n2341LegCuLAprLiqNro), Integer.valueOf(A2341LegCuLAprLiqNro), Integer.valueOf(A6LegNumero)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasaprobaciones");
                  if ( (pr_default.getStatus(25) == 1) )
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
            load6F288( ) ;
         }
         endLevel6F288( ) ;
      }
      closeExtendedTableCursors6F288( ) ;
   }

   public void update6F288( )
   {
      beforeValidate6F288( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6F288( ) ;
      }
      if ( ( nIsMod_288 != 0 ) || ( nIsDirty_288 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency6F288( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm6F288( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate6F288( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T006F28 */
                     pr_default.execute(26, new Object[] {A2326LegCuLAprLicOri, Short.valueOf(A2325LegCuLAprLicCnt), Boolean.valueOf(n2341LegCuLAprLiqNro), Integer.valueOf(A2341LegCuLAprLiqNro), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), A2324LegCuLAprLicFch});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasaprobaciones");
                     if ( (pr_default.getStatus(26) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"legajo_cuenta_licenciasaprobaciones"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate6F288( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey6F288( ) ;
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
            endLevel6F288( ) ;
         }
      }
      closeExtendedTableCursors6F288( ) ;
   }

   public void deferredUpdate6F288( )
   {
   }

   public void delete6F288( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate6F288( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency6F288( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls6F288( ) ;
         afterConfirm6F288( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete6F288( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T006F29 */
               pr_default.execute(27, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), A2324LegCuLAprLicFch});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasaprobaciones");
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
      sMode288 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel6F288( ) ;
      Gx_mode = sMode288 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls6F288( )
   {
      standaloneModal6F288( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isDlt( )  && true /* Level */ && ( GXutil.strcmp(A2326LegCuLAprLicOri, "manual") != 0 ) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "No se pueden eliminar registros automáticos", ""), 1, "");
            AnyError = (short)(1) ;
         }
      }
   }

   public void endLevel6F288( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(4);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart6F288( )
   {
      /* Scan By routine */
      /* Using cursor T006F30 */
      pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
      RcdFound288 = (short)(0) ;
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound288 = (short)(1) ;
         A2324LegCuLAprLicFch = T006F30_A2324LegCuLAprLicFch[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext6F288( )
   {
      /* Scan next routine */
      pr_default.readNext(28);
      RcdFound288 = (short)(0) ;
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound288 = (short)(1) ;
         A2324LegCuLAprLicFch = T006F30_A2324LegCuLAprLicFch[0] ;
      }
   }

   public void scanEnd6F288( )
   {
      pr_default.close(28);
   }

   public void afterConfirm6F288( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert6F288( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate6F288( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete6F288( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete6F288( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate6F288( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes6F288( )
   {
      edtLegCuLAprLicFch_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLAprLicFch_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLAprLicFch_Enabled), 5, 0), !bGXsfl_93_Refreshing);
      edtLegCuLAprLicCnt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLAprLicCnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLAprLicCnt_Enabled), 5, 0), !bGXsfl_93_Refreshing);
      cmbLegCuLAprLicOri.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegCuLAprLicOri.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegCuLAprLicOri.getEnabled(), 5, 0), !bGXsfl_93_Refreshing);
   }

   public void send_integrity_lvl_hashes6F288( )
   {
   }

   public void zm6F289( int GX_JID )
   {
      if ( ( GX_JID == 40 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2327LegCuLConsOri = T006F3_A2327LegCuLConsOri[0] ;
            Z2312LegCuLConsCnt = T006F3_A2312LegCuLConsCnt[0] ;
            Z2342LegCulConsLiqNro = T006F3_A2342LegCulConsLiqNro[0] ;
         }
         else
         {
            Z2327LegCuLConsOri = A2327LegCuLConsOri ;
            Z2312LegCuLConsCnt = A2312LegCuLConsCnt ;
            Z2342LegCulConsLiqNro = A2342LegCulConsLiqNro ;
         }
      }
      if ( GX_JID == -40 )
      {
         Z2243LegCuenLicTpo = A2243LegCuenLicTpo ;
         Z2266LegCuenAnio = A2266LegCuenAnio ;
         Z2310LegCuLConsAnio = A2310LegCuLConsAnio ;
         Z2311LegCuLConsSec = A2311LegCuLConsSec ;
         Z2327LegCuLConsOri = A2327LegCuLConsOri ;
         Z2312LegCuLConsCnt = A2312LegCuLConsCnt ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z2342LegCulConsLiqNro = A2342LegCulConsLiqNro ;
         Z6LegNumero = A6LegNumero ;
      }
   }

   public void standaloneNotModal6F289( )
   {
      cmbLegCuLConsOri.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegCuLConsOri.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegCuLConsOri.getEnabled(), 5, 0), !bGXsfl_107_Refreshing);
      edtLegCuLConsSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLConsSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLConsSec_Enabled), 5, 0), !bGXsfl_107_Refreshing);
   }

   public void standaloneModal6F289( )
   {
      if ( isIns( )  && (GXutil.strcmp("", A2327LegCuLConsOri)==0) && ( Gx_BScreen == 0 ) )
      {
         A2327LegCuLConsOri = "manual" ;
      }
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtLegCuLConsAnio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegCuLConsAnio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLConsAnio_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      }
      else
      {
         edtLegCuLConsAnio_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegCuLConsAnio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLConsAnio_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      }
   }

   public void load6F289( )
   {
      /* Using cursor T006F31 */
      pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), Short.valueOf(A2310LegCuLConsAnio), Short.valueOf(A2311LegCuLConsSec)});
      if ( (pr_default.getStatus(29) != 101) )
      {
         RcdFound289 = (short)(1) ;
         A2327LegCuLConsOri = T006F31_A2327LegCuLConsOri[0] ;
         A2312LegCuLConsCnt = T006F31_A2312LegCuLConsCnt[0] ;
         A2342LegCulConsLiqNro = T006F31_A2342LegCulConsLiqNro[0] ;
         n2342LegCulConsLiqNro = T006F31_n2342LegCulConsLiqNro[0] ;
         zm6F289( -40) ;
      }
      pr_default.close(29);
      onLoadActions6F289( ) ;
   }

   public void onLoadActions6F289( )
   {
   }

   public void checkExtendedTable6F289( )
   {
      nIsDirty_289 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal6F289( ) ;
      /* Using cursor T006F4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n2342LegCulConsLiqNro), Integer.valueOf(A2342LegCulConsLiqNro)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A2342LegCulConsLiqNro) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "CCLicencia Liq Consumo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGCULCONSLIQNRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(2);
      /* Using cursor T006F5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n2342LegCulConsLiqNro), Integer.valueOf(A2342LegCulConsLiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A2342LegCulConsLiqNro) || (0==A6LegNumero) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "CCLicencia Liq Consumo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(3);
   }

   public void closeExtendedTableCursors6F289( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable6F289( )
   {
   }

   public void gxload_41( int A3CliCod ,
                          short A1EmpCod ,
                          int A2342LegCulConsLiqNro )
   {
      /* Using cursor T006F32 */
      pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n2342LegCulConsLiqNro), Integer.valueOf(A2342LegCulConsLiqNro)});
      if ( (pr_default.getStatus(30) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A2342LegCulConsLiqNro) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "CCLicencia Liq Consumo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGCULCONSLIQNRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(30) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(30);
   }

   public void gxload_42( int A3CliCod ,
                          short A1EmpCod ,
                          int A2342LegCulConsLiqNro ,
                          int A6LegNumero )
   {
      /* Using cursor T006F33 */
      pr_default.execute(31, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n2342LegCulConsLiqNro), Integer.valueOf(A2342LegCulConsLiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(31) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A2342LegCulConsLiqNro) || (0==A6LegNumero) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "CCLicencia Liq Consumo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(31) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(31);
   }

   public void getKey6F289( )
   {
      /* Using cursor T006F34 */
      pr_default.execute(32, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), Short.valueOf(A2310LegCuLConsAnio), Short.valueOf(A2311LegCuLConsSec)});
      if ( (pr_default.getStatus(32) != 101) )
      {
         RcdFound289 = (short)(1) ;
      }
      else
      {
         RcdFound289 = (short)(0) ;
      }
      pr_default.close(32);
   }

   public void getByPrimaryKey6F289( )
   {
      /* Using cursor T006F3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), Short.valueOf(A2310LegCuLConsAnio), Short.valueOf(A2311LegCuLConsSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm6F289( 40) ;
         RcdFound289 = (short)(1) ;
         initializeNonKey6F289( ) ;
         A2310LegCuLConsAnio = T006F3_A2310LegCuLConsAnio[0] ;
         A2311LegCuLConsSec = T006F3_A2311LegCuLConsSec[0] ;
         A2327LegCuLConsOri = T006F3_A2327LegCuLConsOri[0] ;
         A2312LegCuLConsCnt = T006F3_A2312LegCuLConsCnt[0] ;
         A2342LegCulConsLiqNro = T006F3_A2342LegCulConsLiqNro[0] ;
         n2342LegCulConsLiqNro = T006F3_n2342LegCulConsLiqNro[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z2243LegCuenLicTpo = A2243LegCuenLicTpo ;
         Z2266LegCuenAnio = A2266LegCuenAnio ;
         Z2310LegCuLConsAnio = A2310LegCuLConsAnio ;
         Z2311LegCuLConsSec = A2311LegCuLConsSec ;
         sMode289 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load6F289( ) ;
         Gx_mode = sMode289 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound289 = (short)(0) ;
         initializeNonKey6F289( ) ;
         sMode289 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal6F289( ) ;
         Gx_mode = sMode289 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes6F289( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency6F289( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T006F2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), Short.valueOf(A2310LegCuLConsAnio), Short.valueOf(A2311LegCuLConsSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"legajo_cuenta_licenciasconsumos"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z2327LegCuLConsOri, T006F2_A2327LegCuLConsOri[0]) != 0 ) || ( Z2312LegCuLConsCnt != T006F2_A2312LegCuLConsCnt[0] ) || ( Z2342LegCulConsLiqNro != T006F2_A2342LegCulConsLiqNro[0] ) )
         {
            if ( GXutil.strcmp(Z2327LegCuLConsOri, T006F2_A2327LegCuLConsOri[0]) != 0 )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuLConsOri");
               GXutil.writeLogRaw("Old: ",Z2327LegCuLConsOri);
               GXutil.writeLogRaw("Current: ",T006F2_A2327LegCuLConsOri[0]);
            }
            if ( Z2312LegCuLConsCnt != T006F2_A2312LegCuLConsCnt[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCuLConsCnt");
               GXutil.writeLogRaw("Old: ",Z2312LegCuLConsCnt);
               GXutil.writeLogRaw("Current: ",T006F2_A2312LegCuLConsCnt[0]);
            }
            if ( Z2342LegCulConsLiqNro != T006F2_A2342LegCulConsLiqNro[0] )
            {
               GXutil.writeLogln("legajo_cuenta_licencias:[seudo value changed for attri]"+"LegCulConsLiqNro");
               GXutil.writeLogRaw("Old: ",Z2342LegCulConsLiqNro);
               GXutil.writeLogRaw("Current: ",T006F2_A2342LegCulConsLiqNro[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"legajo_cuenta_licenciasconsumos"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert6F289( )
   {
      beforeValidate6F289( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6F289( ) ;
      }
      if ( AnyError == 0 )
      {
         zm6F289( 0) ;
         checkOptimisticConcurrency6F289( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm6F289( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert6F289( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006F35 */
                  pr_default.execute(33, new Object[] {A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), Short.valueOf(A2310LegCuLConsAnio), Short.valueOf(A2311LegCuLConsSec), A2327LegCuLConsOri, Short.valueOf(A2312LegCuLConsCnt), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n2342LegCulConsLiqNro), Integer.valueOf(A2342LegCulConsLiqNro), Integer.valueOf(A6LegNumero)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasconsumos");
                  if ( (pr_default.getStatus(33) == 1) )
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
            load6F289( ) ;
         }
         endLevel6F289( ) ;
      }
      closeExtendedTableCursors6F289( ) ;
   }

   public void update6F289( )
   {
      beforeValidate6F289( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6F289( ) ;
      }
      if ( ( nIsMod_289 != 0 ) || ( nIsDirty_289 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency6F289( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm6F289( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate6F289( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T006F36 */
                     pr_default.execute(34, new Object[] {A2327LegCuLConsOri, Short.valueOf(A2312LegCuLConsCnt), Boolean.valueOf(n2342LegCulConsLiqNro), Integer.valueOf(A2342LegCulConsLiqNro), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), Short.valueOf(A2310LegCuLConsAnio), Short.valueOf(A2311LegCuLConsSec)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasconsumos");
                     if ( (pr_default.getStatus(34) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"legajo_cuenta_licenciasconsumos"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate6F289( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey6F289( ) ;
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
            endLevel6F289( ) ;
         }
      }
      closeExtendedTableCursors6F289( ) ;
   }

   public void deferredUpdate6F289( )
   {
   }

   public void delete6F289( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate6F289( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency6F289( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls6F289( ) ;
         afterConfirm6F289( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete6F289( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T006F37 */
               pr_default.execute(35, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), Short.valueOf(A2310LegCuLConsAnio), Short.valueOf(A2311LegCuLConsSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasconsumos");
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
      sMode289 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel6F289( ) ;
      Gx_mode = sMode289 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls6F289( )
   {
      standaloneModal6F289( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isDlt( )  && true /* Level */ && ( GXutil.strcmp(A2327LegCuLConsOri, "manual") != 0 ) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "No se pueden eliminar registros automáticos", ""), 1, "");
            AnyError = (short)(1) ;
         }
      }
   }

   public void endLevel6F289( )
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

   public void scanStart6F289( )
   {
      /* Scan By routine */
      /* Using cursor T006F38 */
      pr_default.execute(36, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
      RcdFound289 = (short)(0) ;
      if ( (pr_default.getStatus(36) != 101) )
      {
         RcdFound289 = (short)(1) ;
         A2310LegCuLConsAnio = T006F38_A2310LegCuLConsAnio[0] ;
         A2311LegCuLConsSec = T006F38_A2311LegCuLConsSec[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext6F289( )
   {
      /* Scan next routine */
      pr_default.readNext(36);
      RcdFound289 = (short)(0) ;
      if ( (pr_default.getStatus(36) != 101) )
      {
         RcdFound289 = (short)(1) ;
         A2310LegCuLConsAnio = T006F38_A2310LegCuLConsAnio[0] ;
         A2311LegCuLConsSec = T006F38_A2311LegCuLConsSec[0] ;
      }
   }

   public void scanEnd6F289( )
   {
      pr_default.close(36);
   }

   public void afterConfirm6F289( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert6F289( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate6F289( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete6F289( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete6F289( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate6F289( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes6F289( )
   {
      edtLegCuLConsAnio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLConsAnio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLConsAnio_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      edtLegCuLConsSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLConsSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLConsSec_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      edtLegCuLConsCnt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLConsCnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLConsCnt_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      cmbLegCuLConsOri.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegCuLConsOri.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegCuLConsOri.getEnabled(), 5, 0), !bGXsfl_107_Refreshing);
   }

   public void send_integrity_lvl_hashes6F289( )
   {
   }

   public void send_integrity_lvl_hashes6F285( )
   {
   }

   public void subsflControlProps_93288( )
   {
      edtLegCuLAprLicFch_Internalname = "LEGCULAPRLICFCH_"+sGXsfl_93_idx ;
      edtLegCuLAprLicCnt_Internalname = "LEGCULAPRLICCNT_"+sGXsfl_93_idx ;
      cmbLegCuLAprLicOri.setInternalname( "LEGCULAPRLICORI_"+sGXsfl_93_idx );
   }

   public void subsflControlProps_fel_93288( )
   {
      edtLegCuLAprLicFch_Internalname = "LEGCULAPRLICFCH_"+sGXsfl_93_fel_idx ;
      edtLegCuLAprLicCnt_Internalname = "LEGCULAPRLICCNT_"+sGXsfl_93_fel_idx ;
      cmbLegCuLAprLicOri.setInternalname( "LEGCULAPRLICORI_"+sGXsfl_93_fel_idx );
   }

   public void addRow6F288( )
   {
      nGXsfl_93_idx = (int)(nGXsfl_93_idx+1) ;
      sGXsfl_93_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_93_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_93288( ) ;
      sendRow6F288( ) ;
   }

   public void sendRow6F288( )
   {
      Gridlevel_aprobacionesRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_aprobaciones_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_aprobaciones_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_aprobaciones_Class, "") != 0 )
         {
            subGridlevel_aprobaciones_Linesclass = subGridlevel_aprobaciones_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_aprobaciones_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_aprobaciones_Backstyle = (byte)(0) ;
         subGridlevel_aprobaciones_Backcolor = subGridlevel_aprobaciones_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_aprobaciones_Class, "") != 0 )
         {
            subGridlevel_aprobaciones_Linesclass = subGridlevel_aprobaciones_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_aprobaciones_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_aprobaciones_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_aprobaciones_Class, "") != 0 )
         {
            subGridlevel_aprobaciones_Linesclass = subGridlevel_aprobaciones_Class+"Odd" ;
         }
         subGridlevel_aprobaciones_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_aprobaciones_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_aprobaciones_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_93_idx) % (2))) == 0 )
         {
            subGridlevel_aprobaciones_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_aprobaciones_Class, "") != 0 )
            {
               subGridlevel_aprobaciones_Linesclass = subGridlevel_aprobaciones_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_aprobaciones_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_aprobaciones_Class, "") != 0 )
            {
               subGridlevel_aprobaciones_Linesclass = subGridlevel_aprobaciones_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_288_" + sGXsfl_93_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 94,'',false,'" + sGXsfl_93_idx + "',93)\"" ;
      ROClassString = "AttributeDate" ;
      Gridlevel_aprobacionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCuLAprLicFch_Internalname,localUtil.format(A2324LegCuLAprLicFch, "99/99/99"),localUtil.format( A2324LegCuLAprLicFch, "99/99/99"),TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,94);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCuLAprLicFch_Jsonclick,Integer.valueOf(0),"AttributeDate","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtLegCuLAprLicFch_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(93),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_288_" + sGXsfl_93_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 95,'',false,'" + sGXsfl_93_idx + "',93)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_aprobacionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCuLAprLicCnt_Internalname,GXutil.ltrim( localUtil.ntoc( A2325LegCuLAprLicCnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtLegCuLAprLicCnt_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2325LegCuLAprLicCnt), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2325LegCuLAprLicCnt), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,95);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCuLAprLicCnt_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtLegCuLAprLicCnt_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(93),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      GXCCtl = "LEGCULAPRLICORI_" + sGXsfl_93_idx ;
      cmbLegCuLAprLicOri.setName( GXCCtl );
      cmbLegCuLAprLicOri.setWebtags( "" );
      cmbLegCuLAprLicOri.addItem("licencias", httpContext.getMessage( "Licencias aprobadas", ""), (short)(0));
      cmbLegCuLAprLicOri.addItem("importacion", httpContext.getMessage( "Importación de LSD", ""), (short)(0));
      cmbLegCuLAprLicOri.addItem("manual", httpContext.getMessage( "Manual", ""), (short)(0));
      cmbLegCuLAprLicOri.addItem("inicializacion", httpContext.getMessage( "Inicialización automática", ""), (short)(0));
      cmbLegCuLAprLicOri.addItem("final", httpContext.getMessage( "Liquidación final", ""), (short)(0));
      if ( cmbLegCuLAprLicOri.getItemCount() > 0 )
      {
         if ( isIns( ) && (GXutil.strcmp("", A2326LegCuLAprLicOri)==0) )
         {
            A2326LegCuLAprLicOri = "manual" ;
         }
      }
      /* ComboBox */
      Gridlevel_aprobacionesRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLegCuLAprLicOri,cmbLegCuLAprLicOri.getInternalname(),GXutil.rtrim( A2326LegCuLAprLicOri),Integer.valueOf(1),cmbLegCuLAprLicOri.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbLegCuLAprLicOri.getEnabled()),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","TrnColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
      cmbLegCuLAprLicOri.setValue( GXutil.rtrim( A2326LegCuLAprLicOri) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegCuLAprLicOri.getInternalname(), "Values", cmbLegCuLAprLicOri.ToJavascriptSource(), !bGXsfl_93_Refreshing);
      httpContext.ajax_sending_grid_row(Gridlevel_aprobacionesRow);
      send_integrity_lvl_hashes6F288( ) ;
      GXCCtl = "Z2324LegCuLAprLicFch_" + sGXsfl_93_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, localUtil.dtoc( Z2324LegCuLAprLicFch, 0, "/"));
      GXCCtl = "Z2326LegCuLAprLicOri_" + sGXsfl_93_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z2326LegCuLAprLicOri));
      GXCCtl = "Z2325LegCuLAprLicCnt_" + sGXsfl_93_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2325LegCuLAprLicCnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2341LegCuLAprLiqNro_" + sGXsfl_93_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2341LegCuLAprLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_288_" + sGXsfl_93_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_288, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_288_" + sGXsfl_93_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_288, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_288_" + sGXsfl_93_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_288, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_93_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_93_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vEMPCOD_" + sGXsfl_93_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vLEGNUMERO_" + sGXsfl_93_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV9LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vLEGCUENLICTPO_" + sGXsfl_93_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV10LegCuenLicTpo));
      GXCCtl = "vLEGCUENANIO_" + sGXsfl_93_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV11LegCuenAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCULAPRLICFCH_"+sGXsfl_93_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLAprLicFch_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCULAPRLICCNT_"+sGXsfl_93_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLAprLicCnt_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCULAPRLICORI_"+sGXsfl_93_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbLegCuLAprLicOri.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_aprobacionesContainer.AddRow(Gridlevel_aprobacionesRow);
   }

   public void readRow6F288( )
   {
      nGXsfl_93_idx = (int)(nGXsfl_93_idx+1) ;
      sGXsfl_93_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_93_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_93288( ) ;
      edtLegCuLAprLicFch_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULAPRLICFCH_"+sGXsfl_93_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtLegCuLAprLicCnt_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULAPRLICCNT_"+sGXsfl_93_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      cmbLegCuLAprLicOri.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULAPRLICORI_"+sGXsfl_93_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      if ( localUtil.vcdate( httpContext.cgiGet( edtLegCuLAprLicFch_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
      {
         GXCCtl = "LEGCULAPRLICFCH_" + sGXsfl_93_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegCuLAprLicFch_Internalname ;
         wbErr = true ;
         A2324LegCuLAprLicFch = GXutil.nullDate() ;
      }
      else
      {
         A2324LegCuLAprLicFch = localUtil.ctod( httpContext.cgiGet( edtLegCuLAprLicFch_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegCuLAprLicCnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegCuLAprLicCnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
      {
         GXCCtl = "LEGCULAPRLICCNT_" + sGXsfl_93_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegCuLAprLicCnt_Internalname ;
         wbErr = true ;
         A2325LegCuLAprLicCnt = (short)(0) ;
      }
      else
      {
         A2325LegCuLAprLicCnt = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLAprLicCnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      cmbLegCuLAprLicOri.setName( cmbLegCuLAprLicOri.getInternalname() );
      cmbLegCuLAprLicOri.setValue( httpContext.cgiGet( cmbLegCuLAprLicOri.getInternalname()) );
      A2326LegCuLAprLicOri = httpContext.cgiGet( cmbLegCuLAprLicOri.getInternalname()) ;
      GXCCtl = "Z2324LegCuLAprLicFch_" + sGXsfl_93_idx ;
      Z2324LegCuLAprLicFch = localUtil.ctod( httpContext.cgiGet( GXCCtl), 0) ;
      GXCCtl = "Z2326LegCuLAprLicOri_" + sGXsfl_93_idx ;
      Z2326LegCuLAprLicOri = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2325LegCuLAprLicCnt_" + sGXsfl_93_idx ;
      Z2325LegCuLAprLicCnt = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2341LegCuLAprLiqNro_" + sGXsfl_93_idx ;
      Z2341LegCuLAprLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      n2341LegCuLAprLiqNro = ((0==A2341LegCuLAprLiqNro) ? true : false) ;
      GXCCtl = "Z2341LegCuLAprLiqNro_" + sGXsfl_93_idx ;
      A2341LegCuLAprLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      n2341LegCuLAprLiqNro = false ;
      n2341LegCuLAprLiqNro = ((0==A2341LegCuLAprLiqNro) ? true : false) ;
      GXCCtl = "nRcdDeleted_288_" + sGXsfl_93_idx ;
      nRcdDeleted_288 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_288_" + sGXsfl_93_idx ;
      nRcdExists_288 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_288_" + sGXsfl_93_idx ;
      nIsMod_288 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void subsflControlProps_107289( )
   {
      edtLegCuLConsAnio_Internalname = "LEGCULCONSANIO_"+sGXsfl_107_idx ;
      edtLegCuLConsSec_Internalname = "LEGCULCONSSEC_"+sGXsfl_107_idx ;
      edtLegCuLConsCnt_Internalname = "LEGCULCONSCNT_"+sGXsfl_107_idx ;
      cmbLegCuLConsOri.setInternalname( "LEGCULCONSORI_"+sGXsfl_107_idx );
   }

   public void subsflControlProps_fel_107289( )
   {
      edtLegCuLConsAnio_Internalname = "LEGCULCONSANIO_"+sGXsfl_107_fel_idx ;
      edtLegCuLConsSec_Internalname = "LEGCULCONSSEC_"+sGXsfl_107_fel_idx ;
      edtLegCuLConsCnt_Internalname = "LEGCULCONSCNT_"+sGXsfl_107_fel_idx ;
      cmbLegCuLConsOri.setInternalname( "LEGCULCONSORI_"+sGXsfl_107_fel_idx );
   }

   public void addRow6F289( )
   {
      nGXsfl_107_idx = (int)(nGXsfl_107_idx+1) ;
      sGXsfl_107_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_107_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_107289( ) ;
      sendRow6F289( ) ;
   }

   public void sendRow6F289( )
   {
      Gridlevel_consumosRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_consumos_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_consumos_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_consumos_Class, "") != 0 )
         {
            subGridlevel_consumos_Linesclass = subGridlevel_consumos_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_consumos_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_consumos_Backstyle = (byte)(0) ;
         subGridlevel_consumos_Backcolor = subGridlevel_consumos_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_consumos_Class, "") != 0 )
         {
            subGridlevel_consumos_Linesclass = subGridlevel_consumos_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_consumos_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_consumos_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_consumos_Class, "") != 0 )
         {
            subGridlevel_consumos_Linesclass = subGridlevel_consumos_Class+"Odd" ;
         }
         subGridlevel_consumos_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_consumos_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_consumos_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_107_idx) % (2))) == 0 )
         {
            subGridlevel_consumos_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_consumos_Class, "") != 0 )
            {
               subGridlevel_consumos_Linesclass = subGridlevel_consumos_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_consumos_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_consumos_Class, "") != 0 )
            {
               subGridlevel_consumos_Linesclass = subGridlevel_consumos_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_289_" + sGXsfl_107_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 108,'',false,'" + sGXsfl_107_idx + "',107)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_consumosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCuLConsAnio_Internalname,GXutil.ltrim( localUtil.ntoc( A2310LegCuLConsAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2310LegCuLConsAnio), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,108);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCuLConsAnio_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtLegCuLConsAnio_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(107),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridlevel_consumosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCuLConsSec_Internalname,GXutil.ltrim( localUtil.ntoc( A2311LegCuLConsSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtLegCuLConsSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2311LegCuLConsSec), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2311LegCuLConsSec), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCuLConsSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(0),Integer.valueOf(edtLegCuLConsSec_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(107),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_289_" + sGXsfl_107_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 110,'',false,'" + sGXsfl_107_idx + "',107)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_consumosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCuLConsCnt_Internalname,GXutil.ltrim( localUtil.ntoc( A2312LegCuLConsCnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtLegCuLConsCnt_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2312LegCuLConsCnt), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2312LegCuLConsCnt), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,110);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCuLConsCnt_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtLegCuLConsCnt_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(107),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      GXCCtl = "LEGCULCONSORI_" + sGXsfl_107_idx ;
      cmbLegCuLConsOri.setName( GXCCtl );
      cmbLegCuLConsOri.setWebtags( "" );
      cmbLegCuLConsOri.addItem("licencias", httpContext.getMessage( "Licencias aprobadas", ""), (short)(0));
      cmbLegCuLConsOri.addItem("importacion", httpContext.getMessage( "Importación de LSD", ""), (short)(0));
      cmbLegCuLConsOri.addItem("manual", httpContext.getMessage( "Manual", ""), (short)(0));
      cmbLegCuLConsOri.addItem("inicializacion", httpContext.getMessage( "Inicialización automática", ""), (short)(0));
      cmbLegCuLConsOri.addItem("final", httpContext.getMessage( "Liquidación final", ""), (short)(0));
      if ( cmbLegCuLConsOri.getItemCount() > 0 )
      {
         if ( isIns( ) && (GXutil.strcmp("", A2327LegCuLConsOri)==0) )
         {
            A2327LegCuLConsOri = "manual" ;
         }
      }
      /* ComboBox */
      Gridlevel_consumosRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLegCuLConsOri,cmbLegCuLConsOri.getInternalname(),GXutil.rtrim( A2327LegCuLConsOri),Integer.valueOf(1),cmbLegCuLConsOri.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbLegCuLConsOri.getEnabled()),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","TrnColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
      cmbLegCuLConsOri.setValue( GXutil.rtrim( A2327LegCuLConsOri) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegCuLConsOri.getInternalname(), "Values", cmbLegCuLConsOri.ToJavascriptSource(), !bGXsfl_107_Refreshing);
      httpContext.ajax_sending_grid_row(Gridlevel_consumosRow);
      send_integrity_lvl_hashes6F289( ) ;
      GXCCtl = "Z2310LegCuLConsAnio_" + sGXsfl_107_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2310LegCuLConsAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2311LegCuLConsSec_" + sGXsfl_107_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2311LegCuLConsSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2327LegCuLConsOri_" + sGXsfl_107_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z2327LegCuLConsOri));
      GXCCtl = "Z2312LegCuLConsCnt_" + sGXsfl_107_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2312LegCuLConsCnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2342LegCulConsLiqNro_" + sGXsfl_107_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2342LegCulConsLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_289_" + sGXsfl_107_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_289, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_289_" + sGXsfl_107_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_289, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_289_" + sGXsfl_107_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_289, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_107_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_107_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vEMPCOD_" + sGXsfl_107_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vLEGNUMERO_" + sGXsfl_107_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV9LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vLEGCUENLICTPO_" + sGXsfl_107_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV10LegCuenLicTpo));
      GXCCtl = "vLEGCUENANIO_" + sGXsfl_107_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV11LegCuenAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCULCONSANIO_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLConsAnio_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCULCONSSEC_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLConsSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCULCONSCNT_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLConsCnt_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCULCONSORI_"+sGXsfl_107_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbLegCuLConsOri.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_consumosContainer.AddRow(Gridlevel_consumosRow);
   }

   public void readRow6F289( )
   {
      nGXsfl_107_idx = (int)(nGXsfl_107_idx+1) ;
      sGXsfl_107_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_107_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_107289( ) ;
      edtLegCuLConsAnio_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULCONSANIO_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtLegCuLConsSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULCONSSEC_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtLegCuLConsCnt_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULCONSCNT_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      cmbLegCuLConsOri.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "LEGCULCONSORI_"+sGXsfl_107_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegCuLConsAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegCuLConsAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
      {
         GXCCtl = "LEGCULCONSANIO_" + sGXsfl_107_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegCuLConsAnio_Internalname ;
         wbErr = true ;
         A2310LegCuLConsAnio = (short)(0) ;
      }
      else
      {
         A2310LegCuLConsAnio = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLConsAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      A2311LegCuLConsSec = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLConsSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegCuLConsCnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegCuLConsCnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
      {
         GXCCtl = "LEGCULCONSCNT_" + sGXsfl_107_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegCuLConsCnt_Internalname ;
         wbErr = true ;
         A2312LegCuLConsCnt = (short)(0) ;
      }
      else
      {
         A2312LegCuLConsCnt = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLConsCnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      cmbLegCuLConsOri.setName( cmbLegCuLConsOri.getInternalname() );
      cmbLegCuLConsOri.setValue( httpContext.cgiGet( cmbLegCuLConsOri.getInternalname()) );
      A2327LegCuLConsOri = httpContext.cgiGet( cmbLegCuLConsOri.getInternalname()) ;
      GXCCtl = "Z2310LegCuLConsAnio_" + sGXsfl_107_idx ;
      Z2310LegCuLConsAnio = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2311LegCuLConsSec_" + sGXsfl_107_idx ;
      Z2311LegCuLConsSec = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2327LegCuLConsOri_" + sGXsfl_107_idx ;
      Z2327LegCuLConsOri = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2312LegCuLConsCnt_" + sGXsfl_107_idx ;
      Z2312LegCuLConsCnt = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2342LegCulConsLiqNro_" + sGXsfl_107_idx ;
      Z2342LegCulConsLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      n2342LegCulConsLiqNro = ((0==A2342LegCulConsLiqNro) ? true : false) ;
      GXCCtl = "Z2342LegCulConsLiqNro_" + sGXsfl_107_idx ;
      A2342LegCulConsLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      n2342LegCulConsLiqNro = false ;
      n2342LegCulConsLiqNro = ((0==A2342LegCulConsLiqNro) ? true : false) ;
      GXCCtl = "nRcdDeleted_289_" + sGXsfl_107_idx ;
      nRcdDeleted_289 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_289_" + sGXsfl_107_idx ;
      nRcdExists_289 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_289_" + sGXsfl_107_idx ;
      nIsMod_289 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defcmbLegCuLConsOri_Enabled = cmbLegCuLConsOri.getEnabled() ;
      defedtLegCuLConsSec_Enabled = edtLegCuLConsSec_Enabled ;
      defedtLegCuLConsAnio_Enabled = edtLegCuLConsAnio_Enabled ;
      defcmbLegCuLAprLicOri_Enabled = cmbLegCuLAprLicOri.getEnabled() ;
      defedtLegCuLAprLicFch_Enabled = edtLegCuLAprLicFch_Enabled ;
   }

   public void confirmValues6F0( )
   {
      nGXsfl_93_idx = 0 ;
      sGXsfl_93_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_93_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_93288( ) ;
      while ( nGXsfl_93_idx < nRC_GXsfl_93 )
      {
         nGXsfl_93_idx = (int)(nGXsfl_93_idx+1) ;
         sGXsfl_93_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_93_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_93288( ) ;
         httpContext.changePostValue( "Z2324LegCuLAprLicFch_"+sGXsfl_93_idx, httpContext.cgiGet( "ZT_"+"Z2324LegCuLAprLicFch_"+sGXsfl_93_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2324LegCuLAprLicFch_"+sGXsfl_93_idx) ;
         httpContext.changePostValue( "Z2326LegCuLAprLicOri_"+sGXsfl_93_idx, httpContext.cgiGet( "ZT_"+"Z2326LegCuLAprLicOri_"+sGXsfl_93_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2326LegCuLAprLicOri_"+sGXsfl_93_idx) ;
         httpContext.changePostValue( "Z2325LegCuLAprLicCnt_"+sGXsfl_93_idx, httpContext.cgiGet( "ZT_"+"Z2325LegCuLAprLicCnt_"+sGXsfl_93_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2325LegCuLAprLicCnt_"+sGXsfl_93_idx) ;
         httpContext.changePostValue( "Z2341LegCuLAprLiqNro_"+sGXsfl_93_idx, httpContext.cgiGet( "ZT_"+"Z2341LegCuLAprLiqNro_"+sGXsfl_93_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2341LegCuLAprLiqNro_"+sGXsfl_93_idx) ;
      }
      nGXsfl_107_idx = 0 ;
      sGXsfl_107_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_107_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_107289( ) ;
      while ( nGXsfl_107_idx < nRC_GXsfl_107 )
      {
         nGXsfl_107_idx = (int)(nGXsfl_107_idx+1) ;
         sGXsfl_107_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_107_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_107289( ) ;
         httpContext.changePostValue( "Z2310LegCuLConsAnio_"+sGXsfl_107_idx, httpContext.cgiGet( "ZT_"+"Z2310LegCuLConsAnio_"+sGXsfl_107_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2310LegCuLConsAnio_"+sGXsfl_107_idx) ;
         httpContext.changePostValue( "Z2311LegCuLConsSec_"+sGXsfl_107_idx, httpContext.cgiGet( "ZT_"+"Z2311LegCuLConsSec_"+sGXsfl_107_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2311LegCuLConsSec_"+sGXsfl_107_idx) ;
         httpContext.changePostValue( "Z2327LegCuLConsOri_"+sGXsfl_107_idx, httpContext.cgiGet( "ZT_"+"Z2327LegCuLConsOri_"+sGXsfl_107_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2327LegCuLConsOri_"+sGXsfl_107_idx) ;
         httpContext.changePostValue( "Z2312LegCuLConsCnt_"+sGXsfl_107_idx, httpContext.cgiGet( "ZT_"+"Z2312LegCuLConsCnt_"+sGXsfl_107_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2312LegCuLConsCnt_"+sGXsfl_107_idx) ;
         httpContext.changePostValue( "Z2342LegCulConsLiqNro_"+sGXsfl_107_idx, httpContext.cgiGet( "ZT_"+"Z2342LegCulConsLiqNro_"+sGXsfl_107_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2342LegCulConsLiqNro_"+sGXsfl_107_idx) ;
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.legajo_cuenta_licencias", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(AV10LegCuenLicTpo)),GXutil.URLEncode(GXutil.ltrimstr(AV11LegCuenAnio,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LegNumero","LegCuenLicTpo","LegCuenAnio"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"legajo_cuenta_licencias");
      forbiddenHiddens.add("LegCuenLicPerIni", localUtil.format(A2244LegCuenLicPerIni, "99/99/9999"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("LegCuLActVen", localUtil.format( DecimalUtil.doubleToDec(A2315LegCuLActVen), "ZZZ9"));
      forbiddenHiddens.add("LegCuLTotCons", localUtil.format( DecimalUtil.doubleToDec(A2313LegCuLTotCons), "ZZZZZZZ9"));
      forbiddenHiddens.add("LegCuLTotCorr", localUtil.format( DecimalUtil.doubleToDec(A2314LegCuLTotCorr), "ZZZZZZZ9"));
      forbiddenHiddens.add("LegCuenLicPerFin", localUtil.format(A2245LegCuenLicPerFin, "99/99/9999"));
      forbiddenHiddens.add("LegCuenDiasCorres", localUtil.format( DecimalUtil.doubleToDec(A2247LegCuenDiasCorres), "ZZZ9"));
      forbiddenHiddens.add("LegCuenDiasGoz", localUtil.format( DecimalUtil.doubleToDec(A2248LegCuenDiasGoz), "ZZZ9"));
      forbiddenHiddens.add("LegCuenDiasVig", localUtil.format( DecimalUtil.doubleToDec(A2249LegCuenDiasVig), "ZZZ9"));
      forbiddenHiddens.add("LegCueAntAbr", GXutil.rtrim( localUtil.format( A2328LegCueAntAbr, "")));
      forbiddenHiddens.add("LegCuLiPCur", localUtil.format( DecimalUtil.doubleToDec(A2302LegCuLiPCur), "ZZZ9"));
      forbiddenHiddens.add("LegCuLiPAnt", localUtil.format( DecimalUtil.doubleToDec(A2303LegCuLiPAnt), "ZZZ9"));
      forbiddenHiddens.add("LegCuLiPVen", localUtil.format( DecimalUtil.doubleToDec(A2304LegCuLiPVen), "ZZZ9"));
      forbiddenHiddens.add("LegCuLiPSaldo", localUtil.format( DecimalUtil.doubleToDec(A2305LegCuLiPSaldo), "ZZZ9"));
      forbiddenHiddens.add("LegCuLiPApr", localUtil.format( DecimalUtil.doubleToDec(A2306LegCuLiPApr), "ZZZ9"));
      forbiddenHiddens.add("LegCuLiAprPGoce", localUtil.format( DecimalUtil.doubleToDec(A2307LegCuLiAprPGoce), "ZZZ9"));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("legajo_cuenta_licencias:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2243LegCuenLicTpo", GXutil.rtrim( Z2243LegCuenLicTpo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2266LegCuenAnio", GXutil.ltrim( localUtil.ntoc( Z2266LegCuenAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2315LegCuLActVen", GXutil.ltrim( localUtil.ntoc( Z2315LegCuLActVen, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2313LegCuLTotCons", GXutil.ltrim( localUtil.ntoc( Z2313LegCuLTotCons, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2314LegCuLTotCorr", GXutil.ltrim( localUtil.ntoc( Z2314LegCuLTotCorr, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2244LegCuenLicPerIni", localUtil.dtoc( Z2244LegCuenLicPerIni, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2245LegCuenLicPerFin", localUtil.dtoc( Z2245LegCuenLicPerFin, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2246LegCuenAntDias", GXutil.ltrim( localUtil.ntoc( Z2246LegCuenAntDias, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2299LegCuenAntAnios", GXutil.ltrim( localUtil.ntoc( Z2299LegCuenAntAnios, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2300LegCuenAntMeses", GXutil.ltrim( localUtil.ntoc( Z2300LegCuenAntMeses, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2247LegCuenDiasCorres", GXutil.ltrim( localUtil.ntoc( Z2247LegCuenDiasCorres, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2248LegCuenDiasGoz", GXutil.ltrim( localUtil.ntoc( Z2248LegCuenDiasGoz, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2249LegCuenDiasVig", GXutil.ltrim( localUtil.ntoc( Z2249LegCuenDiasVig, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2328LegCueAntAbr", Z2328LegCueAntAbr);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2302LegCuLiPCur", GXutil.ltrim( localUtil.ntoc( Z2302LegCuLiPCur, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2303LegCuLiPAnt", GXutil.ltrim( localUtil.ntoc( Z2303LegCuLiPAnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2304LegCuLiPVen", GXutil.ltrim( localUtil.ntoc( Z2304LegCuLiPVen, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2305LegCuLiPSaldo", GXutil.ltrim( localUtil.ntoc( Z2305LegCuLiPSaldo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2306LegCuLiPApr", GXutil.ltrim( localUtil.ntoc( Z2306LegCuLiPApr, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2307LegCuLiAprPGoce", GXutil.ltrim( localUtil.ntoc( Z2307LegCuLiAprPGoce, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2321LegCuLIncluir", Z2321LegCuLIncluir);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2322LegCuLRecalc", Z2322LegCuLRecalc);
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_93", GXutil.ltrim( localUtil.ntoc( nGXsfl_93_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_107", GXutil.ltrim( localUtil.ntoc( nGXsfl_107_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV9LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGCUENLICTPO", GXutil.rtrim( AV10LegCuenLicTpo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGCUENLICTPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10LegCuenLicTpo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGCUENANIO", GXutil.ltrim( localUtil.ntoc( AV11LegCuenAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGCUENANIO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11LegCuenAnio), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCULTOTCONS", GXutil.ltrim( localUtil.ntoc( A2313LegCuLTotCons, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCULTOTCORR", GXutil.ltrim( localUtil.ntoc( A2314LegCuLTotCorr, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCUENDIASVIG", GXutil.ltrim( localUtil.ntoc( A2249LegCuenDiasVig, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCUEANTABR", A2328LegCueAntAbr);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCULIAPRPGOCE", GXutil.ltrim( localUtil.ntoc( A2307LegCuLiAprPGoce, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCULLOGDIS", A2329LegCuLLogDis);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNOMBRE", A251LegNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGAPELLIDO", A230LegApellido);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGID", GXutil.rtrim( A93LegId));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV20Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCULAPRLIQNRO", GXutil.ltrim( localUtil.ntoc( A2341LegCuLAprLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCULCONSLIQNRO", GXutil.ltrim( localUtil.ntoc( A2342LegCulConsLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Objectcall", GXutil.rtrim( Dvpanel_unnamedtable1_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Enabled", GXutil.booltostr( Dvpanel_unnamedtable1_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Width", GXutil.rtrim( Dvpanel_unnamedtable1_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable1_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable1_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Cls", GXutil.rtrim( Dvpanel_unnamedtable1_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Title", GXutil.rtrim( Dvpanel_unnamedtable1_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable1_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable1_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable1_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Objectcall", GXutil.rtrim( Dvpanel_unnamedtable2_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Enabled", GXutil.booltostr( Dvpanel_unnamedtable2_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Width", GXutil.rtrim( Dvpanel_unnamedtable2_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable2_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable2_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Cls", GXutil.rtrim( Dvpanel_unnamedtable2_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Title", GXutil.rtrim( Dvpanel_unnamedtable2_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable2_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable2_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable2_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable2_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable2_Autoscroll));
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
      return formatLink("web.legajo_cuenta_licencias", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(AV10LegCuenLicTpo)),GXutil.URLEncode(GXutil.ltrimstr(AV11LegCuenAnio,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LegNumero","LegCuenLicTpo","LegCuenAnio"})  ;
   }

   public String getPgmname( )
   {
      return "legajo_cuenta_licencias" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "legajo_cuenta_licencias", "") ;
   }

   public void initializeNonKey6F285( )
   {
      A250LegIdNomApe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A250LegIdNomApe", A250LegIdNomApe);
      A2315LegCuLActVen = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2315LegCuLActVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2315LegCuLActVen), 4, 0));
      A2313LegCuLTotCons = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2313LegCuLTotCons", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2313LegCuLTotCons), 8, 0));
      A2314LegCuLTotCorr = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2314LegCuLTotCorr", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2314LegCuLTotCorr), 8, 0));
      A2244LegCuenLicPerIni = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A2244LegCuenLicPerIni", localUtil.format(A2244LegCuenLicPerIni, "99/99/9999"));
      A2245LegCuenLicPerFin = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A2245LegCuenLicPerFin", localUtil.format(A2245LegCuenLicPerFin, "99/99/9999"));
      A2246LegCuenAntDias = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2246LegCuenAntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2246LegCuenAntDias), 8, 0));
      A2299LegCuenAntAnios = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2299LegCuenAntAnios", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2299LegCuenAntAnios), 4, 0));
      A2300LegCuenAntMeses = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2300LegCuenAntMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2300LegCuenAntMeses), 4, 0));
      A2247LegCuenDiasCorres = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2247LegCuenDiasCorres", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2247LegCuenDiasCorres), 4, 0));
      A2248LegCuenDiasGoz = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2248LegCuenDiasGoz", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2248LegCuenDiasGoz), 4, 0));
      A2249LegCuenDiasVig = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2249LegCuenDiasVig", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2249LegCuenDiasVig), 4, 0));
      A2301LegCueAntTexto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2301LegCueAntTexto", A2301LegCueAntTexto);
      A2328LegCueAntAbr = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2328LegCueAntAbr", A2328LegCueAntAbr);
      A2302LegCuLiPCur = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2302LegCuLiPCur", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2302LegCuLiPCur), 4, 0));
      A2303LegCuLiPAnt = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2303LegCuLiPAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2303LegCuLiPAnt), 4, 0));
      A2304LegCuLiPVen = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2304LegCuLiPVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2304LegCuLiPVen), 4, 0));
      A2305LegCuLiPSaldo = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2305LegCuLiPSaldo", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2305LegCuLiPSaldo), 4, 0));
      A2306LegCuLiPApr = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2306LegCuLiPApr", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2306LegCuLiPApr), 4, 0));
      A2307LegCuLiAprPGoce = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2307LegCuLiAprPGoce", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2307LegCuLiAprPGoce), 4, 0));
      A2321LegCuLIncluir = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2321LegCuLIncluir", A2321LegCuLIncluir);
      A2322LegCuLRecalc = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2322LegCuLRecalc", A2322LegCuLRecalc);
      A2329LegCuLLogDis = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2329LegCuLLogDis", A2329LegCuLLogDis);
      A251LegNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A251LegNombre", A251LegNombre);
      A230LegApellido = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A230LegApellido", A230LegApellido);
      A93LegId = "" ;
      n93LegId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A93LegId", A93LegId);
      Z2315LegCuLActVen = (short)(0) ;
      Z2313LegCuLTotCons = 0 ;
      Z2314LegCuLTotCorr = 0 ;
      Z2244LegCuenLicPerIni = GXutil.nullDate() ;
      Z2245LegCuenLicPerFin = GXutil.nullDate() ;
      Z2246LegCuenAntDias = 0 ;
      Z2299LegCuenAntAnios = (short)(0) ;
      Z2300LegCuenAntMeses = (short)(0) ;
      Z2247LegCuenDiasCorres = (short)(0) ;
      Z2248LegCuenDiasGoz = (short)(0) ;
      Z2249LegCuenDiasVig = (short)(0) ;
      Z2328LegCueAntAbr = "" ;
      Z2302LegCuLiPCur = (short)(0) ;
      Z2303LegCuLiPAnt = (short)(0) ;
      Z2304LegCuLiPVen = (short)(0) ;
      Z2305LegCuLiPSaldo = (short)(0) ;
      Z2306LegCuLiPApr = (short)(0) ;
      Z2307LegCuLiAprPGoce = (short)(0) ;
      Z2321LegCuLIncluir = false ;
      Z2322LegCuLRecalc = false ;
   }

   public void initAll6F285( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A6LegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      A2243LegCuenLicTpo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
      A2266LegCuenAnio = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2266LegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2266LegCuenAnio), 4, 0));
      initializeNonKey6F285( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey6F288( )
   {
      A2325LegCuLAprLicCnt = (short)(0) ;
      A2341LegCuLAprLiqNro = 0 ;
      n2341LegCuLAprLiqNro = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2341LegCuLAprLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2341LegCuLAprLiqNro), 8, 0));
      A2326LegCuLAprLicOri = "manual" ;
      Z2326LegCuLAprLicOri = "" ;
      Z2325LegCuLAprLicCnt = (short)(0) ;
      Z2341LegCuLAprLiqNro = 0 ;
   }

   public void initAll6F288( )
   {
      A2324LegCuLAprLicFch = GXutil.nullDate() ;
      initializeNonKey6F288( ) ;
   }

   public void standaloneModalInsert6F288( )
   {
      A2326LegCuLAprLicOri = i2326LegCuLAprLicOri ;
   }

   public void initializeNonKey6F289( )
   {
      A2312LegCuLConsCnt = (short)(0) ;
      A2342LegCulConsLiqNro = 0 ;
      n2342LegCulConsLiqNro = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2342LegCulConsLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2342LegCulConsLiqNro), 8, 0));
      A2327LegCuLConsOri = "manual" ;
      Z2327LegCuLConsOri = "" ;
      Z2312LegCuLConsCnt = (short)(0) ;
      Z2342LegCulConsLiqNro = 0 ;
   }

   public void initAll6F289( )
   {
      A2310LegCuLConsAnio = (short)(0) ;
      A2311LegCuLConsSec = (short)(0) ;
      initializeNonKey6F289( ) ;
   }

   public void standaloneModalInsert6F289( )
   {
      A2327LegCuLConsOri = i2327LegCuLConsOri ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713491662", true, true);
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
      httpContext.AddJavascriptSource("legajo_cuenta_licencias.js", "?20251713491662", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties288( )
   {
      cmbLegCuLAprLicOri.setEnabled( defcmbLegCuLAprLicOri_Enabled );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegCuLAprLicOri.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegCuLAprLicOri.getEnabled(), 5, 0), !bGXsfl_93_Refreshing);
      edtLegCuLAprLicFch_Enabled = defedtLegCuLAprLicFch_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLAprLicFch_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLAprLicFch_Enabled), 5, 0), !bGXsfl_93_Refreshing);
   }

   public void init_level_properties289( )
   {
      cmbLegCuLConsOri.setEnabled( defcmbLegCuLConsOri_Enabled );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegCuLConsOri.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLegCuLConsOri.getEnabled(), 5, 0), !bGXsfl_107_Refreshing);
      edtLegCuLConsSec_Enabled = defedtLegCuLConsSec_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLConsSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLConsSec_Enabled), 5, 0), !bGXsfl_107_Refreshing);
      edtLegCuLConsAnio_Enabled = defedtLegCuLConsAnio_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLConsAnio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLConsAnio_Enabled), 5, 0), !bGXsfl_107_Refreshing);
   }

   public void startgridcontrol93( )
   {
      Gridlevel_aprobacionesContainer.AddObjectProperty("GridName", "Gridlevel_aprobaciones");
      Gridlevel_aprobacionesContainer.AddObjectProperty("Header", subGridlevel_aprobaciones_Header);
      Gridlevel_aprobacionesContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_aprobacionesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_aprobacionesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_aprobacionesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_aprobaciones_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_aprobacionesContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_aprobacionesContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_aprobacionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_aprobacionesColumn.AddObjectProperty("Value", localUtil.format(A2324LegCuLAprLicFch, "99/99/99"));
      Gridlevel_aprobacionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLAprLicFch_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_aprobacionesContainer.AddColumnProperties(Gridlevel_aprobacionesColumn);
      Gridlevel_aprobacionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_aprobacionesColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2325LegCuLAprLicCnt, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_aprobacionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLAprLicCnt_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_aprobacionesContainer.AddColumnProperties(Gridlevel_aprobacionesColumn);
      Gridlevel_aprobacionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_aprobacionesColumn.AddObjectProperty("Value", GXutil.rtrim( A2326LegCuLAprLicOri));
      Gridlevel_aprobacionesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbLegCuLAprLicOri.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel_aprobacionesContainer.AddColumnProperties(Gridlevel_aprobacionesColumn);
      Gridlevel_aprobacionesContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_aprobaciones_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_aprobacionesContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_aprobaciones_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_aprobacionesContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_aprobaciones_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_aprobacionesContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_aprobaciones_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_aprobacionesContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_aprobaciones_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_aprobacionesContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_aprobaciones_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_aprobacionesContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_aprobaciones_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void startgridcontrol107( )
   {
      Gridlevel_consumosContainer.AddObjectProperty("GridName", "Gridlevel_consumos");
      Gridlevel_consumosContainer.AddObjectProperty("Header", subGridlevel_consumos_Header);
      Gridlevel_consumosContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_consumosContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_consumosContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_consumosContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_consumos_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_consumosContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_consumosContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_consumosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_consumosColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2310LegCuLConsAnio, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_consumosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLConsAnio_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_consumosContainer.AddColumnProperties(Gridlevel_consumosColumn);
      Gridlevel_consumosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_consumosColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2311LegCuLConsSec, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_consumosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLConsSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_consumosContainer.AddColumnProperties(Gridlevel_consumosColumn);
      Gridlevel_consumosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_consumosColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2312LegCuLConsCnt, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_consumosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtLegCuLConsCnt_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_consumosContainer.AddColumnProperties(Gridlevel_consumosColumn);
      Gridlevel_consumosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_consumosColumn.AddObjectProperty("Value", GXutil.rtrim( A2327LegCuLConsOri));
      Gridlevel_consumosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbLegCuLConsOri.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel_consumosContainer.AddColumnProperties(Gridlevel_consumosColumn);
      Gridlevel_consumosContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_consumos_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_consumosContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_consumos_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_consumosContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_consumos_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_consumosContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_consumos_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_consumosContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_consumos_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_consumosContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_consumos_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_consumosContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_consumos_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      edtLegIdNomApe_Internalname = "LEGIDNOMAPE" ;
      edtLegCuenAnio_Internalname = "LEGCUENANIO" ;
      edtLegCuenLicPerIni_Internalname = "LEGCUENLICPERINI" ;
      edtLegCuenLicPerFin_Internalname = "LEGCUENLICPERFIN" ;
      chkLegCuLIncluir.setInternalname( "LEGCULINCLUIR" );
      edtLegCuenDiasCorres_Internalname = "LEGCUENDIASCORRES" ;
      edtLegCuLiPAnt_Internalname = "LEGCULIPANT" ;
      edtLegCuLiPVen_Internalname = "LEGCULIPVEN" ;
      edtLegCuLiPCur_Internalname = "LEGCULIPCUR" ;
      edtLegCuLActVen_Internalname = "LEGCULACTVEN" ;
      edtLegCuLiPApr_Internalname = "LEGCULIPAPR" ;
      edtLegCuenDiasGoz_Internalname = "LEGCUENDIASGOZ" ;
      edtLegCuLiPSaldo_Internalname = "LEGCULIPSALDO" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      edtLegCuLAprLicFch_Internalname = "LEGCULAPRLICFCH" ;
      edtLegCuLAprLicCnt_Internalname = "LEGCULAPRLICCNT" ;
      cmbLegCuLAprLicOri.setInternalname( "LEGCULAPRLICORI" );
      divTableleaflevel_aprobaciones_Internalname = "TABLELEAFLEVEL_APROBACIONES" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      Dvpanel_unnamedtable1_Internalname = "DVPANEL_UNNAMEDTABLE1" ;
      edtLegCuLConsAnio_Internalname = "LEGCULCONSANIO" ;
      edtLegCuLConsSec_Internalname = "LEGCULCONSSEC" ;
      edtLegCuLConsCnt_Internalname = "LEGCULCONSCNT" ;
      cmbLegCuLConsOri.setInternalname( "LEGCULCONSORI" );
      divTableleaflevel_consumos_Internalname = "TABLELEAFLEVEL_CONSUMOS" ;
      divUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      Dvpanel_unnamedtable2_Internalname = "DVPANEL_UNNAMEDTABLE2" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtLegNumero_Internalname = "LEGNUMERO" ;
      cmbLegCuenLicTpo.setInternalname( "LEGCUENLICTPO" );
      edtLegCuLRecalc_Internalname = "LEGCULRECALC" ;
      edtLegCuenAntDias_Internalname = "LEGCUENANTDIAS" ;
      edtLegCuenAntAnios_Internalname = "LEGCUENANTANIOS" ;
      edtLegCuenAntMeses_Internalname = "LEGCUENANTMESES" ;
      edtLegCueAntTexto_Internalname = "LEGCUEANTTEXTO" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel_aprobaciones_Internalname = "GRIDLEVEL_APROBACIONES" ;
      subGridlevel_consumos_Internalname = "GRIDLEVEL_CONSUMOS" ;
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
      subGridlevel_consumos_Allowcollapsing = (byte)(0) ;
      subGridlevel_consumos_Allowselection = (byte)(0) ;
      subGridlevel_consumos_Header = "" ;
      subGridlevel_aprobaciones_Allowcollapsing = (byte)(0) ;
      subGridlevel_aprobaciones_Allowselection = (byte)(0) ;
      subGridlevel_aprobaciones_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "legajo_cuenta_licencias", "") );
      cmbLegCuLConsOri.setJsonclick( "" );
      edtLegCuLConsCnt_Jsonclick = "" ;
      edtLegCuLConsSec_Jsonclick = "" ;
      edtLegCuLConsAnio_Jsonclick = "" ;
      subGridlevel_consumos_Class = "WorkWith" ;
      subGridlevel_consumos_Backcolorstyle = (byte)(0) ;
      cmbLegCuLAprLicOri.setJsonclick( "" );
      edtLegCuLAprLicCnt_Jsonclick = "" ;
      edtLegCuLAprLicFch_Jsonclick = "" ;
      subGridlevel_aprobaciones_Class = "WorkWith" ;
      subGridlevel_aprobaciones_Backcolorstyle = (byte)(0) ;
      edtLegCueAntTexto_Enabled = 1 ;
      edtLegCueAntTexto_Visible = 1 ;
      edtLegCuenAntMeses_Jsonclick = "" ;
      edtLegCuenAntMeses_Enabled = 1 ;
      edtLegCuenAntMeses_Visible = 1 ;
      edtLegCuenAntAnios_Jsonclick = "" ;
      edtLegCuenAntAnios_Enabled = 1 ;
      edtLegCuenAntAnios_Visible = 1 ;
      edtLegCuenAntDias_Jsonclick = "" ;
      edtLegCuenAntDias_Enabled = 1 ;
      edtLegCuenAntDias_Visible = 1 ;
      edtLegCuLRecalc_Jsonclick = "" ;
      edtLegCuLRecalc_Enabled = 1 ;
      edtLegCuLRecalc_Visible = 1 ;
      cmbLegCuenLicTpo.setJsonclick( "" );
      cmbLegCuenLicTpo.setVisible( 1 );
      cmbLegCuenLicTpo.setEnabled( 1 );
      edtLegNumero_Jsonclick = "" ;
      edtLegNumero_Enabled = 1 ;
      edtLegNumero_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbLegCuLConsOri.setEnabled( 0 );
      edtLegCuLConsCnt_Enabled = 1 ;
      edtLegCuLConsSec_Enabled = 0 ;
      edtLegCuLConsAnio_Enabled = 1 ;
      Dvpanel_unnamedtable2_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Iconposition = "Right" ;
      Dvpanel_unnamedtable2_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable2_Title = httpContext.getMessage( "Consumos", "") ;
      Dvpanel_unnamedtable2_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_unnamedtable2_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable2_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Width = "100%" ;
      cmbLegCuLAprLicOri.setEnabled( 0 );
      edtLegCuLAprLicCnt_Enabled = 1 ;
      edtLegCuLAprLicFch_Enabled = 1 ;
      Dvpanel_unnamedtable1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Iconposition = "Right" ;
      Dvpanel_unnamedtable1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Title = httpContext.getMessage( "Aprobadas", "") ;
      Dvpanel_unnamedtable1_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_unnamedtable1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Width = "100%" ;
      edtLegCuLiPSaldo_Jsonclick = "" ;
      edtLegCuLiPSaldo_Enabled = 0 ;
      edtLegCuenDiasGoz_Jsonclick = "" ;
      edtLegCuenDiasGoz_Enabled = 0 ;
      edtLegCuLiPApr_Jsonclick = "" ;
      edtLegCuLiPApr_Enabled = 0 ;
      edtLegCuLActVen_Jsonclick = "" ;
      edtLegCuLActVen_Enabled = 0 ;
      edtLegCuLiPCur_Jsonclick = "" ;
      edtLegCuLiPCur_Enabled = 0 ;
      edtLegCuLiPVen_Jsonclick = "" ;
      edtLegCuLiPVen_Enabled = 0 ;
      edtLegCuLiPAnt_Jsonclick = "" ;
      edtLegCuLiPAnt_Enabled = 0 ;
      edtLegCuenDiasCorres_Jsonclick = "" ;
      edtLegCuenDiasCorres_Enabled = 0 ;
      chkLegCuLIncluir.setEnabled( 1 );
      edtLegCuenLicPerFin_Jsonclick = "" ;
      edtLegCuenLicPerFin_Enabled = 0 ;
      edtLegCuenLicPerIni_Jsonclick = "" ;
      edtLegCuenLicPerIni_Enabled = 0 ;
      edtLegCuenAnio_Jsonclick = "" ;
      edtLegCuenAnio_Enabled = 1 ;
      edtLegIdNomApe_Jsonclick = "" ;
      edtLegIdNomApe_Enabled = 0 ;
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

   public void gx12asaclicod6F285( int AV7CliCod )
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
            legajo_cuenta_licencias_impl.this.GXt_int4 = GXv_int5[0] ;
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

   public void gxnrgridlevel_aprobaciones_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_93288( ) ;
      while ( nGXsfl_93_idx <= nRC_GXsfl_93 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal6F288( ) ;
         standaloneModal6F288( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow6F288( ) ;
         nGXsfl_93_idx = (int)(nGXsfl_93_idx+1) ;
         sGXsfl_93_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_93_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_93288( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_aprobacionesContainer)) ;
      /* End function gxnrGridlevel_aprobaciones_newrow */
   }

   public void gxnrgridlevel_consumos_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_107289( ) ;
      while ( nGXsfl_107_idx <= nRC_GXsfl_107 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal6F289( ) ;
         standaloneModal6F289( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow6F289( ) ;
         nGXsfl_107_idx = (int)(nGXsfl_107_idx+1) ;
         sGXsfl_107_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_107_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_107289( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_consumosContainer)) ;
      /* End function gxnrGridlevel_consumos_newrow */
   }

   public void init_web_controls( )
   {
      chkLegCuLIncluir.setName( "LEGCULINCLUIR" );
      chkLegCuLIncluir.setWebtags( "" );
      chkLegCuLIncluir.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkLegCuLIncluir.getInternalname(), "TitleCaption", chkLegCuLIncluir.getCaption(), true);
      chkLegCuLIncluir.setCheckedValue( "false" );
      A2321LegCuLIncluir = GXutil.strtobool( GXutil.booltostr( A2321LegCuLIncluir)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2321LegCuLIncluir", A2321LegCuLIncluir);
      GXCCtl = "LEGCULAPRLICORI_" + sGXsfl_93_idx ;
      cmbLegCuLAprLicOri.setName( GXCCtl );
      cmbLegCuLAprLicOri.setWebtags( "" );
      cmbLegCuLAprLicOri.addItem("licencias", httpContext.getMessage( "Licencias aprobadas", ""), (short)(0));
      cmbLegCuLAprLicOri.addItem("importacion", httpContext.getMessage( "Importación de LSD", ""), (short)(0));
      cmbLegCuLAprLicOri.addItem("manual", httpContext.getMessage( "Manual", ""), (short)(0));
      cmbLegCuLAprLicOri.addItem("inicializacion", httpContext.getMessage( "Inicialización automática", ""), (short)(0));
      cmbLegCuLAprLicOri.addItem("final", httpContext.getMessage( "Liquidación final", ""), (short)(0));
      if ( cmbLegCuLAprLicOri.getItemCount() > 0 )
      {
         if ( isIns( ) && (GXutil.strcmp("", A2326LegCuLAprLicOri)==0) )
         {
            A2326LegCuLAprLicOri = "manual" ;
         }
      }
      GXCCtl = "LEGCULCONSORI_" + sGXsfl_107_idx ;
      cmbLegCuLConsOri.setName( GXCCtl );
      cmbLegCuLConsOri.setWebtags( "" );
      cmbLegCuLConsOri.addItem("licencias", httpContext.getMessage( "Licencias aprobadas", ""), (short)(0));
      cmbLegCuLConsOri.addItem("importacion", httpContext.getMessage( "Importación de LSD", ""), (short)(0));
      cmbLegCuLConsOri.addItem("manual", httpContext.getMessage( "Manual", ""), (short)(0));
      cmbLegCuLConsOri.addItem("inicializacion", httpContext.getMessage( "Inicialización automática", ""), (short)(0));
      cmbLegCuLConsOri.addItem("final", httpContext.getMessage( "Liquidación final", ""), (short)(0));
      if ( cmbLegCuLConsOri.getItemCount() > 0 )
      {
         if ( isIns( ) && (GXutil.strcmp("", A2327LegCuLConsOri)==0) )
         {
            A2327LegCuLConsOri = "manual" ;
         }
      }
      cmbLegCuenLicTpo.setName( "LEGCUENLICTPO" );
      cmbLegCuenLicTpo.setWebtags( "" );
      cmbLegCuenLicTpo.addItem("Vacaciones", httpContext.getMessage( "Vacaciones", ""), (short)(0));
      if ( cmbLegCuenLicTpo.getItemCount() > 0 )
      {
         A2243LegCuenLicTpo = cmbLegCuenLicTpo.getValidValue(A2243LegCuenLicTpo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2243LegCuenLicTpo", A2243LegCuenLicTpo);
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

   public void valid_Legnumero( )
   {
      n93LegId = false ;
      /* Using cursor T006F21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A250LegIdNomApe = T006F21_A250LegIdNomApe[0] ;
      A251LegNombre = T006F21_A251LegNombre[0] ;
      A251LegNombre = T006F21_A251LegNombre[0] ;
      A230LegApellido = T006F21_A230LegApellido[0] ;
      A230LegApellido = T006F21_A230LegApellido[0] ;
      A93LegId = T006F21_A93LegId[0] ;
      n93LegId = T006F21_n93LegId[0] ;
      A93LegId = T006F21_A93LegId[0] ;
      n93LegId = T006F21_n93LegId[0] ;
      pr_default.close(19);
      dynload_actions( ) ;
      if ( cmbLegCuenLicTpo.getItemCount() > 0 )
      {
         A2243LegCuenLicTpo = cmbLegCuenLicTpo.getValidValue(A2243LegCuenLicTpo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbLegCuenLicTpo.setValue( GXutil.rtrim( A2243LegCuenLicTpo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A250LegIdNomApe", A250LegIdNomApe);
      httpContext.ajax_rsp_assign_attri("", false, "A251LegNombre", A251LegNombre);
      httpContext.ajax_rsp_assign_attri("", false, "A230LegApellido", A230LegApellido);
      httpContext.ajax_rsp_assign_attri("", false, "A93LegId", GXutil.rtrim( A93LegId));
   }

   public void valid_Legculaprlicori( )
   {
      A2326LegCuLAprLicOri = cmbLegCuLAprLicOri.getValue() ;
      if ( isDlt( )  && true /* Level */ && ( GXutil.strcmp(A2326LegCuLAprLicOri, "manual") != 0 ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "No se pueden eliminar registros automáticos", ""), 1, "LEGCULAPRLICORI");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbLegCuLAprLicOri.getInternalname() ;
      }
      dynload_actions( ) ;
      if ( cmbLegCuenLicTpo.getItemCount() > 0 )
      {
         A2243LegCuenLicTpo = cmbLegCuenLicTpo.getValidValue(A2243LegCuenLicTpo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbLegCuenLicTpo.setValue( GXutil.rtrim( A2243LegCuenLicTpo) );
      }
      /*  Sending validation outputs */
   }

   public void valid_Legculconsori( )
   {
      A2327LegCuLConsOri = cmbLegCuLConsOri.getValue() ;
      if ( isDlt( )  && true /* Level */ && ( GXutil.strcmp(A2327LegCuLConsOri, "manual") != 0 ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "No se pueden eliminar registros automáticos", ""), 1, "LEGCULCONSORI");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbLegCuLConsOri.getInternalname() ;
      }
      dynload_actions( ) ;
      if ( cmbLegCuenLicTpo.getItemCount() > 0 )
      {
         A2243LegCuenLicTpo = cmbLegCuenLicTpo.getValidValue(A2243LegCuenLicTpo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbLegCuenLicTpo.setValue( GXutil.rtrim( A2243LegCuenLicTpo) );
      }
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV10LegCuenLicTpo',fld:'vLEGCUENLICTPO',pic:'',hsh:true},{av:'AV11LegCuenAnio',fld:'vLEGCUENANIO',pic:'ZZZ9',hsh:true},{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV10LegCuenLicTpo',fld:'vLEGCUENLICTPO',pic:'',hsh:true},{av:'AV11LegCuenAnio',fld:'vLEGCUENANIO',pic:'ZZZ9',hsh:true},{av:'A2244LegCuenLicPerIni',fld:'LEGCUENLICPERINI',pic:''},{av:'A2315LegCuLActVen',fld:'LEGCULACTVEN',pic:'ZZZ9'},{av:'A2313LegCuLTotCons',fld:'LEGCULTOTCONS',pic:'ZZZZZZZ9'},{av:'A2314LegCuLTotCorr',fld:'LEGCULTOTCORR',pic:'ZZZZZZZ9'},{av:'A2245LegCuenLicPerFin',fld:'LEGCUENLICPERFIN',pic:''},{av:'A2247LegCuenDiasCorres',fld:'LEGCUENDIASCORRES',pic:'ZZZ9'},{av:'A2248LegCuenDiasGoz',fld:'LEGCUENDIASGOZ',pic:'ZZZ9'},{av:'A2249LegCuenDiasVig',fld:'LEGCUENDIASVIG',pic:'ZZZ9'},{av:'A2328LegCueAntAbr',fld:'LEGCUEANTABR',pic:''},{av:'A2302LegCuLiPCur',fld:'LEGCULIPCUR',pic:'ZZZ9'},{av:'A2303LegCuLiPAnt',fld:'LEGCULIPANT',pic:'ZZZ9'},{av:'A2304LegCuLiPVen',fld:'LEGCULIPVEN',pic:'ZZZ9'},{av:'A2305LegCuLiPSaldo',fld:'LEGCULIPSALDO',pic:'ZZZ9'},{av:'A2306LegCuLiPApr',fld:'LEGCULIPAPR',pic:'ZZZ9'},{av:'A2307LegCuLiAprPGoce',fld:'LEGCULIAPRPGOCE',pic:'ZZZ9'},{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e126F2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'cmbLegCuenLicTpo'},{av:'A2243LegCuenLicTpo',fld:'LEGCUENLICTPO',pic:''},{av:'A2266LegCuenAnio',fld:'LEGCUENANIO',pic:'ZZZ9'},{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]}");
      setEventMetadata("VALID_LEGCUENANIO","{handler:'valid_Legcuenanio',iparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]");
      setEventMetadata("VALID_LEGCUENANIO",",oparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]}");
      setEventMetadata("VALID_LEGCULINCLUIR","{handler:'valid_Legculincluir',iparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]");
      setEventMetadata("VALID_LEGCULINCLUIR",",oparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A251LegNombre',fld:'LEGNOMBRE',pic:''},{av:'A230LegApellido',fld:'LEGAPELLIDO',pic:''},{av:'A93LegId',fld:'LEGID',pic:''},{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A251LegNombre',fld:'LEGNOMBRE',pic:''},{av:'A230LegApellido',fld:'LEGAPELLIDO',pic:''},{av:'A93LegId',fld:'LEGID',pic:''},{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]}");
      setEventMetadata("VALID_LEGCUENLICTPO","{handler:'valid_Legcuenlictpo',iparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]");
      setEventMetadata("VALID_LEGCUENLICTPO",",oparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]}");
      setEventMetadata("VALID_LEGCULRECALC","{handler:'valid_Legculrecalc',iparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]");
      setEventMetadata("VALID_LEGCULRECALC",",oparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]}");
      setEventMetadata("VALID_LEGCULAPRLICFCH","{handler:'valid_Legculaprlicfch',iparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]");
      setEventMetadata("VALID_LEGCULAPRLICFCH",",oparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]}");
      setEventMetadata("VALID_LEGCULAPRLICORI","{handler:'valid_Legculaprlicori',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'cmbLegCuLAprLicOri'},{av:'A2326LegCuLAprLicOri',fld:'LEGCULAPRLICORI',pic:''},{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]");
      setEventMetadata("VALID_LEGCULAPRLICORI",",oparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]}");
      setEventMetadata("VALID_LEGCULCONSANIO","{handler:'valid_Legculconsanio',iparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]");
      setEventMetadata("VALID_LEGCULCONSANIO",",oparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]}");
      setEventMetadata("VALID_LEGCULCONSSEC","{handler:'valid_Legculconssec',iparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]");
      setEventMetadata("VALID_LEGCULCONSSEC",",oparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]}");
      setEventMetadata("VALID_LEGCULCONSORI","{handler:'valid_Legculconsori',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'cmbLegCuLConsOri'},{av:'A2327LegCuLConsOri',fld:'LEGCULCONSORI',pic:''},{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]");
      setEventMetadata("VALID_LEGCULCONSORI",",oparms:[{av:'A2321LegCuLIncluir',fld:'LEGCULINCLUIR',pic:''}]}");
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
      pr_default.close(19);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV10LegCuenLicTpo = "" ;
      Z2243LegCuenLicTpo = "" ;
      Z2244LegCuenLicPerIni = GXutil.nullDate() ;
      Z2245LegCuenLicPerFin = GXutil.nullDate() ;
      Z2328LegCueAntAbr = "" ;
      Z2324LegCuLAprLicFch = GXutil.nullDate() ;
      Z2326LegCuLAprLicOri = "" ;
      Z2327LegCuLConsOri = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV10LegCuenLicTpo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A2243LegCuenLicTpo = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      A250LegIdNomApe = "" ;
      TempTags = "" ;
      A2244LegCuenLicPerIni = GXutil.nullDate() ;
      A2245LegCuenLicPerFin = GXutil.nullDate() ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_unnamedtable1 = new com.genexus.webpanels.GXUserControl();
      Gridlevel_aprobacionesContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode288 = "" ;
      ucDvpanel_unnamedtable2 = new com.genexus.webpanels.GXUserControl();
      Gridlevel_consumosContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode289 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A2301LegCueAntTexto = "" ;
      A2328LegCueAntAbr = "" ;
      A2329LegCuLLogDis = "" ;
      A251LegNombre = "" ;
      A230LegApellido = "" ;
      A93LegId = "" ;
      AV20Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      Dvpanel_unnamedtable1_Objectcall = "" ;
      Dvpanel_unnamedtable1_Class = "" ;
      Dvpanel_unnamedtable1_Height = "" ;
      Dvpanel_unnamedtable2_Objectcall = "" ;
      Dvpanel_unnamedtable2_Class = "" ;
      Dvpanel_unnamedtable2_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode285 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A2327LegCuLConsOri = "" ;
      A2324LegCuLAprLicFch = GXutil.nullDate() ;
      A2326LegCuLAprLicOri = "" ;
      AV12WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV15TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV16WebSession = httpContext.getWebSession();
      AV18hoy = GXutil.nullDate() ;
      Z2301LegCueAntTexto = "" ;
      Z2329LegCuLLogDis = "" ;
      Z250LegIdNomApe = "" ;
      Z251LegNombre = "" ;
      Z230LegApellido = "" ;
      Z93LegId = "" ;
      T006F12_A250LegIdNomApe = new String[] {""} ;
      T006F12_A251LegNombre = new String[] {""} ;
      T006F12_A230LegApellido = new String[] {""} ;
      T006F12_A93LegId = new String[] {""} ;
      T006F12_n93LegId = new boolean[] {false} ;
      T006F13_A250LegIdNomApe = new String[] {""} ;
      T006F13_A2243LegCuenLicTpo = new String[] {""} ;
      T006F13_A2266LegCuenAnio = new short[1] ;
      T006F13_A2315LegCuLActVen = new short[1] ;
      T006F13_A2313LegCuLTotCons = new int[1] ;
      T006F13_A2314LegCuLTotCorr = new int[1] ;
      T006F13_A2244LegCuenLicPerIni = new java.util.Date[] {GXutil.nullDate()} ;
      T006F13_A2245LegCuenLicPerFin = new java.util.Date[] {GXutil.nullDate()} ;
      T006F13_A2246LegCuenAntDias = new int[1] ;
      T006F13_A2299LegCuenAntAnios = new short[1] ;
      T006F13_A2300LegCuenAntMeses = new short[1] ;
      T006F13_A2247LegCuenDiasCorres = new short[1] ;
      T006F13_A2248LegCuenDiasGoz = new short[1] ;
      T006F13_A2249LegCuenDiasVig = new short[1] ;
      T006F13_A2301LegCueAntTexto = new String[] {""} ;
      T006F13_A2328LegCueAntAbr = new String[] {""} ;
      T006F13_A2302LegCuLiPCur = new short[1] ;
      T006F13_A2303LegCuLiPAnt = new short[1] ;
      T006F13_A2304LegCuLiPVen = new short[1] ;
      T006F13_A2305LegCuLiPSaldo = new short[1] ;
      T006F13_A2306LegCuLiPApr = new short[1] ;
      T006F13_A2307LegCuLiAprPGoce = new short[1] ;
      T006F13_A2321LegCuLIncluir = new boolean[] {false} ;
      T006F13_A2322LegCuLRecalc = new boolean[] {false} ;
      T006F13_A2329LegCuLLogDis = new String[] {""} ;
      T006F13_A251LegNombre = new String[] {""} ;
      T006F13_A230LegApellido = new String[] {""} ;
      T006F13_A93LegId = new String[] {""} ;
      T006F13_n93LegId = new boolean[] {false} ;
      T006F13_A3CliCod = new int[1] ;
      T006F13_A1EmpCod = new short[1] ;
      T006F13_A6LegNumero = new int[1] ;
      T006F14_A250LegIdNomApe = new String[] {""} ;
      T006F14_A251LegNombre = new String[] {""} ;
      T006F14_A230LegApellido = new String[] {""} ;
      T006F14_A93LegId = new String[] {""} ;
      T006F14_n93LegId = new boolean[] {false} ;
      T006F15_A3CliCod = new int[1] ;
      T006F15_A1EmpCod = new short[1] ;
      T006F15_A6LegNumero = new int[1] ;
      T006F15_A2243LegCuenLicTpo = new String[] {""} ;
      T006F15_A2266LegCuenAnio = new short[1] ;
      T006F11_A2243LegCuenLicTpo = new String[] {""} ;
      T006F11_A2266LegCuenAnio = new short[1] ;
      T006F11_A2315LegCuLActVen = new short[1] ;
      T006F11_A2313LegCuLTotCons = new int[1] ;
      T006F11_A2314LegCuLTotCorr = new int[1] ;
      T006F11_A2244LegCuenLicPerIni = new java.util.Date[] {GXutil.nullDate()} ;
      T006F11_A2245LegCuenLicPerFin = new java.util.Date[] {GXutil.nullDate()} ;
      T006F11_A2246LegCuenAntDias = new int[1] ;
      T006F11_A2299LegCuenAntAnios = new short[1] ;
      T006F11_A2300LegCuenAntMeses = new short[1] ;
      T006F11_A2247LegCuenDiasCorres = new short[1] ;
      T006F11_A2248LegCuenDiasGoz = new short[1] ;
      T006F11_A2249LegCuenDiasVig = new short[1] ;
      T006F11_A2301LegCueAntTexto = new String[] {""} ;
      T006F11_A2328LegCueAntAbr = new String[] {""} ;
      T006F11_A2302LegCuLiPCur = new short[1] ;
      T006F11_A2303LegCuLiPAnt = new short[1] ;
      T006F11_A2304LegCuLiPVen = new short[1] ;
      T006F11_A2305LegCuLiPSaldo = new short[1] ;
      T006F11_A2306LegCuLiPApr = new short[1] ;
      T006F11_A2307LegCuLiAprPGoce = new short[1] ;
      T006F11_A2321LegCuLIncluir = new boolean[] {false} ;
      T006F11_A2322LegCuLRecalc = new boolean[] {false} ;
      T006F11_A2329LegCuLLogDis = new String[] {""} ;
      T006F11_A3CliCod = new int[1] ;
      T006F11_A1EmpCod = new short[1] ;
      T006F11_A6LegNumero = new int[1] ;
      T006F16_A2243LegCuenLicTpo = new String[] {""} ;
      T006F16_A2266LegCuenAnio = new short[1] ;
      T006F16_A3CliCod = new int[1] ;
      T006F16_A1EmpCod = new short[1] ;
      T006F16_A6LegNumero = new int[1] ;
      T006F17_A2243LegCuenLicTpo = new String[] {""} ;
      T006F17_A2266LegCuenAnio = new short[1] ;
      T006F17_A3CliCod = new int[1] ;
      T006F17_A1EmpCod = new short[1] ;
      T006F17_A6LegNumero = new int[1] ;
      T006F10_A2243LegCuenLicTpo = new String[] {""} ;
      T006F10_A2266LegCuenAnio = new short[1] ;
      T006F10_A2315LegCuLActVen = new short[1] ;
      T006F10_A2313LegCuLTotCons = new int[1] ;
      T006F10_A2314LegCuLTotCorr = new int[1] ;
      T006F10_A2244LegCuenLicPerIni = new java.util.Date[] {GXutil.nullDate()} ;
      T006F10_A2245LegCuenLicPerFin = new java.util.Date[] {GXutil.nullDate()} ;
      T006F10_A2246LegCuenAntDias = new int[1] ;
      T006F10_A2299LegCuenAntAnios = new short[1] ;
      T006F10_A2300LegCuenAntMeses = new short[1] ;
      T006F10_A2247LegCuenDiasCorres = new short[1] ;
      T006F10_A2248LegCuenDiasGoz = new short[1] ;
      T006F10_A2249LegCuenDiasVig = new short[1] ;
      T006F10_A2301LegCueAntTexto = new String[] {""} ;
      T006F10_A2328LegCueAntAbr = new String[] {""} ;
      T006F10_A2302LegCuLiPCur = new short[1] ;
      T006F10_A2303LegCuLiPAnt = new short[1] ;
      T006F10_A2304LegCuLiPVen = new short[1] ;
      T006F10_A2305LegCuLiPSaldo = new short[1] ;
      T006F10_A2306LegCuLiPApr = new short[1] ;
      T006F10_A2307LegCuLiAprPGoce = new short[1] ;
      T006F10_A2321LegCuLIncluir = new boolean[] {false} ;
      T006F10_A2322LegCuLRecalc = new boolean[] {false} ;
      T006F10_A2329LegCuLLogDis = new String[] {""} ;
      T006F10_A3CliCod = new int[1] ;
      T006F10_A1EmpCod = new short[1] ;
      T006F10_A6LegNumero = new int[1] ;
      T006F21_A250LegIdNomApe = new String[] {""} ;
      T006F21_A251LegNombre = new String[] {""} ;
      T006F21_A230LegApellido = new String[] {""} ;
      T006F21_A93LegId = new String[] {""} ;
      T006F21_n93LegId = new boolean[] {false} ;
      T006F22_A3CliCod = new int[1] ;
      T006F22_A1EmpCod = new short[1] ;
      T006F22_A6LegNumero = new int[1] ;
      T006F22_A2243LegCuenLicTpo = new String[] {""} ;
      T006F22_A2266LegCuenAnio = new short[1] ;
      T006F23_A2243LegCuenLicTpo = new String[] {""} ;
      T006F23_A2266LegCuenAnio = new short[1] ;
      T006F23_A2324LegCuLAprLicFch = new java.util.Date[] {GXutil.nullDate()} ;
      T006F23_A2326LegCuLAprLicOri = new String[] {""} ;
      T006F23_A2325LegCuLAprLicCnt = new short[1] ;
      T006F23_A3CliCod = new int[1] ;
      T006F23_A1EmpCod = new short[1] ;
      T006F23_A2341LegCuLAprLiqNro = new int[1] ;
      T006F23_n2341LegCuLAprLiqNro = new boolean[] {false} ;
      T006F23_A6LegNumero = new int[1] ;
      T006F8_A3CliCod = new int[1] ;
      T006F9_A3CliCod = new int[1] ;
      T006F24_A3CliCod = new int[1] ;
      T006F25_A3CliCod = new int[1] ;
      T006F26_A3CliCod = new int[1] ;
      T006F26_A1EmpCod = new short[1] ;
      T006F26_A6LegNumero = new int[1] ;
      T006F26_A2243LegCuenLicTpo = new String[] {""} ;
      T006F26_A2266LegCuenAnio = new short[1] ;
      T006F26_A2324LegCuLAprLicFch = new java.util.Date[] {GXutil.nullDate()} ;
      T006F7_A2243LegCuenLicTpo = new String[] {""} ;
      T006F7_A2266LegCuenAnio = new short[1] ;
      T006F7_A2324LegCuLAprLicFch = new java.util.Date[] {GXutil.nullDate()} ;
      T006F7_A2326LegCuLAprLicOri = new String[] {""} ;
      T006F7_A2325LegCuLAprLicCnt = new short[1] ;
      T006F7_A3CliCod = new int[1] ;
      T006F7_A1EmpCod = new short[1] ;
      T006F7_A2341LegCuLAprLiqNro = new int[1] ;
      T006F7_n2341LegCuLAprLiqNro = new boolean[] {false} ;
      T006F7_A6LegNumero = new int[1] ;
      T006F6_A2243LegCuenLicTpo = new String[] {""} ;
      T006F6_A2266LegCuenAnio = new short[1] ;
      T006F6_A2324LegCuLAprLicFch = new java.util.Date[] {GXutil.nullDate()} ;
      T006F6_A2326LegCuLAprLicOri = new String[] {""} ;
      T006F6_A2325LegCuLAprLicCnt = new short[1] ;
      T006F6_A3CliCod = new int[1] ;
      T006F6_A1EmpCod = new short[1] ;
      T006F6_A2341LegCuLAprLiqNro = new int[1] ;
      T006F6_n2341LegCuLAprLiqNro = new boolean[] {false} ;
      T006F6_A6LegNumero = new int[1] ;
      T006F30_A3CliCod = new int[1] ;
      T006F30_A1EmpCod = new short[1] ;
      T006F30_A6LegNumero = new int[1] ;
      T006F30_A2243LegCuenLicTpo = new String[] {""} ;
      T006F30_A2266LegCuenAnio = new short[1] ;
      T006F30_A2324LegCuLAprLicFch = new java.util.Date[] {GXutil.nullDate()} ;
      T006F31_A2243LegCuenLicTpo = new String[] {""} ;
      T006F31_A2266LegCuenAnio = new short[1] ;
      T006F31_A2310LegCuLConsAnio = new short[1] ;
      T006F31_A2311LegCuLConsSec = new short[1] ;
      T006F31_A2327LegCuLConsOri = new String[] {""} ;
      T006F31_A2312LegCuLConsCnt = new short[1] ;
      T006F31_A3CliCod = new int[1] ;
      T006F31_A1EmpCod = new short[1] ;
      T006F31_A2342LegCulConsLiqNro = new int[1] ;
      T006F31_n2342LegCulConsLiqNro = new boolean[] {false} ;
      T006F31_A6LegNumero = new int[1] ;
      T006F4_A3CliCod = new int[1] ;
      T006F5_A3CliCod = new int[1] ;
      T006F32_A3CliCod = new int[1] ;
      T006F33_A3CliCod = new int[1] ;
      T006F34_A3CliCod = new int[1] ;
      T006F34_A1EmpCod = new short[1] ;
      T006F34_A6LegNumero = new int[1] ;
      T006F34_A2243LegCuenLicTpo = new String[] {""} ;
      T006F34_A2266LegCuenAnio = new short[1] ;
      T006F34_A2310LegCuLConsAnio = new short[1] ;
      T006F34_A2311LegCuLConsSec = new short[1] ;
      T006F3_A2243LegCuenLicTpo = new String[] {""} ;
      T006F3_A2266LegCuenAnio = new short[1] ;
      T006F3_A2310LegCuLConsAnio = new short[1] ;
      T006F3_A2311LegCuLConsSec = new short[1] ;
      T006F3_A2327LegCuLConsOri = new String[] {""} ;
      T006F3_A2312LegCuLConsCnt = new short[1] ;
      T006F3_A3CliCod = new int[1] ;
      T006F3_A1EmpCod = new short[1] ;
      T006F3_A2342LegCulConsLiqNro = new int[1] ;
      T006F3_n2342LegCulConsLiqNro = new boolean[] {false} ;
      T006F3_A6LegNumero = new int[1] ;
      T006F2_A2243LegCuenLicTpo = new String[] {""} ;
      T006F2_A2266LegCuenAnio = new short[1] ;
      T006F2_A2310LegCuLConsAnio = new short[1] ;
      T006F2_A2311LegCuLConsSec = new short[1] ;
      T006F2_A2327LegCuLConsOri = new String[] {""} ;
      T006F2_A2312LegCuLConsCnt = new short[1] ;
      T006F2_A3CliCod = new int[1] ;
      T006F2_A1EmpCod = new short[1] ;
      T006F2_A2342LegCulConsLiqNro = new int[1] ;
      T006F2_n2342LegCulConsLiqNro = new boolean[] {false} ;
      T006F2_A6LegNumero = new int[1] ;
      T006F38_A3CliCod = new int[1] ;
      T006F38_A1EmpCod = new short[1] ;
      T006F38_A6LegNumero = new int[1] ;
      T006F38_A2243LegCuenLicTpo = new String[] {""} ;
      T006F38_A2266LegCuenAnio = new short[1] ;
      T006F38_A2310LegCuLConsAnio = new short[1] ;
      T006F38_A2311LegCuLConsSec = new short[1] ;
      Gridlevel_aprobacionesRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_aprobaciones_Linesclass = "" ;
      ROClassString = "" ;
      Gridlevel_consumosRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_consumos_Linesclass = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i2326LegCuLAprLicOri = "" ;
      i2327LegCuLConsOri = "" ;
      Gridlevel_aprobacionesColumn = new com.genexus.webpanels.GXWebColumn();
      Gridlevel_consumosColumn = new com.genexus.webpanels.GXWebColumn();
      GXv_int5 = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajo_cuenta_licencias__default(),
         new Object[] {
             new Object[] {
            T006F2_A2243LegCuenLicTpo, T006F2_A2266LegCuenAnio, T006F2_A2310LegCuLConsAnio, T006F2_A2311LegCuLConsSec, T006F2_A2327LegCuLConsOri, T006F2_A2312LegCuLConsCnt, T006F2_A3CliCod, T006F2_A1EmpCod, T006F2_A2342LegCulConsLiqNro, T006F2_n2342LegCulConsLiqNro,
            T006F2_A6LegNumero
            }
            , new Object[] {
            T006F3_A2243LegCuenLicTpo, T006F3_A2266LegCuenAnio, T006F3_A2310LegCuLConsAnio, T006F3_A2311LegCuLConsSec, T006F3_A2327LegCuLConsOri, T006F3_A2312LegCuLConsCnt, T006F3_A3CliCod, T006F3_A1EmpCod, T006F3_A2342LegCulConsLiqNro, T006F3_n2342LegCulConsLiqNro,
            T006F3_A6LegNumero
            }
            , new Object[] {
            T006F4_A3CliCod
            }
            , new Object[] {
            T006F5_A3CliCod
            }
            , new Object[] {
            T006F6_A2243LegCuenLicTpo, T006F6_A2266LegCuenAnio, T006F6_A2324LegCuLAprLicFch, T006F6_A2326LegCuLAprLicOri, T006F6_A2325LegCuLAprLicCnt, T006F6_A3CliCod, T006F6_A1EmpCod, T006F6_A2341LegCuLAprLiqNro, T006F6_n2341LegCuLAprLiqNro, T006F6_A6LegNumero
            }
            , new Object[] {
            T006F7_A2243LegCuenLicTpo, T006F7_A2266LegCuenAnio, T006F7_A2324LegCuLAprLicFch, T006F7_A2326LegCuLAprLicOri, T006F7_A2325LegCuLAprLicCnt, T006F7_A3CliCod, T006F7_A1EmpCod, T006F7_A2341LegCuLAprLiqNro, T006F7_n2341LegCuLAprLiqNro, T006F7_A6LegNumero
            }
            , new Object[] {
            T006F8_A3CliCod
            }
            , new Object[] {
            T006F9_A3CliCod
            }
            , new Object[] {
            T006F10_A2243LegCuenLicTpo, T006F10_A2266LegCuenAnio, T006F10_A2315LegCuLActVen, T006F10_A2313LegCuLTotCons, T006F10_A2314LegCuLTotCorr, T006F10_A2244LegCuenLicPerIni, T006F10_A2245LegCuenLicPerFin, T006F10_A2246LegCuenAntDias, T006F10_A2299LegCuenAntAnios, T006F10_A2300LegCuenAntMeses,
            T006F10_A2247LegCuenDiasCorres, T006F10_A2248LegCuenDiasGoz, T006F10_A2249LegCuenDiasVig, T006F10_A2301LegCueAntTexto, T006F10_A2328LegCueAntAbr, T006F10_A2302LegCuLiPCur, T006F10_A2303LegCuLiPAnt, T006F10_A2304LegCuLiPVen, T006F10_A2305LegCuLiPSaldo, T006F10_A2306LegCuLiPApr,
            T006F10_A2307LegCuLiAprPGoce, T006F10_A2321LegCuLIncluir, T006F10_A2322LegCuLRecalc, T006F10_A2329LegCuLLogDis, T006F10_A3CliCod, T006F10_A1EmpCod, T006F10_A6LegNumero
            }
            , new Object[] {
            T006F11_A2243LegCuenLicTpo, T006F11_A2266LegCuenAnio, T006F11_A2315LegCuLActVen, T006F11_A2313LegCuLTotCons, T006F11_A2314LegCuLTotCorr, T006F11_A2244LegCuenLicPerIni, T006F11_A2245LegCuenLicPerFin, T006F11_A2246LegCuenAntDias, T006F11_A2299LegCuenAntAnios, T006F11_A2300LegCuenAntMeses,
            T006F11_A2247LegCuenDiasCorres, T006F11_A2248LegCuenDiasGoz, T006F11_A2249LegCuenDiasVig, T006F11_A2301LegCueAntTexto, T006F11_A2328LegCueAntAbr, T006F11_A2302LegCuLiPCur, T006F11_A2303LegCuLiPAnt, T006F11_A2304LegCuLiPVen, T006F11_A2305LegCuLiPSaldo, T006F11_A2306LegCuLiPApr,
            T006F11_A2307LegCuLiAprPGoce, T006F11_A2321LegCuLIncluir, T006F11_A2322LegCuLRecalc, T006F11_A2329LegCuLLogDis, T006F11_A3CliCod, T006F11_A1EmpCod, T006F11_A6LegNumero
            }
            , new Object[] {
            T006F12_A250LegIdNomApe, T006F12_A251LegNombre, T006F12_A230LegApellido, T006F12_A93LegId, T006F12_n93LegId
            }
            , new Object[] {
            T006F13_A250LegIdNomApe, T006F13_A2243LegCuenLicTpo, T006F13_A2266LegCuenAnio, T006F13_A2315LegCuLActVen, T006F13_A2313LegCuLTotCons, T006F13_A2314LegCuLTotCorr, T006F13_A2244LegCuenLicPerIni, T006F13_A2245LegCuenLicPerFin, T006F13_A2246LegCuenAntDias, T006F13_A2299LegCuenAntAnios,
            T006F13_A2300LegCuenAntMeses, T006F13_A2247LegCuenDiasCorres, T006F13_A2248LegCuenDiasGoz, T006F13_A2249LegCuenDiasVig, T006F13_A2301LegCueAntTexto, T006F13_A2328LegCueAntAbr, T006F13_A2302LegCuLiPCur, T006F13_A2303LegCuLiPAnt, T006F13_A2304LegCuLiPVen, T006F13_A2305LegCuLiPSaldo,
            T006F13_A2306LegCuLiPApr, T006F13_A2307LegCuLiAprPGoce, T006F13_A2321LegCuLIncluir, T006F13_A2322LegCuLRecalc, T006F13_A2329LegCuLLogDis, T006F13_A251LegNombre, T006F13_A230LegApellido, T006F13_A93LegId, T006F13_n93LegId, T006F13_A3CliCod,
            T006F13_A1EmpCod, T006F13_A6LegNumero
            }
            , new Object[] {
            T006F14_A250LegIdNomApe, T006F14_A251LegNombre, T006F14_A230LegApellido, T006F14_A93LegId, T006F14_n93LegId
            }
            , new Object[] {
            T006F15_A3CliCod, T006F15_A1EmpCod, T006F15_A6LegNumero, T006F15_A2243LegCuenLicTpo, T006F15_A2266LegCuenAnio
            }
            , new Object[] {
            T006F16_A2243LegCuenLicTpo, T006F16_A2266LegCuenAnio, T006F16_A3CliCod, T006F16_A1EmpCod, T006F16_A6LegNumero
            }
            , new Object[] {
            T006F17_A2243LegCuenLicTpo, T006F17_A2266LegCuenAnio, T006F17_A3CliCod, T006F17_A1EmpCod, T006F17_A6LegNumero
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T006F21_A250LegIdNomApe, T006F21_A251LegNombre, T006F21_A230LegApellido, T006F21_A93LegId, T006F21_n93LegId
            }
            , new Object[] {
            T006F22_A3CliCod, T006F22_A1EmpCod, T006F22_A6LegNumero, T006F22_A2243LegCuenLicTpo, T006F22_A2266LegCuenAnio
            }
            , new Object[] {
            T006F23_A2243LegCuenLicTpo, T006F23_A2266LegCuenAnio, T006F23_A2324LegCuLAprLicFch, T006F23_A2326LegCuLAprLicOri, T006F23_A2325LegCuLAprLicCnt, T006F23_A3CliCod, T006F23_A1EmpCod, T006F23_A2341LegCuLAprLiqNro, T006F23_n2341LegCuLAprLiqNro, T006F23_A6LegNumero
            }
            , new Object[] {
            T006F24_A3CliCod
            }
            , new Object[] {
            T006F25_A3CliCod
            }
            , new Object[] {
            T006F26_A3CliCod, T006F26_A1EmpCod, T006F26_A6LegNumero, T006F26_A2243LegCuenLicTpo, T006F26_A2266LegCuenAnio, T006F26_A2324LegCuLAprLicFch
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T006F30_A3CliCod, T006F30_A1EmpCod, T006F30_A6LegNumero, T006F30_A2243LegCuenLicTpo, T006F30_A2266LegCuenAnio, T006F30_A2324LegCuLAprLicFch
            }
            , new Object[] {
            T006F31_A2243LegCuenLicTpo, T006F31_A2266LegCuenAnio, T006F31_A2310LegCuLConsAnio, T006F31_A2311LegCuLConsSec, T006F31_A2327LegCuLConsOri, T006F31_A2312LegCuLConsCnt, T006F31_A3CliCod, T006F31_A1EmpCod, T006F31_A2342LegCulConsLiqNro, T006F31_n2342LegCulConsLiqNro,
            T006F31_A6LegNumero
            }
            , new Object[] {
            T006F32_A3CliCod
            }
            , new Object[] {
            T006F33_A3CliCod
            }
            , new Object[] {
            T006F34_A3CliCod, T006F34_A1EmpCod, T006F34_A6LegNumero, T006F34_A2243LegCuenLicTpo, T006F34_A2266LegCuenAnio, T006F34_A2310LegCuLConsAnio, T006F34_A2311LegCuLConsSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T006F38_A3CliCod, T006F38_A1EmpCod, T006F38_A6LegNumero, T006F38_A2243LegCuenLicTpo, T006F38_A2266LegCuenAnio, T006F38_A2310LegCuLConsAnio, T006F38_A2311LegCuLConsSec
            }
         }
      );
      AV20Pgmname = "legajo_cuenta_licencias" ;
      Z2327LegCuLConsOri = "manual" ;
      A2327LegCuLConsOri = "manual" ;
      i2327LegCuLConsOri = "manual" ;
      Z2326LegCuLAprLicOri = "manual" ;
      A2326LegCuLAprLicOri = "manual" ;
      i2326LegCuLAprLicOri = "manual" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte subGridlevel_aprobaciones_Backcolorstyle ;
   private byte subGridlevel_aprobaciones_Backstyle ;
   private byte subGridlevel_consumos_Backcolorstyle ;
   private byte subGridlevel_consumos_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel_aprobaciones_Allowselection ;
   private byte subGridlevel_aprobaciones_Allowhovering ;
   private byte subGridlevel_aprobaciones_Allowcollapsing ;
   private byte subGridlevel_aprobaciones_Collapsed ;
   private byte subGridlevel_consumos_Allowselection ;
   private byte subGridlevel_consumos_Allowhovering ;
   private byte subGridlevel_consumos_Allowcollapsing ;
   private byte subGridlevel_consumos_Collapsed ;
   private short wcpOAV8EmpCod ;
   private short wcpOAV11LegCuenAnio ;
   private short Z1EmpCod ;
   private short Z2266LegCuenAnio ;
   private short Z2315LegCuLActVen ;
   private short Z2299LegCuenAntAnios ;
   private short Z2300LegCuenAntMeses ;
   private short Z2247LegCuenDiasCorres ;
   private short Z2248LegCuenDiasGoz ;
   private short Z2249LegCuenDiasVig ;
   private short Z2302LegCuLiPCur ;
   private short Z2303LegCuLiPAnt ;
   private short Z2304LegCuLiPVen ;
   private short Z2305LegCuLiPSaldo ;
   private short Z2306LegCuLiPApr ;
   private short Z2307LegCuLiAprPGoce ;
   private short Z2325LegCuLAprLicCnt ;
   private short nRcdDeleted_288 ;
   private short nRcdExists_288 ;
   private short nIsMod_288 ;
   private short Z2310LegCuLConsAnio ;
   private short Z2311LegCuLConsSec ;
   private short Z2312LegCuLConsCnt ;
   private short nRcdDeleted_289 ;
   private short nRcdExists_289 ;
   private short nIsMod_289 ;
   private short A1EmpCod ;
   private short AV8EmpCod ;
   private short AV11LegCuenAnio ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A2266LegCuenAnio ;
   private short A2247LegCuenDiasCorres ;
   private short A2303LegCuLiPAnt ;
   private short A2304LegCuLiPVen ;
   private short A2302LegCuLiPCur ;
   private short A2315LegCuLActVen ;
   private short A2306LegCuLiPApr ;
   private short A2248LegCuenDiasGoz ;
   private short A2305LegCuLiPSaldo ;
   private short nBlankRcdCount288 ;
   private short RcdFound288 ;
   private short nBlankRcdUsr288 ;
   private short nBlankRcdCount289 ;
   private short RcdFound289 ;
   private short nBlankRcdUsr289 ;
   private short A2299LegCuenAntAnios ;
   private short A2300LegCuenAntMeses ;
   private short A2249LegCuenDiasVig ;
   private short A2307LegCuLiAprPGoce ;
   private short RcdFound285 ;
   private short A2310LegCuLConsAnio ;
   private short A2311LegCuLConsSec ;
   private short A2312LegCuLConsCnt ;
   private short A2325LegCuLAprLicCnt ;
   private short AV17actualAnio ;
   private short nIsDirty_285 ;
   private short nIsDirty_288 ;
   private short nIsDirty_289 ;
   private int wcpOAV7CliCod ;
   private int wcpOAV9LegNumero ;
   private int Z3CliCod ;
   private int Z6LegNumero ;
   private int Z2313LegCuLTotCons ;
   private int Z2314LegCuLTotCorr ;
   private int Z2246LegCuenAntDias ;
   private int nRC_GXsfl_93 ;
   private int nGXsfl_93_idx=1 ;
   private int nRC_GXsfl_107 ;
   private int nGXsfl_107_idx=1 ;
   private int Z2341LegCuLAprLiqNro ;
   private int Z2342LegCulConsLiqNro ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A2341LegCuLAprLiqNro ;
   private int A2342LegCulConsLiqNro ;
   private int AV9LegNumero ;
   private int trnEnded ;
   private int edtLegIdNomApe_Enabled ;
   private int edtLegCuenAnio_Enabled ;
   private int edtLegCuenLicPerIni_Enabled ;
   private int edtLegCuenLicPerFin_Enabled ;
   private int edtLegCuenDiasCorres_Enabled ;
   private int edtLegCuLiPAnt_Enabled ;
   private int edtLegCuLiPVen_Enabled ;
   private int edtLegCuLiPCur_Enabled ;
   private int edtLegCuLActVen_Enabled ;
   private int edtLegCuLiPApr_Enabled ;
   private int edtLegCuenDiasGoz_Enabled ;
   private int edtLegCuLiPSaldo_Enabled ;
   private int edtLegCuLAprLicFch_Enabled ;
   private int edtLegCuLAprLicCnt_Enabled ;
   private int fRowAdded ;
   private int edtLegCuLConsAnio_Enabled ;
   private int edtLegCuLConsSec_Enabled ;
   private int edtLegCuLConsCnt_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int edtLegNumero_Visible ;
   private int edtLegNumero_Enabled ;
   private int edtLegCuLRecalc_Visible ;
   private int edtLegCuLRecalc_Enabled ;
   private int A2246LegCuenAntDias ;
   private int edtLegCuenAntDias_Enabled ;
   private int edtLegCuenAntDias_Visible ;
   private int edtLegCuenAntAnios_Enabled ;
   private int edtLegCuenAntAnios_Visible ;
   private int edtLegCuenAntMeses_Enabled ;
   private int edtLegCuenAntMeses_Visible ;
   private int edtLegCueAntTexto_Visible ;
   private int edtLegCueAntTexto_Enabled ;
   private int A2313LegCuLTotCons ;
   private int A2314LegCuLTotCorr ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int Dvpanel_unnamedtable1_Gxcontroltype ;
   private int Dvpanel_unnamedtable2_Gxcontroltype ;
   private int GX_JID ;
   private int subGridlevel_aprobaciones_Backcolor ;
   private int subGridlevel_aprobaciones_Allbackcolor ;
   private int subGridlevel_consumos_Backcolor ;
   private int subGridlevel_consumos_Allbackcolor ;
   private int defcmbLegCuLConsOri_Enabled ;
   private int defedtLegCuLConsSec_Enabled ;
   private int defedtLegCuLConsAnio_Enabled ;
   private int defcmbLegCuLAprLicOri_Enabled ;
   private int defedtLegCuLAprLicFch_Enabled ;
   private int idxLst ;
   private int subGridlevel_aprobaciones_Selectedindex ;
   private int subGridlevel_aprobaciones_Selectioncolor ;
   private int subGridlevel_aprobaciones_Hoveringcolor ;
   private int subGridlevel_consumos_Selectedindex ;
   private int subGridlevel_consumos_Selectioncolor ;
   private int subGridlevel_consumos_Hoveringcolor ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private long GRIDLEVEL_APROBACIONES_nFirstRecordOnPage ;
   private long GRIDLEVEL_CONSUMOS_nFirstRecordOnPage ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV10LegCuenLicTpo ;
   private String Z2243LegCuenLicTpo ;
   private String Z2326LegCuLAprLicOri ;
   private String Z2327LegCuLConsOri ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV10LegCuenLicTpo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtLegCuenAnio_Internalname ;
   private String sGXsfl_93_idx="0001" ;
   private String sGXsfl_107_idx="0001" ;
   private String A2243LegCuenLicTpo ;
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
   private String edtLegIdNomApe_Internalname ;
   private String edtLegIdNomApe_Jsonclick ;
   private String TempTags ;
   private String edtLegCuenAnio_Jsonclick ;
   private String edtLegCuenLicPerIni_Internalname ;
   private String edtLegCuenLicPerIni_Jsonclick ;
   private String edtLegCuenLicPerFin_Internalname ;
   private String edtLegCuenLicPerFin_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String edtLegCuenDiasCorres_Internalname ;
   private String edtLegCuenDiasCorres_Jsonclick ;
   private String edtLegCuLiPAnt_Internalname ;
   private String edtLegCuLiPAnt_Jsonclick ;
   private String edtLegCuLiPVen_Internalname ;
   private String edtLegCuLiPVen_Jsonclick ;
   private String edtLegCuLiPCur_Internalname ;
   private String edtLegCuLiPCur_Jsonclick ;
   private String edtLegCuLActVen_Internalname ;
   private String edtLegCuLActVen_Jsonclick ;
   private String edtLegCuLiPApr_Internalname ;
   private String edtLegCuLiPApr_Jsonclick ;
   private String edtLegCuenDiasGoz_Internalname ;
   private String edtLegCuenDiasGoz_Jsonclick ;
   private String edtLegCuLiPSaldo_Internalname ;
   private String edtLegCuLiPSaldo_Jsonclick ;
   private String Dvpanel_unnamedtable1_Width ;
   private String Dvpanel_unnamedtable1_Cls ;
   private String Dvpanel_unnamedtable1_Title ;
   private String Dvpanel_unnamedtable1_Iconposition ;
   private String Dvpanel_unnamedtable1_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String divTableleaflevel_aprobaciones_Internalname ;
   private String sMode288 ;
   private String edtLegCuLAprLicFch_Internalname ;
   private String edtLegCuLAprLicCnt_Internalname ;
   private String subGridlevel_aprobaciones_Internalname ;
   private String Dvpanel_unnamedtable2_Width ;
   private String Dvpanel_unnamedtable2_Cls ;
   private String Dvpanel_unnamedtable2_Title ;
   private String Dvpanel_unnamedtable2_Iconposition ;
   private String Dvpanel_unnamedtable2_Internalname ;
   private String divUnnamedtable2_Internalname ;
   private String divTableleaflevel_consumos_Internalname ;
   private String sMode289 ;
   private String edtLegCuLConsAnio_Internalname ;
   private String edtLegCuLConsSec_Internalname ;
   private String edtLegCuLConsCnt_Internalname ;
   private String subGridlevel_consumos_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtLegNumero_Internalname ;
   private String edtLegNumero_Jsonclick ;
   private String edtLegCuLRecalc_Internalname ;
   private String edtLegCuLRecalc_Jsonclick ;
   private String edtLegCuenAntDias_Internalname ;
   private String edtLegCuenAntDias_Jsonclick ;
   private String edtLegCuenAntAnios_Internalname ;
   private String edtLegCuenAntAnios_Jsonclick ;
   private String edtLegCuenAntMeses_Internalname ;
   private String edtLegCuenAntMeses_Jsonclick ;
   private String edtLegCueAntTexto_Internalname ;
   private String A93LegId ;
   private String AV20Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String Dvpanel_unnamedtable1_Objectcall ;
   private String Dvpanel_unnamedtable1_Class ;
   private String Dvpanel_unnamedtable1_Height ;
   private String Dvpanel_unnamedtable2_Objectcall ;
   private String Dvpanel_unnamedtable2_Class ;
   private String Dvpanel_unnamedtable2_Height ;
   private String hsh ;
   private String sMode285 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String A2327LegCuLConsOri ;
   private String A2326LegCuLAprLicOri ;
   private String Z93LegId ;
   private String sGXsfl_93_fel_idx="0001" ;
   private String subGridlevel_aprobaciones_Class ;
   private String subGridlevel_aprobaciones_Linesclass ;
   private String ROClassString ;
   private String edtLegCuLAprLicFch_Jsonclick ;
   private String edtLegCuLAprLicCnt_Jsonclick ;
   private String sGXsfl_107_fel_idx="0001" ;
   private String subGridlevel_consumos_Class ;
   private String subGridlevel_consumos_Linesclass ;
   private String edtLegCuLConsAnio_Jsonclick ;
   private String edtLegCuLConsSec_Jsonclick ;
   private String edtLegCuLConsCnt_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String i2326LegCuLAprLicOri ;
   private String i2327LegCuLConsOri ;
   private String subGridlevel_aprobaciones_Header ;
   private String subGridlevel_consumos_Header ;
   private java.util.Date Z2244LegCuenLicPerIni ;
   private java.util.Date Z2245LegCuenLicPerFin ;
   private java.util.Date Z2324LegCuLAprLicFch ;
   private java.util.Date A2244LegCuenLicPerIni ;
   private java.util.Date A2245LegCuenLicPerFin ;
   private java.util.Date A2324LegCuLAprLicFch ;
   private java.util.Date AV18hoy ;
   private boolean Z2321LegCuLIncluir ;
   private boolean Z2322LegCuLRecalc ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n2341LegCuLAprLiqNro ;
   private boolean n2342LegCulConsLiqNro ;
   private boolean wbErr ;
   private boolean A2321LegCuLIncluir ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_unnamedtable1_Autowidth ;
   private boolean Dvpanel_unnamedtable1_Autoheight ;
   private boolean Dvpanel_unnamedtable1_Collapsible ;
   private boolean Dvpanel_unnamedtable1_Collapsed ;
   private boolean Dvpanel_unnamedtable1_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable1_Autoscroll ;
   private boolean bGXsfl_93_Refreshing=false ;
   private boolean Dvpanel_unnamedtable2_Autowidth ;
   private boolean Dvpanel_unnamedtable2_Autoheight ;
   private boolean Dvpanel_unnamedtable2_Collapsible ;
   private boolean Dvpanel_unnamedtable2_Collapsed ;
   private boolean Dvpanel_unnamedtable2_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable2_Autoscroll ;
   private boolean bGXsfl_107_Refreshing=false ;
   private boolean A2322LegCuLRecalc ;
   private boolean n93LegId ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean Dvpanel_unnamedtable1_Enabled ;
   private boolean Dvpanel_unnamedtable1_Showheader ;
   private boolean Dvpanel_unnamedtable1_Visible ;
   private boolean Dvpanel_unnamedtable2_Enabled ;
   private boolean Dvpanel_unnamedtable2_Showheader ;
   private boolean Dvpanel_unnamedtable2_Visible ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private String A2301LegCueAntTexto ;
   private String A2329LegCuLLogDis ;
   private String Z2301LegCueAntTexto ;
   private String Z2329LegCuLLogDis ;
   private String Z2328LegCueAntAbr ;
   private String A250LegIdNomApe ;
   private String A2328LegCueAntAbr ;
   private String A251LegNombre ;
   private String A230LegApellido ;
   private String Z250LegIdNomApe ;
   private String Z251LegNombre ;
   private String Z230LegApellido ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_aprobacionesContainer ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_consumosContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_aprobacionesRow ;
   private com.genexus.webpanels.GXWebRow Gridlevel_consumosRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_aprobacionesColumn ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_consumosColumn ;
   private com.genexus.webpanels.WebSession AV16WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable1 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable2 ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkLegCuLIncluir ;
   private HTMLChoice cmbLegCuLAprLicOri ;
   private HTMLChoice cmbLegCuLConsOri ;
   private HTMLChoice cmbLegCuenLicTpo ;
   private IDataStoreProvider pr_default ;
   private String[] T006F12_A250LegIdNomApe ;
   private String[] T006F12_A251LegNombre ;
   private String[] T006F12_A230LegApellido ;
   private String[] T006F12_A93LegId ;
   private boolean[] T006F12_n93LegId ;
   private String[] T006F13_A250LegIdNomApe ;
   private String[] T006F13_A2243LegCuenLicTpo ;
   private short[] T006F13_A2266LegCuenAnio ;
   private short[] T006F13_A2315LegCuLActVen ;
   private int[] T006F13_A2313LegCuLTotCons ;
   private int[] T006F13_A2314LegCuLTotCorr ;
   private java.util.Date[] T006F13_A2244LegCuenLicPerIni ;
   private java.util.Date[] T006F13_A2245LegCuenLicPerFin ;
   private int[] T006F13_A2246LegCuenAntDias ;
   private short[] T006F13_A2299LegCuenAntAnios ;
   private short[] T006F13_A2300LegCuenAntMeses ;
   private short[] T006F13_A2247LegCuenDiasCorres ;
   private short[] T006F13_A2248LegCuenDiasGoz ;
   private short[] T006F13_A2249LegCuenDiasVig ;
   private String[] T006F13_A2301LegCueAntTexto ;
   private String[] T006F13_A2328LegCueAntAbr ;
   private short[] T006F13_A2302LegCuLiPCur ;
   private short[] T006F13_A2303LegCuLiPAnt ;
   private short[] T006F13_A2304LegCuLiPVen ;
   private short[] T006F13_A2305LegCuLiPSaldo ;
   private short[] T006F13_A2306LegCuLiPApr ;
   private short[] T006F13_A2307LegCuLiAprPGoce ;
   private boolean[] T006F13_A2321LegCuLIncluir ;
   private boolean[] T006F13_A2322LegCuLRecalc ;
   private String[] T006F13_A2329LegCuLLogDis ;
   private String[] T006F13_A251LegNombre ;
   private String[] T006F13_A230LegApellido ;
   private String[] T006F13_A93LegId ;
   private boolean[] T006F13_n93LegId ;
   private int[] T006F13_A3CliCod ;
   private short[] T006F13_A1EmpCod ;
   private int[] T006F13_A6LegNumero ;
   private String[] T006F14_A250LegIdNomApe ;
   private String[] T006F14_A251LegNombre ;
   private String[] T006F14_A230LegApellido ;
   private String[] T006F14_A93LegId ;
   private boolean[] T006F14_n93LegId ;
   private int[] T006F15_A3CliCod ;
   private short[] T006F15_A1EmpCod ;
   private int[] T006F15_A6LegNumero ;
   private String[] T006F15_A2243LegCuenLicTpo ;
   private short[] T006F15_A2266LegCuenAnio ;
   private String[] T006F11_A2243LegCuenLicTpo ;
   private short[] T006F11_A2266LegCuenAnio ;
   private short[] T006F11_A2315LegCuLActVen ;
   private int[] T006F11_A2313LegCuLTotCons ;
   private int[] T006F11_A2314LegCuLTotCorr ;
   private java.util.Date[] T006F11_A2244LegCuenLicPerIni ;
   private java.util.Date[] T006F11_A2245LegCuenLicPerFin ;
   private int[] T006F11_A2246LegCuenAntDias ;
   private short[] T006F11_A2299LegCuenAntAnios ;
   private short[] T006F11_A2300LegCuenAntMeses ;
   private short[] T006F11_A2247LegCuenDiasCorres ;
   private short[] T006F11_A2248LegCuenDiasGoz ;
   private short[] T006F11_A2249LegCuenDiasVig ;
   private String[] T006F11_A2301LegCueAntTexto ;
   private String[] T006F11_A2328LegCueAntAbr ;
   private short[] T006F11_A2302LegCuLiPCur ;
   private short[] T006F11_A2303LegCuLiPAnt ;
   private short[] T006F11_A2304LegCuLiPVen ;
   private short[] T006F11_A2305LegCuLiPSaldo ;
   private short[] T006F11_A2306LegCuLiPApr ;
   private short[] T006F11_A2307LegCuLiAprPGoce ;
   private boolean[] T006F11_A2321LegCuLIncluir ;
   private boolean[] T006F11_A2322LegCuLRecalc ;
   private String[] T006F11_A2329LegCuLLogDis ;
   private int[] T006F11_A3CliCod ;
   private short[] T006F11_A1EmpCod ;
   private int[] T006F11_A6LegNumero ;
   private String[] T006F16_A2243LegCuenLicTpo ;
   private short[] T006F16_A2266LegCuenAnio ;
   private int[] T006F16_A3CliCod ;
   private short[] T006F16_A1EmpCod ;
   private int[] T006F16_A6LegNumero ;
   private String[] T006F17_A2243LegCuenLicTpo ;
   private short[] T006F17_A2266LegCuenAnio ;
   private int[] T006F17_A3CliCod ;
   private short[] T006F17_A1EmpCod ;
   private int[] T006F17_A6LegNumero ;
   private String[] T006F10_A2243LegCuenLicTpo ;
   private short[] T006F10_A2266LegCuenAnio ;
   private short[] T006F10_A2315LegCuLActVen ;
   private int[] T006F10_A2313LegCuLTotCons ;
   private int[] T006F10_A2314LegCuLTotCorr ;
   private java.util.Date[] T006F10_A2244LegCuenLicPerIni ;
   private java.util.Date[] T006F10_A2245LegCuenLicPerFin ;
   private int[] T006F10_A2246LegCuenAntDias ;
   private short[] T006F10_A2299LegCuenAntAnios ;
   private short[] T006F10_A2300LegCuenAntMeses ;
   private short[] T006F10_A2247LegCuenDiasCorres ;
   private short[] T006F10_A2248LegCuenDiasGoz ;
   private short[] T006F10_A2249LegCuenDiasVig ;
   private String[] T006F10_A2301LegCueAntTexto ;
   private String[] T006F10_A2328LegCueAntAbr ;
   private short[] T006F10_A2302LegCuLiPCur ;
   private short[] T006F10_A2303LegCuLiPAnt ;
   private short[] T006F10_A2304LegCuLiPVen ;
   private short[] T006F10_A2305LegCuLiPSaldo ;
   private short[] T006F10_A2306LegCuLiPApr ;
   private short[] T006F10_A2307LegCuLiAprPGoce ;
   private boolean[] T006F10_A2321LegCuLIncluir ;
   private boolean[] T006F10_A2322LegCuLRecalc ;
   private String[] T006F10_A2329LegCuLLogDis ;
   private int[] T006F10_A3CliCod ;
   private short[] T006F10_A1EmpCod ;
   private int[] T006F10_A6LegNumero ;
   private String[] T006F21_A250LegIdNomApe ;
   private String[] T006F21_A251LegNombre ;
   private String[] T006F21_A230LegApellido ;
   private String[] T006F21_A93LegId ;
   private boolean[] T006F21_n93LegId ;
   private int[] T006F22_A3CliCod ;
   private short[] T006F22_A1EmpCod ;
   private int[] T006F22_A6LegNumero ;
   private String[] T006F22_A2243LegCuenLicTpo ;
   private short[] T006F22_A2266LegCuenAnio ;
   private String[] T006F23_A2243LegCuenLicTpo ;
   private short[] T006F23_A2266LegCuenAnio ;
   private java.util.Date[] T006F23_A2324LegCuLAprLicFch ;
   private String[] T006F23_A2326LegCuLAprLicOri ;
   private short[] T006F23_A2325LegCuLAprLicCnt ;
   private int[] T006F23_A3CliCod ;
   private short[] T006F23_A1EmpCod ;
   private int[] T006F23_A2341LegCuLAprLiqNro ;
   private boolean[] T006F23_n2341LegCuLAprLiqNro ;
   private int[] T006F23_A6LegNumero ;
   private int[] T006F8_A3CliCod ;
   private int[] T006F9_A3CliCod ;
   private int[] T006F24_A3CliCod ;
   private int[] T006F25_A3CliCod ;
   private int[] T006F26_A3CliCod ;
   private short[] T006F26_A1EmpCod ;
   private int[] T006F26_A6LegNumero ;
   private String[] T006F26_A2243LegCuenLicTpo ;
   private short[] T006F26_A2266LegCuenAnio ;
   private java.util.Date[] T006F26_A2324LegCuLAprLicFch ;
   private String[] T006F7_A2243LegCuenLicTpo ;
   private short[] T006F7_A2266LegCuenAnio ;
   private java.util.Date[] T006F7_A2324LegCuLAprLicFch ;
   private String[] T006F7_A2326LegCuLAprLicOri ;
   private short[] T006F7_A2325LegCuLAprLicCnt ;
   private int[] T006F7_A3CliCod ;
   private short[] T006F7_A1EmpCod ;
   private int[] T006F7_A2341LegCuLAprLiqNro ;
   private boolean[] T006F7_n2341LegCuLAprLiqNro ;
   private int[] T006F7_A6LegNumero ;
   private String[] T006F6_A2243LegCuenLicTpo ;
   private short[] T006F6_A2266LegCuenAnio ;
   private java.util.Date[] T006F6_A2324LegCuLAprLicFch ;
   private String[] T006F6_A2326LegCuLAprLicOri ;
   private short[] T006F6_A2325LegCuLAprLicCnt ;
   private int[] T006F6_A3CliCod ;
   private short[] T006F6_A1EmpCod ;
   private int[] T006F6_A2341LegCuLAprLiqNro ;
   private boolean[] T006F6_n2341LegCuLAprLiqNro ;
   private int[] T006F6_A6LegNumero ;
   private int[] T006F30_A3CliCod ;
   private short[] T006F30_A1EmpCod ;
   private int[] T006F30_A6LegNumero ;
   private String[] T006F30_A2243LegCuenLicTpo ;
   private short[] T006F30_A2266LegCuenAnio ;
   private java.util.Date[] T006F30_A2324LegCuLAprLicFch ;
   private String[] T006F31_A2243LegCuenLicTpo ;
   private short[] T006F31_A2266LegCuenAnio ;
   private short[] T006F31_A2310LegCuLConsAnio ;
   private short[] T006F31_A2311LegCuLConsSec ;
   private String[] T006F31_A2327LegCuLConsOri ;
   private short[] T006F31_A2312LegCuLConsCnt ;
   private int[] T006F31_A3CliCod ;
   private short[] T006F31_A1EmpCod ;
   private int[] T006F31_A2342LegCulConsLiqNro ;
   private boolean[] T006F31_n2342LegCulConsLiqNro ;
   private int[] T006F31_A6LegNumero ;
   private int[] T006F4_A3CliCod ;
   private int[] T006F5_A3CliCod ;
   private int[] T006F32_A3CliCod ;
   private int[] T006F33_A3CliCod ;
   private int[] T006F34_A3CliCod ;
   private short[] T006F34_A1EmpCod ;
   private int[] T006F34_A6LegNumero ;
   private String[] T006F34_A2243LegCuenLicTpo ;
   private short[] T006F34_A2266LegCuenAnio ;
   private short[] T006F34_A2310LegCuLConsAnio ;
   private short[] T006F34_A2311LegCuLConsSec ;
   private String[] T006F3_A2243LegCuenLicTpo ;
   private short[] T006F3_A2266LegCuenAnio ;
   private short[] T006F3_A2310LegCuLConsAnio ;
   private short[] T006F3_A2311LegCuLConsSec ;
   private String[] T006F3_A2327LegCuLConsOri ;
   private short[] T006F3_A2312LegCuLConsCnt ;
   private int[] T006F3_A3CliCod ;
   private short[] T006F3_A1EmpCod ;
   private int[] T006F3_A2342LegCulConsLiqNro ;
   private boolean[] T006F3_n2342LegCulConsLiqNro ;
   private int[] T006F3_A6LegNumero ;
   private String[] T006F2_A2243LegCuenLicTpo ;
   private short[] T006F2_A2266LegCuenAnio ;
   private short[] T006F2_A2310LegCuLConsAnio ;
   private short[] T006F2_A2311LegCuLConsSec ;
   private String[] T006F2_A2327LegCuLConsOri ;
   private short[] T006F2_A2312LegCuLConsCnt ;
   private int[] T006F2_A3CliCod ;
   private short[] T006F2_A1EmpCod ;
   private int[] T006F2_A2342LegCulConsLiqNro ;
   private boolean[] T006F2_n2342LegCulConsLiqNro ;
   private int[] T006F2_A6LegNumero ;
   private int[] T006F38_A3CliCod ;
   private short[] T006F38_A1EmpCod ;
   private int[] T006F38_A6LegNumero ;
   private String[] T006F38_A2243LegCuenLicTpo ;
   private short[] T006F38_A2266LegCuenAnio ;
   private short[] T006F38_A2310LegCuLConsAnio ;
   private short[] T006F38_A2311LegCuLConsSec ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV12WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV15TrnContext ;
}

final  class legajo_cuenta_licencias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T006F2", "SELECT LegCuenLicTpo, LegCuenAnio, LegCuLConsAnio, LegCuLConsSec, LegCuLConsOri, LegCuLConsCnt, CliCod, EmpCod, LegCulConsLiqNro, LegNumero FROM legajo_cuenta_licenciasconsumos WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLConsAnio = ? AND LegCuLConsSec = ?  FOR UPDATE OF legajo_cuenta_licenciasconsumos NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F3", "SELECT LegCuenLicTpo, LegCuenAnio, LegCuLConsAnio, LegCuLConsSec, LegCuLConsOri, LegCuLConsCnt, CliCod, EmpCod, LegCulConsLiqNro, LegNumero FROM legajo_cuenta_licenciasconsumos WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLConsAnio = ? AND LegCuLConsSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F4", "SELECT CliCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F5", "SELECT CliCod FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F6", "SELECT LegCuenLicTpo, LegCuenAnio, LegCuLAprLicFch, LegCuLAprLicOri, LegCuLAprLicCnt, CliCod, EmpCod, LegCuLAprLiqNro, LegNumero FROM legajo_cuenta_licenciasaprobaciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLAprLicFch = ?  FOR UPDATE OF legajo_cuenta_licenciasaprobaciones NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F7", "SELECT LegCuenLicTpo, LegCuenAnio, LegCuLAprLicFch, LegCuLAprLicOri, LegCuLAprLicCnt, CliCod, EmpCod, LegCuLAprLiqNro, LegNumero FROM legajo_cuenta_licenciasaprobaciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLAprLicFch = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F8", "SELECT CliCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F9", "SELECT CliCod FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F10", "SELECT LegCuenLicTpo, LegCuenAnio, LegCuLActVen, LegCuLTotCons, LegCuLTotCorr, LegCuenLicPerIni, LegCuenLicPerFin, LegCuenAntDias, LegCuenAntAnios, LegCuenAntMeses, LegCuenDiasCorres, LegCuenDiasGoz, LegCuenDiasVig, LegCueAntTexto, LegCueAntAbr, LegCuLiPCur, LegCuLiPAnt, LegCuLiPVen, LegCuLiPSaldo, LegCuLiPApr, LegCuLiAprPGoce, LegCuLIncluir, LegCuLRecalc, LegCuLLogDis, CliCod, EmpCod, LegNumero FROM legajo_cuenta_licencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ?  FOR UPDATE OF legajo_cuenta_licencias NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F11", "SELECT LegCuenLicTpo, LegCuenAnio, LegCuLActVen, LegCuLTotCons, LegCuLTotCorr, LegCuenLicPerIni, LegCuenLicPerFin, LegCuenAntDias, LegCuenAntAnios, LegCuenAntMeses, LegCuenDiasCorres, LegCuenDiasGoz, LegCuenDiasVig, LegCueAntTexto, LegCueAntAbr, LegCuLiPCur, LegCuLiPAnt, LegCuLiPVen, LegCuLiPSaldo, LegCuLiPApr, LegCuLiAprPGoce, LegCuLIncluir, LegCuLRecalc, LegCuLLogDis, CliCod, EmpCod, LegNumero FROM legajo_cuenta_licencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F12", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F13", "SELECT T2.LegIdNomApe, TM1.LegCuenLicTpo, TM1.LegCuenAnio, TM1.LegCuLActVen, TM1.LegCuLTotCons, TM1.LegCuLTotCorr, TM1.LegCuenLicPerIni, TM1.LegCuenLicPerFin, TM1.LegCuenAntDias, TM1.LegCuenAntAnios, TM1.LegCuenAntMeses, TM1.LegCuenDiasCorres, TM1.LegCuenDiasGoz, TM1.LegCuenDiasVig, TM1.LegCueAntTexto, TM1.LegCueAntAbr, TM1.LegCuLiPCur, TM1.LegCuLiPAnt, TM1.LegCuLiPVen, TM1.LegCuLiPSaldo, TM1.LegCuLiPApr, TM1.LegCuLiAprPGoce, TM1.LegCuLIncluir, TM1.LegCuLRecalc, TM1.LegCuLLogDis, T2.LegNombre, T2.LegApellido, T2.LegId, TM1.CliCod, TM1.EmpCod, TM1.LegNumero FROM (legajo_cuenta_licencias TM1 INNER JOIN Legajo T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod AND T2.LegNumero = TM1.LegNumero) WHERE TM1.LegCuenLicTpo = ( ?) and TM1.LegCuenAnio = ? and TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegCuenLicTpo, TM1.LegCuenAnio ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F14", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F15", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio FROM legajo_cuenta_licencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F16", "SELECT LegCuenLicTpo, LegCuenAnio, CliCod, EmpCod, LegNumero FROM legajo_cuenta_licencias WHERE ( LegCuenLicTpo > ( ?) or LegCuenLicTpo = ( ?) and LegCuenAnio > ? or LegCuenAnio = ? and LegCuenLicTpo = ( ?) and CliCod > ? or CliCod = ? and LegCuenAnio = ? and LegCuenLicTpo = ( ?) and EmpCod > ? or EmpCod = ? and CliCod = ? and LegCuenAnio = ? and LegCuenLicTpo = ( ?) and LegNumero > ?) ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T006F17", "SELECT LegCuenLicTpo, LegCuenAnio, CliCod, EmpCod, LegNumero FROM legajo_cuenta_licencias WHERE ( LegCuenLicTpo < ( ?) or LegCuenLicTpo = ( ?) and LegCuenAnio < ? or LegCuenAnio = ? and LegCuenLicTpo = ( ?) and CliCod < ? or CliCod = ? and LegCuenAnio = ? and LegCuenLicTpo = ( ?) and EmpCod < ? or EmpCod = ? and CliCod = ? and LegCuenAnio = ? and LegCuenLicTpo = ( ?) and LegNumero < ?) ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LegCuenLicTpo DESC, LegCuenAnio DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T006F18", "SAVEPOINT gxupdate;INSERT INTO legajo_cuenta_licencias(LegCuenLicTpo, LegCuenAnio, LegCuLActVen, LegCuLTotCons, LegCuLTotCorr, LegCuenLicPerIni, LegCuenLicPerFin, LegCuenAntDias, LegCuenAntAnios, LegCuenAntMeses, LegCuenDiasCorres, LegCuenDiasGoz, LegCuenDiasVig, LegCueAntTexto, LegCueAntAbr, LegCuLiPCur, LegCuLiPAnt, LegCuLiPVen, LegCuLiPSaldo, LegCuLiPApr, LegCuLiAprPGoce, LegCuLIncluir, LegCuLRecalc, LegCuLLogDis, CliCod, EmpCod, LegNumero) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006F19", "SAVEPOINT gxupdate;UPDATE legajo_cuenta_licencias SET LegCuLActVen=?, LegCuLTotCons=?, LegCuLTotCorr=?, LegCuenLicPerIni=?, LegCuenLicPerFin=?, LegCuenAntDias=?, LegCuenAntAnios=?, LegCuenAntMeses=?, LegCuenDiasCorres=?, LegCuenDiasGoz=?, LegCuenDiasVig=?, LegCueAntTexto=?, LegCueAntAbr=?, LegCuLiPCur=?, LegCuLiPAnt=?, LegCuLiPVen=?, LegCuLiPSaldo=?, LegCuLiPApr=?, LegCuLiAprPGoce=?, LegCuLIncluir=?, LegCuLRecalc=?, LegCuLLogDis=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006F20", "SAVEPOINT gxupdate;DELETE FROM legajo_cuenta_licencias  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T006F21", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F22", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio FROM legajo_cuenta_licencias ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F23", "SELECT LegCuenLicTpo, LegCuenAnio, LegCuLAprLicFch, LegCuLAprLicOri, LegCuLAprLicCnt, CliCod, EmpCod, LegCuLAprLiqNro, LegNumero FROM legajo_cuenta_licenciasaprobaciones WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? and LegCuLAprLicFch = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLAprLicFch ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F24", "SELECT CliCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F25", "SELECT CliCod FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F26", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLAprLicFch FROM legajo_cuenta_licenciasaprobaciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLAprLicFch = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T006F27", "SAVEPOINT gxupdate;INSERT INTO legajo_cuenta_licenciasaprobaciones(LegCuenLicTpo, LegCuenAnio, LegCuLAprLicFch, LegCuLAprLicOri, LegCuLAprLicCnt, CliCod, EmpCod, LegCuLAprLiqNro, LegNumero) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006F28", "SAVEPOINT gxupdate;UPDATE legajo_cuenta_licenciasaprobaciones SET LegCuLAprLicOri=?, LegCuLAprLicCnt=?, LegCuLAprLiqNro=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLAprLicFch = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006F29", "SAVEPOINT gxupdate;DELETE FROM legajo_cuenta_licenciasaprobaciones  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLAprLicFch = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T006F30", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLAprLicFch FROM legajo_cuenta_licenciasaprobaciones WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLAprLicFch ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F31", "SELECT LegCuenLicTpo, LegCuenAnio, LegCuLConsAnio, LegCuLConsSec, LegCuLConsOri, LegCuLConsCnt, CliCod, EmpCod, LegCulConsLiqNro, LegNumero FROM legajo_cuenta_licenciasconsumos WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? and LegCuLConsAnio = ? and LegCuLConsSec = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLConsAnio, LegCuLConsSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F32", "SELECT CliCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F33", "SELECT CliCod FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006F34", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLConsAnio, LegCuLConsSec FROM legajo_cuenta_licenciasconsumos WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLConsAnio = ? AND LegCuLConsSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T006F35", "SAVEPOINT gxupdate;INSERT INTO legajo_cuenta_licenciasconsumos(LegCuenLicTpo, LegCuenAnio, LegCuLConsAnio, LegCuLConsSec, LegCuLConsOri, LegCuLConsCnt, CliCod, EmpCod, LegCulConsLiqNro, LegNumero) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006F36", "SAVEPOINT gxupdate;UPDATE legajo_cuenta_licenciasconsumos SET LegCuLConsOri=?, LegCuLConsCnt=?, LegCulConsLiqNro=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLConsAnio = ? AND LegCuLConsSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006F37", "SAVEPOINT gxupdate;DELETE FROM legajo_cuenta_licenciasconsumos  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLConsAnio = ? AND LegCuLConsSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T006F38", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLConsAnio, LegCuLConsSec FROM legajo_cuenta_licenciasconsumos WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLConsAnio, LegCuLConsSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(10);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(10);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(9);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(9);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((short[]) buf[15])[0] = rslt.getShort(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((short[]) buf[18])[0] = rslt.getShort(19);
               ((short[]) buf[19])[0] = rslt.getShort(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((boolean[]) buf[21])[0] = rslt.getBoolean(22);
               ((boolean[]) buf[22])[0] = rslt.getBoolean(23);
               ((String[]) buf[23])[0] = rslt.getLongVarchar(24);
               ((int[]) buf[24])[0] = rslt.getInt(25);
               ((short[]) buf[25])[0] = rslt.getShort(26);
               ((int[]) buf[26])[0] = rslt.getInt(27);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((short[]) buf[15])[0] = rslt.getShort(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((short[]) buf[18])[0] = rslt.getShort(19);
               ((short[]) buf[19])[0] = rslt.getShort(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((boolean[]) buf[21])[0] = rslt.getBoolean(22);
               ((boolean[]) buf[22])[0] = rslt.getBoolean(23);
               ((String[]) buf[23])[0] = rslt.getLongVarchar(24);
               ((int[]) buf[24])[0] = rslt.getInt(25);
               ((short[]) buf[25])[0] = rslt.getShort(26);
               ((int[]) buf[26])[0] = rslt.getInt(27);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((String[]) buf[14])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((short[]) buf[18])[0] = rslt.getShort(19);
               ((short[]) buf[19])[0] = rslt.getShort(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((short[]) buf[21])[0] = rslt.getShort(22);
               ((boolean[]) buf[22])[0] = rslt.getBoolean(23);
               ((boolean[]) buf[23])[0] = rslt.getBoolean(24);
               ((String[]) buf[24])[0] = rslt.getLongVarchar(25);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((String[]) buf[26])[0] = rslt.getVarchar(27);
               ((String[]) buf[27])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((int[]) buf[29])[0] = rslt.getInt(29);
               ((short[]) buf[30])[0] = rslt.getShort(30);
               ((int[]) buf[31])[0] = rslt.getInt(31);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(9);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 24 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               return;
            case 28 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               return;
            case 29 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((int[]) buf[10])[0] = rslt.getInt(10);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 31 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 32 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 36 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
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
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               stmt.setInt(4, ((Number) parms[4]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
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
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               stmt.setInt(4, ((Number) parms[4]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 14 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setInt(12, ((Number) parms[11]).intValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setString(14, (String)parms[13], 20);
               stmt.setInt(15, ((Number) parms[14]).intValue());
               return;
            case 15 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setInt(12, ((Number) parms[11]).intValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setString(14, (String)parms[13], 20);
               stmt.setInt(15, ((Number) parms[14]).intValue());
               return;
            case 16 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setDate(7, (java.util.Date)parms[6]);
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setNLongVarchar(14, (String)parms[13], false);
               stmt.setVarchar(15, (String)parms[14], 40, false);
               stmt.setShort(16, ((Number) parms[15]).shortValue());
               stmt.setShort(17, ((Number) parms[16]).shortValue());
               stmt.setShort(18, ((Number) parms[17]).shortValue());
               stmt.setShort(19, ((Number) parms[18]).shortValue());
               stmt.setShort(20, ((Number) parms[19]).shortValue());
               stmt.setShort(21, ((Number) parms[20]).shortValue());
               stmt.setBoolean(22, ((Boolean) parms[21]).booleanValue());
               stmt.setBoolean(23, ((Boolean) parms[22]).booleanValue());
               stmt.setNLongVarchar(24, (String)parms[23], false);
               stmt.setInt(25, ((Number) parms[24]).intValue());
               stmt.setShort(26, ((Number) parms[25]).shortValue());
               stmt.setInt(27, ((Number) parms[26]).intValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setNLongVarchar(12, (String)parms[11], false);
               stmt.setVarchar(13, (String)parms[12], 40, false);
               stmt.setShort(14, ((Number) parms[13]).shortValue());
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               stmt.setShort(16, ((Number) parms[15]).shortValue());
               stmt.setShort(17, ((Number) parms[16]).shortValue());
               stmt.setShort(18, ((Number) parms[17]).shortValue());
               stmt.setShort(19, ((Number) parms[18]).shortValue());
               stmt.setBoolean(20, ((Boolean) parms[19]).booleanValue());
               stmt.setBoolean(21, ((Boolean) parms[20]).booleanValue());
               stmt.setNLongVarchar(22, (String)parms[21], false);
               stmt.setInt(23, ((Number) parms[22]).intValue());
               stmt.setShort(24, ((Number) parms[23]).shortValue());
               stmt.setInt(25, ((Number) parms[24]).intValue());
               stmt.setString(26, (String)parms[25], 20);
               stmt.setShort(27, ((Number) parms[26]).shortValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               stmt.setInt(4, ((Number) parms[4]).intValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
            case 25 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(8, ((Number) parms[8]).intValue());
               }
               stmt.setInt(9, ((Number) parms[9]).intValue());
               return;
            case 26 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setShort(5, ((Number) parms[5]).shortValue());
               stmt.setInt(6, ((Number) parms[6]).intValue());
               stmt.setString(7, (String)parms[7], 20);
               stmt.setShort(8, ((Number) parms[8]).shortValue());
               stmt.setDate(9, (java.util.Date)parms[9]);
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               stmt.setInt(4, ((Number) parms[4]).intValue());
               return;
            case 32 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 33 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(9, ((Number) parms[9]).intValue());
               }
               stmt.setInt(10, ((Number) parms[10]).intValue());
               return;
            case 34 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setShort(5, ((Number) parms[5]).shortValue());
               stmt.setInt(6, ((Number) parms[6]).intValue());
               stmt.setString(7, (String)parms[7], 20);
               stmt.setShort(8, ((Number) parms[8]).shortValue());
               stmt.setShort(9, ((Number) parms[9]).shortValue());
               stmt.setShort(10, ((Number) parms[10]).shortValue());
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 36 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
      }
   }

}

