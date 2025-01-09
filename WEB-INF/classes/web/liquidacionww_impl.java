package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class liquidacionww_impl extends GXWebComponent
{
   public liquidacionww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public liquidacionww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionww_impl.class ));
   }

   public liquidacionww_impl( int remoteHandle ,
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
      cmbavGridactions = new HTMLChoice();
      cmbLiqClase = new HTMLChoice();
      cmbLiqModTra = new HTMLChoice();
      cmbLiqFrecPag = new HTMLChoice();
      cmbLiqEstado = new HTMLChoice();
      cmbLiqLSDDepEst = new HTMLChoice();
      cmbLiqContrEst = new HTMLChoice();
      cmbLiqPDFEstado = new HTMLChoice();
      cmbLiqAuxEstado = new HTMLChoice();
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
               AV176MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV176MenuOpcCod", AV176MenuOpcCod);
               AV162PeriodoLiq = localUtil.parseDateParm( httpContext.GetPar( "PeriodoLiq")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV162PeriodoLiq", localUtil.format(AV162PeriodoLiq, "99/99/99"));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV176MenuOpcCod,AV162PeriodoLiq});
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
      nRC_GXsfl_70 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_70"))) ;
      nGXsfl_70_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_70_idx"))) ;
      sGXsfl_70_idx = httpContext.GetPar( "sGXsfl_70_idx") ;
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
      AV123ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV9ColumnsSelector);
      AV231Pgmname = httpContext.GetPar( "Pgmname") ;
      AV176MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV35GridState);
      AV162PeriodoLiq = localUtil.parseDateParm( httpContext.GetPar( "PeriodoLiq")) ;
      AV185LiqRelNro = (int)(GXutil.lval( httpContext.GetPar( "LiqRelNro"))) ;
      AV74TFLiqNro = (int)(GXutil.lval( httpContext.GetPar( "TFLiqNro"))) ;
      AV75TFLiqNro_To = (int)(GXutil.lval( httpContext.GetPar( "TFLiqNro_To"))) ;
      AV139TFLiqNombre = httpContext.GetPar( "TFLiqNombre") ;
      AV141TFLiqNombre_Sel = httpContext.GetPar( "TFLiqNombre_Sel") ;
      AV66TFLiqFecha = localUtil.parseDateParm( httpContext.GetPar( "TFLiqFecha")) ;
      AV67TFLiqFecha_To = localUtil.parseDateParm( httpContext.GetPar( "TFLiqFecha_To")) ;
      AV113TFLiqPerPalabra = httpContext.GetPar( "TFLiqPerPalabra") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV114TFLiqPerPalabra_Sels);
      AV68TFLiqFecPago = localUtil.parseDateParm( httpContext.GetPar( "TFLiqFecPago")) ;
      AV69TFLiqFecPago_To = localUtil.parseDateParm( httpContext.GetPar( "TFLiqFecPago_To")) ;
      AV216TFTLiqDescAux = httpContext.GetPar( "TFTLiqDescAux") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV217TFTLiqDescAux_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV226TFLiqModTra_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV228TFLiqFrecPag_Sels);
      AV56TFLiqCntLeg = (short)(GXutil.lval( httpContext.GetPar( "TFLiqCntLeg"))) ;
      AV57TFLiqCntLeg_To = (short)(GXutil.lval( httpContext.GetPar( "TFLiqCntLeg_To"))) ;
      AV119TFLiqError = httpContext.GetPar( "TFLiqError") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV120TFLiqError_Sels);
      AV58TFLiqDescrip = httpContext.GetPar( "TFLiqDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV60TFLiqDescrip_Sels);
      AV70TFLiqImpBruto = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqImpBruto"), ".") ;
      AV71TFLiqImpBruto_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqImpBruto_To"), ".") ;
      AV72TFLiqImpNeto = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqImpNeto"), ".") ;
      AV73TFLiqImpNeto_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqImpNeto_To"), ".") ;
      AV41OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV43OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV39IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV27EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV189collectionLegNumero);
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A283LiqPeriodo = localUtil.parseDateParm( httpContext.GetPar( "LiqPeriodo")) ;
      A719LiqFecImp = localUtil.parseDTimeParm( httpContext.GetPar( "LiqFecImp")) ;
      A361LiqGenInter = GXutil.strtobool( httpContext.GetPar( "LiqGenInter")) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV123ManageFiltersExecutionStep, AV9ColumnsSelector, AV231Pgmname, AV176MenuOpcCod, AV35GridState, AV162PeriodoLiq, AV185LiqRelNro, AV74TFLiqNro, AV75TFLiqNro_To, AV139TFLiqNombre, AV141TFLiqNombre_Sel, AV66TFLiqFecha, AV67TFLiqFecha_To, AV113TFLiqPerPalabra, AV114TFLiqPerPalabra_Sels, AV68TFLiqFecPago, AV69TFLiqFecPago_To, AV216TFTLiqDescAux, AV217TFTLiqDescAux_Sels, AV226TFLiqModTra_Sels, AV228TFLiqFrecPag_Sels, AV56TFLiqCntLeg, AV57TFLiqCntLeg_To, AV119TFLiqError, AV120TFLiqError_Sels, AV58TFLiqDescrip, AV60TFLiqDescrip_Sels, AV70TFLiqImpBruto, AV71TFLiqImpBruto_To, AV72TFLiqImpNeto, AV73TFLiqImpNeto_To, AV41OrderedBy, AV43OrderedDsc, AV7CliCod, AV39IsAuthorized_Update, AV27EmpCod, AV189collectionLegNumero, A3CliCod, A283LiqPeriodo, A719LiqFecImp, A361LiqGenInter, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa2M2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( " Liquidaciones", "")) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridTitlesCategories/GridTitlesCategoriesRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.liquidacionww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV176MenuOpcCod)),GXutil.URLEncode(GXutil.formatDateParm(AV162PeriodoLiq))}, new String[] {"MenuOpcCod","PeriodoLiq"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV231Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_CLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQPERIODO", getSecureSignedToken( sPrefix, A283LiqPeriodo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQFECIMP", getSecureSignedToken( sPrefix, localUtil.format( A719LiqFecImp, "99/99/99 99:99")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV39IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQGENINTER", getSecureSignedToken( sPrefix, A361LiqGenInter));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCOLLECTIONLEGNUMERO", getSecureSignedToken( sPrefix, AV189collectionLegNumero));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_70", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_70, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV25DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV25DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCOLUMNSSELECTOR", AV9ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCOLUMNSSELECTOR", AV9ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vMANAGEFILTERSDATA", AV121ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vMANAGEFILTERSDATA", AV121ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV33GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV34GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDAPPLIEDFILTERS", AV32GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDDO_LIQFECHAAUXDATE", localUtil.dtoc( AV16DDO_LiqFechaAuxDate, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDDO_LIQFECHAAUXDATETO", localUtil.dtoc( AV18DDO_LiqFechaAuxDateTo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDDO_LIQFECPAGOAUXDATE", localUtil.dtoc( AV19DDO_LiqFecPagoAuxDate, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDDO_LIQFECPAGOAUXDATETO", localUtil.dtoc( AV21DDO_LiqFecPagoAuxDateTo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV176MenuOpcCod", wcpOAV176MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV162PeriodoLiq", localUtil.dtoc( wcpOAV162PeriodoLiq, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV123ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV231Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV231Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMENUOPCCOD", AV176MenuOpcCod);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vGRIDSTATE", AV35GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vGRIDSTATE", AV35GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPERIODOLIQ", localUtil.dtoc( AV162PeriodoLiq, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQNRO", GXutil.ltrim( localUtil.ntoc( AV74TFLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQNRO_TO", GXutil.ltrim( localUtil.ntoc( AV75TFLiqNro_To, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQNOMBRE", AV139TFLiqNombre);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQNOMBRE_SEL", AV141TFLiqNombre_Sel);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQFECHA", localUtil.dtoc( AV66TFLiqFecha, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQFECHA_TO", localUtil.dtoc( AV67TFLiqFecha_To, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQPERPALABRA", GXutil.rtrim( AV113TFLiqPerPalabra));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLIQPERPALABRA_SELS", AV114TFLiqPerPalabra_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLIQPERPALABRA_SELS", AV114TFLiqPerPalabra_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQFECPAGO", localUtil.dtoc( AV68TFLiqFecPago, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQFECPAGO_TO", localUtil.dtoc( AV69TFLiqFecPago_To, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFTLIQDESCAUX", AV216TFTLiqDescAux);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFTLIQDESCAUX_SELS", AV217TFTLiqDescAux_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFTLIQDESCAUX_SELS", AV217TFTLiqDescAux_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLIQMODTRA_SELS", AV226TFLiqModTra_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLIQMODTRA_SELS", AV226TFLiqModTra_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLIQFRECPAG_SELS", AV228TFLiqFrecPag_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLIQFRECPAG_SELS", AV228TFLiqFrecPag_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQCNTLEG", GXutil.ltrim( localUtil.ntoc( AV56TFLiqCntLeg, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQCNTLEG_TO", GXutil.ltrim( localUtil.ntoc( AV57TFLiqCntLeg_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQERROR", AV119TFLiqError);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLIQERROR_SELS", AV120TFLiqError_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLIQERROR_SELS", AV120TFLiqError_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQDESCRIP", AV58TFLiqDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLIQDESCRIP_SELS", AV60TFLiqDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLIQDESCRIP_SELS", AV60TFLiqDescrip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQIMPBRUTO", GXutil.ltrim( localUtil.ntoc( AV70TFLiqImpBruto, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQIMPBRUTO_TO", GXutil.ltrim( localUtil.ntoc( AV71TFLiqImpBruto_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQIMPNETO", GXutil.ltrim( localUtil.ntoc( AV72TFLiqImpNeto, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQIMPNETO_TO", GXutil.ltrim( localUtil.ntoc( AV73TFLiqImpNeto_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV41OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV43OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_CLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LIQPERIODO", localUtil.dtoc( A283LiqPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQPERIODO", getSecureSignedToken( sPrefix, A283LiqPeriodo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LIQFECIMP", localUtil.ttoc( A719LiqFecImp, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQFECIMP", getSecureSignedToken( sPrefix, localUtil.format( A719LiqFecImp, "99/99/99 99:99")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV39IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV39IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"LIQGENINTER", A361LiqGenInter);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQGENINTER", getSecureSignedToken( sPrefix, A361LiqGenInter));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQPERPALABRA_SELSJSON", AV112TFLiqPerPalabra_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFTLIQDESCAUX_SELSJSON", AV215TFTLiqDescAux_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQMODTRA_SELSJSON", AV225TFLiqModTra_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQFRECPAG_SELSJSON", AV227TFLiqFrecPag_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQERROR_SELSJSON", AV118TFLiqError_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQDESCRIP_SELSJSON", AV61TFLiqDescrip_SelsJson);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCOLLECTIONLEGNUMERO", AV189collectionLegNumero);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCOLLECTIONLEGNUMERO", AV189collectionLegNumero);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCOLLECTIONLEGNUMERO", getSecureSignedToken( sPrefix, AV189collectionLegNumero));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD_SELECTED", GXutil.ltrim( localUtil.ntoc( AV8CliCod_Selected, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD_SELECTED", GXutil.ltrim( localUtil.ntoc( AV28EmpCod_Selected, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLIQNRO_SELECTED", GXutil.ltrim( localUtil.ntoc( AV40LiqNro_Selected, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV27EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMENSAJETEXTOJSON", AV222mensajeTextoJson);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSIGUIENTEESTADOPALABRA", GXutil.rtrim( AV224siguienteEstadoPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMSGNOTIESTADO", GXutil.rtrim( AV196msgNotiEstado));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION_Title", GXutil.rtrim( Dvelop_confirmpanel_proximaaccion_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_proximaaccion_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_proximaaccion_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_proximaaccion_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_proximaaccion_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_proximaaccion_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_proximaaccion_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Title", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR_Title", GXutil.rtrim( Dvelop_confirmpanel_reliquidar_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_reliquidar_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_reliquidar_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_reliquidar_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_reliquidar_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_reliquidar_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_reliquidar_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CERRAR_Title", GXutil.rtrim( Dvelop_confirmpanel_cerrar_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CERRAR_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_cerrar_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CERRAR_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_cerrar_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CERRAR_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_cerrar_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CERRAR_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_cerrar_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CERRAR_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_cerrar_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CERRAR_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_cerrar_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_REABRIR_Title", GXutil.rtrim( Dvelop_confirmpanel_reabrir_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_REABRIR_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_reabrir_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_REABRIR_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_reabrir_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_REABRIR_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_reabrir_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_REABRIR_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_reabrir_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_REABRIR_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_reabrir_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_REABRIR_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_reabrir_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR_Title", GXutil.rtrim( Dvelop_confirmpanel_cancelar_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_cancelar_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_cancelar_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_cancelar_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_cancelar_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_cancelar_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_cancelar_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_TITLESCATEGORIES_Gridinternalname", GXutil.rtrim( Grid_titlescategories_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_TITLESCATEGORIES_Gridtitlescategories", GXutil.rtrim( Grid_titlescategories_Gridtitlescategories));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Hascategories", GXutil.booltostr( Grid_empowerer_Hascategories));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION_Result", GXutil.rtrim( Dvelop_confirmpanel_proximaaccion_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Result", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR_Result", GXutil.rtrim( Dvelop_confirmpanel_reliquidar_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CERRAR_Result", GXutil.rtrim( Dvelop_confirmpanel_cerrar_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_REABRIR_Result", GXutil.rtrim( Dvelop_confirmpanel_reabrir_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR_Result", GXutil.rtrim( Dvelop_confirmpanel_cancelar_Result));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION_Result", GXutil.rtrim( Dvelop_confirmpanel_proximaaccion_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Result", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR_Result", GXutil.rtrim( Dvelop_confirmpanel_reliquidar_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CERRAR_Result", GXutil.rtrim( Dvelop_confirmpanel_cerrar_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_REABRIR_Result", GXutil.rtrim( Dvelop_confirmpanel_reabrir_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR_Result", GXutil.rtrim( Dvelop_confirmpanel_cancelar_Result));
   }

   public void renderHtmlCloseForm2M2( )
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
      return "LiquidacionWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Liquidaciones", "") ;
   }

   public void wb2M0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.liquidacionww");
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
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/GridTitlesCategories/GridTitlesCategoriesRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
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
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain P0 ML30n", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablefiltrospadre_Internalname, 1, 0, "px", 0, "px", "TableFiltrosPadre", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         wb_table1_11_2M2( true) ;
      }
      else
      {
         wb_table1_11_2M2( false) ;
      }
      return  ;
   }

   public void wb_table1_11_2M2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLiqrelnro_Internalname, httpContext.getMessage( "Liq Rel Nro", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'" + sPrefix + "',false,'" + sGXsfl_70_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLiqrelnro_Internalname, GXutil.ltrim( localUtil.ntoc( AV185LiqRelNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavLiqrelnro_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV185LiqRelNro), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV185LiqRelNro), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,21);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLiqrelnro_Jsonclick, 0, "Attribute", "", "", "", "", edtavLiqrelnro_Visible, edtavLiqrelnro_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiquidacionWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table2_23_2M2( true) ;
      }
      else
      {
         wb_table2_23_2M2( false) ;
      }
      return  ;
   }

   public void wb_table2_23_2M2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridFixedTitles HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol70( ) ;
      }
      if ( wbEnd == 70 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_70 = (int)(nGXsfl_70_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV33GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV34GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV32GridAppliedFilters);
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV25DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtPeriodoLiq_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtPeriodoLiq_Internalname, localUtil.format(A1729PeriodoLiq, "99/99/99"), localUtil.format( A1729PeriodoLiq, "99/99/99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPeriodoLiq_Jsonclick, 0, "Attribute", "", "", "", "", edtPeriodoLiq_Visible, 0, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Periodo", "right", false, "", "HLP_LiquidacionWW.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtPeriodoLiq_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtPeriodoLiq_Visible==0)||(0==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LiquidacionWW.htm");
         httpContext.writeTextNL( "</div>") ;
         wb_table3_115_2M2( true) ;
      }
      else
      {
         wb_table3_115_2M2( false) ;
      }
      return  ;
   }

   public void wb_table3_115_2M2e( boolean wbgen )
   {
      if ( wbgen )
      {
         wb_table4_120_2M2( true) ;
      }
      else
      {
         wb_table4_120_2M2( false) ;
      }
      return  ;
   }

   public void wb_table4_120_2M2e( boolean wbgen )
   {
      if ( wbgen )
      {
         wb_table5_125_2M2( true) ;
      }
      else
      {
         wb_table5_125_2M2( false) ;
      }
      return  ;
   }

   public void wb_table5_125_2M2e( boolean wbgen )
   {
      if ( wbgen )
      {
         wb_table6_130_2M2( true) ;
      }
      else
      {
         wb_table6_130_2M2( false) ;
      }
      return  ;
   }

   public void wb_table6_130_2M2e( boolean wbgen )
   {
      if ( wbgen )
      {
         wb_table7_135_2M2( true) ;
      }
      else
      {
         wb_table7_135_2M2( false) ;
      }
      return  ;
   }

   public void wb_table7_135_2M2e( boolean wbgen )
   {
      if ( wbgen )
      {
         wb_table8_140_2M2( true) ;
      }
      else
      {
         wb_table8_140_2M2( false) ;
      }
      return  ;
   }

   public void wb_table8_140_2M2e( boolean wbgen )
   {
      if ( wbgen )
      {
         /* User Defined Control */
         ucGrid_titlescategories.setProperty("GridTitlesCategories", Grid_titlescategories_Gridtitlescategories);
         ucGrid_titlescategories.render(context, "dvelop.gridtitlescategories", Grid_titlescategories_Internalname, sPrefix+"GRID_TITLESCATEGORIESContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasCategories", Grid_empowerer_Hascategories);
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, sPrefix+"GRID_EMPOWERERContainer");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDdo_liqfechaauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 148,'" + sPrefix + "',false,'" + sGXsfl_70_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_liqfechaauxdatetext_Internalname, AV17DDO_LiqFechaAuxDateText, GXutil.rtrim( localUtil.format( AV17DDO_LiqFechaAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,148);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_liqfechaauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LiquidacionWW.htm");
         /* User Defined Control */
         ucTfliqfecha_rangepicker.setProperty("Start Date", AV16DDO_LiqFechaAuxDate);
         ucTfliqfecha_rangepicker.setProperty("End Date", AV18DDO_LiqFechaAuxDateTo);
         ucTfliqfecha_rangepicker.render(context, "wwp.daterangepicker", Tfliqfecha_rangepicker_Internalname, sPrefix+"TFLIQFECHA_RANGEPICKERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDdo_liqfecpagoauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 151,'" + sPrefix + "',false,'" + sGXsfl_70_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_liqfecpagoauxdatetext_Internalname, AV20DDO_LiqFecPagoAuxDateText, GXutil.rtrim( localUtil.format( AV20DDO_LiqFecPagoAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,151);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_liqfecpagoauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LiquidacionWW.htm");
         /* User Defined Control */
         ucTfliqfecpago_rangepicker.setProperty("Start Date", AV19DDO_LiqFecPagoAuxDate);
         ucTfliqfecpago_rangepicker.setProperty("End Date", AV21DDO_LiqFecPagoAuxDateTo);
         ucTfliqfecpago_rangepicker.render(context, "wwp.daterangepicker", Tfliqfecpago_rangepicker_Internalname, sPrefix+"TFLIQFECPAGO_RANGEPICKERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 70 )
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

   public void start2M2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( " Liquidaciones", ""), (short)(0)) ;
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
            strup2M0( ) ;
         }
      }
   }

   public void ws2M2( )
   {
      start2M2( ) ;
      evt2M2( ) ;
   }

   public void evt2M2( )
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
                              strup2M0( ) ;
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
                              strup2M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e112M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e122M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e132M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e142M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e152M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_PROXIMAACCION.CLOSE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e162M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_ELIMINAR.CLOSE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e172M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_RELIQUIDAR.CLOSE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e182M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_CERRAR.CLOSE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e192M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_REABRIR.CLOSE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e202M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_CANCELAR.CLOSE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e212M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoInsert' */
                                 e222M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoExport' */
                                 e232M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GLOBALEVENTS.MENSAJELIQUIDACION") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e242M2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2M0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavProximaaccion_Internalname ;
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 20), "VPROXIMAACCION.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 18), "VGRIDACTIONS.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 17), "'DOELIMINARTODAS'") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 20), "VPROXIMAACCION.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 18), "VGRIDACTIONS.CLICK") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2M0( ) ;
                           }
                           nGXsfl_70_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_70_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_70_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_702( ) ;
                           AV45ProximaAccion = httpContext.cgiGet( edtavProximaaccion_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavProximaaccion_Internalname, AV45ProximaAccion);
                           cmbavGridactions.setName( cmbavGridactions.getInternalname() );
                           cmbavGridactions.setValue( httpContext.cgiGet( cmbavGridactions.getInternalname()) );
                           AV31GridActions = (short)(GXutil.lval( httpContext.cgiGet( cmbavGridactions.getInternalname()))) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, cmbavGridactions.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31GridActions), 4, 0));
                           A31LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A874LiqNombre = httpContext.cgiGet( edtLiqNombre_Internalname) ;
                           A98LiqFecha = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLiqFecha_Internalname), 0)) ;
                           A748LiqPerPalabra = httpContext.cgiGet( edtLiqPerPalabra_Internalname) ;
                           A280LiqFecPago = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLiqFecPago_Internalname), 0)) ;
                           A2368TLiqDescAux = GXutil.upper( httpContext.cgiGet( edtTLiqDescAux_Internalname)) ;
                           cmbLiqClase.setName( cmbLiqClase.getInternalname() );
                           cmbLiqClase.setValue( httpContext.cgiGet( cmbLiqClase.getInternalname()) );
                           A268LiqClase = (byte)(GXutil.lval( httpContext.cgiGet( cmbLiqClase.getInternalname()))) ;
                           n268LiqClase = false ;
                           cmbLiqModTra.setName( cmbLiqModTra.getInternalname() );
                           cmbLiqModTra.setValue( httpContext.cgiGet( cmbLiqModTra.getInternalname()) );
                           A2409LiqModTra = httpContext.cgiGet( cmbLiqModTra.getInternalname()) ;
                           cmbLiqFrecPag.setName( cmbLiqFrecPag.getInternalname() );
                           cmbLiqFrecPag.setValue( httpContext.cgiGet( cmbLiqFrecPag.getInternalname()) );
                           A2414LiqFrecPag = (byte)(GXutil.lval( httpContext.cgiGet( cmbLiqFrecPag.getInternalname()))) ;
                           A495LiqCntLeg = (short)(localUtil.ctol( httpContext.cgiGet( edtLiqCntLeg_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           cmbLiqEstado.setName( cmbLiqEstado.getInternalname() );
                           cmbLiqEstado.setValue( httpContext.cgiGet( cmbLiqEstado.getInternalname()) );
                           A278LiqEstado = (byte)(GXutil.lval( httpContext.cgiGet( cmbLiqEstado.getInternalname()))) ;
                           cmbLiqLSDDepEst.setName( cmbLiqLSDDepEst.getInternalname() );
                           cmbLiqLSDDepEst.setValue( httpContext.cgiGet( cmbLiqLSDDepEst.getInternalname()) );
                           A2292LiqLSDDepEst = (byte)(GXutil.lval( httpContext.cgiGet( cmbLiqLSDDepEst.getInternalname()))) ;
                           cmbLiqContrEst.setName( cmbLiqContrEst.getInternalname() );
                           cmbLiqContrEst.setValue( httpContext.cgiGet( cmbLiqContrEst.getInternalname()) );
                           A2293LiqContrEst = (byte)(GXutil.lval( httpContext.cgiGet( cmbLiqContrEst.getInternalname()))) ;
                           cmbLiqPDFEstado.setName( cmbLiqPDFEstado.getInternalname() );
                           cmbLiqPDFEstado.setValue( httpContext.cgiGet( cmbLiqPDFEstado.getInternalname()) );
                           A2180LiqPDFEstado = httpContext.cgiGet( cmbLiqPDFEstado.getInternalname()) ;
                           n2180LiqPDFEstado = false ;
                           cmbLiqAuxEstado.setName( cmbLiqAuxEstado.getInternalname() );
                           cmbLiqAuxEstado.setValue( httpContext.cgiGet( cmbLiqAuxEstado.getInternalname()) );
                           A1403LiqAuxEstado = (byte)(GXutil.lval( httpContext.cgiGet( cmbLiqAuxEstado.getInternalname()))) ;
                           AV194EstadoPrin = httpContext.cgiGet( edtavEstadoprin_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadoprin_Internalname, AV194EstadoPrin);
                           AV203EstadoPDF = httpContext.cgiGet( edtavEstadopdf_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadopdf_Internalname, AV203EstadoPDF);
                           AV201EstadoLSDDep = httpContext.cgiGet( edtavEstadolsddep_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadolsddep_Internalname, AV201EstadoLSDDep);
                           AV202EstadoContr = httpContext.cgiGet( edtavEstadocontr_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadocontr_Internalname, AV202EstadoContr);
                           AV204EstadoAuxFut = httpContext.cgiGet( edtavEstadoauxfut_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadoauxfut_Internalname, AV204EstadoAuxFut);
                           A766LiqError = httpContext.cgiGet( edtLiqError_Internalname) ;
                           A271LiqDescrip = httpContext.cgiGet( edtLiqDescrip_Internalname) ;
                           A1142LiqLog = httpContext.cgiGet( edtLiqLog_Internalname) ;
                           A885LiqSegundos = localUtil.ctond( httpContext.cgiGet( edtLiqSegundos_Internalname)) ;
                           A497LiqImpBruto = localUtil.ctond( httpContext.cgiGet( edtLiqImpBruto_Internalname)) ;
                           A496LiqImpNeto = localUtil.ctond( httpContext.cgiGet( edtLiqImpNeto_Internalname)) ;
                           AV175Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplay_Internalname, AV175Display);
                           AV102Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavUpdate_Internalname, AV102Update);
                           AV173VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavVersvg_Internalname, AV173VerSVG);
                           AV174ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavModificarsvg_Internalname, AV174ModificarSVG);
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
                                       GX_FocusControl = edtavProximaaccion_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e252M2 ();
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
                                       GX_FocusControl = edtavProximaaccion_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Refresh */
                                       e262M2 ();
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
                                       GX_FocusControl = edtavProximaaccion_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e272M2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "VPROXIMAACCION.CLICK") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavProximaaccion_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e282M2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "VGRIDACTIONS.CLICK") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavProximaaccion_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e292M2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "'DOELIMINARTODAS'") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavProximaaccion_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: 'DoEliminarTodas' */
                                       e302M2 ();
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
                                    strup2M0( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavProximaaccion_Internalname ;
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

   public void we2M2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm2M2( ) ;
         }
      }
   }

   public void pa2M2( )
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
            GX_FocusControl = edtavLiqrelnro_Internalname ;
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
      subsflControlProps_702( ) ;
      while ( nGXsfl_70_idx <= nRC_GXsfl_70 )
      {
         sendrow_702( ) ;
         nGXsfl_70_idx = ((subGrid_Islastpage==1)&&(nGXsfl_70_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_70_idx+1) ;
         sGXsfl_70_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_70_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_702( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 byte AV123ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV9ColumnsSelector ,
                                 String AV231Pgmname ,
                                 String AV176MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV35GridState ,
                                 java.util.Date AV162PeriodoLiq ,
                                 int AV185LiqRelNro ,
                                 int AV74TFLiqNro ,
                                 int AV75TFLiqNro_To ,
                                 String AV139TFLiqNombre ,
                                 String AV141TFLiqNombre_Sel ,
                                 java.util.Date AV66TFLiqFecha ,
                                 java.util.Date AV67TFLiqFecha_To ,
                                 String AV113TFLiqPerPalabra ,
                                 GXSimpleCollection<String> AV114TFLiqPerPalabra_Sels ,
                                 java.util.Date AV68TFLiqFecPago ,
                                 java.util.Date AV69TFLiqFecPago_To ,
                                 String AV216TFTLiqDescAux ,
                                 GXSimpleCollection<String> AV217TFTLiqDescAux_Sels ,
                                 GXSimpleCollection<String> AV226TFLiqModTra_Sels ,
                                 GXSimpleCollection<Byte> AV228TFLiqFrecPag_Sels ,
                                 short AV56TFLiqCntLeg ,
                                 short AV57TFLiqCntLeg_To ,
                                 String AV119TFLiqError ,
                                 GXSimpleCollection<String> AV120TFLiqError_Sels ,
                                 String AV58TFLiqDescrip ,
                                 GXSimpleCollection<String> AV60TFLiqDescrip_Sels ,
                                 java.math.BigDecimal AV70TFLiqImpBruto ,
                                 java.math.BigDecimal AV71TFLiqImpBruto_To ,
                                 java.math.BigDecimal AV72TFLiqImpNeto ,
                                 java.math.BigDecimal AV73TFLiqImpNeto_To ,
                                 short AV41OrderedBy ,
                                 boolean AV43OrderedDsc ,
                                 int AV7CliCod ,
                                 boolean AV39IsAuthorized_Update ,
                                 short AV27EmpCod ,
                                 GXSimpleCollection<Integer> AV189collectionLegNumero ,
                                 int A3CliCod ,
                                 java.util.Date A283LiqPeriodo ,
                                 java.util.Date A719LiqFecImp ,
                                 boolean A361LiqGenInter ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e262M2 ();
      GRID_nCurrentRecord = 0 ;
      rf2M2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_EMPCOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQESTADO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A278LiqEstado), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LIQESTADO", GXutil.ltrim( localUtil.ntoc( A278LiqEstado, (byte)(1), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQNRO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LIQNRO", GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQNOMBRE", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( A874LiqNombre, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LIQNOMBRE", A874LiqNombre);
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
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2M2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV231Pgmname = "LiquidacionWW" ;
      Gx_err = (short)(0) ;
      edtavProximaaccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavProximaaccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProximaaccion_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavEstadoprin_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadoprin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadoprin_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavEstadopdf_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadopdf_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadopdf_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavEstadolsddep_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadolsddep_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadolsddep_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavEstadocontr_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadocontr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadocontr_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavEstadoauxfut_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadoauxfut_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadoauxfut_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_70_Refreshing);
   }

   public void rf2M2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(70) ;
      /* Execute user event: Refresh */
      e262M2 ();
      nGXsfl_70_idx = 1 ;
      sGXsfl_70_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_70_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_702( ) ;
      bGXsfl_70_Refreshing = true ;
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
         subsflControlProps_702( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A748LiqPerPalabra ,
                                              AV241Liquidacionwwds_10_tfliqperpalabra_sels ,
                                              A2368TLiqDescAux ,
                                              AV245Liquidacionwwds_14_tftliqdescaux_sels ,
                                              A2409LiqModTra ,
                                              AV246Liquidacionwwds_15_tfliqmodtra_sels ,
                                              Byte.valueOf(A2414LiqFrecPag) ,
                                              AV247Liquidacionwwds_16_tfliqfrecpag_sels ,
                                              A766LiqError ,
                                              AV251Liquidacionwwds_20_tfliqerror_sels ,
                                              A271LiqDescrip ,
                                              AV253Liquidacionwwds_22_tfliqdescrip_sels ,
                                              Integer.valueOf(AV234Liquidacionwwds_3_tfliqnro) ,
                                              Integer.valueOf(AV235Liquidacionwwds_4_tfliqnro_to) ,
                                              AV237Liquidacionwwds_6_tfliqnombre_sel ,
                                              AV238Liquidacionwwds_7_tfliqfecha ,
                                              AV239Liquidacionwwds_8_tfliqfecha_to ,
                                              Integer.valueOf(AV241Liquidacionwwds_10_tfliqperpalabra_sels.size()) ,
                                              AV240Liquidacionwwds_9_tfliqperpalabra ,
                                              AV242Liquidacionwwds_11_tfliqfecpago ,
                                              AV243Liquidacionwwds_12_tfliqfecpago_to ,
                                              Integer.valueOf(AV245Liquidacionwwds_14_tftliqdescaux_sels.size()) ,
                                              AV244Liquidacionwwds_13_tftliqdescaux ,
                                              Integer.valueOf(AV246Liquidacionwwds_15_tfliqmodtra_sels.size()) ,
                                              Integer.valueOf(AV247Liquidacionwwds_16_tfliqfrecpag_sels.size()) ,
                                              Short.valueOf(AV248Liquidacionwwds_17_tfliqcntleg) ,
                                              Short.valueOf(AV249Liquidacionwwds_18_tfliqcntleg_to) ,
                                              Integer.valueOf(AV251Liquidacionwwds_20_tfliqerror_sels.size()) ,
                                              AV250Liquidacionwwds_19_tfliqerror ,
                                              Integer.valueOf(AV253Liquidacionwwds_22_tfliqdescrip_sels.size()) ,
                                              AV252Liquidacionwwds_21_tfliqdescrip ,
                                              AV254Liquidacionwwds_23_tfliqimpbruto ,
                                              AV255Liquidacionwwds_24_tfliqimpbruto_to ,
                                              AV256Liquidacionwwds_25_tfliqimpneto ,
                                              AV257Liquidacionwwds_26_tfliqimpneto_to ,
                                              Integer.valueOf(A31LiqNro) ,
                                              A874LiqNombre ,
                                              A98LiqFecha ,
                                              A280LiqFecPago ,
                                              Short.valueOf(A495LiqCntLeg) ,
                                              A497LiqImpBruto ,
                                              A496LiqImpNeto ,
                                              Short.valueOf(AV41OrderedBy) ,
                                              Boolean.valueOf(AV43OrderedDsc) ,
                                              Integer.valueOf(A2112LiqRelNro) ,
                                              A1729PeriodoLiq ,
                                              AV232Liquidacionwwds_1_periodoliq ,
                                              Integer.valueOf(AV7CliCod) ,
                                              Short.valueOf(AV27EmpCod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE,
                                              TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                              TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.BOOLEAN,
                                              TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         lV240Liquidacionwwds_9_tfliqperpalabra = GXutil.padr( GXutil.rtrim( AV240Liquidacionwwds_9_tfliqperpalabra), 20, "%") ;
         lV244Liquidacionwwds_13_tftliqdescaux = GXutil.concat( GXutil.rtrim( AV244Liquidacionwwds_13_tftliqdescaux), "%", "") ;
         lV250Liquidacionwwds_19_tfliqerror = GXutil.concat( GXutil.rtrim( AV250Liquidacionwwds_19_tfliqerror), "%", "") ;
         lV252Liquidacionwwds_21_tfliqdescrip = GXutil.concat( GXutil.rtrim( AV252Liquidacionwwds_21_tfliqdescrip), "%", "") ;
         /* Using cursor H002M2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV7CliCod), Short.valueOf(AV27EmpCod), AV232Liquidacionwwds_1_periodoliq, Integer.valueOf(AV234Liquidacionwwds_3_tfliqnro), Integer.valueOf(AV235Liquidacionwwds_4_tfliqnro_to), AV237Liquidacionwwds_6_tfliqnombre_sel, AV238Liquidacionwwds_7_tfliqfecha, AV239Liquidacionwwds_8_tfliqfecha_to, lV240Liquidacionwwds_9_tfliqperpalabra, AV242Liquidacionwwds_11_tfliqfecpago, AV243Liquidacionwwds_12_tfliqfecpago_to, lV244Liquidacionwwds_13_tftliqdescaux, Short.valueOf(AV248Liquidacionwwds_17_tfliqcntleg), Short.valueOf(AV249Liquidacionwwds_18_tfliqcntleg_to), lV250Liquidacionwwds_19_tfliqerror, lV252Liquidacionwwds_21_tfliqdescrip, AV254Liquidacionwwds_23_tfliqimpbruto, AV255Liquidacionwwds_24_tfliqimpbruto_to, AV256Liquidacionwwds_25_tfliqimpneto, AV257Liquidacionwwds_26_tfliqimpneto_to, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_70_idx = 1 ;
         sGXsfl_70_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_70_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_702( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A2112LiqRelNro = H002M2_A2112LiqRelNro[0] ;
            n2112LiqRelNro = H002M2_n2112LiqRelNro[0] ;
            A719LiqFecImp = H002M2_A719LiqFecImp[0] ;
            A3CliCod = H002M2_A3CliCod[0] ;
            A283LiqPeriodo = H002M2_A283LiqPeriodo[0] ;
            A361LiqGenInter = H002M2_A361LiqGenInter[0] ;
            A1729PeriodoLiq = H002M2_A1729PeriodoLiq[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
            A496LiqImpNeto = H002M2_A496LiqImpNeto[0] ;
            A497LiqImpBruto = H002M2_A497LiqImpBruto[0] ;
            A885LiqSegundos = H002M2_A885LiqSegundos[0] ;
            A1142LiqLog = H002M2_A1142LiqLog[0] ;
            A271LiqDescrip = H002M2_A271LiqDescrip[0] ;
            A766LiqError = H002M2_A766LiqError[0] ;
            A1403LiqAuxEstado = H002M2_A1403LiqAuxEstado[0] ;
            A2180LiqPDFEstado = H002M2_A2180LiqPDFEstado[0] ;
            n2180LiqPDFEstado = H002M2_n2180LiqPDFEstado[0] ;
            A2293LiqContrEst = H002M2_A2293LiqContrEst[0] ;
            A2292LiqLSDDepEst = H002M2_A2292LiqLSDDepEst[0] ;
            A278LiqEstado = H002M2_A278LiqEstado[0] ;
            A495LiqCntLeg = H002M2_A495LiqCntLeg[0] ;
            A2414LiqFrecPag = H002M2_A2414LiqFrecPag[0] ;
            A2409LiqModTra = H002M2_A2409LiqModTra[0] ;
            A268LiqClase = H002M2_A268LiqClase[0] ;
            n268LiqClase = H002M2_n268LiqClase[0] ;
            A2368TLiqDescAux = H002M2_A2368TLiqDescAux[0] ;
            A280LiqFecPago = H002M2_A280LiqFecPago[0] ;
            A748LiqPerPalabra = H002M2_A748LiqPerPalabra[0] ;
            A98LiqFecha = H002M2_A98LiqFecha[0] ;
            A874LiqNombre = H002M2_A874LiqNombre[0] ;
            A1EmpCod = H002M2_A1EmpCod[0] ;
            A31LiqNro = H002M2_A31LiqNro[0] ;
            e272M2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(70) ;
         wb2M0( ) ;
      }
      bGXsfl_70_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2M2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV231Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV231Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_EMPCOD"+"_"+sGXsfl_70_idx, getSecureSignedToken( sPrefix+sGXsfl_70_idx, localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_CLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQESTADO"+"_"+sGXsfl_70_idx, getSecureSignedToken( sPrefix+sGXsfl_70_idx, localUtil.format( DecimalUtil.doubleToDec(A278LiqEstado), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LIQPERIODO", localUtil.dtoc( A283LiqPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQPERIODO", getSecureSignedToken( sPrefix, A283LiqPeriodo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LIQFECIMP", localUtil.ttoc( A719LiqFecImp, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQFECIMP", getSecureSignedToken( sPrefix, localUtil.format( A719LiqFecImp, "99/99/99 99:99")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV39IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV39IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"LIQGENINTER", A361LiqGenInter);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQGENINTER", getSecureSignedToken( sPrefix, A361LiqGenInter));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQNRO"+"_"+sGXsfl_70_idx, getSecureSignedToken( sPrefix+sGXsfl_70_idx, localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCOLLECTIONLEGNUMERO", AV189collectionLegNumero);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCOLLECTIONLEGNUMERO", AV189collectionLegNumero);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vCOLLECTIONLEGNUMERO", getSecureSignedToken( sPrefix, AV189collectionLegNumero));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LIQNOMBRE"+"_"+sGXsfl_70_idx, getSecureSignedToken( sPrefix+sGXsfl_70_idx, GXutil.rtrim( localUtil.format( A874LiqNombre, ""))));
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
      AV232Liquidacionwwds_1_periodoliq = AV162PeriodoLiq ;
      AV233Liquidacionwwds_2_liqrelnro = AV185LiqRelNro ;
      AV234Liquidacionwwds_3_tfliqnro = AV74TFLiqNro ;
      AV235Liquidacionwwds_4_tfliqnro_to = AV75TFLiqNro_To ;
      AV236Liquidacionwwds_5_tfliqnombre = AV139TFLiqNombre ;
      AV237Liquidacionwwds_6_tfliqnombre_sel = AV141TFLiqNombre_Sel ;
      AV238Liquidacionwwds_7_tfliqfecha = AV66TFLiqFecha ;
      AV239Liquidacionwwds_8_tfliqfecha_to = AV67TFLiqFecha_To ;
      AV240Liquidacionwwds_9_tfliqperpalabra = AV113TFLiqPerPalabra ;
      AV241Liquidacionwwds_10_tfliqperpalabra_sels = AV114TFLiqPerPalabra_Sels ;
      AV242Liquidacionwwds_11_tfliqfecpago = AV68TFLiqFecPago ;
      AV243Liquidacionwwds_12_tfliqfecpago_to = AV69TFLiqFecPago_To ;
      AV244Liquidacionwwds_13_tftliqdescaux = AV216TFTLiqDescAux ;
      AV245Liquidacionwwds_14_tftliqdescaux_sels = AV217TFTLiqDescAux_Sels ;
      AV246Liquidacionwwds_15_tfliqmodtra_sels = AV226TFLiqModTra_Sels ;
      AV247Liquidacionwwds_16_tfliqfrecpag_sels = AV228TFLiqFrecPag_Sels ;
      AV248Liquidacionwwds_17_tfliqcntleg = AV56TFLiqCntLeg ;
      AV249Liquidacionwwds_18_tfliqcntleg_to = AV57TFLiqCntLeg_To ;
      AV250Liquidacionwwds_19_tfliqerror = AV119TFLiqError ;
      AV251Liquidacionwwds_20_tfliqerror_sels = AV120TFLiqError_Sels ;
      AV252Liquidacionwwds_21_tfliqdescrip = AV58TFLiqDescrip ;
      AV253Liquidacionwwds_22_tfliqdescrip_sels = AV60TFLiqDescrip_Sels ;
      AV254Liquidacionwwds_23_tfliqimpbruto = AV70TFLiqImpBruto ;
      AV255Liquidacionwwds_24_tfliqimpbruto_to = AV71TFLiqImpBruto_To ;
      AV256Liquidacionwwds_25_tfliqimpneto = AV72TFLiqImpNeto ;
      AV257Liquidacionwwds_26_tfliqimpneto_to = AV73TFLiqImpNeto_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A748LiqPerPalabra ,
                                           AV241Liquidacionwwds_10_tfliqperpalabra_sels ,
                                           A2368TLiqDescAux ,
                                           AV245Liquidacionwwds_14_tftliqdescaux_sels ,
                                           A2409LiqModTra ,
                                           AV246Liquidacionwwds_15_tfliqmodtra_sels ,
                                           Byte.valueOf(A2414LiqFrecPag) ,
                                           AV247Liquidacionwwds_16_tfliqfrecpag_sels ,
                                           A766LiqError ,
                                           AV251Liquidacionwwds_20_tfliqerror_sels ,
                                           A271LiqDescrip ,
                                           AV253Liquidacionwwds_22_tfliqdescrip_sels ,
                                           Integer.valueOf(AV234Liquidacionwwds_3_tfliqnro) ,
                                           Integer.valueOf(AV235Liquidacionwwds_4_tfliqnro_to) ,
                                           AV237Liquidacionwwds_6_tfliqnombre_sel ,
                                           AV238Liquidacionwwds_7_tfliqfecha ,
                                           AV239Liquidacionwwds_8_tfliqfecha_to ,
                                           Integer.valueOf(AV241Liquidacionwwds_10_tfliqperpalabra_sels.size()) ,
                                           AV240Liquidacionwwds_9_tfliqperpalabra ,
                                           AV242Liquidacionwwds_11_tfliqfecpago ,
                                           AV243Liquidacionwwds_12_tfliqfecpago_to ,
                                           Integer.valueOf(AV245Liquidacionwwds_14_tftliqdescaux_sels.size()) ,
                                           AV244Liquidacionwwds_13_tftliqdescaux ,
                                           Integer.valueOf(AV246Liquidacionwwds_15_tfliqmodtra_sels.size()) ,
                                           Integer.valueOf(AV247Liquidacionwwds_16_tfliqfrecpag_sels.size()) ,
                                           Short.valueOf(AV248Liquidacionwwds_17_tfliqcntleg) ,
                                           Short.valueOf(AV249Liquidacionwwds_18_tfliqcntleg_to) ,
                                           Integer.valueOf(AV251Liquidacionwwds_20_tfliqerror_sels.size()) ,
                                           AV250Liquidacionwwds_19_tfliqerror ,
                                           Integer.valueOf(AV253Liquidacionwwds_22_tfliqdescrip_sels.size()) ,
                                           AV252Liquidacionwwds_21_tfliqdescrip ,
                                           AV254Liquidacionwwds_23_tfliqimpbruto ,
                                           AV255Liquidacionwwds_24_tfliqimpbruto_to ,
                                           AV256Liquidacionwwds_25_tfliqimpneto ,
                                           AV257Liquidacionwwds_26_tfliqimpneto_to ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A874LiqNombre ,
                                           A98LiqFecha ,
                                           A280LiqFecPago ,
                                           Short.valueOf(A495LiqCntLeg) ,
                                           A497LiqImpBruto ,
                                           A496LiqImpNeto ,
                                           Short.valueOf(AV41OrderedBy) ,
                                           Boolean.valueOf(AV43OrderedDsc) ,
                                           Integer.valueOf(A2112LiqRelNro) ,
                                           A1729PeriodoLiq ,
                                           AV232Liquidacionwwds_1_periodoliq ,
                                           Integer.valueOf(AV7CliCod) ,
                                           Short.valueOf(AV27EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV240Liquidacionwwds_9_tfliqperpalabra = GXutil.padr( GXutil.rtrim( AV240Liquidacionwwds_9_tfliqperpalabra), 20, "%") ;
      lV244Liquidacionwwds_13_tftliqdescaux = GXutil.concat( GXutil.rtrim( AV244Liquidacionwwds_13_tftliqdescaux), "%", "") ;
      lV250Liquidacionwwds_19_tfliqerror = GXutil.concat( GXutil.rtrim( AV250Liquidacionwwds_19_tfliqerror), "%", "") ;
      lV252Liquidacionwwds_21_tfliqdescrip = GXutil.concat( GXutil.rtrim( AV252Liquidacionwwds_21_tfliqdescrip), "%", "") ;
      /* Using cursor H002M3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV7CliCod), Short.valueOf(AV27EmpCod), AV232Liquidacionwwds_1_periodoliq, Integer.valueOf(AV234Liquidacionwwds_3_tfliqnro), Integer.valueOf(AV235Liquidacionwwds_4_tfliqnro_to), AV237Liquidacionwwds_6_tfliqnombre_sel, AV238Liquidacionwwds_7_tfliqfecha, AV239Liquidacionwwds_8_tfliqfecha_to, lV240Liquidacionwwds_9_tfliqperpalabra, AV242Liquidacionwwds_11_tfliqfecpago, AV243Liquidacionwwds_12_tfliqfecpago_to, lV244Liquidacionwwds_13_tftliqdescaux, Short.valueOf(AV248Liquidacionwwds_17_tfliqcntleg), Short.valueOf(AV249Liquidacionwwds_18_tfliqcntleg_to), lV250Liquidacionwwds_19_tfliqerror, lV252Liquidacionwwds_21_tfliqdescrip, AV254Liquidacionwwds_23_tfliqimpbruto, AV255Liquidacionwwds_24_tfliqimpbruto_to, AV256Liquidacionwwds_25_tfliqimpneto, AV257Liquidacionwwds_26_tfliqimpneto_to});
      GRID_nRecordCount = H002M3_AGRID_nRecordCount[0] ;
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
      AV232Liquidacionwwds_1_periodoliq = AV162PeriodoLiq ;
      AV233Liquidacionwwds_2_liqrelnro = AV185LiqRelNro ;
      AV234Liquidacionwwds_3_tfliqnro = AV74TFLiqNro ;
      AV235Liquidacionwwds_4_tfliqnro_to = AV75TFLiqNro_To ;
      AV236Liquidacionwwds_5_tfliqnombre = AV139TFLiqNombre ;
      AV237Liquidacionwwds_6_tfliqnombre_sel = AV141TFLiqNombre_Sel ;
      AV238Liquidacionwwds_7_tfliqfecha = AV66TFLiqFecha ;
      AV239Liquidacionwwds_8_tfliqfecha_to = AV67TFLiqFecha_To ;
      AV240Liquidacionwwds_9_tfliqperpalabra = AV113TFLiqPerPalabra ;
      AV241Liquidacionwwds_10_tfliqperpalabra_sels = AV114TFLiqPerPalabra_Sels ;
      AV242Liquidacionwwds_11_tfliqfecpago = AV68TFLiqFecPago ;
      AV243Liquidacionwwds_12_tfliqfecpago_to = AV69TFLiqFecPago_To ;
      AV244Liquidacionwwds_13_tftliqdescaux = AV216TFTLiqDescAux ;
      AV245Liquidacionwwds_14_tftliqdescaux_sels = AV217TFTLiqDescAux_Sels ;
      AV246Liquidacionwwds_15_tfliqmodtra_sels = AV226TFLiqModTra_Sels ;
      AV247Liquidacionwwds_16_tfliqfrecpag_sels = AV228TFLiqFrecPag_Sels ;
      AV248Liquidacionwwds_17_tfliqcntleg = AV56TFLiqCntLeg ;
      AV249Liquidacionwwds_18_tfliqcntleg_to = AV57TFLiqCntLeg_To ;
      AV250Liquidacionwwds_19_tfliqerror = AV119TFLiqError ;
      AV251Liquidacionwwds_20_tfliqerror_sels = AV120TFLiqError_Sels ;
      AV252Liquidacionwwds_21_tfliqdescrip = AV58TFLiqDescrip ;
      AV253Liquidacionwwds_22_tfliqdescrip_sels = AV60TFLiqDescrip_Sels ;
      AV254Liquidacionwwds_23_tfliqimpbruto = AV70TFLiqImpBruto ;
      AV255Liquidacionwwds_24_tfliqimpbruto_to = AV71TFLiqImpBruto_To ;
      AV256Liquidacionwwds_25_tfliqimpneto = AV72TFLiqImpNeto ;
      AV257Liquidacionwwds_26_tfliqimpneto_to = AV73TFLiqImpNeto_To ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV123ManageFiltersExecutionStep, AV9ColumnsSelector, AV231Pgmname, AV176MenuOpcCod, AV35GridState, AV162PeriodoLiq, AV185LiqRelNro, AV74TFLiqNro, AV75TFLiqNro_To, AV139TFLiqNombre, AV141TFLiqNombre_Sel, AV66TFLiqFecha, AV67TFLiqFecha_To, AV113TFLiqPerPalabra, AV114TFLiqPerPalabra_Sels, AV68TFLiqFecPago, AV69TFLiqFecPago_To, AV216TFTLiqDescAux, AV217TFTLiqDescAux_Sels, AV226TFLiqModTra_Sels, AV228TFLiqFrecPag_Sels, AV56TFLiqCntLeg, AV57TFLiqCntLeg_To, AV119TFLiqError, AV120TFLiqError_Sels, AV58TFLiqDescrip, AV60TFLiqDescrip_Sels, AV70TFLiqImpBruto, AV71TFLiqImpBruto_To, AV72TFLiqImpNeto, AV73TFLiqImpNeto_To, AV41OrderedBy, AV43OrderedDsc, AV7CliCod, AV39IsAuthorized_Update, AV27EmpCod, AV189collectionLegNumero, A3CliCod, A283LiqPeriodo, A719LiqFecImp, A361LiqGenInter, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV232Liquidacionwwds_1_periodoliq = AV162PeriodoLiq ;
      AV233Liquidacionwwds_2_liqrelnro = AV185LiqRelNro ;
      AV234Liquidacionwwds_3_tfliqnro = AV74TFLiqNro ;
      AV235Liquidacionwwds_4_tfliqnro_to = AV75TFLiqNro_To ;
      AV236Liquidacionwwds_5_tfliqnombre = AV139TFLiqNombre ;
      AV237Liquidacionwwds_6_tfliqnombre_sel = AV141TFLiqNombre_Sel ;
      AV238Liquidacionwwds_7_tfliqfecha = AV66TFLiqFecha ;
      AV239Liquidacionwwds_8_tfliqfecha_to = AV67TFLiqFecha_To ;
      AV240Liquidacionwwds_9_tfliqperpalabra = AV113TFLiqPerPalabra ;
      AV241Liquidacionwwds_10_tfliqperpalabra_sels = AV114TFLiqPerPalabra_Sels ;
      AV242Liquidacionwwds_11_tfliqfecpago = AV68TFLiqFecPago ;
      AV243Liquidacionwwds_12_tfliqfecpago_to = AV69TFLiqFecPago_To ;
      AV244Liquidacionwwds_13_tftliqdescaux = AV216TFTLiqDescAux ;
      AV245Liquidacionwwds_14_tftliqdescaux_sels = AV217TFTLiqDescAux_Sels ;
      AV246Liquidacionwwds_15_tfliqmodtra_sels = AV226TFLiqModTra_Sels ;
      AV247Liquidacionwwds_16_tfliqfrecpag_sels = AV228TFLiqFrecPag_Sels ;
      AV248Liquidacionwwds_17_tfliqcntleg = AV56TFLiqCntLeg ;
      AV249Liquidacionwwds_18_tfliqcntleg_to = AV57TFLiqCntLeg_To ;
      AV250Liquidacionwwds_19_tfliqerror = AV119TFLiqError ;
      AV251Liquidacionwwds_20_tfliqerror_sels = AV120TFLiqError_Sels ;
      AV252Liquidacionwwds_21_tfliqdescrip = AV58TFLiqDescrip ;
      AV253Liquidacionwwds_22_tfliqdescrip_sels = AV60TFLiqDescrip_Sels ;
      AV254Liquidacionwwds_23_tfliqimpbruto = AV70TFLiqImpBruto ;
      AV255Liquidacionwwds_24_tfliqimpbruto_to = AV71TFLiqImpBruto_To ;
      AV256Liquidacionwwds_25_tfliqimpneto = AV72TFLiqImpNeto ;
      AV257Liquidacionwwds_26_tfliqimpneto_to = AV73TFLiqImpNeto_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV123ManageFiltersExecutionStep, AV9ColumnsSelector, AV231Pgmname, AV176MenuOpcCod, AV35GridState, AV162PeriodoLiq, AV185LiqRelNro, AV74TFLiqNro, AV75TFLiqNro_To, AV139TFLiqNombre, AV141TFLiqNombre_Sel, AV66TFLiqFecha, AV67TFLiqFecha_To, AV113TFLiqPerPalabra, AV114TFLiqPerPalabra_Sels, AV68TFLiqFecPago, AV69TFLiqFecPago_To, AV216TFTLiqDescAux, AV217TFTLiqDescAux_Sels, AV226TFLiqModTra_Sels, AV228TFLiqFrecPag_Sels, AV56TFLiqCntLeg, AV57TFLiqCntLeg_To, AV119TFLiqError, AV120TFLiqError_Sels, AV58TFLiqDescrip, AV60TFLiqDescrip_Sels, AV70TFLiqImpBruto, AV71TFLiqImpBruto_To, AV72TFLiqImpNeto, AV73TFLiqImpNeto_To, AV41OrderedBy, AV43OrderedDsc, AV7CliCod, AV39IsAuthorized_Update, AV27EmpCod, AV189collectionLegNumero, A3CliCod, A283LiqPeriodo, A719LiqFecImp, A361LiqGenInter, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV232Liquidacionwwds_1_periodoliq = AV162PeriodoLiq ;
      AV233Liquidacionwwds_2_liqrelnro = AV185LiqRelNro ;
      AV234Liquidacionwwds_3_tfliqnro = AV74TFLiqNro ;
      AV235Liquidacionwwds_4_tfliqnro_to = AV75TFLiqNro_To ;
      AV236Liquidacionwwds_5_tfliqnombre = AV139TFLiqNombre ;
      AV237Liquidacionwwds_6_tfliqnombre_sel = AV141TFLiqNombre_Sel ;
      AV238Liquidacionwwds_7_tfliqfecha = AV66TFLiqFecha ;
      AV239Liquidacionwwds_8_tfliqfecha_to = AV67TFLiqFecha_To ;
      AV240Liquidacionwwds_9_tfliqperpalabra = AV113TFLiqPerPalabra ;
      AV241Liquidacionwwds_10_tfliqperpalabra_sels = AV114TFLiqPerPalabra_Sels ;
      AV242Liquidacionwwds_11_tfliqfecpago = AV68TFLiqFecPago ;
      AV243Liquidacionwwds_12_tfliqfecpago_to = AV69TFLiqFecPago_To ;
      AV244Liquidacionwwds_13_tftliqdescaux = AV216TFTLiqDescAux ;
      AV245Liquidacionwwds_14_tftliqdescaux_sels = AV217TFTLiqDescAux_Sels ;
      AV246Liquidacionwwds_15_tfliqmodtra_sels = AV226TFLiqModTra_Sels ;
      AV247Liquidacionwwds_16_tfliqfrecpag_sels = AV228TFLiqFrecPag_Sels ;
      AV248Liquidacionwwds_17_tfliqcntleg = AV56TFLiqCntLeg ;
      AV249Liquidacionwwds_18_tfliqcntleg_to = AV57TFLiqCntLeg_To ;
      AV250Liquidacionwwds_19_tfliqerror = AV119TFLiqError ;
      AV251Liquidacionwwds_20_tfliqerror_sels = AV120TFLiqError_Sels ;
      AV252Liquidacionwwds_21_tfliqdescrip = AV58TFLiqDescrip ;
      AV253Liquidacionwwds_22_tfliqdescrip_sels = AV60TFLiqDescrip_Sels ;
      AV254Liquidacionwwds_23_tfliqimpbruto = AV70TFLiqImpBruto ;
      AV255Liquidacionwwds_24_tfliqimpbruto_to = AV71TFLiqImpBruto_To ;
      AV256Liquidacionwwds_25_tfliqimpneto = AV72TFLiqImpNeto ;
      AV257Liquidacionwwds_26_tfliqimpneto_to = AV73TFLiqImpNeto_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV123ManageFiltersExecutionStep, AV9ColumnsSelector, AV231Pgmname, AV176MenuOpcCod, AV35GridState, AV162PeriodoLiq, AV185LiqRelNro, AV74TFLiqNro, AV75TFLiqNro_To, AV139TFLiqNombre, AV141TFLiqNombre_Sel, AV66TFLiqFecha, AV67TFLiqFecha_To, AV113TFLiqPerPalabra, AV114TFLiqPerPalabra_Sels, AV68TFLiqFecPago, AV69TFLiqFecPago_To, AV216TFTLiqDescAux, AV217TFTLiqDescAux_Sels, AV226TFLiqModTra_Sels, AV228TFLiqFrecPag_Sels, AV56TFLiqCntLeg, AV57TFLiqCntLeg_To, AV119TFLiqError, AV120TFLiqError_Sels, AV58TFLiqDescrip, AV60TFLiqDescrip_Sels, AV70TFLiqImpBruto, AV71TFLiqImpBruto_To, AV72TFLiqImpNeto, AV73TFLiqImpNeto_To, AV41OrderedBy, AV43OrderedDsc, AV7CliCod, AV39IsAuthorized_Update, AV27EmpCod, AV189collectionLegNumero, A3CliCod, A283LiqPeriodo, A719LiqFecImp, A361LiqGenInter, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV232Liquidacionwwds_1_periodoliq = AV162PeriodoLiq ;
      AV233Liquidacionwwds_2_liqrelnro = AV185LiqRelNro ;
      AV234Liquidacionwwds_3_tfliqnro = AV74TFLiqNro ;
      AV235Liquidacionwwds_4_tfliqnro_to = AV75TFLiqNro_To ;
      AV236Liquidacionwwds_5_tfliqnombre = AV139TFLiqNombre ;
      AV237Liquidacionwwds_6_tfliqnombre_sel = AV141TFLiqNombre_Sel ;
      AV238Liquidacionwwds_7_tfliqfecha = AV66TFLiqFecha ;
      AV239Liquidacionwwds_8_tfliqfecha_to = AV67TFLiqFecha_To ;
      AV240Liquidacionwwds_9_tfliqperpalabra = AV113TFLiqPerPalabra ;
      AV241Liquidacionwwds_10_tfliqperpalabra_sels = AV114TFLiqPerPalabra_Sels ;
      AV242Liquidacionwwds_11_tfliqfecpago = AV68TFLiqFecPago ;
      AV243Liquidacionwwds_12_tfliqfecpago_to = AV69TFLiqFecPago_To ;
      AV244Liquidacionwwds_13_tftliqdescaux = AV216TFTLiqDescAux ;
      AV245Liquidacionwwds_14_tftliqdescaux_sels = AV217TFTLiqDescAux_Sels ;
      AV246Liquidacionwwds_15_tfliqmodtra_sels = AV226TFLiqModTra_Sels ;
      AV247Liquidacionwwds_16_tfliqfrecpag_sels = AV228TFLiqFrecPag_Sels ;
      AV248Liquidacionwwds_17_tfliqcntleg = AV56TFLiqCntLeg ;
      AV249Liquidacionwwds_18_tfliqcntleg_to = AV57TFLiqCntLeg_To ;
      AV250Liquidacionwwds_19_tfliqerror = AV119TFLiqError ;
      AV251Liquidacionwwds_20_tfliqerror_sels = AV120TFLiqError_Sels ;
      AV252Liquidacionwwds_21_tfliqdescrip = AV58TFLiqDescrip ;
      AV253Liquidacionwwds_22_tfliqdescrip_sels = AV60TFLiqDescrip_Sels ;
      AV254Liquidacionwwds_23_tfliqimpbruto = AV70TFLiqImpBruto ;
      AV255Liquidacionwwds_24_tfliqimpbruto_to = AV71TFLiqImpBruto_To ;
      AV256Liquidacionwwds_25_tfliqimpneto = AV72TFLiqImpNeto ;
      AV257Liquidacionwwds_26_tfliqimpneto_to = AV73TFLiqImpNeto_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV123ManageFiltersExecutionStep, AV9ColumnsSelector, AV231Pgmname, AV176MenuOpcCod, AV35GridState, AV162PeriodoLiq, AV185LiqRelNro, AV74TFLiqNro, AV75TFLiqNro_To, AV139TFLiqNombre, AV141TFLiqNombre_Sel, AV66TFLiqFecha, AV67TFLiqFecha_To, AV113TFLiqPerPalabra, AV114TFLiqPerPalabra_Sels, AV68TFLiqFecPago, AV69TFLiqFecPago_To, AV216TFTLiqDescAux, AV217TFTLiqDescAux_Sels, AV226TFLiqModTra_Sels, AV228TFLiqFrecPag_Sels, AV56TFLiqCntLeg, AV57TFLiqCntLeg_To, AV119TFLiqError, AV120TFLiqError_Sels, AV58TFLiqDescrip, AV60TFLiqDescrip_Sels, AV70TFLiqImpBruto, AV71TFLiqImpBruto_To, AV72TFLiqImpNeto, AV73TFLiqImpNeto_To, AV41OrderedBy, AV43OrderedDsc, AV7CliCod, AV39IsAuthorized_Update, AV27EmpCod, AV189collectionLegNumero, A3CliCod, A283LiqPeriodo, A719LiqFecImp, A361LiqGenInter, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV232Liquidacionwwds_1_periodoliq = AV162PeriodoLiq ;
      AV233Liquidacionwwds_2_liqrelnro = AV185LiqRelNro ;
      AV234Liquidacionwwds_3_tfliqnro = AV74TFLiqNro ;
      AV235Liquidacionwwds_4_tfliqnro_to = AV75TFLiqNro_To ;
      AV236Liquidacionwwds_5_tfliqnombre = AV139TFLiqNombre ;
      AV237Liquidacionwwds_6_tfliqnombre_sel = AV141TFLiqNombre_Sel ;
      AV238Liquidacionwwds_7_tfliqfecha = AV66TFLiqFecha ;
      AV239Liquidacionwwds_8_tfliqfecha_to = AV67TFLiqFecha_To ;
      AV240Liquidacionwwds_9_tfliqperpalabra = AV113TFLiqPerPalabra ;
      AV241Liquidacionwwds_10_tfliqperpalabra_sels = AV114TFLiqPerPalabra_Sels ;
      AV242Liquidacionwwds_11_tfliqfecpago = AV68TFLiqFecPago ;
      AV243Liquidacionwwds_12_tfliqfecpago_to = AV69TFLiqFecPago_To ;
      AV244Liquidacionwwds_13_tftliqdescaux = AV216TFTLiqDescAux ;
      AV245Liquidacionwwds_14_tftliqdescaux_sels = AV217TFTLiqDescAux_Sels ;
      AV246Liquidacionwwds_15_tfliqmodtra_sels = AV226TFLiqModTra_Sels ;
      AV247Liquidacionwwds_16_tfliqfrecpag_sels = AV228TFLiqFrecPag_Sels ;
      AV248Liquidacionwwds_17_tfliqcntleg = AV56TFLiqCntLeg ;
      AV249Liquidacionwwds_18_tfliqcntleg_to = AV57TFLiqCntLeg_To ;
      AV250Liquidacionwwds_19_tfliqerror = AV119TFLiqError ;
      AV251Liquidacionwwds_20_tfliqerror_sels = AV120TFLiqError_Sels ;
      AV252Liquidacionwwds_21_tfliqdescrip = AV58TFLiqDescrip ;
      AV253Liquidacionwwds_22_tfliqdescrip_sels = AV60TFLiqDescrip_Sels ;
      AV254Liquidacionwwds_23_tfliqimpbruto = AV70TFLiqImpBruto ;
      AV255Liquidacionwwds_24_tfliqimpbruto_to = AV71TFLiqImpBruto_To ;
      AV256Liquidacionwwds_25_tfliqimpneto = AV72TFLiqImpNeto ;
      AV257Liquidacionwwds_26_tfliqimpneto_to = AV73TFLiqImpNeto_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV123ManageFiltersExecutionStep, AV9ColumnsSelector, AV231Pgmname, AV176MenuOpcCod, AV35GridState, AV162PeriodoLiq, AV185LiqRelNro, AV74TFLiqNro, AV75TFLiqNro_To, AV139TFLiqNombre, AV141TFLiqNombre_Sel, AV66TFLiqFecha, AV67TFLiqFecha_To, AV113TFLiqPerPalabra, AV114TFLiqPerPalabra_Sels, AV68TFLiqFecPago, AV69TFLiqFecPago_To, AV216TFTLiqDescAux, AV217TFTLiqDescAux_Sels, AV226TFLiqModTra_Sels, AV228TFLiqFrecPag_Sels, AV56TFLiqCntLeg, AV57TFLiqCntLeg_To, AV119TFLiqError, AV120TFLiqError_Sels, AV58TFLiqDescrip, AV60TFLiqDescrip_Sels, AV70TFLiqImpBruto, AV71TFLiqImpBruto_To, AV72TFLiqImpNeto, AV73TFLiqImpNeto_To, AV41OrderedBy, AV43OrderedDsc, AV7CliCod, AV39IsAuthorized_Update, AV27EmpCod, AV189collectionLegNumero, A3CliCod, A283LiqPeriodo, A719LiqFecImp, A361LiqGenInter, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV231Pgmname = "LiquidacionWW" ;
      Gx_err = (short)(0) ;
      edtavProximaaccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavProximaaccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProximaaccion_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavEstadoprin_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadoprin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadoprin_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavEstadopdf_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadopdf_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadopdf_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavEstadolsddep_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadolsddep_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadolsddep_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavEstadocontr_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadocontr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadocontr_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavEstadoauxfut_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadoauxfut_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadoauxfut_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_70_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup2M0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e252M2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV25DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vCOLUMNSSELECTOR"), AV9ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vMANAGEFILTERSDATA"), AV121ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_70 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_70"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV33GridCurrentPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV34GridPageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV32GridAppliedFilters = httpContext.cgiGet( sPrefix+"vGRIDAPPLIEDFILTERS") ;
         AV16DDO_LiqFechaAuxDate = localUtil.ctod( httpContext.cgiGet( sPrefix+"vDDO_LIQFECHAAUXDATE"), 0) ;
         AV18DDO_LiqFechaAuxDateTo = localUtil.ctod( httpContext.cgiGet( sPrefix+"vDDO_LIQFECHAAUXDATETO"), 0) ;
         AV19DDO_LiqFecPagoAuxDate = localUtil.ctod( httpContext.cgiGet( sPrefix+"vDDO_LIQFECPAGOAUXDATE"), 0) ;
         AV21DDO_LiqFecPagoAuxDateTo = localUtil.ctod( httpContext.cgiGet( sPrefix+"vDDO_LIQFECPAGOAUXDATETO"), 0) ;
         wcpOAV176MenuOpcCod = httpContext.cgiGet( sPrefix+"wcpOAV176MenuOpcCod") ;
         wcpOAV162PeriodoLiq = localUtil.ctod( httpContext.cgiGet( sPrefix+"wcpOAV162PeriodoLiq"), 0) ;
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
         Dvelop_confirmpanel_proximaaccion_Title = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION_Title") ;
         Dvelop_confirmpanel_proximaaccion_Confirmationtext = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION_Confirmationtext") ;
         Dvelop_confirmpanel_proximaaccion_Yesbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION_Yesbuttoncaption") ;
         Dvelop_confirmpanel_proximaaccion_Nobuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION_Nobuttoncaption") ;
         Dvelop_confirmpanel_proximaaccion_Cancelbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_proximaaccion_Yesbuttonposition = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION_Yesbuttonposition") ;
         Dvelop_confirmpanel_proximaaccion_Confirmtype = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION_Confirmtype") ;
         Dvelop_confirmpanel_eliminar_Title = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Title") ;
         Dvelop_confirmpanel_eliminar_Confirmationtext = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Confirmationtext") ;
         Dvelop_confirmpanel_eliminar_Yesbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttoncaption") ;
         Dvelop_confirmpanel_eliminar_Nobuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Nobuttoncaption") ;
         Dvelop_confirmpanel_eliminar_Cancelbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_eliminar_Yesbuttonposition = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttonposition") ;
         Dvelop_confirmpanel_eliminar_Confirmtype = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Confirmtype") ;
         Dvelop_confirmpanel_reliquidar_Title = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR_Title") ;
         Dvelop_confirmpanel_reliquidar_Confirmationtext = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR_Confirmationtext") ;
         Dvelop_confirmpanel_reliquidar_Yesbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR_Yesbuttoncaption") ;
         Dvelop_confirmpanel_reliquidar_Nobuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR_Nobuttoncaption") ;
         Dvelop_confirmpanel_reliquidar_Cancelbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_reliquidar_Yesbuttonposition = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR_Yesbuttonposition") ;
         Dvelop_confirmpanel_reliquidar_Confirmtype = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR_Confirmtype") ;
         Dvelop_confirmpanel_cerrar_Title = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_CERRAR_Title") ;
         Dvelop_confirmpanel_cerrar_Confirmationtext = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_CERRAR_Confirmationtext") ;
         Dvelop_confirmpanel_cerrar_Yesbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_CERRAR_Yesbuttoncaption") ;
         Dvelop_confirmpanel_cerrar_Nobuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_CERRAR_Nobuttoncaption") ;
         Dvelop_confirmpanel_cerrar_Cancelbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_CERRAR_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_cerrar_Yesbuttonposition = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_CERRAR_Yesbuttonposition") ;
         Dvelop_confirmpanel_cerrar_Confirmtype = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_CERRAR_Confirmtype") ;
         Dvelop_confirmpanel_reabrir_Title = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_REABRIR_Title") ;
         Dvelop_confirmpanel_reabrir_Confirmationtext = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_REABRIR_Confirmationtext") ;
         Dvelop_confirmpanel_reabrir_Yesbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_REABRIR_Yesbuttoncaption") ;
         Dvelop_confirmpanel_reabrir_Nobuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_REABRIR_Nobuttoncaption") ;
         Dvelop_confirmpanel_reabrir_Cancelbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_REABRIR_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_reabrir_Yesbuttonposition = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_REABRIR_Yesbuttonposition") ;
         Dvelop_confirmpanel_reabrir_Confirmtype = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_REABRIR_Confirmtype") ;
         Dvelop_confirmpanel_cancelar_Title = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR_Title") ;
         Dvelop_confirmpanel_cancelar_Confirmationtext = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR_Confirmationtext") ;
         Dvelop_confirmpanel_cancelar_Yesbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR_Yesbuttoncaption") ;
         Dvelop_confirmpanel_cancelar_Nobuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR_Nobuttoncaption") ;
         Dvelop_confirmpanel_cancelar_Cancelbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_cancelar_Yesbuttonposition = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR_Yesbuttonposition") ;
         Dvelop_confirmpanel_cancelar_Confirmtype = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR_Confirmtype") ;
         Grid_titlescategories_Gridinternalname = httpContext.cgiGet( sPrefix+"GRID_TITLESCATEGORIES_Gridinternalname") ;
         Grid_titlescategories_Gridtitlescategories = httpContext.cgiGet( sPrefix+"GRID_TITLESCATEGORIES_Gridtitlescategories") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hascategories = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Hascategories")) ;
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
         Dvelop_confirmpanel_proximaaccion_Result = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION_Result") ;
         Dvelop_confirmpanel_eliminar_Result = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Result") ;
         Dvelop_confirmpanel_reliquidar_Result = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR_Result") ;
         Dvelop_confirmpanel_cerrar_Result = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_CERRAR_Result") ;
         Dvelop_confirmpanel_reabrir_Result = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_REABRIR_Result") ;
         Dvelop_confirmpanel_cancelar_Result = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR_Result") ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavLiqrelnro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavLiqrelnro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vLIQRELNRO");
            GX_FocusControl = edtavLiqrelnro_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV185LiqRelNro = 0 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV185LiqRelNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV185LiqRelNro), 8, 0));
         }
         else
         {
            AV185LiqRelNro = (int)(localUtil.ctol( httpContext.cgiGet( edtavLiqrelnro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV185LiqRelNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV185LiqRelNro), 8, 0));
         }
         A1729PeriodoLiq = localUtil.ctod( httpContext.cgiGet( edtPeriodoLiq_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1729PeriodoLiq", localUtil.format(A1729PeriodoLiq, "99/99/99"));
         AV17DDO_LiqFechaAuxDateText = httpContext.cgiGet( edtavDdo_liqfechaauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17DDO_LiqFechaAuxDateText", AV17DDO_LiqFechaAuxDateText);
         AV20DDO_LiqFecPagoAuxDateText = httpContext.cgiGet( edtavDdo_liqfecpagoauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20DDO_LiqFecPagoAuxDateText", AV20DDO_LiqFecPagoAuxDateText);
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
      e252M2 ();
      if (returnInSub) return;
   }

   public void e252M2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV161cerear = true ;
      AV137cuantas = (short)(12) ;
      AV147mesDesde = (short)(1) ;
      AV149hoy = GXutil.serverDate( context, remoteHandle, pr_default) ;
      AV146anioTest = (short)(GXutil.year( AV149hoy)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV231Pgmname, httpContext.getMessage( "&MenuOpcCod ", "")+AV176MenuOpcCod) ;
      GXt_int1 = AV27EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      liquidacionww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV27EmpCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27EmpCod), 4, 0));
      GXt_int3 = AV7CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      liquidacionww_impl.this.GXt_int3 = GXv_int4[0] ;
      AV7CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      this.executeUsercontrolMethod(sPrefix, false, "TFLIQFECPAGO_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_liqfecpagoauxdatetext_Internalname});
      this.executeUsercontrolMethod(sPrefix, false, "TFLIQFECHA_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_liqfechaauxdatetext_Internalname});
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, sPrefix, false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, sPrefix, false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      Grid_titlescategories_Gridinternalname = subGrid_Internalname ;
      ucGrid_titlescategories.sendProperty(context, sPrefix, false, Grid_titlescategories_Internalname, "GridInternalName", Grid_titlescategories_Gridinternalname);
      /* Execute user subroutine: 'LOADSAVEDFILTERS' */
      S122 ();
      if (returnInSub) return;
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      edtPeriodoLiq_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPeriodoLiq_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPeriodoLiq_Visible), 5, 0), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S142 ();
      if (returnInSub) return;
      if ( AV41OrderedBy < 1 )
      {
         AV41OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S152 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = AV25DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] ;
      AV25DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, sPrefix, false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      AV211observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV211observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, sPrefix, false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, sPrefix, false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, sPrefix, false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      GXv_char7[0] = AV168ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, new web.modotest_codigoparam(remoteHandle, context).executeUdp( ), GXv_char7) ;
      liquidacionww_impl.this.AV168ParmValue = GXv_char7[0] ;
      AV167modoTestEs = GXutil.boolval( AV168ParmValue) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV231Pgmname, httpContext.getMessage( "&ServerSocket.ClientId ", "")+GXutil.trim( AV186ServerSocket.getgxTv_SdtSocket_Clientid())) ;
      AV211observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV211observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, sPrefix, false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, sPrefix, false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "W0068DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, sPrefix, false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
   }

   public void e262M2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV27EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      liquidacionww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV27EmpCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27EmpCod), 4, 0));
      GXt_int3 = AV7CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      liquidacionww_impl.this.GXt_int3 = GXv_int4[0] ;
      AV7CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      GXv_SdtWWPContext8[0] = AV88WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext8) ;
      AV88WWPContext = GXv_SdtWWPContext8[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S162 ();
      if (returnInSub) return;
      if ( AV123ManageFiltersExecutionStep == 1 )
      {
         AV123ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV123ManageFiltersExecutionStep", GXutil.str( AV123ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV123ManageFiltersExecutionStep == 2 )
      {
         AV123ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV123ManageFiltersExecutionStep", GXutil.str( AV123ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S122 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S172 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV47Session.getValue("LiquidacionWWColumnsSelector"), "") != 0 )
      {
         AV11ColumnsSelectorXML = AV47Session.getValue("LiquidacionWWColumnsSelector") ;
         AV9ColumnsSelector.fromxml(AV11ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S182 ();
         if (returnInSub) return;
      }
      edtLiqNro_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqNro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqNro_Visible), 5, 0), !bGXsfl_70_Refreshing);
      edtLiqNombre_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqNombre_Visible), 5, 0), !bGXsfl_70_Refreshing);
      edtLiqFecha_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqFecha_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqFecha_Visible), 5, 0), !bGXsfl_70_Refreshing);
      edtLiqPerPalabra_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqPerPalabra_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqPerPalabra_Visible), 5, 0), !bGXsfl_70_Refreshing);
      edtLiqFecPago_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqFecPago_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqFecPago_Visible), 5, 0), !bGXsfl_70_Refreshing);
      edtTLiqDescAux_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtTLiqDescAux_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTLiqDescAux_Visible), 5, 0), !bGXsfl_70_Refreshing);
      cmbLiqModTra.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqModTra.getInternalname(), "Visible", GXutil.ltrimstr( cmbLiqModTra.getVisible(), 5, 0), !bGXsfl_70_Refreshing);
      cmbLiqFrecPag.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqFrecPag.getInternalname(), "Visible", GXutil.ltrimstr( cmbLiqFrecPag.getVisible(), 5, 0), !bGXsfl_70_Refreshing);
      edtLiqCntLeg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqCntLeg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqCntLeg_Visible), 5, 0), !bGXsfl_70_Refreshing);
      edtavEstadoprin_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadoprin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadoprin_Visible), 5, 0), !bGXsfl_70_Refreshing);
      edtavEstadopdf_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadopdf_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadopdf_Visible), 5, 0), !bGXsfl_70_Refreshing);
      edtavEstadolsddep_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadolsddep_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadolsddep_Visible), 5, 0), !bGXsfl_70_Refreshing);
      edtavEstadocontr_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadocontr_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadocontr_Visible), 5, 0), !bGXsfl_70_Refreshing);
      edtavEstadoauxfut_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadoauxfut_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadoauxfut_Visible), 5, 0), !bGXsfl_70_Refreshing);
      edtLiqError_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqError_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqError_Visible), 5, 0), !bGXsfl_70_Refreshing);
      edtLiqDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDescrip_Visible), 5, 0), !bGXsfl_70_Refreshing);
      edtLiqImpBruto_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqImpBruto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqImpBruto_Visible), 5, 0), !bGXsfl_70_Refreshing);
      edtLiqImpNeto_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqImpNeto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqImpNeto_Visible), 5, 0), !bGXsfl_70_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_70_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV9ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_70_Refreshing);
      AV33GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33GridCurrentPage), 10, 0));
      AV34GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34GridPageCount), 10, 0));
      GXt_char9 = AV32GridAppliedFilters ;
      GXv_char7[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV231Pgmname, GXv_char7) ;
      liquidacionww_impl.this.GXt_char9 = GXv_char7[0] ;
      AV32GridAppliedFilters = GXt_char9 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32GridAppliedFilters", AV32GridAppliedFilters);
      GXt_char9 = AV210MenuOpcTitulo ;
      GXv_char7[0] = GXt_char9 ;
      new web.gettxtcount(remoteHandle, context).execute( AV176MenuOpcCod, GXv_char7) ;
      liquidacionww_impl.this.GXt_char9 = GXv_char7[0] ;
      AV210MenuOpcTitulo = GXt_char9 ;
      if ( (GXutil.strcmp("", AV210MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV210MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int2[0] = (short)(AV213filterCount) ;
      GXv_char7[0] = AV214filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV35GridState, GXv_int2, GXv_char7) ;
      liquidacionww_impl.this.AV213filterCount = GXv_int2[0] ;
      liquidacionww_impl.this.AV214filtrosTexto = GXv_char7[0] ;
      if ( AV213filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV213filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV214filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV232Liquidacionwwds_1_periodoliq = AV162PeriodoLiq ;
      AV233Liquidacionwwds_2_liqrelnro = AV185LiqRelNro ;
      AV234Liquidacionwwds_3_tfliqnro = AV74TFLiqNro ;
      AV235Liquidacionwwds_4_tfliqnro_to = AV75TFLiqNro_To ;
      AV236Liquidacionwwds_5_tfliqnombre = AV139TFLiqNombre ;
      AV237Liquidacionwwds_6_tfliqnombre_sel = AV141TFLiqNombre_Sel ;
      AV238Liquidacionwwds_7_tfliqfecha = AV66TFLiqFecha ;
      AV239Liquidacionwwds_8_tfliqfecha_to = AV67TFLiqFecha_To ;
      AV240Liquidacionwwds_9_tfliqperpalabra = AV113TFLiqPerPalabra ;
      AV241Liquidacionwwds_10_tfliqperpalabra_sels = AV114TFLiqPerPalabra_Sels ;
      AV242Liquidacionwwds_11_tfliqfecpago = AV68TFLiqFecPago ;
      AV243Liquidacionwwds_12_tfliqfecpago_to = AV69TFLiqFecPago_To ;
      AV244Liquidacionwwds_13_tftliqdescaux = AV216TFTLiqDescAux ;
      AV245Liquidacionwwds_14_tftliqdescaux_sels = AV217TFTLiqDescAux_Sels ;
      AV246Liquidacionwwds_15_tfliqmodtra_sels = AV226TFLiqModTra_Sels ;
      AV247Liquidacionwwds_16_tfliqfrecpag_sels = AV228TFLiqFrecPag_Sels ;
      AV248Liquidacionwwds_17_tfliqcntleg = AV56TFLiqCntLeg ;
      AV249Liquidacionwwds_18_tfliqcntleg_to = AV57TFLiqCntLeg_To ;
      AV250Liquidacionwwds_19_tfliqerror = AV119TFLiqError ;
      AV251Liquidacionwwds_20_tfliqerror_sels = AV120TFLiqError_Sels ;
      AV252Liquidacionwwds_21_tfliqdescrip = AV58TFLiqDescrip ;
      AV253Liquidacionwwds_22_tfliqdescrip_sels = AV60TFLiqDescrip_Sels ;
      AV254Liquidacionwwds_23_tfliqimpbruto = AV70TFLiqImpBruto ;
      AV255Liquidacionwwds_24_tfliqimpbruto_to = AV71TFLiqImpBruto_To ;
      AV256Liquidacionwwds_25_tfliqimpneto = AV72TFLiqImpNeto ;
      AV257Liquidacionwwds_26_tfliqimpneto_to = AV73TFLiqImpNeto_To ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV9ColumnsSelector", AV9ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV121ManageFiltersData", AV121ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV35GridState", AV35GridState);
   }

   public void e132M2( )
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
         AV44PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV44PageToGo) ;
      }
   }

   public void e142M2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e152M2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV41OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41OrderedBy), 4, 0));
         AV43OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43OrderedDsc", AV43OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S152 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqNro") == 0 )
         {
            AV74TFLiqNro = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV74TFLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV74TFLiqNro), 8, 0));
            AV75TFLiqNro_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV75TFLiqNro_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV75TFLiqNro_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqNombre") == 0 )
         {
            AV139TFLiqNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV139TFLiqNombre", AV139TFLiqNombre);
            AV141TFLiqNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV141TFLiqNombre_Sel", AV141TFLiqNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqFecha") == 0 )
         {
            AV66TFLiqFecha = localUtil.ctod( Ddo_grid_Filteredtext_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66TFLiqFecha", localUtil.format(AV66TFLiqFecha, "99/99/9999"));
            AV67TFLiqFecha_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67TFLiqFecha_To", localUtil.format(AV67TFLiqFecha_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqPerPalabra") == 0 )
         {
            AV113TFLiqPerPalabra = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV113TFLiqPerPalabra", AV113TFLiqPerPalabra);
            AV112TFLiqPerPalabra_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV112TFLiqPerPalabra_SelsJson", AV112TFLiqPerPalabra_SelsJson);
            AV114TFLiqPerPalabra_Sels.fromJSonString(AV112TFLiqPerPalabra_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqFecPago") == 0 )
         {
            AV68TFLiqFecPago = localUtil.ctod( Ddo_grid_Filteredtext_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68TFLiqFecPago", localUtil.format(AV68TFLiqFecPago, "99/99/9999"));
            AV69TFLiqFecPago_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV69TFLiqFecPago_To", localUtil.format(AV69TFLiqFecPago_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "TLiqDescAux") == 0 )
         {
            AV216TFTLiqDescAux = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV216TFTLiqDescAux", AV216TFTLiqDescAux);
            AV215TFTLiqDescAux_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV215TFTLiqDescAux_SelsJson", AV215TFTLiqDescAux_SelsJson);
            AV217TFTLiqDescAux_Sels.fromJSonString(AV215TFTLiqDescAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqModTra") == 0 )
         {
            AV225TFLiqModTra_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV225TFLiqModTra_SelsJson", AV225TFLiqModTra_SelsJson);
            AV226TFLiqModTra_Sels.fromJSonString(AV225TFLiqModTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqFrecPag") == 0 )
         {
            AV227TFLiqFrecPag_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV227TFLiqFrecPag_SelsJson", AV227TFLiqFrecPag_SelsJson);
            AV228TFLiqFrecPag_Sels.fromJSonString(GXutil.strReplace( AV227TFLiqFrecPag_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqCntLeg") == 0 )
         {
            AV56TFLiqCntLeg = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV56TFLiqCntLeg", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56TFLiqCntLeg), 4, 0));
            AV57TFLiqCntLeg_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV57TFLiqCntLeg_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFLiqCntLeg_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqError") == 0 )
         {
            AV119TFLiqError = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV119TFLiqError", AV119TFLiqError);
            AV118TFLiqError_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV118TFLiqError_SelsJson", AV118TFLiqError_SelsJson);
            AV120TFLiqError_Sels.fromJSonString(AV118TFLiqError_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqDescrip") == 0 )
         {
            AV58TFLiqDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58TFLiqDescrip", AV58TFLiqDescrip);
            AV61TFLiqDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV61TFLiqDescrip_SelsJson", AV61TFLiqDescrip_SelsJson);
            AV60TFLiqDescrip_Sels.fromJSonString(AV61TFLiqDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqImpBruto") == 0 )
         {
            AV70TFLiqImpBruto = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70TFLiqImpBruto", GXutil.ltrimstr( AV70TFLiqImpBruto, 14, 2));
            AV71TFLiqImpBruto_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV71TFLiqImpBruto_To", GXutil.ltrimstr( AV71TFLiqImpBruto_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqImpNeto") == 0 )
         {
            AV72TFLiqImpNeto = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV72TFLiqImpNeto", GXutil.ltrimstr( AV72TFLiqImpNeto, 14, 2));
            AV73TFLiqImpNeto_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV73TFLiqImpNeto_To", GXutil.ltrimstr( AV73TFLiqImpNeto_To, 14, 2));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV60TFLiqDescrip_Sels", AV60TFLiqDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV120TFLiqError_Sels", AV120TFLiqError_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV228TFLiqFrecPag_Sels", AV228TFLiqFrecPag_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV226TFLiqModTra_Sels", AV226TFLiqModTra_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV217TFTLiqDescAux_Sels", AV217TFTLiqDescAux_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV114TFLiqPerPalabra_Sels", AV114TFLiqPerPalabra_Sels);
   }

   private void e272M2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV45ProximaAccion = "<i class=\"fas fa-file-pdf fas fa-file-pdf\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavProximaaccion_Internalname, AV45ProximaAccion);
      if ( false )
      {
         edtavProximaaccion_Class = "Attribute" ;
      }
      else
      {
         edtavProximaaccion_Class = "Invisible" ;
      }
      cmbavGridactions.removeAllItems();
      cmbavGridactions.addItem("0", ";fa fa-bars", (short)(0));
      if ( A278LiqEstado != 4 )
      {
         cmbavGridactions.addItem("1", GXutil.format( "%1;%2", httpContext.getMessage( "Eliminar", ""), "fas fa-times fas fa-times", "", "", "", "", "", "", ""), (short)(0));
      }
      if ( ( ( A278LiqEstado == 3 ) || ( A278LiqEstado == 2 ) ) && GXutil.dateCompare(GXutil.nullDate(), A719LiqFecImp) )
      {
         cmbavGridactions.addItem("2", GXutil.format( "%1;%2", httpContext.getMessage( "Re-Liquidar", ""), "fas fa-cash-register fas fa-cash-register", "", "", "", "", "", "", ""), (short)(0));
      }
      if ( ( A278LiqEstado != 1 ) && ( A278LiqEstado != 4 ) && GXutil.dateCompare(GXutil.nullDate(), A719LiqFecImp) )
      {
         cmbavGridactions.addItem("3", GXutil.format( "%1;%2", httpContext.getMessage( "Cerrar Liquidación", ""), "fas fa-lock-open fas fa-lock-open", "", "", "", "", "", "", ""), (short)(0));
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), A719LiqFecImp) )
      {
         cmbavGridactions.addItem("4", GXutil.format( "%1;%2", httpContext.getMessage( "Generar Archivo de Interbanking", ""), "fas fa-credit-card fas fa-credit-card", "", "", "", "", "", "", ""), (short)(0));
      }
      if ( A278LiqEstado == 4 )
      {
         cmbavGridactions.addItem("5", GXutil.format( "%1;%2", httpContext.getMessage( "Re-Abrir Liquidación", ""), "fas fa-undo fas fa-undo", "", "", "", "", "", "", ""), (short)(0));
      }
      if ( ( A278LiqEstado == 0 ) || ( A278LiqEstado == 1 ) || ( A1403LiqAuxEstado == 0 ) || ( A1403LiqAuxEstado == 1 ) || ( GXutil.strcmp(A2180LiqPDFEstado, "EnEspera") == 0 ) || ( GXutil.strcmp(A2180LiqPDFEstado, "Pendiente") == 0 ) || ( A2292LiqLSDDepEst == 0 ) || ( A2292LiqLSDDepEst == 1 ) || ( A2293LiqContrEst == 0 ) || ( A2293LiqContrEst == 1 ) )
      {
         cmbavGridactions.addItem("6", GXutil.format( "%1;%2", httpContext.getMessage( "Cancelar", ""), "fas fa-ban fas fa-ban", "", "", "", "", "", "", ""), (short)(0));
      }
      if ( cmbavGridactions.getItemCount() == 1 )
      {
         cmbavGridactions.setThemeClass( "Invisible" );
      }
      else
      {
         cmbavGridactions.setThemeClass( "ConvertToDDO" );
      }
      AV175Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplay_Internalname, AV175Display);
      edtavDisplay_Link = formatLink("web.liquidacionview", new String[] {GXutil.URLEncode(GXutil.rtrim(AV176MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A31LiqNro,8,0)),GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "LiquidacionLegajo", "")))}, new String[] {"auxMenuOpcCod","CliCod","EmpCod","LiqNro","TabCode"})  ;
      AV102Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavUpdate_Internalname, AV102Update);
      if ( AV39IsAuthorized_Update )
      {
         GXt_date10 = GXutil.nullDate() ;
         GXv_date11[0] = GXt_date10 ;
         new web.ultimoperiodo(remoteHandle, context).execute( A3CliCod, A1EmpCod, GXv_date11) ;
         liquidacionww_impl.this.GXt_date10 = GXv_date11[0] ;
         AV48TempBoolean = (boolean)((A278LiqEstado!=4)&&GXutil.dateCompare(GXutil.resetTime(A283LiqPeriodo), GXutil.resetTime(GXt_date10))&&GXutil.dateCompare(GXutil.nullDate(), A719LiqFecImp)) ;
         if ( AV48TempBoolean )
         {
            edtavUpdate_Link = formatLink("web.liquidacion_", new String[] {GXutil.URLEncode(GXutil.rtrim(AV176MenuOpcCod)),GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "UPD", ""))),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A31LiqNro,8,0))}, new String[] {"MenuOpcCod","Modo","CliCod","EmpCod","LiqNro"})  ;
            edtavUpdate_Class = "Attribute" ;
         }
         else
         {
            edtavUpdate_Link = "" ;
            edtavUpdate_Class = "Invisible" ;
         }
      }
      edtavVersvg_Format = (short)(1) ;
      GXt_char9 = AV173VerSVG ;
      GXv_char7[0] = GXt_char9 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
      liquidacionww_impl.this.GXt_char9 = GXv_char7[0] ;
      AV173VerSVG = GXt_char9 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavVersvg_Internalname, AV173VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtLiqNombre_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char9 = AV174ModificarSVG ;
      GXv_char7[0] = GXt_char9 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char7) ;
      liquidacionww_impl.this.GXt_char9 = GXv_char7[0] ;
      AV174ModificarSVG = GXt_char9 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavModificarsvg_Internalname, AV174ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      if ( ( A278LiqEstado == 1 ) || ( A278LiqEstado == 2 ) )
      {
         edtavProximaaccion_Visible = 0 ;
      }
      else if ( A278LiqEstado == 3 )
      {
         edtavProximaaccion_Tooltiptext = httpContext.getMessage( "Cerrar Liquidación", "") ;
         AV45ProximaAccion = "<i class=\"fas fa-lock-open fas fa-lock-open\"></i>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavProximaaccion_Internalname, AV45ProximaAccion);
      }
      else
      {
         if ( ! A361LiqGenInter )
         {
            edtavProximaaccion_Tooltiptext = httpContext.getMessage( "Generar Archivo de Interbanking", "") ;
            AV45ProximaAccion = "<i class=\"fas fa-credit-card fas fa-credit-card\"></i>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavProximaaccion_Internalname, AV45ProximaAccion);
         }
         else
         {
            edtavProximaaccion_Tooltiptext = "" ;
            AV45ProximaAccion = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavProximaaccion_Internalname, AV45ProximaAccion);
         }
      }
      AV194EstadoPrin = GXutil.trim( httpContext.getMessage( web.gxdomainliquidacionestado.getDescription(httpContext,(byte)A278LiqEstado), "")) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadoprin_Internalname, AV194EstadoPrin);
      if ( GXutil.strcmp(AV194EstadoPrin, httpContext.getMessage( "Cerrada", "")) == 0 )
      {
         AV201EstadoLSDDep = httpContext.getMessage( "Cerrada", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadolsddep_Internalname, AV201EstadoLSDDep);
      }
      else
      {
         AV201EstadoLSDDep = GXutil.trim( httpContext.getMessage( web.gxdomainliquidacionestado.getDescription(httpContext,(byte)A2292LiqLSDDepEst), "")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadolsddep_Internalname, AV201EstadoLSDDep);
      }
      if ( GXutil.strcmp(AV194EstadoPrin, httpContext.getMessage( "Cerrada", "")) == 0 )
      {
         AV202EstadoContr = httpContext.getMessage( "Cerrada", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadocontr_Internalname, AV202EstadoContr);
      }
      else
      {
         AV202EstadoContr = GXutil.trim( httpContext.getMessage( web.gxdomainliquidacionestado.getDescription(httpContext,(byte)A2293LiqContrEst), "")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadocontr_Internalname, AV202EstadoContr);
      }
      if ( GXutil.strcmp(AV194EstadoPrin, httpContext.getMessage( "Cerrada", "")) == 0 )
      {
         AV203EstadoPDF = httpContext.getMessage( "Cerrada", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadopdf_Internalname, AV203EstadoPDF);
      }
      else
      {
         AV203EstadoPDF = GXutil.trim( httpContext.getMessage( web.gxdomainpdfestado.getDescription(httpContext,(String)A2180LiqPDFEstado), "")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadopdf_Internalname, AV203EstadoPDF);
      }
      if ( GXutil.strcmp(AV194EstadoPrin, httpContext.getMessage( "Cerrada", "")) == 0 )
      {
         AV204EstadoAuxFut = httpContext.getMessage( "Cerrada", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadoauxfut_Internalname, AV204EstadoAuxFut);
      }
      else
      {
         AV204EstadoAuxFut = GXutil.trim( httpContext.getMessage( web.gxdomainliquidacionestado.getDescription(httpContext,(byte)A1403LiqAuxEstado), "")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadoauxfut_Internalname, AV204EstadoAuxFut);
      }
      edtavEstadoprin_Tooltiptext = GXutil.trim( A766LiqError) ;
      if ( GXutil.strcmp(A2180LiqPDFEstado, "Error") == 0 )
      {
         GXt_char9 = "" ;
         GXv_char7[0] = GXt_char9 ;
         new web.getliqbatcherror(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, httpContext.getMessage( "GENERACION_PDFS", ""), GXv_char7) ;
         liquidacionww_impl.this.GXt_char9 = GXv_char7[0] ;
         edtavEstadopdf_Tooltiptext = GXt_char9 ;
      }
      else
      {
         edtavEstadopdf_Tooltiptext = "" ;
      }
      if ( A2292LiqLSDDepEst == 2 )
      {
         GXt_char9 = "" ;
         GXv_char7[0] = GXt_char9 ;
         new web.getliqbatcherror(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, httpContext.getMessage( "DEPENDENCIAS_LSD", ""), GXv_char7) ;
         liquidacionww_impl.this.GXt_char9 = GXv_char7[0] ;
         edtavEstadolsddep_Tooltiptext = GXt_char9 ;
      }
      else
      {
         edtavEstadolsddep_Tooltiptext = "" ;
      }
      if ( A2293LiqContrEst == 2 )
      {
         GXt_char9 = "" ;
         GXv_char7[0] = GXt_char9 ;
         new web.getliqbatcherror(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, httpContext.getMessage( "CONTRIBUCIONES", ""), GXv_char7) ;
         liquidacionww_impl.this.GXt_char9 = GXv_char7[0] ;
         edtavEstadocontr_Tooltiptext = GXt_char9 ;
      }
      else
      {
         edtavEstadocontr_Tooltiptext = "" ;
      }
      if ( A1403LiqAuxEstado == 2 )
      {
         GXt_char9 = "" ;
         GXv_char7[0] = GXt_char9 ;
         new web.getliqbatcherror(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, httpContext.getMessage( "OTROS", ""), GXv_char7) ;
         liquidacionww_impl.this.GXt_char9 = GXv_char7[0] ;
         edtavEstadoauxfut_Tooltiptext = GXt_char9 ;
      }
      else
      {
         edtavEstadoauxfut_Tooltiptext = "" ;
      }
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(70) ;
      }
      sendrow_702( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_70_Refreshing )
      {
         httpContext.doAjaxLoad(70, GridRow);
      }
      /*  Sending Event outputs  */
      cmbavGridactions.setValue( GXutil.trim( GXutil.str( AV31GridActions, 4, 0)) );
   }

   public void e112M2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV11ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV9ColumnsSelector.fromJSonString(AV11ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "LiquidacionWWColumnsSelector", ((GXutil.strcmp("", AV11ColumnsSelectorXML)==0) ? "" : AV9ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefreshCmp(sPrefix);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV9ColumnsSelector", AV9ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV121ManageFiltersData", AV121ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV35GridState", AV35GridState);
   }

   public void e122M2( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("LiquidacionWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV231Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV123ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV123ManageFiltersExecutionStep", GXutil.str( AV123ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefreshCmp(sPrefix);
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("LiquidacionWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV123ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV123ManageFiltersExecutionStep", GXutil.str( AV123ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefreshCmp(sPrefix);
      }
      else
      {
         GXt_char9 = AV122ManageFiltersXml ;
         GXv_char7[0] = GXt_char9 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "LiquidacionWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         liquidacionww_impl.this.GXt_char9 = GXv_char7[0] ;
         AV122ManageFiltersXml = GXt_char9 ;
         if ( (GXutil.strcmp("", AV122ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S192 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV231Pgmname+"GridState", AV122ManageFiltersXml) ;
            AV35GridState.fromxml(AV122ManageFiltersXml, null, null);
            AV41OrderedBy = AV35GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41OrderedBy), 4, 0));
            AV43OrderedDsc = AV35GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43OrderedDsc", AV43OrderedDsc);
            /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
            S152 ();
            if (returnInSub) return;
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S202 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV35GridState", AV35GridState);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV114TFLiqPerPalabra_Sels", AV114TFLiqPerPalabra_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV217TFTLiqDescAux_Sels", AV217TFTLiqDescAux_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV226TFLiqModTra_Sels", AV226TFLiqModTra_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV228TFLiqFrecPag_Sels", AV228TFLiqFrecPag_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV120TFLiqError_Sels", AV120TFLiqError_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV60TFLiqDescrip_Sels", AV60TFLiqDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV9ColumnsSelector", AV9ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV121ManageFiltersData", AV121ManageFiltersData);
   }

   public void e282M2( )
   {
      /* Proximaaccion_Click Routine */
      returnInSub = false ;
      if ( ! A361LiqGenInter && ( A278LiqEstado == 4 ) )
      {
         new web.generarinterbanking(remoteHandle, context).execute( A1EmpCod, A31LiqNro) ;
         gxgrgrid_refresh( subGrid_Rows, AV123ManageFiltersExecutionStep, AV9ColumnsSelector, AV231Pgmname, AV176MenuOpcCod, AV35GridState, AV162PeriodoLiq, AV185LiqRelNro, AV74TFLiqNro, AV75TFLiqNro_To, AV139TFLiqNombre, AV141TFLiqNombre_Sel, AV66TFLiqFecha, AV67TFLiqFecha_To, AV113TFLiqPerPalabra, AV114TFLiqPerPalabra_Sels, AV68TFLiqFecPago, AV69TFLiqFecPago_To, AV216TFTLiqDescAux, AV217TFTLiqDescAux_Sels, AV226TFLiqModTra_Sels, AV228TFLiqFrecPag_Sels, AV56TFLiqCntLeg, AV57TFLiqCntLeg_To, AV119TFLiqError, AV120TFLiqError_Sels, AV58TFLiqDescrip, AV60TFLiqDescrip_Sels, AV70TFLiqImpBruto, AV71TFLiqImpBruto_To, AV72TFLiqImpNeto, AV73TFLiqImpNeto_To, AV41OrderedBy, AV43OrderedDsc, AV7CliCod, AV39IsAuthorized_Update, AV27EmpCod, AV189collectionLegNumero, A3CliCod, A283LiqPeriodo, A719LiqFecImp, A361LiqGenInter, sPrefix) ;
      }
      else
      {
         if ( A278LiqEstado == 3 )
         {
            Dvelop_confirmpanel_proximaaccion_Title = httpContext.getMessage( "Cerrar Liquidación", "") ;
            ucDvelop_confirmpanel_proximaaccion.sendProperty(context, sPrefix, false, Dvelop_confirmpanel_proximaaccion_Internalname, "Title", Dvelop_confirmpanel_proximaaccion_Title);
            Dvelop_confirmpanel_proximaaccion_Confirmationtext = httpContext.getMessage( "¿Está seguro que desea cerrar la liquidación?", "") ;
            ucDvelop_confirmpanel_proximaaccion.sendProperty(context, sPrefix, false, Dvelop_confirmpanel_proximaaccion_Internalname, "ConfirmationText", Dvelop_confirmpanel_proximaaccion_Confirmationtext);
         }
         else
         {
            Dvelop_confirmpanel_proximaaccion_Title = httpContext.getMessage( "Re-Liquidar", "") ;
            ucDvelop_confirmpanel_proximaaccion.sendProperty(context, sPrefix, false, Dvelop_confirmpanel_proximaaccion_Internalname, "Title", Dvelop_confirmpanel_proximaaccion_Title);
            Dvelop_confirmpanel_proximaaccion_Confirmationtext = httpContext.getMessage( "¿Está seguro que desea Re-Liquidar?", "") ;
            ucDvelop_confirmpanel_proximaaccion.sendProperty(context, sPrefix, false, Dvelop_confirmpanel_proximaaccion_Internalname, "ConfirmationText", Dvelop_confirmpanel_proximaaccion_Confirmationtext);
         }
         AV8CliCod_Selected = A3CliCod ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod_Selected), 6, 0));
         AV28EmpCod_Selected = A1EmpCod ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28EmpCod_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28EmpCod_Selected), 4, 0));
         AV40LiqNro_Selected = A31LiqNro ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40LiqNro_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40LiqNro_Selected), 8, 0));
         this.executeUsercontrolMethod(sPrefix, false, "DVELOP_CONFIRMPANEL_PROXIMAACCIONContainer", "Confirm", "", new Object[] {});
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV9ColumnsSelector", AV9ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV121ManageFiltersData", AV121ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV35GridState", AV35GridState);
   }

   public void e162M2( )
   {
      /* Dvelop_confirmpanel_proximaaccion_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_proximaaccion_Result, "Yes") == 0 )
      {
         /* Execute user subroutine: 'DO PROXIMAACCION' */
         S212 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV9ColumnsSelector", AV9ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV121ManageFiltersData", AV121ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV35GridState", AV35GridState);
   }

   public void e292M2( )
   {
      /* Gridactions_Click Routine */
      returnInSub = false ;
      if ( AV31GridActions == 1 )
      {
         /* Execute user subroutine: 'DO ELIMINAR' */
         S222 ();
         if (returnInSub) return;
      }
      else if ( AV31GridActions == 2 )
      {
         /* Execute user subroutine: 'DO RELIQUIDAR' */
         S232 ();
         if (returnInSub) return;
      }
      else if ( AV31GridActions == 3 )
      {
         /* Execute user subroutine: 'DO CERRAR' */
         S242 ();
         if (returnInSub) return;
      }
      else if ( AV31GridActions == 4 )
      {
         /* Execute user subroutine: 'DO GENERARINTERBANKING' */
         S252 ();
         if (returnInSub) return;
      }
      else if ( AV31GridActions == 5 )
      {
         /* Execute user subroutine: 'DO REABRIR' */
         S262 ();
         if (returnInSub) return;
      }
      else if ( AV31GridActions == 6 )
      {
         /* Execute user subroutine: 'DO CANCELAR' */
         S272 ();
         if (returnInSub) return;
      }
      AV31GridActions = (short)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, cmbavGridactions.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31GridActions), 4, 0));
      /*  Sending Event outputs  */
      cmbavGridactions.setValue( GXutil.trim( GXutil.str( AV31GridActions, 4, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavGridactions.getInternalname(), "Values", cmbavGridactions.ToJavascriptSource(), true);
   }

   public void e172M2( )
   {
      /* Dvelop_confirmpanel_eliminar_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_eliminar_Result, "Yes") == 0 )
      {
         /* Execute user subroutine: 'DO ACTION ELIMINAR' */
         S282 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV9ColumnsSelector", AV9ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV121ManageFiltersData", AV121ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV35GridState", AV35GridState);
   }

   public void e182M2( )
   {
      /* Dvelop_confirmpanel_reliquidar_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_reliquidar_Result, "Yes") == 0 )
      {
         /* Execute user subroutine: 'DO ACTION RELIQUIDAR' */
         S292 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV9ColumnsSelector", AV9ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV121ManageFiltersData", AV121ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV35GridState", AV35GridState);
   }

   public void e192M2( )
   {
      /* Dvelop_confirmpanel_cerrar_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_cerrar_Result, "Yes") == 0 )
      {
         /* Execute user subroutine: 'DO ACTION CERRAR' */
         S302 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV9ColumnsSelector", AV9ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV121ManageFiltersData", AV121ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV35GridState", AV35GridState);
   }

   public void e202M2( )
   {
      /* Dvelop_confirmpanel_reabrir_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_reabrir_Result, "Yes") == 0 )
      {
         /* Execute user subroutine: 'DO ACTION REABRIR' */
         S312 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV9ColumnsSelector", AV9ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV121ManageFiltersData", AV121ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV35GridState", AV35GridState);
   }

   public void e212M2( )
   {
      /* Dvelop_confirmpanel_cancelar_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_cancelar_Result, "Yes") == 0 )
      {
         /* Execute user subroutine: 'DO ACTION CANCELAR' */
         S322 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV9ColumnsSelector", AV9ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV121ManageFiltersData", AV121ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV35GridState", AV35GridState);
   }

   public void e222M2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      AV163websession.setValue(httpContext.getMessage( "&LiqPerAno", ""), GXutil.trim( GXutil.str( GXutil.year( AV162PeriodoLiq), 10, 0)));
      AV163websession.setValue(httpContext.getMessage( "&LiqPerMes", ""), GXutil.trim( GXutil.str( GXutil.month( AV162PeriodoLiq), 10, 0)));
      callWebObject(formatLink("web.liquidacion_", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "LiquidaciónABM", ""))),GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "INS", ""))),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV27EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"MenuOpcCod","Modo","CliCod","EmpCod","LiqNro"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
      /*  Sending Event outputs  */
   }

   public void e232M2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV30ExcelFilename ;
      GXv_char12[0] = AV29ErrorMessage ;
      new web.liquidacionwwexport(remoteHandle, context).execute( GXv_char7, GXv_char12) ;
      liquidacionww_impl.this.AV30ExcelFilename = GXv_char7[0] ;
      liquidacionww_impl.this.AV29ErrorMessage = GXv_char12[0] ;
      if ( GXutil.strcmp(AV30ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV30ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV29ErrorMessage);
      }
   }

   public void S152( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV41OrderedBy, 4, 0))+":"+(AV43OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S182( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV9ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "LiqNro", "", "Número", false, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "LiqNombre", "", "Descripción", true, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "LiqFecha", "", "Fecha de liq.", false, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "LiqPerPalabra", "", "Periodo", true, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "LiqFecPago", "", "Fecha de pago", false, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "TLiqDescAux", "", "Tipo", true, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "LiqModTra", "", "Relación laboral", false, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "LiqFrecPag", "", "Frecuencia de pago", false, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "LiqCntLeg", "", "Cantidad de recibos", false, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&EstadoPrin", "Estado", "Recibos", true, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&EstadoPDF", "Estado", "PDFs", true, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&EstadoLSDDep", "Estado", "Dep. LSD", false, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&EstadoContr", "Estado", "Contr.", false, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&EstadoAuxFut", "Estado", "Otros conceptos aux.", false, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "LiqError", "", "Error", false, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "LiqDescrip", "", "Observación", false, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "LiqImpBruto", "", "Bruto", false, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "LiqImpNeto", "", "Neto", false, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&VerSVG", "", "", true, "") ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      if ( ( A278LiqEstado != 4 ) && GXutil.dateCompare(GXutil.resetTime(A283LiqPeriodo), GXutil.resetTime(new web.ultimoperiodo(remoteHandle, context).executeUdp( A3CliCod, A1EmpCod))) && GXutil.dateCompare(GXutil.nullDate(), A719LiqFecImp) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&ModificarSVG", "", "", true, "") ;
         AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector13[0] = AV9ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "", "", "", false, "") ;
         AV9ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      }
      GXt_char9 = AV87UserCustomValue ;
      GXv_char12[0] = GXt_char9 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "LiquidacionWWColumnsSelector", GXv_char12) ;
      liquidacionww_impl.this.GXt_char9 = GXv_char12[0] ;
      AV87UserCustomValue = GXt_char9 ;
      if ( ! ( (GXutil.strcmp("", AV87UserCustomValue)==0) ) )
      {
         AV10ColumnsSelectorAux.fromxml(AV87UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector13[0] = AV10ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector14[0] = AV9ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, GXv_SdtWWPColumnsSelector14) ;
         AV10ColumnsSelectorAux = GXv_SdtWWPColumnsSelector13[0] ;
         AV9ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      GXv_SdtWWPColumnsSelector14[0] = AV9ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV7CliCod, GXv_SdtWWPColumnsSelector14) ;
      AV9ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
   }

   public void S162( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean15 = AV39IsAuthorized_Update ;
      GXv_boolean16[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "Liquidacion_", GXv_boolean16) ;
      liquidacionww_impl.this.GXt_boolean15 = GXv_boolean16[0] ;
      AV39IsAuthorized_Update = GXt_boolean15 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39IsAuthorized_Update", AV39IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV39IsAuthorized_Update));
      if ( ! ( AV39IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_70_Refreshing);
      }
      GXt_boolean15 = AV48TempBoolean ;
      GXv_boolean16[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "Liquidacion_", GXv_boolean16) ;
      liquidacionww_impl.this.GXt_boolean15 = GXv_boolean16[0] ;
      AV48TempBoolean = GXt_boolean15 ;
      if ( ! ( AV48TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S122( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = AV121ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "LiquidacionWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18[0] ;
      AV121ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 ;
   }

   public void S192( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV185LiqRelNro = 0 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV185LiqRelNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV185LiqRelNro), 8, 0));
      AV74TFLiqNro = 0 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV74TFLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV74TFLiqNro), 8, 0));
      AV75TFLiqNro_To = 0 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV75TFLiqNro_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV75TFLiqNro_To), 8, 0));
      AV139TFLiqNombre = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV139TFLiqNombre", AV139TFLiqNombre);
      AV141TFLiqNombre_Sel = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV141TFLiqNombre_Sel", AV141TFLiqNombre_Sel);
      AV66TFLiqFecha = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66TFLiqFecha", localUtil.format(AV66TFLiqFecha, "99/99/9999"));
      AV67TFLiqFecha_To = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67TFLiqFecha_To", localUtil.format(AV67TFLiqFecha_To, "99/99/9999"));
      AV113TFLiqPerPalabra = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV113TFLiqPerPalabra", AV113TFLiqPerPalabra);
      AV114TFLiqPerPalabra_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV68TFLiqFecPago = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68TFLiqFecPago", localUtil.format(AV68TFLiqFecPago, "99/99/9999"));
      AV69TFLiqFecPago_To = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV69TFLiqFecPago_To", localUtil.format(AV69TFLiqFecPago_To, "99/99/9999"));
      AV216TFTLiqDescAux = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV216TFTLiqDescAux", AV216TFTLiqDescAux);
      AV217TFTLiqDescAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV226TFLiqModTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV228TFLiqFrecPag_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV56TFLiqCntLeg = (short)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV56TFLiqCntLeg", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56TFLiqCntLeg), 4, 0));
      AV57TFLiqCntLeg_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV57TFLiqCntLeg_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFLiqCntLeg_To), 4, 0));
      AV119TFLiqError = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV119TFLiqError", AV119TFLiqError);
      AV120TFLiqError_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58TFLiqDescrip = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58TFLiqDescrip", AV58TFLiqDescrip);
      AV60TFLiqDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV70TFLiqImpBruto = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70TFLiqImpBruto", GXutil.ltrimstr( AV70TFLiqImpBruto, 14, 2));
      AV71TFLiqImpBruto_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV71TFLiqImpBruto_To", GXutil.ltrimstr( AV71TFLiqImpBruto_To, 14, 2));
      AV72TFLiqImpNeto = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV72TFLiqImpNeto", GXutil.ltrimstr( AV72TFLiqImpNeto, 14, 2));
      AV73TFLiqImpNeto_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV73TFLiqImpNeto_To", GXutil.ltrimstr( AV73TFLiqImpNeto_To, 14, 2));
      Ddo_grid_Selectedvalue_set = "" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      Ddo_grid_Filteredtext_set = "" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S212( )
   {
      /* 'DO PROXIMAACCION' Routine */
      returnInSub = false ;
      if ( A278LiqEstado == 3 )
      {
         new web.setliqestado(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, (byte)(4)) ;
         new web.alert(remoteHandle, context).execute( "success", httpContext.getMessage( "Liquidación cerrada correctamente", "")) ;
         gxgrgrid_refresh( subGrid_Rows, AV123ManageFiltersExecutionStep, AV9ColumnsSelector, AV231Pgmname, AV176MenuOpcCod, AV35GridState, AV162PeriodoLiq, AV185LiqRelNro, AV74TFLiqNro, AV75TFLiqNro_To, AV139TFLiqNombre, AV141TFLiqNombre_Sel, AV66TFLiqFecha, AV67TFLiqFecha_To, AV113TFLiqPerPalabra, AV114TFLiqPerPalabra_Sels, AV68TFLiqFecPago, AV69TFLiqFecPago_To, AV216TFTLiqDescAux, AV217TFTLiqDescAux_Sels, AV226TFLiqModTra_Sels, AV228TFLiqFrecPag_Sels, AV56TFLiqCntLeg, AV57TFLiqCntLeg_To, AV119TFLiqError, AV120TFLiqError_Sels, AV58TFLiqDescrip, AV60TFLiqDescrip_Sels, AV70TFLiqImpBruto, AV71TFLiqImpBruto_To, AV72TFLiqImpNeto, AV73TFLiqImpNeto_To, AV41OrderedBy, AV43OrderedDsc, AV7CliCod, AV39IsAuthorized_Update, AV27EmpCod, AV189collectionLegNumero, A3CliCod, A283LiqPeriodo, A719LiqFecImp, A361LiqGenInter, sPrefix) ;
      }
      else
      {
         new web.resetealiquidacion(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro) ;
         new web.mensajeliquidacion(remoteHandle, context).execute( ) ;
         gxgrgrid_refresh( subGrid_Rows, AV123ManageFiltersExecutionStep, AV9ColumnsSelector, AV231Pgmname, AV176MenuOpcCod, AV35GridState, AV162PeriodoLiq, AV185LiqRelNro, AV74TFLiqNro, AV75TFLiqNro_To, AV139TFLiqNombre, AV141TFLiqNombre_Sel, AV66TFLiqFecha, AV67TFLiqFecha_To, AV113TFLiqPerPalabra, AV114TFLiqPerPalabra_Sels, AV68TFLiqFecPago, AV69TFLiqFecPago_To, AV216TFTLiqDescAux, AV217TFTLiqDescAux_Sels, AV226TFLiqModTra_Sels, AV228TFLiqFrecPag_Sels, AV56TFLiqCntLeg, AV57TFLiqCntLeg_To, AV119TFLiqError, AV120TFLiqError_Sels, AV58TFLiqDescrip, AV60TFLiqDescrip_Sels, AV70TFLiqImpBruto, AV71TFLiqImpBruto_To, AV72TFLiqImpNeto, AV73TFLiqImpNeto_To, AV41OrderedBy, AV43OrderedDsc, AV7CliCod, AV39IsAuthorized_Update, AV27EmpCod, AV189collectionLegNumero, A3CliCod, A283LiqPeriodo, A719LiqFecImp, A361LiqGenInter, sPrefix) ;
      }
   }

   public void S222( )
   {
      /* 'DO ELIMINAR' Routine */
      returnInSub = false ;
      AV8CliCod_Selected = A3CliCod ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod_Selected), 6, 0));
      AV28EmpCod_Selected = A1EmpCod ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28EmpCod_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28EmpCod_Selected), 4, 0));
      AV40LiqNro_Selected = A31LiqNro ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40LiqNro_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40LiqNro_Selected), 8, 0));
      this.executeUsercontrolMethod(sPrefix, false, "DVELOP_CONFIRMPANEL_ELIMINARContainer", "Confirm", "", new Object[] {});
   }

   public void S282( )
   {
      /* 'DO ACTION ELIMINAR' Routine */
      returnInSub = false ;
      new web.eliminaliquidacion(remoteHandle, context).execute( AV8CliCod_Selected, AV28EmpCod_Selected, AV40LiqNro_Selected) ;
      new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "La liquidación se eliminó correctamente", "")) ;
      gxgrgrid_refresh( subGrid_Rows, AV123ManageFiltersExecutionStep, AV9ColumnsSelector, AV231Pgmname, AV176MenuOpcCod, AV35GridState, AV162PeriodoLiq, AV185LiqRelNro, AV74TFLiqNro, AV75TFLiqNro_To, AV139TFLiqNombre, AV141TFLiqNombre_Sel, AV66TFLiqFecha, AV67TFLiqFecha_To, AV113TFLiqPerPalabra, AV114TFLiqPerPalabra_Sels, AV68TFLiqFecPago, AV69TFLiqFecPago_To, AV216TFTLiqDescAux, AV217TFTLiqDescAux_Sels, AV226TFLiqModTra_Sels, AV228TFLiqFrecPag_Sels, AV56TFLiqCntLeg, AV57TFLiqCntLeg_To, AV119TFLiqError, AV120TFLiqError_Sels, AV58TFLiqDescrip, AV60TFLiqDescrip_Sels, AV70TFLiqImpBruto, AV71TFLiqImpBruto_To, AV72TFLiqImpNeto, AV73TFLiqImpNeto_To, AV41OrderedBy, AV43OrderedDsc, AV7CliCod, AV39IsAuthorized_Update, AV27EmpCod, AV189collectionLegNumero, A3CliCod, A283LiqPeriodo, A719LiqFecImp, A361LiqGenInter, sPrefix) ;
   }

   public void S232( )
   {
      /* 'DO RELIQUIDAR' Routine */
      returnInSub = false ;
      GXv_boolean16[0] = AV169procesandoHay ;
      GXv_int4[0] = AV170procesandoLiqNro ;
      GXv_char12[0] = AV171procesandoError ;
      new web.hayalgunaliquidacionprocesando(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, AV189collectionLegNumero, GXv_boolean16, GXv_int4, GXv_char12) ;
      liquidacionww_impl.this.AV169procesandoHay = GXv_boolean16[0] ;
      liquidacionww_impl.this.AV170procesandoLiqNro = GXv_int4[0] ;
      liquidacionww_impl.this.AV171procesandoError = GXv_char12[0] ;
      if ( AV169procesandoHay )
      {
         new web.alert(remoteHandle, context).execute( "error", GXutil.trim( AV171procesandoError)+" "+GXutil.trim( GXutil.str( AV170procesandoLiqNro, 8, 0))) ;
      }
      else
      {
         GXt_char9 = "" ;
         GXv_char12[0] = GXt_char9 ;
         new web.mensajeconfirmaciondefault(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "re-liquidar", ""), GXutil.trim( A874LiqNombre), GXv_char12) ;
         liquidacionww_impl.this.GXt_char9 = GXv_char12[0] ;
         Dvelop_confirmpanel_reliquidar_Confirmationtext = GXt_char9 ;
         ucDvelop_confirmpanel_reliquidar.sendProperty(context, sPrefix, false, Dvelop_confirmpanel_reliquidar_Internalname, "ConfirmationText", Dvelop_confirmpanel_reliquidar_Confirmationtext);
         AV8CliCod_Selected = A3CliCod ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod_Selected), 6, 0));
         AV28EmpCod_Selected = A1EmpCod ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28EmpCod_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28EmpCod_Selected), 4, 0));
         AV40LiqNro_Selected = A31LiqNro ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40LiqNro_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40LiqNro_Selected), 8, 0));
         this.executeUsercontrolMethod(sPrefix, false, "DVELOP_CONFIRMPANEL_RELIQUIDARContainer", "Confirm", "", new Object[] {});
      }
   }

   public void S292( )
   {
      /* 'DO ACTION RELIQUIDAR' Routine */
      returnInSub = false ;
      new web.resetealiquidacion(remoteHandle, context).execute( AV8CliCod_Selected, AV28EmpCod_Selected, AV40LiqNro_Selected) ;
      new web.mensajeliquidacion(remoteHandle, context).execute( ) ;
      gxgrgrid_refresh( subGrid_Rows, AV123ManageFiltersExecutionStep, AV9ColumnsSelector, AV231Pgmname, AV176MenuOpcCod, AV35GridState, AV162PeriodoLiq, AV185LiqRelNro, AV74TFLiqNro, AV75TFLiqNro_To, AV139TFLiqNombre, AV141TFLiqNombre_Sel, AV66TFLiqFecha, AV67TFLiqFecha_To, AV113TFLiqPerPalabra, AV114TFLiqPerPalabra_Sels, AV68TFLiqFecPago, AV69TFLiqFecPago_To, AV216TFTLiqDescAux, AV217TFTLiqDescAux_Sels, AV226TFLiqModTra_Sels, AV228TFLiqFrecPag_Sels, AV56TFLiqCntLeg, AV57TFLiqCntLeg_To, AV119TFLiqError, AV120TFLiqError_Sels, AV58TFLiqDescrip, AV60TFLiqDescrip_Sels, AV70TFLiqImpBruto, AV71TFLiqImpBruto_To, AV72TFLiqImpNeto, AV73TFLiqImpNeto_To, AV41OrderedBy, AV43OrderedDsc, AV7CliCod, AV39IsAuthorized_Update, AV27EmpCod, AV189collectionLegNumero, A3CliCod, A283LiqPeriodo, A719LiqFecImp, A361LiqGenInter, sPrefix) ;
   }

   public void S242( )
   {
      /* 'DO CERRAR' Routine */
      returnInSub = false ;
      AV8CliCod_Selected = A3CliCod ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod_Selected), 6, 0));
      AV28EmpCod_Selected = A1EmpCod ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28EmpCod_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28EmpCod_Selected), 4, 0));
      AV40LiqNro_Selected = A31LiqNro ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40LiqNro_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40LiqNro_Selected), 8, 0));
      this.executeUsercontrolMethod(sPrefix, false, "DVELOP_CONFIRMPANEL_CERRARContainer", "Confirm", "", new Object[] {});
   }

   public void S302( )
   {
      /* 'DO ACTION CERRAR' Routine */
      returnInSub = false ;
      new web.setliqestado(remoteHandle, context).execute( AV8CliCod_Selected, AV28EmpCod_Selected, AV40LiqNro_Selected, (byte)(4)) ;
      new web.alert(remoteHandle, context).execute( "success", httpContext.getMessage( "Liquidación cerrada correctamente", "")) ;
      gxgrgrid_refresh( subGrid_Rows, AV123ManageFiltersExecutionStep, AV9ColumnsSelector, AV231Pgmname, AV176MenuOpcCod, AV35GridState, AV162PeriodoLiq, AV185LiqRelNro, AV74TFLiqNro, AV75TFLiqNro_To, AV139TFLiqNombre, AV141TFLiqNombre_Sel, AV66TFLiqFecha, AV67TFLiqFecha_To, AV113TFLiqPerPalabra, AV114TFLiqPerPalabra_Sels, AV68TFLiqFecPago, AV69TFLiqFecPago_To, AV216TFTLiqDescAux, AV217TFTLiqDescAux_Sels, AV226TFLiqModTra_Sels, AV228TFLiqFrecPag_Sels, AV56TFLiqCntLeg, AV57TFLiqCntLeg_To, AV119TFLiqError, AV120TFLiqError_Sels, AV58TFLiqDescrip, AV60TFLiqDescrip_Sels, AV70TFLiqImpBruto, AV71TFLiqImpBruto_To, AV72TFLiqImpNeto, AV73TFLiqImpNeto_To, AV41OrderedBy, AV43OrderedDsc, AV7CliCod, AV39IsAuthorized_Update, AV27EmpCod, AV189collectionLegNumero, A3CliCod, A283LiqPeriodo, A719LiqFecImp, A361LiqGenInter, sPrefix) ;
   }

   public void S252( )
   {
      /* 'DO GENERARINTERBANKING' Routine */
      returnInSub = false ;
      new web.generarinterbanking(remoteHandle, context).execute( A1EmpCod, A31LiqNro) ;
   }

   public void S262( )
   {
      /* 'DO REABRIR' Routine */
      returnInSub = false ;
      AV28EmpCod_Selected = A1EmpCod ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28EmpCod_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28EmpCod_Selected), 4, 0));
      AV40LiqNro_Selected = A31LiqNro ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40LiqNro_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40LiqNro_Selected), 8, 0));
      this.executeUsercontrolMethod(sPrefix, false, "DVELOP_CONFIRMPANEL_REABRIRContainer", "Confirm", "", new Object[] {});
   }

   public void S312( )
   {
      /* 'DO ACTION REABRIR' Routine */
      returnInSub = false ;
      new web.reabrirliquidacion(remoteHandle, context).execute( AV28EmpCod_Selected, AV40LiqNro_Selected) ;
      new web.alert(remoteHandle, context).execute( "success", httpContext.getMessage( "Liquidación re-abierta correctamente", "")) ;
      gxgrgrid_refresh( subGrid_Rows, AV123ManageFiltersExecutionStep, AV9ColumnsSelector, AV231Pgmname, AV176MenuOpcCod, AV35GridState, AV162PeriodoLiq, AV185LiqRelNro, AV74TFLiqNro, AV75TFLiqNro_To, AV139TFLiqNombre, AV141TFLiqNombre_Sel, AV66TFLiqFecha, AV67TFLiqFecha_To, AV113TFLiqPerPalabra, AV114TFLiqPerPalabra_Sels, AV68TFLiqFecPago, AV69TFLiqFecPago_To, AV216TFTLiqDescAux, AV217TFTLiqDescAux_Sels, AV226TFLiqModTra_Sels, AV228TFLiqFrecPag_Sels, AV56TFLiqCntLeg, AV57TFLiqCntLeg_To, AV119TFLiqError, AV120TFLiqError_Sels, AV58TFLiqDescrip, AV60TFLiqDescrip_Sels, AV70TFLiqImpBruto, AV71TFLiqImpBruto_To, AV72TFLiqImpNeto, AV73TFLiqImpNeto_To, AV41OrderedBy, AV43OrderedDsc, AV7CliCod, AV39IsAuthorized_Update, AV27EmpCod, AV189collectionLegNumero, A3CliCod, A283LiqPeriodo, A719LiqFecImp, A361LiqGenInter, sPrefix) ;
   }

   public void S272( )
   {
      /* 'DO CANCELAR' Routine */
      returnInSub = false ;
      AV8CliCod_Selected = A3CliCod ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod_Selected), 6, 0));
      AV28EmpCod_Selected = A1EmpCod ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28EmpCod_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28EmpCod_Selected), 4, 0));
      AV40LiqNro_Selected = A31LiqNro ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40LiqNro_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40LiqNro_Selected), 8, 0));
      this.executeUsercontrolMethod(sPrefix, false, "DVELOP_CONFIRMPANEL_CANCELARContainer", "Confirm", "", new Object[] {});
   }

   public void S322( )
   {
      /* 'DO ACTION CANCELAR' Routine */
      returnInSub = false ;
      new web.setliqcancel(remoteHandle, context).execute( AV8CliCod_Selected, AV28EmpCod_Selected, AV40LiqNro_Selected, true) ;
      new web.liqseterror(remoteHandle, context).execute( AV8CliCod_Selected, AV28EmpCod_Selected, AV40LiqNro_Selected, false, false, false, false, false, httpContext.getMessage( "Liquidación cancelada", "")) ;
      gxgrgrid_refresh( subGrid_Rows, AV123ManageFiltersExecutionStep, AV9ColumnsSelector, AV231Pgmname, AV176MenuOpcCod, AV35GridState, AV162PeriodoLiq, AV185LiqRelNro, AV74TFLiqNro, AV75TFLiqNro_To, AV139TFLiqNombre, AV141TFLiqNombre_Sel, AV66TFLiqFecha, AV67TFLiqFecha_To, AV113TFLiqPerPalabra, AV114TFLiqPerPalabra_Sels, AV68TFLiqFecPago, AV69TFLiqFecPago_To, AV216TFTLiqDescAux, AV217TFTLiqDescAux_Sels, AV226TFLiqModTra_Sels, AV228TFLiqFrecPag_Sels, AV56TFLiqCntLeg, AV57TFLiqCntLeg_To, AV119TFLiqError, AV120TFLiqError_Sels, AV58TFLiqDescrip, AV60TFLiqDescrip_Sels, AV70TFLiqImpBruto, AV71TFLiqImpBruto_To, AV72TFLiqImpNeto, AV73TFLiqImpNeto_To, AV41OrderedBy, AV43OrderedDsc, AV7CliCod, AV39IsAuthorized_Update, AV27EmpCod, AV189collectionLegNumero, A3CliCod, A283LiqPeriodo, A719LiqFecImp, A361LiqGenInter, sPrefix) ;
   }

   public void S142( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV47Session.getValue(AV231Pgmname+"GridState"), "") == 0 )
      {
         AV35GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV231Pgmname+"GridState"), null, null);
      }
      else
      {
         AV35GridState.fromxml(AV47Session.getValue(AV231Pgmname+"GridState"), null, null);
      }
      AV41OrderedBy = AV35GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41OrderedBy), 4, 0));
      AV43OrderedDsc = AV35GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43OrderedDsc", AV43OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S152 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S202 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV35GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV35GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV35GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S202( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV258GXV1 = 1 ;
      while ( AV258GXV1 <= AV35GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV36GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV35GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV258GXV1));
         if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LIQRELNRO") == 0 )
         {
            AV185LiqRelNro = (int)(GXutil.lval( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV185LiqRelNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV185LiqRelNro), 8, 0));
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNRO") == 0 )
         {
            AV74TFLiqNro = (int)(GXutil.lval( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV74TFLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV74TFLiqNro), 8, 0));
            AV75TFLiqNro_To = (int)(GXutil.lval( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV75TFLiqNro_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV75TFLiqNro_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE") == 0 )
         {
            AV139TFLiqNombre = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV139TFLiqNombre", AV139TFLiqNombre);
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE_SEL") == 0 )
         {
            AV141TFLiqNombre_Sel = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV141TFLiqNombre_Sel", AV141TFLiqNombre_Sel);
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECHA") == 0 )
         {
            AV66TFLiqFecha = localUtil.ctod( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66TFLiqFecha", localUtil.format(AV66TFLiqFecha, "99/99/9999"));
            AV67TFLiqFecha_To = localUtil.ctod( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67TFLiqFecha_To", localUtil.format(AV67TFLiqFecha_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERPALABRA") == 0 )
         {
            AV113TFLiqPerPalabra = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV113TFLiqPerPalabra", AV113TFLiqPerPalabra);
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERPALABRA_SEL") == 0 )
         {
            AV112TFLiqPerPalabra_SelsJson = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV112TFLiqPerPalabra_SelsJson", AV112TFLiqPerPalabra_SelsJson);
            AV114TFLiqPerPalabra_Sels.fromJSonString(AV112TFLiqPerPalabra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECPAGO") == 0 )
         {
            AV68TFLiqFecPago = localUtil.ctod( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68TFLiqFecPago", localUtil.format(AV68TFLiqFecPago, "99/99/9999"));
            AV69TFLiqFecPago_To = localUtil.ctod( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV69TFLiqFecPago_To", localUtil.format(AV69TFLiqFecPago_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQDESCAUX") == 0 )
         {
            AV216TFTLiqDescAux = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV216TFTLiqDescAux", AV216TFTLiqDescAux);
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQDESCAUX_SEL") == 0 )
         {
            AV215TFTLiqDescAux_SelsJson = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV215TFTLiqDescAux_SelsJson", AV215TFTLiqDescAux_SelsJson);
            AV217TFTLiqDescAux_Sels.fromJSonString(AV215TFTLiqDescAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQMODTRA_SEL") == 0 )
         {
            AV225TFLiqModTra_SelsJson = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV225TFLiqModTra_SelsJson", AV225TFLiqModTra_SelsJson);
            AV226TFLiqModTra_Sels.fromJSonString(AV225TFLiqModTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFRECPAG_SEL") == 0 )
         {
            AV227TFLiqFrecPag_SelsJson = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV227TFLiqFrecPag_SelsJson", AV227TFLiqFrecPag_SelsJson);
            AV228TFLiqFrecPag_Sels.fromJSonString(AV227TFLiqFrecPag_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQCNTLEG") == 0 )
         {
            AV56TFLiqCntLeg = (short)(GXutil.lval( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV56TFLiqCntLeg", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56TFLiqCntLeg), 4, 0));
            AV57TFLiqCntLeg_To = (short)(GXutil.lval( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV57TFLiqCntLeg_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFLiqCntLeg_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQERROR") == 0 )
         {
            AV119TFLiqError = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV119TFLiqError", AV119TFLiqError);
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQERROR_SEL") == 0 )
         {
            AV118TFLiqError_SelsJson = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV118TFLiqError_SelsJson", AV118TFLiqError_SelsJson);
            AV120TFLiqError_Sels.fromJSonString(AV118TFLiqError_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDESCRIP") == 0 )
         {
            AV58TFLiqDescrip = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58TFLiqDescrip", AV58TFLiqDescrip);
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDESCRIP_SEL") == 0 )
         {
            AV61TFLiqDescrip_SelsJson = AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV61TFLiqDescrip_SelsJson", AV61TFLiqDescrip_SelsJson);
            AV60TFLiqDescrip_Sels.fromJSonString(AV61TFLiqDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQIMPBRUTO") == 0 )
         {
            AV70TFLiqImpBruto = CommonUtil.decimalVal( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70TFLiqImpBruto", GXutil.ltrimstr( AV70TFLiqImpBruto, 14, 2));
            AV71TFLiqImpBruto_To = CommonUtil.decimalVal( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV71TFLiqImpBruto_To", GXutil.ltrimstr( AV71TFLiqImpBruto_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQIMPNETO") == 0 )
         {
            AV72TFLiqImpNeto = CommonUtil.decimalVal( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV72TFLiqImpNeto", GXutil.ltrimstr( AV72TFLiqImpNeto, 14, 2));
            AV73TFLiqImpNeto_To = CommonUtil.decimalVal( AV36GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV73TFLiqImpNeto_To", GXutil.ltrimstr( AV73TFLiqImpNeto_To, 14, 2));
         }
         AV258GXV1 = (int)(AV258GXV1+1) ;
      }
      GXt_char9 = "" ;
      GXv_char12[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV141TFLiqNombre_Sel)==0), AV141TFLiqNombre_Sel, GXv_char12) ;
      liquidacionww_impl.this.GXt_char9 = GXv_char12[0] ;
      GXt_char19 = "" ;
      GXv_char7[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV114TFLiqPerPalabra_Sels.size()==0), AV112TFLiqPerPalabra_SelsJson, GXv_char7) ;
      liquidacionww_impl.this.GXt_char19 = GXv_char7[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV217TFTLiqDescAux_Sels.size()==0), AV215TFTLiqDescAux_SelsJson, GXv_char21) ;
      liquidacionww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV226TFLiqModTra_Sels.size()==0), AV225TFLiqModTra_SelsJson, GXv_char23) ;
      liquidacionww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV120TFLiqError_Sels.size()==0), AV118TFLiqError_SelsJson, GXv_char25) ;
      liquidacionww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV60TFLiqDescrip_Sels.size()==0), AV61TFLiqDescrip_SelsJson, GXv_char27) ;
      liquidacionww_impl.this.GXt_char26 = GXv_char27[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char9+"||"+GXt_char19+"||"+GXt_char20+"|"+GXt_char22+"|"+((AV228TFLiqFrecPag_Sels.size()==0) ? "" : AV227TFLiqFrecPag_SelsJson)+"|||||||"+GXt_char24+"|"+GXt_char26+"||" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char26 = "" ;
      GXv_char27[0] = GXt_char26 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV139TFLiqNombre)==0), AV139TFLiqNombre, GXv_char27) ;
      liquidacionww_impl.this.GXt_char26 = GXv_char27[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV113TFLiqPerPalabra)==0), AV113TFLiqPerPalabra, GXv_char25) ;
      liquidacionww_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV216TFTLiqDescAux)==0), AV216TFTLiqDescAux, GXv_char23) ;
      liquidacionww_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV119TFLiqError)==0), AV119TFLiqError, GXv_char21) ;
      liquidacionww_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char19 = "" ;
      GXv_char12[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV58TFLiqDescrip)==0), AV58TFLiqDescrip, GXv_char12) ;
      liquidacionww_impl.this.GXt_char19 = GXv_char12[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV74TFLiqNro) ? "" : GXutil.str( AV74TFLiqNro, 8, 0))+"|"+GXt_char26+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV66TFLiqFecha)) ? "" : localUtil.dtoc( AV66TFLiqFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|"+GXt_char24+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV68TFLiqFecPago)) ? "" : localUtil.dtoc( AV68TFLiqFecPago, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|"+GXt_char22+"|||"+((0==AV56TFLiqCntLeg) ? "" : GXutil.str( AV56TFLiqCntLeg, 4, 0))+"||||||"+GXt_char20+"|"+GXt_char19+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV70TFLiqImpBruto)==0) ? "" : GXutil.str( AV70TFLiqImpBruto, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV72TFLiqImpNeto)==0) ? "" : GXutil.str( AV72TFLiqImpNeto, 14, 2)) ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV75TFLiqNro_To) ? "" : GXutil.str( AV75TFLiqNro_To, 8, 0))+"||"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV67TFLiqFecha_To)) ? "" : localUtil.dtoc( AV67TFLiqFecha_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"||"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV69TFLiqFecPago_To)) ? "" : localUtil.dtoc( AV69TFLiqFecPago_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"||||"+((0==AV57TFLiqCntLeg_To) ? "" : GXutil.str( AV57TFLiqCntLeg_To, 4, 0))+"||||||||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV71TFLiqImpBruto_To)==0) ? "" : GXutil.str( AV71TFLiqImpBruto_To, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV73TFLiqImpNeto_To)==0) ? "" : GXutil.str( AV73TFLiqImpNeto_To, 14, 2)) ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S172( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV35GridState.fromxml(AV47Session.getValue(AV231Pgmname+"GridState"), null, null);
      AV35GridState.setgxTv_SdtWWPGridState_Orderedby( AV41OrderedBy );
      AV35GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV43OrderedDsc );
      AV35GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState28[0] = AV35GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "LIQRELNRO", httpContext.getMessage( "relacionada", ""), !(0==AV185LiqRelNro), (short)(0), GXutil.trim( GXutil.str( AV185LiqRelNro, 8, 0)), "") ;
      AV35GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV35GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFLIQNRO", httpContext.getMessage( "Número", ""), !((0==AV74TFLiqNro)&&(0==AV75TFLiqNro_To)), (short)(0), GXutil.trim( GXutil.str( AV74TFLiqNro, 8, 0)), GXutil.trim( GXutil.str( AV75TFLiqNro_To, 8, 0))) ;
      AV35GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV35GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFLIQNOMBRE", httpContext.getMessage( "Descripción", ""), !(GXutil.strcmp("", AV139TFLiqNombre)==0), (short)(0), AV139TFLiqNombre, "", !(GXutil.strcmp("", AV141TFLiqNombre_Sel)==0), AV141TFLiqNombre_Sel, "") ;
      AV35GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV35GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFLIQFECHA", httpContext.getMessage( "Fecha de liq.", ""), !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV66TFLiqFecha))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV67TFLiqFecha_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV66TFLiqFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), GXutil.trim( localUtil.dtoc( AV67TFLiqFecha_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV35GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV35GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFLIQPERPALABRA", httpContext.getMessage( "Periodo", ""), !(GXutil.strcmp("", AV113TFLiqPerPalabra)==0), (short)(0), AV113TFLiqPerPalabra, "", !(AV114TFLiqPerPalabra_Sels.size()==0), AV114TFLiqPerPalabra_Sels.toJSonString(false), "") ;
      AV35GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV35GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFLIQFECPAGO", httpContext.getMessage( "Fecha de pago", ""), !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV68TFLiqFecPago))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV69TFLiqFecPago_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV68TFLiqFecPago, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), GXutil.trim( localUtil.dtoc( AV69TFLiqFecPago_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV35GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV35GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFTLIQDESCAUX", httpContext.getMessage( "Tipo", ""), !(GXutil.strcmp("", AV216TFTLiqDescAux)==0), (short)(0), AV216TFTLiqDescAux, "", !(AV217TFTLiqDescAux_Sels.size()==0), AV217TFTLiqDescAux_Sels.toJSonString(false), "") ;
      AV35GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV35GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFLIQMODTRA_SEL", httpContext.getMessage( "Relación laboral", ""), !(AV226TFLiqModTra_Sels.size()==0), (short)(0), AV226TFLiqModTra_Sels.toJSonString(false), "") ;
      AV35GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV35GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFLIQFRECPAG_SEL", httpContext.getMessage( "Frecuencia de pago", ""), !(AV228TFLiqFrecPag_Sels.size()==0), (short)(0), AV228TFLiqFrecPag_Sels.toJSonString(false), "") ;
      AV35GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV35GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFLIQCNTLEG", httpContext.getMessage( "Cantidad de recibos", ""), !((0==AV56TFLiqCntLeg)&&(0==AV57TFLiqCntLeg_To)), (short)(0), GXutil.trim( GXutil.str( AV56TFLiqCntLeg, 4, 0)), GXutil.trim( GXutil.str( AV57TFLiqCntLeg_To, 4, 0))) ;
      AV35GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV35GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFLIQERROR", httpContext.getMessage( "Error", ""), !(GXutil.strcmp("", AV119TFLiqError)==0), (short)(0), AV119TFLiqError, "", !(AV120TFLiqError_Sels.size()==0), AV120TFLiqError_Sels.toJSonString(false), "") ;
      AV35GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV35GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFLIQDESCRIP", httpContext.getMessage( "Observación", ""), !(GXutil.strcmp("", AV58TFLiqDescrip)==0), (short)(0), AV58TFLiqDescrip, "", !(AV60TFLiqDescrip_Sels.size()==0), AV60TFLiqDescrip_Sels.toJSonString(false), "") ;
      AV35GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV35GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFLIQIMPBRUTO", httpContext.getMessage( "Bruto", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV70TFLiqImpBruto)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV71TFLiqImpBruto_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV70TFLiqImpBruto, 14, 2)), GXutil.trim( GXutil.str( AV71TFLiqImpBruto_To, 14, 2))) ;
      AV35GridState = GXv_SdtWWPGridState28[0] ;
      GXv_SdtWWPGridState28[0] = AV35GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState28, "TFLIQIMPNETO", httpContext.getMessage( "Neto", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV72TFLiqImpNeto)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV73TFLiqImpNeto_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV72TFLiqImpNeto, 14, 2)), GXutil.trim( GXutil.str( AV73TFLiqImpNeto_To, 14, 2))) ;
      AV35GridState = GXv_SdtWWPGridState28[0] ;
      if ( ! (GXutil.strcmp("", AV176MenuOpcCod)==0) )
      {
         AV36GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV36GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV36GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV176MenuOpcCod );
         AV35GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV36GridStateFilterValue, 0);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV162PeriodoLiq)) )
      {
         AV36GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV36GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&PERIODOLIQ" );
         AV36GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( localUtil.dtoc( AV162PeriodoLiq, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/") );
         AV35GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV36GridStateFilterValue, 0);
      }
      AV35GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV35GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV231Pgmname+"GridState", AV35GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S132( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV85TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV85TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV231Pgmname );
      AV85TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV85TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV37HTTPRequest.getScriptName()+"?"+AV37HTTPRequest.getQuerystring() );
      AV85TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Liquidacion" );
      AV86TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV86TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "PeriodoLiq" );
      AV86TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( localUtil.dtoc( AV162PeriodoLiq, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/") );
      AV85TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV86TrnContextAtt, 0);
      AV47Session.setValue("TrnContext", AV85TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV47Session.getValue(AV231Pgmname+"GridState"), "") == 0 )
      {
         AV35GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV231Pgmname+"GridState"), null, null);
      }
      else
      {
         AV35GridState.fromxml(AV47Session.getValue(AV231Pgmname+"GridState"), null, null);
      }
      if ( ! ( false ) )
      {
         edtavLiqrelnro_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqrelnro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqrelnro_Visible), 5, 0), true);
         GXv_SdtWWPGridState28[0] = AV35GridState;
         if ( new web.wwpbaseobjects.wwp_deletefilter(remoteHandle, context).executeUdp( GXv_SdtWWPGridState28, "LIQRELNRO", false) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         AV35GridState = GXv_SdtWWPGridState28[0] ;
         if ( Cond_result )
         {
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV231Pgmname+"GridState", AV35GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
         }
      }
   }

   public void e302M2( )
   {
      /* 'DoEliminarTodas' Routine */
      returnInSub = false ;
      httpContext.doAjaxRefreshCmp(sPrefix);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV9ColumnsSelector", AV9ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV121ManageFiltersData", AV121ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV35GridState", AV35GridState);
   }

   public void e242M2( )
   {
      /* GlobalEvents_Mensajeliquidacion Routine */
      returnInSub = false ;
      AV111mensaje_collection.fromJSonString(AV222mensajeTextoJson, null);
      if ( AV111mensaje_collection.size() > 0 )
      {
         AV223i = (short)(1) ;
         while ( AV223i <= AV111mensaje_collection.size() )
         {
            AV107mensajeTexto = (String)AV111mensaje_collection.elementAt(-1+AV223i) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV7CliCod, AV231Pgmname, httpContext.getMessage( "&mensajeTexto ", "")+AV107mensajeTexto) ;
            AV195mensajesNotificacion = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV107mensajeTexto," ")) ;
            if ( AV195mensajesNotificacion.size() == 3 )
            {
               AV200LiquidacionEstado = (byte)(1) ;
               AV205PDFEstado = "Pendiente" ;
               AV196msgNotiEstado = (String)AV195mensajesNotificacion.elementAt(-1+1) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV196msgNotiEstado", AV196msgNotiEstado);
               AV198msgNotiPgm = (String)AV195mensajesNotificacion.elementAt(-1+2) ;
               AV197msgNotiLiqNro = (int)(GXutil.lval( (String)AV195mensajesNotificacion.elementAt(-1+3))) ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV7CliCod, AV231Pgmname, httpContext.getMessage( "&msgNotiPgm ", "")+AV198msgNotiPgm) ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV7CliCod, AV231Pgmname, httpContext.getMessage( "&&msgNotiEstado ", "")+AV196msgNotiEstado) ;
               if ( GXutil.strcmp(AV198msgNotiPgm, httpContext.getMessage( "GENERACION_PDFS", "")) == 0 )
               {
                  /* Execute user subroutine: 'INTERPRETAR NOTIFICACION PDF' */
                  S332 ();
                  if (returnInSub) return;
               }
               else
               {
                  /* Execute user subroutine: 'INTERPRETAR NOTIFICACION CONCEPTOS' */
                  S342 ();
                  if (returnInSub) return;
               }
               new web.msgdebug_prod2(remoteHandle, context).execute( AV7CliCod, AV231Pgmname, httpContext.getMessage( "&msgNotiLiqNro ", "")+GXutil.str( AV197msgNotiLiqNro, 8, 0)) ;
               AV219PendienteLiquidacionestado = (byte)(1) ;
               /* Start For Each Line in Grid */
               nRC_GXsfl_70 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_70"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               nGXsfl_70_fel_idx = 0 ;
               while ( nGXsfl_70_fel_idx < nRC_GXsfl_70 )
               {
                  nGXsfl_70_fel_idx = ((subGrid_Islastpage==1)&&(nGXsfl_70_fel_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_70_fel_idx+1) ;
                  sGXsfl_70_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_70_fel_idx), 4, 0), (short)(4), "0") ;
                  subsflControlProps_fel_702( ) ;
                  AV45ProximaAccion = httpContext.cgiGet( edtavProximaaccion_Internalname) ;
                  cmbavGridactions.setName( cmbavGridactions.getInternalname() );
                  cmbavGridactions.setValue( httpContext.cgiGet( cmbavGridactions.getInternalname()) );
                  AV31GridActions = (short)(GXutil.lval( httpContext.cgiGet( cmbavGridactions.getInternalname()))) ;
                  A31LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                  A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                  A874LiqNombre = httpContext.cgiGet( edtLiqNombre_Internalname) ;
                  A98LiqFecha = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLiqFecha_Internalname), 0)) ;
                  A748LiqPerPalabra = httpContext.cgiGet( edtLiqPerPalabra_Internalname) ;
                  A280LiqFecPago = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLiqFecPago_Internalname), 0)) ;
                  A2368TLiqDescAux = GXutil.upper( httpContext.cgiGet( edtTLiqDescAux_Internalname)) ;
                  cmbLiqClase.setName( cmbLiqClase.getInternalname() );
                  cmbLiqClase.setValue( httpContext.cgiGet( cmbLiqClase.getInternalname()) );
                  A268LiqClase = (byte)(GXutil.lval( httpContext.cgiGet( cmbLiqClase.getInternalname()))) ;
                  n268LiqClase = false ;
                  cmbLiqModTra.setName( cmbLiqModTra.getInternalname() );
                  cmbLiqModTra.setValue( httpContext.cgiGet( cmbLiqModTra.getInternalname()) );
                  A2409LiqModTra = httpContext.cgiGet( cmbLiqModTra.getInternalname()) ;
                  cmbLiqFrecPag.setName( cmbLiqFrecPag.getInternalname() );
                  cmbLiqFrecPag.setValue( httpContext.cgiGet( cmbLiqFrecPag.getInternalname()) );
                  A2414LiqFrecPag = (byte)(GXutil.lval( httpContext.cgiGet( cmbLiqFrecPag.getInternalname()))) ;
                  A495LiqCntLeg = (short)(localUtil.ctol( httpContext.cgiGet( edtLiqCntLeg_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                  cmbLiqEstado.setName( cmbLiqEstado.getInternalname() );
                  cmbLiqEstado.setValue( httpContext.cgiGet( cmbLiqEstado.getInternalname()) );
                  A278LiqEstado = (byte)(GXutil.lval( httpContext.cgiGet( cmbLiqEstado.getInternalname()))) ;
                  cmbLiqLSDDepEst.setName( cmbLiqLSDDepEst.getInternalname() );
                  cmbLiqLSDDepEst.setValue( httpContext.cgiGet( cmbLiqLSDDepEst.getInternalname()) );
                  A2292LiqLSDDepEst = (byte)(GXutil.lval( httpContext.cgiGet( cmbLiqLSDDepEst.getInternalname()))) ;
                  cmbLiqContrEst.setName( cmbLiqContrEst.getInternalname() );
                  cmbLiqContrEst.setValue( httpContext.cgiGet( cmbLiqContrEst.getInternalname()) );
                  A2293LiqContrEst = (byte)(GXutil.lval( httpContext.cgiGet( cmbLiqContrEst.getInternalname()))) ;
                  cmbLiqPDFEstado.setName( cmbLiqPDFEstado.getInternalname() );
                  cmbLiqPDFEstado.setValue( httpContext.cgiGet( cmbLiqPDFEstado.getInternalname()) );
                  A2180LiqPDFEstado = httpContext.cgiGet( cmbLiqPDFEstado.getInternalname()) ;
                  n2180LiqPDFEstado = false ;
                  cmbLiqAuxEstado.setName( cmbLiqAuxEstado.getInternalname() );
                  cmbLiqAuxEstado.setValue( httpContext.cgiGet( cmbLiqAuxEstado.getInternalname()) );
                  A1403LiqAuxEstado = (byte)(GXutil.lval( httpContext.cgiGet( cmbLiqAuxEstado.getInternalname()))) ;
                  AV194EstadoPrin = httpContext.cgiGet( edtavEstadoprin_Internalname) ;
                  AV203EstadoPDF = httpContext.cgiGet( edtavEstadopdf_Internalname) ;
                  AV201EstadoLSDDep = httpContext.cgiGet( edtavEstadolsddep_Internalname) ;
                  AV202EstadoContr = httpContext.cgiGet( edtavEstadocontr_Internalname) ;
                  AV204EstadoAuxFut = httpContext.cgiGet( edtavEstadoauxfut_Internalname) ;
                  A766LiqError = httpContext.cgiGet( edtLiqError_Internalname) ;
                  A271LiqDescrip = httpContext.cgiGet( edtLiqDescrip_Internalname) ;
                  A1142LiqLog = httpContext.cgiGet( edtLiqLog_Internalname) ;
                  A885LiqSegundos = localUtil.ctond( httpContext.cgiGet( edtLiqSegundos_Internalname)) ;
                  A497LiqImpBruto = localUtil.ctond( httpContext.cgiGet( edtLiqImpBruto_Internalname)) ;
                  A496LiqImpNeto = localUtil.ctond( httpContext.cgiGet( edtLiqImpNeto_Internalname)) ;
                  AV175Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                  AV102Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                  AV173VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                  AV174ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                  if ( A31LiqNro == AV197msgNotiLiqNro )
                  {
                     if ( GXutil.strcmp(GXutil.upper( AV198msgNotiPgm), httpContext.getMessage( "GUARDALIQUIDACION", "")) == 0 )
                     {
                        if ( GXutil.strcmp(AV196msgNotiEstado, httpContext.getMessage( "PARCIAL", "")) != 0 )
                        {
                           if ( GXutil.strSearch( AV196msgNotiEstado, httpContext.getMessage( "PROGRESO", ""), 1) != 0 )
                           {
                              AV194EstadoPrin = "" ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadoprin_Internalname, AV194EstadoPrin);
                              AV220porcentajePalabra = (String)new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV196msgNotiEstado,"_")).elementAt(-1+2) ;
                              AV194EstadoPrin += " " + GXutil.trim( AV220porcentajePalabra) + "%" ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadoprin_Internalname, AV194EstadoPrin);
                           }
                           else
                           {
                              AV194EstadoPrin = GXutil.trim( httpContext.getMessage( web.gxdomainliquidacionestado.getDescription(httpContext,(byte)AV200LiquidacionEstado), "")) ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadoprin_Internalname, AV194EstadoPrin);
                           }
                        }
                        if ( GXutil.strSearch( AV196msgNotiEstado, httpContext.getMessage( "PROGRESO", ""), 1) == 0 )
                        {
                           AV201EstadoLSDDep = GXutil.trim( AV224siguienteEstadoPalabra) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadolsddep_Internalname, AV201EstadoLSDDep);
                           AV203EstadoPDF = GXutil.trim( AV224siguienteEstadoPalabra) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadopdf_Internalname, AV203EstadoPDF);
                        }
                     }
                     else if ( GXutil.strcmp(GXutil.upper( AV198msgNotiPgm), httpContext.getMessage( "DEPENDENCIAS_LSD", "")) == 0 )
                     {
                        if ( GXutil.strcmp(AV196msgNotiEstado, httpContext.getMessage( "PARCIAL", "")) != 0 )
                        {
                           if ( GXutil.strSearch( AV196msgNotiEstado, httpContext.getMessage( "PROGRESO", ""), 1) != 0 )
                           {
                              AV201EstadoLSDDep = "" ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadolsddep_Internalname, AV201EstadoLSDDep);
                              AV220porcentajePalabra = (String)new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV196msgNotiEstado,"_")).elementAt(-1+2) ;
                              AV201EstadoLSDDep += " " + GXutil.trim( AV220porcentajePalabra) + "%" ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadolsddep_Internalname, AV201EstadoLSDDep);
                           }
                           else
                           {
                              AV201EstadoLSDDep = GXutil.trim( httpContext.getMessage( web.gxdomainliquidacionestado.getDescription(httpContext,(byte)AV200LiquidacionEstado), "")) ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadolsddep_Internalname, AV201EstadoLSDDep);
                           }
                        }
                        if ( GXutil.strSearch( AV196msgNotiEstado, httpContext.getMessage( "PROGRESO", ""), 1) == 0 )
                        {
                           AV202EstadoContr = GXutil.trim( AV224siguienteEstadoPalabra) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadocontr_Internalname, AV202EstadoContr);
                        }
                        new web.msgdebug_prod2(remoteHandle, context).execute( AV7CliCod, AV231Pgmname, httpContext.getMessage( "actualiza a ", "")+AV201EstadoLSDDep) ;
                     }
                     else if ( GXutil.strcmp(GXutil.upper( AV198msgNotiPgm), httpContext.getMessage( "CONTRIBUCIONES", "")) == 0 )
                     {
                        if ( GXutil.strcmp(AV196msgNotiEstado, httpContext.getMessage( "PARCIAL", "")) != 0 )
                        {
                           if ( GXutil.strSearch( AV196msgNotiEstado, httpContext.getMessage( "PROGRESO", ""), 1) != 0 )
                           {
                              AV202EstadoContr = "" ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadocontr_Internalname, AV202EstadoContr);
                              AV220porcentajePalabra = (String)new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV196msgNotiEstado,"_")).elementAt(-1+2) ;
                              AV202EstadoContr += " " + GXutil.trim( AV220porcentajePalabra) + "%" ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadocontr_Internalname, AV202EstadoContr);
                           }
                           else
                           {
                              AV202EstadoContr = GXutil.trim( httpContext.getMessage( web.gxdomainliquidacionestado.getDescription(httpContext,(byte)AV200LiquidacionEstado), "")) ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadocontr_Internalname, AV202EstadoContr);
                           }
                        }
                        if ( GXutil.strSearch( AV196msgNotiEstado, httpContext.getMessage( "PROGRESO", ""), 1) == 0 )
                        {
                           AV204EstadoAuxFut = GXutil.trim( AV224siguienteEstadoPalabra) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadoauxfut_Internalname, AV204EstadoAuxFut);
                        }
                        new web.msgdebug_prod2(remoteHandle, context).execute( AV7CliCod, AV231Pgmname, httpContext.getMessage( "!actualiza a ", "")+AV201EstadoLSDDep) ;
                     }
                     else if ( GXutil.strcmp(GXutil.upper( AV198msgNotiPgm), httpContext.getMessage( "GENERACION_PDFS", "")) == 0 )
                     {
                        if ( GXutil.strSearch( AV196msgNotiEstado, httpContext.getMessage( "PROGRESO", ""), 1) != 0 )
                        {
                           AV203EstadoPDF = "" ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadopdf_Internalname, AV203EstadoPDF);
                           AV220porcentajePalabra = (String)new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV196msgNotiEstado,"_")).elementAt(-1+2) ;
                           AV203EstadoPDF += " " + GXutil.trim( AV220porcentajePalabra) + "%" ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadopdf_Internalname, AV203EstadoPDF);
                        }
                        else
                        {
                           AV203EstadoPDF = GXutil.trim( httpContext.getMessage( web.gxdomainpdfestado.getDescription(httpContext,(String)AV205PDFEstado), "")) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadopdf_Internalname, AV203EstadoPDF);
                        }
                     }
                     else if ( GXutil.strcmp(GXutil.upper( AV198msgNotiPgm), httpContext.getMessage( "OTROS", "")) == 0 )
                     {
                        if ( GXutil.strSearch( AV196msgNotiEstado, httpContext.getMessage( "PROGRESO", ""), 1) != 0 )
                        {
                           AV204EstadoAuxFut = "" ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadoauxfut_Internalname, AV204EstadoAuxFut);
                           AV220porcentajePalabra = (String)new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV196msgNotiEstado,"_")).elementAt(-1+2) ;
                           AV204EstadoAuxFut += " " + GXutil.trim( AV220porcentajePalabra) + "%" ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadoauxfut_Internalname, AV204EstadoAuxFut);
                        }
                        else
                        {
                           AV204EstadoAuxFut = GXutil.trim( httpContext.getMessage( web.gxdomainliquidacionestado.getDescription(httpContext,(byte)AV200LiquidacionEstado), "")) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEstadoauxfut_Internalname, AV204EstadoAuxFut);
                        }
                     }
                  }
                  /* End For Each Line */
               }
               if ( nGXsfl_70_fel_idx == 0 )
               {
                  nGXsfl_70_idx = 1 ;
                  sGXsfl_70_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_70_idx), 4, 0), (short)(4), "0") ;
                  subsflControlProps_702( ) ;
               }
               nGXsfl_70_fel_idx = 1 ;
            }
            AV223i = (short)(AV223i+1) ;
         }
      }
      /*  Sending Event outputs  */
   }

   public void S352( )
   {
      /* 'DO LIQUIDAR' Routine */
      returnInSub = false ;
   }

   public void S332( )
   {
      /* 'INTERPRETAR NOTIFICACION PDF' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV196msgNotiEstado, httpContext.getMessage( "OK", "")) == 0 )
      {
         AV205PDFEstado = "Completo" ;
      }
      else
      {
         if ( GXutil.strcmp(AV196msgNotiEstado, httpContext.getMessage( "MANUAL", "")) == 0 )
         {
            AV205PDFEstado = "Manual" ;
         }
         else
         {
            if ( GXutil.strcmp(AV196msgNotiEstado, httpContext.getMessage( "PROCESANDO", "")) == 0 )
            {
               AV205PDFEstado = "EnEspera" ;
            }
            else
            {
               AV205PDFEstado = "Error" ;
            }
         }
      }
   }

   public void S342( )
   {
      /* 'INTERPRETAR NOTIFICACION CONCEPTOS' Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(AV196msgNotiEstado, httpContext.getMessage( "OK", "")) == 0 ) || ( GXutil.strcmp(AV196msgNotiEstado, httpContext.getMessage( "PARCIAL", "")) == 0 ) || ( GXutil.strSearch( AV196msgNotiEstado, httpContext.getMessage( "PROGRESO", ""), 1) != 0 ) )
      {
         AV200LiquidacionEstado = (byte)(3) ;
         AV224siguienteEstadoPalabra = "..." ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV224siguienteEstadoPalabra", AV224siguienteEstadoPalabra);
      }
      else
      {
         AV200LiquidacionEstado = (byte)(2) ;
         AV224siguienteEstadoPalabra = httpContext.getMessage( web.gxdomainliquidacionestado.getDescription(httpContext,(byte)AV200LiquidacionEstado), "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV224siguienteEstadoPalabra", AV224siguienteEstadoPalabra);
      }
   }

   public void wb_table8_140_2M2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_cancelar_Internalname, tblTabledvelop_confirmpanel_cancelar_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_cancelar.setProperty("Title", Dvelop_confirmpanel_cancelar_Title);
         ucDvelop_confirmpanel_cancelar.setProperty("ConfirmationText", Dvelop_confirmpanel_cancelar_Confirmationtext);
         ucDvelop_confirmpanel_cancelar.setProperty("YesButtonCaption", Dvelop_confirmpanel_cancelar_Yesbuttoncaption);
         ucDvelop_confirmpanel_cancelar.setProperty("NoButtonCaption", Dvelop_confirmpanel_cancelar_Nobuttoncaption);
         ucDvelop_confirmpanel_cancelar.setProperty("CancelButtonCaption", Dvelop_confirmpanel_cancelar_Cancelbuttoncaption);
         ucDvelop_confirmpanel_cancelar.setProperty("YesButtonPosition", Dvelop_confirmpanel_cancelar_Yesbuttonposition);
         ucDvelop_confirmpanel_cancelar.setProperty("ConfirmType", Dvelop_confirmpanel_cancelar_Confirmtype);
         ucDvelop_confirmpanel_cancelar.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_cancelar_Internalname, sPrefix+"DVELOP_CONFIRMPANEL_CANCELARContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVELOP_CONFIRMPANEL_CANCELARContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table8_140_2M2e( true) ;
      }
      else
      {
         wb_table8_140_2M2e( false) ;
      }
   }

   public void wb_table7_135_2M2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_reabrir_Internalname, tblTabledvelop_confirmpanel_reabrir_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_reabrir.setProperty("Title", Dvelop_confirmpanel_reabrir_Title);
         ucDvelop_confirmpanel_reabrir.setProperty("ConfirmationText", Dvelop_confirmpanel_reabrir_Confirmationtext);
         ucDvelop_confirmpanel_reabrir.setProperty("YesButtonCaption", Dvelop_confirmpanel_reabrir_Yesbuttoncaption);
         ucDvelop_confirmpanel_reabrir.setProperty("NoButtonCaption", Dvelop_confirmpanel_reabrir_Nobuttoncaption);
         ucDvelop_confirmpanel_reabrir.setProperty("CancelButtonCaption", Dvelop_confirmpanel_reabrir_Cancelbuttoncaption);
         ucDvelop_confirmpanel_reabrir.setProperty("YesButtonPosition", Dvelop_confirmpanel_reabrir_Yesbuttonposition);
         ucDvelop_confirmpanel_reabrir.setProperty("ConfirmType", Dvelop_confirmpanel_reabrir_Confirmtype);
         ucDvelop_confirmpanel_reabrir.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_reabrir_Internalname, sPrefix+"DVELOP_CONFIRMPANEL_REABRIRContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVELOP_CONFIRMPANEL_REABRIRContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_135_2M2e( true) ;
      }
      else
      {
         wb_table7_135_2M2e( false) ;
      }
   }

   public void wb_table6_130_2M2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_cerrar_Internalname, tblTabledvelop_confirmpanel_cerrar_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_cerrar.setProperty("Title", Dvelop_confirmpanel_cerrar_Title);
         ucDvelop_confirmpanel_cerrar.setProperty("ConfirmationText", Dvelop_confirmpanel_cerrar_Confirmationtext);
         ucDvelop_confirmpanel_cerrar.setProperty("YesButtonCaption", Dvelop_confirmpanel_cerrar_Yesbuttoncaption);
         ucDvelop_confirmpanel_cerrar.setProperty("NoButtonCaption", Dvelop_confirmpanel_cerrar_Nobuttoncaption);
         ucDvelop_confirmpanel_cerrar.setProperty("CancelButtonCaption", Dvelop_confirmpanel_cerrar_Cancelbuttoncaption);
         ucDvelop_confirmpanel_cerrar.setProperty("YesButtonPosition", Dvelop_confirmpanel_cerrar_Yesbuttonposition);
         ucDvelop_confirmpanel_cerrar.setProperty("ConfirmType", Dvelop_confirmpanel_cerrar_Confirmtype);
         ucDvelop_confirmpanel_cerrar.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_cerrar_Internalname, sPrefix+"DVELOP_CONFIRMPANEL_CERRARContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVELOP_CONFIRMPANEL_CERRARContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_130_2M2e( true) ;
      }
      else
      {
         wb_table6_130_2M2e( false) ;
      }
   }

   public void wb_table5_125_2M2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_reliquidar_Internalname, tblTabledvelop_confirmpanel_reliquidar_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_reliquidar.setProperty("Title", Dvelop_confirmpanel_reliquidar_Title);
         ucDvelop_confirmpanel_reliquidar.setProperty("ConfirmationText", Dvelop_confirmpanel_reliquidar_Confirmationtext);
         ucDvelop_confirmpanel_reliquidar.setProperty("YesButtonCaption", Dvelop_confirmpanel_reliquidar_Yesbuttoncaption);
         ucDvelop_confirmpanel_reliquidar.setProperty("NoButtonCaption", Dvelop_confirmpanel_reliquidar_Nobuttoncaption);
         ucDvelop_confirmpanel_reliquidar.setProperty("CancelButtonCaption", Dvelop_confirmpanel_reliquidar_Cancelbuttoncaption);
         ucDvelop_confirmpanel_reliquidar.setProperty("YesButtonPosition", Dvelop_confirmpanel_reliquidar_Yesbuttonposition);
         ucDvelop_confirmpanel_reliquidar.setProperty("ConfirmType", Dvelop_confirmpanel_reliquidar_Confirmtype);
         ucDvelop_confirmpanel_reliquidar.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_reliquidar_Internalname, sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDARContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDARContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_125_2M2e( true) ;
      }
      else
      {
         wb_table5_125_2M2e( false) ;
      }
   }

   public void wb_table4_120_2M2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_eliminar_Internalname, tblTabledvelop_confirmpanel_eliminar_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_eliminar.setProperty("Title", Dvelop_confirmpanel_eliminar_Title);
         ucDvelop_confirmpanel_eliminar.setProperty("ConfirmationText", Dvelop_confirmpanel_eliminar_Confirmationtext);
         ucDvelop_confirmpanel_eliminar.setProperty("YesButtonCaption", Dvelop_confirmpanel_eliminar_Yesbuttoncaption);
         ucDvelop_confirmpanel_eliminar.setProperty("NoButtonCaption", Dvelop_confirmpanel_eliminar_Nobuttoncaption);
         ucDvelop_confirmpanel_eliminar.setProperty("CancelButtonCaption", Dvelop_confirmpanel_eliminar_Cancelbuttoncaption);
         ucDvelop_confirmpanel_eliminar.setProperty("YesButtonPosition", Dvelop_confirmpanel_eliminar_Yesbuttonposition);
         ucDvelop_confirmpanel_eliminar.setProperty("ConfirmType", Dvelop_confirmpanel_eliminar_Confirmtype);
         ucDvelop_confirmpanel_eliminar.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_eliminar_Internalname, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVELOP_CONFIRMPANEL_ELIMINARContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_120_2M2e( true) ;
      }
      else
      {
         wb_table4_120_2M2e( false) ;
      }
   }

   public void wb_table3_115_2M2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_proximaaccion_Internalname, tblTabledvelop_confirmpanel_proximaaccion_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_proximaaccion.setProperty("Title", Dvelop_confirmpanel_proximaaccion_Title);
         ucDvelop_confirmpanel_proximaaccion.setProperty("ConfirmationText", Dvelop_confirmpanel_proximaaccion_Confirmationtext);
         ucDvelop_confirmpanel_proximaaccion.setProperty("YesButtonCaption", Dvelop_confirmpanel_proximaaccion_Yesbuttoncaption);
         ucDvelop_confirmpanel_proximaaccion.setProperty("NoButtonCaption", Dvelop_confirmpanel_proximaaccion_Nobuttoncaption);
         ucDvelop_confirmpanel_proximaaccion.setProperty("CancelButtonCaption", Dvelop_confirmpanel_proximaaccion_Cancelbuttoncaption);
         ucDvelop_confirmpanel_proximaaccion.setProperty("YesButtonPosition", Dvelop_confirmpanel_proximaaccion_Yesbuttonposition);
         ucDvelop_confirmpanel_proximaaccion.setProperty("ConfirmType", Dvelop_confirmpanel_proximaaccion_Confirmtype);
         ucDvelop_confirmpanel_proximaaccion.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_proximaaccion_Internalname, sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCIONContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCIONContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_115_2M2e( true) ;
      }
      else
      {
         wb_table3_115_2M2e( false) ;
      }
   }

   public void wb_table2_23_2M2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablefiltros_Internalname, tblTablefiltros_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_tablecontentbuttonimport_Internalname, 1, 0, "px", 0, "px", "TableContentButtonImport", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_table_svg_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_LiquidacionWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* User Defined Control */
         ucButtonexport1_a3lexport.render(context, "a3lclonevent", Buttonexport1_a3lexport_Internalname, sPrefix+"BUTTONEXPORT1_A3LEXPORTContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td data-align=\"Right\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Right;text-align:-moz-Right;text-align:-webkit-Right")+"\">") ;
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("IconType", Ddo_gridcolumnsselector_Icontype);
         ucDdo_gridcolumnsselector.setProperty("Icon", Ddo_gridcolumnsselector_Icon);
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV25DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV9ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, sPrefix+"DDO_GRIDCOLUMNSSELECTORContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV121ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, sPrefix+"DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 70, 2, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 5, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 70, 2, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_tablecontent_Internalname, divButtonfilter1_tablecontent_Visible, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_filtros_Internalname, 1, 0, "px", 0, "px", "TableContentButtonImportFiltros", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_table_svg_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_LiquidacionWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_table_texto_Internalname, 1, 0, "px", 0, "px", "ML10", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table9_59_2M2( true) ;
      }
      else
      {
         wb_table9_59_2M2( false) ;
      }
      return  ;
   }

   public void wb_table9_59_2M2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* User Defined Control */
         ucButtonfilter1_a3lfilter.render(context, "a3lfilter", Buttonfilter1_a3lfilter_Internalname, sPrefix+"BUTTONFILTER1_A3LFILTERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_23_2M2e( true) ;
      }
      else
      {
         wb_table2_23_2M2e( false) ;
      }
   }

   public void wb_table9_59_2M2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table9_59_2M2e( true) ;
      }
      else
      {
         wb_table9_59_2M2e( false) ;
      }
   }

   public void wb_table1_11_2M2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_LiquidacionWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_11_2M2e( true) ;
      }
      else
      {
         wb_table1_11_2M2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV176MenuOpcCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV176MenuOpcCod", AV176MenuOpcCod);
      AV162PeriodoLiq = (java.util.Date)getParm(obj,1,TypeConstants.DATE) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV162PeriodoLiq", localUtil.format(AV162PeriodoLiq, "99/99/99"));
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
      pa2M2( ) ;
      ws2M2( ) ;
      we2M2( ) ;
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
      sCtrlAV176MenuOpcCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV162PeriodoLiq = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa2M2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "liquidacionww", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa2M2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV176MenuOpcCod = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV176MenuOpcCod", AV176MenuOpcCod);
         AV162PeriodoLiq = (java.util.Date)getParm(obj,3,TypeConstants.DATE) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV162PeriodoLiq", localUtil.format(AV162PeriodoLiq, "99/99/99"));
      }
      wcpOAV176MenuOpcCod = httpContext.cgiGet( sPrefix+"wcpOAV176MenuOpcCod") ;
      wcpOAV162PeriodoLiq = localUtil.ctod( httpContext.cgiGet( sPrefix+"wcpOAV162PeriodoLiq"), 0) ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV176MenuOpcCod, wcpOAV176MenuOpcCod) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(AV162PeriodoLiq), GXutil.resetTime(wcpOAV162PeriodoLiq)) ) ) )
      {
         setjustcreated();
      }
      wcpOAV176MenuOpcCod = AV176MenuOpcCod ;
      wcpOAV162PeriodoLiq = AV162PeriodoLiq ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV176MenuOpcCod = httpContext.cgiGet( sPrefix+"AV176MenuOpcCod_CTRL") ;
      if ( GXutil.len( sCtrlAV176MenuOpcCod) > 0 )
      {
         AV176MenuOpcCod = httpContext.cgiGet( sCtrlAV176MenuOpcCod) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV176MenuOpcCod", AV176MenuOpcCod);
      }
      else
      {
         AV176MenuOpcCod = httpContext.cgiGet( sPrefix+"AV176MenuOpcCod_PARM") ;
      }
      sCtrlAV162PeriodoLiq = httpContext.cgiGet( sPrefix+"AV162PeriodoLiq_CTRL") ;
      if ( GXutil.len( sCtrlAV162PeriodoLiq) > 0 )
      {
         AV162PeriodoLiq = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( sCtrlAV162PeriodoLiq), 0)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV162PeriodoLiq", localUtil.format(AV162PeriodoLiq, "99/99/99"));
      }
      else
      {
         AV162PeriodoLiq = localUtil.ctod( httpContext.cgiGet( sPrefix+"AV162PeriodoLiq_PARM"), 0) ;
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
      pa2M2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws2M2( ) ;
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
      ws2M2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV176MenuOpcCod_PARM", AV176MenuOpcCod);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV176MenuOpcCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV176MenuOpcCod_CTRL", GXutil.rtrim( sCtrlAV176MenuOpcCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV162PeriodoLiq_PARM", localUtil.dtoc( AV162PeriodoLiq, 0, "/"));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV162PeriodoLiq)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV162PeriodoLiq_CTRL", GXutil.rtrim( sCtrlAV162PeriodoLiq));
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
      we2M2( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Shared/daterangepicker/daterangepicker.css", "");
      httpContext.AddStyleSheetFile("DVelop/Shared/daterangepicker/daterangepicker.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202518829716", true, true);
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
      httpContext.AddJavascriptSource("liquidacionww.js", "?202518829717", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridTitlesCategories/GridTitlesCategoriesRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_702( )
   {
      edtavProximaaccion_Internalname = sPrefix+"vPROXIMAACCION_"+sGXsfl_70_idx ;
      cmbavGridactions.setInternalname( sPrefix+"vGRIDACTIONS_"+sGXsfl_70_idx );
      edtLiqNro_Internalname = sPrefix+"LIQNRO_"+sGXsfl_70_idx ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD_"+sGXsfl_70_idx ;
      edtLiqNombre_Internalname = sPrefix+"LIQNOMBRE_"+sGXsfl_70_idx ;
      edtLiqFecha_Internalname = sPrefix+"LIQFECHA_"+sGXsfl_70_idx ;
      edtLiqPerPalabra_Internalname = sPrefix+"LIQPERPALABRA_"+sGXsfl_70_idx ;
      edtLiqFecPago_Internalname = sPrefix+"LIQFECPAGO_"+sGXsfl_70_idx ;
      edtTLiqDescAux_Internalname = sPrefix+"TLIQDESCAUX_"+sGXsfl_70_idx ;
      cmbLiqClase.setInternalname( sPrefix+"LIQCLASE_"+sGXsfl_70_idx );
      cmbLiqModTra.setInternalname( sPrefix+"LIQMODTRA_"+sGXsfl_70_idx );
      cmbLiqFrecPag.setInternalname( sPrefix+"LIQFRECPAG_"+sGXsfl_70_idx );
      edtLiqCntLeg_Internalname = sPrefix+"LIQCNTLEG_"+sGXsfl_70_idx ;
      cmbLiqEstado.setInternalname( sPrefix+"LIQESTADO_"+sGXsfl_70_idx );
      cmbLiqLSDDepEst.setInternalname( sPrefix+"LIQLSDDEPEST_"+sGXsfl_70_idx );
      cmbLiqContrEst.setInternalname( sPrefix+"LIQCONTREST_"+sGXsfl_70_idx );
      cmbLiqPDFEstado.setInternalname( sPrefix+"LIQPDFESTADO_"+sGXsfl_70_idx );
      cmbLiqAuxEstado.setInternalname( sPrefix+"LIQAUXESTADO_"+sGXsfl_70_idx );
      edtavEstadoprin_Internalname = sPrefix+"vESTADOPRIN_"+sGXsfl_70_idx ;
      edtavEstadopdf_Internalname = sPrefix+"vESTADOPDF_"+sGXsfl_70_idx ;
      edtavEstadolsddep_Internalname = sPrefix+"vESTADOLSDDEP_"+sGXsfl_70_idx ;
      edtavEstadocontr_Internalname = sPrefix+"vESTADOCONTR_"+sGXsfl_70_idx ;
      edtavEstadoauxfut_Internalname = sPrefix+"vESTADOAUXFUT_"+sGXsfl_70_idx ;
      edtLiqError_Internalname = sPrefix+"LIQERROR_"+sGXsfl_70_idx ;
      edtLiqDescrip_Internalname = sPrefix+"LIQDESCRIP_"+sGXsfl_70_idx ;
      edtLiqLog_Internalname = sPrefix+"LIQLOG_"+sGXsfl_70_idx ;
      edtLiqSegundos_Internalname = sPrefix+"LIQSEGUNDOS_"+sGXsfl_70_idx ;
      edtLiqImpBruto_Internalname = sPrefix+"LIQIMPBRUTO_"+sGXsfl_70_idx ;
      edtLiqImpNeto_Internalname = sPrefix+"LIQIMPNETO_"+sGXsfl_70_idx ;
      edtavDisplay_Internalname = sPrefix+"vDISPLAY_"+sGXsfl_70_idx ;
      edtavUpdate_Internalname = sPrefix+"vUPDATE_"+sGXsfl_70_idx ;
      edtavVersvg_Internalname = sPrefix+"vVERSVG_"+sGXsfl_70_idx ;
      edtavModificarsvg_Internalname = sPrefix+"vMODIFICARSVG_"+sGXsfl_70_idx ;
   }

   public void subsflControlProps_fel_702( )
   {
      edtavProximaaccion_Internalname = sPrefix+"vPROXIMAACCION_"+sGXsfl_70_fel_idx ;
      cmbavGridactions.setInternalname( sPrefix+"vGRIDACTIONS_"+sGXsfl_70_fel_idx );
      edtLiqNro_Internalname = sPrefix+"LIQNRO_"+sGXsfl_70_fel_idx ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD_"+sGXsfl_70_fel_idx ;
      edtLiqNombre_Internalname = sPrefix+"LIQNOMBRE_"+sGXsfl_70_fel_idx ;
      edtLiqFecha_Internalname = sPrefix+"LIQFECHA_"+sGXsfl_70_fel_idx ;
      edtLiqPerPalabra_Internalname = sPrefix+"LIQPERPALABRA_"+sGXsfl_70_fel_idx ;
      edtLiqFecPago_Internalname = sPrefix+"LIQFECPAGO_"+sGXsfl_70_fel_idx ;
      edtTLiqDescAux_Internalname = sPrefix+"TLIQDESCAUX_"+sGXsfl_70_fel_idx ;
      cmbLiqClase.setInternalname( sPrefix+"LIQCLASE_"+sGXsfl_70_fel_idx );
      cmbLiqModTra.setInternalname( sPrefix+"LIQMODTRA_"+sGXsfl_70_fel_idx );
      cmbLiqFrecPag.setInternalname( sPrefix+"LIQFRECPAG_"+sGXsfl_70_fel_idx );
      edtLiqCntLeg_Internalname = sPrefix+"LIQCNTLEG_"+sGXsfl_70_fel_idx ;
      cmbLiqEstado.setInternalname( sPrefix+"LIQESTADO_"+sGXsfl_70_fel_idx );
      cmbLiqLSDDepEst.setInternalname( sPrefix+"LIQLSDDEPEST_"+sGXsfl_70_fel_idx );
      cmbLiqContrEst.setInternalname( sPrefix+"LIQCONTREST_"+sGXsfl_70_fel_idx );
      cmbLiqPDFEstado.setInternalname( sPrefix+"LIQPDFESTADO_"+sGXsfl_70_fel_idx );
      cmbLiqAuxEstado.setInternalname( sPrefix+"LIQAUXESTADO_"+sGXsfl_70_fel_idx );
      edtavEstadoprin_Internalname = sPrefix+"vESTADOPRIN_"+sGXsfl_70_fel_idx ;
      edtavEstadopdf_Internalname = sPrefix+"vESTADOPDF_"+sGXsfl_70_fel_idx ;
      edtavEstadolsddep_Internalname = sPrefix+"vESTADOLSDDEP_"+sGXsfl_70_fel_idx ;
      edtavEstadocontr_Internalname = sPrefix+"vESTADOCONTR_"+sGXsfl_70_fel_idx ;
      edtavEstadoauxfut_Internalname = sPrefix+"vESTADOAUXFUT_"+sGXsfl_70_fel_idx ;
      edtLiqError_Internalname = sPrefix+"LIQERROR_"+sGXsfl_70_fel_idx ;
      edtLiqDescrip_Internalname = sPrefix+"LIQDESCRIP_"+sGXsfl_70_fel_idx ;
      edtLiqLog_Internalname = sPrefix+"LIQLOG_"+sGXsfl_70_fel_idx ;
      edtLiqSegundos_Internalname = sPrefix+"LIQSEGUNDOS_"+sGXsfl_70_fel_idx ;
      edtLiqImpBruto_Internalname = sPrefix+"LIQIMPBRUTO_"+sGXsfl_70_fel_idx ;
      edtLiqImpNeto_Internalname = sPrefix+"LIQIMPNETO_"+sGXsfl_70_fel_idx ;
      edtavDisplay_Internalname = sPrefix+"vDISPLAY_"+sGXsfl_70_fel_idx ;
      edtavUpdate_Internalname = sPrefix+"vUPDATE_"+sGXsfl_70_fel_idx ;
      edtavVersvg_Internalname = sPrefix+"vVERSVG_"+sGXsfl_70_fel_idx ;
      edtavModificarsvg_Internalname = sPrefix+"vMODIFICARSVG_"+sGXsfl_70_fel_idx ;
   }

   public void sendrow_702( )
   {
      subsflControlProps_702( ) ;
      wb2M0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_70_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_70_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_70_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavProximaaccion_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavProximaaccion_Enabled!=0)&&(edtavProximaaccion_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 71,'"+sPrefix+"',false,'"+sGXsfl_70_idx+"',70)\"" : " ") ;
         ROClassString = edtavProximaaccion_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavProximaaccion_Internalname,GXutil.rtrim( AV45ProximaAccion),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavProximaaccion_Enabled!=0)&&(edtavProximaaccion_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,71);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVPROXIMAACCION.CLICK."+sGXsfl_70_idx+"'","","",edtavProximaaccion_Tooltiptext,"",edtavProximaaccion_Jsonclick,Integer.valueOf(5),edtavProximaaccion_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavProximaaccion_Visible),Integer.valueOf(edtavProximaaccion_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         TempTags = " " + ((cmbavGridactions.getEnabled()!=0)&&(cmbavGridactions.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 72,'"+sPrefix+"',false,'"+sGXsfl_70_idx+"',70)\"" : " ") ;
         if ( ( cmbavGridactions.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "vGRIDACTIONS_" + sGXsfl_70_idx ;
            cmbavGridactions.setName( GXCCtl );
            cmbavGridactions.setWebtags( "" );
            if ( cmbavGridactions.getItemCount() > 0 )
            {
               AV31GridActions = (short)(GXutil.lval( cmbavGridactions.getValidValue(GXutil.trim( GXutil.str( AV31GridActions, 4, 0))))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, cmbavGridactions.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31GridActions), 4, 0));
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavGridactions,cmbavGridactions.getInternalname(),GXutil.trim( GXutil.str( AV31GridActions, 4, 0)),Integer.valueOf(1),cmbavGridactions.getJsonclick(),Integer.valueOf(5),"'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVGRIDACTIONS.CLICK."+sGXsfl_70_idx+"'","int","",Integer.valueOf(-1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","",cmbavGridactions.getThemeClass(),"WWActionGroupColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavGridactions.getEnabled()!=0)&&(cmbavGridactions.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,72);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbavGridactions.setValue( GXutil.trim( GXutil.str( AV31GridActions, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavGridactions.getInternalname(), "Values", cmbavGridactions.ToJavascriptSource(), !bGXsfl_70_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqNro_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqNro_Internalname,GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqNro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqNro_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtEmpCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqNombre_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqNombre_Internalname,A874LiqNombre,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtLiqNombre_Link,"","","",edtLiqNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn ColumnWeightBold","",Integer.valueOf(edtLiqNombre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Descrip","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqFecha_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqFecha_Internalname,localUtil.format(A98LiqFecha, "99/99/9999"),localUtil.format( A98LiqFecha, "99/99/9999"),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqFecha_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqFecha_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqPerPalabra_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqPerPalabra_Internalname,GXutil.rtrim( A748LiqPerPalabra),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqPerPalabra_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqPerPalabra_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqFecPago_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqFecPago_Internalname,localUtil.format(A280LiqFecPago, "99/99/9999"),localUtil.format( A280LiqFecPago, "99/99/9999"),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqFecPago_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqFecPago_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtTLiqDescAux_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTLiqDescAux_Internalname,A2368TLiqDescAux,GXutil.rtrim( localUtil.format( A2368TLiqDescAux, "@!")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtTLiqDescAux_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtTLiqDescAux_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionMedia","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         if ( ( cmbLiqClase.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LIQCLASE_" + sGXsfl_70_idx ;
            cmbLiqClase.setName( GXCCtl );
            cmbLiqClase.setWebtags( "" );
            cmbLiqClase.addItem("0", httpContext.getMessage( "Mensual", ""), (short)(0));
            cmbLiqClase.addItem("1", httpContext.getMessage( "Jornal", ""), (short)(0));
            if ( cmbLiqClase.getItemCount() > 0 )
            {
               A268LiqClase = (byte)(GXutil.lval( cmbLiqClase.getValidValue(GXutil.trim( GXutil.str( A268LiqClase, 1, 0))))) ;
               n268LiqClase = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLiqClase,cmbLiqClase.getInternalname(),GXutil.trim( GXutil.str( A268LiqClase, 1, 0)),Integer.valueOf(1),cmbLiqClase.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLiqClase.setValue( GXutil.trim( GXutil.str( A268LiqClase, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqClase.getInternalname(), "Values", cmbLiqClase.ToJavascriptSource(), !bGXsfl_70_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbLiqModTra.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbLiqModTra.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LIQMODTRA_" + sGXsfl_70_idx ;
            cmbLiqModTra.setName( GXCCtl );
            cmbLiqModTra.setWebtags( "" );
            cmbLiqModTra.addItem("E", httpContext.getMessage( "Empleado", ""), (short)(0));
            cmbLiqModTra.addItem("I", httpContext.getMessage( "Independiente", ""), (short)(0));
            if ( cmbLiqModTra.getItemCount() > 0 )
            {
               A2409LiqModTra = cmbLiqModTra.getValidValue(A2409LiqModTra) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLiqModTra,cmbLiqModTra.getInternalname(),GXutil.rtrim( A2409LiqModTra),Integer.valueOf(1),cmbLiqModTra.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbLiqModTra.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLiqModTra.setValue( GXutil.rtrim( A2409LiqModTra) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqModTra.getInternalname(), "Values", cmbLiqModTra.ToJavascriptSource(), !bGXsfl_70_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbLiqFrecPag.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbLiqFrecPag.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LIQFRECPAG_" + sGXsfl_70_idx ;
            cmbLiqFrecPag.setName( GXCCtl );
            cmbLiqFrecPag.setWebtags( "" );
            cmbLiqFrecPag.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
            cmbLiqFrecPag.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
            cmbLiqFrecPag.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
            cmbLiqFrecPag.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
            if ( cmbLiqFrecPag.getItemCount() > 0 )
            {
               A2414LiqFrecPag = (byte)(GXutil.lval( cmbLiqFrecPag.getValidValue(GXutil.trim( GXutil.str( A2414LiqFrecPag, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLiqFrecPag,cmbLiqFrecPag.getInternalname(),GXutil.trim( GXutil.str( A2414LiqFrecPag, 1, 0)),Integer.valueOf(1),cmbLiqFrecPag.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbLiqFrecPag.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLiqFrecPag.setValue( GXutil.trim( GXutil.str( A2414LiqFrecPag, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqFrecPag.getInternalname(), "Values", cmbLiqFrecPag.ToJavascriptSource(), !bGXsfl_70_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqCntLeg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqCntLeg_Internalname,GXutil.ltrim( localUtil.ntoc( A495LiqCntLeg, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A495LiqCntLeg), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqCntLeg_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLiqCntLeg_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         if ( ( cmbLiqEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LIQESTADO_" + sGXsfl_70_idx ;
            cmbLiqEstado.setName( GXCCtl );
            cmbLiqEstado.setWebtags( "" );
            cmbLiqEstado.addItem("0", httpContext.getMessage( "Pendiente", ""), (short)(0));
            cmbLiqEstado.addItem("1", httpContext.getMessage( "Procesando...", ""), (short)(0));
            cmbLiqEstado.addItem("2", httpContext.getMessage( "Error", ""), (short)(0));
            cmbLiqEstado.addItem("3", httpContext.getMessage( "Completo", ""), (short)(0));
            cmbLiqEstado.addItem("4", httpContext.getMessage( "Cerrada", ""), (short)(0));
            cmbLiqEstado.addItem("5", httpContext.getMessage( "No aplica", ""), (short)(0));
            if ( cmbLiqEstado.getItemCount() > 0 )
            {
               A278LiqEstado = (byte)(GXutil.lval( cmbLiqEstado.getValidValue(GXutil.trim( GXutil.str( A278LiqEstado, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLiqEstado,cmbLiqEstado.getInternalname(),GXutil.trim( GXutil.str( A278LiqEstado, 1, 0)),Integer.valueOf(1),cmbLiqEstado.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLiqEstado.setValue( GXutil.trim( GXutil.str( A278LiqEstado, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqEstado.getInternalname(), "Values", cmbLiqEstado.ToJavascriptSource(), !bGXsfl_70_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         if ( ( cmbLiqLSDDepEst.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LIQLSDDEPEST_" + sGXsfl_70_idx ;
            cmbLiqLSDDepEst.setName( GXCCtl );
            cmbLiqLSDDepEst.setWebtags( "" );
            cmbLiqLSDDepEst.addItem("0", httpContext.getMessage( "Pendiente", ""), (short)(0));
            cmbLiqLSDDepEst.addItem("1", httpContext.getMessage( "Procesando...", ""), (short)(0));
            cmbLiqLSDDepEst.addItem("2", httpContext.getMessage( "Error", ""), (short)(0));
            cmbLiqLSDDepEst.addItem("3", httpContext.getMessage( "Completo", ""), (short)(0));
            cmbLiqLSDDepEst.addItem("4", httpContext.getMessage( "Cerrada", ""), (short)(0));
            cmbLiqLSDDepEst.addItem("5", httpContext.getMessage( "No aplica", ""), (short)(0));
            if ( cmbLiqLSDDepEst.getItemCount() > 0 )
            {
               A2292LiqLSDDepEst = (byte)(GXutil.lval( cmbLiqLSDDepEst.getValidValue(GXutil.trim( GXutil.str( A2292LiqLSDDepEst, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLiqLSDDepEst,cmbLiqLSDDepEst.getInternalname(),GXutil.trim( GXutil.str( A2292LiqLSDDepEst, 1, 0)),Integer.valueOf(1),cmbLiqLSDDepEst.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLiqLSDDepEst.setValue( GXutil.trim( GXutil.str( A2292LiqLSDDepEst, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqLSDDepEst.getInternalname(), "Values", cmbLiqLSDDepEst.ToJavascriptSource(), !bGXsfl_70_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         if ( ( cmbLiqContrEst.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LIQCONTREST_" + sGXsfl_70_idx ;
            cmbLiqContrEst.setName( GXCCtl );
            cmbLiqContrEst.setWebtags( "" );
            cmbLiqContrEst.addItem("0", httpContext.getMessage( "Pendiente", ""), (short)(0));
            cmbLiqContrEst.addItem("1", httpContext.getMessage( "Procesando...", ""), (short)(0));
            cmbLiqContrEst.addItem("2", httpContext.getMessage( "Error", ""), (short)(0));
            cmbLiqContrEst.addItem("3", httpContext.getMessage( "Completo", ""), (short)(0));
            cmbLiqContrEst.addItem("4", httpContext.getMessage( "Cerrada", ""), (short)(0));
            cmbLiqContrEst.addItem("5", httpContext.getMessage( "No aplica", ""), (short)(0));
            if ( cmbLiqContrEst.getItemCount() > 0 )
            {
               A2293LiqContrEst = (byte)(GXutil.lval( cmbLiqContrEst.getValidValue(GXutil.trim( GXutil.str( A2293LiqContrEst, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLiqContrEst,cmbLiqContrEst.getInternalname(),GXutil.trim( GXutil.str( A2293LiqContrEst, 1, 0)),Integer.valueOf(1),cmbLiqContrEst.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLiqContrEst.setValue( GXutil.trim( GXutil.str( A2293LiqContrEst, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqContrEst.getInternalname(), "Values", cmbLiqContrEst.ToJavascriptSource(), !bGXsfl_70_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         if ( ( cmbLiqPDFEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LIQPDFESTADO_" + sGXsfl_70_idx ;
            cmbLiqPDFEstado.setName( GXCCtl );
            cmbLiqPDFEstado.setWebtags( "" );
            cmbLiqPDFEstado.addItem("Completo", httpContext.getMessage( "Completo", ""), (short)(0));
            cmbLiqPDFEstado.addItem("Enviado", httpContext.getMessage( "Enviado", ""), (short)(0));
            cmbLiqPDFEstado.addItem("Pendiente", httpContext.getMessage( "Procesando...", ""), (short)(0));
            cmbLiqPDFEstado.addItem("Error", httpContext.getMessage( "Error", ""), (short)(0));
            cmbLiqPDFEstado.addItem("Manual", httpContext.getMessage( "Manual", ""), (short)(0));
            cmbLiqPDFEstado.addItem("EnEspera", httpContext.getMessage( "Pendiente", ""), (short)(0));
            if ( cmbLiqPDFEstado.getItemCount() > 0 )
            {
               A2180LiqPDFEstado = cmbLiqPDFEstado.getValidValue(A2180LiqPDFEstado) ;
               n2180LiqPDFEstado = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLiqPDFEstado,cmbLiqPDFEstado.getInternalname(),GXutil.rtrim( A2180LiqPDFEstado),Integer.valueOf(1),cmbLiqPDFEstado.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLiqPDFEstado.setValue( GXutil.rtrim( A2180LiqPDFEstado) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqPDFEstado.getInternalname(), "Values", cmbLiqPDFEstado.ToJavascriptSource(), !bGXsfl_70_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         if ( ( cmbLiqAuxEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LIQAUXESTADO_" + sGXsfl_70_idx ;
            cmbLiqAuxEstado.setName( GXCCtl );
            cmbLiqAuxEstado.setWebtags( "" );
            cmbLiqAuxEstado.addItem("0", httpContext.getMessage( "Pendiente", ""), (short)(0));
            cmbLiqAuxEstado.addItem("1", httpContext.getMessage( "Procesando...", ""), (short)(0));
            cmbLiqAuxEstado.addItem("2", httpContext.getMessage( "Error", ""), (short)(0));
            cmbLiqAuxEstado.addItem("3", httpContext.getMessage( "Completo", ""), (short)(0));
            cmbLiqAuxEstado.addItem("4", httpContext.getMessage( "Cerrada", ""), (short)(0));
            cmbLiqAuxEstado.addItem("5", httpContext.getMessage( "No aplica", ""), (short)(0));
            if ( cmbLiqAuxEstado.getItemCount() > 0 )
            {
               A1403LiqAuxEstado = (byte)(GXutil.lval( cmbLiqAuxEstado.getValidValue(GXutil.trim( GXutil.str( A1403LiqAuxEstado, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLiqAuxEstado,cmbLiqAuxEstado.getInternalname(),GXutil.trim( GXutil.str( A1403LiqAuxEstado, 1, 0)),Integer.valueOf(1),cmbLiqAuxEstado.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLiqAuxEstado.setValue( GXutil.trim( GXutil.str( A1403LiqAuxEstado, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqAuxEstado.getInternalname(), "Values", cmbLiqAuxEstado.ToJavascriptSource(), !bGXsfl_70_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEstadoprin_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEstadoprin_Enabled!=0)&&(edtavEstadoprin_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 89,'"+sPrefix+"',false,'"+sGXsfl_70_idx+"',70)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEstadoprin_Internalname,GXutil.rtrim( AV194EstadoPrin),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEstadoprin_Enabled!=0)&&(edtavEstadoprin_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,89);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","",edtavEstadoprin_Tooltiptext,"",edtavEstadoprin_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavEstadoprin_Visible),Integer.valueOf(edtavEstadoprin_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEstadopdf_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEstadopdf_Enabled!=0)&&(edtavEstadopdf_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 90,'"+sPrefix+"',false,'"+sGXsfl_70_idx+"',70)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEstadopdf_Internalname,GXutil.rtrim( AV203EstadoPDF),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEstadopdf_Enabled!=0)&&(edtavEstadopdf_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,90);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","",edtavEstadopdf_Tooltiptext,"",edtavEstadopdf_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavEstadopdf_Visible),Integer.valueOf(edtavEstadopdf_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEstadolsddep_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEstadolsddep_Enabled!=0)&&(edtavEstadolsddep_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 91,'"+sPrefix+"',false,'"+sGXsfl_70_idx+"',70)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEstadolsddep_Internalname,GXutil.rtrim( AV201EstadoLSDDep),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEstadolsddep_Enabled!=0)&&(edtavEstadolsddep_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,91);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","",edtavEstadolsddep_Tooltiptext,"",edtavEstadolsddep_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavEstadolsddep_Visible),Integer.valueOf(edtavEstadolsddep_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEstadocontr_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEstadocontr_Enabled!=0)&&(edtavEstadocontr_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 92,'"+sPrefix+"',false,'"+sGXsfl_70_idx+"',70)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEstadocontr_Internalname,GXutil.rtrim( AV202EstadoContr),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEstadocontr_Enabled!=0)&&(edtavEstadocontr_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,92);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","",edtavEstadocontr_Tooltiptext,"",edtavEstadocontr_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavEstadocontr_Visible),Integer.valueOf(edtavEstadocontr_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEstadoauxfut_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEstadoauxfut_Enabled!=0)&&(edtavEstadoauxfut_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 93,'"+sPrefix+"',false,'"+sGXsfl_70_idx+"',70)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEstadoauxfut_Internalname,GXutil.rtrim( AV204EstadoAuxFut),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEstadoauxfut_Enabled!=0)&&(edtavEstadoauxfut_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,93);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","",edtavEstadoauxfut_Tooltiptext,"",edtavEstadoauxfut_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavEstadoauxfut_Visible),Integer.valueOf(edtavEstadoauxfut_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqError_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqError_Internalname,A766LiqError,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqError_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqError_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"error","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDescrip_Internalname,A271LiqDescrip,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLiqDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLog_Internalname,A1142LiqLog,A1142LiqLog,"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLog_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqSegundos_Internalname,GXutil.ltrim( localUtil.ntoc( A885LiqSegundos, (byte)(5), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A885LiqSegundos, "Z9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqSegundos_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqImpBruto_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqImpBruto_Internalname,GXutil.ltrim( localUtil.ntoc( A497LiqImpBruto, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A497LiqImpBruto, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqImpBruto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLiqImpBruto_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqImpNeto_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqImpNeto_Internalname,GXutil.ltrim( localUtil.ntoc( A496LiqImpNeto, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A496LiqImpNeto, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqImpNeto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLiqImpNeto_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 100,'"+sPrefix+"',false,'"+sGXsfl_70_idx+"',70)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV175Display),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,100);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 101,'"+sPrefix+"',false,'"+sGXsfl_70_idx+"',70)\"" : " ") ;
         ROClassString = edtavUpdate_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV102Update),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,101);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),edtavUpdate_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavVersvg_Enabled!=0)&&(edtavVersvg_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 102,'"+sPrefix+"',false,'"+sGXsfl_70_idx+"',70)\"" : " ") ;
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV173VerSVG),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavVersvg_Enabled!=0)&&(edtavVersvg_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,102);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavModificarsvg_Enabled!=0)&&(edtavModificarsvg_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 103,'"+sPrefix+"',false,'"+sGXsfl_70_idx+"',70)\"" : " ") ;
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV174ModificarSVG),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavModificarsvg_Enabled!=0)&&(edtavModificarsvg_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,103);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(70),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes2M2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_70_idx = ((subGrid_Islastpage==1)&&(nGXsfl_70_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_70_idx+1) ;
         sGXsfl_70_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_70_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_702( ) ;
      }
      /* End function sendrow_702 */
   }

   public void startgridcontrol70( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"70\">") ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavProximaaccion_Class+"\" "+" style=\""+((edtavProximaaccion_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+cmbavGridactions.getThemeClass()+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqNro_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Número", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqFecha_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha de liq.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqPerPalabra_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Periodo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqFecPago_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha de pago", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtTLiqDescAux_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbLiqModTra.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Relación laboral", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbLiqFrecPag.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Frecuencia de pago", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqCntLeg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de recibos", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavEstadoprin_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Recibos", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavEstadopdf_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "PDFs", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavEstadolsddep_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Dep. LSD", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavEstadocontr_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Contr.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavEstadoauxfut_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Otros conceptos aux.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqError_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Error", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Observación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqImpBruto_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Bruto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqImpNeto_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Neto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavUpdate_Class+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV45ProximaAccion));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavProximaaccion_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavProximaaccion_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavProximaaccion_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavProximaaccion_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV31GridActions, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( cmbavGridactions.getThemeClass()));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqNro_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A874LiqNombre);
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtLiqNombre_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqNombre_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A98LiqFecha, "99/99/9999"));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqFecha_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A748LiqPerPalabra));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqPerPalabra_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A280LiqFecPago, "99/99/9999"));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqFecPago_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2368TLiqDescAux);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtTLiqDescAux_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A268LiqClase, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A2409LiqModTra));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbLiqModTra.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2414LiqFrecPag, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbLiqFrecPag.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A495LiqCntLeg, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqCntLeg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A278LiqEstado, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2292LiqLSDDepEst, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2293LiqContrEst, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A2180LiqPDFEstado));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1403LiqAuxEstado, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV194EstadoPrin));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEstadoprin_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavEstadoprin_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavEstadoprin_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV203EstadoPDF));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEstadopdf_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavEstadopdf_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavEstadopdf_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV201EstadoLSDDep));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEstadolsddep_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavEstadolsddep_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavEstadolsddep_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV202EstadoContr));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEstadocontr_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavEstadocontr_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavEstadocontr_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV204EstadoAuxFut));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEstadoauxfut_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavEstadoauxfut_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavEstadoauxfut_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A766LiqError);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqError_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A271LiqDescrip);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1142LiqLog);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A885LiqSegundos, (byte)(5), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A497LiqImpBruto, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqImpBruto_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A496LiqImpNeto, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqImpNeto_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV175Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV102Update));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavUpdate_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV173VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV174ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
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
      edtavLiqrelnro_Internalname = sPrefix+"vLIQRELNRO" ;
      lblButtonexport1_textblock_svg_Internalname = sPrefix+"BUTTONEXPORT1_TEXTBLOCK_SVG" ;
      divButtonexport1_table_svg_Internalname = sPrefix+"BUTTONEXPORT1_TABLE_SVG" ;
      lblButtonexport1_textblock_texto_Internalname = sPrefix+"BUTTONEXPORT1_TEXTBLOCK_TEXTO" ;
      divButtonexport1_table_texto_Internalname = sPrefix+"BUTTONEXPORT1_TABLE_TEXTO" ;
      Buttonexport1_a3lexport_Internalname = sPrefix+"BUTTONEXPORT1_A3LEXPORT" ;
      divButtonexport1_tablecontentbuttonimport_Internalname = sPrefix+"BUTTONEXPORT1_TABLECONTENTBUTTONIMPORT" ;
      Ddo_gridcolumnsselector_Internalname = sPrefix+"DDO_GRIDCOLUMNSSELECTOR" ;
      Ddo_managefilters_Internalname = sPrefix+"DDO_MANAGEFILTERS" ;
      bttBtninsert_Internalname = sPrefix+"BTNINSERT" ;
      bttBtnexport_Internalname = sPrefix+"BTNEXPORT" ;
      lblButtonfilter1_textblock_svg_Internalname = sPrefix+"BUTTONFILTER1_TEXTBLOCK_SVG" ;
      divButtonfilter1_table_svg_Internalname = sPrefix+"BUTTONFILTER1_TABLE_SVG" ;
      lblButtonfilter1_textblock_texto_Internalname = sPrefix+"BUTTONFILTER1_TEXTBLOCK_TEXTO" ;
      divButtonfilter1_table_texto_Internalname = sPrefix+"BUTTONFILTER1_TABLE_TEXTO" ;
      lblButtonfilter1_textblockbadgecount_Internalname = sPrefix+"BUTTONFILTER1_TEXTBLOCKBADGECOUNT" ;
      tblButtonfilter1_tablebadge_Internalname = sPrefix+"BUTTONFILTER1_TABLEBADGE" ;
      divButtonfilter1_filtros_Internalname = sPrefix+"BUTTONFILTER1_FILTROS" ;
      Buttonfilter1_a3lfilter_Internalname = sPrefix+"BUTTONFILTER1_A3LFILTER" ;
      divButtonfilter1_tablecontent_Internalname = sPrefix+"BUTTONFILTER1_TABLECONTENT" ;
      tblTablefiltros_Internalname = sPrefix+"TABLEFILTROS" ;
      divTablefiltrospadre_Internalname = sPrefix+"TABLEFILTROSPADRE" ;
      edtavProximaaccion_Internalname = sPrefix+"vPROXIMAACCION" ;
      cmbavGridactions.setInternalname( sPrefix+"vGRIDACTIONS" );
      edtLiqNro_Internalname = sPrefix+"LIQNRO" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      edtLiqNombre_Internalname = sPrefix+"LIQNOMBRE" ;
      edtLiqFecha_Internalname = sPrefix+"LIQFECHA" ;
      edtLiqPerPalabra_Internalname = sPrefix+"LIQPERPALABRA" ;
      edtLiqFecPago_Internalname = sPrefix+"LIQFECPAGO" ;
      edtTLiqDescAux_Internalname = sPrefix+"TLIQDESCAUX" ;
      cmbLiqClase.setInternalname( sPrefix+"LIQCLASE" );
      cmbLiqModTra.setInternalname( sPrefix+"LIQMODTRA" );
      cmbLiqFrecPag.setInternalname( sPrefix+"LIQFRECPAG" );
      edtLiqCntLeg_Internalname = sPrefix+"LIQCNTLEG" ;
      cmbLiqEstado.setInternalname( sPrefix+"LIQESTADO" );
      cmbLiqLSDDepEst.setInternalname( sPrefix+"LIQLSDDEPEST" );
      cmbLiqContrEst.setInternalname( sPrefix+"LIQCONTREST" );
      cmbLiqPDFEstado.setInternalname( sPrefix+"LIQPDFESTADO" );
      cmbLiqAuxEstado.setInternalname( sPrefix+"LIQAUXESTADO" );
      edtavEstadoprin_Internalname = sPrefix+"vESTADOPRIN" ;
      edtavEstadopdf_Internalname = sPrefix+"vESTADOPDF" ;
      edtavEstadolsddep_Internalname = sPrefix+"vESTADOLSDDEP" ;
      edtavEstadocontr_Internalname = sPrefix+"vESTADOCONTR" ;
      edtavEstadoauxfut_Internalname = sPrefix+"vESTADOAUXFUT" ;
      edtLiqError_Internalname = sPrefix+"LIQERROR" ;
      edtLiqDescrip_Internalname = sPrefix+"LIQDESCRIP" ;
      edtLiqLog_Internalname = sPrefix+"LIQLOG" ;
      edtLiqSegundos_Internalname = sPrefix+"LIQSEGUNDOS" ;
      edtLiqImpBruto_Internalname = sPrefix+"LIQIMPBRUTO" ;
      edtLiqImpNeto_Internalname = sPrefix+"LIQIMPNETO" ;
      edtavDisplay_Internalname = sPrefix+"vDISPLAY" ;
      edtavUpdate_Internalname = sPrefix+"vUPDATE" ;
      edtavVersvg_Internalname = sPrefix+"vVERSVG" ;
      edtavModificarsvg_Internalname = sPrefix+"vMODIFICARSVG" ;
      Gridpaginationbar_Internalname = sPrefix+"GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = sPrefix+"GRIDTABLEWITHPAGINATIONBAR" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
      edtPeriodoLiq_Internalname = sPrefix+"PERIODOLIQ" ;
      Dvelop_confirmpanel_proximaaccion_Internalname = sPrefix+"DVELOP_CONFIRMPANEL_PROXIMAACCION" ;
      tblTabledvelop_confirmpanel_proximaaccion_Internalname = sPrefix+"TABLEDVELOP_CONFIRMPANEL_PROXIMAACCION" ;
      Dvelop_confirmpanel_eliminar_Internalname = sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR" ;
      tblTabledvelop_confirmpanel_eliminar_Internalname = sPrefix+"TABLEDVELOP_CONFIRMPANEL_ELIMINAR" ;
      Dvelop_confirmpanel_reliquidar_Internalname = sPrefix+"DVELOP_CONFIRMPANEL_RELIQUIDAR" ;
      tblTabledvelop_confirmpanel_reliquidar_Internalname = sPrefix+"TABLEDVELOP_CONFIRMPANEL_RELIQUIDAR" ;
      Dvelop_confirmpanel_cerrar_Internalname = sPrefix+"DVELOP_CONFIRMPANEL_CERRAR" ;
      tblTabledvelop_confirmpanel_cerrar_Internalname = sPrefix+"TABLEDVELOP_CONFIRMPANEL_CERRAR" ;
      Dvelop_confirmpanel_reabrir_Internalname = sPrefix+"DVELOP_CONFIRMPANEL_REABRIR" ;
      tblTabledvelop_confirmpanel_reabrir_Internalname = sPrefix+"TABLEDVELOP_CONFIRMPANEL_REABRIR" ;
      Dvelop_confirmpanel_cancelar_Internalname = sPrefix+"DVELOP_CONFIRMPANEL_CANCELAR" ;
      tblTabledvelop_confirmpanel_cancelar_Internalname = sPrefix+"TABLEDVELOP_CONFIRMPANEL_CANCELAR" ;
      Grid_titlescategories_Internalname = sPrefix+"GRID_TITLESCATEGORIES" ;
      Grid_empowerer_Internalname = sPrefix+"GRID_EMPOWERER" ;
      edtavDdo_liqfechaauxdatetext_Internalname = sPrefix+"vDDO_LIQFECHAAUXDATETEXT" ;
      Tfliqfecha_rangepicker_Internalname = sPrefix+"TFLIQFECHA_RANGEPICKER" ;
      divDdo_liqfechaauxdates_Internalname = sPrefix+"DDO_LIQFECHAAUXDATES" ;
      edtavDdo_liqfecpagoauxdatetext_Internalname = sPrefix+"vDDO_LIQFECPAGOAUXDATETEXT" ;
      Tfliqfecpago_rangepicker_Internalname = sPrefix+"TFLIQFECPAGO_RANGEPICKER" ;
      divDdo_liqfecpagoauxdates_Internalname = sPrefix+"DDO_LIQFECPAGOAUXDATES" ;
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
      edtavModificarsvg_Jsonclick = "" ;
      edtavModificarsvg_Columnclass = "WWColumn" ;
      edtavModificarsvg_Link = "" ;
      edtavModificarsvg_Enabled = 1 ;
      edtavModificarsvg_Format = (short)(0) ;
      edtavVersvg_Jsonclick = "" ;
      edtavVersvg_Columnclass = "WWColumn" ;
      edtavVersvg_Link = "" ;
      edtavVersvg_Enabled = 1 ;
      edtavVersvg_Format = (short)(0) ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Class = "Attribute" ;
      edtavUpdate_Enabled = 1 ;
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Enabled = 1 ;
      edtavDisplay_Visible = -1 ;
      edtLiqImpNeto_Jsonclick = "" ;
      edtLiqImpBruto_Jsonclick = "" ;
      edtLiqSegundos_Jsonclick = "" ;
      edtLiqLog_Jsonclick = "" ;
      edtLiqDescrip_Jsonclick = "" ;
      edtLiqError_Jsonclick = "" ;
      edtavEstadoauxfut_Jsonclick = "" ;
      edtavEstadoauxfut_Tooltiptext = "" ;
      edtavEstadoauxfut_Enabled = 1 ;
      edtavEstadocontr_Jsonclick = "" ;
      edtavEstadocontr_Tooltiptext = "" ;
      edtavEstadocontr_Enabled = 1 ;
      edtavEstadolsddep_Jsonclick = "" ;
      edtavEstadolsddep_Tooltiptext = "" ;
      edtavEstadolsddep_Enabled = 1 ;
      edtavEstadopdf_Jsonclick = "" ;
      edtavEstadopdf_Tooltiptext = "" ;
      edtavEstadopdf_Enabled = 1 ;
      edtavEstadoprin_Jsonclick = "" ;
      edtavEstadoprin_Tooltiptext = "" ;
      edtavEstadoprin_Enabled = 1 ;
      cmbLiqAuxEstado.setJsonclick( "" );
      cmbLiqPDFEstado.setJsonclick( "" );
      cmbLiqContrEst.setJsonclick( "" );
      cmbLiqLSDDepEst.setJsonclick( "" );
      cmbLiqEstado.setJsonclick( "" );
      edtLiqCntLeg_Jsonclick = "" ;
      cmbLiqFrecPag.setJsonclick( "" );
      cmbLiqModTra.setJsonclick( "" );
      cmbLiqClase.setJsonclick( "" );
      edtTLiqDescAux_Jsonclick = "" ;
      edtLiqFecPago_Jsonclick = "" ;
      edtLiqPerPalabra_Jsonclick = "" ;
      edtLiqFecha_Jsonclick = "" ;
      edtLiqNombre_Jsonclick = "" ;
      edtLiqNombre_Link = "" ;
      edtEmpCod_Jsonclick = "" ;
      edtLiqNro_Jsonclick = "" ;
      cmbavGridactions.setJsonclick( "" );
      cmbavGridactions.setVisible( -1 );
      cmbavGridactions.setEnabled( 1 );
      cmbavGridactions.setThemeClass( "ConvertToDDO" );
      edtavProximaaccion_Jsonclick = "" ;
      edtavProximaaccion_Class = "Attribute" ;
      edtavProximaaccion_Tooltiptext = "" ;
      edtavProximaaccion_Enabled = 1 ;
      edtavProximaaccion_Visible = -1 ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      lblCouttext_Visible = 1 ;
      divButtonfilter1_tablecontent_Visible = 1 ;
      bttBtnexport_Visible = 1 ;
      bttBtninsert_Visible = 1 ;
      edtavUpdate_Visible = -1 ;
      edtavUpdate_Link = "" ;
      edtavDisplay_Link = "" ;
      tblButtonfilter1_tablebadge_Tooltiptext = "" ;
      lblButtonfilter1_textblockbadgecount_Caption = "2" ;
      tblButtonfilter1_tablebadge_Visible = 1 ;
      lblCouttext_Caption = httpContext.getMessage( "27 registros", "") ;
      edtavModificarsvg_Visible = -1 ;
      edtavVersvg_Visible = -1 ;
      edtLiqImpNeto_Visible = -1 ;
      edtLiqImpBruto_Visible = -1 ;
      edtLiqDescrip_Visible = -1 ;
      edtLiqError_Visible = -1 ;
      edtavEstadoauxfut_Visible = -1 ;
      edtavEstadocontr_Visible = -1 ;
      edtavEstadolsddep_Visible = -1 ;
      edtavEstadopdf_Visible = -1 ;
      edtavEstadoprin_Visible = -1 ;
      edtLiqCntLeg_Visible = -1 ;
      cmbLiqFrecPag.setVisible( -1 );
      cmbLiqModTra.setVisible( -1 );
      edtTLiqDescAux_Visible = -1 ;
      edtLiqFecPago_Visible = -1 ;
      edtLiqPerPalabra_Visible = -1 ;
      edtLiqFecha_Visible = -1 ;
      edtLiqNombre_Visible = -1 ;
      edtLiqNro_Visible = -1 ;
      subGrid_Sortable = (byte)(0) ;
      edtavDdo_liqfecpagoauxdatetext_Jsonclick = "" ;
      edtavDdo_liqfechaauxdatetext_Jsonclick = "" ;
      edtPeriodoLiq_Jsonclick = "" ;
      edtPeriodoLiq_Visible = 1 ;
      edtavLiqrelnro_Jsonclick = "" ;
      edtavLiqrelnro_Enabled = 1 ;
      edtavLiqrelnro_Visible = 1 ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hascategories = GXutil.toBoolean( -1) ;
      Grid_titlescategories_Gridtitlescategories = ";;;;;;;;;;;;;;;;;;Estado;Estado;Estado;Estado;Estado;;;;;;;;;;" ;
      Dvelop_confirmpanel_cancelar_Confirmtype = "1" ;
      Dvelop_confirmpanel_cancelar_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_cancelar_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_cancelar_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_cancelar_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_cancelar_Confirmationtext = "¿Confirma cancelar el proceso de liquidación?" ;
      Dvelop_confirmpanel_cancelar_Title = httpContext.getMessage( "Confirmar", "") ;
      Dvelop_confirmpanel_reabrir_Confirmtype = "1" ;
      Dvelop_confirmpanel_reabrir_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_reabrir_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_reabrir_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_reabrir_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_reabrir_Confirmationtext = "¿Está seguro que desea Re-Abrir la Liquidación?" ;
      Dvelop_confirmpanel_reabrir_Title = httpContext.getMessage( "Re-Abrir Liquidación", "") ;
      Dvelop_confirmpanel_cerrar_Confirmtype = "1" ;
      Dvelop_confirmpanel_cerrar_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_cerrar_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_cerrar_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_cerrar_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_cerrar_Confirmationtext = "¿Está seguro que desea Cerrar la Liquidación?" ;
      Dvelop_confirmpanel_cerrar_Title = httpContext.getMessage( "Cerrar Liquidación", "") ;
      Dvelop_confirmpanel_reliquidar_Confirmtype = "1" ;
      Dvelop_confirmpanel_reliquidar_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_reliquidar_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_reliquidar_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_reliquidar_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_reliquidar_Confirmationtext = "¿Está seguro que desea Re-Liquidar la Liquidación?" ;
      Dvelop_confirmpanel_reliquidar_Title = httpContext.getMessage( "Re-Liquidar", "") ;
      Dvelop_confirmpanel_eliminar_Confirmtype = "1" ;
      Dvelop_confirmpanel_eliminar_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_eliminar_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_eliminar_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_eliminar_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_eliminar_Confirmationtext = "¿Está seguro de que desea eliminar la liquidación?" ;
      Dvelop_confirmpanel_eliminar_Title = httpContext.getMessage( "Eliminar", "") ;
      Dvelop_confirmpanel_proximaaccion_Confirmtype = "1" ;
      Dvelop_confirmpanel_proximaaccion_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_proximaaccion_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_proximaaccion_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_proximaaccion_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_proximaaccion_Confirmationtext = "mensaje" ;
      Dvelop_confirmpanel_proximaaccion_Title = httpContext.getMessage( "titulo", "") ;
      Ddo_grid_Format = "8.0||||||||4.0||||||||-14.2|-14.2" ;
      Ddo_grid_Datalistproc = "LiquidacionWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||||||E:Empleado,I:Independiente|1:Mensual,2:Quincenal,3:Semanal,4:Diaria||||||||||" ;
      Ddo_grid_Allowmultipleselection = "|||T||T|T|T|||||||T|T||" ;
      Ddo_grid_Datalisttype = "|Dynamic||Dynamic||Dynamic|FixedValues|FixedValues|||||||Dynamic|Dynamic||" ;
      Ddo_grid_Includedatalist = "|T||T||T|T|T|||||||T|T||" ;
      Ddo_grid_Filterisrange = "T||P||P||||T||||||||T|T" ;
      Ddo_grid_Filtertype = "Numeric|Character|Date|Character|Date|Character|||Numeric||||||Character|Character|Numeric|Numeric" ;
      Ddo_grid_Includefilter = "T|T|T|T|T|T|||T||||||T|T|T|T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T|T|T|T|T|T|T|T||||||T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "2|3|4|5|6|7|8|9|10||||||11|12|13|14" ;
      Ddo_grid_Columnids = "2:LiqNro|4:LiqNombre|5:LiqFecha|6:LiqPerPalabra|7:LiqFecPago|8:TLiqDescAux|10:LiqModTra|11:LiqFrecPag|12:LiqCntLeg|18:EstadoPrin|19:EstadoPDF|20:EstadoLSDDep|21:EstadoContr|22:EstadoAuxFut|23:LiqError|24:LiqDescrip|27:LiqImpBruto|28:LiqImpNeto" ;
      Ddo_grid_Gridinternalname = "" ;
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
      Ddo_gridcolumnsselector_Caption = httpContext.getMessage( "Columnas", "") ;
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
      GXCCtl = "vGRIDACTIONS_" + sGXsfl_70_idx ;
      cmbavGridactions.setName( GXCCtl );
      cmbavGridactions.setWebtags( "" );
      if ( cmbavGridactions.getItemCount() > 0 )
      {
      }
      GXCCtl = "LIQCLASE_" + sGXsfl_70_idx ;
      cmbLiqClase.setName( GXCCtl );
      cmbLiqClase.setWebtags( "" );
      cmbLiqClase.addItem("0", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbLiqClase.addItem("1", httpContext.getMessage( "Jornal", ""), (short)(0));
      if ( cmbLiqClase.getItemCount() > 0 )
      {
      }
      GXCCtl = "LIQMODTRA_" + sGXsfl_70_idx ;
      cmbLiqModTra.setName( GXCCtl );
      cmbLiqModTra.setWebtags( "" );
      cmbLiqModTra.addItem("E", httpContext.getMessage( "Empleado", ""), (short)(0));
      cmbLiqModTra.addItem("I", httpContext.getMessage( "Independiente", ""), (short)(0));
      if ( cmbLiqModTra.getItemCount() > 0 )
      {
      }
      GXCCtl = "LIQFRECPAG_" + sGXsfl_70_idx ;
      cmbLiqFrecPag.setName( GXCCtl );
      cmbLiqFrecPag.setWebtags( "" );
      cmbLiqFrecPag.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbLiqFrecPag.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbLiqFrecPag.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbLiqFrecPag.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbLiqFrecPag.getItemCount() > 0 )
      {
      }
      GXCCtl = "LIQESTADO_" + sGXsfl_70_idx ;
      cmbLiqEstado.setName( GXCCtl );
      cmbLiqEstado.setWebtags( "" );
      cmbLiqEstado.addItem("0", httpContext.getMessage( "Pendiente", ""), (short)(0));
      cmbLiqEstado.addItem("1", httpContext.getMessage( "Procesando...", ""), (short)(0));
      cmbLiqEstado.addItem("2", httpContext.getMessage( "Error", ""), (short)(0));
      cmbLiqEstado.addItem("3", httpContext.getMessage( "Completo", ""), (short)(0));
      cmbLiqEstado.addItem("4", httpContext.getMessage( "Cerrada", ""), (short)(0));
      cmbLiqEstado.addItem("5", httpContext.getMessage( "No aplica", ""), (short)(0));
      if ( cmbLiqEstado.getItemCount() > 0 )
      {
      }
      GXCCtl = "LIQLSDDEPEST_" + sGXsfl_70_idx ;
      cmbLiqLSDDepEst.setName( GXCCtl );
      cmbLiqLSDDepEst.setWebtags( "" );
      cmbLiqLSDDepEst.addItem("0", httpContext.getMessage( "Pendiente", ""), (short)(0));
      cmbLiqLSDDepEst.addItem("1", httpContext.getMessage( "Procesando...", ""), (short)(0));
      cmbLiqLSDDepEst.addItem("2", httpContext.getMessage( "Error", ""), (short)(0));
      cmbLiqLSDDepEst.addItem("3", httpContext.getMessage( "Completo", ""), (short)(0));
      cmbLiqLSDDepEst.addItem("4", httpContext.getMessage( "Cerrada", ""), (short)(0));
      cmbLiqLSDDepEst.addItem("5", httpContext.getMessage( "No aplica", ""), (short)(0));
      if ( cmbLiqLSDDepEst.getItemCount() > 0 )
      {
      }
      GXCCtl = "LIQCONTREST_" + sGXsfl_70_idx ;
      cmbLiqContrEst.setName( GXCCtl );
      cmbLiqContrEst.setWebtags( "" );
      cmbLiqContrEst.addItem("0", httpContext.getMessage( "Pendiente", ""), (short)(0));
      cmbLiqContrEst.addItem("1", httpContext.getMessage( "Procesando...", ""), (short)(0));
      cmbLiqContrEst.addItem("2", httpContext.getMessage( "Error", ""), (short)(0));
      cmbLiqContrEst.addItem("3", httpContext.getMessage( "Completo", ""), (short)(0));
      cmbLiqContrEst.addItem("4", httpContext.getMessage( "Cerrada", ""), (short)(0));
      cmbLiqContrEst.addItem("5", httpContext.getMessage( "No aplica", ""), (short)(0));
      if ( cmbLiqContrEst.getItemCount() > 0 )
      {
      }
      GXCCtl = "LIQPDFESTADO_" + sGXsfl_70_idx ;
      cmbLiqPDFEstado.setName( GXCCtl );
      cmbLiqPDFEstado.setWebtags( "" );
      cmbLiqPDFEstado.addItem("Completo", httpContext.getMessage( "Completo", ""), (short)(0));
      cmbLiqPDFEstado.addItem("Enviado", httpContext.getMessage( "Enviado", ""), (short)(0));
      cmbLiqPDFEstado.addItem("Pendiente", httpContext.getMessage( "Procesando...", ""), (short)(0));
      cmbLiqPDFEstado.addItem("Error", httpContext.getMessage( "Error", ""), (short)(0));
      cmbLiqPDFEstado.addItem("Manual", httpContext.getMessage( "Manual", ""), (short)(0));
      cmbLiqPDFEstado.addItem("EnEspera", httpContext.getMessage( "Pendiente", ""), (short)(0));
      if ( cmbLiqPDFEstado.getItemCount() > 0 )
      {
      }
      GXCCtl = "LIQAUXESTADO_" + sGXsfl_70_idx ;
      cmbLiqAuxEstado.setName( GXCCtl );
      cmbLiqAuxEstado.setWebtags( "" );
      cmbLiqAuxEstado.addItem("0", httpContext.getMessage( "Pendiente", ""), (short)(0));
      cmbLiqAuxEstado.addItem("1", httpContext.getMessage( "Procesando...", ""), (short)(0));
      cmbLiqAuxEstado.addItem("2", httpContext.getMessage( "Error", ""), (short)(0));
      cmbLiqAuxEstado.addItem("3", httpContext.getMessage( "Completo", ""), (short)(0));
      cmbLiqAuxEstado.addItem("4", httpContext.getMessage( "Cerrada", ""), (short)(0));
      cmbLiqAuxEstado.addItem("5", httpContext.getMessage( "No aplica", ""), (short)(0));
      if ( cmbLiqAuxEstado.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'sPrefix'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV231Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV176MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''},{av:'AV162PeriodoLiq',fld:'vPERIODOLIQ',pic:''},{av:'AV185LiqRelNro',fld:'vLIQRELNRO',pic:'ZZZZZZZ9'},{av:'AV74TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV75TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV139TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV141TFLiqNombre_Sel',fld:'vTFLIQNOMBRE_SEL',pic:''},{av:'AV66TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV67TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV113TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV114TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV68TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV69TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV216TFTLiqDescAux',fld:'vTFTLIQDESCAUX',pic:'@!'},{av:'AV217TFTLiqDescAux_Sels',fld:'vTFTLIQDESCAUX_SELS',pic:''},{av:'AV226TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV228TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV56TFLiqCntLeg',fld:'vTFLIQCNTLEG',pic:'ZZZ9'},{av:'AV57TFLiqCntLeg_To',fld:'vTFLIQCNTLEG_TO',pic:'ZZZ9'},{av:'AV119TFLiqError',fld:'vTFLIQERROR',pic:''},{av:'AV120TFLiqError_Sels',fld:'vTFLIQERROR_SELS',pic:''},{av:'AV58TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV60TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV70TFLiqImpBruto',fld:'vTFLIQIMPBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV71TFLiqImpBruto_To',fld:'vTFLIQIMPBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV72TFLiqImpNeto',fld:'vTFLIQIMPNETO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TFLiqImpNeto_To',fld:'vTFLIQIMPNETO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV43OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV189collectionLegNumero',fld:'vCOLLECTIONLEGNUMERO',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:'',hsh:true},{av:'A719LiqFecImp',fld:'LIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'A361LiqGenInter',fld:'LIQGENINTER',pic:'',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'cmbLiqEstado'},{av:'A278LiqEstado',fld:'LIQESTADO',pic:'9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLiqNro_Visible',ctrl:'LIQNRO',prop:'Visible'},{av:'edtLiqNombre_Visible',ctrl:'LIQNOMBRE',prop:'Visible'},{av:'edtLiqFecha_Visible',ctrl:'LIQFECHA',prop:'Visible'},{av:'edtLiqPerPalabra_Visible',ctrl:'LIQPERPALABRA',prop:'Visible'},{av:'edtLiqFecPago_Visible',ctrl:'LIQFECPAGO',prop:'Visible'},{av:'edtTLiqDescAux_Visible',ctrl:'TLIQDESCAUX',prop:'Visible'},{av:'cmbLiqModTra'},{av:'cmbLiqFrecPag'},{av:'edtLiqCntLeg_Visible',ctrl:'LIQCNTLEG',prop:'Visible'},{av:'edtavEstadoprin_Visible',ctrl:'vESTADOPRIN',prop:'Visible'},{av:'edtavEstadopdf_Visible',ctrl:'vESTADOPDF',prop:'Visible'},{av:'edtavEstadolsddep_Visible',ctrl:'vESTADOLSDDEP',prop:'Visible'},{av:'edtavEstadocontr_Visible',ctrl:'vESTADOCONTR',prop:'Visible'},{av:'edtavEstadoauxfut_Visible',ctrl:'vESTADOAUXFUT',prop:'Visible'},{av:'edtLiqError_Visible',ctrl:'LIQERROR',prop:'Visible'},{av:'edtLiqDescrip_Visible',ctrl:'LIQDESCRIP',prop:'Visible'},{av:'edtLiqImpBruto_Visible',ctrl:'LIQIMPBRUTO',prop:'Visible'},{av:'edtLiqImpNeto_Visible',ctrl:'LIQIMPNETO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV33GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV34GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV32GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV121ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e132M2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV231Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV176MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''},{av:'AV162PeriodoLiq',fld:'vPERIODOLIQ',pic:''},{av:'AV185LiqRelNro',fld:'vLIQRELNRO',pic:'ZZZZZZZ9'},{av:'AV74TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV75TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV139TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV141TFLiqNombre_Sel',fld:'vTFLIQNOMBRE_SEL',pic:''},{av:'AV66TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV67TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV113TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV114TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV68TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV69TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV216TFTLiqDescAux',fld:'vTFTLIQDESCAUX',pic:'@!'},{av:'AV217TFTLiqDescAux_Sels',fld:'vTFTLIQDESCAUX_SELS',pic:''},{av:'AV226TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV228TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV56TFLiqCntLeg',fld:'vTFLIQCNTLEG',pic:'ZZZ9'},{av:'AV57TFLiqCntLeg_To',fld:'vTFLIQCNTLEG_TO',pic:'ZZZ9'},{av:'AV119TFLiqError',fld:'vTFLIQERROR',pic:''},{av:'AV120TFLiqError_Sels',fld:'vTFLIQERROR_SELS',pic:''},{av:'AV58TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV60TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV70TFLiqImpBruto',fld:'vTFLIQIMPBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV71TFLiqImpBruto_To',fld:'vTFLIQIMPBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV72TFLiqImpNeto',fld:'vTFLIQIMPNETO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TFLiqImpNeto_To',fld:'vTFLIQIMPNETO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV43OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV189collectionLegNumero',fld:'vCOLLECTIONLEGNUMERO',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:'',hsh:true},{av:'A719LiqFecImp',fld:'LIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'A361LiqGenInter',fld:'LIQGENINTER',pic:'',hsh:true},{av:'sPrefix'},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e142M2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV231Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV176MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''},{av:'AV162PeriodoLiq',fld:'vPERIODOLIQ',pic:''},{av:'AV185LiqRelNro',fld:'vLIQRELNRO',pic:'ZZZZZZZ9'},{av:'AV74TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV75TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV139TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV141TFLiqNombre_Sel',fld:'vTFLIQNOMBRE_SEL',pic:''},{av:'AV66TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV67TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV113TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV114TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV68TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV69TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV216TFTLiqDescAux',fld:'vTFTLIQDESCAUX',pic:'@!'},{av:'AV217TFTLiqDescAux_Sels',fld:'vTFTLIQDESCAUX_SELS',pic:''},{av:'AV226TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV228TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV56TFLiqCntLeg',fld:'vTFLIQCNTLEG',pic:'ZZZ9'},{av:'AV57TFLiqCntLeg_To',fld:'vTFLIQCNTLEG_TO',pic:'ZZZ9'},{av:'AV119TFLiqError',fld:'vTFLIQERROR',pic:''},{av:'AV120TFLiqError_Sels',fld:'vTFLIQERROR_SELS',pic:''},{av:'AV58TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV60TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV70TFLiqImpBruto',fld:'vTFLIQIMPBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV71TFLiqImpBruto_To',fld:'vTFLIQIMPBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV72TFLiqImpNeto',fld:'vTFLIQIMPNETO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TFLiqImpNeto_To',fld:'vTFLIQIMPNETO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV43OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV189collectionLegNumero',fld:'vCOLLECTIONLEGNUMERO',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:'',hsh:true},{av:'A719LiqFecImp',fld:'LIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'A361LiqGenInter',fld:'LIQGENINTER',pic:'',hsh:true},{av:'sPrefix'},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e152M2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV231Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV176MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''},{av:'AV162PeriodoLiq',fld:'vPERIODOLIQ',pic:''},{av:'AV185LiqRelNro',fld:'vLIQRELNRO',pic:'ZZZZZZZ9'},{av:'AV74TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV75TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV139TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV141TFLiqNombre_Sel',fld:'vTFLIQNOMBRE_SEL',pic:''},{av:'AV66TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV67TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV113TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV114TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV68TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV69TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV216TFTLiqDescAux',fld:'vTFTLIQDESCAUX',pic:'@!'},{av:'AV217TFTLiqDescAux_Sels',fld:'vTFTLIQDESCAUX_SELS',pic:''},{av:'AV226TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV228TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV56TFLiqCntLeg',fld:'vTFLIQCNTLEG',pic:'ZZZ9'},{av:'AV57TFLiqCntLeg_To',fld:'vTFLIQCNTLEG_TO',pic:'ZZZ9'},{av:'AV119TFLiqError',fld:'vTFLIQERROR',pic:''},{av:'AV120TFLiqError_Sels',fld:'vTFLIQERROR_SELS',pic:''},{av:'AV58TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV60TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV70TFLiqImpBruto',fld:'vTFLIQIMPBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV71TFLiqImpBruto_To',fld:'vTFLIQIMPBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV72TFLiqImpNeto',fld:'vTFLIQIMPNETO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TFLiqImpNeto_To',fld:'vTFLIQIMPNETO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV43OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV189collectionLegNumero',fld:'vCOLLECTIONLEGNUMERO',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:'',hsh:true},{av:'A719LiqFecImp',fld:'LIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'A361LiqGenInter',fld:'LIQGENINTER',pic:'',hsh:true},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV41OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV43OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV72TFLiqImpNeto',fld:'vTFLIQIMPNETO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TFLiqImpNeto_To',fld:'vTFLIQIMPNETO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV70TFLiqImpBruto',fld:'vTFLIQIMPBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV71TFLiqImpBruto_To',fld:'vTFLIQIMPBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV58TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV61TFLiqDescrip_SelsJson',fld:'vTFLIQDESCRIP_SELSJSON',pic:''},{av:'AV60TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV119TFLiqError',fld:'vTFLIQERROR',pic:''},{av:'AV118TFLiqError_SelsJson',fld:'vTFLIQERROR_SELSJSON',pic:''},{av:'AV120TFLiqError_Sels',fld:'vTFLIQERROR_SELS',pic:''},{av:'AV56TFLiqCntLeg',fld:'vTFLIQCNTLEG',pic:'ZZZ9'},{av:'AV57TFLiqCntLeg_To',fld:'vTFLIQCNTLEG_TO',pic:'ZZZ9'},{av:'AV227TFLiqFrecPag_SelsJson',fld:'vTFLIQFRECPAG_SELSJSON',pic:''},{av:'AV228TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV225TFLiqModTra_SelsJson',fld:'vTFLIQMODTRA_SELSJSON',pic:''},{av:'AV226TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV216TFTLiqDescAux',fld:'vTFTLIQDESCAUX',pic:'@!'},{av:'AV215TFTLiqDescAux_SelsJson',fld:'vTFTLIQDESCAUX_SELSJSON',pic:''},{av:'AV217TFTLiqDescAux_Sels',fld:'vTFTLIQDESCAUX_SELS',pic:''},{av:'AV68TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV69TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV113TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV112TFLiqPerPalabra_SelsJson',fld:'vTFLIQPERPALABRA_SELSJSON',pic:''},{av:'AV114TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV66TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV67TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV139TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV141TFLiqNombre_Sel',fld:'vTFLIQNOMBRE_SEL',pic:''},{av:'AV74TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV75TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e272M2',iparms:[{av:'cmbLiqEstado'},{av:'A278LiqEstado',fld:'LIQESTADO',pic:'9',hsh:true},{av:'A719LiqFecImp',fld:'LIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'cmbLiqAuxEstado'},{av:'A1403LiqAuxEstado',fld:'LIQAUXESTADO',pic:'9'},{av:'cmbLiqPDFEstado'},{av:'A2180LiqPDFEstado',fld:'LIQPDFESTADO',pic:''},{av:'cmbLiqLSDDepEst'},{av:'A2292LiqLSDDepEst',fld:'LIQLSDDEPEST',pic:'9'},{av:'cmbLiqContrEst'},{av:'A2293LiqContrEst',fld:'LIQCONTREST',pic:'9'},{av:'AV176MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:'',hsh:true},{av:'A361LiqGenInter',fld:'LIQGENINTER',pic:'',hsh:true},{av:'A766LiqError',fld:'LIQERROR',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV45ProximaAccion',fld:'vPROXIMAACCION',pic:''},{av:'edtavProximaaccion_Class',ctrl:'vPROXIMAACCION',prop:'Class'},{av:'cmbavGridactions'},{av:'AV31GridActions',fld:'vGRIDACTIONS',pic:'ZZZ9'},{av:'AV175Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'AV102Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'edtavUpdate_Class',ctrl:'vUPDATE',prop:'Class'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV173VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtLiqNombre_Link',ctrl:'LIQNOMBRE',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV174ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavProximaaccion_Visible',ctrl:'vPROXIMAACCION',prop:'Visible'},{av:'edtavProximaaccion_Tooltiptext',ctrl:'vPROXIMAACCION',prop:'Tooltiptext'},{av:'AV194EstadoPrin',fld:'vESTADOPRIN',pic:''},{av:'AV201EstadoLSDDep',fld:'vESTADOLSDDEP',pic:''},{av:'AV202EstadoContr',fld:'vESTADOCONTR',pic:''},{av:'AV203EstadoPDF',fld:'vESTADOPDF',pic:''},{av:'AV204EstadoAuxFut',fld:'vESTADOAUXFUT',pic:''},{av:'edtavEstadoprin_Tooltiptext',ctrl:'vESTADOPRIN',prop:'Tooltiptext'},{av:'edtavEstadopdf_Tooltiptext',ctrl:'vESTADOPDF',prop:'Tooltiptext'},{av:'edtavEstadolsddep_Tooltiptext',ctrl:'vESTADOLSDDEP',prop:'Tooltiptext'},{av:'edtavEstadocontr_Tooltiptext',ctrl:'vESTADOCONTR',prop:'Tooltiptext'},{av:'edtavEstadoauxfut_Tooltiptext',ctrl:'vESTADOAUXFUT',prop:'Tooltiptext'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e112M2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV231Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV176MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''},{av:'AV162PeriodoLiq',fld:'vPERIODOLIQ',pic:''},{av:'AV185LiqRelNro',fld:'vLIQRELNRO',pic:'ZZZZZZZ9'},{av:'AV74TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV75TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV139TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV141TFLiqNombre_Sel',fld:'vTFLIQNOMBRE_SEL',pic:''},{av:'AV66TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV67TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV113TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV114TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV68TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV69TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV216TFTLiqDescAux',fld:'vTFTLIQDESCAUX',pic:'@!'},{av:'AV217TFTLiqDescAux_Sels',fld:'vTFTLIQDESCAUX_SELS',pic:''},{av:'AV226TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV228TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV56TFLiqCntLeg',fld:'vTFLIQCNTLEG',pic:'ZZZ9'},{av:'AV57TFLiqCntLeg_To',fld:'vTFLIQCNTLEG_TO',pic:'ZZZ9'},{av:'AV119TFLiqError',fld:'vTFLIQERROR',pic:''},{av:'AV120TFLiqError_Sels',fld:'vTFLIQERROR_SELS',pic:''},{av:'AV58TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV60TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV70TFLiqImpBruto',fld:'vTFLIQIMPBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV71TFLiqImpBruto_To',fld:'vTFLIQIMPBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV72TFLiqImpNeto',fld:'vTFLIQIMPNETO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TFLiqImpNeto_To',fld:'vTFLIQIMPNETO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV43OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV189collectionLegNumero',fld:'vCOLLECTIONLEGNUMERO',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:'',hsh:true},{av:'A719LiqFecImp',fld:'LIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'A361LiqGenInter',fld:'LIQGENINTER',pic:'',hsh:true},{av:'sPrefix'},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'cmbLiqEstado'},{av:'A278LiqEstado',fld:'LIQESTADO',pic:'9',hsh:true}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtLiqNro_Visible',ctrl:'LIQNRO',prop:'Visible'},{av:'edtLiqNombre_Visible',ctrl:'LIQNOMBRE',prop:'Visible'},{av:'edtLiqFecha_Visible',ctrl:'LIQFECHA',prop:'Visible'},{av:'edtLiqPerPalabra_Visible',ctrl:'LIQPERPALABRA',prop:'Visible'},{av:'edtLiqFecPago_Visible',ctrl:'LIQFECPAGO',prop:'Visible'},{av:'edtTLiqDescAux_Visible',ctrl:'TLIQDESCAUX',prop:'Visible'},{av:'cmbLiqModTra'},{av:'cmbLiqFrecPag'},{av:'edtLiqCntLeg_Visible',ctrl:'LIQCNTLEG',prop:'Visible'},{av:'edtavEstadoprin_Visible',ctrl:'vESTADOPRIN',prop:'Visible'},{av:'edtavEstadopdf_Visible',ctrl:'vESTADOPDF',prop:'Visible'},{av:'edtavEstadolsddep_Visible',ctrl:'vESTADOLSDDEP',prop:'Visible'},{av:'edtavEstadocontr_Visible',ctrl:'vESTADOCONTR',prop:'Visible'},{av:'edtavEstadoauxfut_Visible',ctrl:'vESTADOAUXFUT',prop:'Visible'},{av:'edtLiqError_Visible',ctrl:'LIQERROR',prop:'Visible'},{av:'edtLiqDescrip_Visible',ctrl:'LIQDESCRIP',prop:'Visible'},{av:'edtLiqImpBruto_Visible',ctrl:'LIQIMPBRUTO',prop:'Visible'},{av:'edtLiqImpNeto_Visible',ctrl:'LIQIMPNETO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV33GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV34GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV32GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV121ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e122M2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV231Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV176MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''},{av:'AV162PeriodoLiq',fld:'vPERIODOLIQ',pic:''},{av:'AV185LiqRelNro',fld:'vLIQRELNRO',pic:'ZZZZZZZ9'},{av:'AV74TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV75TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV139TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV141TFLiqNombre_Sel',fld:'vTFLIQNOMBRE_SEL',pic:''},{av:'AV66TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV67TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV113TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV114TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV68TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV69TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV216TFTLiqDescAux',fld:'vTFTLIQDESCAUX',pic:'@!'},{av:'AV217TFTLiqDescAux_Sels',fld:'vTFTLIQDESCAUX_SELS',pic:''},{av:'AV226TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV228TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV56TFLiqCntLeg',fld:'vTFLIQCNTLEG',pic:'ZZZ9'},{av:'AV57TFLiqCntLeg_To',fld:'vTFLIQCNTLEG_TO',pic:'ZZZ9'},{av:'AV119TFLiqError',fld:'vTFLIQERROR',pic:''},{av:'AV120TFLiqError_Sels',fld:'vTFLIQERROR_SELS',pic:''},{av:'AV58TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV60TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV70TFLiqImpBruto',fld:'vTFLIQIMPBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV71TFLiqImpBruto_To',fld:'vTFLIQIMPBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV72TFLiqImpNeto',fld:'vTFLIQIMPNETO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TFLiqImpNeto_To',fld:'vTFLIQIMPNETO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV43OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV189collectionLegNumero',fld:'vCOLLECTIONLEGNUMERO',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:'',hsh:true},{av:'A719LiqFecImp',fld:'LIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'A361LiqGenInter',fld:'LIQGENINTER',pic:'',hsh:true},{av:'sPrefix'},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV112TFLiqPerPalabra_SelsJson',fld:'vTFLIQPERPALABRA_SELSJSON',pic:''},{av:'AV215TFTLiqDescAux_SelsJson',fld:'vTFTLIQDESCAUX_SELSJSON',pic:''},{av:'AV225TFLiqModTra_SelsJson',fld:'vTFLIQMODTRA_SELSJSON',pic:''},{av:'AV227TFLiqFrecPag_SelsJson',fld:'vTFLIQFRECPAG_SELSJSON',pic:''},{av:'AV118TFLiqError_SelsJson',fld:'vTFLIQERROR_SELSJSON',pic:''},{av:'AV61TFLiqDescrip_SelsJson',fld:'vTFLIQDESCRIP_SELSJSON',pic:''},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'cmbLiqEstado'},{av:'A278LiqEstado',fld:'LIQESTADO',pic:'9',hsh:true}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''},{av:'AV41OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV43OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV185LiqRelNro',fld:'vLIQRELNRO',pic:'ZZZZZZZ9'},{av:'AV74TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV75TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV139TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV141TFLiqNombre_Sel',fld:'vTFLIQNOMBRE_SEL',pic:''},{av:'AV66TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV67TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV113TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV114TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV68TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV69TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV216TFTLiqDescAux',fld:'vTFTLIQDESCAUX',pic:'@!'},{av:'AV217TFTLiqDescAux_Sels',fld:'vTFTLIQDESCAUX_SELS',pic:''},{av:'AV226TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV228TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV56TFLiqCntLeg',fld:'vTFLIQCNTLEG',pic:'ZZZ9'},{av:'AV57TFLiqCntLeg_To',fld:'vTFLIQCNTLEG_TO',pic:'ZZZ9'},{av:'AV119TFLiqError',fld:'vTFLIQERROR',pic:''},{av:'AV120TFLiqError_Sels',fld:'vTFLIQERROR_SELS',pic:''},{av:'AV58TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV60TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV70TFLiqImpBruto',fld:'vTFLIQIMPBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV71TFLiqImpBruto_To',fld:'vTFLIQIMPBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV72TFLiqImpNeto',fld:'vTFLIQIMPNETO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TFLiqImpNeto_To',fld:'vTFLIQIMPNETO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV61TFLiqDescrip_SelsJson',fld:'vTFLIQDESCRIP_SELSJSON',pic:''},{av:'AV118TFLiqError_SelsJson',fld:'vTFLIQERROR_SELSJSON',pic:''},{av:'AV227TFLiqFrecPag_SelsJson',fld:'vTFLIQFRECPAG_SELSJSON',pic:''},{av:'AV225TFLiqModTra_SelsJson',fld:'vTFLIQMODTRA_SELSJSON',pic:''},{av:'AV215TFTLiqDescAux_SelsJson',fld:'vTFTLIQDESCAUX_SELSJSON',pic:''},{av:'AV112TFLiqPerPalabra_SelsJson',fld:'vTFLIQPERPALABRA_SELSJSON',pic:''},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLiqNro_Visible',ctrl:'LIQNRO',prop:'Visible'},{av:'edtLiqNombre_Visible',ctrl:'LIQNOMBRE',prop:'Visible'},{av:'edtLiqFecha_Visible',ctrl:'LIQFECHA',prop:'Visible'},{av:'edtLiqPerPalabra_Visible',ctrl:'LIQPERPALABRA',prop:'Visible'},{av:'edtLiqFecPago_Visible',ctrl:'LIQFECPAGO',prop:'Visible'},{av:'edtTLiqDescAux_Visible',ctrl:'TLIQDESCAUX',prop:'Visible'},{av:'cmbLiqModTra'},{av:'cmbLiqFrecPag'},{av:'edtLiqCntLeg_Visible',ctrl:'LIQCNTLEG',prop:'Visible'},{av:'edtavEstadoprin_Visible',ctrl:'vESTADOPRIN',prop:'Visible'},{av:'edtavEstadopdf_Visible',ctrl:'vESTADOPDF',prop:'Visible'},{av:'edtavEstadolsddep_Visible',ctrl:'vESTADOLSDDEP',prop:'Visible'},{av:'edtavEstadocontr_Visible',ctrl:'vESTADOCONTR',prop:'Visible'},{av:'edtavEstadoauxfut_Visible',ctrl:'vESTADOAUXFUT',prop:'Visible'},{av:'edtLiqError_Visible',ctrl:'LIQERROR',prop:'Visible'},{av:'edtLiqDescrip_Visible',ctrl:'LIQDESCRIP',prop:'Visible'},{av:'edtLiqImpBruto_Visible',ctrl:'LIQIMPBRUTO',prop:'Visible'},{av:'edtLiqImpNeto_Visible',ctrl:'LIQIMPNETO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV33GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV34GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV32GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV121ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("VPROXIMAACCION.CLICK","{handler:'e282M2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV231Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV176MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''},{av:'AV162PeriodoLiq',fld:'vPERIODOLIQ',pic:''},{av:'AV185LiqRelNro',fld:'vLIQRELNRO',pic:'ZZZZZZZ9'},{av:'AV74TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV75TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV139TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV141TFLiqNombre_Sel',fld:'vTFLIQNOMBRE_SEL',pic:''},{av:'AV66TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV67TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV113TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV114TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV68TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV69TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV216TFTLiqDescAux',fld:'vTFTLIQDESCAUX',pic:'@!'},{av:'AV217TFTLiqDescAux_Sels',fld:'vTFTLIQDESCAUX_SELS',pic:''},{av:'AV226TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV228TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV56TFLiqCntLeg',fld:'vTFLIQCNTLEG',pic:'ZZZ9'},{av:'AV57TFLiqCntLeg_To',fld:'vTFLIQCNTLEG_TO',pic:'ZZZ9'},{av:'AV119TFLiqError',fld:'vTFLIQERROR',pic:''},{av:'AV120TFLiqError_Sels',fld:'vTFLIQERROR_SELS',pic:''},{av:'AV58TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV60TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV70TFLiqImpBruto',fld:'vTFLIQIMPBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV71TFLiqImpBruto_To',fld:'vTFLIQIMPBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV72TFLiqImpNeto',fld:'vTFLIQIMPNETO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TFLiqImpNeto_To',fld:'vTFLIQIMPNETO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV43OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV189collectionLegNumero',fld:'vCOLLECTIONLEGNUMERO',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:'',hsh:true},{av:'A719LiqFecImp',fld:'LIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'A361LiqGenInter',fld:'LIQGENINTER',pic:'',hsh:true},{av:'sPrefix'},{av:'cmbLiqEstado'},{av:'A278LiqEstado',fld:'LIQESTADO',pic:'9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("VPROXIMAACCION.CLICK",",oparms:[{av:'Dvelop_confirmpanel_proximaaccion_Title',ctrl:'DVELOP_CONFIRMPANEL_PROXIMAACCION',prop:'Title'},{av:'Dvelop_confirmpanel_proximaaccion_Confirmationtext',ctrl:'DVELOP_CONFIRMPANEL_PROXIMAACCION',prop:'ConfirmationText'},{av:'AV8CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV28EmpCod_Selected',fld:'vEMPCOD_SELECTED',pic:'ZZZ9'},{av:'AV40LiqNro_Selected',fld:'vLIQNRO_SELECTED',pic:'ZZZZZZZ9'},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLiqNro_Visible',ctrl:'LIQNRO',prop:'Visible'},{av:'edtLiqNombre_Visible',ctrl:'LIQNOMBRE',prop:'Visible'},{av:'edtLiqFecha_Visible',ctrl:'LIQFECHA',prop:'Visible'},{av:'edtLiqPerPalabra_Visible',ctrl:'LIQPERPALABRA',prop:'Visible'},{av:'edtLiqFecPago_Visible',ctrl:'LIQFECPAGO',prop:'Visible'},{av:'edtTLiqDescAux_Visible',ctrl:'TLIQDESCAUX',prop:'Visible'},{av:'cmbLiqModTra'},{av:'cmbLiqFrecPag'},{av:'edtLiqCntLeg_Visible',ctrl:'LIQCNTLEG',prop:'Visible'},{av:'edtavEstadoprin_Visible',ctrl:'vESTADOPRIN',prop:'Visible'},{av:'edtavEstadopdf_Visible',ctrl:'vESTADOPDF',prop:'Visible'},{av:'edtavEstadolsddep_Visible',ctrl:'vESTADOLSDDEP',prop:'Visible'},{av:'edtavEstadocontr_Visible',ctrl:'vESTADOCONTR',prop:'Visible'},{av:'edtavEstadoauxfut_Visible',ctrl:'vESTADOAUXFUT',prop:'Visible'},{av:'edtLiqError_Visible',ctrl:'LIQERROR',prop:'Visible'},{av:'edtLiqDescrip_Visible',ctrl:'LIQDESCRIP',prop:'Visible'},{av:'edtLiqImpBruto_Visible',ctrl:'LIQIMPBRUTO',prop:'Visible'},{av:'edtLiqImpNeto_Visible',ctrl:'LIQIMPNETO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV33GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV34GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV32GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV121ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_PROXIMAACCION.CLOSE","{handler:'e162M2',iparms:[{av:'Dvelop_confirmpanel_proximaaccion_Result',ctrl:'DVELOP_CONFIRMPANEL_PROXIMAACCION',prop:'Result'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV231Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV176MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''},{av:'AV162PeriodoLiq',fld:'vPERIODOLIQ',pic:''},{av:'AV185LiqRelNro',fld:'vLIQRELNRO',pic:'ZZZZZZZ9'},{av:'AV74TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV75TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV139TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV141TFLiqNombre_Sel',fld:'vTFLIQNOMBRE_SEL',pic:''},{av:'AV66TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV67TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV113TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV114TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV68TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV69TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV216TFTLiqDescAux',fld:'vTFTLIQDESCAUX',pic:'@!'},{av:'AV217TFTLiqDescAux_Sels',fld:'vTFTLIQDESCAUX_SELS',pic:''},{av:'AV226TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV228TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV56TFLiqCntLeg',fld:'vTFLIQCNTLEG',pic:'ZZZ9'},{av:'AV57TFLiqCntLeg_To',fld:'vTFLIQCNTLEG_TO',pic:'ZZZ9'},{av:'AV119TFLiqError',fld:'vTFLIQERROR',pic:''},{av:'AV120TFLiqError_Sels',fld:'vTFLIQERROR_SELS',pic:''},{av:'AV58TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV60TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV70TFLiqImpBruto',fld:'vTFLIQIMPBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV71TFLiqImpBruto_To',fld:'vTFLIQIMPBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV72TFLiqImpNeto',fld:'vTFLIQIMPNETO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TFLiqImpNeto_To',fld:'vTFLIQIMPNETO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV43OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV189collectionLegNumero',fld:'vCOLLECTIONLEGNUMERO',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:'',hsh:true},{av:'A719LiqFecImp',fld:'LIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'A361LiqGenInter',fld:'LIQGENINTER',pic:'',hsh:true},{av:'sPrefix'},{av:'cmbLiqEstado'},{av:'A278LiqEstado',fld:'LIQESTADO',pic:'9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_PROXIMAACCION.CLOSE",",oparms:[{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLiqNro_Visible',ctrl:'LIQNRO',prop:'Visible'},{av:'edtLiqNombre_Visible',ctrl:'LIQNOMBRE',prop:'Visible'},{av:'edtLiqFecha_Visible',ctrl:'LIQFECHA',prop:'Visible'},{av:'edtLiqPerPalabra_Visible',ctrl:'LIQPERPALABRA',prop:'Visible'},{av:'edtLiqFecPago_Visible',ctrl:'LIQFECPAGO',prop:'Visible'},{av:'edtTLiqDescAux_Visible',ctrl:'TLIQDESCAUX',prop:'Visible'},{av:'cmbLiqModTra'},{av:'cmbLiqFrecPag'},{av:'edtLiqCntLeg_Visible',ctrl:'LIQCNTLEG',prop:'Visible'},{av:'edtavEstadoprin_Visible',ctrl:'vESTADOPRIN',prop:'Visible'},{av:'edtavEstadopdf_Visible',ctrl:'vESTADOPDF',prop:'Visible'},{av:'edtavEstadolsddep_Visible',ctrl:'vESTADOLSDDEP',prop:'Visible'},{av:'edtavEstadocontr_Visible',ctrl:'vESTADOCONTR',prop:'Visible'},{av:'edtavEstadoauxfut_Visible',ctrl:'vESTADOAUXFUT',prop:'Visible'},{av:'edtLiqError_Visible',ctrl:'LIQERROR',prop:'Visible'},{av:'edtLiqDescrip_Visible',ctrl:'LIQDESCRIP',prop:'Visible'},{av:'edtLiqImpBruto_Visible',ctrl:'LIQIMPBRUTO',prop:'Visible'},{av:'edtLiqImpNeto_Visible',ctrl:'LIQIMPNETO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV33GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV34GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV32GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV121ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("VGRIDACTIONS.CLICK","{handler:'e292M2',iparms:[{av:'cmbavGridactions'},{av:'AV31GridActions',fld:'vGRIDACTIONS',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV189collectionLegNumero',fld:'vCOLLECTIONLEGNUMERO',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A874LiqNombre',fld:'LIQNOMBRE',pic:'',hsh:true}]");
      setEventMetadata("VGRIDACTIONS.CLICK",",oparms:[{av:'cmbavGridactions'},{av:'AV31GridActions',fld:'vGRIDACTIONS',pic:'ZZZ9'},{av:'AV8CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV28EmpCod_Selected',fld:'vEMPCOD_SELECTED',pic:'ZZZ9'},{av:'AV40LiqNro_Selected',fld:'vLIQNRO_SELECTED',pic:'ZZZZZZZ9'},{av:'Dvelop_confirmpanel_reliquidar_Confirmationtext',ctrl:'DVELOP_CONFIRMPANEL_RELIQUIDAR',prop:'ConfirmationText'}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_ELIMINAR.CLOSE","{handler:'e172M2',iparms:[{av:'Dvelop_confirmpanel_eliminar_Result',ctrl:'DVELOP_CONFIRMPANEL_ELIMINAR',prop:'Result'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV231Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV176MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''},{av:'AV162PeriodoLiq',fld:'vPERIODOLIQ',pic:''},{av:'AV185LiqRelNro',fld:'vLIQRELNRO',pic:'ZZZZZZZ9'},{av:'AV74TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV75TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV139TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV141TFLiqNombre_Sel',fld:'vTFLIQNOMBRE_SEL',pic:''},{av:'AV66TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV67TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV113TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV114TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV68TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV69TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV216TFTLiqDescAux',fld:'vTFTLIQDESCAUX',pic:'@!'},{av:'AV217TFTLiqDescAux_Sels',fld:'vTFTLIQDESCAUX_SELS',pic:''},{av:'AV226TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV228TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV56TFLiqCntLeg',fld:'vTFLIQCNTLEG',pic:'ZZZ9'},{av:'AV57TFLiqCntLeg_To',fld:'vTFLIQCNTLEG_TO',pic:'ZZZ9'},{av:'AV119TFLiqError',fld:'vTFLIQERROR',pic:''},{av:'AV120TFLiqError_Sels',fld:'vTFLIQERROR_SELS',pic:''},{av:'AV58TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV60TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV70TFLiqImpBruto',fld:'vTFLIQIMPBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV71TFLiqImpBruto_To',fld:'vTFLIQIMPBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV72TFLiqImpNeto',fld:'vTFLIQIMPNETO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TFLiqImpNeto_To',fld:'vTFLIQIMPNETO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV43OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV189collectionLegNumero',fld:'vCOLLECTIONLEGNUMERO',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:'',hsh:true},{av:'A719LiqFecImp',fld:'LIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'A361LiqGenInter',fld:'LIQGENINTER',pic:'',hsh:true},{av:'sPrefix'},{av:'AV8CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV28EmpCod_Selected',fld:'vEMPCOD_SELECTED',pic:'ZZZ9'},{av:'AV40LiqNro_Selected',fld:'vLIQNRO_SELECTED',pic:'ZZZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'cmbLiqEstado'},{av:'A278LiqEstado',fld:'LIQESTADO',pic:'9',hsh:true}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_ELIMINAR.CLOSE",",oparms:[{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLiqNro_Visible',ctrl:'LIQNRO',prop:'Visible'},{av:'edtLiqNombre_Visible',ctrl:'LIQNOMBRE',prop:'Visible'},{av:'edtLiqFecha_Visible',ctrl:'LIQFECHA',prop:'Visible'},{av:'edtLiqPerPalabra_Visible',ctrl:'LIQPERPALABRA',prop:'Visible'},{av:'edtLiqFecPago_Visible',ctrl:'LIQFECPAGO',prop:'Visible'},{av:'edtTLiqDescAux_Visible',ctrl:'TLIQDESCAUX',prop:'Visible'},{av:'cmbLiqModTra'},{av:'cmbLiqFrecPag'},{av:'edtLiqCntLeg_Visible',ctrl:'LIQCNTLEG',prop:'Visible'},{av:'edtavEstadoprin_Visible',ctrl:'vESTADOPRIN',prop:'Visible'},{av:'edtavEstadopdf_Visible',ctrl:'vESTADOPDF',prop:'Visible'},{av:'edtavEstadolsddep_Visible',ctrl:'vESTADOLSDDEP',prop:'Visible'},{av:'edtavEstadocontr_Visible',ctrl:'vESTADOCONTR',prop:'Visible'},{av:'edtavEstadoauxfut_Visible',ctrl:'vESTADOAUXFUT',prop:'Visible'},{av:'edtLiqError_Visible',ctrl:'LIQERROR',prop:'Visible'},{av:'edtLiqDescrip_Visible',ctrl:'LIQDESCRIP',prop:'Visible'},{av:'edtLiqImpBruto_Visible',ctrl:'LIQIMPBRUTO',prop:'Visible'},{av:'edtLiqImpNeto_Visible',ctrl:'LIQIMPNETO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV33GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV34GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV32GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV121ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_RELIQUIDAR.CLOSE","{handler:'e182M2',iparms:[{av:'Dvelop_confirmpanel_reliquidar_Result',ctrl:'DVELOP_CONFIRMPANEL_RELIQUIDAR',prop:'Result'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV231Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV176MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''},{av:'AV162PeriodoLiq',fld:'vPERIODOLIQ',pic:''},{av:'AV185LiqRelNro',fld:'vLIQRELNRO',pic:'ZZZZZZZ9'},{av:'AV74TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV75TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV139TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV141TFLiqNombre_Sel',fld:'vTFLIQNOMBRE_SEL',pic:''},{av:'AV66TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV67TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV113TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV114TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV68TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV69TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV216TFTLiqDescAux',fld:'vTFTLIQDESCAUX',pic:'@!'},{av:'AV217TFTLiqDescAux_Sels',fld:'vTFTLIQDESCAUX_SELS',pic:''},{av:'AV226TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV228TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV56TFLiqCntLeg',fld:'vTFLIQCNTLEG',pic:'ZZZ9'},{av:'AV57TFLiqCntLeg_To',fld:'vTFLIQCNTLEG_TO',pic:'ZZZ9'},{av:'AV119TFLiqError',fld:'vTFLIQERROR',pic:''},{av:'AV120TFLiqError_Sels',fld:'vTFLIQERROR_SELS',pic:''},{av:'AV58TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV60TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV70TFLiqImpBruto',fld:'vTFLIQIMPBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV71TFLiqImpBruto_To',fld:'vTFLIQIMPBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV72TFLiqImpNeto',fld:'vTFLIQIMPNETO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TFLiqImpNeto_To',fld:'vTFLIQIMPNETO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV43OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV189collectionLegNumero',fld:'vCOLLECTIONLEGNUMERO',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:'',hsh:true},{av:'A719LiqFecImp',fld:'LIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'A361LiqGenInter',fld:'LIQGENINTER',pic:'',hsh:true},{av:'sPrefix'},{av:'AV8CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV28EmpCod_Selected',fld:'vEMPCOD_SELECTED',pic:'ZZZ9'},{av:'AV40LiqNro_Selected',fld:'vLIQNRO_SELECTED',pic:'ZZZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'cmbLiqEstado'},{av:'A278LiqEstado',fld:'LIQESTADO',pic:'9',hsh:true}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_RELIQUIDAR.CLOSE",",oparms:[{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLiqNro_Visible',ctrl:'LIQNRO',prop:'Visible'},{av:'edtLiqNombre_Visible',ctrl:'LIQNOMBRE',prop:'Visible'},{av:'edtLiqFecha_Visible',ctrl:'LIQFECHA',prop:'Visible'},{av:'edtLiqPerPalabra_Visible',ctrl:'LIQPERPALABRA',prop:'Visible'},{av:'edtLiqFecPago_Visible',ctrl:'LIQFECPAGO',prop:'Visible'},{av:'edtTLiqDescAux_Visible',ctrl:'TLIQDESCAUX',prop:'Visible'},{av:'cmbLiqModTra'},{av:'cmbLiqFrecPag'},{av:'edtLiqCntLeg_Visible',ctrl:'LIQCNTLEG',prop:'Visible'},{av:'edtavEstadoprin_Visible',ctrl:'vESTADOPRIN',prop:'Visible'},{av:'edtavEstadopdf_Visible',ctrl:'vESTADOPDF',prop:'Visible'},{av:'edtavEstadolsddep_Visible',ctrl:'vESTADOLSDDEP',prop:'Visible'},{av:'edtavEstadocontr_Visible',ctrl:'vESTADOCONTR',prop:'Visible'},{av:'edtavEstadoauxfut_Visible',ctrl:'vESTADOAUXFUT',prop:'Visible'},{av:'edtLiqError_Visible',ctrl:'LIQERROR',prop:'Visible'},{av:'edtLiqDescrip_Visible',ctrl:'LIQDESCRIP',prop:'Visible'},{av:'edtLiqImpBruto_Visible',ctrl:'LIQIMPBRUTO',prop:'Visible'},{av:'edtLiqImpNeto_Visible',ctrl:'LIQIMPNETO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV33GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV34GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV32GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV121ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_CERRAR.CLOSE","{handler:'e192M2',iparms:[{av:'Dvelop_confirmpanel_cerrar_Result',ctrl:'DVELOP_CONFIRMPANEL_CERRAR',prop:'Result'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV231Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV176MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''},{av:'AV162PeriodoLiq',fld:'vPERIODOLIQ',pic:''},{av:'AV185LiqRelNro',fld:'vLIQRELNRO',pic:'ZZZZZZZ9'},{av:'AV74TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV75TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV139TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV141TFLiqNombre_Sel',fld:'vTFLIQNOMBRE_SEL',pic:''},{av:'AV66TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV67TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV113TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV114TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV68TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV69TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV216TFTLiqDescAux',fld:'vTFTLIQDESCAUX',pic:'@!'},{av:'AV217TFTLiqDescAux_Sels',fld:'vTFTLIQDESCAUX_SELS',pic:''},{av:'AV226TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV228TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV56TFLiqCntLeg',fld:'vTFLIQCNTLEG',pic:'ZZZ9'},{av:'AV57TFLiqCntLeg_To',fld:'vTFLIQCNTLEG_TO',pic:'ZZZ9'},{av:'AV119TFLiqError',fld:'vTFLIQERROR',pic:''},{av:'AV120TFLiqError_Sels',fld:'vTFLIQERROR_SELS',pic:''},{av:'AV58TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV60TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV70TFLiqImpBruto',fld:'vTFLIQIMPBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV71TFLiqImpBruto_To',fld:'vTFLIQIMPBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV72TFLiqImpNeto',fld:'vTFLIQIMPNETO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TFLiqImpNeto_To',fld:'vTFLIQIMPNETO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV43OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV189collectionLegNumero',fld:'vCOLLECTIONLEGNUMERO',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:'',hsh:true},{av:'A719LiqFecImp',fld:'LIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'A361LiqGenInter',fld:'LIQGENINTER',pic:'',hsh:true},{av:'sPrefix'},{av:'AV8CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV28EmpCod_Selected',fld:'vEMPCOD_SELECTED',pic:'ZZZ9'},{av:'AV40LiqNro_Selected',fld:'vLIQNRO_SELECTED',pic:'ZZZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'cmbLiqEstado'},{av:'A278LiqEstado',fld:'LIQESTADO',pic:'9',hsh:true}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_CERRAR.CLOSE",",oparms:[{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLiqNro_Visible',ctrl:'LIQNRO',prop:'Visible'},{av:'edtLiqNombre_Visible',ctrl:'LIQNOMBRE',prop:'Visible'},{av:'edtLiqFecha_Visible',ctrl:'LIQFECHA',prop:'Visible'},{av:'edtLiqPerPalabra_Visible',ctrl:'LIQPERPALABRA',prop:'Visible'},{av:'edtLiqFecPago_Visible',ctrl:'LIQFECPAGO',prop:'Visible'},{av:'edtTLiqDescAux_Visible',ctrl:'TLIQDESCAUX',prop:'Visible'},{av:'cmbLiqModTra'},{av:'cmbLiqFrecPag'},{av:'edtLiqCntLeg_Visible',ctrl:'LIQCNTLEG',prop:'Visible'},{av:'edtavEstadoprin_Visible',ctrl:'vESTADOPRIN',prop:'Visible'},{av:'edtavEstadopdf_Visible',ctrl:'vESTADOPDF',prop:'Visible'},{av:'edtavEstadolsddep_Visible',ctrl:'vESTADOLSDDEP',prop:'Visible'},{av:'edtavEstadocontr_Visible',ctrl:'vESTADOCONTR',prop:'Visible'},{av:'edtavEstadoauxfut_Visible',ctrl:'vESTADOAUXFUT',prop:'Visible'},{av:'edtLiqError_Visible',ctrl:'LIQERROR',prop:'Visible'},{av:'edtLiqDescrip_Visible',ctrl:'LIQDESCRIP',prop:'Visible'},{av:'edtLiqImpBruto_Visible',ctrl:'LIQIMPBRUTO',prop:'Visible'},{av:'edtLiqImpNeto_Visible',ctrl:'LIQIMPNETO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV33GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV34GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV32GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV121ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_REABRIR.CLOSE","{handler:'e202M2',iparms:[{av:'Dvelop_confirmpanel_reabrir_Result',ctrl:'DVELOP_CONFIRMPANEL_REABRIR',prop:'Result'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV231Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV176MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''},{av:'AV162PeriodoLiq',fld:'vPERIODOLIQ',pic:''},{av:'AV185LiqRelNro',fld:'vLIQRELNRO',pic:'ZZZZZZZ9'},{av:'AV74TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV75TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV139TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV141TFLiqNombre_Sel',fld:'vTFLIQNOMBRE_SEL',pic:''},{av:'AV66TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV67TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV113TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV114TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV68TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV69TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV216TFTLiqDescAux',fld:'vTFTLIQDESCAUX',pic:'@!'},{av:'AV217TFTLiqDescAux_Sels',fld:'vTFTLIQDESCAUX_SELS',pic:''},{av:'AV226TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV228TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV56TFLiqCntLeg',fld:'vTFLIQCNTLEG',pic:'ZZZ9'},{av:'AV57TFLiqCntLeg_To',fld:'vTFLIQCNTLEG_TO',pic:'ZZZ9'},{av:'AV119TFLiqError',fld:'vTFLIQERROR',pic:''},{av:'AV120TFLiqError_Sels',fld:'vTFLIQERROR_SELS',pic:''},{av:'AV58TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV60TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV70TFLiqImpBruto',fld:'vTFLIQIMPBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV71TFLiqImpBruto_To',fld:'vTFLIQIMPBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV72TFLiqImpNeto',fld:'vTFLIQIMPNETO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TFLiqImpNeto_To',fld:'vTFLIQIMPNETO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV43OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV189collectionLegNumero',fld:'vCOLLECTIONLEGNUMERO',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:'',hsh:true},{av:'A719LiqFecImp',fld:'LIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'A361LiqGenInter',fld:'LIQGENINTER',pic:'',hsh:true},{av:'sPrefix'},{av:'AV28EmpCod_Selected',fld:'vEMPCOD_SELECTED',pic:'ZZZ9'},{av:'AV40LiqNro_Selected',fld:'vLIQNRO_SELECTED',pic:'ZZZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'cmbLiqEstado'},{av:'A278LiqEstado',fld:'LIQESTADO',pic:'9',hsh:true}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_REABRIR.CLOSE",",oparms:[{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLiqNro_Visible',ctrl:'LIQNRO',prop:'Visible'},{av:'edtLiqNombre_Visible',ctrl:'LIQNOMBRE',prop:'Visible'},{av:'edtLiqFecha_Visible',ctrl:'LIQFECHA',prop:'Visible'},{av:'edtLiqPerPalabra_Visible',ctrl:'LIQPERPALABRA',prop:'Visible'},{av:'edtLiqFecPago_Visible',ctrl:'LIQFECPAGO',prop:'Visible'},{av:'edtTLiqDescAux_Visible',ctrl:'TLIQDESCAUX',prop:'Visible'},{av:'cmbLiqModTra'},{av:'cmbLiqFrecPag'},{av:'edtLiqCntLeg_Visible',ctrl:'LIQCNTLEG',prop:'Visible'},{av:'edtavEstadoprin_Visible',ctrl:'vESTADOPRIN',prop:'Visible'},{av:'edtavEstadopdf_Visible',ctrl:'vESTADOPDF',prop:'Visible'},{av:'edtavEstadolsddep_Visible',ctrl:'vESTADOLSDDEP',prop:'Visible'},{av:'edtavEstadocontr_Visible',ctrl:'vESTADOCONTR',prop:'Visible'},{av:'edtavEstadoauxfut_Visible',ctrl:'vESTADOAUXFUT',prop:'Visible'},{av:'edtLiqError_Visible',ctrl:'LIQERROR',prop:'Visible'},{av:'edtLiqDescrip_Visible',ctrl:'LIQDESCRIP',prop:'Visible'},{av:'edtLiqImpBruto_Visible',ctrl:'LIQIMPBRUTO',prop:'Visible'},{av:'edtLiqImpNeto_Visible',ctrl:'LIQIMPNETO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV33GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV34GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV32GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV121ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_CANCELAR.CLOSE","{handler:'e212M2',iparms:[{av:'Dvelop_confirmpanel_cancelar_Result',ctrl:'DVELOP_CONFIRMPANEL_CANCELAR',prop:'Result'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV231Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV176MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''},{av:'AV162PeriodoLiq',fld:'vPERIODOLIQ',pic:''},{av:'AV185LiqRelNro',fld:'vLIQRELNRO',pic:'ZZZZZZZ9'},{av:'AV74TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV75TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV139TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV141TFLiqNombre_Sel',fld:'vTFLIQNOMBRE_SEL',pic:''},{av:'AV66TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV67TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV113TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV114TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV68TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV69TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV216TFTLiqDescAux',fld:'vTFTLIQDESCAUX',pic:'@!'},{av:'AV217TFTLiqDescAux_Sels',fld:'vTFTLIQDESCAUX_SELS',pic:''},{av:'AV226TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV228TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV56TFLiqCntLeg',fld:'vTFLIQCNTLEG',pic:'ZZZ9'},{av:'AV57TFLiqCntLeg_To',fld:'vTFLIQCNTLEG_TO',pic:'ZZZ9'},{av:'AV119TFLiqError',fld:'vTFLIQERROR',pic:''},{av:'AV120TFLiqError_Sels',fld:'vTFLIQERROR_SELS',pic:''},{av:'AV58TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV60TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV70TFLiqImpBruto',fld:'vTFLIQIMPBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV71TFLiqImpBruto_To',fld:'vTFLIQIMPBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV72TFLiqImpNeto',fld:'vTFLIQIMPNETO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TFLiqImpNeto_To',fld:'vTFLIQIMPNETO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV43OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV189collectionLegNumero',fld:'vCOLLECTIONLEGNUMERO',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:'',hsh:true},{av:'A719LiqFecImp',fld:'LIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'A361LiqGenInter',fld:'LIQGENINTER',pic:'',hsh:true},{av:'sPrefix'},{av:'AV8CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV28EmpCod_Selected',fld:'vEMPCOD_SELECTED',pic:'ZZZ9'},{av:'AV40LiqNro_Selected',fld:'vLIQNRO_SELECTED',pic:'ZZZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'cmbLiqEstado'},{av:'A278LiqEstado',fld:'LIQESTADO',pic:'9',hsh:true}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_CANCELAR.CLOSE",",oparms:[{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLiqNro_Visible',ctrl:'LIQNRO',prop:'Visible'},{av:'edtLiqNombre_Visible',ctrl:'LIQNOMBRE',prop:'Visible'},{av:'edtLiqFecha_Visible',ctrl:'LIQFECHA',prop:'Visible'},{av:'edtLiqPerPalabra_Visible',ctrl:'LIQPERPALABRA',prop:'Visible'},{av:'edtLiqFecPago_Visible',ctrl:'LIQFECPAGO',prop:'Visible'},{av:'edtTLiqDescAux_Visible',ctrl:'TLIQDESCAUX',prop:'Visible'},{av:'cmbLiqModTra'},{av:'cmbLiqFrecPag'},{av:'edtLiqCntLeg_Visible',ctrl:'LIQCNTLEG',prop:'Visible'},{av:'edtavEstadoprin_Visible',ctrl:'vESTADOPRIN',prop:'Visible'},{av:'edtavEstadopdf_Visible',ctrl:'vESTADOPDF',prop:'Visible'},{av:'edtavEstadolsddep_Visible',ctrl:'vESTADOLSDDEP',prop:'Visible'},{av:'edtavEstadocontr_Visible',ctrl:'vESTADOCONTR',prop:'Visible'},{av:'edtavEstadoauxfut_Visible',ctrl:'vESTADOAUXFUT',prop:'Visible'},{av:'edtLiqError_Visible',ctrl:'LIQERROR',prop:'Visible'},{av:'edtLiqDescrip_Visible',ctrl:'LIQDESCRIP',prop:'Visible'},{av:'edtLiqImpBruto_Visible',ctrl:'LIQIMPBRUTO',prop:'Visible'},{av:'edtLiqImpNeto_Visible',ctrl:'LIQIMPNETO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV33GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV34GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV32GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV121ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e222M2',iparms:[{av:'AV162PeriodoLiq',fld:'vPERIODOLIQ',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("'DOINSERT'",",oparms:[{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("'DOEXPORT'","{handler:'e232M2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("'DOELIMINARTODAS'","{handler:'e302M2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV231Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV176MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''},{av:'AV162PeriodoLiq',fld:'vPERIODOLIQ',pic:''},{av:'AV185LiqRelNro',fld:'vLIQRELNRO',pic:'ZZZZZZZ9'},{av:'AV74TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV75TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV139TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV141TFLiqNombre_Sel',fld:'vTFLIQNOMBRE_SEL',pic:''},{av:'AV66TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV67TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV113TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV114TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV68TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV69TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV216TFTLiqDescAux',fld:'vTFTLIQDESCAUX',pic:'@!'},{av:'AV217TFTLiqDescAux_Sels',fld:'vTFTLIQDESCAUX_SELS',pic:''},{av:'AV226TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV228TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV56TFLiqCntLeg',fld:'vTFLIQCNTLEG',pic:'ZZZ9'},{av:'AV57TFLiqCntLeg_To',fld:'vTFLIQCNTLEG_TO',pic:'ZZZ9'},{av:'AV119TFLiqError',fld:'vTFLIQERROR',pic:''},{av:'AV120TFLiqError_Sels',fld:'vTFLIQERROR_SELS',pic:''},{av:'AV58TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV60TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV70TFLiqImpBruto',fld:'vTFLIQIMPBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV71TFLiqImpBruto_To',fld:'vTFLIQIMPBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV72TFLiqImpNeto',fld:'vTFLIQIMPNETO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TFLiqImpNeto_To',fld:'vTFLIQIMPNETO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV43OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV189collectionLegNumero',fld:'vCOLLECTIONLEGNUMERO',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A283LiqPeriodo',fld:'LIQPERIODO',pic:'',hsh:true},{av:'A719LiqFecImp',fld:'LIQFECIMP',pic:'99/99/99 99:99',hsh:true},{av:'A361LiqGenInter',fld:'LIQGENINTER',pic:'',hsh:true},{av:'sPrefix'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'cmbLiqEstado'},{av:'A278LiqEstado',fld:'LIQESTADO',pic:'9',hsh:true}]");
      setEventMetadata("'DOELIMINARTODAS'",",oparms:[{av:'AV27EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV123ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV9ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLiqNro_Visible',ctrl:'LIQNRO',prop:'Visible'},{av:'edtLiqNombre_Visible',ctrl:'LIQNOMBRE',prop:'Visible'},{av:'edtLiqFecha_Visible',ctrl:'LIQFECHA',prop:'Visible'},{av:'edtLiqPerPalabra_Visible',ctrl:'LIQPERPALABRA',prop:'Visible'},{av:'edtLiqFecPago_Visible',ctrl:'LIQFECPAGO',prop:'Visible'},{av:'edtTLiqDescAux_Visible',ctrl:'TLIQDESCAUX',prop:'Visible'},{av:'cmbLiqModTra'},{av:'cmbLiqFrecPag'},{av:'edtLiqCntLeg_Visible',ctrl:'LIQCNTLEG',prop:'Visible'},{av:'edtavEstadoprin_Visible',ctrl:'vESTADOPRIN',prop:'Visible'},{av:'edtavEstadopdf_Visible',ctrl:'vESTADOPDF',prop:'Visible'},{av:'edtavEstadolsddep_Visible',ctrl:'vESTADOLSDDEP',prop:'Visible'},{av:'edtavEstadocontr_Visible',ctrl:'vESTADOCONTR',prop:'Visible'},{av:'edtavEstadoauxfut_Visible',ctrl:'vESTADOAUXFUT',prop:'Visible'},{av:'edtLiqError_Visible',ctrl:'LIQERROR',prop:'Visible'},{av:'edtLiqDescrip_Visible',ctrl:'LIQDESCRIP',prop:'Visible'},{av:'edtLiqImpBruto_Visible',ctrl:'LIQIMPBRUTO',prop:'Visible'},{av:'edtLiqImpNeto_Visible',ctrl:'LIQIMPNETO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV33GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV34GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV32GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV39IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV121ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV35GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GLOBALEVENTS.MENSAJELIQUIDACION","{handler:'e242M2',iparms:[{av:'AV222mensajeTextoJson',fld:'vMENSAJETEXTOJSON',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV231Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'A31LiqNro',fld:'LIQNRO',grid:70,pic:'ZZZZZZZ9',hsh:true},{av:'GRID_nFirstRecordOnPage'},{av:'nRC_GXsfl_70',ctrl:'GRID',grid:70,prop:'GridRC',grid:70},{av:'AV224siguienteEstadoPalabra',fld:'vSIGUIENTEESTADOPALABRA',pic:''},{av:'AV201EstadoLSDDep',fld:'vESTADOLSDDEP',grid:70,pic:''},{av:'AV196msgNotiEstado',fld:'vMSGNOTIESTADO',pic:''}]");
      setEventMetadata("GLOBALEVENTS.MENSAJELIQUIDACION",",oparms:[{av:'AV196msgNotiEstado',fld:'vMSGNOTIESTADO',pic:''},{av:'AV194EstadoPrin',fld:'vESTADOPRIN',pic:''},{av:'AV201EstadoLSDDep',fld:'vESTADOLSDDEP',pic:''},{av:'AV203EstadoPDF',fld:'vESTADOPDF',pic:''},{av:'AV202EstadoContr',fld:'vESTADOCONTR',pic:''},{av:'AV204EstadoAuxFut',fld:'vESTADOAUXFUT',pic:''},{av:'AV224siguienteEstadoPalabra',fld:'vSIGUIENTEESTADOPALABRA',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Modificarsvg',iparms:[]");
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
      wcpOAV176MenuOpcCod = "" ;
      wcpOAV162PeriodoLiq = GXutil.nullDate() ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      Dvelop_confirmpanel_proximaaccion_Result = "" ;
      Dvelop_confirmpanel_eliminar_Result = "" ;
      Dvelop_confirmpanel_reliquidar_Result = "" ;
      Dvelop_confirmpanel_cerrar_Result = "" ;
      Dvelop_confirmpanel_reabrir_Result = "" ;
      Dvelop_confirmpanel_cancelar_Result = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV176MenuOpcCod = "" ;
      AV162PeriodoLiq = GXutil.nullDate() ;
      AV9ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV231Pgmname = "" ;
      AV35GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV139TFLiqNombre = "" ;
      AV141TFLiqNombre_Sel = "" ;
      AV66TFLiqFecha = GXutil.nullDate() ;
      AV67TFLiqFecha_To = GXutil.nullDate() ;
      AV113TFLiqPerPalabra = "" ;
      AV114TFLiqPerPalabra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68TFLiqFecPago = GXutil.nullDate() ;
      AV69TFLiqFecPago_To = GXutil.nullDate() ;
      AV216TFTLiqDescAux = "" ;
      AV217TFTLiqDescAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV226TFLiqModTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV228TFLiqFrecPag_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV119TFLiqError = "" ;
      AV120TFLiqError_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58TFLiqDescrip = "" ;
      AV60TFLiqDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV70TFLiqImpBruto = DecimalUtil.ZERO ;
      AV71TFLiqImpBruto_To = DecimalUtil.ZERO ;
      AV72TFLiqImpNeto = DecimalUtil.ZERO ;
      AV73TFLiqImpNeto_To = DecimalUtil.ZERO ;
      AV189collectionLegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      A283LiqPeriodo = GXutil.nullDate() ;
      A719LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV25DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV121ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV32GridAppliedFilters = "" ;
      AV16DDO_LiqFechaAuxDate = GXutil.nullDate() ;
      AV18DDO_LiqFechaAuxDateTo = GXutil.nullDate() ;
      AV19DDO_LiqFecPagoAuxDate = GXutil.nullDate() ;
      AV21DDO_LiqFecPagoAuxDateTo = GXutil.nullDate() ;
      AV112TFLiqPerPalabra_SelsJson = "" ;
      AV215TFTLiqDescAux_SelsJson = "" ;
      AV225TFLiqModTra_SelsJson = "" ;
      AV227TFLiqFrecPag_SelsJson = "" ;
      AV118TFLiqError_SelsJson = "" ;
      AV61TFLiqDescrip_SelsJson = "" ;
      AV222mensajeTextoJson = "" ;
      AV224siguienteEstadoPalabra = "" ;
      AV196msgNotiEstado = "" ;
      Ddo_gridcolumnsselector_Gridinternalname = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_titlescategories_Gridinternalname = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      TempTags = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ClassString = "" ;
      StyleString = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      A1729PeriodoLiq = GXutil.nullDate() ;
      ucGrid_titlescategories = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      AV17DDO_LiqFechaAuxDateText = "" ;
      ucTfliqfecha_rangepicker = new com.genexus.webpanels.GXUserControl();
      AV20DDO_LiqFecPagoAuxDateText = "" ;
      ucTfliqfecpago_rangepicker = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV45ProximaAccion = "" ;
      A874LiqNombre = "" ;
      A98LiqFecha = GXutil.nullDate() ;
      A748LiqPerPalabra = "" ;
      A280LiqFecPago = GXutil.nullDate() ;
      A2368TLiqDescAux = "" ;
      A2409LiqModTra = "" ;
      A2180LiqPDFEstado = "" ;
      AV194EstadoPrin = "" ;
      AV203EstadoPDF = "" ;
      AV201EstadoLSDDep = "" ;
      AV202EstadoContr = "" ;
      AV204EstadoAuxFut = "" ;
      A766LiqError = "" ;
      A271LiqDescrip = "" ;
      A1142LiqLog = "" ;
      A885LiqSegundos = DecimalUtil.ZERO ;
      A497LiqImpBruto = DecimalUtil.ZERO ;
      A496LiqImpNeto = DecimalUtil.ZERO ;
      AV175Display = "" ;
      AV102Update = "" ;
      AV173VerSVG = "" ;
      AV174ModificarSVG = "" ;
      AV241Liquidacionwwds_10_tfliqperpalabra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV245Liquidacionwwds_14_tftliqdescaux_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV246Liquidacionwwds_15_tfliqmodtra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV247Liquidacionwwds_16_tfliqfrecpag_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV251Liquidacionwwds_20_tfliqerror_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV253Liquidacionwwds_22_tfliqdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV240Liquidacionwwds_9_tfliqperpalabra = "" ;
      lV244Liquidacionwwds_13_tftliqdescaux = "" ;
      lV250Liquidacionwwds_19_tfliqerror = "" ;
      lV252Liquidacionwwds_21_tfliqdescrip = "" ;
      AV237Liquidacionwwds_6_tfliqnombre_sel = "" ;
      AV238Liquidacionwwds_7_tfliqfecha = GXutil.nullDate() ;
      AV239Liquidacionwwds_8_tfliqfecha_to = GXutil.nullDate() ;
      AV240Liquidacionwwds_9_tfliqperpalabra = "" ;
      AV242Liquidacionwwds_11_tfliqfecpago = GXutil.nullDate() ;
      AV243Liquidacionwwds_12_tfliqfecpago_to = GXutil.nullDate() ;
      AV244Liquidacionwwds_13_tftliqdescaux = "" ;
      AV250Liquidacionwwds_19_tfliqerror = "" ;
      AV252Liquidacionwwds_21_tfliqdescrip = "" ;
      AV254Liquidacionwwds_23_tfliqimpbruto = DecimalUtil.ZERO ;
      AV255Liquidacionwwds_24_tfliqimpbruto_to = DecimalUtil.ZERO ;
      AV256Liquidacionwwds_25_tfliqimpneto = DecimalUtil.ZERO ;
      AV257Liquidacionwwds_26_tfliqimpneto_to = DecimalUtil.ZERO ;
      AV232Liquidacionwwds_1_periodoliq = GXutil.nullDate() ;
      H002M2_A2112LiqRelNro = new int[1] ;
      H002M2_n2112LiqRelNro = new boolean[] {false} ;
      H002M2_A719LiqFecImp = new java.util.Date[] {GXutil.nullDate()} ;
      H002M2_A3CliCod = new int[1] ;
      H002M2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      H002M2_A361LiqGenInter = new boolean[] {false} ;
      H002M2_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      H002M2_A496LiqImpNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H002M2_A497LiqImpBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H002M2_A885LiqSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H002M2_A1142LiqLog = new String[] {""} ;
      H002M2_A271LiqDescrip = new String[] {""} ;
      H002M2_A766LiqError = new String[] {""} ;
      H002M2_A1403LiqAuxEstado = new byte[1] ;
      H002M2_A2180LiqPDFEstado = new String[] {""} ;
      H002M2_n2180LiqPDFEstado = new boolean[] {false} ;
      H002M2_A2293LiqContrEst = new byte[1] ;
      H002M2_A2292LiqLSDDepEst = new byte[1] ;
      H002M2_A278LiqEstado = new byte[1] ;
      H002M2_A495LiqCntLeg = new short[1] ;
      H002M2_A2414LiqFrecPag = new byte[1] ;
      H002M2_A2409LiqModTra = new String[] {""} ;
      H002M2_A268LiqClase = new byte[1] ;
      H002M2_n268LiqClase = new boolean[] {false} ;
      H002M2_A2368TLiqDescAux = new String[] {""} ;
      H002M2_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      H002M2_A748LiqPerPalabra = new String[] {""} ;
      H002M2_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H002M2_A874LiqNombre = new String[] {""} ;
      H002M2_A1EmpCod = new short[1] ;
      H002M2_A31LiqNro = new int[1] ;
      AV236Liquidacionwwds_5_tfliqnombre = "" ;
      H002M3_AGRID_nRecordCount = new long[1] ;
      AV149hoy = GXutil.nullDate() ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV211observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      AV168ParmValue = "" ;
      AV186ServerSocket = new com.genexuscore.genexus.server.SdtSocket(remoteHandle, context);
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      AV88WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext8 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV47Session = httpContext.getWebSession();
      AV11ColumnsSelectorXML = "" ;
      AV210MenuOpcTitulo = "" ;
      GXv_int2 = new short[1] ;
      AV214filtrosTexto = "" ;
      GXt_date10 = GXutil.nullDate() ;
      GXv_date11 = new java.util.Date[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV122ManageFiltersXml = "" ;
      ucDvelop_confirmpanel_proximaaccion = new com.genexus.webpanels.GXUserControl();
      AV163websession = httpContext.getWebSession();
      AV30ExcelFilename = "" ;
      AV29ErrorMessage = "" ;
      AV87UserCustomValue = "" ;
      AV10ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18 = new GXBaseCollection[1] ;
      GXv_boolean16 = new boolean[1] ;
      GXv_int4 = new int[1] ;
      AV171procesandoError = "" ;
      ucDvelop_confirmpanel_reliquidar = new com.genexus.webpanels.GXUserControl();
      AV36GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char9 = "" ;
      GXv_char7 = new String[1] ;
      GXt_char26 = "" ;
      GXv_char27 = new String[1] ;
      GXt_char24 = "" ;
      GXv_char25 = new String[1] ;
      GXt_char22 = "" ;
      GXv_char23 = new String[1] ;
      GXt_char20 = "" ;
      GXv_char21 = new String[1] ;
      GXt_char19 = "" ;
      GXv_char12 = new String[1] ;
      AV85TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV37HTTPRequest = httpContext.getHttpRequest();
      AV86TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      GXv_SdtWWPGridState28 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV111mensaje_collection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV107mensajeTexto = "" ;
      AV195mensajesNotificacion = new GXSimpleCollection<String>(String.class, "internal", "");
      AV205PDFEstado = "" ;
      AV198msgNotiPgm = "" ;
      AV220porcentajePalabra = "" ;
      ucDvelop_confirmpanel_cancelar = new com.genexus.webpanels.GXUserControl();
      ucDvelop_confirmpanel_reabrir = new com.genexus.webpanels.GXUserControl();
      ucDvelop_confirmpanel_cerrar = new com.genexus.webpanels.GXUserControl();
      ucDvelop_confirmpanel_eliminar = new com.genexus.webpanels.GXUserControl();
      lblButtonexport1_textblock_svg_Jsonclick = "" ;
      lblButtonexport1_textblock_texto_Jsonclick = "" ;
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      bttBtninsert_Jsonclick = "" ;
      bttBtnexport_Jsonclick = "" ;
      lblButtonfilter1_textblock_svg_Jsonclick = "" ;
      lblButtonfilter1_textblock_texto_Jsonclick = "" ;
      lblButtonfilter1_textblockbadgecount_Jsonclick = "" ;
      lblTotaltext_Jsonclick = "" ;
      lblCouttext_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV176MenuOpcCod = "" ;
      sCtrlAV162PeriodoLiq = "" ;
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionww__default(),
         new Object[] {
             new Object[] {
            H002M2_A2112LiqRelNro, H002M2_n2112LiqRelNro, H002M2_A719LiqFecImp, H002M2_A3CliCod, H002M2_A283LiqPeriodo, H002M2_A361LiqGenInter, H002M2_A1729PeriodoLiq, H002M2_A496LiqImpNeto, H002M2_A497LiqImpBruto, H002M2_A885LiqSegundos,
            H002M2_A1142LiqLog, H002M2_A271LiqDescrip, H002M2_A766LiqError, H002M2_A1403LiqAuxEstado, H002M2_A2180LiqPDFEstado, H002M2_n2180LiqPDFEstado, H002M2_A2293LiqContrEst, H002M2_A2292LiqLSDDepEst, H002M2_A278LiqEstado, H002M2_A495LiqCntLeg,
            H002M2_A2414LiqFrecPag, H002M2_A2409LiqModTra, H002M2_A268LiqClase, H002M2_n268LiqClase, H002M2_A2368TLiqDescAux, H002M2_A280LiqFecPago, H002M2_A748LiqPerPalabra, H002M2_A98LiqFecha, H002M2_A874LiqNombre, H002M2_A1EmpCod,
            H002M2_A31LiqNro
            }
            , new Object[] {
            H002M3_AGRID_nRecordCount
            }
         }
      );
      AV231Pgmname = "LiquidacionWW" ;
      /* GeneXus formulas. */
      AV231Pgmname = "LiquidacionWW" ;
      Gx_err = (short)(0) ;
      edtavProximaaccion_Enabled = 0 ;
      edtavEstadoprin_Enabled = 0 ;
      edtavEstadopdf_Enabled = 0 ;
      edtavEstadolsddep_Enabled = 0 ;
      edtavEstadocontr_Enabled = 0 ;
      edtavEstadoauxfut_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
      edtavUpdate_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
      edtavModificarsvg_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte AV123ManageFiltersExecutionStep ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte A268LiqClase ;
   private byte A2414LiqFrecPag ;
   private byte A278LiqEstado ;
   private byte A2292LiqLSDDepEst ;
   private byte A2293LiqContrEst ;
   private byte A1403LiqAuxEstado ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte AV200LiquidacionEstado ;
   private byte AV219PendienteLiquidacionestado ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short AV56TFLiqCntLeg ;
   private short AV57TFLiqCntLeg_To ;
   private short AV41OrderedBy ;
   private short AV27EmpCod ;
   private short AV28EmpCod_Selected ;
   private short wbEnd ;
   private short wbStart ;
   private short AV31GridActions ;
   private short A1EmpCod ;
   private short A495LiqCntLeg ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV248Liquidacionwwds_17_tfliqcntleg ;
   private short AV249Liquidacionwwds_18_tfliqcntleg_to ;
   private short AV137cuantas ;
   private short AV147mesDesde ;
   private short AV146anioTest ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short AV223i ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_70 ;
   private int nGXsfl_70_idx=1 ;
   private int AV185LiqRelNro ;
   private int AV74TFLiqNro ;
   private int AV75TFLiqNro_To ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int AV8CliCod_Selected ;
   private int AV40LiqNro_Selected ;
   private int Gridpaginationbar_Pagestoshow ;
   private int edtavLiqrelnro_Enabled ;
   private int edtavLiqrelnro_Visible ;
   private int edtPeriodoLiq_Visible ;
   private int A31LiqNro ;
   private int subGrid_Islastpage ;
   private int edtavProximaaccion_Enabled ;
   private int edtavEstadoprin_Enabled ;
   private int edtavEstadopdf_Enabled ;
   private int edtavEstadolsddep_Enabled ;
   private int edtavEstadocontr_Enabled ;
   private int edtavEstadoauxfut_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavUpdate_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV241Liquidacionwwds_10_tfliqperpalabra_sels_size ;
   private int AV245Liquidacionwwds_14_tftliqdescaux_sels_size ;
   private int AV246Liquidacionwwds_15_tfliqmodtra_sels_size ;
   private int AV247Liquidacionwwds_16_tfliqfrecpag_sels_size ;
   private int AV251Liquidacionwwds_20_tfliqerror_sels_size ;
   private int AV253Liquidacionwwds_22_tfliqdescrip_sels_size ;
   private int AV234Liquidacionwwds_3_tfliqnro ;
   private int AV235Liquidacionwwds_4_tfliqnro_to ;
   private int A2112LiqRelNro ;
   private int AV233Liquidacionwwds_2_liqrelnro ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int3 ;
   private int edtLiqNro_Visible ;
   private int edtLiqNombre_Visible ;
   private int edtLiqFecha_Visible ;
   private int edtLiqPerPalabra_Visible ;
   private int edtLiqFecPago_Visible ;
   private int edtTLiqDescAux_Visible ;
   private int edtLiqCntLeg_Visible ;
   private int edtavEstadoprin_Visible ;
   private int edtavEstadopdf_Visible ;
   private int edtavEstadolsddep_Visible ;
   private int edtavEstadocontr_Visible ;
   private int edtavEstadoauxfut_Visible ;
   private int edtLiqError_Visible ;
   private int edtLiqDescrip_Visible ;
   private int edtLiqImpBruto_Visible ;
   private int edtLiqImpNeto_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV213filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV44PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavProximaaccion_Visible ;
   private int bttBtninsert_Visible ;
   private int AV170procesandoLiqNro ;
   private int GXv_int4[] ;
   private int AV258GXV1 ;
   private int AV197msgNotiLiqNro ;
   private int nGXsfl_70_fel_idx=1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV33GridCurrentPage ;
   private long AV34GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV70TFLiqImpBruto ;
   private java.math.BigDecimal AV71TFLiqImpBruto_To ;
   private java.math.BigDecimal AV72TFLiqImpNeto ;
   private java.math.BigDecimal AV73TFLiqImpNeto_To ;
   private java.math.BigDecimal A885LiqSegundos ;
   private java.math.BigDecimal A497LiqImpBruto ;
   private java.math.BigDecimal A496LiqImpNeto ;
   private java.math.BigDecimal AV254Liquidacionwwds_23_tfliqimpbruto ;
   private java.math.BigDecimal AV255Liquidacionwwds_24_tfliqimpbruto_to ;
   private java.math.BigDecimal AV256Liquidacionwwds_25_tfliqimpneto ;
   private java.math.BigDecimal AV257Liquidacionwwds_26_tfliqimpneto_to ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Filteredtextto_get ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_gridcolumnsselector_Columnsselectorvalues ;
   private String Ddo_managefilters_Activeeventkey ;
   private String Dvelop_confirmpanel_proximaaccion_Result ;
   private String Dvelop_confirmpanel_eliminar_Result ;
   private String Dvelop_confirmpanel_reliquidar_Result ;
   private String Dvelop_confirmpanel_cerrar_Result ;
   private String Dvelop_confirmpanel_reabrir_Result ;
   private String Dvelop_confirmpanel_cancelar_Result ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_70_idx="0001" ;
   private String AV231Pgmname ;
   private String AV113TFLiqPerPalabra ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String AV224siguienteEstadoPalabra ;
   private String AV196msgNotiEstado ;
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
   private String Dvelop_confirmpanel_proximaaccion_Title ;
   private String Dvelop_confirmpanel_proximaaccion_Confirmationtext ;
   private String Dvelop_confirmpanel_proximaaccion_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_proximaaccion_Nobuttoncaption ;
   private String Dvelop_confirmpanel_proximaaccion_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_proximaaccion_Yesbuttonposition ;
   private String Dvelop_confirmpanel_proximaaccion_Confirmtype ;
   private String Dvelop_confirmpanel_eliminar_Title ;
   private String Dvelop_confirmpanel_eliminar_Confirmationtext ;
   private String Dvelop_confirmpanel_eliminar_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_eliminar_Nobuttoncaption ;
   private String Dvelop_confirmpanel_eliminar_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_eliminar_Yesbuttonposition ;
   private String Dvelop_confirmpanel_eliminar_Confirmtype ;
   private String Dvelop_confirmpanel_reliquidar_Title ;
   private String Dvelop_confirmpanel_reliquidar_Confirmationtext ;
   private String Dvelop_confirmpanel_reliquidar_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_reliquidar_Nobuttoncaption ;
   private String Dvelop_confirmpanel_reliquidar_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_reliquidar_Yesbuttonposition ;
   private String Dvelop_confirmpanel_reliquidar_Confirmtype ;
   private String Dvelop_confirmpanel_cerrar_Title ;
   private String Dvelop_confirmpanel_cerrar_Confirmationtext ;
   private String Dvelop_confirmpanel_cerrar_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_cerrar_Nobuttoncaption ;
   private String Dvelop_confirmpanel_cerrar_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_cerrar_Yesbuttonposition ;
   private String Dvelop_confirmpanel_cerrar_Confirmtype ;
   private String Dvelop_confirmpanel_reabrir_Title ;
   private String Dvelop_confirmpanel_reabrir_Confirmationtext ;
   private String Dvelop_confirmpanel_reabrir_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_reabrir_Nobuttoncaption ;
   private String Dvelop_confirmpanel_reabrir_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_reabrir_Yesbuttonposition ;
   private String Dvelop_confirmpanel_reabrir_Confirmtype ;
   private String Dvelop_confirmpanel_cancelar_Title ;
   private String Dvelop_confirmpanel_cancelar_Confirmationtext ;
   private String Dvelop_confirmpanel_cancelar_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_cancelar_Nobuttoncaption ;
   private String Dvelop_confirmpanel_cancelar_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_cancelar_Yesbuttonposition ;
   private String Dvelop_confirmpanel_cancelar_Confirmtype ;
   private String Grid_titlescategories_Gridinternalname ;
   private String Grid_titlescategories_Gridtitlescategories ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTablefiltrospadre_Internalname ;
   private String edtavLiqrelnro_Internalname ;
   private String TempTags ;
   private String edtavLiqrelnro_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String edtPeriodoLiq_Internalname ;
   private String edtPeriodoLiq_Jsonclick ;
   private String Grid_titlescategories_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String divDdo_liqfechaauxdates_Internalname ;
   private String edtavDdo_liqfechaauxdatetext_Internalname ;
   private String edtavDdo_liqfechaauxdatetext_Jsonclick ;
   private String Tfliqfecha_rangepicker_Internalname ;
   private String divDdo_liqfecpagoauxdates_Internalname ;
   private String edtavDdo_liqfecpagoauxdatetext_Internalname ;
   private String edtavDdo_liqfecpagoauxdatetext_Jsonclick ;
   private String Tfliqfecpago_rangepicker_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavProximaaccion_Internalname ;
   private String AV45ProximaAccion ;
   private String edtLiqNro_Internalname ;
   private String edtEmpCod_Internalname ;
   private String edtLiqNombre_Internalname ;
   private String edtLiqFecha_Internalname ;
   private String A748LiqPerPalabra ;
   private String edtLiqPerPalabra_Internalname ;
   private String edtLiqFecPago_Internalname ;
   private String edtTLiqDescAux_Internalname ;
   private String A2409LiqModTra ;
   private String edtLiqCntLeg_Internalname ;
   private String A2180LiqPDFEstado ;
   private String AV194EstadoPrin ;
   private String edtavEstadoprin_Internalname ;
   private String AV203EstadoPDF ;
   private String edtavEstadopdf_Internalname ;
   private String AV201EstadoLSDDep ;
   private String edtavEstadolsddep_Internalname ;
   private String AV202EstadoContr ;
   private String edtavEstadocontr_Internalname ;
   private String AV204EstadoAuxFut ;
   private String edtavEstadoauxfut_Internalname ;
   private String edtLiqError_Internalname ;
   private String edtLiqDescrip_Internalname ;
   private String edtLiqLog_Internalname ;
   private String edtLiqSegundos_Internalname ;
   private String edtLiqImpBruto_Internalname ;
   private String edtLiqImpNeto_Internalname ;
   private String AV175Display ;
   private String edtavDisplay_Internalname ;
   private String AV102Update ;
   private String edtavUpdate_Internalname ;
   private String AV173VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV174ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String scmdbuf ;
   private String lV240Liquidacionwwds_9_tfliqperpalabra ;
   private String AV240Liquidacionwwds_9_tfliqperpalabra ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String AV211observerPalabra ;
   private String Buttonexport1_a3lexport_Internalname ;
   private String divButtonexport1_tablecontentbuttonimport_Internalname ;
   private String bttBtnexport_Internalname ;
   private String Buttonfilter1_a3lfilter_Internalname ;
   private String divButtonfilter1_tablecontent_Internalname ;
   private String lblCouttext_Internalname ;
   private String lblCouttext_Caption ;
   private String tblButtonfilter1_tablebadge_Internalname ;
   private String lblButtonfilter1_textblockbadgecount_Caption ;
   private String lblButtonfilter1_textblockbadgecount_Internalname ;
   private String tblButtonfilter1_tablebadge_Tooltiptext ;
   private String edtavProximaaccion_Class ;
   private String edtavDisplay_Link ;
   private String edtavUpdate_Link ;
   private String edtavUpdate_Class ;
   private String edtavVersvg_Link ;
   private String edtLiqNombre_Link ;
   private String edtavVersvg_Columnclass ;
   private String edtavModificarsvg_Link ;
   private String edtavModificarsvg_Columnclass ;
   private String edtavProximaaccion_Tooltiptext ;
   private String edtavEstadoprin_Tooltiptext ;
   private String edtavEstadopdf_Tooltiptext ;
   private String edtavEstadolsddep_Tooltiptext ;
   private String edtavEstadocontr_Tooltiptext ;
   private String edtavEstadoauxfut_Tooltiptext ;
   private String Dvelop_confirmpanel_proximaaccion_Internalname ;
   private String bttBtninsert_Internalname ;
   private String Dvelop_confirmpanel_reliquidar_Internalname ;
   private String GXt_char9 ;
   private String GXv_char7[] ;
   private String GXt_char26 ;
   private String GXv_char27[] ;
   private String GXt_char24 ;
   private String GXv_char25[] ;
   private String GXt_char22 ;
   private String GXv_char23[] ;
   private String GXt_char20 ;
   private String GXv_char21[] ;
   private String GXt_char19 ;
   private String GXv_char12[] ;
   private String AV205PDFEstado ;
   private String AV198msgNotiPgm ;
   private String sGXsfl_70_fel_idx="0001" ;
   private String AV220porcentajePalabra ;
   private String tblTabledvelop_confirmpanel_cancelar_Internalname ;
   private String Dvelop_confirmpanel_cancelar_Internalname ;
   private String tblTabledvelop_confirmpanel_reabrir_Internalname ;
   private String Dvelop_confirmpanel_reabrir_Internalname ;
   private String tblTabledvelop_confirmpanel_cerrar_Internalname ;
   private String Dvelop_confirmpanel_cerrar_Internalname ;
   private String tblTabledvelop_confirmpanel_reliquidar_Internalname ;
   private String tblTabledvelop_confirmpanel_eliminar_Internalname ;
   private String Dvelop_confirmpanel_eliminar_Internalname ;
   private String tblTabledvelop_confirmpanel_proximaaccion_Internalname ;
   private String tblTablefiltros_Internalname ;
   private String divButtonexport1_table_svg_Internalname ;
   private String lblButtonexport1_textblock_svg_Internalname ;
   private String lblButtonexport1_textblock_svg_Jsonclick ;
   private String divButtonexport1_table_texto_Internalname ;
   private String lblButtonexport1_textblock_texto_Internalname ;
   private String lblButtonexport1_textblock_texto_Jsonclick ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String bttBtninsert_Jsonclick ;
   private String bttBtnexport_Jsonclick ;
   private String divButtonfilter1_filtros_Internalname ;
   private String divButtonfilter1_table_svg_Internalname ;
   private String lblButtonfilter1_textblock_svg_Internalname ;
   private String lblButtonfilter1_textblock_svg_Jsonclick ;
   private String divButtonfilter1_table_texto_Internalname ;
   private String lblButtonfilter1_textblock_texto_Internalname ;
   private String lblButtonfilter1_textblock_texto_Jsonclick ;
   private String lblButtonfilter1_textblockbadgecount_Jsonclick ;
   private String tblTabletotalregistros_Internalname ;
   private String divTabletotal_Internalname ;
   private String lblTotaltext_Internalname ;
   private String lblTotaltext_Jsonclick ;
   private String lblCouttext_Jsonclick ;
   private String sCtrlAV176MenuOpcCod ;
   private String sCtrlAV162PeriodoLiq ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavProximaaccion_Jsonclick ;
   private String GXCCtl ;
   private String edtLiqNro_Jsonclick ;
   private String edtEmpCod_Jsonclick ;
   private String edtLiqNombre_Jsonclick ;
   private String edtLiqFecha_Jsonclick ;
   private String edtLiqPerPalabra_Jsonclick ;
   private String edtLiqFecPago_Jsonclick ;
   private String edtTLiqDescAux_Jsonclick ;
   private String edtLiqCntLeg_Jsonclick ;
   private String edtavEstadoprin_Jsonclick ;
   private String edtavEstadopdf_Jsonclick ;
   private String edtavEstadolsddep_Jsonclick ;
   private String edtavEstadocontr_Jsonclick ;
   private String edtavEstadoauxfut_Jsonclick ;
   private String edtLiqError_Jsonclick ;
   private String edtLiqDescrip_Jsonclick ;
   private String edtLiqLog_Jsonclick ;
   private String edtLiqSegundos_Jsonclick ;
   private String edtLiqImpBruto_Jsonclick ;
   private String edtLiqImpNeto_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date A719LiqFecImp ;
   private java.util.Date wcpOAV162PeriodoLiq ;
   private java.util.Date AV162PeriodoLiq ;
   private java.util.Date AV66TFLiqFecha ;
   private java.util.Date AV67TFLiqFecha_To ;
   private java.util.Date AV68TFLiqFecPago ;
   private java.util.Date AV69TFLiqFecPago_To ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date AV16DDO_LiqFechaAuxDate ;
   private java.util.Date AV18DDO_LiqFechaAuxDateTo ;
   private java.util.Date AV19DDO_LiqFecPagoAuxDate ;
   private java.util.Date AV21DDO_LiqFecPagoAuxDateTo ;
   private java.util.Date A1729PeriodoLiq ;
   private java.util.Date A98LiqFecha ;
   private java.util.Date A280LiqFecPago ;
   private java.util.Date AV238Liquidacionwwds_7_tfliqfecha ;
   private java.util.Date AV239Liquidacionwwds_8_tfliqfecha_to ;
   private java.util.Date AV242Liquidacionwwds_11_tfliqfecpago ;
   private java.util.Date AV243Liquidacionwwds_12_tfliqfecpago_to ;
   private java.util.Date AV232Liquidacionwwds_1_periodoliq ;
   private java.util.Date AV149hoy ;
   private java.util.Date GXt_date10 ;
   private java.util.Date GXv_date11[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV43OrderedDsc ;
   private boolean AV39IsAuthorized_Update ;
   private boolean A361LiqGenInter ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hascategories ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean Grid_empowerer_Hascolumnsselector ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n268LiqClase ;
   private boolean n2180LiqPDFEstado ;
   private boolean bGXsfl_70_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n2112LiqRelNro ;
   private boolean returnInSub ;
   private boolean AV161cerear ;
   private boolean AV167modoTestEs ;
   private boolean gx_refresh_fired ;
   private boolean AV48TempBoolean ;
   private boolean Cond_result ;
   private boolean GXt_boolean15 ;
   private boolean AV169procesandoHay ;
   private boolean GXv_boolean16[] ;
   private String AV112TFLiqPerPalabra_SelsJson ;
   private String AV215TFTLiqDescAux_SelsJson ;
   private String AV225TFLiqModTra_SelsJson ;
   private String AV227TFLiqFrecPag_SelsJson ;
   private String AV118TFLiqError_SelsJson ;
   private String AV61TFLiqDescrip_SelsJson ;
   private String A1142LiqLog ;
   private String AV168ParmValue ;
   private String AV11ColumnsSelectorXML ;
   private String AV122ManageFiltersXml ;
   private String AV87UserCustomValue ;
   private String wcpOAV176MenuOpcCod ;
   private String AV176MenuOpcCod ;
   private String AV139TFLiqNombre ;
   private String AV141TFLiqNombre_Sel ;
   private String AV216TFTLiqDescAux ;
   private String AV119TFLiqError ;
   private String AV58TFLiqDescrip ;
   private String AV32GridAppliedFilters ;
   private String AV222mensajeTextoJson ;
   private String AV17DDO_LiqFechaAuxDateText ;
   private String AV20DDO_LiqFecPagoAuxDateText ;
   private String A874LiqNombre ;
   private String A2368TLiqDescAux ;
   private String A766LiqError ;
   private String A271LiqDescrip ;
   private String lV244Liquidacionwwds_13_tftliqdescaux ;
   private String lV250Liquidacionwwds_19_tfliqerror ;
   private String lV252Liquidacionwwds_21_tfliqdescrip ;
   private String AV237Liquidacionwwds_6_tfliqnombre_sel ;
   private String AV244Liquidacionwwds_13_tftliqdescaux ;
   private String AV250Liquidacionwwds_19_tfliqerror ;
   private String AV252Liquidacionwwds_21_tfliqdescrip ;
   private String AV236Liquidacionwwds_5_tfliqnombre ;
   private String AV210MenuOpcTitulo ;
   private String AV214filtrosTexto ;
   private String AV30ExcelFilename ;
   private String AV29ErrorMessage ;
   private String AV171procesandoError ;
   private String AV107mensajeTexto ;
   private GXSimpleCollection<Byte> AV247Liquidacionwwds_16_tfliqfrecpag_sels ;
   private GXSimpleCollection<Byte> AV228TFLiqFrecPag_Sels ;
   private GXSimpleCollection<Integer> AV189collectionLegNumero ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV37HTTPRequest ;
   private com.genexus.webpanels.WebSession AV47Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_titlescategories ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucTfliqfecha_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucTfliqfecpago_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_proximaaccion ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_reliquidar ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_cancelar ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_reabrir ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_cerrar ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_eliminar ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV241Liquidacionwwds_10_tfliqperpalabra_sels ;
   private GXSimpleCollection<String> AV246Liquidacionwwds_15_tfliqmodtra_sels ;
   private GXSimpleCollection<String> AV245Liquidacionwwds_14_tftliqdescaux_sels ;
   private GXSimpleCollection<String> AV251Liquidacionwwds_20_tfliqerror_sels ;
   private GXSimpleCollection<String> AV253Liquidacionwwds_22_tfliqdescrip_sels ;
   private com.genexuscore.genexus.server.SdtSocket AV186ServerSocket ;
   private HTMLChoice cmbavGridactions ;
   private HTMLChoice cmbLiqClase ;
   private HTMLChoice cmbLiqModTra ;
   private HTMLChoice cmbLiqFrecPag ;
   private HTMLChoice cmbLiqEstado ;
   private HTMLChoice cmbLiqLSDDepEst ;
   private HTMLChoice cmbLiqContrEst ;
   private HTMLChoice cmbLiqPDFEstado ;
   private HTMLChoice cmbLiqAuxEstado ;
   private IDataStoreProvider pr_default ;
   private int[] H002M2_A2112LiqRelNro ;
   private boolean[] H002M2_n2112LiqRelNro ;
   private java.util.Date[] H002M2_A719LiqFecImp ;
   private int[] H002M2_A3CliCod ;
   private java.util.Date[] H002M2_A283LiqPeriodo ;
   private boolean[] H002M2_A361LiqGenInter ;
   private java.util.Date[] H002M2_A1729PeriodoLiq ;
   private java.math.BigDecimal[] H002M2_A496LiqImpNeto ;
   private java.math.BigDecimal[] H002M2_A497LiqImpBruto ;
   private java.math.BigDecimal[] H002M2_A885LiqSegundos ;
   private String[] H002M2_A1142LiqLog ;
   private String[] H002M2_A271LiqDescrip ;
   private String[] H002M2_A766LiqError ;
   private byte[] H002M2_A1403LiqAuxEstado ;
   private String[] H002M2_A2180LiqPDFEstado ;
   private boolean[] H002M2_n2180LiqPDFEstado ;
   private byte[] H002M2_A2293LiqContrEst ;
   private byte[] H002M2_A2292LiqLSDDepEst ;
   private byte[] H002M2_A278LiqEstado ;
   private short[] H002M2_A495LiqCntLeg ;
   private byte[] H002M2_A2414LiqFrecPag ;
   private String[] H002M2_A2409LiqModTra ;
   private byte[] H002M2_A268LiqClase ;
   private boolean[] H002M2_n268LiqClase ;
   private String[] H002M2_A2368TLiqDescAux ;
   private java.util.Date[] H002M2_A280LiqFecPago ;
   private String[] H002M2_A748LiqPerPalabra ;
   private java.util.Date[] H002M2_A98LiqFecha ;
   private String[] H002M2_A874LiqNombre ;
   private short[] H002M2_A1EmpCod ;
   private int[] H002M2_A31LiqNro ;
   private long[] H002M3_AGRID_nRecordCount ;
   private com.genexus.webpanels.WebSession AV163websession ;
   private GXSimpleCollection<String> AV114TFLiqPerPalabra_Sels ;
   private GXSimpleCollection<String> AV226TFLiqModTra_Sels ;
   private GXSimpleCollection<String> AV195mensajesNotificacion ;
   private GXSimpleCollection<String> AV217TFTLiqDescAux_Sels ;
   private GXSimpleCollection<String> AV120TFLiqError_Sels ;
   private GXSimpleCollection<String> AV60TFLiqDescrip_Sels ;
   private GXSimpleCollection<String> AV111mensaje_collection ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV121ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV9ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV10ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector13[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV25DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV35GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState28[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV36GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV85TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV86TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPContext AV88WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext8[] ;
}

final  class liquidacionww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H002M2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV241Liquidacionwwds_10_tfliqperpalabra_sels ,
                                          String A2368TLiqDescAux ,
                                          GXSimpleCollection<String> AV245Liquidacionwwds_14_tftliqdescaux_sels ,
                                          String A2409LiqModTra ,
                                          GXSimpleCollection<String> AV246Liquidacionwwds_15_tfliqmodtra_sels ,
                                          byte A2414LiqFrecPag ,
                                          GXSimpleCollection<Byte> AV247Liquidacionwwds_16_tfliqfrecpag_sels ,
                                          String A766LiqError ,
                                          GXSimpleCollection<String> AV251Liquidacionwwds_20_tfliqerror_sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV253Liquidacionwwds_22_tfliqdescrip_sels ,
                                          int AV234Liquidacionwwds_3_tfliqnro ,
                                          int AV235Liquidacionwwds_4_tfliqnro_to ,
                                          String AV237Liquidacionwwds_6_tfliqnombre_sel ,
                                          java.util.Date AV238Liquidacionwwds_7_tfliqfecha ,
                                          java.util.Date AV239Liquidacionwwds_8_tfliqfecha_to ,
                                          int AV241Liquidacionwwds_10_tfliqperpalabra_sels_size ,
                                          String AV240Liquidacionwwds_9_tfliqperpalabra ,
                                          java.util.Date AV242Liquidacionwwds_11_tfliqfecpago ,
                                          java.util.Date AV243Liquidacionwwds_12_tfliqfecpago_to ,
                                          int AV245Liquidacionwwds_14_tftliqdescaux_sels_size ,
                                          String AV244Liquidacionwwds_13_tftliqdescaux ,
                                          int AV246Liquidacionwwds_15_tfliqmodtra_sels_size ,
                                          int AV247Liquidacionwwds_16_tfliqfrecpag_sels_size ,
                                          short AV248Liquidacionwwds_17_tfliqcntleg ,
                                          short AV249Liquidacionwwds_18_tfliqcntleg_to ,
                                          int AV251Liquidacionwwds_20_tfliqerror_sels_size ,
                                          String AV250Liquidacionwwds_19_tfliqerror ,
                                          int AV253Liquidacionwwds_22_tfliqdescrip_sels_size ,
                                          String AV252Liquidacionwwds_21_tfliqdescrip ,
                                          java.math.BigDecimal AV254Liquidacionwwds_23_tfliqimpbruto ,
                                          java.math.BigDecimal AV255Liquidacionwwds_24_tfliqimpbruto_to ,
                                          java.math.BigDecimal AV256Liquidacionwwds_25_tfliqimpneto ,
                                          java.math.BigDecimal AV257Liquidacionwwds_26_tfliqimpneto_to ,
                                          int A31LiqNro ,
                                          String A874LiqNombre ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          short A495LiqCntLeg ,
                                          java.math.BigDecimal A497LiqImpBruto ,
                                          java.math.BigDecimal A496LiqImpNeto ,
                                          short AV41OrderedBy ,
                                          boolean AV43OrderedDsc ,
                                          int A2112LiqRelNro ,
                                          java.util.Date A1729PeriodoLiq ,
                                          java.util.Date AV232Liquidacionwwds_1_periodoliq ,
                                          int AV7CliCod ,
                                          short AV27EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int29 = new byte[23];
      Object[] GXv_Object30 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " LiqRelNro, LiqFecImp, CliCod, LiqPeriodo, LiqGenInter, PeriodoLiq, LiqImpNeto, LiqImpBruto, LiqSegundos, LiqLog, LiqDescrip, LiqError, LiqAuxEstado, LiqPDFEstado," ;
      sSelectString += " LiqContrEst, LiqLSDDepEst, LiqEstado, LiqCntLeg, LiqFrecPag, LiqModTra, LiqClase, TLiqDescAux, LiqFecPago, LiqPerPalabra, LiqFecha, LiqNombre, EmpCod, LiqNro" ;
      sFromString = " FROM Liquidacion" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      addWhere(sWhereString, "(LiqRelNro IS NULL)");
      addWhere(sWhereString, "(PeriodoLiq = ?)");
      if ( ! (0==AV234Liquidacionwwds_3_tfliqnro) )
      {
         addWhere(sWhereString, "(LiqNro >= ?)");
      }
      else
      {
         GXv_int29[3] = (byte)(1) ;
      }
      if ( ! (0==AV235Liquidacionwwds_4_tfliqnro_to) )
      {
         addWhere(sWhereString, "(LiqNro <= ?)");
      }
      else
      {
         GXv_int29[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV237Liquidacionwwds_6_tfliqnombre_sel)==0) )
      {
         addWhere(sWhereString, "(LiqNombre = ( ?))");
      }
      else
      {
         GXv_int29[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV238Liquidacionwwds_7_tfliqfecha)) )
      {
         addWhere(sWhereString, "(LiqFecha >= ?)");
      }
      else
      {
         GXv_int29[6] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV239Liquidacionwwds_8_tfliqfecha_to)) )
      {
         addWhere(sWhereString, "(LiqFecha <= ?)");
      }
      else
      {
         GXv_int29[7] = (byte)(1) ;
      }
      if ( ( AV241Liquidacionwwds_10_tfliqperpalabra_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV240Liquidacionwwds_9_tfliqperpalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqPerPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int29[8] = (byte)(1) ;
      }
      if ( AV241Liquidacionwwds_10_tfliqperpalabra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV241Liquidacionwwds_10_tfliqperpalabra_sels, "LiqPerPalabra IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV242Liquidacionwwds_11_tfliqfecpago)) )
      {
         addWhere(sWhereString, "(LiqFecPago >= ?)");
      }
      else
      {
         GXv_int29[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV243Liquidacionwwds_12_tfliqfecpago_to)) )
      {
         addWhere(sWhereString, "(LiqFecPago <= ?)");
      }
      else
      {
         GXv_int29[10] = (byte)(1) ;
      }
      if ( ( AV245Liquidacionwwds_14_tftliqdescaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV244Liquidacionwwds_13_tftliqdescaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqDescAux) like LOWER(?))");
      }
      else
      {
         GXv_int29[11] = (byte)(1) ;
      }
      if ( AV245Liquidacionwwds_14_tftliqdescaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV245Liquidacionwwds_14_tftliqdescaux_sels, "TLiqDescAux IN (", ")")+")");
      }
      if ( AV246Liquidacionwwds_15_tfliqmodtra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV246Liquidacionwwds_15_tfliqmodtra_sels, "LiqModTra IN (", ")")+")");
      }
      if ( AV247Liquidacionwwds_16_tfliqfrecpag_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV247Liquidacionwwds_16_tfliqfrecpag_sels, "LiqFrecPag IN (", ")")+")");
      }
      if ( ! (0==AV248Liquidacionwwds_17_tfliqcntleg) )
      {
         addWhere(sWhereString, "(LiqCntLeg >= ?)");
      }
      else
      {
         GXv_int29[12] = (byte)(1) ;
      }
      if ( ! (0==AV249Liquidacionwwds_18_tfliqcntleg_to) )
      {
         addWhere(sWhereString, "(LiqCntLeg <= ?)");
      }
      else
      {
         GXv_int29[13] = (byte)(1) ;
      }
      if ( ( AV251Liquidacionwwds_20_tfliqerror_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV250Liquidacionwwds_19_tfliqerror)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqError) like LOWER(?))");
      }
      else
      {
         GXv_int29[14] = (byte)(1) ;
      }
      if ( AV251Liquidacionwwds_20_tfliqerror_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV251Liquidacionwwds_20_tfliqerror_sels, "LiqError IN (", ")")+")");
      }
      if ( ( AV253Liquidacionwwds_22_tfliqdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV252Liquidacionwwds_21_tfliqdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int29[15] = (byte)(1) ;
      }
      if ( AV253Liquidacionwwds_22_tfliqdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV253Liquidacionwwds_22_tfliqdescrip_sels, "LiqDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV254Liquidacionwwds_23_tfliqimpbruto)==0) )
      {
         addWhere(sWhereString, "(LiqImpBruto >= ?)");
      }
      else
      {
         GXv_int29[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV255Liquidacionwwds_24_tfliqimpbruto_to)==0) )
      {
         addWhere(sWhereString, "(LiqImpBruto <= ?)");
      }
      else
      {
         GXv_int29[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV256Liquidacionwwds_25_tfliqimpneto)==0) )
      {
         addWhere(sWhereString, "(LiqImpNeto >= ?)");
      }
      else
      {
         GXv_int29[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV257Liquidacionwwds_26_tfliqimpneto_to)==0) )
      {
         addWhere(sWhereString, "(LiqImpNeto <= ?)");
      }
      else
      {
         GXv_int29[19] = (byte)(1) ;
      }
      if ( AV41OrderedBy == 1 )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LiqNro DESC" ;
      }
      else if ( ( AV41OrderedBy == 2 ) && ! AV43OrderedDsc )
      {
         sOrderString += " ORDER BY PeriodoLiq, LiqNro, CliCod, EmpCod" ;
      }
      else if ( ( AV41OrderedBy == 2 ) && ( AV43OrderedDsc ) )
      {
         sOrderString += " ORDER BY PeriodoLiq DESC, LiqNro DESC, CliCod, EmpCod" ;
      }
      else if ( ( AV41OrderedBy == 3 ) && ! AV43OrderedDsc )
      {
         sOrderString += " ORDER BY PeriodoLiq, LiqNombre, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 3 ) && ( AV43OrderedDsc ) )
      {
         sOrderString += " ORDER BY PeriodoLiq DESC, LiqNombre DESC, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 4 ) && ! AV43OrderedDsc )
      {
         sOrderString += " ORDER BY PeriodoLiq, LiqFecha, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 4 ) && ( AV43OrderedDsc ) )
      {
         sOrderString += " ORDER BY PeriodoLiq DESC, LiqFecha DESC, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 5 ) && ! AV43OrderedDsc )
      {
         sOrderString += " ORDER BY PeriodoLiq, LiqPerPalabra, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 5 ) && ( AV43OrderedDsc ) )
      {
         sOrderString += " ORDER BY PeriodoLiq DESC, LiqPerPalabra DESC, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 6 ) && ! AV43OrderedDsc )
      {
         sOrderString += " ORDER BY PeriodoLiq, LiqFecPago, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 6 ) && ( AV43OrderedDsc ) )
      {
         sOrderString += " ORDER BY PeriodoLiq DESC, LiqFecPago DESC, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 7 ) && ! AV43OrderedDsc )
      {
         sOrderString += " ORDER BY PeriodoLiq, TLiqDescAux, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 7 ) && ( AV43OrderedDsc ) )
      {
         sOrderString += " ORDER BY PeriodoLiq DESC, TLiqDescAux DESC, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 8 ) && ! AV43OrderedDsc )
      {
         sOrderString += " ORDER BY PeriodoLiq, LiqModTra, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 8 ) && ( AV43OrderedDsc ) )
      {
         sOrderString += " ORDER BY PeriodoLiq DESC, LiqModTra DESC, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 9 ) && ! AV43OrderedDsc )
      {
         sOrderString += " ORDER BY PeriodoLiq, LiqFrecPag, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 9 ) && ( AV43OrderedDsc ) )
      {
         sOrderString += " ORDER BY PeriodoLiq DESC, LiqFrecPag DESC, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 10 ) && ! AV43OrderedDsc )
      {
         sOrderString += " ORDER BY PeriodoLiq, LiqCntLeg, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 10 ) && ( AV43OrderedDsc ) )
      {
         sOrderString += " ORDER BY PeriodoLiq DESC, LiqCntLeg DESC, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 11 ) && ! AV43OrderedDsc )
      {
         sOrderString += " ORDER BY PeriodoLiq, LiqError, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 11 ) && ( AV43OrderedDsc ) )
      {
         sOrderString += " ORDER BY PeriodoLiq DESC, LiqError DESC, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 12 ) && ! AV43OrderedDsc )
      {
         sOrderString += " ORDER BY PeriodoLiq, LiqDescrip, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 12 ) && ( AV43OrderedDsc ) )
      {
         sOrderString += " ORDER BY PeriodoLiq DESC, LiqDescrip DESC, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 13 ) && ! AV43OrderedDsc )
      {
         sOrderString += " ORDER BY PeriodoLiq, LiqImpBruto, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 13 ) && ( AV43OrderedDsc ) )
      {
         sOrderString += " ORDER BY PeriodoLiq DESC, LiqImpBruto DESC, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 14 ) && ! AV43OrderedDsc )
      {
         sOrderString += " ORDER BY PeriodoLiq, LiqImpNeto, CliCod, EmpCod, LiqNro" ;
      }
      else if ( ( AV41OrderedBy == 14 ) && ( AV43OrderedDsc ) )
      {
         sOrderString += " ORDER BY PeriodoLiq DESC, LiqImpNeto DESC, CliCod, EmpCod, LiqNro" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LiqNro" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object30[0] = scmdbuf ;
      GXv_Object30[1] = GXv_int29 ;
      return GXv_Object30 ;
   }

   protected Object[] conditional_H002M3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV241Liquidacionwwds_10_tfliqperpalabra_sels ,
                                          String A2368TLiqDescAux ,
                                          GXSimpleCollection<String> AV245Liquidacionwwds_14_tftliqdescaux_sels ,
                                          String A2409LiqModTra ,
                                          GXSimpleCollection<String> AV246Liquidacionwwds_15_tfliqmodtra_sels ,
                                          byte A2414LiqFrecPag ,
                                          GXSimpleCollection<Byte> AV247Liquidacionwwds_16_tfliqfrecpag_sels ,
                                          String A766LiqError ,
                                          GXSimpleCollection<String> AV251Liquidacionwwds_20_tfliqerror_sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV253Liquidacionwwds_22_tfliqdescrip_sels ,
                                          int AV234Liquidacionwwds_3_tfliqnro ,
                                          int AV235Liquidacionwwds_4_tfliqnro_to ,
                                          String AV237Liquidacionwwds_6_tfliqnombre_sel ,
                                          java.util.Date AV238Liquidacionwwds_7_tfliqfecha ,
                                          java.util.Date AV239Liquidacionwwds_8_tfliqfecha_to ,
                                          int AV241Liquidacionwwds_10_tfliqperpalabra_sels_size ,
                                          String AV240Liquidacionwwds_9_tfliqperpalabra ,
                                          java.util.Date AV242Liquidacionwwds_11_tfliqfecpago ,
                                          java.util.Date AV243Liquidacionwwds_12_tfliqfecpago_to ,
                                          int AV245Liquidacionwwds_14_tftliqdescaux_sels_size ,
                                          String AV244Liquidacionwwds_13_tftliqdescaux ,
                                          int AV246Liquidacionwwds_15_tfliqmodtra_sels_size ,
                                          int AV247Liquidacionwwds_16_tfliqfrecpag_sels_size ,
                                          short AV248Liquidacionwwds_17_tfliqcntleg ,
                                          short AV249Liquidacionwwds_18_tfliqcntleg_to ,
                                          int AV251Liquidacionwwds_20_tfliqerror_sels_size ,
                                          String AV250Liquidacionwwds_19_tfliqerror ,
                                          int AV253Liquidacionwwds_22_tfliqdescrip_sels_size ,
                                          String AV252Liquidacionwwds_21_tfliqdescrip ,
                                          java.math.BigDecimal AV254Liquidacionwwds_23_tfliqimpbruto ,
                                          java.math.BigDecimal AV255Liquidacionwwds_24_tfliqimpbruto_to ,
                                          java.math.BigDecimal AV256Liquidacionwwds_25_tfliqimpneto ,
                                          java.math.BigDecimal AV257Liquidacionwwds_26_tfliqimpneto_to ,
                                          int A31LiqNro ,
                                          String A874LiqNombre ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          short A495LiqCntLeg ,
                                          java.math.BigDecimal A497LiqImpBruto ,
                                          java.math.BigDecimal A496LiqImpNeto ,
                                          short AV41OrderedBy ,
                                          boolean AV43OrderedDsc ,
                                          int A2112LiqRelNro ,
                                          java.util.Date A1729PeriodoLiq ,
                                          java.util.Date AV232Liquidacionwwds_1_periodoliq ,
                                          int AV7CliCod ,
                                          short AV27EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int32 = new byte[20];
      Object[] GXv_Object33 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM Liquidacion" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      addWhere(sWhereString, "(LiqRelNro IS NULL)");
      addWhere(sWhereString, "(PeriodoLiq = ?)");
      if ( ! (0==AV234Liquidacionwwds_3_tfliqnro) )
      {
         addWhere(sWhereString, "(LiqNro >= ?)");
      }
      else
      {
         GXv_int32[3] = (byte)(1) ;
      }
      if ( ! (0==AV235Liquidacionwwds_4_tfliqnro_to) )
      {
         addWhere(sWhereString, "(LiqNro <= ?)");
      }
      else
      {
         GXv_int32[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV237Liquidacionwwds_6_tfliqnombre_sel)==0) )
      {
         addWhere(sWhereString, "(LiqNombre = ( ?))");
      }
      else
      {
         GXv_int32[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV238Liquidacionwwds_7_tfliqfecha)) )
      {
         addWhere(sWhereString, "(LiqFecha >= ?)");
      }
      else
      {
         GXv_int32[6] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV239Liquidacionwwds_8_tfliqfecha_to)) )
      {
         addWhere(sWhereString, "(LiqFecha <= ?)");
      }
      else
      {
         GXv_int32[7] = (byte)(1) ;
      }
      if ( ( AV241Liquidacionwwds_10_tfliqperpalabra_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV240Liquidacionwwds_9_tfliqperpalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqPerPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int32[8] = (byte)(1) ;
      }
      if ( AV241Liquidacionwwds_10_tfliqperpalabra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV241Liquidacionwwds_10_tfliqperpalabra_sels, "LiqPerPalabra IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV242Liquidacionwwds_11_tfliqfecpago)) )
      {
         addWhere(sWhereString, "(LiqFecPago >= ?)");
      }
      else
      {
         GXv_int32[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV243Liquidacionwwds_12_tfliqfecpago_to)) )
      {
         addWhere(sWhereString, "(LiqFecPago <= ?)");
      }
      else
      {
         GXv_int32[10] = (byte)(1) ;
      }
      if ( ( AV245Liquidacionwwds_14_tftliqdescaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV244Liquidacionwwds_13_tftliqdescaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqDescAux) like LOWER(?))");
      }
      else
      {
         GXv_int32[11] = (byte)(1) ;
      }
      if ( AV245Liquidacionwwds_14_tftliqdescaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV245Liquidacionwwds_14_tftliqdescaux_sels, "TLiqDescAux IN (", ")")+")");
      }
      if ( AV246Liquidacionwwds_15_tfliqmodtra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV246Liquidacionwwds_15_tfliqmodtra_sels, "LiqModTra IN (", ")")+")");
      }
      if ( AV247Liquidacionwwds_16_tfliqfrecpag_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV247Liquidacionwwds_16_tfliqfrecpag_sels, "LiqFrecPag IN (", ")")+")");
      }
      if ( ! (0==AV248Liquidacionwwds_17_tfliqcntleg) )
      {
         addWhere(sWhereString, "(LiqCntLeg >= ?)");
      }
      else
      {
         GXv_int32[12] = (byte)(1) ;
      }
      if ( ! (0==AV249Liquidacionwwds_18_tfliqcntleg_to) )
      {
         addWhere(sWhereString, "(LiqCntLeg <= ?)");
      }
      else
      {
         GXv_int32[13] = (byte)(1) ;
      }
      if ( ( AV251Liquidacionwwds_20_tfliqerror_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV250Liquidacionwwds_19_tfliqerror)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqError) like LOWER(?))");
      }
      else
      {
         GXv_int32[14] = (byte)(1) ;
      }
      if ( AV251Liquidacionwwds_20_tfliqerror_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV251Liquidacionwwds_20_tfliqerror_sels, "LiqError IN (", ")")+")");
      }
      if ( ( AV253Liquidacionwwds_22_tfliqdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV252Liquidacionwwds_21_tfliqdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int32[15] = (byte)(1) ;
      }
      if ( AV253Liquidacionwwds_22_tfliqdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV253Liquidacionwwds_22_tfliqdescrip_sels, "LiqDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV254Liquidacionwwds_23_tfliqimpbruto)==0) )
      {
         addWhere(sWhereString, "(LiqImpBruto >= ?)");
      }
      else
      {
         GXv_int32[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV255Liquidacionwwds_24_tfliqimpbruto_to)==0) )
      {
         addWhere(sWhereString, "(LiqImpBruto <= ?)");
      }
      else
      {
         GXv_int32[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV256Liquidacionwwds_25_tfliqimpneto)==0) )
      {
         addWhere(sWhereString, "(LiqImpNeto >= ?)");
      }
      else
      {
         GXv_int32[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV257Liquidacionwwds_26_tfliqimpneto_to)==0) )
      {
         addWhere(sWhereString, "(LiqImpNeto <= ?)");
      }
      else
      {
         GXv_int32[19] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( AV41OrderedBy == 1 )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 2 ) && ! AV43OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 2 ) && ( AV43OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 3 ) && ! AV43OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 3 ) && ( AV43OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 4 ) && ! AV43OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 4 ) && ( AV43OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 5 ) && ! AV43OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 5 ) && ( AV43OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 6 ) && ! AV43OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 6 ) && ( AV43OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 7 ) && ! AV43OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 7 ) && ( AV43OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 8 ) && ! AV43OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 8 ) && ( AV43OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 9 ) && ! AV43OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 9 ) && ( AV43OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 10 ) && ! AV43OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 10 ) && ( AV43OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 11 ) && ! AV43OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 11 ) && ( AV43OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 12 ) && ! AV43OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 12 ) && ( AV43OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 13 ) && ! AV43OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 13 ) && ( AV43OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 14 ) && ! AV43OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV41OrderedBy == 14 ) && ( AV43OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object33[0] = scmdbuf ;
      GXv_Object33[1] = GXv_int32 ;
      return GXv_Object33 ;
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
                  return conditional_H002M2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).intValue() , (String)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , (java.math.BigDecimal)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (java.util.Date)dynConstraints[38] , ((Number) dynConstraints[39]).shortValue() , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , ((Number) dynConstraints[42]).shortValue() , ((Boolean) dynConstraints[43]).booleanValue() , ((Number) dynConstraints[44]).intValue() , (java.util.Date)dynConstraints[45] , (java.util.Date)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).shortValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).shortValue() );
            case 1 :
                  return conditional_H002M3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).intValue() , (String)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , (java.math.BigDecimal)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (java.util.Date)dynConstraints[38] , ((Number) dynConstraints[39]).shortValue() , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , ((Number) dynConstraints[42]).shortValue() , ((Boolean) dynConstraints[43]).booleanValue() , ((Number) dynConstraints[44]).intValue() , (java.util.Date)dynConstraints[45] , (java.util.Date)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).shortValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002M2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002M3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(2);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,2);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(10);
               ((String[]) buf[11])[0] = rslt.getVarchar(11);
               ((String[]) buf[12])[0] = rslt.getVarchar(12);
               ((byte[]) buf[13])[0] = rslt.getByte(13);
               ((String[]) buf[14])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((byte[]) buf[16])[0] = rslt.getByte(15);
               ((byte[]) buf[17])[0] = rslt.getByte(16);
               ((byte[]) buf[18])[0] = rslt.getByte(17);
               ((short[]) buf[19])[0] = rslt.getShort(18);
               ((byte[]) buf[20])[0] = rslt.getByte(19);
               ((String[]) buf[21])[0] = rslt.getString(20, 1);
               ((byte[]) buf[22])[0] = rslt.getByte(21);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getVarchar(22);
               ((java.util.Date[]) buf[25])[0] = rslt.getGXDate(23);
               ((String[]) buf[26])[0] = rslt.getString(24, 20);
               ((java.util.Date[]) buf[27])[0] = rslt.getGXDate(25);
               ((String[]) buf[28])[0] = rslt.getVarchar(26);
               ((short[]) buf[29])[0] = rslt.getShort(27);
               ((int[]) buf[30])[0] = rslt.getInt(28);
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
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[25]);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[26]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[27]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[29]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[30]);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[31], 20);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[32]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[33]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 30);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[35]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 400);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 400);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[39], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[40], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[41], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[42], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[43]).intValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[44]).intValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[45]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[22]);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[26]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[27]);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[28], 20);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[29]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[30]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 30);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 400);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 400);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[38], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[39], 2);
               }
               return;
      }
   }

}

