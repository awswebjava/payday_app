package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class liquidacionlegajowc_impl extends GXWebComponent
{
   public liquidacionlegajowc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public liquidacionlegajowc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionlegajowc_impl.class ));
   }

   public liquidacionlegajowc_impl( int remoteHandle ,
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
      chkavErroresver = UIFactory.getCheckbox(this);
      cmbavGridactiongroup1 = new HTMLChoice();
      cmbLiqLegAuxEstado = new HTMLChoice();
      cmbLiqLegPDFEstado = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "MenuOpcCod") ;
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
               AV134MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV134MenuOpcCod", AV134MenuOpcCod);
               AV88CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV88CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV88CliCod), 6, 0));
               AV7EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7EmpCod), 4, 0));
               AV17LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17LiqNro), 8, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV134MenuOpcCod,Integer.valueOf(AV88CliCod),Short.valueOf(AV7EmpCod),Integer.valueOf(AV17LiqNro)});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
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
               gxfirstwebparm = httpContext.GetFirstPar( "MenuOpcCod") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "MenuOpcCod") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
            {
               gxnrgrid_newrow_invoke( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid") == 0 )
            {
               gxgrgrid_refresh_invoke( ) ;
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
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void gxnrgrid_newrow_invoke( )
   {
      nRC_GXsfl_77 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_77"))) ;
      nGXsfl_77_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_77_idx"))) ;
      sGXsfl_77_idx = httpContext.GetPar( "sGXsfl_77_idx") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgrid_newrow( ) ;
      /* End function gxnrGrid_newrow_invoke */
   }

   public void gxgrgrid_refresh_invoke( )
   {
      subGrid_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid_Rows"))) ;
      AV88CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV7EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV17LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
      AV163Pgmname = httpContext.GetPar( "Pgmname") ;
      AV153ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV85ColumnsSelector);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV12GridState);
      AV92OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV19OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV110TFLiqLegImpBasico = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpBasico"), ".") ;
      AV111TFLiqLegImpBasico_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpBasico_To"), ".") ;
      AV93TFLiqLegImpTotBruto = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpTotBruto"), ".") ;
      AV94TFLiqLegImpTotBruto_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpTotBruto_To"), ".") ;
      AV108TFLiqLegImpTotBruSinSAC = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpTotBruSinSAC"), ".") ;
      AV109TFLiqLegImpTotBruSinSAC_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpTotBruSinSAC_To"), ".") ;
      AV102TFLiqLegImpTotRetGan = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpTotRetGan"), ".") ;
      AV103TFLiqLegImpTotRetGan_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpTotRetGan_To"), ".") ;
      AV132TFLiqLegError = httpContext.GetPar( "TFLiqLegError") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV133TFLiqLegError_Sels);
      AV140TFLiqLegErrorAux = httpContext.GetPar( "TFLiqLegErrorAux") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV141TFLiqLegErrorAux_Sels);
      AV121TFLiqLegImpContr = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpContr"), ".") ;
      AV122TFLiqLegImpContr_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpContr_To"), ".") ;
      AV125TFLIqLegIteraciones = (short)(GXutil.lval( httpContext.GetPar( "TFLIqLegIteraciones"))) ;
      AV126TFLIqLegIteraciones_To = (short)(GXutil.lval( httpContext.GetPar( "TFLIqLegIteraciones_To"))) ;
      AV127TFLiqLegSegundos = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegSegundos"), ".") ;
      AV128TFLiqLegSegundos_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegSegundos_To"), ".") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV143TFLiqLegAuxEstado_Sels);
      AV134MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      AV130IsAuthorized_Ajustes = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Ajustes")) ;
      AV138LiquidacionAjustesPalabra = httpContext.GetPar( "LiquidacionAjustesPalabra") ;
      AV137IsAuthorized_Display = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Display")) ;
      AV160IsAuthorized_LegHtml = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_LegHtml")) ;
      AV148ErroresVer = GXutil.strtobool( httpContext.GetPar( "ErroresVer")) ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      A31LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV88CliCod, AV7EmpCod, AV17LiqNro, AV163Pgmname, AV153ManageFiltersExecutionStep, AV85ColumnsSelector, AV12GridState, AV92OrderedBy, AV19OrderedDsc, AV110TFLiqLegImpBasico, AV111TFLiqLegImpBasico_To, AV93TFLiqLegImpTotBruto, AV94TFLiqLegImpTotBruto_To, AV108TFLiqLegImpTotBruSinSAC, AV109TFLiqLegImpTotBruSinSAC_To, AV102TFLiqLegImpTotRetGan, AV103TFLiqLegImpTotRetGan_To, AV132TFLiqLegError, AV133TFLiqLegError_Sels, AV140TFLiqLegErrorAux, AV141TFLiqLegErrorAux_Sels, AV121TFLiqLegImpContr, AV122TFLiqLegImpContr_To, AV125TFLIqLegIteraciones, AV126TFLIqLegIteraciones_To, AV127TFLiqLegSegundos, AV128TFLiqLegSegundos_To, AV143TFLiqLegAuxEstado_Sels, AV134MenuOpcCod, AV130IsAuthorized_Ajustes, AV138LiquidacionAjustesPalabra, AV137IsAuthorized_Display, AV160IsAuthorized_LegHtml, AV148ErroresVer, A3CliCod, A1EmpCod, A31LiqNro, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa512( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  httpContext.sendError( 404 );
                  GXutil.writeLog("send_http_error_code 404");
                  GxWebError = (byte)(1) ;
               }
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            if ( nDynComponent == 0 )
            {
               throw new RuntimeException("WebComponent is not allowed to run");
            }
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
         httpContext.writeValue( httpContext.getMessage( "Liquidacion Legajo WC", "")) ;
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
      httpContext.AddJavascriptSource("UserControls/A3LClonEventRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LFilterRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("Window/InNewWindowRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.liquidacionlegajowc", new String[] {GXutil.URLEncode(GXutil.rtrim(AV134MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(AV88CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV7EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV17LiqNro,8,0))}, new String[] {"MenuOpcCod","CliCod","EmpCod","LiqNro"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV163Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_AJUSTES", getSecureSignedToken( sPrefix, AV130IsAuthorized_Ajustes));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQUIDACIONAJUSTESPALABRA", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV138LiquidacionAjustesPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( sPrefix, AV137IsAuthorized_Display));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_LEGHTML", getSecureSignedToken( sPrefix, AV160IsAuthorized_LegHtml));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_CLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_EMPCOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQNRO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_77", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_77, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV5DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV5DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCOLUMNSSELECTOR", AV85ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCOLUMNSSELECTOR", AV85ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vMANAGEFILTERSDATA", AV151ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vMANAGEFILTERSDATA", AV151ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV10GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV11GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDAPPLIEDFILTERS", AV9GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV134MenuOpcCod", wcpOAV134MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV88CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV88CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV7EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOAV7EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV17LiqNro", GXutil.ltrim( localUtil.ntoc( wcpOAV17LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV88CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV163Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV163Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV153ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vGRIDSTATE", AV12GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV92OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV19OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPBASICO", GXutil.ltrim( localUtil.ntoc( AV110TFLiqLegImpBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPBASICO_TO", GXutil.ltrim( localUtil.ntoc( AV111TFLiqLegImpBasico_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPTOTBRUTO", GXutil.ltrim( localUtil.ntoc( AV93TFLiqLegImpTotBruto, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPTOTBRUTO_TO", GXutil.ltrim( localUtil.ntoc( AV94TFLiqLegImpTotBruto_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPTOTBRUSINSAC", GXutil.ltrim( localUtil.ntoc( AV108TFLiqLegImpTotBruSinSAC, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPTOTBRUSINSAC_TO", GXutil.ltrim( localUtil.ntoc( AV109TFLiqLegImpTotBruSinSAC_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPTOTRETGAN", GXutil.ltrim( localUtil.ntoc( AV102TFLiqLegImpTotRetGan, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPTOTRETGAN_TO", GXutil.ltrim( localUtil.ntoc( AV103TFLiqLegImpTotRetGan_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGERROR", AV132TFLiqLegError);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLIQLEGERROR_SELS", AV133TFLiqLegError_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLIQLEGERROR_SELS", AV133TFLiqLegError_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGERRORAUX", AV140TFLiqLegErrorAux);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLIQLEGERRORAUX_SELS", AV141TFLiqLegErrorAux_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLIQLEGERRORAUX_SELS", AV141TFLiqLegErrorAux_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPCONTR", GXutil.ltrim( localUtil.ntoc( AV121TFLiqLegImpContr, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPCONTR_TO", GXutil.ltrim( localUtil.ntoc( AV122TFLiqLegImpContr_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGITERACIONES", GXutil.ltrim( localUtil.ntoc( AV125TFLIqLegIteraciones, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGITERACIONES_TO", GXutil.ltrim( localUtil.ntoc( AV126TFLIqLegIteraciones_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGSEGUNDOS", GXutil.ltrim( localUtil.ntoc( AV127TFLiqLegSegundos, (byte)(10), (byte)(6), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGSEGUNDOS_TO", GXutil.ltrim( localUtil.ntoc( AV128TFLiqLegSegundos_To, (byte)(10), (byte)(6), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLIQLEGAUXESTADO_SELS", AV143TFLiqLegAuxEstado_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLIQLEGAUXESTADO_SELS", AV143TFLiqLegAuxEstado_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMENUOPCCOD", AV134MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV7EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLIQNRO", GXutil.ltrim( localUtil.ntoc( AV17LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LIQESTADO", GXutil.ltrim( localUtil.ntoc( A278LiqEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_AJUSTES", AV130IsAuthorized_Ajustes);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_AJUSTES", getSecureSignedToken( sPrefix, AV130IsAuthorized_Ajustes));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLIQUIDACIONAJUSTESPALABRA", GXutil.rtrim( AV138LiquidacionAjustesPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQUIDACIONAJUSTESPALABRA", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV138LiquidacionAjustesPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_CLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_EMPCOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LIQNRO", GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQNRO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DISPLAY", AV137IsAuthorized_Display);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( sPrefix, AV137IsAuthorized_Display));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_LEGHTML", AV160IsAuthorized_LegHtml);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_LEGHTML", getSecureSignedToken( sPrefix, AV160IsAuthorized_LegHtml));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LIQLEGIMPOTRDESCU", GXutil.ltrim( localUtil.ntoc( A1131LiqLegImpOtrDescu, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGERROR_SELSJSON", AV131TFLiqLegError_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGERRORAUX_SELSJSON", AV139TFLiqLegErrorAux_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGAUXESTADO_SELSJSON", AV142TFLiqLegAuxEstado_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD_SELECTED", GXutil.ltrim( localUtil.ntoc( AV113CliCod_Selected, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD_SELECTED", GXutil.ltrim( localUtil.ntoc( AV8EmpCod_Selected, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLIQNRO_SELECTED", GXutil.ltrim( localUtil.ntoc( AV18LiqNro_Selected, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLEGNUMERO_SELECTED", GXutil.ltrim( localUtil.ntoc( AV16LegNumero_Selected, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vLIQLEGERROR", AV146LiqLegError);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vLIQLEGERROR", AV146LiqLegError);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"BUTTONEXPORT1_A3LEXPORT_Observer", GXutil.rtrim( Buttonexport1_a3lexport_Observer));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"BUTTONEXPORT1_A3LEXPORT_Boton_clon_id", GXutil.rtrim( Buttonexport1_a3lexport_Boton_clon_id));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"BUTTONEXPORT1_A3LEXPORT_Boton_orig_id", GXutil.rtrim( Buttonexport1_a3lexport_Boton_orig_id));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Icontype", GXutil.rtrim( Ddo_gridcolumnsselector_Icontype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Icon", GXutil.rtrim( Ddo_gridcolumnsselector_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Caption", GXutil.rtrim( Ddo_gridcolumnsselector_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Tooltip", GXutil.rtrim( Ddo_gridcolumnsselector_Tooltip));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Cls", GXutil.rtrim( Ddo_gridcolumnsselector_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype", GXutil.rtrim( Ddo_gridcolumnsselector_Dropdownoptionstype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Gridinternalname", GXutil.rtrim( Ddo_gridcolumnsselector_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Icontype", GXutil.rtrim( Ddo_managefilters_Icontype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Icon", GXutil.rtrim( Ddo_managefilters_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Tooltip", GXutil.rtrim( Ddo_managefilters_Tooltip));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Cls", GXutil.rtrim( Ddo_managefilters_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"BUTTONFILTER1_A3LFILTER_Observer", GXutil.rtrim( Buttonfilter1_a3lfilter_Observer));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"BUTTONFILTER1_A3LFILTER_A3l_filter_id", GXutil.rtrim( Buttonfilter1_a3lfilter_A3l_filter_id));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"BUTTONFILTER1_A3LFILTER_Filter_orig", GXutil.rtrim( Buttonfilter1_a3lfilter_Filter_orig));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Class", GXutil.rtrim( Gridpaginationbar_Class));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridpaginationbar_Showfirst));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridpaginationbar_Showprevious));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Shownext", GXutil.booltostr( Gridpaginationbar_Shownext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Showlast", GXutil.booltostr( Gridpaginationbar_Showlast));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridpaginationbar_Pagingbuttonsposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridpaginationbar_Pagingcaptionposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridpaginationbar_Emptygridclass));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridpaginationbar_Rowsperpageselector));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridpaginationbar_Rowsperpageoptions));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridpaginationbar_Rowsperpagecaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"INNEWWINDOW1_Target", GXutil.rtrim( Innewwindow1_Target));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_set", GXutil.rtrim( Ddo_grid_Filteredtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtextto_set", GXutil.rtrim( Ddo_grid_Filteredtextto_set));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Fixable", GXutil.rtrim( Ddo_grid_Fixable));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filterisrange", GXutil.rtrim( Ddo_grid_Filterisrange));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalistfixedvalues", GXutil.rtrim( Ddo_grid_Datalistfixedvalues));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Format", GXutil.rtrim( Ddo_grid_Format));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO_Title", GXutil.rtrim( Dvelop_confirmpanel_eliminarlegajo_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_eliminarlegajo_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminarlegajo_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminarlegajo_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminarlegajo_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_eliminarlegajo_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_eliminarlegajo_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Hascolumnsselector", GXutil.booltostr( Grid_empowerer_Hascolumnsselector));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO_Result", GXutil.rtrim( Dvelop_confirmpanel_eliminarlegajo_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO_Result", GXutil.rtrim( Dvelop_confirmpanel_eliminarlegajo_Result));
   }

   public void renderHtmlCloseForm512( )
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
      return "LiquidacionLegajoWC" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Liquidacion Legajo WC", "") ;
   }

   public void wb510( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.liquidacionlegajowc");
            httpContext.AddJavascriptSource("UserControls/A3LClonEventRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("UserControls/A3LFilterRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
            httpContext.AddJavascriptSource("Window/InNewWindowRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
         }
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablegridheader_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MT10", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableheadercontent_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         wb_table1_14_512( true) ;
      }
      else
      {
         wb_table1_14_512( false) ;
      }
      return  ;
   }

   public void wb_table1_14_512e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableliqerror_Internalname, 1, 0, "px", 0, "px", "TableLiqError", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecheck_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavErroresver.getInternalname(), httpContext.getMessage( "Errores Ver", ""), "gx-form-item AttributeCheckBoxLabel", 0, true, "width: 25%;");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'" + sPrefix + "',false,'" + sGXsfl_77_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavErroresver.getInternalname(), GXutil.booltostr( AV148ErroresVer), "", httpContext.getMessage( "Errores Ver", ""), chkavErroresver.getVisible(), chkavErroresver.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(30, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,30);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablelabel_Internalname, 1, 0, "px", 0, "px", "TableLabel", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, httpContext.getMessage( "Ver liq. con error", ""), "", "", lblTextblock1_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextOptionMenuIzq_new PT10", 0, "", lblTextblock1_Visible, 1, 0, (short)(0), "HLP_LiquidacionLegajoWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_tablecontentbuttonimport_Internalname, 1, 0, "px", 0, "px", "TableContentButtonImport", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_table_svg_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_LiquidacionLegajoWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_table_texto_Internalname, 1, 0, "px", 0, "px", "ML10", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionLegajoWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* User Defined Control */
         ucButtonexport1_a3lexport.render(context, "a3lclonevent", Buttonexport1_a3lexport_Internalname, sPrefix+"BUTTONEXPORT1_A3LEXPORTContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("IconType", Ddo_gridcolumnsselector_Icontype);
         ucDdo_gridcolumnsselector.setProperty("Icon", Ddo_gridcolumnsselector_Icon);
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV5DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV85ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, sPrefix+"DDO_GRIDCOLUMNSSELECTORContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV151ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, sPrefix+"DDO_MANAGEFILTERSContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 77, 2, 0)+","+"null"+");", httpContext.getMessage( "WWP_ExportCaption", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionLegajoWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_tablecontent_Internalname, divButtonfilter1_tablecontent_Visible, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* User Defined Control */
         ucButtonfilter1_a3lfilter.render(context, "a3lfilter", Buttonfilter1_a3lfilter_Internalname, sPrefix+"BUTTONFILTER1_A3LFILTERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilters1_filtros_Internalname, 1, 0, "px", 0, "px", "TableContentButtonImportFiltros", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilters1_table_svg_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilters1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilters1_textblock_svg_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_LiquidacionLegajoWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilters1_table_texto_Internalname, 1, 0, "px", 0, "px", "ML10", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilters1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilters1_textblock_texto_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionLegajoWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table2_68_512( true) ;
      }
      else
      {
         wb_table2_68_512( false) ;
      }
      return  ;
   }

   public void wb_table2_68_512e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol77( ) ;
      }
      if ( wbEnd == 77 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_77 = (int)(nGXsfl_77_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grid", GridContainer, subGrid_Internalname);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridpaginationbar.setProperty("Class", Gridpaginationbar_Class);
         ucGridpaginationbar.setProperty("ShowFirst", Gridpaginationbar_Showfirst);
         ucGridpaginationbar.setProperty("ShowPrevious", Gridpaginationbar_Showprevious);
         ucGridpaginationbar.setProperty("ShowNext", Gridpaginationbar_Shownext);
         ucGridpaginationbar.setProperty("ShowLast", Gridpaginationbar_Showlast);
         ucGridpaginationbar.setProperty("PagesToShow", Gridpaginationbar_Pagestoshow);
         ucGridpaginationbar.setProperty("PagingButtonsPosition", Gridpaginationbar_Pagingbuttonsposition);
         ucGridpaginationbar.setProperty("PagingCaptionPosition", Gridpaginationbar_Pagingcaptionposition);
         ucGridpaginationbar.setProperty("EmptyGridClass", Gridpaginationbar_Emptygridclass);
         ucGridpaginationbar.setProperty("RowsPerPageSelector", Gridpaginationbar_Rowsperpageselector);
         ucGridpaginationbar.setProperty("RowsPerPageOptions", Gridpaginationbar_Rowsperpageoptions);
         ucGridpaginationbar.setProperty("Previous", Gridpaginationbar_Previous);
         ucGridpaginationbar.setProperty("Next", Gridpaginationbar_Next);
         ucGridpaginationbar.setProperty("Caption", Gridpaginationbar_Caption);
         ucGridpaginationbar.setProperty("EmptyGridCaption", Gridpaginationbar_Emptygridcaption);
         ucGridpaginationbar.setProperty("RowsPerPageCaption", Gridpaginationbar_Rowsperpagecaption);
         ucGridpaginationbar.setProperty("CurrentPage", AV10GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV11GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV9GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, sPrefix+"GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, sPrefix+"INNEWWINDOW1Container");
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
         /* User Defined Control */
         ucDdo_grid.setProperty("Caption", Ddo_grid_Caption);
         ucDdo_grid.setProperty("ColumnIds", Ddo_grid_Columnids);
         ucDdo_grid.setProperty("ColumnsSortValues", Ddo_grid_Columnssortvalues);
         ucDdo_grid.setProperty("IncludeSortASC", Ddo_grid_Includesortasc);
         ucDdo_grid.setProperty("Fixable", Ddo_grid_Fixable);
         ucDdo_grid.setProperty("IncludeFilter", Ddo_grid_Includefilter);
         ucDdo_grid.setProperty("FilterType", Ddo_grid_Filtertype);
         ucDdo_grid.setProperty("FilterIsRange", Ddo_grid_Filterisrange);
         ucDdo_grid.setProperty("IncludeDataList", Ddo_grid_Includedatalist);
         ucDdo_grid.setProperty("DataListType", Ddo_grid_Datalisttype);
         ucDdo_grid.setProperty("AllowMultipleSelection", Ddo_grid_Allowmultipleselection);
         ucDdo_grid.setProperty("DataListFixedValues", Ddo_grid_Datalistfixedvalues);
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("Format", Ddo_grid_Format);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV5DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         wb_table3_116_512( true) ;
      }
      else
      {
         wb_table3_116_512( false) ;
      }
      return  ;
   }

   public void wb_table3_116_512e( boolean wbgen )
   {
      if ( wbgen )
      {
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, sPrefix+"GRID_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 77 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grid", GridContainer, subGrid_Internalname);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start512( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
            }
            Form.getMeta().addItem("description", httpContext.getMessage( "Liquidacion Legajo WC", ""), (short)(0)) ;
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
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strup510( ) ;
         }
      }
   }

   public void ws512( )
   {
      start512( ) ;
      evt512( ) ;
   }

   public void evt512( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
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
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup510( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup510( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e11512 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup510( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e12512 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup510( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e13512 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup510( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e14512 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup510( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e15512 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_ELIMINARLEGAJO.CLOSE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup510( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e16512 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup510( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoExport' */
                                 e17512 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VERRORESVER.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup510( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e18512 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup510( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavEliminarlegajo_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 23), "VGRIDACTIONGROUP1.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 23), "VGRIDACTIONGROUP1.CLICK") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup510( ) ;
                           }
                           nGXsfl_77_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_77_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_77_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_772( ) ;
                           AV6EliminarLegajo = httpContext.cgiGet( edtavEliminarlegajo_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEliminarlegajo_Internalname, AV6EliminarLegajo);
                           A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           AV159LegHtml = httpContext.cgiGet( edtavLeghtml_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavLeghtml_Internalname, AV159LegHtml);
                           cmbavGridactiongroup1.setName( cmbavGridactiongroup1.getInternalname() );
                           cmbavGridactiongroup1.setValue( httpContext.cgiGet( cmbavGridactiongroup1.getInternalname()) );
                           AV87GridActionGroup1 = (short)(GXutil.lval( httpContext.cgiGet( cmbavGridactiongroup1.getInternalname()))) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, cmbavGridactiongroup1.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV87GridActionGroup1), 4, 0));
                           A250LegIdNomApe = httpContext.cgiGet( edtLegIdNomApe_Internalname) ;
                           A760LiqLegImpBasico = localUtil.ctond( httpContext.cgiGet( edtLiqLegImpBasico_Internalname)) ;
                           A758LiqLegImpTotBruProm = localUtil.ctond( httpContext.cgiGet( edtLiqLegImpTotBruProm_Internalname)) ;
                           A498LiqLegImpTotBruto = localUtil.ctond( httpContext.cgiGet( edtLiqLegImpTotBruto_Internalname)) ;
                           A281LiqLegImpTotal = localUtil.ctond( httpContext.cgiGet( edtLiqLegImpTotal_Internalname)) ;
                           A759LiqLegImpTotBruSinSAC = localUtil.ctond( httpContext.cgiGet( edtLiqLegImpTotBruSinSAC_Internalname)) ;
                           A579LiqLegImpTotDescu = localUtil.ctond( httpContext.cgiGet( edtLiqLegImpTotDescu_Internalname)) ;
                           A757LiqLegImpTotRetGan = localUtil.ctond( httpContext.cgiGet( edtLiqLegImpTotRetGan_Internalname)) ;
                           if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavLiqlegimpotrdescu_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavLiqlegimpotrdescu_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
                           {
                              httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vLIQLEGIMPOTRDESCU");
                              GX_FocusControl = edtavLiqlegimpotrdescu_Internalname ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              wbErr = true ;
                              AV120LiqLegImpOtrDescu = DecimalUtil.ZERO ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavLiqlegimpotrdescu_Internalname, GXutil.ltrimstr( AV120LiqLegImpOtrDescu, 14, 2));
                           }
                           else
                           {
                              AV120LiqLegImpOtrDescu = localUtil.ctond( httpContext.cgiGet( edtavLiqlegimpotrdescu_Internalname)) ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavLiqlegimpotrdescu_Internalname, GXutil.ltrimstr( AV120LiqLegImpOtrDescu, 14, 2));
                           }
                           if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavLiqlegimptotdescu_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavLiqlegimptotdescu_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
                           {
                              httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vLIQLEGIMPTOTDESCU");
                              GX_FocusControl = edtavLiqlegimptotdescu_Internalname ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              wbErr = true ;
                              AV106LiqLegImpTotDescu = DecimalUtil.ZERO ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavLiqlegimptotdescu_Internalname, GXutil.ltrimstr( AV106LiqLegImpTotDescu, 14, 2));
                           }
                           else
                           {
                              AV106LiqLegImpTotDescu = localUtil.ctond( httpContext.cgiGet( edtavLiqlegimptotdescu_Internalname)) ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavLiqlegimptotdescu_Internalname, GXutil.ltrimstr( AV106LiqLegImpTotDescu, 14, 2));
                           }
                           A891LiqLegError = httpContext.cgiGet( edtLiqLegError_Internalname) ;
                           A1781LiqLegErrorAux = httpContext.cgiGet( edtLiqLegErrorAux_Internalname) ;
                           A239LegCUIL = localUtil.ctol( httpContext.cgiGet( edtLegCUIL_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A590LiqRutaPDF = httpContext.cgiGet( edtLiqRutaPDF_Internalname) ;
                           A774LiqRutaPDFVertical = httpContext.cgiGet( edtLiqRutaPDFVertical_Internalname) ;
                           A1157LiqLegImpContr = localUtil.ctond( httpContext.cgiGet( edtLiqLegImpContr_Internalname)) ;
                           A1158LiqLegImpCosto = localUtil.ctond( httpContext.cgiGet( edtLiqLegImpCosto_Internalname)) ;
                           A883LIqLegIteraciones = (short)(localUtil.ctol( httpContext.cgiGet( edtLIqLegIteraciones_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A884LiqLegSegundos = localUtil.ctond( httpContext.cgiGet( edtLiqLegSegundos_Internalname)) ;
                           cmbLiqLegAuxEstado.setName( cmbLiqLegAuxEstado.getInternalname() );
                           cmbLiqLegAuxEstado.setValue( httpContext.cgiGet( cmbLiqLegAuxEstado.getInternalname()) );
                           A1780LiqLegAuxEstado = (byte)(GXutil.lval( httpContext.cgiGet( cmbLiqLegAuxEstado.getInternalname()))) ;
                           cmbLiqLegPDFEstado.setName( cmbLiqLegPDFEstado.getInternalname() );
                           cmbLiqLegPDFEstado.setValue( httpContext.cgiGet( cmbLiqLegPDFEstado.getInternalname()) );
                           A2179LiqLegPDFEstado = httpContext.cgiGet( cmbLiqLegPDFEstado.getInternalname()) ;
                           n2179LiqLegPDFEstado = false ;
                           AV129Ajustes = httpContext.cgiGet( edtavAjustes_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavAjustes_Internalname, AV129Ajustes);
                           AV136Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplay_Internalname, AV136Display);
                           AV135VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavVersvg_Internalname, AV135VerSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavEliminarlegajo_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e19512 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavEliminarlegajo_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Refresh */
                                       e20512 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavEliminarlegajo_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e21512 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "VGRIDACTIONGROUP1.CLICK") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavEliminarlegajo_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e22512 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       if ( ! wbErr )
                                       {
                                          Rfr0gs = false ;
                                          if ( ! Rfr0gs )
                                          {
                                          }
                                          dynload_actions( ) ;
                                       }
                                    }
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strup510( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavEliminarlegajo_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                    }
                                 }
                              }
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we512( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm512( ) ;
         }
      }
   }

   public void pa512( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
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
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = chkavErroresver.getInternalname() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgrid_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_772( ) ;
      while ( nGXsfl_77_idx <= nRC_GXsfl_77 )
      {
         sendrow_772( ) ;
         nGXsfl_77_idx = ((subGrid_Islastpage==1)&&(nGXsfl_77_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_77_idx+1) ;
         sGXsfl_77_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_77_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_772( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 int AV88CliCod ,
                                 short AV7EmpCod ,
                                 int AV17LiqNro ,
                                 String AV163Pgmname ,
                                 byte AV153ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV85ColumnsSelector ,
                                 web.wwpbaseobjects.SdtWWPGridState AV12GridState ,
                                 short AV92OrderedBy ,
                                 boolean AV19OrderedDsc ,
                                 java.math.BigDecimal AV110TFLiqLegImpBasico ,
                                 java.math.BigDecimal AV111TFLiqLegImpBasico_To ,
                                 java.math.BigDecimal AV93TFLiqLegImpTotBruto ,
                                 java.math.BigDecimal AV94TFLiqLegImpTotBruto_To ,
                                 java.math.BigDecimal AV108TFLiqLegImpTotBruSinSAC ,
                                 java.math.BigDecimal AV109TFLiqLegImpTotBruSinSAC_To ,
                                 java.math.BigDecimal AV102TFLiqLegImpTotRetGan ,
                                 java.math.BigDecimal AV103TFLiqLegImpTotRetGan_To ,
                                 String AV132TFLiqLegError ,
                                 GXSimpleCollection<String> AV133TFLiqLegError_Sels ,
                                 String AV140TFLiqLegErrorAux ,
                                 GXSimpleCollection<String> AV141TFLiqLegErrorAux_Sels ,
                                 java.math.BigDecimal AV121TFLiqLegImpContr ,
                                 java.math.BigDecimal AV122TFLiqLegImpContr_To ,
                                 short AV125TFLIqLegIteraciones ,
                                 short AV126TFLIqLegIteraciones_To ,
                                 java.math.BigDecimal AV127TFLiqLegSegundos ,
                                 java.math.BigDecimal AV128TFLiqLegSegundos_To ,
                                 GXSimpleCollection<Byte> AV143TFLiqLegAuxEstado_Sels ,
                                 String AV134MenuOpcCod ,
                                 boolean AV130IsAuthorized_Ajustes ,
                                 String AV138LiquidacionAjustesPalabra ,
                                 boolean AV137IsAuthorized_Display ,
                                 boolean AV160IsAuthorized_LegHtml ,
                                 boolean AV148ErroresVer ,
                                 int A3CliCod ,
                                 short A1EmpCod ,
                                 int A31LiqNro ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e20512 ();
      GRID_nCurrentRecord = 0 ;
      rf512( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LEGNUMERO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGNUMERO", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), ".", "")));
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      AV148ErroresVer = GXutil.strtobool( GXutil.booltostr( AV148ErroresVer)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV148ErroresVer", AV148ErroresVer);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf512( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV163Pgmname = "LiquidacionLegajoWC" ;
      Gx_err = (short)(0) ;
      edtavEliminarlegajo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEliminarlegajo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarlegajo_Enabled), 5, 0), !bGXsfl_77_Refreshing);
      edtavLeghtml_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLeghtml_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLeghtml_Enabled), 5, 0), !bGXsfl_77_Refreshing);
      edtavLiqlegimpotrdescu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqlegimpotrdescu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqlegimpotrdescu_Enabled), 5, 0), !bGXsfl_77_Refreshing);
      edtavLiqlegimptotdescu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqlegimptotdescu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqlegimptotdescu_Enabled), 5, 0), !bGXsfl_77_Refreshing);
      edtavAjustes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAjustes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAjustes_Enabled), 5, 0), !bGXsfl_77_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_77_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_77_Refreshing);
   }

   public void rf512( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(77) ;
      /* Execute user event: Refresh */
      e20512 ();
      nGXsfl_77_idx = 1 ;
      sGXsfl_77_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_77_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_772( ) ;
      bGXsfl_77_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", sPrefix);
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_772( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A891LiqLegError ,
                                              AV133TFLiqLegError_Sels ,
                                              A1781LiqLegErrorAux ,
                                              AV141TFLiqLegErrorAux_Sels ,
                                              Byte.valueOf(A1780LiqLegAuxEstado) ,
                                              AV143TFLiqLegAuxEstado_Sels ,
                                              AV110TFLiqLegImpBasico ,
                                              AV111TFLiqLegImpBasico_To ,
                                              AV93TFLiqLegImpTotBruto ,
                                              AV94TFLiqLegImpTotBruto_To ,
                                              AV108TFLiqLegImpTotBruSinSAC ,
                                              AV109TFLiqLegImpTotBruSinSAC_To ,
                                              AV102TFLiqLegImpTotRetGan ,
                                              AV103TFLiqLegImpTotRetGan_To ,
                                              Integer.valueOf(AV133TFLiqLegError_Sels.size()) ,
                                              AV132TFLiqLegError ,
                                              Integer.valueOf(AV141TFLiqLegErrorAux_Sels.size()) ,
                                              AV140TFLiqLegErrorAux ,
                                              AV121TFLiqLegImpContr ,
                                              AV122TFLiqLegImpContr_To ,
                                              Short.valueOf(AV125TFLIqLegIteraciones) ,
                                              Short.valueOf(AV126TFLIqLegIteraciones_To) ,
                                              AV127TFLiqLegSegundos ,
                                              AV128TFLiqLegSegundos_To ,
                                              Integer.valueOf(AV143TFLiqLegAuxEstado_Sels.size()) ,
                                              A760LiqLegImpBasico ,
                                              A498LiqLegImpTotBruto ,
                                              A759LiqLegImpTotBruSinSAC ,
                                              A757LiqLegImpTotRetGan ,
                                              A1157LiqLegImpContr ,
                                              Short.valueOf(A883LIqLegIteraciones) ,
                                              A884LiqLegSegundos ,
                                              Short.valueOf(AV92OrderedBy) ,
                                              Boolean.valueOf(AV19OrderedDsc) ,
                                              Integer.valueOf(AV88CliCod) ,
                                              Short.valueOf(AV7EmpCod) ,
                                              Integer.valueOf(AV17LiqNro) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A31LiqNro) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.SHORT,
                                              TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                              }
         });
         lV132TFLiqLegError = GXutil.concat( GXutil.rtrim( AV132TFLiqLegError), "%", "") ;
         lV140TFLiqLegErrorAux = GXutil.concat( GXutil.rtrim( AV140TFLiqLegErrorAux), "%", "") ;
         /* Using cursor H00512 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV7EmpCod), Integer.valueOf(AV17LiqNro), AV110TFLiqLegImpBasico, AV111TFLiqLegImpBasico_To, AV93TFLiqLegImpTotBruto, AV94TFLiqLegImpTotBruto_To, AV108TFLiqLegImpTotBruSinSAC, AV109TFLiqLegImpTotBruSinSAC_To, AV102TFLiqLegImpTotRetGan, AV103TFLiqLegImpTotRetGan_To, lV132TFLiqLegError, lV140TFLiqLegErrorAux, AV121TFLiqLegImpContr, AV122TFLiqLegImpContr_To, Short.valueOf(AV125TFLIqLegIteraciones), Short.valueOf(AV126TFLIqLegIteraciones_To), AV127TFLiqLegSegundos, AV128TFLiqLegSegundos_To, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_77_idx = 1 ;
         sGXsfl_77_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_77_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_772( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A278LiqEstado = H00512_A278LiqEstado[0] ;
            A31LiqNro = H00512_A31LiqNro[0] ;
            A1EmpCod = H00512_A1EmpCod[0] ;
            A3CliCod = H00512_A3CliCod[0] ;
            A1131LiqLegImpOtrDescu = H00512_A1131LiqLegImpOtrDescu[0] ;
            A2179LiqLegPDFEstado = H00512_A2179LiqLegPDFEstado[0] ;
            n2179LiqLegPDFEstado = H00512_n2179LiqLegPDFEstado[0] ;
            A1780LiqLegAuxEstado = H00512_A1780LiqLegAuxEstado[0] ;
            A884LiqLegSegundos = H00512_A884LiqLegSegundos[0] ;
            A883LIqLegIteraciones = H00512_A883LIqLegIteraciones[0] ;
            A1158LiqLegImpCosto = H00512_A1158LiqLegImpCosto[0] ;
            A1157LiqLegImpContr = H00512_A1157LiqLegImpContr[0] ;
            A774LiqRutaPDFVertical = H00512_A774LiqRutaPDFVertical[0] ;
            A590LiqRutaPDF = H00512_A590LiqRutaPDF[0] ;
            A239LegCUIL = H00512_A239LegCUIL[0] ;
            A1781LiqLegErrorAux = H00512_A1781LiqLegErrorAux[0] ;
            A891LiqLegError = H00512_A891LiqLegError[0] ;
            A757LiqLegImpTotRetGan = H00512_A757LiqLegImpTotRetGan[0] ;
            A579LiqLegImpTotDescu = H00512_A579LiqLegImpTotDescu[0] ;
            A759LiqLegImpTotBruSinSAC = H00512_A759LiqLegImpTotBruSinSAC[0] ;
            A281LiqLegImpTotal = H00512_A281LiqLegImpTotal[0] ;
            A498LiqLegImpTotBruto = H00512_A498LiqLegImpTotBruto[0] ;
            A758LiqLegImpTotBruProm = H00512_A758LiqLegImpTotBruProm[0] ;
            A760LiqLegImpBasico = H00512_A760LiqLegImpBasico[0] ;
            A250LegIdNomApe = H00512_A250LegIdNomApe[0] ;
            A6LegNumero = H00512_A6LegNumero[0] ;
            A278LiqEstado = H00512_A278LiqEstado[0] ;
            A239LegCUIL = H00512_A239LegCUIL[0] ;
            A250LegIdNomApe = H00512_A250LegIdNomApe[0] ;
            e21512 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(77) ;
         wb510( ) ;
      }
      bGXsfl_77_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes512( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV163Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV163Pgmname, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_AJUSTES", AV130IsAuthorized_Ajustes);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_AJUSTES", getSecureSignedToken( sPrefix, AV130IsAuthorized_Ajustes));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLIQUIDACIONAJUSTESPALABRA", GXutil.rtrim( AV138LiquidacionAjustesPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQUIDACIONAJUSTESPALABRA", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV138LiquidacionAjustesPalabra, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DISPLAY", AV137IsAuthorized_Display);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( sPrefix, AV137IsAuthorized_Display));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_LEGHTML", AV160IsAuthorized_LegHtml);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_LEGHTML", getSecureSignedToken( sPrefix, AV160IsAuthorized_LegHtml));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_CLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_EMPCOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LIQNRO", GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQNRO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LEGNUMERO"+"_"+sGXsfl_77_idx, getSecureSignedToken( sPrefix+sGXsfl_77_idx, localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9")));
   }

   public int subgrid_fnc_pagecount( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public int subgrid_fnc_recordcount( )
   {
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A891LiqLegError ,
                                           AV133TFLiqLegError_Sels ,
                                           A1781LiqLegErrorAux ,
                                           AV141TFLiqLegErrorAux_Sels ,
                                           Byte.valueOf(A1780LiqLegAuxEstado) ,
                                           AV143TFLiqLegAuxEstado_Sels ,
                                           AV110TFLiqLegImpBasico ,
                                           AV111TFLiqLegImpBasico_To ,
                                           AV93TFLiqLegImpTotBruto ,
                                           AV94TFLiqLegImpTotBruto_To ,
                                           AV108TFLiqLegImpTotBruSinSAC ,
                                           AV109TFLiqLegImpTotBruSinSAC_To ,
                                           AV102TFLiqLegImpTotRetGan ,
                                           AV103TFLiqLegImpTotRetGan_To ,
                                           Integer.valueOf(AV133TFLiqLegError_Sels.size()) ,
                                           AV132TFLiqLegError ,
                                           Integer.valueOf(AV141TFLiqLegErrorAux_Sels.size()) ,
                                           AV140TFLiqLegErrorAux ,
                                           AV121TFLiqLegImpContr ,
                                           AV122TFLiqLegImpContr_To ,
                                           Short.valueOf(AV125TFLIqLegIteraciones) ,
                                           Short.valueOf(AV126TFLIqLegIteraciones_To) ,
                                           AV127TFLiqLegSegundos ,
                                           AV128TFLiqLegSegundos_To ,
                                           Integer.valueOf(AV143TFLiqLegAuxEstado_Sels.size()) ,
                                           A760LiqLegImpBasico ,
                                           A498LiqLegImpTotBruto ,
                                           A759LiqLegImpTotBruSinSAC ,
                                           A757LiqLegImpTotRetGan ,
                                           A1157LiqLegImpContr ,
                                           Short.valueOf(A883LIqLegIteraciones) ,
                                           A884LiqLegSegundos ,
                                           Short.valueOf(AV92OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(AV7EmpCod) ,
                                           Integer.valueOf(AV17LiqNro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV132TFLiqLegError = GXutil.concat( GXutil.rtrim( AV132TFLiqLegError), "%", "") ;
      lV140TFLiqLegErrorAux = GXutil.concat( GXutil.rtrim( AV140TFLiqLegErrorAux), "%", "") ;
      /* Using cursor H00513 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV7EmpCod), Integer.valueOf(AV17LiqNro), AV110TFLiqLegImpBasico, AV111TFLiqLegImpBasico_To, AV93TFLiqLegImpTotBruto, AV94TFLiqLegImpTotBruto_To, AV108TFLiqLegImpTotBruSinSAC, AV109TFLiqLegImpTotBruSinSAC_To, AV102TFLiqLegImpTotRetGan, AV103TFLiqLegImpTotRetGan_To, lV132TFLiqLegError, lV140TFLiqLegErrorAux, AV121TFLiqLegImpContr, AV122TFLiqLegImpContr_To, Short.valueOf(AV125TFLIqLegIteraciones), Short.valueOf(AV126TFLIqLegIteraciones_To), AV127TFLiqLegSegundos, AV128TFLiqLegSegundos_To});
      GRID_nRecordCount = H00513_AGRID_nRecordCount[0] ;
      pr_default.close(1);
      return (int)(GRID_nRecordCount) ;
   }

   public int subgrid_fnc_recordsperpage( )
   {
      if ( subGrid_Rows > 0 )
      {
         return subGrid_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrid_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRID_nFirstRecordOnPage/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public short subgrid_firstpage( )
   {
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV88CliCod, AV7EmpCod, AV17LiqNro, AV163Pgmname, AV153ManageFiltersExecutionStep, AV85ColumnsSelector, AV12GridState, AV92OrderedBy, AV19OrderedDsc, AV110TFLiqLegImpBasico, AV111TFLiqLegImpBasico_To, AV93TFLiqLegImpTotBruto, AV94TFLiqLegImpTotBruto_To, AV108TFLiqLegImpTotBruSinSAC, AV109TFLiqLegImpTotBruSinSAC_To, AV102TFLiqLegImpTotRetGan, AV103TFLiqLegImpTotRetGan_To, AV132TFLiqLegError, AV133TFLiqLegError_Sels, AV140TFLiqLegErrorAux, AV141TFLiqLegErrorAux_Sels, AV121TFLiqLegImpContr, AV122TFLiqLegImpContr_To, AV125TFLIqLegIteraciones, AV126TFLIqLegIteraciones_To, AV127TFLiqLegSegundos, AV128TFLiqLegSegundos_To, AV143TFLiqLegAuxEstado_Sels, AV134MenuOpcCod, AV130IsAuthorized_Ajustes, AV138LiquidacionAjustesPalabra, AV137IsAuthorized_Display, AV160IsAuthorized_LegHtml, AV148ErroresVer, A3CliCod, A1EmpCod, A31LiqNro, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ( GRID_nRecordCount >= subgrid_fnc_recordsperpage( ) ) && ( GRID_nEOF == 0 ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV88CliCod, AV7EmpCod, AV17LiqNro, AV163Pgmname, AV153ManageFiltersExecutionStep, AV85ColumnsSelector, AV12GridState, AV92OrderedBy, AV19OrderedDsc, AV110TFLiqLegImpBasico, AV111TFLiqLegImpBasico_To, AV93TFLiqLegImpTotBruto, AV94TFLiqLegImpTotBruto_To, AV108TFLiqLegImpTotBruSinSAC, AV109TFLiqLegImpTotBruSinSAC_To, AV102TFLiqLegImpTotRetGan, AV103TFLiqLegImpTotRetGan_To, AV132TFLiqLegError, AV133TFLiqLegError_Sels, AV140TFLiqLegErrorAux, AV141TFLiqLegErrorAux_Sels, AV121TFLiqLegImpContr, AV122TFLiqLegImpContr_To, AV125TFLIqLegIteraciones, AV126TFLIqLegIteraciones_To, AV127TFLiqLegSegundos, AV128TFLiqLegSegundos_To, AV143TFLiqLegAuxEstado_Sels, AV134MenuOpcCod, AV130IsAuthorized_Ajustes, AV138LiquidacionAjustesPalabra, AV137IsAuthorized_Display, AV160IsAuthorized_LegHtml, AV148ErroresVer, A3CliCod, A1EmpCod, A31LiqNro, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      if ( GRID_nFirstRecordOnPage >= subgrid_fnc_recordsperpage( ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage-subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV88CliCod, AV7EmpCod, AV17LiqNro, AV163Pgmname, AV153ManageFiltersExecutionStep, AV85ColumnsSelector, AV12GridState, AV92OrderedBy, AV19OrderedDsc, AV110TFLiqLegImpBasico, AV111TFLiqLegImpBasico_To, AV93TFLiqLegImpTotBruto, AV94TFLiqLegImpTotBruto_To, AV108TFLiqLegImpTotBruSinSAC, AV109TFLiqLegImpTotBruSinSAC_To, AV102TFLiqLegImpTotRetGan, AV103TFLiqLegImpTotRetGan_To, AV132TFLiqLegError, AV133TFLiqLegError_Sels, AV140TFLiqLegErrorAux, AV141TFLiqLegErrorAux_Sels, AV121TFLiqLegImpContr, AV122TFLiqLegImpContr_To, AV125TFLIqLegIteraciones, AV126TFLIqLegIteraciones_To, AV127TFLiqLegSegundos, AV128TFLiqLegSegundos_To, AV143TFLiqLegAuxEstado_Sels, AV134MenuOpcCod, AV130IsAuthorized_Ajustes, AV138LiquidacionAjustesPalabra, AV137IsAuthorized_Display, AV160IsAuthorized_LegHtml, AV148ErroresVer, A3CliCod, A1EmpCod, A31LiqNro, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( GRID_nRecordCount > subgrid_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-subgrid_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV88CliCod, AV7EmpCod, AV17LiqNro, AV163Pgmname, AV153ManageFiltersExecutionStep, AV85ColumnsSelector, AV12GridState, AV92OrderedBy, AV19OrderedDsc, AV110TFLiqLegImpBasico, AV111TFLiqLegImpBasico_To, AV93TFLiqLegImpTotBruto, AV94TFLiqLegImpTotBruto_To, AV108TFLiqLegImpTotBruSinSAC, AV109TFLiqLegImpTotBruSinSAC_To, AV102TFLiqLegImpTotRetGan, AV103TFLiqLegImpTotRetGan_To, AV132TFLiqLegError, AV133TFLiqLegError_Sels, AV140TFLiqLegErrorAux, AV141TFLiqLegErrorAux_Sels, AV121TFLiqLegImpContr, AV122TFLiqLegImpContr_To, AV125TFLIqLegIteraciones, AV126TFLIqLegIteraciones_To, AV127TFLiqLegSegundos, AV128TFLiqLegSegundos_To, AV143TFLiqLegAuxEstado_Sels, AV134MenuOpcCod, AV130IsAuthorized_Ajustes, AV138LiquidacionAjustesPalabra, AV137IsAuthorized_Display, AV160IsAuthorized_LegHtml, AV148ErroresVer, A3CliCod, A1EmpCod, A31LiqNro, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV88CliCod, AV7EmpCod, AV17LiqNro, AV163Pgmname, AV153ManageFiltersExecutionStep, AV85ColumnsSelector, AV12GridState, AV92OrderedBy, AV19OrderedDsc, AV110TFLiqLegImpBasico, AV111TFLiqLegImpBasico_To, AV93TFLiqLegImpTotBruto, AV94TFLiqLegImpTotBruto_To, AV108TFLiqLegImpTotBruSinSAC, AV109TFLiqLegImpTotBruSinSAC_To, AV102TFLiqLegImpTotRetGan, AV103TFLiqLegImpTotRetGan_To, AV132TFLiqLegError, AV133TFLiqLegError_Sels, AV140TFLiqLegErrorAux, AV141TFLiqLegErrorAux_Sels, AV121TFLiqLegImpContr, AV122TFLiqLegImpContr_To, AV125TFLIqLegIteraciones, AV126TFLIqLegIteraciones_To, AV127TFLiqLegSegundos, AV128TFLiqLegSegundos_To, AV143TFLiqLegAuxEstado_Sels, AV134MenuOpcCod, AV130IsAuthorized_Ajustes, AV138LiquidacionAjustesPalabra, AV137IsAuthorized_Display, AV160IsAuthorized_LegHtml, AV148ErroresVer, A3CliCod, A1EmpCod, A31LiqNro, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV163Pgmname = "LiquidacionLegajoWC" ;
      Gx_err = (short)(0) ;
      edtavEliminarlegajo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEliminarlegajo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarlegajo_Enabled), 5, 0), !bGXsfl_77_Refreshing);
      edtavLeghtml_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLeghtml_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLeghtml_Enabled), 5, 0), !bGXsfl_77_Refreshing);
      edtavLiqlegimpotrdescu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqlegimpotrdescu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqlegimpotrdescu_Enabled), 5, 0), !bGXsfl_77_Refreshing);
      edtavLiqlegimptotdescu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqlegimptotdescu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqlegimptotdescu_Enabled), 5, 0), !bGXsfl_77_Refreshing);
      edtavAjustes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAjustes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAjustes_Enabled), 5, 0), !bGXsfl_77_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_77_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_77_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup510( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e19512 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV5DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vCOLUMNSSELECTOR"), AV85ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vMANAGEFILTERSDATA"), AV151ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_77 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_77"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV10GridCurrentPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV11GridPageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV9GridAppliedFilters = httpContext.cgiGet( sPrefix+"vGRIDAPPLIEDFILTERS") ;
         wcpOAV134MenuOpcCod = httpContext.cgiGet( sPrefix+"wcpOAV134MenuOpcCod") ;
         wcpOAV88CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV88CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV7EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV7EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV17LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV17LiqNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV16LegNumero_Selected = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vLEGNUMERO_SELECTED"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A31LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"LIQNRO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV18LiqNro_Selected = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vLIQNRO_SELECTED"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"EMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV8EmpCod_Selected = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vEMPCOD_SELECTED"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"CLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV113CliCod_Selected = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vCLICOD_SELECTED"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Buttonexport1_a3lexport_Observer = httpContext.cgiGet( sPrefix+"BUTTONEXPORT1_A3LEXPORT_Observer") ;
         Buttonexport1_a3lexport_Boton_clon_id = httpContext.cgiGet( sPrefix+"BUTTONEXPORT1_A3LEXPORT_Boton_clon_id") ;
         Buttonexport1_a3lexport_Boton_orig_id = httpContext.cgiGet( sPrefix+"BUTTONEXPORT1_A3LEXPORT_Boton_orig_id") ;
         Ddo_gridcolumnsselector_Icontype = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Icontype") ;
         Ddo_gridcolumnsselector_Icon = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Icon") ;
         Ddo_gridcolumnsselector_Caption = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Caption") ;
         Ddo_gridcolumnsselector_Tooltip = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Tooltip") ;
         Ddo_gridcolumnsselector_Cls = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Cls") ;
         Ddo_gridcolumnsselector_Dropdownoptionstype = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype") ;
         Ddo_gridcolumnsselector_Gridinternalname = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Gridinternalname") ;
         Ddo_managefilters_Icontype = httpContext.cgiGet( sPrefix+"DDO_MANAGEFILTERS_Icontype") ;
         Ddo_managefilters_Icon = httpContext.cgiGet( sPrefix+"DDO_MANAGEFILTERS_Icon") ;
         Ddo_managefilters_Tooltip = httpContext.cgiGet( sPrefix+"DDO_MANAGEFILTERS_Tooltip") ;
         Ddo_managefilters_Cls = httpContext.cgiGet( sPrefix+"DDO_MANAGEFILTERS_Cls") ;
         Buttonfilter1_a3lfilter_Observer = httpContext.cgiGet( sPrefix+"BUTTONFILTER1_A3LFILTER_Observer") ;
         Buttonfilter1_a3lfilter_A3l_filter_id = httpContext.cgiGet( sPrefix+"BUTTONFILTER1_A3LFILTER_A3l_filter_id") ;
         Buttonfilter1_a3lfilter_Filter_orig = httpContext.cgiGet( sPrefix+"BUTTONFILTER1_A3LFILTER_Filter_orig") ;
         Gridpaginationbar_Class = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Class") ;
         Gridpaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Showfirst")) ;
         Gridpaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Showprevious")) ;
         Gridpaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Shownext")) ;
         Gridpaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Showlast")) ;
         Gridpaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Pagestoshow"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridpaginationbar_Pagingbuttonsposition = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridpaginationbar_Pagingcaptionposition = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Pagingcaptionposition") ;
         Gridpaginationbar_Emptygridclass = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Emptygridclass") ;
         Gridpaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselector")) ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridpaginationbar_Rowsperpageoptions = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageoptions") ;
         Gridpaginationbar_Previous = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Previous") ;
         Gridpaginationbar_Next = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Next") ;
         Gridpaginationbar_Caption = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Caption") ;
         Gridpaginationbar_Emptygridcaption = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Emptygridcaption") ;
         Gridpaginationbar_Rowsperpagecaption = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpagecaption") ;
         Innewwindow1_Target = httpContext.cgiGet( sPrefix+"INNEWWINDOW1_Target") ;
         Ddo_grid_Caption = httpContext.cgiGet( sPrefix+"DDO_GRID_Caption") ;
         Ddo_grid_Filteredtext_set = httpContext.cgiGet( sPrefix+"DDO_GRID_Filteredtext_set") ;
         Ddo_grid_Filteredtextto_set = httpContext.cgiGet( sPrefix+"DDO_GRID_Filteredtextto_set") ;
         Ddo_grid_Selectedvalue_set = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedvalue_set") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( sPrefix+"DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( sPrefix+"DDO_GRID_Includesortasc") ;
         Ddo_grid_Fixable = httpContext.cgiGet( sPrefix+"DDO_GRID_Fixable") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( sPrefix+"DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( sPrefix+"DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( sPrefix+"DDO_GRID_Filtertype") ;
         Ddo_grid_Filterisrange = httpContext.cgiGet( sPrefix+"DDO_GRID_Filterisrange") ;
         Ddo_grid_Includedatalist = httpContext.cgiGet( sPrefix+"DDO_GRID_Includedatalist") ;
         Ddo_grid_Datalisttype = httpContext.cgiGet( sPrefix+"DDO_GRID_Datalisttype") ;
         Ddo_grid_Allowmultipleselection = httpContext.cgiGet( sPrefix+"DDO_GRID_Allowmultipleselection") ;
         Ddo_grid_Datalistfixedvalues = httpContext.cgiGet( sPrefix+"DDO_GRID_Datalistfixedvalues") ;
         Ddo_grid_Datalistproc = httpContext.cgiGet( sPrefix+"DDO_GRID_Datalistproc") ;
         Ddo_grid_Format = httpContext.cgiGet( sPrefix+"DDO_GRID_Format") ;
         Dvelop_confirmpanel_eliminarlegajo_Title = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO_Title") ;
         Dvelop_confirmpanel_eliminarlegajo_Confirmationtext = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO_Confirmationtext") ;
         Dvelop_confirmpanel_eliminarlegajo_Yesbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO_Yesbuttoncaption") ;
         Dvelop_confirmpanel_eliminarlegajo_Nobuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO_Nobuttoncaption") ;
         Dvelop_confirmpanel_eliminarlegajo_Cancelbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_eliminarlegajo_Yesbuttonposition = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO_Yesbuttonposition") ;
         Dvelop_confirmpanel_eliminarlegajo_Confirmtype = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO_Confirmtype") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Hastitlesettings")) ;
         Grid_empowerer_Hascolumnsselector = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Hascolumnsselector")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( sPrefix+"DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedvalue_get") ;
         Ddo_grid_Filteredtextto_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Filteredtextto_get") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Filteredtext_get") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedcolumn") ;
         Ddo_gridcolumnsselector_Columnsselectorvalues = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues") ;
         Ddo_managefilters_Activeeventkey = httpContext.cgiGet( sPrefix+"DDO_MANAGEFILTERS_Activeeventkey") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Dvelop_confirmpanel_eliminarlegajo_Result = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO_Result") ;
         /* Read variables values. */
         AV148ErroresVer = GXutil.strtobool( httpContext.cgiGet( chkavErroresver.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV148ErroresVer", AV148ErroresVer);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e19512 ();
      if (returnInSub) return;
   }

   public void e19512( )
   {
      /* Start Routine */
      returnInSub = false ;
      Ddo_gridcolumnsselector_Caption = httpContext.getMessage( "Columnas", "") ;
      ucDdo_gridcolumnsselector.sendProperty(context, sPrefix, false, Ddo_gridcolumnsselector_Internalname, "Caption", Ddo_gridcolumnsselector_Caption);
      AV138LiquidacionAjustesPalabra = httpContext.getMessage( "LiquidacionAjustes", "") ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV138LiquidacionAjustesPalabra", AV138LiquidacionAjustesPalabra);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQUIDACIONAJUSTESPALABRA", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV138LiquidacionAjustesPalabra, ""))));
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, sPrefix, false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, sPrefix, false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      /* Execute user subroutine: 'LOADSAVEDFILTERS' */
      S112 ();
      if (returnInSub) return;
      GXt_boolean1 = AV160IsAuthorized_LegHtml ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "LiquidacionVerDetalle", GXv_boolean2) ;
      liquidacionlegajowc_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV160IsAuthorized_LegHtml = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV160IsAuthorized_LegHtml", AV160IsAuthorized_LegHtml);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_LEGHTML", getSecureSignedToken( sPrefix, AV160IsAuthorized_LegHtml));
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV92OrderedBy < 1 )
      {
         AV92OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV92OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV92OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV5DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV5DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, sPrefix, false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      AV157observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV157observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, sPrefix, false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, sPrefix, false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, sPrefix, false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV148ErroresVer = GXutil.boolval( AV91websession.getValue(httpContext.getMessage( "&erroresVer", ""))) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV148ErroresVer", AV148ErroresVer);
      /* Execute user subroutine: 'VER ERRORES VISIBLE' */
      S152 ();
      if (returnInSub) return;
      if ( ! AV147errorHay )
      {
         AV133TFLiqLegError_Sels.clear();
         AV132TFLiqLegError = "" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV132TFLiqLegError", AV132TFLiqLegError);
         chkavErroresver.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavErroresver.getInternalname(), "Visible", GXutil.ltrimstr( chkavErroresver.getVisible(), 5, 0), true);
         lblTextblock1_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblTextblock1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTextblock1_Visible), 5, 0), true);
      }
      AV157observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV157observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, sPrefix, false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, sPrefix, false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "W0068DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, sPrefix, false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
   }

   public void e20512( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV88CliCod, AV163Pgmname, httpContext.getMessage( "sesion columns ", "")+AV23Session.getValue("LiquidacionLegajoWCColumnsSelector")) ;
      GXv_SdtWWPContext5[0] = AV29WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV29WWPContext = GXv_SdtWWPContext5[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S162 ();
      if (returnInSub) return;
      if ( AV153ManageFiltersExecutionStep == 1 )
      {
         AV153ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV153ManageFiltersExecutionStep", GXutil.str( AV153ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV153ManageFiltersExecutionStep == 2 )
      {
         AV153ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV153ManageFiltersExecutionStep", GXutil.str( AV153ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S172 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV23Session.getValue("LiquidacionLegajoWCColumnsSelector"), "") != 0 )
      {
         AV83ColumnsSelectorXML = AV23Session.getValue("LiquidacionLegajoWCColumnsSelector") ;
         AV85ColumnsSelector.fromxml(AV83ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S182 ();
         if (returnInSub) return;
      }
      edtavLeghtml_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLeghtml_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLeghtml_Visible), 5, 0), !bGXsfl_77_Refreshing);
      edtLiqLegImpBasico_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqLegImpBasico_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegImpBasico_Visible), 5, 0), !bGXsfl_77_Refreshing);
      edtLiqLegImpTotBruto_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqLegImpTotBruto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegImpTotBruto_Visible), 5, 0), !bGXsfl_77_Refreshing);
      edtLiqLegImpTotal_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqLegImpTotal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegImpTotal_Visible), 5, 0), !bGXsfl_77_Refreshing);
      edtLiqLegImpTotBruSinSAC_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqLegImpTotBruSinSAC_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegImpTotBruSinSAC_Visible), 5, 0), !bGXsfl_77_Refreshing);
      edtLiqLegImpTotRetGan_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqLegImpTotRetGan_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegImpTotRetGan_Visible), 5, 0), !bGXsfl_77_Refreshing);
      edtavLiqlegimpotrdescu_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqlegimpotrdescu_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqlegimpotrdescu_Visible), 5, 0), !bGXsfl_77_Refreshing);
      edtavLiqlegimptotdescu_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqlegimptotdescu_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqlegimptotdescu_Visible), 5, 0), !bGXsfl_77_Refreshing);
      edtLiqLegError_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqLegError_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegError_Visible), 5, 0), !bGXsfl_77_Refreshing);
      edtLiqLegErrorAux_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqLegErrorAux_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegErrorAux_Visible), 5, 0), !bGXsfl_77_Refreshing);
      edtLegCUIL_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegCUIL_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCUIL_Visible), 5, 0), !bGXsfl_77_Refreshing);
      edtLiqLegImpContr_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqLegImpContr_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegImpContr_Visible), 5, 0), !bGXsfl_77_Refreshing);
      edtLIqLegIteraciones_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLIqLegIteraciones_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLIqLegIteraciones_Visible), 5, 0), !bGXsfl_77_Refreshing);
      edtLiqLegSegundos_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqLegSegundos_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegSegundos_Visible), 5, 0), !bGXsfl_77_Refreshing);
      cmbLiqLegAuxEstado.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqLegAuxEstado.getInternalname(), "Visible", GXutil.ltrimstr( cmbLiqLegAuxEstado.getVisible(), 5, 0), !bGXsfl_77_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_77_Refreshing);
      AV10GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10GridCurrentPage), 10, 0));
      AV11GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11GridPageCount), 10, 0));
      GXt_char6 = AV9GridAppliedFilters ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV163Pgmname, GXv_char7) ;
      liquidacionlegajowc_impl.this.GXt_char6 = GXv_char7[0] ;
      AV9GridAppliedFilters = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9GridAppliedFilters", AV9GridAppliedFilters);
      GXv_int8[0] = (short)(AV155filterCount) ;
      GXv_char7[0] = AV156filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV12GridState, GXv_int8, GXv_char7) ;
      liquidacionlegajowc_impl.this.AV155filterCount = GXv_int8[0] ;
      liquidacionlegajowc_impl.this.AV156filtrosTexto = GXv_char7[0] ;
      if ( AV155filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV155filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV156filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      lblCouttext_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      lblCouttext_Caption = " "+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+httpContext.getMessage( " recibos", "") ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV85ColumnsSelector", AV85ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV151ManageFiltersData", AV151ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV12GridState", AV12GridState);
   }

   public void e13512( )
   {
      /* Gridpaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgrid_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Next") == 0 )
      {
         subgrid_nextpage( ) ;
      }
      else
      {
         AV21PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV21PageToGo) ;
      }
   }

   public void e14512( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15512( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV92OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV92OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV92OrderedBy), 4, 0));
         AV19OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19OrderedDsc", AV19OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegImpBasico") == 0 )
         {
            AV110TFLiqLegImpBasico = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV110TFLiqLegImpBasico", GXutil.ltrimstr( AV110TFLiqLegImpBasico, 14, 2));
            AV111TFLiqLegImpBasico_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV111TFLiqLegImpBasico_To", GXutil.ltrimstr( AV111TFLiqLegImpBasico_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegImpTotBruto") == 0 )
         {
            AV93TFLiqLegImpTotBruto = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV93TFLiqLegImpTotBruto", GXutil.ltrimstr( AV93TFLiqLegImpTotBruto, 14, 2));
            AV94TFLiqLegImpTotBruto_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV94TFLiqLegImpTotBruto_To", GXutil.ltrimstr( AV94TFLiqLegImpTotBruto_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegImpTotBruSinSAC") == 0 )
         {
            AV108TFLiqLegImpTotBruSinSAC = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV108TFLiqLegImpTotBruSinSAC", GXutil.ltrimstr( AV108TFLiqLegImpTotBruSinSAC, 14, 2));
            AV109TFLiqLegImpTotBruSinSAC_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV109TFLiqLegImpTotBruSinSAC_To", GXutil.ltrimstr( AV109TFLiqLegImpTotBruSinSAC_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegImpTotRetGan") == 0 )
         {
            AV102TFLiqLegImpTotRetGan = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV102TFLiqLegImpTotRetGan", GXutil.ltrimstr( AV102TFLiqLegImpTotRetGan, 14, 2));
            AV103TFLiqLegImpTotRetGan_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV103TFLiqLegImpTotRetGan_To", GXutil.ltrimstr( AV103TFLiqLegImpTotRetGan_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegError") == 0 )
         {
            AV132TFLiqLegError = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV132TFLiqLegError", AV132TFLiqLegError);
            AV131TFLiqLegError_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV131TFLiqLegError_SelsJson", AV131TFLiqLegError_SelsJson);
            AV133TFLiqLegError_Sels.fromJSonString(AV131TFLiqLegError_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegErrorAux") == 0 )
         {
            AV140TFLiqLegErrorAux = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV140TFLiqLegErrorAux", AV140TFLiqLegErrorAux);
            AV139TFLiqLegErrorAux_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV139TFLiqLegErrorAux_SelsJson", AV139TFLiqLegErrorAux_SelsJson);
            AV141TFLiqLegErrorAux_Sels.fromJSonString(AV139TFLiqLegErrorAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegImpContr") == 0 )
         {
            AV121TFLiqLegImpContr = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV121TFLiqLegImpContr", GXutil.ltrimstr( AV121TFLiqLegImpContr, 14, 2));
            AV122TFLiqLegImpContr_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV122TFLiqLegImpContr_To", GXutil.ltrimstr( AV122TFLiqLegImpContr_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LIqLegIteraciones") == 0 )
         {
            AV125TFLIqLegIteraciones = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV125TFLIqLegIteraciones", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV125TFLIqLegIteraciones), 4, 0));
            AV126TFLIqLegIteraciones_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV126TFLIqLegIteraciones_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV126TFLIqLegIteraciones_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegSegundos") == 0 )
         {
            AV127TFLiqLegSegundos = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV127TFLiqLegSegundos", GXutil.ltrimstr( AV127TFLiqLegSegundos, 10, 6));
            AV128TFLiqLegSegundos_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV128TFLiqLegSegundos_To", GXutil.ltrimstr( AV128TFLiqLegSegundos_To, 10, 6));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegAuxEstado") == 0 )
         {
            AV142TFLiqLegAuxEstado_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV142TFLiqLegAuxEstado_SelsJson", AV142TFLiqLegAuxEstado_SelsJson);
            AV143TFLiqLegAuxEstado_Sels.fromJSonString(GXutil.strReplace( AV142TFLiqLegAuxEstado_SelsJson, "\"", ""), null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV143TFLiqLegAuxEstado_Sels", AV143TFLiqLegAuxEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV141TFLiqLegErrorAux_Sels", AV141TFLiqLegErrorAux_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV133TFLiqLegError_Sels", AV133TFLiqLegError_Sels);
   }

   private void e21512( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV6EliminarLegajo = "<i class=\"fas fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEliminarlegajo_Internalname, AV6EliminarLegajo);
      if ( false && ( A278LiqEstado != 4 ) )
      {
         edtavEliminarlegajo_Class = "Attribute" ;
      }
      else
      {
         edtavEliminarlegajo_Class = "Invisible" ;
      }
      cmbavGridactiongroup1.removeAllItems();
      cmbavGridactiongroup1.addItem("0", ";fas fa-print", (short)(0));
      cmbavGridactiongroup1.addItem("1", GXutil.format( "%1;%2", httpContext.getMessage( "Un Recibo por Hoja (Vertical)", ""), "far fa-file-pdf far fa-file-pdf", "", "", "", "", "", "", ""), (short)(0));
      cmbavGridactiongroup1.addItem("2", GXutil.format( "%1;%2", httpContext.getMessage( "Dos Recibos por Hoja (Apaisada)", ""), "fas fa-file-pdf fas fa-file-pdf", "", "", "", "", "", "", ""), (short)(0));
      AV129Ajustes = "<i class=\"fas fa-sliders-h fas fa-sliders-h\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavAjustes_Internalname, AV129Ajustes);
      if ( AV130IsAuthorized_Ajustes )
      {
         edtavAjustes_Link = formatLink("web.liquidacionajusteww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV138LiquidacionAjustesPalabra)),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A31LiqNro,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0))}, new String[] {"MenuOpcCod","CliCod","EmpCod","LiqNro","LegNumero"})  ;
      }
      AV136Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplay_Internalname, AV136Display);
      if ( AV137IsAuthorized_Display )
      {
         edtavDisplay_Link = formatLink("web.liquidacionverdetalle2", new String[] {GXutil.URLEncode(GXutil.rtrim(AV134MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A31LiqNro,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0))}, new String[] {"auxMenuOpcCod","CliCod","EmpCod","LiqNro","LegNumero"})  ;
      }
      if ( AV160IsAuthorized_LegHtml )
      {
         edtavLeghtml_Link = formatLink("web.liquidacionverdetalle2", new String[] {GXutil.URLEncode(GXutil.rtrim(AV134MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A31LiqNro,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0))}, new String[] {"auxMenuOpcCod","CliCod","EmpCod","LiqNro","LegNumero"})  ;
      }
      GXt_char6 = AV159LegHtml ;
      GXv_char7[0] = GXt_char6 ;
      new web.gethtmlleg(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, GXv_char7) ;
      liquidacionlegajowc_impl.this.GXt_char6 = GXv_char7[0] ;
      AV159LegHtml = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavLeghtml_Internalname, AV159LegHtml);
      AV120LiqLegImpOtrDescu = A1131LiqLegImpOtrDescu.multiply(DecimalUtil.doubleToDec(-1)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavLiqlegimpotrdescu_Internalname, GXutil.ltrimstr( AV120LiqLegImpOtrDescu, 14, 2));
      AV106LiqLegImpTotDescu = A579LiqLegImpTotDescu.multiply(DecimalUtil.doubleToDec(-1)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavLiqlegimptotdescu_Internalname, GXutil.ltrimstr( AV106LiqLegImpTotDescu, 14, 2));
      edtavVersvg_Format = (short)(1) ;
      GXt_char6 = AV135VerSVG ;
      GXv_char7[0] = GXt_char6 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
      liquidacionlegajowc_impl.this.GXt_char6 = GXv_char7[0] ;
      AV135VerSVG = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavVersvg_Internalname, AV135VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(77) ;
      }
      sendrow_772( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_77_Refreshing )
      {
         httpContext.doAjaxLoad(77, GridRow);
      }
      /*  Sending Event outputs  */
      cmbavGridactiongroup1.setValue( GXutil.trim( GXutil.str( AV87GridActionGroup1, 4, 0)) );
   }

   public void e11512( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV83ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV85ColumnsSelector.fromJSonString(AV83ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "LiquidacionLegajoWCColumnsSelector", ((GXutil.strcmp("", AV83ColumnsSelectorXML)==0) ? "" : AV85ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefreshCmp(sPrefix);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV85ColumnsSelector", AV85ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV151ManageFiltersData", AV151ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV12GridState", AV12GridState);
   }

   public void e12512( )
   {
      /* Ddo_managefilters_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Clean#>") == 0 )
      {
         /* Execute user subroutine: 'CLEANFILTERS' */
         S192 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Save#>") == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S172 ();
         if (returnInSub) return;
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("LiquidacionLegajoWCFilters")),GXutil.URLEncode(GXutil.rtrim(AV163Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV153ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV153ManageFiltersExecutionStep", GXutil.str( AV153ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefreshCmp(sPrefix);
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("LiquidacionLegajoWCFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV153ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV153ManageFiltersExecutionStep", GXutil.str( AV153ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefreshCmp(sPrefix);
      }
      else
      {
         GXt_char6 = AV152ManageFiltersXml ;
         GXv_char7[0] = GXt_char6 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "LiquidacionLegajoWCFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         liquidacionlegajowc_impl.this.GXt_char6 = GXv_char7[0] ;
         AV152ManageFiltersXml = GXt_char6 ;
         if ( (GXutil.strcmp("", AV152ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S192 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV163Pgmname+"GridState", AV152ManageFiltersXml) ;
            AV12GridState.fromxml(AV152ManageFiltersXml, null, null);
            AV92OrderedBy = AV12GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV92OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV92OrderedBy), 4, 0));
            AV19OrderedDsc = AV12GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19OrderedDsc", AV19OrderedDsc);
            /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
            S142 ();
            if (returnInSub) return;
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S202 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV133TFLiqLegError_Sels", AV133TFLiqLegError_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV141TFLiqLegErrorAux_Sels", AV141TFLiqLegErrorAux_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV143TFLiqLegAuxEstado_Sels", AV143TFLiqLegAuxEstado_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV85ColumnsSelector", AV85ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV151ManageFiltersData", AV151ManageFiltersData);
   }

   public void e16512( )
   {
      /* Dvelop_confirmpanel_eliminarlegajo_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_eliminarlegajo_Result, "Yes") == 0 )
      {
         /* Execute user subroutine: 'DO ELIMINARLEGAJO' */
         S212 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV85ColumnsSelector", AV85ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV151ManageFiltersData", AV151ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV12GridState", AV12GridState);
   }

   public void e22512( )
   {
      /* Gridactiongroup1_Click Routine */
      returnInSub = false ;
      if ( AV87GridActionGroup1 == 1 )
      {
         /* Execute user subroutine: 'DO RECIBOSUELDO1' */
         S222 ();
         if (returnInSub) return;
      }
      else if ( AV87GridActionGroup1 == 2 )
      {
         /* Execute user subroutine: 'DO RECIBOSUELDO2' */
         S232 ();
         if (returnInSub) return;
      }
      AV87GridActionGroup1 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, cmbavGridactiongroup1.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV87GridActionGroup1), 4, 0));
      /*  Sending Event outputs  */
      cmbavGridactiongroup1.setValue( GXutil.trim( GXutil.str( AV87GridActionGroup1, 4, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavGridactiongroup1.getInternalname(), "Values", cmbavGridactiongroup1.ToJavascriptSource(), true);
   }

   public void e17512( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV31ExcelFilename ;
      GXv_char9[0] = AV32ErrorMessage ;
      new web.liquidacionlegajowcexport(remoteHandle, context).execute( GXv_char7, GXv_char9) ;
      liquidacionlegajowc_impl.this.AV31ExcelFilename = GXv_char7[0] ;
      liquidacionlegajowc_impl.this.AV32ErrorMessage = GXv_char9[0] ;
      if ( GXutil.strcmp(AV31ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV31ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV32ErrorMessage);
      }
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV92OrderedBy, 4, 0))+":"+(AV19OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S182( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV85ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10[0] = AV85ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&LegHtml", "", "Legajo", true, "") ;
      AV85ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV85ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LiqLegImpBasico", "", "Básico", false, "") ;
      AV85ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV85ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LiqLegImpTotBruto", "", "Bruto", true, "") ;
      AV85ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV85ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LiqLegImpTotal", "", "Neto", true, "") ;
      AV85ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV85ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LiqLegImpTotBruSinSAC", "", "Bruto sin SAC", false, "") ;
      AV85ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV85ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LiqLegImpTotRetGan", "", "Ret. IIGG", true, "") ;
      AV85ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV85ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&LiqLegImpOtrDescu", "", "Aportes", true, "") ;
      AV85ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV85ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&LiqLegImpTotDescu", "", "Ret. Total", false, "") ;
      AV85ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV85ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LiqLegError", "", "Error", false, "") ;
      AV85ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV85ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LiqLegErrorAux", "", "Error conceptos auxiliares", false, "") ;
      AV85ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV85ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LegCUIL", "", "CUIL", false, "") ;
      AV85ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV85ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LiqLegImpContr", "", "Contr.", true, "") ;
      AV85ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV85ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LIqLegIteraciones", "", "Iteraciones Proceso", false, "") ;
      AV85ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV85ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LiqLegSegundos", "", "Segundos", false, "") ;
      AV85ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV85ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LiqLegAuxEstado", "", "Estado conceptos auxiliares", false, "") ;
      AV85ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV85ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&VerSVG", "", "", true, "") ;
      AV85ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXt_char6 = AV84UserCustomValue ;
      GXv_char9[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "LiquidacionLegajoWCColumnsSelector", GXv_char9) ;
      liquidacionlegajowc_impl.this.GXt_char6 = GXv_char9[0] ;
      AV84UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV84UserCustomValue)==0) ) )
      {
         AV86ColumnsSelectorAux.fromxml(AV84UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector10[0] = AV86ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector11[0] = AV85ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, GXv_SdtWWPColumnsSelector11) ;
         AV86ColumnsSelectorAux = GXv_SdtWWPColumnsSelector10[0] ;
         AV85ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      }
      GXv_SdtWWPColumnsSelector11[0] = AV85ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV88CliCod, GXv_SdtWWPColumnsSelector11) ;
      AV85ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
   }

   public void S162( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean1 = AV130IsAuthorized_Ajustes ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiquidacionAjuste", GXv_boolean2) ;
      liquidacionlegajowc_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV130IsAuthorized_Ajustes = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV130IsAuthorized_Ajustes", AV130IsAuthorized_Ajustes);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_AJUSTES", getSecureSignedToken( sPrefix, AV130IsAuthorized_Ajustes));
      if ( ! ( AV130IsAuthorized_Ajustes ) )
      {
         edtavAjustes_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAjustes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAjustes_Visible), 5, 0), !bGXsfl_77_Refreshing);
      }
      GXt_boolean1 = AV137IsAuthorized_Display ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "LiquidacionVerDetalle", GXv_boolean2) ;
      liquidacionlegajowc_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV137IsAuthorized_Display = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV137IsAuthorized_Display", AV137IsAuthorized_Display);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( sPrefix, AV137IsAuthorized_Display));
      if ( ! ( AV137IsAuthorized_Display ) )
      {
         edtavDisplay_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplay_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Visible), 5, 0), !bGXsfl_77_Refreshing);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item12 = AV151ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item13[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item12 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "LiquidacionLegajoWCFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item13) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item12 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item13[0] ;
      AV151ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item12 ;
   }

   public void S192( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV110TFLiqLegImpBasico = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV110TFLiqLegImpBasico", GXutil.ltrimstr( AV110TFLiqLegImpBasico, 14, 2));
      AV111TFLiqLegImpBasico_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV111TFLiqLegImpBasico_To", GXutil.ltrimstr( AV111TFLiqLegImpBasico_To, 14, 2));
      AV93TFLiqLegImpTotBruto = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV93TFLiqLegImpTotBruto", GXutil.ltrimstr( AV93TFLiqLegImpTotBruto, 14, 2));
      AV94TFLiqLegImpTotBruto_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV94TFLiqLegImpTotBruto_To", GXutil.ltrimstr( AV94TFLiqLegImpTotBruto_To, 14, 2));
      AV108TFLiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV108TFLiqLegImpTotBruSinSAC", GXutil.ltrimstr( AV108TFLiqLegImpTotBruSinSAC, 14, 2));
      AV109TFLiqLegImpTotBruSinSAC_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV109TFLiqLegImpTotBruSinSAC_To", GXutil.ltrimstr( AV109TFLiqLegImpTotBruSinSAC_To, 14, 2));
      AV102TFLiqLegImpTotRetGan = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV102TFLiqLegImpTotRetGan", GXutil.ltrimstr( AV102TFLiqLegImpTotRetGan, 14, 2));
      AV103TFLiqLegImpTotRetGan_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV103TFLiqLegImpTotRetGan_To", GXutil.ltrimstr( AV103TFLiqLegImpTotRetGan_To, 14, 2));
      AV132TFLiqLegError = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV132TFLiqLegError", AV132TFLiqLegError);
      AV133TFLiqLegError_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV140TFLiqLegErrorAux = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV140TFLiqLegErrorAux", AV140TFLiqLegErrorAux);
      AV141TFLiqLegErrorAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV121TFLiqLegImpContr = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV121TFLiqLegImpContr", GXutil.ltrimstr( AV121TFLiqLegImpContr, 14, 2));
      AV122TFLiqLegImpContr_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV122TFLiqLegImpContr_To", GXutil.ltrimstr( AV122TFLiqLegImpContr_To, 14, 2));
      AV125TFLIqLegIteraciones = (short)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV125TFLIqLegIteraciones", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV125TFLIqLegIteraciones), 4, 0));
      AV126TFLIqLegIteraciones_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV126TFLIqLegIteraciones_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV126TFLIqLegIteraciones_To), 4, 0));
      AV127TFLiqLegSegundos = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV127TFLiqLegSegundos", GXutil.ltrimstr( AV127TFLiqLegSegundos, 10, 6));
      AV128TFLiqLegSegundos_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV128TFLiqLegSegundos_To", GXutil.ltrimstr( AV128TFLiqLegSegundos_To, 10, 6));
      AV143TFLiqLegAuxEstado_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      Ddo_grid_Selectedvalue_set = "" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      Ddo_grid_Filteredtext_set = "" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S212( )
   {
      /* 'DO ELIMINARLEGAJO' Routine */
      returnInSub = false ;
      new web.eliminaliquidacionlegajo(remoteHandle, context).execute( AV113CliCod_Selected, AV8EmpCod_Selected, AV18LiqNro_Selected, AV16LegNumero_Selected) ;
      gxgrgrid_refresh( subGrid_Rows, AV88CliCod, AV7EmpCod, AV17LiqNro, AV163Pgmname, AV153ManageFiltersExecutionStep, AV85ColumnsSelector, AV12GridState, AV92OrderedBy, AV19OrderedDsc, AV110TFLiqLegImpBasico, AV111TFLiqLegImpBasico_To, AV93TFLiqLegImpTotBruto, AV94TFLiqLegImpTotBruto_To, AV108TFLiqLegImpTotBruSinSAC, AV109TFLiqLegImpTotBruSinSAC_To, AV102TFLiqLegImpTotRetGan, AV103TFLiqLegImpTotRetGan_To, AV132TFLiqLegError, AV133TFLiqLegError_Sels, AV140TFLiqLegErrorAux, AV141TFLiqLegErrorAux_Sels, AV121TFLiqLegImpContr, AV122TFLiqLegImpContr_To, AV125TFLIqLegIteraciones, AV126TFLIqLegIteraciones_To, AV127TFLiqLegSegundos, AV128TFLiqLegSegundos_To, AV143TFLiqLegAuxEstado_Sels, AV134MenuOpcCod, AV130IsAuthorized_Ajustes, AV138LiquidacionAjustesPalabra, AV137IsAuthorized_Display, AV160IsAuthorized_LegHtml, AV148ErroresVer, A3CliCod, A1EmpCod, A31LiqNro, sPrefix) ;
   }

   public void S222( )
   {
      /* 'DO RECIBOSUELDO1' Routine */
      returnInSub = false ;
      GXv_char9[0] = AV99linkPDF ;
      GXv_char7[0] = AV98errorPDF ;
      new web.armaurlrecibopdf(remoteHandle, context).execute( AV88CliCod, AV7EmpCod, AV17LiqNro, A6LegNumero, "Vertical", false, false, GXv_char9, GXv_char7) ;
      liquidacionlegajowc_impl.this.AV99linkPDF = GXv_char9[0] ;
      liquidacionlegajowc_impl.this.AV98errorPDF = GXv_char7[0] ;
      if ( ! (GXutil.strcmp("", AV98errorPDF)==0) )
      {
         new web.alert(remoteHandle, context).execute( "error", AV98errorPDF) ;
      }
      else
      {
         Innewwindow1_Target = AV99linkPDF ;
         ucInnewwindow1.sendProperty(context, sPrefix, false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
         this.executeUsercontrolMethod(sPrefix, false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      }
   }

   public void S232( )
   {
      /* 'DO RECIBOSUELDO2' Routine */
      returnInSub = false ;
      GXv_char9[0] = AV99linkPDF ;
      GXv_char7[0] = AV98errorPDF ;
      new web.armaurlrecibopdf(remoteHandle, context).execute( AV88CliCod, AV7EmpCod, AV17LiqNro, A6LegNumero, "Apaisado", false, false, GXv_char9, GXv_char7) ;
      liquidacionlegajowc_impl.this.AV99linkPDF = GXv_char9[0] ;
      liquidacionlegajowc_impl.this.AV98errorPDF = GXv_char7[0] ;
      if ( ! (GXutil.strcmp("", AV98errorPDF)==0) )
      {
         new web.alert(remoteHandle, context).execute( "error", AV98errorPDF) ;
      }
      else
      {
         Innewwindow1_Target = AV99linkPDF ;
         ucInnewwindow1.sendProperty(context, sPrefix, false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
         this.executeUsercontrolMethod(sPrefix, false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      }
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV23Session.getValue(AV163Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV163Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV23Session.getValue(AV163Pgmname+"GridState"), null, null);
      }
      AV92OrderedBy = AV12GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV92OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV92OrderedBy), 4, 0));
      AV19OrderedDsc = AV12GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19OrderedDsc", AV19OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S202 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV12GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV12GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
   }

   public void S202( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV164GXV1 = 1 ;
      while ( AV164GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV164GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPBASICO") == 0 )
         {
            AV110TFLiqLegImpBasico = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV110TFLiqLegImpBasico", GXutil.ltrimstr( AV110TFLiqLegImpBasico, 14, 2));
            AV111TFLiqLegImpBasico_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV111TFLiqLegImpBasico_To", GXutil.ltrimstr( AV111TFLiqLegImpBasico_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUTO") == 0 )
         {
            AV93TFLiqLegImpTotBruto = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV93TFLiqLegImpTotBruto", GXutil.ltrimstr( AV93TFLiqLegImpTotBruto, 14, 2));
            AV94TFLiqLegImpTotBruto_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV94TFLiqLegImpTotBruto_To", GXutil.ltrimstr( AV94TFLiqLegImpTotBruto_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUSINSAC") == 0 )
         {
            AV108TFLiqLegImpTotBruSinSAC = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV108TFLiqLegImpTotBruSinSAC", GXutil.ltrimstr( AV108TFLiqLegImpTotBruSinSAC, 14, 2));
            AV109TFLiqLegImpTotBruSinSAC_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV109TFLiqLegImpTotBruSinSAC_To", GXutil.ltrimstr( AV109TFLiqLegImpTotBruSinSAC_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTRETGAN") == 0 )
         {
            AV102TFLiqLegImpTotRetGan = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV102TFLiqLegImpTotRetGan", GXutil.ltrimstr( AV102TFLiqLegImpTotRetGan, 14, 2));
            AV103TFLiqLegImpTotRetGan_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV103TFLiqLegImpTotRetGan_To", GXutil.ltrimstr( AV103TFLiqLegImpTotRetGan_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGERROR") == 0 )
         {
            AV132TFLiqLegError = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV132TFLiqLegError", AV132TFLiqLegError);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGERROR_SEL") == 0 )
         {
            AV131TFLiqLegError_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV131TFLiqLegError_SelsJson", AV131TFLiqLegError_SelsJson);
            AV133TFLiqLegError_Sels.fromJSonString(AV131TFLiqLegError_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGERRORAUX") == 0 )
         {
            AV140TFLiqLegErrorAux = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV140TFLiqLegErrorAux", AV140TFLiqLegErrorAux);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGERRORAUX_SEL") == 0 )
         {
            AV139TFLiqLegErrorAux_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV139TFLiqLegErrorAux_SelsJson", AV139TFLiqLegErrorAux_SelsJson);
            AV141TFLiqLegErrorAux_Sels.fromJSonString(AV139TFLiqLegErrorAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPCONTR") == 0 )
         {
            AV121TFLiqLegImpContr = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV121TFLiqLegImpContr", GXutil.ltrimstr( AV121TFLiqLegImpContr, 14, 2));
            AV122TFLiqLegImpContr_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV122TFLiqLegImpContr_To", GXutil.ltrimstr( AV122TFLiqLegImpContr_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGITERACIONES") == 0 )
         {
            AV125TFLIqLegIteraciones = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV125TFLIqLegIteraciones", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV125TFLIqLegIteraciones), 4, 0));
            AV126TFLIqLegIteraciones_To = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV126TFLIqLegIteraciones_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV126TFLIqLegIteraciones_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGSEGUNDOS") == 0 )
         {
            AV127TFLiqLegSegundos = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV127TFLiqLegSegundos", GXutil.ltrimstr( AV127TFLiqLegSegundos, 10, 6));
            AV128TFLiqLegSegundos_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV128TFLiqLegSegundos_To", GXutil.ltrimstr( AV128TFLiqLegSegundos_To, 10, 6));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGAUXESTADO_SEL") == 0 )
         {
            AV142TFLiqLegAuxEstado_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV142TFLiqLegAuxEstado_SelsJson", AV142TFLiqLegAuxEstado_SelsJson);
            AV143TFLiqLegAuxEstado_Sels.fromJSonString(AV142TFLiqLegAuxEstado_SelsJson, null);
         }
         AV164GXV1 = (int)(AV164GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char9[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV133TFLiqLegError_Sels.size()==0), AV131TFLiqLegError_SelsJson, GXv_char9) ;
      liquidacionlegajowc_impl.this.GXt_char6 = GXv_char9[0] ;
      GXt_char14 = "" ;
      GXv_char7[0] = GXt_char14 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV141TFLiqLegErrorAux_Sels.size()==0), AV139TFLiqLegErrorAux_SelsJson, GXv_char7) ;
      liquidacionlegajowc_impl.this.GXt_char14 = GXv_char7[0] ;
      Ddo_grid_Selectedvalue_set = "||||||||"+GXt_char6+"|"+GXt_char14+"||||"+((AV143TFLiqLegAuxEstado_Sels.size()==0) ? "" : AV142TFLiqLegAuxEstado_SelsJson) ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char14 = "" ;
      GXv_char9[0] = GXt_char14 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV132TFLiqLegError)==0), AV132TFLiqLegError, GXv_char9) ;
      liquidacionlegajowc_impl.this.GXt_char14 = GXv_char9[0] ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV140TFLiqLegErrorAux)==0), AV140TFLiqLegErrorAux, GXv_char7) ;
      liquidacionlegajowc_impl.this.GXt_char6 = GXv_char7[0] ;
      Ddo_grid_Filteredtext_set = "|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV110TFLiqLegImpBasico)==0) ? "" : GXutil.str( AV110TFLiqLegImpBasico, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV93TFLiqLegImpTotBruto)==0) ? "" : GXutil.str( AV93TFLiqLegImpTotBruto, 14, 2))+"||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV108TFLiqLegImpTotBruSinSAC)==0) ? "" : GXutil.str( AV108TFLiqLegImpTotBruSinSAC, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV102TFLiqLegImpTotRetGan)==0) ? "" : GXutil.str( AV102TFLiqLegImpTotRetGan, 14, 2))+"|||"+GXt_char14+"|"+GXt_char6+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV121TFLiqLegImpContr)==0) ? "" : GXutil.str( AV121TFLiqLegImpContr, 14, 2))+"|"+((0==AV125TFLIqLegIteraciones) ? "" : GXutil.str( AV125TFLIqLegIteraciones, 4, 0))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV127TFLiqLegSegundos)==0) ? "" : GXutil.str( AV127TFLiqLegSegundos, 10, 6))+"|" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV111TFLiqLegImpBasico_To)==0) ? "" : GXutil.str( AV111TFLiqLegImpBasico_To, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV94TFLiqLegImpTotBruto_To)==0) ? "" : GXutil.str( AV94TFLiqLegImpTotBruto_To, 14, 2))+"||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV109TFLiqLegImpTotBruSinSAC_To)==0) ? "" : GXutil.str( AV109TFLiqLegImpTotBruSinSAC_To, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV103TFLiqLegImpTotRetGan_To)==0) ? "" : GXutil.str( AV103TFLiqLegImpTotRetGan_To, 14, 2))+"|||||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV122TFLiqLegImpContr_To)==0) ? "" : GXutil.str( AV122TFLiqLegImpContr_To, 14, 2))+"|"+((0==AV126TFLIqLegIteraciones_To) ? "" : GXutil.str( AV126TFLIqLegIteraciones_To, 4, 0))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV128TFLiqLegSegundos_To)==0) ? "" : GXutil.str( AV128TFLiqLegSegundos_To, 10, 6))+"|" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S172( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV23Session.getValue(AV163Pgmname+"GridState"), null, null);
      AV12GridState.setgxTv_SdtWWPGridState_Orderedby( AV92OrderedBy );
      AV12GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV19OrderedDsc );
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState15[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState15, "TFLIQLEGIMPBASICO", httpContext.getMessage( "Básico", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV110TFLiqLegImpBasico)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV111TFLiqLegImpBasico_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV110TFLiqLegImpBasico, 14, 2)), GXutil.trim( GXutil.str( AV111TFLiqLegImpBasico_To, 14, 2))) ;
      AV12GridState = GXv_SdtWWPGridState15[0] ;
      GXv_SdtWWPGridState15[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState15, "TFLIQLEGIMPTOTBRUTO", httpContext.getMessage( "Bruto", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV93TFLiqLegImpTotBruto)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV94TFLiqLegImpTotBruto_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV93TFLiqLegImpTotBruto, 14, 2)), GXutil.trim( GXutil.str( AV94TFLiqLegImpTotBruto_To, 14, 2))) ;
      AV12GridState = GXv_SdtWWPGridState15[0] ;
      GXv_SdtWWPGridState15[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState15, "TFLIQLEGIMPTOTBRUSINSAC", httpContext.getMessage( "Bruto sin SAC", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV108TFLiqLegImpTotBruSinSAC)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV109TFLiqLegImpTotBruSinSAC_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV108TFLiqLegImpTotBruSinSAC, 14, 2)), GXutil.trim( GXutil.str( AV109TFLiqLegImpTotBruSinSAC_To, 14, 2))) ;
      AV12GridState = GXv_SdtWWPGridState15[0] ;
      GXv_SdtWWPGridState15[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState15, "TFLIQLEGIMPTOTRETGAN", httpContext.getMessage( "Ret. IIGG", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV102TFLiqLegImpTotRetGan)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV103TFLiqLegImpTotRetGan_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV102TFLiqLegImpTotRetGan, 14, 2)), GXutil.trim( GXutil.str( AV103TFLiqLegImpTotRetGan_To, 14, 2))) ;
      AV12GridState = GXv_SdtWWPGridState15[0] ;
      GXv_SdtWWPGridState15[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState15, "TFLIQLEGERROR", httpContext.getMessage( "Error", ""), !(GXutil.strcmp("", AV132TFLiqLegError)==0), (short)(0), AV132TFLiqLegError, "", !(AV133TFLiqLegError_Sels.size()==0), AV133TFLiqLegError_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState15[0] ;
      GXv_SdtWWPGridState15[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState15, "TFLIQLEGERRORAUX", httpContext.getMessage( "Error conceptos auxiliares", ""), !(GXutil.strcmp("", AV140TFLiqLegErrorAux)==0), (short)(0), AV140TFLiqLegErrorAux, "", !(AV141TFLiqLegErrorAux_Sels.size()==0), AV141TFLiqLegErrorAux_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState15[0] ;
      GXv_SdtWWPGridState15[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState15, "TFLIQLEGIMPCONTR", httpContext.getMessage( "Contr.", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV121TFLiqLegImpContr)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV122TFLiqLegImpContr_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV121TFLiqLegImpContr, 14, 2)), GXutil.trim( GXutil.str( AV122TFLiqLegImpContr_To, 14, 2))) ;
      AV12GridState = GXv_SdtWWPGridState15[0] ;
      GXv_SdtWWPGridState15[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState15, "TFLIQLEGITERACIONES", httpContext.getMessage( "Iteraciones Proceso", ""), !((0==AV125TFLIqLegIteraciones)&&(0==AV126TFLIqLegIteraciones_To)), (short)(0), GXutil.trim( GXutil.str( AV125TFLIqLegIteraciones, 4, 0)), GXutil.trim( GXutil.str( AV126TFLIqLegIteraciones_To, 4, 0))) ;
      AV12GridState = GXv_SdtWWPGridState15[0] ;
      GXv_SdtWWPGridState15[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState15, "TFLIQLEGSEGUNDOS", httpContext.getMessage( "Segundos", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV127TFLiqLegSegundos)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV128TFLiqLegSegundos_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV127TFLiqLegSegundos, 10, 6)), GXutil.trim( GXutil.str( AV128TFLiqLegSegundos_To, 10, 6))) ;
      AV12GridState = GXv_SdtWWPGridState15[0] ;
      GXv_SdtWWPGridState15[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState15, "TFLIQLEGAUXESTADO_SEL", httpContext.getMessage( "Estado conceptos auxiliares", ""), !(AV143TFLiqLegAuxEstado_Sels.size()==0), (short)(0), AV143TFLiqLegAuxEstado_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState15[0] ;
      if ( ! (GXutil.strcmp("", AV134MenuOpcCod)==0) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV134MenuOpcCod );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      if ( ! (0==AV88CliCod) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&CLICOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV88CliCod, 6, 0) );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      if ( ! (0==AV7EmpCod) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&EMPCOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV7EmpCod, 4, 0) );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      if ( ! (0==AV17LiqNro) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&LIQNRO" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV17LiqNro, 8, 0) );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      AV12GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV163Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV27TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV27TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV163Pgmname );
      AV27TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV27TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV14HTTPRequest.getScriptName()+"?"+AV14HTTPRequest.getQuerystring() );
      AV27TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "LiquidacionLegajo" );
      AV23Session.setValue("TrnContext", AV27TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e18512( )
   {
      /* Erroresver_Controlvaluechanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'VER ERRORES' */
      S242 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV85ColumnsSelector", AV85ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV133TFLiqLegError_Sels", AV133TFLiqLegError_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV146LiqLegError", AV146LiqLegError);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV151ManageFiltersData", AV151ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV12GridState", AV12GridState);
   }

   public void S252( )
   {
      /* 'DO RECIBOSTODOS1' Routine */
      returnInSub = false ;
      GXv_char9[0] = "" ;
      GXv_char7[0] = AV99linkPDF ;
      new web.armaurlrecibopdf(remoteHandle, context).execute( AV88CliCod, AV7EmpCod, AV17LiqNro, 0, "Vertical", false, false, GXv_char9, GXv_char7) ;
      liquidacionlegajowc_impl.this.AV99linkPDF = GXv_char7[0] ;
      if ( ! (GXutil.strcmp("", AV98errorPDF)==0) )
      {
         new web.alert(remoteHandle, context).execute( "error", AV98errorPDF) ;
      }
      else
      {
         Innewwindow1_Target = AV99linkPDF ;
         ucInnewwindow1.sendProperty(context, sPrefix, false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
         this.executeUsercontrolMethod(sPrefix, false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      }
   }

   public void S262( )
   {
      /* 'DO RECIBOSTODOS2' Routine */
      returnInSub = false ;
      GXv_char9[0] = AV99linkPDF ;
      GXv_char7[0] = AV98errorPDF ;
      new web.armaurlrecibopdf(remoteHandle, context).execute( AV88CliCod, AV7EmpCod, AV17LiqNro, 0, "Apaisado", false, false, GXv_char9, GXv_char7) ;
      liquidacionlegajowc_impl.this.AV99linkPDF = GXv_char9[0] ;
      liquidacionlegajowc_impl.this.AV98errorPDF = GXv_char7[0] ;
      if ( ! (GXutil.strcmp("", AV98errorPDF)==0) )
      {
         new web.alert(remoteHandle, context).execute( "error", AV98errorPDF) ;
      }
      else
      {
         Innewwindow1_Target = AV99linkPDF ;
         ucInnewwindow1.sendProperty(context, sPrefix, false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
         this.executeUsercontrolMethod(sPrefix, false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
      }
   }

   public void S152( )
   {
      /* 'VER ERRORES VISIBLE' Routine */
      returnInSub = false ;
      GXv_objcol_svchar16[0] = AV146LiqLegError ;
      GXv_boolean2[0] = AV147errorHay ;
      new web.geterroresliqleg(remoteHandle, context).execute( AV88CliCod, AV7EmpCod, AV17LiqNro, GXv_objcol_svchar16, GXv_boolean2) ;
      AV146LiqLegError = GXv_objcol_svchar16[0] ;
      liquidacionlegajowc_impl.this.AV147errorHay = GXv_boolean2[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV147errorHay", AV147errorHay);
   }

   public void S242( )
   {
      /* 'VER ERRORES' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'VER ERRORES VISIBLE' */
      S152 ();
      if (returnInSub) return;
      if ( AV148ErroresVer )
      {
         AV150i = (short)(1) ;
         while ( AV150i <= AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            if ( GXutil.strcmp(((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV150i)).getgxTv_SdtWWPColumnsSelector_Column_Columnname(), httpContext.getMessage( "LiqLegError", "")) == 0 )
            {
               ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV85ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV150i)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
            }
            AV150i = (short)(AV150i+1) ;
         }
         new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "LiquidacionLegajoWCColumnsSelector", AV85ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay")) ;
         AV133TFLiqLegError_Sels.fromJSonString(AV146LiqLegError.toJSonString(false), null);
      }
      else
      {
         AV133TFLiqLegError_Sels.clear();
         AV132TFLiqLegError = "" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV132TFLiqLegError", AV132TFLiqLegError);
      }
      httpContext.doAjaxRefreshCmp(sPrefix);
   }

   public void S272( )
   {
      /* 'DOEXPORT' Routine */
      returnInSub = false ;
   }

   public void wb_table3_116_512( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_eliminarlegajo_Internalname, tblTabledvelop_confirmpanel_eliminarlegajo_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_eliminarlegajo.setProperty("Title", Dvelop_confirmpanel_eliminarlegajo_Title);
         ucDvelop_confirmpanel_eliminarlegajo.setProperty("ConfirmationText", Dvelop_confirmpanel_eliminarlegajo_Confirmationtext);
         ucDvelop_confirmpanel_eliminarlegajo.setProperty("YesButtonCaption", Dvelop_confirmpanel_eliminarlegajo_Yesbuttoncaption);
         ucDvelop_confirmpanel_eliminarlegajo.setProperty("NoButtonCaption", Dvelop_confirmpanel_eliminarlegajo_Nobuttoncaption);
         ucDvelop_confirmpanel_eliminarlegajo.setProperty("CancelButtonCaption", Dvelop_confirmpanel_eliminarlegajo_Cancelbuttoncaption);
         ucDvelop_confirmpanel_eliminarlegajo.setProperty("YesButtonPosition", Dvelop_confirmpanel_eliminarlegajo_Yesbuttonposition);
         ucDvelop_confirmpanel_eliminarlegajo.setProperty("ConfirmType", Dvelop_confirmpanel_eliminarlegajo_Confirmtype);
         ucDvelop_confirmpanel_eliminarlegajo.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_eliminarlegajo_Internalname, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJOContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJOContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_116_512e( true) ;
      }
      else
      {
         wb_table3_116_512e( false) ;
      }
   }

   public void wb_table2_68_512( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblButtonfilter1_tablebadge_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblButtonfilter1_tablebadge_Internalname, tblButtonfilter1_tablebadge_Internalname, "", "TableBadge", 0, "", tblButtonfilter1_tablebadge_Tooltiptext, 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionLegajoWC.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_68_512e( true) ;
      }
      else
      {
         wb_table2_68_512e( false) ;
      }
   }

   public void wb_table1_14_512( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabletotalregistros_Internalname, tblTabletotalregistros_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabletotal_Internalname, 1, 0, "px", 0, "px", "TotalPill ML15", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionLegajoWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_LiquidacionLegajoWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_14_512e( true) ;
      }
      else
      {
         wb_table1_14_512e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV134MenuOpcCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV134MenuOpcCod", AV134MenuOpcCod);
      AV88CliCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV88CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV88CliCod), 6, 0));
      AV7EmpCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7EmpCod), 4, 0));
      AV17LiqNro = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17LiqNro), 8, 0));
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      pa512( ) ;
      ws512( ) ;
      we512( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
      sCtrlAV134MenuOpcCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV88CliCod = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV7EmpCod = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlAV17LiqNro = (String)getParm(obj,3,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa512( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "liquidacionlegajowc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa512( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV134MenuOpcCod = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV134MenuOpcCod", AV134MenuOpcCod);
         AV88CliCod = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV88CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV88CliCod), 6, 0));
         AV7EmpCod = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7EmpCod), 4, 0));
         AV17LiqNro = ((Number) GXutil.testNumericType( getParm(obj,5,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17LiqNro), 8, 0));
      }
      wcpOAV134MenuOpcCod = httpContext.cgiGet( sPrefix+"wcpOAV134MenuOpcCod") ;
      wcpOAV88CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV88CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV7EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV7EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV17LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV17LiqNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV134MenuOpcCod, wcpOAV134MenuOpcCod) != 0 ) || ( AV88CliCod != wcpOAV88CliCod ) || ( AV7EmpCod != wcpOAV7EmpCod ) || ( AV17LiqNro != wcpOAV17LiqNro ) ) )
      {
         setjustcreated();
      }
      wcpOAV134MenuOpcCod = AV134MenuOpcCod ;
      wcpOAV88CliCod = AV88CliCod ;
      wcpOAV7EmpCod = AV7EmpCod ;
      wcpOAV17LiqNro = AV17LiqNro ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV134MenuOpcCod = httpContext.cgiGet( sPrefix+"AV134MenuOpcCod_CTRL") ;
      if ( GXutil.len( sCtrlAV134MenuOpcCod) > 0 )
      {
         AV134MenuOpcCod = httpContext.cgiGet( sCtrlAV134MenuOpcCod) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV134MenuOpcCod", AV134MenuOpcCod);
      }
      else
      {
         AV134MenuOpcCod = httpContext.cgiGet( sPrefix+"AV134MenuOpcCod_PARM") ;
      }
      sCtrlAV88CliCod = httpContext.cgiGet( sPrefix+"AV88CliCod_CTRL") ;
      if ( GXutil.len( sCtrlAV88CliCod) > 0 )
      {
         AV88CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV88CliCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV88CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV88CliCod), 6, 0));
      }
      else
      {
         AV88CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV88CliCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV7EmpCod = httpContext.cgiGet( sPrefix+"AV7EmpCod_CTRL") ;
      if ( GXutil.len( sCtrlAV7EmpCod) > 0 )
      {
         AV7EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlAV7EmpCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7EmpCod), 4, 0));
      }
      else
      {
         AV7EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV7EmpCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV17LiqNro = httpContext.cgiGet( sPrefix+"AV17LiqNro_CTRL") ;
      if ( GXutil.len( sCtrlAV17LiqNro) > 0 )
      {
         AV17LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV17LiqNro), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17LiqNro), 8, 0));
      }
      else
      {
         AV17LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV17LiqNro_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
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
      initweb( ) ;
      nDraw = (byte)(0) ;
      pa512( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws512( ) ;
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
      ws512( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV134MenuOpcCod_PARM", AV134MenuOpcCod);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV134MenuOpcCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV134MenuOpcCod_CTRL", GXutil.rtrim( sCtrlAV134MenuOpcCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV88CliCod_PARM", GXutil.ltrim( localUtil.ntoc( AV88CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV88CliCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV88CliCod_CTRL", GXutil.rtrim( sCtrlAV88CliCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7EmpCod_PARM", GXutil.ltrim( localUtil.ntoc( AV7EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV7EmpCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7EmpCod_CTRL", GXutil.rtrim( sCtrlAV7EmpCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV17LiqNro_PARM", GXutil.ltrim( localUtil.ntoc( AV17LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV17LiqNro)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV17LiqNro_CTRL", GXutil.rtrim( sCtrlAV17LiqNro));
      }
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
      we512( ) ;
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
      httpContext.AddStyleSheetFile("a3lfilter.css", "");
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171351529", true, true);
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
      httpContext.AddJavascriptSource("liquidacionlegajowc.js", "?2025171351529", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LClonEventRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LFilterRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("Window/InNewWindowRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_772( )
   {
      edtavEliminarlegajo_Internalname = sPrefix+"vELIMINARLEGAJO_"+sGXsfl_77_idx ;
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO_"+sGXsfl_77_idx ;
      edtavLeghtml_Internalname = sPrefix+"vLEGHTML_"+sGXsfl_77_idx ;
      cmbavGridactiongroup1.setInternalname( sPrefix+"vGRIDACTIONGROUP1_"+sGXsfl_77_idx );
      edtLegIdNomApe_Internalname = sPrefix+"LEGIDNOMAPE_"+sGXsfl_77_idx ;
      edtLiqLegImpBasico_Internalname = sPrefix+"LIQLEGIMPBASICO_"+sGXsfl_77_idx ;
      edtLiqLegImpTotBruProm_Internalname = sPrefix+"LIQLEGIMPTOTBRUPROM_"+sGXsfl_77_idx ;
      edtLiqLegImpTotBruto_Internalname = sPrefix+"LIQLEGIMPTOTBRUTO_"+sGXsfl_77_idx ;
      edtLiqLegImpTotal_Internalname = sPrefix+"LIQLEGIMPTOTAL_"+sGXsfl_77_idx ;
      edtLiqLegImpTotBruSinSAC_Internalname = sPrefix+"LIQLEGIMPTOTBRUSINSAC_"+sGXsfl_77_idx ;
      edtLiqLegImpTotDescu_Internalname = sPrefix+"LIQLEGIMPTOTDESCU_"+sGXsfl_77_idx ;
      edtLiqLegImpTotRetGan_Internalname = sPrefix+"LIQLEGIMPTOTRETGAN_"+sGXsfl_77_idx ;
      edtavLiqlegimpotrdescu_Internalname = sPrefix+"vLIQLEGIMPOTRDESCU_"+sGXsfl_77_idx ;
      edtavLiqlegimptotdescu_Internalname = sPrefix+"vLIQLEGIMPTOTDESCU_"+sGXsfl_77_idx ;
      edtLiqLegError_Internalname = sPrefix+"LIQLEGERROR_"+sGXsfl_77_idx ;
      edtLiqLegErrorAux_Internalname = sPrefix+"LIQLEGERRORAUX_"+sGXsfl_77_idx ;
      edtLegCUIL_Internalname = sPrefix+"LEGCUIL_"+sGXsfl_77_idx ;
      edtLiqRutaPDF_Internalname = sPrefix+"LIQRUTAPDF_"+sGXsfl_77_idx ;
      edtLiqRutaPDFVertical_Internalname = sPrefix+"LIQRUTAPDFVERTICAL_"+sGXsfl_77_idx ;
      edtLiqLegImpContr_Internalname = sPrefix+"LIQLEGIMPCONTR_"+sGXsfl_77_idx ;
      edtLiqLegImpCosto_Internalname = sPrefix+"LIQLEGIMPCOSTO_"+sGXsfl_77_idx ;
      edtLIqLegIteraciones_Internalname = sPrefix+"LIQLEGITERACIONES_"+sGXsfl_77_idx ;
      edtLiqLegSegundos_Internalname = sPrefix+"LIQLEGSEGUNDOS_"+sGXsfl_77_idx ;
      cmbLiqLegAuxEstado.setInternalname( sPrefix+"LIQLEGAUXESTADO_"+sGXsfl_77_idx );
      cmbLiqLegPDFEstado.setInternalname( sPrefix+"LIQLEGPDFESTADO_"+sGXsfl_77_idx );
      edtavAjustes_Internalname = sPrefix+"vAJUSTES_"+sGXsfl_77_idx ;
      edtavDisplay_Internalname = sPrefix+"vDISPLAY_"+sGXsfl_77_idx ;
      edtavVersvg_Internalname = sPrefix+"vVERSVG_"+sGXsfl_77_idx ;
   }

   public void subsflControlProps_fel_772( )
   {
      edtavEliminarlegajo_Internalname = sPrefix+"vELIMINARLEGAJO_"+sGXsfl_77_fel_idx ;
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO_"+sGXsfl_77_fel_idx ;
      edtavLeghtml_Internalname = sPrefix+"vLEGHTML_"+sGXsfl_77_fel_idx ;
      cmbavGridactiongroup1.setInternalname( sPrefix+"vGRIDACTIONGROUP1_"+sGXsfl_77_fel_idx );
      edtLegIdNomApe_Internalname = sPrefix+"LEGIDNOMAPE_"+sGXsfl_77_fel_idx ;
      edtLiqLegImpBasico_Internalname = sPrefix+"LIQLEGIMPBASICO_"+sGXsfl_77_fel_idx ;
      edtLiqLegImpTotBruProm_Internalname = sPrefix+"LIQLEGIMPTOTBRUPROM_"+sGXsfl_77_fel_idx ;
      edtLiqLegImpTotBruto_Internalname = sPrefix+"LIQLEGIMPTOTBRUTO_"+sGXsfl_77_fel_idx ;
      edtLiqLegImpTotal_Internalname = sPrefix+"LIQLEGIMPTOTAL_"+sGXsfl_77_fel_idx ;
      edtLiqLegImpTotBruSinSAC_Internalname = sPrefix+"LIQLEGIMPTOTBRUSINSAC_"+sGXsfl_77_fel_idx ;
      edtLiqLegImpTotDescu_Internalname = sPrefix+"LIQLEGIMPTOTDESCU_"+sGXsfl_77_fel_idx ;
      edtLiqLegImpTotRetGan_Internalname = sPrefix+"LIQLEGIMPTOTRETGAN_"+sGXsfl_77_fel_idx ;
      edtavLiqlegimpotrdescu_Internalname = sPrefix+"vLIQLEGIMPOTRDESCU_"+sGXsfl_77_fel_idx ;
      edtavLiqlegimptotdescu_Internalname = sPrefix+"vLIQLEGIMPTOTDESCU_"+sGXsfl_77_fel_idx ;
      edtLiqLegError_Internalname = sPrefix+"LIQLEGERROR_"+sGXsfl_77_fel_idx ;
      edtLiqLegErrorAux_Internalname = sPrefix+"LIQLEGERRORAUX_"+sGXsfl_77_fel_idx ;
      edtLegCUIL_Internalname = sPrefix+"LEGCUIL_"+sGXsfl_77_fel_idx ;
      edtLiqRutaPDF_Internalname = sPrefix+"LIQRUTAPDF_"+sGXsfl_77_fel_idx ;
      edtLiqRutaPDFVertical_Internalname = sPrefix+"LIQRUTAPDFVERTICAL_"+sGXsfl_77_fel_idx ;
      edtLiqLegImpContr_Internalname = sPrefix+"LIQLEGIMPCONTR_"+sGXsfl_77_fel_idx ;
      edtLiqLegImpCosto_Internalname = sPrefix+"LIQLEGIMPCOSTO_"+sGXsfl_77_fel_idx ;
      edtLIqLegIteraciones_Internalname = sPrefix+"LIQLEGITERACIONES_"+sGXsfl_77_fel_idx ;
      edtLiqLegSegundos_Internalname = sPrefix+"LIQLEGSEGUNDOS_"+sGXsfl_77_fel_idx ;
      cmbLiqLegAuxEstado.setInternalname( sPrefix+"LIQLEGAUXESTADO_"+sGXsfl_77_fel_idx );
      cmbLiqLegPDFEstado.setInternalname( sPrefix+"LIQLEGPDFESTADO_"+sGXsfl_77_fel_idx );
      edtavAjustes_Internalname = sPrefix+"vAJUSTES_"+sGXsfl_77_fel_idx ;
      edtavDisplay_Internalname = sPrefix+"vDISPLAY_"+sGXsfl_77_fel_idx ;
      edtavVersvg_Internalname = sPrefix+"vVERSVG_"+sGXsfl_77_fel_idx ;
   }

   public void sendrow_772( )
   {
      subsflControlProps_772( ) ;
      wb510( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_77_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
      {
         GridRow = GXWebRow.GetNew(context,GridContainer) ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            subGrid_Backcolor = subGrid_Allbackcolor ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Uniform" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
            subGrid_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_77_idx) % (2))) == 0 )
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Even" ;
               }
            }
            else
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Odd" ;
               }
            }
         }
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridWithPaginationBar WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_77_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEliminarlegajo_Enabled!=0)&&(edtavEliminarlegajo_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 78,'"+sPrefix+"',false,'"+sGXsfl_77_idx+"',77)\"" : " ") ;
         ROClassString = edtavEliminarlegajo_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarlegajo_Internalname,GXutil.rtrim( AV6EliminarLegajo),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEliminarlegajo_Enabled!=0)&&(edtavEliminarlegajo_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,78);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+"e23512_client"+"'","","","","",edtavEliminarlegajo_Jsonclick,Integer.valueOf(7),edtavEliminarlegajo_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavEliminarlegajo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNumero_Internalname,GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegNumero_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavLeghtml_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavLeghtml_Enabled!=0)&&(edtavLeghtml_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 80,'"+sPrefix+"',false,'"+sGXsfl_77_idx+"',77)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavLeghtml_Internalname,AV159LegHtml,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavLeghtml_Enabled!=0)&&(edtavLeghtml_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,80);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavLeghtml_Link,"","","",edtavLeghtml_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn LegajoHTMLColumn","",Integer.valueOf(edtavLeghtml_Visible),Integer.valueOf(edtavLeghtml_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4000),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         TempTags = " " + ((cmbavGridactiongroup1.getEnabled()!=0)&&(cmbavGridactiongroup1.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 81,'"+sPrefix+"',false,'"+sGXsfl_77_idx+"',77)\"" : " ") ;
         if ( ( cmbavGridactiongroup1.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "vGRIDACTIONGROUP1_" + sGXsfl_77_idx ;
            cmbavGridactiongroup1.setName( GXCCtl );
            cmbavGridactiongroup1.setWebtags( "" );
            if ( cmbavGridactiongroup1.getItemCount() > 0 )
            {
               AV87GridActionGroup1 = (short)(GXutil.lval( cmbavGridactiongroup1.getValidValue(GXutil.trim( GXutil.str( AV87GridActionGroup1, 4, 0))))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, cmbavGridactiongroup1.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV87GridActionGroup1), 4, 0));
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavGridactiongroup1,cmbavGridactiongroup1.getInternalname(),GXutil.trim( GXutil.str( AV87GridActionGroup1, 4, 0)),Integer.valueOf(1),cmbavGridactiongroup1.getJsonclick(),Integer.valueOf(5),"'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVGRIDACTIONGROUP1.CLICK."+sGXsfl_77_idx+"'","int","",Integer.valueOf(-1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","ConvertToDDO","WWActionGroupColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavGridactiongroup1.getEnabled()!=0)&&(cmbavGridactiongroup1.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,81);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbavGridactiongroup1.setValue( GXutil.trim( GXutil.str( AV87GridActionGroup1, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavGridactiongroup1.getInternalname(), "Values", cmbavGridactiongroup1.ToJavascriptSource(), !bGXsfl_77_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegIdNomApe_Internalname,A250LegIdNomApe,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegIdNomApe_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn ColumnWeightBold","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqLegImpBasico_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegImpBasico_Internalname,GXutil.ltrim( localUtil.ntoc( A760LiqLegImpBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A760LiqLegImpBasico, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegImpBasico_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqLegImpBasico_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegImpTotBruProm_Internalname,GXutil.ltrim( localUtil.ntoc( A758LiqLegImpTotBruProm, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A758LiqLegImpTotBruProm, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegImpTotBruProm_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqLegImpTotBruto_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegImpTotBruto_Internalname,GXutil.ltrim( localUtil.ntoc( A498LiqLegImpTotBruto, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A498LiqLegImpTotBruto, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegImpTotBruto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn importeColumn","",Integer.valueOf(edtLiqLegImpTotBruto_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqLegImpTotal_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegImpTotal_Internalname,GXutil.ltrim( localUtil.ntoc( A281LiqLegImpTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A281LiqLegImpTotal, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegImpTotal_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn importeColumn hidden-xs","",Integer.valueOf(edtLiqLegImpTotal_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqLegImpTotBruSinSAC_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegImpTotBruSinSAC_Internalname,GXutil.ltrim( localUtil.ntoc( A759LiqLegImpTotBruSinSAC, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A759LiqLegImpTotBruSinSAC, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegImpTotBruSinSAC_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqLegImpTotBruSinSAC_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegImpTotDescu_Internalname,GXutil.ltrim( localUtil.ntoc( A579LiqLegImpTotDescu, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A579LiqLegImpTotDescu, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegImpTotDescu_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqLegImpTotRetGan_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegImpTotRetGan_Internalname,GXutil.ltrim( localUtil.ntoc( A757LiqLegImpTotRetGan, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A757LiqLegImpTotRetGan, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegImpTotRetGan_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn importeColumn","",Integer.valueOf(edtLiqLegImpTotRetGan_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"ImportesSigned","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtavLiqlegimpotrdescu_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavLiqlegimpotrdescu_Enabled!=0)&&(edtavLiqlegimpotrdescu_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 90,'"+sPrefix+"',false,'"+sGXsfl_77_idx+"',77)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavLiqlegimpotrdescu_Internalname,GXutil.ltrim( localUtil.ntoc( AV120LiqLegImpOtrDescu, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavLiqlegimpotrdescu_Enabled!=0) ? localUtil.format( AV120LiqLegImpOtrDescu, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV120LiqLegImpOtrDescu, "ZZ,ZZZ,ZZZ,ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+((edtavLiqlegimpotrdescu_Enabled!=0)&&(edtavLiqlegimpotrdescu_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,90);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavLiqlegimpotrdescu_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn importeColumn","",Integer.valueOf(edtavLiqlegimpotrdescu_Visible),Integer.valueOf(edtavLiqlegimpotrdescu_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtavLiqlegimptotdescu_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavLiqlegimptotdescu_Enabled!=0)&&(edtavLiqlegimptotdescu_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 91,'"+sPrefix+"',false,'"+sGXsfl_77_idx+"',77)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavLiqlegimptotdescu_Internalname,GXutil.ltrim( localUtil.ntoc( AV106LiqLegImpTotDescu, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavLiqlegimptotdescu_Enabled!=0) ? localUtil.format( AV106LiqLegImpTotDescu, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV106LiqLegImpTotDescu, "ZZ,ZZZ,ZZZ,ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+((edtavLiqlegimptotdescu_Enabled!=0)&&(edtavLiqlegimptotdescu_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,91);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavLiqlegimptotdescu_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavLiqlegimptotdescu_Visible),Integer.valueOf(edtavLiqlegimptotdescu_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"ImportesSigned","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqLegError_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegError_Internalname,A891LiqLegError,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegError_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqLegError_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"error","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqLegErrorAux_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegErrorAux_Internalname,A1781LiqLegErrorAux,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegErrorAux_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqLegErrorAux_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"error","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLegCUIL_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCUIL_Internalname,GXutil.ltrim( localUtil.ntoc( A239LegCUIL, (byte)(13), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A239LegCUIL), "ZZ-ZZZZZZZZ-9")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegCUIL_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegCUIL_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqRutaPDF_Internalname,A590LiqRutaPDF,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqRutaPDF_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqRutaPDFVertical_Internalname,A774LiqRutaPDFVertical,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqRutaPDFVertical_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqLegImpContr_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegImpContr_Internalname,GXutil.ltrim( localUtil.ntoc( A1157LiqLegImpContr, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1157LiqLegImpContr, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegImpContr_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn importeColumn","",Integer.valueOf(edtLiqLegImpContr_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegImpCosto_Internalname,GXutil.ltrim( localUtil.ntoc( A1158LiqLegImpCosto, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1158LiqLegImpCosto, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegImpCosto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLIqLegIteraciones_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLIqLegIteraciones_Internalname,GXutil.ltrim( localUtil.ntoc( A883LIqLegIteraciones, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A883LIqLegIteraciones), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLIqLegIteraciones_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLIqLegIteraciones_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqLegSegundos_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegSegundos_Internalname,GXutil.ltrim( localUtil.ntoc( A884LiqLegSegundos, (byte)(10), (byte)(6), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A884LiqLegSegundos, "ZZ9.999999")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegSegundos_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqLegSegundos_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbLiqLegAuxEstado.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbLiqLegAuxEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LIQLEGAUXESTADO_" + sGXsfl_77_idx ;
            cmbLiqLegAuxEstado.setName( GXCCtl );
            cmbLiqLegAuxEstado.setWebtags( "" );
            cmbLiqLegAuxEstado.addItem("0", httpContext.getMessage( "Pendiente", ""), (short)(0));
            cmbLiqLegAuxEstado.addItem("1", httpContext.getMessage( "Procesando...", ""), (short)(0));
            cmbLiqLegAuxEstado.addItem("2", httpContext.getMessage( "Error", ""), (short)(0));
            cmbLiqLegAuxEstado.addItem("3", httpContext.getMessage( "Completo", ""), (short)(0));
            cmbLiqLegAuxEstado.addItem("4", httpContext.getMessage( "Cerrada", ""), (short)(0));
            cmbLiqLegAuxEstado.addItem("5", httpContext.getMessage( "No aplica", ""), (short)(0));
            if ( cmbLiqLegAuxEstado.getItemCount() > 0 )
            {
               A1780LiqLegAuxEstado = (byte)(GXutil.lval( cmbLiqLegAuxEstado.getValidValue(GXutil.trim( GXutil.str( A1780LiqLegAuxEstado, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLiqLegAuxEstado,cmbLiqLegAuxEstado.getInternalname(),GXutil.trim( GXutil.str( A1780LiqLegAuxEstado, 1, 0)),Integer.valueOf(1),cmbLiqLegAuxEstado.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbLiqLegAuxEstado.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLiqLegAuxEstado.setValue( GXutil.trim( GXutil.str( A1780LiqLegAuxEstado, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqLegAuxEstado.getInternalname(), "Values", cmbLiqLegAuxEstado.ToJavascriptSource(), !bGXsfl_77_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         if ( ( cmbLiqLegPDFEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LIQLEGPDFESTADO_" + sGXsfl_77_idx ;
            cmbLiqLegPDFEstado.setName( GXCCtl );
            cmbLiqLegPDFEstado.setWebtags( "" );
            cmbLiqLegPDFEstado.addItem("Completo", httpContext.getMessage( "Completo", ""), (short)(0));
            cmbLiqLegPDFEstado.addItem("Enviado", httpContext.getMessage( "Enviado", ""), (short)(0));
            cmbLiqLegPDFEstado.addItem("Pendiente", httpContext.getMessage( "Procesando...", ""), (short)(0));
            cmbLiqLegPDFEstado.addItem("Error", httpContext.getMessage( "Error", ""), (short)(0));
            cmbLiqLegPDFEstado.addItem("Manual", httpContext.getMessage( "Manual", ""), (short)(0));
            cmbLiqLegPDFEstado.addItem("EnEspera", httpContext.getMessage( "Pendiente", ""), (short)(0));
            if ( cmbLiqLegPDFEstado.getItemCount() > 0 )
            {
               A2179LiqLegPDFEstado = cmbLiqLegPDFEstado.getValidValue(A2179LiqLegPDFEstado) ;
               n2179LiqLegPDFEstado = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLiqLegPDFEstado,cmbLiqLegPDFEstado.getInternalname(),GXutil.rtrim( A2179LiqLegPDFEstado),Integer.valueOf(1),cmbLiqLegPDFEstado.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLiqLegPDFEstado.setValue( GXutil.rtrim( A2179LiqLegPDFEstado) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqLegPDFEstado.getInternalname(), "Values", cmbLiqLegPDFEstado.ToJavascriptSource(), !bGXsfl_77_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavAjustes_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavAjustes_Enabled!=0)&&(edtavAjustes_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 103,'"+sPrefix+"',false,'"+sGXsfl_77_idx+"',77)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavAjustes_Internalname,GXutil.rtrim( AV129Ajustes),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavAjustes_Enabled!=0)&&(edtavAjustes_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,103);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavAjustes_Link,"",httpContext.getMessage( "Ajustes", ""),"",edtavAjustes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavAjustes_Visible),Integer.valueOf(edtavAjustes_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 104,'"+sPrefix+"',false,'"+sGXsfl_77_idx+"',77)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV136Display),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,104);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavVersvg_Enabled!=0)&&(edtavVersvg_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 105,'"+sPrefix+"',false,'"+sGXsfl_77_idx+"',77)\"" : " ") ;
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV135VerSVG),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavVersvg_Enabled!=0)&&(edtavVersvg_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,105);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(77),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes512( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_77_idx = ((subGrid_Islastpage==1)&&(nGXsfl_77_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_77_idx+1) ;
         sGXsfl_77_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_77_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_772( ) ;
      }
      /* End function sendrow_772 */
   }

   public void startgridcontrol77( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"77\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "GridWithPaginationBar WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            subGrid_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGrid_Class) > 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Title" ;
            }
         }
         else
         {
            subGrid_Titlebackstyle = (byte)(1) ;
            if ( subGrid_Backcolorstyle == 1 )
            {
               subGrid_Titlebackcolor = subGrid_Allbackcolor ;
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavEliminarlegajo_Class+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavLeghtml_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Legajo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"ConvertToDDO"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqLegImpBasico_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Básico", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqLegImpTotBruto_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Bruto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqLegImpTotal_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Neto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqLegImpTotBruSinSAC_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Bruto sin SAC", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqLegImpTotRetGan_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Ret. IIGG", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavLiqlegimpotrdescu_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Aportes", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavLiqlegimptotdescu_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Ret. Total", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqLegError_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Error", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqLegErrorAux_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Error conceptos auxiliares", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegCUIL_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "CUIL", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqLegImpContr_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Contr.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLIqLegIteraciones_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Iteraciones Proceso", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqLegSegundos_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Segundos", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbLiqLegAuxEstado.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Estado conceptos auxiliares", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavAjustes_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         GridContainer.AddObjectProperty("GridName", "Grid");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            GridContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            GridContainer.Clear();
         }
         GridContainer.SetWrapped(nGXWrapped);
         GridContainer.AddObjectProperty("GridName", "Grid");
         GridContainer.AddObjectProperty("Header", subGrid_Header);
         GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", sPrefix);
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV6EliminarLegajo));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavEliminarlegajo_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEliminarlegajo_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV159LegHtml);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavLeghtml_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavLeghtml_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavLeghtml_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV87GridActionGroup1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A250LegIdNomApe);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A760LiqLegImpBasico, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqLegImpBasico_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A758LiqLegImpTotBruProm, (byte)(17), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A498LiqLegImpTotBruto, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqLegImpTotBruto_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A281LiqLegImpTotal, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqLegImpTotal_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A759LiqLegImpTotBruSinSAC, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqLegImpTotBruSinSAC_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A579LiqLegImpTotDescu, (byte)(17), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A757LiqLegImpTotRetGan, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqLegImpTotRetGan_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV120LiqLegImpOtrDescu, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavLiqlegimpotrdescu_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavLiqlegimpotrdescu_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV106LiqLegImpTotDescu, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavLiqlegimptotdescu_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavLiqlegimptotdescu_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A891LiqLegError);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqLegError_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1781LiqLegErrorAux);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqLegErrorAux_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A239LegCUIL, (byte)(13), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegCUIL_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A590LiqRutaPDF);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A774LiqRutaPDFVertical);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1157LiqLegImpContr, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqLegImpContr_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1158LiqLegImpCosto, (byte)(17), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A883LIqLegIteraciones, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLIqLegIteraciones_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A884LiqLegSegundos, (byte)(10), (byte)(6), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqLegSegundos_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1780LiqLegAuxEstado, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbLiqLegAuxEstado.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A2179LiqLegPDFEstado));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV129Ajustes));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavAjustes_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavAjustes_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavAjustes_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV136Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV135VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblTotaltext_Internalname = sPrefix+"TOTALTEXT" ;
      lblCouttext_Internalname = sPrefix+"COUTTEXT" ;
      divTabletotal_Internalname = sPrefix+"TABLETOTAL" ;
      tblTabletotalregistros_Internalname = sPrefix+"TABLETOTALREGISTROS" ;
      chkavErroresver.setInternalname( sPrefix+"vERRORESVER" );
      divTablecheck_Internalname = sPrefix+"TABLECHECK" ;
      lblTextblock1_Internalname = sPrefix+"TEXTBLOCK1" ;
      divTablelabel_Internalname = sPrefix+"TABLELABEL" ;
      divTableliqerror_Internalname = sPrefix+"TABLELIQERROR" ;
      lblButtonexport1_textblock_svg_Internalname = sPrefix+"BUTTONEXPORT1_TEXTBLOCK_SVG" ;
      divButtonexport1_table_svg_Internalname = sPrefix+"BUTTONEXPORT1_TABLE_SVG" ;
      lblButtonexport1_textblock_texto_Internalname = sPrefix+"BUTTONEXPORT1_TEXTBLOCK_TEXTO" ;
      divButtonexport1_table_texto_Internalname = sPrefix+"BUTTONEXPORT1_TABLE_TEXTO" ;
      Buttonexport1_a3lexport_Internalname = sPrefix+"BUTTONEXPORT1_A3LEXPORT" ;
      divButtonexport1_tablecontentbuttonimport_Internalname = sPrefix+"BUTTONEXPORT1_TABLECONTENTBUTTONIMPORT" ;
      Ddo_gridcolumnsselector_Internalname = sPrefix+"DDO_GRIDCOLUMNSSELECTOR" ;
      Ddo_managefilters_Internalname = sPrefix+"DDO_MANAGEFILTERS" ;
      bttBtnexport_Internalname = sPrefix+"BTNEXPORT" ;
      Buttonfilter1_a3lfilter_Internalname = sPrefix+"BUTTONFILTER1_A3LFILTER" ;
      lblButtonfilters1_textblock_svg_Internalname = sPrefix+"BUTTONFILTERS1_TEXTBLOCK_SVG" ;
      divButtonfilters1_table_svg_Internalname = sPrefix+"BUTTONFILTERS1_TABLE_SVG" ;
      lblButtonfilters1_textblock_texto_Internalname = sPrefix+"BUTTONFILTERS1_TEXTBLOCK_TEXTO" ;
      divButtonfilters1_table_texto_Internalname = sPrefix+"BUTTONFILTERS1_TABLE_TEXTO" ;
      lblButtonfilter1_textblockbadgecount_Internalname = sPrefix+"BUTTONFILTER1_TEXTBLOCKBADGECOUNT" ;
      tblButtonfilter1_tablebadge_Internalname = sPrefix+"BUTTONFILTER1_TABLEBADGE" ;
      divButtonfilters1_filtros_Internalname = sPrefix+"BUTTONFILTERS1_FILTROS" ;
      divButtonfilter1_tablecontent_Internalname = sPrefix+"BUTTONFILTER1_TABLECONTENT" ;
      divTableactions_Internalname = sPrefix+"TABLEACTIONS" ;
      divTableheadercontent_Internalname = sPrefix+"TABLEHEADERCONTENT" ;
      edtavEliminarlegajo_Internalname = sPrefix+"vELIMINARLEGAJO" ;
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO" ;
      edtavLeghtml_Internalname = sPrefix+"vLEGHTML" ;
      cmbavGridactiongroup1.setInternalname( sPrefix+"vGRIDACTIONGROUP1" );
      edtLegIdNomApe_Internalname = sPrefix+"LEGIDNOMAPE" ;
      edtLiqLegImpBasico_Internalname = sPrefix+"LIQLEGIMPBASICO" ;
      edtLiqLegImpTotBruProm_Internalname = sPrefix+"LIQLEGIMPTOTBRUPROM" ;
      edtLiqLegImpTotBruto_Internalname = sPrefix+"LIQLEGIMPTOTBRUTO" ;
      edtLiqLegImpTotal_Internalname = sPrefix+"LIQLEGIMPTOTAL" ;
      edtLiqLegImpTotBruSinSAC_Internalname = sPrefix+"LIQLEGIMPTOTBRUSINSAC" ;
      edtLiqLegImpTotDescu_Internalname = sPrefix+"LIQLEGIMPTOTDESCU" ;
      edtLiqLegImpTotRetGan_Internalname = sPrefix+"LIQLEGIMPTOTRETGAN" ;
      edtavLiqlegimpotrdescu_Internalname = sPrefix+"vLIQLEGIMPOTRDESCU" ;
      edtavLiqlegimptotdescu_Internalname = sPrefix+"vLIQLEGIMPTOTDESCU" ;
      edtLiqLegError_Internalname = sPrefix+"LIQLEGERROR" ;
      edtLiqLegErrorAux_Internalname = sPrefix+"LIQLEGERRORAUX" ;
      edtLegCUIL_Internalname = sPrefix+"LEGCUIL" ;
      edtLiqRutaPDF_Internalname = sPrefix+"LIQRUTAPDF" ;
      edtLiqRutaPDFVertical_Internalname = sPrefix+"LIQRUTAPDFVERTICAL" ;
      edtLiqLegImpContr_Internalname = sPrefix+"LIQLEGIMPCONTR" ;
      edtLiqLegImpCosto_Internalname = sPrefix+"LIQLEGIMPCOSTO" ;
      edtLIqLegIteraciones_Internalname = sPrefix+"LIQLEGITERACIONES" ;
      edtLiqLegSegundos_Internalname = sPrefix+"LIQLEGSEGUNDOS" ;
      cmbLiqLegAuxEstado.setInternalname( sPrefix+"LIQLEGAUXESTADO" );
      cmbLiqLegPDFEstado.setInternalname( sPrefix+"LIQLEGPDFESTADO" );
      edtavAjustes_Internalname = sPrefix+"vAJUSTES" ;
      edtavDisplay_Internalname = sPrefix+"vDISPLAY" ;
      edtavVersvg_Internalname = sPrefix+"vVERSVG" ;
      Gridpaginationbar_Internalname = sPrefix+"GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = sPrefix+"GRIDTABLEWITHPAGINATIONBAR" ;
      Innewwindow1_Internalname = sPrefix+"INNEWWINDOW1" ;
      divTablegridheader_Internalname = sPrefix+"TABLEGRIDHEADER" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
      Dvelop_confirmpanel_eliminarlegajo_Internalname = sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARLEGAJO" ;
      tblTabledvelop_confirmpanel_eliminarlegajo_Internalname = sPrefix+"TABLEDVELOP_CONFIRMPANEL_ELIMINARLEGAJO" ;
      Grid_empowerer_Internalname = sPrefix+"GRID_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = sPrefix+"HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
      subGrid_Internalname = sPrefix+"GRID" ;
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
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      subGrid_Header = "" ;
      edtavVersvg_Jsonclick = "" ;
      edtavVersvg_Columnclass = "WWColumn" ;
      edtavVersvg_Link = "" ;
      edtavVersvg_Enabled = 1 ;
      edtavVersvg_Format = (short)(0) ;
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Enabled = 1 ;
      edtavAjustes_Jsonclick = "" ;
      edtavAjustes_Link = "" ;
      edtavAjustes_Enabled = 1 ;
      cmbLiqLegPDFEstado.setJsonclick( "" );
      cmbLiqLegAuxEstado.setJsonclick( "" );
      edtLiqLegSegundos_Jsonclick = "" ;
      edtLIqLegIteraciones_Jsonclick = "" ;
      edtLiqLegImpCosto_Jsonclick = "" ;
      edtLiqLegImpContr_Jsonclick = "" ;
      edtLiqRutaPDFVertical_Jsonclick = "" ;
      edtLiqRutaPDF_Jsonclick = "" ;
      edtLegCUIL_Jsonclick = "" ;
      edtLiqLegErrorAux_Jsonclick = "" ;
      edtLiqLegError_Jsonclick = "" ;
      edtavLiqlegimptotdescu_Jsonclick = "" ;
      edtavLiqlegimptotdescu_Enabled = 1 ;
      edtavLiqlegimpotrdescu_Jsonclick = "" ;
      edtavLiqlegimpotrdescu_Enabled = 1 ;
      edtLiqLegImpTotRetGan_Jsonclick = "" ;
      edtLiqLegImpTotDescu_Jsonclick = "" ;
      edtLiqLegImpTotBruSinSAC_Jsonclick = "" ;
      edtLiqLegImpTotal_Jsonclick = "" ;
      edtLiqLegImpTotBruto_Jsonclick = "" ;
      edtLiqLegImpTotBruProm_Jsonclick = "" ;
      edtLiqLegImpBasico_Jsonclick = "" ;
      edtLegIdNomApe_Jsonclick = "" ;
      cmbavGridactiongroup1.setJsonclick( "" );
      cmbavGridactiongroup1.setVisible( -1 );
      cmbavGridactiongroup1.setEnabled( 1 );
      edtavLeghtml_Jsonclick = "" ;
      edtavLeghtml_Link = "" ;
      edtavLeghtml_Enabled = 1 ;
      edtLegNumero_Jsonclick = "" ;
      edtavEliminarlegajo_Jsonclick = "" ;
      edtavEliminarlegajo_Class = "Attribute" ;
      edtavEliminarlegajo_Visible = -1 ;
      edtavEliminarlegajo_Enabled = 1 ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      lblCouttext_Visible = 1 ;
      edtavDisplay_Visible = -1 ;
      edtavAjustes_Visible = -1 ;
      edtavDisplay_Link = "" ;
      lblCouttext_Caption = httpContext.getMessage( " 27 Novedades", "") ;
      tblButtonfilter1_tablebadge_Tooltiptext = "" ;
      lblButtonfilter1_textblockbadgecount_Caption = "2" ;
      tblButtonfilter1_tablebadge_Visible = 1 ;
      edtavVersvg_Visible = -1 ;
      cmbLiqLegAuxEstado.setVisible( -1 );
      edtLiqLegSegundos_Visible = -1 ;
      edtLIqLegIteraciones_Visible = -1 ;
      edtLiqLegImpContr_Visible = -1 ;
      edtLegCUIL_Visible = -1 ;
      edtLiqLegErrorAux_Visible = -1 ;
      edtLiqLegError_Visible = -1 ;
      edtavLiqlegimptotdescu_Visible = -1 ;
      edtavLiqlegimpotrdescu_Visible = -1 ;
      edtLiqLegImpTotRetGan_Visible = -1 ;
      edtLiqLegImpTotBruSinSAC_Visible = -1 ;
      edtLiqLegImpTotal_Visible = -1 ;
      edtLiqLegImpTotBruto_Visible = -1 ;
      edtLiqLegImpBasico_Visible = -1 ;
      edtavLeghtml_Visible = -1 ;
      subGrid_Sortable = (byte)(0) ;
      divButtonfilter1_tablecontent_Visible = 1 ;
      bttBtnexport_Visible = 1 ;
      lblTextblock1_Visible = 1 ;
      chkavErroresver.setEnabled( 1 );
      chkavErroresver.setVisible( 1 );
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Dvelop_confirmpanel_eliminarlegajo_Confirmtype = "1" ;
      Dvelop_confirmpanel_eliminarlegajo_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_eliminarlegajo_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_eliminarlegajo_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_eliminarlegajo_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_eliminarlegajo_Confirmationtext = "¿Está seguro de Eliminar el registro?" ;
      Dvelop_confirmpanel_eliminarlegajo_Title = "" ;
      Ddo_grid_Format = "|-14.2|-14.2||-14.2|-14.2|||||-14.2|4.0|10.6|" ;
      Ddo_grid_Datalistproc = "LiquidacionLegajoWCGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "|||||||||||||0:Pendiente,1:Procesando...,2:Error,3:Completo,4:Cerrada,5:No aplica" ;
      Ddo_grid_Allowmultipleselection = "||||||||T|T||||T" ;
      Ddo_grid_Datalisttype = "||||||||Dynamic|Dynamic||||FixedValues" ;
      Ddo_grid_Includedatalist = "||||||||T|T||||T" ;
      Ddo_grid_Filterisrange = "|T|T||T|T|||||T|T|T|" ;
      Ddo_grid_Filtertype = "|Numeric|Numeric||Numeric|Numeric|||Character|Character|Numeric|Numeric|Numeric|" ;
      Ddo_grid_Includefilter = "|T|T||T|T|||T|T|T|T|T|" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "|T|T|T|T|T|||T|T|T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "|2|3|4|5|6|||7|8|9|10|11|12" ;
      Ddo_grid_Columnids = "2:LegHtml|5:LiqLegImpBasico|7:LiqLegImpTotBruto|8:LiqLegImpTotal|9:LiqLegImpTotBruSinSAC|11:LiqLegImpTotRetGan|12:LiqLegImpOtrDescu|13:LiqLegImpTotDescu|14:LiqLegError|15:LiqLegErrorAux|19:LiqLegImpContr|21:LIqLegIteraciones|22:LiqLegSegundos|23:LiqLegAuxEstado" ;
      Ddo_grid_Gridinternalname = "" ;
      Innewwindow1_Target = "" ;
      Gridpaginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Gridpaginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Gridpaginationbar_Caption = httpContext.getMessage( "WWP_PagingCaption", "") ;
      Gridpaginationbar_Next = "WWP_PagingNextCaption" ;
      Gridpaginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Gridpaginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Gridpaginationbar_Rowsperpageselectedvalue = 10 ;
      Gridpaginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Gridpaginationbar_Pagingcaptionposition = "Left" ;
      Gridpaginationbar_Pagingbuttonsposition = "Right" ;
      Gridpaginationbar_Pagestoshow = 5 ;
      Gridpaginationbar_Showlast = GXutil.toBoolean( 0) ;
      Gridpaginationbar_Shownext = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Gridpaginationbar_Class = "PaginationBar" ;
      Buttonfilter1_a3lfilter_Filter_orig = "" ;
      Buttonfilter1_a3lfilter_A3l_filter_id = "" ;
      Buttonfilter1_a3lfilter_Observer = "" ;
      Ddo_managefilters_Cls = "ManageFilters" ;
      Ddo_managefilters_Tooltip = "WWP_ManageFiltersTooltip" ;
      Ddo_managefilters_Icon = "fas fa-filter" ;
      Ddo_managefilters_Icontype = "FontIcon" ;
      Ddo_gridcolumnsselector_Dropdownoptionstype = "GridColumnsSelector" ;
      Ddo_gridcolumnsselector_Cls = "ColumnsSelector" ;
      Ddo_gridcolumnsselector_Tooltip = "WWP_EditColumnsTooltip" ;
      Ddo_gridcolumnsselector_Caption = httpContext.getMessage( "WWP_EditColumnsCaption", "") ;
      Ddo_gridcolumnsselector_Icon = "fas fa-cog" ;
      Ddo_gridcolumnsselector_Icontype = "FontIcon" ;
      Buttonexport1_a3lexport_Boton_orig_id = "" ;
      Buttonexport1_a3lexport_Boton_clon_id = "" ;
      Buttonexport1_a3lexport_Observer = "" ;
      subGrid_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void init_web_controls( )
   {
      chkavErroresver.setName( "vERRORESVER" );
      chkavErroresver.setWebtags( "" );
      chkavErroresver.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavErroresver.getInternalname(), "TitleCaption", chkavErroresver.getCaption(), true);
      chkavErroresver.setCheckedValue( "false" );
      GXCCtl = "vGRIDACTIONGROUP1_" + sGXsfl_77_idx ;
      cmbavGridactiongroup1.setName( GXCCtl );
      cmbavGridactiongroup1.setWebtags( "" );
      if ( cmbavGridactiongroup1.getItemCount() > 0 )
      {
      }
      GXCCtl = "LIQLEGAUXESTADO_" + sGXsfl_77_idx ;
      cmbLiqLegAuxEstado.setName( GXCCtl );
      cmbLiqLegAuxEstado.setWebtags( "" );
      cmbLiqLegAuxEstado.addItem("0", httpContext.getMessage( "Pendiente", ""), (short)(0));
      cmbLiqLegAuxEstado.addItem("1", httpContext.getMessage( "Procesando...", ""), (short)(0));
      cmbLiqLegAuxEstado.addItem("2", httpContext.getMessage( "Error", ""), (short)(0));
      cmbLiqLegAuxEstado.addItem("3", httpContext.getMessage( "Completo", ""), (short)(0));
      cmbLiqLegAuxEstado.addItem("4", httpContext.getMessage( "Cerrada", ""), (short)(0));
      cmbLiqLegAuxEstado.addItem("5", httpContext.getMessage( "No aplica", ""), (short)(0));
      if ( cmbLiqLegAuxEstado.getItemCount() > 0 )
      {
      }
      GXCCtl = "LIQLEGPDFESTADO_" + sGXsfl_77_idx ;
      cmbLiqLegPDFEstado.setName( GXCCtl );
      cmbLiqLegPDFEstado.setWebtags( "" );
      cmbLiqLegPDFEstado.addItem("Completo", httpContext.getMessage( "Completo", ""), (short)(0));
      cmbLiqLegPDFEstado.addItem("Enviado", httpContext.getMessage( "Enviado", ""), (short)(0));
      cmbLiqLegPDFEstado.addItem("Pendiente", httpContext.getMessage( "Procesando...", ""), (short)(0));
      cmbLiqLegPDFEstado.addItem("Error", httpContext.getMessage( "Error", ""), (short)(0));
      cmbLiqLegPDFEstado.addItem("Manual", httpContext.getMessage( "Manual", ""), (short)(0));
      cmbLiqLegPDFEstado.addItem("EnEspera", httpContext.getMessage( "Pendiente", ""), (short)(0));
      if ( cmbLiqLegPDFEstado.getItemCount() > 0 )
      {
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'sPrefix'},{av:'AV88CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV153ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV85ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV7EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV17LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'AV163Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV92OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV19OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV110TFLiqLegImpBasico',fld:'vTFLIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV111TFLiqLegImpBasico_To',fld:'vTFLIQLEGIMPBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV93TFLiqLegImpTotBruto',fld:'vTFLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV94TFLiqLegImpTotBruto_To',fld:'vTFLIQLEGIMPTOTBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV108TFLiqLegImpTotBruSinSAC',fld:'vTFLIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV109TFLiqLegImpTotBruSinSAC_To',fld:'vTFLIQLEGIMPTOTBRUSINSAC_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV102TFLiqLegImpTotRetGan',fld:'vTFLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV103TFLiqLegImpTotRetGan_To',fld:'vTFLIQLEGIMPTOTRETGAN_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV132TFLiqLegError',fld:'vTFLIQLEGERROR',pic:''},{av:'AV133TFLiqLegError_Sels',fld:'vTFLIQLEGERROR_SELS',pic:''},{av:'AV140TFLiqLegErrorAux',fld:'vTFLIQLEGERRORAUX',pic:''},{av:'AV141TFLiqLegErrorAux_Sels',fld:'vTFLIQLEGERRORAUX_SELS',pic:''},{av:'AV121TFLiqLegImpContr',fld:'vTFLIQLEGIMPCONTR',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV122TFLiqLegImpContr_To',fld:'vTFLIQLEGIMPCONTR_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV125TFLIqLegIteraciones',fld:'vTFLIQLEGITERACIONES',pic:'ZZZ9'},{av:'AV126TFLIqLegIteraciones_To',fld:'vTFLIQLEGITERACIONES_TO',pic:'ZZZ9'},{av:'AV127TFLiqLegSegundos',fld:'vTFLIQLEGSEGUNDOS',pic:'ZZ9.999999'},{av:'AV128TFLiqLegSegundos_To',fld:'vTFLIQLEGSEGUNDOS_TO',pic:'ZZ9.999999'},{av:'AV143TFLiqLegAuxEstado_Sels',fld:'vTFLIQLEGAUXESTADO_SELS',pic:''},{av:'AV134MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV130IsAuthorized_Ajustes',fld:'vISAUTHORIZED_AJUSTES',pic:'',hsh:true},{av:'AV138LiquidacionAjustesPalabra',fld:'vLIQUIDACIONAJUSTESPALABRA',pic:'',hsh:true},{av:'AV137IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV160IsAuthorized_LegHtml',fld:'vISAUTHORIZED_LEGHTML',pic:'',hsh:true},{av:'AV148ErroresVer',fld:'vERRORESVER',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV153ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV85ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtavLeghtml_Visible',ctrl:'vLEGHTML',prop:'Visible'},{av:'edtLiqLegImpBasico_Visible',ctrl:'LIQLEGIMPBASICO',prop:'Visible'},{av:'edtLiqLegImpTotBruto_Visible',ctrl:'LIQLEGIMPTOTBRUTO',prop:'Visible'},{av:'edtLiqLegImpTotal_Visible',ctrl:'LIQLEGIMPTOTAL',prop:'Visible'},{av:'edtLiqLegImpTotBruSinSAC_Visible',ctrl:'LIQLEGIMPTOTBRUSINSAC',prop:'Visible'},{av:'edtLiqLegImpTotRetGan_Visible',ctrl:'LIQLEGIMPTOTRETGAN',prop:'Visible'},{av:'edtavLiqlegimpotrdescu_Visible',ctrl:'vLIQLEGIMPOTRDESCU',prop:'Visible'},{av:'edtavLiqlegimptotdescu_Visible',ctrl:'vLIQLEGIMPTOTDESCU',prop:'Visible'},{av:'edtLiqLegError_Visible',ctrl:'LIQLEGERROR',prop:'Visible'},{av:'edtLiqLegErrorAux_Visible',ctrl:'LIQLEGERRORAUX',prop:'Visible'},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtLiqLegImpContr_Visible',ctrl:'LIQLEGIMPCONTR',prop:'Visible'},{av:'edtLIqLegIteraciones_Visible',ctrl:'LIQLEGITERACIONES',prop:'Visible'},{av:'edtLiqLegSegundos_Visible',ctrl:'LIQLEGSEGUNDOS',prop:'Visible'},{av:'cmbLiqLegAuxEstado'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'AV10GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV11GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV9GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'AV130IsAuthorized_Ajustes',fld:'vISAUTHORIZED_AJUSTES',pic:'',hsh:true},{av:'edtavAjustes_Visible',ctrl:'vAJUSTES',prop:'Visible'},{av:'AV137IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV151ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13512',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV88CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV7EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV17LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'AV163Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV153ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV85ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV92OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV19OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV110TFLiqLegImpBasico',fld:'vTFLIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV111TFLiqLegImpBasico_To',fld:'vTFLIQLEGIMPBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV93TFLiqLegImpTotBruto',fld:'vTFLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV94TFLiqLegImpTotBruto_To',fld:'vTFLIQLEGIMPTOTBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV108TFLiqLegImpTotBruSinSAC',fld:'vTFLIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV109TFLiqLegImpTotBruSinSAC_To',fld:'vTFLIQLEGIMPTOTBRUSINSAC_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV102TFLiqLegImpTotRetGan',fld:'vTFLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV103TFLiqLegImpTotRetGan_To',fld:'vTFLIQLEGIMPTOTRETGAN_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV132TFLiqLegError',fld:'vTFLIQLEGERROR',pic:''},{av:'AV133TFLiqLegError_Sels',fld:'vTFLIQLEGERROR_SELS',pic:''},{av:'AV140TFLiqLegErrorAux',fld:'vTFLIQLEGERRORAUX',pic:''},{av:'AV141TFLiqLegErrorAux_Sels',fld:'vTFLIQLEGERRORAUX_SELS',pic:''},{av:'AV121TFLiqLegImpContr',fld:'vTFLIQLEGIMPCONTR',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV122TFLiqLegImpContr_To',fld:'vTFLIQLEGIMPCONTR_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV125TFLIqLegIteraciones',fld:'vTFLIQLEGITERACIONES',pic:'ZZZ9'},{av:'AV126TFLIqLegIteraciones_To',fld:'vTFLIQLEGITERACIONES_TO',pic:'ZZZ9'},{av:'AV127TFLiqLegSegundos',fld:'vTFLIQLEGSEGUNDOS',pic:'ZZ9.999999'},{av:'AV128TFLiqLegSegundos_To',fld:'vTFLIQLEGSEGUNDOS_TO',pic:'ZZ9.999999'},{av:'AV143TFLiqLegAuxEstado_Sels',fld:'vTFLIQLEGAUXESTADO_SELS',pic:''},{av:'AV134MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV130IsAuthorized_Ajustes',fld:'vISAUTHORIZED_AJUSTES',pic:'',hsh:true},{av:'AV138LiquidacionAjustesPalabra',fld:'vLIQUIDACIONAJUSTESPALABRA',pic:'',hsh:true},{av:'AV137IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV160IsAuthorized_LegHtml',fld:'vISAUTHORIZED_LEGHTML',pic:'',hsh:true},{av:'AV148ErroresVer',fld:'vERRORESVER',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'sPrefix'},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14512',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV88CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV7EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV17LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'AV163Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV153ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV85ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV92OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV19OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV110TFLiqLegImpBasico',fld:'vTFLIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV111TFLiqLegImpBasico_To',fld:'vTFLIQLEGIMPBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV93TFLiqLegImpTotBruto',fld:'vTFLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV94TFLiqLegImpTotBruto_To',fld:'vTFLIQLEGIMPTOTBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV108TFLiqLegImpTotBruSinSAC',fld:'vTFLIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV109TFLiqLegImpTotBruSinSAC_To',fld:'vTFLIQLEGIMPTOTBRUSINSAC_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV102TFLiqLegImpTotRetGan',fld:'vTFLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV103TFLiqLegImpTotRetGan_To',fld:'vTFLIQLEGIMPTOTRETGAN_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV132TFLiqLegError',fld:'vTFLIQLEGERROR',pic:''},{av:'AV133TFLiqLegError_Sels',fld:'vTFLIQLEGERROR_SELS',pic:''},{av:'AV140TFLiqLegErrorAux',fld:'vTFLIQLEGERRORAUX',pic:''},{av:'AV141TFLiqLegErrorAux_Sels',fld:'vTFLIQLEGERRORAUX_SELS',pic:''},{av:'AV121TFLiqLegImpContr',fld:'vTFLIQLEGIMPCONTR',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV122TFLiqLegImpContr_To',fld:'vTFLIQLEGIMPCONTR_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV125TFLIqLegIteraciones',fld:'vTFLIQLEGITERACIONES',pic:'ZZZ9'},{av:'AV126TFLIqLegIteraciones_To',fld:'vTFLIQLEGITERACIONES_TO',pic:'ZZZ9'},{av:'AV127TFLiqLegSegundos',fld:'vTFLIQLEGSEGUNDOS',pic:'ZZ9.999999'},{av:'AV128TFLiqLegSegundos_To',fld:'vTFLIQLEGSEGUNDOS_TO',pic:'ZZ9.999999'},{av:'AV143TFLiqLegAuxEstado_Sels',fld:'vTFLIQLEGAUXESTADO_SELS',pic:''},{av:'AV134MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV130IsAuthorized_Ajustes',fld:'vISAUTHORIZED_AJUSTES',pic:'',hsh:true},{av:'AV138LiquidacionAjustesPalabra',fld:'vLIQUIDACIONAJUSTESPALABRA',pic:'',hsh:true},{av:'AV137IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV160IsAuthorized_LegHtml',fld:'vISAUTHORIZED_LEGHTML',pic:'',hsh:true},{av:'AV148ErroresVer',fld:'vERRORESVER',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'sPrefix'},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15512',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV88CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV7EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV17LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'AV163Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV153ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV85ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV92OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV19OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV110TFLiqLegImpBasico',fld:'vTFLIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV111TFLiqLegImpBasico_To',fld:'vTFLIQLEGIMPBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV93TFLiqLegImpTotBruto',fld:'vTFLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV94TFLiqLegImpTotBruto_To',fld:'vTFLIQLEGIMPTOTBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV108TFLiqLegImpTotBruSinSAC',fld:'vTFLIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV109TFLiqLegImpTotBruSinSAC_To',fld:'vTFLIQLEGIMPTOTBRUSINSAC_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV102TFLiqLegImpTotRetGan',fld:'vTFLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV103TFLiqLegImpTotRetGan_To',fld:'vTFLIQLEGIMPTOTRETGAN_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV132TFLiqLegError',fld:'vTFLIQLEGERROR',pic:''},{av:'AV133TFLiqLegError_Sels',fld:'vTFLIQLEGERROR_SELS',pic:''},{av:'AV140TFLiqLegErrorAux',fld:'vTFLIQLEGERRORAUX',pic:''},{av:'AV141TFLiqLegErrorAux_Sels',fld:'vTFLIQLEGERRORAUX_SELS',pic:''},{av:'AV121TFLiqLegImpContr',fld:'vTFLIQLEGIMPCONTR',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV122TFLiqLegImpContr_To',fld:'vTFLIQLEGIMPCONTR_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV125TFLIqLegIteraciones',fld:'vTFLIQLEGITERACIONES',pic:'ZZZ9'},{av:'AV126TFLIqLegIteraciones_To',fld:'vTFLIQLEGITERACIONES_TO',pic:'ZZZ9'},{av:'AV127TFLiqLegSegundos',fld:'vTFLIQLEGSEGUNDOS',pic:'ZZ9.999999'},{av:'AV128TFLiqLegSegundos_To',fld:'vTFLIQLEGSEGUNDOS_TO',pic:'ZZ9.999999'},{av:'AV143TFLiqLegAuxEstado_Sels',fld:'vTFLIQLEGAUXESTADO_SELS',pic:''},{av:'AV134MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV130IsAuthorized_Ajustes',fld:'vISAUTHORIZED_AJUSTES',pic:'',hsh:true},{av:'AV138LiquidacionAjustesPalabra',fld:'vLIQUIDACIONAJUSTESPALABRA',pic:'',hsh:true},{av:'AV137IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV160IsAuthorized_LegHtml',fld:'vISAUTHORIZED_LEGHTML',pic:'',hsh:true},{av:'AV148ErroresVer',fld:'vERRORESVER',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV92OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV19OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV142TFLiqLegAuxEstado_SelsJson',fld:'vTFLIQLEGAUXESTADO_SELSJSON',pic:''},{av:'AV143TFLiqLegAuxEstado_Sels',fld:'vTFLIQLEGAUXESTADO_SELS',pic:''},{av:'AV127TFLiqLegSegundos',fld:'vTFLIQLEGSEGUNDOS',pic:'ZZ9.999999'},{av:'AV128TFLiqLegSegundos_To',fld:'vTFLIQLEGSEGUNDOS_TO',pic:'ZZ9.999999'},{av:'AV125TFLIqLegIteraciones',fld:'vTFLIQLEGITERACIONES',pic:'ZZZ9'},{av:'AV126TFLIqLegIteraciones_To',fld:'vTFLIQLEGITERACIONES_TO',pic:'ZZZ9'},{av:'AV121TFLiqLegImpContr',fld:'vTFLIQLEGIMPCONTR',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV122TFLiqLegImpContr_To',fld:'vTFLIQLEGIMPCONTR_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV140TFLiqLegErrorAux',fld:'vTFLIQLEGERRORAUX',pic:''},{av:'AV139TFLiqLegErrorAux_SelsJson',fld:'vTFLIQLEGERRORAUX_SELSJSON',pic:''},{av:'AV141TFLiqLegErrorAux_Sels',fld:'vTFLIQLEGERRORAUX_SELS',pic:''},{av:'AV132TFLiqLegError',fld:'vTFLIQLEGERROR',pic:''},{av:'AV131TFLiqLegError_SelsJson',fld:'vTFLIQLEGERROR_SELSJSON',pic:''},{av:'AV133TFLiqLegError_Sels',fld:'vTFLIQLEGERROR_SELS',pic:''},{av:'AV102TFLiqLegImpTotRetGan',fld:'vTFLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV103TFLiqLegImpTotRetGan_To',fld:'vTFLIQLEGIMPTOTRETGAN_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV108TFLiqLegImpTotBruSinSAC',fld:'vTFLIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV109TFLiqLegImpTotBruSinSAC_To',fld:'vTFLIQLEGIMPTOTBRUSINSAC_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV93TFLiqLegImpTotBruto',fld:'vTFLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV94TFLiqLegImpTotBruto_To',fld:'vTFLIQLEGIMPTOTBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV110TFLiqLegImpBasico',fld:'vTFLIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV111TFLiqLegImpBasico_To',fld:'vTFLIQLEGIMPBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e21512',iparms:[{av:'A278LiqEstado',fld:'LIQESTADO',pic:'9'},{av:'AV130IsAuthorized_Ajustes',fld:'vISAUTHORIZED_AJUSTES',pic:'',hsh:true},{av:'AV138LiquidacionAjustesPalabra',fld:'vLIQUIDACIONAJUSTESPALABRA',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV137IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV134MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV160IsAuthorized_LegHtml',fld:'vISAUTHORIZED_LEGHTML',pic:'',hsh:true},{av:'A1131LiqLegImpOtrDescu',fld:'LIQLEGIMPOTRDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A579LiqLegImpTotDescu',fld:'LIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV6EliminarLegajo',fld:'vELIMINARLEGAJO',pic:''},{av:'edtavEliminarlegajo_Class',ctrl:'vELIMINARLEGAJO',prop:'Class'},{av:'cmbavGridactiongroup1'},{av:'AV87GridActionGroup1',fld:'vGRIDACTIONGROUP1',pic:'ZZZ9'},{av:'AV129Ajustes',fld:'vAJUSTES',pic:''},{av:'edtavAjustes_Link',ctrl:'vAJUSTES',prop:'Link'},{av:'AV136Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavLeghtml_Link',ctrl:'vLEGHTML',prop:'Link'},{av:'AV159LegHtml',fld:'vLEGHTML',pic:''},{av:'AV120LiqLegImpOtrDescu',fld:'vLIQLEGIMPOTRDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV106LiqLegImpTotDescu',fld:'vLIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV135VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11512',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV88CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV7EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV17LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'AV163Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV153ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV85ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV92OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV19OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV110TFLiqLegImpBasico',fld:'vTFLIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV111TFLiqLegImpBasico_To',fld:'vTFLIQLEGIMPBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV93TFLiqLegImpTotBruto',fld:'vTFLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV94TFLiqLegImpTotBruto_To',fld:'vTFLIQLEGIMPTOTBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV108TFLiqLegImpTotBruSinSAC',fld:'vTFLIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV109TFLiqLegImpTotBruSinSAC_To',fld:'vTFLIQLEGIMPTOTBRUSINSAC_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV102TFLiqLegImpTotRetGan',fld:'vTFLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV103TFLiqLegImpTotRetGan_To',fld:'vTFLIQLEGIMPTOTRETGAN_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV132TFLiqLegError',fld:'vTFLIQLEGERROR',pic:''},{av:'AV133TFLiqLegError_Sels',fld:'vTFLIQLEGERROR_SELS',pic:''},{av:'AV140TFLiqLegErrorAux',fld:'vTFLIQLEGERRORAUX',pic:''},{av:'AV141TFLiqLegErrorAux_Sels',fld:'vTFLIQLEGERRORAUX_SELS',pic:''},{av:'AV121TFLiqLegImpContr',fld:'vTFLIQLEGIMPCONTR',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV122TFLiqLegImpContr_To',fld:'vTFLIQLEGIMPCONTR_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV125TFLIqLegIteraciones',fld:'vTFLIQLEGITERACIONES',pic:'ZZZ9'},{av:'AV126TFLIqLegIteraciones_To',fld:'vTFLIQLEGITERACIONES_TO',pic:'ZZZ9'},{av:'AV127TFLiqLegSegundos',fld:'vTFLIQLEGSEGUNDOS',pic:'ZZ9.999999'},{av:'AV128TFLiqLegSegundos_To',fld:'vTFLIQLEGSEGUNDOS_TO',pic:'ZZ9.999999'},{av:'AV143TFLiqLegAuxEstado_Sels',fld:'vTFLIQLEGAUXESTADO_SELS',pic:''},{av:'AV134MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV130IsAuthorized_Ajustes',fld:'vISAUTHORIZED_AJUSTES',pic:'',hsh:true},{av:'AV138LiquidacionAjustesPalabra',fld:'vLIQUIDACIONAJUSTESPALABRA',pic:'',hsh:true},{av:'AV137IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV160IsAuthorized_LegHtml',fld:'vISAUTHORIZED_LEGHTML',pic:'',hsh:true},{av:'AV148ErroresVer',fld:'vERRORESVER',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'sPrefix'},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV85ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV153ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtavLeghtml_Visible',ctrl:'vLEGHTML',prop:'Visible'},{av:'edtLiqLegImpBasico_Visible',ctrl:'LIQLEGIMPBASICO',prop:'Visible'},{av:'edtLiqLegImpTotBruto_Visible',ctrl:'LIQLEGIMPTOTBRUTO',prop:'Visible'},{av:'edtLiqLegImpTotal_Visible',ctrl:'LIQLEGIMPTOTAL',prop:'Visible'},{av:'edtLiqLegImpTotBruSinSAC_Visible',ctrl:'LIQLEGIMPTOTBRUSINSAC',prop:'Visible'},{av:'edtLiqLegImpTotRetGan_Visible',ctrl:'LIQLEGIMPTOTRETGAN',prop:'Visible'},{av:'edtavLiqlegimpotrdescu_Visible',ctrl:'vLIQLEGIMPOTRDESCU',prop:'Visible'},{av:'edtavLiqlegimptotdescu_Visible',ctrl:'vLIQLEGIMPTOTDESCU',prop:'Visible'},{av:'edtLiqLegError_Visible',ctrl:'LIQLEGERROR',prop:'Visible'},{av:'edtLiqLegErrorAux_Visible',ctrl:'LIQLEGERRORAUX',prop:'Visible'},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtLiqLegImpContr_Visible',ctrl:'LIQLEGIMPCONTR',prop:'Visible'},{av:'edtLIqLegIteraciones_Visible',ctrl:'LIQLEGITERACIONES',prop:'Visible'},{av:'edtLiqLegSegundos_Visible',ctrl:'LIQLEGSEGUNDOS',prop:'Visible'},{av:'cmbLiqLegAuxEstado'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'AV10GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV11GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV9GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'AV130IsAuthorized_Ajustes',fld:'vISAUTHORIZED_AJUSTES',pic:'',hsh:true},{av:'edtavAjustes_Visible',ctrl:'vAJUSTES',prop:'Visible'},{av:'AV137IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV151ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e12512',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV88CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV7EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV17LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'AV163Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV153ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV85ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV92OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV19OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV110TFLiqLegImpBasico',fld:'vTFLIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV111TFLiqLegImpBasico_To',fld:'vTFLIQLEGIMPBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV93TFLiqLegImpTotBruto',fld:'vTFLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV94TFLiqLegImpTotBruto_To',fld:'vTFLIQLEGIMPTOTBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV108TFLiqLegImpTotBruSinSAC',fld:'vTFLIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV109TFLiqLegImpTotBruSinSAC_To',fld:'vTFLIQLEGIMPTOTBRUSINSAC_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV102TFLiqLegImpTotRetGan',fld:'vTFLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV103TFLiqLegImpTotRetGan_To',fld:'vTFLIQLEGIMPTOTRETGAN_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV132TFLiqLegError',fld:'vTFLIQLEGERROR',pic:''},{av:'AV133TFLiqLegError_Sels',fld:'vTFLIQLEGERROR_SELS',pic:''},{av:'AV140TFLiqLegErrorAux',fld:'vTFLIQLEGERRORAUX',pic:''},{av:'AV141TFLiqLegErrorAux_Sels',fld:'vTFLIQLEGERRORAUX_SELS',pic:''},{av:'AV121TFLiqLegImpContr',fld:'vTFLIQLEGIMPCONTR',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV122TFLiqLegImpContr_To',fld:'vTFLIQLEGIMPCONTR_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV125TFLIqLegIteraciones',fld:'vTFLIQLEGITERACIONES',pic:'ZZZ9'},{av:'AV126TFLIqLegIteraciones_To',fld:'vTFLIQLEGITERACIONES_TO',pic:'ZZZ9'},{av:'AV127TFLiqLegSegundos',fld:'vTFLIQLEGSEGUNDOS',pic:'ZZ9.999999'},{av:'AV128TFLiqLegSegundos_To',fld:'vTFLIQLEGSEGUNDOS_TO',pic:'ZZ9.999999'},{av:'AV143TFLiqLegAuxEstado_Sels',fld:'vTFLIQLEGAUXESTADO_SELS',pic:''},{av:'AV134MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV130IsAuthorized_Ajustes',fld:'vISAUTHORIZED_AJUSTES',pic:'',hsh:true},{av:'AV138LiquidacionAjustesPalabra',fld:'vLIQUIDACIONAJUSTESPALABRA',pic:'',hsh:true},{av:'AV137IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV160IsAuthorized_LegHtml',fld:'vISAUTHORIZED_LEGHTML',pic:'',hsh:true},{av:'AV148ErroresVer',fld:'vERRORESVER',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'sPrefix'},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV131TFLiqLegError_SelsJson',fld:'vTFLIQLEGERROR_SELSJSON',pic:''},{av:'AV139TFLiqLegErrorAux_SelsJson',fld:'vTFLIQLEGERRORAUX_SELSJSON',pic:''},{av:'AV142TFLiqLegAuxEstado_SelsJson',fld:'vTFLIQLEGAUXESTADO_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV153ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV92OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV19OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV110TFLiqLegImpBasico',fld:'vTFLIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV111TFLiqLegImpBasico_To',fld:'vTFLIQLEGIMPBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV93TFLiqLegImpTotBruto',fld:'vTFLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV94TFLiqLegImpTotBruto_To',fld:'vTFLIQLEGIMPTOTBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV108TFLiqLegImpTotBruSinSAC',fld:'vTFLIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV109TFLiqLegImpTotBruSinSAC_To',fld:'vTFLIQLEGIMPTOTBRUSINSAC_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV102TFLiqLegImpTotRetGan',fld:'vTFLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV103TFLiqLegImpTotRetGan_To',fld:'vTFLIQLEGIMPTOTRETGAN_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV132TFLiqLegError',fld:'vTFLIQLEGERROR',pic:''},{av:'AV133TFLiqLegError_Sels',fld:'vTFLIQLEGERROR_SELS',pic:''},{av:'AV140TFLiqLegErrorAux',fld:'vTFLIQLEGERRORAUX',pic:''},{av:'AV141TFLiqLegErrorAux_Sels',fld:'vTFLIQLEGERRORAUX_SELS',pic:''},{av:'AV121TFLiqLegImpContr',fld:'vTFLIQLEGIMPCONTR',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV122TFLiqLegImpContr_To',fld:'vTFLIQLEGIMPCONTR_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV125TFLIqLegIteraciones',fld:'vTFLIQLEGITERACIONES',pic:'ZZZ9'},{av:'AV126TFLIqLegIteraciones_To',fld:'vTFLIQLEGITERACIONES_TO',pic:'ZZZ9'},{av:'AV127TFLiqLegSegundos',fld:'vTFLIQLEGSEGUNDOS',pic:'ZZ9.999999'},{av:'AV128TFLiqLegSegundos_To',fld:'vTFLIQLEGSEGUNDOS_TO',pic:'ZZ9.999999'},{av:'AV143TFLiqLegAuxEstado_Sels',fld:'vTFLIQLEGAUXESTADO_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV142TFLiqLegAuxEstado_SelsJson',fld:'vTFLIQLEGAUXESTADO_SELSJSON',pic:''},{av:'AV139TFLiqLegErrorAux_SelsJson',fld:'vTFLIQLEGERRORAUX_SELSJSON',pic:''},{av:'AV131TFLiqLegError_SelsJson',fld:'vTFLIQLEGERROR_SELSJSON',pic:''},{av:'AV85ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtavLeghtml_Visible',ctrl:'vLEGHTML',prop:'Visible'},{av:'edtLiqLegImpBasico_Visible',ctrl:'LIQLEGIMPBASICO',prop:'Visible'},{av:'edtLiqLegImpTotBruto_Visible',ctrl:'LIQLEGIMPTOTBRUTO',prop:'Visible'},{av:'edtLiqLegImpTotal_Visible',ctrl:'LIQLEGIMPTOTAL',prop:'Visible'},{av:'edtLiqLegImpTotBruSinSAC_Visible',ctrl:'LIQLEGIMPTOTBRUSINSAC',prop:'Visible'},{av:'edtLiqLegImpTotRetGan_Visible',ctrl:'LIQLEGIMPTOTRETGAN',prop:'Visible'},{av:'edtavLiqlegimpotrdescu_Visible',ctrl:'vLIQLEGIMPOTRDESCU',prop:'Visible'},{av:'edtavLiqlegimptotdescu_Visible',ctrl:'vLIQLEGIMPTOTDESCU',prop:'Visible'},{av:'edtLiqLegError_Visible',ctrl:'LIQLEGERROR',prop:'Visible'},{av:'edtLiqLegErrorAux_Visible',ctrl:'LIQLEGERRORAUX',prop:'Visible'},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtLiqLegImpContr_Visible',ctrl:'LIQLEGIMPCONTR',prop:'Visible'},{av:'edtLIqLegIteraciones_Visible',ctrl:'LIQLEGITERACIONES',prop:'Visible'},{av:'edtLiqLegSegundos_Visible',ctrl:'LIQLEGSEGUNDOS',prop:'Visible'},{av:'cmbLiqLegAuxEstado'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'AV10GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV11GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV9GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'AV130IsAuthorized_Ajustes',fld:'vISAUTHORIZED_AJUSTES',pic:'',hsh:true},{av:'edtavAjustes_Visible',ctrl:'vAJUSTES',prop:'Visible'},{av:'AV137IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV151ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("VELIMINARLEGAJO.CLICK","{handler:'e23512',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("VELIMINARLEGAJO.CLICK",",oparms:[{av:'AV113CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV8EmpCod_Selected',fld:'vEMPCOD_SELECTED',pic:'ZZZ9'},{av:'AV18LiqNro_Selected',fld:'vLIQNRO_SELECTED',pic:'ZZZZZZZ9'},{av:'AV16LegNumero_Selected',fld:'vLEGNUMERO_SELECTED',pic:'ZZZZZZZ9'}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_ELIMINARLEGAJO.CLOSE","{handler:'e16512',iparms:[{av:'Dvelop_confirmpanel_eliminarlegajo_Result',ctrl:'DVELOP_CONFIRMPANEL_ELIMINARLEGAJO',prop:'Result'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV88CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV7EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV17LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'AV163Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV153ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV85ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV92OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV19OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV110TFLiqLegImpBasico',fld:'vTFLIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV111TFLiqLegImpBasico_To',fld:'vTFLIQLEGIMPBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV93TFLiqLegImpTotBruto',fld:'vTFLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV94TFLiqLegImpTotBruto_To',fld:'vTFLIQLEGIMPTOTBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV108TFLiqLegImpTotBruSinSAC',fld:'vTFLIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV109TFLiqLegImpTotBruSinSAC_To',fld:'vTFLIQLEGIMPTOTBRUSINSAC_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV102TFLiqLegImpTotRetGan',fld:'vTFLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV103TFLiqLegImpTotRetGan_To',fld:'vTFLIQLEGIMPTOTRETGAN_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV132TFLiqLegError',fld:'vTFLIQLEGERROR',pic:''},{av:'AV133TFLiqLegError_Sels',fld:'vTFLIQLEGERROR_SELS',pic:''},{av:'AV140TFLiqLegErrorAux',fld:'vTFLIQLEGERRORAUX',pic:''},{av:'AV141TFLiqLegErrorAux_Sels',fld:'vTFLIQLEGERRORAUX_SELS',pic:''},{av:'AV121TFLiqLegImpContr',fld:'vTFLIQLEGIMPCONTR',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV122TFLiqLegImpContr_To',fld:'vTFLIQLEGIMPCONTR_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV125TFLIqLegIteraciones',fld:'vTFLIQLEGITERACIONES',pic:'ZZZ9'},{av:'AV126TFLIqLegIteraciones_To',fld:'vTFLIQLEGITERACIONES_TO',pic:'ZZZ9'},{av:'AV127TFLiqLegSegundos',fld:'vTFLIQLEGSEGUNDOS',pic:'ZZ9.999999'},{av:'AV128TFLiqLegSegundos_To',fld:'vTFLIQLEGSEGUNDOS_TO',pic:'ZZ9.999999'},{av:'AV143TFLiqLegAuxEstado_Sels',fld:'vTFLIQLEGAUXESTADO_SELS',pic:''},{av:'AV134MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV130IsAuthorized_Ajustes',fld:'vISAUTHORIZED_AJUSTES',pic:'',hsh:true},{av:'AV138LiquidacionAjustesPalabra',fld:'vLIQUIDACIONAJUSTESPALABRA',pic:'',hsh:true},{av:'AV137IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV160IsAuthorized_LegHtml',fld:'vISAUTHORIZED_LEGHTML',pic:'',hsh:true},{av:'AV148ErroresVer',fld:'vERRORESVER',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'sPrefix'},{av:'AV113CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV8EmpCod_Selected',fld:'vEMPCOD_SELECTED',pic:'ZZZ9'},{av:'AV18LiqNro_Selected',fld:'vLIQNRO_SELECTED',pic:'ZZZZZZZ9'},{av:'AV16LegNumero_Selected',fld:'vLEGNUMERO_SELECTED',pic:'ZZZZZZZ9'}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_ELIMINARLEGAJO.CLOSE",",oparms:[{av:'AV153ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV85ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtavLeghtml_Visible',ctrl:'vLEGHTML',prop:'Visible'},{av:'edtLiqLegImpBasico_Visible',ctrl:'LIQLEGIMPBASICO',prop:'Visible'},{av:'edtLiqLegImpTotBruto_Visible',ctrl:'LIQLEGIMPTOTBRUTO',prop:'Visible'},{av:'edtLiqLegImpTotal_Visible',ctrl:'LIQLEGIMPTOTAL',prop:'Visible'},{av:'edtLiqLegImpTotBruSinSAC_Visible',ctrl:'LIQLEGIMPTOTBRUSINSAC',prop:'Visible'},{av:'edtLiqLegImpTotRetGan_Visible',ctrl:'LIQLEGIMPTOTRETGAN',prop:'Visible'},{av:'edtavLiqlegimpotrdescu_Visible',ctrl:'vLIQLEGIMPOTRDESCU',prop:'Visible'},{av:'edtavLiqlegimptotdescu_Visible',ctrl:'vLIQLEGIMPTOTDESCU',prop:'Visible'},{av:'edtLiqLegError_Visible',ctrl:'LIQLEGERROR',prop:'Visible'},{av:'edtLiqLegErrorAux_Visible',ctrl:'LIQLEGERRORAUX',prop:'Visible'},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtLiqLegImpContr_Visible',ctrl:'LIQLEGIMPCONTR',prop:'Visible'},{av:'edtLIqLegIteraciones_Visible',ctrl:'LIQLEGITERACIONES',prop:'Visible'},{av:'edtLiqLegSegundos_Visible',ctrl:'LIQLEGSEGUNDOS',prop:'Visible'},{av:'cmbLiqLegAuxEstado'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'AV10GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV11GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV9GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'AV130IsAuthorized_Ajustes',fld:'vISAUTHORIZED_AJUSTES',pic:'',hsh:true},{av:'edtavAjustes_Visible',ctrl:'vAJUSTES',prop:'Visible'},{av:'AV137IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV151ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("VGRIDACTIONGROUP1.CLICK","{handler:'e22512',iparms:[{av:'cmbavGridactiongroup1'},{av:'AV87GridActionGroup1',fld:'vGRIDACTIONGROUP1',pic:'ZZZ9'},{av:'AV88CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV7EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV17LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("VGRIDACTIONGROUP1.CLICK",",oparms:[{av:'cmbavGridactiongroup1'},{av:'AV87GridActionGroup1',fld:'vGRIDACTIONGROUP1',pic:'ZZZ9'},{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'}]}");
      setEventMetadata("'DOEXPORT'","{handler:'e17512',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VERRORESVER.CONTROLVALUECHANGED","{handler:'e18512',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV88CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV7EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV17LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'AV163Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV153ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV85ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV92OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV19OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV110TFLiqLegImpBasico',fld:'vTFLIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV111TFLiqLegImpBasico_To',fld:'vTFLIQLEGIMPBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV93TFLiqLegImpTotBruto',fld:'vTFLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV94TFLiqLegImpTotBruto_To',fld:'vTFLIQLEGIMPTOTBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV108TFLiqLegImpTotBruSinSAC',fld:'vTFLIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV109TFLiqLegImpTotBruSinSAC_To',fld:'vTFLIQLEGIMPTOTBRUSINSAC_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV102TFLiqLegImpTotRetGan',fld:'vTFLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV103TFLiqLegImpTotRetGan_To',fld:'vTFLIQLEGIMPTOTRETGAN_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV132TFLiqLegError',fld:'vTFLIQLEGERROR',pic:''},{av:'AV133TFLiqLegError_Sels',fld:'vTFLIQLEGERROR_SELS',pic:''},{av:'AV140TFLiqLegErrorAux',fld:'vTFLIQLEGERRORAUX',pic:''},{av:'AV141TFLiqLegErrorAux_Sels',fld:'vTFLIQLEGERRORAUX_SELS',pic:''},{av:'AV121TFLiqLegImpContr',fld:'vTFLIQLEGIMPCONTR',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV122TFLiqLegImpContr_To',fld:'vTFLIQLEGIMPCONTR_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV125TFLIqLegIteraciones',fld:'vTFLIQLEGITERACIONES',pic:'ZZZ9'},{av:'AV126TFLIqLegIteraciones_To',fld:'vTFLIQLEGITERACIONES_TO',pic:'ZZZ9'},{av:'AV127TFLiqLegSegundos',fld:'vTFLIQLEGSEGUNDOS',pic:'ZZ9.999999'},{av:'AV128TFLiqLegSegundos_To',fld:'vTFLIQLEGSEGUNDOS_TO',pic:'ZZ9.999999'},{av:'AV143TFLiqLegAuxEstado_Sels',fld:'vTFLIQLEGAUXESTADO_SELS',pic:''},{av:'AV134MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV130IsAuthorized_Ajustes',fld:'vISAUTHORIZED_AJUSTES',pic:'',hsh:true},{av:'AV138LiquidacionAjustesPalabra',fld:'vLIQUIDACIONAJUSTESPALABRA',pic:'',hsh:true},{av:'AV137IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV160IsAuthorized_LegHtml',fld:'vISAUTHORIZED_LEGHTML',pic:'',hsh:true},{av:'AV148ErroresVer',fld:'vERRORESVER',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'sPrefix'},{av:'AV146LiqLegError',fld:'vLIQLEGERROR',pic:''}]");
      setEventMetadata("VERRORESVER.CONTROLVALUECHANGED",",oparms:[{av:'AV85ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV132TFLiqLegError',fld:'vTFLIQLEGERROR',pic:''},{av:'AV133TFLiqLegError_Sels',fld:'vTFLIQLEGERROR_SELS',pic:''},{av:'AV147errorHay',fld:'vERRORHAY',pic:''},{av:'AV146LiqLegError',fld:'vLIQLEGERROR',pic:''},{av:'AV153ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtavLeghtml_Visible',ctrl:'vLEGHTML',prop:'Visible'},{av:'edtLiqLegImpBasico_Visible',ctrl:'LIQLEGIMPBASICO',prop:'Visible'},{av:'edtLiqLegImpTotBruto_Visible',ctrl:'LIQLEGIMPTOTBRUTO',prop:'Visible'},{av:'edtLiqLegImpTotal_Visible',ctrl:'LIQLEGIMPTOTAL',prop:'Visible'},{av:'edtLiqLegImpTotBruSinSAC_Visible',ctrl:'LIQLEGIMPTOTBRUSINSAC',prop:'Visible'},{av:'edtLiqLegImpTotRetGan_Visible',ctrl:'LIQLEGIMPTOTRETGAN',prop:'Visible'},{av:'edtavLiqlegimpotrdescu_Visible',ctrl:'vLIQLEGIMPOTRDESCU',prop:'Visible'},{av:'edtavLiqlegimptotdescu_Visible',ctrl:'vLIQLEGIMPTOTDESCU',prop:'Visible'},{av:'edtLiqLegError_Visible',ctrl:'LIQLEGERROR',prop:'Visible'},{av:'edtLiqLegErrorAux_Visible',ctrl:'LIQLEGERRORAUX',prop:'Visible'},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtLiqLegImpContr_Visible',ctrl:'LIQLEGIMPCONTR',prop:'Visible'},{av:'edtLIqLegIteraciones_Visible',ctrl:'LIQLEGITERACIONES',prop:'Visible'},{av:'edtLiqLegSegundos_Visible',ctrl:'LIQLEGSEGUNDOS',prop:'Visible'},{av:'cmbLiqLegAuxEstado'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'AV10GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV11GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV9GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'AV130IsAuthorized_Ajustes',fld:'vISAUTHORIZED_AJUSTES',pic:'',hsh:true},{av:'edtavAjustes_Visible',ctrl:'vAJUSTES',prop:'Visible'},{av:'AV137IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV151ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Versvg',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
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
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      wcpOAV134MenuOpcCod = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      Dvelop_confirmpanel_eliminarlegajo_Result = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV134MenuOpcCod = "" ;
      AV163Pgmname = "" ;
      AV85ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV110TFLiqLegImpBasico = DecimalUtil.ZERO ;
      AV111TFLiqLegImpBasico_To = DecimalUtil.ZERO ;
      AV93TFLiqLegImpTotBruto = DecimalUtil.ZERO ;
      AV94TFLiqLegImpTotBruto_To = DecimalUtil.ZERO ;
      AV108TFLiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      AV109TFLiqLegImpTotBruSinSAC_To = DecimalUtil.ZERO ;
      AV102TFLiqLegImpTotRetGan = DecimalUtil.ZERO ;
      AV103TFLiqLegImpTotRetGan_To = DecimalUtil.ZERO ;
      AV132TFLiqLegError = "" ;
      AV133TFLiqLegError_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV140TFLiqLegErrorAux = "" ;
      AV141TFLiqLegErrorAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV121TFLiqLegImpContr = DecimalUtil.ZERO ;
      AV122TFLiqLegImpContr_To = DecimalUtil.ZERO ;
      AV127TFLiqLegSegundos = DecimalUtil.ZERO ;
      AV128TFLiqLegSegundos_To = DecimalUtil.ZERO ;
      AV143TFLiqLegAuxEstado_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV138LiquidacionAjustesPalabra = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV5DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV151ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV9GridAppliedFilters = "" ;
      A1131LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      AV131TFLiqLegError_SelsJson = "" ;
      AV139TFLiqLegErrorAux_SelsJson = "" ;
      AV142TFLiqLegAuxEstado_SelsJson = "" ;
      AV146LiqLegError = new GXSimpleCollection<String>(String.class, "internal", "");
      Ddo_gridcolumnsselector_Gridinternalname = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      lblTextblock1_Jsonclick = "" ;
      lblButtonexport1_textblock_svg_Jsonclick = "" ;
      lblButtonexport1_textblock_texto_Jsonclick = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      bttBtnexport_Jsonclick = "" ;
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      lblButtonfilters1_textblock_svg_Jsonclick = "" ;
      lblButtonfilters1_textblock_texto_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV6EliminarLegajo = "" ;
      AV159LegHtml = "" ;
      A250LegIdNomApe = "" ;
      A760LiqLegImpBasico = DecimalUtil.ZERO ;
      A758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      A498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      A579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      AV120LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      AV106LiqLegImpTotDescu = DecimalUtil.ZERO ;
      A891LiqLegError = "" ;
      A1781LiqLegErrorAux = "" ;
      A590LiqRutaPDF = "" ;
      A774LiqRutaPDFVertical = "" ;
      A1157LiqLegImpContr = DecimalUtil.ZERO ;
      A1158LiqLegImpCosto = DecimalUtil.ZERO ;
      A884LiqLegSegundos = DecimalUtil.ZERO ;
      A2179LiqLegPDFEstado = "" ;
      AV129Ajustes = "" ;
      AV136Display = "" ;
      AV135VerSVG = "" ;
      scmdbuf = "" ;
      lV132TFLiqLegError = "" ;
      lV140TFLiqLegErrorAux = "" ;
      H00512_A278LiqEstado = new byte[1] ;
      H00512_A31LiqNro = new int[1] ;
      H00512_A1EmpCod = new short[1] ;
      H00512_A3CliCod = new int[1] ;
      H00512_A1131LiqLegImpOtrDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00512_A2179LiqLegPDFEstado = new String[] {""} ;
      H00512_n2179LiqLegPDFEstado = new boolean[] {false} ;
      H00512_A1780LiqLegAuxEstado = new byte[1] ;
      H00512_A884LiqLegSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00512_A883LIqLegIteraciones = new short[1] ;
      H00512_A1158LiqLegImpCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00512_A1157LiqLegImpContr = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00512_A774LiqRutaPDFVertical = new String[] {""} ;
      H00512_A590LiqRutaPDF = new String[] {""} ;
      H00512_A239LegCUIL = new long[1] ;
      H00512_A1781LiqLegErrorAux = new String[] {""} ;
      H00512_A891LiqLegError = new String[] {""} ;
      H00512_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00512_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00512_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00512_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00512_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00512_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00512_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00512_A250LegIdNomApe = new String[] {""} ;
      H00512_A6LegNumero = new int[1] ;
      H00513_AGRID_nRecordCount = new long[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV157observerPalabra = "" ;
      AV91websession = httpContext.getWebSession();
      AV23Session = httpContext.getWebSession();
      AV29WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV83ColumnsSelectorXML = "" ;
      GXv_int8 = new short[1] ;
      AV156filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV152ManageFiltersXml = "" ;
      AV31ExcelFilename = "" ;
      AV32ErrorMessage = "" ;
      AV84UserCustomValue = "" ;
      AV86ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item12 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item13 = new GXBaseCollection[1] ;
      AV99linkPDF = "" ;
      AV98errorPDF = "" ;
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char14 = "" ;
      GXt_char6 = "" ;
      GXv_SdtWWPGridState15 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV27TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14HTTPRequest = httpContext.getHttpRequest();
      GXv_char9 = new String[1] ;
      GXv_char7 = new String[1] ;
      GXv_objcol_svchar16 = new GXSimpleCollection[1] ;
      GXv_boolean2 = new boolean[1] ;
      ucDvelop_confirmpanel_eliminarlegajo = new com.genexus.webpanels.GXUserControl();
      lblButtonfilter1_textblockbadgecount_Jsonclick = "" ;
      lblTotaltext_Jsonclick = "" ;
      lblCouttext_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV134MenuOpcCod = "" ;
      sCtrlAV88CliCod = "" ;
      sCtrlAV7EmpCod = "" ;
      sCtrlAV17LiqNro = "" ;
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionlegajowc__default(),
         new Object[] {
             new Object[] {
            H00512_A278LiqEstado, H00512_A31LiqNro, H00512_A1EmpCod, H00512_A3CliCod, H00512_A1131LiqLegImpOtrDescu, H00512_A2179LiqLegPDFEstado, H00512_n2179LiqLegPDFEstado, H00512_A1780LiqLegAuxEstado, H00512_A884LiqLegSegundos, H00512_A883LIqLegIteraciones,
            H00512_A1158LiqLegImpCosto, H00512_A1157LiqLegImpContr, H00512_A774LiqRutaPDFVertical, H00512_A590LiqRutaPDF, H00512_A239LegCUIL, H00512_A1781LiqLegErrorAux, H00512_A891LiqLegError, H00512_A757LiqLegImpTotRetGan, H00512_A579LiqLegImpTotDescu, H00512_A759LiqLegImpTotBruSinSAC,
            H00512_A281LiqLegImpTotal, H00512_A498LiqLegImpTotBruto, H00512_A758LiqLegImpTotBruProm, H00512_A760LiqLegImpBasico, H00512_A250LegIdNomApe, H00512_A6LegNumero
            }
            , new Object[] {
            H00513_AGRID_nRecordCount
            }
         }
      );
      AV163Pgmname = "LiquidacionLegajoWC" ;
      /* GeneXus formulas. */
      AV163Pgmname = "LiquidacionLegajoWC" ;
      Gx_err = (short)(0) ;
      edtavEliminarlegajo_Enabled = 0 ;
      edtavLeghtml_Enabled = 0 ;
      edtavLiqlegimpotrdescu_Enabled = 0 ;
      edtavLiqlegimptotdescu_Enabled = 0 ;
      edtavAjustes_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte AV153ManageFiltersExecutionStep ;
   private byte A278LiqEstado ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte A1780LiqLegAuxEstado ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short wcpOAV7EmpCod ;
   private short AV7EmpCod ;
   private short AV92OrderedBy ;
   private short AV125TFLIqLegIteraciones ;
   private short AV126TFLIqLegIteraciones_To ;
   private short A1EmpCod ;
   private short AV8EmpCod_Selected ;
   private short wbEnd ;
   private short wbStart ;
   private short AV87GridActionGroup1 ;
   private short A883LIqLegIteraciones ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXv_int8[] ;
   private short edtavVersvg_Format ;
   private short AV150i ;
   private int wcpOAV88CliCod ;
   private int wcpOAV17LiqNro ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_77 ;
   private int AV88CliCod ;
   private int AV17LiqNro ;
   private int nGXsfl_77_idx=1 ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int AV113CliCod_Selected ;
   private int AV18LiqNro_Selected ;
   private int AV16LegNumero_Selected ;
   private int Gridpaginationbar_Pagestoshow ;
   private int lblTextblock1_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int A6LegNumero ;
   private int subGrid_Islastpage ;
   private int edtavEliminarlegajo_Enabled ;
   private int edtavLeghtml_Enabled ;
   private int edtavLiqlegimpotrdescu_Enabled ;
   private int edtavLiqlegimptotdescu_Enabled ;
   private int edtavAjustes_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavVersvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV133TFLiqLegError_Sels_size ;
   private int AV141TFLiqLegErrorAux_Sels_size ;
   private int AV143TFLiqLegAuxEstado_Sels_size ;
   private int edtavLeghtml_Visible ;
   private int edtLiqLegImpBasico_Visible ;
   private int edtLiqLegImpTotBruto_Visible ;
   private int edtLiqLegImpTotal_Visible ;
   private int edtLiqLegImpTotBruSinSAC_Visible ;
   private int edtLiqLegImpTotRetGan_Visible ;
   private int edtavLiqlegimpotrdescu_Visible ;
   private int edtavLiqlegimptotdescu_Visible ;
   private int edtLiqLegError_Visible ;
   private int edtLiqLegErrorAux_Visible ;
   private int edtLegCUIL_Visible ;
   private int edtLiqLegImpContr_Visible ;
   private int edtLIqLegIteraciones_Visible ;
   private int edtLiqLegSegundos_Visible ;
   private int edtavVersvg_Visible ;
   private int AV155filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int lblCouttext_Visible ;
   private int AV21PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavAjustes_Visible ;
   private int AV164GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavEliminarlegajo_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV10GridCurrentPage ;
   private long AV11GridPageCount ;
   private long A239LegCUIL ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV110TFLiqLegImpBasico ;
   private java.math.BigDecimal AV111TFLiqLegImpBasico_To ;
   private java.math.BigDecimal AV93TFLiqLegImpTotBruto ;
   private java.math.BigDecimal AV94TFLiqLegImpTotBruto_To ;
   private java.math.BigDecimal AV108TFLiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal AV109TFLiqLegImpTotBruSinSAC_To ;
   private java.math.BigDecimal AV102TFLiqLegImpTotRetGan ;
   private java.math.BigDecimal AV103TFLiqLegImpTotRetGan_To ;
   private java.math.BigDecimal AV121TFLiqLegImpContr ;
   private java.math.BigDecimal AV122TFLiqLegImpContr_To ;
   private java.math.BigDecimal AV127TFLiqLegSegundos ;
   private java.math.BigDecimal AV128TFLiqLegSegundos_To ;
   private java.math.BigDecimal A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal A760LiqLegImpBasico ;
   private java.math.BigDecimal A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal A498LiqLegImpTotBruto ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private java.math.BigDecimal A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal A579LiqLegImpTotDescu ;
   private java.math.BigDecimal A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal AV120LiqLegImpOtrDescu ;
   private java.math.BigDecimal AV106LiqLegImpTotDescu ;
   private java.math.BigDecimal A1157LiqLegImpContr ;
   private java.math.BigDecimal A1158LiqLegImpCosto ;
   private java.math.BigDecimal A884LiqLegSegundos ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Filteredtextto_get ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_gridcolumnsselector_Columnsselectorvalues ;
   private String Ddo_managefilters_Activeeventkey ;
   private String Dvelop_confirmpanel_eliminarlegajo_Result ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_77_idx="0001" ;
   private String AV163Pgmname ;
   private String AV138LiquidacionAjustesPalabra ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Buttonexport1_a3lexport_Observer ;
   private String Buttonexport1_a3lexport_Boton_clon_id ;
   private String Buttonexport1_a3lexport_Boton_orig_id ;
   private String Ddo_gridcolumnsselector_Icontype ;
   private String Ddo_gridcolumnsselector_Icon ;
   private String Ddo_gridcolumnsselector_Caption ;
   private String Ddo_gridcolumnsselector_Tooltip ;
   private String Ddo_gridcolumnsselector_Cls ;
   private String Ddo_gridcolumnsselector_Dropdownoptionstype ;
   private String Ddo_gridcolumnsselector_Gridinternalname ;
   private String Ddo_managefilters_Icontype ;
   private String Ddo_managefilters_Icon ;
   private String Ddo_managefilters_Tooltip ;
   private String Ddo_managefilters_Cls ;
   private String Buttonfilter1_a3lfilter_Observer ;
   private String Buttonfilter1_a3lfilter_A3l_filter_id ;
   private String Buttonfilter1_a3lfilter_Filter_orig ;
   private String Gridpaginationbar_Class ;
   private String Gridpaginationbar_Pagingbuttonsposition ;
   private String Gridpaginationbar_Pagingcaptionposition ;
   private String Gridpaginationbar_Emptygridclass ;
   private String Gridpaginationbar_Rowsperpageoptions ;
   private String Gridpaginationbar_Previous ;
   private String Gridpaginationbar_Next ;
   private String Gridpaginationbar_Caption ;
   private String Gridpaginationbar_Emptygridcaption ;
   private String Gridpaginationbar_Rowsperpagecaption ;
   private String Innewwindow1_Target ;
   private String Ddo_grid_Caption ;
   private String Ddo_grid_Filteredtext_set ;
   private String Ddo_grid_Filteredtextto_set ;
   private String Ddo_grid_Selectedvalue_set ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Fixable ;
   private String Ddo_grid_Sortedstatus ;
   private String Ddo_grid_Includefilter ;
   private String Ddo_grid_Filtertype ;
   private String Ddo_grid_Filterisrange ;
   private String Ddo_grid_Includedatalist ;
   private String Ddo_grid_Datalisttype ;
   private String Ddo_grid_Allowmultipleselection ;
   private String Ddo_grid_Datalistfixedvalues ;
   private String Ddo_grid_Datalistproc ;
   private String Ddo_grid_Format ;
   private String Dvelop_confirmpanel_eliminarlegajo_Title ;
   private String Dvelop_confirmpanel_eliminarlegajo_Confirmationtext ;
   private String Dvelop_confirmpanel_eliminarlegajo_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_eliminarlegajo_Nobuttoncaption ;
   private String Dvelop_confirmpanel_eliminarlegajo_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_eliminarlegajo_Yesbuttonposition ;
   private String Dvelop_confirmpanel_eliminarlegajo_Confirmtype ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablegridheader_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTableheadercontent_Internalname ;
   private String divTableactions_Internalname ;
   private String divTableliqerror_Internalname ;
   private String divTablecheck_Internalname ;
   private String TempTags ;
   private String divTablelabel_Internalname ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String divButtonexport1_tablecontentbuttonimport_Internalname ;
   private String divButtonexport1_table_svg_Internalname ;
   private String lblButtonexport1_textblock_svg_Internalname ;
   private String lblButtonexport1_textblock_svg_Jsonclick ;
   private String divButtonexport1_table_texto_Internalname ;
   private String lblButtonexport1_textblock_texto_Internalname ;
   private String lblButtonexport1_textblock_texto_Jsonclick ;
   private String Buttonexport1_a3lexport_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String bttBtnexport_Internalname ;
   private String bttBtnexport_Jsonclick ;
   private String divButtonfilter1_tablecontent_Internalname ;
   private String Buttonfilter1_a3lfilter_Internalname ;
   private String divButtonfilters1_filtros_Internalname ;
   private String divButtonfilters1_table_svg_Internalname ;
   private String lblButtonfilters1_textblock_svg_Internalname ;
   private String lblButtonfilters1_textblock_svg_Jsonclick ;
   private String divButtonfilters1_table_texto_Internalname ;
   private String lblButtonfilters1_textblock_texto_Internalname ;
   private String lblButtonfilters1_textblock_texto_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String Innewwindow1_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavEliminarlegajo_Internalname ;
   private String AV6EliminarLegajo ;
   private String edtLegNumero_Internalname ;
   private String edtavLeghtml_Internalname ;
   private String edtLegIdNomApe_Internalname ;
   private String edtLiqLegImpBasico_Internalname ;
   private String edtLiqLegImpTotBruProm_Internalname ;
   private String edtLiqLegImpTotBruto_Internalname ;
   private String edtLiqLegImpTotal_Internalname ;
   private String edtLiqLegImpTotBruSinSAC_Internalname ;
   private String edtLiqLegImpTotDescu_Internalname ;
   private String edtLiqLegImpTotRetGan_Internalname ;
   private String edtavLiqlegimpotrdescu_Internalname ;
   private String edtavLiqlegimptotdescu_Internalname ;
   private String edtLiqLegError_Internalname ;
   private String edtLiqLegErrorAux_Internalname ;
   private String edtLegCUIL_Internalname ;
   private String edtLiqRutaPDF_Internalname ;
   private String edtLiqRutaPDFVertical_Internalname ;
   private String edtLiqLegImpContr_Internalname ;
   private String edtLiqLegImpCosto_Internalname ;
   private String edtLIqLegIteraciones_Internalname ;
   private String edtLiqLegSegundos_Internalname ;
   private String A2179LiqLegPDFEstado ;
   private String AV129Ajustes ;
   private String edtavAjustes_Internalname ;
   private String AV136Display ;
   private String edtavDisplay_Internalname ;
   private String AV135VerSVG ;
   private String edtavVersvg_Internalname ;
   private String scmdbuf ;
   private String AV157observerPalabra ;
   private String tblButtonfilter1_tablebadge_Internalname ;
   private String lblButtonfilter1_textblockbadgecount_Caption ;
   private String lblButtonfilter1_textblockbadgecount_Internalname ;
   private String tblButtonfilter1_tablebadge_Tooltiptext ;
   private String lblCouttext_Internalname ;
   private String lblCouttext_Caption ;
   private String edtavEliminarlegajo_Class ;
   private String edtavAjustes_Link ;
   private String edtavDisplay_Link ;
   private String edtavLeghtml_Link ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String GXt_char14 ;
   private String GXt_char6 ;
   private String GXv_char9[] ;
   private String GXv_char7[] ;
   private String tblTabledvelop_confirmpanel_eliminarlegajo_Internalname ;
   private String Dvelop_confirmpanel_eliminarlegajo_Internalname ;
   private String lblButtonfilter1_textblockbadgecount_Jsonclick ;
   private String tblTabletotalregistros_Internalname ;
   private String divTabletotal_Internalname ;
   private String lblTotaltext_Internalname ;
   private String lblTotaltext_Jsonclick ;
   private String lblCouttext_Jsonclick ;
   private String sCtrlAV134MenuOpcCod ;
   private String sCtrlAV88CliCod ;
   private String sCtrlAV7EmpCod ;
   private String sCtrlAV17LiqNro ;
   private String sGXsfl_77_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavEliminarlegajo_Jsonclick ;
   private String edtLegNumero_Jsonclick ;
   private String edtavLeghtml_Jsonclick ;
   private String GXCCtl ;
   private String edtLegIdNomApe_Jsonclick ;
   private String edtLiqLegImpBasico_Jsonclick ;
   private String edtLiqLegImpTotBruProm_Jsonclick ;
   private String edtLiqLegImpTotBruto_Jsonclick ;
   private String edtLiqLegImpTotal_Jsonclick ;
   private String edtLiqLegImpTotBruSinSAC_Jsonclick ;
   private String edtLiqLegImpTotDescu_Jsonclick ;
   private String edtLiqLegImpTotRetGan_Jsonclick ;
   private String edtavLiqlegimpotrdescu_Jsonclick ;
   private String edtavLiqlegimptotdescu_Jsonclick ;
   private String edtLiqLegError_Jsonclick ;
   private String edtLiqLegErrorAux_Jsonclick ;
   private String edtLegCUIL_Jsonclick ;
   private String edtLiqRutaPDF_Jsonclick ;
   private String edtLiqRutaPDFVertical_Jsonclick ;
   private String edtLiqLegImpContr_Jsonclick ;
   private String edtLiqLegImpCosto_Jsonclick ;
   private String edtLIqLegIteraciones_Jsonclick ;
   private String edtLiqLegSegundos_Jsonclick ;
   private String edtavAjustes_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV19OrderedDsc ;
   private boolean AV130IsAuthorized_Ajustes ;
   private boolean AV137IsAuthorized_Display ;
   private boolean AV160IsAuthorized_LegHtml ;
   private boolean AV148ErroresVer ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean Grid_empowerer_Hascolumnsselector ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n2179LiqLegPDFEstado ;
   private boolean bGXsfl_77_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV147errorHay ;
   private boolean gx_refresh_fired ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String AV131TFLiqLegError_SelsJson ;
   private String AV139TFLiqLegErrorAux_SelsJson ;
   private String AV142TFLiqLegAuxEstado_SelsJson ;
   private String AV83ColumnsSelectorXML ;
   private String AV152ManageFiltersXml ;
   private String AV84UserCustomValue ;
   private String wcpOAV134MenuOpcCod ;
   private String AV134MenuOpcCod ;
   private String AV132TFLiqLegError ;
   private String AV140TFLiqLegErrorAux ;
   private String AV9GridAppliedFilters ;
   private String AV159LegHtml ;
   private String A250LegIdNomApe ;
   private String A891LiqLegError ;
   private String A1781LiqLegErrorAux ;
   private String A590LiqRutaPDF ;
   private String A774LiqRutaPDFVertical ;
   private String lV132TFLiqLegError ;
   private String lV140TFLiqLegErrorAux ;
   private String AV156filtrosTexto ;
   private String AV31ExcelFilename ;
   private String AV32ErrorMessage ;
   private String AV99linkPDF ;
   private String AV98errorPDF ;
   private GXSimpleCollection<Byte> AV143TFLiqLegAuxEstado_Sels ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV14HTTPRequest ;
   private com.genexus.webpanels.WebSession AV91websession ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucInnewwindow1 ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_eliminarlegajo ;
   private ICheckbox chkavErroresver ;
   private HTMLChoice cmbavGridactiongroup1 ;
   private HTMLChoice cmbLiqLegAuxEstado ;
   private HTMLChoice cmbLiqLegPDFEstado ;
   private IDataStoreProvider pr_default ;
   private byte[] H00512_A278LiqEstado ;
   private int[] H00512_A31LiqNro ;
   private short[] H00512_A1EmpCod ;
   private int[] H00512_A3CliCod ;
   private java.math.BigDecimal[] H00512_A1131LiqLegImpOtrDescu ;
   private String[] H00512_A2179LiqLegPDFEstado ;
   private boolean[] H00512_n2179LiqLegPDFEstado ;
   private byte[] H00512_A1780LiqLegAuxEstado ;
   private java.math.BigDecimal[] H00512_A884LiqLegSegundos ;
   private short[] H00512_A883LIqLegIteraciones ;
   private java.math.BigDecimal[] H00512_A1158LiqLegImpCosto ;
   private java.math.BigDecimal[] H00512_A1157LiqLegImpContr ;
   private String[] H00512_A774LiqRutaPDFVertical ;
   private String[] H00512_A590LiqRutaPDF ;
   private long[] H00512_A239LegCUIL ;
   private String[] H00512_A1781LiqLegErrorAux ;
   private String[] H00512_A891LiqLegError ;
   private java.math.BigDecimal[] H00512_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] H00512_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] H00512_A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal[] H00512_A281LiqLegImpTotal ;
   private java.math.BigDecimal[] H00512_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] H00512_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] H00512_A760LiqLegImpBasico ;
   private String[] H00512_A250LegIdNomApe ;
   private int[] H00512_A6LegNumero ;
   private long[] H00513_AGRID_nRecordCount ;
   private GXSimpleCollection<String> AV133TFLiqLegError_Sels ;
   private GXSimpleCollection<String> AV141TFLiqLegErrorAux_Sels ;
   private GXSimpleCollection<String> AV146LiqLegError ;
   private GXSimpleCollection<String> GXv_objcol_svchar16[] ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV151ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item12 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item13[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV85ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV86ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector11[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV5DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState15[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV27TrnContext ;
   private web.wwpbaseobjects.SdtWWPContext AV29WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
}

final  class liquidacionlegajowc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00512( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A891LiqLegError ,
                                          GXSimpleCollection<String> AV133TFLiqLegError_Sels ,
                                          String A1781LiqLegErrorAux ,
                                          GXSimpleCollection<String> AV141TFLiqLegErrorAux_Sels ,
                                          byte A1780LiqLegAuxEstado ,
                                          GXSimpleCollection<Byte> AV143TFLiqLegAuxEstado_Sels ,
                                          java.math.BigDecimal AV110TFLiqLegImpBasico ,
                                          java.math.BigDecimal AV111TFLiqLegImpBasico_To ,
                                          java.math.BigDecimal AV93TFLiqLegImpTotBruto ,
                                          java.math.BigDecimal AV94TFLiqLegImpTotBruto_To ,
                                          java.math.BigDecimal AV108TFLiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal AV109TFLiqLegImpTotBruSinSAC_To ,
                                          java.math.BigDecimal AV102TFLiqLegImpTotRetGan ,
                                          java.math.BigDecimal AV103TFLiqLegImpTotRetGan_To ,
                                          int AV133TFLiqLegError_Sels_size ,
                                          String AV132TFLiqLegError ,
                                          int AV141TFLiqLegErrorAux_Sels_size ,
                                          String AV140TFLiqLegErrorAux ,
                                          java.math.BigDecimal AV121TFLiqLegImpContr ,
                                          java.math.BigDecimal AV122TFLiqLegImpContr_To ,
                                          short AV125TFLIqLegIteraciones ,
                                          short AV126TFLIqLegIteraciones_To ,
                                          java.math.BigDecimal AV127TFLiqLegSegundos ,
                                          java.math.BigDecimal AV128TFLiqLegSegundos_To ,
                                          int AV143TFLiqLegAuxEstado_Sels_size ,
                                          java.math.BigDecimal A760LiqLegImpBasico ,
                                          java.math.BigDecimal A498LiqLegImpTotBruto ,
                                          java.math.BigDecimal A759LiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal A757LiqLegImpTotRetGan ,
                                          java.math.BigDecimal A1157LiqLegImpContr ,
                                          short A883LIqLegIteraciones ,
                                          java.math.BigDecimal A884LiqLegSegundos ,
                                          short AV92OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV88CliCod ,
                                          short AV7EmpCod ,
                                          int AV17LiqNro ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[22];
      Object[] GXv_Object18 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T2.LiqEstado, T1.LiqNro, T1.EmpCod, T1.CliCod, T1.LiqLegImpOtrDescu, T1.LiqLegPDFEstado, T1.LiqLegAuxEstado, T1.LiqLegSegundos, T1.LIqLegIteraciones, T1.LiqLegImpCosto," ;
      sSelectString += " T1.LiqLegImpContr, T1.LiqRutaPDFVertical, T1.LiqRutaPDF, T3.LegCUIL, T1.LiqLegErrorAux, T1.LiqLegError, T1.LiqLegImpTotRetGan, T1.LiqLegImpTotDescu, T1.LiqLegImpTotBruSinSAC," ;
      sSelectString += " T1.LiqLegImpTotal, T1.LiqLegImpTotBruto, T1.LiqLegImpTotBruProm, T1.LiqLegImpBasico, T3.LegIdNomApe, T1.LegNumero" ;
      sFromString = " FROM ((LiquidacionLegajo T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) INNER JOIN Legajo T3 ON T3.CliCod" ;
      sFromString += " = T1.CliCod AND T3.EmpCod = T1.EmpCod AND T3.LegNumero = T1.LegNumero)" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LiqNro = ?)");
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV110TFLiqLegImpBasico)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico >= ?)");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV111TFLiqLegImpBasico_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico <= ?)");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV93TFLiqLegImpTotBruto)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto >= ?)");
      }
      else
      {
         GXv_int17[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV94TFLiqLegImpTotBruto_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto <= ?)");
      }
      else
      {
         GXv_int17[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV108TFLiqLegImpTotBruSinSAC)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC >= ?)");
      }
      else
      {
         GXv_int17[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV109TFLiqLegImpTotBruSinSAC_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC <= ?)");
      }
      else
      {
         GXv_int17[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV102TFLiqLegImpTotRetGan)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan >= ?)");
      }
      else
      {
         GXv_int17[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV103TFLiqLegImpTotRetGan_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan <= ?)");
      }
      else
      {
         GXv_int17[10] = (byte)(1) ;
      }
      if ( ( AV133TFLiqLegError_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV132TFLiqLegError)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqLegError) like LOWER(?))");
      }
      else
      {
         GXv_int17[11] = (byte)(1) ;
      }
      if ( AV133TFLiqLegError_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV133TFLiqLegError_Sels, "T1.LiqLegError IN (", ")")+")");
      }
      if ( ( AV141TFLiqLegErrorAux_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV140TFLiqLegErrorAux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqLegErrorAux) like LOWER(?))");
      }
      else
      {
         GXv_int17[12] = (byte)(1) ;
      }
      if ( AV141TFLiqLegErrorAux_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV141TFLiqLegErrorAux_Sels, "T1.LiqLegErrorAux IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV121TFLiqLegImpContr)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpContr >= ?)");
      }
      else
      {
         GXv_int17[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV122TFLiqLegImpContr_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpContr <= ?)");
      }
      else
      {
         GXv_int17[14] = (byte)(1) ;
      }
      if ( ! (0==AV125TFLIqLegIteraciones) )
      {
         addWhere(sWhereString, "(T1.LIqLegIteraciones >= ?)");
      }
      else
      {
         GXv_int17[15] = (byte)(1) ;
      }
      if ( ! (0==AV126TFLIqLegIteraciones_To) )
      {
         addWhere(sWhereString, "(T1.LIqLegIteraciones <= ?)");
      }
      else
      {
         GXv_int17[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV127TFLiqLegSegundos)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegSegundos >= ?)");
      }
      else
      {
         GXv_int17[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV128TFLiqLegSegundos_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegSegundos <= ?)");
      }
      else
      {
         GXv_int17[18] = (byte)(1) ;
      }
      if ( AV143TFLiqLegAuxEstado_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV143TFLiqLegAuxEstado_Sels, "T1.LiqLegAuxEstado IN (", ")")+")");
      }
      if ( AV92OrderedBy == 1 )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LiqLegImpBasico, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LiqLegImpBasico DESC, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LiqLegImpTotBruto, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LiqLegImpTotBruto DESC, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LiqLegImpTotal, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LiqLegImpTotal DESC, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LiqLegImpTotBruSinSAC, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LiqLegImpTotBruSinSAC DESC, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LiqLegImpTotRetGan, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LiqLegImpTotRetGan DESC, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LiqLegError, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LiqLegError DESC, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LiqLegErrorAux, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LiqLegErrorAux DESC, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 9 ) && ! AV19OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LiqLegImpContr, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 9 ) && ( AV19OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LiqLegImpContr DESC, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 10 ) && ! AV19OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LIqLegIteraciones, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 10 ) && ( AV19OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LIqLegIteraciones DESC, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 11 ) && ! AV19OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LiqLegSegundos, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 11 ) && ( AV19OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LiqLegSegundos DESC, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 12 ) && ! AV19OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LiqLegAuxEstado, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV92OrderedBy == 12 ) && ( AV19OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LiqLegAuxEstado DESC, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
   }

   protected Object[] conditional_H00513( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A891LiqLegError ,
                                          GXSimpleCollection<String> AV133TFLiqLegError_Sels ,
                                          String A1781LiqLegErrorAux ,
                                          GXSimpleCollection<String> AV141TFLiqLegErrorAux_Sels ,
                                          byte A1780LiqLegAuxEstado ,
                                          GXSimpleCollection<Byte> AV143TFLiqLegAuxEstado_Sels ,
                                          java.math.BigDecimal AV110TFLiqLegImpBasico ,
                                          java.math.BigDecimal AV111TFLiqLegImpBasico_To ,
                                          java.math.BigDecimal AV93TFLiqLegImpTotBruto ,
                                          java.math.BigDecimal AV94TFLiqLegImpTotBruto_To ,
                                          java.math.BigDecimal AV108TFLiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal AV109TFLiqLegImpTotBruSinSAC_To ,
                                          java.math.BigDecimal AV102TFLiqLegImpTotRetGan ,
                                          java.math.BigDecimal AV103TFLiqLegImpTotRetGan_To ,
                                          int AV133TFLiqLegError_Sels_size ,
                                          String AV132TFLiqLegError ,
                                          int AV141TFLiqLegErrorAux_Sels_size ,
                                          String AV140TFLiqLegErrorAux ,
                                          java.math.BigDecimal AV121TFLiqLegImpContr ,
                                          java.math.BigDecimal AV122TFLiqLegImpContr_To ,
                                          short AV125TFLIqLegIteraciones ,
                                          short AV126TFLIqLegIteraciones_To ,
                                          java.math.BigDecimal AV127TFLiqLegSegundos ,
                                          java.math.BigDecimal AV128TFLiqLegSegundos_To ,
                                          int AV143TFLiqLegAuxEstado_Sels_size ,
                                          java.math.BigDecimal A760LiqLegImpBasico ,
                                          java.math.BigDecimal A498LiqLegImpTotBruto ,
                                          java.math.BigDecimal A759LiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal A757LiqLegImpTotRetGan ,
                                          java.math.BigDecimal A1157LiqLegImpContr ,
                                          short A883LIqLegIteraciones ,
                                          java.math.BigDecimal A884LiqLegSegundos ,
                                          short AV92OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          int AV88CliCod ,
                                          short AV7EmpCod ,
                                          int AV17LiqNro ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int20 = new byte[19];
      Object[] GXv_Object21 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ((LiquidacionLegajo T1 INNER JOIN Liquidacion T3 ON T3.CliCod = T1.CliCod AND T3.EmpCod = T1.EmpCod AND T3.LiqNro = T1.LiqNro) INNER JOIN Legajo" ;
      scmdbuf += " T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LiqNro = ?)");
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV110TFLiqLegImpBasico)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico >= ?)");
      }
      else
      {
         GXv_int20[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV111TFLiqLegImpBasico_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico <= ?)");
      }
      else
      {
         GXv_int20[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV93TFLiqLegImpTotBruto)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto >= ?)");
      }
      else
      {
         GXv_int20[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV94TFLiqLegImpTotBruto_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto <= ?)");
      }
      else
      {
         GXv_int20[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV108TFLiqLegImpTotBruSinSAC)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC >= ?)");
      }
      else
      {
         GXv_int20[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV109TFLiqLegImpTotBruSinSAC_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC <= ?)");
      }
      else
      {
         GXv_int20[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV102TFLiqLegImpTotRetGan)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan >= ?)");
      }
      else
      {
         GXv_int20[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV103TFLiqLegImpTotRetGan_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan <= ?)");
      }
      else
      {
         GXv_int20[10] = (byte)(1) ;
      }
      if ( ( AV133TFLiqLegError_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV132TFLiqLegError)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqLegError) like LOWER(?))");
      }
      else
      {
         GXv_int20[11] = (byte)(1) ;
      }
      if ( AV133TFLiqLegError_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV133TFLiqLegError_Sels, "T1.LiqLegError IN (", ")")+")");
      }
      if ( ( AV141TFLiqLegErrorAux_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV140TFLiqLegErrorAux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqLegErrorAux) like LOWER(?))");
      }
      else
      {
         GXv_int20[12] = (byte)(1) ;
      }
      if ( AV141TFLiqLegErrorAux_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV141TFLiqLegErrorAux_Sels, "T1.LiqLegErrorAux IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV121TFLiqLegImpContr)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpContr >= ?)");
      }
      else
      {
         GXv_int20[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV122TFLiqLegImpContr_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpContr <= ?)");
      }
      else
      {
         GXv_int20[14] = (byte)(1) ;
      }
      if ( ! (0==AV125TFLIqLegIteraciones) )
      {
         addWhere(sWhereString, "(T1.LIqLegIteraciones >= ?)");
      }
      else
      {
         GXv_int20[15] = (byte)(1) ;
      }
      if ( ! (0==AV126TFLIqLegIteraciones_To) )
      {
         addWhere(sWhereString, "(T1.LIqLegIteraciones <= ?)");
      }
      else
      {
         GXv_int20[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV127TFLiqLegSegundos)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegSegundos >= ?)");
      }
      else
      {
         GXv_int20[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV128TFLiqLegSegundos_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegSegundos <= ?)");
      }
      else
      {
         GXv_int20[18] = (byte)(1) ;
      }
      if ( AV143TFLiqLegAuxEstado_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV143TFLiqLegAuxEstado_Sels, "T1.LiqLegAuxEstado IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( AV92OrderedBy == 1 )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 9 ) && ! AV19OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 9 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 10 ) && ! AV19OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 10 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 11 ) && ! AV19OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 11 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 12 ) && ! AV19OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV92OrderedBy == 12 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object21[0] = scmdbuf ;
      GXv_Object21[1] = GXv_int20 ;
      return GXv_Object21 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_H00512(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).shortValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).shortValue() , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).shortValue() , ((Number) dynConstraints[39]).intValue() );
            case 1 :
                  return conditional_H00513(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).shortValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).shortValue() , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).shortValue() , ((Number) dynConstraints[39]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00512", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00513", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((byte[]) buf[7])[0] = rslt.getByte(7);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,6);
               ((short[]) buf[9])[0] = rslt.getShort(9);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(11,2);
               ((String[]) buf[12])[0] = rslt.getVarchar(12);
               ((String[]) buf[13])[0] = rslt.getVarchar(13);
               ((long[]) buf[14])[0] = rslt.getLong(14);
               ((String[]) buf[15])[0] = rslt.getVarchar(15);
               ((String[]) buf[16])[0] = rslt.getVarchar(16);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(17,2);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(18,2);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(19,2);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(22,2);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(23,2);
               ((String[]) buf[24])[0] = rslt.getVarchar(24);
               ((int[]) buf[25])[0] = rslt.getInt(25);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[23]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[27], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[31], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[32], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 400);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 400);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[35], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[38]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[39], 6);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[40], 6);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[41]).intValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[42]).intValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[43]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[27], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 400);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 400);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[32], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[33], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[34]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[35]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 6);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 6);
               }
               return;
      }
   }

}

