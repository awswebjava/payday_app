package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class obligaciones_impl extends GXWebComponent
{
   public obligaciones_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public obligaciones_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obligaciones_impl.class ));
   }

   public obligaciones_impl( int remoteHandle ,
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
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      chkLiqOblPrimera = UIFactory.getCheckbox(this);
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
               AV50MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV50MenuOpcCod", AV50MenuOpcCod);
               AV8CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
               AV9EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
               AV10LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LegNumero), 8, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV50MenuOpcCod,Integer.valueOf(AV8CliCod),Short.valueOf(AV9EmpCod),Integer.valueOf(AV10LegNumero)});
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
      nRC_GXsfl_67 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_67"))) ;
      nGXsfl_67_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_67_idx"))) ;
      sGXsfl_67_idx = httpContext.GetPar( "sGXsfl_67_idx") ;
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
      AV67Pgmname = httpContext.GetPar( "Pgmname") ;
      AV50MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      AV8CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV9EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV10LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
      AV24TFLiqOblAltaNro = (int)(GXutil.lval( httpContext.GetPar( "TFLiqOblAltaNro"))) ;
      AV25TFLiqOblAltaNro_To = (int)(GXutil.lval( httpContext.GetPar( "TFLiqOblAltaNro_To"))) ;
      AV26TFLiqOblNuevaNro = (int)(GXutil.lval( httpContext.GetPar( "TFLiqOblNuevaNro"))) ;
      AV27TFLiqOblNuevaNro_To = (int)(GXutil.lval( httpContext.GetPar( "TFLiqOblNuevaNro_To"))) ;
      AV28TFLiqOblPeriodo = localUtil.parseDateParm( httpContext.GetPar( "TFLiqOblPeriodo")) ;
      AV29TFLiqOblPeriodo_To = localUtil.parseDateParm( httpContext.GetPar( "TFLiqOblPeriodo_To")) ;
      AV33TFLiqOblSaldo = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqOblSaldo"), ".") ;
      AV34TFLiqOblSaldo_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqOblSaldo_To"), ".") ;
      AV35TFLiqOblCuota = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqOblCuota"), ".") ;
      AV36TFLiqOblCuota_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqOblCuota_To"), ".") ;
      AV37TFLiqOblTotal = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqOblTotal"), ".") ;
      AV38TFLiqOblTotal_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqOblTotal_To"), ".") ;
      AV39TFLiqOblTotRecal = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqOblTotRecal"), ".") ;
      AV40TFLiqOblTotRecal_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqOblTotRecal_To"), ".") ;
      AV16OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV17OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV49IsAuthorized_Display = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Display")) ;
      AV68Obligacionesds_1_clicod = (int)(GXutil.lval( httpContext.GetPar( "Obligacionesds_1_clicod"))) ;
      AV69Obligacionesds_2_empcod = (short)(GXutil.lval( httpContext.GetPar( "Obligacionesds_2_empcod"))) ;
      AV70Obligacionesds_3_legnumero = (int)(GXutil.lval( httpContext.GetPar( "Obligacionesds_3_legnumero"))) ;
      AV52WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV67Pgmname, AV50MenuOpcCod, AV8CliCod, AV9EmpCod, AV10LegNumero, AV24TFLiqOblAltaNro, AV25TFLiqOblAltaNro_To, AV26TFLiqOblNuevaNro, AV27TFLiqOblNuevaNro_To, AV28TFLiqOblPeriodo, AV29TFLiqOblPeriodo_To, AV33TFLiqOblSaldo, AV34TFLiqOblSaldo_To, AV35TFLiqOblCuota, AV36TFLiqOblCuota_To, AV37TFLiqOblTotal, AV38TFLiqOblTotal_To, AV39TFLiqOblTotRecal, AV40TFLiqOblTotRecal_To, AV16OrderedBy, AV17OrderedDsc, AV49IsAuthorized_Display, AV68Obligacionesds_1_clicod, AV69Obligacionesds_2_empcod, AV70Obligacionesds_3_legnumero, AV52WelcomeMessage_NoMostrarMas, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         paDQ2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Saldos de obligaciones", "")) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.obligaciones", new String[] {GXutil.URLEncode(GXutil.rtrim(AV50MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LegNumero,8,0))}, new String[] {"MenuOpcCod","CliCod","EmpCod","LegNumero"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV67Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( sPrefix, AV49IsAuthorized_Display));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_67", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_67, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV43GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV44GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDAPPLIEDFILTERS", AV45GridAppliedFilters);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV41DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV41DDO_TitleSettingsIcons);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDDO_LIQOBLPERIODOAUXDATE", localUtil.dtoc( AV30DDO_LiqOblPeriodoAuxDate, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDDO_LIQOBLPERIODOAUXDATETO", localUtil.dtoc( AV31DDO_LiqOblPeriodoAuxDateTo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV50MenuOpcCod", wcpOAV50MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV8CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV9EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOAV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV10LegNumero", GXutil.ltrim( localUtil.ntoc( wcpOAV10LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV67Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV67Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMENUOPCCOD", AV50MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV10LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQOBLALTANRO", GXutil.ltrim( localUtil.ntoc( AV24TFLiqOblAltaNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQOBLALTANRO_TO", GXutil.ltrim( localUtil.ntoc( AV25TFLiqOblAltaNro_To, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQOBLNUEVANRO", GXutil.ltrim( localUtil.ntoc( AV26TFLiqOblNuevaNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQOBLNUEVANRO_TO", GXutil.ltrim( localUtil.ntoc( AV27TFLiqOblNuevaNro_To, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQOBLPERIODO", localUtil.dtoc( AV28TFLiqOblPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQOBLPERIODO_TO", localUtil.dtoc( AV29TFLiqOblPeriodo_To, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQOBLSALDO", GXutil.ltrim( localUtil.ntoc( AV33TFLiqOblSaldo, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQOBLSALDO_TO", GXutil.ltrim( localUtil.ntoc( AV34TFLiqOblSaldo_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQOBLCUOTA", GXutil.ltrim( localUtil.ntoc( AV35TFLiqOblCuota, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQOBLCUOTA_TO", GXutil.ltrim( localUtil.ntoc( AV36TFLiqOblCuota_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQOBLTOTAL", GXutil.ltrim( localUtil.ntoc( AV37TFLiqOblTotal, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQOBLTOTAL_TO", GXutil.ltrim( localUtil.ntoc( AV38TFLiqOblTotal_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQOBLTOTRECAL", GXutil.ltrim( localUtil.ntoc( AV39TFLiqOblTotRecal, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQOBLTOTRECAL_TO", GXutil.ltrim( localUtil.ntoc( AV40TFLiqOblTotRecal_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV16OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV17OrderedDsc);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DISPLAY", AV49IsAuthorized_Display);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( sPrefix, AV49IsAuthorized_Display));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vOBLIGACIONESDS_1_CLICOD", GXutil.ltrim( localUtil.ntoc( AV68Obligacionesds_1_clicod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vOBLIGACIONESDS_2_EMPCOD", GXutil.ltrim( localUtil.ntoc( AV69Obligacionesds_2_empcod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vOBLIGACIONESDS_3_LEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV70Obligacionesds_3_legnumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filterisrange", GXutil.rtrim( Ddo_grid_Filterisrange));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Format", GXutil.rtrim( Ddo_grid_Format));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
   }

   public void renderHtmlCloseFormDQ2( )
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
      return "obligaciones" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Saldos de obligaciones", "") ;
   }

   public void wbDQ0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.obligaciones");
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
         wb_table1_9_DQ2( true) ;
      }
      else
      {
         wb_table1_9_DQ2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_DQ2e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         ucDdo_grid.setProperty("IncludeFilter", Ddo_grid_Includefilter);
         ucDdo_grid.setProperty("FilterType", Ddo_grid_Filtertype);
         ucDdo_grid.setProperty("FilterIsRange", Ddo_grid_Filterisrange);
         ucDdo_grid.setProperty("Format", Ddo_grid_Format);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV41DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, sPrefix+"GRID_EMPOWERERContainer");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDdo_liqoblperiodoauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 95,'" + sPrefix + "',false,'" + sGXsfl_67_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_liqoblperiodoauxdatetext_Internalname, AV32DDO_LiqOblPeriodoAuxDateText, GXutil.rtrim( localUtil.format( AV32DDO_LiqOblPeriodoAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,95);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_liqoblperiodoauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_obligaciones.htm");
         /* User Defined Control */
         ucTfliqoblperiodo_rangepicker.setProperty("Start Date", AV30DDO_LiqOblPeriodoAuxDate);
         ucTfliqoblperiodo_rangepicker.setProperty("End Date", AV31DDO_LiqOblPeriodoAuxDateTo);
         ucTfliqoblperiodo_rangepicker.render(context, "wwp.daterangepicker", Tfliqoblperiodo_rangepicker_Internalname, sPrefix+"TFLIQOBLPERIODO_RANGEPICKERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 67 )
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

   public void startDQ2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Saldos de obligaciones", ""), (short)(0)) ;
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
            strupDQ0( ) ;
         }
      }
   }

   public void wsDQ2( )
   {
      startDQ2( ) ;
      evtDQ2( ) ;
   }

   public void evtDQ2( )
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
                              strupDQ0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupDQ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e11DQ2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupDQ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e12DQ2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupDQ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e13DQ2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupDQ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e14DQ2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupDQ0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = chkavWelcomemessage_nomostrarmas.getInternalname() ;
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupDQ0( ) ;
                           }
                           nGXsfl_67_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_67_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_672( ) ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1172OblSecuencial = (short)(localUtil.ctol( httpContext.cgiGet( edtOblSecuencial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1184LiqOblAltaNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqOblAltaNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1185LiqOblNuevaNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqOblNuevaNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1186LiqOblPrimera = GXutil.strtobool( httpContext.cgiGet( chkLiqOblPrimera.getInternalname())) ;
                           A1187LiqOblLog = httpContext.cgiGet( edtLiqOblLog_Internalname) ;
                           A1199LiqOblPeriodo = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLiqOblPeriodo_Internalname), 0)) ;
                           A1197LiqOblSaldo = localUtil.ctond( httpContext.cgiGet( edtLiqOblSaldo_Internalname)) ;
                           A1188LiqOblCuota = localUtil.ctond( httpContext.cgiGet( edtLiqOblCuota_Internalname)) ;
                           A1189LiqOblTotal = localUtil.ctond( httpContext.cgiGet( edtLiqOblTotal_Internalname)) ;
                           A1190LiqOblTotRecal = localUtil.ctond( httpContext.cgiGet( edtLiqOblTotRecal_Internalname)) ;
                           AV47VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavVersvg_Internalname, AV47VerSVG);
                           AV48Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplay_Internalname, AV48Display);
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
                                       GX_FocusControl = chkavWelcomemessage_nomostrarmas.getInternalname() ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e15DQ2 ();
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
                                       GX_FocusControl = chkavWelcomemessage_nomostrarmas.getInternalname() ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Refresh */
                                       e16DQ2 ();
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
                                       GX_FocusControl = chkavWelcomemessage_nomostrarmas.getInternalname() ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e17DQ2 ();
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
                                    strupDQ0( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = chkavWelcomemessage_nomostrarmas.getInternalname() ;
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

   public void weDQ2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormDQ2( ) ;
         }
      }
   }

   public void paDQ2( )
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
            GX_FocusControl = chkavWelcomemessage_nomostrarmas.getInternalname() ;
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
      subsflControlProps_672( ) ;
      while ( nGXsfl_67_idx <= nRC_GXsfl_67 )
      {
         sendrow_672( ) ;
         nGXsfl_67_idx = ((subGrid_Islastpage==1)&&(nGXsfl_67_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_67_idx+1) ;
         sGXsfl_67_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_672( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String AV67Pgmname ,
                                 String AV50MenuOpcCod ,
                                 int AV8CliCod ,
                                 short AV9EmpCod ,
                                 int AV10LegNumero ,
                                 int AV24TFLiqOblAltaNro ,
                                 int AV25TFLiqOblAltaNro_To ,
                                 int AV26TFLiqOblNuevaNro ,
                                 int AV27TFLiqOblNuevaNro_To ,
                                 java.util.Date AV28TFLiqOblPeriodo ,
                                 java.util.Date AV29TFLiqOblPeriodo_To ,
                                 java.math.BigDecimal AV33TFLiqOblSaldo ,
                                 java.math.BigDecimal AV34TFLiqOblSaldo_To ,
                                 java.math.BigDecimal AV35TFLiqOblCuota ,
                                 java.math.BigDecimal AV36TFLiqOblCuota_To ,
                                 java.math.BigDecimal AV37TFLiqOblTotal ,
                                 java.math.BigDecimal AV38TFLiqOblTotal_To ,
                                 java.math.BigDecimal AV39TFLiqOblTotRecal ,
                                 java.math.BigDecimal AV40TFLiqOblTotRecal_To ,
                                 short AV16OrderedBy ,
                                 boolean AV17OrderedDsc ,
                                 boolean AV49IsAuthorized_Display ,
                                 int AV68Obligacionesds_1_clicod ,
                                 short AV69Obligacionesds_2_empcod ,
                                 int AV70Obligacionesds_3_legnumero ,
                                 boolean AV52WelcomeMessage_NoMostrarMas ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e16DQ2 ();
      GRID_nCurrentRecord = 0 ;
      rfDQ2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
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
      AV52WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV52WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52WelcomeMessage_NoMostrarMas", AV52WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfDQ2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV67Pgmname = "obligaciones" ;
      Gx_err = (short)(0) ;
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_67_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_67_Refreshing);
   }

   public void rfDQ2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(67) ;
      /* Execute user event: Refresh */
      e16DQ2 ();
      nGXsfl_67_idx = 1 ;
      sGXsfl_67_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_672( ) ;
      bGXsfl_67_Refreshing = true ;
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
         subsflControlProps_672( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Integer.valueOf(AV71Obligacionesds_4_tfliqoblaltanro) ,
                                              Integer.valueOf(AV72Obligacionesds_5_tfliqoblaltanro_to) ,
                                              Integer.valueOf(AV73Obligacionesds_6_tfliqoblnuevanro) ,
                                              Integer.valueOf(AV74Obligacionesds_7_tfliqoblnuevanro_to) ,
                                              AV75Obligacionesds_8_tfliqoblperiodo ,
                                              AV76Obligacionesds_9_tfliqoblperiodo_to ,
                                              AV77Obligacionesds_10_tfliqoblsaldo ,
                                              AV78Obligacionesds_11_tfliqoblsaldo_to ,
                                              AV79Obligacionesds_12_tfliqoblcuota ,
                                              AV80Obligacionesds_13_tfliqoblcuota_to ,
                                              AV81Obligacionesds_14_tfliqobltotal ,
                                              AV82Obligacionesds_15_tfliqobltotal_to ,
                                              AV83Obligacionesds_16_tfliqobltotrecal ,
                                              AV84Obligacionesds_17_tfliqobltotrecal_to ,
                                              Integer.valueOf(A1184LiqOblAltaNro) ,
                                              Integer.valueOf(A1185LiqOblNuevaNro) ,
                                              A1199LiqOblPeriodo ,
                                              A1197LiqOblSaldo ,
                                              A1188LiqOblCuota ,
                                              A1189LiqOblTotal ,
                                              A1190LiqOblTotRecal ,
                                              Short.valueOf(AV16OrderedBy) ,
                                              Boolean.valueOf(AV17OrderedDsc) ,
                                              Integer.valueOf(AV68Obligacionesds_1_clicod) ,
                                              Short.valueOf(AV69Obligacionesds_2_empcod) ,
                                              Integer.valueOf(AV70Obligacionesds_3_legnumero) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A6LegNumero) } ,
                                              new int[]{
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                              }
         });
         /* Using cursor H00DQ2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV68Obligacionesds_1_clicod), Short.valueOf(AV69Obligacionesds_2_empcod), Integer.valueOf(AV70Obligacionesds_3_legnumero), Integer.valueOf(AV71Obligacionesds_4_tfliqoblaltanro), Integer.valueOf(AV72Obligacionesds_5_tfliqoblaltanro_to), Integer.valueOf(AV73Obligacionesds_6_tfliqoblnuevanro), Integer.valueOf(AV74Obligacionesds_7_tfliqoblnuevanro_to), AV75Obligacionesds_8_tfliqoblperiodo, AV76Obligacionesds_9_tfliqoblperiodo_to, AV77Obligacionesds_10_tfliqoblsaldo, AV78Obligacionesds_11_tfliqoblsaldo_to, AV79Obligacionesds_12_tfliqoblcuota, AV80Obligacionesds_13_tfliqoblcuota_to, AV81Obligacionesds_14_tfliqobltotal, AV82Obligacionesds_15_tfliqobltotal_to, AV83Obligacionesds_16_tfliqobltotrecal, AV84Obligacionesds_17_tfliqobltotrecal_to, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_67_idx = 1 ;
         sGXsfl_67_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_672( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1190LiqOblTotRecal = H00DQ2_A1190LiqOblTotRecal[0] ;
            A1189LiqOblTotal = H00DQ2_A1189LiqOblTotal[0] ;
            A1188LiqOblCuota = H00DQ2_A1188LiqOblCuota[0] ;
            A1197LiqOblSaldo = H00DQ2_A1197LiqOblSaldo[0] ;
            A1199LiqOblPeriodo = H00DQ2_A1199LiqOblPeriodo[0] ;
            A1187LiqOblLog = H00DQ2_A1187LiqOblLog[0] ;
            A1186LiqOblPrimera = H00DQ2_A1186LiqOblPrimera[0] ;
            A1185LiqOblNuevaNro = H00DQ2_A1185LiqOblNuevaNro[0] ;
            A1184LiqOblAltaNro = H00DQ2_A1184LiqOblAltaNro[0] ;
            A1172OblSecuencial = H00DQ2_A1172OblSecuencial[0] ;
            A6LegNumero = H00DQ2_A6LegNumero[0] ;
            A1EmpCod = H00DQ2_A1EmpCod[0] ;
            A3CliCod = H00DQ2_A3CliCod[0] ;
            e17DQ2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(67) ;
         wbDQ0( ) ;
      }
      bGXsfl_67_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesDQ2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV67Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV67Pgmname, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DISPLAY", AV49IsAuthorized_Display);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( sPrefix, AV49IsAuthorized_Display));
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
      AV68Obligacionesds_1_clicod = AV8CliCod ;
      AV69Obligacionesds_2_empcod = AV9EmpCod ;
      AV70Obligacionesds_3_legnumero = AV10LegNumero ;
      AV71Obligacionesds_4_tfliqoblaltanro = AV24TFLiqOblAltaNro ;
      AV72Obligacionesds_5_tfliqoblaltanro_to = AV25TFLiqOblAltaNro_To ;
      AV73Obligacionesds_6_tfliqoblnuevanro = AV26TFLiqOblNuevaNro ;
      AV74Obligacionesds_7_tfliqoblnuevanro_to = AV27TFLiqOblNuevaNro_To ;
      AV75Obligacionesds_8_tfliqoblperiodo = AV28TFLiqOblPeriodo ;
      AV76Obligacionesds_9_tfliqoblperiodo_to = AV29TFLiqOblPeriodo_To ;
      AV77Obligacionesds_10_tfliqoblsaldo = AV33TFLiqOblSaldo ;
      AV78Obligacionesds_11_tfliqoblsaldo_to = AV34TFLiqOblSaldo_To ;
      AV79Obligacionesds_12_tfliqoblcuota = AV35TFLiqOblCuota ;
      AV80Obligacionesds_13_tfliqoblcuota_to = AV36TFLiqOblCuota_To ;
      AV81Obligacionesds_14_tfliqobltotal = AV37TFLiqOblTotal ;
      AV82Obligacionesds_15_tfliqobltotal_to = AV38TFLiqOblTotal_To ;
      AV83Obligacionesds_16_tfliqobltotrecal = AV39TFLiqOblTotRecal ;
      AV84Obligacionesds_17_tfliqobltotrecal_to = AV40TFLiqOblTotRecal_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           Integer.valueOf(AV71Obligacionesds_4_tfliqoblaltanro) ,
                                           Integer.valueOf(AV72Obligacionesds_5_tfliqoblaltanro_to) ,
                                           Integer.valueOf(AV73Obligacionesds_6_tfliqoblnuevanro) ,
                                           Integer.valueOf(AV74Obligacionesds_7_tfliqoblnuevanro_to) ,
                                           AV75Obligacionesds_8_tfliqoblperiodo ,
                                           AV76Obligacionesds_9_tfliqoblperiodo_to ,
                                           AV77Obligacionesds_10_tfliqoblsaldo ,
                                           AV78Obligacionesds_11_tfliqoblsaldo_to ,
                                           AV79Obligacionesds_12_tfliqoblcuota ,
                                           AV80Obligacionesds_13_tfliqoblcuota_to ,
                                           AV81Obligacionesds_14_tfliqobltotal ,
                                           AV82Obligacionesds_15_tfliqobltotal_to ,
                                           AV83Obligacionesds_16_tfliqobltotrecal ,
                                           AV84Obligacionesds_17_tfliqobltotrecal_to ,
                                           Integer.valueOf(A1184LiqOblAltaNro) ,
                                           Integer.valueOf(A1185LiqOblNuevaNro) ,
                                           A1199LiqOblPeriodo ,
                                           A1197LiqOblSaldo ,
                                           A1188LiqOblCuota ,
                                           A1189LiqOblTotal ,
                                           A1190LiqOblTotRecal ,
                                           Short.valueOf(AV16OrderedBy) ,
                                           Boolean.valueOf(AV17OrderedDsc) ,
                                           Integer.valueOf(AV68Obligacionesds_1_clicod) ,
                                           Short.valueOf(AV69Obligacionesds_2_empcod) ,
                                           Integer.valueOf(AV70Obligacionesds_3_legnumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      /* Using cursor H00DQ3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV68Obligacionesds_1_clicod), Short.valueOf(AV69Obligacionesds_2_empcod), Integer.valueOf(AV70Obligacionesds_3_legnumero), Integer.valueOf(AV71Obligacionesds_4_tfliqoblaltanro), Integer.valueOf(AV72Obligacionesds_5_tfliqoblaltanro_to), Integer.valueOf(AV73Obligacionesds_6_tfliqoblnuevanro), Integer.valueOf(AV74Obligacionesds_7_tfliqoblnuevanro_to), AV75Obligacionesds_8_tfliqoblperiodo, AV76Obligacionesds_9_tfliqoblperiodo_to, AV77Obligacionesds_10_tfliqoblsaldo, AV78Obligacionesds_11_tfliqoblsaldo_to, AV79Obligacionesds_12_tfliqoblcuota, AV80Obligacionesds_13_tfliqoblcuota_to, AV81Obligacionesds_14_tfliqobltotal, AV82Obligacionesds_15_tfliqobltotal_to, AV83Obligacionesds_16_tfliqobltotrecal, AV84Obligacionesds_17_tfliqobltotrecal_to});
      GRID_nRecordCount = H00DQ3_AGRID_nRecordCount[0] ;
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
      AV68Obligacionesds_1_clicod = AV8CliCod ;
      AV69Obligacionesds_2_empcod = AV9EmpCod ;
      AV70Obligacionesds_3_legnumero = AV10LegNumero ;
      AV71Obligacionesds_4_tfliqoblaltanro = AV24TFLiqOblAltaNro ;
      AV72Obligacionesds_5_tfliqoblaltanro_to = AV25TFLiqOblAltaNro_To ;
      AV73Obligacionesds_6_tfliqoblnuevanro = AV26TFLiqOblNuevaNro ;
      AV74Obligacionesds_7_tfliqoblnuevanro_to = AV27TFLiqOblNuevaNro_To ;
      AV75Obligacionesds_8_tfliqoblperiodo = AV28TFLiqOblPeriodo ;
      AV76Obligacionesds_9_tfliqoblperiodo_to = AV29TFLiqOblPeriodo_To ;
      AV77Obligacionesds_10_tfliqoblsaldo = AV33TFLiqOblSaldo ;
      AV78Obligacionesds_11_tfliqoblsaldo_to = AV34TFLiqOblSaldo_To ;
      AV79Obligacionesds_12_tfliqoblcuota = AV35TFLiqOblCuota ;
      AV80Obligacionesds_13_tfliqoblcuota_to = AV36TFLiqOblCuota_To ;
      AV81Obligacionesds_14_tfliqobltotal = AV37TFLiqOblTotal ;
      AV82Obligacionesds_15_tfliqobltotal_to = AV38TFLiqOblTotal_To ;
      AV83Obligacionesds_16_tfliqobltotrecal = AV39TFLiqOblTotRecal ;
      AV84Obligacionesds_17_tfliqobltotrecal_to = AV40TFLiqOblTotRecal_To ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV67Pgmname, AV50MenuOpcCod, AV8CliCod, AV9EmpCod, AV10LegNumero, AV24TFLiqOblAltaNro, AV25TFLiqOblAltaNro_To, AV26TFLiqOblNuevaNro, AV27TFLiqOblNuevaNro_To, AV28TFLiqOblPeriodo, AV29TFLiqOblPeriodo_To, AV33TFLiqOblSaldo, AV34TFLiqOblSaldo_To, AV35TFLiqOblCuota, AV36TFLiqOblCuota_To, AV37TFLiqOblTotal, AV38TFLiqOblTotal_To, AV39TFLiqOblTotRecal, AV40TFLiqOblTotRecal_To, AV16OrderedBy, AV17OrderedDsc, AV49IsAuthorized_Display, AV68Obligacionesds_1_clicod, AV69Obligacionesds_2_empcod, AV70Obligacionesds_3_legnumero, AV52WelcomeMessage_NoMostrarMas, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV68Obligacionesds_1_clicod = AV8CliCod ;
      AV69Obligacionesds_2_empcod = AV9EmpCod ;
      AV70Obligacionesds_3_legnumero = AV10LegNumero ;
      AV71Obligacionesds_4_tfliqoblaltanro = AV24TFLiqOblAltaNro ;
      AV72Obligacionesds_5_tfliqoblaltanro_to = AV25TFLiqOblAltaNro_To ;
      AV73Obligacionesds_6_tfliqoblnuevanro = AV26TFLiqOblNuevaNro ;
      AV74Obligacionesds_7_tfliqoblnuevanro_to = AV27TFLiqOblNuevaNro_To ;
      AV75Obligacionesds_8_tfliqoblperiodo = AV28TFLiqOblPeriodo ;
      AV76Obligacionesds_9_tfliqoblperiodo_to = AV29TFLiqOblPeriodo_To ;
      AV77Obligacionesds_10_tfliqoblsaldo = AV33TFLiqOblSaldo ;
      AV78Obligacionesds_11_tfliqoblsaldo_to = AV34TFLiqOblSaldo_To ;
      AV79Obligacionesds_12_tfliqoblcuota = AV35TFLiqOblCuota ;
      AV80Obligacionesds_13_tfliqoblcuota_to = AV36TFLiqOblCuota_To ;
      AV81Obligacionesds_14_tfliqobltotal = AV37TFLiqOblTotal ;
      AV82Obligacionesds_15_tfliqobltotal_to = AV38TFLiqOblTotal_To ;
      AV83Obligacionesds_16_tfliqobltotrecal = AV39TFLiqOblTotRecal ;
      AV84Obligacionesds_17_tfliqobltotrecal_to = AV40TFLiqOblTotRecal_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV67Pgmname, AV50MenuOpcCod, AV8CliCod, AV9EmpCod, AV10LegNumero, AV24TFLiqOblAltaNro, AV25TFLiqOblAltaNro_To, AV26TFLiqOblNuevaNro, AV27TFLiqOblNuevaNro_To, AV28TFLiqOblPeriodo, AV29TFLiqOblPeriodo_To, AV33TFLiqOblSaldo, AV34TFLiqOblSaldo_To, AV35TFLiqOblCuota, AV36TFLiqOblCuota_To, AV37TFLiqOblTotal, AV38TFLiqOblTotal_To, AV39TFLiqOblTotRecal, AV40TFLiqOblTotRecal_To, AV16OrderedBy, AV17OrderedDsc, AV49IsAuthorized_Display, AV68Obligacionesds_1_clicod, AV69Obligacionesds_2_empcod, AV70Obligacionesds_3_legnumero, AV52WelcomeMessage_NoMostrarMas, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV68Obligacionesds_1_clicod = AV8CliCod ;
      AV69Obligacionesds_2_empcod = AV9EmpCod ;
      AV70Obligacionesds_3_legnumero = AV10LegNumero ;
      AV71Obligacionesds_4_tfliqoblaltanro = AV24TFLiqOblAltaNro ;
      AV72Obligacionesds_5_tfliqoblaltanro_to = AV25TFLiqOblAltaNro_To ;
      AV73Obligacionesds_6_tfliqoblnuevanro = AV26TFLiqOblNuevaNro ;
      AV74Obligacionesds_7_tfliqoblnuevanro_to = AV27TFLiqOblNuevaNro_To ;
      AV75Obligacionesds_8_tfliqoblperiodo = AV28TFLiqOblPeriodo ;
      AV76Obligacionesds_9_tfliqoblperiodo_to = AV29TFLiqOblPeriodo_To ;
      AV77Obligacionesds_10_tfliqoblsaldo = AV33TFLiqOblSaldo ;
      AV78Obligacionesds_11_tfliqoblsaldo_to = AV34TFLiqOblSaldo_To ;
      AV79Obligacionesds_12_tfliqoblcuota = AV35TFLiqOblCuota ;
      AV80Obligacionesds_13_tfliqoblcuota_to = AV36TFLiqOblCuota_To ;
      AV81Obligacionesds_14_tfliqobltotal = AV37TFLiqOblTotal ;
      AV82Obligacionesds_15_tfliqobltotal_to = AV38TFLiqOblTotal_To ;
      AV83Obligacionesds_16_tfliqobltotrecal = AV39TFLiqOblTotRecal ;
      AV84Obligacionesds_17_tfliqobltotrecal_to = AV40TFLiqOblTotRecal_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV67Pgmname, AV50MenuOpcCod, AV8CliCod, AV9EmpCod, AV10LegNumero, AV24TFLiqOblAltaNro, AV25TFLiqOblAltaNro_To, AV26TFLiqOblNuevaNro, AV27TFLiqOblNuevaNro_To, AV28TFLiqOblPeriodo, AV29TFLiqOblPeriodo_To, AV33TFLiqOblSaldo, AV34TFLiqOblSaldo_To, AV35TFLiqOblCuota, AV36TFLiqOblCuota_To, AV37TFLiqOblTotal, AV38TFLiqOblTotal_To, AV39TFLiqOblTotRecal, AV40TFLiqOblTotRecal_To, AV16OrderedBy, AV17OrderedDsc, AV49IsAuthorized_Display, AV68Obligacionesds_1_clicod, AV69Obligacionesds_2_empcod, AV70Obligacionesds_3_legnumero, AV52WelcomeMessage_NoMostrarMas, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV68Obligacionesds_1_clicod = AV8CliCod ;
      AV69Obligacionesds_2_empcod = AV9EmpCod ;
      AV70Obligacionesds_3_legnumero = AV10LegNumero ;
      AV71Obligacionesds_4_tfliqoblaltanro = AV24TFLiqOblAltaNro ;
      AV72Obligacionesds_5_tfliqoblaltanro_to = AV25TFLiqOblAltaNro_To ;
      AV73Obligacionesds_6_tfliqoblnuevanro = AV26TFLiqOblNuevaNro ;
      AV74Obligacionesds_7_tfliqoblnuevanro_to = AV27TFLiqOblNuevaNro_To ;
      AV75Obligacionesds_8_tfliqoblperiodo = AV28TFLiqOblPeriodo ;
      AV76Obligacionesds_9_tfliqoblperiodo_to = AV29TFLiqOblPeriodo_To ;
      AV77Obligacionesds_10_tfliqoblsaldo = AV33TFLiqOblSaldo ;
      AV78Obligacionesds_11_tfliqoblsaldo_to = AV34TFLiqOblSaldo_To ;
      AV79Obligacionesds_12_tfliqoblcuota = AV35TFLiqOblCuota ;
      AV80Obligacionesds_13_tfliqoblcuota_to = AV36TFLiqOblCuota_To ;
      AV81Obligacionesds_14_tfliqobltotal = AV37TFLiqOblTotal ;
      AV82Obligacionesds_15_tfliqobltotal_to = AV38TFLiqOblTotal_To ;
      AV83Obligacionesds_16_tfliqobltotrecal = AV39TFLiqOblTotRecal ;
      AV84Obligacionesds_17_tfliqobltotrecal_to = AV40TFLiqOblTotRecal_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV67Pgmname, AV50MenuOpcCod, AV8CliCod, AV9EmpCod, AV10LegNumero, AV24TFLiqOblAltaNro, AV25TFLiqOblAltaNro_To, AV26TFLiqOblNuevaNro, AV27TFLiqOblNuevaNro_To, AV28TFLiqOblPeriodo, AV29TFLiqOblPeriodo_To, AV33TFLiqOblSaldo, AV34TFLiqOblSaldo_To, AV35TFLiqOblCuota, AV36TFLiqOblCuota_To, AV37TFLiqOblTotal, AV38TFLiqOblTotal_To, AV39TFLiqOblTotRecal, AV40TFLiqOblTotRecal_To, AV16OrderedBy, AV17OrderedDsc, AV49IsAuthorized_Display, AV68Obligacionesds_1_clicod, AV69Obligacionesds_2_empcod, AV70Obligacionesds_3_legnumero, AV52WelcomeMessage_NoMostrarMas, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV68Obligacionesds_1_clicod = AV8CliCod ;
      AV69Obligacionesds_2_empcod = AV9EmpCod ;
      AV70Obligacionesds_3_legnumero = AV10LegNumero ;
      AV71Obligacionesds_4_tfliqoblaltanro = AV24TFLiqOblAltaNro ;
      AV72Obligacionesds_5_tfliqoblaltanro_to = AV25TFLiqOblAltaNro_To ;
      AV73Obligacionesds_6_tfliqoblnuevanro = AV26TFLiqOblNuevaNro ;
      AV74Obligacionesds_7_tfliqoblnuevanro_to = AV27TFLiqOblNuevaNro_To ;
      AV75Obligacionesds_8_tfliqoblperiodo = AV28TFLiqOblPeriodo ;
      AV76Obligacionesds_9_tfliqoblperiodo_to = AV29TFLiqOblPeriodo_To ;
      AV77Obligacionesds_10_tfliqoblsaldo = AV33TFLiqOblSaldo ;
      AV78Obligacionesds_11_tfliqoblsaldo_to = AV34TFLiqOblSaldo_To ;
      AV79Obligacionesds_12_tfliqoblcuota = AV35TFLiqOblCuota ;
      AV80Obligacionesds_13_tfliqoblcuota_to = AV36TFLiqOblCuota_To ;
      AV81Obligacionesds_14_tfliqobltotal = AV37TFLiqOblTotal ;
      AV82Obligacionesds_15_tfliqobltotal_to = AV38TFLiqOblTotal_To ;
      AV83Obligacionesds_16_tfliqobltotrecal = AV39TFLiqOblTotRecal ;
      AV84Obligacionesds_17_tfliqobltotrecal_to = AV40TFLiqOblTotRecal_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV67Pgmname, AV50MenuOpcCod, AV8CliCod, AV9EmpCod, AV10LegNumero, AV24TFLiqOblAltaNro, AV25TFLiqOblAltaNro_To, AV26TFLiqOblNuevaNro, AV27TFLiqOblNuevaNro_To, AV28TFLiqOblPeriodo, AV29TFLiqOblPeriodo_To, AV33TFLiqOblSaldo, AV34TFLiqOblSaldo_To, AV35TFLiqOblCuota, AV36TFLiqOblCuota_To, AV37TFLiqOblTotal, AV38TFLiqOblTotal_To, AV39TFLiqOblTotRecal, AV40TFLiqOblTotRecal_To, AV16OrderedBy, AV17OrderedDsc, AV49IsAuthorized_Display, AV68Obligacionesds_1_clicod, AV69Obligacionesds_2_empcod, AV70Obligacionesds_3_legnumero, AV52WelcomeMessage_NoMostrarMas, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV67Pgmname = "obligaciones" ;
      Gx_err = (short)(0) ;
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_67_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_67_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupDQ0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e15DQ2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV41DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_67 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_67"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV43GridCurrentPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV44GridPageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV45GridAppliedFilters = httpContext.cgiGet( sPrefix+"vGRIDAPPLIEDFILTERS") ;
         AV30DDO_LiqOblPeriodoAuxDate = localUtil.ctod( httpContext.cgiGet( sPrefix+"vDDO_LIQOBLPERIODOAUXDATE"), 0) ;
         AV31DDO_LiqOblPeriodoAuxDateTo = localUtil.ctod( httpContext.cgiGet( sPrefix+"vDDO_LIQOBLPERIODOAUXDATETO"), 0) ;
         wcpOAV50MenuOpcCod = httpContext.cgiGet( sPrefix+"wcpOAV50MenuOpcCod") ;
         wcpOAV8CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV9EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV10LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV10LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
         Ddo_grid_Gridinternalname = httpContext.cgiGet( sPrefix+"DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( sPrefix+"DDO_GRID_Includesortasc") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( sPrefix+"DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( sPrefix+"DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( sPrefix+"DDO_GRID_Filtertype") ;
         Ddo_grid_Filterisrange = httpContext.cgiGet( sPrefix+"DDO_GRID_Filterisrange") ;
         Ddo_grid_Format = httpContext.cgiGet( sPrefix+"DDO_GRID_Format") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Hastitlesettings")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( sPrefix+"DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedvalue_get") ;
         Ddo_grid_Filteredtextto_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Filteredtextto_get") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Filteredtext_get") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedcolumn") ;
         /* Read variables values. */
         AV58WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV52WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52WelcomeMessage_NoMostrarMas", AV52WelcomeMessage_NoMostrarMas);
         AV32DDO_LiqOblPeriodoAuxDateText = httpContext.cgiGet( edtavDdo_liqoblperiodoauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32DDO_LiqOblPeriodoAuxDateText", AV32DDO_LiqOblPeriodoAuxDateText);
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
      e15DQ2 ();
      if (returnInSub) return;
   }

   public void e15DQ2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV50MenuOpcCod, "", "") ;
      this.executeUsercontrolMethod(sPrefix, false, "TFLIQOBLPERIODO_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_liqoblperiodoauxdatetext_Internalname});
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, sPrefix, false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      if ( AV16OrderedBy < 1 )
      {
         AV16OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S132 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV41DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV41DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, sPrefix, false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char3[0] = AV53MenuBienveImgURL ;
      GXv_char4[0] = AV55MenuBienveTitulo ;
      GXv_char5[0] = AV56MenuBienveTexto ;
      GXv_boolean6[0] = AV57MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV50MenuOpcCod, GXv_char3, GXv_char4, GXv_char5, GXv_boolean6) ;
      obligaciones_impl.this.AV53MenuBienveImgURL = GXv_char3[0] ;
      obligaciones_impl.this.AV55MenuBienveTitulo = GXv_char4[0] ;
      obligaciones_impl.this.AV56MenuBienveTexto = GXv_char5[0] ;
      obligaciones_impl.this.AV57MenuBienveVisible = GXv_boolean6[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV57MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV57MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV55MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV56MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV58WelcomeMessage_Foto = AV53MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV58WelcomeMessage_Foto)==0) ? AV66Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV58WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop(sPrefix, false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV58WelcomeMessage_Foto), true);
         AV66Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV53MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV58WelcomeMessage_Foto)==0) ? AV66Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV58WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop(sPrefix, false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV58WelcomeMessage_Foto), true);
      }
      GXt_char7 = "" ;
      GXt_char8 = "" ;
      GXv_char5[0] = GXt_char8 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char5) ;
      obligaciones_impl.this.GXt_char8 = GXv_char5[0] ;
      GXv_char4[0] = GXt_char7 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char8, GXv_char4) ;
      obligaciones_impl.this.GXt_char7 = GXv_char4[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char7 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
   }

   public void e16DQ2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext9[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext9) ;
      AV6WWPContext = GXv_SdtWWPContext9[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S152 ();
      if (returnInSub) return;
      AV43GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43GridCurrentPage), 10, 0));
      AV44GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44GridPageCount), 10, 0));
      GXt_char8 = AV45GridAppliedFilters ;
      GXv_char5[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV67Pgmname, GXv_char5) ;
      obligaciones_impl.this.GXt_char8 = GXv_char5[0] ;
      AV45GridAppliedFilters = GXt_char8 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45GridAppliedFilters", AV45GridAppliedFilters);
      GXt_char8 = AV63MenuOpcTitulo ;
      GXv_char5[0] = GXt_char8 ;
      new web.gettxtcount(remoteHandle, context).execute( AV50MenuOpcCod, GXv_char5) ;
      obligaciones_impl.this.GXt_char8 = GXv_char5[0] ;
      AV63MenuOpcTitulo = GXt_char8 ;
      if ( (GXutil.strcmp("", AV63MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV63MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      AV68Obligacionesds_1_clicod = AV8CliCod ;
      AV69Obligacionesds_2_empcod = AV9EmpCod ;
      AV70Obligacionesds_3_legnumero = AV10LegNumero ;
      AV71Obligacionesds_4_tfliqoblaltanro = AV24TFLiqOblAltaNro ;
      AV72Obligacionesds_5_tfliqoblaltanro_to = AV25TFLiqOblAltaNro_To ;
      AV73Obligacionesds_6_tfliqoblnuevanro = AV26TFLiqOblNuevaNro ;
      AV74Obligacionesds_7_tfliqoblnuevanro_to = AV27TFLiqOblNuevaNro_To ;
      AV75Obligacionesds_8_tfliqoblperiodo = AV28TFLiqOblPeriodo ;
      AV76Obligacionesds_9_tfliqoblperiodo_to = AV29TFLiqOblPeriodo_To ;
      AV77Obligacionesds_10_tfliqoblsaldo = AV33TFLiqOblSaldo ;
      AV78Obligacionesds_11_tfliqoblsaldo_to = AV34TFLiqOblSaldo_To ;
      AV79Obligacionesds_12_tfliqoblcuota = AV35TFLiqOblCuota ;
      AV80Obligacionesds_13_tfliqoblcuota_to = AV36TFLiqOblCuota_To ;
      AV81Obligacionesds_14_tfliqobltotal = AV37TFLiqOblTotal ;
      AV82Obligacionesds_15_tfliqobltotal_to = AV38TFLiqOblTotal_To ;
      AV83Obligacionesds_16_tfliqobltotrecal = AV39TFLiqOblTotRecal ;
      AV84Obligacionesds_17_tfliqobltotrecal_to = AV40TFLiqOblTotRecal_To ;
      /*  Sending Event outputs  */
   }

   public void e11DQ2( )
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
         AV42PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV42PageToGo) ;
      }
   }

   public void e12DQ2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e13DQ2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV16OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16OrderedBy), 4, 0));
         AV17OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17OrderedDsc", AV17OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S132 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqOblAltaNro") == 0 )
         {
            AV24TFLiqOblAltaNro = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24TFLiqOblAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24TFLiqOblAltaNro), 8, 0));
            AV25TFLiqOblAltaNro_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25TFLiqOblAltaNro_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25TFLiqOblAltaNro_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqOblNuevaNro") == 0 )
         {
            AV26TFLiqOblNuevaNro = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26TFLiqOblNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26TFLiqOblNuevaNro), 8, 0));
            AV27TFLiqOblNuevaNro_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27TFLiqOblNuevaNro_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFLiqOblNuevaNro_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqOblPeriodo") == 0 )
         {
            AV28TFLiqOblPeriodo = localUtil.ctod( Ddo_grid_Filteredtext_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28TFLiqOblPeriodo", localUtil.format(AV28TFLiqOblPeriodo, "99/99/9999"));
            AV29TFLiqOblPeriodo_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29TFLiqOblPeriodo_To", localUtil.format(AV29TFLiqOblPeriodo_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqOblSaldo") == 0 )
         {
            AV33TFLiqOblSaldo = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33TFLiqOblSaldo", GXutil.ltrimstr( AV33TFLiqOblSaldo, 14, 2));
            AV34TFLiqOblSaldo_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34TFLiqOblSaldo_To", GXutil.ltrimstr( AV34TFLiqOblSaldo_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqOblCuota") == 0 )
         {
            AV35TFLiqOblCuota = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35TFLiqOblCuota", GXutil.ltrimstr( AV35TFLiqOblCuota, 14, 2));
            AV36TFLiqOblCuota_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36TFLiqOblCuota_To", GXutil.ltrimstr( AV36TFLiqOblCuota_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqOblTotal") == 0 )
         {
            AV37TFLiqOblTotal = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37TFLiqOblTotal", GXutil.ltrimstr( AV37TFLiqOblTotal, 14, 2));
            AV38TFLiqOblTotal_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV38TFLiqOblTotal_To", GXutil.ltrimstr( AV38TFLiqOblTotal_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqOblTotRecal") == 0 )
         {
            AV39TFLiqOblTotRecal = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39TFLiqOblTotRecal", GXutil.ltrimstr( AV39TFLiqOblTotRecal, 14, 2));
            AV40TFLiqOblTotRecal_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40TFLiqOblTotRecal_To", GXutil.ltrimstr( AV40TFLiqOblTotRecal_To, 14, 2));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
   }

   private void e17DQ2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV48Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplay_Internalname, AV48Display);
      if ( AV49IsAuthorized_Display )
      {
         edtavDisplay_Link = formatLink("web.liqlegobligacioncuenta", new String[] {GXutil.URLEncode(GXutil.rtrim("DSP")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A1172OblSecuencial,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A1184LiqOblAltaNro,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A1185LiqOblNuevaNro,8,0))}, new String[] {})  ;
      }
      edtavVersvg_Format = (short)(1) ;
      GXt_char8 = AV47VerSVG ;
      GXv_char5[0] = GXt_char8 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char5) ;
      obligaciones_impl.this.GXt_char8 = GXv_char5[0] ;
      AV47VerSVG = GXt_char8 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavVersvg_Internalname, AV47VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(67) ;
      }
      sendrow_672( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_67_Refreshing )
      {
         httpContext.doAjaxLoad(67, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void S132( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV16OrderedBy, 4, 0))+":"+(AV17OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S142( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean10 = AV49IsAuthorized_Display ;
      GXv_boolean6[0] = GXt_boolean10 ;
      new web.wwpbaseobjects.secisauthbyobjectname(remoteHandle, context).execute( "LiqLegObligacionCuenta", GXv_boolean6) ;
      obligaciones_impl.this.GXt_boolean10 = GXv_boolean6[0] ;
      AV49IsAuthorized_Display = GXt_boolean10 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV49IsAuthorized_Display", AV49IsAuthorized_Display);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( sPrefix, AV49IsAuthorized_Display));
      if ( ! ( AV49IsAuthorized_Display ) )
      {
         edtavDisplay_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplay_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Visible), 5, 0), !bGXsfl_67_Refreshing);
      }
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV23Session.getValue(AV67Pgmname+"GridState"), "") == 0 )
      {
         AV14GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV67Pgmname+"GridState"), null, null);
      }
      else
      {
         AV14GridState.fromxml(AV23Session.getValue(AV67Pgmname+"GridState"), null, null);
      }
      AV16OrderedBy = AV14GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16OrderedBy), 4, 0));
      AV17OrderedDsc = AV14GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17OrderedDsc", AV17OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S132 ();
      if (returnInSub) return;
      AV85GXV1 = 1 ;
      while ( AV85GXV1 <= AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV15GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV85GXV1));
         if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQOBLALTANRO") == 0 )
         {
            AV24TFLiqOblAltaNro = (int)(GXutil.lval( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24TFLiqOblAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24TFLiqOblAltaNro), 8, 0));
            AV25TFLiqOblAltaNro_To = (int)(GXutil.lval( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25TFLiqOblAltaNro_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25TFLiqOblAltaNro_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQOBLNUEVANRO") == 0 )
         {
            AV26TFLiqOblNuevaNro = (int)(GXutil.lval( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26TFLiqOblNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26TFLiqOblNuevaNro), 8, 0));
            AV27TFLiqOblNuevaNro_To = (int)(GXutil.lval( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27TFLiqOblNuevaNro_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27TFLiqOblNuevaNro_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQOBLPERIODO") == 0 )
         {
            AV28TFLiqOblPeriodo = localUtil.ctod( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28TFLiqOblPeriodo", localUtil.format(AV28TFLiqOblPeriodo, "99/99/9999"));
            AV29TFLiqOblPeriodo_To = localUtil.ctod( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29TFLiqOblPeriodo_To", localUtil.format(AV29TFLiqOblPeriodo_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQOBLSALDO") == 0 )
         {
            AV33TFLiqOblSaldo = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33TFLiqOblSaldo", GXutil.ltrimstr( AV33TFLiqOblSaldo, 14, 2));
            AV34TFLiqOblSaldo_To = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34TFLiqOblSaldo_To", GXutil.ltrimstr( AV34TFLiqOblSaldo_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQOBLCUOTA") == 0 )
         {
            AV35TFLiqOblCuota = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35TFLiqOblCuota", GXutil.ltrimstr( AV35TFLiqOblCuota, 14, 2));
            AV36TFLiqOblCuota_To = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36TFLiqOblCuota_To", GXutil.ltrimstr( AV36TFLiqOblCuota_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQOBLTOTAL") == 0 )
         {
            AV37TFLiqOblTotal = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37TFLiqOblTotal", GXutil.ltrimstr( AV37TFLiqOblTotal, 14, 2));
            AV38TFLiqOblTotal_To = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV38TFLiqOblTotal_To", GXutil.ltrimstr( AV38TFLiqOblTotal_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQOBLTOTRECAL") == 0 )
         {
            AV39TFLiqOblTotRecal = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39TFLiqOblTotRecal", GXutil.ltrimstr( AV39TFLiqOblTotRecal, 14, 2));
            AV40TFLiqOblTotRecal_To = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40TFLiqOblTotRecal_To", GXutil.ltrimstr( AV40TFLiqOblTotRecal_To, 14, 2));
         }
         AV85GXV1 = (int)(AV85GXV1+1) ;
      }
      Ddo_grid_Filteredtext_set = ((0==AV24TFLiqOblAltaNro) ? "" : GXutil.str( AV24TFLiqOblAltaNro, 8, 0))+"|"+((0==AV26TFLiqOblNuevaNro) ? "" : GXutil.str( AV26TFLiqOblNuevaNro, 8, 0))+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV28TFLiqOblPeriodo)) ? "" : localUtil.dtoc( AV28TFLiqOblPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV33TFLiqOblSaldo)==0) ? "" : GXutil.str( AV33TFLiqOblSaldo, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV35TFLiqOblCuota)==0) ? "" : GXutil.str( AV35TFLiqOblCuota, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFLiqOblTotal)==0) ? "" : GXutil.str( AV37TFLiqOblTotal, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFLiqOblTotRecal)==0) ? "" : GXutil.str( AV39TFLiqOblTotRecal, 14, 2)) ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV25TFLiqOblAltaNro_To) ? "" : GXutil.str( AV25TFLiqOblAltaNro_To, 8, 0))+"|"+((0==AV27TFLiqOblNuevaNro_To) ? "" : GXutil.str( AV27TFLiqOblNuevaNro_To, 8, 0))+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV29TFLiqOblPeriodo_To)) ? "" : localUtil.dtoc( AV29TFLiqOblPeriodo_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV34TFLiqOblSaldo_To)==0) ? "" : GXutil.str( AV34TFLiqOblSaldo_To, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV36TFLiqOblCuota_To)==0) ? "" : GXutil.str( AV36TFLiqOblCuota_To, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFLiqOblTotal_To)==0) ? "" : GXutil.str( AV38TFLiqOblTotal_To, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFLiqOblTotRecal_To)==0) ? "" : GXutil.str( AV40TFLiqOblTotRecal_To, 14, 2)) ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
      if ( ! (GXutil.strcmp("", GXutil.trim( AV14GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV14GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV14GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S152( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV14GridState.fromxml(AV23Session.getValue(AV67Pgmname+"GridState"), null, null);
      AV14GridState.setgxTv_SdtWWPGridState_Orderedby( AV16OrderedBy );
      AV14GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV17OrderedDsc );
      AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState11[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState11, "TFLIQOBLALTANRO", httpContext.getMessage( "Liquidación de alta", ""), !((0==AV24TFLiqOblAltaNro)&&(0==AV25TFLiqOblAltaNro_To)), (short)(0), GXutil.trim( GXutil.str( AV24TFLiqOblAltaNro, 8, 0)), GXutil.trim( GXutil.str( AV25TFLiqOblAltaNro_To, 8, 0))) ;
      AV14GridState = GXv_SdtWWPGridState11[0] ;
      GXv_SdtWWPGridState11[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState11, "TFLIQOBLNUEVANRO", httpContext.getMessage( "Liquidación act.", ""), !((0==AV26TFLiqOblNuevaNro)&&(0==AV27TFLiqOblNuevaNro_To)), (short)(0), GXutil.trim( GXutil.str( AV26TFLiqOblNuevaNro, 8, 0)), GXutil.trim( GXutil.str( AV27TFLiqOblNuevaNro_To, 8, 0))) ;
      AV14GridState = GXv_SdtWWPGridState11[0] ;
      GXv_SdtWWPGridState11[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState11, "TFLIQOBLPERIODO", httpContext.getMessage( "Periodo", ""), !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV28TFLiqOblPeriodo))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV29TFLiqOblPeriodo_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV28TFLiqOblPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), GXutil.trim( localUtil.dtoc( AV29TFLiqOblPeriodo_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV14GridState = GXv_SdtWWPGridState11[0] ;
      GXv_SdtWWPGridState11[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState11, "TFLIQOBLSALDO", httpContext.getMessage( "Saldo", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV33TFLiqOblSaldo)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV34TFLiqOblSaldo_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV33TFLiqOblSaldo, 14, 2)), GXutil.trim( GXutil.str( AV34TFLiqOblSaldo_To, 14, 2))) ;
      AV14GridState = GXv_SdtWWPGridState11[0] ;
      GXv_SdtWWPGridState11[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState11, "TFLIQOBLCUOTA", httpContext.getMessage( "Cuota", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV35TFLiqOblCuota)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV36TFLiqOblCuota_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV35TFLiqOblCuota, 14, 2)), GXutil.trim( GXutil.str( AV36TFLiqOblCuota_To, 14, 2))) ;
      AV14GridState = GXv_SdtWWPGridState11[0] ;
      GXv_SdtWWPGridState11[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState11, "TFLIQOBLTOTAL", httpContext.getMessage( "Total", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFLiqOblTotal)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFLiqOblTotal_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV37TFLiqOblTotal, 14, 2)), GXutil.trim( GXutil.str( AV38TFLiqOblTotal_To, 14, 2))) ;
      AV14GridState = GXv_SdtWWPGridState11[0] ;
      GXv_SdtWWPGridState11[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState11, "TFLIQOBLTOTRECAL", httpContext.getMessage( "Total recalculado", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFLiqOblTotRecal)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFLiqOblTotRecal_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV39TFLiqOblTotRecal, 14, 2)), GXutil.trim( GXutil.str( AV40TFLiqOblTotRecal_To, 14, 2))) ;
      AV14GridState = GXv_SdtWWPGridState11[0] ;
      AV14GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV14GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV67Pgmname+"GridState", AV14GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV12TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV67Pgmname );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "LiqLegObligacionCuenta" );
      AV13TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "CliCod" );
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV8CliCod, 6, 0) );
      AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV13TrnContextAtt, 0);
      AV13TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "EmpCod" );
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV9EmpCod, 4, 0) );
      AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV13TrnContextAtt, 0);
      AV13TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "LegNumero" );
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV10LegNumero, 8, 0) );
      AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV13TrnContextAtt, 0);
      AV23Session.setValue("TrnContext", AV12TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void S162( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      GXv_SdtWWPColumnsSelector12[0] = AV21ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV8CliCod, GXv_SdtWWPColumnsSelector12) ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector12[0] ;
   }

   public void e14DQ2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV52WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean6[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV50MenuOpcCod, GXv_boolean6) ;
         GXv_char5[0] = AV54textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char5) ;
         obligaciones_impl.this.AV54textoNoMostrara = GXv_char5[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV54textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean6[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV50MenuOpcCod, GXv_boolean6) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_DQ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_DQ2( true) ;
      }
      else
      {
         wb_table2_12_DQ2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_DQ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_DQ2e( true) ;
      }
      else
      {
         wb_table1_9_DQ2e( false) ;
      }
   }

   public void wb_table2_12_DQ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablepadding_Internalname, tblTablepadding_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableparent_Internalname, divWelcomemessage_welcometableparent_Visible, 0, "px", 0, "px", "WelcomeTableParent", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableprincipal_Internalname, 1, 0, "px", 0, "px", "WelcomeHeaderItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tableclose_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+"e18dq1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_obligaciones.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcomecontentitem_Internalname, 1, 0, "px", 0, "px", "WelcomeContentItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcomecontentflex_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "WelcomeTableImagenCell", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableimagen_Internalname, 1, 0, "px", 0, "px", "WelcomeTableImagen", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, "", httpContext.getMessage( "Welcome Message_Foto", ""), "gx-form-item WelcomeImagenLabel", 0, true, "width: 25%;");
         /* Static Bitmap Variable */
         ClassString = "WelcomeImagen" + " " + ((GXutil.strcmp(imgavWelcomemessage_foto_gximage, "")==0) ? "" : "GX_Image_"+imgavWelcomemessage_foto_gximage+"_Class") ;
         StyleString = "" ;
         AV58WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV58WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV66Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV58WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV58WelcomeMessage_Foto)==0) ? AV66Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV58WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV58WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_obligaciones.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "WelcomeTableTextoCell", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tabletexto_Internalname, 1, 0, "px", 0, "px", "WelcomeTableTexto", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;align-items:flex-start;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table3_30_DQ2( true) ;
      }
      else
      {
         wb_table3_30_DQ2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_DQ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_DQ2( true) ;
      }
      else
      {
         wb_table4_35_DQ2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_DQ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcomebottomitem_Internalname, 1, 0, "px", 0, "px", "WelcomeBottomItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tablecmb_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tablec_Internalname, 1, 0, "px", 0, "px", "TableC font14px", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), "gx-form-item AttributeCheckBoxLabel", 0, true, "width: 25%;");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'" + sPrefix + "',false,'" + sGXsfl_67_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV52WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tabletext_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_obligaciones.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablefiltrospadre_Internalname, 1, 0, "px", 0, "px", "TableFiltrosPadre", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         wb_table5_54_DQ2( true) ;
      }
      else
      {
         wb_table5_54_DQ2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_DQ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='SectionGrid GridFixedTitles HasGridEmpowerer'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol67( ) ;
      }
      if ( wbEnd == 67 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_67 = (int)(nGXsfl_67_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV43GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV44GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV45GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, sPrefix+"GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_DQ2e( true) ;
      }
      else
      {
         wb_table2_12_DQ2e( false) ;
      }
   }

   public void wb_table5_54_DQ2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_obligaciones.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_obligaciones.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_DQ2e( true) ;
      }
      else
      {
         wb_table5_54_DQ2e( false) ;
      }
   }

   public void wb_table4_35_DQ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_obligaciones.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_DQ2e( true) ;
      }
      else
      {
         wb_table4_35_DQ2e( false) ;
      }
   }

   public void wb_table3_30_DQ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_obligaciones.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_DQ2e( true) ;
      }
      else
      {
         wb_table3_30_DQ2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV50MenuOpcCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV50MenuOpcCod", AV50MenuOpcCod);
      AV8CliCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      AV9EmpCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
      AV10LegNumero = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LegNumero), 8, 0));
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
      paDQ2( ) ;
      wsDQ2( ) ;
      weDQ2( ) ;
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
      sCtrlAV50MenuOpcCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV8CliCod = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV9EmpCod = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlAV10LegNumero = (String)getParm(obj,3,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paDQ2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "obligaciones", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paDQ2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV50MenuOpcCod = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV50MenuOpcCod", AV50MenuOpcCod);
         AV8CliCod = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
         AV9EmpCod = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
         AV10LegNumero = ((Number) GXutil.testNumericType( getParm(obj,5,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LegNumero), 8, 0));
      }
      wcpOAV50MenuOpcCod = httpContext.cgiGet( sPrefix+"wcpOAV50MenuOpcCod") ;
      wcpOAV8CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV9EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV10LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV10LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV50MenuOpcCod, wcpOAV50MenuOpcCod) != 0 ) || ( AV8CliCod != wcpOAV8CliCod ) || ( AV9EmpCod != wcpOAV9EmpCod ) || ( AV10LegNumero != wcpOAV10LegNumero ) ) )
      {
         setjustcreated();
      }
      wcpOAV50MenuOpcCod = AV50MenuOpcCod ;
      wcpOAV8CliCod = AV8CliCod ;
      wcpOAV9EmpCod = AV9EmpCod ;
      wcpOAV10LegNumero = AV10LegNumero ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV50MenuOpcCod = httpContext.cgiGet( sPrefix+"AV50MenuOpcCod_CTRL") ;
      if ( GXutil.len( sCtrlAV50MenuOpcCod) > 0 )
      {
         AV50MenuOpcCod = httpContext.cgiGet( sCtrlAV50MenuOpcCod) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV50MenuOpcCod", AV50MenuOpcCod);
      }
      else
      {
         AV50MenuOpcCod = httpContext.cgiGet( sPrefix+"AV50MenuOpcCod_PARM") ;
      }
      sCtrlAV8CliCod = httpContext.cgiGet( sPrefix+"AV8CliCod_CTRL") ;
      if ( GXutil.len( sCtrlAV8CliCod) > 0 )
      {
         AV8CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV8CliCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      }
      else
      {
         AV8CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV8CliCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV9EmpCod = httpContext.cgiGet( sPrefix+"AV9EmpCod_CTRL") ;
      if ( GXutil.len( sCtrlAV9EmpCod) > 0 )
      {
         AV9EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlAV9EmpCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
      }
      else
      {
         AV9EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV9EmpCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV10LegNumero = httpContext.cgiGet( sPrefix+"AV10LegNumero_CTRL") ;
      if ( GXutil.len( sCtrlAV10LegNumero) > 0 )
      {
         AV10LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV10LegNumero), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LegNumero), 8, 0));
      }
      else
      {
         AV10LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV10LegNumero_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      paDQ2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsDQ2( ) ;
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
      wsDQ2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV50MenuOpcCod_PARM", AV50MenuOpcCod);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV50MenuOpcCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV50MenuOpcCod_CTRL", GXutil.rtrim( sCtrlAV50MenuOpcCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8CliCod_PARM", GXutil.ltrim( localUtil.ntoc( AV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV8CliCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8CliCod_CTRL", GXutil.rtrim( sCtrlAV8CliCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV9EmpCod_PARM", GXutil.ltrim( localUtil.ntoc( AV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV9EmpCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV9EmpCod_CTRL", GXutil.rtrim( sCtrlAV9EmpCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10LegNumero_PARM", GXutil.ltrim( localUtil.ntoc( AV10LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV10LegNumero)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10LegNumero_CTRL", GXutil.rtrim( sCtrlAV10LegNumero));
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
      weDQ2( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020313437", true, true);
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
      httpContext.AddJavascriptSource("obligaciones.js", "?2024122020313437", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_672( )
   {
      edtCliCod_Internalname = sPrefix+"CLICOD_"+sGXsfl_67_idx ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD_"+sGXsfl_67_idx ;
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO_"+sGXsfl_67_idx ;
      edtOblSecuencial_Internalname = sPrefix+"OBLSECUENCIAL_"+sGXsfl_67_idx ;
      edtLiqOblAltaNro_Internalname = sPrefix+"LIQOBLALTANRO_"+sGXsfl_67_idx ;
      edtLiqOblNuevaNro_Internalname = sPrefix+"LIQOBLNUEVANRO_"+sGXsfl_67_idx ;
      chkLiqOblPrimera.setInternalname( sPrefix+"LIQOBLPRIMERA_"+sGXsfl_67_idx );
      edtLiqOblLog_Internalname = sPrefix+"LIQOBLLOG_"+sGXsfl_67_idx ;
      edtLiqOblPeriodo_Internalname = sPrefix+"LIQOBLPERIODO_"+sGXsfl_67_idx ;
      edtLiqOblSaldo_Internalname = sPrefix+"LIQOBLSALDO_"+sGXsfl_67_idx ;
      edtLiqOblCuota_Internalname = sPrefix+"LIQOBLCUOTA_"+sGXsfl_67_idx ;
      edtLiqOblTotal_Internalname = sPrefix+"LIQOBLTOTAL_"+sGXsfl_67_idx ;
      edtLiqOblTotRecal_Internalname = sPrefix+"LIQOBLTOTRECAL_"+sGXsfl_67_idx ;
      edtavVersvg_Internalname = sPrefix+"vVERSVG_"+sGXsfl_67_idx ;
      edtavDisplay_Internalname = sPrefix+"vDISPLAY_"+sGXsfl_67_idx ;
   }

   public void subsflControlProps_fel_672( )
   {
      edtCliCod_Internalname = sPrefix+"CLICOD_"+sGXsfl_67_fel_idx ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD_"+sGXsfl_67_fel_idx ;
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO_"+sGXsfl_67_fel_idx ;
      edtOblSecuencial_Internalname = sPrefix+"OBLSECUENCIAL_"+sGXsfl_67_fel_idx ;
      edtLiqOblAltaNro_Internalname = sPrefix+"LIQOBLALTANRO_"+sGXsfl_67_fel_idx ;
      edtLiqOblNuevaNro_Internalname = sPrefix+"LIQOBLNUEVANRO_"+sGXsfl_67_fel_idx ;
      chkLiqOblPrimera.setInternalname( sPrefix+"LIQOBLPRIMERA_"+sGXsfl_67_fel_idx );
      edtLiqOblLog_Internalname = sPrefix+"LIQOBLLOG_"+sGXsfl_67_fel_idx ;
      edtLiqOblPeriodo_Internalname = sPrefix+"LIQOBLPERIODO_"+sGXsfl_67_fel_idx ;
      edtLiqOblSaldo_Internalname = sPrefix+"LIQOBLSALDO_"+sGXsfl_67_fel_idx ;
      edtLiqOblCuota_Internalname = sPrefix+"LIQOBLCUOTA_"+sGXsfl_67_fel_idx ;
      edtLiqOblTotal_Internalname = sPrefix+"LIQOBLTOTAL_"+sGXsfl_67_fel_idx ;
      edtLiqOblTotRecal_Internalname = sPrefix+"LIQOBLTOTRECAL_"+sGXsfl_67_fel_idx ;
      edtavVersvg_Internalname = sPrefix+"vVERSVG_"+sGXsfl_67_fel_idx ;
      edtavDisplay_Internalname = sPrefix+"vDISPLAY_"+sGXsfl_67_fel_idx ;
   }

   public void sendrow_672( )
   {
      subsflControlProps_672( ) ;
      wbDQ0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_67_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_67_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_67_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtEmpCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNumero_Internalname,GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegNumero_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOblSecuencial_Internalname,GXutil.ltrim( localUtil.ntoc( A1172OblSecuencial, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1172OblSecuencial), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtOblSecuencial_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqOblAltaNro_Internalname,GXutil.ltrim( localUtil.ntoc( A1184LiqOblAltaNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1184LiqOblAltaNro), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqOblAltaNro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqOblNuevaNro_Internalname,GXutil.ltrim( localUtil.ntoc( A1185LiqOblNuevaNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1185LiqOblNuevaNro), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqOblNuevaNro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "LIQOBLPRIMERA_" + sGXsfl_67_idx ;
         chkLiqOblPrimera.setName( GXCCtl );
         chkLiqOblPrimera.setWebtags( "" );
         chkLiqOblPrimera.setCaption( "" );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkLiqOblPrimera.getInternalname(), "TitleCaption", chkLiqOblPrimera.getCaption(), !bGXsfl_67_Refreshing);
         chkLiqOblPrimera.setCheckedValue( "false" );
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkLiqOblPrimera.getInternalname(),GXutil.booltostr( A1186LiqOblPrimera),"","",Integer.valueOf(0),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqOblLog_Internalname,A1187LiqOblLog,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqOblLog_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqOblPeriodo_Internalname,localUtil.format(A1199LiqOblPeriodo, "99/99/9999"),localUtil.format( A1199LiqOblPeriodo, "99/99/9999"),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqOblPeriodo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqOblSaldo_Internalname,GXutil.ltrim( localUtil.ntoc( A1197LiqOblSaldo, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1197LiqOblSaldo, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqOblSaldo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqOblCuota_Internalname,GXutil.ltrim( localUtil.ntoc( A1188LiqOblCuota, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1188LiqOblCuota, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqOblCuota_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqOblTotal_Internalname,GXutil.ltrim( localUtil.ntoc( A1189LiqOblTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1189LiqOblTotal, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqOblTotal_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqOblTotRecal_Internalname,GXutil.ltrim( localUtil.ntoc( A1190LiqOblTotRecal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1190LiqOblTotRecal, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqOblTotRecal_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV47VerSVG),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(-1),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV48Display),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesDQ2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_67_idx = ((subGrid_Islastpage==1)&&(nGXsfl_67_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_67_idx+1) ;
         sGXsfl_67_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_672( ) ;
      }
      /* End function sendrow_672 */
   }

   public void startgridcontrol67( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"67\">") ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cod", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Empresa", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Legajo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Secuencial", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Liquidación de alta", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Liquidación act.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Obl Primera", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Obl Log", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Periodo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Saldo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cuota", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Total", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Total recalculado", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1172OblSecuencial, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1184LiqOblAltaNro, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1185LiqOblNuevaNro, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1186LiqOblPrimera));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1187LiqOblLog);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A1199LiqOblPeriodo, "99/99/9999"));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1197LiqOblSaldo, (byte)(17), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1188LiqOblCuota, (byte)(17), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1189LiqOblTotal, (byte)(17), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1190LiqOblTotRecal, (byte)(17), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV47VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV48Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
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
      lblWelcomemessage_closehelp_Internalname = sPrefix+"WELCOMEMESSAGE_CLOSEHELP" ;
      divWelcomemessage_tableclose_Internalname = sPrefix+"WELCOMEMESSAGE_TABLECLOSE" ;
      divWelcomemessage_welcometableprincipal_Internalname = sPrefix+"WELCOMEMESSAGE_WELCOMETABLEPRINCIPAL" ;
      imgavWelcomemessage_foto_Internalname = sPrefix+"vWELCOMEMESSAGE_FOTO" ;
      divWelcomemessage_welcometableimagen_Internalname = sPrefix+"WELCOMEMESSAGE_WELCOMETABLEIMAGEN" ;
      lblWelcomemessage_titulo_Internalname = sPrefix+"WELCOMEMESSAGE_TITULO" ;
      tblWelcomemessage_tabletitulo_Internalname = sPrefix+"WELCOMEMESSAGE_TABLETITULO" ;
      lblWelcomemessage_descripcion_Internalname = sPrefix+"WELCOMEMESSAGE_DESCRIPCION" ;
      tblWelcomemessage_tabledescripcion_Internalname = sPrefix+"WELCOMEMESSAGE_TABLEDESCRIPCION" ;
      divWelcomemessage_tabletexto_Internalname = sPrefix+"WELCOMEMESSAGE_TABLETEXTO" ;
      divWelcomemessage_welcomecontentflex_Internalname = sPrefix+"WELCOMEMESSAGE_WELCOMECONTENTFLEX" ;
      divWelcomemessage_welcomecontentitem_Internalname = sPrefix+"WELCOMEMESSAGE_WELCOMECONTENTITEM" ;
      chkavWelcomemessage_nomostrarmas.setInternalname( sPrefix+"vWELCOMEMESSAGE_NOMOSTRARMAS" );
      divWelcomemessage_tablec_Internalname = sPrefix+"WELCOMEMESSAGE_TABLEC" ;
      lblWelcomemessage_combotext_Internalname = sPrefix+"WELCOMEMESSAGE_COMBOTEXT" ;
      divWelcomemessage_tabletext_Internalname = sPrefix+"WELCOMEMESSAGE_TABLETEXT" ;
      divWelcomemessage_tablecmb_Internalname = sPrefix+"WELCOMEMESSAGE_TABLECMB" ;
      divWelcomemessage_welcomebottomitem_Internalname = sPrefix+"WELCOMEMESSAGE_WELCOMEBOTTOMITEM" ;
      divWelcomemessage_welcometableparent_Internalname = sPrefix+"WELCOMEMESSAGE_WELCOMETABLEPARENT" ;
      lblTotaltext_Internalname = sPrefix+"TOTALTEXT" ;
      lblCouttext_Internalname = sPrefix+"COUTTEXT" ;
      divTabletotal_Internalname = sPrefix+"TABLETOTAL" ;
      tblTabletotalregistros_Internalname = sPrefix+"TABLETOTALREGISTROS" ;
      divTablefiltrospadre_Internalname = sPrefix+"TABLEFILTROSPADRE" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO" ;
      edtOblSecuencial_Internalname = sPrefix+"OBLSECUENCIAL" ;
      edtLiqOblAltaNro_Internalname = sPrefix+"LIQOBLALTANRO" ;
      edtLiqOblNuevaNro_Internalname = sPrefix+"LIQOBLNUEVANRO" ;
      chkLiqOblPrimera.setInternalname( sPrefix+"LIQOBLPRIMERA" );
      edtLiqOblLog_Internalname = sPrefix+"LIQOBLLOG" ;
      edtLiqOblPeriodo_Internalname = sPrefix+"LIQOBLPERIODO" ;
      edtLiqOblSaldo_Internalname = sPrefix+"LIQOBLSALDO" ;
      edtLiqOblCuota_Internalname = sPrefix+"LIQOBLCUOTA" ;
      edtLiqOblTotal_Internalname = sPrefix+"LIQOBLTOTAL" ;
      edtLiqOblTotRecal_Internalname = sPrefix+"LIQOBLTOTRECAL" ;
      edtavVersvg_Internalname = sPrefix+"vVERSVG" ;
      edtavDisplay_Internalname = sPrefix+"vDISPLAY" ;
      Gridpaginationbar_Internalname = sPrefix+"GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = sPrefix+"GRIDTABLEWITHPAGINATIONBAR" ;
      tblTablepadding_Internalname = sPrefix+"TABLEPADDING" ;
      tblTablemainfix_Internalname = sPrefix+"TABLEMAINFIX" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
      Grid_empowerer_Internalname = sPrefix+"GRID_EMPOWERER" ;
      edtavDdo_liqoblperiodoauxdatetext_Internalname = sPrefix+"vDDO_LIQOBLPERIODOAUXDATETEXT" ;
      Tfliqoblperiodo_rangepicker_Internalname = sPrefix+"TFLIQOBLPERIODO_RANGEPICKER" ;
      divDdo_liqoblperiodoauxdates_Internalname = sPrefix+"DDO_LIQOBLPERIODOAUXDATES" ;
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
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Enabled = 0 ;
      edtavVersvg_Jsonclick = "" ;
      edtavVersvg_Columnclass = "WWColumn" ;
      edtavVersvg_Link = "" ;
      edtavVersvg_Enabled = 0 ;
      edtavVersvg_Format = (short)(0) ;
      edtLiqOblTotRecal_Jsonclick = "" ;
      edtLiqOblTotal_Jsonclick = "" ;
      edtLiqOblCuota_Jsonclick = "" ;
      edtLiqOblSaldo_Jsonclick = "" ;
      edtLiqOblPeriodo_Jsonclick = "" ;
      edtLiqOblLog_Jsonclick = "" ;
      chkLiqOblPrimera.setCaption( "" );
      edtLiqOblNuevaNro_Jsonclick = "" ;
      edtLiqOblAltaNro_Jsonclick = "" ;
      edtOblSecuencial_Jsonclick = "" ;
      edtLegNumero_Jsonclick = "" ;
      edtEmpCod_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      lblCouttext_Visible = 1 ;
      chkavWelcomemessage_nomostrarmas.setEnabled( 1 );
      imgavWelcomemessage_foto_gximage = "" ;
      divWelcomemessage_welcometableparent_Visible = 1 ;
      lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
      edtavDisplay_Visible = -1 ;
      edtavDisplay_Link = "" ;
      lblCouttext_Caption = httpContext.getMessage( "27 registros", "") ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      edtavDdo_liqoblperiodoauxdatetext_Jsonclick = "" ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "8.0|8.0||-14.2|-14.2|-14.2|-14.2" ;
      Ddo_grid_Filterisrange = "T|T|P|T|T|T|T" ;
      Ddo_grid_Filtertype = "Numeric|Numeric|Date|Numeric|Numeric|Numeric|Numeric" ;
      Ddo_grid_Includefilter = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|6|7" ;
      Ddo_grid_Columnids = "4:LiqOblAltaNro|5:LiqOblNuevaNro|8:LiqOblPeriodo|9:LiqOblSaldo|10:LiqOblCuota|11:LiqOblTotal|12:LiqOblTotRecal" ;
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
      chkavWelcomemessage_nomostrarmas.setName( "vWELCOMEMESSAGE_NOMOSTRARMAS" );
      chkavWelcomemessage_nomostrarmas.setWebtags( "" );
      chkavWelcomemessage_nomostrarmas.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavWelcomemessage_nomostrarmas.getInternalname(), "TitleCaption", chkavWelcomemessage_nomostrarmas.getCaption(), true);
      chkavWelcomemessage_nomostrarmas.setCheckedValue( "false" );
      GXCCtl = "LIQOBLPRIMERA_" + sGXsfl_67_idx ;
      chkLiqOblPrimera.setName( GXCCtl );
      chkLiqOblPrimera.setWebtags( "" );
      chkLiqOblPrimera.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkLiqOblPrimera.getInternalname(), "TitleCaption", chkLiqOblPrimera.getCaption(), !bGXsfl_67_Refreshing);
      chkLiqOblPrimera.setCheckedValue( "false" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV68Obligacionesds_1_clicod',fld:'vOBLIGACIONESDS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV69Obligacionesds_2_empcod',fld:'vOBLIGACIONESDS_2_EMPCOD',pic:'ZZZ9'},{av:'AV70Obligacionesds_3_legnumero',fld:'vOBLIGACIONESDS_3_LEGNUMERO',pic:'ZZZZZZZ9'},{av:'sPrefix'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV67Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV50MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV24TFLiqOblAltaNro',fld:'vTFLIQOBLALTANRO',pic:'ZZZZZZZ9'},{av:'AV25TFLiqOblAltaNro_To',fld:'vTFLIQOBLALTANRO_TO',pic:'ZZZZZZZ9'},{av:'AV26TFLiqOblNuevaNro',fld:'vTFLIQOBLNUEVANRO',pic:'ZZZZZZZ9'},{av:'AV27TFLiqOblNuevaNro_To',fld:'vTFLIQOBLNUEVANRO_TO',pic:'ZZZZZZZ9'},{av:'AV28TFLiqOblPeriodo',fld:'vTFLIQOBLPERIODO',pic:''},{av:'AV29TFLiqOblPeriodo_To',fld:'vTFLIQOBLPERIODO_TO',pic:''},{av:'AV33TFLiqOblSaldo',fld:'vTFLIQOBLSALDO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV34TFLiqOblSaldo_To',fld:'vTFLIQOBLSALDO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV35TFLiqOblCuota',fld:'vTFLIQOBLCUOTA',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV36TFLiqOblCuota_To',fld:'vTFLIQOBLCUOTA_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV37TFLiqOblTotal',fld:'vTFLIQOBLTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFLiqOblTotal_To',fld:'vTFLIQOBLTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV39TFLiqOblTotRecal',fld:'vTFLIQOBLTOTRECAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFLiqOblTotRecal_To',fld:'vTFLIQOBLTOTRECAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV49IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV52WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV43GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV44GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV45GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'AV49IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e11DQ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV67Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV50MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV24TFLiqOblAltaNro',fld:'vTFLIQOBLALTANRO',pic:'ZZZZZZZ9'},{av:'AV25TFLiqOblAltaNro_To',fld:'vTFLIQOBLALTANRO_TO',pic:'ZZZZZZZ9'},{av:'AV26TFLiqOblNuevaNro',fld:'vTFLIQOBLNUEVANRO',pic:'ZZZZZZZ9'},{av:'AV27TFLiqOblNuevaNro_To',fld:'vTFLIQOBLNUEVANRO_TO',pic:'ZZZZZZZ9'},{av:'AV28TFLiqOblPeriodo',fld:'vTFLIQOBLPERIODO',pic:''},{av:'AV29TFLiqOblPeriodo_To',fld:'vTFLIQOBLPERIODO_TO',pic:''},{av:'AV33TFLiqOblSaldo',fld:'vTFLIQOBLSALDO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV34TFLiqOblSaldo_To',fld:'vTFLIQOBLSALDO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV35TFLiqOblCuota',fld:'vTFLIQOBLCUOTA',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV36TFLiqOblCuota_To',fld:'vTFLIQOBLCUOTA_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV37TFLiqOblTotal',fld:'vTFLIQOBLTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFLiqOblTotal_To',fld:'vTFLIQOBLTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV39TFLiqOblTotRecal',fld:'vTFLIQOBLTOTRECAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFLiqOblTotRecal_To',fld:'vTFLIQOBLTOTRECAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV49IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV68Obligacionesds_1_clicod',fld:'vOBLIGACIONESDS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV69Obligacionesds_2_empcod',fld:'vOBLIGACIONESDS_2_EMPCOD',pic:'ZZZ9'},{av:'AV70Obligacionesds_3_legnumero',fld:'vOBLIGACIONESDS_3_LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV52WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'sPrefix'},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e12DQ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV67Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV50MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV24TFLiqOblAltaNro',fld:'vTFLIQOBLALTANRO',pic:'ZZZZZZZ9'},{av:'AV25TFLiqOblAltaNro_To',fld:'vTFLIQOBLALTANRO_TO',pic:'ZZZZZZZ9'},{av:'AV26TFLiqOblNuevaNro',fld:'vTFLIQOBLNUEVANRO',pic:'ZZZZZZZ9'},{av:'AV27TFLiqOblNuevaNro_To',fld:'vTFLIQOBLNUEVANRO_TO',pic:'ZZZZZZZ9'},{av:'AV28TFLiqOblPeriodo',fld:'vTFLIQOBLPERIODO',pic:''},{av:'AV29TFLiqOblPeriodo_To',fld:'vTFLIQOBLPERIODO_TO',pic:''},{av:'AV33TFLiqOblSaldo',fld:'vTFLIQOBLSALDO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV34TFLiqOblSaldo_To',fld:'vTFLIQOBLSALDO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV35TFLiqOblCuota',fld:'vTFLIQOBLCUOTA',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV36TFLiqOblCuota_To',fld:'vTFLIQOBLCUOTA_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV37TFLiqOblTotal',fld:'vTFLIQOBLTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFLiqOblTotal_To',fld:'vTFLIQOBLTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV39TFLiqOblTotRecal',fld:'vTFLIQOBLTOTRECAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFLiqOblTotRecal_To',fld:'vTFLIQOBLTOTRECAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV49IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV68Obligacionesds_1_clicod',fld:'vOBLIGACIONESDS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV69Obligacionesds_2_empcod',fld:'vOBLIGACIONESDS_2_EMPCOD',pic:'ZZZ9'},{av:'AV70Obligacionesds_3_legnumero',fld:'vOBLIGACIONESDS_3_LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV52WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'sPrefix'},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e13DQ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV67Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV50MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV24TFLiqOblAltaNro',fld:'vTFLIQOBLALTANRO',pic:'ZZZZZZZ9'},{av:'AV25TFLiqOblAltaNro_To',fld:'vTFLIQOBLALTANRO_TO',pic:'ZZZZZZZ9'},{av:'AV26TFLiqOblNuevaNro',fld:'vTFLIQOBLNUEVANRO',pic:'ZZZZZZZ9'},{av:'AV27TFLiqOblNuevaNro_To',fld:'vTFLIQOBLNUEVANRO_TO',pic:'ZZZZZZZ9'},{av:'AV28TFLiqOblPeriodo',fld:'vTFLIQOBLPERIODO',pic:''},{av:'AV29TFLiqOblPeriodo_To',fld:'vTFLIQOBLPERIODO_TO',pic:''},{av:'AV33TFLiqOblSaldo',fld:'vTFLIQOBLSALDO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV34TFLiqOblSaldo_To',fld:'vTFLIQOBLSALDO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV35TFLiqOblCuota',fld:'vTFLIQOBLCUOTA',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV36TFLiqOblCuota_To',fld:'vTFLIQOBLCUOTA_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV37TFLiqOblTotal',fld:'vTFLIQOBLTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFLiqOblTotal_To',fld:'vTFLIQOBLTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV39TFLiqOblTotRecal',fld:'vTFLIQOBLTOTRECAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFLiqOblTotRecal_To',fld:'vTFLIQOBLTOTRECAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV49IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV68Obligacionesds_1_clicod',fld:'vOBLIGACIONESDS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV69Obligacionesds_2_empcod',fld:'vOBLIGACIONESDS_2_EMPCOD',pic:'ZZZ9'},{av:'AV70Obligacionesds_3_legnumero',fld:'vOBLIGACIONESDS_3_LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV52WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV39TFLiqOblTotRecal',fld:'vTFLIQOBLTOTRECAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFLiqOblTotRecal_To',fld:'vTFLIQOBLTOTRECAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV37TFLiqOblTotal',fld:'vTFLIQOBLTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFLiqOblTotal_To',fld:'vTFLIQOBLTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV35TFLiqOblCuota',fld:'vTFLIQOBLCUOTA',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV36TFLiqOblCuota_To',fld:'vTFLIQOBLCUOTA_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV33TFLiqOblSaldo',fld:'vTFLIQOBLSALDO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV34TFLiqOblSaldo_To',fld:'vTFLIQOBLSALDO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV28TFLiqOblPeriodo',fld:'vTFLIQOBLPERIODO',pic:''},{av:'AV29TFLiqOblPeriodo_To',fld:'vTFLIQOBLPERIODO_TO',pic:''},{av:'AV26TFLiqOblNuevaNro',fld:'vTFLIQOBLNUEVANRO',pic:'ZZZZZZZ9'},{av:'AV27TFLiqOblNuevaNro_To',fld:'vTFLIQOBLNUEVANRO_TO',pic:'ZZZZZZZ9'},{av:'AV24TFLiqOblAltaNro',fld:'vTFLIQOBLALTANRO',pic:'ZZZZZZZ9'},{av:'AV25TFLiqOblAltaNro_To',fld:'vTFLIQOBLALTANRO_TO',pic:'ZZZZZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e17DQ2',iparms:[{av:'AV49IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A1172OblSecuencial',fld:'OBLSECUENCIAL',pic:'ZZZ9'},{av:'A1184LiqOblAltaNro',fld:'LIQOBLALTANRO',pic:'ZZZZZZZ9'},{av:'A1185LiqOblNuevaNro',fld:'LIQOBLNUEVANRO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV48Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV47VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'}]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e14DQ2',iparms:[{av:'AV52WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV50MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e18DQ1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("NULL","{handler:'validv_Display',iparms:[]");
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
      wcpOAV50MenuOpcCod = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV50MenuOpcCod = "" ;
      AV67Pgmname = "" ;
      AV28TFLiqOblPeriodo = GXutil.nullDate() ;
      AV29TFLiqOblPeriodo_To = GXutil.nullDate() ;
      AV33TFLiqOblSaldo = DecimalUtil.ZERO ;
      AV34TFLiqOblSaldo_To = DecimalUtil.ZERO ;
      AV35TFLiqOblCuota = DecimalUtil.ZERO ;
      AV36TFLiqOblCuota_To = DecimalUtil.ZERO ;
      AV37TFLiqOblTotal = DecimalUtil.ZERO ;
      AV38TFLiqOblTotal_To = DecimalUtil.ZERO ;
      AV39TFLiqOblTotRecal = DecimalUtil.ZERO ;
      AV40TFLiqOblTotRecal_To = DecimalUtil.ZERO ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV45GridAppliedFilters = "" ;
      AV41DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV30DDO_LiqOblPeriodoAuxDate = GXutil.nullDate() ;
      AV31DDO_LiqOblPeriodoAuxDateTo = GXutil.nullDate() ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      AV32DDO_LiqOblPeriodoAuxDateText = "" ;
      ucTfliqoblperiodo_rangepicker = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A1187LiqOblLog = "" ;
      A1199LiqOblPeriodo = GXutil.nullDate() ;
      A1197LiqOblSaldo = DecimalUtil.ZERO ;
      A1188LiqOblCuota = DecimalUtil.ZERO ;
      A1189LiqOblTotal = DecimalUtil.ZERO ;
      A1190LiqOblTotRecal = DecimalUtil.ZERO ;
      AV47VerSVG = "" ;
      AV48Display = "" ;
      scmdbuf = "" ;
      AV75Obligacionesds_8_tfliqoblperiodo = GXutil.nullDate() ;
      AV76Obligacionesds_9_tfliqoblperiodo_to = GXutil.nullDate() ;
      AV77Obligacionesds_10_tfliqoblsaldo = DecimalUtil.ZERO ;
      AV78Obligacionesds_11_tfliqoblsaldo_to = DecimalUtil.ZERO ;
      AV79Obligacionesds_12_tfliqoblcuota = DecimalUtil.ZERO ;
      AV80Obligacionesds_13_tfliqoblcuota_to = DecimalUtil.ZERO ;
      AV81Obligacionesds_14_tfliqobltotal = DecimalUtil.ZERO ;
      AV82Obligacionesds_15_tfliqobltotal_to = DecimalUtil.ZERO ;
      AV83Obligacionesds_16_tfliqobltotrecal = DecimalUtil.ZERO ;
      AV84Obligacionesds_17_tfliqobltotrecal_to = DecimalUtil.ZERO ;
      H00DQ2_A1190LiqOblTotRecal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00DQ2_A1189LiqOblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00DQ2_A1188LiqOblCuota = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00DQ2_A1197LiqOblSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00DQ2_A1199LiqOblPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      H00DQ2_A1187LiqOblLog = new String[] {""} ;
      H00DQ2_A1186LiqOblPrimera = new boolean[] {false} ;
      H00DQ2_A1185LiqOblNuevaNro = new int[1] ;
      H00DQ2_A1184LiqOblAltaNro = new int[1] ;
      H00DQ2_A1172OblSecuencial = new short[1] ;
      H00DQ2_A6LegNumero = new int[1] ;
      H00DQ2_A1EmpCod = new short[1] ;
      H00DQ2_A3CliCod = new int[1] ;
      H00DQ3_AGRID_nRecordCount = new long[1] ;
      AV58WelcomeMessage_Foto = "" ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV53MenuBienveImgURL = "" ;
      GXv_char3 = new String[1] ;
      AV55MenuBienveTitulo = "" ;
      AV56MenuBienveTexto = "" ;
      AV66Welcomemessage_foto_GXI = "" ;
      GXt_char7 = "" ;
      GXv_char4 = new String[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext9 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV63MenuOpcTitulo = "" ;
      GXt_char8 = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV23Session = httpContext.getWebSession();
      AV14GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV15GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXv_SdtWWPGridState11 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV13TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV21ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector12 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV54textoNoMostrara = "" ;
      GXv_char5 = new String[1] ;
      GXv_boolean6 = new boolean[1] ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      sImgUrl = "" ;
      lblWelcomemessage_combotext_Jsonclick = "" ;
      lblTotaltext_Jsonclick = "" ;
      lblCouttext_Jsonclick = "" ;
      lblWelcomemessage_descripcion_Jsonclick = "" ;
      lblWelcomemessage_titulo_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV50MenuOpcCod = "" ;
      sCtrlAV8CliCod = "" ;
      sCtrlAV9EmpCod = "" ;
      sCtrlAV10LegNumero = "" ;
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obligaciones__default(),
         new Object[] {
             new Object[] {
            H00DQ2_A1190LiqOblTotRecal, H00DQ2_A1189LiqOblTotal, H00DQ2_A1188LiqOblCuota, H00DQ2_A1197LiqOblSaldo, H00DQ2_A1199LiqOblPeriodo, H00DQ2_A1187LiqOblLog, H00DQ2_A1186LiqOblPrimera, H00DQ2_A1185LiqOblNuevaNro, H00DQ2_A1184LiqOblAltaNro, H00DQ2_A1172OblSecuencial,
            H00DQ2_A6LegNumero, H00DQ2_A1EmpCod, H00DQ2_A3CliCod
            }
            , new Object[] {
            H00DQ3_AGRID_nRecordCount
            }
         }
      );
      AV67Pgmname = "obligaciones" ;
      /* GeneXus formulas. */
      AV67Pgmname = "obligaciones" ;
      Gx_err = (short)(0) ;
      edtavVersvg_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
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
   private short wcpOAV9EmpCod ;
   private short AV9EmpCod ;
   private short AV16OrderedBy ;
   private short AV69Obligacionesds_2_empcod ;
   private short wbEnd ;
   private short wbStart ;
   private short A1EmpCod ;
   private short A1172OblSecuencial ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short edtavVersvg_Format ;
   private int wcpOAV8CliCod ;
   private int wcpOAV10LegNumero ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_67 ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int nGXsfl_67_idx=1 ;
   private int AV24TFLiqOblAltaNro ;
   private int AV25TFLiqOblAltaNro_To ;
   private int AV26TFLiqOblNuevaNro ;
   private int AV27TFLiqOblNuevaNro_To ;
   private int AV68Obligacionesds_1_clicod ;
   private int AV70Obligacionesds_3_legnumero ;
   private int Gridpaginationbar_Pagestoshow ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A1184LiqOblAltaNro ;
   private int A1185LiqOblNuevaNro ;
   private int subGrid_Islastpage ;
   private int edtavVersvg_Enabled ;
   private int edtavDisplay_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV71Obligacionesds_4_tfliqoblaltanro ;
   private int AV72Obligacionesds_5_tfliqoblaltanro_to ;
   private int AV73Obligacionesds_6_tfliqoblnuevanro ;
   private int AV74Obligacionesds_7_tfliqoblnuevanro_to ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int lblCouttext_Visible ;
   private int AV42PageToGo ;
   private int edtavDisplay_Visible ;
   private int AV85GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV43GridCurrentPage ;
   private long AV44GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV33TFLiqOblSaldo ;
   private java.math.BigDecimal AV34TFLiqOblSaldo_To ;
   private java.math.BigDecimal AV35TFLiqOblCuota ;
   private java.math.BigDecimal AV36TFLiqOblCuota_To ;
   private java.math.BigDecimal AV37TFLiqOblTotal ;
   private java.math.BigDecimal AV38TFLiqOblTotal_To ;
   private java.math.BigDecimal AV39TFLiqOblTotRecal ;
   private java.math.BigDecimal AV40TFLiqOblTotRecal_To ;
   private java.math.BigDecimal A1197LiqOblSaldo ;
   private java.math.BigDecimal A1188LiqOblCuota ;
   private java.math.BigDecimal A1189LiqOblTotal ;
   private java.math.BigDecimal A1190LiqOblTotRecal ;
   private java.math.BigDecimal AV77Obligacionesds_10_tfliqoblsaldo ;
   private java.math.BigDecimal AV78Obligacionesds_11_tfliqoblsaldo_to ;
   private java.math.BigDecimal AV79Obligacionesds_12_tfliqoblcuota ;
   private java.math.BigDecimal AV80Obligacionesds_13_tfliqoblcuota_to ;
   private java.math.BigDecimal AV81Obligacionesds_14_tfliqobltotal ;
   private java.math.BigDecimal AV82Obligacionesds_15_tfliqobltotal_to ;
   private java.math.BigDecimal AV83Obligacionesds_16_tfliqobltotrecal ;
   private java.math.BigDecimal AV84Obligacionesds_17_tfliqobltotrecal_to ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Filteredtextto_get ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_67_idx="0001" ;
   private String AV67Pgmname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
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
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Sortedstatus ;
   private String Ddo_grid_Includefilter ;
   private String Ddo_grid_Filtertype ;
   private String Ddo_grid_Filterisrange ;
   private String Ddo_grid_Format ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String divDdo_liqoblperiodoauxdates_Internalname ;
   private String TempTags ;
   private String edtavDdo_liqoblperiodoauxdatetext_Internalname ;
   private String edtavDdo_liqoblperiodoauxdatetext_Jsonclick ;
   private String Tfliqoblperiodo_rangepicker_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtCliCod_Internalname ;
   private String edtEmpCod_Internalname ;
   private String edtLegNumero_Internalname ;
   private String edtOblSecuencial_Internalname ;
   private String edtLiqOblAltaNro_Internalname ;
   private String edtLiqOblNuevaNro_Internalname ;
   private String edtLiqOblLog_Internalname ;
   private String edtLiqOblPeriodo_Internalname ;
   private String edtLiqOblSaldo_Internalname ;
   private String edtLiqOblCuota_Internalname ;
   private String edtLiqOblTotal_Internalname ;
   private String edtLiqOblTotRecal_Internalname ;
   private String AV47VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV48Display ;
   private String edtavDisplay_Internalname ;
   private String scmdbuf ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String GXv_char3[] ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String GXt_char7 ;
   private String GXv_char4[] ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String lblCouttext_Internalname ;
   private String lblCouttext_Caption ;
   private String edtavDisplay_Link ;
   private String GXt_char8 ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String GXv_char5[] ;
   private String lblWelcomemessage_combotext_Caption ;
   private String lblWelcomemessage_combotext_Internalname ;
   private String tblTablemainfix_Internalname ;
   private String tblTablepadding_Internalname ;
   private String divWelcomemessage_welcometableprincipal_Internalname ;
   private String divWelcomemessage_tableclose_Internalname ;
   private String lblWelcomemessage_closehelp_Jsonclick ;
   private String divWelcomemessage_welcomecontentitem_Internalname ;
   private String divWelcomemessage_welcomecontentflex_Internalname ;
   private String divWelcomemessage_welcometableimagen_Internalname ;
   private String imgavWelcomemessage_foto_gximage ;
   private String sImgUrl ;
   private String divWelcomemessage_tabletexto_Internalname ;
   private String divWelcomemessage_welcomebottomitem_Internalname ;
   private String divWelcomemessage_tablecmb_Internalname ;
   private String divWelcomemessage_tablec_Internalname ;
   private String divWelcomemessage_tabletext_Internalname ;
   private String lblWelcomemessage_combotext_Jsonclick ;
   private String divTablefiltrospadre_Internalname ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String tblTabletotalregistros_Internalname ;
   private String divTabletotal_Internalname ;
   private String lblTotaltext_Internalname ;
   private String lblTotaltext_Jsonclick ;
   private String lblCouttext_Jsonclick ;
   private String tblWelcomemessage_tabledescripcion_Internalname ;
   private String lblWelcomemessage_descripcion_Jsonclick ;
   private String tblWelcomemessage_tabletitulo_Internalname ;
   private String lblWelcomemessage_titulo_Jsonclick ;
   private String sCtrlAV50MenuOpcCod ;
   private String sCtrlAV8CliCod ;
   private String sCtrlAV9EmpCod ;
   private String sCtrlAV10LegNumero ;
   private String sGXsfl_67_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Jsonclick ;
   private String edtLegNumero_Jsonclick ;
   private String edtOblSecuencial_Jsonclick ;
   private String edtLiqOblAltaNro_Jsonclick ;
   private String edtLiqOblNuevaNro_Jsonclick ;
   private String GXCCtl ;
   private String edtLiqOblLog_Jsonclick ;
   private String edtLiqOblPeriodo_Jsonclick ;
   private String edtLiqOblSaldo_Jsonclick ;
   private String edtLiqOblCuota_Jsonclick ;
   private String edtLiqOblTotal_Jsonclick ;
   private String edtLiqOblTotRecal_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date AV28TFLiqOblPeriodo ;
   private java.util.Date AV29TFLiqOblPeriodo_To ;
   private java.util.Date AV30DDO_LiqOblPeriodoAuxDate ;
   private java.util.Date AV31DDO_LiqOblPeriodoAuxDateTo ;
   private java.util.Date A1199LiqOblPeriodo ;
   private java.util.Date AV75Obligacionesds_8_tfliqoblperiodo ;
   private java.util.Date AV76Obligacionesds_9_tfliqoblperiodo_to ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV17OrderedDsc ;
   private boolean AV49IsAuthorized_Display ;
   private boolean AV52WelcomeMessage_NoMostrarMas ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean A1186LiqOblPrimera ;
   private boolean bGXsfl_67_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV57MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean GXt_boolean10 ;
   private boolean GXv_boolean6[] ;
   private boolean AV58WelcomeMessage_Foto_IsBlob ;
   private String AV56MenuBienveTexto ;
   private String AV54textoNoMostrara ;
   private String wcpOAV50MenuOpcCod ;
   private String AV50MenuOpcCod ;
   private String AV45GridAppliedFilters ;
   private String AV32DDO_LiqOblPeriodoAuxDateText ;
   private String A1187LiqOblLog ;
   private String AV53MenuBienveImgURL ;
   private String AV55MenuBienveTitulo ;
   private String AV66Welcomemessage_foto_GXI ;
   private String AV63MenuOpcTitulo ;
   private String AV58WelcomeMessage_Foto ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucTfliqoblperiodo_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private ICheckbox chkLiqOblPrimera ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] H00DQ2_A1190LiqOblTotRecal ;
   private java.math.BigDecimal[] H00DQ2_A1189LiqOblTotal ;
   private java.math.BigDecimal[] H00DQ2_A1188LiqOblCuota ;
   private java.math.BigDecimal[] H00DQ2_A1197LiqOblSaldo ;
   private java.util.Date[] H00DQ2_A1199LiqOblPeriodo ;
   private String[] H00DQ2_A1187LiqOblLog ;
   private boolean[] H00DQ2_A1186LiqOblPrimera ;
   private int[] H00DQ2_A1185LiqOblNuevaNro ;
   private int[] H00DQ2_A1184LiqOblAltaNro ;
   private short[] H00DQ2_A1172OblSecuencial ;
   private int[] H00DQ2_A6LegNumero ;
   private short[] H00DQ2_A1EmpCod ;
   private int[] H00DQ2_A3CliCod ;
   private long[] H00DQ3_AGRID_nRecordCount ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext9[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPGridState AV14GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState11[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV15GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector12[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV41DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class obligaciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00DQ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV71Obligacionesds_4_tfliqoblaltanro ,
                                          int AV72Obligacionesds_5_tfliqoblaltanro_to ,
                                          int AV73Obligacionesds_6_tfliqoblnuevanro ,
                                          int AV74Obligacionesds_7_tfliqoblnuevanro_to ,
                                          java.util.Date AV75Obligacionesds_8_tfliqoblperiodo ,
                                          java.util.Date AV76Obligacionesds_9_tfliqoblperiodo_to ,
                                          java.math.BigDecimal AV77Obligacionesds_10_tfliqoblsaldo ,
                                          java.math.BigDecimal AV78Obligacionesds_11_tfliqoblsaldo_to ,
                                          java.math.BigDecimal AV79Obligacionesds_12_tfliqoblcuota ,
                                          java.math.BigDecimal AV80Obligacionesds_13_tfliqoblcuota_to ,
                                          java.math.BigDecimal AV81Obligacionesds_14_tfliqobltotal ,
                                          java.math.BigDecimal AV82Obligacionesds_15_tfliqobltotal_to ,
                                          java.math.BigDecimal AV83Obligacionesds_16_tfliqobltotrecal ,
                                          java.math.BigDecimal AV84Obligacionesds_17_tfliqobltotrecal_to ,
                                          int A1184LiqOblAltaNro ,
                                          int A1185LiqOblNuevaNro ,
                                          java.util.Date A1199LiqOblPeriodo ,
                                          java.math.BigDecimal A1197LiqOblSaldo ,
                                          java.math.BigDecimal A1188LiqOblCuota ,
                                          java.math.BigDecimal A1189LiqOblTotal ,
                                          java.math.BigDecimal A1190LiqOblTotRecal ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc ,
                                          int AV68Obligacionesds_1_clicod ,
                                          short AV69Obligacionesds_2_empcod ,
                                          int AV70Obligacionesds_3_legnumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[20];
      Object[] GXv_Object14 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " LiqOblTotRecal, LiqOblTotal, LiqOblCuota, LiqOblSaldo, LiqOblPeriodo, LiqOblLog, LiqOblPrimera, LiqOblNuevaNro, LiqOblAltaNro, OblSecuencial, LegNumero, EmpCod," ;
      sSelectString += " CliCod" ;
      sFromString = " FROM LiqLegObligacionCuenta" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      if ( ! (0==AV71Obligacionesds_4_tfliqoblaltanro) )
      {
         addWhere(sWhereString, "(LiqOblAltaNro >= ?)");
      }
      else
      {
         GXv_int13[3] = (byte)(1) ;
      }
      if ( ! (0==AV72Obligacionesds_5_tfliqoblaltanro_to) )
      {
         addWhere(sWhereString, "(LiqOblAltaNro <= ?)");
      }
      else
      {
         GXv_int13[4] = (byte)(1) ;
      }
      if ( ! (0==AV73Obligacionesds_6_tfliqoblnuevanro) )
      {
         addWhere(sWhereString, "(LiqOblNuevaNro >= ?)");
      }
      else
      {
         GXv_int13[5] = (byte)(1) ;
      }
      if ( ! (0==AV74Obligacionesds_7_tfliqoblnuevanro_to) )
      {
         addWhere(sWhereString, "(LiqOblNuevaNro <= ?)");
      }
      else
      {
         GXv_int13[6] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV75Obligacionesds_8_tfliqoblperiodo)) )
      {
         addWhere(sWhereString, "(LiqOblPeriodo >= ?)");
      }
      else
      {
         GXv_int13[7] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV76Obligacionesds_9_tfliqoblperiodo_to)) )
      {
         addWhere(sWhereString, "(LiqOblPeriodo <= ?)");
      }
      else
      {
         GXv_int13[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV77Obligacionesds_10_tfliqoblsaldo)==0) )
      {
         addWhere(sWhereString, "(LiqOblSaldo >= ?)");
      }
      else
      {
         GXv_int13[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV78Obligacionesds_11_tfliqoblsaldo_to)==0) )
      {
         addWhere(sWhereString, "(LiqOblSaldo <= ?)");
      }
      else
      {
         GXv_int13[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Obligacionesds_12_tfliqoblcuota)==0) )
      {
         addWhere(sWhereString, "(LiqOblCuota >= ?)");
      }
      else
      {
         GXv_int13[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80Obligacionesds_13_tfliqoblcuota_to)==0) )
      {
         addWhere(sWhereString, "(LiqOblCuota <= ?)");
      }
      else
      {
         GXv_int13[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV81Obligacionesds_14_tfliqobltotal)==0) )
      {
         addWhere(sWhereString, "(LiqOblTotal >= ?)");
      }
      else
      {
         GXv_int13[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV82Obligacionesds_15_tfliqobltotal_to)==0) )
      {
         addWhere(sWhereString, "(LiqOblTotal <= ?)");
      }
      else
      {
         GXv_int13[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV83Obligacionesds_16_tfliqobltotrecal)==0) )
      {
         addWhere(sWhereString, "(LiqOblTotRecal >= ?)");
      }
      else
      {
         GXv_int13[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV84Obligacionesds_17_tfliqobltotrecal_to)==0) )
      {
         addWhere(sWhereString, "(LiqOblTotRecal <= ?)");
      }
      else
      {
         GXv_int13[16] = (byte)(1) ;
      }
      if ( ( AV16OrderedBy == 1 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, LiqOblAltaNro, OblSecuencial, LiqOblNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 1 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LiqOblAltaNro DESC, OblSecuencial, LiqOblNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, LiqOblNuevaNro, OblSecuencial, LiqOblAltaNro" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LiqOblNuevaNro DESC, OblSecuencial, LiqOblAltaNro" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, LiqOblPeriodo, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LiqOblPeriodo DESC, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, LiqOblSaldo, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LiqOblSaldo DESC, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, LiqOblCuota, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LiqOblCuota DESC, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 6 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, LiqOblTotal, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 6 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LiqOblTotal DESC, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 7 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, LiqOblTotRecal, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 7 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LiqOblTotRecal DESC, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
   }

   protected Object[] conditional_H00DQ3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV71Obligacionesds_4_tfliqoblaltanro ,
                                          int AV72Obligacionesds_5_tfliqoblaltanro_to ,
                                          int AV73Obligacionesds_6_tfliqoblnuevanro ,
                                          int AV74Obligacionesds_7_tfliqoblnuevanro_to ,
                                          java.util.Date AV75Obligacionesds_8_tfliqoblperiodo ,
                                          java.util.Date AV76Obligacionesds_9_tfliqoblperiodo_to ,
                                          java.math.BigDecimal AV77Obligacionesds_10_tfliqoblsaldo ,
                                          java.math.BigDecimal AV78Obligacionesds_11_tfliqoblsaldo_to ,
                                          java.math.BigDecimal AV79Obligacionesds_12_tfliqoblcuota ,
                                          java.math.BigDecimal AV80Obligacionesds_13_tfliqoblcuota_to ,
                                          java.math.BigDecimal AV81Obligacionesds_14_tfliqobltotal ,
                                          java.math.BigDecimal AV82Obligacionesds_15_tfliqobltotal_to ,
                                          java.math.BigDecimal AV83Obligacionesds_16_tfliqobltotrecal ,
                                          java.math.BigDecimal AV84Obligacionesds_17_tfliqobltotrecal_to ,
                                          int A1184LiqOblAltaNro ,
                                          int A1185LiqOblNuevaNro ,
                                          java.util.Date A1199LiqOblPeriodo ,
                                          java.math.BigDecimal A1197LiqOblSaldo ,
                                          java.math.BigDecimal A1188LiqOblCuota ,
                                          java.math.BigDecimal A1189LiqOblTotal ,
                                          java.math.BigDecimal A1190LiqOblTotRecal ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc ,
                                          int AV68Obligacionesds_1_clicod ,
                                          short AV69Obligacionesds_2_empcod ,
                                          int AV70Obligacionesds_3_legnumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int15 = new byte[17];
      Object[] GXv_Object16 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM LiqLegObligacionCuenta" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      if ( ! (0==AV71Obligacionesds_4_tfliqoblaltanro) )
      {
         addWhere(sWhereString, "(LiqOblAltaNro >= ?)");
      }
      else
      {
         GXv_int15[3] = (byte)(1) ;
      }
      if ( ! (0==AV72Obligacionesds_5_tfliqoblaltanro_to) )
      {
         addWhere(sWhereString, "(LiqOblAltaNro <= ?)");
      }
      else
      {
         GXv_int15[4] = (byte)(1) ;
      }
      if ( ! (0==AV73Obligacionesds_6_tfliqoblnuevanro) )
      {
         addWhere(sWhereString, "(LiqOblNuevaNro >= ?)");
      }
      else
      {
         GXv_int15[5] = (byte)(1) ;
      }
      if ( ! (0==AV74Obligacionesds_7_tfliqoblnuevanro_to) )
      {
         addWhere(sWhereString, "(LiqOblNuevaNro <= ?)");
      }
      else
      {
         GXv_int15[6] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV75Obligacionesds_8_tfliqoblperiodo)) )
      {
         addWhere(sWhereString, "(LiqOblPeriodo >= ?)");
      }
      else
      {
         GXv_int15[7] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV76Obligacionesds_9_tfliqoblperiodo_to)) )
      {
         addWhere(sWhereString, "(LiqOblPeriodo <= ?)");
      }
      else
      {
         GXv_int15[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV77Obligacionesds_10_tfliqoblsaldo)==0) )
      {
         addWhere(sWhereString, "(LiqOblSaldo >= ?)");
      }
      else
      {
         GXv_int15[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV78Obligacionesds_11_tfliqoblsaldo_to)==0) )
      {
         addWhere(sWhereString, "(LiqOblSaldo <= ?)");
      }
      else
      {
         GXv_int15[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Obligacionesds_12_tfliqoblcuota)==0) )
      {
         addWhere(sWhereString, "(LiqOblCuota >= ?)");
      }
      else
      {
         GXv_int15[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80Obligacionesds_13_tfliqoblcuota_to)==0) )
      {
         addWhere(sWhereString, "(LiqOblCuota <= ?)");
      }
      else
      {
         GXv_int15[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV81Obligacionesds_14_tfliqobltotal)==0) )
      {
         addWhere(sWhereString, "(LiqOblTotal >= ?)");
      }
      else
      {
         GXv_int15[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV82Obligacionesds_15_tfliqobltotal_to)==0) )
      {
         addWhere(sWhereString, "(LiqOblTotal <= ?)");
      }
      else
      {
         GXv_int15[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV83Obligacionesds_16_tfliqobltotrecal)==0) )
      {
         addWhere(sWhereString, "(LiqOblTotRecal >= ?)");
      }
      else
      {
         GXv_int15[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV84Obligacionesds_17_tfliqobltotrecal_to)==0) )
      {
         addWhere(sWhereString, "(LiqOblTotRecal <= ?)");
      }
      else
      {
         GXv_int15[16] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV16OrderedBy == 1 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 1 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 6 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 6 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 7 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 7 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object16[0] = scmdbuf ;
      GXv_Object16[1] = GXv_int15 ;
      return GXv_Object16 ;
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
                  return conditional_H00DQ2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , (java.util.Date)dynConstraints[4] , (java.util.Date)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Boolean) dynConstraints[22]).booleanValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).shortValue() , ((Number) dynConstraints[28]).intValue() );
            case 1 :
                  return conditional_H00DQ3(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , (java.util.Date)dynConstraints[4] , (java.util.Date)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() , (java.util.Date)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Boolean) dynConstraints[22]).booleanValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).shortValue() , ((Number) dynConstraints[28]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00DQ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00DQ3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
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
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
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
                  stmt.setInt(sIdx, ((Number) parms[25]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[26]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[27]);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[28]);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[31], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[32], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[33], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[34], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[35], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[37]).intValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[38]).intValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[39]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[17]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[18]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[24]);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[25]);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[27], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[31], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[32], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[33], 2);
               }
               return;
      }
   }

}

